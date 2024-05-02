CREATE OR REPLACE FUNCTION OPUSADM."COA_GET_FINC_LOC_CD_FNC" 
/******************************************************************************
   Name         :   COA_GET_FINC_LOC_CD_FNC
   Purpose      :   상위 LOCATION 조회
   Source       :   MDM_LOCATION
   Target       :
   Example      :   SELECT coa_get_finc_loc_cd_fnc ('USZMV', 'AGT') loc_cd FROM DUAL 

******************************************************************************/

-- ===== Arguments ========================================
(in_loc_cd IN VARCHAR, in_sys_cd IN VARCHAR)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_loc_cd   mdm_organization.loc_cd%TYPE;
-- ===== BEGIN, EXCEPTION  ================================
BEGIN
   v_loc_cd := '';

   IF (in_sys_cd = 'AGT')
   THEN
      BEGIN
         --상위로케이션 찾기
         SELECT loc_cd
           INTO v_loc_cd
           FROM mdm_organization
          WHERE ofc_cd = (SELECT finc_ctrl_ofc_cd
                            FROM mdm_location
                           WHERE loc_cd = in_loc_cd
                             AND delt_flg = 'N')
            AND delt_flg = 'N';
      EXCEPTION
         WHEN NO_DATA_FOUND
         THEN
            BEGIN
               v_loc_cd := 'XXXXX';
            END;
         WHEN OTHERS
         THEN
            BEGIN
               v_loc_cd := 'XXXXX';
            END;
      END;
   END IF;

   RETURN v_loc_cd;
END;
-- ===== End of Function ==================================