CREATE OR REPLACE FUNCTION NISADM.TPB_CHK_FAX_NO_FNC
/*******************************************************************************
   1. Object Name      : TPB_CHK_FAX_NO_FNC
   2. Version          : 1.2
   3. Create Date      : 2007.05.03
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : EMAIL VALIDATION CHECKING
                         ------------------------------------------------------
                         ex) SELECT TPB_CHK_FAX_NO_FNC('02-1111-1111') FROM DUAL ;
                            SELECT faxno, TPB_CHK_FAX_NO_FNC(faxno) faxno_valid 
                            FROM 
                                (
                                          SELECT '+1-1234-1234'  faxno FROM DUAL 
                                UNION ALL SELECT '02-2222-2222'  faxno FROM DUAL  
                                UNION ALL SELECT '(02)3333-3333' faxno FROM DUAL 
                                UNION ALL SELECT '000.'          faxno FROM DUAL 
                                UNION ALL SELECT '1111'          faxno FROM DUAL 
                                ) 
                            WHERE 1=1     
                            ; 
                         ------------------------------------------------------
   7. Revision History : 2007.05.03  Kim Jin-seung  1.0  Created 
                         2007.12.21  Kim Jin-seung  1.1  Corrected - v_goodChar patch; varchar2(1) => varchar2(4)
                         2009.10.05  Park Sung-Jin  1.2  ALPS Migration
*******************************************************************************/


-- ===== Arguments ========================================
(
    v_fax      in VARCHAR2  -- office code
)


RETURN VARCHAR -- RETURN TYPE
AUTHID CURRENT_USER
IS

-- ===== DECLARE ==========================================
    v_faxTempChars VARCHAR2(20); -- temp fax no string
    v_validChars VARCHAR2(14); -- VALID CHARACTERS
    v_goodChar VARCHAR2(4); -- good CHARACTER ( ONE OF VALID CHARACTERS )

    v_valid VARCHAR2(1); -- RETURN Y OR N


-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles
    v_valid := 'Y'; 
    v_validChars := ' -,#1234567890'; 

    --- Blanck Check 
    IF v_fax IS NULL OR LENGTHB(TRIM(v_fax)) <= 4 THEN 
       v_valid := 'N'; 
       
    ELSE
      	-- Loop invalid characters to see if it exists in email
      	v_faxTempChars := v_fax; 
    	WHILE ( LENGTHB(v_faxTempChars) > 0 AND v_valid='Y') LOOP 
    		v_goodChar := SUBSTR(v_faxTempChars,1,1); 
    		IF (INSTR(v_validChars, v_goodChar) <= 0) THEN 
    		   v_valid := 'N';  --If invalid character was found, return 'N' to invalidate
    		END IF; 
    		v_faxTempChars := REPLACE(v_faxTempChars,v_goodChar,''); 
    	END LOOP;

    END IF; 
	

    --- Returning Result
    RETURN v_valid;

END

-- ===== End of Function ==================================
;