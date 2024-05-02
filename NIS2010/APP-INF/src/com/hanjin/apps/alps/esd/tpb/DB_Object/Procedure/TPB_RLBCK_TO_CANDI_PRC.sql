CREATE OR REPLACE PROCEDURE NISADM.TPB_RLBCK_TO_CANDI_PRC

/*******************************************************************************
   1. Object Name      : TPB_RLBCK_TO_CANDI_PRC
   2. Version          : 1.1
   3. Create Date      : 2008.12.08
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : JO TPB ROLLBACK TO CANDIDATE STATUS
                         ------------------------------------------------------
                         DECLARE 
                             v_n3pty_no VARCHAR2(11); 
                         BEGIN 
                             TPB_RLBCK_TO_CANDI_PRC(?,?,?);
                             DBMS_OUTPUT.PUT_LINE('3rd Party TPB No. : ' || v_n3pty_no);
                         END;
                         ------------------------------------------------------
   7. Revision History : 2008.12.08  O Wan-Ki  1.0  Created
                         2009.08.24  Park Sung-Jin  ALPS Migration
*******************************************************************************/

-- ===== Arguments ========================================
(
    v_n3pty_no              IN TPB_OTS_DTL.n3pty_no%TYPE
    ,v_user_ofc_cd          IN VARCHAR2
    ,v_user_id              IN VARCHAR2
)

authid CURRENT_USER

IS

-- ===== DECLARE ==========================================
	v_isvalid               NUMBER(2);

-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

--    1. validation check -----------------------------------
    v_isvalid := 1;
    
--    1-1. invoice & office check
    SELECT  COUNT(0)*v_isvalid
    INTO    v_isvalid
    FROM    tpb_ots_grp
    WHERE   1=1
        AND n3pty_bil_tp_cd = 'JO'
        AND n3pty_no = v_n3pty_no
        AND ofc_cd = v_user_ofc_cd
        AND n3pty_inv_no is null
        AND n3pty_delt_tp_cd IN ('N','S')
    ;

--    1-2. outstanding status check
    SELECT  COUNT(0)*v_isvalid
    INTO    v_isvalid
    FROM    tpb_ots_grp_sts
    WHERE   1=1
        AND n3pty_no = v_n3pty_no
        AND ots_sts_lst_flg = 'Y'
        AND ots_sts_cd = 'O'
    ;    
--    DBMS_OUTPUT.PUT_LINE(v_isvalid);

--    2. CUD ------------------------------------
    IF v_isvalid = 1 THEN 

--        2-1. insert row in tpb_ost_dtl_sts and activity recovery
-----------------------------------------------------------------
        FOR v_dtl_seq_list IN  (SELECT ots_dtl_seq FROM tpb_ots_dtl WHERE n3pty_no = v_n3pty_no) LOOP
        
            UPDATE  tpb_ots_dtl_sts 
            SET     ots_sts_lst_flg = '+'
            WHERE   1=1
                AND ots_dtl_seq = v_dtl_seq_list.ots_dtl_seq
                AND ots_sts_lst_flg = 'Y'
            ;
            
            INSERT INTO tpb_ots_dtl_sts(
                ots_dtl_seq         ,ots_dtl_sts_seq    ,ots_sts_cd
                ,ots_sts_lst_flg    ,ots_sts_cre_dt     ,cre_usr_id
                ,cre_dt             ,upd_usr_id,upd_dt )
            VALUES(
                v_dtl_seq_list.ots_dtl_seq,TO_NUMBER((SELECT MAX(ots_dtl_sts_seq)+1 FROM tpb_ots_dtl_sts WHERE ots_dtl_seq = v_dtl_seq_list.ots_dtl_seq)),'Z'
                ,'Y'                ,SYSDATE            ,v_user_id
                ,SYSDATE            ,v_user_id          ,SYSDATE )
            ;
            
            UPDATE  tpb_ots_dtl_sts
            SET     ots_sts_lst_flg = 'N'
                    ,upd_usr_id = v_user_id
                    ,upd_dt = SYSDATE
            WHERE   1=1
                AND ots_dtl_seq = v_dtl_seq_list.ots_dtl_seq
                AND ots_sts_lst_flg = '+'
            ;
            
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_dtl_seq_list.ots_dtl_seq,'','JO Case Canceled.'||'('||v_n3pty_no||')','A','',v_user_ofc_cd,v_user_id);
            
        END LOOP;
        
--        2-2. update tpb_ots_dtl
---------------------------------
        UPDATE  tpb_ots_dtl
        SET     n3pty_no = ''
                ,cfm_amt = ''
                ,rev_amt = ''
                ,ots_amt = ''
                ,bal_amt = ''
                ,cfm_curr_cd = ''
                ,cfm_rmk = ''
                ,n3pty_no_dp_seq = ''
                ,n3pty_cfm_cd = 'I'
--                ,cfm_dt = ''
--                ,n3pty_cfm_cd = ''
--                ,cfm_ofc_cd = ''
--                ,cfm_usr_id = ''
                ,upd_dt = SYSDATE
                ,upd_usr_id = v_user_id
        WHERE   1=1
            AND n3pty_no = v_n3pty_no
        ;

--        2-3. delete tpb_ots_grp
---------------------------------
        DELETE FROM tpb_ots_grp_sts WHERE n3pty_no = v_n3pty_no;
        DELETE FROM tpb_ots_grp_rcvr_act WHERE n3pty_no = v_n3pty_no;
        DELETE FROM tpb_ots_grp WHERE n3pty_no = v_n3pty_no;
    
    END IF; --IF ( v_isvalid = 1 ) THEN
    
--EXCEPTION
--    WHEN OTHERS THEN
--        v_n3pty_no := NULL;
--        v_ots_dtl_seq := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  

END

-- ===== End of Procedure ==================================
;