CREATE OR REPLACE PROCEDURE OPUSADM."COA_BKG_INFO_INST_PRC" (
   in_bkg_no         IN       VARCHAR2
  ,in_user_id        IN       VARCHAR2
  ,out_result        OUT      VARCHAR2
)
AUTHID CURRENT_USER
IS
/******************************************************************************
   Name         :   COA_RGST_BKG
   Purpose      :   Booking의 테이블로부터 COA_RGST_BKG
   Source       :   COA_BOOKING_V
   Target       :   COA_RGST_BKG
 
******************************************************************************/

--//////////////////////////////////////////////////////////////////////////////////////////////////
-- pctl_no가 여러개인경우 대표 pctl_no의 데이터만 coa_com_cost_para 에 깔아주므로
-- 반드시 두개의 테이블을 동시에 걸어준다.
--//////////////////////////////////////////////////////////////////////////////////////////////////
   CURSOR pctl_cursor(in_bkg_no VARCHAR2)
   IS
      SELECT   a2.pctl_no
              ,a1.cost_rout_no
          FROM coa_com_para a1, coa_com_cost_para a2
         WHERE a1.bkg_no = in_bkg_no
           AND a1.pctl_no = a2.pctl_no
      GROUP BY a1.bkg_no, a2.pctl_no, a1.cost_rout_no;

   v_coa_err_msg      VARCHAR(100);
   v_bkg_sts_cd       coa_rgst_bkg.bkg_sts_cd%TYPE;
   v_bzc_cost_yrmon   VARCHAR2(6);
   v_appl_info        VARCHAR2(30);
   v_qty_sum          NUMBER                            := 0;
   v_coa_step         VARCHAR(100);
   v_bkg_split_rto    BKG_BOOKING.SPLIT_RTO%TYPE;
BEGIN
   v_appl_info := in_bkg_no;
   enis_log_prc(SYSDATE, 'COA_BKG_INFO_INST_PRC', 'V.20100217', v_appl_info);
   --초기화
   out_result := 'Y';

--//////////////////////////////////////////////////////////////////////////////////////////////////
   /*
       1. coa_bkg_cost_dtl의 데이터를 delete하고 새로 생성한다.
       (cost_rout_no 관련 변경 삭제시 pk값이므로 반드시 delete 후 insert.)
       estm_upd_flg='Y', estm_tgt_flg='N'로 세팅해준다.
   */
--//////////////////////////////////////////////////////////////////////////////////////////////////

   -- delete
   DELETE FROM coa_bkg_cost_src_dtl
         WHERE 
         bkg_no = in_bkg_no;

   enis_log_prc(SYSDATE
               ,'COA_RGST_BKG_INST_PRC'
               , 'COA_BKG_COST_SRC_DTL ' || SQL%ROWCOUNT || ' delete'
               ,v_appl_info
               );

   -- insert
   INSERT INTO coa_bkg_cost_src_dtl
               (bkg_no
               ,cntr_tpsz_cd
               ,cost_act_grp_seq
               ,coa_cost_src_cd
               ,cost_rout_no
               ,cost_act_grp_cd
               ,nod_cd
               ,to_nod_cd
               ,stnd_cost_cd
               ,cost_cate_cd
               ,ra_acct_cd
               ,n1st_nod_cd
               ,cntr_qty
               ,n2nd_nod_cd
               ,n3rd_nod_cd
               ,n4th_nod_cd
               ,cost_ass_bse_cd
               ,rout_tz_mod_cd
               ,fcgo_tz_dys
               ,fcgo_tz_hrs
               ,mcgo_tz_dys
               ,mcgo_tz_hrs
               ,spcl_rc_flg
               ,spcl_dg_cgo_flg
               ,spcl_awk_cgo_flg
               ,spcl_bb_cgo_flg
               ,rd_flg
               ,soc_flg
               ,estm_upd_flg
               ,cre_usr_id
               ,cre_dt
               ,ctrl_ofc_cd
               ,rail_svc_tp_cd
               ,cost_act_grp_tp_cd
               ,vsl_slan_cd
               ,cost_io_bnd_cd
               ,n1st_nod_tp_cd
               ,n1st_vndr_seq
               ,n2nd_vndr_seq
               ,n3rd_vndr_seq
               ,n4th_vndr_seq
               ,cust_nomi_trkr_flg
               ,trsp_svc_ofc_cd
               ,lgs_cost_cd_chk_flg
               ,thrp_rt_flg
               ,act_grp_tml_flg
               ,aply_vndr_seq
               ,locl_curr_cd
               ,estm_usd_ttl_amt
               ,respb_usd_ttl_amt
               ,estm_tgt_flg
               ,estm_usd_uc_amt
               ,respb_usd_uc_amt
               ,ctrt_rtn_flg
               ,wtr_rcv_term_cd
               ,wtr_de_term_cd
               ,cost_calc_rmk
               ,delt_flg
               ,bfr_trsp_mod_cd   -- 2010.07.21 PRE_COST_ACT_GRP_CD  -> BFR_TRSP_MOD_CD -- 20071116 박칠서 추가
               ,aft_trsp_mod_cd   -- 2010.07.21 PST_COST_ACT_GRP_CD  -> AFT_TRSP_MOD_CD
               ,upd_usr_id
               ,upd_dt
               )
      (SELECT   a1.bkg_no
               ,CASE
                   WHEN SUBSTR(a2.cntr_tpsz_cd, 0, 1) = 'R'
                   AND a1.soc_flg = 'Y'
                   AND a1.rf_spcl_flg = 'N'
                      THEN   -- 20080304 PEJ 변경
                          'RD' || SUBSTR(a2.cntr_tpsz_cd, -1)
                   WHEN SUBSTR(a2.cntr_tpsz_cd, 0, 1) = 'R'
                   AND a1.rd_spcl_flg = 'Y'
                      THEN   -- 20080130 PEJ 변경
                          'RD' || SUBSTR(a2.cntr_tpsz_cd, -1)
                   ELSE a2.cntr_tpsz_cd
                END cntr_tpsz_cd
               ,a2.cost_act_grp_seq
               ,a2.coa_cost_src_cd
               ,a1.cost_rout_no
               ,MAX(a2.cost_act_grp_cd) act_grp_cd
               ,MAX(a2.n1st_nod_cd) nod_cd
               ,MAX(COALESCE(a2.n4th_nod_cd, a2.n3rd_nod_cd, a2.n2nd_nod_cd)) to_nod_cd
               ,MAX(a2.stnd_cost_cd) stnd_cost_cd
               ,MAX(a2.cost_cate_cd) cost_cate_cd
               ,MAX(a2.ra_acct_cd) ra_acct_cd
               ,MAX(a2.n1st_nod_cd) n1st_nod_cd
               ,SUM(a2.cntr_qty) cntr_qty
               ,MAX(a2.n2nd_nod_cd) n2nd_nod_cd
               ,MAX(a2.n3rd_nod_cd) n3rd_nod_cd
               ,MAX(a2.n4th_nod_cd) n4th_nod_cd
               ,MAX(a2.cost_ass_bse_cd) cost_ass_bse_cd
               ,MAX(a2.rout_tz_mod_cd) rout_tz_mod_cd
               ,MAX(a2.fcgo_tz_dys) fcgo_tz_dys
               ,MAX(a2.fcgo_tz_hrs) fcgo_tz_hrs
               ,MAX(a2.mcgo_tz_dys) mcgo_tz_dys
               ,MAX(a2.mcgo_tz_hrs) mcgo_tz_hrs
               ,MAX(a1.rf_spcl_flg) spcl_rc_flg
               ,MAX(a1.dg_spcl_flg) spcl_dg_cgo_flg
               ,MAX(a1.spcl_awk_cgo_flg) spcl_awk_cgo_flg
               ,MAX(a1.bb_spcl_flg) spcl_bb_cgo_flg
               ,MAX(a1.rd_spcl_flg) rd_flg
               ,MAX(a1.soc_flg) soc_flg
               ,'Y'
               ,in_user_id
               ,SYSDATE
               ,MAX(a2.ctrl_ofc_cd) ctrl_ofc_cd
               ,MAX(a2.rail_svc_tp_cd) rail_svc_tp_cd
               ,MAX(a2.cost_act_grp_tp_cd) cost_act_grp_tp_cd
               ,MAX(a2.vsl_slan_cd) vsl_slan_cd
               ,MAX(a2.cost_io_bnd_cd) cost_io_bnd_cd
               ,MAX(a2.n1st_nod_tp_cd) n1st_nod_tp_cd
               ,MAX(a2.n1st_vndr_seq) n1st_vndr_seq
               ,MAX(a2.n2nd_vndr_seq) n2nd_vndr_seq
               ,MAX(a2.n3rd_vndr_seq) n3rd_vndr_seq
               ,MAX(a2.n4th_vndr_seq) n4th_vndr_seq
               ,MAX(a2.cust_nomi_trkr_flg) cust_nomi_trkr_flg
               ,MAX(a2.trsp_svc_ofc_cd) trsp_svc_ofc_cd
               ,MAX(a2.lgs_cost_cd_chk_flg) lgs_cost_cd_chk_flg
               ,MAX(a2.thrp_rt_flg) thrp_rt_flg
               ,MAX(a2.act_grp_tml_flg) act_grp_tml_flg
               ,MAX(a2.aply_vndr_seq) aply_vndr_seq
               ,'USD' locl_curr_cd   -- usd 단가 적용으로 인해 'USD' 세팅
               ,SUM(estm_usd_ttl_amt) estm_usd_ttl_amt
               ,SUM(respb_usd_ttl_amt) respb_usd_ttl_amt
               ,'N'
               ,AVG(estm_usd_uc_amt) estm_usd_uc_amt
               ,AVG(respb_usd_uc_amt) respb_usd_uc_amt
               ,MAX(a2.ctrt_rtn_flg) ctrt_rtn_flg
               ,MAX(a2.wtr_rcv_term_cd) wtr_rcv_term_cd
               ,MAX(a2.wtr_de_term_cd) wtr_de_term_cd
               ,MAX(a2.cost_calc_rmk) cost_calc_rmk
               ,DECODE(a2.coa_cost_src_cd, '65901021', 'Y', '91401011', 'Y', 'N') delt_flg   -- 화면에서 제외될 코드 (ABC OTH VOL, STP INCOME)
               ,MAX(a2.bfr_trsp_mod_cd) BFR_TRSP_MOD_CD   --PRE_COST_ACT_GRP_CD  -> BFR_TRSP_MOD_CD  2010.07.21 -- 20071116 박칠서 추가
               ,MAX(a2.aft_trsp_mod_cd) AFT_TRSP_MOD_CD   --PST_COST_ACT_GRP_CD  -> AFT_TRSP_MOD_CD  2010.07.21 
               ,in_user_id  
               ,SYSDATE
           FROM coa_com_para a1, coa_com_cost_para a2
          WHERE 1 = 1
            AND a1.bkg_no = in_bkg_no
            AND a1.pctl_no = a2.pctl_no
       GROUP BY a1.bkg_no
               ,CASE
                   WHEN SUBSTR(a2.cntr_tpsz_cd, 0, 1) = 'R'
                   AND a1.soc_flg = 'Y'
                   AND a1.rf_spcl_flg = 'N'
                      THEN   -- 20080304 PEJ 변경
                          'RD' || SUBSTR(a2.cntr_tpsz_cd, -1)
                   WHEN SUBSTR(a2.cntr_tpsz_cd, 0, 1) = 'R'
                   AND a1.rd_spcl_flg = 'Y'
                      THEN   -- 20080130 PEJ 변경
                          'RD' || SUBSTR(a2.cntr_tpsz_cd, -1)
                   ELSE a2.cntr_tpsz_cd
                END
               ,a2.cost_act_grp_seq
               ,a2.coa_cost_src_cd
               ,a1.cost_rout_no);
--enis_log_prc(SYSDATE, 'COA_BKG_INFO_INST_PRC', 'COA_BKG_COST_SRC_DTL', v_appl_info);
--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- BKG 전체 물량 구하기
--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   SELECT NVL(SUM(cntr_qty), 0)
     INTO v_qty_sum
     FROM (SELECT   AVG(cntr_qty) cntr_qty
               FROM coa_bkg_cost_src_dtl
              WHERE bkg_no = in_bkg_no
           GROUP BY bkg_no, cntr_tpsz_cd, cost_rout_no);

--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- BKG SPLIT RATION 구하기
--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := 'BKG SPLIT RATION 구하기';

   SELECT SPLIT_RTO
     INTO v_bkg_split_rto
     FROM BKG_BOOKING
    WHERE bkg_no = in_bkg_no;

--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- ABC/STP 배부
--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
--   v_coa_step := 'ABC/STP 배부';
--
--   IF (v_qty_sum > 0)
--   THEN
--      --RA
--      MERGE INTO coa_bkg_cost_src_dtl b1
--         USING (SELECT a1.bkg_no
--                      ,a1.cntr_tpsz_cd
--                      ,a1.cost_rout_no
--                      ,a1.cost_act_grp_seq
--                      ,a1.coa_cost_src_cd
--                      ,a1.cntr_qty
--                      , abc_stp_amt / v_qty_sum uc_amt   -- 단가
--                      , a1.cntr_qty * abc_stp_amt / v_qty_sum ttl_amt   -- 금액
----                      ,a1.BZC_COST_YRMON
--                  FROM coa_bkg_cost_src_dtl a1
--                      ,(SELECT   bkg_no
--                                ,ra_acct_cd coa_cost_src_cd
--                                ,SUM(svc_trns_prc_amt * NVL(bkg_split_rto, 1)) abc_stp_amt   -- 단가 * Bkg split Ratio
--                            FROM coa_bkg_svc_trns_prc
--                           WHERE bkg_no = in_bkg_no
--                             AND ra_acct_cd IN('65901011', '65901021', '91401011')
--                        GROUP BY bkg_no,ra_acct_cd
--                        UNION ALL
--                        SELECT   bkg_no   -- STP REV 로 STP COST 생성
--                                ,'92404011' coa_cost_src_cd
--                                ,SUM(svc_trns_prc_amt * NVL(bkg_split_rto, 1)) abc_stp_amt   -- 단가 * Bkg split Ratio
--                            FROM coa_bkg_svc_trns_prc
--                           WHERE bkg_no = in_bkg_no
--                             AND ra_acct_cd = '91401011'
--                        GROUP BY bkg_no, ra_acct_cd) a2
--                 WHERE a1.bkg_no = a2.bkg_no
--                   AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
----                   AND a1.BZC_COST_YRMON = V_BZC_COST_YRMON 
--                   AND a1.bkg_no = in_bkg_no) b2
--         ON (    -- b1.BZC_COST_YRMON = b2.BZC_COST_YRMON AND 
--             b1.bkg_no = b2.bkg_no
--             AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
--             AND b1.cost_rout_no = b2.cost_rout_no
--             AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
--             AND b1.coa_cost_src_cd = b2.coa_cost_src_cd)
--         WHEN MATCHED THEN
--            UPDATE
--               SET b1.respb_usd_uc_amt = b2.uc_amt, b1.respb_usd_ttl_amt = b2.ttl_amt
--                  ,b1.locl_curr_cd = 'USD', b1.cost_cate_cd = 'J'
--                  ,cost_calc_rmk = 'ABC RTO:' || v_bkg_split_rto
--                  ,b1.delt_flg = DECODE(ra_acct_cd, '65901021', 'Y', '91401011', 'Y', 'N')
--                  ,b1.upd_usr_id = in_user_id, b1.upd_dt = SYSDATE
--            ;
--      --PA
--      MERGE INTO coa_bkg_cost_src_dtl b1
--         USING (SELECT   a1.bkg_no
--                        ,a1.cntr_tpsz_cd
--                        ,a1.cost_rout_no
--                        ,a1.cost_act_grp_seq
--                        ,'65000000' coa_cost_src_cd
--                        ,SUM(respb_usd_uc_amt) uc_amt   -- 단가
--                        ,SUM(respb_usd_ttl_amt) ttl_amt   -- 금액
----                        ,a1.BZC_COST_YRMON
--                    FROM coa_bkg_cost_src_dtl a1
--                   WHERE 1=1--a1.BZC_COST_YRMON = V_BZC_COST_YRMON 
--                     AND a1.bkg_no = in_bkg_no
--                     AND a1.coa_cost_src_cd IN('65901011', '65901021')
--                GROUP BY a1.bkg_no
--                        ,a1.cntr_tpsz_cd
--                        ,a1.cost_rout_no
--                        ,a1.cost_act_grp_seq
----                        ,a1.BZC_COST_YRMON
--                        ) b2
--         ON (    --b1.BZC_COST_YRMON = b2.BZC_COST_YRMON AND 
--             b1.bkg_no = b2.bkg_no
--             AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
--             AND b1.cost_rout_no = b2.cost_rout_no
--             AND b1.cost_act_grp_seq = b2.cost_act_grp_seq
--             AND b1.coa_cost_src_cd = b2.coa_cost_src_cd)
--         WHEN MATCHED THEN
--            UPDATE
--               SET b1.estm_usd_uc_amt = b2.uc_amt, b1.estm_usd_ttl_amt = b2.ttl_amt
--                  ,b1.locl_curr_cd = 'USD', b1.cost_cate_cd = 'J'
--                  ,cost_calc_rmk = 'ABC RTO:' || v_bkg_split_rto, b1.delt_flg = 'N'
--                  ,b1.upd_usr_id = in_user_id, b1.upd_dt = SYSDATE
--            ;
--   END IF;

--   enis_log_prc(SYSDATE
--               ,'COA_RGST_BKG_INST_PRC'
--               , 'coa_bkg_cost_src_dtl ' || SQL%ROWCOUNT || 'STEP1 insert'
--               ,v_appl_info
--               );


--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- BKG 삭제시 FLG 'Y'로 변경
--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   BEGIN
      SELECT bkg_sts_cd
        INTO v_bkg_sts_cd
        FROM coa_rgst_bkg
       WHERE bkg_no = in_bkg_no;
   EXCEPTION
      WHEN OTHERS
      THEN
         v_bkg_sts_cd := NULL;
   END;

--   enis_log_prc(SYSDATE, 'COA_RGST_BKG_INST_PRC', 'v_bkg_sts_cd: ' || v_bkg_sts_cd, v_appl_info);

   IF (v_bkg_sts_cd = 'X')
   THEN
      UPDATE coa_bkg_cost_src_dtl
         SET delt_flg = 'Y'
       WHERE bkg_no = in_bkg_no;

--      enis_log_prc(SYSDATE
--                  ,'COA_RGST_BKG_INST_PRC'
--                  , 'coa_bkg_cost_dtl ' || SQL%ROWCOUNT || ' update'
--                  ,v_appl_info
--                  );
   END IF;
               
   enis_log_prc(SYSDATE
               ,'COA_BKG_INFO_INST_PRC'
               , 'End' || TO_CHAR(SYSDATE, 'yyyy/mm/dd hh24:mi:ss')
               ,v_appl_info
               );
               
EXCEPTION
   WHEN OTHERS
   THEN
      out_result := 'N';
      enis_log_prc(SYSDATE, 'COA_BKG_INFO_INST_PRC', 'Error: ' || SQLERRM, v_appl_info);
      RAISE;
END coa_bkg_info_inst_prc;