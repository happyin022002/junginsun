CREATE OR REPLACE PROCEDURE OPUSADM."COA_COST_ASSIGN_COP_PRC" 
(RESULT OUT NUMBER, in_bkg_no IN VARCHAR2, usr_id IN VARCHAR2)
AUTHID CURRENT_USER
IS   
/*************************************************************************************** 
   1. Object Name      : COA_COST_ASSIGN_COP_PRC
   2. Description      : BKG 시리즈와 COP 테이블로 부터 COA_RGST_BKG, COA_COM_COST_PARA, COA_COM_PARA만들기
                         COA_BOOKING_V, SCE_COP_HDR
					     COA_RGST_BKG, COA_COM_PARA, COA_COM_COST_PARA, COA_BKG_EXPN_DTL                                     
***************************************************************************************/ 
 
--//////////////////////////////////////////////////////////////////////////////////////////////////
-- CURSOR 정의
--//////////////////////////////////////////////////////////////////////////////////////////////////
   CURSOR spcl_del_cursor(in_bkg_no VARCHAR2)
   IS
      SELECT pctl_no
            ,cntr_tpsz_cd
            ,coa_cost_src_cd
        FROM (SELECT DISTINCT a1.pctl_no
                             ,a2.cntr_tpsz_cd
                             ,DECODE(a3.spcl_cgo_dg_flg || NVL(a1.dg_spcl_flg, 'N') || 'Y', 'YYY', 'N', 'Y') dg
                             ,DECODE(a3.spcl_cgo_bb_flg || NVL(a1.bb_spcl_flg, 'N') || NVL(a4.spcl_cgo_flg, 'N'), 'YYY', 'N', 'Y') bb
                             ,DECODE(a3.spcl_cgo_rf_flg || NVL(a1.rf_spcl_flg, 'N') || DECODE(SUBSTR(a2.cntr_tpsz_cd, 1, 1), 'R', 'Y', 'N')
                                    ,'YYY', 'N'
                                    ,'Y'
                                    ) rf
                             ,DECODE(a3.spcl_cgo_awk_flg || NVL(a1.spcl_awk_cgo_flg, 'N') || NVL(a4.spcl_cgo_flg, 'N'), 'YYY', 'N', 'Y') ak
                             ,a2.coa_cost_src_cd
                         FROM coa_com_para a1, coa_com_cost_para a2, coa_cost_src_acct a3, coa_spcl_repo_cntr_rgst a4
                        WHERE a1.pctl_no = a2.pctl_no
                          AND a2.coa_cost_src_cd = a3.coa_cost_src_cd
                          AND a1.bkg_no = in_bkg_no
                          AND a2.cntr_tpsz_cd = a4.cntr_tpsz_cd
                          AND (   NVL(a1.dg_spcl_flg, 'N') = 'N'
                               OR NVL(a1.bb_spcl_flg, 'N') = 'N'
                               OR NVL(a1.rf_spcl_flg, 'N') = 'N'
                               OR NVL(a1.spcl_awk_cgo_flg, 'N') = 'N'
                              )
                          AND (   a3.spcl_cgo_dg_flg = 'Y'
                               OR a3.spcl_cgo_bb_flg = 'Y'
                               OR a3.spcl_cgo_rf_flg = 'Y'
                               OR a3.spcl_cgo_awk_flg = 'Y'))
       WHERE (    dg = 'Y'
              AND bb = 'Y'
              AND rf = 'Y'
              AND ak = 'Y');
                      
--//////////////////////////////////////////////////////////////////////////////////////////////////
-- 변수 정의
--//////////////////////////////////////////////////////////////////////////////////////////////////

   --공통변수 --------------------------------------------------------------------------------------
   v_appl_info           VARCHAR2(30);
   v_step                VARCHAR(100);
   v_log_mod_nm          VARCHAR2(30)   := 'COA_COST_ASSIGN_COP_PRC';
   v_prc_usr_id          VARCHAR2(20)   := 'SYSTEM_COP_01';
   v_prc_sys_date        DATE           := SYSDATE;
   --BKG INFO용 ------------------------------------------------------------------------------------
   v_n1st_rlane_cd       coa_bkg_expn_dtl.n1st_rlane_cd%TYPE;
   v_n2nd_rlane_cd       coa_bkg_expn_dtl.n2nd_rlane_cd%TYPE;
   v_n3rd_rlane_cd       coa_bkg_expn_dtl.n3rd_rlane_cd%TYPE;
   v_n4th_rlane_cd       coa_bkg_expn_dtl.n4th_rlane_cd%TYPE;
   v_trade1_cd           VARCHAR(3);
   v_trade2_cd           VARCHAR(3);
   v_trade3_cd           VARCHAR(3);
   v_trade4_cd           VARCHAR(3);
   v_n1st_vvd_cd         VARCHAR(10);
   v_n2nd_vvd_cd         VARCHAR(10);
   v_n3rd_vvd_cd         VARCHAR(10);
   v_n4th_vvd_cd         VARCHAR(10);
   v_pol_conti1          VARCHAR(1);
   v_pol_conti2          VARCHAR(1);
   v_pol_conti3          VARCHAR(1);
   v_pol_conti4          VARCHAR(1);
   v_pod_conti1          VARCHAR(1);
   v_pod_conti2          VARCHAR(1);
   v_pod_conti3          VARCHAR(1);
   v_pod_conti4          VARCHAR(1);
   v_rank                NUMBER(1);
   v_svc_mode_cd         VARCHAR(5);
   v_rev_lane_cd         VARCHAR(5);
   v_rev_trade_cd        VARCHAR(3);
   v_rev_ioc_cd          VARCHAR(1);
   v_rev_vvd             VARCHAR(10);
   v_x_rev_vvd           VARCHAR(9);
   --full cargo days 용 data-------------------------------------------------------------------------
   v_full_cargo_dys      NUMBER(3);
   v_error               NUMBER(1); -- days가 없을 시 error 발생
   
    -- 기준년월
    v_bzc_cost_yrmon      VARCHAR(6); 
    v_user_info           VARCHAR(30); 
    
    v_memo_split          VARCHAR(1);
    v_agmt_prc_ctrt_cust_tp_cd pri_taa_mn.prc_ctrt_cust_tp_cd%type; 
BEGIN

--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 시작 정보 출력
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_appl_info := in_bkg_no;
   IF usr_id <> 'SYSTEM_COA' AND usr_id <> 'SYS_COA_BAT_M' THEN
        v_user_info := ', usr_id:'|| usr_id;
   END IF;
   enis_log_prc('', v_log_mod_nm, '==== START : v.20100520 ====' || v_user_info , v_appl_info);

   
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 기준 년월을 조회한다.
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   SELECT coa_bzc_cost_yrmon_fnc(in_bkg_no) bzc_cost_yrmon
     INTO v_bzc_cost_yrmon
     FROM dual;
   
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 항로우선순위/Reveneu conversion  작업처리 및 변수정의
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   v_step := '항로우선순위/Reveneu conversion  작업처리 및 변수정의';
  --BKG_BKG_VVD에 REV_VVD가 있는 경우, 없는 경우 나누어서 처리함
   SELECT v_n1st_rlane_cd
         ,v_n2nd_rlane_cd
         ,v_n3rd_rlane_cd
         ,v_n4th_rlane_cd
         ,v_trade1_cd
         ,v_trade2_cd
         ,v_trade3_cd
         ,v_trade4_cd
         ,v_pol_conti1
         ,v_pol_conti2
         ,v_pol_conti3
         ,v_pol_conti4
         ,v_pod_conti1
         ,v_pod_conti2
         ,v_pod_conti3
         ,v_pod_conti4
         ,v_rank
         ,v_svc_mode_cd
         ,DECODE(v_rank, 1, v_n1st_rlane_cd, 2, v_n2nd_rlane_cd, 3, v_n3rd_rlane_cd, v_n4th_rlane_cd) AS v_rev_lane_cd
         ,DECODE(v_rank, 1, v_trade1_cd,     2, v_trade2_cd,     3, v_trade3_cd,     v_trade4_cd)     AS v_rev_trade_cd
         ,DECODE(v_rank, 1, v_n1st_ioc_cd,   2, v_n2nd_ioc_cd,   3, v_n3rd_ioc_cd,   v_n4th_ioc_cd)   AS v_rev_ioc_cd
         ,DECODE(v_rank, 1, v_n1st_vvd_cd,   2, v_n2nd_vvd_cd,   3, v_n3rd_vvd_cd,   v_n4th_vvd_cd)   AS v_rev_vvd --재무항차가 들어있는 VVD
         ,DECODE(v_rank, 1, vvd1,     2, vvd2,    3, vvd3,     vvd4)    AS v_x_rev_vvd --일반 VVD
         ,v_n1st_vvd_cd --재무항차가 들어있는 VVD
         ,v_n2nd_vvd_cd
         ,v_n3rd_vvd_cd
         ,v_n4th_vvd_cd
     INTO v_n1st_rlane_cd
         ,v_n2nd_rlane_cd
         ,v_n3rd_rlane_cd
         ,v_n4th_rlane_cd
         ,v_trade1_cd
         ,v_trade2_cd
         ,v_trade3_cd
         ,v_trade4_cd
         ,v_pol_conti1
         ,v_pol_conti2
         ,v_pol_conti3
         ,v_pol_conti4
         ,v_pod_conti1
         ,v_pod_conti2
         ,v_pod_conti3
         ,v_pod_conti4
         ,v_rank
         ,v_svc_mode_cd
         ,v_rev_lane_cd
         ,v_rev_trade_cd
         ,v_rev_ioc_cd
         ,v_rev_vvd
         ,v_x_rev_vvd
         ,v_n1st_vvd_cd
         ,v_n2nd_vvd_cd
         ,v_n3rd_vvd_cd
         ,v_n4th_vvd_cd
     FROM (SELECT d1.*
                 ,coa_rank_info_fnc( v_n1st_rlane_cd
                                    ,v_n2nd_rlane_cd
                                    ,v_n3rd_rlane_cd
                                    ,v_n4th_rlane_cd
                                    ,DECODE(v_n1st_ioc_cd, 'I', 'I' || v_pod_conti1, 'OO') 
                                    ,DECODE(v_n2nd_ioc_cd, 'I', 'I' || v_pod_conti2, 'OO') 
                                    ,DECODE(v_n3rd_ioc_cd, 'I', 'I' || v_pod_conti3, 'OO') 
                                    ,DECODE(v_n4th_ioc_cd, 'I', 'I' || v_pod_conti4, 'OO') 
                                   ) AS v_rank                  
             FROM (SELECT c5.v_n1st_rlane_cd
                         ,c5.v_n2nd_rlane_cd
                         ,c5.v_n3rd_rlane_cd
                         ,c5.v_n4th_rlane_cd
                         ,c5.v_svc_mode_cd
                         ,c5.v_trade1_cd
                         ,c5.v_trade2_cd
                         ,c5.v_trade3_cd
                         ,c5.v_trade4_cd
                         ,c5.v_n1st_vvd_cd
                         ,c5.v_n2nd_vvd_cd
                         ,c5.v_n3rd_vvd_cd
                         ,c5.v_n4th_vvd_cd
                         ,c5.vvd1
                         ,c5.vvd2
                         ,c5.vvd3
                         ,c5.vvd4
                         ,c5.v_pol_conti1 v_pol_conti1
                         ,c5.v_pol_conti2 v_pol_conti2
                         ,c5.v_pol_conti3 v_pol_conti3
                         ,c5.v_pol_conti4 v_pol_conti4
                         ,c5.v_pod_conti1 v_pod_conti1
                         ,c5.v_pod_conti2 v_pod_conti2
                         ,c5.v_pod_conti3 v_pod_conti3
                         ,c5.v_pod_conti4 v_pod_conti4
                         ,c1.ioc_cd AS v_n1st_ioc_cd
                         ,c2.ioc_cd AS v_n2nd_ioc_cd
                         ,c3.ioc_cd AS v_n3rd_ioc_cd
                         ,c4.ioc_cd AS v_n4th_ioc_cd
                         ,bkg_rev_vvd
                     FROM (SELECT rlane1 AS v_n1st_rlane_cd
                                 ,DECODE(slan2, '', NULL, rlane2) AS v_n2nd_rlane_cd
                                 ,DECODE(slan3,  '', NULL, rlane3) AS v_n3rd_rlane_cd
                                 ,DECODE(slan4, '', NULL, rlane4) AS v_n4th_rlane_cd
                                 ,coa_usa_mode_fnc(BKG_RCV_TERM_CD, BKG_DE_TERM_CD, bkg_por_cd, bkg_pol_cd, bkg_pod_cd, bkg_del_cd) AS v_svc_mode_cd
                                 ,trd1 AS v_trade1_cd
                                 ,DECODE(slan2, '', NULL, trd2) AS v_trade2_cd
                                 ,DECODE(slan3, '', NULL, trd3) AS v_trade3_cd
                                 ,DECODE(slan4, '', NULL, trd4) AS v_trade4_cd
                                 ,vvd1 || NVL(DECODE(slan1, '', NULL, rev_dir1), dir1) AS v_n1st_vvd_cd
                                 ,vvd2 || NVL(DECODE(slan2, '', NULL, rev_dir2), dir2) AS v_n2nd_vvd_cd
                                 ,vvd3 || NVL(DECODE(slan3, '', NULL, rev_dir3), dir3) AS v_n3rd_vvd_cd
                                 ,vvd4 || NVL(DECODE(slan4, '', NULL, rev_dir4), dir4) AS v_n4th_vvd_cd
                                 ,vvd1
                                 ,vvd2
                                 ,vvd3
                                 ,vvd4
                                 ,pol_conti1 AS v_pol_conti1
                                 ,pol_conti2 AS v_pol_conti2
                                 ,pol_conti3 AS v_pol_conti3
                                 ,pol_conti4 AS v_pol_conti4
                                 ,pod_conti1 AS v_pod_conti1
                                 ,pod_conti2 AS v_pod_conti2
                                 ,pod_conti3 AS v_pod_conti3
                                 ,pod_conti4 AS v_pod_conti4
                                 ,dir1
                                 ,dir2
                                 ,dir3
                                 ,dir4
                                 ,bkg_rev_vvd
                             FROM (SELECT n1st_slan_cd AS slan1
                                         ,n2nd_slan_cd AS slan2
                                         ,n3rd_slan_cd AS slan3
                                         ,n4th_slan_cd AS slan4
                                         ,n1st_vvd AS vvd1
                                         ,n2nd_vvd AS vvd2
                                         ,n3rd_vvd AS vvd3
                                         ,n4th_vvd AS vvd4
                                         ,coa_slane_rlane_conv_fnc(n1st_vvd, n1st_slan_cd, n1st_pol_cd, n1st_pod_cd) AS rlane1
                                         ,coa_slane_rlane_conv_fnc(n2nd_vvd, n2nd_slan_cd, n2nd_pol_cd, n2nd_pod_cd) AS rlane2
                                         ,coa_slane_rlane_conv_fnc(n3rd_vvd, n3rd_slan_cd, n3rd_pol_cd, n3rd_pod_cd) AS rlane3
                                         ,coa_slane_rlane_conv_fnc(n4th_vvd, n4th_slan_cd, n4th_pol_cd, n4th_pod_cd) AS rlane4
                                         ,n1st_pol_conti AS pol_conti1
                                         ,n2nd_pol_conti AS pol_conti2
                                         ,n3rd_pol_conti AS pol_conti3
                                         ,n4th_pol_conti AS pol_conti4
                                         ,n1st_pod_conti AS pod_conti1
                                         ,n2nd_pod_conti AS pod_conti2
                                         ,n3rd_pod_conti AS pod_conti3
                                         ,n4th_pod_conti AS pod_conti4
                                         ,BKG_RCV_TERM_CD
                                         ,BKG_DE_TERM_CD
                                         ,bkg_por_cd
                                         ,bkg_pol_cd
                                         ,bkg_pod_cd
                                         ,bkg_del_cd
                                         ,coa_rlane_trd_conv_fnc(n1st_vvd, n1st_slan_cd, n1st_pol_cd, n1st_pod_cd) AS trd1
                                         ,coa_rlane_trd_conv_fnc(n2nd_vvd, n2nd_slan_cd, n2nd_pol_cd, n2nd_pod_cd) AS trd2
                                         ,coa_rlane_trd_conv_fnc(n3rd_vvd, n3rd_slan_cd, n3rd_pol_cd, n3rd_pod_cd) AS trd3
                                         ,coa_rlane_trd_conv_fnc(n4th_vvd, n4th_slan_cd, n4th_pol_cd, n4th_pod_cd) AS trd4
                                         ,coa_rev_dir_conv_fnc(n1st_slan_cd,  n1st_pol_cd,  SUBSTR(n1st_vvd, 9, 1)) AS rev_dir1
                                         ,coa_rev_dir_conv_fnc(n2nd_slan_cd, n2nd_pol_cd, SUBSTR(n2nd_vvd, 9, 1)) AS rev_dir2
                                         ,coa_rev_dir_conv_fnc(n3rd_slan_cd,  n3rd_pol_cd,  SUBSTR(n3rd_vvd, 9, 1)) AS rev_dir3
                                         ,coa_rev_dir_conv_fnc(n4th_slan_cd, n4th_pol_cd, SUBSTR(n4th_vvd, 9, 1)) AS rev_dir4                                         
                                         ,SUBSTR(n1st_vvd, 9, 1) AS dir1
                                         ,SUBSTR(n2nd_vvd, 9, 1) AS dir2
                                         ,SUBSTR(n3rd_vvd, 9, 1) AS dir3
                                         ,SUBSTR(n4th_vvd, 9, 1) AS dir4
                                         ,bkg_rev_vvd
                                     FROM coa_booking_v
                                    WHERE bkg_no = in_bkg_no)
                          ) c5
                         ,mdm_dtl_rev_lane c1
                         ,mdm_dtl_rev_lane c2
                         ,mdm_dtl_rev_lane c3
                         ,mdm_dtl_rev_lane c4
                    WHERE c1.rlane_cd(+) = c5.v_n1st_rlane_cd
                      AND c1.vsl_slan_dir_cd(+) = CASE WHEN c5.v_n1st_rlane_cd = 'RBCCO' AND c5.dir1 <> 'W' THEN 'E' ELSE c5.dir1 END  -- RBCCO의 경우는 E로 DIR을 변경함.
                      AND c1.fm_conti_cd(+) = c5.v_pol_conti1
                      AND c1.to_conti_cd(+) = c5.v_pod_conti1
                      AND c1.trd_cd(+) = c5.v_trade1_cd
                      AND c1.delt_flg(+) = 'N'
                      AND c2.rlane_cd(+) = c5.v_n2nd_rlane_cd
                      AND c2.vsl_slan_dir_cd(+) = CASE WHEN c5.v_n2nd_rlane_cd = 'RBCCO' AND c5.dir2 <> 'W' THEN 'E' ELSE c5.dir2 END 
                      AND c2.fm_conti_cd(+) = c5.v_pol_conti2
                      AND c2.to_conti_cd(+) = c5.v_pod_conti2
                      AND c2.trd_cd(+) = c5.v_trade2_cd
                      AND c2.delt_flg(+) = 'N'
                      AND c3.rlane_cd(+) = c5.v_n3rd_rlane_cd
                      AND c3.vsl_slan_dir_cd(+) = CASE WHEN c5.v_n3rd_rlane_cd = 'RBCCO' AND c5.dir3 <> 'W' THEN 'E' ELSE c5.dir3 END
                      AND c3.fm_conti_cd(+) = c5.v_pol_conti3
                      AND c3.to_conti_cd(+) = c5.v_pod_conti3
                      AND c3.trd_cd(+) = c5.v_trade3_cd
                      AND c3.delt_flg(+) = 'N'
                      AND c4.rlane_cd(+) = c5.v_n4th_rlane_cd
                      AND c4.vsl_slan_dir_cd(+) = CASE WHEN c5.v_n4th_rlane_cd = 'RBCCO' AND c5.dir4 <> 'W' THEN 'E' ELSE c5.dir4 END 
                      AND c4.fm_conti_cd(+) = c5.v_pol_conti4
                      AND c4.to_conti_cd(+) = c5.v_pod_conti4
                      AND c4.trd_cd(+) = c5.v_trade4_cd
                      AND c4.delt_flg(+) = 'N'
                  ) d1
          ); 
 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   /*  AOM Ticket ID : CHM-201004764-01                                                                                                           
   TAA > SC > RFA 계약순으로 prc_ctrt_cust_tp_cd 정보를 가지고 온다
   가지고 올 때 BKG_RATE 테이블의 RT_APLY_DT 날짜가 포함되는 계약정보를 가지고 오며 
   다수의 ROW가 조회시 최근 계약정보를 가지고 온다
     ==> bkg_no 건당 기간을 달리한 데이타만 존재
  */
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  BEGIN
      WITH TEMP_T AS (SELECT br.bkg_no, br.rt_aply_dt
                        FROM   bkg_rate br
                        WHERE  1 = 1 
                        AND    br.bkg_no = in_bkg_no
                        UNION ALL 
                        SELECT in_bkg_no AS bkg_no, NULL AS rt_aply_dt FROM DUAL
                        )
      SELECT COALESCE((SELECT c.prc_ctrt_cust_tp_cd       --TAA
                      FROM   bkg_booking a
                            ,pri_taa_hdr b
                            ,pri_taa_mn  c
                      WHERE  a.taa_no = b.taa_no 
                      AND    a.bkg_no = t.bkg_no
                      AND    b.taa_prop_no = c.taa_prop_no 
                      AND    c.cfm_flg = 'Y' 
                      AND    c.exp_dt = (SELECT MAX(C2.EXP_DT) 
                                        FROM    pri_taa_mn  c2 
                                        WHERE   C2.cfm_flg = 'Y' 
                                        AND     c.taa_prop_no =c2.taa_prop_no 
                                        AND    NVL(t.rt_aply_dt,TO_DATE('21000101','YYYYMMDD')) >= trunc(c2.eff_dt) 
                                        AND    NVL(t.rt_aply_dt,TO_DATE('10000101','YYYYMMDD')) <= trunc(c2.exp_dt) + 0.99999
                                        )
                      AND    NVL(t.rt_aply_dt,TO_DATE('21000101','YYYYMMDD')) >= trunc(c.eff_dt) 
                      AND    NVL(t.rt_aply_dt,TO_DATE('10000101','YYYYMMDD')) <= trunc(c.exp_dt) + 0.99999
                      
                      AND    ROWNUM =1)
                    , (SELECT e.prc_ctrt_cust_tp_cd        --SC
                        FROM   bkg_booking         a
                              ,pri_sp_hdr          b
                              ,pri_sp_mn           c
                              ,pri_sp_ctrt_pty     d
                              ,pri_sp_ctrt_cust_tp e
                        WHERE  a.sc_no = b.sc_no 
                        AND    a.bkg_no = t.bkg_no
                        AND    b.prop_no = c.prop_no 
                        AND    c.prop_sts_cd = 'F' 
                        AND    c.prop_no = d.prop_no 
                        AND    c.amdt_seq = d.amdt_seq 
                        AND    d.prc_ctrt_pty_tp_cd = 'C' 
                        AND    c.prop_no = e.prop_no 
                        AND    c.amdt_seq = e.amdt_seq 
                        AND    c.exp_dt = (SELECT MAX(C2.EXP_DT) 
                                          FROM    pri_sp_mn  c2 
                                          WHERE   c2.prop_sts_cd = 'F' 
                                          AND     c.prop_no =c2.prop_no 
                                          AND     C2.AMDT_SEQ = C.AMDT_SEQ 
                                          AND    NVL(t.rt_aply_dt,TO_DATE('21000101','YYYYMMDD')) >= trunc(c2.eff_dt) 
                                          AND    NVL(t.rt_aply_dt,TO_DATE('10000101','YYYYMMDD')) <= trunc(c2.exp_dt) + 0.99999
                                          )
                        AND    NVL(t.rt_aply_dt,TO_DATE('21000101','YYYYMMDD')) >= trunc(c.eff_dt) 
                        AND    NVL(t.rt_aply_dt,TO_DATE('10000101','YYYYMMDD')) <= trunc(c.exp_dt) + 0.99999
                        AND    ROWNUM =1)  
                    , (SELECT c.prc_ctrt_cust_tp_cd         --RFA 
                        FROM   bkg_booking a
                              ,pri_rp_hdr  b
                              ,pri_rp_mn   c
                        WHERE  a.rfa_no = b.rfa_no 
                        AND    a.bkg_no = t.bkg_no
                        AND    b.prop_no = c.prop_no 
                        AND    c.prop_sts_cd = 'A' 
                        AND    c.exp_dt = (SELECT MAX(C2.EXP_DT) 
                                          FROM    pri_rp_mn  c2 
                                          WHERE   c2.prop_sts_cd = 'A' 
                                          AND     c2.prop_no =c.prop_no 
                                          AND     NVL(t.rt_aply_dt,TO_DATE('21000101','YYYYMMDD')) >= trunc(c2.eff_dt) 
                                          AND     NVL(t.rt_aply_dt,TO_DATE('10000101','YYYYMMDD')) <= trunc(c2.exp_dt) + 0.99999
                                          )
                        AND    NVL(t.rt_aply_dt,TO_DATE('21000101','YYYYMMDD')) >= trunc(c.eff_dt) 
                        AND    NVL(t.rt_aply_dt,TO_DATE('10000101','YYYYMMDD')) <= trunc(c.exp_dt) + 0.99999
                        AND    ROWNUM =1)
                    )
      INTO   v_agmt_prc_ctrt_cust_tp_cd                      
      FROM   TEMP_T T
      WHERE  ROWNUM =1;
  EXCEPTION
    WHEN OTHERS THEN
        v_agmt_prc_ctrt_cust_tp_cd := NULL;
        
  END;          
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- COA_RGST_BKG MERGE 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   v_step := 'COA_RGST_BKG MERGE'; 
   --enis_log_prc (SYSDATE,'coa_cost_assign_cop_prc', v_step, v_appl_info); 
   MERGE INTO coa_rgst_bkg b1
      USING (WITH coa_ofc_lvl2 AS (SELECT ofc_n2nd_lvl_cd as root2 ,ofc_n4th_lvl_cd as root4 ,ofc_cd FROM  coa_ofc_lvl WHERE v_bzc_cost_yrmon BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON)
             SELECT a1.bkg_no
                   ,NVL(v_rev_trade_cd, 'IAS') trd_cd
                   ,v_rev_ioc_cd ioc_cd
                   ,DECODE(SUBSTR(v_rev_lane_cd, 1, 3), 'RBC', NVL(a6.fdyy, 'CFDR'), SUBSTR(v_x_rev_vvd, 1, 4)) vsl_cd
                   ,DECODE(SUBSTR(v_rev_lane_cd, 1, 3), 'RBC', NVL((a6.mmdd), NULL), SUBSTR(v_x_rev_vvd, 5, 4)) skd_voy_no
                   ,DECODE(SUBSTR(v_rev_lane_cd, 1, 3), 'RBC', 'E', NVL(SUBSTR(v_x_rev_vvd, 9, 1), 'E')) dir_cd
                   ,v_rev_lane_cd rlane_cd 
                   ,a1.slan_cd
                   ,a1.bl_no                   
                   ,NVL(a1.bl_no_tp, '0') bl_no_tp
                   ,a2.root2 rhq_cd   --20080303
                   ,a2.root4 rgn_ofc_cd    
                   ,a1.sls_ofc_cd 
                   ,a1.bkg_sts_cd 
                   ,a1.bkg_cgo_tp_cd 
                   ,a1.bkg_por_cd
                   ,a1.bkg_pol_cd
                   ,a1.bkg_ofc_cd 
                   ,a1.bkg_pod_cd
                   ,a1.bkg_del_cd
                   ,a1.bkg_rcv_term_cd 
                   ,a1.bkg_de_term_cd 
                   ,a1.rep_cmdt_cd 
                   ,a1.cmdt_cd
                   ,v_n1st_vvd_cd n1st_finc_vvd_cd
                   ,v_n2nd_vvd_cd n2nd_finc_vvd_cd
                   ,v_n3rd_vvd_cd n3rd_finc_vvd_cd
                   ,v_n4th_vvd_cd n4th_finc_vvd_cd
                   ,a1.n1st_pol_cd
                   ,a1.n2nd_pol_cd
                   ,a1.n3rd_pol_cd
                   ,a1.n4th_pol_cd
                   ,a1.n1st_pod_cd
                   ,a1.n2nd_pod_cd
                   ,a1.n3rd_pod_cd
                   ,a1.n4th_pod_cd
                   ,DECODE(v_n1st_rlane_cd, NULL, DECODE(a1.n1st_pod_cd, NULL, NULL, 'RBCCO'), v_n1st_rlane_cd) n1st_rlane_cd
                   ,DECODE(v_n2nd_rlane_cd, NULL, DECODE(a1.n2nd_pod_cd, NULL, NULL, 'RBCCO'), v_n2nd_rlane_cd) n2nd_rlane_cd
                   ,DECODE(v_n3rd_rlane_cd, NULL, DECODE(a1.n3rd_pod_cd, NULL, NULL, 'RBCCO'), v_n3rd_rlane_cd) n3rd_rlane_cd
                   ,DECODE(v_n4th_rlane_cd, NULL, DECODE(a1.n4th_pod_cd, NULL, NULL, 'RBCCO'), v_n4th_rlane_cd) n4th_rlane_cd
                   ,DECODE(LENGTH(LTRIM(v_pol_conti1 || v_pod_conti1)), 1, NULL, v_pol_conti1 || v_pod_conti1) n1st_ioc_conti_cd
                   ,DECODE(LENGTH(LTRIM(v_pol_conti2 || v_pod_conti2)), 1, NULL, v_pol_conti2 || v_pod_conti2) n2nd_ioc_conti_cd
                   ,DECODE(LENGTH(LTRIM(v_pol_conti3 || v_pod_conti3)), 1, NULL, v_pol_conti3 || v_pod_conti3) n3rd_ioc_conti_cd
                   ,DECODE(LENGTH(LTRIM(v_pol_conti4 || v_pod_conti4)), 1, NULL, v_pol_conti4 || v_pod_conti4) n4th_ioc_conti_cd
                   ,v_trade1_cd n1st_trd_cd
                   ,v_trade2_cd n2nd_trd_cd
                   ,v_trade3_cd n3rd_trd_cd
                   ,v_trade4_cd n4th_trd_cd
                   ,a1.shpr_cnt_cd
                   ,a1.shpr_cust_seq
                   ,a1.shpr_nm
                   ,a1.cnee_nm
                   ,a1.ntfy_nm
                   ,a1.bkg_cgo_wgt
                   ,a1.bkg_wgt_tp_cd
                   ,DECODE(a1.spcl_dg_cgo_flg, 'Y', 'Y', '1', 'Y', 'N') spcl_dg_cgo_flg
                   ,DECODE(a1.spcl_rc_flg, 'Y', 'Y', '1', 'Y', 'N') spcl_rc_flg
                   ,DECODE(a1.spcl_awk_cgo_flg, 'Y', 'Y', '1', 'Y', 'N') spcl_awk_cgo_flg
                   ,DECODE(a1.spcl_bb_cgo_flg, 'Y', 'Y', '1', 'Y', 'N') spcl_bb_cgo_flg
                   ,DECODE(a1.rd_flg, 'Y', 'Y', '1', 'Y', 'N') rd_flg
                   ,DECODE(a1.soc_flg, 'Y', 'Y', '1', 'Y', 'N') soc_flg
                   ,DECODE(v_rank, 1, a1.n1st_pol_cd, 2, a1.n2nd_pol_cd, 3, a1.n3rd_pol_cd, a1.n4th_pol_cd) rev_pol_cd
                   ,DECODE(v_rank, 1, a1.n1st_pod_cd, 2, a1.n2nd_pod_cd, 3, a1.n3rd_pod_cd, a1.n4th_pod_cd) rev_pod_cd
                   ,usr_id cre_usr_id
                   ,v_prc_sys_date cre_dt
                   ,usr_id upd_usr_id
                   ,v_prc_sys_date upd_dt
                   ,a1.bkg_por_yd_cd
                   ,a1.bkg_del_yd_cd
                   ,a1.ppd_ofc_cd
                   ,a1.clt_ofc_cd
                   ,a1.sc_no
                   ,a1.rfa_no
                   ,a1.oft_tp_cd 
                   ,a1.obrd_dt 
                   /*
                     AOM Ticket ID : CHM-201004764-01 
                     COA_COST_ASSIGN_COP_PRC 프로시저의 COA_RGST_BKG테이블에 입력 후 CGO_RCV_DT가 없을 경우 BKG_CONTAINER 테이블의 MAX CGO_RCV_DT 데이터를 가지고 와서 입력해 준다.
                    */
                   ,DECODE(a1.cntr_rcv_dt,NULL,(SELECT MAX(BC.CGO_RCV_DT) FROM BKG_CONTAINER BC WHERE BC.BKG_NO = A1.BKG_NO),a1.cntr_rcv_dt) AS cntr_rcv_dt
                   ,a6.yyyymmdd auto_rat_dt 
                   ,a1.CUST_KEY_AGMT_MGR_FLG
                   ,a1.cust_tp_cd
                   ,NVL(TRIM(a1.ctrt_ofc_cd), a1.sls_ofc_cd) agmt_sgn_ofc_cd   --20080303, coa_booking_v의 ctrt_ofc_cd가 이미 bkg_booking의 ctrt_ofc_cd임
                   ,DECODE(v_rank
                          ,1, DECODE(v_pol_conti1, v_pod_conti1, 'I' || v_pod_conti1, 'OO')
                          ,2, DECODE(v_pol_conti2, v_pod_conti2, 'I' || v_pod_conti2, 'OO')
                          ,3, DECODE(v_pol_conti3, v_pod_conti3, 'I' || v_pod_conti3, 'OO')
                          ,4, DECODE(v_pol_conti4, v_pod_conti4, 'I' || v_pod_conti4, 'OO')
                          ,NULL
                          ) rev_conti_cd
                   ,DECODE(SUBSTR(v_rev_lane_cd, 1, 3), 'RBC', 'EE', NVL(SUBSTR(v_rev_vvd, -2), 'EE')) finc_dir_cd
                   ,DECODE(SUBSTR(v_rev_lane_cd, 1, 3), 'RBC', 'E', NVL(SUBSTR(v_rev_vvd, -1), 'E')) rev_dir_cd
                   ,v_svc_mode_cd usa_bkg_mod_cd
                   ,DECODE(SUBSTR(v_rev_lane_cd, 1, 3), 'RBC', v_n1st_vvd_cd, v_rev_vvd) wrk_vvd_cd
                   ,a1.SREP_CD
                   ,a1.ctrt_ofc_cd
                   ,a1.ctrt_srep_cd
                   ,coa_vsl_port_days_fnc(SUBSTR(v_n1st_vvd_cd, 1, 4)
                                         ,SUBSTR(v_n1st_vvd_cd, 5, 4)
                                         ,SUBSTR(v_n1st_vvd_cd, 9, 1)
                                         ,a1.n1st_pol_cd
                                         ,a1.n1st_pod_cd
                                         ) n1st_pol_pod_dys
                   ,coa_vsl_port_days_fnc(SUBSTR(v_n2nd_vvd_cd, 1, 4)
                                         ,SUBSTR(v_n2nd_vvd_cd, 5, 4)
                                         ,SUBSTR(v_n2nd_vvd_cd, 9, 1)
                                         ,a1.n2nd_pol_cd
                                         ,a1.n2nd_pod_cd
                                         ) n2nd_pol_pod_dys
                   ,coa_vsl_port_days_fnc(SUBSTR(v_n3rd_vvd_cd, 1, 4)
                                         ,SUBSTR(v_n3rd_vvd_cd, 5, 4)
                                         ,SUBSTR(v_n3rd_vvd_cd, 9, 1)
                                         ,a1.n3rd_pol_cd
                                         ,a1.n3rd_pod_cd
                                         ) n3rd_pol_pod_dys
                   ,coa_vsl_port_days_fnc(SUBSTR(v_n4th_vvd_cd, 1, 4)
                                         ,SUBSTR(v_n4th_vvd_cd, 5, 4)
                                         ,SUBSTR(v_n4th_vvd_cd, 9, 1)
                                         ,a1.n4th_pol_cd
                                         ,a1.n4th_pod_cd
                                         ) n4th_pol_pod_dys
                   ,a1.KR_CSTMS_CUST_TP_CD agmt_cust_tp_cd --BKG_BKG_MISC에서 BKG_BOOKING으로 변경              
                   ,a1.CTRT_CUST_CNT_CD agmt_cnt_cd --BKG_BKG_RT에서 BKG_BOOKING으로 변경   
                   ,a1.CTRT_CUST_SEQ agmt_cust_seq  --BKG_BKG_RT에서 BKG_BOOKING으로 변경                           
                   ,a5.root2 ctrt_hq_ofc_cd   --20080303
                   ,a5.root4 ctrt_rgn_ofc_cd   
                   ,a1.CNEE_CNT_CD
                   ,a1.cnee_cust_seq
                   ,A1.TAA_NO
                   ,A1.NTFY_CNT_CD
                   ,A1.NTFY_CUST_SEQ                   
--                   TAA_NO, NTFY_CNT_CD, NTFY_CUST_SEQ, SC_RFA_HLD_CNT_CD, SC_RFA_HLD_CUST_SEQ, SUB_TRD_CD
                   ,v_agmt_prc_ctrt_cust_tp_cd  AS agmt_prc_ctrt_cust_tp_cd 
                   ,A1.RT_BL_TP_CD          
               FROM coa_booking_v a1
                   ,coa_ofc_lvl2 a2 --RHQ_CD, RGN_OFC_CD
                   ,coa_ofc_lvl2 a5 --CTRT_HQ_OFC_CD, CTRT_RGN_OFC_CD
                   ,(SELECT 'FD' || TO_CHAR(MAX(z2.cre_dt), 'YY') fdyy
                            ,TO_CHAR(MAX(z2.cre_dt), 'MMDD') mmdd
                            ,TO_CHAR(MAX(z2.cre_dt), 'YYYYMMDD') yyyymmdd 
                       FROM bkg_rate z1, bkg_vvd z2
                      WHERE z2.bkg_no          = in_bkg_no
                        AND z1.bkg_no(+)       = z2.bkg_no) a6                      
              WHERE a1.bkg_no = in_bkg_no
                AND a2.ofc_cd(+) = a1.sls_ofc_cd
                AND a5.ofc_cd(+) = NVL(a1.ctrt_ofc_cd, a1.sls_ofc_cd)
                ) b2
      ON (    b1.bkg_no = b2.bkg_no)
      WHEN NOT MATCHED THEN 
         INSERT(b1.bkg_no, b1.trd_cd, b1.rlane_cd, b1.ioc_cd, b1.vsl_cd, b1.skd_voy_no, b1.dir_cd, b1.rev_conti_cd, b1.finc_dir_cd 
               ,b1.slan_cd, b1.bl_no, b1.bl_no_tp, b1.rgn_ofc_cd, b1.rhq_cd, b1.sls_ofc_cd, b1.usa_bkg_mod_cd, b1.bkg_sts_cd 
               ,b1.bkg_cgo_tp_cd, b1.bkg_por_cd, b1.bkg_por_yd_cd, b1.bkg_pol_cd, b1.bkg_ofc_cd, b1.bkg_pod_cd, b1.bkg_del_cd, b1.bkg_del_yd_cd 
               ,b1.bkg_rcv_term_cd, b1.bkg_de_term_cd, b1.rep_cmdt_cd, b1.cmdt_cd, b1.ppd_ofc_cd, b1.clt_ofc_cd, b1.n1st_finc_vvd_cd 
               ,b1.n2nd_finc_vvd_cd, b1.n3rd_finc_vvd_cd, b1.n4th_finc_vvd_cd, b1.n1st_pol_cd, b1.n2nd_pol_cd, b1.n3rd_pol_cd, b1.n4th_pol_cd 
               ,b1.n1st_pod_cd, b1.n2nd_pod_cd, b1.n3rd_pod_cd, b1.n4th_pod_cd, b1.n1st_rlane_cd, b1.n2nd_rlane_cd, b1.n3rd_rlane_cd 
               ,b1.n4th_rlane_cd, b1.n1st_ioc_conti_cd, b1.n2nd_ioc_conti_cd, b1.n3rd_ioc_conti_cd, b1.n4th_ioc_conti_cd, b1.n1st_trd_cd 
               ,b1.n2nd_trd_cd, b1.n3rd_trd_cd, b1.n4th_trd_cd, b1.n1st_pol_pod_dys, b1.n2nd_pol_pod_dys, b1.n3rd_pol_pod_dys, b1.n4th_pol_pod_dys 
               ,b1.shpr_cnt_cd, b1.shpr_cust_seq, b1.shpr_nm, b1.cnee_nm, b1.ntfy_nm, b1.sc_no, b1.rfa_no, b1.cust_tp_cd, b1.agmt_cust_tp_cd 
               ,b1.agmt_cnt_cd, b1.agmt_cust_seq, b1.agmt_sgn_ofc_cd, b1.cust_key_agmt_mgr_flg, b1.oft_tp_cd, b1.obrd_dt, b1.cntr_rcv_dt, b1.srep_cd 
               ,b1.rev_pol_cd, b1.rev_pod_cd, b1.bkg_cgo_wgt, b1.bkg_wgt_tp_cd, b1.auto_rat_dt, b1.spcl_rc_flg, b1.spcl_dg_cgo_flg 
               ,b1.spcl_bb_cgo_flg, b1.spcl_awk_cgo_flg, b1.rd_flg, b1.soc_flg, b1.rev_dir_cd, b1.cre_usr_id, b1.cre_dt, b1.upd_usr_id, b1.upd_dt 
               ,b1.wrk_vvd_cd, b1.ctrt_ofc_cd, b1.ctrt_srep_cd, b1.ctrt_hq_ofc_cd, b1.ctrt_rgn_ofc_cd, b1.cnee_cnt_cd, b1.cnee_cust_seq
               ,b1.taa_no, b1.ntfy_cnt_cd, b1.ntfy_cust_seq, b1.agmt_prc_ctrt_cust_tp_cd,b1.rt_bl_tp_cd) 
         VALUES(b2.bkg_no, b2.trd_cd, b2.rlane_cd, b2.ioc_cd, b2.vsl_cd, b2.skd_voy_no, b2.dir_cd, b2.rev_conti_cd, b2.finc_dir_cd 
               ,b2.slan_cd, b2.bl_no, b2.bl_no_tp, b2.rgn_ofc_cd, b2.rhq_cd, b2.sls_ofc_cd, b2.usa_bkg_mod_cd, b2.bkg_sts_cd 
               ,b2.bkg_cgo_tp_cd, b2.bkg_por_cd, b2.bkg_por_yd_cd, b2.bkg_pol_cd, b2.bkg_ofc_cd, b2.bkg_pod_cd, b2.bkg_del_cd, b2.bkg_del_yd_cd 
               ,b2.bkg_rcv_term_cd, b2.bkg_de_term_cd, b2.rep_cmdt_cd, b2.cmdt_cd, b2.ppd_ofc_cd, b2.clt_ofc_cd, b2.n1st_finc_vvd_cd 
               ,b2.n2nd_finc_vvd_cd, b2.n3rd_finc_vvd_cd, b2.n4th_finc_vvd_cd, b2.n1st_pol_cd, b2.n2nd_pol_cd, b2.n3rd_pol_cd, b2.n4th_pol_cd 
               ,b2.n1st_pod_cd, b2.n2nd_pod_cd, b2.n3rd_pod_cd, b2.n4th_pod_cd, b2.n1st_rlane_cd, b2.n2nd_rlane_cd, b2.n3rd_rlane_cd 
               ,b2.n4th_rlane_cd, b2.n1st_ioc_conti_cd, b2.n2nd_ioc_conti_cd, b2.n3rd_ioc_conti_cd, b2.n4th_ioc_conti_cd, b2.n1st_trd_cd 
               ,b2.n2nd_trd_cd, b2.n3rd_trd_cd, b2.n4th_trd_cd, b2.n1st_pol_pod_dys, b2.n2nd_pol_pod_dys, b2.n3rd_pol_pod_dys, b2.n4th_pol_pod_dys 
               ,b2.shpr_cnt_cd, b2.shpr_cust_seq, b2.shpr_nm, b2.cnee_nm, b2.ntfy_nm, b2.sc_no, b2.rfa_no, b2.cust_tp_cd, b2.agmt_cust_tp_cd 
               ,b2.agmt_cnt_cd, b2.agmt_cust_seq, b2.agmt_sgn_ofc_cd, b2.cust_key_agmt_mgr_flg, b2.oft_tp_cd, b2.obrd_dt, b2.cntr_rcv_dt, b2.srep_cd 
               ,b2.rev_pol_cd, b2.rev_pod_cd, b2.bkg_cgo_wgt, b2.bkg_wgt_tp_cd, b2.auto_rat_dt, b2.spcl_rc_flg, b2.spcl_dg_cgo_flg 
               ,b2.spcl_bb_cgo_flg, b2.spcl_awk_cgo_flg, b2.rd_flg, b2.soc_flg, b2.rev_dir_cd, b2.cre_usr_id, b2.cre_dt, b2.upd_usr_id 
               ,b2.upd_dt   -- create시에 cre_dt, upd_dt를 모두 넣어준다. 
               ,b2.wrk_vvd_cd, b2.ctrt_ofc_cd, b2.ctrt_srep_cd, b2.ctrt_hq_ofc_cd, b2.ctrt_rgn_ofc_cd, b2.cnee_cnt_cd, b2.cnee_cust_seq
               ,b2.taa_no, b2.ntfy_cnt_cd, b2.ntfy_cust_seq, b2.agmt_prc_ctrt_cust_tp_cd,b2.rt_bl_tp_cd) 
      WHEN MATCHED THEN 
         UPDATE 
            SET b1.trd_cd = b2.trd_cd, b1.rlane_cd = b2.rlane_cd, b1.ioc_cd = b2.ioc_cd, b1.vsl_cd = b2.vsl_cd, b1.skd_voy_no = b2.skd_voy_no 
               ,b1.dir_cd = b2.dir_cd, b1.rev_conti_cd = b2.rev_conti_cd, b1.finc_dir_cd = b2.finc_dir_cd, b1.slan_cd = b2.slan_cd 
               ,b1.bl_no = b2.bl_no, b1.bl_no_tp = b2.bl_no_tp, b1.rgn_ofc_cd = b2.rgn_ofc_cd, b1.rhq_cd = b2.rhq_cd 
               ,b1.sls_ofc_cd = b2.sls_ofc_cd, b1.usa_bkg_mod_cd = b2.usa_bkg_mod_cd, b1.bkg_sts_cd = b2.bkg_sts_cd 
               ,b1.bkg_cgo_tp_cd = b2.bkg_cgo_tp_cd, b1.bkg_por_cd = b2.bkg_por_cd, b1.bkg_por_yd_cd = b2.bkg_por_yd_cd 
               ,b1.bkg_pol_cd = b2.bkg_pol_cd, b1.bkg_ofc_cd = b2.bkg_ofc_cd, b1.bkg_pod_cd = b2.bkg_pod_cd, b1.bkg_del_cd = b2.bkg_del_cd 
               ,b1.bkg_del_yd_cd = b2.bkg_del_yd_cd, b1.bkg_rcv_term_cd = b2.bkg_rcv_term_cd, b1.bkg_de_term_cd = b2.bkg_de_term_cd 
               ,b1.rep_cmdt_cd = b2.rep_cmdt_cd, b1.cmdt_cd = b2.cmdt_cd, b1.ppd_ofc_cd = b2.ppd_ofc_cd, b1.clt_ofc_cd = b2.clt_ofc_cd 
               ,b1.n1st_finc_vvd_cd = b2.n1st_finc_vvd_cd, b1.n2nd_finc_vvd_cd = b2.n2nd_finc_vvd_cd, b1.n3rd_finc_vvd_cd = b2.n3rd_finc_vvd_cd 
               ,b1.n4th_finc_vvd_cd = b2.n4th_finc_vvd_cd, b1.n1st_pol_cd = b2.n1st_pol_cd, b1.n2nd_pol_cd = b2.n2nd_pol_cd 
               ,b1.n3rd_pol_cd = b2.n3rd_pol_cd, b1.n4th_pol_cd = b2.n4th_pol_cd, b1.n1st_pod_cd = b2.n1st_pod_cd, b1.n2nd_pod_cd = b2.n2nd_pod_cd 
               ,b1.n3rd_pod_cd = b2.n3rd_pod_cd, b1.n4th_pod_cd = b2.n4th_pod_cd, b1.n1st_rlane_cd = b2.n1st_rlane_cd 
               ,b1.n2nd_rlane_cd = b2.n2nd_rlane_cd, b1.n3rd_rlane_cd = b2.n3rd_rlane_cd, b1.n4th_rlane_cd = b2.n4th_rlane_cd 
               ,b1.n1st_ioc_conti_cd = b2.n1st_ioc_conti_cd, b1.n2nd_ioc_conti_cd = b2.n2nd_ioc_conti_cd, b1.n3rd_ioc_conti_cd = b2.n3rd_ioc_conti_cd 
               ,b1.n4th_ioc_conti_cd = b2.n4th_ioc_conti_cd, b1.n1st_trd_cd = b2.n1st_trd_cd, b1.n2nd_trd_cd = b2.n2nd_trd_cd 
               ,b1.n3rd_trd_cd = b2.n3rd_trd_cd, b1.n4th_trd_cd = b2.n4th_trd_cd, b1.n1st_pol_pod_dys = b2.n1st_pol_pod_dys 
               ,b1.n2nd_pol_pod_dys = b2.n2nd_pol_pod_dys, b1.n3rd_pol_pod_dys = b2.n3rd_pol_pod_dys, b1.n4th_pol_pod_dys = b2.n4th_pol_pod_dys 
               ,b1.shpr_cnt_cd = b2.shpr_cnt_cd, b1.shpr_cust_seq = b2.shpr_cust_seq, b1.shpr_nm = b2.shpr_nm, b1.cnee_nm = b2.cnee_nm 
               ,b1.ntfy_nm = b2.ntfy_nm, b1.sc_no = b2.sc_no, b1.rfa_no = b2.rfa_no, b1.cust_tp_cd = b2.cust_tp_cd 
               ,b1.agmt_cust_tp_cd = b2.agmt_cust_tp_cd, b1.agmt_cnt_cd = b2.agmt_cnt_cd, b1.agmt_cust_seq = b2.agmt_cust_seq 
               ,b1.agmt_sgn_ofc_cd = b2.agmt_sgn_ofc_cd, b1.cust_key_agmt_mgr_flg = b2.cust_key_agmt_mgr_flg, b1.oft_tp_cd = b2.oft_tp_cd 
               ,b1.obrd_dt = b2.obrd_dt, b1.cntr_rcv_dt = b2.cntr_rcv_dt, b1.srep_cd = b2.srep_cd, b1.rev_pol_cd = b2.rev_pol_cd 
               ,b1.rev_pod_cd = b2.rev_pod_cd, b1.bkg_cgo_wgt = b2.bkg_cgo_wgt, b1.bkg_wgt_tp_cd = b2.bkg_wgt_tp_cd, b1.auto_rat_dt = b2.auto_rat_dt 
               ,b1.spcl_rc_flg = b2.spcl_rc_flg, b1.spcl_dg_cgo_flg = b2.spcl_dg_cgo_flg, b1.spcl_bb_cgo_flg = b2.spcl_bb_cgo_flg 
               ,b1.spcl_awk_cgo_flg = b2.spcl_awk_cgo_flg, b1.rd_flg = b2.rd_flg, b1.soc_flg = b2.soc_flg 
               ,b1.rev_dir_cd = b2.rev_dir_cd   --,b1.cre_usr_id = b2.cre_usr_id, b1.cre_dt = b2.cre_dt update시에는 넣어주지 않는다. 
               ,b1.upd_usr_id = b2.upd_usr_id, b1.upd_dt = b2.upd_dt, b1.wrk_vvd_cd = b2.wrk_vvd_cd, b1.ctrt_ofc_cd = b2.ctrt_ofc_cd 
               ,b1.ctrt_srep_cd = b2.ctrt_srep_cd, b1.ctrt_hq_ofc_cd = b2.ctrt_hq_ofc_cd, b1.ctrt_rgn_ofc_cd = b2.ctrt_rgn_ofc_cd 
               ,b1.cnee_cnt_cd = b2.cnee_cnt_cd, b1.cnee_cust_seq = b2.cnee_cust_seq
               ,b1.taa_no = b2.taa_no, b1.ntfy_cnt_cd = b2.ntfy_cnt_cd, b1.ntfy_cust_seq = b2.ntfy_cust_seq, b1.agmt_prc_ctrt_cust_tp_cd = b2.agmt_prc_ctrt_cust_tp_cd,b1.rt_bl_tp_cd = b2.rt_bl_tp_cd
         ; 
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 
 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- COA_RGST_BKG 실화주 UPDATE (PRI시스템에서 SC_RFA_HLD_CNT_CD, SC_RFA_HLD_CUST_SEQ)
--   v_step := 'COA_RGST_BKG 실화주 UPDATE'; 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 

--SELECT  CASE
--        WHEN  SM.REAL_CUST_CNT_CD IS NOT NULL THEN SM.REAL_CUST_CNT_CD
--        ELSE  CP.CUST_CNT_CD
--        END   CUST_CNT_CD ,
--        CASE
--        WHEN  SM.REAL_CUST_CNT_CD IS NOT NULL THEN SM.REAL_CUST_SEQ
--        ELSE  CP.CUST_SEQ
--        END   CUST_SEQ
--FROM    COA_BKG_INFO    CB  ,
--        PRI_SP_HDR      SH  ,
--        PRI_SP_MN       SM  ,
--        PRI_SP_CTRT_PTY CP
--WHERE   SH.SC_NO              = CB.SC_NO
--AND     SM.PROP_NO            = SH.PROP_NO
--AND     SM.PROP_STS_CD        = 'F'
--AND     CB.CNTR_RCV_DT        BETWEEN SM.EFF_DT AND SM.EXP_DT + 0.99999   /* 0.99999 는 23시 59분 59초를 의미 */
--AND     CP.PROP_NO            = SM.PROP_NO
--AND     CP.AMDT_SEQ           = SM.AMDT_SEQ
--AND     CP.PRC_CTRT_PTY_TP_CD = 'C'
--AND     CB.BKG_NO             = 'KORY6015212'
-- 
--================================================
-- 
 
   v_step := 'COA_RGST_BKG 실화주 UPDATE'; 
   MERGE INTO COA_RGST_BKG B1 
      USING (
        SELECT  /*+ ORDERED */ CB.BKG_NO,
                CASE
                    WHEN  SM.REAL_CUST_CNT_CD IS NOT NULL THEN SM.REAL_CUST_CNT_CD
                    ELSE  CP.CUST_CNT_CD
                END   SC_RFA_HLD_CNT_CD, --CUST_CNT_CD ,
                CASE
                    WHEN  SM.REAL_CUST_CNT_CD IS NOT NULL THEN SM.REAL_CUST_SEQ
                    ELSE  CP.CUST_SEQ
                END   SC_RFA_HLD_CUST_SEQ --CUST_SEQ
        FROM    COA_RGST_BKG    CB  ,
                PRI_SP_HDR      SH  ,
                PRI_SP_MN       SM  ,
                PRI_SP_CTRT_PTY CP
        WHERE   1=1
        AND     CB.BKG_NO             =  in_bkg_no
        AND     SH.SC_NO              = CB.SC_NO
        AND     SM.PROP_NO            = SH.PROP_NO
        AND     SM.PROP_STS_CD        = 'F'
        AND     CB.CNTR_RCV_DT        BETWEEN SM.EFF_DT AND SM.EXP_DT + 0.99999   /* 0.99999 는 23시 59분 59초를 의미 */
        AND     CP.PROP_NO            = SM.PROP_NO
        AND     CP.AMDT_SEQ           = SM.AMDT_SEQ
        AND     CP.PRC_CTRT_PTY_TP_CD = 'C'
      ) B2 
      ON (    B1.BKG_NO = B2.BKG_NO ) 
      WHEN MATCHED THEN 
         UPDATE 
            SET B1.SC_RFA_HLD_CNT_CD = B2.SC_RFA_HLD_CNT_CD, B1.SC_RFA_HLD_CUST_SEQ = B2.SC_RFA_HLD_CUST_SEQ 
      ; 
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 

--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- COA_BKG_INFO SUB TRADE UPDATE 
--   v_step := 'COA_BKG_INFO SUB TRADE UPDATE'; 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   v_step := 'COA_RGST_BKG SUB TRADE UPDATE';   
   MERGE INTO COA_RGST_BKG B1
   USING (SELECT A1.BKG_NO, A2.SUB_TRD_CD 
            FROM   COA_RGST_BKG A1 ,COA_MON_VVD A2 
            WHERE  A1.BKG_NO = in_bkg_no 
            AND A1.TRD_CD = A2.TRD_CD 
            AND A1.RLANE_CD = A2.RLANE_CD 
            AND A1.IOC_CD = A2.IOC_CD 
            AND A1.VSL_CD = A2.VSL_CD 
            AND A1.SKD_VOY_NO = A2.SKD_VOY_NO 
            AND A1.DIR_CD = A2.DIR_CD ) B2
   ON (    B1.BKG_NO = B2.BKG_NO ) 
   WHEN MATCHED THEN UPDATE SET B1.SUB_TRD_CD = B2.SUB_TRD_CD;
   
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 
 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- PARA SERIES DELETE 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   v_step := 'PARA SERIES DELETE'; 
 
   DELETE FROM coa_com_cost_para 
         WHERE pctl_no IN(SELECT cop_no 
                            FROM sce_cop_hdr 
                           WHERE bkg_no = in_bkg_no); 
-- 
----   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 
   DELETE FROM coa_com_para 
         WHERE pctl_no IN(SELECT cop_no 
                            FROM sce_cop_hdr 
                           WHERE bkg_no = in_bkg_no); 
 
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 
 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- COA_COM_PARA INSERT 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   v_step := 'COA_COM_PARA INSERT'; 
   
   select count(*)
     into v_memo_split
     from bkg_booking
    where bkg_no = in_bkg_no
      and nvl(bl_no_tp,'0') <> '0';
    
   INSERT INTO coa_com_para 
               (pctl_no 
               ,bkg_no 
               ,por_nod_cd 
               ,del_nod_cd 
               ,bkg_ofc_cd 
               ,bkg_cgo_tp_cd 
               ,bkg_rcv_term_cd 
               ,bkg_de_term_cd 
               ,rep_cmdt_cd 
               ,cmdt_cd 
               ,n1st_rlane_cd 
               ,n2nd_rlane_cd 
               ,n3rd_rlane_cd 
               ,n4th_rlane_cd 
               ,shpr_cnt_cd 
               ,shpr_seq 
               --,cnee_cnt_cd 
               --,cnee_seq 
               ,dg_clss_cd 
               ,dg_spcl_flg 
               ,spcl_awk_cgo_flg 
               ,rf_spcl_flg 
               ,rd_spcl_flg 
               ,bb_spcl_flg 
               ,soc_flg 
               ,bkg_wgt 
               ,bkg_wgt_ut_cd 
               ,cre_usr_id 
               ,cre_dt 
               ,n1st_ts_port_cd 
               ,n2nd_ts_port_cd 
               ,n3rd_ts_port_cd 
               ,por_cd 
               ,pol_cd 
               ,pod_cd 
               ,del_cd 
               ,trnk_vsl_cd 
               ,trnk_skd_voy_no 
               ,trnk_skd_dir_cd 
               ,n1st_finc_vvd_cd 
               ,n2nd_finc_vvd_cd 
               ,n3rd_finc_vvd_cd 
               ,n4th_finc_vvd_cd 
               ,n1st_trd_cd 
               ,n2nd_trd_cd 
               ,n3rd_trd_cd 
               ,n4th_trd_cd 
               ,cost_rout_no 
               ,para_rout_no 
               ,UPD_USR_ID
               ,UPD_DT
               ,ORG_PCTL_NO
               ,CNTR_QTY
               ) 
       (SELECT b1.cop_no 
             ,b2.bkg_no 
             ,B2.bkg_por_yd_cd 
             ,B2.bkg_del_yd_cd 
             ,b2.bkg_ofc_cd 
             ,b2.bkg_cgo_tp_cd 
             ,b2.bkg_rcv_term_cd 
             ,b2.bkg_de_term_cd 
             ,b2.rep_cmdt_cd 
             ,b2.cmdt_cd 
             ,SUBSTR(b2.n1st_rlane_cd, 1, 3) 
             ,SUBSTR(b2.n2nd_rlane_cd, 1, 3) 
             ,SUBSTR(b2.n3rd_rlane_cd, 1, 3) 
             ,SUBSTR(b2.n4th_rlane_cd, 1, 3) 
             ,b2.shpr_cnt_cd 
             ,b2.shpr_cust_seq 
--             ,'' c_cnt_cd 
--             ,'' cust_cd 
              --SCE_COP_HDR에서 관리하지 않으므로 PRD_PROD_CTL_MST에서 가져오도록 수정
             ,(SELECT mst.dg_clss_cd FROM PRD_PROD_CTL_MST mst WHERE mst.pctl_no = b1.pctl_no ) dg_clss_cd
             -- SPCL_FLG = AWK_CGO_FLG || DCGO_FLG || RC_FLG || BB_CGO_FLG || SOC_FLG || RD_CGO_FLG 조합
             ,SUBSTR(B3.SPCL_FLG, 2, 1) DG_SPCL_FLG
             ,SUBSTR(B3.SPCL_FLG, 1, 1) SPCL_AWK_CGO_FLG
             ,SUBSTR(B3.SPCL_FLG, 3, 1) RF_SPCL_FLG
             ,SUBSTR(B3.SPCL_FLG, 6, 1) RD_SPCL_FLG
             ,SUBSTR(B3.SPCL_FLG, 4, 1) BB_SPCL_FLG
             ,SUBSTR(B3.SPCL_FLG, 5, 1) SOC_FLG
             ,b2.bkg_cgo_wgt 
             ,b2.bkg_wgt_tp_cd 
             ,v_prc_usr_id 
             ,v_prc_sys_date 
             ,b2.n1st_pod_cd 
             ,b2.n2nd_pod_cd 
             ,b2.n3rd_pod_cd 
             ,b2.bkg_por_cd 
             ,b2.bkg_pol_cd 
             ,b2.bkg_pod_cd 
             ,b2.bkg_del_cd 
             ,b2.vsl_cd 
             ,b2.skd_voy_no 
             ,b2.dir_cd 
             ,b2.n1st_finc_vvd_cd 
             ,b2.n2nd_finc_vvd_cd 
             ,b2.n3rd_finc_vvd_cd 
             ,b2.n4th_finc_vvd_cd 
             ,b2.n1st_trd_cd 
             ,b2.n2nd_trd_cd 
             ,b2.n3rd_trd_cd 
             ,b2.n4th_trd_cd 
             , 'ROUTE' || LPAD(TO_CHAR(b3.group_no), 15, '0') cost_rout_no   -- cost_rout_no : 실제 ROUTING CASE에 따른 route번호 
             , DENSE_RANK() OVER(ORDER BY b3.group_no, b3.cntr_tpsz_cd) para_rout_no   --TPSZ별로 같은 값이 들어간다. 
             ,v_prc_usr_id 
             ,v_prc_sys_date 
             ,B1.PCTL_NO
             ,B3.QTY CNTR_QTY
         FROM coa_rgst_bkg b2 
             ,sce_cop_hdr b1 
             ,(
                WITH QTY 
                     AS (
                        -- QTY물량
                        SELECT   A1.BKG_NO 
                                 ,A1.PCTL_NO 
                                 ,A1.COP_NO
                                 ,A2.CNTR_TPSZ_CD 
--                                 ,NULL CNTR_NO, 
                                 ,SUM(A2.OP_CNTR_QTY)                      QTY 
--                                 ,NVL(A2.AWK_CGO_FLG,'N')                  AWK_CGO_FLG 
--                                 ,NVL(A2.DCGO_FLG,'N')                     DCGO_FLG 
--                                 ,NVL(A2.RC_FLG,'N')                       RC_FLG 
--                                 ,NVL(A2.BB_CGO_FLG,'N')                   BB_CGO_FLG 
--                                 ,NVL(A2.SOC_FLG,'N')                      SOC_FLG 
                                 ,NVL(DECODE(A2.AWK_CGO_QTY,0,'N','Y'),'N') AWK_CGO_FLG
                                 ,NVL(DECODE(A2.DCGO_QTY,0,'N','Y'),'N')    DCGO_FLG
                                 ,NVL(DECODE(A2.RC_QTY,0,'N','Y'),'N')      RC_FLG
                                 ,NVL(DECODE(A2.BB_CGO_QTY,0,'N','Y'),'N')  BB_CGO_FLG
                                 ,NVL(DECODE(A2.SOC_QTY,0,'N','Y'),'N')     SOC_FLG
                                 ,DECODE(SUBSTR(A2.CNTR_TPSZ_CD,1,1),'R',DECODE(SUBSTR(A2.EQ_SUBST_CNTR_TPSZ_CD,1,1),'D','Y', 'N'), 'N') RD_CGO_FLG 
                                 ,A3.FLEX_HGT_FLG
                         FROM     SCE_COP_HDR A1
                                 ,BKG_QUANTITY A2 -- BKG_QTY_DTL
                                 ,BKG_BOOKING A3
                         WHERE    A1.BKG_NO = in_bkg_no --'KORY6015212' 
                         AND A1.BKG_NO = A2.BKG_NO
                         AND A1.BKG_NO = A3.BKG_NO
                         AND A1.COP_NO = SCE_REP_COP_NO_FNC(A2.BKG_NO, A2.CNTR_TPSZ_CD)
                         GROUP BY A1.BKG_NO 
                                  ,A1.PCTL_NO 
                                  ,A1.COP_NO
                                  ,A2.CNTR_TPSZ_CD
--                                  ,NULL CNTR_NO
--                                  ,NVL(A2.AWK_CGO_FLG,'N') 
--                                  ,NVL(A2.DCGO_FLG,'N') 
--                                  ,NVL(A2.RC_FLG,'N') 
--                                  ,NVL(A2.BB_CGO_FLG,'N') 
--                                  ,NVL(A2.SOC_FLG,'N') 
                                  ,NVL(DECODE(A2.AWK_CGO_QTY,0,'N','Y'),'N') 
                                  ,NVL(DECODE(A2.DCGO_QTY,0,'N','Y'),'N') 
                                  ,NVL(DECODE(A2.RC_QTY,0,'N','Y'),'N') 
                                  ,NVL(DECODE(A2.BB_CGO_QTY,0,'N','Y'),'N') 
                                  ,NVL(DECODE(A2.SOC_QTY,0,'N','Y'),'N')
                                  ,DECODE(SUBSTR(A2.CNTR_TPSZ_CD,1,1),'R',DECODE(SUBSTR(A2.EQ_SUBST_CNTR_TPSZ_CD,1,1),'D','Y', 'N') , 'N')
                                  ,A3.FLEX_HGT_FLG
                                  ), 
                     CNTR 
                     AS (-- CNTR물량
                        SELECT   A2.BKG_NO 
                                ,A3.PCTL_NO 
                                ,A3.COP_NO
                                ,A3.CNTR_TPSZ_CD 
                                ,--  A2.CNTR_NO, 
                                 SUM(A2.CNTR_VOL_QTY)    QTY 
                                , NVL(A2.AWK_CGO_FLG,'N') AWK_CGO_FLG 
                                , NVL(A2.DCGO_FLG,'N')    DCGO_FLG 
                                , NVL(A2.RC_FLG,'N')      RC_FLG 
                                , NVL(A2.BB_CGO_FLG,'N')  BB_CGO_FLG 
                                , NVL(A2.SOC_FLG,'N')     SOC_FLG 
                                , NVL(A2.RD_CGO_FLG,'N')  RD_CGO_FLG 
                                ,A1.FLEX_HGT_FLG
                         FROM    BKG_CONTAINER A2 
                                ,SCE_COP_HDR A3 
                                ,BKG_BOOKING A1
                         WHERE   A2.BKG_NO = in_bkg_no--'OSLY3120003' --'KORY6015212' 
                         AND A2.BKG_NO = A3.BKG_NO 
                         AND A3.CNTR_NO = A2.CNTR_NO 
                         AND A3.BKG_NO = A1.BKG_NO
                         AND A3.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD 
                         AND (v_memo_split = 0 and A3.cop_sts_cd   not in ('X','M','O') -- 일반 BKG 일경우
                          OR  v_memo_split > 0 and A3.cop_sts_cd   not in ('M','O')     -- Memo split의 원부킹 일경우
                             )
                         GROUP BY A2.BKG_NO 
                                 ,A3.PCTL_NO 
                                 ,A3.COP_NO
                                 ,A3.CNTR_TPSZ_CD 
                                 ,A2.AWK_CGO_FLG 
                                 ,NVL(A2.AWK_CGO_FLG,'N') 
                                 ,NVL(A2.DCGO_FLG,'N') 
                                 ,NVL(A2.RC_FLG,'N') 
                                 ,NVL(A2.BB_CGO_FLG,'N') 
                                 ,NVL(A2.SOC_FLG,'N') 
                                 ,NVL(A2.RD_CGO_FLG,'N')
                                 ,A1.FLEX_HGT_FLG
                        )
                        ,
                     ROUTE 
                     AS (
                     SELECT   D1.BKG_NO 
--                                  , D1.PCTL_NO 
                                  , D1.COP_NO
                                  , D1.CNTR_TPSZ_CD 
                                  , D2.COST_ACT_GRP_SEQ 
                                  , D1.SPCL_FLG 
                                  , D1.QTY 
--                                  , ROW_NUMBER() OVER(PARTITION BY D1.BKG_NO,D1.PCTL_NO,D1.CNTR_TPSZ_CD ORDER BY D2.COST_ACT_GRP_SEQ) RN 
                                  , ROW_NUMBER() OVER(PARTITION BY D1.BKG_NO,D1.COP_NO,D1.CNTR_TPSZ_CD ORDER BY D2.COST_ACT_GRP_SEQ) RN 
                                 , D2.COST_ACT_GRP_CD 
                                    ||NVL(D2.N1ST_NOD_CD,'XXXXXXX') 
                                    ||NVL(D2.N2ND_NOD_CD,'XXXXXXX') 
                                    ||NVL(D2.N3RD_NOD_CD,'XXXXXXX') 
                                    ||NVL(D2.N4TH_NOD_CD,'XXXXXXX') 
                                    ||NVL(D2.TRSP_MOD_CD,'XX') --                                  ||D1.SPCL_FLG 
                                    NOD -- QTY_CLASS
                         FROM PRD_PROD_CTL_ACT_GRP_DTL D2,
                              (
                                 select bkg_no
                                       ,pctl_no
                                       ,cntr_tpsz_cd
                                       ,cop_no
                                       ,nvl(max(cntr_spcl_flg),max(bkg_spcl_flg)) spcl_flg -- CNTR의 Specail Flag를 우선시 한다.
                                       ,max(bkg_spcl_flg) bkg_spcl_flg
                                       ,sum(abs(cntr_qty)) + sum(abs(bkg_qty)) qty         -- 차이나는 물량이 마이너스 일수 있어서 절대값으로 처리
                                   from (
                                        select bkg_no 
                                              ,pctl_no 
                                              ,cop_no
                                              ,cntr_tpsz_cd 
                                              ,sum(qty)     cntr_qty  -- bkg_contrainer 물량 
                                              ,awk_cgo_flg||dcgo_flg||rc_flg||bb_cgo_flg||soc_flg||rd_cgo_flg cntr_spcl_flg 
                                              ,0 bkg_qty
                                              ,'' bkg_spcl_flg
--                                              ,'CNTR'       qty_class 
                                          from cntr 
                                         group by bkg_no 
                                                 ,pctl_no,cop_no
                                                 ,cntr_tpsz_cd 
                                                 ,awk_cgo_flg||dcgo_flg||rc_flg||bb_cgo_flg||soc_flg||rd_cgo_flg 
                                         union all 
                                         select c1.bkg_no 
                                               ,c1.pctl_no
                                               ,c1.cop_no
                                               ,c1.cntr_tpsz_cd 
                                               ,0 cntr_qty
                                               ,'' cntr_spcl_flg
                                               ,c2.qty  bkg_qty-- bkg_contrainer? bkg_qty_dtl차이 물량
                                               ,c1.awk_cgo_flg||c1.dcgo_flg||c1.rc_flg||c1.bb_cgo_flg||c1.soc_flg||c1.rd_cgo_flg bkg_spcl_flg 
--                                               ,qty_class 
                                           from qty c1 
                                               ,(
                                                  --Flex Height의 경우 D4, D5간의 혼용을 가능하도록 하기 위해서 도입한 개념으로 미주지역에서 발생하며
                                                  --BKG_BOOKING의 flex_hgt_flg='Y'인경우에 
                                                    select b1.bkg_no 
                                                          ,decode(b1.flex_hgt_flg, 'Y', decode(b1.cntr_tpsz_cd,'D4', nvl(b2.cntr_tpsz_cd,b1.cntr_tpsz_cd)
                                                                                                              ,'D5', nvl(b2.cntr_tpsz_cd,b1.cntr_tpsz_cd)
                                                                                                              ,B1.CNTR_TPSZ_CD)
                                                                                  , b1.cntr_tpsz_cd) cntr_tpsz_cd --b1.cntr_tpsz_cd 
                                                          ,b1.qty - nvl(b2.qty,0) qty2
                                                          ,decode(b1.flex_hgt_flg, 'Y', Decode(b1.cntr_tpsz_cD,'D4', nvl(b2.qty, b1.qty)
                                                                                                              ,'D5', nvl(b2.qty, b1.qty)
                                                                                                              ,b1.qty)
                                                                                  , b1.qty) - nvl(b2.qty,0) qty
                                                          
                                                          ,'QTY'                  qty_class 
                                                   from   (select   bkg_no, cntr_tpsz_cd, flex_hgt_flg, sum(qty) qty from qty group by bkg_no, cntr_tpsz_cd, flex_hgt_flg) b1 
                                                         ,(select   bkg_no, cntr_tpsz_cd, flex_hgt_flg, sum(qty) qty from cntr group by bkg_no, cntr_tpsz_cd, flex_hgt_flg) b2 
                                                   where  b1.bkg_no = b2.bkg_no (+) 
                                                   and    decode(b1.flex_hgt_flg, 'Y', decode(b1.cntr_tpsz_cd,'D4', nvl(b2.cntr_tpsz_cd(+),b1.cntr_tpsz_cd)
                                                                                                             ,'D5', nvl(b2.cntr_tpsz_cd(+),b1.cntr_tpsz_cd)
                                                                                                             ,b1.cntr_tpsz_cd)
                                                                                , b1.cntr_tpsz_cd) = b2.cntr_tpsz_cd (+)
                                                    
                                                
                                                ) c2 
                                          where c1.bkg_no = c2.bkg_no 
                                            and c1.cntr_tpsz_cd = c2.cntr_tpsz_cd 
                                            and c2.qty > 0
                                         ) 
                                   group by bkg_no
                                           ,pctl_no
                                           ,cntr_tpsz_cd
                                           ,cop_no
                              ) D1 
                         WHERE    D2.PCTL_NO = D1.PCTL_NO 
                         GROUP BY D1.BKG_NO 
--                                  , D1.PCTL_NO 
                                  , D1.COP_NO
                                  , D1.CNTR_TPSZ_CD 
                                  , D2.COST_ACT_GRP_SEQ 
                                  , D1.SPCL_FLG 
                                  , D2.COST_ACT_GRP_CD 
                                    ||NVL(D2.N1ST_NOD_CD,'XXXXXXX') 
                                    ||NVL(D2.N2ND_NOD_CD,'XXXXXXX') 
                                    ||NVL(D2.N3RD_NOD_CD,'XXXXXXX') 
                                    ||NVL(D2.N4TH_NOD_CD,'XXXXXXX') 
                                    ||NVL(D2.TRSP_MOD_CD,'XX') 
                                  --||D1.SPCL_FLG 
                                  , D1.QTY) 
                SELECT   BKG_NO 
                         , COP_NO 
                         , CNTR_TPSZ_CD 
                         , SPCL_FLG 
                         , QTY 
                         , DENSE_RANK() OVER(ORDER BY SUBSTR(MAX(SYS_CONNECT_BY_PATH(NOD,'-')),2)||SPCL_FLG) GROUP_NO 
                --       , SUBSTR(MAX(SYS_CONNECT_BY_PATH(NOD,'-')),2) || SPCL_FLG 
                FROM ROUTE 
                START WITH RN = 1 CONNECT BY PRIOR COP_NO = COP_NO 
                                          AND PRIOR CNTR_TPSZ_CD = CNTR_TPSZ_CD 
                                          AND PRIOR RN + 1 = RN 
                GROUP BY BKG_NO 
                         , COP_NO 
                         , CNTR_TPSZ_CD 
                         , SPCL_FLG 
                         , QTY
              ) B3
        WHERE 1 = 1 
          AND b1.bkg_no = in_bkg_no 
          AND b1.bkg_no = b2.bkg_no        
          AND b1.cop_no = b3.cop_no 
          AND b1.cntr_tpsz_cd not like 'Q%' -- Q 타입을 제외한다.
          ); 
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 
 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- COA_COM_COST_PARA INSERT 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   v_step := 'COA_COM_COST_PARA INSERT'; 
    
 -------------------------------------------------------------------------------------------------------------- 
 -- Full cargo days = COP의 Estimated/Actual Transit Time 계산 방법 준용(sce_cop_tot_tran_time_fnc 사용)      | 
 -- sce_cop_tot_tran_time_fnc 을 태워 나온 값 중에 # 뒤에 있는 값이 actual 이므로 해당 값을 사용한다.         |  
 -- days 확인용 주석                                                                                          | 
 -------------------------------------------------------------------------------------------------------------- 

--  enis_log_prc(SYSDATE, 'coa_cost_assign_cop', 'v_full_days :'||v_full_days || 'v_full_hours :'||v_full_hours, v_appl_info);    
 
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
--               ,cust_nomi_trkr_flg --Customer Nominated Trucker coa에서 넣어주지 않고, TRS에서 알아서 처리함
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
               ,scc_cd 
               ,ecc_cd 
               ,para_fm_scc_cd 
               ,para_to_scc_cd 
               ,para_fm_ecc_cd 
               ,para_to_ecc_cd 
               ,n1st_rail_crr_tp_cd 
               ,n2nd_rail_crr_tp_cd 
               ,n3rd_rail_crr_tp_cd 
               ,ctrt_rtn_flg 
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
               ,UPD_USR_ID
               ,UPD_DT
               )                
      (SELECT b1.cop_no 
             ,b2.cost_act_grp_seq 
--             ,b5.cntr_tpsz_cd 
             ,b1.cntr_tpsz_cd 
             ,b4.coa_cost_src_cd 
             ,b4.stnd_cost_cd 
             ,b4.cost_ut_amt_cd 
             ,b4.cost_src_sys_cd 
             ,b4.cost_ass_bse_cd 
             ,b2.cost_act_grp_cd 
             ,b2.cost_act_grp_tp_cd 
             ,b2.vsl_slan_cd 
             ,b2.ctrl_ofc_cd 
             ,'' cost_ofc_cd 
             ,b2.pctl_io_bnd_cd 
             ,b2.n1st_nod_cd 
             ,b2.n1st_nod_tp_cd 
             ,b2.n1st_nod_pln_dt n1st_estm_dt 
             ,b2.n2nd_nod_cd 
             ,b2.n3rd_nod_cd 
             ,b2.n4th_nod_cd 
             ,b2.trsp_mod_cd rout_tz_mod_cd 
             ,b2.n1st_lnk_dist n1st_pol_pod_dist 
             ,b2.n1st_lnk_dist_ut_cd n1st_dist_ut_cd 
             ,b2.n2nd_lnk_dist n2nd_pol_pod_dist 
             ,b2.n2nd_lnk_dist_ut_cd n2nd_dist_ut_cd 
             ,b2.n3rd_lnk_dist n3rd_pol_pod_dist 
             ,b2.n3rd_dist_ut_cd 
             ,b2.n1st_vndr_seq 
             ,b2.n2nd_vndr_seq 
             ,b2.n3rd_vndr_seq 
             ,NULL n4th_vndr_seq 
--             ,b2.cust_nomi_trkr_flg PRD/SCE(?)삭제
             ,b2.pre_nod_cd 
             ,b2.nxt_nod_cd 
             ,b2.pre_vndr_seq 
             ,b2.nxt_vndr_seq 
             --Full cargo days = COP의 Estimated/Actual Transit Time 계산 방법 준용(SCE_COP_TOT_TRAN_TIME_FNC 사용) CSR No.N200903300170  
             ,(SUBSTR(sce_cop_tot_tran_time_fnc(b1.cop_no ,in_bkg_no ) 
                    ,INSTR(sce_cop_tot_tran_time_fnc(b1.cop_no ,in_bkg_no), '#')+1 --# 표시 이후 부터 
                    ,INSTR(sce_cop_tot_tran_time_fnc(b1.cop_no ,in_bkg_no), 'D', 8) --두 번째 D가 나온 위치 
                    -INSTR(sce_cop_tot_tran_time_fnc(b1.cop_no ,in_bkg_no), '#')-1) 
                     ) --Full cargo days 
             + (SUBSTR(sce_cop_tot_tran_time_fnc(b1.cop_no ,in_bkg_no) 
                      ,INSTR(sce_cop_tot_tran_time_fnc(b1.cop_no ,in_bkg_no ), 'D', 8)+2 --두 번째 D가 나온 위치 + 공백 감안 
                      ,INSTR(sce_cop_tot_tran_time_fnc(b1.cop_no ,in_bkg_no ), 'H', 10)   --두 번째 H가 나온 위치 
                      -(INSTR(sce_cop_tot_tran_time_fnc(b1.cop_no ,in_bkg_no ),'D', 8)+2) 
                      ) /24 ) --Hours 이므로 24로 나눠서 더해준다.                  
--             ,CASE 
--                 WHEN 60 > b1.ttl_tztm_hrs / 24 
--                    THEN b1.ttl_tztm_hrs / 24 
--                 ELSE coa_eq_ttl_tztm_fnc(coa_bzc_cost_yrmon_fnc(in_bkg_no, in_bkg_no_split), b1.por_cd, b1.del_cd, b1.cntr_tpsz_cd) 
--              END (예전 Full cargo days Logic) 
             ,0 fcgo_tz_hrs 
             ,NULL mcgo_tz_dys 
             ,NULL mcgo_tz_hrs 
             ,b11.cntr_qty 
             ,'A' cost_cate_cd 
             ,0 estm_uc_amt 
             ,0 respb_uc_amt 
             ,'' locl_curr_cd 
             ,'N' trsp_svc_ofc_cd 
             ,'N' cost_asgn_calc_flg --DEFALUT값 넣어주기
             ,v_prc_usr_id 
             ,v_prc_sys_date 
             ,DECODE(SUBSTR(b2.n1st_nod_cd, 1, 5), SUBSTR(COALESCE(n4th_nod_cd, n3rd_nod_cd, n2nd_nod_cd), 1, 5), 'Y', 'N') lgs_cost_cd_chk_flg   --쿼리변경 20080303 
             ,'N' thrp_rt_flg 
             ,DECODE(n1st_nod_tp_cd, 'M', 'Y', 'N') act_grp_tml_flg 
             ,'N' lgs_cost_auto_cd_flg 
             ,DECODE(b6.conti_cd,b7.conti_cd,'I','O') ioc_cd -- 20081125 변경 
             ,e_pol.scc_cd 
             ,e_pol.ecc_cd 
             ,e_pol.scc_cd para_fm_scc_cd 
             ,e_pod.scc_cd para_to_scc_cd 
             ,e_pol.ecc_cd para_fm_ecc_cd 
             ,e_pod.ecc_cd para_to_ecc_cd 
             ,n1st_rail_crr_tp_cd 
             ,n2nd_rail_crr_tp_cd 
             ,n3rd_rail_crr_tp_cd 
             ,'N' ctrt_rtn_flg 
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
             ,v_prc_usr_id 
             ,v_prc_sys_date 
         FROM sce_cop_hdr b1 --b1 
             ,PRD_PROD_CTL_ACT_GRP_DTL b2 --b2 
             ,coa_act_grp_cost_mapg b3 --b3 
             ,coa_cost_src_acct b4 --b4 
             ,mdm_location b6 --b6 
             ,mdm_location b7 --b7 
             ,coa_location_v e_pol 
             ,coa_location_v e_pod 
            ,(
                SELECT   bkg_no 
                       ,MIN(PCTL_NO) min_cop_no 
                       --,cntr_tpsz_cd 
                       ,ROUND(SUM(cntr_qty), 2) cntr_qty 
                   FROM COA_COM_PARA
                   WHERE BKG_NO = in_bkg_no
                GROUP BY bkg_no, COST_ROUT_NO, PARA_ROUT_NO--, cntr_tpsz_cd
            ) B11 
        WHERE 1=1 
          AND b1.bkg_no = in_bkg_no 
--          AND b1.cop_no = b2.cop_no 
          AND b1.PCTL_NO = b2.PCTL_NO 
          AND b1.bkg_no = b11.bkg_no
          AND b1.cop_no = b11.min_cop_no
--          AND b1.cntr_tpsz_cd = b11.cntr_tpsz_cd     COP_NO가 있으면 CNTR_TPSZ_CD도 알수 있으므로 걸어주지 않음
          AND b2.cost_act_grp_cd = b3.cost_act_grp_cd 
          AND b3.coa_cost_src_cd = b4.coa_cost_src_cd 
          AND SUBSTR(b2.pre_nod_cd, 1, 5) = b6.loc_cd(+)   --쿼리변경 20081125 
          AND SUBSTR(b2.nxt_nod_cd, 1, 5) = b7.loc_cd(+)   --쿼리변경 20081125 
          AND b3.cost_aply_flg = 'Y' 
          AND NVL(b4.delt_flg, 'N') = 'N' -- NULL값이 있으므로 NVL처리
          /* TRS의 LOC의 5자리 비교후 필요한 Cost code만 만들기*/ --쿼리변경 20080303 
          --cost_src_sys_cd값이 NULL인 경우 없으므로 NVL(b4.cost_src_sys_cd, 'TRS') 처리 삭제
          AND DECODE(b4.cost_src_sys_cd 
                    ,'TRS', DECODE(SUBSTR(b2.n1st_nod_cd, 1, 5), SUBSTR(COALESCE(b2.n4th_nod_cd, b2.n3rd_nod_cd, b2.n2nd_nod_cd), 1, 5), 'Y', 'N') 
                    ,'Y' 
                    ) =  
                 NVL(lgs_cost_cd_chk_flg
                    ,DECODE(b4.cost_src_sys_cd
                           ,'TRS', DECODE(SUBSTR(b2.n1st_nod_cd, 1, 5), SUBSTR(COALESCE(b2.n4th_nod_cd, b2.n3rd_nod_cd, b2.n2nd_nod_cd), 1, 5), 'Y', 'N') 
                           ,'Y' 
                           ) 
                    ) 
          AND b3.coa_cost_src_cd NOT IN 
                 (--'SVWFTS',   -- WHF(wharfage) for T/S -- 2008.3.12 최요환씨 요청으로 제외 
                  'TMNDRM'   -- TES MTY 대표 SVLDMT 만 생성 (2010.05.25 신준모씨 요청)
                 ,'SVALMT'
                 ,'SRNDMT' 
                 ,'SRFDMT' 
                 ,'SVWFMT' 
                 ,'CGCUMT' 
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
                 ,'TRMTWD' 
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
                 ) 
          AND SUBSTR(b2.n1st_nod_cd, 1, 5) = e_pol.loc_cd(+) --FROM 
--          AND SUBSTR(DECODE(n4th_nod_cd, NULL, DECODE(n3rd_nod_cd, NULL, n2nd_nod_cd, n3rd_nod_cd), n4th_nod_cd), 1, 5) = e_pod.loc_cd(+) --TO 
          AND SUBSTR(COALESCE(n4th_nod_cd, n3rd_nod_cd, n2nd_nod_cd), 1, 5) = e_pod.loc_cd(+) --TO
          ); 
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 
   
   

 --------------------------------------------------------------------- 
 -- Full cargo days 값이 나오지 않으면(null 이면) Error 처리         | 
 -- CSR No.N200903300170                                             | 
 --------------------------------------------------------------------- 
   SELECT count(*) 
     INTO v_full_cargo_dys 
     FROM coa_com_para a1, coa_com_cost_para a2 
    WHERE a1.bkg_no = in_bkg_no 
      AND a1.pctl_no = a2.pctl_no 
      and a2.fcgo_tz_dys is null; 
       
   IF v_full_cargo_dys > 0 
   THEN 
     enis_log_prc(SYSDATE, v_log_mod_nm, 'No Full cargo days', v_appl_info); 
     SELECT 1/0  
       INTO v_error 
       FROM dual; 
   END IF;    
 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- TRS PRE PST 운송모드 제공 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   v_step := 'TRS PRE PST 운송모드 제공'; 
         
   MERGE INTO coa_com_cost_para c1 
      USING (SELECT PCTL_NO 
                   ,cost_act_grp_seq 
                   ,cost_act_grp_cd 
                   ,DECODE(pre_tp_cd, 'L', pre_act_cd, DECODE(pre_tp_cd2, 'L', pre_act_cd2,(DECODE(pre_tp_cd3, 'L', pre_act_cd3)))) BFR_TRSP_MOD_CD --PRE_COST_ACT_GRP_CD  -> BFR_TRSP_MOD_CD  2010.07.21 pre_act_grp_cd 
                   ,DECODE(pst_tp_cd, 'L', pst_act_cd, DECODE(pst_tp_cd2, 'L', pst_act_cd2,(DECODE(pst_tp_cd3, 'L', pst_act_cd3)))) AFT_TRSP_MOD_CD   --PST_COST_ACT_GRP_CD  -> AFT_TRSP_MOD_CD  2010.07.21 pst_act_grp_cd 
               FROM (SELECT A2.PCTL_NO 
                           ,a3.cost_act_grp_seq 
                           ,a3.cost_act_grp_cd   --      ,trsp_mod_cd --      ,cost_act_grp_tp_cd 
                           ,LAG(a3.cost_act_grp_tp_cd, 1) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pre_tp_cd 
                           ,LEAD(a3.cost_act_grp_tp_cd, 1) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pst_tp_cd 
                           ,LAG(a3.cost_act_grp_tp_cd, 2) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pre_tp_cd2 
                           ,LEAD(a3.cost_act_grp_tp_cd, 2) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pst_tp_cd2 
                           ,LAG(a3.cost_act_grp_tp_cd, 3) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pre_tp_cd3 
                           ,LEAD(a3.cost_act_grp_tp_cd, 3) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pst_tp_cd3 
                           ,LAG(a3.trsp_mod_cd, 1) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pre_act_cd 
                           ,LEAD(a3.trsp_mod_cd, 1) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pst_act_cd 
                           ,LAG(a3.trsp_mod_cd, 2) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pre_act_cd2 
                           ,LEAD(a3.trsp_mod_cd, 2) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pst_act_cd2 
                           ,LAG(a3.trsp_mod_cd, 3) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pre_act_cd3 
                           ,LEAD(a3.trsp_mod_cd, 3) OVER(ORDER BY a3.PCTL_NO, a3.cost_act_grp_seq) pst_act_cd3 
                       FROM (SELECT B1.PCTL_NO, B1.ORG_PCTL_NO
                             FROM COA_COM_PARA B1, COA_COM_COST_PARA B2
                             WHERE B1.BKG_NO = in_bkg_no
                             AND B1.PCTL_NO = B2.PCTL_NO
                             GROUP BY B1.PCTL_NO, B1.ORG_PCTL_NO) a2
                             , PRD_PROD_CTL_ACT_GRP_DTL a3 
                      WHERE a2.ORG_PCTL_NO = A3.PCTL_NO) 
              WHERE 1 = 1 
                AND (   DECODE(pre_tp_cd, 'L', pre_act_cd, DECODE(pre_tp_cd2, 'L', pre_act_cd2, (DECODE(pre_tp_cd3, 'L', pre_act_cd3)))) IS NOT NULL 
                     OR DECODE(pst_tp_cd, 'L', pst_act_cd, DECODE(pst_tp_cd2, 'L', pst_act_cd2, (DECODE(pst_tp_cd3, 'L', pst_act_cd3)))) IS NOT NULL 
                    )) c2 
      ON (    c1.pctl_no = c2.PCTL_NO 
          AND c1.cost_act_grp_seq = c2.cost_act_grp_seq) 
      WHEN MATCHED THEN 
         UPDATE 
            SET c1.BFR_TRSP_MOD_CD = c2.BFR_TRSP_MOD_CD   -- 2010.07.21 PRE_COST_ACT_GRP_CD  -> BFR_TRSP_MOD_CD
            ,   c1.AFT_TRSP_MOD_CD = c2.AFT_TRSP_MOD_CD   -- 2010.07.21 PST_COST_ACT_GRP_CD  -> AFT_TRSP_MOD_CD  
            --c1.pre_cost_act_grp_cd = c2.pre_act_grp_cd, c1.pst_cost_act_grp_cd = c2.pst_act_grp_cd 
         ;
         
         
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 

 --------------------------------------------------------------------- 
 -- Vendor code에 대해서                                             |
 -- TRS_TRSP_SVC_ORD,TRS_TRSP_RAIL_BIL_ORD,TRS_TRSP_RAIL_BIL_VNDR_SET| 
 -- 테이블에서 정보를 가져와서 Update 함                             |
 -- 결합테스트 중 나온 요건적용                                      | 
 --------------------------------------------------------------------- 
   v_step := 'TRS Vendor정보 변경'; 
    MERGE INTO coa_com_cost_para x
    USING (
            select c1.pctl_no
                  ,c1.cost_act_grp_seq
                  ,c1.cntr_tpsz_cd
                  ,MAX(decode(c1.sub_rail_seq,1,c1.vndr_seq)) n1st_vndr_seq
                  ,MAX(decode(c1.sub_rail_seq,2,c1.vndr_seq)) n2nd_vndr_seq
                  ,MAX(decode(c1.sub_rail_seq,3,c1.vndr_seq)) n3rd_vndr_seq
                  ,MAX(decode(c1.sub_rail_seq,4,c1.vndr_seq)) n4th_vndr_seq   
              from (
                    select 
                           b1.pctl_no
                          ,b1.cost_act_grp_seq
                          ,b1.cntr_tpsz_cd
                          ,b1.n1st_vndr_seq
                          ,b1.n2nd_vndr_seq
                          ,b1.n3rd_vndr_seq
                          ,b1.n4th_vndr_seq
                          ,nvl2(b2.vndr_seq,b2.vndr_seq,b4.vndr_seq) vndr_seq
                          ,nvl2(b2.vndr_seq,1,b4.sub_rail_seq) sub_rail_seq
                      from (
                            select a2.pctl_no
                                  ,a2.cost_act_grp_seq
                                  ,a2.cntr_tpsz_cd
                                  ,a2.n1st_vndr_seq
                                  ,a2.n2nd_vndr_seq
                                  ,a2.n3rd_vndr_seq
                                  ,a2.n4th_vndr_seq
                              from coa_com_para a1
                                  ,coa_com_cost_para a2
                             where 1=1
                               and a1.bkg_no            = in_bkg_no
                               and a1.pctl_no           = a2.pctl_no
                             group by a2.pctl_no
                                     ,a2.cost_act_grp_seq
                                     ,a2.cntr_tpsz_cd
                                     ,a2.n1st_vndr_seq
                                     ,a2.n2nd_vndr_seq
                                     ,a2.n3rd_vndr_seq
                                     ,a2.n4th_vndr_seq
                           ) b1      
                          ,trs_trsp_svc_ord b2
                          ,trs_trsp_rail_bil_ord b3
                          ,trs_trsp_rail_bil_vndr_set b4
                     where 1=1
                       and b1.pctl_no           = b2.cop_no(+)
                       and b1.cost_act_grp_seq  = b2.cost_act_grp_seq(+)
                       and NVL(b2.delt_flg(+),'N') <> 'Y'
                       and b2.trsp_so_tp_cd(+)     <> 'S'
                       
                       and b1.pctl_no           = b3.cop_no(+)
                       and b1.cost_act_grp_seq  = b3.cost_act_grp_seq(+)
                       and NVL(b3.delt_flg(+),'N') <> 'Y'
                    
                       and b3.trsp_so_ofc_cty_cd = b4.trsp_so_ofc_cty_cd(+)
                       and b3.trsp_so_seq        = b4.trsp_so_seq(+)
                   ) c1
            where c1.vndr_seq is not null        
            group by c1.pctl_no
                    ,c1.cost_act_grp_seq
                    ,c1.cntr_tpsz_cd  
          ) y
       ON (
            x.pctl_no          = y.pctl_no
        AND x.cost_act_grp_seq = y.cost_act_grp_seq
        AND x.cntr_tpsz_cd     = y.cntr_tpsz_cd
       )
    WHEN MATCHED THEN
        UPDATE 
           SET x.n1st_vndr_seq = y.n1st_vndr_seq
              ,x.n2nd_vndr_seq = y.n2nd_vndr_seq
              ,x.n3rd_vndr_seq = y.n3rd_vndr_seq
              ,x.n4th_vndr_seq = y.n4th_vndr_seq
    ;
--    enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 

--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- SPCL관련 계정 삭제 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   v_step := 'SPCL관련 계정 삭제'; 
 
   FOR del_list IN spcl_del_cursor(in_bkg_no) 
   LOOP 
      DELETE FROM coa_com_cost_para 
            WHERE pctl_no = del_list.pctl_no 
              AND cntr_tpsz_cd = del_list.cntr_tpsz_cd 
              AND coa_cost_src_cd = del_list.coa_cost_src_cd; 
   END LOOP; 
 
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info);  
--/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- REV CNTR 관련 계정 삭제 
--/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   v_step := 'COA_COM_COST_PARA REV CNTR 관련 계정 삭제'; 
 
   DELETE FROM coa_com_cost_para 
         WHERE pctl_no IN(SELECT pctl_no 
                            FROM coa_com_para 
                           WHERE bkg_no = in_bkg_no 
                             AND bkg_cgo_tp_cd = 'R') 
           AND coa_cost_src_cd IN(SELECT coa_cost_src_cd 
                                    FROM coa_cost_src_acct 
                                   WHERE bkg_rev_mcgo_flg = 'Y'); 
 
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 
 
--/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- SOC(SHIPPER ON CONTAINER) : 화주 컨테이너는 장비비를 붙이지 않는다. 2007.12.03 박칠서 
-- MTY, HLD, EMU 계정 삭제 
--/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   v_step := 'COA_COM_COST_PARA SOC 관련 계정 삭제'; 
 
   DELETE FROM coa_com_cost_para 
         WHERE pctl_no IN(SELECT pctl_no 
                            FROM coa_com_para 
                           WHERE bkg_no = in_bkg_no 
                             AND soc_flg = 'Y') 
           AND coa_cost_src_cd IN(SELECT coa_cost_src_cd 
                                    FROM coa_cost_src_acct 
                                   WHERE bkg_full_soc_cgo_flg = 'Y'); 
 
--  enis_log_prc('', v_log_mod_nm,    '[COA_COST_ASSIGN] : SOC DELETE'|| TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'), v_appl_info); 
 
--/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- FREE IN , OUT , TACKLE 계정 삭제 (BKG Term logic) (CSR No.N200712120003) 
--/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   v_step := 'FREE IN(BKG-POL) 계정 삭제'; 
 
   /* 1,2,3순서로 붙는 단가는 붙여주지 않고 단지 LEA로만 IF한다. 
   1.cost_ass_bse_cd: Contrace/Average모두 단가를 붙여주지 않기위해 
   2.ctrt_rtn_flg: 'N'일 경우 붙여주는 Average단가를 붙이지 않기 위해 
   3.cost_asgn_calc_flg: 'Y'가 아닐경우SCC->ECC->LCC 단위로 Average단가를 붙이기 않기위해 
   */ 
   UPDATE      coa_com_cost_para b1  
   SET cost_ass_bse_cd='X', ctrt_rtn_flg='X', cost_asgn_calc_flg='Y'  
         WHERE EXISTS( 
                  SELECT 1 
                    FROM (SELECT /*+ index(a1 XAK3COA_COM_PARA) */ 
                                 a2.pctl_no 
                                ,a2.cost_act_grp_seq 
                                ,a2.cntr_tpsz_cd 
                                ,a2.coa_cost_src_cd 
                            FROM coa_com_para a1, coa_com_cost_para a2 
                           WHERE a1.bkg_no = in_bkg_no 
                             AND a1.bkg_rcv_term_cd = 'I'   -- RCV 
                             AND a2.cost_act_grp_cd = 'NOBT'   -- NOBT 
                             AND (SUBSTR(a2.coa_cost_src_cd, 1, 2) IN('TM', 'SV', 'TP', 'CG', 'SR') 
                                  OR SUBSTR(a2.coa_cost_src_cd, 1, 4) = '9230') --자가터미널 계정도 Free In 일 때 삭제 
                             AND a1.pctl_no = a2.pctl_no) b2 
                   WHERE b1.pctl_no = b2.pctl_no 
                     AND b1.cost_act_grp_seq = b2.cost_act_grp_seq 
                     AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd 
                     AND b1.coa_cost_src_cd = b2.coa_cost_src_cd); 
 
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 
 
   -- FREE OUT(BKG-POD) 계정 삭제 
   v_step := 'FREE OUT(BKG-POD) 계정 삭제'; 
 

   UPDATE      coa_com_cost_para b1  
   SET cost_ass_bse_cd='X', ctrt_rtn_flg='X', cost_asgn_calc_flg='Y'  
         WHERE EXISTS( 
                  SELECT 1 
                    FROM (SELECT /*+ index(a1 XAK3COA_COM_PARA) */ 
                                 a2.pctl_no 
                                ,a2.cost_act_grp_seq 
                                ,a2.cntr_tpsz_cd 
                                ,a2.coa_cost_src_cd 
                            FROM coa_com_para a1, coa_com_cost_para a2 
                           WHERE a1.bkg_no = in_bkg_no 
                             AND a1.bkg_de_term_cd = 'O'   -- DE 
                             AND a2.cost_act_grp_cd = 'NIBT'   -- NIBC 
                             AND (SUBSTR(a2.coa_cost_src_cd, 1, 2) IN('TM', 'SV', 'TP', 'CG', 'SR') 
                                  OR SUBSTR(a2.coa_cost_src_cd, 1, 4) = '9230')--자가터미널 계정도 Free Out 일 때 삭제 
                             AND a1.pctl_no = a2.pctl_no) b2 
                   WHERE b1.pctl_no = b2.pctl_no 
                     AND b1.cost_act_grp_seq = b2.cost_act_grp_seq 
                     AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd 
                     AND b1.coa_cost_src_cd = b2.coa_cost_src_cd); 
-- 
 
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 
 
   -- TACKLE(BKG-POL) 계정 삭제 
   v_step := 'TACKLE(BKG-POL) 계정 삭제'; 
 
    
   DELETE      coa_com_cost_para b1 
         WHERE EXISTS( 
                  SELECT 1 
                    FROM (SELECT /*+ index(a1 XAK3COA_COM_PARA) */ 
                                 a2.pctl_no 
                                ,a2.cost_act_grp_seq 
                                ,a2.cntr_tpsz_cd 
                                ,a2.coa_cost_src_cd 
                            FROM coa_com_para a1, coa_com_cost_para a2 
                           WHERE a1.bkg_no = in_bkg_no 
                             AND a1.bkg_rcv_term_cd = 'T'   -- RCV 
                             AND a2.cost_act_grp_cd = 'NOBT'   -- NOBT 
                             AND SUBSTR(a2.coa_cost_src_cd, 1, 2) = 'TM' 
                             AND a1.pctl_no = a2.pctl_no) b2 
                   WHERE b1.pctl_no = b2.pctl_no 
                     AND b1.cost_act_grp_seq = b2.cost_act_grp_seq 
                     AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd 
                     AND b1.coa_cost_src_cd = b2.coa_cost_src_cd); 
 
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 
 
   -- TACKLE(BKG-POD) 계정 삭제 
   v_step := 'TACKLE(BKG-POD) 계정 삭제'; 
 
   DELETE      coa_com_cost_para b1 
         WHERE EXISTS( 
                  SELECT 1 
                    FROM (SELECT /*+ index(a1 XAK3COA_COM_PARA) */ 
                                 a2.pctl_no 
                                ,a2.cost_act_grp_seq 
                                ,a2.cntr_tpsz_cd 
                                ,a2.coa_cost_src_cd 
                            FROM coa_com_para a1, coa_com_cost_para a2 
                           WHERE a1.bkg_no = in_bkg_no 
                             AND a1.bkg_de_term_cd = 'T'   -- DE 
                             AND a2.cost_act_grp_cd = 'NIBT'   -- NIBC 
                             AND SUBSTR(a2.coa_cost_src_cd, 1, 2) = 'TM' 
                             AND a1.pctl_no = a2.pctl_no) b2 
                   WHERE b1.pctl_no = b2.pctl_no 
                     AND b1.cost_act_grp_seq = b2.cost_act_grp_seq 
                     AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd 
                     AND b1.coa_cost_src_cd = b2.coa_cost_src_cd); 
 
--   enis_log_prc('', v_log_mod_nm, v_step || SQL%ROWCOUNT , v_appl_info); 
 

   RESULT := 1; 
   v_step := 'End'; 
   enis_log_prc('', v_log_mod_nm, v_step, v_appl_info); 
EXCEPTION 
   WHEN OTHERS 
   THEN 
      enis_log_prc('', v_log_mod_nm, 'ERROR: ' || v_step || ' > ' || SQLERRM, v_appl_info); 
      RESULT := 0; 
      RAISE; 
END COA_COST_ASSIGN_COP_PRC;