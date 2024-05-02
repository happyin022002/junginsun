CREATE OR REPLACE PROCEDURE OPUSADM.COA_CREATE_TS_QTY_PRC (
   in_yr            IN       VARCHAR2   -- MANDatory
  ,in_fm_mon        IN       VARCHAR2   -- MANDatory
  ,in_to_mon        IN       VARCHAR2   -- MANDatory
  ,in_fm_wk         IN       VARCHAR2   -- MANDatory
  ,in_to_wk         IN       VARCHAR2   -- MANDatory
  ,in_trd_cd        IN       VARCHAR2   -- Optional
  ,in_rlane_cd      IN       VARCHAR2   -- Optional
  ,in_ioc_cd        IN       VARCHAR2   -- Optional
  ,in_vsl_cd        IN       VARCHAR2   -- Optional
  ,in_skd_voy_no    IN       VARCHAR2   -- Optional
  ,in_dir_cd        IN       VARCHAR2   -- Optional
  ,in_user_id       IN       VARCHAR2   -- Input User ID
  ,out_error_code   OUT      VARCHAR2
  ,out_error_msg    OUT      VARCHAR2
)
Authid current_user
IS
   /******************************************************************************
      목적: TS항차 고정비 배부용 물량생성
            COA_MON_VVD, COA_RGST_BKG, COA_BKG_REV_DTL --> COA_LANE_TS_QTY

      설명: TS 노선의 선복비용을 REV LANE 으로 이전 하기 위해 TS 고정비 배부를 한다.
            1단계-수송량 기준(항차당 실제 선복활용)
            2단계-선복약정기준(연간사업계획, 약정 초과달성 노선 배부에서 제외함)     
  
   ******************************************************************************/


   ------------------------------[ 변수선언부             ]-----------------------
   v_commit_unit     PLS_INTEGER     := 10000;
   v_read_count      NUMBER (10)     := 0;
   /** 작업로그 관련 변수선언 **/
   v_status_msg      VARCHAR2 (1000);
   /* 오류 변수 선언 */
   vvd_cre_error     EXCEPTION;
------------------------------- [ 업무로직 구현부] -------------------------------
BEGIN
   enis_log_prc (SYSDATE, 'COA_CREATE_TS_QTY_PRC', '[V.20110615]', NULL);
   enis_log_prc (SYSDATE, 'COA_CREATE_TS_QTY_PRC', 'input param : Year:['|| in_yr 
                                                    ||'],WK:[' || in_fm_wk  ||'~'|| in_to_wk 
                                                    ||'],MON:['|| in_fm_mon ||'~'|| in_to_mon 
                                                    ||'],trd:['|| in_trd_cd 
                                                    ||'],rlane:['|| in_rlane_cd 
                                                    ||'],ioc:['|| in_ioc_cd 
                                                    ||'],vsl:['|| in_vsl_cd 
                                                    ||'],voy:['|| in_skd_voy_no 
                                                    ||'],dir:['|| in_dir_cd 
                                                    ||'],userid:['|| in_user_id 
                                                    ||']',NULL); 
      /** 시작일시 설정 **/
   --   v_mig_st_dt := sysdate;

   -- 기존 TS QTY 삭제
   DELETE FROM coa_lane_ts_qty
         WHERE EXISTS (
                  SELECT rlane_cd
                        ,ioc_cd
                        ,trd_cd
                        ,vsl_cd
                        ,skd_voy_no
                        ,dir_cd
                    FROM coa_mon_vvd
                   WHERE fm_rlane_cd = rlane_cd
                     AND fm_ioc_cd = ioc_cd
                     AND fm_trd_cd = trd_cd
                     AND fm_vsl_cd = vsl_cd
                     AND fm_skd_voy_no = skd_voy_no
                     AND fm_skd_dir_cd = dir_cd
                     AND sls_yrmon LIKE in_yr || '%'
                     AND cost_wk BETWEEN in_fm_wk AND in_to_wk);

   -- TS QTY 생성
   -- 실제 REV_VVD 에 300 QTY 가 있다면 VVD1에서 100 QTY, VDD2 에서 200 QTY 가 왔을것이다.
   -- 하지만 로직상 VVD1-300, VVD2-300 이렇게 들어간다. 이상하다.
   INSERT INTO coa_lane_ts_qty
               (fm_rlane_cd
               ,fm_ioc_cd
               ,fm_trd_cd
               ,fm_vsl_cd
               ,fm_skd_voy_no
               ,fm_skd_dir_cd
               ,to_rlane_cd
               ,to_ioc_cd
               ,to_trd_cd
               ,to_vsl_cd
               ,to_skd_voy_no
               ,to_skd_dir_cd
               ,ts_qty
               ,ts_rto
               ,cre_usr_id
               ,cre_dt
               ,upd_usr_id
               ,upd_dt
               )
      SELECT /*+  ORDERED NO_MERGE(d1) */ 
             d2.fm_rlane
            ,d2.fm_ioc
            ,d2.fm_trd_cd
--            ,d2.fm_rev_vvd
            ,SUBSTR (d2.fm_rev_vvd, 1, 4) fm_vsl_cd
            ,SUBSTR (d2.fm_rev_vvd, 5, 4) fm_skd_voy_no
            ,SUBSTR (d2.fm_rev_vvd, 9, 1) fm_skd_dir_cd
            ,d2.to_rlane
            ,d2.to_ioc
            ,d2.to_trd_cd
--            ,d2.to_rev_vvd
            ,SUBSTR (d2.to_rev_vvd, 1, 4) to_vsl_cd
            ,SUBSTR (d2.to_rev_vvd, 5, 4) to_skd_voy_no
            ,SUBSTR (d2.to_rev_vvd, 9, 1) to_skd_dir_cd
            ,d2.ts_qty
            --FM RLANE, IOC, TRD, VVD  T/S QTY 비율
            ,ratio_to_report (d2.ts_qty) OVER (PARTITION BY d2.fm_trd_cd, d2.fm_ioc, d2.fm_rlane, d2.fm_rev_vvd) rto
            ,in_user_id
            ,SYSDATE
            ,in_user_id
            ,SYSDATE            
        FROM 
              -- TS 대상 VVD 선정 (Asia Intra 구간 VVD)    2007.09.17 BY LHI
             (SELECT a.cost_wk,
                     a.trd_cd
                    ,a.ioc_cd
                    ,a.rlane_cd
                    ,a.vsl_cd
                    ,a.skd_voy_no
                    ,a.dir_cd
                FROM coa_mon_vvd a, coa_lane_rgst b
               WHERE b.intr_asia_flg      = 'Y'
                 AND NVL(a.delt_flg, 'N') = 'N'
                 AND NVL(b.delt_flg, 'N') = 'N'
                 AND substr(a.sls_yrmon,1,4)||a.cost_wk between in_yr||in_fm_wk and in_yr||in_to_wk
                 AND a.trd_cd             = b.trd_cd
                 AND a.rlane_cd           = b.rlane_cd
                 AND a.dir_cd             = b.dir_cd
                 AND a.ioc_cd             = b.ioc_cd
            ) d1             
           ,(
              -- 실제 전체 TS한 FM VVD - TO VVD의 물량 생성 2007.09.17 BY LHI
              -- 각 FM VVD(VVD1,VVD2,VVD3,VVD4)가 T/S한 물량
              SELECT   DECODE (c2.NO, 1, c1.trd1, 2, c1.trd2, 3, c1.trd3, 4, c1.trd4) fm_trd_cd   -- FROM (열을 행의 바꿈)
                      -- ALX 노선의 로컬물량을 잡기 위한 예외처리 추가 2010.05.10
                      ,DECODE (DECODE(c2.NO, 1, c1.rlane1, 2, c1.rlane2, 3, c1.rlane3, 4, c1.rlane4),'ALXIA','I'
                               , DECODE(c2.NO, 1, c1.ioc1, 2, c1.ioc2, 3, c1.ioc3, 4, c1.ioc4)) fm_ioc
                      ,DECODE (c2.NO, 1, c1.rlane1, 2, c1.rlane2, 3, c1.rlane3, 4, c1.rlane4) fm_rlane
                      ,DECODE (c2.NO, 1, c1.vvd1, 2, c1.vvd2, 3, c1.vvd3, 4, c1.vvd4) fm_rev_vvd
                      ,c1.trd_cd to_trd_cd   -- TO
                      ,c1.ioc_cd to_ioc
                      ,c1.rlane_cd to_rlane
                      ,c1.rev_vvd to_rev_vvd
                      ,SUM (c1.qty) ts_qty   -- 각 FM VVD(VVD1,VVD2,VVD3,VVD4)가 T/S한 물량 합계
                  FROM (SELECT   /*+  ORDERED NO_MERGE(b2) */ 
                                 b2.trd1   -- FROM TRD
                                ,b2.trd2
                                ,b2.trd3
                                ,b2.trd4
                                ,b2.ioc1   -- FROM IOC
                                ,b2.ioc2
                                ,b2.ioc3
                                ,b2.ioc4
                                ,b2.rlane1   -- FROM RLANE
                                ,b2.rlane2
                                ,b2.rlane3
                                ,b2.rlane4
                                ,b2.vvd1   -- FROM VVD
                                ,b2.vvd2
                                ,b2.vvd3
                                ,b2.vvd4
                                ,b2.trd_cd   -- TO
                                ,b2.ioc_cd
                                ,b2.rlane_cd
                                ,b2.rev_vvd
                                ,SUM (DECODE (SUBSTR (b1.cntr_tpsz_cd, -1), '2', b1.bkg_qty, b1.bkg_qty * 2)) qty   -- TEU TPSZ 구분없이 합계
                            FROM (
                                    select distinct
                                          a4.bkg_no
                                         ,a4.n1st_trd_cd trd1   -- FROM TRD
                                         ,a4.n2nd_trd_cd trd2
                                         ,a4.n3rd_trd_cd trd3
                                         ,a4.n4th_trd_cd trd4                                         
                                         ,DECODE (SUBSTR (a4.n1st_ioc_conti_cd, 1, 1)
                                                 ,SUBSTR (a4.n1st_ioc_conti_cd, 2, 1), 'I'
                                                 ,'O'
                                                 ) ioc1   -- I:같은 CONTI, O:다른 CONTI 예)AA-->I, AM-->O
                                         ,DECODE (SUBSTR (a4.n2nd_ioc_conti_cd, 1, 1)
                                                 ,SUBSTR (a4.n2nd_ioc_conti_cd, 2, 1), 'I'
                                                 ,'O'
                                                 ) ioc2
                                         ,DECODE (SUBSTR (a4.n3rd_ioc_conti_cd, 1, 1)
                                                 ,SUBSTR (a4.n3rd_ioc_conti_cd, 2, 1), 'I'
                                                 ,'O'
                                                 ) ioc3
                                         ,DECODE (SUBSTR (a4.n4th_ioc_conti_cd, 1, 1)
                                                 ,SUBSTR (a4.n4th_ioc_conti_cd, 2, 1), 'I'
                                                 ,'O'
                                                 ) ioc4 /*2010.08.20 예외사항 추가*/
                                         ,a4.n1st_rlane_cd rlane1   -- FROM RLANE
                                         ,a4.n2nd_rlane_cd rlane2
                                         ,a4.n3rd_rlane_cd rlane3
                                         ,a4.n4th_rlane_cd rlane4
                                         ,SUBSTR (a4.n1st_finc_vvd_cd, 1, 9) vvd1   -- FROM VVD
                                         ,SUBSTR (a4.n2nd_finc_vvd_cd, 1, 9) vvd2
                                         ,SUBSTR (a4.n3rd_finc_vvd_cd, 1, 9) vvd3
                                         ,SUBSTR (a4.n4th_finc_vvd_cd, 1, 9) vvd4
                                         ,a4.trd_cd   -- TO
                                         ,a4.ioc_cd
                                         ,a4.rlane_cd
                                         ,a4.vsl_cd || a4.skd_voy_no || a4.dir_cd rev_vvd
                                    from coa_mon_vvd a1
                                        ,coa_lane_rgst a2
                                        ,bkg_vvd a3
                                        ,coa_rgst_bkg a4
                                    where 1=1
                                      and a1.trd_cd        = a2.trd_cd
                                      and a1.rlane_cd      = a2.rlane_cd
                                      and a1.ioc_cd        = a2.ioc_cd
                                      and a1.dir_cd        = a2.dir_cd
                                      and a1.delt_flg      = 'N'
                                      and a2.delt_flg      = 'N'
                                      and a2.intr_asia_flg = 'Y'
                                      and substr(a1.sls_yrmon,1,4) || a1.cost_wk between in_yr||in_fm_wk and in_yr||in_to_wk
                                      and a1.vsl_cd        = a3.vsl_cd
                                      and a1.skd_voy_no    = a3.skd_voy_no
                                      and a1.dir_cd        = a3.skd_dir_cd
                                      and a1.rlane_cd      <> 'RBCCO'
                                      and a3.bkg_no        = a4.bkg_no
                                      and a4.bl_no_tp      IN ('M', '0')
                                      and a4.bkg_sts_cd    IN ('F', 'S')   /* <>'X' */
                                      and a4.bkg_cgo_tp_cd <> 'P'
                                 ) b2
                                 ,coa_bkg_rev_dtl b1
                           WHERE b1.bkg_no = b2.bkg_no
                        GROUP BY b2.vvd1
                                ,b2.vvd2
                                ,b2.vvd3
                                ,b2.vvd4
                                ,b2.trd1
                                ,b2.trd2
                                ,b2.trd3
                                ,b2.trd4
                                ,b2.rlane1
                                ,b2.rlane2
                                ,b2.rlane3
                                ,b2.rlane4
                                ,b2.ioc1
                                ,b2.ioc2
                                ,b2.ioc3
                                ,b2.ioc4
                                ,b2.ioc_cd
                                ,b2.trd_cd
                                ,b2.rlane_cd
                                ,b2.rev_vvd
                        ) c1
                      , (SELECT cpy_no AS NO
                           FROM com_cpy_no
                          WHERE cpy_no BETWEEN 1 AND 4) c2   -- 1,2,3,4 번호 4개(열을 행으로 바꾸기 위해)
                 WHERE DECODE (c2.NO, 1, vvd1,   2, vvd2,   3, vvd3,   4, vvd4) IS NOT NULL   -- NULL 아닌 VVD만큼 ROW 생성 예) VVD4 가 NULL이면 3개의 ROW 생성
                   AND DECODE (c2.NO, 1, rlane1, 2, rlane2, 3, rlane3, 4, rlane4) IS NOT NULL
                   AND DECODE (c2.NO, 1, rlane1, 2, rlane2, 3, rlane3, 4, rlane4) <> 'RBCCO'
                   AND DECODE (c2.NO, 1, ioc1,   2, ioc2,   3, ioc3,   4, ioc4) IS NOT NULL
                   AND DECODE (c2.NO, 1, trd1,   2, trd2,   3, trd3,   4, trd4) IS NOT NULL
              GROUP BY DECODE (c2.NO, 1, vvd1,   2, vvd2,   3, vvd3,   4, vvd4)
                      ,DECODE (c2.NO, 1, trd1,   2, trd2,   3, trd3,   4, trd4)
                      ,DECODE (c2.NO, 1, rlane1, 2, rlane2, 3, rlane3, 4, rlane4)
                      ,DECODE (DECODE(c2.NO, 1, rlane1, 2, rlane2, 3, rlane3, 4, rlane4),'ALXIA','I', DECODE(c2.NO, 1, ioc1, 2, ioc2, 3, ioc3, 4, ioc4))
                      ,c1.trd_cd
                      ,c1.ioc_cd
                      ,c1.rlane_cd
                      ,c1.rev_vvd
            ) d2
       -- 전체 FM VVD - TO VVD 중 FM VVD가 Asia Intra 구간만 TS 물량 산정 기준 2007.09.17 BY LHI
      WHERE  SUBSTR (d2.fm_rev_vvd, 1, 4) = d1.vsl_cd
         AND SUBSTR (d2.fm_rev_vvd, 5, 4) = d1.skd_voy_no
         AND SUBSTR (d2.fm_rev_vvd, 9, 1) = d1.dir_cd
         AND d2.fm_rlane                  = d1.rlane_cd
         AND d2.fm_ioc                    = d1.ioc_cd
         AND d2.fm_trd_cd                 = d1.trd_cd
         ;

   -- 전량 TS한 VVD에 대해 LO 물량이 없기때문에 LO 물량 0로 생성 2007.09.17 BY LHI
   INSERT INTO coa_lane_ts_qty
               (fm_rlane_cd
               ,fm_ioc_cd
               ,fm_trd_cd
               ,fm_vsl_cd
               ,fm_skd_voy_no
               ,fm_skd_dir_cd
               ,to_rlane_cd
               ,to_ioc_cd
               ,to_trd_cd
               ,to_vsl_cd
               ,to_skd_voy_no
               ,to_skd_dir_cd
               ,ts_qty
               ,ts_rto
               ,cre_usr_id
               ,cre_dt
               ,upd_usr_id
               ,upd_dt               
               )
      SELECT   a.fm_rlane_cd
              ,a.fm_ioc_cd
              ,a.fm_trd_cd
              ,a.fm_vsl_cd
              ,a.fm_skd_voy_no
              ,a.fm_skd_dir_cd
              ,a.to_rlane_cd
              ,a.to_ioc_cd
              ,a.to_trd_cd
              ,a.to_vsl_cd
              ,a.to_skd_voy_no
              ,a.to_skd_dir_cd
              ,SUM (a.ts_qty) ts_qty
              ,SUM (a.ts_rto) ts_rto
              ,in_user_id
              ,SYSDATE
              ,in_user_id
              ,SYSDATE              
          FROM (
                -- TS 물량
                SELECT /*+ USE_NL(a, b) */
                       b.fm_trd_cd   -- FM TRD
                      ,b.fm_rlane_cd
                      ,b.fm_ioc_cd
                      ,b.fm_vsl_cd
                      ,b.fm_skd_voy_no
                      ,b.fm_skd_dir_cd
                      ,b.to_trd_cd   -- TO TRD
                      ,b.to_rlane_cd
                      ,b.to_ioc_cd
                      ,b.to_vsl_cd
                      ,b.to_skd_voy_no
                      ,b.to_skd_dir_cd
                      ,b.ts_qty
                      ,b.ts_rto
                  FROM coa_mon_vvd a, coa_lane_ts_qty b
                 WHERE a.trd_cd     = b.fm_trd_cd
                   AND a.rlane_cd   = b.fm_rlane_cd
                   AND a.ioc_cd     = b.fm_ioc_cd
                   AND a.vsl_cd     = b.fm_vsl_cd
                   AND a.skd_voy_no = b.fm_skd_voy_no
                   AND a.dir_cd     = b.fm_skd_dir_cd
                   AND a.sls_yrmon  LIKE in_yr || '%'
                   AND a.cost_wk    BETWEEN in_fm_wk AND in_to_wk
                UNION   -- 중복 제거
                -- LO 물량(삭제후 실행해야 유니크 에러 발생안함)
                SELECT /*+ USE_NL(a, b) */
                       b.fm_trd_cd   -- FM TRD
                      ,b.fm_rlane_cd
                      ,b.fm_ioc_cd
                      ,b.fm_vsl_cd
                      ,b.fm_skd_voy_no
                      ,b.fm_skd_dir_cd
                      ,b.fm_trd_cd   -- FM TRD
                      ,b.fm_rlane_cd
                      ,b.fm_ioc_cd
                      ,b.fm_vsl_cd
                      ,b.fm_skd_voy_no
                      ,b.fm_skd_dir_cd
                      ,0
                      ,0
                  FROM coa_mon_vvd a, coa_lane_ts_qty b
                 WHERE a.trd_cd     = b.fm_trd_cd
                   AND a.rlane_cd   = b.fm_rlane_cd
                   AND a.ioc_cd     = b.fm_ioc_cd
                   AND a.vsl_cd     = b.fm_vsl_cd
                   AND a.skd_voy_no = b.fm_skd_voy_no
                   AND a.dir_cd     = b.fm_skd_dir_cd
                   AND a.sls_yrmon  LIKE in_yr || '%'
                   AND a.cost_wk    BETWEEN in_fm_wk AND in_to_wk) a
              ,coa_lane_ts_qty b
         WHERE a.fm_trd_cd     = b.fm_trd_cd(+)
           AND a.fm_rlane_cd   = b.fm_rlane_cd(+)
           AND a.fm_ioc_cd     = b.fm_ioc_cd(+)
           AND a.fm_vsl_cd     = b.fm_vsl_cd(+)
           AND a.fm_skd_voy_no = b.fm_skd_voy_no(+)
           AND a.fm_skd_dir_cd = b.fm_skd_dir_cd(+)
           AND a.to_trd_cd     = b.to_trd_cd(+)
           AND a.to_rlane_cd   = b.to_rlane_cd(+)
           AND a.to_ioc_cd     = b.to_ioc_cd(+)
           AND a.to_vsl_cd     = b.to_vsl_cd(+)
           AND a.to_skd_voy_no = b.to_skd_voy_no(+)
           AND a.to_skd_dir_cd = b.to_skd_dir_cd(+)
           AND b.fm_trd_cd     IS NULL
      GROUP BY a.fm_rlane_cd
              ,a.fm_ioc_cd
              ,a.fm_trd_cd
              ,a.fm_vsl_cd
              ,a.fm_skd_voy_no
              ,a.fm_skd_dir_cd
              ,a.to_rlane_cd
              ,a.to_ioc_cd
              ,a.to_trd_cd
              ,a.to_vsl_cd
              ,a.to_skd_voy_no
              ,a.to_skd_dir_cd;

   -- BKG QTY Update
   UPDATE coa_mon_vvd c
      SET c.bkg_ttl_qty =
             (SELECT SUM (DECODE (SUBSTR (b.cntr_tpsz_cd, 2, 1), '2', b.bkg_qty, b.bkg_qty * 2))   -- TEU 기준으로 FM WK ~ TO WK 의 VVD 별 물량을 업데이트
                FROM COA_RGST_BKG a, coa_bkg_rev_dtl b
               WHERE a.bkg_no     = b.bkg_no
                 AND a.ioc_cd     = c.ioc_cd
                 AND a.trd_cd     = c.trd_cd
                 AND a.rlane_cd   = c.rlane_cd
                 AND a.vsl_cd     = c.vsl_cd
                 AND a.skd_voy_no = c.skd_voy_no
                 AND a.dir_cd     = c.dir_cd
                 AND a.bl_no_tp   IN ('M', '0')
                 AND a.bkg_sts_cd IN ('F', 'S')   /* <>'X' */
                 AND a.bkg_cgo_tp_cd <> 'P')
    WHERE c.sls_yrmon LIKE in_yr || '%'
      AND c.cost_wk BETWEEN in_fm_wk AND in_to_wk;

   out_error_code := '00000';
   out_error_msg := 'Completed!';
   enis_log_prc (SYSDATE, 'COA_CREATE_TS_QTY_PRC', out_error_msg,NULL);
-------------------------------[ 예외처리부      ]-----------------------
EXCEPTION
   WHEN OTHERS THEN
      out_error_code := SQLCODE;
      out_error_msg := SQLERRM;
      enis_log_prc (SYSDATE, 'COA_CREATE_TS_QTY_PRC', 'Error:' || SQLERRM, NULL);
      RAISE;
END COA_CREATE_TS_QTY_PRC;