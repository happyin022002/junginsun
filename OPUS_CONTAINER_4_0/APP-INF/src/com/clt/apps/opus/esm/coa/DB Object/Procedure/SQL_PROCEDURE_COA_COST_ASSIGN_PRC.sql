CREATE OR REPLACE PROCEDURE OPUSADM.COA_COST_ASSIGN_PRC (
   RESULT            OUT      NUMBER
  ,in_start_prd_no   IN       VARCHAR2
  ,in_end_prd_no     IN       VARCHAR2
  ,in_usr_id         IN       VARCHAR2
  ,in_cost_yrmon     IN       VARCHAR2
)
Authid current_user
IS
/***************************************************************************************
   Name         :   COA_COST_ASSIGN
   Purpose      :   PRD의 테이블로부터 coa_com_qty_para,coa_com_cost_para,coa_com_para만들기
   Source       :   prd_prod_ctl_mst,rd_prod_ctl_act_grp_dtl,prd_prod_ctl_qty
   Target       :   COA_RGST_BKG
***************************************************************************************/
   CURSOR spcl_del_cursor(in_start_prd_no VARCHAR2, in_end_prd_no VARCHAR2)
   IS         
           
        SELECT pctl_no , cntr_tpsz_cd, coa_cost_src_cd
        FROM (
        SELECT DISTINCT a1.pctl_no
                       ,a2.cntr_tpsz_cd
                       ,DECODE(a3.spcl_cgo_dg_flg || NVL(a1.dg_spcl_flg, 'N') || 'Y', 'YYY', 'N', 'Y') dg
                       ,DECODE(a3.spcl_cgo_bb_flg || NVL(a1.bb_spcl_flg, 'N') || NVL(a4.spcl_cgo_flg, 'N'), 'YYY', 'N', 'Y') bb
                       ,DECODE(a3.spcl_cgo_rf_flg || NVL(a1.rf_spcl_flg, 'N') || DECODE(SUBSTR(a2.cntr_tpsz_cd, 1, 1), 'R', 'Y', 'N'), 'YYY', 'N', 'Y') rf
                       ,DECODE(a3.spcl_cgo_awk_flg || NVL(a1.spcl_awk_cgo_flg, 'N') || NVL(a4.spcl_cgo_flg, 'N'), 'YYY', 'N', 'Y') ak
                       ,a2.coa_cost_src_cd
                   FROM coa_com_para a1, coa_com_cost_para a2, coa_cost_src_acct a3, coa_spcl_repo_cntr_rgst a4
                  WHERE 1=1
                    AND a1.pctl_no >= in_start_prd_no
                    AND a1.pctl_no <= in_end_prd_no
                    AND a1.pctl_no = a2.pctl_no
                    AND a2.coa_cost_src_cd = a3.coa_cost_src_cd
                    AND a2.cntr_tpsz_cd  = a4.cntr_tpsz_cd
                    AND (   NVL(a1.dg_spcl_flg, 'N') = 'N'
                         OR NVL(a1.bb_spcl_flg, 'N') = 'N'
                         OR NVL(a1.rf_spcl_flg, 'N') = 'N'
                         OR NVL(a1.spcl_awk_cgo_flg, 'N') = 'N'
                        )
                    AND (   a3.spcl_cgo_dg_flg = 'Y'
                         OR a3.spcl_cgo_bb_flg = 'Y'
                         OR a3.spcl_cgo_rf_flg = 'Y'
                         OR a3.spcl_cgo_awk_flg = 'Y'))    
             WHERE (dg = 'Y' AND bb = 'Y' AND rf = 'Y' AND ak = 'Y') ;
     
   v_return   NUMBER;
   v_appl_info VARCHAR2(30);
 
BEGIN
  v_appl_info := in_start_prd_no || ',' || SUBSTR(in_end_prd_no, -3); 
  
  enis_log_prc(SYSDATE
               ,'coa_cost_assign_prc'
               , 'Input Parameter (' || in_start_prd_no || ',' || in_end_prd_no || ' ' || in_usr_id || '), ' || 'V.20081111'
               ,v_appl_info);

--   DELETE FROM coa_com_tml_prc_cost
--         WHERE pctl_no >= in_start_prd_no
--           AND pctl_no <= in_end_prd_no;

   --enis_log_prc (SYSDATE, 'coa_cost_assign_prc', SQL%ROWCOUNT
--                         || ' PRC Deleted, '
--                         || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss')
--                        ,v_appl_info);
   DELETE FROM coa_com_qty_para
         WHERE pctl_no >= in_start_prd_no
           AND pctl_no <= in_end_prd_no;

   --enis_log_prc (SYSDATE, 'coa_cost_assign_prc', SQL%ROWCOUNT
--                         || ' QTY Deleted, '
--                         || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss')
--                        ,v_appl_info);
--   DELETE FROM coa_com_svc_trns_prc_para
--         WHERE pctl_no >= in_start_prd_no
--           AND pctl_no <= in_end_prd_no;

   --enis_log_prc (SYSDATE, 'coa_cost_assign_prc', SQL%ROWCOUNT
--                         || ' COA_COM_SVC_TRNS_PRC_PARA Deleted, '
--                         || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss')
--                        ,v_appl_info);
   DELETE FROM coa_com_cost_para
         WHERE pctl_no >= in_start_prd_no
           AND pctl_no <= in_end_prd_no;

   --enis_log_prc (SYSDATE, 'coa_cost_assign_prc', SQL%ROWCOUNT
--                         || ' CST Deleted, '
--                         || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss')
--                        ,v_appl_info);
   DELETE FROM coa_com_para
         WHERE pctl_no >= in_start_prd_no
           AND pctl_no <= in_end_prd_no;

   --enis_log_prc (SYSDATE, 'coa_cost_assign_prc', SQL%ROWCOUNT
--                         || ' COM Deleted, '
--                         || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss')
--                        ,v_appl_info);

   /************************************************************************************************************
 * PRD Master Copy해 놓기
 ************************************************************************************************************/
   INSERT INTO coa_com_para
               (pctl_no
               ,mty_pkup_yd_cd
               ,por_cd
               ,por_nod_cd
               ,pol_cd
               ,n1st_ts_port_cd
               ,n2nd_ts_port_cd
               ,n3rd_ts_port_cd
               ,pod_cd
               ,del_cd
               ,del_nod_cd
               ,mty_rtn_yd_cd
               ,ttl_tztm_hrs
               ,ttl_expn_amt
               ,trnk_aval_spc
               ,ob_itchg_ctnt
               ,ib_itchg_ctnt
               ,trnk_vsl_cd
               ,trnk_skd_voy_no
               ,trnk_skd_dir_cd
               ,cnst_flg
               ,bkg_cgo_tp_cd
               ,bkg_rcv_term_cd
               ,bkg_de_term_cd
               ,rep_cmdt_cd
               ,cmdt_cd
               ,shpr_cnt_cd
               ,shpr_seq
               ,cnee_cnt_cd
               ,cnee_seq
               ,sc_no
               ,rfa_no
               ,dg_clss_cd
               ,dg_spcl_flg
               ,rf_spcl_flg
               ,spcl_awk_cgo_flg
               ,bb_spcl_flg
               ,rd_spcl_flg
               ,hngr_spcl_flg
               ,soc_flg
               ,eq_subst_flg
               ,bkg_wgt
               ,bkg_wgt_ut_cd
               ,sls_ofc_cd
               ,bkg_ofc_cd
               ,cre_usr_id
               ,cre_dt
               ,upd_usr_id
               ,upd_dt
               )
      SELECT pctl_no
            ,mty_pkup_yd_cd
            ,por_cd
            ,por_nod_cd
            ,pol_cd
            ,n1st_ts_port_cd
            ,n2nd_ts_port_cd
            ,n3rd_ts_port_cd
            ,pod_cd
            ,del_cd
            ,del_nod_cd
            ,mty_rtn_yd_cd
            ,ttl_tztm_hrs
            ,ttl_expn_amt
            ,trnk_aval_spc
            ,ob_itchg_ctnt
            ,ib_itchg_ctnt
            ,trnk_vsl_cd
            ,trnk_skd_voy_no
            ,trnk_skd_dir_cd
            ,cnst_flg
            ,bkg_cgo_tp_cd
            ,bkg_rcv_term_cd
            ,bkg_de_term_cd
            ,rep_cmdt_cd
            ,cmdt_cd
            ,shpr_cnt_cd
            ,shpr_seq
            ,cnee_cnt_cd
            ,cnee_seq
            ,sc_no
            ,rfa_no
            ,dg_clss_cd
            ,DECODE(dg_spcl_flg, '0', 'N', 'N', 'N', NULL, 'N', 'Y')
            ,DECODE(rf_spcl_flg, '0', 'N', 'N', 'N', NULL, 'N', 'Y')
            ,DECODE(spcl_awk_cgo_flg, '0', 'N', 'N', 'N', NULL, 'N', 'Y')
            ,DECODE(bb_spcl_flg, '0', 'N', 'N', 'N', NULL, 'N', 'Y')
            ,DECODE(rd_spcl_flg, '0', 'N', 'N', 'N', NULL, 'N', 'Y')
            ,NVL(hngr_spcl_flg, 'N')
            ,DECODE(soc_flg, '0', 'N', 'N', 'N', NULL, 'N', 'Y')
            ,NVL(eq_subst_flg, 'N')
            ,bkg_wgt
            ,bkg_wgt_ut_cd
            ,sls_ofc_cd
            ,bkg_ofc_cd
            ,in_usr_id
            ,SYSDATE
            ,in_usr_id
            ,SYSDATE
        FROM prd_prod_ctl_mst
       WHERE pctl_no >= in_start_prd_no
         AND pctl_no <= in_end_prd_no;

   enis_log_prc (SYSDATE, 'coa_cost_assign_prc', SQL%ROWCOUNT
                         || ' COM Inserted, '
                         || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss')
                        ,v_appl_info);

/************************************************************************************************************
 * PRD DTL의 Lane Trade,Dirtection UPdate
   Ticket ID : CHM-201007421-01 쿼리 변경 - Lane Trade,Dirtection
 ************************************************************************************************************/
   MERGE INTO coa_com_para b1
      USING (
            SELECT  pctl_no
                   ,n1st_trd_cd
                   ,n2nd_trd_cd
                   ,n3rd_trd_cd
                   ,n4th_trd_cd
                   ,n1st_rlane_cd
                   ,n2nd_rlane_cd
                   ,n3rd_rlane_cd
                   ,n4th_rlane_cd
                   ,n1st_finc_vvd_cd
                   ,n2nd_finc_vvd_cd
                   ,n3rd_finc_vvd_cd
                   ,n4th_finc_vvd_cd
                   ,coa_rank_info_fnc(n1st_rlane_cd
                                     ,n2nd_rlane_cd
                                     ,n3rd_rlane_cd
                                     ,n4th_rlane_cd
                                     ,DECODE(n1st_ioc_cd, 'I', 'I' || pod_conti1, 'OO')
                                     ,DECODE(n2nd_ioc_cd, 'I', 'I' || pod_conti2, 'OO')
                                     ,DECODE(n3rd_ioc_cd, 'I', 'I' || pod_conti3, 'OO')
                                     ,DECODE(n4th_ioc_cd, 'I', 'I' || pod_conti4, 'OO')) v_ranking
            FROM (
            --------------------------------------------------------------------------------------                         
                      SELECT pctl_no
                           ,MAX(DECODE(row_num, 1, b1.trd_cd, NULL)) AS n1st_trd_cd
                           ,MAX(DECODE(row_num, 2, b1.trd_cd, NULL)) AS n2nd_trd_cd
                           ,MAX(DECODE(row_num, 3, b1.trd_cd, NULL)) AS n3rd_trd_cd
                           ,MAX(DECODE(row_num, 4, b1.trd_cd, NULL)) AS n4th_trd_cd
                           ,MAX(DECODE(row_num, 1, b1.rlane_cd, NULL)) AS n1st_rlane_cd
                           ,MAX(DECODE(row_num, 2, b1.rlane_cd, NULL)) AS n2nd_rlane_cd
                           ,MAX(DECODE(row_num, 3, b1.rlane_cd, NULL)) AS n3rd_rlane_cd
                           ,MAX(DECODE(row_num, 4, b1.rlane_cd, NULL)) AS n4th_rlane_cd
                           ,MAX(DECODE(row_num, 1, b1.ioc_cd, NULL)) AS n1st_ioc_cd
                           ,MAX(DECODE(row_num, 2, b1.ioc_cd, NULL)) AS n2nd_ioc_cd
                           ,MAX(DECODE(row_num, 3, b1.ioc_cd, NULL)) AS n3rd_ioc_cd
                           ,MAX(DECODE(row_num, 4, b1.ioc_cd, NULL)) AS n4th_ioc_cd
                           ,MAX(DECODE(row_num, 1, b1.pod_conti_cd, NULL)) AS pod_conti1
                           ,MAX(DECODE(row_num, 2, b1.pod_conti_cd, NULL)) AS pod_conti2
                           ,MAX(DECODE(row_num, 3, b1.pod_conti_cd, NULL)) AS pod_conti3
                           ,MAX(DECODE(row_num, 4, b1.pod_conti_cd, NULL)) AS pod_conti4
                           ,MAX(DECODE(row_num, 1, b1.vvd, NULL)) AS n1st_finc_vvd_cd
                           ,MAX(DECODE(row_num, 2, b1.vvd, NULL)) AS n2nd_finc_vvd_cd
                           ,MAX(DECODE(row_num, 3, b1.vvd, NULL)) AS n3rd_finc_vvd_cd
                           ,MAX(DECODE(row_num, 4, b1.vvd, NULL)) AS n4th_finc_vvd_cd
                       FROM (SELECT /*+USE_NL(a1 a2) index_asc(dtl XPKPRD_PROD_CTL_ROUT_DTL) */
--                                    ROWNUM AS row_num
                                    row_number()over(partition by a1.pctl_no order by a1.pctl_no) row_num
                                   ,a1.pctl_no
                                   ,a2.trd_cd
                                   ,a2.rlane_cd
                                   ,a1.vsl_slan_cd
                                   , a1.vsl_cd || a1.skd_voy_no || a1.skd_dir_cd AS vvd
                                   ,a3.conti_cd AS pol_conti_cd
                                   ,a4.conti_cd AS pod_conti_cd
                                   ,DECODE(a3.conti_cd, a4.conti_cd, 'I', 'O') AS ioc_cd
                               FROM prd_prod_ctl_rout_dtl a1, coa_rev_lane_v a2, mdm_location a3, mdm_location a4
                              WHERE a1.vsl_slan_cd = a2.slan_cd
                                AND a1.skd_dir_cd = a2.dir_cd
                                AND SUBSTR(a1.org_nod_cd, 1, 5) = a3.loc_cd
                                AND SUBSTR(a1.dest_nod_cd, 1, 5) = a4.loc_cd
                                AND a3.conti_cd = a2.fm_conti_cd
                                AND a4.conti_cd = a2.to_conti_cd
                                AND a1.trsp_mod_cd IN('WD', 'VD')
                                AND pctl_no BETWEEN in_start_prd_no AND in_end_prd_no
                               -- AND ROWNUM < 5
                                )b1
                       group by pctl_no
                       ) c1         
                )  b2          
      ON (b1.pctl_no = b2.pctl_no)
      WHEN MATCHED THEN
         UPDATE
            SET b1.n1st_finc_vvd_cd = b2.n1st_finc_vvd_cd, b1.n1st_rlane_cd = b2.n1st_rlane_cd, b1.n1st_trd_cd = b2.n1st_trd_cd
               ,b1.n2nd_finc_vvd_cd = b2.n2nd_finc_vvd_cd, b1.n2nd_rlane_cd = b2.n2nd_rlane_cd, b1.n2nd_trd_cd = b2.n2nd_trd_cd
               ,b1.n3rd_finc_vvd_cd = b2.n3rd_finc_vvd_cd, b1.n3rd_rlane_cd = b2.n3rd_rlane_cd, b1.n3rd_trd_cd = b2.n3rd_trd_cd
               ,b1.n4th_finc_vvd_cd = b2.n4th_finc_vvd_cd, b1.n4th_rlane_cd = b2.n4th_rlane_cd, b1.n4th_trd_cd = b2.n4th_trd_cd
               ,b1.cost_rout_no = b2.v_ranking
         ;

   --enis_log_prc (SYSDATE, 'coa_cost_assign_prc', SQL%ROWCOUNT
--                         || ' PRD DTL Update, '
--                         || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss')
--                        ,v_appl_info);
   INSERT INTO coa_com_cost_para
               (pctl_no
               ,cost_act_grp_seq
               ,cntr_tpsz_cd
               ,coa_cost_src_cd
               ,stnd_cost_cd
               ,cost_ut_amt_cd
               ,cost_src_sys_cd
               ,cost_ass_bse_cd
               ,cost_act_grp_cd
               ,cost_act_grp_tp_cd
               ,vsl_slan_cd
               ,ctrl_ofc_cd
               ,cost_ofc_cd
               ,cost_io_bnd_cd
               ,n1st_nod_cd
               ,n1st_nod_tp_cd
               ,n1st_estm_dt
               ,n2nd_nod_cd
               ,n3rd_nod_cd
               ,n4th_nod_cd
               ,rout_tz_mod_cd
               ,n1st_pol_pod_dist
               ,n1st_dist_ut_cd
               ,n2nd_pol_pod_dist
               ,n2nd_dist_ut_cd
               ,n3rd_pol_pod_dist
               ,n3rd_dist_ut_cd
               ,n1st_vndr_seq
               ,n2nd_vndr_seq
               ,n3rd_vndr_seq
               ,n4th_vndr_seq
--               ,cust_nomi_trkr_flg PRD 200909월말 변경된거 같음
               ,pre_nod_cd
               ,pst_nod_cd
               ,pre_lnk_vndr_seq
               ,pst_lnk_vndr_seq
               ,fcgo_tz_dys
               ,fcgo_tz_hrs
               ,mcgo_tz_dys
               ,mcgo_tz_hrs
               ,cntr_qty
               ,cost_cate_cd
               ,estm_uc_amt
               ,respb_uc_amt
               ,locl_curr_cd
               ,trsp_svc_ofc_cd
               ,cost_asgn_calc_flg
               ,cre_usr_id
               ,cre_dt
               ,lgs_cost_cd_chk_flg
               ,thrp_rt_flg
               ,act_grp_tml_flg
               ,lgs_cost_auto_cd_flg
               ,ioc_cd
               ,ctrt_rtn_flg
               ,scc_cd
               ,ecc_cd
               ,para_fm_scc_cd
               ,para_to_scc_cd
               ,para_fm_ecc_cd
               ,para_to_ecc_cd
               ,n1st_rail_crr_tp_cd
               ,n2nd_rail_crr_tp_cd
               ,n3rd_rail_crr_tp_cd
               ,BFR_TRSP_MOD_CD  -- 2010.07.21 PRE_COST_ACT_GRP_CD  -> BFR_TRSP_MOD_CD
               ,AFT_TRSP_MOD_CD  -- 2010.07.21 PST_COST_ACT_GRP_CD  -> AFT_TRSP_MOD_CD
                ,inlnd_rout_incl_sttl_flg
                ,n1st_trsp_agmt_seq
                ,n2nd_trsp_agmt_seq
                ,n3rd_trsp_agmt_seq
                ,n1st_trsp_agmt_ofc_cty_cd
                ,n1st_agmt_ref_no
                ,n2nd_trsp_agmt_ofc_cty_cd
                ,n2nd_agmt_ref_no
                ,n3rd_trsp_agmt_ofc_cty_cd
                ,n3rd_agmt_ref_no
                ,upd_usr_id
                ,upd_dt
               )
      (SELECT a.pctl_no
             ,a.cost_act_grp_seq
             ,d.cntr_tpsz_cd
             ,c.coa_cost_src_cd
             ,c.stnd_cost_cd
             ,c.cost_ut_amt_cd
             ,c.cost_src_sys_cd
             ,c.cost_ass_bse_cd
             ,a.cost_act_grp_cd
             ,a.cost_act_grp_tp_cd
             ,a.vsl_slan_cd
             ,a.ctrl_ofc_cd
             ,'' cost_ofc_cd
             ,a.pctl_io_bnd_cd
             ,a.n1st_nod_cd
             ,a.n1st_nod_tp_cd
             ,a.n1st_nod_pln_dt
             ,a.n2nd_nod_cd
             ,a.n3rd_nod_cd
             ,a.n4th_nod_cd
             ,a.trsp_mod_cd
             ,a.n1st_lnk_dist
             ,a.n1st_lnk_dist_ut_cd
             ,a.n2nd_lnk_dist
             ,a.n2nd_lnk_dist_ut_cd
             ,a.n3rd_lnk_dist
             ,a.n3rd_dist_ut_cd
             ,a.n1st_vndr_seq
             ,a.n2nd_vndr_seq
             ,a.n3rd_vndr_seq
             ,'' n4th_vndr_seq
--             ,a.cust_nomi_trkr_flg PRD 200909월말 변경된거 같음
             ,a.pre_nod_cd
             ,a.nxt_nod_cd
             ,a.pre_vndr_seq
             ,a.nxt_vndr_seq
             ,(SELECT --d.ttl_tztm_hrs / 24
                case when 60 > d.ttl_tztm_hrs/24 
                then d.ttl_tztm_hrs/24
                else COA_EQ_TTL_TZTM_FNC (TO_CHAR(SYSDATE, 'YYYYMM'),por_cd,del_cd,d.cntr_tpsz_cd)
                end  
                 FROM prd_prod_ctl_mst d
                WHERE pctl_no = a.pctl_no) fcgo_tz_dys
             ,0 fcgo_tz_hrs
             ,'' mcgo_tz_dys
             ,'' mcgo_tz_hrs
             ,d.pctl_qty
             ,'9' cost_cate_cd
             ,0 estm_uc_amt
             ,0 respb_uc_amt
             ,'' locl_curr_cd
             ,'N' trsp_svc_ofc_cd
             ,'' cost_asgn_calc_flg
             ,'System'
             ,SYSDATE
             ,DECODE(c.cost_src_sys_cd
                    ,'TRS', DECODE(SUBSTR(a.n1st_nod_cd, 1, 5)
                                  ,DECODE(SUBSTR(a.n4th_nod_cd, 1, 5)
                                         ,NULL, NVL(SUBSTR(a.n3rd_nod_cd, 1, 5), SUBSTR(a.n2nd_nod_cd, 1, 5))
                                         ,SUBSTR(a.n4th_nod_cd, 1, 5)
                                         ), 'Y'
                                  ,'N'
                                  )
                    ,'Y'
                    )
             ,'N'
             ,DECODE(n1st_nod_tp_cd, 'M', 'Y', 'N')
             ,'N'
             ,(SELECT DECODE(pol.conti_cd, pod.conti_cd, 'I', 'O')
                 FROM coa_com_para b, mdm_location pol, mdm_location pod
                WHERE pol_cd = pol.loc_cd
                  AND pod_cd = pod.loc_cd
                  AND b.pctl_no = a.pctl_no) ioc_cd
             ,'N' ctrt_rtn_flg   /* AMT가 계약에 의한 제로인경우 'Y'로 치환 */
             ,v.scc_cd
             ,v.ecc_cd
             ,e_pol.scc_cd
             ,e_pod.scc_cd
             ,e_pol.ecc_cd
             ,e_pod.ecc_cd
             ,n1st_rail_crr_tp_cd
             ,n2nd_rail_crr_tp_cd
             ,n3rd_rail_crr_tp_cd
             /* PRD에서 제공된 T/T 구하기,별도의 Table인 prd_prod_ctl_rout_dtl에서
                pctl_no와 해당 ACT_GRP SEQ로 구하러간다*/
       ,      CASE
                 WHEN cost_act_grp_tp_cd = 'N'
                    THEN (SELECT trsp_mod_cd
                            FROM prd_prod_ctl_rout_dtl
                           WHERE pctl_no = a.pctl_no
                             AND pctl_seq =
                                    (SELECT pctl_seq - 1
                                       FROM prd_prod_ctl_rout_dtl
                                      WHERE (pctl_no, org_nod_cd, dest_nod_cd, cost_act_grp_seq) =
                                               (SELECT pctl_no
                                                      ,n1st_nod_cd
                                                      ,n2nd_nod_cd
                                                      ,cost_act_grp_seq
                                                  FROM prd_prod_ctl_act_grp_dtl
                                                 WHERE pctl_no = a.pctl_no
                                                   AND cost_act_grp_tp_cd = 'N'
                                                   AND cost_act_grp_seq = a.cost_act_grp_seq
                                                   AND ROWNUM = 1)
                                        AND ROWNUM = 1)
                             AND ROWNUM < 2)
              END BFR_TRSP_MOD_CD   --PRE_COST_ACT_GRP_CD  -> BFR_TRSP_MOD_CD  2010.07.21  pre_cost_act_grp_cd
             ,CASE
                 WHEN cost_act_grp_tp_cd = 'N'
                    THEN (SELECT trsp_mod_cd
                            FROM prd_prod_ctl_rout_dtl
                           WHERE pctl_no = a.pctl_no
                             AND pctl_seq =
                                    (SELECT pctl_seq + 1
                                       FROM prd_prod_ctl_rout_dtl
                                      WHERE (pctl_no, org_nod_cd, dest_nod_cd, cost_act_grp_seq) =
                                               (SELECT pctl_no
                                                      ,n1st_nod_cd
                                                      ,n2nd_nod_cd
                                                      ,cost_act_grp_seq
                                                  FROM prd_prod_ctl_act_grp_dtl
                                                 WHERE pctl_no = a.pctl_no
                                                   AND cost_act_grp_tp_cd = 'N'
                                                   AND cost_act_grp_seq = a.cost_act_grp_seq
                                                   AND ROWNUM = 1)
                                        AND ROWNUM = 1)
                             AND ROWNUM < 2)
              END AFT_TRSP_MOD_CD   --PST_COST_ACT_GRP_CD  -> AFT_TRSP_MOD_CD  2010.07.21 post_cost_act_grp_cd
                ,a.inlnd_rout_incl_sttl_flg
                ,a.n1st_trsp_agmt_seq
                ,a.n2nd_trsp_agmt_seq
                ,a.n3rd_trsp_agmt_seq
                ,a.n1st_trsp_agmt_ofc_cty_cd
                ,a.n1st_agmt_ref_no
                ,a.n2nd_trsp_agmt_ofc_cty_cd
                ,a.n2nd_agmt_ref_no
                ,a.n3rd_trsp_agmt_ofc_cty_cd
                ,a.n3rd_agmt_ref_no
            ,in_usr_id
            ,SYSDATE
         FROM prd_prod_ctl_act_grp_dtl a
             ,coa_act_grp_cost_mapg b
             ,coa_cost_src_acct c
             ,prd_prod_ctl_qty d
             ,coa_location_v v
             ,coa_location_v e_pol
             ,coa_location_v e_pod
        WHERE a.cost_act_grp_cd = b.cost_act_grp_cd
          AND b.coa_cost_src_cd = c.coa_cost_src_cd
          AND a.pctl_no = d.pctl_no
          AND b.cost_aply_flg = 'Y'
          AND NVL(c.delt_flg, 'N') = 'N'
          AND DECODE(NVL(c.cost_src_sys_cd, 'TRS')
                    ,   /* TRS의 LOC의 5자리 비교후 필요한 Cost code만 만들기*/
                     'TRS', DECODE(SUBSTR(a.n1st_nod_cd, 1, 5)
                                  ,NVL(SUBSTR(a.n4th_nod_cd, 1, 5), NVL(SUBSTR(a.n3rd_nod_cd, 1, 5), SUBSTR(a.n2nd_nod_cd, 1, 5))), 'Y'
                                  ,'N'
                                  )
                    ,'Y'
                    ) =
                 NVL(lgs_cost_cd_chk_flg
                    ,DECODE(NVL(c.cost_src_sys_cd, 'TRS')
                           ,   /* TRS의 LOC의 5자리 비교후 필요한 Cost code만 만들기*/
                            'TRS', DECODE(SUBSTR(a.n1st_nod_cd, 1, 5)
                                         ,NVL(SUBSTR(a.n4th_nod_cd, 1, 5), NVL(SUBSTR(a.n3rd_nod_cd, 1, 5), SUBSTR(a.n2nd_nod_cd, 1, 5))), 'Y'
                                         ,'N'
                                         )
                           ,'Y'
                           )
                    )
          AND b.coa_cost_src_cd NOT IN
                 (
                 --'SVWFTS',   -- WHF(wharfage) for T/S -- 2008.3.12 최요환씨 요청으로 제외 -- 2011.01.13 삭제로직추가
                  'TMNDRM'   -- TES MTY 대표 SVLDMT 만 생성 (2010.05.25 신준모씨 요청)
                 ,'SVALMT'   -- 2011.01.13 추가
                 ,'SRNDMT' 
                 ,'SRFDMT' 
                 ,'SVWFMT' 
                 ,'CGCUMT'   -- 2011.01.13 추가
                 ,'SVLDTM' 
                 ,'SVDRMT' 
                 ,'SVSSMT' 
                 ,'SVSSTM' 
                 ,'TMNDMT' 
                 ,'TMNDXM' 
                 ,'TMFDMT' 
                 ,'TMFDXM' 
                 ,'TPNDMT'   -- TES MTY 
                 ,'TPNDTM'   -- TRS MTY 대표 TRMTRT만 생성 (2010.05.25 신준모씨 요청)
                 ,'TRMTRD' 
                 ,'TRMTTD' 
                 ,'TRMTWR' 
                 ,'TRMTWT' 
                 ,'TRMTWD'   -- 2011.01.13 추가
                 ,'TRMOWD' 
                 ,'TRMORD' 
                 ,'TRMOTD' 
                 ,'TRMOWR' 
                 ,'TRMOWT' 
                 ,'TRMORT' 
                 ,'SMLWAL' 
                 ,'SMFRAL' 
                 ,'SMFUWD' 
                 ,'SMFURD' 
                 ,'SMFUTD' 
                 ,'SMFUWR' 
                 ,'SMFUWT' 
                 ,'SMFURT' 
                 ,'SMFIAL' 
                 ,'SMRCAL' 
                 ,'SMTLAL' 
                 ,'SMOTAL' 
                 ,'SMLFAL' 
                 ,'SMSRAL' 
                 ,'SMSNAL' 
                 ,'SMWTAL'   -- TRS MTY
                 --,'TRMTRT','SVLDMT' --2011.01.13 삭제
                 ,'65101951'
                 ,'65102081'
                 ,'65102151'
                 ,'65202011'
                 ,'65203011'
                 ,'65205011'
                 ,'65205012'
                 ,'65205013'
                 ,'65205014'
                 ,'65205015'
                 ,'65205016'
                 ,'65205017'
                 ,'65205018'
                 ,'65205019'
                 ,'65205020'
                 ,'65205021'
                 ,'65205022'
                 ,'65205023'
                 ,'65205024'
                 ,'65205025'
                 ,'65205026'
                 ,'65205027'
                 ,'65205028'
                 ,'65205029'
                 )
          AND SUBSTR(d.cntr_tpsz_cd, 1, 1) <> 'Q'
          AND SUBSTR(a.n1st_nod_cd, 1, 5) = v.loc_cd(+)
          AND SUBSTR(a.n1st_nod_cd, 1, 5) = e_pol.loc_cd(+)
          AND SUBSTR(DECODE(n4th_nod_cd, NULL, DECODE(n3rd_nod_cd, NULL, n2nd_nod_cd, n3rd_nod_cd), n4th_nod_cd), 1, 5) = e_pod.loc_cd(+)
          AND a.pctl_no >= in_start_prd_no
          AND a.pctl_no <= in_end_prd_no);

--   /* -- DG  */
--   DELETE FROM coa_com_cost_para
--         WHERE pctl_no IN(SELECT pctl_no
--                            FROM coa_com_para
--                           WHERE pctl_no IN(SELECT pctl_no
--                                              FROM prd_prod_ctl_mst
--                                             WHERE pctl_no >= in_start_prd_no
--                                               AND pctl_no <= in_end_prd_no)
--                             AND NVL(dg_spcl_flg, 'N') = 'N')
--           AND coa_cost_src_cd IN(SELECT coa_cost_src_cd
--                                    FROM coa_cost_src_acct
--                                   WHERE spcl_cgo_dg_flg = 'Y');

--   /*BB*/
--   DELETE FROM coa_com_cost_para
--         WHERE pctl_no IN(SELECT pctl_no
--                            FROM coa_com_para
--                           WHERE pctl_no IN(SELECT pctl_no
--                                              FROM prd_prod_ctl_mst
--                                             WHERE pctl_no >= in_start_prd_no
--                                               AND pctl_no <= in_end_prd_no)
--                             AND NVL(bb_spcl_flg, 'N') = 'N')
--           AND coa_cost_src_cd IN(SELECT coa_cost_src_cd
--                                    FROM coa_cost_src_acct
--                                   WHERE spcl_cgo_bb_flg = 'Y');

--   /* RF */
--   DELETE FROM coa_com_cost_para
--         WHERE pctl_no IN(SELECT pctl_no
--                            FROM coa_com_para
--                           WHERE pctl_no IN(SELECT pctl_no
--                                              FROM prd_prod_ctl_mst
--                                             WHERE pctl_no >= in_start_prd_no
--                                               AND pctl_no <= in_end_prd_no)
--                             AND NVL(rf_spcl_flg, 'N') = 'N')
--           AND coa_cost_src_cd IN(SELECT coa_cost_src_cd
--                                    FROM coa_cost_src_acct
--                                   WHERE spcl_cgo_rf_flg = 'Y');

--   /*AK*/
--   DELETE FROM coa_com_cost_para
--         WHERE pctl_no IN(SELECT pctl_no
--                            FROM coa_com_para
--                           WHERE pctl_no IN(SELECT pctl_no
--                                              FROM prd_prod_ctl_mst
--                                             WHERE pctl_no >= in_start_prd_no
--                                               AND pctl_no <= in_end_prd_no)
--                             AND NVL(spcl_awk_cgo_flg, 'N') = 'N')
--           AND coa_cost_src_cd IN(SELECT coa_cost_src_cd
--                                    FROM coa_cost_src_acct
--                                   WHERE spcl_cgo_awk_flg = 'Y');
                       
   FOR del_list IN spcl_del_cursor(in_start_prd_no, in_end_prd_no)
   LOOP
    DELETE FROM coa_com_cost_para
    WHERE pctl_no = del_list.pctl_no AND cntr_tpsz_cd = del_list.cntr_tpsz_cd AND coa_cost_src_cd = del_list.coa_cost_src_cd;   
   END LOOP;
   
    --enis_log_prc (SYSDATE, 'coa_cost_assign_prc', '[COA_COST_ASSIGN_PRC]++++: spcl'|| TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'), v_appl_info);

--------- DELETE BKG_CGO_TP, SOC 계정  {{ ------------------------------------------------------------------------
    -- BKG_CGO_TP
   DELETE FROM coa_com_cost_para
         WHERE pctl_no IN(SELECT pctl_no
                            FROM coa_com_para
                           WHERE pctl_no BETWEEN in_start_prd_no AND in_end_prd_no
                             AND bkg_cgo_tp_cd = 'R')
           AND coa_cost_src_cd IN(SELECT coa_cost_src_cd
                                    FROM coa_cost_src_acct
                                   WHERE bkg_rev_mcgo_flg = 'Y');

   -- SOC
   DELETE FROM coa_com_cost_para
         WHERE pctl_no IN(SELECT pctl_no
                            FROM coa_com_para
                           WHERE pctl_no BETWEEN in_start_prd_no AND in_end_prd_no
                             AND soc_flg = 'Y')
           AND coa_cost_src_cd IN(SELECT coa_cost_src_cd
                                    FROM coa_cost_src_acct
                                   WHERE bkg_full_soc_cgo_flg = 'Y');

     /* 자가 터미날인경우 기본 Node단가 계정 삭제*/
--     DELETE FROM coa_com_cost_para
--     WHERE pctl_no BETWEEN in_start_prd_no AND in_end_prd_no
--     AND  cost_act_grp_tp_cd ='N'
--     AND  cost_src_sys_cd ='TES'
--     AND  cost_act_grp_cd <> 'COMN'
--     AND  n1st_nod_cd in ('KRPUSYK','KRKANYA','KRPUSKC','KRPUSYG')
--     AND  coa_cost_src_cd NOT in ('92301011','92301021','92302051','92301051','92301041','92302031','92302011','92301031','92302021');

   --------- DELETE BKG_CGO_TP 계정  }} ------------------------------------------------------------------------

   --enis_log_prc (SYSDATE, 'coa_cost_assign_prc', SQL%ROWCOUNT
--                         || ' CST Inserted, '
--                         || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss')
--                        ,v_appl_info);
/************************************************************************************************************
*  SPC 계정적용여부 처리
           SPCL_CGO_AWK_FLG ='Y'
        or  SPCL_CGO_RF_FLG ='Y'
************************************************************************************************************/

   /************************************************************************************************************
* ROUTE 별  QTY 저장하기
************************************************************************************************************/
   INSERT INTO coa_com_qty_para
               (pctl_no
               ,cntr_tpsz_cd
               ,bkg_rev
               ,bkg_oft_rev
               ,bkg_qty
               ,estm_cm_amt
               ,estm_opfit_amt
               ,ra_opfit_amt
               ,ra_cm_amt
               ,cre_usr_id
               ,cre_dt
               ,upd_usr_id
               ,upd_dt
               )
      SELECT pctl_no
            ,cntr_tpsz_cd
            ,0 bkg_rev
            ,0 bkg_oft_rev
            ,pctl_qty
            ,0
            ,0
            ,0
            ,0
            ,in_usr_id
            ,SYSDATE
            ,in_usr_id
            ,SYSDATE
        FROM prd_prod_ctl_qty
       WHERE pctl_no >= in_start_prd_no
         AND pctl_no <= in_end_prd_no;

   --enis_log_prc (SYSDATE, 'coa_cost_assign_prc', SQL%ROWCOUNT
--                         || ' QTY Inserted, '
--                         || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss')
--                        ,v_appl_info);



   ----------------------------------------------------------------------------------------------------
-- FREE IN , OUT , TACKLE 계정 삭제
----------------------------------------------------------------------------------------------------
-- FREE IN(BKG-POL) 계정 삭제
   DELETE      coa_com_cost_para b1
         WHERE EXISTS(
                  SELECT 1
                    FROM (SELECT /*+ index(a1 XAK3COA_COM_PARA) */ 
                                 a2.pctl_no
                                ,a2.cost_act_grp_seq
                                ,a2.cntr_tpsz_cd
                                ,a2.coa_cost_src_cd
                            FROM coa_com_para a1, coa_com_cost_para a2
                           WHERE a1.pctl_no BETWEEN in_start_prd_no AND in_end_prd_no
                             AND a1.bkg_rcv_term_cd = 'I'   -- RCV
                             AND a2.cost_act_grp_cd = 'NOBT'   -- NOBT
                             AND SUBSTR(a2.coa_cost_src_cd, 1, 2) IN('TM', 'SV', 'TP', 'CG', 'SR')
                             AND a1.pctl_no = a2.pctl_no) b2
                   WHERE b1.pctl_no = b2.pctl_no
                     AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
                     AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
                     AND b1.coa_cost_src_cd = b2.coa_cost_src_cd);

-- FREE OUT(BKG-POD) 계정 삭제
   DELETE      coa_com_cost_para b1
         WHERE EXISTS(
                  SELECT 1
                    FROM (SELECT /*+ index(a1 XAK3COA_COM_PARA) */ 
                                 a2.pctl_no
                                ,a2.cost_act_grp_seq
                                ,a2.cntr_tpsz_cd
                                ,a2.coa_cost_src_cd
                            FROM coa_com_para a1, coa_com_cost_para a2
                           WHERE a1.pctl_no BETWEEN in_start_prd_no AND in_end_prd_no
                             AND a1.bkg_de_term_cd = 'O'   -- DE
                             AND a2.cost_act_grp_cd = 'NIBT'   -- NIBC
                             AND SUBSTR(a2.coa_cost_src_cd, 1, 2) IN('TM', 'SV', 'TP', 'CG', 'SR')
                             AND a1.pctl_no = a2.pctl_no) b2
                   WHERE b1.pctl_no = b2.pctl_no
                     AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
                     AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
                     AND b1.coa_cost_src_cd = b2.coa_cost_src_cd);

-- TACKLE(BKG-POL) 계정 삭제
   DELETE      coa_com_cost_para b1
         WHERE EXISTS(
                  SELECT 1
                    FROM (SELECT /*+ index(a1 XAK3COA_COM_PARA) */ a2.pctl_no
                                ,a2.cost_act_grp_seq
                                ,a2.cntr_tpsz_cd
                                ,a2.coa_cost_src_cd
                            FROM coa_com_para a1, coa_com_cost_para a2
                           WHERE a1.pctl_no BETWEEN in_start_prd_no AND in_end_prd_no
                             AND a1.bkg_rcv_term_cd = 'T'   -- RCV
                             AND a2.cost_act_grp_cd = 'NOBT'   -- NOBT
                             AND SUBSTR(a2.coa_cost_src_cd, 1, 2) = 'TM'
                             AND a1.pctl_no = a2.pctl_no) b2
                   WHERE b1.pctl_no = b2.pctl_no
                     AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
                     AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
                     AND b1.coa_cost_src_cd = b2.coa_cost_src_cd);

-- TACKLE(BKG-POD) 계정 삭제
   DELETE      coa_com_cost_para b1
         WHERE EXISTS(
                  SELECT 1
                    FROM (SELECT /*+ index(a1 XAK3COA_COM_PARA) */ a2.pctl_no
                                ,a2.cost_act_grp_seq
                                ,a2.cntr_tpsz_cd
                                ,a2.coa_cost_src_cd
                            FROM coa_com_para a1, coa_com_cost_para a2
                           WHERE a1.pctl_no BETWEEN in_start_prd_no AND in_end_prd_no
                             AND a1.bkg_de_term_cd = 'T'   -- DE
                             AND a2.cost_act_grp_cd = 'NIBC'   -- NIBC
                             AND SUBSTR(a2.coa_cost_src_cd, 1, 2) = 'TM'
                             AND a1.pctl_no = a2.pctl_no) b2
                   WHERE b1.pctl_no = b2.pctl_no
                     AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
                     AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
                     AND b1.coa_cost_src_cd = b2.coa_cost_src_cd);

   RESULT := 1;
EXCEPTION
   WHEN OTHERS
   THEN
      enis_log_prc(SYSDATE, 'COA_COST_ASSIGN_PRC', 'ERROR: ' || SQLERRM,v_appl_info);
      RESULT := -1;
END COA_COST_ASSIGN_PRC;