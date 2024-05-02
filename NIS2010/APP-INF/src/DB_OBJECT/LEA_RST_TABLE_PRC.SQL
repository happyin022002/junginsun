CREATE OR REPLACE PROCEDURE LEAADM.LEA_RST_TABLE_PRC (exe_yrmon_in IN VARCHAR, bat_id_in IN VARCHAR)
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
*******************************************************************************
//* Variable Declare --------------------------------------------------------*/
   c_use_scheduler       CONSTANT BOOLEAN      := TRUE; 
   c_mon_cycle           CONSTANT BINARY_INTEGER          := 1;   -- 1초 주기로 모니터링
   c_tbl_nm              CONSTANT VARCHAR2(30) := 'LEA_ACCL_DTL' ;
   v_partition_cnt       BINARY_INTEGER ;
   v_repeat_knt          NUMBER          := 0;   --동일수행년월의 반복 배치 작업 여부
   v_lst_cfm_exe_yrmon   VARCHAR2 (6);
   v_bkup_tbl_nm         VARCHAR2(30) ;
   v_cnt                 NUMBER ;
   v_action              VARCHAR2 (3000);
   v_jobid               NUMBER ;
   NEW_LINE              CONSTANT VARCHAR2 (3) := CHR (10);
BEGIN

   DBMS_APPLICATION_INFO.SET_MODULE('LEA_RST_TABLE_PRC('||exe_yrmon_in||')', 'Initializing'); 
   
   lea_log_prc ('lea_rst_table_prc() start.');

   v_bkup_tbl_nm := c_tbl_nm || '_BKUP_' || exe_yrmon_in ;

   -- 해당 수행년월의 백업 테이블이 존재하는지 체크한다.
   -- 백업 테이블이 없다면 진행하지 않는다.
   SELECT COUNT (1)
     INTO v_cnt
     FROM user_tables
    WHERE table_name = v_bkup_tbl_nm ;

   IF v_cnt < 1 THEN
     lea_log_prc ('백업 테이블('||v_bkup_tbl_nm||')이 없습니다.');
	 RETURN ;
   END IF ;

   lea_bkup_pkg.backup_table_indexes_prc     (c_tbl_nm) ;     -- 1. Backup Table Indexes
   lea_bkup_pkg.disable_table_constraints_prc(c_tbl_nm) ;     -- 2. Disable table constraints
   lea_bkup_pkg.drop_table_indexes_prc       (c_tbl_nm) ;     -- 3. Drop table indexes
   
   EXECUTE IMMEDIATE 'TRUNCATE TABLE '||c_tbl_nm ;            -- 4. DTL 테이블을 TRUNCATE한다.
   EXECUTE IMMEDIATE 'ALTER TABLE '||c_tbl_nm || ' NOLOGGING'; -- 5. 테이블을 NOLOGGING 으로 설정한다.

   -- 백업 테이블을 변경하지 못하도록 LOCK 한다
   v_action := 'LOCK TABLE ' || v_bkup_tbl_nm || ' IN SHARE MODE NOWAIT' ;
   EXECUTE IMMEDIATE v_action ;

   lea_log_prc ('Lock Table '||v_bkup_tbl_nm);
   
   -- 백업 테이블은 정렬되어 있으며, 정렬 순서를 지켜야 하므로 PARALLEL 을 사용할 수 없음
   -- 파티션 갯수와 동일한 SCHEDULER를 실행하여 PARTITION 별로 CONCURRENT 하게 복사
   FOR  C IN (SELECT ROWNUM RN, PARTITION_NAME 
                FROM USER_TAB_PARTITIONS A 
               WHERE TABLE_NAME = c_tbl_nm ORDER BY PARTITION_POSITION)
   LOOP
       v_action := 'BEGIN /* RESTORE */' || NEW_LINE || 
                   'INSERT /*+ APPEND NOLOGGING */ INTO ' || c_tbl_nm || ' PARTITION(' || C.PARTITION_NAME || ')' || NEW_LINE || 
                   'SELECT * FROM ' || v_bkup_tbl_nm || ' PARTITION(' || C.PARTITION_NAME || ') ;' || NEW_LINE || 
                   'COMMIT;' || NEW_LINE || 
                   'END;' ;
      DBMS_OUTPUT.PUT_LINE(v_action || NEW_LINE) ;
      
      DBMS_APPLICATION_INFO.SET_ACTION(c_tbl_nm || ' PARTITION(' || C.PARTITION_NAME || ')');
      
      IF c_use_scheduler
      THEN   --###### SCHEDULER 사용시
         DBMS_SCHEDULER.create_job (job_name        => 'DTL_RSTR_' || exe_yrmon_in || '_' || c.PARTITION_NAME,
                                    job_type        => 'PLSQL_BLOCK',
                                    job_action      => v_action,
                                    enabled         => TRUE,   -- 등록즉시 수행
                                    comments        => c_tbl_nm || ' 파티션 ' || c.PARTITION_NAME || ' 백업'
                                   );
      ELSE   --###### JOB QUEUE 사용시
         DBMS_JOB.submit (v_jobid, v_action);
      END IF;
   END LOOP ;
   
   lea_log_prc ('Register Schedule');
      
   -- 모든 스케줄러 Job 이 끝날때까지 대기한다.
   LOOP
      IF c_use_scheduler
      THEN   --###### SCHEDULER 사용시
         --## SCHEDULER 사용시
         SELECT COUNT (1)
           INTO v_cnt
           FROM user_scheduler_jobs 
           WHERE job_action LIKE 'BEGIN /* RESTORE */%';
      ELSE   --###### JOB QUEUE 사용시
         SELECT COUNT (1)
           INTO v_cnt
           FROM user_jobs
           WHERE what LIKE 'BEGIN /* RESTORE */%';
      END IF;

      IF v_cnt = 0
      THEN
         EXIT;
      END IF;

      DBMS_LOCK.sleep (c_mon_cycle);
   END LOOP;
   
   COMMIT ; -- 백업 테이블에 걸었던 LOCK을 해제한다.

   lea_log_prc ('Schedule Job finished');
   
   EXECUTE IMMEDIATE 'ALTER TABLE '||c_tbl_nm || ' LOGGING'; -- 7. 테이블을 LOGGING 으로 복구한다.

   lea_bkup_pkg.restore_table_indexes_prc   (c_tbl_nm) ;     -- 8. Restore Table Indexes
   lea_bkup_pkg.enable_table_constraints_prc(c_tbl_nm) ;     -- 9. Enable table constraints

   lea_log_prc ('lea_rst_table_prc() end.');
--   APP_DEBUG.LOG_ELAPSED_TIME('lea_init_table_prc 완료') ; -- 시간 측정을 위한 디버깅 코드
   
/* Exception -----------------------------------------------------------------*/
EXCEPTION
   WHEN OTHERS
   THEN
      raise_application_error (-20000, SQLERRM || CHR (10) || DBMS_UTILITY.format_error_backtrace);
END;