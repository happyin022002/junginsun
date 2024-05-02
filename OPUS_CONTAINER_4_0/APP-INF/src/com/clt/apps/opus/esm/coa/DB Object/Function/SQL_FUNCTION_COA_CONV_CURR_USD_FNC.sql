CREATE OR REPLACE FUNCTION OPUSADM."COA_CONV_CURR_USD_FNC" (in_curr_cd IN VARCHAR, in_curr_amt IN VARCHAR, in_acct_xch_rt_yrmon IN VARCHAR)
   RETURN NUMBER   -- RETURN TYPE
   Authid current_user
/******************************************************************************
   Name         :   COA_CONV_CURR_USD_FNC
   Purpose      :   curr을 usd로 변경한다.
   Source       :
   Target       :
   Example      :
   SELECT coa_conv_curr_usd_fnc ('KRW', 1000,'200702') usd_amt
   FROM DUAL

   SELECT coa_conv_curr_usd_fnc ('KRW', 1000, NULL) usd_amt -- 현재기준
   FROM DUAL
******************************************************************************/
IS
-- ===== DECLARE ==========================================
   v_err_msg   VARCHAR2(1000);
   v_usd_amt   gl_mon_xch_rt.usd_locl_xch_rt%TYPE;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
   BEGIN
      SELECT in_curr_amt / usd_locl_xch_rt usd_amt
        INTO v_usd_amt
        FROM gl_mon_xch_rt
       WHERE acct_xch_rt_yrmon = NVL(in_acct_xch_rt_yrmon, TO_CHAR(SYSDATE, 'yyyymm'))
         AND acct_xch_rt_lvl   = '1'
         AND curr_cd           = NVL(in_curr_cd, 'USD');
   EXCEPTION
      WHEN OTHERS
      THEN
         BEGIN
            v_usd_amt := NULL;
         END;
   END;

   IF (v_usd_amt IS NULL)
   THEN
      BEGIN
         SELECT in_curr_amt / usd_locl_xch_rt usd_amt
           INTO v_usd_amt
           FROM gl_mon_xch_rt
          WHERE acct_xch_rt_yrmon = (SELECT MAX(acct_xch_rt_yrmon)
                                       FROM gl_mon_xch_rt)
            AND acct_xch_rt_lvl   = '1'
            AND curr_cd           = NVL(in_curr_cd, 'USD');
      EXCEPTION
         WHEN OTHERS
         THEN
            BEGIN
               v_usd_amt := NULL;
            END;
      END;
   END IF;

   RETURN v_usd_amt;
END;
-- ===== End of Function ==================================