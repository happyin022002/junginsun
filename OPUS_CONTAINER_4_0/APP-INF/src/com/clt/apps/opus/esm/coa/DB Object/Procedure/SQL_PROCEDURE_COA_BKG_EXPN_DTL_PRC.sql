CREATE OR REPLACE PROCEDURE COA_BKG_EXPN_DTL_PRC (
                                                   in_mode         IN   VARCHAR2   -- A: AUTO, B: BKG NO, W: Week
                                                  ,in_year         IN   VARCHAR2   -- Year
                                                  ,in_fm_wk        IN   VARCHAR2   -- From Week
                                                  ,in_to_wk        IN   VARCHAR2   -- To Week  
                                                  ,in_bkg_no       IN   VARCHAR2) 
AUTHID CURRENT_USER
IS
                                                  
/******************************************************************************
   Purpose      :   계정별 레포트 작성시 COA_BKG_SRC_DTL 데이터가 대량이어서
                    빠른 조회 어려움을 해결하기 위해 만듬

   Revision History
      1. 2014.06.01 Initial Creation
      2. 2014.08.29 SJH Revenue Average Flag
      3. 2014.11.13 PCM NYK Mty Repo Cost
      3. 2014.11.18 SMY Slot Internal Pricing   

   Ex)
    -- 하루전에 변경된 BKG에 대해서 EXPN DTL 데이터 생성
    BEGIN
      COA_BKG_EXPN_DTL_PRC ('A', '2008', NULL, NULL, NULL, NULL);
      COMMIT;
    END;

    -- Week에 해당하는 
    BEGIN
      COA_BKG_EXPN_DTL_PRC ('W', '2008', '23', '23', NULL, NULL);
      COMMIT;
    END;

    -- BKG에 해당하는 
    BEGIN
      COA_BKG_EXPN_DTL_PRC ('B', NULL, NULL, NULL, 'HAMZ1110007','  ');
      COMMIT;
    END;

    -- LOG 보기
    SELECT *
      FROM enis_log
     WHERE mod_name = 'COA_BKG_EXPN_DTL_PRC'
       AND exec_dt  > SYSDATE-1/24
--       AND log_desc LIKE 'v_prc_cnt%'
--       AND log_desc LIKE 'Error%'
     ORDER BY exec_dt DESC 

******************************************************************************/



--//////////////////////////////////////////////////////////////////////////////////////////////////
-- CURSOR 정의
-- BKG대상을 잡아준다
-- A : coa_bkg_info.coa_bat_dt 가 하루전에 변경된 BKG들을 대상으로 잡는다.
-- W : 주차에 해당하는 BKG들을 대상으로 잡는다
-- B : BKG 한건을 대상으로 잡는다(배치시 사용)
--//////////////////////////////////////////////////////////////////////////////////////////////////
    CURSOR bkg_list_cursor(p_mode VARCHAR2, p_year VARCHAR2, p_fm_dt VARCHAR2, p_to_dt VARCHAR2, p_bkg_no VARCHAR2) IS
    SELECT a2.bkg_no
        , count(*) over() ttl_cnt
      FROM coa_mon_vvd a1
          ,coa_rgst_bkg a2
     WHERE a1.trd_cd        = a2.trd_cd
       AND a1.rlane_cd      = a2.rlane_cd
       AND a1.ioc_cd        = a2.ioc_cd
       AND a1.vsl_cd        = a2.vsl_cd
       AND a1.skd_voy_no    = a2.skd_voy_no
       AND a1.dir_cd        = a2.dir_cd  
       AND a1.delt_flg      = 'N'
       AND 'A'              = p_mode 
       AND a2.coa_bat_dt    > sysdate-1 
    UNION ALL
    SELECT a2.bkg_no
    , count(*) over() ttl_cnt
      FROM coa_mon_vvd a1
          ,coa_rgst_bkg a2
     WHERE a1.trd_cd     = a2.trd_cd
       AND a1.rlane_cd   = a2.rlane_cd
       AND a1.ioc_cd     = a2.ioc_cd
       AND a1.vsl_cd     = a2.vsl_cd
       AND a1.skd_voy_no = a2.skd_voy_no
       AND a1.dir_cd     = a2.dir_cd  
       AND a1.delt_flg   = 'N'
       AND 'W'           = p_mode 
       AND a1.sls_yrmon  LIKE p_year||'%' 
       AND a1.cost_wk    BETWEEN p_fm_dt AND p_to_dt
    UNION ALL
    SELECT bkg_no
    , count(*) over() ttl_cnt
      FROM coa_rgst_bkg 
     WHERE 'B'           = p_mode 
       AND bkg_no        = p_bkg_no 
    ;
    
--//////////////////////////////////////////////////////////////////////////////////////////////////
-- 변수 정의
--//////////////////////////////////////////////////////////////////////////////////////////////////
   v_start_time            TIMESTAMP;
   v_coa_step              VARCHAR(100);
   v_mode                  VARCHAR(1);
   v_year                  VARCHAR(4);
   v_fm_wk                 VARCHAR(8);   -- from week
   v_to_wk                 VARCHAR(8);   -- to week
   v_bkg_no                coa_rgst_bkg.bkg_no%TYPE;
   v_prc_ttl_cnt           NUMBER                                   := 0;   -- 전체대상건수
   v_prc_cnt               NUMBER                                   := 0;   -- 처리건수
   v_ins_cnt               NUMBER                                   := 0;   -- 생성건수
   v_err_cnt               NUMBER                                   := 0;   -- 에러건수
   v_is_err                VARCHAR2(1)                              := 'N';   -- 에러 여부 Y/N
   v_appl_info             VARCHAR2(15)                             := NULL;   -- BKG_NO
   v_bkg_cost_smry_bkg_no   coa_rgst_bkg.bkg_no%TYPE;   -- BKG COST DTL 의 BKG_NO
   v_rmk                   VARCHAR(1000);
   V_VVD_CNT               NUMBER(1); -- VVD CNT
   v_calc_gkb              VARCHAR(15); --COA_BKG_COST_CALC에 BKG 정보가 있는지 조회
   v_agmt_prc_ctrt_cust_tp_cd pri_taa_mn.prc_ctrt_cust_tp_cd%type;
BEGIN
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 시작 정보 출력
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_coa_step := '초기값 설정';
   v_start_time := systimestamp;
   enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'V.20141118');

--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 대상 날짜 조건 설정
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   IF (in_mode = 'W') THEN  -- WEEK
      v_mode   := in_mode;
      v_year   := in_year;
      v_fm_wk  := in_fm_wk;
      v_to_wk  := in_to_wk;
   ELSE                     -- AUTO
      v_mode   := in_mode;
      v_year   := '';
      v_fm_wk  := '';
      v_to_wk  := '';
   END IF;
   IF (in_mode = 'B') THEN
      v_mode   := in_mode;
      v_bkg_no := in_bkg_no;
    ELSE
      v_mode   := in_mode;
      v_bkg_no := '';
    END IF;

   enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'AUTO/MNL: ' || in_mode || ' FM:' || v_fm_wk || ' ~ TO:' || v_to_wk || ', BKG:' || v_bkg_no, v_bkg_no);

  
--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- SCE_COP_HDR COST_ROUT_NO 수정
--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   FOR bkg_list IN bkg_list_cursor(v_mode, v_year, v_fm_wk, v_to_wk, v_bkg_no)
   LOOP
      BEGIN
         v_rmk := '';
         -- 에러발생시 부킹정보
         v_appl_info := bkg_list.bkg_no;
         
         -- Booking별 계산의 경우는 로그를 남기지 않도록 한다. A: AUTO, B: BKG NO, W: Week
         IF in_mode IN ('A', 'W')  
         THEN         
             IF v_prc_cnt = 0 THEN
                v_prc_ttl_cnt := bkg_list.ttl_cnt;
                enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'v_prc_cnt: 1/' || v_prc_ttl_cnt || ' ' || trunc(1 / v_prc_ttl_cnt * 100) || '%' , v_appl_info);
             END IF;
         END IF;
         
         --초기화
         V_VVD_CNT := 0;         
         BEGIN
            
            SELECT COUNT(*) 
            INTO V_VVD_CNT
            FROM COA_MON_VVD A1
                ,COA_RGST_BKG A2
            WHERE A2.BKG_NO        = BKG_LIST.BKG_NO 
              AND A1.VSL_CD        = A2.VSL_CD
              AND A1.SKD_VOY_NO    = A2.SKD_VOY_NO
              AND A1.DIR_CD        = A2.DIR_CD
              AND A1.RLANE_CD      = A2.RLANE_CD
              AND A1.TRD_CD        = A2.TRD_CD
              AND A1.IOC_CD        = A2.IOC_CD
              AND A1.DELT_FLG      = 'N'
              AND A2.BKG_STS_CD    IN('F', 'S', 'W')
              AND A2.BL_NO_TP      IN('M', '0')
              AND A2.BKG_CGO_TP_CD <> 'P'
              ;
              
         EXCEPTION
               WHEN NO_DATA_FOUND
               THEN
                V_VVD_CNT := 0;

         END;
         
         -- EXPN_DTL과 EXPN_DTL_WK 삭제를 대상 항차 존재 유무와 관계 없이 먼저 실행
         -- 대상 항차가 없으면 아무것도 실행하지 않고 끝나기 때문에 삭제 하지 않으면
         -- 기존 data 가 남게 되므로
         
         DELETE coa_bkg_expn_dtl
          WHERE bkg_no       = bkg_list.bkg_no;
             -- 데이터 선 체크
             v_is_err := 'N';

         DELETE COA_BKG_EXPN_DTL_WK
              WHERE BKG_NO       = BKG_LIST.BKG_NO;
         
         
         IF(V_VVD_CNT = 0) THEN                 
            enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC',  'COA_MON_VVD, COA_RGST_BKG JOIN DATA 없음(대상항차 확인)', v_appl_info);
         END IF;
         
         --VVD정보가 있는 경우에만 수행 
         IF(V_VVD_CNT > 0) THEN 

             BEGIN
                -- COA_BKG_COST_SMRY 데이터 존재 체크
                SELECT bkg_no
                  INTO v_bkg_cost_smry_bkg_no
                  FROM COA_BKG_COST_SMRY
                 WHERE bkg_no = bkg_list.bkg_no
                   AND rownum = 1 ;
             EXCEPTION
                WHEN OTHERS
                THEN
                   IF (v_is_err = 'N')
                   THEN
                      v_err_cnt := v_err_cnt + 1;
                   END IF;
                   v_rmk := v_rmk || ' COST_DTL_CHK';
                   v_is_err := 'Y';
    --               enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'V_BKG_COST_DTL_BKG_NO 없음', v_appl_info);
             END;
    
    --         IF (v_is_err = 'N') THEN
    --            enis_log_prc(SYSDATE, 'COA_BKG_EXPN_DTL_PRC', 'INSERT:'|| trunc(v_ins_cnt+1), v_appl_info);
    
    
--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- COA_BKG_EXPN_DTL 입력
--//////////////////////////////////////////////////////////////////////////////////////////////////////////////

                INSERT INTO coa_bkg_expn_dtl
                            (bkg_no
                            ,cntr_tpsz_cd
                            ,cost_rout_no
                            ,cost_yrmon
                            ,SLS_YRMON
                            ,cost_wk
                            ,trd_cd   -- VVD
                            ,sub_trd_cd
                            ,rlane_cd
                            ,ioc_cd
                            ,vsl_cd
                            ,skd_voy_no
                            ,dir_cd
                            ,n1st_trd_cd   -- TRD
                            ,n2nd_trd_cd
                            ,n3rd_trd_cd
                            ,n4th_trd_cd
                            ,n1st_rlane_cd   -- RLANE
                            ,n2nd_rlane_cd
                            ,n3rd_rlane_cd
                            ,n4th_rlane_cd
                            ,n1st_ioc_conti_cd   -- IOC
                            ,n2nd_ioc_conti_cd
                            ,n3rd_ioc_conti_cd
                            ,n4th_ioc_conti_cd
                            ,n1st_finc_vvd_cd   -- FINC VVD
                            ,n2nd_finc_vvd_cd
                            ,n3rd_finc_vvd_cd
                            ,n4th_finc_vvd_cd
                            ,bkg_por_cd   -- LOC
                            ,bkg_pol_cd
                            ,bkg_pod_cd
                            ,bkg_del_cd
                            ,rev_pol_cd
                            ,rev_pod_cd
                            ,n1st_pol_cd
                            ,n2nd_pol_cd
                            ,n3rd_pol_cd
                            ,n4th_pol_cd
                            ,n1st_pod_cd
                            ,n2nd_pod_cd
                            ,n3rd_pod_cd
                            ,n4th_pod_cd
                            ,agmt_sgn_ofc_cd   -- OFC
                            ,rhq_cd
                            ,rgn_ofc_cd
                            ,sls_ofc_cd
                            ,ctrt_hq_ofc_cd
                            ,ctrt_rgn_ofc_cd
                            ,ctrt_ofc_cd
                            ,ctrt_srep_cd
                            ,sc_no   -- SC/RFA
                            ,rfa_no
                            ,bl_no_tp
                            ,bkg_sts_cd
                            ,bkg_cgo_tp_cd    -- MISC
                            ,usa_bkg_mod_cd
                            ,rep_cmdt_cd
                            ,cmdt_cd
                            ,spcl_rc_flg      -- FLG
                            ,spcl_dg_cgo_flg
                            ,spcl_bb_cgo_flg
                            ,spcl_awk_cgo_flg
                            ,rd_flg
                            ,soc_flg
                            ,bkg_de_term_cd
                            ,bkg_rcv_term_cd
                            ,bl_no
                            ,bl_no_chk
                            ,cnee_nm
                            ,cntr_rcv_dt
                            ,cust_tp_cd
                            ,ntfy_nm
                            ,obrd_dt
                            ,oft_tp_cd
                            ,shpr_cnt_cd
                            ,shpr_cust_seq
                            ,shpr_nm
                            ,srep_cd
                            ,rev_conti_cd
                            ,bkg_ofc_cd
                            ,agmt_cust_tp_cd
                            ,agmt_cnt_cd
                            ,agmt_cust_seq
                            ,cust_key_agmt_mgr_flg            
                            ,bkg_qty          -- QTY
                            ,ra_fcgo_tz_dys   -- DAYS
                            ,ra_mcgo_tz_dys
                            ,bkg_rev          -- REV
                            ,bkg_oft_rev
                            ,bkg_misc_rev
                            ,scr_chg_rev
                            ,dmdt_com_amt     -- DEM/DET
                            ,slt_mgmt_ut_com_amt   -- SMU
                            ,bzc_stvg_com_amt   -- NODE
                            ,otr_cy_hndl_com_amt
                            ,ts_stvg_com_amt
                            ,dck_cy_hndl_com_amt
                            ,cgo_hndl_com_amt
                            ,fcntr_sto_com_amt
                            ,misc_cgo_hndl_com_amt
                            ,cgo_var_vol_dc_amt
                            ,tml_com_amt
                            ,full_rail_dir_com_amt   -- LINK
                            ,full_rail_trk_com_amt
                            ,full_trk_dir_com_amt
                            ,full_wtr_dir_com_amt
                            ,full_wtr_rail_com_amt
                            ,full_wtr_trk_com_amt
                            ,full_trsp_com_amt
                            ,mty_stvg_pa_amt        -- MTY
                            ,mty_trsp_pa_amt
                            ,ac_com_amt                 -- AGENT COMMISSION
                            ,cntr_sterm_pa_amt          -- HOLD
                            ,cntr_lterm_pa_amt
                            ,cntr_mnr_chg_pa_amt
                            ,cntr_dpc_pa_amt
                            ,cntr_insur_pa_amt
                            ,chss_sterm_pa_amt
                            ,chss_lterm_pa_amt
                            ,chss_mnr_chg_pa_amt
                            ,chss_dpc_pa_amt
                            ,chss_dryg_pa_amt
                            ,chss_insur_pa_amt
                            ,biz_act_pa_amt              -- ABC
                            ,own_vol_act_amt
                            ,otr_vol_act_amt
                            ,stp_incm_amt
                            ,stp_cost_amt
                            ,op_inter_slt_rntl_bse_amt   -- EMU
                            ,mty_sim_amt
                            ,inter_eq_rntl_bse_amt
                            ,pa_cm_cost_ttl_amt          -- TTL PA
                            ,pa_cm_amt
                            ,pa_cm_pre_bx_amt
                            ,ra_cm_cost_ttl_amt          -- TTL RA
                            ,ra_cm_amt
                            ,ra_cm_pre_bx_amt
                            ,ra_op_cost_ttl_amt          -- SPACE CHARTER REV
                            ,ra_op_amt
                            ,ra_op_pre_bx_amt
                            ,cre_usr_id
                            ,cre_dt
                            ,upd_usr_id
                            ,upd_dt
                            ,bkg_rmk
                            ,spcl_cntr_tpsz_cd
                            ,bkg_cgo_wgt
                            ,bkg_wgt_tp_cd
                            ,cntr_fx_amt        -- OP EQ Cost
                            ,chss_fx_amt        -- OP EQ Cost
                            ,SC_RFA_HLD_CNT_CD
                            ,SC_RFA_HLD_CUST_SEQ
                            ,CNEE_CNT_CD
                            ,CNEE_CUST_SEQ
                            ,NTFY_CNT_CD
                            ,NTFY_CUST_SEQ

                            ,SLAN_CD
                            ,DELT_FLG

                            ,ACT_OFC_CD
                            ,AUTO_RAT_DT
                            ,BKG_DEL_YD_CD
                            ,BKG_POR_YD_CD
                            ,CLT_OFC_CD
                            ,FINC_DIR_CD
                            ,N1ST_POL_POD_DYS
                            ,N2ND_POL_POD_DYS
                            ,N3RD_POL_POD_DYS
                            ,N4TH_POL_POD_DYS
                            ,PPD_OFC_CD
                            ,REV_DIR_CD
                            ,VOP_CD
                            ,WRK_VVD_CD

                            ,taa_no
 
                            ,agmt_prc_ctrt_cust_tp_cd

                            ,rt_bl_tp_cd
                            ,rev_avg_flg  --SJH.20140829.ADD
                            ,MTY_STVG_PA_AMT2
                            ,MTY_TRSP_PA_AMT2
                            ,PA_CM_PRE_BX_AMT2
                            ,PA_CM_COST_TTL_AMT2
                            ,PA_CM_AMT2   
                            ,slt_inter_prc_amt    -- 2014.11.18 Slot Internal Pricing
                            )
                   SELECT c1.bkg_no
                         ,c1.cntr_tpsz_cd
                         ,c1.cost_rout_no
                         ,c1.cost_yrmon
                         ,c1.SLS_YRMON
                         ,c1.cost_wk
                         ,c1.trd_cd   -- VVD
                         ,c1.sub_trd_cd
                         ,c1.rlane_cd
                         ,c1.ioc_cd
                         ,c1.vsl_cd
                         ,c1.skd_voy_no
                         ,c1.dir_cd
                         ,c1.n1st_trd_cd   -- TRD
                         ,c1.n2nd_trd_cd
                         ,c1.n3rd_trd_cd
                         ,c1.n4th_trd_cd
                         ,c1.n1st_rlane_cd   -- RLANE
                         ,c1.n2nd_rlane_cd
                         ,c1.n3rd_rlane_cd
                         ,c1.n4th_rlane_cd
                         ,c1.n1st_ioc_conti_cd   -- IOC
                         ,c1.n2nd_ioc_conti_cd
                         ,c1.n3rd_ioc_conti_cd
                         ,c1.n4th_ioc_conti_cd
                         ,c1.n1st_finc_vvd_cd   -- FINC VVD
                         ,c1.n2nd_finc_vvd_cd
                         ,c1.n3rd_finc_vvd_cd
                         ,c1.n4th_finc_vvd_cd
                         ,c1.bkg_por_cd   -- LOC
                         ,c1.bkg_pol_cd
                         ,c1.bkg_pod_cd
                         ,c1.bkg_del_cd
                         ,c1.rev_pol_cd
                         ,c1.rev_pod_cd
                         ,c1.n1st_pol_cd
                         ,c1.n2nd_pol_cd
                         ,c1.n3rd_pol_cd
                         ,c1.n4th_pol_cd
                         ,c1.n1st_pod_cd
                         ,c1.n2nd_pod_cd
                         ,c1.n3rd_pod_cd
                         ,c1.n4th_pod_cd
                         ,c1.agmt_sgn_ofc_cd   -- OFC
                         ,c1.rhq_cd
                         ,c1.rgn_ofc_cd
                         ,c1.sls_ofc_cd
                         ,c1.ctrt_hq_ofc_cd
                         ,c1.ctrt_rgn_ofc_cd
                         ,c1.ctrt_ofc_cd
                         ,c1.ctrt_srep_cd
                         ,c1.sc_no   -- SC/RFA
                         ,c1.rfa_no
                         ,c1.bl_no_tp
                         ,c1.bkg_sts_cd
                         ,c1.bkg_cgo_tp_cd   -- MISC
                         ,c1.usa_bkg_mod_cd
                         ,c1.rep_cmdt_cd
                         ,c1.cmdt_cd
                         ,c1.spcl_rc_flg   -- FLG
                         ,c1.spcl_dg_cgo_flg
                         ,c1.spcl_bb_cgo_flg
                         ,c1.spcl_awk_cgo_flg
                         ,c1.rd_flg
                         ,c1.soc_flg
                         
                         ,c1.bkg_de_term_cd
                         ,c1.bkg_rcv_term_cd
                         ,c1.bl_no
                         ,c1.bl_no_chk
                         ,c1.cnee_nm
                         ,c1.cntr_rcv_dt
                         ,c1.cust_tp_cd
                         ,c1.ntfy_nm
                         ,c1.obrd_dt
                         ,c1.oft_tp_cd
                         ,c1.shpr_cnt_cd
                         ,c1.shpr_cust_seq
                         ,c1.shpr_nm
                         ,c1.srep_cd
                         ,c1.rev_conti_cd
                         ,c1.bkg_ofc_cd
                         ,c1.agmt_cust_tp_cd
                         ,c1.agmt_cnt_cd
                         ,c1.agmt_cust_seq
                         ,c1.cust_key_agmt_mgr_flg
                         
                         ,c1.bkg_qty   -- QTY
                         ,c2.ra_fcgo_tz_dys   -- DAYS
                         ,c2.ra_mcgo_tz_dys
                         ,c1.bkg_rev   -- REV
                         ,c1.bkg_oft_rev
                         ,c1.bkg_misc_rev
                         ,c1.scr_chg_rev
                         ,c2.dmdt_com_amt   -- DEM/DET
                         ,c2.slt_mgmt_ut_com_amt   -- SMU
                         ,NVL(c2.bzc_stvg_com_amt,0)   -- NODE
                         ,NVL(c2.otr_cy_hndl_com_amt,0)
                         ,NVL(c2.ts_stvg_com_amt,0)
                         ,NVL(c2.dck_cy_hndl_com_amt,0)
                         ,NVL(c2.cgo_hndl_com_amt,0)
                         ,NVL(c2.fcntr_sto_com_amt,0)
                         ,NVL(c2.misc_cgo_hndl_com_amt,0)
                         ,NVL(c2.cgo_var_vol_dc_amt,0)
                         ,NVL(c2.tml_com_amt,0)
                         ,NVL(c2.full_rail_dir_com_amt,0)   -- LINK
                         ,NVL(c2.full_rail_trk_com_amt,0)
                         ,NVL(c2.full_trk_dir_com_amt,0)
                         ,NVL(c2.full_wtr_dir_com_amt,0)
                         ,NVL(c2.full_wtr_rail_com_amt,0)
                         ,NVL(c2.full_wtr_trk_com_amt,0)
                         ,NVL(c2.full_trsp_com_amt,0)
                         ,NVL(c2.mty_stvg_pa_amt,0)   -- MTY
                         ,NVL(c2.mty_trsp_pa_amt,0)
                         ,c2.ac_com_amt          -- AGENT COMMISSION
                         ,c2.cntr_sterm_pa_amt   -- HOLD
                         ,c2.cntr_lterm_pa_amt
                         ,c2.cntr_mnr_chg_pa_amt
                         ,c2.cntr_dpc_pa_amt
                         ,c2.cntr_insur_pa_amt
                         ,c2.chss_sterm_pa_amt
                         ,c2.chss_lterm_pa_amt
                         ,c2.chss_mnr_chg_pa_amt
                         ,c2.chss_dpc_pa_amt
                         ,c2.chss_dryg_pa_amt
                         ,c2.chss_insur_pa_amt
                         ,c2.biz_act_pa_amt   -- ABC
                         ,c2.own_vol_act_amt
                         ,c2.otr_vol_act_amt
                         ,c2.stp_incm_amt
                         ,c2.stp_cost_amt
                         ,c2.op_inter_slt_rntl_bse_amt   -- EMU
                         ,c2.mty_sim_amt
                         ,c2.inter_eq_rntl_bse_amt
                         ,c2.pa_cm_cost_ttl_amt   -- TTL PA
                         ,c2.pa_cm_cost_ttl_amt / decode(substr(c1.cntr_tpsz_cd, -1), '2', c1.bkg_qty, c1.bkg_qty * 2) pa_cm_amt
                         ,c2.pa_cm_cost_ttl_amt / c1.bkg_qty pa_cm_pre_bx_amt
                         ,c2.ra_cm_cost_ttl_amt   -- TTL RA
                         ,c2.ra_cm_cost_ttl_amt / decode(substr(c1.cntr_tpsz_cd, -1), '2', c1.bkg_qty, c1.bkg_qty * 2) ra_cm_amt
                         ,c2.ra_cm_cost_ttl_amt / c1.bkg_qty ra_cm_pre_bx_amt
                         ,c2.ra_op_cost_ttl_amt   -- SPACE CHARTER REV
                         ,c2.ra_op_cost_ttl_amt / decode(substr(c1.cntr_tpsz_cd, -1), '2', c1.bkg_qty, c1.bkg_qty * 2) ra_op_amt
                         ,c2.ra_op_cost_ttl_amt / c1.bkg_qty ra_op_pre_bx_amt
                         ,'SYS_COA_EXPN' cre_usr_id
                         ,sysdate cre_dt
                         ,'SYS_COA_EXPN' upd_usr_id
                         ,sysdate upd_dt
                         ,v_rmk
                         ,c1.spcl_cntr_tpsz_cd
                         ,c1.bkg_cgo_wgt
                         ,c1.bkg_wgt_tp_cd
                         ,c2.cntr_fix_amt        -- OP EQ Cost
                         ,c2.chss_fix_amt        -- OP EQ Cost 

                        ,C1.SC_RFA_HLD_CNT_CD
                        ,C1.SC_RFA_HLD_CUST_SEQ
                        ,C1.CNEE_CNT_CD
                        ,C1.CNEE_CUST_SEQ
                        ,C1.NTFY_CNT_CD
                        ,C1.NTFY_CUST_SEQ
                        ,C1.SLAN_CD
                        ,C1.DELT_FLG
 
                        ,C1.ACT_OFC_CD
                        ,C1.AUTO_RAT_DT
                        ,C1.BKG_DEL_YD_CD
                        ,C1.BKG_POR_YD_CD
                        ,C1.CLT_OFC_CD
                        ,C1.FINC_DIR_CD
                        ,C1.N1ST_POL_POD_DYS
                        ,C1.N2ND_POL_POD_DYS
                        ,C1.N3RD_POL_POD_DYS
                        ,C1.N4TH_POL_POD_DYS
                        ,C1.PPD_OFC_CD
                        ,C1.REV_DIR_CD
                        ,C1.VOP_CD
                        ,C1.WRK_VVD_CD
                        ,c1.taa_no
                        ,c1.agmt_prc_ctrt_cust_tp_cd
                        ,c1.rt_bl_tp_cd
                        ,c1.rev_avg_flg                     --SJH.20140829.ADD
                        ,NVL(c2.mty_stvg_pa_amt2,0)   -- MTY
                        ,NVL(c2.mty_trsp_pa_amt2,0)
                        ,c2.pa_cm_cost_ttl_amt2 / c1.bkg_qty pa_cm_pre_bx_amt2
                        ,c2.pa_cm_cost_ttl_amt2   -- TTL PA
                        ,c2.pa_cm_cost_ttl_amt2 / decode(substr(c1.cntr_tpsz_cd, -1), '2', c1.bkg_qty, c1.bkg_qty * 2) pa_cm_amt2
                        ,c2.slt_inter_prc_amt  -- 2014.10.20 Slot Internal Pricing 
                     FROM (
                           SELECT a2.bkg_no
                                 ,a3.cntr_tpsz_cd
                                 ,a3.cost_rout_no
                                 ,a1.cost_yrmon
                                 ,a1.SLS_YRMON
                                 ,a1.cost_wk
                                 ,a1.trd_cd   -- VVD
                                 ,a1.sub_trd_cd
                                 ,a1.rlane_cd
                                 ,a1.ioc_cd
                                 ,a1.vsl_cd
                                 ,a1.skd_voy_no
                                 ,a1.dir_cd
                                 ,a2.n1st_trd_cd   -- TRD
                                 ,a2.n2nd_trd_cd
                                 ,a2.n3rd_trd_cd
                                 ,a2.n4th_trd_cd
                                 ,a2.n1st_rlane_cd   -- RLANE
                                 ,a2.n2nd_rlane_cd
                                 ,a2.n3rd_rlane_cd
                                 ,a2.n4th_rlane_cd
                                 ,(CASE WHEN a2.n1st_ioc_conti_cd IS NULL THEN '' 
                                        WHEN SUBSTR(a2.n1st_ioc_conti_cd,1,1) =  SUBSTR(a2.n1st_ioc_conti_cd,2,1) THEN 'I' 
                                        WHEN SUBSTR(a2.n1st_ioc_conti_cd,1,1) <> SUBSTR(a2.n1st_ioc_conti_cd,2,1) THEN 'O' END) AS n1st_ioc_conti_cd
                                 ,(CASE WHEN a2.n2nd_ioc_conti_cd IS NULL THEN '' 
                                        WHEN SUBSTR(a2.n2nd_ioc_conti_cd,1,1) =  SUBSTR(a2.n2nd_ioc_conti_cd,2,1) THEN 'I' 
                                        WHEN SUBSTR(a2.n2nd_ioc_conti_cd,1,1) <> SUBSTR(a2.n2nd_ioc_conti_cd,2,1) THEN 'O' END) AS n2nd_ioc_conti_cd 
                                 ,(CASE WHEN a2.n3rd_ioc_conti_cd IS NULL THEN '' 
                                        WHEN SUBSTR(a2.n3rd_ioc_conti_cd,1,1) =  SUBSTR(a2.n3rd_ioc_conti_cd,2,1) THEN 'I' 
                                        WHEN SUBSTR(a2.n3rd_ioc_conti_cd,1,1) <> SUBSTR(a2.n3rd_ioc_conti_cd,2,1) THEN 'O' END) AS n3rd_ioc_conti_cd 
                                 ,(CASE WHEN a2.n4th_ioc_conti_cd IS NULL THEN '' 
                                        WHEN SUBSTR(a2.n4th_ioc_conti_cd,1,1) =  SUBSTR(a2.n4th_ioc_conti_cd,2,1) THEN 'I' 
                                        WHEN SUBSTR(a2.n4th_ioc_conti_cd,1,1) <> SUBSTR(a2.n4th_ioc_conti_cd,2,1) THEN 'O' END) AS n4th_ioc_conti_cd                             
                                 ,SUBSTR(a2.n1st_finc_vvd_cd,1,9) AS n1st_finc_vvd_cd  -- FINC VVD
                                 ,SUBSTR(a2.n2nd_finc_vvd_cd,1,9) AS n2nd_finc_vvd_cd
                                 ,SUBSTR(a2.n3rd_finc_vvd_cd,1,9) AS n3rd_finc_vvd_cd
                                 ,SUBSTR(a2.n4th_finc_vvd_cd,1,9) AS n4th_finc_vvd_cd
                                 ,a2.bkg_por_cd   -- LOC
                                 ,a2.bkg_pol_cd
                                 ,a2.bkg_pod_cd
                                 ,a2.bkg_del_cd
                                 ,a2.rev_pol_cd
                                 ,a2.rev_pod_cd
                                 ,a2.n1st_pol_cd
                                 ,a2.n2nd_pol_cd
                                 ,a2.n3rd_pol_cd
                                 ,a2.n4th_pol_cd
                                 ,a2.n1st_pod_cd
                                 ,a2.n2nd_pod_cd
                                 ,a2.n3rd_pod_cd
                                 ,a2.n4th_pod_cd
                                 ,a2.agmt_sgn_ofc_cd   -- OFC
                                 ,a2.rhq_cd
                                 ,a2.rgn_ofc_cd
                                 ,a2.sls_ofc_cd
                                 ,a2.ctrt_hq_ofc_cd
                                 ,a2.ctrt_rgn_ofc_cd
                                 ,a2.ctrt_ofc_cd
                                 ,a2.ctrt_srep_cd
                                 ,a2.sc_no   -- SC/RFA
                                 ,a2.rfa_no
                                 ,a2.bl_no_tp
                                 ,a2.bkg_sts_cd   -- MISC
                                 ,a2.bkg_cgo_tp_cd
                                 ,a2.usa_bkg_mod_cd
                                 ,a2.rep_cmdt_cd
                                 ,a2.cmdt_cd
                                 
                                 ,a3.spcl_rc_flg   
                                 ,a3.spcl_dg_cgo_flg
                                 ,a3.spcl_bb_cgo_flg
                                 ,a3.spcl_awk_cgo_flg
                                 ,a3.rd_flg
                                 ,a3.soc_flg
                                 
                                 ,a2.bkg_de_term_cd
                                 ,a2.bkg_rcv_term_cd
                                 ,a2.bl_no
                                 ,a2.bl_no_chk
                                 ,a2.cnee_nm
                                 ,a2.cntr_rcv_dt
                                 ,a2.cust_tp_cd
                                 ,a2.ntfy_nm
                                 ,a2.obrd_dt
                                 ,a2.oft_tp_cd
                                 ,a2.shpr_cnt_cd
                                 ,a2.shpr_cust_seq
                                 ,a2.shpr_nm
                                 ,a2.srep_cd
                                 ,a2.rev_conti_cd
                                 ,a2.bkg_ofc_cd
                                 ,a2.agmt_cust_tp_cd
                                 ,a2.agmt_cnt_cd
                                 ,a2.agmt_cust_seq
                                 ,a2.cust_key_agmt_mgr_flg
                                 ,a3.bkg_qty   -- QTY
                                 ,a3.bkg_rev   -- REV
                                 ,a3.bkg_oft_rev
                                 ,a3.bkg_misc_rev
                                 ,a3.scr_chg_rev
                                 ,a3.spcl_cntr_tpsz_cd
                                 ,a2.bkg_cgo_wgt
                                 ,a2.bkg_wgt_tp_cd
                               
                                ,A2.SC_RFA_HLD_CNT_CD
                                ,A2.SC_RFA_HLD_CUST_SEQ
                                ,A2.CNEE_CNT_CD
                                ,A2.CNEE_CUST_SEQ
                                ,A2.NTFY_CNT_CD
                                ,A2.NTFY_CUST_SEQ
                               
                                ,A2.SLAN_CD
                                ,A1.DELT_FLG
                               
                                ,A2.ACT_OFC_CD
                                ,A2.AUTO_RAT_DT
                                ,A2.BKG_DEL_YD_CD
                                ,A2.BKG_POR_YD_CD
                                ,A2.CLT_OFC_CD
                                ,A2.FINC_DIR_CD
                                ,A2.N1ST_POL_POD_DYS
                                ,A2.N2ND_POL_POD_DYS
                                ,A2.N3RD_POL_POD_DYS
                                ,A2.N4TH_POL_POD_DYS
                                ,A2.PPD_OFC_CD
                                ,A2.REV_DIR_CD
                                ,A2.VOP_CD
                                ,A2.WRK_VVD_CD
                      
                                ,a2.taa_no
                                ,a2.agmt_prc_ctrt_cust_tp_cd
                                ,a2.rt_bl_tp_cd
                                ,a3.rev_avg_flg                     --SJH.20140829.ADD
                                
                             FROM coa_mon_vvd a1
                                 ,coa_rgst_bkg a2
                                 ,(SELECT   
                                            bkg_no
                                           ,cntr_tpsz_cd
                                           ,cost_rout_no
                                           ,spcl_rc_flg
                                           ,spcl_dg_cgo_flg
                                           ,spcl_bb_cgo_flg
                                           ,spcl_awk_cgo_flg
                                           ,rd_flg
                                           ,soc_flg
                                           ,SUM(bkg_qty) bkg_qty
                                           ,SUM(nvl(bkg_rev, 0)) bkg_rev
                                           ,SUM(nvl(bkg_oft_rev, 0)) bkg_oft_rev
                                           ,SUM(nvl(bkg_misc_rev, 0)) bkg_misc_rev
                                           ,SUM(nvl(scr_chg_rev, 0)) scr_chg_rev
                                           ,spcl_cntr_tpsz_cd
                                           ,rev_avg_flg                     --SJH.20140829.ADD
                                       FROM coa_bkg_rev_dtl
                                      WHERE 1=1
    --                                    AND substr(cntr_tpsz_cd, 1, 1) <> 'Q'  -- Q타입도 포함시킴
                                        AND delt_flg = 'N'
                                        AND bkg_no             = bkg_list.bkg_no   -- LIST BKG_NO
                                   GROUP BY bkg_no
                                           ,cntr_tpsz_cd
                                           ,cost_rout_no
                                           ,spcl_rc_flg
                                           ,spcl_dg_cgo_flg
                                           ,spcl_bb_cgo_flg
                                           ,spcl_awk_cgo_flg
                                           ,rd_flg
                                           ,soc_flg
                                           ,spcl_cntr_tpsz_cd
                                           ,rev_avg_flg                     --SJH.20140829.ADD
                                           ) a3
                            WHERE a1.vsl_cd        = a2.vsl_cd
                              AND a1.skd_voy_no    = a2.skd_voy_no
                              AND a1.dir_cd        = a2.dir_cd
                              AND a1.rlane_cd      = a2.rlane_cd
                              AND a1.trd_cd        = a2.trd_cd
                              AND a1.ioc_cd        = a2.ioc_cd
                              AND a2.bkg_no        = a3.bkg_no
                              AND a1.delt_flg      = 'N'
                              AND a2.bkg_sts_cd    IN('F', 'S','W')
                              AND a2.bl_no_tp      IN('M', '0')
                              AND a2.bkg_cgo_tp_cd <> 'P'
                              AND a2.bkg_no        = bkg_list.bkg_no   -- # BKG_NO
                          ) c1
                         ,(
                           SELECT   b1.bkg_no
                                   ,b1.cntr_tpsz_cd
                                   ,b1.cost_rout_no
                                   ,MAX(ra_fcgo_tz_dys)               ra_fcgo_tz_dys      -- DAYS
                                   ,MAX(ra_mcgo_tz_dys)               ra_mcgo_tz_dys
                                   ,SUM(b1.dmdt_com_amt)              dmdt_com_amt               --43201011 DEM/DET
                                   ,SUM(b1.slt_mgmt_ut_com_amt)       slt_mgmt_ut_com_amt        --92101011 SMU
                                   ,SUM(b1.ac_com_amt)                ac_com_amt                 --51401011 AGENT COMMISSIN
                                   ,SUM(b1.cntr_sterm_pa_amt)         cntr_sterm_pa_amt          --52101011 HOLD
                                   ,SUM(b1.cntr_lterm_pa_amt)         cntr_lterm_pa_amt          --52201011
                                   ,SUM(b1.cntr_mnr_chg_pa_amt)       cntr_mnr_chg_pa_amt        --52301011
                                   ,SUM(b1.cntr_dpc_pa_amt)           cntr_dpc_pa_amt            --52401011
                                   ,SUM(b1.cntr_insur_pa_amt)         cntr_insur_pa_amt          --52601011
                                   ,SUM(b1.chss_sterm_pa_amt)         chss_sterm_pa_amt          --52101021
                                   ,SUM(b1.chss_lterm_pa_amt)         chss_lterm_pa_amt          --52201021
                                   ,SUM(b1.chss_mnr_chg_pa_amt)       chss_mnr_chg_pa_amt        --52301021
                                   ,SUM(b1.chss_dpc_pa_amt)           chss_dpc_pa_amt            --52402011
                                   ,SUM(b1.chss_dryg_pa_amt)          chss_dryg_pa_amt           --52501011
                                   ,SUM(b1.chss_insur_pa_amt)         chss_insur_pa_amt          --52601021
                                   ,SUM(b1.biz_act_pa_amt)            biz_act_pa_amt             --65000000 ABC
                                   ,SUM(b1.own_vol_act_amt)           own_vol_act_amt            --65901011
                                   ,SUM(b1.otr_vol_act_amt)           otr_vol_act_amt            --65901021
                                   ,SUM(b1.stp_incm_amt)              stp_incm_amt               --91401011
                                   ,SUM(b1.stp_cost_amt)              stp_cost_amt               --92404011
                                   ,SUM(b1.op_inter_slt_rntl_bse_amt) op_inter_slt_rntl_bse_amt  --92101011 EMU
                                   ,SUM(b1.mty_sim_amt)               mty_sim_amt                --92202012
                                   ,SUM(b1.inter_eq_rntl_bse_amt)     inter_eq_rntl_bse_amt      --92202011
                                   ,SUM(b1.cntr_fix_amt)              cntr_fix_amt               -- 92202013 EQ Cost
                                   ,SUM(b1.chss_fix_amt)              chss_fix_amt               --92202014
                                   
                                   ,SUM(estm_cm_cost_amt) + SUM(common_amt) pa_cm_cost_ttl_amt   --cm에 common_amt를 더해준다. 
                                   ,SUM(estm_cm_cost_amt2) + SUM(common_amt) pa_cm_cost_ttl_amt2   --cm에 common_amt를 더해준다. 
                                   ,SUM(ra_cm_cost_amt)   + SUM(common_amt) ra_cm_cost_ttl_amt
                                   ,SUM(ra_opfit_cost_amt) - SUM(dmdt_com_amt) ra_op_cost_ttl_amt  -- op cost에 dem/det를 - 해준다                                     
                                   ------------------------I/B, O/B비용으로 나뉘어져 있었던 부분
                                   ,SUM(b1.bzc_stvg_com_amt)           bzc_stvg_com_amt -- NODE
                                   ,SUM(b1.otr_cy_hndl_com_amt)        otr_cy_hndl_com_amt
                                   ,SUM(b1.ts_stvg_com_amt)            ts_stvg_com_amt
                                   ,SUM(b1.dck_cy_hndl_com_amt)        dck_cy_hndl_com_amt
                                   ,SUM(b1.cgo_hndl_com_amt)           cgo_hndl_com_amt
                                   ,SUM(b1.fcntr_sto_com_amt)          fcntr_sto_com_amt
                                   ,SUM(b1.misc_cgo_hndl_com_amt)      misc_cgo_hndl_com_amt
                                   ,SUM(b1.cgo_var_vol_dc_amt)         cgo_var_vol_dc_amt
                                   ,SUM(b1.tml_com_amt)                tml_com_amt
    
                                   ,SUM(b1.full_rail_dir_com_amt)      full_rail_dir_com_amt -- LINK
                                   ,SUM(b1.full_rail_trk_com_amt)      full_rail_trk_com_amt
                                   ,SUM(b1.full_trk_dir_com_amt)       full_trk_dir_com_amt
                                   ,SUM(b1.full_wtr_dir_com_amt)       full_wtr_dir_com_amt
                                   ,SUM(b1.full_wtr_rail_com_amt)      full_wtr_rail_com_amt
                                   ,SUM(b1.full_wtr_trk_com_amt)       full_wtr_trk_com_amt
                                   ,SUM(b1.full_trsp_com_amt)          full_trsp_com_amt
                                   ,SUM(b1.mty_stvg_pa_amt)            mty_stvg_pa_amt -- MTY
                                   ,SUM(b1.mty_trsp_pa_amt)            mty_trsp_pa_amt
                                   ,SUM(b1.mty_stvg_pa_amt2)           mty_stvg_pa_amt2 -- C.M Park
                                   ,SUM(b1.mty_trsp_pa_amt2)           mty_trsp_pa_amt2 -- C.M Park
                                   ,SUM(b1.slt_inter_prc_amt)          slt_inter_prc_amt  -- 2014.11.18 Slot Internal Pricing
                               FROM (
                                     SELECT a1.bkg_no
                                           ,a1.cntr_tpsz_cd
                                           ,a1.cost_rout_no
                                           ,NVL(fcgo_tz_dys, 0)                                    ra_fcgo_tz_dys      -- DAYS
                                           ,NVL(mcgo_tz_dys, 0)                                    ra_mcgo_tz_dys
                                           ,DECODE(a2.stnd_cost_cd, '43201011', a1.estm_usd_ttl_amt, 0)  dmdt_com_amt        -- DEM/DET
                                           ,DECODE(a2.stnd_cost_cd, '51401011', a1.estm_usd_ttl_amt, 0)  ac_com_amt          -- AGENT COMMISSIN
                                           
                                           ,DECODE(a2.stnd_cost_cd, '52101011', a1.estm_usd_ttl_amt, 0)  cntr_sterm_pa_amt   -- HOLD
                                           ,DECODE(a2.stnd_cost_cd, '52101021', a1.estm_usd_ttl_amt, 0)  chss_sterm_pa_amt
                                           ,DECODE(a2.stnd_cost_cd, '52201011', a1.estm_usd_ttl_amt, 0)  cntr_lterm_pa_amt
                                           ,DECODE(a2.stnd_cost_cd, '52201021', a1.estm_usd_ttl_amt, 0)  chss_lterm_pa_amt
                                           ,DECODE(a2.stnd_cost_cd, '52301011', a1.estm_usd_ttl_amt, 0)  cntr_mnr_chg_pa_amt
                                           ,DECODE(a2.stnd_cost_cd, '52301021', a1.estm_usd_ttl_amt, 0)  chss_mnr_chg_pa_amt
                                           ,DECODE(a2.stnd_cost_cd, '52401011', a1.estm_usd_ttl_amt, 0)  cntr_dpc_pa_amt
                                           ,DECODE(a2.stnd_cost_cd, '52402011', a1.estm_usd_ttl_amt, 0)  chss_dpc_pa_amt
                                           ,DECODE(a2.stnd_cost_cd, '52501011', a1.estm_usd_ttl_amt, 0)  chss_dryg_pa_amt
                                           ,DECODE(a2.stnd_cost_cd, '52601011', a1.estm_usd_ttl_amt, 0)  cntr_insur_pa_amt
                                           ,DECODE(a2.stnd_cost_cd, '52601021', a1.estm_usd_ttl_amt, 0)  chss_insur_pa_amt
                                           ,DECODE(a2.stnd_cost_cd, '65000000', a1.estm_usd_ttl_amt, 0)  biz_act_pa_amt     -- ABC
    
                                           ,DECODE(a2.stnd_cost_cd, '65901011', a1.respb_usd_ttl_amt,0)  own_vol_act_amt
                                           ,DECODE(a2.stnd_cost_cd, '65901021', a1.respb_usd_ttl_amt,0)  otr_vol_act_amt
                                           ,DECODE(a2.stnd_cost_cd, '91401011', a1.respb_usd_ttl_amt,0)  stp_incm_amt
                                           ,DECODE(a2.stnd_cost_cd, '92101011', a1.respb_usd_ttl_amt,0)  slt_mgmt_ut_com_amt       -- SMU
                                           ,DECODE(a2.stnd_cost_cd, '92101011', a1.respb_usd_ttl_amt,0)  op_inter_slt_rntl_bse_amt -- SMU(위 컬럼과동일)
                                           ,DECODE(a2.stnd_cost_cd, '92202011', a1.respb_usd_ttl_amt,0)  inter_eq_rntl_bse_amt     -- EMU
                                           ,DECODE(a2.stnd_cost_cd, '92202012', a1.respb_usd_ttl_amt,0)  mty_sim_amt     
                                           ,DECODE(a2.stnd_cost_cd, '92404011', a1.respb_usd_ttl_amt,0)  stp_cost_amt
                                           
                                           ,DECODE(a2.pa_vw || a2.stnd_cost_tp_cd || a2.coa_cost_src_prt_cd, 'BKGCPA', NVL(estm_usd_ttl_amt, 0), 0) estm_cm_cost_amt
                                           ,DECODE(a2.pa_vw || a2.stnd_cost_tp_cd || a2.coa_cost_src_prt_cd, 'BKGCPA', NVL(estm_usd_ttl_amt2, 0), 0) estm_cm_cost_amt2  -- EMPTY2 C.M Park
                                           ,DECODE(a2.pa_vw || a2.stnd_cost_tp_cd || a2.coa_cost_src_prt_cd, 'BKGCRA', NVL(respb_usd_ttl_amt, 0), 0) ra_cm_cost_amt
                                           ,DECODE(a2.pa_vw || a2.stnd_cost_tp_cd || a2.coa_cost_src_prt_cd, 'BKGOPA', NVL(estm_usd_ttl_amt, 0), 0) estm_opfit_cost_amt
                                           ,DECODE(a2.pa_vw || a2.stnd_cost_tp_cd || a2.coa_cost_src_prt_cd, 'BKGORA', NVL(respb_usd_ttl_amt, 0), 0) ra_opfit_cost_amt
                                           ,DECODE(a2.pa_vw || a2.stnd_cost_tp_cd || a2.coa_cost_src_prt_cd, 'BKGCCO', NVL(estm_usd_ttl_amt, 0), 0) common_amt
                                   
                                           ,DECODE(a2.stnd_cost_cd, '92202013', a1.respb_usd_ttl_amt, 0) cntr_fix_amt -- EQ Cost
                                           ,DECODE(a2.stnd_cost_cd, '92202014', a1.respb_usd_ttl_amt, 0) chss_fix_amt
                                           ------------------------I/B, O/B비용으로 나뉘어져 있었던 부분
                                           ,DECODE(a2.stnd_cost_cd, '51101011', a1.estm_usd_ttl_amt, 0) bzc_stvg_com_amt   -- NODE
                                           ,DECODE(a2.stnd_cost_cd, '51101071', a1.estm_usd_ttl_amt, 0) otr_cy_hndl_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51101021', a1.estm_usd_ttl_amt, 0) ts_stvg_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51101031', a1.estm_usd_ttl_amt, 0) dck_cy_hndl_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51101051', a1.estm_usd_ttl_amt, 0) cgo_hndl_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51101041', a1.estm_usd_ttl_amt, 0) fcntr_sto_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51101061', a1.estm_usd_ttl_amt, 0) misc_cgo_hndl_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51601011', a1.estm_usd_ttl_amt, '51601012', a1.estm_usd_ttl_amt, 0) cgo_var_vol_dc_amt --terminal, trans vol incentive 모두 집계
                                           ,DECODE(a2.stnd_cost_cd, '92301000', a1.estm_usd_ttl_amt, 0) tml_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51301011', a1.estm_usd_ttl_amt, 0) full_rail_dir_com_amt   -- LINK
                                           ,DECODE(a2.stnd_cost_cd, '51301021', a1.estm_usd_ttl_amt, 0) full_rail_trk_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51301031', a1.estm_usd_ttl_amt, 0) full_trk_dir_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51301041', a1.estm_usd_ttl_amt, 0) full_wtr_dir_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51301051', a1.estm_usd_ttl_amt, 0) full_wtr_rail_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51301061', a1.estm_usd_ttl_amt, 0) full_wtr_trk_com_amt
--                                           ,DECODE(a2.stnd_cost_cd, '51301081', a1.estm_usd_ttl_amt, 0) full_trsp_com_amt
                                           ,DECODE(a2.stnd_cost_cd, '51301081', a1.estm_usd_ttl_amt, '51301091', a1.estm_usd_ttl_amt, 0) full_trsp_com_amt 
                                           ,DECODE(a2.stnd_cost_cd, '51102000', a1.estm_usd_ttl_amt, 0) mty_stvg_pa_amt   -- MTY
                                           ,DECODE(a2.stnd_cost_cd, '51302000', a1.estm_usd_ttl_amt, 0) mty_trsp_pa_amt
                                           ,DECODE(a2.stnd_cost_cd, '51102000', a1.estm_usd_ttl_amt2, 0) mty_stvg_pa_amt2   -- MTY2 C.M Park
                                           ,DECODE(a2.stnd_cost_cd, '51302000', a1.estm_usd_ttl_amt2, 0) mty_trsp_pa_amt2   -- MTY2 C.M Park
                                           ,DECODE(a2.stnd_cost_cd, '54600001', a1.estm_usd_ttl_amt, 0) slt_inter_prc_amt  -- 2014.11.18 Slot Internal Pricing
                                       FROM COA_BKG_COST_SMRY a1--coa_bkg_cost_src_dtl a1
                                           ,coa_stnd_acct_v a2
                                      WHERE 
                                            a1.stnd_cost_cd    = a2.stnd_cost_cd
    --                                    AND a2.pa_vw           = 'BKG'
                                        AND a1.bkg_no          = bkg_list.bkg_no   -- # BKG_NO
                                        AND a1.delt_flg           = 'N'
                                    ) b1
                           GROUP BY b1.bkg_no
                                   ,b1.cntr_tpsz_cd 
                                   ,b1.cost_rout_no                    
                          ) c2                  
                    WHERE c1.bkg_no       = c2.bkg_no(+)
                      AND c1.cntr_tpsz_cd = c2.cntr_tpsz_cd(+)
                      AND c1.cost_rout_no = c2.cost_rout_no(+)                  
                      ;
                      

--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- COA_BKG_EXPN_DTL_WK 입력
--//////////////////////////////////////////////////////////////////////////////////////////////////////////////
            INSERT INTO COA_BKG_EXPN_DTL_WK 
                       (BKG_NO 
                        , CNTR_TPSZ_CD 
                        , COST_ROUT_NO 
                        , COST_YRMON 
                        , SLS_YRMON 
                        , COST_WK 
                        , TRD_CD 
                        , SUB_TRD_CD 
                        , RLANE_CD 
                        , IOC_CD 
                        , VSL_CD 
                        , SKD_VOY_NO 
                        , DIR_CD 
                        , N1ST_TRD_CD 
                        , N2ND_TRD_CD 
                        , N3RD_TRD_CD 
                        , N4TH_TRD_CD 
                        , N1ST_RLANE_CD 
                        , N2ND_RLANE_CD 
                        , N3RD_RLANE_CD 
                        , N4TH_RLANE_CD 
                        , N1ST_IOC_CONTI_CD 
                        , N2ND_IOC_CONTI_CD 
                        , N3RD_IOC_CONTI_CD 
                        , N4TH_IOC_CONTI_CD 
                        , N1ST_FINC_VVD_CD 
                        , N2ND_FINC_VVD_CD 
                        , N3RD_FINC_VVD_CD 
                        , N4TH_FINC_VVD_CD 
                        , BKG_POR_CD 
                        , BKG_POL_CD 
                        , BKG_POD_CD 
                        , BKG_DEL_CD 
                        , REV_POL_CD 
                        , REV_POD_CD 
                        , N1ST_POL_CD 
                        , N2ND_POL_CD 
                        , N3RD_POL_CD 
                        , N4TH_POL_CD 
                        , N1ST_POD_CD 
                        , N2ND_POD_CD 
                        , N3RD_POD_CD 
                        , N4TH_POD_CD 
                        , AGMT_SGN_OFC_CD 
                        , RHQ_CD 
                        , RGN_OFC_CD 
                        , SLS_OFC_CD 
                        , CTRT_HQ_OFC_CD 
                        , CTRT_RGN_OFC_CD 
                        , CTRT_OFC_CD 
                        , CTRT_SREP_CD 
                        , SC_NO 
                        , RFA_NO 
                        , CUST_TP_CD 
                        , BL_NO 
                        , BKG_RCV_TERM_CD 
                        , CMDT_CD 
                        , BKG_DE_TERM_CD 
                        , BKG_STS_CD 
                        , BKG_CGO_TP_CD 
                        , USA_BKG_MOD_CD 
                        , REP_CMDT_CD 
                        , SPCL_RC_FLG 
                        , SPCL_DG_CGO_FLG 
                        , SPCL_BB_CGO_FLG 
                        , SPCL_AWK_CGO_FLG 
                        , RD_FLG 
                        , SOC_FLG 
                        , SHPR_CNT_CD 
                        , SHPR_CUST_SEQ 
                        , SHPR_NM 
                        , CNEE_NM 
                        , NTFY_NM 
                        , OFT_TP_CD 
                        , OBRD_DT 
                        , CNTR_RCV_DT 
                        , SREP_CD 
                        , REV_CONTI_CD 
                        , BKG_OFC_CD 
                        , AGMT_CUST_TP_CD 
                        , AGMT_CNT_CD 
                        , AGMT_CUST_SEQ 
                        , CUST_KEY_AGMT_MGR_FLG 
                        , BKG_QTY 
                        , RA_FCGO_TZ_DYS 
                        , RA_MCGO_TZ_DYS 
                        , BKG_REV 
                        , BKG_OFT_REV 
                        , BKG_MISC_REV 
                        , SCR_CHG_REV 
                        , DMDT_COM_AMT 
                        , SLT_MGMT_UT_COM_AMT 
                        , BZC_STVG_COM_AMT 
                        , OTR_CY_HNDL_COM_AMT 
                        , TS_STVG_COM_AMT 
                        , DCK_CY_HNDL_COM_AMT 
                        , CGO_HNDL_COM_AMT 
                        , FCNTR_STO_COM_AMT 
                        , MISC_CGO_HNDL_COM_AMT 
                        , TML_COM_AMT 
                        , FULL_RAIL_DIR_COM_AMT 
                        , FULL_RAIL_TRK_COM_AMT 
                        , FULL_TRK_DIR_COM_AMT 
                        , FULL_WTR_DIR_COM_AMT 
                        , FULL_WTR_RAIL_COM_AMT 
                        , FULL_WTR_TRK_COM_AMT 
                        , FULL_TRSP_COM_AMT 
                        , MTY_STVG_PA_AMT 
                        , MTY_TRSP_PA_AMT 
                        , CGO_VAR_VOL_DC_AMT 
                        , AC_COM_AMT 
                        , CNTR_STERM_PA_AMT 
                        , CNTR_LTERM_PA_AMT 
                        , CNTR_MNR_CHG_PA_AMT 
                        , CNTR_DPC_PA_AMT 
                        , CNTR_INSUR_PA_AMT 
                        , CHSS_STERM_PA_AMT 
                        , CHSS_LTERM_PA_AMT 
                        , CHSS_MNR_CHG_PA_AMT 
                        , CHSS_DPC_PA_AMT 
                        , CHSS_DRYG_PA_AMT 
                        , CHSS_INSUR_PA_AMT 
                        , BIZ_ACT_PA_AMT 
                        , OWN_VOL_ACT_AMT 
                        , OTR_VOL_ACT_AMT 
                        , STP_INCM_AMT 
                        , STP_COST_AMT 
                        , OP_INTER_SLT_RNTL_BSE_AMT 
                        , MTY_SIM_AMT 
                        , INTER_EQ_RNTL_BSE_AMT 
                        , PA_CM_COST_TTL_AMT 
                        , PA_CM_AMT 
                        , PA_CM_PRE_BX_AMT 
                        , RA_CM_COST_TTL_AMT 
                        , RA_CM_AMT 
                        , RA_CM_PRE_BX_AMT 
                        , RA_OP_COST_TTL_AMT 
                        , RA_OP_AMT 
                        , RA_OP_PRE_BX_AMT 
                        , BKG_RMK 
                        , CRE_USR_ID 
                        , CRE_DT 
                        , UPD_USR_ID 
                        , UPD_DT 
                        , SPCL_CNTR_TPSZ_CD 
                        , BKG_CGO_WGT 
                        , BZC_SPCL_FLG 
                        , BKG_WGT_TP_CD 
                        , CHSS_FX_AMT 
                        , CNEE_CNT_CD 
                        , CNTR_FX_AMT 
                        , CNEE_CUST_SEQ 
                        , NTFY_CNT_CD 
                        , NTFY_CUST_SEQ 
                        , SC_RFA_HLD_CNT_CD 
                        , SC_RFA_HLD_CUST_SEQ 
                        , BL_NO_TP 
                        , BL_NO_CHK 
                        , SLAN_CD 
                        , DELT_FLG 
                        , ACT_OFC_CD 
                        , AUTO_RAT_DT 
                        , BKG_DEL_YD_CD 
                        , BKG_POR_YD_CD 
                        , CLT_OFC_CD 
                        , FINC_DIR_CD 
                        , N1ST_POL_POD_DYS 
                        , N2ND_POL_POD_DYS 
                        , N3RD_POL_POD_DYS 
                        , N4TH_POL_POD_DYS 
                        , TAA_NO 
                        , PPD_OFC_CD 
                        , REV_DIR_CD 
                        , VOP_CD 
                        , WRK_VVD_CD
                        , AGMT_PRC_CTRT_CUST_TP_CD
                        , RT_BL_TP_CD
                        ) 
            SELECT BKG_NO 
                   , CNTR_TPSZ_CD 
                   , COST_ROUT_NO 
                   , COST_YRMON 
                   , SLS_YRMON 
                   , COST_WK 
                   , TRD_CD 
                   , SUB_TRD_CD 
                   , RLANE_CD 
                   , IOC_CD 
                   , VSL_CD 
                   , SKD_VOY_NO 
                   , DIR_CD 
                   , N1ST_TRD_CD 
                   , N2ND_TRD_CD 
                   , N3RD_TRD_CD 
                   , N4TH_TRD_CD 
                   , N1ST_RLANE_CD 
                   , N2ND_RLANE_CD 
                   , N3RD_RLANE_CD 
                   , N4TH_RLANE_CD 
                   , N1ST_IOC_CONTI_CD 
                   , N2ND_IOC_CONTI_CD 
                   , N3RD_IOC_CONTI_CD 
                   , N4TH_IOC_CONTI_CD 
                   , N1ST_FINC_VVD_CD 
                   , N2ND_FINC_VVD_CD 
                   , N3RD_FINC_VVD_CD 
                   , N4TH_FINC_VVD_CD 
                   , BKG_POR_CD 
                   , BKG_POL_CD 
                   , BKG_POD_CD 
                   , BKG_DEL_CD 
                   , REV_POL_CD 
                   , REV_POD_CD 
                   , N1ST_POL_CD 
                   , N2ND_POL_CD 
                   , N3RD_POL_CD 
                   , N4TH_POL_CD 
                   , N1ST_POD_CD 
                   , N2ND_POD_CD 
                   , N3RD_POD_CD 
                   , N4TH_POD_CD 
                   , AGMT_SGN_OFC_CD 
                   , RHQ_CD 
                   , RGN_OFC_CD 
                   , SLS_OFC_CD 
                   , CTRT_HQ_OFC_CD 
                   , CTRT_RGN_OFC_CD 
                   , CTRT_OFC_CD 
                   , CTRT_SREP_CD 
                   , SC_NO 
                   , RFA_NO 
                   , CUST_TP_CD 
                   , BL_NO 
                   , BKG_RCV_TERM_CD 
                   , CMDT_CD 
                   , BKG_DE_TERM_CD 
                   , BKG_STS_CD 
                   , BKG_CGO_TP_CD 
                   , USA_BKG_MOD_CD 
                   , REP_CMDT_CD 
                   , SPCL_RC_FLG 
                   , SPCL_DG_CGO_FLG 
                   , SPCL_BB_CGO_FLG 
                   , SPCL_AWK_CGO_FLG 
                   , RD_FLG 
                   , SOC_FLG 
                   , SHPR_CNT_CD 
                   , SHPR_CUST_SEQ 
                   , SHPR_NM 
                   , CNEE_NM 
                   , NTFY_NM 
                   , OFT_TP_CD 
                   , OBRD_DT 
                   , CNTR_RCV_DT 
                   , SREP_CD 
                   , REV_CONTI_CD 
                   , BKG_OFC_CD 
                   , AGMT_CUST_TP_CD 
                   , AGMT_CNT_CD 
                   , AGMT_CUST_SEQ 
                   , CUST_KEY_AGMT_MGR_FLG 
                   , BKG_QTY 
                   , RA_FCGO_TZ_DYS 
                   , RA_MCGO_TZ_DYS 
                   , BKG_REV 
                   , BKG_OFT_REV 
                   , BKG_MISC_REV 
                   , SCR_CHG_REV 
                   , DMDT_COM_AMT 
                   , SLT_MGMT_UT_COM_AMT 
                   , BZC_STVG_COM_AMT 
                   , OTR_CY_HNDL_COM_AMT 
                   , TS_STVG_COM_AMT 
                   , DCK_CY_HNDL_COM_AMT 
                   , CGO_HNDL_COM_AMT 
                   , FCNTR_STO_COM_AMT 
                   , MISC_CGO_HNDL_COM_AMT 
                   , TML_COM_AMT 
                   , FULL_RAIL_DIR_COM_AMT 
                   , FULL_RAIL_TRK_COM_AMT 
                   , FULL_TRK_DIR_COM_AMT 
                   , FULL_WTR_DIR_COM_AMT 
                   , FULL_WTR_RAIL_COM_AMT 
                   , FULL_WTR_TRK_COM_AMT 
                   , FULL_TRSP_COM_AMT 
                   , MTY_STVG_PA_AMT 
                   , MTY_TRSP_PA_AMT 
                   , CGO_VAR_VOL_DC_AMT 
                   , AC_COM_AMT 
                   , CNTR_STERM_PA_AMT 
                   , CNTR_LTERM_PA_AMT 
                   , CNTR_MNR_CHG_PA_AMT 
                   , CNTR_DPC_PA_AMT 
                   , CNTR_INSUR_PA_AMT 
                   , CHSS_STERM_PA_AMT 
                   , CHSS_LTERM_PA_AMT 
                   , CHSS_MNR_CHG_PA_AMT 
                   , CHSS_DPC_PA_AMT 
                   , CHSS_DRYG_PA_AMT 
                   , CHSS_INSUR_PA_AMT 
                   , BIZ_ACT_PA_AMT 
                   , OWN_VOL_ACT_AMT 
                   , OTR_VOL_ACT_AMT 
                   , STP_INCM_AMT 
                   , STP_COST_AMT 
                   , OP_INTER_SLT_RNTL_BSE_AMT 
                   , MTY_SIM_AMT 
                   , INTER_EQ_RNTL_BSE_AMT 
                   , PA_CM_COST_TTL_AMT 
                   , PA_CM_AMT 
                   , PA_CM_PRE_BX_AMT 
                   , RA_CM_COST_TTL_AMT 
                   , RA_CM_AMT 
                   , RA_CM_PRE_BX_AMT 
                   , RA_OP_COST_TTL_AMT 
                   , RA_OP_AMT 
                   , RA_OP_PRE_BX_AMT 
                   , BKG_RMK 
                   , CRE_USR_ID 
                   , CRE_DT 
                   , UPD_USR_ID 
                   , UPD_DT 
                   , SPCL_CNTR_TPSZ_CD 
                   , BKG_CGO_WGT 
                   , BZC_SPCL_FLG 
                   , BKG_WGT_TP_CD 
                   , CHSS_FX_AMT 
                   , CNEE_CNT_CD 
                   , CNTR_FX_AMT 
                   , CNEE_CUST_SEQ 
                   , NTFY_CNT_CD 
                   , NTFY_CUST_SEQ 
                   , SC_RFA_HLD_CNT_CD 
                   , SC_RFA_HLD_CUST_SEQ 
                   , BL_NO_TP 
                   , BL_NO_CHK 
                   , SLAN_CD 
                   , DELT_FLG 
                   , ACT_OFC_CD 
                   , AUTO_RAT_DT 
                   , BKG_DEL_YD_CD 
                   , BKG_POR_YD_CD 
                   , CLT_OFC_CD 
                   , FINC_DIR_CD 
                   , N1ST_POL_POD_DYS 
                   , N2ND_POL_POD_DYS 
                   , N3RD_POL_POD_DYS 
                   , N4TH_POL_POD_DYS 
                   , TAA_NO 
                   , PPD_OFC_CD 
                   , REV_DIR_CD 
                   , VOP_CD 
                   , WRK_VVD_CD 
                   , AGMT_PRC_CTRT_CUST_TP_CD
                   , RT_BL_TP_CD
            FROM   COA_BKG_EXPN_DTL 
            WHERE  BKG_NO = BKG_LIST.BKG_NO;
            
            v_ins_cnt := v_ins_cnt + 1;
            COMMIT;
--         END IF;
         
         END IF;-- VVD정보가 있는 경우 수행 

         v_prc_cnt := v_prc_cnt + 1;

                        
         IF (v_prc_cnt MOD 1000 = 0)
         THEN
            enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'v_prc_cnt: ' || v_prc_cnt || '/' || v_prc_ttl_cnt || ' ' || trunc(v_prc_cnt / v_prc_ttl_cnt * 100) || '%', v_appl_info);
            enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'v_ins_cnt: ' || v_ins_cnt, v_appl_info);
            enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'v_err_cnt: ' || v_err_cnt, v_appl_info);
         END IF;
         
      EXCEPTION
         WHEN OTHERS
         THEN
            enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'ERROR: ' || sqlerrm, v_appl_info);
            ROLLBACK;
      END;
   END LOOP;
   
   -- Booking별 계산의 경우는 로그를 남기지 않도록 한다. A: AUTO, B: BKG NO, W: Week
   IF in_mode IN ('A', 'W')  
   THEN
       enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'v_prc_cnt: ' || v_prc_cnt || '/' || v_prc_ttl_cnt || ' ' || trunc(v_prc_cnt / v_prc_ttl_cnt * 100) || '%');
       enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'End v_ins_cnt: ' || v_ins_cnt);
       enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'End v_err_cnt: ' || v_err_cnt);
       enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', '소요시간: ' || to_char(systimestamp - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
   END IF;
   
EXCEPTION
   WHEN OTHERS
   THEN
      enis_log_prc(sysdate, 'COA_BKG_EXPN_DTL_PRC', 'ERROR: ' || sqlerrm, v_appl_info);
      RAISE;
END COA_BKG_EXPN_DTL_PRC;