CREATE OR REPLACE PROCEDURE OPUSADM.COA_CREATE_OPERATION_DAYS_PRC (
   in_yr         IN       VARCHAR2
  ,in_fm_wk      IN       VARCHAR2
  ,in_duration   IN       VARCHAR2
  ,in_usr_id     IN       VARCHAR2
  ,out_err_cd    OUT      VARCHAR2
  ,out_err_msg   OUT      VARCHAR2
)
Authid current_user
IS
   --DECLARE
   --   out_err_cd   VARCHAR2(4000);
   --   out_err_msg    VARCHAR2(4000);
   --BEGIN
   --   coa_create_operation_days_prc('2008', '14', 'SYS_COA_PCS', out_err_cd, out_err_msg);
   --   commit; -- 생성시간: 5초
   --END;

   --SELECT *
   --  FROM enis_log
   -- WHERE mod_name = 'COA_CREATE_OPERATION_DAYS_PRC'
   --   AND exec_dt > SYSDATE - 1 / 24
   --ORDER BY exec_dt DESC

   /*
     1.Description:
         - 용도: 대상항차 기준의 Schedule의 Port간 운항 일수를 생성
                 COA_MON_VVD_PORT_OP_DYS 데이터 생성
         - 파라미터: 년도,주차                         
   */
   ------------------------------[ 변수선언부             ]-----------------------
   v_cost_yrwk_min   VARCHAR2 (6);
   v_cost_yrwk_max   VARCHAR2 (6);
   v_min_yrwk        VARCHAR2 (6);
   v_max_yrwk        VARCHAR2 (6);
   
    --------------------------------------------------------------------------------
   
   /** Lane 구간별 운항일수 생성 **/
   CURSOR port_pair_days_cur(
      v_trd_cd       VARCHAR2
     ,v_rlane_cd     VARCHAR2
     ,v_ioc_cd       VARCHAR2
     ,v_vsl_cd       VARCHAR2
     ,v_skd_voy_no   VARCHAR2
     ,v_dir_cd       VARCHAR2
     ,v_slan_cd      VARCHAR2
   ) IS
      SELECT e1.trd_cd
            ,e1.vsl_cd
            ,e1.skd_voy_no
            ,e1.skd_dir_cd
            ,e1.vps_port_cd
            ,e1.slan_cd
            ,e1.rlane_cd
            ,e1.ioc_cd
            ,e1.port_days
            ,e1.sea_days
            ,e1.vps_etd_dt
            ,e1.clpt_seq
            ,e1.clpt_ind_seq
            ,e1.nxt_conti_cd
            ,e1.conti_cd
            ,e1.nxt_sconti_cd
            ,e1.sconti_cd            
            ,
             -- 1. 대륙이 바뀌는 경우 운항일수 100% 적용            
             CASE
                WHEN(e1.conti_cd <> e1.nxt_conti_cd)
                THEN 'Y'
                WHEN (e1.is_pre_egsuz = 'Y' OR e1.is_pre_papac = 'Y' OR e1.is_turn_ind_chng='Y') THEN 'Y'
                ELSE 'N'
             END is_sea_dys_100_pct
            ,
             -- egsuz_rto > papac_rto > pndlm_rto > other_rto 우선순위로 Ratio 결정함
             DECODE(SIGN(e1.egsuz_rto)
                    ,1, e1.egsuz_rto
                       ,DECODE(SIGN(e1.papac_rto)
                                 ,1, e1.papac_rto
                                 ,DECODE(SIGN(e1.pndlm_rto), 1, e1.pndlm_rto, e1.other_rto)
                              )
                   ) rto
            ,DECODE(SIGN(e1.egsuz_rto)
                      ,1, 'egsuz_rto'
                          ,DECODE(SIGN(e1.papac_rto)
                                 ,1, 'papac_rto'
                                 ,DECODE(SIGN(e1.pndlm_rto), 1, 'pndlm_rto', 'other_rto')
                          )
                   ) aply_rto_nm
            ,e1.turn_port_ind_cd
            ,e1.nxt_turn_port_ind_cd
        FROM (
              SELECT   v_trd_cd trd_cd
                      ,d1.clpt_ind_seq
                      ,d1.vsl_cd
                      ,d1.skd_voy_no
                      ,d1.skd_dir_cd
                      ,d1.vps_port_cd
                      ,d1.slan_cd
                      ,v_rlane_cd rlane_cd
                      ,v_ioc_cd ioc_cd
                      ,d2.port_days
                      ,d2.sea_days
                      ,d1.vps_etd_dt
                      ,d1.clpt_seq
                      ,LEAD(d1.conti_cd) OVER(ORDER BY d1.vsl_cd, d1.skd_voy_no, d1.skd_dir_cd, d1.clpt_ind_seq
                       ,d1.clpt_seq) nxt_conti_cd
                      ,LEAD(d1.sconti_cd) OVER(ORDER BY d1.vsl_cd, d1.skd_voy_no, d1.skd_dir_cd, d1.clpt_ind_seq
                       ,d1.clpt_seq) nxt_sconti_cd
                      ,d1.conti_cd
                      ,d1.sconti_cd                     
                      ,
                       -- 수에즈/파나마 운하 Apply Ratio 100%
                       CASE
                          WHEN(d1.vps_port_cd = 'EGSUZ') THEN 1
                          ELSE 0
                       END egsuz_rto
                      ,
                       CASE
                          WHEN(d1.vps_port_cd = 'PAPAC') THEN 1
                          ELSE 0
                       END papac_rto
                      ,
                       -- 대륙을 3개를 운항하는 VVD - Apply Ratio 0.5 적용              2007.09.17 BY LHI
                       CASE
                          WHEN d2.pndlm_conti_cnt >= 3 THEN 0.5
                          ELSE 0
                       END pndlm_rto
                      ,
                       -- d3.turn_port_ind_cd 또는 d1.turn_port_ind_cd 가 'Y' 이면 Ratio는 0.5
                       CASE
                          WHEN NVL(d3.turn_port_ind_cd, d1.turn_port_ind_cd) = 'N' THEN 1
                          ELSE 0.5
                       END other_rto
                      ,d1.turn_port_ind_cd
                      ,LEAD(d1.turn_port_ind_cd) OVER(ORDER BY d1.vsl_cd, d1.skd_voy_no, d1.skd_dir_cd, d1.clpt_ind_seq
                       ,d1.clpt_seq) nxt_turn_port_ind_cd
                      ,
                       -- E B/D 이고 앞포트가 EGSUZ 이면 100%
                       -- W B/D 이고 앞포트가 PAPAC 이면 100%
                       CASE
                          WHEN(    d1.skd_dir_cd = 'E'
                               AND LEAD(d1.vps_port_cd) OVER(ORDER BY d1.vsl_cd, d1.skd_voy_no, d1.skd_dir_cd
                                   ,d1.clpt_ind_seq, d1.clpt_seq) = 'EGSUZ'
                              ) THEN 'Y'
                          ELSE 'N'
                       END is_pre_egsuz
                      ,
                       CASE
                          WHEN(    d1.skd_dir_cd = 'W'
                               AND LEAD(d1.vps_port_cd) OVER(ORDER BY d1.vsl_cd, d1.skd_voy_no, d1.skd_dir_cd
                                   ,d1.clpt_ind_seq, d1.clpt_seq) = 'PAPAC'
                              ) THEN 'Y'
                          ELSE 'N'
                       END is_pre_papac
                       ,
                        --Turn indicator 가 Y,D,V -> N 으로 바뀌는 Asia 구간의 앞 port이면 100%
                       CASE
                          WHEN(    d1.turn_port_ind_cd in ('Y','D','V')
                               AND d1.conti_cd='A'
                               AND LEAD(d1.turn_port_ind_cd) OVER(ORDER BY d1.vsl_cd, d1.skd_voy_no, d1.skd_dir_cd
                                   ,d1.clpt_ind_seq, d1.clpt_seq) ='N'
                              ) THEN 'Y'
                          ELSE 'N'
                       END is_turn_ind_chng

                  FROM (
                        -- 해당 VVD가 운항되는 대륙 선별                                 2007.09.17 BY LHI
                        SELECT   b1.clpt_ind_seq
                                ,b1.vsl_cd
                                ,b1.skd_voy_no
                                ,b1.skd_dir_cd
                                ,b1.vps_port_cd
                                ,b1.slan_cd
                                ,b2.conti_cd conti_cd
                                ,b1.vps_etd_dt
                                ,b1.clpt_seq
                                ,b1.turn_port_ind_cd
                                ,b2.sconti_cd
                            FROM vsk_vsl_port_skd b1
                                ,(SELECT loc_cd
                                        ,conti_cd
                                        ,sconti_cd
                                    FROM mdm_location) b2
                                ,(SELECT DISTINCT DECODE(NO, 1, fm_conti_cd, to_conti_cd) conti_cd   -- 행이 (E),(E,F,A) 이렇게 여러가지 나옴
                                             FROM (SELECT DISTINCT  fm_conti_cd
                                                                  , to_conti_cd
                                                              FROM mdm_dtl_rev_lane
                                                             WHERE rlane_cd        = v_rlane_cd
                                                               AND vsl_slan_dir_cd = v_dir_cd
                                                               AND trd_cd          = v_trd_cd
                                                               AND ioc_cd          = v_ioc_cd
                                                               AND delt_flg        = 'N') a1
                                                 ,(SELECT cpy_no NO
                                                     FROM com_cpy_no
                                                    WHERE cpy_no BETWEEN 1 AND 2) a2) b3
                           WHERE b1.vsl_cd      = v_vsl_cd
                             AND b1.skd_voy_no  = v_skd_voy_no
                             AND b1.skd_dir_cd  = v_dir_cd
                             AND NVL(b1.skd_cng_sts_cd, '*') <> 'S'
                             AND b1.vps_port_cd = b2.loc_cd
                             AND b2.conti_cd    = b3.conti_cd   -- RLANE 이 걸쳐 있는 대륙만 대상으로 잡는다.
                        ORDER BY vps_etd_dt
                       ) d1
                      ,(
                        -- Port Days, Sea Days 산출                                2007.09.17 BY LHI
                        SELECT c1.slan_cd
                              ,c1.vsl_cd
                              ,c1.skd_voy_no
                              ,c1.skd_dir_cd
                              ,c1.vps_port_cd
                              ,c1.clpt_ind_seq
                              ,c1.vps_eta_dt
                              ,c1.vps_etd_dt
                              ,c1.pndlm_conti_cnt
                              , c1.vps_etd_dt - c1.vps_eta_dt port_days
                              ,NVL(c1.sea_days, 0) sea_days
                              ,c1.clpt_seq
                          FROM (
                                SELECT b1.seq
                                      ,b1.slan_cd
                                      ,b1.vsl_cd
                                      ,b1.skd_voy_no
                                      ,b1.skd_dir_cd
                                      ,b1.vps_port_cd
                                      ,b1.clpt_ind_seq
                                      ,b1.clpt_seq
                                      ,b1.vps_eta_dt
                                      ,b1.vps_etd_dt
                                      ,b1.turn_port_ind_cd
                                      ,b1.turn_skd_voy_no
                                      ,b1.turn_skd_dir_cd
                                      ,b1.pndlm_conti_cnt
                                      -- 다음 PORT 도착일시 - 현재 PORT 출발일시
                                      ,LEAD(b1.vps_eta_dt) OVER(ORDER BY b1.vps_etd_dt) - b1.vps_etd_dt sea_days
                                  FROM (
                                        /* 각 Lane의 Port별 List를 만든다. 겹치는 구간 제외 */
                                        SELECT   ROW_NUMBER() OVER(PARTITION BY    a1.vps_port_cd
                                                                                || TO_CHAR(a1.vps_etd_dt
                                                                                          ,'YYYYMMDDHH24MISS'
                                                                                          ) ORDER BY a1.vps_etd_dt, DECODE(a1.skd_dir_cd,v_dir_cd,1,2)) cnt
                                                ,a2.vsl_slan_dir_seq seq
                                                ,a1.slan_cd
                                                ,a1.vsl_cd
                                                ,a1.skd_voy_no
                                                ,a1.skd_dir_cd
                                                ,a1.vps_port_cd
                                                ,a1.clpt_ind_seq
                                                ,a1.clpt_seq
                                                ,a1.vps_eta_dt
                                                ,a1.vps_etd_dt
                                                ,a1.turn_port_ind_cd
                                                ,a1.turn_skd_voy_no
                                                ,a1.turn_skd_dir_cd
                                                ,
                                                 -- pndlm 의 대륙 갯수
                                                 -- EGSUZ, EGPSD 를 Asia 로 인식
                                                 -- AEC : EGSUZ 를 원대륙으로 처리해서 펜듈럼 처리한다.
                                                 -- INX, RES노선의 F->A, AEC노선은 F->F, 나머지 타노선은 F->E으로 변환한다.
                                                 COUNT(DISTINCT a3.conti_cd)OVER(PARTITION BY a1.vsl_cd, a1.skd_voy_no) pndlm_conti_cnt
                                            FROM vsk_vsl_port_skd a1
                                                ,mdm_vsl_svc_lane_dir a2
                                                ,mdm_location a3
                                           WHERE a1.vsl_cd      = v_vsl_cd
                                             AND a1.skd_voy_no IN (v_skd_voy_no)
                                             AND NVL(a1.skd_cng_sts_cd, '*') <> 'S'
                                             AND a1.slan_cd     = a2.vsl_slan_cd
                                             AND a1.skd_dir_cd  = a2.vsl_slan_dir_cd
                                             AND a1.vps_port_cd = a3.loc_cd
                                        ORDER BY a1.skd_voy_no, a2.vsl_slan_dir_seq, a1.skd_dir_cd, a1.clpt_seq
                                      ) b1
                                 WHERE TRIM(b1.cnt) = 1
                              ) c1
                         WHERE DECODE(c1.skd_voy_no
                                     ,v_skd_voy_no, c1.skd_voy_no
                                     ,DECODE(c1.skd_dir_cd
                                            ,NVL(c1.turn_skd_dir_cd, c1.skd_dir_cd), c1.skd_voy_no
                                            ,v_skd_voy_no
                                            )
                                     ) = v_skd_voy_no
                        ) d2
                      ,(
                        -- Turn Port Indicate는 Long Range SKD 보다 Profoma SKD 를 기준으로 한다.
                        SELECT vsl_slan_cd
                              ,port_cd
                              ,skd_dir_cd
                              ,clpt_seq
                              ,turn_port_ind_cd 
                          FROM vsk_pf_skd_dtl
                         WHERE (vsl_slan_cd, pf_svc_tp_cd) IN(
                                           SELECT vsl_slan_cd
                                                 ,MAX(pf_svc_tp_cd)   -- 년도, CAPA, 코드 등으로 복합 데이터임
                                               --향후 유저협의후 마지막 생성일 기준으로 변경 필요할것 같음 2008.03.03
                                             FROM vsk_pf_skd
                                            WHERE vsl_slan_cd = v_slan_cd
                                              AND slan_stnd_flg = 'Y'
                                            GROUP BY vsl_slan_cd)
                      ) d3
                 WHERE d1.slan_cd      = d2.slan_cd
                   AND d1.vsl_cd       = d2.vsl_cd
                   AND d1.vps_port_cd  = d2.vps_port_cd
                   AND d1.clpt_ind_seq = d2.clpt_ind_seq
                   AND d1.vps_etd_dt   = d2.vps_etd_dt
                   AND d1.slan_cd      = d3.vsl_slan_cd(+)
                   AND d1.skd_dir_cd   = d3.skd_dir_cd(+)
                   AND d1.vps_port_cd  = d3.port_cd(+)
                   AND d1.clpt_ind_seq = d3.clpt_seq(+)
              ORDER BY d1.vsl_cd, d1.skd_voy_no, d1.skd_dir_cd, d1.clpt_ind_seq, d1.clpt_seq) e1;
       
   --/////////////////////////////////////////////////////////////////////////////////
   -- (!주의)
   -- IL(Israle) -> E, EGSUZ -> F, PAPAC -> M 으로 현업에서 처리함
   -- mdm_location 데이터에 이미 적용되어 있음 2008.07.05
   --/////////////////////////////////////////////////////////////////////////////////

   ------------------------------[ 변수선언부             ]-----------------------
   v_step         VARCHAR2(100);
   v_log_mod_nm   VARCHAR2(100) := 'COA_CREATE_OPERATION_DAYS_PRC';
   v_vvd_info     VARCHAR2(500);
--------------------------------[ 업무로직 구현부       ]-----------------------
BEGIN
   enis_log_prc('', v_log_mod_nm, '[V.20100510]', NULL);

   /** 시작일시 설정 **/
   v_step := 'delete';

   /** 대상 항차 테이블 기준으로 삭제 */
   SELECT   MIN(cost_yr || cost_wk), MAX(cost_yr || cost_wk)
     INTO   v_min_yrwk, v_max_yrwk
     FROM   (SELECT cost_yr, cost_wk
               FROM coa_wk_prd
    		  WHERE	cost_yr || cost_wk >= in_yr||in_fm_wk
    		  ORDER	BY COST_YR,COST_WK
    		)
    WHERE	ROWNUM <= in_duration ;

   DELETE FROM coa_mon_vvd_port_op_dys
         WHERE (trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd) IN(
                                                            SELECT trd_cd
                                                                  ,rlane_cd
                                                                  ,ioc_cd
                                                                  ,vsl_cd
                                                                  ,skd_voy_no
                                                                  ,dir_cd
                                                              FROM coa_mon_vvd
                                                             WHERE substr(sls_yrmon,1,4)||cost_wk BETWEEN v_min_yrwk AND v_max_yrwk );

   enis_log_prc('', v_log_mod_nm, 'COA_MON_VVD_PORT_OP_DYS: ' || SQL%ROWCOUNT || ' 건 삭제, sys_yrmon='||in_yr||',cost_wk='||v_min_yrwk||'~'||v_max_yrwk, NULL);
   
   FOR mon_vvd_list IN (SELECT   trd_cd
                                ,rlane_cd
                                ,ioc_cd
                                ,vsl_cd
                                ,skd_voy_no
                                ,dir_cd
                                ,slan_cd
                            FROM coa_mon_vvd
                           WHERE substr(sls_yrmon,1,4)||cost_wk BETWEEN v_min_yrwk AND v_max_yrwk
                        ORDER BY 1, 2, 3, 4, 5, 6) LOOP   /* 구간별 운항일수를 구하기 위한 대상항차 선정 */
      FOR port_pair_days_list IN port_pair_days_cur(mon_vvd_list.trd_cd
                                                   ,mon_vvd_list.rlane_cd
                                                   ,mon_vvd_list.ioc_cd
                                                   ,mon_vvd_list.vsl_cd
                                                   ,mon_vvd_list.skd_voy_no
                                                   ,mon_vvd_list.dir_cd
                                                   ,mon_vvd_list.slan_cd
                                                   ) LOOP
         v_vvd_info := port_pair_days_list.trd_cd;
         v_vvd_info := v_vvd_info || ',' || port_pair_days_list.rlane_cd;
         v_vvd_info := v_vvd_info || ',' || port_pair_days_list.ioc_cd;
         v_vvd_info :=
               v_vvd_info
            || ','
            || port_pair_days_list.vsl_cd
            || port_pair_days_list.skd_voy_no
            || port_pair_days_list.skd_dir_cd;
         v_vvd_info := v_vvd_info || ',' || port_pair_days_list.vps_port_cd;
         v_vvd_info := v_vvd_info || ',' || port_pair_days_list.clpt_ind_seq;
         v_vvd_info := v_vvd_info || ',' || ROUND(port_pair_days_list.port_days, 3);
         v_vvd_info := v_vvd_info || ',' || ROUND(port_pair_days_list.sea_days, 3);
         v_vvd_info := v_vvd_info || ',' || port_pair_days_list.rto;
         v_step := 'insert';

         INSERT INTO coa_mon_vvd_port_op_dys
                     (trd_cd
                     ,rlane_cd
                     ,ioc_cd
                     ,vsl_cd
                     ,skd_voy_no
                     ,dir_cd
                     ,loc_cd
                     ,vsl_dbl_call_seq   -- pk
                     ,slan_cd                     
                     ,ttl_tz_dys
                     ,sea_dys
                     ,port_dys
                     ,aply_voy_rto
                     ,clpt_seq
                     ,cre_usr_id
                     ,cre_dt
                     ,upd_usr_id
                     ,upd_dt
                     ,vvd_rmk
                     )
              VALUES (port_pair_days_list.trd_cd
                     ,port_pair_days_list.rlane_cd
                     ,port_pair_days_list.ioc_cd
                     ,port_pair_days_list.vsl_cd
                     ,port_pair_days_list.skd_voy_no
                     ,port_pair_days_list.skd_dir_cd
                     ,port_pair_days_list.vps_port_cd
                     ,port_pair_days_list.clpt_ind_seq   -- pk
                     ,port_pair_days_list.slan_cd                    
                     ,   ABS(  NVL(port_pair_days_list.sea_days, 0)
                             * DECODE(port_pair_days_list.is_sea_dys_100_pct, 'Y', 1, port_pair_days_list.rto)
                            )
                       + ABS(NVL(port_pair_days_list.port_days, 0) * port_pair_days_list.rto)   -- ttl_tz_dys
                     ,ABS(  NVL(port_pair_days_list.sea_days, 0)
                          * DECODE(port_pair_days_list.is_sea_dys_100_pct, 'Y', 1, port_pair_days_list.rto)
                         )   -- sea_dys
                     ,ABS(NVL(port_pair_days_list.port_days, 0) * port_pair_days_list.rto)   -- port_dys
                     ,port_pair_days_list.rto   -- aply_voy_rto
                     ,port_pair_days_list.clpt_seq
                     ,in_usr_id
                     ,SYSDATE
                     ,in_usr_id
                     ,SYSDATE
                     ,    'T.Ind:'
                       || port_pair_days_list.turn_port_ind_cd
                       || ', Port_days:'
                       || TO_CHAR(port_pair_days_list.port_days, '90.99')
                       || ', Sea_days:'
                       || TO_CHAR(port_pair_days_list.sea_days, '90.99')
                       || ', Ratio:'
                       || TO_CHAR(port_pair_days_list.rto, '0.99')
                       || ', Sea Day 100%:'
                       || port_pair_days_list.is_sea_dys_100_pct
                       || ', Apply ratio:'
                       || port_pair_days_list.aply_rto_nm
                     -- vvd_rmk
                     );
            
      END LOOP;   /* end if 구간 일수 */
      
   END LOOP;   /* end if 대상항차 */

   -- T/IPC 구간 마지막 포트 Sea Days 0로 셋팅 BY LHI 2007.07.03

   v_step := 'Last port Sea days Update';
   UPDATE coa_mon_vvd_port_op_dys
      SET ttl_tz_dys = port_dys
         ,sea_dys = 0
         ,upd_usr_id = in_usr_id
         ,upd_dt = SYSDATE
         ,vvd_rmk = vvd_rmk || ' > Last port Sea days:0'
    WHERE (trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd, vsl_dbl_call_seq, clpt_seq) IN(
             SELECT DISTINCT b.trd_cd
                            ,b.rlane_cd
                            ,b.ioc_cd
                            ,b.vsl_cd
                            ,b.skd_voy_no
                            ,b.dir_cd
                            ,b.vsl_dbl_call_seq
                            ,MAX(b.clpt_seq) OVER(PARTITION BY b.trd_cd, b.rlane_cd, b.ioc_cd, b.vsl_cd, b.skd_voy_no, b.dir_cd)
                                                                                                                max_seq
                        FROM coa_mon_vvd a, coa_mon_vvd_port_op_dys b
                       WHERE 1 = 1
                         AND a.trd_cd     = b.trd_cd
                         AND a.rlane_cd   = b.rlane_cd
                         AND a.ioc_cd     = b.ioc_cd
                         AND a.vsl_cd     = b.vsl_cd
                         AND a.skd_voy_no = b.skd_voy_no
                         AND a.dir_cd     = b.dir_cd
                         AND substr(a.sls_yrmon,1,4) || cost_wk BETWEEN v_min_yrwk AND v_max_yrwk
                         AND NVL(a.delt_flg, 'N') <> 'Y');

   -- VSL_CD, VOY_NO 기준 첫포트 0.5 Ratio 2007.07.31 BY LHI
   v_step := 'First port Ratio Update';

     
      --2009.10.08 vvd_rmk문자열길이오류로인한수정(vvd_rmk ||replace)추가
      --2009.11.17로직수정  
      -- VSL_CD, VOY_NO 기준 첫포트 0.5 Ratio
      --현재는 대륙의 마지막 port에 seadays 100%적용하는 logic과 첫번째 port일경우 seadays 50% 적용하는 logic이 동시에 적용되고 있음
      --따라서 수정사항은 위의 두가지로직이 동시에 적용될경우 대륙의 마지막 port로서 Seadays 100%적용 logic이 우선하도록 수정한다.
      --그러므로 첫번째포트는 두가지로직이 동시적용될경우 100%적용이다.
       
      /*         2010.10.08 JEONG SANG-KI
                 "Voyage 기준(단위) 1st Port" AND "Voyage 기준(단위) 대륙별 Last Port가 아닌경우" Operation Days Apply Ratio 50% 적용로직
                 - 기존로직 오류수정
      */

    UPDATE coa_mon_vvd_port_op_dys 
    SET sea_dys      = decode(aply_voy_rto,0.5,sea_dys,sea_dys * 0.5) 
       ,port_dys     = decode(aply_voy_rto,0.5,port_dys,port_dys * 0.5) 
       ,ttl_tz_dys   = decode(aply_voy_rto,0.5,ttl_tz_dys,(sea_dys+port_dys)* 0.5) 
       ,aply_voy_rto = 0.5 
       ,upd_usr_id   = in_usr_id 
       ,upd_dt       = SYSDATE 
       ,vvd_rmk      = decode(aply_voy_rto,0.5, REPLACE(REPLACE(vvd_rmk, ' > First port Ratio:0.5', ''),' > First port,sea,Ratio:0.5','') || ' > First port,sea,Ratio:0.5' 
                              ,'sea days:['||TO_CHAR(sea_dys, '90.99') ||':'|| TO_CHAR(sea_dys * 0.5, '90.99') ||']' 
                               ||', port days:['||TO_CHAR(port_dys, '90.99')||':'|| TO_CHAR(port_dys * 0.5, '90.99') ||']' 
                               ||', total days:['||TO_CHAR(ttl_tz_dys, '90.99')||':'|| TO_CHAR((sea_dys+port_dys)* 0.5, '90.99')||'] > First port,sea,Ratio:0.5') 
    WHERE (vsl_cd, skd_voy_no, loc_cd, vsl_dbl_call_seq, clpt_seq) 
          IN 
          ( 
          
          SELECT    XX.VSL_CD       AS VSL_CD
               ,    XX.SKD_VOY_NO   AS SKD_VOY_NO
               ,    XX.VPS_PORT_CD  AS LOC_CD
               ,    XX.CLPT_IND_SEQ AS VSL_DBL_CALL_SEQ
               ,    XX.CLPT_SEQ     AS CLPT_SEQ
          FROM      (
                    SELECT    X.TRD_CD
                         ,    X.RLANE_CD
                         ,    X.VSL_CD
                         ,    X.SKD_VOY_NO
                         ,    X.SKD_DIR_CD
                         ,    X.VPS_PORT_CD
                         ,    X.VPS_ETD_DT
                         ,    X.SLAN_CD
                         ,    X.CLPT_IND_SEQ
                         ,    X.CLPT_SEQ
                         ,    X.TURN_PORT_IND_CD
                         ,    ML.CONTI_CD                                                                                                                         AS CUR_CONTI_CD
                         ,    LEAD(ML.CONTI_CD) OVER(ORDER BY X.SKD_DIR_CD, X.CLPT_SEQ) AS NXT_CONTI_CD
                    FROM      (
                              SELECT    ROW_NUMBER() OVER (PARTITION BY MST.VSL_CD, MST.SKD_VOY_NO ORDER BY PS.VSL_CD ASC, PS.SKD_VOY_NO ASC, PS.VPS_ETD_DT ASC)  AS VSL_VOY_CLPT_SEQ
                                   ,    MST.TRD_CD
                                   ,    MST.RLANE_CD
                                   ,    MST.VSL_CD
                                   ,    MST.SKD_VOY_NO
                                   ,    MST.DIR_CD        AS SKD_DIR_CD
                                   ,    PS.VPS_PORT_CD
                                   ,    PS.VPS_ETD_DT
                                   ,    MST.SLAN_CD
                                   ,    PS.CLPT_IND_SEQ
                                   ,    PS.CLPT_SEQ
                                   ,    PS.TURN_PORT_IND_CD
                              FROM      COA_MON_VVD         MST
                                   ,    VSK_VSL_PORT_SKD    PS
                              WHERE     MST.VSL_CD          = PS.VSL_CD
                              AND       MST.SKD_VOY_NO      = PS.SKD_VOY_NO  /* 특정 VOYAGE에 대한 First Port 대상을 잡기 위해서 Bound 제한제외함. */
                              AND       MST.DELT_FLG        = 'N'
                              AND       NVL(PS.SKD_CNG_STS_CD, '*') <> 'S'
                              AND       SUBSTR(MST.SLS_YRMON,1,4)||MST.COST_WK BETWEEN TO_NUMBER(v_min_yrwk) AND TO_NUMBER(v_max_yrwk)
                              AND       PS.CLPT_IND_SEQ     = 1
                              AND       PS.CLPT_SEQ         = 1
                              ) X
                        ,     MDM_LOCATION                  ML
                    WHERE     1 = 1
                    AND       X.VPS_PORT_CD                 = LOC_CD
                    AND       X.VSL_VOY_CLPT_SEQ            = 1          
                    )         XX
          WHERE     XX.CUR_CONTI_CD                         =  XX.NXT_CONTI_CD                              
       
    ) /* END OF IN Statement */
    ;
    

   out_err_cd := '00000';
   out_err_msg := 'Completed!';   
   enis_log_prc('', v_log_mod_nm, 'END', NULL);
   
   COMMIT;
-------------------------------[ 예외처리부            ]-----------------------
EXCEPTION
   WHEN OTHERS THEN
      out_err_cd   := SQLCODE;
      out_err_msg  := v_step || SQLERRM;
      enis_log_prc('', v_log_mod_nm, v_step || '=='||v_vvd_info || ' >> ERROR ' || SQLERRM, NULL);
      RAISE;
END COA_CREATE_OPERATION_DAYS_PRC;