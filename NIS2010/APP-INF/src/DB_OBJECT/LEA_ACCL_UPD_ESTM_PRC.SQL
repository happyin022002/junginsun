CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACCL_UPD_ESTM_PRC (exe_yrmon_in IN VARCHAR, bat_id_in IN VARCHAR) 
IS 
/******************************************************************************* 
  1.Object Name     : LEA_ACCL_UPD_ESTM_PRC
  2.Version         : 1.0
  3.Create Date     : 2007-03-02
  4.Sub System      : Logistics Expense Accrual
  5.Author          : 전재홍
  6.Description     : Estimation(From COA) 정보 생성
  7.Revision History 
    2007-03-02 : - 김상모 최초생성. 
    2008-03-06 : - EDW 요청으로 ctrl_ofc_cd 컬럼 추가(LEA_ESTM_COST_IF, LEA_ACCL_DTL) 
                   CTRL_OFC_CD 변경값 적용되게 로직 추가 
    2008-03-10 : - 결산기간을 2월 수행년월 부터 2008.01월 반영(HardCoding) : '200710'->'200801'       
    2008-03-25 : - VVD Type is 'BV','RV' and Booking Status is 'F', 'W' => Mapping/Allocate is 'Y' 
                   VVD Type is 'PV'      and Booking Status is 'F', 'W' => Mapping/Allocate is 'N'   
    2008-04-04 : - 전재홍 - Accrual 로직 추가 변경에 따라 Throupht Cost Flag 관련 로직 제거 
                   THRP_RT_FLG = Y 인경우에도 매핑 배부 
    2008-04-23 : - PV Booking 에 대한 처리시 rev_month 조건 및 index 추가 
    2008-04-30 : - Actual Container 금액이 존재하지 않는 Basic Cost Code 만 
                   Invoice Count초기화 처리 
    2008-05-23 : - PV인 경우에도 배부 적용.(매핑인경우에는 rev.month 를 비교하게됨)  
                 - PV BOOKING 에 대한 매핑 배부 FLG 처리 하지 않음. 
    2008-05-27 : - Actual Cost 이관시 금액뿐만 아니라 inv_knt 도 update 되어야  
                   Accrual Cost 가 계산될수 있음.   
    2008-10-01 : - 마지막 10000 건 이하인 경우 Commit 누락 방지 
    2009-01-08 : - Trade, Lane 정보 추가 
    2009-01-21 : - Exe.Yrmon가 1,2,3 월일경우 Rev.Month 는 전년도 각각 10,11,12 월부터
                   포함하도록 로직으로 반영  
    2009-03-02 : - 대상항차중 전년도 대상 포함하도록 변경 
    2009-06-16 : - 로그 건수 1만에서 10만건으로 조정 
    2009-06-24 : - EST UPDATE 시 INVOICE COUNT  초기화는 ACT_CNTR_COST_AMT=0 -> ACT_INV_KNT=0 기준으로 변경 
    2009-09-23 : - ACCL_COST_AMT 업데이트 시 Basic Cost(ACCL_LGC_TP_CD IN (NB, LB)) 에 대해서는 Invoice Count
                   및 ACT_COST-AMT 를 참조하고, Other Cost 에 대해서는 Update 하지 않음.   
    2009-11-03 : - ESTM UPDATE 시에 CTRL_OFC_CD 는 UPDATE 하지 않음.  
                 - ESTM UPDATE 시에 Other Cost(NO,LO) 는  
                   1) Update 되는 ESTM 금액이 = 0 인 경우, Accrual 금액 = 0
                   2) Update 되는 ESTM 금액이 <> 0 인 경우, Accrual 금액 update 하지 않음
    2010-03-23 : - ESTM UPDATE 시에 CTRL_OFC_CD 는 UPDATE 로 변경(20091103 이전으로 롤백)
    2010-04-16 : - bkg_no_split 칼럼 제거
  
*******************************************************************************/ 
   /* Variable Declare --------------------------------------------------------*/ 
   v_bat_his_rec   lea_bat_pkg.bat_his_rec;   --Batch Hostory Record 
   v_rtn_val       VARCHAR2 (1);       
   v_cur_idx       NUMBER := 0; 
    
   v_act_cost_amt  NUMBER := 0; 
    
   /*---------------------------------------------------------------------------------- 
         Booking  Container  Status  Update  Target  Split  Combine Booking 
       -------------------------------------------------------------------------------- 
         BKG9+""  CNTR9      F        Y        Y     Null    Null    <- 일반속성 Update 
         BKG0+""  CNTR0      X        Y        Y     Null    Null    <- 자체 Cancel 
         BKG1+""  CNTR1      X        Y        Y     M(Y)    Null    <- 화주요청 Split 
         BKG1+A1  CNTR1      F        Y        N     Null    Null 
         BKG2+""  CNTR2      S        Y        Y     C       Null    <- 선사요청 Split 
         BKG2+R1  CNTR2      F        Y        N     Null    Null 
         BKG3+""  CNTR5      X        Y        Y     Null    BKG4+"" <- Combine 
         BKG4+""  CNTR5      F        Y        N     Null    Null 
   ------------------------------------------------------------------------------------*/    
                   
   /* Cursor Declare ------------------------------------------------------------*/ 
   CURSOR upd_estm_cost_if_cur 
   IS 
      SELECT /*+ parallel(i, 8) leading(c) */ 
             i.bkg_no, i.cntr_no, i.cost_act_grp_seq, i.coa_cost_src_cd, i.cost_act_grp_cd, 
             i.cntr_tpsz_cd, i.cntr_qty, i.cost_src_sys_cd, 
             i.pln_cost_amt, i.estm_cost_amt, --i.act_cost_amt, i.accl_cost_amt, 
             i.n1st_nod_cd, i.n2nd_nod_cd, i.n3rd_nod_cd, i.n4th_nod_cd, 
             i.n1st_vndr_seq, i.n2nd_vndr_seq, i.n3rd_vndr_seq, i.n4th_vndr_seq, 
             DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'CFDR', i.vsl_cd) vsl_cd, 
             DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', SUBSTR (i.vsl_cd || i.skd_voy_no , 3, 4), i.skd_voy_no) skd_voy_no, 
             DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'E', i.skd_dir_cd) skd_dir_cd, 
             DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'E', i.rev_dir_cd) rev_dir_cd, 
             v.last_estm_vvd_tp_cd estm_vvd_tp_cd, 
             --DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'XX', i.estm_ioc_div_cd) estm_ioc_div_cd, 
             i.estm_ioc_div_cd, 
             c.acct_cd, i.bkg_sts_cd, i.bkg_split_cd, i.cmb_bkg_no,   
             i.thrp_rt_flg,  i.estm_upd_flg, i.estm_tgt_flg,  i.cost_rout_no, i.cost_ass_bse_cd, ctrt_rtn_flg, 
             v.rev_yrmon, i.delt_flg, 
             DECODE(SUBSTR(c.accl_lgc_tp_cd, 2, 1), 'B', 1, NULL) ttl_inv_knt,  --Basic Cost면 Total Invoice Counter를 Default로 1로 셋팅처리 
             DECODE(SUBSTR(c.accl_lgc_tp_cd, 2, 1), 'B', 0, NULL) act_inv_knt,  
             c.accl_lgc_tp_cd, 
             CASE 
                --WHEN v.last_estm_vvd_tp_cd = 'PV' THEN 'N' 
                --R.VVD Type이 PV(진행항차)이면 Mapping/Alloc 처리대상 아님 
                --WHEN i.thrp_rt_flg = 'Y' THEN 'N'                       
                --Booking Status Code is 'A', 'X', 'S' => 'N' 
                WHEN i.bkg_sts_cd = 'A' OR i.bkg_sts_cd = 'X'  OR i.bkg_sts_cd = 'S' THEN 'N' 
                --Dispatch CNTR에 대해서는 Mapping,Allocate 처리대상 아님 
                WHEN i.delt_flg = 'Y' THEN 'N' 
                --배부 시에도 NOBC와 NIBC에 대해서는 TMNDFL, TMFDFL Cost를 배부받지 않도록 Hard coding 필요 
                WHEN (i.cost_act_grp_cd = 'NOBC' OR i.cost_act_grp_cd = 'NIBC') 
                   AND 
                     (i.coa_cost_src_cd = 'TMNDFL' OR i.coa_cost_src_cd = 'TMFDFL') THEN 'N' 
                ELSE 'Y' --'RV', 'BV' and Booking Status Code is 'F', 'W' => Mapping Allocate is 'Y(es)' 
             END mapg_aloc_flg, 
             i.n1st_vvd_cd, 
             i.n2nd_vvd_cd, 
             i.upd_bat_st_dt, 
             i.ctrl_ofc_cd, 
             i.trd_cd, 
             i.rlane_cd 
        FROM lea_estm_cost_if i,  
             lea_lgs_cost c, 
             (  --수행년월별로 Revenue YearMonth, R.VVD, IOC 별로 R.VVD Type 변화를 가지면서 반복되어 들어옴 
                --최근 수행년월의 R.VVD 하나만 가져와야 됨 
                SELECT rev_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, 
                       SUBSTR(MAX(exe_yrmon||estm_vvd_tp_cd), 7, 2) last_estm_vvd_tp_cd, 
                       estm_ioc_div_cd,estm_vvd_hdr_id 
                FROM   gl_estm_rev_vvd 
                WHERE  estm_bc_div_cd = 'C'  --By Container 
--                  AND  exe_yrmon      = exe_yrmon_in --R.VVD가 수행년월별(EXE_YRMON)로 누적되어야 됨!!! 
                  AND  exe_yrmon  in ( exe_yrmon_in , TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in,'yyyymm') ,-12 ), 'yyyy') || '12')  
                  AND  rev_yrmon BETWEEN CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03') 
                                                THEN to_char(add_months(to_date(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm')  
                                              ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01' 
                                         END 
                                 AND TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -1), 'yyyymm')  
--                  AND  rev_yrmon BETWEEN '200801' AND TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -1), 'yyyymm')    
                GROUP BY rev_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, estm_ioc_div_cd, estm_vvd_hdr_id 
             ) v 
       WHERE 1=1               --RBC Lane R.VVD:CFDRyymmEE, IOC:XX 
         AND v.vsl_cd          = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'CFDR', i.vsl_cd) 
         AND v.skd_voy_no      = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', SUBSTR (i.vsl_cd || i.skd_voy_no , 3, 4), i.skd_voy_no) --년월(2007.03) => 0703 
         AND v.skd_dir_cd      = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'E', i.skd_dir_cd) 
         AND v.rev_dir_cd      = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'E', i.rev_dir_cd)                                                        
         --AND v.estm_ioc_div_cd = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'XX', i.estm_ioc_div_cd)   --IOC 일치 
         AND v.estm_ioc_div_cd = i.estm_ioc_div_cd   --IOC 일치 
         AND c.coa_cost_src_cd = i.coa_cost_src_cd   --Cost Code 
         AND c.delt_flg        = 'N'                 --Delete Cost code 
         AND c.accl_auto_cd    = 'A'                 --Auto Accrual 만 COA에서 가져옴(Manual, Transfer 안가져옴)  
          
         AND ( 
                i.estm_upd_flg    = 'Y' 
                OR 
                i.upd_bat_st_dt       = exe_yrmon_in   --수행년월의 반복 배치 작업 대상 
             ) 
         AND ( 
                 ( 
                    i.bkg_sts_cd IN ('A', 'F', 'W') 
                 ) 
              OR  
              (  --Target='Y' 후 자체 Cancel('X') 
                    i.estm_tgt_flg = 'Y' AND i.bkg_sts_cd = 'X' AND i.bkg_split_cd IS NULL AND i.cmb_bkg_no IS NULL 
                 )                  
              OR (  --수행년월 기간 동안 Cancel처리된 Split,  
                     ( i.bkg_sts_cd = 'X' OR i.bkg_sts_cd = 'S' ) AND i.bkg_split_cd IS NOT NULL 
                 ) 
              OR (  --Combine Booking도 Actual Mapping을 위해 가져옴  
                    i.bkg_sts_cd = 'X' AND i.cmb_bkg_no IS NOT NULL 
                 )                  
             ) 
         ORDER BY bkg_sts_cd  --중요함(삭제 금지)!!! 반드시 F->X(S) 부터 처리되어야 이미 매핑배부된 금액이 보존됨     
         ;    
 
BEGIN 
   v_bat_his_rec.estm_upd_st_dt := SYSDATE;   --Update Estimate data insert start date 
    
   lea_log_prc ('lea_accl_upd_estm_prc() start.'); 
 
   FOR upd IN upd_estm_cost_if_cur 
   LOOP 
      v_act_cost_amt := 0; --Init...이관대상 Actual Cost 
      v_cur_idx := v_cur_idx + 1;  --Update Data Counter 
      /* Log... 
      lea_log_prc ('upd.idx: ' || v_cur_idx); 
      lea_log_prc ('upd.bkg_no: ' || upd.bkg_no); 
      lea_log_prc ('upd.bkg_split_cd: ' || upd.bkg_split_cd); 
      lea_log_prc ('upd.cntr_no: ' || upd.cntr_no); 
      lea_log_prc ('upd.cost_act_grp_seq: ' || upd.cost_act_grp_seq); 
      lea_log_prc ('upd.coa_cost_src_cd: ' || upd.coa_cost_src_cd); 
      lea_log_prc ('upd.cmb_bkg_no: ' || upd.cmb_bkg_no); 
      lea_log_prc ('upd.cmb_bkg_no_split: ' || upd.cmb_bkg_no_split); 
      lea_log_prc ('upd.bkg_sts_cd: ' || upd.bkg_sts_cd); 
      */ 
      IF upd.bkg_sts_cd = 'F' OR upd.bkg_sts_cd = 'A' THEN --Booking Status Code is 'F(irm)', 'A(dvanced)' 
         IF upd.estm_tgt_flg = 'Y' OR upd.upd_bat_st_dt = exe_yrmon_in THEN --Update Booking and Targeted 
 
            -- Firm Booking의 일반속성 Update 
            UPDATE /*+ index (lea_accl_dtl xpklea_accl_dtl) */ lea_accl_dtl 
               SET cost_act_grp_cd = upd.cost_act_grp_cd, 
                   cntr_tpsz_cd    = upd.cntr_tpsz_cd, 
                   cntr_qty        = upd.cntr_qty, 
                   cost_src_sys_cd = upd.cost_src_sys_cd, 
                   pln_cost_amt    = upd.pln_cost_amt, 
                   estm_cost_amt   = upd.estm_cost_amt, 
                   accl_cost_amt   = CASE WHEN upd.accl_lgc_tp_cd in ('NB','LB') AND 
                                               act_inv_knt >= DECODE(act_inv_knt, 0 , upd.ttl_inv_knt, ttl_inv_knt) 
                                                THEN 0
                                          WHEN upd.accl_lgc_tp_cd in ('NB','LB') AND 
                                               act_inv_knt < DECODE(act_inv_knt, 0 , upd.ttl_inv_knt, ttl_inv_knt) AND
                                               act_cost_amt <= 0
                                                THEN upd.estm_cost_amt
                                          WHEN upd.accl_lgc_tp_cd in ('NB','LB') AND 
                                               act_inv_knt < DECODE(act_inv_knt, 0 , upd.ttl_inv_knt, ttl_inv_knt) AND
                                               act_cost_amt > 0
                                                THEN accl_cost_amt
                                          WHEN upd.accl_lgc_tp_cd in ('NO','LO') AND 
                                               upd.estm_cost_amt = 0 
                                                THEN 0
                                          ELSE accl_cost_amt
                                     END ,
--                                            DECODE(act_cost_amt, 0, upd.estm_cost_amt, accl_cost_amt), 
                   n1st_nod_cd     = upd.n1st_nod_cd, 
                   n2nd_nod_cd     = upd.n2nd_nod_cd, 
                   n3rd_nod_cd     = upd.n3rd_nod_cd, 
                   n4th_nod_cd     = upd.n4th_nod_cd, 
                   n1st_vndr_seq   = upd.n1st_vndr_seq, 
                   n2nd_vndr_seq   = upd.n2nd_vndr_seq, 
                   n3rd_vndr_seq   = upd.n3rd_vndr_seq, 
                   n4th_vndr_seq   = upd.n4th_vndr_seq, 
                   vsl_cd          = upd.vsl_cd, 
                   skd_voy_no      = upd.skd_voy_no, 
                   skd_dir_cd      = upd.skd_dir_cd, 
                   rev_dir_cd      = upd.rev_dir_cd, 
                   estm_vvd_tp_cd  = upd.estm_vvd_tp_cd, 
                   estm_ioc_div_cd = upd.estm_ioc_div_cd, 
                   bkg_sts_cd      = upd.bkg_sts_cd, 
                   thrp_rt_flg     = upd.thrp_rt_flg, 
--                   act_inv_knt     = DECODE(act_inv_knt, 0 , upd.act_inv_knt, act_inv_knt), 
                   ttl_inv_knt     = DECODE(act_inv_knt, 0 , upd.ttl_inv_knt, ttl_inv_knt), 
                   accl_lgc_tp_cd  = upd.accl_lgc_tp_cd,                    
                   mapg_aloc_flg   = upd.mapg_aloc_flg, 
                   cost_rout_no    = upd.cost_rout_no, 
                   cost_ass_bse_cd = upd.cost_ass_bse_cd, 
                   ctrt_rtn_flg    = upd.ctrt_rtn_flg, 
                   delt_flg        = upd.delt_flg, 
                   upd_usr_id      = 'UPD_ESTM_U_0', 
                   upd_dt          = SYSDATE, 
                   n1st_vvd_cd     = upd.n1st_vvd_cd, 
                   n2nd_vvd_cd     = upd.n2nd_vvd_cd, 
                   ctrl_ofc_cd     = upd.ctrl_ofc_cd, 
                   trd_cd          = upd.trd_cd, 
                   rlane_cd        = upd.rlane_cd 
             WHERE rev_yrmon        = upd.rev_yrmon 
               AND bkg_no           = upd.bkg_no 
               AND cntr_no          = upd.cntr_no
               AND cost_act_grp_seq = upd.cost_act_grp_seq 
               AND coa_cost_src_cd  = upd.coa_cost_src_cd 
               ; 
                
            IF SQL%FOUND THEN 
               UPDATE lea_estm_cost_if 
               SET estm_upd_flg       = 'N', --'Y'->'N' 처리 
                   upd_bat_st_dt      = exe_yrmon_in 
               WHERE bkg_no           = upd.bkg_no 
               AND   cntr_no          = upd.cntr_no 
               AND   cost_act_grp_seq = upd.cost_act_grp_seq 
               AND   coa_cost_src_cd  = upd.coa_cost_src_cd 
                  ; 
                   
            ELSIF SQL%NOTFOUND THEN 
               INSERT INTO lea_accl_dtl 
                  (rev_yrmon, bkg_no, cost_act_grp_cd, cost_act_grp_seq, cntr_no, coa_cost_src_cd, 
                   cntr_tpsz_cd, cntr_qty, cost_src_sys_cd, pln_cost_amt, estm_cost_amt, accl_cost_amt,  
                   thrp_rt_flg, n1st_nod_cd, n2nd_nod_cd, n3rd_nod_cd, n4th_nod_cd, 
                   n1st_vndr_seq, n2nd_vndr_seq, n3rd_vndr_seq, n4th_vndr_seq, 
                   vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, estm_vvd_tp_cd, estm_ioc_div_cd, 
                   acct_cd, bkg_sts_cd, bkg_split_cd, cmb_bkg_no, 
                   mapg_aloc_flg, accl_calc_flg, act_inv_knt, ttl_inv_knt, cre_usr_id, cre_dt, upd_usr_id, upd_dt, 
                   cost_rout_no, cost_ass_bse_cd, ctrt_rtn_flg, delt_flg, accl_lgc_tp_cd, 
                   n1st_vvd_cd, n2nd_vvd_cd, ctrl_ofc_cd, trd_cd, rlane_cd) 
               VALUES 
                  (upd.rev_yrmon, upd.bkg_no, upd.cost_act_grp_cd, upd.cost_act_grp_seq, upd.cntr_no, upd.coa_cost_src_cd, 
                   upd.cntr_tpsz_cd, upd.cntr_qty, upd.cost_src_sys_cd, upd.pln_cost_amt, upd.estm_cost_amt, upd.estm_cost_amt, 
                   upd.thrp_rt_flg, upd.n1st_nod_cd, upd.n2nd_nod_cd, upd.n3rd_nod_cd, upd.n4th_nod_cd, 
                   upd.n1st_vndr_seq, upd.n2nd_vndr_seq, upd.n3rd_vndr_seq, upd.n4th_vndr_seq, 
                   upd.vsl_cd, upd.skd_voy_no, upd.skd_dir_cd, upd.rev_dir_cd, upd.estm_vvd_tp_cd, upd.estm_ioc_div_cd, 
                   upd.acct_cd, upd.bkg_sts_cd, upd.bkg_split_cd, upd.cmb_bkg_no, 
                   upd.mapg_aloc_flg, 'N', upd.act_inv_knt, upd.ttl_inv_knt, 'UPD_ESTM_UI', SYSDATE, 'UPD_ESTM_UI', SYSDATE, 
                   upd.cost_rout_no, upd.cost_ass_bse_cd, upd.ctrt_rtn_flg, upd.delt_flg, upd.accl_lgc_tp_cd, 
                   upd.n1st_vvd_cd, upd.n2nd_vvd_cd, upd.ctrl_ofc_cd, upd.trd_cd, upd.rlane_cd );                   
            END IF; 
                         
         ELSIF upd.estm_tgt_flg = 'N' THEN --upd Booking and not Targeted (Split, Combine 처리 되어 새롭게 생긴 Bookings) 
            MERGE /*+ INDEX(M XPKLEA_ACCL_DTL) */ INTO lea_accl_dtl m 
            USING  
            ( 
               SELECT upd.rev_yrmon u0, upd.bkg_no u1, upd.cost_act_grp_seq u3, upd.cntr_no u4, upd.coa_cost_src_cd u5, upd.cost_act_grp_cd u6,  
                      upd.cntr_tpsz_cd u7, upd.cntr_qty u8, upd.cost_src_sys_cd u9, upd.pln_cost_amt u10, upd.estm_cost_amt u11, upd.estm_cost_amt u12, 
                      upd.thrp_rt_flg u13, upd.n1st_nod_cd u14, upd.n2nd_nod_cd u15, upd.n3rd_nod_cd u16, upd.n4th_nod_cd u17, 
                      upd.n1st_vndr_seq u18, upd.n2nd_vndr_seq u19, upd.n3rd_vndr_seq u20, upd.n4th_vndr_seq u21, 
                      upd.vsl_cd u22, upd.skd_voy_no u23, upd.skd_dir_cd u24, upd.rev_dir_cd u25, upd.estm_vvd_tp_cd u26, upd.estm_ioc_div_cd u27, 
                      upd.acct_cd u28, upd.bkg_sts_cd u29, upd.mapg_aloc_flg u30, 'N' u31, upd.act_inv_knt u32, upd.ttl_inv_knt u33, 'UPD_ESTM_I' u34, 'UPD_ESTM_I' u35, 
                      upd.cost_rout_no u36, upd.cost_ass_bse_cd u37, upd.ctrt_rtn_flg u38, upd.delt_flg u39, upd.accl_lgc_tp_cd u40, 
                      upd.n1st_vvd_cd u41, upd.n2nd_vvd_cd u42, upd.ctrl_ofc_cd u43, upd.trd_cd u44, upd.rlane_cd u45 
               FROM dual 
            ) v 
            ON       (    v.u0 = m.rev_yrmon             --Table Primary Key 
                      AND v.u1 = m.bkg_no 
                      AND v.u3 = m.cost_act_grp_seq 
                      AND v.u4 = m.cntr_no 
                      AND v.u5 = m.coa_cost_src_cd) 
           WHEN MATCHED THEN 
               UPDATE  
                  SET m.cost_act_grp_cd = v.u6, 
                      m.cntr_tpsz_cd    = v.u7, 
                      m.cntr_qty        = v.u8, 
                      m.cost_src_sys_cd = v.u9, 
                      m.pln_cost_amt    = v.u10, 
                      m.estm_cost_amt   = v.u11, 
                      m.accl_cost_amt   = CASE  WHEN v.u40 in ('NB','LB') AND 
                                                    m.act_inv_knt >= DECODE(m.act_inv_knt , 0 , v.u33, m.ttl_inv_knt) 
                                                    THEN 0
                                                WHEN v.u40 in ('NB','LB') AND 
                                                    m.act_inv_knt < DECODE(m.act_inv_knt , 0 , v.u33, m.ttl_inv_knt) AND
                                                    m.act_cost_amt <= 0 
                                                    THEN v.u11
                                                WHEN v.u40 in ('NB','LB') AND 
                                                    m.act_inv_knt < DECODE(m.act_inv_knt , 0 , v.u33, m.ttl_inv_knt) AND
                                                    m.act_cost_amt > 0 
                                                    THEN m.accl_cost_amt
                                                WHEN v.u40 in ('NO','LO') AND 
                                                     v.u11 = 0 
                                                    THEN 0
                                                ELSE m.accl_cost_amt
                                          END ,
--                      DECODE(m.act_cost_amt, 0, v.u12 , m.accl_cost_amt),  
                      m.thrp_rt_flg     = v.u13, 
                      m.n1st_nod_cd     = v.u14, 
                      m.n2nd_nod_cd     = v.u15, 
                      m.n3rd_nod_cd     = v.u16, 
                      m.n4th_nod_cd     = v.u17, 
                      m.n1st_vndr_seq   = v.u18, 
                      m.n2nd_vndr_seq   = v.u19, 
                      m.n3rd_vndr_seq   = v.u20, 
                      m.n4th_vndr_seq   = v.u21, 
                      m.vsl_cd          = v.u22, 
                      m.skd_voy_No      = v.u23, 
                      m.skd_dir_cd      = v.u24, 
                      m.rev_dir_cd      = v.u25, 
                      m.estm_vvd_tp_cd  = v.u26, 
                      m.estm_ioc_div_cd = v.u27, 
                      m.acct_cd         = v.u28, 
                      m.bkg_sts_cd      = v.u29, 
                      m.mapg_aloc_flg   = v.u30, 
                      m.accl_calc_flg   = v.u31, 
--                      m.act_inv_knt     = DECODE(m.act_inv_knt , 0 , v.u32, m.act_inv_knt), 
                      m.ttl_inv_knt     = DECODE(m.act_inv_knt , 0 , v.u33, m.ttl_inv_knt), 
                      m.upd_usr_id      = v.u34, 
                      m.cre_usr_id      = v.u35, 
                      m.cost_rout_no    = v.u36, 
                      m.cost_ass_bse_cd = v.u37, 
                      m.ctrt_rtn_flg    = v.u38,   
                      m.delt_flg        = v.u39, 
                      m.accl_lgc_tp_cd  = v.u40, 
                      m.n1st_vvd_cd     = v.u41, 
                      m.n2nd_vvd_cd     = v.u42, 
                      m.ctrl_ofc_cd     = v.u43, 
                      m.trd_cd          = v.u44, 
                      m.rlane_cd        = v.u45 
           WHEN NOT MATCHED THEN            
               INSERT 
                  (rev_yrmon, bkg_no, cost_act_grp_seq, cntr_no, coa_cost_src_cd, cost_act_grp_cd,  
                   cntr_tpsz_cd, cntr_qty, cost_src_sys_cd, pln_cost_amt, estm_cost_amt, accl_cost_amt, --Act.Cost가 0이면 Accl.Cost는 Estm.Cost 임 
                   thrp_rt_flg, n1st_nod_cd, n2nd_nod_cd, n3rd_nod_cd, n4th_nod_cd, 
                   n1st_vndr_seq, n2nd_vndr_seq, n3rd_vndr_seq, n4th_vndr_seq, 
                   vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, estm_vvd_tp_cd, estm_ioc_div_cd, 
                   acct_cd, bkg_sts_cd,  mapg_aloc_flg, accl_calc_flg, act_inv_knt, ttl_inv_knt, cre_usr_id, cre_dt, upd_usr_id, upd_dt, 
                   cost_rout_no, cost_ass_bse_cd, ctrt_rtn_flg, delt_flg, accl_lgc_tp_cd, 
                   n1st_vvd_cd, n2nd_vvd_cd, ctrl_ofc_cd, trd_cd, rlane_cd) 
               VALUES 
                  (v.u0, v.u1, v.u3, v.u4, v.u5, v.u6, 
                   v.u7, v.u8, v.u9, v.u10, v.u11, v.u12, 
                   v.u13, v.u14, v.u15, v.u16, v.u17, 
                   v.u18, v.u19, v.u20, v.u21, 
                   v.u22, v.u23, v.u24, v.u25, v.u26, v.u27, 
                   v.u28, v.u29, v.u30, v.u31, v.u32, v.u33, v.u34, SYSDATE, v.u35, SYSDATE,   
                   v.u36, v.u37, v.u38, v.u39, v.u40, 
                   v.u41, v.u42, v.u43, v.u44, v.u45 
                   ); --Accrual 대상 처리     
                    
                         
--            INSERT INTO lea_accl_dtl 
--               (rev_yrmon, bkg_no,  cost_act_grp_cd, cost_act_grp_seq, cntr_no, coa_cost_src_cd, 
--                cntr_tpsz_cd, cntr_qty, cost_src_sys_cd, pln_cost_amt, estm_cost_amt, accl_cost_amt,  
--                thrp_rt_flg, n1st_nod_cd, n2nd_nod_cd, n3rd_nod_cd, n4th_nod_cd, 
--                n1st_vndr_seq, n2nd_vndr_seq, n3rd_vndr_seq, n4th_vndr_seq, 
--                vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, estm_vvd_tp_cd, estm_ioc_div_cd, 
--                acct_cd, bkg_sts_cd,  mapg_aloc_flg, accl_calc_flg, act_inv_knt, ttl_inv_knt, cre_usr_id, cre_dt, upd_usr_id, upd_dt, 
--                cost_rout_no, cost_ass_bse_cd, ctrt_rtn_flg, delt_flg, accl_lgc_tp_cd) 
--            VALUES 
--               (upd.rev_yrmon, upd.bkg_no,  upd.cost_act_grp_cd, upd.cost_act_grp_seq, upd.cntr_no, upd.coa_cost_src_cd, 
--                upd.cntr_tpsz_cd, upd.cntr_qty, upd.cost_src_sys_cd, upd.pln_cost_amt, upd.estm_cost_amt, upd.estm_cost_amt, 
--                upd.thrp_rt_flg, upd.n1st_nod_cd, upd.n2nd_nod_cd, upd.n3rd_nod_cd, upd.n4th_nod_cd, 
--                upd.n1st_vndr_seq, upd.n2nd_vndr_seq, upd.n3rd_vndr_seq, upd.n4th_vndr_seq, 
--                upd.vsl_cd, upd.skd_voy_no, upd.skd_dir_cd, upd.rev_dir_cd, upd.estm_vvd_tp_cd, upd.estm_ioc_div_cd, 
--                upd.acct_cd, upd.bkg_sts_cd, upd.mapg_aloc_flg, 'N', upd.act_inv_knt, upd.ttl_inv_knt, 'UPD_ESTM_I', SYSDATE, 'UPD_ESTM_I', SYSDATE, 
--                upd.cost_rout_no, upd.cost_ass_bse_cd, upd.ctrt_rtn_flg, upd.delt_flg, upd.accl_lgc_tp_cd); --Accrual 대상 처리 
                      
            IF SQL%FOUND THEN       
               UPDATE lea_estm_cost_if 
               SET estm_upd_flg        = 'N', --'Y'->'N' 처리 
                   estm_tgt_flg        = 'Y',  --Targeted 
                   upd_bat_st_dt       = exe_yrmon_in 
                  WHERE bkg_no         = upd.bkg_no 
                  AND cntr_no          = upd.cntr_no 
                  AND cost_act_grp_seq = upd.cost_act_grp_seq 
                  AND coa_cost_src_cd  = upd.coa_cost_src_cd 
                  ; 
                   
            END IF; 
             
         END IF;  
      ELSIF upd.bkg_sts_cd = 'S' OR upd.bkg_sts_cd = 'X' THEN --S:선사요청 Split, X:자체Cancel, 화주요청 Split 
         IF upd.estm_tgt_flg = 'Y' AND upd.bkg_split_cd IS NULL AND upd.cmb_bkg_no IS NULL THEN   
         
                --??
            IF SQL%FOUND THEN       
               UPDATE  lea_estm_cost_if 
               SET estm_upd_flg        = 'N', --'Y'->'N' 처리 
                   upd_bat_st_dt       = exe_yrmon_in 
                  WHERE bkg_no         = upd.bkg_no 
                  AND cntr_no          = upd.cntr_no 
                  AND cost_act_grp_seq = upd.cost_act_grp_seq 
                  AND coa_cost_src_cd  = upd.coa_cost_src_cd 
                  ; 
                   
            END IF; 
             
         ELSIF upd.estm_tgt_flg = 'Y' AND upd.bkg_split_cd IS NOT NULL AND upd.cmb_bkg_no IS NULL THEN --화주,선주 요청 Split 
            -- Split전 부킹에 매핑배부된 Actual cost를 Split된 부킹에 이관처리(중요) 
            UPDATE /*+ index (lea_accl_dtl xpklea_accl_dtl) */ lea_accl_dtl 
            SET   bkg_sts_cd        = upd.bkg_sts_cd, 
                  bkg_split_cd      = upd.bkg_split_cd, 
                  cmb_bkg_no        = upd.cmb_bkg_no, 

                  delt_flg          = upd.delt_flg, 
                  mapg_aloc_flg     = upd.mapg_aloc_flg, --Mapping, Allocate 대상이 아님 
                  upd_usr_id        = 'UPD_ESTM_U_2-0', 
                  upd_dt            = SYSDATE 
            WHERE rev_yrmon        = upd.rev_yrmon 
              AND bkg_no           = upd.bkg_no 

              AND cntr_no          = upd.cntr_no 
              AND cost_act_grp_seq = upd.cost_act_grp_seq 
              AND coa_cost_src_cd  = upd.coa_cost_src_cd 
            RETURNING act_cost_amt INTO v_act_cost_amt 
              ;             
--            UPDATE lea_accl_dtl 
--            SET   rev_yrmon = rev_yrmon 
--            WHERE rev_yrmon        = upd.rev_yrmon 
--              AND bkg_no           = upd.bkg_no 
--              AND bkg_no_split     = upd.bkg_no_split 
--              AND cntr_no          = upd.cntr_no 
--              AND cost_act_grp_seq = upd.cost_act_grp_seq 
--              AND coa_cost_src_cd  = upd.coa_cost_src_cd 
--              ; 
             
            --대상이 존재시 이관 처리 
            IF v_act_cost_amt > 0 THEN 
               UPDATE lea_accl_dtl d 
                  SET (d.act_cntr_cost_amt, 
                       d.act_bkg_cost_amt,   
                       d.act_rev_vvd_cost_amt, 
                       d.act_com_vvd_cost_amt, 
                       d.act_etc_cost_amt, 
                       d.act_cost_amt, 
                       d.act_inv_knt, 
                       d.ttl_inv_knt) 
                         =    
                         (SELECT /*+ index (lea_accl_dtl xpklea_accl_dtl) */ NVL(act_cntr_cost_amt, 0), 
                                 NVL(act_bkg_cost_amt, 0), 
                                 NVL(act_rev_vvd_cost_amt, 0),  
                                 NVL(act_com_vvd_cost_amt, 0),  
                                 NVL(act_etc_cost_amt, 0),  
                                 NVL(act_cost_amt, 0), 
                                 NVL(act_inv_knt, 0), 
                                 NVL(ttl_inv_knt, 0) 
                            FROM lea_accl_dtl 
                           WHERE rev_yrmon        = upd.rev_yrmon 
                             AND bkg_no           = upd.bkg_no 
                             AND cntr_no          = upd.cntr_no 
                             AND cost_act_grp_seq = upd.cost_act_grp_seq 
                             AND coa_cost_src_cd  = upd.coa_cost_src_cd), 
                      d.accl_calc_flg = 'Y',        
                      d.upd_usr_id    = 'UPD_ESTM_U_2', 
                      d.upd_dt        = SYSDATE 
                WHERE rev_yrmon        = upd.rev_yrmon 
                  AND bkg_no           like  upd.bkg_no||'%' 
                  AND length(bkg_no) = 13
--                  AND bkg_no_split     <> '  '   --Booking Split Number 가 존재하는 
                  AND cntr_no          = upd.cntr_no 
                  AND cost_act_grp_seq = upd.cost_act_grp_seq 
                  AND coa_cost_src_cd  = upd.coa_cost_src_cd 
                  AND bkg_sts_cd       = 'F' 
                  ;             
             
            END IF;             
             
 
            --다음 수행년월 배치 실행시 누적 안되게 처리!!    
            UPDATE  lea_estm_cost_if 
            SET estm_upd_flg        = 'N', --'Y'->'N' 처리 
                upd_bat_st_dt       = exe_yrmon_in 
               WHERE bkg_no         = upd.bkg_no 
               AND cntr_no          = upd.cntr_no 
               AND cost_act_grp_seq = upd.cost_act_grp_seq 
               AND coa_cost_src_cd  = upd.coa_cost_src_cd 
               ; 
                            
         ELSIF upd.estm_tgt_flg = 'Y' AND upd.bkg_split_cd IS NULL AND upd.cmb_bkg_no IS NOT NULL THEN --Combine 처리 
            --Combine 처리된 Booking에 대해 Combine 이전 Booking의 Actual 값을 이관처리(중요) 
            UPDATE /*+ index (lea_accl_dtl xpklea_accl_dtl) */ lea_accl_dtl 
            SET   bkg_sts_cd        = upd.bkg_sts_cd, 
                  bkg_split_cd      = upd.bkg_split_cd, 
                  cmb_bkg_no        = upd.cmb_bkg_no, 

                  delt_flg          = upd.delt_flg, 
                  mapg_aloc_flg     = upd.mapg_aloc_flg, --Mapping, Allocate 대상이 아님 
                  upd_usr_id        = 'UPD_ESTM_U_3-0', 
                  upd_dt            = SYSDATE 
            WHERE rev_yrmon        = upd.rev_yrmon 
              AND bkg_no           = upd.bkg_no 

              AND cntr_no          = upd.cntr_no 
              AND cost_act_grp_seq = upd.cost_act_grp_seq 
              AND coa_cost_src_cd  = upd.coa_cost_src_cd 
            RETURNING act_cost_amt INTO v_act_cost_amt 
              ;              
--            UPDATE lea_accl_dtl 
--            SET   rev_yrmon = rev_yrmon 
--            WHERE rev_yrmon        = upd.rev_yrmon 
--              AND bkg_no           = upd.bkg_no 
--              AND bkg_no_split     = upd.bkg_no_split 
--              AND cntr_no          = upd.cntr_no 
--              AND cost_act_grp_seq = upd.cost_act_grp_seq 
--              AND coa_cost_src_cd  = upd.coa_cost_src_cd 
--              ; 
             
            --대상이 존재시 이관 처리 
            IF v_act_cost_amt > 0 THEN 
               UPDATE /*+ index (lea_accl_dtl xpklea_accl_dtl) */ lea_accl_dtl d 
                  SET (d.act_cntr_cost_amt, 
                       d.act_bkg_cost_amt,   
                       d.act_rev_vvd_cost_amt, 
                       d.act_com_vvd_cost_amt, 
                       d.act_etc_cost_amt, 
                       d.act_cost_amt, 
                       d.act_inv_knt, 
                       d.ttl_inv_knt ) 
                         =    
                         (SELECT /*+ index (lea_accl_dtl xpklea_accl_dtl) */ NVL(act_cntr_cost_amt, 0), 
                                 NVL(act_bkg_cost_amt, 0), 
                                 NVL(act_rev_vvd_cost_amt, 0),  
                                 NVL(act_com_vvd_cost_amt, 0),  
                                 NVL(act_etc_cost_amt, 0),  
                                 NVL(act_cost_amt, 0), 
                                 NVL(act_inv_knt, 0), 
                                 NVL(ttl_inv_knt, 0) 
                            FROM lea_accl_dtl 
                            WHERE rev_yrmon        = upd.rev_yrmon 
                              AND bkg_no           = upd.bkg_no 

                              AND cntr_no          = upd.cntr_no 
                              AND cost_act_grp_seq = upd.cost_act_grp_seq 
                              AND coa_cost_src_cd  = upd.coa_cost_src_cd), 
                     d.accl_calc_flg = 'Y', 
                     d.upd_usr_id    = 'UPD_ESTM_U_3', 
                     d.upd_dt        = SYSDATE 
               WHERE rev_yrmon         = upd.rev_yrmon 
                  AND bkg_no           = upd.cmb_bkg_no       --Combine Booking No. 

                  AND cntr_no          = upd.cntr_no 
                  AND cost_act_grp_seq = upd.cost_act_grp_seq 
                  AND coa_cost_src_cd  = upd.coa_cost_src_cd 
                  AND bkg_sts_cd       = 'F'  
                  ; 
                                           
            END IF; 
                                          
            --다음 수행년월 배치 실행시 누적 안되게 처리!!       
            UPDATE  lea_estm_cost_if 
            SET estm_upd_flg        = 'N', --'Y'->'N' 처리 
                upd_bat_st_dt       = exe_yrmon_in 
               WHERE bkg_no         = upd.bkg_no
               AND cntr_no          = upd.cntr_no 
               AND cost_act_grp_seq = upd.cost_act_grp_seq 
               AND coa_cost_src_cd  = upd.coa_cost_src_cd 
               ; 
                   
         END IF; 
          
      END IF;           
 
--      /* Exception ------------------------------------------------------------------*/ 
--      EXCEPTION 
--         WHEN NO_DATA_FOUND 
--         THEN 
--            DBMS_OUTPUT.put_line ('No Data Found.'); 
--            lea_log_prc ('NO_DATA_FOUND'); 
--         WHEN OTHERS 
--         THEN 
--            DBMS_OUTPUT.put_line (   '[LEA_SCNR] : Error!! ' 
--                                  || SQLERRM 
--                                  || ', ' 
--                                  || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss') 
--                                 ); 
--            lea_log_prc ('OTHERS, ' || SQLERRM || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss')); 
--      END; 
 
      --10000 만건 단위로 Commit 
      IF MOD(v_cur_idx, 100000) = 0 THEN 
         COMMIT; 
         lea_log_prc('Working...idx='||v_cur_idx); 
      END IF; 
       
   END LOOP; 
    
   COMMIT; -- 추가 (2008/10/01) 
    
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_UPD_ESTM_PRC 완료') ; -- 시간 측정을 위한 디버깅 코드 
    
   LEA_BKUP_PKG.analyze_table('LEA_ACCL_DTL'); 
    
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_UPD_ESTM_PRC:ANALYZE 완료') ; -- 시간 측정을 위한 디버깅 코드 
    
    
--   PV 인 Booking을 새로운 수행년월 마다 다시 체크하여 Mapping,Allocate 대상 처리 
--   MERGE INTO lea_accl_dtl m 
--   USING 
--   ( 
--      SELECT /*+ INDEX(D XAK1LEA_ACCL_DTL) PARALLEL_INDEX(D XAK1LEA_ACCL_DTL 8)  */  
--             d.ROWID RID, v.estm_vvd_tp_cd, d.thrp_rt_flg, d.bkg_sts_cd, 
--             d.delt_flg, d.cost_act_grp_cd, d.coa_cost_src_cd 
--      FROM lea_accl_dtl d, gl_estm_rev_vvd v 
--      WHERE 1=1 
--      AND d.rev_yrmon       >= '200801' 
--      AND v.exe_yrmon       = exe_yrmon_in 
--      AND d.vsl_cd          = v.vsl_cd 
--      AND d.skd_voy_no      = v.skd_voy_no 
--      AND d.skd_dir_cd      = v.skd_dir_cd 
--      AND d.rev_dir_cd      = v.rev_dir_cd 
--      AND d.rev_yrmon       = v.rev_yrmon 
--      AND d.estm_ioc_div_cd = v.estm_ioc_div_cd 
--      AND v.estm_vvd_tp_cd  <> 'PV' 
--      AND d.estm_vvd_tp_cd  = 'PV'   
--      AND v.estm_bc_div_cd  = 'C' 
--      AND d.mapg_aloc_flg   = 'N' 
--      AND d.delt_flg        = 'N' 
--      ORDER BY RID 
--   ) U 
--   ON ( M.ROWID = U.RID ) 
--   WHEN MATCHED THEN 
--      UPDATE 
--      SET m.estm_vvd_tp_cd = u.estm_vvd_tp_cd,  
--          m.mapg_aloc_flg  = CASE 
----                                 WHEN u.estm_vvd_tp_cd = 'PV' THEN 'N' 
--                                 --WHEN u.thrp_rt_flg    = 'Y'  THEN 'N'                       
--                                 WHEN u.bkg_sts_cd     = 'A' OR u.bkg_sts_cd = 'X' OR u.bkg_sts_cd = 'S' THEN 'N' 
--                                 WHEN u.delt_flg       = 'Y'  THEN 'N' 
--                                 WHEN (u.cost_act_grp_cd = 'NOBC' OR u.cost_act_grp_cd = 'NIBC') 
--                                    AND 
--                                      (u.coa_cost_src_cd = 'TMNDFL' OR u.coa_cost_src_cd = 'TMFDFL') THEN 'N' 
--                                 ELSE 'Y' 
--                              END, 
--          m.upd_usr_id     = 'UPD_ESTM_U_4', 
--          m.upd_dt         = SYSDATE 
--    ;    
--    
--   Commit; 
    
--   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_UPD_ESTM_PRC:PV_VVD 완료('||v_cur_idx||')') ; -- 시간 측정을 위한 디버깅 코드 
    
   --Batch History Record setting 
   v_bat_his_rec.exe_yrmon := exe_yrmon_in; 
   v_bat_his_rec.bat_id := bat_id_in; 
   v_bat_his_rec.estm_upd_knt := v_cur_idx;   --Insert Row Count 
   v_bat_his_rec.estm_upd_end_dt := SYSDATE;  --Update Estimate data insert end date 
   v_rtn_val := lea_accl_bat_his_fnc (v_bat_his_rec, 'BU'); 
    
   lea_log_prc ('lea_accl_upd_estm_prc() end.('||v_cur_idx||')'); 
    
   /* Exception -----------------------------------------------------------------*/ 
   EXCEPTION 
   WHEN OTHERS 
   THEN 
        
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);  
END;