CREATE OR REPLACE FUNCTION OPUSADM.PRD_GET_SPACE_FNC
/* ========================================================
 *Copyright(c) 2006 CyberLogitec
 *@Function Name : PRD_GET_SPACE_FNC
 *@LastModifyDate : 2009-10-08
 *@LastModifier : JSY(jaksal@cyberlogitec.com)
 *@LastVersion : 1.0
 *@Purpose : Get the space.
 *@Remark:
 *@Issue:
======================================================== */
(
    V_PCTL_NO IN VARCHAR2,
    V_POL IN VARCHAR2,
    V_POD IN VARCHAR2,
    V_VVD IN VARCHAR2,
    V_T_VVD_FLAG IN VARCHAR2,
    V_SLS_OFC_CD IN VARCHAR2
    
) 
    return VARCHAR2
    authid current_user
IS
    V_RET_VAL VARCHAR2(100) := NULL; 
    V_QTY VARCHAR2(10) := NULL; 
    V_ALOC NUMBER :=0;
    V_BKG  NUMBER :=0;
        
BEGIN
    DBMS_OUTPUT.ENABLE;
    DBMS_OUTPUT.PUT_LINE('0.  START! V_PCTL_NO :'||V_PCTL_NO ); 
    DBMS_OUTPUT.PUT_LINE('0.  START! V_POL :'||V_POL ); 
    DBMS_OUTPUT.PUT_LINE('0.  START! V_POD:'||V_POD ); 
    DBMS_OUTPUT.PUT_LINE('0.  START! V_VVD:'||V_VVD ); 
    DBMS_OUTPUT.PUT_LINE('0.  START! V_T_VVD_FLAG:'||V_T_VVD_FLAG ); 
    DBMS_OUTPUT.PUT_LINE('0.  START! V_SLS_OFC_CD:'||V_SLS_OFC_CD ); 
    
    
    SELECT NVL(SUM(BKG_AVAL_TTL_QTY),0)
    INTO V_ALOC
    FROM (            
            SELECT 
                P.VSL_CD, P.SKD_VOY_NO, P.SKD_DIR_CD,
                P.ORG_NOD_CD, P.DEST_NOD_CD, 
                SUM(ASGN_TTL_QTY) BKG_AVAL_TTL_QTY,
                SUM(ASGN_45FT_HC_QTY) BKG_AVAL_45FT_HC_QTY,
                SUM(ASGN_RF_QTY) BKG_AVAL_RF_QTY
            FROM SPC_ALOC_POL_POD S,
                (SELECT D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, D.ORG_NOD_CD, D.DEST_NOD_CD,
                       COA_SLANE_RLANE_CONV_FNC(D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD, D.VSL_SLAN_CD, 
                       SUBSTR(D.ORG_NOD_CD,1,5), SUBSTR(D.DEST_NOD_CD,1,5)) RLANE_CD
                FROM PRD_PROD_CTL_ROUT_DTL D
                WHERE  D.PCTL_NO = V_PCTL_NO
                AND D.TRSP_MOD_CD = 'VD'
                AND D.ORG_NOD_CD = V_POL
                AND D.DEST_NOD_CD = V_POD
                ) P
            WHERE S.RLANE_CD = P.RLANE_CD
            AND S.DIR_CD = P.SKD_DIR_CD
            AND S.VSL_CD = P.VSL_CD
            AND S.SKD_VOY_NO = P.SKD_VOY_NO
            AND S.SKD_DIR_CD = P.SKD_DIR_CD
            AND S.TS_FLG = DECODE(V_T_VVD_FLAG,'V','N','Y')  
            AND S.POL_YD_CD = P.ORG_NOD_CD
            AND S.POD_YD_CD = P.DEST_NOD_CD
            AND S.SLS_OFC_CD = V_SLS_OFC_CD
            GROUP BY P.VSL_CD, P.SKD_VOY_NO, P.SKD_DIR_CD,
                P.ORG_NOD_CD, P.DEST_NOD_CD    
    );
    
    SELECT NVL(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD,2,1),2,1,2) * Q.OP_CNTR_QTY),0) 
    INTO V_BKG
    FROM PRD_PROD_CTL_ROUT_DTL P, BKG_VVD V, BKG_BOOKING B, BKG_QUANTITY Q
    WHERE P.PCTL_NO = V_PCTL_NO
    AND P.ORG_NOD_CD = V_POL
    AND P.DEST_NOD_CD = V_POD
    AND P.TRSP_MOD_CD = 'VD'
    AND P.VSL_CD = V.VSL_CD
    AND P.SKD_VOY_NO = V.SKD_VOY_NO
    AND P.SKD_DIR_CD = V.SKD_DIR_CD
    AND P.ORG_NOD_CD = V.POL_YD_CD
    AND P.DEST_NOD_CD = V.POD_YD_CD
    AND V.BKG_NO = B.BKG_NO
    AND B.BKG_STS_CD IN ('F','W')
    AND B.BKG_CGO_TP_CD IN ('F','R','B')
    AND B.BKG_NO = Q.BKG_NO
    AND B.OB_SLS_OFC_CD = V_SLS_OFC_CD;
    
    
    
    V_RET_VAL:=V_ALOC-V_BKG||'TEU';
    IF (V_ALOC = NULL or V_ALOC-V_BKG < 1) THEN 
        V_RET_VAL:='0';
    END IF;
    
    RETURN V_RET_VAL;
    EXCEPTION
      WHEN NO_DATA_FOUND
      THEN
         BEGIN
            DBMS_OUTPUT.PUT_LINE('9.  NO_DATA_FOUND  : '); 
            V_RET_VAL:=0;
            RETURN V_RET_VAL;
         END;
      WHEN OTHERS
      THEN
         BEGIN
            DBMS_OUTPUT.PUT_LINE('9.  OTHERS  : '); 
            V_RET_VAL:=0;
            RETURN V_RET_VAL;
         END;
    

      
END ;
/

