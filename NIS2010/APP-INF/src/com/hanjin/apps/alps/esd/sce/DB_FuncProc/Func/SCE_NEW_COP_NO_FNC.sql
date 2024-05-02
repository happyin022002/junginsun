CREATE OR REPLACE FUNCTION SCE_NEW_COP_NO_FNC ( v_ofc_cd VARCHAR2 )

/*******************************************************************************
   1. Object Name      : SCE_NEW_COP_NO_FNC
   2. Version          : 1.0
   3. Create Date      : 2009.09.15
   4. Sub System       : SCE
   5. Author           : 김인수
   6. Description      : 신규 COP No 를 추출한다. (office code 를 받음)
   7. Revision History : 2009.09.15 김인수 최초 생성
*******************************************************************************/

RETURN VARCHAR2
authid current_user 
IS
    v_cop_no VARCHAR2(14);

BEGIN
    
select 
 'C'|| substr(v_ofc_cd, 1, 3)  ||
               SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),2,1) ||                                                
               CASE WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '10' THEN 'A'                      
                    WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '11' THEN 'B'                      
                    WHEN SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),3,2) = '12' THEN 'C'                      
                    ELSE SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),4,1)                                      
               END  ||                                                                              
               SUBSTR(TO_CHAR(SYSDATE,'YYMMDD'),5,2) ||                                             
               TRIM(TO_CHAR(SCE_COP_SEQ1.NEXTVAL,'000000'))                                                   
into v_cop_no
from dual;

RETURN v_cop_no;

END;
/
