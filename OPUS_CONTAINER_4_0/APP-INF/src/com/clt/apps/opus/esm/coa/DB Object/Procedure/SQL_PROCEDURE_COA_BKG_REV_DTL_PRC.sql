CREATE OR REPLACE PROCEDURE COA_BKG_REV_DTL_PRC (in_bkg_no IN VARCHAR2, out_result OUT VARCHAR2)
AUTHID current_user
IS

/******************************************************************************
Name         :   COA_BKG_REV_DTL_PRC
Purpose      :   Booking rate를 이용하여 운임수입을 산출하고, 기타 SMRY테이블의 요약작업
Source       :   BKG_BKG_RATE
Target       :   COA_BKG_REV_DTL
2014.08.26 박찬민 실제 Charge 가 있는 Bkg에만 MIS OP 금액 합산
2014.10.21 SJH bkg_chg_rt에 존재하는경우 조건없이 실제 운임수입이 있는 경우로 간주
******************************************************************************/

    /* sce_cop_hdr, bkg_bkg_cntr 테이블에서 물량을 가져온다. sce_cop_hdr의 물량이 null인 경우 bkg_bkg_cntr에서 물량을 구한다. */
    CURSOR cntr_type_size_cursor(in_bkg_no VARCHAR2)
    IS
    SELECT -- bkg_no 
           cntr_tpsz_cd
          ,cntr_tpsz
          ,op_qty
          ,op_ratio_qty
          ,teu_tot total_teu
          ,feu_tot total_feu
          ,tot_teu total_qty
      FROM (
            SELECT bkg_no 
                  ,cntr_tpsz_cd
                  ,cntr_tpsz
                  ,SUM(COALESCE(a1_vol_qty, a2_vol_qty, 1)) OVER (PARTITION BY bkg_no,cntr_tpsz_cd) op_qty 
                  ,NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd,-1), '2', COALESCE(a1_vol_qty, a2_vol_qty, 1)
                                                         , COALESCE(a1_vol_qty, a2_vol_qty, 1) * 2)) OVER (PARTITION BY bkg_no,cntr_tpsz_cd) ,1) op_ratio_qty
                  ,SUM(DECODE(SUBSTR(cntr_tpsz_cd,-1), '2',     COALESCE(a1_vol_qty, a2_vol_qty, 1),0))  OVER() teu_tot
                  ,SUM(DECODE(SUBSTR(cntr_tpsz_cd,-1), '2', 0,  COALESCE(a1_vol_qty, a2_vol_qty, 1))) OVER() feu_tot
                  ,NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd,-1) ,'2', COALESCE(a1_vol_qty, a2_vol_qty, 1)
                                                              , COALESCE(a1_vol_qty, a2_vol_qty, 1) * 2)) OVER() ,1)  tot_teu
              FROM ( 
                        SELECT a1.bkg_no
                              ,CASE WHEN SUBSTR(a1.cntr_tpsz_cd,0,1)='R' AND a2.SOC_FLG='Y' AND a2.RC_FLG='N' THEN
                                         'RD' || SUBSTR(a1.cntr_tpsz_cd, -1)
                                    WHEN SUBSTR(a1.cntr_tpsz_cd,0,1)='R' AND a2.RD_CGO_FLG='Y' THEN -- COP는 SPCL를 안함...DCGO_FLG, RC_FLG, BB_CGO_FLG, AWK_CGO_FLG, RD_CGO_FLG, SOC_FLG
                                         'RD' || SUBSTR(a1.cntr_tpsz_cd, -1)
                                    ELSE
                                         a1.cntr_tpsz_cd
                               END cntr_tpsz_cd                        
                              ,SUBSTR(a1.cntr_tpsz_cd,-1) cntr_tpsz
                              ,NULL a1_vol_qty --,a1.cntr_vol_qty a1_vol_qty COP는 물량관리를 안함...
                              ,a2.CNTR_VOL_QTY a2_vol_qty
                          FROM sce_cop_hdr a1, BKG_CONTAINER a2
                         WHERE 1 = 1
                           AND a1.bkg_no       = in_bkg_no
                           AND a1.bkg_no       = a2.bkg_no
                           AND a1.cntr_no      = a2.cntr_no
                        )
           )            
     GROUP BY --bkg_no ,bkg_no_split
           cntr_tpsz_cd
          ,cntr_tpsz
          ,op_qty
          ,op_ratio_qty
          ,teu_tot
          ,feu_tot
          ,tot_teu             
    ;
    
    


------------------------------[ 변수선언부            ]-----------------------

/**작업로그 관련 변수선언 **/
v_teu_rev_amt            NUMBER(25, 13);
v_teu_oft_amt            NUMBER(25, 13);
v_teu_sec_amt            NUMBER(25, 13);
v_teu_misc_amt           NUMBER(25, 13);
v_feu_rev_amt            NUMBER(25, 13);
v_feu_oft_amt            NUMBER(25, 13);
v_feu_sec_amt            NUMBER(25, 13);
v_feu_misc_amt           NUMBER(25, 13);
v_bl_rev_amt             NUMBER(25, 13);
v_bl_oft_amt             NUMBER(25, 13);
v_bl_sec_amt             NUMBER(25, 13);
v_bl_misc_amt            NUMBER(25, 13);
v_row_cnt                NUMBER(3);
v_rev_row_cnt            NUMBER(3);        -- 해당 BKG의 coa_bkg_rev_dtl table의 row count
v_surplus_bkg_rev        NUMBER(25, 13);   --차이값 정리용
v_surplus_bkg_oft_rev    NUMBER(25, 13);   --차이값 정리용
v_surplus_bkg_misc_rev   NUMBER(25, 13);   --차이값 정리용
v_surplus_scr_chg_rev    NUMBER(25, 13);   --차이값 정리용
v_surplus_total_rev      NUMBER(25, 13);   --차이값 정리용
v_surplus_total_rev2     NUMBER(25, 13);   --차이값 정리용(oft는 제외한 값)
--v_total_bkg_qty          NUMBER(5);   --차이값 정리용
  v_total_bkg_qty       coa_bkg_rev_dtl.bkg_qty%TYPE;
v_appl_info              VARCHAR2(30);
v_eq_sub_cnt             NUMBER;
v_cost_yrmon             VARCHAR(6);

--Special에 해당하는 Q type 변환 Type 변수 선언
v_cost_rout_no_min  coa_bkg_rev_dtl.cost_rout_no%TYPE;  -- 현재 BKG의 route no 중 최소값

v_cntr_tpsz_cd_20  coa_bkg_rev_dtl.cntr_tpsz_cd%TYPE;
v_cntr_tpsz_cd_40  coa_bkg_rev_dtl.cntr_tpsz_cd%TYPE;
v_cost_rout_no_20  coa_bkg_rev_dtl.cost_rout_no%TYPE;
v_cost_rout_no_40  coa_bkg_rev_dtl.cost_rout_no%TYPE;
v_spcl_cntr_tpsz_cd_20  coa_bkg_rev_dtl.spcl_cntr_tpsz_cd%TYPE;
v_spcl_cntr_tpsz_cd_40  coa_bkg_rev_dtl.spcl_cntr_tpsz_cd%TYPE;
-------------------------------[ 업무로직 구현부       ]-----------------------
BEGIN
 
    v_appl_info := in_bkg_no ||  '#';
    enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'V.20091204', v_appl_info);
    
    /** 초기값 설정 **/
    out_result := 'Y';
    --차이 정리용
    v_surplus_bkg_rev := 0;
    v_surplus_bkg_oft_rev := 0;
    v_surplus_bkg_misc_rev := 0;
    v_surplus_scr_chg_rev := 0;
    v_surplus_total_rev := 0;
    v_surplus_total_rev2 := 0;
    v_total_bkg_qty := 0;
    v_eq_sub_cnt := 0;    
    
    -- 기준년월
    v_cost_yrmon := coa_bzc_cost_yrmon_fnc(in_bkg_no);
    
    v_row_cnt := 0;
    
    --Special에 해당하는 Q type 변환 Type 변수 초기화
    v_cost_rout_no_min := '';
    
    v_cntr_tpsz_cd_20 := '';
    v_cntr_tpsz_cd_40 := '';
    v_cost_rout_no_20 := '';
    v_cost_rout_no_40 := '';
    v_spcl_cntr_tpsz_cd_20 := '';
    v_spcl_cntr_tpsz_cd_40 := '';
       
    BEGIN
        SELECT COUNT(*)
          INTO v_row_cnt
          FROM bkg_chg_rt
         WHERE bkg_no = in_bkg_no;
           --AND chg_cd = 'OFT';                --SJH.20141017.ADD : bkg_chg_rt에 존재하는경우 조건없이 실제 운임수입이 있는 경우로 간주
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            BEGIN
                v_row_cnt := 0;
            END;
    END;
    --enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'v_row_cnt: ' || v_row_cnt, v_appl_info);

    --COA_BKG_REV_DTL : DELETE
    DELETE FROM coa_bkg_rev_dtl
     WHERE bkg_no       = in_bkg_no;
   -- enis_log_prc(SYSDATE, 'COA_BKG_COST_SMRY_PRC', 'coa_bkg_rev_dtl ' || SQL%ROWCOUNT || ' delete', v_appl_info);

    --COA_BKG_REV_DTL : INSERT
    INSERT INTO coa_bkg_rev_dtl
                               (bkg_no
                               ,cntr_tpsz_cd
                               ,bkg_qty
                               ,cost_rout_no
                               ,spcl_rc_flg     
                               ,spcl_dg_cgo_flg
                               ,spcl_bb_cgo_flg
                               ,spcl_awk_cgo_flg
                               ,rd_flg                               
                               ,soc_flg
                               ,rev_avg_flg                            --SJH.20140829.ADD
                               ,cre_usr_id
                               ,cre_dt
                               ,upd_usr_id
                               ,upd_dt
                               )
        SELECT   BKG_NO 
                 , CNTR_TPSZ_CD 
                 , SUM(CNTR_QTY) 
                 , COST_ROUT_NO 
                 , RF_SPCL_FLG 
                 , DG_SPCL_FLG 
                 , BB_SPCL_FLG 
                 , SPCL_AWK_CGO_FLG 
                 , RD_SPCL_FLG 
                 , SOC_FLG 
                 ,'Y'                                                       --SJH.20140903.ADD
                 , 'SYSTEM_COA' 
                 , SYSDATE 
                 , 'SYSTEM_COA' 
                 , SYSDATE 
        FROM     (SELECT DISTINCT A1.PCTL_NO 
                                  , A1.BKG_NO 
                                  , CASE 
                                      WHEN SUBSTR(A2.CNTR_TPSZ_CD,0,1) = 'R' 
                                           AND A1.SOC_FLG = 'Y' 
                                           AND A1.RF_SPCL_FLG = 'N' 
                                      THEN 'RD' 
                                           ||SUBSTR(A2.CNTR_TPSZ_CD,-1) 
                                      WHEN SUBSTR(A2.CNTR_TPSZ_CD,0,1) = 'R' 
                                           AND A1.RD_SPCL_FLG = 'Y' 
                                      THEN 'RD' 
                                           ||SUBSTR(A2.CNTR_TPSZ_CD,-1) 
                                      ELSE A2.CNTR_TPSZ_CD 
                                    END CNTR_TPSZ_CD  -- a2.cntr_tpsz_cd 
                                  , A2.CNTR_QTY 
                                  , A1.COST_ROUT_NO 
                                  , A1.RF_SPCL_FLG 
                                  , A1.DG_SPCL_FLG 
                                  , A1.BB_SPCL_FLG 
                                  , A1.SPCL_AWK_CGO_FLG 
                                  , A1.RD_SPCL_FLG 
                                  , A1.SOC_FLG 
                  FROM   COA_COM_PARA A1 
                        ,COA_COM_COST_PARA A2 
                  WHERE  A1.PCTL_NO = A2.PCTL_NO 
                         AND A2.CNTR_QTY > 0 
                         AND A1.BKG_NO = in_bkg_no) 
        GROUP BY BKG_NO 
                 , CNTR_TPSZ_CD 
                 , COST_ROUT_NO 
                 , COST_ROUT_NO 
                 , RF_SPCL_FLG 
                 , DG_SPCL_FLG 
                 , BB_SPCL_FLG 
                 , SPCL_AWK_CGO_FLG 
                 , RD_SPCL_FLG 
                 , SOC_FLG
    ;  
 
   -- enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'coa_bkg_rev_dtl ' || SQL%ROWCOUNT || ' Insert', v_appl_info);

    BEGIN
        SELECT COUNT(*)
          INTO v_rev_row_cnt
          FROM coa_bkg_rev_dtl
         WHERE bkg_no = in_bkg_no
        ;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            BEGIN
                v_rev_row_cnt := 0;
            END;
    END;
    
    IF v_rev_row_cnt > 0 THEN   -- coa_bkg_rev_dtl에 Data 없으면 실행 안함
        /* 2. Dead Space관련 Void Vol 세팅(있으면 update, 없으면 insert) -----------------------------------------*/      
        SELECT MIN(cost_rout_no)
          INTO v_cost_rout_no_min
          FROM coa_bkg_rev_dtl
         WHERE bkg_no = in_bkg_no
        ;

        MERGE INTO coa_bkg_rev_dtl c1
        USING (
               SELECT  b2.bkg_no
                      ,b2.cntr_tpsz_cd
                      ,b2.cost_rout_no
                      ,b2.bkg_qty
                      ,b3.spcl_rc_flg
                      ,b3.spcl_dg_cgo_flg
                      ,b3.spcl_bb_cgo_flg
                      ,b3.spcl_awk_cgo_flg
                      ,b3.rd_flg
                      ,b3.soc_flg
                 FROM     
                  ( SELECT a1.bkg_no
                         ,a1.cntr_tpsz_cd
                         ,a1.op_cntr_qty bkg_qty
                         ,v_cost_rout_no_min AS cost_rout_no
                     FROM BKG_QUANTITY a1
                    WHERE a1.bkg_no       = in_bkg_no
                      AND a1.cntr_tpsz_cd LIKE 'Q%'
                  ) b2
                  ,(SELECT a2.bkg_no
                         ,a2.spcl_rc_flg
                         ,a2.spcl_dg_cgo_flg
                         ,a2.spcl_bb_cgo_flg
                         ,a2.spcl_awk_cgo_flg
                         ,a2.rd_flg
                         ,a2.soc_flg
                     FROM COA_RGST_BKG a2
                    WHERE a2.bkg_no       = in_bkg_no
                  ) b3
              WHERE b2.bkg_no = b3.bkg_no
              ) c2     
           ON (    c1.bkg_no       = c2.bkg_no
               AND c1.cntr_tpsz_cd = c2.cntr_tpsz_cd
               AND c1.cost_rout_no = c2.cost_rout_no
               )
         WHEN NOT MATCHED THEN
            INSERT(c1.bkg_no, c1.cntr_tpsz_cd, c1.cost_rout_no, c1.bkg_qty, c1.spcl_rc_flg, c1.spcl_dg_cgo_flg, c1.spcl_awk_cgo_flg, c1.spcl_bb_cgo_flg, c1.rd_flg, c1.soc_flg, c1.cre_usr_id, c1.cre_dt, c1.upd_usr_id, c1.upd_dt)
            VALUES(c2.bkg_no, c2.cntr_tpsz_cd, c2.cost_rout_no, c2.bkg_qty, c2.spcl_rc_flg, c2.spcl_dg_cgo_flg, c2.spcl_awk_cgo_flg, c2.spcl_bb_cgo_flg, c2.rd_flg, c2.soc_flg, 'SYSTEM_COA',  SYSDATE,   'SYSTEM_COA',  SYSDATE)
         WHEN MATCHED THEN
            UPDATE
               SET c1.bkg_qty             = c2.bkg_qty
                  ,c1.bkg_rev             = NULL
                  ,c1.bkg_oft_rev         = NULL
                  ,c1.bkg_misc_rev        = NULL
                  ,c1.scr_chg_rev         = NULL
                  ,c1.rev_act_flg         = NULL
                  ,c1.estm_cm_cost_amt    = NULL
                  ,c1.estm_opfit_cost_amt = NULL
                  ,c1.ra_cm_cost_amt      = NULL
                  ,c1.ra_opfit_cost_amt   = NULL
                  ,c1.act_cm_cost_amt     = NULL
                  ,c1.act_opfit_cost_amt  = NULL
                  ,c1.accl_rt_amt         = NULL
                  ,c1.shpr_cntr_tpsz_cd   = NULL
                  ,c1.shpr_cntr_qty       = NULL
                  ,c1.cre_usr_id          = 'SYSTEM_COA'
                  ,c1.cre_dt              = SYSDATE
                  ,c1.upd_usr_id          = 'SYSTEM_COA'
                  ,c1.upd_dt              = SYSDATE
                  ,c1.spcl_rc_flg         = NULL
                  ,c1.spcl_dg_cgo_flg     = NULL
                  ,c1.spcl_bb_cgo_flg     = NULL
                  ,c1.spcl_awk_cgo_flg    = NULL
                  ,c1.rd_flg              = NULL
                  ,c1.soc_flg             = NULL
                  ,c1.delt_flg            = 'N'
                  ,c1.ra_opfit_act_amt    = NULL
                  ,c1.ra_act_cm_amt       = NULL
                  ,c1.fcgo_tz_dys         = NULL
                  ,c1.fcgo_tz_hrs         = NULL
                  ,c1.mcgo_tz_dys         = NULL
                  ,c1.mcgo_tz_hrs         = NULL
        ;
            
        /* 3. Special Container Type Size Update -----------------------------------------*/
        UPDATE coa_bkg_rev_dtl
           SET spcl_cntr_tpsz_cd = coa_ut_tpsz_fnc('TPS', cntr_tpsz_cd)
                  --SJH.20141021.ADD  : bkg_chg_rt에 존재하는경우 조건없이 실제 운임수입이 있는 경우로 간주
                 ,rev_avg_flg = decode(nvl(v_row_cnt,0),0,'Y','N')
         WHERE bkg_no = in_bkg_no
        ;
        --enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', '3. Special Container Type Size Update', v_appl_info);
        
        /* 4. Dead Space Special Container Type Size Update -----------------------------------------
              Q type은 rout_no와 무관하게 처리됨
              SIZE별로 분리하여 F,O 가 섞여있는 경우에 대해서는 F로 처리함. 둘다 없을 경우 SP로 변환 
              spcl_cntr_tpsz_cd와 일치하는 MIN rout로 Q type의 rout_no를 변경 */      
              
        -- spcl_tpsz_cd 구하기
        BEGIN
            SELECT MAX(DECODE(c1.q_tpsz_cd, 'Q2', cntr_tpsz_cd))      AS v_cntr_tpsz_cd_20
                  ,MAX(DECODE(c1.q_tpsz_cd, 'Q2', cost_rout_no))      AS v_cost_rout_no_20
                  ,MAX(DECODE(c1.q_tpsz_cd, 'Q2', spcl_cntr_tpsz_cd)) AS v_spcl_cntr_tpsz_cd_20
                  ,MAX(DECODE(c1.q_tpsz_cd, 'Q4', cntr_tpsz_cd))      AS v_cntr_tpsz_cd_40
                  ,MAX(DECODE(c1.q_tpsz_cd, 'Q4', cost_rout_no))      AS v_cost_rout_no_40
                  ,MAX(DECODE(c1.q_tpsz_cd, 'Q4', spcl_cntr_tpsz_cd)) AS v_spcl_cntr_tpsz_cd_40
              INTO v_cntr_tpsz_cd_20
                  ,v_cost_rout_no_20
                  ,v_spcl_cntr_tpsz_cd_20
                  ,v_cntr_tpsz_cd_40
                  ,v_cost_rout_no_40
                  ,v_spcl_cntr_tpsz_cd_40
              FROM (SELECT 'Q2' AS q_tpsz_cd
                      FROM DUAL
                     UNION ALL
                    SELECT 'Q4' AS q_tpsz_cd
                      FROM DUAL
                   ) c1
                  ,(
                    SELECT q_tpsz_cd
                          ,cntr_tpsz_cd
                          ,cost_rout_no
                          ,spcl_cntr_tpsz_cd
                          ,COUNT(*) OVER() AS ttl_cnt      -- 전체 Q type의 개수.
                      FROM (
                            -- Q2   
                            SELECT 'Q2' AS q_tpsz_cd
                                  ,cntr_tpsz_cd
                                  ,cost_rout_no
                                  ,spcl_cntr_tpsz_cd
                              FROM (
                                    SELECT cntr_tpsz_cd
                                          ,cost_rout_no
                                          ,spcl_cntr_tpsz_cd
                                      FROM coa_bkg_rev_dtl
                                     WHERE bkg_no = in_bkg_no
                                       AND SUBSTR(cntr_tpsz_cd, 1, 1) IN ('A', 'S', 'F', 'O')      -- F,O 이외는 변환없이 무시
                                       AND SUBSTR(cntr_tpsz_cd, -1) = '2'
                                    ORDER BY spcl_cntr_tpsz_cd, cost_rout_no, bkg_qty DESC         -- F type, rout_no가 빠른것, qty가 큰것을 우선함
                                   )
                             WHERE ROWNUM = 1
                             UNION ALL
                            -- Q4
                            SELECT 'Q4' AS q_tpsz_cd
                                  ,cntr_tpsz_cd
                                  ,cost_rout_no
                                  ,spcl_cntr_tpsz_cd
                              FROM (
                                    SELECT cntr_tpsz_cd
                                          ,cost_rout_no
                                          ,spcl_cntr_tpsz_cd
                                      FROM coa_bkg_rev_dtl
                                     WHERE bkg_no = in_bkg_no
                                       AND SUBSTR(cntr_tpsz_cd, 1, 1) IN ('A', 'S', 'F', 'O')      -- F,O 이외는 변환없이 무시
                                       AND SUBSTR(cntr_tpsz_cd, -1) <> '2'
                                    ORDER BY spcl_cntr_tpsz_cd, cost_rout_no, bkg_qty DESC         -- F type, rout_no가 빠른것, qty가 큰것을 우선함
                                   )
                             WHERE ROWNUM = 1
                           )
                   ) c2   
             WHERE c1.q_tpsz_cd = CASE 
                                    WHEN c2.ttl_cnt = 1 
                                      THEN c1.q_tpsz_cd 
                                    ELSE c2.q_tpsz_cd 
                                  END                       -- Q2 또는 Q4 한개만 있을 경우 각각 Q4, Q2를 만들어 줌
            ;
            
            -- Q2, Q4 둘다 없을 경우 처음꺼에 넣어줌   
            IF (v_spcl_cntr_tpsz_cd_20 IS NULL AND v_spcl_cntr_tpsz_cd_40 IS NULL) 
            THEN
                 BEGIN
                    SELECT MAX(DECODE(a1.q_tpsz_cd, 'Q2', a2.cntr_tpsz_cd))      AS v_cntr_tpsz_cd_20
                          ,MAX(DECODE(a1.q_tpsz_cd, 'Q2', a2.cost_rout_no))      AS v_cost_rout_no_20
                          ,MAX(DECODE(a1.q_tpsz_cd, 'Q2', a2.spcl_cntr_tpsz_cd)) AS v_spcl_cntr_tpsz_cd_20
                          ,MAX(DECODE(a1.q_tpsz_cd, 'Q4', a2.cntr_tpsz_cd))      AS v_cntr_tpsz_cd_40
                          ,MAX(DECODE(a1.q_tpsz_cd, 'Q4', a2.cost_rout_no))      AS v_cost_rout_no_40
                          ,MAX(DECODE(a1.q_tpsz_cd, 'Q4', a2.spcl_cntr_tpsz_cd)) AS v_spcl_cntr_tpsz_cd_40
                      INTO v_cntr_tpsz_cd_20
                          ,v_cost_rout_no_20
                          ,v_spcl_cntr_tpsz_cd_20
                          ,v_cntr_tpsz_cd_40
                          ,v_cost_rout_no_40
                          ,v_spcl_cntr_tpsz_cd_40
                      FROM (SELECT 'Q2' AS q_tpsz_cd
                              FROM DUAL
                             UNION ALL
                            SELECT 'Q4' AS q_tpsz_cd
                              FROM DUAL
                           ) a1
                          ,(SELECT cntr_tpsz_cd
                                  ,cost_rout_no
                                  ,spcl_cntr_tpsz_cd
                              FROM coa_bkg_rev_dtl
                             WHERE bkg_no = in_bkg_no
                               AND cntr_tpsz_cd NOT LIKE 'Q%'
                               AND ROWNUM = 1
                           ) a2
                    ;
                    enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'Q2, Q4 둘다 없을 경우');
                 END;
            END IF;
                 
            EXCEPTION
                WHEN OTHERS THEN
                     BEGIN
                         v_spcl_cntr_tpsz_cd_20 := 'SP2';
                         v_spcl_cntr_tpsz_cd_40 := 'SP4';
                         v_cost_rout_no_20 := v_cost_rout_no_min;
                         v_cost_rout_no_40 := v_cost_rout_no_min;
    --                    -- enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'NO_DATA_FOUND');
                     END;
            END;
            
            -- Q에 해당하는 Special type을 못찾으면 금액은 Step7에서 전체에 TEU기준으로 배부됨.
            UPDATE coa_bkg_rev_dtl
               SET cost_rout_no = v_cost_rout_no_20
                  ,spcl_cntr_tpsz_cd = v_spcl_cntr_tpsz_cd_20
             WHERE bkg_no = in_bkg_no
               AND cntr_tpsz_cd = 'Q2'
            ;
           
            UPDATE coa_bkg_rev_dtl
               SET cost_rout_no = v_cost_rout_no_40
                  ,spcl_cntr_tpsz_cd = v_spcl_cntr_tpsz_cd_40
             WHERE bkg_no = in_bkg_no
               AND cntr_tpsz_cd = 'Q4'
            ;
            
        -- Q type의 special flag를 원 타입으로 Update[20090422]
        MERGE INTO coa_bkg_rev_dtl a1
             USING (
                    SELECT a1.bkg_no
                          ,a1.cntr_tpsz_cd a_tpsz
                          ,a1.spcl_cntr_tpsz_cd a_spcl_cntr
                          ,a2.cntr_tpsz_cd
                          ,a2.spcl_cntr_tpsz_cd
                          ,a1.cost_rout_no
                          ,a1.spcl_rc_flg
                          ,a1.spcl_dg_cgo_flg
                          ,a1.spcl_bb_cgo_flg
                          ,a1.spcl_awk_cgo_flg
                          ,a1.rd_flg
                          ,a1.soc_flg
                      FROM coa_bkg_rev_dtl a1
                          ,(
                           select bkg_no,cost_rout_no,cntr_tpsz_cd,spcl_cntr_tpsz_cd
                             from coa_bkg_rev_dtl
                            where cntr_tpsz_cd LIKE 'Q%'
                              and bkg_no       = in_bkg_no
                            ) a2
                     WHERE 1=1
                       AND a1.bkg_no            = in_bkg_no
                       AND a1.bkg_no            = a2.bkg_no
                       AND a1.cost_rout_no      = a2.cost_rout_no
                       AND a1.spcl_cntr_tpsz_cd = a2.spcl_cntr_tpsz_cd
                       AND a1.cntr_tpsz_cd      NOT LIKE 'Q%'
                       AND SUBSTR(a1.cntr_tpsz_cd, 1, 1) IN ('F','A','S','O')
                       AND a1.cntr_tpsz_cd      = a1.spcl_cntr_tpsz_cd
                       AND a1.SPCL_RC_FLG       is not null
                    ) a2
                 ON (
                         a1.bkg_no            = a2.bkg_no
                     and a1.cost_rout_no      = a2.cost_rout_no
                     and a1.cntr_tpsz_cd      = a2.cntr_tpsz_cd
                     and a1.cntr_tpsz_cd      like 'Q%'
                    )
        WHEN MATCHED THEN
          UPDATE
             SET a1.spcl_rc_flg      = a2.spcl_rc_flg
                ,a1.spcl_dg_cgo_flg  = a2.spcl_dg_cgo_flg
                ,a1.spcl_bb_cgo_flg  = a2.spcl_bb_cgo_flg
                ,a1.spcl_awk_cgo_flg = a2.spcl_awk_cgo_flg
                ,a1.rd_flg           = a2.rd_flg
                ,a1.soc_flg          = a2.soc_flg
          ;            
                 
        IF (v_row_cnt >= 1) THEN   /* 실제 운임수입이 있는 경우 */
            -------------------------------[ Revenue를 각 container Type Size TEU,FEU 별로 UPdate 로직]----------------------------
                 -- enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'line 234, step1:::: 순수 cntr_tpsz_cd 적용 IF문');
            
            BEGIN
    --          EQ SUB 있는지 확인
                SELECT COUNT(*)
                  INTO v_eq_sub_cnt
                  FROM BKG_QUANTITY
                 WHERE bkg_no = in_bkg_no
                   AND EQ_SUBST_CGO_QTY > 0
                   AND EQ_SUBST_CNTR_TPSZ_CD IS NOT NULL
                ; --Column

            EXCEPTION
                WHEN OTHERS THEN
                BEGIN
                    v_eq_sub_cnt := 0;
                END;
            END;
            
            IF v_eq_sub_cnt = 0 THEN
                /* step1-1:::: 순수 cntr_tpsz_cd 적용 - EQ SUB가 없을 경우*/            
                MERGE INTO coa_bkg_rev_dtl f1
                USING (
                       SELECT b1.bkg_no
                             ,b1.cost_rout_no
                             ,b1.cntr_tpsz_cd
                             ,b2.bkg_rev      * (b1.bkg_qty / DECODE(b1.ttl_bkg_qty, 0, 1, NULL, 1, b1.ttl_bkg_qty)) AS bkg_rev
                             ,b2.bkg_oft_rev  * (b1.bkg_qty / DECODE(b1.ttl_bkg_qty, 0, 1, NULL, 1, b1.ttl_bkg_qty)) AS bkg_oft_rev
                             ,b2.scr_chg_rev  * (b1.bkg_qty / DECODE(b1.ttl_bkg_qty, 0, 1, NULL, 1, b1.ttl_bkg_qty)) AS scr_chg_rev
                             ,b2.bkg_misc_rev * (b1.bkg_qty / DECODE(b1.ttl_bkg_qty, 0, 1, NULL, 1, b1.ttl_bkg_qty)) AS bkg_misc_rev
                             ,'Y' AS rev_act_flg
                             ,'SYSTEM_COA' AS cre_usr_id
                             ,SYSDATE AS cre_dt
                             ,'SYSTEM_COA' AS upd_usr_id
                             ,SYSDATE AS upd_dt
                         FROM (-- tpsz별 물량을 가져오는 부분
                               SELECT bkg_no
                                     ,cost_rout_no
                                     ,cntr_tpsz_cd
                                     ,REPLACE(cntr_tpsz_cd, 'RD', 'R') AS cnvt_cntr_tpsz_cd   -- RD와 R은 둘다 R로 rate됨
                                     ,bkg_qty
                                     ,SUM(bkg_qty) OVER (PARTITION BY bkg_no, REPLACE(cntr_tpsz_cd, 'RD', 'R')) AS ttl_bkg_qty
                                 FROM coa_bkg_rev_dtl
                                WHERE bkg_no = in_bkg_no
                                  AND cntr_tpsz_cd NOT LIKE 'Q%'             -- Q type 제외
                              ) b1
                             ,(-- Rate를 USD로 변환하여 각각 분리하는 부분 
                               SELECT a1.bkg_no
                                     ,a1.RAT_UT_CD
                                     ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411111', DECODE(a1.CHG_CD, 'OFT', 0, a1.CHG_AMT / a3.usd_locl_xch_rt), 0)) AS bkg_rev
                                     ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411111', DECODE(a1.CHG_CD, 'OFT', a1.CHG_AMT / a3.usd_locl_xch_rt, 0))) AS bkg_oft_rev
                                     ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411914', a1.CHG_AMT / a3.usd_locl_xch_rt, 0)) AS scr_chg_rev
                                     ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411915', a1.CHG_AMT / a3.usd_locl_xch_rt, 0)) AS bkg_misc_rev
                                 FROM BKG_CHG_RT a1
                                     ,mdm_charge a2
                                     ,gl_mon_xch_rt a3
                                WHERE a1.bkg_no          = in_bkg_no
                                  AND a1.CHG_CD       = a2.chg_cd
                                  AND a2.CO_CHG_ACCT_CD IN ('411111','411914','411915')
                                  AND TO_CHAR(a1.cre_dt, 'YYYYMM') = a3.acct_xch_rt_yrmon
                                  AND a3.acct_xch_rt_lvl = '1'
                                  AND a1.CURR_CD         = a3.CURR_CD          
                                  AND a1.dp_seq          = DECODE(a1.CHG_CD, 'DIH', 430, a1.dp_seq)   -- DIH의 경우 dp_seq = 430
                                  AND (   a1.CHG_CD NOT IN('DOD', 'TVA')
                                       OR a1.de_term_cd     <> 'H'
                                       OR a1.PRN_HDN_FLG <> '1'
                                       OR NOT EXISTS(
                                                     SELECT 'X'
                                                       FROM bkg_booking bkg
                                                      WHERE bkg.bkg_no       = a1.bkg_no
                                                        AND bkg.pod_cd       = bkg.del_cd
                                                        AND bkg.de_term_cd   IN ('Y', 'H'))
                                      )
                                  AND a1.FRT_INCL_XCLD_DIV_CD  = 'N'
                                  AND REGEXP_LIKE(a1.RAT_UT_CD, '^[[:alpha:]]{1}[[:digit:]]{1}') -- 숫자+문자로된 순수 TPSZ만 처리
                                  AND a1.RAT_UT_CD NOT LIKE 'Q%'             -- Q type 제외
                                GROUP BY a1.bkg_no
                                     ,a1.RAT_UT_CD) b2
                        WHERE b1.bkg_no            = b2.bkg_no
                          AND b1.cnvt_cntr_tpsz_cd = b2.RAT_UT_CD
                      ) f2
                   ON (    f1.bkg_no       = f2.bkg_no
                       AND f1.cntr_tpsz_cd = f2.cntr_tpsz_cd
                       AND f1.cost_rout_no = f2.cost_rout_no)
                  WHEN MATCHED THEN
                    UPDATE
                       SET f1.bkg_rev        = f2.bkg_rev
                          ,f1.bkg_oft_rev    = f2.bkg_oft_rev
                          ,f1.bkg_misc_rev   = f2.bkg_misc_rev  -- 20080304 PEJ m.sec와 m.misc가 잘 못 매핑되어 변경
                          ,f1.scr_chg_rev    = f2.scr_chg_rev   -- 20080304 PEJ m.sec와 m.misc가 잘 못 매핑되어 변경
                          ,f1.rev_act_flg    = f2.rev_act_flg
                          ,f1.etc_ut_rev_amt = 0     -- Default로 0을 넣어 준다.
                          ,f1.upd_usr_id     = f2.upd_usr_id
                          ,f1.upd_dt         = f2.upd_dt
                ;
    
           -- enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'EQ SUB 없음', v_appl_info);            
            ELSE
                /* step1-2:::: 순수 cntr_tpsz_cd 적용 - EQ SUB가 있을 경우*/
    
                /* step1-2.1:::: tpsz별로 Min QTY를 기준으로 amt update*/    
                MERGE INTO coa_bkg_rev_dtl f1
                USING (
                       SELECT bkg_no
                             ,cntr_tpsz_cd
                             ,cost_rout_no
                             ,NVL(bkg_rev, 0)      AS bkg_rev
                             ,NVL(bkg_oft_rev, 0)  AS bkg_oft_rev
                             ,NVL(bkg_misc_rev, 0) AS bkg_misc_rev
                             ,NVL(scr_chg_rev, 0)  AS scr_chg_rev
                             ,'Y' AS rev_act_flg
                             ,'SYSTEM_COA' AS cre_usr_id
                             ,SYSDATE AS cre_dt
                             ,'SYSTEM_COA' AS upd_usr_id
                             ,SYSDATE AS upd_dt 
                         FROM (
                               SELECT c1.bkg_no
                                     ,c1.cntr_tpsz_cd
                                     ,c1.cost_rout_no
                                     ,c2.bkg_rev_uc_amt      * LEAST(c1.teu_bkg_qty,c2.teu_cntr_qty) AS bkg_rev  -- TPSZ별 금액
                                     ,c2.bkg_oft_rev_uc_amt  * LEAST(c1.teu_bkg_qty,c2.teu_cntr_qty) AS bkg_oft_rev
                                     ,c2.bkg_misc_rev_uc_amt * LEAST(c1.teu_bkg_qty,c2.teu_cntr_qty) AS bkg_misc_rev
                                     ,c2.scr_chg_rev_uc_amt  * LEAST(c1.teu_bkg_qty,c2.teu_cntr_qty) AS scr_chg_rev
                                 FROM (SELECT bkg_no
                                             ,cntr_tpsz_cd
                                             ,cost_rout_no
                                             ,DECODE(SUBSTR(cntr_tpsz_cd, -1), '2', bkg_qty, bkg_qty*2) AS teu_bkg_qty
                                             ,REPLACE(cntr_tpsz_cd, 'RD', 'R') AS org_cntr_tpsz_cd
                                         FROM coa_bkg_rev_dtl
                                        WHERE bkg_no = in_bkg_no
                                          AND cntr_tpsz_cd NOT LIKE 'Q%'              -- Q type 제외
                                      ) c1
                                     ,(SELECT b1.bkg_no
                                             ,b1.RAT_UT_CD
                                             ,b1.teu_cntr_qty
                                             ,b1.bkg_rev      / b1.teu_cntr_qty AS bkg_rev_uc_amt  -- 단가
                                             ,b1.bkg_oft_rev  / b1.teu_cntr_qty AS bkg_oft_rev_uc_amt
                                             ,b1.bkg_misc_rev / b1.teu_cntr_qty AS bkg_misc_rev_uc_amt
                                             ,b1.scr_chg_rev  / b1.teu_cntr_qty AS scr_chg_rev_uc_amt
                                         FROM (         
                                               SELECT a1.bkg_no
                                                     ,a1.RAT_UT_CD
                                                     ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411111', DECODE(a1.CHG_CD, 'OFT', 0, a1.CHG_AMT / a3.usd_locl_xch_rt), 0)) AS bkg_rev -- 금액
                                                     ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411111', DECODE(a1.CHG_CD, 'OFT', a1.CHG_AMT / a3.usd_locl_xch_rt, 0))) AS bkg_oft_rev
                                                     ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411915', a1.CHG_AMT / a3.usd_locl_xch_rt, 0)) AS bkg_misc_rev
                                                     ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411914', a1.CHG_AMT / a3.usd_locl_xch_rt, 0)) AS scr_chg_rev
                                                     ,NVL(AVG(a4.cntr_qty), 1) AS teu_cntr_qty  -- Rate 물량 계정별 평균물량으로 사용
                                                 FROM BKG_CHG_RT a1
                                                     ,mdm_charge a2
                                                     ,gl_mon_xch_rt a3
                                                     ,(SELECT   bkg_no
                                                               ,RAT_UT_CD
                                                               ,CHG_CD
                                                               ,SUM(DECODE(SUBSTR(RAT_UT_CD, -1), '2', RAT_AS_QTY, RAT_AS_QTY*2)) cntr_qty
                                                         FROM BKG_CHG_RT
                                                        WHERE bkg_no = in_bkg_no
                                                          AND REGEXP_LIKE(RAT_UT_CD, '^[[:alpha:]]{1}[[:digit:]]{1}') -- 숫자+문자로된 순수 TPSZ만 처리
                                                       GROUP BY bkg_no
                                                               ,RAT_UT_CD
                                                               ,CHG_CD) a4
                                                WHERE a1.bkg_no            = in_bkg_no
                                                  AND a1.CHG_CD         = a2.chg_cd
                                                  AND a1.bkg_no = a4.bkg_no                    --
                                                  AND a1.RAT_UT_CD = a4.RAT_UT_CD    --
                                                  AND a1.CHG_CD = a4.CHG_CD              -- CHG CD별 , CNTR TPSZ 별 SUM 하여 구한 물량을 쓰기 위해 Join
                                                  AND a2.CO_CHG_ACCT_CD   IN ('411111','411914','411915')
                                                  AND TO_CHAR(a1.cre_dt, 'YYYYMM') = a3.acct_xch_rt_yrmon
                                                  AND a1.CURR_CD           = a3.CURR_CD
                                                  AND a3.acct_xch_rt_lvl   = '1'
                                                  AND a1.dp_seq            = DECODE(a1.CHG_CD, 'DIH', 430, a1.dp_seq)   -- DIH의 경우 dp_seq = 430인 것만
                                                  AND (   a1.CHG_CD NOT IN('DOD', 'TVA')
                                                       OR a1.de_term_cd     <> 'H'
                                                       OR a1.PRN_HDN_FLG <> '1'
                                                       OR NOT EXISTS(
                                                                     SELECT 'X'
                                                                       FROM bkg_booking bkg
                                                                      WHERE bkg.bkg_no       = a1.bkg_no
                                                                        AND bkg.pod_cd       = bkg.del_cd
                                                                        AND bkg.de_term_cd   IN ('Y', 'H'))
                                                      )   --위 주석 조건 변경 끝
                                                  AND a1.FRT_INCL_XCLD_DIV_CD    = 'N'
                                                  AND REGEXP_LIKE(a1.RAT_UT_CD, '^[[:alpha:]]{1}[[:digit:]]{1}') -- 숫자+문자로된 순수 TPSZ만 처리
                                                  AND a1.RAT_UT_CD NOT LIKE 'Q%'             -- Q type 제외
                                                GROUP BY a1.bkg_no
                                                     ,a1.RAT_UT_CD
                                              ) b1       
                                      ) c2
                                WHERE c1.bkg_no           = c2.bkg_no (+)
                                  AND c1.org_cntr_tpsz_cd = c2. RAT_UT_CD (+)  -- 20080311 PEJ 변경
                              )
                      ) f2       
                   ON (    f1.bkg_no       = f2.bkg_no
                       AND f1.cntr_tpsz_cd = f2.cntr_tpsz_cd
                       AND f1.cost_rout_no = f2.cost_rout_no)
                  WHEN MATCHED THEN
                    UPDATE
                       SET f1.bkg_rev        = f2.bkg_rev
                          ,f1.bkg_oft_rev    = f2.bkg_oft_rev
                          ,f1.bkg_misc_rev   = f2.bkg_misc_rev  
                          ,f1.scr_chg_rev    = f2.scr_chg_rev   
                          ,f1.rev_act_flg    = f2.rev_act_flg
                          ,f1.etc_ut_rev_amt = 0     -- Default로 0을 넣어 준다.
                          ,f1.upd_usr_id     = f2.upd_usr_id
                          ,f1.upd_dt         = f2.upd_dt
                ;
    
           -- enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'EQ SUB merge update', v_appl_info);     
                
                /* step1-2.2:::: tpsz별로 차액을 배부하여 amt update*/    
                MERGE INTO coa_bkg_rev_dtl f1
                USING (            
                       SELECT bkg_no
                             ,cntr_tpsz_cd
                             ,cost_rout_no
                             ,alloc_bkg_rev      * alloc_ratio AS bkg_rev -- 배부될 금액 * 배부율
                             ,alloc_bkg_oft_rev  * alloc_ratio AS bkg_oft_rev
                             ,alloc_bkg_misc_rev * alloc_ratio AS bkg_misc_rev
                             ,alloc_scr_chg_rev  * alloc_ratio AS scr_chg_rev
                             ,'Y' AS rev_act_flg
                             ,'SYSTEM_COA' AS cre_usr_id
                             ,SYSDATE AS cre_dt
                             ,'SYSTEM_COA' AS upd_usr_id
                             ,SYSDATE AS upd_dt 
                         FROM (
                               SELECT c2.bkg_no
                                     ,c2.cntr_tpsz_cd
                                     ,c2.cost_rout_no
                                     ,DECODE(c2.ttl_alloc_teu_qty, 0, 0
                                                                 ,c2.alloc_teu_qty  / c2.ttl_alloc_teu_qty) AS alloc_ratio    -- 배부율
                                     ,NVL(c1.ttl_bkg_rev, 0)      - NVL(c2.ttl_bkg_rev, 0) AS alloc_bkg_rev     -- 배부될 금액 = Rate 전체 금액 - rev_dtl 전체 금액
                                     ,NVL(c1.ttl_bkg_oft_rev, 0)  - NVL(c2.ttl_bkg_oft_rev, 0) AS alloc_bkg_oft_rev
                                     ,NVL(c1.ttl_bkg_misc_rev, 0) - NVL(c2.ttl_bkg_misc_rev, 0) AS alloc_bkg_misc_rev
                                     ,NVL(c1.ttl_scr_chg_rev, 0)  - NVL(c2.ttl_scr_chg_rev, 0) AS alloc_scr_chg_rev
                                 FROM (
                                       SELECT a1.bkg_no
                                             ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411111', DECODE(a1.CHG_CD, 'OFT', 0, a1.CHG_AMT / a3.usd_locl_xch_rt), 0)) AS ttl_bkg_rev -- Rate 전체금액
                                             ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411111', DECODE(a1.CHG_CD, 'OFT', a1.CHG_AMT / a3.usd_locl_xch_rt, 0))) AS ttl_bkg_oft_rev
                                             ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411915', a1.CHG_AMT / a3.usd_locl_xch_rt, 0)) AS ttl_bkg_misc_rev
                                             ,SUM(DECODE(a2.CO_CHG_ACCT_CD, '411914', a1.CHG_AMT / a3.usd_locl_xch_rt, 0)) AS ttl_scr_chg_rev
                                             ,NVL(AVG(a4.cntr_qty), 1) AS teu_cntr_qty  -- Rate 물량 계정별 평균물량으로 사용
                                         FROM BKG_CHG_RT a1
                                             ,mdm_charge a2
                                             ,gl_mon_xch_rt a3
                                             ,(SELECT bkg_no
                                                     ,RAT_UT_CD
                                                     ,CHG_CD
                                                     ,SUM(DECODE(SUBSTR(RAT_UT_CD, -1), '2', RAT_AS_QTY, RAT_AS_QTY*2)) cntr_qty
                                                 FROM BKG_CHG_RT
                                                WHERE bkg_no = in_bkg_no
                                                  AND REGEXP_LIKE(RAT_UT_CD, '^[[:alpha:]]{1}[[:digit:]]{1}') -- 숫자+문자로된 순수 TPSZ만 처리
                                               GROUP BY bkg_no
                                                       ,RAT_UT_CD
                                                       ,CHG_CD) a4
                                        WHERE a1.bkg_no            = in_bkg_no
                                          AND a1.CHG_CD         = a2.chg_cd
                                          AND a1.bkg_no = a4.bkg_no                    --
                                          AND a1.RAT_UT_CD = a4.RAT_UT_CD    --
                                          AND a1.CHG_CD = a4.CHG_CD              -- CHG CD별 , CNTR TPSZ 별 SUM 하여 구한 물량을 쓰기 위해 Join
                                          AND a2.CO_CHG_ACCT_CD   IN ('411111','411914','411915')
                                          AND TO_CHAR(a1.cre_dt, 'YYYYMM') = a3.acct_xch_rt_yrmon
                                          AND a1.CURR_CD           = a3.CURR_CD
                                          AND a3.acct_xch_rt_lvl   = '1'
                                          AND a1.dp_seq            = DECODE(a1.CHG_CD, 'DIH', 430, a1.dp_seq)   -- DIH의 경우 dp_seq = 430인 것만
                                          AND (   a1.CHG_CD NOT IN('DOD', 'TVA')
                                               OR a1.de_term_cd     <> 'H'
                                               OR a1.PRN_HDN_FLG <> '1'
                                               OR NOT EXISTS(
                                                             SELECT 'X'
                                                               FROM bkg_booking bkg
                                                              WHERE bkg.bkg_no       = a1.bkg_no
                                                                AND bkg.pod_cd       = bkg.del_cd
                                                                AND bkg.de_term_cd   IN ('Y', 'H'))
                                              )   --위 주석 조건 변경 끝
                                          AND a1.FRT_INCL_XCLD_DIV_CD    = 'N'
                                          AND REGEXP_LIKE(a1.RAT_UT_CD, '^[[:alpha:]]{1}[[:digit:]]{1}') -- 숫자+문자로된 순수 TPSZ만 처리
                                          AND a1.RAT_UT_CD NOT LIKE 'Q%'             -- Q type 제외
                                        GROUP BY a1.bkg_no
                                      ) c1   
                                     ,(SELECT b1.bkg_no
                                             ,b1.cntr_tpsz_cd
                                             ,b1.cost_rout_no
                                             ,DECODE(SUBSTR(b1.cntr_tpsz_cd, -1), '2', b1.alloc_qty, b1.alloc_qty*2) AS alloc_teu_qty                   -- 배부 받을 QTY
                                             ,SUM(DECODE(SUBSTR(b1.cntr_tpsz_cd, -1), '2', b1.alloc_qty, b1.alloc_qty*2)) OVER() AS ttl_alloc_teu_qty   -- 전체 QTY
                                             ,SUM(b1.bkg_rev)      OVER() AS ttl_bkg_rev             -- step1-2.1에서 업데이트된 현재 rev_dtl에 있는 전체 bkg_rev
                                             ,SUM(b1.bkg_oft_rev)  OVER() AS ttl_bkg_oft_rev
                                             ,SUM(b1.bkg_misc_rev) OVER() AS ttl_bkg_misc_rev
                                             ,SUM(b1.scr_chg_rev)  OVER() AS ttl_scr_chg_rev
                                         FROM (SELECT a1.bkg_no
                                                     ,a1.cntr_tpsz_cd
                                                     ,a1.cost_rout_no
                                                     ,DECODE(SIGN(NVL(a2.cntr_qty, 0) - NVL(a1.bkg_qty, 0)), -1, NVL(a1.bkg_qty, 0) - NVL(a2.cntr_qty, 0), 0) AS alloc_qty 
                                                                                                                            -- Rev. qty - rate qty 가 0보다 큰 경우만 고려
                                                     ,a1.bkg_rev
                                                     ,a1.bkg_oft_rev
                                                     ,a1.bkg_misc_rev
                                                     ,a1.scr_chg_rev   
                                                 FROM coa_bkg_rev_dtl a1
                                                     ,(SELECT bkg_no
                                                             ,RAT_UT_CD
                                                             ,AVG(DECODE(SUBSTR(RAT_UT_CD, -1), '2', RAT_AS_QTY, RAT_AS_QTY*2)) AS cntr_qty
                                                            -- ,AVG(cntr_qty) AS cntr_qty
                                                         FROM BKG_CHG_RT
                                                        WHERE REGEXP_LIKE(RAT_UT_CD, '^[[:alpha:]]{1}[[:digit:]]{1}') -- 숫자+문자로된 순수 TPSZ만 처리
                                                        GROUP BY bkg_no
                                                             ,RAT_UT_CD
                                                      ) a2
                                                WHERE a1.bkg_no            = in_bkg_no
                                                  AND a1.bkg_no = a2.bkg_no (+)
                                                  AND REPLACE(a1.cntr_tpsz_cd, 'RD', 'R') = a2.RAT_UT_CD (+)
                                                  AND a1.cntr_tpsz_cd not like 'Q%'
                                              ) b1
                                      ) c2
                                WHERE c1.bkg_no         (+) = c2.bkg_no          
                              )
                      ) f2       
                   ON (    f1.bkg_no       = f2.bkg_no
                       AND f1.cntr_tpsz_cd = f2.cntr_tpsz_cd
                       AND f1.cost_rout_no = f2.cost_rout_no)
                  WHEN MATCHED THEN
                    UPDATE
                       SET f1.bkg_rev        = f1.bkg_rev      + f2.bkg_rev
                          ,f1.bkg_oft_rev    = f1.bkg_oft_rev  + f2.bkg_oft_rev
                          ,f1.bkg_misc_rev   = f1.bkg_misc_rev + f2.bkg_misc_rev  
                          ,f1.scr_chg_rev    = f1.scr_chg_rev  + f2.scr_chg_rev   
                          ,f1.rev_act_flg    = f2.rev_act_flg
                          ,f1.etc_ut_rev_amt = 0     -- Default로 0을 넣어 준다.
                          ,f1.upd_usr_id     = f2.upd_usr_id
                          ,f1.upd_dt         = f2.upd_dt
                ;           
           
          --  enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'EQ SUB merge update2', v_appl_info);            
            END IF;
          --  enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'line 401 STEP1: 순수 cntr_tpsz_cd 적용 : ' || SQL%ROWCOUNT || ' merge update', v_appl_info);         
             
            /* step1-3:::: Q type 운임 귀속 update*/    
            MERGE INTO coa_bkg_rev_dtl f1 
            USING (        
                   SELECT a2.bkg_no
                         ,DECODE(SUBSTR(a2.cntr_tpsz_cd, -1), '2', v_cntr_tpsz_cd_20, v_cntr_tpsz_cd_40) AS cntr_tpsz_cd
                         ,a2.cost_rout_no
                         ,SUM(DECODE(a3.CO_CHG_ACCT_CD, '411111', DECODE(a1.CHG_CD, 'OFT', 0, a1.CHG_AMT / a4.usd_locl_xch_rt), 0)) AS bkg_rev
                         ,SUM(DECODE(a3.CO_CHG_ACCT_CD, '411111', DECODE(a1.CHG_CD, 'OFT', a1.CHG_AMT / a4.usd_locl_xch_rt, 0))) AS bkg_oft_rev
                         ,SUM(DECODE(a3.CO_CHG_ACCT_CD, '411914', a1.CHG_AMT / a4.usd_locl_xch_rt, 0)) AS bkg_misc_rev
                         ,SUM(DECODE(a3.CO_CHG_ACCT_CD, '411915', a1.CHG_AMT / a4.usd_locl_xch_rt, 0)) AS scr_chg_rev
                     FROM BKG_CHG_RT a1
                         ,coa_bkg_rev_dtl a2
                         ,mdm_charge a3
                         ,gl_mon_xch_rt a4
                    WHERE a1.bkg_no = a2.bkg_no
                      AND a1.RAT_UT_CD = a2.cntr_tpsz_cd
                      AND a1.RAT_UT_CD LIKE 'Q%'               -- Rate가 Q인 것만
                      AND a1.bkg_no = in_bkg_no
                      AND a1.CHG_CD = a3.chg_cd
                      AND a3.CO_CHG_ACCT_CD IN ('411111','411914','411915')
                      AND a1.CURR_CD = a4.CURR_CD
                      AND TO_CHAR(a1.cre_dt, 'YYYYMM') = a4.acct_xch_rt_yrmon
                      AND a4.acct_xch_rt_lvl = '1'       
                      AND a1.dp_seq = DECODE(a1.CHG_CD, 'DIH', 430, a1.dp_seq)   -- DIH의 경우 dp_seq = 430
                      AND (   a1.CHG_CD NOT IN('DOD', 'TVA')
                           OR a1.de_term_cd     <> 'H'
                           OR a1.PRN_HDN_FLG <> '1'
                           OR NOT EXISTS(
                                         SELECT 'X'
                                           FROM bkg_booking bkg
                                          WHERE bkg.bkg_no       = a1.bkg_no
                                            AND bkg.pod_cd       = bkg.del_cd
                                            AND bkg.de_term_cd   IN ('Y', 'H'))
                          )   --위 주석 조건 변경 끝
                    GROUP BY a2.bkg_no
                         ,DECODE(SUBSTR(a2.cntr_tpsz_cd, -1), '2', v_cntr_tpsz_cd_20, v_cntr_tpsz_cd_40)
                         ,a2.cost_rout_no
                  ) f2
               ON (    f1.bkg_no = f2.bkg_no
                   AND f1.cntr_tpsz_cd = f2.cntr_tpsz_cd
                   AND f1.cost_rout_no = f2.cost_rout_no
                  )              
             WHEN MATCHED THEN
                  UPDATE
                     SET f1.bkg_rev      = f1.bkg_rev + f2.bkg_rev
                        ,f1.bkg_oft_rev  = f1.bkg_oft_rev + f2.bkg_oft_rev
                        ,f1.bkg_misc_rev = f1.bkg_misc_rev + f2.bkg_misc_rev  
                        ,f1.scr_chg_rev  = f1.scr_chg_rev + f2.scr_chg_rev
            ;            
    
    --FOR param IN (SELECT bkg_rev, bkg_oft_rev, bkg_misc_rev, scr_chg_rev
    --                FROM coa_bkg_rev_dtl
    --               WHERE bkg_no = in_bkg_no
    --                 and bkg_no_split =  in_bkg_no_split ) LOOP    
    --          enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', '== 순수 cntr_tpsz_cd REV : bkg_rev =[' || param.bkg_rev || ']: bkg_oft_rev=[' || param.bkg_oft_rev || ']: bkg_misc_rev=['||param.bkg_misc_rev || ']' , v_appl_info);
    --END LOOP ;
    
    
            /* step2::::20, 40  적용값 구하기*/
            SELECT SUM(DECODE(rev.RAT_UT_CD,'20', SUM(DECODE(CO_CHG_ACCT_CD, '411111',DECODE(rev.CHG_CD, 'OFT', 0, CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt)),0))
                             ,0)
                      ) rev_teu
                  ,SUM(DECODE(rev.RAT_UT_CD,'20', SUM(DECODE(CO_CHG_ACCT_CD, '411111',DECODE(rev.CHG_CD, 'OFT', CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt), 0)))
                             ,0)
                      ) oft_teu
                  ,SUM(DECODE(rev.RAT_UT_CD,'20', SUM(DECODE(CO_CHG_ACCT_CD, '411914',rev.CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt), 0))
                             ,0)
                      ) sec_teu
                  ,SUM(DECODE(rev.RAT_UT_CD,'20', SUM(DECODE(CO_CHG_ACCT_CD, '411915',rev.CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt), 0))
                             ,0)
                      ) misc_teu
                  ,SUM(DECODE(rev.RAT_UT_CD,'20',0,SUM(DECODE(CO_CHG_ACCT_CD,'411111',DECODE(rev.CHG_CD, 'OFT', 0, rev.CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt))))
                             )
                      ) rev_feu
                  ,SUM(DECODE(rev.RAT_UT_CD,'20',0,SUM(DECODE(CO_CHG_ACCT_CD,'411111',DECODE(rev.CHG_CD, 'OFT', rev.CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt), 0)))
                             )
                      ) oft_feu
                  ,SUM(DECODE(rev.RAT_UT_CD,'20',0,SUM(DECODE(CO_CHG_ACCT_CD, '411914', rev.CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt), 0))
                             )
                      ) sec_feu
                  ,SUM(DECODE(rev.RAT_UT_CD,'20',0,SUM(DECODE(CO_CHG_ACCT_CD, '411915', rev.CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt), 0))
                             )
                      ) misc_feu        
              INTO v_teu_rev_amt
                  ,v_teu_oft_amt
                  ,v_teu_sec_amt
                  ,v_teu_misc_amt
                  ,v_feu_rev_amt
                  ,v_feu_oft_amt
                  ,v_feu_sec_amt
                  ,v_feu_misc_amt
              FROM BKG_CHG_RT rev, mdm_charge chg, gl_mon_xch_rt xch
             WHERE rev.bkg_no         = in_bkg_no
               AND rev.CHG_CD      = chg.chg_cd
               AND rev.RAT_UT_CD IN('20', '40', '45')
               --AND rev.CHG_CD NOT IN('CTT', 'WHF', 'DMR', 'DTC', 'DEM', 'DBS', 'DIH', 'DOD', 'TVA') --조건 변경 시작
               AND rev.dp_seq         = DECODE(rev.CHG_CD, 'DIH', 430, rev.dp_seq)   -- DIH의 경우 dp_seq = 430
               AND (   rev.CHG_CD  NOT IN('DOD', 'TVA')
                    OR rev.de_term_cd <> 'H'
                    OR rev.PRN_HDN_FLG <> '1'
                    OR NOT EXISTS(
                                  SELECT 'X'
                                    FROM bkg_booking bkg
                                  WHERE 1 = 1
                                    AND bkg.bkg_no       = rev.bkg_no
                                    AND bkg.pod_cd       = bkg.del_cd
                                    AND bkg.de_term_cd   IN('Y', 'H'))
                                  )   --위 주석 조건 변경 끝
               AND rev.FRT_INCL_XCLD_DIV_CD(+) = 'N'
               AND CO_CHG_ACCT_CD       IN ('411111','411914','411915')
               AND TO_CHAR(rev.cre_dt, 'YYYYMM') = xch.acct_xch_rt_yrmon
               AND xch.acct_xch_rt_lvl   = '1'
               AND rev.CURR_CD           = xch.CURR_CD
             GROUP BY RAT_UT_CD;
            -- enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'line 465 STEP2:v_teu_rev_amt ' || v_teu_oft_amt, v_appl_info);
    
            /* BL 당 건수 혹은 PC 당계약된  운임수입 가져오기 */
            /* step3::::순수 cntr_tpsz 및 20/40이 아닌,  BOX등의 적용값 구하기*/
            SELECT SUM(DECODE(CO_CHG_ACCT_CD,'411111',DECODE(rev.CHG_CD, 'OFT', 0, CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt)),0)) bl_rev
                  ,SUM(DECODE(CO_CHG_ACCT_CD,'411111',DECODE(rev.CHG_CD, 'OFT', CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt), 0),0)) bl_oft
                  ,SUM(DECODE(CO_CHG_ACCT_CD,'411914',CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt), 0)) bl_sec
                  ,SUM(DECODE(CO_CHG_ACCT_CD,'411915',CHG_AMT / DECODE(usd_locl_xch_rt, 0, 1, usd_locl_xch_rt), 0)) bl_misc
              INTO v_bl_rev_amt
                  ,v_bl_oft_amt
                  ,v_bl_sec_amt
                  ,v_bl_misc_amt
              FROM BKG_CHG_RT rev, mdm_charge chg, gl_mon_xch_rt xch
             WHERE rev.bkg_no         = in_bkg_no
               AND rev.CHG_CD      = chg.chg_cd
               AND rev.RAT_UT_CD NOT IN ('20', '40', '45')                         -- SIZE 제외
               AND NOT REGEXP_LIKE(rev.RAT_UT_CD, '^[[:alpha:]]{1}[[:digit:]]{1}') -- 숫자+문자로 된 순수 TPSZ 제외
               AND CO_CHG_ACCT_CD IN ('411111','411914','411915')
               --AND rev.CHG_CD NOT IN('CTT', 'WHF', 'DMR', 'DTC', 'DEM', 'DBS', 'DIH', 'DOD', 'TVA') --조건 변경 시작
               AND rev.dp_seq = DECODE(rev.CHG_CD, 'DIH', 430, rev.dp_seq)   -- DIH의 경우 dp_seq = 430
               AND (   rev.CHG_CD NOT IN('DOD', 'TVA')
                    OR rev.de_term_cd <> 'H'
                    OR rev.PRN_HDN_FLG <> '1'
                    OR NOT EXISTS(
                                  SELECT 'X'
                                    FROM bkg_booking bkg
                                   WHERE bkg.bkg_no       = rev.bkg_no
                                     AND bkg.pod_cd       = bkg.del_cd
                                     AND bkg.de_term_cd   IN ('Y', 'H'))
                                  )   --위 주석 조건 변경 끝
               AND rev.FRT_INCL_XCLD_DIV_CD(+) = 'N'
               AND TO_CHAR(rev.cre_dt, 'YYYYMM') = xch.acct_xch_rt_yrmon
               AND rev.CURR_CD           = xch.CURR_CD
               AND xch.acct_xch_rt_lvl   = '1';
          --  enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'line 535 STEP3:v_bl_oft_amt ' || v_bl_rev_amt, v_appl_info);
    
            /* step4::: step2,3에서 구한 적용값으로 coa_bkg_rev_dtl 테이블 update
                        커서에 Q type이 없음 */
            FOR cntr_type_list IN cntr_type_size_cursor(in_bkg_no) LOOP
                IF cntr_type_list.cntr_tpsz = '2' THEN
                    MERGE INTO coa_bkg_rev_dtl k
                    USING (
                           SELECT bkg_no
                                 ,cntr_tpsz_cd
                                 ,cost_rout_no   -- cost_rout_no별로 비용을 나눠준다.(bkg_qty / total_qty)
                                 ,bkg_rev      + bkg_rev2      *(bkg_qty / DECODE(total_qty, NULL, 1, 0, 1, total_qty)) rev
                                 ,bkg_oft_rev  + bkg_oft_rev2  *(bkg_qty / DECODE(total_qty, NULL, 1, 0, 1, total_qty)) oft
                                 ,bkg_misc_rev + bkg_misc_rev2 *(bkg_qty / DECODE(total_qty, NULL, 1, 0, 1, total_qty)) misc
                                 ,scr_chg_rev  + scr_chg_rev2  *(bkg_qty / DECODE(total_qty, NULL, 1, 0, 1, total_qty)) sec
                                 ,'Y' flg
                                 ,'SYSTEM_COA' cre_usr_id
                                 ,SYSDATE cre_dt
                                 ,'SYSTEM_COA' upd_usr_id
                                 ,SYSDATE upd_dt
                            FROM (SELECT a.bkg_no
                                        ,a.cntr_tpsz_cd
                                        ,a.cost_rout_no
                                        ,NVL(a.bkg_rev, 0) bkg_rev
                                        ,NVL(v_teu_rev_amt*(cntr_type_list.op_qty       / DECODE(cntr_type_list.total_teu, 0, 1, cntr_type_list.total_teu)),0)
                                        +NVL(v_bl_rev_amt *(cntr_type_list.op_ratio_qty / DECODE(cntr_type_list.total_qty, 0, 1, cntr_type_list.total_qty)),0) 
                                        bkg_rev2
                                        ,NVL(a.bkg_oft_rev, 0) bkg_oft_rev
                                        ,NVL(v_teu_oft_amt*(cntr_type_list.op_qty       / DECODE(cntr_type_list.total_teu, 0, 1, cntr_type_list.total_teu)),0)
                                        +NVL(v_bl_oft_amt *(cntr_type_list.op_ratio_qty / DECODE(cntr_type_list.total_qty, 0, 1, cntr_type_list.total_qty)),0) 
                                        bkg_oft_rev2
                                        ,NVL(a.scr_chg_rev, 0) scr_chg_rev
                                        ,NVL(v_teu_sec_amt*(cntr_type_list.op_qty       / DECODE(cntr_type_list.total_teu, 0, 1, cntr_type_list.total_teu)),0)
                                        +NVL(v_bl_sec_amt *(cntr_type_list.op_ratio_qty / DECODE(cntr_type_list.total_qty, 0, 1, cntr_type_list.total_qty)),0) 
                                        scr_chg_rev2
                                        ,NVL(a.bkg_misc_rev, 0) bkg_misc_rev
                                        ,NVL(v_teu_misc_amt*(cntr_type_list.op_qty       / DECODE(cntr_type_list.total_teu, 0, 1, cntr_type_list.total_teu)),0)
                                        +NVL(v_bl_misc_amt *(cntr_type_list.op_ratio_qty / DECODE(cntr_type_list.total_qty, 0, 1, cntr_type_list.total_qty)),0) 
                                        bkg_misc_rev2
                                        ,a.bkg_qty
                                        ,(SELECT SUM(bkg_qty)
                                            FROM coa_bkg_rev_dtl
                                            WHERE bkg_no       = a.bkg_no
                                              AND cntr_tpsz_cd = a.cntr_tpsz_cd
                                              AND cntr_tpsz_cd not like 'Q%'
    --                                          AND SUBSTR (cntr_tpsz_cd, -1, 1) = '2'
                                        ) total_qty
                                     FROM coa_bkg_rev_dtl a
                                    WHERE a.bkg_no       = in_bkg_no
                                      AND a.cntr_tpsz_cd = cntr_type_list.cntr_tpsz_cd   --추가 20070819
                                   )
                        ) m
                    ON (    k.bkg_no       = m.bkg_no
                        AND k.cntr_tpsz_cd = m.cntr_tpsz_cd
                        AND k.cost_rout_no = m.cost_rout_no)
                    WHEN MATCHED THEN
                        UPDATE
                           SET k.bkg_rev      = m.rev
                              ,k.bkg_oft_rev  = m.oft
                              ,k.bkg_misc_rev = m.misc
                              ,k.scr_chg_rev  = m.sec
                              ,k.rev_act_flg  = m.flg
                              ,k.etc_ut_rev_amt = 0     -- Default로 0을 넣어 준다.
                              ,k.upd_usr_id   = m.upd_usr_id
                              ,k.upd_dt       = m.upd_dt
                    ;
                ELSE
                    MERGE INTO coa_bkg_rev_dtl k
                    USING (
                           SELECT bkg_no
                                 ,cntr_tpsz_cd
                                 ,cost_rout_no   -- cost_rout_no별로 비용을 나눠준다.(bkg_qty / total_qty)
                                 ,bkg_rev      + bkg_rev2      *(bkg_qty / DECODE(total_qty, NULL, 1, 0, 1, total_qty)) rev
                                 ,bkg_oft_rev  + bkg_oft_rev2  *(bkg_qty / DECODE(total_qty, NULL, 1, 0, 1, total_qty)) oft
                                 ,bkg_misc_rev + bkg_misc_rev2 *(bkg_qty / DECODE(total_qty, NULL, 1, 0, 1, total_qty)) misc
                                 ,scr_chg_rev  + scr_chg_rev2  *(bkg_qty / DECODE(total_qty, NULL, 1, 0, 1, total_qty)) sec
                                 ,'Y' flg
                                 ,'SYSTEM_COA' cre_usr_id
                                 ,SYSDATE cre_dt
                                 ,'SYSTEM_COA' upd_usr_id
                                 ,SYSDATE upd_dt
                             FROM (SELECT a.bkg_no
                                         ,a.cntr_tpsz_cd
                                         ,a.cost_rout_no
                                         ,NVL(a.bkg_rev, 0) bkg_rev
                                         ,NVL(v_feu_rev_amt*(cntr_type_list.op_qty       / DECODE(cntr_type_list.total_feu, 0, 1, cntr_type_list.total_feu)),0)
                                         +NVL(v_bl_rev_amt *(cntr_type_list.op_ratio_qty / DECODE(cntr_type_list.total_qty, 0, 1, cntr_type_list.total_qty)),0) 
                                          bkg_rev2
                                         ,NVL(a.bkg_oft_rev, 0) bkg_oft_rev
                                         ,NVL(v_feu_oft_amt*(cntr_type_list.op_qty       / DECODE(cntr_type_list.total_feu, 0, 1, cntr_type_list.total_feu)),0)
                                         +NVL(v_bl_oft_amt *(cntr_type_list.op_ratio_qty / DECODE(cntr_type_list.total_qty, 0, 1, cntr_type_list.total_qty)),0) 
                                          bkg_oft_rev2
                                         ,NVL(a.scr_chg_rev, 0) scr_chg_rev
                                         ,NVL(v_feu_sec_amt*(cntr_type_list.op_qty       / DECODE(cntr_type_list.total_feu, 0, 1, cntr_type_list.total_feu)),0)
                                         +NVL(v_bl_sec_amt *(cntr_type_list.op_ratio_qty / DECODE(cntr_type_list.total_qty, 0, 1, cntr_type_list.total_qty)),0) 
                                          scr_chg_rev2
                                         ,NVL(a.bkg_misc_rev, 0) bkg_misc_rev
                                         ,NVL(v_feu_misc_amt*(cntr_type_list.op_qty       / DECODE(cntr_type_list.total_feu, 0, 1, cntr_type_list.total_feu)),0)
                                         +NVL(v_bl_misc_amt *(cntr_type_list.op_ratio_qty / DECODE(cntr_type_list.total_qty, 0, 1, cntr_type_list.total_qty)),0) 
                                          bkg_misc_rev2
                                         ,a.bkg_qty
                                         ,(SELECT SUM(bkg_qty)
                                             FROM coa_bkg_rev_dtl
                                            WHERE bkg_no       = a.bkg_no
                                              AND cntr_tpsz_cd = a.cntr_tpsz_cd
                                              AND SUBSTR(cntr_tpsz_cd, -1) <> '2'
                                              AND cntr_tpsz_cd not like 'Q%'
                                           ) total_qty
                                   FROM coa_bkg_rev_dtl a
                                   WHERE a.bkg_no       = in_bkg_no
                                     AND a.cntr_tpsz_cd = cntr_type_list.cntr_tpsz_cd   --추가 20070819
                                   )
                    ) m
                    ON (    k.bkg_no       = m.bkg_no
                        AND k.cntr_tpsz_cd = m.cntr_tpsz_cd
                        AND k.cost_rout_no = m.cost_rout_no)
                    WHEN MATCHED THEN
                        UPDATE
                            SET k.bkg_rev      = m.rev
                               ,k.bkg_oft_rev  = m.oft
                               ,k.bkg_misc_rev = m.misc
                               ,k.scr_chg_rev  = m.sec
                               ,k.rev_act_flg  = m.flg
                               ,k.etc_ut_rev_amt = 0     -- Default로 0을 넣어 준다.
                               ,k.upd_usr_id   = m.upd_usr_id
                               ,k.upd_dt       = m.upd_dt
                    ;
                END IF;
          --  enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'STEP4:coa_bkg_rev_dtl ' || SQL%ROWCOUNT || 'merge update', v_appl_info);
            END LOOP;
    
    
        /*평균 RPB 적용하는 경우 */
        ELSIF(v_row_cnt = 0 ) THEN
        
            /* step5:::수입을 평균으로 잡아서 coa_bkg_rev_dtl 테이블을 update */
            MERGE INTO coa_bkg_rev_dtl a
            USING (SELECT rev.bkg_no
                         ,rev.cntr_tpsz_cd
                         ,rev.cost_rout_no
                         ,COALESCE(rpb2.bkg_avg_rpb_rev
                                  ,rpb3.bkg_avg_rpb_rev
                                  ,DECODE(SUBSTR(rev.cntr_tpsz_cd, -1)
                                         ,'2', NVL(rpb4.net_20ft_avg_rev, rpb5.net_20ft_avg_rev)
                                         ,NVL(rpb4.net_40ft_avg_rev, rpb5.net_40ft_avg_rev)
                                         )
                                  )
                          * rev.bkg_qty net
                         ,COALESCE(rpb2.bkg_oft_avg_rpb_rev
                                  ,rpb3.bkg_oft_avg_rpb_rev
                                  ,DECODE(SUBSTR(rev.cntr_tpsz_cd, -1)
                                         ,'2', NVL(rpb4.oft_20ft_avg_rev, rpb5.oft_20ft_avg_rev)
                                         ,NVL(rpb4.oft_40ft_avg_rev, rpb5.oft_40ft_avg_rev)
                                         )
                                  )
                          * rev.bkg_qty oft
                         ,COALESCE(rpb2.bkg_misc_avg_rpb_rev
                                  ,rpb3.bkg_misc_avg_rpb_rev
                                  ,DECODE(SUBSTR(rev.cntr_tpsz_cd, -1)
                                         ,'2', NVL(rpb4.misc_20ft_avg_rev, rpb5.misc_20ft_avg_rev)
                                         ,NVL(rpb4.misc_40ft_avg_rev, rpb5.misc_40ft_avg_rev)
                                         )
                                  )
                          * rev.bkg_qty misc
                         ,COALESCE(rpb2.scr_chg_avg_rpb_rev
                                  ,rpb3.scr_chg_avg_rpb_rev
                                  ,DECODE(SUBSTR(rev.cntr_tpsz_cd, -1)
                                         ,'2', NVL(rpb4.scr_20ft_avg_rev, rpb5.scr_20ft_avg_rev)
                                         ,NVL(rpb4.scr_40ft_avg_rev, rpb5.scr_40ft_avg_rev)
                                         )
                                  )
                          * rev.bkg_qty chg
                         ,'N' flg
                         ,'SYSTEM_COA' cre_usr_id
                         ,SYSDATE cre_dt
                         ,'SYSTEM_COA' upd_usr_id
                         ,SYSDATE upd_dt
                   FROM (
                         SELECT b.bkg_no
                               ,b.ioc_cd
                               ,b.rlane_cd
                               ,d.cntr_tpsz_cd
                               ,NVL(d.bkg_qty, 0) bkg_qty
                               ,d.cost_rout_no
                               ,b.bkg_por_cd
                               ,b.bkg_del_cd
                               ,b.dir_cd
                               ,b.trd_cd
                               ,por.scc_cd por_scc
                               ,del.scc_cd del_scc
                           FROM COA_RGST_BKG b
                               ,coa_bkg_rev_dtl d
                               ,coa_location_v por
                               ,coa_location_v del
                          WHERE b.bkg_no       = d.bkg_no
                            AND b.bkg_por_cd   = por.loc_cd
                            AND b.bkg_del_cd   = del.loc_cd
                            AND b.bkg_no       = in_bkg_no
                            AND d.cntr_tpsz_cd NOT LIKE 'Q%'             -- Q type 제외
                        ) rev
                       ,coa_mon_rout_rpb rpb2
                       ,coa_mon_scc_rpb  rpb3
                       ,coa_mon_lane_rpb rpb4
                       ,coa_mon_trd_rpb  rpb5
                   WHERE 1=1
                     
                     AND rev.rlane_cd       = rpb2.rlane_cd(+)
                     AND rev.ioc_cd         = rpb2.ioc_cd(+)
                     AND rev.cntr_tpsz_cd   = rpb2.cntr_tpsz_cd(+)
                     AND rpb2.rpb_yrmon(+)  = v_cost_yrmon
                     AND rev.bkg_por_cd     = rpb2.bkg_por_cd(+)
                     AND rev.bkg_del_cd     = rpb2.bkg_del_cd(+)
                     
                     AND rev.por_scc        = rpb3.bkg_por_scc_cd(+)
                     AND rev.del_scc        = rpb3.bkg_del_scc_cd(+)
                     AND rev.cntr_tpsz_cd   = rpb3.cntr_tpsz_cd(+)
                     AND rpb3.rpb_yrmon(+)  = v_cost_yrmon
                     
                     AND rev.rlane_cd       = rpb4.rlane_cd(+)
                     AND rev.ioc_cd         = rpb4.ioc_cd(+)
                     AND rev.dir_cd         = rpb4.dir_cd(+)
                     AND rpb4.rpb_yrmon(+)  = v_cost_yrmon
                     
                     AND rev.trd_cd         = rpb5.trd_cd(+)
                     AND rev.dir_cd         = rpb5.dir_cd(+)
                     AND rpb5.rpb_yrmon(+)  = v_cost_yrmon
                ) b
            ON (    a.bkg_no       = b.bkg_no
                AND a.cntr_tpsz_cd = b.cntr_tpsz_cd
                AND a.cost_rout_no = b.cost_rout_no)
            WHEN MATCHED THEN
                UPDATE
                   SET a.bkg_rev      = b.net
                      ,a.bkg_oft_rev  = b.oft
                      ,a.bkg_misc_rev = b.misc
                      ,a.scr_chg_rev  = b.chg
                      ,a.rev_act_flg  = b.flg
                      ,a.etc_ut_rev_amt = 0     -- Default로 0을 넣어 준다.                      
                      ,a.upd_usr_id   = b.upd_usr_id
                      ,a.upd_dt       = b.upd_dt
            ;
       -- enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'line 781 coa_bkg_rev_dtl ' || SQL%ROWCOUNT || 'merge update', v_appl_info);
        END IF;
    
    
        /* step7 최종 Data 검증하기
           bl type이 'C'에 해당 되지 않는 경우에만 해당된다
           각 booking별 입력된값과 Bl Rate상의 금액을 비교해 차이만큼 정리해준다.
           각 Item별 TEU 물량으로 나누어준다  v_surplus_amt */
           
        IF (v_row_cnt >= 1) THEN
            -- 부족분 보정작업
            -- coa_bkg_rev_dtl에 들어있는 total 값, 물량 구하기
            SELECT SUM(DECODE(SUBSTR(cntr_tpsz_cd, -1, 1), '2', bkg_qty, bkg_qty * 2))
                  ,NVL(SUM(bkg_rev), 0)
                  ,NVL(SUM(bkg_oft_rev), 0)
                  ,NVL(SUM(bkg_misc_rev), 0)
                  ,NVL(SUM(scr_chg_rev), 0)
                  ,NVL(SUM(bkg_rev), 0) + NVL(SUM(bkg_oft_rev), 0) + NVL(SUM(bkg_misc_rev), 0) + NVL(SUM(scr_chg_rev), 0)
                  ,NVL(SUM(bkg_rev), 0) + NVL(SUM(bkg_misc_rev), 0) + NVL(SUM(scr_chg_rev), 0)
              INTO v_total_bkg_qty
                  ,v_surplus_bkg_rev
                  ,v_surplus_bkg_oft_rev
                  ,v_surplus_bkg_misc_rev
                  ,v_surplus_scr_chg_rev
                  ,v_surplus_total_rev
                  ,v_surplus_total_rev2
              FROM coa_bkg_rev_dtl
             WHERE bkg_no       = in_bkg_no
               AND cntr_tpsz_cd NOT LIKE 'Q%'
               ;
    
             -- 부족분 보정작업
             MERGE INTO coa_bkg_rev_dtl b1
             USING (SELECT a1.bkg_no
                          ,a1.cntr_tpsz_cd
                          ,a1.cost_rout_no
                          ,CASE
                              WHEN(ABS(a2.total - v_surplus_total_rev) > 1 AND v_surplus_bkg_rev < a2.rev) THEN
                                   NVL(a1.bkg_rev, 0)
                                    + (a2.rev - v_surplus_bkg_rev) * DECODE(SUBSTR(a1.cntr_tpsz_cd, -1, 1), '2', a1.bkg_qty, a1.bkg_qty * 2)
                                     / DECODE(v_total_bkg_qty, NULL, 1, 0, 1, v_total_bkg_qty)
                              ELSE NVL(a1.bkg_rev, 0)
                           END bkg_rev
                          ,CASE
                              WHEN(ABS(a2.total - v_surplus_total_rev) > 1 AND v_surplus_bkg_oft_rev < a2.oft) THEN
                                   NVL(a1.bkg_oft_rev, 0)
                                    + (a2.oft - v_surplus_bkg_oft_rev) * DECODE(SUBSTR(a1.cntr_tpsz_cd, -1, 1), '2', a1.bkg_qty, a1.bkg_qty * 2)
                                     / DECODE(v_total_bkg_qty, NULL, 1, 0, 1, v_total_bkg_qty)
                              ELSE NVL(a1.bkg_oft_rev, 0)
                           END bkg_oft_rev
                          ,CASE
                              WHEN(ABS(a2.total - v_surplus_total_rev) > 1 AND v_surplus_bkg_misc_rev < a2.misc) THEN
                                   NVL(a1.bkg_misc_rev, 0)
                                    + (a2.misc - v_surplus_bkg_misc_rev) * DECODE(SUBSTR(a1.cntr_tpsz_cd, -1, 1), '2', a1.bkg_qty, a1.bkg_qty * 2)
                                     / DECODE(v_total_bkg_qty, NULL, 1, 0, 1, v_total_bkg_qty)
                              ELSE NVL(a1.bkg_misc_rev, 0)
                           END bkg_misc_rev
                          ,CASE
                              WHEN(ABS(a2.total - v_surplus_total_rev) > 1 AND v_surplus_scr_chg_rev < a2.sec) THEN
                                   NVL(a1.scr_chg_rev, 0)
                                    + (a2.sec - v_surplus_scr_chg_rev) * DECODE(SUBSTR(a1.cntr_tpsz_cd, -1, 1), '2', a1.bkg_qty, a1.bkg_qty * 2)
                                     / DECODE(v_total_bkg_qty, NULL, 1, 0, 1, v_total_bkg_qty)
                              ELSE NVL(a1.scr_chg_rev, 0)
                           END scr_chg_rev
                      --,a2.bkg_no
                      FROM coa_bkg_rev_dtl a1
                          ,(SELECT   rev.bkg_no
                                    ,SUM(DECODE(chg.CO_CHG_ACCT_CD,'411111',DECODE(rev.CHG_CD,'OFT',0,NVL(rev.CHG_AMT, 0) / DECODE(xch.usd_locl_xch_rt, 0, 1, xch.usd_locl_xch_rt)),0))
                                    +SUM(DECODE(chg.CO_CHG_ACCT_CD,'411111',DECODE(rev.CHG_CD,'OFT',  NVL(rev.CHG_AMT, 0) / DECODE(xch.usd_locl_xch_rt, 0, 1, xch.usd_locl_xch_rt),0),0))
                                    +SUM(DECODE(chg.CO_CHG_ACCT_CD,'411914',NVL(rev.CHG_AMT, 0) / DECODE(xch.usd_locl_xch_rt, 0, 1, xch.usd_locl_xch_rt),0))
                                    +SUM(DECODE(chg.CO_CHG_ACCT_CD,'411915',NVL(rev.CHG_AMT, 0) / DECODE(xch.usd_locl_xch_rt, 0, 1, xch.usd_locl_xch_rt),0)) 
                                     total
                                    ,SUM(DECODE(chg.CO_CHG_ACCT_CD,'411111',DECODE(rev.CHG_CD,'OFT',0,NVL(rev.CHG_AMT, 0) / DECODE(xch.usd_locl_xch_rt, 0, 1, xch.usd_locl_xch_rt)),0)) rev
                                    ,SUM(DECODE(chg.CO_CHG_ACCT_CD,'411111',DECODE(rev.CHG_CD,'OFT',  NVL(rev.CHG_AMT, 0) / DECODE(xch.usd_locl_xch_rt, 0, 1, xch.usd_locl_xch_rt),0),0)) oft
                                    ,SUM(DECODE(chg.CO_CHG_ACCT_CD,'411914',NVL(rev.CHG_AMT, 0) / DECODE(xch.usd_locl_xch_rt, 0, 1, xch.usd_locl_xch_rt),0)) sec
                                    ,SUM(DECODE(chg.CO_CHG_ACCT_CD,'411915',NVL(rev.CHG_AMT, 0) / DECODE(xch.usd_locl_xch_rt, 0, 1, xch.usd_locl_xch_rt),0)) misc
                                FROM BKG_CHG_RT rev
                                    ,mdm_charge chg
                                    ,gl_mon_xch_rt xch
                               WHERE rev.bkg_no = in_bkg_no
                                 AND rev.CHG_CD = chg.chg_cd
                                 AND CO_CHG_ACCT_CD IN ('411111','411914','411915')
                                 AND TO_CHAR(rev.cre_dt, 'YYYYMM') = xch.acct_xch_rt_yrmon
                                 AND xch.acct_xch_rt_lvl = '1'
                                 AND rev.CURR_CD = xch.CURR_CD
                                 --AND rev.CHG_CD NOT IN('CTT', 'WHF', 'DMR', 'DTC', 'DEM', 'DBS', 'DIH', 'DOD', 'TVA') --조건 변경 시작
                                 AND rev.dp_seq = DECODE(rev.CHG_CD, 'DIH', 430, rev.dp_seq)   -- DIH의 경우 dp_seq = 430
                                 AND (   rev.CHG_CD NOT IN('DOD', 'TVA')
                                      OR rev.de_term_cd <> 'H'
                                      OR rev.PRN_HDN_FLG <> '1'
                                      OR NOT EXISTS(
                                            SELECT 'X'
                                              FROM bkg_booking bkg
                                             WHERE 1 = 1
                                               AND bkg.bkg_no = rev.bkg_no
                                               AND bkg.pod_cd = bkg.del_cd
                                               AND bkg.de_term_cd IN('Y', 'H'))
                                     )   --위 주석 조건 변경 끝
                                 AND rev.FRT_INCL_XCLD_DIV_CD(+) = 'N'
                            GROUP BY rev.bkg_no) a2
                     WHERE a1.bkg_no       = a2.bkg_no
                       AND a1.cntr_tpsz_cd NOT LIKE 'Q%' -- 20090408
                ) b2
                ON (    b1.bkg_no = b2.bkg_no
                    AND b1.cntr_tpsz_cd = b2.cntr_tpsz_cd
                    AND b1.cost_rout_no = b2.cost_rout_no)
                WHEN MATCHED THEN
                   UPDATE
                      SET b1.bkg_rev      = b2.bkg_rev
                        , b1.bkg_oft_rev  = b2.bkg_oft_rev
                        , b1.bkg_misc_rev = b2.bkg_misc_rev
                        , b1.scr_chg_rev  = b2.scr_chg_rev
                   ;
        END IF;
        
        /* 
        step8::: MRI 운임단가를 적용한다. ----------------------------------------------------------------------------
        2008.05.08 MRI단가로 만든 Revenue를 Misc Revenue에 추가하고 추가한 Misc Revenue를 etc_ut_rev_amt에 저장한다.
        2008.05.27 Lane/Bound별 단가가 $100 초과  100 미만 일 경우, Trade/Bound별 단가 적용
        */
        IF (v_row_cnt >= 1) THEN
        MERGE INTO coa_bkg_rev_dtl c1
        USING (
               SELECT bkg_no
                     ,cntr_tpsz_cd
                     ,cost_rout_no
    --                 ,bkg_qty
    --                 ,SUM(ut_rev_amt) AS ut_rev_amt
                     ,SUM(DECODE(SUBSTR(cntr_tpsz_cd,-1), '2', bkg_qty, bkg_qty*2) * etc_ut_rev_amt) AS etc_ut_rev_amt
                 FROM (SELECT b1.bkg_no
                             ,b2.cntr_tpsz_cd
                             ,b2.cost_rout_no
                             ,b2.bkg_qty
                             ,DECODE(b3.is_use_trd_uc,'Y', b3.trd_uc_amt, b3.rlane_uc_amt) AS etc_ut_rev_amt
                         FROM COA_RGST_BKG b1
                             ,coa_bkg_rev_dtl b2
                             ,(SELECT a1.rev_yrmon
                                     ,a1.trd_cd
                                     ,a1.dir_cd
                                     ,a1.rlane_cd
                                     ,a1.trd_ttl_amt
                                     ,a1.trd_ttl_qty
                                     ,CASE 
                                        WHEN a1.etc_ut_rev_amt > 100 AND a1.trd_ttl_qty < 100 
                                            THEN 'Y'
                                        ELSE 'N'
                                      END AS is_use_trd_uc  -- 단가가 100 이상이고 물량이 100 이하이면 trd 단가 사용
                                     ,a1.etc_ut_rev_amt AS rlane_uc_amt
                                     ,a2.etc_ut_rev_amt AS trd_uc_amt
                                FROM  coa_mon_misc_rev_pre_teu a1
                                     ,coa_mon_misc_rev_pre_teu a2
                               WHERE a1.rev_yrmon = a2.rev_yrmon
                                 AND a1.trd_cd    = a2.trd_cd
                                 AND a1.dir_cd    = a2.dir_cd
                                 AND a1.rev_yrmon = v_cost_yrmon
                                 AND a1.rlane_cd  <> 'XXXXX'
                                 AND a2.rlane_cd  =  'XXXXX'                                      
                              ) b3
                        WHERE b1.bkg_no       = b2.bkg_no
                          AND b1.trd_cd       = b3.trd_cd
                          AND b1.rlane_cd     = b3.rlane_cd
                          AND b1.dir_cd       = b3.dir_cd
                          AND b1.bkg_no       = in_bkg_no
                          AND b2.cntr_tpsz_cd NOT LIKE 'Q%'             -- Q type 제외
                       )
                GROUP BY bkg_no
                     ,cntr_tpsz_cd
                     ,cost_rout_no
    --                 ,bkg_qty
        ) c2
        ON (    c1.bkg_no       = c2.bkg_no
            AND c1.cntr_tpsz_cd = c2.cntr_tpsz_cd
            AND c1.cost_rout_no = c2.cost_rout_no
        )
        WHEN MATCHED THEN
            UPDATE
               SET c1.bkg_misc_rev   = NVL(c1.bkg_misc_rev, 0) + NVL(c2.etc_ut_rev_amt, 0)
                 , c1.etc_ut_rev_amt = c2.etc_ut_rev_amt 
        ;
        END IF;
        
        --      enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'line 962 coa_bkg_rev_dtl 최종정리 : ' || SQL%ROWCOUNT || 'merge update', v_appl_info);
        -- Data 정리 끝
    
    
        enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'End ' || TO_CHAR(SYSDATE, 'yyyy/mm/dd hh24:mi:ss'), v_appl_info );
    ELSE
        enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'End ' || TO_CHAR(SYSDATE, 'yyyy/mm/dd hh24:mi:ss') || ' count 0', v_appl_info );
    END IF;     

EXCEPTION
    WHEN OTHERS THEN
        out_result := 'N';
        enis_log_prc(SYSDATE, 'COA_BKG_REV_DTL_PRC', 'Error: ' || SQLERRM, v_appl_info);
        RAISE;
END COA_BKG_REV_DTL_PRC;