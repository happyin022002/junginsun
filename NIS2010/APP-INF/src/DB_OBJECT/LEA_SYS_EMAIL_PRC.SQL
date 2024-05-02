CREATE OR REPLACE PROCEDURE LEAADM.LEA_SYS_EMAIL_PRC(subj_nm_in VARCHAR2, contents_in VARCHAR2)
IS
/*******************************************************************************
  1.Name       : 김상모
  2.Create Date: 2007-02-02
  3.Description:
      - 용도: e-NIS 화물변동비 추정결산 배치 수행 중 e-Mail 전송
      - 파라미터: 제목과 간단한 내용 처리 용도임
      - 특이사항
        (1) 정상, 오류 작업 처리를 e-Mail로 전송처리
        (2) Mail Server IP는 DBA가 Oracle 환경에 셋팅 함
  4.Revision History
    2007-04-11:김상모:최초생성.
*******************************************************************************/

   /* Variable Declare -------------------------------------------------------*/
   v_from_eml VARCHAR2(32767) := 'jhjeon@cyberlogitec.com'; --전재홍
   v_to_eml   VARCHAR2(32767) := 'jhjeon@cyberlogitec.com';
   v_mime_type VARCHAR2(100) := 'text/plain; charset=UTF-8'; --Korean language 처리
   
BEGIN

   UTL_MAIL.SEND(  sender     => v_from_eml,
                   recipients => v_to_eml,
                   subject    => subj_nm_in,
                   message    => contents_in,
                   mime_type  => v_mime_type);
   
END;