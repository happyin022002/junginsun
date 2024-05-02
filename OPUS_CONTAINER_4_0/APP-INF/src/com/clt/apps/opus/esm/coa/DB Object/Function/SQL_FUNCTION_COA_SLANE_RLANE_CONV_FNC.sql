CREATE OR REPLACE FUNCTION OPUSADM."COA_SLANE_RLANE_CONV_FNC" 
/******************************************************************************
   Name         :   COA_SLANE_RLANE_CONV_FNC
   Purpose      :   RLANE 를 찾는다.
   Source       :   MDM_TRADE, MDM_LOCATION
   Target       :
   Example      :
   SELECT COA_SLANE_RLANE_CONV_FNC ('CYIT0028W','NE1', 'CNNBO', 'DEHAM') rlane
   FROM DUAL 
******************************************************************************/

-- ===== Arguments ========================================
(in_vvd IN VARCHAR, in_slane IN VARCHAR, in_pol_cd IN VARCHAR, in_pod_cd IN VARCHAR)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_err_msg       VARCHAR2(1000);
   v_cost_yrmon    coa_mon_vvd.cost_yrmon%TYPE;
   v_rep_trd_cd    mdm_rev_lane.rep_trd_cd%TYPE;
   v_rlane_cd      mdm_rev_lane.rlane_cd%TYPE;
   v_vsl_slan_cd   mdm_rev_lane.vsl_slan_cd%TYPE;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
   
    BEGIN
      v_vsl_slan_cd := in_slane;

      SELECT rlane_cd
        INTO v_rlane_cd
        FROM mdm_dtl_rev_lane
       WHERE vsl_slan_dir_cd = SUBSTR(in_vvd, 9, 1)
--         AND ioc_cd = DECODE((SELECT coa_conti_conv_fnc(v_vsl_slan_cd,conti_cd,in_pol_cd) conti_cd
--                                FROM mdm_location
--                               WHERE loc_cd = in_pol_cd), (SELECT coa_conti_conv_fnc(v_vsl_slan_cd,conti_cd,in_pod_cd) conti_cd
--                                                             FROM mdm_location
--                                                            WHERE loc_cd = in_pod_cd), 'I', 'O')
         AND fm_conti_cd = (SELECT conti_cd
                              FROM mdm_location
                             WHERE loc_cd = in_pol_cd)
         AND to_conti_cd = (SELECT conti_cd
                              FROM mdm_location
                             WHERE loc_cd = in_pod_cd)
         AND SUBSTR(rlane_cd, 1, 3) = in_slane
         AND DELT_FLG   ='N';
        
      
   EXCEPTION
--      WHEN OTHERS
      WHEN NO_DATA_FOUND
      THEN
--         enis_log_prc(SYSDATE, 'COA_SLANE_RLANE_CONV_FNC', SQLERRM);
--         enis_log_prc(SYSDATE, 'coa_slane_rlane_conv_fnc', v_err_msg);
--         enis_log_prc(SYSDATE, 'COA_SLANE_RLANE_CONV_FNC', 'in_dir: ' || in_dir_cd);
--         enis_log_prc(SYSDATE, 'COA_SLANE_RLANE_CONV_FNC', 'in_slane: ' || in_slane);
--         enis_log_prc(SYSDATE, 'COA_SLANE_RLANE_CONV_FNC', 'in_pol_cd: ' || in_pol_cd);
--         enis_log_prc(SYSDATE, 'COA_SLANE_RLANE_CONV_FNC', 'in_pod_cd: ' || in_pod_cd);
         v_rlane_cd := 'RBCCO';
   END;
   
   RETURN v_rlane_cd;
END;
-- ===== End of Function ==================================