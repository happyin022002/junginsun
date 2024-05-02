CREATE OR REPLACE FUNCTION OPUSADM."TPB_GET_INV_CURR_CHG_ROC_FNC" 

/*******************************************************************************
1. Object Name      : TPB_GET_INV_CURR_CHG_ROC_FNC
2. Version          : 1.1
3. Create Date      : 2007.07.03
4. Sub System       : Third Party Billing
5. Author           : Sun, Choi
6. Description      : Amount Currency change For R.O.C.
                      -------------------------------------------------------

                      -------------------------------------------------------
7. Revision History : 2007.07.03  Kim Jin-seung    1.0  Created
                      2009.09.14  Sun CHOI         1.1  Migration
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

    --- To Get Amount Changed
    v_amt := TPB_GET_INV_CURR_CHG_FNC(in_from_curr_cd, in_to_curr_cd, in_amt, in_yrmon);

    --- In case of the Currency KRW,JPY,VND, Round amount. 
    IF ( in_to_curr_cd='KRW' OR in_to_curr_cd='JPY' OR in_to_curr_cd='VND' ) THEN 
        v_amt := ROUND(v_amt, 0);
    END IF; 
    
    --- Returning Result 
    RETURN v_amt; 

END

-- ===== End of Function ==================================
;

GRANT EXECUTE ON OPUSADM.TPB_GET_INV_CURR_CHG_ROC_FNC TO OPUSDEV;
GRANT EXECUTE ON OPUSADM.TPB_GET_INV_CURR_CHG_ROC_FNC TO OPUS_ROLE;