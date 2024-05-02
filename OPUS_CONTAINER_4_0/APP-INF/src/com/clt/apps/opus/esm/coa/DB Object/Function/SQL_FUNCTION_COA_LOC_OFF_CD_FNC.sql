CREATE OR REPLACE FUNCTION OPUSADM."COA_LOC_OFF_CD_FNC" 
/******************************************************************************
   Name         :   COA_LOC_OFF_CD_FNC
   Purpose      :   Location office 조회
   Source       :   MDM_LOCATION
   Target       :  
   Example      :
   SELECT coa_loc_off_cd_fnc ('KRPUS') finc_ctrl_ofc_cd
   FROM DUAL
******************************************************************************/

-- ===== Arguments ========================================
(in_loc_cd IN VARCHAR)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_finc_ctrl_ofc_cd   mdm_location.finc_ctrl_ofc_cd%TYPE;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
   BEGIN
      SELECT NVL (finc_ctrl_ofc_cd, nvl(eq_ctrl_ofc_cd,sls_ofc_cd))
        INTO v_finc_ctrl_ofc_cd
        FROM mdm_location
       WHERE loc_cd = in_loc_cd;
   EXCEPTION
      WHEN NO_DATA_FOUND
      THEN
         BEGIN
            v_finc_ctrl_ofc_cd := 'X';
         END;
      WHEN OTHERS
      THEN
         BEGIN
            v_finc_ctrl_ofc_cd := 'X';
         END;
   END;

   RETURN v_finc_ctrl_ofc_cd;
END;