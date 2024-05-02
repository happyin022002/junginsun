CREATE OR REPLACE FUNCTION OPUSADM."COA_GET_OFC_LEVEL_FNC" 
/******************************************************************************
   Name         :   COA_GET_CD_NM_FNC 
   Purpose      :   공통코드명 조회
   Source       :   COA_OFC_LVL,MDM_ORGANIZATION
   Target       :     
   Example      :
   SELECT COA_GET_OFC_LEVEL_FNC('SHAAAG') cd_nm
   FROM DUAL
                        
******************************************************************************/

-- ===== Arguments ========================================
(p_ofc_cd IN VARCHAR)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_ofc_lvl     varchar2(1) ;
   v_prnt_ofc_cd varchar2(6) ;
   v_ofc_cd      varchar2(6);
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
  BEGIN
         
     SELECT ofc_lvl
       INTO v_ofc_lvl
       FROM coa_ofc_lvl
      WHERE ofc_cd     = p_ofc_cd
        AND to_char(SYSDATE, 'YYYYMM') BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON -- 20081222
     ;  

   EXCEPTION
      WHEN NO_DATA_FOUND THEN 
         BEGIN
            SELECT '1'
              INTO v_ofc_lvl            
              FROM mdm_organization
             WHERE sls_ofc_div_cd = 'HO'
               AND NVL(delt_flg, 'N')  = 'N'
               AND loc_cd         LIKE 'HQ%'
               AND ofc_cd         =  v_ofc_cd
              ; 
         EXCEPTION
           WHEN OTHERS THEN
            v_ofc_lvl :='1';
         END;
      WHEN OTHERS THEN
        v_ofc_lvl :='1';
   END;         
       
       RETURN v_ofc_lvl;
END;
-- ===== End of Function ==================================