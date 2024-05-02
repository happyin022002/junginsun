-- 분기에 한번 생성(COA_HLD_COST)
-- CDA 담당자가 기간을 보내주면서 COA 수송량과 holding days를 요청하면
-- 월별로 데이터를 뽑아줌
-- 2011.01 : 2010.09~11

SELECT   '201011' cost_yrmon
      ,EQ_TPSZ_CD
--      ,stnd_cost_cd
--      ,'CNTR' cntr_chss_div_cd
      ,SUM(cntr_qty) qty
      ,SUM(fcgo_tz_dys * cntr_qty) fdays
      ,SUM(mcgo_tz_dys * cntr_qty) mdays
      ,ROUND((SUM(fcgo_tz_dys * cntr_qty) + SUM(mcgo_tz_dys * cntr_qty)) / SUM(cntr_qty)) eq_hld_dys
      ,'' upd_usr_id
      ,SYSDATE upd_dt
  FROM (
        SELECT   /*+ ordered index(a4 XAK5COA_RGST_BKG) */
                 a1.bkg_no
                ,a3.stnd_cost_cd
                ,DECODE(coa_ut_tpsz_fnc('TPS' , a3.CNTR_TPSZ_CD), 'RD2', 'R2', 'RD5', 'R5', coa_ut_tpsz_fnc('TPS' , a3.CNTR_TPSZ_CD)) EQ_TPSZ_CD
                ,AVG(a3.cntr_qty) cntr_qty
                ,AVG(a3.fcgo_tz_dys) fcgo_tz_dys
                ,AVG(a3.mcgo_tz_dys) mcgo_tz_dys
            FROM coa_rgst_bkg a1
                 ,coa_mon_vvd a2
                 ,coa_bkg_cost_smry a3   
--                 , coa_hld_cost a4
           WHERE 1 = 1
             AND a1.bl_no_tp           IN('M', '0')
             AND a1.bkg_sts_cd         IN('F', 'S')
             AND a1.bkg_cgo_tp_cd      NOT IN('P')
             AND NVL(a2.delt_flg, 'N') = 'N'
             AND a2.cost_yrmon         BETWEEN '201011' AND '201011'
             AND a3.stnd_cost_cd       = '52301011'-- 장비비 계정이 모든 TPSZ 들어있는 계정으로 골라야 함 확인 필요
             AND a1.trd_cd             = a2.trd_cd
             AND a1.rlane_cd           = a2.rlane_cd
             AND a1.ioc_cd             = a2.ioc_cd
             AND a1.vsl_cd             = a2.vsl_cd
             AND a1.skd_voy_no         = a2.skd_voy_no
             AND a1.dir_cd             = a2.dir_cd
             AND a1.bkg_no             = a3.bkg_no
             AND A3.cntr_qty           <> 0
--             AND a2.cost_yrmon = a4.cost_yrmon
--             AND a4.cntr_chss_div_cd = 'CNTR'
--             AND coa_ut_tpsz_fnc(NULL, DECODE(a3.cntr_tpsz_cd, 'RD2', 'R2', 'RD5', 'R5', a3.cntr_tpsz_cd)) = a4.eq_tpsz_cd
--             AND a3.stnd_cost_cd = a4.stnd_cost_cd
        GROUP BY 
                a1.bkg_no
                ,a3.stnd_cost_cd
                ,DECODE(coa_ut_tpsz_fnc('TPS' , a3.CNTR_TPSZ_CD), 'RD2', 'R2', 'RD5', 'R5', coa_ut_tpsz_fnc('TPS' , a3.CNTR_TPSZ_CD)) 
                ,cost_rout_no
        )
GROUP BY EQ_TPSZ_CD
--       , stnd_cost_cd
;