CREATE OR REPLACE PACKAGE TRS_INLAND_COST_CALC_PKG
AUTHID CURRENT_USER
IS 

/******************************************************************************
   Name         :   GET_EUR_INLNAD_COST
   Purpose      :   EUROPE INLNAD COST CALCULATE
   Table        :   
   Ver          :   1.0
   Date         :   2012.07.12
******************************************************************************/
FUNCTION GET_EUR_USD_COST
(
    P_IO_BND_CD  IN VARCHAR2,
    P_FM_NOD_CD  IN VARCHAR2,
    P_DOR_NOD_CD IN VARCHAR2,
    P_TO_NOD_CD  IN VARCHAR2,
    P_RCV_DE_TERM_CD IN VARCHAR2,
    P_TRSP_CRR_MOD_CD IN VARCHAR2,
    P_EQ_TPSZ_CD IN VARCHAR2,
    P_RT_APLY_DT IN DATE
)
RETURN VARCHAR2;

/******************************************************************************
   Name         :   GET_MERGE_BKG_LIST
   Purpose      :   EUROPE INLNAD COST CALCULATE
   Table        :   
   Ver          :   1.0
   Date         :   2012.07.12
******************************************************************************/
FUNCTION GET_MERGE_BKG_LIST
(
    P_BKG_NO  IN VARCHAR2
)
RETURN VARCHAR2;

/******************************************************************************
   Name         :   GET_BKG_MERGE
   Purpose      :   BKG REV RATE CALCULATE
   Table        :   
   Ver          :   1.0
   Date         :   2012.07.12
******************************************************************************/
FUNCTION GET_BKG_REV_AMT
(
    P_BKG_NO      IN VARCHAR2
   ,P_BKG_MRG_FLG IN VARCHAR2
   ,P_RT_APLY_DT  IN DATE
   ,P_SVC_SCP_CD  IN VARCHAR2
)
RETURN NUMBER;

END TRS_INLAND_COST_CALC_PKG;
/
CREATE OR REPLACE PACKAGE BODY TRS_INLAND_COST_CALC_PKG 
IS 

/******************************************************************************
   Name         :   GET_EUR_INLNAD_COST
   Purpose      :   EUROPE INLNAD COST CALCULATE
   Table        :   
   Ver          :   1.0
   Date         :   2012.07.12
******************************************************************************/
FUNCTION GET_EUR_USD_COST
(
    P_IO_BND_CD  IN VARCHAR2,
    P_FM_NOD_CD  IN VARCHAR2,
    P_DOR_NOD_CD IN VARCHAR2,
    P_TO_NOD_CD  IN VARCHAR2,
    P_RCV_DE_TERM_CD IN VARCHAR2,
    P_TRSP_CRR_MOD_CD IN VARCHAR2,
    P_EQ_TPSZ_CD IN VARCHAR2,
    P_RT_APLY_DT IN DATE
)
RETURN VARCHAR2
IS
r_result VARCHAR2(100);
BEGIN
    BEGIN
        SELECT COST_USD_AMT
          INTO r_result
          FROM (
                SELECT 'Y'||'|'||
                       TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A2.CURR_CD, DECODE(P_EQ_TPSZ_CD, 'D2', A3.INLND_20FT_TTL_AMT, A3.INLND_40FT_TTL_AMT), TO_CHAR(P_RT_APLY_DT,'YYYYMM') ) ||'|'||
                       TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A2.CURR_CD, DECODE(P_EQ_TPSZ_CD, 'D2', A3.TRSP_20FT_COST_AMT, A3.TRSP_40FT_COST_AMT), TO_CHAR(P_RT_APLY_DT,'YYYYMM') ) COST_USD_AMT
                  FROM TRS_INLND_COST_TRF_HDR A2
                      ,TRS_INLND_COST_TRF A3
                 WHERE 1=1
                   AND A3.RCV_DE_TERM_CD = P_RCV_DE_TERM_CD
                   AND A2.IO_BND_CD      = P_IO_BND_CD
                   AND SUBSTR(DECODE(P_IO_BND_CD, 'I', A3.PORT_NOD_CD, 'O', A3.LOC_NOD_CD),1,5) = SUBSTR(DECODE(P_IO_BND_CD, 'I', P_FM_NOD_CD, 'O', NVL(P_DOR_NOD_CD, P_FM_NOD_CD)),1,5)
                   AND SUBSTR(DECODE(P_IO_BND_CD, 'I', A3.LOC_NOD_CD, 'O', A3.PORT_NOD_CD),1,5) = SUBSTR(DECODE(P_IO_BND_CD, 'I', NVL(P_DOR_NOD_CD, P_TO_NOD_CD), 'O', P_TO_NOD_CD),1,5)
                   AND A2.COST_TRF_NO     = A3.COST_TRF_NO
                   AND A2.COST_TRF_STS_CD = 'C'
                   AND P_RT_APLY_DT BETWEEN A2.EFF_FM_DT AND A2.EFF_TO_DT
                   AND A3.TRSP_CRR_MOD_CD = P_TRSP_CRR_MOD_CD
                 ORDER BY DECODE(P_EQ_TPSZ_CD, 'D2', A3.INLND_20FT_TTL_AMT, A3.INLND_40FT_TTL_AMT) ASC
               )
         WHERE ROWNUM = 1
        ;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
			r_result := 'N|0|0';
			RETURN r_result; 
		WHEN OTHERS THEN
			r_result := 'N|0|0';
			RETURN r_result;
    END;
    RETURN r_result;
END;

/******************************************************************************
   Name         :   GET_EUR_INLNAD_COST
   Purpose      :   EUROPE INLNAD COST CALCULATE
   Table        :   
   Ver          :   1.0
   Date         :   2012.07.12
******************************************************************************/
FUNCTION GET_MERGE_BKG_LIST
(
    P_BKG_NO  IN VARCHAR2
)
RETURN VARCHAR2
IS
v_bkg_no_list VARCHAR2(200);
v_old_tpsz    VARCHAR2(100);
v_qty_sum     NUMBER(5,3) := 0;
v_tpsz_flg    VARCHAR2(1) := 'N';

v_i           NUMBER(10);
r_result      VARCHAR2(1000);

CURSOR CUR_DATA (i_bkg_no VARCHAR2) IS
SELECT BKG_NO, CNTR_TPSZ_CD, OP_CNTR_QTY
  FROM BKG_QUANTITY X
 WHERE BKG_NO IN (
    SELECT FM_BKG_NO BKG_NO --입력 BKG이 SPLIT된 BKG일 때 상위 BKG
    FROM   BKG_BOOKING
    WHERE  BKG_NO = i_bkg_no
    AND    BKG_CRE_TP_CD = 'S'
    UNION 
    SELECT BKG_NO --입력 BKG
    FROM   BKG_BOOKING
    WHERE  BKG_NO = i_bkg_no
    UNION
    SELECT BKG_NO --입력 BKG으로부터 SPLIT된 BKG
    FROM   BKG_BOOKING
    WHERE  FM_BKG_NO = i_bkg_no
    AND    BKG_CRE_TP_CD = 'S'
    UNION
    SELECT BKG_NO --입력 bkg과 같은 from bkg을 가지는 bkg
    FROM   bkg_booking
    WHERE  FM_BKG_NO IN (SELECT FM_BKG_NO
                           FROM BKG_BOOKING
                          WHERE BKG_NO = i_bkg_no
                            AND BKG_CRE_TP_CD = 'S')
    AND    BKG_CRE_TP_CD = 'S'
    UNION
    SELECT /*+ INDEX(BKG_BOOKING XPKBKG_BOOKING) */  
           BKG_NO --empty bkg을 위한 추가 처리
    FROM   BKG_BOOKING
    WHERE  BKG_CGO_TP_CD = 'P'
    AND    BKG_NO LIKE i_bkg_no||'%'
    AND    BKG_NO <> i_bkg_no	
    AND    LENGTH(i_bkg_no) = 11
    UNION
    SELECT /*+ INDEX(BKG_BOOKING XPKBKG_BOOKING) */  
           BKG_NO --empty bkg을 위한 추가 처리
    FROM   BKG_BOOKING
    WHERE  BKG_CGO_TP_CD = 'P'
    AND    BKG_NO LIKE substr(i_bkg_no, 1, 11)||'%'
    AND    BKG_NO <> i_bkg_no	
    AND    LENGTH(i_bkg_no) = 13
)
AND OP_CNTR_QTY < 1
;

BEGIN
    v_i := 0;
    FOR CUR_BKG IN CUR_DATA(P_BKG_NO) LOOP
        v_i := v_i + 1;
        v_bkg_no_list := v_bkg_no_list ||','||CUR_BKG.BKG_NO;
        IF (v_i > 1) AND (v_old_tpsz <> CUR_BKG.CNTR_TPSZ_CD) THEN -- SPLIT된 BKG의 CNTR이 모두 같은 TYPE/SIZE인지 체크한다.
            v_tpsz_flg := 'Y';
        END IF;
        v_old_tpsz    := CUR_BKG.CNTR_TPSZ_CD;
        
        v_qty_sum := v_qty_sum + CUR_BKG.OP_CNTR_QTY;
    END LOOP;
    
    IF v_tpsz_flg = 'N' AND v_qty_sum = 1 THEN -- TP/SZ가 동일하고 Volume의 총합이 1일 경우만 MERGE한다.
        r_result := SUBSTR(v_bkg_no_list, 2);
    END IF;

    RETURN r_result;
END;

/******************************************************************************
   Name         :   GET_BKG_MERGE
   Purpose      :   BKG REV RATE CALCULATE
   Table        :   
   Ver          :   1.0
   Date         :   2012.07.12
******************************************************************************/
FUNCTION GET_BKG_REV_AMT
(
    P_BKG_NO      IN VARCHAR2
   ,P_BKG_MRG_FLG IN VARCHAR2
   ,P_RT_APLY_DT  IN DATE
   ,P_SVC_SCP_CD  IN VARCHAR2
)
RETURN NUMBER
IS
r_result      NUMBER(18,3);

BEGIN
    IF P_BKG_MRG_FLG = 'Y' THEN
        SELECT  SUM(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(X.CURR_CD, X.CHG_AMT, TO_CHAR(P_RT_APLY_DT,'YYYYMM')))
        INTO    r_result
        FROM    BKG_CHG_RT X
        WHERE   X.BKG_NO IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(P_BKG_NO, ',')))
        AND     X.CHG_CD = DECODE(P_SVC_SCP_CD, 'AEW', 'DIH', 'AEE', 'OIH')
        ;
    ELSE
        SELECT  SUM(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(X.CURR_CD, X.CHG_AMT, TO_CHAR(P_RT_APLY_DT,'YYYYMM')))
        INTO    r_result
        FROM    BKG_CHG_RT X
        WHERE   X.BKG_NO = P_BKG_NO
        AND     X.CHG_CD = DECODE(P_SVC_SCP_CD, 'AEW', 'DIH', 'AEE', 'OIH')
        ;
    END IF;

    RETURN r_result;
END;

END TRS_INLAND_COST_CALC_PKG;
