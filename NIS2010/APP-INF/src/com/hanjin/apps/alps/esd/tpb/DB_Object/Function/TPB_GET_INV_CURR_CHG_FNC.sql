CREATE OR REPLACE FUNCTION NISADM.TPB_GET_INV_CURR_CHG_FNC

/*******************************************************************************
   1. Object Name      : TPB_GET_INV_CURR_CHG_FNC
   2. Version          : 1.1
   3. Create Date      : 2006.11.01
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : Invoice Revision/Correction : Currency change  
   7. Revision History : 2006.11.01  Kim Young-chang  1.0  Created
                         2009.08.31  Park Sung-Jin  1.1  ALPS Migration
   * ex) 
     SELECT TPB_GET_INV_CURR_CHG_FNC('KRW','USD', 100, SYSDATE) FROM DUAL ; 
*******************************************************************************/

-- ===== Arguments ========================================
(    
    in_from_curr_cd  IN VARCHAR2, -- From Currency code
    in_to_curr_cd    IN VARCHAR2, -- To   Currency code 
    in_amt           IN NUMBER,   -- amount
    in_yrmon         IN DATE      -- currency rate Base Date
) 


RETURN NUMBER -- RETURN TYPE 

AUTHID CURRENT_USER

IS 

-- ===== DECLARE ==========================================
v_amt  NUMBER(18,2);


-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    -- Local -> USD
    IF in_to_curr_cd = 'USD' THEN
        SELECT ROUND(in_amt/r.usd_locl_xch_rt,2) usd_amt  
        INTO v_amt           
        FROM gl_mon_xch_rt r 
        WHERE r.curr_cd = in_from_curr_cd                             --기존 Currency 
        AND r.acct_xch_rt_lvl = '1' 
        AND r.acct_xch_rt_yrmon = TO_CHAR(in_yrmon,'YYYYMM')         
        AND ROWNUM = 1;
    
    -- USD -> Local
    ELSIF in_from_curr_cd = 'USD' THEN
        SELECT ROUND(in_amt * r.usd_locl_xch_rt,2) loc_amt
        INTO v_amt               
        FROM gl_mon_xch_rt r
        WHERE r.curr_cd = in_to_curr_cd                             --바꾸려고 하는 Currency  
        AND r.acct_xch_rt_lvl = '1' 
        AND r.acct_xch_rt_yrmon = TO_CHAR(in_yrmon,'YYYYMM')                   
        AND ROWNUM = 1;
    
    -- Local -> Other Local
    ELSE
        SELECT ROUND(in_amt/r.usd_locl_xch_rt * usd_rate, 2)    
        INTO v_amt          
        FROM gl_mon_xch_rt r,
            (SELECT r.usd_locl_xch_rt usd_rate
            FROM gl_mon_xch_rt r
            WHERE r.curr_cd = in_to_curr_cd                         -- 바꾸려고 하는 Currency                 
                AND r.acct_xch_rt_lvl = '1' 
                AND r.acct_xch_rt_yrmon = TO_CHAR(in_yrmon,'YYYYMM') 
                AND ROWNUM = 1
            )
        WHERE r.curr_cd = in_from_curr_cd                            -- 기존 Currency 
        AND r.acct_xch_rt_lvl = '1' 
        AND r.acct_xch_rt_yrmon = TO_CHAR(in_yrmon,'YYYYMM')                  
        AND ROWNUM = 1;    
    END IF;
    
    --- Returning Result 
    RETURN v_amt;     

END

-- ===== End of Function ==================================
;