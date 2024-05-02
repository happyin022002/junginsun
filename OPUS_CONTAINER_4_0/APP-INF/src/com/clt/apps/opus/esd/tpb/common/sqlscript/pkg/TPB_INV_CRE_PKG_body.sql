CREATE OR REPLACE PACKAGE BODY OPUSADM."TPB_INV_CRE_PKG"

IS

/*******************************************************************************
   1. Object Name      : TPB_INV_CRE_PKG
   2. Version          : 1.4
   3. Create Date      : 2008.09.30
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : TPB Invoice Creation Package
                         ------------------------------------------------------
                         DECLARE 

                         BEGIN 
                            TPB_INV_CRE_PKG...1. (,,,,) ;
                            TPB_INV_CRE_PKG...2. (,,,,) ;
                            TPB_INV_CRE_PKG...3. (,,,,) ;
                         END; 
                         ------------------------------------------------------
   7. Revision History : 2008.09.30  Kim Jin-seung      1.0  Created
                         2009.05.28  O Wan-Ki           1.1  Modified
                         2009.09.22  Park Sung-Jin      1.2  Migration
                         2010.01.08  Sun, CHOI          1.3  EQ_TP_CD -> EQ_KND_CD 전환
                         2010.06.09  Jong-Geon Byeon    1.4  TPB_INV_RVIS_DTl.VAT_DTL_AMT 추가
*******************************************************************************/

/*###############################################################################################
 *# CRE_INV_RVIS : CREATE TPB INVOICE MAIN, REVISION DATA 
 *###############################################################################################*/

PROCEDURE CRE_INV_RVIS
-- ===== Arguments ========================================
(    
    in_n3pty_no     IN VARCHAR2,
    in_user_ofc_cd           IN VARCHAR2,
    in_user_id          IN VARCHAR2,
    
    in_bil_tp_cd           IN VARCHAR2, 
    in_h_vndr_cust_div_cd IN VARCHAR2,
    in_vndr_cnt_cd IN VARCHAR2,
    in_vndr_seq IN VARCHAR2,
    in_cust_cnt_cd IN VARCHAR2,
    in_cust_seq IN VARCHAR2,
    in_vndr_cust_nm IN VARCHAR2,
    in_vndr_cust_addr IN VARCHAR2,
    in_fax_no IN VARCHAR2,
    in_phn_no IN VARCHAR2,
    in_vndr_cust_ref_rmk IN VARCHAR2,
    in_rcv_due_dt IN VARCHAR2,
    in_rgst_no IN VARCHAR2,
    in_inv_desc IN VARCHAR2,
    in_curr_cd IN VARCHAR2,
    in_net_amt IN VARCHAR2,
    in_vat_amt IN VARCHAR2,
    in_add_amt IN VARCHAR2,
    in_ddct_amt IN VARCHAR2,
    in_sum_inv_amt IN VARCHAR2,
    in_vndr_cust_eml IN VARCHAR2,
    in_cty_nm IN VARCHAR2,
    in_ste_cd IN VARCHAR2,
    in_zip_cd IN VARCHAR2,
    in_usr_inp_ctnt1 IN VARCHAR2,
    in_usr_inp_ctnt2 IN VARCHAR2,

	in_ida_tax_seq IN VARCHAR2, --2009-05-28
    
    out_n3pty_inv_no    OUT VARCHAR2, --------
    out_n3pty_inv_rvis_seq OUT VARCHAR2 --------
) 

IS 

-- ===== DECLARE ==========================================
    v_n3pty_inv_no tpb_invoice.n3pty_inv_no%TYPE; -- temp TPB Inv No.
--    v_n3pty_inv_rvis_seq tpb_inv_rvis.n3pty_inv_rvis_seq%TYPE; -- n3pty_inv_rvis_seq


-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

    --- Initiate varibles 

    --- ====== get tpb invoice no. =========== 
    TPB_GEN_INV_NO_PRC(in_user_ofc_cd, in_bil_tp_cd, in_user_id, v_n3pty_inv_no); 

    SELECT lst_n3pty_inv_no 
    INTO out_n3pty_inv_no  
    FROM tpb_inv_no_gen 
    WHERE lst_n3pty_inv_no = v_n3pty_inv_no 
    FOR UPDATE NOWAIT 
    ; 

    
    --- ====== IF TPB INV NO. is valid ===========
    IF LENGTHB(out_n3pty_inv_no) = 11 THEN ----------------------

        
        ----- insert into tpb_invoice ------------------------------    
        SELECT NVL(MAX(n3pty_inv_rvis_seq),0) + 1 AS new_n3pty_inv_rvis_seq 
        INTO out_n3pty_inv_rvis_seq 
        FROM tpb_inv_rvis 
        WHERE n3pty_inv_no = out_n3pty_inv_no
        ;  

        ----- insert into tpb_invoice ------------------------------    
        INSERT INTO tpb_invoice ( 
            n3pty_inv_no, lst_n3pty_inv_rvis_seq, ofc_cd, n3pty_delt_tp_cd, lnk_n3pty_inv_no, 
            if_bl_no, cre_usr_id, cre_dt, upd_usr_id, upd_dt 
        ) VALUES ( 
            out_n3pty_inv_no, out_n3pty_inv_rvis_seq, in_user_ofc_cd, 'N', NULL, 
            out_n3pty_inv_no, in_user_id, SYSDATE, in_user_id, SYSDATE 
        ); 

        ----- insert into tpb_inv_rvis ------------------------------    
        INSERT INTO tpb_inv_rvis (
            n3pty_inv_no, n3pty_inv_rvis_seq, n3pty_inv_rvis_cd, n3pty_delt_tp_cd, co_nm, 
            ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, vndr_cust_div_cd, 
            vndr_cnt_cd, vndr_seq, cust_cnt_cd, cust_seq, vndr_cust_nm, 
            vndr_cust_addr, vndr_cust_eml, cty_nm, ste_cd, zip_cd, 
            fax_no, phn_no, vndr_cust_ref_rmk, usr_inp_ctnt1, usr_inp_ctnt2, 
            rcv_due_dt, rgst_no, inv_desc, inv_rmk1, inv_rmk2, 
            n3pty_inv_if_tp_cd, n3pty_inv_upd_flg, n3pty_inv_sts_cd, clt_agn_flg, clt_agn_rmk, 
            clt_agn_dt, ar_if_dt, curr_cd, mon_xch_rt, net_amt, 
            vat_amt, add_amt, ddct_amt, inv_amt, clt_amt, 
            clt_dt, inv_iss_locl_dt, inv_iss_gdt, inv_upd_locl_dt, inv_upd_gdt, 
            fax_eml_snd_no, if_bl_no, cre_usr_id, cre_dt, upd_usr_id, 
            upd_dt, ida_tax_seq
        ) VALUES (
            out_n3pty_inv_no, out_n3pty_inv_rvis_seq, 'ORG', 'N', NULL, 
            NULL, NULL, NULL, NULL, in_h_vndr_cust_div_cd, 
            in_vndr_cnt_cd, in_vndr_seq, in_cust_cnt_cd, in_cust_seq, in_vndr_cust_nm, 
            in_vndr_cust_addr, in_vndr_cust_eml, in_cty_nm, in_ste_cd, in_zip_cd, 
            in_fax_no, in_phn_no, in_vndr_cust_ref_rmk, in_usr_inp_ctnt1, in_usr_inp_ctnt2, 
            TO_DATE(in_rcv_due_dt,'YYYY-MM-DD'), in_rgst_no, in_inv_desc, NULL, NULL, 
            NULL, NULL, 'N', 'N', NULL, 
            NULL, NULL, in_curr_cd, TPB_GET_USD_XCH_RT_FNC(in_curr_cd, NVL(TPB_GET_LCL_DATE_FNC(SYSDATE,in_user_ofc_cd),SYSDATE) ), in_net_amt, 
            in_vat_amt, in_add_amt, in_ddct_amt, in_sum_inv_amt, NULL, 
            NULL, SYSDATE, SYSDATE, SYSDATE, SYSDATE, 
            NULL, out_n3pty_inv_no, in_user_id, SYSDATE, in_user_id, 
            SYSDATE, TO_NUMBER(in_ida_tax_seq)
        ); 
        
        UPDATE tpb_inv_rvis
        SET (co_nm, ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, inv_rmk1, inv_rmk2 ) 
            = ( SELECT co_nm, ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, inv_rmk1, inv_rmk2 
                FROM tpb_inv_sh_set       
                WHERE inv_iss_ofc_cd = in_user_ofc_cd AND ROWNUM = 1
              ) 
        WHERE n3pty_inv_no = out_n3pty_inv_no AND n3pty_inv_rvis_seq = out_n3pty_inv_rvis_seq 
        ; 
        
        TPB_INV_CRE_PKG.UPD_OTS_GRP_INFO(
            in_n3pty_no, out_n3pty_inv_no, in_user_ofc_cd, in_user_id ,in_curr_cd , in_sum_inv_amt);

    END IF; -------------------------------------------
    

--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
    

END
-- ===== End of Procedure ==================================
;


/*###############################################################################################
 *# CRE_INV_RVIS_DTL : CREATE TPB REVISION DETAIL DATA 
 *###############################################################################################*/
PROCEDURE CRE_INV_RVIS_DTL

-- ===== Arguments ========================================
(    
    in_n3pty_inv_no    IN VARCHAR2, 
    in_n3pty_inv_rvis_seq IN NUMBER, 
    in_user_ofc_cd       IN VARCHAR2, 
    in_user_id           IN VARCHAR2, 
    
    in_curr_cd      IN VARCHAR2, 

    in_n3pty_no IN VARCHAR2, 
    in_ots_dtl_seq IN VARCHAR2, 


    in_n3pty_bil_tp_cd IN VARCHAR2, 
    in_eq_knd_cd IN VARCHAR2, 
    in_eq_no IN VARCHAR2, 
    in_eq_tpsz_cd IN VARCHAR2, 
    in_new_eq_no IN VARCHAR2, 
    in_bkg_no IN VARCHAR2, 
    in_bl_no IN VARCHAR2, 
    in_vsl_cd IN VARCHAR2, 
    in_skd_voy_no IN VARCHAR2, 
    in_skd_dir_cd IN VARCHAR2, 
    in_yd_cd IN VARCHAR2, 
    in_fm_nod_cd IN VARCHAR2, 
    in_via_nod_cd IN VARCHAR2, 
    in_to_nod_cd IN VARCHAR2, 
    in_dor_nod_cd IN VARCHAR2, 
    in_new_cntr_seal_no IN VARCHAR2, 
    in_lst_free_dt IN VARCHAR2, 
    in_ots_amt IN VARCHAR2, 
    in_inv_dtl_amt IN VARCHAR2, 
    in_pkup_dt IN VARCHAR2, 
    in_ft_ovr_dys IN VARCHAR2, 
    in_cita_no IN VARCHAR2, 
    in_cntr_wgt IN VARCHAR2, 
    in_n3pty_cntr_wgt_ut_cd IN VARCHAR2, 
    in_wt_hrs IN VARCHAR2, 
    in_occr_dt IN VARCHAR2, 
    in_new_vsl_cd IN VARCHAR2, 
    in_new_bkg_no IN VARCHAR2, 
    in_acct_cd IN VARCHAR2, 
    in_lgs_cost_cd IN VARCHAR2, 
    in_so_no IN VARCHAR2, 
    in_estm_svr_id IN VARCHAR2, 
    in_finc_dir_cd IN VARCHAR2, 
    in_rev_amt IN VARCHAR2, 
    in_csr_no IN VARCHAR2, 
    in_gl_dt IN VARCHAR2, 
    in_vvd_cd IN VARCHAR2,
    in_vat_dtl_amt IN VARCHAR2
) 

IS 

-- ===== DECLARE ==========================================

-- ===== BEGIN, EXCEPTION & END ======================================
BEGIN

    ----- insert into tpb_invoice ------------------------------   
    INSERT INTO tpb_inv_rvis_dtl (
        n3pty_inv_no, n3pty_inv_rvis_seq, 
        n3pty_inv_rvis_dtl_seq, 
        n3pty_no, ots_dtl_seq, 
        n3pty_delt_tp_cd, n3pty_bil_tp_cd, eq_knd_cd, eq_no, eq_tpsz_cd, 
        bkg_no, bl_no, 
        vsl_cd, skd_voy_no, skd_dir_cd, finc_dir_cd, yd_cd, 
        fm_nod_cd, via_nod_cd, to_nod_cd, dor_nod_cd, new_eq_no, 
        new_cntr_seal_no, lst_free_dt, ots_amt, corr_ots_amt, rev_amt, 
        inv_dtl_amt, pkup_dt, ft_ovr_dys, cita_no, cntr_wgt, 
        n3pty_cntr_wgt_ut_cd, wt_hrs, occr_dt, new_vsl_cd, new_skd_voy_no, 
        new_skd_dir_cd, new_bkg_no, acct_cd, lgs_cost_cd, so_no, 
        csr_no, gl_dt, vvd_cd, estm_sys_area_grp_id, cre_usr_id, 
        cre_dt, upd_usr_id, upd_dt, vat_dtl_amt
    ) VALUES (
        in_n3pty_inv_no, in_n3pty_inv_rvis_seq, 
        ( SELECT NVL(MAX(n3pty_inv_rvis_dtl_seq),0)+1 
          FROM tpb_inv_rvis_dtl 
          WHERE n3pty_inv_no = in_n3pty_inv_no AND n3pty_inv_rvis_seq = in_n3pty_inv_rvis_seq 
        ), 
        in_n3pty_no, in_ots_dtl_seq, 
        'N', in_n3pty_bil_tp_cd, in_eq_knd_cd, in_eq_no, in_eq_tpsz_cd, 
        in_bkg_no, in_bl_no,
        in_vsl_cd, in_skd_voy_no, in_skd_dir_cd, in_finc_dir_cd, in_yd_cd, 
        in_fm_nod_cd, in_via_nod_cd, in_to_nod_cd, in_dor_nod_cd, in_new_eq_no, 
        in_new_cntr_seal_no, TO_DATE(in_lst_free_dt,'YYYY-MM-DD'), in_ots_amt, NULL, in_rev_amt, 
        in_inv_dtl_amt, TO_DATE(in_pkup_dt,'YYYY-MM-DD'), in_ft_ovr_dys, in_cita_no, in_cntr_wgt, 
        in_n3pty_cntr_wgt_ut_cd, in_wt_hrs, TO_DATE(in_occr_dt,'YYYY-MM-DD'), SUBSTRB(in_new_vsl_cd,1,4), SUBSTRB(in_new_vsl_cd,5,4), 
        SUBSTRB(in_new_vsl_cd,9,2), in_new_bkg_no, in_acct_cd, in_lgs_cost_cd, in_so_no, 
        in_csr_no, in_gl_dt, in_vvd_cd, in_estm_svr_id, in_user_id, 
        SYSDATE, in_user_id, SYSDATE, in_vat_dtl_amt
    ); 
    
    TPB_INV_CRE_PKG.UPD_OTS_DTL_INFO(
        in_n3pty_no, in_ots_dtl_seq, in_user_ofc_cd, in_user_id, in_curr_cd, in_inv_dtl_amt);


--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END
-- ===== End of Procedure ==================================
;

/*###############################################################################################
 *# UPD_OTS_GRP_INFO : UPDATE Outstanding Group Data 
 *###############################################################################################*/

PROCEDURE UPD_OTS_GRP_INFO


-- ===== Arguments ========================================
(    
    in_n3pty_no         IN VARCHAR2,
    in_n3pty_inv_no     IN VARCHAR2,

    in_user_ofc_cd      IN VARCHAR2,
    in_user_id          IN VARCHAR2,

    in_curr_cd          IN VARCHAR2, 
    in_sum_inv_amt      IN VARCHAR2 

) 

IS 

-- ===== DECLARE ==========================================

--    v_n3pty_no           TPB_OTS_GRP.n3pty_no%TYPE; 

-- ===== BEGIN, EXCEPTION & END ======================================
BEGIN

    --- Initiate varibles 
    
    --- ====== UPDATE TPB OUTSTANDING GROUP ===========
    UPDATE TPB_OTS_GRP B 
    SET n3pty_inv_no = in_n3pty_inv_no, 
        inv_amt = TPB_GET_INV_CURR_CHG_FNC(in_curr_cd, B.curr_cd, TO_NUMBER(in_sum_inv_amt), SYSDATE), 
        upd_usr_id = in_user_id, 
        upd_dt = SYSDATE
    WHERE n3pty_no = in_n3pty_no
    ; 

    --- ====== ADD OUTSTANDING GROUP STATUS ===========
    TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, 'I', in_user_id); 

    --- ====== ADD OUTSTANDING GROUP RECOVERY ACTIVITY ===========
    TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'','Invoice created.','A','',in_user_ofc_cd,in_user_id);


--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 

END
-- ===== End of Procedure ==================================
;


/*###############################################################################################
 *# UPD_OTS_DTL_INFO : UPDATE Outstanding Detail Data 
 *###############################################################################################*/

PROCEDURE UPD_OTS_DTL_INFO

-- ===== Arguments ========================================
(    
    in_n3pty_no         IN VARCHAR2,
    in_ots_dtl_seq      IN VARCHAR2, 

    in_user_ofc_cd      IN VARCHAR2,
    in_user_id          IN VARCHAR2,

    in_curr_cd          IN VARCHAR2, 
    in_inv_dtl_amt      IN VARCHAR2 
) 

IS 

-- ===== DECLARE ==========================================


-- ===== BEGIN, EXCEPTION & END ======================================
BEGIN

    --- Initiate varibles 
    
    --- ====== UPDATE TPB OUTSTANDING GROUP ===========
    UPDATE TPB_OTS_DTL A 
    SET inv_amt = TPB_GET_INV_CURR_CHG_FNC(in_curr_cd, A.cfm_curr_cd, TO_NUMBER(in_inv_dtl_amt), SYSDATE), 
        upd_usr_id = in_user_id, 
        upd_dt = SYSDATE
    WHERE ots_dtl_seq = in_ots_dtl_seq 
        AND n3pty_no = in_n3pty_no
    ; 

    --- ====== ADD OUTSTANDING GROUP STATUS ===========
    TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'I', in_user_id); 

    --- ====== ADD OUTSTANDING GROUP RECOVERY ACTIVITY ===========
    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',in_ots_dtl_seq,'','Invoice created.','A','',in_user_ofc_cd,in_user_id);

--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     
END
-- ===== End of Procedure ==================================
;




--#################################################################################################

END
-- ===== End of Package ==================================
;