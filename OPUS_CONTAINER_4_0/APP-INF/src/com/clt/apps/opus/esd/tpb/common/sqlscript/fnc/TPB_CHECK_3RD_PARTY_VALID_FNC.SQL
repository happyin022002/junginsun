CREATE OR REPLACE FUNCTION OPUSADM."TPB_CHECK_3RD_PARTY_VALID_FNC" 

/*******************************************************************************
   1. Object Name      : TPB_CHECK_3RD_PARTY_VALID_FNC
   2. Version          : 1.1
   3. Create Date      : 2008.09.19
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : Getting the Business Office code of the 3rd Party Office 
   7. Revision History : 2008.09.19  Kim Jin-seung  1.0  Created
                         2009.09.01  Park Sung-Jin  1.1  Migration

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
    v_valid_yn VARCHAR2(1); -- VALID Y/N


-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles 
    v_valid_yn := 'N'; 

    --- Getting business ofc_cd
    SELECT DECODE( SIGN(CNT), 1, 'Y', 'N') valid_yn 
    INTO v_valid_yn
    FROM 
        ( 
        SELECT 
            DECODE( v_vndr_cust_div_cd, 
                'V', ( SELECT COUNT(0)  
                       FROM mdm_vendor       
                       WHERE ROWNUM=1 
                            AND vndr_seq = TO_NUMBER(v_vndr_cust_cd) 
                            AND rfnd_psdo_cust_cd IS NOT NULL 
                     ), 
                'C', ( SELECT COUNT(0)  
                       FROM mdm_customer     
                       WHERE ROWNUM=1 
                            AND cust_cnt_cd = SUBSTRB(v_vndr_cust_cd,1,2)
                            AND cust_seq = TO_NUMBER(SUBSTRB(v_vndr_cust_cd,3))  
                            AND cntr_div_flg = 'Y' 
                     ),
                'S', ( SELECT COUNT(0)  
                       FROM mdm_organization 
                       WHERE ROWNUM=1 AND ofc_cd = v_vndr_cust_cd
                     ), 
                0 
            ) CNT 
        FROM DUAL 
        ) A
    WHERE 1=1 
    ; 
    
    --- Returning Result 
    RETURN v_valid_yn; 

EXCEPTION
    WHEN OTHERS THEN
        v_valid_yn := 'N';
        RETURN v_valid_yn; 
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 

END

-- ===== End of Function ==================================
;

GRANT EXECUTE ON OPUSADM.TPB_CHECK_3RD_PARTY_VALID_FNC TO OPUSDEV;
GRANT EXECUTE ON OPUSADM.TPB_CHECK_3RD_PARTY_VALID_FNC TO OPUS_ROLE;