CREATE OR REPLACE PROCEDURE OPUSADM."COA_NOD_AVG_STND_COST_MTY_PRC" (IN_COST_YRMON_SRC IN VARCHAR2, IN_COST_YRMON_DEST IN VARCHAR2)
Authid current_user
IS
/******************************************************************************
   Purpose      : 1. TES S/O실적으로부터 NODE 평균단가 생성

   변경내역     :
   2006.11.18 오명석 최초생성
   2007.09.28 박칠서 소스 정리
   2007.09.28 박칠서 TPNDFL, TPNDTS 제외
   2007.10.02 박칠서 TES 새로운 로직 적용
   2007.10.11 박칠서 LCC 단계추가 - MTY REPO LCC 로직 추가하면서 필요하게됨
   2007.11.01 박칠서 전월단가 복사시 노드레벨만 복사했으나 전체 복사로 변경함
   2007.11.02 박칠서 Node full, mty 처리 분리
   2007.11.08 박칠서 원천 데이터를 TES S/O 데이터에서 LEA I/F 데이터로 변경
   2007.12.20 전성진 원천 데이터를 LEA I/F 데이터에서 TES S/O 데이터로 변경
   2007.12.27 전성진 20/40, BOX를 구할때 COST_UT_AMT_CD = 'SZ' 인 것만 생성
   2008.01.11 전성진 200801월 단가부터 MTY가 20,40만 생성하기 때문에 
                        1. BOX단가 구하는 로직을 FULL/MTY 구분하여 적용.
                        2. 20,40단가 구하는 부분에 FULL만 구함.
   2008.03.31 전윤주 MTY 단가 생성 분리
   2008.04.02 전윤주 TPNDMT vs SVLDMT   logic 추가
                     한 Node에서 TPNDMT, SVLDMT, TMNDMT 가 모두 같이 있는 Node일 경우 TMNDMT, SVLDMT를 0 으로 해서
                     상위 Location group 단가 만들 때 사용함
                     TMFDMT, TMFDXM 계정에 대해서도 상위에서 TPNDMT, TMNDMT 보다 먼저 check해서 붙이므로
                     상위 location group 단가 만들 때 가지고 있음
                     (Node Creation only 미체크 계정 5개)
   2008.05.29 전윤주 COA_NOD_AVG_STND_COST 에 COST_FX_FLG column 추가 된 것 반영 수정
******************************************************************************/

   ------------------------------[ 변수선언부             ]-----------------------

   /** 작업로그 관련 변수선언 **/
   V_START_TIME                   TIMESTAMP;
   V_COA_STEP                     VARCHAR(100);
   V_PRC_CNT                      NUMBER;
   V_COST_YRMON_PREV3_N1ST_DATE   DATE;   -- 3개월전 첫째날
   V_COST_YRMON_PREV0_N1ST_DATE   DATE;   -- 현재월 첫째날  
   
-------------------------------[ 업무로직 구현부       ]-----------------------
BEGIN
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 시작 정보 출력
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   V_START_TIME := SYSTIMESTAMP;
   V_PRC_CNT := 0;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', '[V.20080402]');
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'in_cost_yrmon_src: ' || IN_COST_YRMON_SRC);
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'in_cost_yrmon_dest: ' || IN_COST_YRMON_DEST);
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 3개월 기간 구하기
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   V_COA_STEP := '3개월 기간 구하기';
   V_COST_YRMON_PREV3_N1ST_DATE := ADD_MONTHS(TO_DATE(IN_COST_YRMON_SRC || '01', 'YYYYMMDD'), -3);
   V_COST_YRMON_PREV0_N1ST_DATE := TO_DATE(IN_COST_YRMON_SRC || '01', 'YYYYMMDD');
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'v_cost_yrmon_prev3_n1st_date: ' || V_COST_YRMON_PREV3_N1ST_DATE);
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'v_cost_yrmon_prev0_n1st_date: ' || V_COST_YRMON_PREV0_N1ST_DATE);
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 대상 년월 단가 삭제
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   V_COA_STEP := '대상 년월 단가 삭제';

   DELETE FROM COA_NOD_AVG_STND_COST
         WHERE COST_YRMON = IN_COST_YRMON_DEST;

   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'COA_NOD_AVG_STND_COST: ' || SQL%ROWCOUNT || ' delete');
   -------------------------------[ NODE AVG COST 작업 처리         ]-----------------------

   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- 전월 데이터 복사
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   V_COA_STEP := '전월 데이터 복사';

   INSERT INTO COA_NOD_AVG_STND_COST
      SELECT IN_COST_YRMON_DEST
            ,FULL_MTY_CD
            ,CNTR_TPSZ_CD
            ,COST_LOC_GRP_CD
            ,NOD_CD
            ,COA_COST_SRC_CD
            ,TRD_CD
            ,LOCL_CURR_CD
            ,STND_COST_USD_AMT
            ,LOCL_RT_AMT
            ,SLAN_CD
            ,SKD_DIR_CD
            ,USD_RT_AMT
            ,COST_ASS_BSE_CD
            ,BIZ_RULE_FLG
            ,FM_EFF_DT
            ,TO_EFF_DT
            ,NOD_TTL_QTY
            ,NOD_TTL_AMT
            ,COST_VOL_CD
            ,'SYS_COA_COPY' CRE_USR_ID
            ,SYSDATE CRE_DT
            ,'SYS_COA_COPY' UPD_USR_ID
            ,SYSDATE UPD_DT
            , TO_CHAR(ADD_MONTHS(TO_DATE(IN_COST_YRMON_DEST || '01', 'YYYYMMDD'), -1), 'YYYYMM') || ' Copy'
            ,COST_FX_FLG
            ,COST_ACT_GRP_CD
        FROM COA_NOD_AVG_STND_COST
       WHERE COST_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(IN_COST_YRMON_DEST || '01', 'YYYYMMDD'), -1), 'YYYYMM')   -- 1개월전
                                                                                                           ;

   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', '전월단가 copy: ' || SQL%ROWCOUNT);
--
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- NODE MTY 단가 처리
--      MTY의 경우 USER의 요청으로 20,40 만 생성하나 현재(2008.12.27)는 coa_cost_src_acct의 cost_ut_amt_cd를 사용하지 않고 처리함    
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   V_COA_STEP := 'NODE MTY 단가 처리';
   MERGE INTO COA_NOD_AVG_STND_COST E1
      USING (SELECT d1.cost_yrmon
                   ,d1.full_mty_cd
                   ,coa_ut_tpsz_fnc(NULL, d1.cntr_tpsz_cd) cntr_tpsz_cd   -- SPCL FLG 인것은 모두 SP 로 바꾼다.
                   ,d1.cost_loc_grp_cd
                   ,d1.nod_cd
                   ,d1.coa_cost_src_cd
                   ,'USD' locl_curr_cd
                   ,SUM(d1.cost_usd_amt) / SUM(d1.uom_qty) AS stnd_cost_usd_amt
                   ,'A' cost_ass_bse_cd
                   ,SUM(d1.uom_qty) nod_ttl_qty
                   ,SUM(d1.cost_usd_amt) nod_ttl_amt
                   ,MAX(d1.cost_vol_cd) cost_vol_cd
               FROM (SELECT in_cost_yrmon_dest AS cost_yrmon
                           ,c1.full_mty_cd
                           ,c1.cntr_tpsz_cd
                           ,'N' AS cost_loc_grp_cd
                           ,c1.nod_cd
                           ,c1.coa_cost_src_cd
                           ,NVL(c1.cost_usd_amt, 0) cost_usd_amt
                           ,c1.uom_1_cd
                           ,NVL(c3.uom_1_qty, 0) uom_1_qty
                           ,c1.uom_2_cd
                           ,NVL(c4.uom_2_qty, 0) uom_2_qty
                           ,CASE
                               WHEN(NVL(c3.uom_1_qty, 0) > 0)
                                  THEN NVL(c3.uom_1_qty, 0)
                               ELSE NVL(c4.uom_2_qty, 0)
                            END uom_qty
                           ,CASE
                               WHEN(NVL(c3.uom_1_qty, 0) > 0)
                                  THEN c1.uom_1_cd
                               ELSE c1.uom_2_cd
                            END cost_vol_cd
                       FROM (                               
                                -- AMT
                                SELECT b1.full_mty_cd
                                      ,b1.coa_cost_src_cd
                                      ,b1.uom_1_cd
                                      ,b1.uom_2_cd
                                      ,b2.cntr_tpsz_cd
                                      ,b2.nod_cd
                                      ,b2.cost_usd_amt
                                  FROM 
                                       (SELECT full_mty_cd AS full_mty_cd
                                              ,coa_cost_src_cd 
                                              ,cost_vol_cd AS uom_1_cd
                                              ,cost_vol_cd1 AS uom_2_cd
                                          FROM coa_cost_src_acct
                                         WHERE cost_src_sys_cd = 'TES'
                                           AND coa_cost_src_cd NOT IN('TPNDFL', 'TPNDTS')   -- 2007.09.28 이경한 요청 TPNDFL, TPNDTS 제외
                                           AND full_mty_cd = 'M'   -- MTY 
                                                                  ) b1, 
                                       (SELECT a3.cntr_sty_cd AS full_mty_cd
                                              ,decode(substr(a2.cntr_tpsz_cd, -1), '2', '20', '40') cntr_tpsz_cd
                                                  -- MTY 는 20, 40 TYPE 만 필요함
                                              ,a1.yd_cd AS nod_cd
                                              ,a2.lgs_cost_cd AS coa_cost_src_cd
                                              ,SUM(coa_conv_curr_usd_fnc(a1.curr_cd, NVL(a2.inv_amt, 0), TO_CHAR(a1.iss_dt, 'YYYYMM'))) AS cost_usd_amt
                                          FROM tes_tml_so_hdr a1, tes_tml_so_dtl a2, tes_tml_so_cost a3
                                         WHERE a1.tml_so_ofc_cty_cd = a2.tml_so_ofc_cty_cd
                                           AND a1.tml_so_seq = a2.tml_so_seq
                                           AND a2.lgs_cost_cd = a3.lgs_cost_cd
                                           AND a1.tml_inv_sts_cd = 'D'
                                           AND NVL(a1.delt_flg, 'N') <> 'Y'
                                           AND a1.iss_dt >= v_cost_yrmon_prev3_n1st_date
                                           AND a1.iss_dt < v_cost_yrmon_prev0_n1st_date
                                           AND a3.cntr_sty_cd = 'M'   -- MTY
                                         GROUP BY a3.cntr_sty_cd, decode(substr(a2.cntr_tpsz_cd, -1), '2', '20', '40'), a1.yd_cd, a2.lgs_cost_cd
                                         ORDER BY 1, 2, 3, 4) b2
                                 WHERE b1.coa_cost_src_cd = b2.coa_cost_src_cd) c1                                 
                            -- COST SRC QTY
                           ,(SELECT a3.cntr_sty_cd full_mty_cd
                                   ,decode(substr(a2.cntr_tpsz_cd, -1), '2', '20', '40') cntr_tpsz_cd
                                       -- MTY 는 20, 40 TYPE 만 필요함
                                   ,a1.yd_cd nod_cd
                                   ,a2.lgs_cost_cd AS coa_cost_src_cd
                                   ,SUM(DECODE(a2.calc_cost_grp_cd
                                               ,'TM', NVL(a2.rvis_vol_qty, 1)
                                               ,'ON', NVL(a2.rvis_vol_qty, 1)
                                               ,NVL(a2.ovr_dys, 1)
                                              )
                                       ) cost_src_qty
                               FROM tes_tml_so_hdr a1, tes_tml_so_dtl a2, tes_tml_so_cost a3
                              WHERE a1.tml_so_ofc_cty_cd = a2.tml_so_ofc_cty_cd
                                AND a1.tml_so_seq = a2.tml_so_seq
                                AND a2.lgs_cost_cd = a3.lgs_cost_cd
                                AND a1.tml_inv_sts_cd = 'D'
                                AND NVL(a1.delt_flg, 'N') <> 'Y'
                                AND a1.iss_dt >= v_cost_yrmon_prev3_n1st_date
                                AND a1.iss_dt < v_cost_yrmon_prev0_n1st_date
                                AND NVL(a2.inv_amt, 0) > 0 -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.
                                AND a3.cntr_sty_cd = 'M'   -- MTY
                              GROUP BY a3.cntr_sty_cd, decode(substr(a2.cntr_tpsz_cd, -1), '2', '20', '40'), a1.yd_cd, a2.lgs_cost_cd
                             HAVING SUM(DECODE(a2.calc_cost_grp_cd
                                               ,'TM', NVL(a2.rvis_vol_qty, 1)
                                               ,'ON', NVL(a2.rvis_vol_qty, 1)
                                               ,NVL(a2.ovr_dys, 1)
                                              )
                                       ) > 0
                              ORDER BY 1, 2, 3, 4) c2
                            -- UOM_1_QTY
                           ,(SELECT a3.cntr_sty_cd full_mty_cd
                                   ,decode(substr(a2.cntr_tpsz_cd, -1), '2', '20', '40') cntr_tpsz_cd
                                       -- MTY 는 20, 40 TYPE 만 필요함
                                   ,a1.yd_cd nod_cd
                                   ,a2.lgs_cost_cd AS uom_1_cd
                                   ,SUM(DECODE(a2.calc_cost_grp_cd
                                               ,'TM', NVL(a2.rvis_vol_qty, 1)
                                               ,'ON', NVL(a2.rvis_vol_qty, 1)
                                               ,NVL(a2.ovr_dys, 1)
                                              )
                                       ) uom_1_qty
                               FROM tes_tml_so_hdr a1, tes_tml_so_dtl a2, tes_tml_so_cost a3
                              WHERE a1.tml_so_ofc_cty_cd = a2.tml_so_ofc_cty_cd
                                AND a1.tml_so_seq = a2.tml_so_seq
                                AND a2.lgs_cost_cd = a3.lgs_cost_cd
                                AND a1.tml_inv_sts_cd = 'D'
                                AND NVL(a1.delt_flg, 'N') <> 'Y'
                                AND a1.iss_dt >= v_cost_yrmon_prev3_n1st_date
                                AND a1.iss_dt < v_cost_yrmon_prev0_n1st_date
                                AND NVL(a2.inv_amt, 0) > 0 -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.
                                AND a3.cntr_sty_cd = 'M'   -- MTY
                              GROUP BY a3.cntr_sty_cd, decode(substr(a2.cntr_tpsz_cd, -1), '2', '20', '40'), a1.yd_cd, a2.lgs_cost_cd
                             HAVING SUM(DECODE(a2.calc_cost_grp_cd
                                               ,'TM', NVL(a2.rvis_vol_qty, 1)
                                               ,'ON', NVL(a2.rvis_vol_qty, 1)
                                               ,NVL(a2.ovr_dys, 1)
                                              )
                                       ) > 0
                              ORDER BY 1, 2, 3, 4) c3
                            -- UOM_2_QTY : UOM_1_QTY 쿼리와 같음
                           ,(SELECT a3.cntr_sty_cd full_mty_cd
                                   ,decode(substr(a2.cntr_tpsz_cd, -1), '2', '20', '40') cntr_tpsz_cd
                                       -- MTY 는 20, 40 TYPE 만 필요함
                                   ,a1.yd_cd nod_cd
                                   ,a2.lgs_cost_cd AS uom_2_cd
                                   ,SUM(DECODE(a2.calc_cost_grp_cd
                                               ,'TM', NVL(a2.rvis_vol_qty, 1)
                                               ,'ON', NVL(a2.rvis_vol_qty, 1)
                                               ,NVL(a2.ovr_dys, 1)
                                              )
                                       ) uom_2_qty
                               FROM tes_tml_so_hdr a1, tes_tml_so_dtl a2, tes_tml_so_cost a3
                              WHERE a1.tml_so_ofc_cty_cd = a2.tml_so_ofc_cty_cd
                                AND a1.tml_so_seq = a2.tml_so_seq
                                AND a2.lgs_cost_cd = a3.lgs_cost_cd
                                AND a1.tml_inv_sts_cd = 'D'
                                AND NVL(a1.delt_flg, 'N') <> 'Y'
                                AND a1.iss_dt >= v_cost_yrmon_prev3_n1st_date
                                AND a1.iss_dt < v_cost_yrmon_prev0_n1st_date
                                AND NVL(a2.inv_amt, 0) > 0  -- 마이너스는 기지급건 조정을 위한것이므로 카운트 하지 않는다.
                                AND a3.cntr_sty_cd = 'M'   -- MTY
                              GROUP BY a3.cntr_sty_cd, decode(substr(a2.cntr_tpsz_cd, -1), '2', '20', '40'), a1.yd_cd, a2.lgs_cost_cd
                             HAVING SUM(DECODE(a2.calc_cost_grp_cd
                                               ,'TM', NVL(a2.rvis_vol_qty, 1)
                                               ,'ON', NVL(a2.rvis_vol_qty, 1)
                                               ,NVL(a2.ovr_dys, 1)
                                              )
                                       ) > 0
                              ORDER BY 1, 2, 3, 4) c4
                      WHERE c1.full_mty_cd = c2.full_mty_cd(+)
                        AND c1.cntr_tpsz_cd = c2.cntr_tpsz_cd(+)
                        AND c1.nod_cd = c2.nod_cd(+)
                        AND c1.coa_cost_src_cd = c2.coa_cost_src_cd(+)
                        AND c1.full_mty_cd = c3.full_mty_cd(+)
                        AND c1.cntr_tpsz_cd = c3.cntr_tpsz_cd(+)
                        AND c1.nod_cd = c3.nod_cd(+)
                        AND c1.uom_1_cd = c3.uom_1_cd(+)
                        AND c1.full_mty_cd = c4.full_mty_cd(+)
                        AND c1.cntr_tpsz_cd = c4.cntr_tpsz_cd(+)
                        AND c1.nod_cd = c4.nod_cd(+)
                        AND c1.uom_2_cd = c4.uom_2_cd(+)
                        AND DECODE(c3.uom_1_qty, NULL, 'X', 'O') || DECODE(c4.uom_2_qty, NULL, 'X', 'O') <> 'XX') d1
                                                                        -- QTY 1차, 2차 모두 없으면 단가생성에서 제외
              GROUP BY cost_yrmon, full_mty_cd, coa_ut_tpsz_fnc(NULL, d1.cntr_tpsz_cd), cost_loc_grp_cd, nod_cd, coa_cost_src_cd) E2
      ON (    E1.COST_YRMON = E2.COST_YRMON
          AND E1.FULL_MTY_CD = E2.FULL_MTY_CD
          AND E1.CNTR_TPSZ_CD = E2.CNTR_TPSZ_CD
          AND E1.COST_LOC_GRP_CD = E2.COST_LOC_GRP_CD
          AND E1.NOD_CD = E2.NOD_CD
          AND E1.COA_COST_SRC_CD = E2.COA_COST_SRC_CD)
      WHEN NOT MATCHED THEN
         INSERT(E1.COST_YRMON, E1.FULL_MTY_CD, E1.CNTR_TPSZ_CD, E1.COST_LOC_GRP_CD, E1.NOD_CD, E1.COA_COST_SRC_CD, E1.LOCL_CURR_CD
               ,E1.STND_COST_USD_AMT, E1.COST_ASS_BSE_CD, E1.NOD_TTL_QTY, E1.NOD_TTL_AMT, E1.COST_VOL_CD, E1.CRE_USR_ID, E1.CRE_DT, E1.UPD_USR_ID
               ,E1.UPD_DT)
         VALUES(E2.COST_YRMON, E2.FULL_MTY_CD, E2.CNTR_TPSZ_CD, E2.COST_LOC_GRP_CD, E2.NOD_CD, E2.COA_COST_SRC_CD, E2.LOCL_CURR_CD
               ,E2.STND_COST_USD_AMT, E2.COST_ASS_BSE_CD, E2.NOD_TTL_QTY, E2.NOD_TTL_AMT, E2.COST_VOL_CD, 'SYS_COA_CRE', SYSDATE, 'SYS_COA_CRE'
               ,SYSDATE)
      WHEN MATCHED THEN
         UPDATE
            SET E1.LOCL_CURR_CD = E2.LOCL_CURR_CD, E1.STND_COST_USD_AMT = E2.STND_COST_USD_AMT, E1.COST_ASS_BSE_CD = E2.COST_ASS_BSE_CD
               ,E1.NOD_TTL_QTY = E2.NOD_TTL_QTY, E1.NOD_TTL_AMT = E2.NOD_TTL_AMT, E1.COST_VOL_CD = E2.COST_VOL_CD, E1.UPD_USR_ID = 'SYS_COA_UPD'
               ,E1.UPD_DT = SYSDATE
         ;
   V_PRC_CNT := V_PRC_CNT + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'NODE MTY Merge: ' || SQL%ROWCOUNT);
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- SCC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   V_COA_STEP := 'SCC';
            
   MERGE INTO coa_nod_avg_stnd_cost e1
      USING (SELECT cost_yrmon
                   ,a1.full_mty_cd
                   ,a1.cntr_tpsz_cd
                   ,'S' cost_loc_grp_cd
                   ,coa_loc_fnc(a1.nod_cd, 'SCC') nod_cd
                   ,a1.coa_cost_src_cd
                   ,'USD' locl_curr_cd
                   ,'A' cost_ass_bse_cd
                   ,SUM(CASE WHEN
                                a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                             ELSE a1.nod_ttl_amt
                         END ) AS nod_ttl_amt --TPNDMT 가 있는 Node에 대해서는 SVLDMT, TMNDMT 단가를 무조건 0처리
                                              --TPNDMT 가 없는 경우에 대해서는 SVLDMT, TMNDMT 사용
                   ,SUM(CASE WHEN
                                a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                             ELSE a1.nod_ttl_qty
                         END ) AS nod_ttl_qty --TPNDMT 가 있는 Node에 대해서는 SVLDMT, TMNDMT 단가를 무조건 0처리
                                              --TPNDMT 가 없는 경우에 대해서는 SVLDMT, TMNDMT 사용
                   ,DECODE(SUM(CASE WHEN
                                       a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_qty
                               END)
                          ,0 , 0
                          ,SUM(CASE WHEN
                                        a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_amt
                                END )
                           /SUM(CASE WHEN
                                        a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_qty
                                END)
                          ) AS stnd_cost_usd_amt 
                          
             FROM coa_nod_avg_stnd_cost a1, coa_cost_src_acct a2
                 ,(SELECT  nod_cd --해당 Node에 TPNDMT 있는지 check
                          ,cntr_tpsz_cd
                          ,coa_cost_src_cd
                     FROM coa_nod_avg_stnd_cost
                    WHERE cost_yrmon = in_cost_yrmon_dest
                      AND full_mty_cd = 'M'
                      AND cost_loc_grp_cd = 'N'
                      AND coa_cost_src_cd = 'TPNDMT' --TPNDMT vs SVLDMT 
                                                     --위 두가지 경우는 같이 비용으로 들어갈 수 없다.
                  ) a3
            WHERE cost_yrmon = in_cost_yrmon_dest
              AND cost_loc_grp_cd = 'N'
              AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.
                                                    -- 현재(2008.04.10)는 TPNDMT, SVLDMT, TMNDMT, TMFDMT, TMFDXM만 올라갈 수 있게 되어있다.                                                    
              AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
              AND a1.full_mty_cd = 'M'
              AND a1.nod_cd = a3.nod_cd(+) 
              AND a1.cntr_tpsz_cd = a3.cntr_tpsz_cd(+)
            GROUP BY a1.cost_yrmon, a1.full_mty_cd, a1.cntr_tpsz_cd, coa_loc_fnc(a1.nod_cd, 'SCC')
                    ,a1.coa_cost_src_cd
            HAVING coa_loc_fnc(a1.nod_cd, 'SCC') IS NOT NULL ) e2
            
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd
          AND e1.nod_cd = e2.nod_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.full_mty_cd, e1.cntr_tpsz_cd, e1.cost_loc_grp_cd, e1.nod_cd, e1.coa_cost_src_cd, e1.locl_curr_cd
               ,e1.stnd_cost_usd_amt, e1.cost_ass_bse_cd, e1.nod_ttl_qty, e1.nod_ttl_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.full_mty_cd, e2.cntr_tpsz_cd, e2.cost_loc_grp_cd, e2.nod_cd, e2.coa_cost_src_cd, e2.locl_curr_cd
               ,e2.stnd_cost_usd_amt, e2.cost_ass_bse_cd, e2.nod_ttl_qty, e2.nod_ttl_amt, null, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.nod_ttl_qty = e2.nod_ttl_qty, e1.nod_ttl_amt = e2.nod_ttl_amt, e1.cost_vol_cd = null, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = sysdate
      ;
   V_PRC_CNT := V_PRC_CNT + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'SCC: ' || SQL%ROWCOUNT);
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- ECC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   V_COA_STEP := 'ECC';
   MERGE INTO coa_nod_avg_stnd_cost e1
      USING (SELECT cost_yrmon
                   ,a1.full_mty_cd
                   ,a1.cntr_tpsz_cd
                   ,'E' cost_loc_grp_cd
                   ,coa_loc_fnc(a1.nod_cd, 'ECC') nod_cd
                   ,a1.coa_cost_src_cd
                   ,'USD' locl_curr_cd
                   ,'A' cost_ass_bse_cd
                   ,SUM(CASE WHEN
                                a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                             ELSE a1.nod_ttl_amt
                         END ) AS nod_ttl_amt --TPNDMT 가 있는 Node에 대해서는 SVLDMT, TMNDMT 단가를 무조건 0처리
                                              --TPNDMT 가 없는 경우에 대해서는 SVLDMT, TMNDMT 사용
                   ,SUM(CASE WHEN
                                a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                             ELSE a1.nod_ttl_qty
                         END ) AS nod_ttl_qty --TPNDMT 가 있는 Node에 대해서는 SVLDMT, TMNDMT 단가를 무조건 0처리
                                              --TPNDMT 가 없는 경우에 대해서는 SVLDMT, TMNDMT 사용
                   ,DECODE(SUM(CASE WHEN
                                       a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_qty
                               END)
                          ,0 , 0
                          ,SUM(CASE WHEN
                                        a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_amt
                                END )
                           /SUM(CASE WHEN
                                        a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_qty
                                END)
                          ) AS stnd_cost_usd_amt 

             FROM coa_nod_avg_stnd_cost a1, coa_cost_src_acct a2
                 ,(SELECT  nod_cd --해당 Node에 TPNDMT 있는지 check
                          ,coa_cost_src_cd
                          ,cntr_tpsz_cd
                     FROM coa_nod_avg_stnd_cost
                    WHERE cost_yrmon = in_cost_yrmon_dest
                      AND full_mty_cd = 'M'
                      AND cost_loc_grp_cd = 'N'
                      AND coa_cost_src_cd = 'TPNDMT' --TPNDMT vs SVLDMT 
                                                     --위 두가지 경우는 같이 비용으로 들어갈 수 없다.
                  ) a3
            WHERE cost_yrmon = in_cost_yrmon_dest
              AND cost_loc_grp_cd = 'N'
              AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.
                                                    -- 현재(2008.04.10)는 TPNDMT, SVLDMT, TMNDMT, TMFDMT, TMFDXM만 올라갈 수 있게 되어있다.
              AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
              AND a1.full_mty_cd = 'M'
              AND a1.nod_cd = a3.nod_cd(+)
              AND a1.cntr_tpsz_cd = a3.cntr_tpsz_cd(+)
            GROUP BY a1.cost_yrmon, a1.full_mty_cd, a1.cntr_tpsz_cd, coa_loc_fnc(a1.nod_cd, 'ECC')
                    ,a1.coa_cost_src_cd
            HAVING coa_loc_fnc(a1.nod_cd, 'ECC') IS NOT NULL ) e2
            
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd
          AND e1.nod_cd = e2.nod_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.full_mty_cd, e1.cntr_tpsz_cd, e1.cost_loc_grp_cd, e1.nod_cd, e1.coa_cost_src_cd, e1.locl_curr_cd
               ,e1.stnd_cost_usd_amt, e1.cost_ass_bse_cd, e1.nod_ttl_qty, e1.nod_ttl_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.full_mty_cd, e2.cntr_tpsz_cd, e2.cost_loc_grp_cd, e2.nod_cd, e2.coa_cost_src_cd, e2.locl_curr_cd
               ,e2.stnd_cost_usd_amt, e2.cost_ass_bse_cd, e2.nod_ttl_qty, e2.nod_ttl_amt, null, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.nod_ttl_qty = e2.nod_ttl_qty, e1.nod_ttl_amt = e2.nod_ttl_amt, e1.cost_vol_cd = null, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = sysdate
      ;
   V_PRC_CNT := V_PRC_CNT + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'ECC: ' || SQL%ROWCOUNT);
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- LCC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   V_COA_STEP := 'LCC';
   MERGE INTO coa_nod_avg_stnd_cost e1
      USING (SELECT cost_yrmon
                   ,a1.full_mty_cd
                   ,a1.cntr_tpsz_cd
                   ,'L' cost_loc_grp_cd
                   ,coa_loc_fnc(a1.nod_cd, 'LCC') nod_cd
                   ,a1.coa_cost_src_cd
                   ,'USD' locl_curr_cd
                   ,'A' cost_ass_bse_cd
                   ,SUM(CASE WHEN
                                a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                             ELSE a1.nod_ttl_amt
                         END ) AS nod_ttl_amt --TPNDMT 가 있는 Node에 대해서는 SVLDMT, TMNDMT 단가를 무조건 0처리
                                              --TPNDMT 가 없는 경우에 대해서는 SVLDMT, TMNDMT 사용
                   ,SUM(CASE WHEN
                                a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                             ELSE a1.nod_ttl_qty
                         END ) AS nod_ttl_qty --TPNDMT 가 있는 Node에 대해서는 SVLDMT, TMNDMT 단가를 무조건 0처리
                                              --TPNDMT 가 없는 경우에 대해서는 SVLDMT, TMNDMT 사용
                   ,DECODE(SUM(CASE WHEN
                                       a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_qty
                               END)
                          ,0 , 0
                          ,SUM(CASE WHEN
                                        a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_amt
                                END )
                           /SUM(CASE WHEN
                                        a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_qty
                                END)
                          ) AS stnd_cost_usd_amt 

             FROM coa_nod_avg_stnd_cost a1, coa_cost_src_acct a2
                 ,(SELECT  nod_cd --해당 Node에 TPNDMT 있는지 check
                          ,cntr_tpsz_cd
                          ,coa_cost_src_cd
                     FROM coa_nod_avg_stnd_cost
                    WHERE cost_yrmon = in_cost_yrmon_dest
                      AND full_mty_cd = 'M'
                      AND cost_loc_grp_cd = 'N'
                      AND coa_cost_src_cd = 'TPNDMT' --TPNDMT vs SVLDMT 
                                                     --위 두가지 경우는 같이 비용으로 들어갈 수 없다.
                  ) a3
            WHERE cost_yrmon = in_cost_yrmon_dest
              AND cost_loc_grp_cd = 'N'
              AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.
                                                    -- 현재(2008.04.10)는 TPNDMT, SVLDMT, TMNDMT, TMFDMT, TMFDXM만 올라갈 수 있게 되어있다.
              AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
              AND a1.full_mty_cd = 'M'
              AND a1.nod_cd = a3.nod_cd(+) 
              AND a1.cntr_tpsz_cd = a3.cntr_tpsz_cd(+)
            GROUP BY a1.cost_yrmon, a1.full_mty_cd, a1.cntr_tpsz_cd, coa_loc_fnc(a1.nod_cd, 'LCC')
                    ,a1.coa_cost_src_cd
            HAVING coa_loc_fnc(a1.nod_cd, 'LCC') IS NOT NULL ) e2
            
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd
          AND e1.nod_cd = e2.nod_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.full_mty_cd, e1.cntr_tpsz_cd, e1.cost_loc_grp_cd, e1.nod_cd, e1.coa_cost_src_cd, e1.locl_curr_cd
               ,e1.stnd_cost_usd_amt, e1.cost_ass_bse_cd, e1.nod_ttl_qty, e1.nod_ttl_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.full_mty_cd, e2.cntr_tpsz_cd, e2.cost_loc_grp_cd, e2.nod_cd, e2.coa_cost_src_cd, e2.locl_curr_cd
               ,e2.stnd_cost_usd_amt, e2.cost_ass_bse_cd, e2.nod_ttl_qty, e2.nod_ttl_amt, null, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.nod_ttl_qty = e2.nod_ttl_qty, e1.nod_ttl_amt = e2.nod_ttl_amt, e1.cost_vol_cd = null, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = sysdate
      ;
   V_PRC_CNT := V_PRC_CNT + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'LCC: ' || SQL%ROWCOUNT);
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- RCC
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   V_COA_STEP := 'RCC';
   MERGE INTO coa_nod_avg_stnd_cost e1
      USING (SELECT cost_yrmon
                   ,a1.full_mty_cd
                   ,a1.cntr_tpsz_cd
                   ,'R' cost_loc_grp_cd
                   ,coa_loc_fnc(a1.nod_cd, 'RCC') nod_cd
                   ,a1.coa_cost_src_cd
                   ,'USD' locl_curr_cd
                   ,'A' cost_ass_bse_cd
                   ,SUM(CASE WHEN
                                a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                             ELSE a1.nod_ttl_amt
                         END ) AS nod_ttl_amt --TPNDMT 가 있는 Node에 대해서는 SVLDMT, TMNDMT 단가를 무조건 0처리
                                              --TPNDMT 가 없는 경우에 대해서는 SVLDMT, TMNDMT 사용
                   ,SUM(CASE WHEN
                                a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                             ELSE a1.nod_ttl_qty
                         END ) AS nod_ttl_qty --TPNDMT 가 있는 Node에 대해서는 SVLDMT, TMNDMT 단가를 무조건 0처리
                                              --TPNDMT 가 없는 경우에 대해서는 SVLDMT, TMNDMT 사용
                   ,DECODE(SUM(CASE WHEN
                                       a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_qty
                               END)
                          ,0 , 0
                          ,SUM(CASE WHEN
                                        a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_amt
                                END )
                           /SUM(CASE WHEN
                                        a3.nod_cd IS NOT NULL AND a1.coa_cost_src_cd IN ('SVLDMT', 'TMNDMT') THEN 0
                                    ELSE a1.nod_ttl_qty
                                END)
                          ) AS stnd_cost_usd_amt 
                          
             FROM coa_nod_avg_stnd_cost a1, coa_cost_src_acct a2
                 ,(SELECT  nod_cd --해당 Node에 TPNDMT 있는지 check
                          ,cntr_tpsz_cd
                          ,coa_cost_src_cd
                     FROM coa_nod_avg_stnd_cost
                    WHERE cost_yrmon = in_cost_yrmon_dest
                      AND full_mty_cd = 'M'
                      AND cost_loc_grp_cd = 'N'
                      AND coa_cost_src_cd = 'TPNDMT' --TPNDMT vs SVLDMT 
                                                     --위 두가지 경우는 같이 비용으로 들어갈 수 없다.
                  ) a3
            WHERE cost_yrmon = in_cost_yrmon_dest
              AND cost_loc_grp_cd = 'N'
              AND nvl(a2.bkg_mcgo_flg, 'N') = 'N'   -- BKG_MCGO_FLG 가 Y 인것은 NODE 에만 깐다.
                                                    -- 현재(2008.04.10)는 TPNDMT, SVLDMT, TMNDMT, TMFDMT, TMFDXM만 올라갈 수 있게 되어있다.
              AND a1.coa_cost_src_cd = a2.coa_cost_src_cd
              AND a1.full_mty_cd = 'M'
              AND a1.nod_cd = a3.nod_cd(+) 
              AND a1.cntr_tpsz_cd = a3.cntr_tpsz_cd(+)
            GROUP BY a1.cost_yrmon, a1.full_mty_cd, a1.cntr_tpsz_cd, coa_loc_fnc(a1.nod_cd, 'RCC')
                    ,a1.coa_cost_src_cd
            HAVING coa_loc_fnc(a1.nod_cd, 'RCC') IS NOT NULL ) e2
            
      ON (    e1.cost_yrmon = e2.cost_yrmon
          AND e1.full_mty_cd = e2.full_mty_cd
          AND e1.cntr_tpsz_cd = e2.cntr_tpsz_cd
          AND e1.cost_loc_grp_cd = e2.cost_loc_grp_cd
          AND e1.nod_cd = e2.nod_cd
          AND e1.coa_cost_src_cd = e2.coa_cost_src_cd)
      WHEN NOT MATCHED THEN
         INSERT(e1.cost_yrmon, e1.full_mty_cd, e1.cntr_tpsz_cd, e1.cost_loc_grp_cd, e1.nod_cd, e1.coa_cost_src_cd, e1.locl_curr_cd
               ,e1.stnd_cost_usd_amt, e1.cost_ass_bse_cd, e1.nod_ttl_qty, e1.nod_ttl_amt, e1.cost_vol_cd, e1.cre_usr_id, e1.cre_dt, e1.upd_usr_id
               ,e1.upd_dt)
         VALUES(e2.cost_yrmon, e2.full_mty_cd, e2.cntr_tpsz_cd, e2.cost_loc_grp_cd, e2.nod_cd, e2.coa_cost_src_cd, e2.locl_curr_cd
               ,e2.stnd_cost_usd_amt, e2.cost_ass_bse_cd, e2.nod_ttl_qty, e2.nod_ttl_amt, null, 'SYS_COA_CRE', sysdate, 'SYS_COA_CRE', sysdate)
      WHEN MATCHED THEN
         UPDATE
            SET e1.locl_curr_cd = e2.locl_curr_cd, e1.stnd_cost_usd_amt = e2.stnd_cost_usd_amt, e1.cost_ass_bse_cd = e2.cost_ass_bse_cd
               ,e1.nod_ttl_qty = e2.nod_ttl_qty, e1.nod_ttl_amt = e2.nod_ttl_amt, e1.cost_vol_cd = null, e1.upd_usr_id = 'SYS_COA_UPD'
               ,e1.upd_dt = sysdate
      ;
   V_PRC_CNT := V_PRC_CNT + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'RCC: ' || SQL%ROWCOUNT);
   --
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- BOX tpsz MTY
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   V_COA_STEP := 'BOX tpsz';
   MERGE INTO COA_NOD_AVG_STND_COST E1
      USING (SELECT A1.COST_YRMON
                   ,A1.FULL_MTY_CD
                   ,'BOX' AS CNTR_TPSZ_CD
                   ,A1.COST_LOC_GRP_CD
                   ,A1.NOD_CD
                   ,A1.COA_COST_SRC_CD
                   ,'USD' AS LOCL_CURR_CD
                   ,'A' AS COST_ASS_BSE_CD
                   ,SUM(A1.NOD_TTL_AMT) AS NOD_TTL_AMT
                   ,SUM(A1.NOD_TTL_QTY) AS NOD_TTL_QTY
                   ,SUM(A1.NOD_TTL_AMT) / SUM(A1.NOD_TTL_QTY) AS STND_COST_USD_AMT
               FROM COA_NOD_AVG_STND_COST A1
                   ,COA_COST_SRC_ACCT A2
              WHERE A1.COA_COST_SRC_CD = A2.COA_COST_SRC_CD
                AND A1.COST_YRMON = IN_COST_YRMON_DEST
                AND A1.CNTR_TPSZ_CD NOT IN ('BOX')    -- MTY의 경우 20,40으로만 단가를 계산하기 때문에 BOX만 제외하고 box단가 생성
                                                      -- 전월데이터를 copy하기 때문에 BOX 단가가 존재함.  
                AND A1.NOD_TTL_AMT > 0   -- AMT 가 0인것이 있음
                AND A1.NOD_TTL_QTY > 0
                AND A2.COST_SRC_SYS_CD = 'TES'
                AND A2.COST_UT_AMT_CD = 'BOX'   -- 단가를 붙일때 BOX인것만 사용함.
                AND A1.FULL_MTY_CD = 'M'        -- MTY
              GROUP BY A1.COST_YRMON, A1.FULL_MTY_CD, 'BOX', A1.COST_LOC_GRP_CD, A1.NOD_CD, A1.COA_COST_SRC_CD) E2
      ON (    E1.COST_YRMON = E2.COST_YRMON
          AND E1.FULL_MTY_CD = E2.FULL_MTY_CD
          AND E1.CNTR_TPSZ_CD = E2.CNTR_TPSZ_CD
          AND E1.COST_LOC_GRP_CD = E2.COST_LOC_GRP_CD
          AND E1.NOD_CD = E2.NOD_CD
          AND E1.COA_COST_SRC_CD = E2.COA_COST_SRC_CD)
      WHEN NOT MATCHED THEN
         INSERT(E1.COST_YRMON, E1.FULL_MTY_CD, E1.CNTR_TPSZ_CD, E1.COST_LOC_GRP_CD, E1.NOD_CD, E1.COA_COST_SRC_CD, E1.LOCL_CURR_CD
               ,E1.STND_COST_USD_AMT, E1.COST_ASS_BSE_CD, E1.NOD_TTL_QTY, E1.NOD_TTL_AMT, E1.COST_VOL_CD, E1.CRE_USR_ID, E1.CRE_DT, E1.UPD_USR_ID
               ,E1.UPD_DT)
         VALUES(E2.COST_YRMON, E2.FULL_MTY_CD, E2.CNTR_TPSZ_CD, E2.COST_LOC_GRP_CD, E2.NOD_CD, E2.COA_COST_SRC_CD, E2.LOCL_CURR_CD
               ,E2.STND_COST_USD_AMT, E2.COST_ASS_BSE_CD, E2.NOD_TTL_QTY, E2.NOD_TTL_AMT, NULL, 'SYS_COA_CRE', SYSDATE, 'SYS_COA_CRE', SYSDATE)
      WHEN MATCHED THEN
         UPDATE
            SET E1.LOCL_CURR_CD = E2.LOCL_CURR_CD, E1.STND_COST_USD_AMT = E2.STND_COST_USD_AMT, E1.COST_ASS_BSE_CD = E2.COST_ASS_BSE_CD
               ,E1.NOD_TTL_QTY = E2.NOD_TTL_QTY, E1.NOD_TTL_AMT = E2.NOD_TTL_AMT, E1.COST_VOL_CD = NULL, E1.UPD_USR_ID = 'SYS_COA_UPD'
               ,E1.UPD_DT = SYSDATE
         ;
   V_PRC_CNT := V_PRC_CNT + SQL%ROWCOUNT;
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'BOX MTY: ' || SQL%ROWCOUNT);
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'V_PRC_CNT: ' || TO_CHAR(V_PRC_CNT, '999,999,999,999'));
   ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', '소요시간: ' || TO_CHAR(SYSTIMESTAMP - V_START_TIME, 'yyyy/mm/dd hh24:mi:ss.ff'));
EXCEPTION
   WHEN OTHERS
   THEN
      ENIS_LOG_PRC(SYSDATE, 'COA_NOD_AVG_STND_COST_MTY_PRC', 'Error!! ' || V_COA_STEP || ' >> ' || SQLERRM);
END COA_NOD_AVG_STND_COST_MTY_PRC;