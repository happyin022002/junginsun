CREATE OR REPLACE PROCEDURE LEAADM.LEA_INIT_FLG_PRC (exe_yrmon_in IN VARCHAR)
IS
/*******************************************************************************
  1.Name       : 김상모
  2.Create Date: 2007-03-02
  3.Description:
      - 용도: 추정결산 처리된 FLAG Column을 'N' 처리
      - 파라미터:
      - 특이사항
        (1) 처리대상 Table.Column
            LEA_ESTM_COST_IF.ESTM_UPD_FLG
            LEA_ACCL_DTL.ACCL_CAL_FLG
  4.Revision History
    2007-03-02:김상모:최초생성.
*******************************************************************************/
/* Variable Declare --------------------------------------------------------*/
BEGIN
   
   lea_log_prc ('lea_init_flg_prc() start.');

   EXECUTE IMMEDIATE 'alter session enable parallel dml' ;
   
   --XAK4LEA_ACCL_DTL Bitmap Index 를 Unusable 시킴
   LEA_BKUP_PKG.set_indexes_unusable_prc('XAK4LEA_ACCL_DTL');
   LEA_BKUP_PKG.set_indexes_unusable_prc('XAK2LEA_ACCL_DTL');
   
   --Accrual Detail Calculation Table
   UPDATE /*+ parallel(d 12) */ 
          lea_accl_dtl d
      SET accl_calc_flg = 'N',
          upd_usr_id    = 'INIT_FLG',
          upd_dt        = SYSDATE
    WHERE accl_calc_flg = 'Y'
    ;
 
   Commit;
   
   --Unusable 시킨 Bitmap Index를 reBuild 처리
   LEA_BKUP_PKG.rebuild_indexes_prc('XAK4LEA_ACCL_DTL');
   LEA_BKUP_PKG.rebuild_indexes_prc('XAK2LEA_ACCL_DTL');
       
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_INIT_FLG_PRC 완료') ; -- 시간 측정을 위한 디버깅 코드
    
   lea_log_prc ('lea_init_flg_prc() end.');
   
/* Exception -----------------------------------------------------------------*/
EXCEPTION
   WHEN OTHERS
   THEN
      raise_application_error (-20000, SQLERRM || CHR (10) || DBMS_UTILITY.format_error_backtrace);
END;