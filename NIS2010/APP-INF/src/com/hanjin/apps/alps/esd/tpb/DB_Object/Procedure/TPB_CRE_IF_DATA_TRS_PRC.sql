CREATE OR REPLACE PROCEDURE NISADM.TPB_CRE_IF_DATA_TRS_PRC

 /*******************************************************************************
   1. Object Name      : TPB_CRE_IF_DATA_TRS_PRC
   2. Version          : 1.4
   3. Create Date      : 2008.09.04
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : From TES To TPB (Inbound) Interface
                         -------------------------------------------------------
                         BEGIN 
                             TPB_CRE_IF_DATA_TRS_PRC('NYCBB','-6') ;
                             -- DBMS_OUTPUT.PUT_LINE('');
                         END;
                         -------------------------------------------------------
   7. Revision History : 2008.09.04  Kim Jin-seung   1.0  Created
                         2008.11.05  Kim Jin-seung   1.1  2008.11.10  기준으로 Interface 결과 Data 테이블 변경 수용하도록 처리 - tpb_ots_dtl_seq1 사용
                         2009.03.27  O Wan-Ki        1.2  N200903170210, TRS-IF시 Cancel Flag 정보포함.
                         2009.08.17  Park Sung-Jin   1.3  ALPS Migration
                         2010.01.07  Jong-Geon Byeon 1.4  NIS2010 ALPS간 EQ_KND_CD 단일화 작업
 *******************************************************************************/

-- ===== Arguments ========================================
(    
    in_trsp_if_ofc_cd  in VARCHAR2,  -- KEY1 : trsp_if_ofc_cd
    in_trsp_if_seq     in VARCHAR2,  -- KEY2 : trsp_if_seq
    in_user_ofc_cd     in VARCHAR2, -- user office code  
    in_user_id         in VARCHAR2  -- user id    
) 
authid CURRENT_USER

IS 

-- ===== DECLARE ==========================================
    v_src_sys_cd    VARCHAR2(3); -- TRS
    v_isafter20081110 NUMBER(1); -- DATE CHAECK SING RESULT 
    v_ots_dtl_seq   TPB_OTS_DTL.ots_dtl_seq%TYPE;
    
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    ----- Initiate varibles 
    v_src_sys_cd  := 'TRS'; 


        SELECT tpb_ots_dtl_seq1.nextval 
        INTO v_ots_dtl_seq
        FROM DUAL
        ; 

        ---------------------------------- 
        INSERT INTO TPB_OTS_DTL ( 
            ots_dtl_seq, src_if_seq_no, n3pty_bil_tp_cd, 
            if_rhq_cd, 
            if_ofc_cd, 
            ofc_cd, 
            n3pty_src_sub_sys_cd, n3pty_expn_tp_cd, n3pty_src_no, so_no, csr_no, 
            src_vndr_cnt_cd, src_vndr_seq, vndr_cust_div_cd, vndr_cnt_cd, vndr_seq, 
            cust_cnt_cd, cust_seq, n3pty_ofc_cd, eq_no, eq_tpsz_cd, 
            fm_nod_cd, to_nod_cd, via_nod_cd, dor_nod_cd, 
            eq_knd_cd, bkg_no, bl_no, skd_dir_cd, finc_dir_cd, vsl_cd,
            skd_voy_no, if_curr_cd, acct_cd, lgs_cost_cd, if_amt, 
            if_rmk, n3pty_if_tp_cd, n3pty_cfm_cd, n3pty_delt_tp_cd, 
            if_usr_id, if_dt, cre_usr_id, cre_dt, upd_usr_id, upd_dt  
			/*1.2 Modified : 2009-03-27 O Wan-Ki N200903170210, TRS-IF시 Cancel Flag 정보포함.*/
			,cxl_flg
        ) 
        SELECT 
            v_ots_dtl_seq, trsp_if_seq, n3pty_bil_tp_cd, 
            TPB_GET_HNDL_OFC_FNC('R',TPB_GET_N3PTY_OFC_CD_FNC(trsp_if_ofc_cd)), 
            trsp_if_ofc_cd, 
            TPB_GET_N3PTY_OFC_CD_FNC(trsp_if_ofc_cd), 
            v_src_sys_cd, v_src_sys_cd, inv_no, trsp_so_ofc_cty_cd || trsp_so_seq, csr_no,  
            NULL, vndr_seq, vndr_cust_div_cd, n3pty_vndr_cnt_cd, n3pty_vndr_seq, 
            cust_cnt_cd, cust_seq, n3pty_ofc_cd, eq_no, eq_tpsz_cd, 
            fm_nod_cd, to_nod_cd, via_nod_cd, dor_nod_cd, 
            eq_knd_cd, bkg_no, bl_no, substrb(skd_dir_cd,1,1), substrb(skd_dir_cd,1,1) || substrb(finc_skd_dir_cd,1,1), vsl_cd,
            skd_voy_no, curr_cd, acct_cd, lgs_cost_cd, if_amt, 
            if_rmk, 'S', 'I', 'N', 
            NVL(upd_usr_id,cre_usr_id), SYSDATE, NVL(upd_usr_id,cre_usr_id), SYSDATE, NVL(upd_usr_id,cre_usr_id), SYSDATE
			/*1.2 Modified : 2009-03-27 O Wan-Ki N200903170210, TRS-IF시 Cancel Flag 정보포함.*/
			,cxl_flg
        FROM TRS_N3RD_PTY_IF 
        WHERE trsp_n3pty_if_sts_cd IN ('N') -- , 'P') -- Interface 대상만 
            AND trsp_if_ofc_cd = in_trsp_if_ofc_cd 
            AND trsp_if_seq = in_trsp_if_seq 
        ; 
         
         
        ---------------------------------- 
        UPDATE TRS_N3RD_PTY_IF 
        SET trsp_n3pty_if_sts_cd = 'P', 
            upd_dt = SYSDATE 
        WHERE trsp_n3pty_if_sts_cd = 'N' 
            AND trsp_if_ofc_cd = in_trsp_if_ofc_cd 
            AND trsp_if_seq = in_trsp_if_seq 
        ; 
        ----------------------------------

        TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'Z', in_user_id); 
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Interfaced from '||v_src_sys_cd||'.','A','',in_user_ofc_cd,in_user_id);



--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END

-- ===== End of Procedure ==================================
;