CREATE OR REPLACE PROCEDURE LEAADM.LEA_BKUP_TABLE_PRC(tablespace_nm IN VARCHAR, exe_yrmon_in IN VARCHAR)
IS
/*******************************************************************************
  1.Name       : 김상모
  2.Create Date: 2007-03-02
  3.Description:
      - 용도: 추정결산 처리된 LEA_ACCL_DTL을 반복되는 수행년월인 경우 백업된 데이터 Restore 하기
      - 파라미터: 실행수행년월(in_exeyrmon(Format:'YYYYMM'))
      - 특이사항
        (1) lea_bkup_pkg 이용
  4.Revision History
    2007-03-02:김상모:최초생성.
    2008-06-12:전재홍:Backup Talbe 생성후 LEADEV 에 SELECT 권한 부여
*******************************************************************************
//* Variable Declare --------------------------------------------------------*/
   c_use_scheduler       CONSTANT BOOLEAN      := TRUE; 
   c_mon_cycle           CONSTANT BINARY_INTEGER          := 1;   -- 1초 주기로 모니터링
   c_tbl_nm              CONSTANT VARCHAR2(30) := 'LEA_ACCL_DTL' ;
   c_ConCurrMonth        CONSTANT BINARY_INTEGER          := 4;   --한번에 4개까지만 스케줄링 처리
   v_partition_cnt       BINARY_INTEGER ;

   v_bkup_tbl_nm         VARCHAR2(30) ;
   v_cnt                 NUMBER ;
   v_action              VARCHAR2 (3000);
   v_jobid               NUMBER ;
   NEW_LINE              CONSTANT VARCHAR2 (3) := CHR (10);
   start_tm              TIMESTAMP;
   idx                   BINARY_INTEGER := 0;
   
   v_stmt                VARCHAR2(4000) ;                
   
   CURSOR PartTBL_cur
   IS 
      SELECT ROWNUM RN, PARTITION_NAME 
      FROM USER_TAB_PARTITIONS A 
      WHERE TABLE_NAME = c_tbl_nm ORDER BY PARTITION_POSITION
   ;
   
   --Table of Record
   TYPE PartTBL_table_type IS TABLE OF USER_TAB_PARTITIONS%ROWTYPE
   INDEX BY BINARY_INTEGER;
   
   PartTBL_table PartTBL_table_type ;
   
BEGIN
   DBMS_APPLICATION_INFO.SET_MODULE('LEA_BKUP_TABLE_PRC('||tablespace_nm||','||exe_yrmon_in||')', 'Initializing');  
   
   lea_log_prc ('lea_bkup_table_prc() start.');
   start_tm := SYSTIMESTAMP; --작업시작 시간
   
   v_bkup_tbl_nm := c_tbl_nm || '_BKUP_' || exe_yrmon_in ;
   
   -- 해당 수행년월의 백업 테이블이 이미 만들어져 있는지 체크한다.
   -- 백업 테이블이 이미 존재한다면 진행하지 않는다.
   SELECT COUNT (1)
     INTO v_cnt
     FROM user_tables
    WHERE table_name = v_bkup_tbl_nm ;
   
   IF v_cnt >= 1 THEN
     lea_log_prc ('백업 테이블('||v_bkup_tbl_nm||')이 이미 존재하므로 다시 백업하지 않습니다.');
     lea_sys_email_prc('테이블('||v_bkup_tbl_nm||') 백업작업 오류', '백업 테이블('||v_bkup_tbl_nm||')이 이미 존재하므로 다시 백업하지 않습니다.'); --Subject, Contents
    RETURN ;
   END IF ;

   -- 백업 테이블을 생성한다.
   --v_action := LEA_BKUP_PKG.get_backup_table_ddl_fnc(c_tbl_nm, v_bkup_tbl_nm, '') ;
   v_action := LEA_BKUP_PKG.get_backup_table_ddl_fnc(c_tbl_nm, v_bkup_tbl_nm, tablespace_nm) ;
   
   EXECUTE IMMEDIATE v_action ;

   -- 원본 테이블을 변경하지 못하도록 LOCK 한다
   v_action := 'LOCK TABLE ' || c_tbl_nm || ' IN SHARE MODE NOWAIT' ;
   EXECUTE IMMEDIATE v_action ;
   
   
   FOR PartTBL_list IN ( SELECT ROWNUM RN, PARTITION_NAME 
                         FROM USER_TAB_PARTITIONS A 
                         WHERE TABLE_NAME = c_tbl_nm ORDER BY PARTITION_POSITION ) LOOP
      idx:= idx+1 ;
      
      PartTBL_table(idx).PARTITION_NAME := PartTBL_List.PARTITION_NAME;
                               
   END LOOP;
   
   idx := 1; --Init
   
   
   WHILE idx <= PartTBL_table.COUNT --COUNT()
   LOOP
  
      -- 스케줄러 Job 을 c_ConCurrMonth 갯수만 체크 후 추가 스케줄러 Add 처리를 위해 사용
      LOOP
         IF c_use_scheduler
         THEN   --###### SCHEDULER 사용시
            --## SCHEDULER 사용시
            SELECT COUNT (1)
              INTO v_cnt
              FROM user_scheduler_jobs 
              WHERE job_action LIKE 'BEGIN /* BACKUP */%';
         ELSE   --###### JOB QUEUE 사용시
            SELECT COUNT (1)
              INTO v_cnt
              FROM user_jobs
              WHERE what LIKE 'BEGIN /* BACKUP */%';
         END IF;

         IF v_cnt < c_ConCurrMonth
         THEN
            EXIT;
         END IF;

         DBMS_LOCK.sleep (c_mon_cycle);
      END LOOP;
  

      DBMS_APPLICATION_INFO.SET_ACTION(idx||','||PartTBL_table(idx).PARTITION_NAME);
      
      lea_log_prc(idx||','||PartTBL_table(idx).PARTITION_NAME);
      
       v_action := 'BEGIN /* BACKUP */' || NEW_LINE || 
                   'INSERT /*+ APPEND NOLOGGING */ INTO ' || v_bkup_tbl_nm || ' PARTITION(' || PartTBL_table(idx).PARTITION_NAME || ')' || NEW_LINE || 
                   'SELECT * FROM ' ||  c_tbl_nm || ' PARTITION(' || PartTBL_table(idx).PARTITION_NAME || ')' || NEW_LINE || 
                   'ORDER BY REV_YRMON,COA_COST_SRC_CD,N1ST_NOD_CD,' || NEW_LINE || 
                   '      VSL_CD,SKD_VOY_NO,SKD_DIR_CD,REV_DIR_CD,ACCL_CALC_FLG,BKG_STS_CD ;' || NEW_LINE || 
                   'COMMIT;' || NEW_LINE || 
                   'END;' ;
      
      DBMS_OUTPUT.PUT_LINE(v_action || NEW_LINE) ;
      IF c_use_scheduler
      THEN   --###### SCHEDULER 사용시
         DBMS_SCHEDULER.create_job (job_name        => 'DTL_BKUP_' || exe_yrmon_in || '_' || PartTBL_table(idx).PARTITION_NAME,
                                    job_type        => 'PLSQL_BLOCK',
                                    job_action      => v_action,
                                    enabled         => TRUE,   -- 등록즉시 수행
                                    comments        => c_tbl_nm || ' 파티션 ' || PartTBL_table(idx).PARTITION_NAME || ' 백업'
                                   );
      ELSE   --###### JOB QUEUE 사용시
         DBMS_JOB.submit (v_jobid, v_action);
      END IF;
      
      idx := idx+1 ;
  
   END LOOP;
   
   -- 모든 스케줄러 Job 이 끝날때까지 대기한다.
   LOOP
      IF c_use_scheduler
      THEN   --###### SCHEDULER 사용시
         --## SCHEDULER 사용시
         SELECT COUNT (1)
           INTO v_cnt
           FROM user_scheduler_jobs 
           WHERE job_action LIKE 'BEGIN /* BACKUP */%';
      ELSE   --###### JOB QUEUE 사용시
         SELECT COUNT (1)
           INTO v_cnt
           FROM user_jobs
           WHERE what LIKE 'BEGIN /* BACKUP */%';
      END IF;

      IF v_cnt = 0
      THEN
         EXIT;
      END IF;

      DBMS_LOCK.sleep (c_mon_cycle);
   END LOOP;   
    
   --LOCK을 해제한다.
   COMMIT ;
   
   v_stmt := 'GRANT SELECT ON '|| v_bkup_tbl_nm ||' TO lea_role';
   EXECUTE IMMEDIATE v_stmt ; 
   v_stmt :='';
   v_stmt := 'CREATE PUBLIC SYNONYM ' ||v_bkup_tbl_nm|| ' FOR '||v_bkup_tbl_nm;
   EXECUTE IMMEDIATE v_stmt ;
            
   lea_log_prc ('lea_bkup_table_prc() end.');
   
   lea_sys_email_prc(UPPER(c_tbl_nm)||'->'||UPPER(v_bkup_tbl_nm)||' 테이블 백업작업 성공', '시작:'||start_tm || NEW_LINE ||'종료:'|| SYSTIMESTAMP); --Subject, Contents
   
/* Exception -----------------------------------------------------------------*/
EXCEPTION
   WHEN OTHERS
   THEN
      lea_sys_email_prc(c_tbl_nm||'->'||UPPER(v_bkup_tbl_nm)||' 테이블 백업작업 오류', SQLERRM); --Subject, Contents
      raise_application_error (-20000, SQLERRM || CHR (10) || DBMS_UTILITY.format_error_backtrace);
END;