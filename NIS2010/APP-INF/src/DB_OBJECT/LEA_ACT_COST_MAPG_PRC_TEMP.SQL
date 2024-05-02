CREATE OR REPLACE PROCEDURE LEAADM.LEA_ACT_COST_MAPG_PRC_TEMP
IS
    v_bkg_no           VARCHAR2(11)     :='';       
    v_bkg_no_split     VARCHAR2(2)     := '';
    v_rev_yrmon        VARCHAR2(6) :='';
    v_vsl_cd           VARCHAR2(4) :='';
    v_skd_voy_no       VARCHAR2(4) := '';
    v_skd_dir_cd       VARCHAR2(1) := '';
    v_rev_dir_cd       VARCHAR2(1) := '';
    v_lng_rtn          VARCHAR2 (100)            := ''; 
    v_str_desc         VARCHAR2 (100)            := ''; 
    v_bkg  VARCHAR2(13) := '';
    v_cntr VARCHAR2(14) := '';
    v_v_cnt  NUMBER(2) := 0 ;
    
BEGIN

FOR c in ( 
   SELECT 
distinct a.exe_yrmon a1, a.csr_no a2, a.bkg_no a3, a.bkg_no_split a4, b.bkg_no a5, b.bkg_no_split  a6
from lea_rev_vvd_cng a, lea_act_cost_if b
where a.exe_yrmon >= '200801'
and a.exe_yrmon = b.exe_yrmon
and a.inv_sys_id = b.inv_sys_id
and a.csr_no = b.csr_no
and a.bkg_no = b.new_bkg_no 
and a.bkg_no_split =  b.new_bkg_no_split
and a.old_vsl_cd = b.vsl_cd
and a.old_skd_voy_no = b.skd_voy_no
and a.old_skd_dir_cd = b.skd_dir_cd
and a.old_rev_dir_cd = b.rev_dir_cd
and b.act_cost_mapg_cd = 'V'
and a.upd_usr_id <> 'MANUAL' )

LOOP

 


            update lea_rev_vvd_cng
            set bkg_no = c.a5 , 
            bkg_no_split = c.a6
            where exe_yrmon = c.a1
            and csr_no = c.a2
            and bkg_no = c.a3
            and bkg_no_split = c.a4
            ;
            
     
  
        commit;
    
 

END LOOP;

EXCEPTION 
WHEN NO_DATA_FOUND THEN

dbms_output.put_line(v_bkg||' '||v_cntr);
WHEN OTHERS 
THEN 
v_lng_rtn := TO_CHAR (SQLCODE); 
v_str_desc := SUBSTR (SQLERRM, 1, 100); 

dbms_output.put_line(v_bkg||' '||v_cntr||' '||v_lng_rtn||' '||v_str_desc);
END;