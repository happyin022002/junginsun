CREATE OR REPLACE PROCEDURE OPUSADM."COA_NOD_AVG_STND_COST_FULL_PRC" (in_cost_yrmon_src IN VARCHAR2, in_cost_yrmon_dest IN VARCHAR2)
Authid current_user 
IS
/******************************************************************************
   Purpose      : 1. TES S/O실적으로부터 NODE 평균단가 생성
******************************************************************************/

   ------------------------------[ 변수선언부             ]-----------------------

   /** 작업로그 관련 변수선언 **/
   v_start_time                   TIMESTAMP;
   v_coa_step                     VARCHAR(100);
   v_prc_cnt                      NUMBER;
   v_cost_yrmon_prev3_n1st_date   DATE;   -- 3개월전 첫째날
   v_cost_yrmon_prev0_n1st_date   DATE;   -- 현재월 첫째날
-------------------------------[ 업무로직 구현부       ]-----------------------
BEGIN
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 시작 정보 출력
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_start_time := SYSTIMESTAMP;
   v_prc_cnt := 0;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', '[V.20071227]');
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'in_cost_yrmon_src:' || in_cost_yrmon_src);
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'in_cost_yrmon_dest:' || in_cost_yrmon_dest);
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 3개월 기간 구하기
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := '3개월 기간 구하기';
   v_cost_yrmon_prev3_n1st_date := ADD_MONTHS(TO_DATE(in_cost_yrmon_src || '01', 'YYYYMMDD'), -3);
   v_cost_yrmon_prev0_n1st_date := TO_DATE(in_cost_yrmon_src || '01', 'YYYYMMDD');
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'v_cost_yrmon_prev3_n1st_date:' || v_cost_yrmon_prev3_n1st_date);
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'v_cost_yrmon_prev0_n1st_date:' || v_cost_yrmon_prev0_n1st_date);
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 대상 년월 단가 삭제
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := '대상 년월 단가 삭제';

   DELETE FROM coa_nod_avg_stnd_cost
         WHERE cost_yrmon = in_cost_yrmon_dest
           AND full_mty_cd = 'F';

   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'COA_NOD_AVG_STND_COST:' || SQL%ROWCOUNT || ' delete');
   -------------------------------[ NODE AVG COST 작업 처리         ]-----------------------

   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 전월 데이터 복사
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := '전월 데이터 복사';

   INSERT INTO coa_nod_avg_stnd_cost
      SELECT in_cost_yrmon_dest
            ,full_mty_cd
            ,cntr_tpsz_cd
            ,cost_loc_grp_cd
            ,nod_cd
            ,coa_cost_src_cd
            , trd_cd            
            ,locl_curr_cd
            ,stnd_cost_usd_amt
            ,locl_rt_amt
            ,slan_cd
            ,skd_dir_cd
            ,usd_rt_amt
            ,cost_ass_bse_cd
            ,biz_rule_flg
            ,fm_eff_dt
            ,to_eff_dt
            ,nod_ttl_qty
            ,nod_ttl_amt
            ,cost_vol_cd
            ,TO_CHAR(ADD_MONTHS(TO_DATE(in_cost_yrmon_src || '01', 'YYYYMMDD'), -1), 'YYYYMM') || ' Copy'
            ,cost_fx_flg
            ,'SYS_COA_COPY' AS cre_usr_id
            ,SYSDATE AS cre_dt
            ,'SYS_COA_COPY' AS upd_usr_id
            ,SYSDATE AS upd_dt
            ,cost_act_grp_cd

        FROM coa_nod_avg_stnd_cost
       WHERE cost_yrmon = TO_CHAR(ADD_MONTHS(TO_DATE(in_cost_yrmon_src || '01', 'YYYYMMDD'), -1), 'YYYYMM')   -- 1개월전
         AND full_mty_cd = 'F'
                                                                                                           ;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', '전월단가 copy:' || SQL%ROWCOUNT);
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- NODE FULL 단가 처리
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'NODE FULL 단가 처리';
   MERGE INTO coa_nod_avg_stnd_cost e1
      USING (SELECT d1.cost_yrmon
                   ,d1.full_mty_cd
                   ,coa_ut_tpsz_fnc(NULL, d1.cntr_tpsz_cd) AS cntr_tpsz_cd   -- SPCL FLG 인것은 모두 SP 로 바꾼다.
                   ,d1.cost_loc_grp_cd
                   ,d1.nod_cd
                   ,d1.coa_cost_src_cd
                   ,'USD' locl_curr_cd
                   ,SUM(d1.cost_usd_amt)/SUM(d1.uom_qty) AS stnd_cost_usd_amt
                   ,'A' cost_ass_bse_cd
                   ,SUM(d1.uom_qty) AS nod_ttl_qty
                   ,SUM(d1.cost_usd_amt) AS nod_ttl_amt
                   ,MAX(d1.cost_vol_cd) AS cost_vol_cd
               FROM (SELECT in_cost_yrmon_dest AS cost_yrmon
                           ,c1.full_mty_cd
                           ,c1.cntr_tpsz_cd
                           ,'N' AS cost_loc_grp_cd
                           ,c1.nod_cd
                           ,c1.coa_cost_src_cd
                           ,NVL(c1.cost_usd_amt, 0) AS cost_usd_amt
                           ,c1.uom_1_cd
                           ,NVL(c3.uom_1_qty, 0) AS uom_1_qty
                           ,c1.uom_2_cd
                           ,NVL(c4.uom_2_qty, 0) AS uom_2_qty
                           ,c5.cop_full_qty
                           ,CASE
                               WHEN(c1.uom_1_cd = 'COP_FULL')
                                  THEN c5.cop_full_qty
                               WHEN(NVL(c3.uom_1_qty, 0) > 0)
                                  THEN NVL(c3.uom_1_qty, 0)
                               WHEN(c1.uom_2_cd = 'COP_FULL')
                                  THEN c5.cop_full_qty
                               WHEN(NVL(c4.uom_2_qty, 0) > 0)
                                  THEN NVL(c4.uom_2_qty, 0)
                               ELSE c5.cop_full_qty
                            END AS uom_qty
                           ,CASE
                               WHEN(c1.uom_1_cd = 'COP_FULL')
                                  THEN 'COP_FULL'
                               WHEN(NVL(c3.uom_1_qty, 0) > 0)
                                  THEN c1.uom_1_cd
                               WHEN(c1.uom_2_cd = 'COP_FULL')
                                  THEN 'COP_FULL'
                               WHEN(NVL(c4.uom_2_qty, 0) > 0)
                                  THEN c1.uom_2_cd
                               ELSE 'COP_FULL'
                            END AS cost_vol_cd
                       FROM (                               
                              -- AMT
                              SELECT b1.full_mty_cd
                                    ,b1.coa_cost_src_cd
                                    ,b1.uom_1_cd
                                    ,b1.uom_2_cd
                                    ,b2.cntr_tpsz_cd
                                    ,b2.nod_cd
                                    ,b2.cost_usd_amt
                                FROM 
                                     (SELECT full_mty_cd AS full_mty_cd
                                            ,coa_cost_src_cd 
                                            ,cost_vol_cd AS uom_1_cd
                                            ,cost_vol_cd1 AS uom_2_cd
                                        FROM coa_cost_src_acct
                                       WHERE cost_src_sys_cd = 'TES'
                                         AND coa_cost_src_cd NOT IN ('TPNDFL', 'TPNDTS')   -- 2007.09.28 이경한 요청 TPNDFL, TPNDTS 제외
                                         AND full_mty_cd = 'F'   -- FULL 
                                                                ) b1, 
                                     (SELECT a3.cntr_sty_cd AS full_mty_cd
                                            ,NVL(a2.cntr_tpsz_cd, 'OTH') AS cntr_tpsz_cd
                                            ,a1.yd_cd AS nod_cd
                                            ,a2.lgs_cost_cd AS coa_cost_src_cd
                                            ,SUM(coa_conv_curr_usd_fnc(a1.curr_cd, NVL(a2.inv_amt, 0), TO_CHAR(a1.iss_dt, 'YYYYMM'))) AS cost_usd_amt
                                        FROM tes_tml_so_hdr a1, tes_tml_so_dtl a2, tes_tml_so_cost a3
                                       WHERE a1.tml_so_ofc_cty_cd = a2.tml_so_ofc_cty_cd
                                         AND a1.tml_so_seq = a2.tml_so_seq
                                         AND a2.lgs_cost_cd = a3.lgs_cost_cd
                                         AND a1.tml_inv_sts_cd = 'D'
                                         AND NVL(a1.delt_flg, 'N') <> 'Y'
                                         AND a1.iss_dt >= v_cost_yrmon_prev3_n1st_date
                                         AND a1.iss_dt < v_cost_yrmon_prev0_n1st_date
                                         AND a3.cntr_sty_cd = 'F'   -- FULL
                                       GROUP BY a3.cntr_sty_cd, NVL(a2.cntr_tpsz_cd, 'OTH'), a1.yd_cd, a2.lgs_cost_cd
                                       ORDER BY 1, 2, 3, 4) b2
                               WHERE b1.coa_cost_src_cd = b2.coa_cost_src_cd) c1                                 
                              -- COST SRC QTY
                           , (SELECT a3.cntr_sty_cd AS full_mty_cd
                                    ,NVL(a2.cntr_tpsz_cd, 'OTH') AS cntr_tpsz_cd
                                    ,a1.yd_cd nod_cd
                                    ,a2.lgs_cost_cd AS coa_cost_src_cd
                                    ,SUM(DECODE(a2.calc_cost_grp_cd
                                                ,'TM', NVL(a2.rvis_vol_qty, 1)
                                                ,'ON', NVL(a2.rvis_vol_qty, 1)
                                                ,NVL(a2.ovr_dys, 1)
                                               )
                                        ) AS cost_src_qty
                                FROM tes_tml_so_hdr a1, tes_tml_so_dtl a2, tes_tml_so_cost a3
                               WHERE a1.tml_so_ofc_cty_cd = a2.tml_so_ofc_cty_cd
                                 AND a1.tml_so_seq = a2.tml_so_seq
                                 AND a2.lgs_cost_cd = a3.lgs_cost_cd
                                 AND a1.tml_inv_sts_cd = 'D'
                                 AND NVL(a1.delt_flg, 'N') <> 'Y'
                                 AND a1.iss_dt >= v_cost_yrmon_prev3_n1st_date
                                 AND a1.iss_dt < v_cost_yrmon_prev0_n1st_date
                                 AND NVL(a2.inv_amt, 0) > 0 -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.
                                 AND a3.cntr_sty_cd = 'F'   -- FULL
                               GROUP BY a3.cntr_sty_cd, NVL(a2.cntr_tpsz_cd, 'OTH'), a1.yd_cd, a2.lgs_cost_cd
                              HAVING SUM(DECODE(a2.calc_cost_grp_cd
                                                ,'TM', NVL(a2.rvis_vol_qty, 1)
                                                ,'ON', NVL(a2.rvis_vol_qty, 1)
                                                ,NVL(a2.ovr_dys, 1)
                                               )
                                        ) > 0
                               ORDER BY 1, 2, 3, 4) c2
                             -- UOM_1_QTY
                           , (SELECT a3.cntr_sty_cd AS full_mty_cd
                                    ,NVL(a2.cntr_tpsz_cd, 'OTH') AS cntr_tpsz_cd
                                    ,a1.yd_cd nod_cd
                                    ,a2.lgs_cost_cd AS uom_1_cd
                                    ,SUM(DECODE(a2.calc_cost_grp_cd
                                                ,'TM', NVL(a2.rvis_vol_qty, 1)
                                                ,'ON', NVL(a2.rvis_vol_qty, 1)
                                                ,NVL(a2.ovr_dys, 1)
                                               )
                                        ) AS uom_1_qty
                                FROM tes_tml_so_hdr a1, tes_tml_so_dtl a2, tes_tml_so_cost a3
                               WHERE a1.tml_so_ofc_cty_cd = a2.tml_so_ofc_cty_cd
                                 AND a1.tml_so_seq = a2.tml_so_seq
                                 AND a2.lgs_cost_cd = a3.lgs_cost_cd
                                 AND a1.tml_inv_sts_cd = 'D'
                                 AND NVL(a1.delt_flg, 'N') <> 'Y'
                                 AND a1.iss_dt >= v_cost_yrmon_prev3_n1st_date
                                 AND a1.iss_dt < v_cost_yrmon_prev0_n1st_date
                                 AND NVL(a2.inv_amt, 0) > 0 -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.
                                 AND a3.cntr_sty_cd = 'F'   -- FULL
                               GROUP BY a3.cntr_sty_cd, NVL(a2.cntr_tpsz_cd, 'OTH'), a1.yd_cd, a2.lgs_cost_cd                                   
                              HAVING SUM(DECODE(a2.calc_cost_grp_cd
                                                ,'TM', NVL(a2.rvis_vol_qty, 1)
                                                ,'ON', NVL(a2.rvis_vol_qty, 1)
                                                ,NVL(a2.ovr_dys, 1)
                                               )
                                        ) > 0
                               ORDER BY 1, 2, 3, 4) c3
                             -- UOM_2_QTY : UOM_1_QTY 쿼리와 같음
                           , (SELECT a3.cntr_sty_cd AS full_mty_cd
                                    ,NVL(a2.cntr_tpsz_cd, 'OTH') AS cntr_tpsz_cd
                                    ,a1.yd_cd nod_cd
                                    ,a2.lgs_cost_cd AS uom_2_cd
                                    ,SUM(DECODE(a2.calc_cost_grp_cd
                                                ,'TM', NVL(a2.rvis_vol_qty, 1)
                                                ,'ON', NVL(a2.rvis_vol_qty, 1)
                                                ,NVL(a2.ovr_dys, 1)
                                               )
                                        ) AS uom_2_qty
                                FROM tes_tml_so_hdr a1, tes_tml_so_dtl a2, tes_tml_so_cost a3
                               WHERE a1.tml_so_ofc_cty_cd = a2.tml_so_ofc_cty_cd
                                 AND a1.tml_so_seq = a2.tml_so_seq
                                 AND a2.lgs_cost_cd = a3.lgs_cost_cd
                                 AND a1.tml_inv_sts_cd = 'D'
                                 AND NVL(a1.delt_flg, 'N') <> 'Y'
                                 AND a1.iss_dt >= v_cost_yrmon_prev3_n1st_date
                                 AND a1.iss_dt < v_cost_yrmon_prev0_n1st_date
                                 AND NVL(a2.inv_amt, 0) > 0  -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.
                                 AND a3.cntr_sty_cd = 'F'   -- FULL
                               GROUP BY a3.cntr_sty_cd, NVL(a2.cntr_tpsz_cd, 'OTH'), a1.yd_cd, a2.lgs_cost_cd
                              HAVING SUM(DECODE(a2.calc_cost_grp_cd
                                                ,'TM', NVL(a2.rvis_vol_qty, 1)
                                                ,'ON', NVL(a2.rvis_vol_qty, 1)
                                                ,NVL(a2.ovr_dys, 1)
                                               )
                                        ) > 0
                               ORDER BY 1, 2, 3, 4) c4
                             -- COP_FULL_QTY : QTY1 쿼리와 같음
                           , (SELECT a3.cntr_sty_cd AS full_mty_cd
                                    ,NVL(a2.cntr_tpsz_cd, 'OTH') AS cntr_tpsz_cd
                                    ,a1.yd_cd nod_cd
                                    ,SUM(DECODE(a2.calc_cost_grp_cd
                                                ,'TM', NVL(a2.rvis_vol_qty, 1)
                                                ,'ON', NVL(a2.rvis_vol_qty, 1)
                                                ,NVL(a2.ovr_dys, 1)
                                               )
                                        ) AS cop_full_qty
                                FROM tes_tml_so_hdr a1, tes_tml_so_dtl a2, tes_tml_so_cost a3
                               WHERE a1.tml_so_ofc_cty_cd = a2.tml_so_ofc_cty_cd
                                 AND a1.tml_so_seq = a2.tml_so_seq
                                 AND a2.lgs_cost_cd = a3.lgs_cost_cd
                                 AND a1.tml_inv_sts_cd = 'D'
                                 AND NVL(a1.delt_flg, 'N') <> 'Y'
                                 AND a1.iss_dt >= v_cost_yrmon_prev3_n1st_date
                                 AND a1.iss_dt < v_cost_yrmon_prev0_n1st_date
                                 AND NVL(a2.inv_amt, 0) > 0  -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.
                                 AND a3.cntr_sty_cd = 'F'   -- FULL
                               GROUP BY a3.cntr_sty_cd, NVL(a2.cntr_tpsz_cd, 'OTH'), a1.yd_cd
                              HAVING SUM(DECODE(a2.calc_cost_grp_cd
                                                ,'TM', NVL(a2.rvis_vol_qty, 1)
                                                ,'ON', NVL(a2.rvis_vol_qty, 1)
                                                ,NVL(a2.ovr_dys, 1)
                                               )
                                        ) > 0
                               ORDER BY 1, 2, 3) c5
                      WHERE c1.full_mty_cd = c2.full_mty_cd(+)
                        AND c1.cntr_tpsz_cd = c2.cntr_tpsz_cd(+)
                        AND c1.nod_cd = c2.nod_cd(+)
                        AND c1.coa_cost_src_cd = c2.coa_cost_src_cd(+)
                        AND c1.full_mty_cd = c3.full_mty_cd(+)
                        AND c1.cntr_tpsz_cd = c3.cntr_tpsz_cd(+)
                        AND c1.nod_cd = c3.nod_cd(+)
                        AND c1.uom_1_cd = c3.uom_1_cd(+)
                        AND c1.full_mty_cd = c4.full_mty_cd(+)
                        AND c1.cntr_tpsz_cd = c4.cntr_tpsz_cd(+)
                        AND c1.nod_cd = c4.nod_cd(+)
                        AND c1.uom_2_cd = c4.uom_2_cd(+)
                        AND c1.full_mty_cd = c5.full_mty_cd(+)
                        AND c1.cntr_tpsz_cd = c5.cntr_tpsz_cd(+)
                        AND c1.nod_cd = c5.nod_cd(+)
                        AND DECODE(c3.uom_1_qty, NULL, 'X', 'O') || DECODE(c4.uom_2_qty, NULL, 'X', 'O')|| DECODE(c5.cop_full_qty, NULL, 'X', 'O') <> 'XXX') d1
                                                                                                -- QTY 1차, 2차, 3차(Full) 모두 없으면 단가생성에서 제외                                                                                                                  
              GROUP BY cost_yrmon, full_mty_cd, coa_ut_tpsz_fnc(NULL, d1.cntr_tpsz_cd), cost_loc_grp_cd, nod_cd, coa_cost_src_cd
            ) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd
          AND e1.nod_cd = e2.nod_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.full_mty_cd, e1.cntr_tpsz_cd, e1.cost_loc_grp_cd, e1.nod_cd, e1.coa_cost_src_cd, e1.locl_curr_cd
               ,e1.stnd_cost_usd_amt, e1.cost_ass_bse_cd, e1.nod_ttl_qty, e1.nod_ttl_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.full_mty_cd, e2.cntr_tpsz_cd, e2.cost_loc_grp_cd, e2.nod_cd, e2.coa_cost_src_cd, e2.locl_curr_cd
               ,e2.stnd_cost_usd_amt, e2.cost_ass_bse_cd, e2.nod_ttl_qty, e2.nod_ttl_amt, e2.cost_vol_cd, 'SYS_COA_CRE', SYSDATE, 'SYS_COA_CRE'
               ,SYSDATE)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.nod_ttl_qty = e2.nod_ttl_qty, e1.nod_ttl_amt = e2.nod_ttl_amt, e1.cost_vol_cd = e2.cost_vol_cd, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = SYSDATE
          WHERE NVL(e1.cost_fx_flg,'N') <> 'Y'
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'NODE FULL Merge:' || SQL%ROWCOUNT);
   --  
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- SCC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'SCC';
   MERGE INTO coa_nod_avg_stnd_cost e1
      USING (SELECT   cost_yrmon
                     ,a1.full_mty_cd
                     ,cntr_tpsz_cd
                     ,'S' AS cost_loc_grp_cd
                     ,coa_loc_fnc(nod_cd, 'SCC') AS nod_cd
                     ,a1.coa_cost_src_cd
                     ,'USD' AS locl_curr_cd
                     ,'A' AS cost_ass_bse_cd
                     ,SUM(nod_ttl_amt) AS nod_ttl_amt
                     ,SUM(nod_ttl_qty) AS nod_ttl_qty
                     ,SUM(nod_ttl_amt) / SUM(nod_ttl_qty) AS stnd_cost_usd_amt
                 FROM coa_nod_avg_stnd_cost a1, coa_cost_src_acct a2
                WHERE cost_yrmon = in_cost_yrmon_dest
                  AND cost_loc_grp_cd = 'N'
                  AND NVL(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.
                  AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
                  AND a1.full_mty_cd = 'F'
             GROUP BY cost_yrmon, a1.full_mty_cd, cntr_tpsz_cd, coa_loc_fnc(nod_cd, 'SCC'), a1.coa_cost_src_cd
               HAVING coa_loc_fnc(nod_cd, 'SCC') IS NOT NULL
            ) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd
          AND e1.nod_cd = e2.nod_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.full_mty_cd, e1.cntr_tpsz_cd, e1.cost_loc_grp_cd, e1.nod_cd, e1.coa_cost_src_cd, e1.locl_curr_cd
               ,e1.stnd_cost_usd_amt, e1.cost_ass_bse_cd, e1.nod_ttl_qty, e1.nod_ttl_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.full_mty_cd, e2.cntr_tpsz_cd, e2.cost_loc_grp_cd, e2.nod_cd, e2.coa_cost_src_cd, e2.locl_curr_cd
               ,e2.stnd_cost_usd_amt, e2.cost_ass_bse_cd, e2.nod_ttl_qty, e2.nod_ttl_amt, NULL, 'SYS_COA_CRE', SYSDATE, 'SYS_COA_CRE', SYSDATE)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.nod_ttl_qty = e2.nod_ttl_qty, e1.nod_ttl_amt = e2.nod_ttl_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = SYSDATE     
          WHERE NVL(e1.cost_fx_flg,'N') <> 'Y'
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'SCC:' || SQL%ROWCOUNT);
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- ECC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'ECC';
   MERGE INTO coa_nod_avg_stnd_cost e1
      USING (SELECT   cost_yrmon
                     ,a1.full_mty_cd
                     ,cntr_tpsz_cd
                     ,'E' AS cost_loc_grp_cd
                     ,coa_loc_fnc(nod_cd, 'ECC') AS nod_cd
                     ,a1.coa_cost_src_cd
                     ,'USD' AS locl_curr_cd
                     ,'A' AS cost_ass_bse_cd
                     ,SUM(nod_ttl_amt) AS nod_ttl_amt
                     ,SUM(nod_ttl_qty) AS nod_ttl_qty
                     ,SUM(nod_ttl_amt) / SUM(nod_ttl_qty) AS stnd_cost_usd_amt
                 FROM coa_nod_avg_stnd_cost a1, coa_cost_src_acct a2
                WHERE cost_yrmon = in_cost_yrmon_dest
                  AND cost_loc_grp_cd = 'N'
                  AND NVL(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG가 Y 인것은 NODE 에만 깐다.
                  AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
                  AND a1.full_mty_cd = 'F'
             GROUP BY cost_yrmon, a1.full_mty_cd, cntr_tpsz_cd, coa_loc_fnc(nod_cd, 'ECC'), a1.coa_cost_src_cd
               HAVING coa_loc_fnc(nod_cd, 'ECC') IS NOT NULL
            ) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd
          AND e1.nod_cd = e2.nod_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.full_mty_cd, e1.cntr_tpsz_cd, e1.cost_loc_grp_cd, e1.nod_cd, e1.coa_cost_src_cd, e1.locl_curr_cd
               ,e1.stnd_cost_usd_amt, e1.cost_ass_bse_cd, e1.nod_ttl_qty, e1.nod_ttl_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.full_mty_cd, e2.cntr_tpsz_cd, e2.cost_loc_grp_cd, e2.nod_cd, e2.coa_cost_src_cd, e2.locl_curr_cd
               ,e2.stnd_cost_usd_amt, e2.cost_ass_bse_cd, e2.nod_ttl_qty, e2.nod_ttl_amt, NULL, 'SYS_COA_CRE', SYSDATE, 'SYS_COA_CRE', SYSDATE)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.nod_ttl_qty = e2.nod_ttl_qty, e1.nod_ttl_amt = e2.nod_ttl_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = SYSDATE      
          WHERE NVL(e1.cost_fx_flg,'N') <> 'Y'
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'ECC:' || SQL%ROWCOUNT);
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- LCC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'LCC';
   MERGE INTO coa_nod_avg_stnd_cost e1
      USING (SELECT   cost_yrmon
                     ,a1.full_mty_cd
                     ,cntr_tpsz_cd
                     ,'L' AS cost_loc_grp_cd
                     ,coa_loc_fnc(nod_cd, 'LCC') AS nod_cd
                     ,a1.coa_cost_src_cd
                     ,'USD' AS locl_curr_cd
                     ,'A' AS cost_ass_bse_cd
                     ,SUM(nod_ttl_amt) AS nod_ttl_amt
                     ,SUM(nod_ttl_qty) AS nod_ttl_qty
                     ,SUM(nod_ttl_amt) / SUM(nod_ttl_qty) AS stnd_cost_usd_amt
                 FROM coa_nod_avg_stnd_cost a1, coa_cost_src_acct a2
                WHERE cost_yrmon = in_cost_yrmon_dest
                  AND cost_loc_grp_cd = 'N'
                  AND NVL(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG가 Y 인것은 NODE 에만 깐다.
                  AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
                  AND a1.full_mty_cd = 'F'
             GROUP BY cost_yrmon, a1.full_mty_cd, cntr_tpsz_cd, coa_loc_fnc(nod_cd, 'LCC'), a1.coa_cost_src_cd
               HAVING coa_loc_fnc(nod_cd, 'LCC') IS NOT NULL
            ) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd
          AND e1.nod_cd = e2.nod_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.full_mty_cd, e1.cntr_tpsz_cd, e1.cost_loc_grp_cd, e1.nod_cd, e1.coa_cost_src_cd, e1.locl_curr_cd
               ,e1.stnd_cost_usd_amt, e1.cost_ass_bse_cd, e1.nod_ttl_qty, e1.nod_ttl_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.full_mty_cd, e2.cntr_tpsz_cd, e2.cost_loc_grp_cd, e2.nod_cd, e2.coa_cost_src_cd, e2.locl_curr_cd
               ,e2.stnd_cost_usd_amt, e2.cost_ass_bse_cd, e2.nod_ttl_qty, e2.nod_ttl_amt, NULL, 'SYS_COA_CRE', SYSDATE, 'SYS_COA_CRE', SYSDATE)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.nod_ttl_qty = e2.nod_ttl_qty, e1.nod_ttl_amt = e2.nod_ttl_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = SYSDATE 
          WHERE NVL(e1.cost_fx_flg,'N') <> 'Y'
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'LCC:' || SQL%ROWCOUNT);
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- RCC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'RCC';
   MERGE INTO coa_nod_avg_stnd_cost e1
      USING (SELECT   cost_yrmon
                     ,a1.full_mty_cd
                     ,cntr_tpsz_cd
                     ,'R' AS cost_loc_grp_cd
                     ,coa_loc_fnc(nod_cd, 'RCC') AS nod_cd
                     ,a1.coa_cost_src_cd
                     ,'USD' AS locl_curr_cd
                     ,'A' AS cost_ass_bse_cd
                     ,SUM(nod_ttl_amt) AS nod_ttl_amt
                     ,SUM(nod_ttl_qty) AS nod_ttl_qty
                     ,SUM(nod_ttl_amt) / SUM(nod_ttl_qty) AS stnd_cost_usd_amt
                 FROM coa_nod_avg_stnd_cost a1, coa_cost_src_acct a2
                WHERE cost_yrmon = in_cost_yrmon_dest
                  AND cost_loc_grp_cd = 'N'
                  AND NVL(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG가 Y 인것은 NODE 에만 깐다.
                  AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
                  AND a1.full_mty_cd = 'F'
             GROUP BY cost_yrmon, a1.full_mty_cd, cntr_tpsz_cd, coa_loc_fnc(nod_cd, 'RCC'), a1.coa_cost_src_cd
            ) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd
          AND e1.nod_cd = e2.nod_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.full_mty_cd, e1.cntr_tpsz_cd, e1.cost_loc_grp_cd, e1.nod_cd, e1.coa_cost_src_cd, e1.locl_curr_cd
               ,e1.stnd_cost_usd_amt, e1.cost_ass_bse_cd, e1.nod_ttl_qty, e1.nod_ttl_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.full_mty_cd, e2.cntr_tpsz_cd, e2.cost_loc_grp_cd, e2.nod_cd, e2.coa_cost_src_cd, e2.locl_curr_cd
               ,e2.stnd_cost_usd_amt, e2.cost_ass_bse_cd, e2.nod_ttl_qty, e2.nod_ttl_amt, NULL, 'SYS_COA_CRE', SYSDATE, 'SYS_COA_CRE', SYSDATE)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.nod_ttl_qty = e2.nod_ttl_qty, e1.nod_ttl_amt = e2.nod_ttl_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = SYSDATE 
          WHERE NVL(e1.cost_fx_flg,'N') <> 'Y'
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'RCC:' || SQL%ROWCOUNT);
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- BOX tpsz FULL
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'BOX tpsz';
   MERGE INTO coa_nod_avg_stnd_cost e1
      USING (SELECT a1.cost_yrmon
                   ,a1.full_mty_cd
                   ,'BOX' AS cntr_tpsz_cd
                   ,a1.cost_loc_grp_cd
                   ,a1.nod_cd
                   ,a1.coa_cost_src_cd
                   ,'USD' AS locl_curr_cd
                   ,'A' AS cost_ass_bse_cd
                   ,SUM(a1.nod_ttl_amt) AS nod_ttl_amt
                   ,SUM(a1.nod_ttl_qty) AS nod_ttl_qty
                   ,SUM(a1.nod_ttl_amt) / SUM(a1.nod_ttl_qty) AS stnd_cost_usd_amt
               FROM coa_nod_avg_stnd_cost a1
                   ,coa_cost_src_acct a2
              WHERE a1.coa_cost_src_cd = a2.coa_cost_src_cd
                AND a1.cost_yrmon = in_cost_yrmon_dest
                AND a1.cntr_tpsz_cd NOT IN ('20', '40', 'BOX') -- tpsz로 된 물량/금액만으로 box단가 생성
                                                               -- 전월데이터를 copy하기 때문에 20,40,BOX 단가가 존재함.  
                AND a1.nod_ttl_amt > 0   -- AMT 가 0인것이 있음
                AND a1.nod_ttl_qty > 0
                AND a2.cost_src_sys_cd = 'TES'
                AND a2.cost_ut_amt_cd = 'BOX'   -- 단가를 붙일때 BOX인것만 사용함.
                AND a1.full_mty_cd = 'F'        -- FULL
              GROUP BY a1.cost_yrmon, a1.full_mty_cd, 'BOX', a1.cost_loc_grp_cd, a1.nod_cd, a1.coa_cost_src_cd
            ) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd
          AND e1.nod_cd = e2.nod_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.full_mty_cd, e1.cntr_tpsz_cd, e1.cost_loc_grp_cd, e1.nod_cd, e1.coa_cost_src_cd, e1.locl_curr_cd
               ,e1.stnd_cost_usd_amt, e1.cost_ass_bse_cd, e1.nod_ttl_qty, e1.nod_ttl_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.full_mty_cd, e2.cntr_tpsz_cd, e2.cost_loc_grp_cd, e2.nod_cd, e2.coa_cost_src_cd, e2.locl_curr_cd
               ,e2.stnd_cost_usd_amt, e2.cost_ass_bse_cd, e2.nod_ttl_qty, e2.nod_ttl_amt, NULL, 'SYS_COA_CRE', SYSDATE, 'SYS_COA_CRE', SYSDATE)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.nod_ttl_qty = e2.nod_ttl_qty, e1.nod_ttl_amt = e2.nod_ttl_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = SYSDATE 
          WHERE NVL(e1.cost_fx_flg,'N') <> 'Y'
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'BOX FULL:' || SQL%ROWCOUNT);
   --
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 20, 40 tpsz
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := '20, 40 tpsz';
   MERGE INTO coa_nod_avg_stnd_cost e1
      USING (SELECT   a1.cost_yrmon
                     ,a1.full_mty_cd
                     ,DECODE(SUBSTR(a1.cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd
                     ,a1.cost_loc_grp_cd
                     ,a1.nod_cd
                     ,a1.coa_cost_src_cd
                     ,'USD' AS locl_curr_cd
                     ,'A' AS cost_ass_bse_cd
                     ,SUM(a1.nod_ttl_qty) AS nod_ttl_qty
                     ,SUM(a1.nod_ttl_amt) AS nod_ttl_amt
                     ,SUM(a1.nod_ttl_amt) / SUM(a1.nod_ttl_qty) AS stnd_cost_usd_amt
                 FROM coa_nod_avg_stnd_cost a1
                     ,coa_cost_src_acct a2
                WHERE a1.coa_cost_src_cd = a2.coa_cost_src_cd
                  AND a1.cost_yrmon = in_cost_yrmon_dest
                  AND a1.cntr_tpsz_cd NOT IN ('20', '40', 'BOX') -- 전월 데이터를 copy 했기 때문에 제외
                  AND a1.nod_ttl_amt > 0   -- AMT 가 0인것이 있음
                  AND a1.nod_ttl_qty > 0
                  AND a2.cost_src_sys_cd = 'TES'
                  AND a2.cost_ut_amt_cd = 'SZ'  -- 단가를 붙일때 SZ인것만 사용함.
                  AND a1.full_mty_cd = 'F'      -- MTY 는 20,40 으로만 위 로직에서 단가 생성되어 있음
             GROUP BY a1.cost_yrmon, a1.full_mty_cd, DECODE(SUBSTR(a1.cntr_tpsz_cd, -1), '2', '20', '40')
                     ,a1.cost_loc_grp_cd, a1.nod_cd, a1.coa_cost_src_cd
            ) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd
          AND e1.nod_cd = e2.nod_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.full_mty_cd, e1.cntr_tpsz_cd, e1.cost_loc_grp_cd, e1.nod_cd, e1.coa_cost_src_cd, e1.locl_curr_cd
               ,e1.stnd_cost_usd_amt, e1.cost_ass_bse_cd, e1.nod_ttl_qty, e1.nod_ttl_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.full_mty_cd, e2.cntr_tpsz_cd, e2.cost_loc_grp_cd, e2.nod_cd, e2.coa_cost_src_cd, e2.locl_curr_cd
               ,e2.stnd_cost_usd_amt, e2.cost_ass_bse_cd, e2.nod_ttl_qty, e2.nod_ttl_amt, NULL, 'SYS_COA_CRE', SYSDATE, 'SYS_COA_CRE', SYSDATE)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.nod_ttl_qty = e2.nod_ttl_qty, e1.nod_ttl_amt = e2.nod_ttl_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = SYSDATE  
          WHERE NVL(e1.cost_fx_flg,'N') <> 'Y'
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'SIZ:' || SQL%ROWCOUNT);
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'V_PRC_CNT:' || TO_CHAR(v_prc_cnt, '999,999,999,999'));
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', '소요시간:' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
EXCEPTION
   WHEN OTHERS
   THEN
      ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_FULL_PRC', 'Error!!-' || v_coa_step || '>>' || SQLERRM);
END COA_NOD_AVG_STND_COST_FULL_PRC;