CREATE OR REPLACE PACKAGE AOC_TRF_CALC_PKG
AUTHID CURRENT_USER
IS 

/******************************************************************************
   Name         :   GET_USD_COST
   Purpose      :   INLNAD COST CALCULATE
   Table        :   
   Ver          :   1.0
   Date         :   2012.07.12
******************************************************************************/
FUNCTION GET_USD_COST
(
    P_RHQ_CD  IN VARCHAR2,
    P_IO_BND_CD  IN VARCHAR2,
    P_FM_NOD_CD  IN VARCHAR2,
    P_DOR_NOD_CD IN VARCHAR2,
    P_TO_NOD_CD  IN VARCHAR2,
    P_RCV_DE_TERM_CD IN VARCHAR2,
    P_TRSP_CRR_MOD_CD IN VARCHAR2,
    P_EQ_TPSZ_CD IN VARCHAR2,
    P_RT_APLY_DT IN DATE,
    P_COST_TRF_NO IN VARCHAR2
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
    P_RHQ_CD      IN VARCHAR2
   ,P_BKG_NO      IN VARCHAR2
   ,P_BKG_MRG_FLG IN VARCHAR2
   ,P_RT_APLY_DT  IN DATE
   ,P_BND_CD      IN VARCHAR2
)
RETURN NUMBER;

 /******************************************************************** 
 * -- Author  : JEONG SANG-KI 
 * -- Created : DEC 13, 2006 
 * -- Table   : GL_MON_XCH_RT 
 * -- Purpose : LOCAL CURRENCY >> USD  
 **********************************************************************/ 
  FUNCTION GET_CONVERSION_USD_AMT_FNC  
  ( 
           p_local_curr_cd  IN VARCHAR2 
      ,    p_local_amt      IN NUMBER 
      ,    p_basis_dt       IN VARCHAR2 default TO_CHAR(SYSDATE, 'YYYYMM') 
  ) RETURN NUMBER;

/******************************************************************** 
* -- Author  : Jong Hyek Choi
* -- Created : Jan 26, 2012
* -- Table   :  
* -- Purpose : 입력된 금액을 FROM Currency에서 TO Currency로 변경한다.
**********************************************************************/   
  FUNCTION GET_CONVERSION_AMT_FNC  
  ( 
           p_from_curr_cd  IN VARCHAR2 
      ,    p_to_curr_cd    IN VARCHAR2 
      ,    p_original_amt  IN NUMBER 
      ,    p_basis_dt      IN VARCHAR2 default TO_CHAR(SYSDATE, 'YYYYMM')  
  ) RETURN NUMBER; 

/******************************************************************** 
* -- Author  : Jong Hyek Choi
* -- Created : Jan 26, 2012
* -- Table   :  
* -- Purpose : 입력 OFFICE의 RHQ OFFICE를 가져온다.
**********************************************************************/   
  FUNCTION GET_RHQ_OFC_CD
  (
           V_OFC_CD in VARCHAR2 
  )
  RETURN VARCHAR2
  ;

END AOC_TRF_CALC_PKG;


CREATE OR REPLACE PACKAGE BODY AOC_TRF_CALC_PKG
IS 

/******************************************************************************
   Name         :   GET_USD_COST
   Purpose      :   INLNAD COST CALCULATE
   Table        :   
   Ver          :   1.0
   Date         :   2012.07.12
******************************************************************************/
FUNCTION GET_USD_COST
(
    P_RHQ_CD  IN VARCHAR2,
    P_IO_BND_CD  IN VARCHAR2,
    P_FM_NOD_CD  IN VARCHAR2,
    P_DOR_NOD_CD IN VARCHAR2,
    P_TO_NOD_CD  IN VARCHAR2,
    P_RCV_DE_TERM_CD IN VARCHAR2,
    P_TRSP_CRR_MOD_CD IN VARCHAR2,
    P_EQ_TPSZ_CD IN VARCHAR2,
    P_RT_APLY_DT IN DATE,
    P_COST_TRF_NO IN VARCHAR2
)
RETURN VARCHAR2
IS
r_result VARCHAR2(100);
BEGIN
    BEGIN

    IF P_RHQ_CD = 'HAMRU' THEN
    
        SELECT COST_USD_AMT
          INTO r_result
          FROM (
                SELECT 'Y'||'|'||
                       GET_CONVERSION_USD_AMT_FNC(A3.CURR_CD, DECODE(P_EQ_TPSZ_CD, 'D2', A3.INLND_20FT_TTL_AMT, A3.INLND_40FT_TTL_AMT), TO_CHAR(P_RT_APLY_DT,'YYYYMM') ) ||'|'||
                       GET_CONVERSION_USD_AMT_FNC(A3.CURR_CD, DECODE(P_EQ_TPSZ_CD, 'D2', A3.TRSP_20FT_TTL_COST_AMT, A3.TRSP_40FT_TTL_COST_AMT), TO_CHAR(P_RT_APLY_DT,'YYYYMM') ) COST_USD_AMT
                  FROM AOC_EUR_INLND_TRF_HDR A2
                      ,AOC_EUR_INLND_TRF_DTL A3
                 WHERE 1=1
                   AND A2.COST_TRF_NO = P_COST_TRF_NO
                   AND A3.RCV_DE_TERM_CD = P_RCV_DE_TERM_CD
                   AND A2.IO_BND_CD      = P_IO_BND_CD
                   AND SUBSTR(DECODE(P_IO_BND_CD, 'I', A3.PORT_NOD_CD, 'O', A3.LOC_NOD_CD),1,5) = SUBSTR(DECODE(P_IO_BND_CD, 'I', P_FM_NOD_CD, 'O', NVL(P_DOR_NOD_CD, P_FM_NOD_CD)),1,5)
                   AND SUBSTR(DECODE(P_IO_BND_CD, 'I', A3.LOC_NOD_CD, 'O', A3.PORT_NOD_CD),1,5) = SUBSTR(DECODE(P_IO_BND_CD, 'I', NVL(P_DOR_NOD_CD, P_TO_NOD_CD), 'O', P_TO_NOD_CD),1,5)
                   AND A2.COST_TRF_NO     = A3.COST_TRF_NO
                   AND A3.COST_SEL_ROUT_FLG = 'Y'
                 ORDER BY DECODE(P_EQ_TPSZ_CD, 'D2', A3.INLND_20FT_TTL_AMT, A3.INLND_40FT_TTL_AMT) ASC
               )
         WHERE ROWNUM = 1
        ;
        
    ELSE

        SELECT COST_USD_AMT
          INTO r_result
          FROM (
                SELECT 'Y'||'|'||
                       GET_CONVERSION_USD_AMT_FNC(A3.CURR_CD, DECODE(P_EQ_TPSZ_CD, 'D2', A3.INLND_20FT_TTL_AMT, A3.INLND_40FT_TTL_AMT), TO_CHAR(P_RT_APLY_DT,'YYYYMM') ) ||'|'||
                       GET_CONVERSION_USD_AMT_FNC(A3.CURR_CD, DECODE(P_EQ_TPSZ_CD, 'D2', A3.TRSP_20FT_TTL_COST_AMT, A3.TRSP_40FT_TTL_COST_AMT), TO_CHAR(P_RT_APLY_DT,'YYYYMM') ) COST_USD_AMT
                  FROM AOC_CHN_INLND_TRF_HDR A2
                      ,AOC_CHN_INLND_TRF_DTL A3
                 WHERE 1=1
                   AND A2.COST_TRF_NO = P_COST_TRF_NO
                   AND A3.RCV_DE_TERM_CD = P_RCV_DE_TERM_CD
                   AND A2.IO_BND_CD      = P_IO_BND_CD
                   AND SUBSTR(DECODE(P_IO_BND_CD, 'I', A3.PORT_NOD_CD, 'O', A3.LOC_NOD_CD),1,5) = SUBSTR(DECODE(P_IO_BND_CD, 'I', P_FM_NOD_CD, 'O', NVL(P_DOR_NOD_CD, P_FM_NOD_CD)),1,5)
                   AND SUBSTR(DECODE(P_IO_BND_CD, 'I', A3.LOC_NOD_CD, 'O', A3.PORT_NOD_CD),1,5) = SUBSTR(DECODE(P_IO_BND_CD, 'I', NVL(P_DOR_NOD_CD, P_TO_NOD_CD), 'O', P_TO_NOD_CD),1,5)
                   AND A2.COST_TRF_NO     = A3.COST_TRF_NO
                   AND A3.COST_SEL_ROUT_FLG = 'Y'
                 ORDER BY DECODE(P_EQ_TPSZ_CD, 'D2', A3.INLND_20FT_TTL_AMT, A3.INLND_40FT_TTL_AMT) ASC
               )
         WHERE ROWNUM = 1
        ;    
    
    END IF;
    
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
   Revision History : 
   2013.07.16 서미진 [CHM-201325606] 1. WJC 단독 적용
									 2. WHC, MSC의 Exist 조건에 Bound 적용 
******************************************************************************/
FUNCTION GET_BKG_REV_AMT
(
    P_RHQ_CD      IN VARCHAR2
   ,P_BKG_NO      IN VARCHAR2
   ,P_BKG_MRG_FLG IN VARCHAR2
   ,P_RT_APLY_DT  IN DATE
   ,P_BND_CD      IN VARCHAR2
)
RETURN NUMBER
IS
r_result      NUMBER(18,3);

BEGIN

    IF P_RHQ_CD = 'HAMRU' THEN
    
        IF P_BKG_MRG_FLG = 'Y' THEN
            SELECT  SUM(GET_CONVERSION_USD_AMT_FNC(J.CURR_CD, NVL(J.CHG_AMT,0), TO_CHAR(P_RT_APLY_DT,'YYYYMM')))
            INTO    r_result
            FROM (
                SELECT  X1.CURR_CD , X1.CHG_AMT 
                FROM    BKG_CHG_RT X1
                WHERE   X1.BKG_NO IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(P_BKG_NO, ',')))
                AND     DECODE(X1.CHG_CD,'OIH','O','DIH','I','X') = P_BND_CD
                
                UNION ALL
                SELECT  X2.CURR_CD , X2.CHG_AMT 
                FROM    BKG_CHG_RT X2
                WHERE   X2.BKG_NO IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(P_BKG_NO, ',')))
                AND     DECODE(X2.CHG_CD,'OAR','O','DAR','I','X') = P_BND_CD
                AND     NOT EXISTS (SELECT 'X' FROM BKG_CHG_RT XX 
                								WHERE X2.BKG_NO = XX.BKG_NO AND XX.CHG_CD IN ('OIH','DIH'))
                UNION ALL
                SELECT  X.CURR_CD , X.CHG_AMT 
                FROM    BKG_CHG_RT X
                WHERE   X.BKG_NO IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(P_BKG_NO, ',')))
                AND DECODE(P_BND_CD,'O','P','I','C') = X.FRT_TERM_CD
                AND X.CHG_CD = 'IHC'
                
                UNION ALL
                SELECT  X.CURR_CD , X.CHG_AMT 
                FROM    BKG_CHG_RT X
                WHERE   X.BKG_NO IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(P_BKG_NO, ',')))
                AND DECODE(P_BND_CD,'O','P','I','C') = X.FRT_TERM_CD
                AND X.CHG_CD = 'WJC'
                
                UNION ALL
                SELECT  X3.CURR_CD , X3.CHG_AMT 
                FROM    BKG_CHG_RT X3
                      , AOC_SVC_SCP S
                      , BKG_BOOKING B            
                WHERE   X3.BKG_NO IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(P_BKG_NO, ',')))
                AND X3.BKG_NO = B.BKG_NO
                AND S.RHQ_CD = P_RHQ_CD
                AND S.SVC_SCP_CD = B.SVC_SCP_CD
                AND S.TRSP_BND_CD = P_BND_CD
                AND DECODE(P_BND_CD,'O','P','I','C') = X3.FRT_TERM_CD
                AND X3.CHG_CD IN ('WHC','MSC')
                AND ( EXISTS (SELECT 'X' FROM BKG_CHG_RT C WHERE C.BKG_NO = X3.BKG_NO 
                                        AND C.CHG_CD IN ('OIH','DIH','OAR','DAR')
                                        AND DECODE(C.CHG_CD,'OIH','O','DIH','I','OAR','O','DAR','I') = P_BND_CD
                             )
                    OR ( EXISTS (SELECT 'X' FROM BKG_CHG_RT C WHERE C.BKG_NO = X3.BKG_NO 
                                        AND C.CHG_CD IN ('IHC','WJC')
                                        AND DECODE(P_BND_CD,'O','P','I','C') = C.FRT_TERM_CD
                            )
                       )
                    )  
            ) J
            ;
        ELSE
            SELECT  SUM(GET_CONVERSION_USD_AMT_FNC(J.CURR_CD, NVL(J.CHG_AMT,0), TO_CHAR(P_RT_APLY_DT,'YYYYMM')))
            INTO    r_result
            FROM (
                SELECT  X1.CURR_CD , X1.CHG_AMT 
                FROM    BKG_CHG_RT X1
                WHERE   X1.BKG_NO = P_BKG_NO
                AND     DECODE(X1.CHG_CD,'OIH','O','DIH','I','X') = P_BND_CD
                UNION ALL
                SELECT  X2.CURR_CD , X2.CHG_AMT 
                FROM    BKG_CHG_RT X2
                WHERE   X2.BKG_NO = P_BKG_NO
                AND     DECODE(X2.CHG_CD,'OAR','O','DAR','I','X') = P_BND_CD
                AND     NOT EXISTS (SELECT 'X' FROM BKG_CHG_RT XX 
                								WHERE X2.BKG_NO = XX.BKG_NO AND XX.CHG_CD IN ('OIH','DIH'))
                UNION ALL
                SELECT  X.CURR_CD , X.CHG_AMT 
                FROM    BKG_CHG_RT X
                WHERE   X.BKG_NO = P_BKG_NO
                AND DECODE(P_BND_CD,'O','P','I','C') = X.FRT_TERM_CD
                AND X.CHG_CD = 'IHC'	
                
                UNION ALL
                SELECT  X.CURR_CD , X.CHG_AMT 
                FROM    BKG_CHG_RT X
                WHERE   X.BKG_NO IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(P_BKG_NO, ',')))
                AND DECODE(P_BND_CD,'O','P','I','C') = X.FRT_TERM_CD
                AND X.CHG_CD = 'WJC'
                
                UNION ALL
                SELECT  X3.CURR_CD , X3.CHG_AMT 
                FROM    BKG_CHG_RT X3
                      , AOC_SVC_SCP S
                      , BKG_BOOKING B            
                WHERE   X3.BKG_NO = P_BKG_NO
                AND X3.BKG_NO = B.BKG_NO
                AND S.RHQ_CD = P_RHQ_CD
                AND S.SVC_SCP_CD = B.SVC_SCP_CD
                AND S.TRSP_BND_CD = P_BND_CD
                AND DECODE(P_BND_CD,'O','P','I','C') = X3.FRT_TERM_CD
                AND X3.CHG_CD IN ('WHC','MSC')
                AND ( EXISTS (SELECT 'X' FROM BKG_CHG_RT C WHERE C.BKG_NO = X3.BKG_NO 
                                        AND C.CHG_CD IN ('OIH','DIH','OAR','DAR')
                                        AND DECODE(C.CHG_CD,'OIH','O','DIH','I','OAR','O','DAR','I') = P_BND_CD
                             )
                    OR ( EXISTS (SELECT 'X' FROM BKG_CHG_RT C WHERE C.BKG_NO = X3.BKG_NO 
                                        AND C.CHG_CD IN ('IHC','WJC')
                                        AND DECODE(P_BND_CD,'O','P','I','C') = C.FRT_TERM_CD
                            )
                       )
                    )  
            ) J
            ;
        END IF;
        
    ELSE
    
        IF P_BKG_MRG_FLG = 'Y' THEN
            SELECT  SUM(GET_CONVERSION_USD_AMT_FNC(J.CURR_CD, NVL(J.CHG_AMT,0), TO_CHAR(P_RT_APLY_DT,'YYYYMM')))
            INTO    r_result
            FROM (
                SELECT  X1.CURR_CD , X1.CHG_AMT 
                FROM    BKG_CHG_RT X1
                WHERE   X1.BKG_NO IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(P_BKG_NO, ',')))
                AND     DECODE(X1.CHG_CD,'OIH','O','DIH','I','X') = P_BND_CD
                UNION ALL
                SELECT  X2.CURR_CD , X2.CHG_AMT 
                FROM    BKG_CHG_RT X2
                WHERE   X2.BKG_NO IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(P_BKG_NO, ',')))
                AND     DECODE(X2.CHG_CD,'OAR','O','DAR','I','X') = P_BND_CD
                AND     NOT EXISTS (SELECT 'X' FROM BKG_CHG_RT XX 
                								WHERE X2.BKG_NO = XX.BKG_NO AND XX.CHG_CD IN ('OIH','DIH'))
                UNION ALL
                SELECT  X.CURR_CD , X.CHG_AMT 
                FROM    BKG_CHG_RT X
                WHERE   X.BKG_NO IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(P_BKG_NO, ',')))
                AND DECODE(P_BND_CD,'O','P','I','C') = X.FRT_TERM_CD
                AND X.CHG_CD = 'IHC'
            ) J
            ;
        ELSE
            SELECT  SUM(GET_CONVERSION_USD_AMT_FNC(J.CURR_CD, NVL(J.CHG_AMT,0), TO_CHAR(P_RT_APLY_DT,'YYYYMM')))
            INTO    r_result
            FROM (
                SELECT  X1.CURR_CD , X1.CHG_AMT 
                FROM    BKG_CHG_RT X1
                WHERE   X1.BKG_NO = P_BKG_NO
                AND     DECODE(X1.CHG_CD,'OIH','O','DIH','I','X') = P_BND_CD
                UNION ALL
                SELECT  X2.CURR_CD , X2.CHG_AMT 
                FROM    BKG_CHG_RT X2
                WHERE   X2.BKG_NO = P_BKG_NO
                AND     DECODE(X2.CHG_CD,'OAR','O','DAR','I','X') = P_BND_CD
                AND     NOT EXISTS (SELECT 'X' FROM BKG_CHG_RT XX 
                								WHERE X2.BKG_NO = XX.BKG_NO AND XX.CHG_CD IN ('OIH','DIH'))
                UNION ALL
                SELECT  X.CURR_CD , X.CHG_AMT 
                FROM    BKG_CHG_RT X
                WHERE   X.BKG_NO = P_BKG_NO
                AND DECODE(P_BND_CD,'O','P','I','C') = X.FRT_TERM_CD
                AND X.CHG_CD = 'IHC'
            ) J
            ;
        END IF;

    END IF;
    

    RETURN r_result;
END;


  /********************************************************************   
 * -- Author  : JEONG SANG-KI   
 * -- Created : DEC 13, 2006   
 * -- Table   : GL_MON_XCH_RT   
 * -- Purpose : LOCAL CURRENCY >> USD    
 **********************************************************************/   
  FUNCTION GET_CONVERSION_USD_AMT_FNC    
  (   
           p_local_curr_cd  IN VARCHAR2   
      ,    p_local_amt      IN NUMBER   
      ,    p_basis_dt       IN VARCHAR2 default TO_CHAR(SYSDATE, 'YYYYMM')   
  ) RETURN NUMBER   
  
  IS   
    v_conv_amt NUMBER  (18,3) := 0 ;   
    v_basis_ym VARCHAR2(6)    := '';   
  BEGIN     
   
    IF p_basis_dt IS NULL OR NVL(LENGTH(p_basis_dt),0) < 6 THEN   
        v_basis_ym := TO_CHAR(SYSDATE, 'YYYYMM');   
    ELSE   
        v_basis_ym := SUBSTR(p_basis_dt, 1, 6)  ;   
    END IF;   
     
    IF p_local_amt = 0 THEN   
        v_conv_amt := 0;         
    ELSE   
       
        /* Local Currency -->> USD Currency */       
        SELECT ROUND((p_local_amt / RAT.USD_LOCL_XCH_RT), 3)   
        INTO   v_conv_amt   
        FROM   GL_MON_XCH_RT RAT   
        WHERE  RAT.CURR_CD              = UPPER(p_local_curr_cd)   
        AND    RAT.ACCT_XCH_RT_LVL      = '1'   
        AND    RAT.ACCT_XCH_RT_YRMON    = v_basis_ym   
        ;        
       
    END IF;   
     
    RETURN v_conv_amt;   
     
  EXCEPTION   
      WHEN NO_DATA_FOUND THEN    
          RETURN 0;   
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_USD_AMT_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');   
      WHEN OTHERS THEN   
          RETURN 0;   
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_USD_AMT_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
     
  END;   
  
 /********************************************************************   
 * -- Author  : JEONG SANG-KI   
 * -- Created : DEC 13, 2006   
 * -- Table   : GL_MON_XCH_RT   
 * -- Purpose : LOCAL CURRENCY >> USD    
 **********************************************************************/   
  FUNCTION GET_CONVERSION_AMT_FNC    
  (   
           p_from_curr_cd  IN VARCHAR2 
      ,    p_to_curr_cd    IN VARCHAR2 
      ,    p_original_amt  IN NUMBER 
      ,    p_basis_dt      IN VARCHAR2 default TO_CHAR(SYSDATE, 'YYYYMM')   
  ) RETURN NUMBER   
  
  IS   
    v_conv_amt NUMBER  (18,3) := 0 ;   
    v_basis_ym VARCHAR2(6)    := '';   
  BEGIN     
   
    IF p_basis_dt IS NULL OR NVL(LENGTH(p_basis_dt),0) < 6 THEN   
        v_basis_ym := TO_CHAR(SYSDATE, 'YYYYMM');   
    ELSE   
        v_basis_ym := SUBSTR(p_basis_dt, 1, 6)  ;   
    END IF;   
     
    IF p_original_amt = 0 THEN   
        v_conv_amt := 0;
    ELSIF p_from_curr_cd = p_to_curr_cd THEN
        v_conv_amt := p_original_amt;
    ELSIF p_to_curr_cd = 'USD' THEN
        /* FROM Currency -->> USD Currency */       
        SELECT ROUND((p_original_amt / RAT.USD_LOCL_XCH_RT), 3)   
        INTO   v_conv_amt   
        FROM   GL_MON_XCH_RT RAT   
        WHERE  RAT.CURR_CD              = UPPER(p_from_curr_cd)   
        AND    RAT.ACCT_XCH_RT_LVL      = '1'   
        AND    RAT.ACCT_XCH_RT_YRMON    = v_basis_ym   
        ;
    ELSE
        /* FROM Currency -->> TO Currency */       
        SELECT ROUND( (p_original_amt/FM_CUR.USD_LOCL_XCH_RT) * TO_CUR.USD_LOCL_XCH_RT, 3)           
        INTO   v_conv_amt                   
        FROM   GL_MON_XCH_RT FM_CUR
              ,GL_MON_XCH_RT TO_CUR                                        
        WHERE  1=1
        AND    FM_CUR.CURR_CD                      = p_from_curr_cd                                 
        AND    TO_CUR.CURR_CD                      = p_to_curr_cd                           
        AND    FM_CUR.ACCT_XCH_RT_LVL              = '1'                              
        AND    FM_CUR.ACCT_XCH_RT_LVL              = TO_CUR.ACCT_XCH_RT_LVL              
        AND    FM_CUR.ACCT_XCH_RT_YRMON            = TO_CUR.ACCT_XCH_RT_YRMON           
        AND    FM_CUR.ACCT_XCH_RT_YRMON            = v_basis_ym
        ;
    END IF;   
     
    RETURN v_conv_amt;   
     
  EXCEPTION   
      WHEN NO_DATA_FOUND THEN    
          RETURN 0;   
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_AMT_FNC%% <NO_DATA_FOUND> ERROR MSG = ['||SQLERRM||']');   
      WHEN OTHERS THEN   
          RETURN 0;   
          DBMS_OUTPUT.PUT_LINE('%%GET_CONVERSION_AMT_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');   
     
  END; 

/********************************************************************  
* -- Author  : Jong Hyek Choi 
* -- Created : Jan 26, 2012 
* -- Table   :   
* -- Purpose : 입력 OFFICE의 RHQ OFFICE를 가져온다. 
**********************************************************************/
FUNCTION GET_RHQ_OFC_CD 
( 
    V_OFC_CD in VARCHAR2  
) RETURN VARCHAR2   
IS  
    V_RETURN    VARCHAR2(100)             ; 
BEGIN 
     SELECT OFC_CD 
       INTO V_RETURN 
       FROM  
       ( 
           SELECT X.* 
            FROM MDM_ORGANIZATION X 
            WHERE DELT_FLG = 'N' 
            CONNECT BY PRIOR PRNT_OFC_CD = OFC_CD 
            START WITH OFC_CD IN ( 
             V_OFC_CD 
            ) 
       ) 
       WHERE OFC_TP_CD = 'HQ' 
         AND OFC_CD NOT IN ('SELDC', 'SELHO') 
        ; 
 
    RETURN V_RETURN; 
END;

END AOC_TRF_CALC_PKG;