CREATE OR REPLACE FUNCTION OPUSADM."PRD_GET_LINK_COST_FNC"

/******************************************************************************
   Name         :   PRD_GET_LINK_COST_FNC
   Purpose      :   TS SHUTTL COST 구하기
   Source       :   COA_LNK_AVG_STND_COST
   Target       :   
   Ver          :   1.0                       
   Date         :   2007.03.02
   System       :   PRD
   Author       :   김윤석 (6944)
******************************************************************************/

(    
    ------------------------------PARAMETERS------------------------------
    P_PORT          IN VARCHAR2,
    P_TP_SZ         IN VARCHAR2,
    P_FL_MT         IN VARCHAR2,
    P_YYYYMM        IN VARCHAR2
    ----------------------------------------------------------------------
) 


RETURN NUMBER -- RETURN TYPE 
authid current_user 
IS 
    
    RTN_AMT      NUMBER(25,13) := NULL;
    VV_COST_AMT  NUMBER(25,13) := NULL;
    VV_SCC_CD    VARCHAR2(5)   := NULL;
    VV_ECC_CD    VARCHAR2(5)   := NULL;
    VV_LCC_CD    VARCHAR2(5)   := NULL;
    VV_RCC_CD    VARCHAR2(5)   := NULL;
    VV_COST_CODE VARCHAR2(8)   := NULL;
    
BEGIN

--COST CODE SETTING
    IF P_FL_MT = 'M' THEN
        VV_COST_CODE := 'TRMTTD'; -- EMPTY REPO TRUCK DIRECT
    ELSIF P_FL_MT = 'F' THEN
        VV_COST_CODE := 'TRTSTD'; -- T/S Shuttle Truck Direct
    ELSE
        RTN_AMT := NULL;
        RETURN RTN_AMT;
    END IF;

-- FIND SCC, ECC, LCC, RCC
    FOR V_AA IN
    (
        SELECT T.SCC_CD SCC_CD, T.ECC_CD ECC_CD, T.LCC_CD LCC_CD, T.RCC_CD RCC_CD
        FROM MDM_LOCATION L, MDM_EQ_ORZ_CHT T
        WHERE L.LOC_CD = P_PORT
        AND   L.SCC_CD = T.SCC_CD
    )
    LOOP
        VV_SCC_CD := V_AA.SCC_CD;
        VV_ECC_CD := V_AA.ECC_CD;
        VV_LCC_CD := V_AA.LCC_CD;
        VV_RCC_CD := V_AA.RCC_CD;
    END LOOP;

--  SCC/ECC/LCC/RCC PAIR 별 TS SHUTTLE COST 검색   
    FOR V_AA IN 
    (
        SELECT /*+ INDEX(COA_LNK_AVG_STND_COST XPKCOA_LNK_AVG_STND_COST) */
               DECODE(MAX(DECODE(COST_LOC_GRP_CD,'S',STND_COST_USD_AMT)),'', 
               DECODE(MAX(DECODE(COST_LOC_GRP_CD,'E',STND_COST_USD_AMT)),'',
               DECODE(MAX(DECODE(COST_LOC_GRP_CD,'L',STND_COST_USD_AMT)),'', 
                   MAX(DECODE(COST_LOC_GRP_CD,'R',STND_COST_USD_AMT)),
                   MAX(DECODE(COST_LOC_GRP_CD,'L',STND_COST_USD_AMT))),
                  MAX(DECODE(COST_LOC_GRP_CD,'E',STND_COST_USD_AMT))),
                  MAX(DECODE(COST_LOC_GRP_CD,'S',STND_COST_USD_AMT))) COST_AMT
        FROM   COA_LNK_AVG_STND_COST 
        WHERE  COST_YRMON = P_YYYYMM
        AND    LNK_FM_NOD_CD = LNK_TO_NOD_CD
        AND    LNK_FM_NOD_CD IN (VV_SCC_CD, VV_ECC_CD, VV_LCC_CD, VV_RCC_CD)
        AND    CO_CD = 'H'
        AND    COA_COST_SRC_CD = VV_COST_CODE
        AND    COST_LOC_GRP_CD IN ('S', 'E', 'L', 'R')
        AND    CNTR_TPSZ_CD = P_TP_SZ
        AND    FULL_MTY_CD = P_FL_MT
        AND    ROWNUM = 1
    )
    LOOP
        VV_COST_AMT := V_AA.COST_AMT;
    END LOOP;

    IF VV_COST_AMT IS NOT NULL THEN
        RTN_AMT := VV_COST_AMT;
        RETURN RTN_AMT;
    END IF;

    RTN_AMT := NULL;
    RETURN RTN_AMT;
    
    EXCEPTION
        WHEN OTHERS THEN
        RETURN -11; 
END;
/

