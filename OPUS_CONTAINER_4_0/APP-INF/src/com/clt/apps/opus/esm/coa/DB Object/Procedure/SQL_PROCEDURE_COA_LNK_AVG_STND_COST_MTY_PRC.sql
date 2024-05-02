CREATE OR REPLACE PROCEDURE OPUSADM.COA_LNK_AVG_STND_COST_MTY_PRC(
   in_cost_yrmon_src         IN   VARCHAR2
  ,in_cost_yrmon_dest        IN   VARCHAR2
  ,in_duration               IN   VARCHAR2
)
authid current_user
IS
/******************************************************************************
   Purpose      : COA_CNTR_REPO_LNK_COST MTY 평균단가 생성


   Ex)
    -- 200712월부터 3개월 기간 기준으로 100801 평균단가 생성(약 12분소요됨)
    BEGIN
      COA_LNK_AVG_STND_COST_MTY_PRC ( '200712', '100801', '2' );
      COMMIT;
    END;

    -- LOG 보기
    SELECT * FROM ENIS_LOG
    WHERE MOD_NAME = 'COA_LNK_AVG_STND_COST_MTY_PRC'
      AND EXEC_DT > SYSDATE - 1/24
    ORDER BY EXEC_DT DESC  
******************************************************************************/

  ------------------------------[ 변수선언부             ]-----------------------
   /** 작업로그 관련 변수선언 **/
   v_start_time                   TIMESTAMP;
   v_prc_cnt                      NUMBER;
   v_coa_step                     VARCHAR(100);
   v_cost_yrmon_prev3             VARCHAR2(6);   -- Duration 전 월
   v_cost_yrmon_prev0             VARCHAR2(6);   -- 현재월 월
   v_cost_yrmon_max               VARCHAR2(6);   -- 단가생성 최근월

-------------------------------[ 업무로직 구현부       ]-----------------------

BEGIN
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 시작 정보 출력
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := '초기값 설정';
   v_start_time := systimestamp;
   v_prc_cnt := 0;
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', '[V.20080304]');
   enis_log_prc(sysdate
               ,'COA_LNK_AVG_STND_COST_MTY_PRC'
               , 'IN_COST_YRMON_SRC: ' || in_cost_yrmon_src || '-->' || 'IN_COST_YRMON_DEST: ' || in_cost_yrmon_dest
               );
   --

--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 단가 생성 기간 구하기
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := '단가 생성 기간 구하기';
   v_cost_yrmon_prev3 := TO_CHAR(add_months(TO_DATE(in_cost_yrmon_src || '01', 'YYYYMMDD'), -in_duration), 'YYYYMM');
   v_cost_yrmon_prev0 := in_cost_yrmon_src;
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'v_cost_yrmon_prev3: ' || v_cost_yrmon_prev3);
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'v_cost_yrmon_prev0: ' || v_cost_yrmon_prev0);

--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 대상 년월 단가 삭제
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := '대상 년월 단가 삭제';

   DELETE FROM coa_lnk_avg_stnd_cost
         WHERE cost_yrmon = in_cost_yrmon_dest
           AND full_mty_cd = 'M';

   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'COA_LNK_AVG_STND_COST: ' || SQL%ROWCOUNT || ' delete');

-------------------------------[ LINK AVG COST 작업 처리         ]-------------------------------------------

/************************************************************************************************************
 * 순수 tpsz
 ***********************************************************************************************************/
   v_cost_yrmon_max := TO_CHAR(add_months(TO_DATE(in_cost_yrmon_dest || '01', 'YYYYMMDD'), -1), 'YYYYMM');
  -- 전월 데이터 복사

   --************************************************************************************************************
   -- 3개월 data 만 가지고 단가를 생성할 경우 빠지는 node, link가 많기 때문에 전달 data를 copy 한 후
   -- 있는 부분은 update, 없는 부분은 insert 한다.
   -- 해당 대상 년월 삭제하고 전달 data insert
   --************************************************************************************************************
   INSERT INTO coa_lnk_avg_stnd_cost
      SELECT in_cost_yrmon_dest
            ,lnk_fm_nod_cd
            ,lnk_to_nod_cd
            ,co_cd
            ,cntr_tpsz_cd
            ,full_mty_cd
            ,coa_cost_src_cd
            ,cost_loc_grp_cd
            ,locl_curr_cd
            ,stnd_cost_usd_amt
            ,lnk_locl_rt_amt
            ,lnk_usd_rt_amt
            ,cost_ass_bse_cd
            ,rout_tz_mod_cd
            ,fm_eff_dt
            ,to_eff_dt
            ,lnk_ttl_qty
            ,lnk_ttl_amt
            ,cost_vol_cd
            ,v_cost_yrmon_max || ' Copy'
            ,cost_fx_flg
            ,'SYS_COA_COPY' cre_usr_id
            ,sysdate cre_dt
            ,'SYS_COA_COPY' upd_usr_id
            ,sysdate upd_dt
        FROM coa_lnk_avg_stnd_cost
       WHERE cost_yrmon = v_cost_yrmon_max   -- 사용자 입력월 또는 최근월
         AND full_mty_cd = 'M'
                                                                                                           ;

   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', '전월단가 copy(' || v_cost_yrmon_max || '): ' || SQL%ROWCOUNT);

--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- NODE MTY 단가 처리
--      COP FULL 적용안함
--      TRMORD/RT/TD/WD/WR/WT -> TRMTRD/RT/TD/WD/WR/WT 로 변경하여 평균단가 생성함
--      TRMO* 는 TRMT* 와 같은 비용으로 2중 비용이 계산되므로 하나만 선택한다.
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'NODE MTY 단가 처리';
   MERGE INTO coa_lnk_avg_stnd_cost f1
      USING (WITH uom_qty AS -- 반복되는 부분 With 절로 만듬
             (SELECT   b1.lnk_fm_nod_cd
                      ,b1.lnk_to_nod_cd
                      ,decode(substr(b1.cntr_tpsz_cd, -1), '2', '20', '40') cntr_tpsz_cd
                      -- MTY 는 20, 40 TYPE 만 필요함
                      ,b1.coa_cost_src_cd
                      ,SUM(b1.cost_src_qty) cost_src_qty
                FROM (SELECT a1.n1st_nod_cd lnk_fm_nod_cd
                            ,COALESCE(a1.n4th_nod_cd, a1.n3rd_nod_cd, a1.n2nd_nod_cd) lnk_to_nod_cd
                            ,a1.cntr_tpsz_cd
                            ,decode(substr(a1.coa_cost_src_cd, 1, 4)
                                   ,'TRMO', REPLACE(a1.coa_cost_src_cd, 'TRMO', 'TRMT')
                                   ,a1.coa_cost_src_cd
                                   ) coa_cost_src_cd   -- TRMO* -> TRMT*로 변경
                             ,decode(inv_cxl_flg, 'Y', -1, 1) cost_src_qty
                        -- INVOICE CANCEL 시 2개의 ROW가 존재 금액은 마이너스 금액이 있어서 0이되지만 QYT는 -1처리 필요
                        FROM COA_TRSP_ACT_COST_IF a1, coa_cost_src_acct a2
                            ,(SELECT DISTINCT vsl_cd
                                         ,skd_voy_no
                                         ,skd_dir_cd
                                         ,rev_dir_cd
                                    FROM gl_estm_rev_vvd
                                   WHERE estm_bc_div_cd IN ('C', 'M')
                                     AND rev_yrmon BETWEEN v_cost_yrmon_prev3 AND v_cost_yrmon_prev0
                                     AND exe_yrmon = v_cost_yrmon_prev0    -- 대상기간의 마지막월.
                                     AND estm_vvd_tp_cd IN  ('RV','BV')
                              ) a3  --vvd를 읽어와 R.Month 선정
                       WHERE a1.coa_cost_src_cd = a2.coa_cost_src_cd
                         AND a1.inv_sys_id = 'TRS'   -- TES, TRS
                         AND a1.cntr_tpsz_cd IS NOT NULL
                         AND a1.locl_cost_amt > 0
                         -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.
                         AND a2.full_mty_cd = 'M'   -- M:MTY, F:FULL
                         AND a1.otr_crr_flg = 'N'   -- Y: 타선사 비용, N: 한진비용
                         AND a1.vsl_cd     = a3.vsl_cd
                         AND a1.skd_voy_no = a3.skd_voy_no
                         AND a1.skd_dir_cd = a3.skd_dir_cd
                         AND a1.rev_dir_cd = a3.rev_dir_cd
                                                           ) b1
                GROUP BY b1.lnk_fm_nod_cd, b1.lnk_to_nod_cd
                        ,decode(substr(b1.cntr_tpsz_cd, -1), '2', '20', '40'), b1.coa_cost_src_cd
              )

              SELECT in_cost_yrmon_dest cost_yrmon
                     ,f1.lnk_fm_nod_cd
                     ,f1.lnk_to_nod_cd
                     ,f1.cntr_tpsz_cd   -- 20, 40
                     ,'H' co_cd   -- HJS
                     ,'N' cost_loc_grp_cd   -- NODE
                     ,'M' full_mty_cd   -- MTY
                     ,'A' cost_ass_bse_cd   -- AVG
                     ,'USD' locl_curr_cd
                     ,f1.coa_cost_src_cd
                     ,SUM(f1.cost_usd_amt) / SUM(f1.uom_qty) stnd_cost_usd_amt
                     ,SUM(f1.cost_usd_amt) lnk_ttl_amt
                     ,SUM(f1.uom_qty) lnk_ttl_qty
                     ,MAX(f1.cost_vol_cd) cost_vol_cd
                FROM (SELECT c1.lnk_fm_nod_cd
                            ,c1.lnk_to_nod_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.cost_usd_amt
                            ,c1.coa_cost_src_cd
                            ,c2.cost_src_qty
                            ,c1.uom_1_cd
                            ,c3.uom_1_qty
                            ,c1.uom_2_cd
                            ,c4.uom_2_qty
                            ,CASE
                                WHEN(c3.uom_1_qty IS NOT NULL)
                                    THEN c1.uom_1_cd
                                ELSE c1.uom_2_cd
                             END cost_vol_cd
                            ,CASE
                                WHEN(c3.uom_1_qty IS NOT NULL)
                                    THEN uom_1_qty
                                ELSE uom_2_qty
                             END uom_qty
                       FROM (
                             -- COST AMT
                             SELECT   b1.lnk_fm_nod_cd
                                     ,b1.lnk_to_nod_cd
                                     ,decode(substr(b1.cntr_tpsz_cd, -1), '2', '20', '40') cntr_tpsz_cd
                                     -- MTY 는 20, 40 TYPE 만 필요함
                                     ,b1.coa_cost_src_cd
                                     ,b1.uom_1_cd
                                     ,b1.uom_2_cd
                                     ,SUM(b1.cost_usd_amt) cost_usd_amt
                                FROM (SELECT a1.n1st_nod_cd lnk_fm_nod_cd
                                            ,COALESCE(a1.n4th_nod_cd, a1.n3rd_nod_cd, a1.n2nd_nod_cd) lnk_to_nod_cd
                                            -- MTY 는 ID/OD 경우 없음
                                            ,a1.cntr_tpsz_cd
                                            ,decode(substr(a1.coa_cost_src_cd, 1, 4)
                                                    ,'TRMO', REPLACE(a1.coa_cost_src_cd, 'TRMO', 'TRMT')
                                                    ,a1.coa_cost_src_cd
                                                   ) coa_cost_src_cd   -- TRMO* -> TRMT*로 변경
                                             ,a2.cost_vol_cd uom_1_cd
                                             ,a2.cost_vol_cd1 uom_2_cd
                                             ,coa_conv_curr_usd_fnc(a1.locl_curr_cd
                                                                    ,nvl(a1.locl_cost_amt, 0)
                                                                    ,substr(a1.gl_dt, 1, 6)
                                                                    ) cost_usd_amt
                                        FROM COA_TRSP_ACT_COST_IF a1, coa_cost_src_acct a2
                                            ,(SELECT DISTINCT vsl_cd
                                                         ,skd_voy_no
                                                         ,skd_dir_cd
                                                         ,rev_dir_cd
                                                FROM gl_estm_rev_vvd
                                               WHERE estm_bc_div_cd IN ('C', 'M')
                                                 AND rev_yrmon BETWEEN v_cost_yrmon_prev3 AND v_cost_yrmon_prev0
                                                 AND exe_yrmon = v_cost_yrmon_prev0    -- 대상기간의 마지막월.
                                                 AND estm_vvd_tp_cd IN  ('RV','BV')
                                              ) a3  --vvd를 읽어와 R.Month 선정
                                       WHERE a1.coa_cost_src_cd = a2.coa_cost_src_cd
                                         AND a1.inv_sys_id = 'TRS'   -- TES, TRS
                                         AND a1.cntr_tpsz_cd IS NOT NULL
                                         AND a2.full_mty_cd = 'M'   -- M:MTY, F:FULL
                                         AND a1.otr_crr_flg = 'N'   -- Y: 타선사 비용, N: 한진비용
                                         AND a1.vsl_cd     = a3.vsl_cd
                                         AND a1.skd_voy_no = a3.skd_voy_no
                                         AND a1.skd_dir_cd = a3.skd_dir_cd
                                         AND a1.rev_dir_cd = a3.rev_dir_cd
                                                                  ) b1
                             GROUP BY b1.lnk_fm_nod_cd, b1.lnk_to_nod_cd
                                     ,decode(substr(b1.cntr_tpsz_cd, -1), '2', '20', '40'), b1.coa_cost_src_cd
                                     ,b1.uom_1_cd, b1.uom_2_cd) c1
                             -- COST SRC QTY 데이터 확인 위해 넣음
                            , (SELECT lnk_fm_nod_cd
                                     ,lnk_to_nod_cd
                                     ,cntr_tpsz_cd
                                     ,coa_cost_src_cd
                                     ,cost_src_qty
                                 FROM uom_qty
                                UNION ALL
                               SELECT lnk_fm_nod_cd
                                     ,lnk_to_nod_cd
                                     ,cntr_tpsz_cd
                                     ,'TR_MTY' AS coa_cost_src_cd
                                     ,SUM(cost_src_qty) cost_src_qty
                                 FROM uom_qty
                                WHERE coa_cost_src_cd like 'TRMT%'
                                GROUP BY lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd) c2

                              -- UOM 1 QTY
                            , (SELECT lnk_fm_nod_cd
                                     ,lnk_to_nod_cd
                                     ,cntr_tpsz_cd
                                     ,coa_cost_src_cd
                                     ,cost_src_qty AS uom_1_qty
                                 FROM uom_qty
                                UNION ALL
                               SELECT lnk_fm_nod_cd
                                     ,lnk_to_nod_cd
                                     ,cntr_tpsz_cd
                                     ,'TR_MTY' AS coa_cost_src_cd
                                     ,SUM(cost_src_qty) cost_src_qty
                                 FROM uom_qty
                                WHERE coa_cost_src_cd like 'TRMT%'
                                GROUP BY lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd) c3

                            -- UOM 2 QTY
                            , (SELECT lnk_fm_nod_cd
                                     ,lnk_to_nod_cd
                                     ,cntr_tpsz_cd
                                     ,coa_cost_src_cd
                                     ,cost_src_qty AS uom_2_qty
                                FROM uom_qty
                               UNION ALL
                              SELECT lnk_fm_nod_cd
                                    ,lnk_to_nod_cd
                                    ,cntr_tpsz_cd
                                    ,'TR_MTY' AS coa_cost_src_cd
                                    ,SUM(cost_src_qty) cost_src_qty
                                FROM uom_qty
                               WHERE coa_cost_src_cd like 'TRMT%'
                               GROUP BY lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd) c4

                       WHERE c1.lnk_fm_nod_cd = c2.lnk_fm_nod_cd   -- C2
                         AND c1.lnk_to_nod_cd = c2.lnk_to_nod_cd
                         AND c1.cntr_tpsz_cd = c2.cntr_tpsz_cd
                         AND c1.uom_1_cd = c2.coa_cost_src_cd
                         AND c1.lnk_fm_nod_cd = c3.lnk_fm_nod_cd(+)   -- C3
                         AND c1.lnk_to_nod_cd = c3.lnk_to_nod_cd(+)
                         AND c1.cntr_tpsz_cd = c3.cntr_tpsz_cd(+)
                         AND c1.uom_1_cd = c3.coa_cost_src_cd(+)
                         AND c1.lnk_fm_nod_cd = c4.lnk_fm_nod_cd(+)   -- C4
                         AND c1.lnk_to_nod_cd = c4.lnk_to_nod_cd(+)
                         AND c1.cntr_tpsz_cd = c4.cntr_tpsz_cd(+)
                         AND c1.uom_2_cd = c4.coa_cost_src_cd(+)
                         AND decode(c3.uom_1_qty, NULL, 'X', 'O') || decode(c4.uom_2_qty, NULL, 'X', 'O') <> 'XX' -- QTY 1차, 2차 없으면 단가생성에서 제외
                            ) f1
                GROUP BY f1.lnk_fm_nod_cd, f1.lnk_to_nod_cd, f1.cntr_tpsz_cd, f1.coa_cost_src_cd) f2

            ON (    f1.cost_yrmon = f2.cost_yrmon
                AND f1.lnk_fm_nod_cd = f2.lnk_fm_nod_cd
                AND f1.lnk_to_nod_cd = f2.lnk_to_nod_cd
                AND f1.cntr_tpsz_cd = f2.cntr_tpsz_cd
                AND f1.co_cd = f2.co_cd
                AND f1.full_mty_cd = f2.full_mty_cd
                AND f1.cost_loc_grp_cd = f2.cost_loc_grp_cd
                AND f1.coa_cost_src_cd = f2.coa_cost_src_cd)
            WHEN NOT MATCHED THEN
               INSERT(f1.cost_yrmon, f1.full_mty_cd, f1.cntr_tpsz_cd, f1.co_cd, f1.cost_loc_grp_cd, f1.lnk_fm_nod_cd
                     ,f1.lnk_to_nod_cd, f1.coa_cost_src_cd, f1.locl_curr_cd, f1.stnd_cost_usd_amt, f1.cost_ass_bse_cd
                     ,f1.lnk_ttl_qty, f1.lnk_ttl_amt, f1.cost_vol_cd, f1.cre_usr_id, f1.cre_dt, f1.upd_usr_id, f1.upd_dt)
               VALUES(f2.cost_yrmon, f2.full_mty_cd, f2.cntr_tpsz_cd, f2.co_cd, f2.cost_loc_grp_cd, f2.lnk_fm_nod_cd
                     ,f2.lnk_to_nod_cd, f2.coa_cost_src_cd, f2.locl_curr_cd, f2.stnd_cost_usd_amt, f2.cost_ass_bse_cd
                     ,f2.lnk_ttl_qty, f2.lnk_ttl_amt, f2.cost_vol_cd, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)
            WHEN MATCHED THEN
               UPDATE
                  SET f1.locl_curr_cd = f2.locl_curr_cd, f1.stnd_cost_usd_amt = f2.stnd_cost_usd_amt
                     ,f1.cost_ass_bse_cd = f2.cost_ass_bse_cd, f1.lnk_ttl_qty = f2.lnk_ttl_qty
                     ,f1.lnk_ttl_amt = f2.lnk_ttl_amt, f1.cost_vol_cd = f2.cost_vol_cd, f1.upd_usr_id = 'SYS_COA_UPD'
                     ,f1.upd_dt = sysdate
               ;

           v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
           enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'NODE MTY Merge: ' || SQL%ROWCOUNT);
           

--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- Location
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'LOC';
   MERGE INTO coa_lnk_avg_stnd_cost e1
      USING (SELECT   a1.cost_yrmon
                     ,nvl(coa_loc_fnc(a1.lnk_fm_nod_cd, 'LOC'), ' ') lnk_fm_nod_cd
                     ,nvl(coa_loc_fnc(a1.lnk_to_nod_cd, 'LOC'), ' ') lnk_to_nod_cd
                     ,'H' co_cd
                     ,a1.cntr_tpsz_cd
                     ,a1.full_mty_cd
                     ,a1.coa_cost_src_cd
                     ,'C' cost_loc_grp_cd
                     ,'USD' locl_curr_cd
                     ,'A' cost_ass_bse_cd
                     ,SUM(a1.lnk_ttl_amt) lnk_ttl_amt
                     ,SUM(a1.lnk_ttl_qty) lnk_ttl_qty
                     ,DECODE(SUM(a1.lnk_ttl_qty),0 ,0
                            ,SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty)) stnd_cost_usd_amt
                 FROM coa_lnk_avg_stnd_cost a1, coa_cost_src_acct a2
                WHERE a1.cost_yrmon = in_cost_yrmon_dest
                  AND a1.cost_loc_grp_cd = 'N'
                  AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.
                  AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
                  AND a1.full_mty_cd = 'M'
             GROUP BY a1.cost_yrmon, a1.full_mty_cd, a1.cntr_tpsz_cd, nvl(coa_loc_fnc(a1.lnk_fm_nod_cd, 'LOC'), ' ')
                     ,nvl(coa_loc_fnc(a1.lnk_to_nod_cd, 'LOC'), ' '), a1.coa_cost_src_cd) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.lnk_fm_nod_cd = e2.lnk_fm_nod_cd
          AND e1.lnk_to_nod_cd = e2.lnk_to_nod_cd
          AND e1.co_cd = e2.co_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = sysdate
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'LOC: ' || SQL%ROWCOUNT);
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- SCC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'SCC';
   MERGE INTO coa_lnk_avg_stnd_cost e1
      USING (SELECT   a1.cost_yrmon
                     ,nvl(coa_loc_fnc(a1.lnk_fm_nod_cd, 'SCC'), ' ') lnk_fm_nod_cd
                     ,nvl(coa_loc_fnc(a1.lnk_to_nod_cd, 'SCC'), ' ') lnk_to_nod_cd
                     ,'H' co_cd
                     ,a1.cntr_tpsz_cd
                     ,a1.full_mty_cd
                     ,a1.coa_cost_src_cd
                     ,'S' cost_loc_grp_cd
                     ,'USD' locl_curr_cd
                     ,'A' cost_ass_bse_cd
                     ,SUM(a1.lnk_ttl_amt) lnk_ttl_amt
                     ,SUM(a1.lnk_ttl_qty) lnk_ttl_qty
                     ,DECODE(SUM(a1.lnk_ttl_qty),0 ,0
                            ,SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty)) stnd_cost_usd_amt
                 FROM coa_lnk_avg_stnd_cost a1, coa_cost_src_acct a2
                WHERE a1.cost_yrmon = in_cost_yrmon_dest
                  AND a1.cost_loc_grp_cd = 'N'
                  AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.
                  AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
                  AND a1.full_mty_cd = 'M'
             GROUP BY a1.cost_yrmon, a1.full_mty_cd, a1.cntr_tpsz_cd, nvl(coa_loc_fnc(a1.lnk_fm_nod_cd, 'SCC'), ' ')
                     ,nvl(coa_loc_fnc(a1.lnk_to_nod_cd, 'SCC'), ' '), a1.coa_cost_src_cd) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.lnk_fm_nod_cd = e2.lnk_fm_nod_cd
          AND e1.lnk_to_nod_cd = e2.lnk_to_nod_cd
          AND e1.co_cd = e2.co_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = sysdate
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'SCC: ' || SQL%ROWCOUNT);
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- ECC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'ECC';
   MERGE INTO coa_lnk_avg_stnd_cost e1
      USING (SELECT   a1.cost_yrmon
                     ,nvl(coa_loc_fnc(a1.lnk_fm_nod_cd, 'ECC'), ' ') lnk_fm_nod_cd
                     ,nvl(coa_loc_fnc(a1.lnk_to_nod_cd, 'ECC'), ' ') lnk_to_nod_cd
                     ,'H' co_cd
                     ,a1.cntr_tpsz_cd
                     ,a1.full_mty_cd
                     ,a1.coa_cost_src_cd
                     ,'E' cost_loc_grp_cd
                     ,'USD' locl_curr_cd
                     ,'A' cost_ass_bse_cd
                     ,SUM(a1.lnk_ttl_amt) lnk_ttl_amt
                     ,SUM(a1.lnk_ttl_qty) lnk_ttl_qty
                     ,DECODE(SUM(a1.lnk_ttl_qty) ,0 ,0
                            ,SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty)) stnd_cost_usd_amt
                 FROM coa_lnk_avg_stnd_cost a1, coa_cost_src_acct a2
                WHERE a1.cost_yrmon = in_cost_yrmon_dest
                  AND a1.cost_loc_grp_cd = 'N'
                  AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.
                  AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
                  AND a1.full_mty_cd = 'M'
             GROUP BY a1.cost_yrmon, a1.full_mty_cd, a1.cntr_tpsz_cd, nvl(coa_loc_fnc(a1.lnk_fm_nod_cd, 'ECC'), ' ')
                     ,nvl(coa_loc_fnc(a1.lnk_to_nod_cd, 'ECC'), ' '), a1.coa_cost_src_cd) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.lnk_fm_nod_cd = e2.lnk_fm_nod_cd
          AND e1.lnk_to_nod_cd = e2.lnk_to_nod_cd
          AND e1.co_cd = e2.co_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = sysdate
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'ECC: ' || SQL%ROWCOUNT);
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- LCC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'LCC';
   MERGE INTO coa_lnk_avg_stnd_cost e1
      USING (SELECT   a1.cost_yrmon
                     ,nvl(coa_loc_fnc(a1.lnk_fm_nod_cd, 'LCC'), ' ') lnk_fm_nod_cd
                     ,nvl(coa_loc_fnc(a1.lnk_to_nod_cd, 'LCC'), ' ') lnk_to_nod_cd
                     ,'H' co_cd
                     ,a1.cntr_tpsz_cd
                     ,a1.full_mty_cd
                     ,a1.coa_cost_src_cd
                     ,'L' cost_loc_grp_cd
                     ,'USD' locl_curr_cd
                     ,'A' cost_ass_bse_cd
                     ,SUM(a1.lnk_ttl_amt) lnk_ttl_amt
                     ,SUM(a1.lnk_ttl_qty) lnk_ttl_qty
                     ,DECODE(SUM(a1.lnk_ttl_qty) ,0 ,0
                            ,SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty)) stnd_cost_usd_amt
                 FROM coa_lnk_avg_stnd_cost a1, coa_cost_src_acct a2
                WHERE a1.cost_yrmon = in_cost_yrmon_dest
                  AND a1.cost_loc_grp_cd = 'N'
                  AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.
                  AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
                  AND a1.full_mty_cd = 'M'
             GROUP BY a1.cost_yrmon, a1.full_mty_cd, a1.cntr_tpsz_cd, nvl(coa_loc_fnc(a1.lnk_fm_nod_cd, 'LCC'), ' ')
                     ,nvl(coa_loc_fnc(a1.lnk_to_nod_cd, 'LCC'), ' '), a1.coa_cost_src_cd) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.lnk_fm_nod_cd = e2.lnk_fm_nod_cd
          AND e1.lnk_to_nod_cd = e2.lnk_to_nod_cd
          AND e1.co_cd = e2.co_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = sysdate
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'LCC: ' || SQL%ROWCOUNT);
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- RCC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'RCC';
   MERGE INTO coa_lnk_avg_stnd_cost e1
      USING (SELECT   a1.cost_yrmon
                     ,nvl(coa_loc_fnc(a1.lnk_fm_nod_cd, 'RCC'), ' ') lnk_fm_nod_cd
                     ,nvl(coa_loc_fnc(a1.lnk_to_nod_cd, 'RCC'), ' ') lnk_to_nod_cd
                     ,'H' co_cd
                     ,a1.cntr_tpsz_cd
                     ,a1.full_mty_cd
                     ,a1.coa_cost_src_cd
                     ,'R' cost_loc_grp_cd
                     ,'USD' locl_curr_cd
                     ,'A' cost_ass_bse_cd
                     ,SUM(a1.lnk_ttl_amt) lnk_ttl_amt
                     ,SUM(a1.lnk_ttl_qty) lnk_ttl_qty
                     ,DECODE(SUM(a1.lnk_ttl_qty) ,0 ,0
                            ,SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty)) stnd_cost_usd_amt
                 FROM coa_lnk_avg_stnd_cost a1, coa_cost_src_acct a2
                WHERE a1.cost_yrmon = in_cost_yrmon_dest
                  AND a1.cost_loc_grp_cd = 'N'
                  AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.
                  AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
                  AND a1.full_mty_cd = 'M'
             GROUP BY a1.cost_yrmon, a1.full_mty_cd, a1.cntr_tpsz_cd, nvl(coa_loc_fnc(a1.lnk_fm_nod_cd, 'RCC'), ' ')
                     ,nvl(coa_loc_fnc(a1.lnk_to_nod_cd, 'RCC'), ' '), a1.coa_cost_src_cd) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.lnk_fm_nod_cd = e2.lnk_fm_nod_cd
          AND e1.lnk_to_nod_cd = e2.lnk_to_nod_cd
          AND e1.co_cd = e2.co_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = sysdate
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'RCC: ' || SQL%ROWCOUNT);

--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- BOX tpsz
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'BOX tpsz';
   MERGE INTO coa_lnk_avg_stnd_cost e1
      USING (SELECT   a1.cost_yrmon
                     ,a1.lnk_fm_nod_cd
                     ,a1.lnk_to_nod_cd
                     ,'H' co_cd
                     ,'BOX' AS cntr_tpsz_cd
                     ,a1.full_mty_cd
                     ,a1.coa_cost_src_cd
                     ,a1.cost_loc_grp_cd
                     ,'USD' AS locl_curr_cd
                     ,'A' AS cost_ass_bse_cd
                     ,SUM(a1.lnk_ttl_amt) AS lnk_ttl_amt
                     ,SUM(a1.lnk_ttl_qty) AS lnk_ttl_qty
                     ,SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty) AS stnd_cost_usd_amt
                 FROM coa_lnk_avg_stnd_cost a1
                     ,coa_cost_src_acct a2
                WHERE a1.coa_cost_src_cd = a2.coa_cost_src_cd
                  AND a1.cost_yrmon = in_cost_yrmon_dest
                  AND a1.lnk_ttl_amt > 0   -- AMT 가 0인것이 있음
                  AND a1.lnk_ttl_qty > 0
                  AND a1.cntr_tpsz_cd NOT IN ('20', '40', 'BOX')    -- 전월 데이터를 copy 했기 때문에 제외
                  AND a2.cost_src_sys_cd = 'TRS'
                  AND a2.cost_ut_amt_cd = 'BOX' -- 단가를 붙일때 BOX인것만 사용함.
                  AND a1.full_mty_cd = 'M'
             GROUP BY a1.cost_yrmon, a1.lnk_fm_nod_cd, a1.lnk_to_nod_cd, 'BOX', a1.full_mty_cd, a1.coa_cost_src_cd
                     ,a1.cost_loc_grp_cd) e2
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.lnk_fm_nod_cd = e2.lnk_fm_nod_cd
          AND e1.lnk_to_nod_cd = e2.lnk_to_nod_cd
          AND e1.co_cd = e2.co_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = sysdate
         ;
   v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'BOX tpsz: ' || SQL%ROWCOUNT);

--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- EQR  Mty 단가제공 20070327 현업 협의된 사항
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
--   v_coa_step := 'REPO LNK DEL';  // 2015.02.17 coa_cntr_repo_lnk_cost 없음
--
--   DELETE FROM coa_cntr_repo_lnk_cost
--         WHERE cost_yrmon = in_cost_yrmon_dest;
--
--   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'COA_CNTR_REPO_LNK_COST: ' || SQL%ROWCOUNT || ' DELETE');
--   v_coa_step := 'REPO LNK INS';
--
--   INSERT INTO coa_cntr_repo_lnk_cost
--               (cost_yrmon
--               ,lnk_fm_ecc_cd
--               ,lnk_to_ecc_cd
--               ,cntr_tpsz_cd
--               ,trsp_mod_cd
--               ,lnk_uc_amt
--               ,lnk_tp_flg
--               ,lnk_ttl_qty
--               ,lnk_ttl_amt
--               ,cre_usr_id
--               ,cre_dt
--               ,upd_usr_id
--               ,upd_dt
--               )
--      SELECT   cost_yrmon
--              ,lnk_fm_nod_cd lnk_fm_ecc_cd
--              ,lnk_to_nod_cd lnk_to_ecc_cd
--              ,cntr_tpsz_cd
--              ,substr(coa_cost_src_cd, 5, 2) trsp_mod_cd
--              ,stnd_cost_usd_amt lnk_uc_amt
--              ,decode(lnk_fm_nod_cd, lnk_to_nod_cd, 'Y', 'N') lnk_tp_flg
--              ,SUM(lnk_ttl_qty) lnk_ttl_qty
--              ,SUM(lnk_ttl_amt) lnk_ttl_amt
--              ,'SYS_COA_CRE'
--              ,sysdate
--              ,'SYS_COA_CRE'
--              ,sysdate
--          FROM coa_lnk_avg_stnd_cost
--         WHERE full_mty_cd = 'M'
--           AND cost_yrmon = in_cost_yrmon_dest
--           AND cost_loc_grp_cd = 'E'   -- ECC
--      GROUP BY cost_yrmon, lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd, substr(coa_cost_src_cd, 5, 2)
--              ,decode(lnk_fm_nod_cd, lnk_to_nod_cd, 'Y', 'N'), stnd_cost_usd_amt;
--
--   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'COA_CNTR_REPO_LNK_COST: ' || SQL%ROWCOUNT || ' INSERT');
   enis_log_prc(sysdate
               ,'COA_LNK_AVG_STND_COST_MTY_PRC'
               , '소요시간: ' || to_char(systimestamp - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff')
               );
EXCEPTION
   WHEN OTHERS
   THEN
      enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_MTY_PRC', 'Error!! ' || v_coa_step || ' >> ' || sqlerrm);
END COA_LNK_AVG_STND_COST_MTY_PRC;