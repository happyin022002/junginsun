CREATE OR REPLACE FUNCTION OPUSADM."PRD_GET_COP_NO_EUR_DR_STR_FNC"

/* ========================================================
   1. Object Name      : PRD_GET_OCN_SKD_STR_FNC
   2. Version          : 1.0
   3. Create Date      : 2009.11.19
   4. Sub System       : Product Catalog
   5. Author           : 조용인
   6. Description      : COP BOUND별 S/O STRING 산출
   7. Revision History : 2009.11.19 조용인 최초 생성
======================================================== */

(
    V_COP_NO       IN VARCHAR2,  
    V_BND_CD       IN VARCHAR2
) 

RETURN VARCHAR2                
authid current_user
IS

    rtStr       VARCHAR2(800)   := NULL;
  
BEGIN
    

    SELECT
        REPLACE( 
        REPLACE(MAX(   SYS_CONNECT_BY_PATH(  
                       DECODE(B.LAG_SEQ,-1,NULL,   
                                   DECODE(B.RK2,1,'%'||B.FM_NOD_CD||DECODE(B.TO_NOD_CD,NULL,NULL,'@*'),NULL) 
                               	  )||  
                       B.MODE_CD||
                       '@*'||B.COMB_MOD||'@*'||LPAD(B.COST_ACT_SEQ,3,'0')||
                       DECODE(B.TO_NOD_CD,NULL,NULL,'@*')||  
                       B.TO_NOD_CD  
                       , '-')  
                       ),'@*','-')||'%'  
                ,'-%','%') SO_STRING
    INTO rtStr 
    FROM (
        SELECT COP_NO,NVL(RK,1) RK,NVL(RK2,1) RK2,FM_NOD_CD,TO_NOD_CD,MODE_CD, 
               COMB_MOD,COST_ACT_SEQ,
               LAG_NOD,LAG_COST_ACT_GRP_SEQ,SO_CNT,
               (CASE WHEN RK2 = 1 AND LAG_NOD = FM_NOD_CD AND LAG_COST_ACT_GRP_SEQ IS NOT NULL
                            THEN -1
                     ELSE 0
               END) LAG_SEQ,
              TRSP_BND_CD   
        FROM (   
            SELECT COP_NO,
                   DENSE_RANK() OVER (PARTITION BY COP_NO,TRSP_BND_CD ORDER BY COST_ACT_GRP_SEQ,SEQ) RK,
                   DENSE_RANK() OVER (PARTITION BY COP_NO,TRSP_BND_CD,COST_ACT_GRP_SEQ ORDER BY SEQ) RK2,
                   FM_NOD_CD,TO_NOD_CD,MODE_CD,
                   COMB_MOD,COST_ACT_GRP_SEQ COST_ACT_SEQ,
                   COUNT(COST_ACT_GRP_SEQ) OVER (PARTITION BY COP_NO) SO_CNT,
                   LAG(TO_NOD_CD,1) OVER(PARTITION BY COP_NO,TRSP_BND_CD ORDER BY COST_ACT_GRP_SEQ, SEQ) LAG_NOD,
                   LAG(COST_ACT_GRP_SEQ,1) OVER (PARTITION BY COP_NO,TRSP_BND_CD ORDER BY COST_ACT_GRP_SEQ,SEQ) LAG_COST_ACT_GRP_SEQ,
                   TRSP_BND_CD
            FROM (
                SELECT COP_NO, SEQ,FM_NOD_CD,TO_NOD_CD,MODE_CD,
                       COMB_MOD,COST_ACT_GRP_SEQ,TRSP_BND_CD 
                FROM ( 
                    SELECT  COP_NO,
                    (                                                                                                
                    CASE F_N0                                                                                        
                        WHEN 0 THEN '1'    WHEN 1 THEN '2'  
                        ELSE 'N/A'                                                                                   
                    END                                                                                              
                    ) SEQ,
                    (                                                                                                
                    CASE F_N0                                                                                        
                        WHEN 0 THEN SUBSTR(ROUT,1,7)    WHEN 1 THEN SUBSTR(ROUT,10,7)  
                        ELSE 'N/A'                                                                                   
                    END                                                                                              
                    ) FM_NOD_CD,
                    (                                                                                                
                    CASE F_N0                                                                                        
                        WHEN 0 THEN SUBSTR(ROUT,10,7)    WHEN 1 THEN SUBSTR(ROUT,19,7)  
                        ELSE 'N/A'                                                                                   
                    END                                                                                              
                    ) TO_NOD_CD,
                    (                                                                                                
                    CASE F_N0                                                                                        
                        WHEN 0 THEN SUBSTR(ROUT,8,2)    WHEN 1 THEN SUBSTR(ROUT,17,2)  
                        ELSE 'N/A'                                                                                   
                    END                                                                                              
                    ) MODE_CD,
                    (                                                                                                
                    CASE WHEN LENGTH(ROUT) > 16  THEN 'Y' 
                        ELSE 'N'                                                                                  
                    END                                                                                              
                    ) COMB_MOD,
                    TRSP_BND_CD,
                    COST_ACT_GRP_SEQ  
                    FROM 
                    (
                        SELECT  COP_NO,
                        (CASE 
                            WHEN TRSP_BND_CD = 'O' AND TRIM(DOR_NOD_CD) IS NOT NULL
                                   THEN TRIM(DOR_NOD_CD)||SUBSTR(TRSP_CRR_MOD_CD,1,1)||'D'||
                                        TRIM(VIA_NOD_CD)||DECODE(TRIM(VIA_NOD_CD),NULL,NULL,DECODE(SUBSTR(TRSP_CRR_MOD_CD,2,1),'D',TRSP_CRR_MOD_CD,SUBSTR(TRSP_CRR_MOD_CD,2,1)||'D'))||
                                        TO_NOD_CD
                            WHEN TRSP_BND_CD = 'I' AND TRIM(DOR_NOD_CD) IS NOT NULL
                                   THEN FM_NOD_CD||SUBSTR(TRSP_CRR_MOD_CD,1,1)||'D'|| 
                                        TRIM(VIA_NOD_CD)||DECODE(TRIM(VIA_NOD_CD),NULL,NULL,DECODE(SUBSTR(TRSP_CRR_MOD_CD,2,1),'D',TRSP_CRR_MOD_CD,SUBSTR(TRSP_CRR_MOD_CD,2,1)||'D'))||
                                        TRIM(DOR_NOD_CD)
                            ELSE 
                                        FM_NOD_CD||SUBSTR(TRSP_CRR_MOD_CD,1,1)||'D'|| 
                                        DECODE(TRSP_BND_CD,'O',TRIM(DOR_NOD_CD),TRIM(VIA_NOD_CD))||DECODE(DECODE(TRSP_BND_CD,'O',TRIM(DOR_NOD_CD),TRIM(VIA_NOD_CD)),NULL,NULL,DECODE(TRSP_BND_CD,'O',SUBSTR(TRSP_CRR_MOD_CD,1,1)||'D',DECODE(SUBSTR(TRSP_CRR_MOD_CD,2,1),'D',TRSP_CRR_MOD_CD,SUBSTR(TRSP_CRR_MOD_CD,2,1)||'D')))||
                                        DECODE(TRSP_BND_CD,'O',TRIM(VIA_NOD_CD),TRIM(DOR_NOD_CD))||DECODE(DECODE(TRSP_BND_CD,'O',TRIM(VIA_NOD_CD),TRIM(DOR_NOD_CD)),NULL,NULL,DECODE(SUBSTR(TRSP_CRR_MOD_CD,2,1),'D',TRSP_CRR_MOD_CD,SUBSTR(TRSP_CRR_MOD_CD,2,1)||'D'))||
                                          TO_NOD_CD 
                        END) 
                        ROUT ,
                        TRSP_BND_CD,
                        COST_ACT_GRP_SEQ                      
                        FROM TRS_TRSP_SVC_ORD S                                                                                                        
                        WHERE COP_NO = V_COP_NO 
                        AND TRSP_BND_CD = V_BND_CD
                        AND TRSP_SO_TP_CD <> 'S' 
                        AND NVL(RPLN_UMCH_FLG,'N') <> 'Y'
                        AND NVL(TRSP_FRST_FLG,'N') <> 'Y'                         
                        AND NVL(DELT_FLG,'N') <> 'Y' 
                        AND EXISTS
                        (SELECT 'X' FROM BKG_BOOKING B, SCE_COP_HDR H
                         WHERE H.COP_NO = S.COP_NO
                         AND H.BKG_NO = B.BKG_NO
                         AND NVL(S.DOR_NOD_CD,DECODE(V_BND_CD,'O',B.POR_NOD_CD,'I',B.DEL_NOD_CD)) = 
                             DECODE(V_BND_CD,'O',B.POR_NOD_CD,'I',B.DEL_NOD_CD)
                         )
                     ) SVC_ORD,                                                                                               
                    (                                                                                                
                        SELECT CPY_NO F_N0 FROM COM_CPY_NO WHERE CPY_NO <=1                                 
                    ) ORDER BY 1
                )
                WHERE TO_NOD_CD IS NOT NULL
                UNION ALL 
                -- Rail So
                SELECT /*+  ORDERED */
                    A.COP_NO,
                    TO_CHAR(B.SUB_RAIL_SEQ),
                    B.FM_NOD_CD,
                    B.TO_NOD_CD,
                    B.TRSP_MOD_CD,
                    (CASE WHEN COUNT(B.SUB_RAIL_SEQ) OVER (PARTITION BY B.TRSP_SO_OFC_CTY_CD ,B.TRSP_SO_SEQ) > 1
                            THEN 'Y'
                          ELSE  'N'
                     END) COMB_MOD, 
                    A.COST_ACT_GRP_SEQ,
                    A.TRSP_BND_CD
                FROM TRS_TRSP_RAIL_BIL_ORD A , TRS_TRSP_RAIL_BIL_VNDR_SET B 
                WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD                                                                     
                AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ  
                AND A.TRSP_BND_CD = V_BND_CD                                                                             
                AND A.COP_NO = V_COP_NO 
                AND NVL(A.TRSP_FRST_FLG,'N') <> 'Y'
                AND NVL(A.DELT_FLG,'N') <> 'Y' 
                ORDER BY 1,8,2 --6,1  
            ) 
        ) 
    ) B
    START WITH B.RK = 1  
    CONNECT BY PRIOR B.RK   = B.RK -1  ;
    
    RETURN rtStr;
                        
END;
/

