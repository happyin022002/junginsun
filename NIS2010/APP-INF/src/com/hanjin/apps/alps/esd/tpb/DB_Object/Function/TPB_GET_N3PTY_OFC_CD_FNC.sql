CREATE OR REPLACE FUNCTION NISADM.TPB_GET_N3PTY_OFC_CD_FNC

/*******************************************************************************
   1. Object Name      : TPB_GET_N3PTY_OFC_CD_FNC
   2. Version          : 1.1
   3. Create Date      : 2008.09.04
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : Getting the 3rd Party Office Code of the General Office 
                         ------------------------------------------------------
                         SELECT TPB_GET_N3PTY_OFC_CD_FNC('BOMBA') FROM DUAL ; 
                         ------------------------------------------------------
   7. Revision History : 2008.09.04  Kim Jin-seung  1.0  Created
                         2009.08.05  O Wan-Ki       1.1  ALPS Migration
*******************************************************************************/

-- ===== Arguments ========================================
(    
    in_ofc_cd      in TPB_HNDL_OFC.OFC_CD%TYPE  -- General Office code     
) 


RETURN VARCHAR2 -- RETURN TYPE 
AUTHID CURRENT_USER

IS 

-- ===== DECLARE ==========================================
    v_ofc_cd TPB_HNDL_OFC.N3PTY_OFC_CD%TYPE; -- TPB OFFICE


-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles 
    v_ofc_cd := NULL; 

    --- Getting ofc_cd
    SELECT N3PTY_OFC_CD 
    INTO v_ofc_cd
    FROM TPB_HNDL_OFC 
    WHERE 1=1
        AND N3PTY_OFC_TP_CD = 'G' 
        AND OFC_CD = in_ofc_cd 
        AND DELT_FLG = 'N'
    ; 


    --- Returning Result 
    RETURN v_ofc_cd; 

END

-- ===== End of Function ==================================
;