CREATE OR REPLACE PROCEDURE OPUSDEV.COA_CREATE_NTCOST_PRC (
   in_yr            IN       VARCHAR2
  ,in_mon           IN       VARCHAR2
  ,in_wk            IN       VARCHAR2
  ,in_trd_cd        IN       VARCHAR2
  ,in_rlane_cd      IN       VARCHAR2
  ,in_vsl_cd        IN       VARCHAR2
  ,in_skd_voy_no    IN       VARCHAR2
  ,in_dir_cd        IN       VARCHAR2
  ,in_user_id       IN       VARCHAR2
  ,in_log_lvl       IN       VARCHAR2 DEFAULT '9'
  ,out_error_code   OUT      VARCHAR2
  ,out_error_msg    OUT      VARCHAR2
)
Authid current_user
IS
/****************************************************************************** 
   Name         :   COA_CREATE_NTCOST_PRC 
   Purpose      :   선박운항 변/고정비 배부 로직
   Description  :   1. 파라미터: 년,월,주차,trade,revenue lane,ioc,vvd
                    2. 특이사항
                    3. Remaining Amount가 없다.   

   Revision History
      1. 2007.01.09 Initial Create
      2. 2015.02.11 SMY Updated comment for own vessel hire cost
      3. 2015.06.26 PCM Adding SC Operation      
      4. 2015.06.26 SMY Changing missing comment      
******************************************************************************/ 
   /*
     EX)
        SELECT * FROM ENIS_LOG
        WHERE MOD_NAME = 'COA_CREATE_NTCOST_PRC'
          AND EXEC_DT > SYSDATE - 1/24
        ORDER BY EXEC_DT DESC;

   */

   /* 고정비 대상 항차 선정 */
   CURSOR nt_vvd_list_cur IS
      SELECT DECODE(in_mon, NULL, b1.sls_yrmon, b1.cost_yrmon) sls_yrmon
            ,b5.stnd_cost_cd
            ,b5.stnd_cost_nm
            ,b4.vop_cd
            ,b4.vsl_oshp_cd
            ,b1.trd_cd
            ,b1.rlane_cd
            ,b1.ioc_cd
            ,b1.vsl_cd
            ,b1.skd_voy_no
            ,b1.dir_cd
            ,b1.slan_cd            
            ,decode(b2.vsl_lane_tp_cd, 'SC' ,b6.cntr_vsl_clss_capa, b4.vsl_clss_capa) vsl_clss_capa
            ,b2.vsl_lane_tp_cd
            ,b3.vsl_dbl_call_seq
            ,b3.loc_cd
            ,b3.ttl_tz_dys
            ,b3.sea_dys
            ,b3.port_dys
            ,b3.aply_voy_rto
            ,b3.clpt_seq
            ,b1.n1st_lodg_port_etd_dt,b4.vsl_aply_fm_dt,b4.vsl_retn_fm_dt
        FROM coa_mon_vvd b1
            ,coa_lane_rgst b2
            ,coa_mon_vvd_port_op_dys b3
            ,coa_vsl_rgst b4
            ,(SELECT   a2.stnd_cost_cd
                      ,a2.stnd_cost_nm
                      ,a1.vsl_oshp_cd
                      ,a1.vop_cd
                  FROM coa_ntwk_cost_cre a1, coa_stnd_acct a2
                 WHERE a1.cre_slct_flg = 'Y'
                   AND a1.stnd_cost_cd = a2.stnd_cost_cd
                   AND a2.mgrp_cost_cd IN('OV', 'OF')
                   -- Network Cost에 사용되는 비목 선정(Slot Cht 비용 제외)  2007.09.17 BY LHI
                   AND a2.stnd_cost_cd NOT IN ('54400000','54400010', '92200000', '92100000', '75000000')  -- 2015.06.26 PCM SC OP
              ORDER BY acct_dp_seq) b5
             ,mdm_vsl_cntr b6
       WHERE 1 = 1
         AND b1.vsl_cd     = b4.vsl_cd(+)
         AND b1.vsl_cd     = b6.vsl_cd
         AND b1.rlane_cd   = b2.rlane_cd
         AND b1.dir_cd     = b2.dir_cd
         AND b1.trd_cd     = b2.trd_cd
         AND b1.ioc_cd     = b2.ioc_cd
         AND b2.vsl_lane_tp_cd IN('JO', 'SC')
         AND b1.trd_cd      = b3.trd_cd
         AND b1.rlane_cd    = b3.rlane_cd
         AND b1.ioc_cd      = b3.ioc_cd
         AND b1.vsl_cd      = b3.vsl_cd
         AND b1.skd_voy_no  = b3.skd_voy_no
         AND b1.dir_cd      = b3.dir_cd
         AND b4.vop_cd      = b5.vop_cd
         AND b4.vsl_oshp_cd = NVL(b5.vsl_oshp_cd,b4.vsl_oshp_cd)
         AND TO_CHAR(b1.n1st_lodg_port_etd_dt, 'YYYYMMDD') BETWEEN NVL(TO_CHAR(b4.vsl_aply_fm_dt, 'YYYYMMDD'), '19000101')
                                                               AND NVL(TO_CHAR(b4.vsl_aply_to_dt, 'YYYYMMDD'), '99991231')
         AND DECODE(in_mon, NULL, b1.sls_yrmon, b1.cost_yrmon) LIKE in_yr || in_mon || '%'
         AND b1.cost_wk    = NVL(in_wk, cost_wk)
         AND b1.trd_cd     = NVL(in_trd_cd,     b1.trd_cd)
         AND b1.rlane_cd   = NVL(in_rlane_cd,   b1.rlane_cd)
         AND b1.vsl_cd     = NVL(in_vsl_cd,     b1.vsl_cd)
         AND b1.skd_voy_no = NVL(in_skd_voy_no, b1.skd_voy_no)
         AND b1.dir_cd     = NVL(in_dir_cd,     b1.dir_cd)
         AND NVL(b1.delt_flg, 'N') = 'N'
         
         union all
         
              SELECT DECODE(in_mon, NULL, b1.sls_yrmon, b1.cost_yrmon) sls_yrmon
            ,b5.stnd_cost_cd
            ,b5.stnd_cost_nm
            ,b4.vop_cd
            ,b4.vsl_oshp_cd
            ,b1.trd_cd
            ,b1.rlane_cd
            ,b1.ioc_cd
            ,b1.vsl_cd
            ,b1.skd_voy_no
            ,b1.dir_cd
            ,b1.slan_cd            
            ,decode(b2.vsl_lane_tp_cd, 'SC' ,b6.cntr_vsl_clss_capa, b4.vsl_clss_capa) vsl_clss_capa
            ,b2.vsl_lane_tp_cd
            ,b3.vsl_dbl_call_seq
            ,b3.loc_cd
            ,b3.ttl_tz_dys
            ,b3.sea_dys
            ,b3.port_dys
            ,b3.aply_voy_rto
            ,b3.clpt_seq
            ,b1.n1st_lodg_port_etd_dt,b4.vsl_aply_fm_dt,b4.vsl_retn_fm_dt
        FROM coa_mon_vvd b1
            ,coa_lane_rgst b2
            ,coa_mon_vvd_port_op_dys b3
            ,coa_vsl_rgst b4
            ,(SELECT   a2.stnd_cost_cd
                      ,a2.stnd_cost_nm
                      ,a1.vsl_oshp_cd
                      ,a1.vop_cd
                  FROM coa_ntwk_cost_cre a1, coa_stnd_acct a2
                 WHERE a1.cre_slct_flg = 'Y'
                   AND a1.stnd_cost_cd = a2.stnd_cost_cd
                   AND a2.mgrp_cost_cd IN('OV', 'OF','GE')
                   -- Network Cost에 사용되는 비목 선정(Slot Cht 비용 제외)  2007.09.17 BY LHI
                   AND a2.stnd_cost_cd IN ('75000000')
              ORDER BY acct_dp_seq) b5
             ,mdm_vsl_cntr b6
       WHERE 1 = 1
         AND b1.vsl_cd     = b4.vsl_cd(+)
         AND b1.vsl_cd     = b6.vsl_cd
         AND b1.rlane_cd   = b2.rlane_cd
         AND b1.dir_cd     = b2.dir_cd
         AND b1.trd_cd     = b2.trd_cd
         AND b1.ioc_cd     = b2.ioc_cd
         AND b2.vsl_lane_tp_cd IN('JO', 'SC')
         AND b1.trd_cd      = b3.trd_cd
         AND b1.rlane_cd    = b3.rlane_cd
         AND b1.ioc_cd      = b3.ioc_cd
         AND b1.vsl_cd      = b3.vsl_cd
         AND b1.skd_voy_no  = b3.skd_voy_no
         AND b1.dir_cd      = b3.dir_cd
         --AND b4.vop_cd      = b5.vop_cd
         AND b4.vsl_oshp_cd = NVL(b5.vsl_oshp_cd,b4.vsl_oshp_cd)
         AND TO_CHAR(b1.n1st_lodg_port_etd_dt, 'YYYYMMDD') BETWEEN NVL(TO_CHAR(b4.vsl_aply_fm_dt, 'YYYYMMDD'), '19000101')
                                                               AND NVL(TO_CHAR(b4.vsl_aply_to_dt, 'YYYYMMDD'), '99991231')
         AND DECODE(in_mon, NULL, b1.sls_yrmon, b1.cost_yrmon) LIKE in_yr || in_mon || '%'
         AND b1.cost_wk    = NVL(in_wk, cost_wk)
         AND b1.trd_cd     = NVL(in_trd_cd,     b1.trd_cd)
         AND b1.rlane_cd   = NVL(in_rlane_cd,   b1.rlane_cd)
         AND b1.vsl_cd     = NVL(in_vsl_cd,     b1.vsl_cd)
         AND b1.skd_voy_no = NVL(in_skd_voy_no, b1.skd_voy_no)
         AND b1.dir_cd     = NVL(in_dir_cd,     b1.dir_cd)
         AND NVL(b1.delt_flg, 'N') = 'N'
         
         ;

   ------------------------------[ 변수선언부             ]-----------------------
   v_commit_unit     PLS_INTEGER    := 10000;
   v_read_count      NUMBER(10)     := 0;
   v_step            VARCHAR2(1000);
   v_cost_calc_rmk   VARCHAR2(2000);
   v_port_usd_amt    NUMBER         := 0;
   v_cnl_usd_amt     NUMBER         := 0;
   v_op_cost_amt     NUMBER(25, 13) := 0;   -- OP Cost
   v_is_exist_mss    VARCHAR(1);   -- Y: Missing 있음, N: Missing 없음
   v_log_mod_nm      VARCHAR2(30)   := 'COA_CREATE_NTCOST_PRC';
   v_timestamp       TIMESTAMP;
   v_timestamp2      TIMESTAMP;
   v_timestamp3      TIMESTAMP;
   v_foil_csm        NUMBER(25, 13) := 0;   -- Fuel Oil comsumption
   v_foil_uc_amt     NUMBER(25, 13) := 0;   -- Fuel Oil Unit Cost
   v_yrmon           NUMBER(6)   :=0;
   v_yrwk            NUMBER(6)   :=0;
   v_rmk_yrmon       VARCHAR2(20);
   v_rmk_clss        VARCHAR2(20);
------------------------------- [ 업무로직 구현부] -------------------------------
BEGIN
   --/////////////////////////////////////////////////////////////////////////////////////
   -- 파라메터 로그 출력
   --/////////////////////////////////////////////////////////////////////////////////////
   enis_log_prc('', v_log_mod_nm, '[V.20100910]', NULL);
   enis_log_prc (sysdate, v_log_mod_nm, 'input param : ['|| in_yr
                                                    ||']['|| in_mon
                                                    ||']['|| in_wk
                                                    ||']['|| in_trd_cd
                                                    ||']['|| in_rlane_cd
                                                    ||']['|| in_vsl_cd
                                                    ||']['|| in_skd_voy_no
                                                    ||']['|| in_dir_cd
                                                    ||']['|| in_user_id
                                                    ||']','');

   --////////////////////////////////////////////////////////////////////////////////////
   -- Missing 리스트 삭제
   --////////////////////////////////////////////////////////////////////////////////////
   IF (in_wk IS NULL) THEN
      DELETE FROM coa_mss_sts
            WHERE prc_nm = 'COA_CREATE_NTCOST_PRC'
              AND cost_yrwk = in_yr
              AND cost_mon = in_mon
              AND stnd_cost_cd IN(SELECT stnd_cost_cd   -- 화면에서 선택된 계정만 삭제
                                    FROM coa_ntwk_cost_cre
                                   WHERE cre_slct_flg = 'Y')
              AND trd_cd     = NVL(in_trd_cd, trd_cd)
              AND rlane_cd   = NVL(in_rlane_cd, rlane_cd)
              AND vsl_cd     = NVL(in_vsl_cd, vsl_cd)
              AND skd_voy_no = NVL(in_skd_voy_no, skd_voy_no)
              AND dir_cd     = NVL(in_dir_cd, dir_cd);

      IF (in_log_lvl <= '2') THEN
         enis_log_prc('', v_log_mod_nm, 'COA_MSS_STS MON: ' || SQL%ROWCOUNT || ' 건 삭제', NULL);
      END IF;
   ELSE
      DELETE FROM coa_mss_sts
            WHERE prc_nm     = 'COA_CREATE_NTCOST_PRC'
              AND cost_yrwk  = in_yr || in_wk
              AND stnd_cost_cd IN(SELECT stnd_cost_cd   -- 화면에서 선택된 계정만 삭제
                                    FROM coa_ntwk_cost_cre
                                   WHERE cre_slct_flg = 'Y')
              AND trd_cd     = NVL(in_trd_cd, trd_cd)
              AND rlane_cd   = NVL(in_rlane_cd, rlane_cd)
              AND vsl_cd     = NVL(in_vsl_cd, vsl_cd)
              AND skd_voy_no = NVL(in_skd_voy_no, skd_voy_no)
              AND dir_cd     = NVL(in_dir_cd, dir_cd);

      IF (in_log_lvl <= '2') THEN
         enis_log_prc('', v_log_mod_nm, 'COA_MSS_STS WK: ' || SQL%ROWCOUNT || ' 건 삭제', NULL);
      END IF;
   END IF;

   --////////////////////////////////////////////////////////////////////////////////////
   -- 비용생성전 기존비용 Reset 2007.09.07 BY LHI
   -- 금액 0 으로 초기화
   --////////////////////////////////////////////////////////////////////////////////////
   UPDATE coa_vvd_hir   -- TS Allocation 화면에서 조회함
      SET ntwk_hir_cost_amt = 0
         ,ts_uc_amt = 0
         ,co_sls_amt = 0
         ,co_amt = 0
         ,ipt_asgn_amt = 0
         ,ts_ctrb_bse_cost_amt = 0
         ,cmmt_bse_cost_amt = 0
         ,upd_usr_id = in_user_id
         ,upd_dt = SYSDATE
    WHERE stnd_cost_cd IN(SELECT stnd_cost_cd
                            FROM coa_ntwk_cost_cre
                           WHERE cre_slct_flg = 'Y')
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

   IF (in_log_lvl <= '2') THEN
      enis_log_prc('', v_log_mod_nm, 'COA_VVD_HIR: ' || SQL%ROWCOUNT || ' 건 UPDATE', NULL);
   END IF;

   --////////////////////////////////////////////////////////////////////////////////////
   -- Vsl, Port 별 비용 삭제
   --////////////////////////////////////////////////////////////////////////////////////
   DELETE FROM coa_mon_vvd_port_cost
         WHERE stnd_cost_cd IN(SELECT stnd_cost_cd
                                 FROM coa_ntwk_cost_cre
                                WHERE cre_slct_flg = 'Y')
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

   IF (in_log_lvl <= '2') THEN
      enis_log_prc('', v_log_mod_nm, 'COA_MON_VVD_PORT_COST: ' || SQL%ROWCOUNT || ' 건 삭제', NULL);
   END IF;

   --////////////////////////////////////////////////////////////////////////////////////
   -- 고정비 대상을 선정
   --////////////////////////////////////////////////////////////////////////////////////
   IF (in_log_lvl <= '2') THEN
      enis_log_prc('', v_log_mod_nm, 'LOOP START', NULL);
   END IF;

    --////////////////////////////////////////////////////////////////////////////////////
    --53101000  Port Expense        -- 선박운항 변동비
    --53102000  Canal Transit Fee
    --53200000  Bunker
    --
    --54100000  Crew Expense        -- 선박운항 고정비
    --54150000  Vessel M&R
    --54180000  Telecom Expense
    --54200000  Store Supply Expense
    --54250000  Insurance
    --54300000  Lubricant Expense
    --54350000  Time Charterage
    --54400000  Space Charterage                       -- COA_CREATE_SPC_CHT_PRC 에서 처리
    --54450000  Depreciations
    --54550000  Other Operation Fixed Exp
    --75000000  General Expense
    --////////////////////////////////////////////////////////////////////////////////////
   --////////////////////////////////////////////////////////////////////////////////////
   -- LOOP 시작
   --////////////////////////////////////////////////////////////////////////////////////
   FOR target_vvd_list IN nt_vvd_list_cur LOOP
      v_op_cost_amt := 0;
      v_cost_calc_rmk := '';
      v_is_exist_mss := 'N';   -- Missing 없음
      --////////////////////////////////////////////////////////////////////////////////////
      -- Port/Canal Cost 산식 : 단가 * Port별 Apply Ratio
      --////////////////////////////////////////////////////////////////////////////////////
      v_step := 'Port/Canal Charge';
      IF (in_wk IS NULL) THEN
          v_rmk_yrmon := 'cost_yrmon';
      END IF;
      IF (in_mon IS NULL) THEN
          v_rmk_yrmon := 'sls_yrmon';
      END IF;
      v_rmk_clss := 'vsl_clss_capa';

      IF (    target_vvd_list.stnd_cost_cd = '53101000'   -- Port Expense
          AND target_vvd_list.loc_cd NOT IN('EGSCA', 'PAPCA')
         ) THEN
         BEGIN
--            IF ( (in_wk IS NULL AND in_yr||in_mon < '201010') OR (in_mon IS NULL AND in_yr||in_wk < '201040') ) THEN
                SELECT SUM(port_usd_amt) * target_vvd_list.aply_voy_rto usd_amt
                      ,SUM(port_usd_amt)
                      ,SUM(port_usd_amt) || '*' || target_vvd_list.aply_voy_rto cost_calc_rmk
                  INTO v_op_cost_amt
                      ,v_port_usd_amt
                      ,v_cost_calc_rmk
                  FROM coa_port_trf
                 WHERE 1=1 
--                   AND slan_cd              = slan_cd --target_vvd_list.slan_cd --service lane정보 사용안함
                   AND vsl_cd               = target_vvd_list.vsl_cd
                   AND skd_voy_no           = target_vvd_list.skd_voy_no
                   AND skd_dir_cd           = target_vvd_list.dir_cd
                   AND SUBSTR(tml_cd, 1, 5) = target_vvd_list.loc_cd;

         EXCEPTION
            WHEN OTHERS THEN
               v_op_cost_amt := NULL;
         END;

         IF (   v_op_cost_amt IS NULL
             OR v_op_cost_amt = 0) THEN
            v_is_exist_mss := 'Y';   -- Missing 있음

            IF (   v_port_usd_amt IS NULL
                OR v_port_usd_amt = 0) THEN
               v_cost_calc_rmk := 'Port Expense is not available'; -- 2015.06.26 Changing remark
            END IF;
         ELSE
            v_is_exist_mss := 'N';   -- Missing 없음
         END IF;
      END IF;

      IF (    target_vvd_list.stnd_cost_cd = '53102000'   -- Canal Transit Fee
          AND target_vvd_list.loc_cd IN('EGSCA', 'PAPCA')   -- 운하이고
          AND target_vvd_list.ioc_cd = 'O'   -- Ocean 구간일때
         ) THEN
         BEGIN
                SELECT SUM(port_usd_amt) * target_vvd_list.aply_voy_rto usd_amt
                      ,SUM(port_usd_amt)
                      ,SUM(port_usd_amt) || '*' || target_vvd_list.aply_voy_rto cost_calc_rmk
                  INTO v_op_cost_amt
                      ,v_cnl_usd_amt
                      ,v_cost_calc_rmk
                  FROM coa_port_trf
                 WHERE 1=1
--                   and slan_cd              = slan_cd --target_vvd_list.slan_cd --service lane정보 사용안함
                   AND vsl_cd               = target_vvd_list.vsl_cd
                   AND skd_voy_no           = target_vvd_list.skd_voy_no
                   AND skd_dir_cd           = target_vvd_list.dir_cd
                   AND SUBSTR(tml_cd, 1, 5) = target_vvd_list.loc_cd;
         EXCEPTION
            WHEN OTHERS THEN
               v_op_cost_amt := NULL;
         END;

         IF (   v_op_cost_amt IS NULL
             OR v_op_cost_amt = 0) THEN
            v_is_exist_mss := 'Y';   -- Missing 있음

            IF (   v_cnl_usd_amt IS NULL
                OR v_cnl_usd_amt = 0) THEN
               v_cost_calc_rmk := 'Canal Transit Fee is not available';  -- 2015.06.26 Changing remark
            END IF;
         ELSE
            v_is_exist_mss := 'N';   -- Missing 없음
         END IF;
      END IF;

      --////////////////////////////////////////////////////////////////////////////////////
      -- Bunker Cost 산식 : 일단 소모 톤량 * 톤당 단가 * 운항일수
      -- OWN/CHT VSL 모두 발생 2007.09.17 BY LHI
      --////////////////////////////////////////////////////////////////////////////////////
      IF target_vvd_list.stnd_cost_cd IN('53200000') THEN   /* Bunker */
         v_step := 'Bunker tariff';
         v_rmk_clss := 'vsl_clss_capa';

         BEGIN
            SELECT   (foil_csm * foil_uc_amt) * target_vvd_list.ttl_tz_dys
                   + (doil_csm * doil_uc_amt) * target_vvd_list.ttl_tz_dys amt
                  ,foil_csm
                  ,foil_uc_amt
                  ,    '('
                    || foil_csm
                    || '*'
                    || foil_uc_amt
                    || ') * '
                    || target_vvd_list.ttl_tz_dys
                    || '+ ('
                    || doil_csm
                    || '*'
                    || doil_uc_amt
                    || ') * '
                    || target_vvd_list.ttl_tz_dys cost_calc_rmk
              INTO v_op_cost_amt
                  ,v_foil_csm
                  ,v_foil_uc_amt
                  ,v_cost_calc_rmk
              FROM coa_bnk_trf
             WHERE rlane_cd = target_vvd_list.rlane_cd
               AND slan_cd = target_vvd_list.slan_cd
               AND cost_yrmon = target_vvd_list.sls_yrmon
               AND slan_dir_cd = target_vvd_list.dir_cd
               AND vsl_clss_capa = target_vvd_list.vsl_clss_capa;
         EXCEPTION
            WHEN OTHERS THEN
               v_op_cost_amt := NULL;
               v_cost_calc_rmk := 'Bunker Fee is not available';  -- 2015.06.26 Changing remark
         END;

         IF (   v_op_cost_amt IS NULL
             OR v_op_cost_amt = 0) THEN
            v_is_exist_mss := 'Y';   -- Missing 있음
            v_cost_calc_rmk := 'Bunker Fee is not available';  -- 2015.06.26 Changing remark
         ELSIF(   v_foil_csm IS NULL
               OR v_foil_csm = 0) THEN
            v_is_exist_mss := 'Y';   -- Missing 있음
            v_cost_calc_rmk := 'Bunker Fee is not available';  -- 2015.06.26 Changing remark
            v_cost_calc_rmk := 'Fuel Oil consumption is 0';
         ELSIF(   v_foil_uc_amt IS NULL
               OR v_foil_uc_amt = 0) THEN
            v_is_exist_mss := 'Y';   -- Missing 있음
            v_cost_calc_rmk := 'Bunker Fee is not available' || ',Fuel Oil Cost is 0';
         ELSE
            v_is_exist_mss := 'N';   -- Missing 없음
         END IF;
      END IF;


      --////////////////////////////////////////////////////////////////////////////////////
      -- Company 선박고정비 : 고정비 단가 * 운항일수
      -- Company 선박에만 발생
      -- COA_OWN_VSL_DLY_HIR <- 관리회계에서 I/F 받는 데이터
      --////////////////////////////////////////////////////////////////////////////////////
      IF target_vvd_list.stnd_cost_cd IN
                        ('54100000', '54150000', '54180000', '54200000', '54250000', '54300000', '54450000', '54550000') THEN
         v_step := 'Own Daily Hire';
         v_rmk_clss := 'vsl_clss_capa';

         BEGIN
            -- 비용없으면 평균사용함
            SELECT DECODE(SUM(dhir_amt), 0, SUM(avg_dhir_amt), SUM(dhir_amt)) * target_vvd_list.ttl_tz_dys amt
                   -- 2015.02.11  Updated comment
                   -- 2015.06.26  Changing remark
                  ,DECODE(NVL(SUM(dhir_amt),0), 0, DECODE(NVL(SUM(avg_dhir_amt),0),0, 'Own Vessel Hire is not available', SUM(avg_dhir_amt) ), SUM(dhir_amt)) 
--                                                   || '*' || target_vvd_list.ttl_tz_dys   -- 2015.06.26 Changing remark
                                                     ||' / Transit Time = ' || target_vvd_list.ttl_tz_dys 
                                                                                                          cost_calc_rmk  
 
              INTO v_op_cost_amt
                  ,v_cost_calc_rmk
              FROM (SELECT dhir_amt dhir_amt
                          ,0 avg_dhir_amt
                      FROM coa_own_vsl_dly_hir
                     WHERE cost_yrmon   = target_vvd_list.sls_yrmon
                       AND vsl_cd       = target_vvd_list.vsl_cd
                       AND stnd_cost_cd = target_vvd_list.stnd_cost_cd
                    UNION ALL
                    SELECT 0 dhir_amt
                          ,dhir_amt avg_dhir_amt
                      FROM coa_own_vsl_dly_hir
                     WHERE cost_yrmon    = target_vvd_list.sls_yrmon
                       AND vsl_cd        = 'XXXX'   -- vsl 이 없을경우 평균 사용
                       AND vsl_clss_capa = target_vvd_list.vsl_clss_capa
                       AND stnd_cost_cd  = target_vvd_list.stnd_cost_cd);
         EXCEPTION
            WHEN OTHERS THEN
               v_op_cost_amt := NULL;
               v_cost_calc_rmk := 'Own Vessel Hire is not available';  -- 2015.06.26  Changing remark
         END;

         IF (   v_op_cost_amt IS NULL
             OR v_op_cost_amt = 0) THEN
            v_is_exist_mss := 'Y';   -- Missing 있음
         ELSE
            v_is_exist_mss := 'N';   -- Missing 없음
         END IF;
      END IF; -- Company 선박 고정비

      --////////////////////////////////////////////////////////////////////////////////////
      -- 타선박용선료 : 용대선료 단가 * 운항일수
      -- CHT VSL에만 발생 2007.09.17 BY LHI
      --////////////////////////////////////////////////////////////////////////////////////
      IF target_vvd_list.stnd_cost_cd IN('54350000') THEN
         v_step := 'Time Chaterage';
         v_rmk_clss := 'vsl_clss_capa';

         BEGIN
            SELECT chrg_dhir_amt * target_vvd_list.ttl_tz_dys amt
                  , chrg_dhir_amt || '*' || target_vvd_list.ttl_tz_dys cost_calc_rmk
              INTO v_op_cost_amt
                  ,v_cost_calc_rmk
              FROM coa_chrg_vsl_dly_hir
             WHERE cost_yrmon = target_vvd_list.sls_yrmon
               AND vsl_cd     = target_vvd_list.vsl_cd;
         EXCEPTION
            WHEN OTHERS THEN
               v_op_cost_amt := NULL;
               v_cost_calc_rmk := 'Time Charterage is not available';   -- 2015.06.26  Changing remark
         END;

         IF (   v_op_cost_amt IS NULL
             OR v_op_cost_amt = 0) THEN
            v_is_exist_mss := 'Y';   -- Missing 있음
         ELSE
            v_is_exist_mss := 'N';   -- Missing 없음
         END IF;
      END IF; -- 타선박용선료

      -- Create VSL Table 화면에서 OPR 선택을 안했을 경우
      IF (target_vvd_list.vsl_oshp_cd IS NULL) THEN
         v_is_exist_mss := 'Y';
         v_cost_calc_rmk := 'OPR is empty';
      END IF;     
      
      
      --////////////////////////////////////////////////////////////////////////////////////
      -- General Expense: Vessel 별 일당 단가 * 운항일수
      -- Company 운항 선박에 발생
      -- COA_OWN_VSL_DLY_HIR 에 75000000 으로 들어가있음
      --////////////////////////////////////////////////////////////////////////////////////
      IF target_vvd_list.stnd_cost_cd IN ('75000000') THEN
         v_step := 'General Expense';
         v_rmk_clss := 'vsl_clss_capa';

         BEGIN
            -- 비용없으면 평균사용함
            SELECT DECODE(SUM(dhir_amt), 0, SUM(avg_dhir_amt), SUM(dhir_amt)) * target_vvd_list.ttl_tz_dys amt
                  ,DECODE(SUM(dhir_amt), 0, SUM(avg_dhir_amt), SUM(dhir_amt)) || '*' || target_vvd_list.ttl_tz_dys
                                                                                                          cost_calc_rmk
              INTO v_op_cost_amt
                  ,v_cost_calc_rmk
              FROM (SELECT dhir_amt dhir_amt
                          ,0 avg_dhir_amt
                      FROM coa_own_vsl_dly_hir
                     WHERE cost_yrmon   = target_vvd_list.sls_yrmon
                       AND vsl_cd       = target_vvd_list.vsl_cd
                       AND stnd_cost_cd = target_vvd_list.stnd_cost_cd
                    UNION ALL
                    SELECT 0 dhir_amt
                          ,dhir_amt avg_dhir_amt
                      FROM coa_own_vsl_dly_hir
                     WHERE cost_yrmon    = target_vvd_list.sls_yrmon
                       AND vsl_cd        = 'XXXX'   -- vsl 이 없을경우 평균 사용
                       AND vsl_clss_capa = target_vvd_list.vsl_clss_capa
                       AND stnd_cost_cd  = target_vvd_list.stnd_cost_cd);
         EXCEPTION
            WHEN OTHERS THEN
               v_op_cost_amt := NULL;
               v_cost_calc_rmk := 'General Expense is not available';  -- 2015.06.26  Changing remark
         END;

         IF (   v_op_cost_amt IS NULL
             OR v_op_cost_amt = 0) THEN
            v_is_exist_mss := 'Y';   -- Missing 있음
            v_cost_calc_rmk := 'General Expense is not available';
         ELSE
            v_is_exist_mss := 'N';   -- Missing 없음
         END IF;
      END IF; -- Company 선박 고정비

      --///////////////////////////////////////////////////////////////////////////////////
      -- Missing 처리
      --///////////////////////////////////////////////////////////////////////////////////
      IF (v_is_exist_mss = 'Y') THEN  
         v_cost_calc_rmk :=
               v_cost_calc_rmk  -- 2015.06.26  Changing remark
            || ' / '
            || 'Cost Month = '
            || target_vvd_list.sls_yrmon
            || ' / '
            || 'Service Lane = '
            || target_vvd_list.slan_cd
            || ' / '
--            || v_rmk_clss ||': '   -- 2015.02.11  COMMENT      
            || 'VSL Class Capa = '
            || target_vvd_list.vsl_clss_capa
--            || ']'  -- 2015.02.11  COMMENT
            ;
         MERGE INTO coa_mss_sts a1
            USING (SELECT 'COA_CREATE_NTCOST_PRC' prc_nm
                         , in_yr || in_wk cost_yrwk
                         ,NVL(in_mon, 'XX') cost_mon
                         ,target_vvd_list.stnd_cost_cd stnd_cost_cd
                         ,target_vvd_list.trd_cd trd_cd
                         ,target_vvd_list.ioc_cd ioc_cd
                         ,target_vvd_list.rlane_cd rlane_cd
                         ,target_vvd_list.vsl_cd vsl_cd
                         ,target_vvd_list.skd_voy_no skd_voy_no
                         ,target_vvd_list.dir_cd dir_cd
                         ,v_cost_calc_rmk cost_calc_rmk
                         ,'N' bsa_zr_flg
                     FROM DUAL) a2
            ON (    a1.prc_nm = a2.prc_nm
                AND a1.cost_yrwk = a2.cost_yrwk
                AND a1.cost_mon = a2.cost_mon
                AND a1.stnd_cost_cd = a2.stnd_cost_cd
                AND a1.trd_cd       = a2.trd_cd
                AND a1.ioc_cd       = a2.ioc_cd
                AND a1.rlane_cd     = a2.rlane_cd
                AND a1.vsl_cd       = a2.vsl_cd
                AND a1.skd_voy_no   = a2.skd_voy_no
                AND a1.dir_cd       = a2.dir_cd       )
            WHEN NOT MATCHED THEN
               INSERT(a1.prc_nm, a1.cost_yrwk, a1.cost_mon, a1.stnd_cost_cd, a1.trd_cd, a1.ioc_cd, a1.rlane_cd
                     ,a1.vsl_cd, a1.skd_voy_no, a1.dir_cd, a1.cre_dt, a1.cre_usr_id, a1.upd_dt, a1.upd_usr_id, a1.cost_calc_rmk, a1.bsa_zr_flg)
               VALUES(a2.prc_nm, a2.cost_yrwk, a2.cost_mon, a2.stnd_cost_cd, a2.trd_cd, a2.ioc_cd, a2.rlane_cd
                     ,a2.vsl_cd, a2.skd_voy_no, a2.dir_cd, SYSDATE, in_user_id, SYSDATE, in_user_id, a2.cost_calc_rmk, a2.bsa_zr_flg);
      END IF;

      IF (v_is_exist_mss = 'N') THEN
         --///////////////////////////////////////////////////////////////////////////////////////////////////////////////
         -- Missing 이 없으면 Port별 Data Insert
         --///////////////////////////////////////////////////////////////////////////////////////////////////////////////
         v_step := 'COA_MON_VVD_PORT_COST merge';
         MERGE INTO coa_mon_vvd_port_cost a
            USING (SELECT target_vvd_list.trd_cd trd_cd
                         ,target_vvd_list.rlane_cd rlane_cd
                         ,target_vvd_list.ioc_cd ioc_cd
                         ,target_vvd_list.vsl_cd vsl_cd
                         ,target_vvd_list.skd_voy_no skd_voy_no
                         ,target_vvd_list.dir_cd dir_cd
                         ,target_vvd_list.loc_cd loc_cd   -- NETWORK COST 에서 들어가는 정보
                         ,target_vvd_list.vsl_dbl_call_seq vsl_dbl_call_seq   -- NETWORK COST 에서 들어가는 정보
                         ,target_vvd_list.stnd_cost_cd stnd_cost_cd
                         ,v_op_cost_amt vsl_cost_amt
                         ,v_cost_calc_rmk cost_calc_rmk
                         ,target_vvd_list.clpt_seq clpt_seq
                         ,target_vvd_list.aply_voy_rto aply_voy_rto
                         ,target_vvd_list.sea_dys sea_dys
                         ,target_vvd_list.port_dys port_dys
                         ,target_vvd_list.ttl_tz_dys ttl_tz_dys
                         ,v_foil_csm foil_csm
                     FROM DUAL) b
            ON (    a.trd_cd           = b.trd_cd
                AND a.rlane_cd         = b.rlane_cd
                AND a.ioc_cd           = b.ioc_cd
                AND a.vsl_cd           = b.vsl_cd
                AND a.skd_voy_no       = b.skd_voy_no
                AND a.dir_cd           = b.dir_cd
                AND a.loc_cd           = b.loc_cd
                AND a.vsl_dbl_call_seq = b.vsl_dbl_call_seq
                AND a.stnd_cost_cd     = b.stnd_cost_cd)
            WHEN MATCHED THEN
               UPDATE
                  SET a.vsl_cost_amt = b.vsl_cost_amt, a.cost_calc_rmk = b.cost_calc_rmk, a.clpt_seq = b.clpt_seq
                     ,a.aply_voy_rto = b.aply_voy_rto, a.sea_dys = b.sea_dys, a.port_dys = b.port_dys
                     ,a.ttl_tz_dys   = b.ttl_tz_dys, a.foil_csm = b.foil_csm, a.upd_usr_id = 'SYS_COA_NTCOST'
                     ,a.upd_dt = SYSDATE
            WHEN NOT MATCHED THEN
               INSERT(a.trd_cd, a.rlane_cd, a.ioc_cd, a.vsl_cd, a.skd_voy_no, a.dir_cd, a.loc_cd, a.vsl_dbl_call_seq
                     ,a.stnd_cost_cd, a.vsl_cost_amt, a.cost_calc_rmk, a.clpt_seq, a.aply_voy_rto, a.sea_dys
                     ,a.port_dys, a.ttl_tz_dys, a.foil_csm, a.cre_usr_id, a.cre_dt, a.upd_usr_id, a.upd_dt)
               VALUES(b.trd_cd, b.rlane_cd, b.ioc_cd, b.vsl_cd, b.skd_voy_no, b.dir_cd, b.loc_cd, b.vsl_dbl_call_seq
                     ,b.stnd_cost_cd, b.vsl_cost_amt, b.cost_calc_rmk, b.clpt_seq, b.aply_voy_rto, b.sea_dys
                     ,b.port_dys, b.ttl_tz_dys, b.foil_csm, 'SYS_COA_NTCOST', SYSDATE, 'SYS_COA_NTCOST', SYSDATE);

         IF (in_log_lvl <= '1') THEN
            enis_log_prc('', v_log_mod_nm, 'COA_MON_VVD_PORT_COST: ' || SQL%ROWCOUNT || ' 건 MERGE', NULL);
         END IF;
      END IF;
   END LOOP;

   IF (in_log_lvl <= '1') THEN
      enis_log_prc('', v_log_mod_nm, 'LOOP END', NULL);
   END IF;

   --///////////////////////////////////////////////////////////////////////////////////////////////
   -- 계정(Slot Cht 비용 제외), Port별 비용을 coa_vvd_hir에 계정별 비용으로 집중 2007.09.17 BY LHI
   -- 금액을 0 처리함
   --///////////////////////////////////////////////////////////////////////////////////////////////
   MERGE INTO coa_vvd_hir b1
      USING   (
              SELECT    a1.trd_cd
                     ,  a1.rlane_cd
                     ,  a1.ioc_cd
                     ,  a1.vsl_cd
                     ,  a1.skd_voy_no
                     ,  a1.dir_cd
                     ,  a2.stnd_cost_cd
                     ,  SUM(a2.vsl_cost_amt)         AS ntwk_hir_cost_amt
               FROM     coa_mon_vvd                  a1
                     ,  coa_mon_vvd_port_cost        a2
               WHERE    a1.trd_cd                    = a2.trd_cd
                  AND   a1.rlane_cd                  = a2.rlane_cd
                  AND   a1.ioc_cd                    = a2.ioc_cd
                  AND   a1.vsl_cd                    = a2.vsl_cd
                  AND   a1.skd_voy_no                = a2.skd_voy_no
                  AND   a1.dir_cd                    = a2.dir_cd

                  AND   DECODE(  in_mon, NULL, a1.sls_yrmon
                                             , a1.cost_yrmon )
                                                     LIKE in_yr || in_mon || '%'

                  AND   a1.cost_wk                   = NVL(in_wk, a1.cost_wk)
                  AND   NVL(a1.delt_flg, 'N')        = 'N'
                  AND   a2.stnd_cost_cd              NOT IN('54400000','54400010')   -- Space Charterage 제외  -- 2015.06.26 PCM SC OP
                  AND   a2.stnd_cost_cd              IN( SELECT stnd_cost_cd
                                                         FROM   coa_ntwk_cost_cre
                                                         WHERE  cre_slct_flg       = 'Y'
                                                       )
                  AND   a1.trd_cd                    = NVL(in_trd_cd     , a1.trd_cd     )
                  AND   a1.rlane_cd                  = NVL(in_rlane_cd   , a1.rlane_cd   )
                  AND   a1.vsl_cd                    = NVL(in_vsl_cd     , a1.vsl_cd     )
                  AND   a1.skd_voy_no                = NVL(in_skd_voy_no , a1.skd_voy_no )
                  AND   a1.dir_cd                    = NVL(in_dir_cd     , a1.dir_cd     )
             GROUP BY   a1.trd_cd
                   ,    a1.rlane_cd
                   ,    a1.ioc_cd
                   ,    a1.vsl_cd
                   ,    a1.skd_voy_no
                   ,    a1.dir_cd
                   ,    a2.stnd_cost_cd
              ) b2

      ON  (             b1.vsl_cd                    = b2.vsl_cd
                  AND   b1.skd_voy_no                = b2.skd_voy_no
                  AND   b1.dir_cd                    = b2.dir_cd
                  AND   b1.rlane_cd                  = b2.rlane_cd
                  AND   b1.trd_cd                    = b2.trd_cd
                  AND   b1.ioc_cd                    = b2.ioc_cd
                  AND   b1.stnd_cost_cd              = b2.stnd_cost_cd
          )

      WHEN MATCHED THEN
         UPDATE
            SET         b1.ntwk_hir_cost_amt         = b2.ntwk_hir_cost_amt
                   ,    b1.ts_uc_amt                 = 0
                   ,    b1.co_sls_amt               = 0
                   ,    b1.co_amt                    = 0
                   ,    b1.n1st_asgn_amt             = b1.n1st_asgn_amt
                   ,    b1.ipt_asgn_amt              = 0
                   ,    b1.ts_ctrb_bse_cost_amt      = 0
                   ,    b1.cmmt_bse_cost_amt         = 0
                   ,    b1.ts_asgn_amt               = b1.ts_asgn_amt
                   ,    b1.upd_usr_id                = in_user_id
                   ,    b1.upd_dt                    = SYSDATE
      WHEN NOT MATCHED THEN
         INSERT  (      b1.trd_cd
                   ,    b1.rlane_cd
                   ,    b1.ioc_cd
                   ,    b1.vsl_cd
                   ,    b1.skd_voy_no
                   ,    b1.dir_cd
                   ,    b1.stnd_cost_cd
                   ,    b1.ntwk_hir_cost_amt
                   ,    b1.ts_uc_amt
                   ,    b1.co_sls_amt
                   ,    b1.co_amt
                   ,    b1.n1st_asgn_amt
                   ,    b1.ipt_asgn_amt
                   ,    b1.ts_ctrb_bse_cost_amt
                   ,    b1.cmmt_bse_cost_amt
                   ,    b1.ts_asgn_amt
                   ,    b1.cre_usr_id
                   ,    cre_dt
                   ,    b1.upd_usr_id
                   ,    upd_dt
                 )
         VALUES  (      b2.trd_cd
                   ,    b2.rlane_cd
                   ,    b2.ioc_cd
                   ,    b2.vsl_cd
                   ,    b2.skd_voy_no
                   ,    b2.dir_cd
                   ,    b2.stnd_cost_cd
                   ,    b2.ntwk_hir_cost_amt
                   ,    0                        /* ts_uc_amt              */
                   ,    0                        /* co_sls_amt            */
                   ,    0                        /* co_amt                 */
                   ,    0                        /* n1st_asgn_amt          */
                   ,    0                        /* ipt_asgn_amt           */
                   ,    0                        /* ts_ctrb_bse_cost_amt   */
                   ,    0                        /* cmmt_bse_cost_amt      */
                   ,    0                        /* ts_asgn_amt            */
                   ,    in_user_id
                   ,    SYSDATE
                   ,    in_user_id
                   ,    SYSDATE
                 ) ;


   IF (in_log_lvl <= '1') THEN
      enis_log_prc('', v_log_mod_nm, 'COA_VVD_HIR: ' || SQL%ROWCOUNT || ' 건 MERGE', NULL);
   END IF;

   --///////////////////////////////////////////////////////////////////////////////////////////////
   -- 결과 Table Update
   --///////////////////////////////////////////////////////////////////////////////////////////////
   UPDATE coa_ntwk_cost_cre
      SET cre_sts_cd = 'C';   -- C:Completed

   UPDATE coa_ntwk_cost_cre
      SET cre_sts_cd = 'M'   -- M:Missing
    WHERE stnd_cost_cd IN(
                           SELECT DISTINCT stnd_cost_cd
                             FROM coa_mss_sts
                            WHERE prc_nm    = 'COA_CREATE_NTCOST_PRC'
                              AND cost_yrwk = in_yr || in_wk
                              AND cost_mon  = NVL(in_mon, 'XX')
                              -- 처음 coa_mss_sts 초기회시 해당 주차혹은 원에 모든 로그를 삭제하는것이 아니기때문에
                              -- 정보 Update시에도 아래 추가한 정보에 해당하는 정보에 대해서만 진행하는것이 맞음
                              AND trd_cd     = NVL(in_trd_cd, trd_cd)
                              AND rlane_cd   = NVL(in_rlane_cd, rlane_cd)
                              AND vsl_cd     = NVL(in_vsl_cd, vsl_cd)
                              AND skd_voy_no = NVL(in_skd_voy_no, skd_voy_no)
                              AND dir_cd     = NVL(in_dir_cd, dir_cd)
                              )

    ;

   IF (in_log_lvl <= '1') THEN
      enis_log_prc('', v_log_mod_nm, 'COA_NTWK_COST_CRE: ' || SQL%ROWCOUNT || ' 건 UPDATE', NULL);
   END IF;

   out_error_code := '00000';   -- COA_CREATE_NTWK_COST_ALL_PRC 에서 체크 함
   out_error_msg := 'Completed!';
   enis_log_prc('', v_log_mod_nm, 'END', NULL);
--COMMIT;
---------------------------[ 예외처리부      ]-----------------------
EXCEPTION
   WHEN OTHERS THEN
      enis_log_prc('', v_log_mod_nm, v_step || ' >> ERROR ' || SQLERRM, NULL);
      RAISE;
END coa_create_ntcost_prc;