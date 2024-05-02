CREATE OR REPLACE FUNCTION TRS_GET_AGMT_RULE_CHK_FNC (
  P_TRSP_TMP_SEQ  IN NUMBER
, P_SR            IN NUMBER
, P_AGMT_RT_TP    IN VARCHAR2)
RETURN VARCHAR2
AUTHID CURRENT_USER
IS
/******************************************************************************
   Name         :   TRS_GET_AGMT_VERIFY_RULE_FNC
   Purpose      :   Agreement Rule Check Function
   Table        :   TRS_TRSP_AGMT_TMP
   Ver          :   1.0
   Date         :   2010.04.66
   System       :   e-NIS > TRS
   Author       :   최종혁
   History      :   
******************************************************************************/
R_RETURN VARCHAR2(100);
V_RULE_C VARCHAR2(100);
V_RULE_D VARCHAR2(100);
V_RULE_F VARCHAR2(100);

BEGIN
IF P_AGMT_RT_TP = 'P' THEN
    /* PAIR TYPE RULL CHECK */
    -- RULE-C, RULE-D, RULE-F CHECK
    FOR RET_DATA IN (
        SELECT 
          CASE WHEN
          (
            SELECT 1
              FROM TRS_AGMT_EQ_TP_RULE            H
             WHERE TRSP_AGMT_RULE_TP_CD                = 'P'
               AND TRSP_AGMT_STEP_KNT                  = 3
               AND TRSP_AGMT_COST_MOD_CD               = T.TRSP_COST_MOD_CD
               AND NVL(TRSP_AGMT_CGO_TP_CD, 'N/A')     = DECODE(T.CGO_TP_CD, '0', 'N/A', T.CGO_TP_CD)
               AND NVL(DOR_LOC_COND_CD, 'N/A')         = DECODE(T.DOR_NOD_CD, '0000000', 'N/A', 'NN')
               AND TRSP_AGMT_EQ_KND_CD                 = T.EQ_KND_CD
               AND TRSP_AGMT_EQ_SZ_CD                  = T.TRSP_AGMT_EQ_SZ_CD
               AND ROWNUM                              = 1
          ) IS NULL THEN 'X'
          END AS RULE_C
         ,CASE WHEN
          (
            SELECT 1
              FROM TRS_AGMT_EQ_TP_RULE            H
             WHERE TRSP_AGMT_RULE_TP_CD                = 'P'
               AND TRSP_AGMT_STEP_KNT                  = 4
               AND TRSP_AGMT_COST_MOD_CD               = T.TRSP_COST_MOD_CD
               AND NVL(TRSP_AGMT_CGO_TP_CD, 'N/A')     = DECODE(T.CGO_TP_CD, '0', 'N/A', T.CGO_TP_CD)
               AND TRSP_AGMT_EQ_KND_CD                 = T.EQ_KND_CD
               AND TRSP_AGMT_EQ_TP_CD                  = T.TRSP_AGMT_EQ_TP_CD
               AND NVL(CHSS_NO_COND_CD, 'N/A')         = DECODE(T.TRSP_AGMT_BDL_QTY, '0', 'N/A', 'NN')
               AND ROWNUM                              = 1
          ) IS NULL THEN 'X'
          END AS RULE_D
          
         ,CASE WHEN
          (
            SELECT 1
              FROM TRS_AGMT_EQ_TP_RULE            H
             WHERE TRSP_AGMT_RULE_TP_CD    = 'P'
               AND TRSP_AGMT_STEP_KNT      = 6
               AND TRSP_AGMT_EQ_TP_CD      = T.TRSP_AGMT_EQ_TP_CD
               AND NVL(H.TRSP_AGMT_EQ_SZ_CD, 'N/A')    = NVL(T.TRSP_AGMT_EQ_SZ_CD, 'N/A') --Genset은 Size가 없으므로 NVL처리
               AND ROWNUM                  = 1
          ) IS NULL THEN 'X'
          END AS RULE_F
         FROM TRS_AGMT_TMP T
        WHERE TRSP_TMP_SEQ = P_TRSP_TMP_SEQ
          AND ROW_NO       = P_SR
    )
    LOOP
        V_RULE_C := V_RULE_C || RET_DATA.RULE_C;
        V_RULE_D := V_RULE_D || RET_DATA.RULE_D;
        V_RULE_F := V_RULE_F || RET_DATA.RULE_F;
    END LOOP;
    
    IF LENGTH(V_RULE_C)>0 THEN
       V_RULE_C := ',RULE-C ERR';
    END IF;
    
    IF LENGTH(V_RULE_D)>0 THEN
       V_RULE_D := ',RULE-D ERR';
    END IF;
    
    IF LENGTH(V_RULE_F)>0 THEN
       V_RULE_F := ',RULE-F ERR';
    END IF;
    
    R_RETURN := V_RULE_C||V_RULE_D||V_RULE_F;
ELSIF P_AGMT_RT_TP = 'D' THEN
    /* DISTANCE TYPE RULL CHECK */
    -- RULE-C, RULE-D, RULE-F CHECK
    FOR RET_DATA IN (
        SELECT 
          CASE WHEN
          (SELECT 1
             FROM TRS_AGMT_EQ_TP_RULE            H
            WHERE TRSP_AGMT_RULE_TP_CD                = 'D'
              AND TRSP_AGMT_STEP_KNT                  = 3
              AND TRSP_AGMT_COST_MOD_CD               = T.TRSP_COST_MOD_CD
              AND NVL(TRSP_AGMT_CGO_TP_CD, 'N/A')     = DECODE(T.CGO_TP_CD, '0', 'N/A', T.CGO_TP_CD)
              AND NVL(DOR_LOC_COND_CD, 'N/A')         = DECODE(T.DOR_NOD_CD, '0000000', 'N/A', 'NN')
              AND TRSP_AGMT_EQ_KND_CD                 = T.EQ_KND_CD
              AND H.TRSP_AGMT_EQ_SZ_CD                = T.TRSP_AGMT_EQ_SZ_CD
              AND ROWNUM                              = 1
          ) IS NULL THEN 'XR'
          END AS RULE_C
         ,CASE WHEN
          (SELECT 1
             FROM TRS_AGMT_EQ_TP_RULE            H
            WHERE TRSP_AGMT_RULE_TP_CD                = 'D'
              AND TRSP_AGMT_STEP_KNT                  = 4
              AND TRSP_AGMT_COST_MOD_CD               = T.TRSP_COST_MOD_CD
              AND NVL(TRSP_AGMT_CGO_TP_CD, 'N/A')     = DECODE(T.CGO_TP_CD, '0', 'N/A', T.CGO_TP_CD)
              AND H.TRSP_AGMT_EQ_KND_CD               = T.EQ_KND_CD
              AND H.TRSP_AGMT_EQ_TP_CD                = T.TRSP_AGMT_EQ_TP_CD
              AND NVL(CHSS_NO_COND_CD, 'N/A')         = DECODE(T.TRSP_AGMT_BDL_QTY, '0', 'N/A', 'NN')
              AND ROWNUM                              = 1
          ) IS NULL THEN 'X'
          END AS RULE_D
         ,CASE WHEN
          (SELECT 1
             FROM TRS_AGMT_EQ_TP_RULE            H
            WHERE TRSP_AGMT_RULE_TP_CD                = 'D'
              AND TRSP_AGMT_STEP_KNT                  = 6
              AND H.TRSP_AGMT_EQ_TP_CD                = T.TRSP_AGMT_EQ_TP_CD
              AND NVL(H.TRSP_AGMT_EQ_SZ_CD, 'N/A')    = NVL(T.TRSP_AGMT_EQ_SZ_CD, 'N/A') --Genset은 Size가 없으므로 NVL처리
              AND ROWNUM                              = 1
          ) IS NULL THEN 'X'
          END AS RULE_F
         FROM TRS_AGMT_TMP T
        WHERE TRSP_TMP_SEQ = P_TRSP_TMP_SEQ
          AND ROW_NO       = P_SR
    )
    LOOP
        V_RULE_C := V_RULE_C || RET_DATA.RULE_C;
        V_RULE_D := V_RULE_D || RET_DATA.RULE_D;
        V_RULE_F := V_RULE_F || RET_DATA.RULE_F;
    END LOOP;
    
    IF LENGTH(V_RULE_C)>0 THEN
       V_RULE_C := ',RULE-C ERR';
    END IF;
    
    IF LENGTH(V_RULE_D)>0 THEN
       V_RULE_D := ',RULE-D ERR';
    END IF;
    
    IF LENGTH(V_RULE_F)>0 THEN
       V_RULE_F := ',RULE-F ERR';
    END IF;
    
    R_RETURN := V_RULE_C||V_RULE_D||V_RULE_F;
ELSIF P_AGMT_RT_TP = 'S' THEN
    /* SURCHARGE RULL CHECK */
    -- RULE-D, RULE-F CHECK
    FOR RET_DATA IN (
        SELECT 
          CASE WHEN
          (SELECT 1
             FROM TRS_AGMT_EQ_TP_RULE            H
            WHERE TRSP_AGMT_RULE_TP_CD                = 'S'
              AND TRSP_AGMT_STEP_KNT                  = 5
              AND TRSP_AGMT_COST_MOD_CD               = T.TRSP_COST_MOD_CD
              AND NVL(TRSP_AGMT_CGO_TP_CD, 'N/A')     = DECODE(T.CGO_TP_CD, '0', 'N/A', T.CGO_TP_CD)
              AND TRSP_AGMT_EQ_KND_CD                 = T.EQ_KND_CD
              AND TRSP_AGMT_EQ_TP_CD                  = TRSP_AGMT_EQ_TP_CD
              AND ROWNUM                              = 1
          ) IS NULL THEN 'X'
          END AS RULE_D
         ,CASE WHEN
          (SELECT 1
             FROM TRS_AGMT_EQ_TP_RULE            H
            WHERE TRSP_AGMT_RULE_TP_CD                = 'S'
              AND TRSP_AGMT_STEP_KNT                  = 6
              AND TRSP_AGMT_EQ_TP_CD                  = T.TRSP_AGMT_EQ_TP_CD
              AND NVL(H.TRSP_AGMT_EQ_SZ_CD, 'N/A')    = NVL(T.TRSP_AGMT_EQ_SZ_CD, 'N/A') --Genset은 Size가 없으므로 NVL처리
              AND ROWNUM                              = 1
          ) IS NULL THEN 'X'
          END AS RULE_F
         FROM TRS_AGMT_TMP T
        WHERE TRSP_TMP_SEQ = P_TRSP_TMP_SEQ
          AND ROW_NO       = P_SR
    )
    LOOP
        V_RULE_D := V_RULE_D || RET_DATA.RULE_D;
        V_RULE_F := V_RULE_F || RET_DATA.RULE_F;
    END LOOP;

    IF LENGTH(V_RULE_D)>0 THEN
       V_RULE_D := ',RULE-D ERR';
    END IF;
    
    IF LENGTH(V_RULE_F)>0 THEN
       V_RULE_F := ',RULE-F ERR';
    END IF;

    R_RETURN := V_RULE_D||V_RULE_F;
END IF;
RETURN R_RETURN;

END ;