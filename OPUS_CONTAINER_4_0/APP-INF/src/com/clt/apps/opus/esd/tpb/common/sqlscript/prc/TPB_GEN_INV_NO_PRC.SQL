CREATE OR REPLACE PROCEDURE OPUSADM."TPB_GEN_INV_NO_PRC" 
/*******************************************************************************
   1. Object Name      : TPB_GEN_INV_NO_PRC
   2. Version          : 1.2
   3. Create Date      : 2007.05.31
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : 3rd Party Invoice No. Generating 
                         -------------------------------------------------------
                         DECLARE 
                            lst_n3pty_inv_no VARCHAR2(11); 
                         BEGIN 
                             TPB_GEN_INV_NO_PRC('PUSBTF', 'XX', '_user_id_', lst_n3pty_inv_no) ;
                             DBMS_OUTPUT.PUT_LINE('3rd Party Invoice No. : ' || lst_n3pty_inv_no);
                         END; 
                         -------------------------------------------------------
   7. Revision History : 2006.10.20  Kim Jin-seung  1.0  Created
                         2007.05.31  Kim Jin-seung  1.1  Corrected
                          ==> (n3pty_inv_ofc_cty_cd, n3pty_inv_yrmon, n3pty_bil_tp_cd) 차원에서 n3pty_inv_seq 생성
                         2009.09.08  Park Sung-Jin  1.2  Migration                 
*******************************************************************************/


-- ===== Arguments ========================================
(    
    v_ofc_cd      in VARCHAR2,  -- office code to get city code
    v_bil_tp_cd   in VARCHAR2,  -- billing type code
    v_user_id     in VARCHAR2,  -- user id 
    v_lst_inv_no  out VARCHAR2   -- 3rd Party Invoice No. (in failure : Null)
) 
authid CURRENT_USER
IS 

-- ===== DECLARE ==========================================
v_ofc_cty_cd  tpb_inv_no_gen.n3pty_inv_ofc_cty_cd%TYPE;  -- city code
v_yrmon       tpb_inv_no_gen.n3pty_inv_yrmon%TYPE; -- year/month

n_affected_rows number(8); 

-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles 
    v_ofc_cty_cd := SUBSTRB(TRIM(v_ofc_cd),1,3); 
    v_lst_inv_no := NULL; 

    -- v_yrmon := TO_CHAR(SYSDATE,'YYMM') ; 
    SELECT TO_CHAR(SYSDATE,'YY') || 
        DECODE( TO_NUMBER(TO_CHAR(SYSDATE,'MM')), 
            10, 'A',
            11, 'B',
            12, 'C',
            TO_NUMBER(TO_CHAR(SYSDATE,'MM'))
        ) 
    INTO v_yrmon 
    FROM DUAL 
    ; 

    
    --- ====== IF City Code is valid ===========
    IF ( LENGTHB(v_ofc_cty_cd) = 3 ) AND (LENGTHB(v_bil_tp_cd) = 2) THEN ----------------------


        --- ========================================
        --- seq++  3rd party no 
        --- ========================================

        ----- Update(Insert) seq / 3PB No.------------------------------    
        MERGE INTO tpb_inv_no_gen a 
            USING (
                SELECT NVL(MAX(n3pty_inv_seq),0)+1 next_seq   
                FROM tpb_inv_no_gen  
                WHERE  n3pty_inv_ofc_cty_cd = v_ofc_cty_cd 
                    AND n3pty_inv_yrmon = v_yrmon 
                    AND n3pty_bil_tp_cd = v_bil_tp_cd    --- Changed By Kim Jin-seung In 2007-05-31
            ) b 
            ON ( a.n3pty_inv_ofc_cty_cd = v_ofc_cty_cd 
                AND a.n3pty_inv_yrmon = v_yrmon  
                AND a.n3pty_bil_tp_cd = v_bil_tp_cd ) 
        WHEN MATCHED THEN 
            UPDATE SET  
                n3pty_inv_seq = b.next_seq,  
                lst_n3pty_inv_no = n3pty_inv_ofc_cty_cd || n3pty_inv_yrmon || n3pty_bil_tp_cd 
                               || TRIM(TO_CHAR(b.next_seq,'000')), 
                upd_usr_id = v_user_id, 
                upd_dt = SYSDATE 
        WHEN NOT MATCHED THEN 
            INSERT  ( 
                n3pty_inv_ofc_cty_cd, n3pty_inv_yrmon, n3pty_bil_tp_cd, n3pty_inv_seq, 
                lst_n3pty_inv_no, 
                cre_usr_id, cre_dt, upd_usr_id, upd_dt 
            ) VALUES ( 
                v_ofc_cty_cd, v_yrmon, v_bil_tp_cd, 1, 
                v_ofc_cty_cd || v_yrmon || v_bil_tp_cd || TRIM(TO_CHAR(1,'000')), 
                v_user_id, SYSDATE, v_user_id, SYSDATE 
            ) 
        ;
        
        

        -------------------------------------
        n_affected_rows := SQL%ROWCOUNT; --- affected rows
        
        IF n_affected_rows != 1 THEN  --- abnormal 
            DBMS_OUTPUT.PUT_LINE('affected rows : ' || n_affected_rows);
            v_lst_inv_no := NULL; 
        ELSE --- normal 
            ----- Getting 3PB No. 
            SELECT lst_n3pty_inv_no 
            INTO v_lst_inv_no 
            FROM tpb_inv_no_gen a 
            WHERE a.n3pty_inv_ofc_cty_cd = v_ofc_cty_cd 
                AND a.n3pty_inv_yrmon = v_yrmon  
                AND a.n3pty_bil_tp_cd = v_bil_tp_cd 
            ; 
        END IF; ---

    END IF; -------------------------------------------



--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_inv_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END

-- ===== End of Procedure ==================================
;

GRANT EXECUTE ON OPUSADM.TPB_GEN_INV_NO_PRC TO OPUSDEV;
GRANT EXECUTE ON OPUSADM.TPB_GEN_INV_NO_PRC TO OPUS_ROLE;