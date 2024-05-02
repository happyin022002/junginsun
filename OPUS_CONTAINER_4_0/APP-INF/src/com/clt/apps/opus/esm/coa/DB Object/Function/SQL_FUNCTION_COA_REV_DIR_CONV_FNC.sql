CREATE OR REPLACE FUNCTION OPUSADM."COA_REV_DIR_CONV_FNC" 
/******************************************************************************
   Name         :   COA_REV_DIR_CONV_FNC
   Purpose      :   rev_direction 를 찾는다.
   Source       :   AR_FINC_DIR_CONV
   Target       :  
   Example      :
   SELECT coa_rev_dir_conv_fnc  ('APW', 'KRINC', 'E')  rev_dir
   FROM DUAL  
******************************************************************************/

-- ===== Arguments ========================================
(in_slane IN VARCHAR, in_pol_cd IN VARCHAR, in_dir_cd IN VARCHAR)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_err_msg        VARCHAR2(1000);
   v_rlane_dir_cd   ar_finc_dir_conv.rlane_dir_cd%TYPE;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
   BEGIN
      SELECT rlane_dir_cd
        INTO v_rlane_dir_cd
        FROM ar_finc_dir_conv
       WHERE slan_cd = in_slane
         AND sconti_cd = (SELECT sconti_cd
                            FROM mdm_location
                           WHERE loc_cd = in_pol_cd)
         AND slan_dir_cd = in_dir_cd
         AND DELT_FLG ='N';
   EXCEPTION
      WHEN OTHERS
      THEN
--         enis_log_prc(SYSDATE, 'coa_rev_dir_conv_fnc', SQLERRM);
--         enis_log_prc(SYSDATE, 'coa_rev_dir_conv_fnc', v_err_msg);
--         enis_log_prc(SYSDATE, 'coa_rev_dir_conv_fnc', 'in_slane: ' || in_slane);
--         enis_log_prc(SYSDATE, 'coa_rev_dir_conv_fnc', 'in_pol_cd: ' || in_pol_cd);
--         enis_log_prc(SYSDATE, 'coa_rev_dir_conv_fnc', 'in_dir_cd: ' || in_dir_cd);
         v_rlane_dir_cd := in_dir_cd;
   END;

   RETURN v_rlane_dir_cd;
END;
-- ===== End of Function ==================================