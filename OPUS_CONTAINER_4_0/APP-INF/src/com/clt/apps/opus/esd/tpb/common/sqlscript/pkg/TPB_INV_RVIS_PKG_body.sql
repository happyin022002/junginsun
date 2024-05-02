CREATE OR REPLACE PACKAGE BODY OPUSADM."TPB_INV_RVIS_PKG"

IS
/*******************************************************************************
   1. Object Name      : TPB_INV_RVIS_PKGBODY
   2. Version          : 1.9
   3. Create Date      : 2008.09.30
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : TPB Invoice Revision Package Body 
                         ------------------------------------------------------
                         DECLARE 

                         BEGIN 
                             TPB_INV_UPD...1. (,,,,) ;
                             TPB_INV_UPD_PKG...2. (,,,,) ;
                             TPB_INV_UPD_PKG...3. (,,,,) ;
                         END; 
                         ------------------------------------------------------
   7. Revision History : 2008.10.06  Kim Jin-seung   1.0  Created
                         2008.11.21  Kim Jin-seung   1.1  Credit note check
                         2008.11.26  Kim Jin-seung   1.2  Group Status
                         2009.01.30  O Wan-Ki        1.3  TPB
                         2009.04.27  O Wan-Ki        1.4  N200904160080, ctnt1/ctnt2/ref_rmk modification on Invoice
                         2009.04.27  O Wan-Ki        1.5  Add ida_tax_seq 
                         2009.05.28  O Wan-Ki        1.6  Modified
                         2009.10.05  Park Sung-Jin   1.7  Migration
                         2010.01.08  Sun, CHOI       1.8  EQ_TP_CD -> EQ_KND_CD 전환
                         2010.02.10  Jong-Geon Byeon 1.9  PROCEDURE UPD_INV_RVIS : TPB_INV_RVIS 테이블의 Rivision 데이터의 CURR_CD컬럼 값을 파라미터로 받아온 값으로 변경(curr_cd -> in_curr_cd)
*******************************************************************************/


/*###############################################################################################
 *# UPD_INV_RVIS : UPDATE TPB INVOICE MAIN, REVISION DATA 
 *###############################################################################################*/

PROCEDURE UPD_INV_RVIS

-- ===== Arguments ========================================
(    
    in_user_ofc_cd           IN VARCHAR2,
    in_user_id          IN VARCHAR2,
    in_n3pty_no     IN VARCHAR2,
    in_n3pty_inv_no    IN VARCHAR2, --------
    in_n3pty_inv_rvis_seq IN VARCHAR2, 
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
) 

IS 

-- ===== DECLARE ==========================================
    v_n3pty_inv_no tpb_invoice.n3pty_inv_no%TYPE; -- temp TPB Inv No.

    v_now_rvis_seq           tpb_inv_rvis.n3pty_inv_rvis_seq%TYPE; 
    v_now_rvis_cd            tpb_inv_rvis.n3pty_inv_rvis_cd%TYPE; 


-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

    --- Initiate varibles 

    --- ====== get tpb invoice info =========== 
    SELECT n3pty_inv_no 
    INTO out_n3pty_inv_no  
    FROM tpb_invoice
    WHERE n3pty_inv_no = in_n3pty_inv_no 
    FOR UPDATE NOWAIT 
    ; 
    
    SELECT -- v.n3pty_inv_no, 
        v.lst_n3pty_inv_rvis_seq AS now_rvis_seq, 
        r.n3pty_inv_rvis_cd AS now_rvis_cd, 
        DECODE( SUBSTRB(r.n3pty_inv_rvis_cd,1,1), 'C', 0, r.n3pty_inv_rvis_seq+1 ) AS new_creditnote_seq, 
        CASE 
            WHEN v.n3pty_delt_tp_cd != 'N' 
                THEN NULL 
            WHEN r.n3pty_inv_rvis_cd = 'ORG' OR r.n3pty_inv_rvis_cd IS NULL 
                THEN 'C01' 
            WHEN SUBSTRB(n3pty_inv_rvis_cd,1,1) = 'R' AND TO_NUMBER(SUBSTRB(n3pty_inv_rvis_cd,2,2))+1 < 100 
                THEN 'C'|| TRIM(LPAD(TO_CHAR(TO_NUMBER(SUBSTRB(n3pty_inv_rvis_cd,2,2))+1), 2, '0')) 
            WHEN SUBSTRB(n3pty_inv_rvis_cd,1,1) = 'R' AND TO_NUMBER(SUBSTRB(n3pty_inv_rvis_cd,2,2))+1 >= 100 
                THEN NULL 
            WHEN SUBSTRB(n3pty_inv_rvis_cd,1,1) != 'R' 
                THEN 'C01' 
        END AS new_creditnote_cd, 
        DECODE( SUBSTRB(r.n3pty_inv_rvis_cd,1,1), 'C', r.n3pty_inv_rvis_seq+1, r.n3pty_inv_rvis_seq+2 ) AS new_rvis_seq, 
        CASE 
            WHEN v.n3pty_delt_tp_cd != 'N' 
                THEN NULL 
            WHEN r.n3pty_inv_rvis_cd = 'ORG' OR r.n3pty_inv_rvis_cd IS NULL 
                THEN 'R01' 
            WHEN SUBSTRB(n3pty_inv_rvis_cd,1,1) = 'R' AND TO_NUMBER(SUBSTRB(n3pty_inv_rvis_cd,2,2))+1 < 100 
                THEN 'R'|| TRIM(LPAD(TO_CHAR(TO_NUMBER(SUBSTRB(n3pty_inv_rvis_cd,2,2))+1), 2, '0')) 
            WHEN SUBSTRB(n3pty_inv_rvis_cd,1,1) = 'R' AND TO_NUMBER(SUBSTRB(n3pty_inv_rvis_cd,2,2))+1 >= 100 
                THEN NULL 
            WHEN SUBSTRB(n3pty_inv_rvis_cd,1,1) != 'R' 
                THEN 'R01' 
        END AS new_rvis_cd 
    INTO v_now_rvis_seq, v_now_rvis_cd, 
         out_new_creditnote_seq, out_new_creditnote_cd, 
         out_new_rvis_seq, out_new_rvis_cd 
    FROM tpb_inv_rvis r, tpb_invoice v 
    WHERE 1=1 
        AND r.n3pty_inv_no = v.n3pty_inv_no
        AND r.n3pty_inv_rvis_seq = v.lst_n3pty_inv_rvis_seq 
        AND v.n3pty_inv_no = in_n3pty_inv_no 
--        AND 
    ;


    SELECT DECODE( COUNT(0), 0, out_new_creditnote_seq, NULL ) 
    INTO out_new_creditnote_seq 
    FROM tpb_inv_rvis r 
    WHERE 1=1
        AND n3pty_inv_no = in_n3pty_inv_no 
        AND n3pty_inv_rvis_seq = out_new_creditnote_seq
    ;


    --- ====== IF TPB INV NO. is valid ===========
    IF LENGTHB(in_n3pty_inv_no) = 11 THEN ----------------------

        
        ----- FOR CREDIT NOTE ------------------------------    
        IF TO_NUMBER(out_new_creditnote_seq) > 0 THEN ----------------------

            ----- update tpb_invoice ------------------------------    
    
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
                upd_dt, ida_tax_seq --2009-05-28
            ) 
            SELECT 
                n3pty_inv_no, out_new_creditnote_seq, out_new_creditnote_cd, n3pty_delt_tp_cd, co_nm, 
                ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, vndr_cust_div_cd, 
                vndr_cnt_cd, vndr_seq, cust_cnt_cd, cust_seq, vndr_cust_nm, 
                vndr_cust_addr, vndr_cust_eml, cty_nm, ste_cd, zip_cd, 
                fax_no, phn_no, vndr_cust_ref_rmk, usr_inp_ctnt1, usr_inp_ctnt2, 
                rcv_due_dt, rgst_no, inv_desc, inv_rmk1, inv_rmk2, 
                NULL n3pty_inv_if_tp_cd, n3pty_inv_upd_flg, 'N' n3pty_inv_sts_cd, clt_agn_flg, clt_agn_rmk, 
                NULL clt_agn_dt, NULL AS ar_if_dt, curr_cd, mon_xch_rt, (-1)*net_amt, 
                (-1)*vat_amt, (-1)*add_amt, (-1)*ddct_amt, (-1)*inv_amt, NULL AS clt_amt, 
                NULL AS clt_dt, SYSDATE inv_iss_locl_dt, SYSDATE inv_iss_gdt, SYSDATE inv_upd_locl_dt, SYSDATE inv_upd_gdt, 
                fax_eml_snd_no, if_bl_no, upd_usr_id, SYSDATE cre_dt, upd_usr_id, 
                SYSDATE upd_dt, in_ida_tax_seq --2009-05-28
            FROM tpb_inv_rvis r 
            WHERE r.n3pty_inv_no = in_n3pty_inv_no 
                AND r.n3pty_inv_rvis_seq = in_n3pty_inv_rvis_seq 
                AND r.n3pty_delt_tp_cd = 'N'
            ; 
            

            ----- insert into tpb_inv_rvis_dtl ------------------------------    
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
            ) 
            SELECT 
                n3pty_inv_no, out_new_creditnote_seq, 
                n3pty_inv_rvis_dtl_seq, 
                n3pty_no, ots_dtl_seq, 
                n3pty_delt_tp_cd, n3pty_bil_tp_cd, eq_knd_cd, eq_no, eq_tpsz_cd, 
                bkg_no, bl_no, 
                vsl_cd, skd_voy_no, skd_dir_cd, finc_dir_cd, yd_cd, 
                fm_nod_cd, via_nod_cd, to_nod_cd, dor_nod_cd, new_eq_no, 
                new_cntr_seal_no, lst_free_dt, ots_amt, corr_ots_amt, (-1)*rev_amt, 
                (-1)*inv_dtl_amt, pkup_dt, ft_ovr_dys, cita_no, cntr_wgt, 
                n3pty_cntr_wgt_ut_cd, wt_hrs, occr_dt, new_vsl_cd, new_skd_voy_no, 
                new_skd_dir_cd, new_bkg_no, acct_cd, lgs_cost_cd, so_no, 
                csr_no, gl_dt, vvd_cd, estm_sys_area_grp_id, in_user_id, 
                SYSDATE, in_user_id, SYSDATE, NVL(vat_dtl_amt,0)*(-1)
            FROM tpb_inv_rvis_dtl 
            WHERE n3pty_inv_no = in_n3pty_inv_no
                AND n3pty_inv_rvis_seq = in_n3pty_inv_rvis_seq
                AND n3pty_delt_tp_cd = 'N'
            ; 
            
        END IF; -------------------------------------------



        ----- FOR REVISION ------------------------------    
        
        ----- UPDATE tpb_invoice ------------------------------    
        UPDATE tpb_invoice 
        SET 
            lst_n3pty_inv_rvis_seq = TO_NUMBER(out_new_rvis_seq), 
            upd_usr_id = in_user_id, 
            upd_dt = SYSDATE 
        WHERE n3pty_inv_no = in_n3pty_inv_no 
        ;  

        ----- insert into tpb_inv_rvis ------------------------------    
        INSERT INTO tpb_inv_rvis (
            n3pty_inv_no, n3pty_inv_rvis_seq, n3pty_inv_rvis_cd, n3pty_delt_tp_cd, co_nm, 
            ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, vndr_cust_div_cd, 
            vndr_cnt_cd, vndr_seq, cust_cnt_cd, cust_seq, vndr_cust_nm, 
            vndr_cust_addr, vndr_cust_eml, cty_nm, ste_cd, zip_cd, 
            fax_no, phn_no, vndr_cust_ref_rmk, usr_inp_ctnt1, usr_inp_ctnt2, 
            rcv_due_dt, rgst_no, inv_desc, inv_rmk1, inv_rmk2, 
            n3pty_inv_if_tp_cd, n3pty_inv_upd_flg, n3pty_inv_sts_cd, clt_agn_flg, clt_agn_rmk, 
            clt_agn_dt, ar_if_dt, curr_cd, 
            mon_xch_rt, net_amt, 
            vat_amt, add_amt, ddct_amt, inv_amt, clt_amt, 
            clt_dt, inv_iss_locl_dt, inv_iss_gdt, inv_upd_locl_dt, inv_upd_gdt, 
            fax_eml_snd_no, if_bl_no, cre_usr_id, cre_dt, upd_usr_id, 
            upd_dt, ida_tax_seq --2009-05-28
        ) 
        SELECT 
            r.n3pty_inv_no, out_new_rvis_seq, out_new_rvis_cd, r.n3pty_delt_tp_cd, co_nm, 
            ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, in_h_vndr_cust_div_cd, 
            in_vndr_cnt_cd, in_vndr_seq, in_cust_cnt_cd, in_cust_seq, in_vndr_cust_nm, 
            in_vndr_cust_addr, in_vndr_cust_eml, in_cty_nm, in_ste_cd, in_zip_cd, 
            in_fax_no, in_phn_no, 
			
			/* 2009-04-27 O Wan-Ki N200904160080 vndr_cust_ref_rmk, usr_inp_ctnt1, usr_inp_ctnt2, -> in_vndr_cust_ref_rmk, in_usr_inp_ctnt1, in_usr_inp_ctnt2, */
			in_vndr_cust_ref_rmk, in_usr_inp_ctnt1, in_usr_inp_ctnt2, 
            
			TO_DATE(in_rcv_due_dt,'YYYY-MM-DD'), rgst_no, in_inv_desc, inv_rmk1, inv_rmk2, 
            NULL n3pty_inv_if_tp_cd, n3pty_inv_upd_flg, 'N' n3pty_inv_sts_cd, clt_agn_flg, clt_agn_rmk, 
            clt_agn_dt, NULL AS ar_if_dt, in_curr_cd, 
            TPB_GET_USD_XCH_RT_FNC(in_curr_cd,NVL(TPB_GET_LCL_DATE_FNC(SYSDATE,v.ofc_cd),SYSDATE)), in_net_amt, 
            in_vat_amt, in_add_amt, in_ddct_amt, in_sum_inv_amt, NULL AS clt_amt, 
            NULL AS clt_dt, SYSDATE inv_iss_locl_dt, SYSDATE inv_iss_gdt, SYSDATE inv_upd_locl_dt, SYSDATE inv_upd_gdt, 
            fax_eml_snd_no, r.if_bl_no, in_user_id, SYSDATE cre_dt, in_user_id, 
            SYSDATE upd_dt, ida_tax_seq --2009-05-28
        FROM tpb_inv_rvis r, tpb_invoice v 
        WHERE r.n3pty_inv_no = v.n3pty_inv_no  
            AND r.n3pty_inv_no = in_n3pty_inv_no 
            AND r.n3pty_inv_rvis_seq = in_n3pty_inv_rvis_seq 
            AND r.n3pty_delt_tp_cd = 'N'
        ; 
        
        UPDATE tpb_inv_rvis
        SET clt_agn_flg = NVL(in_clt_agn_flg,'N'), 
            clt_agn_rmk = in_clt_agn_rmk, 
            clt_agn_dt = DECODE( NVL(in_clt_agn_flg,'N'), 'Y', SYSDATE), 
            (co_nm, ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, inv_rmk1, inv_rmk2 ) 
            = ( SELECT co_nm, ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, inv_rmk1, inv_rmk2 
                FROM tpb_inv_sh_set       
                WHERE inv_iss_ofc_cd = in_user_ofc_cd AND ROWNUM = 1
              ) 
        WHERE n3pty_inv_no = in_n3pty_inv_no 
            AND n3pty_inv_rvis_seq = out_new_rvis_seq 
        ; 
        
        
        TPB_INV_RVIS_PKG.UPD_OTS_GRP_INFO(
            in_n3pty_no, in_n3pty_inv_no, out_new_rvis_seq, out_new_rvis_cd
            , out_new_creditnote_seq, out_new_creditnote_cd, in_user_ofc_cd
            , in_user_id, in_curr_cd, in_sum_inv_amt, in_clt_agn_flg )
        ;
            
    END IF; -------------------------------------------

    

--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END
-- ===== End of Procedure ==================================
;


/*###############################################################################################
 *# UPDATE_INV_RVIS_DTL : UPDATE TPB REVISION DETAIL DATA 
 *###############################################################################################*/

PROCEDURE UPD_INV_RVIS_DTL

-- ===== Arguments ========================================
(    
    in_n3pty_inv_no    IN VARCHAR2, 
    in_n3pty_inv_rvis_seq IN NUMBER, 
    in_user_id           IN VARCHAR2, 

    in_n3pty_no IN VARCHAR2, 
--    in_n3pty_inv_rvis_dtl_seq IN NUMBER, 
    in_ots_dtl_seq IN VARCHAR2, 

    in_new_rvis_seq IN VARCHAR2, --------
    in_new_rvis_cd IN VARCHAR2, --------
    in_new_creditnote_seq IN VARCHAR2, -------- credit note 
    in_new_creditnote_cd IN VARCHAR2, -------- credit note 


--    in_n3pty_bil_tp_cd IN VARCHAR2, 
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


    ----- FOR REVISION 

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
    ) 
    SELECT 
        n3pty_inv_no, in_new_rvis_seq, 
        n3pty_inv_rvis_dtl_seq, 
        n3pty_no, ots_dtl_seq, 
        n3pty_delt_tp_cd, n3pty_bil_tp_cd, eq_knd_cd, eq_no, eq_tpsz_cd, 
        bkg_no, bl_no,
        vsl_cd, skd_voy_no, skd_dir_cd, finc_dir_cd, yd_cd, 
        fm_nod_cd, via_nod_cd, to_nod_cd, dor_nod_cd, in_new_eq_no, 
        in_new_cntr_seal_no,  TO_DATE(in_lst_free_dt,'YYYY-MM-DD'), in_ots_amt, corr_ots_amt, rev_amt, 
        in_inv_dtl_amt, TO_DATE(in_pkup_dt,'YYYY-MM-DD'), in_ft_ovr_dys, in_cita_no, in_cntr_wgt, 
        in_n3pty_cntr_wgt_ut_cd, in_wt_hrs, TO_DATE(in_occr_dt,'YYYY-MM-DD'), SUBSTRB(in_new_vsl_cd,1,4), SUBSTRB(in_new_vsl_cd,5,4), 
        SUBSTRB(in_new_vsl_cd,9,2), in_new_bkg_no, in_acct_cd, in_lgs_cost_cd, so_no, 
        csr_no, gl_dt, vvd_cd, estm_sys_area_grp_id, in_user_id, 
        SYSDATE, in_user_id, SYSDATE, in_vat_dtl_amt
    FROM tpb_inv_rvis_dtl 
    WHERE n3pty_inv_no = in_n3pty_inv_no
        AND n3pty_inv_rvis_seq = in_n3pty_inv_rvis_seq 
        AND ots_dtl_seq = in_ots_dtl_seq 
        -- AND n3pty_inv_rvis_dtl_seq = in_n3pty_inv_rvis_dtl_seq 
        AND n3pty_delt_tp_cd = 'N'
    ; 
    

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

    in_new_rvis_seq     IN VARCHAR2, --------
    in_new_rvis_cd      IN VARCHAR2, --------
    in_new_creditnote_seq IN VARCHAR2, -------- credit note 
    in_new_creditnote_cd IN VARCHAR2, -------- credit note 

    in_user_ofc_cd      IN VARCHAR2,
    in_user_id          IN VARCHAR2,

    in_curr_cd          IN VARCHAR2, 
    in_sum_inv_amt      IN VARCHAR2, 
    
    in_clt_agn_flg      IN VARCHAR2 
) 

IS 

-- ===== DECLARE ==========================================

    v_lst_ots_sts       TPB_OTS_GRP_STS.ots_sts_cd%TYPE;
    v_act_rmk           TPB_OTS_GRP_RCVR_ACT.ACT_RMK%TYPE;


-- ===== BEGIN, EXCEPTION & END ======================================
BEGIN

    --- Initiate varibles 
    
    --- ====== UPDATE TPB OUTSTANDING GROUP ===========
    UPDATE TPB_OTS_GRP B 
    SET 
        inv_amt = TPB_GET_INV_CURR_CHG_FNC(in_curr_cd, B.curr_cd, TO_NUMBER(in_sum_inv_amt), SYSDATE), 
        clt_amt = 0,
        bal_amt = (ots_amt - NVL(adj_amt,0)),
        upd_usr_id = in_user_id, 
        upd_dt = SYSDATE
    WHERE 1=1
        AND n3pty_no = in_n3pty_no 
        AND n3pty_inv_no = in_n3pty_inv_no 
        AND n3pty_delt_tp_cd = 'N' 
    ; 

    --- STATUS CHECK ------
    SELECT ots_sts_cd
    INTO v_lst_ots_sts 
    FROM TPB_OTS_GRP_STS 
    WHERE n3pty_no = in_n3pty_no 
        AND ots_sts_lst_flg = 'Y' 
    ;

    --- ====== ADD OUTSTANDING GROUP STATUS ===========
    IF ( in_clt_agn_flg='Y' AND v_lst_ots_sts!='Y' ) THEN --- I=>Y
        TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, 'Y', in_user_id); 
        
    ELSIF ( in_clt_agn_flg!='Y' AND v_lst_ots_sts='Y' ) THEN  ---- Y=>I
        TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, 'I', in_user_id); 
        
    ELSIF ( v_lst_ots_sts='E' OR v_lst_ots_sts='L' OR v_lst_ots_sts='A' ) THEN 
        TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, 'I', in_user_id); 

    END IF; 

    --- ====== ADD OUTSTANDING GROUP RECOVERY ACTIVITY ===========
    --- FOR CREDIT NOTE
    IF TO_NUMBER(in_new_creditnote_seq) > 0 THEN 
        v_act_rmk := 'The Credit Note  ['||in_new_creditnote_cd||'] was revised.'; 
        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);    
    END IF; 

    --- FOR REVISION 
    IF ( in_clt_agn_flg='Y' AND v_lst_ots_sts!='Y' ) THEN --- I=>Y
        v_act_rmk := 'Transfered to Collection Agency or Legal Action. '||'['||in_new_rvis_cd||']'; 
        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);
        
    ELSIF ( in_clt_agn_flg!='Y' AND v_lst_ots_sts='Y' ) THEN  ---- Y=>I
        v_act_rmk := 'Cancelled transferring to Collection Agency or Legal Action.'||'['||in_new_rvis_cd||']'; 
        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);

    ELSE 
        v_act_rmk := 'Revision version '||'['||in_new_rvis_cd||'] was revised.'; 
        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);

    END IF; 



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

    in_new_rvis_seq     IN VARCHAR2, --------
    in_new_rvis_cd      IN VARCHAR2, --------
    in_new_creditnote_seq IN VARCHAR2, -------- credit note 
    in_new_creditnote_cd IN VARCHAR2, -------- credit note 

    in_user_ofc_cd      IN VARCHAR2,
    in_user_id          IN VARCHAR2,

    in_curr_cd          IN VARCHAR2, 
    in_inv_dtl_amt      IN VARCHAR2, 
    
    in_clt_agn_flg      IN VARCHAR2 
) 

IS 

-- ===== DECLARE ==========================================

    v_lst_ots_sts       TPB_OTS_GRP_STS.ots_sts_cd%TYPE;
    v_act_rmk           TPB_OTS_GRP_RCVR_ACT.ACT_RMK%TYPE;

-- ===== BEGIN, EXCEPTION & END ======================================
BEGIN

    --- Initiate varibles 
    
    --- ====== UPDATE TPB OUTSTANDING DETAIL ===========
    UPDATE TPB_OTS_DTL A 
    SET inv_amt = TPB_GET_INV_CURR_CHG_FNC(in_curr_cd, A.cfm_curr_cd, TO_NUMBER(in_inv_dtl_amt), SYSDATE), 
        clt_amt = 0,
        bal_amt = (ots_amt - NVL(adj_amt,0)),
        upd_usr_id = in_user_id, 
        upd_dt = SYSDATE
    WHERE ots_dtl_seq = in_ots_dtl_seq 
        AND n3pty_no = in_n3pty_no
    ; 


    --- STATUS CHECK ------
    SELECT ots_sts_cd
    INTO v_lst_ots_sts 
    FROM TPB_OTS_GRP_STS 
    WHERE n3pty_no = in_n3pty_no 
        AND ots_sts_lst_flg = 'Y' 
    ;


    --- ====== ADD OUTSTANDING DETAIL STATUS ===========
    IF ( in_clt_agn_flg='Y' AND v_lst_ots_sts!='Y' ) THEN --- I=>Y
        TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'Y', in_user_id);  
        
    ELSIF ( in_clt_agn_flg!='Y' AND v_lst_ots_sts='Y' ) THEN  ---- Y=>I
        TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'I', in_user_id); 

    ELSIF ( v_lst_ots_sts='E' OR v_lst_ots_sts='L' OR v_lst_ots_sts='A' ) THEN 
        TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'I', in_user_id); 
        
    END IF; 

    --- ====== ADD OUTSTANDING DETAIL RECOVERY ACTIVITY ===========
    --- FOR CREDIT NOTE
    IF TO_NUMBER(in_new_creditnote_seq) > 0 THEN 
        v_act_rmk := 'The Credit Note  ['||in_new_creditnote_cd||'] was revised.'; 
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',in_ots_dtl_seq,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);
    END IF; 

    --- FOR REVISION 
    IF ( in_clt_agn_flg='Y' AND v_lst_ots_sts!='Y' ) THEN --- I=>Y
        v_act_rmk := 'Transfered to Collection Agency or Legal Action. '||'['||in_new_rvis_cd||']'; 
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',in_ots_dtl_seq,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);
        
    ELSIF ( in_clt_agn_flg!='Y' AND v_lst_ots_sts='Y' ) THEN  ---- Y=>I
        v_act_rmk := 'Cancelled transferring to Collection Agency or Legal Action.'||'['||in_new_rvis_cd||']'; 
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',in_ots_dtl_seq,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);

    ELSE 
        v_act_rmk := 'Revision version '||'['||in_new_rvis_cd||'] was revised.'; 
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',in_ots_dtl_seq,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);

    END IF; 
--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END
-- ===== End of Procedure ==================================
;


/*###############################################################################################
 *# UPD_INV_RVIS_ISSUE : UPDATE Invoice Revision Issue Data 
 *###############################################################################################*/

PROCEDURE UPD_INV_RVIS_ISSUE

-- ===== Arguments ========================================
(    
    in_n3pty_inv_no     IN VARCHAR2,
    in_now_rvis_seq     IN VARCHAR2, --------
    in_now_rvis_cd      IN VARCHAR2, --------

    in_n3pty_inv_if_tp_cd  IN VARCHAR2,
    in_n3pty_inv_if_tp_nm  IN VARCHAR2, 
    in_fax_eml_snd_no      IN VARCHAR2, 
    in_contact_info      IN VARCHAR2,  
    
    in_user_ofc_cd      IN VARCHAR2,
    in_user_id          IN VARCHAR2
) 

IS 

-- ===== DECLARE ==========================================

    v_n3pty_no          TPB_OTS_GRP.n3pty_no%TYPE;
    v_lst_ots_sts       TPB_OTS_GRP_STS.ots_sts_cd%TYPE;
    v_act_rmk           TPB_OTS_GRP_RCVR_ACT.ACT_RMK%TYPE;

-- ===== BEGIN, EXCEPTION & END ======================================
BEGIN

    --- Initiate varibles 
    v_n3pty_no := NULL;
    
    --- ====== UPDATE TPB REVISION INFO ===========
    UPDATE TPB_INV_RVIS 
    SET n3pty_inv_if_tp_cd = in_n3pty_inv_if_tp_cd, 
        fax_eml_snd_no = in_fax_eml_snd_no,                            -- FAX, EMAIL KEY？？蹂？UPDATE  		
        vndr_cust_eml = DECODE(in_n3pty_inv_if_tp_cd,'E',in_contact_info,vndr_cust_eml), -- vndr_cust_eml 
        fax_no = DECODE(in_n3pty_inv_if_tp_cd,'F',in_contact_info,fax_no), 
        n3pty_inv_upd_flg = 'N',                       -- ？ㅼ？？ Update Flag瑜？N ？쇰？ ？？？？.
        upd_usr_id = in_user_id,  
        upd_dt = SYSDATE 
    WHERE n3pty_inv_no = in_n3pty_inv_no 
        AND n3pty_inv_rvis_seq = in_now_rvis_seq 
        AND n3pty_delt_tp_cd = 'N' 
    ; 

    --- ====== GET TPB_NO =================
    SELECT ( SELECT n3pty_no FROM TPB_OTS_GRP WHERE n3pty_inv_no = in_n3pty_inv_no AND ROWNUM = 1 ) AS n3pty_no 
    INTO v_n3pty_no
    FROM DUAL 
    ; 

    --- ====== ADD OUTSTANDING GROUP/DETAIL RECOVERY ACTIVITY ===========
    IF v_n3pty_no IS NOT NULL AND LENGTHB(v_n3pty_no) > 0 THEN 
        v_act_rmk := 'Invoice Version ['||in_now_rvis_cd||'] Issued by '||in_n3pty_inv_if_tp_nm||'. '; 
        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);    
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',v_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);
    END IF; 


--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END
-- ===== End of Procedure ==================================
;


/*###############################################################################################
 *# UPD_INV_RVIS_ERPIF : UPDATE Invoice Revision ERP A/R I/F Data 
 *###############################################################################################*/

PROCEDURE UPD_INV_RVIS_ERPIF

-- ===== Arguments ========================================
(    
    in_n3pty_inv_no     IN VARCHAR2,
    in_now_rvis_seq     IN VARCHAR2, --------

    in_user_ofc_cd      IN VARCHAR2,
    in_user_id          IN VARCHAR2,

    out_erpif_rvis_seq OUT VARCHAR2, -------- rvis_seq to do erp i/f 
    out_erpif_rvis_cd OUT VARCHAR2, -------- rvis_seq to do erp i/f 
    out_erpif_creditnote_seq OUT VARCHAR2, -------- credit note seq to do erp i/f 
    out_erpif_creditnote_cd OUT VARCHAR2 -------- credit note seq to do erp i/f 
) 

IS 

-- ===== DECLARE ==========================================

    v_n3pty_no          TPB_OTS_GRP.n3pty_no%TYPE;
--    v_lst_ots_sts       TPB_OTS_GRP_STS.ots_sts_cd%TYPE;
    v_act_rmk           TPB_OTS_GRP_RCVR_ACT.ACT_RMK%TYPE;
    
    n_grp_bal_amt       TPB_OTS_GRP.bal_amt%TYPE;
    
    v_base_rvis_seq  TPB_INV_RVIS.n3pty_inv_rvis_seq%TYPE;
    v_base_rvis_cd  TPB_INV_RVIS.n3pty_inv_rvis_cd%TYPE;


-- ===== BEGIN, EXCEPTION & END ======================================
BEGIN

    --- Initiate varibles 
    v_n3pty_no := NULL;
    v_base_rvis_seq := NULL;
    v_base_rvis_cd := NULL; 
    
    
    SELECT n3pty_inv_rvis_cd 
    INTO v_base_rvis_cd 
    FROM TPB_INV_RVIS R, TPB_INVOICE V 
    WHERE 1=1 
        AND R.n3pty_inv_no = V.n3pty_inv_no 
        AND R.n3pty_inv_no=in_n3pty_inv_no
        AND R.n3pty_inv_rvis_seq = in_now_rvis_seq
    ; 
    
    --- DECIDE ... ERP I/F CASE 
    SELECT MAX(n3pty_inv_rvis_seq) n3pty_inv_rvis_seq 
    INTO v_base_rvis_seq 
    FROM TPB_INV_RVIS R, TPB_INVOICE V 
    WHERE 1=1 
        AND R.n3pty_inv_no = V.n3pty_inv_no 
        AND R.n3pty_inv_no=in_n3pty_inv_no
        AND R.n3pty_inv_sts_cd = 'A' 
    ; 
    
    IF v_base_rvis_seq IS NOT NULL AND v_base_rvis_seq > 0 THEN 
    
        SELECT n3pty_inv_rvis_cd  
        INTO v_base_rvis_cd 
        FROM TPB_INV_RVIS R, TPB_INVOICE V 
        WHERE 1=1 
            AND R.n3pty_inv_no = V.n3pty_inv_no 
            AND R.n3pty_inv_no=in_n3pty_inv_no
            AND R.n3pty_inv_rvis_seq = v_base_rvis_seq 
        ; 
        
    END IF; 
    
    
    ----- 湲곗？ rvis_seq濡？erp i/f？？rvis_seq 援ы？？湲？
--    out_erpif_rvis_seq OUT VARCHAR2, -------- rvis_seq to do erp i/f 
--    out_erpif_rvis_cd OUT VARCHAR2, -------- rvis_seq to do erp i/f 
--    out_erpif_creditnote_seq OUT VARCHAR2, -------- credit note seq to do erp i/f 
--    out_erpif_creditnote_cd OUT VARCHAR2, -------- credit note seq to do erp i/f 
    
    
    out_erpif_rvis_seq := in_now_rvis_seq; 
    
    SELECT n3pty_inv_rvis_cd  
    INTO out_erpif_rvis_cd  
    FROM TPB_INV_RVIS R, TPB_INVOICE V 
    WHERE 1=1 
        AND R.n3pty_inv_no = V.n3pty_inv_no 
        AND R.n3pty_inv_no=in_n3pty_inv_no
        AND R.n3pty_inv_rvis_seq = out_erpif_rvis_seq 
    ; 

    --- 理？醫？ erp i/f媛？ ？？嫄간엔？xx？대㈃ 泥？由В엔엔엔엔엔？rp i/f？？Cxx？？？？？？  
    IF ( v_base_rvis_cd IS NULL OR SUBSTRB(v_base_rvis_cd,1,1) = 'C' ) THEN  --- none, Cxx 
        out_erpif_creditnote_seq := NULL;
        out_erpif_creditnote_cd := NULL;
        
    --- 理？醫？ erp i/f媛？ ORG？？Rxx？대㈃ 泥？由В엔엔엔엔엔？rp i/f？？Cxx瑜？援ы？？？？ 
    ELSIF ( v_base_rvis_cd = 'ORG' OR SUBSTRB(v_base_rvis_cd,1,1) = 'R' ) THEN  --- ORG, Rxx

        SELECT MIN(n3pty_inv_rvis_seq) n3pty_inv_rvis_seq  ---- ERP I/F ？？？？ 媛？？？理？珥？？？
        INTO out_erpif_creditnote_seq  
        FROM TPB_INV_RVIS R, TPB_INVOICE V 
        WHERE 1=1 
            AND R.n3pty_inv_no = V.n3pty_inv_no 
            AND R.n3pty_inv_no=in_n3pty_inv_no
            AND R.n3pty_inv_sts_cd = 'N' 
            AND R.n3pty_inv_rvis_seq > v_base_rvis_seq  --- 理？醫？ ERP I/F ？댄？？ 寃？以？
            AND R.n3pty_inv_rvis_cd LIKE 'C%'   -- Cxx 以？？？？？ 
        ; 
        
        IF ( out_erpif_creditnote_seq IS NOT NULL AND out_erpif_creditnote_seq> 0 ) THEN 

            SELECT n3pty_inv_rvis_cd  
            INTO out_erpif_creditnote_cd  
            FROM TPB_INV_RVIS R, TPB_INVOICE V 
            WHERE 1=1 
                AND R.n3pty_inv_no = V.n3pty_inv_no 
                AND R.n3pty_inv_no=in_n3pty_inv_no
                AND R.n3pty_inv_rvis_seq = out_erpif_creditnote_seq 
            ; 
        ELSE 
            out_erpif_creditnote_seq := NULL;
            
        END IF; 
    
    END IF; ---- 
        
    --- ====== UPDATE TPB REVISION INFO ===========
    UPDATE TPB_INV_RVIS 
    SET n3pty_inv_sts_cd = 'A' 
        ,clt_amt = inv_amt 
        ,clt_dt = SYSDATE 
        ,ar_if_dt = SYSDATE 
        ,upd_usr_id = in_user_id  
        ,upd_dt = SYSDATE 
    WHERE n3pty_inv_no = in_n3pty_inv_no 
        AND n3pty_inv_rvis_seq = out_erpif_creditnote_seq
        AND n3pty_delt_tp_cd = 'N' 
    ;     
    
    UPDATE TPB_INV_RVIS 
    SET n3pty_inv_sts_cd = 'A' 
        ,clt_amt = inv_amt 
        ,clt_dt = SYSDATE 
        ,ar_if_dt = SYSDATE 
        ,upd_usr_id = in_user_id  
        ,upd_dt = SYSDATE 
    WHERE n3pty_inv_no = in_n3pty_inv_no 
        AND n3pty_inv_rvis_seq = in_now_rvis_seq
        AND n3pty_delt_tp_cd = 'N' 
    ;     


    --- ====== GET TPB_NO =================
    SELECT ( SELECT n3pty_no FROM TPB_OTS_GRP WHERE n3pty_inv_no = in_n3pty_inv_no AND ROWNUM = 1 ) AS n3pty_no 
    INTO v_n3pty_no
    FROM DUAL 
    ; 
    
    IF v_n3pty_no IS NOT NULL AND LENGTHB(v_n3pty_no) > 0 THEN 
    
        --- ====== UPDATE COLLECTION AMOUNT, BALANCE AMOUNT ============
        UPDATE TPB_OTS_GRP   
        SET clt_amt = inv_amt   
            ,bal_amt = (ots_amt - NVL(adj_amt,0) - inv_amt)  
            ,upd_usr_id = in_user_id 
            ,upd_dt = SYSDATE 
        WHERE n3pty_no = v_n3pty_no 
            AND n3pty_delt_tp_cd = 'N'  
        ;
    
        UPDATE TPB_OTS_DTL   
        SET clt_amt = inv_amt   
            ,bal_amt = (ots_amt - NVL(adj_amt,0) - inv_amt)  
            ,upd_usr_id = in_user_id 
            ,upd_dt = SYSDATE   
        WHERE n3pty_no = v_n3pty_no 
            AND n3pty_delt_tp_cd = 'N'  
        ;
    
        --- ====== GET GROUP BALANCE =================
        SELECT bal_amt 
        INTO n_grp_bal_amt 
        FROM TPB_OTS_GRP 
        WHERE n3pty_no = v_n3pty_no 
            AND n3pty_delt_tp_cd = 'N' 
        ;
    
        --- ====== ADD OUTSTANDING GROUP/DETAIL STATUS 1st ===========
        ----- GROUP 
        TPB_ADD_OTS_GRP_STS_PRC(v_n3pty_no, 'L', in_user_id); 
        
        ----- DETAIL -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'Y', in_user_id);  
        ---  1) INSERT TPB_OTS_DTL_STS
        INSERT INTO TPB_OTS_DTL_STS (
            ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt, 
            cre_usr_id, cre_dt, upd_usr_id, upd_dt
        ) 
        SELECT 
            ots_dtl_seq, ots_dtl_sts_seq + 1, 'L', '+', SYSDATE, 
            in_user_id, SYSDATE, in_user_id, SYSDATE 
        FROM TPB_OTS_DTL_STS 
        WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = v_n3pty_no ) 
            AND ots_sts_lst_flg = 'Y'
        ;
        ---  2) INSERT TPB_OTS_DTL_STS
        UPDATE TPB_OTS_DTL_STS 
        SET ots_sts_lst_flg = DECODE(ots_sts_lst_flg,'Y','N','+','Y',ots_sts_lst_flg), 
            upd_usr_id = in_user_id, 
            upd_dt = SYSDATE
        WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = v_n3pty_no ) 
            AND ots_sts_lst_flg IN ('Y','+')
        ;  
        

        ------- Rercovery Activity --------
        IF ( out_erpif_rvis_seq IS NULL AND out_erpif_rvis_cd IS NULL ) THEN 

--            v_act_rmk := 'ERP interface was completed. ['||in_n3pty_inv_no||out_erpif_rvis_cd||']';	--2009-01-30 
			v_act_rmk := 'ERP interface was completed --- Case closed ['||in_n3pty_inv_no||out_erpif_rvis_cd||']';
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);    
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',v_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);
        
        END IF ; 

--        v_act_rmk := 'ERP interface was completed. ['||in_n3pty_inv_no||out_erpif_rvis_cd||']'; 	--2009-01-30
		v_act_rmk := 'ERP interface was completed - Case closed ['||in_n3pty_inv_no||out_erpif_rvis_cd||']';
        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);    
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',v_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);



        --- ====== ADD OUTSTANDING GROUP/DETAIL STATUS 2nd ===========
        IF ( n_grp_bal_amt = 0.0 ) THEN 
        
            ----- GROUP 
            TPB_ADD_OTS_GRP_STS_PRC(v_n3pty_no, 'E', in_user_id); 
            
            ----- DETAIL -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'Y', in_user_id);  
            ---  1) INSERT TPB_OTS_DTL_STS
            INSERT INTO TPB_OTS_DTL_STS (
                ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt, 
                cre_usr_id, cre_dt, upd_usr_id, upd_dt
            ) 
            SELECT 
                ots_dtl_seq, ots_dtl_sts_seq + 1, 'E', '+', SYSDATE, 
                in_user_id, SYSDATE, in_user_id, SYSDATE 
            FROM TPB_OTS_DTL_STS 
            WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = v_n3pty_no ) 
                AND ots_sts_lst_flg = 'Y'
            ;
            ---  2) INSERT TPB_OTS_DTL_STS
            UPDATE TPB_OTS_DTL_STS 
            SET ots_sts_lst_flg = DECODE(ots_sts_lst_flg,'Y','N','+','Y',ots_sts_lst_flg), 
                upd_usr_id = in_user_id, 
                upd_dt = SYSDATE
            WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = v_n3pty_no ) 
                AND ots_sts_lst_flg IN ('Y','+')
            ;  
            

            ------- Rercovery Activity --------
--            v_act_rmk := 'Closed due to collection finished. ['||in_n3pty_inv_no||out_erpif_rvis_cd||']';	--2009-01-30
--            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);    	--2009-01-30
--            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',v_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);	--2009-01-30
    
        END IF; 
        
        --- ====== ADD OUTSTANDING GROUP/DETAIL RECOVERY ACTIVITY ===========

        
    END IF; 


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