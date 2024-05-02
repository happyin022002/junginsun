CREATE OR REPLACE PROCEDURE OPUSADM.COA_CREATE_SPC_CHT_PRC (
   in_yr           IN       VARCHAR2
  ,in_mon          IN       VARCHAR2
  ,in_wk           IN       VARCHAR2
  ,in_trd_cd       IN       VARCHAR2
  ,in_rlane_cd     IN       VARCHAR2
  ,in_vsl_cd       IN       VARCHAR2
  ,in_skd_voy_no   IN       VARCHAR2
  ,in_dir_cd       IN       VARCHAR2
  ,in_user_id      IN       VARCHAR2
  ,in_log_lvl      IN       VARCHAR2 DEFAULT '9'
  ,out_err_cd      OUT      VARCHAR2
  ,out_err_msg     OUT      VARCHAR2
)
Authid current_user
IS
   /*
     1.Name       : COA_CREATE_SPC_CHT_PRC
     2.Create Date: 2007-01.09
     3.Description:
         - 용도: 1. 선복 임대차 수입 비용 생성

         - 파라미터: 년,월,주차,trade,revenue lane,ioc,vvd
         - 특이사항

     EX)
        SELECT * FROM ENIS_LOG
        WHERE MOD_NAME = 'COA_CREATE_SPC_CHT_PRC'
          AND EXEC_DT > SYSDATE - 1/24
        ORDER BY EXEC_DT DESC;

     4.Revision History
   */

   /* 선복 임대차 수입/비용 대상 항차 선정 */
   CURSOR nt_vvd_list_cur IS
      SELECT b1.trd_cd
            ,b1.rlane_cd
            ,b1.ioc_cd
            ,b1.vsl_cd
            ,b1.skd_voy_no
            ,b1.dir_cd
            ,b1.slan_cd
            ,NVL (b1.bsa_zr_flg, 'N') bsa_zr_flg   -- BSA Flg Missing 생성 여부에 사용
            ,b3.incm_bzc_chtr_cd   -- I:Income, C:Cost
            ,b3.incm_sub_lse_cd
            ,b3.incm_crs_chtr_cd
            ,b3.expn_bzc_chtr_cd   -- I:Income, C:Cost
            ,b3.expn_sub_chtr_cd
            ,b3.expn_crs_chtr_cd
            ,b2.vsl_lane_tp_cd
            ,b3.vop_cd
        FROM coa_mon_vvd b1
            ,coa_lane_rgst b2
            ,coa_slt_chtr_info b3   -- ROW 3개 짜리
            ,coa_vsl_rgst b4
       WHERE NVL (b1.delt_flg, 'N') = 'N'
         AND b1.rlane_cd = b2.rlane_cd
         AND b1.dir_cd = b2.dir_cd
         AND b1.trd_cd = b2.trd_cd
         AND b1.ioc_cd = b2.ioc_cd
         AND b1.vsl_cd = b4.vsl_cd(+)
         AND TO_CHAR (b1.n1st_lodg_port_etd_dt, 'YYYYMMDD') BETWEEN NVL (TO_CHAR (b4.vsl_aply_fm_dt(+), 'YYYYMMDD'), '19000101')
                                                                AND NVL (TO_CHAR (b4.vsl_aply_to_dt(+), 'YYYYMMDD'), '99991231')
         AND SUBSTR (b2.vsl_lane_tp_cd, 1, 1) = b3.slt_tp_cd
         AND DECODE (SUBSTR (b2.vsl_lane_tp_cd, 1, 1), 'S', 'OTH', b4.vop_cd) = b3.vop_cd   -- CO, OTH
         AND DECODE(in_mon, NULL, b1.sls_yrmon, b1.cost_yrmon) LIKE in_yr || in_mon || '%'
         AND b1.cost_wk      = NVL(in_wk, cost_wk)
         AND b1.trd_cd       = NVL (in_trd_cd, b1.trd_cd)
         AND b1.rlane_cd     = NVL (in_rlane_cd, b1.rlane_cd)
         AND b1.vsl_cd       = NVL (in_vsl_cd, b1.vsl_cd)
         AND b1.skd_voy_no   = NVL (in_skd_voy_no, b1.skd_voy_no)
         AND b1.dir_cd       = NVL (in_dir_cd, b1.dir_cd)
         AND NVL (b2.trnk_ipt_flg, 'N') <> 'Y'
         AND b3.cre_slct_flg = 'Y';

   ------------------------------[ 변수선언부             ]-----------------------
   /* 선복 임대차 비용생성 유무를 저장 */
   v_incm_bzc_flg    VARCHAR (1)     := 'P';
   v_incm_sub_flg    VARCHAR (1)     := 'P';
   v_incm_crs_flg    VARCHAR (1)     := 'P';
   v_expn_bzc_flg    VARCHAR (1)     := 'P';
   v_expn_sub_flg    VARCHAR (1)     := 'P';
   v_expn_crs_flg    VARCHAR (1)     := 'P';
   /* 선복 임대차 비용/수입 저장 */
   v_incm_bzc_amt    NUMBER (25, 13) := 0;
   v_incm_sub_amt    NUMBER (25, 13) := 0;
   v_incm_crs_amt    NUMBER (25, 13) := 0;
   v_expn_bzc_amt    NUMBER (25, 13) := 0;
   v_expn_sub_amt    NUMBER (25, 13) := 0;
   v_expn_crs_amt    NUMBER (25, 13) := 0;
   v_CO_rto         NUMBER (25, 13) := 0;
   v_cht_rto         NUMBER (25, 13) := 0;
   v_bsa_capa        NUMBER (25, 13) := 0;
   /* 오류 변수 선언 */
   v_cost_calc_rmk   VARCHAR2 (1000);
   v_step            VARCHAR2 (100);
   v_log_mod_nm      VARCHAR2 (30)   := 'COA_CREATE_SPC_CHT_PRC';
   v_start_time      TIMESTAMP;
BEGIN
   enis_log_prc ('', v_log_mod_nm, '[V.20100114]', NULL);

   IF (in_log_lvl <= '2') THEN
      v_start_time := SYSTIMESTAMP;
   END IF;

   --////////////////////////////////////////////////////////////////////////////////////
   -- Missing 리스트 삭제
   --////////////////////////////////////////////////////////////////////////////////////
   IF (in_wk IS NULL) THEN
      DELETE FROM coa_mss_sts
            WHERE prc_nm = 'COA_CREATE_SPC_CHT_PRC'
              AND cost_yrwk = in_yr
              AND cost_mon = in_mon
              AND stnd_cost_cd = '54400000'   -- Space charterage
              AND trd_cd = NVL (in_trd_cd, trd_cd)
              AND rlane_cd = NVL (in_rlane_cd, rlane_cd)
              AND vsl_cd = NVL (in_vsl_cd, vsl_cd)
              AND skd_voy_no = NVL (in_skd_voy_no, skd_voy_no)
              AND dir_cd = NVL (in_dir_cd, dir_cd);

      IF (in_log_lvl <= '2') THEN
         enis_log_prc ('', v_log_mod_nm, 'COA_MSS_STS MON: ' || SQL%ROWCOUNT || ' 건 삭제', NULL);
      END IF;
   ELSE
      DELETE FROM coa_mss_sts
            WHERE prc_nm = 'COA_CREATE_SPC_CHT_PRC'
              AND cost_yrwk = in_yr || in_wk
              AND stnd_cost_cd = '54400000'   -- Space charterage
              AND trd_cd = NVL (in_trd_cd, trd_cd)
              AND rlane_cd = NVL (in_rlane_cd, rlane_cd)
              AND vsl_cd = NVL (in_vsl_cd, vsl_cd)
              AND skd_voy_no = NVL (in_skd_voy_no, skd_voy_no)
              AND dir_cd = NVL (in_dir_cd, dir_cd);

      IF (in_log_lvl <= '2') THEN
         enis_log_prc ('', v_log_mod_nm, 'COA_MSS_STS WK: ' || SQL%ROWCOUNT || ' 건 삭제', NULL);
      END IF;
   END IF;

   --///////////////////////////////////////////////////////////////////////////////////////
   -- 비용생성전 기존비용 초기화
   --///////////////////////////////////////////////////////////////////////////////////////
   UPDATE coa_vvd_hir
      SET ntwk_hir_cost_amt = 0
         ,ts_uc_amt = 0
         ,co_sls_amt = 0
         ,co_amt = 0
         ,ipt_asgn_amt = 0
         ,ts_ctrb_bse_cost_amt = 0
         ,cmmt_bse_cost_amt = 0
         ,upd_usr_id = 'SYS_COA_SPCCHT'
         ,upd_dt = SYSDATE
    WHERE stnd_cost_cd = '54400000'   -- Space charterage
      AND (trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd) IN(
             SELECT trd_cd
                   ,rlane_cd
                   ,ioc_cd
                   ,vsl_cd
                   ,skd_voy_no
                   ,dir_cd
               FROM coa_mon_vvd
              WHERE DECODE(in_mon, NULL, sls_yrmon, cost_yrmon) LIKE in_yr || in_mon || '%'
                AND cost_wk = NVL(in_wk, cost_wk)
                AND trd_cd = NVL(in_trd_cd, trd_cd)
                AND rlane_cd = NVL(in_rlane_cd, rlane_cd)
                AND vsl_cd = NVL(in_vsl_cd, vsl_cd)
                AND skd_voy_no = NVL(in_skd_voy_no, skd_voy_no)
                AND dir_cd = NVL(in_dir_cd, dir_cd));

   v_step := 'LOOP';

   FOR target_vvd_list IN nt_vvd_list_cur LOOP
      /**
      STND_COST_CD STND_COST_NM
      ----------------------------------------
      54400000 Space Charterage
      43102011 Space Charter Revenue
      **/

      /* 변수 초기화 */
      v_incm_bzc_flg := 'P';   -- P:Pass, F:Fail
      v_incm_sub_flg := 'P';
      v_incm_crs_flg := 'P';
      v_expn_bzc_flg := 'P';
      v_expn_sub_flg := 'P';
      v_expn_crs_flg := 'P';
      v_incm_bzc_amt := 0;
      v_incm_sub_amt := 0;
      v_incm_crs_amt := 0;
      v_expn_bzc_amt := 0;
      v_expn_sub_amt := 0;
      v_expn_crs_amt := 0;
      v_CO_rto := 0;
      v_cht_rto := 0;
      v_bsa_capa := 0;
      v_cost_calc_rmk := '';
      v_step := 'LOOP-CHT AMT CHECK';

      /* 선복 임대차 비용 생성조건에 부합되는지 CHECK FLAG 조회 */
      -- BSA & Slot-swap by VVD  화면 참조
      BEGIN
         SELECT NVL (incm_bzc_chtr_amt, 0) incm_bzc_chtr_amt   -- INCOME
               ,NVL (incm_sub_chtr_amt, 0) incm_sub_chtr_amt
               ,NVL (incm_crs_chtr_amt, 0) incm_crs_chtr_amt
               ,NVL (expn_bzc_chtr_amt, 0) expn_bzc_chtr_amt   -- EXPENSE
               ,NVL (expn_sub_chtr_amt, 0) expn_sub_chtr_amt
               ,NVL (expn_crs_chtr_amt, 0) expn_crs_chtr_amt
               ,CO_bsa_rto
               ,chtr_bsa_rto
               ,fnl_CO_bsa_capa
           INTO v_incm_bzc_amt   -- INCOME
               ,v_incm_sub_amt
               ,v_incm_crs_amt
               ,v_expn_bzc_amt   -- EXPENSE
               ,v_expn_sub_amt
               ,v_expn_crs_amt
               ,v_CO_rto
               ,v_cht_rto
               ,v_bsa_capa
           FROM bsa_vvd_mst
          WHERE vsl_cd = target_vvd_list.vsl_cd
            AND skd_voy_no = target_vvd_list.skd_voy_no
            AND skd_dir_cd = target_vvd_list.dir_cd
            AND trd_cd = target_vvd_list.trd_cd
            AND rlane_cd = target_vvd_list.rlane_cd;
      EXCEPTION
         WHEN NO_DATA_FOUND THEN
            v_cost_calc_rmk := 'not exist BSA & Slot-swap by VVD';
            v_incm_bzc_flg := 'E';
         WHEN OTHERS THEN
            RAISE;
      END;

      --////////////////////////////////////////////////////////////////////////////////////////////
      -- Charter 금액 누락 체크
      --////////////////////////////////////////////////////////////////////////////////////////////
      IF (    target_vvd_list.incm_bzc_chtr_cd IS NOT NULL   -- I:Income 체크 되어 있으나 금액이 0보다 작으면
          AND v_incm_bzc_amt <= 0
         ) THEN
         v_incm_bzc_flg := 'F';
         v_cost_calc_rmk := v_cost_calc_rmk || ', income basic charter amt is 0';
      END IF;

      IF (    target_vvd_list.incm_sub_lse_cd IS NOT NULL
          AND v_incm_sub_amt <= 0) THEN
         v_incm_sub_flg := 'F';
         v_cost_calc_rmk := v_cost_calc_rmk || ', income sub lease amt is 0';
      END IF;

      IF (    target_vvd_list.incm_crs_chtr_cd IS NOT NULL
          AND v_incm_crs_amt <= 0) THEN
         v_incm_crs_flg := 'F';
         v_cost_calc_rmk := v_cost_calc_rmk || ', income corss charter amt is 0';
      END IF;

      IF (    target_vvd_list.expn_bzc_chtr_cd IS NOT NULL   -- C:Cost 체크 되어 있으나 금액이 0보다 작으면
          AND v_expn_bzc_amt <= 0
         ) THEN
         v_expn_bzc_flg := 'F';
         v_cost_calc_rmk := v_cost_calc_rmk || ', expense basic charter amt is 0';
      END IF;

      IF (    target_vvd_list.expn_sub_chtr_cd IS NOT NULL
          AND v_expn_sub_amt <= 0) THEN
         v_expn_sub_flg := 'F';
         v_cost_calc_rmk := v_cost_calc_rmk || ', expense sub lease amt is 0';
      END IF;

      IF (    target_vvd_list.expn_crs_chtr_cd IS NOT NULL
          AND v_expn_crs_amt <= 0) THEN
         v_expn_crs_flg := 'F';
         v_cost_calc_rmk := v_cost_calc_rmk || ', expense corss charter amt is 0';
      END IF;

      /* 6개의 FLAG가 모두 'P:Pass'일경우 COA_VVD_HIR TABLE에 생성 */
      IF (   (v_incm_bzc_flg || v_incm_sub_flg || v_incm_crs_flg || v_expn_bzc_flg || v_expn_sub_flg || v_expn_crs_flg =
                                                                                                                'PPPPPP'
             )
          OR target_vvd_list.bsa_zr_flg = 'Y'   -- BSA Flag 체크 되어 있으면 Missing 체크 안함
         ) THEN
         v_step := 'LOOP-COA_MON_VVD UPDATE';

         --////////////////////////////////////////////////////////////////////////////////////////////////////
         -- COA_MON_VVD 정보 업데이트
         --////////////////////////////////////////////////////////////////////////////////////////////////////
         UPDATE coa_mon_vvd
            SET CO_bsa_rto = v_CO_rto   -- CO 비율
               ,chtr_bsa_rto = v_cht_rto   -- 임대 비율
               ,vvd_bsa_capa = v_bsa_capa
          WHERE vsl_cd = target_vvd_list.vsl_cd
            AND skd_voy_no = target_vvd_list.skd_voy_no
            AND dir_cd = target_vvd_list.dir_cd
            AND trd_cd = target_vvd_list.trd_cd
            AND rlane_cd = target_vvd_list.rlane_cd
            AND ioc_cd = target_vvd_list.ioc_cd;

         --///////////////////////////////////////////////////////////////////////////////////////////////////////////////
          -- SLOT CHARTRAGE 에서 호출시
          -- Slot Chater에서 넘어온 것은 Port별로 저장하지 않는다
          --///////////////////////////////////////////////////////////////////////////////////////////////////////////////
         v_step := 'LOOP-COA_VVD_HIR MERGE';
         MERGE INTO coa_vvd_hir a
            USING (SELECT target_vvd_list.trd_cd trd_cd
                         ,target_vvd_list.rlane_cd rlane_cd
                         ,target_vvd_list.ioc_cd ioc_cd
                         ,target_vvd_list.vsl_cd vsl_cd
                         ,target_vvd_list.skd_voy_no skd_voy_no
                         ,target_vvd_list.dir_cd dir_cd
                         ,'54400000' stnd_cost_cd   -- Space Charterage
                         , v_expn_bzc_amt + v_expn_sub_amt + v_expn_crs_amt ntwk_hir_cost_amt
                     FROM DUAL) b
            ON (    a.trd_cd = b.trd_cd
                AND a.rlane_cd = b.rlane_cd
                AND a.ioc_cd = b.ioc_cd
                AND a.vsl_cd = b.vsl_cd
                AND a.skd_voy_no = b.skd_voy_no
                AND a.dir_cd = b.dir_cd
                AND a.stnd_cost_cd = b.stnd_cost_cd)
            WHEN MATCHED THEN
               UPDATE
                  SET a.ntwk_hir_cost_amt = b.ntwk_hir_cost_amt, a.upd_usr_id = 'COA_INS_PASS', a.upd_dt = SYSDATE
            WHEN NOT MATCHED THEN
               INSERT (a.trd_cd, a.rlane_cd, a.ioc_cd, a.vsl_cd, a.skd_voy_no, a.dir_cd, a.stnd_cost_cd
                      ,a.ntwk_hir_cost_amt, a.cre_usr_id, a.cre_dt, a.upd_usr_id, a.upd_dt)
               VALUES (b.trd_cd, b.rlane_cd, b.ioc_cd, b.vsl_cd, b.skd_voy_no, b.dir_cd, b.stnd_cost_cd
                      ,b.ntwk_hir_cost_amt, 'COA_INS_PASS', SYSDATE, 'COA_INS_PASS', SYSDATE);
      END IF;

      --////////////////////////////////////////////////////////////////////////////////////////
      -- Missing 추가
      -- (!주의) bsa_zr_flg = 'Y' 도 Missing 에 추가 해서 데이터 이력은 남기나 화면에 표시하지는 않는다.
      --////////////////////////////////////////////////////////////////////////////////////////
      IF (v_incm_bzc_flg || v_incm_sub_flg || v_incm_crs_flg || v_expn_bzc_flg || v_expn_sub_flg || v_expn_crs_flg <>
                                                                                                                'PPPPPP'
         ) THEN
         v_cost_calc_rmk := v_cost_calc_rmk || ' >> ' || target_vvd_list.vsl_lane_tp_cd || ',' || target_vvd_list.vop_cd;
         MERGE INTO coa_mss_sts a1
            USING (SELECT 'COA_CREATE_SPC_CHT_PRC' prc_nm
                         ,in_yr || in_wk cost_yrwk
                         ,NVL (in_mon, 'XX') cost_mon
                         ,'54400000' stnd_cost_cd   -- Space Charterage
                         ,target_vvd_list.trd_cd trd_cd
                         ,target_vvd_list.ioc_cd ioc_cd
                         ,target_vvd_list.rlane_cd rlane_cd
                         ,target_vvd_list.vsl_cd vsl_cd
                         ,target_vvd_list.skd_voy_no skd_voy_no
                         ,target_vvd_list.dir_cd dir_cd
                         ,v_cost_calc_rmk cost_calc_rmk
                         ,target_vvd_list.bsa_zr_flg bsa_zr_flg
                     FROM DUAL) a2
            ON (    a1.prc_nm = a2.prc_nm
                AND a1.cost_yrwk = a2.cost_yrwk
                AND a1.cost_mon = a2.cost_mon
                AND a1.stnd_cost_cd = a2.stnd_cost_cd
                AND a1.trd_cd = a2.trd_cd
                AND a1.ioc_cd = a2.ioc_cd
                AND a1.rlane_cd = a2.rlane_cd
                AND a1.vsl_cd = a2.vsl_cd
                AND a1.skd_voy_no = a2.skd_voy_no
                AND a1.dir_cd = a2.dir_cd)
            WHEN NOT MATCHED THEN
               INSERT (a1.prc_nm
                     , a1.cost_yrwk
                     , a1.cost_mon
                     , a1.stnd_cost_cd
                     , a1.trd_cd
                     , a1.ioc_cd
                     , a1.rlane_cd
                     , a1.vsl_cd
                     , a1.skd_voy_no
                     , a1.dir_cd
                     , a1.cost_calc_rmk
                     , a1.bsa_zr_flg
                     , a1.cre_usr_id
                     , a1.cre_dt
                     , a1.upd_usr_id
                     , a1.upd_dt
               )VALUES(
                       a2.prc_nm
                     , a2.cost_yrwk
                     , a2.cost_mon
                     , a2.stnd_cost_cd
                     , a2.trd_cd
                     , a2.ioc_cd
                     , a2.rlane_cd
                     , a2.vsl_cd
                     , a2.skd_voy_no
                     , a2.dir_cd
                     , a2.cost_calc_rmk
                     , a2.bsa_zr_flg
                     , in_user_id
                     , SYSDATE
                     , in_user_id
                     , SYSDATE
               );
      END IF;
   END LOOP;

   v_step := 'COA_SLT_CHTR_INFO 결과 UPDATE';

   --/////////////////////////////////////////////////////////////////////////////////////
   -- COA_SLT_CHTR_INFO 결과 UPDATE
   -- Complete update 후 Missing 부분만 update
   --/////////////////////////////////////////////////////////////////////////////////////
   UPDATE coa_slt_chtr_info
      SET op_cre_sts_cd = 'C'   -- Complete
                             ;

   UPDATE coa_slt_chtr_info
      SET op_cre_sts_cd = 'M'   -- Missing
    WHERE (slt_tp_cd, vop_cd) IN (
             SELECT DISTINCT SUBSTR (a2.vsl_lane_tp_cd, 1, 1) slt_tp_cd
                            ,a3.vop_cd
                        FROM coa_mss_sts a1, coa_lane_rgst a2, coa_vsl_rgst a3
                       WHERE prc_nm          = 'COA_CREATE_SPC_CHT_PRC'
                         AND a1.cost_yrwk    = in_yr || in_wk
                         AND a1.cost_mon     = NVL (in_mon, 'XX')
                         AND a1.trd_cd       = NVL (in_trd_cd, a1.trd_cd)
                         AND a1.rlane_cd     = NVL (in_rlane_cd, a1.rlane_cd)
                         AND a1.vsl_cd       = NVL (in_vsl_cd, a1.vsl_cd)
                         AND a1.skd_voy_no   = NVL (in_skd_voy_no, a1.skd_voy_no)
                         AND a1.dir_cd       = NVL (in_dir_cd, a1.dir_cd)
                         AND a1.stnd_cost_cd = '54400000'
                         AND a1.bsa_zr_flg   = 'N'
                         AND a1.rlane_cd     = a2.rlane_cd
                         AND a1.dir_cd       = a2.dir_cd
                         AND a1.trd_cd       = a2.trd_cd
                         AND a1.ioc_cd       = a2.ioc_cd
                         AND a1.vsl_cd       = a3.vsl_cd
                         AND a3.lst_flg      = 'Y' );

   out_err_cd := '00000';
   out_err_msg := 'Completed!';
   enis_log_prc ('', v_log_mod_nm, 'END', NULL);

   IF (in_log_lvl <= '2') THEN
      enis_log_prc ('', v_log_mod_nm
                   , '소요시간: ' || TO_CHAR (SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
   END IF;
-------------------------------[ 예외처리부      ]-----------------------
EXCEPTION
   WHEN OTHERS THEN
      out_err_cd := SQLCODE;
      out_err_msg := SQLERRM;
      enis_log_prc ('', v_log_mod_nm, v_step || ' >> ERROR ' || SQLERRM, NULL);
      RAISE;
END coa_create_spc_cht_prc;