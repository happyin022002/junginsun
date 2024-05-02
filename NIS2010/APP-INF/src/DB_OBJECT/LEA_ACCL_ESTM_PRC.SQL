CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACCL_ESTM_PRC (exe_yrmon_in IN VARCHAR, bat_id_in IN VARCHAR) 
IS 
/******************************************************************************* 
  1.Object Name     : LEA_ACCL_ESTM_PRC
  2.Version         : 1.0
  3.Create Date     : 2007-03-02
  4.Sub System      : Logistics Expense Accrual
  5.Author          : 전재홍
  6.Description     : Estimation(From COA) 정보 생성
  7.Revision History 
    2007-02-02 : - 김상모 최초생성. 
    2008-03-06 : - EDW 요청으로 ctrl_ofc_cd 컬럼 추가(LEA_ESTM_COST_IF, LEA_ACCL_DTL) 
                   CTRL_OFC_CD 변경값 적용되게 로직 추가     
    2008-03-10 : - 결산기간을 2월 수행년월 부터 2008.01월 반영(HardCoding) : '200710'->'200801'      
    2008-03-25 : - VVD Type is 'BV','RV' and Booking Status is 'F', 'W' => Mapping/Allocate is 'Y' 
                   VVD Type is 'PV'      and Booking Status is 'F', 'W' => Mapping/Allocate is 'N'  
    2008-04-04 : - 전재홍 - Accrual 로직 추가 변경에 따라 Throupht Cost Flag 관련 로직 제거 
                   THRP_RT_FLG = Y 인 경우에도 매핑 배부  
    2008-05-23 : - PV인 경우에도 배부 적용.(매핑인경우에는 rev.month 를 비교하게됨)     
    2009-01-08 : - Trade, Lane 정보 추가 
    2009-01-21 : - Exe.Yrmon가 1,2,3 월일경우 Rev.Month 는 전년도 각각 10,11,12 를   
                   포함하도록 로직반영  
    2009-03-02 : - 대상항차중 전년도 대상 포함하도록 변경 
    2009-09-23 : - ACCL_COST_AMT 업데이트 시 Basic Cost 에 대해서는 Invoice Count 및 ACT_COST_AMT 를 참조하고, 
                   Other Cost 에 대해서는 Update 하지 않음.  
    2009-11-03 : - ESTM UPDATE 시에 CTRL_OFC_CD 는 UPDATE 하지 않음.  
                 - ESTM UPDATE 시에 Other Cost(NO,LO) 는  
                   1) Update 되는 ESTM 금액이 = 0 인 경우, Accrual 금액 = 0 
                   2) Update 되는 ESTM 금액이 <> 0 인 경우, Accrual 금액 update 하지 않음
    2010-03-23 : - ESTM UPDATE 시에 CTRL_OFC_CD 는 UPDATE 로 변경(20091103 이전으로 롤백)
    2010-04-16 : - bkg_no_split 칼럼 제거
*******************************************************************************/ 
/* Variable Declare -------------------------------------------------------*/ 
   v_bat_his_rec   lea_bat_pkg.bat_his_rec;   --Batch Hostory Record 
   v_rtn_val       VARCHAR2 (1); 
   v_row_knt       NUMBER := 0; 
BEGIN 
   lea_log_prc ('lea_accl_estm_prc() start.'); 
   v_bat_his_rec.estm_st_dt := SYSDATE;   --Estimate data insert start date 
--   lea_log_prc ('lea_bat_pkg.g_exe_yrmon=' || lea_bat_pkg.g_exe_yrmon); 
--   lea_log_prc ('lea_bat_pkg.g_bat_id=' || lea_bat_pkg.g_bat_id); 
--   lea_log_prc ('v_bat_his_rec.bat_id=' || v_bat_his_rec.bat_id); 
 
   execute immediate 'alter session enable parallel dml' ; 
 
   lea_bkup_pkg.set_table_index_logging_prc('LEA_ACCL_DTL', FALSE) ; 

   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_estm_prc-MERGE'); 
 
   -- 데이타가 INSERT 되는 Unique Index(PK 인덱스 포함) 를 제외한 모든 인덱스를  
   -- DISABLE 시키고, MERGE가 끝난 후에 다시 REBUILD 한다. 
   -- MERGE APPEND 문이 실행된 후에 INDEX REBUILD 를 PARALLEL 로 하지 않는데 
   -- 실제로는 해당 파티션의 모든 ROW 가 새 ROW 이므로 REBUILD가 빠르다. 
   -- XAK3LEA_ACCL_DTL,XAK3LEA_ACCL_DTL 는 둘다 BITMAP Index 이기 때문에 Main에서 
   -- Unusable 처리후 매핑,배부가 끝난 뒤 Main에서 Rebuild 처리 한다. 
   LEA_BKUP_PKG.set_indexes_unusable_prc('XAK1LEA_ACCL_DTL', 'P'||exe_yrmon_in) ; 
   LEA_BKUP_PKG.set_indexes_unusable_prc('XAK2LEA_ACCL_DTL', 'P'||exe_yrmon_in) ; 
 
    
   MERGE /*+ Append use_nl(m) */ 
      INTO lea_accl_dtl m 
      USING ( 
            SELECT    /*+ parallel(i,8) parallel(v,8) */ 
                      v.rev_yrmon         u0, 
                      i.bkg_no            u1, 
                      i.cntr_no           u5, 
                      i.cost_act_grp_seq  u4, 
                      i.cost_act_grp_cd   u3, 
                      i.coa_cost_src_cd   u6, 
                      i.cntr_tpsz_cd      u7, 
                      i.cntr_qty          u8, 
                      i.cost_src_sys_cd   u9,   --TRS,TES 
                      i.pln_cost_amt      u10, 
                      i.estm_cost_amt     u11, 
                      i.thrp_rt_flg       u12,  --Throughput Cost Flag 
                      i.n1st_nod_cd       u13,  --Node 
                      i.n2nd_nod_cd       u14, 
                      i.n3rd_nod_cd       u15, 
                      i.n4th_nod_cd       u16, 
                      i.n1st_vndr_seq     u17,  --Vendor 
                      i.n2nd_vndr_seq     u18, 
                      i.n3rd_vndr_seq     u19, 
                      i.n4th_vndr_seq     u20, 
                      v.vsl_cd            u24, 
                      v.skd_voy_no        u25, 
                      v.skd_dir_cd        u26, 
                      v.rev_dir_cd        u27, 
                      v.last_estm_vvd_tp_cd    u28, 
                      v.estm_ioc_div_cd   u29,                       
                      c.acct_cd           u30, 
                      i.bkg_sts_cd        u31,     --Booking status code       
                      CASE 
--                         WHEN v.estm_vvd_tp_cd = 'PV' THEN 'N' 
                         --R.VVD Type이 PV(진행항차)이면 Mapping/Alloc 처리대상 아님 -> 2008.5.23 변경 
                         --WHEN i.thrp_rt_flg = 'Y' THEN 'N'                       
                         --Booking Status Code is 'X', 'S' => 'N' 
                         WHEN i.bkg_sts_cd = 'X' OR i.bkg_sts_cd = 'S' THEN 'N' 
                         --Dispatch CNTR에 대해서는 Mapping,Allocate 처리대상 아님 
                         WHEN i.delt_flg = 'Y' THEN 'N' 
                         --배부 시에도 NOBC와 NIBC에 대해서는 TMNDFL, TMFDFL Cost를 배부받지 않도록 Hard coding 필요 
                         WHEN (i.cost_act_grp_cd = 'NOBC' OR i.cost_act_grp_cd = 'NIBC') 
                            AND 
                              (i.coa_cost_src_cd = 'TMNDFL' OR i.coa_cost_src_cd = 'TMFDFL') THEN 'N' 
                         ELSE 'Y' --'RV', 'BV' and Booking Status Code is 'F', 'W' => Mapping Allocate is 'Y(es)' 
                      END                 u32, --mapg_aloc_flg(Mapping Allocate flag) 
                      i.cost_rout_no      u33, 
                      i.delt_flg          u34, 
                      DECODE(SUBSTR(c.accl_lgc_tp_cd, 2, 1), 'B', 1, NULL) u35,  --Basic Cost면 Total Invoice Counter를 Default로 1로 셋팅처리 
                      DECODE(SUBSTR(c.accl_lgc_tp_cd, 2, 1), 'B', 0, NULL) u38,  --Basic Cost면 Actual Invoice Counter를 Default로 0로 셋팅처리    
                      c.accl_lgc_tp_cd    u36, --Accrual logic case(LB, LO, NB, NO) 
                      i.cost_ass_bse_cd   u37, 
                      i.ctrt_rtn_flg      u45, 
                      i.cmb_bkg_no        u39, 
                      i.bkg_split_cd      u41, 
                      i.n1st_vvd_cd       u42, --First Actual VVD 
                      i.n2nd_vvd_cd       u43, --Second Actual VVD 
                      i.ctrl_ofc_cd       u46, 
                      i.trd_cd            u47, 
                      i.rlane_cd          u48 
                 FROM lea_estm_cost_if i, 
                      (SELECT rev_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, 
                               SUBSTR(MAX(exe_yrmon||estm_vvd_tp_cd), 7, 2) last_estm_vvd_tp_cd, 
                               estm_ioc_div_cd,estm_vvd_hdr_id 
                        FROM   gl_estm_rev_vvd 
                        WHERE  estm_bc_div_cd = 'C'  --By Container 
        --                  AND  exe_yrmon      = exe_yrmon_in --R.VVD가 수행년월별(EXE_YRMON)로 누적되어야 됨!!! 
                          AND  exe_yrmon  in ( exe_yrmon_in , TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in,'yyyymm') ,-12 ), 'yyyy') || '12')  
                          AND  rev_yrmon >= CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03') 
                                                    THEN to_char(add_months(to_date(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm')  
                                                 ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01' 
                                            END                                       
        --                  AND  rev_yrmon BETWEEN '200801' AND TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -1), 'yyyymm')    
                        GROUP BY rev_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, estm_ioc_div_cd, estm_vvd_hdr_id ) v, 
                      lea_lgs_cost c 
                WHERE 1=1           
                  AND v.vsl_cd          = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'CFDR', i.vsl_cd) -- RBC Lane R.VVD:CFDRyymmEE,  IOC:XX 
                  AND v.skd_voy_no      = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', SUBSTR (i.vsl_cd || i.skd_voy_no , 3, 4), i.skd_voy_no) --년월(2007.03) => 0703 
                  AND v.skd_dir_cd      = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'E', i.skd_dir_cd) 
                  AND v.rev_dir_cd      = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'E', i.rev_dir_cd)                                                        
                  AND v.estm_ioc_div_cd = i.estm_ioc_div_cd   --IOC 일치               
                  AND c.coa_cost_src_cd = i.coa_cost_src_cd   --Cost Code 
                  AND c.accl_auto_cd    = 'A'                 --Auto Accrual 만 COA에서 가져옴(Manual, Transfer 안가져옴) 
                  AND c.delt_flg        = 'N'                 --Delete not Cost code 
                  AND ( 
                          (  
--                           i.estm_tgt_flg    = 'N'            --추정 대상으로 선택하지 않은 것중(수행년월별로 Rev년월별 R.VVD가 반복되기 때문에 대상확인이 필요, 중복회피) 
--                           AND 
                           i.estm_upd_flg    = 'Y' 
                          ) 
                          OR i.bat_st_dt      = exe_yrmon_in   --수행년월의 반복 배치 작업 대상 
                      ) 
                  AND ( 
                          ( 
                              i.bkg_sts_cd IN ('F', 'W') 
                          )   
                       OR (  --수행년월 기간 동안 Cancel처리된 Split,  
                              ( i.bkg_sts_cd = 'X' OR i.bkg_sts_cd = 'S' ) AND i.bkg_split_cd IS NOT NULL 
                          ) 
                       OR (  --Combine Booking도 Actual Mapping을 위해 가져옴  
                             i.bkg_sts_cd = 'X' AND i.cmb_bkg_no IS NOT NULL 
                          ) 
                      ) 
            ORDER BY i.rev_yrmon, i.coa_cost_src_cd, i.n1st_nod_cd,  
                  i.vsl_cd, i.skd_voy_no, i.skd_dir_cd, i.rev_dir_cd,  
                  i.bkg_no 
              ) v 
      ON (    v.u0 = m.rev_yrmon             --Table Primary Key 
          AND v.u1 = m.bkg_no 
          AND v.u5 = m.cntr_no 
          AND v.u4 = m.cost_act_grp_seq 
          AND v.u6 = m.coa_cost_src_cd) 
      WHEN MATCHED THEN 
         UPDATE   --진행항차(PV)에서 수행항차 변경될시 LEA_ACCL_DTL에 Update 처리(후 Actual 재매핑,배부 없이 Case별 Accrual만 계산 대상) 
            SET m.cost_act_grp_cd   = v.u3, 
                m.cntr_qty          = v.u8, 
                m.cost_src_sys_cd   = v.u9, 
                m.pln_cost_amt      = v.u10, 
                m.estm_cost_amt     = v.u11, 
                m.accl_cost_amt     = CASE  WHEN v.u36 in ('NB','LB') AND 
                                                 m.act_inv_knt >= DECODE(m.act_inv_knt , 0 , v.u35, m.ttl_inv_knt) 
                                                    THEN 0
                                            WHEN v.u36 in ('NB','LB') AND 
                                                 m.act_inv_knt < DECODE(m.act_inv_knt , 0 , v.u35, m.ttl_inv_knt) AND
                                                 m.act_cost_amt <= 0 
                                                    THEN v.u11
                                            WHEN v.u36 in ('NB','LB') AND 
                                                 m.act_inv_knt < DECODE(m.act_inv_knt , 0 , v.u35, m.ttl_inv_knt) AND
                                                 m.act_cost_amt > 0 
                                                    THEN m.accl_cost_amt
                                            WHEN v.u36 in ('NO','LO') AND 
                                                 v.u11 = 0 
                                                    THEN 0
                                            ELSE m.accl_cost_amt
                                      END ,
--                DECODE(m.act_cost_amt, 0, v.u11, m.accl_cost_amt), --Act.Cost가 0이면 Accl.Cost는 Estm.Cost 임                 
                m.thrp_rt_flg       = v.u12, 
                m.n1st_nod_cd       = v.u13, 
                m.n2nd_nod_cd       = v.u14, 
                m.n3rd_nod_cd       = v.u15, 
                m.n4th_nod_cd       = v.u16, 
                m.n1st_vndr_seq     = v.u17, 
                m.n2nd_vndr_seq     = v.u18, 
                m.n3rd_vndr_seq     = v.u19, 
                m.n4th_vndr_seq     = v.u20,   
                m.vsl_cd            = v.u24, 
                m.skd_voy_no        = v.u25, 
                m.skd_dir_cd        = v.u26, 
                m.rev_dir_cd        = v.u27, 
                m.accl_calc_flg     = CASE 
                                         WHEN m.act_cost_amt = 0 THEN --Act.Cost가 0이면 Accl.Cost는 Estm.Cost 임으로 다시 Accrual 처리할 필요 없음 
                                            'N' 
                                         WHEN m.estm_cost_amt <> v.u11 AND m.act_cost_amt <> 0 THEN --Estm.Cost 변동이 있고 Act.Cost가 발생되어 있으면 Accrual 처리해야 됨 
                                            'Y' 
                                         ELSE 
                                            m.accl_calc_flg 
                                      END, 
                m.bkg_sts_cd        = v.u31,                                       
                m.mapg_aloc_flg     = v.u32, 
--                m.act_inv_knt       = DECODE(m.act_inv_knt , 0 , v.u38, m.act_inv_knt),
                m.ttl_inv_knt       = DECODE(m.act_inv_knt , 0 , v.u35, m.ttl_inv_knt),
                m.upd_usr_id        = 'ACCL_ESTM_M', 
                m.upd_dt            = SYSDATE, 
                m.cost_rout_no      = v.u33, 
                m.delt_flg          = v.u34, 
                m.cmb_bkg_no        = v.u39, 
                m.bkg_split_cd      = v.u41, 
                m.n1st_vvd_cd       = v.u42, 
                m.n2nd_vvd_cd       = v.u43, 
                m.cost_ass_bse_cd   = v.u37,  
                m.ctrt_rtn_flg      = v.u45, 
                m.ctrl_ofc_cd       = v.u46, 
                m.trd_cd            = v.u47, 
                m.rlane_cd          = v.u48 
      WHEN NOT MATCHED THEN 
         INSERT (rev_yrmon, bkg_no, cost_act_grp_cd, cost_act_grp_seq, cntr_no, coa_cost_src_cd, 
                 cntr_tpsz_cd, cntr_qty, cost_src_sys_cd, pln_cost_amt, estm_cost_amt, accl_cost_amt,  
                 thrp_rt_flg, n1st_nod_cd, n2nd_nod_cd, n3rd_nod_cd, n4th_nod_cd, n1st_vndr_seq, n2nd_vndr_seq, n3rd_vndr_seq, n4th_vndr_seq, 
                 vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, estm_vvd_tp_cd, estm_ioc_div_cd, 
                 acct_cd, bkg_sts_cd,  mapg_aloc_flg, accl_calc_flg,  
                 act_inv_knt, ttl_inv_knt, cre_usr_id, cre_dt, upd_usr_id, upd_dt, 
                 cost_rout_no, delt_flg, accl_lgc_tp_cd, cost_ass_bse_cd, ctrt_rtn_flg, cmb_bkg_no,  bkg_split_cd, n1st_vvd_cd, n2nd_vvd_cd, 
                 ctrl_ofc_cd, trd_cd, rlane_cd) 
         VALUES (v.u0, v.u1,  v.u3, v.u4, v.u5, v.u6, 
                 v.u7, v.u8, v.u9, v.u10, v.u11, v.u11, --Insert시는 Act.Cost가 없기 때문에 Estm.Cost를 Accl.Cost로 Accrual처리 
                 v.u12, v.u13, v.u14, v.u15, v.u16, v.u17, v.u18, v.u19, v.u20, 
                 v.u24, v.u25, v.u26, v.u27, v.u28, v.u29, 
                 v.u30, v.u31, v.u32, 'N', --Accrual 여부 Flag(ACCL_CALC_FLG)를 'N'으로 처리함 
                 v.u38, v.u35, 'ACCL_ESTM_I', SYSDATE, 'ACCL_ESTM_I', SYSDATE, 
                 v.u33, v.u34, v.u36, v.u37, v.u45, v.u39, v.u41, v.u42, v.u43, 
                 v.u46, v.u47, v.u48) 
                 ;  
   v_bat_his_rec.estm_knt := SQL%ROWCOUNT;   --Insert Row Count 
    
   Commit; --Append 뒤에는 반드시 Commit 처리!! 
    
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_ESTM_PRC:MERGE 완료('||v_bat_his_rec.estm_knt||')') ; -- 시간 측정을 위한 디버깅 코드 
    
   lea_log_prc ('MERGE Finished'); 
   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_estm_prc-ANALYZE'); 
    
   -- PK Unique Index를 analyze 처리 
   LEA_BKUP_PKG.analyze_table('LEA_ACCL_DTL'); 
--   2007.10.12    
--   LEA_BKUP_PKG.analyze_table('LEA_ACCL_DTL', 'P'||exe_yrmon_in); 
--   LEA_BKUP_PKG.analyze_table('LEA_ACCL_DTL', 'P'||TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in,'YYYYMM'),1), 'YYYYMM')); 
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_ESTM_PRC:ANALYZE 완료') ; -- 시간 측정을 위한 디버깅 코드 
   lea_log_prc ('ANALYZE Finished'); 
   LEA_BKUP_PKG.rebuild_indexes_prc('XAK1LEA_ACCL_DTL', 'P'||exe_yrmon_in) ; 
   LEA_BKUP_PKG.rebuild_indexes_prc('XAK2LEA_ACCL_DTL', 'P'||exe_yrmon_in) ; 
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_ESTM_PRC:IND_PRT_REBILD 완료') ; -- 시간 측정을 위한 디버깅 코드 
    
   lea_log_prc ('Index Partition Rebuild Finished'); 
    
    
   IF v_bat_his_rec.estm_knt > 0   --수행년월기준으로 추정 대상으로 표시 
   THEN 
      lea_log_prc ('Start update estimated Target Flag(N->Y):'||exe_yrmon_in); 
      execute immediate 'alter session enable parallel dml' ; 
      DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_estm_prc-TARGET UPDATE'); 
      MERGE INTO lea_estm_cost_if m 
         USING ( 
                  SELECT /*+ parallel(i) */ 
                         i.ROWID RID 
                    FROM lea_estm_cost_if i,  
                         (SELECT rev_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, 
                               SUBSTR(MAX(exe_yrmon||estm_vvd_tp_cd), 7, 2) last_estm_vvd_tp_cd, 
                               estm_ioc_div_cd,estm_vvd_hdr_id 
                        FROM   gl_estm_rev_vvd 
                        WHERE  estm_bc_div_cd = 'C'  --By Container 
        --                  AND  exe_yrmon      = exe_yrmon_in --R.VVD가 수행년월별(EXE_YRMON)로 누적되어야 됨!!! 
                          AND  exe_yrmon  in ( exe_yrmon_in , TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in,'yyyymm') ,-12 ), 'yyyy') || '12')  
                          AND  rev_yrmon >= CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03') 
                                                    THEN to_char(add_months(to_date(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm')  
                                                 ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01' 
                                            END                                       
 --                  AND  rev_yrmon BETWEEN '200801' AND TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -1), 'yyyymm')    
                        GROUP BY rev_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, estm_ioc_div_cd, estm_vvd_hdr_id ) v, 
                         lea_lgs_cost c 
                   WHERE 1=1   
--                     AND v.exe_yrmon       = exe_yrmon_in        --Execute Year Month(Parameter) 
                     --AND v.rev_yrmon      >= '200710'            --2007년10월 이후부터 화물변동비 수입 시점으로 잡음 : 2007년4분기까지 유지 2008.02.11 이경한 대리 
--                     AND v.rev_yrmon      >= '200801'              --2008년01월 이후부터 화물변동비 수입 시점으로 잡음 : 2008.03.10 이경한 대리 
--                     AND v.exe_yrmon  in ( exe_yrmon_in , TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in,'yyyymm') ,-12 ), 'yyyy') || '12')  
                     AND v.rev_yrmon >= CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03') 
                                                    THEN TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm')  
                                                    ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01' 
                                        END                               
                     AND v.vsl_cd          = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'CFDR', i.vsl_cd) -- RBC Lane R.VVD:CFDRyymmEE,  IOC:XX 
                     AND v.skd_voy_no      = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', SUBSTR (i.vsl_cd || i.skd_voy_no , 3, 4), i.skd_voy_no) --년월(2007.03) => 0703 
                     AND v.skd_dir_cd      = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'E', i.skd_dir_cd) 
                     AND v.rev_dir_cd      = DECODE(SUBSTR (i.vsl_cd, 1, 2), 'FD', 'E', i.rev_dir_cd)                                                        
                     AND v.estm_ioc_div_cd = i.estm_ioc_div_cd   --IOC 일치                       
                     AND c.coa_cost_src_cd = i.coa_cost_src_cd   --Cost Code 
                     AND c.accl_auto_cd    = 'A'                 --Auto Accrual 만 COA에서 가져옴(Manual, Transfer 안가져옴) 
                     AND c.delt_flg        = 'N'                 --Delete not Cost code 
                     AND ( 
                            (  
--                              i.estm_tgt_flg    = 'N'            --추정 대상으로 선택하지 않은 것중(수행년월별로 Rev년월별 R.VVD가 반복되기 때문에 대상확인이 필요, 중복회피) 
--                              AND 
                              i.estm_upd_flg    = 'Y' 
                            ) 
                            OR i.bat_st_dt      = exe_yrmon_in   --수행년월의 반복 배치 작업 대상 
                         ) 
                     AND ( 
                             (  
                                i.bkg_sts_cd IN ('F', 'W') 
                             )   
                          OR (  --수행년월 기간 동안 Cancel처리된 Split,  
                                 ( i.bkg_sts_cd = 'X' OR i.bkg_sts_cd = 'S' ) AND i.bkg_split_cd IS NOT NULL 
                             ) 
                          OR (  --Combine Booking도 Actual Mapping을 위해 가져옴  
                                i.bkg_sts_cd = 'X' AND i.cmb_bkg_no IS NOT NULL 
                             ) 
                         ) 
                     ORDER BY RID 
                 ) v 
         ON (    m.ROWID = v.RID ) 
         WHEN MATCHED THEN 
            UPDATE  
               SET m.estm_tgt_flg = 'Y',   --추정대상으로 선택됨 
                   m.estm_upd_flg = 'N',   --Update 처리 완료 Y -> N 
                   m.bat_st_dt    = exe_yrmon_in --수행년월의 반복 배치 작업 대상 
        ; 
    
      v_row_knt := SQL%ROWCOUNT ; 
       
      Commit; 
       
      lea_log_prc ('End update estimated Target Flag(N->Y) count:'||v_row_knt); 
      APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_ESTM_PRC:UPDATE_TARGET 완료('||v_row_knt||')') ; -- 시간 측정을 위한 디버깅 코드 
                              
   END IF;                        
   lea_bkup_pkg.set_table_index_logging_prc('LEA_ACCL_DTL', TRUE) ; 
   lea_log_prc('lea_bat_pkg.g_bat_id:' || lea_bat_pkg.g_bat_id); 
    
   --Batch History Record setting 
   v_bat_his_rec.exe_yrmon := exe_yrmon_in; 
   v_bat_his_rec.bat_id := bat_id_in; 
   --v_bat_his_rec.estm_knt := SQL%ROWCOUNT;   --Insert Row Count 
   v_bat_his_rec.estm_end_dt := SYSDATE;   --Estimate data insert end date 
   lea_log_prc ('LEA_ACCL_DTL Insert Count:' || v_bat_his_rec.estm_knt); 
   v_rtn_val := lea_accl_bat_his_fnc (v_bat_his_rec, 'BE'); 
   lea_log_prc ('lea_accl_estm_prc() end.');    --Batch History Estimate(Update) 
    
   /* Exception -----------------------------------------------------------------*/ 
   EXCEPTION 
   WHEN OTHERS 
   THEN 
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);         
END;