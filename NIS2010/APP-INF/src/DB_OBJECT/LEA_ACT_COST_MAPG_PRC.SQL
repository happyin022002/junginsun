CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACT_COST_MAPG_PRC (  
   prc_nm_in        IN   lea_bat_par_prt.prc_nm%TYPE,  
   par_prt_seq_in   IN   lea_bat_par_prt.par_prt_seq%TYPE  
)  
IS  
/*  
    1.Object Name      : LEA_ACT_COST_MAPG_PRC 
    2.Version          : 1.0 
    3.Create Date      : 2007-03-26 
    4.Sub System       : Logistics Expense Accrual 
    5.Author           : 전재홍 
    6.Description      : 결산 수행시 매핑/배부 UnFmatching 에러에 대해 User Manual 작업후 
                         작업분에대해 재 매핑/배부처리 
    7.Revision History : 
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
                    (Cost Code 변환 하지 않으며 Accrual 위해 Invoice Count 조정: CNTC 배부시 특정노드만 Count) 
     2008-01-23 : - BKG 변경되어 해당 결산월 이후의 데이타일경우 차월대상으로 처리. 
     2008-01-25 : - CNTR Mapping 시 CNTR 의 BKG 변경 사항을 기록. 
     2008-01-28 : - 배부 기준을 REV.VVD -> ACT.VVD로 변경(Grouping 기준 - LEA_ACT_MAPG_PRT_PRC 포함) 
     2008-02-05 : - Partial Container 처리시 BKG 변경사항 우선 적용하여 처리. 
     2008-02-11 : - 200801~200803 수행월에는 200710 REV.MONTH 부터 
     2008-02-25 : - 매핑 배부시 해당 수행월의 ACT 금액을 ACCL_DTL에 기록. 
                    (해당 수행월의 데이타 검증시 활용함.)                            
     2008-02-27 : - ACT VVD 배부시 에러경우 CNTC 단위로 배부처리. (200803 결산시부터) 
     2008-03-21 : - Node Basic 추정값 상관없이 매핑. => 2007/11/26 사항 롤백임. 
     2008-03-24 : - Node Exception 사항 보완 
                    (모든 cntr mapping level 에서 'NTST' ACT GRP CD 일경우는 1번째 노드 7자리 .  
                     그 외는 1번째 노드의 5자리) 
     2008-04-02 : - OD~, ID~ Activity Group 일경우 TRDR~, SCFU~ Cost Code 4자리로 매핑. 
     2008-04-08 : - Node Exception 사항 추가(롤백사항) 
     2008-04-14 : - Cntr BKG History 관련 Actual BKG 3자리 조건 추가    
     2008-04-16 : - bkg 변경 및 OUT_OF_SCOPE 시에도 CSR 재발행 대상 선별 처리. 
     2008-04-21 : - VVD Exception 로직 변경(New BKG 의 New VVD Check) 
     2008-04-25 : - ACT_VVD 배부시 Rev.Month 비교 조건에서 제외-Performace Check!            
     2008-05-16 : - CNTC 배부시 전용터미널(3개)의 경우는 (SVLDFL+NOBT/NIBT , SVLDTS+NTST)  일치,  
                    그 외에 대해서는 일반 룰에 따라 배부한다. 
     2008-05-21 : - ACT_VVD 배부시 전체 COST CODE 에 대해서 REV. MONTH 범위처리였으나, 
                    NO 인경우만 범위처리하는것으로 수정                               
     2008-05-26 : - MAPG_CD = E UPLN_SO =Y 일경우에 MAPG_CD  =>S 로 처리하여 
                    ERP Summary 시 포함   
                  - ACT VVD 배부시 지정된 REV.MONTH 범위내에서 배부.(롤백사항) 
     2008-09-25 : - TMNDRF 에 대해 CNTC 배부시 EST_COST_AMT > 0 인 cntr에만 배부        
     2008-10-02 : - Invoice 의 CSR no중 Office에 해당하는 부분 5자리 Code로 
                    Control office(LEA_ACCL_DTL) 를 매핑시에 Update. (결산시점의 Office 로 대체 ) 
     2008-11-18 : - ACT VVD 배부 에러시 CNTC 배부 대상으로 변경 처리 
                  - CNTC 배부시 1ST NODE 만 사용토록 변경(대상 감소됨) 
                  - CNTC 배부시 전용터미널이 아닌경우에는 전용터미널 제외한 NODE 에 배부(NO COST 는 제외) 
     2009-01-21 : - Exe.Yrmon가 1,2,3 월일경우 Rev.Month 는 전년도 각각 10,11,12 월부터   
                    포함하도록 로직으로 반영  
     2009-06-16 : - TES에서 소급적용(rtro_tml_inv_flg) 로 I/F 되는 INVOICE 건은 CNTR 매핑 금액과 
                    관계없이 배부 적용 
     2010-03-11 : - ACT_VVD 배부시 당해년도 REV.MONTH 조건 제거
     2010-04-16 : - bkg_no_split 칼럼 제거
      
           
          
*/  
   v_map_cd           VARCHAR2 (1)              := 'N';  
   v_tp_ttl_inv_knt   NUMBER                    := 0;  
   v_cnt              NUMBER                    := 0;  
   v_map_cnt          NUMBER                    := 0;  
   sql_cnt            NUMBER                    := 0;  
   -- insert into  LEA_ERR_LOG  
   v_exe_yrmon        VARCHAR2 (6)              := '';  
   v_rev_yrmon        VARCHAR2 (6)              := '';  
   v_bkg_no           VARCHAR2 (13)             := '';  
   v_bkg_no_split     VARCHAR2 (2)              := '';  
   v_cntr_no          VARCHAR2 (14)             := '';  
   v_sum_usd_cost     NUMBER (25,13)            := 0;  
   v_prc_tp           VARCHAR2 (30)             := '';  
   v_lng_rtn          VARCHAR2 (100)            := '';  
   v_str_desc         VARCHAR2 (100)            := '';  
    
   v_n_cnt            NUMBER (18)               := 0; -- NODE Excption 
          
   v_modi_knt         NUMBER (18)               := 0;  
    
   v_n_bkg_no           VARCHAR2(13)     :='';       -- CNTR BKG HISTORY 참조한 New Info      
   v_n_bkg_no_split     VARCHAR2(2)     := ''; 
   v_n_rev_yrmon        VARCHAR2(6) :=''; 
   v_n_vsl_cd           VARCHAR2(4) :=''; 
   v_n_skd_voy_no       VARCHAR2(4) := ''; 
   v_n_skd_dir_cd       VARCHAR2(1) := ''; 
   v_n_rev_dir_cd       VARCHAR2(1) := ''; 
   v_bkg_cnt            NUMBER(1) := 0; 
    
   v_rev_vvd_cng    VARCHAR2(1)                 := 'N'; 
   v_v_cnt      NUMBER(18) := 0 ;  
    
   v_cntr_qty       NUMBER (8,2)                := 0; 
    
   v_act_vvd_cnt    NUMBER (5) := 0; 
   
   v_key              lea_bat_par_prt%ROWTYPE;  
   v_msg              VARCHAR2 (1024);  
    
   v_xx_cnt NUMBER (1); 
   v_g_cnt NUMBER (2); -- Activity Grp Code  Exception 
BEGIN  
   -- 배치 처리정보를 조회한다.  
   SELECT *  
     INTO v_key  
     FROM lea_bat_par_prt  
    WHERE prc_nm = prc_nm_in AND par_prt_seq = par_prt_seq_in;  
  
   -- '처리중' 으로 표시  
   UPDATE lea_bat_par_prt  
      SET par_prt_sts_cd = 'R',  
          st_tms = SYSTIMESTAMP  
    WHERE prc_nm = prc_nm_in AND par_prt_seq = par_prt_seq_in;  
  
--   -- 배치처리 정보  
--   v_msg := 'LEA_ACT_COST_MAP_PRC('||v_Key.Proc_No||') fetched '||v_id ;  
--   lea_log_prc(v_msg||NVL('(VSL='||v_Key.vsl_cd||' VOY='||v_Key.skd_voy_no||' DIR='||v_Key.skd_dir_cd||' REVDIR='||v_Key.rev_dir_cd||  
--               ' COST_CD='||v_Key.coa_cost_src_cd||' 1st_NOD='||v_Key.n1st_nod_cd, '<NULL>')) ;  
   COMMIT;  
  
   IF v_key.mapg_prt_lvl IS NULL  
   THEN  
      lea_log_prc ('SEQ : ' || TO_CHAR (par_prt_seq_in, '99,990') || ' MAPG_PRT_LVL : <NULL>');  
   ELSE  
      lea_log_prc (   'SEQ : '  
                   || TO_CHAR (par_prt_seq_in, '99,990')  
                   || ' MAPG_PRT_LVL : '  
                   || v_key.mapg_prt_lvl  
                  );  
   END IF;  
  
   IF v_key.mapg_prt_lvl IN ('1', '2', '3')  
   THEN  
      FOR c IN (-- v_key.mapg_prt_lvl = 3 인 경우 : group by coa_cost_src_cd, n1st_nod_cd 로 했다.  
                SELECT a.ROWID rid, a.exe_yrmon exe_yrmon, a.inv_sys_id inv_sys_id, a.if_seq if_seq ,a.csr_no csr_no, 
                       a.rev_yrmon rev_yrmon, a.bkg_no bkg_no,  
                       a.cntr_no cntr_no, a.cntr_tpsz_cd cntr_tpsz_cd,  
                       a.cost_act_grp_cd cost_act_grp_cd, a.cost_act_grp_seq cost_act_grp_seq,  
                       a.coa_cost_src_cd cost_cd,  
                       NVL (a.n1st_thrp_incl_cost_cd, ' ') n1st_thrp_cost_cd,  
                       NVL (a.n2nd_thrp_incl_cost_cd, ' ') n2nd_thrp_cost_cd,  
                       NVL (a.n3rd_thrp_incl_cost_cd, ' ') n3rd_thrp_cost_cd,  
                       a.vsl_cd vsl_cd, a.skd_voy_no skd_voy_no, a.skd_dir_cd skd_dir_cd, a.rev_dir_cd rev_dir_cd,  
                       substr(a.act_vvd_cd, 1, 9) act_vvd_cd, 
                       a.acct_cd acct_cd, a.n1st_nod_cd n1st_nod_cd, a.n2nd_nod_cd n2nd_nod_cd,  
                       a.n3rd_nod_cd n3rd_nod_cd, a.n4th_nod_cd n4th_nod_cd,  
                       v_key.mapg_prt_lvl act_cost_type,  
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
                       b.accl_lgc_tp_cd accl_lgc_tp, 
                       NVL(a.upln_so_flg, 'N') upln_so_flg, 
                       SUBSTR(a.csr_no, 4, 5) ctrl_ofc_cd, 
                       a.rtro_tml_inv_flg rtro_tml_inv_flg 
                  FROM lea_act_cost_if a, lea_lgs_cost b  
                 WHERE v_key.mapg_prt_lvl = 3 AND a.coa_cost_src_cd = v_key.coa_cost_src_cd AND a.n1st_nod_cd = v_key.n1st_nod_cd  
                   AND a.exe_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon  
--                   AND a.rev_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon  
                   AND a.rev_yrmon BETWEEN CASE WHEN SUBSTR(v_key.exe_yrmon, 5 ,2 ) IN ('01','02','03') 
                                                    THEN TO_CHAR(ADD_MONTHS(TO_DATE(v_key.exe_yrmon, 'yyyymm'), -3), 'yyyymm')  
                                                ELSE SUBSTR(v_key.exe_yrmon,  1, 4) || '01' 
                                           END 
                                   AND v_key.exe_yrmon 
                   AND a.otr_crr_flg = 'N'  
                   AND a.act_cost_mapg_cd = 'N'  
                   AND b.accl_auto_cd = 'A'  
                   AND b.estm_cost_flg = 'Y'  
                   AND b.accl_flg = 'Y'  
                   AND b.delt_flg = 'N'  
                   AND a.coa_cost_src_cd = b.coa_cost_src_cd  
--                   AND a.acct_cd = b.acct_cd  
                   AND a.act_vvd_cd =  v_key.vsl_cd || v_key.skd_voy_no ||  v_key.skd_dir_cd                   
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
                        END = v_key.mapg_prt_lvl  
                   UNION ALL  
                   -- v_key.mapg_prt_lvl < 3 인 경우 : coa_cost_src_cd -> '#', n1st_nod_cd -> '#' 로 해서 Group By 에서 빼다.  
                   SELECT a.ROWID rid, a.exe_yrmon exe_yrmon, a.inv_sys_id inv_sys_id, a.if_seq if_seq, a.csr_no csr_no,  
                       a.rev_yrmon rev_yrmon, a.bkg_no bkg_no,  
                       a.cntr_no cntr_no, a.cntr_tpsz_cd cntr_tpsz_cd,  
                       a.cost_act_grp_cd cost_act_grp_cd, a.cost_act_grp_seq cost_act_grp_seq,  
                       a.coa_cost_src_cd cost_cd,  
                       NVL (a.n1st_thrp_incl_cost_cd, ' ') n1st_thrp_cost_cd,  
                       NVL (a.n2nd_thrp_incl_cost_cd, ' ') n2nd_thrp_cost_cd,  
                       NVL (a.n3rd_thrp_incl_cost_cd, ' ') n3rd_thrp_cost_cd,  
                       a.vsl_cd vsl_cd, a.skd_voy_no skd_voy_no, a.skd_dir_cd skd_dir_cd, a.rev_dir_cd rev_dir_cd,  
                       substr(a.act_vvd_cd, 1,9) act_vvd_cd, 
                       a.acct_cd acct_cd, a.n1st_nod_cd n1st_nod_cd, a.n2nd_nod_cd n2nd_nod_cd,  
                       a.n3rd_nod_cd n3rd_nod_cd, a.n4th_nod_cd n4th_nod_cd,  
                       v_key.mapg_prt_lvl act_cost_type,  
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
                       b.accl_lgc_tp_cd accl_lgc_tp , 
                       NVL(a.upln_so_flg, 'N') upln_so_flg,  
                       SUBSTR(a.csr_no, 4, 5) ctrl_ofc_cd, 
                       a.rtro_tml_inv_flg rtro_tml_inv_flg 
                  FROM lea_act_cost_if a, lea_lgs_cost b  
                 WHERE v_key.mapg_prt_lvl < 3  
                   AND a.exe_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon  
                   AND a.rev_yrmon BETWEEN CASE WHEN SUBSTR(v_key.exe_yrmon, 5 ,2 ) IN ('01','02','03') 
                                                    THEN TO_CHAR(ADD_MONTHS(TO_DATE(v_key.exe_yrmon, 'yyyymm'), -3), 'yyyymm')  
                                                ELSE SUBSTR(v_key.exe_yrmon,  1, 4) || '01' 
                                           END 
                                   AND v_key.exe_yrmon 
--                   AND a.rev_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon  
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
                   AND a.vsl_cd = v_key.vsl_cd  
                   AND a.skd_voy_no = v_key.skd_voy_no  
                   AND a.skd_dir_cd = v_key.skd_dir_cd  
                   AND a.rev_dir_cd = v_key.rev_dir_cd  
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
                        END = v_key.mapg_prt_lvl  
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
           
            v_cntr_no := c.cntr_no;  
            v_sum_usd_cost := c.sum_usd_cost;  
            v_prc_tp := '';  
                         
            v_rev_vvd_cng       := 'N'; 
            v_v_cnt := 0; 
             
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
            v_g_cnt := 0; 
             
            v_act_vvd_cnt := 0; 
              
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
              
               SELECT /*+ NO_EXPAND */ COUNT (*) , nvl(sum(cntr_qty), 0) 
                 INTO v_map_cnt , v_cntr_qty 
                 FROM lea_accl_dtl  
                WHERE 1 = 1  
                  AND rev_yrmon = c.rev_yrmon 
                  AND bkg_no = c.bkg_no  
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
                   
                  AND n1st_nod_cd = c.n1st_nod_cd 
                               
--                  AND n1st_nod_cd  like CASE WHEN NVL(c.cost_act_grp_cd, ' ') = 'NTST'  
--                                                THEN c.n1st_nod_cd 
--                                        ELSE SUBSTR(c.n1st_nod_cd, 1, 5)||'%'  
--                                        END 
                  AND mapg_aloc_flg = 'Y'   -- Accl Calc => 'NO'  
--                  AND bkg_sts_cd = 'F'  
--                  AND estm_cost_amt   >   0  
                  ;  
  
--                dbms_output.put_line('COUNT ' ||v_map_cnt); 
 
               IF v_map_cnt = 1 and v_cntr_qty = 1 
               THEN  
                  v_prc_tp := 'CNTR';  
               ELSIF v_map_cnt > 1  
               THEN                     
                  v_prc_tp := 'CNTR_MAP_CNT_OVER'; 
               ELSE                 
--                    <CNTR-BKG Exception Case Check - 임시>  
                    SELECT /*+ FIRST_ROWS INDEX(lea_accl_dtl xpklea_accl_dtl) */ COUNT(1) INTO v_bkg_cnt FROM lea_accl_dtl 
                    WHERE rev_yrmon = c.rev_yrmon 
                    AND bkg_no = c.bkg_no 
                    AND cntr_no = c.cntr_no 

                    AND mapg_aloc_flg = 'Y'  
                    AND ROWNUM = 1 
                    ; 
                     
                    IF v_bkg_cnt = 0 THEN  
 
                        SELECT   bkg_no, NVL(rev_yrmon, ''),  
                                 NVL(vsl_cd, ''), NVL(skd_voy_no , ''), NVL(skd_dir_cd , ''), NVL(rev_dir_cd ,'') 
                        INTO  v_n_bkg_no, v_n_rev_yrmon , 
                              v_n_vsl_cd, v_n_skd_voy_no, v_n_skd_dir_cd, v_n_rev_dir_cd 
                        FROM LEA_CNTR_BKG_HIS 
                        WHERE BKG_HIS_SEQ = (SELECT MIN(SEQ) FROM  
                                                (SELECT MIN(BKG_HIS_SEQ) SEQ FROM LEA_CNTR_BKG_HIS 
                                                WHERE BKG_HIS_SEQ >= (  SELECT BKG_HIS_SEQ FROM LEA_CNTR_BKG_HIS 
                                                                        WHERE BKG_NO = c.bkg_no 
                                                                    
                                                                        AND CNTR_NO = c.cntr_no) 
                                                AND  CNTR_NO =c.cntr_no 
                                                AND  COP_STS_CD = 'F' 
                                                AND  BKG_NO LIKE SUBSTR(c.bkg_no, 1, 3)||'%' 
                                                UNION  
                                                SELECT MAX(BKG_HIS_SEQ) FROM LEA_CNTR_BKG_HIS 
                                                WHERE BKG_HIS_SEQ >= (  SELECT BKG_HIS_SEQ FROM LEA_CNTR_BKG_HIS 
                                                                        WHERE BKG_NO =c.bkg_no 
                                                                     
                                                                        AND CNTR_NO = c.cntr_no) 
                                                AND CNTR_NO = c.cntr_no 
                                                AND BKG_NO LIKE SUBSTR(c.bkg_no, 1, 3)||'%')) 
                        AND CNTR_NO = c.cntr_no 
                        ;  
                   
                    ELSE  
                        v_n_bkg_no := c.bkg_no; 
                     
                        v_n_rev_yrmon := c.rev_yrmon; 
                        v_n_vsl_cd := c.vsl_cd; 
                        v_n_skd_voy_no := c.skd_voy_no; 
                        v_n_skd_dir_cd := c.skd_dir_cd; 
                        v_n_rev_dir_cd := c.rev_dir_cd; 
                    END IF; 
    
                     
--                    < ID~  or OD~ ACT_GRP_CD Exception! > 
                    IF v_n_rev_yrmon is not null and  
                        (c.cost_act_grp_cd like 'ID%' OR c.cost_act_grp_cd like 'OD%') THEN 
                        
                        SELECT COUNT(*)  
                          INTO v_g_cnt 
                          FROM lea_accl_dtl 
                         WHERE 1=1  
                          AND rev_yrmon = v_n_rev_yrmon 
                          AND bkg_no = v_n_bkg_no  
                          
                          AND cntr_no = c.cntr_no  
                          AND (cost_act_grp_cd like 'ID%' OR cost_act_grp_cd like 'OD%') 
                          AND cost_act_grp_seq = c.cost_act_grp_seq  
                          AND coa_cost_src_cd like CASE WHEN (c.cost_cd like 'TRDR%' or c.cost_cd like 'SCFU%') 
                                                            THEN SUBSTR(c.cost_cd , 1, 4 )||'%' 
                                                        ELSE c.cost_cd 
                                                   END  
                          AND mapg_aloc_flg = 'Y'  
                          ; 
                       
                     END IF; 
                       
                     
--                    < 변경된 BKG 으로 PARTIAL CONTAINER Check! > 
                    SELECT /*+ NO_EXPAND */ COUNT (*) , nvl(sum(cntr_qty), 0) 
                     INTO v_map_cnt , v_cntr_qty 
                     FROM lea_accl_dtl  
                    WHERE 1 = 1  
                      AND rev_yrmon = NVL(v_n_rev_yrmon, rev_yrmon) 
                      AND bkg_no = v_n_bkg_no  
                     
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
                       
                      AND n1st_nod_cd like   CASE WHEN  n1st_nod_cd = c.n1st_nod_cd   
                                                    THEN c.n1st_nod_cd 
                                                ELSE SUBSTR(c.n1st_nod_cd, 1, 5)||'%'  
                                                END  
                       
--                      AND n1st_nod_cd  like CASE WHEN NVL(c.cost_act_grp_cd, ' ') = 'NTST'  
--                                                    THEN c.n1st_nod_cd 
--                                                 ELSE SUBSTR(c.n1st_nod_cd, 1, 5)||'%'  
--                                            END 
                      AND mapg_aloc_flg = 'Y'   -- Accl Calc => 'NO'  
    --                  AND bkg_sts_cd = 'F'  
    --                  AND estm_cost_amt   >   0  
                      ;  
                     
--                         < Node Exception Case Check>  
                    SELECT /*+ NO_EXPAND */ COUNT (*) INTO v_n_cnt FROM lea_accl_dtl  
                    WHERE 1 = 1  
                    AND rev_yrmon = NVL(v_n_rev_yrmon, rev_yrmon) 
                    AND bkg_no = v_n_bkg_no  
                    
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
               
                  IF     length (v_n_vsl_cd || v_n_skd_voy_no || v_n_skd_dir_cd || v_n_rev_dir_cd) < 10 
                  THEN 
                      v_prc_tp := 'OUT_OF_SCOPE'; 
                       
                  ELSIF     (v_n_rev_yrmon is null or v_n_rev_yrmon > c.exe_yrmon ) and  
                            length (v_n_vsl_cd || v_n_skd_voy_no || v_n_skd_dir_cd || v_n_rev_dir_cd) = 10 
                  THEN      
                      v_prc_tp := 'O_EVVD';  --> CSR 재발행 대상 
                   
                  ELSIF     v_map_cnt = 1 and v_cntr_qty < 1 and v_n_rev_yrmon is not null and v_n_vsl_cd is not null 
                  THEN 
                      v_prc_tp := 'CNTR_P';  --> Partial Container Mapping 
                      
                  ELSIF    v_g_cnt = 1 
                  THEN   
                      v_prc_tp := 'CNTR_G'; --> OD~ ID~ GRP CD excption 
                       
                  ELSIF    v_n_cnt = 1 
                  THEN 
                      v_prc_tp := 'ND_EXPT'; --> Only NODE Unmapping  
                           
                  ELSIF     v_n_rev_yrmon <> c.rev_yrmon and  
                            length (v_n_vsl_cd || v_n_skd_voy_no || v_n_skd_dir_cd || v_n_rev_dir_cd) = 10  
                  THEN  
                      v_prc_tp := 'O_RM';  --> 매핑 및 CSR 재발행 대상 
                                            
                  ELSE  
                      v_prc_tp := 'CNTR_MAP_ERR_CASE';  --> Error Case 
                       
                  END IF; 
                                 
               END IF;  
                
            ELSIF c.act_cost_type = '2'  
            THEN  
               v_prc_tp := 'BKG';  
            ELSIF c.act_cost_type = '3'  
            THEN  
               v_prc_tp := 'ACT_VVD';  
            ELSE  
               v_prc_tp := 'ACT_COST_TYPE_4';  
            END IF;  
                 
                 
--            dbms_output.put_line('v_prc_tp ' ||v_prc_tp);     
                 
            IF v_prc_tp = 'O_RM' or v_prc_tp = 'O_EVVD' THEN   
                                   
                SELECT COUNT(*) into v_v_cnt  
                FROM lea_rev_vvd_cng 
                WHERE exe_yrmon = c.exe_yrmon 
                AND csr_no = c.csr_no 
                AND bkg_no = c.bkg_no 
            
                ; 
                 
                IF v_v_cnt = 0  
                THEN 
                    INSERT INTO lea_rev_vvd_cng 
                    (exe_yrmon, csr_no, bkg_no , inv_sys_id,  
                    old_vsl_cd ,old_skd_voy_no, old_skd_dir_cd, old_rev_dir_cd,  
                    new_vsl_cd, new_skd_voy_no, new_skd_dir_cd, new_rev_dir_cd, 
                    old_rev_yrmon, new_rev_yrmon, cre_usr_id, cre_dt , upd_usr_id, upd_dt) 
                    VALUES 
                    (c.exe_yrmon, c.csr_no, c.bkg_no, c.inv_sys_id, 
                    c.vsl_cd, c.skd_voy_no, c.skd_dir_cd, c.rev_dir_cd,  
                    v_n_vsl_cd, v_n_skd_voy_no, v_n_skd_dir_cd, v_n_rev_dir_cd,  
                    c.rev_yrmon, v_n_rev_yrmon, 'LEA_ACT_BAT', sysdate, 'LEA_ACT_BAT', sysdate ); 
                END IF; 
            END IF; 
                       
            IF v_prc_tp = 'CNTR'  
            THEN  
               UPDATE /*+ NO_EXPAND */ lea_accl_dtl   /* Level 1*/  
                  SET act_cntr_cost_amt = act_cntr_cost_amt + c.sum_usd_cost,   /* 누적 (수행월 개념 없음) */  
                      act_cost_amt = act_cost_amt + c.sum_usd_cost,  
                      lst_act_cntr_amt = lst_act_cntr_amt + c.sum_usd_cost, 
                      lst_act_upd_dt = sysdate, 
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
                      accl_calc_flg = 'Y' , 
                      ctrl_ofc_cd = c.ctrl_ofc_cd 
                WHERE 1 = 1  
                  AND rev_yrmon = c.rev_yrmon  
                  AND bkg_no = c.bkg_no  
                
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
                   
                  AND n1st_nod_cd = c.n1st_nod_cd 
                   
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
                
            ELSIF v_prc_tp = 'CNTR_G'  
            THEN  
               UPDATE /*+ NO_EXPAND */ lea_accl_dtl   /* Level 1*/  
                  SET act_cntr_cost_amt = act_cntr_cost_amt + c.sum_usd_cost,   /* 누적 (수행월 개념 없음) */  
                      act_cost_amt = act_cost_amt + c.sum_usd_cost,  
                      lst_act_cntr_amt = lst_act_cntr_amt + c.sum_usd_cost, 
                      lst_act_upd_dt = sysdate, 
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
                      accl_calc_flg = 'Y' , 
                      ctrl_ofc_cd = c.ctrl_ofc_cd 
                WHERE 1 = 1 
                AND rev_yrmon = v_n_rev_yrmon 
                AND bkg_no = v_n_bkg_no  
               
                AND cntr_no = c.cntr_no  
                AND (cost_act_grp_cd like 'ID%' OR cost_act_grp_cd like 'OD%')                  
                AND cost_act_grp_seq = c.cost_act_grp_seq  
                AND coa_cost_src_cd like CASE WHEN (c.cost_cd like 'TRDR%' or c.cost_cd like 'SCFU%') 
                                                THEN SUBSTR(c.cost_cd , 1, 4 )||'%' 
                                              ELSE c.cost_cd 
                                         END  
                AND mapg_aloc_flg = 'Y'   
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
                    lst_act_cntr_amt = lst_act_cntr_amt + (c.sum_usd_cost * nvl(b.cntr_qty, 0)), 
                    lst_act_upd_dt = sysdate, 
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
                    accl_calc_flg = 'Y' , 
                    ctrl_ofc_cd = c.ctrl_ofc_cd 
                WHERE 1 = 1  
                      AND rev_yrmon = NVL(v_n_rev_yrmon , rev_yrmon) 
                      AND cntr_no = c.cntr_no  
--                      AND NVL (cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (cntr_tpsz_cd, ' '))  
                      AND cost_act_grp_cd = NVL (c.cost_act_grp_cd, cost_act_grp_cd)  
                      AND cost_act_grp_seq = NVL (c.cost_act_grp_seq, cost_act_grp_seq) -- Check! 
                      AND coa_cost_src_cd = c.cost_cd  
--                      AND acct_cd = c.acct_cd  
                      AND vsl_cd = NVL(v_n_vsl_cd , vsl_cd ) 
                      AND skd_voy_no = NVL(v_n_skd_voy_no, skd_voy_no ) 
                      AND skd_dir_cd = NVL(v_n_skd_dir_cd, skd_dir_cd ) 
                      AND rev_dir_cd = NVL(v_n_rev_dir_cd, rev_dir_cd )   
                       
                      AND n1st_nod_cd like   CASE WHEN  n1st_nod_cd = c.n1st_nod_cd   
                                                THEN c.n1st_nod_cd 
                                            ELSE SUBSTR(c.n1st_nod_cd, 1, 5)||'%'  
                                            END  
 
                      AND mapg_aloc_flg = 'Y'   -- Accl Calc => 'NO' 
--                      AND (( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB') 
--                           OR (c.accl_lgc_tp <> 'NB')) 
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
                      lst_act_cntr_amt = lst_act_cntr_amt + c.sum_usd_cost, 
                      lst_act_upd_dt = sysdate, 
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
                      accl_calc_flg = 'Y' , 
                      ctrl_ofc_cd = c.ctrl_ofc_cd 
                WHERE 1 = 1  
--                  AND rev_yrmon = c.rev_yrmon  
                  AND bkg_no = v_n_bkg_no  
                 
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
               UPDATE /*+ NO_EXPAND */ lea_accl_dtl z  /* Level 1*/  
                  SET act_cntr_cost_amt = act_cntr_cost_amt + (c.sum_usd_cost * nvl(z.cntr_qty, 0)),   /* 누적 (수행월 개념 없음) */            
                      act_cost_amt = act_cost_amt + (c.sum_usd_cost * nvl(z.cntr_qty, 0)),  
                      lst_act_cntr_amt = lst_act_cntr_amt + (c.sum_usd_cost * nvl(z.cntr_qty, 0)), 
                      lst_act_upd_dt = sysdate, 
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
                      accl_calc_flg = 'Y' , 
                      ctrl_ofc_cd = c.ctrl_ofc_cd 
                WHERE 1 = 1  
                  AND rev_yrmon = v_n_rev_yrmon  
                  AND bkg_no = v_n_bkg_no   -- Because of Partial Container 
             
                  AND cntr_no = c.cntr_no  
--                  AND NVL (cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (cntr_tpsz_cd, ' '))  
                  AND cost_act_grp_cd = NVL (c.cost_act_grp_cd, cost_act_grp_cd)  
                  AND cost_act_grp_seq = NVL (c.cost_act_grp_seq, cost_act_grp_seq)  
                  AND coa_cost_src_cd = c.cost_cd  
--                  AND acct_cd = c.acct_cd  
                  AND vsl_cd = v_n_vsl_cd  
                  AND skd_voy_no = v_n_skd_voy_no  
                  AND skd_dir_cd = v_n_skd_dir_cd  
                  AND rev_dir_cd = v_n_rev_dir_cd 
                  AND n1st_nod_cd like   CASE WHEN  n1st_nod_cd = c.n1st_nod_cd   
                                            THEN c.n1st_nod_cd 
                                        ELSE SUBSTR(c.n1st_nod_cd, 1, 5)||'%'  
                                        END  
                  AND mapg_aloc_flg = 'Y'   
--                  AND (( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB') 
--                       OR (c.accl_lgc_tp <> 'NB')) 
 
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
               UPDATE /*+ NO_EXPAND */ lea_accl_dtl   /* LEA_ACT_COST_MAP_PRC Level 2 */  
                  SET (act_bkg_cost_amt, act_cost_amt) =  
                         (SELECT ROUND (act_bkg_cost_amt + decode(x.estm_sum , null, 0 , (cntr_qty / x.estm_sum * c.sum_usd_cost)), 13 ),  
                                 ROUND (act_cost_amt + decode(x.estm_sum , null, 0 , (cntr_qty / x.estm_sum * c.sum_usd_cost)), 13)  
                            FROM (SELECT SUM (cntr_qty) estm_sum  
                                    FROM lea_accl_dtl  
                                   WHERE rev_yrmon = c.rev_yrmon  
                                     AND bkg_no = c.bkg_no  
                                    
                                     AND coa_cost_src_cd = c.cost_cd  
--                                     AND acct_cd = c.acct_cd  
                                     AND (n1st_vvd_cd = c.act_vvd_cd or n2nd_vvd_cd = c.act_vvd_cd ) 
--                                     AND vsl_cd = c.vsl_cd  
--                                     AND skd_voy_no = c.skd_voy_no  
--                                     AND skd_dir_cd = c.skd_dir_cd  
--                                     AND rev_dir_cd = c.rev_dir_cd 
                                     AND n1st_nod_cd like SUBSTR(c.n1st_nod_cd, 1, 5)||'%'  
--                                     AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd  
--                                     AND NVL (n3rd_nod_cd, ' ') = c.n3rd_nod_cd  
--                                     AND NVL (n4th_nod_cd, ' ') = c.n4th_nod_cd  
--                                   and estm_cost_amt       >   0  
                                     AND cntr_qty > 0  
                                     AND mapg_aloc_flg = 'Y'                                      
                                     AND act_cntr_cost_amt = 0 --Mapping 금액이 없는 경우만 대상(2007.09.05) 
--                                     AND ( ( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB') 
--                                          OR (c.accl_lgc_tp <> 'NB') )  
                                          ) x),  
                      accl_calc_flg = 'Y'  
                WHERE rev_yrmon = c.rev_yrmon  
                  AND bkg_no = c.bkg_no  
                   
                  AND coa_cost_src_cd = c.cost_cd  
--                  AND acct_cd = c.acct_cd 
                  AND (n1st_vvd_cd = c.act_vvd_cd or n2nd_vvd_cd = c.act_vvd_cd )  
--                  AND vsl_cd = c.vsl_cd  
--                  AND skd_voy_no = c.skd_voy_no  
--                  AND skd_dir_cd = c.skd_dir_cd  
--                  AND rev_dir_cd = c.rev_dir_cd  
                    AND n1st_nod_cd like SUBSTR(c.n1st_nod_cd, 1, 5)||'%'  
--                  AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
--                  AND NVL (n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
--                  AND NVL (n4th_nod_cd, ' ') = c.n4th_nod_cd 
--                    and estm_cost_amt       >   0  
                  AND cntr_qty > 0 
                  AND act_cntr_cost_amt = 0  
                  AND mapg_aloc_flg = 'Y'  
--                  AND (( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB') 
--                       OR (c.accl_lgc_tp <> 'NB')) 
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
 
               UPDATE /*+ index (lea_accl_dtl xak6lea_accl_dtl) */ lea_accl_dtl    
                  SET (act_rev_vvd_cost_amt, act_cost_amt, lst_act_rev_vvd_amt ) =  
                         (SELECT ROUND (  act_rev_vvd_cost_amt  
                                        + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * c.sum_usd_cost)), 13 ),  
                                 ROUND (act_cost_amt + decode(x.estm_sum, null, 0, (cntr_qty / x.estm_sum * c.sum_usd_cost)), 13) , 
                                 ROUND (  lst_act_rev_vvd_amt  
                                        + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * c.sum_usd_cost)), 13 ) 
                            FROM (SELECT /*+ index (lea_accl_dtl xak6lea_accl_dtl) */ SUM (cntr_qty) estm_sum  
                                    FROM lea_accl_dtl  
                                   WHERE 1=1 
--                                     AND rev_yrmon like substr(c.exe_yrmon, 1, 4)||'%' 
                                     AND rev_yrmon = c.rev_yrmon 
--                                     AND ( (accl_lgc_tp_cd = 'NO' AND rev_yrmon BETWEEN to_char(add_months(to_date(c.rev_yrmon, 'yyyymm') , -1 ), 'yyyymm')  
--                                                                                AND to_char( add_months(to_date(c.rev_yrmon, 'yyyymm') , 1 ), 'yyyymm') ) 
--                                           OR 
--                                           (accl_lgc_tp_cd = 'NB' AND rev_yrmon = c.rev_yrmon) 
--                                         )                                                            
                                     AND coa_cost_src_cd = c.cost_cd  
--                                     AND acct_cd = c.acct_cd  
                                     AND (n1st_vvd_cd = c.act_vvd_cd or n2nd_vvd_cd = c.act_vvd_cd ) 
--                                     AND vsl_cd = c.vsl_cd  
--                                     AND skd_voy_no = c.skd_voy_no  
--                                     AND skd_dir_cd = c.skd_dir_cd  
--                                     AND rev_dir_cd = c.rev_dir_cd  
                                     AND n1st_nod_cd  like SUBSTR(c.n1st_nod_cd, 1, 5)||'%'  
--                                     AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
--                                     AND NVL (n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
--                                     AND NVL (n4th_nod_cd, ' ') = c.n4th_nod_cd 
--                                     AND bkg_sts_cd = 'F'  
                                     AND mapg_aloc_flg = 'Y' 
                                     AND act_cntr_cost_amt = DECODE(c.rtro_tml_inv_flg, 'Y', act_cntr_cost_amt , 0 ) 
--                                   and estm_cost_amt       >   0  
                                     AND cntr_qty > 0 
--                                     AND ( ( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB') 
--                                          OR (c.accl_lgc_tp <> 'NB')) 
                                        ) x),  
                      accl_calc_flg = 'Y' , 
                      lst_act_upd_dt = sysdate 
                WHERE 1=1 
--                  AND rev_yrmon like substr(c.exe_yrmon, 1, 4)||'%' 
                  AND rev_yrmon = c.rev_yrmon 
--                  AND ( (accl_lgc_tp_cd = 'NO' AND rev_yrmon BETWEEN to_char(add_months(to_date(c.rev_yrmon, 'yyyymm') , -1 ), 'yyyymm')  
--                                                             AND to_char( add_months(to_date(c.rev_yrmon, 'yyyymm') , 1 ), 'yyyymm') ) 
--                        OR 
--                        (accl_lgc_tp_cd = 'NB' AND rev_yrmon = c.rev_yrmon) 
--                      )    
                  AND coa_cost_src_cd = c.cost_cd  
--                  AND acct_cd = c.acct_cd 
                  AND (n1st_vvd_cd = c.act_vvd_cd or n2nd_vvd_cd = c.act_vvd_cd )  
--                  AND vsl_cd = c.vsl_cd  
--                  AND skd_voy_no = c.skd_voy_no  
--                  AND skd_dir_cd = c.skd_dir_cd  
--                  AND rev_dir_cd = c.rev_dir_cd  
                  AND n1st_nod_cd  like SUBSTR(c.n1st_nod_cd, 1, 5)||'%'  
--                  AND NVL (n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
--                  AND NVL (n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
--                  AND NVL (n4th_nod_cd, ' ') = c.n4th_nod_cd 
--                    and estm_cost_amt       >   0  
                  AND cntr_qty > 0  
                  AND act_cntr_cost_amt = DECODE(c.rtro_tml_inv_flg, 'Y', act_cntr_cost_amt , 0 ) 
                  AND mapg_aloc_flg = 'Y'  
--                  AND (( estm_cost_amt > 0 AND c.accl_lgc_tp = 'NB') 
--                       OR (c.accl_lgc_tp <> 'NB')) 
                  ;  
                   
                  v_modi_knt := v_modi_knt + SQL%ROWCOUNT;  
                
                   IF SQL%ROWCOUNT > 0  
                   THEN  
                      v_map_cd := 'Y';  
                   ELSE      
                      v_map_cd := 'N'; -- > CNTC 배부 처리로 전환. 
                       
                      UPDATE lea_act_cost_if 
                      SET inter_prc_aply_flg = 'Y' , 
                          act_vvd_cd = '' -- User Manual Column으로 사용 
                      WHERE ROWID = c.rid  
                      ; 
                       
                   END IF;  
               
    
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
  
--            dbms_output.put_line('v_map_cd ' ||v_map_cd);  
--            dbms_output.put_line ('ROWID ' || c.rid);  
              
            UPDATE lea_act_cost_if  
               SET act_cost_mapg_cd = CASE WHEN v_map_cd = 'E' AND c.upln_so_flg = 'Y'  
                                            THEN 'S' 
                                           ELSE v_map_cd 
                                      END , 
                   bat_st_dt = SYSDATE,  
                   cntr_mapg_expt_log = v_prc_tp, 
                   new_rev_yrmon = decode(c.bkg_no, v_n_bkg_no, null, v_n_rev_yrmon) , 
                   new_bkg_no = decode(c.bkg_no, v_n_bkg_no, null, v_n_bkg_no)                  
             WHERE ROWID = c.rid;  
  
            COMMIT;  
         EXCEPTION  
            WHEN NO_DATA_FOUND  
            THEN UPDATE lea_act_cost_if  
                   SET act_cost_mapg_cd = CASE WHEN v_map_cd = 'E' AND c.upln_so_flg = 'Y'  
                                                THEN 'S' 
                                               ELSE v_map_cd 
                                          END , 
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
                            NVL (v_bkg_no, ' '), 'XX', NVL (v_cntr_no, ' '),  
                            v_key.vsl_cd, v_key.skd_voy_no, v_key.skd_dir_cd, v_key.rev_dir_cd,  
                            c.cost_cd, c.n1st_nod_cd, NVL (v_sum_usd_cost, 0),  
                            v_lng_rtn, v_str_desc);  
  
               COMMIT;  
         END;  
      END LOOP;  
   ELSIF v_key.mapg_prt_lvl = '4'  
   THEN  
      lea_log_prc ('PRT_LEVEL : ' || v_key.mapg_prt_lvl || '<CNTC ALLOCATE>');  
  
      FOR d IN (SELECT a.exe_yrmon exe_yrmon, a.rev_yrmon rev_yrmon,  
                       a.coa_cost_src_cd cost_cd, b.accl_lgc_tp_cd accl_lgc_tp,  
                       CASE WHEN a.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' )   
                                THEN a.n1st_nod_cd 
                            ELSE SUBSTR(a.n1st_nod_cd , 1, 5) 
                       END n1st_nod_cd,  
                       sum(a.usd_cost_amt) sum_usd_cost, 
                       a.rtro_tml_inv_flg rtro_tml_inv_flg 
                  FROM lea_act_cost_if a, lea_lgs_cost b  
                 WHERE a.exe_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon  
                   AND a.rev_yrmon BETWEEN CASE WHEN SUBSTR(v_key.exe_yrmon, 5 ,2 ) IN ('01','02','03') 
                                                    THEN to_char(add_months(to_date(v_key.exe_yrmon, 'yyyymm'), -3), 'yyyymm')  
                                                ELSE SUBSTR(v_key.exe_yrmon,  1, 4) || '01' 
                                           END 
                                   AND v_key.exe_yrmon 
--                   AND a.rev_yrmon BETWEEN SUBSTR (v_key.exe_yrmon, 1, 4) AND v_key.exe_yrmon  
                   AND (substr(a.act_vvd_cd , 1, 4) = 'CNTC'  or a.act_vvd_cd is null) 
                   AND a.act_cost_mapg_cd = 'N'  
                   AND a.otr_crr_flg = 'N'  
                   AND b.accl_auto_cd = 'A'  
                   AND b.estm_cost_flg = 'Y'  
                   AND b.accl_flg = 'Y'  
                   AND b.delt_flg = 'N'  
                   AND a.coa_cost_src_cd = v_key.coa_cost_src_cd  
                   AND a.n1st_nod_cd like v_key.n1st_nod_cd||'%' 
                   AND a.coa_cost_src_cd = b.coa_cost_src_cd  
--                   AND a.acct_cd = b.acct_cd 
                   GROUP BY a.exe_yrmon , a.rev_yrmon ,  
                       a.coa_cost_src_cd , b.accl_lgc_tp_cd ,  
                       CASE WHEN a.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' )   
                                THEN a.n1st_nod_cd 
                            ELSE SUBSTR(a.n1st_nod_cd , 1, 5) 
                       END, a.rtro_tml_inv_flg )  
      LOOP  
         BEGIN  
            SAVEPOINT savept;  
            v_map_cd := 'N';  
            sql_cnt := 0;  
            -- Insert into LEA_ERR_LOG  
            v_exe_yrmon := '';  
            v_rev_yrmon := '';  
            v_sum_usd_cost := 0;  
            v_exe_yrmon := d.exe_yrmon;  
            v_rev_yrmon := d.rev_yrmon;  
            v_sum_usd_cost := d.sum_usd_cost;  
  
            IF d.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' ) THEN --전용터미널중 3개 
             
               UPDATE /*+ index (lea_accl_dtl xak2lea_accl_dtl) */ lea_accl_dtl   
               SET  (act_com_vvd_cost_amt, act_cost_amt , lst_act_com_vvd_amt , ttl_inv_knt, act_inv_knt ) =  
                      (SELECT ROUND (act_com_vvd_cost_amt  
                                     + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * d.sum_usd_cost)), 13 ),  
                              ROUND (act_cost_amt + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * d.sum_usd_cost)), 13), 
                              ROUND (lst_act_com_vvd_amt  
                                     + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * d.sum_usd_cost)), 13 ) , 
                              CASE  
                                WHEN ROUND (act_com_vvd_cost_amt  
                                            + decode(x.estm_sum , null, 0, (cntr_qty / x.estm_sum * d.sum_usd_cost)), 13 ) <> 0  
                                AND d.accl_lgc_tp = 'NB' 
                                    THEN 1 
                                ELSE ttl_inv_knt 
                              END, 
                              CASE  
                                WHEN ROUND (act_com_vvd_cost_amt  
                                            + decode(x.estm_sum, null, 0 , (cntr_qty / x.estm_sum * d.sum_usd_cost)), 13 ) <> 0  
                                AND d.accl_lgc_tp = 'NB' 
                                    THEN 1 
                                ELSE act_inv_knt 
                              END 
                         FROM (SELECT /*+ index (lea_accl_dtl xak2lea_accl_dtl) */ SUM (cntr_qty) estm_sum  
                                 FROM lea_accl_dtl  
                                WHERE rev_yrmon = d.rev_yrmon  
                                  AND coa_cost_src_cd = d.cost_cd 
                                  AND cost_act_grp_cd IN (  SELECT CASE WHEN  d.cost_cd = 'SVLDFL' THEN 'NOBT' END FROM DUAL 
                                                            UNION ALL 
                                                            SELECT CASE WHEN  d.cost_cd = 'SVLDFL' THEN 'NIBT' END FROM DUAL 
                                                            UNION ALL 
                                                            SELECT CASE WHEN  d.cost_cd = 'SVLDTS' THEN 'NTST' END FROM DUAL  
                                                            UNION ALL 
                                                            SELECT CASE WHEN  d.cost_cd NOT IN ('SVLDFL','SVLDTS') THEN cost_act_grp_cd END FROM DUAL ) 
                                  AND n1st_nod_cd  = d.n1st_nod_cd  
                                  AND mapg_aloc_flg = 'Y' 
                                  AND cntr_qty > 0  
                                  AND act_cntr_cost_amt = DECODE(d.rtro_tml_inv_flg, 'Y', act_cntr_cost_amt , 0 )  
                                     ) x),  
                    accl_calc_flg = 'Y',  
                    lst_act_upd_dt = sysdate 
                WHERE rev_yrmon = d.rev_yrmon  
                AND coa_cost_src_cd = d.cost_cd 
                AND cost_act_grp_cd IN (SELECT CASE WHEN  d.cost_cd = 'SVLDFL' THEN 'NOBT' END FROM DUAL 
                                        UNION ALL 
                                        SELECT CASE WHEN  d.cost_cd = 'SVLDFL' THEN 'NIBT' END FROM DUAL 
                                        UNION ALL 
                                        SELECT CASE WHEN  d.cost_cd = 'SVLDTS' THEN 'NTST' END FROM DUAL  
                                        UNION ALL 
                                        SELECT CASE WHEN  d.cost_cd NOT IN ('SVLDFL','SVLDTS') THEN cost_act_grp_cd END FROM DUAL )   
                AND n1st_nod_cd  = d.n1st_nod_cd 
                AND cntr_qty > 0  
                AND act_cntr_cost_amt = DECODE(d.rtro_tml_inv_flg, 'Y', act_cntr_cost_amt , 0 ) 
                AND mapg_aloc_flg = 'Y' 
                ;  
                
           ELSE 
              
                UPDATE /*+ index (lea_accl_dtl xak2lea_accl_dtl) */ lea_accl_dtl    
                SET (act_com_vvd_cost_amt, act_cost_amt , lst_act_com_vvd_amt ) =  
                      (SELECT ROUND (act_com_vvd_cost_amt  
                                     + DECODE(x.estm_sum , null, 0, ( DECODE(coa_cost_src_cd ,  'TMNDRF' , estm_cost_amt ,  cntr_qty ) / x.estm_sum * d.sum_usd_cost)), 13 ),  
                              ROUND (act_cost_amt + DECODE(x.estm_sum , null, 0, (DECODE(coa_cost_src_cd ,  'TMNDRF' , estm_cost_amt ,  cntr_qty ) / x.estm_sum * d.sum_usd_cost)), 13), 
                              ROUND (lst_act_com_vvd_amt  
                                     + DECODE (x.estm_sum , null, 0, ( DECODE(coa_cost_src_cd ,  'TMNDRF' , estm_cost_amt ,  cntr_qty ) / x.estm_sum * d.sum_usd_cost)), 13 )  
                         FROM (SELECT /*+ index (lea_accl_dtl xak2lea_accl_dtl) */  
                                      DECODE( coa_cost_src_cd ,  'TMNDRF' , SUM(estm_cost_amt) ,  SUM(cntr_qty) ) estm_sum 
                                 FROM lea_accl_dtl  
                                WHERE rev_yrmon = d.rev_yrmon  
                                  AND coa_cost_src_cd = d.cost_cd                        
                                  AND n1st_nod_cd  like d.n1st_nod_cd||'%'  
                                  AND DECODE(accl_lgc_tp_cd,'NO', 0 , DECODE(n1st_nod_cd,'KRPUSYK',1,'KRPUSYG',1,'KRKANY4',1, 0 )) = 0 
                                  AND mapg_aloc_flg = 'Y' 
                                  AND DECODE(coa_cost_src_cd ,  'TMNDRF' , estm_cost_amt ,  cntr_qty ) > 0 
                                  AND act_cntr_cost_amt = DECODE(d.rtro_tml_inv_flg, 'Y', act_cntr_cost_amt , 0 ) 
                                  GROUP BY coa_cost_src_cd 
                                        ) x),  
                    accl_calc_flg = 'Y',  
                    lst_act_upd_dt = sysdate 
                WHERE rev_yrmon = d.rev_yrmon  
                AND coa_cost_src_cd = d.cost_cd  
                AND n1st_nod_cd  like d.n1st_nod_cd||'%'  
                AND DECODE(accl_lgc_tp_cd,'NO', 0 , DECODE(n1st_nod_cd,'KRPUSYK',1,'KRPUSYG',1,'KRKANY4',1, 0 )) = 0 
                AND DECODE(coa_cost_src_cd ,  'TMNDRF' , estm_cost_amt ,  cntr_qty ) > 0 
                AND act_cntr_cost_amt = DECODE(d.rtro_tml_inv_flg, 'Y', act_cntr_cost_amt , 0 ) 
                AND mapg_aloc_flg = 'Y' 
                ;  
                 
            END IF; 
  
            v_modi_knt := v_modi_knt + SQL%ROWCOUNT;  
  
            IF SQL%ROWCOUNT > 0  
            THEN  
               v_map_cd := 'Y';  
            ELSE  
               v_map_cd := 'C';  
            END IF;  
 
            MERGE INTO lea_act_cost_if c 
            USING (SELECT a.rowid rid FROM  lea_act_cost_if a, lea_lgs_cost b 
                       WHERE a.exe_yrmon = v_exe_yrmon  
                       AND a.rev_yrmon = v_rev_yrmon  
                       AND (substr(a.act_vvd_cd , 1, 4) = 'CNTC'  or a.act_vvd_cd is null)  
                       AND a.act_cost_mapg_cd = 'N'  
                       AND a.otr_crr_flg = 'N'  
                       AND b.accl_auto_cd = 'A'  
                       AND b.estm_cost_flg = 'Y'  
                       AND b.accl_flg = 'Y'  
                       AND b.delt_flg = 'N'  
                       AND a.coa_cost_src_cd = d.cost_cd 
                       AND a.n1st_nod_cd like CASE WHEN d.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' )   
                                                    THEN d.n1st_nod_cd 
                                                   ELSE SUBSTR(d.n1st_nod_cd , 1, 5)||'%' 
                                              END 
                       AND a.rtro_tml_inv_flg = d.rtro_tml_inv_flg 
                       AND a.coa_cost_src_cd = b.coa_cost_src_cd  
--                       AND a.acct_cd = b.acct_cd 
                       ) e 
            ON (c.rowid = e.rid) 
            WHEN MATCHED THEN 
            UPDATE SET act_cost_mapg_cd = v_map_cd,  
                       bat_st_dt = SYSDATE,  
                       cntr_mapg_expt_log = 'CNTC_ALLOC'  
            ; 
  
            COMMIT;  
             
         EXCEPTION  
            WHEN OTHERS  
            THEN  
               v_lng_rtn := TO_CHAR (SQLCODE);  
               v_str_desc := SUBSTR (SQLERRM, 1, 100);  
               ROLLBACK TO savept;  
  
               INSERT INTO lea_err_log  
                    VALUES (v_exe_yrmon, v_key.par_prt_seq, v_key.mapg_prt_lvl, ' ', ' ', ' ',  
                            v_key.vsl_cd, v_key.skd_voy_no, v_key.skd_dir_cd, v_key.rev_dir_cd,   
                            d.cost_cd, d.n1st_nod_cd, NVL (v_sum_usd_cost, 0),  
                            v_lng_rtn, v_str_desc);  
  
               COMMIT;  
         END;  
      END LOOP;  
   
   ELSE  
    NULL; 
            
   END IF;  
  
   -- 작업 성공으로 표시  
   UPDATE lea_bat_par_prt  
      SET par_prt_sts_cd = 'Y',  
          end_tms = SYSTIMESTAMP,  
          modi_row_knt = v_modi_knt  
    WHERE prc_nm = prc_nm_in AND par_prt_seq = par_prt_seq_in;  
  
   COMMIT;  
    
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