CREATE OR REPLACE PROCEDURE LEAADM.lea_accl_act_smry_prc (exe_yrmon_in IN VARCHAR, bat_id_in IN VARCHAR)
IS
/*******************************************************************************
  1.Name       : 김상모
  2.Create Date: 2007-02-02
  3.Description:
      - 용도: LEA_ACT_COST_IF 에서 Account code 별로 Summary(PRE Cost Amount) 결과를
              LEA_ACCT_COST_AMT에 Merge(Insert or Update) 처리
      - 파라미터: 실행수행년월(in_exeyrmon(Format:'YYYYMM'))
      - 특이사항
        (1) Summary
  4.Revision History
    2007-02-22:김상모:최초생성.
    2008-03-10:김상모:결산기간을 2월 수행년월 부터 2008.01월 반영(HardCoding) : '200710'->'200801'
    2009-01-21:전재홍:Exe.Yrmon가 1,2,3 월일경우 Rev.Month 는 전년도 각각 10,11,12 월부터  
               포함하도록 로직반영(수행월 관계없이-rev.month 와 동일하게)
*******************************************************************************/
/* Variable Declare ------------------------------------------------------------*/
   v_bat_his_rec   lea_bat_pkg.bat_his_rec;   --Batch Hostory Record
   v_rtn_val       VARCHAR2 (1);
   v_row_knt       NUMBER := 0;

BEGIN
   lea_log_prc ('lea_accl_act_smry_prc() Start.');
   
   v_bat_his_rec.estm_st_dt := SYSDATE;   --Estimate data insert start date
   
   MERGE INTO lea_acct_cost_amt a
      USING ( SELECT /*+ Parallel(i) */   
                     exe_yrmon_in exe_yrmon, --수행 년월별 누적치를 Summary 
                     i.rev_yrmon, i.acct_cd, c.accl_auto_cd, SUM (i.usd_cost_amt) pre_act_cost_amt
                FROM lea_act_cost_if i,
                (
                  SELECT DISTINCT ACCL_AUTO_CD ACCL_AUTO_CD, ACCT_CD ACCT_CD, COA_COST_SRC_CD COA_COST_SRC_CD                                      
                  FROM LEA_LGS_COST                                                                                     
                  WHERE ACCL_FLG = 'Y' --화물변동비 관련 계정(Account Code: 512xxx 로 시작됨)만 Actual cost로 잡음                                                                              
                  UNION ALL                                                                                             
                  SELECT DISTINCT 'M' ACCL_AUTO_CD, OTR_CRR_ACCT_CD ACCT_CD, COA_COST_SRC_CD COA_COST_SRC_CD --타선사용 Account code(Manual)                         
                  FROM LEA_LGS_COST                                                                                     
                  WHERE OTR_CRR_ACCT_CD IS NOT NULL
                ) c
                WHERE i.acct_cd = c.acct_cd
                  AND i.coa_cost_src_cd = c.coa_cost_src_cd
--                  AND i.exe_yrmon BETWEEN SUBSTR(exe_yrmon_in, 1, 4)||'01' AND exe_yrmon_in
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
             GROUP BY i.rev_yrmon, i.acct_cd, c.accl_auto_cd ) u   --View Table
      ON (     a.exe_yrmon    = u.exe_yrmon
           AND a.rev_yrmon    = u.rev_yrmon
           AND a.acct_cd      = u.acct_cd
           AND a.accl_auto_cd = u.accl_auto_cd)
      WHEN MATCHED THEN   --중복시 Actual Cost만 Update 처리
         UPDATE
            SET a.pre_act_cost_amt = u.pre_act_cost_amt,
                a.pst_act_cost_amt = DECODE(a.accl_auto_cd, 'A', a.pst_act_cost_amt, u.pre_act_cost_amt), --Manual, Transfer Accout Code 에 대해서는 PRE, POST 금액을 같게 처리함!!
                a.upd_usr_id = 'ACT_SMRY_U',
                a.upd_dt = SYSDATE
      WHEN NOT MATCHED THEN   --중복이 없을시 Insert 처리
         INSERT (a.exe_yrmon,
                 a.rev_yrmon, 
                 a.acct_cd, 
                 a.accl_auto_cd, 
                 a.pre_act_cost_amt, 
                 a.pst_act_cost_amt, 
                 cre_usr_id, 
                 cre_dt, 
                 upd_usr_id, 
                 upd_dt)
         VALUES (u.exe_yrmon, 
                 u.rev_yrmon, 
                 u.acct_cd, 
                 u.accl_auto_cd, 
                 u.pre_act_cost_amt, 
                 DECODE(u.accl_auto_cd, 'A', 0, u.pre_act_cost_amt), 
                 'ACT_SMRY_I', 
                 SYSDATE, 
                 'ACT_SMRY_I', 
                 SYSDATE)
         ;
   
   v_row_knt := SQL%ROWCOUNT ;

   Commit;
   
   --lea_act_cost_if->lea_acct_cost_amt Summary Insert
   lea_log_prc ('lea_accl_act_smry_prc() End.('||v_row_knt||')');
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_ACT_SMRY_PRC 완료') ; -- 시간 측정을 위한 디버깅 코드   

   /* Exception -----------------------------------------------------------------*/
   EXCEPTION
   WHEN OTHERS
   THEN
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);        

END;