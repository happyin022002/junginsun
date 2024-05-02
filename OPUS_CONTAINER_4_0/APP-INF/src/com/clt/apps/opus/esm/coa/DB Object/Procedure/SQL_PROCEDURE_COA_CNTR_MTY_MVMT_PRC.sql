CREATE OR REPLACE PROCEDURE OPUSADM."COA_CNTR_MTY_MVMT_PRC" 
(in_yrmon IN VARCHAR2, in_mvmt_src_yrmon IN VARCHAR2, in_step IN NUMBER)  
   Authid current_user
IS  
/******************************************************************************  
   Name         :   COA_CNTR_MTY_MVMT_PRC  
   Purpose      :   Container별 MTY상태동안의 이동경로  
   Source       :   DW의 LO_CNTR_MOVE  
   Target       :   COA_CNTR_MTY_MVMT 
  
   1. CNTR_MVMT_STS (CD, CM, ID, IC, XX(Senator)|MT)로 시작해서 (MT|CP, OP, OC, XX(Senator))로 끝나는 Yard Tracking 기록  
      -> COA_CNTR_MTY_MVMT, COA_CNTR_MTY_MVMT_ROUT  
      -> 동일 Yard일 경우 첫 Yard 정보만 기록  
      -> 동일 Yard에서 CP, OP, OC, XX CNTR_MVMT_STS가 존재할 경우 이 Yard정보만 기록  
      -> Start 이후 CD, CM, ID, IC, XX, CP, OP, OC (NONE MTY) 를 만날경우 Reset후 Start Yard 재검색  
   2. 각 Yard (Node)별 하역비 계산      ( COA_NOD_AVG_STND_COST, COA_COST_SRC_ACCT, COA_LOCATION_V )  
   3. 각 Yard (Link)별 운반비 계산      ( COA_LNK_AVG_STND_COST, COA_COST_SRC_ACCT, COA_LOCATION_V )  
   4. ROUT별 단가합계, 평균이동일수 계산( COA_MTY_CNTR_ROUT_PERF )  
   5. ECC별 단가합계, 평균이동일수 계산 ( COA_MTY_ECC_CNTR_SMRY  )  
   6. 최종 단가 계산                    ( COA_MTY_ECC_UT_COST    )  
   7. Step 설명 - in_step 해당 step만 진행  
      - 0 : 전단계 진행  
      - 1 : Container Emtpy Status 선별 단계  
      - 2 : 하역비, 운반비 계산 단계  
      - 3 : ECC별 하역비, 운반비, 운반일수 요약 단계  
      - 4 : ECC별 하역비, 운반비, 운반일수 평균단가 계산 단계  
      - 5 : ECC별 하역비, 운반비, 운반일수 최종단가 계산 단계   
                                              
******************************************************************************/  
  
   --////////////////////////////////////////////////////////////////////////////////////////////////////////  
-- 1단계:  MTY 상태내역 커서 생성  
--         현재 전체컨데이터 리스트에서 컨테이너별 리스트로 변경 필요(전체로 처리할때 로직이 복잡함)  
/* MVMT_STS_CD 코드  
    BI   Bare Chassis Gate In  
    BO   Bare Chassis Gate Out  
    BR   Chassis Bare  
    EN   Enroute BTWN differant EQ CTRL Area  
    IC   Inbound full CY (순서6)  
    ID   Inbound full delivery (순서7)  
    MT   EMPTY CONTAINER (순서1)  
    OC   outbound full CY (순서3)  
    OP   Empty Release for outbound (순서2)  
    TN   Transportation within same EQ CTRL Area  
    TS   Transhipment  
    VD   Vessel discharge (순서5)  
    VL   Vessel Loading (순서4)  
    XX   XX status  
    CD   Domestic "ID"  (Domestic 미주지역을 의미함)  
    CE   Domestic "EN"  
    CI   Domestic "IC"  
    CM   Domestic "MT"  
    CO   Domestic "OC"  
    CP   Domestic "OP"  
    CT   Domestic "TN"  
    CX   Domestic "XX"  
*/  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
   CURSOR cntr_cursor(v_month VARCHAR2)  
   IS  
      SELECT  TO_CHAR(a.mvmt_dt, 'YYYYMM') monthly  
              ,a.cntr_no cntr_no  
              ,a.mvmt_sts_cd  
              ,a.mvmt_dt  
              ,a.yd_cd  
              ,a.full_mty_cd   --       ,A.CNTR_TPSZ_CD                  CNTR_TPSZ_CD  
              ,NVL(c.cntr_tpsz_cd_sp, a.cntr_tpsz_cd) cntr_tpsz_cd  
              ,a.co_cd co_cd  
              ,LEAD(a.mvmt_sts_cd, 1) OVER(ORDER BY a.cntr_no, a.mvmt_dt, a.cnmv_seq) next_mvmt_sts_cd   -- 후 MVMT  
              ,LAG(a.mvmt_sts_cd, 1) OVER(ORDER BY a.cntr_no, a.mvmt_dt, a.cnmv_seq) prev_mvmt_sts_cd   -- 전 MVMT  
              ,LEAD(a.yd_cd, 1) OVER(ORDER BY a.cntr_no, a.mvmt_dt, a.cnmv_seq) next_yd_cd   -- 후 야드  
              ,LEAD(a.co_cd, 1) OVER(ORDER BY a.cntr_no, a.mvmt_dt, a.cnmv_seq) next_co_cd   -- 전 회사  
              ,LAG(a.co_cd, 1) OVER(ORDER BY a.cntr_no, a.mvmt_dt, a.cnmv_seq) prev_co_cd   -- 후 회사  
              ,LEAD(a.cntr_no, 1) OVER(ORDER BY a.cntr_no, a.mvmt_dt, a.cnmv_seq) next_cntr_no   -- 후 컨테이너 NO  
              ,LEAD(a.mvmt_dt, 1) OVER(ORDER BY a.cntr_no, a.mvmt_dt, a.cnmv_seq) next_mvmt_dt   -- 후 MVMT 날짜  
          FROM coa_edw_if_mgmt a  
              ,(SELECT   cntr_tpsz_cd  
                        ,cntr_no  
                        ,yd_cd  
                        ,TO_CHAR(mvmt_dt, 'YYYYMMDD')  
                        ,MIN(mvmt_dt) mvmt_dt  
                    FROM coa_edw_if_mgmt  
                   WHERE mvmt_dt >= ADD_MONTHS(TO_DATE(in_mvmt_src_yrmon, 'YYYYMM'), -5) 
                     AND mvmt_dt < TO_DATE(in_mvmt_src_yrmon, 'YYYYMM')  
                GROUP BY cntr_tpsz_cd, cntr_no, yd_cd, TO_CHAR(mvmt_dt, 'YYYYMMDD')  
                ORDER BY cntr_tpsz_cd, cntr_no, yd_cd, mvmt_dt) b   -- (!주의) 같은 날짜에 CNTR 가 같은건이 들어온다. 1개만 선택  
              ,(SELECT cntr_tpsz_cd  
                      --,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', 'SP2', 'SP4') cntr_tpsz_cd_sp  
                      ,COA_UT_TPSZ_FNC('TPS' , CNTR_TPSZ_CD) cntr_tpsz_cd_sp  
                  FROM coa_spcl_repo_cntr_rgst  
                 WHERE list_bx_set_lvl_cd = '0001'  
                   AND spcl_cgo_flg = 'Y') c  
         WHERE a.cntr_tpsz_cd = b.cntr_tpsz_cd  
           AND a.cntr_no = b.cntr_no  
           AND a.yd_cd = b.yd_cd  
           AND a.mvmt_dt = b.mvmt_dt  
           AND a.cntr_tpsz_cd = c.cntr_tpsz_cd(+)  
           AND a.mvmt_dt >= ADD_MONTHS(TO_DATE(in_mvmt_src_yrmon, 'YYYYMM'), -5)  
           AND a.mvmt_dt < TO_DATE(in_mvmt_src_yrmon, 'YYYYMM')   
--           AND a.cntr_no = 'AMFU1395059' --테스트용 데이터  
      ORDER BY a.cntr_no, a.mvmt_dt, a.cnmv_seq;  
  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
-- 2단계:  MTY 상태내역 커서 생성  
--         SCC, ECC, LCC, RCC 현, 후 LOC 비교하기 위해 만듬  
--  
--      REP_YD_TP_CD 리스트  
--          M Marine Terminal  
--          Y CY  
--          S CFS  
--          R Rail Ramp  
--          B Barge Terminal  
--          P Pseudo Yard  
--  
--      coa_location_v 사용하는 쿼리 향후 수정필요 39,000 건 2007.12.03 박칠서  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
   CURSOR cntr_mty_cursor(v_month VARCHAR2)  
   IS  
      SELECT DISTINCT a.cost_yrmon cost_yrmon  
                     ,a.yd_cd yd_cd  
                     ,a.cntr_tpsz_cd cntr_tpsz_cd  
                     ,coa_ut_tpsz_fnc('SZ', a.cntr_tpsz_cd) cntr_tpsz_cd2  
                     ,a.nxt_yd_cd nxt_yd_cd  
                     ,NVL(v_s.scc_cd, 'XXXXX') scc_cd  
                     ,NVL(v_e.ecc_cd, 'XXXXX') ecc_cd  
                     ,NVL(v_l.lcc_cd, 'XXXXX') lcc_cd  
                     ,NVL(v_r.rcc_cd, 'XXXXX') rcc_cd  
                     ,NVL(v_s_n.scc_cd, 'XXXXX') nxt_scc_cd  
                     ,NVL(v_e_n.ecc_cd, 'XXXXX') nxt_ecc_cd  
                     ,NVL(v_l_n.lcc_cd, 'XXXXX') nxt_lcc_cd  
                     ,NVL(v_r_n.rcc_cd, 'XXXXX') nxt_rcc_cd  
                     ,NVL(b.rep_yd_tp_cd, 'X') rep_yd_tp_cd  
                 FROM coa_cntr_mty_mvmt a  
                     ,coa_location_v v_s  
                     ,coa_location_v v_e  
                     ,coa_location_v v_l  
                     ,coa_location_v v_r  
                     ,coa_location_v v_s_n  
                     ,coa_location_v v_e_n  
                     ,coa_location_v v_l_n  
                     ,coa_location_v v_r_n  
                     ,mdm_yard b  
                WHERE a.cost_yrmon = v_month 
                  AND SUBSTR(a.yd_cd, 1, 5) = v_s.loc_cd(+)   -- 현 YD 조건  
                  AND SUBSTR(a.yd_cd, 1, 5) = v_e.loc_cd(+)  
                  AND SUBSTR(a.yd_cd, 1, 5) = v_l.loc_cd(+)  
                  AND SUBSTR(a.yd_cd, 1, 5) = v_r.loc_cd(+)  
                  AND SUBSTR(a.nxt_yd_cd, 1, 5) = v_s_n.loc_cd(+)   -- 후 YD 조건  
                  AND SUBSTR(a.nxt_yd_cd, 1, 5) = v_e_n.loc_cd(+)  
                  AND SUBSTR(a.nxt_yd_cd, 1, 5) = v_l_n.loc_cd(+)  
                  AND SUBSTR(a.nxt_yd_cd, 1, 5) = v_r_n.loc_cd(+)  
                  AND a.yd_cd = b.yd_cd(+)  
                  AND mty_cost_tp_cd = 'M'  
             ORDER BY a.cost_yrmon, a.yd_cd, a.cntr_tpsz_cd;  
  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
-- 2단계:  DAYS 업데이트 할 컨테이너 커서 생성  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
   CURSOR days_cntr_cursor(v_month VARCHAR2)  
   IS  
      SELECT DISTINCT cntr_no  
                 FROM coa_cntr_mty_mvmt  
                WHERE cost_yrmon = v_month  
                  AND mty_cost_tp_cd = 'M';  
  
------------------------------[ 변수선언부             ]-----------------------  
  
   /** 작업로그 관련 변수선언 **/  
   v_mig_pgm_nm          VARCHAR2(100)  := 'COA_CNTR_MTY_MVMT_PRC';  
   v_mig_sub_sys_cd      VARCHAR2(3)    := 'COA';  
   v_mig_pic_nm          VARCHAR2(20)   := '오명석';  
   v_tgt_tbl_nm          VARCHAR2(100)  := 'COA_CNTR_MTY_MVMT';  
   v_src_tbl_nm          VARCHAR2(100)  := 'LO_CNTR_MOVE';  
   v_mig_st_dt           DATE;  
   v_ins_or_upd_cnt      NUMBER(18)     := 0;   -- 2007.11.29 박칠서 v_mig_knt -> v_ins_or_upd_cnt 변경  
   v_step2_prc_cnt       NUMBER(18)     := 0;   -- 2007.11.29 박칠서 v_mig_knt2 -> v_step2_prc_cnt 변경  
   v_mig_err_msg         VARCHAR2(1000);  
   /** Movement History 비교관련 변수선언 **/  
   v_yrmon               VARCHAR2(6)    := '';   -- 2007.11.29 박칠서 in_month_arg -> v_yrmon 변경  
   v_monthly             VARCHAR2(10)   := '';  
   v_container           VARCHAR2(20)   := '';  
   v_yard                VARCHAR2(10)   := '';  
   v_cntr_tpsz_cd        VARCHAR2(4)    := '';  
   v_mvmt_sts_cd         VARCHAR2(2)    := '';  
   v_mvmt_dt             DATE           := '';  
   v_empty               VARCHAR2(10)   := '';  
   v_move_seq            VARCHAR2(10)   := '';  
   v_seq                 NUMBER(4)      := 0;  
   v_set_seq             NUMBER(3)      := 0;  
   v_trans_unit          NUMBER(8)      := 1000;  
   v_is_ins              VARCHAR2(1)    := 'N';   -- 2007.11.28 박칠서 v_insert_flag -> v_is_ins 변경  
   v_is_upd              VARCHAR2(1)    := 'N';   -- 2007.11.28 박칠서 v_updt_flag -> v_is_upd 변경  
   v_is_mty_cntr         VARCHAR2(1)    := 'N';   -- 2007.11.28 박칠서 v_cnms_chk -> v_is_mty_cntr 변경  
   v_is_mty_end          VARCHAR2(1)    := 0;   -- 2007.11.29 박칠서 v_mty_end_chk -> v_is_mty_end 변경  
   v_is_diff_yd          VARCHAR2(1)    := 'N';   -- 2007.11.29 박칠서 v_yd_chk -> v_is_diff_yd 변경  
   v_mty_mvmt_cnt        NUMBER         := 0;   -- 2007.11.29 박칠서 v_rout_yd_seq -> v_mty_mvmt_cnt 변경  
   v_rout_n1st_yd_cd     VARCHAR2(7)    := '';  
   v_rout_lst_yd_cd      VARCHAR2(7)    := '';  
   v_mty_mvmt_rout_seq   NUMBER         := 0;   -- 2007.12.03 박칠서 v_rout_seq -> v_mty_mvmt_rout_seq 변경 : MTY CNTR ROUT 경우의 수  
   v_same_yd_cnt         NUMBER         := 0;   -- 2007.11.29 박칠서 v_yd_cnt -> v_same_yd_cnt 변경  
   v_stv_amt             NUMBER         := 0;  
   v_stv_amt_n           NUMBER         := 0;  
   v_stv_amt_s           NUMBER         := 0;  
   v_stv_amt_e           NUMBER         := 0;  
   v_stv_amt_l           NUMBER         := 0;  
   v_stv_amt_r           NUMBER         := 0;  
   v_lnk_amt             NUMBER         := 0;  
   v_lnk_amt_n           NUMBER         := 0;  
   v_lnk_amt_s           NUMBER         := 0;  
   v_lnk_amt_l           NUMBER         := 0;  
   v_lnk_amt_e           NUMBER         := 0;  
   v_lnk_amt_r           NUMBER         := 0;  
   v_n1st_mvmt_dt        DATE           := '';  
   v_lst_mvmt_dt         DATE           := '';  
   v_dur_mvmt_dt         NUMBER         := 0;  
   v_calc_node_remark    VARCHAR2(1000)   := '';  
   v_calc_link_remark    VARCHAR2(1000)   := '';  
   -- ROUT를 위한 변수  
   v_calc_node_amount    coa_cntr_mty_mvmt.mty_stvg_ttl_amt%TYPE;  
   v_calc_link_amount    coa_cntr_mty_mvmt.mty_stvg_ttl_amt%TYPE;  
   -- AMT update를 위한 변수  
   v_rout_yd_cd01        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd02        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd03        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd04        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd05        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd06        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd07        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd08        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd09        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd10        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd11        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd12        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd13        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd14        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd15        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd16        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd17        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd18        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd19        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd20        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd21        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd22        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd23        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd24        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd25        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd26        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd27        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd28        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd29        VARCHAR2(7)    := NULL;  
   v_rout_yd_cd30        VARCHAR2(7)    := NULL;  
   -- conti가 3개 이상인 cntr삭제 flag  
   v_conti_cnt           NUMBER         := 0;  
   v_is_del_cntr         CHAR(1)        := NULL;  
   ---MT 단가 만들 때 쓸 QTY 변수  
   v_rto_qty            coa_mty_ecc_cntr_smry.mty_qty%TYPE;  
-------------------------------[ 업무로직 구현부       ]-----------------------  
BEGIN  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
-- 시작일시 설정  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
   v_mig_st_dt := SYSDATE;  
  
   -- 아규먼트로 현재년월을 입력하지 않을 경우 현재년월 가져오기  
   IF in_yrmon IS NULL  
   THEN  
      v_yrmon := TO_CHAR(SYSDATE, 'YYYYMM');  
   ELSE  
      v_yrmon := in_yrmon;  
   END IF;  
  
   enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', 'Started (Year/Month ' || v_yrmon || ', Step : ' || in_step || ')');  
  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
-- 데이터 삭제  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
   IF    in_step <= 1  
      OR in_step = 0  
   THEN  
      /** 이미 만들어진 데이터가 있을 경우 삭제 **/  
      DELETE      coa_cntr_mty_mvmt  
            WHERE cost_yrmon = v_yrmon  
              AND mty_cost_tp_cd = 'M';  
  
            enis_log_prc (SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', 'COA_CNTR_MTY_MVMT '||SQL%ROWCOUNT || ' Records Deleted ');  
      COMMIT;  
   END IF;  
  
   IF    in_step <= 3  
      OR in_step = 0  
   THEN  
      /** 이미 만들어진 데이터가 있을 경우 삭제 **/  
      DELETE      coa_mty_cntr_rout_perf  
            WHERE cost_yrmon = v_yrmon  
              AND mty_cost_tp_cd = 'M';  
  
            enis_log_prc (SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', 'COA_MTY_CNTR_ROUT_PERF '||SQL%ROWCOUNT || ' Records Deleted ');  
      COMMIT;  
   END IF;  
  
   IF in_step <= 4 or in_step = 0 then  
      /** 이미 만들어진 데이터가 있을 경우 삭제 **/  
      DELETE      coa_mty_ecc_cntr_smry  
            WHERE cost_yrmon = v_yrmon  
              AND mty_cost_tp_cd = 'M';  
  
            enis_log_prc (SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', 'COA_MTY_ECC_CNTR_SMRY '||SQL%ROWCOUNT || ' Records Deleted ');  
      COMMIT;  
   END IF;  
  
   IF in_step <= 5 or in_step = 0 then  
      /** 이미 만들어진 데이터가 있을 경우 삭제 **/  
      DELETE      coa_mty_ecc_ut_cost  
            WHERE cost_yrmon = v_yrmon;  
  
            enis_log_prc (SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', 'COA_MTY_ECC_UT_COST '||SQL%ROWCOUNT || ' Records Deleted ');  
      COMMIT;  
   END IF;  
  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
-- 1단계 진행 (40분~1시간 소요)  
--      목적 : COA_CNTR_MTY_MVMT 에 3개월간 MTY 상태 갯수, MTY 상태 기간, 라우트별 갯수를 생성함.  
--      CNTR 리스트가 FULL, MTY 가 같이 들어오므로 MTY 구분처리 필요  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
   IF    in_step <= 1  
      OR in_step = 0  
   THEN  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', '1단계 시작 ');  
  
      -------------------------------[ Emtpy Container Movement 시작         ]-----------------------  
      FOR cntr_list IN cntr_cursor(v_yrmon)  
      LOOP  
         -- CNTR가 바뀌게 되면 리셋  
         IF    v_container != cntr_list.cntr_no  
            OR v_container IS NULL  
         THEN  
            v_container := cntr_list.cntr_no;  
            v_monthly := '';  
            v_yard := '';  
            v_cntr_tpsz_cd := '';  
            v_mvmt_sts_cd := '';  
            v_mvmt_dt := '';  
            v_empty := '';  
            v_move_seq := '';  
            v_seq := 0;  
            v_set_seq := 0;  
            v_is_mty_cntr := 'N';  
            v_mty_mvmt_cnt := 0;  
            v_rout_n1st_yd_cd := '';  
            v_rout_lst_yd_cd := '';  
            v_mty_mvmt_rout_seq := 0;  
            v_is_diff_yd := 'N';  
            v_is_mty_end := 'N';  
            v_n1st_mvmt_dt := '';  
            v_lst_mvmt_dt := '';  
            v_dur_mvmt_dt := 0;  
            cntr_list.prev_mvmt_sts_cd := '';  
         END IF;  
  
         -- container movement date 년월/SEQ 부여  
         IF    v_monthly <> cntr_list.monthly  
            OR v_monthly IS NULL  
         THEN  
            v_monthly := cntr_list.monthly;  
            v_seq := 0;  
         END IF;  
  
         IF v_is_mty_cntr <> 'Y'   -- CNTR가 MTY 가 아니면  
         THEN  
            -- 전 MVMT 상태가 'CD', 'CM', 'ID', 'IC', 'XX' 일 경우 현 CNTR 는 MTY 상태이다.  
            IF     (   cntr_list.prev_mvmt_sts_cd = 'CD'  
                    OR cntr_list.prev_mvmt_sts_cd = 'CM'  
                    OR cntr_list.prev_mvmt_sts_cd = 'ID'  
                    OR cntr_list.prev_mvmt_sts_cd = 'IC'  
                    OR (    cntr_list.prev_mvmt_sts_cd = 'XX'  
                        AND cntr_list.prev_co_cd = 'D')  
                   )   -- D (DSR+Senator=DESEN)인 XX만 적용  
               AND cntr_list.mvmt_sts_cd = 'MT'  
            THEN  
               v_rout_yd_cd01 := NULL;  
               v_rout_yd_cd02 := NULL;  
               v_rout_yd_cd03 := NULL;  
               v_rout_yd_cd04 := NULL;  
               v_rout_yd_cd05 := NULL;  
               v_rout_yd_cd06 := NULL;  
               v_rout_yd_cd07 := NULL;  
               v_rout_yd_cd08 := NULL;  
               v_rout_yd_cd09 := NULL;  
               v_rout_yd_cd10 := NULL;  
               v_rout_yd_cd11 := NULL;  
               v_rout_yd_cd12 := NULL;  
               v_rout_yd_cd13 := NULL;  
               v_rout_yd_cd14 := NULL;  
               v_rout_yd_cd15 := NULL;  
               v_rout_yd_cd16 := NULL;  
               v_rout_yd_cd17 := NULL;  
               v_rout_yd_cd18 := NULL;  
               v_rout_yd_cd19 := NULL;  
               v_rout_yd_cd20 := NULL;  
               v_rout_yd_cd21 := NULL;  
               v_rout_yd_cd22 := NULL;  
               v_rout_yd_cd23 := NULL;  
               v_rout_yd_cd24 := NULL;  
               v_rout_yd_cd25 := NULL;  
               v_rout_yd_cd26 := NULL;  
               v_rout_yd_cd27 := NULL;  
               v_rout_yd_cd28 := NULL;  
               v_rout_yd_cd29 := NULL;  
               v_rout_yd_cd30 := NULL;  
               v_yard := cntr_list.yd_cd;  
               v_cntr_tpsz_cd := cntr_list.cntr_tpsz_cd;  
               v_mvmt_sts_cd := cntr_list.mvmt_sts_cd;  
               v_mvmt_dt := cntr_list.mvmt_dt;  
               -- ROUT용  
               v_mty_mvmt_cnt := 0;  
               v_rout_n1st_yd_cd := '';  
               v_rout_lst_yd_cd := '';  
               v_mty_mvmt_rout_seq := 0;  
               v_is_ins := 'Y';  
               v_is_mty_cntr := 'Y';  
               v_rout_n1st_yd_cd := v_yard;  
               v_dur_mvmt_dt := 0;  
               -- First Movement Date  
               v_n1st_mvmt_dt := v_mvmt_dt;  
               -- mty group seq  
               v_set_seq := v_set_seq + 1;  
            END IF;  
         END IF;  
  
         -- 앞단에서 v_is_mty_cntr = 'Y' 이지만 MTY 상태로 바꾸는 코드가 들어올수 있어서 다시 현 상태 체크함  
         -- CD, CM, ID, IC, XX, CP, OP, OC (NONE MTY) 를 만날경우 IS_MTY = 'N', INSERT만 함  
         IF     (   cntr_list.mvmt_sts_cd = 'CD'  
                 OR cntr_list.mvmt_sts_cd = 'CM'  
                 OR cntr_list.mvmt_sts_cd = 'ID'  
                 OR cntr_list.mvmt_sts_cd = 'IC'  
                 OR cntr_list.mvmt_sts_cd = 'XX'  
                 OR cntr_list.mvmt_sts_cd = 'CP'  
                 OR cntr_list.mvmt_sts_cd = 'OP'  
                 OR cntr_list.mvmt_sts_cd = 'OC'  
                )  
            AND v_is_mty_cntr = 'Y'  
         THEN  
            v_is_mty_cntr := 'N';  
         END IF;  
  
         IF v_is_mty_cntr = 'Y'  
         THEN  
            -- CNTR MVMT 리스트에서 현재상태가 MTY 마직막인지 체크  
            -- D (Senator)인 XX만 적용  
            IF (    cntr_list.mvmt_sts_cd = 'MT'  
                AND (    cntr_list.cntr_no = cntr_list.next_cntr_no  
                     AND (   cntr_list.next_mvmt_sts_cd = 'CP'  
                          OR cntr_list.next_mvmt_sts_cd = 'OP'  
                          OR cntr_list.next_mvmt_sts_cd = 'OC'  
                          OR (    cntr_list.next_mvmt_sts_cd = 'XX'  
                              AND cntr_list.next_co_cd = 'D')  
                         )  
                    )  
               )  
            THEN  
               v_is_mty_end := 'Y';  
            ELSE  
               v_is_mty_end := 'N';  
            END IF;  
  
            -- container 변경되거나 Yard가 바꼈을 때 yard check 수행  
            IF    v_yard <> cntr_list.yd_cd  
               OR v_yard IS NULL  
            THEN  
               v_is_diff_yd := 'Y';  
            END IF;  
  
            -- 동일Yard에서 첫Yard만 입력  
            IF    v_is_diff_yd = 'Y'  
               OR v_is_mty_end = 'Y'  
            THEN  
               v_is_diff_yd := 'N';  
               v_is_ins := 'Y';  
               v_yard := cntr_list.yd_cd;  
               v_cntr_tpsz_cd := cntr_list.cntr_tpsz_cd;  
               v_mvmt_sts_cd := cntr_list.mvmt_sts_cd;  
               v_mvmt_dt := cntr_list.mvmt_dt;  
  
               -- mty mvmt end에서 동일 yard가 있는지 확인  
               IF v_is_mty_end = 'Y'  
               THEN  
                  -- Last Movement Date  
                  v_lst_mvmt_dt := v_mvmt_dt;  
                  -- CNTR 이동 기간  
                  v_dur_mvmt_dt := v_lst_mvmt_dt - v_n1st_mvmt_dt;  
  
                  IF v_dur_mvmt_dt < 1  
                  THEN  
                     v_dur_mvmt_dt := 1;  
                  END IF;  
  
                  -- 이전 v_move_seq가 동일 Yard인지 확인  
                  v_same_yd_cnt := 0;  
  
                  SELECT COUNT(*)  
                    INTO v_same_yd_cnt  
                    FROM coa_cntr_mty_mvmt  
                   WHERE cost_yrmon = v_yrmon  
                     AND cntr_no = v_container  
                     AND mon_mvmt_seq = v_move_seq   -- 이전 move_seq  
                     AND yd_cd = v_yard   -- 현재 Yard  
                     AND cnmv_sts_cd NOT IN('CD', 'CM', 'ID', 'IC', 'XX')  
                     AND cntr_rout_seq = v_set_seq  
                     AND mty_cost_tp_cd = 'M';  
  
                  IF v_same_yd_cnt > 0  
                  THEN  
                     DELETE FROM coa_cntr_mty_mvmt  
                           WHERE cost_yrmon = v_yrmon  
                             AND cntr_no = v_container  
                             AND mon_mvmt_seq = v_move_seq   -- 이전 move_seq  
                             AND cntr_rout_seq = v_set_seq  
                             AND mty_cost_tp_cd = 'M';  
  
                     v_mty_mvmt_cnt := v_mty_mvmt_cnt - 1;   -- MTY 이동한 번호를 감소한다.  
                  END IF;  
  
                  -- 마지막 yd 변수 처리  
                  v_rout_lst_yd_cd := v_yard;  
                  v_is_ins := 'Y';  
                  v_is_upd := 'Y';  
                  v_is_mty_cntr := 'N';  
                  v_n1st_mvmt_dt := '';  
                  v_lst_mvmt_dt := '';  
               END IF;  
            END IF;  
         END IF;  
  
         IF v_is_ins = 'Y'  
         THEN  
            -- 이전 v_move_seq  
            v_seq := v_seq + 1;  
            v_move_seq := v_monthly || TRIM(TO_CHAR(v_seq, '000'));  
  
            INSERT INTO coa_cntr_mty_mvmt  
                        (cost_yrmon  
                        ,cntr_no  
                        ,mon_mvmt_seq   -- 년월+seq 정렬용 의미없음  
                        ,yd_cd  
                        ,cntr_tpsz_cd  
                        ,cnmv_sts_cd  
                        ,cnmv_dt  
                        ,cntr_rout_seq   -- 조회기간내에 MTY 가 몇번 있었는지 CNT  
                        ,rout_n1st_yd_cd   -- COA_CNTR_MTY_MVMT_ROUT 에 들어가는 ROUT_N1ST_YD_CD  
                        ,rout_lst_yd_cd   -- COA_CNTR_MTY_MVMT_ROUT 에 들어가는 ROUT_LST_YD_CD  
                        ,rout_seq   -- COA_CNTR_MTY_MVMT_ROUT 에 들어가는 ROUT_SEQ  
                        ,mty_stvg_ttl_amt  
                        ,mty_trsp_ttl_amt  
                        ,cost_cre_sts_cd   -- N: MTY 미확정, Y: MTY 확정, A(APPROVAL): MTY 승인 MTY 미확정은 다음단계에서 삭제됨  
                        ,mty_dur_dys                        
                        ,mty_cost_tp_cd
                        ,cre_usr_id
                        ,cre_dt
                        ,upd_usr_id
                        ,upd_dt
                        )  
                 VALUES (v_yrmon  
                        ,v_container  
                        ,v_move_seq  
                        ,v_yard  
                        ,v_cntr_tpsz_cd  
                        ,v_mvmt_sts_cd  
                        ,v_mvmt_dt  
                        ,v_set_seq  
                        ,''   -- INS '' --> UPD v_rout_n1st_yd_cd 넣음  
                        ,''   -- INS '' --> UPD v_rout_lst_yd_cd 넣음  
                        ,0   -- INS 0 --> UPD v_mty_mvmt_rout_seq 넣음  
                        ,0   -- 2단계에서 UPD  
                        ,0   -- 2단계에서 UPD  
                        ,'N'   -- INS 'N' --> UPD 'Y' 넣음  
                        ,v_dur_mvmt_dt   -- LST MVMT DT - N1ST MVMT DT                         
                        ,'M' -- MT repo Cost 용 단가 생성  
                        ,'SYS_COA'
                        ,SYSDATE
                        ,'SYS_COA'
                        ,SYSDATE
                        );  
  
            v_is_ins := 'N';  
            v_ins_or_upd_cnt := v_ins_or_upd_cnt + 1;  
  
            IF MOD(v_ins_or_upd_cnt, v_trans_unit) = 0   -- 1000개 INSERT 후 커밋함(속도개선을 위해: 검증필요)  
            THEN  
               COMMIT;  
            END IF;  
  
            -- MTY로 상태가 변경될때 마다 MTY 상태인 YD를 변수에 저장한다.  
            v_mty_mvmt_cnt := v_mty_mvmt_cnt + 1;   -- INS 시 마다 증가  
  
            IF v_mty_mvmt_cnt = 1  
            THEN  
               v_rout_yd_cd01 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 2  
            THEN  
               v_rout_yd_cd02 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 3  
            THEN  
               v_rout_yd_cd03 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 4  
            THEN  
               v_rout_yd_cd04 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 5  
            THEN  
               v_rout_yd_cd05 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 6  
            THEN  
               v_rout_yd_cd06 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 7  
            THEN  
               v_rout_yd_cd07 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 8  
            THEN  
               v_rout_yd_cd08 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 9  
            THEN  
               v_rout_yd_cd09 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 10  
            THEN  
               v_rout_yd_cd10 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 11  
            THEN  
               v_rout_yd_cd11 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 12  
            THEN  
               v_rout_yd_cd12 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 13  
            THEN  
               v_rout_yd_cd13 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 14  
            THEN  
               v_rout_yd_cd14 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 15  
            THEN  
               v_rout_yd_cd15 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 16  
            THEN  
               v_rout_yd_cd16 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 17  
            THEN  
               v_rout_yd_cd17 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 18  
            THEN  
               v_rout_yd_cd18 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 19  
            THEN  
               v_rout_yd_cd19 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 20  
            THEN  
               v_rout_yd_cd20 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 21  
            THEN  
               v_rout_yd_cd21 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 22  
            THEN  
               v_rout_yd_cd22 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 23  
            THEN  
               v_rout_yd_cd23 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 24  
            THEN  
               v_rout_yd_cd24 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 25  
            THEN  
               v_rout_yd_cd25 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 26  
            THEN  
               v_rout_yd_cd26 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 27  
            THEN  
               v_rout_yd_cd27 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 28  
            THEN  
               v_rout_yd_cd28 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 29  
            THEN  
               v_rout_yd_cd29 := v_yard;  
            ELSIF v_mty_mvmt_cnt = 30  
            THEN  
               v_rout_yd_cd30 := v_yard;  
            END IF;  
         END IF;  
  
         IF v_is_upd = 'Y'  
         THEN  
            BEGIN  
               -- 현재 MTY MVMT ROUT와 같은 경로가 있는지 체크  
               SELECT rout_seq  
                 INTO v_mty_mvmt_rout_seq  
                 FROM coa_cntr_mty_mvmt_rout   -- 2007.11.29 현재 YD_CD13까지 데이터 있는것 있음  
                WHERE rout_n1st_yd_cd = v_rout_n1st_yd_cd  
                  AND rout_lst_yd_cd = v_rout_lst_yd_cd  
                  AND NVL(rout_yd_cd01, 'N') = NVL(v_rout_yd_cd01, 'N')  
                  AND NVL(rout_yd_cd02, 'N') = NVL(v_rout_yd_cd02, 'N')  
                  AND NVL(rout_yd_cd03, 'N') = NVL(v_rout_yd_cd03, 'N')  
                  AND NVL(rout_yd_cd04, 'N') = NVL(v_rout_yd_cd04, 'N')  
                  AND NVL(rout_yd_cd05, 'N') = NVL(v_rout_yd_cd05, 'N')  
                  AND NVL(rout_yd_cd06, 'N') = NVL(v_rout_yd_cd06, 'N')  
                  AND NVL(rout_yd_cd07, 'N') = NVL(v_rout_yd_cd07, 'N')  
                  AND NVL(rout_yd_cd08, 'N') = NVL(v_rout_yd_cd08, 'N')  
                  AND NVL(rout_yd_cd09, 'N') = NVL(v_rout_yd_cd09, 'N')  
                  AND NVL(rout_yd_cd10, 'N') = NVL(v_rout_yd_cd10, 'N')  
                  AND NVL(rout_yd_cd11, 'N') = NVL(v_rout_yd_cd11, 'N')  
                  AND NVL(rout_yd_cd12, 'N') = NVL(v_rout_yd_cd12, 'N')  
                  AND NVL(rout_yd_cd13, 'N') = NVL(v_rout_yd_cd13, 'N')  
                  AND NVL(rout_yd_cd14, 'N') = NVL(v_rout_yd_cd14, 'N')  
                  AND NVL(rout_yd_cd15, 'N') = NVL(v_rout_yd_cd15, 'N')  
                  AND NVL(rout_yd_cd16, 'N') = NVL(v_rout_yd_cd16, 'N')  
                  AND NVL(rout_yd_cd17, 'N') = NVL(v_rout_yd_cd17, 'N')  
                  AND NVL(rout_yd_cd18, 'N') = NVL(v_rout_yd_cd18, 'N')  
                  AND NVL(rout_yd_cd19, 'N') = NVL(v_rout_yd_cd19, 'N')  
                  AND NVL(rout_yd_cd20, 'N') = NVL(v_rout_yd_cd20, 'N')  
                  AND NVL(rout_yd_cd21, 'N') = NVL(v_rout_yd_cd21, 'N')  
                  AND NVL(rout_yd_cd22, 'N') = NVL(v_rout_yd_cd22, 'N')  
                  AND NVL(rout_yd_cd23, 'N') = NVL(v_rout_yd_cd23, 'N')  
                  AND NVL(rout_yd_cd24, 'N') = NVL(v_rout_yd_cd24, 'N')  
                  AND NVL(rout_yd_cd25, 'N') = NVL(v_rout_yd_cd25, 'N')  
                  AND NVL(rout_yd_cd26, 'N') = NVL(v_rout_yd_cd26, 'N')  
                  AND NVL(rout_yd_cd27, 'N') = NVL(v_rout_yd_cd27, 'N')  
                  AND NVL(rout_yd_cd28, 'N') = NVL(v_rout_yd_cd28, 'N')  
                  AND NVL(rout_yd_cd29, 'N') = NVL(v_rout_yd_cd29, 'N')  
                  AND NVL(rout_yd_cd30, 'N') = NVL(v_rout_yd_cd30, 'N');  
            EXCEPTION  
               WHEN NO_DATA_FOUND  
               THEN  
                  -- 없으면 MTY MVMT ROUT CASE 를 하나 더 추가한다.  
                  SELECT MAX(rout_seq)  
                    INTO v_mty_mvmt_rout_seq  
                    FROM coa_cntr_mty_mvmt_rout  
                   WHERE rout_n1st_yd_cd = v_rout_n1st_yd_cd  
                     AND rout_lst_yd_cd = v_rout_lst_yd_cd;  
  
                  IF v_mty_mvmt_rout_seq > 0  
                  THEN  
                     v_mty_mvmt_rout_seq := v_mty_mvmt_rout_seq + 1;  
                  ELSE  
                     v_mty_mvmt_rout_seq := 1;  
                  END IF;  
  
                  -- COA_CNTR_MTY_MVMT_ROUT : 삭제 없이 계속 ROUT CASE 별로 누적되는 데이터임  
                  INSERT INTO coa_cntr_mty_mvmt_rout  
                              (rout_n1st_yd_cd  
                              ,rout_lst_yd_cd  
                              ,rout_seq  
                              ,rout_yd_cd01  
                              ,rout_yd_cd02  
                              ,rout_yd_cd03  
                              ,rout_yd_cd04  
                              ,rout_yd_cd05  
                              ,rout_yd_cd06  
                              ,rout_yd_cd07  
                              ,rout_yd_cd08  
                              ,rout_yd_cd09  
                              ,rout_yd_cd10  
                              ,rout_yd_cd11  
                              ,rout_yd_cd12  
                              ,rout_yd_cd13  
                              ,rout_yd_cd14  
                              ,rout_yd_cd15  
                              ,rout_yd_cd16  
                              ,rout_yd_cd17  
                              ,rout_yd_cd18  
                              ,rout_yd_cd19  
                              ,rout_yd_cd20  
                              ,rout_yd_cd21  
                              ,rout_yd_cd22  
                              ,rout_yd_cd23  
                              ,rout_yd_cd24  
                              ,rout_yd_cd25  
                              ,rout_yd_cd26  
                              ,rout_yd_cd27  
                              ,rout_yd_cd28  
                              ,rout_yd_cd29  
                              ,rout_yd_cd30  
                              ,cre_usr_id  
                              ,cre_dt 
                              ,upd_usr_id
                              ,upd_dt 
                              )  
                       VALUES (v_rout_n1st_yd_cd  
                              ,v_rout_lst_yd_cd  
                              ,v_mty_mvmt_rout_seq  
                              ,v_rout_yd_cd01  
                              ,v_rout_yd_cd02  
                              ,v_rout_yd_cd03  
                              ,v_rout_yd_cd04  
                              ,v_rout_yd_cd05  
                              ,v_rout_yd_cd06  
                              ,v_rout_yd_cd07  
                              ,v_rout_yd_cd08  
                              ,v_rout_yd_cd09  
                              ,v_rout_yd_cd10  
                              ,v_rout_yd_cd11  
                              ,v_rout_yd_cd12  
                              ,v_rout_yd_cd13  
                              ,v_rout_yd_cd14  
                              ,v_rout_yd_cd15  
                              ,v_rout_yd_cd16  
                              ,v_rout_yd_cd17  
                              ,v_rout_yd_cd18  
                              ,v_rout_yd_cd19  
                              ,v_rout_yd_cd20  
                              ,v_rout_yd_cd21  
                              ,v_rout_yd_cd22  
                              ,v_rout_yd_cd23  
                              ,v_rout_yd_cd24  
                              ,v_rout_yd_cd25  
                              ,v_rout_yd_cd26  
                              ,v_rout_yd_cd27  
                              ,v_rout_yd_cd28  
                              ,v_rout_yd_cd29  
                              ,v_rout_yd_cd30  
                              ,'SYSTEM'  
                              ,SYSDATE  
                              ,'SYSTEM'  
                              ,SYSDATE  
                              );  
            END;  
  
            -- 확정 'Y' 마킹  
            UPDATE coa_cntr_mty_mvmt  
               SET cost_cre_sts_cd = 'Y'  
                  ,rout_n1st_yd_cd = v_rout_n1st_yd_cd   -- COA_CNTR_MTY_MVMT_ROUT 에 들어가는 ROUT_N1ST_YD_CD  
                  ,rout_lst_yd_cd = v_rout_lst_yd_cd   -- COA_CNTR_MTY_MVMT_ROUT 에 들어가는 ROUT_LST_YD_CD  
                  ,rout_seq = v_mty_mvmt_rout_seq   -- COA_CNTR_MTY_MVMT_ROUT 에 들어가는 ROUT_SEQ  
             WHERE cost_yrmon = v_yrmon  
               AND cntr_no = v_container  
               AND cntr_rout_seq = v_set_seq  
               AND mty_cost_tp_cd = 'M';  
  
            v_is_upd := 'N';  
         END IF;  
      END LOOP;  
  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', 'COA_CNTR_MTY_MVMT ' || v_ins_or_upd_cnt || ' Records Inserted ');  
  
      -- 이전 CNTR가 MTY 체크를 완료하지 못했을 경우 삭제  
      DELETE      coa_cntr_mty_mvmt  
            WHERE cost_yrmon = v_yrmon  
              AND cost_cre_sts_cd = 'N'  
              AND mty_cost_tp_cd = 'M';  
  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', 'COA_CNTR_MTY_MVMT ' || SQL%ROWCOUNT || ' Records Deleted ');  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', '1단계 종료 ');  
      COMMIT;  
   END IF;  
  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
-- 2단계 진행 (2시간 소요)  
--      MTY 하역, 운바비 생성, MTY 일수 생성, CONTI 3개이상인 레코드 삭제  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
   IF    in_step <= 2  
      OR in_step = 0  
   THEN  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', '2단계 시작 ');  
  
      -- A(APPROVAL) 승인을 Y(YES) 확정으로 변경함  
      UPDATE coa_cntr_mty_mvmt  
         SET cost_cre_sts_cd = 'Y'  
       WHERE cost_yrmon = v_yrmon  
         AND cost_cre_sts_cd = 'A'  
         AND mty_cost_tp_cd = 'M';  
  
      -- NEXT YARD CODE 업데이트  
      MERGE INTO coa_cntr_mty_mvmt b1  
         USING (SELECT cost_yrmon  
                      ,cntr_no  
                      ,mon_mvmt_seq  
                      ,LEAD(yd_cd, 1) OVER(ORDER BY cost_yrmon, cntr_no, mon_mvmt_seq) nxt_yd_cd  
                      ,mty_cost_tp_cd  
                  FROM coa_cntr_mty_mvmt  
                 WHERE cost_yrmon = v_yrmon  
                   AND mty_cost_tp_cd = 'M') b2  
         ON (    b1.cost_yrmon = b2.cost_yrmon  
             AND b1.cntr_no = b2.cntr_no  
             AND b1.mon_mvmt_seq = b2.mon_mvmt_seq  
             AND b1.mty_cost_tp_cd = b2.mty_cost_tp_cd)  
         WHEN MATCHED THEN  
            UPDATE  
               SET b1.nxt_yd_cd = b2.nxt_yd_cd  
            ;  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', 'NEXT_YD_CD Update  ' || SQL%ROWCOUNT || ' Records Updated ');  
      COMMIT;  
      -------------------------------[ 하역비, 운반비 계산         ]-----------------------  
      v_ins_or_upd_cnt := 0;  
      v_step2_prc_cnt := 0;  
      v_yard := '';  
  
      FOR cntr_mty_list IN cntr_mty_cursor(v_yrmon)  
      LOOP  
         -- 2007.05.16  
         -- MDM_YARD.REP_YD_TP_CD <> 'M' AND COA_COST_SRC_CD IN ('SVLDMT', 'SVLDTM') 이면 NOD 단가 0으로 처리  
         -- MDM_YARD.REP_YD_TP_CD =  'M' : Terminal Yard  
             --YARD의 대표속성입니다.  
             --M-MARINE TERMINAL  
             --P-PSEUDO YARD  
             --B-BARGE TERMINAL  
             --R-RAIL RAMP  
             --S-CFS  
             --Y-YARD  
         -- Terminal Yard가 아닐경우 Terminal NOD비용이 붙이면 안된다.  
           
        /**********************************************************************************************************  
        * -- LCC 이후 붙는 data를 찾아서 통보해 주기 위해 remark를 column에 update 한다.                          *  
        * -- update 하기 위해서 변수에 담아 놓는다.     -20080403 전윤주                                          *  
        * -- 금액도 변수에 담아두고 나중에 update 한다. Remark와 같은 Logic 이므로 -20080918 전윤주               *  
        ***********************************************************************************************************/   
           BEGIN  
             SELECT DECODE(SIGN(stnd_cost_usd_amt_n)  
                                 ,1, 'NODE'  
                                 ,0, 'NODE'   
                                 ,DECODE(SIGN(stnd_cost_usd_amt_s)  
                                        ,1, 'SCC'  
                                        ,0, 'SCC'  
                                        ,DECODE(SIGN(stnd_cost_usd_amt_e)  
                                               ,1, 'ECC'  
                                               ,0, 'ECC'  
                                               ,DECODE(SIGN(stnd_cost_usd_amt_l)  
                                                      ,1, 'LCC'  
                                                      ,0, 'LCC'  
                                                      ,DECODE(SIGN(stnd_cost_usd_amt_r)  
                                                      ,1, 'RCC'  
                                                      ,0, 'RCC'  
                                                      ,'NODATA')  
                                                      )  
                                                )  
                                         )  
                            )   -- 어느 level에 있는 값을 가져올건지 선택  
                      ,DECODE(SIGN(stnd_cost_usd_amt_n)  
                                 ,1, stnd_cost_usd_amt_n  
                                 ,0, stnd_cost_usd_amt_n   
                                 ,DECODE(SIGN(stnd_cost_usd_amt_s)  
                                        ,1, stnd_cost_usd_amt_s  
                                        ,0, stnd_cost_usd_amt_s  
                                        ,DECODE(SIGN(stnd_cost_usd_amt_e)  
                                               ,1, stnd_cost_usd_amt_e  
                                               ,0, stnd_cost_usd_amt_e  
                                               ,DECODE(SIGN(stnd_cost_usd_amt_l)  
                                                      ,1, stnd_cost_usd_amt_l  
                                                      ,0, stnd_cost_usd_amt_l  
                                                      ,DECODE(SIGN(stnd_cost_usd_amt_r)  
                                                      ,1, stnd_cost_usd_amt_r  
                                                      ,0, stnd_cost_usd_amt_r  
                                                      ,0)  
                                                      )  
                                               )  
                                         )  
                                  )   -- 어느 level에 있는 값을 가져올건지 선택  
                 into v_calc_node_remark  
                     ,v_calc_node_amount  
                      -------------------------------------------------------------------------------------------------------                                                                
                 FROM (SELECT CASE  
                                WHEN b1.amt_node >= 0 --0으로 넣어주는 단가가 있으므로 0이어도 붙여줘야 한다. 그 level에 없는 건 null로 들어옴  
                                  THEN b1.amt_node --node에 단가가 있으면 그 단가를 쓴다   
                                ELSE CASE   
                                       WHEN b1.amt_tmnd = 1   
                                         THEN b2.amt_node --단가가 없는데 그 붙을 단가가 TMNDMT 계정이었다면 TPNDMT 단가(b2에 select 해놓은 단가) 를 쓴다.  
                                       WHEN b1.amt_tmfd > 0   
                                         THEN b3.amt_node  
                                       ELSE null --단가가 없는데 그 붙을 단가가 TMFDMT나 TMFDXM 계정이었다면 TMNDMT단가(b3에 select 해놓은 단가)를 쓴다.  
                                     END  
                              END AS stnd_cost_usd_amt_n  
                                
                             ,CASE  
                                WHEN b1.amt_scc >= 0   
                                  THEN b1.amt_scc --SCC에 단가가 있으면 그 단가를 쓴다   
                                ELSE CASE   
                                        WHEN b1.amt_tmnd = 1   
                                         THEN b2.amt_node --단가가 없는데 그 붙을 단가가 TMNDMT 계정이었다면 TPNDMT 단가(b2에 select 해놓은 단가) 를 쓴다.  
                                       WHEN b1.amt_tmfd > 0   
                                         THEN b3.amt_node  
                                       ELSE null --단가가 없는데 그 붙을 단가가 TMFDMT나 TMFDXM 계정이었다면 TMNDMT단가(b3에 select 해놓은 단가)를 쓴다.  
                                     END  
                              END AS stnd_cost_usd_amt_s  
                                
                             ,CASE  
                                WHEN b1.amt_ecc >= 0   
                                  THEN b1.amt_ecc --ECC에 단가가 있으면 그 단가를 쓴다   
                                ELSE CASE   
                                       WHEN b1.amt_tmnd = 1   
                                         THEN b2.amt_node --단가가 없는데 그 붙을 단가가 TMNDMT 계정이었다면 TPNDMT 단가(b2에 select 해놓은 단가) 를 쓴다.  
                                       WHEN b1.amt_tmfd > 0   
                                         THEN b3.amt_node  
                                       ELSE null --단가가 없는데 그 붙을 단가가 TMFDMT나 TMFDXM 계정이었다면 TMNDMT단가(b3에 select 해놓은 단가)를 쓴다.  
                                     END  
                              END AS stnd_cost_usd_amt_e   
                                
                             ,CASE  
                                WHEN b1.amt_lcc >= 0   
                                  THEN b1.amt_lcc --node에 단가가 있으면 그 단가를 쓴다   
                                ELSE CASE  
                                       WHEN b1.amt_tmnd = 1   
                                         THEN b2.amt_node --단가가 없는데 그 붙을 단가가 TMNDMT 계정이었다면 TPNDMT 단가(b2에 select 해놓은 단가) 를 쓴다.  
                                       WHEN b1.amt_tmfd > 0   
                                         THEN b3.amt_node  
                                       ELSE null --단가가 없는데 그 붙을 단가가 TMFDMT나 TMFDXM 계정이었다면 TMNDMT단가(b3에 select 해놓은 단가)를 쓴다.  
                                     END  
                              END AS stnd_cost_usd_amt_l   
                                
                             ,CASE  
                                WHEN b1.amt_rcc >= 0   
                                  THEN b1.amt_rcc --node에 단가가 있으면 그 단가를 쓴다   
                                ELSE CASE   
                                        WHEN b1.amt_tmnd = 1   
                                         THEN b2.amt_node --단가가 없는데 그 붙을 단가가 TMNDMT 계정이었다면 TPNDMT 단가(b2에 select 해놓은 단가) 를 쓴다.  
                                       WHEN b1.amt_tmfd > 0   
                                         THEN b3.amt_node  
                                       ELSE null --단가가 없는데 그 붙을 단가가 TMFDMT나 TMFDXM 계정이었다면 TMNDMT단가(b3에 select 해놓은 단가)를 쓴다.  
                                     END  
                              END AS stnd_cost_usd_amt_r        
                                  
                             -- TMNDMT 값을 붙여야 하는데 그 단가를 들고 있지 않는 경우에는 별도로 가져온 TPNDMT 값을 붙여준다.  
                             --(EX: CNHKG 같은 경우 TMNDMT 단가를 들고 있지 않다. 그런데 Node에서 들어온 값이 TMND를 붙여야 할 경우  
                             -- TPND로 찾아서 붙여준다. 만약에 TMNDMT 단가는 없는데 TMFD 계정들이 있을 경우에는 그 값을 사용하고 없으면 상위)                                                                                                                             
                       FROM          
                           (SELECT SUM(stnd_cost_usd_amt_n) amt_node  
                                  ,SUM(stnd_cost_usd_amt_s) amt_scc  
                                  ,SUM(stnd_cost_usd_amt_e) amt_ecc  
                                  ,SUM(stnd_cost_usd_amt_l) amt_lcc  
                                  ,SUM(stnd_cost_usd_amt_r) amt_rcc --각각의 level의 amount 합계를 구한다.(계정별로 들고 있었던 것을 SUM  
                                  ,SUM(cnt) cnt --TPNDMT 계정이 있는지 없는지 check  
                                  ,SUM(amt_tmnd) amt_tmnd -- location 별로 TMNDMT 의 Amount를 SUM해서 가지고 있는다. 0이면 위에서 TPNDMT를 붙여줌  
                                  ,SUM(amt_tmfd) amt_tmfd  
                            FROM (SELECT (DECODE(a.cost_loc_grp_cd,'N', NVL(a.stnd_cost_usd_amt, 0),null)) stnd_cost_usd_amt_n                                                                                                                     
                                        ,(DECODE(a.cost_loc_grp_cd,'S', NVL(a.stnd_cost_usd_amt, 0),null)) stnd_cost_usd_amt_s  
                                        ,(DECODE(a.cost_loc_grp_cd,'E', NVL(a.stnd_cost_usd_amt, 0),null)) stnd_cost_usd_amt_e              
                                        ,(DECODE(a.cost_loc_grp_cd,'L', NVL(a.stnd_cost_usd_amt, 0),null)) stnd_cost_usd_amt_l                            
                                        ,(DECODE(a.cost_loc_grp_cd,'R', NVL(a.stnd_cost_usd_amt, 0),null)) stnd_cost_usd_amt_r -- 계정별로 단가를 들고 있는다.   
                                        ,a.coa_cost_src_cd                                                                        
                                        ,SUM(DECODE(a.coa_cost_src_cd, 'TPNDMT', 1, 0)) OVER (partition by a.cost_loc_grp_cd) AS cnt --TPNDMT 계정이 있으면 1, 없으면 0  
                                        ,SUM(DECODE(a.coa_cost_src_cd, 'TMNDMT', 1, 0)) OVER (partition by a.cost_loc_grp_cd) AS amt_tmnd  --TMNDMT 계정이 있으면 1, 없으면 0  
                                        ,SUM(DECODE(a.coa_cost_src_cd, 'TMFDMT', 1, 'TMFDXM', 1, 0)) OVER (partition by a.cost_loc_grp_cd) AS amt_tmfd --TMFD 계정들이 값이 있는지                                                
                                   FROM coa_nod_avg_stnd_cost a, coa_cost_src_acct b   -- NODE 평균단가 사용                                              
                                  WHERE a.cost_yrmon = v_yrmon  
                                    AND a.full_mty_cd = 'M'  
                                    AND a.cntr_tpsz_cd = cntr_mty_list.cntr_tpsz_cd2  
                                    AND a.cost_loc_grp_cd IN('N', 'S', 'E', 'L', 'R')  
                                    AND a.nod_cd =  
                                            DECODE(a.cost_loc_grp_cd                                                                 
                                                         ,'N', cntr_mty_list.yd_cd  
                                                         ,'S', cntr_mty_list.scc_cd  
                                                         ,'E', cntr_mty_list.ecc_cd  
                                                         ,'L', cntr_mty_list.lcc_cd  
                                                         ,'R', cntr_mty_list.rcc_cd     
                                                   )  
                                    AND a.coa_cost_src_cd = b.coa_cost_src_cd  
                                    AND b.cost_src_sys_cd = 'TES'  
                                    AND b.full_mty_cd = 'M'  
                                    -- (! 주의)M(MARINE TERMINAL), B(BARGE TERMINAL)인 경우 즉 물옆에 있을으면 FD(OFF DOCK) 아닌것  
                                    AND a.coa_cost_src_cd NOT LIKE DECODE(cntr_mty_list.rep_yd_tp_cd, 'M', '%FD%', 'B', '%FD%', 'SV%')  
                                    AND a.coa_cost_src_cd NOT LIKE DECODE(cntr_mty_list.rep_yd_tp_cd, 'M', '%FD%', 'B', '%FD%', 'TP%')  
                                    AND a.coa_cost_src_cd NOT LIKE DECODE(cntr_mty_list.rep_yd_tp_cd, 'M', '%FD%', 'B', '%FD%', 'TMNDRM')  
                                    AND a.coa_cost_src_cd NOT LIKE DECODE(cntr_mty_list.rep_yd_tp_cd, 'R', 'TMNDMT', 'P', 'TMNDMT', 'S', 'TMNDMT', 'Y', 'TMNDMT', 'a'))a                                      
                             WHERE DECODE(cnt, 1, DECODE(a.COA_COST_SRC_CD, 'SVLDMT', null , 'TMNDMT', null,  a.coa_cost_src_cd), a.COA_COST_SRC_CD) = a.COA_COST_SRC_CD) b1  
                               
                             --TMNDMT의 값이 없을 것을 대비하여 TPNDMT 값을 select 하여 들고 있는다.  
                             ,(SELECT SUM(DECODE(a.cost_loc_grp_cd,'N', NVL(a.stnd_cost_usd_amt, 0),null)) amt_node                                                                                                                  
                                     ,SUM(DECODE(a.cost_loc_grp_cd,'S', NVL(a.stnd_cost_usd_amt, 0),null)) amt_scc  
                                     ,SUM(DECODE(a.cost_loc_grp_cd,'E', NVL(a.stnd_cost_usd_amt, 0),null)) amt_ecc              
                                     ,SUM(DECODE(a.cost_loc_grp_cd,'L', NVL(a.stnd_cost_usd_amt, 0),null)) amt_lcc                            
                                     ,SUM(DECODE(a.cost_loc_grp_cd,'R', NVL(a.stnd_cost_usd_amt, 0),null)) amt_rcc                                                                                                    
                               FROM coa_nod_avg_stnd_cost a, coa_cost_src_acct b   -- NODE 평균단가 사용                                              
                              WHERE a.cost_yrmon = v_yrmon  
                                AND a.full_mty_cd = 'M'  
                                AND a.cntr_tpsz_cd = cntr_mty_list.cntr_tpsz_cd2  
                                AND a.cost_loc_grp_cd IN('N', 'S', 'E', 'L', 'R')  
                                AND a.nod_cd =  
                                        DECODE(a.cost_loc_grp_cd  
                                               ,'N', cntr_mty_list.yd_cd  
                                               ,'S', cntr_mty_list.scc_cd  
                                               ,'E', cntr_mty_list.ecc_cd  
                                               ,'L', cntr_mty_list.lcc_cd  
                                               ,'R', cntr_mty_list.rcc_cd      
                                               )  
                                AND a.coa_cost_src_cd = b.coa_cost_src_cd  
                                AND b.cost_src_sys_cd = 'TES'  
                                AND b.full_mty_cd = 'M'  
                                AND a.coa_cost_src_cd = 'TPNDMT')b2 --조건을 TPNDMT만  
                                  
                              --TMFDMT의 값이 없을 것을 대비하여 TMNDMT 값을 select 하여 들고 있는다.    
                             ,(SELECT SUM(DECODE(a.cost_loc_grp_cd,'N', NVL(a.stnd_cost_usd_amt, 0),null)) amt_node                                                                                                                  
                                     ,SUM(DECODE(a.cost_loc_grp_cd,'S', NVL(a.stnd_cost_usd_amt, 0),null)) amt_scc  
                                     ,SUM(DECODE(a.cost_loc_grp_cd,'E', NVL(a.stnd_cost_usd_amt, 0),null)) amt_ecc              
                                     ,SUM(DECODE(a.cost_loc_grp_cd,'L', NVL(a.stnd_cost_usd_amt, 0),null)) amt_lcc                            
                                     ,SUM(DECODE(a.cost_loc_grp_cd,'R', NVL(a.stnd_cost_usd_amt, 0),null)) amt_rcc                                                                                                    
                               FROM coa_nod_avg_stnd_cost a, coa_cost_src_acct b   -- NODE 평균단가 사용                                              
                              WHERE a.cost_yrmon = v_yrmon  
                                AND a.full_mty_cd = 'M'  
                                AND a.cntr_tpsz_cd = cntr_mty_list.cntr_tpsz_cd2  
                                AND a.cost_loc_grp_cd IN('N', 'S', 'E', 'L', 'R')  
                                AND a.nod_cd =  
                                        DECODE(a.cost_loc_grp_cd  
                                               ,'N', cntr_mty_list.yd_cd  
                                               ,'S', cntr_mty_list.scc_cd  
                                               ,'E', cntr_mty_list.ecc_cd  
                                               ,'L', cntr_mty_list.lcc_cd  
                                               ,'R', cntr_mty_list.rcc_cd      
                                               )  
                                AND a.coa_cost_src_cd = b.coa_cost_src_cd  
                                AND b.cost_src_sys_cd = 'TES'  
                                AND b.full_mty_cd = 'M'  
                                AND a.coa_cost_src_cd = 'TMNDMT')b3  
                             ) ;  
         EXCEPTION  
            WHEN OTHERS  
            THEN   
                v_calc_node_remark := 'NODE CALC DATA 없습니다.';  
                v_calc_node_amount := 0 ;  
         END;          
           
         BEGIN  
           SELECT DECODE(SIGN(stnd_cost_usd_amt_n)  
                         ,1, 'NODE'  
                         ,0, 'NODE' -- 0 이 붙어야 되는 곳은 단가를 0으로 넣어 두었기 때문에 실제로 0 이 붙는다.  
                         ,DECODE(SIGN(stnd_cost_usd_amt_s)  
                                ,1, 'SCC'  
                                ,0, 'SCC' -- 0 도 붙여줘야 됨  
                                ,DECODE(SIGN(stnd_cost_usd_amt_e)  
                                       ,1, 'ECC'  
                                       ,0, 'ECC'  
                                       ,DECODE(SIGN(stnd_cost_usd_amt_l)  
                                              ,1, 'LCC'  
                                              ,0, 'LCC'  
                                              ,DECODE(SIGN(stnd_cost_usd_amt_r)  
                                              ,1, 'RCC'   
                                              ,0, 'RCC', 'NODATA')  
                                              )  
                                       )  
                                )  
                         )  
                   ,DECODE(SIGN(stnd_cost_usd_amt_n)  
                                 ,1, stnd_cost_usd_amt_n  
                                 ,0, stnd_cost_usd_amt_n  
                                 ,DECODE(SIGN(stnd_cost_usd_amt_s)  
                                        ,1, stnd_cost_usd_amt_s  
                                        ,0, stnd_cost_usd_amt_s  
                                        ,DECODE(SIGN(stnd_cost_usd_amt_e)  
                                               ,1, stnd_cost_usd_amt_e  
                                               ,0, stnd_cost_usd_amt_e  
                                               ,DECODE(SIGN(stnd_cost_usd_amt_l)  
                                                      ,1, stnd_cost_usd_amt_l  
                                                      ,0, stnd_cost_usd_amt_l  
                                                      ,DECODE(SIGN(stnd_cost_usd_amt_r)  
                                                      ,1, stnd_cost_usd_amt_r  
                                                      ,0, stnd_cost_usd_amt_r  
                                                      ,0)  
                                                      )  
                                               )  
                                        )  
                                 )  
              INTO v_calc_link_remark  
                  ,v_calc_link_amount  
              FROM (SELECT ROUND(DECODE(SUM(DECODE(a.cost_loc_grp_cd, 'N', NVL(lnk_ttl_qty, 0), null)) --진짜 node에서 0이 붙는 것만 0처리 하고  
                                       ,0, 0                                                           --나머지는 null로   
                                       , SUM(DECODE(a.cost_loc_grp_cd, 'N', NVL(lnk_ttl_amt, 0), null))  
                                         / SUM(DECODE(a.cost_loc_grp_cd, 'N', NVL(lnk_ttl_qty, 0), null))  
                                       )  
                                ,3  
                                ) stnd_cost_usd_amt_n  
                          ,ROUND(DECODE(SUM(DECODE(a.cost_loc_grp_cd, 'S', NVL(lnk_ttl_qty, 0), null))  
                                       ,0, 0  
                                       , SUM(DECODE(a.cost_loc_grp_cd, 'S', NVL(lnk_ttl_amt, 0), null))  
                                         / SUM(DECODE(a.cost_loc_grp_cd, 'S', NVL(lnk_ttl_qty, 0), null))  
                                       )  
                                ,3  
                                ) stnd_cost_usd_amt_s  
                          ,ROUND(DECODE(SUM(DECODE(a.cost_loc_grp_cd, 'E', NVL(lnk_ttl_qty, 0), null))  
                                       ,0, 0  
                                       , SUM(DECODE(a.cost_loc_grp_cd, 'E', NVL(lnk_ttl_amt, 0), null))  
                                         / SUM(DECODE(a.cost_loc_grp_cd, 'E', NVL(lnk_ttl_qty, 0), null))  
                                       )  
                                ,3  
                                ) stnd_cost_usd_amt_e  
                          ,ROUND(DECODE(SUM(DECODE(a.cost_loc_grp_cd, 'L', NVL(lnk_ttl_qty, 0), null))  
                                       ,0, 0  
                                       , SUM(DECODE(a.cost_loc_grp_cd, 'L', NVL(lnk_ttl_amt, 0), null))  
                                         / SUM(DECODE(a.cost_loc_grp_cd, 'L', NVL(lnk_ttl_qty, 0), null))  
                                       )  
                                ,3  
                                ) stnd_cost_usd_amt_l  
                          ,ROUND(DECODE(SUM(DECODE(a.cost_loc_grp_cd, 'R', NVL(lnk_ttl_qty, 0), null))  
                                       ,0, 0  
                                       , SUM(DECODE(a.cost_loc_grp_cd, 'R', NVL(lnk_ttl_amt, 0), null))  
                                         / SUM(DECODE(a.cost_loc_grp_cd, 'R', NVL(lnk_ttl_qty, 0), null))  
                                       )  
                                ,3  
                                ) stnd_cost_usd_amt_r  
                      FROM coa_lnk_avg_stnd_cost a, coa_cost_src_acct b   -- LINK 평균단가(금액/수량) 사용  
                     WHERE a.cost_yrmon = v_yrmon  
                       AND a.lnk_fm_nod_cd =  
                              DECODE(a.cost_loc_grp_cd  
                                    ,'N', cntr_mty_list.yd_cd  
                                    ,'S', cntr_mty_list.scc_cd  
                                    ,'E', cntr_mty_list.ecc_cd  
                                    ,'L', cntr_mty_list.lcc_cd  
                                    ,'R', cntr_mty_list.rcc_cd  
                                    )  
                       AND a.lnk_to_nod_cd =  
                              DECODE(a.cost_loc_grp_cd  
                                    ,'N', cntr_mty_list.nxt_yd_cd  
                                    ,'S', cntr_mty_list.nxt_scc_cd  
                                    ,'E', cntr_mty_list.nxt_ecc_cd  
                                    ,'L', cntr_mty_list.nxt_lcc_cd  
                                    ,'R', cntr_mty_list.nxt_rcc_cd  
                                    )  
                       AND a.cntr_tpsz_cd = cntr_mty_list.cntr_tpsz_cd2  
                       AND a.full_mty_cd = 'M'  
                       AND a.coa_cost_src_cd = b.coa_cost_src_cd  
                       AND a.cost_loc_grp_cd IN('N', 'S', 'E', 'L', 'R'));  
                         
         EXCEPTION  
            WHEN OTHERS  
            THEN   
                v_calc_link_remark := 'LINK CALC DATA 없습니다.';  
                v_calc_link_amount := 0 ;  
         END;        
      
      
         UPDATE coa_cntr_mty_mvmt  
            SET mty_stvg_ttl_amt = v_calc_node_amount                     
               ,mty_trsp_ttl_amt = v_calc_link_amount                     
               ,cost_cre_sts_cd = 'A'   -- A(APPROVAL) 승인  
               ,cre_dt = SYSDATE  
               ,cost_calc_rmk = 'NODE:'||v_calc_node_remark ||'LINK:'||v_calc_link_remark               
          WHERE cost_yrmon = v_yrmon  
            AND yd_cd = cntr_mty_list.yd_cd  
            AND cntr_tpsz_cd = cntr_mty_list.cntr_tpsz_cd  
            AND NVL(nxt_yd_cd, 'N') = NVL(cntr_mty_list.nxt_yd_cd, 'N')  
            AND mty_cost_tp_cd = 'M';  
  
         v_ins_or_upd_cnt := v_ins_or_upd_cnt + SQL%ROWCOUNT;  
         v_step2_prc_cnt := v_step2_prc_cnt + 1;  
--         IF MOD(v_step2_prc_cnt, v_trans_unit) = 0  
--         THEN  
         COMMIT;  
--         END IF;  
      END LOOP;  
  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', 'COA_CNTR_MTY_MVMT-COST  ' || v_ins_or_upd_cnt || ' Records Updated ');  
      COMMIT;  
  
      -- MTY END에서 운반비가 없어야 함  
      UPDATE coa_cntr_mty_mvmt  
         SET mty_trsp_ttl_amt = 0  
            ,cre_dt = SYSDATE  
       WHERE cost_yrmon = v_yrmon  
         AND mty_dur_dys > 0 -- MTY MVMT 마직말 일때만 MTY 상태인 일수가 들어감  
         AND mty_cost_tp_cd = 'M';     
  
      COMMIT;  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', '2단계 종료 ');  
   -------------------------------[ Emtpy Container Movement 끝         ]-----------------------  
   END IF;  
  
   -------------------------------[           DAYS UPDATE 시작           ]------------------------  
   FOR days_list IN days_cntr_cursor(v_yrmon)  
   LOOP  
      -- CONTI 3개인 데이터 삭제(ORGIN, DEST 로 데이터 생성을 해야 하므로 CONTI 가 3개이상은 대상에서 제외함.)  
      SELECT COUNT(*)  
        INTO v_conti_cnt  
        FROM (SELECT DISTINCT DECODE(a2.conti_cd, 'F', 'E', a2.conti_cd) conti_cd   -- F(AFRICA) 이면 E(EUROP) 으로 간주  
                         FROM coa_cntr_mty_mvmt a1, mdm_location a2, mdm_eq_orz_cht a3  
                        WHERE cost_yrmon = v_yrmon  
                          AND cntr_no = days_list.cntr_no  
                          AND SUBSTR(a1.yd_cd, 1, 5) = a2.loc_cd  
                          AND a2.scc_cd = a3.scc_cd  
                          AND a1.mty_cost_tp_cd = 'M');  
  
      IF v_conti_cnt > 2  
      THEN  
         DELETE FROM coa_cntr_mty_mvmt  
               WHERE cost_yrmon = v_yrmon  
                 AND cntr_no = days_list.cntr_no  
                 AND mty_cost_tp_cd = 'M';  
  
         v_is_del_cntr := 'Y';  
      ELSE  
         v_is_del_cntr := 'N';  
      END IF;  
  
      IF (v_is_del_cntr = 'N')   -- CONTI 가 2개 이하이면  
      THEN  
         -- NEXT YARD, mty_dur_dys(1단계에서 데이터 생성함, 2단계에서 다시 생성 정리필요)  
         MERGE INTO coa_cntr_mty_mvmt a1  
            USING (SELECT cost_yrmon  
                         ,cntr_no  
                         ,mon_mvmt_seq  
                         , next_cnmv_dt - cnmv_dt mty_dur_dys   -- MTY 일수 = 후 MTY 날짜 - 현 MTY 날짜  
                         ,DECODE(next_cnmv_dt, NULL, NULL, nxt_yd_cd) nxt_yd_cd   --마지막에서는 NEXT YARD NULL로 세팅(이경한대리)  
                         ,mty_cost_tp_cd  
                     FROM (SELECT cost_yrmon  
                                 ,cntr_no  
                                 ,mon_mvmt_seq  
                                 ,yd_cd  
                                 ,cnmv_dt  
                                 ,mty_dur_dys  
                                 ,nxt_yd_cd  
                                 ,LEAD(cnmv_dt, 1) OVER(ORDER BY cntr_no, cnmv_dt, mon_mvmt_seq) next_cnmv_dt  
                                 ,mty_cost_tp_cd  
                             FROM coa_cntr_mty_mvmt  
                            WHERE 1 = 1  
                              AND cost_yrmon = v_yrmon  
                              AND cntr_no = days_list.cntr_no  
                              AND mty_cost_tp_cd = 'M')) a2  
            ON (    a1.cost_yrmon = a2.cost_yrmon  
                AND a1.cntr_no = a2.cntr_no  
                AND a1.mon_mvmt_seq = a2.mon_mvmt_seq  
                AND a1.mty_cost_tp_cd = a2.mty_cost_tp_cd)  
            WHEN MATCHED THEN  
               UPDATE  
                  SET a1.mty_dur_dys = a2.mty_dur_dys, a1.nxt_yd_cd = a2.nxt_yd_cd  
               ;  
      END IF;  
  
      COMMIT;  
   END LOOP;  
  
   -------------------------------[           DAYS UPDATE 종료           ]------------------------  
  
   --  
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
-- 3단계 진행 (10분 소요)  
--      COA_CNTR_MTY_MVMT -> COA_MTY_CNTR_ROUT_PERF 각 월별, ORGIN, DEST별 발생한 MTY CNTR 의 MTY 하역, 운반비, MTY 일수, MTY 수량 데이터 생성  
--      COA_MTY_CNTR_ROUT_PERF, COA_FULL_ECC_IMBAL -> COA_MTY_ECC_CNTR_SMRY  
--          ECC, LCC, RCC 레벨의 각 월별, ORGIN, DEST별 MTY CNTR 의 MTY 하역단가, 운반단가, IMBALANCE 상태 데이터 생성  
--          COA_FULL_ECC_IMBAL(MTCH BAK I/F시 생성함)  
--      COA_MTY_ECC_CNTR_SMRY, COA_FULL_ECC_IMBAL -> COA_MTY_ECC_UT_COST MTY 하역단가, 운반단가, 평균 MTY 일수에 IMBALANCE RATION 적용   
--////////////////////////////////////////////////////////////////////////////////////////////////////////  
   IF    in_step <= 3  
      OR in_step = 0  
   THEN  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', '3단계 시작 ');  
  
      -- ROUT별 단가합계  
      /*********** 20070930 로직 변경 --Ari  
      1. YD_CD의 CONTI를 구한다.('F'(아프리카)-->'E'로 처리해준다)  
      2. rout_n1st_yd_cd, rout_lst_yd_cd가 'A'(ASIA)->'A'(ASIA)인 경우  mty_stvg_ttl_amt,mty_trsp_ttl_amt,ttl_tz_dys를 50%처리한다.  
      3. ORIGIN 일경우 첫번째 대륙값만 합산, DEST의 경우 마지막 대륙값만 합산  
      4. 마지막 단계의 1/2로직 삭제  
      *****************************************************************************************************************/  
      -- ROUT별 단가합계  
      INSERT INTO coa_mty_cntr_rout_perf  
                  (cost_yrmon  
                  ,cntr_tpsz_cd  
                  ,rout_n1st_yd_cd  
                  ,rout_lst_yd_cd  
                  ,rout_seq  
                  ,rout_n1st_ecc_cd  
                  ,rout_lst_ecc_cd  
                  ,mty_stvg_ttl_amt  
                  ,mty_trsp_ttl_amt  
                  ,ttl_tz_dys  
                  ,ttl_tztm_hrs  
                  ,ttl_cntr_qty                  
                  ,cntr_org_dest_cd  
                  ,mty_cost_tp_cd
                  ,cre_usr_id  
                  ,cre_dt
                  ,upd_usr_id
                  ,upd_dt
                  )  
         WITH loc AS   -- coa_location_v변형  
              (SELECT a.loc_cd  
                     ,a.conti_cd  
                     ,b.ecc_cd  
                     ,b.lcc_cd 
                 FROM mdm_location a, mdm_eq_orz_cht b  
                WHERE a.scc_cd = b.scc_cd)  
         SELECT   cost_yrmon  
                 ,cntr_tpsz_cd  
                 ,n1st_yd_cd  
                 ,lst_yd_cd  
                 ,rout_seq  
                 ,n1st_ecc_cd  
                 ,lst_ecc_cd  
                 ,SUM(mty_stvg_ttl_amt)   --'A'->'A'인경우 1/2  
                 ,SUM(mty_trsp_ttl_amt)   --'A'->'A'인경우 1/2  
                 ,SUM(mty_dur_dys)   --'A'->'A'인경우 1/2  
                 ,0  
                 ,COUNT(*)                
                 ,cntr_org_dest_cd   --FIRST와 같은경우 'O', LAST와 같은경우 'D'  
                 ,mty_cost_tp_cd -- MT repo 용 단가 표시
                 ,'SYSTEM'  
                 ,SYSDATE 
                 ,'SYSTEM'  
                 ,SYSDATE 
             FROM (SELECT b2.cost_yrmon  
                         ,b2.cntr_tpsz_cd  
                         ,b2.n1st_yd_cd  
                         ,b2.lst_yd_cd  
                         ,b2.rout_seq  
                         ,b2.n1st_ecc_cd  
                         ,b2.lst_ecc_cd   --, a2.conti_cd || a3.conti_cd || a4.conti_cd  
                         ,b2.cntr_no  
                         ,DECODE(b2.is_asia, 'Y', b2.mty_stvg_ttl_amt / 2, b2.mty_stvg_ttl_amt) mty_stvg_ttl_amt  
                         ,DECODE(b2.is_asia, 'Y', b2.mty_trsp_ttl_amt / 2, b2.mty_trsp_ttl_amt) mty_trsp_ttl_amt  
                         ,DECODE(b2.is_asia, 'Y', b2.mty_dur_dys / 2, b2.mty_dur_dys) mty_dur_dys   --,b2.is_asia  
                         ,DECODE(b2.is_asia, 'Y', b1.cntr_org_dest_cd, b2.cntr_org_dest_cd) cntr_org_dest_cd  
                         ,b2.mty_cost_tp_cd  
                     FROM (SELECT 'O' cntr_org_dest_cd  
                                 ,'Y' is_asia  
                             FROM DUAL  
                           UNION ALL  
                           SELECT 'D' cntr_org_dest_cd  
                                 ,'Y'  
                             FROM DUAL) b1   --'A'->'A'일경우 'O', 'D' 모두 생성  
                         ,(SELECT   a1.cost_yrmon  
                                   ,a1.cntr_tpsz_cd  
                                   ,a1.rout_n1st_yd_cd n1st_yd_cd  
                                   ,a1.rout_lst_yd_cd lst_yd_cd  
                                   ,a1.rout_seq  
                                   ,NVL(a2.ecc_cd, 'XXXXX') n1st_ecc_cd  
                                   ,NVL(a3.ecc_cd, 'XXXXX') lst_ecc_cd   --, a2.conti_cd || a3.conti_cd || a4.conti_cd  
                                   ,a1.cntr_no  
                                   ,NVL(SUM(a1.mty_stvg_ttl_amt), 0) mty_stvg_ttl_amt  
                                   ,NVL(SUM(a1.mty_trsp_ttl_amt), 0) mty_trsp_ttl_amt  
                                   ,NVL(SUM(a1.mty_dur_dys), 0) mty_dur_dys     
                                   ,DECODE(a2.conti_cd || a3.conti_cd, 'AA', 'Y', 'N') is_asia  
                                   ,DECODE(DECODE(a4.conti_cd, 'F', 'E', a4.conti_cd)  
                                          ,DECODE(a2.conti_cd, 'F', 'E', a2.conti_cd), 'O'  
                                          ,DECODE(a3.conti_cd, 'F', 'E', a3.conti_cd), 'D'  
                                          ) cntr_org_dest_cd                                    
                                   ,a1.mty_cost_tp_cd                      
                               FROM coa_cntr_mty_mvmt a1, loc a2, loc a3, loc a4, coa_full_ecc_imbal a5  
                              WHERE a1.cost_yrmon = v_yrmon  
                                AND SUBSTR(a1.rout_n1st_yd_cd, 1, 5) = a2.loc_cd(+)  
                                AND SUBSTR(a1.rout_lst_yd_cd, 1, 5) = a3.loc_cd(+)  
                                AND SUBSTR(a1.yd_cd, 1, 5) = a4.loc_cd(+)  
                                AND a5.cost_yrmon = v_yrmon  
                                AND NVL(a2.ecc_cd, 'XXXXX') = a5.fcntr_ecc_cd  
                                AND a1.cntr_tpsz_cd = a5.cntr_tpsz_cd  
                                AND a5.cost_loc_grp_cd = 'E'  
                                AND a1.mty_cost_tp_cd = 'M'  
                           GROUP BY a1.cost_yrmon  
                                   ,a1.cntr_tpsz_cd  
                                   ,a1.rout_n1st_yd_cd  
                                   ,a1.rout_lst_yd_cd  
                                   ,a1.rout_seq  
                                   ,NVL(a2.ecc_cd, 'XXXXX')  
                                   ,NVL(a3.ecc_cd, 'XXXXX')  
                                   ,a1.cntr_no  
                                   ,DECODE(a2.conti_cd || a3.conti_cd, 'AA', 'Y', 'N')                                   
                                   ,DECODE(DECODE(a4.conti_cd, 'F', 'E', a4.conti_cd)  
                                          ,DECODE(a2.conti_cd, 'F', 'E', a2.conti_cd), 'O'  
                                          ,DECODE(a3.conti_cd, 'F', 'E', a3.conti_cd), 'D'  
                                          )  
                                   ,a1.mty_cost_tp_cd) b2  
                    WHERE b1.is_asia(+) = b2.is_asia)   --'A'->'A'일경우 'O', 'D' 모두 생성  
         GROUP BY cost_yrmon, cntr_tpsz_cd, n1st_yd_cd, lst_yd_cd, rout_seq, n1st_ecc_cd, lst_ecc_cd, cntr_org_dest_cd, mty_cost_tp_cd;  
  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', '3단계 종료 COA_MTY_CNTR_ROUT_PERF  ' || SQL%ROWCOUNT || ' Records Inserted ');  
      COMMIT;  
----////////////////////////////////////////////////////////////////////////////////////////////////////////  
---- ECC별 Origin DEST 단가합계(4)  
----////////////////////////////////////////////////////////////////////////////////////////////////////////  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', 'ECC별 Origin DEST 단가합계(4) 시작');  
  
      ----------------------------  
    --| ECC별 Origin DEST 단가합계 |  
      -----------coa_mty_ecc_cntr_smry table에 넣어줄 때 Repo Cost용 단가와 Simulated Cost용 단가 2번 insert------------  
  
        
      -- Repo Cost용 단가 insert 부분 시작--  
      INSERT INTO coa_mty_ecc_cntr_smry  
                  (cost_yrmon  
                  ,cntr_tpsz_cd  
                  ,ecc_cd  
                  ,cntr_io_vol_sts_cd -- D(DEFICIT), S(SURPLUS) IMBALANCE 상태   
                  ,cntr_org_dest_cd  
                  ,mty_qty  
                  ,mty_stvg_uc_amt   -- 평균 MTY 하역단가  
                  ,mty_stvg_ttl_amt  
                  ,mty_trsp_uc_amt   -- 평균 MTY 운반단가  
                  ,mty_trsp_ttl_amt  
                  ,mty_tz_hrs   -- 0 처리함 사용안함  
                  ,mty_tz_dys   -- 평균 MTY 일수                    
                  ,cost_loc_grp_cd  
                  ,mty_repo_sim_cd --Repo Cost 생성 단가 인지 (R), Simulated Cost 생성 단가 인지 (S) 구분  
                  ,mty_cost_tp_cd -- Mty Cost 생성 단가 인지 (M), Minus Credit 생성 단가 인지 (C) 구분  
                  ,cre_usr_id  
                  ,cre_dt
                  ,upd_usr_id
                  ,upd_dt
                  )  
         SELECT   a.cost_yrmon  
                 ,a.cntr_tpsz_cd  
                 ,a.rout_n1st_ecc_cd  
                 ,b.cntr_io_vol_sts_cd  
                 ,'O' cntr_org_dest_cd  
                 ,SUM(a.TTL_CNTR_QTY) --MTY 물량으로 나누어 줌 Origin , Dest 는 밑에 조건에서 갈림  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --IB QTY가 0이면 단가 0으로 setting    
                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --IB QTY가 0이면 단가 0으로 setting  
                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
                 ,0  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, SUM(a.ttl_tz_dys) / SUM(a.TTL_CNTR_QTY))                  
                 ,'E'  
                 ,'R' --Repo Cost 생성 용 단가 표시  
                 ,a.mty_cost_tp_cd
                 ,'SYSTEM'  
                 ,SYSDATE
                 ,'SYSTEM'  
                 ,SYSDATE
             FROM coa_mty_cntr_rout_perf a, coa_full_ecc_imbal b  
            WHERE a.cost_yrmon = in_yrmon  
              AND a.cntr_org_dest_cd = 'O'   -- Origin은 Origin 데이터만 SUM  
              AND b.cost_loc_grp_cd = 'E'   -- IMBALANCE ECC 레벨  
              AND a.cost_yrmon = b.cost_yrmon  
              AND a.rout_n1st_ecc_cd = b.fcntr_ecc_cd  
              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd  
              AND a.mty_cost_tp_cd = 'M'  
         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.rout_n1st_ecc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd  
         UNION  
         SELECT   a.cost_yrmon  
                 ,a.cntr_tpsz_cd  
                 ,a.lcc_cd  
                 ,b.cntr_io_vol_sts_cd  
                 ,'O' cntr_org_dest_cd  
                 ,SUM(a.TTL_CNTR_QTY) --MTY 물량으로 나누어 줌 Origin , Dest 는 밑에 조건에서 갈림  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --IB QTY가 0이면 단가 0으로 setting    
                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --IB QTY가 0이면 단가 0으로 setting  
                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
                 ,0  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, SUM(a.ttl_tz_dys) / SUM(a.TTL_CNTR_QTY))                
                 ,'L'  
                 ,'R' --Repo Cost 생성 용 단가 표시  
                 ,a.mty_cost_tp_cd
                 ,'SYSTEM'  
                 ,SYSDATE
                 ,'SYSTEM'  
                 ,SYSDATE  
             FROM (SELECT a.cost_yrmon cost_yrmon  
                         ,a.cntr_tpsz_cd cntr_tpsz_cd  
                         ,b.lcc_cd lcc_cd  
                         ,a.mty_stvg_ttl_amt mty_stvg_ttl_amt  
                         ,a.mty_trsp_ttl_amt mty_trsp_ttl_amt  
                         ,a.ttl_tz_dys ttl_tz_dys  
                         ,a.ttl_cntr_qty ttl_cntr_qty  
                         ,a.cntr_org_dest_cd  
                         ,a.mty_cost_tp_cd  
                     FROM coa_mty_cntr_rout_perf a  
                         ,(SELECT DISTINCT ecc_cd  
                                          ,lcc_cd  
                                          ,rcc_cd  
                                      FROM coa_location_v) b  
                    WHERE a.cost_yrmon = in_yrmon  
                      AND a.rout_n1st_ecc_cd = b.ecc_cd  
                      AND a.mty_cost_tp_cd = 'M') a  
                 ,coa_full_ecc_imbal b  
            WHERE a.cost_yrmon = in_yrmon  
              AND a.cntr_org_dest_cd = 'O'   -- Origin은 Origin 데이터만 SUM  
              AND b.cost_loc_grp_cd = 'L'  -- IMBALANCE LCC 레벨  
              AND a.cost_yrmon = b.cost_yrmon  
              AND a.lcc_cd = b.fcntr_ecc_cd  
              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd  
         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.lcc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd  
         UNION  
         SELECT   a.cost_yrmon  
                 ,a.cntr_tpsz_cd  
                 ,a.rcc_cd  
                 ,b.cntr_io_vol_sts_cd  
                 ,'O' cntr_org_dest_cd  
                 ,SUM(a.TTL_CNTR_QTY) --MTY 물량으로 나누어 줌 Origin , Dest 는 밑에 조건에서 갈림  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --IB QTY가 0이면 단가 0으로 setting    
                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --IB QTY가 0이면 단가 0으로 setting  
                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
                 ,0  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, SUM(a.ttl_tz_dys) / SUM(a.TTL_CNTR_QTY))                  
                 ,'R'  
                 ,'R' --Repo Cost 생성 용 단가 표시  
                 ,a.mty_cost_tp_cd
                 ,'SYSTEM'  
                 ,SYSDATE 
                 ,'SYSTEM'  
                 ,SYSDATE  
             FROM (SELECT a.cost_yrmon cost_yrmon  
                         ,a.cntr_tpsz_cd cntr_tpsz_cd  
                         ,b.rcc_cd rcc_cd  
                         ,a.mty_stvg_ttl_amt mty_stvg_ttl_amt  
                         ,a.mty_trsp_ttl_amt mty_trsp_ttl_amt  
                         ,a.ttl_tz_dys ttl_tz_dys  
                         ,a.ttl_cntr_qty ttl_cntr_qty  
                         ,a.cntr_org_dest_cd  
                         ,a.mty_cost_tp_cd  
                     FROM coa_mty_cntr_rout_perf a  
                         ,(SELECT DISTINCT ecc_cd  
                                          ,lcc_cd  
                                          ,rcc_cd  
                                      FROM coa_location_v) b  
                    WHERE a.cost_yrmon = in_yrmon  
                      AND a.rout_n1st_ecc_cd = b.ecc_cd  
                      AND a.mty_cost_tp_cd = 'M') a  
                 ,coa_full_ecc_imbal b  
            WHERE a.cost_yrmon = in_yrmon  
              AND a.cntr_org_dest_cd = 'O'   -- Origin은 Origin 데이터만 SUM  
              AND b.cost_loc_grp_cd = 'R' -- IMBALANCE RCC 레벨  
              AND a.cost_yrmon = b.cost_yrmon  
              AND a.rcc_cd = b.fcntr_ecc_cd  
              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd  
         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.rcc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd  
         UNION   -- Destionation  
         SELECT   a.cost_yrmon  
                 ,a.cntr_tpsz_cd  
                 ,a.rout_lst_ecc_cd  
                 ,b.cntr_io_vol_sts_cd  
                 ,'D' cntr_org_dest_cd  
                 ,SUM(a.TTL_CNTR_QTY) --MTY 물량으로 나누어 줌 Origin , Dest 는 밑에 조건에서 갈림  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --OB QTY가 0이면 단가 0으로 setting    
                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --OB QTY가 0이면 단가 0으로 setting  
                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
                 ,0  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, SUM(a.ttl_tz_dys) / SUM(a.TTL_CNTR_QTY))                 
                 ,'E'   
                 ,'R' --Repo Cost 생성 용 단가 표시  
                 ,a.mty_cost_tp_cd
                 ,'SYSTEM'  
                 ,SYSDATE
                 ,'SYSTEM'  
                 ,SYSDATE 
             FROM coa_mty_cntr_rout_perf a, coa_full_ecc_imbal b  
            WHERE a.cost_yrmon = in_yrmon  
              AND a.cntr_org_dest_cd = 'D'   -- Dest는  Dest 데이터만 SUM  
              AND b.cost_loc_grp_cd = 'E'  
              AND a.cost_yrmon = b.cost_yrmon  
              AND a.rout_lst_ecc_cd = b.fcntr_ecc_cd  
              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd  
              AND a.mty_cost_tp_cd = 'M'   
         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.rout_lst_ecc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd  
         UNION  
         SELECT   a.cost_yrmon  
                 ,a.cntr_tpsz_cd  
                 ,a.lcc_cd  
                 ,b.cntr_io_vol_sts_cd  
                 ,'D' cntr_org_dest_cd  
                 ,SUM(a.TTL_CNTR_QTY) --MTY 물량으로 나누어 줌 Origin , Dest 는 밑에 조건에서 갈림  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --OB QTY가 0이면 단가 0으로 setting    
                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --OB QTY가 0이면 단가 0으로 setting  
                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
                 ,0  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, SUM(a.ttl_tz_dys) / SUM(a.TTL_CNTR_QTY))  
                 ,'L'  
                 ,'R' --Repo Cost 생성 용 단가 표시  
                 ,a.mty_cost_tp_cd
                 ,'SYSTEM'  
                 ,SYSDATE
                 ,'SYSTEM'  
                 ,SYSDATE 
             FROM (SELECT a.cost_yrmon cost_yrmon  
                         ,a.cntr_tpsz_cd cntr_tpsz_cd  
                         ,b.lcc_cd lcc_cd  
                         ,a.mty_stvg_ttl_amt mty_stvg_ttl_amt  
                         ,a.mty_trsp_ttl_amt mty_trsp_ttl_amt  
                         ,a.ttl_tz_dys ttl_tz_dys  
                         ,a.ttl_cntr_qty ttl_cntr_qty  
                         ,a.cntr_org_dest_cd  
                         ,a.mty_cost_tp_cd  
                     FROM coa_mty_cntr_rout_perf a  
                         ,(SELECT DISTINCT ecc_cd  
                                          ,lcc_cd  
                                          ,rcc_cd  
                                      FROM coa_location_v) b  
                    WHERE a.cost_yrmon = in_yrmon  
                      AND a.rout_lst_ecc_cd = b.ecc_cd  
                      AND a.mty_cost_tp_cd = 'M') a  
                 ,coa_full_ecc_imbal b  
            WHERE a.cost_yrmon = in_yrmon  
              AND a.cntr_org_dest_cd = 'D'   -- Dest는  Dest 데이터만 SUM  
              AND b.cost_loc_grp_cd = 'L'  
              AND a.cost_yrmon = b.cost_yrmon  
              AND a.lcc_cd = b.fcntr_ecc_cd  
              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd  
         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.lcc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd  
         UNION  
         SELECT   a.cost_yrmon  
                 ,a.cntr_tpsz_cd  
                 ,a.rcc_cd  
                 ,b.cntr_io_vol_sts_cd  
                 ,'D' cntr_org_dest_cd  
                 ,SUM(a.TTL_CNTR_QTY) --MTY 물량으로 나누어 줌 Origin , Dest 는 밑에 조건에서 갈림  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --OB QTY가 0이면 단가 0으로 setting    
                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.TTL_CNTR_QTY)) --OB QTY가 0이면 단가 0으로 setting  
                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
                 ,0  
                 , DECODE(SUM(a.TTL_CNTR_QTY), 0, 0, SUM(a.ttl_tz_dys) / SUM(a.TTL_CNTR_QTY))  
                 ,'R'  
                 ,'R' --Repo Cost 생성 용 단가 표시  
                 ,a.mty_cost_tp_cd
                 ,'SYSTEM'  
                 ,SYSDATE
                 ,'SYSTEM'  
                 ,SYSDATE
             FROM (SELECT a.cost_yrmon cost_yrmon  
                         ,a.cntr_tpsz_cd cntr_tpsz_cd  
                         ,b.rcc_cd rcc_cd  
                         ,a.mty_stvg_ttl_amt mty_stvg_ttl_amt  
                         ,a.mty_trsp_ttl_amt mty_trsp_ttl_amt  
                         ,a.ttl_tz_dys ttl_tz_dys  
                         ,a.ttl_cntr_qty ttl_cntr_qty  
                         ,a.cntr_org_dest_cd  
                         ,a.mty_cost_tp_cd  
                     FROM coa_mty_cntr_rout_perf a  
                         ,(SELECT DISTINCT ecc_cd  
                                          ,lcc_cd  
                                          ,rcc_cd  
                                      FROM coa_location_v) b  
                    WHERE a.cost_yrmon = in_yrmon  
                      AND a.rout_lst_ecc_cd = b.ecc_cd  
                      AND a.mty_cost_tp_cd = 'M') a  
                 ,coa_full_ecc_imbal b  
            WHERE a.cost_yrmon = in_yrmon  
              AND a.cntr_org_dest_cd = 'D'   -- Dest는  Dest 데이터만 SUM  
              AND b.cost_loc_grp_cd = 'R'  
              AND a.cost_yrmon = b.cost_yrmon  
              AND a.rcc_cd = b.fcntr_ecc_cd  
              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd  
         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.rcc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd;  
           
        ----------- Repo Cost용 단가 insert 부분 끝--------------------------------  
           
        ----------- Simulated Cost용 단가 insert 부분 시작--------------------------------  
           
--         INSERT INTO coa_mty_ecc_cntr_smry  
--                  (cost_yrmon  
--                  ,cntr_tpsz_cd  
--                  ,ecc_cd  
--                  ,cntr_io_vol_sts_cd -- D(DEFICIT), S(SURPLUS) IMBALANCE 상태   
--                  ,cntr_org_dest_cd  
--                  ,mty_qty  
--                  ,mty_stvg_uc_amt   -- 평균 MTY 하역단가  
--                  ,mty_stvg_ttl_amt  
--                  ,mty_trsp_uc_amt   -- 평균 MTY 운반단가  
--                  ,mty_trsp_ttl_amt  
--                  ,mty_tz_hrs   -- 0 처리함 사용안함  
--                  ,mty_tz_dys   -- 평균 MTY 일수                    
--                  ,cost_loc_grp_cd  
--                  ,mty_repo_sim_cd --Repo Cost 생성 단가 인지 (R), Simulated Cost 생성 단가 인지 (S) 구분  
--                  ,mty_cost_tp_cd -- Mty Cost 생성 단가 인지 (M), Minus Credit 생성 단가 인지 (C) 구분  
--                  ,cre_usr_id  
--                  ,cre_dt
--                  ,upd_usr_id
--                  ,upd_dt
--                  )  
--         SELECT   a.cost_yrmon  
--                 ,a.cntr_tpsz_cd  
--                 ,a.rout_n1st_ecc_cd  
--                 ,b.cntr_io_vol_sts_cd  
--                 ,'O' cntr_org_dest_cd  
--                 ,SUM(a.ttl_cntr_qty)  
--                 , NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
--                 , NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
--                 ,0  
--                 , SUM(a.ttl_tz_dys) / SUM(a.ttl_cntr_qty)                 
--                 ,'E'  
--                 ,'S' --Simulated Cost 생성 용 단가 표시  
--                 ,a.mty_cost_tp_cd --MT Repo 생성 용 단가 표시  
--                 ,'SYSTEM'  
--                 ,SYSDATE 
--                 ,'SYSTEM'  
--                 ,SYSDATE 
--             FROM coa_mty_cntr_rout_perf a, coa_full_ecc_imbal b  
--            WHERE a.cost_yrmon = in_yrmon  
--              AND a.cntr_org_dest_cd = 'O'   -- Origin은 Origin 데이터만 SUM  
--              AND b.cost_loc_grp_cd = 'E'   -- IMBALANCE ECC 레벨  
--              AND a.cost_yrmon = b.cost_yrmon  
--              AND a.rout_n1st_ecc_cd = b.fcntr_ecc_cd  
--              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd  
--              AND a.rout_n1st_ecc_cd <> a.rout_lst_ecc_cd -- 같은 ECC내 MVMT data 제외  
--              AND a.mty_cost_tp_cd = 'M'   
--         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.rout_n1st_ecc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd  
--         UNION  
--         SELECT   a.cost_yrmon  
--                 ,a.cntr_tpsz_cd  
--                 ,a.lcc_cd  
--                 ,b.cntr_io_vol_sts_cd  
--                 ,'O' cntr_org_dest_cd  
--                 ,SUM(a.ttl_cntr_qty)  
--                 , NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
--                 , NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
--                 ,0  
--                 , SUM(a.ttl_tz_dys) / SUM(a.ttl_cntr_qty)                    
--                 ,'L'  
--                 ,'S' --Simulated Cost 생성 용 단가 표시  
--                 ,a.mty_cost_tp_cd --MT Repo 생성 용 단가 표시 
--                 ,'SYSTEM'  
--                 ,SYSDATE 
--                 ,'SYSTEM'  
--                 ,SYSDATE  
--             FROM (SELECT a.cost_yrmon cost_yrmon  
--                         ,a.cntr_tpsz_cd cntr_tpsz_cd  
--                         ,b.lcc_cd lcc_cd  
--                         ,a.mty_stvg_ttl_amt mty_stvg_ttl_amt  
--                         ,a.mty_trsp_ttl_amt mty_trsp_ttl_amt  
--                         ,a.ttl_tz_dys ttl_tz_dys  
--                         ,a.ttl_cntr_qty ttl_cntr_qty  
--                         ,a.cntr_org_dest_cd  
--                         ,a.mty_cost_tp_cd  
--                     FROM coa_mty_cntr_rout_perf a  
--                         ,(SELECT DISTINCT ecc_cd  
--                                          ,lcc_cd  
--                                          ,rcc_cd  
--                                      FROM coa_location_v) b  
--                    WHERE a.cost_yrmon = in_yrmon  
--                      AND a.rout_n1st_ecc_cd = b.ecc_cd  
--                      AND a.rout_n1st_ecc_cd <> a.rout_lst_ecc_cd --같은 ECC내 MVMT data 제외  
--                      AND a.mty_cost_tp_cd = 'M'    
--                   ) a  
--                 ,coa_full_ecc_imbal b  
--            WHERE a.cost_yrmon = in_yrmon  
--              AND a.cntr_org_dest_cd = 'O'   -- Origin은 Origin 데이터만 SUM  
--              AND b.cost_loc_grp_cd = 'L'  -- IMBALANCE LCC 레벨  
--              AND a.cost_yrmon = b.cost_yrmon  
--              AND a.lcc_cd = b.fcntr_ecc_cd  
--              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd                
--         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.lcc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd  
--         UNION  
--         SELECT   a.cost_yrmon  
--                 ,a.cntr_tpsz_cd  
--                 ,a.rcc_cd  
--                 ,b.cntr_io_vol_sts_cd  
--                 ,'O' cntr_org_dest_cd  
--                 ,SUM(a.ttl_cntr_qty)  
--                 , NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
--                 , NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
--                 ,0  
--                 , SUM(a.ttl_tz_dys) / SUM(a.ttl_cntr_qty)                 
--                 ,'R'  
--                 ,'S' --Simulated Cost 생성 용 단가 표시  
--                 ,a.mty_cost_tp_cd --MT Repo 생성 용 단가 표시 
--                 ,'SYSTEM'  
--                 ,SYSDATE 
--                 ,'SYSTEM'  
--                 ,SYSDATE  
--             FROM (SELECT a.cost_yrmon cost_yrmon  
--                         ,a.cntr_tpsz_cd cntr_tpsz_cd  
--                         ,b.rcc_cd rcc_cd  
--                         ,a.mty_stvg_ttl_amt mty_stvg_ttl_amt  
--                         ,a.mty_trsp_ttl_amt mty_trsp_ttl_amt  
--                         ,a.ttl_tz_dys ttl_tz_dys  
--                         ,a.ttl_cntr_qty ttl_cntr_qty  
--                         ,a.cntr_org_dest_cd  
--                         ,a.mty_cost_tp_cd  
--                     FROM coa_mty_cntr_rout_perf a  
--                         ,(SELECT DISTINCT ecc_cd  
--                                          ,lcc_cd  
--                                          ,rcc_cd  
--                                      FROM coa_location_v) b  
--                    WHERE a.cost_yrmon = in_yrmon  
--                      AND a.rout_n1st_ecc_cd = b.ecc_cd  
--                      AND a.rout_n1st_ecc_cd <> a.rout_lst_ecc_cd --같은 ECC내 MVMT data 제외  
--                      AND a.mty_cost_tp_cd = 'M'  
--                  ) a  
--                 ,coa_full_ecc_imbal b  
--            WHERE a.cost_yrmon = in_yrmon  
--              AND a.cntr_org_dest_cd = 'O'   -- Origin은 Origin 데이터만 SUM  
--              AND b.cost_loc_grp_cd = 'R' -- IMBALANCE RCC 레벨  
--              AND a.cost_yrmon = b.cost_yrmon  
--              AND a.rcc_cd = b.fcntr_ecc_cd  
--              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd                
--         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.rcc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd  
--         UNION   -- Destionation  
--         SELECT   a.cost_yrmon  
--                 ,a.cntr_tpsz_cd  
--                 ,a.rout_lst_ecc_cd  
--                 ,b.cntr_io_vol_sts_cd  
--                 ,'D' cntr_org_dest_cd  
--                 ,SUM(a.ttl_cntr_qty)  
--                 , NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
--                 , NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
--                 ,0  
--                 , SUM(a.ttl_tz_dys) / SUM(a.ttl_cntr_qty)  
--                 ,'E'   
--                 ,'S' --Simulated Cost 생성 용 단가 표시  
--                 ,a.mty_cost_tp_cd --MT Repo 생성 용 단가 표시  
--                 ,'SYSTEM'  
--                 ,SYSDATE 
--                 ,'SYSTEM'  
--                 ,SYSDATE 
--             FROM coa_mty_cntr_rout_perf a, coa_full_ecc_imbal b  
--            WHERE a.cost_yrmon = in_yrmon  
--              AND a.cntr_org_dest_cd = 'D'   -- Dest는  Dest 데이터만 SUM  
--              AND b.cost_loc_grp_cd = 'E'  
--              AND a.cost_yrmon = b.cost_yrmon  
--              AND a.rout_lst_ecc_cd = b.fcntr_ecc_cd  
--              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd  
--              AND a.rout_n1st_ecc_cd <> a.rout_lst_ecc_cd --같은 ECC내 MVMT data 제외  
--              AND a.mty_cost_tp_cd = 'M'  
--         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.rout_lst_ecc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd  
--         UNION  
--         SELECT   a.cost_yrmon  
--                 ,a.cntr_tpsz_cd  
--                 ,a.lcc_cd  
--                 ,b.cntr_io_vol_sts_cd  
--                 ,'D' cntr_org_dest_cd  
--                 ,SUM(a.ttl_cntr_qty)  
--                 , NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
--                 , NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
--                 ,0  
--                 , SUM(a.ttl_tz_dys) / SUM(a.ttl_cntr_qty)  
--                 ,'L'  
--                 ,'S' --Simulated Cost 생성 용 단가 표시  
--                 ,a.mty_cost_tp_cd  
--                 ,'SYSTEM'  
--                 ,SYSDATE 
--                 ,'SYSTEM'  
--                 ,SYSDATE 
--             FROM (SELECT a.cost_yrmon cost_yrmon  
--                         ,a.cntr_tpsz_cd cntr_tpsz_cd  
--                         ,b.lcc_cd lcc_cd  
--                         ,a.mty_stvg_ttl_amt mty_stvg_ttl_amt  
--                         ,a.mty_trsp_ttl_amt mty_trsp_ttl_amt  
--                         ,a.ttl_tz_dys ttl_tz_dys  
--                         ,a.ttl_cntr_qty ttl_cntr_qty  
--                         ,a.cntr_org_dest_cd  
--                         ,a.mty_cost_tp_cd  
--                     FROM coa_mty_cntr_rout_perf a  
--                         ,(SELECT DISTINCT ecc_cd  
--                                          ,lcc_cd  
--                                          ,rcc_cd  
--                                      FROM coa_location_v) b  
--                    WHERE a.cost_yrmon = in_yrmon  
--                      AND a.rout_lst_ecc_cd = b.ecc_cd  
--                      AND a.rout_n1st_ecc_cd <> a.rout_lst_ecc_cd --같은 ECC내 MVMT data 제외  
--                      AND a.mty_cost_tp_cd = 'M'  
--                  ) a  
--                 ,coa_full_ecc_imbal b  
--            WHERE a.cost_yrmon = in_yrmon  
--              AND a.cntr_org_dest_cd = 'D'   -- Dest는  Dest 데이터만 SUM  
--              AND b.cost_loc_grp_cd = 'L'  
--              AND a.cost_yrmon = b.cost_yrmon  
--              AND a.lcc_cd = b.fcntr_ecc_cd  
--              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd                
--         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.lcc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd  
--         UNION  
--         SELECT   a.cost_yrmon  
--                 ,a.cntr_tpsz_cd  
--                 ,a.rcc_cd  
--                 ,b.cntr_io_vol_sts_cd  
--                 ,'D' cntr_org_dest_cd  
--                 ,SUM(a.ttl_cntr_qty)  
--                 , NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_stvg_ttl_amt, 0)), 0)  
--                 , NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0) / SUM(a.ttl_cntr_qty)  
--                 ,NVL(SUM(NVL(a.mty_trsp_ttl_amt, 0)), 0)  
--                 ,0  
--                 , SUM(a.ttl_tz_dys) / SUM(a.ttl_cntr_qty)  
--                 ,'R'  
--                 ,'S' --Simulated Cost 생성 용 단가 표시  
--                 ,a.mty_cost_tp_cd  
--                 ,'SYSTEM'  
--                 ,SYSDATE 
--                 ,'SYSTEM'  
--                 ,SYSDATE
--             FROM (SELECT a.cost_yrmon cost_yrmon  
--                         ,a.cntr_tpsz_cd cntr_tpsz_cd  
--                         ,b.rcc_cd rcc_cd  
--                         ,a.mty_stvg_ttl_amt mty_stvg_ttl_amt  
--                         ,a.mty_trsp_ttl_amt mty_trsp_ttl_amt  
--                         ,a.ttl_tz_dys ttl_tz_dys  
--                         ,a.ttl_cntr_qty ttl_cntr_qty  
--                         ,a.cntr_org_dest_cd  
--                         ,a.mty_cost_tp_cd  
--                     FROM coa_mty_cntr_rout_perf a  
--                         ,(SELECT DISTINCT ecc_cd  
--                                          ,lcc_cd  
--                                          ,rcc_cd  
--                                      FROM coa_location_v) b  
--                    WHERE a.cost_yrmon = in_yrmon  
--                      AND a.rout_lst_ecc_cd = b.ecc_cd  
--                      AND a.rout_n1st_ecc_cd <> a.rout_lst_ecc_cd --같은 ECC내 MVMT data 제외  
--                      AND a.mty_cost_tp_cd = 'M'  
--                 ) a  
--                 ,coa_full_ecc_imbal b  
--            WHERE a.cost_yrmon = in_yrmon  
--              AND a.cntr_org_dest_cd = 'D'   -- Dest는  Dest 데이터만 SUM  
--              AND b.cost_loc_grp_cd = 'R'  
--              AND a.cost_yrmon = b.cost_yrmon  
--              AND a.rcc_cd = b.fcntr_ecc_cd  
--              AND a.cntr_tpsz_cd = b.cntr_tpsz_cd                
--         GROUP BY a.cost_yrmon, a.cntr_tpsz_cd, a.rcc_cd, b.cntr_io_vol_sts_cd, a.mty_cost_tp_cd;  
  
      enis_log_prc(SYSDATE  
                  ,'COA_CNTR_MTY_MVMT_PRC'  
                  , 'ECC별 Origin DEST 단가합계(4) 종료 COA_MTY_ECC_CNTR_SMRY  ' || SQL%ROWCOUNT || ' Records Inserted '  
                  );  
      COMMIT;  
        
    
        
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', '최종 COA_MTY_ECC_UT_COST 시작 ');  
  
      -- 최종 MTY ECC UNIT COST  
      INSERT INTO coa_mty_ecc_ut_cost  
                  (cost_yrmon  
                  ,ecc_cd  
                  ,cntr_tpsz_cd  
                  ,cntr_org_dest_cd  
                  ,cntr_io_vol_sts_cd  
                  ,imbal_rto  
                  ,mcntr_qty  
                  ,mty_stvg_uc_amt  
                  ,mty_trsp_uc_amt  
                  ,mty_tz_dys  
                  ,mty_tz_hrs  
                  ,full_stvg_uc_amt  
                  ,fcntr_qty  
                  ,full_trsp_uc_amt  
                  ,full_tz_hrs  
                  ,cre_usr_id  
                  ,cre_dt  
                  ,upd_usr_id  
                  ,upd_dt  
                  ,cost_loc_grp_cd  
                  )  
         SELECT a.cost_yrmon  
               ,a.ecc_cd  
               ,a.cntr_tpsz_cd  
               ,a.cntr_org_dest_cd  
               ,a.cntr_io_vol_sts_cd  
               ,b.cntr_imbal_rto  
               ,a.mty_qty  
               ,NVL(a.mty_stvg_uc_amt, 0)  
               ,NVL(a.mty_trsp_uc_amt, 0)  
               ,a.mty_tz_dys  
               ,a.mty_tz_hrs  
               ,NVL(a.mty_stvg_uc_amt, 0)  
               ,0  
               ,NVL(a.mty_trsp_uc_amt, 0)  
               ,a.mty_tz_dys  
               ,'SYSTEM'  
               ,SYSDATE  
               ,'SYSTEM'  
               ,SYSDATE  
               ,a.cost_loc_grp_cd  
           FROM coa_mty_ecc_cntr_smry a, coa_full_ecc_imbal b  
          WHERE a.cost_yrmon = v_yrmon  
            AND a.cost_yrmon = b.cost_yrmon  
            AND a.ecc_cd = b.fcntr_ecc_cd  
            AND a.cntr_tpsz_cd = b.cntr_tpsz_cd  
            AND a.cost_loc_grp_cd = b.cost_loc_grp_cd  
            AND a.mty_repo_sim_cd = 'R'  
            AND a.mty_cost_tp_cd = 'M'; --MT repo 단가 먼저 insert  
           
         --MT repo 단가 insert 후 'S'로 들어온 Simulated 단가 update     
--         MERGE INTO coa_mty_ecc_ut_cost b1  
--            USING ( SELECT a1.cost_yrmon  
--                          ,a1.ecc_cd   
--                          ,a1.cntr_tpsz_cd  
--                          ,a1.cntr_org_dest_cd  
--                          ,a1.cntr_io_vol_sts_cd  
--                          ,a1.cost_loc_grp_cd   
--                          ,a1.mty_qty sim_cntr_qty  
--                          ,NVL(a1.mty_stvg_uc_amt, 0) sim_stvg_uc_amt                             
--                          ,NVL(a1.mty_trsp_uc_amt, 0) sim_trsp_uc_amt  
--                          ,a1.mty_tz_dys sim_tz_dys  
--                          ,a1.mty_tz_hrs sim_tz_hrs  
--                     FROM coa_mty_ecc_cntr_smry a1, coa_full_ecc_imbal a2  
--                    WHERE a1.cost_yrmon = v_yrmon  
--                      AND a1.cost_yrmon = a2.cost_yrmon  
--                      AND a1.ecc_cd = a2.fcntr_ecc_cd  
--                      AND a1.cntr_tpsz_cd = a2.cntr_tpsz_cd  
--                      AND a1.cost_loc_grp_cd = a2.cost_loc_grp_cd  
--                      AND a1.mty_repo_sim_cd = 'S'  
--                      AND a1.mty_cost_tp_cd = 'M') b2 --Simulated 용 단가를 SIM column에 update  
--             ON (     b1.cost_yrmon = b2.cost_yrmon   
--                    AND b1.ecc_cd = b2.ecc_cd   
--                    AND b1.cntr_tpsz_cd= b2.cntr_tpsz_cd   
--                    AND b1.cntr_org_dest_cd = b2.cntr_org_dest_cd   
--                    AND b1.cntr_io_vol_sts_cd= b2.cntr_io_vol_sts_cd   
--                    AND b1.cost_loc_grp_cd= b2.cost_loc_grp_cd )  
--                      
--             WHEN MATCHED THEN   
--                UPDATE   
--                    SET b1.sim_cntr_qty = b2.sim_cntr_qty  
--                       ,b1.sim_stvg_uc_amt = b2.sim_stvg_uc_amt  
--                       ,b1.sim_trsp_uc_amt = b2.sim_trsp_uc_amt  
--                       ,b1.sim_tz_dys = b2.sim_tz_dys  
--                       ,b1.sim_tz_hrs = b2.sim_tz_hrs ;  
--  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', '최종 COA_MTY_ECC_UT_COST 종료  ' || SQL%ROWCOUNT || ' Records Inserted ');  
      COMMIT;  
   END IF;  

--2010.11.26 이윤정 추가
--[CHM-201007334-01] 2011 상반기 EMU 단가 산출 작업
--   update coa_mty_ecc_ut_cost
--   set   SIM_CNTR_QTY = 0
--       , SIM_STVG_UC_AMT = 0
--       , SIM_TRSP_UC_AMT = 0
--       , SIM_TZ_DYS = 0
--       , SIM_TZ_HRS = 0
--   where COST_YRMON = v_yrmon
--   and SIM_CNTR_QTY is null
--   and SIM_STVG_UC_AMT is null
--   and SIM_TRSP_UC_AMT is null
--   and SIM_TZ_DYS is null
--   and SIM_TZ_HRS is null ;
   
   COMMIT; 
     
   enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', '[COA_CNTR_MTY_MVMT_PRC]  : End (Year/Month ' || v_yrmon || ', Step : ' || in_step);  
-------------------------------[ 예외처리부            ]-----------------------  
EXCEPTION  
   WHEN OTHERS  
   THEN  
      v_mig_err_msg := SQLERRM;  
      enis_log_prc(SYSDATE, 'COA_CNTR_MTY_MVMT_PRC', 'Error ' || v_mig_err_msg);  
END COA_CNTR_MTY_MVMT_PRC;