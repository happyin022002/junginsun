CREATE OR REPLACE FUNCTION NISADM.TPB_GET_LOCL_AMT_FNC

/*******************************************************************************
   1. Object Name      : TPB_GET_LOCL_AMT_FNC
   2. Version          : 1.0
   3. Create Date      : 2010.02.11
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : 3rd Party Getting Local Amounts  
                         ------------------------------------------------------
                         SELECT TPB_GET_LOCL_AMT_FNC( USD -> Local ) ; 
                         ------------------------------------------------------
   7. Revision History : 2010.02.11  Jong-Geon Byeon  1.0  Created
*******************************************************************************/

-- ===== Arguments ========================================
(
    v_amt      IN NUMBER,   -- amount(money)
    v_curr_cd  IN VARCHAR2, -- currency code
    v_yrmon    IN DATE      -- currency rate Base Date
)


RETURN NUMBER -- RETURN TYPE
AUTHID CURRENT_USER
IS

-- ===== DECLARE ==========================================
xch_amt  NUMBER(18,2);     -- USD AMOUNTS (CHANGED)


-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles
    xch_amt := NULL;

    --- Getting LOCAL Amounts
        SELECT v_amt * R.USD_LOCL_XCH_RT LOCL_AMT
          INTO xch_amt
          FROM GL_MON_XCH_RT R
         WHERE R.CURR_CD = v_curr_cd
           AND R.ACCT_XCH_RT_LVL = '1'
           AND R.ACCT_XCH_RT_YRMON = TO_CHAR(v_yrmon,'YYYYMM')
           AND ROWNUM = 1
    ;

    --- Returning Result
    RETURN xch_amt;

END

-- ===== End of Function ==================================
;