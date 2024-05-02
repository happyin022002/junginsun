CREATE OR REPLACE PROCEDURE OPUSADM."PRD_SET_ACT_DWTIME_PRC"
(       
        IN_PCTL_NO          IN VARCHAR2,
        IN_BND_CD           IN VARCHAR2,
        IN_CMMT_YN          IN VARCHAR2,        
        IN_USR_ID           IN VARCHAR2,
        OUT_RESULT          OUT VARCHAR2
) authid current_user
IS

/******************************************************************************

******************************************************************************/ 

--TYPE DEF---------------------------------------------------------
TYPE ROUT_RD IS RECORD 
(
    R_SEQ         VARCHAR2(3),
    R_NODE1       VARCHAR2(10),
    R_NODE2       VARCHAR2(10),
    R_NODE_KIND   VARCHAR2(2),
    R_OI_BIND_CD  VARCHAR2(3),
    R_TRS_MODE    VARCHAR2(3),      
    R_TIME_O      DATE,
    R_TIME_D      DATE,
    R_DWTZ_TIME   VARCHAR2(9),     
    R_TZ_TIME     VARCHAR2(10)
);
TYPE ROUT_TBL IS TABLE OF ROUT_RD INDEX BY BINARY_INTEGER;

--VARIABLE DECLEAR---------------------------------------------------------
routTbl             ROUT_TBL;
dCnt                NUMBER := 0;
sDate               DATE;
idx                 BINARY_INTEGER := 0;
rtStr               VARCHAR2(70) := NULL;
V_APL_GMT           VARCHAR2(1) := 'N';
V_CNTR_TPSZ         VARCHAR2(30) := NULL;

AG_PCTL_NO          VARCHAR2(20) := NULL;
AG_ACT_GRP_SEQ      NUMBER := 0;
AG_ACT_GRP_TP_CD    VARCHAR2(4) := NULL;
AG_IO_BND_CD        VARCHAR2(1) := NULL;
AG_NOD_CD           VARCHAR2(7) := NULL;
AG_PLN_DT           DATE;
AG_PLN_DT_NEW       DATE;
--CURSOR---------------------------------------------------------
/* GET PC DETAIL INFO */
CURSOR GET_PC_DTL_DATA(E_PCTL_NO VARCHAR2,E_BND_CD VARCHAR2, V_CNTR_TPSZ VARCHAR2) IS
    SELECT 
    D.PCTL_SEQ,
    D.ORG_NOD_CD,
    D.DEST_NOD_CD,
    D.NOD_LNK_DIV_CD,
    D.PCTL_IO_BND_CD,
    D.TRSP_MOD_CD,
    D.ARR_ST_DT,
    D.DEP_FSH_DT,
    (CASE
        WHEN NOD_LNK_DIV_CD = 'L' THEN TZ_DWLL_TM_HRS
        WHEN NOD_LNK_DIV_CD = 'N' THEN
            (CASE
                WHEN D.ORG_NOD_TP_CD = 'Z' THEN
                    (SELECT CGO_HNDL_TM_HRS FROM MDM_ZONE WHERE ZN_CD = D.ORG_NOD_CD)
                WHEN D.MTY_YD_FLG = 'Y' THEN 0
                ELSE
                    (SELECT DECODE(NVL(PRM_CUST_FLG, 'N'), 'Y', DECODE(SIGN(INSTR(V_CNTR_TPSZ,'R')),1,RF_MIN_DWLL_HRS,DRY_MIN_DWLL_HRS),
                                    DECODE(SIGN(INSTR(V_CNTR_TPSZ,'R')),1,NVL(RF_AVG_DWLL_HRS,0),NVL(DRY_AVG_DWLL_HRS,0))) 
                     FROM MDM_YARD WHERE YD_CD = D.ORG_NOD_CD )
            END)
    END)
    TZ_DWLL_TM_HRS  
    FROM PRD_PROD_CTL_MST M,
    PRD_PROD_CTL_ROUT_DTL D
    WHERE   M.PCTL_NO = D.PCTL_NO
    AND     D.PCTL_NO = E_PCTL_NO
    AND     D.PCTL_IO_BND_CD = E_BND_CD
    ORDER BY D.PCTL_NO,D.PCTL_SEQ ASC
    ;
/* GET STANDARD DATE (POD DISCHARGING)  */
CURSOR GET_STAND_DATE(E_PCTL_NO VARCHAR2,BND_CD VARCHAR2) IS
    SELECT DECODE(BND_CD,'I',DEP_FSH_DT,'O',ARR_ST_DT) FROM PRD_PROD_CTL_ROUT_DTL D
    WHERE   PCTL_NO = E_PCTL_NO
    AND     PCTL_IO_BND_CD = 'T'
    AND     PCTL_SEQ = (SELECT DECODE(BND_CD,'I',MAX(PCTL_SEQ),'O',MIN(PCTL_SEQ)) FROM PRD_PROD_CTL_ROUT_DTL WHERE PCTL_NO=D.PCTL_NO AND PCTL_IO_BND_CD='T')
    ;    
/* GET CNTR TP/SZ FOR DWELL TIME OPTION(DRY/REFER)  */
CURSOR GET_CNTR_TPSZ(E_PCTL_NO VARCHAR2) IS
    SELECT
    MAX(SYS_CONNECT_BY_PATH(TP,'-') )
    FROM
    (
        SELECT
        PCTL_NO,
        ROWNUM ORD,
        SUBSTR(CNTR_TPSZ_CD,1,1) TP 
        FROM PRD_PROD_CTL_QTY Q
        WHERE PCTL_NO = E_PCTL_NO
    ) Q
    START WITH ORD = 1 CONNECT BY PRIOR ORD = ORD - 1 AND PRIOR PCTL_NO = PCTL_NO    
    ;
/* CORRECT PRD_PROD_CTL_ACT_GRP_DTL  N1ST_NOD_PLN_DT */    
CURSOR CORRECT_ACT_GRP_PLN(E_PCTL_NO VARCHAR2,BND_CD VARCHAR2) IS
    SELECT
    G.PCTL_NO,G.COST_ACT_GRP_SEQ,G.COST_ACT_GRP_TP_CD,G.PCTL_IO_BND_CD,G.N1ST_NOD_CD,G.N1ST_NOD_PLN_DT,
    D.ARR_ST_DT N1ST_NOD_PLN_DT_NEW
    FROM
    (
        SELECT
        PCTL_NO,COST_ACT_GRP_SEQ,COST_ACT_GRP_TP_CD,PCTL_IO_BND_CD,N1ST_NOD_CD,N1ST_NOD_PLN_DT,
        RANK() OVER(PARTITION BY PCTL_NO,N1ST_NOD_CD,COST_ACT_GRP_TP_CD ORDER BY PCTL_NO,COST_ACT_GRP_SEQ) RNK
        FROM
        PRD_PROD_CTL_ACT_GRP_DTL 
        WHERE   PCTL_NO = E_PCTL_NO
        AND     PCTL_IO_BND_CD = BND_CD
    ) G,
    (
        SELECT
        PCTL_NO,PCTL_SEQ,ORG_NOD_CD,NOD_LNK_DIV_CD,PCTL_IO_BND_CD,ARR_ST_DT,
        RANK() OVER(PARTITION BY PCTL_NO,ORG_NOD_CD,NOD_LNK_DIV_CD ORDER BY PCTL_NO,PCTL_SEQ) RNK
        FROM
        PRD_PROD_CTL_ROUT_DTL 
        WHERE   PCTL_NO = E_PCTL_NO
        AND     PCTL_IO_BND_CD = BND_CD
    ) D
    WHERE   G.N1ST_NOD_CD = D.ORG_NOD_CD
    AND     G.COST_ACT_GRP_TP_CD = D.NOD_LNK_DIV_CD
    AND     G.RNK = D.RNK
    ORDER BY PCTL_NO,COST_ACT_GRP_SEQ
    ;
/*********************************************************************************************************/    
BEGIN
    OUT_RESULT          := 'SUCCESS';
    
    DBMS_OUTPUT.ENABLE;
    --DBMS_OUTPUT.DISABLE;
    
    --ACT#1. PC DETAIL ???? ？?？ ???？? ?？?
    OPEN GET_CNTR_TPSZ(IN_PCTL_NO);
    FETCH GET_CNTR_TPSZ INTO V_CNTR_TPSZ;
    
    FOR DTL_INFO IN GET_PC_DTL_DATA(IN_PCTL_NO,IN_BND_CD,V_CNTR_TPSZ) LOOP
        dCnt := dCnt + 1;
        routTbl(dCnt).R_SEQ         :=  DTL_INFO.PCTL_SEQ;
        routTbl(dCnt).R_NODE1       :=  DTL_INFO.ORG_NOD_CD;
        routTbl(dCnt).R_NODE2       :=  DTL_INFO.DEST_NOD_CD;
        routTbl(dCnt).R_NODE_KIND   :=  DTL_INFO.NOD_LNK_DIV_CD;
        routTbl(dCnt).R_OI_BIND_CD  :=  DTL_INFO.PCTL_IO_BND_CD;
        routTbl(dCnt).R_TRS_MODE    :=  DTL_INFO.TRSP_MOD_CD;
        routTbl(dCnt).R_TIME_O      :=  DTL_INFO.ARR_ST_DT;
        routTbl(dCnt).R_TIME_D      :=  DTL_INFO.DEP_FSH_DT;
        routTbl(dCnt).R_DWTZ_TIME   :=  DTL_INFO.TZ_DWLL_TM_HRS;         
    END LOOP;    -- ACT#1 END
    
    --ACT#2. Actual Milestone ????
    OPEN GET_STAND_DATE(IN_PCTL_NO,IN_BND_CD);
    FETCH GET_STAND_DATE INTO sDate;   
    routTbl(1).R_TIME_O := sDate;
    routTbl(1).R_TIME_D := routTbl(1).R_TIME_O + TO_NUMBER(routTbl(1).R_DWTZ_TIME)/24;
    
    FOR idx IN 2..(routTbl.COUNT) LOOP
        IF(routTbl(idx).R_NODE_KIND='N') THEN       --node
            routTbl(idx).R_TIME_O := routTbl(idx-1).R_TIME_D; 
            routTbl(idx).R_TIME_D := NULL;  
        ELSIF(routTbl(idx).R_NODE_KIND='L') THEN 
            IF(routTbl(idx).R_TRS_MODE = 'RD') THEN
                rtStr := NULL;
--                rtStr := PRD_GET_RAIL_SKD_FNC(TO_CHAR(routTbl(idx-1).R_TIME_O,'yyyy/mm/dd hh24:mi:ss'),
--                                    routTbl(idx).R_NODE1,routTbl(idx).R_NODE2,routTbl(idx-1).R_DWTZ_TIME,'N',V_APL_GMT);
--                IF rtStr IS NOT NULL THEN
--                    routTbl(idx).R_TIME_O := TO_DATE(SUBSTR(rtStr,1,14),'yyyy/mm/dd hh24:mi:ss');
--                    routTbl(idx).R_TIME_D := TO_DATE(SUBSTR(rtStr,15,14),'yyyy/mm/dd hh24:mi:ss');   
--                ELSE
                routTbl(idx).R_TIME_O := routTbl(idx-1).R_TIME_O + TO_NUMBER(routTbl(idx-1).R_DWTZ_TIME)/24;  
                routTbl(idx).R_TIME_D := routTbl(idx).R_TIME_O + TO_NUMBER(routTbl(idx).R_DWTZ_TIME)/24;                     
--                END IF;
            ELSE
                routTbl(idx).R_TIME_O := routTbl(idx-1).R_TIME_O + TO_NUMBER(routTbl(idx-1).R_DWTZ_TIME)/24;  
                routTbl(idx).R_TIME_D := routTbl(idx).R_TIME_O + TO_NUMBER(routTbl(idx).R_DWTZ_TIME)/24;                       
            END IF; 
            routTbl(idx-1).R_TIME_D := routTbl(idx).R_TIME_O;
        END IF;        
    END LOOP;
    
    --ACT#3. ?????? T/T ??？?？ETAIL UPDATE
    FOR idx IN 1..(routTbl.count) LOOP 
        routTbl(idx).R_TZ_TIME := NVL(TO_CHAR(TRUNC((routTbl(idx).R_TIME_D - routTbl(idx).R_TIME_O) * 24)),'0');
        
        ----ARR_ST_DT,DEP_FSH_DT,TZ_DWLL_TM_HRS,UPD_USR_ID,UPD_DT
        UPDATE PRD_PROD_CTL_ROUT_DTL D
        SET
        ARR_ST_DT       = routTbl(idx).R_TIME_O,
        DEP_FSH_DT      = routTbl(idx).R_TIME_D,
        TZ_DWLL_TM_HRS  = routTbl(idx).R_TZ_TIME,
        UPD_USR_ID      = IN_USR_ID,
        UPD_DT          = SYSDATE
        WHERE   PCTL_NO = IN_PCTL_NO
        AND     PCTL_SEQ = routTbl(idx).R_SEQ;        
    END LOOP;
    
    --ACT#4. PC MAST T/T UPDATE
    UPDATE PRD_PROD_CTL_MST M
    SET
    TTL_TZTM_HRS = (SELECT ROUND((MAX(ARR_ST_DT) - MIN(ARR_ST_DT)) * 24) FROM PRD_PROD_CTL_ROUT_DTL
                    WHERE PCTL_NO = M.PCTL_NO)
    WHERE PCTL_NO = IN_PCTL_NO
    ;
    
    --ACT#5. Activity Group N1ST_PLN_DT Update
    FOR V_INFO IN CORRECT_ACT_GRP_PLN(IN_PCTL_NO,IN_BND_CD) LOOP
        AG_PCTL_NO          := V_INFO.PCTL_NO;
        AG_ACT_GRP_SEQ      := V_INFO.COST_ACT_GRP_SEQ;
        AG_ACT_GRP_TP_CD    := V_INFO.COST_ACT_GRP_TP_CD;
        AG_IO_BND_CD        := V_INFO.PCTL_IO_BND_CD;
        AG_NOD_CD           := V_INFO.N1ST_NOD_CD;
        AG_PLN_DT           := V_INFO.N1ST_NOD_PLN_DT;
        AG_PLN_DT_NEW       := V_INFO.N1ST_NOD_PLN_DT_NEW;
        
        UPDATE PRD_PROD_CTL_ACT_GRP_DTL D
        SET
        N1ST_NOD_PLN_DT = AG_PLN_DT_NEW
        WHERE   PCTL_NO = AG_PCTL_NO
        AND     COST_ACT_GRP_SEQ = AG_ACT_GRP_SEQ
        AND     COST_ACT_GRP_TP_CD = AG_ACT_GRP_TP_CD
        AND     PCTL_IO_BND_CD = AG_IO_BND_CD
        AND     N1ST_NOD_CD = AG_NOD_CD
        ;        
    END LOOP; 
    
    
    
    IF IN_CMMT_YN = 'Y' THEN
        COMMIT;
    END IF;
    
    
    EXCEPTION
        WHEN OTHERS
        THEN  OUT_RESULT := 'FAIL'; 
    
END PRD_SET_ACT_DWTIME_PRC;
/

