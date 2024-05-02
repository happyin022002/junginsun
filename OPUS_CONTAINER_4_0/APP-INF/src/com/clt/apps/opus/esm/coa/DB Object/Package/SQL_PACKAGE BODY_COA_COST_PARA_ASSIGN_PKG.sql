CREATE OR REPLACE PACKAGE BODY COA_COST_PARA_ASSIGN_PKG
AS
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- PRD 호출시 작업
--  (!주의) BKG_NO 는 NULL로 들어옴
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   PROCEDURE main_prd_avg(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
   )
   IS
      v_err_msg      VARCHAR2(4000);
      v_start_time   TIMESTAMP;
      v_appl_info    VARCHAR2(30);
   BEGIN
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- PCTL_NO 정보 셋팅
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_appl_info := in_start_pctl_no || ',' || SUBSTR(in_end_pctl_no, -3);
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 버전 및 기준년월 로그 출력
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'v.20141118 15:00 PRD', v_appl_info);
      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'in_cost_yrmon: ' || in_cost_yrmon, v_appl_info);
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- TES 평균단가
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'PARA_TES_AVG >> ';
--      v_start_time := SYSTIMESTAMP;
      v_err_msg := para_tes_avg(in_bkg_no, in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- TRS 평균단가
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'PARA_TRS_AVG  >> ';
--      v_start_time := SYSTIMESTAMP;
      v_err_msg := para_trs_avg(in_bkg_no, in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));

--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- FDR TERM 정리 작업
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'CLR_FDR_TERM >> ';
--      V_START_TIME := SYSTIMESTAMP;
      v_err_msg := clr_fdr_term(in_bkg_no, in_start_pctl_no, in_end_pctl_no, v_appl_info);
--      ENIS_LOG_PRC(SYSDATE
--                  ,'coa_cost_para_assign_pkg'
--                  , 'upd_fdr_term ' || TO_CHAR(SYSTIMESTAMP - V_START_TIME, 'yyyy/mm/dd hh24:mi:ss.ff')
--                  ,V_APPL_INFO
--                  );
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- TP(THROUGHPUT) 정리 작업
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'CLR_TES_TP >> ';
--      V_START_TIME := SYSTIMESTAMP;
      v_err_msg := clr_tes_tp(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, v_appl_info);
--      ENIS_LOG_PRC(SYSDATE, 'coa_cost_para_assign_pkg', 'upd_tes_tp ' || TO_CHAR(SYSTIMESTAMP - V_START_TIME, 'yyyy/mm/dd hh24:mi:ss.ff')
--                  ,V_APPL_INFO);

--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- Slot Internal Pricing Average Unit Cost
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'PARA_SLT_INTER_PRC  >> ';
--      v_start_time := SYSTIMESTAMP;
      v_err_msg := para_slt_inter_prc(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      ENIS_LOG_PRC(SYSDATE, 'coa_cost_para_assign_pkg', V_ERR_MSG || TO_CHAR(SYSTIMESTAMP - V_START_TIME, 'yyyy/mm/dd hh24:mi:ss.ff'), V_APPL_INFO);


   EXCEPTION
      WHEN OTHERS
      THEN
         enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Error main_prd_avg >> ' || v_err_msg || SQLERRM, v_appl_info);
         RAISE;
   END;

--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- COP 호출시 작업
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   PROCEDURE main_cop_avg(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
   )
   IS
      v_err_msg      VARCHAR2(4000);
      v_rslt         VARCHAR2(100);
      v_start_time   TIMESTAMP;
      v_appl_info    VARCHAR2(30);
   BEGIN
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- BKG_NO 정보 셋팅
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_appl_info := in_bkg_no;
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 버전 및 기준년월 로그 출력
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'v.20141118 COP', v_appl_info);
      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'in_cost_yrmon: ' || in_cost_yrmon, v_appl_info);
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- TES 평균단가
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'PARA_TES_AVG >> ';
--      v_start_time := SYSTIMESTAMP;
      v_rslt := para_tes_avg(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'),v_appl_info);
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- TES MTY 평균단가
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'PA_TES_MTY >> ';
--      v_start_time := SYSTIMESTAMP;
      v_rslt := pa_tes_mty(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES MTY Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'),v_appl_info);
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- TRS 평균단가
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'PARA_TRS_AVG  >> ';
--      v_start_time := SYSTIMESTAMP;
      v_rslt := para_trs_avg(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TRS Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'),v_appl_info);
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- DEM/DET 평균단가
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'PARA_DMDT  >> ';
--      v_start_time := SYSTIMESTAMP;
      v_rslt := para_dmdt(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- HLD 평균단가
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'UPD_ERP_HLD_COST_UC_AMT  >> ';
--      v_start_time := SYSTIMESTAMP;
      v_rslt := pa_hld(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- TRS MTY 평균단가
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'PA_TRS_MTY  >> ';
--      v_start_time := SYSTIMESTAMP;
      v_rslt := pa_trs_mty(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- FDR TERM 정리 작업
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := 'CLR_FDR_TERM >> ';
--      V_START_TIME := SYSTIMESTAMP;
      v_rslt := clr_fdr_term(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, v_appl_info);
--      ENIS_LOG_PRC(SYSDATE, 'coa_cost_para_assign_pkg', V_ERR_MSG || TO_CHAR(SYSTIMESTAMP - V_START_TIME, 'yyyy/mm/dd hh24:mi:ss.ff'), V_APPL_INFO);
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- TP(THROUGHPUT) 정리 작업
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := 'CLR_TES_TP >> ';
--      V_START_TIME := SYSTIMESTAMP;
      v_rslt := clr_tes_tp(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, v_appl_info);
--      ENIS_LOG_PRC(SYSDATE, 'coa_cost_para_assign_pkg', V_ERR_MSG || TO_CHAR(SYSTIMESTAMP - V_START_TIME, 'yyyy/mm/dd hh24:mi:ss.ff'), V_APPL_INFO);
-- AGT OTH 평균단가
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'PARA_AGT_OTH  >> ';
--      v_start_time := SYSTIMESTAMP;
      v_rslt := para_agt_oth(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'V_ERR_MSG ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- Slot Internal Pricing Average Unit Cost
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_start_pctl_no || 'PARA_SLT_INTER_PRC  >> ';
--      v_start_time := SYSTIMESTAMP;
      v_rslt := para_slt_inter_prc(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      ENIS_LOG_PRC(SYSDATE, 'coa_cost_para_assign_pkg', V_ERR_MSG || TO_CHAR(SYSTIMESTAMP - V_START_TIME, 'yyyy/mm/dd hh24:mi:ss.ff'), V_APPL_INFO);

--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- SO Cancel된 Activity의 비용을 0처리해준다.
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := in_bkg_no || 'PARA_SO_CANCEL  >> ';

      v_rslt := para_so_cancel(in_bkg_no, v_appl_info);
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'upd_so_cancel ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'), v_appl_info);
   EXCEPTION
      WHEN OTHERS
      THEN
         enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Error main_cop_avg >> ' || v_err_msg || SQLERRM, v_appl_info);
         RAISE;
   END;


--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- PRD 호출시 계산된 금액 합계를 PRD에 넣어줌
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   PROCEDURE main_prd_prod_ctl_mst(in_start_pctl_no IN VARCHAR2, in_end_pctl_no IN VARCHAR2, in_cost_yrmon IN VARCHAR2)
   IS
      v_err_msg      VARCHAR2(4000);
      v_start_time   TIMESTAMP;
      v_appl_info    VARCHAR2(30);
   BEGIN
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- PCTL_NO 정보 셋팅
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_appl_info := in_start_pctl_no || ',' || SUBSTR(in_end_pctl_no, -3);
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 계산된 금액 합계 작업
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := 'CALC_PRD_SUM_COST >> ';
--      v_start_time := SYSTIMESTAMP;
      v_err_msg := calc_prd_sum_cost(in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
   EXCEPTION
      WHEN OTHERS
      THEN
         enis_log_prc(SYSDATE, 'main_prd_prod_ctl_mst', 'Error upd_prd_prod_ctl_mst >> ' || v_err_msg || SQLERRM, v_appl_info);
         RAISE;
   END;

--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 로컬 단가를 USD 로 전환 및 금액 계산(단가*수량)
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   PROCEDURE main_com_ttl_para(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
   )
   IS
      v_err_msg      VARCHAR2(4000);
      v_rslt         VARCHAR2(100);
      v_start_time   TIMESTAMP;
      v_appl_info    VARCHAR2(30);
   BEGIN
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- PCTL_NO, BKG_NO 정보 셋팅
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      IF (in_bkg_no IS NULL)
      THEN
         v_appl_info := in_start_pctl_no || ',' || SUBSTR(in_start_pctl_no, -3);
      ELSE
         v_appl_info := in_bkg_no || '#';
      END IF;

--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 경리환율 및 금액 계산
--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      v_err_msg := 'CALC_TTL_COST >> ';
--      V_START_TIME := SYSTIMESTAMP;
      v_rslt := calc_ttl_cost(in_bkg_no,  in_start_pctl_no, in_end_pctl_no, in_cost_yrmon, v_appl_info);
--      ENIS_LOG_PRC(SYSDATE, 'coa_cost_para_assign_pkg', V_ERR_MSG || TO_CHAR(SYSTIMESTAMP - V_START_TIME, 'yyyy/mm/dd hh24:mi:ss.ff'), V_APPL_INFO);
   --
   EXCEPTION
      WHEN OTHERS
      THEN
         enis_log_prc(SYSDATE, 'main_ttl_para', 'Error main_com_ttl_para >> ' || v_err_msg || SQLERRM, v_appl_info);
         RAISE;
   END;

/************************************************************************************************************
 * PARA_TES_AVG
 ***********************************************************************************************************/
   FUNCTION para_tes_avg(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2
   IS
      CURSOR para_cost_cursor
      IS
         SELECT   pctl_no
                 ,cost_rout_no --Pre_CM 용인지 확인하기 위해 length check
                 ,bkg_cgo_tp_cd
             FROM coa_com_para
            WHERE NVL(bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
              AND pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
         ORDER BY pctl_no;
         
-------------DECLARE----------------------------
      v_trd_cd       coa_rgst_bkg.trd_cd%TYPE; --loc 단가 Pre_CM 단가 생성용 정보
      v_err_msg      VARCHAR2(4000);
      v_start_time   TIMESTAMP;
------------------------------------------------      
   BEGIN
      BEGIN
--         enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:in_cost_yrmon : ' || in_cost_yrmon,in_appl_info);
         FOR para_cost_list IN para_cost_cursor
         LOOP
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:pctl_no : ' || para_cost_list.pctl_no, in_appl_info);
            -- 노드
            -- NOD 단가
--            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_NOD_AVG_STND_COST) */ c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_cd
                            ,c2.stnd_cost_usd_amt
                            ,c1.ctrt_rtn_flg
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,n1st_nod_cd nod_cd
                                    ,ctrt_rtn_flg
                                    ,cost_act_grp_cd
                                FROM coa_com_cost_para
                               WHERE pctl_no = para_cost_list.pctl_no
--                                 AND COST_ASS_BSE_CD = DECODE(IN_PRC_NO, 1, 'A', 'C')   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND NVL(estm_uc_amt, 0) = 0
--                                 AND NVL(CTRT_RTN_FLG, 'N') =
--                                                           DECODE(IN_PRC_NO
--                                                                 ,1, NVL(CTRT_RTN_FLG, 'N')
--                                                                 ,'N'
--                                                                 )   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND ctrt_rtn_flg = 'N'
                                 AND cost_src_sys_cd = 'TES') c1
                            ,coa_nod_avg_stnd_cost c2
                       WHERE c2.cost_yrmon = in_cost_yrmon
                         AND c2.full_mty_cd = 'F'
                         AND c2.cost_loc_grp_cd = 'N'   -- NOD
                         AND c1.cntr_tpsz_cd_2 = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                         AND c1.nod_cd = c2.nod_cd
                          --------- TRADE별 단가 적용 START ------------
                         AND NVL(c2.trd_cd, 'NNN') = NVL((SELECT c3.trd_cd from coa_nod_avg_stnd_cost c3
                                                           WHERE c3.cost_yrmon       = c2.cost_yrmon
                                                             AND c3.full_mty_cd      = c2.full_mty_cd
                                                             AND c3.cntr_tpsz_cd     = c2.cntr_tpsz_cd
                                                             AND c3.cost_loc_grp_cd  = c2.cost_loc_grp_cd
                                                             AND c3.nod_cd           = c2.nod_cd
                                                             AND c3.coa_cost_src_cd  = c2.coa_cost_src_cd
                                                             AND c3.slan_cd          = c2.slan_cd
                                                             AND c3.cost_act_grp_cd  = c2.cost_act_grp_cd
                                                             AND c3.trd_cd           <> 'NNN'
                                                             AND c3.trd_cd           = (SELECT h.trd_cd from coa_com_para p, coa_rgst_bkg h
                                                                                         WHERE p.pctl_no = para_cost_list.pctl_no
                                                                                           AND h.bkg_no  = p.bkg_no)
                                                         ),'NNN') 
                            
                         --------- A/G별 단가 적용 START --------------
                         AND NVL(c2.cost_act_grp_cd, 'NNNN') = NVL((SELECT c3.cost_act_grp_cd from coa_nod_avg_stnd_cost c3
                                                                     WHERE c3.cost_yrmon       = c2.cost_yrmon
                                                                       AND c3.full_mty_cd      = c2.full_mty_cd
                                                                       AND c3.cntr_tpsz_cd     = c2.cntr_tpsz_cd
                                                                       AND c3.cost_loc_grp_cd  = c2.cost_loc_grp_cd
                                                                       AND c3.nod_cd           = c2.nod_cd
                                                                       AND c3.coa_cost_src_cd  = c2.coa_cost_src_cd
                                                                       AND c3.trd_cd           = c2.trd_cd
                                                                       AND c3.slan_cd          = c2.slan_cd                                                                       
                                                                       AND c3.cost_act_grp_cd  <> 'NNNN'
                                                                       AND c3.cost_act_grp_cd  = c1.cost_act_grp_cd
                                                                   ),'NNNN') 
                         ) d2
               ON (d1.pctl_no = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'A', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TES AVG-NOD ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt 
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;
--            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:NOD 단가 : ' || SQL%ROWCOUNT, in_appl_info);
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'),in_appl_info);
            
         --**************************************************************************************
         -- REV MT BKG일 경우에 Node Level에서 평균 단가 붙이고 난 후 REV MT 단가가 있으면      *
         -- REV MT 단가를 붙여준다.                                                             *
         --                                                                                     *
         -- CSR No.N200906170170                                                                *
         --**************************************************************************************
         IF (para_cost_list.bkg_cgo_tp_cd = 'R') 
         THEN
--            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_NOD_AVG_STND_COST) */c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_cd
                            ,c2.stnd_cost_usd_amt
                            ,c1.ctrt_rtn_flg
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,n1st_nod_cd nod_cd
                                    ,ctrt_rtn_flg
                                FROM coa_com_cost_para
                               WHERE pctl_no = para_cost_list.pctl_no--                                
                                 AND NVL(estm_uc_amt, 0) > 0 -- REV MT 단가는 기존 평균 단가가 0 이면 붙이면 안됨(원래 안붙는 단가이므로)                         
                                -- AND ctrt_rtn_flg = 'N' --REV MT 단가는 Contract 단가가 있더라도 단가가 있으면 무조건 붙임
                                 AND cost_src_sys_cd = 'TES') c1
                            ,coa_nod_avg_stnd_cost c2
                       WHERE c2.cost_yrmon = in_cost_yrmon
                         AND c2.full_mty_cd = 'R' --Code가 R로 들어옴
                         AND c2.cost_loc_grp_cd = 'N'   -- NOD
                         AND c1.cntr_tpsz_cd_2 = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                         AND c1.nod_cd = c2.nod_cd) d2
               ON (d1.pctl_no = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'A', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk =  'Revenue MT ' || '-> ' || TO_CHAR(d2.stnd_cost_usd_amt,'FM9,999,999.99') ||' ' || d2.locl_curr_cd 
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;
--                v_err_msg := v_err_msg + SQL%ROWCOUNT;
--                enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:REV MT 단가 : ' || SQL%ROWCOUNT, in_appl_info);
--                enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'),in_appl_info);
                      
            END IF;    
            
            --
            -- Location 단가 (CGFRTX 계정 단가를 Trade 별로 붙이기 위해서 coa_rgst_bkg에서 TRD 정보를 가져온다.
            --                Location level 만 단가 Logic 적용 되어있음 CSR No. N200903190080)   
            --               (CGFRTX 계정 단가를 Trade, A/G (NIBT, NOBT도 다르게 적용하기 위해 A/G 정보도 가져와야 함
            --                CSR No.CHM-201003904)               
--            v_start_time := SYSTIMESTAMP;
            
              MERGE INTO coa_com_cost_para d1
                   USING (SELECT /*+ index(c2 XPKCOA_NOD_AVG_STND_COST) */c1.pctl_no
                                ,c1.cost_act_grp_seq
                                ,c1.cost_src_sys_cd
                                ,c1.cntr_tpsz_cd
                                ,c1.coa_cost_src_cd
                                ,c1.nod_cd
                                ,c2.stnd_cost_usd_amt
                                ,c1.ctrt_rtn_flg                                
                                ,c1.cost_act_grp_cd
                                ,c2.locl_curr_cd
                            FROM (SELECT pctl_no
                                        ,cost_act_grp_seq
                                        ,cost_src_sys_cd
                                        ,cntr_tpsz_cd
                                        ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                        ,coa_cost_src_cd
                                        ,substr(n1st_nod_cd, 1, 5) nod_cd
                                        ,ctrt_rtn_flg                                        
                                        ,cost_act_grp_cd
                                    FROM coa_com_cost_para
                                   WHERE pctl_no = para_cost_list.pctl_no                                     
    --                                 AND COST_ASS_BSE_CD = DECODE(IN_PRC_NO, 1, 'A', 'C')   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                     AND NVL(estm_uc_amt, 0) = 0
    --                                 AND NVL(CTRT_RTN_FLG, 'N') =
    --                                                           DECODE(IN_PRC_NO
    --                                                                 ,1, NVL(CTRT_RTN_FLG, 'N')
    --                                                                 ,'N'
    --                                                                 )   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                     AND ctrt_rtn_flg = 'N'
                                     AND cost_src_sys_cd = 'TES'
                                     AND NVL(cost_asgn_calc_flg, 'N') <> 'Y'   -- 단가 붙인거 제외 : 2008.1.21 전성진
                                                                            ) c1
                                ,coa_nod_avg_stnd_cost c2
                           WHERE c2.cost_yrmon = in_cost_yrmon
                             AND c2.full_mty_cd = 'F'
                             AND c2.cost_loc_grp_cd = 'C'   -- Location
                             AND c1.cntr_tpsz_cd_2 = c2.cntr_tpsz_cd
                             AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                             AND c1.nod_cd = c2.nod_cd
                             --------- TRADE별 단가 적용 START ------------
                             AND NVL(c2.trd_cd, 'NNN') = NVL((SELECT c3.trd_cd from coa_nod_avg_stnd_cost c3
                                                               WHERE c3.cost_yrmon       = c2.cost_yrmon
                                                                 AND c3.full_mty_cd      = c2.full_mty_cd
                                                                 AND c3.cntr_tpsz_cd     = c2.cntr_tpsz_cd
                                                                 AND c3.cost_loc_grp_cd  = c2.cost_loc_grp_cd
                                                                 AND c3.nod_cd           = c2.nod_cd
                                                                 AND c3.coa_cost_src_cd  = c2.coa_cost_src_cd
                                                                 AND c3.slan_cd          = c2.slan_cd
                                                                 AND c3.cost_act_grp_cd  = c2.cost_act_grp_cd
                                                                 AND c3.trd_cd           <> 'NNN'
                                                                 AND c3.trd_cd           = (SELECT h.trd_cd from coa_com_para p, coa_rgst_bkg h
                                                                                             WHERE p.pctl_no = para_cost_list.pctl_no
                                                                                               AND h.bkg_no  = p.bkg_no)
                                                             ),'NNN') 
                            
                         --------- A/G별 단가 적용 START --------------
                             AND NVL(c2.cost_act_grp_cd, 'NNNN') = NVL((SELECT c3.cost_act_grp_cd from coa_nod_avg_stnd_cost c3
                                                                         WHERE c3.cost_yrmon       = c2.cost_yrmon
                                                                           AND c3.full_mty_cd      = c2.full_mty_cd
                                                                           AND c3.cntr_tpsz_cd     = c2.cntr_tpsz_cd
                                                                           AND c3.cost_loc_grp_cd  = c2.cost_loc_grp_cd
                                                                           AND c3.nod_cd           = c2.nod_cd
                                                                           AND c3.coa_cost_src_cd  = c2.coa_cost_src_cd
                                                                           AND c3.trd_cd           = c2.trd_cd
                                                                           AND c3.slan_cd          = c2.slan_cd                                                                       
                                                                           AND c3.cost_act_grp_cd  <> 'NNNN'
                                                                           AND c3.cost_act_grp_cd  = c1.cost_act_grp_cd
                                                                       ),'NNNN')
--                             AND DECODE(c1.coa_cost_src_cd, 'CGFRTX', c1.trd_cd, 'NNN') = c2.trd_cd
--                             AND DECODE(c1.coa_cost_src_cd, 'CGFRTX', c1.cost_act_grp_cd, 'NNNN') = c2.cost_act_grp_cd
                             ) d2
                   ON (d1.pctl_no = d2.pctl_no
                   AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
                   AND d1.cntr_tpsz_cd = d2.cntr_tpsz_cd
                   AND d1.coa_cost_src_cd = d2.coa_cost_src_cd)
                   WHEN MATCHED THEN
                      UPDATE
                         SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                            ,d1.cost_cate_cd = 'A', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                            ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TES AVG-LOC ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt
                            ,d1.cost_asgn_calc_flg = 'Y'
                      ;
--            v_err_msg := v_err_msg + SQL%ROWCOUNT;          
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:Location 단가 : ' || SQL%ROWCOUNT,in_appl_info);
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'),in_appl_info);
            --
            -- SCC 단가
--            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_NOD_AVG_STND_COST) */c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_cd
                            ,c2.stnd_cost_usd_amt
                            ,c1.ctrt_rtn_flg
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,coa_loc_fnc(n1st_nod_cd, 'SCC') nod_cd
                                    ,ctrt_rtn_flg
                                FROM coa_com_cost_para
                               WHERE pctl_no = para_cost_list.pctl_no
--                                 AND COST_ASS_BSE_CD = DECODE(IN_PRC_NO, 1, 'A', 'C')   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND NVL(estm_uc_amt, 0) = 0
--                                 AND NVL(CTRT_RTN_FLG, 'N') =
--                                                           DECODE(IN_PRC_NO
--                                                                 ,1, NVL(CTRT_RTN_FLG, 'N')
--                                                                 ,'N'
--                                                                 )   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND ctrt_rtn_flg = 'N'
                                 AND cost_src_sys_cd = 'TES'
                                 AND NVL(cost_asgn_calc_flg, 'N') <> 'Y'   -- 단가 붙인거 제외 : 2008.1.21 전성진
                                                                        ) c1
                            ,coa_nod_avg_stnd_cost c2
                       WHERE c2.cost_yrmon = in_cost_yrmon
                         AND c2.full_mty_cd = 'F'
                         AND c2.cost_loc_grp_cd = 'S'   -- SCC
                         AND c1.cntr_tpsz_cd_2 = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                         AND c1.nod_cd = c2.nod_cd) d2
               ON (d1.pctl_no = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'A', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TES AVG-SCC ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;
--            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:SCC 단가 : ' || SQL%ROWCOUNT, in_appl_info);
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'), in_appl_info);
            --
            -- ECC 단가
--            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_NOD_AVG_STND_COST) */c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_cd
                            ,c2.stnd_cost_usd_amt
                            ,c1.ctrt_rtn_flg
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,coa_loc_fnc(n1st_nod_cd, 'ECC') nod_cd
                                    ,ctrt_rtn_flg
                                FROM coa_com_cost_para
                               WHERE pctl_no = para_cost_list.pctl_no
--                                 AND COST_ASS_BSE_CD = DECODE(IN_PRC_NO, 1, 'A', 'C')   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND NVL(estm_uc_amt, 0) = 0
--                                 AND NVL(CTRT_RTN_FLG, 'N') =
--                                                           DECODE(IN_PRC_NO
--                                                                 ,1, NVL(CTRT_RTN_FLG, 'N')
--                                                                 ,'N'
--                                                                 )   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND ctrt_rtn_flg = 'N'
                                 AND cost_src_sys_cd = 'TES'
                                 AND NVL(cost_asgn_calc_flg, 'N') <> 'Y'   -- 단가 붙인거 제외 : 2008.1.21 전성진
                                                                        ) c1
                            ,coa_nod_avg_stnd_cost c2
                       WHERE c2.cost_yrmon = in_cost_yrmon
                         AND c2.full_mty_cd = 'F'
                         AND c2.cost_loc_grp_cd = 'E'   -- ECC
                         AND c1.cntr_tpsz_cd_2 = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                         AND c1.nod_cd = c2.nod_cd) d2
               ON (d1.pctl_no = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'A', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TES AVG-ECC ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;
--            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:ECC 단가 : ' || SQL%ROWCOUNT,in_appl_info);
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'),in_appl_info);
            --
            -- LCC 단가
--            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_NOD_AVG_STND_COST) */c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_cd
                            ,c2.stnd_cost_usd_amt
                            ,c1.ctrt_rtn_flg
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,coa_loc_fnc(n1st_nod_cd, 'LCC') nod_cd
                                    ,ctrt_rtn_flg
                                FROM coa_com_cost_para
                               WHERE pctl_no = para_cost_list.pctl_no
--                                 AND COST_ASS_BSE_CD = DECODE(IN_PRC_NO, 1, 'A', 'C')   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND NVL(estm_uc_amt, 0) = 0
--                                 AND NVL(CTRT_RTN_FLG, 'N') =
--                                                           DECODE(IN_PRC_NO
--                                                                 ,1, NVL(CTRT_RTN_FLG, 'N')
--                                                                 ,'N'
--                                                                 )   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND ctrt_rtn_flg = 'N'
                                 AND cost_src_sys_cd = 'TES'
                                 AND NVL(cost_asgn_calc_flg, 'N') <> 'Y'   -- 단가 붙인거 제외 : 2008.1.21 전성진
                                                                        ) c1
                            ,coa_nod_avg_stnd_cost c2
                       WHERE c2.cost_yrmon = in_cost_yrmon
                         AND c2.full_mty_cd = 'F'
                         AND c2.cost_loc_grp_cd = 'L'   -- LCC
                         AND c1.cntr_tpsz_cd_2 = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                         AND c1.nod_cd = c2.nod_cd) d2
               ON (d1.pctl_no = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'A', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TES AVG-LCC ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;
--            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:LCC 단가 : ' || SQL%ROWCOUNT,in_appl_info);
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'),in_appl_info);
                  
            -- RCC 단가
--            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_NOD_AVG_STND_COST) */c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_cd
                            ,c2.stnd_cost_usd_amt
                            ,c1.ctrt_rtn_flg
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,coa_loc_fnc(n1st_nod_cd, 'RCC') nod_cd
                                    ,ctrt_rtn_flg
                                FROM coa_com_cost_para
                               WHERE pctl_no = para_cost_list.pctl_no
--                                 AND COST_ASS_BSE_CD = DECODE(IN_PRC_NO, 1, 'A', 'C')   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND NVL(estm_uc_amt, 0) = 0
--                                 AND NVL(CTRT_RTN_FLG, 'N') =
--                                                           DECODE(IN_PRC_NO
--                                                                 ,1, NVL(CTRT_RTN_FLG, 'N')
--                                                                 ,'N'
--                                                                 )   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND ctrt_rtn_flg = 'N'
                                 AND cost_src_sys_cd = 'TES'
                                 AND NVL(cost_asgn_calc_flg, 'N') <> 'Y'   -- 단가 붙인거 제외 : 2008.1.21 전성진
                                                                        ) c1
                            ,coa_nod_avg_stnd_cost c2
                       WHERE c2.cost_yrmon = in_cost_yrmon
                         AND c2.full_mty_cd = 'F'
                         AND c2.cost_loc_grp_cd = 'R'   -- RCC
                         AND c1.cntr_tpsz_cd_2 = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                         AND c1.nod_cd = c2.nod_cd) d2
               ON (d1.pctl_no = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'A', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TES AVG-RCC ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;                  
--            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--           enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:RCC 단가 : ' || SQL%ROWCOUNT,in_appl_info);
--           enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES:Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'),in_appl_info);
         END LOOP;
      
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TES END.',in_appl_info);
      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      RETURN v_err_msg;
   END;

/************************************************************************************************************
 * PARA_TRS_AVG
 ***********************************************************************************************************/
   FUNCTION para_trs_avg(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2
   IS
      CURSOR para_cost_cursor
      IS
         SELECT   pctl_no
             FROM coa_com_para
            WHERE NVL(bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
              AND pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
         ORDER BY pctl_no;

      v_err_msg      VARCHAR2(4000);
      v_start_time   TIMESTAMP;
   BEGIN
      BEGIN
         FOR para_cost_list IN para_cost_cursor
         LOOP
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TRS:pctl_no : ' || para_cost_list.pctl_no, in_appl_info);
            -- 링크
            -- NOD 단가
            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_LNK_AVG_STND_COST) */
                             c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_fm_cd
                            ,c1.nod_to_cd
                            ,c2.stnd_cost_usd_amt
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,CASE
                                       WHEN(substr(cost_act_grp_cd, 1, 2) = 'OD')   -- O/B Door
                                          THEN  n2nd_nod_cd
                                       ELSE n1st_nod_cd
                                     END nod_fm_cd
                                    ,CASE
                                       WHEN(substr(cost_act_grp_cd, 1, 2) = 'ID')   -- I/B Door
                                          THEN CASE
                                                 WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                       + decode(n2nd_nod_cd, NULL, 0, 1)
                                                       + decode(n3rd_nod_cd, NULL, 0, 1)
                                                       + decode(n4th_nod_cd, NULL, 0, 1)
                                                      ) = 4
                                                     )
                                                    THEN n3rd_nod_cd
                                                 WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                       + decode(n2nd_nod_cd, NULL, 0, 1)
                                                       + decode(n3rd_nod_cd, NULL, 0, 1)
                                                       + decode(n4th_nod_cd, NULL, 0, 1)
                                                      ) = 3
                                                     )
                                                    THEN n2nd_nod_cd
                                                 ELSE n2nd_nod_cd
                                              END
                                       ELSE COALESCE(n4th_nod_cd, n3rd_nod_cd, n2nd_nod_cd)
                                     END nod_to_cd                                    
                                FROM coa_com_cost_para
                               WHERE pctl_no = para_cost_list.pctl_no
--                                 AND COST_ASS_BSE_CD = DECODE(IN_PRC_NO, 1, 'A', 'C')   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND NVL(estm_uc_amt, 0) = 0
--                                 AND NVL(CTRT_RTN_FLG, 'N') =
--                                                           DECODE(IN_PRC_NO
--                                                                 ,1, NVL(CTRT_RTN_FLG, 'N')
--                                                                 ,'N'
--                                                                 )   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND ctrt_rtn_flg = 'N'
                                 AND cost_src_sys_cd = 'TRS') c1
                            ,coa_lnk_avg_stnd_cost c2
                       WHERE c2.cost_yrmon       = in_cost_yrmon
                         AND c2.full_mty_cd      = 'F'
                         AND c2.co_cd            = 'H'
                         AND c2.cost_loc_grp_cd  = 'N'   -- NOD
                         AND c1.cntr_tpsz_cd_2   = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd  = c2.coa_cost_src_cd
                         AND c1.nod_fm_cd        = c2.lnk_fm_nod_cd
                         AND c1.nod_to_cd        = c2.lnk_to_nod_cd) d2
               ON (d1.pctl_no          = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd     = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd  = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'C', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TRS AVG-NOD ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;
            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'NOD 단가 : ' || SQL%ROWCOUNT, in_appl_info);
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'), in_appl_info);

            -- Location 단가
            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_LNK_AVG_STND_COST) */
                             c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_fm_cd
                            ,c1.nod_to_cd
                            ,c2.stnd_cost_usd_amt
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,CASE
                                       WHEN(substr(cost_act_grp_cd, 1, 2) = 'OD')   -- O/B Door
                                          THEN  n2nd_nod_cd
                                       ELSE n1st_nod_cd
                                     END nod_fm_cd
                                    ,CASE
                                       WHEN(substr(cost_act_grp_cd, 1, 2) = 'ID')   -- I/B Door
                                          THEN CASE
                                                 WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                       + decode(n2nd_nod_cd, NULL, 0, 1)
                                                       + decode(n3rd_nod_cd, NULL, 0, 1)
                                                       + decode(n4th_nod_cd, NULL, 0, 1)
                                                      ) = 4
                                                     )
                                                    THEN n3rd_nod_cd
                                                 WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                       + decode(n2nd_nod_cd, NULL, 0, 1)
                                                       + decode(n3rd_nod_cd, NULL, 0, 1)
                                                       + decode(n4th_nod_cd, NULL, 0, 1)
                                                      ) = 3
                                                     )
                                                    THEN n2nd_nod_cd
                                                 ELSE n2nd_nod_cd
                                              END
                                       ELSE COALESCE(n4th_nod_cd, n3rd_nod_cd, n2nd_nod_cd)
                                     END nod_to_cd
                                FROM coa_com_cost_para
                               WHERE pctl_no             = para_cost_list.pctl_no
                                 AND NVL(estm_uc_amt, 0) = 0
                                 AND ctrt_rtn_flg        = 'N'
                                 AND cost_src_sys_cd     = 'TRS'
                                 AND NVL(cost_asgn_calc_flg, 'N') <> 'Y') c1
                            ,coa_lnk_avg_stnd_cost c2
                       WHERE c2.cost_yrmon      = in_cost_yrmon
                         AND c2.full_mty_cd     = 'F'
                         AND c2.co_cd           = 'H'
                         AND c2.cost_loc_grp_cd = 'C'   -- Location
                         AND c1.cntr_tpsz_cd_2  = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                         AND SUBSTR(c1.nod_fm_cd,1,5) = c2.lnk_fm_nod_cd
                         AND SUBSTR(c1.nod_to_cd,1,5) = c2.lnk_to_nod_cd) d2
               ON (d1.pctl_no          = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd     = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd  = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'C', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TRS AVG-LOC ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;
            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Location 단가 : ' || SQL%ROWCOUNT, in_appl_info);
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'), in_appl_info);
            
            -- SCC 단가
            -- 9월달 부터 SCC 단가 대신 Location단가를 붙임
            -- 하지만 이전 BKG가 돌면 SCC 단가가 붙어야 할것 같아서 로직은 그대로 보존
            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_LNK_AVG_STND_COST) */
                             c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_fm_cd
                            ,c1.nod_to_cd
                            ,c2.stnd_cost_usd_amt
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,coa_loc_fnc(CASE
                                                   WHEN(substr(cost_act_grp_cd, 1, 2) = 'OD')   -- O/B Door
                                                      THEN  n2nd_nod_cd
                                                   ELSE n1st_nod_cd
                                                 END
                                                ,'SCC'
                                                ) nod_fm_cd
                                    ,coa_loc_fnc(CASE
                                                   WHEN(substr(cost_act_grp_cd, 1, 2) = 'ID')   -- I/B Door
                                                      THEN CASE
                                                             WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                                   + decode(n2nd_nod_cd, NULL, 0, 1)
                                                                   + decode(n3rd_nod_cd, NULL, 0, 1)
                                                                   + decode(n4th_nod_cd, NULL, 0, 1)
                                                                  ) = 4
                                                                 )
                                                                THEN n3rd_nod_cd
                                                             WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                                   + decode(n2nd_nod_cd, NULL, 0, 1)
                                                                   + decode(n3rd_nod_cd, NULL, 0, 1)
                                                                   + decode(n4th_nod_cd, NULL, 0, 1)
                                                                  ) = 3
                                                                 )
                                                                THEN n2nd_nod_cd
                                                             ELSE n2nd_nod_cd
                                                          END
                                                   ELSE COALESCE(n4th_nod_cd, n3rd_nod_cd, n2nd_nod_cd)
                                                 END
                                                ,'SCC'
                                                ) nod_to_cd
                                FROM coa_com_cost_para
                               WHERE pctl_no = para_cost_list.pctl_no
--                                 AND COST_ASS_BSE_CD = DECODE(IN_PRC_NO, 1, 'A', 'C')   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND NVL(estm_uc_amt, 0) = 0
--                                 AND NVL(CTRT_RTN_FLG, 'N') =
--                                                           DECODE(IN_PRC_NO
--                                                                 ,1, NVL(CTRT_RTN_FLG, 'N')
--                                                                 ,'N'
--                                                                 )   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND ctrt_rtn_flg = 'N'
                                 AND cost_src_sys_cd = 'TRS'
                                 AND NVL(cost_asgn_calc_flg, 'N') <> 'Y') c1
                            ,coa_lnk_avg_stnd_cost c2
                       WHERE c2.cost_yrmon      = in_cost_yrmon
                         AND c2.full_mty_cd     = 'F'
                         AND c2.co_cd           = 'H'
                         AND c2.cost_loc_grp_cd = 'S'   -- SCC
                         AND c1.cntr_tpsz_cd_2  = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                         AND c1.nod_fm_cd       = c2.lnk_fm_nod_cd
                         AND c1.nod_to_cd       = c2.lnk_to_nod_cd) d2
               ON (d1.pctl_no          = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd     = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd  = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'C', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TRS AVG-SCC ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;
            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'SCC 단가 : ' || SQL%ROWCOUNT, in_appl_info);
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'), in_appl_info);
            --
            -- ECC 단가
            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_LNK_AVG_STND_COST) */
                             c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_fm_cd
                            ,c1.nod_to_cd
                            ,c2.stnd_cost_usd_amt
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,coa_loc_fnc(CASE
                                                   WHEN(substr(cost_act_grp_cd, 1, 2) = 'OD')   -- O/B Door
                                                      THEN  n2nd_nod_cd
                                                   ELSE n1st_nod_cd
                                                 END
                                                ,'ECC'
                                                ) nod_fm_cd
                                    ,coa_loc_fnc(CASE
                                                   WHEN(substr(cost_act_grp_cd, 1, 2) = 'ID')   -- I/B Door
                                                      THEN CASE
                                                             WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                                   + decode(n2nd_nod_cd, NULL, 0, 1)
                                                                   + decode(n3rd_nod_cd, NULL, 0, 1)
                                                                   + decode(n4th_nod_cd, NULL, 0, 1)
                                                                  ) = 4
                                                                 )
                                                                THEN n3rd_nod_cd
                                                             WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                                   + decode(n2nd_nod_cd, NULL, 0, 1)
                                                                   + decode(n3rd_nod_cd, NULL, 0, 1)
                                                                   + decode(n4th_nod_cd, NULL, 0, 1)
                                                                  ) = 3
                                                                 )
                                                                THEN n2nd_nod_cd
                                                             ELSE n2nd_nod_cd
                                                          END
                                                   ELSE COALESCE(n4th_nod_cd, n3rd_nod_cd, n2nd_nod_cd)
                                                 END
                                                ,'ECC'
                                                ) nod_to_cd
                                FROM coa_com_cost_para
                               WHERE pctl_no = para_cost_list.pctl_no
--                                 AND COST_ASS_BSE_CD = DECODE(IN_PRC_NO, 1, 'A', 'C')   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND NVL(estm_uc_amt, 0) = 0
--                                 AND NVL(CTRT_RTN_FLG, 'N') =
--                                                           DECODE(IN_PRC_NO
--                                                                 ,1, NVL(CTRT_RTN_FLG, 'N')
--                                                                 ,'N'
--                                                                 )   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND ctrt_rtn_flg = 'N'
                                 AND cost_src_sys_cd = 'TRS'
                                 AND NVL(cost_asgn_calc_flg, 'N') <> 'Y') c1
                            ,coa_lnk_avg_stnd_cost c2
                       WHERE c2.cost_yrmon = in_cost_yrmon
                         AND c2.full_mty_cd = 'F'
                         AND c2.co_cd = 'H'
                         AND c2.cost_loc_grp_cd = 'E'   -- ECC
                         AND c1.cntr_tpsz_cd_2 = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                         AND c1.nod_fm_cd = c2.lnk_fm_nod_cd
                         AND c1.nod_to_cd = c2.lnk_to_nod_cd) d2
               ON (d1.pctl_no = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'C', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TRS AVG-ECC ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;
            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'ECC 단가 : ' || SQL%ROWCOUNT, in_appl_info);
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'), in_appl_info);
            --
            -- LCC 단가
            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_LNK_AVG_STND_COST) */
                             c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_fm_cd
                            ,c1.nod_to_cd
                            ,c2.stnd_cost_usd_amt
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,coa_loc_fnc(CASE
                                                   WHEN(substr(cost_act_grp_cd, 1, 2) = 'OD')   -- O/B Door
                                                      THEN  n2nd_nod_cd
                                                   ELSE n1st_nod_cd
                                                 END
                                                ,'LCC'
                                                ) nod_fm_cd
                                    ,coa_loc_fnc(CASE
                                                   WHEN(substr(cost_act_grp_cd, 1, 2) = 'ID')   -- I/B Door
                                                      THEN CASE
                                                             WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                                   + decode(n2nd_nod_cd, NULL, 0, 1)
                                                                   + decode(n3rd_nod_cd, NULL, 0, 1)
                                                                   + decode(n4th_nod_cd, NULL, 0, 1)
                                                                  ) = 4
                                                                 )
                                                                THEN n3rd_nod_cd
                                                             WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                                   + decode(n2nd_nod_cd, NULL, 0, 1)
                                                                   + decode(n3rd_nod_cd, NULL, 0, 1)
                                                                   + decode(n4th_nod_cd, NULL, 0, 1)
                                                                  ) = 3
                                                                 )
                                                                THEN n2nd_nod_cd
                                                             ELSE n2nd_nod_cd
                                                          END
                                                   ELSE COALESCE(n4th_nod_cd, n3rd_nod_cd, n2nd_nod_cd)
                                                 END
                                                ,'LCC'
                                                ) nod_to_cd
                                FROM coa_com_cost_para
                               WHERE pctl_no = para_cost_list.pctl_no
--                                 AND COST_ASS_BSE_CD = DECODE(IN_PRC_NO, 1, 'A', 'C')   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND NVL(estm_uc_amt, 0) = 0
--                                 AND NVL(CTRT_RTN_FLG, 'N') =
--                                                           DECODE(IN_PRC_NO
--                                                                 ,1, NVL(CTRT_RTN_FLG, 'N')
--                                                                 ,'N'
--                                                                 )   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND ctrt_rtn_flg = 'N'
                                 AND cost_src_sys_cd = 'TRS'
                                 AND NVL(cost_asgn_calc_flg, 'N') <> 'Y') c1
                            ,coa_lnk_avg_stnd_cost c2
                       WHERE c2.cost_yrmon = in_cost_yrmon
                         AND c2.full_mty_cd = 'F'
                         AND c2.co_cd = 'H'
                         AND c2.cost_loc_grp_cd = 'L'   -- LCC
                         AND c1.cntr_tpsz_cd_2 = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                         AND c1.nod_fm_cd = c2.lnk_fm_nod_cd
                         AND c1.nod_to_cd = c2.lnk_to_nod_cd) d2
               ON (d1.pctl_no = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'C', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TRS AVG-LCC ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;
            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'LCC 단가 : ' || SQL%ROWCOUNT, in_appl_info);
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'), in_appl_info);
   
            -- RCC 단가
            v_start_time := SYSTIMESTAMP;
            MERGE INTO coa_com_cost_para d1
               USING (SELECT /*+ index(c2 XPKCOA_LNK_AVG_STND_COST) */
                             c1.pctl_no
                            ,c1.cost_act_grp_seq
                            ,c1.cost_src_sys_cd
                            ,c1.cntr_tpsz_cd
                            ,c1.coa_cost_src_cd
                            ,c1.nod_fm_cd
                            ,c1.nod_to_cd
                            ,c2.stnd_cost_usd_amt
                            ,c2.locl_curr_cd
                        FROM (SELECT pctl_no
                                    ,cost_act_grp_seq
                                    ,cost_src_sys_cd
                                    ,cntr_tpsz_cd
                                    ,coa_ut_tpsz_fnc(cost_ut_amt_cd, cntr_tpsz_cd) cntr_tpsz_cd_2
                                    ,coa_cost_src_cd
                                    ,coa_loc_fnc(CASE
                                                   WHEN(substr(cost_act_grp_cd, 1, 2) = 'OD')   -- O/B Door
                                                      THEN  n2nd_nod_cd
                                                   ELSE n1st_nod_cd
                                                 END
                                                ,'RCC'
                                                ) nod_fm_cd
                                    ,coa_loc_fnc(CASE
                                                   WHEN(substr(cost_act_grp_cd, 1, 2) = 'ID')   -- I/B Door
                                                      THEN CASE
                                                             WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                                   + decode(n2nd_nod_cd, NULL, 0, 1)
                                                                   + decode(n3rd_nod_cd, NULL, 0, 1)
                                                                   + decode(n4th_nod_cd, NULL, 0, 1)
                                                                  ) = 4
                                                                 )
                                                                THEN n3rd_nod_cd
                                                             WHEN((  decode(n1st_nod_cd, NULL, 0, 1)
                                                                   + decode(n2nd_nod_cd, NULL, 0, 1)
                                                                   + decode(n3rd_nod_cd, NULL, 0, 1)
                                                                   + decode(n4th_nod_cd, NULL, 0, 1)
                                                                  ) = 3
                                                                 )
                                                                THEN n2nd_nod_cd
                                                             ELSE n2nd_nod_cd
                                                          END
                                                   ELSE COALESCE(n4th_nod_cd, n3rd_nod_cd, n2nd_nod_cd)
                                                 END
                                                ,'RCC'
                                                ) nod_to_cd
                                FROM coa_com_cost_para
                               WHERE pctl_no = para_cost_list.pctl_no
--                                 AND COST_ASS_BSE_CD = DECODE(IN_PRC_NO, 1, 'A', 'C')   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND NVL(estm_uc_amt, 0) = 0
--                                 AND NVL(CTRT_RTN_FLG, 'N') =
--                                                           DECODE(IN_PRC_NO
--                                                                 ,1, NVL(CTRT_RTN_FLG, 'N')
--                                                                 ,'N'
--                                                                 )   -- 두번째 처리시 단가 안붙은거 처리시 조건
                                 AND ctrt_rtn_flg = 'N'
                                 AND cost_src_sys_cd = 'TRS'
                                 AND NVL(cost_asgn_calc_flg, 'N') <> 'Y') c1
                            ,coa_lnk_avg_stnd_cost c2
                       WHERE c2.cost_yrmon = in_cost_yrmon
                         AND c2.full_mty_cd = 'F'
                         AND c2.co_cd = 'H'
                         AND c2.cost_loc_grp_cd = 'R'   -- RCC
                         AND c1.cntr_tpsz_cd_2 = c2.cntr_tpsz_cd
                         AND c1.coa_cost_src_cd = c2.coa_cost_src_cd
                         AND c1.nod_fm_cd = c2.lnk_fm_nod_cd
                         AND c1.nod_to_cd = c2.lnk_to_nod_cd) d2
               ON (d1.pctl_no = d2.pctl_no
               AND d1.cost_act_grp_seq = d2.cost_act_grp_seq
               AND d1.cntr_tpsz_cd = d2.cntr_tpsz_cd
               AND d1.coa_cost_src_cd = d2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET d1.estm_uc_amt = d2.stnd_cost_usd_amt, d1.respb_uc_amt = d2.stnd_cost_usd_amt, d1.locl_curr_cd = d2.locl_curr_cd
                        ,d1.cost_cate_cd = 'C', d1.cre_usr_id = 'SYS_COA_PKG', d1.cre_dt = SYSDATE
                        ,d1.cost_calc_rmk = d1.cost_calc_rmk || '>TRS AVG-RCC ' || d1.estm_uc_amt || '->' || d2.stnd_cost_usd_amt
                        ,d1.cost_asgn_calc_flg = 'Y'
                  ;       
            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'RCC 단가 : ' || SQL%ROWCOUNT, in_appl_info);
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Required ' || TO_CHAR(SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'), in_appl_info);
                
      END LOOP;
      --enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'TRS END.',in_appl_info);
      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      RETURN v_err_msg;
   END;

/************************************************************************************************************
 * upd_tes_mty_ecc_ut_cost_uc_amt
 * -- MT Stevedorage, MTY CNTR Transportation
 ***********************************************************************************************************/
   FUNCTION pa_tes_mty(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2
   IS
      CURSOR para_cost_cursor
      IS
         SELECT a2.pctl_no
               ,a2.cost_act_grp_seq
               ,a2.cost_src_sys_cd
               ,a2.cntr_tpsz_cd
--               ,coa_ut_tpsz_fnc(a2.cost_ut_amt_cd, a2.cntr_tpsz_cd) cntr_tpsz_cd_2
         ,      coa_ut_tpsz_fnc('TPS', a2.cntr_tpsz_cd) cntr_tpsz_cd_2   --MT 단가를 20,40 으로 만들기 때문에 SZ 로 되어있음.
                                                                         --MT 회송비 단가는 TPS 로 붙어야 하기 때문에 강제로 setting
               ,a2.coa_cost_src_cd
               ,a1.por_cd
               ,a1.del_cd
               ,a2.n1st_nod_cd
               ,a1.mty_pkup_yd_cd
               ,a1.mty_rtn_yd_cd
               ,a3.trd_cd
           FROM coa_com_para a1, coa_com_cost_para a2, coa_rgst_bkg a3
          WHERE a1.pctl_no = a2.pctl_no
            AND NVL(a1.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
            AND a1.bkg_no = a3.bkg_no
            AND a1.pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
            AND a2.cost_ass_bse_cd = 'A'
            AND a2.cost_src_sys_cd = 'TES'
            AND a2.stnd_cost_cd = '51102000';

      ------------------------------[ 변수선언부             ]-----------------------
      v_err_msg           NUMBER                               := 0;
      v_ra_acct_cd_cnt    NUMBER;
      v_estm_uc_amt1      coa_com_cost_para.estm_uc_amt%TYPE;
      v_estm_uc_amt2      coa_com_cost_para.estm_uc_amt%TYPE;
      v_ra_acct_cd        coa_com_cost_para.ra_acct_cd%TYPE;
      v_cost_calc_rmk     VARCHAR(1000);   -- 20080601 ari precm rmk처리용
      v_estm_rmk1         VARCHAR(1000);   -- 20080601 ari precm rmk처리용
      v_estm_rmk2         VARCHAR(1000);   -- 20080601 ari precm rmk처리용
   BEGIN
      BEGIN
         FOR para_cost_list IN para_cost_cursor
         LOOP
            SELECT COUNT(*) ra_acct_cd_cnt
              INTO v_ra_acct_cd_cnt
              FROM coa_com_cost_para
             WHERE pctl_no = para_cost_list.pctl_no
               AND cost_src_sys_cd = 'TES'
               AND ra_acct_cd = '51102000';

            v_estm_uc_amt1 := NULL;
            v_estm_uc_amt2 := NULL;
            
            v_ra_acct_cd := NULL;

            IF (v_ra_acct_cd_cnt = 0)   -- 51102000 코드로 한번만 들어간다.
            THEN
               -- 20080601 ari precm rmk 처리를 위해 수정함
               v_cost_calc_rmk :=
                  get_mty_ecc_ut_cost_uc_amt(in_cost_yrmon
                                            ,para_cost_list.cntr_tpsz_cd_2
                                            ,para_cost_list.mty_pkup_yd_cd
                                            ,para_cost_list.mty_rtn_yd_cd
                                            ,para_cost_list.trd_cd
                                            ,in_appl_info
                                            );
               v_ra_acct_cd := '51102000';
               v_estm_uc_amt1 := substr(v_cost_calc_rmk, 11, INSTR(v_cost_calc_rmk, 'rmk(A)=')-11);
               v_estm_rmk1 := substr(v_cost_calc_rmk, INSTR(v_cost_calc_rmk, 'rmk(A)=')+7, INSTR(v_cost_calc_rmk, 'EPP-B(UC)=')-INSTR(v_cost_calc_rmk, 'rmk(A)=')-7);
               v_estm_uc_amt2 := substr(v_cost_calc_rmk, INSTR(v_cost_calc_rmk, 'EPP-B(UC)=')+10, INSTR(v_cost_calc_rmk, 'rmk(B)=')-INSTR(v_cost_calc_rmk, 'EPP-B(UC)=')-10 );
               v_estm_rmk2 := substr(v_cost_calc_rmk, INSTR(v_cost_calc_rmk, 'rmk(B)=')+7);
--               v_estm_uc_amt := SUBSTR(v_cost_calc_rmk, 0, INSTR(v_cost_calc_rmk, ' rmk='));
--               v_cost_calc_rmk := SUBSTR(v_cost_calc_rmk, INSTR(v_cost_calc_rmk, ' rmk=') + 5);
            END IF;

            UPDATE coa_com_cost_para
               SET estm_uc_amt = v_estm_uc_amt1
                  ,cost_calc_rmk = v_estm_rmk1
                  ,estm_usd_ut_amt2 = v_estm_uc_amt2
                  ,cost_calc_rmk2 = v_estm_rmk2
                  ,ra_acct_cd = v_ra_acct_cd
                  ,locl_curr_cd = 'USD'
                  ,cost_cate_cd = 'B'
                  ,cost_ass_bse_cd = 'A'  
                  ,cre_usr_id = 'SYS_COA_PKG'
                  ,cre_dt = SYSDATE


                  --                  ,cost_calc_rmk = 'MTY' || ' RA_CNT ' || v_ra_acct_cd_cnt
           
             WHERE pctl_no = para_cost_list.pctl_no
               AND cost_act_grp_seq = para_cost_list.cost_act_grp_seq
               AND cntr_tpsz_cd = para_cost_list.cntr_tpsz_cd
               AND coa_cost_src_cd = para_cost_list.coa_cost_src_cd;
--            v_err_msg := v_err_msg + SQL%ROWCOUNT;
         END LOOP;
      --enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Result : ' || V_ERR_MSG );
      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      RETURN v_err_msg;
   END;

/************************************************************************************************************
 * upd_trs_mty_ecc_ut_cost_uc_amt
 * -- MT Stevedorage, MTY CNTR Transportation
 ***********************************************************************************************************/
   FUNCTION pa_trs_mty(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2
   IS
      CURSOR para_cost_cursor
      IS
         SELECT a1.pctl_no
               ,a2.cost_act_grp_seq
               ,a2.cntr_tpsz_cd
--               ,coa_ut_tpsz_fnc(a2.cost_ut_amt_cd, a2.cntr_tpsz_cd) cntr_tpsz_cd_2
         ,      coa_ut_tpsz_fnc('TPS', a2.cntr_tpsz_cd) cntr_tpsz_cd_2   --MT 단가를 20,40 으로 만들기 때문에 SZ 로 되어있음.
                                                                         --MT 회송비 단가는 TPS 로 붙어야 하기 때문에 강제로 setting
               ,a2.cost_act_grp_cd
               ,a2.coa_cost_src_cd
               ,a1.por_cd
               ,a1.del_cd
           FROM coa_com_para a1, coa_com_cost_para a2
          WHERE a1.pctl_no = a2.pctl_no
            AND NVL(a1.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
            AND a1.pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
            AND a2.cost_ass_bse_cd = 'A'
            AND a2.cost_src_sys_cd = 'TRS'
            AND a2.stnd_cost_cd = '51302000';

      ------------------------------[ 변수선언부             ]-----------------------
      v_err_msg          NUMBER                               := 0;
      v_ra_acct_cd_cnt   NUMBER;
      v_estm_uc_amt      coa_com_cost_para.estm_uc_amt%TYPE;
      v_ra_acct_cd       coa_com_cost_para.ra_acct_cd%TYPE;
      v_cost_calc_rmk    VARCHAR(1000);   -- 20080601 ari precm rmk처리용
   BEGIN
--      BEGIN
--         FOR para_cost_list IN para_cost_cursor
--         LOOP
--            SELECT COUNT(*) v_ra_acct_cd_cnt
--              INTO v_ra_acct_cd_cnt
--              FROM coa_com_cost_para
--             WHERE pctl_no = para_cost_list.pctl_no
--               AND cost_src_sys_cd = 'TRS'
--               AND ra_acct_cd = '51302000';
--
--            v_estm_uc_amt := NULL;
--            v_ra_acct_cd := NULL;
--
--            IF (v_ra_acct_cd_cnt = 0)
--            THEN   -- 51302000 코드로 한번만 들어간다.
--               -- 20080601 ari precm rmk 처리를 위해 수정함
--               v_cost_calc_rmk :=
--                  get_mty_ecc_ut_cost_uc_amt(in_cost_yrmon
--                                            ,para_cost_list.cntr_tpsz_cd_2
--                                            ,para_cost_list.por_cd
--                                            ,para_cost_list.del_cd
--                                            ,'51302000'
--                                            ,in_appl_info
--                                            );
--               v_estm_uc_amt := SUBSTR(v_cost_calc_rmk, 0, INSTR(v_cost_calc_rmk, ' rmk='));
--               v_cost_calc_rmk := SUBSTR(v_cost_calc_rmk, INSTR(v_cost_calc_rmk, ' rmk=') + 5);
--               v_ra_acct_cd := '51302000';
--            END IF;
--
--            UPDATE coa_com_cost_para
--               SET estm_uc_amt = v_estm_uc_amt
--                  ,ra_acct_cd = v_ra_acct_cd
--                  ,locl_curr_cd = 'USD'
--                  ,cost_cate_cd = 'G'
--                  ,cost_ass_bse_cd = 'A'  
--                  ,cre_usr_id = 'SYS_COA_PKG'
--                  ,cre_dt = SYSDATE
----                  ,cost_calc_rmk = 'MTY'
--            ,      cost_calc_rmk = 'TES MTY' || ' ' || v_cost_calc_rmk   
--             WHERE pctl_no = para_cost_list.pctl_no
--               AND cost_act_grp_seq = para_cost_list.cost_act_grp_seq
--               AND cntr_tpsz_cd = para_cost_list.cntr_tpsz_cd   -- MTY 는 순수타입 적용
--               AND coa_cost_src_cd = para_cost_list.coa_cost_src_cd;
----            v_err_msg := v_err_msg + SQL%ROWCOUNT;
--         END LOOP;
--      --enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Result : ' || V_ERR_MSG );
--      EXCEPTION
--         WHEN OTHERS
--         THEN
--            RAISE;
--      END;

      RETURN v_err_msg;
   END;

/************************************************************************************************************
 * GET_MTY_ECC_UT_COST_UC_AMT
 ***********************************************************************************************************/
FUNCTION get_mty_ecc_ut_cost_uc_amt(
      in_cost_yrmon      IN   VARCHAR
     ,in_cntr_tpsz_cd    IN   VARCHAR   -- 순수타입 적용
     ,in_mty_fm_nod_cd   IN   VARCHAR
     ,in_mty_to_nod_cd   IN   VARCHAR
     ,in_trd_cd          IN   VARCHAR
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR   -- RETURN TYPE
   IS
-- ===== DECLARE ==========================================
      v_err_msg                  VARCHAR2(1000);
      v_rtn_rmk                  VARCHAR2(1000);
      v_in_epp1_rmk              VARCHAR2(1000);
      v_in_epp2_rmk              VARCHAR2(1000);
      v_out_epp1_rmk             VARCHAR2(1000);
      v_out_epp2_rmk             VARCHAR2(1000);

      v_ib_mty_amt1              coa_mty_repo_ut_cost.ib_mty_amt1%TYPE;
      v_ib_mty_amt2              coa_mty_repo_ut_cost.ib_mty_amt2%TYPE;
      v_ob_mty_amt1              coa_mty_repo_ut_cost.ob_mty_amt1%TYPE;
      v_ob_mty_amt2              coa_mty_repo_ut_cost.ob_mty_amt2%TYPE;
-- ===== BEGIN, EXCEPTION  ======================================
   BEGIN
      BEGIN
-- Inbound {{ --------------------------------------------------------------------------------------
         -- ECC
         BEGIN
            SELECT ib_mty_amt1
                  ,ib_mty_amt2
              INTO v_ib_mty_amt1
                  ,v_ib_mty_amt2
              FROM coa_mty_repo_ut_cost
             WHERE cost_loc_grp_cd = 'E'
               AND trd_cd = in_trd_cd
               AND in_cost_yrmon between eff_fm_yrmon and NVL(eff_to_yrmon, '999912')
               AND cntr_tpsz_cd = in_cntr_tpsz_cd
               AND scc_cd = coa_loc_fnc(in_mty_fm_nod_cd, 'ECC');

            --ECC 단가 적용
            v_in_epp1_rmk := coa_loc_fnc(in_mty_fm_nod_cd, 'ECC') || ' IB EPP-A (ECC)=';
            v_in_epp2_rmk := coa_loc_fnc(in_mty_fm_nod_cd, 'ECC') || ' IB EPP-B (ECC)=';
         EXCEPTION
            WHEN OTHERS
            THEN
               v_err_msg := 'ECC INBOUND 데이터가 없습니다.';
               --enis_log_prc(SYSDATE, 'get_mty_ecc_ut_cost_uc_amt', v_err_msg);
               v_ib_mty_amt1 := null;
               v_ib_mty_amt2 := null;
         END;

         -- LCC
         IF (   v_ib_mty_amt1 IS NULL
             AND v_ib_mty_amt2 IS NULL)
         THEN
            BEGIN
               SELECT ib_mty_amt1
                  ,ib_mty_amt2
              INTO v_ib_mty_amt1
                  ,v_ib_mty_amt2
              FROM coa_mty_repo_ut_cost
             WHERE cost_loc_grp_cd = 'L'
               AND trd_cd = in_trd_cd
               AND in_cost_yrmon between eff_fm_yrmon and NVL(eff_to_yrmon, '999912')
               AND cntr_tpsz_cd = in_cntr_tpsz_cd
               AND scc_cd = coa_loc_fnc(in_mty_fm_nod_cd, 'LCC');

            --ECC 단가 적용
            v_in_epp1_rmk := coa_loc_fnc(in_mty_fm_nod_cd, 'ECC') || ' IB EPP-A (LCC)=';
            v_in_epp2_rmk := coa_loc_fnc(in_mty_fm_nod_cd, 'ECC') || ' IB EPP-B (LCC)=';
         EXCEPTION
            WHEN OTHERS
            THEN
               v_err_msg := 'LCC INBOUND 데이터가 없습니다.';
               --enis_log_prc(SYSDATE, 'get_mty_ecc_ut_cost_uc_amt', v_err_msg);
               v_ib_mty_amt1 := null;
               v_ib_mty_amt2 := null;
            END;
         END IF;

          -- RCC
         IF (   v_ib_mty_amt1 IS NULL
             AND v_ib_mty_amt2 IS NULL)
         THEN
            BEGIN
               SELECT ib_mty_amt1
                  ,ib_mty_amt2
              INTO v_ib_mty_amt1
                  ,v_ib_mty_amt2
              FROM coa_mty_repo_ut_cost
             WHERE cost_loc_grp_cd = 'R'
               AND trd_cd = in_trd_cd
               AND in_cost_yrmon between eff_fm_yrmon and NVL(eff_to_yrmon, '999912')
               AND cntr_tpsz_cd = in_cntr_tpsz_cd
               AND scc_cd = coa_loc_fnc(in_mty_fm_nod_cd, 'RCC');

            --ECC 단가 적용
            v_in_epp1_rmk := coa_loc_fnc(in_mty_fm_nod_cd, 'ECC') || ' IB EPP-A (RCC)=';
            v_in_epp2_rmk := coa_loc_fnc(in_mty_fm_nod_cd, 'ECC') || ' IB EPP-B (RCC)=';
         EXCEPTION
            WHEN OTHERS
            THEN
               v_err_msg := 'RCC INBOUND 데이터가 없습니다.';
               --enis_log_prc(SYSDATE, 'get_mty_ecc_ut_cost_uc_amt', v_err_msg);
               v_ib_mty_amt1 := null;
               v_ib_mty_amt2 := null;
            END;
         END IF;

-- ORIGIN }} --------------------------------------------------------------------------------------

         --
-- Outbound {{ ----------------------------------------------------------------------------------------
         -- ECC
         BEGIN
            SELECT ob_mty_amt1
                  ,ob_mty_amt2
              INTO v_ob_mty_amt1
                  ,v_ob_mty_amt2
              FROM coa_mty_repo_ut_cost
             WHERE cost_loc_grp_cd = 'E'
               AND trd_cd = in_trd_cd
               AND in_cost_yrmon between eff_fm_yrmon and NVL(eff_to_yrmon, '999912')
               AND cntr_tpsz_cd = in_cntr_tpsz_cd
               AND scc_cd = coa_loc_fnc(in_mty_to_nod_cd, 'ECC');

            --ECC 단가 적용
            v_out_epp1_rmk := coa_loc_fnc(in_mty_to_nod_cd, 'ECC') || ' OB EPP-A (ECC)=';
            v_out_epp2_rmk := coa_loc_fnc(in_mty_to_nod_cd, 'ECC') || ' OB EPP-B (ECC)=';
         EXCEPTION
            WHEN OTHERS
            THEN
               v_err_msg := 'ECC OUTBOUND 데이터가 없습니다.';
               --enis_log_prc(SYSDATE, 'get_mty_ecc_ut_cost_uc_amt', v_err_msg);
               v_ib_mty_amt1 := null;
               v_ib_mty_amt2 := null;
         END;

         -- LCC
         IF (   v_ob_mty_amt1 IS NULL
             AND v_ob_mty_amt2 IS NULL)
         THEN
            BEGIN
               SELECT ob_mty_amt1
                  ,ob_mty_amt2
              INTO v_ob_mty_amt1
                  ,v_ob_mty_amt2
              FROM coa_mty_repo_ut_cost
             WHERE cost_loc_grp_cd = 'L'
               AND trd_cd = in_trd_cd
               AND in_cost_yrmon between eff_fm_yrmon and NVL(eff_to_yrmon, '999912')
               AND cntr_tpsz_cd = in_cntr_tpsz_cd
               AND scc_cd = coa_loc_fnc(in_mty_to_nod_cd, 'LCC');

            --LCC 단가 적용
            v_out_epp1_rmk := coa_loc_fnc(in_mty_to_nod_cd, 'ECC') || ' OB EPP-A (LCC)=';
            v_out_epp2_rmk := coa_loc_fnc(in_mty_to_nod_cd, 'ECC') || ' OB EPP-B (LCC)=';
         EXCEPTION
            WHEN OTHERS
            THEN
               v_err_msg := 'LCC OUTBOUND 데이터가 없습니다.';
               --enis_log_prc(SYSDATE, 'get_mty_ecc_ut_cost_uc_amt', v_err_msg);
               v_ob_mty_amt1 := null;
               v_ob_mty_amt2 := null;
            END;
         END IF;

          -- RCC
         IF (   v_ob_mty_amt1 IS NULL
             AND v_ob_mty_amt2 IS NULL)
         THEN
            BEGIN
               SELECT ob_mty_amt1
                  ,ob_mty_amt2
              INTO v_ob_mty_amt1
                  ,v_ob_mty_amt2
              FROM coa_mty_repo_ut_cost
             WHERE cost_loc_grp_cd = 'R'
               AND trd_cd = in_trd_cd
               AND in_cost_yrmon between eff_fm_yrmon and NVL(eff_to_yrmon, '999912')
               AND cntr_tpsz_cd = in_cntr_tpsz_cd
               AND scc_cd = coa_loc_fnc(in_mty_fm_nod_cd, 'RCC');

            --RCC 단가 적용
            v_out_epp1_rmk := coa_loc_fnc(in_mty_to_nod_cd, 'ECC') || ' OB EPP-A (RCC)=';
            v_out_epp2_rmk := coa_loc_fnc(in_mty_to_nod_cd, 'ECC') || ' OB EPP-B (RCC)=';
         EXCEPTION
            WHEN OTHERS
            THEN
               v_err_msg := 'RCC OUTBOUND 데이터가 없습니다.';
               --enis_log_prc(SYSDATE, 'get_mty_ecc_ut_cost_uc_amt', v_err_msg);
               v_ob_mty_amt1 := null;
               v_ob_mty_amt2 := null;
            END;
         END IF;

-- DEST }} ----------------------------------------------------------------------------------------

 
--         IF (in_stnd_cost_cd = '51102000')
--         THEN
            v_rtn_rmk := 'EPP-A(UC)=' || (v_ib_mty_amt1 + v_ob_mty_amt1) || 'rmk(A)=' || v_in_epp1_rmk || v_ib_mty_amt1 || ' ' || v_out_epp1_rmk || v_ob_mty_amt1 ||
                         'EPP-B(UC)=' || (v_ib_mty_amt2 + v_ob_mty_amt2) || 'rmk(B)=' || v_in_epp2_rmk || v_ib_mty_amt2 || ' ' || v_out_epp2_rmk || v_ob_mty_amt2 ;
--         END IF;
      EXCEPTION
         WHEN OTHERS
         THEN
            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', SQLERRM, in_appl_info);
            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', v_err_msg, in_appl_info);
            v_rtn_rmk := '';
      END;

      --단가와 rmk를 함께 리턴
      RETURN v_rtn_rmk;
   END;


/************************************************************************************************************
 * upd_erp_dmdt_n3rd_pty_uc_amt
 * -- CNTR DEM/DET Cost
 * -- Volumn Discount Incentive
 ***********************************************************************************************************/
   FUNCTION para_dmdt(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2
   IS
      CURSOR para_cost_cursor
      IS
         SELECT a2.pctl_no
               ,a2.cost_act_grp_seq
               ,a2.cntr_tpsz_cd
               ,coa_ut_tpsz_fnc(a2.cost_ut_amt_cd, a2.cntr_tpsz_cd) cntr_tpsz_cd_2
               ,a2.coa_cost_src_cd
               ,a2.stnd_cost_cd
           FROM coa_com_para a1, coa_com_cost_para a2
          WHERE a1.pctl_no = a2.pctl_no
            AND NVL(a1.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
            AND a2.pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
            AND a2.cost_ass_bse_cd = 'A'
            AND a2.cost_src_sys_cd = 'ERP'
            AND a2.stnd_cost_cd IN('43201011', '51601011');

      ------------------------------[ 변수선언부             ]-----------------------
      v_err_msg       NUMBER                               := 0;
      v_estm_uc_amt   coa_com_cost_para.estm_uc_amt%TYPE;
   BEGIN
      BEGIN
         FOR para_cost_list IN para_cost_cursor
         LOOP
            BEGIN
               SELECT uc_amt
                 INTO v_estm_uc_amt
                 FROM coa_dmdt_n3rd_pty
                WHERE cost_yrmon = in_cost_yrmon
                  AND cntr_tpsz_cd = 'TEU'
                  AND stnd_cost_cd = para_cost_list.stnd_cost_cd;

               IF (SUBSTR(para_cost_list.cntr_tpsz_cd, -1) > '2')
               THEN
                  -- D2 보다 크면 2배를 넣는다.
                  v_estm_uc_amt := v_estm_uc_amt * 2;
               END IF;
            EXCEPTION
               WHEN OTHERS
               THEN
                  --enis_log_prc(SYSDATE, 'coa_dmdt_n3rd_pty_uc_amt_fnc', SQLERRM);
                  --enis_log_prc(SYSDATE, 'coa_dmdt_n3rd_pty_uc_amt_fnc', 'v_estm_uc_amt: ' || v_estm_uc_amt);
                  --enis_log_prc(SYSDATE, 'coa_dmdt_n3rd_pty_uc_amt_fnc', 'cntr_tpsz_cd_2: ' || para_cost_list.cntr_tpsz_cd_2);
                  --enis_log_prc(SYSDATE, 'coa_dmdt_n3rd_pty_uc_amt_fnc', 'stnd_cost_cd: ' || para_cost_list.stnd_cost_cd);
                  v_estm_uc_amt := '';
            END;

            UPDATE coa_com_cost_para
               SET estm_uc_amt = v_estm_uc_amt
                  ,respb_uc_amt = v_estm_uc_amt
                  ,locl_curr_cd = 'USD'
                  ,cost_cate_cd = 'E'
--                  ,cost_ass_bse_cd = 'A'
            ,      cre_usr_id = 'SYS_COA_PKG'
                  ,cre_dt = SYSDATE
                  ,cost_calc_rmk =
                      DECODE(para_cost_list.stnd_cost_cd
                            ,'43201011', '>DMDT=' || ROUND(v_estm_uc_amt, 2)
                            , '>Vol Discount=' || ROUND(v_estm_uc_amt, 2)
                            )
             WHERE pctl_no = para_cost_list.pctl_no
               AND cost_act_grp_seq = para_cost_list.cost_act_grp_seq
               AND cntr_tpsz_cd = para_cost_list.cntr_tpsz_cd
               AND coa_cost_src_cd = para_cost_list.coa_cost_src_cd;
--            v_err_msg := v_err_msg + SQL%ROWCOUNT;
         END LOOP;
      --enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Result : ' || V_ERR_MSG );
      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      RETURN v_err_msg;
   END;

/************************************************************************************************************
 * upd_erp_hld_cost_uc_amt
 * -- CNTR Fixed Cost
 ***********************************************************************************************************/
   FUNCTION pa_hld(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2
   IS
      CURSOR para_cost_cursor
      IS
         SELECT a1.pctl_no
               ,a2.cost_act_grp_seq
               ,a2.cntr_tpsz_cd
               ,coa_ut_tpsz_fnc(a2.cost_ut_amt_cd, a2.cntr_tpsz_cd) cntr_tpsz_cd_2
               ,a2.coa_cost_src_cd
               ,a2.stnd_cost_cd
               ,a2.fcgo_tz_dys
               ,a1.por_cd
               ,a1.pol_cd
               ,a1.pod_cd
               ,a1.del_cd
           FROM coa_com_para a1, coa_com_cost_para a2
          WHERE a1.pctl_no = a2.pctl_no
            AND NVL(a1.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
            AND a1.pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
            AND a2.cost_ass_bse_cd = 'A'
            AND a2.cost_src_sys_cd = 'ERP'
            AND a2.stnd_cost_cd IN
                   ('52101011'   -- CNTR
                   ,'52201011'
                   ,'52301011'
                   ,'52401011'
                   ,'52601011'
                   ,'52101021'   -- CHSS
                   ,'52201021'
                   ,'52301021'
                   ,'52402011'
                   ,'52501011'
                   ,'52601021'
                   );

      ------------------------------[ 변수선언부             ]-----------------------
      v_err_msg            NUMBER                                  := 0;
      v_estm_uc_amt        coa_com_cost_para.estm_uc_amt%TYPE;
      v_mcgo_tz_dys        coa_com_cost_para.mcgo_tz_dys%TYPE;
      v_cntr_chss_div_cd   coa_hld_cost.cntr_chss_div_cd%TYPE;
      v_uc_amt             coa_hld_cost.chss_hld_uc_amt%TYPE;
      v_tpsz_cd            coa_hld_cost.eq_tpsz_cd%TYPE;
      v_rout_tz_mod_cd     coa_com_cost_para.rout_tz_mod_cd%TYPE;
      v_hld_msg            VARCHAR2(100);
   BEGIN
      BEGIN
         --enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', '+++++++++++++++++++++++++++++++' || in_cost_yrmon);
         FOR para_cost_list IN para_cost_cursor
         LOOP
            IF (   para_cost_list.stnd_cost_cd = '52101011'
                OR para_cost_list.stnd_cost_cd = '52201011'
                OR para_cost_list.stnd_cost_cd = '52301011'
                OR para_cost_list.stnd_cost_cd = '52401011'
                OR para_cost_list.stnd_cost_cd = '52601011'
               )
            THEN
               v_cntr_chss_div_cd := 'CNTR';
               v_tpsz_cd := para_cost_list.cntr_tpsz_cd_2;
            ELSE
               v_cntr_chss_div_cd := 'CHSS';
               v_tpsz_cd := 'BOX';
            END IF;

            /* 단가 구하기 */
            BEGIN
               SELECT NVL(chss_hld_uc_amt, 0) chss_hld_uc_amt
                 INTO v_uc_amt
                 FROM coa_hld_cost
                WHERE cost_yrmon = in_cost_yrmon
                  AND cntr_chss_div_cd = v_cntr_chss_div_cd
                  AND eq_tpsz_cd = v_tpsz_cd
                  AND stnd_cost_cd = para_cost_list.stnd_cost_cd;
            EXCEPTION
               WHEN OTHERS
               THEN
                  v_uc_amt := 0;
            END;

            BEGIN
               /* CSR No. N200802290005                                                  */
               /* US-> MX, MX->US 로 나오는 BKG 중 Trucking 한 것만 찾기 위해서          */
               /* rout_tz_mod_cd 를 변수에 넣어놓았다가 'TD' 인 경우에만 CHSS 붙이도록 함*/
               SELECT DISTINCT rout_tz_mod_cd
                          INTO v_rout_tz_mod_cd
                          FROM coa_com_cost_para
                         WHERE pctl_no = para_cost_list.pctl_no
                           AND (   (    n1st_nod_cd LIKE 'US%'
                                    AND n2nd_nod_cd LIKE 'MX%')
                                OR (    n1st_nod_cd LIKE 'MX%'
                                    AND n2nd_nod_cd LIKE 'US%'));
            EXCEPTION
               WHEN OTHERS
               THEN
                  v_rout_tz_mod_cd := 'XX';
            END;

            /* CNTR 장비비 계산공식 = PDM *(BKG화물별 Full T-Time + Origin Side A Side MT T-Time/2 */
            IF (v_cntr_chss_div_cd = 'CNTR')
            THEN
--               enis_log_prc(SYSDATE
--                           ,'upd_erp_hld_cost_uc_amt'
--                           , 'CNTR : ' || v_uc_amt || ' * (' || NVL(in_fcgo_tz_days, 0) || ' + ' || v_mcgo_tz_dys || ')'
--                           ,in_appl_info
--                           );
               v_mcgo_tz_dys := 0; -- NYK MT 단가에 포함 C.M Park
--                  get_mcgo_tz_days(in_cost_yrmon, para_cost_list.cntr_tpsz_cd_2, para_cost_list.por_cd, para_cost_list.del_cd
--                                  ,in_appl_info);

               UPDATE coa_com_cost_para
                  SET mcgo_tz_dys = v_mcgo_tz_dys
                WHERE pctl_no = para_cost_list.pctl_no
                  AND cost_act_grp_seq = para_cost_list.cost_act_grp_seq
                  AND cntr_tpsz_cd = para_cost_list.cntr_tpsz_cd   -- HOLD 는 순수타입 적용
                  AND coa_cost_src_cd = para_cost_list.coa_cost_src_cd;

               v_estm_uc_amt := v_uc_amt *(NVL(para_cost_list.fcgo_tz_dys, 0) + v_mcgo_tz_dys);
               v_hld_msg :=
                        'HLD UC=' || ROUND(v_uc_amt, 2) || ', FullDays=' || NVL(para_cost_list.fcgo_tz_dys, 0) || ', MTDays='
                        || v_mcgo_tz_dys;
            ELSIF(    v_cntr_chss_div_cd = 'CHSS'
                  AND (   SUBSTR(para_cost_list.por_cd, 1, 2) = 'US'
                       OR SUBSTR(para_cost_list.del_cd, 1, 2) = 'US'
                       OR (    SUBSTR(para_cost_list.pod_cd, 1, 2) = 'US'
                           AND SUBSTR(para_cost_list.del_cd, 1, 2) = 'MX'
                           AND v_rout_tz_mod_cd = 'TD'
                          )
                       -- US에서 discharging 되고 Trucking으로 MX로 운반되는 경우도 CHSS 비용 추가
                       -- CSR No. N200802290005
                       OR (    SUBSTR(para_cost_list.por_cd, 1, 2) = 'MX'
                           AND SUBSTR(para_cost_list.pol_cd, 1, 2) = 'US'
                           AND v_rout_tz_mod_cd = 'TD'
                          )
                      -- MX에서 reciept 하고 Trucking으로 US로 운반되어 loading 경우도 CHSS 비용 추가
                      -- CSR No. N200802290005
                      )
                 )
            THEN
--               IF (SUBSTR(para_cost_list.cntr_tpsz_cd_2, -1) > '2')
--               THEN
                  -- CHSS(샷시) 이고 D2 보다 크면 2배를 넣는다. 선적일수를 곱한다.
                  --enis_log_prc(SYSDATE, 'coa_hld_cost_uc_amt_fnc', 'CHSS : ' || v_uc_amt || ' * 2');
                  --v_estm_uc_amt := v_uc_amt * 2;
--               ELSE
                  --enis_log_prc(SYSDATE, 'coa_hld_cost_uc_amt_fnc', 'CHSS : ' || v_uc_amt);
                  --------------------------------------------------------------
--               |(CHSS 비용 TEU 계산에서 BOX로 바뀌었기 때문에 *2 logic 삭제)  |
                  --------------------------------------------------------------
               v_estm_uc_amt := v_uc_amt;
               v_hld_msg := 'HLD UC=' || ROUND(v_uc_amt, 2);
--               END IF;
            ELSE
               v_estm_uc_amt := 0;
            END IF;

            UPDATE coa_com_cost_para
               SET estm_uc_amt = v_estm_uc_amt
                  ,locl_curr_cd = 'USD'
                  ,cost_cate_cd = 'F'
--                  ,cost_ass_bse_cd = 'A'
            ,      cre_usr_id = 'SYS_COA_PKG'
                  ,cre_dt = SYSDATE
                  ,cost_calc_rmk = v_hld_msg
             WHERE pctl_no = para_cost_list.pctl_no
               AND cost_act_grp_seq = para_cost_list.cost_act_grp_seq
               AND cntr_tpsz_cd = para_cost_list.cntr_tpsz_cd   -- HOLD 는 순수타입 적용
               AND coa_cost_src_cd = para_cost_list.coa_cost_src_cd;
--            v_err_msg := v_err_msg + SQL%ROWCOUNT;
         END LOOP;
      --enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'Result : ' || V_ERR_MSG );
      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      RETURN v_err_msg;
   END;

/************************************************************************************************************
 * get_hld_cost_uc_amt
 ***********************************************************************************************************/
   FUNCTION get_mcgo_tz_days(
      in_cost_yrmon      IN   VARCHAR
     ,in_eq_tpsz_cd      IN   VARCHAR   -- 순수타입 적용
     ,in_mty_fm_nod_cd   IN   VARCHAR
     ,in_mty_to_nod_cd   IN   VARCHAR
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR   -- RETURN TYPE
   IS
-- ===== DECLARE ==========================================
      v_err_msg                  VARCHAR2(1000);
      v_mcgo_tz_dys              coa_com_cost_para.mcgo_tz_dys%TYPE;
      v_mty_tz_por_dys           coa_mty_ecc_cntr_smry.mty_tz_dys%TYPE;
      v_mty_tz_del_dys           coa_mty_ecc_cntr_smry.mty_tz_dys%TYPE;
      v_imbal_rto_por            coa_mty_ecc_ut_cost.imbal_rto%TYPE;
      v_imbal_rto_del            coa_mty_ecc_ut_cost.imbal_rto%TYPE;
      v_cntr_io_vol_sts_por_cd   coa_full_ecc_imbal.cntr_io_vol_sts_cd%TYPE;   -- Origin ECC 장비상태
      v_cntr_io_vol_sts_del_cd   coa_full_ecc_imbal.cntr_io_vol_sts_cd%TYPE;   -- Dest ECC 장비상태
-- ===== BEGIN, EXCEPTION  ======================================
   BEGIN
      BEGIN
        /* MT T-Time 구하기  */
-- ORIGIN -------------------------------------------------------------------------------------------------
--
-- ECC
         BEGIN
            SELECT cntr_io_vol_sts_cd
                  ,NVL(mty_tz_dys, 0) mty_tz_dys
                  ,imbal_rto
              INTO v_cntr_io_vol_sts_por_cd   -- Origin ECC 장비상태
                  ,v_mty_tz_por_dys   -- Origin MT T-Time
                  ,v_imbal_rto_por
              FROM coa_mty_ecc_ut_cost
             WHERE cntr_org_dest_cd = 'D'
               AND cost_loc_grp_cd = 'E'
               AND cost_yrmon = in_cost_yrmon
               AND ecc_cd = coa_loc_fnc(in_mty_fm_nod_cd, 'ECC')
               AND cntr_tpsz_cd = in_eq_tpsz_cd;
         EXCEPTION
            WHEN OTHERS
            THEN
               v_err_msg := 'ECC ORIGIN 데이터가 없습니다.';
         END;

         -- LCC(EMU와 동일하게 ECC->LCC->RCC단위로 붙여주기위해 추가)
         IF (v_cntr_io_vol_sts_por_cd IS NULL)
         THEN
            BEGIN
               SELECT cntr_io_vol_sts_cd
                     ,NVL(mty_tz_dys, 0) mty_tz_dys
                     ,imbal_rto
                 INTO v_cntr_io_vol_sts_por_cd   -- Origin LCC 장비상태
                     ,v_mty_tz_por_dys   -- Origin MT T-Time
                     ,v_imbal_rto_por
                 FROM coa_mty_ecc_ut_cost
                WHERE cntr_org_dest_cd = 'D'
                  AND cost_loc_grp_cd = 'L'
                  AND cost_yrmon = in_cost_yrmon
                  AND ecc_cd = coa_loc_fnc(in_mty_fm_nod_cd, 'LCC')
                  AND cntr_tpsz_cd = in_eq_tpsz_cd;
            EXCEPTION
               WHEN OTHERS
               THEN
                  v_err_msg := 'LCC ORIGIN 데이터가 없습니다.';
            END;
         END IF;

         -- RCC
         IF (v_cntr_io_vol_sts_por_cd IS NULL)
         THEN
            BEGIN
               SELECT cntr_io_vol_sts_cd
                     ,NVL(mty_tz_dys, 0) mty_tz_dys
                     ,imbal_rto
                 INTO v_cntr_io_vol_sts_por_cd   -- Origin RCC 장비상태
                     ,v_mty_tz_por_dys   -- Origin MT T-Time
                     ,v_imbal_rto_por
                 FROM coa_mty_ecc_ut_cost
                WHERE cntr_org_dest_cd = 'D'
                  AND cost_loc_grp_cd = 'R'
                  AND cost_yrmon = in_cost_yrmon
                  AND ecc_cd = coa_loc_fnc(in_mty_fm_nod_cd, 'RCC')
                  AND cntr_tpsz_cd = in_eq_tpsz_cd;
            EXCEPTION
               WHEN OTHERS
               THEN
                  v_err_msg := 'RCC ORIGIN 데이터가 없습니다.';
            END;
         END IF;

-- DEST ----------------------------------------------------------------------------------------------------
--
         -- ECC
         BEGIN
            SELECT cntr_io_vol_sts_cd
                  ,NVL(mty_tz_dys, 0) mty_tz_dys
                  ,imbal_rto
              INTO v_cntr_io_vol_sts_del_cd   -- DEST ECC 장비상태
                  ,v_mty_tz_del_dys   -- DEST MT T-Time
                  ,v_imbal_rto_del
              FROM coa_mty_ecc_ut_cost
             WHERE cntr_org_dest_cd = 'O'
               AND cost_loc_grp_cd = 'E'
               AND cost_yrmon = in_cost_yrmon
               AND ecc_cd = coa_loc_fnc(in_mty_to_nod_cd, 'ECC')
               AND cntr_tpsz_cd = in_eq_tpsz_cd;
         EXCEPTION
            WHEN OTHERS
            THEN
               v_err_msg := 'ECC DEST 데이터가 없습니다.';
         END;

         -- LCC
         IF (v_cntr_io_vol_sts_del_cd IS NULL)
         THEN
            BEGIN
               SELECT cntr_io_vol_sts_cd
                     ,NVL(mty_tz_dys, 0) mty_tz_dys
                     ,imbal_rto
                 INTO v_cntr_io_vol_sts_del_cd   -- DEST LCC 장비상태
                     ,v_mty_tz_del_dys   -- DEST MT T-Time
                     ,v_imbal_rto_del
                 FROM coa_mty_ecc_ut_cost
                WHERE cntr_org_dest_cd = 'O'
                  AND cost_loc_grp_cd = 'L'
                  AND cost_yrmon = in_cost_yrmon
                  AND ecc_cd = coa_loc_fnc(in_mty_to_nod_cd, 'LCC')
                  AND cntr_tpsz_cd = in_eq_tpsz_cd;
            EXCEPTION
               WHEN OTHERS
               THEN
                  v_err_msg := 'LCC DEST 데이터가 없습니다.';
            END;
         END IF;

         -- RCC
         IF (v_cntr_io_vol_sts_del_cd IS NULL)
         THEN
            BEGIN
               SELECT cntr_io_vol_sts_cd
                     ,NVL(mty_tz_dys, 0) mty_tz_dys
                     ,imbal_rto
                 INTO v_cntr_io_vol_sts_del_cd   -- DEST RCC 장비상태
                     ,v_mty_tz_del_dys   -- DEST MT T-Time
                     ,v_imbal_rto_del
                 FROM coa_mty_ecc_ut_cost
                WHERE cntr_org_dest_cd = 'O'
                  AND cost_loc_grp_cd = 'R'
                  AND cost_yrmon = in_cost_yrmon
                  AND ecc_cd = coa_loc_fnc(in_mty_to_nod_cd, 'RCC')
                  AND cntr_tpsz_cd = in_eq_tpsz_cd;
            EXCEPTION
               WHEN OTHERS
               THEN
                  v_err_msg := 'RCC DEST 데이터가 없습니다.';
            END;
         END IF;

         /* MT T-Time 반영 여부 */
         IF (v_cntr_io_vol_sts_por_cd = 'S')
         THEN
            -- POR 에서 Surplus 이면 반영하지 않는다.
            v_mty_tz_por_dys := 0;
         END IF;

         IF (v_cntr_io_vol_sts_del_cd = 'D')
         THEN
            -- DEL 에서 Deficit 이면 반영하지 않는다.
            v_mty_tz_del_dys := 0;
         END IF;

--         enis_log_prc(SYSDATE
--                     ,'coa_hld_cost_uc_amt_fnc'
--                     , 'MCGO_TZ_DAYS : ' || NVL(v_mty_tz_por_dys, 0) || '*' || NVL(v_imbal_rto_por, 0) || ' / 2 + ' || NVL(v_mty_tz_del_dys, 0) || '*'
--                       || NVL(v_imbal_rto_del, 0) || ' / 2'
--                     );
           v_mcgo_tz_dys := NVL(v_mty_tz_por_dys, 0) + NVL(v_mty_tz_del_dys, 0);

                  
      EXCEPTION
         WHEN OTHERS
         THEN
            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', SQLERRM, in_appl_info);
            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', v_err_msg, in_appl_info);
            v_mcgo_tz_dys := 0;
      END;

      RETURN v_mcgo_tz_dys;
   END;


/************************************************************************************************************
 * get_ioc
 ***********************************************************************************************************/
   FUNCTION get_ioc(in_pol_cd IN VARCHAR, in_pod_cd IN VARCHAR, in_appl_info IN VARCHAR2)
      RETURN VARCHAR   -- RETURN TYPE
   IS
-- ===== DECLARE ==========================================
      v_err_msg   VARCHAR2(1000);
      v_ioc_cd    VARCHAR2(10);
-- ===== BEGIN, EXCEPTION  ======================================
   BEGIN
      BEGIN
         SELECT DECODE(a1.conti_cd, a2.conti_cd, 'I' || a1.conti_cd, 'OO')
           INTO v_ioc_cd
           FROM mdm_location a1, mdm_location a2
          WHERE a1.loc_cd = in_pol_cd
            AND a2.loc_cd = in_pod_cd;
      EXCEPTION
         WHEN OTHERS
         THEN
--            v_err_msg := 'get_ioc  데이터가 없습니다.';
--            enis_log_prc(SYSDATE, 'get_ioc', v_err_msg);
--            enis_log_prc(SYSDATE, 'get_ioc', 'in_pol_cd: ' || in_pol_cd);
--            enis_log_prc(SYSDATE, 'get_ioc', 'in_pod_cd: ' || in_pod_cd);
            v_ioc_cd := NULL;
      END;

      RETURN v_ioc_cd;
   END;

/************************************************************************************************************
 * upd_tes_tp
 ***********************************************************************************************************/
   FUNCTION clr_tes_tp(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2
   IS
      v_err_msg   NUMBER := 0;
   BEGIN
      BEGIN
         -- TP FLAG 가 'Y' 인거 찾아서 0 으로 처리한다.
         -- coa_cost_src_cd 앞 2자리가 'TP' 인것은 제외한다.

         --
         UPDATE coa_com_cost_para
            SET estm_uc_amt = 0
               ,cost_calc_rmk = cost_calc_rmk || '>TP ' || estm_uc_amt || '->0'
          WHERE pctl_no IN(
                   SELECT pctl_no
                     FROM coa_com_para
                    WHERE NVL(bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
                      AND pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no)
            AND cost_src_sys_cd = 'TES'
            AND thrp_rt_flg = 'Y'
            AND SUBSTR(coa_cost_src_cd, 1, 2) NOT IN('TP');
--         enis_log_prc(SYSDATE, 'upd_tes_tp', in_start_pctl_no || ' TP update : ' || SQL%ROWCOUNT);
      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      RETURN v_err_msg;
   END;
   
/************************************************************************************************************
 * upd_ttl_para
 ***********************************************************************************************************/
   FUNCTION calc_ttl_cost(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2
   IS
      ------------------------------[ 변수선언부             ]-----------------------
      v_err_msg   NUMBER := 0;
   BEGIN
      BEGIN
         UPDATE coa_com_cost_para
            SET estm_usd_uc_amt =
                   DECODE(NVL(locl_curr_cd, 'USD')
                         ,'USD', NVL(estm_uc_amt, 0)
                         ,coa_conv_curr_usd_fnc(locl_curr_cd, NVL(estm_uc_amt, 0), in_cost_yrmon)
                         )
               ,respb_usd_uc_amt =
                   DECODE(NVL(locl_curr_cd, 'USD')
                         ,'USD', NVL(respb_uc_amt, 0)
                         ,coa_conv_curr_usd_fnc(locl_curr_cd, NVL(respb_uc_amt, 0), in_cost_yrmon)
                         )
               ,estm_usd_ttl_amt =
                   DECODE(NVL(locl_curr_cd, 'USD')
                         ,'USD', NVL(cntr_qty, 0) * NVL(estm_uc_amt, 0)
                         ,coa_conv_curr_usd_fnc(locl_curr_cd, NVL(cntr_qty, 0) * NVL(estm_uc_amt, 0), in_cost_yrmon)
                         )
               ,estm_usd_ttl_amt2 = ESTM_USD_UT_AMT2 * NVL(cntr_qty, 0)
               ,respb_usd_ttl_amt =
                   DECODE(NVL(locl_curr_cd, 'USD')
                         ,'USD', NVL(cntr_qty, 0) * NVL(respb_uc_amt, 0)
                         ,coa_conv_curr_usd_fnc(locl_curr_cd, NVL(cntr_qty, 0) * NVL(respb_uc_amt, 0), in_cost_yrmon)
                         )
          WHERE pctl_no IN(
                   SELECT pctl_no
                     FROM coa_com_para
                    WHERE NVL(bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
                      AND pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no);
--         enis_log_prc(SYSDATE, 'upd_ttl_para', in_start_pctl_no || 'UPDATE : ' || SQL%ROWCOUNT);
      --enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'in_start_pctl_no: ' || in_start_pctl_no || ' in_start_pctl_no: ' || in_end_pctl_no);
      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      RETURN v_err_msg;
   END;

/************************************************************************************************************
 * upd_prd_prod_ctl_mst
 ***********************************************************************************************************/
   FUNCTION calc_prd_sum_cost(in_start_pctl_no IN VARCHAR2, in_end_pctl_no IN VARCHAR2, in_cost_yrmon IN VARCHAR2, in_appl_info IN VARCHAR2)
      RETURN VARCHAR2
   IS
      ------------------------------[ 변수선언부             ]-----------------------
      v_err_msg   NUMBER := 0;
   BEGIN
      BEGIN
         MERGE INTO prd_prod_ctl_mst b1
            USING (SELECT   pctl_no
                           ,SUM(estm_usd_ttl_amt) ttl_expn_amt
                       FROM coa_com_cost_para a1
                      WHERE pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
                        AND coa_cost_src_cd NOT IN('43201011')   -- DMDT 제외
                   GROUP BY pctl_no) b2
            ON (b1.pctl_no = b2.pctl_no)
            WHEN MATCHED THEN
               UPDATE
                  SET b1.ttl_expn_amt = b2.ttl_expn_amt, b1.upd_usr_id = 'SYS_COA_PKG', b1.upd_dt = SYSDATE
               ;
         enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', in_start_pctl_no || ' MERGE : ' || SQL%ROWCOUNT, in_appl_info);

         -- PARA 삭제함
         DELETE      coa_com_cost_para
               WHERE pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
                 AND (SUBSTR(pctl_no, 1, 1) <> 'T') AND (SUBSTR(pctl_no, 1, 1) <> 'X');   -- 'T', 'X' 는 화면에서 확인용 이라 임시로 보관한다.

         DELETE      coa_com_qty_para
               WHERE pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
                 AND (SUBSTR(pctl_no, 1, 1) <> 'T') AND (SUBSTR(pctl_no, 1, 1) <> 'X');

         DELETE      coa_com_para
               WHERE pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
                 AND (SUBSTR(pctl_no, 1, 1) <> 'T') AND (SUBSTR(pctl_no, 1, 1) <> 'X');
      EXCEPTION
         WHEN OTHERS
         THEN
            v_err_msg := -1;
            RAISE;
      END;

      RETURN v_err_msg;
   END;

/************************************************************************************************************
 * upd_fdr_term
 * -- FDR TERM
 ***********************************************************************************************************/
   FUNCTION clr_fdr_term(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2
   IS
      CURSOR para_cost_cursor(v_bkg_no IN VARCHAR2, v_start_pctl_no IN VARCHAR2, v_end_pctl_no IN VARCHAR2)
      IS
         -- FDR TERM 별 공제 - #1
         -- A/G 별 공제방식 NOBT, NIBT, NTST Case1, 2
         SELECT d1.pctl_no
               ,d1.prev_seq
               ,d1.prev_grp
               ,d1.prev_wd_vd
               ,d1.post_seq
               ,d1.post_grp
               ,d1.post_wd_vd
               ,d1.prev_seq2
               ,d1.prev_grp2
               ,d1.post_seq2
               ,d1.post_grp2
               ,d1.wtr_rcv_term_cd
               ,d1.wtr_de_term_cd
           FROM (SELECT c1.pctl_no
                       ,c1.cost_act_grp_seq
                       ,c1.cost_act_grp_cd
                       ,CASE
                           WHEN(c1.cost_act_grp_cd IN('PRWD', 'POWD', 'TRWD', 'TYWD'))   -- 해당 A/G Water 인 경우
                              THEN LAG(c1.cost_act_grp_seq) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                           ELSE NULL
                        END prev_seq   -- 직전 SEQ
                       ,CASE
                           WHEN(cost_act_grp_cd IN('PRWD', 'POWD', 'TRWD', 'TYWD'))
                              THEN LAG(c1.cost_act_grp_cd) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                           ELSE NULL
                        END prev_grp   -- 직전 A/G
                       ,CASE
                           WHEN(    LAG(c1.bfr_trsp_mod_cd) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq) IN('WD', 'VD')
                                AND LAG(c1.aft_trsp_mod_cd) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq) IN('WD', 'VD')
                               )
                              THEN 'Y'
                           ELSE 'N'
                        END prev_wd_vd   -- 직전 WD,VD 여부
                       ,CASE
                           WHEN(cost_act_grp_cd IN('PRWD', 'POWD', 'TRWD', 'TYWD'))
                              THEN LEAD(c1.cost_act_grp_seq) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                           ELSE NULL
                        END post_seq   -- 직후 SEQ
                       ,CASE
                           WHEN(cost_act_grp_cd IN('PRWD', 'POWD', 'TRWD', 'TYWD'))
                              THEN LEAD(c1.cost_act_grp_cd) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                           ELSE NULL
                        END post_grp   -- 직후 A/G
                       ,CASE
                           WHEN(    LEAD(c1.bfr_trsp_mod_cd) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq) IN('WD', 'VD')
                                AND LEAD(c1.aft_trsp_mod_cd) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq) IN('WD', 'VD')
                               )
                              THEN 'Y'
                           ELSE 'N'
                        END post_wd_vd   -- 직후 WD,VD 여부
                       ,CASE
                           WHEN(    cost_act_grp_cd IN('PRWD', 'POWD', 'TRWD', 'TYWD')
                                AND wtr_rcv_term_cd = 'V'
                               )   --WTR_RCV_TERM_CD이 'V' 일때만 직직전 SEQ 찾는다. (CSR No.N200712120003)
                              THEN CASE
                                     WHEN(SUBSTR(LAG(c1.cost_act_grp_cd, 2) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq), 1, 1) = 'N')
                                        THEN LAG(c1.cost_act_grp_seq, 2) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                                     ELSE LAG(c1.cost_act_grp_seq, 3) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                                  END
                           ELSE NULL
                        END prev_seq2   -- 직직전 A/G 이 N 으로 시작하면 직직전 SEQ 아니면 직직직전 SEQ
                       ,CASE
                           WHEN(cost_act_grp_cd IN('PRWD', 'POWD', 'TRWD', 'TYWD'))
                              THEN CASE
                                     WHEN(SUBSTR(LAG(c1.cost_act_grp_cd, 2) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq), 1, 1) = 'N')
                                        THEN LAG(c1.cost_act_grp_cd, 2) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                                     ELSE LAG(c1.cost_act_grp_cd, 3) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                                  END
                           ELSE NULL
                        END prev_grp2   -- 직직전 A/G 이 N 으로 시작하면 직직전 A/G 아니면 직직직전 A/G
                       ,CASE
                           WHEN(    cost_act_grp_cd IN('PRWD', 'POWD', 'TRWD', 'TYWD')
                                AND wtr_de_term_cd = 'V')   --WTR_DE_TERM_CD 'V' 일때만 직직후 SEQ 찾는다
                              THEN CASE
                                     WHEN(SUBSTR(LEAD(c1.cost_act_grp_cd, 2) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq), 1, 1) = 'N')
                                        THEN LEAD(c1.cost_act_grp_seq, 2) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                                     ELSE LEAD(c1.cost_act_grp_seq, 3) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                                  END
                           ELSE NULL
                        END post_seq2   -- 직직후 A/G 이 N 으로 시작하면 직직후 SEQ 아니면 직직직후 SEQ
                       ,CASE
                           WHEN(cost_act_grp_cd IN('PRWD', 'POWD', 'TRWD', 'TYWD'))
                              THEN CASE
                                     WHEN(SUBSTR(LEAD(c1.cost_act_grp_cd, 2) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq), 1, 1) = 'N')
                                        THEN LEAD(c1.cost_act_grp_cd, 2) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                                     ELSE LEAD(c1.cost_act_grp_cd, 3) OVER(ORDER BY c1.pctl_no, c1.cost_act_grp_seq)
                                  END
                           ELSE NULL
                        END post_grp2   -- 직직후 A/G 이 N 으로 시작하면 직직후 A/G 아니면 직직직후 A/G
                       ,c1.bfr_trsp_mod_cd --c1.pre_cost_act_grp_cd
                       ,c1.aft_trsp_mod_cd --c1.pst_cost_act_grp_cd
                       ,c1.org_loc_cd
                       ,c1.wtr_rcv_term_cd
                       ,c1.wtr_de_term_cd
                   FROM (SELECT   b1.pctl_no
                                 ,b1.cost_act_grp_seq
                                 ,b1.cost_act_grp_cd
                                 ,b1.org_loc_cd
                                 ,b1.dest_loc_cd
                                 ,b1.bfr_trsp_mod_cd --b1.pre_cost_act_grp_cd
                                 ,b1.aft_trsp_mod_cd --b1.pst_cost_act_grp_cd
                                 ,b1.wtr_rcv_term_cd
                                 ,b1.wtr_de_term_cd
                             FROM (SELECT DISTINCT a2.pctl_no
                                                  ,a2.cost_act_grp_seq
                                                  ,a2.cost_act_grp_cd
                                                  ,SUBSTR(a2.n1st_nod_cd, 1, 5) org_loc_cd
                                                  ,SUBSTR(a2.n2nd_nod_cd, 1, 5) dest_loc_cd
                                                  ,a2.bfr_trsp_mod_cd --a2.pre_cost_act_grp_cd 
                                                  ,a2.aft_trsp_mod_cd --a2.pst_cost_act_grp_cd
                                                  ,a2.wtr_rcv_term_cd
                                                  ,a2.wtr_de_term_cd
                                              FROM coa_com_para a1, coa_com_cost_para a2
                                             WHERE a1.pctl_no = a2.pctl_no
                                               AND NVL(a1.bkg_no, 'XXXXX') = NVL(v_bkg_no, 'XXXXX')
                                               AND a2.pctl_no BETWEEN v_start_pctl_no AND v_end_pctl_no) b1
                         ORDER BY b1.cost_act_grp_seq) c1) d1
          WHERE d1.cost_act_grp_cd IN('PRWD', 'POWD', 'TRWD', 'TYWD');   -- 기존 A/G

      ------------------------------[ 변수선언부             ]-----------------------
      v_err_msg           NUMBER                                    := 0;
      v_pctl_no           coa_com_cost_para.pctl_no%TYPE;
      v_prev_seq          coa_com_cost_para.cost_act_grp_seq%TYPE;
      v_prev_grp          coa_com_cost_para.cost_act_grp_cd%TYPE;
      v_prev_wd_vd        VARCHAR(1);
      v_post_seq          coa_com_cost_para.cost_act_grp_seq%TYPE;
      v_post_grp          coa_com_cost_para.cost_act_grp_cd%TYPE;
      v_post_wd_vd        VARCHAR(1);
      v_prev_seq2         coa_com_cost_para.cost_act_grp_seq%TYPE;
      v_prev_grp2         coa_com_cost_para.cost_act_grp_cd%TYPE;
      v_post_seq2         coa_com_cost_para.cost_act_grp_seq%TYPE;
      v_post_grp2         coa_com_cost_para.cost_act_grp_cd%TYPE;
      v_wtr_rcv_term_cd   coa_com_cost_para.wtr_rcv_term_cd%TYPE;
      v_wtr_de_term_cd    coa_com_cost_para.wtr_de_term_cd%TYPE;
   BEGIN
      BEGIN
         --TRS에서 agrrement 된 term을 붙여주면 모두 그 term으로 update 한다.(CSR No.N200712120003)
         MERGE INTO coa_com_cost_para b1
            USING (SELECT DISTINCT a2.pctl_no
                                  ,a2.cntr_tpsz_cd
                                  ,a2.wtr_rcv_term_cd
                                  ,a2.wtr_de_term_cd
                                  ,a2.cost_act_grp_seq
                                  ,a2.cost_act_grp_cd
                              FROM coa_com_para a1, coa_com_cost_para a2
                             WHERE a1.pctl_no = a2.pctl_no
                               AND NVL(a1.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
                               AND a2.pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
                               AND a2.cost_ass_bse_cd in ('C', 'L') -- Actual Cost 붙는 것들도 term setting 해줘야 함
                               AND a2.ctrt_rtn_flg = 'Y'
                               AND a2.wtr_rcv_term_cd IS NOT NULL
                               AND a2.wtr_de_term_cd IS NOT NULL
                               AND a2.cost_src_sys_cd = 'TRS') b2
            ON (    b1.pctl_no = b2.pctl_no
                AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
                AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
                AND b1.ctrt_rtn_flg  in ('N', 'L')) -- Actual Cost 붙는 것들도 term setting 해줘야 함
            WHEN MATCHED THEN
               UPDATE
                  SET b1.wtr_rcv_term_cd = b2.wtr_rcv_term_cd, b1.wtr_de_term_cd = b2.wtr_de_term_cd, b1.cre_usr_id = 'SYS_COA_PKG'
                     ,b1.cre_dt = SYSDATE
                     , b1.cost_calc_rmk = cost_calc_rmk || '>WTR TERM SET TRS'
               ;
      --TRS term과 맞추기
      -- FDR Term : Link AG 이 Water 인 경우 적용
      --           (VSL 인 경우는 모든 Terminal 비용을 Company가 지불하므로
      --           Water의 FIO Term 일 경우와 동일 Logic을 적용)
      -- WATER TERM CODE 가 NULL 인경우 TERM SETTING 를 해준다.
      -- TRS 로직 보완 향후 COA 에서 로직 제거 필요. 
         MERGE INTO coa_com_cost_para c1
            USING (SELECT b1.pctl_no
                         ,b1.cost_act_grp_seq
                         ,b1.cntr_tpsz_cd
                         ,b1.coa_cost_src_cd
                         ,b1.cost_act_grp_cd
                         ,b1.org_loc_cd
                         ,b1.dest_loc_cd
                         ,b2.fdr_rcv_term_cd wtr_rcv_term_cd
                         ,b2.fdr_de_term_cd wtr_de_term_cd
                     FROM (SELECT DISTINCT a2.pctl_no
                                          ,a2.cost_act_grp_seq
                                          ,a2.cntr_tpsz_cd
                                          ,a2.coa_cost_src_cd
                                          ,a2.cost_act_grp_cd
                                          ,SUBSTR(a2.n1st_nod_cd, 1, 5) org_loc_cd
                                          ,SUBSTR(a2.n2nd_nod_cd, 1, 5) dest_loc_cd
                                      FROM coa_com_para a1, coa_com_cost_para a2
                                     WHERE a1.pctl_no = a2.pctl_no
                                       AND NVL(a1.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
                                       AND a2.pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
                                       AND cost_act_grp_cd IN('PRWD', 'POWD', 'TRWD', 'TYWD')
                                       AND (   wtr_rcv_term_cd IS NULL
                                            OR wtr_de_term_cd IS NULL)) b1
                         ,(SELECT org_loc_cd
                                 ,dest_loc_cd
                                 ,full_mty_cd
                                 ,fdr_rcv_term_cd   -- I: FREE IN, O: FREE OUT, Y: CY, T: TACKLE
                                 ,fdr_de_term_cd   -- I: FREE IN, O: FREE OUT, Y: CY, T: TACKLE
                             FROM coa_trns_fdr_term
                            WHERE full_mty_cd = 'F') b2
                    WHERE b1.org_loc_cd = b2.org_loc_cd
                      AND b1.dest_loc_cd = b2.dest_loc_cd) c2
            ON (    c1.pctl_no = c2.pctl_no
                AND c1.cost_act_grp_seq = c2.cost_act_grp_seq
                AND c1.cntr_tpsz_cd = c2.cntr_tpsz_cd
                AND c1.coa_cost_src_cd = c2.coa_cost_src_cd)
            WHEN MATCHED THEN
               UPDATE
                  SET c1.wtr_rcv_term_cd = c2.wtr_rcv_term_cd, c1.wtr_de_term_cd = c2.wtr_de_term_cd, c1.cost_cate_cd = 'K'
                     ,c1.cre_usr_id = 'SYS_COA_PKG', c1.cre_dt = SYSDATE
                     , c1.cost_calc_rmk = cost_calc_rmk || '>WTR TERM SET'
               ;

--         enis_log_prc(SYSDATE, 'upd_fdr_term', 'wtr_term_cd ' || SQL%ROWCOUNT);
         --
         -- TS 비용처리#1
         -- %FL(SVLDFL, TPNDFL, TMNDFL) 계정 CTRT_RTN_FLG = N 이면 0 처리
         UPDATE coa_com_cost_para
            SET estm_uc_amt = 0
               ,respb_uc_amt = 0
               ,cost_calc_rmk = cost_calc_rmk || '>TS (SV/TP/TM)NDFL ' || estm_uc_amt || '->0'
--          WHERE coa_cost_src_cd LIKE '%FL'
         WHERE  coa_cost_src_cd IN('SVLDFL', 'TPNDFL', 'TMNDFL')   -- 이경한D 요청으로 3개 계정만 처리, 2008.01.25 전성진
            AND ctrt_rtn_flg = 'N'
            AND cost_act_grp_cd = 'NTST'
            AND pctl_no IN(
                   SELECT a2.pctl_no
                     FROM coa_com_para a1, coa_com_cost_para a2
                    WHERE a1.pctl_no = a2.pctl_no
                      AND NVL(a1.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
                      AND a2.pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no);

--
         -- TS 비용처리#2
         MERGE INTO coa_com_cost_para c1
            USING (SELECT b1.pctl_no
                         ,b1.cost_act_grp_seq
                         ,b1.cntr_tpsz_cd
                         ,b1.coa_cost_src_cd
                         ,b1.estm_uc_amt
                     FROM (SELECT a2.pctl_no
                                 ,a2.cost_act_grp_seq
                                 ,a2.cntr_tpsz_cd
                                 ,a2.coa_cost_src_cd
                                 , a2.estm_uc_amt * 2 estm_uc_amt
                             FROM coa_com_para a1, coa_com_cost_para a2
                            WHERE a1.pctl_no = a2.pctl_no
                              AND NVL(a1.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
                              AND a2.pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
                              AND a2.coa_cost_src_cd in ('SVLDTS', 'TPNDTS', 'TMNDTS') 
                              AND a2.ctrt_rtn_flg = 'N') b1
                         ,(SELECT DISTINCT a2.pctl_no
                                          ,a2.cost_act_grp_seq
                                          ,a2.cntr_tpsz_cd
                                          ,a2.coa_cost_src_cd
                                          ,a2.cost_act_grp_cd
                                          ,a2.n1st_nod_cd
                                          ,a2.bfr_trsp_mod_cd --a2.pre_cost_act_grp_cd
                                          ,a2.aft_trsp_mod_cd --a2.aft_trsp_mod_cd
                                          ,a2.wtr_de_term_cd
                                          ,a2.wtr_rcv_term_cd
                                      FROM coa_com_para a1, coa_com_cost_para a2
                                     WHERE a1.pctl_no = a2.pctl_no
                                       AND NVL(a1.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
                                       AND a2.pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
                                       AND a2.cost_act_grp_cd = 'NTST'
                                       AND a2.bfr_trsp_mod_cd IN('WD', 'VD')
                                       AND a2.aft_trsp_mod_cd IN('WD', 'VD')
                                       AND a2.ctrt_rtn_flg = 'N'
                                  ORDER BY cost_act_grp_seq) b2
                    WHERE b1.pctl_no = b2.pctl_no
                      AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
                      AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
                      AND b1.coa_cost_src_cd = b2.coa_cost_src_cd) c2
            ON (    c1.pctl_no = c2.pctl_no
                AND c1.cost_act_grp_seq = c2.cost_act_grp_seq
                AND c1.cntr_tpsz_cd = c2.cntr_tpsz_cd
                AND c1.coa_cost_src_cd = c2.coa_cost_src_cd)
            WHEN MATCHED THEN
               UPDATE
                  SET c1.estm_uc_amt = c2.estm_uc_amt, c1.respb_uc_amt = c2.estm_uc_amt, c1.cost_cate_cd = 'K'
                     ,c1.cre_usr_id = 'SYS_COA_PKG', c1.cre_dt = SYSDATE
                     ,c1.cost_calc_rmk = cost_calc_rmk || '>TS ' || c1.estm_uc_amt || '->' || c2.estm_uc_amt
               ;

--         enis_log_prc(SYSDATE, 'upd_fdr_term', 'TS ' || SQL%ROWCOUNT);
         -- FDR TERM 별 공제 - #1
         -- RCV TERM - NOBT, NIBT, NTST Case1, 2
         FOR para_cost_list IN para_cost_cursor(in_bkg_no,  in_start_pctl_no, in_end_pctl_no)
         LOOP
--            enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'coa_com_cost_para : ' || SQL%ROWCOUNT || ' DELETE');
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'pctl_no ' || para_cost_list.pctl_no);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'prev_seq ' || para_cost_list.prev_seq);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'prev_grp ' || para_cost_list.prev_grp);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'prev_wd_vd ' || para_cost_list.prev_wd_vd);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'prev_seq ' || para_cost_list.post_seq);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'prev_grp ' || para_cost_list.post_grp);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'prev_wd_vd ' || para_cost_list.post_wd_vd);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'prev_seq ' || para_cost_list.prev_seq2);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'prev_grp ' || para_cost_list.prev_grp2);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'prev_seq ' || para_cost_list.post_seq2);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'prev_grp ' || para_cost_list.post_grp2);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'wtr_rcv_term_cd ' || para_cost_list.wtr_rcv_term_cd);
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'wtr_de_term_cd ' || para_cost_list.wtr_de_term_cd);
            MERGE INTO coa_com_cost_para b1
               USING (SELECT a1.pctl_no
                            ,a1.cost_act_grp_seq
                            ,a1.cntr_tpsz_cd
                            ,a1.coa_cost_src_cd
                            ,a2.nod_stvg_rto aa
                            ,a2.nod_thrp_rto bb
                            ,a2.nod_tml_rto cc
                            ,DECODE(SUBSTR(coa_cost_src_cd, 1, 2)
                                   ,'SV', a1.estm_uc_amt * a2.nod_stvg_rto
                                   ,'TP', a1.estm_uc_amt * a2.nod_thrp_rto
                                   ,'TM', a1.estm_uc_amt * a2.nod_tml_rto                                   
                                   ) estm_uc_amt
                        FROM coa_com_cost_para a1, coa_trns_term_calc a2
                       WHERE a1.pctl_no = para_cost_list.pctl_no
                         AND a1.cost_act_grp_seq = para_cost_list.prev_seq
                         AND (   a1.coa_cost_src_cd LIKE 'SV%'
                              OR a1.coa_cost_src_cd LIKE 'TP%'
                              OR a1.coa_cost_src_cd LIKE 'TMND%'                             
                             )
--                              AND a1.ctrt_rtn_flg = 'N' -- 박진순 로직확인 필요
                         AND a2.cost_act_grp_cd = para_cost_list.prev_grp
                         AND a2.calc_term_cd = 'RCV'
                         AND a2.wtr_term_cd = para_cost_list.wtr_rcv_term_cd
                         AND a2.wtr_mod_flg = para_cost_list.prev_wd_vd) b2   -- 직전
               ON (b1.pctl_no = b2.pctl_no
               AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
               AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
               AND b1.coa_cost_src_cd = b2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET b1.estm_uc_amt = b2.estm_uc_amt, b1.respb_uc_amt = b2.estm_uc_amt, b1.cost_cate_cd = 'K'
                        ,b1.cre_usr_id = 'SYS_COA_PKG', b1.cre_dt = SYSDATE
                        ,b1.cost_calc_rmk = cost_calc_rmk || '>FDR RCV1 ' || b1.estm_uc_amt || '->' || b2.estm_uc_amt
                  ;
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'RCV TERM - NOBT, NIBT, NTST Case1, 2' || SQL%ROWCOUNT);
--            MERGE INTO coa_com_cost_para b1
--               USING (SELECT a1.pctl_no
--                            ,a1.cost_act_grp_seq
--                            ,a1.cntr_tpsz_cd
--                            ,a1.coa_cost_src_cd
--                            ,a2.nod_stvg_rto aa
--                            ,a2.nod_thrp_rto bb
--                            ,a2.nod_tml_rto cc
--                            ,DECODE(SUBSTR(coa_cost_src_cd, 1, 2)
--                                   ,'92', CASE   -- 이경한 요청 2007.09.11
--                                       -- 직후 
--                                       WHEN(    para_cost_list.post_grp IN('NTST')
--                                            AND para_cost_list.post_wd_vd = 'Y'
--                                            AND para_cost_list.wtr_de_term_cd = 'Y'   -- NTST, WD,VD, CY, 면 TML RATIO 적용
--                                           )
--                                          THEN a1.estm_uc_amt * a2.nod_tml_rto
--                                       WHEN(    para_cost_list.post_grp IN('NTST')
--                                            AND para_cost_list.post_wd_vd = 'Y'
--                                            AND para_cost_list.wtr_de_term_cd = 'T'   -- NTST, WD,VD, TACKLE, 92301011,92301041 면 SV RATIO 적용
--                                            AND a1.coa_cost_src_cd IN('92301011', '92301041')
--                                           )
--                                          THEN a1.estm_uc_amt * a2.nod_stvg_rto
--                                       ELSE a1.estm_uc_amt
--                                    END
--                                   ) estm_uc_amt
--                        FROM coa_com_cost_para a1, coa_trns_term_calc a2
--                       WHERE a1.pctl_no = para_cost_list.pctl_no
--                         AND a1.cost_act_grp_seq = para_cost_list.prev_seq
--                         AND ( a1.coa_cost_src_cd LIKE '92%')
----                              AND a1.ctrt_rtn_flg = 'N' -- 박진순 로직확인 필요
--                         AND a2.cost_act_grp_cd = para_cost_list.prev_grp
--                         AND a2.calc_term_cd = 'RCV'
--                         AND a2.wtr_term_cd = para_cost_list.wtr_rcv_term_cd
--                         AND a2.wtr_mod_flg = para_cost_list.prev_wd_vd) b2   -- 직전
--               ON (b1.pctl_no = b2.pctl_no
--               AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
--               AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
--               AND b1.coa_cost_src_cd = b2.coa_cost_src_cd)
--               WHEN MATCHED THEN
--                  UPDATE
--                     SET b1.estm_uc_amt = b2.estm_uc_amt, b1.respb_uc_amt = b2.estm_uc_amt, b1.cost_cate_cd = 'K'
--                        ,b1.cre_usr_id = 'SYS_COA_PKG', b1.cre_dt = SYSDATE
--                        ,b1.cost_calc_rmk = cost_calc_rmk || '>FDR NTST RCV1 ' || b1.estm_uc_amt || '->' || b2.estm_uc_amt
--                  ;
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'RCV TERM - NTST Case1, 2' || SQL%ROWCOUNT);

            -- FDR TERM 별 공제 - #2
            -- DEL TERM - NOBT, NIBT, NTST Case1, 2
            MERGE INTO coa_com_cost_para b1
               USING (SELECT a1.pctl_no
                            ,a1.cost_act_grp_seq
                            ,a1.cntr_tpsz_cd
                            ,a1.coa_cost_src_cd
                            ,a2.nod_stvg_rto aa
                            ,a2.nod_thrp_rto bb
                            ,a2.nod_tml_rto cc
                            ,DECODE(SUBSTR(coa_cost_src_cd, 1, 2)
                                   ,'SV', a1.estm_uc_amt * a2.nod_stvg_rto
                                   ,'TP', a1.estm_uc_amt * a2.nod_thrp_rto
                                   ,'TM', a1.estm_uc_amt * a2.nod_tml_rto
                                   ) estm_uc_amt
                        FROM coa_com_cost_para a1, coa_trns_term_calc a2
                       WHERE a1.pctl_no = para_cost_list.pctl_no
                         AND a1.cost_act_grp_seq = para_cost_list.post_seq
                         AND (   a1.coa_cost_src_cd LIKE 'SV%'
                              OR a1.coa_cost_src_cd LIKE 'TP%'
                              OR a1.coa_cost_src_cd LIKE 'TMND%'                              
                             )
                         AND a2.cost_act_grp_cd = para_cost_list.post_grp
                         AND a2.calc_term_cd = 'DEL'
                         AND a2.wtr_term_cd = para_cost_list.wtr_de_term_cd
                         AND a2.wtr_mod_flg = para_cost_list.post_wd_vd) b2
               ON (b1.pctl_no = b2.pctl_no
               AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
               AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
               AND b1.coa_cost_src_cd = b2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET b1.estm_uc_amt = b2.estm_uc_amt, b1.respb_uc_amt = b2.estm_uc_amt, b1.cost_cate_cd = 'K'
                        ,b1.cre_usr_id = 'SYS_COA_PKG', b1.cre_dt = SYSDATE
                        ,b1.cost_calc_rmk = cost_calc_rmk || '>FDR DEL1 ' || b1.estm_uc_amt || '->' || b2.estm_uc_amt
                  ;
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'DEL TERM - NOBT, NIBT, NTST Case1, 2' || SQL%ROWCOUNT);

--            MERGE INTO coa_com_cost_para b1
--               USING (SELECT a1.pctl_no
--                            ,a1.cost_act_grp_seq
--                            ,a1.cntr_tpsz_cd
--                            ,a1.coa_cost_src_cd
--                            ,a2.nod_stvg_rto aa
--                            ,a2.nod_thrp_rto bb
--                            ,a2.nod_tml_rto cc
--                            ,DECODE(SUBSTR(coa_cost_src_cd, 1, 2)
--                                   ,'92', CASE   -- 이경한 요청 2007.09.11
--                                       -- 직후 post_grp post_wd_vd,wtr_de_term_cd
--                                       WHEN(    para_cost_list.post_grp IN('NTST')
--                                            AND para_cost_list.post_wd_vd = 'Y'
--                                            AND para_cost_list.wtr_de_term_cd = 'Y'   -- NTST, WD,VD, CY, 면 TML RATIO 적용
--                                           )
--                                          THEN a1.estm_uc_amt * a2.nod_tml_rto
--                                       WHEN(    para_cost_list.post_grp IN('NTST')
--                                            AND para_cost_list.post_wd_vd = 'Y'
--                                            AND para_cost_list.wtr_de_term_cd = 'T'   -- NTST, WD,VD, TACKLE, 92301011,92301041 면 SV RATIO 적용
--                                            AND a1.coa_cost_src_cd IN('92301011', '92301041')
--                                           )
--                                          THEN a1.estm_uc_amt * a2.nod_stvg_rto
--                                       ELSE a1.estm_uc_amt
--                                    END
--                                   ) estm_uc_amt
--                        FROM coa_com_cost_para a1, coa_trns_term_calc a2
--                       WHERE a1.pctl_no = para_cost_list.pctl_no
--                         AND a1.cost_act_grp_seq = para_cost_list.post_seq
--                         AND ( a1.coa_cost_src_cd LIKE '92%')
--                         AND a2.cost_act_grp_cd = para_cost_list.post_grp
--                         AND a2.calc_term_cd = 'DEL'
--                         AND a2.wtr_term_cd = para_cost_list.wtr_de_term_cd
--                         AND a2.wtr_mod_flg = para_cost_list.post_wd_vd) b2
--               ON (b1.pctl_no = b2.pctl_no
--               AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
--               AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
--               AND b1.coa_cost_src_cd = b2.coa_cost_src_cd)
--               WHEN MATCHED THEN
--                  UPDATE
--                     SET b1.estm_uc_amt = b2.estm_uc_amt, b1.respb_uc_amt = b2.estm_uc_amt, b1.cost_cate_cd = 'K'
--                        ,b1.cre_usr_id = 'SYS_COA_PKG', b1.cre_dt = SYSDATE
--                        ,b1.cost_calc_rmk = cost_calc_rmk || '>FDR NTST DEL1 ' || b1.estm_uc_amt || '->' || b2.estm_uc_amt
--                  ;
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'DEL NTST TERM - NTST Case1, 2' || SQL%ROWCOUNT);

            -- RCV TERM > TES Cost Code 계산 로직 > 직전 또는 직후 NODE(NTST)
            MERGE INTO coa_com_cost_para b1
               USING (SELECT a1.pctl_no
                            ,a1.cost_act_grp_seq
                            ,a1.cntr_tpsz_cd
                            ,a1.coa_cost_src_cd
                            ,a2.nxt_nod_stvg_rto
                            ,a2.nxt_nod_thrp_rto
                            ,DECODE(SUBSTR(coa_cost_src_cd, 1, 2)
                                   ,'SV', a1.estm_uc_amt * a2.nxt_nod_stvg_rto
                                   ,'TP', a1.estm_uc_amt * a2.nxt_nod_thrp_rto
                                   ) estm_uc_amt
                        FROM coa_com_cost_para a1, coa_trns_term_calc a2
                       WHERE a1.pctl_no = para_cost_list.pctl_no
                         AND a1.cost_act_grp_seq = para_cost_list.prev_seq2
                         AND (   a1.coa_cost_src_cd LIKE 'SV%'
                              OR a1.coa_cost_src_cd LIKE 'TP%')
                         AND a2.cost_act_grp_cd = para_cost_list.prev_grp2
                         AND a2.calc_term_cd = 'RCV'
                         AND a2.wtr_term_cd = 'V'
                         AND a2.wtr_mod_flg = para_cost_list.prev_wd_vd) b2
               ON (b1.pctl_no = b2.pctl_no
               AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
               AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
               AND b1.coa_cost_src_cd = b2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET b1.estm_uc_amt = b2.estm_uc_amt, b1.respb_uc_amt = b2.estm_uc_amt, b1.cost_cate_cd = 'K'
                        ,b1.cre_usr_id = 'SYS_COA_PKG', b1.cre_dt = SYSDATE
                        ,b1.cost_calc_rmk = cost_calc_rmk || '>FDR RCV2 ' || b1.estm_uc_amt || '->' || b2.estm_uc_amt
                  ;
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'RCV 2차' || SQL%ROWCOUNT);
            -- DEL TERM > TES Cost Code 계산 로직 > 직전 또는 직후 NODE(NTST)
            MERGE INTO coa_com_cost_para b1
               USING (SELECT a1.pctl_no
                            ,a1.cost_act_grp_seq
                            ,a1.cntr_tpsz_cd
                            ,a1.coa_cost_src_cd
                            ,a2.nxt_nod_stvg_rto
                            ,a2.nxt_nod_thrp_rto
                            ,DECODE(SUBSTR(coa_cost_src_cd, 1, 2)
                                   ,'SV', a1.estm_uc_amt * a2.nxt_nod_stvg_rto
                                   ,'TP', a1.estm_uc_amt * a2.nxt_nod_thrp_rto
                                   ) estm_uc_amt
                        FROM coa_com_cost_para a1, coa_trns_term_calc a2
                       WHERE a1.pctl_no = para_cost_list.pctl_no
                         AND a1.cost_act_grp_seq = para_cost_list.post_seq2
                         AND (   a1.coa_cost_src_cd LIKE 'SV%'
                              OR a1.coa_cost_src_cd LIKE 'TP%')
                         AND a2.cost_act_grp_cd = para_cost_list.post_grp2
                         AND a2.calc_term_cd = 'DEL'
                         AND a2.wtr_term_cd = 'V'
                         AND a2.wtr_mod_flg = para_cost_list.post_wd_vd) b2
               ON (b1.pctl_no = b2.pctl_no
               AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
               AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
               AND b1.coa_cost_src_cd = b2.coa_cost_src_cd)
               WHEN MATCHED THEN
                  UPDATE
                     SET b1.estm_uc_amt = b2.estm_uc_amt, b1.respb_uc_amt = b2.estm_uc_amt, b1.cost_cate_cd = 'K'
                        ,b1.cre_usr_id = 'SYS_COA_PKG', b1.cre_dt = SYSDATE
                        ,b1.cost_calc_rmk = cost_calc_rmk || '>FDR DEL2 ' || b1.estm_uc_amt || '->' || b2.estm_uc_amt
                  ;
--            enis_log_prc(SYSDATE, 'upd_fdr_term', 'DEL 2차' || SQL%ROWCOUNT);
         END LOOP;
      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      RETURN v_err_msg;
   END;

/************************************************************************************************************
 * para_agt_oth(신규테이블때문에 주석처리 MIG_USER)
 ***********************************************************************************************************/
   FUNCTION para_agt_oth(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2
   IS
      CURSOR para_cost_cursor
      IS
         SELECT a2.pctl_no
               ,a2.cost_act_grp_seq
               ,a2.cntr_tpsz_cd
               ,a2.coa_cost_src_cd   --,a2.stnd_cost_cd
               ,a1.por_cd
               ,a1.del_cd
           FROM coa_com_para a1, coa_com_cost_para a2
          WHERE a1.pctl_no = a2.pctl_no
            AND NVL(a1.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
            AND a2.pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
            --AGT Other계정 9개
            AND a2.coa_cost_src_cd IN('512691', '512692', '512693', '512694', '512695', '512696', '512697', '512698', '512699');

      ------------------------------[ 변수선언부             ]-----------------------
      v_err_msg           VARCHAR2(4000);
      v_estm_por_uc_amt   coa_com_cost_para.estm_uc_amt%TYPE;
      v_estm_del_uc_amt   coa_com_cost_para.estm_uc_amt%TYPE;
   BEGIN
      BEGIN
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'BKG_NO=' || in_bkg_no );
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'START PCTL=' || in_start_pctl_no );
--      enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'END PCTL=' || in_end_pctl_no );

         FOR para_cost_list IN para_cost_cursor
         LOOP


            BEGIN
               -- POR 비용
               SELECT stnd_cost_usd_amt
                 INTO v_estm_por_uc_amt
                 FROM coa_otr_comm
                WHERE cost_yrmon = in_cost_yrmon
                  AND cntr_tpsz_cd = 'TEU'
                  AND comm_loc_cd = coa_get_finc_loc_cd_fnc(para_cost_list.por_cd, 'AGT')
                  AND coa_cost_src_cd = para_cost_list.coa_cost_src_cd;

               v_err_msg := ' POR=' || v_estm_por_uc_amt;
            EXCEPTION
               WHEN NO_DATA_FOUND
               THEN
                  v_estm_por_uc_amt := 0;
            END;

            BEGIN
               -- DEL 비용
               SELECT stnd_cost_usd_amt
                 INTO v_estm_del_uc_amt
                 FROM coa_otr_comm
                WHERE cost_yrmon = in_cost_yrmon
                  AND cntr_tpsz_cd = 'TEU'
                  AND comm_loc_cd = coa_get_finc_loc_cd_fnc(para_cost_list.del_cd, 'AGT')
                  AND coa_cost_src_cd = para_cost_list.coa_cost_src_cd;

               v_err_msg := ' DEL=' || v_estm_del_uc_amt;
            EXCEPTION
               WHEN NO_DATA_FOUND
               THEN
                  v_estm_del_uc_amt := 0;
            END;

            IF (SUBSTR(para_cost_list.cntr_tpsz_cd, -1) > '2')
            THEN
               -- D2 보다 크면 2배를 넣는다.
               v_estm_por_uc_amt := v_estm_por_uc_amt * 2;
               v_estm_del_uc_amt := v_estm_del_uc_amt * 2;
            END IF;

            UPDATE coa_com_cost_para
               SET estm_uc_amt = NVL(v_estm_por_uc_amt, 0) + NVL(v_estm_del_uc_amt, 0)
                  ,respb_uc_amt = NVL(v_estm_por_uc_amt, 0) + NVL(v_estm_del_uc_amt, 0)
                  ,locl_curr_cd = 'USD'
                  ,cost_cate_cd = 'E'
                  ,cre_usr_id = 'SYS_COA_PKG'
                  ,cre_dt = SYSDATE
                  ,cost_calc_rmk = 'AGT OTH'
             WHERE pctl_no = para_cost_list.pctl_no
               AND cost_act_grp_seq = para_cost_list.cost_act_grp_seq
               AND cntr_tpsz_cd = para_cost_list.cntr_tpsz_cd
               AND coa_cost_src_cd = para_cost_list.coa_cost_src_cd;
--            v_err_msg := v_err_msg + SQL%ROWCOUNT;
         END LOOP;

--         enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'AGT OTH Result : ' || v_err_msg, in_appl_info);
      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      RETURN v_err_msg;
   END;

/************************************************************************************************************
 * para_slt_inter_prc
 * -- Slot Internal Pricing Cost
 ***********************************************************************************************************/
   FUNCTION para_slt_inter_prc(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2
   IS
      CURSOR para_cost_cursor
      IS

         SELECT   
                a2.pctl_no
               ,a2.cost_act_grp_seq
               ,a2.cntr_tpsz_cd
               ,a2.vsl_slan_cd
               ,coa_ut_tpsz_fnc(a2.cost_ut_amt_cd, a2.cntr_tpsz_cd) cntr_tpsz_cd_2
               ,substr(a2.n1st_nod_cd, 1,2) fm_cnt_cd
               ,substr(a2.n2nd_nod_cd, 1,2) to_cnt_cd
               ,substr(a2.n1st_nod_cd, 1,5) fm_port_cd
               ,substr(a2.n2nd_nod_cd, 1,5) to_port_cd
               ,DECODE(dg_spcl_flg,'Y','DG',DECODE(rf_spcl_flg,'Y','RF',DECODE(spcl_awk_cgo_flg,'Y','AW',DECODE(bb_spcl_flg,'Y','BB','GC')))) cargo_type
               ,a1.dg_spcl_flg
               ,a1.rf_spcl_flg
               ,a1.spcl_awk_cgo_flg
               ,a1.bb_spcl_flg
               ,a2.coa_cost_src_cd
               ,a2.stnd_cost_cd
               ,CASE
                WHEN a2.vsl_slan_cd = SUBSTR(a1.n1st_rlane_cd,1,3)  AND substr(a2.N1ST_NOD_CD,1,5) = a1.POL_CD   and substr(a2.N2ND_NOD_CD,1,5) = a1.N1ST_TS_PORT_CD
                THEN a1.n1st_trd_cd
                WHEN a2.vsl_slan_cd = SUBSTR(a1.n2nd_rlane_cd,1,3)  AND substr(a2.N1ST_NOD_CD,1,5) = a1.N1ST_TS_PORT_CD   and substr(a2.N2ND_NOD_CD,1,5) = a1.N2ND_TS_PORT_CD
                THEN a1.n2nd_trd_cd
                WHEN a2.vsl_slan_cd = SUBSTR(a1.n3rd_rlane_cd,1,3)  AND substr(a2.N1ST_NOD_CD,1,5) = a1.N2ND_TS_PORT_CD   and substr(a2.N2ND_NOD_CD,1,5) = a1.N3RD_TS_PORT_CD
                THEN a1.n3rd_trd_cd 
                ELSE a1.n4th_trd_cd
                END trd_cd               
           FROM coa_com_para a1, coa_com_cost_para a2
          WHERE a1.pctl_no = a2.pctl_no
            AND NVL(a1.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')
            AND a2.pctl_no BETWEEN in_start_pctl_no AND in_end_pctl_no
            AND a2.cost_ass_bse_cd = 'A'
            AND a2.cost_src_sys_cd = 'COA'
            AND a2.stnd_cost_cd IN('54600001');

      ------------------------------[ 변수선언부             ]-----------------------
      v_err_msg       NUMBER                               := 0;
      v_estm_uc_amt   coa_com_cost_para.estm_uc_amt%TYPE;
      v_rmk           VARCHAR2(100);   
      
   BEGIN
      BEGIN
         

         enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'para_slt_inter_prc : start' , in_appl_info);
         
         FOR para_cost_list IN para_cost_cursor
         LOOP
            BEGIN
                  -- Rank :  1. Cargo : Port to Port 2. Port to Country 3. Country to Port 4. Country to Country
                  --         5. GC Cargo : Port to Port 6. Port to Country 7. Country to Port 8. Country to Country


                  enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'pctl_no:'||para_cost_list.pctl_no||','||
                              'cost_act_grp_seq:'||para_cost_list.cost_act_grp_seq||','||          
                              'cntr_tpsz_cd:'||para_cost_list.cntr_tpsz_cd||','||                                        
                              'coa_cost_src_cd:'||para_cost_list.coa_cost_src_cd||','||                                                                      
                              'trd_cd:'||para_cost_list.trd_cd||','||                              
                              'vsl_slan_cd:'||para_cost_list.vsl_slan_cd||','||
                              'fm_port_cd:'||para_cost_list.fm_port_cd||','||
                              'to_port_cd:'||para_cost_list.to_port_cd||','||                              
                              'cargo_type:'||para_cost_list.cargo_type||','                                                                                                                                                               
                  
                  , in_appl_info);                  


                  SELECT uc_amt,
                         'Priority: '||rank_no||'>'||rank_rmk
                  INTO v_estm_uc_amt ,
                       v_rmk
                  FROM (
                      SELECT CASE WHEN  cgo_tp_cd = para_cost_list.cargo_type AND fm_port_cd <> 'X' AND to_port_cd <> 'X' THEN 1
                                  WHEN  cgo_tp_cd = para_cost_list.cargo_type AND fm_port_cd <> 'X' AND to_port_cd  = 'X' THEN 2
                                  WHEN  cgo_tp_cd = para_cost_list.cargo_type AND fm_port_cd  = 'X' AND to_port_cd <> 'X' THEN 3
                                  WHEN  cgo_tp_cd = para_cost_list.cargo_type AND fm_port_cd  = 'X' AND to_port_cd  = 'X' THEN 4
                                  
                                  WHEN  cgo_tp_cd = 'GC' AND fm_port_cd <> 'X' AND to_port_cd <> 'X' THEN 5
                                  WHEN  cgo_tp_cd = 'GC' AND fm_port_cd <> 'X' AND to_port_cd  = 'X' THEN 6
                                  WHEN  cgo_tp_cd = 'GC' AND fm_port_cd  = 'X' AND to_port_cd <> 'X' THEN 7
                                  WHEN  cgo_tp_cd = 'GC' AND fm_port_cd  = 'X' AND to_port_cd  = 'X' THEN 8                              
                              END  rank_no, 
                              cgo_tp_cd||' >'||DECODE(fm_port_cd,'X',fm_cnt_cd,fm_port_cd)||' - '||DECODE(to_port_cd,'X',to_cnt_cd,to_port_cd) rank_rmk,
                              fm_port_cd, 
                              to_port_cd,
                              DECODE( SUBSTR(para_cost_list.cntr_tpsz_cd_2, -1),'2', cntr_20ft_rt_amt,'7', cntr_45ft_rt_amt, '5',cntr_hc_rt_amt,cntr_40ft_rt_amt) uc_amt
                         FROM coa_slt_inter_prc_ut_cost
                        WHERE in_cost_yrmon  BETWEEN  eff_fm_yrmon
                                                 AND  eff_to_yrmon
                          AND delt_flg    = 'N'
                          AND slan_cd     = para_cost_list.vsl_slan_cd
                          AND trd_cd      = para_cost_list.trd_cd
                          AND sub_trd_cd  = sub_trd_cd --@@@ 수정
                          AND fm_cnt_cd   = para_cost_list.fm_cnt_cd
                          AND to_cnt_cd   = para_cost_list.to_cnt_cd
                          AND fm_port_cd  IN ('X',para_cost_list.fm_port_cd)
                          AND to_port_cd  IN ('X',para_cost_list.to_port_cd)
                          AND cgo_tp_cd   IN ('GC',para_cost_list.cargo_type)
                          ORDER BY rank_no asc, rt_seq desc 
                    )
                    WHERE ROWNUM = 1 
                 ;
                 

            EXCEPTION
               WHEN NO_DATA_FOUND
               THEN
                  v_estm_uc_amt := 0;
                  v_rmk := 'Data not found';
                WHEN OTHERS
                THEN
                  v_estm_uc_amt := NULL;
                  v_err_msg := -1;
                  RAISE;
            END;
            
            UPDATE coa_com_cost_para
               SET estm_uc_amt = v_estm_uc_amt
                  ,respb_uc_amt = v_estm_uc_amt
                  ,locl_curr_cd = 'USD'
                  ,cost_cate_cd = 'E'
--                  ,cost_ass_bse_cd = 'A'
            ,      cre_usr_id = 'SYS_COA_PKG'
                  ,cre_dt = SYSDATE
                  ,cost_calc_rmk =v_rmk
             WHERE pctl_no = para_cost_list.pctl_no
               AND cost_act_grp_seq = para_cost_list.cost_act_grp_seq
               AND cntr_tpsz_cd = para_cost_list.cntr_tpsz_cd
               AND coa_cost_src_cd = para_cost_list.coa_cost_src_cd;

         END LOOP;
        
         enis_log_prc(SYSDATE, 'coa_cost_para_assign_pkg', 'para_slt_inter_prc : end' , in_appl_info);          
         

      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      RETURN v_err_msg;
   END;  

/************************************************************************************************************
 * para_so_cancel
 ***********************************************************************************************************/
   FUNCTION para_so_cancel(in_bkg_no IN VARCHAR2, in_appl_info IN VARCHAR2)
      RETURN VARCHAR2
   IS

      ------------------------------[ 변수선언부             ]-----------------------
      v_err_msg    NUMBER                       := 0;
      BEGIN
      
--      enis_log_prc (SYSDATE, 'coa_cost_para_assign_pkg', 'in_bkg_no: ' || in_bkg_no, in_appl_info);
       -- SO Cancel은 컨테이너 별루 이루어지기 때문에
       -- Cntr가 모두 SO Cancel난경우만 비용 0처리 한다.
       BEGIN
      UPDATE coa_com_cost_para
          SET estm_uc_amt = 0
             ,respb_uc_amt = 0
             ,estm_usd_uc_amt = 0
             ,respb_usd_uc_amt = 0
             ,estm_usd_ttl_amt = 0
             ,respb_usd_ttl_amt = 0
             ,ctrt_rtn_flg = 'X'
             ,cost_calc_rmk = cost_calc_rmk || '->SO Cancel 0'
        WHERE (pctl_no, cost_act_grp_seq, cntr_tpsz_cd) IN(
                -- P상태가 BKG신규생성시 또는 SO Cancel시에 들어 올수 있어서 SCE에 문의하여 쿼리 변경[2010.02.19]
                 SELECT DISTINCT b2.pctl_no
                                ,b3.cost_act_grp_seq
                                ,b2.cntr_tpsz_cd
--                              ,b3.so_cancel_cnt
--                              ,b2.cntr_qty
--                              ,b1.cost_rout_no
                 FROM            coa_com_para b1
                                ,coa_com_cost_para b2
                                ,(
                              SELECT   a1.bkg_no
                                      ,a1.cntr_tpsz_cd
                                      ,a3.cost_rout_no
                                      ,a2.cost_act_grp_seq
                                      ,COUNT(distinct a1.cop_no) so_cancel_cnt
                                  FROM sce_cop_hdr a1, SCE_PLN_SO_LIST a2, coa_com_para a3
                                 WHERE a1.bkg_no = in_bkg_no   --'KORY6015212' --이부분 수정하였으므로 SO Cancel된 BKG 반드시 테스트 할것
                                   AND a1.cop_no = a2.cop_no
                                   AND a1.bkg_no = a3.bkg_no
                                   AND a1.pctl_no = a3.org_pctl_no
                                   -- 2010.02.25 변경
                                   AND a2.trsp_so_sts_cd in ('N', 'D')
--                                   AND a2.trsp_so_sts_cd = 'P'
                              GROUP BY a1.bkg_no
                                      ,a1.cntr_tpsz_cd
                                      ,a3.cost_rout_no
                                      ,a2.cost_act_grp_seq
                                 ) b3
                           WHERE b1.bkg_no       = b3.bkg_no
                             AND b1.pctl_no      = b2.pctl_no
                             AND b1.cost_rout_no = b3.cost_rout_no
                             AND b2.cntr_tpsz_cd = b3.cntr_tpsz_cd
                             AND b2.cost_act_grp_seq = b3.cost_act_grp_seq
                             -- 특정 A/G 구간의 S/O 가 cancel 인 경우 중
                             -- CNTR QTY 만큼의 COP가 모두 cancel 된 경우만 비용 삭제
                             --ex) CNTR QTY가 2개이나 특정 A/G 의 1개의 COP만 cancel 된 경우 비용 삭제 하지 않음
                             AND b3.so_cancel_cnt = b2.cntr_qty                           
                             AND b2.cost_asgn_calc_flg NOT IN ( 'Y' )                            
                     );

      --enis_log_prc (SYSDATE, 'coa_cost_para_assign_pkg', 'PA 에 단가 : ' || SQL%ROWCOUNT);
      EXCEPTION
         WHEN OTHERS
         THEN
            v_err_msg := -1;
            RAISE;
      END;

      RETURN v_err_msg;
   END;   
/*=====================================================================================================================*/
END coa_cost_para_assign_pkg;