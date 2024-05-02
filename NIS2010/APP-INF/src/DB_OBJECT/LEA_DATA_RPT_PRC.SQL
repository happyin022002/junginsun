CREATE OR REPLACE PROCEDURE LEAADM.LEA_DATA_RPT_PRC
IS 
   v_lng_rtn            VARCHAR2 (100)              := ''; 
   v_str_desc           VARCHAR2 (100)              := ''; 
   v_ctrl_ofc_cd        VARCHAR2 (6)                := '';
   v_cnt                NUMBER(18)                  := 0;

BEGIN
FOR C IN (  
        select distinct a.rev_yrmon rev_yrmon, a.n1st_nod_cd n1st_nod_cd, 
        a.n2nd_nod_cd n2nd_nod_cd , NVL(a.n3rd_nod_cd,' ') n3rd_nod_cd, NVL(a.n4th_nod_cd, ' ') n4th_nod_cd
        from lea_accl_dtl a
        where a.rev_yrmon in ( '200801' , '200802', '200803')
        AND A.DELT_FLG = 'N'
        AND A.BKG_STS_CD IN ('F','W')
        and a.ctrl_ofc_cd is null
        order by a.rev_yrmon
        )
LOOP 
    begin
            lea_log_prc('Node = '||c.rev_yrmon||'-'||c.n1st_nod_cd||'-'||c.n2nd_nod_cd||'-'||c.n3rd_nod_cd||'-'||c.n4th_nod_cd);
            v_ctrl_ofc_cd :='';
            v_cnt := 0;
        
            begin
                select  rev_yrmon into  v_ctrl_ofc_cd from lea_act_cost_if_temp 
                where exe_yrmon = '999999'
                and inv_sys_id = 'AAA'
                and n1st_nod_cd = c.n1st_nod_cd
                and n2nd_nod_cd = c.n2nd_nod_cd
                and n3rd_nod_cd = c.n3rd_nod_cd
                and n4th_nod_cd = c.n4th_nod_cd
                and rownum = 1
                ;  
                 
            exception
               WHEN OTHERS 
               THEN 
                  v_lng_rtn := TO_CHAR (SQLCODE); 
                  v_str_desc := SUBSTR (SQLERRM, 1, 100); 
                  DBMS_OUTPUT.PUT_LINE('Error '|| v_lng_rtn ||'-'||v_str_desc);
            end;
         
            lea_log_prc('CTRL_OFC = '|| v_ctrl_ofc_cd );
                  
           IF  length(v_ctrl_ofc_cd) > 0  THEN
    
                UPDATE LEA_ACCL_DTL
                set ctrl_ofc_cd = v_ctrl_ofc_cd
                WHERE rev_yrmon = c.rev_yrmon
                AND DELT_FLG = 'N'
                AND BKG_STS_CD IN ('F','W')
                and ctrl_ofc_cd is null
                and n1st_nod_cd = c.n1st_nod_cd
                and n2nd_nod_cd = c.n2nd_nod_cd
                and NVL(n3rd_nod_cd, ' ') = c.n3rd_nod_cd
                and NVL(n4th_nod_cd, ' ') = c.n4th_nod_cd
                ;
                
                v_cnt := SQL%ROWCOUNT;
                lea_log_prc('CTRL_OFC_CD UPDATE = '||v_ctrl_ofc_cd||':'||v_cnt);
                
                COMMIT;
                
           END IF;
    EXCEPTION 
       WHEN OTHERS 
       THEN 
          v_lng_rtn := TO_CHAR (SQLCODE); 
          v_str_desc := SUBSTR (SQLERRM, 1, 100); 
          DBMS_OUTPUT.PUT_LINE('Error 4'|| v_lng_rtn ||'-'||v_str_desc);
    
    END;
    
END LOOP;  
      
 
EXCEPTION 
   WHEN OTHERS 
   THEN 
      v_lng_rtn := TO_CHAR (SQLCODE); 
      v_str_desc := SUBSTR (SQLERRM, 1, 100); 
      DBMS_OUTPUT.PUT_LINE('Error 3'|| v_lng_rtn ||'-'||v_str_desc);

END;