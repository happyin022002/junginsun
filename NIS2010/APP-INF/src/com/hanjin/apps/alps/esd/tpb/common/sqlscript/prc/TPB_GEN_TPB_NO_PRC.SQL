CREATE OR REPLACE PROCEDURE NISADM.TPB_GEN_TPB_NO_PRC

/*******************************************************************************
   1. Object Name      : TPB_GEN_TPB_NO_PRC
   2. Version          : 1.1
   3. Create Date      : 2006.10.19
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : 3rd Party No. Generating 
                         ------------------------------------------------------
                         DECLARE 
                             lst_n3pty_no VARCHAR2(14); 
                         BEGIN 
                             TPB_GEN_TPB_NO_PRC('PUSBTF','_user_id_', lst_n3pty_no) ;
                             DBMS_OUTPUT.PUT_LINE('3rd Party No. : ' || lst_n3pty_no);
                         END;
                         ------------------------------------------------------
   7. Revision History : 2006.10.19  Kim Jin-seung  1.0  Created
                         2009.08.10  O Wan-Ki       1.1  ALPS Migration
*******************************************************************************/

-- ===== Arguments ========================================
(    
    v_ofc_cd   in VARCHAR2,  -- office code to get city code
    v_user_id  in VARCHAR2,  -- user id 
    v_lst_no   out VARCHAR2   -- 3rd Party No. (in failure : Null)
) 
authid CURRENT_USER
IS 

-- ===== DECLARE ==========================================
v_appl_cd     tpb_no_gen.n3pty_appl_cd%TYPE; -- app code
v_ofc_cty_cd  tpb_no_gen.n3pty_ofc_cty_cd%TYPE;  -- city code
v_yrmon       tpb_no_gen.n3pty_yrmon%TYPE; -- year/month

n_affected_rows number(8); 

-- ===== BEGIN, EXCEPTION & END ======================================
BEGIN

    --- Initiate varibles 
    v_appl_cd := 'TPB'; -- fixed
    v_ofc_cty_cd := SUBSTRB(TRIM(v_ofc_cd),1,3); 
    v_yrmon := TO_CHAR(SYSDATE,'YYMM') ; 
    v_lst_no := NULL; 

    
    --- ====== IF City Code is valid ===========
    IF LENGTHB(v_ofc_cty_cd) = 3 THEN ----------------------


        --- ========================================
        --- seq++ & Getting 3rd party no 
        --- ========================================

        ----- Update(Insert) seq / 3PB No.------------------------------    
        MERGE INTO tpb_no_gen a 
            USING DUAL 
            ON ( a.n3pty_appl_cd = v_appl_cd 
                AND a.n3pty_ofc_cty_cd = v_ofc_cty_cd  
                AND a.n3pty_yrmon = v_yrmon ) 
        WHEN MATCHED THEN 
            UPDATE SET  
                n3pty_seq = n3pty_seq + 1, 
                lst_n3pty_no = n3pty_appl_cd || n3pty_ofc_cty_cd || n3pty_yrmon 
                               || TRIM(TO_CHAR(n3pty_seq+1,'0000')), 
                upd_usr_id = v_user_id, 
                upd_dt = SYSDATE
        WHEN NOT MATCHED THEN 
            INSERT  ( 
                n3pty_appl_cd, n3pty_ofc_cty_cd, n3pty_yrmon, n3pty_seq, 
                lst_n3pty_no, 
                cre_usr_id, cre_dt, upd_usr_id, upd_dt 
            ) VALUES ( 
                v_appl_cd, v_ofc_cty_cd, v_yrmon, 1, 
                v_appl_cd || v_ofc_cty_cd || v_yrmon || TRIM(TO_CHAR(1,'0000')), 
                v_user_id, SYSDATE, v_user_id, SYSDATE 
            )
        ;
        --DBMS_OUTPUT.PUT_LINE('lst_n3pty_no1 : ' || n3pty_appl_cd || n3pty_ofc_cty_cd || n3pty_yrmon || TRIM(TO_CHAR(n3pty_seq+1,'0000')));
        --DBMS_OUTPUT.PUT_LINE('lst_n3pty_no2 : ' || v_appl_cd || v_ofc_cty_cd || v_yrmon || TRIM(TO_CHAR(1,'0000')));        

        -------------------------------------
        n_affected_rows := SQL%ROWCOUNT; --- affected rows
        
        IF n_affected_rows != 1 THEN  --- abnormal 
            DBMS_OUTPUT.PUT_LINE('affected rows : ' || n_affected_rows);
            v_lst_no := NULL; 
        ELSE --- normal 
            ----- Getting 3PB No. 
            SELECT lst_n3pty_no 
            INTO v_lst_no 
            FROM tpb_no_gen a 
            WHERE a.n3pty_appl_cd = v_appl_cd 
                AND a.n3pty_ofc_cty_cd = v_ofc_cty_cd  
                AND a.n3pty_yrmon = v_yrmon 
            ; 
 --DBMS_OUTPUT.PUT_LINE('v_lst_no : ' || v_lst_no);
        END IF; ---
    END IF; -------------------------------------------



--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END

-- ===== End of Procedure ==================================
;