CREATE OR REPLACE PROCEDURE LEAADM.LEA_ESTIF_DEL_PRC (V_MONTH IN VARCHAR2)
IS 
   v_lng_rtn            VARCHAR2 (100)              := ''; 
   v_str_desc           VARCHAR2 (100)              := ''; 
   v_cnt                NUMBER(18)                  := 1;
   v_tot_cnt            NUMBER(18)                  := 0;
   term_exception EXCEPTION ;
   length_exception EXCEPTION ;

BEGIN

    IF LENGTH(v_month) != 6 THEN
        RAISE length_exception ;
    END IF ;
        
    IF v_month >= '200901' THEN
        RAISE term_exception ;
    END IF ;    

    v_tot_cnt := 0 ;
    
    WHILE v_cnt > 0  LOOP
    
        DELETE LEA_ESTM_COST_IF
        WHERE UPD_DT >= TO_DATE(v_month,'YYYYMM')
	    AND UPD_DT < add_months(TO_DATE(v_month,'YYYYMM'), 1)
        AND ROWNUM < 100001
        ;
        
        v_cnt := SQL%ROWCOUNT; 
        
        COMMIT;
        
        v_tot_cnt := v_tot_cnt + v_cnt ;
        
        lea_log_prc('Del Count = '||v_tot_cnt);

        DBMS_LOCK.sleep (60);   

    END LOOP;

    COMMIT;
          
EXCEPTION 
   
      WHEN length_exception THEN
      DBMS_OUTPUT.PUT_LINE('error: invalid month') ;
      WHEN term_exception THEN
      DBMS_OUTPUT.PUT_LINE('error: 200801') ;
      WHEN OTHERS THEN 
      v_lng_rtn := TO_CHAR (SQLCODE); 
      v_str_desc := SUBSTR (SQLERRM, 1, 100); 
      DBMS_OUTPUT.PUT_LINE('Error'|| v_lng_rtn ||'-'||v_str_desc);
      ROLLBACK ;

END;