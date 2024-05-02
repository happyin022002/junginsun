CREATE OR REPLACE FUNCTION NISADM.TPB_GET_HNDL_OFC_FNC

/*******************************************************************************
   1. Object Name      : TPB_GET_HNDL_OFC_FNC
   2. Version          : 1.1
   3. Create Date      : 2008.09.04
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : Getting the Business Office code of the 3rd Party Office 
                         TPB Office에 대응되는 업무 Office를 원하는 type별로 가져온다.
                         type은 R:RHQ / C:Control / A: A/R
                         ------------------------------------------------------
                         SELECT TPB_GET_HNDL_OFC_FNC('R','BOMBB') FROM DUAL ;
                         ------------------------------------------------------
   7. Revision History : 2008.09.04  Kim Jin-seung  1.0  Created
                         2009.08.07  Park Sung-Jin  1.0  ALPS Migration
*******************************************************************************/

-- ===== Arguments ========================================
(    
    in_n3pty_ofc_tp_cd  IN TPB_HNDL_OFC.N3PTY_OFC_TP_CD%TYPE,  -- Office type : R / C / A
    in_ofc_cd           IN TPB_HNDL_OFC.OFC_CD%TYPE            -- TPB Office code     
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

    --- Getting business ofc_cd
    SELECT 
        DECODE(in_n3pty_ofc_tp_cd,
            'R', RHQ_CD,
            'C', N3PTY_CTRL_OFC_CD,
            'A', N3PTY_AR_OFC_CD, 
            NULL
        ) 
    INTO v_ofc_cd
    FROM TPB_HNDL_OFC 
    WHERE 1=1
        AND N3PTY_OFC_TP_CD = 'T' 
        AND OFC_CD = in_ofc_cd 
        AND DELT_FLG = 'N'
    ; 


    --- Returning Result 
    RETURN v_ofc_cd; 

END

-- ===== End of Function ==================================
;