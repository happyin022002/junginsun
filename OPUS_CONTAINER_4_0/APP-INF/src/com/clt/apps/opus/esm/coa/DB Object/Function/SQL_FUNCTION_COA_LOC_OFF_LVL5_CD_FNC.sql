CREATE OR REPLACE FUNCTION OPUSADM."COA_LOC_OFF_LVL5_CD_FNC" 
/******************************************************************************
   Name         :   COA_LOC_OFF_CD_FNC
   Purpose      :   Location office 조회
   Source       :   MDM_LOCATION, COA_OFC_LVL
   Target       :
   Example      :
   SELECT COA_LOC_OFF_LVL4_CD_FNC ('KRPUS','200812') finc_ctrl_ofc_cd
   FROM DUAL
******************************************************************************/

-- ===== Arguments ========================================
(in_loc_cd         IN VARCHAR
,in_bzc_cost_yrmon IN VARCHAR)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_finc_ctrl_ofc_cd   mdm_location.finc_ctrl_ofc_cd%TYPE;
   v_bzc_cost_yrmon     COA_OFC_LVL.OFC_APLY_FM_YRMON%TYPE;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
   BEGIN
      
      IF in_bzc_cost_yrmon IS NULL 
      THEN      
        v_bzc_cost_yrmon := TO_CHAR(SYSDATE,'YYYYMM');
      ELSE
        v_bzc_cost_yrmon := in_bzc_cost_yrmon;
      END IF;
      
      SELECT COALESCE(finc_ctrl_ofc_cd, eq_ctrl_ofc_cd, sls_ofc_cd)
        INTO v_finc_ctrl_ofc_cd
        FROM mdm_location
       WHERE loc_cd = in_loc_cd;

      
      SELECT ofc_n5th_lvl_cd
        INTO v_finc_ctrl_ofc_cd
        FROM coa_ofc_lvl
       WHERE v_bzc_cost_yrmon BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON
--             cost_yrmon = NVL(in_bzc_cost_yrmon,TO_CHAR(SYSDATE,'YYYYMM'))
         AND ofc_cd = v_finc_ctrl_ofc_cd;

   EXCEPTION
      WHEN OTHERS
      THEN
         BEGIN
            v_finc_ctrl_ofc_cd := 'X';
         END;
   END;

   RETURN v_finc_ctrl_ofc_cd;
END;
-- ===== End of Function ==================================