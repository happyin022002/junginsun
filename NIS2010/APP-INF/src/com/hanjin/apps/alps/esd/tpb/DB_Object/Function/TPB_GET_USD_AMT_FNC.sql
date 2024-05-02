CREATE OR REPLACE FUNCTION NISADM.TPB_GET_USD_AMT_FNC

/*******************************************************************************
   1. Object Name      : TPB_GET_TRD_FNC
   2. Version          : 1.0
   3. Create Date      : 2006.10.30
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : 3rd Party Getting USD Amounts  
                         ------------------------------------------------------
                         SELECT TPB_GET_USD_AMT_FNC(1000,'KRW',SYSDATE) FROM DUAL ; 
                         ------------------------------------------------------
   7. Revision History : 2006.10.30  Kim Jin-seung    1.0  Created
                         2009.08.07  Byeon Jong-Geon  1.1  ALPS Migration
*******************************************************************************/

-- ===== Arguments ========================================
(
    n_amt      in NUMBER,   -- amount(money)
    v_curr_cd  in VARCHAR2, -- currency code
    v_yrmon    in DATE      -- currency rate Base Date
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

    --- Getting USD Amounts
    SELECT ROUND(n_amt/r.usd_locl_xch_rt,2) usd_amt
    INTO xch_amt
    FROM gl_mon_xch_rt r
    WHERE r.curr_cd = v_curr_cd
        AND r.acct_xch_rt_lvl = '1'
        AND r.acct_xch_rt_yrmon = TO_CHAR(v_yrmon,'YYYYMM')
        AND ROWNUM = 1
    ;

    --- Returning Result
    RETURN xch_amt;

END

-- ===== End of Function ==================================
;