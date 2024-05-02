CREATE OR REPLACE PACKAGE BODY NISADM.TPB_INV_RVIS_PKG

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
                         2009.10.05  Park Sung-Jin   1.7  ALPS Migration
                         2010.01.08  Sun, CHOI       1.8  EQ_TP_CD -> EQ_KND_CD 전환
                         2010.02.10  Jong-Geon Byeon 1.9  PROCEDURE UPD_INV_RVIS : TPB_INV_RVIS 테이블의 Rivision 데이터의 CURR_CD컬럼 값을 파라미터로 받아온 값으로 변경(curr_cd -> in_curr_cd)
                         2012.05.17  Jeong-Seon An   1.10 [CHM-201216957] [TPB] Status "ERP Interface"의 변경 요청
                         2012.12.31  Jeong-Seon An        CHM-201220985 PSO에 대한 3자구상 개발관련
                         2015.11-12  KIm Hyun-hwa         India SBC 금액정보 추가
                         2016.05-19  KIm Hyun-hwa         India KKC 금액정보 추가 2016.06.01 적용
                         2016.05-26  KIm Hyun-hwa         Microsoft  EDI 전송용 Load Id 추가(5/31적용)
*******************************************************************************/


/*###############################################################################################
 *# UPD_INV_RVIS : UPDATE TPB INVOICE MAIN, REVISION DATA
 *###############################################################################################*/

PROCEDURE UPD_INV_RVIS

-- ===== Arguments ========================================
(
    in_user_ofc_cd                  IN VARCHAR2,
    in_user_id                      IN VARCHAR2,
    in_n3pty_no                     IN VARCHAR2,
    in_n3pty_inv_no                 IN VARCHAR2,
    in_n3pty_inv_rvis_seq           IN VARCHAR2,
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
    in_clt_agn_flg                  IN VARCHAR2,
    in_clt_agn_rmk                  IN VARCHAR2,
    in_ida_tax_seq                  IN VARCHAR2,
    in_locl_tax_amt                 IN VARCHAR2,
    in_n2nd_locl_tax_amt            IN VARCHAR2,
    in_ida_cgst_rto                 IN VARCHAR2,
    in_ida_sgst_rto                 IN VARCHAR2,
    in_ida_igst_rto                 IN VARCHAR2,
    in_ida_ugst_rto                 IN VARCHAR2,
    in_ida_cgst_amt                 IN VARCHAR2,
    in_ida_sgst_amt                 IN VARCHAR2,
    in_ida_igst_amt                 IN VARCHAR2,
    in_ida_ugst_amt                 IN VARCHAR2,

    out_n3pty_inv_no                OUT VARCHAR2,
    out_new_rvis_seq                OUT VARCHAR2,
    out_new_rvis_cd                 OUT VARCHAR2,
    out_new_creditnote_seq          OUT VARCHAR2,
    out_new_creditnote_cd           OUT VARCHAR2
)

IS

-- ===== DECLARE ==========================================
    v_n3pty_inv_no                  TPB_INVOICE.N3PTY_INV_NO%TYPE; -- TEMP TPB INV NO.
    v_now_rvis_seq                  TPB_INV_RVIS.N3PTY_INV_RVIS_SEQ%TYPE;
    v_now_rvis_cd                   TPB_INV_RVIS.N3PTY_INV_RVIS_CD%TYPE;


-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

    --- Initiate varibles

    --- ====== get tpb invoice info ===========
    SELECT   N3PTY_INV_NO
    INTO     out_n3pty_inv_no
    FROM     TPB_INVOICE
    WHERE    1 = 1
    AND      N3PTY_INV_NO = in_n3pty_inv_no
    FOR UPDATE NOWAIT
    ;

    SELECT   V.LST_N3PTY_INV_RVIS_SEQ AS NOW_RVIS_SEQ
           , R.N3PTY_INV_RVIS_CD AS NOW_RVIS_CD
           , DECODE( SUBSTRB(R.N3PTY_INV_RVIS_CD,1,1), 'C', 0, R.N3PTY_INV_RVIS_SEQ + 1 ) AS NEW_CREDITNOTE_SEQ
           , CASE WHEN V.N3PTY_DELT_TP_CD != 'N' THEN NULL
                  WHEN R.N3PTY_INV_RVIS_CD = 'ORG' OR R.N3PTY_INV_RVIS_CD IS NULL THEN 'C01'
                  WHEN SUBSTRB(N3PTY_INV_RVIS_CD,1,1) = 'R' AND TO_NUMBER(SUBSTRB(N3PTY_INV_RVIS_CD,2,2)) + 1 < 100 THEN 'C'|| TRIM(LPAD(TO_CHAR(TO_NUMBER(SUBSTRB(N3PTY_INV_RVIS_CD,2,2))+1), 2, '0'))
                  WHEN SUBSTRB(N3PTY_INV_RVIS_CD,1,1) = 'R' AND TO_NUMBER(SUBSTRB(N3PTY_INV_RVIS_CD,2,2)) + 1 >= 100 THEN NULL
                  WHEN SUBSTRB(N3PTY_INV_RVIS_CD,1,1) != 'R' THEN 'C01'
             END AS NEW_CREDITNOTE_CD
           , DECODE( SUBSTRB(R.N3PTY_INV_RVIS_CD,1,1), 'C', R.N3PTY_INV_RVIS_SEQ + 1, R.N3PTY_INV_RVIS_SEQ + 2 ) AS NEW_RVIS_SEQ
           , CASE WHEN V.N3PTY_DELT_TP_CD != 'N' THEN NULL
                  WHEN R.N3PTY_INV_RVIS_CD = 'ORG' OR R.N3PTY_INV_RVIS_CD IS NULL THEN 'R01'
                  WHEN SUBSTRB(N3PTY_INV_RVIS_CD,1,1) = 'R' AND TO_NUMBER(SUBSTRB(N3PTY_INV_RVIS_CD,2,2)) + 1 < 100 THEN 'R'|| TRIM(LPAD(TO_CHAR(TO_NUMBER(SUBSTRB(N3PTY_INV_RVIS_CD,2,2))+1), 2, '0'))
                  WHEN SUBSTRB(N3PTY_INV_RVIS_CD,1,1) = 'R' AND TO_NUMBER(SUBSTRB(N3PTY_INV_RVIS_CD,2,2)) + 1 >= 100 THEN NULL
                  WHEN SUBSTRB(N3PTY_INV_RVIS_CD,1,1) != 'R' THEN 'R01'
             END AS NEW_RVIS_CD
    INTO     v_now_rvis_seq
           , v_now_rvis_cd
           , out_new_creditnote_seq
           , out_new_creditnote_cd
           , out_new_rvis_seq
           , out_new_rvis_cd
    FROM     TPB_INV_RVIS R
           , TPB_INVOICE V
    WHERE    1 = 1
    AND      R.N3PTY_INV_NO = v.n3pty_inv_no
    AND      R.N3PTY_INV_RVIS_SEQ = v.lst_n3pty_inv_rvis_seq
    AND      V.N3PTY_INV_NO = in_n3pty_inv_no
    ;


    SELECT   DECODE( COUNT(0), 0, OUT_NEW_CREDITNOTE_SEQ, NULL )
    INTO     out_new_creditnote_seq
    FROM     TPB_INV_RVIS R
    WHERE    1 = 1
    AND      N3PTY_INV_NO = in_n3pty_inv_no
    AND      N3PTY_INV_RVIS_SEQ = out_new_creditnote_seq
    ;


    --- ====== IF TPB INV NO. is valid ===========
    IF LENGTHB(in_n3pty_inv_no) = 11 THEN ----------------------


        ----- FOR CREDIT NOTE ------------------------------
        IF TO_NUMBER(out_new_creditnote_seq) > 0 THEN ----------------------

            ----- update tpb_invoice ------------------------------

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
                   , LOCL_TAX_AMT
                   , N2ND_LOCL_TAX_AMT
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
                   , IDA_CGST_RTO
                   , IDA_SGST_RTO
                   , IDA_IGST_RTO
                   , IDA_UGST_RTO
                   , IDA_CGST_AMT
                   , IDA_SGST_AMT
                   , IDA_IGST_AMT
                   , IDA_UGST_AMT
            )
            SELECT   n3pty_inv_no
                   , out_new_creditnote_seq
                   , out_new_creditnote_cd
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
                   , NULL AS N3PTY_INV_IF_TP_CD
                   , N3PTY_INV_UPD_FLG
                   , 'N' AS N3PTY_INV_STS_CD
                   , CLT_AGN_FLG
                   , CLT_AGN_RMK
                   , NULL AS CLT_AGN_DT
                   , NULL AS AR_IF_DT
                   , CURR_CD
                   , MON_XCH_RT
                   , (-1) * NET_AMT
                   , (-1) * VAT_AMT
                   , (-1) * ADD_AMT
                   , (-1) * DDCT_AMT
                   , (-1) * INV_AMT
                   , NULL AS CLT_AMT
                   , (-1) * NVL(LOCL_TAX_AMT,0)
                   , (-1) * NVL(N2ND_LOCL_TAX_AMT,0)
                   , NULL AS CLT_DT
                   , SYSDATE AS INV_ISS_LOCL_DT
                   , SYSDATE AS INV_ISS_GDT
                   , SYSDATE AS INV_UPD_LOCL_DT
                   , SYSDATE AS INV_UPD_GDT
                   , FAX_EML_SND_NO
                   , IF_BL_NO
                   , UPD_USR_ID
                   , SYSDATE AS CRE_DT
                   , UPD_USR_ID
                   , SYSDATE AS UPD_DT
                   , in_ida_tax_seq
                   , IDA_CGST_RTO
                   , IDA_SGST_RTO
                   , IDA_IGST_RTO
                   , IDA_UGST_RTO
                   , (-1) * IDA_CGST_AMT
                   , (-1) * IDA_SGST_AMT
                   , (-1) * IDA_IGST_AMT
                   , (-1) * IDA_UGST_AMT
            FROM     TPB_INV_RVIS R
            WHERE    1 = 1
            AND      R.N3PTY_INV_NO = in_n3pty_inv_no
            AND      R.N3PTY_INV_RVIS_SEQ = in_n3pty_inv_rvis_seq
            AND      R.N3PTY_DELT_TP_CD = 'N'
            ;


            ----- insert into tpb_inv_rvis_dtl ------------------------------
            INSERT INTO TPB_INV_RVIS_DTL
            (
                     N3PTY_INV_NO
                   , N3PTY_INV_RVIS_SEQ
                   , N3PTY_INV_RVIS_DTL_SEQ
                   , N3PTY_NO
                   , OTS_DTL_SEQ
                   , N3PTY_DELT_TP_CD
                   , N3PTY_BIL_TP_CD
                   , EQ_KND_CD
                   , EQ_NO
                   , EQ_TPSZ_CD
                   , BKG_NO
                   , BL_NO
                   , VSL_CD
                   , SKD_VOY_NO
                   , SKD_DIR_CD
                   , FINC_DIR_CD
                   , YD_CD
                   , FM_NOD_CD
                   , VIA_NOD_CD
                   , TO_NOD_CD
                   , DOR_NOD_CD
                   , NEW_EQ_NO
                   , NEW_CNTR_SEAL_NO
                   , LST_FREE_DT
                   , OTS_AMT
                   , CORR_OTS_AMT
                   , REV_AMT
                   , INV_DTL_AMT
                   , PKUP_DT
                   , FT_OVR_DYS
                   , CITA_NO
                   , CNTR_WGT
                   , N3PTY_CNTR_WGT_UT_CD
                   , WT_HRS
                   , OCCR_DT
                   , NEW_VSL_CD
                   , NEW_SKD_VOY_NO
                   , NEW_SKD_DIR_CD
                   , NEW_BKG_NO
                   , ACCT_CD
                   , LGS_COST_CD
                   , SO_NO
                   , CSR_NO
                   , GL_DT
                   , VVD_CD
                   , ESTM_SYS_AREA_GRP_ID
                   , CRE_USR_ID
                   , CRE_DT
                   , UPD_USR_ID
                   , UPD_DT
                   , VAT_DTL_AMT
                   , ACT_ATD_INP_DT
                   , TML_NM
                   , ACCT_NM
                   , ADD_AMT
            )
            SELECT   N3PTY_INV_NO
                   , out_new_creditnote_seq
                   , N3PTY_INV_RVIS_DTL_SEQ
                   , N3PTY_NO
                   , OTS_DTL_SEQ
                   , N3PTY_DELT_TP_CD
                   , N3PTY_BIL_TP_CD
                   , EQ_KND_CD
                   , EQ_NO
                   , EQ_TPSZ_CD
                   , BKG_NO
                   , BL_NO
                   , VSL_CD
                   , SKD_VOY_NO
                   , SKD_DIR_CD
                   , FINC_DIR_CD
                   , YD_CD
                   , FM_NOD_CD
                   , VIA_NOD_CD
                   , TO_NOD_CD
                   , DOR_NOD_CD
                   , NEW_EQ_NO
                   , NEW_CNTR_SEAL_NO
                   , LST_FREE_DT
                   , OTS_AMT
                   , CORR_OTS_AMT
                   , (-1) * REV_AMT
                   , (-1) * INV_DTL_AMT
                   , PKUP_DT
                   , FT_OVR_DYS
                   , CITA_NO
                   , CNTR_WGT
                   , N3PTY_CNTR_WGT_UT_CD
                   , WT_HRS
                   , OCCR_DT
                   , NEW_VSL_CD
                   , NEW_SKD_VOY_NO
                   , NEW_SKD_DIR_CD
                   , NEW_BKG_NO
                   , ACCT_CD
                   , LGS_COST_CD
                   , SO_NO
                   , CSR_NO
                   , GL_DT
                   , VVD_CD
                   , ESTM_SYS_AREA_GRP_ID
                   , in_user_id
                   , SYSDATE
                   , in_user_id
                   , SYSDATE
                   , NVL(VAT_DTL_AMT,0) * (-1)
                   , ACT_ATD_INP_DT
                   , TML_NM
                   , ACCT_NM
                   , (-1) * ADD_AMT
            FROM     TPB_INV_RVIS_DTL
            WHERE    1 = 1
            AND      N3PTY_INV_NO = in_n3pty_inv_no
            AND      N3PTY_INV_RVIS_SEQ = in_n3pty_inv_rvis_seq
            AND      N3PTY_DELT_TP_CD = 'N'
            ;

        END IF;



        ----- FOR REVISION ------------------------------

        ----- UPDATE tpb_invoice ------------------------------
        UPDATE   TPB_INVOICE
        SET      LST_N3PTY_INV_RVIS_SEQ = TO_NUMBER(out_new_rvis_seq)
               , UPD_USR_ID = in_user_id
               , UPD_DT = SYSDATE
        WHERE    1 = 1
        AND      N3PTY_INV_NO = in_n3pty_inv_no
        ;

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
               , LOCL_TAX_AMT
               , N2ND_LOCL_TAX_AMT
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
               , IDA_CGST_RTO
               , IDA_SGST_RTO
               , IDA_IGST_RTO
               , IDA_UGST_RTO
               , IDA_CGST_AMT
               , IDA_SGST_AMT
               , IDA_IGST_AMT
               , IDA_UGST_AMT
        )
        SELECT   R.N3PTY_INV_NO
               , out_new_rvis_seq
               , out_new_rvis_cd
               , R.N3PTY_DELT_TP_CD
               , CO_NM
               , OFC_ADDR
               , OFC_PHN_NO
               , OFC_FAX_NO
               , BIL_TO_LOC_DIV_CD
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
               , RGST_NO
               , in_inv_desc
               , INV_RMK1
               , INV_RMK2
               , NULL AS N3PTY_INV_IF_TP_CD
               , N3PTY_INV_UPD_FLG
               , 'N' AS N3PTY_INV_STS_CD
               , CLT_AGN_FLG
               , CLT_AGN_RMK
               , CLT_AGN_DT
               , NULL AS AR_IF_DT
               , in_curr_cd
               , TPB_GET_USD_XCH_RT_FNC(in_curr_cd,NVL(TPB_GET_LCL_DATE_FNC(SYSDATE,v.ofc_cd),SYSDATE))
               , in_net_amt
               , in_vat_amt
               , in_add_amt
               , in_ddct_amt
               , in_sum_inv_amt
               , NULL AS CLT_AMT
               , in_locl_tax_amt
               , in_n2nd_locl_tax_amt
               , NULL AS CLT_DT
               , SYSDATE AS INV_ISS_LOCL_DT
               , SYSDATE AS INV_ISS_GDT
               , SYSDATE AS INV_UPD_LOCL_DT
               , SYSDATE AS INV_UPD_GDT
               , FAX_EML_SND_NO
               , R.IF_BL_NO
               , in_user_id
               , SYSDATE AS CRE_DT
               , in_user_id
               , SYSDATE AS UPD_DT
               , IDA_TAX_SEQ
               , in_ida_cgst_rto
               , in_ida_sgst_rto
               , in_ida_igst_rto
               , in_ida_ugst_rto
               , REPLACE(in_ida_cgst_amt,',','')
               , REPLACE(in_ida_sgst_amt,',','')
               , REPLACE(in_ida_igst_amt,',','')
               , REPLACE(in_ida_ugst_amt,',','')
        FROM     TPB_INV_RVIS R
               , TPB_INVOICE V
        WHERE    1 = 1
        AND      R.N3PTY_INV_NO = v.n3pty_inv_no
        AND      R.N3PTY_INV_NO = in_n3pty_inv_no
        AND      R.N3PTY_INV_RVIS_SEQ = in_n3pty_inv_rvis_seq
        AND      R.N3PTY_DELT_TP_CD = 'N'
        ;

        UPDATE   TPB_INV_RVIS
        SET      CLT_AGN_FLG = NVL(in_clt_agn_flg,'N')
               , CLT_AGN_RMK = in_clt_agn_rmk
               , CLT_AGN_DT = DECODE( NVL(in_clt_agn_flg,'N'), 'Y', SYSDATE)
               , ( CO_NM, OFC_ADDR, OFC_PHN_NO, OFC_FAX_NO, BIL_TO_LOC_DIV_CD, INV_RMK1, INV_RMK2 )
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
        AND      N3PTY_INV_NO = in_n3pty_inv_no
        AND      N3PTY_INV_RVIS_SEQ = out_new_rvis_seq
        ;


        TPB_INV_RVIS_PKG.UPD_OTS_GRP_INFO( in_n3pty_no, in_n3pty_inv_no, out_new_rvis_seq, out_new_rvis_cd, out_new_creditnote_seq, out_new_creditnote_cd, in_user_ofc_cd, in_user_id, in_curr_cd, in_sum_inv_amt, in_clt_agn_flg );

    END IF;



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
        in_ots_dtl_seq IN VARCHAR2,
        in_new_rvis_seq IN VARCHAR2, --------
        in_new_rvis_cd IN VARCHAR2, --------
        in_new_creditnote_seq IN VARCHAR2, -------- credit note
        in_new_creditnote_cd IN VARCHAR2, -------- credit note
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
        in_vat_dtl_amt IN VARCHAR2,
        in_lod_id IN VARCHAR2,
        in_inv_dtl_add_amt IN VARCHAR2
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
    --[CHM-201220985] START-----------------------------------------------------
        ,act_atd_inp_dt
        ,tml_nm
        ,acct_nm
    --[CHM-201220985]   END-----------------------------------------------------
        ,lod_id
        ,add_amt
    )
    SELECT
        n3pty_inv_no, in_new_rvis_seq,
        n3pty_inv_rvis_dtl_seq,
        n3pty_no, ots_dtl_seq,
        n3pty_delt_tp_cd, n3pty_bil_tp_cd, eq_knd_cd, eq_no, eq_tpsz_cd,
        bkg_no, bl_no,
        vsl_cd, skd_voy_no, skd_dir_cd, finc_dir_cd, in_yd_cd,
        fm_nod_cd, via_nod_cd, to_nod_cd, dor_nod_cd, in_new_eq_no,
        in_new_cntr_seal_no,  TO_DATE(in_lst_free_dt,'YYYY-MM-DD'), in_ots_amt, corr_ots_amt, rev_amt,
        in_inv_dtl_amt, TO_DATE(in_pkup_dt,'YYYY-MM-DD'), in_ft_ovr_dys, in_cita_no, in_cntr_wgt,
        in_n3pty_cntr_wgt_ut_cd, in_wt_hrs, TO_DATE(in_occr_dt,'YYYY-MM-DD'), SUBSTRB(in_new_vsl_cd,1,4), SUBSTRB(in_new_vsl_cd,5,4),
        SUBSTRB(in_new_vsl_cd,9,2), in_new_bkg_no, in_acct_cd, in_lgs_cost_cd, so_no,
        csr_no, gl_dt, vvd_cd, estm_sys_area_grp_id, in_user_id,
        SYSDATE, in_user_id, SYSDATE, in_vat_dtl_amt
    --[CHM-201220985] START-----------------------------------------------------
        ,( SELECT  MIN(VPS_ETD_DT)
           FROM    VSK_VSL_PORT_SKD
           WHERE   VSL_CD = SUBSTR(in_vvd_cd,1,4)
           AND     SKD_VOY_NO = SUBSTR(in_vvd_cd,5,4)
           AND     SKD_DIR_CD  = SUBSTR(in_vvd_cd,9,1)
           AND     YD_CD = in_yd_cd
         )
        ,( SELECT  YD_NM
           FROM    MDM_YARD
           WHERE   YD_CD = in_yd_cd
         )
        ,(
           SELECT  ACCT_ENG_NM VAL
           FROM    MDM_ACCOUNT
           WHERE   ACCT_CD = in_acct_cd
         )
    --[CHM-201220985]   END-----------------------------------------------------
       ,in_lod_id
       ,in_inv_dtl_add_amt
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
       -- IF ( n_grp_bal_amt = 0.0 ) THEN   --by [CHM-201216957] [TPB] Status "ERP Interface"의 변경 요청

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

        --END IF;

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