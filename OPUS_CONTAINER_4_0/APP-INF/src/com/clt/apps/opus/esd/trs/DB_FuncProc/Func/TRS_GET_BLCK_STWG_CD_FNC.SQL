CREATE OR REPLACE FUNCTION TRS_GET_BLCK_STWG_CD_FNC(V_BKG_NO IN VARCHAR2)
RETURN VARCHAR2
AUTHID CURRENT_USER
IS
/*
  1.Name        : POONG YEON CHO
  2.Create Date : 2009-12-11
  3.Description :
      - 용도    : BLOCK STOWAGE CD 추출.
      - 파라미터: V_BKG_NO
      - 특이사항: 
  4.Revision History
*/
    V_BS_CD         VARCHAR2(4)      := ''  ;

BEGIN

/************************************************************************* 
1. BKG의 HOT DELIVERY FLAG가 설정되어 있으면 1순위
*************************************************************************/ 
    BEGIN      
        SELECT  '1'||'HOT' BS
        INTO    V_BS_CD
        FROM 
                BKG_BOOKING BK
        WHERE   1=1
          AND   BKG_NO = V_BKG_NO
          AND   NVL(BK.HOT_DE_FLG, 'N') ='Y'
        ;     
        DBMS_OUTPUT.PUT_LINE('1.V_BS_CD===>'||V_BS_CD);    
    
    EXCEPTION WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('%%TRS_GET_BLCK_STWG_CD_FNC%% 1HOT SELECT ['||SQLERRM||']');
    END;
/************************************************************************* 
2. 고가 운송물중 LANE이 일치하는것 - 2순위
*************************************************************************/         
    IF V_BS_CD IS NULL THEN
    
        BEGIN
            SELECT  DECODE(SUBSTR(BS_CD, 3, 1), '2', '2'||'LB4', '3', '2'||'LB4', '2'|| BS_CD) BS
            INTO    V_BS_CD
            FROM (
                    SELECT BK.BKG_NO,
                    (
                        SELECT MIN(PBST.BLCK_STWG_CD)  BS_CD
                        FROM   PRD_BLCK_STWG PBST ,
                               PRD_INLND_ROUT_MST PIRM
                        WHERE  PBST.PORT_CD                         = SUBSTR(PIRM.ROUT_ORG_NOD_CD, 1, 5)
                        AND    PBST.HUB_LOC_CD                      = SUBSTR(PIRM.HUB_LOC_CD, 1, 5) 
                        AND    PBST.PORT_CD                         = BK.POD_CD
                        AND    PIRM.ROUT_DEST_NOD_CD                LIKE BK.DEL_CD||'%'
                        AND    SUBSTR(PIRM.ROUT_DEST_NOD_CD,1,5)    = BK.DEL_CD                       
                        AND    PBST.VSL_SLAN_CD                     = BK.SLAN_CD
                        AND PIRM.PCTL_IO_BND_CD IN ('I','B')
                        AND NVL(PIRM.DELT_FLG,'N') <> 'Y' 
                        AND NVL(PIRM.INLND_ROUT_BKG_FLG,'N') = 'Y'                              
                    ) BS_CD
                    FROM BKG_BOOKING      BK ,
                         BKG_CNTR_MF_DESC CM 
                    WHERE 1=1
                    AND BK.BKG_NO                           = V_BKG_NO
                    AND BK.BKG_NO                           = CM.BKG_NO(+)
                    AND (UPPER(CM.CNTR_MF_GDS_DESC)         LIKE '%NOTE BOOK%'
                      OR UPPER(CM.CNTR_MF_GDS_DESC)         LIKE '%LCD-TFT%'
                      OR UPPER(CM.CNTR_MF_GDS_DESC)         LIKE '%MONITOR%'
                      OR UPPER(CM.CNTR_MF_GDS_DESC)         LIKE '%SHOE%'
                      OR BK.CMDT_CD                         IN ('847129','853945','847100','46')
                      OR BK.REP_CMDT_CD                     = '46')
               )
               ;
        EXCEPTION WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('%%TRS_GET_BLCK_STWG_CD_FNC%% 2. SELECT ['||SQLERRM||']');
        END;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('2.V_BS_CD===>'||V_BS_CD); 
/************************************************************************* 
3. 고가 운송물중 LANE이 ALL인것 - 3순위
*************************************************************************/     
    IF V_BS_CD IS NULL THEN
        BEGIN
            SELECT  DECODE(SUBSTR(BS_CD,3,1), '2', '3'||'LB4', '3', '3'||'LB4', '3'||BS_CD) BS
            INTO    V_BS_CD
            FROM (
                    SELECT BK.BKG_NO,
                    (
                        SELECT MIN(PBST.BLCK_STWG_CD)  BS_CD
                        FROM   PRD_BLCK_STWG PBST ,
                               PRD_INLND_ROUT_MST PIRM
                        WHERE  PBST.PORT_CD                         = SUBSTR(PIRM.ROUT_ORG_NOD_CD, 1, 5)
                        AND    PBST.HUB_LOC_CD                      = SUBSTR(PIRM.HUB_LOC_CD, 1, 5) 
                        AND    PBST.PORT_CD                         = BK.POD_CD
                        AND    PIRM.ROUT_DEST_NOD_CD                LIKE BK.DEL_CD||'%'
                        AND    SUBSTR(PIRM.ROUT_DEST_NOD_CD,1,5)    = BK.DEL_CD                       
                        AND    PBST.VSL_SLAN_CD                     = 'ALL'   
                        AND    PIRM.PCTL_IO_BND_CD                  IN ('I','B')
                        AND    NVL(PIRM.DELT_FLG,'N')               <> 'Y' 
                        AND    NVL(PIRM.INLND_ROUT_BKG_FLG,'N')     = 'Y'                              
                    ) BS_CD
                    FROM BKG_BOOKING      BK ,
                         BKG_CNTR_MF_DESC CM 
                    WHERE 1=1
                    AND BK.BKG_NO                           = V_BKG_NO
                    AND BK.BKG_NO                           = CM.BKG_NO(+)
                    AND (UPPER(CM.CNTR_MF_GDS_DESC)         LIKE '%NOTE BOOK%'
                      OR UPPER(CM.CNTR_MF_GDS_DESC)         LIKE '%LCD-TFT%'
                      OR UPPER(CM.CNTR_MF_GDS_DESC)         LIKE '%MONITOR%'
                      OR UPPER(CM.CNTR_MF_GDS_DESC)         LIKE '%SHOE%'
                      OR BK.CMDT_CD                         IN ('847129','853945','847100','46')
                      OR BK.REP_CMDT_CD                     = '46')
               )
               ;
        EXCEPTION WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('%%TRS_GET_BLCK_STWG_CD_FNC%% 3.SELECT ['||SQLERRM||']');
        END;  
    END IF;

    DBMS_OUTPUT.PUT_LINE('3.V_BS_CD===>'||V_BS_CD); 

/************************************************************************* 
4. 4순위
*************************************************************************/ 
    
    IF V_BS_CD IS NULL THEN
        BEGIN
            SELECT  4||BS_CD
            INTO    V_BS_CD
            FROM
            (
                SELECT MIN(PBST.BLCK_STWG_CD)  BS_CD
                       , BKG_NO
                FROM   PRD_BLCK_STWG        PBST ,
                       PRD_INLND_ROUT_MST   PIRM ,
                       BKG_BOOKING          BK
                WHERE  PBST.PORT_CD                         = SUBSTR(PIRM.ROUT_ORG_NOD_CD, 1, 5)
                AND    PBST.HUB_LOC_CD                      = SUBSTR(PIRM.HUB_LOC_CD, 1, 5)
                AND    PBST.PORT_CD                         =    BK.POD_CD
                AND    PIRM.ROUT_DEST_NOD_CD                LIKE BK.DEL_CD||'%'
                AND    SUBSTR(PIRM.ROUT_DEST_NOD_CD,1,5)    =    BK.DEL_CD
                AND    PBST.VSL_SLAN_CD                     = BK.SLAN_CD
                AND    PIRM.PCTL_IO_BND_CD                  IN ('I','B')
                AND    NVL(PIRM.DELT_FLG,'N')               <> 'Y' 
                AND    NVL(PIRM.INLND_ROUT_BKG_FLG,'N')     = 'Y'
                AND    BKG_NO                               = V_BKG_NO
                GROUP BY
                BKG_NO 
            )
            ;
        EXCEPTION WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('%%TRS_GET_BLCK_STWG_CD_FNC%% 4.SELECT ['||SQLERRM||']');
        END;  
    END IF;
    DBMS_OUTPUT.PUT_LINE('4.V_BS_CD===>'||V_BS_CD); 

/************************************************************************* 
4. 5순위
*************************************************************************/
    IF V_BS_CD IS NULL THEN
        BEGIN
            SELECT  '5'||BS_CD
            INTO    V_BS_CD
            FROM
            (
                SELECT MIN(PBST.BLCK_STWG_CD)  BS_CD
                       , BKG_NO
                FROM   PRD_BLCK_STWG        PBST ,
                       PRD_INLND_ROUT_MST   PIRM ,
                       BKG_BOOKING          BK
                WHERE  PBST.PORT_CD                         = SUBSTR(PIRM.ROUT_ORG_NOD_CD, 1, 5)
                AND    PBST.HUB_LOC_CD                      = SUBSTR(PIRM.HUB_LOC_CD, 1, 5)
                AND    PBST.VSL_SLAN_CD                     = 'ALL' 
                AND    PBST.PORT_CD                         = BK.POD_CD
                AND    PIRM.ROUT_DEST_NOD_CD                LIKE BK.DEL_CD||'%'
                AND    SUBSTR(PIRM.ROUT_DEST_NOD_CD,1,5)    = BK.DEL_CD
                AND    PIRM.PCTL_IO_BND_CD                  IN ('I','B')
                AND    NVL(PIRM.DELT_FLG,'N')               <> 'Y' 
                AND    NVL(PIRM.INLND_ROUT_BKG_FLG,'N')     = 'Y'
                AND    BKG_NO                               = V_BKG_NO
                GROUP BY BKG_NO
            )
            ;
        EXCEPTION WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('%%TRS_GET_BLCK_STWG_CD_FNC%% 5.SELECT ['||SQLERRM||']');
        END; 
    END IF;
    DBMS_OUTPUT.PUT_LINE('5.V_BS_CD===>'||V_BS_CD);
RETURN SUBSTR(V_BS_CD, 2);
EXCEPTION
    WHEN OTHERS THEN
    RETURN NULL;
        DBMS_OUTPUT.PUT_LINE('%%TRS_GET_BLCK_STWG_CD_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');
END ;