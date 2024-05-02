CREATE OR REPLACE PROCEDURE COA_BKG_COST_SMRY_PRC ( 
   in_bkg_no         IN       VARCHAR2 
  ,in_user_id        IN       VARCHAR2  
  ,in_is_del_para    IN       VARCHAR2 
  ,out_result        OUT      VARCHAR2 
) 
AUTHID CURRENT_USER 
IS 
/****************************************************************************** 
   Name         :   COA_RGST_BKG 
   Purpose      :   Booking의 테이블로부터 COA_RGST_BKG 
   Source       :   COA_BOOKING_V
   Target       :   COA_RGST_BKG   
   Revision History
       1. 2014.06.01 Initial Creation   
       2. 2014.11.13 PCM NYK Mty Repo Cost
       2. 2014.11.18 SMY Slot Internal Pricing      
******************************************************************************/ 
 
   --------------------------------[      Variable definition        ]----------------------- 
 
    /** 작업로그 관련 변수선언 **/ 
    v_coa_err_msg           VARCHAR(100); 
    v_bkg_sts_cd            COA_RGST_BKG.bkg_sts_cd%TYPE; 
    v_bzc_cost_yrmon        VARCHAR2(6); 
    v_appl_info             VARCHAR2(30); 
    v_prc_usr_id            VARCHAR2(20)   := in_user_id; 
    v_prc_sys_date          DATE           := SYSDATE;     
--  v_lea_cfm_dt            bkg_booking.bkg_cfm_snt_dt%TYPE; 
    v_skd_voy_no            VARCHAR2(4); 
    v_cop_sts_cd            CHAR(1); 
    v_booking_cnt           NUMBER(3); 
    v_booking_smry_cnt      NUMBER(3); 
    

    v_bkg_month            coa_mon_vvd.cost_yrmon%TYPE; 
    v_cost_calc_lea        CHAR(1); 
 
 
 
BEGIN 
    v_appl_info := in_bkg_no; 
    enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'V.20141118', v_appl_info); 
     
    -- Initialization
    out_result := 'Y'; 
    v_skd_voy_no := 'XXXX'; 
        
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- Search base year month
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   SELECT coa_bzc_cost_yrmon_fnc(in_bkg_no) bzc_cost_yrmon 
     INTO v_bzc_cost_yrmon 
     FROM dual;     
 
---------------------------------[ COA_BKG_COST_DTL Summary ]----------------------- 
 
 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
-- COA_BKG_COST_ACT_GRP_SMRY(INQUIRY BY BKG) 
--///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
 
   DELETE FROM COA_BKG_COST_ACT_GRP_SMRY WHERE BKG_NO       = IN_BKG_NO; 
--  enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'COA_BKG_COST_ACT_GRP_SMRY ' || SQL%ROWCOUNT || ' delete', v_appl_info); 
 
    INSERT INTO COA_BKG_COST_ACT_GRP_SMRY( BKG_NO, 
      CNTR_TPSZ_CD, 
      COST_ROUT_NO, 
      COST_ACT_GRP_SEQ, 
      NOD_LNK_ROUT_NM, 
      STND_COST_CD, 
      COST_ACT_GRP_CD, 
      COST_YRMON, 
      CNTR_QTY, 
      ESTM_USD_TTL_AMT, 
      RESPB_USD_TTL_AMT, 
      WTR_RCV_TERM_CD, 
      WTR_DE_TERM_CD, 
      DELT_FLG, 
      CRE_USR_ID, 
      CRE_DT, 
      UPD_USR_ID, 
      UPD_DT,
      ESTM_USD_TTL_AMT2
      ) 
    (SELECT BKG_NO, 
      CNTR_TPSZ_CD, 
      COST_ROUT_NO, 
      COST_ACT_GRP_SEQ, 
      NVL(NOD_LNK_ROUT, ' '), 
      STND_COST_CD, 
      COST_ACT_GRP_CD, 
      COST_YRMON, 
      CNTR_QTY, 
      SUM(ESTM_USD_TTL_AMT) ESTM_USD_TTL_AMT, 
      SUM(RESPB_USD_TTL_AMT) RESPB_USD_TTL_AMT, 
      WTR_RCV_TERM_CD, 
      WTR_DE_TERM_CD, 
      DELT_FLG, 
      v_prc_usr_id, 
      v_prc_sys_date, 
      v_prc_usr_id, 
      v_prc_sys_date,
      SUM(ESTM_USD_TTL_AMT2) ESTM_USD_TTL_AMT2
     FROM ( WITH BOOKING AS ( 
            SELECT A2.COST_YRMON , 
              A3.BKG_NO 
            FROM COA_MON_VVD A2, 
              COA_RGST_BKG A3 
            WHERE 1 = 1 
              AND A3.BKG_NO = IN_BKG_NO 
              AND A3.BL_NO_TP IN ('M', '0') --REPORT 기본 조건 
              AND A3.BKG_STS_CD IN ('F', 'S', 'W') --REPORT 기본 조건 
              AND A3.BKG_CGO_TP_CD NOT IN ('P') --REPORT 기본 조건 
              AND A2.DELT_FLG = 'N' --REPORT 기본 조건 
              AND A2.TRD_CD = A3.TRD_CD 
              AND A2.RLANE_CD = A3.RLANE_CD 
              AND A2.IOC_CD = A3.IOC_CD 
              AND A2.VSL_CD = A3.VSL_CD 
              AND A2.SKD_VOY_NO = A3.SKD_VOY_NO 
              AND A2.DIR_CD = A3.DIR_CD) 
        SELECT B2.COST_YRMON, 
          B1.BKG_NO, 
          B1.CNTR_TPSZ_CD, 
          B1.COST_ROUT_NO, 
          B1.CNTR_QTY, 
          B1.COST_ACT_GRP_SEQ, 
          B1.COST_ACT_GRP_CD, 
          DECODE(B1.N1ST_NOD_CD, B1.N2ND_NOD_CD, B1.N1ST_NOD_CD , DECODE(B1.N1ST_NOD_CD, NULL, ' ' , B1.N1ST_NOD_CD) ||DECODE(B1.N2ND_NOD_CD, NULL, ' ' , ' -> ' || B1.N2ND_NOD_CD) ||DECODE(B1.N3RD_NOD_CD, NULL, ' ' , ' -> ' || B1.N3RD_NOD_CD) ||DECODE(B1.N4TH_NOD_CD, NULL, ' ' , ' -> ' || B1.N4TH_NOD_CD)) NOD_LNK_ROUT, 
          B1.STND_COST_CD, 
          B1.WTR_RCV_TERM_CD, 
          B1.WTR_DE_TERM_CD, 
          B1.ESTM_USD_TTL_AMT, 
          B1.RESPB_USD_TTL_AMT, 
          B1.DELT_FLG,
          B1.ESTM_USD_TTL_AMT2
        FROM COA_BKG_COST_SRC_DTL B1, 
          BOOKING B2 
        WHERE B1.BKG_NO = B2.BKG_NO 
          AND DELT_FLG = 'N' 
          AND (NVL(b1.ESTM_USD_TTL_AMT,0)<>0 OR NVL(b1.RESPB_USD_TTL_AMT,0)<>0) 
          ) 
    GROUP BY BKG_NO, CNTR_TPSZ_CD, COST_ROUT_NO, COST_ACT_GRP_SEQ, NVL(NOD_LNK_ROUT, ' '), STND_COST_CD, COST_ACT_GRP_CD, COST_YRMON, CNTR_QTY, WTR_RCV_TERM_CD, WTR_DE_TERM_CD, DELT_FLG 
    ); 
--   enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'COA_BKG_COST_ACT_GRP_SMRY ' || SQL%ROWCOUNT || ' insert', v_appl_info); 
 
 
 
 
 
   --   -- delete 
   DELETE FROM coa_bkg_cost_smry 
         WHERE bkg_no       = in_bkg_no; 
 
--  enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'coa_bkg_cost_smry ' || SQL%ROWCOUNT || ' delete', v_appl_info); --++ 
 
   -- stnd_cost_cd = 'LOAD0000" 데이터추가 
   INSERT INTO coa_bkg_cost_smry 
               (bkg_no 
               ,stnd_cost_cd 
               ,cntr_tpsz_cd 
               ,sgrp_cost_cd 
               ,cntr_qty 
               ,ra_acct_cd 
               ,estm_uc_amt 
               ,ra_uc_amt 
               ,act_uc_amt 
               ,past_flg 
               ,accl_rt_amt 
               ,rlane_cd 
               ,ioc_cd 
               ,vsl_cd 
               ,skd_voy_no 
               ,skd_dir_cd 
               ,cost_cond_cd 
               ,cost_rout_no 
               ,spcl_rc_flg 
               ,spcl_dg_cgo_flg 
               ,spcl_bb_cgo_flg 
               ,spcl_awk_cgo_flg 
               ,rd_flg 
               ,soc_flg 
               ,estm_usd_ttl_amt 
               ,respb_usd_ttl_amt 
               ,estm_usd_uc_amt 
               ,respb_usd_uc_amt 
               ,fcgo_tz_dys 
               ,fcgo_tz_hrs 
               ,mcgo_tz_dys 
               ,mcgo_tz_hrs 
               ,delt_flg 
               ,cre_usr_id 
               ,cre_dt 
               ,upd_usr_id 
               ,upd_dt
               ,estm_usd_ut_amt2
               ,estm_usd_ttl_amt2
               ) 
      (SELECT   a.bkg_no 
               ,'LOAD0000' stnd_cost_cd 
               ,b.cntr_tpsz_cd 
               ,'COMN' sgrp_cost_cd 
               ,AVG(NVL(b.cntr_qty, 0)) cntr_qty 
               ,' ' ra_acct_cd 
               ,0 estm_uc_amt 
               ,0 ra_uc_amt 
               ,0 act_uc_amt 
               ,'U' past_flg   -- flag 
               ,SUM(NVL(b.accl_rt_amt, 0)) accl_rt_amt 
               ,MAX(a.rlane_cd) rlane_cd 
               ,MAX(a.ioc_cd) ioc_cd 
               ,MAX(a.vsl_cd) vsl_cd 
               ,MAX(a.skd_voy_no) skd_voy_no 
               ,MAX(a.dir_cd) skd_dir_cd 
               ,'Y' cost_cond_cd   -- flag 
               ,b.cost_rout_no 
               ,MAX(b.spcl_rc_flg) spcl_rc_flg 
               ,MAX(b.spcl_dg_cgo_flg) spcl_dg_cgo_flg 
               ,MAX(b.spcl_bb_cgo_flg) spcl_bb_cgo_flg 
               ,MAX(b.spcl_awk_cgo_flg) spcl_awk_cgo_flg 
               ,MAX(b.rd_flg) rd_flg 
               ,MAX(b.soc_flg) soc_flg 
               ,0 estm_usd_ttl_amt 
               ,0 respb_usd_ttl_amt 
               ,0 estm_usd_uc_amt 
               ,0 respb_usd_uc_amt 
               ,AVG(fcgo_tz_dys) fcgo_tz_dys 
               ,AVG(fcgo_tz_hrs) fcgo_tz_hrs 
               ,AVG(mcgo_tz_dys) mcgo_tz_dys 
               ,AVG(mcgo_tz_hrs) mcgo_tz_hrs 
               ,MAX(delt_flg) delt_flg 
               ,in_user_id cre_usr_id 
               ,SYSDATE cre_dt 
               ,in_user_id upd_usr_id 
               ,SYSDATE upd_dt
               ,0 estm_usd_ut_amt2
               ,0 estm_usd_ttl_amt2
           FROM COA_RGST_BKG a, coa_bkg_cost_src_dtl b 
          WHERE a.bkg_no = in_bkg_no 
--            AND a.BZC_COST_YRMON = b.BZC_COST_YRMON 
            AND a.bkg_no = b.bkg_no 
       GROUP BY a.bkg_no, b.cntr_tpsz_cd, b.cost_rout_no); 
 
--   enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'coa_bkg_cost_smry 1st ' || SQL%ROWCOUNT || ' insert', v_appl_info); --++ 
 
   --'LOAD0000' 을 제외한 나머지 데이터 추가 
   INSERT INTO coa_bkg_cost_smry 
               (bkg_no 
               ,stnd_cost_cd 
               ,cntr_tpsz_cd 
               ,sgrp_cost_cd 
               ,cntr_qty 
               ,ra_acct_cd 
               ,estm_uc_amt 
               ,ra_uc_amt 
               ,act_uc_amt 
               ,past_flg 
               ,accl_rt_amt 
               ,rlane_cd 
               ,ioc_cd 
               ,vsl_cd 
               ,skd_voy_no 
               ,skd_dir_cd 
               ,cost_cond_cd 
               ,cost_rout_no 
               ,spcl_rc_flg 
               ,spcl_dg_cgo_flg 
               ,spcl_bb_cgo_flg 
               ,spcl_awk_cgo_flg 
               ,rd_flg 
               ,soc_flg 
               ,estm_usd_ttl_amt 
               ,respb_usd_ttl_amt 
               ,estm_usd_uc_amt 
               ,respb_usd_uc_amt 
               ,fcgo_tz_dys 
               ,fcgo_tz_hrs 
               ,mcgo_tz_dys 
               ,mcgo_tz_hrs 
               ,delt_flg 
               ,ts_seq -- 2014.11.18 Slot Internal Pricing
               ,cre_usr_id 
               ,cre_dt 
               ,upd_usr_id 
               ,upd_dt
               ,estm_usd_ut_amt2
               ,estm_usd_ttl_amt2
               ) 
      (SELECT   a.bkg_no 
               ,b.stnd_cost_cd 
               ,b.cntr_tpsz_cd 
               ,MAX(c.sgrp_cost_cd) sgrp_cost_cd 
               ,AVG(NVL(b.cntr_qty, 0)) cntr_qty 
               ,MAX(b.ra_acct_cd) ra_acct_cd 
               ,SUM(NVL(b.estm_usd_uc_amt, 0)) estm_uc_amt   -- SUM 하기 전에 경리환율적용(박칠서) 
               ,SUM(NVL(b.respb_usd_ttl_amt, 0)) ra_uc_amt 
               ,SUM(NVL(b.act_uc_amt, 0)) act_uc_amt 
               ,'U' past_flg   -- flag 
               ,SUM(NVL(b.accl_rt_amt, 0)) accl_rt_amt 
               ,MAX(a.rlane_cd) rlane_cd 
               ,MAX(a.ioc_cd) ioc_cd 
               ,MAX(a.vsl_cd) vsl_cd 
               ,MAX(a.skd_voy_no) skd_voy_no 
               ,MAX(a.dir_cd) skd_dir_cd 
               ,'Y' cost_cond_cd   -- flag 
               ,b.cost_rout_no 
               ,MAX(b.spcl_rc_flg) spcl_rc_flg 
               ,MAX(b.spcl_dg_cgo_flg) spcl_dg_cgo_flg 
               ,MAX(b.spcl_bb_cgo_flg) spcl_bb_cgo_flg 
               ,MAX(b.spcl_awk_cgo_flg) spcl_awk_cgo_flg 
               ,MAX(b.rd_flg) rd_flg 
               ,MAX(b.soc_flg) soc_flg 
               ,SUM(NVL(b.estm_usd_ttl_amt, 0)) estm_usd_ttl_amt 
               ,SUM(NVL(b.respb_usd_ttl_amt, 0)) respb_usd_ttl_amt 
               ,SUM(NVL(b.estm_usd_uc_amt, 0)) estm_usd_uc_amt 
               ,SUM(NVL(b.respb_usd_uc_amt, 0)) respb_usd_uc_amt 
               ,AVG(fcgo_tz_dys) fcgo_tz_dys 
               ,AVG(fcgo_tz_hrs) fcgo_tz_hrs 
               ,AVG(mcgo_tz_dys) mcgo_tz_dys 
               ,AVG(mcgo_tz_hrs) mcgo_tz_hrs 
               ,MAX(b.delt_flg) delt_flg 
               
               -- 2014.11.18 Slot Internal Pricing               
               ,CASE
                WHEN b.STND_COST_CD = '54600001' THEN              
                    CASE
                    WHEN b.vsl_slan_cd = SUBSTR(a.n1st_rlane_cd,1,3)  AND substr(b.NOD_CD,1,5)  = a.N1ST_POL_CD   and substr(b.TO_NOD_CD,1,5) = a.N1ST_POD_CD
                        THEN 1
                    WHEN b.vsl_slan_cd = SUBSTR(a.N2ND_RLANE_CD,1,3)  AND substr(b.NOD_CD,1,5)  = a.N2ND_POL_CD   and substr(b.TO_NOD_CD,1,5) = a.N2ND_POD_CD
                        THEN 2
                    WHEN b.vsl_slan_cd = SUBSTR(a.N3RD_RLANE_CD,1,3)  AND substr(b.NOD_CD,1,5)  = a.N3RD_POL_CD   and substr(b.TO_NOD_CD,1,5) = a.N3RD_POD_CD
                        THEN 3
                    ELSE 4
                    END     
                ELSE 0
                END TS_SEQ                 
               
               ,in_user_id cre_usr_id 
               ,SYSDATE cre_dt 
               ,in_user_id upd_usr_id 
               ,SYSDATE upd_dt
               ,SUM(NVL(b.estm_usd_ut_amt2, 0)) estm_usd_ut_amt2
               ,SUM(NVL(b.estm_usd_ttl_amt2, 0)) estm_usd_ttl_amt2
           FROM COA_RGST_BKG a, coa_bkg_cost_src_dtl b, coa_stnd_acct c 
          WHERE a.bkg_no       = in_bkg_no 
            AND a.bkg_no       = b.bkg_no 
            AND b.stnd_cost_cd = c.stnd_cost_cd 
       GROUP BY a.bkg_no, b.stnd_cost_cd, b.cntr_tpsz_cd, b.cost_rout_no
               -- 2014.11.18 Slot Internal Pricing               
               ,CASE
                WHEN b.STND_COST_CD = '54600001' THEN              
                    CASE
                    WHEN b.vsl_slan_cd = SUBSTR(a.n1st_rlane_cd,1,3)  AND substr(b.NOD_CD,1,5)  = a.N1ST_POL_CD   and substr(b.TO_NOD_CD,1,5) = a.N1ST_POD_CD
                        THEN 1
                    WHEN b.vsl_slan_cd = SUBSTR(a.N2ND_RLANE_CD,1,3)  AND substr(b.NOD_CD,1,5)  = a.N2ND_POL_CD   and substr(b.TO_NOD_CD,1,5) = a.N2ND_POD_CD
                        THEN 2
                    WHEN b.vsl_slan_cd = SUBSTR(a.N3RD_RLANE_CD,1,3)  AND substr(b.NOD_CD,1,5)  = a.N3RD_POL_CD   and substr(b.TO_NOD_CD,1,5) = a.N3RD_POD_CD
                        THEN 3
                    ELSE 4
                    END     
                ELSE 0
                END            
       
       ); 
 
--   enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'coa_bkg_cost_smry 2nd ' || SQL%ROWCOUNT || ' insert', v_appl_info); --++ 
 
   ------------------------------------------------------------------------------------------------------ 
 
    
 
   /* ----------------------------------------------------------------------------------------------------- 
       STEP 2: 최종으로 COA BOOKING REVENUE DETAIL에  정보 UPDATE 하기 
               stnd_cost_cd = '92404011', '91401011', '41101011','LOAD0001' 데이터를 제외하고 올려준다. 
               2008.07.01 MERGER INTO로 로직 변경 COA_BKG_REV_DTL_PRC로 부터 Dead Space 로직을 분리하여 COA_BKG_COS_SMRY_PRC로 이동 
               2008.11.10 Dead Space 로직을 COA_BKG_REV_DTL_PRC로 이동 
     ----------------------------------------------------------------------------------------------------- */ 
 
    --해당 부킹이 rev_dtl에 있는지 확인 
    BEGIN 
        SELECT COUNT(*) 
          INTO v_booking_cnt 
          FROM coa_bkg_rev_dtl 
         WHERE bkg_no       = in_bkg_no; 
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN 
            BEGIN 
                v_booking_cnt := 0; 
            END; 
    END;   
    
    IF v_booking_cnt>0 THEN  
        /* 1. 비용 Update -------------------------------------------------------------------------------------*/
        MERGE INTO coa_bkg_rev_dtl k 
        USING ( 
          SELECT bkg_no 
                ,cntr_tpsz_cd 
                ,MAX(cntr_qty) cntr_qty 
--                , SUM(estm_cm_cost_amt) + SUM(common_amt) - SUM(demdet_estm) estm_cm_cost_amt   --cm에 common_amt를 더해준다. cm에 dem/det를 - 해준다 
--                ,SUM(estm_opfit_cost_amt) estm_opfit_cost_amt 
--                , SUM(ra_cm_cost_amt) + SUM(common_amt) - SUM(demdet_ra) ra_cm_cost_amt 
--                ,SUM(ra_opfit_cost_amt) ra_opfit_cost_amt 
                , SUM(estm_cm_cost_amt) + SUM(common_amt) estm_cm_cost_amt   --cm에 common_amt를 더해준다. cm에 dem/det를 - 해준다(CM/OP변경으로 dem/det삭제) 
                , SUM(estm_cm_cost_amt2) + SUM(common_amt) estm_cm_cost_amt2   --C.M Park EPP B 단가
                , SUM(estm_opfit_cost_amt) - SUM(demdet_estm) estm_opfit_cost_amt 
                , SUM(ra_cm_cost_amt) + SUM(common_amt) ra_cm_cost_amt 
                , SUM(ra_opfit_cost_amt) - SUM(demdet_ra) ra_opfit_cost_amt 
                ,SUM(accl_rt_amt) accl_rt_amt 
                ,in_user_id upd_usr_id 
                ,SYSDATE upd_dt 
                ,MAX(spcl_rc_flg) spcl_rc_flg   --spcl 
                ,MAX(spcl_dg_cgo_flg) spcl_dg_cgo_flg 
                ,MAX(spcl_bb_cgo_flg) spcl_bb_cgo_flg 
                ,MAX(spcl_awk_cgo_flg) spcl_awk_cgo_flg 
                ,MAX(rd_flg) rd_flg 
                ,MAX(soc_flg) soc_flg 
                ,cost_rout_no 
                ,MIN(delt_flg) delt_flg 
                ,AVG(fcgo_tz_dys) fcgo_tz_dys 
                ,AVG(fcgo_tz_hrs) fcgo_tz_hrs 
                ,AVG(mcgo_tz_dys) mcgo_tz_dys 
                ,AVG(mcgo_tz_hrs) mcgo_tz_hrs 
           FROM ( 
                 SELECT a1.bkg_no 
                       ,a1.cntr_tpsz_cd 
                       ,a1.cntr_qty 
                       , a4.stnd_cost_tp_cd || a4.coa_cost_src_prt_cd cd   -- stnd_cost_tp_cd:(C, O) coa_cost_src_prt_cd:(PA, RA, CO) 
                       --,estm_usd_ttl_amt --,respb_usd_ttl_amt 
                       ,a1.stnd_cost_cd 
                       ,a4.stnd_cost_tp_cd 
                       ,a4.coa_cost_src_prt_cd 
                       ,DECODE(a4.stnd_cost_tp_cd || a4.coa_cost_src_prt_cd, 'CPA', NVL(estm_usd_ttl_amt, 0), 0) estm_cm_cost_amt 
                       ,DECODE(a4.stnd_cost_tp_cd || a4.coa_cost_src_prt_cd, 'CPA', NVL(estm_usd_ttl_amt2, 0), 0) estm_cm_cost_amt2 --C.M Park EPP B 단가
                       ,DECODE(a4.stnd_cost_tp_cd || a4.coa_cost_src_prt_cd, 'OPA', NVL(estm_usd_ttl_amt, 0), 0) estm_opfit_cost_amt 
                       ,DECODE(a4.stnd_cost_tp_cd || a4.coa_cost_src_prt_cd, 'CRA', NVL(respb_usd_ttl_amt, 0), 0) ra_cm_cost_amt 
                       ,DECODE(a4.stnd_cost_tp_cd || a4.coa_cost_src_prt_cd, 'ORA', NVL(respb_usd_ttl_amt, 0), 0) ra_opfit_cost_amt 
                       --,DECODE(a4.coa_cost_src_prt_cd, 'CO', NVL(estm_usd_ttl_amt, 0), 0) common_amt 
                       ,DECODE(a4.stnd_cost_tp_cd || a4.coa_cost_src_prt_cd, 'CCO', NVL(estm_usd_ttl_amt, 0), 0) common_amt 
                       ,DECODE(a1.stnd_cost_cd, '43201011', NVL(estm_usd_ttl_amt, 0), 0) demdet_estm 
                       ,DECODE(a1.stnd_cost_cd, '43201011', NVL(respb_usd_ttl_amt, 0), 0) demdet_ra 
                       ,a1.accl_rt_amt 
                       ,a1.spcl_rc_flg 
                       ,a1.spcl_dg_cgo_flg 
                       ,a1.spcl_bb_cgo_flg 
                       ,a1.spcl_awk_cgo_flg 
                       ,a1.rd_flg 
                       ,a1.soc_flg 
                       ,a1.cost_rout_no 
                       ,a1.delt_flg 
                       ,a1.fcgo_tz_dys 
                       ,a1.fcgo_tz_hrs 
                       ,a1.mcgo_tz_dys 
                       ,a1.mcgo_tz_hrs 
                   FROM coa_bkg_cost_smry a1, coa_stnd_acct a2, coa_mn_grp_cost a3, coa_stnd_acct_v a4 
                  WHERE 1 = 1 
                    AND a1.bkg_no       = in_bkg_no 
                    AND a1.stnd_cost_cd = a2.stnd_cost_cd 
                    AND a2.mgrp_cost_cd = a3.mgrp_cost_cd 
                    AND a1.stnd_cost_cd = a4.stnd_cost_cd 
                    AND a4.pa_vw        = 'BKG' 
                  --AND a1.stnd_cost_cd <>'43201011' 
                ) 
          GROUP BY bkg_no, cntr_tpsz_cd, cost_rout_no 
        ) m 
        ON (    k.bkg_no       = m.bkg_no                                                  
            AND k.cntr_tpsz_cd = m.cntr_tpsz_cd                          
            AND k.cost_rout_no = m.cost_rout_no)                         
        WHEN MATCHED THEN                                                
            UPDATE                                                       
                SET k.bkg_qty             = m.cntr_qty 
                   ,k.estm_cm_cost_amt    = m.estm_cm_cost_amt
                   ,k.estm_cm_cost_amt2   = m.estm_cm_cost_amt2
                   ,k.estm_opfit_cost_amt = m.estm_opfit_cost_amt 
                   ,k.ra_cm_cost_amt      = m.ra_cm_cost_amt 
                   ,k.ra_opfit_cost_amt   = m.ra_opfit_cost_amt 
                   ,k.accl_rt_amt         = m.accl_rt_amt 
--                   ,k.spcl_rc_flg         = m.spcl_rc_flg 
--                   ,k.spcl_dg_cgo_flg     = m.spcl_dg_cgo_flg 
--                   ,k.spcl_bb_cgo_flg     = m.spcl_bb_cgo_flg 
--                   ,k.spcl_awk_cgo_flg    = m.spcl_awk_cgo_flg 
--                   ,k.rd_flg              = m.rd_flg 
--                   ,k.soc_flg             = m.soc_flg 
                   ,k.delt_flg            = m.delt_flg 
                   ,k.fcgo_tz_dys         = m.fcgo_tz_dys 
                   ,k.fcgo_tz_hrs         = m.fcgo_tz_hrs 
                   ,k.mcgo_tz_dys         = m.mcgo_tz_dys 
                   ,k.mcgo_tz_hrs         = m.mcgo_tz_hrs 
                   ,k.upd_usr_id          = m.upd_usr_id                        
                   ,k.upd_dt              = m.upd_dt 
        ; 
--       enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'coa_bkg_rev_dtl ' || SQL%ROWCOUNT || ' update', v_appl_info); --++ 
         
             
             
    END IF; 
--      enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'line 723 coa_bkg_rev_dtl ' || SQL%ROWCOUNT || 'merge update', v_appl_info); --++ 
    /* ------------------------------------------------------------------------------------------------------------- */ 
     
 
   /* ----------------------------------------------------------------------------------------------------- 
       STEP 4: coa_bkg_cost_smry, coa_bkg_svc_trns_smry , coa_bkg_lgs_smry 테이블의 정보를 변경한다. 
               2008.07.01 COA_BKG_REV_DTL_PRC로 부터 분리하여 COA_BKG_COS_SMRY_PRC로 이동 
               2009.03.02 coa_bkg_svc_trns_smry계산 로직 하단으로 이동 
     ----------------------------------------------------------------------------------------------------- */ 
 
    IF v_booking_cnt > 0 THEN 
        /* 
          coa_bkg_rev_dtl 데이터를 이용하여 coa_bkg_cost_smry 테이블에 
          stnd_cost_cd ='41101011' 인 데이터를 넣어준다.(있으면 update, 없으면 insert) 
          2008.05.08 Freight Revenue로 몰아주던 것을 Freight/Misc Operation Revenue로 각각 나누어서 Revenue를 summary에 적용한다. 
        */ 
        /* coa_bkg_cost_smry 테이블에 정보를 입력한다 ---------------------------------------------------------------*/ 
        MERGE INTO coa_bkg_cost_smry a 
           USING ( 
                  SELECT bkg_no 
                        ,b.stnd_cost_cd 
                        ,cntr_tpsz_cd 
                        ,cost_rout_no 
                        ,b.sgrp_cost_cd 
                        ,bkg_qty cntr_qty 
                        ,DECODE(b.stnd_cost_cd, '41101011', DECODE(bkg_qty, 0, 0, NVL(bkg_rev, 0) + NVL(bkg_oft_rev, 0)),  
                                                '43207011', DECODE(bkg_qty, 0, 0, NVL(bkg_misc_rev, 0) + NVL(scr_chg_rev, 0))) estm_usd_uc_amt 
                        ,DECODE(b.stnd_cost_cd, '41101011', DECODE(bkg_qty, 0, 0, NVL(bkg_rev, 0) + NVL(bkg_oft_rev, 0)), 
                                                '43207011', DECODE(bkg_qty, 0, 0, NVL(bkg_misc_rev, 0) + NVL(scr_chg_rev, 0))) estm_usd_ttl_amt 
                        ,DECODE(b.stnd_cost_cd, '41101011', DECODE(bkg_qty, 0, 0, NVL(bkg_rev, 0) + NVL(bkg_oft_rev, 0)), 
                                                '43207011', DECODE(bkg_qty, 0, 0, NVL(bkg_misc_rev, 0) + NVL(scr_chg_rev, 0))) respb_usd_uc_amt 
                        ,DECODE(b.stnd_cost_cd, '41101011', DECODE(bkg_qty, 0, 0, NVL(bkg_rev, 0) + NVL(bkg_oft_rev, 0)),  
                                                '43207011', DECODE(bkg_qty, 0, 0, NVL(bkg_misc_rev, 0) + NVL(scr_chg_rev, 0))) respb_usd_ttl_amt 
                        ,'SYSTEM_COA' cre_usr_id 
                        ,SYSDATE cre_dt 
                        ,'SYSTEM_COA' upd_usr_id 
                        ,SYSDATE upd_dt 
                        ,accl_rt_amt 
                        ,'I' past_flg_i 
                        ,'U' past_flg_u 
                    FROM coa_bkg_rev_dtl a 
                        ,( 
                           SELECT stnd_cost_cd, sgrp_cost_cd 
                             FROM coa_stnd_acct 
                            WHERE stnd_cost_cd in ('41101011','43207011') 
                         ) b 
                   WHERE a.bkg_no       = in_bkg_no 
                 ) b 
           ON (    a.bkg_no       = b.bkg_no 
               AND a.stnd_cost_cd = b.stnd_cost_cd 
               AND a.cntr_tpsz_cd = b.cntr_tpsz_cd 
               AND a.cost_rout_no = b.cost_rout_no) 
           WHEN MATCHED THEN 
              UPDATE 
                 SET a.sgrp_cost_cd      = b.sgrp_cost_cd 
                    ,a.cntr_qty          = b.cntr_qty 
                    ,a.estm_usd_uc_amt   = b.estm_usd_uc_amt 
                    ,a.estm_usd_ttl_amt  = b.estm_usd_ttl_amt 
                    ,a.respb_usd_uc_amt  = b.respb_usd_uc_amt 
                    ,a.respb_usd_ttl_amt = b.respb_usd_ttl_amt 
                    ,a.upd_usr_id        = b.upd_usr_id 
                    ,a.upd_dt            = b.upd_dt 
                    ,a.accl_rt_amt       = b.accl_rt_amt 
                    ,a.past_flg          = past_flg_u 
           WHEN NOT MATCHED THEN 
              INSERT(a.bkg_no, a.stnd_cost_cd, a.cntr_tpsz_cd, a.cost_rout_no, a.sgrp_cost_cd, a.cntr_qty, a.estm_usd_uc_amt 
                    ,a.estm_usd_ttl_amt, a.respb_usd_uc_amt, a.respb_usd_ttl_amt, a.accl_rt_amt, a.past_flg, a.cre_usr_id, a.cre_dt, a.upd_usr_id, a.upd_dt) 
              VALUES(b.bkg_no, b.stnd_cost_cd, b.cntr_tpsz_cd, b.cost_rout_no, b.sgrp_cost_cd, b.cntr_qty, b.estm_usd_uc_amt 
                    ,b.estm_usd_ttl_amt, b.respb_usd_uc_amt, b.respb_usd_ttl_amt, b.accl_rt_amt, b.past_flg_i, b.cre_usr_id, b.cre_dt, b.upd_usr_id, b.upd_dt); 
         
--        enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'line 695 coa_bkg_cost_smry ' || SQL%ROWCOUNT || 'merge update', v_appl_info); --++ 
--        enis_log_prc (SYSDATE, 'COA_BKG_REV_DTL_PRC', ' line 820 요약전' || TO_CHAR(SYSDATE, 'yyyy/mm/dd hh24:mi:ss'), v_appl_info); --++ 
        /* coa_bkg_cost_smry 테이블에 정보를 입력한다_END -----------------------------------------------------------*/ 
 
 
     
        /* coa_bkg_lgs_smry 테이블에 정보를 입력한다 ----------------------------------------------------------------*/ 
        --기존 데이터 삭제 
        DELETE FROM coa_bkg_lgs_smry 
              WHERE 1 = 1 
                AND bkg_no       = in_bkg_no; 
         
        INSERT INTO coa_bkg_lgs_smry 
                    (bkg_no 
                    ,cntr_tpsz_cd 
                    ,COST_ACT_GRP_CD 
                    ,sttl_flg 
                    ,n1st_nod_cd 
                    ,n2nd_nod_cd 
                    ,n3rd_nod_cd 
                    ,n4th_nod_cd 
                    ,ctrl_ofc_cd 
                    ,rhq_cd 
                    ,cost_act_grp_tp_cd 
                    ,cost_io_bnd_cd 
                    ,PRE_COST_ACT_GRP_CD   
                    ,PST_COST_ACT_GRP_CD  
                    ,pre_act_grp_de_term_cd 
                    ,pst_act_grp_rcv_term_cd 
                    ,void_20ft_qty 
                    ,void_40ft_qty 
                    ,cntr_qty 
                    ,bzc_stvg_amt 
                    ,otr_cy_hndl_amt 
                    ,ts_stvg_amt 
                    ,dck_cy_hndl_amt 
                    ,cgo_hndl_amt 
                    ,fcntr_sto_amt 
                    ,misc_cgo_hndl_amt 
                    ,fcntr_trsp_rail_dir_amt 
                    ,fcntr_trsp_rail_trk_amt 
                    ,fcntr_trsp_trk_dir_amt 
                    ,fcntr_trsp_wtr_dir_amt 
                    ,fcntr_trsp_wtr_rail_amt 
                    ,fcntr_trsp_wtr_trk_amt 
                    ,misc_fcntr_trsp_amt 
                    ,fcntr_trsp_fuel_scg_amt 
                    ,tml_amt 
                    ,fcntr_stvg_ttl_amt 
                    ,fcntr_trsp_ttl_amt 
                    ,bkg_qty 
                    ,lgs_kpi_mn_cd 
                    ,lgs_kpi_cd 
                    ,cre_usr_id 
                    ,cre_dt 
                    ,upd_usr_id 
                    ,upd_dt 
                    )   
           SELECT   b2.bkg_no 
                   ,b2.cntr_tpsz_cd 
                   ,b2.COST_ACT_GRP_CD 
                   ,b2.sttl_flg 
                   ,NVL(b2.n1st_nod_cd, 'XXXXXXX') n1st_nod_cd 
                   ,NVL(b2.n2nd_nod_cd, 'XXXXXXX') n2nd_nod_cd 
                   ,NVL(b2.n3rd_nod_cd, 'XXXXXXX') n3rd_nod_cd 
                   ,NVL(b2.n4th_nod_cd, 'XXXXXXX') n4th_nod_cd 
                   ,b2.ctrl_ofc_cd 
                   ,NVL(b1.ar_hd_qtr_ofc_cd, 'NONHQ') rhq_cd 
                   ,b2.cost_act_grp_tp_cd 
                   ,b2.cost_io_bnd_cd    
                   ,NVL(b2.PRE_COST_ACT_GRP_CD, 'XXXX') PRE_COST_ACT_GRP_CD 
                   ,NVL(b2.PST_COST_ACT_GRP_CD, 'XXXX') PST_COST_ACT_GRP_CD 
                   ,NVL(b2.pre_act_grp_de_term_cd, 'X') pre_act_grp_de_term_cd 
                   ,NVL(b2.pst_act_grp_rcv_term_cd, 'X') pst_act_grp_rcv_term_cd 
                   ,b4.void_20ft_qty  
                   ,b4.void_40ft_qty 
                   ,SUM(b2.cntr_qty)                cntr_qty 
                   ,SUM(b2.bzc_stvg_amt)            bzc_stvg_amt 
                   ,SUM(b2.otr_cy_hndl_amt)         otr_cy_hndl_amt 
                   ,SUM(b2.ts_stvg_amt)             ts_stvg_amt 
                   ,SUM(b2.dck_cy_hndl_amt)         dck_cy_hndl_amt 
                   ,SUM(b2.cgo_hndl_amt)            cgo_hndl_amt 
                   ,SUM(b2.fcntr_sto_amt)           fcntr_sto_amt 
                   ,SUM(b2.misc_cgo_hndl_amt)       misc_cgo_hndl_amt 
                   ,SUM(b2.fcntr_trsp_rail_dir_amt) fcntr_trsp_rail_dir_amt 
                   ,SUM(b2.fcntr_trsp_rail_trk_amt) fcntr_trsp_rail_trk_amt 
                   ,SUM(b2.fcntr_trsp_trk_dir_amt)  fcntr_trsp_trk_dir_amt 
                   ,SUM(b2.fcntr_trsp_wtr_dir_amt)  fcntr_trsp_wtr_dir_amt 
                   ,SUM(b2.fcntr_trsp_wtr_rail_amt) fcntr_trsp_wtr_rail_amt 
                   ,SUM(b2.fcntr_trsp_wtr_trk_amt)  fcntr_trsp_wtr_trk_amt 
                   ,SUM(b2.misc_fcntr_trsp_amt)     misc_fcntr_trsp_amt 
                   ,SUM(b2.fcntr_trsp_fuel_scg_amt)     fcntr_trsp_fuel_scg_amt -- 20101123 Fuel surcharge 추가 
                   ,SUM(b2.tml_amt)                 tml_amt 
                   ,SUM(b2.fcntr_stvg_ttl_amt)      fcntr_stvg_ttl_amt 
                   ,SUM(b2.fcntr_trsp_ttl_amt)      fcntr_trsp_ttl_amt 
                   ,b4.bkg_qty 
                   ,b3.lgs_kpi_mn_cd 
                   ,b3.lgs_kpi_cd 
                   ,'SYS_COA_REV' cre_usr_id 
                   ,SYSDATE cre_dt 
                   ,'SYS_COA_REV' upd_usr_id 
                   ,SYSDATE upd_dt 
               FROM prd_cost_act_grp b3 
                   ,mdm_organization b1        
                   ,(SELECT   bkg_no 
                             ,spcl_cntr_tpsz_cd cntr_tpsz_cd 
                             ,SUM(decode(substr(cntr_tpsz_cd,1,1),'Q',0,bkg_qty)) bkg_qty 
                             ,SUM(decode(substr(cntr_tpsz_cd,1,1),'Q',DECODE(substr(cntr_tpsz_cd,-1), '2', bkg_qty, 0),0)) void_20ft_qty 
                             ,SUM(decode(substr(cntr_tpsz_cd,1,1),'Q',DECODE(substr(cntr_tpsz_cd,-1), '2', 0, bkg_qty),0)) void_40ft_qty 
                         FROM coa_bkg_rev_dtl 
                        WHERE bkg_no       = in_bkg_no 
                     GROUP BY bkg_no,  spcl_cntr_tpsz_cd 
                     ) b4 
                   ,(SELECT   bkg_no 
                             ,cntr_tpsz_cd 
                             ,cost_act_grp_cd 
                             ,sttl_flg 
                             ,n1st_nod_cd 
                             ,n2nd_nod_cd 
                             ,n3rd_nod_cd 
                             ,n4th_nod_cd 
                             ,ctrl_ofc_cd 
                             ,cost_act_grp_tp_cd 
                             ,cost_io_bnd_cd 
                             ,pre_cost_act_grp_cd 
                             ,pst_cost_act_grp_cd 
                             ,pre_act_grp_de_term_cd 
                             ,pst_act_grp_rcv_term_cd 
                             ,CASE cost_act_grp_cd 
                                 WHEN 'IDRD' THEN SUM(qty_trdrrt)   -- TRDRRD 
                                 WHEN 'IDRT' THEN SUM(qty_trdrrt)   -- TRDRRT 
                                 WHEN 'IDRW' THEN SUM(qty_trdrwr)   -- TRDRWR 
                                 WHEN 'IDTD' THEN SUM(qty_trdrtd)   -- TRDRTD 
                                 WHEN 'IDTR' THEN SUM(qty_trdrrt)   -- TRDRRT 
                                 WHEN 'IDTW' THEN SUM(qty_trdrwt)   -- TRDRWT 
                                 WHEN 'IDWD' THEN SUM(qty_trdrwd)   -- TRDRWD 
                                 WHEN 'IDWR' THEN SUM(qty_trdrwr)   -- TRDRWR 
                                 WHEN 'IDWT' THEN SUM(qty_trdrwt)   -- TRDRWT 
                                 WHEN 'IFRD' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlsrd))   -- TRLCRD, TRLSRD 
                                 WHEN 'IFRT' THEN COALESCE(SUM(qty_trlcrt), SUM(qty_trlsrt))   -- TRLCRT, TRLSRT 
                                 WHEN 'IFRW' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlswr))   -- TRLCWR, TRLSWR 
                                 WHEN 'IFTD' THEN COALESCE(SUM(qty_trlctd), SUM(qty_trlstd))   -- TRLCTD, TRLSTD 
                                 WHEN 'IFTR' THEN COALESCE(SUM(qty_trlcrt), SUM(qty_trlsrt))   -- TRLCRT, TRLSRT 
                                 WHEN 'IFTW' THEN COALESCE(SUM(qty_trlcwt), SUM(qty_trlswt))   -- TRLCWT, TRLSWT 
                                 WHEN 'IFWD' THEN COALESCE(SUM(qty_trlcwd), SUM(qty_trlswd))   -- TRLCWD, TRLSWD 
                                 WHEN 'IFWR' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlswr))   -- TRLCWR, TRLSWR 
                                 WHEN 'IFWT' THEN COALESCE(SUM(qty_trlcwt), SUM(qty_trlswt))   -- TRLCWT, TRLSWT 
                                 WHEN 'IYRD' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlsrd))   -- TRLCRD, TRLSRD 
                                 WHEN 'IYRT' THEN COALESCE(SUM(qty_trlcrt), SUM(qty_trlsrt))   -- TRLCRT, TRLSRT 
                                 WHEN 'IYRW' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlswr))   -- TRLCWR, TRLSWR 
                                 WHEN 'IYTD' THEN COALESCE(SUM(qty_trlctd), SUM(qty_trlstd))   -- TRLCTD, TRLSTD 
                                 WHEN 'IYTR' THEN COALESCE(SUM(qty_trlcrt), SUM(qty_trlsrt))   -- TRLCRT, TRLSRT 
                                 WHEN 'IYTW' THEN COALESCE(SUM(qty_trlcwt), SUM(qty_trlswt))   -- TRLCWT, TRLSWT 
                                 WHEN 'IYWD' THEN COALESCE(SUM(qty_trlcwd), SUM(qty_trlswd))   -- TRLCWD, TRLSWD 
                                 WHEN 'IYWR' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlswr))   -- TRLCWR, TRLSWR 
                                 WHEN 'IYWT' THEN COALESCE(SUM(qty_trlcwt), SUM(qty_trlswt))   -- TRLCWT, TRLSWT 
                                 WHEN 'NIBB' THEN COALESCE(SUM(qty_tmndfl), SUM(qty_tmfdfl))   -- TMNDFL, TMFDFL 
                                 WHEN 'NIBC' THEN SUM(qty_tmfdfl)   -- TMFDFL 
                                 WHEN 'NIBR' THEN SUM(qty_tmfdfl)   -- TMFDFL 
                                 WHEN 'NIBT'                                  
                                    THEN COALESCE(SUM(qty_svldfl), SUM(qty_tpndfl))   --SVLDFL, TPNDFL 
                                 WHEN 'NIBY' THEN COALESCE(SUM(qty_tmndfl), SUM(qty_tmfdfl))   -- TMNDFL, TMFDFL 
                                 WHEN 'NOBB' THEN COALESCE(SUM(qty_tmndfl), SUM(qty_tmfdfl))   -- TMNDFL, TMFDFL 
                                 WHEN 'NOBC' THEN SUM(qty_tmfdfl)                              -- TMFDFL 
                                 WHEN 'NOBR' THEN SUM(qty_tmfdfl)                              -- TMFDFL 
                                 WHEN 'NOBT' THEN COALESCE(SUM(qty_svldfl), SUM(qty_tpndfl))   -- SVLDFL, TPNDFL 
                                 WHEN 'NOBY' THEN COALESCE(SUM(qty_tmndfl), SUM(qty_tmfdfl))   -- TMNDFL, TMFDFL 
                                 ------------------------------------------------------------ 
                                 -- T/S 물량집계 로직 수정 시작(2008.4.14) - CSR No.N200804150005 
                                 /*    
                                      1. TPNDFL, SVLDFL, TPNDTS, SVLDTS 의 물량정보를 읽어온다. 
                                      2. NTST의 앞뒤 Activity Group Code를 살펴보고 앞,뒤에 ~TD Activity group이 있으면 그대로 
                                          2-1. 이전 Feeder(~WD)의 'Del' Term이 Y or T or V 이면 0 
                                          2-2. 이후 Feeder(~WD)의 'Rec' Term이 Y or T or V 이면 0 
                                        
                                      3. NTST의 앞뒤 Activity Group Code를 살펴보고 앞,뒤에 ~TD Activity group이 없으면 X2를 한다. 
                                          3-1. 이전 Feeder(~WD)의 'Del' Term이 Y or T or V 이면 /2 
                                          3-2. 이후 Feeder(~WD)의 'Rec' Term이 Y or T or V 이고 
                                                   3-2-1. 이전 Feeder(~WD)의 'Del' Term이 Y or T or V 이면 0 
                                                   3-2-2. 이전 Feeder(~WD)의 'Del' Term이 Y or T or V 이 아니면 /2 
                                      4.추가로직 ~TD를 비교할 때 substr(nod_cd, 1, 5)가 같을 경우만 고려한다. 
                                        Pre TD의 경우 이전 TD의 to_nod_cd를 Post TD의 경우 이후 TD의 nod_cd를 고려함. 
                                        (같은 location에 있을 때만 TD를 고려함.) 
                                 */ 
                                 ------------------------------------------------------------- 
                                 WHEN 'NTST'    
                                    THEN CASE 
                                           -- pre가 TD인 경우 
                                           WHEN PRE_COST_ACT_GRP_CD LIKE '%TD' AND SUBSTR(pre_to_nod_cd, 1, 5) = SUBSTR(n1st_nod_cd, 1, 5)  
                                              THEN CASE WHEN PST_COST_ACT_GRP_CD LIKE '%WD' AND pst_act_grp_rcv_term_cd IN ('Y', 'T', 'V')  
                                                      THEN 0 
                                                      ELSE COALESCE(SUM(qty_svldfl),SUM(qty_tpndfl),SUM(qty_svldts),SUM(qty_tpndts),0)        
                                                   END                                 
                                           -- post가 TD인 경우 
                                           WHEN PST_COST_ACT_GRP_CD LIKE '%TD' AND SUBSTR(pst_nod_cd, 1, 5) = SUBSTR(n1st_nod_cd, 1, 5)  
                                              THEN CASE WHEN PRE_COST_ACT_GRP_CD LIKE '%WD' AND pre_act_grp_de_term_cd IN ('Y', 'T', 'V')  
                                                      THEN 0 
                                                      ELSE COALESCE(SUM(qty_svldfl),SUM(qty_tpndfl),SUM(qty_svldts),SUM(qty_tpndts),0) 
                                                   END 
                                           -- pre와 post가 WD인 경우 
                                           WHEN PRE_COST_ACT_GRP_CD LIKE '%WD' AND PST_COST_ACT_GRP_CD LIKE '%WD'  
                                              THEN CASE WHEN pre_act_grp_de_term_cd IN ('Y', 'T', 'V')  
                                                      THEN CASE WHEN pst_act_grp_rcv_term_cd IN ('Y', 'T', 'V') 
                                                              THEN 0 
                                                              ELSE COALESCE(SUM(qty_svldfl),SUM(qty_tpndfl),SUM(qty_svldts),SUM(qty_tpndts),0) 
                                                           END 
                                                      ELSE CASE WHEN pst_act_grp_rcv_term_cd IN ('Y', 'T', 'V') 
                                                              THEN COALESCE(SUM(qty_svldfl),SUM(qty_tpndfl),SUM(qty_svldts),SUM(qty_tpndts),0) 
                                                              ELSE COALESCE(SUM(qty_svldfl),SUM(qty_tpndfl),SUM(qty_svldts),SUM(qty_tpndts),0) * 2 
                                                           END 
                                                   END 
                                           -- pre가 WD인 경우 
                                           WHEN PRE_COST_ACT_GRP_CD LIKE '%WD' AND pre_act_grp_de_term_cd IN ('Y', 'T', 'V')  
                                              THEN COALESCE(SUM(qty_svldfl),SUM(qty_tpndfl),SUM(qty_svldts),SUM(qty_tpndts),0) 
                                           -- pst가 WD인 경우 
                                           WHEN PST_COST_ACT_GRP_CD LIKE '%WD' AND pst_act_grp_rcv_term_cd IN ('Y', 'T', 'V')  
                                              THEN COALESCE(SUM(qty_svldfl),SUM(qty_tpndfl),SUM(qty_svldts),SUM(qty_tpndts),0) 
                                           ELSE COALESCE(SUM(qty_svldfl),SUM(qty_tpndfl),SUM(qty_svldts),SUM(qty_tpndts),0) * 2      
                                         END 
                                 ------------------------------------------------------------- 
                                 -- T/S 물량집계 로직 수정 끝(2008.4.14)                           
                                 -------------------------------------------------------------             
                                 WHEN 'ODRD' THEN SUM(qty_trdrrd)   -- TRDRRD 
                                 WHEN 'ODRT' THEN SUM(qty_trdrrt)   -- TRDRRT 
                                 WHEN 'ODRW' THEN SUM(qty_trdrwr)   -- TRDRWR 
                                 WHEN 'ODTD' THEN SUM(qty_trdrtd)   -- TRDRTD 
                                 WHEN 'ODTR' THEN SUM(qty_trdrrt)   -- TRDRRT 
                                 WHEN 'ODTW' THEN SUM(qty_trdrwt)   -- TRDRWT 
                                 WHEN 'ODWD' THEN SUM(qty_trdrwd)   -- TRDRWD 
                                 WHEN 'ODWR' THEN SUM(qty_trdrwr)   -- TRDRWR 
                                 WHEN 'ODWT' THEN SUM(qty_trdrwt)   -- TRDRWT 
                                 WHEN 'OFRD' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlsrd))   -- TRLCRD, TRLSRD 
                                 WHEN 'OFRT' THEN COALESCE(SUM(qty_trlcrt), SUM(qty_trlsrt))   -- TRLCRT, TRLSRT 
                                 WHEN 'OFRW' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlswr))   -- TRLCWR, TRLSWR 
                                 WHEN 'OFTD' THEN COALESCE(SUM(qty_trlctd), SUM(qty_trlstd))   -- TRLCTD, TRLSTD 
                                 WHEN 'OFTR' THEN COALESCE(SUM(qty_trlcrt), SUM(qty_trlsrt))   -- TRLCRT, TRLSRT 
                                 WHEN 'OFTW' THEN COALESCE(SUM(qty_trlcwt), SUM(qty_trlswt))   -- TRLCWT, TRLSWT 
                                 WHEN 'OFWD' THEN COALESCE(SUM(qty_trlcwd), SUM(qty_trlswd))   -- TRLCWD, TRLSWD 
                                 WHEN 'OFWR' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlswr))   -- TRLCWR, TRLSWR 
                                 WHEN 'OFWT' THEN COALESCE(SUM(qty_trlcwt), SUM(qty_trlswt))   -- TRLCWT, TRLSWT 
                                 WHEN 'OYRD' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlsrd))   -- TRLCRD, TRLSRD 
                                 WHEN 'OYRT' THEN COALESCE(SUM(qty_trlcrt), SUM(qty_trlsrt))   -- TRLCRT, TRLSRT 
                                 WHEN 'OYRW' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlswr))   -- TRLCWR, TRLSWR 
                                 WHEN 'OYTD' THEN COALESCE(SUM(qty_trlctd), SUM(qty_trlstd))   -- TRLCTD, TRLSTD 
                                 WHEN 'OYTR' THEN COALESCE(SUM(qty_trlcrt), SUM(qty_trlsrt))   -- TRLCRT, TRLSRT 
                                 WHEN 'OYTW' THEN COALESCE(SUM(qty_trlcwt), SUM(qty_trlswt))   -- TRLCWT, TRLSWT 
                                 WHEN 'OYWD' THEN COALESCE(SUM(qty_trlcwd), SUM(qty_trlswd))   -- TRLCWD, TRLSWD 
                                 WHEN 'OYWR' THEN COALESCE(SUM(qty_trlcrd), SUM(qty_trlswr))   -- TRLCWR, TRLSWR 
                                 WHEN 'OYWT' THEN COALESCE(SUM(qty_trlcwt), SUM(qty_trlswt))   -- TRLCWT, TRLSWT 
                                 WHEN 'POWD' THEN COALESCE(SUM(qty_trtcwd), SUM(qty_trtswd))   -- TRTCWD, TRTSWD 
                                 WHEN 'PRWD' THEN COALESCE(SUM(qty_trtcwd), SUM(qty_trtswd))   -- TRTCWD, TRTSWD 
                                 WHEN 'TRWD' THEN COALESCE(SUM(qty_trlcwd), SUM(qty_trlswd))   -- TRLCWD, TRLSWD 
                                 WHEN 'TYRD' THEN COALESCE(SUM(qty_trtcrd), SUM(qty_trtsrd))   -- TRTCRD, TRTSRD 
                                 WHEN 'TYRT' THEN COALESCE(SUM(qty_trtcrt), SUM(qty_trtsrt))   -- TRTCRT, TRTSRT 
                                 WHEN 'TYRW' THEN COALESCE(SUM(qty_trtcwr), SUM(qty_trtswr))   -- TRTCWR, TRTSWR 
                                 WHEN 'TYTD' THEN COALESCE(SUM(qty_trtctd), SUM(qty_trtstd))   -- TRTCTD, TRTSTD 
                                 WHEN 'TYTR' THEN COALESCE(SUM(qty_trtcrt), SUM(qty_trtsrt))   -- TRTCRT, TRTSRT 
                                 WHEN 'TYTW' THEN COALESCE(SUM(qty_trtcwt), SUM(qty_trtswt))   -- TRTCWT, TRTSWT 
                                 WHEN 'TYWR' THEN COALESCE(SUM(qty_trtcwr), SUM(qty_trtswr))   -- TRTCWR, TRTSWR 
                                 WHEN 'TYWT' THEN COALESCE(SUM(qty_trtcwt), SUM(qty_trtswt))   -- TRTCWT, TRTSWT 
                                 WHEN 'TYWD' THEN SUM(qty_trtswd)   -- TRTSWD 
                                 ELSE 0 
                              END cntr_qty 
                             ,SUM(bzc_stvg_amt) bzc_stvg_amt 
                             ,SUM(otr_cy_hndl_amt) otr_cy_hndl_amt 
                             ,SUM(ts_stvg_amt) ts_stvg_amt 
                             ,SUM(dck_cy_hndl_amt) dck_cy_hndl_amt 
                             ,SUM(cgo_hndl_amt) cgo_hndl_amt 
                             ,SUM(fcntr_sto_amt) fcntr_sto_amt 
                             ,SUM(misc_cgo_hndl_amt) misc_cgo_hndl_amt 
                             ,SUM(fcntr_trsp_rail_dir_amt) fcntr_trsp_rail_dir_amt 
                             ,SUM(fcntr_trsp_rail_trk_amt) fcntr_trsp_rail_trk_amt 
                             ,SUM(fcntr_trsp_trk_dir_amt) fcntr_trsp_trk_dir_amt 
                             ,SUM(fcntr_trsp_wtr_dir_amt) fcntr_trsp_wtr_dir_amt 
                             ,SUM(fcntr_trsp_wtr_rail_amt) fcntr_trsp_wtr_rail_amt 
                             ,SUM(fcntr_trsp_wtr_trk_amt) fcntr_trsp_wtr_trk_amt 
                             ,SUM(misc_fcntr_trsp_amt) misc_fcntr_trsp_amt 
                             ,SUM(fcntr_trsp_fuel_scg_amt) fcntr_trsp_fuel_scg_amt
                             ,SUM(tml_amt) tml_amt 
                             ,SUM(fcntr_stvg_ttl_amt) fcntr_stvg_ttl_amt 
                             ,SUM(fcntr_trsp_ttl_amt) fcntr_trsp_ttl_amt 
                         FROM (SELECT   bkg_no 
                                       ,cntr_tpsz_cd 
                                       ,cost_rout_no 
                                       ,cost_act_grp_seq 
                                       ,COST_ACT_GRP_CD 
                                       ,DECODE(SUBSTR(coa_cost_src_cd, 1, 4), 'TRLS', 'Y', 'TRTS', 'Y', 'N') sttl_flg 
                                       ,n1st_nod_cd 
                                       ,n2nd_nod_cd 
                                       ,n3rd_nod_cd 
                                       ,n4th_nod_cd 
                                       ,NVL(ctrl_ofc_cd, 'NONOFC') ctrl_ofc_cd 
                                       ,cost_act_grp_tp_cd 
                                       ,cost_io_bnd_cd 
                                       ,LAG(COST_ACT_GRP_CD, 1) OVER (PARTITION BY bkg_no, cntr_tpsz_cd, cost_rout_no  
                                                                     ORDER BY bkg_no, cntr_tpsz_cd, cost_rout_no, cost_act_grp_seq) AS PRE_COST_ACT_GRP_CD 
                                       ,LEAD(COST_ACT_GRP_CD, 1) OVER (PARTITION BY bkg_no, cntr_tpsz_cd, cost_rout_no  
                                                                      ORDER BY bkg_no, cntr_tpsz_cd, cost_rout_no, cost_act_grp_seq) AS PST_COST_ACT_GRP_CD 
                                       ,LAG(wtr_de_term_cd, 1) OVER (PARTITION BY bkg_no,  cntr_tpsz_cd, cost_rout_no  
                                                                         ORDER BY bkg_no,  cntr_tpsz_cd, cost_rout_no, cost_act_grp_seq) AS pre_act_grp_de_term_cd 
                                       ,LEAD(wtr_rcv_term_cd, 1) OVER (PARTITION BY bkg_no,cntr_tpsz_cd, cost_rout_no  
                                                                           ORDER BY bkg_no, cntr_tpsz_cd, cost_rout_no, cost_act_grp_seq) AS pst_act_grp_rcv_term_cd 
                                       ,LAG(to_nod_cd, 1) OVER (PARTITION BY bkg_no, cntr_tpsz_cd, cost_rout_no  
                                                                    ORDER BY bkg_no, cntr_tpsz_cd, cost_rout_no, cost_act_grp_seq) AS pre_to_nod_cd 
                                       ,LEAD(nod_cd, 1) OVER (PARTITION BY bkg_no,  cntr_tpsz_cd, cost_rout_no  
                                                                  ORDER BY bkg_no, cntr_tpsz_cd, cost_rout_no, cost_act_grp_seq) AS pst_nod_cd                                                                         
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRDRRD', cntr_qty, NULL)) qty_trdrrd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRDRRT', cntr_qty, NULL)) qty_trdrrt 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRDRWR', cntr_qty, NULL)) qty_trdrwr 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRDRTD', cntr_qty, NULL)) qty_trdrtd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRDRWT', cntr_qty, NULL)) qty_trdrwt 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRDRWD', cntr_qty, NULL)) qty_trdrwd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLCRD', cntr_qty, NULL)) qty_trlcrd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLCRT', cntr_qty, NULL)) qty_trlcrt 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLCWR', cntr_qty, NULL)) qty_trlcwr 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLCTD', cntr_qty, NULL)) qty_trlctd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLCWT', cntr_qty, NULL)) qty_trlcwt 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLCWD', cntr_qty, NULL)) qty_trlcwd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TMNDFL', cntr_qty, NULL)) qty_tmndfl 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TMFDFL', cntr_qty, NULL)) qty_tmfdfl 
                                       ,SUM(DECODE(coa_cost_src_cd, 'SVLDFL', cntr_qty, NULL)) qty_svldfl 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTCWD', cntr_qty, NULL)) qty_trtcwd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTCRD', cntr_qty, NULL)) qty_trtcrd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTCRT', cntr_qty, NULL)) qty_trtcrt 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTCWR', cntr_qty, NULL)) qty_trtcwr 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTCTD', cntr_qty, NULL)) qty_trtctd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTCWT', cntr_qty, NULL)) qty_trtcwt 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLSRD', cntr_qty, NULL)) qty_trlsrd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLSRT', cntr_qty, NULL)) qty_trlsrt 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLSWR', cntr_qty, NULL)) qty_trlswr 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLSTD', cntr_qty, NULL)) qty_trlstd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLSWT', cntr_qty, NULL)) qty_trlswt 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRLSWD', cntr_qty, NULL)) qty_trlswd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TPNDFL', cntr_qty, NULL)) qty_tpndfl 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTSWD', cntr_qty, NULL)) qty_trtswd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTSRD', cntr_qty, NULL)) qty_trtsrd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTSRT', cntr_qty, NULL)) qty_trtsrt 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTSWR', cntr_qty, NULL)) qty_trtswr 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTSTD', cntr_qty, NULL)) qty_trtstd 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TRTSWT', cntr_qty, NULL)) qty_trtswt                               
                                       ,SUM(DECODE(coa_cost_src_cd, 'SVLDTS', cntr_qty, NULL)) qty_svldts 
                                       ,SUM(DECODE(coa_cost_src_cd, 'TPNDTS', cntr_qty, NULL)) qty_tpndts 
                                                                              
                                       ,SUM(DECODE(stnd_cost_cd, '51101011', estm_usd_ttl_amt, 0)) bzc_stvg_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51101071', estm_usd_ttl_amt, 0)) otr_cy_hndl_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51101021', estm_usd_ttl_amt, 0)) ts_stvg_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51101031', estm_usd_ttl_amt, 0)) dck_cy_hndl_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51101051', estm_usd_ttl_amt, 0)) cgo_hndl_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51101041', estm_usd_ttl_amt, 0)) fcntr_sto_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51101061', estm_usd_ttl_amt, 0)) misc_cgo_hndl_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51301011', estm_usd_ttl_amt, 0)) fcntr_trsp_rail_dir_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51301021', estm_usd_ttl_amt, 0)) fcntr_trsp_rail_trk_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51301031', estm_usd_ttl_amt, 0)) fcntr_trsp_trk_dir_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51301041', estm_usd_ttl_amt, 0)) fcntr_trsp_wtr_dir_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51301051', estm_usd_ttl_amt, 0)) fcntr_trsp_wtr_rail_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51301061', estm_usd_ttl_amt, 0)) fcntr_trsp_wtr_trk_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51301081', estm_usd_ttl_amt, 0)) misc_fcntr_trsp_amt 
                                       ,SUM(DECODE(stnd_cost_cd, '51301091', estm_usd_ttl_amt, 0)) fcntr_trsp_fuel_scg_amt--misc_fcntr_trsp_scfu_amt -- 20101123 Fuel surcharge 추가 
                                       ,0 tml_amt 
                                       ,SUM(DECODE(cost_act_grp_tp_cd, 'N', estm_usd_ttl_amt, 0)) fcntr_stvg_ttl_amt 
                                       ,SUM(DECODE(cost_act_grp_tp_cd, 'L', estm_usd_ttl_amt, 0)) fcntr_trsp_ttl_amt 
                                   FROM coa_bkg_cost_src_dtl 
                                  WHERE 1 = 1 
--                                    AND BZC_COST_YRMON = (SELECT BZC_COST_YRMON FROM COA_RGST_BKG WHERE BKG_NO = in_bkg_no) 
                                    AND bkg_no       = in_bkg_no 
                                    AND cost_act_grp_cd NOT IN ('COMN', 'VSSL')  -- 2014.11.18 Slot Internal Pricing
                                    AND delt_flg NOT IN('Y') 
                                    AND estm_usd_ttl_amt NOT IN(0) 
                                    --AND cntr_qty NOT IN(0) 
                               GROUP BY bkg_no 
                                       ,cntr_tpsz_cd 
                                       ,cost_rout_no 
                                       ,cost_act_grp_seq 
                                       ,cost_act_grp_cd 
                                       ,DECODE(SUBSTR(coa_cost_src_cd, 1, 4), 'TRLS', 'Y', 'TRTS', 'Y', 'N') 
                                       ,n1st_nod_cd 
                                       ,n2nd_nod_cd 
                                       ,n3rd_nod_cd 
                                       ,n4th_nod_cd 
                                       ,NVL(ctrl_ofc_cd, 'NONOFC') 
                                       ,cost_act_grp_tp_cd 
                                       ,cost_io_bnd_cd 
                                       ,wtr_de_term_cd 
                                       ,wtr_rcv_term_cd 
                                       ,nod_cd 
                                       ,to_nod_cd) 
                     GROUP BY bkg_no 
                             ,cntr_tpsz_cd 
                             ,COST_ACT_GRP_CD 
                             ,sttl_flg 
                             ,n1st_nod_cd 
                             ,n2nd_nod_cd 
                             ,n3rd_nod_cd 
                             ,n4th_nod_cd 
                             ,ctrl_ofc_cd 
                             ,cost_act_grp_tp_cd 
                             ,cost_io_bnd_cd 
                             ,pre_act_grp_de_term_cd 
                             ,pst_act_grp_rcv_term_cd 
                             ,cost_rout_no 
                             ,PST_COST_ACT_GRP_CD 
                             ,PRE_COST_ACT_GRP_CD 
                             ,pre_to_nod_cd 
                             ,pst_nod_cd) b2 
              WHERE b2.ctrl_ofc_cd  = b1.ofc_cd(+) 
                AND b2.COST_ACT_GRP_CD   = b3.cost_act_grp_cd(+) 
                AND b2.bkg_no       = b4.bkg_no 
                AND b2.cntr_tpsz_cd = b4.cntr_tpsz_cd 
           GROUP BY b2.bkg_no 
                   ,b2.cntr_tpsz_cd 
                   ,b2.COST_ACT_GRP_CD 
                   ,b2.sttl_flg 
                   ,NVL(b2.n1st_nod_cd, 'XXXXXXX') 
                   ,NVL(b2.n2nd_nod_cd, 'XXXXXXX') 
                   ,NVL(b2.n3rd_nod_cd, 'XXXXXXX') 
                   ,NVL(b2.n4th_nod_cd, 'XXXXXXX') 
                   ,b2.ctrl_ofc_cd 
                   ,NVL(b1.ar_hd_qtr_ofc_cd, 'NONHQ') 
                   ,b2.cost_act_grp_tp_cd 
                   ,b2.cost_io_bnd_cd 
                   ,NVL(b2.PRE_COST_ACT_GRP_CD, 'XXXX') 
                   ,NVL(b2.PST_COST_ACT_GRP_CD, 'XXXX') 
                   ,NVL(b2.pre_act_grp_de_term_cd, 'X') 
                   ,NVL(b2.pst_act_grp_rcv_term_cd, 'X') 
                   ,b3.lgs_kpi_mn_cd 
                   ,b3.lgs_kpi_cd 
                   ,b4.bkg_qty 
                   ,b4.void_20ft_qty 
                   ,b4.void_40ft_qty   
 
                   ;     
        /* coa_bkg_lgs_smry 테이블에 정보를 입력한다_END ------------------------------------------------------------*/                    
    ELSE 
         
        --기존 데이터 삭제 
        DELETE FROM coa_bkg_lgs_smry 
         WHERE 1 = 1 
           AND bkg_no = in_bkg_no;        
        
        enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'COA_BKG_REV_DTL : BKG_NO가 존재하지 않습니다.', v_appl_info); 
     
    END IF; 
 
    /* 2009.03.02 PSH  cost smry 데이터 확인 후 coa_bkg_svc_trns_smry계산하도록 변경. 
                       : 타비용 없을경우 coa_bkg_svc_trns_prc  삭제------------------------*/ 
     
    --해당 부킹이 cost_smry에 있는지 확인 
    BEGIN 
        SELECT COUNT(*) 
          INTO v_booking_smry_cnt 
          FROM coa_bkg_cost_smry 
         WHERE bkg_no       = in_bkg_no; 
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN 
            BEGIN 
                v_booking_smry_cnt := 0; 
            END; 
    END; 
 
 
   IF (in_is_del_para = 'T') 
   THEN 
      --PARA 정보 삭제 시작 -- 
 
      -- delete:coa_com_qty_para테이블 데이터 삭제 
      DELETE FROM coa_com_qty_para 
            WHERE pctl_no IN( 
                     SELECT p.pctl_no 
                       FROM coa_com_para c, coa_com_qty_para p 
                      WHERE c.pctl_no = p.pctl_no 
                        AND NVL(c.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')); 
 
--   enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'COA_COM_QTY_PARA : ' || SQL%ROWCOUNT || ' DELETE', v_appl_info); --++ 

 
      -- delete:coa_com_cost_para 테이블 데이터 삭제 
      DELETE FROM coa_com_cost_para 
            WHERE pctl_no IN( 
                     SELECT p.pctl_no 
                       FROM coa_com_para c, coa_com_cost_para p 
                      WHERE c.pctl_no = p.pctl_no 
                        AND NVL(c.bkg_no, 'XXXXX') = NVL(in_bkg_no, 'XXXXX')); 
 
--   enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'COA_COM_COST_PARA : ' || SQL%ROWCOUNT || ' DELETE', v_appl_info); --++ 
 
      --delete:coa_com_cost_para 테이블 데이터 삭제 
      DELETE FROM coa_com_para 
            WHERE pctl_no IN(SELECT pctl_no 
                               FROM coa_com_para 
                              WHERE bkg_no = in_bkg_no); 
--      enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'COA_COM_PARA : ' || SQL%ROWCOUNT || ' DELETE', v_appl_info); --++ 
-- PARA 정보 삭제 끝 
   END IF; 
    
   -- 2008.08.06 COA_BKG_EXPN_DTL의 일배치 기준으로 사용하기 위해서 
   -- COA_RGST_BKG.COA_BAT_DT에 데이터 변경 
   UPDATE COA_RGST_BKG 
      SET coa_bat_dt = SYSDATE 
    WHERE bkg_no       = in_bkg_no; 
       
--enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'End' || TO_CHAR(SYSDATE, 'yyyy/mm/dd hh24:mi:ss'), v_appl_info); --++ 
--------------------------------------------------------------------------------------------------------------------- 
EXCEPTION 
   WHEN OTHERS 
   THEN 
      out_result := 'N'; 
      enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'Error: ' || SQLERRM, v_appl_info); 
      RAISE; 
END COA_BKG_COST_SMRY_PRC;