CREATE OR REPLACE PROCEDURE COA_CREATE_TARGET_VVD_PRC
( 
   in_year       IN VARCHAR2, 
   in_fm_wk      IN VARCHAR2, 
   in_duration   IN VARCHAR2, 
   in_ind        IN VARCHAR2, -- COA,BSA 구분 
   in_trd_cd     IN VARCHAR2, -- Optional:Trade 
   in_rlane_cd   IN VARCHAR2, -- Optional:Rlane 
   in_ioc_cd     IN VARCHAR2, -- Optional:IOC 
   in_vsl_cd     IN VARCHAR2, -- Optional:Vessel code 
   in_skd_voy_no IN VARCHAR2, -- Optional:Voyage Number 
   in_dir_cd     IN VARCHAR2, -- Optional:Dir 
   in_user_id    IN VARCHAR2, -- User id 
   p_error_code OUT VARCHAR2, 
   p_error_msg  OUT VARCHAR2 
) 
Authid current_user 
IS 
/****************************************************************************** 
   Name         :   COA_CREATE_TARGET_VVD_PRC 
   Purpose      :   주차별 대상 항차를 생성 
   Source       :   vsl_port_skd 
   Target       :   coa_mon_vvd 
   Revision History
      1. 2014.12.18 Intra, IPC SAME CONTI MULTI TRADE
      2. 2015.01.19 Deleting AR Revenue Lane Mapping     
      3. 2015.01.20 SMY Creating AZX lane    
      4. 2015.01.21 SMY modifying sales_yrmon 
      5. 2015.06.09 SMY Adding to Omission Port
      6. 2015.06.12 SMY modifying 2 over omission port
******************************************************************************/ 
/* 
 
--------------------------------------------------------------------------- 
<<대상항차 선정 기준[2009.12.15 신준모씨가 확정해준 로직]>> 
--------------------------------------------------------------------------- 
1. Ocean : turn port indicator가 'Y','N' 인 포트 중 (Loading Port) 
           대륙이 변경되기 직전 포트를 기준으로 함 
2. Trunk IPC : turn port indicator가 'Y','N','F' 인 포트 중 
               국가가 하나 이상일 경우 마지막 국가 직전 포트를 기준으로 함 
               단일 국가일경우 존재하지 않는다고 함 
               (현재는 마지막포트롤 잡아 주도록 했음 이유는 기준포트를 잡지 않으면  
                Rev.Month, Week, Sls.Month등에 NULL이 들어 가기 때문에) 
3. Intra : turn port indicator가 'Y','N' 인 포트 중 (Loading Port) 
           Loading Port의 마지막 포트를 기준으로 함 
--------------------------------------------------------------------------- 
Log 확인 
--------------------------------------------------------------------------- 
SELECT * FROM ENIS_LOG 
WHERE MOD_NAME = 'COA_CREATE_TARGET_VVD_PRC' 
  AND EXEC_DT > SYSDATE - 1/(24*60) 
ORDER BY EXEC_DT DESC; 
--------------------------------------------------------------------------- 
Procedure 실행 
--------------------------------------------------------------------------- 
DECLARE 
P_ERROR_CODE	VARCHAR2(4000); 
P_ERROR_MSG	VARCHAR2(4000); 
BEGIN 
    COA_CREATE_TARGET_VVD_PRC('2010' -- in_year 
                             ,'22'   -- in_fm_wk 
                             ,'1'    -- in_duration 
                             ,BSA'   -- in_ind[BSA:대상선정,COA:주차확정] 
                             ,NULL   -- in_trd_cd 
                             ,NULL   -- in_rlane_cd 
                             ,NULL   -- in_ioc_cd 
                             ,NULL   -- in_vsl_cd 
                             ,NULL   -- in_skd_voy_no 
                             ,NULL   -- in_dir_cd 
                             ,'BATCH'  
                             ,P_ERROR_CODE 
                             ,P_ERROR_MSG) ; 
    COMMIT; 
END; 
--------------------------------------------------------------------------- 
Revision History 
---------------------------------------------------------------------------
    ------------------------------------ 
     
*/ 
--   in_year       VARCHAR2 (4)    := '2010'; 
--   in_fm_wk      VARCHAR2 (2)    := '01'; 
--   in_duration   VARCHAR2 (2)    := '6'; 
--   in_ind        VARCHAR2 (3)    := 'BSA'; -- COA,BSA 구분 
--   in_trd_cd     VARCHAR2 (3)    := ''; -- Optional 
--   in_rlane_cd   VARCHAR2 (5)    := ''; -- Optional 
--   in_ioc_cd     VARCHAR2 (1)    := ''; -- Optional 
--   in_vsl_cd     VARCHAR2 (4)    := 'HNCA'; -- Optional 
--   in_skd_voy_no VARCHAR2 (4)    := '0042'; -- Optional 
--   in_dir_cd     VARCHAR2 (1)    := 'W'; -- Optional 
--   in_user_id    VARCHAR2 (20)   := 'BATCH'; 
-- 
   v_log_mod_nm       VARCHAR2 (30)   := 'COA_CREATE_TARGET_VVD_PRC'; 
   v_appl_info        VARCHAR2 (30)   := ''; 
   v_log_desc         VARCHAR2 (4000); 
   v_coa_err_msg      VARCHAR2 (100); 
   out_result         VARCHAR2 (5000); 
   v_bzc_cost_yrmon   VARCHAR2 (6); 
   v_cnt              NUMBER          := 0; 
   v_is_exit          VARCHAR2 (1)    := 'N'; 
   v_start_time1       TIMESTAMP; 
   v_start_time2       TIMESTAMP; 
   v_o_cost_yrmon     coa_mon_vvd.cost_yrmon%TYPE; --Ocean의 cost_yrmon을 담음
   
   /** Define Canal Port **/
   -- 2015.06.09 comment
--   v_canal_port1 VARCHAR2(5) :='EGSCA'; -- EGSUZ
--   v_canal_port2 VARCHAR2(5) :='PAPCA'; -- PAPAC

   
 
 
 
    -- ================================================================================================================== 
    -- Ocean 대상선정 커서 
    -- ================================================================================================================== 
    -- 4 start ----------------------------------------------------------------------------------------------------------- 
    -- 해당 주차에 해당하는것을 추출한다. 
    CURSOR ocean_cursor IS 
    SELECT d2.cost_yr 
          ,d2.cost_wk 
          ,d1.trd_cd 
          ,d1.rlane_cd 
          ,d1.slan_cd 
          ,d1.sub_trd_cd 
          ,d1.ioc_cd 
          ,d1.vsl_cd 
          ,d1.skd_voy_no 
          ,d1.skd_dir_cd dir_cd 
          ,d1.vps_port_cd 
          ,d1.vps_etd_dt 
          ,d1.min_etd_dt 
          ,to_char(d1.vps_etd_dt,'yyyymm') sls_yrmon 
          ,count(*) over() t_cnt 
      FROM ( 
            
            -- 3 start --------------------------------------------------------------------------------------------------- 
            -- Ocean 구간의 대상 Port는 이전대륙의 마지막 Port 
            SELECT DECODE(c1.conti,c1.next_conti,'I','O') ioc_cd 
                  ,c1.slan_cd 
                  ,c1.vsl_cd 
                  ,c1.skd_voy_no 
                  ,c1.skd_dir_cd 
                  ,c1.vps_port_cd 
                  ,c1.conti 
                  ,c1.next_conti 
                  ,c2.trd_cd 
                  ,c2.rlane_cd 
                  ,c2.sub_trd_cd 
                  ,c1.vps_etd_dt 
                  ,c1.min_etd_dt 
                  
                  ,ROW_NUMBER () OVER(PARTITION BY c1.slan_cd, c1.vsl_cd, c1.skd_voy_no, c1.skd_dir_cd, DECODE(c1.conti,c1.next_conti,'I','O'),
                                                   c2.trd_cd, c2.rlane_cd, c2.sub_trd_cd
                                          ORDER BY c1.slan_cd, c1.vsl_cd, c1.skd_voy_no, c1.skd_dir_cd, DECODE(c1.conti,c1.next_conti,'I','O'),
                                                   c2.trd_cd, c2.rlane_cd, c2.sub_trd_cd, c1.vps_etd_dt DESC 
                   ) row_no                  
              FROM ( 
                   
                   
                   -- 2 start -------------------------------------------------------------------------------------------- 
                   -- Conti를 현재와 다음 Conti를 구하고 vps_etd_dt의 최소값을 구한다. 
                   SELECT b1.vsl_cd 
                         ,b1.skd_voy_no 
                         ,b1.skd_dir_cd 
                         ,b1.slan_cd 
                         ,b1.vps_etd_dt 
                         ,b1.vps_port_cd 
                         ,b1.clpt_seq 
                         ,b1.turn_port_ind_cd 
                         ,b2.conti_cd conti
                         ,LEAD(b2.conti_cd) OVER(PARTITION BY b1.slan_cd, b1.vsl_cd, b1.skd_voy_no, b1.skd_dir_cd ORDER BY b1.vps_etd_dt) next_conti 
                         ,MIN(b1.vps_etd_dt) OVER(PARTITION BY b1.slan_cd, b1.vsl_cd, b1.skd_voy_no, b1.skd_dir_cd) min_etd_dt 
                     FROM vsk_vsl_port_skd b1 
                         ,mdm_location b2 
                    WHERE 1=1 
                      AND b1.vps_port_cd         = b2.loc_cd 
                      AND NVL(b1.skd_cng_sts_cd,'*') NOT IN ('S') 
--                      AND b1.vps_port_cd         NOT IN (:v_canal_port1,:v_canal_port2) --2015.06.09 comment
                      -- 2015.06.09  Omission Port
                      AND NOT EXISTS (
                              SELECT 1
                                FROM coa_mon_vvd_port_expt e1
                               WHERE 1=1
                                 AND e1.loc_cd = b1.vps_port_cd  
                                 AND NVL(e1.dir_cd , b1.skd_dir_cd) = b1.skd_dir_cd                                             
                                 AND e1.rlane_cd IS NULL
                                 AND b1.vps_etd_dt BETWEEN TO_DATE(e1.eff_fm_dt,'YYYY/MM/DD')
                                                   AND     TO_DATE(e1.eff_to_dt,'YYYY/MM/DD')+0.99999
                              )                      
                      And (b1.slan_cd, b1.vsl_cd, b1.skd_voy_no, b1.skd_dir_cd) in  
                          ( 
                             
                             -- 1 start ----------------------------------------------------------------------------------------- 
                             -- Ocean구간 생성 대상 VVD List(Lane 정보중 Trunk IPC, Intra IPC 이 아닌 것을 대상으로 함) 
                             -- Vessel Schedule 에 Port가 현재 주차에 해당하는 포트가 하나라도 존재하면 대상으로 선정한다. 
                             SELECT DISTINCT  
                                    a2.slan_cd 
                                   ,a2.vsl_cd 
                                   ,a2.skd_voy_no 
                                   ,a2.skd_dir_cd 
                               FROM ( 
                                    SELECT MIN(sls_fm_dt) sls_fm_dt, MAX(sls_to_dt)  sls_to_dt 
                                      FROM ( 
                                           SELECT cost_yr, sls_fm_dt, sls_to_dt 
                                             FROM coa_wk_prd 
                                            WHERE cost_yr || cost_wk  >= in_year || in_fm_wk 
                                            ORDER BY sls_fm_dt 
                                           )  
                                     WHERE 1=1 
                                       AND rownum   <= in_duration 
                                    ) a1 
                                   ,vsk_vsl_port_skd a2 
                              WHERE 1=1 

                                AND a2.vps_etd_dt                 BETWEEN to_date(a1.sls_fm_dt,'yyyymmdd hh:mi:ss') AND to_date(a1.sls_to_dt,'yyyymmdd')+0.99999 
                                AND a2.vsl_cd                     = NVL(in_vsl_cd      ,a2.vsl_cd) 
                                AND a2.skd_voy_no                 = NVL(in_skd_voy_no  ,a2.skd_voy_no) 
                                AND a2.skd_dir_cd                 = NVL(in_dir_cd      ,a2.skd_dir_cd) 
                                AND NVL(a2.skd_cng_sts_cd,'*')        NOT IN ('S') 
                                AND NVL(a2.turn_port_ind_cd,'*')  NOT IN ('V') 
--                                AND a2.vps_port_cd                NOT IN (:v_canal_port1,:v_canal_port2)   2015.06.09 comment
                                -- 2015.06.09  Omission Port
                                AND NOT EXISTS (
                                          SELECT 1
                                            FROM coa_mon_vvd_port_expt e1
                                           WHERE 1=1
                                             AND e1.loc_cd = a2.vps_port_cd  
                                             AND NVL(e1.dir_cd , a2.skd_dir_cd) = a2.skd_dir_cd                                             
                                             AND e1.rlane_cd IS NULL
                                             AND a2.vps_etd_dt BETWEEN TO_DATE(e1.eff_fm_dt,'YYYY/MM/DD')
                                                               AND     TO_DATE(e1.eff_to_dt,'YYYY/MM/DD')+0.99999
                                          )
                                AND a2.slan_cd                    IN ( 
                                                                      SELECT DISTINCT slan_cd 
                                                                        FROM coa_lane_rgst 
                                                                       WHERE NVL(intr_asia_flg,'N') NOT IN ('Y') 
                                                                         AND NVL(trnk_ipt_flg ,'N') NOT IN ('Y') 
                                                                         AND NVL(delt_flg     ,'N') NOT IN ('Y') 
                                                                         AND slan_cd                = a2.slan_cd 
                                                                         AND trd_cd                 = NVL(in_trd_cd   , trd_cd) 
                                                                         AND rlane_cd               = NVL(in_rlane_cd , rlane_cd) 
                                                                         AND dir_cd                 = NVL(in_dir_cd   , dir_cd) 
                                                                         AND ioc_cd                 = NVL(in_ioc_cd   , ioc_cd)
                                                                         AND ROWNUM <= 1 
                                                                      )                           
                          
                          
                          -- 1 end ----------------------------------------------------------------------------------------- 
                          ) 
--                     ORDER BY b1.slan_cd, b1.vsl_cd,b1.skd_voy_no,b1.skd_dir_cd,b1.clpt_seq 
                     -- 2 end ---------------------------------------------------------------------------------------------- 
                     
                   UNION  -- AZX 추가1
                   
                   -- 2-2 start -------------------------------------------------------------------------------------------- 
                   -- Conti를 현재와 다음 Conti를 구하고 vps_etd_dt의 최소값을 구한다. 
                   SELECT b1.vsl_cd 
                         ,b1.skd_voy_no 
                         ,b1.skd_dir_cd 
                         ,b1.slan_cd 
                         ,b1.vps_etd_dt 
                         ,b1.vps_port_cd 
                         ,b1.clpt_seq 
                         ,b1.turn_port_ind_cd 
                         ,b2.conti_cd conti
--                         ,LEAD(b2.conti_cd,2) OVER(PARTITION BY b1.slan_cd, b1.vsl_cd, b1.skd_voy_no, b1.skd_dir_cd ORDER BY b1.vps_etd_dt) next_conti 
--                         ,b3.cpy_no 
                         ,CASE 
                            WHEN b3.cpy_no = 1
                            THEN 
                              LEAD(b2.conti_cd, 2) OVER(PARTITION BY b1.slan_cd, b1.vsl_cd, b1.skd_voy_no, b1.skd_dir_cd ORDER BY b3.cpy_no , b1.vps_etd_dt)                           
                            ELSE  
                              LEAD(b2.conti_cd, 3) OVER(PARTITION BY b1.slan_cd, b1.vsl_cd, b1.skd_voy_no, b1.skd_dir_cd ORDER BY b3.cpy_no , b1.vps_etd_dt)                           
                          END next_conti  
                         
                         ,MIN(b1.vps_etd_dt) OVER(PARTITION BY b1.slan_cd, b1.vsl_cd, b1.skd_voy_no, b1.skd_dir_cd) min_etd_dt 
                     FROM vsk_vsl_port_skd b1 
                         ,mdm_location b2 
                        ,(SELECT cpy_no 
                         FROM com_cpy_no
                        WHERE cpy_no BETWEEN 1 AND 2)  b3                          
                    WHERE 1=1 
                      AND b1.vps_port_cd         = b2.loc_cd 
                      AND NVL(b1.skd_cng_sts_cd,'*') NOT IN ('S') 
--                      AND b1.vps_port_cd         NOT IN (:v_canal_port1,:v_canal_port2)  2015.06.09 comment
                      -- 2015.06.09  Omission Port
                      AND NOT EXISTS (
                              SELECT 1
                                FROM coa_mon_vvd_port_expt e1
                               WHERE 1=1
                                 AND e1.loc_cd = b1.vps_port_cd  
                                 AND NVL(e1.dir_cd , b1.skd_dir_cd) = b1.skd_dir_cd                                             
                                 AND e1.rlane_cd IS NULL
                                 AND b1.vps_etd_dt BETWEEN TO_DATE(e1.eff_fm_dt,'YYYY/MM/DD')
                                                   AND     TO_DATE(e1.eff_to_dt,'YYYY/MM/DD')+0.99999
                              )                       
                      
                      And (b1.slan_cd, b1.vsl_cd, b1.skd_voy_no, b1.skd_dir_cd) in  
                          ( 
                             -- 1-2 start ----------------------------------------------------------------------------------------- 
                             -- Ocean구간 생성 대상 VVD List(Lane 정보중 Trunk IPC, Intra IPC 이 아닌 것을 대상으로 함) 
                             -- Vessel Schedule 에 Port가 현재 주차에 해당하는 포트가 하나라도 존재하면 대상으로 선정한다. 
                             SELECT DISTINCT  
                                    a2.slan_cd 
                                   ,a2.vsl_cd 
                                   ,a2.skd_voy_no 
                                   ,a2.skd_dir_cd 
                               FROM ( 
                                    SELECT MIN(sls_fm_dt) sls_fm_dt, MAX(sls_to_dt)  sls_to_dt 
                                      FROM ( 
                                           SELECT cost_yr, sls_fm_dt, sls_to_dt 
                                             FROM coa_wk_prd 
                                            WHERE cost_yr || cost_wk  >= in_year || in_fm_wk 
                                            ORDER BY sls_fm_dt 
                                           )  
                                     WHERE 1=1 
                                       AND rownum   <= in_duration 
                                    ) a1 
                                   ,vsk_vsl_port_skd a2 
                              WHERE 1=1 
                                AND a2.vps_etd_dt                 BETWEEN to_date(a1.sls_fm_dt,'yyyymmdd hh:mi:ss') AND to_date(a1.sls_to_dt,'yyyymmdd')+0.99999 
                                AND a2.vsl_cd                     = NVL(in_vsl_cd      ,a2.vsl_cd) 
                                AND a2.skd_voy_no                 = NVL(in_skd_voy_no  ,a2.skd_voy_no) 
                                AND a2.skd_dir_cd                 = NVL(in_dir_cd      ,a2.skd_dir_cd) 
                                AND NVL(a2.skd_cng_sts_cd,'*')        NOT IN ('S') 
                                AND NVL(a2.turn_port_ind_cd,'*')  NOT IN ('V') 
--                                AND a2.vps_port_cd                NOT IN (:v_canal_port1,:v_canal_port2) --2015.06.09 comment
                                -- 2015.06.09  Omission Port
                                AND NOT EXISTS (
                                          SELECT 1
                                            FROM coa_mon_vvd_port_expt e1
                                           WHERE 1=1
                                             AND e1.loc_cd = a2.vps_port_cd  
                                             AND NVL(e1.dir_cd , a2.skd_dir_cd) = a2.skd_dir_cd                                             
                                             AND e1.rlane_cd IS NULL
                                             AND a2.vps_etd_dt BETWEEN TO_DATE(e1.eff_fm_dt,'YYYY/MM/DD')
                                                               AND     TO_DATE(e1.eff_to_dt,'YYYY/MM/DD')+0.99999
                                          )                                
                                
                                AND a2.slan_cd                    IN ( 
                                                                      SELECT DISTINCT slan_cd 
                                                                        FROM coa_lane_rgst 
                                                                       WHERE NVL(intr_asia_flg,'N') NOT IN ('Y') 
                                                                         AND NVL(trnk_ipt_flg ,'N') NOT IN ('Y') 
                                                                         AND NVL(delt_flg     ,'N') NOT IN ('Y') 
                                                                         AND slan_cd                = a2.slan_cd 
                                                                         AND trd_cd                 = NVL(in_trd_cd   , trd_cd) 
                                                                         AND rlane_cd               = NVL(in_rlane_cd , rlane_cd) 
                                                                         AND dir_cd                 = NVL(in_dir_cd   , dir_cd) 
                                                                         AND ioc_cd                 = NVL(in_ioc_cd   , ioc_cd)
                                                                         AND NVL(pndlm_lane_flg,'N')             = 'Y'
                                                                         AND ROWNUM <= 1 
                                                                      )                           
                          -- 1-2 end ----------------------------------------------------------------------------------------- 
                          ) 
--                     ORDER BY b1.slan_cd, b1.vsl_cd,b1.skd_voy_no,b1.skd_dir_cd,b1.clpt_seq 
                     -- 2-2 end ----------------------------------------------------------------------------------------------                         
                   
                    
                   ) c1 
                  ,coa_lane_rgst c2 
             WHERE c1.conti                                <> c1.next_conti 
               AND NVL(c1.turn_port_ind_cd,'N')            NOT IN ('V','D') 
               AND c1.next_conti                           IS NOT NULL 
               AND DECODE(c1.conti,c1.next_conti,'I','O') = c2.ioc_cd 
               AND c1.skd_dir_cd                          = c2.dir_cd 
               AND c1.slan_cd                             = c2.slan_cd 
               AND NVL(c2.delt_flg,'N')                   = 'N' 
               
               -- 2015.01.20 AZX 하드코딩 (AFT외의 trade 에서 F confi 제외)
               AND DECODE(c1.slan_cd,'AZX', DECODE(c2.trd_cd,'AFT','X', 
                                            DECODE(c1.conti, 'F','F',
                                            DECODE(c1.next_conti,'F','F','X'))),'X') = 'X'
             
               
               AND c2.trd_cd  in ( 
                                 SELECT DISTINCT trd_cd 
                                   FROM mdm_dtl_rev_lane 
                                  WHERE delt_flg             = 'N' 
                                    AND fm_conti_cd          IS NOT NULL 
                                    AND vsl_slan_dir_cd      = c1.skd_dir_cd 
                                    AND fm_conti_cd          = c1.conti 
                                    AND to_conti_cd          = c1.next_conti 
                                    AND ioc_cd               = c2.ioc_cd 
                                    AND SUBSTR(rlane_cd,1,3) = c1.slan_cd 
 
                                 ) 
--            ORDER BY c1.slan_cd, c1.vsl_cd, c1.skd_voy_no, c1.skd_dir_cd 
            -- 3 end ----------------------------------------------------------------------------------------------------- 
            
            ) d1 
           ,( 
            SELECT cost_yr, cost_wk, sls_fm_dt, sls_to_dt 
              FROM ( 
                   SELECT cost_yr, cost_wk, sls_fm_dt, sls_to_dt 
                     FROM coa_wk_prd 
                    WHERE cost_yr || cost_wk  >= in_year || in_fm_wk 
                    ORDER BY SLS_FM_DT 
                   )  
             WHERE 1=1 
               AND rownum   <= in_duration 
            )d2 
     WHERE 1=1 
       AND d1.vps_etd_dt  BETWEEN to_date(d2.sls_fm_dt,'yyyymmdd hh:mi:ss') AND to_date(d2.sls_to_dt,'yyyymmdd')+0.99999 
       AND d1.trd_cd      = NVL(in_trd_cd    , d1.trd_cd) 
       AND d1.rlane_cd    = NVL(in_rlane_cd  , d1.rlane_cd) 
       AND d1.ioc_cd      = NVL(in_ioc_cd    , d1.ioc_cd) 
       AND d1.vsl_cd      = NVL(in_vsl_cd    , d1.vsl_cd) 
       AND d1.skd_voy_no  = NVL(in_skd_voy_no, d1.skd_voy_no) 
       AND d1.skd_dir_cd  = NVL(in_dir_cd    , d1.skd_dir_cd)
       AND d1.row_no = 1
       ; 
--     ORDER BY d1.slan_cd, d1.vsl_cd, d1.skd_voy_no, d1.skd_dir_cd 
     -- 4 end ------------------------------------------------------------------------------------------------------------- 
    -- ================================================================================================================== 
     
    -- ================================================================================================================== 
    -- 순수역내 대상선정 커서 
    -- ================================================================================================================== 
    CURSOR inter_cursor IS 
    SELECT e2.cost_yr, e2.cost_wk 
          ,e3.trd_cd,e3.rlane_cd,e3.sub_trd_cd,e1.slan_cd,'I' ioc_cd,e1.vsl_cd,e1.skd_voy_no,e1.skd_dir_cd dir_cd,e1.vps_port_cd 
          ,e1.vps_etd_dt,e1.min_etd_dt, to_char(e1.vps_etd_dt,'yyyymm') sls_yrmon 
          ,DECODE(NVL(e3.intr_asia_flg,'N'),'Y','I-I','T-I') ind 
          ,count(*) over() t_cnt 
      FROM (
             -- 4 start -------------------------------------------------------------------------------------------------------------- 
             -- Loading Port 중에 마지막 Port를 선별한다. 
             SELECT c1.slan_cd,c1.vsl_cd,c1.skd_voy_no,c1.skd_dir_cd,c1.vps_port_cd,c1.clpt_seq,c1.turn_port_ind_cd,c1.vps_etd_dt,c1.cnt_cd 
                   ,c1.conti_cd,c1.next_conti,c1.min_etd_dt 
                   ,ROW_NUMBER() OVER(PARTITION BY c1.slan_cd,c1.vsl_cd,c1.skd_voy_no,c1.skd_dir_cd 
                                          ORDER BY c1.slan_cd,c1.vsl_cd,c1.skd_voy_no,c1.skd_dir_cd) num  
               FROM (                  
               		SELECT	slan_cd,vsl_cd,skd_voy_no,skd_dir_cd,vps_port_cd,turn_port_ind_cd,clpt_seq,cnt_cd,conti_cd,next_conti,vps_etd_dt,min_etd_dt
               	            ,org_target_seq target_seq
               		  FROM	(
		                     
                             -- 2 start ------------------------------------------------------------------------------------------------------ 
		                     -- VVD의 대상 포트정보를 조회한다(아주구간) 
		                     -- Loading Port 를 선별한다. 
		                     -- 현재와 다음 conti를 구한다 
		                     -- vps_etd_dt의 최소값을 구한다 
		                     SELECT b1.slan_cd,b1.vsl_cd,b1.skd_voy_no,b1.skd_dir_cd,b1.vps_port_cd,b1.turn_port_ind_cd,b1.clpt_seq 
		                           ,MAX(b1.clpt_seq) OVER(PARTITION BY b1.slan_cd,b1.vsl_cd,b1.skd_voy_no,b1.skd_dir_cd) org_target_seq -- VVD의 Max seq 
		                           ,b2.cnt_cd 
		                           ,b2.conti_cd conti_cd 
		                           ,NVL(LEAD(b2.conti_cd) OVER(PARTITION BY b1.slan_cd,b1.vsl_cd,b1.skd_voy_no,b1.skd_dir_cd ORDER BY b1.slan_cd,b1.vsl_cd,b1.skd_voy_no,b1.skd_dir_cd,b1.clpt_seq)  
		                               ,b2.conti_cd) next_conti 
		                           ,b1.vps_etd_dt 
		                           ,MIN(b1.vps_etd_dt) OVER(PARTITION BY b1.slan_cd,b1.vsl_cd,b1.skd_voy_no,b1.skd_dir_cd) min_etd_dt 
		                           ,B2.CONTI_CD ORG_CONTI
		                           ,LEAD(B2.CONTI_CD) OVER(PARTITION BY b1.slan_cd,b1.vsl_cd,b1.skd_voy_no,b1.skd_dir_cd ORDER BY b1.slan_cd,b1.vsl_cd,b1.skd_voy_no,b1.skd_dir_cd,b1.clpt_seq) ORG_NEXT		                          
		                       FROM vsk_vsl_port_skd b1 
		                           ,mdm_location b2 
		                      WHERE (b1.slan_cd, b1.vsl_cd, b1.skd_voy_no, b1.skd_dir_cd) IN  
		                            ( 
		                            
                                    -- 1 start ---------------------------------------------------------------------------------------------- 
		                            -- 순수 IPC 구간 생성 대상 VVD List(Lane 정보중 Trunk IPC, Intra IPC인것을 대상으로 함) 
		                            -- Vessel Schedule 에 Port가 현재 주차에 해당하는 포트가 하나라도 존재하면 대상으로 선정한다. 
		                            SELECT DISTINCT  
		                                   a2.slan_cd 
		                                  ,a2.vsl_cd 
		                                  ,a2.skd_voy_no 
		                                  ,a2.skd_dir_cd 
		                              FROM ( 
		                                    SELECT MIN(sls_fm_dt) sls_fm_dt, MAX(sls_to_dt)  sls_to_dt 
		                                      FROM ( 
		                                           SELECT cost_yr, sls_fm_dt, sls_to_dt 
		                                             FROM coa_wk_prd 
		                                            WHERE cost_yr || cost_wk  >= in_year || in_fm_wk 
		                                            ORDER BY sls_fm_dt 
		                                           )  
		                                     WHERE 1=1 
		                                       AND rownum   <= in_duration 
		                                    ) a1 
		                                  ,vsk_vsl_port_skd a2 
		                             WHERE 1=1 
		                               AND a2.vps_etd_dt                 BETWEEN to_date(a1.sls_fm_dt,'yyyymmdd hh:mi:ss') AND to_date(a1.sls_to_dt,'yyyymmdd')+0.99999 
		                               AND a2.vsl_cd                     = NVL(in_vsl_cd      ,a2.vsl_cd) 
		                               AND a2.skd_voy_no                 = NVL(in_skd_voy_no  ,a2.skd_voy_no) 
		                               AND a2.skd_dir_cd                 = NVL(in_dir_cd      ,a2.skd_dir_cd) 
		                               AND NVL(a2.skd_cng_sts_cd,'*')        NOT IN ('S') 
--		                               AND a2.vps_port_cd                NOT IN (:v_canal_port1,:v_canal_port2) 2015.06.09 comment
                                       -- 2015.06.09  Omission Port
                                       AND NOT EXISTS (
                                                  SELECT 1
                                                    FROM coa_mon_vvd_port_expt e1
                                                   WHERE 1=1
                                                     AND e1.loc_cd = a2.vps_port_cd  
                                                     AND NVL(e1.dir_cd , a2.skd_dir_cd) = a2.skd_dir_cd                                             
                                                     AND e1.rlane_cd IS NULL
                                                     AND a2.vps_etd_dt BETWEEN TO_DATE(e1.eff_fm_dt,'YYYY/MM/DD')
                                                                       AND     TO_DATE(e1.eff_to_dt,'YYYY/MM/DD')+0.99999
                                                  )
                                       
                                       
		                               AND a2.slan_cd                    IN ( 
		                                                                     SELECT DISTINCT slan_cd 
		                                                                       FROM coa_lane_rgst 
		                                                                      WHERE (NVL(intr_asia_flg,'N') = 'Y') -- OR NVL(trnk_ipt_flg,'N') = 'Y') 
		                                                                        AND NVL(delt_flg      ,'N') = 'N' 
		                                                                        AND slan_cd                = a2.slan_cd 
		                                                                        AND trd_cd                 = NVL(in_trd_cd, trd_cd) 
		                                                                        AND rlane_cd               = NVL(in_rlane_cd, rlane_cd) 
		                                                                        AND dir_cd                 = NVL(in_dir_cd, dir_cd) 
		                                                                        AND ioc_cd                 = NVL(in_ioc_cd, ioc_cd)	                                                                       
        		                                                                AND ROWNUM <= 1 
		                                                                     ) 
		                            
                                    
                                    -- 1 END ------------------------------------------------------------------------------------------------ 
		                            ) 
		                        AND b1.vps_port_cd                = b2.loc_cd 
		                        AND NVL(b1.skd_cng_sts_cd,'*')        NOT IN ('S') 
		                        AND NVL(b1.turn_port_ind_cd,'*')  IN ('Y','N')    
--		                        AND b1.vps_port_cd                NOT IN (:v_canal_port1,:v_canal_port2) 2015.06.09 comment
                                -- 2015.06.09  Omission Port
                                AND NOT EXISTS (
                                        SELECT 1
                                          FROM coa_mon_vvd_port_expt e1
                                         WHERE 1=1
                                           AND e1.loc_cd = b1.vps_port_cd  
                                           AND NVL(e1.dir_cd , b1.skd_dir_cd) = b1.skd_dir_cd                                             
                                           AND e1.rlane_cd IS NULL
                                           AND b1.vps_etd_dt BETWEEN TO_DATE(e1.eff_fm_dt,'YYYY/MM/DD')
                                                             AND     TO_DATE(e1.eff_to_dt,'YYYY/MM/DD')+0.99999
                                        )                                   
                                
		--                      ORDER BY b1.slan_cd,b1.vsl_cd,b1.skd_voy_no,b1.skd_dir_cd,b1.clpt_seq 
                             -- 2 END -------------------------------------------------------------------------------------------------------- 
		                     
                             )		            
                     ) c1 
              WHERE c1.conti_cd = c1.next_conti 
                AND c1.target_seq = c1.clpt_seq 
             -- 4 END ---------------------------------------------------------------------------------------------------------------- 
 
             ) e1 
            ,( 
              SELECT cost_yr, cost_wk, sls_fm_dt, sls_to_dt 
                FROM ( 
                     SELECT cost_yr, cost_wk, sls_fm_dt, sls_to_dt 
                       FROM coa_wk_prd 
                      WHERE cost_yr || cost_wk  >= in_year || in_fm_wk 
                      ORDER BY SLS_FM_DT 
                     )  
               WHERE 1=1 
                 AND rownum   <= in_duration 
              ) e2 
             ,coa_lane_rgst e3 
     WHERE 1=1 
       AND e1.vps_etd_dt BETWEEN to_date(e2.sls_fm_dt,'yyyymmdd hh:mi:ss') AND to_date(e2.sls_to_dt,'yyyymmdd')+0.99999 
       AND e1.slan_cd    = e3.slan_cd 
       AND e1.skd_dir_cd = e3.dir_cd 
       AND e3.ioc_cd     = 'I' 
       AND NVL(e3.delt_flg,'N') = 'N' 
       AND (NVL(e3.intr_asia_flg,'N') ='Y') -- OR NVL(e3.TRNK_IPT_FLG,'N') = 'Y') 
       AND e3.trd_cd     = (    
                                SELECT DISTINCT trd_cd 
                                   FROM mdm_dtl_rev_lane 
                                  WHERE delt_flg             = 'N' 
                                    AND vsl_slan_dir_cd      = e1.skd_dir_cd 
                                    AND fm_conti_cd          = e1.conti_cd
                                    AND to_conti_cd          = e1.next_conti 
                                    AND ioc_cd               = 'I'
                                    AND SUBSTR(rlane_cd,1,3) = e1.slan_cd 
                           ) 
       AND e3.trd_cd      = NVL(in_trd_cd    , e3.trd_cd) 
       AND e3.rlane_cd    = NVL(in_rlane_cd  , e3.rlane_cd) 
       AND e3.ioc_cd      = NVL(in_ioc_cd    , e3.ioc_cd) 
       AND e1.vsl_cd      = NVL(in_vsl_cd    , e1.vsl_cd) 
       AND e1.skd_voy_no  = NVL(in_skd_voy_no, e1.skd_voy_no) 
       AND e1.skd_dir_cd  = NVL(in_dir_cd    , e1.skd_dir_cd)
       ;
    -- ================================================================================================================== 
 
 
    -- ================================================================================================================== 
    -- Trunk-IPC 구간의 IAT[아주역내] 구간에 대해서 Week 정보를  
    -- Trunk-IPC 대상항차를 원양 노선 항차와 통일하면서 매주 Trunk_IPC 실적 파악하는게 불가능 
    -- BPS 와 같이 아주역내에서 실제 항차를 수행한 시점을 기준으로 대상항차의 주차정보를 선정하여 실적을 보여줄 수 있도록 함 
    -- ================================================================================================================== 
    CURSOR trunk_cursor (p_cost_yrmon VARCHAR2, p_trd_cd VARCHAR2,p_rlane_cd VARCHAR2, p_vsl_cd VARCHAR2, p_skd_voy_no VARCHAR2, p_dir_cd VARCHAR2, p_slan_cd VARCHAR2) IS  
    SELECT DISTINCT  
           e2.cost_yr, e2.cost_wk 
          ,p_cost_yrmon cost_yrmon  --NVL(TO_CHAR(e1.vps_etd_dt,'yyyymm'),e4.cost_yrmon)  Ocean의 cost_yrmon을 받는 것으로 변경
          ,NVL(TO_CHAR(e1.vps_etd_dt,'yyyymm'),e4.sls_yrmon) sls_yrmon 
          ,e4.rlane_cd
          ,e3.trd_cd, e3.sub_trd_cd, e1.slan_cd, e3.ioc_cd 
          ,e1.vsl_cd, e1.skd_voy_no, e1.skd_dir_cd 
          ,e1.vps_port_cd, e1.vps_etd_dt, e4.n1st_lodg_port_etd_dt 
          ,'T-O' ioc_rule_desc   
          ,e4.wky_tgt_flg, e4.mon_tgt_flg, e4.wky_mnl_flg, e4.delt_flg 
          ,count(*) over() t_cnt 
      FROM ( 
          -- 3 start ----------------------------------------------------------------------------------------- 
          -- 마지막 국가가 제외된 상태의 Max seq를 구한다 
          -- Max seq와 같은 clpt_seq 의 포트가 기준포트가 된다. 
          SELECT c1.slan_cd,c1.vsl_cd,c1.skd_voy_no,c1.skd_dir_cd,c1.vps_port_cd,c1.turn_port_ind_cd,c1.cnt_cd 
                ,c1.clpt_seq 
                ,MAX(c1.clpt_seq) OVER(PARTITION BY c1.slan_cd,c1.vsl_cd,c1.skd_voy_no,c1.skd_dir_cd) max_clpt_seq -- Max seq를 구한다 
                ,c1.conti_cd,c1.next_conti 
                ,c1.vps_etd_dt,c1.min_etd_dt 
            FROM ( 
                  
                  -- 2 start ----------------------------------------------------------------------------------------- 
                  -- 총국가수와 국가별 Max seq를 이용하여 국가 순번을 구한다. 
                  -- 이는 하나 이상의 국가를 운항했을 경우 마지막국가를 제외 하기 위해서 
                  SELECT b1.slan_cd,b1.vsl_cd,b1.skd_voy_no,b1.skd_dir_cd,b1.vps_port_cd,b1.turn_port_ind_cd,b1.cnt_cd 
                        ,b1.clpt_seq 
                        ,COUNT(DISTINCT cnt_cd) OVER(PARTITION BY slan_cd,vsl_cd,skd_voy_no,skd_dir_cd) cnt_tot_num            -- 총 국가수 
                        ,DENSE_RANK()     OVER(PARTITION BY slan_cd,vsl_cd,skd_voy_no,skd_dir_cd ORDER BY cnt_max_seq) cnt_seq -- clpt_seq로 정렬된 국가순번 
--                        ,b1.cnt_max_seq -- cnt_seq 구할때 사용한 데이터 확인을 위한 것  
                        ,conti_cd,next_conti 
                        ,b1.vps_etd_dt,min_etd_dt 
                    FROM ( 
                          
                          -- 1 start --------------------------------------------------------------------------------- 
                          -- VVD의 대상 포트정보를 조회한다(아주구간) 
                          -- 국가별 Max seq를 구한다 
                          SELECT a1.slan_cd,a1.vsl_cd,a1.skd_voy_no,a1.skd_dir_cd,a1.vps_port_cd,a1.turn_port_ind_cd,a1.clpt_seq 
                                ,cnt_cd
                                ,MAX(clpt_seq) OVER(PARTITION BY slan_cd,vsl_cd,skd_voy_no,skd_dir_cd,cnt_cd) cnt_max_seq   -- 국가별 Max seq 
                                ,a2.conti_cd conti_cd 
                                ,NVL(LEAD(a2.conti_cd) OVER(partition by slan_cd,vsl_cd,skd_voy_no,skd_dir_cd ORDER BY slan_cd,vsl_cd,skd_voy_no,skd_dir_cd,clpt_seq) 
                                         ,a2.conti_cd) next_conti 
                                ,a1.vps_etd_dt          
                                ,MIN(vps_etD_dt) OVER(partition by slan_cd,vsl_cd,skd_voy_no,skd_dir_cd) min_etd_dt 
                            FROM vsk_vsl_port_skd a1 
                                ,mdm_location a2 
                           WHERE 1=1  
                             AND a1.slan_cd                   = p_slan_cd 
                             AND a1.vsl_cd                    = p_vsl_cd 
                             AND a1.skd_voy_no                = p_skd_voy_no 
                             AND a1.skd_dir_cd                = p_dir_cd 
                             AND a1.vps_port_cd               = a2.loc_cd 
                             AND NVL(a1.skd_cng_sts_cd,'*')       NOT IN('S') 
                             AND NVL(a1.turn_port_ind_cd,'*') NOT IN ('V','D') 
--                             AND a1.vps_port_cd NOT IN (:v_canal_port1,:v_canal_port2)  --2015.06.09 comment
                             -- 2015.06.09  Omission Port
                             AND NOT EXISTS (
                                      SELECT 1
                                        FROM coa_mon_vvd_port_expt e1
                                       WHERE 1=1
                                         AND e1.loc_cd = a1.vps_port_cd  
                                         AND NVL(e1.dir_cd , a1.skd_dir_cd) = a1.skd_dir_cd                                             
                                         AND e1.rlane_cd IS NULL
                                         AND a1.vps_etd_dt BETWEEN TO_DATE(e1.eff_fm_dt,'YYYY/MM/DD')
                                                           AND     TO_DATE(e1.eff_to_dt,'YYYY/MM/DD')+0.99999
                                      )                             
                             
                             AND a2.conti_cd = 'A' -- 아주구간만 조회한다.    
                           ORDER BY a1.slan_cd,a1.vsl_cd,a1.skd_voy_no,a1.skd_dir_cd,a1.clpt_seq 
                           -- 1 end --------------------------------------------------------------------------------- 
                           
                        ) b1 
                   WHERE 1=1 
                   ORDER BY slan_cd,vsl_cd,skd_voy_no,skd_dir_cd,clpt_seq 
                   -- 2 end ----------------------------------------------------------------------------------------- 
                   
                   ) c1 
           WHERE 1=1 
             AND c1.cnt_seq <= DECODE(c1.cnt_tot_num, 1, 1, c1.cnt_tot_num-1)  -- 대륙이 하나 이상일 경우 대륙이 바뀌기 직전 국가를 제외 
           ORDER BY c1.slan_cd,c1.vsl_cd,c1.skd_voy_no,c1.skd_dir_cd,c1.clpt_seq 
           -- 3 end ----------------------------------------------------------------------------------------- 
           ) e1 
--          ,( 
--            SELECT cost_yr, cost_wk, sls_fm_dt, sls_to_dt 
--              FROM ( 
--                   SELECT cost_yr, cost_wk, sls_fm_dt, sls_to_dt 
--                     FROM coa_wk_prd 
--                    WHERE cost_yr || cost_wk  >= in_year || in_fm_wk 
--                    ORDER BY SLS_FM_DT 
--                   )  
--             WHERE 1=1 
--               AND rownum   <= in_duration 
--            ) e2 
          ,coa_wk_prd e2 
          ,coa_lane_rgst e3 
          ,coa_mon_vvd e4 
     WHERE 1=1 
       AND e1.clpt_seq              = e1.max_clpt_seq 
       AND e1.vps_etd_dt            BETWEEN to_date(e2.sls_fm_dt,'yyyymmdd hh:mi:ss') AND to_date(e2.sls_to_dt,'yyyymmdd')+0.99999 
       AND e1.slan_cd               = e3.slan_cd 
       AND e1.vsl_cd                = e4.vsl_cd 
       AND e1.skd_voy_no            = e4.skd_voy_no 
       AND e1.skd_dir_cd            = e4.dir_cd 
       AND e4.ioc_cd                = 'O' 
       AND e4.rlane_cd              NOT IN ('RBCCO') 
       AND NVL(e4.delt_flg,'*')     NOT IN ('Y') --AES AECAE AEC O DOHA 0060 E 
       AND e4.trd_cd                = p_trd_cd 
       AND e4.rlane_cd              = p_rlane_cd 
       AND e4.vsl_cd                = p_vsl_cd 
       AND e4.skd_voy_no            = p_skd_voy_no 
       AND e4.dir_cd                = p_dir_cd 
       AND e3.ioc_cd                = 'I' 
       AND e3.rlane_cd              = p_rlane_cd 
       AND NVL(e3.delt_flg,'N')     = 'N' 
       AND e1.skd_dir_cd            = e3.dir_cd 
       AND e3.trd_cd     = (    
                             SELECT DISTINCT trd_cd 
                                   FROM mdm_dtl_rev_lane 
                                  WHERE delt_flg             = 'N' 
                                    AND vsl_slan_dir_cd      = e1.skd_dir_cd 
                                    AND fm_conti_cd          = e1.conti_cd
                                    AND to_conti_cd          = e1.next_conti 
                                    AND ioc_cd               = 'I'
                                    AND SUBSTR(rlane_cd,1,3) = e1.slan_cd 
                           ) 
; 
        
BEGIN 
    v_start_time1 := SYSTIMESTAMP; 
    enis_log_prc (sysdate, v_log_mod_nm, 'START v.20150609',''); 
    enis_log_prc (sysdate, v_log_mod_nm, 'input param : ['|| in_year 
                                                    ||']['|| in_fm_wk 
                                                    ||']['|| in_duration 
                                                    ||']['|| in_ind 
                                                    ||']['|| in_trd_cd 
                                                    ||']['|| in_rlane_cd 
                                                    ||']['|| in_ioc_cd 
                                                    ||']['|| in_vsl_cd 
                                                    ||']['|| in_skd_voy_no 
                                                    ||']['|| in_dir_cd 
                                                    ||']['|| in_user_id 
                                                    ||']',''); 
 
    -- 1.Ocean 구간의 항차에 대한 정보를 입력한다. 
    v_appl_info := '1.Ocean VVD Cursor'; 
    v_start_time2 := SYSTIMESTAMP; 
    FOR ocean_list IN ocean_cursor LOOP 
        v_cnt := ocean_list.t_cnt; 
        v_log_desc := '['||ocean_list.t_cnt       ||'][' 
                         ||ocean_list.trd_cd      ||'][' 
                         ||ocean_list.rlane_cd    ||'][' 
                         ||ocean_list.ioc_cd      ||'][' 
                         ||ocean_list.vsl_cd  
                         ||ocean_list.skd_voy_no  
                         ||ocean_list.dir_cd      ||'][' 
                         ||ocean_list.slan_cd     ||'][' 
                         ||ocean_list.sub_trd_cd  ||'][' 
                         ||ocean_list.vps_port_cd ||'][' 
                         ||TO_CHAR(ocean_list.vps_etd_dt,'YYYYMMDD HH24:MI:SS')||'][' 
                         ||TO_CHAR(ocean_list.min_etd_dt,'YYYYMMDD HH24:MI:SS')||'][' 
                         ||ocean_list.sls_yrmon   ||']'; 
--        enis_log_prc (sysdate, v_log_mod_nm,v_log_desc,''); 
 
                  
        -- 1-1.Ocean 항차정보를 입력한다. 
        v_appl_info := '1-1.Ocean VVD Insert/Update'; 
        MERGE INTO coa_mon_vvd x 
        USING ( 
               SELECT ocean_list.cost_yr  
                     ,ocean_list.cost_wk     as cost_wk 
                     ,ocean_list.trd_cd      as trd_cd 
                     ,ocean_list.rlane_cd    as rlane_cd 
                     ,ocean_list.ioc_cd      as ioc_cd 
                     ,ocean_list.vsl_cd      as vsl_cd 
                     ,ocean_list.skd_voy_no  as skd_voy_no 
                     ,ocean_list.dir_cd      as dir_cd 
                     ,ocean_list.slan_cd     as slan_cd 
                     ,ocean_list.sub_trd_cd  as sub_trd_cd 
                     ,ocean_list.vps_port_cd as vps_port_cd 
                     ,ocean_list.vps_etd_dt  as vps_etd_dt 
                     ,ocean_list.min_etd_dt  as min_etd_dt 
                     ,ocean_list.sls_yrmon   as sls_yrmon 
                 FROM DUAL 
              ) y 
        ON ( 
                x.trd_cd      = y.trd_cd 
            AND x.rlane_cd    = y.rlane_cd 
            AND x.ioc_cd      = y.ioc_cd 
            AND x.vsl_cd      = y.vsl_cd 
            AND x.skd_voy_no  = y.skd_voy_no 
            AND x.dir_cd      = y.dir_cd 
           ) 
        WHEN MATCHED THEN 
            UPDATE  
               SET  
                   x.cost_yrmon            = DECODE(NVL(x.mon_tgt_flg,'N'), 'N', y.sls_yrmon, x.cost_yrmon) -- 월확정이 안된 경우만 정보를 변경 
                  ,x.cost_wk               = DECODE(NVL(x.wky_mnl_flg,'P'), 'P', y.cost_wk, x.cost_wk)      -- 주차확정이 안된 경우만 정보를 변경 
                  ,x.sls_yrmon             = y.sls_yrmon 
                  ,x.slan_cd               = y.slan_cd 
                  ,x.lst_lodg_port_etd_dt  = y.vps_etd_dt 
                  ,x.n1st_lodg_port_etD_dt = y.min_etd_dt 
                  ,x.lst_lodg_port_cd      = y.vps_port_cd 
                  ,x.ioc_rule_desc         = 'T-O' 
                  ,x.delt_flg              = DECODE(NVL(x.delt_flg,'N'),'N','N',x.delt_flg) 
                  ,x.wky_tgt_flg           = DECODE(NVL(x.wky_tgt_flg,'N'),'Y','Y',DECODE(in_ind,'COA','Y','N')) 
                  ,x.wky_mnl_flg           = DECODE(in_ind,'COA', DECODE(NVL(x.wky_mnl_flg,'P'), 'P', 'A', x.wky_mnl_flg),x.wky_mnl_flg) 
                  ,x.upd_usr_id            = in_user_id 
                  ,x.upd_dt                = SYSDATE 
        WHEN NOT MATCHED THEN 
            INSERT (x.trd_cd, x.sub_trd_cd, x.rlane_cd, x.ioc_cd 
                   ,x.vsl_cd, x.skd_voy_no, x.dir_cd 
                   ,x.cost_yrmon,x.sls_yrmon, x.cost_wk, x.slan_cd 
                   ,x.lst_lodg_port_etd_dt, x.n1st_lodg_port_etD_dt, x.lst_lodg_port_cd, x.ioc_rule_desc 
                   ,x.wky_tgt_flg,x.wky_mnl_flg, x.mon_tgt_flg, x.delt_flg 
                   ,x.cre_usr_id, x.cre_dt, x.upd_usr_id, x.upd_dt) 
            VALUES (y.trd_cd, y.sub_trd_cd, y.rlane_cd, y.ioc_cd 
                   ,y.vsl_cd, y.skd_voy_no, y.dir_cd 
                   ,y.sls_yrmon,y.sls_yrmon, y.cost_wk, y.slan_cd 
                   ,y.vps_etd_dt, y.min_etd_dt,y.vps_port_cd, 'T-O' 
                   ,DECODE(in_ind,'COA','Y','N'),DECODE(in_ind,'COA','A','P'),'N','N' 
                   ,in_user_id, SYSDATE,in_user_id, SYSDATE) 
         
        ; 
--        enis_log_prc(sysdate, v_log_mod_nm, '1-1.Ocean VVD Input.' || v_log_desc ,''); 
 
        -- 1-2.Ocean 구간의 Trunk IPC 항차중 IAT를 제외한 항차정보만 입력한다. 
        v_appl_info := '1-2.Ocean Trunk IPC(!IAT)'; 
        MERGE INTO coa_mon_vvd x 
        USING ( 
               SELECT a1.trd_cd bef_trd_cd 
                     ,a2.trd_cd, a2.sub_trd_cd, a2.rlane_cd, 'I' as ioc_cd 
                     ,a1.vsl_cd, a1.skd_voy_no, a1.dir_cd 
                     ,a1.cost_yrmon,a1.sls_yrmon,a1.cost_wk,a1.slan_cd 
                     ,a1.lst_lodg_port_etd_dt,a1.n1st_lodg_port_etd_dt,a1.lst_lodg_port_cd,'T-I' as ioc_rule_desc 
                     ,a1.wky_tgt_flg,a1.wky_mnl_flg,a1.mon_tgt_flg,a1.delt_flg 
                 FROM coa_mon_vvd a1 
                     ,coa_lane_rgst a2 
                WHERE 1=1 
                  AND a1.rlane_cd             = a2.rlane_cd 
                  AND a1.dir_cd               = a2.dir_cd 
                  AND a2.ioc_cd               = 'I' 
                  AND a1.ioc_cd               = 'O' 
                  AND a2.trnk_ipt_flg         = 'Y' 
                  AND NVL(a1.delt_flg,'N')    = 'N' 
                  AND NVL(a2.delt_flg,'N')    = 'N' 
                  AND a2.trd_cd               NOT IN ('IAT') -- Trunk IPC 중 아주인 것들은 제외시킨다. 
                  AND a1.rlane_cd             NOT IN ('RBCCO') 
                  AND a1.lst_lodg_port_etd_dt IS NOT NULL 
                  AND a1.trd_cd               = ocean_list.trd_cd 
                  AND a1.rlane_cd             = ocean_list.rlane_cd 
                  AND a1.vsl_cd               = ocean_list.vsl_cd 
                  AND a1.skd_voy_no           = ocean_list.skd_voy_no 
                  AND a1.dir_cd               = ocean_list.dir_cd 
              ) y 
        ON ( 
                x.trd_cd      = y.trd_cd 
            AND x.rlane_cd    = y.rlane_cd 
            AND x.ioc_cd      = y.ioc_cd 
            AND x.vsl_cd      = y.vsl_cd 
            AND x.skd_voy_no  = y.skd_voy_no 
            AND x.dir_cd      = y.dir_cd 
           ) 
        WHEN MATCHED THEN 
            UPDATE  
               SET x.cost_yrmon            = DECODE(NVL(x.mon_tgt_flg,'N'), 'N', y.cost_yrmon, x.cost_yrmon) 
                  ,x.cost_wk               = DECODE(NVL(x.wky_mnl_flg,'P'), 'P', y.cost_wk, x.cost_wk) 
                  ,x.sls_yrmon             = y.sls_yrmon 
                  ,x.slan_cd               = y.slan_cd 
                  ,x.lst_lodg_port_etd_dt  = y.lst_lodg_port_etd_dt 
                  ,x.n1st_lodg_port_etD_dt = y.n1st_lodg_port_etD_dt 
                  ,x.lst_lodg_port_cd      = y.lst_lodg_port_cd 
                  ,x.ioc_rule_desc         = y.ioc_rule_desc 
                  ,x.delt_flg              = DECODE(x.mon_tgt_flg,'Y',x.delt_flg,DECODE(x.delt_flg,'N','N',y.delt_flg)) -- 월확정 되었을 경우는 변경하지 않음.
                  ,x.wky_tgt_flg           = y.wky_tgt_flg        -- Trunk IPC는 Ocean 구간과 동일하게 주차확정을 설정함 
                  ,x.wky_mnl_flg           = DECODE(x.wky_mnl_flg,'M', x.wky_mnl_flg, y.wky_mnl_flg) 
                  ,x.upd_usr_id            = in_user_id 
                  ,x.upd_dt                = SYSDATE 
        WHEN NOT MATCHED THEN 
            INSERT (x.trd_cd, x.sub_trd_cd, x.rlane_cd, x.ioc_cd 
                   ,x.vsl_cd, x.skd_voy_no, x.dir_cd 
                   ,x.cost_yrmon, x.sls_yrmon, x.cost_wk, x.slan_cd 
                   ,x.lst_lodg_port_etd_dt, x.n1st_lodg_port_etd_dt, x.lst_lodg_port_cd, x.ioc_rule_desc 
                   ,x.wky_tgt_flg,x.wky_mnl_flg, x.mon_tgt_flg, x.delt_flg 
                   ,x.cre_usr_id, x.cre_dt,x.upd_usr_id,x.upd_dt) 
            VALUES (y.trd_cd, y.sub_trd_cd, y.rlane_cd, y.ioc_cd 
                   ,y.vsl_cd, y.skd_voy_no, y.dir_cd 
                   ,y.cost_yrmon,y.sls_yrmon, y.cost_wk, y.slan_cd 
                   ,y.lst_lodg_port_etd_dt, y.n1st_lodg_port_etd_dt,y.lst_lodg_port_cd, y.ioc_rule_desc 
                   ,y.wky_tgt_flg,y.wky_mnl_flg,y.mon_tgt_flg,y.delt_flg 
                   ,in_user_id, SYSDATE,in_user_id, SYSDATE) 
        ; 
--        enis_log_prc (sysdate, v_log_mod_nm, '1-2.Ocean Trunk IPC VVD Input(Not exists IAT).',''); 
        
        -- Trunk 커서에 Ocean의 cost_yrmon을 넣기 위해 조회한다.
        BEGIN
            SELECT cost_yrmon
              INTO v_o_cost_yrmon
              FROM coa_mon_vvd
             WHERE trd_cd     = ocean_list.trd_cd 
               AND rlane_cd   = ocean_list.rlane_cd 
               AND ioc_cd     = 'O' 
               AND vsl_cd     = ocean_list.vsl_cd 
               AND skd_voy_no = ocean_list.skd_voy_no 
               AND dir_cd     = ocean_list.dir_cd ;
        EXCEPTION
            WHEN OTHERS
               THEN v_o_cost_yrmon := '0000';
        END;
        
         
        -- 1-3.Ocean 구간의 Trunk IPC 항차 중 IAT 항차정보만 입력한다. 
        v_appl_info := '1-3.Ocean Trunk IPC(IAT)'; 
        FOR trunk_list IN trunk_cursor(v_o_cost_yrmon
                                      ,ocean_list.trd_cd 
                                      ,ocean_list.rlane_cd 
                                      ,ocean_list.vsl_cd 
                                      ,ocean_list.skd_voy_no 
                                      ,ocean_list.dir_cd 
                                      ,ocean_list.slan_cd 
                                      ) LOOP 
           v_log_desc := '['|| trunk_list.trd_cd 
                      ||']['|| trunk_list.rlane_cd 
                      ||']['|| trunk_list.ioc_cd 
                      ||']['|| trunk_list.vsl_cd  
                            || trunk_list.skd_voy_no  
                            || trunk_list.skd_dir_cd   
                      ||']['|| trunk_list.slan_cd 
                      ||']['|| trunk_list.sub_trd_cd 
                      ||']['|| trunk_list.vps_port_cd 
                      ||']['|| TO_CHAR(trunk_list.vps_etd_dt,'YYYYMMDD HH24:MI:SS') 
                      ||']['|| trunk_list.cost_yrmon 
                      ||']['|| trunk_list.sls_yrmon 
                      ||']['|| trunk_list.cost_wk 
                      ||']['|| trunk_list.wky_tgt_flg 
                      ||']['|| trunk_list.mon_tgt_flg 
                      ||']['|| trunk_list.delt_flg ||']'; 
 
            MERGE INTO coa_mon_vvd x 
            USING ( 
                   SELECT trunk_list.cost_yrmon   as cost_yrmon 
                         ,trunk_list.sls_yrmon    as sls_yrmon 
                         ,trunk_list.cost_wk      as cost_wk 
                         ,trunk_list.trd_cd       as trd_cd 
                         ,trunk_list.rlane_cd     as rlane_cd 
                         ,trunk_list.sub_trd_cd   as sub_trd_cd 
                         ,trunk_list.slan_cd      as slan_cd 
                         ,trunk_list.ioc_cd       as ioc_cd 
                         ,trunk_list.vsl_cd       as vsl_cd 
                         ,trunk_list.skd_voy_no   as skd_voy_no 
                         ,trunk_list.skd_dir_cd   as dir_cd 
                         ,trunk_list.vps_port_cd  as vps_port_cd 
                         ,trunk_list.vps_etd_dt   as vps_etd_dt 
                         ,trunk_list.n1st_lodg_port_etd_dt as n1st_lodg_port_etd_dt 
                         ,trunk_list.ioc_rule_desc as ioc_rule_desc 
                         ,trunk_list.wky_tgt_flg   as wky_tgt_flg 
                         ,trunk_list.mon_tgt_flg   as mon_tgt_flg 
                         ,trunk_list.wky_mnl_flg   as wky_mnl_flg 
                         ,trunk_list.delt_flg      as delt_flg 
                     FROM dual 
                  ) y 
            ON ( 
                    x.trd_cd      = y.trd_cd 
                AND x.rlane_cd    = y.rlane_cd 
                AND x.ioc_cd      = y.ioc_cd 
                AND x.vsl_cd      = y.vsl_cd 
                AND x.skd_voy_no  = y.skd_voy_no 
                AND x.dir_cd      = y.dir_cd 
               ) 
            WHEN MATCHED THEN 
                UPDATE  
                   SET x.cost_yrmon            = DECODE(NVL(x.mon_tgt_flg,'N'), 'N', y.cost_yrmon, x.cost_yrmon) 
                      ,x.cost_wk               = DECODE(NVL(x.wky_mnl_flg,'P'), 'P', y.cost_wk, x.cost_wk) 
                      ,x.sls_yrmon             = y.sls_yrmon 
                      ,x.slan_cd               = y.slan_cd 
                      ,x.lst_lodg_port_etd_dt  = y.vps_etd_dt 
                      ,x.n1st_lodg_port_etD_dt = y.n1st_lodg_port_etD_dt 
                      ,x.lst_lodg_port_cd      = y.vps_port_cd 
                      ,x.ioc_rule_desc         = y.ioc_rule_desc 
                      ,x.delt_flg              = DECODE(x.mon_tgt_flg,'Y',x.delt_flg,DECODE(x.delt_flg,'N','N',y.delt_flg)) -- 월확정 되었을 경우는 변경하지 않음.
                      ,x.wky_tgt_flg           = y.wky_tgt_flg        -- Trunk IPC는 Ocean 구간과 동일하게 주차확정을 설정함 
                      ,x.wky_mnl_flg           = DECODE(x.wky_mnl_flg,'M', x.wky_mnl_flg, y.wky_mnl_flg) 
                      ,x.upd_usr_id            = in_user_id 
                      ,x.upd_dt                = SYSDATE 
            WHEN NOT MATCHED THEN 
                INSERT (x.trd_cd, x.sub_trd_cd, x.rlane_cd, x.ioc_cd 
                       ,x.vsl_cd, x.skd_voy_no, x.dir_cd 
                       ,x.cost_yrmon, x.sls_yrmon, x.cost_wk, x.slan_cd 
                       ,x.lst_lodg_port_etd_dt, x.n1st_lodg_port_etd_dt, x.lst_lodg_port_cd, x.ioc_rule_desc 
                       ,x.wky_tgt_flg,x.wky_mnl_flg, x.mon_tgt_flg, x.delt_flg 
                       ,x.cre_usr_id, x.cre_dt,x.upd_usr_id,x.upd_dt) 
                VALUES (y.trd_cd, y.sub_trd_cd, y.rlane_cd, y.ioc_cd 
                       ,y.vsl_cd, y.skd_voy_no, y.dir_cd 
                       ,y.cost_yrmon,y.sls_yrmon, y.cost_wk, y.slan_cd 
                       ,y.vps_etd_dt, y.n1st_lodg_port_etd_dt,y.vps_port_cd, y.ioc_rule_desc 
                       ,y.wky_tgt_flg,y.wky_mnl_flg,y.mon_tgt_flg,y.delt_flg 
                       ,in_user_id, SYSDATE,in_user_id, SYSDATE); 
 
--            enis_log_prc (sysdate, v_log_mod_nm, '1-3.Ocean Trunk IPC VVD Input(Exists IAT).' || v_log_desc,''); 
              v_log_desc := ''; 
        END LOOP; 
    END LOOP; 
    enis_log_prc (sysdate, v_log_mod_nm, '1.Ocean VVD Cursor['||v_cnt||']',''); 
--    enis_log_prc (SYSDATE, v_log_mod_nm, '1.Ocean VVD Input : ' || TO_CHAR(SYSTIMESTAMP - v_start_time2, 'yyyy/mm/dd hh24:mi:ss.ff')); 
 
 
 
    -- 2.Inter[순수역내] 구간의 항차에 대한 정보를 입력한다. 
    v_appl_info := '2.Inter VVD Input'; 
    v_start_time2 := SYSTIMESTAMP; 
    v_cnt := 0; 
    FOR inter_list IN inter_cursor LOOP 
        v_cnt := inter_list.t_cnt; 
        v_log_desc := '['||inter_list.t_cnt       ||'][' 
                         ||inter_list.trd_cd      ||'][' 
                         ||inter_list.rlane_cd    ||'][' 
                         ||inter_list.ioc_cd      ||'][' 
                         ||inter_list.vsl_cd  
                         ||inter_list.skd_voy_no  
                         ||inter_list.dir_cd      ||'][' 
                         ||inter_list.slan_cd     ||'][' 
                         ||inter_list.sub_trd_cd  ||'][' 
                         ||inter_list.vps_port_cd ||'][' 
                         ||inter_list.vps_etd_dt  ||'][' 
                         ||inter_list.min_etd_dt  ||'][' 
                         ||inter_list.sls_yrmon   ||']'; 
--        enis_log_prc (sysdate, v_log_mod_nm,v_log_desc,''); 
        MERGE INTO coa_mon_vvd x 
        USING ( 
               SELECT inter_list.cost_yr     as cost_yr 
                     ,inter_list.cost_wk     as cost_wk 
                     ,inter_list.trd_cd      as trd_cd 
                     ,inter_list.rlane_cd    as rlane_cd 
                     ,inter_list.ioc_cd      as ioc_cd 
                     ,inter_list.vsl_cd      as vsl_cd 
                     ,inter_list.skd_voy_no  as skd_voy_no 
                     ,inter_list.dir_cd      as dir_cd 
                     ,inter_list.slan_cd     as slan_cd 
                     ,inter_list.sub_trd_cd  as sub_trd_cd 
                     ,inter_list.vps_port_cd as vps_port_cd 
                     ,inter_list.vps_etd_dt  as vps_etd_dt 
                     ,inter_list.min_etd_dt  as min_etd_dt 
                     ,inter_list.sls_yrmon   as sls_yrmon 
                     ,inter_list.ind         as ind 
                 FROM DUAL 
              ) y 
        ON ( 
                x.trd_cd      = y.trd_cd 
            AND x.rlane_cd    = y.rlane_cd 
            AND x.ioc_cd      = y.ioc_cd 
            AND x.vsl_cd      = y.vsl_cd 
            AND x.skd_voy_no  = y.skd_voy_no 
            AND x.dir_cd      = y.dir_cd 
           ) 
        WHEN MATCHED THEN 
            UPDATE  
               SET x.cost_yrmon            = DECODE(NVL(x.mon_tgt_flg,'N'), 'N', y.sls_yrmon, x.cost_yrmon) -- 월확정이 안된 경우만 정보를 변경 
                  ,x.cost_wk               = DECODE(NVL(x.wky_mnl_flg,'P'), 'P', y.cost_wk, x.cost_wk)      -- 주차확정이 안된 경우만 정보를 변경 
                  ,x.sls_yrmon             = y.sls_yrmon 
                  ,x.slan_cd               = y.slan_cd 
                  ,x.lst_lodg_port_etd_dt  = y.vps_etd_dt 
                  ,x.n1st_lodg_port_etD_dt = y.min_etd_dt 
                  ,x.lst_lodg_port_cd      = y.vps_port_cd 
                  ,x.ioc_rule_desc         = y.ind 
                  ,x.delt_flg              = DECODE(NVL(x.delt_flg,'N'),'N','N',x.delt_flg) 
                  ,x.wky_tgt_flg           = DECODE(NVL(x.wky_tgt_flg,'N'),'Y','Y',DECODE(in_ind,'COA','Y','N')) 
                  ,x.wky_mnl_flg           = DECODE(in_ind,'COA', DECODE(NVL(x.wky_mnl_flg,'P'), 'P', 'A', x.wky_mnl_flg),x.wky_mnl_flg) 
                  ,x.upd_usr_id            = in_user_id 
                  ,x.upd_dt                = SYSDATE 
        WHEN NOT MATCHED THEN 
            INSERT (trd_cd, sub_trd_cd, rlane_cd, ioc_cd 
                   ,vsl_cd, skd_voy_no, dir_cd 
                   ,cost_yrmon,sls_yrmon, cost_wk, slan_cd 
                   ,lst_lodg_port_etd_dt, n1st_lodg_port_etD_dt, lst_lodg_port_cd, ioc_rule_desc 
                   ,wky_tgt_flg,wky_mnl_flg, mon_tgt_flg, delt_flg 
                   ,cre_usr_id, cre_dt, upd_usr_id, upd_dt) 
            VALUES (y.trd_cd, y.sub_trd_cd, y.rlane_cd, y.ioc_cd 
                   ,y.vsl_cd, y.skd_voy_no, y.dir_cd 
                   ,y.sls_yrmon,y.sls_yrmon, y.cost_wk, y.slan_cd 
                   ,y.vps_etd_dt, y.min_etd_dt,y.vps_port_cd, y.ind 
                   ,DECODE(in_ind,'COA','Y','N'),DECODE(in_ind,'COA','A','P'),'N','N' 
                   ,in_user_id, SYSDATE,in_user_id, SYSDATE) 
         
        ; 
--        enis_log_prc (sysdate, v_log_mod_nm, '2.Inter VVD Input.' || v_log_desc,''); 
        v_log_desc := ''; 
 
    END LOOP; 
    enis_log_prc (sysdate, v_log_mod_nm, v_appl_info||'['||v_cnt||']'); 
--    enis_log_prc (SYSDATE, v_log_mod_nm, '2.Inter VVD Input. : ' || TO_CHAR(SYSTIMESTAMP - v_start_time2, 'yyyy/mm/dd hh24:mi:ss.ff')); 
     

    -- -------------------------------------------------------------------------------------------- 
    -- 2-1.Omission Port 
    -- -------------------------------------------------------------------------------------------- 
    v_appl_info := '2-1.Omission Port Update'; 
    v_start_time2 := SYSTIMESTAMP; 
    MERGE INTO coa_mon_vvd x 
    USING ( 

        SELECT 
                b1.trd_cd
               ,b1.rlane_cd
               ,b1.ioc_cd
               ,b1.vsl_cd
               ,b1.skd_voy_no
               ,b1.dir_cd
               ,b1.next_vps_port_cd 
               ,b1.next_vps_etd_dt
               ,to_char(b1.next_vps_etd_dt,'yyyymm') sls_yrmon
               ,d2.cost_wk 
         FROM 
            (
            SELECT  b1.trd_cd
                   ,b1.rlane_cd
                   ,b1.ioc_cd
                   ,b1.vsl_cd
                   ,b1.skd_voy_no
                   ,b1.dir_cd  
                   ,b1.slan_cd 
                   ,b1.vps_etd_dt 
                   ,b1.vps_port_cd 
                   ,b1.clpt_seq 
                   ,b.lst_lodg_port_cd
                   ,LAG(b1.vps_port_cd) OVER(PARTITION BY b1.trd_cd, b1.rlane_cd, b1.ioc_cd, b1.slan_cd, b1.vsl_cd, b1.skd_voy_no, b1.dir_cd ORDER BY b1.vps_etd_dt) next_vps_port_cd
                   ,LAG(b1.vps_etd_dt) OVER(PARTITION BY b1.trd_cd, b1.rlane_cd, b1.ioc_cd, b1.slan_cd, b1.vsl_cd, b1.skd_voy_no, b1.dir_cd ORDER BY b1.vps_etd_dt) next_vps_etd_dt
                   
              FROM 
            (
                SELECT  
                        b.trd_cd
                       ,b.rlane_cd
                       ,b.ioc_cd
                       ,b.vsl_cd
                       ,b.skd_voy_no
                       ,b.dir_cd  
                       ,b1.slan_cd 
                       ,b1.vps_etd_dt 
                       ,b1.vps_port_cd 
                       ,b1.clpt_seq 
                       ,b.lst_lodg_port_cd
                  FROM coa_mon_vvd b
                      ,vsk_vsl_port_skd b1
                 WHERE SUBSTR(b.sls_yrmon,1,4)||b.cost_wk   
                    IN ( 
                        SELECT distinct cost_yr || cost_wk 
                          FROM ( 
                               SELECT cost_yr, cost_wk, sls_fm_dt, sls_to_dt 
                                 FROM coa_wk_prd 
                                WHERE cost_yr || cost_wk  >= in_year || in_fm_wk 
                                ORDER BY sls_fm_dt 
                               )  
                         WHERE 1=1 
                           AND rownum   <= in_duration 
                       ) 
                   AND b.trd_cd      = NVL(in_trd_cd    , b.trd_cd) 
                   AND b.rlane_cd    = NVL(in_rlane_cd  , b.rlane_cd) 
                   AND b.ioc_cd      = NVL(in_ioc_cd    , b.ioc_cd) 
                   AND b.vsl_cd      = NVL(in_vsl_cd    , b.vsl_cd) 
                   AND b.skd_voy_no  = NVL(in_skd_voy_no, b.skd_voy_no) 
                   AND b.dir_cd      = NVL(in_dir_cd    , b.dir_cd)   
                   AND b.delt_flg = 'N'       
                   AND NVL(b.mon_tgt_flg,'N') = 'N'
                   AND NVL(b.wky_mnl_flg,'P') IN ('P','M','A')
                   AND  EXISTS (
                          SELECT 1
                            FROM coa_mon_vvd_port_expt e1
                           WHERE 1=1
                             AND e1.loc_cd = b.lst_lodg_port_cd  

                             AND DECODE(NVL(e1.dir_cd ,'X'), 'X', b1.skd_dir_cd, e1.dir_cd) = b1.skd_dir_cd
                             AND e1.rlane_cd = b.rlane_cd
                             AND b.lst_lodg_port_etd_dt BETWEEN TO_DATE(e1.eff_fm_dt,'YYYY/MM/DD')
                                                 AND     TO_DATE(NVL(e1.eff_to_dt,'9999/12/31'),'YYYY/MM/DD')+0.99999
                          )
                          
                   AND NVL(b1.skd_cng_sts_cd,'*')   NOT IN ('S')    
                   AND NVL(b1.turn_port_ind_cd,'*') NOT IN ('V','D') 
                   AND b.vsl_cd = b1.vsl_cd
                   AND b.skd_voy_no = b1.skd_voy_no
                   AND b.dir_cd = b1.skd_dir_cd
                 ) b1,
                 coa_mon_vvd b
            WHERE 1=1
              AND b1.trd_cd      = b.trd_cd    
              AND b1.rlane_cd    = b.rlane_cd  
              AND b1.ioc_cd      = b.ioc_cd    
              AND b1.vsl_cd      = b.vsl_cd    
              AND b1.skd_voy_no  = b.skd_voy_no
              AND b1.dir_cd      = b.dir_cd             
                 
              -- Revenue Lane EXCEPT
              AND NOT EXISTS (
                         SELECT 1
                           FROM coa_mon_vvd_port_expt e1
                          WHERE 1=1
                            AND e1.loc_cd = b1.vps_port_cd  
                            AND DECODE(NVL(e1.dir_cd ,'X') , 'X', b1.dir_cd, e1.dir_cd) = b1.dir_cd                                             
                            AND e1.rlane_cd = b.rlane_cd

                            AND b1.vps_etd_dt BETWEEN TO_DATE(e1.eff_fm_dt,'YYYY/MM/DD')
                                              AND     TO_DATE(NVL(e1.eff_to_dt,'9999/12/31'),'YYYY/MM/DD')+0.99999 
                            AND b1.vps_port_cd <> b.lst_lodg_port_cd                 
                           ) 

              -- CANAL EXCEPT
              AND NOT EXISTS (
                         SELECT 1
                           FROM coa_mon_vvd_port_expt e1
                          WHERE 1=1
                            AND e1.loc_cd = b1.vps_port_cd  
                            AND DECODE(NVL(e1.dir_cd ,'X') , 'X', b1.dir_cd, e1.dir_cd) = b1.dir_cd                                             
                            AND NVL(e1.rlane_cd, 'XXXXX') = 'XXXXX'
                            AND b1.vps_etd_dt BETWEEN TO_DATE(e1.eff_fm_dt,'YYYY/MM/DD')
                                              AND     TO_DATE(NVL(e1.eff_to_dt,'9999/12/31'),'YYYY/MM/DD')+0.99999       
                           ) 

           ) b1
        ,coa_mon_vvd b
        ,coa_wk_prd d2
        WHERE 1=1
          AND b1.trd_cd      = b.trd_cd    
          AND b1.rlane_cd    = b.rlane_cd  
          AND b1.ioc_cd      = b.ioc_cd    
          AND b1.vsl_cd      = b.vsl_cd    
          AND b1.skd_voy_no  = b.skd_voy_no
          AND b1.dir_cd      = b.dir_cd     
          AND b1.vps_port_cd = b.lst_lodg_port_cd          
          AND b1.vps_etd_dt  BETWEEN to_date(d2.sls_fm_dt,'yyyymmdd hh:mi:ss') 
                                 AND to_date(d2.sls_to_dt,'yyyymmdd')+0.99999         
          
               
              


          ) y 
    ON ( 
            x.trd_cd      = y.trd_cd 
        AND x.rlane_cd    = y.rlane_cd 
        AND x.ioc_cd      = y.ioc_cd 
        AND x.vsl_cd      = y.vsl_cd 
        AND x.skd_voy_no  = y.skd_voy_no 
        AND x.dir_cd      = y.dir_cd 
       ) 
    WHEN MATCHED THEN 
        UPDATE  
           SET x.cost_yrmon            = y.sls_yrmon
              ,x.cost_wk               = y.cost_wk
              ,x.sls_yrmon             = y.sls_yrmon 
              ,x.lst_lodg_port_etd_dt  = y.next_vps_etd_dt 
              ,x.lst_lodg_port_cd      = y.next_vps_port_cd 
              ,x.upd_usr_id            = in_user_id 
              ,x.upd_dt                = SYSDATE 
    ;
    enis_log_prc (sysdate, v_log_mod_nm, v_appl_info,'');   
    -- -------------------------------------------------------------------------------------------- 
    -- 3.FDR 등록 
    -- Vessel Code : FD + 년(끝에 두자리) 
    -- Voyage Number : 해당주차의 시잘일 부터 마지막 날짜의 월일(0706) 
    -- Bound : E, W 각각 7개씩 만들어준다. 
    -- -------------------------------------------------------------------------------------------- 
--    v_mig_msg   :='  ['||v_mig_pgm_nm||']  : FDR 구간 생성'||TO_CHAR(sysdate,'YYYYMMDD HH24:MI:SS'); 
    v_appl_info := '3.FDR VVD Input'; 
    v_start_time2 := SYSTIMESTAMP; 
    MERGE INTO coa_mon_vvd a 
    USING 
         ( 
          SELECT trd_cd,rlane_cd,ioc,vsl,voyage,bound,in_year||SUBSTR(voyage,1,2) yyyymm,cost_wk,slane slan_cd,'XXXXX' loading_port,ioc_rule 
            FROM ( 
                  SELECT cost_wk,'FD'||substr(sls_fm_dt,3,2) vsl,substr(to_char(fm_dt + rnum -1 ,'yyyymmdd'),5,4) voyage,'E' bound,'I' ioc,'R-I' ioc_rule,'RBC' slane 
                    FROM ( 
                          SELECT cost_wk,sls_fm_dt, to_date(sls_fm_dt,'yyyymmdd') fm_dt,sls_to_dt - sls_fm_dt +1 chk 
                            FROM coa_wk_prd 
                           WHERE cost_yr LIKE in_year||'%' 
                             AND cost_wk BETWEEN in_fm_wk AND (TO_NUMBER(in_fm_wk) + TO_NUMBER(in_duration)) 
                         ), 
                         ( 
                          SELECT rownum rnum 
                            FROM coa_sub_grp_cost 
                           WHERE rownum <8) 
                  WHERE rnum <=chk 
                  UNION ALL 
                  SELECT  cost_wk,'FD'||substr(sls_fm_dt,3,2) vsl,substr(to_char(fm_dt + rnum -1,'yyyymmdd'),5,4) voyage,'E' bound,'O' ioc,'R-O' ioc_rule,'RBC' 
                  FROM ( 
                        SELECT cost_wk,sls_fm_dt, to_date(sls_fm_dt,'yyyymmdd') fm_dt ,SLS_TO_DT - sls_fm_dt +1 chk 
                          FROM coa_wk_prd 
                         WHERE cost_yr LIKE in_year||'%' 
                           AND cost_wk BETWEEN in_fm_wk AND (TO_NUMBER(in_fm_wk) + TO_NUMBER(in_duration)) 
                       ), 
                       ( 
                        SELECT rownum rnum 
                          FROM coa_sub_grp_cost 
                         WHERE rownum <8) 
                   WHERE rnum <=chk 
                 ), 
                (SELECT rlane_cd,trd_cd,slan_cd,ioc_cd,dir_cd FROM coa_lane_rgst WHERE rlane_cd = 'RBCCO') 
           WHERE slane     = 'RBC' 
             AND ioc       = ioc_cd 
             AND bound     = dir_cd 
         ) b 
    ON (    a.trd_cd     = b.trd_cd 
        AND a.rlane_cd   = b.rlane_cd 
        AND a.ioc_cd     = b.ioc 
        AND a.vsl_cd     = b.vsl 
        AND a.skd_voy_no = b.voyage 
        AND a.dir_cd     = b.bound 
       ) 
    WHEN MATCHED THEN 
        UPDATE 
        SET a.cost_yrmon       = DECODE(NVL(mon_tgt_flg,'N'), 'N', b.yyyymm, a.cost_yrmon) 
           ,a.cost_wk          = DECODE(NVL(wky_mnl_flg,'P'), 'P', b.cost_wk, a.cost_wk) 
           ,a.slan_cd          = b.slan_cd 
           ,a.lst_lodg_port_cd = loading_port 
           ,a.ioc_rule_desc    = b.ioc_rule 
           ,a.wky_tgt_flg      = DECODE(NVL(wky_tgt_flg,'N'),'Y','Y',DECODE(in_ind,'COA','Y','N')) 
           ,a.wky_mnl_flg      = DECODE(in_ind,'COA', DECODE(NVL(a.wky_mnl_flg,'P'), 'P', 'A', a.wky_mnl_flg),a.wky_mnl_flg) 
           ,a.mon_tgt_flg      = DECODE(NVL(mon_tgt_flg,'N'),'Y','Y','N','N') 
           ,a.delt_flg         = 'N' 
           ,a.upd_usr_id       = in_user_id 
           ,a.upd_dt           = sysdate 
    WHEN NOT MATCHED THEN 
        INSERT (a.trd_cd,a.rlane_cd,a.ioc_cd,a.vsl_cd,a.skd_voy_no,a.dir_cd,a.cost_yrmon,a.cost_wk,a.slan_cd 
               ,a.lst_lodg_port_cd,a.ioc_rule_desc 
               ,a.wky_tgt_flg,a.wky_mnl_flg, a.mon_tgt_flg,a.delt_flg 
               ,a.cre_usr_id,a.cre_dt,a.upd_usr_id,a.upd_dt) 
        VALUES (b.trd_cd,b.rlane_cd,b.ioc,b.vsl,b.voyage,b.bound,b.yyyymm,b.cost_wk,b.slan_cd, 
                b.loading_port,b.ioc_rule 
                ,DECODE(in_ind,'COA','Y','N'),DECODE(in_ind,'COA','A','P'),'N','N' 
                ,in_user_id,SYSDATE,in_user_id,SYSDATE) 
    ; 
    enis_log_prc (sysdate, v_log_mod_nm, v_appl_info,''); 
    -- -------------------------------------------------------------------------------------------- 
     
    -- -------------------------------------------------------------------------------------------- 
    -- 4. 영업관점의 년월을 변경한다. 
    -- COA_MON_VVD.SLS_YRMON를 해당 주차를 일괄 업데이트한다. 
    -- Weekly 확정 이전까지만 변경하도록 수정[2008.02.05] 
    -- Weekly 확정 전 : lst_lodg_port_etd_dt가 없을경우는 cost_yrmon으로 대체한다 
    -- Weekly 확정 후 : sls_yrmon을 입력 만약 sls_yrmon이 null일경우 cost_yrmon을 입력 
    -- -------------------------------------------------------------------------------------------- 
    v_appl_info := '4.SLS_YRMON Input.'; 
    UPDATE coa_mon_vvd  a
       SET sls_yrmon = DECODE(wky_tgt_flg, 'N', NVL2(lst_lodg_port_etd_dt, 
--                                              TO_CHAR(lst_lodg_port_etd_dt, 'YYYYMM') --2015.01.21
                                              (SELECT DECODE(cost_yr, SUBSTR(wk.sls_fm_dt, 1,4) ,substr(wk.sls_fm_dt, 1,6),substr(wk.sls_to_dt, 1,6))
                                                 FROM coa_wk_prd wk
                                                WHERE TO_CHAR(trunc(a.lst_lodg_port_etd_dt),'YYYYMMDD') BETWEEN wk.sls_fm_dt AND wk.sls_to_dt )                                              
                                              , cost_yrmon) 
                                              , NVL(sls_yrmon,cost_yrmon) --  
                              ) 
     WHERE cost_yrmon in ( 
                            SELECT DISTINCT DECODE(rnum, 1, SUBSTR(sls_fm_dt,1,6), 2, SUBSTR(sls_to_dt,1,6))  yrmon 
                              FROM ( 
                                   SELECT sls_fm_dt, sls_to_dt 
                                     FROM coa_wk_prd 
                                    WHERE cost_yr || cost_wk  >= in_year || in_fm_wk 
                                    ORDER BY sls_fm_dt 
                                   ) a 
                                  ,(SELECT ROWNUM rnum FROM com_cpy_no WHERE ROWNUM < 3) b 
                             WHERE 1=1 
                               AND rownum   <= in_duration 
                         ) 
       AND trd_cd      = NVL(in_trd_cd    , trd_cd) 
       AND rlane_cd    = NVL(in_rlane_cd  , rlane_cd) 
       AND ioc_cd      = NVL(in_ioc_cd    , ioc_cd) 
       AND vsl_cd      = NVL(in_vsl_cd    , vsl_cd) 
       AND skd_voy_no  = NVL(in_skd_voy_no, skd_voy_no) 
       AND dir_cd      = NVL(in_dir_cd    , dir_cd) 
    -- -------------------------------------------------------------------------------------------- 
    ; 
    enis_log_prc (sysdate, v_log_mod_nm, v_appl_info,''); 
 
 
     
    -- -------------------------------------------------------------------------------------------- 
    -- 5.Sub Trade Update[Ocean, IES 역내구간 정보] 
    -- COA_MON_VVD.SUB_TRD_CD를 해당 주차를 일괄 업데이트한다. 
    -- -------------------------------------------------------------------------------------------- 
    v_appl_info := '5.Sub Trade Update.'; 
    UPDATE coa_mon_vvd b 
       SET b.sub_trd_cd = (SELECT sub_trd_cd 
                             FROM coa_lane_rgst a 
                            WHERE a.rlane_cd = b.rlane_cd 
                              AND a.dir_cd   = b.dir_cd 
                              AND a.trd_cd   = b.trd_cd 
                              AND a.ioc_cd   = b.ioc_cd 
                          ) 
     WHERE SUBSTR(b.cost_yrmon,1,4)||b.cost_wk   
        IN ( 
            SELECT distinct cost_yr || cost_wk 
              FROM ( 
                   SELECT cost_yr, cost_wk, sls_fm_dt, sls_to_dt 
                     FROM coa_wk_prd 
                    WHERE cost_yr || cost_wk  >= in_year || in_fm_wk 
                    ORDER BY sls_fm_dt 
                   )  
             WHERE 1=1 
               AND rownum   <= in_duration 
           ) 
       AND b.trd_cd      = NVL(in_trd_cd    , b.trd_cd) 
       AND b.rlane_cd    = NVL(in_rlane_cd  , b.rlane_cd) 
       AND b.ioc_cd      = NVL(in_ioc_cd    , b.ioc_cd) 
       AND b.vsl_cd      = NVL(in_vsl_cd    , b.vsl_cd) 
       AND b.skd_voy_no  = NVL(in_skd_voy_no, b.skd_voy_no) 
       AND b.dir_cd      = NVL(in_dir_cd    , b.dir_cd)    
    -- -------------------------------------------------------------------------------------------- 
    ; 
    enis_log_prc (sysdate, v_log_mod_nm, '5.Sub Trade Update.',''); 
 
    -- -------------------------------------------------------------------------------------------- 
    -- 6. COA_VSL_RGST에 VESSEL 정보를 insert/update (기준 : COA_MON_VVD와 COA_VSL_INFO 기준으로) 
    -- -------------------------------------------------------------------------------------------- 
    v_appl_info := '6.Vessel Register Update'; 
    MERGE INTO coa_vsl_rgst a 
    USING 
    ( 
        SELECT DISTINCT  
               a.vsl_cd 
              ,b.crr_cd 
              ,NVL(d.vsl_clss_capa,b.cntr_vsl_clss_capa) vsl_clss_capa 
              ,NVL(d.vsl_dznd_capa,b.cntr_dzn_capa) vsl_dznd_capa 
              ,NVL(d.vsl_rgst_cnt_cd, b.vsl_rgst_cnt_cd) vsl_rgst_cnt_cd 
              ,NVL(d.lst_flg,'N') lst_flg
              ,CASE WHEN B.CRR_CD = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC THEN 'NYK'
               ELSE 'OTH'
               END OPR1
              ,CASE WHEN B.CRR_CD = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC AND VSL_OWN_IND_CD = 'O' THEN 'OWN'
                    WHEN B.CRR_CD = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC AND VSL_OWN_IND_CD = 'C' THEN 'CHT'
               ELSE 'OTH'
               END  OPR2
          FROM coa_mon_vvd a 
              ,mdm_vsl_cntr b 
              ,coa_lane_rgst c 
              ,coa_vsl_rgst d 
         WHERE SUBSTR(a.cost_yrmon,1,4)||a.cost_wk  
           IN ( 
                SELECT distinct cost_yr || cost_wk 
                  FROM ( 
                       SELECT cost_yr, cost_wk, sls_fm_dt, sls_to_dt 
                         FROM coa_wk_prd 
                        WHERE cost_yr || cost_wk  >= in_year || in_fm_wk 
                        ORDER BY sls_fm_dt 
                       )  
                 WHERE 1=1 
                   AND rownum   <= in_duration 
              ) 
           AND a.vsl_cd         = b.vsl_cd 
           AND a.trd_cd         = c.trd_cd 
           AND a.rlane_cd       = c.rlane_cd 
           AND a.dir_cd         = c.dir_cd 
           AND a.ioc_cd         = c.ioc_cd 
           AND a.vsl_cd         = d.vsl_cd(+) 
           AND c.vsl_lane_tp_cd = 'JO' 
           AND a.delt_flg       = 'N'
           AND d.delt_flg(+)    = 'N'
           AND d.lst_flg(+)     = 'Y'
           AND a.trd_cd      = NVL(in_trd_cd    , a.trd_cd) 
           AND a.rlane_cd    = NVL(in_rlane_cd  , a.rlane_cd) 
           AND a.ioc_cd      = NVL(in_ioc_cd    , a.ioc_cd) 
           AND a.vsl_cd      = NVL(in_vsl_cd    , a.vsl_cd) 
           AND a.skd_voy_no  = NVL(in_skd_voy_no, a.skd_voy_no) 
           AND a.dir_cd      = NVL(in_dir_cd    , a.dir_cd) 
            
    ) b 
    ON (a.vsl_cd = b.vsl_cd ) /* JO 노선인 경우에만 Vessel Register Table에 Insert or Update 한다 */ 
    WHEN MATCHED THEN 
        UPDATE 
           SET a.vsl_rgst_cnt_cd = b.vsl_rgst_cnt_cd
              ,a.vsl_dznd_capa   = b.vsl_dznd_capa
--              ,a.vsl_clss_capa   = b.vsl_clss_capa  추후 협의 후 반영해야 함. 2010.04.02

              /*AOM Ticket ID - CHM-201004427-01
                20100616 ==>  From date, to date, carrier code 정보 업데이트*/
              ,a.crr_cd         = b.crr_cd
              ,a.vsl_aply_fm_dt = nvl((SELECT MIN(vps_etd_dt) etd_dt
                                   FROM   vsk_vsl_port_skd vsk
                                   WHERE  vsk.vsl_cd = substr(a.vvd_cd, 1, 4) AND
                                          vsk.skd_voy_no = substr(a.vvd_cd, 5, 4) AND
                                          vsk.skd_dir_cd = substr(a.vvd_cd, 9, 1)),a.vsl_aply_fm_dt)
              ,a.vsl_aply_to_dt = nvl((SELECT MIN(vps_etd_dt)-1 etd_dt
                                      FROM   coa_vsl_rgst     c
                                            ,vsk_vsl_port_skd vsk
                                      WHERE  c.vsl_cd = a.vsl_cd 
                                      AND    c.vsl_seq = (SELECT MIN(z.vsl_seq)
                                                           FROM   coa_vsl_rgst z
                                                           WHERE  z.vsl_cd = a.vsl_cd AND z.vsl_seq > a.vsl_seq) 
                                      AND    vsk.vsl_cd = substr(c.vvd_cd, 1, 4) 
                                      AND    vsk.skd_voy_no =  substr(c.vvd_cd, 5, 4) 
                                      AND    vsk.skd_dir_cd =  substr(c.vvd_cd, 9, 1)), a.vsl_aply_to_dt)                               
              ,a.upd_usr_id      = in_user_id 
              ,a.vsl_tp_cd       = 'C' 
              ,a.upd_dt          = SYSDATE 
        WHEN NOT MATCHED THEN 
        INSERT (vsl_seq,vsl_cd,vsl_tp_cd,vsl_oshp_cd,vop_cd,crr_cd,
                vsl_rgst_cnt_cd,stnd_ldb_capa,vsl_clss_capa, 
                trd_chk_flg,vsl_dznd_capa,vsl_prc,vsl_prc_rto, 
                vsl_retn_fm_dt,vsl_retn_to_dt, 
                delt_flg,lst_flg, vsl_aply_fm_dt, vsl_aply_to_dt, 
                cre_usr_id,cre_dt,upd_usr_id,upd_dt) 
        VALUES ('1',b.vsl_cd,'C',B.OPR2,B.OPR1,b.crr_cd
               ,b.vsl_rgst_cnt_cd,0,b.vsl_clss_capa 
               ,'N',b.vsl_dznd_capa,0,0 
               ,SYSDATE, TO_DATE('99991231','YYYYMMDD')
               ,'N','Y',SYSDATE, TO_DATE('99991231','YYYYMMDD')
               ,in_user_id,SYSDATE,in_user_id,SYSDATE) 
    ; 
    -- --------------------------------------------------------------------------------------------         
    enis_log_prc (sysdate, v_log_mod_nm, '6.Vessel Register Update.',''); 
 
    enis_log_prc (sysdate, v_log_mod_nm, 'END 1:' || v_cnt); 
    enis_log_prc (SYSDATE, v_log_mod_nm, 'Total Required : ' || TO_CHAR(SYSTIMESTAMP - v_start_time1, 'yyyy/mm/dd hh24:mi:ss.ff')); 
    
  -- -------------------------------------------------------------------------------------------- 
    -- 7. AR_MST_REV_VVD 에 VVD 정보를 INTERFACE 해준다. (comment. 2015.01.19)
    -- -------------------------------------------------------------------------------------------- 
--    v_appl_info := '7.AR_MST_REV_VVD Update'; 
--    
--    MERGE INTO AR_MST_REV_VVD A
--USING(
--SELECT F.VSL_CD
--                       , F.SKD_VOY_NO
--                       , F.SKD_DIR_CD
--                       , F.FNC_DIR_CD
--                       , F.VSL_LANE_TP_CD
--                       , F.SLAN_CD
--                       , F.LST_LODG_PORT_CD
--                       , F.COST_YRMON
--                       , F.RLANE_CD
--FROM (
--    SELECT DISTINCT A.VSL_CD
--                       , A.SKD_VOY_NO
--                       , A.DIR_CD SKD_DIR_CD
--                       , A.DIR_CD FNC_DIR_CD
--                       , (SELECT MAX(VSL_LANE_TP_CD) FROM COA_LANE_RGST C WHERE A.RLANE_CD = C.RLANE_CD AND A.DIR_CD = C.DIR_CD) VSL_LANE_TP_CD
--                       , A.SLAN_CD
--                       , A.LST_LODG_PORT_CD
--                       , A.COST_YRMON
--                       , A.RLANE_CD
--                       , RANK() OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD ORDER BY A.IOC_CD DESC, A.RLANE_CD) RNK
--    FROM COA_MON_VVD A,
--             (   SELECT VSL_CD
--                       , SKD_VOY_NO
--                       , DIR_CD
--                       , SLAN_CD
--                       , MAX(LST_LODG_PORT_ETD_DT) LST_LODG_PORT_ETD_DT
--                       , MAX(COST_YRMON) COST_YRMON
--                FROM COA_MON_VVD C
--                WHERE 1=1
--                  AND C.DELT_FLG = 'N'
--                  AND C.VSL_CD NOT LIKE 'FD%'
--                  AND SUBSTR(C.cost_yrmon,1,4)||C.cost_wk   
--                                                IN ( 
--                                                    SELECT distinct cost_yr || cost_wk 
--                                                      FROM ( 
--                                                           SELECT cost_yr, cost_wk, sls_fm_dt, sls_to_dt 
--                                                             FROM coa_wk_prd 
--                                                            WHERE cost_yr || cost_wk  >= in_year || in_fm_wk 
--                                                            ORDER BY sls_fm_dt 
--                                                           )  
--                                                     WHERE 1=1 
--                                                       AND rownum   <= in_duration 
--                                                   ) 
--                GROUP BY VSL_CD
--                       , SKD_VOY_NO
--                       , DIR_CD
--                       , SLAN_CD ) B
--    WHERE 1=1
--    AND A.DELT_FLG = 'N'
--    AND A.VSL_CD = B.VSL_CD
--    AND A.SKD_VOY_NO = B.SKD_VOY_NO
--    AND A.DIR_CD = B.DIR_CD
--    AND A.SLAN_CD = B.SLAN_CD
--    AND A.LST_LODG_PORT_ETD_DT = B.LST_LODG_PORT_ETD_DT
--    AND A.COST_YRMON = B.COST_YRMON) F
--WHERE RNK = 1
--) B
--ON (A.VSL_CD = B.VSL_CD
--    AND A.SKD_VOY_NO = B.SKD_VOY_NO
--    AND A.SKD_DIR_CD = B.SKD_DIR_CD
--    AND A.RLANE_DIR_CD = B.FNC_DIR_CD
--   )
--WHEN MATCHED THEN 
--        UPDATE 
--        SET A.VOY_TP_CD = B.VSL_LANE_TP_CD
--          , A.SLAN_CD   = B.SLAN_CD
--          , PORT_CHK_FLG = 'Y'
--          , REV_PORT_CD = B.LST_LODG_PORT_CD
--          , LOD_QTY    = 0.000
--          , REV_YRMON  = B.COST_YRMON
--          , COM_VVD_FLG = 'N'
--          , VVD_COM_LVL = '1'
--          , RLANE_CD = B.RLANE_CD
--          , DELT_FLG = 'N'
--          , UPD_DT   = SYSDATE
--          , UPD_USR_ID = 'SYSTEM'
--WHEN NOT MATCHED THEN 
--    INSERT ( A.VSL_CD
-- ,A.SKD_VOY_NO
-- ,A.SKD_DIR_CD
-- ,A.RLANE_DIR_CD
-- ,A.VOY_TP_CD
-- ,A.SLAN_CD
-- ,A.PORT_CHK_FLG
-- ,A.REV_PORT_CD
-- ,A.LOD_QTY
-- ,A.REV_YRMON
-- ,A.COM_VVD_FLG
-- ,A.VVD_COM_LVL
-- ,A.RLANE_CD
-- ,A.DELT_FLG
-- ,A.CRE_USR_ID
-- ,A.CRE_DT
-- ,A.UPD_USR_ID
-- ,A.UPD_DT
--)
--VALUES
--(B.VSL_CD
--       ,B.SKD_VOY_NO
--       ,B.SKD_DIR_CD
--       ,B.FNC_DIR_CD
--       ,B.VSL_LANE_TP_CD
--       ,B.SLAN_CD
--       ,'Y'
--       ,B.LST_LODG_PORT_CD
--       ,0.000
--       ,B.COST_YRMON
--       ,'N'
--       ,'1'
--       ,B.RLANE_CD
--       ,'N'
--       ,'SYSTEM'
--       , SYSDATE
--       ,'SYSTEM'
--       , SYSDATE
--
--)
--;
--
--IF TO_CHAR(SYSDATE,'YYYYMM') <> TO_CHAR(SYSDATE+1, 'YYYYMM')
--THEN 
--
--MERGE INTO AR_MST_REV_VVD A
--USING(
--SELECT VSL_CD, SUBSTR(TO_CHAR(SYSDATE+1, 'YYYYMM'),3,4) SKD_VOY_NO, SKD_DIR_CD, RLANE_DIR_CD, VOY_TP_CD, SLAN_CD, PORT_CHK_FLG, REV_PORT_CD, LOD_QTY, REV_YRMON, COM_VVD_FLG, VVD_COM_LVL, RLANE_CD, DELT_FLG, CRE_USR_ID, CRE_DT, EAI_EVNT_DT, UPD_USR_ID, UPD_DT
--FROM AR_MST_REV_VVD B
-- WHERE 1=1
--   AND B.VSL_CD IN ('CFDR', 'CNTC')
--   AND B.REV_YRMON = TO_CHAR(SYSDATE, 'YYYYMM')
--   ) B
--ON ( A.VSL_CD = B.VSL_CD
--   AND A.SKD_VOY_NO = B.SKD_VOY_NO
--   AND A.SKD_DIR_CD = B.SKD_DIR_CD
--   AND A.RLANE_DIR_CD = B.RLANE_DIR_CD
--   )
--WHEN NOT MATCHED THEN 
--INSERT (
--    VSL_CD, SKD_VOY_NO, SKD_DIR_CD, RLANE_DIR_CD, VOY_TP_CD, SLAN_CD, PORT_CHK_FLG, REV_PORT_CD, LOD_QTY, REV_YRMON, COM_VVD_FLG, VVD_COM_LVL, RLANE_CD, DELT_FLG, CRE_USR_ID, CRE_DT, EAI_EVNT_DT, UPD_USR_ID, UPD_DT
--)
--VALUES
--(
--    B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.RLANE_DIR_CD, B.VOY_TP_CD, B.SLAN_CD, B.PORT_CHK_FLG, B.REV_PORT_CD, B.LOD_QTY, B.REV_YRMON, B.COM_VVD_FLG, B.VVD_COM_LVL, B.RLANE_CD, B.DELT_FLG, B.CRE_USR_ID, B.CRE_DT, B.EAI_EVNT_DT, B.UPD_USR_ID, B.UPD_DT
--)
--;
--END IF;
--
--
--enis_log_prc (sysdate, v_log_mod_nm, '7.AR_MST_REV_VVD Update.',''); 
     
    /* 성공적으로 항차 생성 완료시 */ 
    p_error_code := '00000'; 
    p_error_msg  := 'Completed!'; 
 
--    COMMIT; 
-----------------[ 예외처리부            ]----------------------- 
   EXCEPTION 
     WHEN OTHERS THEN 
         p_error_code   := SQLCODE; 
         p_error_msg    := v_appl_info||'[' || v_log_desc || '] >>> '||SQLERRM; 
         enis_log_prc (sysdate, v_log_mod_nm, 'Error >>['||p_error_code||']['||p_error_msg||']'); 
END COA_CREATE_TARGET_VVD_PRC;