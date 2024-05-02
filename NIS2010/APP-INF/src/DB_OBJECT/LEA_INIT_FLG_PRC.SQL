CREATE OR REPLACE PROCEDURE LEAADM.LEA_INIT_FLG_PRC (exe_yrmon_in IN VARCHAR)
IS
/*******************************************************************************
  1.Name       : ����
  2.Create Date: 2007-03-02
  3.Description:
      - �뵵: ������� ó���� FLAG Column�� 'N' ó��
      - �Ķ����:
      - Ư�̻���
        (1) ó����� Table.Column
            LEA_ESTM_COST_IF.ESTM_UPD_FLG
            LEA_ACCL_DTL.ACCL_CAL_FLG
  4.Revision History
    2007-03-02:����:���ʻ���.
*******************************************************************************/
/* Variable Declare --------------------------------------------------------*/
BEGIN
   
   lea_log_prc ('lea_init_flg_prc() start.');

   EXECUTE IMMEDIATE 'alter session enable parallel dml' ;
   
   --XAK4LEA_ACCL_DTL Bitmap Index �� Unusable ��Ŵ
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
   
   --Unusable ��Ų Bitmap Index�� reBuild ó��
   LEA_BKUP_PKG.rebuild_indexes_prc('XAK4LEA_ACCL_DTL');
   LEA_BKUP_PKG.rebuild_indexes_prc('XAK2LEA_ACCL_DTL');
       
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_INIT_FLG_PRC �Ϸ�') ; -- �ð� ������ ���� ����� �ڵ�
    
   lea_log_prc ('lea_init_flg_prc() end.');
   
/* Exception -----------------------------------------------------------------*/
EXCEPTION
   WHEN OTHERS
   THEN
      raise_application_error (-20000, SQLERRM || CHR (10) || DBMS_UTILITY.format_error_backtrace);
END;