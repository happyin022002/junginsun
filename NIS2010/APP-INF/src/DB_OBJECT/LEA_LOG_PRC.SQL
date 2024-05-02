CREATE OR REPLACE PROCEDURE LEAADM.LEA_LOG_PRC (bat_log_in IN VARCHAR2)
IS
/*******************************************************************************
  1.Name       : 김상모
  2.Create Date: 2007-02-02
  3.Description:
      - 용도: Busincess Logic Check
      - 파라미터: Log Message(bat_log_in)
      - 특이사항
        (1) Autonomous transactions 은 transaction logging and retry counters
            같이 main transaction 처리와 별개로 transaction이 필요할 때 유용하다.
        (2) OWA_UTIL.who_called_me Using
  4.Revision History
    2007-02-02:김상모
*******************************************************************************/
   PRAGMA AUTONOMOUS_TRANSACTION;   -- COMMIT Control
   
   v_bat_log_seq   lea_bat_log.bat_log_seq%TYPE;
   /* owa_util.who_called_me -------------------------------------------------*/
   v_owner         VARCHAR2 (100);
   v_pname         VARCHAR2 (100);   -- Called Procedure, Function name
   v_lineno        VARCHAR2 (100);
   v_caller_t      VARCHAR2 (100);
   /*-------------------------------------------------------------------------*/
BEGIN

   BEGIN
      /* Get who called me Procedure or Function(Object) Name */
      OWA_UTIL.who_called_me (v_owner, v_pname, v_lineno, v_caller_t);

--      SELECT /*+ INDEX_DESC(LEA_BAT_LOG XPKLEA_BAT_LOG) */
--             bat_log_seq + 1 --Next Sequence
--        INTO v_bat_log_seq
--        FROM lea_bat_log
--       WHERE cre_tms BETWEEN TRUNC (SYSDATE) AND TRUNC (SYSDATE) + 0.99999421 AND ROWNUM = 1;
--   EXCEPTION
--      WHEN OTHERS
--      THEN
--         v_bat_log_seq := 1;
   END;

--   INSERT INTO lea_bat_log
--        VALUES (systimestamp, v_bat_log_seq, v_pname, bat_log_in);

   INSERT INTO lea_bat_log
        VALUES (systimestamp, LEA_BAT_LOG_SEQ.nextval, v_pname, bat_log_in);

   COMMIT;
   
/* Exception -----------------------------------------------------------------*/
   EXCEPTION
   WHEN OTHERS
   THEN
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);
      
END;


/*
site: http://download-west.oracle.com/docs/cd/B19306_01/appdev.102/b14258/w_util.htm

WHO_CALLED_ME Procedure
This procedure returns information (in the form of output parameters) about the PL/SQL code unit that invoked it.

Syntax

OWA_UTIL.WHO_CALLED_ME(
   owner          OUT      VARCHAR2,
   name           OUT      VARCHAR2,
   lineno         OUT      NUMBER,
   caller_t       OUT      VARCHAR2);
Parameters

Table 148-15 WHO_CALLED_ME Procedure Parameters

Parameter Description
owner The owner of the program unit.
name The name of the program unit. This is the name of the package, if the calling program unit is wrapped in a package, or the name of the procedure or function if the calling program unit is a standalone procedure or function. If the calling program unit is part of an anonymous block, this is NULL.
lineno The line number within the program unit where the call was made.
caller_t The type of program unit that made the call. The possibilities are: package body, anonymous block, procedure, and function. Procedure and function are only for standalone procedures and functions.
*/


--   f_id   UTL_FILE.file_type;   --Utility File
--BEGIN
--   /* Utility File Open */
--   f_id := UTL_FILE.fopen ('PLSQL_LOG', 'lea_batch_prc.log', 'a');
--   --UTL_FILE.put_line (p_fileid, TO_CHAR (SYSDATE, '[yyyy/mm/dd hh24:mi:ss]') || p_log);
--   UTL_FILE.put_line (f_id, TO_CHAR (SYSTIMESTAMP, '[yyyy/mm/dd hh24:mi:ssxff] ') || p_log);
--   /* Utility File Close */
--   UTL_FILE.fclose (f_id);
--/* Exception -----------------------------------------------------------------*/
--EXCEPTION
--   WHEN UTL_FILE.invalid_path
--   THEN
--      DBMS_OUTPUT.put_line ('UTL_FILE.INVALID_PATH');
--      UTL_FILE.fclose (f_id);
--   WHEN UTL_FILE.read_error
--   THEN
--      DBMS_OUTPUT.put_line ('UTL_FILE.READ_ERROR');
--      UTL_FILE.fclose (f_id);
--   WHEN UTL_FILE.write_error
--   THEN
--      DBMS_OUTPUT.put_line ('UTL_FILE.WRITE_ERROR');
--      UTL_FILE.fclose (f_id);
--   WHEN OTHERS
--   THEN
--      DBMS_OUTPUT.put_line ('other stuff');
--      UTL_FILE.fclose (f_id);
--END;