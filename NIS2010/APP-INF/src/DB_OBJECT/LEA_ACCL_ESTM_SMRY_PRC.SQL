CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACCL_ESTM_SMRY_PRC (exe_yrmon_in IN VARCHAR, bat_id_in IN VARCHAR)
IS
/*******************************************************************************
  1.Name       : 김상모
  2.Create Date: 2007-02-20
  3.Description:
      - 용도: 추정결산 처리된 LEA_ACCL_DTL에서 Account code 별로 Summary 처리 하여
                 LEA_ACC_COST_AMT에 Insert 처리
      - 파라미터: 실행수행년월(in_exeyrmon(Format:'YYYYMM'))
      - 특이사항
        (1) Manual Accrual Account code 와 분리하여 관리 처리함
  4.Revision History
    2007-02-20:김상모:최초생성.
    2008-03-10:김상모:결산기간을 2월 수행년월 부터 2008.01월 반영(HardCoding) : '200801'
    2008-03-25:김상모:Firm, Waiting 인 Booking만 추정으로 잡음       
    2009-01-21:전재홍:Exe.Yrmon가 1,2,3 월일경우 Rev.Month 는 전년도 각각 10,11,12 월부터   
                      포함하도록 로직으로 반영 (PV 필요하므로 TO 는 규정하지 않음)
*******************************************************************************/
/* Variable Declare -------------------------------------------------------*/
   v_bat_his_rec   lea_bat_pkg.bat_his_rec;   --Batch Hostory Record
   v_rtn_val       VARCHAR2 (1);
BEGIN
   lea_log_prc ('lea_accl_estm_smry_prc() Start.');
   v_bat_his_rec.estm_st_dt := SYSDATE;   --Estimate data insert start date

   EXECUTE IMMEDIATE 'alter session enable parallel dml' ;

   /* 실행년월은 유일함(재실행시 삭제 처리) */
   DELETE /*+ Parallel(a) Nologging */
          lea_acct_cost_amt a
   WHERE a.exe_yrmon = exe_yrmon_in;
   
   Commit; --PDML 뒤 반드시 Commit 처리 할것
   
   EXECUTE IMMEDIATE 'alter table lea_acct_cost_amt deallocate unused' ; --Remove delete space
      
   EXECUTE IMMEDIATE 'alter session enable parallel dml' ;

   INSERT /*+ Parallel(a) Nologging */ INTO lea_acct_cost_amt a
               (exe_yrmon, rev_yrmon, acct_cd, accl_auto_cd, estm_cost_amt, pst_act_cost_amt, accl_cost_amt,
                mnl_inp_flg, cre_usr_id, cre_dt, upd_usr_id, upd_dt)
      SELECT   /*+ Parallel(d) */
               exe_yrmon_in, rev_yrmon, d.acct_cd, c.accl_auto_cd, SUM (estm_cost_amt), SUM (NVL(act_cost_amt, 0)),
               SUM (accl_cost_amt), 'N', 'ESTM_SMRY', SYSDATE, 'ESTM_SMRY', SYSDATE
          FROM lea_accl_dtl d,
               lea_lgs_cost c  --타선사 Account code는 Manual 로 처리되기 때문에 따로 Union 할 필요 없음
         WHERE d.coa_cost_src_cd  = c.coa_cost_src_cd
           AND d.delt_flg     = 'N'         --Delete Estimated
           AND c.accl_auto_cd = 'A'         --Estimated Cost Code 가 Auto 만 LEA_ACCL_DTL 에 깔려 있음
           AND c.delt_flg     = 'N'         --Cost Code 삭제여부 확인
           AND d.bkg_sts_cd   IN ('F', 'W') --Firm, Waiting 인 Booking만 추정으로 잡음
--           AND d.rev_yrmon   >= '200801'    --결산기간을 2008.01월 부터 잡음 2008.03.10
           AND d.rev_yrmon >= CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03')
                                    THEN TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm') 
                                    ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01'
                              END
      GROUP BY rev_yrmon, d.acct_cd, c.accl_auto_cd
             ;
   
   lea_log_prc ('lea_accl_dtl->lea_acct_cost_amt Summary Insert Count:' || SQL%ROWCOUNT);
   lea_log_prc ('SQLCODE:' || SQLCODE);
   
   lea_log_prc('lea_accl_estm_smry_prc() End.');
   
   Commit;
   
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_ESTM_SMRY_PRC 완료') ; -- 시간 측정을 위한 디버깅 코드
      
   /* Exception -----------------------------------------------------------------*/
   EXCEPTION
   WHEN OTHERS
   THEN
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE); 
END;