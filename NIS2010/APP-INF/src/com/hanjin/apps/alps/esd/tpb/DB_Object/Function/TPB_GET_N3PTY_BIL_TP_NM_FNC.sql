CREATE OR REPLACE FUNCTION NISADM.TPB_GET_N3PTY_BIL_TP_NM_FNC

/*******************************************************************************
   1. Object Name      : TPB_GET_N3PTY_BIL_TP_NM_FNC
   2. Version          : 1.1
   3. Create Date      : 2008.09.04
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : (TPB) GETTING THIRD PARTY BILLING TYPE NAME
   7. Revision History : 2008-09-04  Kim Jin-seung  1.0  Created
                         2009.08.31  Park Sung-Jin  1.1  ALPS Migration
   * ex) 
     SELECT TPB_GET_N3PTY_BIL_TP_NM_FNC('CD') FROM DUAL ; 
*******************************************************************************/

-- ===== Arguments ========================================
(   
    in_n3pty_bil_tp_cd  in TPB_N3RD_PTY_BIL_TP.N3PTY_BIL_TP_CD%TYPE  -- billing type code
) 


RETURN VARCHAR2 -- RETURN TYPE 

AUTHID CURRENT_USER

IS 

-- ===== DECLARE ==========================================
    v_n3pty_bil_tp_nm  TPB_N3RD_PTY_BIL_TP.N3PTY_BIL_TP_NM%TYPE; 

-- ===== BEGIN, EXCEPTION  ======================================
BEGIN


    --- Getting billing type name
    SELECT N3PTY_BIL_TP_NM
    INTO v_n3pty_bil_tp_nm 
    FROM TPB_N3RD_PTY_BIL_TP 
    WHERE N3PTY_BIL_TP_CD = in_n3pty_bil_tp_cd
    ;

    --- Returning Result 
    RETURN v_n3pty_bil_tp_nm; 

END

-- ===== End of Function ==================================
;