CREATE OR REPLACE FUNCTION "COA_RLANE_TRD_CONV_FNC" 
  
/*******************************************************************************
   1. Object Name      : COA_RLANE_TRD_CONV_FNC
   2. Version          : 1.0
   3. Create Date      : 2008.09.01
   4. Source           : MDM_TRADE, MDM_LOCATION
   5. Author           : COA
   6. Description      : Searching for Trade
   7. Revision History : 1. 2008.09.01 Create
                         2. 2015.01.16 SMY Creating RBC by all trade
   
   Example      :
   SELECT COA_RLANE_TRD_CONV_FNC ('CMQD0004W','APW', 'KRINC', 'USLGB') trd_cd
   FROM DUAL    
*******************************************************************************/  

-- ===== Arguments ========================================
(in_vvd IN VARCHAR, in_slane IN VARCHAR, in_pol_cd IN VARCHAR, in_pod_cd IN VARCHAR)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_err_msg       VARCHAR2 (1000);
   v_rep_trd_cd    mdm_rev_lane.rep_trd_cd%TYPE;
   v_rlane_cd      mdm_rev_lane.rlane_cd%TYPE;
   v_cost_yrmon    coa_mon_vvd.cost_yrmon%TYPE;
   v_vsl_slan_cd   VARCHAR(3);
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN   
    

   BEGIN
      v_vsl_slan_cd := in_slane;
      SELECT trd_cd 
        INTO v_rep_trd_cd
        FROM mdm_dtl_rev_lane  
       WHERE vsl_slan_dir_cd  = SUBSTR(in_vvd, 9, 1)
         AND fm_conti_cd = (SELECT conti_cd
                              FROM mdm_location
                             WHERE loc_cd = in_pol_cd)
         AND to_conti_cd = (SELECT conti_cd
                              FROM mdm_location
                             WHERE loc_cd = in_pod_cd)
         AND rlane_cd like in_slane || '%'
         AND delt_flg = 'N';  
        
   EXCEPTION
--      WHEN OTHERS
      WHEN NO_DATA_FOUND
      THEN
          BEGIN
              SELECT trd_cd 
                INTO v_rep_trd_cd
                FROM mdm_dtl_rev_lane  
               WHERE vsl_slan_dir_cd  = 'E' --SUBSTR(in_vvd, 9, 1)
                 AND fm_conti_cd = (SELECT conti_cd
                                      FROM mdm_location
                                     WHERE loc_cd = in_pol_cd)
                 AND to_conti_cd = (SELECT conti_cd
                                      FROM mdm_location
                                     WHERE loc_cd = in_pod_cd)
                 AND rlane_cd like 'RBCCO'
                 AND delt_flg = 'N';  

          EXCEPTION
        --     WHEN OTHERS
              WHEN NO_DATA_FOUND
              THEN
                   v_rep_trd_cd := 'IAT';             
      
--         enis_log_prc (SYSDATE, 'COA_RLANE_TRD_CONV_FNC',SQLERRM);
--         enis_log_prc (SYSDATE, 'COA_RLANE_TRD_CONV_FNC',v_err_msg);
--         enis_log_prc (SYSDATE, 'COA_RLANE_TRD_CONV_FNC','in_dir: ' || in_dir_cd);
--         enis_log_prc (SYSDATE, 'COA_RLANE_TRD_CONV_FNC','in_slane: ' || in_slane);
--         enis_log_prc (SYSDATE, 'COA_RLANE_TRD_CONV_FNC','in_pol_cd: ' || in_pol_cd);
--         enis_log_prc (SYSDATE, 'COA_RLANE_TRD_CONV_FNC','in_pod_cd: ' || in_pod_cd);

          END;        
   END;


   RETURN v_rep_trd_cd;
END;
-- ===== End of Function ==================================