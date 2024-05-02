CREATE OR REPLACE FUNCTION OPUSADM.HOM_GET_ALL_VVD_FNC
(
  v_lnk_knt           IN NUMBER   ,
  v_vps_eta_dt        IN DATE     ,
  v_ib_org_nod_cd     IN VARCHAR2 ,
  v_n2nd_pol_cd       IN VARCHAR2 ,
  v_n2nd_pod_cd       IN VARCHAR2 ,
  v_n2nd_lane_cd      IN VARCHAR2 ,
  v_n2nd_lane_fdr_flg IN VARCHAR2 ,
  v_n3rd_pol_cd       IN VARCHAR2 ,
  v_n3rd_pod_cd       IN VARCHAR2 ,
  v_n3rd_lane_cd      IN VARCHAR2 ,
  v_n3rd_lane_fdr_flg IN VARCHAR2 ,
  v_n4th_pol_cd       IN VARCHAR2 ,
  v_n4th_pod_cd       IN VARCHAR2 ,
  v_n4th_lane_cd      IN VARCHAR2 ,
  v_n4th_lane_fdr_flg IN VARCHAR2 ,
  v_vps_etd_dt        IN DATE     ,    --20160126 JKLIM ADD
  v_n1st_pod_cd       IN VARCHAR2 ,    --20160126 JKLIM ADD
  v_n1st_lane_cd      IN VARCHAR2      --20160126 JKLIM ADD
)

/*******************************************************************************
   1. Object Name      :  HOM_GET_ALL_VVD_FNC
   2. Version          :  1.0
   3. Create Date      :  2011.09.01
   4. Sub System       :  HOM
   5. Author           :  류선우
   6. Description      :  Ocean Route 를 기준으로, First VVD 다음에 연결될 수 있는 2nd, 3rd, 4th VVD 정보를 구하는 FUNCTION
   7. Revision History :  2011.09.01 류선우 최초 생성
                          2011.09.22 변수 Size 조정
                          2013.08.13 NEXT를 찾을때 DWELL 시간(6->12)을 줘서 찾음 (ts_hrs=12)
                          20160126 JKLIM : Vessel Connect Time Management LOGID ADD

*******************************************************************************/

    RETURN VARCHAR2

    AUTHID  CURRENT_USER

IS

  row_split     VARCHAR2(2)     ;
  col_split     VARCHAR2(2)     ;

  r_vvd_str     VARCHAR2(3000)  ;
  ts_hrs        NUMBER(6)       ;
  st_dt         DATE            ;
  ib_org_nod_cd VARCHAR2(7)     ;

  rtn_str       VARCHAR2(1000)   ;

  TS1_BUF_HR  NUMBER := NULL ;    --20160126 JKLIM ADD
  TS2_BUF_HR  NUMBER := NULL ;    --20160126 JKLIM ADD
  TS3_BUF_HR  NUMBER := NULL ;    --20160126 JKLIM ADD

BEGIN

  row_split   := '@#' ;
  col_split   := '$%' ;

  r_vvd_str   := ''   ;
  ts_hrs      := 12    ;


  IF v_lnk_knt NOT IN ( 2, 3, 4 ) THEN
    RETURN  NULL  ;
  END IF;

  --20160126 JKLIM ADD Start

   SELECT  CNN_BUF_HRS
         INTO  TS1_BUF_HR
         FROM
            (
           SELECT  V.CNN_BUF_HRS
             FROM  PRD_VSL_CNN_TM_MGMT V
            WHERE  V.DCHG_CNT_CD = SUBSTR(v_n1st_pod_cd,1,2)
              AND  SUBSTR(V.DCHG_TML_CD,1,5) =  DECODE(V.DCHG_TML_CD,'ALL','ALL',SUBSTR(v_n1st_pod_cd,1,5))
              AND  V.DCHG_SLAN_CD = DECODE(V.DCHG_SLAN_CD,'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n1st_lane_cd)
                                                                       FROM MDM_VSL_SVC_LANE MVSL
                                                                       WHERE MVSL.VSL_SLAN_CD = v_n1st_lane_cd
                                                                       AND   ROWNUM = 1
                                                                     ),v_n1st_lane_cd) )
              AND  NVL(V.LOD_CNT_CD,'AL')   = DECODE(NVL(V.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(v_n2nd_pol_cd,1,2))
              AND  SUBSTR(NVL(V.LOD_TML_CD,'ALL'),1,5)   =  DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(v_n2nd_pol_cd,1,5))
              AND  NVL(V.LOD_SLAN_CD,'ALL')  = DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n2nd_lane_cd)
                                                                                            FROM MDM_VSL_SVC_LANE MVSL
                                                                                            WHERE MVSL.VSL_SLAN_CD = v_n2nd_lane_cd
                                                                                            AND   ROWNUM = 1
                                                                                           ),v_n2nd_lane_cd) )
              AND  DECODE(V.DCHG_TML_CD,'ALL',10000,0) + DECODE(V.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                   DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                = (
                  SELECT MIN ( DECODE(V2.DCHG_TML_CD,'ALL',10000,0) + DECODE(V2.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V2.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                               DECODE(NVL(V2.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V2.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                               )
                    FROM PRD_VSL_CNN_TM_MGMT V2
                   WHERE V2.DCHG_CNT_CD = V.DCHG_CNT_CD
                     AND  SUBSTR(V2.DCHG_TML_CD,1,5) =  DECODE(V2.DCHG_TML_CD,'ALL','ALL',SUBSTR(v_n1st_pod_cd,1,5))
                     AND  V2.DCHG_SLAN_CD = DECODE(V2.DCHG_SLAN_CD,'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n1st_lane_cd)
                                                                                FROM MDM_VSL_SVC_LANE MVSL
                                                                                WHERE MVSL.VSL_SLAN_CD = v_n1st_lane_cd
                                                                                AND   ROWNUM = 1
                                                                               ),v_n1st_lane_cd) )
                     AND  NVL(V2.LOD_CNT_CD,'AL')   = DECODE(NVL(V2.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(v_n2nd_pol_cd,1,2))
                     AND  SUBSTR(NVL(V2.LOD_TML_CD,'ALL'),1,5)   =  DECODE(NVL(V2.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(v_n2nd_pol_cd,1,5))
                     AND  NVL(V2.LOD_SLAN_CD,'ALL')  = DECODE(NVL(V2.LOD_SLAN_CD,'ALL'),'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n2nd_lane_cd)
                                                                                                      FROM MDM_VSL_SVC_LANE MVSL
                                                                                                      WHERE MVSL.VSL_SLAN_CD = v_n2nd_lane_cd
                                                                                                      AND   ROWNUM = 1
                                                                                                     ),v_n2nd_lane_cd) )
                   )
             UNION ALL
             SELECT 12 FROM DUAL
            )
            WHERE ROWNUM =1
          ;

         -- DBMS_OUTPUT.PUT_LINE('TS1_BUF_HR'||TS1_BUF_HR) ;

       SELECT  CNN_BUF_HRS
         INTO  TS2_BUF_HR
         FROM
            (
           SELECT  V.CNN_BUF_HRS
             FROM  PRD_VSL_CNN_TM_MGMT V
            WHERE  V.DCHG_CNT_CD = SUBSTR(v_n2nd_pod_cd,1,2)
              AND  SUBSTR(V.DCHG_TML_CD,1,5) =  DECODE(V.DCHG_TML_CD,'ALL','ALL',SUBSTR(v_n2nd_pod_cd,1,5))
              AND  V.DCHG_SLAN_CD = DECODE(V.DCHG_SLAN_CD,'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n2nd_lane_cd)
                                                                       FROM MDM_VSL_SVC_LANE MVSL
                                                                       WHERE MVSL.VSL_SLAN_CD = v_n2nd_lane_cd
                                                                       AND   ROWNUM = 1
                                                                     ),v_n2nd_lane_cd) )
              AND  NVL(V.LOD_CNT_CD,'AL')   = DECODE(NVL(V.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(v_n3rd_pol_cd,1,2))
              AND  SUBSTR(NVL(V.LOD_TML_CD,'ALL'),1,5)   =  DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(v_n3rd_pol_cd,1,5))
              AND  NVL(V.LOD_SLAN_CD,'ALL')  = DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n3rd_lane_cd)
                                                                                            FROM MDM_VSL_SVC_LANE MVSL
                                                                                            WHERE MVSL.VSL_SLAN_CD = v_n3rd_lane_cd
                                                                                            AND   ROWNUM = 1
                                                                                           ),v_n3rd_lane_cd) )
              AND  DECODE(V.DCHG_TML_CD,'ALL',10000,0) + DECODE(V.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                   DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                = (
                  SELECT MIN ( DECODE(V2.DCHG_TML_CD,'ALL',10000,0) + DECODE(V2.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V2.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                               DECODE(NVL(V2.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V2.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                               )
                    FROM PRD_VSL_CNN_TM_MGMT V2
                   WHERE V2.DCHG_CNT_CD = V.DCHG_CNT_CD
                     AND  SUBSTR(V.DCHG_TML_CD,1,5) =  DECODE(V.DCHG_TML_CD,'ALL','ALL',SUBSTR(v_n2nd_pod_cd,1,5))
                     AND  V.DCHG_SLAN_CD = DECODE(V.DCHG_SLAN_CD,'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n2nd_lane_cd)
                                                                                FROM MDM_VSL_SVC_LANE MVSL
                                                                                WHERE MVSL.VSL_SLAN_CD = v_n2nd_lane_cd
                                                                                AND   ROWNUM = 1
                                                                               ),v_n2nd_lane_cd) )
                     AND  NVL(V.LOD_CNT_CD,'AL')   = DECODE(NVL(V.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(v_n3rd_pol_cd,1,2))
                     AND  SUBSTR(NVL(V.LOD_TML_CD,'ALL'),1,5)   =  DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(v_n3rd_pol_cd,1,5))
                     AND  NVL(V.LOD_SLAN_CD,'ALL')  = DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n3rd_lane_cd)
                                                                                                      FROM MDM_VSL_SVC_LANE MVSL
                                                                                                      WHERE MVSL.VSL_SLAN_CD = v_n3rd_lane_cd
                                                                                                      AND   ROWNUM = 1
                                                                                                     ),v_n3rd_lane_cd) )
                   )
             UNION ALL
             SELECT 12 FROM DUAL
            )
            WHERE ROWNUM =1
          ;

        --  DBMS_OUTPUT.PUT_LINE('3333') ;

       SELECT  CNN_BUF_HRS
         INTO  TS3_BUF_HR
         FROM
            (
           SELECT  V.CNN_BUF_HRS
             FROM  PRD_VSL_CNN_TM_MGMT V
            WHERE  V.DCHG_CNT_CD = SUBSTR(v_n3rd_pod_cd,1,2)
              AND  SUBSTR(V.DCHG_TML_CD,1,5) =  DECODE(V.DCHG_TML_CD,'ALL','ALL',SUBSTR(v_n3rd_pod_cd,1,5))
              AND  V.DCHG_SLAN_CD = DECODE(V.DCHG_SLAN_CD,'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n3rd_lane_cd)
                                                                       FROM MDM_VSL_SVC_LANE MVSL
                                                                       WHERE MVSL.VSL_SLAN_CD = v_n3rd_lane_cd
                                                                       AND   ROWNUM = 1
                                                                     ),v_n3rd_lane_cd) )
              AND  NVL(V.LOD_CNT_CD,'AL')   = DECODE(NVL(V.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(v_n4th_pol_cd,1,2))
              AND  SUBSTR(NVL(V.LOD_TML_CD,'ALL'),1,5)   =  DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(v_n4th_pol_cd,1,5))
              AND  NVL(V.LOD_SLAN_CD,'ALL')  = DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n4th_lane_cd)
                                                                                            FROM MDM_VSL_SVC_LANE MVSL
                                                                                            WHERE MVSL.VSL_SLAN_CD = v_n4th_lane_cd
                                                                                            AND   ROWNUM = 1
                                                                                           ),v_n4th_lane_cd) )
              AND  DECODE(V.DCHG_TML_CD,'ALL',10000,0) + DECODE(V.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                   DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                = (
                  SELECT MIN ( DECODE(V2.DCHG_TML_CD,'ALL',10000,0) + DECODE(V2.DCHG_SLAN_CD,'ALL',1000,0) + DECODE(NVL(V2.LOD_CNT_CD,'ALL'),'ALL',100,0) +
                               DECODE(NVL(V2.LOD_TML_CD,'ALL'),'ALL',10,0) + DECODE(NVL(V2.LOD_SLAN_CD,'ALL'),'ALL',1,0)
                               )
                    FROM PRD_VSL_CNN_TM_MGMT V2
                   WHERE V2.DCHG_CNT_CD = V.DCHG_CNT_CD
                     AND  SUBSTR(V.DCHG_TML_CD,1,5) =  DECODE(V.DCHG_TML_CD,'ALL','ALL',SUBSTR(v_n3rd_pod_cd,1,5))
                     AND  V.DCHG_SLAN_CD = DECODE(V.DCHG_SLAN_CD,'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n3rd_lane_cd)
                                                                                FROM MDM_VSL_SVC_LANE MVSL
                                                                                WHERE MVSL.VSL_SLAN_CD = v_n3rd_lane_cd
                                                                                AND   ROWNUM = 1
                                                                               ),v_n3rd_lane_cd) )
                     AND  NVL(V.LOD_CNT_CD,'AL')   = DECODE(NVL(V.LOD_CNT_CD,'AL'),'AL','AL',SUBSTR(v_n4th_pol_cd,1,2))
                     AND  SUBSTR(NVL(V.LOD_TML_CD,'ALL'),1,5)   =  DECODE(NVL(V.LOD_TML_CD,'ALL'),'ALL','ALL',SUBSTR(v_n4th_pol_cd,1,5))
                     AND  NVL(V.LOD_SLAN_CD,'ALL')  = DECODE(NVL(V.LOD_SLAN_CD,'ALL'),'ALL','ALL',NVL((SELECT DECODE(MVSL.VSL_SVC_TP_CD,'O','FDR',v_n4th_lane_cd)
                                                                                                      FROM MDM_VSL_SVC_LANE MVSL
                                                                                                      WHERE MVSL.VSL_SLAN_CD = v_n4th_lane_cd
                                                                                                      AND   ROWNUM = 1
                                                                                                     ),v_n4th_lane_cd) )
                   )
             UNION ALL
             SELECT 12 FROM DUAL
            )
            WHERE ROWNUM =1
          ;

  IF TS1_BUF_HR = NULL THEN
      TS1_BUF_HR := 12 ;
  END IF ;

  IF TS2_BUF_HR = NULL THEN
      TS2_BUF_HR := 12 ;
  END IF ;

  IF TS3_BUF_HR = NULL THEN
      TS3_BUF_HR := 12 ;
  END IF ;

  --20160126 JKLIM ADD end


  st_dt       := v_vps_etd_dt + ( TS1_BUF_HR / 24 ) ; -- 20160126 JKLIM v_vps_eta_dt -> v_vps_etd_dt

  ib_org_nod_cd  := '' ;
  IF v_lnk_knt = 2 THEN
    ib_org_nod_cd  := v_ib_org_nod_cd  ;
  END IF  ;

  rtn_str     := HOM_GET_NEXT_VVD_FNC(st_dt, v_n2nd_pol_cd, v_n2nd_pod_cd, v_n2nd_lane_cd, v_n2nd_lane_fdr_flg, ib_org_nod_cd) ;

  r_vvd_str := rtn_str ;

  IF v_lnk_knt = 2 OR rtn_str IS NULL THEN
    RETURN  r_vvd_str ;
  END IF;


  SELECT  TO_DATE(COL_1, 'YYYY-MM-DD HH24:MI') + ( TS2_BUF_HR / 24 )
  INTO    st_dt
  FROM    TABLE( HOM_MLT_RTN_PKG.HOM_STR_TO_TBL_FNC(rtn_str, '$%') )
  WHERE   SEQ = 16   /*  20160126 JKLIM SEQ = 16 : POD ETD <- SELQ 8 : POD ETA */
  ;

  ib_org_nod_cd  := '' ;
  IF v_lnk_knt = 3 THEN
    ib_org_nod_cd  := v_ib_org_nod_cd  ;
  END IF  ;

  rtn_str     := HOM_GET_NEXT_VVD_FNC(st_dt, v_n3rd_pol_cd, v_n3rd_pod_cd, v_n3rd_lane_cd, v_n3rd_lane_fdr_flg, ib_org_nod_cd) ;

  IF rtn_str IS NULL THEN
    r_vvd_str := '' ;
  ELSE
    r_vvd_str := r_vvd_str || row_split || rtn_str  ;
  END IF;

  IF v_lnk_knt = 3 OR rtn_str IS NULL THEN
    RETURN  r_vvd_str ;
  END IF;


  SELECT  TO_DATE(COL_1, 'YYYY-MM-DD HH24:MI') + ( TS3_BUF_HR / 24 )
  INTO    st_dt
  FROM    TABLE( HOM_MLT_RTN_PKG.HOM_STR_TO_TBL_FNC(rtn_str, '$%') )
  WHERE   SEQ = 16   /*  20160126 JKLIM SEQ = 16 : POD ETD <- SELQ 8 : POD ETA */
  ;

  ib_org_nod_cd  := '' ;
  IF v_lnk_knt = 4 THEN
    ib_org_nod_cd  := v_ib_org_nod_cd  ;
  END IF  ;

  rtn_str   := HOM_GET_NEXT_VVD_FNC(st_dt, v_n4th_pol_cd, v_n4th_pod_cd, v_n4th_lane_cd, v_n4th_lane_fdr_flg, ib_org_nod_cd) ;

  IF rtn_str IS NULL THEN
    r_vvd_str := '' ;
  ELSE
    r_vvd_str := r_vvd_str || row_split || rtn_str  ;
  END IF;

  RETURN r_vvd_str  ;

END HOM_GET_ALL_VVD_FNC
;
/

