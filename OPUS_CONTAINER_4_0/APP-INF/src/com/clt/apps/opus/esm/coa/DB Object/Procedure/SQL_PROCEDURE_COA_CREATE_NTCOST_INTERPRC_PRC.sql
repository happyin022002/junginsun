CREATE OR REPLACE PROCEDURE  COA_CREATE_NTCOST_INTERPRC_PRC (
   in_step_flg      IN       VARCHAR2
  ,in_mon_or_wk     IN       VARCHAR2
  ,in_yr            IN       VARCHAR2
  ,in_fm_mon        IN       VARCHAR2
  ,in_to_mon        IN       VARCHAR2
  ,in_fm_wk         IN       VARCHAR2
  ,in_to_wk         IN       VARCHAR2
  ,in_trd_cd        IN       VARCHAR2
  ,in_rlane_cd      IN       VARCHAR2
  ,in_vsl_cd        IN       VARCHAR2
  ,in_skd_voy_no    IN       VARCHAR2
  ,in_dir_cd        IN       VARCHAR2
  ,in_user_id       IN       VARCHAR2
  ,out_error_code   OUT      VARCHAR2
  ,out_error_msg    OUT      VARCHAR2
)
Authid current_user
IS
   /*
     1.Name       : COA_CREATE_NTCOST_INTERPRC_PRC
     2.Create Date: 2010.10.22
     3.Description:
     4.Revision History
         1) 2010.10.22 : 최초 생성 - 이행지 [CHM-201006375-01] : [COA] Trunk IPC와 Ocean간 내부거래 신규 추가
         2) 2011.01.07 김기종 [CHM-201007912-01] 아주 노선 선복사용량에 대한 원양으로의 운항 변고정비 배부 로직(약정율) 
               - OP5,OP6적용일환으로 COA_FX_AMT_DTRB 테이블 dtrb_step_cd   = 'BZC' 조건 추가
         3) 2014.11.18 SMY Slot Internal Pricing
         4) 2015.06.08 SMY Slot Internal Pricing  From <-> To Chagne (Borrower -> Supplier basis)       
         5) 2015.06.11 SMY Re-Assignment by VVD (Adding Local IP)
      
         - 용도: 1. 선박운항 변/고정비 배부 로직

         - 파라미터: 년,월,주차,trade,revenue lane,ioc,vvd
         - 특이사항
           - Remaining Amount가 없다.

     EX)
        SELECT * FROM ENIS_LOG
        WHERE MOD_NAME = 'COA_CREATE_NTCOST_INTERPRC_PRC'
          AND EXEC_DT > SYSDATE - 1/24
        ORDER BY EXEC_DT DESC;
        
        2015.01.15 박찬민 IAS->IAT 로 하드코딩 변경
                          
   */

   ------------------------------[ 변수선언부             ]-----------------------
   v_commit_unit     PLS_INTEGER    := 10000;
   v_read_count      NUMBER(10)     := 0;
   v_log_mod_nm      VARCHAR2(30)   := 'COA_CREATE_NTCOST_INTERPRC_PRC';
   v_timestamp       TIMESTAMP;
   v_timestamp2      TIMESTAMP;
   v_timestamp3      TIMESTAMP;
   v_stnd_cost_cd    VARCHAR2(30):='54600000';
   v_stnd_cost_cd2   VARCHAR2(30):='54600001';   -- CM Slt Internal Pricing
   v_stnd_cost_cd3   VARCHAR2(30):='54600002';   -- OP Slt Internal Pricing
------------------------------- [ 업무로직 구현부] -------------------------------
BEGIN
    --/////////////////////////////////////////////////////////////////////////////////////
    -- 파라메터 로그 출력
    --/////////////////////////////////////////////////////////////////////////////////////
    enis_log_prc('', v_log_mod_nm, '[V.20150611]', NULL);
    enis_log_prc (sysdate, v_log_mod_nm, 'input param : '||in_step_flg||'-['||in_mon_or_wk
                                                    ||']['|| in_yr 
                                                    ||']['|| in_fm_mon 
                                                    ||']['|| in_to_mon 
                                                    ||']['|| in_fm_wk  
                                                    ||']['|| in_to_wk 
                                                    ||']['|| in_trd_cd 
                                                    ||']['|| in_rlane_cd 
                                                    ||']['|| in_vsl_cd 
                                                    ||']['|| in_skd_voy_no 
                                                    ||']['|| in_dir_cd 
                                                    ||']['|| in_user_id 
                                                    ||']','');
    /* 
     * UI ID    : ESM_COA_0180
     * UI Title : Re-Assignment by Bound(Internal Pricing) 
     * Creation 적용시 호출
     */
    IF (in_step_flg = '1') THEN
        --////////////////////////////////////////////////////////////////////////////////////
        -- 1-1. 비용 삭제
        --////////////////////////////////////////////////////////////////////////////////////
        DELETE
          FROM  COA_INTER_PRC_VVD_EXPN
         WHERE  1=1
           AND  (trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd) 
                IN  (
                    SELECT trd_cd
                        ,   rlane_cd
                        ,   ioc_cd
                        ,   vsl_cd
                        ,   skd_voy_no
                        ,   dir_cd
                      FROM  COA_MON_VVD
                     WHERE  1=1
                       AND  DECODE(in_mon_or_wk, 'W', SUBSTR(sls_yrmon,1,4), SUBSTR(cost_yrmon,1,4)) = in_yr
                       AND  DECODE(in_mon_or_wk, 'W', cost_wk, SUBSTR(cost_yrmon,5,2))
                                   BETWEEN DECODE(in_mon_or_wk, 'W',in_fm_wk,in_fm_mon) 
                                       AND DECODE(in_mon_or_wk, 'W',in_to_wk,in_to_mon)
                       AND  trd_cd     = NVL(in_trd_cd,     trd_cd)
                       AND  rlane_cd   = NVL(in_rlane_cd,   rlane_cd)
                       AND  vsl_cd     = NVL(in_vsl_cd,     vsl_cd)
                       AND  skd_voy_no = NVL(in_skd_voy_no, skd_voy_no)
                       AND  dir_cd     = NVL(in_dir_cd,     dir_cd)
                    )
           AND  stnd_cost_cd = v_stnd_cost_cd
        ;
        
        enis_log_prc('', v_log_mod_nm, 'COA_INTER_PRC_VVD_EXPN : ' || SQL%ROWCOUNT || ' 건 삭제', NULL);
        
        --////////////////////////////////////////////////////////////////////////////////////
        -- 1-2. 비용 생성 (COA_INTER_PRC_VVD_EXPN)
        --////////////////////////////////////////////////////////////////////////////////////
        INSERT INTO COA_INTER_PRC_VVD_EXPN
        (   trd_cd
         ,  rlane_cd
         ,  ioc_cd 
         ,  vsl_cd 
         ,  skd_voy_no
         ,  dir_cd
         ,  stnd_cost_cd
         ,  inter_prc_uc_amt
         ,  cntr_lod_qty
         ,  inter_prc_ttl_expn_amt
         ,  cost_calc_rmk
         ,  cre_usr_id
         ,  cre_dt
         ,  upd_usr_id
         ,  upd_dt
        )
        
        SELECT  trd_cd
            ,   rlane_cd
            ,   ioc_cd
            ,   vsl_cd
            ,   skd_voy_no
            ,   dir_cd
            ,   v_stnd_cost_cd                          AS stnd_cost_cd
            ,   inter_prc_uc_amt
            ,   cntr_lod_qty
            ,   inter_prc_uc_amt * cntr_lod_qty         AS inter_prc_ttl_expn_amt
            ,   inter_prc_uc_amt || '*' || cntr_lod_qty AS cost_calc_rmk
            ,   in_user_id
            ,   SYSDATE
            ,   in_user_id
            ,   SYSDATE
          FROM  (
                SELECT  mst.trd_cd
                    ,   mst.rlane_cd
                    ,   mst.ioc_cd
                    ,   mst.vsl_cd
                    ,   mst.skd_voy_no
                    ,   mst.dir_cd
                    ,   uc.inter_prc_uc_amt
                    ,   SUM(NVL(dtl.bkg_qty,0)) cntr_lod_qty
                  FROM  COA_MON_VVD           MST
                     ,  COA_RGST_BKG          B
                     ,  COA_BKG_REV_DTL       DTL
                     ,  COA_INTER_PRC_UT_COST UC
                 WHERE  1 = 1
                   AND  mst.trd_cd        = b.trd_cd
                   AND  mst.rlane_cd      = b.rlane_cd
                   AND  mst.ioc_cd        = b.ioc_cd
                   AND  mst.vsl_cd        = b.vsl_cd
                   AND  mst.skd_voy_no    = b.skd_voy_no
                   AND  mst.dir_cd        = b.dir_cd
                   AND  b.bkg_no          = dtl.bkg_no
                   AND  SUBSTR(mst.rlane_cd,4,2) = SUBSTR(uc.trd_cd,1,2)
                   AND  DECODE(in_mon_or_wk, 'W', mst.sls_yrmon, mst.cost_yrmon)    = uc.cost_yrmon
                   
                   AND  mst.delt_flg      = 'N'
                   AND  dtl.delt_flg      = 'N'
                   AND  b.bkg_sts_cd      IN ('F', 'S')
                   AND  b.bkg_cgo_tp_cd   <> 'P'
                   AND  b.bl_no_tp        IN ('M', '0')  
                               
                   AND  mst.trd_cd        = 'IAT'
                   AND  mst.sub_trd_cd    = 'IP'
                   AND  DECODE(in_mon_or_wk, 'W', SUBSTR(mst.sls_yrmon,1,4), SUBSTR(mst.cost_yrmon,1,4)) = in_yr
                   AND  DECODE(in_mon_or_wk, 'W', mst.cost_wk, SUBSTR(mst.cost_yrmon,5,2))
                                           BETWEEN DECODE(in_mon_or_wk, 'W', in_fm_wk, in_fm_mon) 
                                               AND DECODE(in_mon_or_wk, 'W', in_to_wk, in_to_mon)           
                 GROUP BY   mst.trd_cd
                          , mst.sub_trd_cd
                          , mst.rlane_cd
                          , mst.ioc_cd
                          , mst.vsl_cd
                          , mst.skd_voy_no
                          , mst.dir_cd
                          , uc.inter_prc_uc_amt
        );
        
        enis_log_prc('', v_log_mod_nm, 'COA_INTER_PRC_VVD_EXPN : ' || SQL%ROWCOUNT || ' 건 삽입', NULL);
        
        --////////////////////////////////////////////////////////////////////////////////////
        -- 1-3. COA_VVD_HIR 초기화
        --////////////////////////////////////////////////////////////////////////////////////
--        UPDATE    COA_VVD_HIR
--           SET    ntwk_hir_cost_amt   = 0
--         WHERE    (trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd)
--                  IN  (
--                  SELECT trd_cd
--                      ,   rlane_cd
--                      ,   ioc_cd
--                      ,   vsl_cd
--                      ,   skd_voy_no
--                      ,   dir_cd
--                    FROM  COA_MON_VVD
--                   WHERE  1=1
--                     AND  DECODE(in_mon_or_wk, 'W', SUBSTR(sls_yrmon,1,4), SUBSTR(cost_yrmon,1,4)) = in_yr
--                     AND  DECODE(in_mon_or_wk, 'W', cost_wk, SUBSTR(cost_yrmon,5,2))
--                                 BETWEEN DECODE(in_mon_or_wk, 'W',in_fm_wk,in_fm_mon) 
--                                     AND DECODE(in_mon_or_wk, 'W',in_to_wk,in_to_mon)
--                     AND  trd_cd     = NVL(in_trd_cd,     trd_cd)
--                     AND  rlane_cd   = NVL(in_rlane_cd,   rlane_cd)
--                     AND  vsl_cd     = NVL(in_vsl_cd,     vsl_cd)
--                     AND  skd_voy_no = NVL(in_skd_voy_no, skd_voy_no)
--                     AND  dir_cd     = NVL(in_dir_cd,     dir_cd)
--                  )
--           AND  stnd_cost_cd = v_stnd_cost_cd
--        ;
        
        enis_log_prc('', v_log_mod_nm, 'COA_VVD_HIR : ' || SQL%ROWCOUNT || ' 건 초기화', NULL);
        --////////////////////////////////////////////////////////////////////////////////////
        -- 1-4. COA_VVD_HIR Merge
        --////////////////////////////////////////////////////////////////////////////////////
        MERGE INTO COA_VVD_HIR VVD_HIR
            USING (
                SELECT  a.trd_cd
                     ,  a.rlane_cd
                     ,  a.ioc_cd 
                     ,  a.vsl_cd 
                     ,  a.skd_voy_no
                     ,  a.dir_cd
                     ,  a.stnd_cost_cd
                     ,  a.inter_prc_ttl_expn_amt 
                  FROM  COA_INTER_PRC_VVD_EXPN A
                    ,   COA_MON_VVD B
                 WHERE  1=1
                   AND  a.trd_cd        = b.trd_cd
                   AND  a.rlane_cd      = b.rlane_cd
                   AND  a.ioc_cd        = b.ioc_cd
                   AND  a.vsl_cd        = b.vsl_cd
                   AND  a.skd_voy_no    = b.skd_voy_no
                   AND  a.dir_cd        = b.dir_cd
                   AND  DECODE(in_mon_or_wk, 'W', SUBSTR(b.sls_yrmon,1,4), SUBSTR(b.cost_yrmon,1,4)) = in_yr
                   AND  DECODE(in_mon_or_wk, 'W', b.cost_wk, SUBSTR(b.cost_yrmon,5,2))
                                   BETWEEN DECODE(in_mon_or_wk, 'W',in_fm_wk,in_fm_mon) 
                                       AND DECODE(in_mon_or_wk, 'W',in_to_wk,in_to_mon)
                   AND  a.trd_cd        = NVL(in_trd_cd,     a.trd_cd)
                   AND  a.rlane_cd      = NVL(in_rlane_cd,   a.rlane_cd)
                   AND  a.vsl_cd        = NVL(in_vsl_cd,     a.vsl_cd)
                   AND  a.skd_voy_no    = NVL(in_skd_voy_no, a.skd_voy_no)
                   AND  a.dir_cd        = NVL(in_dir_cd,     a.dir_cd)
                   AND  a.stnd_cost_cd  = v_stnd_cost_cd
                   ) VVD_EXPN
            ON  (   vvd_hir.trd_cd      = vvd_expn.trd_cd
                AND vvd_hir.rlane_cd    = vvd_expn.rlane_cd
                AND vvd_hir.ioc_cd      = vvd_expn.ioc_cd
                AND vvd_hir.vsl_cd      = vvd_expn.vsl_cd
                AND vvd_hir.skd_voy_no  = vvd_expn.skd_voy_no
                AND vvd_hir.dir_cd      = vvd_expn.dir_cd
                AND vvd_hir.stnd_cost_cd= vvd_expn.stnd_cost_cd
                )
            WHEN MATCHED THEN
                UPDATE
                  SET   ntwk_hir_cost_amt  = inter_prc_ttl_expn_amt 
                   ,    upd_usr_id         = in_user_id
                   ,    upd_dt             = SYSDATE
            WHEN NOT MATCHED THEN
                INSERT ( trd_cd,rlane_cd,ioc_cd,vsl_cd,skd_voy_no,dir_cd,stnd_cost_cd
                        ,ntwk_hir_cost_amt,cre_usr_id,cre_dt,upd_usr_id,upd_dt)
                VALUES ( vvd_expn.trd_cd, vvd_expn.rlane_cd,vvd_expn.ioc_cd,vvd_expn.vsl_cd,vvd_expn.skd_voy_no,vvd_expn.dir_cd,v_stnd_cost_cd
                        ,vvd_expn.inter_prc_ttl_expn_amt,in_user_id,SYSDATE,in_user_id,SYSDATE)
            ;
        
        enis_log_prc('', v_log_mod_nm, 'COA_VVD_HIR : ' || SQL%ROWCOUNT || ' 건 Merge', NULL);
    END IF;


    /* 
     * UI ID    : ESM_COA_4002
     * UI Title : Re-Assignment by VVD(Slot Internal Pricing) 
     * Creation 적용시 호출
     */
    IF (in_step_flg = '4') THEN
        --////////////////////////////////////////////////////////////////////////////////////
        -- 1-1. 비용 삭제
        --////////////////////////////////////////////////////////////////////////////////////
        DELETE
          FROM  COA_INTER_PRC_VVD_EXPN
         WHERE  1=1
           AND  (trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd) 
                IN  (
                    SELECT trd_cd
                        ,   rlane_cd
                        ,   ioc_cd
                        ,   vsl_cd
                        ,   skd_voy_no
                        ,   dir_cd
                      FROM  COA_MON_VVD
                     WHERE  1=1
                       AND  DECODE(in_mon_or_wk, 'W', SUBSTR(sls_yrmon,1,4), SUBSTR(cost_yrmon,1,4)) = in_yr
                       AND  DECODE(in_mon_or_wk, 'W', cost_wk, SUBSTR(cost_yrmon,5,2))
                                   BETWEEN DECODE(in_mon_or_wk, 'W',in_fm_wk,in_fm_mon) 
                                       AND DECODE(in_mon_or_wk, 'W',in_to_wk,in_to_mon)
                       AND  trd_cd     = NVL(in_trd_cd,     trd_cd)
                       AND  rlane_cd   = NVL(in_rlane_cd,   rlane_cd)
                       AND  vsl_cd     = NVL(in_vsl_cd,     vsl_cd)
                       AND  skd_voy_no = NVL(in_skd_voy_no, skd_voy_no)
                       AND  dir_cd     = NVL(in_dir_cd,     dir_cd)
                    )
           AND  stnd_cost_cd = v_stnd_cost_cd3
        ;
        
        enis_log_prc('', v_log_mod_nm, 'COA_INTER_PRC_VVD_EXPN : ' || SQL%ROWCOUNT || ' count deleted', NULL);
        
        --////////////////////////////////////////////////////////////////////////////////////
        -- 1-2. 비용 생성 (COA_INTER_PRC_VVD_EXPN)
        --////////////////////////////////////////////////////////////////////////////////////
--        INSERT INTO COA_INTER_PRC_VVD_EXPN
--        (   trd_cd
--         ,  rlane_cd
--         ,  ioc_cd 
--         ,  vsl_cd 
--         ,  skd_voy_no
--         ,  dir_cd
--         ,  to_trd_cd
--         ,  to_rlane_cd
--         ,  to_ioc_cd
--         ,  to_vsl_cd
--         ,  to_skd_voy_no
--         ,  to_skd_dir_cd 
--         ,  stnd_cost_cd
--         ,  inter_prc_uc_amt
--         ,  cntr_lod_qty
--         ,  inter_prc_ttl_expn_amt
--         ,  cost_calc_rmk
--         ,  cre_usr_id
--         ,  cre_dt
--         ,  upd_usr_id
--         ,  upd_dt
--        )
        MERGE INTO coa_inter_prc_vvd_expn a1
        USING (
           -- 2015.06.08 SMY 
           WITH
           T_VVD AS (
              
              SELECT  
                      mst.trd_cd
                  ,   mst.rlane_cd
                  ,   mst.ioc_cd
                  ,   mst.vsl_cd
                  ,   mst.skd_voy_no
                  ,   mst.dir_cd
                  ,   mst.sub_trd_cd
                  ,   mst.vsl_cd||mst.skd_voy_no||mst.dir_cd  vvd_cd
                FROM  COA_MON_VVD           MST
               WHERE  1 = 1
                 AND  mst.delt_flg      = 'N'
                 AND  DECODE(in_mon_or_wk, 'W', SUBSTR(mst.sls_yrmon,1,4), SUBSTR(mst.cost_yrmon,1,4)) = in_yr
                 AND  DECODE(in_mon_or_wk, 'W', mst.cost_wk, SUBSTR(mst.cost_yrmon,5,2))
                                         BETWEEN DECODE(in_mon_or_wk, 'W', in_fm_wk, in_fm_mon) 
                                             AND DECODE(in_mon_or_wk, 'W', in_to_wk, in_to_mon)    
          
                 AND  mst.trd_cd     = NVL(in_trd_cd,     mst.trd_cd)
                 AND  mst.rlane_cd   = NVL(in_rlane_cd,   mst.rlane_cd)
                 AND  mst.vsl_cd     = NVL(in_vsl_cd,     mst.vsl_cd)
                 AND  mst.skd_voy_no = NVL(in_skd_voy_no, mst.skd_voy_no)
                 AND  mst.dir_cd     = NVL(in_dir_cd,     mst.dir_cd)
                 
           )  
            SELECT      -- 2015.06.11 ADD IP Logic
                        NVL(DECODE(c.sub_trd_cd, 'IP', d.trd_cd, a.trd_cd),a.trd_cd) trd_cd
                    ,   a.rlane_cd
                    ,   NVL(DECODE(c.sub_trd_cd, 'IP', d.ioc_cd, a.ioc_cd),a.ioc_cd) ioc_cd
                    ,   a.vsl_cd
                    ,   a.skd_voy_no            
                    ,   a.dir_cd             
                    ,   a.to_trd_cd
                    ,   c.sub_trd_cd
                    ,   a.to_rlane_cd
                    ,   a.to_ioc_cd
                    ,   a.to_vsl_cd
                    ,   a.to_skd_voy_no
                    ,   a.to_skd_dir_cd
                    ,   a.stnd_cost_cd
                    ,   a.inter_prc_uc_amt
                    ,   a.cntr_lod_qty
                    ,   a.inter_prc_ttl_expn_amt
                    ,   a.cost_calc_rmk 
            
              FROM 
              (  
                SELECT  trd_cd
                    ,   rlane_cd
                    ,   DECODE ( SUBSTR(ioc_cd,1,1), SUBSTR(ioc_cd,2,1), 'I','O') ioc_cd
                    ,   SUBSTR(vvd_cd,1,4) vsl_cd
                    ,   SUBSTR(vvd_cd,5,4) skd_voy_no            
                    ,   SUBSTR(vvd_cd,9,1) dir_cd             
                    ,   to_trd_cd
                    ,   to_rlane_cd
                    ,   to_ioc_cd
                    ,   to_vsl_cd
                    ,   to_skd_voy_no
                    ,   to_skd_dir_cd
                    ,   v_stnd_cost_cd3                          AS stnd_cost_cd
                    ,   SUM(inter_prc_ttl_expn_amt)/SUM(cntr_lod_qty) inter_prc_uc_amt
                    ,   SUM(cntr_lod_qty) cntr_lod_qty
                    ,   SUM(inter_prc_ttl_expn_amt) inter_prc_ttl_expn_amt
                    ,   '' cost_calc_rmk

                  FROM  (                 
                         
                        
                        SELECT 
                             NVL(uc.cntr_qty,0) cntr_lod_qty                    
                            ,uc.estm_usd_ttl_amt inter_prc_ttl_expn_amt 
                            ,uc.estm_usd_uc_amt  inter_prc_uc_amt
                            ,uc.ts_seq
                            ,DECODE(uc.ts_seq, 1, b.N1ST_TRD_CD, 2,b.N2ND_TRD_CD, 3,b.N3RD_TRD_CD, b.N4TH_TRD_CD)  trd_cd
                            ,DECODE(uc.ts_seq, 1, b.N1ST_RLANE_CD, 2,b.N2ND_RLANE_CD, 3,b.N3RD_RLANE_CD, b.N4TH_RLANE_CD) rlane_cd                    
                            ,DECODE(uc.ts_seq, 1, b.N1ST_IOC_CONTI_CD, 2,b.N2ND_IOC_CONTI_CD, 3,b.N3RD_IOC_CONTI_CD, b.N4TH_IOC_CONTI_CD) ioc_cd                                        
                            ,SUBSTR(DECODE(uc.ts_seq, 1, b.N1ST_FINC_VVD_CD, 2,b.N2ND_FINC_VVD_CD, 3,b.N3RD_FINC_VVD_CD, b.N4TH_FINC_VVD_CD),1,9) vvd_cd                                    
                            ,b.trd_cd     to_trd_cd
                            ,b.rlane_cd   to_rlane_cd
                            ,b.ioc_cd     to_ioc_cd
                            ,b.vsl_cd     to_vsl_cd
                            ,b.skd_voy_no to_skd_voy_no
                            ,b.dir_cd     to_skd_dir_cd           
                       
                         FROM 
                         (
                       
                            SELECT distinct
                                    b1.bkg_no
                                   ,b1.trd_cd
                                   ,b1.rlane_cd
                                   ,b1.ioc_cd
                                   ,b1.vsl_cd
                                   ,b1.skd_voy_no
                                   ,b1.dir_cd                          
                                   ,b1.n1st_trd_cd
                                   ,b1.n2nd_trd_cd
                                   ,b1.n3rd_trd_cd
                                   ,b1.n4th_trd_cd 
                                   ,b1.n1st_rlane_cd
                                   ,b1.n2nd_rlane_cd
                                   ,b1.n3rd_rlane_cd
                                   ,b1.n4th_rlane_cd 
                                   ,b1.n1st_ioc_conti_cd
                                   ,b1.n2nd_ioc_conti_cd
                                   ,b1.n3rd_ioc_conti_cd
                                   ,b1.n4th_ioc_conti_cd 
                                   ,b2.n1st_finc_vvd_cd
                                   ,b2.n2nd_finc_vvd_cd
                                   ,b2.n3rd_finc_vvd_cd
                                   ,b2.n4th_finc_vvd_cd 
                              FROM  
                                    coa_rgst_bkg          b1
                                   ,coa_bkg_expn_dtl      b2
                                   ,t_vvd                 vvd                     
                             WHERE  1 = 1
                               AND  b1.bkg_sts_cd      IN ('F', 'S', 'W')
                               AND  b1.bkg_cgo_tp_cd   <> 'P'
                               AND  b1.bl_no_tp        IN ('M', '0')  
                               AND  b1.bkg_no = b2.bkg_no
                               AND  SUBSTR(b2.sls_yrmon,1,4)||b2.cost_wk BETWEEN 
                                       (
                                           SELECT  COST_YRWK
                                             FROM (
                                                 select  LEAD (COST_YR||COST_WK,9) OVER ( ORDER BY  SLS_FM_DT DESC) COST_YRWK
                                                   from coa_wk_prd
                                                  where COST_YR||COST_WK <=  in_yr||in_fm_wk
                                             )
                                            WHERE ROWNUM = 1
                                       )  
                                       AND 
                                       (
                                           --201506
                                           SELECT  COST_YRWK
                                            FROM (
                                                select  LEAD (COST_YR||COST_WK,10) OVER ( ORDER BY  SLS_FM_DT ) COST_YRWK
                                                  from coa_wk_prd
                                                 where COST_YR||COST_WK >=  in_yr||in_to_wk
                                           )
                                           WHERE ROWNUM = 1                                                         
                                       
                                       )
                                                                   

                               AND  (b2.n1st_finc_vvd_cd = vvd.vvd_cd OR 
                                     NVL(b2.n2nd_finc_vvd_cd,'X') = vvd.vvd_cd OR
                                     NVL(b2.n3rd_finc_vvd_cd,'X') = vvd.vvd_cd OR
                                     NVL(b2.n4th_finc_vvd_cd,'X') = vvd.vvd_cd )

                         ) b,
                         coa_bkg_cost_smry     uc
                         WHERE 1=1
                           AND  b.bkg_no = uc.bkg_no
    --                       AND  b.bkg_no = 'SIN501106600'
                           AND  uc.stnd_cost_cd LIKE v_stnd_cost_cd2
                           AND  uc.estm_usd_ttl_amt > 0                   

                        )                  
                        GROUP BY  trd_cd
                              ,   rlane_cd
                              ,   DECODE ( SUBSTR(ioc_cd,1,1), SUBSTR(ioc_cd,2,1), 'I','O') 
                              ,   SUBSTR(vvd_cd,1,4) 
                              ,   SUBSTR(vvd_cd,5,4)             
                              ,   SUBSTR(vvd_cd,9,1)                      
                              ,   to_trd_cd
                              ,   to_rlane_cd
                              ,   to_ioc_cd
                              ,   to_vsl_cd
                              ,   to_skd_voy_no
                              ,   to_skd_dir_cd
                    ) a
                    ,t_vvd c
                    ,coa_mon_vvd d
                    WHERE 1=1
                   -- supplier IP sub_trd_cd join                  
                   AND  a.trd_cd      = c.trd_cd     
                   AND  a.rlane_cd    = c.rlane_cd   
                   AND  a.ioc_cd      = c.ioc_cd     
                   AND  a.vsl_cd      = c.vsl_cd     
                   AND  a.skd_voy_no  = c.skd_voy_no 
                   AND  a.dir_cd      = c.dir_cd     

                   -- ocean vvd join
                   AND  c.rlane_cd           = d.rlane_cd (+)
                   AND  c.vsl_cd             = d.vsl_cd (+)
                   AND  c.skd_voy_no         = d.skd_voy_no (+)
                   AND  c.dir_cd             = d.dir_cd(+)
                   AND  d.sub_trd_cd(+)      <> 'IP'
                   AND  d.rlane_cd(+)        <> 'RBCCO'
                   AND  d.IOC_CD (+)         = 'O'
                   AND  d.delt_flg(+)        = 'N' 

                    
                    
        ) b1
        ON  (   a1.trd_cd           = b1.trd_cd            
            AND a1.rlane_cd         = b1.rlane_cd       
            AND a1.ioc_cd           = b1.ioc_cd         
            AND a1.vsl_cd           = b1.vsl_cd         
            AND a1.skd_voy_no       = b1.skd_voy_no     
            AND a1.dir_cd           = b1.dir_cd         
            AND a1.stnd_cost_cd     = b1.stnd_cost_cd   
            AND a1.to_trd_cd        = b1.to_trd_cd      
            AND a1.to_rlane_cd      = b1.to_rlane_cd    
            AND a1.to_ioc_cd        = b1.to_ioc_cd      
            AND a1.to_vsl_cd        = b1.to_vsl_cd      
            AND a1.to_skd_voy_no    = b1.to_skd_voy_no  
            AND a1.to_skd_dir_cd    = b1.to_skd_dir_cd          
            
            )
        WHEN MATCHED THEN
            UPDATE
              SET   
                 a1.inter_prc_uc_amt           = b1.inter_prc_uc_amt         
               , a1.cntr_lod_qty               = b1.cntr_lod_qty             
               , a1.inter_prc_ttl_expn_amt     = b1.inter_prc_ttl_expn_amt   
               , a1.cost_calc_rmk              = b1.cost_calc_rmk            
               , a1.upd_usr_id                 = in_user_id
               , a1.upd_dt                     = SYSDATE           
               
        WHEN NOT MATCHED THEN
            INSERT ( 
                a1.trd_cd
             ,  a1.rlane_cd
             ,  a1.ioc_cd 
             ,  a1.vsl_cd 
             ,  a1.skd_voy_no
             ,  a1.dir_cd
             ,  a1.to_trd_cd
             ,  a1.to_rlane_cd
             ,  a1.to_ioc_cd
             ,  a1.to_vsl_cd
             ,  a1.to_skd_voy_no
             ,  a1.to_skd_dir_cd 
             ,  a1.stnd_cost_cd
             ,  a1.inter_prc_uc_amt
             ,  a1.cntr_lod_qty
             ,  a1.inter_prc_ttl_expn_amt
             ,  a1.cost_calc_rmk
             ,  a1.cre_usr_id
             ,  a1.cre_dt
             ,  a1.upd_usr_id
             ,  a1.upd_dt
            )        
            VALUES ( 
                b1.trd_cd
             ,  b1.rlane_cd
             ,  b1.ioc_cd 
             ,  b1.vsl_cd 
             ,  b1.skd_voy_no
             ,  b1.dir_cd
             ,  b1.to_trd_cd
             ,  b1.to_rlane_cd
             ,  b1.to_ioc_cd
             ,  b1.to_vsl_cd
             ,  b1.to_skd_voy_no
             ,  b1.to_skd_dir_cd 
             ,  b1.stnd_cost_cd
             ,  b1.inter_prc_uc_amt
             ,  b1.cntr_lod_qty
             ,  b1.inter_prc_ttl_expn_amt
             ,  b1.cost_calc_rmk
             ,  in_user_id
             ,  SYSDATE
             ,  in_user_id
             ,  SYSDATE
            )
        ;            
        
--        SELECT  trd_cd
--            ,   rlane_cd
--            ,   ioc_cd
--            ,   vsl_cd
--            ,   skd_voy_no
--            ,   dir_cd
--            ,   to_trd_cd
--            ,   to_rlane_cd
--            ,   DECODE ( SUBSTR(to_ioc_cd,1,1), SUBSTR(to_ioc_cd,2,1), 'I','O') to_ioc_cd
--            ,   SUBSTR(to_vvd_cd,1,4) to_vsl_cd
--            ,   SUBSTR(to_vvd_cd,5,4) to_skd_voy_no            
--            ,   SUBSTR(to_vvd_cd,9,1) to_skd_dir_cd                        
--            ,   v_stnd_cost_cd3                          AS stnd_cost_cd
--            ,   SUM(inter_prc_ttl_expn_amt)/SUM(cntr_lod_qty) inter_prc_uc_amt
--            ,   SUM(cntr_lod_qty) cntr_lod_qty
--            ,   SUM(inter_prc_ttl_expn_amt) inter_prc_ttl_expn_amt
--            ,   '' cost_calc_rmk
--            ,   in_user_id
--            ,   SYSDATE
--            ,   in_user_id
--            ,   SYSDATE
--          FROM  (
--                SELECT  mst.trd_cd
--                    ,   mst.rlane_cd
--                    ,   mst.ioc_cd
--                    ,   mst.vsl_cd
--                    ,   mst.skd_voy_no
--                    ,   mst.dir_cd
--                    ,NVL(uc.cntr_qty,0) cntr_lod_qty                    
--                    ,uc.estm_usd_ttl_amt inter_prc_ttl_expn_amt 
--                    ,uc.estm_usd_uc_amt  inter_prc_uc_amt
--                    ,uc.ts_seq
--                    ,DECODE(uc.ts_seq, 1, b.N1ST_TRD_CD, 2,b.N2ND_TRD_CD, 3,b.N3RD_TRD_CD, b.N4TH_TRD_CD) to_trd_cd
--                    ,DECODE(uc.ts_seq, 1, b.N1ST_RLANE_CD, 2,b.N2ND_RLANE_CD, 3,b.N3RD_RLANE_CD, b.N4TH_RLANE_CD) to_rlane_cd                    
--                    ,DECODE(uc.ts_seq, 1, b.N1ST_IOC_CONTI_CD, 2,b.N2ND_IOC_CONTI_CD, 3,b.N3RD_IOC_CONTI_CD, b.N4TH_IOC_CONTI_CD) to_ioc_cd                                        
--                    ,SUBSTR(DECODE(uc.ts_seq, 1, b.N1ST_FINC_VVD_CD, 2,b.N2ND_FINC_VVD_CD, 3,b.N3RD_FINC_VVD_CD, b.N4TH_FINC_VVD_CD),1,9) to_vvd_cd                    
--
--                    
--                  FROM  COA_MON_VVD           MST
--                     ,  COA_RGST_BKG          B
--                     ,  coa_bkg_cost_smry     UC
--                 WHERE  1 = 1
--                   AND  mst.trd_cd        = b.trd_cd
--                   AND  mst.rlane_cd      = b.rlane_cd
--                   AND  mst.ioc_cd        = b.ioc_cd
--                   AND  mst.vsl_cd        = b.vsl_cd
--                   AND  mst.skd_voy_no    = b.skd_voy_no
--                   AND  mst.dir_cd        = b.dir_cd
--                   AND  mst.delt_flg      = 'N'
--                   AND  b.bkg_sts_cd      IN ('F', 'S', 'W')
--                   AND  b.bkg_cgo_tp_cd   <> 'P'
--                   AND  b.bl_no_tp        IN ('M', '0')  
--                   AND  DECODE(in_mon_or_wk, 'W', SUBSTR(mst.sls_yrmon,1,4), SUBSTR(mst.cost_yrmon,1,4)) = in_yr
--                   AND  DECODE(in_mon_or_wk, 'W', mst.cost_wk, SUBSTR(mst.cost_yrmon,5,2))
--                                           BETWEEN DECODE(in_mon_or_wk, 'W', in_fm_wk, in_fm_mon) 
--                                               AND DECODE(in_mon_or_wk, 'W', in_to_wk, in_to_mon)    
--
--                   AND  mst.trd_cd     = NVL(in_trd_cd,     mst.trd_cd)
--                   AND  mst.rlane_cd   = NVL(in_rlane_cd,   mst.rlane_cd)
--                   AND  mst.vsl_cd     = NVL(in_vsl_cd,     mst.vsl_cd)
--                   AND  mst.skd_voy_no = NVL(in_skd_voy_no, mst.skd_voy_no)
--                   AND  mst.dir_cd     = NVL(in_dir_cd,     mst.dir_cd)
--                                               
--                   AND  b.bkg_no = uc.bkg_no
----                   AND  b.bkg_no = 'NYK400317700'
--                   AND  uc.stnd_cost_cd LIKE v_stnd_cost_cd2
--                   AND  uc.estm_usd_ttl_amt > 0
--
--                )                  
--             GROUP BY   trd_cd
--                    ,   rlane_cd
--                    ,   ioc_cd
--                    ,   vsl_cd
--                    ,   skd_voy_no
--                    ,   dir_cd
--                    ,   to_trd_cd
--                    ,   to_rlane_cd
--                    ,   DECODE ( SUBSTR(to_ioc_cd,1,1), SUBSTR(to_ioc_cd,2,1), 'I','O') 
--                    ,   to_vvd_cd
--
--        ;        

        
        enis_log_prc('', v_log_mod_nm, 'COA_INTER_PRC_VVD_EXPN : ' || SQL%ROWCOUNT || ' count inserted', NULL);
        
        --////////////////////////////////////////////////////////////////////////////////////
        -- 1-3. COA_VVD_HIR 초기화
        --////////////////////////////////////////////////////////////////////////////////////
--        UPDATE    COA_VVD_HIR
--           SET    ntwk_hir_cost_amt   = 0
--         WHERE    (trd_cd, rlane_cd, ioc_cd, vsl_cd, skd_voy_no, dir_cd)
--                  IN  (
--                  SELECT trd_cd
--                      ,   rlane_cd
--                      ,   ioc_cd
--                      ,   vsl_cd
--                      ,   skd_voy_no
--                      ,   dir_cd
--                    FROM  COA_MON_VVD
--                   WHERE  1=1
--                     AND  DECODE(in_mon_or_wk, 'W', SUBSTR(sls_yrmon,1,4), SUBSTR(cost_yrmon,1,4)) = in_yr
--                     AND  DECODE(in_mon_or_wk, 'W', cost_wk, SUBSTR(cost_yrmon,5,2))
--                                 BETWEEN DECODE(in_mon_or_wk, 'W',in_fm_wk,in_fm_mon) 
--                                     AND DECODE(in_mon_or_wk, 'W',in_to_wk,in_to_mon)
--                     AND  trd_cd     = NVL(in_trd_cd,     trd_cd)
--                     AND  rlane_cd   = NVL(in_rlane_cd,   rlane_cd)
--                     AND  vsl_cd     = NVL(in_vsl_cd,     vsl_cd)
--                     AND  skd_voy_no = NVL(in_skd_voy_no, skd_voy_no)
--                     AND  dir_cd     = NVL(in_dir_cd,     dir_cd)
--                  )
--           AND  stnd_cost_cd = v_stnd_cost_cd
--        ;
        
--        enis_log_prc('', v_log_mod_nm, 'COA_VVD_HIR : ' || SQL%ROWCOUNT || ' 건 초기화', NULL);
        --////////////////////////////////////////////////////////////////////////////////////
        -- 1-4. COA_VVD_HIR Merge
        --////////////////////////////////////////////////////////////////////////////////////
        MERGE INTO COA_VVD_HIR VVD_HIR
            USING (
                -- 2015.06.08  (supplier -> borrower change) 
                SELECT  
                        a.rlane_cd       rlane_cd
                     ,  a.vsl_cd         vsl_cd
                     ,  a.skd_voy_no     skd_voy_no
                     ,  a.dir_cd         dir_cd
                     ,  a.stnd_cost_cd
                     ,  a.trd_cd
                     ,  a.ioc_cd
                     -- 2015.06.11 comment
--                     ,  CASE 
--                        WHEN c.sub_trd_cd = 'IP' THEN  d.trd_cd
--                        ELSE a.trd_cd
--                        END  trd_cd
--                     ,  CASE 
--                        WHEN c.sub_trd_cd = 'IP' THEN  d.ioc_cd
--                        ELSE a.ioc_cd
--                        END  ioc_cd                       
                     
                     ,  SUM(a.inter_prc_ttl_expn_amt *(-1)) inter_prc_ttl_expn_amt
                  FROM  COA_INTER_PRC_VVD_EXPN A
                    ,   COA_MON_VVD B
--                    ,   COA_MON_VVD C   -- 2015.06.11 comment  
--                    ,   COA_MON_VVD D     
                 WHERE  1=1
                   AND  a.trd_cd        = b.trd_cd
                   AND  a.rlane_cd      = b.rlane_cd
                   AND  a.ioc_cd        = b.ioc_cd
                   AND  a.vsl_cd        = b.vsl_cd
                   AND  a.skd_voy_no    = b.skd_voy_no
                   AND  a.dir_cd        = b.dir_cd
                   AND  b.delt_flg      = 'N'
                   AND  DECODE(in_mon_or_wk, 'W', SUBSTR(b.sls_yrmon,1,4), SUBSTR(b.cost_yrmon,1,4)) = in_yr
                   AND  DECODE(in_mon_or_wk, 'W', b.cost_wk, SUBSTR(b.cost_yrmon,5,2))
                                   BETWEEN DECODE(in_mon_or_wk, 'W',in_fm_wk,in_fm_mon)
                                       AND DECODE(in_mon_or_wk, 'W',in_to_wk,in_to_mon)
                   AND  a.trd_cd        = NVL(in_trd_cd,     a.trd_cd)
                   AND  a.rlane_cd      = NVL(in_rlane_cd,   a.rlane_cd)
                   AND  a.vsl_cd        = NVL(in_vsl_cd,     a.vsl_cd)
                   AND  a.skd_voy_no    = NVL(in_skd_voy_no, a.skd_voy_no)
                   AND  a.dir_cd        = NVL(in_dir_cd,     a.dir_cd)
                   AND  a.stnd_cost_cd  = v_stnd_cost_cd3
--                   -- supplier trd join                  
--                   AND  a.trd_cd      = c.trd_cd     
--                   AND  a.rlane_cd    = c.rlane_cd   
--                   AND  a.ioc_cd      = c.ioc_cd     
--                   AND  a.vsl_cd      = c.vsl_cd     
--                   AND  a.skd_voy_no  = c.skd_voy_no 
--                   AND  a.dir_cd      = c.dir_cd     
--                   AND  c.delt_flg       = 'N'               
--                   -- ocean vvd join
--                   AND  c.rlane_cd           = d.rlane_cd (+)
--                   AND  c.vsl_cd             = d.vsl_cd (+)
--                   AND  c.skd_voy_no         = d.skd_voy_no (+)
--                   AND  c.dir_cd             = d.dir_cd(+)
--                   AND  d.sub_trd_cd(+)      <> 'IP'
--                   AND  d.rlane_cd(+)        <> 'RBCCO'
--                   AND  d.IOC_CD (+)         = 'O'
--                   AND  d.delt_flg(+)        = 'N'
                  GROUP BY  a.rlane_cd, a.vsl_cd, a.skd_voy_no, a.dir_cd, a.stnd_cost_cd ,a.trd_cd, a.ioc_cd
--                         ,  CASE 
--                            WHEN c.sub_trd_cd = 'IP' THEN  d.trd_cd
--                            ELSE a.trd_cd
--                            END  
--                         ,  CASE 
--                            WHEN c.sub_trd_cd = 'IP' THEN  d.ioc_cd
--                            ELSE a.ioc_cd
--                            END                       


-- 2015.06.08 comment  (supplier -> borrower change)          
--                SELECT  
--                        a.to_rlane_cd       rlane_cd
--                     ,  a.to_vsl_cd         vsl_cd
--                     ,  a.to_skd_voy_no     skd_voy_no
--                     ,  a.to_skd_dir_cd     dir_cd
--                     ,  a.stnd_cost_cd
----                        a.to_trd_cd         trd_cd
----                     ,  a.to_ioc_cd         ioc_cd
----                     ,  c.sub_trd_cd        to_sub_trd_cd
--                     ,  CASE 
--                        WHEN c.sub_trd_cd = 'IP' THEN  d.trd_cd
--                        ELSE a.to_trd_cd
--                        END  trd_cd
--                     ,  CASE 
--                        WHEN c.sub_trd_cd = 'IP' THEN  d.ioc_cd
--                        ELSE a.to_ioc_cd
--                        END  ioc_cd                      
--                     ,  SUM(a.inter_prc_ttl_expn_amt *(-1)) inter_prc_ttl_expn_amt
--                  FROM  COA_INTER_PRC_VVD_EXPN A
--                    ,   COA_MON_VVD B
--                    ,   COA_MON_VVD C     
--                    ,   COA_MON_VVD D     
--                 WHERE  1=1
--                   AND  a.trd_cd        = b.trd_cd
--                   AND  a.rlane_cd      = b.rlane_cd
--                   AND  a.ioc_cd        = b.ioc_cd
--                   AND  a.vsl_cd        = b.vsl_cd
--                   AND  a.skd_voy_no    = b.skd_voy_no
--                   AND  a.dir_cd        = b.dir_cd
--                   AND  b.delt_flg      = 'N'
--                   AND  DECODE(in_mon_or_wk, 'W', SUBSTR(b.sls_yrmon,1,4), SUBSTR(b.cost_yrmon,1,4)) = in_yr
--                   AND  DECODE(in_mon_or_wk, 'W', b.cost_wk, SUBSTR(b.cost_yrmon,5,2))
--                                   BETWEEN DECODE(in_mon_or_wk, 'W',in_fm_wk,in_fm_mon) 
--                                       AND DECODE(in_mon_or_wk, 'W',in_to_wk,in_to_mon)
--                   AND  a.trd_cd        = NVL(in_trd_cd,     a.trd_cd)
--                   AND  a.rlane_cd      = NVL(in_rlane_cd,   a.rlane_cd)
--                   AND  a.vsl_cd        = NVL(in_vsl_cd,     a.vsl_cd)
--                   AND  a.skd_voy_no    = NVL(in_skd_voy_no, a.skd_voy_no)
--                   AND  a.dir_cd        = NVL(in_dir_cd,     a.dir_cd)
--                   AND  a.stnd_cost_cd  = v_stnd_cost_cd3
--                   -- to trd join                   
--                   AND  a.to_trd_cd      = c.trd_cd     
--                   AND  a.to_rlane_cd    = c.rlane_cd   
--                   AND  a.to_ioc_cd      = c.ioc_cd     
--                   AND  a.to_vsl_cd      = c.vsl_cd     
--                   AND  a.to_skd_voy_no  = c.skd_voy_no 
--                   AND  a.to_skd_dir_cd  = c.dir_cd     
--                   AND  c.delt_flg       = 'N'               
--                   -- ocean vvd join
--                   AND  c.rlane_cd           = d.rlane_cd (+)
--                   AND  c.vsl_cd             = d.vsl_cd (+)
--                   AND  c.skd_voy_no         = d.skd_voy_no (+)
--                   AND  c.dir_cd             = d.dir_cd(+)
--                   AND  d.sub_trd_cd(+)      <> 'IP'
--                   AND  d.rlane_cd(+)        <> 'RBCCO'
--                   AND  d.IOC_CD (+)         = 'O'
--                   AND  d.delt_flg(+)        = 'N'
--                  GROUP BY  a.to_rlane_cd, a.to_vsl_cd, a.to_skd_voy_no, a.to_skd_dir_cd, a.stnd_cost_cd 
--                         ,  CASE 
--                            WHEN c.sub_trd_cd = 'IP' THEN  d.trd_cd
--                            ELSE a.to_trd_cd
--                            END  
--                         ,  CASE 
--                            WHEN c.sub_trd_cd = 'IP' THEN  d.ioc_cd
--                            ELSE a.to_ioc_cd
--                            END               

                   ) VVD_EXPN
            ON  (   vvd_hir.trd_cd      = vvd_expn.trd_cd
                AND vvd_hir.rlane_cd    = vvd_expn.rlane_cd
                AND vvd_hir.ioc_cd      = vvd_expn.ioc_cd
                AND vvd_hir.vsl_cd      = vvd_expn.vsl_cd
                AND vvd_hir.skd_voy_no  = vvd_expn.skd_voy_no
                AND vvd_hir.dir_cd      = vvd_expn.dir_cd
                AND vvd_hir.stnd_cost_cd= vvd_expn.stnd_cost_cd
                )
            WHEN MATCHED THEN
                UPDATE
                  SET   ntwk_hir_cost_amt  = inter_prc_ttl_expn_amt
                   ,    co_sls_amt         = inter_prc_ttl_expn_amt
                   ,    upd_usr_id         = in_user_id
                   ,    upd_dt             = SYSDATE
            WHEN NOT MATCHED THEN
                INSERT ( trd_cd,rlane_cd,ioc_cd,vsl_cd,skd_voy_no,dir_cd,stnd_cost_cd
                        ,ntwk_hir_cost_amt,co_sls_amt, cre_usr_id,cre_dt,upd_usr_id,upd_dt)
                VALUES ( vvd_expn.trd_cd, vvd_expn.rlane_cd,vvd_expn.ioc_cd,vvd_expn.vsl_cd,vvd_expn.skd_voy_no,vvd_expn.dir_cd,v_stnd_cost_cd3
                        ,vvd_expn.inter_prc_ttl_expn_amt,vvd_expn.inter_prc_ttl_expn_amt,in_user_id,SYSDATE,in_user_id,SYSDATE)
            ;
        
        enis_log_prc('', v_log_mod_nm, 'COA_VVD_HIR : ' || SQL%ROWCOUNT || ' count merged', NULL);
    END IF;


    /* 
     * UI ID    : ESM_COA_0107
     * UI Title : Allocation Results(Internal Pricing)
     * Creation 적용시 호출
     */
    IF (in_step_flg = '2') THEN
        --////////////////////////////////////////////////////////////////////////////////////
        -- 2-1. COA_FX_AMT_DTRB 생성
        --////////////////////////////////////////////////////////////////////////////////////
        MERGE INTO   COA_FX_AMT_DTRB  MST
            USING  (
                    SELECT  IPC.TRD_CD                              AS FM_TRD_CD
                        ,   IPC.RLANE_CD                            AS FM_RLANE_CD
                        ,   IPC.IOC_CD                              AS FM_IOC_CD
                        ,   IPC.VSL_CD                              AS FM_VSL_CD
                        ,   IPC.SKD_VOY_NO                          AS FM_SKD_VOY_NO
                        ,   IPC.DIR_CD                              AS FM_SKD_DIR_CD
                        ,   OCN.TRD_CD                              AS TO_TRD_CD
                        ,   OCN.RLANE_CD                            AS TO_RLANE_CD
                        ,   OCN.IOC_CD                              AS TO_IOC_CD
                        ,   OCN.VSL_CD                              AS TO_VSL_CD
                        ,   OCN.SKD_VOY_NO                          AS TO_SKD_VOY_NO
                        ,   OCN.DIR_CD                              AS TO_SKD_DIR_CD
                        ,   EXP.STND_COST_CD                        AS STND_COST_CD
                        ,   'LO'                                    AS LOCL_TS_STS_CD      
                        ,   EXP.INTER_PRC_TTL_EXPN_AMT              AS FX_COST_DTRB_AMT
                        ,   in_user_id                            AS LOGIN_USR_ID
                      FROM  COA_MON_VVD                             IPC
                        ,   COA_MON_VVD                             OCN
                        ,   COA_INTER_PRC_VVD_EXPN                  EXP
                     WHERE  1 = 1
                       AND  IPC.RLANE_CD       = OCN.RLANE_CD     /* INTERPORT CARGO vs OCEAN */
                       AND  IPC.VSL_CD         = OCN.VSL_CD
                       AND  IPC.SKD_VOY_NO     = OCN.SKD_VOY_NO
                       AND  IPC.DIR_CD         = OCN.DIR_CD
                       AND  IPC.TRD_CD         = EXP.TRD_CD       
                       AND  IPC.RLANE_CD       = EXP.RLANE_CD     
                       AND  IPC.IOC_CD         = EXP.IOC_CD       
                       AND  IPC.VSL_CD         = EXP.VSL_CD       
                       AND  IPC.SKD_VOY_NO     = EXP.SKD_VOY_NO   
                       AND  IPC.DIR_CD         = EXP.DIR_CD       
                       AND  EXP.STND_COST_CD   = v_stnd_cost_cd
                       AND  IPC.DELT_FLG       = 'N'
                       AND  OCN.DELT_FLG       = 'N'
                       AND  IPC.TRD_CD         = 'IAT'
                       AND  IPC.IOC_CD         = 'I'
                       AND  IPC.SUB_TRD_CD     = 'IP'
                       AND  OCN.TRD_CD         IN (
                                                    SELECT  INTG_CD_VAL_CTNT AS TRD_CD
                                                      FROM  COM_INTG_CD A,
                                                            COM_INTG_CD_DTL B
                                                     WHERE  A.INTG_CD_ID      =  B.INTG_CD_ID
                                                       AND  A.INTG_CD_ID      = 'CD02765'
                                                       AND  A.INTG_CD_USE_FLG = 'Y'
                                                 )
                       AND  IPC.RLANE_CD       <> 'RBCCO'
                       AND  OCN.IOC_CD         = 'O'
                       AND  OCN.SUB_TRD_CD     <> 'IP'
                       AND  DECODE(in_mon_or_wk, 'W', SUBSTR(ipc.sls_yrmon,1,4), SUBSTR(ipc.cost_yrmon,1,4)) = in_yr
                       AND  DECODE(in_mon_or_wk, 'W', ipc.cost_wk, SUBSTR(ipc.cost_yrmon,5,2))
                                                   BETWEEN DECODE(in_mon_or_wk, 'W', in_fm_wk, in_fm_mon) 
                                                       AND DECODE(in_mon_or_wk, 'W', in_to_wk, in_to_mon)
                    ) X
            ON  (
                    MST.FM_TRD_CD      = X.FM_TRD_CD
                AND MST.FM_RLANE_CD    = X.FM_RLANE_CD
                AND MST.FM_IOC_CD      = X.FM_IOC_CD
                AND MST.FM_VSL_CD      = X.FM_VSL_CD
                AND MST.FM_SKD_VOY_NO  = X.FM_SKD_VOY_NO  
                AND MST.FM_SKD_DIR_CD  = X.FM_SKD_DIR_CD
                AND MST.STND_COST_CD   = X.STND_COST_CD   /* 54600000 : Internal Expense */
                )
            WHEN MATCHED THEN
                UPDATE        
                SET MST.FX_COST_DTRB_AMT        = X.FX_COST_DTRB_AMT                 
                  , MST.UPD_USR_ID              = X.LOGIN_USR_ID
                  , MST.UPD_DT                  = SYSDATE
            WHEN NOT MATCHED THEN
                INSERT  (
                        MST.FM_TRD_CD
                    ,   MST.FM_RLANE_CD
                    ,   MST.FM_IOC_CD
                    ,   MST.FM_VSL_CD
                    ,   MST.FM_SKD_VOY_NO
                    ,   MST.FM_SKD_DIR_CD
                    ,   MST.TO_TRD_CD
                    ,   MST.TO_RLANE_CD
                    ,   MST.TO_IOC_CD
                    ,   MST.TO_VSL_CD
                    ,   MST.TO_SKD_VOY_NO
                    ,   MST.TO_SKD_DIR_CD
                    ,   MST.STND_COST_CD            /* 54600000 OFIN (Internal Expense)  */
                    ,   MST.LOCL_TS_STS_CD          /* LO or TS                          */              
                    ,   MST.FX_COST_DTRB_AMT        /* 고정비 배부금액                   */  
                    ,   MST.CRE_USR_ID
                    ,   MST.CRE_DT
                    ,   MST.UPD_USR_ID
                    ,   MST.UPD_DT                   
                )
                VALUES          (
                        X.FM_TRD_CD
                    ,   X.FM_RLANE_CD
                    ,   X.FM_IOC_CD
                    ,   X.FM_VSL_CD
                    ,   X.FM_SKD_VOY_NO
                    ,   X.FM_SKD_DIR_CD
                    ,   X.TO_TRD_CD
                    ,   X.TO_RLANE_CD
                    ,   X.TO_IOC_CD
                    ,   X.TO_VSL_CD
                    ,   X.TO_SKD_VOY_NO
                    ,   X.TO_SKD_DIR_CD
                    ,   X.STND_COST_CD
                    ,   X.LOCL_TS_STS_CD      
                    ,   X.FX_COST_DTRB_AMT                    
                    ,   X.LOGIN_USR_ID              /* CRE_USR_ID */
                    ,   SYSDATE                     /* CRE_DT     */
                    ,   X.LOGIN_USR_ID              /* UPD_USR_ID */
                    ,   SYSDATE                     /* UPD_DT     */                   
                )
                ;
        enis_log_prc('', v_log_mod_nm, 'COA_FX_AMT_DTRB : ' || SQL%ROWCOUNT || ' 건 Merge', NULL);
        --////////////////////////////////////////////////////////////////////////////////////
        -- 2-2. COA_VVD_HIR 생성
        --////////////////////////////////////////////////////////////////////////////////////
        
        MERGE INTO COA_VVD_HIR       MST
            USING  (
                SELECT  'FM'                  AS FM_TO_FLG
                    ,   DTR.FM_TRD_CD         AS TRD_CD                                               
                    ,   DTR.FM_RLANE_CD       AS RLANE_CD
                    ,   DTR.FM_IOC_CD         AS IOC_CD
                    ,   DTR.FM_VSL_CD         AS VSL_CD
                    ,   DTR.FM_SKD_VOY_NO     AS SKD_VOY_NO
                    ,   DTR.FM_SKD_DIR_CD     AS DIR_CD
                    ,   DTR.STND_COST_CD      AS STND_COST_CD
                    ,   DTR.FX_COST_DTRB_AMT  AS FX_COST_DTRB_AMT
                    ,   in_user_id           AS LOGIN_USR_ID
                  FROM  COA_MON_VVD           HD
                    ,   COA_FX_AMT_DTRB       DTR
                 WHERE  HD.TRD_CD             = DTR.FM_TRD_CD
                   AND  HD.RLANE_CD           = DTR.FM_RLANE_CD
                   AND  HD.IOC_CD             = DTR.FM_IOC_CD
                   AND  HD.VSL_CD             = DTR.FM_VSL_CD
                   AND  HD.SKD_VOY_NO         = DTR.FM_SKD_VOY_NO
                   AND  HD.DIR_CD             = DTR.FM_SKD_DIR_CD
                   AND  HD.DELT_FLG           = 'N'
                   AND  HD.RLANE_CD           <> 'RBCCO'
                   AND  DECODE(in_mon_or_wk, 'W', SUBSTR(HD.sls_yrmon,1,4), SUBSTR(HD.cost_yrmon,1,4)) = in_yr
                   AND  DECODE(in_mon_or_wk, 'W', HD.cost_wk, SUBSTR(HD.cost_yrmon,5,2))
                                   BETWEEN DECODE(in_mon_or_wk, 'W',in_fm_wk,in_fm_mon) 
                                       AND DECODE(in_mon_or_wk, 'W',in_to_wk,in_to_mon)
                   AND  HD.trd_cd       = NVL(in_trd_cd,     HD.trd_cd)
                   AND  HD.rlane_cd     = NVL(in_rlane_cd,   HD.rlane_cd)
                   AND  HD.vsl_cd       = NVL(in_vsl_cd,     HD.vsl_cd)
                   AND  HD.skd_voy_no   = NVL(in_skd_voy_no, HD.skd_voy_no)
                   AND  HD.dir_cd       = NVL(in_dir_cd,     HD.dir_cd)
                   AND  DTR.STND_COST_CD= v_stnd_cost_cd                   
                UNION ALL
                
                SELECT  'TO'                  AS FM_TO_FLG
                    ,   DTR.TO_TRD_CD         AS TRD_CD
                    ,   DTR.TO_RLANE_CD       AS RLANE_CD
                    ,   DTR.TO_IOC_CD         AS IOC_CD
                    ,   DTR.TO_VSL_CD         AS VSL_CD
                    ,   DTR.TO_SKD_VOY_NO     AS SKD_VOY_NO
                    ,   DTR.TO_SKD_DIR_CD     AS DIR_CD
                    ,   DTR.STND_COST_CD      AS STND_COST_CD
                    ,   DTR.FX_COST_DTRB_AMT  AS FX_COST_DTRB_AMT
                    ,   in_user_id           AS LOGIN_USR_ID
                  FROM  COA_MON_VVD           HD
                    ,   COA_FX_AMT_DTRB       DTR
                 WHERE  HD.TRD_CD             = DTR.FM_TRD_CD
                   AND  HD.RLANE_CD           = DTR.FM_RLANE_CD
                   AND  HD.IOC_CD             = DTR.FM_IOC_CD
                   AND  HD.VSL_CD             = DTR.FM_VSL_CD
                   AND  HD.SKD_VOY_NO         = DTR.FM_SKD_VOY_NO
                   AND  HD.DIR_CD             = DTR.FM_SKD_DIR_CD
                   AND  HD.DELT_FLG           = 'N'
                   AND  DECODE(in_mon_or_wk, 'W', SUBSTR(HD.sls_yrmon,1,4), SUBSTR(HD.cost_yrmon,1,4)) = in_yr
                   AND  DECODE(in_mon_or_wk, 'W', HD.cost_wk, SUBSTR(HD.cost_yrmon,5,2))
                                   BETWEEN DECODE(in_mon_or_wk, 'W',in_fm_wk,in_fm_mon) 
                                       AND DECODE(in_mon_or_wk, 'W',in_to_wk,in_to_mon)
                   AND  HD.trd_cd       = NVL(in_trd_cd,     HD.trd_cd)
                   AND  HD.rlane_cd     = NVL(in_rlane_cd,   HD.rlane_cd)
                   AND  HD.vsl_cd       = NVL(in_vsl_cd,     HD.vsl_cd)
                   AND  HD.skd_voy_no   = NVL(in_skd_voy_no, HD.skd_voy_no)
                   AND  HD.dir_cd       = NVL(in_dir_cd,     HD.dir_cd)
                   AND  DTR.STND_COST_CD      = v_stnd_cost_cd                               
            ) X
            ON     (
                    MST.TRD_CD            = X.TRD_CD
                AND MST.RLANE_CD          = X.RLANE_CD
                AND MST.IOC_CD            = X.IOC_CD
                AND MST.VSL_CD            = X.VSL_CD
                AND MST.SKD_VOY_NO        = X.SKD_VOY_NO         
                AND MST.DIR_CD            = X.DIR_CD
                AND MST.STND_COST_CD      = X.STND_COST_CD
            )                  
            WHEN MATCHED THEN
                UPDATE   
                    SET MST.NTWK_HIR_COST_AMT  =  CASE WHEN X.FM_TO_FLG = 'FM' THEN X.FX_COST_DTRB_AMT  /* FROM COST PLUS  */
                                                       WHEN X.FM_TO_FLG = 'TO' THEN X.FX_COST_DTRB_AMT*(-1) /* FROM COST PLUS  */
                                                       ELSE -1
                                                  END                   
                    ,   MST.CO_SLS_AMT        =  CASE WHEN X.FM_TO_FLG = 'FM' THEN X.FX_COST_DTRB_AMT       /* FROM COST PLUS  */
                                                       WHEN X.FM_TO_FLG = 'TO' THEN X.FX_COST_DTRB_AMT*(-1)  /* TO   COST MINUS */
                                                       ELSE -1
                                                  END                  
                    ,   MST.UPD_USR_ID            = X.LOGIN_USR_ID
                    ,   MST.UPD_DT                = SYSDATE                               
            WHEN NOT MATCHED THEN
                INSERT    (
                    MST.TRD_CD
                ,   MST.RLANE_CD
                ,   MST.IOC_CD
                ,   MST.VSL_CD
                ,   MST.SKD_VOY_NO
                ,   MST.DIR_CD
                ,   MST.STND_COST_CD
                ,   MST.NTWK_HIR_COST_AMT
                ,   MST.CO_SLS_AMT             
                ,   MST.CRE_USR_ID
                ,   MST.CRE_DT
                ,   MST.UPD_USR_ID
                ,   MST.UPD_DT
                )
                VALUES    (
                    X.TRD_CD
                ,   X.RLANE_CD
                ,   X.IOC_CD
                ,   X.VSL_CD
                ,   X.SKD_VOY_NO
                ,   X.DIR_CD
                ,   X.STND_COST_CD
                ,   CASE WHEN X.FM_TO_FLG = 'FM' THEN X.FX_COST_DTRB_AMT /* (MST.NTWK_HIR_COST_AMT - MST.NTWK_HIR_COST_AMT*(-1)) */
                         WHEN X.FM_TO_FLG = 'TO' THEN X.FX_COST_DTRB_AMT *(-1)
                         ELSE -1
                    END
                ,   CASE WHEN X.FM_TO_FLG = 'FM' THEN X.FX_COST_DTRB_AMT /* (MST.NTWK_HIR_COST_AMT - MST.NTWK_HIR_COST_AMT*(-1)) */
                         WHEN X.FM_TO_FLG = 'TO' THEN X.FX_COST_DTRB_AMT *(-1)
                         ELSE -1
                    END               
                , X.LOGIN_USR_ID
                , SYSDATE
                , X.LOGIN_USR_ID
                , SYSDATE
                );
        enis_log_prc('', v_log_mod_nm, 'COA_VVD_HIR : ' || SQL%ROWCOUNT || ' 건 Merge', NULL);
    END IF;
   
    /* 
     * UI ID    : ESM_COA_0107
     * UI Title : Allocation Results(Internal Pricing)
     * Apply to P/L 적용시 호출
     */
    IF (in_step_flg = '9') THEN
        --////////////////////////////////////////////////////////////////////////////////////
        -- 9-1. Apply to P/L (Internal Pricing)
        --////////////////////////////////////////////////////////////////////////////////////
    MERGE INTO  COA_PFIT_LSS_SMRY   MST
        USING  (
            SELECT   HIR.VSL_CD             AS VSL_CD
                ,    HIR.SKD_VOY_NO         AS SKD_VOY_NO
                ,    HIR.DIR_CD             AS SKD_DIR_CD
                ,    HIR.IOC_CD             AS IOC_CD
                ,    HIR.RLANE_CD           AS RLANE_CD
                ,    HIR.TRD_CD             AS TRD_CD
                ,    'XXXX'                 AS CNTR_TPSZ_CD
                ,    COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()   AS SLS_OFC_CD         /* 영업 지점 코드                                    */
                ,    COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()   AS AGMT_SGN_OFC_CD    /* Booking에 해당되는 각 계약를 성사시킨 Office Code */
                ,    HIR.STND_COST_CD       AS STND_COST_CD       /* 월간 비목별 TOTAL COST SUMMARY                    */
                ,    HIR.NTWK_HIR_COST_AMT  AS ESTM_PL_AMT
                ,    NULL                   AS RA_PL_AMT          /* 추정 실적 금액                                    */
                ,    NULL                   AS ACT_PL_AMT         /* 실적금액                                          */
                ,    NULL                   AS ACCL_RT_AMT        /* 추정결산   금액                                   */
                ,    HIR.CO_SLS_AMT         AS CO_SLS_AMT         /* company 비율 금액                                 */
                ,    NULL                   AS CO_AMT             /* CHT 비율 금액                                     */
                ,    NULL                   AS PL_DESC            /* PL Report별 표기되는 Item별 Report DESC           */
                ,    in_user_id             AS LOGIN_USR_ID
              FROM  COA_MON_VVD            HD
                ,   COA_VVD_HIR            HIR
                ,   COA_LANE_RGST          LNE
             WHERE  HD.TRD_CD              = HIR.TRD_CD
               AND  HD.RLANE_CD            = HIR.RLANE_CD
               AND  HD.IOC_CD              = HIR.IOC_CD
               AND  HD.VSL_CD              = HIR.VSL_CD
               AND  HD.SKD_VOY_NO          = HIR.SKD_VOY_NO
               AND  HD.DIR_CD              = HIR.DIR_CD
               AND  HD.TRD_CD              = LNE.TRD_CD
               AND  HD.RLANE_CD            = LNE.RLANE_CD
               AND  HD.IOC_CD              = LNE.IOC_CD
               AND  HD.DIR_CD              = LNE.DIR_CD
               AND  HD.DELT_FLG            = 'N'
               AND  HD.IOC_CD              = 'I'
               AND  HD.TRD_CD              = 'IAT'
               AND  HD.SUB_TRD_CD          = 'IP'
               AND  HD.RLANE_CD            <> 'RBCCO'  /* FEEDER COMMON LANE */           
               AND  DECODE(in_mon_or_wk, 'W', SUBSTR(HD.sls_yrmon,1,4), SUBSTR(HD.cost_yrmon,1,4)) = in_yr
               AND  DECODE(in_mon_or_wk, 'W', HD.cost_wk, SUBSTR(HD.cost_yrmon,5,2))
                               BETWEEN DECODE(in_mon_or_wk, 'W',in_fm_wk,in_fm_mon) 
                                   AND DECODE(in_mon_or_wk, 'W',in_to_wk,in_to_mon)
               AND  HD.trd_cd              = NVL(in_trd_cd,     HD.trd_cd)
               AND  HD.rlane_cd            = NVL(in_rlane_cd,   HD.rlane_cd)
               AND  HD.vsl_cd              = NVL(in_vsl_cd,     HD.vsl_cd)
               AND  HD.skd_voy_no          = NVL(in_skd_voy_no, HD.skd_voy_no)
               AND  HD.dir_cd              = NVL(in_dir_cd,     HD.dir_cd)
               AND  HIR.STND_COST_CD       = v_stnd_cost_cd
            UNION ALL
            
            SELECT  HIR.VSL_CD             AS VSL_CD
                ,   HIR.SKD_VOY_NO         AS SKD_VOY_NO
                ,   HIR.DIR_CD             AS SKD_DIR_CD
                ,   HIR.IOC_CD             AS IOC_CD
                ,   HIR.RLANE_CD           AS RLANE_CD
                ,   HIR.TRD_CD             AS TRD_CD
                ,   'XXXX'                 AS CNTR_TPSZ_CD
                ,   COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()                AS SLS_OFC_CD
                ,   COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()                AS AGMT_SGN_OFC_CD
                ,   HIR.STND_COST_CD       AS STND_COST_CD
                ,   HIR.NTWK_HIR_COST_AMT  AS ESTM_PL_AMT
                ,   NULL                   AS RA_PL_AMT
                ,   NULL                   AS ACT_PL_AMT
                ,   NULL                   AS ACCL_RT_AMT
                ,   HIR.CO_SLS_AMT         AS CO_SLS_AMT
                ,   NULL                   AS CO_AMT              
                ,   NULL                   AS PL_DESC
                ,   in_user_id             AS LOGIN_USR_ID
          FROM     COA_VVD_HIR            HIR
          WHERE    ( HIR.TRD_CD
                   , HIR.RLANE_CD
                   , HIR.IOC_CD
                   , HIR.VSL_CD
                   , HIR.SKD_VOY_NO
                   , HIR.DIR_CD
                   , HIR.STND_COST_CD
                   )  
                   IN
                   ( SELECT    DTR.TO_TRD_CD        
                           ,   DTR.TO_RLANE_CD       
                           ,   DTR.TO_IOC_CD         
                           ,   DTR.TO_VSL_CD         
                           ,   DTR.TO_SKD_VOY_NO     
                           ,   DTR.TO_SKD_DIR_CD     
                           ,   DTR.STND_COST_CD      
                       FROM      COA_FX_AMT_DTRB       DTR
                      WHERE    ( DTR.FM_TRD_CD
                              , DTR.FM_RLANE_CD
                              , DTR.FM_IOC_CD
                              , DTR.FM_VSL_CD
                              , DTR.FM_SKD_VOY_NO
                              , DTR.FM_SKD_DIR_CD
                              , DTR.STND_COST_CD
                              )
                              IN
                              (SELECT    DTR.FM_TRD_CD                                                    
                                     ,   DTR.FM_RLANE_CD       
                                     ,   DTR.FM_IOC_CD         
                                     ,   DTR.FM_VSL_CD         
                                     ,   DTR.FM_SKD_VOY_NO    
                                     ,   DTR.FM_SKD_DIR_CD     
                                     ,   DTR.STND_COST_CD      
                                 FROM   COA_MON_VVD           HD
                                     ,  COA_FX_AMT_DTRB       DTR
                                WHERE   HD.TRD_CD          = DTR.FM_TRD_CD
                                  AND   HD.RLANE_CD        = DTR.FM_RLANE_CD
                                  AND   HD.IOC_CD          = DTR.FM_IOC_CD
                                  AND   HD.VSL_CD          = DTR.FM_VSL_CD
                                  AND   HD.SKD_VOY_NO      = DTR.FM_SKD_VOY_NO
                                  AND   HD.DIR_CD          = DTR.FM_SKD_DIR_CD
                                  AND   HD.DELT_FLG        = 'N'
                                  AND   HD.IOC_CD          = 'I'
                                  AND   HD.TRD_CD          = 'IAT'
                                  AND   HD.SUB_TRD_CD      = 'IP'
                                  AND   HD.RLANE_CD        <> 'RBCCO'                                             
                                  AND   DECODE(in_mon_or_wk, 'W', SUBSTR(HD.sls_yrmon,1,4), SUBSTR(HD.cost_yrmon,1,4)) = in_yr
                                  AND   DECODE(in_mon_or_wk, 'W', HD.cost_wk, SUBSTR(HD.cost_yrmon,5,2))
                                                   BETWEEN DECODE(in_mon_or_wk, 'W',in_fm_wk,in_fm_mon) 
                                                       AND DECODE(in_mon_or_wk, 'W',in_to_wk,in_to_mon)
                                  AND   HD.trd_cd          = NVL(in_trd_cd,     HD.trd_cd)
                                  AND   HD.rlane_cd        = NVL(in_rlane_cd,   HD.rlane_cd)
                                  AND   HD.vsl_cd          = NVL(in_vsl_cd,     HD.vsl_cd)
                                  AND   HD.skd_voy_no      = NVL(in_skd_voy_no, HD.skd_voy_no)
                                  AND   HD.dir_cd          = NVL(in_dir_cd,     HD.dir_cd)
                                  AND   DTR.STND_COST_CD   = v_stnd_cost_cd
                              )                                     
                    )
                 ) X
          ON     (         MST.VSL_CD             = X.VSL_CD
                  AND      MST.SKD_VOY_NO         = X.SKD_VOY_NO
                  AND      MST.SKD_DIR_CD         = X.SKD_DIR_CD
                  AND      MST.IOC_CD             = X.IOC_CD
                  AND      MST.RLANE_CD           = X.RLANE_CD
                  AND      MST.TRD_CD             = X.TRD_CD
                  AND      MST.CNTR_TPSZ_CD       = X.CNTR_TPSZ_CD
                  AND      MST.SLS_OFC_CD         = X.SLS_OFC_CD
                  AND      MST.AGMT_SGN_OFC_CD    = X.AGMT_SGN_OFC_CD
                  AND      MST.STND_COST_CD       = X.STND_COST_CD
                 )
    WHEN MATCHED THEN
                 UPDATE 
                 SET      
                           MST.ESTM_PL_AMT        = X.ESTM_PL_AMT                      
                      ,    MST.CO_SLS_AMT         = X.ESTM_PL_AMT                      
                      ,    MST.UPD_USR_ID         = X.LOGIN_USR_ID
                      ,    MST.UPD_DT             = SYSDATE
    WHEN NOT MATCHED THEN       
                 INSERT (  MST.VSL_CD
                      ,    MST.SKD_VOY_NO
                      ,    MST.SKD_DIR_CD
                      ,    MST.IOC_CD
                      ,    MST.RLANE_CD
                      ,    MST.TRD_CD
                      ,    MST.CNTR_TPSZ_CD
                      ,    MST.SLS_OFC_CD
                      ,    MST.AGMT_SGN_OFC_CD
                      ,    MST.STND_COST_CD
                      
                      ,    MST.ESTM_PL_AMT        /* 월간 비목별 TOTAL COST SUMMARY        */
                      ,    MST.RA_PL_AMT          /* 추정 실적 금액                        */
                      ,    MST.ACT_PL_AMT         /* 실적금액                              */
                      ,    MST.ACCL_RT_AMT        /* 추정결산   금액                       */
                      ,    MST.CO_SLS_AMT         /* Company 비율 금액                     */
                      ,    MST.CO_AMT             /* CHT 비율 금액                         */                  
                      ,    MST.PL_DESC            /* PL Report별 표기되는 Item별 Report DESC */
                      
                      ,    MST.CRE_USR_ID
                      ,    MST.CRE_DT
                      ,    MST.UPD_USR_ID
                      ,    MST.UPD_DT
                      )
          VALUES      (    X.VSL_CD
                      ,    X.SKD_VOY_NO
                      ,    X.SKD_DIR_CD
                      ,    X.IOC_CD
                      ,    X.RLANE_CD
                      ,    X.TRD_CD
                      ,    X.CNTR_TPSZ_CD
                      ,    X.SLS_OFC_CD
                      ,    X.AGMT_SGN_OFC_CD
                      ,    X.STND_COST_CD
                      
                      ,    X.ESTM_PL_AMT        /* 월간 비목별 TOTAL COST SUMMARY        */
                      ,    X.RA_PL_AMT          /* 추정 실적 금액                        */
                      ,    X.ACT_PL_AMT         /* 실적금액                              */
                      ,    X.ACCL_RT_AMT        /* 추정결산   금액                       */
                      ,    X.CO_SLS_AMT        /* company 비율 금액                         */
                      ,    X.CO_AMT             /* CHT 비율 금액                         */    

                      ,    X.PL_DESC            /* PL Report별 표기되는 Item별 Report DESC */
                      
                      ,    X.LOGIN_USR_ID
                      ,    SYSDATE
                      ,    X.LOGIN_USR_ID
                      ,    SYSDATE
                      );
    END IF;

    out_error_code := '00000';   -- COA_CREATE_NTWK_COST_ALL_PRC 에서 체크 함
    out_error_msg := 'Completed!';
    enis_log_prc('', v_log_mod_nm, 'END', NULL);
--COMMIT;
---------------------------[ 예외처리부      ]-----------------------
EXCEPTION
   WHEN OTHERS THEN
      enis_log_prc('', v_log_mod_nm, ' >> ERROR ' || SQLERRM, NULL);
      RAISE;
END COA_CREATE_NTCOST_INTERPRC_PRC;