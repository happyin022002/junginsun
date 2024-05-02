CREATE OR REPLACE FUNCTION NISADM.TPB_CHK_EMAIL_ADDR_FNC

/*******************************************************************************
   1. Object Name      : TPB_CHK_EMAIL_ADDR_FNC
   2. Version          : 1.2
   3. Create Date      : 2007.04.02
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : EMAIL VALIDATION CHECKING
                         ------------------------------------------------------
                         ex) SELECT TPB_CHK_EMAIL_ADDR_FNC('abc@abc.com') FROM DUAL ;
                            SELECT email, TPB_CHK_EMAIL_ADDR_FNC(email) email_valid 
                            FROM 
                                (
                                          SELECT 'abc@abc.com'  email FROM DUAL 
                                UNION ALL SELECT 'abc@abc'      email FROM DUAL  
                                UNION ALL SELECT 'abc@abc@com'  email FROM DUAL 
                                UNION ALL SELECT 'abc@abc.'     email FROM DUAL 
                                UNION ALL SELECT 'abc@'         email FROM DUAL 
                                UNION ALL SELECT '@abc.com'     email FROM DUAL  
                                UNION ALL SELECT 'abc@abc.com;' email FROM DUAL  
                                UNION ALL SELECT 'abc@ abc.com' email FROM DUAL  
                                UNION ALL SELECT 'abcabc.com'   email FROM DUAL 
                                UNION ALL SELECT 'abc@a:bc.com' email FROM DUAL  
                                UNION ALL SELECT 'abc@abc,com'  email FROM DUAL  
                                ) 
                            WHERE 1=1      * 2007-04-09 Kim Jin-seung
                            ; 
                         ------------------------------------------------------
   7. Revision History : 2007.04.02  Kim Jin-seung  1.0  Created 
                         2007.04.09  Kim Jin-seung  1.1  Corrected : null bug correct
                         2007.05.03  Kim Jin-seung  1.2  Corrected : Optimization in Loop 
                         2009.10.05  Park Sung-Jin  1.3  ALPS Migration
*******************************************************************************/

-- ===== Arguments ========================================
(
    v_email      in VARCHAR2  -- office code
)


RETURN VARCHAR -- RETURN TYPE
AUTHID CURRENT_USER
IS

-- ===== DECLARE ==========================================
    v_invalidChars VARCHAR2(5); -- INVALID CHARACTERS
    v_badChar VARCHAR2(1); -- BAD CHARACTER ( ONE OF INVALID CHARACTERS )
    n_atPosition NUMBER(4);  -- '@' position index
    n_periodPosition NUMBER(4); 

    v_valid VARCHAR2(1); -- RETURN Y OR N


-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles
    v_valid := 'Y'; 
    v_invalidChars := ' /:,;'; 

    --- Blanck Check 
    IF v_email IS NULL OR LENGTHB(TRIM(v_email)) = 0 THEN 
       v_valid := 'N'; 
       
    ELSE
      	-- Loop invalid characters to see if it exists in email
    	WHILE ( LENGTHB(v_invalidChars) > 0  AND v_valid='Y') LOOP 
    		v_badChar := SUBSTR(v_invalidChars,1,1); 
    		IF (INSTR(v_email, v_badChar) > 0) THEN 
    		   v_valid := 'N';  --If invalid character was found, return 0 to invalidate
    		END IF; 
    		v_invalidChars := REPLACE(v_invalidChars,v_badChar,''); 
    	END LOOP;
    	
    	-- Check to see if '@' exists.
    	n_atPosition := INSTR(v_email,'@',1); 
    	IF n_atPosition <= 1 THEN -- '@' is not exists or first located
    	   v_valid := 'N';
        END IF; 
        
     	--Check to see if extra '@' exists after 1st '@'.
    	IF INSTR(v_email,'@',n_atPosition+1) > 0 THEN 
    	   v_valid := 'N';
    	END IF; 

    	n_periodPosition := INSTR(v_email,'.',n_atPosition); 
    	
    	IF n_periodPosition = 0 THEN
    	   v_valid := 'N'; 
    	END IF; 
    	
    	IF (n_periodPosition+2) > LENGTHB(v_email) THEN -- check domain char size 2 or more 
    	   v_valid := 'N'; 
    	END IF; 
    	
    	IF SUBSTRB(v_email, LENGTHB(v_email),1)='.' 
    	   OR SUBSTRB(v_email, 1,1)='.' THEN -- check last char '.'
    	   v_valid := 'N'; 
    	END IF; 

    END IF; 
	

    --- Returning Result
    RETURN v_valid;

END

-- ===== End of Function ==================================
;