CREATE OR REPLACE PROCEDURE OPUSADM."BSA_CREATE_DAILY_BATCH_PRC" 
(
    p_year       IN  VARCHAR2,
    p_week       IN  VARCHAR2,
    p_duration   IN  VARCHAR2,
    p_step       IN  VARCHAR2,
    p_only_step  IN  VARCHAR2, -- Y :  p_step만 실행, N : 이전단계 포함하여 실행
    p_bsacoa     IN  VARCHAR2, -- BSA, COA
    p_trd_cd     IN  VARCHAR2, -- Optional
    p_rlane_cd   IN  VARCHAR2, -- Optional
    p_ioc_cd     IN  VARCHAR2, -- Optional
    p_vsl_cd     IN  VARCHAR2, -- Optional
    p_skd_voy_no IN  VARCHAR2, -- Optional
    p_dir_cd     IN  VARCHAR2, -- Optional
    p_user_id    IN  VARCHAR2, -- Input User ID
    p_error_code OUT VARCHAR2,
    p_error_msg  OUT VARCHAR2
)
Authid current_user
IS
/******************************************************************************
   Name         :   BSA_CREATE_DAILY_BATCH_PRC
   Purpose      :   
   Source       :   
   Target       :   
   Ver          :   1.0
   Date         :   2007.11.
   System       :   Sales ManageMent > BSA
   Author       :   
******************************************************************************/
/*
  1.Name       : 
  2.Create Date: 2007-11-
  3.Description:
      - 용    도: Daily Batch 돌리기 위한 프로시져 
      - 파라미터: 
      - 특이사항
      ====> p_step 단계
          1. BSA Contract 정보 생성
          2. BSA VVD 정보 생성
          3. BSA VVD 정보 Reset
          4. BSA VVD 의 특정 정보 0 으로 만들기
      
  4.Revision History
*/
------------------------------[ 변수선언부             ]--------------------------
    /** 작업로그 관련 변수선언 **/
    v_mig_pgm_nm       varchar2(100)  := 'BSA_CREATE_DAILY_BATCH_PRC' ;
    v_mig_err_msg      varchar2(1000)                                ;
    v_err_dtl_msg      varchar2(1000)                                ;
    v_mig_msg          varchar2(1000)                                ;
    v_fm_yrwk          varchar2(6)                                   ;
    v_to_yrwk          varchar2(6)                                   ;
    /* 오류 변수 선언 */
    vvd_cre_error EXCEPTION;
    v_weekly_chk varchar2(1) :='N';
-- 예외의 이름을 선언
    not_completed EXCEPTION;     -- STEP 1
    
------------------------------- [ 업무로직 구현부] -------------------------------
BEGIN
    
--exec_dt in date,
--mod_name in varchar,
--log_desc in varchar default 'Processed',
--appl_info in varchar default null)
 
    -- 1. BSA Contract 정보 생성
    IF (p_step = '1' AND p_only_step = 'Y') OR ((p_step >= '1' AND p_only_step = 'N')) THEN
        
        SELECT  MIN(cost_yrwk) fm_yrwk, MAX(cost_yrwk) to_yrwk
          INTO  v_fm_yrwk, v_to_yrwk
          FROM  (
                SELECT  cost_yr||cost_wk as cost_yrwk
                  FROM  coa_wk_prd
                 WHERE  cost_yr || cost_wk  >= p_year || p_week
                 ORDER BY cost_yr || cost_wk
                 )
         WHERE  ROWNUM <= p_duration
        ;
        
        -- 1-1. batchBSACreate    ---------------------------------------------------------------------------------------------------
        v_err_dtl_msg := '1-1. batchBSACreate';
        BSA_CREATE_PRC(v_fm_yrwk,v_to_yrwk,'',p_trd_cd, p_rlane_cd,p_dir_cd, p_user_id, p_error_code, p_error_msg);
        
        IF p_error_code <> '00000' THEN 
            enis_log_prc(SYSDATE, v_mig_pgm_nm, '1-1. BSACreateError!(' || p_error_msg || ')', v_err_dtl_msg);
            RAISE not_completed;           
            
        ELSE
            enis_log_prc(SYSDATE, v_mig_pgm_nm, '1-1. BSACreateCompleted!(' || v_fm_yrwk ||'~'|| v_to_yrwk || ')', v_err_dtl_msg);
        END IF;         
        -- 1-2. batchBSAUpdateCreate  -----------------------------------------------------------------------------------------------
        v_err_dtl_msg := '1-2. batchBSAUpdateCreate';
        BSA_CREATE_REVISE_PRC(p_error_code, p_error_msg);
        
        IF p_error_code <> '00000' THEN 
            enis_log_prc(SYSDATE, v_mig_pgm_nm, '1-2. BSAUpdateCreateError!(' || p_error_msg || ')', v_err_dtl_msg);
            RAISE not_completed;         
            
        ELSE
            enis_log_prc(SYSDATE, v_mig_pgm_nm, '1-2. BSAUpdateCreateCompleted!', v_err_dtl_msg);
        END IF;         
    END IF;
 
     -- 2. BSA VVD 정보 생성
    IF (p_step = '2' AND p_only_step = 'Y') OR ((p_step >= '2' AND p_only_step = 'N')) THEN
        FOR param IN (
                      SELECT  cost_yr, SUBSTR(MIN(cost_yr||cost_wk),5,2) fm_wk
                                     , SUBSTR(MAX(cost_yr||cost_wk),5,2) to_wk
                        FROM  (
                              SELECT  cost_yr, cost_wk
                                FROM  coa_wk_prd
                               WHERE  cost_yr || cost_wk  >= p_year || p_week
                               ORDER BY cost_yr || cost_wk
                               )
                       WHERE  ROWNUM <= p_duration
                       GROUP BY cost_yr
                      ) LOOP
         
            -- 2-1. batchBSAVVDCreate  ----------------------------------------------------------------------------------------------
            v_err_dtl_msg := '2. batchBSAVVDCreate';
            BSA_CREATE_VVD_PRC(param.cost_yr,  '', '', param.fm_wk, param.to_wk, p_trd_cd, p_rlane_cd, p_ioc_cd, p_vsl_cd, p_skd_voy_no, p_dir_cd, p_user_id, p_error_code, p_error_msg); 
            
            IF p_error_code <> '00000' THEN 
                enis_log_prc(SYSDATE, v_mig_pgm_nm, '2. BSAVVDCreateError!(' || p_error_msg || ')', v_err_dtl_msg);
                RAISE not_completed;               
                
            ELSE
                enis_log_prc(SYSDATE, v_mig_pgm_nm, '2. BSAVVDCreateCompleted!(' || v_fm_yrwk ||'~'|| v_to_yrwk || ')', v_err_dtl_msg);
            END IF;         
        
        END LOOP;
    END IF;

     -- 3. BSA VVD 정보 Reset
    IF (p_step = '3' AND p_only_step = 'Y') OR ((p_step >= '3' AND p_only_step = 'N')) THEN
        FOR param IN (                      
                      SELECT  cost_yr, SUBSTR(MIN(cost_yr||cost_wk),5,2) fm_wk
                                     , SUBSTR(MAX(cost_yr||cost_wk),5,2) to_wk
                        FROM  (
                              SELECT  cost_yr, cost_wk
                                FROM  coa_wk_prd
                               WHERE  cost_yr || cost_wk  >= p_year || p_week
                               ORDER BY cost_yr || cost_wk
                               )
                       WHERE  ROWNUM <= p_duration
                       GROUP BY cost_yr
                    ) LOOP
                    
            -- 3. batchBSAVVDReset  -----------------------------------------------------------------------------------------------
            v_err_dtl_msg := '3. batchBSAVVDReset';
            BSA_RESET_VVD_PRC(param.cost_yr,  '', '', param.fm_wk, param.to_wk, p_trd_cd, p_rlane_cd, p_ioc_cd, p_vsl_cd, p_skd_voy_no, p_dir_cd, p_user_id, p_error_code, p_error_msg); 
            
            IF p_error_code <> '00000' THEN 
                enis_log_prc(SYSDATE, v_mig_pgm_nm, '3. BSAVVDResetError!(' || p_error_msg || ')', v_err_dtl_msg);
                RAISE not_completed;             
                
            ELSE
                enis_log_prc(SYSDATE, v_mig_pgm_nm, '3. BSAVVDResetCompleted!(' || param.cost_yr ||','||  param.fm_wk ||'~'|| param.to_wk || ')', v_err_dtl_msg);
            END IF;  
            COMMIT;       
        
        END LOOP;  
    END IF;

     -- 4. BSA VVD 정보 중 특정 항차들에 대해서 값을 '0'으로 만들어 준다.
    IF (p_step = '4' AND p_only_step = 'Y') OR ((p_step >= '4' AND p_only_step = 'N')) THEN  
        v_err_dtl_msg := '4. batchBSAVVDZero';         
        -- 8. batchBSAVVDZero  ------------------------------------------------------------------------------------------------
        BSA_RESET_VVD_ZERO_PRC(p_trd_cd, p_rlane_cd, p_ioc_cd, p_vsl_cd, p_skd_voy_no, p_dir_cd, p_user_id, p_error_code, p_error_msg); 
        
        IF p_error_code <> '00000' THEN 
            enis_log_prc(SYSDATE, v_mig_pgm_nm, '4. BSAVVDZeroError!(' || p_error_msg || ')', v_err_dtl_msg);
            RAISE not_completed;         
            
        ELSE
            enis_log_prc(SYSDATE, v_mig_pgm_nm, '4. BSAVVDZeroCompleted!', v_err_dtl_msg);
        END IF;      

    END IF;
    
    /* 성공적으로 항차 생성 완료시 */
    p_error_code := '00000';
    p_error_msg  := 'Completed!';
--    DBMS_OUTPUT.PUT_LINE('BSA_CREATE_DAILY_BATCH_PRC Completed!!');
--    COMMIT;
-----------------[ 예외처리부            ]-----------------------
   EXCEPTION
     WHEN not_completed THEN
         rollback;
         p_error_code   := SQLCODE;
         p_error_msg    := v_mig_msg || '[' || v_err_dtl_msg || p_error_code|| ': ' || p_error_msg || '] >>> '|| SQLERRM;
         enis_log_prc(SYSDATE, v_mig_pgm_nm, p_error_msg,'DailyBatch');
     
     WHEN OTHERS THEN
         rollback;
         p_error_code   := SQLCODE;
         p_error_msg    := v_mig_msg || '[' || v_err_dtl_msg || p_error_code|| ': ' || p_error_msg || '] >>> '|| SQLERRM;
         enis_log_prc(SYSDATE, v_mig_pgm_nm, p_error_msg,'DailyBatch');
END BSA_CREATE_DAILY_BATCH_PRC;