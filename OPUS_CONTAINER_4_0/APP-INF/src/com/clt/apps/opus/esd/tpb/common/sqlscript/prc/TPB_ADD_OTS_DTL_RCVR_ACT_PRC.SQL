CREATE OR REPLACE PROCEDURE OPUSADM."TPB_ADD_OTS_DTL_RCVR_ACT_PRC" 


/*******************************************************************************
   1. Object Name      : TPB_ADD_OTS_DTL_RCVR_ACT_PRC
   2. Version          : 1.1
   3. Create Date      : 2008.09.22
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : Add Outstanding Detail Recovery Activity Message
                         ------------------------------------------------------
                         DECLARE 

                         BEGIN 
                             TPB_ADD_OTS_DTL_RCVR_ACT_PRC(,,,,) ;
                         END; 
                         ------------------------------------------------------
   7. Revision History : 2008.09.22  Kim Jin-seung  1.0  Created
                         2009.08.10  Park Sung-Jin  1.1  Migration
                         2010.08.09  Eunju Son      1.2  Interface Remark modify
*******************************************************************************/

-- ===== Arguments ========================================
( 
    v_proc_type     IN VARCHAR2   --- process type; S:Single, M:Multi
    ,v_proc_key  IN VARCHAR2      --- key; process type=S:ots_dtl_seq, =M:n3pty_no
    ,v_cntc_pson_nm IN VARCHAR2   --- contact person name
    ,v_act_rmk      IN VARCHAR2   --- recovery activity remark
    ,v_n3pty_clt_rmk_tp_cd IN VARCHAR2  --- remark typ code; A:Auto / M:User Manual
    ,v_file_no      IN VARCHAR2   --- file no 
    ,v_user_ofc_cd  IN VARCHAR2   --- user office code
    ,v_user_id      IN VARCHAR2   --- user id
) 
authid CURRENT_USER

IS 

-- ===== DECLARE ==========================================
p_if_rmk VARCHAR2(1000)    := ''; 
p_act_rmk TPB_OTS_DTL_RCVR_ACT.ACT_RMK%TYPE;
v_src_no  TPB_OTS_DTL.N3PTY_SRC_NO%TYPE; 

-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

    --- Initiate varibles 

    ---  1) INSERT TPB_OTS_DTL_RCVR_ACT
    IF ( v_proc_type = 'S' ) THEN 
        IF  v_act_rmk like 'Confirmed. -%' THEN
             SELECT IF_RMK,N3PTY_SRC_NO 
             into p_if_rmk, v_src_no
             FROM TPB_OTS_DTL 
             WHERE OTS_DTL_SEQ=v_proc_key;
             
             
            p_act_rmk := v_act_rmk ||'['||TRIM(v_src_no)||']'||p_if_rmk;
        ELSE
            p_act_rmk := v_act_rmk;
             
        END IF;      
        
        INSERT INTO TPB_OTS_DTL_RCVR_ACT (
            ots_dtl_seq, 
            ots_rcvr_act_seq, 
            cntc_pson_nm, act_rmk, 
            n3pty_clt_rmk_tp_cd, rcvr_act_cre_ofc_cd, rcvr_act_upd_ofc_cd, file_no, locl_cre_dt, 
            cre_usr_id, cre_dt, upd_usr_id, upd_dt    
        ) 
        SELECT 
            v_proc_key, 
            ( SELECT NVL(MAX(ots_rcvr_act_seq),0)+1
              FROM TPB_OTS_DTL_RCVR_ACT 
              WHERE ots_dtl_seq = v_proc_key 
            ), 
            v_cntc_pson_nm, p_act_rmk, 
            v_n3pty_clt_rmk_tp_cd, v_user_ofc_cd, v_user_ofc_cd, v_file_no, SYSDATE, 
            v_user_id, SYSDATE, v_user_id, SYSDATE 
        FROM DUAL
        ;

    ELSIF ( v_proc_type = 'M' ) THEN 

        INSERT INTO TPB_OTS_DTL_RCVR_ACT (
            ots_dtl_seq, ots_rcvr_act_seq, cntc_pson_nm, act_rmk, 
            n3pty_clt_rmk_tp_cd, rcvr_act_cre_ofc_cd, rcvr_act_upd_ofc_cd, file_no, locl_cre_dt, 
            cre_usr_id, cre_dt, upd_usr_id, upd_dt    
        ) 
        SELECT 
            ots_dtl_seq, NVL(MAX(ots_rcvr_act_seq),0)+1, v_cntc_pson_nm, v_act_rmk, 
            v_n3pty_clt_rmk_tp_cd, v_user_ofc_cd, v_user_ofc_cd, v_file_no, SYSDATE, 
            v_user_id, SYSDATE, v_user_id, SYSDATE 
        FROM TPB_OTS_DTL_RCVR_ACT 
        WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq 
                               FROM TPB_OTS_DTL 
                               WHERE n3pty_no = v_proc_key 
                                  AND n3pty_delt_tp_cd = 'N'
                             ) 
        GROUP BY ots_dtl_seq 
        ---
        UNION ALL
        --- 
        SELECT 
            ots_dtl_seq, 1, v_cntc_pson_nm, v_act_rmk, 
            v_n3pty_clt_rmk_tp_cd, v_user_ofc_cd, v_user_ofc_cd, v_file_no, SYSDATE, 
            v_user_id, SYSDATE, v_user_id, SYSDATE 
        FROM TPB_OTS_DTL A
        WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq 
                               FROM TPB_OTS_DTL 
                               WHERE n3pty_no = v_proc_key 
                                  AND n3pty_delt_tp_cd = 'N'
                             ) 
            AND NOT EXISTS ( SELECT ots_dtl_seq 
                             FROM TPB_OTS_DTL_RCVR_ACT B
                             WHERE A.ots_dtl_seq = B.ots_dtl_seq
                           ) 
        ;

    END IF;    


--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_inv_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END

-- ===== End of Procedure ==================================
;

GRANT EXECUTE ON OPUSADM.TPB_ADD_OTS_DTL_RCVR_ACT_PRC TO OPUSDEV;
GRANT EXECUTE ON OPUSADM.TPB_ADD_OTS_DTL_RCVR_ACT_PRC TO OPUS_ROLE;