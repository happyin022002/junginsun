CREATE OR REPLACE FUNCTION OPUSADM."PRD_GET_OCN_VVD_FNC"

/* ========================================================
   1. Object Name      : PRD_GET_OCN_VVD_FNC
   2. Version          : 1.0
   3. Create Date      : 2009.11.20
   4. Sub System       : Product Catalog
   5. Author           : 조용인
   6. Description      : 해상 운송 구간에 대한 특정번째의 VVD 산출
   7. Revision History : 2009.11.20 조용인 최초 생성
======================================================== */

(
    ----------------------------------------PARAMETERS----------------------------------------
    V_PCTL_NO       IN VARCHAR2,   -- PRD NUMBER
    V_SEQ           IN NUMBER      -- 디테이 VESSEL 구간
    -------------------------------------------------------------------------------------------
)

RETURN VARCHAR2                 -- String of milestone Information
authid current_user 
IS

    rtStr       VARCHAR2(800)   := NULL;

BEGIN

        
    SELECT VVD
    INTO    rtStr
    FROM (
        select RANK() OVER (ORDER BY PCTL_SEQ) RK,VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD 
        from prd_prod_ctl_rout_dtl
        where pctl_no = V_PCTL_NO
        and pctl_io_bnd_cd ='T'
        and substr(ORG_NOD_CD,1,5) <>  substr(DEST_NOD_CD,1,5)
        and TRSP_MOD_CD in ('WD','VD')
        )
    WHERE RK =V_SEQ    
    ;     

    RETURN rtStr;
                        
END;
/
