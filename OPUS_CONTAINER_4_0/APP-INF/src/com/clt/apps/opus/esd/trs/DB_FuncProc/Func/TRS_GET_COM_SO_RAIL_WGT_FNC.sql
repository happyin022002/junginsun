CREATE OR REPLACE FUNCTION OPUSADM.TRS_GET_COM_SO_RAIL_WGT_FNC
/* ========================================================
     1. Object Name      : TRS_GET_COM_WGT_FNC
     2. Version          : 1.0
     3. Create Date      : 2015.07.03
     4. Sub System       : TRS
     5. Author           :
     6. Description      : SO WEIGHT
     7. Revision History :
     8. Return : Net Weight | Tare Weight | Gross Weight
     9. Parameter :
        I_GUBUN -> S : W/O Container Weight
                -> P : W/O Preview Container Weight [RD]
                -> R : US Rail
                -> RO : US Outbound Rail
                -> B : Booking
                -> C : COA
        I_TRSP_SO_OFC_CTY_CD :  S/O CODE
        I_TRSP_SO_SEQ : S/O Sequence
        I_WO_PRV_GRP_SEQ : W/O Group Sequence ( Only I_GUBUN == 'P' )
        I_WGT_UNIT_CD : Weight Unit Code
  ======================================================== */
(
  I_GUBUN              IN CHAR
 ,I_TRSP_SO_OFC_CTY_CD IN VARCHAR2
 ,I_TRSP_SO_SEQ        IN NUMBER
 ,I_WO_PRV_GRP_SEQ     IN NUMBER
 ,I_BKG_NO             IN VARCHAR2
 ,I_EQ_NO              IN VARCHAR2
 ,I_EQ_TPSZ_CD         IN VARCHAR2
 ,I_WGT_UNIT_CD        IN VARCHAR2
 ,I_COP_NO             IN VARCHAR2 DEFAULT NULL
 ,I_TEU_USE_FLG        IN CHAR DEFAULT 'Y'
) RETURN VARCHAR2 AUTHID CURRENT_USER IS

  SP_NET_WGT     NUMBER(18, 3) := 0.00;
  O_NET_WEIGHT   NUMBER(18, 3) := 0.00;
  O_TARE_WEIGHT  NUMBER(18, 3) := 0.00;
  O_GROSS_WEIGHT NUMBER(18, 3) := 0.00;
  O_VGM_WEIGHT  NUMBER(18, 3) := 0.00;

  T_TARE_KGS_WEIGHT  NUMBER(18, 3) := 0.00;
  T_TARE_LBS_WEIGHT  NUMBER(18, 3) := 0.00;

  V_WGT_UT_CD  VARCHAR(3); -- Booking Weight Unit Code
  V_ACT_WEIGHT NUMBER(18, 3) := 0; --BOOKING BL DOC ACTUAL WEIGHT
  V_TPSZ       NUMBER;

  V_TRSP_SO_STS_CD TRS_TRSP_SVC_ORD.TRSP_SO_STS_CD%TYPE;
  V_TRO_SEQ        TRS_TRSP_SVC_ORD.TRO_SEQ%TYPE;
  V_CNTR_KGS_WGT   NUMBER(18, 3) := 0.00;
  V_CNTR_LBS_WGT   NUMBER(18, 3) := 0.00;
  V_EQ_KND_CD      TRS_TRSP_SVC_ORD.EQ_KND_CD%TYPE;

  V_VGM_KGS_WGT    NUMBER(18, 3) := 0.00;
  V_VGM_LBS_WGT    NUMBER(18, 3) := 0.00;

  V_BKG_NO      VARCHAR2(13);
  V_COP_NO      VARCHAR2(14);
  V_CNTR_NO     VARCHAR2(15);
  V_EQ_TPSZ_CD  VARCHAR2(4);
  V_IO_BND_CD   VARCHAR2(1);
  V_CONTI_CD    VARCHAR2(1);

BEGIN
  DBMS_OUTPUT.disable;
  BEGIN
    IF I_GUBUN = 'S' OR I_GUBUN = 'P' THEN
      SELECT SO.BKG_NO
            ,SO.EQ_NO
            ,SO.EQ_TPSZ_CD
            ,SO.TRSP_BND_CD
            ,SO.TRO_SEQ
            ,SO.CONTI_CD
            ,SO.TRSP_SO_STS_CD
            ,NVL(SO.CNTR_KGS_WGT, 0)
            ,NVL(SO.CNTR_LBS_WGT, 0)
            ,SO.EQ_KND_CD
            ,SO.COP_NO
        INTO V_BKG_NO
            ,V_CNTR_NO
            ,V_EQ_TPSZ_CD
            ,V_IO_BND_CD
            ,V_TRO_SEQ
            ,V_CONTI_CD
            ,V_TRSP_SO_STS_CD
            ,V_CNTR_KGS_WGT
            ,V_CNTR_LBS_WGT
            ,V_EQ_KND_CD
            ,V_COP_NO
        FROM TRS_TRSP_SVC_ORD SO
       WHERE SO.TRSP_SO_OFC_CTY_CD = I_TRSP_SO_OFC_CTY_CD
         AND SO.TRSP_SO_SEQ = I_TRSP_SO_SEQ;
    END IF;

    IF V_EQ_KND_CD IN ('Z', 'G') THEN
      RETURN('0' || '|' || '0' || '|' || '0');
    END IF;

    IF V_BKG_NO IS NULL THEN
      V_BKG_NO := I_BKG_NO;
    END IF;
    IF V_CNTR_NO IS NULL THEN
      V_CNTR_NO := I_EQ_NO;
    END IF;
    IF V_EQ_TPSZ_CD IS NULL THEN
      V_EQ_TPSZ_CD := I_EQ_TPSZ_CD;
    END IF;

    IF V_BKG_NO IS NOT NULL AND V_CNTR_NO IS NOT NULL THEN
      BEGIN
        SELECT TRS_COMMON_PKG.GET_CONV_WGT_TO_KGS_FNC(NVL(BC.VGM_WGT_UT_CD, 'KGS'), NVL(BC.VGM_WGT, 0))
              ,TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(NVL(BC.VGM_WGT_UT_CD, 'KGS'), NVL(BC.VGM_WGT, 0))
          INTO V_VGM_KGS_WGT, V_VGM_LBS_WGT
          FROM BKG_CONTAINER BC
         WHERE BC.BKG_NO = V_BKG_NO AND BC.CNTR_NO = V_CNTR_NO;
       EXCEPTION WHEN NO_DATA_FOUND THEN
            V_VGM_KGS_WGT := 0.00;
            V_VGM_LBS_WGT := 0.00;
       END;
    END IF;

    --Tare Weight (LBS)
    SELECT TARE_KGS_WGT
          ,TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC('KGS', TARE_KGS_WGT) TARE_LBS_WGT
          ,EQ_TPSZ
      INTO T_TARE_KGS_WEIGHT, T_TARE_LBS_WEIGHT, V_TPSZ
      FROM (SELECT (CASE WHEN SIGN(NVL(M.TARE_WGT, 0)) > 0 THEN M.TARE_WGT
                         ELSE (CASE WHEN SIGN(NVL(B.TARE_WGT, 0)) > 0 THEN B.TARE_WGT ELSE NVL(A.CNTR_TPSZ_TARE_WGT, 0) END)
                   END) TARE_KGS_WGT
                  ,DECODE(SUBSTR(X.EQ_TPSZ_CD, -1), 2, 1, 2) EQ_TPSZ
              FROM MST_CONTAINER M
                  ,MDM_CNTR_TP_SZ A
                  ,MST_CNTR_SPEC B
                  ,(SELECT V_CNTR_NO AS EQ_NO, V_EQ_TPSZ_CD AS EQ_TPSZ_CD FROM DUAL) X
             WHERE X.EQ_NO = M.CNTR_NO(+)
               AND M.CNTR_SPEC_NO = B.CNTR_SPEC_NO(+)
               AND X.EQ_TPSZ_CD = A.CNTR_TPSZ_CD(+)
               AND NVL(A.DELT_FLG(+), 'N') = 'N');
  END;
  IF I_GUBUN = 'S' AND V_TRSP_SO_STS_CD = 'I' THEN
      O_NET_WEIGHT := V_CNTR_LBS_WGT;  --LBS
  ELSIF (I_GUBUN = 'S' AND V_TRSP_SO_STS_CD <> 'I') OR I_GUBUN IN ('B', 'C', 'RO', 'RI') THEN
    IF I_GUBUN = 'RO' THEN
        IF V_VGM_KGS_WGT > 0 THEN
          O_NET_WEIGHT := V_VGM_LBS_WGT - T_TARE_LBS_WEIGHT;
          GOTO goto_result;
        END IF;
    END IF;
    IF I_COP_NO IS NOT NULL THEN
       V_COP_NO := I_COP_NO;
    END IF;
    FOR T1 IN (SELECT BC.BKG_NO, BC.CNTR_NO, BC.CNTR_TPSZ_CD, DECODE(BC.WGT_UT_CD, 'LBS', NVL(BC.CNTR_WGT, 0), TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(BC.WGT_UT_CD, NVL(BC.CNTR_WGT, 0)))  CNTR_WGT     --LBS
                 FROM BKG_CONTAINER BC, BKG_BOOKING B, BKG_BOOKING B1
                WHERE 1 = 1
                  AND B.BKG_NO = (SELECT S2.BKG_NO
                                    FROM SCE_COP_HDR S1, SCE_COP_HDR S2
                                   WHERE S1.MST_COP_NO = S2.COP_NO
                                     AND S1.COP_NO = V_COP_NO
                                     AND ROWNUM = 1)
                  AND B.BKG_NO <> B1.BKG_NO
                  AND B.VSL_CD = B1.VSL_CD
                  AND B.SKD_VOY_NO = B1.SKD_VOY_NO
                  AND B.SKD_DIR_CD = B1.SKD_DIR_CD
                  AND B1.BKG_NO = BC.BKG_NO
                  AND BC.CNTR_NO = I_EQ_NO
                  AND B1.BKG_CGO_TP_CD = 'F'
                  AND (B1.BKG_STS_CD = 'W' OR B1.BKG_STS_CD = 'F')
               UNION ALL
               SELECT BC.BKG_NO, BC.CNTR_NO, BC.CNTR_TPSZ_CD, DECODE(BC.WGT_UT_CD, 'LBS', NVL(BC.CNTR_WGT, 0), TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(BC.WGT_UT_CD, NVL(BC.CNTR_WGT, 0)))  CNTR_WGT  --LBS
                 FROM BKG_CONTAINER BC
                WHERE BC.BKG_NO = I_BKG_NO
                  AND BC.CNTR_NO = I_EQ_NO
               UNION ALL
               SELECT I_BKG_NO     BKG_NO
                     ,I_EQ_NO      CNTR_NO
                     ,I_EQ_TPSZ_CD CNTR_TPSZ_CD
                     ,0            CNTR_WGT
                 FROM DUAL
                WHERE NOT EXISTS
                (SELECT 1
                         FROM BKG_CONTAINER BC
                        WHERE BC.BKG_NO = I_BKG_NO
                          AND BC.CNTR_NO = I_EQ_NO))
    LOOP
      BEGIN
         SP_NET_WGT  := T1.CNTR_WGT;     --LBS
         V_WGT_UT_CD := 'LBS';

        --Actual Weight
        SELECT DECODE(NVL(WGT_UT_CD, 'KGS'),'LBS', NVL(ACT_WGT, 0),  TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(NVL(WGT_UT_CD, 'KGS'), NVL(ACT_WGT, 0))) / NVL((SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, -1), 2, 1, 2) * OP_CNTR_QTY)
                               FROM BKG_QUANTITY
                              WHERE BKG_NO = T1.BKG_NO)
                            ,1)
          INTO V_ACT_WEIGHT
          FROM BKG_BL_DOC
         WHERE BKG_NO = T1.BKG_NO;

        -- BY CHO 201506015
        IF SP_NET_WGT = 0 THEN
           IF SP_NET_WGT = 0 AND V_CONTI_CD = 'E' AND I_GUBUN != 'B' THEN
            BEGIN
              SELECT DECODE(NVL(DOC.WGT_UT_CD, 'KGS'), 'LBS',NVL(TRO.CGO_WGT, 0), TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(NVL(DOC.WGT_UT_CD, 'KGS'), NVL(TRO.CGO_WGT, 0))) --LBS
                INTO SP_NET_WGT
                FROM BKG_EUR_TRO TRO, BKG_BL_DOC DOC
               WHERE TRO.BKG_NO = DOC.BKG_NO
                 AND TRO.BKG_NO = T1.BKG_NO
                 AND TRO.TRO_SEQ = V_TRO_SEQ
                 AND TRO.IO_BND_CD = V_IO_BND_CD;
            EXCEPTION
              WHEN NO_DATA_FOUND THEN
                SP_NET_WGT := 0;
            END;
          END IF;
          IF SP_NET_WGT = 0 AND I_TEU_USE_FLG = 'Y' THEN
            SP_NET_WGT := V_ACT_WEIGHT * V_TPSZ;
          END IF;
       END IF;
      EXCEPTION
          WHEN NO_DATA_FOUND THEN
               SP_NET_WGT := 0;
      END;
      O_NET_WEIGHT := O_NET_WEIGHT + SP_NET_WGT;
    END LOOP;
  ELSIF I_GUBUN = 'P' THEN
    BEGIN
      SELECT NVL(TMP.CNTR_LBS_WGT, 0)  --LBS
        INTO O_NET_WEIGHT
        FROM TRS_TRSP_WRK_ORD_PRV_TMP TMP
       WHERE TMP.TRSP_SO_OFC_CTY_CD = I_TRSP_SO_OFC_CTY_CD
         AND TMP.TRSP_SO_SEQ = I_TRSP_SO_SEQ
         AND TMP.WO_PRV_GRP_SEQ = I_WO_PRV_GRP_SEQ;
    END;
  ELSIF I_GUBUN = 'R' THEN
    BEGIN
      SELECT CASE SO.TRSP_BND_CD WHEN  'O' THEN DECODE(SO.WGT_MEAS_UT_CD, 'LBS', NVL(SO.CNTR_WGT, 0), TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(SO.WGT_MEAS_UT_CD, NVL(SO.CNTR_WGT, 0)))
                                 WHEN  'I' THEN DECODE(D.WGT_UT_CD, 'LBS', NVL(D.CNTR_WGT, 0), TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(D.WGT_UT_CD, NVL(D.CNTR_WGT, 0)))
             END NET_WGT,  --LBS
             TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC('KGS', MST_SPEC_FNC('TARE', SO.EQ_NO)),
             MST_SPEC_FNC('TARE', SO.EQ_NO)
        INTO O_NET_WEIGHT, T_TARE_LBS_WEIGHT, T_TARE_KGS_WEIGHT
        FROM TRS_TRSP_RAIL_BIL_ORD SO, BKG_CONTAINER D
       WHERE SO.TRSP_SO_OFC_CTY_CD = I_TRSP_SO_OFC_CTY_CD
         AND SO.TRSP_SO_SEQ = I_TRSP_SO_SEQ
         AND SO.BKG_NO = D.BKG_NO(+)
         AND SO.EQ_NO = D.CNTR_NO(+);
    END;
  END IF;
  <<goto_result>>
  NULL;
  IF I_WGT_UNIT_CD = 'KGS' THEN
      O_VGM_WEIGHT :=  NVL(V_VGM_KGS_WGT, 0);
      O_TARE_WEIGHT := NVL(T_TARE_KGS_WEIGHT, 0);
      O_NET_WEIGHT  := ROUND(TRS_COMMON_PKG.GET_CONV_WGT_TO_KGS_FNC('LBS', O_NET_WEIGHT), 4);
  ELSE
      O_VGM_WEIGHT :=   NVL(V_VGM_LBS_WGT, 0);
      O_TARE_WEIGHT :=  NVL(T_TARE_LBS_WEIGHT, 0);
      O_NET_WEIGHT  := ROUND(O_NET_WEIGHT, 4);
  END IF;
   O_GROSS_WEIGHT := ROUND(NVL(O_NET_WEIGHT, 0) + NVL(O_TARE_WEIGHT, 0), 4);
  RETURN(TO_CHAR(NVL(O_NET_WEIGHT, 0), '999999999999990.990') || '|' || TO_CHAR(NVL(O_TARE_WEIGHT, 0), '999999999999990.990') || '|' || TO_CHAR(NVL(O_GROSS_WEIGHT, 0), '999999999999990.990')
  || '|' || TO_CHAR(NVL(O_VGM_WEIGHT, 0), '999999999999990.990')
  );
END TRS_GET_COM_SO_RAIL_WGT_FNC;
