CREATE OR REPLACE FUNCTION OPUSADM.HOM_GET_NEXT_VVD_FNC
(
  v_st_dt         IN DATE     ,
  v_pol_cd        IN VARCHAR2 ,
  v_pod_cd        IN VARCHAR2 ,
  v_lane_cd       IN VARCHAR2 ,
  v_lane_fdr_flg  IN VARCHAR2 ,
  v_ib_org_nod_cd IN VARCHAR2
)

/*******************************************************************************
   1. Object Name      :  HOM_GET_NEXT_VVD_FNC
   2. Version          :  1.0
   3. Create Date      :  2011.09.01
   4. Sub System       :  HOM
   5. Author           :  류선우
   6. Description      :  바로 연결될 수 있는 VVD 를 구하는 FUNCTION
   7. Revision History :  2011.09.01 류선우 최초 생성
                          2011.09.22 Transit Time 계산 로직 수정
                          2011.09.22 POL Yard Code, POD Yard Code, VVD 칼럼 추가
                          2013.08.13 HOM_GET_ALL_VVD_FNC NEXT를 찾을때 DWELL 시간(6->12)을 줘서 찾는것 관련 일부 수정
                                    AND     V1.TURN_PORT_FLG||V1.TURN_PORT_IND_CD NOT IN ('ND', 'NV','NF') -- 20130813 alps 와 같게 
                                    ORDER BY   V1.VPS_ETD_DT , V2.VPS_ETB_DT , VS.VSL_CD -- 20130813 alps 와 같게 
  << RETURN >>
    01> VESSEL NAME
    02> Service Lane Code
    03> POL Location Name
    04> POL Yard Name
    05> VPS_ETD_DT ( POL ETD )
    06> POD Location Name
    07> POD Yard Name
    08> VPS_ETA_DT ( POD ETA )
    09> Transit Time ( DAYS & HOURS )
    10> CARBON EMISSION ( Function 외부에서 Replace 처리를 위하여 상수 문자열을 Return 함 )
    11> POL Yard Code
    12> POD Yard Code
    13> VVD
    14> POL ETB
    15> POD ETB
    16> POD ETD
*******************************************************************************/

    RETURN VARCHAR2

    AUTHID  CURRENT_USER

IS

  col_split       VARCHAR2(2)   ;

  r_vsl_nm        VARCHAR2(200) ;
  r_vsl_slane_cd  VARCHAR2(10)  ;
  r_pol_loc_nm    VARCHAR2(200) ;
  r_pol_yd_nm     VARCHAR2(200) ;
  r_vps_etd_dt    VARCHAR2(20)  ;
  r_pod_loc_nm    VARCHAR2(200) ;
  r_pod_yd_nm     VARCHAR2(200) ;
  r_vps_eta_dt    VARCHAR2(20)  ;
  r_tztm          VARCHAR2(20)  ;
  r_pol_yd_cd     VARCHAR2(7)   ;
  r_pod_yd_cd     VARCHAR2(7)   ;
  r_vvd           VARCHAR2(9)   ;
  r_pol_etb_dt    VARCHAR2(20)  ;
  r_pod_etb_dt    VARCHAR2(20)  ;
  r_pod_etd_dt    VARCHAR2(20)  ;

BEGIN

  col_split       := '$%' ;

  r_vsl_nm        := ''   ;
  r_vsl_slane_cd  := ''   ;
  r_pol_loc_nm    := ''   ;
  r_pol_yd_nm     := ''   ;
  r_vps_etd_dt    := ''   ;
  r_pod_loc_nm    := ''   ;
  r_pod_yd_nm     := ''   ;
  r_vps_eta_dt    := ''   ;
  r_tztm          := ''   ;
  r_pol_yd_cd     := ''   ;
  r_pod_yd_cd     := ''   ;
  r_vvd           := ''   ;
  r_pol_etb_dt    := ''   ;
  r_pod_etb_dt    := ''   ;
  r_pod_etd_dt    := ''   ;

  SELECT  *
  INTO    r_vsl_nm        ,
          r_vsl_slane_cd  ,
          r_pol_loc_nm    ,
          r_pol_yd_nm     ,
          r_vps_etd_dt    ,
          r_pod_loc_nm    ,
          r_pod_yd_nm     ,
          r_vps_eta_dt    ,
          r_tztm          ,
          r_pol_yd_cd     ,
          r_pod_yd_cd     ,
          r_vvd           ,
          r_pol_etb_dt    ,
          r_pod_etb_dt    ,
          r_pod_etd_dt
  FROM    (
          SELECT  /*+ USE_NL(V1 VS V2) ORDERED  */
--                  ( SELECT VSL_ENG_NM FROM MDM_VSL_CNTR A WHERE A.VSL_CD = VS.VSL_CD ) || ' ' || VS.SKD_VOY_NO || VS.SKD_DIR_CD ,
                  VSK_COMMON_PKG.GET_VSL_MASK_CSSM_VOY_DIR_FNC(VS.VSL_CD,VS.SKD_VOY_NO,VS.SKD_DIR_CD,v_pol_cd,'O'),
                  '(' || VS.VSL_SLAN_CD || ')'  ,
                  ( SELECT LOC_NM FROM MDM_LOCATION A WHERE A.LOC_CD = SUBSTR(V1.YD_CD,1,5) ) ,
                  '(' || ( SELECT YD_NM FROM MDM_YARD A WHERE A.YD_CD = V1.YD_CD ) || ')'     ,
                  TO_CHAR(V1.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') ,
                  ( SELECT LOC_NM FROM MDM_LOCATION A WHERE A.LOC_CD = SUBSTR(V2.YD_CD,1,5) ) ,
                  '(' || ( SELECT YD_NM FROM MDM_YARD A WHERE A.YD_CD = V2.YD_CD ) || ')'     ,
                  TO_CHAR(V2.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI')  ,
                  LPAD(TRUNC(V2.VPS_ETA_DT - V1.VPS_ETD_DT), 2, ' ') || ' days '
                    || LPAD(MOD(TRUNC((V2.VPS_ETA_DT - V1.VPS_ETD_DT) * 24), 24), 2, ' ') || ' hours' ,
                  V1.YD_CD  POL_YD_CD ,
                  V2.YD_CD  POD_YD_CD ,
                  VS.VSL_CD || VS.SKD_VOY_NO || VS.SKD_DIR_CD   ,
                  TO_CHAR(V1.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI')  ,
                  TO_CHAR(V2.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI')  ,
                  TO_CHAR(V2.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')
          FROM    VSK_VSL_PORT_SKD  V1  ,
                  VSK_VSL_SKD       VS  ,
                  VSK_VSL_PORT_SKD  V2
          WHERE   VS.VSL_SLAN_CD    = CASE
                                      WHEN  v_lane_fdr_flg = 'Y' AND ( SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE SL WHERE SL.VSL_SLAN_CD = VS.VSL_SLAN_CD ) = 'O'
                                        THEN  VS.VSL_SLAN_CD
                                      ELSE  v_lane_cd
                                      END
          AND     VS.SKD_STS_CD     IN  ( 'ACT', 'RDY' )
          AND     NOT EXISTS  (
                              SELECT  'X'
                              FROM    MDM_VSL_CNTR  VC
                              WHERE   VC.VSL_CLSS_FLG = 'T'
                              AND     VC.VSL_CD       = VS.VSL_CD
                              )
          AND     V1.VSL_CD         = VS.VSL_CD
          AND     V1.SKD_VOY_NO     = VS.SKD_VOY_NO
          AND     V1.SKD_DIR_CD     = VS.SKD_DIR_CD
          AND     V1.VPS_PORT_CD    = v_pol_cd
          AND     NVL(V1.SKD_CNG_STS_CD, ' ') <> 'S'
          --AND     V1.VPS_ETD_DT     BETWEEN v_st_dt AND v_st_dt + 14  /* 최대 14일 이내에는 연결될 수 있는 VVD 를 대상으로 함 */
          AND     V1.VPS_ETA_DT     BETWEEN v_st_dt AND v_st_dt + 14  /*20160808 ETB->ETA PRD 담당자와 협의후 변경 */  
          AND     V2.VSL_CD         = VS.VSL_CD
          AND     V2.SKD_VOY_NO     = VS.SKD_VOY_NO
          AND     V2.SKD_DIR_CD     = VS.SKD_DIR_CD
          AND     V2.VPS_PORT_CD    = v_pod_cd
          AND     V2.YD_CD || ''    = NVL(v_ib_org_nod_cd, V2.YD_CD)  /* 독립적인 INDEX 사용을 막기위하여 || 사용 */
          AND     NVL(V2.SKD_CNG_STS_CD, ' ') <> 'S'
          AND     V1.TURN_PORT_FLG||V1.TURN_PORT_IND_CD NOT IN ('ND', 'NV','NF') -- 20130813 alps 와 같게 
          AND     V1.CLPT_SEQ < V2.CLPT_SEQ
          ORDER BY   V1.VPS_ETD_DT , V2.VPS_ETB_DT , VS.VSL_CD -- 20130813 alps 와 같게 
          )
  WHERE   ROWNUM  = 1
  ;

  RETURN  r_vsl_nm                || col_split ||
          r_vsl_slane_cd          || col_split ||
          r_pol_loc_nm            || col_split ||
          r_pol_yd_nm             || col_split ||
          r_vps_etd_dt            || col_split ||
          r_pod_loc_nm            || col_split ||
          r_pod_yd_nm             || col_split ||
          r_vps_eta_dt            || col_split ||
          r_tztm                  || col_split ||
          'CARBON_EMISSION_VALUE' || col_split ||
          r_pol_yd_cd             || col_split ||
          r_pod_yd_cd             || col_split ||
          r_vvd                   || col_split ||
          r_pol_etb_dt            || col_split ||
          r_pod_etb_dt            || col_split ||
          r_pod_etd_dt
          ;

  EXCEPTION
  WHEN  NO_DATA_FOUND THEN


    IF v_lane_fdr_flg = 'Y' THEN

      SELECT  'Feeder'        ,
              ''              ,
              ( SELECT LOC_NM FROM MDM_LOCATION A WHERE A.LOC_CD = SUBSTR(POL_YD_CD,1,5) )  ,
              '(' || ( SELECT YD_NM FROM MDM_YARD A WHERE A.YD_CD = POL_YD_CD ) || ')'      ,
              TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')   ,
              ( SELECT LOC_NM FROM MDM_LOCATION A WHERE A.LOC_CD = SUBSTR(POD_YD_CD,1,5) )  ,
              '(' || ( SELECT YD_NM FROM MDM_YARD A WHERE A.YD_CD = POD_YD_CD ) || ')'      ,
              TO_CHAR(VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') ,
              LPAD(TRUNC(VPS_ETA_DT - VPS_ETD_DT), 2, ' ') || ' days '
                || LPAD(MOD(TRUNC((VPS_ETA_DT - VPS_ETD_DT) * 24), 24), 2, ' ') || ' hours' ,
              POL_YD_CD       ,
              POD_YD_CD       ,
              ''              ,
              ''              ,
              ''              ,
              ''
      INTO    r_vsl_nm        ,
              r_vsl_slane_cd  ,
              r_pol_loc_nm    ,
              r_pol_yd_nm     ,
              r_vps_etd_dt    ,
              r_pod_loc_nm    ,
              r_pod_yd_nm     ,
              r_vps_eta_dt    ,
              r_tztm          ,
              r_pol_yd_cd     ,
              r_pod_yd_cd     ,
              r_vvd           ,
              r_pol_etb_dt    ,
              r_pod_etb_dt    ,
              r_pod_etd_dt
      FROM    (
              SELECT  *
              FROM    (
                      SELECT  VSL_SLAN_CD               ,
                              (
                              SELECT  TML_CD
                              FROM    PRD_PORT_TML_MTX  TM
                              WHERE   TM.PORT_CD      = FL.LNK_ORG_LOC_CD
                              AND     TM.VSL_SLAN_CD  = FL.VSL_SLAN_CD
                              AND     TM.SKD_DIR_CD   = FL.SKD_DIR_CD
                              AND     ROWNUM          = 1
                              ) POL_YD_CD               ,
                              (
                              SELECT  NVL(v_ib_org_nod_cd, TM.TML_CD)
                              FROM    PRD_PORT_TML_MTX  TM
                              WHERE   TM.PORT_CD      = FL.LNK_DEST_LOC_CD
                              AND     TM.VSL_SLAN_CD  = FL.VSL_SLAN_CD
                              AND     TM.SKD_DIR_CD   = FL.SKD_DIR_CD
                              AND     ROWNUM          = 1
                              ) POD_YD_CD               ,
                              CASE
                              WHEN ST_DAY = TO_CHAR(v_st_dt, 'D') AND TO_CHAR(v_st_dt, 'HH24') < ST_HRS
                                THEN TRUNC(v_st_dt) + (7 * RO.WK_NO) + (ST_HRS / 24)
                              ELSE TRUNC(NEXT_DAY(v_st_dt, FL.ST_DAY)) + (7 * RO.WK_NO) + (ST_HRS / 24)
                              END VPS_ETD_DT            ,
                              CASE
                              WHEN ST_DAY = TO_CHAR(v_st_dt, 'D') AND TO_CHAR(v_st_dt, 'HH24') < ST_HRS
                                THEN TRUNC(v_st_dt) + (7 * RO.WK_NO) + (ST_HRS / 24)
                              ELSE TRUNC(NEXT_DAY(v_st_dt, FL.ST_DAY)) + (7 * RO.WK_NO) + (ST_HRS / 24)
                              END + ( TZTM_HRS / 24 )
                                VPS_ETA_DT
                      FROM    (
                              SELECT  DECODE(RO.ROW_LVL ,
                                        1, DECODE(FL.SUN_ST_FLG, 'Y', 1),
                                        2, DECODE(FL.MON_ST_FLG, 'Y', 2),
                                        3, DECODE(FL.TUE_ST_FLG, 'Y', 3),
                                        4, DECODE(FL.WED_ST_FLG, 'Y', 4),
                                        5, DECODE(FL.THU_ST_FLG, 'Y', 5),
                                        6, DECODE(FL.FRI_ST_FLG, 'Y', 6),
                                        7, DECODE(FL.SAT_ST_FLG, 'Y', 7)
                                      ) ST_DAY              ,
                                      FL.TZTM_HRS           ,
                                      FL.VSL_SLAN_CD        ,
                                      FL.SKD_DIR_CD         ,
                                      FL.VNDR_SEQ           ,
                                      FL.LNK_ORG_LOC_CD     ,
                                      FL.LNK_DEST_LOC_CD    ,
                                      '18' ST_HRS               -- 해당일 18시 출발
                              FROM    PRD_FDR_LNK   FL  ,
                                      ( SELECT LEVEL ROW_LVL FROM DUAL CONNECT BY LEVEL <= 7 )  RO
                              WHERE   FL.LNK_ORG_LOC_CD     = v_pol_cd
                              AND     FL.LNK_DEST_LOC_CD    = v_pod_cd
                              AND     FL.DELT_FLG           = 'N'
                              AND     EXISTS  (
                                              SELECT  'X'
                                              FROM    PRD_PORT_TML_MTX  TM
                                              WHERE   TM.PORT_CD      = FL.LNK_DEST_LOC_CD
                                              AND     TM.VSL_SLAN_CD  = FL.VSL_SLAN_CD
                                              AND     TM.SKD_DIR_CD   = FL.SKD_DIR_CD
                                              AND     TM.TML_CD       = NVL(v_ib_org_nod_cd, TM.TML_CD)
                                              )
                              ) FL  ,
                              ( /* 최대 14일 이내에 연결될 수 있도록 WK_NO 를 SELECT 한다 */
                              SELECT LEVEL - 1 WK_NO FROM DUAL CONNECT BY LEVEL <= 3
                              ) RO
                      WHERE   ST_DAY  IS NOT NULL
                      )
              WHERE   VPS_ETD_DT  BETWEEN v_st_dt AND v_st_dt + 14  /* 최대 14일 이내에는 연결될 수 있는 VVD 를 대상으로 함 */
              ORDER BY
                      VPS_ETD_DT
              )
      WHERE   ROWNUM  = 1
      ;

    RETURN  r_vsl_nm                || col_split ||
            r_vsl_slane_cd          || col_split ||
            r_pol_loc_nm            || col_split ||
            r_pol_yd_nm             || col_split ||
            r_vps_etd_dt            || col_split ||
            r_pod_loc_nm            || col_split ||
            r_pod_yd_nm             || col_split ||
            r_vps_eta_dt            || col_split ||
            r_tztm                  || col_split ||
            'CARBON_EMISSION_VALUE' || col_split ||
            r_pol_yd_cd             || col_split ||
            r_pod_yd_cd             || col_split ||
            r_vvd                   || col_split ||
            r_pol_etb_dt            || col_split ||
            r_pod_etb_dt            || col_split ||
            r_pod_etd_dt
            ;

    ELSE
      RETURN  NULL  ;
    END IF;


END HOM_GET_NEXT_VVD_FNC
;
/

