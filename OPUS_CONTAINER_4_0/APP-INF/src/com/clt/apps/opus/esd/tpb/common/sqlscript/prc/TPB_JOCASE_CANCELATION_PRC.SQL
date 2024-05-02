CREATE OR REPLACE PROCEDURE OPUSADM."TPB_JOCASE_CANCELATION_PRC" 

/*******************************************************************************
1. Object Name      : TPB_JOCASE_CANCELATION_PRC
2. Version          : 1.1
3. Create Date      : 2008-11-20
4. Sub System       : Third Party Billing
5. Author           : Sun, Choi
6. Description      : JO TPB CANCEL
                      -------------------------------------------------------
                      DECLARE 
                            v_n3pty_no VARCHAR2(11); 
                      BEGIN 
                            TPB_JOCASE_CANCELATION_PRC(:n3pty_no,:user_ofc_cd,:user_id);
                            DBMS_OUTPUT.PUT_LINE('3rd Party TPB No. : ' || v_n3pty_no);
                      END; 
                      -------------------------------------------------------
7. Revision History : 2008.11.20  O Wan-Ki          1.0  Created
                      2009.10.30  Jong-Geon Byeon   1.1  Migration
*******************************************************************************/

-- ===== Arguments ========================================
(
     v_n3pty_no             IN TPB_OTS_DTL.n3pty_no%TYPE
    ,v_user_ofc_cd          IN VARCHAR2
    ,v_user_id              IN VARCHAR2
)
AUTHID CURRENT_USER
IS

-- ===== DECLARE ==========================================
	v_isvalid               NUMBER(2);

-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

--  2. validation check -----------------------------------
    v_isvalid := 1;
    
--  2-1. invoice & office check
    SELECT COUNT(0) * v_isvalid
      INTO v_isvalid
      FROM tpb_ots_grp
     WHERE 1 = 1
       AND n3pty_bil_tp_cd = 'JO'
       AND n3pty_no = v_n3pty_no
       AND ofc_cd = v_user_ofc_cd
       AND n3pty_inv_no is null
       AND n3pty_delt_tp_cd IN ('N','S')
    ;
--  2-2. outstanding status check
    SELECT COUNT(0) * v_isvalid
      INTO v_isvalid
      FROM tpb_ots_grp_sts
     WHERE 1 = 1
       AND n3pty_no = v_n3pty_no
       AND ots_sts_lst_flg = 'Y'
       AND ots_sts_cd = 'O'
    ;    

--  2.update & insert ------------------------------------
    IF  v_isvalid = 1 THEN 
    
--      2-1. update tpb_ots_dtl
---------------------------------
        UPDATE tpb_ots_dtl
           SET n3pty_delt_tp_cd = 'C'
              ,upd_dt = SYSDATE
              ,upd_usr_id = v_user_id
         WHERE 1 = 1
           AND n3pty_no = v_n3pty_no
        ;
        
--      2-2. insert row in tpb_ost_dtl_sts and activity recovery
-----------------------------------------------------------------
        FOR v_dtl_seq_list IN (SELECT ots_dtl_seq FROM tpb_ots_dtl WHERE n3pty_no = v_n3pty_no) LOOP
        
            UPDATE tpb_ots_dtl_sts 
               SET ots_sts_lst_flg = '+'
             WHERE 1 = 1
               AND ots_dtl_seq = v_dtl_seq_list.ots_dtl_seq
               AND ots_sts_lst_flg = 'Y'
            ;
            
            INSERT INTO tpb_ots_dtl_sts(
                   ots_dtl_seq
                  ,ots_dtl_sts_seq
                  ,ots_sts_cd
                  ,ots_sts_lst_flg
                  ,ots_sts_cre_dt
                  ,cre_usr_id
                  ,cre_dt,upd_usr_id,upd_dt )
            VALUES (
                   v_dtl_seq_list.ots_dtl_seq
                  ,TO_NUMBER((SELECT MAX(ots_dtl_sts_seq)+1 FROM tpb_ots_dtl_sts WHERE ots_dtl_seq = v_dtl_seq_list.ots_dtl_seq))
                  ,'D'
                  ,'Y'
                  ,SYSDATE
                  ,v_user_id
                  ,SYSDATE
                  ,v_user_id
                  ,SYSDATE )
            ;
            
            UPDATE tpb_ots_dtl_sts
               SET ots_sts_lst_flg = 'N'
                  ,upd_usr_id = v_user_id
                  ,upd_dt = SYSDATE
             WHERE 1 = 1
               AND ots_dtl_seq = v_dtl_seq_list.ots_dtl_seq
               AND ots_sts_lst_flg = '+'
            ;
            
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_dtl_seq_list.ots_dtl_seq,'','JO Case Canceled.','A','',v_user_ofc_cd,v_user_id);
            
        END LOOP;
        
--      2-3. update tpb_ots_grp
---------------------------------
        UPDATE tpb_ots_grp
           SET n3pty_delt_tp_cd = 'C'
              ,UPD_DT = SYSDATE
              ,UPD_USR_ID = v_user_id
         WHERE 1 = 1
           AND n3pty_no = v_n3pty_no
        ;
        
--      2-4. insert row in tpb_ost_grp_sts and activity recovery 
--------------------------------------------
        UPDATE tpb_ots_grp_sts
           SET ots_sts_lst_flg = '+'
              ,upd_dt = SYSDATE
              ,upd_usr_id = v_user_id
         WHERE 1 = 1
           AND n3pty_no = v_n3pty_no
        ;
        
        INSERT INTO tpb_ots_grp_sts(
               n3pty_no
              ,ots_sts_seq
              ,ots_sts_cd
              ,ots_sts_lst_flg
              ,ots_sts_cre_dt
              ,cre_usr_id
              ,cre_dt
              ,upd_usr_id
              ,upd_dt )
        VALUES(
               v_n3pty_no
              ,TO_NUMBER((SELECT MAX(ots_sts_seq)+1 FROM tpb_ots_grp_sts WHERE n3pty_no = v_n3pty_no))
              ,'D'
              ,'Y'
              ,SYSDATE
              ,v_user_id
              ,SYSDATE
              ,v_user_id
              ,SYSDATE )
        ;
        
        UPDATE tpb_ots_grp_sts
           SET ots_sts_lst_flg = 'N'
              ,upd_usr_id = v_user_id
              ,upd_dt = SYSDATE
         WHERE 1 = 1
           AND n3pty_no = v_n3pty_no
           AND ots_sts_lst_flg = '+'
        ;

        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'','JO Case Canceled.','A','',v_user_ofc_cd,v_user_id);
    
    END IF; --IF ( v_isvalid = 1 ) THEN
    
--EXCEPTION
--    WHEN OTHERS THEN
--        v_n3pty_no := NULL;
--        v_ots_dtl_seq := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  

END

-- ===== End of Procedure ==================================
;

GRANT EXECUTE ON OPUSADM.TPB_JOCASE_CANCELATION_PRC TO OPUSDEV;
GRANT EXECUTE ON OPUSADM.TPB_JOCASE_CANCELATION_PRC TO OPUS_ROLE;