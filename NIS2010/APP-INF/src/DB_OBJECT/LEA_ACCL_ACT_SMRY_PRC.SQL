CREATE OR REPLACE PROCEDURE LEAADM.lea_accl_act_smry_prc (exe_yrmon_in IN VARCHAR, bat_id_in IN VARCHAR)
IS
/*******************************************************************************
  1.Name       : ����
  2.Create Date: 2007-02-02
  3.Description:
      - �뵵: LEA_ACT_COST_IF ���� Account code ���� Summary(PRE Cost Amount) �����
              LEA_ACCT_COST_AMT�� Merge(Insert or Update) ó��
      - �Ķ����: ���������(in_exeyrmon(Format:'YYYYMM'))
      - Ư�̻���
        (1) Summary
  4.Revision History
    2007-02-22:����:���ʻ���.
    2008-03-10:����:���Ⱓ�� 2�� ������ ���� 2008.01�� �ݿ�(HardCoding) : '200710'->'200801'
    2009-01-21:����ȫ:Exe.Yrmon�� 1,2,3 ���ϰ�� Rev.Month �� ���⵵ ���� 10,11,12 ������  
               �����ϵ��� �����ݿ�(����� �������-rev.month �� �����ϰ�)
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
                     exe_yrmon_in exe_yrmon, --���� ����� ����ġ�� Summary 
                     i.rev_yrmon, i.acct_cd, c.accl_auto_cd, SUM (i.usd_cost_amt) pre_act_cost_amt
                FROM lea_act_cost_if i,
                (
                  SELECT DISTINCT ACCL_AUTO_CD ACCL_AUTO_CD, ACCT_CD ACCT_CD, COA_COST_SRC_CD COA_COST_SRC_CD                                      
                  FROM LEA_LGS_COST                                                                                     
                  WHERE ACCL_FLG = 'Y' --ȭ�������� ���� ����(Account Code: 512xxx �� ���۵�)�� Actual cost�� ����                                                                              
                  UNION ALL                                                                                             
                  SELECT DISTINCT 'M' ACCL_AUTO_CD, OTR_CRR_ACCT_CD ACCT_CD, COA_COST_SRC_CD COA_COST_SRC_CD --Ÿ����� Account code(Manual)                         
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
      WHEN MATCHED THEN   --�ߺ��� Actual Cost�� Update ó��
         UPDATE
            SET a.pre_act_cost_amt = u.pre_act_cost_amt,
                a.pst_act_cost_amt = DECODE(a.accl_auto_cd, 'A', a.pst_act_cost_amt, u.pre_act_cost_amt), --Manual, Transfer Accout Code �� ���ؼ��� PRE, POST �ݾ��� ���� ó����!!
                a.upd_usr_id = 'ACT_SMRY_U',
                a.upd_dt = SYSDATE
      WHEN NOT MATCHED THEN   --�ߺ��� ������ Insert ó��
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
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_ACT_SMRY_PRC �Ϸ�') ; -- �ð� ������ ���� ����� �ڵ�   

   /* Exception -----------------------------------------------------------------*/
   EXCEPTION
   WHEN OTHERS
   THEN
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);        

END;