CREATE OR REPLACE PACKAGE NISADM.TPB_INV_CRE_PKG 
 
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
                         2009.09.22  Park Sung-Jin      1.2  ALPS Migration 
                         2010.01.08  Sun, CHOI          1.3  EQ_TP_CD -> EQ_KND_CD 전환 
                         2010.06.09  Jong-Geon Byeon    1.4  TPB_INV_RVIS_DTl.VAT_DTL_AMT 추가 
                         2012.12.31  Jeong-Seon An      CHM-201220985 PSO에 대한 3자구상 개발관련 
                         2015.11-12  KIm Hyun-hwa       India SBC 금액정보 추가 
                         2016.05-19  KIm Hyun-hwa       India KKC 금액정보 추가 2016.06.01 적용 
                         2016.05-26  KIm Hyun-hwa       Microsoft  EDI 전송용 Load Id 추가 
                         2016.07-18  Song Jeong-In      Billing Type Code 별 Add Amount 추가(VGM) 
*******************************************************************************/ 
 
    --- CREATE TPB INVOICE MAIN, REVISION DATA  
    PROCEDURE CRE_INV_RVIS( 
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
        in_locl_tax_amt IN VARCHAR2, --2015-11-12  India SBC charge 
        in_n2nd_locl_tax_amt IN VARCHAR2,  --2016-06-01 적용 KKC 
         
        out_n3pty_inv_no    OUT VARCHAR2, -------- 
        out_n3pty_inv_rvis_seq OUT VARCHAR2 -------- 
    ); 
     
    --- CREATE TPB REVISION DETAIL DATA  
    PROCEDURE CRE_INV_RVIS_DTL( 
 
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
        in_vat_dtl_amt IN VARCHAR2 , 
        in_lod_id IN VARCHAR2,   
        in_inv_dtl_add_amt IN VARCHAR2 
    ); 
 
    --- UPDATE Outstanding Group Data  
    PROCEDURE UPD_OTS_GRP_INFO( 
        in_n3pty_no         IN VARCHAR2, 
        in_n3pty_inv_no     IN VARCHAR2, 
 
        in_user_ofc_cd      IN VARCHAR2, 
        in_user_id          IN VARCHAR2, 
 
        in_curr_cd          IN VARCHAR2,  
        in_sum_inv_amt      IN VARCHAR2  
    ); 
     
    --- UPDATE Outstanding Detail Data  
    PROCEDURE UPD_OTS_DTL_INFO( 
        in_n3pty_no         IN VARCHAR2, 
        in_ots_dtl_seq      IN VARCHAR2,  
 
        in_user_ofc_cd      IN VARCHAR2, 
        in_user_id          IN VARCHAR2, 
 
        in_curr_cd          IN VARCHAR2,  
        in_inv_dtl_amt      IN VARCHAR2  
    ); 
 
END 
 
-- ===== End of Pakage ================================== 
;