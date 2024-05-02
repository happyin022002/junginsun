CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACCL_CAL_PRC (exe_yrmon_in IN VARCHAR, bat_id_in IN VARCHAR)  
IS  
/*******************************************************************************  
  1.Object Name      : LEA_ACCL_CAL_PRC 
  2.Version          : 1.0 
  3.Create Date      : 2007-03-02  
  4.Sub System       : Logistics Expense Accrual 
  5.Author           : 전재홍 
  6.Description      : Actual Cost 가 매핑/배부 된 후 계산 로직에 따라 ACCL_COST_AMT 처리 
  7.Revision History : 
        2007-03-02 : - 김상모 최초생성.  
        2008-04-25 : - 전재홍 : NO 인경우 act_cost_amt 존재시 accl_cost_amt = 0   
        2008-04-30 : - TES NB Cost의 act_inv_knt 를 cost code grouping내 조정하여  
                       accrual amount 계산.  
        2008-06-23 : - LO , NO 의 5개월 이전에 대한 Accrual 제거시 등호 추가(EX. 6월 결산시 1월 데이타까지 제거)  
        2008-06-27 : - LO , NO 의 5개월 이전 Accrual 제거를 3개월로 변경  
                     - Mapping이 이루어지지 않고, Act VVD 금액을 배부받은 NB Cost 의 Accrual 제거  
                     - 수행월 기준 5개월 이전의 모든 Accrual 제거 로직 추가  
        2008-07-22 : - NO 일때 act_cost_amt 가 minus(-) 인경우 Accrual 을 Estimation 으로 한다.  
        2008-09-25 : - TMFDFL, TMNDRF, TMNDTS, SVSSFL, SVSSTS 인 NB cost code의 accrual   
                       제거 시기는 NO와 같이 3개월로 변경  
                       - 특정 Cost Code 를 제외한 NO Cost 에 대해서는 rev.month 기준   
                         수행월포함 2개월동안에는 estm_cost_amt - act_cost_amt 로 accl_cost_amt를 계산한다.  
                       - ~DC Cost 는 Accl_cost_amt = 0  
                       - NO 의 최근 3개월 이전의 accl_cost_amt =0  마지막에 수행  
                       - Accl amt 는 최대 rev.month 기준 5개월 유지이므로 범위를 (수행월-5) 로 한다.  
                         (Other Cost - LO, NO 는 3개월)  
        2008-10-10 : - act_cost_amt 가 minus(-) 인경우 Accrual 을 Estimation 으로 한다.  
        2009-05-22 : - LO Type 관련 Accl 보완  
                     - DELETE 된 건들은 Invoice Ratio 계산시 제외          
                     - LB 대상선정시 매핑 처리된 것들만 대상  
        2009-06-17 : - NO 에 대해서 actual/revenue vvd 배부된 값이 있는 경우(ACT_REV_VVD_COST_AMT> 0)에만 
                       ACCL_COST_AMT =0 으로 계산한다 나머지의 경우는 CASE 에 따라 차액 계산.   
        2009-09-29 : - Cost Group 에 따른 Actual Invoice Count 생성에서 ACT_INV_KNT 비교를 제외.
                       (Invoice 생성시 NB COST 의 경우 Cost GROUP 내 여러 경우- (TPNDFL+SVLDFL, TPNDTS+SVLDTS..)로 
                        생성될수 있기때문에 이에 따른 ACCL_COST_AMT 를 처리하기 위함)  
        2009-10-09 : - 홍콩 관련 Invoice 관련하여 Accrual 계산 로직 추가
                     - ESTM_COST_AMT = 0 으로 변동된 경우 기존 ACCL_COST_AMT 를 제거
        2009-11-24 : - NO Calc 시 수행월로부터 마지막 3개월째에 해당할경우 로직 추가
                     - NO Calc 시 수행월로부터 3개월 이전에 대하여 0으로 처리시 NULL 처리 추가
                     - NO Calc 대상범위를 2개월에서 3개월로 변경.(롤백) 
        2010-04-13 : - 홍콩 관련 로직 변경 (ACTUAL/ ESTM >0.8 이고 ACCRUAL >0 이상 ACCRUAL 제거)
                       SUTTLE 경우 ESTM 은 각각 생성하나 홍콩에서 INVOICE 를 하나로 생성  
                     - BKG_NO = BKG_NO||BKG_NO_SPLIT 으로 변경(BKG_NO_SPLIT 제거)         
*******************************************************************************/  
  
   /* Variable Declare ----------------------------------------------------------*/  
   v_bat_his_rec   lea_bat_pkg.bat_his_rec;   --Batch Hostory Record  
   v_rtn_val       VARCHAR2 (1);  
   v_accl_knt      NUMBER := 0;  
   v_othclr_knt    NUMBER := 0;  
   v_xxx_knt       NUMBER := 0;  
   v_lo_knt        NUMBER := 0;  
   v_clr_knt       NUMBER := 0;  
  
BEGIN  
   lea_log_prc ('lea_accl_cal_prc() Start.');  
   v_bat_his_rec.accl_st_dt := SYSDATE;   --Accrual data calculation start date  
   
     
   UPDATE lea_accl_dtl  
   SET act_inv_knt = act_inv_knt + 1,   
       accl_calc_flg = 'Y',  
       upd_usr_id = 'ACCL_CAL_NB',  
       upd_dt = SYSDATE  
   WHERE ROWID IN   
   (SELECT /*+ PARALLEL (D 10) */   
    d.ROWID   
    FROM lea_accl_dtl d,  
         (SELECT DISTINCT   
                CASE WHEN coa_cost_src_Cd IN ('TPNDFL','SVLDFL','TPNDTS','SVLDTS') THEN 1  
                    WHEN coa_cost_src_Cd IN ('SVSSFL','SVSSTS') THEN 2  
                    WHEN coa_cost_src_Cd IN ('TMNDFL','TMNDTS') THEN 3  
                    ELSE 4   
                END cost_cd_tp,  
                rev_yrmon, bkg_no, cntr_no, cost_act_grp_seq,  cost_act_Grp_cd, max(act_inv_knt) knt  
        FROM lea_accl_dtl  
        WHERE rev_yrmon > TO_CHAR(ADD_MONTHS (TO_DATE (exe_yrmon_in, 'rrrrmm'), -5), 'rrrrmm')  
--        WHERE rev_yrmon >= substr(exe_yrmon_in, 1, 4) || '01' AND rev_yrmon <= exe_yrmon_in  --(수행월 - 5개월처리?)  
        AND act_cntr_cost_amt <> 0   
        AND mapg_aloc_flg = 'Y'          
        AND accl_calc_flg = 'Y'   
        AND CASE WHEN coa_cost_src_Cd IN ('TPNDFL','SVLDFL','TPNDTS','SVLDTS') THEN 1  
            WHEN coa_cost_src_Cd IN ('SVSSFL','SVSSTS') THEN 2  
            WHEN coa_cost_src_Cd IN ('TMNDFL','TMNDTS') THEN 3  
            ELSE 4  
        END  IN ( 1, 2, 3)  
        GROUP BY CASE WHEN coa_cost_src_Cd IN ('TPNDFL','SVLDFL','TPNDTS','SVLDTS') THEN 1  
                    WHEN coa_cost_src_Cd IN ('SVSSFL','SVSSTS') THEN 2  
                    WHEN coa_cost_src_Cd IN ('TMNDFL','TMNDTS') THEN 3  
                    ELSE 4  
                END , rev_yrmon, bkg_no, cntr_no, cost_act_grp_seq,  cost_act_Grp_cd   
                 ) e   
    WHERE d.rev_yrmon > TO_CHAR(ADD_MONTHS (TO_DATE (exe_yrmon_in, 'rrrrmm'), -5), 'rrrrmm')  
--    AND d.act_inv_knt < e.knt  -- 제거
    AND d.estm_cost_amt <> 0    ---추가 사항  
    AND d.accl_cost_amt <> 0   
    AND d.mapg_aloc_flg = 'Y'   
    AND d.rev_yrmon = e.rev_yrmon  
    AND d.bkg_no = e.bkg_no  
    AND d.cntr_no = e.cntr_no  
    AND d.cost_act_grp_seq = e.cost_act_grp_seq  
    AND d.cost_act_grp_cd = e.cost_act_grp_cd  
    AND CASE WHEN d.coa_cost_src_Cd IN ('TPNDFL','SVLDFL','TPNDTS','SVLDTS') THEN 1  
             WHEN d.coa_cost_src_Cd IN ('SVSSFL','SVSSTS') THEN 2  
             WHEN d.coa_cost_src_Cd IN ('TMNDFL','TMNDTS') THEN 3  
             ELSE 4   
        END = e.cost_cd_tp )  
    ;  
          
    COMMIT;  
                 
   execute immediate 'alter session enable parallel dml' ;     
     
   UPDATE /*+ parallel(XXCase,12) nologging */  
   (  
      SELECT /*+ parallel(d,12) */  
        accl_cost_amt, d.upd_usr_id, d.upd_dt,  
         CASE  
            --전용터미널 비용 배분을 타 터미널과 동일하게 변경하며, 전용터미널 내부거래 계정 사용치 않음  
            --단, Node Basic(NB) Cost Code에 대해서 Accrual은 Actual이 배분된 경우 추정과의 비교 없이 0으로 함  
            --※ 부산(KRPUSYG, KRPUSYK) 및 광양(KRKANY4)에만 해당하며 일본은 타 터미널과 완전히 동일한 Logic으로 전환됨     
            WHEN d.accl_lgc_tp_cd = 'NB' AND d.n1st_nod_cd in ('KRPUSYG', 'KRPUSYK', 'KRKANY4')  
               THEN 0  
            WHEN d.act_cost_amt < 0   
               THEN d.estm_cost_amt  
            WHEN d.accl_lgc_tp_cd = 'LB' OR d.accl_lgc_tp_cd = 'NB'  
               THEN CASE  
                      WHEN (d.act_inv_knt / DECODE(d.ttl_inv_knt, 0, 1, d.ttl_inv_knt)) >= 1  
                           OR  
                           (d.accl_lgc_tp_cd = 'NB' AND d.act_rev_vvd_cost_amt <> 0 )    
                         THEN 0  
                      ELSE DECODE(SIGN(d.estm_cost_amt - NVL(d.act_cost_amt, 0)), -1, 0, d.estm_cost_amt - NVL(d.act_cost_amt, 0))  
                    END  
            WHEN d.accl_lgc_tp_cd = 'NO'   
               THEN CASE   
                        WHEN d.rev_yrmon > (TO_CHAR(ADD_MONTHS (TO_DATE( exe_yrmon_in , 'YYYYMM') , -3) , 'YYYYMM'))
                          THEN DECODE(SIGN(NVL(d.act_rev_vvd_cost_amt, 0)), 1 , 0 ,  
                                      DECODE(SIGN(NVL(d.act_cost_amt, 0)), 1,  DECODE(SIGN(d.estm_cost_amt-d.act_cost_amt) , -1, 0 , d.estm_cost_amt-d.act_cost_amt ) , d.estm_cost_amt ) )  
                    END  
         END CalAccrual  
      FROM   lea_accl_dtl d  
      WHERE 1=1  
        AND d.rev_yrmon > TO_CHAR(ADD_MONTHS (TO_DATE (exe_yrmon_in, 'rrrrmm'), -5), 'rrrrmm')  
        AND d.accl_lgc_tp_cd IN ('LB', 'NB', 'NO')  
        AND d.accl_calc_flg = 'Y'  
        AND d.coa_cost_src_cd not in ('SVXXDC', 'CGXXDC', 'TMXXDC', 'SRXXDC') --Discount에 대한 Cost Code('SVXXDC', 'CGXXDC', 'TMXXDC', 'SRXXDC')는 Accrual을 계산하지 않음(LO Type)  
   ) XXCase  
   SET XXCase.accl_cost_amt = XXCase.CalAccrual,  
       XXCase.upd_usr_id    = DECODE(XXCase.upd_usr_id, 'ACCL_CAL_NB', 'ACCL_CAL_NB','ACCL_CAL_XX') , --Temp!!!  
       XXCase.upd_dt        = SYSDATE  
   ;  
  
   v_xxx_knt := SQL%ROWCOUNT ;  
   v_accl_knt := v_accl_knt + v_xxx_knt;  
     
   Commit;  
     
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_CAL_PRC:XXCase 완료('||v_xxx_knt||')') ; -- 시간 측정을 위한 디버깅 코드  
   lea_log_prc ('lea_accl_cal_prc() Status : Update XXCase Commited('||v_xxx_knt||').');  
  
   execute immediate 'alter session enable parallel dml' ;  
  
	MERGE /*+ USE_NL(N DTL) */ -- PARALLEL       : 8시간.   
	                           -- SERIAL+NO-SORT : 40분  
	                           -- SERIAL+SORT    : 20분  
	  INTO lea_accl_dtl dtl  
	USING (  
	  SELECT   RID, accl_cost_amt, upd_usr_id, upd_dt,  
			   DECODE(SubCalAccrual, 1, 0, DECODE(SIGN(estm_cost_amt - act_cost_amt), -1, 0, estm_cost_amt - act_cost_amt)) CalAccrual  
			   FROM (  
					 SELECT /*+ parallel(d,16) */  
							d.ROWID RID,   
							d.accl_cost_amt,  
							d.estm_cost_amt,  
							NVL(d.act_cost_amt, 0) act_cost_amt,  
                     d.upd_usr_id,  
                     d.upd_dt,  
                     least(greatest(NVL(inv_ratio,0), 0), 1) SubCalAccrual  
                FROM lea_accl_dtl d,  
                    (  
                     SELECT /*+ parallel(lb, 16) */  
                           lb.rev_yrmon, lb.bkg_no,   
                           lb.cntr_no, lb.cost_act_grp_seq,  
                           sum(lb.act_inv_knt)/DECODE(sum(lb.ttl_inv_knt), 0, 1, sum(lb.ttl_inv_knt)) inv_ratio  
                      FROM lea_accl_dtl lb  
                      WHERE lb.rev_yrmon > TO_CHAR(ADD_MONTHS (TO_DATE (exe_yrmon_in, 'rrrrmm'), -5), 'rrrrmm')  
                      AND lb.accl_lgc_tp_cd = 'LB'  
                        
                      AND lb.delt_flg = 'N'  
                      AND lb.act_cntr_cost_amt > 0   
                        
                      GROUP BY lb.rev_yrmon, lb.bkg_no, 
                           lb.cntr_no, lb.cost_act_grp_seq  
                    ) LB  
                WHERE 1=1  
                AND d.rev_yrmon > TO_CHAR(ADD_MONTHS (TO_DATE (exe_yrmon_in, 'rrrrmm'), -3), 'rrrrmm')  
                AND d.accl_lgc_tp_cd = 'LO'   --반드시 LB 작업이 완료된 뒤에 처리되어야 된다.  
                  
                AND d.accl_calc_flg = 'Y'  
                AND d.accl_cost_amt  > 0  
                  
                AND lb.rev_yrmon = d.rev_yrmon  
                AND lb.bkg_no = d.bkg_no  
                AND lb.cntr_no = d.cntr_no  
                AND lb.cost_act_grp_seq = d.cost_act_grp_seq  
                )      
      ORDER BY RID -- NESTED LOOP조인 속도 향상(2배 개선)  
   ) N  
   ON (dtl.ROWID = N.RID)  
   WHEN MATCHED THEN  
      UPDATE SET dtl.accl_cost_amt = n.CalAccrual,  
                 dtl.upd_usr_id    = 'ACCL_CAL_LO',  
                 dtl.upd_dt        = SYSDATE ;  
  
   v_lo_knt   := SQL%ROWCOUNT ;  
   v_accl_knt := v_accl_knt +  v_lo_knt ;                  
                 
   COMMIT;  
      
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_CAL_PRC:LOCase 완료('||v_lo_knt||')') ; -- 시간 측정을 위한 디버깅 코드  
   lea_log_prc ('lea_accl_cal_prc() Status : Update LOCase Commited('||v_lo_knt||').');  
   
   
     
   
   -- 홍콩 관련 Invoice 에 대한 Accrual 처리
    UPDATE LEA_ACCL_DTL
    SET ACCL_COST_AMT = 0
    WHERE (REV_YRMON , BKG_NO, CNTR_NO , COST_ACT_GRP_SEQ,COA_COST_SRC_CD)
            IN (
                SELECT DISTINCT REV_YRMON , BKG_NO, CNTR_NO , COST_ACT_GRP_SEQ,COA_COST_SRC_CD
                FROM (
                        SELECT  REV_YRMON , BKG_NO, CNTR_NO , COST_ACT_GRP_SEQ, COA_COST_SRC_CD,
                                SUM(ACT_CNTR_COST_AMT/ESTM_COST_AMT) OVER(PARTITION BY BKG_NO,  CNTR_NO) AMT , 
                                SUM(ACCL_COST_AMT)  OVER(PARTITION BY BKG_NO,  CNTR_NO) ACCL
                        FROM    LEA_ACCL_DTL
                        WHERE   REV_YRMON > TO_CHAR(ADD_MONTHS (TO_DATE (exe_yrmon_in, 'RRRRMM'), -5), 'RRRRMM')  
                        AND     COA_COST_SRC_CD = 'TPNDTS'
                        AND     N1ST_NOD_CD LIKE 'CNHKG%'
                        AND     DELT_FLG = 'N'
                        AND     ESTM_COST_AMT<>0
                    ) A
                WHERE A.AMT > 0.8 AND A.ACCL > 0 
                )
    AND ACCL_COST_AMT >0
    ; 
    commit;
     
   execute immediate 'alter session enable parallel dml' ;  
   --수행년월 기준으로 3개월 이전 Other.Amount 및 아래 5개의 Cost에 대해서는 Accrual 를 0 으로 처리(Clear)  
   UPDATE /*+ parallel(OthClrCase,12) nologging */  
   (  
      SELECT /*+ parallel(d,12) */  
             accl_cost_amt, d.upd_usr_id, d.upd_dt  
      FROM   lea_accl_dtl d  
      WHERE  1=1  
        AND  d.rev_yrmon <= TO_CHAR(ADD_MONTHS (TO_DATE (exe_yrmon_in, 'rrrrmm'), -3), 'rrrrmm')  
        AND  ( d.accl_lgc_tp_cd IN ('LO', 'NO') --Other Cost Type  
                OR d.coa_cost_src_cd in ('TMFDFL', 'TMNDRF', 'TMNDTS', 'SVSSFL', 'SVSSTS') )  
        AND  NVL(d.accl_cost_amt, 1 ) <> 0  
   ) OthClrCase  
   SET OthClrCase.accl_cost_amt = 0,  
       OthClrCase.upd_usr_id    = 'ACCL_CAL_CLR',  
       OthClrCase.upd_dt        = SYSDATE  
   ;  
     
   v_othclr_knt := SQL%ROWCOUNT ;  
     
   v_accl_knt := v_accl_knt + v_othclr_knt;  
     
   Commit;  
  
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_CAL_PRC:OthClrCase 완료('||v_othclr_knt||')') ; -- 시간 측정을 위한 디버깅 코드  
   lea_log_prc ('lea_accl_cal_prc() Status : Update OthClrCase Commited('||v_othclr_knt||').');  
     
     
   -- 5개월 이전의 남아 있는 모든 ACCL_COST_AMT 를 제거한다. 
   -- ESTM_COST_AMT = 0 으로 변동된 경우 기존 ACCL_COST_AMT 를 제거한다.   
--   UPDATE LEA_ACCL_DTL  
--   SET ACCL_COST_AMT = 0  
--   WHERE ( (REV_YRMON <= TO_CHAR(ADD_MONTHS (TO_DATE (exe_yrmon_in, 'RRRRMM'), -5), 'RRRRMM')) 
--            OR
--           (REV_YRMON > TO_CHAR(ADD_MONTHS (TO_DATE (exe_yrmon_in, 'rrrrmm'), -5), 'rrrrmm') 
--            AND ESTM_COST_AMT = 0 )
--         )
--   AND ACCL_COST_AMT <> 0         
--   ;  

   UPDATE lea_accl_dtl 
   SET accl_cost_amt = 0 
   WHERE rev_yrmon >= substr(exe_yrmon_in, 1, 4) || '01'  
   AND rev_yrmon <= TO_CHAR(ADD_MONTHS (TO_DATE (exe_yrmon_in, 'rrrrmm'), -5), 'rrrrmm') 
   AND NVL(accl_cost_amt, 1) <> 0 
   ;
   commit;
   
   UPDATE lea_accl_dtl 
   SET accl_cost_amt = 0 
   WHERE rev_yrmon > TO_CHAR(ADD_MONTHS (TO_DATE (exe_yrmon_in, 'rrrrmm'), -5), 'rrrrmm') 
   AND estm_cost_amt = 0
   AND NVL(accl_cost_amt, 1) <> 0 
   ;
   commit;
     
   v_clr_knt := SQL%ROWCOUNT ;  
     
   v_accl_knt := v_accl_knt + v_clr_knt;  
     
   
     
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_CAL_PRC:5개월이전삭제 완료('||v_clr_knt||')') ;   
   lea_log_prc ('lea_accl_cal_prc() Status : Update 5Month Clr Commited('||v_clr_knt||').');  
  
   --Batch History Record setting  
   v_bat_his_rec.exe_yrmon := exe_yrmon_in;  
   v_bat_his_rec.bat_id := bat_id_in;  
   v_bat_his_rec.accl_knt := v_accl_knt;                                              
   v_bat_his_rec.accl_end_dt := SYSDATE;                        --Accrual Calculation data insert end date  
   v_rtn_val := lea_accl_bat_his_fnc (v_bat_his_rec, 'AC');     --Batch History Accrual Calculation(Update)  
     
   Commit;  
     
   lea_log_prc ('lea_accl_cal_prc() End.('||v_accl_knt||')');  
     
   /* Exception -----------------------------------------------------------------*/  
   EXCEPTION  
   WHEN OTHERS  
   THEN  
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);      
     
END;