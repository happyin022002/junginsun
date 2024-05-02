create or replace procedure TRS_CHG_MGT_SO_CREATE_PRC
/*******************************************************************************
    1. Object Name      : TRS_CHG_MGT_SO_CREATE_PRC
    2. Version          : 1.0
    3. Create Date      : 2016.1.19
    4. Sub System       : TRS
    5. Author           :
    6. Description      : S/O Creation > Shipment Change Management
    7. Revision History :
  *******************************************************************************/
(IN_TRSP_SO_OFC_CTY_CD VARCHAR2, IN_TRSP_SO_SEQ NUMBER, IN_UPD_FLG BOOLEAN DEFAULT FALSE) AUTHID CURRENT_USER IS
  V_SO                           TRS_TRSP_SVC_ORD%ROWTYPE;
  v_div_cd                       VARCHAR2(3) := '@#@';
  INS_TRS_TRSP_SVC_ORD_BKG_CNG_Q VARCHAR2(3000);
  INS_TRS_TRSP_BKG_CNG_Q         VARCHAR2(3000);
  --  VVSV / VVTV
  CURSOR BKG_VVDTS(IN_BKG_NO VARCHAR2) IS
    SELECT K.*,
           NVL((SELECT C.TRSP_CNG_SUB_SEQ
                 FROM TRS_TRSP_BKG_CNG C
                WHERE C.BKG_NO = IN_BKG_NO
                  AND C.CNG_CATE_CD = K.CNG_CATE_CD
                  AND C.CNG_CATE_SUB_CD = K.CNG_CATE_SUB_CD
                  AND C.PRMRY_COL_VAL_RMK = K.PRMRY_COL_VAL_RMK
                  AND ROWNUM = 1),
               1) TRSP_CNG_SUB_SEQ
      FROM (SELECT BKG_NO,
                   'VV' CNG_CATE_CD,
                   DECODE(VSL_PRE_PST_CD, 'S', 'SV', 'T', 'TV') CNG_CATE_SUB_CD,
                   'BKG_NO,VSL_PRE_PST_CD,VSL_SEQ' AS PRMRY_COL_NM,
                   BKG_NO || v_div_cd || VSL_PRE_PST_CD || v_div_cd || VSL_SEQ AS PRMRY_COL_VAL_RMK,
                   'BKG_VVD' AS TBL_NM,
                   'PRE_VSL_CD,PRE_SKD_VOY_NO,PRE_SKD_DIR_CD,PRE_SLAN_CD' AS COL_NM,
                   VSL_CD || v_div_cd || SKD_VOY_NO || v_div_cd || SKD_DIR_CD || v_div_cd || SLAN_CD AS COL_N1ST_RMK,
                   NULL AS COL_N2ND_RMK,
                   RANK() OVER(PARTITION BY BKG_NO, VSL_PRE_PST_CD ORDER BY VSL_SEQ) RK
              FROM BKG_VVD
             WHERE BKG_NO = IN_BKG_NO
               AND VSL_PRE_PST_CD IN ('S', 'T')) K
     WHERE RK = 1;

  --CNCN
  CURSOR BKG_CNCN(IN_BKG_NO VARCHAR2) IS
    SELECT K.*,
           NVL((SELECT C.TRSP_CNG_SUB_SEQ
                 FROM TRS_TRSP_BKG_CNG C
                WHERE C.BKG_NO = IN_BKG_NO
                  AND C.CNG_CATE_CD = K.CNG_CATE_CD
                  AND C.CNG_CATE_SUB_CD = K.CNG_CATE_SUB_CD
                  AND C.PRMRY_COL_VAL_RMK = K.PRMRY_COL_VAL_RMK
                  AND ROWNUM = 1),
               1) TRSP_CNG_SUB_SEQ
      FROM (SELECT X.BKG_NO,
                   'CN' CNG_CATE_CD,
                   'CN' CNG_CATE_SUB_CD,
                   'BKG_NO' AS PRMRY_COL_NM,
                   X.BKG_NO AS PRMRY_COL_VAL_RMK,
                   'BKG_BOOKING' AS TBL_NM,
                   'DCGO_FLG_BB_CGO_FLG_AWK_CGO_FLG_RC_FLG_RD_CGO_FLG' AS COL_NM,
                   CASE
                     WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y' AND
                          SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 2) + 1, INSTR(X.BKG_SPE, '^', 1, 3) - INSTR(X.BKG_SPE, '^', 1, 2) - 1) = 'Y' THEN
                      'AD'
                     WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y' AND
                          SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 3) + 1, INSTR(X.BKG_SPE, '^', 1, 4) - INSTR(X.BKG_SPE, '^', 1, 3) - 1) = 'Y' THEN
                      'RD'
                     WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y' AND
                          SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 2) + 1, INSTR(X.BKG_SPE, '^', 1, 3) - INSTR(X.BKG_SPE, '^', 1, 2) - 1) != 'Y' AND
                          SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 3) + 1, INSTR(X.BKG_SPE, '^', 1, 4) - INSTR(X.BKG_SPE, '^', 1, 3) - 1) != 'Y' THEN
                      'DG'
                     WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) != 'Y' AND
                          SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 2) + 1, INSTR(X.BKG_SPE, '^', 1, 3) - INSTR(X.BKG_SPE, '^', 1, 2) - 1) = 'Y' THEN
                      'AK'
                     WHEN SUBSTR(X.BKG_SPE, 0, INSTR(X.BKG_SPE, '^', 1, 1) - 1) != 'Y' AND
                          SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 3) + 1, INSTR(X.BKG_SPE, '^', 1, 4) - INSTR(X.BKG_SPE, '^', 1, 3) - 1) = 'Y' THEN
                      'RF'
                     WHEN SUBSTR(X.BKG_SPE, INSTR(X.BKG_SPE, '^', 1, 1) + 1, INSTR(X.BKG_SPE, '^', 1, 2) - INSTR(X.BKG_SPE, '^', 1, 1) - 1) = 'Y' THEN
                      'BB'
                     ELSE
                      'GP'
                   END AS COL_N1ST_RMK,
                   NULL AS COL_N2ND_RMK
              FROM (SELECT BKG_NO,
                           NVL(BKG.DCGO_FLG, ' ') || '^' || NVL(BKG.BB_CGO_FLG, ' ') || '^' || NVL(BKG.AWK_CGO_FLG, ' ') || '^' || NVL(BKG.RC_FLG, ' ') || '^' || NVL(BKG.RD_CGO_FLG, ' ') || '^' AS BKG_SPE
                      FROM BKG_BOOKING BKG
                     WHERE BKG.BKG_NO = IN_BKG_NO) X) K;

  --CTPO / CTIN
  CURSOR BKG_CUFF(IN_BKG_NO VARCHAR2) IS
    SELECT K.*,
           NVL((SELECT C.TRSP_CNG_SUB_SEQ
                 FROM TRS_TRSP_BKG_CNG C
                WHERE C.BKG_NO = IN_BKG_NO
                  AND C.CNG_CATE_CD = K.CNG_CATE_CD
                  AND C.CNG_CATE_SUB_CD = K.CNG_CATE_SUB_CD
                  AND C.PRMRY_COL_VAL_RMK = K.PRMRY_COL_VAL_RMK
                  AND ROWNUM = 1),
               1) TRSP_CNG_SUB_SEQ
      FROM (SELECT BKG_NO,
                   'CT' AS CNG_CATE_CD,
                   DECODE(CLZ_TP_CD, 'T', 'PO', 'R', 'IN') AS CNG_CATE_SUB_CD,
                   'BKG_NO, CLZ_TP_CD' AS PRMRY_COL_NM,
                   BKG_NO || v_div_cd || CLZ_TP_CD AS PRMRY_COL_VAL_RMK,
                   'BKG_CLZ_TM' AS TBL_NM,
                   'MNL_SET_DT_SYS_SET_DT' AS COL_NM,
                   NVL(TO_CHAR(MNL_SET_DT, 'YYYY-MM-DD HH24:MI:SS'), TO_CHAR(SYS_SET_DT, 'YYYY-MM-DD HH24:MI:SS')) AS COL_N1ST_RMK,
                   NULL AS COL_N2ND_RMK
              FROM BKG_CLZ_TM
             WHERE BKG_NO = IN_BKG_NO
               AND CLZ_TP_CD IN ('T', 'R')) K;

  --CURS
  CURSOR BKG_CRUS(IN_BKG_NO VARCHAR2, IN_BL_NO VARCHAR2) IS
    SELECT K.*,
           NVL((SELECT C.TRSP_CNG_SUB_SEQ
                 FROM TRS_TRSP_BKG_CNG C
                WHERE C.BKG_NO = IN_BKG_NO
                  AND C.CNG_CATE_CD = K.CNG_CATE_CD
                  AND C.CNG_CATE_SUB_CD = K.CNG_CATE_SUB_CD
                  AND C.PRMRY_COL_VAL_RMK = K.PRMRY_COL_VAL_RMK
                  AND ROWNUM = 1),
               1) TRSP_CNG_SUB_SEQ
      FROM (SELECT IN_BKG_NO AS BKG_NO,
                   'CR' AS CNG_CATE_CD,
                   'US' AS CNG_CATE_SUB_CD,
                   'BL_NO' AS PRMRY_COL_NM,
                   BL_NO AS PRMRY_COL_VAL_RMK,
                   'BKG_CGO_RLSE' AS TBL_NM,
                   'FRT_CLT_FLG,OBL_RDEM_FLG,CSTMS_CLR_CD' AS COL_NM,
                   FRT_CLT_FLG || v_div_cd || OBL_RDEM_FLG || v_div_cd || CSTMS_CLR_CD AS COL_N1ST_RMK,
                   NULL AS COL_N2ND_RMK
              FROM BKG_CGO_RLSE R
             WHERE BL_NO = IN_BL_NO) K;

  --ATAU
  CURSOR BKG_ATAU(IN_BKG_NO VARCHAR2, IN_BND_CD VARCHAR2, IN_TRO_SEQ NUMBER, IN_TRO_SUB_SEQ NUMBER) IS
    SELECT K.*,
           NVL((SELECT C.TRSP_CNG_SUB_SEQ
                 FROM TRS_TRSP_BKG_CNG C
                WHERE C.BKG_NO = IN_BKG_NO
                  AND C.CNG_CATE_CD = K.CNG_CATE_CD
                  AND C.CNG_CATE_SUB_CD = K.CNG_CATE_SUB_CD
                  AND C.PRMRY_COL_VAL_RMK = K.PRMRY_COL_VAL_RMK
                  AND ROWNUM = 1),
               TO_NUMBER(IN_TRO_SEQ || IN_TRO_SUB_SEQ)) TRSP_CNG_SUB_SEQ
      FROM (SELECT B.BKG_NO,
                   'AT' AS CNG_CATE_CD,
                   'AU' AS CNG_CATE_SUB_CD,
                   'BKG_NO,IO_BND_CD,RTN_TRO_FLG,TRO_SEQ,TRO_SUB_SEQ' AS PRMRY_COL_NM,
                   B.BKG_NO || v_div_cd || B.IO_BND_CD || v_div_cd || B.RTN_TRO_FLG || v_div_cd || B.TRO_SEQ || v_div_cd || B.TRO_SUB_SEQ AS PRMRY_COL_VAL_RMK,
                   'BKG_TRO,BKG_TRO_DTL' AS TBL_NM,
                   'ZN_CD,DOR_PST_NO,ACT_SHPR_ADDR,DOR_ARR_DT,DIFF_RMK' AS COL_NM,
                   A.ZN_CD || v_div_cd || A.DOR_PST_NO || v_div_cd || A.ACT_SHPR_ADDR || v_div_cd || TO_CHAR(B.DOR_ARR_DT, 'YYYYMMDDHH24MISS') AS COL_N1ST_RMK,
                   A.DIFF_RMK AS COL_N2ND_RMK
              FROM BKG_TRO A, BKG_TRO_DTL B
             WHERE A.BKG_NO = B.BKG_NO
               AND A.IO_BND_CD = B.IO_BND_CD
               AND A.RTN_TRO_FLG = B.RTN_TRO_FLG
               AND A.TRO_SEQ = B.TRO_SEQ
               AND A.BKG_NO = IN_BKG_NO
               AND A.IO_BND_CD = IN_BND_CD
               AND A.TRO_SEQ = IN_TRO_SEQ
               AND B.TRO_SUB_SEQ = IN_TRO_SUB_SEQ) K;

  --ATEU
  CURSOR BKG_ATEU(IN_BKG_NO VARCHAR2, IN_BND_CD VARCHAR2, IN_TRO_SEQ NUMBER, IN_TRO_SUB_SEQ NUMBER) IS
    SELECT K.*,
           NVL((SELECT C.TRSP_CNG_SUB_SEQ
                 FROM TRS_TRSP_BKG_CNG C
                WHERE C.BKG_NO = IN_BKG_NO
                  AND C.CNG_CATE_CD = K.CNG_CATE_CD
                  AND C.CNG_CATE_SUB_CD = K.CNG_CATE_SUB_CD
                  AND C.PRMRY_COL_VAL_RMK = K.PRMRY_COL_VAL_RMK
                  AND ROWNUM = 1),
               TO_NUMBER(IN_TRO_SEQ || IN_TRO_SUB_SEQ)) TRSP_CNG_SUB_SEQ
      FROM (SELECT B.BKG_NO,
                   'AT' AS CNG_CATE_CD,
                   'EU' AS CNG_CATE_SUB_CD,
                   'BKG_NO,IO_BND_CD,TRO_SEQ,TRO_SUB_SEQ' AS PRMRY_COL_NM,
                   B.BKG_NO || v_div_cd || B.IO_BND_CD || v_div_cd || B.TRO_SEQ || v_div_cd || B.TRO_SUB_SEQ AS PRMRY_COL_VAL_RMK,
                   'BKG_EUR_TRO,BKG_EUR_TRO_DTL' AS TBL_NM,
                   'DOR_ADDR,LOD_REF_NO,DOR_ZIP_ID,CNTC_PSON_NM,CNTC_PHN_NO,CNTC_EML,ARR_DT,SPCL_INSTR_RMK' AS COL_NM,
                   B.DOR_ADDR || v_div_cd || B.LOD_REF_NO || v_div_cd || B.DOR_ZIP_ID || v_div_cd || B.CNTC_PSON_NM || v_div_cd || B.CNTC_PHN_NO || v_div_cd || B.CNTC_EML || v_div_cd ||
                   TO_CHAR(B.ARR_DT, 'YYYYMMDDHH24MISS') AS COL_N1ST_RMK,
                   A.SPCL_INSTR_RMK AS COL_N2ND_RMK
              FROM BKG_EUR_TRO A, BKG_EUR_TRO_DTL B
             WHERE A.BKG_NO = B.BKG_NO
               AND A.IO_BND_CD = B.IO_BND_CD
               AND A.TRO_SEQ = B.TRO_SEQ
               AND A.BKG_NO = IN_BKG_NO
               AND A.IO_BND_CD = IN_BND_CD
               AND A.TRO_SEQ = IN_TRO_SEQ
               AND B.TRO_SUB_SEQ = IN_TRO_SUB_SEQ) K;
  --SCDG
  CURSOR BKG_SCDG(IN_BKG_NO VARCHAR2) IS
    SELECT K.*,
           NVL((SELECT C.TRSP_CNG_SUB_SEQ
                 FROM TRS_TRSP_BKG_CNG C
                WHERE C.BKG_NO = IN_BKG_NO
                  AND C.CNG_CATE_CD = K.CNG_CATE_CD
                  AND C.CNG_CATE_SUB_CD = K.CNG_CATE_SUB_CD
                  AND C.PRMRY_COL_VAL_RMK = K.PRMRY_COL_VAL_RMK
                  AND ROWNUM = 1),
               DCGO_SEQ) TRSP_CNG_SUB_SEQ
      FROM (SELECT BKG_NO,
                   'SC' AS CNG_CATE_CD,
                   'DG' AS CNG_CATE_SUB_CD,
                   DCGO_SEQ,
                   'BKG_NO,DCGO_SEQ' AS PRMRY_COL_NM,
                   BKG_NO || v_div_cd || DCGO_SEQ AS PRMRY_COL_VAL_RMK,
                   'BKG_DG_CGO' AS TBL_NM,
                   'IMDG_UN_NO,IMDG_UN_NO_SEQ,IMDG_CLSS_CD,GRS_WGT,NET_WGT,PRP_SHP_NM,FLSH_PNT_CDO_TEMP,IMDG_PCK_GRP_CD,PSA_NO,MRN_POLUT_FLG,EMER_CNTC_PHN_NO_CTNT,EMER_CNTC_PSON_NM,HZD_DESC' AS COL_NM,
                   IMDG_UN_NO || v_div_cd || IMDG_UN_NO_SEQ || v_div_cd || IMDG_CLSS_CD || v_div_cd || GRS_WGT || v_div_cd || NET_WGT || v_div_cd || PRP_SHP_NM || v_div_cd || FLSH_PNT_CDO_TEMP ||
                   v_div_cd || IMDG_PCK_GRP_CD || v_div_cd || PSA_NO || v_div_cd || MRN_POLUT_FLG || v_div_cd || EMER_CNTC_PHN_NO_CTNT || v_div_cd || EMER_CNTC_PSON_NM AS COL_N1ST_RMK,
                   HZD_DESC AS COL_N2ND_RMK
              FROM BKG_DG_CGO
             WHERE BKG_NO = IN_BKG_NO) K;
  --SCRF
  CURSOR BKG_SCRF(IN_BKG_NO VARCHAR2) IS
    SELECT K.*,
           NVL((SELECT C.TRSP_CNG_SUB_SEQ
                 FROM TRS_TRSP_BKG_CNG C
                WHERE C.BKG_NO = IN_BKG_NO
                  AND C.CNG_CATE_CD = K.CNG_CATE_CD
                  AND C.CNG_CATE_SUB_CD = K.CNG_CATE_SUB_CD
                  AND C.PRMRY_COL_VAL_RMK = K.PRMRY_COL_VAL_RMK
                  AND ROWNUM = 1),
               RC_SEQ) TRSP_CNG_SUB_SEQ
      FROM (SELECT BKG_NO,
                   'SC' AS CNG_CATE_CD,
                   'RF' AS CNG_CATE_SUB_CD,
                   RC_SEQ,
                   'BKG_NO,RC_SEQ' AS PRMRY_COL_NM,
                   BKG_NO || v_div_cd || RC_SEQ AS PRMRY_COL_VAL_RMK,
                   'BKG_RF_CGO' AS TBL_NM,
                   'CDO_TEMP,FDO_TEMP,VENT_RTO' AS COL_NM,
                   CDO_TEMP || v_div_cd || FDO_TEMP || v_div_cd || VENT_RTO AS COL_N1ST_RMK,
                   NULL AS COL_N2ND_RMK
              FROM BKG_RF_CGO
             WHERE BKG_NO = IN_BKG_NO) K;
  --SCAW
  CURSOR BKG_SCAW(IN_BKG_NO VARCHAR2) IS
    SELECT K.*,
           NVL((SELECT C.TRSP_CNG_SUB_SEQ
                 FROM TRS_TRSP_BKG_CNG C
                WHERE C.BKG_NO = IN_BKG_NO
                  AND C.CNG_CATE_CD = K.CNG_CATE_CD
                  AND C.CNG_CATE_SUB_CD = K.CNG_CATE_SUB_CD
                  AND C.PRMRY_COL_VAL_RMK = K.PRMRY_COL_VAL_RMK
                  AND ROWNUM = 1),
               AWK_CGO_SEQ) TRSP_CNG_SUB_SEQ
      FROM (SELECT BKG_NO,
                   'SC' AS CNG_CATE_CD,
                   'AW' AS CNG_CATE_SUB_CD,
                   AWK_CGO_SEQ,
                   'BKG_NO,AWK_CGO_SEQ' AS PRMRY_COL_NM,
                   BKG_NO || v_div_cd || AWK_CGO_SEQ AS PRMRY_COL_VAL_RMK,
                   'BKG_AWK_CGO' AS TBL_NM,
                   'TTL_DIM_LEN,TTL_DIM_WDT,TTL_DIM_HGT' AS COL_NM,
                   TTL_DIM_LEN || v_div_cd || TTL_DIM_WDT || v_div_cd || TTL_DIM_HGT AS COL_N1ST_RMK,
                   NULL AS COL_N2ND_RMK
              FROM BKG_AWK_CGO
             WHERE BKG_NO = IN_BKG_NO) K;
BEGIN
  DBMS_OUTPUT.DISABLE;

  -- INSERT / UPDATE  Query -
  INS_TRS_TRSP_BKG_CNG_Q := 'MERGE INTO TRS_TRSP_BKG_CNG B
                            USING DUAL
                            ON (B.BKG_NO = :A1 AND B.CNG_CATE_CD = :A2 AND B.CNG_CATE_SUB_CD = :A3 AND B.TRSP_CNG_SUB_SEQ = :A4)
                            WHEN NOT MATCHED THEN
                              INSERT (
                                 BKG_NO
                                ,CNG_CATE_CD
                                ,CNG_CATE_SUB_CD
                                ,TRSP_CNG_SUB_SEQ
                                ,PRMRY_COL_NM
                                ,PRMRY_COL_VAL_RMK
                                ,TBL_NM
                                ,COL_NM
                                ,COL_N1ST_RMK
                                ,COL_N2ND_RMK
                                ,DELT_FLG
                                ,LOCL_CRE_DT
                                ,LOCL_UPD_DT
                                ,CRE_USR_ID
                                ,CRE_DT
                                ,UPD_USR_ID
                                ,UPD_DT
                                ,CNG_IND_FLG
                              ) VALUES (
                                :A5, :A6, :A7, :A8, :A9, :A10, :A11, :A12, :A13, :A14, :A15, :A16, :A17, :A18, :A19, :A20, :A21, :A21
                              )';

  --  INSERT / UPDATE  Query -  TRS_TRSP_SVC_ORD_BKG_CNG
  INS_TRS_TRSP_SVC_ORD_BKG_CNG_Q := 'MERGE INTO TRS_TRSP_SVC_ORD_BKG_CNG B
                                    USING DUAL
                                    ON (TRSP_SO_OFC_CTY_CD = :A1 AND TRSP_SO_SEQ = :A2 AND TRSP_SO_SUB_SEQ = 1 AND BKG_NO = :A3 AND CNG_CATE_CD = :A4 AND CNG_CATE_SUB_CD = :A5 AND TRSP_CNG_SUB_SEQ = :A6)
                                    WHEN MATCHED THEN
                                      UPDATE
                                         SET COL_N1ST_RMK     = :A7
                                            ,COL_N2ND_RMK     = :A8
                                            ,PRE_COL_N1ST_RMK = :A9
                                            ,PRE_COL_N2ND_RMK = :A10
                                            ,CNG_IND_FLG      = :A11
                                            ,UPD_USR_ID       = :A12
                                            ,UPD_DT           = :A13
                                    WHEN NOT MATCHED THEN
                                      INSERT (
                                         TRSP_SO_OFC_CTY_CD
                                        ,TRSP_SO_SEQ
                                        ,TRSP_SO_SUB_SEQ
                                        ,BKG_NO
                                        ,CNG_CATE_CD
                                        ,CNG_CATE_SUB_CD
                                        ,TRSP_CNG_SUB_SEQ
                                        ,COL_N1ST_RMK
                                        ,COL_N2ND_RMK
                                        ,PRE_COL_N1ST_RMK
                                        ,PRE_COL_N2ND_RMK
                                        ,CNG_IND_FLG
                                        ,CRE_USR_ID
                                        ,CRE_DT
                                        ,UPD_USR_ID
                                        ,UPD_DT
                                      ) VALUES (
                                        :A14, :A15, 1, :A16, :A17, :A18, :A19, :A20, :A21, :A22, :A23, :A24, :A25, :A26, :A27, :A28
                                      )';

  BEGIN
    SELECT SO.TRSP_SO_OFC_CTY_CD,
           SO.TRSP_SO_SEQ,
           SO.BKG_NO,
           SO.BL_NO,
           SO.EQ_NO,
           SO.EQ_TPSZ_CD,
           SO.TRSP_BND_CD,
           SO.TRSP_COST_DTL_MOD_CD,
           SO.TRO_SEQ,
           SO.TRO_SUB_SEQ,
           SO.CRE_OFC_CD,
           SO.CRE_USR_ID,
           SO.CRE_DT,
           SO.UPD_USR_ID,
           SO.UPD_DT,
           SO.LOCL_CRE_DT,
           SO.LOCL_UPD_DT
      INTO V_SO.TRSP_SO_OFC_CTY_CD,
           V_SO.TRSP_SO_SEQ,
           V_SO.BKG_NO,
           V_SO.BL_NO,
           V_SO.EQ_NO,
           V_SO.EQ_TPSZ_CD,
           V_SO.TRSP_BND_CD,
           V_SO.TRSP_COST_DTL_MOD_CD,
           V_SO.TRO_SEQ,
           V_SO.TRO_SUB_SEQ,
           V_SO.CRE_OFC_CD,
           V_SO.CRE_USR_ID,
           V_SO.CRE_DT,
           V_SO.UPD_USR_ID,
           V_SO.UPD_DT,
           V_SO.LOCL_CRE_DT,
           V_SO.LOCL_UPD_DT
      FROM TRS_TRSP_SVC_ORD SO
     WHERE SO.TRSP_SO_OFC_CTY_CD = IN_TRSP_SO_OFC_CTY_CD
       AND SO.TRSP_SO_SEQ = IN_TRSP_SO_SEQ;

    -- TRS_TRSP_SVC_ORD_CNG  Creation
    MERGE INTO TRS_TRSP_SVC_ORD_CNG C
    USING DUAL
    ON (C.TRSP_SO_OFC_CTY_CD = V_SO.TRSP_SO_OFC_CTY_CD AND C.TRSP_SO_SEQ = V_SO.TRSP_SO_SEQ AND C.TRSP_SO_SUB_SEQ = 1)
    WHEN MATCHED THEN
      UPDATE
         SET C.BKG_NO       = V_SO.BKG_NO,
             C.EQ_NO        = V_SO.EQ_NO,
             C.CNTR_TPSZ_CD = V_SO.EQ_TPSZ_CD,
             C.CNG_IND_FLG  = 'N',
             C.CRE_OFC_CD   = NVL(C.CRE_OFC_CD, V_SO.CRE_OFC_CD),
             C.LOCL_UPD_DT  = V_SO.LOCL_UPD_DT,
             C.UPD_DT       = V_SO.UPD_DT,
             C.UPD_USR_ID   = V_SO.UPD_USR_ID
    WHEN NOT MATCHED THEN
      INSERT
        (TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, TRSP_SO_SUB_SEQ, BKG_NO, EQ_NO, CNTR_TPSZ_CD, CNG_IND_FLG, CRE_OFC_CD, DELT_FLG, LOCL_CRE_DT, LOCL_UPD_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)
      VALUES
        (V_SO.TRSP_SO_OFC_CTY_CD,
         V_SO.TRSP_SO_SEQ,
         1,
         V_SO.BKG_NO,
         V_SO.EQ_NO,
         V_SO.EQ_TPSZ_CD,
         'N',
         V_SO.CRE_OFC_CD,
         'N',
         V_SO.LOCL_CRE_DT,
         V_SO.LOCL_UPD_DT,
         V_SO.CRE_USR_ID,
         V_SO.CRE_DT,
         V_SO.UPD_USR_ID,
         V_SO.UPD_DT);

    /*
    * BKG_VVD
    * - Category : VV(Vessel/Voyage) / Sub-Category : Pre-VVD(SV), Trunk VVD(TV)
    * S : PRE, T : Trunk, U : Post
    * If the value is more then 2 as same 'S', the applicable PRE VVD is minimum value of VSL Sequence.
    */
    FOR V IN BKG_VVDTS(V_SO.BKG_NO) LOOP
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_BKG_CNG_Q
          USING V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.PRMRY_COL_NM, V.PRMRY_COL_VAL_RMK, V.TBL_NM, V.COL_NM, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.LOCL_CRE_DT, V_SO.LOCL_UPD_DT, V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT, 'N';
      END;
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_SVC_ORD_BKG_CNG_Q
          USING V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.UPD_USR_ID, V_SO.UPD_DT, V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT;
      END;
    END LOOP;

    /*
    * BKG_BOOKING - Cargo Nature
    * - Category : CN(Cargo Nature) / Sub-Category : CN(Dangerous, Reefer, Awkward Flag)
    */
    FOR V IN BKG_CNCN(V_SO.BKG_NO) LOOP
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_BKG_CNG_Q
          USING V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.PRMRY_COL_NM, V.PRMRY_COL_VAL_RMK, V.TBL_NM, V.COL_NM, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.LOCL_CRE_DT, V_SO.LOCL_UPD_DT, V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT, 'N';
      END;
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_SVC_ORD_BKG_CNG_Q
          USING V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.UPD_USR_ID, V_SO.UPD_DT, V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT;
      END;
    END LOOP;
    /*
    * Booking Cut Off Time
    * Category : CT(Cut Off Time) / Sub-Category : PO(Port Cut Off), IN(Inland Cut Off)
    */
    FOR V IN BKG_CUFF(V_SO.BKG_NO) LOOP
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_BKG_CNG_Q
          USING V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.PRMRY_COL_NM, V.PRMRY_COL_VAL_RMK, V.TBL_NM, V.COL_NM, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.LOCL_CRE_DT, V_SO.LOCL_UPD_DT, V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT, 'N';
      END;
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_SVC_ORD_BKG_CNG_Q
          USING V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.UPD_USR_ID, V_SO.UPD_DT, V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT;
      END;
    END LOOP;

    /*
    * BKG_CGO_RLSE (F,O,C)
    * - Category : CR(Special Cargo) / Sub-Category : US(USA)
    */
    IF V_SO.TRSP_BND_CD = 'I' THEN
      FOR V IN BKG_CRUS(V_SO.BKG_NO, V_SO.BL_NO) LOOP
        BEGIN
          EXECUTE IMMEDIATE INS_TRS_TRSP_BKG_CNG_Q
            USING V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.PRMRY_COL_NM, V.PRMRY_COL_VAL_RMK, V.TBL_NM, V.COL_NM, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.LOCL_CRE_DT, V_SO.LOCL_UPD_DT, V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT, 'N';
        END;
        BEGIN
          EXECUTE IMMEDIATE INS_TRS_TRSP_SVC_ORD_BKG_CNG_Q
            USING V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.UPD_USR_ID, V_SO.UPD_DT, V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT;
        END;
      END LOOP;
    END IF;

    /*
    * BKG_TRO, BKG_TRO_DTL
    * - Category : AT(Appointment) / Sub-Category : AU(AISA & USA)
    */
    FOR V IN BKG_ATAU(V_SO.BKG_NO, V_SO.TRSP_BND_CD, V_SO.TRO_SEQ, V_SO.TRO_SUB_SEQ) LOOP
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_BKG_CNG_Q
          USING V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.PRMRY_COL_NM, V.PRMRY_COL_VAL_RMK, V.TBL_NM, V.COL_NM, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.LOCL_CRE_DT, V_SO.LOCL_UPD_DT, V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT, 'N';
      END;
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_SVC_ORD_BKG_CNG_Q
          USING V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.UPD_USR_ID, V_SO.UPD_DT, V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT;
      END;
    END LOOP;

    /*
    * BKG_EUR_TRO, BKG_EUR_TRO_DTL
    * - Category : AT(Appointment) / Sub-Category : EU(EUR)
    */
    FOR V IN BKG_ATEU(V_SO.BKG_NO, V_SO.TRSP_BND_CD, V_SO.TRO_SEQ, V_SO.TRO_SUB_SEQ) LOOP
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_BKG_CNG_Q
          USING V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.PRMRY_COL_NM, V.PRMRY_COL_VAL_RMK, V.TBL_NM, V.COL_NM, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.LOCL_CRE_DT, V_SO.LOCL_UPD_DT, V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT, 'N';
      END;
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_SVC_ORD_BKG_CNG_Q
          USING V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.UPD_USR_ID, V_SO.UPD_DT, V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT;
      END;
    END LOOP;
    /*
    * BKG_DG_CGO
    * - Category : SC(Special Cargo) / Sub-Category : DG(Dangerous)
    */
    FOR V IN BKG_SCDG(V_SO.BKG_NO) LOOP
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_BKG_CNG_Q
          USING V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.PRMRY_COL_NM, V.PRMRY_COL_VAL_RMK, V.TBL_NM, V.COL_NM, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.LOCL_CRE_DT, V_SO.LOCL_UPD_DT, V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT, 'N';
      END;
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_SVC_ORD_BKG_CNG_Q
          USING V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.UPD_USR_ID, V_SO.UPD_DT, V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT;
      END;
    END LOOP;

    /*
    * BKG_RF_CGO
    * - Category : SC(Special Cargo) / Sub-Category : RF(Reefer)
    */
      FOR V IN BKG_SCRF(V_SO.BKG_NO) LOOP
        BEGIN
          EXECUTE IMMEDIATE INS_TRS_TRSP_BKG_CNG_Q
            USING V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.PRMRY_COL_NM, V.PRMRY_COL_VAL_RMK, V.TBL_NM, V.COL_NM, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.LOCL_CRE_DT, V_SO.LOCL_UPD_DT, V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT, 'N';
        END;
        BEGIN
          EXECUTE IMMEDIATE INS_TRS_TRSP_SVC_ORD_BKG_CNG_Q
            USING V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.UPD_USR_ID, V_SO.UPD_DT, V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT;
        END;
      END LOOP;
    /*
    * BKG_AWK_CGO
    * - Category : SC(Special Cargo) / Sub-Category : AW(Awkward)
    */
    FOR V IN BKG_SCAW(V_SO.BKG_NO) LOOP
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_BKG_CNG_Q
          USING V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.PRMRY_COL_NM, V.PRMRY_COL_VAL_RMK, V.TBL_NM, V.COL_NM, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.LOCL_CRE_DT, V_SO.LOCL_UPD_DT, V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT, 'N';
      END;
      BEGIN
        EXECUTE IMMEDIATE INS_TRS_TRSP_SVC_ORD_BKG_CNG_Q
          USING V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.UPD_USR_ID, V_SO.UPD_DT, V_SO.TRSP_SO_OFC_CTY_CD, V_SO.TRSP_SO_SEQ, V.BKG_NO, V.CNG_CATE_CD, V.CNG_CATE_SUB_CD, V.TRSP_CNG_SUB_SEQ, V.COL_N1ST_RMK, V.COL_N2ND_RMK, V.COL_N1ST_RMK, V.COL_N2ND_RMK, 'N', V_SO.CRE_USR_ID, V_SO.CRE_DT, V_SO.UPD_USR_ID, V_SO.UPD_DT;
      END;
    END LOOP;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND');
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('OTHERS');
  END;
END TRS_CHG_MGT_SO_CREATE_PRC;
