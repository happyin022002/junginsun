CREATE OR REPLACE FUNCTION OPUSADM."PRD_GET_OCN_LINK_STR_FNC"

/* ========================================================
   1. Object Name      : PRD_GET_OCN_LINK_STR_FNC
   2. Version          : 1.0
   3. Create Date      : 2008.11.03
   4. Sub System       : Product Catalog
   5. Author           : 조용인
   6. Description      : 해상 운송 LINK 구간에 대한 Detail Route 정보 산출
   7. Revision History : 2008.11.03 조용인 최초 생성
======================================================== */

(
    ----------------------------------------PARAMETERS----------------------------------------
    V_COP_NO        IN VARCHAR2    -- COP NO
    -------------------------------------------------------------------------------------------
)

RETURN VARCHAR2                 -- String of milestone Information
authid current_user 
IS

    rtStr       VARCHAR2(800)   := NULL;

BEGIN

        SELECT             
            REPLACE( 
            REPLACE(MAX(DECODE(B.TRSP_BND_CD,'T',  
                           SYS_CONNECT_BY_PATH(  
                           DECODE(B.LAG_SEQ,-1,NULL,   
                                       DECODE(B.RK2,1,'%'||B.FM_NOD_CD||DECODE(B.TO_NOD_CD,NULL,NULL,'@*'),NULL) 
                                   	  )||  
                           B.MODE_CD||
                           '@*'||B.COMB_MOD||'@*'||LPAD(B.COST_ACT_SEQ,3,'0')||DECODE(B.TO_NOD_CD,NULL,NULL,'@*')||  
                           B.TO_NOD_CD  
                           , '-')  
                           )),'@*','-')||'%'  
                    ,'-%','%') OCN
        INTO rtStr
        FROM 
            (
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
                    SELECT H.COP_NO,'1' SEQ,M.N1ST_NOD_CD FM_NOD_CD,M.N2ND_NOD_CD TO_NOD_CD,M.TRSP_MOD_CD MODE_CD,
                    'N' COMB_MOD,M.COST_ACT_GRP_SEQ,'T' TRSP_BND_CD
                    FROM SCE_COP_HDR H, PRD_PROD_CTL_ACT_GRP_DTL M
                    WHERE H.COP_NO = V_COP_NO
                    AND H.PCTL_NO = M.PCTL_NO
                    AND M.COST_ACT_GRP_TP_CD='L'
                    AND M.PCTL_IO_BND_CD ='T'
                    ORDER BY 1,7,2
                ) 
             ) SO
        ) B START WITH B.RK = 1 
        CONNECT BY PRIOR B.RK   = B.RK -1  
        GROUP BY B.COP_NO ;

    RETURN rtStr;
                        
END;
/

