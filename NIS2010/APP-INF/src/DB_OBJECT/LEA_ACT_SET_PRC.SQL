CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACT_SET_PRC     
(        
    v_exe_yrmon  in  VARCHAR2     
)     
IS     
     
/*  
  1.Object Name      : LEA_ACT_SET_PRC  
  2.Version          : 1.0 
  3.Create Date      : 2007-03-06 
  4.Sub System       : Logistics Expense Accrual 
  5.Author           : 전재홍 
  6.Description      : TES/TRS Source Data (LEA_ACT_COST_IF)의 기본정보 생성(Rev.Month, USD 변환, Rep.Account 등) 
  7.Revision History :  
     2007-03-06 : 전재홍 - 최초 생성    
     2008-01-17 : 내부거래단가 적용방식 변경(기존 Cost Code 변환 로직 삭제 )  
     2008-01-22 : CNTR BKG HISTORY 에 REV.MONTH 추가  
     2008-02-18 : ACT_VVD_CD VALUE 9자리로 SETTING 추가  
     2009-02-26 : 수행월의 연도 변경시 , Rev.Month 범위가 매핑/배부 대상 외의 경우에는  
                  act_cost_mapg_cd = 'S' 로 Setting 하여 Report 조회시 Summary 대상으로 포함시킨다.  
                  이럴경우 전년도 12월 수행월의 REV VVD 가 필요함(GL_ESTM_REV_VVD)
     2009-10-09 : TMNDTS 일경우 TTL_INV_KNT =2 로 UPDATE 로직 제거
     
                    
*/     
     
    v_lng_rtn  VARCHAR2(20);     
    v_str_desc VARCHAR2(200);     
     
    sql_cnt NUMBER;     
       
--    v_suc_cnt  NUMBER := 0 ;     
--    v_err_cnt  NUMBER := 0 ;     
     
BEGIN     
     
    lea_log_prc ('lea_act_set_prc() start.');     
         
    for m in 1..to_number(substr(v_exe_yrmon,5,2))     
    loop     
       LEA_BKUP_PKG.set_indexes_unusable_prc('XAK1LEA_ACT_COST_IF', 'P'||substr(v_exe_yrmon,1,4)||trim(to_char(m, '00'))) ;     
       LEA_BKUP_PKG.set_indexes_unusable_prc('XAK2LEA_ACT_COST_IF', 'P'||substr(v_exe_yrmon,1,4)||trim(to_char(m, '00'))) ;     
    end loop ;     
         
         
        
    /* 오류항차 정제 A->B aval_flg:Y */     
    merge into lea_act_cost_if a     
    using     
        ( select    
        i.rowid RID, e.corr_vsl_cd, e.corr_skd_voy_no, e.corr_skd_dir_cd, e.corr_rev_dir_cd     
        from lea_act_cost_if i, gl_err_vvd e     
        where i.exe_yrmon between substr(v_exe_yrmon, 1, 4) and v_exe_yrmon     
--        AND i.rev_yrmon between substr(v_exe_yrmon, 1, 4) and v_exe_yrmon     
        and i.vsl_cd = e.err_vsl_cd     
        and i.skd_voy_no = e.err_skd_voy_no     
        and i.skd_dir_cd = e.err_skd_dir_cd     
        and i.rev_dir_cd = e.err_rev_dir_cd     
        and i.act_cost_mapg_cd = 'N'     
        and e.aval_flg = 'Y'     
        order by RID ) u     
    on (a.rowid = u.RID)     
    when matched then     
    update set  a.vsl_cd = u.corr_vsl_cd,     
                a.skd_voy_no = u.corr_skd_voy_no,      
                a.skd_dir_cd = u.corr_skd_dir_cd,     
                a.rev_dir_cd = u.corr_rev_dir_cd,      
                a.err_vvd_aply_flg = 'Y'     
    ;     
         
    sql_cnt := SQL%ROWCOUNT;     
         
    Commit;     
     
    APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACT_SET_PRC:FIX_ERR_VVD(A->B)  완료(' || sql_cnt || '건)') ; -- 시간 측정을 위한 디버깅 코드        
         
    /* 오류항차 정제 A<-B aval_flg:N */     
    merge into lea_act_cost_if a     
    using     
        ( select    
        i.rowid RID, e.err_vsl_cd, e.err_skd_voy_no, e.err_skd_dir_cd, e.err_rev_dir_cd     
        from lea_act_cost_if i, gl_err_vvd e     
        where i.exe_yrmon between substr(v_exe_yrmon, 1, 4) and v_exe_yrmon     
--        AND i.rev_yrmon between substr(v_exe_yrmon, 1, 4) and v_exe_yrmon     
        and i.vsl_cd = e.corr_vsl_cd     
        and i.skd_voy_no = e.corr_skd_voy_no     
        and i.skd_dir_cd = e.corr_skd_dir_cd     
        and i.rev_dir_cd = e.corr_rev_dir_cd     
        and i.act_cost_mapg_cd = 'N'     
        and e.aval_flg = 'N'     
        order by RID ) u     
    on (a.rowid = u.RID)     
    when matched then     
    update set  a.vsl_cd = u.err_vsl_cd ,     
                a.skd_voy_no = u.err_skd_voy_no,      
                a.skd_dir_cd = u.err_skd_dir_cd,     
                a.rev_dir_cd = u.err_rev_dir_cd,      
                a.err_vvd_aply_flg = 'Y'     
    ;         
         
    sql_cnt := SQL%ROWCOUNT;     
         
    Commit;     
     
    APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACT_SET_PRC:FIX_ERR_VVD(A<-B)  완료(' || sql_cnt || '건)') ; -- 시간 측정을 위한 디버깅 코드        
         
  
    --내부거래 관련 Cost code, Account code 변환   (2008/01/17 삭제)  
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
--        and a.exe_yrmon between substr(v_exe_yrmon, 1, 4) and v_exe_yrmon     
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
--    sql_cnt := SQL%ROWCOUNT;     
--         
--    Commit;     
         
--    APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACT_SET_PRC:내부거래변환  완료(' || sql_cnt || '건)') ; -- 시간 측정을 위한 디버깅 코드     
  
    -- CNTR BKG HISTORY REV. MONTH 추가 (결산시점에 확정된 rev.month 사용하기 위해 별도로 udpate 함)  
    merge   
    into lea_cntr_bkg_his a  
    using (  
             select exe_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, max(rev_yrmon) rev_yrmon     
             from    gl_estm_rev_vvd     
             where   estm_bc_div_cd in ('C', 'M')  
             and exe_yrmon = v_exe_yrmon     
             and estm_vvd_tp_cd in  ('RV','BV')     
             group by exe_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd           
          )  b  
    on (a.cntr_atch_dt >= TO_DATE('20091001', 'YYYYMMDD') and   
        a.vsl_cd = b.vsl_cd and   
        a.skd_voy_no = b.skd_voy_no and   
        a.skd_dir_cd = b.skd_dir_cd and   
        a.rev_dir_cd = b.rev_dir_cd)  
    when matched then     
    update set a.rev_yrmon = b.rev_yrmon  
    ; -- index!!  
      
    commit;   
      
         
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
                    ,vvd.rev_yrmon vvd_rev_yrmon     
                    ,greatest(vvd.rev_yrmon, a.exe_yrmon) xch_yrmon     
                    ,decode(a.otr_crr_flg, 'Y', cost_cd.otr_crr_rep_acct_cd , cost_cd.rep_acct_cd) cost_acct_cd     
                from    lea_act_cost_if a,     
                        (select exe_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd, max(rev_yrmon) rev_yrmon     
                         from    gl_estm_rev_vvd     
                         where   estm_bc_div_cd in ('C', 'M')  
                         and exe_yrmon in ( v_exe_yrmon , TO_CHAR(ADD_MONTHS(TO_DATE(v_exe_yrmon,'yyyymm') ,-12 ), 'yyyy') || '12')   
                         and estm_vvd_tp_cd in  ('RV','BV')     
                         group by exe_yrmon, vsl_cd, skd_voy_no, skd_dir_cd, rev_dir_cd)  vvd,     
                        (select coa_cost_src_cd, otr_crr_rep_acct_cd, rep_acct_cd     
                         from lea_lgs_cost     
                         where delt_flg = 'N') cost_cd     
                where 1 = 1                    
                and a.exe_yrmon between substr(v_exe_yrmon, 1, 4) and v_exe_yrmon     
                and a.rev_yrmon is null  
                and vvd.exe_yrmon in ( v_exe_yrmon , TO_CHAR(ADD_MONTHS(TO_DATE(v_exe_yrmon,'yyyymm') ,-12 ), 'yyyy') || '12')  
--                and a.exe_yrmon   =   vvd.exe_yrmon     
                and a.vsl_cd      =   vvd.vsl_cd    
                and a.skd_voy_no  =   vvd.skd_voy_no     
                and a.skd_dir_cd  =   vvd.skd_dir_cd     
                and a.rev_dir_cd  =   vvd.rev_dir_cd    
                and a.coa_cost_src_cd =   cost_cd.coa_cost_src_cd     
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
                    A.act_vvd_cd = SUBSTR(A.act_vvd_cd  ,1, 9),  
                    A.rep_acct_cd = cost_acct_cd,     
                    A.usd_cost_amt = usd_amt,     
                    A.n3rd_nod_cd = decode(A.n3rd_nod_cd ,  null, ' ' , decode(A.inv_sys_id , 'TES', ' ', A.n3rd_nod_cd)),     
                    A.n4th_nod_cd = decode(A.n4th_nod_cd ,  null, ' ' , decode(A.inv_sys_id , 'TES', ' ', A.n4th_nod_cd)),   
--                    A.ttl_inv_knt = decode(A.coa_cost_src_cd, 'TMNDTS' , 2 , A.ttl_inv_knt ),  
                    A.act_cost_mapg_cd = CASE WHEN vvd_rev_yrmon BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(v_exe_yrmon,'yyyymm') ,-12 ), 'yyyy') ||'01'  
                                                                 AND CASE WHEN SUBSTR(v_exe_yrmon, 5 ,2 ) IN ('01','02','03')  
                                                                             THEN TO_CHAR(ADD_MONTHS(TO_DATE(v_exe_yrmon, 'yyyymm'), -4), 'yyyymm')  
                                                                          ELSE TO_CHAR(ADD_MONTHS(TO_DATE(v_exe_yrmon,'yyyymm') ,-12 ), 'yyyy') || '12'  
                                                                     END   
                                                THEN 'S'   
                                              ELSE A.act_cost_mapg_cd  
                                         END   
                    ;     
                 
     
    sql_cnt := SQL%ROWCOUNT;     
    lea_log_prc(sql_cnt||' Rows Successfully Updated.');     
    Commit;     
     
    APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACT_SET_PRC:환율(USD)변환 완료(' || sql_cnt || '건)') ; -- 시간 측정을 위한 디버깅 코드             
         
    for m in 1..to_number(substr(v_exe_yrmon,5,2))     
    loop     
       LEA_BKUP_PKG.rebuild_indexes_prc('XAK1LEA_ACT_COST_IF', 'P'||substr(v_exe_yrmon,1,4)||trim(to_char(m, '00'))) ;     
       LEA_BKUP_PKG.rebuild_indexes_prc('XAK2LEA_ACT_COST_IF', 'P'||substr(v_exe_yrmon,1,4)||trim(to_char(m, '00'))) ;     
    end loop ;     
         
    APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACT_SET_PRC:IND_PART_REBUILD 완료') ; -- 시간 측정을 위한 디버깅 코드             
         
    lea_log_prc ('lea_act_set_prc() end.');     
         
   /* Exception -----------------------------------------------------------------*/     
   EXCEPTION     
   WHEN OTHERS     
   THEN     
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);       
--    v_lng_rtn   := TO_CHAR(SQLCODE);     
--    v_str_desc  := '[LEA_ACT_SET_PRC]:'||SUBSTR(SQLERRM, 1, 100);     
--         
--    dbms_output.put_line('Exception :' || v_lng_rtn || v_str_desc );     
         
--    ROLLBACK;     
     
END;