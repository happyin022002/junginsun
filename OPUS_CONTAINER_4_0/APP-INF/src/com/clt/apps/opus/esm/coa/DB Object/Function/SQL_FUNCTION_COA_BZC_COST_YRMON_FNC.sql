CREATE OR REPLACE FUNCTION OPUSADM."COA_BZC_COST_YRMON_FNC" (IN_BKG_NO IN VARCHAR) 
   RETURN VARCHAR 
   Authid current_user
/****************************************************************************** 
   Purpose      :   단가를 붙일 기준 년월을 가져오다. 
 
   Revision History 
    2007-04-17:박칠서 최초생성 
    2007-09-18:박칠서 최종 기준 년월 제한 추가 
    2007-11-06:박칠서 RBCCO 기준년월 로직수정 
                      ASIS - RBCCO일 경우 생성일을 기준년월로 한다. 
                      TOBE - RBCCO일 대상항차 년월을 찾고 없으면 생성일을 기준년월로 한다. 
    2007-11-09:박칠서 PRD 호출시 에러 수정, BKG 없이 호출 되므로 시스템 년월로 보완 
   Example      : 
   SELECT coa_bzc_cost_yrmon_fnc ('SIN6B069040') bzc_cost_yrmon 
   FROM DUAL 
 
******************************************************************************/ 
IS 
-- ===== DECLARE ==========================================
   V_STEP              VARCHAR2(100); 
   V_TRD_CD            COA_BKG_EXPN_DTL.TRD_CD%TYPE; 
   V_RLANE_CD          COA_BKG_EXPN_DTL.RLANE_CD%TYPE; 
   V_IOC_CD            COA_BKG_EXPN_DTL.IOC_CD%TYPE; 
   V_VSL_CD            COA_BKG_EXPN_DTL.VSL_CD%TYPE; 
   V_SKD_VOY_NO        COA_BKG_EXPN_DTL.SKD_VOY_NO%TYPE; 
   V_DIR_CD            COA_BKG_EXPN_DTL.DIR_CD%TYPE; 
   V_BKG_INFO_CRE_DT   VARCHAR2(6); 
   V_VVD_COST_YRMON    VARCHAR2(6); 
   V_BZC_COST_YRMON    VARCHAR2(6); 
   V_MAX_COST_YRMON    VARCHAR2(6)                    := '201011';   -- 현재 생성된 최종 단가 년월 
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN 
--//////////////////////////////////////////////////////////////////////// 
-- 부킹생성일, VVD 정보 
--//////////////////////////////////////////////////////////////////////// 
   V_STEP := '부킹생성일, VVD 정보'; 
 
   BEGIN 
      SELECT TRD_CD 
            ,RLANE_CD 
            ,IOC_CD 
            ,VSL_CD 
            ,SKD_VOY_NO 
            ,DIR_CD 
            ,TO_CHAR(CRE_DT, 'YYYYMM') CRE_DT 
        INTO V_TRD_CD 
            ,V_RLANE_CD 
            ,V_IOC_CD 
            ,V_VSL_CD 
            ,V_SKD_VOY_NO 
            ,V_DIR_CD 
            ,V_BKG_INFO_CRE_DT 
        FROM COA_BKG_EXPN_DTL 
       WHERE BKG_NO       = IN_BKG_NO; 
   EXCEPTION 
      WHEN OTHERS 
      THEN 
         -- 부킹생성일이 없으면 현재 년월 
         V_VVD_COST_YRMON := NULL; 
   END; 
 
--//////////////////////////////////////////////////////////////////////// 
-- 대상항차 년월 
--//////////////////////////////////////////////////////////////////////// 
   BEGIN 
      SELECT COST_YRMON 
        INTO V_VVD_COST_YRMON 
        FROM COA_MON_VVD 
       WHERE TRD_CD     = V_TRD_CD 
         AND RLANE_CD   = V_RLANE_CD 
         AND IOC_CD     = V_IOC_CD 
         AND VSL_CD     = V_VSL_CD 
         AND SKD_VOY_NO = V_SKD_VOY_NO 
         AND DIR_CD     = V_DIR_CD 
         AND DELT_FLG   = 'N'; 
   EXCEPTION 
      WHEN OTHERS 
      THEN 
         V_VVD_COST_YRMON := NULL; 
   END; 
 
--//////////////////////////////////////////////////////////////////////// 
-- RBCCO 이고 VVD 기준년월이 없으면 BKG 생성년월을 기준으로 한다. 
--//////////////////////////////////////////////////////////////////////// 
   V_STEP := 'RBCCO 이고 VVD'; 
 
   IF (    V_RLANE_CD = 'RBCCO' 
       AND V_VVD_COST_YRMON IS NULL) 
   THEN 
      V_VVD_COST_YRMON := V_BKG_INFO_CRE_DT; 
   END IF; 
 
--//////////////////////////////////////////////////////////////////////// 
-- RBCCO 가 아닌데 VVD 기준년월이 없으면 현재년월을 기준으로 한다. 
-- (주의) PRD 에서 호출시 BKG 이 없으므로 꼭 필요한 부분 
--//////////////////////////////////////////////////////////////////////// 
   V_STEP := 'RBCCO 가 아닌데 VVD'; 
 
   IF (    V_RLANE_CD <> 'RBCCO' 
       AND V_VVD_COST_YRMON IS NULL) 
   THEN 
      V_VVD_COST_YRMON := TO_CHAR(SYSDATE, 'YYYYMM'); 
   END IF; 
 
--//////////////////////////////////////////////////////////////////////// 
-- VVD 기준년월로 NODE 단가가 있는지 체크 
--//////////////////////////////////////////////////////////////////////// 
   BEGIN 
      SELECT COST_YRMON 
        INTO V_BZC_COST_YRMON 
        FROM COA_NOD_AVG_STND_COST 
       WHERE COST_YRMON  = V_VVD_COST_YRMON 
         AND COST_YRMON <= V_MAX_COST_YRMON   -- 차월 단가를 미리 생성하기 위해 MAX 제한을 한다. 
         AND ROWNUM < 2; 
   EXCEPTION 
      WHEN OTHERS 
      THEN 
         V_BZC_COST_YRMON := NULL; 
   END; 
 
--//////////////////////////////////////////////////////////////////////// 
-- NODE 단가가 없으면 가장 최근 NODE 단가를 사용한다. 
-- 성능 때문에 NOD 단가에 기준년월 없을때만 MAX 값 추출 
--//////////////////////////////////////////////////////////////////////// 
   V_STEP := 'VVD 기준년월로'; 
 
   IF (V_BZC_COST_YRMON IS NULL) 
   THEN 
      SELECT MAX(COST_YRMON) 
        INTO V_BZC_COST_YRMON 
        FROM COA_NOD_AVG_STND_COST 
       WHERE COST_YRMON <= V_MAX_COST_YRMON;   -- 차월 단가를 미리 생성하기 위해 MAX 제한을 한다. 
   END IF; 
 
   RETURN V_BZC_COST_YRMON; 
   
EXCEPTION 
   WHEN OTHERS 
   THEN 
--      DBMS_OUTPUT.PUT_LINE(SQLERRM || IN_BKG_NO ||  '#'); 
--      ENIS_LOG_PRC(SYSDATE, 'COA_BZC_COST_YRMON_FNC', V_STEP || ' > ' || SQLERRM, IN_BKG_NO || '#'); 
      RAISE; 
END;