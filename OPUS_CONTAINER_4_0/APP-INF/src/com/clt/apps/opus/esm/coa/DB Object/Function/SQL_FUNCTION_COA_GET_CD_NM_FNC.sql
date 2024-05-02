CREATE OR REPLACE FUNCTION OPUSADM."COA_GET_CD_NM_FNC" 
/******************************************************************************
   Name         :   COA_GET_CD_NM_FNC 
   Purpose      :   공통코드명 조회
   Source       :   COM_INTG_CD_DTL
   Target       :
   Example      :
   SELECT coa_get_cd_nm_fnc ('CD00849', 'D') cd_nm
   FROM DUAL
    
******************************************************************************/

-- ===== Arguments ========================================
(in_intg_cd_id IN VARCHAR, in_intg_cd_val_ctnt IN VARCHAR)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_cd_nm   com_intg_cd_dtl.intg_cd_val_dp_desc%TYPE;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
   BEGIN
      SELECT intg_cd_val_dp_desc
        INTO v_cd_nm
        FROM com_intg_cd_dtl
       WHERE intg_cd_id = in_intg_cd_id
         AND intg_cd_val_ctnt = in_intg_cd_val_ctnt;
   EXCEPTION
      WHEN NO_DATA_FOUND
      THEN
         BEGIN
            v_cd_nm := '';
         END;
      WHEN OTHERS
      THEN
         BEGIN
            v_cd_nm := '';
         END;
   END;

   RETURN v_cd_nm;
END;
-- ===== End of Function ==================================