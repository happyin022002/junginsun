CREATE OR REPLACE PROCEDURE OPUSADM."COA_CREATE_TS_CTRB_PRC" (
   in_yr           IN       VARCHAR2
  ,in_mon          IN       VARCHAR2
  ,in_wk           IN       VARCHAR2
  ,in_trd_cd       IN       VARCHAR2
  ,in_rlane_cd     IN       VARCHAR2
  ,in_ioc_cd       IN       VARCHAR2
  ,in_vsl_cd       IN       VARCHAR2
  ,in_skd_voy_no   IN       VARCHAR2
  ,in_dir_cd       IN       VARCHAR2
  ,in_usr_id       IN       VARCHAR2
  ,out_err_cd      OUT      VARCHAR2
  ,out_err_msg     OUT      VARCHAR2
)
Authid current_user
IS
   /******************************************************************************
      Name         :   COA_CREATE_TS_CTRB_PRC
      Purpose      :   고정비 배부 생성 로직
      Source       :   coa_mon_vvd,coa_vvd_hir,coa_lane_ts_qty
      Target       :   coa_vvd_hir
      Description  :
         - 용도: 1. 사선 고정비에 대해서 고정비 배부 로직

         - 파라미터: 년,월,주차,trade,revenue lane,ioc,vvd
         - 특이사항
           - Remaining Amount가 없다.
  *************************************************************************************/
   /* 고정비 대상 항차 선정 */
   CURSOR coa_mon_vvd_list_cur IS
      SELECT a1.cost_yrmon as sls_yrmon
            ,a1.trd_cd
            ,a1.rlane_cd
            ,a1.ioc_cd
            ,a1.vsl_cd
            ,a1.skd_voy_no
            ,a1.dir_cd
            ,a1.slan_cd
        FROM coa_mon_vvd a1, coa_lane_rgst a2
       WHERE a1.trd_cd     = a2.trd_cd
         AND a1.rlane_cd   = a2.rlane_cd
         AND a1.dir_cd     = a2.dir_cd
         AND a1.ioc_cd     = a2.ioc_cd
         AND a2.delt_flg   = 'N'
         AND a2.ioc_cd     = 'I'
         AND a2.rlane_cd   <> 'RBCCO'
         AND DECODE(in_mon, NULL, a1.sls_yrmon, a1.cost_yrmon) LIKE in_yr || in_mon || '%'
         AND a1.cost_wk    = NVL(in_wk, a1.cost_wk)
         AND a1.trd_cd     = NVL(in_trd_cd, a1.trd_cd)
         AND a1.rlane_cd   = NVL(in_rlane_cd, a1.rlane_cd)
         AND a1.ioc_cd     = NVL(in_ioc_cd, a1.ioc_cd)
         AND a1.vsl_cd     = NVL(in_vsl_cd, a1.vsl_cd)
         AND a1.skd_voy_no = NVL(in_skd_voy_no, a1.skd_voy_no)
         AND a1.dir_cd     = NVL(in_dir_cd, a1.dir_cd);

   ------------------------------[ 변수선언부             ]-----------------------
   v_log_mod_nm            VARCHAR2(30)  := 'COA_CREATE_TS_CTRB_PRC';
   v_step                  VARCHAR2(100);
   v_stnd_cost_interprc_cd VARCHAR2(10) := '54600000';
------------------------------- [ 업무로직 구현부] -------------------------------
BEGIN
   enis_log_prc('', v_log_mod_nm, '[V.20081229]', NULL);

   /** 고정비 대상을 선정 */
   FOR coa_mon_vvd_list IN coa_mon_vvd_list_cur LOOP
   
      /* Actual Cost */
      UPDATE coa_vvd_hir a
         SET a.n1st_asgn_amt =
                  NVL(a.n1st_asgn_amt, 0)
                + NVL((SELECT SUM(fx_cost_dtrb_amt)
                         FROM coa_fx_amt_dtrb b
                        WHERE b.fm_trd_cd      = coa_mon_vvd_list.trd_cd
                          AND b.fm_ioc_cd      = coa_mon_vvd_list.ioc_cd
                          AND b.fm_rlane_cd    = coa_mon_vvd_list.rlane_cd
                          AND b.fm_vsl_cd      = coa_mon_vvd_list.vsl_cd
                          AND b.fm_skd_voy_no  = coa_mon_vvd_list.skd_voy_no
                          AND b.fm_skd_dir_cd  = coa_mon_vvd_list.dir_cd
                          AND b.locl_ts_sts_cd = 'TS'                         
                          AND a.stnd_cost_cd   = b.stnd_cost_cd)
                     ,0
                     )
            ,a.upd_usr_id = in_usr_id
            ,a.upd_dt     = SYSDATE
       WHERE a.ioc_cd       = coa_mon_vvd_list.ioc_cd
         AND a.rlane_cd     = coa_mon_vvd_list.rlane_cd
         AND a.vsl_cd       = coa_mon_vvd_list.vsl_cd
         AND a.skd_voy_no   = coa_mon_vvd_list.skd_voy_no
         AND a.dir_cd       = coa_mon_vvd_list.dir_cd
         AND a.trd_cd       = coa_mon_vvd_list.trd_cd
         AND a.stnd_cost_cd NOT IN ( v_stnd_cost_interprc_cd )
         ;

      /* Actual Cost */
      UPDATE coa_vvd_hir a
         SET a.n1st_asgn_amt =
                  NVL(a.n1st_asgn_amt, 0)
                - NVL((SELECT amt
                         FROM (SELECT   to_trd_cd
                                       ,to_rlane_cd
                                       ,to_ioc_cd
                                       ,to_vsl_cd
                                       ,to_skd_voy_no
                                       ,to_skd_dir_cd
                                       ,stnd_cost_cd
                                       ,SUM(fx_cost_dtrb_amt) amt
                                   FROM coa_fx_amt_dtrb b
                                  WHERE b.fm_trd_cd      = coa_mon_vvd_list.trd_cd
                                    AND b.fm_ioc_cd      = coa_mon_vvd_list.ioc_cd
                                    AND b.fm_rlane_cd    = coa_mon_vvd_list.rlane_cd
                                    AND b.fm_vsl_cd      = coa_mon_vvd_list.vsl_cd
                                    AND b.fm_skd_voy_no  = coa_mon_vvd_list.skd_voy_no
                                    AND b.fm_skd_dir_cd  = coa_mon_vvd_list.dir_cd
                                    AND b.locl_ts_sts_cd = 'TS'                                    
                                    AND b.stnd_cost_cd NOT IN ( v_stnd_cost_interprc_cd )
                               GROUP BY to_trd_cd, to_rlane_cd, to_ioc_cd, to_vsl_cd, to_skd_voy_no, to_skd_dir_cd, stnd_cost_cd) b
                        WHERE a.trd_cd       = b.to_trd_cd
                          AND a.rlane_cd     = b.to_rlane_cd
                          AND a.ioc_cd       = b.to_ioc_cd
                          AND a.vsl_cd       = b.to_vsl_cd
                          AND a.skd_voy_no   = b.to_skd_voy_no
                          AND a.dir_cd       = b.to_skd_dir_cd
                          AND a.stnd_cost_cd = b.stnd_cost_cd)
                     ,0
                     )
            ,a.upd_usr_id = in_usr_id
            ,a.upd_dt = SYSDATE
       WHERE EXISTS(
                SELECT 'OK'
                  FROM (SELECT   to_trd_cd
                                ,to_rlane_cd
                                ,to_ioc_cd
                                ,to_vsl_cd
                                ,to_skd_voy_no
                                ,to_skd_dir_cd
                                ,stnd_cost_cd
                                ,SUM(fx_cost_dtrb_amt) amt
                            FROM coa_fx_amt_dtrb b
                           WHERE b.fm_trd_cd      = coa_mon_vvd_list.trd_cd
                             AND b.fm_ioc_cd      = coa_mon_vvd_list.ioc_cd
                             AND b.fm_rlane_cd    = coa_mon_vvd_list.rlane_cd
                             AND b.fm_vsl_cd      = coa_mon_vvd_list.vsl_cd
                             AND b.fm_skd_voy_no  = coa_mon_vvd_list.skd_voy_no
                             AND b.fm_skd_dir_cd  = coa_mon_vvd_list.dir_cd
                             AND b.locl_ts_sts_cd = 'TS'                             
                        GROUP BY to_trd_cd, to_rlane_cd, to_ioc_cd, to_vsl_cd, to_skd_voy_no, to_skd_dir_cd, stnd_cost_cd) b
                 WHERE a.trd_cd       = b.to_trd_cd
                   AND a.rlane_cd     = b.to_rlane_cd
                   AND a.ioc_cd       = b.to_ioc_cd
                   AND a.vsl_cd       = b.to_vsl_cd
                   AND a.skd_voy_no   = b.to_skd_voy_no
                   AND a.dir_cd       = b.to_skd_dir_cd
                   AND a.stnd_cost_cd = b.stnd_cost_cd
                )
          AND a.stnd_cost_cd NOT IN ( v_stnd_cost_interprc_cd )
        ;

      UPDATE coa_fx_amt_dtrb
         set fx_cost_dtrb_amt      = 0
            ,ts_uc_amt             = 0
       WHERE fm_trd_cd     = coa_mon_vvd_list.trd_cd
         AND fm_ioc_cd     = coa_mon_vvd_list.ioc_cd
         AND fm_rlane_cd   = coa_mon_vvd_list.rlane_cd
         AND fm_vsl_cd     = coa_mon_vvd_list.vsl_cd
         AND fm_skd_voy_no = coa_mon_vvd_list.skd_voy_no
         AND fm_skd_dir_cd = coa_mon_vvd_list.dir_cd
         AND stnd_cost_cd  NOT IN ( v_stnd_cost_interprc_cd )
       ;


   MERGE INTO coa_fx_amt_dtrb c1
      USING (
         SELECT   e1.fm_trd_cd
                 ,e1.fm_rlane_cd
                 ,e1.fm_ioc_cd
                 ,e1.fm_vsl_cd
                 ,e1.fm_skd_voy_no
                 ,e1.fm_skd_dir_cd
                 ,e1.to_trd_cd
                 ,e1.to_rlane_cd
                 ,e1.to_ioc_cd
                 ,e1.to_vsl_cd
                 ,e1.to_skd_voy_no
                 ,e1.to_skd_dir_cd
                 ,e1.stnd_cost_cd
                 ,e1.locl_ts_sts_cd
                 ,e1.co_slt_uc_amt ts_uc_amt   -- Unit Cost Per Slot
                 ,e1.ts_co_op_amt fx_cost_dtrb_amt   -- Asgn Amt
                 ,in_usr_id cre_usr_id
                 ,SYSDATE   cre_dt
             FROM (SELECT d1.fm_trd_cd
                         ,d1.fm_rlane_cd
                         ,d1.fm_ioc_cd
                         ,d1.fm_vsl_cd
                         ,d1.fm_skd_voy_no
                         ,d1.fm_skd_dir_cd
                         ,d1.to_trd_cd
                         ,d1.to_rlane_cd
                         ,d1.to_ioc_cd
                         ,d1.to_vsl_cd
                         ,d1.to_skd_voy_no
                         ,d1.to_skd_dir_cd
                         ,d1.stnd_cost_cd
                         ,d1.locl_ts_sts_cd
                         ,d1.co_slt_uc_amt   -- Unit Cost Per Slot
                         ,d1.ts_co_op_amt   -- Asgn Amt
                         ,d1.co_op_amt
                     FROM (SELECT   c1.fm_trd_cd
                                   ,c1.fm_rlane_cd
                                   ,c1.fm_ioc_cd
                                   ,c1.fm_vsl_cd
                                   ,c1.fm_skd_voy_no
                                   ,c1.fm_skd_dir_cd
                                   ,c1.to_trd_cd
                                   ,c1.to_rlane_cd
                                   ,c1.to_ioc_cd
                                   ,c1.to_vsl_cd
                                   ,c1.to_skd_voy_no
                                   ,c1.to_skd_dir_cd
                                   ,c1.stnd_cost_cd
                                   ,c1.locl_ts_sts_cd
                                   ,
                                    -- QTY
                                    SUM(NVL(c1.supply_qty, 0)) AS supply_qty
                                   ,SUM(NVL(c1.load_qty, 0)) AS load_qty
                                   ,SUM(NVL(c1.ts_qty, 0)) AS ts_qty
--                                   ,SUM(NVL(c1.cmmt_ts_qty, 0)) AS cmmt_qty   -- -- Cmmt Bse Vol
                                   ,
                                    -- RTO
                                    SUM(NVL(c1.ts_rto, 0)) AS ts_rto
--                                   ,SUM(NVL(c1.ts_rt_amt, 0)) AS cmmt_rto   -- Cmmt Bse Rto
                                   ,
                                    -- U/C
                                    SUM(NVL(c1.co_slt_uc_amt, 0)) AS co_slt_uc_amt   -- Unit Cost Per Slot(공급단가)
                                  
                                   ,SUM(NVL(c1.ts_co_op_amt, 0)) AS ts_co_op_amt   -- Asgn Amt
                                   ,SUM(NVL(c1.co_op_amt, 0)) AS co_op_amt   -- (VVD별)운항변동비고정비
                               FROM (SELECT b1.fm_trd_cd
                                           ,b1.fm_rlane_cd
                                           ,b1.fm_ioc_cd
                                           ,b1.fm_vsl_cd
                                           ,b1.fm_skd_voy_no
                                           ,b1.fm_skd_dir_cd
                                           ,b1.fm_sub_trd_cd
                                           ,b1.to_trd_cd
                                           ,b1.to_rlane_cd
                                           ,b1.to_ioc_cd
                                           ,b1.to_vsl_cd
                                           ,b1.to_skd_voy_no
                                           ,b1.to_skd_dir_cd
                                           ,b4.stnd_cost_cd
                                           ,DECODE(b1.fm_trd_cd || b1.fm_rlane_cd || b1.fm_ioc_cd || b1.fm_vsl_cd || b1.fm_skd_voy_no || b1.fm_skd_dir_cd
                                                  , b1.to_trd_cd || b1.to_rlane_cd || b1.to_ioc_cd || b1.to_vsl_cd || b1.to_skd_voy_no || b1.to_skd_dir_cd, 'LO'
                                                  ,'TS'
                                                  ) AS locl_ts_sts_cd
                                           ,b1.fm_vvd_cnt
                                           ,b1.to_vvd_cnt
                                           ,b1.ts_qty
                                           ,b1.ts_rto   -- 실적 비율
                                           ,NVL(b4.co_sls_amt, 0) * NVL(b1.ts_rto, 0) AS ts_co_op_amt
                                           ,b1.vvd_bsa_capa AS supply_qty   -- 공급 선복량
                                           ,b1.bkg_ttl_qty  AS load_qty   -- 수송 선복량
                                           ,b4.co_sls_amt  AS co_op_amt   -- Company 선박운항비
                                           ,(b4.co_sls_amt / b1.bkg_ttl_qty) AS load_uc_amt   -- Company 선박수송단가 = Company 선박운항비 / 수송량
                                            -- Company Slot 단가 = Company 선박운항비 / Company Slot량
                                           ,(b4.co_sls_amt / DECODE(NVL(b1.vvd_bsa_capa, 0), 0, b1.bkg_ttl_qty, b1.vvd_bsa_capa)) AS co_slt_uc_amt   -- Unit Cost Per Slot
                                       FROM (SELECT a1.fm_trd_cd
                                                   ,a1.fm_rlane_cd
                                                   ,a1.fm_ioc_cd
                                                   ,a1.fm_vsl_cd
                                                   ,a1.fm_skd_voy_no
                                                   ,a1.fm_skd_dir_cd
                                                   ,a2.sub_trd_cd fm_sub_trd_cd
                                                   ,a1.to_trd_cd
                                                   ,a1.to_rlane_cd
                                                   ,a1.to_ioc_cd
                                                   ,a1.to_vsl_cd
                                                   ,a1.to_skd_voy_no
                                                   ,a1.to_skd_dir_cd
                                                   ,a1.ts_qty
                                                   ,a1.ts_rto
                                                   ,a1.fm_vvd_cnt
                                                   ,a1.to_vvd_cnt
                                                   ,
                                                    -- to vvd가 fm vvd로부터 T/S받은 갯수가 2개 이상인 fm vvd일경우
                                                    CASE
                                                       WHEN fm_cnt = SUM(a1.fm_vvd_cnt) OVER(PARTITION BY a1.fm_trd_cd, a1.fm_rlane_cd, a1.fm_ioc_cd, a1.fm_vsl_cd, a1.fm_skd_voy_no, a1.fm_skd_dir_cd, a1.to_trd_cd, a1.to_rlane_cd, a1.to_ioc_cd) THEN fm_vvd_cnt
                                                       ELSE MAX(a1.fm_vvd_cnt) OVER(PARTITION BY fm_trd_cd, fm_rlane_cd, fm_ioc_cd, fm_vsl_cd, fm_skd_voy_no, fm_skd_dir_cd, to_trd_cd, to_rlane_cd, to_ioc_cd)
                                                    END fm_chk
                                                   ,SUM(a1.ts_qty) OVER(PARTITION BY fm_trd_cd, fm_rlane_cd, fm_ioc_cd, fm_vsl_cd, fm_skd_voy_no, fm_skd_dir_cd, to_trd_cd, to_rlane_cd, to_ioc_cd, to_skd_dir_cd) lane_ts_qty
                                                   ,   --한개의 FM VVD가 여러개의 TO VVD에 TS 했을경우 QTY 총 합
                                                    SUM(a1.ts_qty) OVER(PARTITION BY fm_trd_cd, fm_rlane_cd, fm_ioc_cd, fm_skd_dir_cd, to_trd_cd, to_rlane_cd, to_ioc_cd, to_vsl_cd, to_skd_voy_no, to_skd_dir_cd) lane_ts_qty2
                                                   ,   --여러개의 FM VVD가 한개의 TO VVD에 TS 했을경우 QTY 총 합
                                                    SUM(a1.ts_qty) OVER(PARTITION BY fm_trd_cd, fm_rlane_cd, fm_ioc_cd, fm_vsl_cd, fm_skd_voy_no, fm_skd_dir_cd, to_trd_cd, to_rlane_cd, to_ioc_cd, to_skd_dir_cd, fm_vvd_cnt) lane_ts_qty3
                                                   ,   --한개의 FM VVD가 여러개의 TO VVD에 TS 했을경우 QTY 총 합 단 TO VVD 중 여러개의 FM VVD로 부터 TS 받은 VVD의 QTY는 제외
                                                    a2.vvd_bsa_capa
                                                   ,a2.bkg_ttl_qty
                                               FROM (SELECT fm_trd_cd
                                                           ,fm_rlane_cd
                                                           ,fm_ioc_cd
                                                           ,fm_vsl_cd
                                                           ,fm_skd_voy_no
                                                           ,fm_skd_dir_cd
                                                           ,to_trd_cd
                                                           ,to_rlane_cd
                                                           ,to_ioc_cd
                                                           ,to_vsl_cd
                                                           ,to_skd_voy_no
                                                           ,to_skd_dir_cd
                                                           ,ts_qty
                                                           ,ts_rto
                                                           ,
                                                            -- fm trade, rlane에서 to trade, rlane으로 ts한 from vvd의 갯수 구하기
                                                            COUNT(fm_vsl_cd || fm_skd_voy_no || fm_skd_dir_cd) OVER(PARTITION BY fm_trd_cd, fm_rlane_cd, fm_ioc_cd, fm_vsl_cd, fm_skd_voy_no, fm_skd_dir_cd, to_trd_cd, to_rlane_cd, to_ioc_cd) fm_cnt
                                                           ,
                                                            -- to vvd가 fm vvd T/S받은 갯수
                                                            COUNT(DISTINCT fm_vsl_cd || fm_skd_voy_no || fm_skd_dir_cd) OVER(PARTITION BY fm_trd_cd, fm_rlane_cd, fm_ioc_cd, to_trd_cd, to_rlane_cd, to_ioc_cd, to_vsl_cd, to_skd_voy_no, to_skd_dir_cd)
                                                                                                                                                                                                                                                    fm_vvd_cnt
                                                           ,
                                                            -- fm vvd가 to vvd에 T/S한 갯수
                                                            COUNT(DISTINCT to_vsl_cd || to_skd_voy_no || to_skd_dir_cd) OVER(PARTITION BY fm_trd_cd, fm_rlane_cd, fm_ioc_cd, fm_vsl_cd, fm_skd_voy_no, fm_skd_dir_cd, to_trd_cd, to_rlane_cd, to_ioc_cd)
                                                                                                                                                                                                                                                    to_vvd_cnt
                                                       FROM coa_lane_ts_qty
                                                      WHERE (
                                                             to_trd_cd, to_rlane_cd, to_ioc_cd, to_vsl_cd, to_skd_voy_no, to_skd_dir_cd
                                                            )
                                                         IN (
                                                             SELECT
                                                                    to_trd_cd
                                                                   ,to_rlane_cd
                                                                   ,to_ioc_cd
                                                                   ,to_vsl_cd
                                                                   ,to_skd_voy_no
                                                                   ,to_skd_dir_cd
                                                               FROM coa_lane_ts_qty
                                                              WHERE 1=1
                                                                AND fm_trd_cd     = coa_mon_vvd_list.trd_cd
                                                                AND fm_rlane_cd   = coa_mon_vvd_list.rlane_cd
                                                                AND fm_ioc_cd     = coa_mon_vvd_list.ioc_cd
                                                                AND fm_vsl_cd     = coa_mon_vvd_list.vsl_cd
                                                                AND fm_skd_voy_no = coa_mon_vvd_list.skd_voy_no
                                                                AND fm_skd_dir_cd = coa_mon_vvd_list.dir_cd
                                                              )
                                                       ) a1
                                                   ,coa_mon_vvd a2
                                              WHERE 1 = 1
                                                AND a1.fm_trd_cd     = a2.trd_cd
                                                AND a1.fm_rlane_cd   = a2.rlane_cd
                                                AND a1.fm_ioc_cd     = a2.ioc_cd
                                                AND a1.fm_vsl_cd     = a2.vsl_cd
                                                AND a1.fm_skd_voy_no = a2.skd_voy_no
                                                AND a1.fm_skd_dir_cd = a2.dir_cd
                                                AND NVL(a2.delt_flg, 'N') = 'N'

                                            ) b1
                                           ,coa_vvd_hir b4
                                      WHERE b1.fm_trd_cd     = b4.trd_cd -- vvd_hir
                                        AND b1.fm_rlane_cd   = b4.rlane_cd
                                        AND b1.fm_ioc_cd     = b4.ioc_cd
                                        AND b1.fm_vsl_cd     = b4.vsl_cd
                                        AND b1.fm_skd_voy_no = b4.skd_voy_no
                                        AND b1.fm_skd_dir_cd = b4.dir_cd
                                        AND b1.fm_trd_cd     = coa_mon_vvd_list.trd_cd
                                        AND b1.fm_rlane_cd   = coa_mon_vvd_list.rlane_cd
                                        AND b1.fm_ioc_cd     = coa_mon_vvd_list.ioc_cd
                                        AND b1.fm_vsl_cd     = coa_mon_vvd_list.vsl_cd
                                        AND b1.fm_skd_voy_no = coa_mon_vvd_list.skd_voy_no
                                        AND b1.fm_skd_dir_cd = coa_mon_vvd_list.dir_cd
                                        AND b4.stnd_cost_cd  NOT IN ( v_stnd_cost_interprc_cd )
                                        ) c1
                           GROUP BY c1.fm_trd_cd
                                   ,c1.fm_rlane_cd
                                   ,c1.fm_ioc_cd
                                   ,c1.fm_vsl_cd
                                   ,c1.fm_skd_voy_no
                                   ,c1.fm_skd_dir_cd
                                   ,c1.to_trd_cd
                                   ,c1.to_ioc_cd
                                   ,c1.to_rlane_cd
                                   ,c1.to_vsl_cd
                                   ,c1.to_skd_voy_no
                                   ,c1.to_skd_dir_cd
                                   ,c1.stnd_cost_cd
                                   ,c1.locl_ts_sts_cd
                                   ) d1
                  ) e1
         ORDER BY e1.fm_trd_cd, e1.fm_rlane_cd, e1.fm_ioc_cd, e1.fm_vsl_cd, e1.fm_skd_voy_no, e1.fm_skd_dir_cd, e1.locl_ts_sts_cd
                 ,e1.to_trd_cd, e1.to_rlane_cd, e1.to_ioc_cd, e1.to_vsl_cd, e1.to_skd_voy_no, e1.to_skd_dir_cd, e1.stnd_cost_cd
         ) c2
      ON (    c1.fm_trd_cd     = c2.fm_trd_cd
          AND c1.fm_rlane_cd   = c2.fm_rlane_cd
          AND c1.fm_ioc_cd     = c2.fm_ioc_cd
          AND c1.fm_vsl_cd     = c2.fm_vsl_cd
          AND c1.fm_skd_voy_no = c2.fm_skd_voy_no
          AND c1.fm_skd_dir_cd = c2.fm_skd_dir_cd
          AND c1.to_trd_cd     = c2.to_trd_cd
          AND c1.to_rlane_cd   = c2.to_rlane_cd
          AND c1.to_ioc_cd     = c2.to_ioc_cd
          AND c1.to_vsl_cd     = c2.to_vsl_cd
          AND c1.to_skd_voy_no = c2.to_skd_voy_no
          AND c1.to_skd_dir_cd = c2.to_skd_dir_cd
          AND c1.stnd_cost_cd  = c2.stnd_cost_cd          
         )
      WHEN MATCHED THEN
         UPDATE
            SET c1.fx_cost_dtrb_amt     = c2.fx_cost_dtrb_amt
               ,c1.ts_uc_amt            = c2.ts_uc_amt
               ,c1.locl_ts_sts_cd       = c2.locl_ts_sts_cd
               ,c1.upd_usr_id           = c2.cre_usr_id
               ,c1.upd_dt               = SYSDATE
      WHEN NOT MATCHED THEN
         INSERT(c1.fm_trd_cd, c1.fm_rlane_cd, c1.fm_ioc_cd, c1.fm_vsl_cd, c1.fm_skd_voy_no, c1.fm_skd_dir_cd
               ,c1.to_trd_cd, c1.to_rlane_cd, c1.to_ioc_cd, c1.to_vsl_cd, c1.to_skd_voy_no, c1.to_skd_dir_cd, c1.stnd_cost_cd
               ,c1.fx_cost_dtrb_amt, c1.ts_uc_amt, c1.locl_ts_sts_cd
               ,c1.cre_usr_id, c1.cre_dt, c1.upd_usr_id, c1.upd_dt
               
               )
         VALUES(c2.fm_trd_cd, c2.fm_rlane_cd, c2.fm_ioc_cd, c2.fm_vsl_cd, c2.fm_skd_voy_no, c2.fm_skd_dir_cd
               ,c2.to_trd_cd, c2.to_rlane_cd, c2.to_ioc_cd, c2.to_vsl_cd, c2.to_skd_voy_no, c2.to_skd_dir_cd, c2.stnd_cost_cd
               ,c2.fx_cost_dtrb_amt, c2.ts_uc_amt, c2.locl_ts_sts_cd 
               ,c2.cre_usr_id, c2.cre_dt, c2.cre_usr_id, c2.cre_dt
              
               );
   END LOOP;

   /** 결과값을 VVD HIRE에 Insert or Update */
   /* 1. VVD HIRE TABLE에 데이터가 있을 경우
         1-1 : 비목별로 N1ST_ASGN_AMT 컬럼에 UPDATE(+) 한다.
      2. VVD HIRE TABLE에 데이터가 없을 경우
         1-1 : 비목별로 INSERT 한다.
   */
   v_step := '고정비 배부 결과 입력';
   --////////////////////////////////////////////////////////////////////////////////////
   -- From 기준 From VVD 의 ts_co_op_amt 를  n1st_asgn_amt 에서 차감
   --////////////////////////////////////////////////////////////////////////////////////
   MERGE INTO coa_vvd_hir c1
      USING (SELECT   b2.fm_trd_cd
                     ,b2.fm_rlane_cd
                     ,b2.fm_ioc_cd
                     ,b2.fm_vsl_cd
                     ,b2.fm_skd_voy_no
                     ,b2.fm_skd_dir_cd
                     ,b2.stnd_cost_cd
                     ,SUM(b2.fx_cost_dtrb_amt) ts_amt   -- ts_co_op_amt
                 FROM (SELECT a1.trd_cd
                             ,a1.rlane_cd
                             ,a1.ioc_cd
                             ,a1.vsl_cd
                             ,a1.skd_voy_no
                             ,a1.dir_cd
                         FROM coa_mon_vvd a1, coa_lane_rgst a2
                        WHERE a1.trd_cd     = a2.trd_cd
                          AND a1.rlane_cd   = a2.rlane_cd
                          AND a1.dir_cd     = a2.dir_cd
                          AND a1.ioc_cd     = a2.ioc_cd
                          AND NVL(a1.delt_flg, 'N') = 'N'
                          AND DECODE(in_mon, NULL, a1.sls_yrmon, a1.cost_yrmon) LIKE in_yr || in_mon || '%'
                          AND a1.cost_wk    = NVL(in_wk, a1.cost_wk)
                          AND a1.trd_cd     = NVL(in_trd_cd, a1.trd_cd)
                          AND a1.rlane_cd   = NVL(in_rlane_cd, a1.rlane_cd)
                          AND a1.ioc_cd     = NVL(in_ioc_cd, a1.ioc_cd)
                          AND a1.vsl_cd     = NVL(in_vsl_cd, a1.vsl_cd)
                          AND a1.skd_voy_no = NVL(in_skd_voy_no, a1.skd_voy_no)
                          AND a1.dir_cd     = NVL(in_dir_cd, a1.dir_cd)
                          AND a2.delt_flg   = 'N'
                          AND a2.ioc_cd     = 'I'
                          AND a2.rlane_cd   <> 'RBCCO') b1
                     ,coa_fx_amt_dtrb b2
                WHERE b1.trd_cd         = b2.fm_trd_cd
                  AND b1.ioc_cd         = b2.fm_ioc_cd
                  AND b1.rlane_cd       = b2.fm_rlane_cd
                  AND b1.vsl_cd         = b2.fm_vsl_cd
                  AND b1.skd_voy_no     = b2.fm_skd_voy_no
                  AND b1.dir_cd         = b2.fm_skd_dir_cd
                  AND b2.locl_ts_sts_cd = 'TS'                  
                  AND b2.stnd_cost_cd   NOT IN ( v_stnd_cost_interprc_cd )
             GROUP BY b2.fm_trd_cd, b2.fm_rlane_cd, b2.fm_ioc_cd, b2.fm_vsl_cd, b2.fm_skd_voy_no, b2.fm_skd_dir_cd, b2.stnd_cost_cd) c2
      ON (    c1.trd_cd       = c2.fm_trd_cd
          AND c1.rlane_cd     = c2.fm_rlane_cd
          AND c1.ioc_cd       = c2.fm_ioc_cd
          AND c1.vsl_cd       = c2.fm_vsl_cd
          AND c1.skd_voy_no   = c2.fm_skd_voy_no
          AND c1.dir_cd       = c2.fm_skd_dir_cd
          AND c1.stnd_cost_cd = c2.stnd_cost_cd)
      WHEN MATCHED THEN
         UPDATE
            SET c1.n1st_asgn_amt = NVL(c1.n1st_asgn_amt, 0) - NVL(c2.ts_amt, 0)
              , c1.upd_usr_id = in_usr_id
              , c1.upd_dt = SYSDATE
      WHEN NOT MATCHED THEN
         INSERT(c1.trd_cd, c1.rlane_cd, c1.ioc_cd, c1.vsl_cd, c1.skd_voy_no, c1.dir_cd, c1.stnd_cost_cd, c1.ntwk_hir_cost_amt, c1.ts_uc_amt, c1.co_sls_amt, c1.co_amt, c1.n1st_asgn_amt, c1.ipt_asgn_amt, c1.cre_usr_id, c1.cre_dt, c1.upd_usr_id, c1.upd_dt)
         VALUES(c2.fm_trd_cd, c2.fm_rlane_cd, c2.fm_ioc_cd, c2.fm_vsl_cd, c2.fm_skd_voy_no, c2.fm_skd_dir_cd, c2.stnd_cost_cd, 0, 0, 0, 0, c2.ts_amt, 0, in_usr_id, SYSDATE, in_usr_id, SYSDATE);   -- n1st_asgn_amt
         
   --////////////////////////////////////////////////////////////////////////////////////
   -- To 기준 To VVD 의 ts_co_op_amt 를  n1st_asgn_amt 에 부과
   --////////////////////////////////////////////////////////////////////////////////////
   MERGE INTO coa_vvd_hir a
      USING (SELECT   to_trd_cd
                     ,to_rlane_cd
                     ,to_ioc_cd
                     ,to_vsl_cd
                     ,to_skd_voy_no
                     ,to_skd_dir_cd
                     ,stnd_cost_cd
                     ,SUM(fx_cost_dtrb_amt) ts_amt
                 FROM (SELECT a1.trd_cd
                             ,a1.rlane_cd
                             ,a1.ioc_cd
                             ,a1.vsl_cd
                             ,a1.skd_voy_no
                             ,a1.dir_cd
                         FROM coa_mon_vvd a1, coa_lane_rgst a2
                        WHERE a1.trd_cd     = a2.trd_cd
                          AND a1.rlane_cd   = a2.rlane_cd
                          AND a1.dir_cd     = a2.dir_cd
                          AND a1.ioc_cd     = a2.ioc_cd
                          AND NVL(a1.delt_flg, 'N') = 'N'
                          AND DECODE(in_mon, NULL, a1.sls_yrmon, a1.cost_yrmon) LIKE in_yr || in_mon || '%'
                          AND a1.cost_wk    = NVL(in_wk, a1.cost_wk)
                          AND a1.trd_cd     = NVL(in_trd_cd, a1.trd_cd)
                          AND a1.rlane_cd   = NVL(in_rlane_cd, a1.rlane_cd)
                          AND a1.ioc_cd     = NVL(in_ioc_cd, a1.ioc_cd)
                          AND a1.vsl_cd     = NVL(in_vsl_cd, a1.vsl_cd)
                          AND a1.skd_voy_no = NVL(in_skd_voy_no, a1.skd_voy_no)
                          AND a1.dir_cd     = NVL(in_dir_cd, a1.dir_cd)
                          AND a2.delt_flg   = 'N'
                          AND a2.ioc_cd     = 'I'
                          AND a2.rlane_cd   <> 'RBCCO') a
                     ,coa_fx_amt_dtrb b
                WHERE a.trd_cd         = b.fm_trd_cd
                  AND a.ioc_cd         = b.fm_ioc_cd
                  AND a.rlane_cd       = b.fm_rlane_cd
                  AND a.vsl_cd         = b.fm_vsl_cd
                  AND a.skd_voy_no     = b.fm_skd_voy_no
                  AND a.dir_cd         = b.fm_skd_dir_cd
                  AND b.locl_ts_sts_cd = 'TS'
                  AND b.stnd_cost_cd   NOT IN ( v_stnd_cost_interprc_cd )
             GROUP BY to_trd_cd, to_rlane_cd, to_ioc_cd, to_vsl_cd, to_skd_voy_no, to_skd_dir_cd, stnd_cost_cd) b
      ON (    a.trd_cd       = b.to_trd_cd
          AND a.rlane_cd     = b.to_rlane_cd
          AND a.ioc_cd       = b.to_ioc_cd
          AND a.vsl_cd       = b.to_vsl_cd
          AND a.skd_voy_no   = b.to_skd_voy_no
          AND a.dir_cd       = b.to_skd_dir_cd
          AND a.stnd_cost_cd = b.stnd_cost_cd)
      WHEN MATCHED THEN
         UPDATE
            SET a.n1st_asgn_amt = NVL(a.n1st_asgn_amt, 0) + NVL(b.ts_amt, 0)
              , a.upd_usr_id = in_usr_id
              , a.upd_dt = SYSDATE
      WHEN NOT MATCHED THEN
         INSERT(trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, stnd_cost_cd, ntwk_hir_cost_amt, ts_uc_amt, co_sls_amt, co_amt, n1st_asgn_amt, ipt_asgn_amt, cre_usr_id, cre_dt, upd_usr_id, upd_dt)
         VALUES(b.to_trd_cd, b.to_rlane_cd, b.to_ioc_cd, b.to_vsl_cd, b.to_skd_voy_no, b.to_skd_dir_cd, b.stnd_cost_cd, 0, 0, 0, 0, b.ts_amt, 0, in_usr_id, SYSDATE, in_usr_id, SYSDATE);   -- n1st_asgn_amt

   out_err_cd := '00000';
   out_err_msg := 'Completed!';
   enis_log_prc('', v_log_mod_nm, 'END', NULL);
-----------------------[ 예외처리부      ]-----------------------
EXCEPTION
   WHEN OTHERS THEN
      out_err_cd := SQLCODE;
      out_err_msg := SQLERRM;
      enis_log_prc('', v_log_mod_nm, v_step || ' >> ERROR ' || SQLERRM, NULL);
      RAISE;
END COA_CREATE_TS_CTRB_PRC;