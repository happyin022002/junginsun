CREATE OR REPLACE PROCEDURE OPUSADM."COA_CNTR_REPO_SHTG_INFO_PRC" (in_cost_yrmon_dest IN VARCHAR2, in_cost_yrmon_src IN VARCHAR2  )
AUTHID CURRENT_USER
IS
/******************************************************************************
   
   사용 예
   
   Dry는 같은 del_repo_flg를 사용하므로 CNTR_TPSZ_CD 가 'D'로 되어있음
              'R2', 'R5'는 각각 장비 부족지역 del_repo_flg가 setting 되어있음
              
   201007월 사용 ratio를 CMB source 기간을 201004-05월로 만들 경우
   coa_cntr_repo_shtg_info_prc('201007', '201005');   
   
   Name         :   COA_CNTR_REPO_SHTG_INFO_PRC
   Purpose      :   EQ 회송 기여도 장비 부족지역 선정
   Source       :
   Target       :   COA_CNTR_REPO_SHTG_INFO_PRC
******************************************************************************/

--------------------------------[     변수 선언   ]-----------------------

/** 작업로그 관련 변수선언 **/
BEGIN
   enis_log_prc(SYSDATE, 'COA_CNTR_REPO_SHTG_INFO_PRC', 'V.20071012' || ' START');

---------------------------------[      BODY      ]-----------------------

   --STEP1 기존 데이터 삭제
   DELETE FROM coa_cntr_repo_shtg_info
         WHERE cost_yrmon = in_cost_yrmon_dest;

   --STEP2 신규 데이터 등록
   INSERT INTO coa_cntr_repo_shtg_info
               (cost_yrmon
               ,cntr_tpsz_cd
               ,ecc_cd
               ,lcc_cd
               ,rcc_cd
               ,imbal_cr_lvl
               ,opb_cr_lvl
               ,mb_cr_lvl
               ,imbal_amt
               ,opb_amt
               ,mb_amt
               ,cre_usr_id
               ,cre_dt
               ,upd_usr_id
               ,upd_dt
               )
      SELECT in_cost_yrmon_dest
            ,cntr_tpsz_cd
            ,ecc_cd
            ,lcc_cd
            ,rcc_cd
            ,(SELECT MAX(eq_repo_cr_lvl)
                FROM coa_cntr_repo_rule b
               WHERE b.cost_yrmon = in_cost_yrmon_dest
                 AND b.cntr_tpsz_cd = a.cntr_tpsz_cd
                 AND (   DECODE(b.eq_repo_cr_lvl, 'X', a.imbalance, a.inbal_ranking) >= b.imbal_fm_rto
                      OR DECODE(b.eq_repo_cr_lvl, 'X', a.imbalance, a.inbal_ranking) > b.imbal_to_rto
                     )
                 AND b.imbal_all_aply_flg = 'Y') imbalance_level
            ,(SELECT b.eq_repo_cr_lvl
                FROM coa_cntr_repo_rule b
               WHERE b.cost_yrmon = in_cost_yrmon_dest
                 AND b.cntr_tpsz_cd = a.cntr_tpsz_cd
                 AND (a.cmb BETWEEN b.opb_fm_amt AND b.opb_to_amt)
                 AND b.opb_all_aply_flg = 'Y') opb_level
            ,(SELECT b.eq_repo_cr_lvl
                FROM coa_cntr_repo_rule b
               WHERE b.cost_yrmon = in_cost_yrmon_dest
                 AND b.cntr_tpsz_cd = a.cntr_tpsz_cd
                 AND (a.matchback BETWEEN b.mb_fm_rto AND b.mb_to_rto)
                 AND b.mb_all_aply_flg = 'Y') mb_level
            ,a.imbalance --아래컬럼으로변경
            --,a.inbal_ranking
            ,a.cmb
            ,a.matchback
            ,'SYSTEM_COA'
            ,SYSDATE
            ,'SYSTEM_COA'
            ,SYSDATE
        FROM (SELECT cntr_tpsz_cd
                    ,ecc_cd
                    ,lcc_cd
                    ,rcc_cd
                    ,imbalance
                    ,inbal_ranking
                    ,NVL(cmb, 0) cmb
                    ,ROUND(matchback, 5) matchback -- 2010.11.26 이윤정 [CHM-201007334-01] 적은 물량에도 Ratio 부여 되도록 로직 수정 [ROUND(matchback, 2)-->ROUND(matchback, 5) 로 변경]
                FROM (SELECT b.ecc_cd
                            ,b.lcc_cd
                            ,b.rcc_cd
                            ,b.cntr_tpsz_cd
                            ,a.cmb
                            ,imbalance
                            ,inbal_ranking
                            ,DECODE(SIGN(b.ob_vol - b.ib_vol), 1, -b.ib_vol / b.ob_vol, -1, b.ob_vol / b.ib_vol, 0, 1) matchback
                        FROM (SELECT   c.ecc_cd
                                      ,d.cntr_tpsz_cd
                                      , SUM(d.estm_cm_cost_amt) / SUM(d.bkg_qty) cmb
                                  FROM coa_mon_vvd a, coa_rgst_bkg b, coa_location_v c, coa_bkg_rev_dtl d, coa_spcl_repo_cntr_rgst e
                                 WHERE a.trd_cd = b.trd_cd
                                   AND a.rlane_cd = b.rlane_cd
                                   AND a.ioc_cd = b.ioc_cd
                                   AND a.vsl_cd = b.vsl_cd
                                   AND a.skd_voy_no = b.skd_voy_no
                                   AND a.dir_cd = b.dir_cd
                                   AND b.bkg_no = d.bkg_no
                                   AND a.cost_yrmon BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(in_cost_yrmon_src, 'yyyymm'), -1), 'yyyymm') AND in_cost_yrmon_src
                                   --AND a.cost_yrmon BETWEEN '200807' AND '200808'
                                   AND b.bkg_sts_cd IN('F', 'S')
                                   AND b.bkg_cgo_tp_cd <> 'P'
                                   AND b.bkg_por_cd = c.loc_cd
                                   AND e.repo_flg = 'Y'
                                   AND NVL(e.delt_flg, 'N') = 'N'
                                   AND d.cntr_tpsz_cd = e.cntr_tpsz_cd
                                   AND e.list_bx_set_lvl_cd = '0001'
                              GROUP BY c.ecc_cd, d.cntr_tpsz_cd) a
                            ,(   /* Match Back */
                              SELECT ecc_cd
                                    ,lcc_cd
                                    ,rcc_cd
                                    ,cntr_tpsz_cd
                                    ,CUME_DIST() OVER(PARTITION BY cntr_tpsz_cd ORDER BY ib_vol - ob_vol) inbal_ranking
                                    , ib_vol - ob_vol imbalance
                                    ,ib_vol
                                    ,ob_vol
                                FROM (SELECT   b.ecc_cd
                                              ,b.lcc_cd
                                              ,b.rcc_cd
                                              ,a.cntr_tpsz_cd
                                              ,SUM(full_ib_qty) ib_vol
                                              ,SUM(full_ob_qty) ob_vol
                                          FROM coa_mtch_bak_info a, coa_location_v b, coa_cntr_repo_rout_ecc c, coa_spcl_repo_cntr_rgst e
                                         WHERE a.loc_cd = b.loc_cd
                                           AND b.rcc_cd = c.rcc_cd
                                           AND b.ecc_cd = c.ecc_cd
                                           AND a.cost_yrmon = c.cost_yrmon
                                           AND c.del_repo_flg = 'Y'
                                           AND c.cntr_tpsz_cd = DECODE(SUBSTR(e.cntr_tpsz_cd, 0, 1), 'D', 'D', e.cntr_tpsz_cd)  
                                           AND e.repo_flg = 'Y'
                                           AND NVL(e.delt_flg, 'N') = 'N'
                                           AND a.cntr_tpsz_cd = e.cntr_tpsz_cd
                                           AND a.cost_yrmon = in_cost_yrmon_dest
                                      GROUP BY b.ecc_cd, b.lcc_cd, b.rcc_cd, a.cntr_tpsz_cd)) b
                       WHERE a.ecc_cd(+) = b.ecc_cd
                         AND a.cntr_tpsz_cd(+) = b.cntr_tpsz_cd)) a;

   --STEP3 cr_rto 업데이트
   UPDATE coa_cntr_repo_shtg_info a
      SET a.eq_repo_cr_rto =
             (SELECT b.eq_repo_cr_rto
                FROM coa_cntr_repo_cr b
               WHERE b.cost_yrmon = in_cost_yrmon_dest
                 AND b.cntr_tpsz_cd = a.cntr_tpsz_cd
                 AND b.repo_lvl_grp_cd = a.imbal_cr_lvl || a.opb_cr_lvl || a.mb_cr_lvl)
    WHERE a.cost_yrmon = in_cost_yrmon_dest;

--   --STEP4 정리작업
--   DELETE FROM coa_cntr_repo_shtg_info
--         WHERE cost_yrmon = in_cost_yrmon
--           AND (   imbal_cr_lvl = 'X'
--                OR imbal_cr_lvl IS NULL
--                OR opb_cr_lvl = 'X'
--                OR opb_cr_lvl IS NULL
--                OR mb_cr_lvl = 'X'
--                OR mb_cr_lvl IS NULL);

   enis_log_prc(SYSDATE, 'COA_CNTR_REPO_SHTG_INFO_PRC', 'End');
---------------------------------------------------------------------------------------------------------------------
EXCEPTION
   WHEN OTHERS
   THEN
      enis_log_prc(SYSDATE, 'COA_CNTR_REPO_SHTG_INFO_PRC', 'Error: ' || SQLERRM);
END coa_cntr_repo_shtg_info_prc;