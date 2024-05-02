CREATE OR REPLACE FUNCTION OPUSADM.PRD_GET_TLANE_FNC

/* ========================================================
   1. Object Name      : PRD_GET_TLANE_FNC
   2. Version          : 1.0
   3. Create Date      : 2008.10.28
   4. Sub System       : Product Catalog
   5. Author           :
   6. Description      : 해상 운송 구간중 TRUNK LANE을 구한다.
   7. Revision History :
======================================================== */
(
    ------------------------------PARAMETERS------------------------------
    V_PCTL_NO           IN VARCHAR2,
    V_DIV               IN VARCHAR2 -- 'VVD' : RETURN VVD(), 'SEQ' : RETURN SEQ OF T.LANE
    -----------------------------------------------------------------------
)

RETURN VARCHAR
authid current_user
IS
    RET_VAL     VARCHAR2(100) := NULL;
    R_PCTL_SEQ  VARCHAR2(5) := NULL;
    R_VSL_CD    VARCHAR2(4) := NULL;
    R_VOY_NO    VARCHAR2(4) := NULL;
    R_DIR_CD    VARCHAR2(1) := NULL;
BEGIN

    FOR V_AA IN
    (
        SELECT
            PCTL_NO,
            DECODE(T_SEQ,1,N1ST_PCTL_SEQ,2,N2ND_PCTL_SEQ,3,N3RD_PCTL_SEQ,4,N4TH_PCTL_SEQ) PCTL_SEQ,
            DECODE(T_SEQ,1,N1ST_VSL_CD,2,N2ND_VSL_CD,3,N3RD_VSL_CD,4,N4TH_VSL_CD) VSL_CD,
            DECODE(T_SEQ,1,N1ST_SKD_VOY_NO,2,N2ND_SKD_VOY_NO,3,N3RD_SKD_VOY_NO,4,N4TH_SKD_VOY_NO) VOY_NO,
            DECODE(T_SEQ,1,N1ST_SKD_DIR_CD,2,N2ND_SKD_DIR_CD,3,N3RD_SKD_DIR_CD,4,N4TH_SKD_DIR_CD) DIR_CD
        FROM(
            SELECT
                PCTL_NO,
                CNT,
                N1ST_PCTL_SEQ, N1ST_VSL_CD, N1ST_SKD_VOY_NO, N1ST_SKD_DIR_CD, N1ST_VSL_SLAN_CD, N1ST_ORG_CONTI_CD, N1ST_DEST_CONTI_CD, N1ST_R_LANE,
                N2ND_PCTL_SEQ, N2ND_VSL_CD, N2ND_SKD_VOY_NO, N2ND_SKD_DIR_CD, N2ND_VSL_SLAN_CD, N2ND_ORG_CONTI_CD, N2ND_DEST_CONTI_CD, N2ND_R_LANE,
                N3RD_PCTL_SEQ, N3RD_VSL_CD, N3RD_SKD_VOY_NO, N3RD_SKD_DIR_CD, N3RD_VSL_SLAN_CD, N3RD_ORG_CONTI_CD, N3RD_DEST_CONTI_CD, N3RD_R_LANE,
                N4TH_PCTL_SEQ, N4TH_VSL_CD, N4TH_SKD_VOY_NO, N4TH_SKD_DIR_CD, N4TH_VSL_SLAN_CD, N4TH_ORG_CONTI_CD, N4TH_DEST_CONTI_CD, N4TH_R_LANE,
                (CASE WHEN -- COA_RANK_INFO_FNC 의 예외사항처리 : TZ_DWLL_TM_HRS의 MAX값으로 결정한다
                        -- 1. Mother Vsl 인데, R.Lane이 'RBCCO'로 결정될 경우
                        ('NOFDR' IN (N1ST_R_LANE,N2ND_R_LANE,N3RD_R_LANE,N4TH_R_LANE))
                        -- 2. COA_RANK_INFO_FNC 내에서 동일 순위 처리되는 경우
                        OR  1 <   (SELECT COUNT(rnk_seq) FROM ar_rout_rnk WHERE rlane_cd = N1ST_R_LANE AND SUBSTR (zn_ioc_cd,1,2) = substr(CPARA1,1,2) AND delt_flg='N')
                        OR  1 <   DECODE(N2ND_R_LANE,NULL,0,(SELECT COUNT(rnk_seq) FROM ar_rout_rnk WHERE rlane_cd = N2ND_R_LANE AND SUBSTR (zn_ioc_cd,1,2) = substr(CPARA2,1,2) AND delt_flg='N'))
                        OR  1 <   DECODE(N3RD_R_LANE,NULL,0,(SELECT COUNT(rnk_seq) FROM ar_rout_rnk WHERE rlane_cd = N3RD_R_LANE AND SUBSTR (zn_ioc_cd,1,2) = substr(CPARA3,1,2) AND delt_flg='N'))
                        OR  1 <   DECODE(N4TH_R_LANE,NULL,0,(SELECT COUNT(rnk_seq) FROM ar_rout_rnk WHERE rlane_cd = N4TH_R_LANE AND SUBSTR (zn_ioc_cd,1,2) = substr(CPARA4,1,2) AND delt_flg='N'))
                        -- 3. COA_RANK_INFO_FNC 내에서 rnk_seq 가 null 로 결정될 경우
                        OR ((SELECT SUM(rnk_seq) FROM ar_rout_rnk WHERE rlane_cd = N1ST_R_LANE AND SUBSTR (zn_ioc_cd,1,2) = substr(CPARA1,1,2) AND delt_flg='N')
                                 + DECODE(N2ND_R_LANE,NULL,0,(SELECT SUM(rnk_seq) FROM ar_rout_rnk WHERE rlane_cd = N2ND_R_LANE AND SUBSTR (zn_ioc_cd,1,2) = substr(CPARA2,1,2) AND delt_flg='N'))
                                 + DECODE(N3RD_R_LANE,NULL,0,(SELECT SUM(rnk_seq) FROM ar_rout_rnk WHERE rlane_cd = N3RD_R_LANE AND SUBSTR (zn_ioc_cd,1,2) = substr(CPARA3,1,2) AND delt_flg='N'))
                                 + DECODE(N4TH_R_LANE,NULL,0,(SELECT SUM(rnk_seq) FROM ar_rout_rnk WHERE rlane_cd = N4TH_R_LANE AND SUBSTR (zn_ioc_cd,1,2) = substr(CPARA4,1,2) AND delt_flg='N')) IS NULL)
                   THEN MAX_TZ_TM
                   ELSE DECODE(COA_RANK_INFO_FNC(N1ST_R_LANE,N2ND_R_LANE,N3RD_R_LANE,N4TH_R_LANE,CPARA1,CPARA2,CPARA3,CPARA4)
                               , 1, N1ST_TZTM_HRS_BY_R_LANE, 2, N2ND_TZTM_HRS_BY_R_LANE, 3, N3RD_TZTM_HRS_BY_R_LANE, N4TH_TZTM_HRS_BY_R_LANE)
                END) T_SEQ
            FROM(
                SELECT
                    PCTL_NO,
                    MAX(RNK) CNT,
                    MAX(DECODE(RNK,1,PCTL_SEQ)) N1ST_PCTL_SEQ,
                    MAX(DECODE(RNK,1,VSL_CD)) N1ST_VSL_CD,
                    MAX(DECODE(RNK,1,SKD_VOY_NO)) N1ST_SKD_VOY_NO,
                    MAX(DECODE(RNK,1,SKD_DIR_CD)) N1ST_SKD_DIR_CD,
                    MAX(DECODE(RNK,1,VSL_SLAN_CD)) N1ST_VSL_SLAN_CD,
                    MAX(DECODE(RNK,1,ORG_CONTI_CD)) N1ST_ORG_CONTI_CD,
                    MAX(DECODE(RNK,1,DEST_CONTI_CD)) N1ST_DEST_CONTI_CD,
                    MAX(DECODE(RNK,1,R_LANE_CD)) N1ST_R_LANE,
                    MAX(DECODE(RNK,1,TZ_DWLL_TM_HRS)) N1ST_TZTM_HRS,
                    MAX(DECODE(RNK,1,MAX_TZ_TM_BY_R_LANE)) N1ST_TZTM_HRS_BY_R_LANE,
                    MAX(DECODE(RNK,1,CAPAR)) CPARA1,
                    MAX(DECODE(RNK,2,PCTL_SEQ)) N2ND_PCTL_SEQ,
                    MAX(DECODE(RNK,2,VSL_CD)) N2ND_VSL_CD,
                    MAX(DECODE(RNK,2,SKD_VOY_NO)) N2ND_SKD_VOY_NO,
                    MAX(DECODE(RNK,2,SKD_DIR_CD)) N2ND_SKD_DIR_CD,
                    MAX(DECODE(RNK,2,VSL_SLAN_CD)) N2ND_VSL_SLAN_CD,
                    MAX(DECODE(RNK,2,ORG_CONTI_CD)) N2ND_ORG_CONTI_CD,
                    MAX(DECODE(RNK,2,DEST_CONTI_CD)) N2ND_DEST_CONTI_CD,
                    MAX(DECODE(RNK,2,R_LANE_CD)) N2ND_R_LANE,
                    MAX(DECODE(RNK,2,TZ_DWLL_TM_HRS)) N2ND_TZTM_HRS,
                    MAX(DECODE(RNK,2,MAX_TZ_TM_BY_R_LANE)) N2ND_TZTM_HRS_BY_R_LANE,
                    MAX(DECODE(RNK,2,CAPAR)) CPARA2,
                    MAX(DECODE(RNK,3,PCTL_SEQ)) N3RD_PCTL_SEQ,
                    MAX(DECODE(RNK,3,VSL_CD)) N3RD_VSL_CD,
                    MAX(DECODE(RNK,3,SKD_VOY_NO)) N3RD_SKD_VOY_NO,
                    MAX(DECODE(RNK,3,SKD_DIR_CD)) N3RD_SKD_DIR_CD,
                    MAX(DECODE(RNK,3,VSL_SLAN_CD)) N3RD_VSL_SLAN_CD,
                    MAX(DECODE(RNK,3,ORG_CONTI_CD)) N3RD_ORG_CONTI_CD,
                    MAX(DECODE(RNK,3,DEST_CONTI_CD)) N3RD_DEST_CONTI_CD,
                    MAX(DECODE(RNK,3,R_LANE_CD)) N3RD_R_LANE,
                    MAX(DECODE(RNK,3,TZ_DWLL_TM_HRS)) N3RD_TZTM_HRS,
                    MAX(DECODE(RNK,3,MAX_TZ_TM_BY_R_LANE)) N3RD_TZTM_HRS_BY_R_LANE,
                    MAX(DECODE(RNK,3,CAPAR)) CPARA3,
                    MAX(DECODE(RNK,4,PCTL_SEQ)) N4TH_PCTL_SEQ,
                    MAX(DECODE(RNK,4,VSL_CD)) N4TH_VSL_CD,
                    MAX(DECODE(RNK,4,SKD_VOY_NO)) N4TH_SKD_VOY_NO,
                    MAX(DECODE(RNK,4,SKD_DIR_CD)) N4TH_SKD_DIR_CD,
                    MAX(DECODE(RNK,4,VSL_SLAN_CD)) N4TH_VSL_SLAN_CD,
                    MAX(DECODE(RNK,4,ORG_CONTI_CD)) N4TH_ORG_CONTI_CD,
                    MAX(DECODE(RNK,4,DEST_CONTI_CD)) N4TH_DEST_CONTI_CD,
                    MAX(DECODE(RNK,4,R_LANE_CD)) N4TH_R_LANE,
                    MAX(DECODE(RNK,4,TZ_DWLL_TM_HRS)) N4TH_TZTM_HRS,
                    MAX(DECODE(RNK,4,MAX_TZ_TM_BY_R_LANE)) N4TH_TZTM_HRS_BY_R_LANE,
                    MAX(DECODE(RNK,4,CAPAR)) CPARA4,
                    MAX(MAX_TZ_TM) MAX_TZ_TM
                FROM(
                    SELECT
                          PCTL_NO,PCTL_SEQ,ORG_NOD_CD,ORG_CONTI_CD,DEST_NOD_CD,DEST_CONTI_CD,VSL_SLAN_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,TZ_DWLL_TM_HRS,RNK,R_LANE_CD
                        , MAX(DECODE(MAX_TZ_TM, 1, RNK)) OVER (PARTITION BY PCTL_NO) MAX_TZ_TM
                        , IOC_CD AS CAPAR
                        , MAX(DECODE(MAX_TZ_TM_BY_R_LANE, 1, RNK)) OVER (PARTITION BY PCTL_NO, R_LANE_CD) MAX_TZ_TM_BY_R_LANE
                    FROM(
                        SELECT
                            PCTL_NO
                          , PCTL_SEQ
                          , IOC_CD
                          , ORG_NOD_CD
                          , ORG_CONTI_CD
                          , DEST_NOD_CD
                          , DEST_CONTI_CD
                          , VSL_SLAN_CD
                          , VSL_CD
                          , SKD_VOY_NO
                          , SKD_DIR_CD
                          , TZ_DWLL_TM_HRS
                          , RANK() OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) RNK
                          , R_LANE_CD
                          , ROW_NUMBER() OVER (PARTITION BY PCTL_NO ORDER BY TZ_DWLL_TM_HRS DESC, PCTL_SEQ) MAX_TZ_TM
                          , R_LANE_CD CPARA
                             , ROW_NUMBER() OVER  (PARTITION BY PCTL_NO, R_LANE_CD ORDER BY TZ_DWLL_TM_HRS DESC, PCTL_SEQ) MAX_TZ_TM_BY_R_LANE
                        FROM(
                            SELECT
                                RDTL.PCTL_NO
                              , RDTL.PCTL_SEQ
                              , DECODE(IOC_CD, 'O', 'OO', NULL, DECODE(OLOC.CONTI_CD, DLOC.CONTI_CD, 'I' || DLOC.CONTI_CD, 'OO'), IOC_CD || DLOC.CONTI_CD) AS IOC_CD
                              , RDTL.ORG_NOD_CD
                              , OLOC.CONTI_CD ORG_CONTI_CD
                              , RDTL.DEST_NOD_CD
                              , DLOC.CONTI_CD DEST_CONTI_CD
                              , RDTL.VSL_SLAN_CD, RDTL.VSL_CD, RDTL.SKD_VOY_NO, RDTL.SKD_DIR_CD
                              , RDTL.TZ_DWLL_TM_HRS
                              , CASE WHEN RLAN.RLANE_CD IS NULL OR RLAN.RLANE_CD = 'RBCCO' THEN DECODE(MVSL.VSL_SVC_TP_CD, 'O', 'RBCCO', 'NOFDR')
                                   ELSE RLAN.RLANE_CD
                               END AS  R_LANE_CD
                            FROM PRD_PROD_CTL_ROUT_DTL RDTL
                                LEFT OUTER JOIN MDM_LOCATION OLOC
                                ON (OLOC.LOC_CD = SUBSTR(RDTL.ORG_NOD_CD,1,5))
                                LEFT OUTER JOIN MDM_LOCATION DLOC
                                ON (DLOC.LOC_CD = SUBSTR(RDTL.DEST_NOD_CD,1,5))
                                LEFT OUTER JOIN MDM_DTL_REV_LANE RLAN
                                ON (RLAN.VSL_SLAN_DIR_CD = RDTL.SKD_DIR_CD
                                    AND RLAN.FM_CONTI_CD = OLOC.CONTI_CD
                                    AND RLAN.TO_CONTI_CD = DLOC.CONTI_CD
                                    AND SUBSTR(RLAN.RLANE_CD,1,3) = RDTL.VSL_SLAN_CD
                                    AND RLAN.DELT_FLG = 'N')
                                LEFT OUTER JOIN MDM_VSL_SVC_LANE MVSL -- REVENUE LANE이 없거나, RBCCO인 경우, MDM_VSL_SVC_LANE을 확인해서 FEEDER인지 확인한다.
                                ON (NVL(RLAN.RLANE_CD,'RBCCO') = 'RBCCO'
                                    AND MVSL.VSL_SLAN_CD = RDTL.VSL_SLAN_CD )
                            WHERE RDTL.PCTL_NO LIKE V_PCTL_NO||'%'
                            AND RDTL.PCTL_IO_BND_CD = 'T'
                            AND RDTL.NOD_LNK_DIV_CD = 'L'
                            AND RDTL.VSL_SLAN_CD IS NOT NULL
                            AND RDTL.TRSP_MOD_CD IN ('WD','VD')
                            )
                        )
                    )
                GROUP BY PCTL_NO
               )
           )
    )
    LOOP
        R_PCTL_SEQ := V_AA.PCTL_SEQ;
        R_VSL_CD   := V_AA.VSL_CD;
        R_VOY_NO   := V_AA.VOY_NO;
        R_DIR_CD   := V_AA.DIR_CD;
    END LOOP;

    IF V_DIV = 'VVD' THEN
        RET_VAL := R_VSL_CD||R_VOY_NO||R_DIR_CD;
    ELSIF V_DIV = 'SEQ' THEN
        RET_VAL := R_PCTL_SEQ;
    END IF;


    RETURN RET_VAL;
END;
/

