CREATE OR REPLACE FUNCTION OPUSADM.PRD_GET_FEEDER_VVD_SKD_FNC
/* ========================================================
   1. Object Name      : PRD_GET_FEEDER_VVD_SKD_FNC
   2. Version          : 1.0
   3. Create Date      : 2009.11.27
   4. Sub System       : Product Catalog
   5. Author           :
   6. Description      : FEEDER 단일 LINK인 경우만 VVD 산출
   7. Revision History : 2009.11.27 최초 생성
                       : 2010.03.10 calling port seq 적용
                       : 2010.09.14 RDY Status SKD 제외로직 추가.(TBNX Vessel)
                       : 2011.03.24 Calling Matrix 최적화
                       : 2011.04.20 Double Calling하는 경우를 우선해서 가져오도록 변경.
                       : 2011.04.21 ETD가 가장 빠른배를 가져오도록 한다.
                       : 2011.05.30 SQL Tuning
======================================================== */

(
    ------------------------------PARAMETERS------------------------------
    V_D_DATE    IN VARCHAR2,   -- Milestone Time ('20061115123000')
    V_ORG_NOD   IN VARCHAR2,  -- Origin Node Code ('USCHI01')
    V_ORG_SEQ   IN VARCHAR2,  -- Origin Calling seq 2
    V_DST_NOD   IN VARCHAR2,  -- Destination Node Code ('KRPUS01')
    V_DST_SEQ   IN VARCHAR2,  -- Destination Calling seq 2
    V_SLANE_CD  IN VARCHAR2,  -- SLANE CODE ('PDS')
    V_DIR_CD    IN VARCHAR2,   -- Direction Code ('E')
    V_REVERSE   IN VARCHAR2,  -- Door Arrival Date OR Loading Due Date / VVD ('N'/'Y'/'V')
    V_ORD       IN VARCHAR2,  -- Ocean Route Ordering
    V_CGO_TP    IN VARCHAR2,   --Special Type
    V_GMT       IN VARCHAR2   -- GMY YN
    -----------------------------------------------------------------------
)

RETURN VARCHAR2
authid current_user
IS
    RET_VAL VARCHAR2(400) := NULL;
    V_DATE DATE;
    VV_ETD DATE;
    VV_ORG_ETB DATE;
    VV_CCT VARCHAR2(200) := NULL;
    VV_ETB DATE;
    VV_VSL_CD VARCHAR2(4) := NULL;
    VV_VOY_NO VARCHAR2(4) := NULL;
    VV_DIR_CD VARCHAR2(1) := NULL;
    VV_LANE_CD VARCHAR2(4):= NULL;
    VV_O_IND_SEQ VARCHAR2(2) := NULL;
    VV_D_IND_SEQ VARCHAR2(2) := NULL;
    VV_ORG_YD_CD VARCHAR2(7) := NULL;
    VV_DST_YD_CD VARCHAR2(7) := NULL;
    VV_CRR_CD VARCHAR2(4) := NULL;


    VV_NETD DATE;
    VV_NORG_ETB DATE;
    VV_NCCT VARCHAR2(200) := NULL;
    VV_NETB DATE;
    VV_NO_IND_SEQ VARCHAR2(2) := NULL;
    VV_ND_IND_SEQ VARCHAR2(2) := NULL;
    VV_NORG_YD_CD VARCHAR2(7) := NULL;
    VV_NDST_YD_CD VARCHAR2(7) := NULL;
    VV_ORG_ETA  DATE; --2015-05-20 BY MR JO.
    VV_DST_ETD  DATE; --2015-05-20 BY MR JO.
BEGIN

    IF V_GMT = 'Y' THEN
        V_DATE := GLOBALDATE_PKG.TIME_CONV_FNC('GMT',TO_DATE(V_D_DATE,'yyyymmddhh24miss'),SUBSTR(V_DST_NOD,1,5));
    ELSE
        V_DATE := TO_DATE(V_D_DATE, 'yyyymmddhh24miss');
    END IF;

    FOR V_AA IN
    (
        SELECT
        O_ETD_DT AS ORG_ETD,
        O_ETB_DT AS ORG_ETB,
        D_ETB_DT AS DST_ETB,
        O_ETA_DT AS ORG_ETA, --2015-05-20 MR. JO 
        D_ETD_DT AS DST_ETD, --2015-05-20 MR. JO 
        O_VSL_CD AS VSL_CD,
        O_SKD_VOY_NO AS SKD_VOY_NO,
        DIR_CD AS DIR_CD,
        O_IND_SEQ AS O_IND_SEQ,
        D_IND_SEQ AS D_IND_SEQ,
        O_YD_CD AS ORG_YD_CD,
        D_YD_CD AS DST_YD_CD,
        NO_ETD_DT AS NORG_ETD,
        NO_ETB_DT AS NORG_ETB,
        ND_ETB_DT AS NDST_ETB,
        NO_IND_SEQ AS NO_IND_SEQ,
        ND_IND_SEQ AS ND_IND_SEQ,
        NO_YD_CD AS NORG_YD_CD,
        ND_YD_CD AS NDST_YD_CD,
        CRR_CD AS CRR_CD
        FROM
        (
                SELECT
                O_VSL_CD, O_SKD_VOY_NO, DIR_CD, D_VSL_CD, D_SKD_VOY_NO, O_YD_CD, D_YD_CD,
                O_ETD_DT, O_ETB_DT, D_ETB_DT, O_IND_SEQ, D_IND_SEQ, O_CLPT_SEQ, D_CLPT_SEQ,O_ETA_DT,D_ETD_DT,
                PRE_O_SEQ, PRE_D_SEQ, NXT_O_SEQ, NXT_D_SEQ, CRR_CD,
                NO_YD_CD, ND_YD_CD, NO_ETD_DT, NO_ETB_DT, ND_ETB_DT,
                NO_IND_SEQ, ND_IND_SEQ, NO_CLPT_SEQ, ND_CLPT_SEQ
                FROM
                (
                    SELECT
                    O_VSL_CD, O_SKD_VOY_NO, DIR_CD, D_VSL_CD, D_SKD_VOY_NO, O_YD_CD, D_YD_CD,
                    O_ETD_DT,O_ETB_DT, D_ETB_DT, O_IND_SEQ, D_IND_SEQ, O_CLPT_SEQ, D_CLPT_SEQ,O_ETA_DT,D_ETD_DT,
                    PRE_O_SEQ, PRE_D_SEQ, NXT_O_SEQ, NXT_D_SEQ, CRR_CD,
                    NO_YD_CD, ND_YD_CD, NO_ETD_DT, NO_ETB_DT, ND_ETB_DT,
                    NO_IND_SEQ, ND_IND_SEQ, NO_CLPT_SEQ, ND_CLPT_SEQ
                    FROM
                    (
                       SELECT /*+NO_EXPAND USE_NL(O S D V) */
                          O.VSL_CD AS O_VSL_CD,
                          O.SKD_VOY_NO AS O_SKD_VOY_NO,
                          O.SKD_DIR_CD AS DIR_CD,
                          D.VSL_CD AS D_VSL_CD,
                          D.SKD_VOY_NO AS D_SKD_VOY_NO,
                          O.YD_CD AS O_YD_CD,
                          D.YD_CD AS D_YD_CD,
                          O.VPS_ETD_DT AS O_ETD_DT,
                          O.VPS_ETB_DT AS O_ETB_DT,
                          D.VPS_ETB_DT AS D_ETB_DT,
                          O.VPS_ETA_DT AS O_ETA_DT, --2015-05-20 BY MR JO.
                          D.VPS_ETD_DT AS D_ETD_DT, --2015-05-20 BY MR JO.
                          O.CLPT_IND_SEQ AS O_IND_SEQ,
                          D.CLPT_IND_SEQ AS D_IND_SEQ,
                          O.CLPT_SEQ AS O_CLPT_SEQ,
                          D.CLPT_SEQ AS D_CLPT_SEQ,
                          O.SLAN_CD  AS SLAN_CD,
                          LAG(O.CLPT_SEQ,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ) AS PRE_O_SEQ,
                          LAG(D.CLPT_SEQ,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ) AS PRE_D_SEQ,
                          LEAD(O.CLPT_SEQ,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ) AS NXT_O_SEQ,
                          LEAD(D.CLPT_SEQ,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ) AS NXT_D_SEQ,

                          LEAD(O.YD_CD,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ, D.CLPT_SEQ) AS NO_YD_CD,
                          LEAD(D.YD_CD,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ, D.CLPT_SEQ) AS ND_YD_CD,
                          LEAD(O.VPS_ETD_DT,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ, D.CLPT_SEQ) AS NO_ETD_DT,
                          LEAD(O.VPS_ETB_DT,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ, D.CLPT_SEQ) AS NO_ETB_DT,
                          LEAD(D.VPS_ETB_DT,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ, D.CLPT_SEQ) AS ND_ETB_DT,
                          LEAD(O.CLPT_IND_SEQ,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ, D.CLPT_SEQ) AS NO_IND_SEQ,
                          LEAD(D.CLPT_IND_SEQ,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ, D.CLPT_SEQ) AS ND_IND_SEQ,
                          LEAD(O.CLPT_SEQ,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ, D.CLPT_SEQ) AS NO_CLPT_SEQ,
                          LEAD(D.CLPT_SEQ,1,NULL) OVER (PARTITION BY O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD ORDER BY O.CLPT_SEQ, D.CLPT_SEQ) AS ND_CLPT_SEQ,
                          (SELECT CRR_CD FROM MDM_VSL_CNTR WHERE VSL_CD =O.VSL_CD AND NVL(DELT_FLG,'N') <> 'Y') CRR_CD,
                          NVL(S.VSL_SVC_TP_CD,'X') SVC_LANE_TP
                        FROM  VSK_VSL_PORT_SKD O, VSK_VSL_PORT_SKD D, VSK_VSL_SKD V,MDM_VSL_SVC_LANE S
                        WHERE O.VPS_PORT_CD = SUBSTR(V_ORG_NOD,1,5)
                        AND D.VPS_PORT_CD = SUBSTR(V_DST_NOD,1,5)
                        AND O.YD_CD = DECODE(LENGTH(V_ORG_NOD),7,V_ORG_NOD,O.YD_CD)
                        AND O.CLPT_IND_SEQ = NVL(V_ORG_SEQ,O.CLPT_IND_SEQ)
                        AND D.YD_CD = DECODE(LENGTH(V_DST_NOD),7,V_DST_NOD,D.YD_CD)
                        AND D.CLPT_IND_SEQ = NVL(V_DST_SEQ,D.CLPT_IND_SEQ)
                        AND (O.SLAN_CD   = NVL(V_SLANE_CD, O.SLAN_CD) OR S.VSL_SVC_TP_CD ='O')
                        AND O.SKD_DIR_CD = NVL(V_DIR_CD, O.SKD_DIR_CD)
                        AND O.VPS_ETD_DT BETWEEN V_DATE AND V_DATE + 60
                        AND O.TURN_PORT_IND_CD IN ('Y', 'N')  --ADD
                        AND NVL(O.VT_ADD_CALL_FLG,'N') <> 'Y'  --ADD
                        AND NVL(O.SKD_CNG_STS_CD,' ') <> 'S'
                        AND NVL(D.SKD_CNG_STS_CD,' ') <> 'S'
                        AND D.SLAN_CD = O.SLAN_CD
                        AND O.SLAN_CD = S.VSL_SLAN_CD
                        AND O.VSL_CD = D.VSL_CD
                        AND O.SKD_VOY_NO = D.SKD_VOY_NO
                        AND O.SKD_DIR_CD = D.SKD_DIR_CD
                        AND D.CLPT_SEQ > O.CLPT_SEQ
                        AND O.VSL_CD = V.VSL_CD
                        AND O.SKD_VOY_NO = V.SKD_VOY_NO
                        AND O.SKD_DIR_CD = V.SKD_DIR_CD
                        AND V.SKD_STS_CD IN ('ACT', 'CLO')
                    ) VV
                )
              ORDER BY O_ETD_DT, O_IND_SEQ, NO_IND_SEQ ,D_IND_SEQ, ND_IND_SEQ
            )
            WHERE ROWNUM = 1
    )
    LOOP
        VV_ETD      :=  V_AA.ORG_ETD;
        VV_ORG_ETB  :=  V_AA.ORG_ETB;
        VV_ETB      :=  V_AA.DST_ETB;
        VV_VSL_CD   :=  V_AA.VSL_CD;
        VV_VOY_NO   :=  V_AA.SKD_VOY_NO;
        VV_DIR_CD   :=  V_AA.DIR_CD;
        VV_O_IND_SEQ := V_AA.O_IND_SEQ;
        VV_D_IND_SEQ := V_AA.D_IND_SEQ;
        VV_ORG_YD_CD := V_AA.ORG_YD_CD;
        VV_DST_YD_CD := V_AA.DST_YD_CD;
        VV_CRR_CD   :=  V_AA.CRR_CD;
        VV_ORG_ETA  :=  V_AA.ORG_ETA; --2015-05-20 BY MR JO.
        VV_DST_ETD  :=  V_AA.DST_ETD; --2015-05-20 BY MR JO.

        VV_NETD     :=  V_AA.NORG_ETD;
        VV_NORG_ETB :=  V_AA.NORG_ETB;
        VV_NETB     :=  V_AA.NDST_ETB;
        VV_NO_IND_SEQ := V_AA.NO_IND_SEQ;
        VV_ND_IND_SEQ := V_AA.ND_IND_SEQ;
        VV_NORG_YD_CD := V_AA.NORG_YD_CD;
        VV_NDST_YD_CD := V_AA.NDST_YD_CD;
    END LOOP;


    IF (VV_ETD IS NOT NULL) AND (VV_ETB IS NOT NULL) THEN
        IF V_GMT = 'Y' THEN
            VV_ORG_ETB := GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(V_ORG_NOD,1,5),VV_ORG_ETB,'GMT');
            VV_ETD :=  GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(V_ORG_NOD,1,5),VV_ETD,'GMT');
            VV_ETB := GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(V_DST_NOD,1,5),VV_ETB,'GMT');

            VV_NORG_ETB := GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(V_ORG_NOD,1,5),VV_NORG_ETB,'GMT');
            VV_NETD :=  GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(V_ORG_NOD,1,5),VV_NETD,'GMT');
            VV_NETB := GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(V_DST_NOD,1,5),VV_NETB,'GMT');
            VV_ORG_ETA := GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(V_ORG_NOD,1,5),VV_ORG_ETA,'GMT');
            VV_DST_ETD := GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(V_DST_NOD,1,5),VV_DST_ETD,'GMT');
        END IF;


        RET_VAL := RPAD('ORG_ETB'||V_ORD||TO_CHAR(VV_ORG_ETB,'yyyymmddhh24miss'),22, ' ') ||
                   RPAD('ORG_ETA'||V_ORD||TO_CHAR(VV_ORG_ETA,'yyyymmddhh24miss'),22, ' ') ||--2015-05-20 BY MR JO.
                   RPAD('DST_ETD'||V_ORD||TO_CHAR(VV_DST_ETD,'yyyymmddhh24miss'),22, ' ') ||--2015-05-20 BY MR JO.
                   RPAD('POLT'||V_ORD||TO_CHAR(VV_ETD,'yyyymmddhh24miss'),19,' ') ||
                   RPAD('PODT'||V_ORD||TO_CHAR(VV_ETB,'yyyymmddhh24miss'),19,' ') ||
                   RPAD('VVD'||V_ORD||VV_VSL_CD||VV_VOY_NO||VV_DIR_CD,13,' ') ||
                   RPAD('POL'||V_ORD||VV_ORG_YD_CD,11,' ') ||
                   RPAD('POD'||V_ORD||VV_DST_YD_CD,11,' ') ||
                   RPAD('CRR'||V_ORD||VV_CRR_CD,8,' ') ||
                   RPAD('POL_SEQ'||V_ORD||VV_O_IND_SEQ,10,' ') ||
                   RPAD('POD_SEQ'||V_ORD||VV_D_IND_SEQ,10,' ') ||
                   RPAD('ORG_ETBN'||V_ORD||TO_CHAR(VV_NORG_ETB,'yyyymmddhh24miss'),23, ' ') ||
                   RPAD('POLTN'||V_ORD||TO_CHAR(VV_NETD,'yyyymmddhh24miss'),20,' ') ||
                   RPAD('PODTN'||V_ORD||TO_CHAR(VV_NETB,'yyyymmddhh24miss'),20,' ') ||
                   RPAD('POLN'||V_ORD||VV_NORG_YD_CD,12,' ') ||
                   RPAD('PODN'||V_ORD||VV_NDST_YD_CD,12,' ') ||
                   RPAD('POL_SEQN'||V_ORD||VV_NO_IND_SEQ,11,' ') ||
                   RPAD('POD_SEQN'||V_ORD||VV_ND_IND_SEQ,11,' ');

        IF V_ORD = '1' THEN
            --VV_CCT := 'CCC'||TO_CHAR(NVL(PRD_GET_CCT_FNC(VV_ORG_YD_CD, V_SLANE_CD,VV_DIR_CD,V_CGO_TP,VV_VSL_CD||VV_VOY_NO||VV_DIR_CD,VV_O_IND_SEQ, (VV_ORG_ETB), VV_ETD ),TRUNC(VV_ORG_ETB) - 7/24),'yyyymmddhh24miss') ;
            --VV_NCCT := 'CCNC'||TO_CHAR(NVL(PRD_GET_CCT_FNC(VV_NORG_YD_CD, V_SLANE_CD,VV_DIR_CD,V_CGO_TP,VV_VSL_CD||VV_VOY_NO||VV_DIR_CD,VV_O_IND_SEQ, (VV_NORG_ETB), VV_NETD ),TRUNC(VV_NORG_ETB ) - 7/24),'yyyymmddhh24miss') ;
   
            VV_CCT  :=   'CCC' ||TO_CHAR(NVL(PRD_COMMON_PKG.PRD_GET_CCT_BY_BKG_INFO_FNC(VV_VSL_CD, VV_VOY_NO, VV_DIR_CD, SUBSTR(VV_ORG_YD_CD, 1, 5), VV_O_IND_SEQ, VV_ORG_YD_CD, V_CGO_TP),TRUNC(VV_ORG_ETB ) - 7/24),'yyyymmddhh24miss');
            VV_NCCT :=   'CCNC'||TO_CHAR(NVL(PRD_COMMON_PKG.PRD_GET_CCT_BY_BKG_INFO_FNC(VV_VSL_CD, VV_VOY_NO, VV_DIR_CD, SUBSTR(VV_NORG_YD_CD, 1, 5), VV_O_IND_SEQ, VV_NORG_YD_CD, V_CGO_TP),TRUNC(VV_NORG_ETB ) - 7/24),'yyyymmddhh24miss');            
            RET_VAL := VV_CCT||VV_NCCT||RET_VAL ;
        END IF ;
    ELSE
        RET_VAL := NULL;
    END IF;
    RETURN RET_VAL;
END;
/
