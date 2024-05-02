CREATE OR REPLACE PACKAGE BODY NISADM.TPB_INV_CRE_PKG

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
                         2012.12.31  Jeong-Seon An      1.5  CHM-201220985 PSO에 대한 3자구상 개발관련
                         2015.11-12  KIm Hyun-hwa       1.6  India SBC 금액정보 추가
                         2016.05-19  KIm Hyun-hwa       1.7  India KKC 금액정보 추가 2016.06.01 적용
                         2016.05-26  KIm Hyun-hwa       1.8  Microsoft  EDI 전송용 Load Id 추가
                         2016.07-18  Song Jeong-In      1.9  Billing Type Code 별 Add Amount 추가(VGM)
                         2017.09.11  Jong-Geon Byeon    1.3  India Tax 및 India Invoice No. 채번 규칙 변경
*******************************************************************************/

/*###############################################################################################
 *# CRE_INV_RVIS : CREATE TPB INVOICE MAIN, REVISION DATA
 *###############################################################################################*/

PROCEDURE CRE_INV_RVIS
-- ===== Arguments ========================================
(
    in_n3pty_no                     IN VARCHAR2,
    in_user_ofc_cd                  IN VARCHAR2,
    in_user_id                      IN VARCHAR2,
    in_bil_tp_cd                    IN VARCHAR2,
    in_h_vndr_cust_div_cd           IN VARCHAR2,
    in_vndr_cnt_cd                  IN VARCHAR2,
    in_vndr_seq                     IN VARCHAR2,
    in_cust_cnt_cd                  IN VARCHAR2,
    in_cust_seq                     IN VARCHAR2,
    in_vndr_cust_nm                 IN VARCHAR2,
    in_vndr_cust_addr               IN VARCHAR2,
    in_fax_no                       IN VARCHAR2,
    in_phn_no                       IN VARCHAR2,
    in_vndr_cust_ref_rmk            IN VARCHAR2,
    in_rcv_due_dt                   IN VARCHAR2,
    in_rgst_no                      IN VARCHAR2,
    in_inv_desc                     IN VARCHAR2,
    in_curr_cd                      IN VARCHAR2,
    in_net_amt                      IN VARCHAR2,
    in_vat_amt                      IN VARCHAR2,
    in_add_amt                      IN VARCHAR2,
    in_ddct_amt                     IN VARCHAR2,
    in_sum_inv_amt                  IN VARCHAR2,
    in_vndr_cust_eml                IN VARCHAR2,
    in_cty_nm                       IN VARCHAR2,
    in_ste_cd                       IN VARCHAR2,
    in_zip_cd                       IN VARCHAR2,
    in_usr_inp_ctnt1                IN VARCHAR2,
    in_usr_inp_ctnt2                IN VARCHAR2,
  	in_ida_tax_seq                  IN VARCHAR2, --2009-05-28
    in_locl_tax_amt                 IN VARCHAR2, --2015-11-12 India SBC charge
    in_n2nd_locl_tax_amt            IN VARCHAR2,  --2016-06-01 적용 KKC
    in_ida_cgst_rto                 IN VARCHAR2,
    in_ida_sgst_rto                 IN VARCHAR2,
    in_ida_igst_rto                 IN VARCHAR2,
    in_ida_ugst_rto                 IN VARCHAR2,
    in_ida_cgst_amt                 IN VARCHAR2,
    in_ida_sgst_amt                 IN VARCHAR2,
    in_ida_igst_amt                 IN VARCHAR2,
    in_ida_ugst_amt                 IN VARCHAR2,

    out_n3pty_inv_no                OUT VARCHAR2, --------
    out_n3pty_inv_rvis_seq          OUT VARCHAR2 --------
)

IS

-- ===== DECLARE ==========================================
v_n3pty_inv_no                      TPB_INVOICE.N3PTY_INV_NO%TYPE; -- TEMP TPB INV NO.
v_cnt_cd                            MDM_LOCATION.CNT_CD%TYPE;
-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

    --- ====== get tpb invoice no. ===========
    TPB_GEN_INV_NO_PRC(in_user_ofc_cd, in_bil_tp_cd, in_user_id, v_n3pty_inv_no);

    SELECT   L.CNT_CD
    INTO     v_cnt_cd
    FROM     MDM_ORGANIZATION O
           , MDM_LOCATION L
    WHERE    1 = 1
    AND      O.LOC_CD = L.LOC_CD
    AND      O.OFC_CD = in_user_ofc_cd
    ;
    
    IF v_cnt_cd = 'IN' THEN
        SELECT   ATTR_CTNT3
        INTO     out_n3pty_inv_no
        FROM     COM_SER_NO_CTNT
        WHERE    1 = 1
        AND      ATTR_CTNT3 = v_n3pty_inv_no
        FOR UPDATE NOWAIT
        ;
    ELSE
        SELECT   LST_N3PTY_INV_NO
        INTO     out_n3pty_inv_no
        FROM     TPB_INV_NO_GEN
        WHERE    1 = 1
        AND      LST_N3PTY_INV_NO = v_n3pty_inv_no
        FOR UPDATE NOWAIT
        ;
    END IF;


    --- ====== IF TPB INV NO. is valid ===========
    IF LENGTHB(out_n3pty_inv_no) = 11 THEN ----------------------


        ----- insert into tpb_invoice ------------------------------
        SELECT   NVL(MAX(N3PTY_INV_RVIS_SEQ),0) + 1 AS NEW_N3PTY_INV_RVIS_SEQ
        INTO     out_n3pty_inv_rvis_seq
        FROM     TPB_INV_RVIS
        WHERE    1 = 1
        AND      N3PTY_INV_NO = out_n3pty_inv_no
        ;

        ----- insert into tpb_invoice ------------------------------
        INSERT INTO TPB_INVOICE (
                 N3PTY_INV_NO
               , LST_N3PTY_INV_RVIS_SEQ
               , OFC_CD
               , N3PTY_DELT_TP_CD
               , LNK_N3PTY_INV_NO
               , IF_BL_NO
               , CRE_USR_ID
               , CRE_DT
               , UPD_USR_ID
               , UPD_DT
        ) VALUES
        (
                 out_n3pty_inv_no
               , out_n3pty_inv_rvis_seq
               , in_user_ofc_cd
               , 'N'
               , NULL
               , out_n3pty_inv_no
               , in_user_id
               , SYSDATE
               , in_user_id
               , SYSDATE
        );

        ----- insert into tpb_inv_rvis ------------------------------
        INSERT INTO TPB_INV_RVIS
        (
                 N3PTY_INV_NO
               , N3PTY_INV_RVIS_SEQ
               , N3PTY_INV_RVIS_CD
               , N3PTY_DELT_TP_CD
               , CO_NM
               , OFC_ADDR
               , OFC_PHN_NO
               , OFC_FAX_NO
               , BIL_TO_LOC_DIV_CD
               , VNDR_CUST_DIV_CD
               , VNDR_CNT_CD
               , VNDR_SEQ
               , CUST_CNT_CD
               , CUST_SEQ
               , VNDR_CUST_NM
               , VNDR_CUST_ADDR
               , VNDR_CUST_EML
               , CTY_NM
               , STE_CD
               , ZIP_CD
               , FAX_NO
               , PHN_NO
               , VNDR_CUST_REF_RMK
               , USR_INP_CTNT1
               , USR_INP_CTNT2
               , RCV_DUE_DT
               , RGST_NO
               , INV_DESC
               , INV_RMK1
               , INV_RMK2
               , N3PTY_INV_IF_TP_CD
               , N3PTY_INV_UPD_FLG
               , N3PTY_INV_STS_CD
               , CLT_AGN_FLG
               , CLT_AGN_RMK
               , CLT_AGN_DT
               , AR_IF_DT
               , CURR_CD
               , MON_XCH_RT
               , NET_AMT
               , VAT_AMT
               , ADD_AMT
               , DDCT_AMT
               , INV_AMT
               , CLT_AMT
               , CLT_DT
               , INV_ISS_LOCL_DT
               , INV_ISS_GDT
               , INV_UPD_LOCL_DT
               , INV_UPD_GDT
               , FAX_EML_SND_NO
               , IF_BL_NO
               , CRE_USR_ID
               , CRE_DT
               , UPD_USR_ID
               , UPD_DT
               , IDA_TAX_SEQ
               , LOCL_TAX_AMT
               , N2ND_LOCL_TAX_AMT
               , IDA_CGST_RTO
               , IDA_SGST_RTO
               , IDA_IGST_RTO
               , IDA_UGST_RTO
               , IDA_CGST_AMT
               , IDA_SGST_AMT
               , IDA_IGST_AMT
               , IDA_UGST_AMT
        ) VALUES
        (
                 out_n3pty_inv_no
               , out_n3pty_inv_rvis_seq
               , 'ORG'
               , 'N'
               , NULL
               , NULL
               , NULL
               , NULL
               , NULL
               , in_h_vndr_cust_div_cd
               , in_vndr_cnt_cd
               , in_vndr_seq
               , in_cust_cnt_cd
               , in_cust_seq
               , in_vndr_cust_nm
               , in_vndr_cust_addr
               , in_vndr_cust_eml
               , in_cty_nm
               , in_ste_cd
               , in_zip_cd
               , in_fax_no
               , in_phn_no
               , in_vndr_cust_ref_rmk
               , in_usr_inp_ctnt1
               , in_usr_inp_ctnt2
               , TO_DATE(in_rcv_due_dt,'YYYY-MM-DD')
               , in_rgst_no
               , in_inv_desc
               , NULL
               , NULL
               , NULL
               , NULL
               , 'N'
               , 'N'
               , NULL
               , NULL
               , NULL
               , in_curr_cd
               , TPB_GET_USD_XCH_RT_FNC(in_curr_cd, NVL(TPB_GET_LCL_DATE_FNC(SYSDATE,in_user_ofc_cd),SYSDATE) )
               , in_net_amt
               , in_vat_amt
               , in_add_amt
               , in_ddct_amt
               , in_sum_inv_amt
               , NULL
               , NULL
               , SYSDATE
               , SYSDATE
               , SYSDATE
               , SYSDATE
               , NULL
               , out_n3pty_inv_no
               , in_user_id
               , SYSDATE
               , in_user_id
               , SYSDATE
               , TO_NUMBER(in_ida_tax_seq)
               , in_locl_tax_amt
               , in_n2nd_locl_tax_amt
               , in_ida_cgst_rto
               , in_ida_sgst_rto
               , in_ida_igst_rto
               , in_ida_ugst_rto
               , REPLACE(in_ida_cgst_amt,',','')
               , REPLACE(in_ida_sgst_amt,',','')
               , REPLACE(in_ida_igst_amt,',','')
               , REPLACE(in_ida_ugst_amt,',','')
        );

        UPDATE   TPB_INV_RVIS
        SET      ( CO_NM, OFC_ADDR, OFC_PHN_NO, OFC_FAX_NO, BIL_TO_LOC_DIV_CD, INV_RMK1, INV_RMK2 )
                 = (
                     SELECT   CO_NM
                            , OFC_ADDR
                            , OFC_PHN_NO
                            , OFC_FAX_NO
                            , BIL_TO_LOC_DIV_CD
                            , INV_RMK1
                            , INV_RMK2
                     FROM     TPB_INV_SH_SET
                     WHERE    1 = 1
                     AND      INV_ISS_OFC_CD = in_user_ofc_cd
                     AND      ROWNUM = 1
                 )
        WHERE    1 = 1
        AND      N3PTY_INV_NO = out_n3pty_inv_no
        AND      N3PTY_INV_RVIS_SEQ = out_n3pty_inv_rvis_seq
        ;

        TPB_INV_CRE_PKG.UPD_OTS_GRP_INFO( in_n3pty_no, out_n3pty_inv_no, in_user_ofc_cd, in_user_id ,in_curr_cd , in_sum_inv_amt );

    END IF;


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
    in_n3pty_inv_no                 IN VARCHAR2,
    in_n3pty_inv_rvis_seq           IN NUMBER,
    in_user_ofc_cd                  IN VARCHAR2,
    in_user_id                      IN VARCHAR2,
    in_curr_cd                      IN VARCHAR2,
    in_n3pty_no                     IN VARCHAR2,
    in_ots_dtl_seq                  IN VARCHAR2,
    in_n3pty_bil_tp_cd              IN VARCHAR2,
    in_eq_knd_cd                    IN VARCHAR2,
    in_eq_no                        IN VARCHAR2,
    in_eq_tpsz_cd                   IN VARCHAR2,
    in_new_eq_no                    IN VARCHAR2,
    in_bkg_no                       IN VARCHAR2,
    in_bl_no                        IN VARCHAR2,
    in_vsl_cd                       IN VARCHAR2,
    in_skd_voy_no                   IN VARCHAR2,
    in_skd_dir_cd                   IN VARCHAR2,
    in_yd_cd                        IN VARCHAR2,
    in_fm_nod_cd                    IN VARCHAR2,
    in_via_nod_cd                   IN VARCHAR2,
    in_to_nod_cd                    IN VARCHAR2,
    in_dor_nod_cd                   IN VARCHAR2,
    in_new_cntr_seal_no             IN VARCHAR2,
    in_lst_free_dt                  IN VARCHAR2,
    in_ots_amt                      IN VARCHAR2,
    in_inv_dtl_amt                  IN VARCHAR2,
    in_pkup_dt                      IN VARCHAR2,
    in_ft_ovr_dys                   IN VARCHAR2,
    in_cita_no                      IN VARCHAR2,
    in_cntr_wgt                     IN VARCHAR2,
    in_n3pty_cntr_wgt_ut_cd         IN VARCHAR2,
    in_wt_hrs                       IN VARCHAR2,
    in_occr_dt                      IN VARCHAR2,
    in_new_vsl_cd                   IN VARCHAR2,
    in_new_bkg_no                   IN VARCHAR2,
    in_acct_cd                      IN VARCHAR2,
    in_lgs_cost_cd                  IN VARCHAR2,
    in_so_no                        IN VARCHAR2,
    in_estm_svr_id                  IN VARCHAR2,
    in_finc_dir_cd                  IN VARCHAR2,
    in_rev_amt                      IN VARCHAR2,
    in_csr_no                       IN VARCHAR2,
    in_gl_dt                        IN VARCHAR2,
    in_vvd_cd                       IN VARCHAR2,
    in_vat_dtl_amt                  IN VARCHAR2,
    in_lod_id                       IN VARCHAR2,
    in_inv_dtl_add_amt              IN VARCHAR2
)

IS

-- ===== DECLARE ==========================================

-- ===== BEGIN, EXCEPTION & END ======================================
BEGIN

    ----- insert into tpb_invoice ------------------------------
    INSERT INTO tpb_inv_rvis_dtl
    (
             n3pty_inv_no
           , n3pty_inv_rvis_seq
           , n3pty_inv_rvis_dtl_seq
           , n3pty_no
           , ots_dtl_seq
           , n3pty_delt_tp_cd
           , n3pty_bil_tp_cd
           , eq_knd_cd
           , eq_no
           , eq_tpsz_cd
           , bkg_no
           , bl_no
           , vsl_cd
           , skd_voy_no
           , skd_dir_cd
           , finc_dir_cd
           , yd_cd
           , fm_nod_cd
           , via_nod_cd
           , to_nod_cd
           , dor_nod_cd
           , new_eq_no
           , new_cntr_seal_no
           , lst_free_dt
           , ots_amt
           , corr_ots_amt
           , rev_amt
           , inv_dtl_amt
           , pkup_dt
           , ft_ovr_dys
           , cita_no
           , cntr_wgt
           , n3pty_cntr_wgt_ut_cd
           , wt_hrs
           , occr_dt
           , new_vsl_cd
           , new_skd_voy_no
           , new_skd_dir_cd
           , new_bkg_no
           , acct_cd
           , lgs_cost_cd
           , so_no
           , csr_no
           , gl_dt
           , vvd_cd
           , estm_sys_area_grp_id
           , cre_usr_id
           , cre_dt
           , upd_usr_id
           , upd_dt
           , vat_dtl_amt
           , act_atd_inp_dt
           , tml_nm
           , acct_nm
           , lod_id
           , add_amt
    )
    VALUES
    (
             in_n3pty_inv_no
           , in_n3pty_inv_rvis_seq
           , (
               SELECT   NVL(MAX(N3PTY_INV_RVIS_DTL_SEQ),0)+1
               FROM     TPB_INV_RVIS_DTL
               WHERE    1 = 1
               AND      N3PTY_INV_NO = in_n3pty_inv_no
               AND      N3PTY_INV_RVIS_SEQ = in_n3pty_inv_rvis_seq
             )
           , in_n3pty_no
           , in_ots_dtl_seq
           , 'N'
           , in_n3pty_bil_tp_cd
           , in_eq_knd_cd
           , in_eq_no
           , in_eq_tpsz_cd
           , in_bkg_no
           , in_bl_no
           , in_vsl_cd
           , in_skd_voy_no
           , in_skd_dir_cd
           , in_finc_dir_cd
           , in_yd_cd
           , in_fm_nod_cd
           , in_via_nod_cd
           , in_to_nod_cd
           , in_dor_nod_cd
           , in_new_eq_no
           , in_new_cntr_seal_no
           , TO_DATE(in_lst_free_dt,'YYYY-MM-DD')
           , in_ots_amt
           , NULL
           , in_rev_amt
           , in_inv_dtl_amt
           , TO_DATE(in_pkup_dt,'YYYY-MM-DD')
           , in_ft_ovr_dys
           , in_cita_no
           , in_cntr_wgt
           , in_n3pty_cntr_wgt_ut_cd
           , in_wt_hrs
           , TO_DATE(in_occr_dt,'YYYY-MM-DD')
           , SUBSTRB(in_new_vsl_cd,1,4)
           , SUBSTRB(in_new_vsl_cd,5,4)
           , SUBSTRB(in_new_vsl_cd,9,2)
           , in_new_bkg_no
           , in_acct_cd
           , in_lgs_cost_cd
           , in_so_no
           , in_csr_no
           , in_gl_dt
           , in_vvd_cd
           , in_estm_svr_id
           , in_user_id
           , SYSDATE
           , in_user_id
           , SYSDATE
           , in_vat_dtl_amt
           , (
               SELECT  MIN(VPS_ETD_DT)
               FROM    VSK_VSL_PORT_SKD
               WHERE   VSL_CD = SUBSTR(in_vvd_cd,1,4)
               AND     SKD_VOY_NO = SUBSTR(in_vvd_cd,5,4)
               AND     SKD_DIR_CD  = SUBSTR(in_vvd_cd,9,1)
               AND     YD_CD = in_yd_cd
             )
           , ( SELECT YD_NM FROM MDM_YARD WHERE YD_CD = in_yd_cd )
           , ( SELECT ACCT_ENG_NM VAL FROM MDM_ACCOUNT WHERE ACCT_CD = in_acct_cd )
           , in_lod_id
           , in_inv_dtl_add_amt
    );

    TPB_INV_CRE_PKG.UPD_OTS_DTL_INFO( in_n3pty_no, in_ots_dtl_seq, in_user_ofc_cd, in_user_id, in_curr_cd, in_inv_dtl_amt );


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
    in_n3pty_no                     IN VARCHAR2,
    in_n3pty_inv_no                 IN VARCHAR2,
    in_user_ofc_cd                  IN VARCHAR2,
    in_user_id                      IN VARCHAR2,
    in_curr_cd                      IN VARCHAR2,
    in_sum_inv_amt                  IN VARCHAR2
)

IS

-- ===== DECLARE ==========================================

--    v_n3pty_no           TPB_OTS_GRP.n3pty_no%TYPE;

-- ===== BEGIN, EXCEPTION & END ======================================
BEGIN

    --- ====== UPDATE TPB OUTSTANDING GROUP ===========
    UPDATE   TPB_OTS_GRP B
    SET      N3PTY_INV_NO = in_n3pty_inv_no
           , INV_AMT = TPB_GET_INV_CURR_CHG_FNC(in_curr_cd, B.CURR_CD, TO_NUMBER(in_sum_inv_amt), SYSDATE)
           , UPD_USR_ID = in_user_id
           , UPD_DT = SYSDATE
    WHERE    1 = 1
    AND      N3PTY_NO = in_n3pty_no
    ;

    --- ====== ADD OUTSTANDING GROUP STATUS ===========
    TPB_ADD_OTS_GRP_STS_PRC( in_n3pty_no, 'I', in_user_id );

    --- ====== ADD OUTSTANDING GROUP RECOVERY ACTIVITY ===========
    TPB_ADD_OTS_GRP_RCVR_ACT_PRC( in_n3pty_no, '', 'Invoice created.', 'A','', in_user_ofc_cd, in_user_id );


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
    in_n3pty_no                     IN VARCHAR2,
    in_ots_dtl_seq                  IN VARCHAR2,
    in_user_ofc_cd                  IN VARCHAR2,
    in_user_id                      IN VARCHAR2,
    in_curr_cd                      IN VARCHAR2,
    in_inv_dtl_amt                  IN VARCHAR2
)

IS

-- ===== DECLARE ==========================================


-- ===== BEGIN, EXCEPTION & END ======================================
BEGIN

    --- ====== UPDATE TPB OUTSTANDING GROUP ===========
    UPDATE   TPB_OTS_DTL A
    SET      INV_AMT = TPB_GET_INV_CURR_CHG_FNC( in_curr_cd, A.CFM_CURR_CD, TO_NUMBER(in_inv_dtl_amt), SYSDATE )
           , UPD_USR_ID = in_user_id
           , UPD_DT = SYSDATE
    WHERE    1 = 1
    AND      OTS_DTL_SEQ = in_ots_dtl_seq
    AND      N3PTY_NO = in_n3pty_no
    ;

    --- ====== ADD OUTSTANDING GROUP STATUS ===========
    TPB_ADD_OTS_DTL_STS_PRC( in_ots_dtl_seq, 'I', in_user_id );

    --- ====== ADD OUTSTANDING GROUP RECOVERY ACTIVITY ===========
    TPB_ADD_OTS_DTL_RCVR_ACT_PRC( 'S', in_ots_dtl_seq, '', 'Invoice created.', 'A', '', in_user_ofc_cd, in_user_id );

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