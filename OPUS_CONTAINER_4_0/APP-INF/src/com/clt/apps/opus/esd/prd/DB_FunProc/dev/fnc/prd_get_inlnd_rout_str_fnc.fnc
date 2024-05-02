CREATE OR REPLACE FUNCTION OPUSADM."PRD_GET_INLND_ROUT_STR_FNC"

/* ========================================================
   1. Object Name      : PRD_GET_INLND_ROUT_STR_FNC
   2. Version          : 1.0
   3. Create Date      : 2008.10.06
   4. Sub System       : Product Catalog
   5. Author           : 조용인
   6. Description      : INLAND 구간의 ROUTE STRING 산출
   7. Revision History : 2008.10.06 조용인 최초 생성
======================================================== */

(
    ----------------------------------------PARAMETERS----------------------------------------
    V_ORG           IN VARCHAR2,   -- INLAND ROUT ORG
    V_DEST          IN VARCHAR2,   -- INLAND ROUT DEST
    V_SEQ           IN NUMBER      -- INLAND SEQ
    -------------------------------------------------------------------------------------------
)

RETURN VARCHAR2                 -- String of milestone Information
authid current_user 
IS

    rtStr       VARCHAR2(800)   := NULL;

BEGIN

    SELECT /*+ rule */  REPLACE(MAX(D1.ROUT_ORG_NOD_CD||                          
           SYS_CONNECT_BY_PATH(D1.TRSP_MOD_CD||'@*'||NVL(D1.INLND_ROUT_CMB_FLG,'N')||'@*'     
           ||D1.LNK_DEST_NOD_CD, '-')),'@*','-')   
      INTO    rtStr               
    FROM PRD_INLND_ROUT_DTL D1                                       
    WHERE D1.ROUT_ORG_NOD_CD = V_ORG                  
    	AND D1.ROUT_DEST_NOD_CD = V_DEST                 
    	AND D1.ROUT_SEQ = V_SEQ                                 
    START WITH D1.ROUT_ORG_NOD_CD = V_ORG                
    	AND D1.ROUT_DEST_NOD_CD = V_DEST                
    	AND D1.ROUT_SEQ = V_SEQ                           	
    	AND D1.ROUT_DTL_SEQ =1             
    CONNECT BY PRIOR D1.ROUT_DTL_SEQ +1 = D1.ROUT_DTL_SEQ            
        AND D1.ROUT_ORG_NOD_CD = V_ORG                  
        AND D1.ROUT_DEST_NOD_CD = V_DEST               
        AND D1.ROUT_SEQ = V_SEQ       
      ;    

    RETURN rtStr;
                        
END;
/

