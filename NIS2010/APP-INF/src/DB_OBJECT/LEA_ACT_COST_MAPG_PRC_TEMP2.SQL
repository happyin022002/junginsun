CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACT_COST_MAPG_PRC_TEMP2                                                                                                                           
IS                                                                                                                                                                                       
/*                                                                                                                                                                                       
    1.Object Name      : LEA_ACT_COST_MAPG_PRC_TEMP1                                                                                                                                     
    2.Version          : 1.0                                                                                                                                                             
    3.Create Date      : 2007-03-26                                                                                                                                                      
    4.Sub System       : Logistics Expense Accrual                                                                                                                                       
    5.Author           : 전재홍                                                                                                                                                          
    6.Description      : 결산 수행시 매핑/배부 Unmatching 에러에 대해 User Manual 작업후                                                                                                 
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
     2010-04-09 : - BKG_NO_SPLIT 제거                                                                                                                                                    
                                                                                                                                                                                         
                                                                                                                                                                                         
                                                                                                                                                                                         
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
   v_v_cnt          NUMBER(18) := 0 ;                                                                                                                                                    
                                                                                                                                                                                         
   v_cntr_qty       NUMBER (8,2)                := 0;                                                                                                                                    
                                                                                                                                                                                         
   v_act_vvd_cnt    NUMBER (5) := 0;                                                                                                                                                     
                                                                                                                                                                                         
   v_msg              VARCHAR2 (1024);                                                                                                                                                   
                                                                                                                                                                                         
   v_xx_cnt NUMBER (1);                                                                                                                                                                  
   v_g_cnt NUMBER (2); -- Activity Grp Code  Exception                                                                                                                                   
BEGIN                                                                                                                                                                                    
                                                                                                                                                                                         
      FOR d IN (SELECT a.exe_yrmon exe_yrmon, a.rev_yrmon rev_yrmon,                                                                                                                     
                       a.coa_cost_src_cd cost_cd, b.accl_lgc_tp_cd accl_lgc_tp,                                                                                                          
                       CASE WHEN a.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' )                                                                                                   
                                THEN a.n1st_nod_cd                                                                                                                                       
                            ELSE SUBSTR(a.n1st_nod_cd , 1, 5)                                                                                                                            
                       END n1st_nod_cd,                                                                                                                                                  
                       sum(a.usd_cost_amt) sum_usd_cost,                                                                                                                                 
                       a.rtro_tml_inv_flg rtro_tml_inv_flg                                                                                                                               
                  FROM lea_act_cost_if a, lea_lgs_cost b                                                                                                                                 
                 WHERE a.exe_yrmon BETWEEN '201012' AND '201103'                                                                                                    
                    AND a.rev_yrmon >= '201012'                                                                                                                                          
                                                                                                                                                                                         
                                                                                                                                                                                         
                   AND (substr(a.act_vvd_cd , 1, 4) = 'CNTC'  or a.act_vvd_cd is null)                                                                                                   
                                                                                                                                                                                         
                   AND a.act_cost_mapg_cd = 'C'                                                                                                                                          
                   AND a.inter_prc_aply_flg = 'Y'                                                                                                                                        
                                                                                                                                                                                         
                   AND a.otr_crr_flg = 'N'                                                                                                                                               
                   AND b.accl_auto_cd = 'A'                                                                                                                                              
                   AND b.estm_cost_flg = 'Y'                                                                                                                                             
                   AND b.accl_flg = 'Y'                                                                                                                                                  
                   AND b.delt_flg = 'N'                                                                                                                                                  
                                                                                                                                                                                         
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
                                                                                                                                                                                         
            /*****중요(조건절과 위의 대상조건이 동일해야함.**/                                                                                                                           
            MERGE INTO lea_act_cost_if c                                                                                                                                                 
            USING (SELECT a.rowid rid FROM  lea_act_cost_if a, lea_lgs_cost b                                                                                                            
                       WHERE a.exe_yrmon = v_exe_yrmon                                                                                                                                   
                       AND a.rev_yrmon = v_rev_yrmon                                                                                                                                     
                       AND (substr(a.act_vvd_cd , 1, 4) = 'CNTC'  or a.act_vvd_cd is null)                                                                                               
                                                                                                                                                                                         
                       AND a.act_cost_mapg_cd = 'C'                                                                                                                                      
                       AND a.inter_prc_aply_flg = 'Y'                                                                                                                                    
                                                                                                                                                                                         
                                                                                                                                                                                         
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
                                                                                                                                                                                         
                                                                                                                                                                                         
         END;                                                                                                                                                                            
      END LOOP;                                                                                                                                                                          
                                                                                                                                                                                         
EXCEPTION                                                                                                                                                                                
   WHEN OTHERS                                                                                                                                                                           
   THEN                                                                                                                                                                                  
      v_lng_rtn := TO_CHAR (SQLCODE);                                                                                                                                                    
      v_str_desc := SUBSTR (SQLERRM, 1, 100);                                                                                                                                            
                                                                                                                                                                                         
END;