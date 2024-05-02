CREATE OR REPLACE PROCEDURE LEAADM.LEA_SEND_EMAIL_PRC (pi_exe_yrmon IN VARCHAR2)
IS
/*******************************************************************************
  1.Name       : 박연진
  2.Create Date: 2007-02-02
  3.Description:
      - 용도: e-NIS 화물변동비 추정결산을 위한 월간 배치프로그램
              종료를 셋팅된 사용자들에게 e-Mail 로 전송
      - 파라미터: 실행수행년월(p_exeyrmon(Format:'YYYYMM'))
      - 특이사항
        (1) 월간 배치프로그램 정상처리시(lea_bat_main_prc)
        (2) e-Mail setting을 테이블 데이터로 관리
  4.Revision History
    2007-02-02:박연진:최초생성.
*******************************************************************************/

   /* Variable Declare -------------------------------------------------------*/
   --mail_conn       UTL_SMTP.connection;
   v_to_eml        VARCHAR2 (200);
   v_cc_eml        VARCHAR2 (200);
   v_mailhost      VARCHAR2 (200);
   n_mailport      NUMBER;
   v_from_eml      VARCHAR2 (200);
   v_temp_to_eml   VARCHAR2 (200);
   v_subj_nm       VARCHAR2 (500);
   v_contents      VARCHAR2 (4000);
   i_sub_length    INTEGER   := 0;

   CURSOR get_mailsetvalues
   IS
      SELECT a.eml_svr_ip, a.port_no, a.fm_eml, a.to_eml, a.cc_eml,
             REPLACE (a.subj_nm, '$EXE_YRMON', b.exe_yrmon) subj_nm,
             REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (a.ctnt, '$EXE_YRMON', b.exe_yrmon), '$ST_TM', b.bat_st_dt),
                                                 '$END_TM', b.bat_end_dt), '$WRK_FLAG', bat_cmpl_flg),
                               '$TO', a.to_eml), '$FROM', fm_eml) ctnt
        FROM (SELECT eml_svr_ip, port_no, bat_fm_eml fm_eml, bat_to_eml to_eml, bat_cc_eml cc_eml,
                     bat_subj_nm subj_nm, bat_ctnt ctnt
                FROM lea_eml_set a
               WHERE pgm_sub_sys_cd = 'LEA') a,
             (SELECT exe_yrmon, TO_CHAR (bat_st_dt, 'YYYY/MM/DD HH24:MI:SS') bat_st_dt,
                     TO_CHAR (bat_end_dt, 'YYYY/MM/DD HH24:MI:SS') bat_end_dt,
                     DECODE (bat_cmpl_flg, 'Y', 'Success', 'Fail') bat_cmpl_flg
                FROM lea_accl_bat_his a
               WHERE bat_id =
                        (SELECT MAX (a.bat_id)
                           FROM lea_accl_bat_his a, lea_accl_cond_itm b
                          WHERE a.exe_yrmon = b.exe_yrmon
                            AND b.cond_cfm_flg = 'Y'
                            AND a.exe_yrmon = REPLACE (pi_exe_yrmon, '-'))) b;
BEGIN
   OPEN get_mailsetvalues;

   FETCH get_mailsetvalues
    INTO v_mailhost, n_mailport, v_from_eml, v_to_eml, v_cc_eml, v_subj_nm, v_contents;

   IF get_mailsetvalues%NOTFOUND
   THEN
      CLOSE get_mailsetvalues;
      lea_sys_email_prc('lea_send_email_prc data not found', 'Not found data in LEA_EML_SET, '||to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS')) ;
   ELSE   
     UTL_MAIL.SEND(sender => v_from_eml,
                   recipients => v_to_eml,
                   cc => v_cc_eml,
                   --bcc => 'smkim@cyberlogitec.com',
                   subject => v_subj_nm,
                   message => v_contents,
                   mime_type   => 'text/plain; charset=UTF-8');
      CLOSE get_mailsetvalues;                   
   END IF;
                    


   /* log...
   lea_log_prc ('v_mailhost : ' || v_mailhost || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
   lea_log_prc ('n_mailport : ' || n_mailport || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
   lea_log_prc ('v_from_eml : ' || v_from_eml || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
   lea_log_prc ('v_to_eml   : ' || v_to_eml || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
   lea_log_prc ('v_cc_eml   : ' || v_cc_eml || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
   lea_log_prc ('v_subj_nm  : ' || v_subj_nm || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
   lea_log_prc ('v_contents : ' || v_contents || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
   */
      
--   v_temp_to_eml := v_to_eml;
--   mail_conn := UTL_SMTP.open_connection (v_mailhost, n_mailport);
--   UTL_SMTP.helo (mail_conn, v_mailhost);
--   UTL_SMTP.mail (mail_conn, v_from_eml);

--   WHILE LENGTH (v_temp_to_eml) > 0
--   LOOP
--      i_sub_length := INSTR (v_temp_to_eml, ';');

--      IF i_sub_length > 0
--      THEN
--         v_to_eml := SUBSTR (v_temp_to_eml, 0, i_sub_length - 1);
--         v_temp_to_eml := SUBSTR (v_temp_to_eml, i_sub_length + 1);
--      ELSE
--         v_to_eml := v_temp_to_eml;
--         v_temp_to_eml := '';
--      END IF;

--      UTL_SMTP.rcpt (mail_conn, 'to:' || v_to_eml);
--   END LOOP;

--   i_sub_length := 0;
--   v_temp_to_eml := v_cc_eml;

--   WHILE LENGTH (v_temp_to_eml) > 0
--   LOOP
--      i_sub_length := INSTR (v_temp_to_eml, ';');

--      IF i_sub_length > 0
--      THEN
--         v_cc_eml := SUBSTR (v_temp_to_eml, 0, i_sub_length - 1);
--         v_temp_to_eml := SUBSTR (v_temp_to_eml, i_sub_length + 1);
--      ELSE
--         v_cc_eml := v_temp_to_eml;
--         v_temp_to_eml := '';
--      END IF;

--      UTL_SMTP.rcpt (mail_conn, 'cc:' || v_cc_eml);
--   END LOOP;

--   UTL_SMTP.open_data (mail_conn);

--   UTL_SMTP.write_raw_data (mail_conn, UTL_RAW.cast_to_raw ('Date'|| ': '|| TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss')|| UTL_TCP.crlf));
--   UTL_SMTP.write_raw_data (mail_conn, UTL_RAW.cast_to_raw ('From' || ': ' || v_from_eml || UTL_TCP.crlf));
--   UTL_SMTP.write_raw_data (mail_conn, UTL_RAW.cast_to_raw ('To' || ': ' || v_to_eml || UTL_TCP.crlf));
--   UTL_SMTP.write_raw_data (mail_conn, UTL_RAW.cast_to_raw ('Cc' || ': ' || v_cc_eml || UTL_TCP.crlf));
--   UTL_SMTP.write_raw_data (mail_conn, UTL_RAW.cast_to_raw ('Subject' || ': ' || v_subj_nm || UTL_TCP.crlf));
--   UTL_SMTP.write_raw_data (mail_conn, UTL_RAW.cast_to_raw (UTL_TCP.crlf));
--   UTL_SMTP.write_raw_data (mail_conn, UTL_RAW.cast_to_raw ('Contents' || ': ' || v_contents));

--   UTL_SMTP.close_data (mail_conn);
--   UTL_SMTP.quit (mail_conn);


--                      
--   lea_log_prc ('[LEA_SEND_EMAIL_PRC] : success!!   : '|| TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
--   
--EXCEPTION
--   WHEN UTL_SMTP.transient_error OR UTL_SMTP.permanent_error
--   THEN
--      BEGIN
--         UTL_SMTP.quit (mail_conn);
--      EXCEPTION
--         WHEN UTL_SMTP.transient_error OR UTL_SMTP.permanent_error
--         THEN
--            NULL;
--      END;

--      DBMS_OUTPUT.put_line ('[LEA_SEND_EMAIL_PRC] : Error!! '|| SQLERRM || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
--      lea_log_prc ('[LEA_SEND_EMAIL_PRC] : Error!! ' || SQLERRM || ', ' || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss'));
   /* Exception -----------------------------------------------------------------*/
   EXCEPTION
   WHEN OTHERS
   THEN
      raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE); 
            
END lea_send_email_prc;