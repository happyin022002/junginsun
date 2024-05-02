CREATE OR REPLACE FUNCTION TRS_FILTER_SPC_CHAR_FNC(v_indata IN VARCHAR2 , v_candicd IN VARCHAR2 DEFAULT '' )
RETURN varchar2
AUTHID CURRENT_USER
IS
/*
  1.Name       : 이용태
  2.Create Date: 2008-03-31
  3.Description:
      - 용도: 키보드 입력 외 특수문자 제거.
      - 파라미터: v_indata
      - 특이사항: ascii 30-127 사이의 문자 외에 제거.
  4.Revision History
    2007-01-05:이민석:최초생성.
*/

v_out VARCHAR2(1000) := '';
tmp_a number  := '';
tmp_b VARCHAR2(6) := '';

i int := 0;

BEGIN

--DBMS_OUTPUT.enable;

  IF length(v_indata) >0 THEN
        FOR i IN 1..length(v_indata)      LOOP
        	tmp_a := ascii( substr( v_indata,i,1 ) );
        	tmp_b := substr( v_indata,i,1 );
    
--        	DBMS_OUTPUT.PUT_LINE( '---------- '||i || ' , ' || tmp_a || ' , ' || tmp_b    ) ;

    	   IF 30 < tmp_a and tmp_a < 127 THEN 
    	      v_out := CONCAT(v_out, tmp_b );       -- 30-127 사이면 그대로 저장.
    	   ELSE
    	      v_out := CONCAT(v_out, v_candicd );   -- 그렇지 않으면 대체 코드 or 공백 저장.
           END IF;
    	
--    	DBMS_OUTPUT.PUT_LINE( tmp_b) ;
    
        
        END LOOP;
    
   END IF;

RETURN v_out ;
	
END ;