CREATE OR REPLACE FUNCTION OPUSADM.HOM_GET_ALL_INLND_FNC
( 
  v_rout_org_nod_cd   IN VARCHAR2 , 
  v_rout_dest_nod_cd  IN VARCHAR2 , 
  v_rout_seq          IN VARCHAR2 , 
  v_bnd_cd            IN VARCHAR2 , 
  v_vsl_dt            IN DATE 
) 
 
/******************************************************************************* 
   1. Object Name      :  HOM_GET_ALL_INLND_FNC 
   2. Version          :  1.0 
   3. Create Date      :  2011.09.01 
   4. Sub System       :  HOM 
   5. Author           :  류선우 
   6. Description      :  Inland Route 정보를 구하는 FUNCTION 
   7. Revision History :  2011.09.01 류선우 최초 생성 
                          2011.09.22 Origin Yard Code, Destination Yard Code 칼럼 추가 
                          2011.10.12 Link Distance 가 업을때 HOM_GET_APPX_LNK_DIST_FNC() 를 추가적으로 호출하도록 수정 
                          2013.03.15 IRG의 Dwell Time 추가  
 
  << RETURN >> 
    01> VNDR_LGL_ENG_NM 
    02> TRANSPORTATION MODE NAME 
    03> Origin Location Name 
    04> Origin Yard Name 
    05> DEPARTURE DATE (YYYY-MM-DD) 
    06> Destination Location Name 
    07> Destination Yard Name 
    08> ARRIVAL DATE (YYYY-MM-DD) 
    09> TZTM_HRS ( DAYS & HOURS ) 
    10> CARBON EMISSION ( ROUND 처리 ) 
    11> Origin Yard Code 
    12> Destination Yard Code 
    13> NULL ( HOM_GET_NEXT_VVD_FNC 의 RETURN 값과 칼럼을 일치하기 위하여 추가 ) 
*******************************************************************************/ 
 
    RETURN VARCHAR2 
 
    AUTHID  CURRENT_USER 
 
IS 
 
  row_split   VARCHAR2(2)     ; 
  col_split   VARCHAR2(2)     ; 
 
  r_inlnd_str VARCHAR2(3000)  ; 
 
BEGIN 
 
  row_split   := '@#' ; 
  col_split   := '$%' ; 
 
  r_inlnd_str := ''   ; 
 
 
 
  SELECT  LTRIM(TTL_STR, row_split) TTL_STR 
  INTO    r_inlnd_str 
  FROM 
  ( 
  SELECT  SYS_CONNECT_BY_PATH(ROW_STR, '@#') TTL_STR ,  /* SYS_CONNECT_BY_PATH 에 row_split 변수를 대입하면 에러 발생 */ 
          ROW_NUMBER  , 
          ROW_COUNT 
  FROM    ( 
          SELECT  ( SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR A WHERE A.VNDR_SEQ = ID.VNDR_SEQ ) 
                    || col_split || 
                  '(' || ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL A WHERE A.INTG_CD_ID = 'CD00997' AND A.INTG_CD_VAL_CTNT = ID.TRSP_MOD_CD ) || ')' 
                    || col_split || 
                  ( SELECT LOC_NM FROM MDM_LOCATION A WHERE A.LOC_CD = SUBSTR(ID.LNK_ORG_NOD_CD,1,5) ) 
                    || col_split || 
                  CASE 
                  WHEN  v_bnd_cd = 'O' AND ID.ROUT_DTL_SEQ = 1 
                    THEN  '' 
                  ELSE  '(' || ( SELECT YD_NM FROM MDM_YARD A WHERE A.YD_CD = ID.LNK_ORG_NOD_CD ) || ')' 
                  END 
                    || col_split || 
                  TO_CHAR ( 
                          /* 1 day 는 CCT 를 고려한 수식임 */ 
                          CASE 
                          WHEN  v_bnd_cd  = 'O' 
--                            THEN  v_vsl_dt - 1 - ( SUM(EL.TZTM_HRS) OVER ( ORDER BY ID.ROUT_DTL_SEQ DESC RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW ) / 24 ) 
                            THEN  v_vsl_dt - ( SUM(EL.TZTM_HRS+NVL(DRY_AVG_DWLL_HRS,0)) OVER ( ORDER BY ID.ROUT_DTL_SEQ DESC RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW ) / 24 ) 
                          WHEN  v_bnd_cd  = 'I' 
--                            THEN  v_vsl_dt + ( NVL(SUM(EL.TZTM_HRS) OVER ( ORDER BY ID.ROUT_DTL_SEQ RANGE BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING ), 0) / 24 ) 
                            THEN  v_vsl_dt + ( NVL(SUM(EL.TZTM_HRS+NVL(DRY_AVG_DWLL_HRS,0)) OVER ( ORDER BY ID.ROUT_DTL_SEQ RANGE BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING ), 0) / 24 ) 
                          END , 
                          'YYYY-MM-DD' 
                          ) 
                    || col_split || 
                  ( SELECT LOC_NM FROM MDM_LOCATION A WHERE A.LOC_CD = SUBSTR(ID.LNK_DEST_NOD_CD,1,5) ) 
                    || col_split || 
                  CASE 
                  WHEN   v_bnd_cd = 'I' AND ID.ROUT_DTL_SEQ = MAX(ID.ROUT_DTL_SEQ) OVER () 
                    THEN  '' 
                  ELSE  '(' || ( SELECT YD_NM FROM MDM_YARD A WHERE A.YD_CD = ID.LNK_DEST_NOD_CD ) || ')' 
                  END 
                    || col_split || 
                  TO_CHAR ( 
                          /* 1 day 는 CCT 를 고려한 수식임 */ 
                          CASE 
                          WHEN  v_bnd_cd  = 'O' 
--                            THEN  v_vsl_dt - 1 - ( NVL(SUM(EL.TZTM_HRS) OVER ( ORDER BY ID.ROUT_DTL_SEQ DESC RANGE BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING ), 0) / 24 ) 
                            THEN  v_vsl_dt - ( NVL(SUM(EL.TZTM_HRS+NVL(DRY_AVG_DWLL_HRS,0)) OVER ( ORDER BY ID.ROUT_DTL_SEQ DESC RANGE BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING ), 0) / 24 ) 
                          WHEN  v_bnd_cd  = 'I' 
--                            THEN  v_vsl_dt + ( SUM(EL.TZTM_HRS) OVER ( ORDER BY ID.ROUT_DTL_SEQ RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW ) / 24 ) 
                            THEN  v_vsl_dt + ( SUM(EL.TZTM_HRS+NVL(DRY_AVG_DWLL_HRS,0))  OVER ( ORDER BY ID.ROUT_DTL_SEQ RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW ) / 24 ) 
                          END , 
                          'YYYY-MM-DD' 
                          ) 
                    || col_split || 
                  --LPAD(TRUNC(EL.TZTM_HRS / 24), 2, ' ') || ' days ' || LPAD(MOD(EL.TZTM_HRS, 24), 2, ' ') || ' hours' 
                  LPAD(TRUNC( (EL.TZTM_HRS + decode(v_bnd_cd, 'O',NVL(DRY_AVG_DWLL_HRS,0),'I',NVL(DRY_AVG_DWLL_HRS,0) ) )/ 24), 2, ' ') || ' days ' || LPAD(MOD( (EL.TZTM_HRS + decode(v_bnd_cd, 'O',NVL(DRY_AVG_DWLL_HRS,0),'I',NVL(DRY_AVG_DWLL_HRS,0) ) ), 24), 2, ' ') || ' hours' 
                    || col_split || 
                    '0' 
                    || col_split || 
                  ID.LNK_ORG_NOD_CD 
                    || col_split || 
                  ID.LNK_DEST_NOD_CD 
                    || col_split || 
                  TO_CHAR (CASE WHEN SUBSTR(ID.LNK_ORG_NOD_CD,1,5) = SUBSTR(ID.LNK_DEST_NOD_CD,1,5) THEN  
                     v_vsl_dt - ( NVL(SUM(EL.TZTM_HRS+NVL(DRY_AVG_DWLL_HRS,0)) OVER ( ORDER BY ID.ROUT_DTL_SEQ DESC RANGE BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING ), 0) / 24 ) 
                  ELSE  
                     v_vsl_dt - ( SUM(EL.TZTM_HRS+NVL(DRY_AVG_DWLL_HRS,0)) OVER ( ORDER BY ID.ROUT_DTL_SEQ DESC RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW ) / 24 )  
                  END, 'YYYY-MM-DD HH24:MI') 
                    ROW_STR , -- 조회을 원하는 칼럼 결합 
                  ROW_NUMBER() OVER ( ORDER BY ID.ROUT_DTL_SEQ ) ROW_NUMBER  , -- DATA SORTING 순서 지정 
                  COUNT(1) OVER ()                      ROW_COUNT 
          FROM    PRD_INLND_ROUT_DTL  ID  , 
                  PRD_INLND_EACH_LNK  EL 
                  , MDM_YARD Y --------------------------add jsy 
          WHERE   ID.ROUT_ORG_NOD_CD  = v_rout_org_nod_cd 
          AND     ID.ROUT_DEST_NOD_CD = v_rout_dest_nod_cd 
          AND     ID.ROUT_SEQ         = v_rout_seq 
          AND     EL.LNK_ORG_NOD_CD   = ID.LNK_ORG_NOD_CD 
          AND     EL.LNK_DEST_NOD_CD  = ID.LNK_DEST_NOD_CD 
          AND     EL.TRSP_MOD_CD      = ID.TRSP_MOD_CD 
          AND     ID.LNK_DEST_NOD_CD = Y.YD_CD(+) 
          ) 
  START WITH  ROW_NUMBER = 1 
  CONNECT BY  PRIOR ROW_NUMBER = ROW_NUMBER - 1 
  ) 
  WHERE   ROW_NUMBER = ROW_COUNT 
  ; 
 
  RETURN  r_inlnd_str ; 
 
 
END HOM_GET_ALL_INLND_FNC 
;
/

