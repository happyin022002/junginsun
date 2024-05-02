CREATE OR REPLACE PROCEDURE LEAADM.LEA_CSR_MNTR_PRC(exe_yrmon_in IN VARCHAR, tmp_yrmon_in IN VARCHAR)
IS
 
/*   
  1. Name : LEA_CSR_MNTR_PRC   
  2. Create Date : 2007-11-12   
  3. Description :   
     - Uses       : Actual Data(From TES, TRS) Data 를 Estimation Data 에 mapping
     - Remarks   
       (1) ...   
  4. Revision History   
     2007-11-12 : 전재홍 - 최초 생성  
     2007-11-26 : ORDER BY GL_DT DESC 추가  
     2007-11-28 : ENIS cre_dt (lea_act_cost_if.cre_dt) 추가 및 I/F DATE ORDER BY 로 변경
     2007-11-29 : Office Code 가 SELTOB, SELCOL 일경우 Invoice Office hard-coding.
     2007-12-03 : Cost Code Error 시 대체 Cost Code 적용 추가
     2007-12-04 : BKG 개별 SEARCH 대신 CNTR BKG HISTORY 참조한 BKG 정보(ETL작업시 처리) 로 로직 변경
     2008-01-02 : NO BKG 시 v_n_bkg_no -> NVL(v_n_bkg_no, c.bkg_no) 로 변경
     2008-02-11 : 내부 거래 코드 변환 관련 삭제
     2010-04-09 : BKG_NO_SPLIT 제거
*/   

   v_map_cd           VARCHAR2 (1)              := 'N'; 
   v_tp_ttl_inv_knt   NUMBER                    := 0; 
   v_map_cnt          NUMBER                    := 0; 
   sql_cnt            NUMBER                    := 0; 
   
--   v_c_cnt            NUMBER (18)               := 0;  -- Combine
--   v_c_rev_yrmon      VARCHAR2 (6)              := ''; 
--   v_c_bkg_no         VARCHAR2 (13)             := ''; 
--   v_c_bkg_no_split   VARCHAR2 (2)              := ''; 
--   v_c_vsl_cd         VARCHAR2 (4)              := ''; 
--   v_c_skd_voy_no     VARCHAR2 (4)              := ''; 
--   v_c_skd_dir_cd     VARCHAR2 (1)              := ''; 
--   v_c_rev_dir_cd     VARCHAR2 (1)              := ''; 
--   v_c_cost_cd        VARCHAR2 (8)              := ''; 
--   
--   v_s_cnt            NUMBER (18)               := 0; -- Original or Split
--   v_s_rev_yrmon      VARCHAR2 (6)              := ''; 
--   v_s_bkg_no         VARCHAR2 (13)             := ''; 
--   v_s_bkg_no_split   VARCHAR2 (2)              := ''; 
--   v_s_vsl_cd         VARCHAR2 (4)              := ''; 
--   v_s_skd_voy_no     VARCHAR2 (4)              := ''; 
--   v_s_skd_dir_cd     VARCHAR2 (1)              := ''; 
--   v_s_rev_dir_cd     VARCHAR2 (1)              := ''; 
--   v_s_cost_cd        VARCHAR2 (8)              := '';
   
   v_sum_cntr_qty       NUMBER (8,2)    := 0;
   v_aloc_cntr_amt      NUMBER (25,13)  := 0;

   v_cntr_qty       NUMBER (8,2)    := 0;
    
   v_no_bkg     NUMBER (2) := 0;
   v_nd_err     NUMBER (2) := 0;
   v_tpsz_err   NUMBER (2) := 0;
   v_ag_err     NUMBER (2) := 0;
   v_cost_err   NUMBER (2) := 0;
   v_vvd_err    NUMBER (2) := 0;
   v_exe_yrmon        VARCHAR2 (6)  := ''; 
   v_inv_sys_id       VARCHAR2 (3)  := ''; 
   v_if_seq        NUMBER (9)   := 0; 
   v_tmp_yrmon  VARCHAR2(6) := '';
   
   v_n_bkg_no   VARCHAR2(13);
   v_n_bkg_no_split VARCHAR2(2);
   v_bkg_cnt NUMBER(2);
   
   v_prc_tp           VARCHAR2 (30)             := ''; 
   v_lng_rtn          VARCHAR2 (100)            := ''; 
   v_str_desc         VARCHAR2 (600)            := ''; 

BEGIN 
    
--    v_exe_yrmon := '200809';
--    v_tmp_yrmon := '200808';

    v_exe_yrmon := exe_yrmon_in;
    v_tmp_yrmon := tmp_yrmon_in;
    
    DELETE lea_csr_mntr
    WHERE exe_yrmon = v_exe_yrmon;   
    COMMIT;
       
    SAVEPOINT savept1; 

--    dbms_output.put_line('EXE_YRMON : '||v_exe_yrmon);
    
--    merge /*+ use_nl(COST_CD ACT) */   
--    into lea_act_cost_if ACT   
--    using (   
--        select  /*+ parallel(a) use_hash(a,b) */   
--               a.rowid rid, b.inter_prc_cd, b.inter_prc_acct_cd   
--        from  lea_act_cost_if a, lea_lgs_cost b   
--        where b.inter_prc_cd is not null   
--        and b.accl_flg = 'Y'   
--        and b.accl_auto_cd = 'A'   
--        and b.estm_cost_flg = 'Y'   
--        and b.delt_flg = 'N' 
--        and a.otr_crr_flg = 'N'  
--        and a.coa_cost_src_cd = b.coa_cost_src_cd   
--        and a.exe_yrmon = v_exe_yrmon
----        and a.cre_dt between to_date('131107','ddmmrr') and to_date('191107', 'ddmmrr') + 0.99999 
----        and a.cre_dt BETWEEN to_date(to_char(sysdate, 'ddmmrr'),'ddmmrr') AND
----                                to_date(to_char(sysdate, 'ddmmrr'),'ddmmrr') + 0.99999  
--        and a.act_cost_mapg_cd = 'N'   
--        and a.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' , 'KRPUSKC', 'JPTYOY1', 'JPOSAY1')   
--        and b.accl_lgc_tp_cd in ('NB','NO')    
--        order by rid ) COST_CD    
--    on (ACT.rowid = COST_CD.rid)   
--    when matched then   
--    update set  ACT.bkup_inter_cost_cd = ACT.coa_cost_src_cd   
--               ,ACT.bkup_inter_acct_cd = ACT.acct_cd   
--               ,ACT.coa_cost_src_cd = COST_CD.inter_prc_cd   
--               ,ACT.acct_cd = COST_CD.inter_prc_acct_cd   
--               ,ACT.inter_prc_aply_flg = 'Y'   
--               ,ACT.ttl_inv_knt = 1   
--               ;
--
--    commit;
    
    merge /*+ use_nl(b a) */   
    into lea_act_cost_if A   
    using (   
        select /*+ no_merge */   
            c.*,   
            round(c.locl_cost_amt / xch.usd_locl_xch_rt, 3) usd_amt   
        from (  select /*+ parallel(a) */    
                    a.rowid rid    
                    ,a.exe_yrmon   
                    ,a.locl_curr_cd   
                    ,a.locl_cost_amt   
                    ,a.usd_cost_amt   
                    ,a.rep_acct_cd   
                    ,a.ttl_inv_knt   
                    ,a.n3rd_nod_cd   
                    ,a.n4th_nod_cd
                    ,CASE WHEN (a.vsl_cd = 'CNTC' OR a.vsl_cd = 'CFDR') AND vvd.rev_yrmon is null
                            THEN '20'||a.skd_voy_no
                          ELSE
                            vvd.rev_yrmon
                     END vvd_rev_yrmon
--                    DECODE(a.vsl_cd, 'CNTC', a.exe_yrmon , vvd.rev_yrmon ) vvd_rev_yrmon     
                    ,v_tmp_yrmon xch_yrmon   
                    ,decode(a.otr_crr_flg, 'Y', cost_cd.otr_crr_rep_acct_cd , cost_cd.rep_acct_cd) cost_acct_cd   
                from    lea_act_cost_if a,   
                        (select exe_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, max(rev_yrmon) rev_yrmon   
                         from    gl_estm_rev_vvd   
                         where   estm_bc_div_cd in ('C', 'M')
                         and exe_yrmon = v_tmp_yrmon   
                         and estm_vvd_tp_cd in  ('RV','BV')   
                         group by exe_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd)  vvd,   
                        (select coa_cost_src_cd, otr_crr_rep_acct_cd, rep_acct_cd   
                         from lea_lgs_cost   
                         where delt_flg = 'N') cost_cd   
                where 1=1
--                and  cre_dt between to_date('131107','ddmmrr') and to_date('191107', 'ddmmrr') + 0.99999 
                --                and a.cre_dt BETWEEN to_date(to_char(sysdate, 'ddmmrr'),'ddmmrr') AND
--                                to_date(to_char(sysdate, 'ddmmrr'),'ddmmrr') + 0.99999   
--                and a.rev_yrmon is null
                and a.exe_yrmon = v_exe_yrmon
                and vvd.exe_yrmon(+) =  v_tmp_yrmon 
--                and a.exe_yrmon   =   vvd.exe_yrmon(+)   
                and a.vsl_cd      =   vvd.vsl_cd(+)   
                and a.skd_voy_no  =   vvd.skd_voy_no(+)   
                and a.skd_dir_cd  =   vvd.skd_dir_cd(+)   
                and a.rev_dir_cd  =   vvd.rev_dir_cd(+)   
                and a.coa_cost_src_cd =   cost_cd.coa_cost_src_cd(+)    
            )   c,   
            (select acct_xch_rt_yrmon, curr_cd, usd_locl_xch_rt   
            from gl_mon_xch_rt   
            where acct_xch_rt_lvl = '3' -- Monthly Exchange Rate   
            and delt_flg = 'N'    
            )   xch   
        where c.xch_yrmon = xch.acct_xch_rt_yrmon(+)   
        and   c.locl_curr_cd = xch.curr_cd(+)   
        order by c.RID   
        )   B   
    on (A.rowid = B.rid   
--        and A.act_cost_mapg_cd = 'N'   
--        and A.exe_yrmon between substr(v_exe_yrmon, 1, 4) and v_exe_yrmon   
        )   
    when matched then   
        update set  A.rev_yrmon = vvd_rev_yrmon,   
                    A.rep_acct_cd = cost_acct_cd,   
                    A.act_vvd_cd = substr(a.act_vvd_cd,1,9),
                    A.usd_cost_amt = usd_amt,   
                    /* null -> ' ' 로 변경 (30Jul07) */   
                    A.n3rd_nod_cd = decode(A.n3rd_nod_cd ,  null, ' ' , decode(A.inv_sys_id , 'TES', ' ', A.n3rd_nod_cd)),   
                    A.n4th_nod_cd = decode(A.n4th_nod_cd ,  null, ' ' , decode(A.inv_sys_id , 'TES', ' ', A.n4th_nod_cd)), 
                    A.ttl_inv_knt = decode(A.coa_cost_src_cd, 'TMNDTS' , 2 , A.ttl_inv_knt )           
                    ; 

    COMMIT;                
         

    FOR c IN ( 
        SELECT  a.exe_yrmon exe_yrmon, a.inv_sys_id inv_sys_id, a.if_seq if_seq , a.gl_dt gl_dt,
                a.csr_no csr_no, 
                decode(substr(a.csr_no, 4, 6) , 'SELTOB', 'SELTOB', 'SELCOL', 'SELCOL', substr(a.csr_no, 4, 5))inv_ofc,
                a.rev_yrmon  rev_yrmon, a.bkg_no bkg_no, 
                a.cntr_no cntr_no, a.cntr_tpsz_cd cntr_tpsz_cd, 
                a.cost_act_grp_cd cost_act_grp_cd, a.cost_act_grp_seq cost_act_grp_seq, 
                a.coa_cost_src_cd coa_cost_src_cd, 
                NVL (a.n1st_thrp_incl_cost_cd, ' ') n1st_thrp_cost_cd, 
                NVL (a.n2nd_thrp_incl_cost_cd, ' ') n2nd_thrp_cost_cd, 
                NVL (a.n3rd_thrp_incl_cost_cd, ' ') n3rd_thrp_cost_cd, 
                a.vsl_cd vsl_cd, a.skd_voy_no skd_voy_no, a.skd_dir_cd skd_dir_cd, a.rev_dir_cd rev_dir_cd, 
                a.acct_cd acct_cd, a.n1st_nod_cd n1st_nod_cd, a.n2nd_nod_cd n2nd_nod_cd, 
                a.n3rd_nod_cd n3rd_nod_cd, a.n4th_nod_cd n4th_nod_cd, 
                CASE 
                  WHEN a.cntr_no IS NOT NULL 
                  AND a.bkg_no IS NOT NULL 
                  AND a.vsl_cd <> 'CNTC' 
                     THEN 1 
                  WHEN a.bkg_no IS NOT NULL AND a.vsl_cd <> 'CNTC' 
                     THEN 2 
                  WHEN a.vsl_cd <> 'CNTC' 
                     THEN 3 
                  WHEN a.vsl_cd = 'CNTC'
                     THEN 4
                  ELSE 5 
                END act_cost_type, 
                a.inv_no inv_no,
                a.usd_cost_amt sum_usd_cost, 
                b.accl_lgc_tp_cd accl_lgc_tp,
                a.cre_dt cre_dt
        FROM lea_act_cost_if a, lea_lgs_cost b 
        WHERE 1=1
        AND a.exe_yrmon = v_exe_yrmon      
        AND a.otr_crr_flg = 'N' 
        AND a.act_cost_mapg_cd = 'N'       
        AND b.accl_auto_cd = 'A' 
        AND b.estm_cost_flg = 'Y' 
        AND b.accl_flg = 'Y' 
        AND b.delt_flg = 'N' 
        AND a.n1st_nod_cd is not null -- index 존재함.
        AND a.usd_cost_amt <> 0
        AND a.coa_cost_src_cd = b.coa_cost_src_cd 
        AND a.acct_cd = b.acct_cd 
        ORDER BY a.cre_dt DESC )
            
      LOOP 
         BEGIN
         
--            DELETE lea_csr_mntr
--            WHERE exe_yrmon = c.exe_yrmon
--            AND inv_sys_id = c.inv_sys_id
--            AND if_seq = c.if_seq ; 
--            COMMIT;

            SAVEPOINT savept; 
            
            v_map_cd := 'N'; 
            sql_cnt := 0; 
            -- Insert into LEA_ERR_LOG 

            v_exe_yrmon := c.exe_yrmon; 
            v_inv_sys_id := c.inv_sys_id; 
            v_if_seq := c.if_seq; 

            v_prc_tp := ''; 
--            v_c_rev_yrmon := ''; 
--            v_c_bkg_no := ''; 
--            v_c_bkg_no_split := ''; 
--            v_c_vsl_cd := ''; 
--            v_c_skd_voy_no := ''; 
--            v_c_skd_dir_cd := ''; 
--            v_c_rev_dir_cd := ''; 
--            v_c_cost_cd := ''; 
--            v_s_rev_yrmon := ''; 
--            v_s_bkg_no := ''; 
--            v_s_bkg_no_split := ''; 
--            v_s_vsl_cd := ''; 
--            v_s_skd_voy_no := ''; 
--            v_s_skd_dir_cd := ''; 
--            v_s_rev_dir_cd := ''; 
--            v_s_cost_cd := ''; 
--            v_s_cnt := 0; 
--            v_c_cnt := 0; 
            
            v_sum_cntr_qty := 0;
            v_aloc_cntr_amt := 0;
             
            v_cntr_qty      := 0;
            
            v_no_bkg      := 0;
            v_nd_err      := 0;
            v_tpsz_err    := 0;
            v_ag_err      := 0;
            v_cost_err   := 0;
            v_vvd_err    := 0;
            
            v_n_bkg_no   := '';
            v_n_bkg_no_split  := '';
            v_bkg_cnt := 0 ;
                                             
            IF c.act_cost_type = '1' THEN 
            
--                  <CNTR-BKG Exception Case Check> 
                SELECT /*+ FIRST_ROWS */ COUNT(1) INTO v_bkg_cnt FROM lea_estm_cost_if
                WHERE bkg_no = c.bkg_no
                AND cntr_no = c.cntr_no
                AND bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                AND delt_flg = 'N' 
                AND ROWNUM = 1
                ;
                
                IF v_bkg_cnt = 0 THEN
                    BEGIN 
                        SELECT   bkg_no
                        INTO  v_n_bkg_no FROM LEA_CNTR_BKG_HIS
                        WHERE BKG_HIS_SEQ = (SELECT MIN(SEQ) FROM 
                                                (SELECT MIN(BKG_HIS_SEQ) SEQ FROM LEA_CNTR_BKG_HIS
                                                WHERE BKG_HIS_SEQ >= (  SELECT BKG_HIS_SEQ FROM LEA_CNTR_BKG_HIS
                                                                        WHERE BKG_NO = c.bkg_no
                                                                        AND CNTR_NO = c.cntr_no)
                                                AND  CNTR_NO =c.cntr_no
                                                AND  COP_STS_CD = 'F' 
                                                UNION 
                                                SELECT MAX(BKG_HIS_SEQ) FROM LEA_CNTR_BKG_HIS
                                                WHERE BKG_HIS_SEQ >= (  SELECT BKG_HIS_SEQ FROM LEA_CNTR_BKG_HIS
                                                                        WHERE BKG_NO =c.bkg_no
                                                                        AND CNTR_NO = c.cntr_no)
                                            AND CNTR_NO = c.cntr_no))
                        AND CNTR_NO = c.cntr_no;
                        
                    EXCEPTION                        
                        WHEN OTHERS 
                        THEN 
                           v_lng_rtn := TO_CHAR (SQLCODE); 
                           v_str_desc := SUBSTR (SQLERRM, 1, 100);
                           /* 'E' error 로 처리됨('BK') */
--                           dbms_output.put_line ('E error : '||v_exe_yrmon ||' '||v_if_seq||' '||v_lng_rtn||' '||v_str_desc);
                    END;
              
                ELSE 
                    v_n_bkg_no := c.bkg_no;
                END IF;    

                SELECT COUNT (*) , nvl(sum(cntr_qty), 0)
                INTO v_map_cnt , v_cntr_qty
                FROM lea_estm_cost_if e , lea_lgs_cost b
                WHERE 1 = 1 
--                AND e.rev_yrmon = NVL(c.rev_yrmon, e.rev_yrmon) 
                AND e.bkg_no = v_n_bkg_no 
                AND e.cntr_no = c.cntr_no 
                AND NVL (e.cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (e.cntr_tpsz_cd, ' '))
                AND e.cost_act_grp_cd = NVL (c.cost_act_grp_cd, e.cost_act_grp_cd) 
--                AND e.cost_act_grp_seq = NVL (c.cost_act_grp_seq, e.cost_act_grp_seq)
                AND e.coa_cost_src_cd = c.coa_cost_src_cd 
                AND e.coa_cost_src_cd = b.coa_cost_src_cd
--                AND e.acct_cd = c.acct_cd 
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd 
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no                 
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd
                AND e.n1st_nod_cd  =  CASE 
                                        WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'OD'
                                            THEN e.n1st_nod_cd
                                        ELSE c.n1st_nod_cd
                                      END
                AND NVL (e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                AND NVL (e.n3rd_nod_cd, ' ') =    CASE 
                                                    WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
                                                    AND NVL (e.n4th_nod_cd, ' ')  = ' '
                                                        THEN  NVL (e.n3rd_nod_cd, ' ')
                                                    ELSE c.n3rd_nod_cd
                                                END
                AND NVL (e.n4th_nod_cd, ' ') =    CASE 
                                                    WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
                                                        THEN NVL (e.n4th_nod_cd, ' ')
                                                    ELSE c.n4th_nod_cd
                                                END
                AND e.delt_flg = 'N'
                AND e.skd_voy_no IS NOT NULL --
--                AND e.thrp_rt_flg = 'N'
                AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                AND (e.cost_act_grp_cd , e.coa_cost_src_cd) NOT IN    (('NIBC', 'TMNDFL'), 
                                                                    ('NIBC', 'TMFDFL'), 
                                                                    ('NOBC', 'TMNDFL'),
                                                                    ('NOBC', 'TMFDFL'))        
                ;
                 
                  
                IF v_map_cnt = 1 and v_cntr_qty = 1 THEN 
                    v_prc_tp := 'CNTR'; 
                ELSIF v_map_cnt = 1 and v_cntr_qty < 1 THEN
                    v_prc_tp := 'CNTR_P'; 
                ELSIF v_map_cnt = 0 THEN                                
                    v_prc_tp := 'CNTR_MAP_ERR_CASE';     
                ELSE
                    v_prc_tp := 'CNTR_MAP_CNT_OVER';      
                END IF;
               
            ELSIF c.act_cost_type = '2' THEN
                v_prc_tp := 'BKG';
            ELSIF c.act_cost_type = '3' THEN
                v_prc_tp := 'RVVD';
            ELSIF c.act_cost_type = '4' THEN
                v_prc_tp := 'CNTC';
            ELSE 
               v_prc_tp := 'ACT_COST_TYPE_4';
            END IF; 


 
            IF v_prc_tp = 'CNTR' or v_prc_tp = 'CNTR_P' THEN

                SELECT  NVL(SUM(e.cntr_qty),0) INTO v_sum_cntr_qty
                FROM    lea_estm_cost_if e
                WHERE   1=1
--                AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon)
                AND e.bkg_no = v_n_bkg_no
                AND e.cntr_no = c.cntr_no 
                AND NVL (e.cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (e.cntr_tpsz_cd, ' ')) 
                AND e.cost_act_grp_cd = NVL (c.cost_act_grp_cd, e.cost_act_grp_cd) 
--                AND e.cost_act_grp_seq = NVL (c.cost_act_grp_seq, e.cost_act_grp_seq) 
                AND e.coa_cost_src_cd = c.coa_cost_src_cd 
--                AND e.acct_cd = c.acct_cd 
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd 
                AND e.n1st_nod_cd = CASE WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'OD'
                                            THEN e.n1st_nod_cd
                                        ELSE c.n1st_nod_cd
                                    END
                AND NVL (e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                AND NVL (e.n3rd_nod_cd, ' ') = CASE WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
                                                    AND NVL (e.n4th_nod_cd, ' ')  = ' '
                                                        THEN  NVL (e.n3rd_nod_cd, ' ')
                                                    ELSE c.n3rd_nod_cd
                                                END
                AND NVL (e.n4th_nod_cd, ' ') = CASE WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
                                                        THEN NVL (e.n4th_nod_cd, ' ')
                                                    ELSE c.n4th_nod_cd
                                               END
                AND e.delt_flg = 'N'
                AND e.skd_voy_no IS NOT NULL
--                AND e.thrp_rt_flg = 'N'
                AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                    ('NIBC', 'TMFDFL'), 
                                                                    ('NOBC', 'TMNDFL'),
                                                                    ('NOBC', 'TMFDFL')) ;


                IF v_sum_cntr_qty <= 0 THEN

--                    INSERT INTO lea_csr_mntr m
--                    (SELECT c.exe_yrmon                 ,       
--                            c.inv_sys_id                ,     	
--                            c.if_seq                    ,     	
--                            c.gl_dt                     ,     	
--                            c.csr_no csr_no             ,     	
--                            c.inv_no inv_no             ,     	
--                            c.inv_ofc                   ,     	
--                            c.rev_yrmon                 ,     	
--                            c.vsl_cd 					,		
--                            c.skd_voy_no 				,		
--                            c.skd_dir_cd 				,		
--                            c.rev_dir_cd    			,		
--                            DECODE(SUBSTR (vsl_cd, 1, 2), 'FD', 'CFDR', vsl_cd), 
--                            DECODE(SUBSTR (vsl_cd, 1, 2), 'FD', SUBSTR (vsl_cd || skd_voy_no , 3, 4), skd_voy_no), 
--                            DECODE(SUBSTR (vsl_cd, 1, 2), 'FD', 'E', skd_dir_cd), 
--                            DECODE(SUBSTR (vsl_cd, 1, 2), 'FD', 'E', rev_dir_cd),		
--                            v_n_bkg_no                  ,
--                            v_n_bkg_no_split            ,    	
--                            c.cntr_no                   ,     	
--                            c.cntr_tpsz_cd              ,     	
--                            e.cntr_tpsz_cd              ,     	
--                            c.cost_act_grp_cd           ,     	
--                            e.cost_act_grp_cd           ,     	
--                            c.cost_act_grp_seq          ,     	
--                            e.cost_act_grp_seq          ,     	
--                            c.coa_cost_src_cd           ,     	
--                            e.coa_cost_src_cd           ,     	
--                            c.n1st_nod_cd               ,     	
--                            e.n1st_nod_cd               ,     	
--                            c.n2nd_nod_cd               ,     	
--                            e.n2nd_nod_cd               ,     	
--                            c.n3rd_nod_cd               ,     	
--                            e.n3rd_nod_cd               ,     	
--                            c.n4th_nod_cd               ,     	
--                            e.n4th_nod_cd               ,     	
--                            c.sum_usd_cost              ,     	
--                            e.estm_cost_amt             ,     	
--                            0                           ,     	
--                            0                           ,     	
--                            'MA'                        ,  -- 매핑  	
--                            sysdate                     , 
--                            c.cre_dt                       -- ENIS 생성일자                        	
--                        FROM    lea_estm_cost_if e
--                        WHERE   1=1
----                        AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon)
--                        AND e.bkg_no = v_n_bkg_no 
--                        AND e.bkg_no_split = v_n_bkg_no_split
--                        AND e.cntr_no = c.cntr_no 
--                        AND NVL (e.cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (e.cntr_tpsz_cd, ' ')) 
--                        AND e.cost_act_grp_cd = NVL (c.cost_act_grp_cd, e.cost_act_grp_cd) 
----                        AND e.cost_act_grp_seq = NVL (c.cost_act_grp_seq, e.cost_act_grp_seq) 
--                        AND e.coa_cost_src_cd = c.coa_cost_src_cd 
----                        AND e.acct_cd = c.acct_cd 
--                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
--                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
--                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
--                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd 
--                        AND e.n1st_nod_cd = CASE WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'OD'
--                                                    THEN e.n1st_nod_cd
--                                                ELSE c.n1st_nod_cd
--                                            END
--                        AND NVL (e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
--                        AND NVL (e.n3rd_nod_cd, ' ') = CASE WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
--                                                            AND NVL (e.n4th_nod_cd, ' ')  = ' '
--                                                                THEN  NVL (e.n3rd_nod_cd, ' ')
--                                                            ELSE c.n3rd_nod_cd
--                                                       END
--                        AND NVL (e.n4th_nod_cd, ' ') = CASE WHEN SUBSTR(NVL(c.cost_act_grp_cd, ' '), 1,2) = 'ID'
--                                                                THEN NVL (e.n4th_nod_cd, ' ')
--                                                            ELSE c.n4th_nod_cd
--                                                       END
--                        AND e.delt_flg = 'N'
--                        AND e.skd_voy_no IS NOT NULL
----                        AND e.thrp_rt_flg = 'N'
--                        AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
--                        AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
--                                                                            ('NIBC', 'TMFDFL'), 
--                                                                            ('NOBC', 'TMNDFL'),
--                                                                            ('NOBC', 'TMFDFL')) 
--                        AND rownum = 1 ) ;
--
--                ELSE 
                    v_map_cd := 'E'; 
                END IF; 

            ELSIF v_prc_tp = 'BKG' THEN
          
                SELECT  NVL(SUM(cntr_qty) , 0) , 
                        DECODE(NVL(SUM(cntr_qty) , 0), 0 , 0, c.sum_usd_cost / SUM(cntr_qty))
                INTO    v_sum_cntr_qty, v_aloc_cntr_amt
                FROM    lea_estm_cost_if e
                WHERE  1=1
--                AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon)
                AND e.bkg_no = c.bkg_no 
                AND e.coa_cost_src_cd = c.coa_cost_src_cd 
--                AND e.acct_cd = c.acct_cd 
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
                AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd 
                AND e.n1st_nod_cd = c.n1st_nod_cd 
                AND NVL (e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd
                AND NVL (e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd
                AND NVL (e.n4th_nod_cd, ' ') = c.n4th_nod_cd
                AND e.delt_flg = 'N'
                AND e.skd_voy_no IS NOT NULL
                AND e.thrp_rt_flg = 'N'
                AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                    ('NIBC', 'TMFDFL'), 
                                                                    ('NOBC', 'TMNDFL'),
                                                                    ('NOBC', 'TMFDFL')) ; 
                                                                    
                IF v_sum_cntr_qty > 0 THEN
                    INSERT INTO lea_csr_mntr m
                    (SELECT /*+ FIRST_ROWS  */ c.exe_yrmon                 ,       
                            c.inv_sys_id                ,     	
                            c.if_seq                    ,     	
                            c.gl_dt                     ,     	
                            c.csr_no csr_no             ,     	
                            c.inv_no inv_no             ,     	
                            c.inv_ofc                   ,     	
                            c.rev_yrmon                 ,     	
                            c.vsl_cd 					,		
                            c.skd_voy_no 				,		
                            c.skd_dir_cd 				,		
                            c.rev_dir_cd    			,		
                            DECODE(SUBSTR (vsl_cd, 1, 2), 'FD', 'CFDR', vsl_cd), 
                            DECODE(SUBSTR (vsl_cd, 1, 2), 'FD', SUBSTR (vsl_cd || skd_voy_no , 3, 4), skd_voy_no), 
                            DECODE(SUBSTR (vsl_cd, 1, 2), 'FD', 'E', skd_dir_cd), 
                            DECODE(SUBSTR (vsl_cd, 1, 2), 'FD', 'E', rev_dir_cd),		
                            c.bkg_no                    ,	
                            null                        ,
                            c.cntr_no                   ,     	
                            DECODE(c.cntr_no, null , null , c.cntr_tpsz_cd ) ,     	
                            null                        , -- e.cntr_tpsz_cd    	
                            c.cost_act_grp_cd           ,     	
                            null                        , -- e.cost_act_grp_cd    	
                            c.cost_act_grp_seq          ,   	
                            null                        , -- e.cost_act_grp_seq     	
                            c.coa_cost_src_cd           ,     	
                            e.coa_cost_src_cd           ,     	
                            c.n1st_nod_cd               ,     	
                            e.n1st_nod_cd               ,     	
                            c.n2nd_nod_cd               ,     	
                            e.n2nd_nod_cd               ,     	
                            c.n3rd_nod_cd               ,     	
                            e.n3rd_nod_cd               ,     	
                            c.n4th_nod_cd               ,     	
                            e.n4th_nod_cd               ,     	
                            c.sum_usd_cost              ,     	
                            0                           , -- e.est_cost_amt    	
                            v_sum_cntr_qty              ,
                            v_aloc_cntr_amt             ,
                            'DI'                        ,   --> 배부  	
                            sysdate                     ,     	
                            c.cre_dt                       -- ENIS 생성일자                          	
                    FROM    lea_estm_cost_if e
                    WHERE 1=1
--                    AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon) 
                    AND e.bkg_no = c.bkg_no 
                    AND e.coa_cost_src_cd = c.coa_cost_src_cd 
    --                AND e.acct_cd = c.acct_cd 
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd
                    AND e.n1st_nod_cd = c.n1st_nod_cd 
                    AND NVL (e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd
                    AND NVL (e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd
                    AND NVL (e.n4th_nod_cd, ' ') = c.n4th_nod_cd
                    AND e.delt_flg = 'N'
                    AND e.skd_voy_no IS NOT NULL
                    AND e.thrp_rt_flg = 'N'
                    AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                    AND (e.cost_act_grp_cd , e.coa_cost_src_cd ) not in    (('NIBC', 'TMNDFL'), 
                                                                        ('NIBC', 'TMFDFL'), 
                                                                        ('NOBC', 'TMNDFL'),
                                                                        ('NOBC', 'TMFDFL'))
                    AND rownum = 1 ) ;
                    
                ELSE
                    v_map_cd := 'B';
                END IF;

            ELSIF v_prc_tp = 'RVVD' THEN
            
                SELECT  NVL(SUM(cntr_qty) , 0) , 
                        DECODE(NVL(SUM(cntr_qty) , 0), 0 , 0, c.sum_usd_cost / SUM(cntr_qty))
                INTO    v_sum_cntr_qty, v_aloc_cntr_amt
                FROM    lea_estm_cost_if e
                WHERE 1=1
--                AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon) 
                AND e.coa_cost_src_cd = c.coa_cost_src_cd 
--                AND e.acct_cd = c.acct_cd 
                AND e.vsl_cd = c.vsl_cd
                AND e.skd_voy_no = c.skd_voy_no
                AND e.skd_dir_cd = c.skd_dir_cd 
                AND e.rev_dir_cd = c.rev_dir_cd 
                AND e.n1st_nod_cd = c.n1st_nod_cd 
                AND NVL (e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd
                AND NVL (e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd
                AND NVL (e.n4th_nod_cd, ' ') = c.n4th_nod_cd 
                AND e.delt_flg = 'N'
                AND e.skd_voy_no IS NOT NULL
                AND e.thrp_rt_flg = 'N'
                AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in    (('NIBC', 'TMNDFL'), 
                                                                    ('NIBC', 'TMFDFL'), 
                                                                    ('NOBC', 'TMNDFL'),
                                                                    ('NOBC', 'TMFDFL')) ;
                                                                    
                IF v_sum_cntr_qty > 0 THEN
                    INSERT INTO lea_csr_mntr m
                    (SELECT /*+ FIRST_ROWS */ c.exe_yrmon                 ,       
                            c.inv_sys_id                ,     	
                            c.if_seq                    ,     	
                            c.gl_dt                     ,     	
                            c.csr_no csr_no             ,     	
                            c.inv_no inv_no             ,     	
                            c.inv_ofc                   ,     	
                            c.rev_yrmon                 ,     	
                            c.vsl_cd 					,		
                            c.skd_voy_no 				,		
                            c.skd_dir_cd 				,		
                            c.rev_dir_cd    			,		
                            e.vsl_cd                    , 
                            e.skd_voy_no                , 
                            e.skd_dir_cd                , 
                            e.rev_dir_cd                , 
                            c.bkg_no                    ,
                            null                        ,
                            c.cntr_no                   ,     	
                            DECODE(c.cntr_no, null , null , c.cntr_tpsz_cd ) ,   	
                            null                        , -- e.cntr_tpsz_cd    	
                            c.cost_act_grp_cd           ,     	
                            null                        , -- e.cost_act_grp_cd    	
                            c.cost_act_grp_seq          ,   	
                            null                        , -- e.cost_act_grp_seq     	
                            c.coa_cost_src_cd           ,     	
                            e.coa_cost_src_cd           ,     	
                            c.n1st_nod_cd               ,     	
                            e.n1st_nod_cd               ,     	
                            c.n2nd_nod_cd               ,     	
                            e.n2nd_nod_cd               ,     	
                            c.n3rd_nod_cd               ,     	
                            e.n3rd_nod_cd               ,     	
                            c.n4th_nod_cd               ,     	
                            e.n4th_nod_cd               ,     	
                            c.sum_usd_cost              ,     	
                            0                           , -- e.est_cost_amt    	
                            v_sum_cntr_qty              ,
                            v_aloc_cntr_amt             ,
                            'DI'                        , --> 배부  	
                            sysdate                     ,     	
                            c.cre_dt                       -- ENIS 생성일자                          	
                    FROM    lea_estm_cost_if e
                    WHERE 1=1
--                    AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon) 
                    AND e.coa_cost_src_cd = c.coa_cost_src_cd 
    --                AND e.acct_cd = c.acct_cd 
                    AND e.vsl_cd = c.vsl_cd
                    AND e.skd_voy_no = c.skd_voy_no
                    AND e.skd_dir_cd = c.skd_dir_cd 
                    AND e.rev_dir_cd = c.rev_dir_cd 
                    AND e.n1st_nod_cd = c.n1st_nod_cd 
                    AND NVL (e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd
                    AND NVL (e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd
                    AND NVL (e.n4th_nod_cd, ' ') = c.n4th_nod_cd
                    AND e.delt_flg = 'N'
                    AND e.skd_voy_no IS NOT NULL
                    AND e.thrp_rt_flg = 'N'
                    AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                    AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                        ('NIBC', 'TMFDFL'), 
                                                                        ('NOBC', 'TMNDFL'),
                                                                        ('NOBC', 'TMFDFL'))
                    AND rownum = 1 ) ;
                    
                ELSE
                    v_map_cd := 'R';
                END IF;
                      
            ELSIF v_prc_tp = 'CNTC'    THEN
         
                SELECT  /*+ NO_EXPAND index (lea_estm_cost_if xak6lea_estm_cost_if) */ NVL(SUM(cntr_qty) , 0) , 
                        DECODE(NVL(SUM(cntr_qty) , 0), 0 , 0, c.sum_usd_cost / SUM(cntr_qty) )
                INTO    v_sum_cntr_qty, v_aloc_cntr_amt
                FROM    lea_estm_cost_if e
                WHERE e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon) 
                AND e.coa_cost_src_cd = c.coa_cost_src_cd 
--                AND e.acct_cd = c.acct_cd
                AND e.n1st_nod_cd = c.n1st_nod_cd 
                AND NVL (e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd
                AND NVL (e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd
                AND NVL (e.n4th_nod_cd, ' ') = c.n4th_nod_cd 
                AND e.delt_flg = 'N'
                AND e.skd_voy_no IS NOT NULL
                AND e.thrp_rt_flg = 'N'
                AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in    (('NIBC', 'TMNDFL'), 
                                                                    ('NIBC', 'TMFDFL'), 
                                                                    ('NOBC', 'TMNDFL'),
                                                                    ('NOBC', 'TMFDFL')) ;
                
                IF v_sum_cntr_qty > 0 THEN
                    INSERT INTO lea_csr_mntr m
                    (SELECT /*+ FIRST_ROWS NO_EXPAND index (lea_estm_cost_if xak6lea_estm_cost_if) */ c.exe_yrmon                 ,       
                            c.inv_sys_id                ,     	
                            c.if_seq                    ,     	
                            c.gl_dt                     ,     	
                            c.csr_no csr_no             ,     	
                            c.inv_no inv_no             ,     	
                            c.inv_ofc                   ,     	
                            c.rev_yrmon                 ,     	
                            c.vsl_cd 					,		
                            c.skd_voy_no 				,		
                            c.skd_dir_cd 				,		
                            c.rev_dir_cd    			,		
                            null     					,		
                            null        				,		
                            null         				,		
                            null        				,		
                            c.bkg_no                    ,
                            null                        ,	
                            c.cntr_no                   ,     	
                            DECODE(c.cntr_no, null , null , c.cntr_tpsz_cd ) ,     	
                            null                        , -- e.cntr_tpsz_cd    	
                            c.cost_act_grp_cd           ,     	
                            null                        , -- e.cost_act_grp_cd    	
                            c.cost_act_grp_seq          ,   	
                            null                        , -- e.cost_act_grp_seq     	
                            c.coa_cost_src_cd           ,     	
                            e.coa_cost_src_cd           ,     	
                            c.n1st_nod_cd               ,     	
                            e.n1st_nod_cd               ,     	
                            c.n2nd_nod_cd               ,     	
                            e.n2nd_nod_cd               ,     	
                            c.n3rd_nod_cd               ,     	
                            e.n3rd_nod_cd               ,     	
                            c.n4th_nod_cd               ,     	
                            e.n4th_nod_cd               ,     	
                            c.sum_usd_cost              ,     	
                            0                           , -- e.est_cost_amt    	
                            v_sum_cntr_qty              ,
                            v_aloc_cntr_amt             ,
                            'DI'                        , --> 배부  	
                            sysdate                     ,     	
                            c.cre_dt                       -- ENIS 생성일자                          	
                    FROM    lea_estm_cost_if e
                    WHERE e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon) 
                    AND e.coa_cost_src_cd = c.coa_cost_src_cd 
    --                AND e.acct_cd = c.acct_cd
                    AND e.n1st_nod_cd = c.n1st_nod_cd 
                    AND NVL (e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd
                    AND NVL (e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd
                    AND NVL (e.n4th_nod_cd, ' ') = c.n4th_nod_cd
                    AND e.delt_flg = 'N'
                    AND e.skd_voy_no IS NOT NULL
                    AND e.thrp_rt_flg = 'N'
                    AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                    AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                        ('NIBC', 'TMFDFL'), 
                                                                        ('NOBC', 'TMNDFL'),
                                                                        ('NOBC', 'TMFDFL'))
                    AND rownum = 1 ) ;  
                    
                ELSE
                    v_map_cd := 'C';
                END IF;             

            ELSIF v_prc_tp = 'CNTR_MAP_ERR_CASE'    OR 
                  v_prc_tp = 'CNTR_MAP_CNT_OVER'    THEN                   
                    v_map_cd := 'E';                    
            ELSE 
               NULL; 
            END IF; 
 
            /* Error 에 대하여 세부 유형으로 처리 */
            IF v_map_cd = 'E' THEN
                 
                SELECT /*+ FIRST_ROWS */ COUNT(*) INTO v_no_bkg FROM lea_estm_cost_if e
                WHERE  1=1 
--                AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon) 
                AND e.bkg_no = v_n_bkg_no
                AND e.cntr_no = c.cntr_no
                AND e.delt_flg = 'N'
                AND e.skd_voy_no IS NOT NULL
                AND e.thrp_rt_flg = 'N'
                AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                    ('NIBC', 'TMFDFL'), 
                                                                    ('NOBC', 'TMNDFL'),
                                                                    ('NOBC', 'TMFDFL'))
                AND rownum = 1;
                

                IF v_no_bkg = 0  THEN
                    INSERT INTO lea_csr_mntr
                    (SELECT c.exe_yrmon , c.inv_sys_id , c.if_seq , c.gl_dt ,  c.csr_no,     	
                                        c.inv_no, c.inv_ofc, c.rev_yrmon, 
                                        c.vsl_cd , c.skd_voy_no, c.skd_dir_cd, c.rev_dir_cd ,		
                                        null, null, null, null,	
                                        NVL(v_n_bkg_no, c.bkg_no), null,  c.cntr_no,     	
                                        DECODE(c.cntr_no, null , null , c.cntr_tpsz_cd ) ,     	
                                        null, c.cost_act_grp_cd,null, c.cost_act_grp_seq , null,     	
                                        c.coa_cost_src_cd  , null,  	
                                        c.n1st_nod_cd , null, c.n2nd_nod_cd, null, c.n3rd_nod_cd ,  null,  c.n4th_nod_cd ,     	
                                        null, c.sum_usd_cost,null ,0 ,0,'BK' , sysdate, c.cre_dt FROM DUAL );
                      
                ELSE
                    /* (1)Node */       
                    SELECT /*+ FIRST_ROWS */ count(*) INTO v_nd_err FROM lea_estm_cost_if e
                    WHERE 1=1
--                    AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon)
                    AND e.bkg_no = v_n_bkg_no 
                    AND e.cntr_no = c.cntr_no
                    AND e.cntr_tpsz_cd = NVL (c.cntr_tpsz_cd, e.cntr_tpsz_cd)
                    AND e.cost_act_grp_cd= NVL(c.cost_act_grp_cd, e.cost_act_grp_cd)
                    AND e.coa_cost_src_cd = c.coa_cost_src_cd
--                    AND e.acct_cd = c.acct_cd 
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd
                    AND e.delt_flg = 'N'
                    AND e.skd_voy_no IS NOT NULL
--                    AND e.thrp_rt_flg = 'N'
                    AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                    AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                        ('NIBC', 'TMFDFL'), 
                                                                        ('NOBC', 'TMNDFL'),
                                                                        ('NOBC', 'TMFDFL'))
                    AND e.n1st_nod_cd like SUBSTR(c.n1st_nod_cd,1,5)||'%' 
                    AND rownum = 1 ;
                    
            
                    IF v_nd_err > 0 THEN
                        INSERT INTO lea_csr_mntr m
                        (SELECT /*+ FIRST_ROWS */ c.exe_yrmon , c.inv_sys_id , c.if_seq ,
                                c.gl_dt , c.csr_no csr_no , c.inv_no inv_no , c.inv_ofc ,    	
                                c.rev_yrmon , c.vsl_cd , c.skd_voy_no , c.skd_dir_cd , c.rev_dir_cd ,		
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd),	
                                v_n_bkg_no , null,  c.cntr_no ,     	
                                DECODE(c.cntr_no, null , null , c.cntr_tpsz_cd ) , e.cntr_tpsz_cd ,     	
                                c.cost_act_grp_cd , e.cost_act_grp_cd ,     	
                                c.cost_act_grp_seq , e.cost_act_grp_seq ,     	
                                c.coa_cost_src_cd , e.coa_cost_src_cd ,     	
                                c.n1st_nod_cd , e.n1st_nod_cd , c.n2nd_nod_cd , e.n2nd_nod_cd ,     	
                                c.n3rd_nod_cd , e.n3rd_nod_cd , c.n4th_nod_cd , e.n4th_nod_cd ,     	
                                c.sum_usd_cost , e.estm_cost_amt , 0 , 0 ,     	
                                'ND' ,  	
                                sysdate , c.cre_dt
                        FROM    lea_estm_cost_if e
                        WHERE   1=1
--                        AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon) 
                        AND e.bkg_no = v_n_bkg_no 
                        AND e.cntr_no = c.cntr_no 
                        AND NVL (e.cntr_tpsz_cd, ' ') = NVL (c.cntr_tpsz_cd, NVL (e.cntr_tpsz_cd, ' ')) 
                        AND e.cost_act_grp_cd = NVL (c.cost_act_grp_cd, e.cost_act_grp_cd) 
                        AND e.coa_cost_src_cd = c.coa_cost_src_cd 
--                        AND e.acct_cd = c.acct_cd 
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd
                        AND e.delt_flg = 'N'
                        AND e.skd_voy_no IS NOT NULL
--                        AND e.thrp_rt_flg = 'N'
                        AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                        AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                            ('NIBC', 'TMFDFL'), 
                                                                            ('NOBC', 'TMNDFL'),
                                                                            ('NOBC', 'TMFDFL'))
                        AND e.n1st_nod_cd like SUBSTR(c.n1st_nod_cd,1,5)||'%' 
                        AND rownum = 1 ); 
                        
                        GOTO end_loop;
                         
                    END IF;
                    
                    /* (2)TP/SZ */       
                    SELECT /*+ FIRST_ROWS */ count(*) INTO v_tpsz_err FROM lea_estm_cost_if e
                    WHERE 1=1
--                    AND e.rev_yrmon =NVL(c.rev_yrmon , e.rev_yrmon)
                    AND e.bkg_no = v_n_bkg_no 
                    AND e.cntr_no = c.cntr_no
                    AND e.cost_act_grp_cd = NVL(c.cost_act_grp_cd, e.cost_act_grp_cd)
                    AND e.coa_cost_src_cd = c.coa_cost_src_cd
--                    AND e.acct_cd = c.acct_cd 
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd
                    AND e.n1st_nod_cd = c.n1st_nod_cd 
                    AND nvl(e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                    AND nvl(e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
                    AND nvl(e.n4th_nod_cd, ' ') = c.n4th_nod_cd 
                    AND e.delt_flg = 'N'
                    AND e.skd_voy_no IS NOT NULL
--                    AND e.thrp_rt_flg = 'N'
                    AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                    AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                        ('NIBC', 'TMFDFL'), 
                                                                        ('NOBC', 'TMNDFL'),
                                                                        ('NOBC', 'TMFDFL')) 
                    AND rownum = 1;
                   
                    
                    IF v_tpsz_err > 0 THEN
                        INSERT INTO lea_csr_mntr m
                        (SELECT /*+ FIRST_ROWS */ c.exe_yrmon , c.inv_sys_id , c.if_seq ,
                                c.gl_dt , c.csr_no csr_no , c.inv_no inv_no , c.inv_ofc ,    	
                                c.rev_yrmon , c.vsl_cd , c.skd_voy_no , c.skd_dir_cd , c.rev_dir_cd ,		
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd),	
                                v_n_bkg_no , null, c.cntr_no ,     	
                                DECODE(c.cntr_no, null , null , c.cntr_tpsz_cd ) , e.cntr_tpsz_cd ,     	
                                c.cost_act_grp_cd , e.cost_act_grp_cd ,     	
                                c.cost_act_grp_seq , e.cost_act_grp_seq ,     	
                                c.coa_cost_src_cd , e.coa_cost_src_cd ,     	
                                c.n1st_nod_cd , e.n1st_nod_cd , c.n2nd_nod_cd , e.n2nd_nod_cd ,     	
                                c.n3rd_nod_cd , e.n3rd_nod_cd , c.n4th_nod_cd , e.n4th_nod_cd ,     	
                                c.sum_usd_cost , e.estm_cost_amt , 0 , 0 ,
                                'TS' ,
                                sysdate , c.cre_dt                          	
                        FROM    lea_estm_cost_if e
                        WHERE 1=1
--                        AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon)
                        AND e.bkg_no = v_n_bkg_no
                        AND e.cntr_no = c.cntr_no
                        AND e.cost_act_grp_cd = NVL(c.cost_act_grp_cd, e.cost_act_grp_cd)
                        AND e.coa_cost_src_cd = c.coa_cost_src_cd
--                        AND e.acct_cd = c.acct_cd 
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd
                        AND e.n1st_nod_cd = c.n1st_nod_cd 
                        AND nvl(e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                        AND nvl(e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
                        AND nvl(e.n4th_nod_cd, ' ') = c.n4th_nod_cd
                        AND e.delt_flg = 'N'
                        AND e.skd_voy_no IS NOT NULL
--                        AND e.thrp_rt_flg = 'N'
                        AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                        AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                            ('NIBC', 'TMFDFL'), 
                                                                            ('NOBC', 'TMNDFL'),
                                                                            ('NOBC', 'TMFDFL'))
                        AND rownum = 1) ; 
                        
                        GOTO end_loop; 
                    END IF;
                    
                    /* (3)A/G */       
                    SELECT /*+ FIRST_ROWS */ count(*) INTO v_ag_err FROM lea_estm_cost_if e
                    WHERE 1=1
--                    AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon)
                    AND e.bkg_no = v_n_bkg_no
                    AND e.cntr_no = c.cntr_no
                    AND e.cntr_tpsz_cd = NVL (c.cntr_tpsz_cd, e.cntr_tpsz_cd)
                    AND e.coa_cost_src_cd = c.coa_cost_src_cd
--                    AND e.acct_cd = c.acct_cd 
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd
                    AND e.n1st_nod_cd = c.n1st_nod_cd 
                    AND nvl(e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                    AND nvl(e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
                    AND nvl(e.n4th_nod_cd, ' ') = c.n4th_nod_cd
                    AND e.delt_flg = 'N'
                    AND e.skd_voy_no IS NOT NULL
--                    AND e.thrp_rt_flg = 'N'
                    AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                    AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                        ('NIBC', 'TMFDFL'), 
                                                                        ('NOBC', 'TMNDFL'),
                                                                        ('NOBC', 'TMFDFL'))
                    AND rownum = 1 ;
                  
                    IF v_ag_err > 0 THEN
                        INSERT INTO lea_csr_mntr m
                        (SELECT /*+ FIRST_ROWS */ c.exe_yrmon , c.inv_sys_id , c.if_seq ,
                                c.gl_dt , c.csr_no csr_no , c.inv_no inv_no , c.inv_ofc ,    	
                                c.rev_yrmon , c.vsl_cd , c.skd_voy_no , c.skd_dir_cd , c.rev_dir_cd ,		
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd),
                                v_n_bkg_no , null, c.cntr_no ,     	
                                DECODE(c.cntr_no, null , null , c.cntr_tpsz_cd ) , e.cntr_tpsz_cd ,     	
                                c.cost_act_grp_cd , e.cost_act_grp_cd ,     	
                                c.cost_act_grp_seq , e.cost_act_grp_seq ,     	
                                c.coa_cost_src_cd , e.coa_cost_src_cd ,     	
                                c.n1st_nod_cd , e.n1st_nod_cd , c.n2nd_nod_cd , e.n2nd_nod_cd ,     	
                                c.n3rd_nod_cd , e.n3rd_nod_cd , c.n4th_nod_cd , e.n4th_nod_cd ,     	
                                c.sum_usd_cost , e.estm_cost_amt , 0 , 0 ,
                                'AG' ,	
                                sysdate , c.cre_dt                          	
                        FROM    lea_estm_cost_if e
                        WHERE 1=1
--                        AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon)
                        AND e.bkg_no = v_n_bkg_no
                        AND e.cntr_no = c.cntr_no
                        AND e.cntr_tpsz_cd = NVL (c.cntr_tpsz_cd, e.cntr_tpsz_cd)
                        AND e.coa_cost_src_cd = c.coa_cost_src_cd
--                        AND e.acct_cd = c.acct_cd 
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd
                        AND e.n1st_nod_cd = c.n1st_nod_cd 
                        AND nvl(e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                        AND nvl(e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
                        AND nvl(e.n4th_nod_cd, ' ') = c.n4th_nod_cd
                        AND e.delt_flg = 'N'
                        AND e.skd_voy_no IS NOT NULL
--                        AND e.thrp_rt_flg = 'N'
                        AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                        AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                            ('NIBC', 'TMFDFL'), 
                                                                            ('NOBC', 'TMNDFL'),
                                                                            ('NOBC', 'TMFDFL')) 
                        AND rownum = 1) ; 
                        
                        GOTO end_loop; 
                    END IF;
                    
                    /* (4)Cost CD */       
                    SELECT /*+ FIRST_ROWS */ count(*) INTO v_cost_err FROM lea_estm_cost_if e
                    WHERE 1=1
--                    AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon)
                    AND e.bkg_no =  v_n_bkg_no 
                    AND e.cntr_no = c.cntr_no
                    AND e.cntr_tpsz_cd = NVL (c.cntr_tpsz_cd, e.cntr_tpsz_cd)
                    AND e.cost_act_grp_cd= NVL(c.cost_act_grp_cd, e.cost_act_grp_cd)
--                    AND e.acct_cd = c.acct_cd 
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
                    AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd
                    AND e.n1st_nod_cd = c.n1st_nod_cd 
                    AND nvl(e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                    AND nvl(e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
                    AND nvl(e.n4th_nod_cd, ' ') = c.n4th_nod_cd 
                    AND e.delt_flg = 'N'
                    AND e.skd_voy_no IS NOT NULL
--                    AND e.thrp_rt_flg = 'N'
                    AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                    AND e.coa_cost_src_cd in ( SELECT DECODE(ROWNUM ,   1, a.coa_cost_src_cd1, 
                                                                            2, a.coa_cost_src_cd2,
                                                                            3, a.coa_cost_src_cd3, null)
                                                     FROM lea_lgs_cost a, (SELECT * FROM  ap_period WHERE ROWNUM < 4 ) b
                                                                           WHERE a.coa_cost_src_cd = c.coa_cost_src_Cd )
                    AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                        ('NIBC', 'TMFDFL'), 
                                                                        ('NOBC', 'TMNDFL'),
                                                                        ('NOBC', 'TMFDFL')) 
                    AND rownum = 1 ;
                
                    IF v_cost_err > 0 THEN
                        INSERT INTO lea_csr_mntr m
                        (SELECT /*+ FIRST_ROWS */ c.exe_yrmon , c.inv_sys_id , c.if_seq ,
                                c.gl_dt , c.csr_no csr_no , c.inv_no inv_no , c.inv_ofc ,    	
                                c.rev_yrmon , c.vsl_cd , c.skd_voy_no , c.skd_dir_cd , c.rev_dir_cd ,		
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd),	
                                v_n_bkg_no, null, c.cntr_no ,     	
                                DECODE(c.cntr_no, null , null , c.cntr_tpsz_cd ) , e.cntr_tpsz_cd ,     	
                                c.cost_act_grp_cd , e.cost_act_grp_cd ,     	
                                c.cost_act_grp_seq , e.cost_act_grp_seq ,     	
                                c.coa_cost_src_cd , e.coa_cost_src_cd ,     	
                                c.n1st_nod_cd , e.n1st_nod_cd , c.n2nd_nod_cd , e.n2nd_nod_cd ,     	
                                c.n3rd_nod_cd , e.n3rd_nod_cd , c.n4th_nod_cd , e.n4th_nod_cd ,     	
                                c.sum_usd_cost , e.estm_cost_amt , 0 , 0 ,
                                'CD' ,	
                                sysdate , c.cre_dt                          	
                        FROM    lea_estm_cost_if e
                        WHERE 1=1
--                        AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon)
                        AND e.bkg_no =  v_n_bkg_no
                        AND e.cntr_no = c.cntr_no
                        AND e.cntr_tpsz_cd = NVL (c.cntr_tpsz_cd, e.cntr_tpsz_cd)
                        AND e.cost_act_grp_cd= NVL(c.cost_act_grp_cd, e.cost_act_grp_cd)
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd) = c.vsl_cd
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no) = c.skd_voy_no
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd) = c.skd_dir_cd 
                        AND DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd) = c.rev_dir_cd
                        AND e.n1st_nod_cd = c.n1st_nod_cd 
                        AND nvl(e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                        AND nvl(e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
                        AND nvl(e.n4th_nod_cd, ' ') = c.n4th_nod_cd
                        AND e.delt_flg = 'N'
                        AND e.skd_voy_no IS NOT NULL
--                        AND e.thrp_rt_flg = 'N'
                        AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                        AND e.coa_cost_src_cd in ( SELECT DECODE(ROWNUM ,   1, a.coa_cost_src_cd1, 
                                                                            2, a.coa_cost_src_cd2,
                                                                            3, a.coa_cost_src_cd3, null)
                                                     FROM lea_lgs_cost a, (SELECT * FROM  ap_period WHERE ROWNUM < 4 ) b
                                                    WHERE a.coa_cost_src_cd = c.coa_cost_src_Cd )
                        AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                            ('NIBC', 'TMFDFL'), 
                                                                            ('NOBC', 'TMNDFL'),
                                                                            ('NOBC', 'TMFDFL'))  
                        AND rownum = 1) ; 
                        
                        GOTO end_loop; 
                    END IF ;
                    
                    /* (5)VVD */       
                    SELECT /*+ FIRST_ROWS */ count(*) INTO v_vvd_err FROM lea_estm_cost_if e
                    WHERE 1=1
--                    AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon)
                    AND e.bkg_no = v_n_bkg_no
                    AND e.cntr_no = c.cntr_no
                    AND e.cntr_tpsz_cd = NVL (c.cntr_tpsz_cd, e.cntr_tpsz_cd)
                    AND e.cost_act_grp_cd= NVL(c.cost_act_grp_cd, e.cost_act_grp_cd)
                    AND e.coa_cost_src_cd = c.coa_cost_src_cd
--                    AND e.acct_cd = c.acct_cd 
                    AND e.n1st_nod_cd = c.n1st_nod_cd 
                    AND nvl(e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                    AND nvl(e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
                    AND nvl(e.n4th_nod_cd, ' ') = c.n4th_nod_cd
                    AND e.delt_flg = 'N'
                    AND e.skd_voy_no IS NOT NULL
--                    AND e.thrp_rt_flg = 'N'
                    AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                    AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                        ('NIBC', 'TMFDFL'), 
                                                                        ('NOBC', 'TMNDFL'),
                                                                        ('NOBC', 'TMFDFL'))
                    AND rownum =1 ;
                   
                    IF v_vvd_err > 0 THEN
                        INSERT INTO lea_csr_mntr m
                        (SELECT /*+ FIRST_ROWS */ c.exe_yrmon , c.inv_sys_id , c.if_seq ,
                                c.gl_dt , c.csr_no csr_no , c.inv_no inv_no , c.inv_ofc ,    	
                                c.rev_yrmon , c.vsl_cd , c.skd_voy_no , c.skd_dir_cd , c.rev_dir_cd ,		
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'CFDR', e.vsl_cd), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', SUBSTR (e.vsl_cd || e.skd_voy_no , 3, 4), e.skd_voy_no), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.skd_dir_cd), 
                                DECODE(SUBSTR (e.vsl_cd, 1, 2), 'FD', 'E', e.rev_dir_cd),	
                                v_n_bkg_no , null, c.cntr_no ,     	
                                DECODE(c.cntr_no, null , null , c.cntr_tpsz_cd ) , e.cntr_tpsz_cd ,     	
                                c.cost_act_grp_cd , e.cost_act_grp_cd ,     	
                                c.cost_act_grp_seq , e.cost_act_grp_seq ,     	
                                c.coa_cost_src_cd , e.coa_cost_src_cd ,     	
                                c.n1st_nod_cd , e.n1st_nod_cd , c.n2nd_nod_cd , e.n2nd_nod_cd ,     	
                                c.n3rd_nod_cd , e.n3rd_nod_cd , c.n4th_nod_cd , e.n4th_nod_cd ,     	
                                c.sum_usd_cost , e.estm_cost_amt , 0 , 0 , 	
                                'VV' ,	
                                sysdate , c.cre_dt                          	
                        FROM    lea_estm_cost_if e
                        WHERE 1=1
--                        AND e.rev_yrmon = NVL(c.rev_yrmon , e.rev_yrmon)
                        AND e.bkg_no = v_n_bkg_no
                        AND e.cntr_no = c.cntr_no
                        AND e.cntr_tpsz_cd = NVL (c.cntr_tpsz_cd, e.cntr_tpsz_cd)
                        AND e.cost_act_grp_cd= NVL(c.cost_act_grp_cd, e.cost_act_grp_cd)
                        AND e.coa_cost_src_cd = c.coa_cost_src_cd
--                        AND e.acct_cd = c.acct_cd
                        AND e.n1st_nod_cd = c.n1st_nod_cd 
                        AND nvl(e.n2nd_nod_cd, ' ') = c.n2nd_nod_cd 
                        AND nvl(e.n3rd_nod_cd, ' ') = c.n3rd_nod_cd 
                        AND nvl(e.n4th_nod_cd, ' ') = c.n4th_nod_cd
                        AND e.delt_flg = 'N'
                        AND e.skd_voy_no IS NOT NULL
--                        AND e.thrp_rt_flg = 'N'
                        AND e.bkg_sts_cd NOT IN ('W' ,'X' , 'S')
                        AND (e.cost_act_grp_cd , e.coa_cost_src_cd) not in  (('NIBC', 'TMNDFL'), 
                                                                            ('NIBC', 'TMFDFL'), 
                                                                            ('NOBC', 'TMNDFL'),
                                                                            ('NOBC', 'TMFDFL'))  
                        AND rownum = 1) ; 
                        
                        GOTO end_loop; 
                    END IF ;

                    INSERT INTO lea_csr_mntr
                    (SELECT c.exe_yrmon             ,       
                        c.inv_sys_id                ,     	
                        c.if_seq                    ,     	
                        c.gl_dt                     ,     	
                        c.csr_no                    ,     	
                        c.inv_no                    ,     	
                        c.inv_ofc                   ,     	
                        c.rev_yrmon                 ,     	
                        c.vsl_cd 					,		
                        c.skd_voy_no 				,		
                        c.skd_dir_cd 				,		
                        c.rev_dir_cd    			,		
                        null     					,		
                        null         				,		
                        null         				,		
                        null         				,	
                        v_n_bkg_no                  ,
                        null                        ,
                        c.cntr_no                   ,     	
                        DECODE(c.cntr_no, null , null , c.cntr_tpsz_cd ) ,     	
                        null                        ,     	
                        c.cost_act_grp_cd           ,     	
                        null                        ,     	
                        c.cost_act_grp_seq          ,     	
                        null                        ,     	
                        c.coa_cost_src_cd           ,     	
                        null                        ,     	
                        c.n1st_nod_cd               ,     	
                        null                        ,     	
                        c.n2nd_nod_cd               ,     	
                        null                        ,     	
                        c.n3rd_nod_cd               ,     	
                        null                        ,     	
                        c.n4th_nod_cd               ,     	
                        null                        ,     	
                        c.sum_usd_cost              ,     	
                        0                           ,     	
                        0                           ,     	
                        0                           ,
                        'BK'                        ,   	
                        sysdate                     , 
                        c.cre_dt                     
                FROM DUAL );   
                END IF;
                
            ELSIF v_map_cd = 'B' OR v_map_cd = 'R' OR v_map_cd = 'C' THEN

                INSERT INTO lea_csr_mntr
                (SELECT c.exe_yrmon                 ,       
                        c.inv_sys_id                ,     	
                        c.if_seq                    ,     	
                        c.gl_dt                     ,     	
                        c.csr_no                    ,     	
                        c.inv_no                    ,     	
                        c.inv_ofc                   ,     	
                        c.rev_yrmon                 ,     	
                        c.vsl_cd 					,		
                        c.skd_voy_no 				,		
                        c.skd_dir_cd 				,		
                        c.rev_dir_cd    			,		
                        null     					,		
                        null         				,		
                        null         				,		
                        null         				,	
                        DECODE(v_map_cd , 'B' , c.bkg_no ,
                                          'R' , null , 
                                          'C' , null , 'XX' ),
                        null                        ,
                        c.cntr_no                   ,     	
                        DECODE(c.cntr_no, null , null , c.cntr_tpsz_cd ) ,     	
                        null                        ,     	
                        c.cost_act_grp_cd           ,     	
                        null                        ,     	
                        c.cost_act_grp_seq          ,     	
                        null                        ,     	
                        c.coa_cost_src_cd           ,     	
                        null                        ,     	
                        c.n1st_nod_cd               ,     	
                        null                        ,     	
                        c.n2nd_nod_cd               ,     	
                        null                        ,     	
                        c.n3rd_nod_cd               ,     	
                        null                        ,     	
                        c.n4th_nod_cd               ,     	
                        null                        ,     	
                        c.sum_usd_cost              ,     	
                        0                           ,     	
                        0                           ,     	
                        0                           ,
                        'NE'                        ,   	
                        sysdate                     , 
                        c.cre_dt                     
                FROM DUAL );   
                
            ELSE 
                NULL;      
            END IF; 
                
        COMMIT; ------->?

        EXCEPTION 
            WHEN OTHERS THEN 
                v_lng_rtn := TO_CHAR (SQLCODE); 
                v_str_desc := SUBSTR (SQLERRM, 1, 100);                 
--                dbms_output.put_line ('EXCPT '||v_exe_yrmon ||' '||v_if_seq||' '||v_prc_tp||' '||v_lng_rtn||' '||v_str_desc);
                ROLLBACK TO savept; 
        END;

    <<end_loop>>
    COMMIT; 
       
    END LOOP; 

EXCEPTION 
    WHEN OTHERS THEN
        v_lng_rtn := TO_CHAR (SQLCODE); 
        v_str_desc := SUBSTR (SQLERRM, 1, 100);        
--        dbms_output.put_line (v_exe_yrmon ||' '||v_if_seq||' '||v_lng_rtn||' '||v_str_desc);
        ROLLBACK TO savept1; 
END;