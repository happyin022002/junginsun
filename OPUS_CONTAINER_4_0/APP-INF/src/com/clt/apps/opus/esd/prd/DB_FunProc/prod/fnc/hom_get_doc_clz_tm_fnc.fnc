CREATE OR REPLACE FUNCTION OPUSADM.HOM_GET_DOC_CLZ_TM_FNC
(
  v_slan_cd         IN VARCHAR2 ,
  v_pol_loc_cd      IN VARCHAR2 ,
  v_pod_cnt_cd      IN VARCHAR2 ,
  v_etb             DATE        ,
  v_etd             DATE        ,
  v_eta             DATE
)

/*******************************************************************************
   1. Object Name      :  HOM_GET_DOC_CLZ_TM_FNC
   2. Version          :  1.0
   3. Create Date      :  2011.12.31
   4. Sub System       :  HOM
   5. Author           :  류선우
   6. Description      :  BKG Request 시 Document Closing Time 을 구하는 Function
   7. Revision History :  2011.12.31 류선우 최초 생성
*******************************************************************************/

    RETURN DATE

    AUTHID  CURRENT_USER

IS

  r_dct      DATE   ;

BEGIN

  SELECT  CASE
          WHEN  XCLD_HOL_FLG = 'Y'
            THEN  NVL(  (
                        SELECT  MIN(A.HOL_DT) - 1 + (1/24*17) --연휴시작 전일 17시
                        FROM    DMT_HOLIDAY A
                        WHERE   A.HOL_YR  = TO_CHAR(DCT, 'YYYY')
                        AND     A.CNT_CD  = SUBSTR(v_pol_loc_cd, 1, 2)
                        AND     NVL(TRIM(A.LOC_CD), v_pol_loc_cd) = v_pol_loc_cd
                        AND     TO_CHAR(A.HOL_DT, 'YYYYMMDD') = TO_CHAR(DCT, 'YYYYMMDD')
                        )
                        , DCT )
          ELSE  DCT
          END
  INTO    r_dct
  FROM    (
          SELECT  CASE
                  WHEN TO_CHAR(DCT, 'DY') = 'SUN' THEN DCT - 2
                  WHEN TO_CHAR(DCT, 'DY') = 'SAT' THEN DCT - 1
                  ELSE DCT
                    END DCT ,
                    XCLD_HOL_FLG
          FROM    (
                  SELECT  CASE
                           WHEN DOC_CLZ_TP_CD = 'B' THEN v_etb + (NVL(ITVAL_HRS, 0)/24) --ETB
                           WHEN DOC_CLZ_TP_CD = 'D' THEN v_etd + (NVL(ITVAL_HRS, 0)/24) --ETD
                           WHEN DOC_CLZ_TP_CD = 'A' THEN v_eta + (NVL(ITVAL_HRS, 0)/24) --ETA
                           WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD IN ( '1DA', '2DA', '3DA', '1DB', '2DB', '3DB', '1DD', '2DD', '3DD' )
                            THEN  TRUNC(DECODE(SUBSTR(DOC_CLZ_DY_CD,3,1), 'A', v_eta, 'B', v_etb, 'D', v_etd)) - TO_NUMBER(SUBSTR(DOC_CLZ_DY_CD,1,1)) + DOC_CLZ_DY_HRS/(24*60)
                           WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD IN ( 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN' )
                            THEN  (
                                   SELECT TRUNC(v_etd) - CPY_NO + DOC_CLZ_DY_HRS/(24*60)
                                   FROM   ( SELECT LEVEL CPY_NO FROM DUAL CONNECT BY LEVEL <= 7 )
                                   WHERE    DOC_CLZ_DY_CD = TO_CHAR(v_etd - CPY_NO , 'DY')
                                   )
                           END  DCT ,
                           XCLD_HOL_FLG
                  FROM    (
                          SELECT DOC_CLZ_TP_CD, ITVAL_HRS, XCLD_HOL_FLG, DOC_CLZ_DY_CD, DOC_CLZ_DY_HRS
                          FROM    (
                                  SELECT  DC.*,
                                          ROW_NUMBER() OVER ( ORDER BY DECODE(VSL_SLAN_CD, '*', 2, 1), DECODE(DEST_CNT_CD, '*', 2, 1) ) ROW_NO
                                  FROM  BKG_DOC_CLZ_SET DC
                                  WHERE VSL_SLAN_CD IN ( '*', v_slan_cd )
                                  AND   YD_CD = v_pol_loc_cd
                                  AND   DEST_CNT_CD IN ( '*', v_pod_cnt_cd )
                                  AND   DELT_FLG = 'N'
                                  )
                          WHERE ROW_NO = 1
                          )
                  )
          )
  ;

  RETURN  r_dct ;


  EXCEPTION
  WHEN  NO_DATA_FOUND THEN
      RETURN  NULL ;


END HOM_GET_DOC_CLZ_TM_FNC
;
/

