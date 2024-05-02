CREATE OR REPLACE FUNCTION OPUSADM."COA_GET_COM_NM_FNC" 
/******************************************************************************
   Name         :   COA_GET_COM_NM_FNC
   Purpose      :   단독코드명 조회
   Source       :
   Target       :  
   Example      :
   SELECT coa_get_com_nm_fnc ('COA_COST_SRC_CD', 'TRTCWT') com_nm
   FROM DUAL

   SELECT coa_get_com_nm_fnc ('coa_cost_src_cd', 'TRTCWT') com_nm
   FROM DUAL
******************************************************************************/

-- ===== Arguments ========================================
(in_cd_nm IN VARCHAR, in_cd_val IN VARCHAR)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_com_nm   VARCHAR(1000) := NULL;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
   BEGIN
      IF (UPPER(in_cd_nm) = 'COA_COST_SRC_CD')
      THEN
         SELECT coa_cost_src_cd_nm
           INTO v_com_nm
           FROM coa_cost_src_acct
          WHERE coa_cost_src_cd = in_cd_val;
      END IF;

      IF (UPPER(in_cd_nm) = 'STND_COST_CD')
      THEN
         SELECT stnd_cost_nm
           INTO v_com_nm
           FROM coa_stnd_acct
          WHERE stnd_cost_cd = in_cd_val;
      END IF;

      IF (UPPER(in_cd_nm) = 'COST_ACT_GRP_CD')
      THEN
         SELECT cost_act_grp_nm
           INTO v_com_nm
           FROM prd_cost_act_grp
          WHERE cost_act_grp_cd = in_cd_val;
      END IF;
   EXCEPTION
      WHEN OTHERS
      THEN
         BEGIN
            v_com_nm := NULL;
         END;
   END;

   RETURN v_com_nm;
END;
-- ===== End of Function ==================================