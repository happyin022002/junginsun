CREATE OR REPLACE FUNCTION NISADM.TPB_GET_OFC_BIL_CURR_CD_FNC

/*******************************************************************************
   1. Object Name      : TPB_GET_OFC_BIL_CURR_CD_FNC
   2. Version          : 1.1
   3. Create Date      : 2008.09.04
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : (TPB) GETTING BILLING CURRENCY CODE OF OFFICE FROM MDM ORGANIZATION INFO
   7. Revision History : 2008-09-04  Kim Jin-seung  1.0  Created
                         2009.08.31  Park Sung-Jin  1.1  ALPS Migration
   * ex) 
     SELECT TPB_GET_OFC_BIL_CURR_CD_FNC('PUSBO') FROM DUAL ; 
*******************************************************************************/

-- ===== Arguments ========================================
(   
    in_ofc_cd  in MDM_ORGANIZATION.OFC_CD%TYPE  -- OFFICE CODE
) 

RETURN VARCHAR2 -- RETURN TYPE 

AUTHID CURRENT_USER

IS 

-- ===== DECLARE ==========================================
    v_bil_curr_cd  MDM_ORGANIZATION.BIL_CURR_CD%TYPE; 

-- ===== BEGIN, EXCEPTION  ======================================
BEGIN


    --- Getting billing type name
    SELECT BIL_CURR_CD 
    INTO v_bil_curr_cd 
    FROM MDM_ORGANIZATION 
    WHERE OFC_CD = in_ofc_cd
    ; 
    
    --- Returning Result 
    RETURN v_bil_curr_cd; 

END

-- ===== End of Function ==================================
;