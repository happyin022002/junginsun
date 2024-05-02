CREATE OR REPLACE FUNCTION OPUSADM.HOM_GET_APPX_LNK_DIST_FNC
(
  v_fm_nod_cd     IN VARCHAR2 ,
  v_to_nod_cd     IN VARCHAR2 ,
  v_trsp_mod_cd   IN VARCHAR2
)

/*******************************************************************************
   1. Object Name      :  HOM_GET_APPX_LNK_DIST_FNC
   2. Version          :  1.0
   3. Create Date      :  2011.10.12
   4. Sub System       :  HOM
   5. Author           :  류선우
   6. Description      :  Inland Trans Mode 별 Link Distance 을 근사값을 구하는 FUNCTION
   7. Revision History :  2011.10.12 AS-IS 의 CUP_GET_DIST_BTWN_LOC_FNC 를 참고하여 최초 생성
*******************************************************************************/

    RETURN  NUMBER

    AUTHID  CURRENT_USER

IS

  r_lnk_dist  NUMBER := 0 ;

BEGIN

  IF v_trsp_mod_cd = 'WD' THEN

    SELECT  NVL(MIN(STND_DIST * 1.852), 0)
    INTO    r_lnk_dist
    FROM    VSK_PORT_DIST
    WHERE   FM_LOC_CD = SUBSTR(v_fm_nod_cd, 1, 5)
    AND     TO_LOC_CD = SUBSTR(v_to_nod_cd, 1, 5)
    ;

    IF r_lnk_dist = 0 THEN
      SELECT  NVL(MIN(STND_DIST * 1.852), 0)
      INTO    r_lnk_dist
      FROM    VSK_PORT_DIST
      WHERE   FM_LOC_CD = SUBSTR(v_to_nod_cd, 1, 5)
      AND     TO_LOC_CD = SUBSTR(v_fm_nod_cd, 1, 5)
      ;
    END IF  ;

  ELSE

    SELECT  NVL(MIN(DECODE(DIST_UT_CD, 'M', 1.6093, 1) * LNK_DIST), 0)
    INTO    r_lnk_dist
    FROM    PRD_INLND_EACH_LNK
    WHERE   LNK_ORG_NOD_CD      = v_to_nod_cd
    AND     LNK_DEST_NOD_CD     = v_fm_nod_cd
    AND     TRSP_MOD_CD         = v_trsp_mod_cd
    AND     NVL(DELT_FLG, 'N')  = 'N'
    ;


    IF r_lnk_dist = 0 THEN
      SELECT  NVL(MIN(DECODE(DIST_UT_CD, 'M', 1.6093, 1) * LNK_DIST), 0)
      INTO    r_lnk_dist
      FROM    PRD_INLND_EACH_LNK
      WHERE   LNK_ORG_NOD_CD      LIKE SUBSTR(v_fm_nod_cd, 1, 5) || '%'
      AND     LNK_DEST_NOD_CD     LIKE SUBSTR(v_to_nod_cd, 1, 5) || '%'
      AND     TRSP_MOD_CD         = v_trsp_mod_cd
      AND     NVL(DELT_FLG, 'N')  = 'N'
      ;
    END IF  ;

    IF r_lnk_dist = 0 THEN
      SELECT  NVL(MIN(DECODE(DIST_UT_CD, 'M', 1.6093, 1) * LNK_DIST), 0)
      INTO    r_lnk_dist
      FROM    PRD_INLND_EACH_LNK
      WHERE   LNK_ORG_NOD_CD      LIKE SUBSTR(v_to_nod_cd, 1, 5) || '%'
      AND     LNK_DEST_NOD_CD     LIKE SUBSTR(v_fm_nod_cd, 1, 5) || '%'
      AND     TRSP_MOD_CD         = v_trsp_mod_cd
      AND     NVL(DELT_FLG, 'N')  = 'N'
      ;
    END IF  ;

  END IF  ;

  RETURN r_lnk_dist ;

END HOM_GET_APPX_LNK_DIST_FNC
;
/

