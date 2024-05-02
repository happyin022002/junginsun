create or replace procedure TRS_CHG_MGT_SO_SYNC_PRC
/*******************************************************************************
    1. Object Name      : TRS_CHG_MGT_SO_SYNC_PRC
    2. Version          : 1.0
    3. Create Date      : 2015.03.06
    4. Sub System       : TRS
    5. Author           :
    6. Description      :
    7. Revision History :
  *******************************************************************************/
(IN_BKG_NO             VARCHAR2,
 IN_TRSP_SO_OFC_CTY_CD VARCHAR2,
 IN_TRSP_SO_SEQ        NUMBER,
 IN_TRSP_SO_SUB_SEQ    NUMBER,
 IN_TRSP_CNG_SUB_SEQ   NUMBER,
 IN_CNG_CATE_CD        VARCHAR2,
 IN_CNG_CATE_SUB_CD    VARCHAR2,
 IN_UPD_USR_ID         VARCHAR2) AUTHID CURRENT_USER IS

  V_COL_CNT    number(3);
  V_DATA_CNT   number(3);
  COL_NM       TRS_TRSP_BKG_CNG.COL_NM%TYPE;
  COL_N1ST_RMK TRS_TRSP_BKG_CNG.COL_N1ST_RMK%TYPE;
  COL_N2ND_RMK TRS_TRSP_BKG_CNG.COL_N2ND_RMK%TYPE;
  TYPE NESTED_TAB IS TABLE OF VARCHAR2(1000) INDEX BY VARCHAR2(100);
  DTAB NESTED_TAB;
  invalid_exception EXCEPTION;
  PRAGMA EXCEPTION_INIT(invalid_exception, -20100);
  VALUE_DELIMITER CHAR(3) := '@#@';

  V_IB_BKG_VVD  BKG_VVD%ROWTYPE;
  V_OB_BKG_VVD  BKG_VVD%ROWTYPE;
  V_BKG_BOOKING BKG_BOOKING%ROWTYPE;

BEGIN
  DBMS_OUTPUT.DISABLE;

  IF IN_CNG_CATE_CD IN ('AT', 'CN', 'VV') THEN
    BEGIN
      SELECT COL_NM
            ,C.COL_N1ST_RMK
            ,C.COL_N2ND_RMK
            ,DECODE(SUBSTR(TRIM(COL_NM), -1), ',', REGEXP_COUNT(COL_NM, ','), REGEXP_COUNT(COL_NM, ',') + 1)
            ,DECODE(SUBSTR(TRIM(COL_N1ST_RMK), -3), VALUE_DELIMITER, REGEXP_COUNT(COL_N1ST_RMK, VALUE_DELIMITER), REGEXP_COUNT(COL_N1ST_RMK, VALUE_DELIMITER) + 1)
        into COL_NM
            ,COL_N1ST_RMK
            ,COL_N2ND_RMK
            ,V_COL_CNT
            ,V_DATA_CNT
        FROM TRS_TRSP_BKG_CNG C
       WHERE BKG_NO = IN_BKG_NO
         AND TRSP_CNG_SUB_SEQ = IN_TRSP_CNG_SUB_SEQ
         AND CNG_CATE_CD = IN_CNG_CATE_CD
         AND CNG_CATE_SUB_CD = IN_CNG_CATE_SUB_CD
         AND C.DELT_FLG = 'N';

      IF V_COL_CNT > 0 THEN
        COL_N1ST_RMK := REGEXP_REPLACE(REGEXP_REPLACE(COL_N1ST_RMK, '\^', '#####'), VALUE_DELIMITER, ' ^');
        FOR X IN 1 .. V_COL_CNT LOOP
          IF V_COL_CNT = V_DATA_CNT THEN
            DTAB(REGEXP_SUBSTR(COL_NM, '[^,]+', 1, X)) := TRIM(REGEXP_REPLACE(REGEXP_SUBSTR(COL_N1ST_RMK, '[^^]+', 1, X), '#####', '^'));
          ELSE
            IF X <= V_DATA_CNT THEN
              DTAB(REGEXP_SUBSTR(COL_NM, '[^,]+', 1, X)) := TRIM(REGEXP_REPLACE(REGEXP_SUBSTR(COL_N1ST_RMK, '[^^]+', 1, X), '#####', '^'));
            ELSE
              DTAB(REGEXP_SUBSTR(COL_NM, '[^,]+', 1, X)) := TRIM(COL_N2ND_RMK);
            END IF;
          END IF;
        END LOOP;
        IF IN_CNG_CATE_SUB_CD = 'EU' THEN
          UPDATE TRS_TRSP_SVC_ORD O
             SET O.TRO_LOD_REF_NO   = DTAB('LOD_REF_NO')
                ,O.DOR_PST_CD       = DTAB('DOR_ZIP_ID')
                ,O.DOR_NOD_PLN_DT   = TO_DATE(DTAB('ARR_DT'), 'YYYYMMDDHH24MISS')
                ,O.CNTC_PSON_NM     = DTAB('CNTC_PSON_NM')
                ,O.CNTC_PSON_PHN_NO = DTAB('CNTC_PHN_NO')
                ,O.DOR_DE_ADDR      = DTAB('DOR_ADDR')
                ,O.SPCL_INSTR_RMK   = DTAB('SPCL_INSTR_RMK')
                ,O.LOCL_UPD_DT      = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(O.CRE_OFC_CD)
                ,O.UPD_DT           = SYSDATE
                ,O.UPD_USR_ID       = IN_UPD_USR_ID
           WHERE O.TRSP_SO_OFC_CTY_CD = IN_TRSP_SO_OFC_CTY_CD
             AND O.TRSP_SO_SEQ = IN_TRSP_SO_SEQ;
        ELSIF IN_CNG_CATE_SUB_CD = 'AU' THEN
          UPDATE TRS_TRSP_SVC_ORD O
             SET O.DOR_PST_CD     = DTAB('DOR_PST_NO')
                ,O.DOR_NOD_PLN_DT = TO_DATE(DTAB('DOR_ARR_DT'), 'YYYYMMDDHH24MISS')
                ,O.DOR_DE_ADDR    = DTAB('ACT_SHPR_ADDR')
                ,O.SPCL_INSTR_RMK = DTAB('DIFF_RMK')
                ,O.DOR_NOD_CD     = DTAB('ZN_CD')
                ,O.LOCL_UPD_DT    = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(O.CRE_OFC_CD)
                ,O.UPD_DT         = SYSDATE
                ,O.UPD_USR_ID     = IN_UPD_USR_ID
           WHERE O.TRSP_SO_OFC_CTY_CD = IN_TRSP_SO_OFC_CTY_CD
             AND O.TRSP_SO_SEQ = IN_TRSP_SO_SEQ;
        ELSIF IN_CNG_CATE_SUB_CD = 'CN' THEN
          UPDATE TRS_TRSP_SVC_ORD O
             SET O.SPCL_CGO_CNTR_TP_CD = DTAB('DCGO_FLG_BB_CGO_FLG_AWK_CGO_FLG_RC_FLG_RD_CGO_FLG')
           WHERE O.TRSP_SO_OFC_CTY_CD = IN_TRSP_SO_OFC_CTY_CD
             AND O.TRSP_SO_SEQ = IN_TRSP_SO_SEQ;
        ELSIF IN_CNG_CATE_SUB_CD IN ('TV', 'SV') THEN
          SELECT O.VSL_CD
                ,O.SKD_VOY_NO
                ,O.SKD_DIR_CD
                ,O.SLAN_CD
            INTO V_BKG_BOOKING.VSL_CD
                ,V_BKG_BOOKING.SKD_VOY_NO
                ,V_BKG_BOOKING.SKD_DIR_CD
                ,V_BKG_BOOKING.SLAN_CD
            FROM BKG_BOOKING O
           WHERE BKG_NO = IN_BKG_NO;
          BEGIN
            SELECT IB.VSL_CD
                  ,IB.SKD_VOY_NO
                  ,IB.SKD_DIR_CD
                  ,IB.SLAN_CD
                  ,IB.POD_CD
                  ,IB.VSL_PRE_PST_CD
              INTO V_IB_BKG_VVD.VSL_CD
                  ,V_IB_BKG_VVD.SKD_VOY_NO
                  ,V_IB_BKG_VVD.SKD_DIR_CD
                  ,V_IB_BKG_VVD.SLAN_CD
                  ,V_IB_BKG_VVD.POD_CD
                  ,V_IB_BKG_VVD.VSL_PRE_PST_CD
              FROM BKG_VVD          IB
                  ,TRS_TRSP_SVC_ORD SO
             WHERE IB.BKG_NO = SO.BKG_NO
               AND IB.POD_CD = SUBSTR(SO.FM_NOD_CD, 1, 5)
               AND SO.TRSP_SO_OFC_CTY_CD = IN_TRSP_SO_OFC_CTY_CD
               AND SO.TRSP_SO_SEQ = IN_TRSP_SO_SEQ
               AND ROWNUM = 1;
          EXCEPTION
            WHEN NO_DATA_FOUND THEN
              DBMS_OUTPUT.PUT_LINE('IB_NO_DATA_FOUND');
          END;
          BEGIN
            SELECT OB.VSL_CD
                  ,OB.SKD_VOY_NO
                  ,OB.SKD_DIR_CD
                  ,OB.SLAN_CD
                  ,OB.POD_CD
                  ,OB.VSL_PRE_PST_CD
              INTO V_OB_BKG_VVD.VSL_CD
                  ,V_OB_BKG_VVD.SKD_VOY_NO
                  ,V_OB_BKG_VVD.SKD_DIR_CD
                  ,V_OB_BKG_VVD.SLAN_CD
                  ,V_OB_BKG_VVD.POD_CD
                  ,V_OB_BKG_VVD.VSL_PRE_PST_CD
              FROM BKG_VVD          OB
                  ,TRS_TRSP_SVC_ORD SO
             WHERE OB.BKG_NO = SO.BKG_NO
               AND OB.POL_CD = SUBSTR(DECODE(SO.TRSP_BND_CD, 'O', SO.TO_NOD_CD, SO.FM_NOD_CD), 1, 5)
               AND SO.TRSP_SO_OFC_CTY_CD = IN_TRSP_SO_OFC_CTY_CD
               AND SO.TRSP_SO_SEQ = IN_TRSP_SO_SEQ
               AND ROWNUM = 1;
          EXCEPTION
            WHEN NO_DATA_FOUND THEN
              DBMS_OUTPUT.PUT_LINE('OB_NO_DATA_FOUND');
          END;

          UPDATE TRS_TRSP_SVC_ORD O
             SET O.VSL_CD           = V_BKG_BOOKING.VSL_CD
                ,O.SKD_VOY_NO       = V_BKG_BOOKING.SKD_VOY_NO
                ,O.SKD_DIR_CD       = V_BKG_BOOKING.SKD_DIR_CD
                ,O.SLAN_CD          = V_BKG_BOOKING.SLAN_CD
                ,O.FDR_VSL_CD       = DECODE(O.TRSP_BND_CD, 'I', V_IB_BKG_VVD.VSL_CD, V_OB_BKG_VVD.VSL_CD)
                ,O.FDR_SKD_VOY_NO   = DECODE(O.TRSP_BND_CD, 'I', V_IB_BKG_VVD.SKD_VOY_NO, V_OB_BKG_VVD.SKD_VOY_NO)
                ,O.FDR_SKD_DIR_CD   = DECODE(O.TRSP_BND_CD, 'I', V_IB_BKG_VVD.SKD_DIR_CD, V_OB_BKG_VVD.SKD_DIR_CD)
                ,O.IB_VVD_CD        = V_IB_BKG_VVD.VSL_CD || V_IB_BKG_VVD.SKD_VOY_NO || V_IB_BKG_VVD.SKD_DIR_CD
                ,O.OB_VVD_CD        = V_OB_BKG_VVD.VSL_CD || V_OB_BKG_VVD.SKD_VOY_NO || V_OB_BKG_VVD.SKD_DIR_CD
                ,O.TRSP_NXT_PORT_CD = DECODE(O.TRSP_BND_CD, 'I', V_IB_BKG_VVD.POD_CD, V_OB_BKG_VVD.POD_CD)
                ,O.LOCL_UPD_DT      = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(O.CRE_OFC_CD)
                ,O.UPD_DT           = SYSDATE
                ,O.UPD_USR_ID       = IN_UPD_USR_ID
           WHERE O.TRSP_SO_OFC_CTY_CD = IN_TRSP_SO_OFC_CTY_CD
             AND O.TRSP_SO_SEQ = IN_TRSP_SO_SEQ;
        END IF;
      END IF;
    EXCEPTION
      WHEN OTHERS THEN
        DBMS_OUTPUT.put_line(SQLERRM);
    END;
  END IF;

  UPDATE TRS_TRSP_SVC_ORD_BKG_CNG K
     SET CNG_IND_FLG        = 'N'
        ,K.PRE_COL_N1ST_RMK = K.COL_N1ST_RMK
        ,K.PRE_COL_N2ND_RMK = K.COL_N2ND_RMK
        ,UPD_USR_ID         = IN_UPD_USR_ID
        ,UPD_DT             = SYSDATE
   WHERE K.TRSP_SO_OFC_CTY_CD = IN_TRSP_SO_OFC_CTY_CD
     AND K.TRSP_SO_SEQ = IN_TRSP_SO_SEQ
     AND K.TRSP_SO_SUB_SEQ = 1
     AND K.BKG_NO = IN_BKG_NO
     AND K.CNG_CATE_CD = IN_CNG_CATE_CD
     AND K.CNG_CATE_SUB_CD = IN_CNG_CATE_SUB_CD
     AND K.TRSP_CNG_SUB_SEQ = IN_TRSP_CNG_SUB_SEQ;

  UPDATE TRS_TRSP_SVC_ORD_CNG S
     SET CNG_IND_FLG  =
         (SELECT MAX(CNG_IND_FLG)
            FROM TRS_TRSP_SVC_ORD_BKG_CNG
           WHERE TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD
             AND TRSP_SO_SEQ = S.TRSP_SO_SEQ
             AND TRSP_SO_SUB_SEQ = 1
             AND BKG_NO = S.BKG_NO
         )
        ,S.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT CRE_OFC_CD
                                                             FROM TRS_TRSP_SVC_ORD
                                                            WHERE TRSP_SO_OFC_CTY_CD = S.TRSP_SO_OFC_CTY_CD
                                                              AND TRSP_SO_SEQ = S.TRSP_SO_SEQ))
        ,UPD_USR_ID    = IN_UPD_USR_ID
        ,UPD_DT        = SYSDATE
   WHERE TRSP_SO_OFC_CTY_CD = IN_TRSP_SO_OFC_CTY_CD
     AND TRSP_SO_SEQ = IN_TRSP_SO_SEQ
     AND TRSP_SO_SUB_SEQ = 1;
  DBMS_OUTPUT.PUT_LINE('So Bkg Sync');
EXCEPTION
  WHEN invalid_exception THEN
    DBMS_OUTPUT.put_line(SQLERRM);
  WHEN OTHERS THEN
    DBMS_OUTPUT.put_line(SQLERRM);
END TRS_CHG_MGT_SO_SYNC_PRC;
