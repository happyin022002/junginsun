CREATE OR REPLACE PROCEDURE OPUSADM."TPB_ADD_OTS_GRP_RCVR_ACT_PRC" 

/*******************************************************************************
1. Object Name      : TPB_ADD_OTS_GRP_RCVR_ACT_PRC
2. Version          : 1.1
3. Create Date      : 2008.09.22
4. Sub System       : Third Party Billing
5. Author           : Sun, Choi
6. Description      : Add Outstanding Group Recovery Activity Message
                      -------------------------------------------------------
                      DECLARE 

					  BEGIN 
					      TPB_ADD_OTS_GRP_RCVR_ACT_PRC(,,,,) ;
					  END; 
                      -------------------------------------------------------
7. Revision History : 2008.09.22  Kim Jin-seung    1.0  Created
                      2009.08.10  Jong-Geon Byeon  1.1  Migration
*******************************************************************************/

-- ===== Arguments ========================================
	( 
	    v_n3pty_no     			IN VARCHAR2      --- key - n3pty_no
	    ,v_cntc_pson_nm 		IN VARCHAR2   --- contact person name
	    ,v_act_rmk      		IN VARCHAR2   --- recovery activity remark
	    ,v_n3pty_clt_rmk_tp_cd 	IN VARCHAR2  --- remark typ code; A:Auto / M:User Manual
	    ,v_file_no      		IN VARCHAR2   --- file no 
	    ,v_user_ofc_cd  		IN VARCHAR2   --- user office code
	    ,v_user_id      		IN VARCHAR2   --- user id
	) 
authid CURRENT_USER
	IS 

	-- ===== DECLARE ==========================================


	-- ===== BEGIN, EXCEPTION and END ======================================
	BEGIN

	    --- Initiate varibles 

	    ---  INSERT TPB_OTS_GRP_RCVR_ACT
	    INSERT INTO TPB_OTS_GRP_RCVR_ACT (
	        n3pty_no, 
	        ots_grp_rcvr_act_seq, 
	        cntc_pson_nm, act_rmk, 
	        n3pty_clt_rmk_tp_cd, clt_act_cre_ofc_cd, clt_act_upd_ofc_cd, file_no, locl_cre_dt, 
	        cre_usr_id, cre_dt, upd_usr_id, upd_dt    
	    ) 
	    SELECT 
	        v_n3pty_no, 
	        ( SELECT NVL(MAX(ots_grp_rcvr_act_seq),0)+1
	          FROM TPB_OTS_GRP_RCVR_ACT 
	          WHERE n3pty_no = v_n3pty_no 
	        ), 
	        v_cntc_pson_nm, v_act_rmk, 
	        v_n3pty_clt_rmk_tp_cd, v_user_ofc_cd, v_user_ofc_cd, v_file_no, SYSDATE, 
	        v_user_id, SYSDATE, v_user_id, SYSDATE 
	    FROM DUAL 
	    ;

	--EXCEPTION
	--    WHEN OTHERS THEN
	--        v_lst_inv_no := NULL;
	--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
	     

	END

	-- ===== End of Procedure ==================================
	;

GRANT EXECUTE ON OPUSADM.TPB_ADD_OTS_GRP_RCVR_ACT_PRC TO OPUSDEV;
GRANT EXECUTE ON OPUSADM.TPB_ADD_OTS_GRP_RCVR_ACT_PRC TO OPUS_ROLE;