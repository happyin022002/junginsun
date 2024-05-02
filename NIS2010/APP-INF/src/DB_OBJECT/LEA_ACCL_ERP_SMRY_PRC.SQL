CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACCL_ERP_SMRY_PRC (exe_yrmon_in IN VARCHAR, bat_id_in IN VARCHAR)
IS
/*******************************************************************************
  1.Object Name     : LEA_ACCL_ERP_SMRY_PRC
  2.Version         : 1.0
  3.Create Date     : 2007-03-02
  4.Sub System      : Logistics Expense Accrual
  5.Author          : 전재홍
  6.Description     : 추정결산 처리된 LEA_ACCL_DTL에서 최종 Layout for ERP 으로 Summary
                      GL_ACCL_IF에 Insert 처리
  7.Revision History 
    2007-02-25 : - 김상모 최초생성.
    2008-03-10 : - 결산기간을 2월 수행년월 부터 2008.01월 반영(HardCoding) : '200710'->'200801'   
    2008-03-25 : - VVD type에 관계 없이 bkg status가 'F', 'W' 인 것 모두 Summary 대상
    2008-04-21 : - 전재홍 : Manual 금액 summary 시 Cost Code Join 누락으로 인한
                   Actual 금액 과다생성 부분 수정보완
    2008-06-02 : - Act_Cost_AMT 에 따라 ESTM_COST_AMT 를 대체하여 Summary.
    2008-07-08 : - Unplaned S/O 관련 UnMapping Actual Data 를 Summary 에 추가.
                   (CRE_USER_ID = 'ERP_SMRY_3')
    2009-01-21 : - Exe.Yrmon가 1,2,3 월일경우 Rev.Month 는 전년도 각각 10,11,12 월 부터 
                   포함하도록 로직반영  (ACTUAL DATA는 수행월 관계없이 필요함)
    2009-09-24 : - Unplaned S/O 관련 UnMapping Actual Data 처리시
                   IOC, VVD TYPE 을 VVD의 Maximum 값으로 생성.
    2009-10-20 : - 'S' Summary 의 경우(CRE_USR_ID = 'ERP_SMRY_3') 
                   ESTM_VVD_TP_CD, ESTM_IOC_DIV_CD 은 Max 값으로 참조하여 Summary 한다.
    2010-02-25 : - 전용터미널 추가하여 Summary
                   USLGBPT, USOAKM1, USSEAM1, TWKHHHT
    2010-04-09 : - BKG_NO_SPLIT 제거
    2011-04-06 : - 1. LEA_ACCL_DTL(Auto Account Code) 에서 GL_ACCL_IF 로 Summary 처리 로직 수정
 		    - Estimate 금액은 LEA_ACCL_DTL 금액 그대로 업데이트 처리
 		    - CRE_USR_ID를 ERP_SMRY_NO, ERP_SMRY_NB, ERP_SMRY_LO, ERP_SMRY_LB 로 구분해서 저장.
 		   2. Mapping 처리시 unpland s/o 관련해서 actual data 기반으로 summary 로직 수정
 		    - lea_act_cost_if 의 Actual 금액을 Estimate 금액으로 업데이트 하지 말고 무조건 0 처리함.
*******************************************************************************/
/* Variable Declare -------------------------------------------------------*/
   v_bat_his_rec   lea_bat_pkg.bat_his_rec;   --Batch History Record
   v_rtn_val       VARCHAR2 (1);
   v_row_knt       NUMBER; -- 유효자릿수 38자리
   
BEGIN
   lea_log_prc ('lea_accl_erp_smry_prc() Start.');
   v_bat_his_rec.estm_st_dt := SYSDATE;   --Estimate data insert start date

   /* 재실행시 삭제 처리(특정 수행년월의 데이터만 SnapShut 처리함) */
   EXECUTE IMMEDIATE 'TRUNCATE TABLE gl_accl_if'; --Comment이유: 수행년월별로 보존, 퍼지우선 대상 테이블!!

   lea_log_prc ('Complete Truncate gl_accl_if');
   
--   EXECUTE IMMEDIATE 'alter session enable parallel dml' ;

--   /* 실행년월은 유일함(재실행시 삭제 처리) */
--   DELETE /*+ Parallel(a,36) Nologging */
--          gl_accl_if a
--   WHERE a.exe_yrmon = exe_yrmon_in;
--   
--   Commit; --PDML 뒤 반드시 Commit 처리 할것
--   
--   EXECUTE IMMEDIATE 'alter table gl_accl_if deallocate unused' ; --Remove delete space
      
   /*---------------------------------------------------------------------------
      *** GL_ACCL_IF Table's Index Script 
   
      --UI에서 메뉴얼 저장시 Max Sequence 를 구하기 위함
      CREATE INDEX xak1gl_accl_if ON gl_accl_if 
      (exe_yrmon, accl_seq)
      TABLESPACE ts_lea_i;

      --UI에서 메뉴얼 저장시 특정 CRE_USR_ID ('UI_MNL_SAV')로 생성된 데이터를 지우기 위해서 사용
      --CRE_USR_ID의 Distinct는 3임으로 전체대비 10% 미만인 경우 BITMAP Index를 사용하기 권장함
      CREATE BITMAP INDEX xak2gl_accl_if ON gl_accl_if
      (exe_yrmon, cre_usr_id);
      TABLESPACE ts_lea_i;
   ---------------------------------------------------------------------------*/   
   /* Index UNUSABLE 처리 */
   EXECUTE IMMEDIATE 'Alter Index XAK1GL_ACCL_IF UNUSABLE'; --Non Unique Index(Unique Index는 UnUsable 처리할수 없음)
   EXECUTE IMMEDIATE 'Alter Index XAK2GL_ACCL_IF UNUSABLE'; --BitMap Index

   EXECUTE IMMEDIATE 'alter session enable parallel dml' ;
   
   /* LEA_ACCL_DTL(Auto Account Code) 에서 GL_ACCL_IF 로 Summary 처리 */
   INSERT /*+ Append */ INTO gl_accl_if
   (exe_yrmon      , sys_src_id     , rev_yrmon      , acct_cd        , accl_seq       , biz_ut_id      ,
    vsl_cd         , skd_voy_no     , skd_dir_cd     , rev_dir_cd     , estm_vvd_tp_cd , estm_ioc_div_cd,
    estm_vvd_hdr_id, estm_bc_div_cd , nod_cd         , estm_cost_amt  , act_cost_amt   , accl_cost_amt  ,
    bkg_no         , cntr_tpsz_cd   ,
    cre_usr_id     , cre_dt         , upd_usr_id     , upd_dt)   
   SELECT exe_yrmon, sys_src_id, rev_yrmon, acct_cd, ROWNUM, biz_ut_id,
          vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, last_estm_vvd_tp_cd, estm_ioc_div_cd, 
          estm_vvd_hdr_id, estm_bc_div_cd, nod_cd, SUM.estm_cost_amt, SUM.act_cost_amt, SUM.accl_cost_amt,
          bkg_no, cntr_tpsz_cd,
          cre_usr_id, cre_dt, upd_usr_id, upd_dt
     FROM (SELECT   
                    exe_yrmon_in exe_yrmon,   --Execute Year month
                    'ESD' sys_src_id,    --Sub System code(ERP에서 정의한 코드임)
                    T.vvd_rev_yrmon rev_yrmon,
                    T.acct_cd,
                    'CNTR' biz_ut_id,    --Biz unit ID
                    T.vsl_cd,
                    T.skd_voy_no,
                    T.skd_dir_cd,
                    T.rev_dir_cd,
                    T.last_estm_vvd_tp_cd,    --GL_ESTM_REV_VVD.ESTM_VVD_TP_CD
                    T.estm_ioc_div_cd,        --GL_ESTM_REV_VVD.ESTM_BC_DIV_CD
                    T.estm_vvd_hdr_id,
                    --v.estm_bc_div_cd,
                    'C' estm_bc_div_cd,       --Only Container
                    T.nod_cd nod_cd,
                    SUM (NVL(T.estm_cost, 0 )) estm_cost_amt,
                    SUM (NVL(T.act_cost_amt, 0)) act_cost_amt,
                    SUM (NVL(T.accl_cost_amt, 0)) accl_cost_amt,
                    T.bkg_no,
                    T.cntr_tpsz_cd,
                    -- 2011-04-06 CRE_USR_ID를 ERP_SMRY_NO, ERP_SMRY_NB, ERP_SMRY_LO, ERP_SMRY_LB 로 구분해서 저장. 
                    T.type_cd cre_usr_id,
                    SYSDATE cre_dt,
                    -- 2011-04-06 CRE_USR_ID를 ERP_SMRY_NO, ERP_SMRY_NB, ERP_SMRY_LO, ERP_SMRY_LB 로 구분해서 저장. 
                    T.type_cd upd_usr_id,
                    SYSDATE upd_dt
               FROM (SELECT  /*+ Parallel(d) leading(v) use_hash(v d) */ d.* ,
                                case
                                   when d.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' , 'KRPUSKC', 'JPTYOY1', 'JPOSAY1',
                                                          'USLGBPT' , 'USOAKM1' , 'USSEAM1' , 'TWKHHHT')
                                   then d.n1st_nod_cd 
                                   else SUBSTR (NVL (d.n1st_nod_cd, 'HQCOL'), 1, 5)
                                end nod_cd, --nod_cd(Default: HQCOL)
-- 2011-04-06 Estimate 금액은 LEA_ACCL_DTL 금액 그대로 업데이트 처리
--                                case
--                                        when NVL(d.act_cost_amt, 0) <= 0 
--                                            then d.estm_cost_amt
--                                        when NVL(d.act_cost_amt, 0) > 0
--                                            and NVL(d.act_inv_knt, 0) > NVL(d.ttl_inv_knt, 0)
--                                            and NVL(d.act_cntr_cost_amt , 0 ) = 0 
--                                            and substr(d.accl_lgc_tp_cd, 1, 1) = 'L'
--                                            then d.estm_cost_amt
--                                        when NVL(d.act_cost_amt, 0) > 0 
--                                            and NVL(d.act_inv_knt, 0) <= NVL(d.ttl_inv_knt, 0) 
--                                            and NVL(d.estm_cost_amt , 0)  >= NVL(d.act_cost_amt , 0 ) 
--                                            and NVL(d.accl_cost_amt, 0) <> 0  
--                                            then d.estm_cost_amt
--                                        else d.act_cost_amt
--                                end estm_cost,
				d.estm_cost_amt estm_cost,
                                v.vvd_rev_yrmon,
                                v.last_estm_vvd_tp_cd,
                                v.estm_vvd_hdr_id,
                                -- 2011-04-06 CRE_USR_ID를 ERP_SMRY_NO, ERP_SMRY_NB, ERP_SMRY_LO, ERP_SMRY_LB 로 구분해서 저장.   
                                DECODE(d.ACCL_LGC_TP_CD, 'NB', 'ERP_SMRY_1_NB', 'NO', 'ERP_SMRY_1_NO', 'LO', 'ERP_SMRY_1_LO', 'LB', 'ERP_SMRY_1_LB', 'ERP_SMRY_1') AS type_cd
                        FROM lea_accl_dtl d ,  
                            ( --최신 수행년월에 해당하는 항차타입으로만 집계
                               SELECT /*+ no_merge */
                                      DISTINCT rev_yrmon vvd_rev_yrmon , vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, 
                                      SUBSTR(MAX(exe_yrmon||estm_vvd_tp_cd), 7, 2) last_estm_vvd_tp_cd,
                                      estm_ioc_div_cd, estm_vvd_hdr_id
                               FROM  gl_estm_rev_vvd
                               WHERE estm_bc_div_cd = 'C'
                               AND  exe_yrmon  in ( exe_yrmon_in , TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in,'yyyymm') ,-12 ), 'yyyy') || '12') 
--                               AND   rev_yrmon     >= '200801'  
                               AND rev_yrmon >= CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03')
                                                      THEN to_char(add_months(to_date(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm') 
                                                     ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01'
                                                END             
                               GROUP BY rev_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, estm_ioc_div_cd, estm_vvd_hdr_id
                            ) v
                      WHERE 1=1
                        AND v.vsl_cd          = d.vsl_cd
                        AND v.skd_voy_no      = d.skd_voy_no
                        AND v.skd_dir_cd      = d.skd_dir_cd
                        AND v.rev_dir_cd      = d.rev_dir_cd
                        --AND v.estm_vvd_tp_cd  = d.estm_vvd_tp_cd
                        AND v.estm_ioc_div_cd = d.estm_ioc_div_cd
                        AND d.delt_flg        = 'N'
                        AND d.bkg_sts_cd      IN ('F', 'W') --VVD type에 관계 없이 bkg status가 'F', 'W' 인 것 모두 Summary 대상
                        AND NOT(d.estm_cost_amt = 0 AND NVL(d.act_cost_amt, 0) = 0) 
                        )T
           GROUP BY exe_yrmon_in,        --Execute Year month
                    T.vvd_rev_yrmon ,
                    T.acct_cd,
                    T.vsl_cd,
                    T.skd_voy_no,
                    T.skd_dir_cd,
                    T.rev_dir_cd,
                    T.last_estm_vvd_tp_cd,    --GL_ESTM_REV_VVD.ESTM_VVD_TP_CD
                    T.estm_ioc_div_cd,        --GL_ESTM_REV_VVD.ESTM_BC_DIV_CD
                    T.estm_vvd_hdr_id,
                    --v.estm_bc_div_cd,
                    T.nod_cd,
                    T.bkg_no,
                    T.cntr_tpsz_cd,
                    -- 2011-04-06 CRE_USR_ID를 ERP_SMRY_NO, ERP_SMRY_NB, ERP_SMRY_LO, ERP_SMRY_LB 로 구분해서 저장.   
                    T.type_cd) SUM
                    ;
                    
   v_row_knt := SQL%ROWCOUNT;
   
   Commit; --Append 뒤에는 반드시 Commit 처리!!
   
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_ERP_SMRY_PRC:ACCL_DTL 완료('||v_row_knt||')') ; -- 시간 측정을 위한 디버깅 코드
   

   /* LEA_ACT_COST_IF 에서 Manual, Tranfer 계정에 해당하는 Actual Cost를 가져와 Insert 처리 */
   INSERT /*+ Append */ INTO gl_accl_if
   (exe_yrmon, sys_src_id, rev_yrmon, acct_cd, accl_seq, biz_ut_id, vsl_cd,
    skd_voy_no, skd_dir_cd, rev_dir_cd, estm_vvd_tp_cd, estm_ioc_div_cd, estm_vvd_hdr_id,
    estm_bc_div_cd, nod_cd, act_cost_amt, cre_usr_id, cre_dt, upd_usr_id, upd_dt)
   SELECT v.exe_yrmon, sys_src_id, rev_yrmon, acct_cd, (v_row_knt + ROWNUM), biz_ut_id, vsl_cd,
          skd_voy_no, skd_dir_cd, rev_dir_cd, estm_vvd_tp_cd, estm_ioc_div_cd, estm_vvd_hdr_id,
          estm_bc_div_cd, nod_cd, act_cost_amt, cre_usr_id, cre_dt, upd_usr_id, upd_dt
     FROM (SELECT   /*+ Parallel(i) */
                    exe_yrmon_in exe_yrmon,
                    'ESD' sys_src_id,
                    i.rev_yrmon, 
                    i.acct_cd, 
                    'CNTR' biz_ut_id, 
                    i.vsl_cd,
                    i.skd_voy_no, 
                    i.skd_dir_cd, 
                    i.rev_dir_cd, 
                    'RV' estm_vvd_tp_cd,
                    'XX' estm_ioc_div_cd, 
                    '99999' estm_vvd_hdr_id,
                    'C' estm_bc_div_cd,
                    case
                       when i.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' , 'KRPUSKC', 'JPTYOY1', 'JPOSAY1',
                                              'USLGBPT' , 'USOAKM1' , 'USSEAM1' , 'TWKHHHT')
                       then i.n1st_nod_cd 
                       else SUBSTR (NVL (i.n1st_nod_cd, 'HQCOL'), 1, 5)
                    end nod_cd,   --nod_cd(Default: HQCOL)
                    SUM (NVL(i.usd_cost_amt, 0)) act_cost_amt,
                    'ERP_SMRY_2' cre_usr_id,
                    SYSDATE cre_dt,
                    'ERP_SMRY_2' upd_usr_id,
                    SYSDATE upd_dt
               FROM lea_act_cost_if i, lea_lgs_cost c               
              WHERE i.coa_cost_src_cd = c.coa_cost_src_cd
                AND case when i.otr_crr_flg = 'Y' and i.acct_cd = c.otr_crr_acct_cd 
                           then c.otr_crr_accl_auto_cd
                         when i.otr_crr_flg = 'N' and i.acct_cd = c.acct_cd
                           then c.accl_auto_cd 
                         else 'A'
                    end in ('M','T')
--                AND i.exe_yrmon BETWEEN SUBSTR (exe_yrmon_in, 1, 4) || '01' AND exe_yrmon_in
--                AND i.rev_yrmon BETWEEN SUBSTR (exe_yrmon_in, 1, 4) || '01' AND exe_yrmon_in
                AND i.exe_yrmon BETWEEN CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03')
                                                THEN TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm') 
                                             ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01'
                                        END
                                AND exe_yrmon_in
                AND i.rev_yrmon BETWEEN CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03')
                                                THEN TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm') 
                                             ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01'
                                        END
                                AND exe_yrmon_in
           GROUP BY i.exe_yrmon,
                    i.rev_yrmon,
                    i.acct_cd,
                    i.vsl_cd,
                    i.skd_voy_no,
                    i.skd_dir_cd,
                    i.rev_dir_cd,
                    case
                       when i.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' , 'KRPUSKC', 'JPTYOY1', 'JPOSAY1',
                                              'USLGBPT' , 'USOAKM1' , 'USSEAM1' , 'TWKHHHT')
                       then i.n1st_nod_cd 
                       else SUBSTR (NVL (i.n1st_nod_cd, 'HQCOL'), 1, 5)
                    end   --nod_cd(Default: HQCOL)
           ) v
            ;
            
   v_row_knt := v_row_knt + SQL%ROWCOUNT ;
               
   Commit; --Append 뒤에는 반드시 Commit 처리!!

   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_ERP_SMRY_PRC:M,T 완료('||v_row_knt||')') ; -- 시간 측정을 위한 디버깅 코드   
   
   /* Mapping 처리시 unpland s/o 관련해서 actual data 기반으로 summary 함.*/
   INSERT /*+ Append */ INTO gl_accl_if
   (exe_yrmon      , sys_src_id     , rev_yrmon      , acct_cd        , accl_seq       , biz_ut_id      ,
    vsl_cd         , skd_voy_no     , skd_dir_cd     , rev_dir_cd     , 
    estm_vvd_tp_cd , estm_ioc_div_cd, estm_vvd_hdr_id, estm_bc_div_cd , 
    nod_cd         , estm_cost_amt  , act_cost_amt   , accl_cost_amt  ,
    bkg_no         , cntr_tpsz_cd   ,
    cre_usr_id     , cre_dt         , upd_usr_id     , upd_dt)         
        SELECT  exe_yrmon, sys_src_id, rev_yrmon, acct_cd, ( v_row_knt + ROWNUM), biz_ut_id, 
                vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, 
                estm_vvd_tp_cd, estm_ioc_div_cd, estm_vvd_hdr_id, 'C', 
                nod_cd, SUM.estm_cost_amt, SUM.act_cost_amt, SUM.accl_cost_amt,
                bkg_no, cntr_tpsz_cd,
                cre_usr_id, cre_dt, upd_usr_id, upd_dt 
        FROM (  SELECT  
                    exe_yrmon_in exe_yrmon,  
                    'ESD' sys_src_id,   
                    DECODE(a.new_bkg_no, null, a.rev_yrmon, a.new_rev_yrmon) rev_yrmon,
                    a.acct_cd,
                    'CNTR' biz_ut_id,   
                    DECODE(a.new_bkg_no, null, a.vsl_cd, b.vsl_cd) vsl_cd ,
                    DECODE(a.new_bkg_no, null, a.skd_voy_no , b.skd_voy_no) skd_voy_no ,
                    DECODE(a.new_bkg_no, null, a.skd_dir_cd, b.skd_dir_cd) skd_dir_cd ,
                    DECODE(a.new_bkg_no, null, a.rev_dir_cd, b.rev_dir_cd) rev_dir_cd , 
                    v.last_estm_vvd_tp_cd estm_vvd_tp_cd,
                    v.estm_ioc_div_cd estm_ioc_div_cd,
                    v.estm_vvd_hdr_id estm_vvd_hdr_id,
                    case
                       when a.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' , 'KRPUSKC', 'JPTYOY1', 'JPOSAY1',
                                              'USLGBPT' , 'USOAKM1' , 'USSEAM1' , 'TWKHHHT')
                       then a.n1st_nod_cd 
                       else SUBSTR (NVL (a.n1st_nod_cd, 'HQCOL'), 1, 5)
                    end nod_cd,   --nod_cd(Default: HQCOL)
                    -- 2011-04-06 lea_act_cost_if 의 Actual 금액을 Estimate 금액으로 업데이트 하지 말고 무조건 0 처리함.
                    --SUM (NVL(a.usd_cost_amt, 0)) estm_cost_amt,
                    0 estm_cost_amt,
                    SUM (NVL(a.usd_cost_amt, 0)) act_cost_amt,
                    0 accl_cost_amt,
                    DECODE(a.new_bkg_no, null, a.bkg_no, a.new_bkg_no) bkg_no,
                    a.cntr_tpsz_cd,
                    'ERP_SMRY_3' cre_usr_id,
                    SYSDATE cre_dt,
                    'ERP_SMRY_3' upd_usr_id,
                    SYSDATE upd_dt
               FROM lea_act_cost_if a ,
                    (SELECT rev_yrmon vvd_rev_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, last_estm_vvd_tp_cd, estm_ioc_div_cd, estm_vvd_hdr_id
                    FROM    (SELECT rev_yrmon , vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, last_estm_vvd_tp_cd, estm_ioc_div_cd, estm_vvd_hdr_id ,
                                    ROW_NUMBER() OVER ( PARTITION BY rev_yrmon , vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd 
                                                        ORDER BY last_estm_vvd_tp_cd, estm_ioc_div_cd DESC ) row_pos
                            FROM  ( SELECT /*+ no_merge */
                                        DISTINCT rev_yrmon , vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, estm_ioc_div_cd,
                                        SUBSTR(MAX(exe_yrmon||estm_vvd_tp_cd), 7, 2) last_estm_vvd_tp_cd, 
                                        estm_vvd_hdr_id
                                    FROM  gl_estm_rev_vvd
                                    WHERE estm_bc_div_cd = 'C'
                                    AND exe_yrmon  in ( exe_yrmon_in , TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in,'yyyymm') ,-12 ), 'yyyy') || '12') 
                                    AND rev_yrmon >=    CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03')
                                                                THEN to_char(add_months(to_date(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm') 
                                                             ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01'
                                                        END             
                                    GROUP BY rev_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd , estm_ioc_div_cd, estm_vvd_hdr_id )
                            )
                    WHERE row_pos = 1 ) v ,
                    lea_cntr_bkg_his b  
              WHERE 1=1
--                AND a.exe_yrmon BETWEEN SUBSTR (exe_yrmon_in, 1, 4) || '01' AND exe_yrmon_in
--                AND a.rev_yrmon BETWEEN SUBSTR (exe_yrmon_in, 1, 4) || '01' AND exe_yrmon_in
                AND a.exe_yrmon BETWEEN CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03')
                                                THEN TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm') 
                                             ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01'
                                        END
                                AND exe_yrmon_in     
                AND a.rev_yrmon BETWEEN CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03')
                                                THEN TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm') 
                                             ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01'
                                        END
                                AND exe_yrmon_in     
                AND a.act_cost_mapg_cd = 'S' --Error Summary 대상
                
                AND DECODE(a.new_bkg_no, null, a.rev_yrmon, a.new_rev_yrmon) = v.vvd_rev_yrmon
                AND DECODE(a.new_bkg_no, null, a.vsl_cd, b.vsl_cd) = v.vsl_cd 
                AND DECODE(a.new_bkg_no, null, a.skd_voy_no , b.skd_voy_no) = v.skd_voy_no 
                AND DECODE(a.new_bkg_no, null, a.skd_dir_cd, b.skd_dir_cd) = v.skd_dir_cd 
                AND DECODE(a.new_bkg_no, null, a.rev_dir_cd, b.rev_dir_cd) = v.rev_dir_cd  
                
                AND DECODE(a.new_bkg_no , null, a.bkg_no , a.new_bkg_no ) = b.bkg_no
                AND a.cntr_no = b.cntr_no
                
           GROUP BY exe_yrmon_in,        --Execute Year month
                    DECODE(a.new_bkg_no, null, a.rev_yrmon, a.new_rev_yrmon),
                    a.acct_cd,
                    DECODE(a.new_bkg_no, null, a.vsl_cd, b.vsl_cd),
                    DECODE(a.new_bkg_no, null, a.skd_voy_no , b.skd_voy_no),
                    DECODE(a.new_bkg_no, null, a.skd_dir_cd, b.skd_dir_cd),
                    DECODE(a.new_bkg_no, null, a.rev_dir_cd, b.rev_dir_cd),
                    v.last_estm_vvd_tp_cd ,
                    v.estm_ioc_div_cd ,
                    v.estm_vvd_hdr_id ,
                    case
                       when a.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' , 'KRPUSKC', 'JPTYOY1', 'JPOSAY1',
                                              'USLGBPT' , 'USOAKM1' , 'USSEAM1' , 'TWKHHHT')
                       then a.n1st_nod_cd 
                       else SUBSTR (NVL (a.n1st_nod_cd, 'HQCOL'), 1, 5)
                    end,   --nod_cd(Default: HQCOL)
                    DECODE(a.new_bkg_no , null, a.bkg_no, a.new_bkg_no),
                    a.cntr_tpsz_cd
            ) SUM
            ;
            
    v_row_knt := v_row_knt + SQL%ROWCOUNT ;
    
    Commit;     

   /* Index USABLE 처리 */
   EXECUTE IMMEDIATE 'Alter Index XAK1GL_ACCL_IF ReBuild PARALLEL NOLOGGING'; --Parallel 숫자 튜닝 필요!!
   EXECUTE IMMEDIATE 'Alter Index XAK2GL_ACCL_IF ReBuild PARALLEL NOLOGGING';
   
   EXECUTE IMMEDIATE 'Alter Index XAK1GL_ACCL_IF NOPARALLEL LOGGING'; --Alter Parallel 뒤엔 반드시 noparallel 처리할것!! 
   EXECUTE IMMEDIATE 'Alter Index XAK2GL_ACCL_IF NOPARALLEL LOGGING';
               
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_ERP_SMRY_PRC:IDX_REBUILD 완료') ; -- 시간 측정을 위한 디버깅 코드
      
   --Batch History Record setting
--   v_bat_his_rec.exe_yrmon := exe_yrmon_in;
--   v_bat_his_rec.bat_id := bat_id_in;
--   v_bat_his_rec.estm_knt := SQL%ROWCOUNT;                                              --Insert Row Count
--   v_bat_his_rec.estm_end_dt := SYSDATE;                                    --Estimate data insert end date
--   v_rtn_val := lea_accl_bat_his_fnc (v_bat_his_rec, 'S1');              --Batch History Estimate(Update)
--   lea_log_prc('lea_accl_dtl->gl_accl_if Summary RowCount: '|| SQL%ROWCOUNT);
   lea_log_prc ('lea_accl_erp_smry_prc() End.');
   
   /* Exception -----------------------------------------------------------------*/
   EXCEPTION
   WHEN OTHERS
   THEN
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE); 
      
END;