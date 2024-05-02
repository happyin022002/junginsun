CREATE OR REPLACE PROCEDURE LEAADM.LEA_BAT_START_PRC(exe_yrmon_in IN VARCHAR2, msg_out OUT VARCHAR2)
IS
/*******************************************************************************
  1.Name       : 김상모
  2.Create Date: 2007-02-02
  3.Description:
      - 용도: e-NIS 화물변동비 추정결산 배치 Start를 위한 Procedure(Async방식)
      - 파라미터: 실행수행년월(exe_yrmon_in('YYYYMM'), msg_out(return to UI))
      - 특이사항
        (1) 유저가 매월초 추정 전제조건을 확인하고 배치프로그램을 실행(호출)
        (2) 장시간 비동기 배치프로그램 호출을 위해 Oracle의 Scheduler or Job에 등록하고 빠짐(Async방식)
            => 웹 특성상 프로그램 호출 후 짧은 시간에 응답이 나와야 됨, 웹 서버에 장시간 부하를 주면 안됨
        (3) 배치로직 흐름별 Logging과 e-Mail 전송을 통해 시스템 담당자와 배치실행 유저에게 결과를 통보
        (4) 로그를 Table(LEA_BAT_LOG)에 Insert 처리함(lea_log_prc('Strings'); 사용)
  4.Revision History
    2007-02-02:김상모:최초생성.
    2009-01-05:LEA_BAT_MAIN_PRC => LEA_BAT_MAIN_PRE_PRC 로 변경
               lea_bat_cond_chk_prc 실행 부분 주석처리
               
*******************************************************************************/
    c_Use_Scheduler CONSTANT BOOLEAN := False ; -- 패키지 lea_bat_pkg의 변수로 빼는게 좋겠다...
    v_jobid BINARY_INTEGER ;
    v_Action varchar2(100) ;

BEGIN
    /* Batch Start log */
    lea_log_prc (' ');   --New Line
    lea_log_prc ('---------------------------------------------------------------------------');
    lea_log_prc ('LEA Batch Start! Execute Year Month:' || exe_yrmon_in);
    
    -- 작업 수행을 위한 사전 준비가 되어 있는지 체크한다.
    -- LEA_BAT_MAIN_PRE_PRC 실행으로 주석처리함. (AP 마감되기 전 실행)
--    BEGIN
--   
--        -- 수 초 이내에 완료 가능한 만큼만 시간을 사용하도록 하십시요.
--        /* Batch Condition Item Confirm Check Processing... -----------------------*/
--        lea_bat_cond_chk_prc (exe_yrmon_in, msg_out);
--        
--        IF Length(msg_out) > 0 THEN --전제조건을 체크하는 에러(메세지)가 존재하면 종료
--            lea_log_prc('종료... '|| msg_out);
--            RETURN; --호출한 쪽(UI)으로 메세지를 넘김(msg_out OUT)
--        END IF;
--        
--        lea_log_prc('Condition Check...OK!!!');
--        
--    EXCEPTION
--        WHEN OTHERS THEN
--            msg_out := '이러저러한 이유로 작업을 시작할 수 없습니다.' ;
--            RETURN ;
--    END ;
    
    -- JOB 등록하고 즉시 빠짐
    -- INTERVAL 값을 주지 않으면 등록하고 COMMIT 즉시 실행되며
    -- 완료 후에는 자동 삭제됨
    v_Action := 'LEA_BAT_MAIN_PRE_PRC(''' || exe_yrmon_in || ''');' ;
    dbms_output.put_line('ACTION:'||v_Action) ;
    IF /*lea_bat_pkg.*/c_Use_Scheduler THEN --###### SCHEDULER 사용시
        BEGIN
            DBMS_SCHEDULER.CREATE_JOB (
                   job_name   => 'LEA_BAT_'||exe_yrmon_in,
                   job_type   => 'PLSQL_BLOCK',
                   job_action => v_Action,
                   enabled    => TRUE,  -- 등록즉시 수행
                   comments   => '화물변동비 추정결산 배치 프로그램');
        EXCEPTION
            WHEN OTHERS THEN
                IF SQLCODE = -27477 THEN
--                    ORA-27477: "LEAADM.LEA_BAT_200703"이(가) 존재함
--                    ORA-06512: "SYS.DBMS_ISCHED", 줄 99에서
--                    ORA-06512: "SYS.DBMS_SCHEDULER", 줄 262에서
--                    ORA-06512: "LEAADM.LEA_ACCL_START_PRC", 줄 31에서
--                    ORA-06512: 줄 1에서
                    msg_out := 'Batch is already running.' ; --'배치 작업이 이미 수행중입니다.'
                    RETURN ;
                END IF ;
        END ;
    ELSE                    --###### JOB QUEUE 사용시
        DBMS_JOB.SUBMIT(v_jobid, v_Action) ;
        DBMS_OUTPUT.PUT_LINE('JOB_ID : ' || v_jobid) ;
    END IF ;
    COMMIT ;
    
    msg_out := 'Batch started.'; --'작업이 시작되었습니다.'
END ;