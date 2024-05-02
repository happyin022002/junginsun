CREATE OR REPLACE PROCEDURE OPUSADM."COA_COST_ASSIGN_PRE_PRC" (   
  IN_NEW_CD        IN VARCHAR2 DEFAULT 'N' 
 ,IN_LOG_LVL       IN VARCHAR2 DEFAULT '9'   
)   
AUTHID CURRENT_USER   
IS 
/******************************************************************************   
    Name         :   COA_COST_ASSIGN_PRE_PRC   
    Purpose      :   COA의 배치 스케줄러에 의해 수행되는 비용계산 사전작업   
                     (각 시스템의 IF를 COA의 비용계산용 테이블로 옮기기)   
    Source       :   COA_BKG_COM_IF   
    Target       :   COA_BKG_COST_CALC   
       
    주의 사항    :   v_bsc_prc_cnt_min조절시 자바소스의 BASIC_PRECESSING_COUNT_PER_MINUTE값도 동시에 바꾸어야 함.   
******************************************************************************/   
 
   
   ------------------------------[ 변수선언부             ]-----------------------   
   v_cnt              NUMBER (18)    := 0;   
   v_step             VARCHAR2 (100);   
   v_log_mod_nm       VARCHAR2 (30)  := 'COA_COST_ASSIGN_PRE_PRC';   
   v_start_date       DATE;-- VARCHAR(15); -- IF 시작기준일시   
   v_end_date         DATE;-- VARCHAR(15); -- IF 종료기준일시   
   v_sysdate          DATE := SYSDATE;-- 현재시간   
   v_user_id          VARCHAR(20)  := 'SYS_SCHEDULER';   
      
--	//상수정의, 일단 변수로 구현하고 나중에 DB에 넣고 변경 가능하도록 할것.   
--	int CALCULATION_COPY_TERM  = 5;                //연관 데이터 변경작업이 일어날 최대시간    
--	int TIME_PERIOD  = 1;                          //시간대 1:8시-18시, 2:18시-24시, 3:0시-8시   
--	int BASIC_PRECESSING_COUNT_PER_MINUTE = 12;    //분당 처리 건수   
--	int THREAD_EXECUTION_COUNT    = 5 * TIME_PERIOD; //한번에 수행될 수 있는 THREAD수   
--	int MAXIMUM_PROCESSING_COUNT  = BASIC_PRECESSING_COUNT_PER_MINUTE * THREAD_EXECUTION_COUNT;//시스템에서 최대한 PROCESSING하는 수   
   v_calc_cp_term NUMBER(3); -- 상황에 따라 바꾸어줄 부분       
   v_tm_period NUMBER(1);                          
   v_bsc_prc_cnt_min NUMBER(3); --12 상황에 따라 바꾸어줄 부분, 자바소스에도 있음 양쪽다 바꾸어야 함    
   v_thread_exe_cnt NUMBER(3);  
   v_max_prc_cnt NUMBER(5);  
   v_cnt_no NUMBER(3);   
      
-------------------------------[ 업무로직 구현부       ]-----------------------   
BEGIN   
      
   enis_log_prc ('', v_log_mod_nm, TO_CHAR(v_sysdate) ||' Start');   
   
   --////////////////////////////////////////////////////////////////////////////////////////////   
   -- 1.기준 정보 설정   
   --////////////////////////////////////////////////////////////////////////////////////////////   
   v_step := '1.기준 정보 설정';   
   
    SELECT MAX(DECODE(BKG_NO, 'CALC_CP_TERM', COA_BAT_SEQ)) CALC_CP_TERM
          ,MAX(DECODE(BKG_NO, 'TIME_PERIOD', COA_BAT_SEQ)) TIME_PERIOD
          ,MAX(DECODE(BKG_NO, 'PRC_CNT_MIN', COA_BAT_SEQ)) PRC_CNT_MIN
      INTO v_calc_cp_term, v_tm_period, v_bsc_prc_cnt_min
      FROM COA_BKG_COST_CALC
     WHERE BKG_NO IN ('CALC_CP_TERM','TIME_PERIOD','PRC_CNT_MIN');
    
    IF v_calc_cp_term = '' THEN
        v_calc_cp_term    := 3; -- 상황에 따라 바꾸어줄 부분 
        v_tm_period       := 1;
        v_bsc_prc_cnt_min := 40;--12 상황에 따라 바꾸어줄 부분, 자바소스에도 있음 양쪽다 바꾸어야 함 
    END IF;
    
   -- v_start_date,  v_end_date 설정
    SELECT IF_DT   
           ,SYSDATE - V_CALC_CP_TERM / (24 * 60)         -- 현재 시간에서  v_calc_cp_term이전   
    INTO v_start_date   
        ,v_end_date   
    FROM   COA_BKG_COM_IF    
    WHERE  BKG_NO = 'LASTCOPYTIME'    
           AND COST_SRC_SYS_CD = 'COA';    
   
   IF TO_CHAR(v_start_date, 'HH24') IN ('18', '19', '20', '21', '22', '23') THEN   
        v_tm_period := 2;   
   ELSIF TO_CHAR(v_start_date, 'HH24') IN ('24', '01', '02', '03', '04', '05', '06', '07') THEN   
        v_tm_period := 3;   
   END IF;   
      
   v_thread_exe_cnt := 5 * v_tm_period; -- 동시수행배치갯수= 5*시간대상수(1,2,3)   
   v_max_prc_cnt := v_bsc_prc_cnt_min * v_thread_exe_cnt; -- 최대BKG건수 = 분당처리건수* 동시수행배치갯수   
      
   IF (in_log_lvl <= '3') THEN   
      enis_log_prc ('', v_log_mod_nm, v_step 
                          || '  v_start_date='      || TO_CHAR(v_start_date, 'YYYYMMDD HH24MISS')    
                          || ', v_end_date='        || TO_CHAR(v_end_date, 'YYYYMMDD HH24MISS')     
                          || ', v_tm_period='       || v_tm_period 
                          || ', v_calc_cp_term='    || v_calc_cp_term
                          || ', v_bsc_prc_cnt_min=' || v_bsc_prc_cnt_min
                   );   
   END IF;   
      
   --////////////////////////////////////////////////////////////////////////////////////////////   
   -- 2.LASTCOPYTIME UPDATE   
   --////////////////////////////////////////////////////////////////////////////////////////////   
   v_step := '2.LASTCOPYTIME UPDATE';   
      
   UPDATE COA_BKG_COM_IF    
   SET    IF_DT = v_end_date   
          ,UPD_DT = v_sysdate    
          ,UPD_USR_ID = v_user_id   
   WHERE  BKG_NO = 'LASTCOPYTIME'    
          AND COST_SRC_SYS_CD = 'COA' ;   
              
--   IF (in_log_lvl <= '3') THEN   
--      enis_log_prc ('', v_log_mod_nm, v_step || ' ' || SQL%ROWCOUNT || ' Update');   
--   END IF;   
      
   COMMIT; --다른 배치에서도 동시수행 가능하므로 바로 COMMIT 해준다   
      
   --////////////////////////////////////////////////////////////////////////////////////////////   
   -- 3.PROCESSING STATUS BKG 처리   
   --////////////////////////////////////////////////////////////////////////////////////////////   
   v_step := '3.PROCESSING STATUS BKG 처리';   
      
   -- 현재 배치상태가 'P'인 BKG은 다음번에 수행할 수 있도록 COA_BKG_COM_IF에 다시 넣는다   
    MERGE INTO COA_BKG_COM_IF B1    
    USING (SELECT A1.BKG_NO    
                  ,'COA'                   COST_SRC_SYS_CD    
                  ,v_end_date              IF_DT    
                  ,REPLACE(IF_RMK,'->PROCESSING STATUS','') ||'->PROCESSING STATUS' IF_RMK    
                  ,v_user_id UPD_USR_ID   
                  ,v_sysdate UPD_DT   
                  ,v_user_id CRE_USR_ID   
                  ,v_sysdate CRE_DT   
           FROM   COA_BKG_COST_CALC A1    
                  ,(SELECT BKG_NO    
                          ,IF_RMK    
                   FROM   (SELECT BKG_NO    
                                  ,IF_RMK    
                                  ,IF_DT    
                                  ,RANK() OVER(PARTITION BY BKG_NO ORDER BY DECODE(IF_RMK,'Booking Create', 0,'E-Booking Create',0, 1), IF_DT DESC) RANKING    
                           FROM   COA_BKG_COM_IF    
                           WHERE  IF_DT > V_START_DATE AND IF_DT <= V_END_DATE
                           )    
                   WHERE  RANKING = 1) A2    
           WHERE  A1.BKG_NO = A2.BKG_NO    
                  AND A1.COA_BAT_CD = 'P') B2    
    ON ( B1.BKG_NO = B2.BKG_NO AND B1.COST_SRC_SYS_CD = B2.COST_SRC_SYS_CD )    
    WHEN MATCHED THEN    
        UPDATE SET B1.IF_DT = B2.IF_DT, B1.IF_RMK = B2.IF_RMK, B1.UPD_USR_ID = B2.UPD_USR_ID, B1.UPD_DT = B2.UPD_DT    
    WHEN NOT MATCHED THEN    
        INSERT (B1.BKG_NO, B1.COST_SRC_SYS_CD, B1.IF_DT, B1.IF_RMK, B1.CRE_USR_ID, B1.CRE_DT, B1.UPD_USR_ID, B1.UPD_DT)    
        VALUES (B2.BKG_NO, B2.COST_SRC_SYS_CD, B2.IF_DT, B2.IF_RMK, B2.CRE_USR_ID, B2.CRE_DT, B2.UPD_USR_ID, B2.UPD_DT);    
      
--   IF (in_log_lvl <= '3') THEN   
--      enis_log_prc ('', v_log_mod_nm, v_step || ' ' || SQL%ROWCOUNT || ' Merge');   
--   END IF;   
         
   COMMIT; --다른 배치에서도 동시수행 가능하므로 바로 COMMIT 해준다   
   
   --////////////////////////////////////////////////////////////////////////////////////////////   
   -- 4.COA_BKG_COM_IF의 데이터 COA_BKG_COST_CALC로 COPY   
   --////////////////////////////////////////////////////////////////////////////////////////////   
   v_step := '4.COA_BKG_COM_IF의 데이터 COA_BKG_COST_CALC로 COPY';   
   
   MERGE INTO COA_BKG_COST_CALC B1   
   USING (   
        SELECT BKG_NO    
            , IF_DT   COA_BAT_DT
            , IF_RMK COA_BAT_RMK   
            , 'W' COA_BAT_CD   
            , 0 COA_BAT_SEQ   
            , 0 COA_MNL_BAT_SEQ   
            , v_user_id UPD_USR_ID   
            , DECODE(IF_RMK,'Booking Create', IF_DT,'E-Booking Create',IF_DT, v_sysdate) UPD_DT -- Booking Create는 우선순위를 높여주기 위해 IF_DT 사용   
            , v_user_id CRE_USR_ID   
            , DECODE(IF_RMK,'Booking Create', IF_DT,'E-Booking Create',IF_DT, v_sysdate) CRE_DT -- Booking Create는 우선순위를 높여주기 위해 IF_DT 사용   
        FROM   (SELECT BKG_NO    
                       ,IF_RMK   
                       ,IF_DT   
                       ,RANK() OVER(PARTITION BY BKG_NO ORDER BY DECODE(IF_RMK,'Booking Create', 0,'E-Booking Create',0, 1), IF_DT DESC,ROWNUM) RANKING    
                FROM   COA_BKG_COM_IF    
                WHERE  IF_DT > V_START_DATE AND IF_DT <= V_END_DATE
                )    
        WHERE  RANKING = 1) B2   
   ON (B1.BKG_NO = B2.BKG_NO)       
   WHEN MATCHED THEN    
       UPDATE 
          SET B1.COA_BAT_CD  = B2.COA_BAT_CD
             ,B1.COA_BAT_SEQ = B2.COA_BAT_SEQ
             ,B1.COA_BAT_DT = B2.COA_BAT_DT
             ,B1.COA_BAT_RMK = B2.COA_BAT_RMK
             ,B1.UPD_USR_ID = B2.UPD_USR_ID
             ,B1.UPD_DT = B2.UPD_DT              
   WHEN NOT MATCHED THEN   
       INSERT (B1.BKG_NO, B1.COA_BAT_CD, B1.COA_BAT_SEQ, B1.COA_BAT_DT, B1.COA_BAT_RMK, B1.COA_MNL_BAT_SEQ, B1.CRE_USR_ID, B1.CRE_DT, B1.UPD_USR_ID, B1.UPD_DT)   
       VALUES (B2.BKG_NO, B2.COA_BAT_CD, B2.COA_BAT_SEQ, B2.COA_BAT_DT, B2.COA_BAT_RMK, B2.COA_MNL_BAT_SEQ, B2.CRE_USR_ID, B2.CRE_DT, B2.UPD_USR_ID, B2.UPD_DT)   
   ;

--   IF (in_log_lvl <= '3') THEN   
--      enis_log_prc ('', v_log_mod_nm, v_step || ' ' || SQL%ROWCOUNT || ' Merge');   
--   END IF;   
          
   COMMIT; --다른 배치에서도 동시수행 가능하므로 바로 COMMIT 해준다   
      
   --////////////////////////////////////////////////////////////////////////////////////////////   
   -- 5.COA_BKG_COST_CALC 테이블의 'C', 'E'를 제외한 BKG 건수를 체크('N', 'P')   
   --////////////////////////////////////////////////////////////////////////////////////////////   
   v_step := '5.COA_BKG_COST_CALC 테이블의 C,E 상태 를 제외한 BKG 건수를 체크('||in_new_cd||',P)';   
   SELECT COUNT(* ) INTO v_cnt    
   FROM   COA_BKG_COST_CALC    
   WHERE  COA_BAT_CD IN (in_new_cd,'P');   
      
--   IF (in_log_lvl <= '3') THEN   
--      enis_log_prc ('', v_log_mod_nm, v_step || ' v_cnt = ' || v_cnt);   
--   END IF;   
      
   --////////////////////////////////////////////////////////////////////////////////////////////   
   -- 6. MAXIMUM PROCESSING COUNT 이하이면 한번에 수행할 갯수만큼 'W'->'N'으로 변경   
   --////////////////////////////////////////////////////////////////////////////////////////////   
   v_step := '6. MAXIMUM PROCESSING COUNT 이하이면 한번에 수행할 갯수만큼 W->N으로 변경';   
   IF (v_cnt < v_max_prc_cnt) THEN   
          
       UPDATE COA_BKG_COST_CALC    
       SET    COA_BAT_CD = in_new_cd    
       WHERE  BKG_NO IN (SELECT BKG_NO
                          FROM (
                                SELECT BKG_NO
                                      ,RANKING
                                      ,ROW_NUMBER() OVER(ORDER BY RANKING) NUM --update 날짜가 동일 할경우 한쪽으로 몰리는 현상을 방지하기 위해서
                                  FROM   (SELECT BKG_NO
                                                 ,RANK() OVER(ORDER BY DECODE(COA_BAT_RMK,'Booking Create', 0,'E-Booking Create',0, 1), UPD_DT,ROWNUM) RANKING
                                          FROM   COA_BKG_COST_CALC
                                          WHERE  COA_BAT_CD = 'W')
                               )
                         WHERE  NUM <= v_bsc_prc_cnt_min)   
       ;   
          
--       IF (in_log_lvl <= '3') THEN   
--          enis_log_prc ('', v_log_mod_nm, v_step || ' ' || SQL%ROWCOUNT || ' Update');   
--       END IF;   
          
       COMMIT;   
   END IF;   
      
   enis_log_prc ('', v_log_mod_nm, '[V.20100428] '|| TO_CHAR(v_sysdate) ||' End');   
EXCEPTION   
   WHEN OTHERS THEN   
      enis_log_prc ('', v_log_mod_nm, 'ERROR: ' || v_step || ' > ' || SQLERRM);   
      ROLLBACK;   
         
         
END COA_COST_ASSIGN_PRE_PRC;