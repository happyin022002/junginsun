CREATE OR REPLACE PROCEDURE LEAADM.LEA_BAT_COND_CHK_PRC (exe_yrmon_in IN VARCHAR2, msg_out OUT VARCHAR2)
IS
/*******************************************************************************
  1.Name       : 김상모
  2.Create Date: 2007-02-02
  3.Description:
      - 용도: e-NIS 화물변동비 추정결산을 위한 월간 배치프로그램
      - 파라미터: 실행수행년월(in_exeyrmon(Format:'YYYYMM'))
      - 특이사항
        (1) 유저가 매월초 추정 전제조건(Condition Confirm)
            및 Manual Save, ERP Interface를 확인하고 배치프로그램을 실행(호출)
        (2) 대용량 데이터 처리
  4.Revision History
    2007-02-02:김상모:최초생성.
*******************************************************************************/
/* Variable Declare -------------------------------------------------------*/
   v_cond_cfm_flg      lea_accl_cond_itm.cond_cfm_flg%TYPE;
   v_mnl_inp_flg       lea_accl_cond_itm.mnl_inp_flg%TYPE;
   v_erp_if_flg        lea_accl_cond_itm.erp_if_flg%TYPE;
   v_accl_bat_sts_cd   lea_accl_cond_itm.accl_bat_sts_cd%TYPE;
   v_bat_id            lea_accl_bat_his.bat_id%TYPE;
   v_bat_cmpl_flg      lea_accl_bat_his.bat_cmpl_flg%TYPE;
   v_objects_knt       NUMBER := 0;
   v_rtn_val           VARCHAR2 (3);

   /* Execute Year Month's ERP Confirm Checking */
   CURSOR cfm_chk_cur
   IS
   SELECT CASE (SIGN(TO_DATE(MAX(exe_yrmon), 'rrrrmm') - TO_DATE(exe_yrmon_in, 'rrrrmm')))
             WHEN 1 THEN --'Confirm 처리된 마지막 수행년월(' || MAX(exe_yrmon) ||') 배치 작업 보다 이전 수행년월(' || exe_yrmon_in ||') 배치 작업을 할수가 없습니다.'
                         'Can''t start batch for the previous Exe. Months.'
             WHEN 0 THEN --'이미 입력하신 수행년월(' || exe_yrmon_in ||') 배치 작업이 완료 되어 Confirm 되어 있습니다.'
                         'Batch for Exe.Month ' || exe_yrmon_in ||' has been completed and confirmed.'
             WHEN -1 THEN 
                  CASE
                     WHEN TO_CHAR(ADD_MONTHS(TO_DATE(MAX(exe_yrmon), 'rrrrmm'), 1), 'rrrrmm') <> exe_yrmon_in THEN
                        --'Confirm 처리된 마지막 수행년월(' || MAX(exe_yrmon) ||') 기준으로 다음달(' || TO_CHAR(ADD_MONTHS(TO_DATE(max(exe_yrmon), 'rrrrmm'), 1), 'rrrrmm') ||') 배치 작업만 가능합니다.'
                        'Only can start batch for the next month of the last Exe. Months.'
                  END
          ELSE NULL
          END Notice
   FROM lea_accl_cond_itm
   WHERE erp_if_flg = 'Y' --Manual Input Save 후 By Account Code 화면에서 Confirm 버턴 클릭 완료 상태
   ;
   
   /* Execute Year Month's Condition Confirm Checking */
   CURSOR cond_itm_cur
   IS
      SELECT NVL (cond_cfm_flg, 'N'), NVL (mnl_inp_flg, 'N'), NVL (erp_if_flg, 'N'),
             accl_bat_sts_cd
        FROM lea_accl_cond_itm
       WHERE exe_yrmon = exe_yrmon_in;

   /* Batch History Checking */
   CURSOR bat_his_cur
   IS
      SELECT /*+ INDEX_DESC( lea_accl_bat_his XPKLEA_ACCL_BAT_HIS ) */
             bat_id, NVL (bat_cmpl_flg, 'N')
        FROM lea_accl_bat_his
       WHERE exe_yrmon = exe_yrmon_in AND ROWNUM = 1 AND bat_cmpl_flg = 'Y';
       
   /* Check Schedule Table Backup */
   CURSOR skd_tbl_bkup
   IS    
   SELECT job_name
     FROM user_scheduler_jobs
    WHERE job_name LIKE 'BACKUP_TABLE_%'
    ;
    
   /* Check Vaild Status of Object(Procedure, Function, Package, Package body) */ 
   /* Status가 VAILD가 아닌 경우 정상적으로 호출 할수가 없다. */
   CURSOR objects_vaild
   IS
   SELECT COUNT(1)
   FROM user_objects
   WHERE object_name LIKE 'LEA\_%' ESCAPE '\'
     AND object_type IN ('PROCEDURE', 'FUNCTION', 'PACKAGE', 'PACKAGE BODY')
     AND STATUS <> 'VALID' ;    
           
   /* Schedule 등록 실행이 아니 Job 등록 실행 체크 */  
   CURSOR job_chk_cur
   IS
   SELECT 'Batch is already running.'
   FROM user_jobs
   WHERE what LIKE 'LEA_BAT_MAIN_PRC%'
   ;   

     
BEGIN
   lea_log_prc ('lea_accl_bat_cond_chk_prc() Start.');
   
   OPEN objects_vaild;
   FETCH objects_vaild
    INTO v_objects_knt;
    
   IF v_objects_knt > 0 THEN
      msg_out := 'Check objects, status not vaild.'; 
      return;   
   END IF;
   
   OPEN job_chk_cur;
   FETCH job_chk_cur
    INTO msg_out;
    
   IF job_chk_cur%FOUND AND Length(msg_out) > 0
   THEN
      return;
   END IF;
      
   OPEN skd_tbl_bkup;
   FETCH skd_tbl_bkup
    INTO msg_out;

   IF skd_tbl_bkup%FOUND AND Length(msg_out) > 0
   THEN
      msg_out := 'Working, Table backup(' || msg_out || ')';
   END IF;
      
   OPEN cfm_chk_cur;
   FETCH cfm_chk_cur
    INTO msg_out;

   IF cfm_chk_cur%FOUND AND Length(msg_out) > 0
   THEN
      return;
   END IF;
   
   
   /*-------------------------------------------------------------------------*/
         
   v_cond_cfm_flg := 'N';
   v_mnl_inp_flg := 'N';

   OPEN cond_itm_cur;
   FETCH cond_itm_cur
    INTO v_cond_cfm_flg, v_mnl_inp_flg, v_erp_if_flg, v_accl_bat_sts_cd;
    
    
   IF cond_itm_cur%NOTFOUND
   THEN
      msg_out :=  'Batch Condition not Found.';
      --v_rtn_val := 'T001';
   ELSIF cond_itm_cur%FOUND
   THEN
      IF v_cond_cfm_flg = 'N'
      THEN
         msg_out := 'Batch Condition not Confirm';
         --v_rtn_val := 'N';
--      ELSIF v_cond_cfm_flg = 'Y' AND v_mnl_inp_flg = 'N'
--      THEN
--         IF v_accl_bat_sts_cd = 'BPR'   --Batch program running.
--         THEN
--            msg_out := 'Batch Program Running.';
--            --v_rtn_val := 'R';
--         ELSE
--            OPEN bat_his_cur;

--            FETCH bat_his_cur
--             INTO v_bat_id, v_bat_cmpl_flg;

--            IF bat_his_cur%FOUND
--            THEN
--               IF v_bat_cmpl_flg = 'Y'   --Batch Program add Start
--               THEN
--                  msg_out := 'Execute year month add Start.';
--                  --v_rtn_val := 'A';
--               END IF;
--            ELSIF bat_his_cur%NOTFOUND
--            THEN   --Batch Program first Start
--               msg_out := 'Batch Program first Start.';
--               --v_rtn_val := 'F';
--            END IF;

--            CLOSE bat_his_cur;
--         END IF;
      ELSIF     v_cond_cfm_flg = 'Y'
            AND v_mnl_inp_flg = 'Y'   --반드시 Manual Account Input 후 ERP Interface 가 가능함
      THEN
         IF v_erp_if_flg = 'N'
         THEN
            msg_out := 'Manual accrual amount has been already input, can''t start batch again.';
            v_rtn_val := 'M';
         ELSE
            msg_out := 'ERP interface has been already done, can''t start batch again.';
            --v_rtn_val := 'E';
         END IF;
      END IF;
   END IF;

   /* CLose Cursors */
   CLOSE skd_tbl_bkup;
   CLOSE cond_itm_cur;
   CLOSE cfm_chk_cur;
   CLOSE objects_vaild;
   
   lea_log_prc ('lea_accl_bat_cond_chk_prc() End.');
   
EXCEPTION
   WHEN NO_DATA_FOUND
   THEN
      CLOSE skd_tbl_bkup;
      CLOSE cond_itm_cur;
      CLOSE cfm_chk_cur;
      CLOSE objects_vaild;
      
      DBMS_OUTPUT.put_line ('No Data Found');
      msg_out := 'No Data Found';
   WHEN OTHERS
   THEN
      CLOSE skd_tbl_bkup;
      CLOSE cond_itm_cur;
      CLOSE cfm_chk_cur;
      CLOSE objects_vaild;
      lea_log_prc('[lea_bat_cond_chk_prc] : Error!! ' || SQLERRM || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
      DBMS_OUTPUT.put_line ('[lea_bat_cond_chk_prc] : Error!! ' || SQLERRM || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
      
END;