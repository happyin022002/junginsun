CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACCL_DTL_TBL_BKUP_ST_PRC(exe_yrmon_in IN VARCHAR2, msg_out OUT VARCHAR2) IS
    c_Use_Scheduler CONSTANT BOOLEAN := TRUE ; -- 패키지 lea_bat_pkg의 변수로 빼는게 좋겠다...
    v_jobid BINARY_INTEGER ;
    v_Action varchar2(100) ;
    
    v_tablespace_nm VARCHAR2(100) := 'TS_ACCL_D';
    v_src_table_nm VARCHAR2(30) := 'LEA_ACCL_DTL';
    v_bkup_table_nm VARCHAR2(30) := 'LEA_ACCL_DTL_'||exe_yrmon_in; --LEA_ACCL_DTL_200704


BEGIN
    /* Table backup Start log */
    lea_log_prc (' ');   --New Line
    lea_log_prc ('---------------------------------------------------------------------------');
    lea_log_prc ('LEA backup Table Start! Execute Year Month:' || exe_yrmon_in);
    
    -- JOB 등록하고 즉시 빠짐
    -- INTERVAL 값을 주지 않으면 등록하고 COMMIT 즉시 실행되며
    -- 완료 후에는 자동 삭제됨
    --v_Action := 'LEA_BKUP_PKG.BACKUP_TABLE_PRC(''' || v_tablespace_nm ||''','''||v_src_table_nm||''','''||v_bkup_table_nm||''');' ;
    v_Action := 'LEA_BKUP_TABLE_PRC(''' || v_tablespace_nm ||''',''' || exe_yrmon_in ||''');' ;
    
    lea_log_prc(v_Action);
    
    dbms_output.put_line('ACTION:'||v_Action) ;
    IF /*lea_bat_pkg.*/c_Use_Scheduler THEN --###### SCHEDULER 사용시
        BEGIN
            DBMS_SCHEDULER.CREATE_JOB (
                   job_name   => 'BACKUP_TABLE_'||exe_yrmon_in,
                   job_type   => 'PLSQL_BLOCK',
                   job_action => v_Action,
                   enabled    => TRUE,  -- 등록즉시 수행
                   comments   => '화물 변동비 추정 ' || v_src_table_nm || '대용량 테이블 백업');
        EXCEPTION
            WHEN OTHERS THEN
                        --lea_log_prc('Others SQLCODE:'||SQLCODE);
                IF SQLCODE = -27477 THEN
--                    ORA-27477: "LEAADM.LEA_BAT_200703"이(가) 존재함
--                    ORA-06512: "SYS.DBMS_ISCHED", 줄 99에서
--                    ORA-06512: "SYS.DBMS_SCHEDULER", 줄 262에서
--                    ORA-06512: "LEAADM.LEA_ACCL_START_PRC", 줄 31에서
--                    ORA-06512: 줄 1에서
                    --msg_out := '백업 작업이 이미 수행중입니다.' ;
                    msg_out := 'Backup batch is already running.' ;
                    RETURN ;
                END IF ;
        END ;
    ELSE                    --###### JOB QUEUE 사용시
        DBMS_JOB.SUBMIT(v_jobid, v_Action) ;
        DBMS_OUTPUT.PUT_LINE('JOB_ID : ' || v_jobid) ;
    END IF ;
    COMMIT ;
    
      
    --msg_out := '백업 작업이 시작되었습니다.' ;
    msg_out := 'Backup batch started.' ;
    
    lea_log_prc ('LEA backup Table Schedule started! Execute Year Month:' || exe_yrmon_in);
END ;