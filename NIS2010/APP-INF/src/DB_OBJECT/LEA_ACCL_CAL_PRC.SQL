CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACCL_CAL_PRC (exe_yrmon_in IN VARCHAR, bat_id_in IN VARCHAR)  
IS  
/*******************************************************************************  
  1.Object Name      : LEA_ACCL_CAL_PRC 
  2.Version          : 1.0 
  3.Create Date      : 2007-03-02  
  4.Sub System       : Logistics Expense Accrual 
  5.Author           : ����ȫ 
  6.Description      : Actual Cost �� ����/��� �� �� ��� ������ ���� ACCL_COST_AMT ó�� 
  7.Revision History : 
        2007-03-02 : - ���� ���ʻ���.  
        2008-04-25 : - ����ȫ : NO �ΰ�� act_cost_amt ����� accl_cost_amt = 0   
        2008-04-30 : - TES NB Cost�� act_inv_knt �� cost code grouping�� �����Ͽ�  
                       accrual amount ���.  
        2008-06-23 : - LO , NO �� 5���� ������ ���� Accrual ���Ž� ��ȣ �߰�(EX. 6�� ���� 1�� ����Ÿ���� ����)  
        2008-06-27 : - LO , NO �� 5���� ���� Accrual ���Ÿ� 3������ ����  
                     - Mapping�� �̷������ �ʰ�, Act VVD �ݾ��� ��ι��� NB Cost �� Accrual ����  
                     - ����� ���� 5���� ������ ��� Accrual ���� ���� �߰�  
        2008-07-22 : - NO �϶� act_cost_amt �� minus(-) �ΰ�� Accrual �� Estimation ���� �Ѵ�.  
        2008-09-25 : - TMFDFL, TMNDRF, TMNDTS, SVSSFL, SVSSTS �� NB cost code�� accrual   
                       ���� �ñ�� NO�� ���� 3������ ����  
                       - Ư�� Cost Code �� ������ NO Cost �� ���ؼ��� rev.month ����   
                         ��������� 2�������ȿ��� estm_cost_amt - act_cost_amt �� accl_cost_amt�� ����Ѵ�.  
                       - ~DC Cost �� Accl_cost_amt = 0  
                       - NO �� �ֱ� 3���� ������ accl_cost_amt =0  �������� ����  
                       - Accl amt �� �ִ� rev.month ���� 5���� �����̹Ƿ� ������ (�����-5) �� �Ѵ�.  
                         (Other Cost - LO, NO �� 3����)  
        2008-10-10 : - act_cost_amt �� minus(-) �ΰ�� Accrual �� Estimation ���� �Ѵ�.  
        2009-05-22 : - LO Type ���� Accl ����  
                     - DELETE �� �ǵ��� Invoice Ratio ���� ����          
                     - LB ������� ���� ó���� �͵鸸 ���  
        2009-06-17 : - NO �� ���ؼ� actual/revenue vvd ��ε� ���� �ִ� ���(ACT_REV_VVD_COST_AMT> 0)���� 
                       ACCL_COST_AMT =0 ���� ����Ѵ� �������� ���� CASE �� ���� ���� ���.   
        2009-09-29 : - Cost Group �� ���� Actual Invoice Count �������� ACT_INV_KNT �񱳸� ����.
                       (Invoice ������ NB COST �� ��� Cost GROUP �� ���� ���- (TPNDFL+SVLDFL, TPNDTS+SVLDTS..)�� 
                        �����ɼ� �ֱ⶧���� �̿� ���� ACCL_COST_AMT �� ó���ϱ� ����)  
        2009-10-09 : - ȫ�� ���� Invoice �����Ͽ� Accrual ��� ���� �߰�
                     - ESTM_COST_AMT = 0 ���� ������ ��� ���� ACCL_COST_AMT �� ����
        2009-11-24 : - NO Calc �� ������κ��� ������ 3����°�� �ش��Ұ�� ���� �߰�
                     - NO Calc �� ������κ��� 3���� ������ ���Ͽ� 0���� ó���� NULL ó�� �߰�
                     - NO Calc �������� 2�������� 3������ ����.(�ѹ�) 
        2010-04-13 : - ȫ�� ���� ���� ���� (ACTUAL/ ESTM >0.8 �̰� ACCRUAL >0 �̻� ACCRUAL ����)
                       SUTTLE ��� ESTM �� ���� �����ϳ� ȫ�ῡ�� INVOICE �� �ϳ��� ����  
                     - BKG_NO = BKG_NO||BKG_NO_SPLIT ���� ����(BKG_NO_SPLIT ����)         
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
--        WHERE rev_yrmon >= substr(exe_yrmon_in, 1, 4) || '01' AND rev_yrmon <= exe_yrmon_in  --(����� - 5����ó��?)  
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
--    AND d.act_inv_knt < e.knt  -- ����
    AND d.estm_cost_amt <> 0    ---�߰� ����  
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
            --�����͹̳� ��� ����� Ÿ �͹̳ΰ� �����ϰ� �����ϸ�, �����͹̳� ���ΰŷ� ���� ���ġ ����  
            --��, Node Basic(NB) Cost Code�� ���ؼ� Accrual�� Actual�� ��е� ��� �������� �� ���� 0���� ��  
            --�� �λ�(KRPUSYG, KRPUSYK) �� ����(KRKANY4)���� �ش��ϸ� �Ϻ��� Ÿ �͹̳ΰ� ������ ������ Logic���� ��ȯ��     
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
        AND d.coa_cost_src_cd not in ('SVXXDC', 'CGXXDC', 'TMXXDC', 'SRXXDC') --Discount�� ���� Cost Code('SVXXDC', 'CGXXDC', 'TMXXDC', 'SRXXDC')�� Accrual�� ������� ����(LO Type)  
   ) XXCase  
   SET XXCase.accl_cost_amt = XXCase.CalAccrual,  
       XXCase.upd_usr_id    = DECODE(XXCase.upd_usr_id, 'ACCL_CAL_NB', 'ACCL_CAL_NB','ACCL_CAL_XX') , --Temp!!!  
       XXCase.upd_dt        = SYSDATE  
   ;  
  
   v_xxx_knt := SQL%ROWCOUNT ;  
   v_accl_knt := v_accl_knt + v_xxx_knt;  
     
   Commit;  
     
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_CAL_PRC:XXCase �Ϸ�('||v_xxx_knt||')') ; -- �ð� ������ ���� ����� �ڵ�  
   lea_log_prc ('lea_accl_cal_prc() Status : Update XXCase Commited('||v_xxx_knt||').');  
  
   execute immediate 'alter session enable parallel dml' ;  
  
	MERGE /*+ USE_NL(N DTL) */ -- PARALLEL       : 8�ð�.   
	                           -- SERIAL+NO-SORT : 40��  
	                           -- SERIAL+SORT    : 20��  
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
                AND d.accl_lgc_tp_cd = 'LO'   --�ݵ�� LB �۾��� �Ϸ�� �ڿ� ó���Ǿ�� �ȴ�.  
                  
                AND d.accl_calc_flg = 'Y'  
                AND d.accl_cost_amt  > 0  
                  
                AND lb.rev_yrmon = d.rev_yrmon  
                AND lb.bkg_no = d.bkg_no  
                AND lb.cntr_no = d.cntr_no  
                AND lb.cost_act_grp_seq = d.cost_act_grp_seq  
                )      
      ORDER BY RID -- NESTED LOOP���� �ӵ� ���(2�� ����)  
   ) N  
   ON (dtl.ROWID = N.RID)  
   WHEN MATCHED THEN  
      UPDATE SET dtl.accl_cost_amt = n.CalAccrual,  
                 dtl.upd_usr_id    = 'ACCL_CAL_LO',  
                 dtl.upd_dt        = SYSDATE ;  
  
   v_lo_knt   := SQL%ROWCOUNT ;  
   v_accl_knt := v_accl_knt +  v_lo_knt ;                  
                 
   COMMIT;  
      
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_CAL_PRC:LOCase �Ϸ�('||v_lo_knt||')') ; -- �ð� ������ ���� ����� �ڵ�  
   lea_log_prc ('lea_accl_cal_prc() Status : Update LOCase Commited('||v_lo_knt||').');  
   
   
     
   
   -- ȫ�� ���� Invoice �� ���� Accrual ó��
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
   --������ �������� 3���� ���� Other.Amount �� �Ʒ� 5���� Cost�� ���ؼ��� Accrual �� 0 ���� ó��(Clear)  
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
  
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_CAL_PRC:OthClrCase �Ϸ�('||v_othclr_knt||')') ; -- �ð� ������ ���� ����� �ڵ�  
   lea_log_prc ('lea_accl_cal_prc() Status : Update OthClrCase Commited('||v_othclr_knt||').');  
     
     
   -- 5���� ������ ���� �ִ� ��� ACCL_COST_AMT �� �����Ѵ�. 
   -- ESTM_COST_AMT = 0 ���� ������ ��� ���� ACCL_COST_AMT �� �����Ѵ�.   
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
     
   
     
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACCL_CAL_PRC:5������������ �Ϸ�('||v_clr_knt||')') ;   
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