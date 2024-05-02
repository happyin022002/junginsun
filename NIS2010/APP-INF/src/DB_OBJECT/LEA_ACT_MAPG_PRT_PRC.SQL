CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACT_MAPG_PRT_PRC (exe_yrmon_in IN VARCHAR, bat_id_in IN VARCHAR)   
IS   
/*******************************************************************************   
  1.Name       : 전재홍 
  2.Create Date: 2007-02-02   
  3.Description:   
      - 용도: e-NIS 화물변동비 추정결산을 위한 월간 배치프로그램   
      - 파라미터: 실행수행년월(in_exeyrmon(Format:'YYYYMM'))   
      - 특이사항   
        (1) 유저가 매월초 추정 전제조건을 확인하고 배치프로그램을 실행(호출)   
        (2) 대용량 데이터 처리   
  4.Revision History   
    - 나장근(WIZBASE) 2007-02-02:최초생성. 
    - 전재홍  2008-01-25 : 결산 대상 GROUPING 변경(ACT VVD 기준)
      2008-02-11 : - 200801~200803 수행월에는 200710 REV.MONTH 부터
      2008-06-09 : - max_job 을 12개에서 6개로 줄임.(이정남 수석 권장)
      2008-11-21 : - CNTC 배부시 NODE-> Location 단위로 배부 적수 변경.
      2009-01-21 : - Exe.Yrmon가 1,2,3 월일경우 Rev.Month 는 전년도 각각 10,11,12 월부터  
                     포함하도록 로직으로 반영 
*******************************************************************************/   
   PRAGMA AUTONOMOUS_TRANSACTION;   
/* Variable Declare -------------------------------------------------------*/   
   
   -- Schedule Setting   
   -- JOB QUEUE 에서 JOB QUEUE를 호출하면 수행이 안되는 문제때문에 SCHEDULER를 사용함   
   c_use_scheduler   CONSTANT BOOLEAN                 := TRUE;    
   c_iter_prc_nm     CONSTANT VARCHAR2 (100)          := 'LEA_BAT_PAR_ITER_PRC';   
   c_prc_nm          CONSTANT VARCHAR2 (100)          := 'LEA_ACT_COST_MAPG_PRC';   
   c_max_job         CONSTANT BINARY_INTEGER          := 6;   
   c_mon_cycle       CONSTANT BINARY_INTEGER          := 1;   -- 1초 주기로 모니터링   
   -----------------------------------------------------------------------------------   
      
   v_jobid                    BINARY_INTEGER;   
   v_action                   VARCHAR2 (100);   
   v_cnt                      BINARY_INTEGER;   
   v_initial                  NUMBER;   
   v_total                    NUMBER;   
   v_running                  NUMBER;   
   v_finished                 NUMBER;   
   v_failed                   NUMBER;   
   v_bat_his_rec              lea_bat_pkg.bat_his_rec;   --Batch Hostory Record   
   v_rtn_val                  VARCHAR2 (1);   
BEGIN   
   lea_log_prc ('lea_act_mapg_prt_prc() Start.');   
   v_bat_his_rec.mapg_aloc_st_dt := SYSDATE;   --Estimate data insert start date   
      
   /*-------------------------------------------------------------------------------------*/   
   /* Level 1,2,3 데이타 생성 --> 1,2,3 모두 Level 1로 해서 보낸다.(Level 구별 하지 않음) */   
   /* 실제 레벨은 LEA_ACT_COST_MAPG_PRC 가 나눠서 처리한다.                               */   
   /*-------------------------------------------------------------------------------------*/   
   DELETE   lea_bat_par_prt   
   WHERE    prc_nm = c_prc_nm; --LEA_ACT_COST_MAPG_PRC   
      
--    선작업 및 재작업에 대한 처리   
--      update lea_act_cost_if
--      set   act_cost_mapg_cd = 'N',
--            cntr_mapg_expt_log = ''
--      where exe_yrmon = exe_yrmon_in   
--      ;   
      
--   DELETE LEA_REV_VVD_CNG
--   WHERE exe_yrmon = exe_yrmon_in
--   ;
   
   DELETE   lea_err_log;   
   COMMIT;   
      
      
   INSERT INTO lea_bat_par_prt  
      SELECT c_prc_nm                                   PRC_NM,    
            ROW_NUMBER () OVER (ORDER BY MAPG_PRT_LVL, SUM(INV_KNT) DESC) PAR_PRT_SEQ,    
          'N'                                        PAR_PRT_STS_CD,    
          TO_NUMBER (NULL)                           MODI_ROW_KNT,   
          TO_NUMBER (NULL)                           PROC_NO,   
          TO_DATE (NULL)                             ST_TMS,    
          TO_DATE (NULL)                             END_TMS,   
          MAPG_PRT_LVL,   
          exe_yrmon_in                               EXE_YRMON,   
          NULL                                       REV_YRMON,   
          DECODE(MAPG_PRT_LVL,3,SUBSTR(ACT_VVD,1,4), VSL_CD) ,   -- LVL 1, 2 => REV_VVD, LVL 3 => ACT_VVD 
          DECODE(MAPG_PRT_LVL,3,SUBSTR(ACT_VVD,5,4), SKD_VOY_NO) ,    
          DECODE(MAPG_PRT_LVL,3,SUBSTR(ACT_VVD,9,1), SKD_DIR_CD) ,    
          DECODE(MAPG_PRT_LVL,3,NULL, REV_DIR_CD) ,    
          NULL                                       ESTM_VVD_TP_CD,    
          NULL                                       ESTM_IOC_DIV_CD,    
          DECODE(MAPG_PRT_LVL,3,COA_COST_SRC_CD),    
          DECODE(MAPG_PRT_LVL,3,N1ST_NOD_CD),    
          sum(INV_KNT)   
        FROM (SELECT /* FULL(A) PARALLEL(A) USE_HASH(A B) */ -- 테이블 lea_act_cost_if 건수가 늘어나면 힌트로 전환(현재는 건수가 적어서 안쓰는게 빠름)   
                       (CASE   
                            WHEN a.cntr_no IS NOT NULL   
                            AND a.bkg_no IS NOT NULL   
                            AND a.vsl_cd <> 'CNTC'   
                                THEN 1   
                            WHEN a.bkg_no IS NOT NULL   
                            AND a.vsl_cd <> 'CNTC'   
                                THEN 2   
                            WHEN a.act_vvd_cd is not null and substr(a.act_vvd_cd ,1,4) <> 'CNTC'   
                                THEN 3   
                            ELSE 4   
                        END   
                       ) mapg_prt_lvl,   
                       a.vsl_cd, a.skd_voy_no, a.skd_dir_cd, a.rev_dir_cd, a.act_vvd_cd act_vvd,
                       a.coa_cost_src_cd, a.n1st_nod_cd n1st_nod_cd,    
                       COUNT (1) inv_knt   
                  FROM lea_act_cost_if a, lea_lgs_cost b   
                 WHERE 1=1
                 AND a.exe_yrmon BETWEEN SUBSTR (exe_yrmon_in, 1, 4) AND exe_yrmon_in  
                 AND a.rev_yrmon BETWEEN CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03')
                                                THEN TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm') 
                                              ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01'
                                         END
                                 AND exe_yrmon_in 
--                 AND a.rev_yrmon BETWEEN SUBSTR (exe_yrmon_in, 1, 4) AND exe_yrmon_in  
--                     AND a.exe_yrmon BETWEEN '200712' AND exe_yrmon_in
--                     AND a.rev_yrmon BETWEEN '200710' AND exe_yrmon_in 
--                   AND a.rev_yrmon >= '200706' -- 6월 수입항차부터 대상으로 잡음.
                   AND a.act_cost_mapg_cd = 'N'    
                   AND a.otr_crr_flg = 'N'   
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
              GROUP BY a.vsl_cd,   
                       a.skd_voy_no,   
                       a.skd_dir_cd,   
                       a.rev_dir_cd,   
                       a.act_vvd_cd, 
                       a.coa_cost_src_cd,   
                       a.n1st_nod_cd,   
                       CASE   
                            WHEN a.cntr_no IS NOT NULL   
                            AND a.bkg_no IS NOT NULL   
                            AND a.vsl_cd <> 'CNTC'   
                                THEN 1   
                            WHEN a.bkg_no IS NOT NULL   
                            AND a.vsl_cd <> 'CNTC'   
                                THEN 2   
                            WHEN a.act_vvd_cd is not null and substr(a.act_vvd_cd ,1,4) <> 'CNTC'  
                                THEN 3   
                            ELSE 4   
                       END) a   
       WHERE mapg_prt_lvl IN (1, 2, 3)        
       GROUP BY MAPG_PRT_LVL,  
          DECODE(MAPG_PRT_LVL,3,SUBSTR(ACT_VVD,1,4), VSL_CD) ,   -- LVL 1, 2 => REV_VVD, LVL 3 => ACT_VVD 
          DECODE(MAPG_PRT_LVL,3,SUBSTR(ACT_VVD,5,4), SKD_VOY_NO) ,    
          DECODE(MAPG_PRT_LVL,3,SUBSTR(ACT_VVD,9,1), SKD_DIR_CD) ,    
          DECODE(MAPG_PRT_LVL,3,NULL, REV_DIR_CD),  
          DECODE(MAPG_PRT_LVL,3,COA_COST_SRC_CD),  
          DECODE(MAPG_PRT_LVL,3,N1ST_NOD_CD)  
       ORDER BY MAPG_PRT_LVL, PAR_PRT_SEQ  
       ;   
   
    lea_log_prc ('MPPG_PRT_LVL 123 COMMIT ' || SQL%ROWCOUNT);   
   COMMIT;   
      
   
   -- Level 1,2,3 데이타에 대한 처리 프로세스를 N개의 병렬로 수행하기 위해   
   -- 스케줄러에 N 개의 Job 을 등록한다.   
   FOR i IN 1 .. c_max_job   
   LOOP   
      -- c_iter_prc_nm = 'LEA_BAT_PAR_ITER_PRC', c_prc_nm = 'LEA_ACT_COST_MAPG_PRC'   
      v_action := c_iter_prc_nm || '(' || i || ',''' || c_prc_nm || ''');';   
   
      IF /*lea_bat_pkg.*/ c_use_scheduler   
      THEN   --###### SCHEDULER 사용시   
         DBMS_SCHEDULER.create_job (job_name        => 'LEA_BAT_MAPG_L123_' || i,   
                                    job_type        => 'PLSQL_BLOCK',   
                                    job_action      => v_action,   
                                    enabled         => TRUE,   -- 등록즉시 수행   
                                    comments        => '화물 변동비 추정 Actual Cost 매핑 배분 Level 1~3'   
                                   );   
      ELSE   --###### JOB QUEUE 사용시   
         DBMS_JOB.submit (v_jobid, v_action);   
      END IF;   
   END LOOP;   
   
   COMMIT;   
   lea_log_prc ('MPPG_PRT_LVL 123 : JOB REGISTERD');   
   
   -- Level 1~3의 처리는 스케줄러에 의해 수행되는 N 개의 병렬 작업에 의해 수행된다.   
   -- 이 프로시저는 스케줄러 작업이 끝나는지만 확인하면 된다.   
   
   -- 모든 스케줄러 Job 이 끝날때까지 대기한다.   
   LOOP   
      IF /*lea_bat_pkg.*/ c_use_scheduler   
      THEN   --###### SCHEDULER 사용시   
         --## SCHEDULER 사용시   
         SELECT COUNT (1)   
           INTO v_cnt   
           FROM user_scheduler_jobs   
          WHERE job_action LIKE c_iter_prc_nm || '%';   
      ELSE   --###### JOB QUEUE 사용시   
         SELECT COUNT (1)   
           INTO v_cnt   
           FROM user_jobs   
          WHERE what LIKE c_iter_prc_nm || '%';   
      END IF;   
   
      IF v_cnt = 0   
      THEN   
         EXIT;   
      END IF;   
   
      DBMS_LOCK.sleep (c_mon_cycle);   
   END LOOP;   
   
   lea_log_prc ('MPPG_PRT_LVL 123 : JOB END');   
   
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACT_MAPG_PRT_PRC:LVL_123 완료') ; -- 시간 측정을 위한 디버깅 코드   
      
   -- 작업이 모두 정상적으로 끝났는지 조회한다.   
   SELECT NVL (SUM (DECODE (par_prt_sts_cd, 'N', 1, 0)), 0) not_started,   
          NVL (SUM (DECODE (par_prt_sts_cd, 'R', 1, 0)), 0) running,   
          NVL (SUM (DECODE (par_prt_sts_cd, 'Y', 1, 0)), 0) finished,   
          NVL (SUM (DECODE (par_prt_sts_cd, 'F', 1, 0)), 0) failed   
     INTO v_initial,   
          v_running,   
          v_finished,   
          v_failed   
     FROM lea_bat_PAR_prt;   
   
   DBMS_OUTPUT.put_line (NULL);   
   
   IF v_initial > 0   
   THEN   
      lea_log_prc ('수행되지 않은 Level 1~3 매핑 작업이 있습니다.');   
      COMMIT;   
      RETURN;   
   ELSIF v_running > 0   
   THEN   
      lea_log_prc ('Level 1~3 매핑 작업이 현재 수행중입니다.');   
      COMMIT;   
      RETURN;   
   ELSIF v_failed > 0   
   THEN   
      lea_log_prc ('실패한 Level 1~3 매핑 작업이 있습니다.');   
      COMMIT;   
      RETURN;   
   ELSIF v_finished = 0   
   THEN   
      lea_log_prc ('Level 1~3 매핑 작업이 하나도 수행되지 않았습니다.');   
      COMMIT;   
      RETURN;   
   ELSE   
      lea_log_prc ('Level 1~3 매핑 정상적으로 종료되었습니다.');   
   END IF;   
   
   -- 아래 건수가 나오면 안됨   
   SELECT COUNT (1)   
     INTO v_cnt   
     FROM lea_act_cost_if a, lea_lgs_cost b   
    WHERE substr(a.act_vvd_cd, 1, 4) <> 'CNTC'   and a.act_vvd_cd  is not null
      AND act_cost_mapg_cd = 'N'   
      AND a.exe_yrmon BETWEEN SUBSTR (exe_yrmon_in, 1, 4) AND exe_yrmon_in   --  + 4QTA?...   
      AND a.rev_yrmon BETWEEN CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03')
                                       THEN TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm') 
                                   ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01'
                              END
                      AND exe_yrmon_in   
--      AND a.exe_yrmon BETWEEN '200712' AND exe_yrmon_in
--      AND a.rev_yrmon BETWEEN '200710' AND exe_yrmon_in 
      AND a.otr_crr_flg = 'N'   
      AND b.accl_auto_cd = 'A'   
      AND b.estm_cost_flg = 'Y'   
      AND b.accl_flg = 'Y'   
      AND b.delt_flg = 'N'   
      AND a.coa_cost_src_cd = b.coa_cost_src_cd ;  
--      AND a.acct_cd = b.acct_cd;   
   
   IF v_cnt > 0   
   THEN   
      lea_log_prc ('Level 1~3에 해당되는 데이타중에 매핑되지 않은 건이 ' || v_cnt || ' 건 있습니다.' );   
   END IF;   
   
   
   

   
   --##########################################################################   
   -- 처리되지 않은 Actual Data를 사용하여 Level 4 처리를 수행한다.   
   --##########################################################################   
   SELECT MAX (par_prt_seq) + 1   
     INTO v_cnt   
     FROM lea_bat_par_prt   
    WHERE prc_nm = c_prc_nm   
    ;   
   
   lea_log_prc ('MPPG_PRT_LVL 4 START');   
   
   INSERT INTO lea_bat_par_prt   
      SELECT c_prc_nm                                           PRC_NM,    
            v_cnt + ROW_NUMBER () OVER (ORDER BY inv_knt DESC) PAR_PRT_SEQ,   
          'N'                                                PAR_PRT_STS_CD,    
          TO_NUMBER (NULL)                                   MODI_ROW_KNT,   
          TO_NUMBER (NULL)                                   PROC_NO,   
          TO_DATE (NULL)                                     ST_TMS,    
          TO_DATE (NULL)                                     END_TMS,   
          MAPG_PRT_LVL,   
          exe_yrmon_in                                       EXE_YRMON,   
          NULL                                               REV_YRMON,   
          VSL_CD,   
          SKD_VOY_NO,    
          SKD_DIR_CD,    
          REV_DIR_CD,    
          NULL                                               ESTM_VVD_TP_CD,    
          NULL                                               ESTM_IOC_DIV_CD,    
          COA_COST_SRC_CD,    
          N1ST_NOD_CD,    
          INV_KNT   
        FROM (SELECT /* FULL(A) PARALLEL(A) USE_HASH(A B) */ -- 테이블 lea_act_cost_if 건수가 늘어나면 힌트로 전환(현재는 건수가 적어서 안쓰는게 빠름)   
                       4 MAPG_PRT_LVL,    
                       'CNTC' vsl_cd, ' ' skd_voy_no, ' ' skd_dir_cd, ' ' rev_dir_cd,    
                        a.coa_cost_src_cd, 
                        CASE WHEN a.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' )  
                                THEN a.n1st_nod_cd
                            ELSE SUBSTR(a.n1st_nod_cd , 1, 5)
                        END n1st_nod_cd ,   
                       --A.act_cost_mapg_cd,   
                       COUNT (1) INV_KNT   
                  FROM lea_act_cost_if a, lea_lgs_cost b   
                 WHERE 1=1
                 AND a.exe_yrmon BETWEEN SUBSTR (exe_yrmon_in, 1, 4) AND exe_yrmon_in 
                 AND a.rev_yrmon BETWEEN CASE WHEN SUBSTR(exe_yrmon_in, 5 ,2 ) IN ('01','02','03')
                                                THEN TO_CHAR(ADD_MONTHS(TO_DATE(exe_yrmon_in, 'yyyymm'), -3), 'yyyymm') 
                                              ELSE SUBSTR(exe_yrmon_in,  1, 4) || '01'
                                         END
                                 AND exe_yrmon_in      
--                 AND a.rev_yrmon BETWEEN SUBSTR (exe_yrmon_in, 1, 4) AND exe_yrmon_in 
                   AND (substr(a.act_vvd_cd , 1, 4) = 'CNTC' or a.act_vvd_cd is null)
                   AND (nvl(a.cost_act_grp_cd, ' '), a.coa_cost_src_cd) 
                                not in (('NIBC', 'TMNDFL'),
                                        ('NIBC', 'TMFDFL'),
                                        ('NOBC', 'TMNDFL'),
                                        ('NOBC', 'TMFDFL'))   -- 대부분 존재하지 않을것임. 
                   AND a.act_cost_mapg_cd = 'N'   
                   AND a.otr_crr_flg = 'N'   
                   AND b.accl_auto_cd = 'A'   
                   AND b.estm_cost_flg = 'Y'   
                   AND b.accl_flg = 'Y'   
                   AND b.delt_flg = 'N'   
                   AND a.coa_cost_src_cd = b.coa_cost_src_cd   
--                   AND a.acct_cd = b.acct_cd   
              GROUP BY a.coa_cost_src_cd, 
                       CASE WHEN a.n1st_nod_cd in ('KRPUSYK' , 'KRPUSYG' , 'KRKANY4' )  
                                THEN a.n1st_nod_cd
                            ELSE SUBSTR(a.n1st_nod_cd , 1, 5)
                       END) a;   
   
   
   lea_log_prc ('MPPG_PRT_LVL 4 ROWCOUNT:' || SQL%ROWCOUNT);   
   COMMIT;   
   lea_log_prc ('MPPG_PRT_LVL 4 COMMIT');   
   
   -- Level 4의 처리도 스케줄러에 의해 수행되는 N 개의 병렬 작업에 의해 수행된다.   
   -- 이 프로시저는 스케줄러 작업이 끝나는지만 확인하면 된다.   
   
   -- Level 1,2,3 데이타에 대한 처리 프로세스를 N개의 병렬로 수행한다.   
   -- N 개의 스케줄러 Job 을 등록한다.   
   FOR i IN 1 .. c_max_job   
   LOOP   
--      v_action := c_iter_prc_nm || '(' || i || ');';   
      v_action := c_iter_prc_nm || '(' || i || ',''' || c_prc_nm || ''');';   
   
      IF /*lea_bat_pkg.*/ c_use_scheduler   
      THEN   --###### SCHEDULER 사용시   
         DBMS_SCHEDULER.create_job (job_name        => 'LEA_BAT_MAPG_L4__' || i,   
                                    job_type        => 'PLSQL_BLOCK',   
                                    job_action      => v_action,   
                                    enabled         => TRUE,   -- 등록즉시 수행   
                                    comments        => '화물 변동비 추정 Actual Cost 매핑 배분 Level 4'   
                                   );   
      ELSE   --###### JOB QUEUE 사용시   
         DBMS_JOB.submit (v_jobid, v_action);   
      END IF;   
   END LOOP;   
   
   COMMIT;   
   lea_log_prc ('MPPG_PRT_LVL 4 : JOB REGISTERD');   
   
   -- 모든 스케줄러 Job 이 끝날때까지 대기한다.   
   LOOP   
      IF /*lea_bat_pkg.*/ c_use_scheduler   
      THEN   --###### SCHEDULER 사용시   
         --## SCHEDULER 사용시   
         SELECT COUNT (1)   
           INTO v_cnt   
           FROM user_scheduler_jobs   
          WHERE job_action LIKE c_iter_prc_nm || '%';   
      ELSE   --###### JOB QUEUE 사용시   
         SELECT COUNT (1)   
           INTO v_cnt   
           FROM user_jobs   
          WHERE what LIKE c_iter_prc_nm || '%';   
      END IF;   
   
      IF v_cnt = 0   
      THEN   
         EXIT;   
      END IF;   
   
      DBMS_LOCK.sleep (c_mon_cycle);   
   END LOOP;   
   
   lea_log_prc ('MPPG_PRT_LVL 4 : JOB END');   
   APP_DEBUG.LOG_ELAPSED_TIME('LEA_ACT_MAPG_PRT_PRC:LVL_4 완료') ; -- 시간 측정을 위한 디버깅 코드   
      
   -- 작업이 모두 정상적으로 끝났는지 조회한다.   
   SELECT NVL (SUM (DECODE (par_prt_sts_cd, 'N', 1, 0)), 0) not_started,   
          NVL (SUM (DECODE (par_prt_sts_cd, 'R', 1, 0)), 0) running,   
          NVL (SUM (DECODE (par_prt_sts_cd, 'Y', 1, 0)), 0) finished,   
          NVL (SUM (DECODE (par_prt_sts_cd, 'F', 1, 0)), 0) failed   
     INTO v_initial,   
          v_running,   
          v_finished,   
          v_failed   
     FROM lea_bat_par_prt;   
   
   --dbms_output.put_line(NULL) ;   
   IF v_initial > 0   
   THEN   
      lea_log_prc ('수행되지 않은 Level 4 매핑 작업이 있습니다.');   
      COMMIT;   
      RETURN;   
   ELSIF v_running > 0   
   THEN   
      lea_log_prc ('Level 4 매핑 작업이 현재 수행중입니다.');   
      COMMIT;   
      RETURN;   
   ELSIF v_failed > 0   
   THEN   
      lea_log_prc ('실패한 Level 4 매핑 작업이 있습니다.');   
      COMMIT;   
      RETURN;   
   ELSIF v_finished = 0   
   THEN   
      lea_log_prc ('Level 4 매핑 작업이 하나도 수행되지 않았습니다.');   
      COMMIT;   
      RETURN;   
   ELSE   
      lea_log_prc ('Level 4 매핑 정상적으로 종료되었습니다.');   
   END IF;   
      

   --Batch History Record setting   
      
   --Mapping, Allocate Count of Actual Cost   
    SELECT SUM (modi_row_knt)   
    INTO   v_bat_his_rec.mapg_aloc_knt   
      FROM lea_bat_par_prt   
     WHERE prc_nm = 'LEA_ACT_COST_MAPG_PRC'   
     ;   
      
   v_bat_his_rec.exe_yrmon := exe_yrmon_in;   
   v_bat_his_rec.bat_id := bat_id_in;   
   v_bat_his_rec.mapg_aloc_end_dt := SYSDATE;   --Estimate data insert end date   
   v_rtn_val := lea_accl_bat_his_fnc (v_bat_his_rec, 'MA');   --Batch History Update Actual Cost Mapping, Allocate(PART)   
   lea_log_prc ('lea_act_mapg_prt_prc() End.');   
      
/* Exception -----------------------------------------------------------------*/   
   EXCEPTION   
   WHEN OTHERS   
   THEN   
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);     
         
END;