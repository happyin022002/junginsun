CREATE OR REPLACE PROCEDURE LEAADM.LEA_BAT_MAIN_PRC (exe_yrmon_in IN VARCHAR2) 
IS 
/******************************************************************************* 
  1.Name       : LEA_BAT_MAIN_PRC
  2.Create Date: 2007-02-02 
  3.Description: 
      - �뵵: e-NIS ȭ�������� ��������� ���� ���� ��ġ���α׷� 
      - �Ķ����: ���������(p_exeyrmon(Format:'YYYYMM')) 
      - Ư�̻��� 
        (1) ���� ���� ������ Procedure�� ������ �ܰ躰 ó�� 
        (2) Main Procedure���� ȣ���� (Sub)Procedure�� exception �߻��� Main Procedure�� �ö�� 
  4.Revision History 
    2007-02-02:����:���ʻ���. 
    2008-04-25:����ȫ:����, Estimation Update ��ð� �ҿ�� ���� 
                      AP ������, ��������� I/F ������ �����ϱ� ���� �и���.
    2010-01-15:��굥��Ÿ ������ LEA_ACCL_DTL Analyze
*******************************************************************************/ 
 
   --PRAGMA AUTONOMOUS_TRANSACTION; 
   --Autonomous ������ PDML(alter session enable parallel dml)�� Series �� ó���ȴ�. 
   --��, ������ �ǵ���� Parallel ȿ���� �� ����. 
    
   /* Variable Declare -------------------------------------------------------*/ 
   v_bat_id        lea_accl_bat_his.bat_id%TYPE; 
   v_bat_rmk       lea_accl_bat_his.bat_rmk%TYPE; 
   v_bat_his_rec   lea_bat_pkg.bat_his_rec;   --Batch History Record 
   v_msg           varchar2(30000) ; 
    v_msg_out           varchar2(30000) ; 
    
BEGIN 
--   DBMS_APPLICATION_INFO.SET_MODULE('LEA_BAT_MAIN_PRC'||exe_yrmon_in||')', 'Initializing'); 
--   APP_DEBUG.SET_REFERENCE_POINT ; -- �ð� ������ ���� ����� �ڵ� 
--    
--   /* Send e-Mail for Batch Starting Message */ 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#1', '��ġ���α׷��� ���������� ���� �Ǿ����ϴ�.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
-- 
-- 
--   /*-------------------------------------------------------------------------*/ 
--   /* Biz Logic Processing Start                                              */ 
--   /*-------------------------------------------------------------------------*/ 
--   /* Batch Start log */ 
--   lea_log_prc ('');   --New Line 
--   lea_log_prc ('---------------------------------------------------------------------------'); 
--   lea_log_prc ('LEA Batch Main Start! Execute Year Month:' || exe_yrmon_in); 
--     
--   --lea_bat_pkg.g_exe_yrmon := exe_yrmon_in;   --Package �������� ������ �Ҵ� 
--   --lea_log_prc (exe_yrmon_in || ' ' || v_bat_rmk); 
-- 
--   --Batch History Record setting 
--   v_bat_his_rec.exe_yrmon := exe_yrmon_in; 
--   v_bat_his_rec.bat_id := NULL; 
--   v_bat_his_rec.bat_rmk := v_bat_rmk; 
--   v_bat_his_rec.accl_bat_sts_cd := 'BPR';   --Batch Program Running.(*ETL �۾��� ������!!) 
--    
--   --Batch History Start (Insert) 
--   v_bat_his_rec.bat_id := lea_accl_bat_his_fnc (v_bat_his_rec, 'BS'); --���� bat_id  �Ҵ� 
--   lea_bat_pkg.g_bat_id := v_bat_his_rec.bat_id;   --Package �������� ��ġ���̵� �Ҵ� 
--    
--   /* Batch Job Auditing Start(DBA) */ 
--   --batch_audit_pkg.job_start ('LEA_BAT_MAIN_PRC'); 
--       
--   /*----------------------------------------------------------------------*/ 
--   /* Restore...Table(LEA_ACCL_DTL)                                        */ 
--   /*----------------------------------------------------------------------*/ 
----   DBMS_APPLICATION_INFO.SET_ACTION('lea_rst_table_prc'); --Session Monitor�� Action �� ������ ���ڿ��� �Ҵ� 
----   lea_rst_table_prc(exe_yrmon_in, v_bat_his_rec.bat_id); 
----   lea_sys_email_prc('Logistics Expense Accrual Batch Status#2', 'Restore...Table(LEA_ACCL_DTL) ó�� �Ϸ�.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
-- 
-- 
--   /*----------------------------------------------------------------------*/ 
--   /* Analyze Large Transaction Tables                                     */ 
--   /*----------------------------------------------------------------------*/ 
--   DBMS_APPLICATION_INFO.SET_ACTION('Analyze Tables'); --Session Monitor�� Action �� ������ ���ڿ��� �Ҵ� 
--   LEA_BKUP_PKG.analyze_table('LEA_ESTM_COST_IF') ;  
--   --LEA_BKUP_PKG.analyze_table('LEA_ACT_COST_IF') ;
--   LEA_BKUP_PKG.analyze_table('LEA_ACT_COST_IF') ;  
--   --LEA_BKUP_PKG.analyze_table('LEA_ACCL_DTL', 'P'||exe_yrmon_in) ; -- ���� �� ���� ANALYZE   
--   APP_DEBUG.LOG_ELAPSED_TIME('Analyze Tables �Ϸ�') ; -- �ð� ������ ���� ����� �ڵ�       
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#2-1', 'Analyze...Table ó�� �Ϸ�.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
-- 
-- 
--   -- ����Ÿ�� INSERT �Ǵ� Unique Index(PK �ε��� ����) �� ������ ��� �ε����� 
--   -- DISABLE ��Ű��, MERGE�� ���� �Ŀ� �ٽ� REBUILD �Ѵ�.
--   -- MERGE APPEND ���� ����� �Ŀ� INDEX REBUILD �� PARALLEL �� ���� �ʴµ�
--   -- �����δ� �ش� ��Ƽ���� ��� ROW �� �� ROW �̹Ƿ� REBUILD�� ������.
--   -- BITMAP Index �� Table(LEA_ACCL_DTL) ��ü�� Lock ���� ��� ������ Parallel Processor �۾� ������
--   -- Unusable ó�� ��(***) Parallel ó���� ���� �� Rebuild ó��
--   LEA_BKUP_PKG.set_indexes_unusable_prc('XAK3LEA_ACCL_DTL') ;
--   LEA_BKUP_PKG.set_indexes_unusable_prc('XAK4LEA_ACCL_DTL') ;
--
--   /*----------------------------------------------------------------------*/ 
--   /* Update Estimae cost ��������                                         */ 
--   /*----------------------------------------------------------------------*/ 
--   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_upd_estm_prc'); 
--   lea_accl_upd_estm_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#3', 'Update Estimae cost �������� �Ϸ�.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
-- 
--   DBMS_LOCK.sleep(600);  /* specifies the sleep time in seconds 1*60*10=600(10��) */
--    

   
--   /*----------------------------------------------------------------------*/ 
--   /* Estimate cost ��������                                               */ 
--   /*----------------------------------------------------------------------*/ 
--   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_estm_prc'); 
--   lea_accl_estm_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#4', 'Estimate cost �������� �Ϸ�.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
--    
----   LEA_BKUP_PKG.analyze_table('LEA_ACCL_DTL', 'P'||exe_yrmon_in) ; -- ���� �� ���� ANALYZE
--   ops$oracle.analyze_table ('LEAADM', 'LEA_ACCL_DTL', 1);
--   
--  
--   /*----------------------------------------------------------------------*/ 
--   /* Estimate ������ LEA_ACCL_DTL BackUP                                  */ 
--   /*----------------------------------------------------------------------*/ 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#BACKUP', 'LEA_ACCL_DTL BACKUP START.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
--   lea_accl_dtl_tbl_bkup_st_prc(exe_yrmon_in, v_msg_out);
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#BACKUP', 'LEA_ACCL_DTL BACKUP END.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
   
    
   /*----------------------------------------------------------------------*/ 
   /* Actual cost  ���� ó���ϱ�                                           */ 
   /*----------------------------------------------------------------------*/ 
   DBMS_APPLICATION_INFO.SET_ACTION('lea_act_set_prc'); 
   lea_act_set_prc (exe_yrmon_in); 
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#5', 'Actual cost  ���� ó���ϱ� �Ϸ�.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
    
   /*----------------------------------------------------------------------*/ 
   /* Actual Mapping, Allocate ó���ϱ�                                    */ 
   /*----------------------------------------------------------------------*/ 
   DBMS_APPLICATION_INFO.SET_ACTION('lea_act_mapg_prt_prc'); 
   lea_act_mapg_prt_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#6', 'Actual Mapping, Allocate ó���ϱ� �Ϸ�.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
    
   -- ����Ÿ�� INSERT �Ǵ� Unique Index(PK �ε��� ����) �� ������ ��� �ε����� 
   -- DISABLE ��Ű��, MERGE�� ���� �Ŀ� �ٽ� REBUILD �Ѵ�.
   -- MERGE APPEND ���� ����� �Ŀ� INDEX REBUILD �� PARALLEL �� ���� �ʴµ�
   -- �����δ� �ش� ��Ƽ���� ��� ROW �� �� ROW �̹Ƿ� REBUILD�� ������.
   -- BITMAP Index �� Table(LEA_ACCL_DTL) ��ü�� Lock ���� ��� ������ Parallel Processor �۾� ������
   -- Unusable ó�� �� Parallel ó���� ���� �� Rebuild ó��(***)
   LEA_BKUP_PKG.rebuild_indexes_prc('XAK3LEA_ACCL_DTL') ;
   LEA_BKUP_PKG.rebuild_indexes_prc('XAK4LEA_ACCL_DTL') ;
    
   /*----------------------------------------------------------------------*/ 
   /* Accrual cost ����ϱ�                                                */ 
   /*----------------------------------------------------------------------*/ 
   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_cal_prc'); 
   lea_accl_cal_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#7', 'Accrual cost ����ϱ� �Ϸ�.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
    
   /*----------------------------------------------------------------------*/ 
   /* Report Summary                                                       */ 
   /*----------------------------------------------------------------------*/ 
   --Step1.LEA_ACCL_DTL(Estm, Post Actual, Accrual) -> Insert LEA_ACCT_COST_AMT 
   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_estm_smry_prc'); 
   lea_accl_estm_smry_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
   --Step2.LEA_ACT_COST_IF(Pre Actual) -> Insert or Update LEA_ACCT_COST_AMT 
   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_act_smry_prc'); 
   lea_accl_act_smry_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#8', 'Report Summary �Ϸ�.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
    
   /*----------------------------------------------------------------------*/ 
   /* for ERP Summary                                                      */ 
   /*----------------------------------------------------------------------*/ 
   --Step1.LEA_ACCL_DTL(Estm, Post Actual, Accrual)  -> Insert GL_ACCL_IF 
   --Step2.LEA_ACT_COST_IF(Manual, Transfer Account) -> Insert GL_ACCL_IF 
   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_erp_smry_prc'); 
   lea_accl_erp_smry_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#9', 'for ERP Summary �Ϸ�.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
   
   /*----------------------------------------------------------------------*/ 
   /* Init... FLAG Column(ESTM_UPD_FLG, ACCL_CAL_FLG)                      */ 
   /*----------------------------------------------------------------------*/ 
   --�ӽ� (2009.05.26)
--   DBMS_APPLICATION_INFO.SET_ACTION('lea_init_flg_prc'); 
--   lea_init_flg_prc(exe_yrmon_in); 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#10', 'Init... FLAG Column(ESTM_UPD_FLG, ACCL_CAL_FLG) �Ϸ�.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
       
       
   /* Batch History Setting --------------------------------------------------*/ 
   v_bat_his_rec.accl_bat_sts_cd := 'BNC';   --Batch Porgram normal finished. 
   v_bat_his_rec.bat_cmpl_flg := 'Y';   --completed 
   v_bat_his_rec.bat_rmk := 'Batch Porgram normal finished.'; 
   --Batch History Complete (Update) 
   v_bat_id := lea_accl_bat_his_fnc (v_bat_his_rec, 'BC'); 
   /*-------------------------------------------------------------------------*/ 
 
    
   /*-------------------------------------------------------------------------*/ 
   /* Biz Logic Processing End                                                */ 
   /*-------------------------------------------------------------------------*/ 
 
   /* Send e-Mail for Batch Completed Message */ 
   lea_send_email_prc(exe_yrmon_in);  --Send to User 
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#11', '��ġ���α׷��� ���������� ���� �Ǿ����ϴ�.') ; 
 
   /* Batch End log */ 
   lea_log_prc ('LEA Batch Main End! Execute Year Month:' || exe_yrmon_in); 
   lea_log_prc ('---------------------------------------------------------------------------'); 
    
   /* Batch Job Auditing End(DBA) */ 
   --batch_audit_pkg.job_end ('LEA_BAT_MAIN_PRC'); 
    
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_BAT_MAIN_PRC �Ϸ�') ; -- �ð� ������ ���� ����� �ڵ� 
 
   COMMIT;   --Main, Sub Procedures Commit. 
   
   ops$oracle.analyze_table ('LEAADM', 'LEA_ACCL_DTL', 1);
    
/* Exception -----------------------------------------------------------------*/    
   EXCEPTION 
    
   WHEN OTHERS 
   THEN 
      v_msg := SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE ; 
      lea_log_prc('Other Exetpion:'|| v_msg); --logging 
       
      /* Batch History Setting -----------------------------------------------------------*/ 
      v_bat_his_rec.accl_bat_sts_cd := 'BAC';   --Batch Porgram abnormal finished. 
      v_bat_his_rec.bat_cmpl_flg := 'N';   --Not completed 
      v_bat_his_rec.bat_rmk := 'Other Exetpion:'|| v_msg; 
      --Batch History Complete (Update) 
      v_bat_id := lea_accl_bat_his_fnc (v_bat_his_rec, 'BC'); 
      /*----------------------------------------------------------------------------------*/ 
       
      /* Send e-Mail ---------------------------------------------------------------------*/ 
      lea_send_email_prc(exe_yrmon_in); --Send to user 
      lea_sys_email_prc('Occur Batch Procedure Other Exception', to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')||CHR(10)||v_msg) ; --Send to System Manager 
       
      Commit; 
END;