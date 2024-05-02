CREATE OR REPLACE PROCEDURE COA_PFIT_LSS_SMRY_PRC (
   in_fm_yyyywk   IN   VARCHAR2
  ,in_to_yyyywk   IN   VARCHAR2
  ,in_log_lvl     IN   VARCHAR2 DEFAULT '9'
)
Authid current_user
 IS
 
    /****************************************************************************** 
       Name         :   COA_PFIT_LSS_SMRY_PRC 
       Purpose      :   BKG_COST_SMRY VSL 단위 주집계 계산
       Source       :   coa_bkg_cost_smry 
       Target       :   coa_pfit_lss_smry 
       Revision History
          1. 2007.01.24 박칠서 최초생성
          2. 2015.01.30 Modifying error when VVD's sales week is updated by vessel schedule
    ******************************************************************************/ 
 
   /******************************************************************************
      Ex)
       BEGIN
         COA_PFIT_LSS_SMRY_PRC ('200752', '200801', '1');
         COMMIT;
       END;

       SELECT * FROM ENIS_LOG
       WHERE MOD_NAME = 'COA_PFIT_LSS_SMRY_PRC'
         AND EXEC_DT > SYSDATE - 1/24
       ORDER BY EXEC_DT DESC
   ******************************************************************************/

   ------------------------------[ 변수선언부             ]-----------------------
   v_cnt              NUMBER (18)    := 0;
   v_cnt_del          NUMBER (18)    := 0;
   v_cnt_ins          NUMBER (18)    := 0;
   v_step             VARCHAR2 (100);
   v_start_time       TIMESTAMP;
   v_start_ttl_time   TIMESTAMP;
   v_head_office      VARCHAR(6)     :=  COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC();
   v_log_mod_nm       VARCHAR2 (30)  := 'COA_PFIT_LSS_SMRY_PRC';
-------------------------------[ 업무로직 구현부       ]-----------------------
BEGIN
   v_start_time     := SYSTIMESTAMP;
   v_start_ttl_time := SYSTIMESTAMP;
   enis_log_prc ('', v_log_mod_nm, '[V.20150130]');
   enis_log_prc ('', v_log_mod_nm, 'in_fm_yyyywk ~ in_to_yyyywk : ' || in_fm_yyyywk || ' ~ ' || in_to_yyyywk);
   --////////////////////////////////////////////////////////////////////////////////////////////
   -- 기존 데이터 삭제
   --////////////////////////////////////////////////////////////////////////////////////////////
   v_step := '기존 데이터 삭제';

   DELETE FROM coa_pfit_lss_smry
         WHERE (trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, skd_dir_cd) IN (
                  SELECT DISTINCT a1.trd_cd
                                 ,a1.rlane_cd
                                 ,a1.ioc_cd
                                 ,a1.vsl_cd
                                 ,a1.skd_voy_no
                                 ,a1.dir_cd
                             FROM coa_mon_vvd a1
                            WHERE SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk >= in_fm_yyyywk
                              AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk <= in_to_yyyywk)
           AND stnd_cost_cd NOT IN (
                                    SELECT stnd_cost_cd   -- BSA, 실적수익성 CM OP, ETC 는 삭제하지 않는다.
                                      FROM coa_pfit_lss_rpt_itm
                                     WHERE (rpt_vw_cd = 'P' AND stnd_cost_tp_cd IN ('O', 'A', 'B'))
                                        OR (rpt_vw_cd = 'P' AND stnd_cost_cd IN ('43102011', 'BSA00000'))
                                   );
                                   
   -- 추후 CM 계정으로 변경시 제외시켜줘야 함
   DELETE FROM coa_pfit_lss_smry
         WHERE (trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, skd_dir_cd) 
            IN (
                  SELECT DISTINCT a1.trd_cd
                                 ,a1.rlane_cd
                                 ,a1.ioc_cd
                                 ,a1.vsl_cd
                                 ,a1.skd_voy_no
                                 ,a1.dir_cd
                             FROM coa_mon_vvd a1
                            WHERE SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk >= in_fm_yyyywk
                              AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk <= in_to_yyyywk
               )
           AND stnd_cost_cd IN (
                                SELECT stnd_cost_cd   
                                  FROM coa_pfit_lss_rpt_itm
                                 WHERE rpt_vw_cd = 'P'
                                   AND stnd_cost_tp_cd = 'O' 
                                   AND sgrp_cost_cd  IN ('EQCF','EQSF')
                               );
                  


   IF (in_log_lvl <= '3') THEN
      enis_log_prc ('', v_log_mod_nm, '기존 데이터 삭제 ' || SQL%ROWCOUNT || ' DELETE');
   END IF;

   COMMIT;
   --////////////////////////////////////////////////////////////////////////////////////////////
   -- 신규 데이터 등록
   --////////////////////////////////////////////////////////////////////////////////////////////
   v_step := '신규 데이터 등록-LOAD0000';
--[CHM-201007143-01]


   MERGE INTO coa_pfit_lss_smry a
      USING (
          SELECT   a1.trd_cd
                  ,a1.rlane_cd
                  ,a1.ioc_cd
                  ,a1.vsl_cd
                  ,a1.skd_voy_no
                  ,a1.dir_cd 
                  ,NVL (a2.sls_ofc_cd, v_head_office) sls_ofc_cd
                  ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office)) agmt_sgn_ofc_cd
                  ,a3.cntr_tpsz_cd
    --              ,a3.stnd_cost_cd
                  ,decode(a3.stnd_cost_cd,'51301091','51301081',a3.stnd_cost_cd) stnd_cost_cd -- 20101123 Fuel surcharge 추가된 계정에 대해서 Merge
                  ,SUM (a3.cntr_qty) estm_pl_amt
                  ,SUM (a3.cntr_qty) ra_pl_amt
                  ,0 act_pl_amt
                  ,0 accl_rt_amt
                  ,SUM (a3.cntr_qty) co_sls_amt
              FROM coa_mon_vvd a1, coa_rgst_bkg a2, coa_bkg_cost_smry a3
             WHERE a1.vsl_cd = a2.vsl_cd
               AND a1.trd_cd = a2.trd_cd
               AND a1.rlane_cd = a2.rlane_cd
               AND a1.ioc_cd = a2.ioc_cd
               AND a1.skd_voy_no = a2.skd_voy_no
               AND a1.dir_cd = a2.dir_cd
               AND a2.bkg_no = a3.bkg_no
               AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk >= in_fm_yyyywk
               AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk <= in_to_yyyywk
               AND a1.delt_flg      = 'N'
               AND a2.bl_no_tp      IN ('M', '0')
               AND a2.bkg_sts_cd    IN ('F', 'S')
               AND a2.bkg_cgo_tp_cd NOT IN ('P')
               AND a3.stnd_cost_cd  IN ('LOAD0000')
          GROUP BY a1.trd_cd
                  ,a1.rlane_cd
                  ,a1.ioc_cd
                  ,a1.vsl_cd
                  ,a1.skd_voy_no
                  ,a1.dir_cd
                  ,NVL (a2.sls_ofc_cd, v_head_office)
                  ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office))
                  ,a3.cntr_tpsz_cd
                  --,a3.stnd_cost_cd
                  ,decode(a3.stnd_cost_cd,'51301091','51301081',a3.stnd_cost_cd) -- 20101123 Fuel surcharge 추가된 계정에 대해서 Merge
      ) b
      ON (
              a.vsl_cd = b.vsl_cd
          AND a.skd_voy_no = b.skd_voy_no
          AND a.skd_dir_cd = b.dir_cd
          AND a.ioc_cd = b.ioc_cd      
          AND a.rlane_cd = b.rlane_cd      
          AND a.trd_cd = b.trd_cd
          AND a.cntr_tpsz_cd = b.cntr_tpsz_cd
          AND a.sls_ofc_cd = b.sls_ofc_cd
          and a.agmt_sgn_ofc_cd = b.agmt_sgn_ofc_cd
          AND a.stnd_cost_cd = b.stnd_cost_cd

          )
      WHEN MATCHED THEN
         UPDATE
            SET a.estm_pl_amt = b.estm_pl_amt
               ,a.ra_pl_amt   = b.ra_pl_amt
               ,a.co_sls_amt  = b.co_sls_amt
               ,a.co_amt = null
               ,a.upd_usr_id  = 'SYS_COA_PL'
               ,a.upd_dt      = SYSDATE
      WHEN NOT MATCHED THEN
         INSERT (
                a.trd_cd
               ,a.rlane_cd
               ,a.ioc_cd
               ,a.vsl_cd
               ,a.skd_voy_no
               ,a.skd_dir_cd
               ,a.sls_ofc_cd
               ,a.agmt_sgn_ofc_cd
               ,a.cntr_tpsz_cd
               ,a.stnd_cost_cd
               ,a.estm_pl_amt
               ,a.ra_pl_amt
               ,a.act_pl_amt
               ,a.accl_rt_amt
               ,a.co_sls_amt
               ,a.cre_usr_id
               ,a.cre_dt
               ,a.upd_usr_id
               ,a.upd_dt
                )
         VALUES (
                b.trd_cd
               ,b.rlane_cd
               ,b.ioc_cd
               ,b.vsl_cd
               ,b.skd_voy_no
               ,b.dir_cd
               ,b.sls_ofc_cd
               ,b.agmt_sgn_ofc_cd
               ,b.cntr_tpsz_cd
               ,b.stnd_cost_cd
               ,b.estm_pl_amt
               ,b.ra_pl_amt
               ,b.act_pl_amt
               ,b.accl_rt_amt
               ,b.co_sls_amt
               ,'SYS_COA_PL'
               ,SYSDATE
               ,'SYS_COA_PL'
               ,SYSDATE
                );
   -- 2015.01.30 comment
--   INSERT INTO coa_pfit_lss_smry
--               (trd_cd
--               ,rlane_cd
--               ,ioc_cd
--               ,vsl_cd
--               ,skd_voy_no
--               ,skd_dir_cd
--               ,sls_ofc_cd
--               ,agmt_sgn_ofc_cd
--               ,cntr_tpsz_cd
--               ,stnd_cost_cd
--               ,estm_pl_amt
--               ,ra_pl_amt
--               ,act_pl_amt
--               ,accl_rt_amt
--               ,co_sls_amt
--               ,cre_usr_id
--               ,cre_dt
--               ,upd_usr_id
--               ,upd_dt
--               )
--      SELECT   a1.trd_cd
--              ,a1.rlane_cd
--              ,a1.ioc_cd
--              ,a1.vsl_cd
--              ,a1.skd_voy_no
--              ,a1.dir_cd
--              ,NVL (a2.sls_ofc_cd, v_head_office) sls_ofc_cd
--              ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office)) agmt_sgn_ofc_cd
--              ,a3.cntr_tpsz_cd
----              ,a3.stnd_cost_cd
--              ,decode(a3.stnd_cost_cd,'51301091','51301081',a3.stnd_cost_cd) stnd_cost_cd -- 20101123 Fuel surcharge 추가된 계정에 대해서 Merge
--              ,SUM (a3.cntr_qty) estm_pl_amt
--              ,SUM (a3.cntr_qty) ra_pl_amt
--              ,0 act_pl_amt
--              ,0 accl_rt_amt
--              ,SUM (a3.cntr_qty) co_sls_amt
--              ,'SYS_COA_PL'
--              ,SYSDATE
--              ,'SYS_COA_PL'
--              ,SYSDATE           
--          FROM coa_mon_vvd a1, coa_rgst_bkg a2, coa_bkg_cost_smry a3
--         WHERE a1.vsl_cd = a2.vsl_cd
--           AND a1.trd_cd = a2.trd_cd
--           AND a1.rlane_cd = a2.rlane_cd
--           AND a1.ioc_cd = a2.ioc_cd
--           AND a1.skd_voy_no = a2.skd_voy_no
--           AND a1.dir_cd = a2.dir_cd
--           AND a2.bkg_no = a3.bkg_no
--           AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk >= in_fm_yyyywk
--           AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk <= in_to_yyyywk
--           AND a1.delt_flg      = 'N'
--           AND a2.bl_no_tp      IN ('M', '0')
--           AND a2.bkg_sts_cd    IN ('F', 'S')
--           AND a2.bkg_cgo_tp_cd NOT IN ('P')
--           AND a3.stnd_cost_cd  IN ('LOAD0000')
--      GROUP BY a1.trd_cd
--              ,a1.rlane_cd
--              ,a1.ioc_cd
--              ,a1.vsl_cd
--              ,a1.skd_voy_no
--              ,a1.dir_cd
--              ,NVL (a2.sls_ofc_cd, v_head_office)
--              ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office))
--              ,a3.cntr_tpsz_cd
--              --,a3.stnd_cost_cd
--              ,decode(a3.stnd_cost_cd,'51301091','51301081',a3.stnd_cost_cd) -- 20101123 Fuel surcharge 추가된 계정에 대해서 Merge
--               ;
              

   IF (in_log_lvl <= '3') THEN
      enis_log_prc ('', v_log_mod_nm, v_step ||' ' || SQL%ROWCOUNT || ' INSERT');
   END IF;

   IF (in_log_lvl <= '1') THEN
      enis_log_prc ('', v_log_mod_nm
                   , '소요시간: ' || TO_CHAR (SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
      v_start_time := SYSTIMESTAMP;
   END IF;
   
   COMMIT;

   v_step := '신규 데이터 등록-LOAD0000 Q TYPE';

   -- Q 볼륨 추가
   
   MERGE INTO coa_pfit_lss_smry a
      USING (
          SELECT   a1.trd_cd
                  ,a1.rlane_cd
                  ,a1.ioc_cd
                  ,a1.vsl_cd
                  ,a1.skd_voy_no
                  ,a1.dir_cd
                  ,NVL (a2.sls_ofc_cd, v_head_office) sls_ofc_cd
                  ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office)) agmt_sgn_ofc_cd
                  ,a3.cntr_tpsz_cd
                  ,'LOAD0000' stnd_cost_cd
                  ,SUM (NVL (a3.bkg_qty, 0)) estm_pl_amt
                  ,SUM (NVL (a3.bkg_qty, 0)) ra_pl_amt
                  ,0 act_pl_amt
                  ,0 accl_rt_amt
                  ,SUM (NVL (a3.bkg_qty, 0)) co_sls_amt
              FROM coa_mon_vvd a1, coa_rgst_bkg a2, coa_bkg_rev_dtl a3
             WHERE a1.vsl_cd = a2.vsl_cd
               AND a1.trd_cd = a2.trd_cd
               AND a1.rlane_cd = a2.rlane_cd
               AND a1.ioc_cd = a2.ioc_cd
               AND a1.skd_voy_no = a2.skd_voy_no
               AND a1.dir_cd = a2.dir_cd
               AND a2.bkg_no = a3.bkg_no
               AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk >= in_fm_yyyywk
               AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk <= in_to_yyyywk
               AND a1.delt_flg = 'N'
               AND a2.bl_no_tp IN ('M', '0')
               AND a2.bkg_sts_cd IN ('F', 'S')
               AND a2.bkg_cgo_tp_cd NOT IN ('P')
               AND a3.cntr_tpsz_cd LIKE 'Q%'
          GROUP BY a1.trd_cd
                  ,a1.rlane_cd
                  ,a1.ioc_cd
                  ,a1.vsl_cd
                  ,a1.skd_voy_no
                  ,a1.dir_cd
                  ,NVL (a2.sls_ofc_cd, v_head_office)
                  ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office))
                  ,a3.cntr_tpsz_cd
      ) b
      ON (
              a.vsl_cd = b.vsl_cd
          AND a.skd_voy_no = b.skd_voy_no
          AND a.skd_dir_cd = b.dir_cd
          AND a.ioc_cd = b.ioc_cd      
          AND a.rlane_cd = b.rlane_cd      
          AND a.trd_cd = b.trd_cd
          AND a.cntr_tpsz_cd = b.cntr_tpsz_cd
          AND a.sls_ofc_cd = b.sls_ofc_cd
          and a.agmt_sgn_ofc_cd = b.agmt_sgn_ofc_cd
          AND a.stnd_cost_cd = b.stnd_cost_cd

          )
      WHEN MATCHED THEN
         UPDATE
            SET a.estm_pl_amt = b.estm_pl_amt
               ,a.ra_pl_amt   = b.ra_pl_amt
               ,a.co_sls_amt  = b.co_sls_amt
               ,a.co_amt = null
               ,a.upd_usr_id  = 'SYS_COA_PL'
               ,a.upd_dt      = SYSDATE
      WHEN NOT MATCHED THEN
         INSERT (
                a.trd_cd
               ,a.rlane_cd
               ,a.ioc_cd
               ,a.vsl_cd
               ,a.skd_voy_no
               ,a.skd_dir_cd
               ,a.sls_ofc_cd
               ,a.agmt_sgn_ofc_cd
               ,a.cntr_tpsz_cd
               ,a.stnd_cost_cd
               ,a.estm_pl_amt
               ,a.ra_pl_amt
               ,a.act_pl_amt
               ,a.accl_rt_amt
               ,a.co_sls_amt
               ,a.cre_usr_id
               ,a.cre_dt
               ,a.upd_usr_id
               ,a.upd_dt
                )
         VALUES (
                b.trd_cd
               ,b.rlane_cd
               ,b.ioc_cd
               ,b.vsl_cd
               ,b.skd_voy_no
               ,b.dir_cd
               ,b.sls_ofc_cd
               ,b.agmt_sgn_ofc_cd
               ,b.cntr_tpsz_cd
               ,b.stnd_cost_cd
               ,b.estm_pl_amt
               ,b.ra_pl_amt
               ,b.act_pl_amt
               ,b.accl_rt_amt
               ,b.co_sls_amt
               ,'SYS_COA_PL'
               ,SYSDATE
               ,'SYS_COA_PL'
               ,SYSDATE
                );   
   
   
   -- 2015.01.30 comment
--   INSERT INTO coa_pfit_lss_smry
--               (trd_cd
--               ,rlane_cd
--               ,ioc_cd
--               ,vsl_cd
--               ,skd_voy_no
--               ,skd_dir_cd
--               ,sls_ofc_cd
--               ,agmt_sgn_ofc_cd
--               ,cntr_tpsz_cd
--               ,stnd_cost_cd
--               ,estm_pl_amt
--               ,ra_pl_amt
--               ,act_pl_amt
--               ,accl_rt_amt
--               ,co_sls_amt
--               ,cre_usr_id
--               ,cre_dt
--               ,upd_usr_id
--               ,upd_dt
--               )
--      SELECT   a1.trd_cd
--              ,a1.rlane_cd
--              ,a1.ioc_cd
--              ,a1.vsl_cd
--              ,a1.skd_voy_no
--              ,a1.dir_cd
--              ,NVL (a2.sls_ofc_cd, v_head_office) sls_ofc_cd
--              ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office)) agmt_sgn_ofc_cd
--              ,a3.cntr_tpsz_cd
--              ,'LOAD0000' stnd_cost_cd
--              ,SUM (NVL (a3.bkg_qty, 0)) estm_pl_amt
--              ,SUM (NVL (a3.bkg_qty, 0)) ra_pl_amt
--              ,0 act_pl_amt
--              ,0 accl_rt_amt
--              ,SUM (NVL (a3.bkg_qty, 0)) co_sls_amt
--              ,'SYS_COA_PL'
--              ,SYSDATE
--              ,'SYS_COA_PL'
--              ,SYSDATE
--          FROM coa_mon_vvd a1, coa_rgst_bkg a2, coa_bkg_rev_dtl a3
--         WHERE a1.vsl_cd = a2.vsl_cd
--           AND a1.trd_cd = a2.trd_cd
--           AND a1.rlane_cd = a2.rlane_cd
--           AND a1.ioc_cd = a2.ioc_cd
--           AND a1.skd_voy_no = a2.skd_voy_no
--           AND a1.dir_cd = a2.dir_cd
--           AND a2.bkg_no = a3.bkg_no
--           AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk >= in_fm_yyyywk
--           AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk <= in_to_yyyywk
--           AND a1.delt_flg = 'N'
--           AND a2.bl_no_tp IN ('M', '0')
--           AND a2.bkg_sts_cd IN ('F', 'S')
--           AND a2.bkg_cgo_tp_cd NOT IN ('P')
--           AND a3.cntr_tpsz_cd LIKE 'Q%'
--      GROUP BY a1.trd_cd
--              ,a1.rlane_cd
--              ,a1.ioc_cd
--              ,a1.vsl_cd
--              ,a1.skd_voy_no
--              ,a1.dir_cd
--              ,NVL (a2.sls_ofc_cd, v_head_office)
--              ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office))
--              ,a3.cntr_tpsz_cd;

   IF (in_log_lvl <= '3') THEN
      enis_log_prc ('', v_log_mod_nm, v_step ||' ' || SQL%ROWCOUNT || ' INSERT');
   END IF;

   IF (in_log_lvl <= '1') THEN
      enis_log_prc ('', v_log_mod_nm
                   , '소요시간: ' || TO_CHAR (SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
      v_start_time := SYSTIMESTAMP;
   END IF;

   COMMIT;
   
   v_step := '신규 데이터 등록-NORMAL';
--[CHM-201007143-01]
   MERGE INTO coa_pfit_lss_smry a
      USING (
          SELECT   a1.trd_cd
                  ,a1.rlane_cd
                  ,a1.ioc_cd
                  ,a1.vsl_cd
                  ,a1.skd_voy_no
                  ,a1.dir_cd
                  ,NVL (a2.sls_ofc_cd, v_head_office) sls_ofc_cd
                  ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office)) agmt_sgn_ofc_cd
                  ,a3.cntr_tpsz_cd
    --              ,a3.stnd_cost_cd
                  ,decode(a3.stnd_cost_cd,'51301091','51301081',a3.stnd_cost_cd) stnd_cost_cd -- 20101123 Fuel surcharge 추가된 계정에 대해서 Merge
                  ,SUM (a3.estm_usd_ttl_amt) estm_pl_amt
                  ,SUM (a3.respb_usd_ttl_amt) ra_pl_amt
                  ,SUM (a3.act_uc_amt) act_pl_amt
                  ,SUM (a3.accl_rt_amt) accl_rt_amt
                  ,SUM (a3.estm_usd_ttl_amt) co_sls_amt

              FROM coa_mon_vvd a1, coa_rgst_bkg a2, coa_bkg_cost_smry a3
             WHERE a1.vsl_cd = a2.vsl_cd
               AND a1.trd_cd = a2.trd_cd
               AND a1.rlane_cd = a2.rlane_cd
               AND a1.ioc_cd = a2.ioc_cd
               AND a1.skd_voy_no = a2.skd_voy_no
               AND a1.dir_cd = a2.dir_cd
               AND a2.bkg_no = a3.bkg_no
               AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk >= in_fm_yyyywk
               AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk <= in_to_yyyywk
               AND a1.delt_flg = 'N'
               AND a2.bl_no_tp IN ('M', '0')
               AND a2.bkg_sts_cd IN ('F', 'S')
               AND a2.bkg_cgo_tp_cd NOT IN ('P')
               AND a3.stnd_cost_cd NOT IN ('LOAD0000')   --STP REV, STP COST 제외
          --AND a3.cntr_qty <> 0 -- 삭제된 부킹은 올려주지 않는다.
          GROUP BY a1.trd_cd
                  ,a1.rlane_cd
                  ,a1.ioc_cd
                  ,a1.vsl_cd
                  ,a1.skd_voy_no
                  ,a1.dir_cd
                  ,NVL (a2.sls_ofc_cd, v_head_office)
                  ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office))
                  ,a3.cntr_tpsz_cd
    --              ,a3.stnd_cost_cd
                  ,decode(a3.stnd_cost_cd,'51301091','51301081',a3.stnd_cost_cd) -- 20101123 Fuel surcharge 추가된 계정에 대해서 Merge
      ) b
      ON (
              a.vsl_cd = b.vsl_cd
          AND a.skd_voy_no = b.skd_voy_no
          AND a.skd_dir_cd = b.dir_cd
          AND a.ioc_cd = b.ioc_cd      
          AND a.rlane_cd = b.rlane_cd      
          AND a.trd_cd = b.trd_cd
          AND a.cntr_tpsz_cd = b.cntr_tpsz_cd
          AND a.sls_ofc_cd = b.sls_ofc_cd
          and a.agmt_sgn_ofc_cd = b.agmt_sgn_ofc_cd
          AND a.stnd_cost_cd = b.stnd_cost_cd

          )
      WHEN MATCHED THEN
         UPDATE
            SET a.estm_pl_amt = b.estm_pl_amt
               ,a.ra_pl_amt   = b.ra_pl_amt
               ,a.act_pl_amt  = b.act_pl_amt
               ,a.accl_rt_amt = b.accl_rt_amt
               ,a.co_sls_amt  = b.co_sls_amt
               ,a.co_amt = null
               ,a.upd_usr_id  = 'SYS_COA_PL'
               ,a.upd_dt      = SYSDATE
      WHEN NOT MATCHED THEN
         INSERT (
                a.trd_cd
               ,a.rlane_cd
               ,a.ioc_cd
               ,a.vsl_cd
               ,a.skd_voy_no
               ,a.skd_dir_cd
               ,a.sls_ofc_cd
               ,a.agmt_sgn_ofc_cd
               ,a.cntr_tpsz_cd
               ,a.stnd_cost_cd
               ,a.estm_pl_amt
               ,a.ra_pl_amt
               ,a.act_pl_amt
               ,a.accl_rt_amt
               ,a.co_sls_amt
               ,a.cre_usr_id
               ,a.cre_dt
               ,a.upd_usr_id
               ,a.upd_dt
                )
         VALUES (
                b.trd_cd
               ,b.rlane_cd
               ,b.ioc_cd
               ,b.vsl_cd
               ,b.skd_voy_no
               ,b.dir_cd
               ,b.sls_ofc_cd
               ,b.agmt_sgn_ofc_cd
               ,b.cntr_tpsz_cd
               ,b.stnd_cost_cd
               ,b.estm_pl_amt
               ,b.ra_pl_amt
               ,b.act_pl_amt
               ,b.accl_rt_amt
               ,b.co_sls_amt
               ,'SYS_COA_PL'
               ,SYSDATE
               ,'SYS_COA_PL'
               ,SYSDATE
                );


   -- 2015.01.30 comment
--   INSERT INTO coa_pfit_lss_smry
--               (trd_cd
--               ,rlane_cd
--               ,ioc_cd
--               ,vsl_cd
--               ,skd_voy_no
--               ,skd_dir_cd
--               ,sls_ofc_cd
--               ,agmt_sgn_ofc_cd
--               ,cntr_tpsz_cd
--               ,stnd_cost_cd
--               ,estm_pl_amt
--               ,ra_pl_amt
--               ,act_pl_amt
--               ,accl_rt_amt
--               ,co_sls_amt
--               ,cre_usr_id
--               ,cre_dt
--               ,upd_usr_id
--               ,upd_dt               
--               )
--      SELECT   a1.trd_cd
--              ,a1.rlane_cd
--              ,a1.ioc_cd
--              ,a1.vsl_cd
--              ,a1.skd_voy_no
--              ,a1.dir_cd
--              ,NVL (a2.sls_ofc_cd, v_head_office) sls_ofc_cd
--              ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office)) agmt_sgn_ofc_cd
--              ,a3.cntr_tpsz_cd
----              ,a3.stnd_cost_cd
--              ,decode(a3.stnd_cost_cd,'51301091','51301081',a3.stnd_cost_cd) stnd_cost_cd -- 20101123 Fuel surcharge 추가된 계정에 대해서 Merge
--              ,SUM (a3.estm_usd_ttl_amt) estm_pl_amt
--              ,SUM (a3.respb_usd_ttl_amt) ra_pl_amt
--              ,SUM (a3.act_uc_amt) act_pl_amt
--              ,SUM (a3.accl_rt_amt) accl_rt_amt
--              ,SUM (a3.estm_usd_ttl_amt) co_sls_amt
--              ,'SYS_COA_PL'
--              ,SYSDATE
--              ,'SYS_COA_PL'
--              ,SYSDATE
--          FROM coa_mon_vvd a1, coa_rgst_bkg a2, coa_bkg_cost_smry a3
--         WHERE a1.vsl_cd = a2.vsl_cd
--           AND a1.trd_cd = a2.trd_cd
--           AND a1.rlane_cd = a2.rlane_cd
--           AND a1.ioc_cd = a2.ioc_cd
--           AND a1.skd_voy_no = a2.skd_voy_no
--           AND a1.dir_cd = a2.dir_cd
--           AND a2.bkg_no = a3.bkg_no
--           AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk >= in_fm_yyyywk
--           AND SUBSTR (a1.sls_yrmon, 1, 4) || a1.cost_wk <= in_to_yyyywk
--           AND a1.delt_flg = 'N'
--           AND a2.bl_no_tp IN ('M', '0')
--           AND a2.bkg_sts_cd IN ('F', 'S')
--           AND a2.bkg_cgo_tp_cd NOT IN ('P')
--           AND a3.stnd_cost_cd NOT IN ('LOAD0000')   --STP REV, STP COST 제외
--      --AND a3.cntr_qty <> 0 -- 삭제된 부킹은 올려주지 않는다.
--      GROUP BY a1.trd_cd
--              ,a1.rlane_cd
--              ,a1.ioc_cd
--              ,a1.vsl_cd
--              ,a1.skd_voy_no
--              ,a1.dir_cd
--              ,NVL (a2.sls_ofc_cd, v_head_office)
--              ,NVL (a2.agmt_sgn_ofc_cd, NVL (a2.sls_ofc_cd, v_head_office))
--              ,a3.cntr_tpsz_cd
----              ,a3.stnd_cost_cd
--              ,decode(a3.stnd_cost_cd,'51301091','51301081',a3.stnd_cost_cd) -- 20101123 Fuel surcharge 추가된 계정에 대해서 Merge
--              ;
   IF (in_log_lvl <= '3') THEN
      enis_log_prc ('', v_log_mod_nm, v_step ||' ' || SQL%ROWCOUNT || ' INSERT');
   END IF;

   IF (in_log_lvl <= '1') THEN
      enis_log_prc ('', v_log_mod_nm
                   , '소요시간: ' || TO_CHAR (SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
      v_start_time := SYSTIMESTAMP;
   END IF;



   COMMIT;

   --////////////////////////////////////////////////////////////////////////////////////////////
   -- Space Chater Revenue및 BSA를 밀어넣기
   --////////////////////////////////////////////////////////////////////////////////////////////
   MERGE INTO coa_pfit_lss_smry a
      USING (SELECT   vsl_cd
                     ,skd_voy_no
                     ,dir_cd
                     ,rlane_cd
                     ,trd_cd
                     ,ioc_cd
                     ,'BSA00000' stnd_cost_cd
                     ,'XXXX' cntr_tpsz_cd
                     ,SUM (fnl_co_bsa_capa) estm_pl_amt
                     ,0 ra_pl_amt
                     ,0 act_pl_amt
                     ,0 accl_rt_amt
                     ,'X' pl_desc
                     ,v_head_office agmt_sgn_ofc_cd
                     ,v_head_office sls_ofc_cd
                 FROM (SELECT a.vsl_cd
                             ,a.skd_voy_no
                             ,a.dir_cd
                             ,a.rlane_cd
                             ,a.trd_cd
                             ,a.ioc_cd
                             ,b.fnl_co_bsa_capa
                             , NVL (b.incm_bzc_chtr_amt, 0) + NVL (b.incm_sub_chtr_amt, 0)
                               + NVL (b.incm_crs_chtr_amt, 0) spc_income
                         FROM coa_mon_vvd a, bsa_vvd_mst b
                        WHERE a.vsl_cd = b.vsl_cd
                          AND a.skd_voy_no = b.skd_voy_no
                          AND a.dir_cd = b.skd_dir_cd
                          AND a.trd_cd = b.trd_cd
                          AND a.rlane_cd = b.rlane_cd
                          AND a.ioc_cd = b.ioc_cd
                          AND SUBSTR (a.sls_yrmon, 1, 4) || a.cost_wk >= in_fm_yyyywk
                          AND SUBSTR (a.sls_yrmon, 1, 4) || a.cost_wk <= in_to_yyyywk
                          AND a.delt_flg = 'N')
             GROUP BY vsl_cd, skd_voy_no, dir_cd, rlane_cd, trd_cd, ioc_cd) b
      ON (    a.trd_cd = b.trd_cd
          AND a.rlane_cd = b.rlane_cd
          AND a.ioc_cd = b.ioc_cd
          AND a.vsl_cd = b.vsl_cd
          AND a.skd_voy_no = b.skd_voy_no
          AND a.skd_dir_cd = b.dir_cd
          AND a.stnd_cost_cd = b.stnd_cost_cd
          AND a.cntr_tpsz_cd = b.cntr_tpsz_cd)
      WHEN MATCHED THEN
         UPDATE
            SET a.estm_pl_amt = b.estm_pl_amt
               ,a.ra_pl_amt   = b.estm_pl_amt
               ,a.upd_usr_id  = 'SYS_COA_PL'
               ,a.upd_dt      = SYSDATE
      WHEN NOT MATCHED THEN
         INSERT (a.vsl_cd, a.skd_voy_no, a.skd_dir_cd, a.ioc_cd, a.rlane_cd, a.trd_cd, a.cntr_tpsz_cd, a.stnd_cost_cd
                ,a.estm_pl_amt, a.ra_pl_amt, a.act_pl_amt, a.accl_rt_amt, a.pl_desc
                ,a.cre_usr_id, a.cre_dt, a.upd_usr_id, a.upd_dt
                ,a.agmt_sgn_ofc_cd, a.sls_ofc_cd)
         VALUES (b.vsl_cd, b.skd_voy_no, b.dir_cd, b.ioc_cd, b.rlane_cd, b.trd_cd, b.cntr_tpsz_cd, b.stnd_cost_cd
                ,b.estm_pl_amt, b.estm_pl_amt, b.act_pl_amt, b.accl_rt_amt, b.pl_desc
                ,'SYS_COA_PL', SYSDATE,'SYS_COA_PL', SYSDATE
                ,b.agmt_sgn_ofc_cd, b.sls_ofc_cd);

   IF (in_log_lvl <= '3') THEN
      enis_log_prc ('', v_log_mod_nm, 'Space Chater Revenue및 BSA를 밀어넣기 ' || SQL%ROWCOUNT || ' MERGE');
   END IF;

   IF (in_log_lvl <= '1') THEN
      enis_log_prc ('', v_log_mod_nm
                   , '소요시간: ' || TO_CHAR (SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
      v_start_time := SYSTIMESTAMP;
   END IF;

   COMMIT;
   --////////////////////////////////////////////////////////////////////////////////////////////
   -- Special Lane에 대한 LOAD(수송량)을 BSA(공급량)으로 밀어넣기
   --////////////////////////////////////////////////////////////////////////////////////////////
   MERGE INTO coa_pfit_lss_smry a
      USING (SELECT   b.vsl_cd vsl_cd
                     ,b.skd_voy_no skd_voy_no
                     ,b.skd_dir_cd skd_dir_cd
                     ,b.rlane_cd rlane_cd
                     ,b.trd_cd trd_cd
                     ,b.ioc_cd ioc_cd
                     ,'BSA00000' stnd_cost_cd
                     ,'XXXX' cntr_tpsz_cd
                     ,SUM (DECODE (SUBSTR (b.cntr_tpsz_cd, -1), '2', b.estm_pl_amt, b.estm_pl_amt * 2)) estm_pl_amt   -- TEU Base
                     ,0 ra_pl_amt
                     ,0 act_pl_amt
                     ,0 accl_rt_amt
                     ,'LOAD to BSA' pl_desc
                     ,v_head_office agmt_sgn_ofc_cd
                     ,v_head_office sls_ofc_cd
                 FROM coa_mon_vvd a, coa_pfit_lss_smry b, coa_lane_rgst c
                WHERE a.trd_cd = b.trd_cd
                  AND a.rlane_cd = b.rlane_cd
                  AND a.ioc_cd = b.ioc_cd
                  AND a.vsl_cd = b.vsl_cd
                  AND a.skd_voy_no = b.skd_voy_no
                  AND a.dir_cd = b.skd_dir_cd
                  AND a.rlane_cd = c.rlane_cd
                  AND a.dir_cd = c.dir_cd
                  AND a.trd_cd = c.trd_cd
                  AND a.ioc_cd = c.ioc_cd
                  AND b.stnd_cost_cd = 'LOAD0000'
                  AND SUBSTR (a.sls_yrmon, 1, 4) || a.cost_wk >= in_fm_yyyywk
                  AND SUBSTR (a.sls_yrmon, 1, 4) || a.cost_wk <= in_to_yyyywk
                  AND NVL (a.delt_flg, 'N') = 'N'
                  AND NVL (c.lod_spl_cng_flg, 'N') = 'Y'
             GROUP BY b.vsl_cd, b.skd_voy_no, b.skd_dir_cd, b.rlane_cd, b.trd_cd, b.ioc_cd) b
      ON (    a.trd_cd = b.trd_cd
          AND a.rlane_cd = b.rlane_cd
          AND a.ioc_cd = b.ioc_cd
          AND a.vsl_cd = b.vsl_cd
          AND a.skd_voy_no = b.skd_voy_no
          AND a.skd_dir_cd = b.skd_dir_cd
          AND a.stnd_cost_cd = b.stnd_cost_cd
          AND a.cntr_tpsz_cd = b.cntr_tpsz_cd)
      WHEN MATCHED THEN
         UPDATE
            SET a.estm_pl_amt = b.estm_pl_amt
               ,a.ra_pl_amt = b.estm_pl_amt
               ,a.pl_desc = b.pl_desc
               ,a.upd_usr_id = 'SYS_COA_PL'
               ,a.upd_dt = SYSDATE
      WHEN NOT MATCHED THEN
         INSERT (a.vsl_cd, a.skd_voy_no, a.skd_dir_cd, a.ioc_cd, a.rlane_cd, a.trd_cd, a.cntr_tpsz_cd, a.stnd_cost_cd
                ,a.estm_pl_amt, a.ra_pl_amt, a.act_pl_amt, a.accl_rt_amt, a.pl_desc
                ,a.cre_usr_id, a.cre_dt, a.upd_usr_id, a.upd_dt
                ,a.agmt_sgn_ofc_cd, a.sls_ofc_cd)
         VALUES (b.vsl_cd, b.skd_voy_no, b.skd_dir_cd, b.ioc_cd, b.rlane_cd, b.trd_cd, b.cntr_tpsz_cd, b.stnd_cost_cd
                ,b.estm_pl_amt, b.estm_pl_amt, b.act_pl_amt, b.accl_rt_amt, b.pl_desc
                ,'SYS_COA_PL', SYSDATE, 'SYS_COA_PL', SYSDATE
                ,b.agmt_sgn_ofc_cd, b.sls_ofc_cd);

   IF (in_log_lvl <= '3') THEN
      enis_log_prc (''
                   ,v_log_mod_nm
                   , 'Special Lane에 대한 LOAD(수송량)을 BSA(공급량)으로 밀어넣기 ' || SQL%ROWCOUNT || ' MERGE'
                   );
   END IF;

   IF (in_log_lvl <= '1') THEN
      enis_log_prc ('', v_log_mod_nm
                   , '소요시간: ' || TO_CHAR (SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
      v_start_time := SYSTIMESTAMP;
   END IF;

   COMMIT;

   --////////////////////////////////////////////////////////////////////////////////////////////
   -- LOAD에 없는 BSA 0 처리
   --////////////////////////////////////////////////////////////////////////////////////////////
   UPDATE coa_pfit_lss_smry
      SET estm_pl_amt = 0
         ,ra_pl_amt = 0
         ,upd_usr_id = 'SYS_COA_PL'
         ,pl_desc = 'BSA Only'
         ,upd_dt = SYSDATE
    WHERE (vsl_cd, skd_voy_no, skd_dir_cd, ioc_cd, rlane_cd, trd_cd, cntr_tpsz_cd, stnd_cost_cd) IN (
             SELECT a.vsl_cd vsl_cd
                   ,a.skd_voy_no skd_voy_no
                   ,a.dir_cd skd_dir_cd
                   ,a.ioc_cd ioc_cd
                   ,a.rlane_cd rlane_cd
                   ,a.trd_cd trd_cd
                   ,'XXXX' cntr_tpsz_cd
                   ,'BSA00000' stnd_cost_cd
               FROM coa_mon_vvd a, coa_pfit_lss_smry b, coa_lane_rgst c
              WHERE 1 = 1
                AND a.vsl_cd = b.vsl_cd
                AND a.skd_voy_no = b.skd_voy_no
                AND a.dir_cd = b.skd_dir_cd
                AND a.ioc_cd = b.ioc_cd
                AND a.rlane_cd = b.rlane_cd
                AND a.trd_cd = b.trd_cd
                AND a.rlane_cd = c.rlane_cd
                AND a.dir_cd = c.dir_cd
                AND a.trd_cd = c.trd_cd
                AND a.ioc_cd = c.ioc_cd
                AND b.stnd_cost_cd = 'BSA00000'
                AND SUBSTR (a.sls_yrmon, 1, 4) || a.cost_wk >= in_fm_yyyywk
                AND SUBSTR (a.sls_yrmon, 1, 4) || a.cost_wk <= in_to_yyyywk
                AND NVL (a.delt_flg, 'N') = 'N'
                AND NVL (c.lod_spl_cng_flg, 'N') = 'Y'
             MINUS
             SELECT a.vsl_cd vsl_cd
                   ,a.skd_voy_no skd_voy_no
                   ,a.dir_cd skd_dir_cd
                   ,a.ioc_cd ioc_cd
                   ,a.rlane_cd rlane_cd
                   ,a.trd_cd trd_cd
                   ,'XXXX' cntr_tpsz_cd
                   ,'BSA00000' stnd_cost_cd
               FROM coa_mon_vvd a, coa_pfit_lss_smry b, coa_lane_rgst c
              WHERE 1 = 1
                AND a.vsl_cd = b.vsl_cd
                AND a.skd_voy_no = b.skd_voy_no
                AND a.dir_cd = b.skd_dir_cd
                AND a.ioc_cd = b.ioc_cd
                AND a.rlane_cd = b.rlane_cd
                AND a.trd_cd = b.trd_cd
                AND a.rlane_cd = c.rlane_cd
                AND a.dir_cd = c.dir_cd
                AND a.trd_cd = c.trd_cd
                AND a.ioc_cd = c.ioc_cd
                AND b.stnd_cost_cd = 'LOAD0000'
                AND SUBSTR (a.sls_yrmon, 1, 4) || a.cost_wk >= in_fm_yyyywk
                AND SUBSTR (a.sls_yrmon, 1, 4) || a.cost_wk <= in_to_yyyywk
                AND NVL (a.delt_flg, 'N') = 'N'
                AND NVL (c.lod_spl_cng_flg, 'N') = 'Y');

   IF (in_log_lvl <= '3') THEN
      enis_log_prc ('', v_log_mod_nm, 'LOAD에 없는 BSA 0 처리 ' || SQL%ROWCOUNT || ' UPDATE');
   END IF;

   IF (in_log_lvl <= '1') THEN
      enis_log_prc ('', v_log_mod_nm
                   , '소요시간: ' || TO_CHAR (SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
      v_start_time := SYSTIMESTAMP;
      enis_log_prc (''
                   ,v_log_mod_nm
                   , '총 소요시간: ' || TO_CHAR (SYSTIMESTAMP - v_start_ttl_time, 'yyyy/mm/dd hh24:mi:ss.ff')
                   );
   END IF;

   COMMIT;
   enis_log_prc ('', v_log_mod_nm, 'End ');
EXCEPTION
   WHEN OTHERS THEN
      enis_log_prc ('', v_log_mod_nm, 'Error: ' || v_step || ' > ' || SQLERRM);
END COA_PFIT_LSS_SMRY_PRC;