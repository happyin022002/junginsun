CREATE OR REPLACE FUNCTION NISADM.TPB_GET_3RD_PARTY_NAME_FNC

/*******************************************************************************
   1. Object Name      : TPB_GET_3RD_PARTY_NAME_FNC
   2. Version          : 1.1
   3. Create Date      : 2008.09.04
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : Getting the 3RD PARTY NAME 
   7. Revision History : 2008-09-22  Kim Jin-seung  1.0  Created
                         2009.09.01  Park Sung-Jin  1.1  ALPS Migration
   * ex) 
     SELECT TPB_GET_3RD_PARTY_NAME_FNC('V','BOMBB') FROM DUAL ; 
     SELECT TPB_GET_3RD_PARTY_NAME_FNC('C','BOMBB') FROM DUAL ; 
     SELECT TPB_GET_3RD_PARTY_NAME_FNC('S','BOMBB') FROM DUAL ; 
*******************************************************************************/

-- ===== Arguments ========================================
(    
    v_vndr_cust_div_cd IN VARCHAR2, 
    v_vndr_cust_cd IN VARCHAR2
) 


RETURN VARCHAR2 -- RETURN TYPE 

AUTHID CURRENT_USER

IS 

-- ===== DECLARE ==========================================
    v_n3pty_nm VARCHAR2(100); -- VALID Y/N


-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles 
    v_n3pty_nm := '-'; 

    --- Getting business ofc_cd
    SELECT name 
    INTO v_n3pty_nm
    FROM 
        ( 
        SELECT 
            DECODE( v_vndr_cust_div_cd, 
                'V', ( SELECT vndr_lgl_eng_nm as name  
                       FROM mdm_vendor       
                       WHERE ROWNUM=1 
                            AND vndr_seq = TO_NUMBER(v_vndr_cust_cd) 
--                            AND rfnd_psdo_cust_cd IS NOT NULL 
                     ), 
                'C', ( SELECT cust_lgl_eng_nm as name   
                       FROM mdm_customer     
                       WHERE ROWNUM=1 
                            AND cust_cnt_cd = SUBSTRB(v_vndr_cust_cd,1,2)
                            AND cust_seq = TO_NUMBER(SUBSTRB(v_vndr_cust_cd,3))  
--                            AND cntr_div_flg = 'Y' 
                     ),
                'S', ( SELECT ofc_eng_nm as name   
                       FROM mdm_organization 
                       WHERE ROWNUM=1 AND ofc_cd = v_vndr_cust_cd
                     ), 
                '-' 
            ) as name  
        FROM DUAL 
        ) A
    WHERE 1=1 
    ; 
    
    --- Returning Result 
    RETURN v_n3pty_nm; 

EXCEPTION
    WHEN OTHERS THEN
        v_n3pty_nm := '-';
        RETURN v_n3pty_nm; 
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 

END

-- ===== End of Function ==================================
;