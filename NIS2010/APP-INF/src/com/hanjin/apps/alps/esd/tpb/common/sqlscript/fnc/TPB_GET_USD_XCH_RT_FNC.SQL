CREATE OR REPLACE FUNCTION NISADM.TPB_GET_USD_XCH_RT_FNC
/*******************************************************************************
   1. Object Name      : TPB_GET_USD_XCH_RT_FNC
   2. Version          : 1.1
   3. Create Date      : 2006.11.01
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : 3rd Party Getting USD Local Xch Rate
                         -------------------------------------------------------
                         SELECT TPB_GET_USD_XCH_RT_FNC('KRW',SYSDATE) FROM DUAL ;
                         -------------------------------------------------------
   7. Revision History : 2006.11.01  Kim Jin-seung  1.0  Created
                         2009.09.08  Park Sung-Jin  1.2  ALPS Migration                 
*******************************************************************************/

-- ===== Arguments ========================================
(
    v_curr_cd  in VARCHAR2, -- currency code
    v_yrmon    in DATE      -- currency rate Base Date
)


RETURN NUMBER -- RETURN TYPE

AUTHID CURRENT_USER

IS

-- ===== DECLARE ==========================================
n_usd_locl_xch_rt  gl_mon_xch_rt.usd_locl_xch_rt%TYPE;     -- USD local xch Rate


-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles
    n_usd_locl_xch_rt := NULL;

    --- Getting USD Amounts
    SELECT r.usd_locl_xch_rt
    INTO n_usd_locl_xch_rt
    FROM gl_mon_xch_rt r
    WHERE r.curr_cd = v_curr_cd
        AND r.acct_xch_rt_lvl = '1'
        AND r.acct_xch_rt_yrmon = TO_CHAR(v_yrmon,'YYYYMM')
        AND ROWNUM = 1
    ;

    --- Returning Result
    RETURN n_usd_locl_xch_rt;

END

-- ===== End of Function ==================================
;