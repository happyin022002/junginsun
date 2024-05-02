CREATE OR REPLACE FUNCTION OPUSADM."COA_LOC_FNC" (in_loc IN VARCHAR, in_para IN VARCHAR)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
   
/******************************************************************************
   Name         :   COA_LOC_FNC
   Purpose      :   SCC, ECC, LCC, RCC 조회
   Source       :   COA_LOCATION_V
   Target       :   
   Example      :
   SELECT coa_loc_fnc ('AEJEA', 'ECC') nod_cd
   FROM DUAL

   in_pctl_no : pctl_no
   in_loc     : ['NOD','LOC','SCC', 'ECC', 'LCC', 'RCC']

******************************************************************************/
IS
-- ===== DECLARE ==========================================
   v_rslt_loc_cd   coa_location_v.ecc_cd%TYPE;
   v_scc_cd        coa_location_v.ecc_cd%TYPE;
   v_ecc_cd        coa_location_v.ecc_cd%TYPE;
   v_lcc_cd        coa_location_v.ecc_cd%TYPE;
   v_rcc_cd        coa_location_v.ecc_cd%TYPE;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
   BEGIN
      SELECT scc_cd
            ,ecc_cd
            ,lcc_cd
            ,rcc_cd
        INTO v_scc_cd
            ,v_ecc_cd
            ,v_lcc_cd
            ,v_rcc_cd
        FROM coa_location_v
       WHERE loc_cd = SUBSTR(in_loc, 1, 5);

      IF ('NOD' = UPPER(in_para))
      THEN
         v_rslt_loc_cd := in_loc;
      ELSIF('LOC' = UPPER(in_para))
      THEN
         v_rslt_loc_cd := SUBSTR(in_loc, 1, 5);
      ELSIF('SCC' = UPPER(in_para))
      THEN
         v_rslt_loc_cd := v_scc_cd;
      ELSIF('ECC' = UPPER(in_para))
      THEN
         v_rslt_loc_cd := v_ecc_cd;
      ELSIF('LCC' = UPPER(in_para))
      THEN
         v_rslt_loc_cd := v_lcc_cd;
      ELSIF('RCC' = UPPER(in_para))
      THEN
         v_rslt_loc_cd := v_rcc_cd;
      END IF;
   EXCEPTION
      WHEN NO_DATA_FOUND
      THEN
         BEGIN
            v_rslt_loc_cd := '';
         END;
      WHEN OTHERS
      THEN
         BEGIN
            v_rslt_loc_cd := '';
         END;
   END;

   RETURN v_rslt_loc_cd;
END;
-- ===== End of Function ==================================