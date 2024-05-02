CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACT_COST_MAPG_PRC_T
IS 
/* 
    1. Name : LEA_ACT_COST_MAPG_PRC 
    2. Create Date : 2007-03-06 
    3. Description : 
     - Uses       : Actual Data(From TES, TRS) Data 를 Estimation Data 에 mapping 및 배부. 
     - Parameters : v_mapg_prt_lvl in  number, 
                    v_exe_yrmon in  varchar2(6), 
                    v_vsl_cd    in  varchar2(4), 
                    v_skd_voy_no    in  varchar2(4), 
                    v_skd_dir_cd    in  varchar2(1), 
                    v_rev_dir_cd    in  varchar2(1), 
                    v_coa_cost_src_cd   in  varchar2(6), 
                    v_n1st_nod_cd   in  varchar2(6) 
     - Remarks 
       (1) ... 
    4. Revision History 
     2007-03-06 : 전재홍 - 최초 생성 
     2007-11-26 : - BKG, REV VVD, CNTC 배부일경우 NODE1 만 비교
                  - NB (AND) estm_cost_amt >0 을 매핑 예외, 배부 조건에 추가 
     2007-11-27 : - n1st_nod_cd => substr(n1st_nod_cd,1,5) 로 배부 기준 변경
     2007-11-28 : - Rev.VVD => Act.VVD 로 배부 기준 변경
     2007-12-04 : - BKG 개별 SEARCH 대신 CNTR BKG HISTORY 참조한 BKG 정보(ETL작업시 처리) 로 로직 변경
     2007-12-05 : - 1.n1st_nod_cd -> 2.substr(n1st_nod_cd,1,5) 로 배부 기준 변경
                  - TP Cost Exception 처리 관련 로직 삭제
     2007-12-06 : - CNTR의 BKG History 처리 로직 추가(Exception)
     2007-12-07 : - NODE Exception 시 OutBound => 마지막노드의 location, InBound => 첫번째노드의 location
     2007-12-18 : - VVD Exception 시 1.n1st_nod_cd -> 2.substr(n1st_nod_cd,1,5) 로 변경
     2008-01-16 : - ACCT_CD 비교 삭제
     2008-01-17 : - 내부거래단가 관련 내용 변경
                    (Cost Code 변환 하지 않고 Accrual 위해 Invoice Count 조정: CNTC 배부시 특정노드만 Count)
     2008-01-23 : - BKG 변경되어 해당 결산월 이후의 데이타일경우 차월대상으로 처리.
     2008-01-25 : - CNTR Mapping 시 CNTR 의 BKG 변경 사항을 기록.
     2008-01-28 : - 배부 기준을 REV.VVD -> ACT.VVD로 변경(Grouping 기준 - LEA_ACT_MAPG_PRT_PRC 포함)
     2008-02-05 : - Partial Container 처리시 BKG 변경사항 우선 적용하여 처리.
     2008-02-11 : - 200801~200803 수행월에는 200710 REV.MONTH 부터
     
*/ 
   v_map_cd           VARCHAR2 (1)              := 'N'; 
   v_tp_ttl_inv_knt   NUMBER                    := 0; 
   v_cnt              NUMBER                    := 0; 
   v_map_cnt          NUMBER                    := 0; 
   sql_cnt            NUMBER                    := 0; 
   -- insert into  LEA_ERR_LOG 
   v_exe_yrmon        VARCHAR2 (6)              := ''; 
   v_rev_yrmon        VARCHAR2 (6)              := ''; 
   v_bkg_no           VARCHAR2 (11)             := ''; 
   v_bkg_no_split     VARCHAR2 (2)              := ''; 
   v_cntr_no          VARCHAR2 (14)             := ''; 
   v_sum_usd_cost     NUMBER (25,13)            := 0; 
   v_prc_tp           VARCHAR2 (30)             := ''; 
   v_lng_rtn          VARCHAR2 (100)            := ''; 
   v_str_desc         VARCHAR2 (100)            := ''; 
   
   v_n_cnt            NUMBER (18)               := 0; -- NODE Excption
      
   v_s_cnt            NUMBER (18)               := 0; -- Original or Split
   v_s_rev_yrmon      VARCHAR2 (6)              := ''; 
   v_s_bkg_no         VARCHAR2 (11)             := ''; 
   v_s_bkg_no_split   VARCHAR2 (2)              := ''; 
   v_s_vsl_cd         VARCHAR2 (4)              := ''; 
   v_s_skd_voy_no     VARCHAR2 (4)              := ''; 
   v_s_skd_dir_cd     VARCHAR2 (1)              := ''; 
   v_s_rev_dir_cd     VARCHAR2 (1)              := ''; 
   v_s_cost_cd        VARCHAR2 (8)              := ''; 
   
   v_modi_knt         NUMBER (18)               := 0; 
   
   v_v_cnt            NUMBER (18)               := 0;
   v_v_csr_no           VARCHAR2(50)              := '';
   v_v_inv_sys_id       VARCHAR2(3)               := '';
   v_v_exe_yrmon      VARCHAR2 (6)                := '';
   
   v_v_bkg_no         VARCHAR2 (11)             := ''; -- REV VVD Change
   v_v_bkg_no_split   VARCHAR2 (2)              := ''; 
   v_vo_vsl_cd         VARCHAR2 (4)              := ''; 
   v_vo_skd_voy_no     VARCHAR2 (4)              := ''; 
   v_vo_skd_dir_cd     VARCHAR2 (1)              := ''; 
   v_vo_rev_dir_cd     VARCHAR2 (1)              := ''; 
   v_vo_rev_yrmon      VARCHAR2 (6)              := '';
   v_vn_rev_yrmon      VARCHAR2 (6)              := '';  
   v_vn_vsl_cd         VARCHAR2 (4)              := ''; 
   v_vn_skd_voy_no     VARCHAR2 (4)              := ''; 
   v_vn_skd_dir_cd     VARCHAR2 (1)              := ''; 
   v_vn_rev_dir_cd     VARCHAR2 (1)              := ''; 
   
   v_n_bkg_no   VARCHAR2(11)     :='';       -- CNTR BKG HISTORY 참조한 New Info     
   v_n_bkg_no_split     VARCHAR2(2)     := '';
   v_n_rev_yrmon    VARCHAR2(6) :='';
   v_n_vsl_cd VARCHAR2(4) :='';
   v_n_skd_voy_no VARCHAR2(4) := '';
   v_n_skd_dir_cd VARCHAR2(1) := '';
   v_n_rev_dir_cd VARCHAR2(1) := '';
   v_bkg_cnt NUMBER(1) := 0;
   
   v_rev_vvd_cng    VARCHAR2(1)                 := 'N';
   
   v_cntr_qty       NUMBER (8,2)                := 0;
  
   v_key              lea_bat_par_prt%ROWTYPE; 
   v_msg              VARCHAR2 (1024); 
   
   v_xx_cnt NUMBER (1);
BEGIN 
   -- 배치 처리정보를 조회한다. 
--   SELECT * 
--     INTO v_key 
--     FROM lea_bat_par_prt
--     where mapg_prt_lvl = '3'
--     and modi_row_knt = 0 
----    WHERE prc_nm = prc_nm_in AND par_prt_seq = par_prt_seq_in; 
---- 
----   -- '처리중' 으로 표시 
--   UPDATE lea_bat_par_prt 
--      SET par_prt_sts_cd = 'R', 
--          st_tms = SYSTIMESTAMP 
--    WHERE prc_nm = v_key.prc_nm and par_prt_seq = v_key.par_prt_seq; 
-- 
----   -- 배치처리 정보 
----   v_msg := 'LEA_ACT_COST_MAP_PRC('||v_Key.Proc_No||') fetched '||v_id ; 
----   lea_log_prc(v_msg||NVL('(VSL='||v_Key.vsl_cd||' VOY='||v_Key.skd_voy_no||' DIR='||v_Key.skd_dir_cd||' REVDIR='||v_Key.rev_dir_cd|| 
----               ' COST_CD='||v_Key.coa_cost_src_cd||' 1st_NOD='||v_Key.n1st_nod_cd, '<NULL>')) ; 
--   COMMIT; 
-- 
--   IF v_key.mapg_prt_lvl IS NULL 
--   THEN 
--      lea_log_prc ('SEQ : ' || TO_CHAR (par_prt_seq_in, '9,990') || ' MAPG_PRT_LVL : <NULL>'); 
--   ELSE 
--      lea_log_prc (   'SEQ : ' 
--                   || TO_CHAR (par_prt_seq_in, '9,990') 
--                   || ' MAPG_PRT_LVL : ' 
--                   || v_key.mapg_prt_lvl 
--                  ); 
--   END IF; 
 
--   IF v_key.mapg_prt_lvl in ( '1','3')
--   THEN 
      FOR c IN (-- v_key.mapg_prt_lvl = 3 인 경우 : group by coa_cost_src_cd, n1st_nod_cd 로 했다. 
                SELECT a.ROWID rid, a.exe_yrmon exe_yrmon, a.inv_sys_id inv_sys_id, a.if_seq if_seq ,a.csr_no csr_no,
                       a.rev_yrmon rev_yrmon, a.bkg_no bkg_no, 
                       a.bkg_no_split bkg_no_split, a.cntr_no cntr_no, a.cntr_tpsz_cd cntr_tpsz_cd, 
                       a.cost_act_grp_cd cost_act_grp_cd, a.cost_act_grp_seq cost_act_grp_seq, 
                       a.coa_cost_src_cd cost_cd, 
                       NVL (a.n1st_thrp_incl_cost_cd, ' ') n1st_thrp_cost_cd, 
                       NVL (a.n2nd_thrp_incl_cost_cd, ' ') n2nd_thrp_cost_cd, 
                       NVL (a.n3rd_thrp_incl_cost_cd, ' ') n3rd_thrp_cost_cd, 
                       a.vsl_cd vsl_cd, a.skd_voy_no skd_voy_no, a.skd_dir_cd skd_dir_cd, a.rev_dir_cd rev_dir_cd, 
                       substr(a.act_vvd_cd, 1, 9) act_vvd_cd,
                       a.acct_cd acct_cd, a.n1st_nod_cd n1st_nod_cd, a.n2nd_nod_cd n2nd_nod_cd, 
                       a.n3rd_nod_cd n3rd_nod_cd, a.n4th_nod_cd n4th_nod_cd, 
                       3 act_cost_type, 
--                       CASE 
--                          WHEN a.cntr_no IS NOT NULL 
--                          AND a.bkg_no IS NOT NULL 
--                          AND a.vsl_cd <> 'CNTC' 
--                             THEN 1 
--                          WHEN a.bkg_no IS NOT NULL AND a.vsl_cd <> 'CNTC' 
--                             THEN 2 
--                          WHEN a.act_vvd_cd is not null and substr(a.act_vvd_cd ,1,4) <> 'CNTC' 
--                             THEN 3 
--                          ELSE 4 
--                       END act_cost_type, 
                       a.inv_no inv_no,
                       a.inv_cxl_flg inv_cxl_flg,
                       a.usd_cost_amt sum_usd_cost, 
                       a.ttl_inv_knt ttl_inv_knt, 
                       DECODE (a.inv_cxl_flg, 'Y', -1, 1) act_inv_knt, 
                       b.accl_lgc_tp_cd accl_lgc_tp
                  FROM lea_act_cost_if a, lea_lgs_cost b 
                 WHERE 3 = 3 
--                 AND a.coa_cost_src_cd = 'SRNDTS'  AND a.n1st_nod_cd = 'SGSINJL' 
                   AND a.exe_yrmon BETWEEN SUBSTR ('200801', 1, 4) AND '200801'
--                   AND a.rev_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
                    AND a.rev_yrmon BETWEEN '200710' AND '200801' 
--                   AND a.rev_yrmon >= '200706'
                   AND a.otr_crr_flg = 'N' 
                   AND a.act_cost_mapg_cd = 'N' 
                   AND b.accl_auto_cd = 'A' 
                   AND b.estm_cost_flg = 'Y' 
                   AND b.accl_flg = 'Y' 
                   AND b.delt_flg = 'N' 
                   AND a.coa_cost_src_cd = b.coa_cost_src_cd 
--                   AND a.acct_cd = b.acct_cd 
--                   AND a.act_vvd_cd =  'ABDO0015E'                 
                   AND CASE 
                            WHEN a.cntr_no IS NOT NULL 
                            AND a.bkg_no IS NOT NULL 
                            AND a.vsl_cd <> 'CNTC' 
                                THEN 1 
                            WHEN a.bkg_no IS NOT NULL AND a.vsl_cd <> 'CNTC' 
                                THEN 2 
                            WHEN a.act_vvd_cd is not null and substr(a.act_vvd_cd ,1,4) <> 'CNTC'  
                                THEN 3 
                            ELSE 4 
                        END = 3
                   UNION ALL 
                   -- v_key.mapg_prt_lvl < 3 인 경우 : coa_cost_src_cd -> '#', n1st_nod_cd -> '#' 로 해서 Group By 에서 빼다. 
                   SELECT a.ROWID rid, a.exe_yrmon exe_yrmon, a.inv_sys_id inv_sys_id, a.if_seq if_seq, a.csr_no csr_no, 
                       a.rev_yrmon rev_yrmon, a.bkg_no bkg_no, 
                       a.bkg_no_split bkg_no_split, a.cntr_no cntr_no, a.cntr_tpsz_cd cntr_tpsz_cd, 
                       a.cost_act_grp_cd cost_act_grp_cd, a.cost_act_grp_seq cost_act_grp_seq, 
                       a.coa_cost_src_cd cost_cd, 
                       NVL (a.n1st_thrp_incl_cost_cd, ' ') n1st_thrp_cost_cd, 
                       NVL (a.n2nd_thrp_incl_cost_cd, ' ') n2nd_thrp_cost_cd, 
                       NVL (a.n3rd_thrp_incl_cost_cd, ' ') n3rd_thrp_cost_cd, 
                       a.vsl_cd vsl_cd, a.skd_voy_no skd_voy_no, a.skd_dir_cd skd_dir_cd, a.rev_dir_cd rev_dir_cd, 
                       substr(a.act_vvd_cd, 1,9) act_vvd_cd,
                       a.acct_cd acct_cd, a.n1st_nod_cd n1st_nod_cd, a.n2nd_nod_cd n2nd_nod_cd, 
                       a.n3rd_nod_cd n3rd_nod_cd, a.n4th_nod_cd n4th_nod_cd, 
                       1 act_cost_type, 
--                       CASE 
--                          WHEN a.cntr_no IS NOT NULL 
--                          AND a.bkg_no IS NOT NULL 
--                          AND a.vsl_cd <> 'CNTC' 
--                             THEN 1 
--                          WHEN a.bkg_no IS NOT NULL AND a.vsl_cd <> 'CNTC' 
--                             THEN 2 
--                          WHEN  a.act_vvd_cd is not null and substr(a.act_vvd_cd ,1,4) <> 'CNTC'  
--                             THEN 3 
--                          ELSE 4 
--                       END act_cost_type, 
                       a.inv_no inv_no,
                       a.inv_cxl_flg inv_cxl_flg,
                       a.usd_cost_amt sum_usd_cost, 
                       a.ttl_inv_knt ttl_inv_knt, 
                       DECODE (a.inv_cxl_flg, 'Y', -1, 1) act_inv_knt, 
                       b.accl_lgc_tp_cd accl_lgc_tp
                  FROM lea_act_cost_if a, lea_lgs_cost b 
                 WHERE 1 < 3 
                   AND a.exe_yrmon BETWEEN SUBSTR ('200801', 1, 4) AND '200801'
--                   AND a.rev_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
                   AND a.rev_yrmon BETWEEN '200710' AND '200801'
--                   AND a.rev_yrmon >= '200706'
                   AND a.otr_crr_flg = 'N' 
                   AND a.act_cost_mapg_cd = 'N' 
                   AND b.accl_auto_cd = 'A' 
                   AND b.estm_cost_flg = 'Y' 
                   AND b.accl_flg = 'Y' 
                   AND b.delt_flg = 'N' 
                   AND (nvl(a.cost_act_grp_cd, ' '), a.coa_cost_src_cd) 
                                not in (('NIBC', 'TMNDFL'),
                                        ('NIBC', 'TMFDFL'),
                                        ('NOBC', 'TMNDFL'),
                                        ('NOBC', 'TMFDFL'))
                   AND a.coa_cost_src_cd = b.coa_cost_src_cd 
--                   AND a.acct_cd = b.acct_cd 
                   AND a.vsl_cd = 'AEAD'
                   AND a.skd_voy_no = '0050'
                   AND a.skd_dir_cd = 'E'
                   AND a.rev_dir_cd ='E'
                   AND  CASE 
                            WHEN a.cntr_no IS NOT NULL 
                            AND a.bkg_no IS NOT NULL 
                            AND a.vsl_cd <> 'CNTC' 
                                THEN 1 
                            WHEN a.bkg_no IS NOT NULL AND a.vsl_cd <> 'CNTC' 
                                THEN 2 
                            WHEN a.act_vvd_cd is not null and substr(a.act_vvd_cd ,1,4) <> 'CNTC'
                                THEN 3 
                            ELSE 4 
                        END = 1
                   ORDER BY exe_yrmon, inv_sys_id, if_seq
                   ) 
      LOOP 
         BEGIN 
            SAVEPOINT savept; 
            v_map_cd := 'N'; 
            sql_cnt := 0; 
            -- Insert into LEA_ERR_LOG 
            v_exe_yrmon := ''; 
            v_rev_yrmon := ''; 
            v_bkg_no := ''; 
            v_bkg_no_split := ''; 
            v_cntr_no := ''; 
            v_sum_usd_cost := 0; 
            v_exe_yrmon := c.exe_yrmon; 
            v_rev_yrmon := c.rev_yrmon; 
            v_bkg_no := c.bkg_no; 
            v_bkg_no_split := c.bkg_no_split; 
            v_cntr_no := c.cntr_no; 
            v_sum_usd_cost := c.sum_usd_cost; 
            v_prc_tp := ''; 
           
            v_s_rev_yrmon := ''; 
            v_s_bkg_no := ''; 
            v_s_bkg_no_split := ''; 
            v_s_vsl_cd := ''; 
            v_s_skd_voy_no := ''; 
            v_s_skd_dir_cd := ''; 
            v_s_rev_dir_cd := ''; 
            v_s_cost_cd := ''; 
            v_s_cnt := 0; 
            v_n_cnt := 0; 
            
            v_v_csr_no           := '';
            v_v_inv_sys_id       := '';
            v_v_exe_yrmon      := '';           
            v_v_bkg_no         := ''; 
            v_v_bkg_no_split   := ''; 
            v_vo_vsl_cd         := ''; 
            v_vo_skd_voy_no     := ''; 
            v_vo_skd_dir_cd     := ''; 
            v_vo_rev_dir_cd     := '';   
            v_vn_vsl_cd         := ''; 
            v_vn_skd_voy_no     := ''; 
            v_vn_skd_dir_cd     := ''; 
            v_vn_rev_dir_cd     := ''; 
            
            v_rev_vvd_cng       := 'N';
            
            v_cntr_qty      := 0;
            v_map_cnt       := 0;
            
            v_n_bkg_no := '';
            v_n_bkg_no_split := '';
            v_n_rev_yrmon := '';
            v_n_vsl_cd :='';
            v_n_skd_voy_no := '';
            v_n_skd_dir_cd := '';
            v_n_rev_dir_cd := '';
       
            v_bkg_cnt := 0;
            v_xx_cnt :=0;
             
--            dbms_output.put_line ('ROWID ' || c.rid); 
--            dbms_output.put_line ('ACT_COST_TYPE ' || c.act_cost_type );
--            dbms_output.put_line (c.rev_yrmon ||' '|| c.bkg_no || ' ' || c.bkg_no_split || ' '); 
--            dbms_output.put_line(c.cntr_no || c.cntr_tpsz_cd ||' ' ||c.cost_act_grp_cd||' '|| c.cost_act_grp_seq); 
--            dbms_output.put_line ( c.cost_cd || ' '||c.acct_cd ); 
--            dbms_output.put_line( c.vsl_cd || ' '|| c.skd_voy_no|| ' '|| c.skd_dir_cd ||' '||c.rev_dir_cd ); 
--            dbms_output.put_line ( c.n1st_nod_cd|| ' '||c.n2nd_nod_cd||' '||c.n3rd_nod_cd||' '||c.n4th_nod_cd); 
--               
                   
            IF c.act_cost_type = '1' 
            THEN 
dbms_output.put_line ('ROWID ' || c.rid); 
               SELECT COUNT (*) , nvl(sum(cntr_qty), 0)
                 INTO v_map_cnt , v_cntr_qty
                 FROM lea_accl_dtl 
                WHERE 1 = 1 
                  AND rev_yrmon = c.rev_yrmon
                  AND bkg_no = c.bkg_no 
                  AND bkg_no_split = c.bkg_no_split
                  AND cntr_no = c.cntr_no 
--                  AND NVL (cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (cntr_tpsz_cd, ' ')) --임시로 제외 2007/10/17 
                  AND cost_act_grp_cd = NVL (c.cost_act_grp_cd, cost_act_grp_cd) 
                  AND cost_act_grp_seq = NVL (c.cost_act_grp_seq, cost_act_grp_seq) 
                  AND coa_cost_src_cd = c.cost_cd 
--                  AND acct_cd = c.acct_cd 
                  AND vsl_cd = c.vsl_cd 
                  AND skd_voy_no = c.skd_voy_no 
                  AND skd_dir_cd = c.skd_dir_cd 
                  AND rev_dir_cd = c.rev_dir_cd 
                  /* NODE 예외로직은 Mapping(Actual과 R.MON, BKG,VSL,COST.. 일치)시 체크하여
                     'CNTR CASE'로 적용.: 20070803 이경한 대리 */                    
                  AND n1st_nod_cd  = CASE 
                                        WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'OD'
                                            THEN n1st_nod_cd
                                        ELSE c.n1st_nod_cd
                                     END
                  AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                  AND NVL (n3rd_nod_cd, ' ') = CASE 
                                                    WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
                                                    AND NVL (n4th_nod_cd, ' ')  = ' '
                                                        THEN  NVL (n3rd_nod_cd, ' ')
                                                    ELSE c.n3rd_nod_cd
                                               END
                  AND NVL (n4th_nod_cd, ' ') = CASE 
                                                    WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
--                                                    AND NVL (n4th_nod_cd, ' ')  <> ' '
                                                        THEN NVL (n4th_nod_cd, ' ')
                                                    ELSE c.n4th_nod_cd
                                               END
                  AND mapg_aloc_flg = 'Y'   -- Accl Calc => 'NO' 
--                  AND bkg_sts_cd = 'F' 
--                  AND estm_cost_amt   >   0 
                  ; 
 
                dbms_output.put_line('COUNT ' ||v_map_cnt);

               IF v_map_cnt = 1 and v_cntr_qty = 1
               THEN 
                  v_prc_tp := 'CNTR'; 
               ELSIF v_map_cnt > 1 
               THEN                    
                  v_prc_tp := 'CNTR_MAP_CNT_OVER';
               ELSE                
--                    <CNTR-BKG Exception Case Check - 임시> 
                    SELECT /*+ FIRST_ROWS */ COUNT(1) INTO v_bkg_cnt FROM lea_accl_dtl
                    WHERE rev_yrmon = c.rev_yrmon
                    AND bkg_no = c.bkg_no
                    AND cntr_no = c.cntr_no
                    AND bkg_no_split  = c.bkg_no_split                   
                    AND mapg_aloc_flg = 'Y' 
                    AND ROWNUM = 1
                    ;
                    
                    dbms_output.put_line('BKGCOUNT ' ||v_bkg_cnt);
                    
                    IF v_bkg_cnt = 0 THEN 

                        SELECT   bkg_no, bkg_no_split, NVL(rev_yrmon, ''), 
                                 NVL(vsl_cd, ''), NVL(skd_voy_no , ''), NVL(skd_dir_cd , ''), NVL(rev_dir_cd ,'')
                        INTO  v_n_bkg_no, v_n_bkg_no_split , v_n_rev_yrmon ,
                              v_n_vsl_cd, v_n_skd_voy_no, v_n_skd_dir_cd, v_n_rev_dir_cd
                        FROM LEA_CNTR_BKG_HIS
                        WHERE BKG_HIS_SEQ = (SELECT MIN(SEQ) FROM 
                                                (SELECT MIN(BKG_HIS_SEQ) SEQ FROM LEA_CNTR_BKG_HIS
                                                WHERE BKG_HIS_SEQ >= (  SELECT BKG_HIS_SEQ FROM LEA_CNTR_BKG_HIS
                                                                        WHERE BKG_NO = c.bkg_no
                                                                        AND BKG_NO_SPLIT =c.bkg_no_split
                                                                        AND CNTR_NO = c.cntr_no)
                                                AND  CNTR_NO =c.cntr_no
                                                AND  COP_STS_CD = 'F'
                                                UNION 
                                                SELECT MAX(BKG_HIS_SEQ) FROM LEA_CNTR_BKG_HIS
                                                WHERE BKG_HIS_SEQ >= (  SELECT BKG_HIS_SEQ FROM LEA_CNTR_BKG_HIS
                                                                        WHERE BKG_NO =c.bkg_no
                                                                        AND BKG_NO_SPLIT =c.bkg_no_split
                                                                        AND CNTR_NO = c.cntr_no)
                                            AND CNTR_NO = c.cntr_no))
                        AND CNTR_NO = c.cntr_no
                        ;
                  
                    ELSE 
                        v_n_bkg_no := c.bkg_no;
                        v_n_bkg_no_split := c.bkg_no_split;
                        v_n_rev_yrmon := c.rev_yrmon;
                        v_n_vsl_cd := c.vsl_cd;
                        v_n_skd_voy_no := c.skd_voy_no;
                        v_n_skd_dir_cd := c.skd_dir_cd;
                        v_n_rev_dir_cd := c.rev_dir_cd;
                    END IF;
                    
DBMS_OUTPUT.PUT_LINE('BKG :' ||v_n_bkg_no||v_n_bkg_no_split);
                    
--                    < 변경된 BKG 으로 PARTIAL CONTAINER Check! >
                    SELECT COUNT (*) , nvl(sum(cntr_qty), 0)
                     INTO v_map_cnt , v_cntr_qty
                     FROM lea_accl_dtl 
                    WHERE 1 = 1 
                      AND rev_yrmon = NVL(v_n_rev_yrmon, rev_yrmon)
                      AND bkg_no = v_n_bkg_no 
                      AND bkg_no_split = v_n_bkg_no_split
                      AND cntr_no = c.cntr_no 
    --                  AND NVL (cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (cntr_tpsz_cd, ' ')) --임시로 제외 2007/10/17 
                      AND cost_act_grp_cd = NVL (c.cost_act_grp_cd, cost_act_grp_cd) 
                      AND cost_act_grp_seq = NVL (c.cost_act_grp_seq, cost_act_grp_seq) 
                      AND coa_cost_src_cd = c.cost_cd 
    --                  AND acct_cd = c.acct_cd 
                      AND vsl_cd = NVL(v_n_vsl_cd , vsl_cd )
                      AND skd_voy_no = NVL(v_n_skd_voy_no, skd_voy_no )
                      AND skd_dir_cd = NVL(v_n_skd_dir_cd, skd_dir_cd )
                      AND rev_dir_cd = NVL(v_n_rev_dir_cd, rev_dir_cd )  
                      AND n1st_nod_cd  = CASE 
                                            WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'OD'
                                                THEN n1st_nod_cd
                                            ELSE c.n1st_nod_cd
                                         END
                      AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                      AND NVL (n3rd_nod_cd, ' ') = CASE 
                                                        WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
                                                        AND NVL (n4th_nod_cd, ' ')  = ' '
                                                            THEN  NVL (n3rd_nod_cd, ' ')
                                                        ELSE c.n3rd_nod_cd
                                                   END
                      AND NVL (n4th_nod_cd, ' ') = CASE 
                                                        WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
    --                                                    AND NVL (n4th_nod_cd, ' ')  <> ' '
                                                            THEN NVL (n4th_nod_cd, ' ')
                                                        ELSE c.n4th_nod_cd
                                                   END
                      AND mapg_aloc_flg = 'Y'   -- Accl Calc => 'NO' 
    --                  AND bkg_sts_cd = 'F' 
    --                  AND estm_cost_amt   >   0 
                      ; 
                    
--                      < Node Exception Case Check>                                                      
                    SELECT COUNT (*) INTO v_n_cnt FROM lea_accl_dtl 
                    WHERE 1 = 1 
--                    AND rev_yrmon = c.rev_yrmon 
                    AND bkg_no = v_n_bkg_no 
                    AND bkg_no_split = v_n_bkg_no_split
                    AND cntr_no = c.cntr_no 
--                          AND NVL (cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (cntr_tpsz_cd, ' ')) 
                    AND cost_act_grp_cd = NVL (c.cost_act_grp_cd, cost_act_grp_cd)
                    AND cost_act_grp_cd <> 'NTST' 
                    AND cost_act_grp_seq = NVL (c.cost_act_grp_seq, cost_act_grp_seq) 
                    AND coa_cost_src_cd = c.cost_cd 
--                    AND acct_cd = c.acct_cd 
                    AND vsl_cd = NVL(v_n_vsl_cd , vsl_cd )
                    AND skd_voy_no = NVL(v_n_skd_voy_no, skd_voy_no )
                    AND skd_dir_cd = NVL(v_n_skd_dir_cd, skd_dir_cd )
                    AND rev_dir_cd = NVL(v_n_rev_dir_cd, rev_dir_cd )                
                    AND CASE WHEN cost_act_grp_cd like 'O%' THEN 
                                    DECODE(n4th_nod_cd , null, 
                                        DECODE(n3rd_nod_cd, null, 
                                            DECODE(n2nd_nod_cd, null, 
                                                n1st_nod_cd, 
                                            n2nd_nod_cd),
                                        n3rd_nod_cd), 
                                    n4th_nod_cd)  
                             ELSE n1st_nod_cd
                        END like CASE WHEN cost_act_grp_cd like 'O%' THEN 
                                                    DECODE(n4th_nod_cd , null, 
                                                        DECODE(n3rd_nod_cd, null, 
                                                            DECODE(n2nd_nod_cd, null, 
                                                                SUBSTR(c.n1st_nod_cd, 1, 5)||'%', 
                                                            SUBSTR(c.n2nd_nod_cd, 1, 5)||'%'),
                                                        SUBSTR(c.n3rd_nod_cd, 1, 5)||'%'), 
                                                    SUBSTR(c.n4th_nod_cd, 1, 5)||'%')                                                    
                                              ELSE SUBSTR(c.n1st_nod_cd, 1, 5)||'%'
                                         END
                    AND mapg_aloc_flg = 'Y'   -- Accl Calc => 'NO' 
                    ;
                    
                    
--                   < VVD Exception Case Check>    
                    SELECT count(1)
                    INTO v_s_cnt 
                    FROM lea_accl_dtl 
                    WHERE bkg_no = v_n_bkg_no 
                    AND bkg_no_split = v_n_bkg_no_split
                    AND cntr_no = c.cntr_no 
                    AND cost_act_grp_seq = NVL (c.cost_act_grp_seq, cost_act_grp_seq)
                    AND cost_act_grp_cd = NVL(c.cost_act_grp_cd, cost_act_grp_cd ) 
                    AND coa_cost_src_cd = c.cost_cd
                    AND mapg_aloc_flg = 'Y' 
                    AND n1st_nod_cd like SUBSTR(c.n1st_nod_cd, 1, 5)||'%'
                    AND ROWNUM = 1;
                    
                    IF v_s_cnt >0 THEN
                        SELECT rev_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd 
                        INTO v_s_rev_yrmon , v_s_vsl_cd, v_s_skd_voy_no, v_s_skd_dir_cd, v_s_rev_dir_cd
                        FROM lea_accl_dtl 
                        WHERE bkg_no = v_n_bkg_no 
                        AND bkg_no_split = v_n_bkg_no_split
                        AND cntr_no = c.cntr_no 
                        AND cost_act_grp_seq = NVL (c.cost_act_grp_seq, cost_act_grp_seq)
                        AND cost_act_grp_cd = NVL(c.cost_act_grp_cd, cost_act_grp_cd ) 
                        AND coa_cost_src_cd = c.cost_cd
                        AND mapg_aloc_flg = 'Y' 
                        AND n1st_nod_cd like SUBSTR(c.n1st_nod_cd, 1, 5)||'%'
                        AND ROWNUM = 1;
                    END IF; 
                    
DBMS_OUTPUT.PUT_LINE('V_MAP = '||v_map_cnt||'V_N = '||v_n_cnt);
                           
                  IF v_map_cnt = 1 and v_cntr_qty < 1 and v_n_rev_yrmon is not null and v_n_vsl_cd is not null
                  THEN
                      v_prc_tp := 'CNTR_P';                  
                  ELSIF    v_n_cnt = 1  --> Only NODE Unmapping 
                  /* 1) Rev Month 가 같으나  Rev VVD 가 다른경우 - Mapping (Allocate) (AND) LEA_REV_VVD_CNG 데이타생성
                     2) Rev Month (Rev VVD) 가 다른경우 - LEA_REV_VVD_CNG 데이타생성 */
                  THEN
                    v_prc_tp := 'ND_EXPT';
                    
                  ELSIF        v_s_cnt > 0  -- Mon (O) (AND) VVD (X) 
                         AND v_s_rev_yrmon = c.rev_yrmon 
                         AND v_s_vsl_cd || v_s_skd_voy_no || v_s_skd_dir_cd || v_s_rev_dir_cd 
                                        <> c.vsl_cd ||c.skd_voy_no ||c.skd_dir_cd || c.rev_dir_cd
                  THEN 
                     v_prc_tp := 'O_RM';  --> LEA_REV_VVD_CNG에 데이타 생성
                     v_rev_vvd_cng := 'Y';                   
                                      
                  ELSIF     v_s_cnt > 0 -- Mon (X) (AND) VVD (X) 
                        AND v_s_rev_yrmon <> c.rev_yrmon 
                        AND v_s_vsl_cd || v_s_skd_voy_no || v_s_skd_dir_cd || v_s_rev_dir_cd 
                                        <> c.vsl_cd ||c.skd_voy_no ||c.skd_dir_cd || c.rev_dir_cd 
                  THEN 
                    v_prc_tp := 'O_EVVD';    --> LEA_REV_VVD_CNG에 데이타 생성
                    v_rev_vvd_cng := 'Y';   
                    
                  ELSIF     v_n_rev_yrmon > v_exe_yrmon   -- 차월 대상이됨
                        OR  v_n_rev_yrmon is null
                  THEN  
                    v_prc_tp := 'OUT_OF_SCOPE';
                  ELSE 
                     v_prc_tp := 'CNTR_MAP_ERR_CASE'; 
                  END IF;              
dbms_output.put_line('v_prc_tp1 ' ||v_prc_tp);                     
               END IF; 
dbms_output.put_line('v_prc_tp2 ' ||v_prc_tp);    
               
            ELSIF c.act_cost_type = '2' 
            THEN 
               v_prc_tp := 'BKG'; 
            ELSIF c.act_cost_type = '3' 
            THEN 
               v_prc_tp := 'ACT_VVD'; 
            ELSE 
               v_prc_tp := 'ACT_COST_TYPE_4'; 
            END IF; 
                
                

                
            IF v_prc_tp = 'O_RM' or v_prc_tp = 'O_EVVD' THEN  
                        
                v_v_exe_yrmon := c.exe_yrmon;
                v_v_csr_no := c.csr_no;
                v_v_bkg_no := v_n_bkg_no ;
                v_v_bkg_no_split := v_n_bkg_no_split;
                v_v_inv_sys_id := c.inv_sys_id;
                v_vo_vsl_cd := c.vsl_cd;
                v_vo_skd_voy_no := c.skd_voy_no;
                v_vo_skd_dir_cd := c.skd_dir_cd;
                v_vo_rev_dir_cd := c.rev_dir_cd;
                v_vn_vsl_cd := v_s_vsl_cd;
                v_vn_skd_voy_no := v_s_skd_voy_no;
                v_vn_skd_dir_cd := v_s_skd_dir_cd;
                v_vn_rev_dir_cd := v_s_rev_dir_cd;
                v_vo_rev_yrmon := c.rev_yrmon;
                v_vn_rev_yrmon := v_s_rev_yrmon;
                 

                SELECT COUNT(*) into v_v_cnt 
                FROM lea_rev_vvd_cng
                WHERE exe_yrmon = v_v_exe_yrmon
                AND csr_no = v_v_csr_no
                AND bkg_no = v_v_bkg_no
                AND bkg_no_split = v_v_bkg_no_split
                ;
                
                IF v_v_cnt = 0 
                THEN
                    INSERT INTO lea_rev_vvd_cng
                    (exe_yrmon, csr_no, bkg_no ,bkg_no_split, inv_sys_id, 
                    old_vsl_cd ,old_skd_voy_no, old_skd_dir_cd, old_rev_dir_cd, 
                    new_vsl_cd, new_skd_voy_no, new_skd_dir_cd, new_rev_dir_cd,
                    old_rev_yrmon, new_rev_yrmon, cre_usr_id, cre_dt , upd_usr_id, upd_dt)
                    VALUES
                    (v_v_exe_yrmon, v_v_csr_no, v_v_bkg_no, v_v_bkg_no_split, v_v_inv_sys_id,
                    v_vo_vsl_cd, v_vo_skd_voy_no, v_vo_skd_dir_cd, v_vo_rev_dir_cd, 
                    v_vn_vsl_cd, v_vn_skd_voy_no, v_vn_skd_dir_cd, v_vn_rev_dir_cd, 
                    v_vo_rev_yrmon, v_vn_rev_yrmon, 'LEA_ACT_BAT', sysdate, 'LEA_ACT_BAT', sysdate );
                END IF;
            END IF;
                      
            IF v_prc_tp = 'CNTR' 
            THEN 
               UPDATE lea_accl_dtl   /* Level 1*/ 
                  SET act_cntr_cost_amt = act_cntr_cost_amt + c.sum_usd_cost,   /* 누적 (수행월 개념 없음) */ 
                      act_cost_amt = act_cost_amt + c.sum_usd_cost, 
                      ttl_inv_knt = 
                         CASE 
                            WHEN (   c.accl_lgc_tp = 'NB' 
                                  OR c.accl_lgc_tp = 'LB' 
                                 ) AND c.inv_cxl_flg = 'Y' 
                               THEN ttl_inv_knt + c.ttl_inv_knt
                            WHEN (   c.accl_lgc_tp = 'NB' 
                                  OR c.accl_lgc_tp = 'LB' 
                                 ) AND c.inv_cxl_flg = 'N' 
                               THEN DECODE (ttl_inv_knt, c.ttl_inv_knt, ttl_inv_knt, c.ttl_inv_knt) 
                            ELSE ttl_inv_knt 
                         END, 
                      act_inv_knt = 
                         CASE 
                            WHEN (   c.accl_lgc_tp = 'NB' 
                                  OR c.accl_lgc_tp = 'LB' 
                                 ) 
                               THEN act_inv_knt + c.act_inv_knt 
                            ELSE act_inv_knt 
                         END, 
                      accl_calc_flg = 'Y' 
                WHERE 1 = 1 
                  AND rev_yrmon = c.rev_yrmon 
                  AND bkg_no = c.bkg_no 
                  AND bkg_no_split = c.bkg_no_split 
                  AND cntr_no = c.cntr_no 
--                  AND NVL (cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (cntr_tpsz_cd, ' ')) 
                  AND cost_act_grp_cd = NVL (c.cost_act_grp_cd, cost_act_grp_cd) 
                  AND cost_act_grp_seq = NVL (c.cost_act_grp_seq, cost_act_grp_seq) 
                  AND coa_cost_src_cd = c.cost_cd 
--                  AND acct_cd = c.acct_cd 
                  AND vsl_cd = c.vsl_cd 
                  AND skd_voy_no = c.skd_voy_no 
                  AND skd_dir_cd = c.skd_dir_cd 
                  AND rev_dir_cd = c.rev_dir_cd 
                  AND n1st_nod_cd  = CASE 
                                        WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'OD'
                                            THEN n1st_nod_cd
                                        ELSE c.n1st_nod_cd
                                     END
                  AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                  AND NVL (n3rd_nod_cd, ' ') = CASE 
                                                    WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
                                                    AND NVL (n4th_nod_cd, ' ')  = ' '
                                                        THEN  NVL (n3rd_nod_cd, ' ')
                                                    ELSE c.n3rd_nod_cd
                                               END
                  AND NVL (n4th_nod_cd, ' ') = CASE 
                                                    WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
--                                                    AND NVL (n4th_nod_cd, ' ')  <> ' '
                                                        THEN NVL (n4th_nod_cd, ' ')
                                                    ELSE c.n4th_nod_cd
                                               END
                  AND mapg_aloc_flg = 'Y'   -- Accl Calc => 'NO' 
--                  AND bkg_sts_cd = 'F' 
--                    and estm_cost_amt   >   0 
               ; 
 
               IF SQL%ROWCOUNT > 0 
               THEN 
                  v_map_cd := 'Y'; 
               ELSE 
                  v_map_cd := 'E'; 
               END IF; 

               v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
            ELSIF v_prc_tp = 'CNTR_P'
            THEN 
                UPDATE lea_accl_dtl  b                  
                SET act_cntr_cost_amt = act_cntr_cost_amt + (c.sum_usd_cost * nvl(b.cntr_qty, 0)),   /* 누적 (수행월 개념 없음) */ 
                    act_cost_amt = act_cost_amt + (c.sum_usd_cost *nvl(b.cntr_qty, 0)), 
                    ttl_inv_knt = 
                                 CASE 
                                    WHEN (   c.accl_lgc_tp = 'NB' 
                                          OR c.accl_lgc_tp = 'LB' 
                                         ) AND c.inv_cxl_flg = 'Y' 
                                       THEN ttl_inv_knt + c.ttl_inv_knt
                                    WHEN (   c.accl_lgc_tp = 'NB' 
                                          OR c.accl_lgc_tp = 'LB' 
                                         ) AND c.inv_cxl_flg = 'N' 
                                       THEN DECODE (ttl_inv_knt, c.ttl_inv_knt, ttl_inv_knt, c.ttl_inv_knt) 
                                    ELSE ttl_inv_knt 
                                 END, 
                    act_inv_knt = 
                                 CASE 
                                    WHEN (   c.accl_lgc_tp = 'NB' 
                                          OR c.accl_lgc_tp = 'LB' 
                                         ) 
                                       THEN act_inv_knt + c.act_inv_knt 
                                    ELSE act_inv_knt 
                                 END, 
                    accl_calc_flg = 'Y' 
                WHERE 1 = 1 
                      AND rev_yrmon = NVL(v_n_rev_yrmon , rev_yrmon)
                      AND cntr_no = c.cntr_no 
--                      AND NVL (cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (cntr_tpsz_cd, ' ')) 
                      AND cost_act_grp_cd = NVL (c.cost_act_grp_cd, cost_act_grp_cd) 
--                      AND cost_act_grp_seq = NVL (c.cost_act_grp_seq, cost_act_grp_seq) -- Check!
                      AND coa_cost_src_cd = c.cost_cd 
--                      AND acct_cd = c.acct_cd 
                      AND vsl_cd = NVL(v_n_vsl_cd , vsl_cd )
                      AND skd_voy_no = NVL(v_n_skd_voy_no, skd_voy_no )
                      AND skd_dir_cd = NVL(v_n_skd_dir_cd, skd_dir_cd )
                      AND rev_dir_cd = NVL(v_n_rev_dir_cd, rev_dir_cd )  
                      AND n1st_nod_cd  = CASE 
                                        WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'OD'
                                            THEN n1st_nod_cd
                                        ELSE c.n1st_nod_cd
                                     END
                      AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                      AND NVL (n3rd_nod_cd, ' ') = CASE 
                                                        WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
                                                        AND NVL (n4th_nod_cd, ' ')  = ' '
                                                            THEN  NVL (n3rd_nod_cd, ' ')
                                                        ELSE c.n3rd_nod_cd
                                                   END
                      AND NVL (n4th_nod_cd, ' ') = CASE 
                                                        WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
    --                                                    AND NVL (n4th_nod_cd, ' ')  <> ' '
                                                            THEN NVL (n4th_nod_cd, ' ')
                                                        ELSE c.n4th_nod_cd
                                                   END
                      AND mapg_aloc_flg = 'Y'   -- Accl Calc => 'NO'
                      AND (( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB')
                           OR (c.accl_lgc_tp <> 'NB'))
                      ; 
                      
                
                IF SQL%ROWCOUNT > 0 
                THEN 
                  v_map_cd := 'Y'; 
                ELSE 
                  v_map_cd := 'E'; 
                END IF; 
                
                v_modi_knt := v_modi_knt + SQL%ROWCOUNT;
            
            ELSIF v_prc_tp = 'ND_EXPT'
            THEN
               UPDATE lea_accl_dtl   /* Level 1*/ 
                  SET act_cntr_cost_amt = act_cntr_cost_amt + c.sum_usd_cost,   /* 누적 (수행월 개념 없음) */ 
                      act_cost_amt = act_cost_amt + c.sum_usd_cost, 
                      ttl_inv_knt = 
                         CASE 
                            WHEN (   c.accl_lgc_tp = 'NB' 
                                  OR c.accl_lgc_tp = 'LB' 
                                 ) AND c.inv_cxl_flg = 'Y' 
                               THEN ttl_inv_knt + c.ttl_inv_knt
                            WHEN (   c.accl_lgc_tp = 'NB' 
                                  OR c.accl_lgc_tp = 'LB' 
                                 ) AND c.inv_cxl_flg = 'N' 
                               THEN DECODE (ttl_inv_knt, c.ttl_inv_knt, ttl_inv_knt, c.ttl_inv_knt) 
                            ELSE ttl_inv_knt 
                         END, 
                      act_inv_knt = 
                         CASE 
                            WHEN (   c.accl_lgc_tp = 'NB' 
                                  OR c.accl_lgc_tp = 'LB' 
                                 ) 
                               THEN act_inv_knt + c.act_inv_knt 
                            ELSE act_inv_knt 
                         END, 
                      accl_calc_flg = 'Y' 
                WHERE 1 = 1 
--                  AND rev_yrmon = c.rev_yrmon 
                  AND bkg_no = v_n_bkg_no 
                  AND bkg_no_split = v_n_bkg_no_split
                  AND cntr_no = c.cntr_no 
--                  AND NVL (cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (cntr_tpsz_cd, ' ')) 
                  AND cost_act_grp_cd = NVL (c.cost_act_grp_cd, cost_act_grp_cd) 
                  AND cost_act_grp_seq = NVL (c.cost_act_grp_seq, cost_act_grp_seq) 
                  AND coa_cost_src_cd = c.cost_cd 
--                  AND acct_cd = c.acct_cd 
                  AND vsl_cd = NVL(v_n_vsl_cd , vsl_cd )
                  AND skd_voy_no = NVL(v_n_skd_voy_no, skd_voy_no )
                  AND skd_dir_cd = NVL(v_n_skd_dir_cd, skd_dir_cd )
                  AND rev_dir_cd = NVL(v_n_rev_dir_cd, rev_dir_cd )  
                  AND CASE WHEN cost_act_grp_cd like 'O%' THEN 
                                    DECODE(n4th_nod_cd , null, 
                                        DECODE(n3rd_nod_cd, null, 
                                            DECODE(n2nd_nod_cd, null, 
                                                n1st_nod_cd, 
                                            n2nd_nod_cd),
                                        n3rd_nod_cd), 
                                    n4th_nod_cd)                                                    
                             ELSE n1st_nod_cd 
                      END like CASE WHEN cost_act_grp_cd like 'O%' THEN 
                                    DECODE(n4th_nod_cd , null, 
                                        DECODE(n3rd_nod_cd, null, 
                                            DECODE(n2nd_nod_cd, null, 
                                                SUBSTR(c.n1st_nod_cd, 1, 5)||'%', 
                                            SUBSTR(c.n2nd_nod_cd, 1, 5)||'%'),
                                        SUBSTR(c.n3rd_nod_cd, 1, 5)||'%'), 
                                    SUBSTR(c.n4th_nod_cd, 1, 5)||'%')                                                    
                                ELSE SUBSTR(c.n1st_nod_cd, 1, 5)||'%'
                                END
                  AND mapg_aloc_flg = 'Y'   -- Accl Calc => 'NO'
                  AND (( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB')
                       OR (c.accl_lgc_tp <> 'NB'))
               ; 
 
               IF SQL%ROWCOUNT > 0 
               THEN 
                  v_map_cd := 'Y'; 
               ELSE 
                  v_map_cd := 'E'; 
               END IF; 

               v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
               
            ELSIF v_prc_tp = 'O_RM' 
            THEN 
               UPDATE lea_accl_dtl z  /* Level 1*/ 
                  SET act_cntr_cost_amt = act_cntr_cost_amt + (c.sum_usd_cost * nvl(z.cntr_qty, 0)),   /* 누적 (수행월 개념 없음) */ 
                      act_cost_amt = act_cost_amt + (c.sum_usd_cost * nvl(z.cntr_qty, 0)), 
                      ttl_inv_knt = 
                         CASE
                            WHEN (   c.accl_lgc_tp = 'NB' 
                                  OR c.accl_lgc_tp = 'LB' 
                                 ) AND c.inv_cxl_flg = 'Y' 
                               THEN ttl_inv_knt + c.ttl_inv_knt 
                            WHEN (   c.accl_lgc_tp = 'NB' 
                                  OR c.accl_lgc_tp = 'LB' 
                                 ) AND c.inv_cxl_flg = 'N' 
                               THEN DECODE (ttl_inv_knt, c.ttl_inv_knt, ttl_inv_knt, c.ttl_inv_knt) 
                            ELSE ttl_inv_knt 
                         END, 
                      act_inv_knt = 
                         CASE 
                            WHEN (   c.accl_lgc_tp = 'NB' 
                                  OR c.accl_lgc_tp = 'LB' 
                                 ) 
                               THEN act_inv_knt + c.act_inv_knt 
                            ELSE act_inv_knt 
                         END, 
                      accl_calc_flg = 'Y' 
                WHERE 1 = 1 
                  AND rev_yrmon = v_s_rev_yrmon 
--                  AND bkg_no = v_s_bkg_no   -- Because of Partial Container
--                  AND bkg_no_split = v_s_bkg_no_split 
                  AND cntr_no = c.cntr_no 
--                  AND NVL (cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (cntr_tpsz_cd, ' ')) 
                  AND cost_act_grp_cd = NVL (c.cost_act_grp_cd, cost_act_grp_cd) 
                  AND cost_act_grp_seq = NVL (c.cost_act_grp_seq, cost_act_grp_seq) 
                  AND coa_cost_src_cd = c.cost_cd 
--                  AND acct_cd = c.acct_cd 
                  AND vsl_cd = v_s_vsl_cd 
                  AND skd_voy_no = v_s_skd_voy_no 
                  AND skd_dir_cd = v_s_skd_dir_cd 
                  AND rev_dir_cd = v_s_rev_dir_cd
                  AND n1st_nod_cd like SUBSTR(c.n1st_nod_cd, 1, 5)||'%'
--                  AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd
--                  AND NVL (n3rd_nod_cd, ' ') = c.n3rd_nod_cd
--                  AND NVL (n4th_nod_cd, ' ') = c.n4th_nod_cd
                  AND mapg_aloc_flg = 'Y'   -- Accl Calc => 'NO' 
                  AND (( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB')
                       OR (c.accl_lgc_tp <> 'NB'))

               ; 
 
               IF SQL%ROWCOUNT > 0 
               THEN 
                  v_map_cd := 'Y'; 
               ELSE 
                  v_map_cd := 'E'; 
               END IF; 
 
               v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
               
            ELSIF v_prc_tp = 'BKG' 
            THEN 
               UPDATE lea_accl_dtl   /* LEA_ACT_COST_MAP_PRC Level 2 */ 
                  SET (act_bkg_cost_amt, act_cost_amt) = 
                         (SELECT ROUND (act_bkg_cost_amt + decode(x.estm_sum , null, 0 , (cntr_qty / x.estm_sum * c.sum_usd_cost)), 13 ), 
                                 ROUND (act_cost_amt + decode(x.estm_sum , null, 0 , (cntr_qty / x.estm_sum * c.sum_usd_cost)), 13) 
                            FROM (SELECT SUM (cntr_qty) estm_sum 
                                    FROM lea_accl_dtl 
                                   WHERE rev_yrmon = c.rev_yrmon 
                                     AND bkg_no = c.bkg_no 
                                     AND bkg_no_split = c.bkg_no_split 
                                     AND coa_cost_src_cd = c.cost_cd 
--                                     AND acct_cd = c.acct_cd 
                                     AND (n1st_vvd_cd = c.act_vvd_cd or n2nd_vvd_cd = c.act_vvd_cd )
--                                     AND vsl_cd = c.vsl_cd 
--                                     AND skd_voy_no = c.skd_voy_no 
--                                     AND skd_dir_cd = c.skd_dir_cd 
--                                     AND rev_dir_cd = c.rev_dir_cd
                                     AND n1st_nod_cd like   CASE WHEN  n1st_nod_cd = c.n1st_nod_cd  
                                                                THEN c.n1st_nod_cd
                                                            ELSE SUBSTR(c.n1st_nod_cd, 1, 5)||'%' 
                                                            END 
--                                     AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
--                                     AND NVL (n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
--                                     AND NVL (n4th_nod_cd, ' ') = c.n4th_nod_cd 
--                                   and estm_cost_amt       >   0 
                                     AND cntr_qty > 0 
                                     AND mapg_aloc_flg = 'Y'                                     
                                     AND act_cntr_cost_amt = 0 --Mapping 금액이 없는 경우만 대상(2007.09.05)
                                     AND (( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB')
                                          OR (c.accl_lgc_tp <> 'NB')) ) x), 
                      accl_calc_flg = 'Y' 
                WHERE rev_yrmon = c.rev_yrmon 
                  AND bkg_no = c.bkg_no 
                  AND bkg_no_split = c.bkg_no_split 
                  AND coa_cost_src_cd = c.cost_cd 
--                  AND acct_cd = c.acct_cd
                  AND (n1st_vvd_cd = c.act_vvd_cd or n2nd_vvd_cd = c.act_vvd_cd ) 
--                  AND vsl_cd = c.vsl_cd 
--                  AND skd_voy_no = c.skd_voy_no 
--                  AND skd_dir_cd = c.skd_dir_cd 
--                  AND rev_dir_cd = c.rev_dir_cd 
                  AND n1st_nod_cd  like CASE WHEN  n1st_nod_cd = c.n1st_nod_cd  
                                               THEN c.n1st_nod_cd
                                        ELSE SUBSTR(c.n1st_nod_cd, 1, 5)||'%' 
                                        END  
--                  AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd
--                  AND NVL (n3rd_nod_cd, ' ') = c.n3rd_nod_cd
--                  AND NVL (n4th_nod_cd, ' ') = c.n4th_nod_cd
--                    and estm_cost_amt       >   0 
                  AND cntr_qty > 0
                  AND act_cntr_cost_amt = 0 
                  AND mapg_aloc_flg = 'Y' 
                  AND (( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB')
                       OR (c.accl_lgc_tp <> 'NB'))
                  ; 
 
               IF SQL%ROWCOUNT > 0 
               THEN 
                  v_map_cd := 'Y'; 
               ELSE 
                  v_map_cd := 'B'; 
               END IF; 
--               dbms_output.put_line('BKG ' ||sql%rowcount ||'  '||v_map_cd);
               v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
            ELSIF v_prc_tp = 'ACT_VVD' 
            THEN
               
               UPDATE lea_accl_dtl   /* LEA_ACT_COST_MAP_PRC Level 3 */ 
                  SET (act_rev_vvd_cost_amt, act_cost_amt) = 
                         (SELECT ROUND (  act_rev_vvd_cost_amt 
                                        + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * c.sum_usd_cost)), 13 ), 
                                 ROUND (act_cost_amt + decode(x.estm_sum, null, 0, (cntr_qty / x.estm_sum * c.sum_usd_cost)), 13) 
                            FROM (SELECT SUM (cntr_qty) estm_sum 
                                    FROM lea_accl_dtl 
                                   WHERE rev_yrmon = c.rev_yrmon 
                                     AND coa_cost_src_cd = c.cost_cd 
--                                     AND acct_cd = c.acct_cd 
                                     AND (n1st_vvd_cd = c.act_vvd_cd or n2nd_vvd_cd = c.act_vvd_cd )
--                                     AND vsl_cd = c.vsl_cd 
--                                     AND skd_voy_no = c.skd_voy_no 
--                                     AND skd_dir_cd = c.skd_dir_cd 
--                                     AND rev_dir_cd = c.rev_dir_cd 
                                     AND n1st_nod_cd  like CASE WHEN  n1st_nod_cd = c.n1st_nod_cd  
                                                                    THEN c.n1st_nod_cd
                                                            ELSE SUBSTR(c.n1st_nod_cd, 1, 5)||'%' 
                                                            END 
--                                     AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd
--                                     AND NVL (n3rd_nod_cd, ' ') = c.n3rd_nod_cd
--                                     AND NVL (n4th_nod_cd, ' ') = c.n4th_nod_cd
--                                     AND bkg_sts_cd = 'F' 
                                     AND mapg_aloc_flg = 'Y'
                                     AND act_cntr_cost_amt = 0 
--                                   and estm_cost_amt       >   0 
                                     AND cntr_qty > 0
                                     AND (( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB')
                                          OR (c.accl_lgc_tp <> 'NB'))) x), 
                      accl_calc_flg = 'Y' 
                WHERE rev_yrmon = c.rev_yrmon 
                  AND coa_cost_src_cd = c.cost_cd 
--                  AND acct_cd = c.acct_cd
                  AND (n1st_vvd_cd = c.act_vvd_cd or n2nd_vvd_cd = c.act_vvd_cd ) 
--                  AND vsl_cd = c.vsl_cd 
--                  AND skd_voy_no = c.skd_voy_no 
--                  AND skd_dir_cd = c.skd_dir_cd 
--                  AND rev_dir_cd = c.rev_dir_cd 
                  AND n1st_nod_cd  like CASE WHEN  n1st_nod_cd = c.n1st_nod_cd  
                                                THEN c.n1st_nod_cd
                                        ELSE SUBSTR(c.n1st_nod_cd, 1, 5)||'%' 
                                        END   
--                  AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd
--                  AND NVL (n3rd_nod_cd, ' ') = c.n3rd_nod_cd
--                  AND NVL (n4th_nod_cd, ' ') = c.n4th_nod_cd
--                    and estm_cost_amt       >   0 
                  AND cntr_qty > 0 
                  AND act_cntr_cost_amt = 0
                  AND mapg_aloc_flg = 'Y' 
                  AND (( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB')
                       OR (c.accl_lgc_tp <> 'NB'))
                  ; 
              
 
               
 
               IF SQL%ROWCOUNT > 0 
               THEN 
                  v_map_cd := 'Y'; 
               ELSE 
                  v_map_cd := 'R'; 
               END IF; 
               
               v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
            ELSIF v_prc_tp = 'CNTR_MAP_ERR_CASE'   OR 
                  v_prc_tp = 'CNTR_MAP_CNT_OVER'
            THEN 
               v_map_cd := 'E'; 
            ELSIF   v_prc_tp = 'O_EVVD' 
            THEN 
               v_map_cd := 'V';
            ELSIF   v_prc_tp = 'OUT_OF_SCOPE'
            THEN
               v_map_cd := 'N';
            ELSE 
               NULL; 
            END IF; 
 
        
--            dbms_output.put_line ('ROWID ' || c.rid); 
             
            UPDATE lea_act_cost_if 
               SET act_cost_mapg_cd = v_map_cd, 
                   bat_st_dt = SYSDATE, 
                   cntr_mapg_expt_log = v_prc_tp,
                   new_rev_yrmon = decode(c.bkg_no||c.bkg_no_split, v_n_bkg_no||v_n_bkg_no_split, null, v_n_bkg_no) ,
                   new_bkg_no = decode(c.bkg_no||c.bkg_no_split, v_n_bkg_no||v_n_bkg_no_split, null, v_n_bkg_no) ,
                   new_bkg_no_split = decode(c.bkg_no||c.bkg_no_split, v_n_bkg_no||v_n_bkg_no_split, null, v_n_bkg_no_split)
             WHERE ROWID = c.rid; 
 
            COMMIT; 
         EXCEPTION 
            WHEN NO_DATA_FOUND 
            THEN UPDATE lea_act_cost_if 
                   SET act_cost_mapg_cd = 'E', 
                       bat_st_dt = SYSDATE, 
                       cntr_mapg_expt_log = 'NO_DATA_FOUND' 
                 WHERE ROWID = c.rid; 
            WHEN OTHERS 
            THEN 
               v_lng_rtn := TO_CHAR (SQLCODE); 
               v_str_desc := SUBSTR (SQLERRM, 1, 100); 
               ROLLBACK TO savept; 
 
               INSERT INTO lea_err_log 
                    VALUES (v_exe_yrmon, v_key.par_prt_seq, v_key.mapg_prt_lvl, 
                            NVL (v_bkg_no, ' '), NVL (v_bkg_no_split, ' '), NVL (v_cntr_no, ' '), 
                            v_key.vsl_cd, v_key.skd_voy_no, v_key.skd_dir_cd, v_key.rev_dir_cd, 
                            c.cost_cd, c.n1st_nod_cd, NVL (v_sum_usd_cost, 0), 
                            v_lng_rtn, v_str_desc); 
 
               COMMIT; 
         END; 
      END LOOP; 
--   ELSIF v_key.mapg_prt_lvl = '4' 
--   THEN 
--      lea_log_prc ('PRT_LEVEL : ' || v_key.mapg_prt_lvl || '<CNTC ALLOCATE>'); 
-- 
--      FOR d IN (SELECT a.exe_yrmon exe_yrmon, a.rev_yrmon rev_yrmon, 
--                       a.coa_cost_src_cd cost_cd, b.accl_lgc_tp_cd accl_lgc_tp, 
--                       a.n1st_nod_cd n1st_nod_cd, a.n2nd_nod_cd n2nd_nod_cd, 
--                       a.n3rd_nod_cd n3rd_nod_cd, a.n4th_nod_cd n4th_nod_cd, 
--                       sum(a.usd_cost_amt) sum_usd_cost
--                  FROM lea_act_cost_if a, lea_lgs_cost b 
--                 WHERE a.exe_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
----                   AND a.rev_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
--                   AND a.rev_yrmon BETWEEN '200710' AND v_key.exe_yrmon 
----                   AND a.rev_yrmon >= '200706'
--                   AND (substr(a.act_vvd_cd , 1, 4) = 'CNTC'  or a.act_vvd_cd is null)
--                   AND a.act_cost_mapg_cd = 'N' 
--                   AND a.otr_crr_flg = 'N' 
--                   AND b.accl_auto_cd = 'A' 
--                   AND b.estm_cost_flg = 'Y' 
--                   AND b.accl_flg = 'Y' 
--                   AND b.delt_flg = 'N' 
--                   AND a.coa_cost_src_cd = v_key.coa_cost_src_cd 
--                   AND a.n1st_nod_cd = v_key.n1st_nod_cd 
--                   AND a.coa_cost_src_cd = b.coa_cost_src_cd 
----                   AND a.acct_cd = b.acct_cd
--                   GROUP BY a.exe_yrmon , a.rev_yrmon , 
--                       a.coa_cost_src_cd , b.accl_lgc_tp_cd , 
--                       a.n1st_nod_cd , a.n2nd_nod_cd , 
--                       a.n3rd_nod_cd , a.n4th_nod_cd ) 
--      LOOP 
--         BEGIN 
--            SAVEPOINT savept; 
--            v_map_cd := 'N'; 
--            sql_cnt := 0; 
--            -- Insert into LEA_ERR_LOG 
--            v_exe_yrmon := ''; 
--            v_rev_yrmon := ''; 
--            v_sum_usd_cost := 0; 
--            v_exe_yrmon := d.exe_yrmon; 
--            v_rev_yrmon := d.rev_yrmon; 
--            v_sum_usd_cost := d.sum_usd_cost; 
-- 
--            UPDATE /*+ index (lea_accl_dtl xak2lea_accl_dtl) */ lea_accl_dtl   /* LEA_ACT_COST_MAP_PRC CNTC Level */ 
--               SET (act_com_vvd_cost_amt, act_cost_amt , ttl_inv_knt, act_inv_knt) = 
--                      (SELECT ROUND (act_com_vvd_cost_amt 
--                                     + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * d.sum_usd_cost)), 13 ), 
--                              ROUND (act_cost_amt + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * d.sum_usd_cost)), 13) ,
--                              CASE 
--                                WHEN ROUND (act_com_vvd_cost_amt 
--                                            + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * d.sum_usd_cost)), 13 ) <> 0 
--                                AND d.n1st_nod_cd in  ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' ) 
--                                AND d.accl_lgc_tp = 'NB'
--                                    THEN 1
--                                ELSE ttl_inv_knt
--                              END,
--                              CASE 
--                                WHEN ROUND (act_com_vvd_cost_amt 
--                                            + decode(x.estm_sum, null, 0 , (cntr_qty / x.estm_sum * d.sum_usd_cost)), 13 ) <> 0 
--                                AND d.n1st_nod_cd in  ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' ) 
--                                AND d.accl_lgc_tp = 'NB'
--                                    THEN 1
--                                ELSE act_inv_knt
--                              END
--                         FROM (SELECT /*+ index (lea_accl_dtl xak2lea_accl_dtl) */ SUM (cntr_qty) estm_sum 
--                                 FROM lea_accl_dtl 
--                                WHERE rev_yrmon = d.rev_yrmon 
--                                  AND coa_cost_src_cd = d.cost_cd 
--                                  AND n1st_nod_cd  like CASE WHEN  n1st_nod_cd = d.n1st_nod_cd  
--                                                                THEN d.n1st_nod_cd
--                                                        ELSE SUBSTR(d.n1st_nod_cd, 1, 5)||'%' 
--                                                        END   
----                                  AND NVL (n2nd_nod_cd, ' ') = d.n2nd_nod_cd
----                                  AND NVL (n3rd_nod_cd, ' ') = d.n3rd_nod_cd
----                                  AND NVL (n4th_nod_cd, ' ') = d.n4th_nod_cd 
----                                  AND bkg_sts_cd = 'F' 
--                                  AND mapg_aloc_flg = 'Y'
--                                  AND cntr_qty > 0 
--                                  AND act_cntr_cost_amt = 0
----                                and estm_cost_amt       >   0 
--                                  AND (( estm_cost_amt > 0 AND d.accl_lgc_tp = 'NB')
--                                       OR (d.accl_lgc_tp <> 'NB')) ) x), 
--                   accl_calc_flg = 'Y' 
--             WHERE rev_yrmon = d.rev_yrmon 
--               AND coa_cost_src_cd = d.cost_cd 
--               AND n1st_nod_cd  like CASE WHEN  n1st_nod_cd = d.n1st_nod_cd  
--                                        THEN d.n1st_nod_cd
--                                    ELSE SUBSTR(d.n1st_nod_cd, 1, 5)||'%' 
--                                    END   
----               AND NVL (n2nd_nod_cd, ' ') = d.n2nd_nod_cd
----               AND NVL (n3rd_nod_cd, ' ') = d.n3rd_nod_cd 
----               AND NVL (n4th_nod_cd, ' ') = d.n4th_nod_cd
--               AND cntr_qty > 0 
--               AND act_cntr_cost_amt = 0
----                and estm_cost_amt       >   0 
--               AND mapg_aloc_flg = 'Y'
--               AND (( estm_cost_amt > 0 AND d.accl_lgc_tp = 'NB')
--                    OR (d.accl_lgc_tp <> 'NB'))
--               ; 
-- 
--            v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
-- 
--            IF SQL%ROWCOUNT > 0 
--            THEN 
--               v_map_cd := 'Y'; 
--            ELSE 
--               v_map_cd := 'C'; 
--            END IF; 
--
--            MERGE INTO lea_act_cost_if c
--            USING (SELECT a.rowid rid FROM  lea_act_cost_if a, lea_lgs_cost b              
--                       WHERE a.exe_yrmon = v_exe_yrmon 
--                       AND a.rev_yrmon = v_rev_yrmon 
--                       AND (substr(a.act_vvd_cd , 1, 4) = 'CNTC'  or a.act_vvd_cd is null) 
--                       AND a.act_cost_mapg_cd = 'N' 
--                       AND a.otr_crr_flg = 'N' 
--                       AND b.accl_auto_cd = 'A' 
--                       AND b.estm_cost_flg = 'Y' 
--                       AND b.accl_flg = 'Y' 
--                       AND b.delt_flg = 'N' 
--                       AND a.coa_cost_src_cd = d.cost_cd
--                       AND a.n1st_nod_cd = d.n1st_nod_cd
--                       AND NVL (n2nd_nod_cd, ' ') = d.n2nd_nod_cd
--                       AND NVL (n3rd_nod_cd, ' ') = d.n3rd_nod_cd
--                       AND NVL (n4th_nod_cd, ' ') = d.n4th_nod_cd
--                       AND a.coa_cost_src_cd = b.coa_cost_src_cd 
----                       AND a.acct_cd = b.acct_cd
--                       ) e
--            ON (c.rowid = e.rid)
--            WHEN MATCHED THEN
--            UPDATE SET act_cost_mapg_cd = v_map_cd, 
--                       bat_st_dt = SYSDATE, 
--                       cntr_mapg_expt_log = 'CNTC_ALLOC' 
--            ;
-- 
--            COMMIT; 
--            
--         EXCEPTION 
--            WHEN OTHERS 
--            THEN 
--               v_lng_rtn := TO_CHAR (SQLCODE); 
--               v_str_desc := SUBSTR (SQLERRM, 1, 100); 
--               ROLLBACK TO savept; 
-- 
--               INSERT INTO lea_err_log 
--                    VALUES (v_exe_yrmon, v_key.par_prt_seq, v_key.mapg_prt_lvl, ' ', ' ', ' ', 
--                            v_key.vsl_cd, v_key.skd_voy_no, v_key.skd_dir_cd, v_key.rev_dir_cd,  
--                            d.cost_cd, d.n1st_nod_cd, NVL (v_sum_usd_cost, 0), 
--                            v_lng_rtn, v_str_desc); 
-- 
--               COMMIT; 
--         END; 
--      END LOOP; 
   /* Error 처리는 배치실행 후  원인 파악 후에 필요함.
      ACT_COST_MAPG_CD2 NVL 처리 OR UPDATE 해야 함.
      AND n1st_nod_cd  like SUBSTR(c.n1st_nod_cd, 1, 5)||'%'  ??*/
      
--   ELSIF v_key.mapg_prt_lvl = '5'  
--   THEN
--   
--        lea_log_prc ('PRT_LEVEL : '|| v_key.mapg_prt_lvl || '<ERROR DATA(E) ALLOCATE>'); 
-- 
--        FOR e IN (SELECT    a.ROWID rid, 
--                            a.exe_yrmon exe_yrmon, 
--                            a.rev_yrmon rev_yrmon, 
--                            a.bkg_no bkg_no, 
--                            a.bkg_no_split bkg_no_split,      
--                            a.coa_cost_src_cd cost_cd, 
--                            a.vsl_cd vsl_cd, 
--                            a.skd_voy_no skd_voy_no, 
--                            a.skd_dir_cd skd_dir_cd, 
--                            a.rev_dir_cd rev_dir_cd, 
--                            a.n1st_nod_cd n1st_nod_cd, 
--                            a.n2nd_nod_cd n2nd_nod_cd, 
--                            a.n3rd_nod_cd n3rd_nod_cd, 
--                            a.n4th_nod_cd n4th_nod_cd,
--                            a.usd_cost_amt sum_usd_cost,
--                            a.act_cost_mapg_cd mapg_cd
--                  FROM lea_act_cost_if a, lea_lgs_cost b 
--                 WHERE a.exe_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
--                   AND a.rev_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
----                   AND a.rev_yrmon >= '200706'
--                   AND a.otr_crr_flg = 'N' 
--                   AND (a.act_cost_mapg_cd = 'E' AND a.act_cost_mapg_cd2 = 'N')
--                   AND b.accl_auto_cd = 'A' 
--                   AND b.estm_cost_flg = 'Y' 
--                   AND b.accl_flg = 'Y' 
--                   AND b.delt_flg = 'N' 
--                   AND a.coa_cost_src_cd = b.coa_cost_src_cd 
----                   AND a.acct_cd = b.acct_cd 
--                   AND a.vsl_cd = v_key.vsl_cd 
--                   AND a.skd_voy_no = v_key.skd_voy_no 
--                   AND a.skd_dir_cd = v_key.skd_dir_cd 
--                   AND a.rev_dir_cd = v_key.rev_dir_cd            
--                ) 
-- 
--        LOOP 
--            BEGIN 
--                SAVEPOINT savept; 
-- 
--                v_map_cd := e.mapg_cd; 
--                sql_cnt := 0; 
-- 
--                -- Insert into LEA_ERR_LOG 
--                v_exe_yrmon :=  ''; 
--                v_rev_yrmon :=  ''; 
--                v_sum_usd_cost  :=  0; 
-- 
--                v_exe_yrmon :=  e.exe_yrmon; 
--                v_rev_yrmon :=  e.rev_yrmon; 
--                v_sum_usd_cost  :=  e.sum_usd_cost; 
---- 
--                  UPDATE lea_accl_dtl   /* LEA_ACT_COST_MAP_PRC Level 5 */ 
--                  SET (act_etc_cost_amt, act_cost_amt) = 
--                         (SELECT ROUND (act_etc_cost_amt + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * e.sum_usd_cost)),13 ), 
--                                 ROUND (act_cost_amt + decode(x.estm_sum, null, 0, (cntr_qty / x.estm_sum * e.sum_usd_cost)), 13) 
--                            FROM (SELECT SUM (cntr_qty) estm_sum 
--                                    FROM lea_accl_dtl 
--                                   WHERE rev_yrmon = e.rev_yrmon 
--                                     AND bkg_no = e.bkg_no 
--                                     AND bkg_no_split = e.bkg_no_split 
--                                     AND coa_cost_src_cd = e.cost_cd 
--                                     AND vsl_cd = e.vsl_cd 
--                                     AND skd_voy_no = e.skd_voy_no 
--                                     AND skd_dir_cd = e.skd_dir_cd 
--                                     AND rev_dir_cd = e.rev_dir_cd
--                                     AND n1st_nod_cd = e.n1st_nod_cd 
----                                     AND NVL (n2nd_nod_cd, ' ') =  e.n2nd_nod_cd
----                                     AND NVL (n3rd_nod_cd, ' ') =  e.n3rd_nod_cd
----                                     AND NVL (n4th_nod_cd, ' ') =  e.n4th_nod_cd 
----                                                        and estm_cost_amt       >   0 
--                                     AND act_cntr_cost_amt = 0
--                                     AND cntr_qty > 0 
--                                     AND mapg_aloc_flg = 'Y' 
--                                     AND (( estm_cost_amt > 0 AND e.accl_lgc_tp = 'NB')
--                                          OR (e.accl_lgc_tp <> 'NB'))
--                          ) x), 
--                      accl_calc_flg = 'Y' 
--                WHERE rev_yrmon = e.rev_yrmon 
--                  AND bkg_no = e.bkg_no 
--                  AND bkg_no_split = e.bkg_no_split 
--                  AND coa_cost_src_cd = e.cost_cd 
--                  AND vsl_cd = e.vsl_cd 
--                  AND skd_voy_no = e.skd_voy_no 
--                  AND skd_dir_cd = e.skd_dir_cd 
--                  AND rev_dir_cd = e.rev_dir_cd
--                  AND n1st_nod_cd = e.n1st_nod_cd 
----                  AND NVL (n2nd_nod_cd, ' ') = e.n2nd_nod_cd 
----                  AND NVL (n3rd_nod_cd, ' ') = e.n3rd_nod_cd
----                  AND NVL (n4th_nod_cd, ' ') = e.n4th_nod_cd
----                    and estm_cost_amt       >   0 
--                  AND cntr_qty > 0 
--                  AND act_cntr_cost_amt = 0
--                  AND mapg_aloc_flg = 'Y' 
--                  AND (( estm_cost_amt > 0 AND e.accl_lgc_tp = 'NB')
--                       OR (e.accl_lgc_tp <> 'NB'))
----                    ; 
-- 
--                IF SQL%ROWCOUNT > 0 
--                THEN 
--                  v_map_cd := 'Y'; 
--                ELSE 
--                  v_map_cd := 'B'; 
--                END IF; 
--                
--                v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
--                
--                update  lea_act_cost_if 
--                set act_cost_mapg_cd2 = v_map_cd , 
--                    bat_st_dt         = sysdate 
--                where rowid = e.rid 
--                ; 
-- 
--                COMMIT; 
--
--            EXCEPTION WHEN OTHERS THEN 
--                v_lng_rtn   := TO_CHAR(SQLCODE); 
--                v_str_desc  := SUBSTR(SQLERRM, 1, 100); 
-- 
--                ROLLBACK  TO savept ; 
-- 
--                insert into lea_err_log 
--                values 
--                (v_exe_yrmon, 
--                v_key.par_prt_seq, 
--                v_key.mapg_prt_lvl, 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                e.cost_cd, 
--                e.n1st_nod_cd, 
--                nvl(v_sum_usd_cost, 0), 
--                v_lng_rtn, 
--                v_str_desc 
--                ); 
-- 
--           COMMIT; 
--            END; 
-- 
--        END LOOP; 
--        
--        
--   ELSIF v_key.mapg_prt_lvl = '6'  
--   THEN
--   
--        lea_log_prc ('PRT_LEVEL : '|| v_key.mapg_prt_lvl || '<ERROR DATA(B) ALLOCATE>'); 
-- 
--        FOR b IN (SELECT    a.ROWID rid, 
--                            a.exe_yrmon exe_yrmon, 
--                            a.rev_yrmon rev_yrmon,     
--                            a.coa_cost_src_cd cost_cd, 
--                            a.vsl_cd vsl_cd, 
--                            a.skd_voy_no skd_voy_no, 
--                            a.skd_dir_cd skd_dir_cd, 
--                            a.rev_dir_cd rev_dir_cd, 
--                            a.n1st_nod_cd n1st_nod_cd, 
--                            a.n2nd_nod_cd n2nd_nod_cd, 
--                            a.n3rd_nod_cd n3rd_nod_cd, 
--                            a.n4th_nod_cd n4th_nod_cd,
--                            a.usd_cost_amt sum_usd_cost,
--                            a.act_cost_mapg_cd mapg_cd
--                  FROM lea_act_cost_if a, lea_lgs_cost b 
--                 WHERE a.exe_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
--                   AND a.rev_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
----                   AND a.rev_yrmon >= '200706'
--                   AND a.otr_crr_flg = 'N' 
--                   AND ((a.act_cost_mapg_cd = 'B' AND a.act_cost_mapg_cd2 =  'N' ) OR a.act_cost_mapg_cd2 = 'B')
--                   AND b.accl_auto_cd = 'A' 
--                   AND b.estm_cost_flg = 'Y' 
--                   AND b.accl_flg = 'Y' 
--                   AND b.delt_flg = 'N' 
--                   AND a.coa_cost_src_cd = b.coa_cost_src_cd 
----                   AND a.acct_cd = b.acct_cd 
--                   AND a.vsl_cd = v_key.vsl_cd 
--                   AND a.skd_voy_no = v_key.skd_voy_no 
--                   AND a.skd_dir_cd = v_key.skd_dir_cd 
--                   AND a.rev_dir_cd = v_key.rev_dir_cd
--                   AND a.coa_cost_src_cd = v_key.coa_cost_src_cd 
--                   AND a.n1st_nod_cd = v_key.n1st_nod_cd           
--                ) 
-- 
--        LOOP 
--            BEGIN 
--                SAVEPOINT savept; 
-- 
--                v_map_cd := b.mapg_cd; 
--                sql_cnt := 0; 
-- 
--                -- Insert into LEA_ERR_LOG 
--                v_exe_yrmon :=  ''; 
--                v_rev_yrmon :=  ''; 
--                v_sum_usd_cost  :=  0; 
-- 
--                v_exe_yrmon :=  b.exe_yrmon; 
--                v_rev_yrmon :=  b.rev_yrmon; 
--                v_sum_usd_cost  :=  b.sum_usd_cost; 
--
--                UPDATE lea_accl_dtl   /* LEA_ACT_COST_MAP_PRC Level 3 */ 
--                  SET (act_etc_cost_amt, act_cost_amt) = 
--                         (SELECT ROUND (  act_etc_cost_amt 
--                                        + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * b.sum_usd_cost)), 
--                                        13 
--                                       ), 
--                                 ROUND (act_cost_amt + decode(x.estm_sum, null, 0, (cntr_qty / x.estm_sum * b.sum_usd_cost)), 13) 
--                            FROM (SELECT SUM (cntr_qty) estm_sum 
--                                    FROM lea_accl_dtl 
--                                   WHERE rev_yrmon = b.rev_yrmon 
--                                     AND coa_cost_src_cd = b.cost_cd 
--                                     AND vsl_cd = b.vsl_cd 
--                                     AND skd_voy_no = b.skd_voy_no 
--                                     AND skd_dir_cd = b.skd_dir_cd 
--                                     AND rev_dir_cd = b.rev_dir_cd 
--                                     AND n1st_nod_cd = b.n1st_nod_cd 
----                                     AND NVL (n2nd_nod_cd, ' ') = b.n2nd_nod_cd 
----                                     AND NVL (n3rd_nod_cd, ' ') = b.n3rd_nod_cd
----                                     AND NVL (n4th_nod_cd, ' ') = b.n4th_nod_cd
----                                     AND bkg_sts_cd = 'F' 
--                                     AND mapg_aloc_flg = 'Y'
--                                    AND act_cntr_cost_amt = 0 
--                                  AND (( estm_cost_amt > 0 AND b.accl_lgc_tp = 'NB')
--                                       OR (b.accl_lgc_tp <> 'NB'))
--                                     AND cntr_qty > 0) x), 
--                      accl_calc_flg = 'Y' 
--                WHERE rev_yrmon = b.rev_yrmon 
--                  AND coa_cost_src_cd = b.cost_cd 
--                  AND vsl_cd = b.vsl_cd 
--                  AND skd_voy_no = b.skd_voy_no 
--                  AND skd_dir_cd = b.skd_dir_cd 
--                  AND rev_dir_cd = b.rev_dir_cd 
--                  AND n1st_nod_cd = b.n1st_nod_cd 
----                  AND NVL (n2nd_nod_cd, ' ') = b.n2nd_nod_cd
----                  AND NVL (n3rd_nod_cd, ' ') = b.n3rd_nod_cd
----                  AND NVL (n4th_nod_cd, ' ') = b.n4th_nod_cd
----                    and estm_cost_amt       >   0 
--                  AND cntr_qty > 0 
--                  AND act_cntr_cost_amt = 0
--                  AND mapg_aloc_flg = 'Y' 
--                  AND (( estm_cost_amt > 0 AND b.accl_lgc_tp = 'NB')
--                       OR (b.accl_lgc_tp <> 'NB'))
--; 
-- 
--                IF SQL%ROWCOUNT > 0 
--                THEN 
--                  v_map_cd := 'Y'; 
--                ELSE 
--                  v_map_cd := 'R'; 
--                END IF; 
--                
--                v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
--                
--                update  lea_act_cost_if 
--                set act_cost_mapg_cd2 = v_map_cd , 
--                    bat_st_dt = sysdate 
--                where rowid = b.rid 
--                ; 
-- 
--                COMMIT; 
--
--            EXCEPTION WHEN OTHERS THEN 
--                v_lng_rtn   := TO_CHAR(SQLCODE); 
--                v_str_desc  := SUBSTR(SQLERRM, 1, 100); 
-- 
--                ROLLBACK  TO savept ; 
-- 
--                insert into lea_err_log 
--                values 
--                (v_exe_yrmon, 
--                v_key.par_prt_seq, 
--                v_key.mapg_prt_lvl, 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                b.cost_cd, 
--                b.n1st_nod_cd, 
--                nvl(v_sum_usd_cost, 0), 
--                v_lng_rtn, 
--                v_str_desc 
--                ); 
-- 
--           COMMIT; 
--            END; 
-- 
--        END LOOP; 
--        
--   ELSIF v_key.mapg_prt_lvl = '7'  
--   THEN
--
--        lea_log_prc ('PRT_LEVEL : '|| v_key.mapg_prt_lvl || '<ERROR DATA(R) ALLOCATE>'); 
-- 
--        FOR r IN (SELECT a.exe_yrmon exe_yrmon, a.rev_yrmon rev_yrmon, 
--                       a.coa_cost_src_cd cost_cd,  
--                       a.n1st_nod_cd n1st_nod_cd, a.n2nd_nod_cd n2nd_nod_cd, 
--                       a.n3rd_nod_cd n3rd_nod_cd, a.n4th_nod_cd n4th_nod_cd, 
--                       sum(a.usd_cost_amt) sum_usd_cost
--                  FROM lea_act_cost_if a, lea_lgs_cost b 
--                 WHERE a.exe_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
--                   AND a.rev_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
----                   AND a.rev_yrmon >= '200706'
--                   AND ((a.act_cost_mapg_cd = 'R' AND a.act_cost_mapg_cd2 =  'N') OR a.act_cost_mapg_cd2 = 'R')
--                   AND a.otr_crr_flg = 'N' 
--                   AND b.accl_auto_cd = 'A' 
--                   AND b.estm_cost_flg = 'Y' 
--                   AND b.accl_flg = 'Y' 
--                   AND b.delt_flg = 'N' 
--                   AND a.coa_cost_src_cd = v_key.coa_cost_src_cd 
--                   AND a.n1st_nod_cd = v_key.n1st_nod_cd 
--                   AND a.coa_cost_src_cd = b.coa_cost_src_cd 
----                   AND a.acct_cd = b.acct_cd
--                   GROUP BY a.exe_yrmon , a.rev_yrmon , 
--                       a.coa_cost_src_cd , 
--                       a.n1st_nod_cd , a.n2nd_nod_cd , 
--                       a.n3rd_nod_cd , a.n4th_nod_cd ) 
--        LOOP 
--        BEGIN 
--            SAVEPOINT savept; 
--            sql_cnt := 0; 
--            -- Insert into LEA_ERR_LOG 
--            v_exe_yrmon := ''; 
--            v_rev_yrmon := ''; 
--            v_sum_usd_cost := 0; 
--            v_exe_yrmon := r.exe_yrmon; 
--            v_rev_yrmon := r.rev_yrmon; 
--            v_sum_usd_cost := r.sum_usd_cost; 
--                    
--            UPDATE /*+ index (lea_accl_dtl xak2lea_accl_dtl) */ lea_accl_dtl   /* LEA_ACT_COST_MAP_PRC CNTC Level */ 
--               SET (act_etc_cost_amt, act_cost_amt) = 
--                      (SELECT ROUND (act_etc_cost_amt + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * r.sum_usd_cost)), 13 ), 
--                              ROUND (act_cost_amt + decode(x.estm_sum, null, 0 , (cntr_qty / x.estm_sum * r.sum_usd_cost)), 13) 
--                         FROM (SELECT /*+ index (lea_accl_dtl xak2lea_accl_dtl) */ SUM (cntr_qty) estm_sum 
--                                 FROM lea_accl_dtl 
--                                WHERE rev_yrmon = r.rev_yrmon 
--                                  AND coa_cost_src_cd = r.cost_cd 
--                                  AND n1st_nod_cd = r.n1st_nod_cd 
----                                  AND NVL (n2nd_nod_cd, ' ') = r.n2nd_nod_cd 
----                                  AND NVL (n3rd_nod_cd, ' ') = r.n3rd_nod_cd
----                                  AND NVL (n4th_nod_cd, ' ') = r.n4th_nod_cd
----                                  AND bkg_sts_cd = 'F' 
--                                  AND mapg_aloc_flg = 'Y' 
--                                  AND cntr_qty > 0 
--                                    AND act_cntr_cost_amt = 0
--                                    AND (( estm_cost_amt > 0 AND r.accl_lgc_tp = 'NB')
--                                          OR (r.accl_lgc_tp <> 'NB'))
--                              ) x), 
--                   accl_calc_flg = 'Y' 
--             WHERE rev_yrmon = r.rev_yrmon 
--               AND coa_cost_src_cd = r.cost_cd 
--               AND n1st_nod_cd = r.n1st_nod_cd 
----               AND NVL (n2nd_nod_cd, ' ') = r.n2nd_nod_cd
----               AND NVL (n3rd_nod_cd, ' ') = r.n3rd_nod_cd
----               AND NVL (n4th_nod_cd, ' ') = r.n4th_nod_cd
--               AND cntr_qty > 0 
--               AND act_cntr_cost_amt = 0
--            --                and estm_cost_amt       >   0 
--               AND mapg_aloc_flg = 'Y' 
--                  AND (( estm_cost_amt > 0 AND r.accl_lgc_tp = 'NB')
--                       OR (r.accl_lgc_tp <> 'NB'))
--; 
--        
--            v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
--            
--            IF SQL%ROWCOUNT > 0 
--            THEN 
--               v_map_cd := 'Y'; 
--            ELSE 
--               v_map_cd := 'C'; 
--            END IF; 
--            
--            v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
--            
--            MERGE INTO lea_act_cost_if c
--            USING (SELECT a.rowid rid FROM  lea_act_cost_if a, lea_lgs_cost b              
--                       WHERE a.exe_yrmon = v_exe_yrmon 
--                       AND a.rev_yrmon = v_rev_yrmon 
--    --                   AND a.rev_yrmon >= '200706'
--                       AND ((a.act_cost_mapg_cd = 'R' AND a.act_cost_mapg_cd2 =  'N' ) or a.act_cost_mapg_cd2 = 'R')
--                       AND a.otr_crr_flg = 'N' 
--                       AND b.accl_auto_cd = 'A' 
--                       AND b.estm_cost_flg = 'Y' 
--                       AND b.accl_flg = 'Y' 
--                       AND b.delt_flg = 'N' 
--                       AND a.coa_cost_src_cd = r.cost_cd
--                       AND a.n1st_nod_cd = r.n1st_nod_cd
--                       AND NVL (n2nd_nod_cd, ' ') = r.n2nd_nod_cd
--                       AND NVL (n3rd_nod_cd, ' ') = r.n3rd_nod_cd
--                       AND NVL (n4th_nod_cd, ' ') = r.n4th_nod_cd
--                       AND a.coa_cost_src_cd = b.coa_cost_src_cd 
----                       AND a.acct_cd = b.acct_cd
--) e
--            ON (c.rowid = e.rid)
--            WHEN MATCHED THEN
--            UPDATE SET act_cost_mapg_cd2 = v_map_cd, 
--                       bat_st_dt = SYSDATE
--            ;
--        
--            COMMIT; 
--
--            EXCEPTION WHEN OTHERS THEN 
--                v_lng_rtn   := TO_CHAR(SQLCODE); 
--                v_str_desc  := SUBSTR(SQLERRM, 1, 100); 
-- 
--                ROLLBACK  TO savept ; 
-- 
--                insert into lea_err_log 
--                values 
--                (v_exe_yrmon, 
--                v_key.par_prt_seq, 
--                v_key.mapg_prt_lvl, 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                r.cost_cd, 
--                r.n1st_nod_cd, 
--                nvl(v_sum_usd_cost, 0), 
--                v_lng_rtn, 
--                v_str_desc 
--                ); 
-- 
--           COMMIT; 
--            END; 
-- 
--        END LOOP; 
--
--   ELSIF v_key.mapg_prt_lvl = '8'  
--   THEN
--
--        lea_log_prc ('PRT_LEVEL : '|| v_key.mapg_prt_lvl || '<ERROR DATA(C) ALLOCATE>'); 
-- 
--        FOR f IN (SELECT a.exe_yrmon exe_yrmon, a.rev_yrmon rev_yrmon, 
--                       a.coa_cost_src_cd cost_cd,                  
--                       sum(a.usd_cost_amt) sum_usd_cost
--                  FROM lea_act_cost_if a, lea_lgs_cost b 
--                 WHERE a.exe_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
--                   AND a.rev_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon 
----                   AND a.rev_yrmon >= '200706'
--                   AND ((a.act_cost_mapg_cd = 'C' AND a.act_cost_mapg_cd2 = 'N') OR a.act_cost_mapg_cd2 = 'C')
--                   AND a.otr_crr_flg = 'N' 
--                   AND b.accl_auto_cd = 'A' 
--                   AND b.estm_cost_flg = 'Y' 
--                   AND b.accl_flg = 'Y' 
--                   AND b.delt_flg = 'N' 
--                   AND a.coa_cost_src_cd = v_key.coa_cost_src_cd 
--                   AND a.coa_cost_src_cd = b.coa_cost_src_cd 
----                   AND a.acct_cd = b.acct_cd
--                   GROUP BY a.exe_yrmon , a.rev_yrmon , a.coa_cost_src_cd ) 
--        LOOP 
--        BEGIN 
--            SAVEPOINT savept; 
--
--            sql_cnt := 0; 
--            -- Insert into LEA_ERR_LOG 
--            v_exe_yrmon := ''; 
--            v_rev_yrmon := ''; 
--            v_sum_usd_cost := 0; 
--            v_exe_yrmon := f.exe_yrmon; 
--            v_rev_yrmon := f.rev_yrmon; 
--            v_sum_usd_cost := f.sum_usd_cost; 
--                    
--            UPDATE /*+ index (lea_accl_dtl xak5lea_accl_dtl) */ lea_accl_dtl   /* LEA_ACT_COST_MAP_PRC err */ 
--               SET (act_etc_cost_amt , act_cost_amt) = 
--                      (SELECT ROUND (act_etc_cost_amt + decode(x.estm_sum, null, 0, (cntr_qty / x.estm_sum * f.sum_usd_cost)), 13 ), 
--                              ROUND (act_cost_amt + decode(x.estm_sum, null, 0, (cntr_qty / x.estm_sum * f.sum_usd_cost)), 13) 
--                         FROM (SELECT /*+ index (lea_accl_dtl xak5lea_accl_dtl) */ SUM (cntr_qty) estm_sum 
--                                 FROM lea_accl_dtl 
--                                WHERE rev_yrmon = f.rev_yrmon 
--                                  AND coa_cost_src_cd = f.cost_cd 
----                                  AND bkg_sts_cd = 'F' 
--                                  AND mapg_aloc_flg = 'Y' 
--                                  AND cntr_qty > 0 
--                                    AND act_cntr_cost_amt = 0
--                                  AND (( estm_cost_amt > 0 AND f.accl_lgc_tp = 'NB')
--                                      OR (f.accl_lgc_tp <> 'NB'))
--                              ) x), 
--                   accl_calc_flg = 'Y' 
--             WHERE rev_yrmon = f.rev_yrmon 
--               AND coa_cost_src_cd = f.cost_cd 
--               AND cntr_qty > 0 
--               AND act_cntr_cost_amt = 0
--            --                and estm_cost_amt       >   0 
--               AND mapg_aloc_flg = 'Y' 
--                  AND (( estm_cost_amt > 0 AND f.accl_lgc_tp = 'NB')
--                       OR (f.accl_lgc_tp <> 'NB'))
--               ; 
--        
--            v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
--            
--            IF SQL%ROWCOUNT > 0 
--            THEN 
--               v_map_cd := 'Y'; 
--            ELSE 
--               v_map_cd := 'X'; 
--            END IF; 
--            
--            v_modi_knt := v_modi_knt + SQL%ROWCOUNT; 
--            
--            MERGE INTO lea_act_cost_if c
--            USING (SELECT a.rowid rid FROM  lea_act_cost_if a, lea_lgs_cost b              
--                       WHERE a.exe_yrmon = v_exe_yrmon 
--                       AND a.rev_yrmon = v_rev_yrmon 
--    --                   AND a.rev_yrmon >= '200706'
--                       AND ((a.act_cost_mapg_cd = 'C' AND a.act_cost_mapg_cd2 = 'N') OR a.act_cost_mapg_cd2 = 'C')
--                       AND a.otr_crr_flg = 'N' 
--                       AND b.accl_auto_cd = 'A' 
--                       AND b.estm_cost_flg = 'Y' 
--                       AND b.accl_flg = 'Y' 
--                       AND b.delt_flg = 'N' 
--                       AND a.coa_cost_src_cd = f.cost_cd
--                       AND a.coa_cost_src_cd = b.coa_cost_src_cd 
----                       AND a.acct_cd = b.acct_cd
--) e
--            ON (c.rowid = e.rid)
--            WHEN MATCHED THEN
--            UPDATE SET act_cost_mapg_cd2 = v_map_cd, 
--                       bat_st_dt = SYSDATE
--            ;
--        
--            COMMIT; 
--
--            EXCEPTION WHEN OTHERS THEN 
--                v_lng_rtn   := TO_CHAR(SQLCODE); 
--                v_str_desc  := SUBSTR(SQLERRM, 1, 100); 
-- 
--                ROLLBACK  TO savept ; 
-- 
--                insert into lea_err_log 
--                values 
--                (v_exe_yrmon, 
--                v_key.par_prt_seq, 
--                v_key.mapg_prt_lvl, 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                ' ', 
--                f.cost_cd, 
--                ' ', 
--                nvl(v_sum_usd_cost, 0), 
--                v_lng_rtn, 
--                v_str_desc 
--                ); 
-- 
--           COMMIT; 
--            END; 
-- 
--        END LOOP; 
--   ELSE
--   NULL;
--           
--   END IF; 
 
   -- 작업 성공으로 표시 
--   UPDATE lea_bat_par_prt 
--      SET par_prt_sts_cd = 'Y', 
--          end_tms = SYSTIMESTAMP, 
--          modi_row_knt = v_modi_knt 
--    WHERE prc_nm = prc_nm_in AND par_prt_seq = par_prt_seq_in; 
-- 
--   COMMIT; 
EXCEPTION 
   WHEN OTHERS 
   THEN 
      v_lng_rtn := TO_CHAR (SQLCODE); 
      v_str_desc := SUBSTR (SQLERRM, 1, 100); 
 
      INSERT INTO lea_err_log 
           VALUES (v_exe_yrmon, v_key.par_prt_seq, v_key.mapg_prt_lvl, 
                    ' ', ' ', ' ',
                    v_key.vsl_cd, v_key.skd_voy_no, v_key.skd_dir_cd, v_key.rev_dir_cd, 
                    ' ', ' ', 
                   NVL (v_sum_usd_cost, 0), v_lng_rtn, v_str_desc); 
 
      COMMIT; 
END;