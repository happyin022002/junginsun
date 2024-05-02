CREATE OR REPLACE PROCEDURE LEAADM.LEA_BAT_MAIN_PRE_PRC (exe_yrmon_in IN VARCHAR2) 
IS 
/******************************************************************************* 
  1.Name       : LEA_BAT_MAIN_PRE_PRC
  2.Create Date: 2007-02-02 
  3.Description: 
      - 용도: e-NIS 화물변동비 추정결산을 위한 월간 배치프로그램 
      - 파라미터: 실행수행년월(p_exeyrmon(Format:'YYYYMM')) 
      - 특이사항 
        (1) 실제 업무 로직을 Procedure로 나누어 단계별 처리 
        (2) Main Procedure에서 호출한 (Sub)Procedure의 exception 발생시 Main Procedure로 올라옴 
  4.Revision History 
    2007-02-02:김상모:최초생성. 
    2008-04-25:전재홍:결산시, Estimation Update 장시간 소요로 인해 
                      AP 마감전, 대상항차가 I/F 시점에 실행하기 위해 
                      LEA_BAT_MAIN_PRC 에서 분리함.
    2009-01-20:- LEA_ACCL_DTL_마지막 수행월 Partition 에 대해서 Analyze 실행
               - EST UPDATE 가 끝난 후, 이 시점까지 LEA_ACCL_DTL 을 BackUp 한다.
                 LEA_ACCL_UPD_ESTM_PRC 가 장시간 실행되므로 결산 재수행시에는 
                 BackUp Table 을 Restore 해서 소요시간을 최소화하도록 한다.
                 결산후 전월 Backup 시 , 전전월 Backup 분과 같이 삭제 요청한다.(Space 확보)
    2010-01-15:- Analyze 부분 변경
*******************************************************************************/ 
 
   --PRAGMA AUTONOMOUS_TRANSACTION; 
   --Autonomous 설정시 PDML(alter session enable parallel dml)이 Series 로 처리된다. 
   --즉, 셋팅한 의도대로 Parallel 효과를 못 낸다. 
    
   /* Variable Declare -------------------------------------------------------*/ 
   v_bat_id        lea_accl_bat_his.bat_id%TYPE; 
   v_bat_rmk       lea_accl_bat_his.bat_rmk%TYPE; 
   v_bat_his_rec   lea_bat_pkg.bat_his_rec;   --Batch History Record 
   v_msg           varchar2(30000) ; 
    v_msg_out           varchar2(30000) ; 
    
BEGIN 
   DBMS_APPLICATION_INFO.SET_MODULE('LEA_BAT_MAIN_PRC'||exe_yrmon_in||')', 'Initializing'); 
   APP_DEBUG.SET_REFERENCE_POINT ; -- 시간 측정을 위한 디버깅 코드 
    
   /* Send e-Mail for Batch Starting Message */ 
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#1', '배치프로그램이 정상적으로 시작 되었습니다.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
 
 
   /*-------------------------------------------------------------------------*/ 
   /* Biz Logic Processing Start                                              */ 
   /*-------------------------------------------------------------------------*/ 
   /* Batch Start log */ 
   lea_log_prc ('');   --New Line 
   lea_log_prc ('---------------------------------------------------------------------------'); 
   lea_log_prc ('LEA Batch Main Start! Execute Year Month:' || exe_yrmon_in); 
     
   --lea_bat_pkg.g_exe_yrmon := exe_yrmon_in;   --Package 전역변수 수행년월 할당 
   --lea_log_prc (exe_yrmon_in || ' ' || v_bat_rmk); 
 
   --Batch History Record setting 
   v_bat_his_rec.exe_yrmon := exe_yrmon_in; 
   v_bat_his_rec.bat_id := NULL; 
   v_bat_his_rec.bat_rmk := v_bat_rmk; 
   v_bat_his_rec.accl_bat_sts_cd := 'BPR';   --Batch Program Running.(*ETL 작업시 참조함!!) 
    
   --Batch History Start (Insert) 
   v_bat_his_rec.bat_id := lea_accl_bat_his_fnc (v_bat_his_rec, 'BS'); --최초 bat_id  할당 
   lea_bat_pkg.g_bat_id := v_bat_his_rec.bat_id;   --Package 전역변수 배치아이디 할당 
    
   /* Batch Job Auditing Start(DBA) */ 
   --batch_audit_pkg.job_start ('LEA_BAT_MAIN_PRC'); 
       
   /*----------------------------------------------------------------------*/ 
   /* Restore...Table(LEA_ACCL_DTL)                                        */ 
   /*----------------------------------------------------------------------*/ 
--   DBMS_APPLICATION_INFO.SET_ACTION('lea_rst_table_prc'); --Session Monitor의 Action 에 지정된 문자열을 할당 
--   lea_rst_table_prc(exe_yrmon_in, v_bat_his_rec.bat_id); 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#2', 'Restore...Table(LEA_ACCL_DTL) 처리 완료.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
 
 
   /*----------------------------------------------------------------------*/ 
   /* Analyze Large Transaction Tables                                     */ 
   /*----------------------------------------------------------------------*/ 
   DBMS_APPLICATION_INFO.SET_ACTION('Analyze Tables'); --Session Monitor의 Action 에 지정된 문자열을 할당 
   LEA_BKUP_PKG.analyze_table('LEA_ESTM_COST_IF') ;  
   --LEA_BKUP_PKG.analyze_table('LEA_ACT_COST_IF') ;
   LEA_BKUP_PKG.analyze_table('LEA_ACT_COST_IF') ;  
--   LEA_BKUP_PKG.analyze_table('LEA_ACCL_DTL', 'P'||exe_yrmon_in) ; -- 새로 들어갈 월만 ANALYZE   
   APP_DEBUG.LOG_ELAPSED_TIME('Analyze Tables 완료') ; -- 시간 측정을 위한 디버깅 코드       
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#2-1', 'Analyze...Table 처리 완료.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
 
 
   -- 데이타가 INSERT 되는 Unique Index(PK 인덱스 포함) 를 제외한 모든 인덱스를 
   -- DISABLE 시키고, MERGE가 끝난 후에 다시 REBUILD 한다.
   -- MERGE APPEND 문이 실행된 후에 INDEX REBUILD 를 PARALLEL 로 하지 않는데
   -- 실제로는 해당 파티션의 모든 ROW 가 새 ROW 이므로 REBUILD가 빠르다.
   -- BITMAP Index 는 Table(LEA_ACCL_DTL) 전체를 Lock 으로 잡기 때문에 Parallel Processor 작업 이전에
   -- Unusable 처리 후(***) Parallel 처리가 끝난 뒤 Rebuild 처리
   LEA_BKUP_PKG.set_indexes_unusable_prc('XAK3LEA_ACCL_DTL') ;
   LEA_BKUP_PKG.set_indexes_unusable_prc('XAK4LEA_ACCL_DTL') ;

   /*----------------------------------------------------------------------*/ 
   /* Update Estimae cost 가져오기                                         */ 
   /*----------------------------------------------------------------------*/ 
   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_upd_estm_prc'); 
   lea_accl_upd_estm_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#3', 'Update Estimae cost 가져오기 완료.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
 
   DBMS_LOCK.sleep(600);  /* specifies the sleep time in seconds 1*60*10=600(10분) */
    
   /*----------------------------------------------------------------------*/ 
   /* Estimate cost 가져오기                                               */ 
   /*----------------------------------------------------------------------*/ 
   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_estm_prc'); 
   lea_accl_estm_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#4', 'Estimate cost 가져오기 완료.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
    
--   LEA_BKUP_PKG.analyze_table('LEA_ACCL_DTL', 'P'||exe_yrmon_in) ; -- 새로 들어갈 월만 ANALYZE
   ops$oracle.analyze_table ('LEAADM', 'LEA_ACCL_DTL', 1);
   
  
   /*----------------------------------------------------------------------*/ 
   /* Estimate 생성후 LEA_ACCL_DTL BackUP                                  */ 
   /*----------------------------------------------------------------------*/ 
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#BACKUP', 'LEA_ACCL_DTL BACKUP START.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
   lea_accl_dtl_tbl_bkup_st_prc(exe_yrmon_in, v_msg_out);
   lea_sys_email_prc('Logistics Expense Accrual Batch Status#BACKUP', 'LEA_ACCL_DTL BACKUP END.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
   
   
--   /*----------------------------------------------------------------------*/ 
--   /* Actual cost  정제 처리하기                                           */ 
--   /*----------------------------------------------------------------------*/ 
--   DBMS_APPLICATION_INFO.SET_ACTION('lea_act_set_prc'); 
--   lea_act_set_prc (exe_yrmon_in); 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#5', 'Actual cost  정제 처리하기 완료.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
--    
--   /*----------------------------------------------------------------------*/ 
--   /* Actual Mapping, Allocate 처리하기                                    */ 
--   /*----------------------------------------------------------------------*/ 
--   DBMS_APPLICATION_INFO.SET_ACTION('lea_act_mapg_prt_prc'); 
--   lea_act_mapg_prt_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#6', 'Actual Mapping, Allocate 처리하기 완료.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
--    
--   -- 데이타가 INSERT 되는 Unique Index(PK 인덱스 포함) 를 제외한 모든 인덱스를 
--   -- DISABLE 시키고, MERGE가 끝난 후에 다시 REBUILD 한다.
--   -- MERGE APPEND 문이 실행된 후에 INDEX REBUILD 를 PARALLEL 로 하지 않는데
--   -- 실제로는 해당 파티션의 모든 ROW 가 새 ROW 이므로 REBUILD가 빠르다.
--   -- BITMAP Index 는 Table(LEA_ACCL_DTL) 전체를 Lock 으로 잡기 때문에 Parallel Processor 작업 이전에
--   -- Unusable 처리 후 Parallel 처리가 끝난 뒤 Rebuild 처리(***)
--   LEA_BKUP_PKG.rebuild_indexes_prc('XAK3LEA_ACCL_DTL') ;
--   LEA_BKUP_PKG.rebuild_indexes_prc('XAK4LEA_ACCL_DTL') ;
--    
--   /*----------------------------------------------------------------------*/ 
--   /* Accrual cost 계산하기                                                */ 
--   /*----------------------------------------------------------------------*/ 
--   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_cal_prc'); 
--   lea_accl_cal_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#7', 'Accrual cost 계산하기 완료.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
--    
--   /*----------------------------------------------------------------------*/ 
--   /* Report Summary                                                       */ 
--   /*----------------------------------------------------------------------*/ 
--   --Step1.LEA_ACCL_DTL(Estm, Post Actual, Accrual) -> Insert LEA_ACCT_COST_AMT 
--   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_estm_smry_prc'); 
--   lea_accl_estm_smry_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
--   --Step2.LEA_ACT_COST_IF(Pre Actual) -> Insert or Update LEA_ACCT_COST_AMT 
--   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_act_smry_prc'); 
--   lea_accl_act_smry_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#8', 'Report Summary 완료.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
--    
--   /*----------------------------------------------------------------------*/ 
--   /* for ERP Summary                                                      */ 
--   /*----------------------------------------------------------------------*/ 
--   --Step1.LEA_ACCL_DTL(Estm, Post Actual, Accrual)  -> Insert GL_ACCL_IF 
--   --Step2.LEA_ACT_COST_IF(Manual, Transfer Account) -> Insert GL_ACCL_IF 
--   DBMS_APPLICATION_INFO.SET_ACTION('lea_accl_erp_smry_prc'); 
--   lea_accl_erp_smry_prc (exe_yrmon_in, v_bat_his_rec.bat_id); 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#9', 'for ERP Summary 완료.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
--   
--   /*----------------------------------------------------------------------*/ 
--   /* Init... FLAG Column(ESTM_UPD_FLG, ACCL_CAL_FLG)                      */ 
--   /*----------------------------------------------------------------------*/ 
--   DBMS_APPLICATION_INFO.SET_ACTION('lea_init_flg_prc'); 
--   lea_init_flg_prc(exe_yrmon_in); 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#10', 'Init... FLAG Column(ESTM_UPD_FLG, ACCL_CAL_FLG) 완료.'||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ; 
--       
--       
--   /* Batch History Setting --------------------------------------------------*/ 
--   v_bat_his_rec.accl_bat_sts_cd := 'BNC';   --Batch Porgram normal finished. 
--   v_bat_his_rec.bat_cmpl_flg := 'Y';   --completed 
--   v_bat_his_rec.bat_rmk := 'Batch Porgram normal finished.'; 
--   --Batch History Complete (Update) 
--   v_bat_id := lea_accl_bat_his_fnc (v_bat_his_rec, 'BC'); 
--   /*-------------------------------------------------------------------------*/ 
-- 
--    
--   /*-------------------------------------------------------------------------*/ 
--   /* Biz Logic Processing End                                                */ 
--   /*-------------------------------------------------------------------------*/ 
-- 
--   /* Send e-Mail for Batch Completed Message */ 
--   lea_send_email_prc(exe_yrmon_in);  --Send to User 
--   lea_sys_email_prc('Logistics Expense Accrual Batch Status#11', '배치프로그램이 정상적으로 종료 되었습니다.') ; 
-- 
--   /* Batch End log */ 
--   lea_log_prc ('LEA Batch Main End! Execute Year Month:' || exe_yrmon_in); 
--   lea_log_prc ('---------------------------------------------------------------------------'); 
--    
--   /* Batch Job Auditing End(DBA) */ 
--   --batch_audit_pkg.job_end ('LEA_BAT_MAIN_PRC'); 
--    
--   APP_DEBUG.LOG_ELAPSED_TIME('LEA_BAT_MAIN_PRC 완료') ; -- 시간 측정을 위한 디버깅 코드 
-- 
--   COMMIT;   --Main, Sub Procedures Commit. 
    
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