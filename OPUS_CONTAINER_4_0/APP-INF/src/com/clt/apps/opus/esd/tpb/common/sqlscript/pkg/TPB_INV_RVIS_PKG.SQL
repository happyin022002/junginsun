CREATE OR REPLACE PACKAGE OPUSADM."TPB_INV_RVIS_PKG" 

IS
/*******************************************************************************
   1. Object Name      : TPB_INV_RVIS_PKG
   2. Version          : 1.3
   3. Create Date      : 2008.10.06
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : TPB Invoice Revision Package
                         ------------------------------------------------------
                         DECLARE 

                         BEGIN 
                             TPB_INV_RVIS_PKG...1. (,,,,) ;
                             TPB_INV_RVIS_PKG...2. (,,,,) ;
                             TPB_INV_RVIS_PKG...3. (,,,,) ;
                         END; 
                         ------------------------------------------------------
   7. Revision History : 2008.10.06  Kim Jin-seung  1.0  Created
                         2009.05.28  O Wan-Ki       1.1  Modified
                         2009.10.05  Park Sung-Jin  1.2  Migration
                         2010.01.08  Sun, CHOI      1.3  EQ_TP_CD -> EQ_KND_CD 전환
*******************************************************************************/


    --- UPDATE TPB INVOICE MAIN, REVISION DATA 
    PROCEDURE UPD_INV_RVIS(
        in_user_ofc_cd           IN VARCHAR2,
        in_user_id          IN VARCHAR2,
        
        in_n3pty_no     IN VARCHAR2,
        in_n3pty_inv_no    IN VARCHAR2, --------
        in_n3pty_inv_rvis_seq IN VARCHAR2, 
    --    in_bil_tp_cd           IN VARCHAR2, 
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
        
        in_clt_agn_flg IN VARCHAR2, 
        in_clt_agn_rmk IN VARCHAR2, 

		in_ida_tax_seq IN VARCHAR2, --2009-05-28
        
        out_n3pty_inv_no    OUT VARCHAR2, --------
        out_new_rvis_seq OUT VARCHAR2, --------
        out_new_rvis_cd OUT VARCHAR2, --------
        out_new_creditnote_seq OUT VARCHAR2, -------- credit note 
        out_new_creditnote_cd OUT VARCHAR2 -------- credit note 
    );
    
    --- UPDATE TPB REVISION DETAIL DATA 
    PROCEDURE UPD_INV_RVIS_DTL(
        in_n3pty_inv_no    IN VARCHAR2, 
        in_n3pty_inv_rvis_seq IN NUMBER, 
        in_user_id           IN VARCHAR2, 

        in_n3pty_no IN VARCHAR2, 
--        in_n3pty_inv_rvis_dtl_seq IN NUMBER, 
        in_ots_dtl_seq IN VARCHAR2, 

        in_new_rvis_seq IN VARCHAR2, --------
        in_new_rvis_cd IN VARCHAR2, --------
        in_new_creditnote_seq IN VARCHAR2, -------- credit note 
        in_new_creditnote_cd IN VARCHAR2, -------- credit note 

--        in_n3pty_bil_tp_cd IN VARCHAR2, 
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
    );

    --- UPDATE Outstanding Group Data 
    PROCEDURE UPD_OTS_GRP_INFO(
        in_n3pty_no         IN VARCHAR2,
        in_n3pty_inv_no     IN VARCHAR2,

        in_new_rvis_seq     IN VARCHAR2, --------
        in_new_rvis_cd      IN VARCHAR2, --------
        in_new_creditnote_seq IN VARCHAR2, -------- credit note 
        in_new_creditnote_cd IN VARCHAR2, -------- credit note 

        in_user_ofc_cd      IN VARCHAR2,
        in_user_id          IN VARCHAR2,

        in_curr_cd          IN VARCHAR2, 
        in_sum_inv_amt      IN VARCHAR2, 
        
        in_clt_agn_flg      IN VARCHAR2 
    );
    
    --- UPDATE Outstanding Detail Data 
    PROCEDURE UPD_OTS_DTL_INFO(
        in_n3pty_no         IN VARCHAR2,
        in_ots_dtl_seq      IN VARCHAR2, 

        in_new_rvis_seq     IN VARCHAR2, --------
        in_new_rvis_cd      IN VARCHAR2, --------
        in_new_creditnote_seq IN VARCHAR2, -------- credit note 
        in_new_creditnote_cd IN VARCHAR2, -------- credit note 

        in_user_ofc_cd      IN VARCHAR2,
        in_user_id          IN VARCHAR2,

        in_curr_cd          IN VARCHAR2, 
        in_inv_dtl_amt      IN VARCHAR2, 
        
        in_clt_agn_flg      IN VARCHAR2 
    );

    --- UPDATE Invoice Revision Issue Data  
    PROCEDURE UPD_INV_RVIS_ISSUE (
        in_n3pty_inv_no     IN VARCHAR2,
        in_now_rvis_seq     IN VARCHAR2, --------
        in_now_rvis_cd      IN VARCHAR2, --------
    
        in_n3pty_inv_if_tp_cd  IN VARCHAR2,
        in_n3pty_inv_if_tp_nm  IN VARCHAR2, 
        in_fax_eml_snd_no      IN VARCHAR2, 
        in_contact_info      IN VARCHAR2,  
        
        in_user_ofc_cd      IN VARCHAR2,
        in_user_id          IN VARCHAR2
    );

    --- UPDATE Invoice Revision ERP A/R I/F Data  
    PROCEDURE UPD_INV_RVIS_ERPIF (
        in_n3pty_inv_no     IN VARCHAR2,
        in_now_rvis_seq     IN VARCHAR2, --------
    
        in_user_ofc_cd      IN VARCHAR2,
        in_user_id          IN VARCHAR2,

        out_erpif_rvis_seq OUT VARCHAR2, -------- rvis_seq to do erp i/f 
        out_erpif_rvis_cd OUT VARCHAR2, -------- rvis_seq to do erp i/f 
        out_erpif_creditnote_seq OUT VARCHAR2, -------- credit note seq to do erp i/f 
        out_erpif_creditnote_cd OUT VARCHAR2 -------- credit note seq to do erp i/f 
    
    );

END

-- ===== End of Pakage ==================================
;