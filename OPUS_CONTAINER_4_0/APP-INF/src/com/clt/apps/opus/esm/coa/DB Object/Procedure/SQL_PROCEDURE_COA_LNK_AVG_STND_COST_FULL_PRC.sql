CREATE OR REPLACE PROCEDURE OPUSADM.COA_LNK_AVG_STND_COST_FULL_PRC (    
   in_cost_yrmon_src_fm         in   varchar2     
  ,in_cost_yrmon_src_to         in   varchar2     
  ,in_cost_yrmon_src_trlcrd     in   varchar2     
  ,in_rev_vvd_exe_yrmon         in   varchar2    
  ,in_cost_yrmon_dest           in   varchar2    
  ,in_cost_yrmon_copy_src       in   varchar2    
)   Authid current_user 
IS    
/******************************************************************************    
   Purpose      : 1. TRS의 테이블로부터 LINK 평균단가 생성     
    
    -- LOG 보기    
    SELECT * FROM ENIS_LOG    
    WHERE MOD_NAME = 'COA_LNK_AVG_STND_COST_FULL_PRC'    
      AND EXEC_DT > SYSDATE - 1/24    
    ORDER BY EXEC_DT DESC       


******************************************************************************/    
    
   ------------------------------[ 변수선언부             ]-----------------------    
   /** 작업로그 관련 변수선언 **/    
   v_start_time                   TIMESTAMP;    
   v_prc_cnt                      NUMBER;    
   v_coa_step                     VARCHAR(100);    
   v_cost_yrmon_prev2             VARCHAR2(6);   -- 1개월전 월    
   v_cost_yrmon_prev0             VARCHAR2(6);   -- 현재월 월    
   v_cost_yrmon_max               VARCHAR2(6);   -- 단가생성 최근월    
   v_yrmon_copy_src_cnt           NUMBER;        -- copy 월 건수    
       
-------------------------------[ 업무로직 구현부       ]-----------------------    
BEGIN    
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
-- 시작 정보 출력    
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
   v_coa_step := '초기값 설정';    
   v_start_time := systimestamp;    
   v_prc_cnt := 0;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', '[V.20100616]');    
   enis_log_prc(sysdate    
               ,'COA_LNK_AVG_STND_COST_FULL_PRC'    
               , 'IN_COST_YRMON_SRC_FM:' || in_cost_yrmon_src_fm || ',' || 'IN_COST_YRMON_SRC_TO:' || in_cost_yrmon_src_to 
                 || ',' || 'IN_REV_VVD_EXE_YRMON:' || in_rev_vvd_exe_yrmon || '-->' || 'IN_COST_YRMON_DEST:' || in_cost_yrmon_dest 
               );    
   --    
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
--기간 구하기 --   
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
   v_coa_step := '기간 구하기';    
--   v_cost_yrmon_prev2 := TO_CHAR(add_months(TO_DATE(in_cost_yrmon_src || '01', 'YYYYMMDD'), -1), 'YYYYMM');    
--   v_cost_yrmon_prev0 := in_cost_yrmon_src;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'in_cost_yrmon_src_fm:' || in_cost_yrmon_src_fm);    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'in_cost_yrmon_src_to:' || in_cost_yrmon_src_to);    
   --    
   
-------------------------------[ LINK AVG COST 작업 처리         ]-----------------------    
   --    
/************************************************************************************************************    
 * 순수 tpsz    
 ***********************************************************************************************************/    
 
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
-- LINK FULL 단가 처리    
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
   v_coa_step := 'LINK FULL 단가 처리_기본 단가 UPD';    
   
   --생성하고자 하는 년월보다 1개월 후 월로 단가를 생성한 후
   --logic 처리하여 update 한다.
   --EX)101006월에 단가를 복사해 놓으면 101007월에 update 될 단가들이 저장되고
   --   merge into 로 101006월로 update 된다.
   
   DELETE FROM coa_lnk_avg_stnd_cost
         WHERE cost_yrmon = to_char(add_months(to_date(in_cost_yrmon_dest, 'yyyymm'), 1),'YYYYMM')
           AND full_mty_cd = 'F' ;
   
   MERGE INTO coa_lnk_avg_stnd_cost f1    
      USING (WITH uom_qty AS    
              (    
                SELECT lnk_fm_nod_cd    
                      ,lnk_to_nod_cd    
                      ,cntr_tpsz_cd    
                      ,coa_cost_src_cd    
                      --1. TRDRTD 계정에 대해 I/B, O/B 모두 Invoice 대상선정시 1st node와 3rd node의 Location이 일치하는 경우에 부합하는 것만 대상으로 한다.    
                      --2. Surcharge의 경우 Volume을 TR_FULL의 정보를 사용하는데 1번로직 적용후 금액은 그대로 인데 물량이 줄어서     
                      --   Surcharge 단가가 커지는 현상이 발생하여 Surcharge에서 사용하는 volume정보는 1번로직을 적용하지 않는다    
                      --3. TRDRTD 계정만이 아니라 TR로 시작해서 TD로 끝나는 계정[TR__TD]에 대해서    
                      -- 미주지역[US, CA, MX]의 경우 TYPE SIZE에 상관없이 평균단가를 적용한다.    
                      --4. SCFUTD계정의 미주지역[US, CA, MX]의 경우 TYPE SIZE에 상관없이 평균단가를 적용한다.    
                      --5. (-)Invoice 의 경우 (+,-) 여부가 아니라 해당 구간의 대상금액의 합계가 (-)경우 단가에서 제외시킨다.    
                      ,CASE    
                           WHEN (coa_cost_src_cd LIKE 'TR__TD' OR coa_cost_src_cd = 'SCFUTD') AND (SUBSTR(lnk_fm_nod_cd,1,2) IN ('US','CA','MX') OR SUBSTR(lnk_to_nod_cd,1,2) IN ('US','CA','MX'))    
                             THEN SUM(cost_src_qty) OVER (PARTITION BY lnk_fm_nod_cd, lnk_to_nod_cd, coa_cost_src_cd)    
                           ELSE cost_src_qty    
                       END cost_src_qty    
--                      [CHM-201006103-01] 
--                      ,CASE    
--                           WHEN (coa_cost_src_cd LIKE 'TR__TD' OR coa_cost_src_cd = 'SCFUTD') AND (SUBSTR(lnk_fm_nod_cd,1,2) IN ('US','CA','MX') OR SUBSTR(lnk_to_nod_cd,1,2) IN ('US','CA','MX'))    
--                             THEN SUM(cost_src_qty2) OVER (PARTITION BY lnk_fm_nod_cd, lnk_to_nod_cd, coa_cost_src_cd)    
--                           ELSE cost_src_qty2    
--                       END cost_src_qty2 -- TR_FULL시 사용할 Volume    
                      ,CASE    
                           WHEN (coa_cost_src_cd LIKE 'TR__TD' OR coa_cost_src_cd = 'SCFUTD') AND (SUBSTR(lnk_fm_nod_cd,1,2) IN ('US','CA','MX') OR SUBSTR(lnk_to_nod_cd,1,2) IN ('US','CA','MX'))    
                             THEN SUM(cost_usd_amt) OVER (PARTITION BY lnk_fm_nod_cd, lnk_to_nod_cd,coa_cost_src_cd)    
                           ELSE cost_usd_amt    
                       END cost_usd_amt    
                  FROM (                         
                       SELECT b1.lnk_fm_nod_cd    
                             ,b1.lnk_to_nod_cd    
                             ,b1.cntr_tpsz_cd    
                             ,b1.coa_cost_src_cd    
                             ,SUM(b1.cost_src_qty) cost_src_qty    
--                             ,SUM(b1.cost_src_qty) cost_src_qty2     --[CHM-201006103-01]
                             ,SUM(b1.cost_usd_amt) AS cost_usd_amt    
                        FROM (    
                              SELECT CASE    
                                       WHEN(substr(a1.cost_act_grp_cd, 1, 2) = 'OD')   -- O/B Door    
                                          THEN  a1.n2nd_nod_cd    
                                       ELSE a1.n1st_nod_cd    
                                     END lnk_fm_nod_cd    
                                    ,CASE    
                                       WHEN(substr(a1.cost_act_grp_cd, 1, 2) = 'ID')   -- I/B Door    
                                          THEN CASE    
                                                 WHEN((  decode(a1.n1st_nod_cd, NULL, 0, 1)    
                                                       + decode(a1.n2nd_nod_cd, NULL, 0, 1)    
                                                       + decode(a1.n3rd_nod_cd, NULL, 0, 1)    
                                                       + decode(a1.n4th_nod_cd, NULL, 0, 1)    
                                                      ) = 4    
                                                     )    
                                                    THEN a1.n3rd_nod_cd    
                                                 WHEN((  decode(a1.n1st_nod_cd, NULL, 0, 1)    
                                                       + decode(a1.n2nd_nod_cd, NULL, 0, 1)    
                                                       + decode(a1.n3rd_nod_cd, NULL, 0, 1)    
                                                       + decode(a1.n4th_nod_cd, NULL, 0, 1)    
                                                      ) = 3    
                                                     )    
                                                    THEN a1.n2nd_nod_cd    
                                                 ELSE a1.n2nd_nod_cd    
                                              END    
                                       ELSE COALESCE(a1.n4th_nod_cd, a1.n3rd_nod_cd, a1.n2nd_nod_cd)    
                                     END lnk_to_nod_cd    
                                    ,a1.cntr_tpsz_cd    
                                    ,a1.coa_cost_src_cd    
                                    ,CASE     
                                       WHEN a1.inv_cxl_flg = 'N'    
                                         THEN     
                                           CASE WHEN a1.locl_cost_amt >= 0    
                                                  THEN 1    
                                                ELSE 0    
                                           END    
                                         ELSE -1    
                                     END AS cost_src_qty    
                                    -- INVOICE CANCEL 시 2개의 ROW가 존재 금액은 마이너스 금액이 있어서 0이되지만 QYT는 -1처리 필요    
                                    -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.    
--                                    ,coa_conv_curr_usd_fnc( a1.locl_curr_cd    
--                                                            ,NVL(    
--                                                                  CASE     
--                                                                     WHEN a1.inv_cxl_flg = 'N' AND a1.locl_cost_amt < 0    
--                                                                       THEN 0    
--                                                                     ELSE   a1.locl_cost_amt    
--                                                                    END    
--                                                             ,0 )                                                    
--                                                              ,substr(a1.gl_dt, 1, 6)    
--                                                            ) AS cost_usd_amt       
                                    -- (-)Invoice 단가에 대해서 제외하던부분을     
                                    -- (+,-) 여부가 아니라 해당 구간의 대상금액의 합계가 (-)경우 단가에서 제외시킨다.    
                                    ,coa_conv_curr_usd_fnc( a1.locl_curr_cd    
                                                           ,NVL(a1.locl_cost_amt, 0)                                                    
                                                           ,substr(a1.gl_dt, 1, 6)    
                                                            ) AS cost_usd_amt                                                              
                                                                                                                       
                                FROM COA_TRSP_ACT_COST_IF a1, coa_cost_src_acct a2    
                                    ,(SELECT DISTINCT vsl_cd    
                                            ,skd_voy_no    
                                            ,skd_dir_cd    
                                            ,rev_dir_cd    
                                        FROM gl_estm_rev_vvd    
                                       WHERE estm_bc_div_cd IN ('C', 'M')    
--                                         AND rev_yrmon      BETWEEN v_cost_yrmon_prev2 AND v_cost_yrmon_prev0      
                                         AND rev_yrmon      BETWEEN in_cost_yrmon_src_fm AND in_cost_yrmon_src_to      
                                    	 AND exe_yrmon      >= in_rev_vvd_exe_yrmon --2010.10.12 이윤정 [CHM-201006549-01] 조건을 대상기간의 마지막월 전월 보다 큰 경우로 변경
                                         AND estm_vvd_tp_cd IN  ('RV','BV')    
                                         AND vsl_cd         <> 'CNTC' -- 공통항차는 제외    
                                     ) a3    
                               WHERE a1.coa_cost_src_cd = a2.coa_cost_src_cd    
                                 AND a1.inv_sys_id      = 'TRS'   -- TES, TRS    
                                 AND a1.cntr_tpsz_cd    IS NOT NULL    
--                                 AND a1.locl_cost_amt   > 0    
                                 -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.    
                                 AND a2.full_mty_cd     = 'F'   -- M:MTY, F:FULL    
                                 AND a1.otr_crr_flg     = 'N'   -- Y: 타선사 비용, N: 한진비용    
                                 AND a1.vsl_cd          = a3.vsl_cd    
                                 AND a1.skd_voy_no      = a3.skd_voy_no    
                                 AND a1.skd_dir_cd      = a3.skd_dir_cd    
                                 AND a1.rev_dir_cd      = a3.rev_dir_cd    
--                                 AND a1.coa_cost_src_cd NOT IN ('TRDRTD', 'TRLCRD')  
--                                 AND a1.coa_cost_src_cd NOT IN ('TRDRTD', 'TRLCRD', 'TRLSWD', 'TRLSRD', 'TRDRRD', 'TRDRWD')     
                                 AND a1.coa_cost_src_cd NOT IN ('TRLCRD', 'TRLSWD', 'TRLSRD', 'TRDRRD', 'TRDRWD') -- [CHM-201006103-01] 
                                 AND a1.coa_cost_src_cd NOT LIKE 'TROT%'    
                                     
                             ) b1    
                       GROUP BY b1.lnk_fm_nod_cd, b1.lnk_to_nod_cd, b1.cntr_tpsz_cd, b1.coa_cost_src_cd    
                      HAVING SUM(b1.cost_src_qty) <> 0     
                         AND SUM(b1.cost_src_qty) >=0  -- (+,-) 여부가 아니라 해당 구간의 대상금액의 합계가 (-)경우 단가에서 제외시킨다.    
                           
                      UNION ALL    
                          
                      -- coa_cost_src_cd = 'TRLCRD'  시작    
                      SELECT c1.lnk_fm_nod_cd    
                             ,c1.lnk_to_nod_cd    
                             ,c1.cntr_tpsz_cd    
                             ,c1.coa_cost_src_cd    
                             ,SUM(c1.cost_src_qty) AS cost_src_qty    
--                             ,SUM(c1.cost_src_qty) AS cost_src_qty2    -- [CHM-201006103-01] 
                             ,SUM(c1.cost_usd_amt) AS cost_usd_amt    
                        FROM (    
        						 SELECT  b1.lnk_fm_nod_cd    
        	                            ,b1.lnk_to_nod_cd    
        	                            ,b1.cntr_tpsz_cd    
        	                            ,b1.coa_cost_src_cd    
        	                            ,AVG (b1.cost_src_qty) AS cost_src_qty      
        	                            ,SUM (b1.cost_usd_amt) AS cost_usd_amt    
        	                            ,b1.cntr_no    
						           FROM (    
						                  SELECT  a1.lnk_fm_nod_cd    
                                                  ,a1.lnk_to_nod_cd    
                                                  ,a1.cntr_tpsz_cd    
                                                  ,a1.coa_cost_src_cd    
                                                  ,SUM (a1.cost_src_qty) AS cost_src_qty      
                                                  -- INVOICE CANCEL 시 2개의 ROW가 존재 금액은 마이너스 금액이 있어서 0이되지만 QYT는 -1처리 필요    
                                                  -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.    
                                                  ,SUM (a1.cost_usd_amt) AS cost_usd_amt    
                                                  ,a1.cntr_no    
                                                  ,a1.inv_no    
					                        FROM (      
                                                       SELECT CASE    
                                                               WHEN(substr(a1.cost_act_grp_cd, 1, 2) = 'OD')   -- O/B Door    
                                                                  THEN  a1.n2nd_nod_cd    
                                                               ELSE a1.n1st_nod_cd    
                                                             END lnk_fm_nod_cd    
                                                            ,CASE    
                                                               WHEN(substr(a1.cost_act_grp_cd, 1, 2) = 'ID')   -- I/B Door    
                                                                  THEN CASE    
                                                                         WHEN((  decode(a1.n1st_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n2nd_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n3rd_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n4th_nod_cd, NULL, 0, 1)    
                                                                              ) = 4    
                                                                             )    
                                                                            THEN a1.n3rd_nod_cd    
                                                                         WHEN((  decode(a1.n1st_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n2nd_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n3rd_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n4th_nod_cd, NULL, 0, 1)    
                                                                              ) = 3    
                                                                             )    
                                                                            THEN a1.n2nd_nod_cd    
                                                                         ELSE a1.n2nd_nod_cd    
                                                                      END    
                                                               ELSE COALESCE(a1.n4th_nod_cd, a1.n3rd_nod_cd, a1.n2nd_nod_cd)    
                                                             END lnk_to_nod_cd    
                                                            ,a1.cntr_tpsz_cd    
                                                            ,a1.coa_cost_src_cd    
                                                            ,CASE     
                                                               WHEN a1.inv_cxl_flg = 'N'    
                                                                 THEN     
                                                                   CASE WHEN a1.locl_cost_amt >= 0    
                                                                          THEN 1    
                                                                        ELSE 0    
                                                                   END    
                                                                 ELSE -1    
                                                             END AS cost_src_qty      
                                                            -- INVOICE CANCEL 시 2개의 ROW가 존재 금액은 마이너스 금액이 있어서 0이되지만 QYT는 -1처리 필요    
                                                            -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.    
--                                                            ,coa_conv_curr_usd_fnc( a1.locl_curr_cd    
--                                                                                     ,NVL(    
--                                                                                           CASE     
--                                                                                             WHEN a1.inv_cxl_flg = 'N' AND a1.locl_cost_amt < 0    
--                                                                                               THEN 0    
--                                                                                             ELSE   a1.locl_cost_amt    
--                                                                                            END    
--                                                                                      ,0 )                                                    
--                                                                                      ,substr(a1.gl_dt, 1, 6)    
--                                                                                    ) AS cost_usd_amt    
                                                            -- (-)Invoice 단가에 대해서 제외하던부분을     
                                                            -- (+,-) 여부가 아니라 해당 구간의 대상금액의 합계가 (-)경우 단가에서 제외시킨다.    
                                                            ,coa_conv_curr_usd_fnc( a1.locl_curr_cd    
                                                                                   ,NVL(a1.locl_cost_amt, 0)                                                    
                                                                                   ,substr(a1.gl_dt, 1, 6)    
                                                                                    ) AS cost_usd_amt                                                              
                                                                                        
                                                            ,a1.cntr_no    
                                                            ,a1.inv_no					                        			    
                        
                                            		  FROM	    
                        	                        		COA_TRSP_ACT_COST_IF a1, coa_cost_src_acct a2    
                        			                        ,(SELECT DISTINCT vsl_cd    
                        			                                    ,skd_voy_no    
                        			                                    ,skd_dir_cd    
                        			                                    ,rev_dir_cd    
                        			                                FROM gl_estm_rev_vvd    
                        			                               WHERE estm_bc_div_cd IN ('C', 'M')    
--                        			                                 AND rev_yrmon      BETWEEN v_cost_yrmon_prev2 AND v_cost_yrmon_prev0      
                        			                                 AND rev_yrmon      BETWEEN in_cost_yrmon_src_fm AND in_cost_yrmon_src_to      
                        			                                 AND exe_yrmon      >= in_rev_vvd_exe_yrmon  --2010.10.12 이윤정 [CHM-201006549-01] 조건을 대상기간의 마지막월 전월 보다 큰 경우로 변경
                        			                                 AND estm_vvd_tp_cd IN  ('RV','BV')    
                        			                                 AND vsl_cd         <> 'CNTC' -- 공통항차는 제외    
                        			                         ) a3    
                    			                  WHERE a1.coa_cost_src_cd = a2.coa_cost_src_cd    
                    		                        AND a1.inv_sys_id      = 'TRS'   -- TES, TRS    
                    		                        AND a1.cntr_tpsz_cd    IS NOT NULL    
--                    		                        AND a1.locl_cost_amt   > 0    
                    		                        -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.    
                    		                        AND a2.full_mty_cd     = 'F'   -- M:MTY, F:FULL    
                    		                        AND a1.otr_crr_flg     = 'N'   -- Y: 타선사 비용, N: 한진비용    
                    		                        AND a1.vsl_cd          = a3.vsl_cd    
                    		                        AND a1.skd_voy_no      = a3.skd_voy_no    
                    		                        AND a1.skd_dir_cd      = a3.skd_dir_cd    
                    		                        AND a1.rev_dir_cd      = a3.rev_dir_cd    
                    		                        AND a1.coa_cost_src_cd = 'TRLCRD'    
						                         ) a1    
						       	            GROUP BY a1.cntr_no, a1.inv_no, a1.lnk_fm_nod_cd, a1.lnk_to_nod_cd, a1.cntr_tpsz_cd, a1.coa_cost_src_cd    
        								) b1    
        					       GROUP BY b1.cntr_no, b1.lnk_fm_nod_cd, b1.lnk_to_nod_cd, b1.cntr_tpsz_cd, b1.coa_cost_src_cd    
         					) c1    
         		       GROUP BY c1.lnk_fm_nod_cd, c1.lnk_to_nod_cd, c1.cntr_tpsz_cd, c1.coa_cost_src_cd    
                      HAVING SUM(c1.cost_src_qty) <> 0    
                         AND SUM(c1.cost_usd_amt) >= 0 -- (+,-) 여부가 아니라 해당 구간의 대상금액의 합계가 (-)경우 단가에서 제외시킨다.    
                  )    
              )                  
               SELECT to_char(add_months(to_date(in_cost_yrmon_dest, 'yyyymm'), 1),'YYYYMM') cost_yrmon    
                     ,f1.lnk_fm_nod_cd    
                     ,f1.lnk_to_nod_cd    
                     ,coa_ut_tpsz_fnc(NULL, f1.cntr_tpsz_cd) cntr_tpsz_cd   -- SPCL FLG 인것은 모두 SP 로 바꾼다.    
                     ,'C' co_cd  --Company   
                     ,'N' cost_loc_grp_cd   -- NODE    
                     ,'F' full_mty_cd   -- FULL    
                     ,'A' cost_ass_bse_cd   -- AVG    
                     ,'USD' locl_curr_cd    
                     ,f1.coa_cost_src_cd    
                     ,SUM(f1.cost_usd_amt) / SUM(f1.uom_qty) stnd_cost_usd_amt    
                     ,SUM(f1.cost_usd_amt) lnk_ttl_amt    
                     ,SUM(f1.uom_qty) lnk_ttl_qty    
                     ,MAX(f1.cost_vol_cd) cost_vol_cd    
                 FROM (SELECT c1.lnk_fm_nod_cd    
                             ,c1.lnk_to_nod_cd    
                             ,c1.cntr_tpsz_cd    
                             ,c1.cost_usd_amt    
                             ,c1.coa_cost_src_cd    
                             ,c2.cost_src_qty    
                             ,c1.uom_1_cd    
                             ,c3.uom_1_qty    
                             ,c1.uom_2_cd    
                             ,c4.uom_2_qty    
                             ,c5.cop_full_qty                                 
                             ,CASE    
                                 WHEN(c3.uom_1_qty IS NOT NULL)    
                                    THEN c1.uom_1_cd    
                                 WHEN(c4.uom_2_qty IS NOT NULL)    
                                    THEN c1.uom_2_cd    
                                 ELSE 'COP_FULL'    
                              END cost_vol_cd    
                             ,CASE    
                                 WHEN(c3.uom_1_qty IS NOT NULL)    
                                    THEN uom_1_qty    
                                 WHEN(c4.uom_2_qty IS NOT NULL)    
                                    THEN uom_2_qty    
                                 ELSE cop_full_qty    
                              END uom_qty    
                         FROM (    
                               -- COST AMT    
                               SELECT a1.lnk_fm_nod_cd    
                                     ,a1.lnk_to_nod_cd    
--                                     ,a1.cntr_tpsz_cd AS cntr_tpsz_cd_org    
                                     ,a1.coa_cost_src_cd    
                                     ,a2.cost_ut_amt_cd    
                                     ,CASE a2.cost_ut_amt_cd                                                      
                                        WHEN 'SZ' THEN DECODE(SUBSTR(a1.cntr_tpsz_cd, -1), '2', '20', '40')    
                                        WHEN 'BOX' THEN 'BOX'    
                                        ELSE a1.cntr_tpsz_cd  -- TPSZ    
                                      END AS cntr_tpsz_cd    
                                     ,a2.cost_vol_cd AS uom_1_cd    
                                     ,a2.cost_vol_cd1 AS uom_2_cd    
                                     ,SUM(a1.cost_usd_amt) AS cost_usd_amt    
                                 FROM uom_qty a1, coa_cost_src_acct a2    
                                WHERE a1.coa_cost_src_cd = a2.coa_cost_src_cd    
                                GROUP BY a1.lnk_fm_nod_cd    
                                     ,a1.lnk_to_nod_cd    
                                     ,a1.coa_cost_src_cd    
                                     ,a2.cost_ut_amt_cd    
                                     ,CASE a2.cost_ut_amt_cd                                                      
                                        WHEN 'SZ' THEN DECODE(SUBSTR(a1.cntr_tpsz_cd, -1), '2', '20', '40')    
                                        WHEN 'BOX' THEN 'BOX'    
                                        ELSE a1.cntr_tpsz_cd  -- TPSZ    
                                      END    
                                     ,a2.cost_vol_cd    
                                     ,a2.cost_vol_cd1) c1    
                                         
                               -- COST SRC QTY 데이터 확인 위해 넣음    
                               -- TR FULL일 경우만 TPS,SZ,BOX별로 물량 산정. 예를 들어 'BOX'이면 전체 tpsz를 box로 변환하여 물량을 구함.    
                         ,      (-- TPSZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,cost_src_qty    
                                   FROM uom_qty    
                                 -- SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS cost_src_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                       ,coa_cost_src_cd    
                                  UNION ALL    
                                 -- BOX    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS cost_src_qty    
                                   FROM uom_qty    
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,coa_cost_src_cd    
                                  UNION ALL    
                                 -- TR_FULL. TPSZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS cost_src_qty                                        
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd, cost_src_qty    
                                  UNION ALL    
                                 -- TR_FULL. SZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS cost_src_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                  UNION ALL    
                                 -- TR_FULL. BOX    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS cost_src_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd) c2    
                               -- UOM 1 QTY    
                         ,      (-- TPSZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,cost_src_qty AS uom_1_qty    
                                   FROM uom_qty    
                                 -- SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_1_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                       ,coa_cost_src_cd    
                                 -- BOX    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_1_qty    
                                   FROM uom_qty    
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,coa_cost_src_cd    
                                 -- TR_FULL. TPSZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_1_qty                                        
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd, cost_src_qty    
                                 -- TR_FULL. SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_1_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                 -- TR_FULL. BOX    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_1_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd) c3    
                               -- UOM 2 QTY    
                         ,      (-- TPSZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,cost_src_qty AS uom_2_qty    
                                   FROM uom_qty    
                                 -- SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_2_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                       ,coa_cost_src_cd    
                                 -- BOX    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_2_qty    
                                   FROM uom_qty    
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,coa_cost_src_cd    
                                 -- TR_FULL. TPSZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_2_qty                                        
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd, cost_src_qty    
                                 -- TR_FULL. SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_2_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                 -- TR_FULL. BOX    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_2_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd) c4    
                             -- COP FULL QTY    
                       ,        (-- TPSZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,SUM(cost_src_qty) AS cop_full_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd    
                                 -- SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,SUM(cost_src_qty) AS cop_full_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                 -- BOX    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,SUM(cost_src_qty) AS cop_full_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd ) c5    
                        WHERE c1.lnk_fm_nod_cd = c2.lnk_fm_nod_cd   -- C2    
                          AND c1.lnk_to_nod_cd = c2.lnk_to_nod_cd    
                          AND c1.cntr_tpsz_cd  = c2.cntr_tpsz_cd    
                          AND c1.uom_1_cd      = c2.coa_cost_src_cd    
                          AND c1.lnk_fm_nod_cd = c3.lnk_fm_nod_cd(+)   -- C3    
                          AND c1.lnk_to_nod_cd = c3.lnk_to_nod_cd(+)    
                          AND c1.cntr_tpsz_cd  = c3.cntr_tpsz_cd(+)    
                          AND c1.uom_1_cd      = c3.coa_cost_src_cd(+)    
                          AND c1.lnk_fm_nod_cd = c4.lnk_fm_nod_cd(+)   -- C4    
                          AND c1.lnk_to_nod_cd = c4.lnk_to_nod_cd(+)    
                          AND c1.cntr_tpsz_cd  = c4.cntr_tpsz_cd(+)    
                          AND c1.uom_2_cd      = c4.coa_cost_src_cd(+)    
                          AND c1.lnk_fm_nod_cd = c5.lnk_fm_nod_cd(+)   -- C5    
                          AND c1.lnk_to_nod_cd = c5.lnk_to_nod_cd(+)    
                          AND c1.cntr_tpsz_cd  = c5.cntr_tpsz_cd(+)    
                          AND    decode(c3.uom_1_qty, NULL, 'X', 'O')    
                              || decode(c4.uom_2_qty, NULL, 'X', 'O')    
                              || decode(c5.cop_full_qty, NULL, 'X', 'O') <> 'XXX'    
                                                                                 -- QTY 1차, 2차, 3차 모두 없으면 단가생성에서 제외    
                      ) f1    
             WHERE f1.uom_qty > 0    
             GROUP BY f1.lnk_fm_nod_cd, f1.lnk_to_nod_cd, coa_ut_tpsz_fnc(NULL, f1.cntr_tpsz_cd), f1.coa_cost_src_cd) f2    
      ON (    f1.cost_yrmon      = f2.cost_yrmon    
          AND f1.lnk_fm_nod_cd   = f2.lnk_fm_nod_cd    
          AND f1.lnk_to_nod_cd   = f2.lnk_to_nod_cd    
          AND f1.cntr_tpsz_cd    = f2.cntr_tpsz_cd    
          AND f1.co_cd           = f2.co_cd    
          AND f1.full_mty_cd     = f2.full_mty_cd    
          AND f1.cost_loc_grp_cd = f2.cost_loc_grp_cd    
          AND f1.coa_cost_src_cd = f2.coa_cost_src_cd)    
      WHEN NOT MATCHED THEN    
         INSERT(f1.cost_yrmon, f1.full_mty_cd, f1.cntr_tpsz_cd, f1.co_cd, f1.cost_loc_grp_cd, f1.lnk_fm_nod_cd    
               ,f1.lnk_to_nod_cd, f1.coa_cost_src_cd, f1.locl_curr_cd, f1.stnd_cost_usd_amt, f1.cost_ass_bse_cd    
               ,f1.lnk_ttl_qty, f1.lnk_ttl_amt, f1.cost_vol_cd, f1.cre_usr_id, f1.cre_dt, f1.upd_usr_id, f1.upd_dt)    
         VALUES(f2.cost_yrmon, f2.full_mty_cd, f2.cntr_tpsz_cd, f2.co_cd, f2.cost_loc_grp_cd, f2.lnk_fm_nod_cd    
               ,f2.lnk_to_nod_cd, f2.coa_cost_src_cd, f2.locl_curr_cd, f2.stnd_cost_usd_amt, f2.cost_ass_bse_cd    
               ,f2.lnk_ttl_qty, f2.lnk_ttl_amt, f2.cost_vol_cd, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)    
      WHEN MATCHED THEN    
         UPDATE    
            SET f1.locl_curr_cd = f2.locl_curr_cd, f1.stnd_cost_usd_amt = f2.stnd_cost_usd_amt    
               ,f1.cost_ass_bse_cd = f2.cost_ass_bse_cd, f1.lnk_ttl_qty = f2.lnk_ttl_qty    
               ,f1.lnk_ttl_amt = f2.lnk_ttl_amt, f1.cost_vol_cd = f2.cost_vol_cd, f1.upd_usr_id = 'SYS_COA_UPD'    
               ,f1.upd_dt = sysdate    
          WHERE NVL(f1.cost_fx_flg,'N') <> 'Y'      -- Cost Fixed된것 Update하지 않음.    
            AND f1.locl_curr_cd         = 'USD'     -- Local Currency가 USD 인것만 변경하도록 함    
         ;    
         
    --v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'LINK FULL Merge:' || SQL%ROWCOUNT);   
             
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
-- Node 단가의 SCFUDT 보정 -- SCFUTD계정의 미주지역[US, CA, MX]의 경우 TYPE SIZE에 상관없이 평균단가를 적용한다.[20081128]    
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////       
   v_coa_step := 'NODE FULL Merge SCFUTD';    
   MERGE INTO coa_lnk_avg_stnd_cost x    
        USING (    
               SELECT cost_yrmon    
                     ,lnk_fm_nod_cd    
                     ,lnk_to_nod_cd    
                     ,co_cd    
                     ,cntr_tpsz_cd    
                     ,full_mty_cd    
                     ,coa_cost_src_cd    
                     ,cost_loc_grp_cd    
                     ,stnd_cost_usd_amt    
--                     ,lnk_ttl_qty    
--                     ,lnk_ttl_amt    
                     ,SUM(lnk_ttl_qty) OVER(PARTITION BY cost_yrmon, lnk_fm_nod_cd, lnk_to_nod_cd, co_cd, full_mty_cd, coa_cost_src_cd, cost_loc_grp_cd) AS lnk_ttl_qty    
                     ,SUM(lnk_ttl_amt) OVER(PARTITION BY cost_yrmon, lnk_fm_nod_cd, lnk_to_nod_cd, co_cd, full_mty_cd, coa_cost_src_cd, cost_loc_grp_cd) AS lnk_ttl_amt    
                 FROM coa_lnk_avg_stnd_cost    
                WHERE cost_yrmon      = to_char(add_months(to_date(in_cost_yrmon_dest, 'yyyymm'), 1),'YYYYMM')    
                  AND full_mty_cd     = 'F'    
                  AND coa_cost_src_cd = 'SCFUTD'    
                  AND cost_loc_grp_cd = 'N'    
                  AND (SUBSTR(lnk_fm_nod_cd,1,2) IN ('US','CA','MX') OR SUBSTR(lnk_to_nod_cd,1,2) IN ('US','CA','MX'))    
              ) y    
           ON (    
                   x.cost_yrmon      = y.cost_yrmon    
               AND x.lnk_fm_nod_cd   = y.lnk_fm_nod_cd    
               AND x.lnk_to_nod_cd   = y.lnk_to_nod_cd    
               AND x.co_cd           = y.co_cd    
               AND x.cntr_tpsz_cd    = y.cntr_tpsz_cd    
               AND x.full_mty_cd     = y.full_mty_cd    
               AND x.coa_cost_src_cd = y.coa_cost_src_cd    
               AND x.cost_loc_grp_cd = y.cost_loc_grp_cd    
              )    
   WHEN MATCHED THEN    
        UPDATE    
           SET x.stnd_cost_usd_amt = y.lnk_ttl_amt/y.lnk_ttl_qty    
              ,x.lnk_ttl_qty       = y.lnk_ttl_qty    
              ,x.lnk_ttl_amt       = y.lnk_ttl_amt    
         WHERE NVL(x.cost_fx_flg,'N') <> 'Y'    
    ;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'LINK FULL Merge SCFUTD:' || SQL%ROWCOUNT);    
   
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 미주 지역 (US~, CA~) TRDRTD, TRLCRD 계정은 다른 logic 으로 생성하기 때문에 생성한 계정 중
-- 미주지역 TRDRTD, TRLCRD 계정은 삭제해준다.
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   DELETE FROM coa_lnk_avg_stnd_cost
         WHERE cost_yrmon = to_char(add_months(to_date(in_cost_yrmon_dest, 'yyyymm'), 1),'YYYYMM')
           AND (lnk_fm_nod_cd like 'US%' or lnk_fm_nod_cd like 'CA%')
           AND (lnk_to_nod_cd like 'US%' or lnk_to_nod_cd like 'CA%')
           AND coa_cost_src_cd in ('TRDRTD', 'TRLCRD') ;    
           
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'US TRDRTD_TRLCRD Delete:' || SQL%ROWCOUNT); 
           
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 생성된 기본 UPD 단가를 Dest 단가에 Merge into
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////

   MERGE INTO coa_lnk_avg_stnd_cost e1
      USING (
             SELECT   in_cost_yrmon_dest cost_yrmon
                     ,a1.lnk_fm_nod_cd
                     ,a1.lnk_to_nod_cd--                    
                     ,a1.co_cd
                     ,a1.cntr_tpsz_cd
                     ,a1.full_mty_cd
                     ,a1.coa_cost_src_cd
                     ,a1.cost_loc_grp_cd
--                     ,'USD' locl_curr_cd
                     ,a1.locl_curr_cd
                     ,a1.cost_ass_bse_cd
                     ,a1.lnk_ttl_amt
                     ,a1.lnk_ttl_qty--                   
                     ,a1.stnd_cost_usd_amt
                     ,a1.cost_vol_cd
                 FROM coa_lnk_avg_stnd_cost a1
                WHERE a1.cost_yrmon             =  to_char(add_months(to_date(in_cost_yrmon_dest, 'yyyymm'), 1),'YYYYMM')
                  AND a1.cost_loc_grp_cd        = 'N'                 
                  AND a1.full_mty_cd            = 'F'             
              
            ) e2
      ON (    e1.cost_yrmon      = e2.cost_yrmon
          AND e1.lnk_fm_nod_cd   = e2.lnk_fm_nod_cd
          AND e1.lnk_to_nod_cd   = e2.lnk_to_nod_cd
          AND e1.co_cd           = e2.co_cd
          AND e1.cntr_tpsz_cd    = e2.cntr_tpsz_cd
          AND e1.full_mty_cd     = e2.full_mty_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'COA_CRE_'||in_cost_yrmon_dest, sysdate, 'COA_CRE_'||in_cost_yrmon_dest 
               , sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = e2.cost_vol_cd, e1.upd_usr_id = 'COA_UPD_'||in_cost_yrmon_dest
               ,e1.upd_dt = sysdate, e1.cost_calc_rmk = in_cost_yrmon_dest||'_EDIT'
       ;
       
     enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', '기본 생성단가 Merge' || SQL%ROWCOUNT);   
     
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////
---- TRLCRD 단가 생성
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////     
   
   -- 생성 기간은 한달로 최종 단가 생성 년월 +2개월 cost_yrmon 으로 단가가 생성된다.
   
   DELETE FROM coa_lnk_avg_stnd_Cost
         WHERE cost_yrmon = to_char(add_months(to_date(in_cost_yrmon_dest, 'yyyymm'), 2),'YYYYMM')
           AND full_mty_cd = 'F';
   
       
   MERGE INTO coa_lnk_avg_stnd_cost f1    
      USING (WITH uom_qty AS    
              (    
                SELECT lnk_fm_nod_cd    
                      ,lnk_to_nod_cd    
                      ,cntr_tpsz_cd    
                      ,coa_cost_src_cd    
                      --1. (-)Invoice 의 경우 (+,-) 여부가 아니라 해당 구간의 대상금액의 합계가 (-)경우 단가에서 제외시킨다.    
                      ,cost_src_qty   
--                       [CHM-201006103-01]
--                      ,CASE    
--                           WHEN (coa_cost_src_cd LIKE 'TR__TD' OR coa_cost_src_cd = 'SCFUTD') AND (SUBSTR(lnk_fm_nod_cd,1,2) IN ('US','CA','MX') OR SUBSTR(lnk_to_nod_cd,1,2) IN ('US','CA','MX'))    
--                             THEN SUM(cost_src_qty2) OVER (PARTITION BY lnk_fm_nod_cd, lnk_to_nod_cd, coa_cost_src_cd)    
--                           ELSE cost_src_qty2    
--                       END cost_src_qty2 -- TR_FULL시 사용할 Volume    
                      ,cost_usd_amt
                  FROM (                   
                      -- coa_cost_src_cd = 'TRLCRD'  시작    
                      SELECT c1.lnk_fm_nod_cd    
                             ,c1.lnk_to_nod_cd    
                             ,c1.cntr_tpsz_cd    
                             ,c1.coa_cost_src_cd    
                             ,SUM(c1.cost_src_qty) AS cost_src_qty    
--                             ,SUM(c1.cost_src_qty) AS cost_src_qty2  -- [CHM-201006103-01]    
                             ,SUM(c1.cost_usd_amt) AS cost_usd_amt    
                        FROM (    
        						 SELECT  b1.lnk_fm_nod_cd    
        	                            ,b1.lnk_to_nod_cd    
        	                            ,b1.cntr_tpsz_cd    
        	                            ,b1.coa_cost_src_cd    
        	                            ,AVG (b1.cost_src_qty) AS cost_src_qty      
        	                            ,SUM (b1.cost_usd_amt) AS cost_usd_amt    
        	                            ,b1.cntr_no    
						           FROM (    
						                  SELECT  a1.lnk_fm_nod_cd    
                                                  ,a1.lnk_to_nod_cd    
                                                  ,a1.cntr_tpsz_cd    
                                                  ,a1.coa_cost_src_cd    
                                                  ,SUM (a1.cost_src_qty) AS cost_src_qty      
                                                  -- INVOICE CANCEL 시 2개의 ROW가 존재 금액은 마이너스 금액이 있어서 0이되지만 QYT는 -1처리 필요    
                                                  -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.    
                                                  ,SUM (a1.cost_usd_amt) AS cost_usd_amt    
                                                  ,a1.cntr_no    
                                                  ,a1.inv_no    
					                        FROM (      
                                                       SELECT CASE    
                                                               WHEN(substr(a1.cost_act_grp_cd, 1, 2) = 'OD')   -- O/B Door    
                                                                  THEN  a1.n2nd_nod_cd    
                                                               ELSE a1.n1st_nod_cd    
                                                             END lnk_fm_nod_cd    
                                                            ,CASE    
                                                               WHEN(substr(a1.cost_act_grp_cd, 1, 2) = 'ID')   -- I/B Door    
                                                                  THEN CASE    
                                                                         WHEN((  decode(a1.n1st_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n2nd_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n3rd_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n4th_nod_cd, NULL, 0, 1)    
                                                                              ) = 4    
                                                                             )    
                                                                            THEN a1.n3rd_nod_cd    
                                                                         WHEN((  decode(a1.n1st_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n2nd_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n3rd_nod_cd, NULL, 0, 1)    
                                                                               + decode(a1.n4th_nod_cd, NULL, 0, 1)    
                                                                              ) = 3    
                                                                             )    
                                                                            THEN a1.n2nd_nod_cd    
                                                                         ELSE a1.n2nd_nod_cd    
                                                                      END    
                                                               ELSE COALESCE(a1.n4th_nod_cd, a1.n3rd_nod_cd, a1.n2nd_nod_cd)    
                                                             END lnk_to_nod_cd    
                                                            ,a1.cntr_tpsz_cd    
                                                            ,a1.coa_cost_src_cd    
                                                            ,CASE     
                                                               WHEN a1.inv_cxl_flg = 'N'    
                                                                 THEN     
                                                                   CASE WHEN a1.locl_cost_amt >= 0    
                                                                          THEN 1    
                                                                        ELSE 0    
                                                                   END    
                                                                 ELSE -1    
                                                             END AS cost_src_qty      
                                                            -- INVOICE CANCEL 시 2개의 ROW가 존재 금액은 마이너스 금액이 있어서 0이되지만 QYT는 -1처리 필요    
                                                            -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.    
--                                                            ,coa_conv_curr_usd_fnc( a1.locl_curr_cd    
--                                                                                     ,NVL(    
--                                                                                           CASE     
--                                                                                             WHEN a1.inv_cxl_flg = 'N' AND a1.locl_cost_amt < 0    
--                                                                                               THEN 0    
--                                                                                             ELSE   a1.locl_cost_amt    
--                                                                                            END    
--                                                                                      ,0 )                                                    
--                                                                                      ,substr(a1.gl_dt, 1, 6)    
--                                                                                    ) AS cost_usd_amt    
                                                            -- (-)Invoice 단가에 대해서 제외하던부분을     
                                                            -- (+,-) 여부가 아니라 해당 구간의 대상금액의 합계가 (-)경우 단가에서 제외시킨다.    
                                                            ,coa_conv_curr_usd_fnc( a1.locl_curr_cd    
                                                                                   ,NVL(a1.locl_cost_amt, 0)                                                    
                                                                                   ,substr(a1.gl_dt, 1, 6)    
                                                                                    ) AS cost_usd_amt                                                              
                                                                                        
                                                            ,a1.cntr_no    
                                                            ,a1.inv_no					                        			    
                        
                                            		  FROM	    
                        	                        		COA_TRSP_ACT_COST_IF a1, coa_cost_src_acct a2    
                        			                        ,(SELECT DISTINCT vsl_cd    
                        			                                    ,skd_voy_no    
                        			                                    ,skd_dir_cd    
                        			                                    ,rev_dir_cd    
                        			                                FROM gl_estm_rev_vvd    
                        			                               WHERE estm_bc_div_cd IN ('C', 'M')    
--                        			                                 AND rev_yrmon      BETWEEN v_cost_yrmon_prev2 AND v_cost_yrmon_prev2      
                        			                                 AND rev_yrmon      BETWEEN in_cost_yrmon_src_trlcrd AND in_cost_yrmon_src_trlcrd      
                        			                                 AND exe_yrmon      >= in_rev_vvd_exe_yrmon  --2010.10.12 이윤정 [CHM-201006549-01] 조건을 대상기간의 마지막월 전월 보다 큰 경우로 변경   
                        			                                 AND estm_vvd_tp_cd IN  ('RV','BV')    
                        			                                 AND vsl_cd         <> 'CNTC' -- 공통항차는 제외    
                        			                         ) a3    
                    			                  WHERE a1.coa_cost_src_cd = a2.coa_cost_src_cd    
                    		                        AND a1.inv_sys_id      = 'TRS'   -- TES, TRS    
                    		                        AND a1.cntr_tpsz_cd    IS NOT NULL    
--                    		                        AND a1.locl_cost_amt   > 0    
                    		                        -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.    
                    		                        AND a2.full_mty_cd     = 'F'   -- M:MTY, F:FULL    
                    		                        AND a1.otr_crr_flg     = 'N'   -- Y: 타선사 비용, N: 한진비용    
                    		                        AND a1.vsl_cd          = a3.vsl_cd    
                    		                        AND a1.skd_voy_no      = a3.skd_voy_no    
                    		                        AND a1.skd_dir_cd      = a3.skd_dir_cd    
                    		                        AND a1.rev_dir_cd      = a3.rev_dir_cd    
                    		                        AND a1.coa_cost_src_cd = 'TRLCRD'    
						                         ) a1    
						       	            GROUP BY a1.cntr_no, a1.inv_no, a1.lnk_fm_nod_cd, a1.lnk_to_nod_cd, a1.cntr_tpsz_cd, a1.coa_cost_src_cd    
        								) b1    
        					       GROUP BY b1.cntr_no, b1.lnk_fm_nod_cd, b1.lnk_to_nod_cd, b1.cntr_tpsz_cd, b1.coa_cost_src_cd    
         					) c1    
         		       GROUP BY c1.lnk_fm_nod_cd, c1.lnk_to_nod_cd, c1.cntr_tpsz_cd, c1.coa_cost_src_cd    
                      HAVING SUM(c1.cost_src_qty) <> 0    
                         AND SUM(c1.cost_usd_amt) >= 0 -- (+,-) 여부가 아니라 해당 구간의 대상금액의 합계가 (-)경우 단가에서 제외시킨다.    
                  )    
              )                  
               SELECT to_char(add_months(to_date(in_cost_yrmon_dest, 'yyyymm'), 2),'YYYYMM') cost_yrmon    
                     ,f1.lnk_fm_nod_cd    
                     ,f1.lnk_to_nod_cd    
                     ,coa_ut_tpsz_fnc(NULL, f1.cntr_tpsz_cd) cntr_tpsz_cd   -- SPCL FLG 인것은 모두 SP 로 바꾼다.    
                     ,'C' co_cd   -- Company    
                     ,'N' cost_loc_grp_cd   -- NODE    
                     ,'F' full_mty_cd   -- FULL    
                     ,'A' cost_ass_bse_cd   -- AVG    
                     ,'USD' locl_curr_cd    
                     ,f1.coa_cost_src_cd    
                     ,SUM(f1.cost_usd_amt) / SUM(f1.uom_qty) stnd_cost_usd_amt    
                     ,SUM(f1.cost_usd_amt) lnk_ttl_amt    
                     ,SUM(f1.uom_qty) lnk_ttl_qty    
                     ,MAX(f1.cost_vol_cd) cost_vol_cd    
                 FROM (SELECT c1.lnk_fm_nod_cd    
                             ,c1.lnk_to_nod_cd    
                             ,c1.cntr_tpsz_cd    
                             ,c1.cost_usd_amt    
                             ,c1.coa_cost_src_cd    
                             ,c2.cost_src_qty    
                             ,c1.uom_1_cd    
                             ,c3.uom_1_qty    
                             ,c1.uom_2_cd    
                             ,c4.uom_2_qty    
                             ,c5.cop_full_qty                                 
                             ,CASE    
                                 WHEN(c3.uom_1_qty IS NOT NULL)    
                                    THEN c1.uom_1_cd    
                                 WHEN(c4.uom_2_qty IS NOT NULL)    
                                    THEN c1.uom_2_cd    
                                 ELSE 'COP_FULL'    
                              END cost_vol_cd    
                             ,CASE    
                                 WHEN(c3.uom_1_qty IS NOT NULL)    
                                    THEN uom_1_qty    
                                 WHEN(c4.uom_2_qty IS NOT NULL)    
                                    THEN uom_2_qty    
                                 ELSE cop_full_qty    
                              END uom_qty    
                         FROM (    
                               -- COST AMT    
                               SELECT a1.lnk_fm_nod_cd    
                                     ,a1.lnk_to_nod_cd    
--                                     ,a1.cntr_tpsz_cd AS cntr_tpsz_cd_org    
                                     ,a1.coa_cost_src_cd    
                                     ,a2.cost_ut_amt_cd    
                                     ,CASE a2.cost_ut_amt_cd                                                      
                                        WHEN 'SZ' THEN DECODE(SUBSTR(a1.cntr_tpsz_cd, -1), '2', '20', '40')    
                                        WHEN 'BOX' THEN 'BOX'    
                                        ELSE a1.cntr_tpsz_cd  -- TPSZ    
                                      END AS cntr_tpsz_cd    
                                     ,a2.cost_vol_cd AS uom_1_cd    
                                     ,a2.cost_vol_cd1 AS uom_2_cd    
                                     ,SUM(a1.cost_usd_amt) AS cost_usd_amt    
                                 FROM uom_qty a1, coa_cost_src_acct a2    
                                WHERE a1.coa_cost_src_cd = a2.coa_cost_src_cd    
                                GROUP BY a1.lnk_fm_nod_cd    
                                     ,a1.lnk_to_nod_cd    
                                     ,a1.coa_cost_src_cd    
                                     ,a2.cost_ut_amt_cd    
                                     ,CASE a2.cost_ut_amt_cd                                                      
                                        WHEN 'SZ' THEN DECODE(SUBSTR(a1.cntr_tpsz_cd, -1), '2', '20', '40')    
                                        WHEN 'BOX' THEN 'BOX'    
                                        ELSE a1.cntr_tpsz_cd  -- TPSZ    
                                      END    
                                     ,a2.cost_vol_cd    
                                     ,a2.cost_vol_cd1) c1    
                                         
                               -- COST SRC QTY 데이터 확인 위해 넣음    
                               -- TR FULL일 경우만 TPS,SZ,BOX별로 물량 산정. 예를 들어 'BOX'이면 전체 tpsz를 box로 변환하여 물량을 구함.    
                         ,      (-- TPSZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,cost_src_qty    
                                   FROM uom_qty    
                                 -- SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS cost_src_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                       ,coa_cost_src_cd    
                                  UNION ALL    
                                 -- BOX    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS cost_src_qty    
                                   FROM uom_qty    
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,coa_cost_src_cd    
                                  UNION ALL    
                                 -- TR_FULL. TPSZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS cost_src_qty                                        
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd, cost_src_qty    
                                  UNION ALL    
                                 -- TR_FULL. SZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS cost_src_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                  UNION ALL    
                                 -- TR_FULL. BOX    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS cost_src_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd) c2    
                               -- UOM 1 QTY    
                         ,      (-- TPSZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,cost_src_qty AS uom_1_qty    
                                   FROM uom_qty    
                                 -- SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_1_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                       ,coa_cost_src_cd    
                                 -- BOX    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_1_qty    
                                   FROM uom_qty    
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,coa_cost_src_cd    
                                 -- TR_FULL. TPSZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_1_qty                                        
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd, cost_src_qty    
                                 -- TR_FULL. SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_1_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                 -- TR_FULL. BOX    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_1_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd) c3    
                               -- UOM 2 QTY    
                         ,      (-- TPSZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,cost_src_qty AS uom_2_qty    
                                   FROM uom_qty    
                                 -- SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_2_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                       ,coa_cost_src_cd    
                                 -- BOX    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_2_qty    
                                   FROM uom_qty    
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,coa_cost_src_cd    
                                 -- TR_FULL. TPSZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_2_qty                                        
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd, cost_src_qty    
                                 -- TR_FULL. SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_2_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                 -- TR_FULL. BOX    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,'TR_FULL' AS coa_cost_src_cd    
                                       ,SUM(cost_src_qty) AS uom_2_qty    
                                   FROM uom_qty    
                                  WHERE SUBSTR(coa_cost_src_cd, 1, 3) IN ('TRL', 'TRD', 'TRT', 'TRO')        
                                  GROUP BY  lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd) c4    
                             -- COP FULL QTY    
                       ,        (-- TPSZ    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,cntr_tpsz_cd    
                                       ,SUM(cost_src_qty) AS cop_full_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd, lnk_to_nod_cd, cntr_tpsz_cd    
                                 -- SZ    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40') AS cntr_tpsz_cd    
                                       ,SUM(cost_src_qty) AS cop_full_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', '20', '40')    
                                 -- BOX    
                                  UNION ALL    
                                 SELECT lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd    
                                       ,'BOX' AS cntr_tpsz_cd    
                                       ,SUM(cost_src_qty) AS cop_full_qty    
                                   FROM uom_qty    
                                  GROUP BY lnk_fm_nod_cd    
                                       ,lnk_to_nod_cd ) c5    
                        WHERE c1.lnk_fm_nod_cd = c2.lnk_fm_nod_cd   -- C2    
                          AND c1.lnk_to_nod_cd = c2.lnk_to_nod_cd    
                          AND c1.cntr_tpsz_cd  = c2.cntr_tpsz_cd    
                          AND c1.uom_1_cd      = c2.coa_cost_src_cd    
                          AND c1.lnk_fm_nod_cd = c3.lnk_fm_nod_cd(+)   -- C3    
                          AND c1.lnk_to_nod_cd = c3.lnk_to_nod_cd(+)    
                          AND c1.cntr_tpsz_cd  = c3.cntr_tpsz_cd(+)    
                          AND c1.uom_1_cd      = c3.coa_cost_src_cd(+)    
                          AND c1.lnk_fm_nod_cd = c4.lnk_fm_nod_cd(+)   -- C4    
                          AND c1.lnk_to_nod_cd = c4.lnk_to_nod_cd(+)    
                          AND c1.cntr_tpsz_cd  = c4.cntr_tpsz_cd(+)    
                          AND c1.uom_2_cd      = c4.coa_cost_src_cd(+)    
                          AND c1.lnk_fm_nod_cd = c5.lnk_fm_nod_cd(+)   -- C5    
                          AND c1.lnk_to_nod_cd = c5.lnk_to_nod_cd(+)    
                          AND c1.cntr_tpsz_cd  = c5.cntr_tpsz_cd(+)    
                          AND    decode(c3.uom_1_qty, NULL, 'X', 'O')    
                              || decode(c4.uom_2_qty, NULL, 'X', 'O')    
                              || decode(c5.cop_full_qty, NULL, 'X', 'O') <> 'XXX'    
                                                                                 -- QTY 1차, 2차, 3차 모두 없으면 단가생성에서 제외    
                      ) f1    
             WHERE f1.uom_qty > 0    
             GROUP BY f1.lnk_fm_nod_cd, f1.lnk_to_nod_cd, coa_ut_tpsz_fnc(NULL, f1.cntr_tpsz_cd), f1.coa_cost_src_cd) f2    
      ON (    f1.cost_yrmon      = f2.cost_yrmon    
          AND f1.lnk_fm_nod_cd   = f2.lnk_fm_nod_cd    
          AND f1.lnk_to_nod_cd   = f2.lnk_to_nod_cd    
          AND f1.cntr_tpsz_cd    = f2.cntr_tpsz_cd    
          AND f1.co_cd           = f2.co_cd    
          AND f1.full_mty_cd     = f2.full_mty_cd    
          AND f1.cost_loc_grp_cd = f2.cost_loc_grp_cd    
          AND f1.coa_cost_src_cd = f2.coa_cost_src_cd)    
      WHEN NOT MATCHED THEN    
         INSERT(f1.cost_yrmon, f1.full_mty_cd, f1.cntr_tpsz_cd, f1.co_cd, f1.cost_loc_grp_cd, f1.lnk_fm_nod_cd    
               ,f1.lnk_to_nod_cd, f1.coa_cost_src_cd, f1.locl_curr_cd, f1.stnd_cost_usd_amt, f1.cost_ass_bse_cd    
               ,f1.lnk_ttl_qty, f1.lnk_ttl_amt, f1.cost_vol_cd, f1.cre_usr_id, f1.cre_dt, f1.upd_usr_id, f1.upd_dt)    
         VALUES(f2.cost_yrmon, f2.full_mty_cd, f2.cntr_tpsz_cd, f2.co_cd, f2.cost_loc_grp_cd, f2.lnk_fm_nod_cd    
               ,f2.lnk_to_nod_cd, f2.coa_cost_src_cd, f2.locl_curr_cd, f2.stnd_cost_usd_amt, f2.cost_ass_bse_cd    
               ,f2.lnk_ttl_qty, f2.lnk_ttl_amt, f2.cost_vol_cd, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)    
      WHEN MATCHED THEN    
         UPDATE    
            SET f1.locl_curr_cd = f2.locl_curr_cd, f1.stnd_cost_usd_amt = f2.stnd_cost_usd_amt    
               ,f1.cost_ass_bse_cd = f2.cost_ass_bse_cd, f1.lnk_ttl_qty = f2.lnk_ttl_qty    
               ,f1.lnk_ttl_amt = f2.lnk_ttl_amt, f1.cost_vol_cd = f2.cost_vol_cd, f1.upd_usr_id = 'SYS_COA_UPD'    
               ,f1.upd_dt = sysdate    
          WHERE NVL(f1.cost_fx_flg,'N') <> 'Y'      -- Cost Fixed된것 Update하지 않음.    
            AND f1.locl_curr_cd         = 'USD'     -- Local Currency가 USD 인것만 변경하도록 함    
         ;      
         
     
           
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////
---- 생성된 단가 중 미주지역 TRLCRD 만 merge into
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////

   MERGE INTO coa_lnk_avg_stnd_cost e1
      USING (
             SELECT   in_cost_yrmon_dest cost_yrmon
                     ,a1.lnk_fm_nod_cd
                     ,a1.lnk_to_nod_cd--                    
                     ,a1.co_cd
                     ,a1.cntr_tpsz_cd
                     ,a1.full_mty_cd
                     ,a1.coa_cost_src_cd
                     ,a1.cost_loc_grp_cd
--                     ,'USD' locl_curr_cd
                     ,a1.locl_curr_cd
                     ,a1.cost_ass_bse_cd
                     ,a1.lnk_ttl_amt
                     ,a1.lnk_ttl_qty--                   
                     ,a1.stnd_cost_usd_amt
                     ,a1.cost_vol_cd
                 FROM coa_lnk_avg_stnd_cost a1
                WHERE a1.cost_yrmon             =  to_char(add_months(to_date(in_cost_yrmon_dest, 'yyyymm'), 2),'YYYYMM')
                  AND a1.cost_loc_grp_cd        = 'N'                 
                  AND a1.full_mty_cd            = 'F'    
                  AND (a1.lnk_fm_nod_cd like 'US%' or a1.lnk_fm_nod_cd like 'CA%')
                  AND (a1.lnk_to_nod_cd like 'US%' or a1.lnk_to_nod_cd like 'CA%')
                  AND a1.coa_cost_src_cd = 'TRLCRD'    
              
            ) e2
      ON (    e1.cost_yrmon      = e2.cost_yrmon
          AND e1.lnk_fm_nod_cd   = e2.lnk_fm_nod_cd
          AND e1.lnk_to_nod_cd   = e2.lnk_to_nod_cd
          AND e1.co_cd           = e2.co_cd
          AND e1.cntr_tpsz_cd    = e2.cntr_tpsz_cd
          AND e1.full_mty_cd     = e2.full_mty_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'COA_CRE_'||in_cost_yrmon_dest, sysdate, 'COA_CRE_'||in_cost_yrmon_dest 
               , sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = e2.cost_vol_cd, e1.upd_usr_id = 'COA_UPD_'||in_cost_yrmon_dest
               ,e1.upd_dt = sysdate, e1.cost_calc_rmk = in_cost_yrmon_dest||'_EDIT'
       ;           
       
     enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'TRLCRD Merge' || SQL%ROWCOUNT); 
       
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
---- TPSZ copy    (새로 생성된 단가만 다른 TPSZ 까지 복사)
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
   v_coa_step := 'TPSZ_COPY';    
   MERGE INTO coa_lnk_avg_stnd_cost e1    
      USING (   -- D7, R2, R7 타입사이즈     
                SELECT /*+ ordered */     
                       c1.cost_yrmon    
                      ,c1.lnk_fm_nod_cd    
                      ,c1.lnk_to_nod_cd    
                      ,c1.co_cd    
                      ,c1.tpzs AS cntr_tpsz_cd    
                      ,c1.full_mty_cd    
                      ,c1.coa_cost_src_cd    
                      ,c1.cost_loc_grp_cd    
                      ,c1.locl_curr_cd    
                      ,c1.stnd_cost_usd_amt    
                      ,c1.lnk_locl_rt_amt    
                      ,c1.lnk_usd_rt_amt    
                      ,c1.cost_ass_bse_cd    
                      ,c1.rout_tz_mod_cd    
                      ,c1.fm_eff_dt    
                      ,c1.to_eff_dt    
                      ,c1.lnk_ttl_qty    
                      ,c1.lnk_ttl_amt    
                      ,c1.cost_vol_cd    
                      ,'SYS_COA_TPSZ' AS cre_usr_id    
                      ,SYSDATE AS cre_dt    
                      ,'SYS_COA_TPSZ' AS upd_usr_id    
                      ,SYSDATE AS upd_dt    
                      ,'TPSZ Copy' AS cost_calc_rmk    
                      ,'N' AS cost_fx_flg    
                  FROM (    
                        SELECT  b.cntr_tpsz_cd as tpzs, a.*    
                          FROM (-- GROUP 별로 TPSZ의 MIN 값 한줄만 가져오기. 시작    
                                SELECT cost_yrmon    
                                      ,lnk_fm_nod_cd    
                                      ,lnk_to_nod_cd    
                                      ,co_cd    
                                      ,MIN(DECODE(cntr_tpsz_cd, 'D5',  1    
                                                              , 'D4',  2    
                                                              , 'D2',  3    
                                                              , 'R2',  4    
                                                              , 'R5',  5    
                                                              , 'F2',  6    
                                                              , 'F4',  7    
                                                              , 'F5' , 8    
                                                              , 'R4' , 9    
                                                              , 'R7' ,10    
                                                              , 'D7' ,11    
                                                              , 'O2' ,12    
                                                              , 'O4' ,13    
                                                              , 'T2' ,14    
                                                              , 'T4' ,15    
                                                              , 'SP2',16    
                                                              , 'SP4',17)) AS cntr_tpsz_cd2    
                                      ,'D7' as cntr_tpsz_cd    
                                      ,full_mty_cd    
                                      ,coa_cost_src_cd    
                                      ,cost_loc_grp_cd    
                                  FROM coa_lnk_avg_stnd_cost    
                                 WHERE cost_yrmon      = in_cost_yrmon_dest    
                                   AND full_mty_cd     = 'F'    
                                   AND cost_loc_grp_cd = 'N'    
                                   AND REGEXP_LIKE(cntr_tpsz_cd, '^[DRSOTF]')    
                                   AND cre_usr_id = 'COA_CRE_'||in_cost_yrmon_dest
                                 GROUP BY cost_yrmon    
                                         ,lnk_fm_nod_cd    
                                         ,lnk_to_nod_cd    
                                         ,co_cd    
                                         ,full_mty_cd    
                                         ,coa_cost_src_cd    
                                         ,cost_loc_grp_cd    
                                UNION ALL    
                                SELECT cost_yrmon    
                                      ,lnk_fm_nod_cd    
                                      ,lnk_to_nod_cd    
                                      ,co_cd    
                                      ,MIN(DECODE(cntr_tpsz_cd, 'R5' , 1    
                                                              , 'D5' , 2    
                                                              , 'D7' , 3    
                                                              , 'D4' , 4    
                                                              , 'D2' , 5    
                                                              , 'F2' , 6    
                                                              , 'F4' , 7    
                                                              , 'F5' , 8    
                                                              , 'R4' , 9    
                                                              , 'R7' ,10    
                                                              , 'R2' ,11    
                                                              , 'O2' ,12    
                                                              , 'O4' ,13    
                                                              , 'T2' ,14    
                                                              , 'T4' ,15    
                                                              , 'SP2',16    
                                                              , 'SP4',17))    
                                             AS cntr_tpsz_cd2    
                                      ,'R2' as cntr_tpsz_cd    
                                      ,full_mty_cd    
                                      ,coa_cost_src_cd    
                                      ,cost_loc_grp_cd    
                                  FROM coa_lnk_avg_stnd_cost    
                                 WHERE cost_yrmon      = in_cost_yrmon_dest    
                                   AND full_mty_cd     = 'F'    
                                   AND cost_loc_grp_cd = 'N'    
                                   AND REGEXP_LIKE(cntr_tpsz_cd, '^[DRSOTF]') 
                                   AND cre_usr_id = 'COA_CRE_'||in_cost_yrmon_dest   
                                 GROUP BY cost_yrmon    
                                         ,lnk_fm_nod_cd    
                                         ,lnk_to_nod_cd    
                                         ,co_cd    
                                         ,full_mty_cd    
                                         ,coa_cost_src_cd    
                                         ,cost_loc_grp_cd    
                                UNION ALL    
                                SELECT cost_yrmon    
                                      ,lnk_fm_nod_cd    
                                      ,lnk_to_nod_cd    
                                      ,co_cd    
                                      ,MIN(DECODE(cntr_tpsz_cd, 'R5' , 1    
                                                              , 'D5' , 2    
                                                              , 'D7' , 3    
                                                              , 'D4' , 4    
                                                              , 'R2' , 5    
                                                              , 'D2' , 6    
                                                              , 'F2' , 7    
                                                              , 'F4' , 8    
                                                              , 'F5' , 9    
                                                              , 'R4' ,10    
                                                              , 'R7' ,11    
                                                              , 'O2' ,12    
                                                              , 'O4' ,13    
                                                              , 'T2' ,14    
                                                              , 'T4' ,15    
                                                              , 'SP2',16    
                                                              , 'SP4',17))    
                                              AS cntr_tpsz_cd2    
                                      ,'R7' as cntr_tpsz_cd    
                                      ,full_mty_cd    
                                      ,coa_cost_src_cd    
                                      ,cost_loc_grp_cd    
                                  FROM coa_lnk_avg_stnd_cost    
                                 WHERE cost_yrmon      = in_cost_yrmon_dest    
                                   AND full_mty_cd     = 'F'    
                                   AND cost_loc_grp_cd = 'N'    
                                   AND REGEXP_LIKE(cntr_tpsz_cd, '^[DRSOTF]') 
                                   AND cre_usr_id = 'COA_CRE_'||in_cost_yrmon_dest   
                                 GROUP BY cost_yrmon    
                                         ,lnk_fm_nod_cd    
                                         ,lnk_to_nod_cd    
                                         ,co_cd    
                                         ,full_mty_cd    
                                         ,coa_cost_src_cd    
                                         ,cost_loc_grp_cd    
    
                               ) b    
                                -- GROUP 별로 TPSZ의 MIN 값 한줄만 가져오기. 끝    
                              ,coa_lnk_avg_stnd_cost a    
                          WHERE a.cost_yrmon   = b.cost_yrmon    
                           AND a.lnk_fm_nod_cd = b.lnk_fm_nod_cd    
                           AND a.lnk_to_nod_cd = b.lnk_to_nod_cd    
                           AND a.co_cd         = b.co_cd    
                           AND a.cntr_tpsz_cd  = CASE WHEN b.cntr_tpsz_cd = 'D7'    
                                                        THEN DECODE(b.cntr_tpsz_cd2, 1, 'D5'    
                                                                                   , 2, 'D4'    
                                                                                   , 3, 'D2'    
                                                                                   , 4, 'R2'    
                                                                                   , 5, 'R5'    
                                                                                   , 6, 'F2'    
                                                                                   , 7, 'F4'    
                                                                                   , 8, 'F5'    
                                                                                   , 9, 'R4'    
                                                                                   ,10, 'R7'    
                                                                                   ,11, 'D7'    
                                                                                   ,12, 'O2'    
                                                                                   ,13, 'O4'    
                                                                                   ,14, 'T2'    
                                                                                   ,15, 'T4'    
                                                                                   ,16, 'SP2'    
                                                                                   ,17, 'SP4')    
                                                      WHEN b.cntr_tpsz_cd = 'R2'    
                                                        THEN DECODE(b.cntr_tpsz_cd2, 1, 'R5'    
                                                                                   , 2, 'D5'    
                                                                                   , 3, 'D7'    
                                                                                   , 4, 'D4'    
                                                                                   , 5, 'D2'    
                                                                                   , 6, 'F2'    
                                                                                   , 7, 'F4'    
                                                                                   , 8, 'F5'    
                                                                                   , 9, 'R4'    
                                                                                   ,10, 'R7'    
                                                                                   ,11, 'R2'    
                                                                                   ,12, 'O2'    
                                                                                   ,13, 'O4'    
                                                                                   ,14, 'T2'    
                                                                                   ,15, 'T4'    
                                                                                   ,16, 'SP2'    
                                                                                   ,17, 'SP4')    
                                                      when b.cntr_tpsz_cd = 'R7'    
                                                        THEN DECODE(b.cntr_tpsz_cd2, 1, 'R5'    
                                                                                   , 2, 'D5'    
                                                                                   , 3, 'D7'    
                                                                                   , 4, 'D4'    
                                                                                   , 5, 'R2'    
                                                                                   , 6, 'D2'    
                                                                                   , 7, 'F2'    
                                                                                   , 8, 'F4'    
                                                                                   , 9, 'F5'    
                                                                                   ,10, 'R4'    
                                                                                   ,11, 'R7'    
                                                                                   ,12, 'O2'    
                                                                                   ,13, 'O4'    
                                                                                   ,14, 'T2'    
                                                                                   ,15, 'T4'    
                                                                                   ,16, 'SP2'    
                                                                                   ,17, 'SP4')    
                                                 END    
                           AND a.full_mty_cd     = b.full_mty_cd    
                           AND a.coa_cost_src_cd = b.coa_cost_src_cd    
                           AND a.cost_loc_grp_cd = b.cost_loc_grp_cd    
                       ) c1    
                    
                UNION ALL    
                -- D7, R2, R7 을 제외한 타입사이즈     
                SELECT /*+ ordered */     
                       c1.cost_yrmon    
                      ,c1.lnk_fm_nod_cd    
                      ,c1.lnk_to_nod_cd    
                      ,c1.co_cd    
                      ,c2.tpsz AS cntr_tpsz_cd    
                      ,c1.full_mty_cd    
                      ,c1.coa_cost_src_cd    
                      ,c1.cost_loc_grp_cd    
                      ,c1.locl_curr_cd    
                      ,c1.stnd_cost_usd_amt    
                      ,c1.lnk_locl_rt_amt    
                      ,c1.lnk_usd_rt_amt    
                      ,c1.cost_ass_bse_cd    
                      ,c1.rout_tz_mod_cd    
                      ,c1.fm_eff_dt    
                      ,c1.to_eff_dt    
                      ,c1.lnk_ttl_qty    
                      ,c1.lnk_ttl_amt    
                      ,c1.cost_vol_cd    
                      ,'SYS_COA_TPSZ' AS cre_usr_id    
                      ,SYSDATE AS cre_dt    
                      ,'SYS_COA_TPSZ' AS upd_usr_id    
                      ,SYSDATE AS upd_dt    
                      ,'TPSZ Copy' AS cost_calc_rmk    
                      ,'N' AS cost_fx_flg    
                  FROM (    
                        SELECT  a.*    
                          FROM (-- GROUP 별로 TPSZ의 MIN 값 한줄만 가져오기. 시작    
                                SELECT cost_yrmon    
                                      ,lnk_fm_nod_cd    
                                      ,lnk_to_nod_cd    
                                      ,co_cd    
                                      ,MIN(DECODE(cntr_tpsz_cd, 'D4' , 1    
                                                              , 'D2' , 2    
                                                              , 'D5' , 3    
                                                              , 'D7' , 4    
                                                              , 'R2' , 5    
                                                              , 'R5' , 6    
                                                              , 'F2' , 7    
                                                              , 'F4' , 8    
                                                              , 'F5' , 9    
                                                              , 'R4' ,10    
                                                              , 'R7' ,11    
                                                              , 'O2' ,12    
                                                              , 'O4' ,13    
                                                              , 'T2' ,14    
                                                              , 'T4' ,15    
                                                              , 'SP2',16    
                                                              , 'SP4',17))    
                                       AS cntr_tpsz_cd    
                                      ,full_mty_cd    
                                      ,coa_cost_src_cd    
                                      ,cost_loc_grp_cd    
                                  FROM coa_lnk_avg_stnd_cost    
                                 WHERE cost_yrmon      = in_cost_yrmon_dest    
                                   AND full_mty_cd     = 'F'    
                                   AND cost_loc_grp_cd = 'N'    
                                   AND REGEXP_LIKE(cntr_tpsz_cd, '^[DRSOTF]')    
                                   AND cntr_tpsz_cd    NOT IN ('D7','R2','R7')    
                                   AND cre_usr_id = 'COA_CRE_'||in_cost_yrmon_dest
                                 GROUP BY cost_yrmon    
                                         ,lnk_fm_nod_cd    
                                         ,lnk_to_nod_cd    
                                         ,co_cd    
                                         ,full_mty_cd    
                                         ,coa_cost_src_cd    
                                         ,cost_loc_grp_cd    
    
                               ) b    
                                -- GROUP 별로 TPSZ의 MIN 값 한줄만 가져오기. 끝    
                              ,coa_lnk_avg_stnd_cost a    
                          WHERE a.cost_yrmon   = b.cost_yrmon    
                           AND a.lnk_fm_nod_cd = b.lnk_fm_nod_cd    
                           AND a.lnk_to_nod_cd = b.lnk_to_nod_cd    
                           AND a.co_cd         = b.co_cd    
                           AND a.cntr_tpsz_cd  = DECODE(b.cntr_tpsz_cd, 1, 'D4'    
                                                                     , 2, 'D2'    
                                                                     , 3, 'D5'    
                                                                     , 4, 'D7'    
                                                                     , 5, 'R2'    
                                                                     , 6, 'R5'    
                                                                     , 7, 'F2'    
                                                                     , 8, 'F4'    
                                                                     , 9, 'F5'    
                                                                     ,10, 'R4'    
                                                                     ,11, 'R7'    
                                                                     ,12, 'O2'    
                                                                     ,13, 'O4'    
                                                                     ,14, 'T2'    
                                                                     ,15, 'T4'    
                                                                     ,16, 'SP2'    
                                                                     ,17, 'SP4')    
                           AND a.full_mty_cd     = b.full_mty_cd    
                           AND a.coa_cost_src_cd = b.coa_cost_src_cd    
                           AND a.cost_loc_grp_cd = b.cost_loc_grp_cd    
                       ) c1    
                      ,(    
                        SELECT 'D4' AS tpsz,  1 AS ord FROM dual UNION ALL    
                        SELECT 'D2' AS tpsz,  2 AS ord FROM dual UNION ALL    
                        SELECT 'D5' AS tpsz,  3 AS ord FROM dual UNION ALL    
                        SELECT 'R4' AS tpsz,  6 AS ord FROM dual UNION ALL    
                        SELECT 'R5' AS tpsz,  7 AS ord FROM dual UNION ALL    
                        SELECT 'F2' AS tpsz,  9 AS ord FROM dual UNION ALL    
                        SELECT 'F4' AS tpsz, 10 AS ord FROM dual UNION ALL    
                        SELECT 'F5' AS tpsz, 11 AS ord FROM dual UNION ALL    
                        SELECT 'O2' AS tpsz, 12 AS ord FROM dual UNION ALL    
                        SELECT 'O4' AS tpsz, 13 AS ord FROM dual UNION ALL    
                        SELECT 'T2' AS tpsz, 14 AS ord FROM dual UNION ALL    
                        SELECT 'T4' AS tpsz, 15 AS ord FROM dual UNION ALL    
                        SELECT 'SP2' AS tpsz,16 AS ord FROM dual UNION ALL    
                        SELECT 'SP4' AS tpsz,17 AS ord FROM dual     
--                        SELECT 'D7' AS tpsz,  4 AS ord FROM dual UNION ALL    
--                        SELECT 'R2' AS tpsz,  5 AS ord FROM dual UNION ALL    
--                        SELECT 'R7' AS tpsz,  8 AS ord FROM dual UNION ALL    
                           
                       ) c2     
                       ORDER BY cost_yrmon, lnk_fm_nod_cd, lnk_to_nod_cd, coa_cost_src_cd, cntr_tpsz_cd    
          
                       ) e2    
      ON (    e1.cost_yrmon      = e2.cost_yrmon    
          AND e1.lnk_fm_nod_cd   = e2.lnk_fm_nod_cd    
          AND e1.lnk_to_nod_cd   = e2.lnk_to_nod_cd    
          AND e1.co_cd           = e2.co_cd    
          AND e1.cntr_tpsz_cd    = e2.cntr_tpsz_cd    
          AND e1.full_mty_cd     = e2.full_mty_cd    
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd    
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)    
      WHEN NOT MATCHED THEN    
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd    
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt    
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id    
               ,e1.upd_dt, e1.cost_fx_flg, e1.cost_calc_rmk)    
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd    
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt    
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, e2.cost_vol_cd, e2.cre_usr_id, e2.cre_dt, e2.upd_usr_id    
               ,e2.upd_dt, e2.cost_fx_flg, e2.cost_calc_rmk)        
         ;    
   --v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'TPSZ_COPY:' || SQL%ROWCOUNT);    
    
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
---- SZ copy    (새로 생성된 단가만 다른 SZ 까지 복사)
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
   v_coa_step := 'SZ_COPY';    
   MERGE INTO coa_lnk_avg_stnd_cost e1    
      USING (   SELECT /*+ ordered */     
                       c1.cost_yrmon    
                      ,c1.lnk_fm_nod_cd    
                      ,c1.lnk_to_nod_cd    
                      ,c1.co_cd    
                      ,c2.tpsz AS cntr_tpsz_cd    
                      ,c1.full_mty_cd    
                      ,c1.coa_cost_src_cd    
                      ,c1.cost_loc_grp_cd    
                      ,c1.locl_curr_cd    
                      ,c1.stnd_cost_usd_amt    
                      ,c1.lnk_locl_rt_amt    
                      ,c1.lnk_usd_rt_amt    
                      ,c1.cost_ass_bse_cd    
                      ,c1.rout_tz_mod_cd    
                      ,c1.fm_eff_dt    
                      ,c1.to_eff_dt    
                      ,c1.lnk_ttl_qty    
                      ,c1.lnk_ttl_amt    
                      ,c1.cost_vol_cd    
                      ,'SYS_COA_SZ' AS cre_usr_id    
                      ,SYSDATE AS cre_dt    
                      ,'SYS_COA_SZ' AS upd_usr_id    
                      ,SYSDATE AS upd_dt    
                      ,'SZ Copy' AS cost_calc_rmk    
                      ,'N' AS cost_fx_flg    
                  FROM (SELECT  a.*    
                          FROM (-- GROUP 별로 SZ의 MIN 값 한줄만 가져오기. 시작    
                                SELECT cost_yrmon    
                                      ,lnk_fm_nod_cd    
                                      ,lnk_to_nod_cd    
                                      ,co_cd    
                                      ,MIN(DECODE(cntr_tpsz_cd, '20' , 1    
                                                              , '40' , 2)) as cntr_tpsz_cd    
                                      ,full_mty_cd    
                                      ,coa_cost_src_cd    
                                      ,cost_loc_grp_cd    
                                  FROM coa_lnk_avg_stnd_cost    
                                 WHERE cost_yrmon      = in_cost_yrmon_dest    
                                   AND full_mty_cd     = 'F'    
                                   AND cost_loc_grp_cd = 'N'    
                                   AND REGEXP_LIKE(cntr_tpsz_cd, '^[24]')    
                                   AND cre_usr_id = 'COA_CRE_'||in_cost_yrmon_dest
                                 GROUP BY cost_yrmon    
                                      ,lnk_fm_nod_cd    
                                      ,lnk_to_nod_cd    
                                      ,co_cd    
                                      ,full_mty_cd    
                                      ,coa_cost_src_cd    
                                      ,cost_loc_grp_cd) b    
                                -- GROUP 별로 SZ의 MIN 값 한줄만 가져오기. 끝    
                              ,coa_lnk_avg_stnd_cost a    
                          WHERE a.cost_yrmon = b.cost_yrmon    
                           AND a.lnk_fm_nod_cd = b.lnk_fm_nod_cd    
                           AND a.lnk_to_nod_cd = b.lnk_to_nod_cd    
                           AND a.co_cd         = b.co_cd    
                           AND a.cntr_tpsz_cd  = DECODE(b.cntr_tpsz_cd, 1, '20'    
                                                                      , 2, '40')    
                           AND a.full_mty_cd = b.full_mty_cd    
                           AND a.coa_cost_src_cd = b.coa_cost_src_cd    
                           AND a.cost_loc_grp_cd = b.cost_loc_grp_cd    
                       ) c1    
                      ,(    
                        select '20' as tpsz, 1 as ord from dual union all    
                        select '40' as tpsz, 2 as ord from dual     
                        ) c2     
              ) e2    
      ON (    e1.cost_yrmon = e2.cost_yrmon    
          AND e1.lnk_fm_nod_cd = e2.lnk_fm_nod_cd    
          AND e1.lnk_to_nod_cd = e2.lnk_to_nod_cd    
          AND e1.co_cd = e2.co_cd    
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd    
          AND e1.full_mty_cd = e2.full_mty_cd    
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd    
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)    
      WHEN NOT MATCHED THEN    
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd    
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt    
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id    
               ,e1.upd_dt, e1.cost_fx_flg, e1.cost_calc_rmk)    
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd    
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt    
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, e2.cost_vol_cd, e2.cre_usr_id, e2.cre_dt, e2.upd_usr_id    
               ,e2.upd_dt, e2.cost_fx_flg, e2.cost_calc_rmk)        
         ;    
   --v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'SZ_COPY:' || SQL%ROWCOUNT);    

----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
---- 미주지역 TRDRTD 단가 생성 (COA_LNK_STND_COST_FULL_TR_PRC 로 생성)
---- type/size 구분 없이 summary하여 단가 생성 후 다른 type/size로 복사
---- 생성년월 + 3개월 cost_yrmon 에 생성
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////  
   DELETE FROM coa_lnk_avg_stnd_cost
         WHERE cost_yrmon = to_char(add_months(to_date(in_cost_yrmon_dest, 'yyyymm'), 3))
           AND full_mty_cd = 'F';
              
    COA_LNK_STND_COST_FULL_TR_PRC ( 
                                   in_cost_yrmon_src_fm  
                                  ,in_cost_yrmon_src_to
                                  ,in_rev_vvd_exe_yrmon    
                                  ,to_char(add_months(to_date(in_cost_yrmon_dest, 'yyyymm'), 3),'YYYYMM') 
                                  ); 
   
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////
---- 생성된 단가 중 미주지역 TRDRTD 만 merge into
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////

   MERGE INTO coa_lnk_avg_stnd_cost e1
      USING (
             SELECT   in_cost_yrmon_dest cost_yrmon
                     ,a1.lnk_fm_nod_cd
                     ,a1.lnk_to_nod_cd--                    
                     ,a1.co_cd
                     ,a1.cntr_tpsz_cd
                     ,a1.full_mty_cd
                     ,a1.coa_cost_src_cd
                     ,a1.cost_loc_grp_cd
--                     ,'USD' locl_curr_cd
                     ,a1.locl_curr_cd
                     ,a1.cost_ass_bse_cd
                     ,a1.lnk_ttl_amt
                     ,a1.lnk_ttl_qty--                   
                     ,a1.stnd_cost_usd_amt
                     ,a1.cost_vol_cd
                 FROM coa_lnk_avg_stnd_cost a1
                WHERE a1.cost_yrmon             =  to_char(add_months(to_date(in_cost_yrmon_dest, 'yyyymm'), 3),'YYYYMM')
                  AND a1.cost_loc_grp_cd        = 'N'                 
                  AND a1.full_mty_cd            = 'F'    
                  AND (a1.lnk_fm_nod_cd like 'US%' or a1.lnk_fm_nod_cd like 'CA%')
                  AND (a1.lnk_to_nod_cd like 'US%' or a1.lnk_to_nod_cd like 'CA%')
                  AND a1.coa_cost_src_cd = 'TRDRTD'    
              
            ) e2
      ON (    e1.cost_yrmon      = e2.cost_yrmon
          AND e1.lnk_fm_nod_cd   = e2.lnk_fm_nod_cd
          AND e1.lnk_to_nod_cd   = e2.lnk_to_nod_cd
          AND e1.co_cd           = e2.co_cd
          AND e1.cntr_tpsz_cd    = e2.cntr_tpsz_cd
          AND e1.full_mty_cd     = e2.full_mty_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'CRE_'||in_cost_yrmon_dest || '_TRDRTD', sysdate, 'CRE_'||in_cost_yrmon_dest || '_TRDRTD'
               , sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = e2.cost_vol_cd, e1.upd_usr_id = 'UPD'||in_cost_yrmon_dest || '_TRDRTD'
               ,e1.upd_dt = sysdate, e1.cost_calc_rmk = in_cost_yrmon_dest||'_TRDRTD'
       ;       

   --v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'TRDRTD Merge: ' || SQL%ROWCOUNT);
   
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////
---- 생성 단가 중 (-)로 생성 된 단가 삭제
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////

   DELETE FROM coa_lnk_avg_stnd_cost
         WHERE cost_yrmon = in_cost_yrmon_dest
           AND STND_COST_USD_AMT < 0 ;
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', '- 단가 삭제: ' || SQL%ROWCOUNT);
   
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
---- Location 평균 단가 생성 (SCC 대신 Location 단가를 적용)
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
   v_coa_step := 'LOC';    
   MERGE INTO coa_lnk_avg_stnd_cost e1    
      USING (    
             SELECT   a1.cost_yrmon    
                     ,SUBSTR(a1.lnk_fm_nod_cd,1,5) AS lnk_fm_nod_cd    
                     ,SUBSTR(a1.lnk_to_nod_cd,1,5) AS lnk_to_nod_cd    
--                     ,NVL(coa_loc_fnc(a1.lnk_fm_nod_cd, 'SCC'), ' ') AS lnk_fm_nod_cd    
--                     ,NVL(coa_loc_fnc(a1.lnk_to_nod_cd, 'SCC'), ' ') AS lnk_to_nod_cd    
                     ,'H' co_cd    
                     ,a1.cntr_tpsz_cd    
                     ,a1.full_mty_cd    
                     ,a1.coa_cost_src_cd    
                     ,'C' cost_loc_grp_cd    
--                     ,'USD' locl_curr_cd    
                     ,a1.locl_curr_cd    
                     ,'A' cost_ass_bse_cd    
                     ,SUM(a1.lnk_ttl_amt) lnk_ttl_amt    
                     ,SUM(a1.lnk_ttl_qty) lnk_ttl_qty    
--                     ,SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty) stnd_cost_usd_amt    
                     ,DECODE(SUM(a1.lnk_ttl_qty), 0, 0, SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty)) stnd_cost_usd_amt    
                 FROM coa_lnk_avg_stnd_cost a1, coa_cost_src_acct a2    
                WHERE a1.cost_yrmon             = in_cost_yrmon_dest    
                  AND a1.cost_loc_grp_cd        = 'N'    
                  AND a2.coa_cost_src_cd        NOT LIKE '__OT__'    
--                  AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.    
                  AND a1.coa_cost_src_cd        = a2.coa_cost_src_cd    
                  AND a1.full_mty_cd            = 'F'              -- FULL    
                  AND a1.locl_curr_cd           = 'USD'   -- Local Currency 가 USD 인 데이터만 변경한다.    
             GROUP BY cost_yrmon    
                     ,a1.full_mty_cd    
                     ,cntr_tpsz_cd    
                     ,SUBSTR(a1.lnk_fm_nod_cd,1,5)    
                     ,SUBSTR(a1.lnk_to_nod_cd,1,5)    
                     ,a1.coa_cost_src_cd    
                     ,a1.locl_curr_cd               
            ) e2    
      ON (    e1.cost_yrmon      = e2.cost_yrmon    
          AND e1.lnk_fm_nod_cd   = e2.lnk_fm_nod_cd    
          AND e1.lnk_to_nod_cd   = e2.lnk_to_nod_cd    
          AND e1.co_cd           = e2.co_cd    
          AND e1.cntr_tpsz_cd    = e2.cntr_tpsz_cd    
          AND e1.full_mty_cd     = e2.full_mty_cd    
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd    
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)    
      WHEN NOT MATCHED THEN    
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd    
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt    
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id    
               ,e1.upd_dt)    
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd    
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt    
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'COA_CRE_'||in_cost_yrmon_dest, sysdate, 'COA_CRE_'||in_cost_yrmon_dest, sysdate)    
      WHEN MATCHED THEN    
         UPDATE    
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd    
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty    
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'COA_UPD_'||in_cost_yrmon_dest 
               ,e1.upd_dt = sysdate, e1.cost_calc_rmk = e1.cost_calc_rmk || in_cost_yrmon_dest || '_EDIT '
          WHERE NVL(e1.cost_fx_flg,'N') <> 'Y'      -- Cost Fixed된것 Update하지 않음.    
            AND e1.locl_curr_cd         = 'USD'     -- Local Currency 가 USD 인 데이터만 변경한다.    
         ;    
   --v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'LOC:' || SQL%ROWCOUNT);    
       
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
---- ECC    
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
   v_coa_step := 'ECC';    
   MERGE INTO coa_lnk_avg_stnd_cost e1    
      USING (SELECT   a1.cost_yrmon    
                     ,NVL(coa_loc_fnc(a1.lnk_fm_nod_cd, 'ECC'), ' ') AS lnk_fm_nod_cd    
                     ,NVL(coa_loc_fnc(a1.lnk_to_nod_cd, 'ECC'), ' ') AS lnk_to_nod_cd    
                     ,'H' co_cd    
                     ,a1.cntr_tpsz_cd    
                     ,a1.full_mty_cd    
                     ,a1.coa_cost_src_cd    
                     ,'E' cost_loc_grp_cd    
                     ,a1.locl_curr_cd    
                     ,'A' cost_ass_bse_cd    
                     ,SUM(a1.lnk_ttl_amt) lnk_ttl_amt    
                     ,SUM(a1.lnk_ttl_qty) lnk_ttl_qty    
                     --,SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty) stnd_cost_usd_amt    
                     ,DECODE(SUM(a1.lnk_ttl_qty), 0, 0, SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty)) stnd_cost_usd_amt    
                 FROM coa_lnk_avg_stnd_cost a1, coa_cost_src_acct a2    
                WHERE a1.cost_yrmon             = in_cost_yrmon_dest    
                  AND a1.cost_loc_grp_cd        = 'N'    
                  AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'     -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.    
                  AND a1.coa_cost_src_cd        = a2.coa_cost_src_cd    
                  AND a1.full_mty_cd            = 'F'     -- FULL    
                  AND a1.locl_curr_cd           = 'USD'   -- Local Currency 가 USD 인 데이터만 변경한다.    
             GROUP BY cost_yrmon    
                     ,a1.full_mty_cd    
                     ,cntr_tpsz_cd    
                     ,coa_loc_fnc(lnk_fm_nod_cd, 'ECC')    
                     ,coa_loc_fnc(lnk_to_nod_cd, 'ECC')    
                     ,a1.coa_cost_src_cd    
                     ,a1.locl_curr_cd    
          ) e2    
      ON (    e1.cost_yrmon      = e2.cost_yrmon    
          AND e1.lnk_fm_nod_cd   = e2.lnk_fm_nod_cd    
          AND e1.lnk_to_nod_cd   = e2.lnk_to_nod_cd    
          AND e1.co_cd           = e2.co_cd    
          AND e1.cntr_tpsz_cd    = e2.cntr_tpsz_cd    
          AND e1.full_mty_cd     = e2.full_mty_cd    
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd    
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)    
      WHEN NOT MATCHED THEN    
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd    
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt    
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id    
               ,e1.upd_dt)    
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd    
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt    
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'COA_CRE_'||in_cost_yrmon_dest , sysdate, 'COA_CRE_'||in_cost_yrmon_dest, sysdate)    
      WHEN MATCHED THEN    
         UPDATE    
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd    
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty    
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'COA_UPD_'||in_cost_yrmon_dest    
               ,e1.upd_dt = sysdate, e1.cost_calc_rmk = e1.cost_calc_rmk || in_cost_yrmon_dest || '_EDIT '    
          WHERE NVL(e1.cost_fx_flg,'N') <> 'Y'      -- Cost Fixed된것 Update하지 않음.    
            AND e1.locl_curr_cd         = 'USD'     -- Local Currency 가 USD 인 데이터만 변경한다.    
         ;    
   --v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'ECC:' || SQL%ROWCOUNT);    
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
---- LCC    
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
   v_coa_step := 'LCC';    
   MERGE INTO coa_lnk_avg_stnd_cost e1    
      USING (SELECT   a1.cost_yrmon    
                     ,NVL(coa_loc_fnc(a1.lnk_fm_nod_cd, 'LCC'), ' ') AS lnk_fm_nod_cd    
                     ,NVL(coa_loc_fnc(a1.lnk_to_nod_cd, 'LCC'), ' ') AS lnk_to_nod_cd    
                     ,'H' co_cd    
                     ,a1.cntr_tpsz_cd    
                     ,a1.full_mty_cd    
                     ,a1.coa_cost_src_cd    
                     ,'L' cost_loc_grp_cd    
                     ,a1.locl_curr_cd    
                     ,'A' cost_ass_bse_cd    
                     ,SUM(a1.lnk_ttl_amt) lnk_ttl_amt    
                     ,SUM(a1.lnk_ttl_qty) lnk_ttl_qty    
                     --,SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty) stnd_cost_usd_amt    
                     ,DECODE(SUM(a1.lnk_ttl_qty), 0, 0, SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty)) stnd_cost_usd_amt    
                 FROM coa_lnk_avg_stnd_cost a1, coa_cost_src_acct a2    
                WHERE a1.cost_yrmon = in_cost_yrmon_dest    
                  AND a1.cost_loc_grp_cd = 'N'    
                  AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.    
                  AND a1.coa_cost_src_cd = a2.coa_cost_src_cd    
                  AND a1.full_mty_cd = 'F'              -- FULL    
                  AND a1.locl_curr_cd = 'USD'   -- Local Currency 가 USD 인 데이터만 변경한다.    
             GROUP BY cost_yrmon    
                     ,a1.full_mty_cd    
                     ,cntr_tpsz_cd    
                     ,coa_loc_fnc(lnk_fm_nod_cd, 'LCC')    
                     ,coa_loc_fnc(lnk_to_nod_cd, 'LCC')    
                     ,a1.coa_cost_src_cd    
                     ,a1.locl_curr_cd    
             ) e2    
      ON (    e1.cost_yrmon = e2.cost_yrmon    
          AND e1.lnk_fm_nod_cd = e2.lnk_fm_nod_cd    
          AND e1.lnk_to_nod_cd = e2.lnk_to_nod_cd    
          AND e1.co_cd = e2.co_cd    
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd    
          AND e1.full_mty_cd = e2.full_mty_cd    
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd    
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)    
      WHEN NOT MATCHED THEN    
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd    
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt    
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id    
               ,e1.upd_dt)    
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd    
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt    
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'COA_CRE_'||in_cost_yrmon_dest, sysdate, 'COA_CRE_'||in_cost_yrmon_dest, sysdate)    
      WHEN MATCHED THEN    
         UPDATE    
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd    
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty    
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'COA_UPD_'||in_cost_yrmon_dest    
               ,e1.upd_dt = sysdate, e1.cost_calc_rmk = e1.cost_calc_rmk|| in_cost_yrmon_dest || '_EDIT '  
          WHERE NVL(e1.cost_fx_flg,'N') <> 'Y'      -- Cost Fixed된것 Update하지 않음.    
            AND e1.locl_curr_cd         = 'USD'     -- Local Currency 가 USD 인 데이터만 변경한다.    
         ;    
   --v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'LCC:' || SQL%ROWCOUNT);    
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
---- RCC    
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
   v_coa_step := 'RCC';    
   MERGE INTO coa_lnk_avg_stnd_cost e1    
      USING (SELECT   a1.cost_yrmon    
                     ,NVL(coa_loc_fnc(a1.lnk_fm_nod_cd, 'RCC'), ' ') AS lnk_fm_nod_cd    
                     ,NVL(coa_loc_fnc(a1.lnk_to_nod_cd, 'RCC'), ' ') AS lnk_to_nod_cd    
                     ,'H' co_cd    
                     ,a1.cntr_tpsz_cd    
                     ,a1.full_mty_cd    
                     ,a1.coa_cost_src_cd    
                     ,'R' cost_loc_grp_cd    
                     ,a1.locl_curr_cd    
                     ,'A' cost_ass_bse_cd    
                     ,SUM(a1.lnk_ttl_amt) lnk_ttl_amt    
                     ,SUM(a1.lnk_ttl_qty) lnk_ttl_qty    
                     --,SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty) stnd_cost_usd_amt    
                     ,DECODE(SUM(a1.lnk_ttl_qty), 0, 0, SUM(a1.lnk_ttl_amt) / SUM(a1.lnk_ttl_qty)) stnd_cost_usd_amt    
                 FROM coa_lnk_avg_stnd_cost a1, coa_cost_src_acct a2    
                WHERE a1.cost_yrmon             = in_cost_yrmon_dest    
                  AND a1.cost_loc_grp_cd        = 'N'    
                  AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.    
                  AND a1.coa_cost_src_cd        = a2.coa_cost_src_cd    
                  AND a1.full_mty_cd            = 'F'              -- FULL    
                  AND a1.locl_curr_cd           = 'USD'   -- Local Currency 가 USD 인 데이터만 변경한다.    
             GROUP BY cost_yrmon    
                     ,a1.full_mty_cd    
                     ,cntr_tpsz_cd    
                     ,coa_loc_fnc(lnk_fm_nod_cd, 'RCC')    
                     ,coa_loc_fnc(lnk_to_nod_cd, 'RCC')    
                     ,a1.coa_cost_src_cd    
                     ,a1.locl_curr_cd    
            ) e2    
      ON (    e1.cost_yrmon      = e2.cost_yrmon    
          AND e1.lnk_fm_nod_cd   = e2.lnk_fm_nod_cd    
          AND e1.lnk_to_nod_cd   = e2.lnk_to_nod_cd    
          AND e1.co_cd           = e2.co_cd    
          AND e1.cntr_tpsz_cd    = e2.cntr_tpsz_cd    
          AND e1.full_mty_cd     = e2.full_mty_cd    
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd    
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)    
      WHEN NOT MATCHED THEN    
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd    
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt    
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id    
               ,e1.upd_dt)    
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd    
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt    
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'COA_CRE_'||in_cost_yrmon_dest , sysdate, 'COA_CRE_'||in_cost_yrmon_dest , sysdate)    
      WHEN MATCHED THEN    
         UPDATE    
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd    
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty    
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = NULL, e1.upd_usr_id = 'COA_UPD_'||in_cost_yrmon_dest    
               ,e1.upd_dt = sysdate, e1.cost_calc_rmk = e1.cost_calc_rmk|| in_cost_yrmon_dest || '_EDIT '    
          WHERE NVL(e1.cost_fx_flg,'N') <> 'Y'      -- Cost Fixed된것 Update하지 않음.    
            AND e1.locl_curr_cd         = 'USD'   -- Local Currency 가 USD 인 데이터만 변경한다.    
         ;    
   --v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'RCC:' || SQL%ROWCOUNT); 
   
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////
---- 지난 달 FIXED 단가 최종 생성 단가에 merge into
----/////////////////////////////////////////////////////////////////////////////////////////////////////////////

   MERGE INTO coa_lnk_avg_stnd_cost e1
      USING (
             SELECT   in_cost_yrmon_dest cost_yrmon
                     ,a1.lnk_fm_nod_cd
                     ,a1.lnk_to_nod_cd--                    
                     ,a1.co_cd
                     ,a1.cntr_tpsz_cd
                     ,a1.full_mty_cd
                     ,a1.coa_cost_src_cd
                     ,a1.cost_loc_grp_cd
--                     ,'USD' locl_curr_cd
                     ,a1.locl_curr_cd
                     ,a1.cost_ass_bse_cd
                     ,a1.lnk_ttl_amt
                     ,a1.lnk_ttl_qty--                   
                     ,a1.stnd_cost_usd_amt
                     ,a1.cost_vol_cd
                 FROM coa_lnk_avg_stnd_cost a1
                WHERE a1.cost_yrmon             =  in_cost_yrmon_copy_src                              
                  AND a1.full_mty_cd            = 'F'    
                  AND a1.cost_fx_flg = 'Y'  
              
            ) e2
      ON (    e1.cost_yrmon      = e2.cost_yrmon
          AND e1.lnk_fm_nod_cd   = e2.lnk_fm_nod_cd
          AND e1.lnk_to_nod_cd   = e2.lnk_to_nod_cd
          AND e1.co_cd           = e2.co_cd
          AND e1.cntr_tpsz_cd    = e2.cntr_tpsz_cd
          AND e1.full_mty_cd     = e2.full_mty_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.lnk_fm_nod_cd, e1.lnk_to_nod_cd, e1.co_cd, e1.cntr_tpsz_cd, e1.full_mty_cd
               ,e1.coa_cost_src_cd, e1.cost_loc_grp_cd, e1.locl_curr_cd, e1.cost_ass_bse_cd, e1.lnk_ttl_amt
               ,e1.lnk_ttl_qty, e1.stnd_cost_usd_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt, e1. cost_fx_flg)
         VALUES(e2.cost_yrmon, e2.lnk_fm_nod_cd, e2.lnk_to_nod_cd, e2.co_cd, e2.cntr_tpsz_cd, e2.full_mty_cd
               ,e2.coa_cost_src_cd, e2.cost_loc_grp_cd, e2.locl_curr_cd, e2.cost_ass_bse_cd, e2.lnk_ttl_amt
               ,e2.lnk_ttl_qty, e2.stnd_cost_usd_amt, NULL, 'COA_CRE_'||in_cost_yrmon_dest , sysdate, 'COA_CRE_'||in_cost_yrmon_dest
               , sysdate, 'Y' )
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.lnk_ttl_amt = e2.lnk_ttl_amt, e1.lnk_ttl_qty = e2.lnk_ttl_qty
               ,e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_vol_cd = e2.cost_vol_cd, e1.upd_usr_id = 'COA_UPD_'||in_cost_yrmon_dest
               ,e1.upd_dt = sysdate, e1.cost_calc_rmk = in_cost_yrmon_dest||'_FIXED', e1.cost_fx_flg = 'Y'
       ;       

   --v_prc_cnt := v_prc_cnt + SQL%ROWCOUNT;    
   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'Fixed 단가 UPD: ' || SQL%ROWCOUNT);
    
--   enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'V_PRC_CNT:' || to_char(v_prc_cnt, '999,999,999,999'));    
    
   enis_log_prc(sysdate    
               ,'COA_LNK_AVG_STND_COST_FULL_PRC'    
               , '소요시간:' || to_char(systimestamp - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff')    
               );    
EXCEPTION    
   WHEN OTHERS    
   THEN    
      enis_log_prc(sysdate, 'COA_LNK_AVG_STND_COST_FULL_PRC', 'Error!!-' || v_coa_step || '>>' || sqlerrm);    
END COA_LNK_AVG_STND_COST_FULL_PRC;