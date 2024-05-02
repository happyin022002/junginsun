CREATE OR REPLACE PROCEDURE NISADM.TPB_CRE_IF_DATA_REV_PRC 
 
 /******************************************************************************* 
   1. Object Name      : TPB_CRE_IF_DATA_REV_PRC 
   2. Version          : 1.0 
   3. Create Date      : 2015.01.02 
   4. Sub System       : Third Party Billing 
   5. Author           : JS, AN 
   6. Description      : Logistic Revenue TPB Data Creation - Single 
                         ------------------------------------------------------- 
   7. Revision History : 2015.01.02  Creation 
                         2015.03.10  customer code 추가 
                         2015.08.25  GL date 추가(cost_prd_fm_dt), VVD의 Month를 cost_prd_fm_dt 와 동일하게 함. 
                         2015.11.18  India local tax(SBC charge) 로직 보완 
                         2016.05.19  India local tax(KKC charge) 로직 보완 
                         2017.06.08  버그 수정 및 에러 메시지 출력 
 *******************************************************************************/ 
  
-- ===== Arguments ======================================== 
(     
    in_n3pty_tp_cd                      IN  VARCHAR2,       -- Interface Type  
    in_expn_tp_cd                       IN  VARCHAR2,       -- Expense Type 
    in_bil_tp_cd                        IN  VARCHAR2,       -- Logistic Rev.Code 
    in_cost_ofc_cd                      IN  VARCHAR2,       -- Cost Office 
    in_src_vndr_cnt_cd                  IN  VARCHAR2,       -- S/P 
    in_src_vndr_seq                     IN  VARCHAR2,       -- S/P 
    in_vndr_cust_div_cd                 IN  VARCHAR2,       -- Custmer type  2015.03.10 
    in_cust_cnt_cd                      IN  VARCHAR2,       -- Customer 2015.03.10 
    in_cust_seq                         IN  VARCHAR2,       -- Customer 2015.03.10 
    in_cost_prd_fm_dt                   IN  VARCHAR2,       -- Cost Period 
    in_cost_prd_to_dt                   IN  VARCHAR2,       -- Cost Period 
    in_cfm_curr_cd                      IN  VARCHAR2,       -- Currency 
    in_ttl_amt                          IN  VARCHAR2,       -- Total Amount 
    in_tax                              IN  VARCHAR2,       -- Tax 
    in_locl_tax_amt                     IN  VARCHAR2,       -- india SBC Tax 
    in_n2nd_locl_tax_amt                IN  VARCHAR2,       -- india KKC Tax 
    in_dtl_rmk                          IN  VARCHAR2,       -- Detail 
    in_re_yd_cd                         IN  VARCHAR2,       -- Yard in Head 
    in_user_ofc_cd                      IN  VARCHAR2,       -- user office code 
    in_user_id                          IN  VARCHAR2,       -- user id 
    out_tpb_no                          OUT VARCHAR2,       -- TPB_No 
    out_inv_no                          OUT VARCHAR2,       -- TPB_INV_No 
    out_rtn_cd                          OUT VARCHAR2        -- Return Rsult Code 
) IS  
 
-- ===== DECLARE ========================================== 
    USER_DEFINED_CNTC_PNT_EXCPT         EXCEPTION; 
 
    v_src_sys_cd                        VARCHAR2(3); 
    v_null_sys_cd                       VARCHAR2(1); 
    v_ida_flg                           VARCHAR2(1) := 'N'; 
    v_gl_dt                             VARCHAR2(8); 
    v_dtl_vat                           VARCHAR2(20); 
     
    v_ots_dtl_seq                       TPB_OTS_DTL.OTS_DTL_SEQ%TYPE; 
    v_n3pty_no                          TPB_OTS_DTL.N3PTY_NO%TYPE; 
    v_n3pty_inv_no                      TPB_INVOICE.N3PTY_INV_NO%TYPE; 
    out_n3pty_inv_no                    TPB_INVOICE.N3PTY_INV_NO%TYPE; 
    v_n3pty_inv_rvis_seq                TPB_INVOICE.LST_N3PTY_INV_RVIS_SEQ%TYPE; 
    out_n3pty_inv_rvis_seq              TPB_INVOICE.LST_N3PTY_INV_RVIS_SEQ%TYPE; 
    in_ida_tax_seq                      TPB_INV_RVIS.IDA_TAX_SEQ%TYPE; 
    v_ofc_cty_cd                        TPB_INV_NO_GEN.N3PTY_INV_OFC_CTY_CD%TYPE; 
    v_yrmon                             TPB_INV_NO_GEN.N3PTY_INV_YRMON%TYPE; 
    v_bil_tp_cd                         TPB_INV_NO_GEN.N3PTY_BIL_TP_CD%TYPE; 
    v_lst_inv_no                        TPB_INV_NO_GEN.LST_N3PTY_INV_NO%TYPE; 
    v_acct_cd                           TPB_N3RD_PTY_BIL_TP.REV_ACCT_CD%TYPE; 
     
    in_vndr_cust_nm                     MDM_VENDOR.VNDR_LGL_ENG_NM%TYPE; 
    in_vndr_cust_addr                   MDM_VENDOR.ENG_ADDR%TYPE; 
    in_vndr_cust_eml                    MDM_VNDR_CNTC_PNT.VNDR_EML%TYPE; 
    in_fax_no                           MDM_VNDR_CNTC_PNT.FAX_NO%TYPE; 
    in_phn_no                           MDM_VNDR_CNTC_PNT.PHN_NO%TYPE; 
    in_rgst_no                          MDM_VENDOR.RGST_NO%TYPE; 
    in_cty_nm                           MDM_VENDOR.CHK_DE_CTY_NM%TYPE; 
    in_ste_cd                           MDM_VENDOR.CHK_DE_STE_CD%TYPE; 
    in_zip_cd                           MDM_VENDOR.ZIP_CD%TYPE; 
 
    v_err_cd                            VARCHAR2(10) := '000000'; 
    v_message                           VARCHAR2(500); 
    n_affected_rows                     NUMBER(8);  
     
 
BEGIN 
 
--    DBMS_OUTPUT.ENABLE;   
    DBMS_OUTPUT.DISABLE; 
 
    ----- Initiate varibles  
    --v_result := 'TPBHAM14120020'                -- test!! 
    v_src_sys_cd            := in_expn_tp_cd; 
    v_null_sys_cd           := ''; 
    v_n3pty_no              := ''; 
    v_n3pty_inv_no          := ''; 
    v_n3pty_inv_rvis_seq    := ''; 
    v_gl_dt                 := in_cost_prd_fm_dt; 
    v_dtl_vat               := in_tax ; 
 
    BEGIN 
        SELECT   REV_ACCT_CD 
        INTO     v_acct_cd 
        FROM     TPB_N3RD_PTY_BIL_TP 
        WHERE    1 = 1 
        AND      N3PTY_TP_CD = 'R' 
        AND      N3PTY_EXPN_TP_CD = in_expn_tp_cd 
        AND      N3PTY_BIL_TP_CD = in_bil_tp_cd 
        ; 
    EXCEPTION 
        WHEN OTHERS THEN 
            v_message := '01'; 
            DBMS_OUTPUT.PUT_LINE('TPB_N3RD_PTY_BIL_TP.REV_ACCT_CD EXCEPTION-'|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd); 
    END; 
     
     
    BEGIN 
        IF in_vndr_cust_div_cd = 'C' THEN 
            BEGIN 
                SELECT   F.FAX_NO 
                       , P.PHN_NO 
                       , B.BZET_ADDR||'\n'||' Tel: '||P.PHN_NO ENG_ADDR 
                       , A.CUST_LGL_ENG_NM 
                       , E.CUST_EML 
                       , A.CUST_RGST_NO RGST_NO 
                       , B.CTY_NM 
                       , B.STE_CD 
                       , B.ZIP_CD 
                INTO     in_fax_no 
                       , in_phn_no 
                       , in_vndr_cust_addr 
                       , in_vndr_cust_nm 
                       , in_vndr_cust_eml 
                       , in_rgst_no 
                       , in_cty_nm 
                       , in_ste_cd 
                       , in_zip_cd 
                FROM     MDM_CUSTOMER A 
                       , MDM_CUST_ADDR B 
                       , ( 
                           SELECT   /*+ INDEX_DESC(C XPKMDM_CUST_CNTC_PNT) */ 
                                    C.* 
                           FROM     MDM_CUST_CNTC_PNT C 
                           WHERE    1 = 1 
                           AND      C.PHN_NO IS NOT NULL 
                           AND      C.CUST_CNT_CD = in_cust_cnt_cd 
                           AND      C.CUST_SEQ = in_cust_seq 
                           AND      ROWNUM = 1 
                         ) P 
                       , ( 
                           SELECT   /*+ INDEX_DESC(C XPKMDM_CUST_CNTC_PNT) */  
                                    C.*  
                           FROM     MDM_CUST_CNTC_PNT C 
                           WHERE    1 = 1 
                           AND      C.FAX_NO IS NOT NULL 
                           AND      C.CUST_CNT_CD = in_cust_cnt_cd 
                           AND      C.CUST_SEQ = in_cust_seq 
                           AND      ROWNUM = 1 
                         ) F 
                       , ( 
                           SELECT   /*+ INDEX_DESC(C XPKMDM_CUST_CNTC_PNT) */  
                                    C.*  
                           FROM     MDM_CUST_CNTC_PNT C 
                           WHERE    1 = 1 
                           AND      C.CUST_EML IS NOT NULL 
                           AND      C.CUST_CNT_CD = in_cust_cnt_cd 
                           AND      C.CUST_SEQ = in_cust_seq 
                           AND      ROWNUM = 1 
                         ) E 
                WHERE    1 = 1 
                AND      A.CUST_CNT_CD = B.CUST_CNT_CD(+) 
                AND      A.CUST_SEQ = B.CUST_SEQ(+) 
                AND      A.CUST_CNT_CD = P.CUST_CNT_CD(+) 
                AND      A.CUST_SEQ = P.CUST_SEQ(+) 
                AND      A.CUST_CNT_CD = F.CUST_CNT_CD(+) 
                AND      A.CUST_SEQ = F.CUST_SEQ(+) 
                AND      A.CUST_CNT_CD = E.CUST_CNT_CD(+) 
                AND      A.CUST_SEQ = E.CUST_SEQ(+) 
                AND      ( B.PRMRY_CHK_FLG = 'Y' OR B.PRMRY_CHK_FLG IS NULL ) 
                AND      ( A.NMD_CUST_FLG IS NULL OR A.NMD_CUST_FLG != 'Y' ) 
                AND      A.DELT_FLG = 'N' 
                AND      A.CUST_CNT_CD = in_cust_cnt_cd 
                AND      A.CUST_SEQ =  in_cust_seq 
                AND      ROWNUM = 1 
                ; 
            EXCEPTION 
                WHEN OTHERS THEN 
                    v_message := '21'; 
                    DBMS_OUTPUT.PUT_LINE('MDM_CUSTOMER EXCEPTION-'|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd); 
            END; 
        ELSE 
            BEGIN 
                SELECT   F.FAX_NO   
                       , P.PHN_NO  
                       , B.ENG_ADDR AS VNDR_CUST_ADDR   
                       , B.VNDR_LGL_ENG_NM AS VNDR_CUST_NM 
                       , E.VNDR_EML AS VNDR_CUST_EML 
                       , B.TAX_ID AS RGST_NO 
                       , B.CHK_DE_CTY_NM 
                       , B.CHK_DE_STE_CD 
                       , B.ZIP_CD  
                INTO     in_fax_no 
                       , in_phn_no 
                       , in_vndr_cust_addr 
                       , in_vndr_cust_nm 
                       , in_vndr_cust_eml 
                       , in_rgst_no 
                       , in_cty_nm 
                       , in_ste_cd 
                       , in_zip_cd 
                FROM     MDM_VENDOR B  
                       , ( 
                           SELECT   /*+ INDEX_DESC(C XPKMDM_VNDR_CNTC_PNT) */ 
                                    C.* 
                           FROM     MDM_VNDR_CNTC_PNT C 
                           WHERE    1 = 1 
                           AND      PHN_NO IS NOT NULL 
                           AND      C.DELT_FLG = 'N' 
                           AND      C.VNDR_SEQ = in_src_vndr_seq 
                           AND      ROWNUM = 1 
                         ) P 
                       , ( 
                           SELECT   /*+ INDEX_DESC(C XPKMDM_VNDR_CNTC_PNT) */ 
                                    C.* 
                           FROM     MDM_VNDR_CNTC_PNT C 
                           WHERE    1 = 1 
                           AND      FAX_NO IS NOT NULL 
                           AND      C.DELT_FLG = 'N' 
                           AND      C.VNDR_SEQ = in_src_vndr_seq 
                           AND      ROWNUM = 1 
                         ) F 
                       , ( 
                           SELECT   /*+ INDEX_DESC(C XPKMDM_VNDR_CNTC_PNT) */ 
                                    C.* 
                           FROM     MDM_VNDR_CNTC_PNT C 
                           WHERE    1 = 1 
                           AND      VNDR_EML IS NOT NULL 
                           AND      C.DELT_FLG = 'N' 
                           AND      C.VNDR_SEQ = in_src_vndr_seq 
                           AND      ROWNUM = 1 
                         ) E 
                WHERE    1 = 1 
                AND      B.VNDR_SEQ = P.VNDR_SEQ(+) 
                AND      B.VNDR_SEQ = F.VNDR_SEQ(+) 
                AND      B.VNDR_SEQ = E.VNDR_SEQ(+) 
                AND      B.VNDR_SEQ = in_src_vndr_seq 
                AND      ROWNUM = 1 
                ; 
            EXCEPTION 
                WHEN OTHERS THEN 
                    v_message := '22'; 
                    DBMS_OUTPUT.PUT_LINE('MDM_VENDOR EXCEPTION-'|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd); 
            END; 
             
            IF in_fax_no IS NULL AND in_phn_no IS NULL AND in_vndr_cust_eml IS NULL THEN 
--                out_rtn_cd  := '10'; 
                RAISE USER_DEFINED_CNTC_PNT_EXCPT; 
            END IF; 
        END IF; 
 
 
        ----------------------------------  
        --1. create candidate 
        ----------------------------------  
        SELECT   TPB_OTS_DTL_SEQ1.NEXTVAL AS OTS_DTL_SEQ 
        INTO     v_ots_dtl_seq 
        FROM     DUAL 
        ; 
         
        ---------------------------------- 
        BEGIN 
            INSERT INTO TPB_OTS_DTL 
            (  
                     OTS_DTL_SEQ 
                   , N3PTY_TP_CD 
                   , N3PTY_SRC_SUB_SYS_CD 
                   , N3PTY_EXPN_TP_CD 
                   , N3PTY_BIL_TP_CD      
                   , ACCT_CD 
                   , OFC_CD 
                   , COST_OFC_CD 
                   , SRC_VNDR_CNT_CD 
                   , SRC_VNDR_SEQ 
                   , COST_PRD_FM_DT 
                   , COST_PRD_TO_DT 
                   , IF_CURR_CD 
                   , IF_AMT 
                   , CFM_RMK 
                   , N3PTY_CFM_CD 
                   , N3PTY_IF_TP_CD 
                   , N3PTY_DELT_TP_CD 
                   , IF_USR_ID 
                   , IF_DT 
                   , IF_RHQ_CD 
                   , IF_OFC_CD 
                   , CRE_USR_ID 
                   , CRE_DT 
                   , UPD_USR_ID 
                   , UPD_DT 
                   , VSL_CD 
                   , SKD_VOY_NO 
                   , SKD_DIR_CD 
                   , FINC_DIR_CD 
                   , COST_EXPT_FLG 
                   , RE_YD_CD 
                   , VNDR_CUST_DIV_CD 
                   , CUST_CNT_CD 
                   , CUST_SEQ 
                   , GL_DT 
            ) 
            SELECT   v_ots_dtl_seq              AS OTS_DTL_SEQ 
                   , in_n3pty_tp_cd             AS N3PTY_TP_CD 
                   , in_expn_tp_cd              AS N3PTY_SRC_SUB_SYS_CD 
                   , in_expn_tp_cd              AS N3PTY_EXPN_TP_CD 
                   , in_bil_tp_cd               AS N3PTY_BIL_TP_CD 
                   , v_acct_cd                  AS ACCT_CD 
                   , in_cost_ofc_cd             AS OFC_CD 
                   , in_cost_ofc_cd             AS COST_OFC_CD 
                   , UPPER(in_src_vndr_cnt_cd)  AS SRC_VNDR_CNT_CD 
                   , in_src_vndr_seq            AS SRC_VNDR_SEQ 
                   , in_cost_prd_fm_dt          AS COST_PRD_FM_DT 
                   , in_cost_prd_to_dt          AS COST_PRD_TO_DT 
                   , in_cfm_curr_cd             AS IF_CURR_CD 
                   , in_ttl_amt                 AS IF_AMT 
                   , in_dtl_rmk                 AS CFM_RMK 
                   , 'I'                        AS N3PTY_CFM_CD 
                   , 'M'                        AS N3PTY_IF_TP_CD 
                   , 'N'                        AS N3PTY_DELT_TP_CD 
                   , in_user_id                 AS IF_USR_ID 
                   , SYSDATE                    AS IF_DT 
                   , TPB_GET_HNDL_OFC_FNC('R',TPB_GET_N3PTY_OFC_CD_FNC(in_user_ofc_cd)) AS IF_RHQ_CD 
                   , in_user_ofc_cd             AS IF_OFC_CD 
                   , in_user_id                 AS CRE_USR_ID 
                   , SYSDATE                    AS CRE_DT 
                   , in_user_id                 AS UPD_USR_ID 
                   , SYSDATE                    AS UPD_DT 
                   , 'CNTC'                     AS VSL_CD 
                   , SUBSTR(in_cost_prd_fm_dt,3,4) AS SKD_VOY_NO 
                   , 'M'                        AS SKD_DIR_CD 
                   , 'MM'                       AS FINC_DIR_CD 
                   , 'N'                        AS COST_EXPT_FLG 
                   , in_re_yd_cd                AS RE_YD_CD 
                   , in_vndr_cust_div_cd        AS VNDR_CUST_DIV_CD 
                   , UPPER(in_cust_cnt_cd)      AS CUST_CNT_CD 
                   , in_cust_seq                AS CUST_SEQ 
                   , v_gl_dt                    AS GL_DT 
            FROM     DUAL 
            ; 
        EXCEPTION 
            WHEN OTHERS THEN 
                v_message := '02'; 
                DBMS_OUTPUT.PUT_LINE('INSERT TPB_OTS_DTL EXCEPTION-'|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd); 
        END; 
 
          
        TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'Z', in_user_id);  
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Interfaced from '||v_src_sys_cd||'.','A','',in_user_ofc_cd,in_user_id); 
 
 
        ----------------------------------  
        --2. CREATE TPB  
        ----------------------------------  
        TPB_CANDIDATE_CONFIRM_PRC 
        ( 
              v_null_sys_cd 
            , 'I' 
            , v_ots_dtl_seq 
            , in_cost_ofc_cd 
            , in_user_id 
            , in_dtl_rmk 
            , v_null_sys_cd 
            , in_cfm_curr_cd 
            , in_ttl_amt 
            , in_vndr_cust_div_cd  ---'V' 
            , UPPER(in_src_vndr_cnt_cd) 
            , in_src_vndr_seq 
            , UPPER(in_cust_cnt_cd) -- v_null_sys_cd 
            , in_cust_seq           -- v_null_sys_cd 
            , in_cost_ofc_cd 
            , v_n3pty_no 
         ) 
         ; 
 
 
        ----------------------------------  
        --3. CREATE TPB INVOICE 
        ---------------------------------- 
        BEGIN 
            SELECT   DECODE(C.CNT_CD,'IN','Y','N') 
            INTO     v_ida_flg 
            FROM     MDM_ORGANIZATION B 
                   , MDM_LOCATION C 
            WHERE    1 = 1 
            AND      B.LOC_CD = C.LOC_CD 
            AND      NVL(B.DELT_FLG,'N') = 'N' 
            AND      NVL(C.DELT_FLG,'N') = 'N' 
            AND      B.OFC_CD = in_cost_ofc_cd 
            AND      ROWNUM = 1 
            ; 
        EXCEPTION 
            WHEN OTHERS THEN 
                v_message := '03'; 
                DBMS_OUTPUT.PUT_LINE('MDM_ORGANIZATION TPB_OTS_DTL EXCEPTION-'|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd); 
        END; 
 
        IF v_ida_flg = 'Y' THEN 
            SELECT   IDA_TAX_SEQ 
            INTO     in_ida_tax_seq 
            FROM     TPB_IDA_TAX 
            WHERE    1 = 1 
            AND      EFF_DT = ( SELECT MAX(EFF_DT) FROM TPB_IDA_TAX WHERE EFF_DT < SYSDATE AND (DELT_FLG = 'N' OR DELT_FLG IS NULL) GROUP BY OFC_CD ) 
            AND      (DELT_FLG = 'N' OR DELT_FLG IS NULL) 
            ; 
             
            v_dtl_vat:=  '0'; 
        ELSE 
            SELECT   0 
            INTO     in_ida_tax_seq 
            FROM     DUAL 
            ; 
             
            v_dtl_vat:=  in_tax; 
        END IF;     
 
 
        SELECT   N3PTY_NO 
        INTO     v_n3pty_no 
        FROM     TPB_OTS_DTL 
        WHERE    1 = 1 
        AND      OTS_DTL_SEQ = v_ots_dtl_seq 
        ; 
         
        --- ====== get tpb invoice no. ===========  
        v_ofc_cty_cd := SUBSTRB(TRIM(in_cost_ofc_cd),1,3); 
        v_lst_inv_no := NULL; 
        v_bil_tp_cd := in_bil_tp_cd; 
 
        SELECT   TO_CHAR(SYSDATE,'YY') ||  
                 DECODE( TO_NUMBER(TO_CHAR(SYSDATE,'MM')),  
                    10, 'A' 
                  , 11, 'B' 
                  , 12, 'C' 
                  , TO_NUMBER(TO_CHAR(SYSDATE,'MM')) 
                 )  
        INTO     v_yrmon  
        FROM     DUAL  
        ; 
         
         
        --- ====== IF City Code is valid =========== 
        IF ( LENGTHB(v_ofc_cty_cd) = 3 ) AND (LENGTHB(v_bil_tp_cd) = 2) THEN ---------------------- 
 
            --- ======================================== 
            --- seq++  3rd party no  
            --- ======================================== 
 
            ----- Update(Insert) seq / 3PB No.------------------------------     
            MERGE INTO TPB_INV_NO_GEN A 
                USING ( 
                    SELECT   NVL(MAX(N3PTY_INV_SEQ),0)+1 NEXT_SEQ 
                    FROM     TPB_INV_NO_GEN 
                    WHERE    1 = 1 
                    AND      N3PTY_INV_OFC_CTY_CD = v_ofc_cty_cd 
                    AND      N3PTY_INV_YRMON = v_yrmon 
                    AND      N3PTY_BIL_TP_CD = v_bil_tp_cd 
                ) B ON 
                (            A.N3PTY_INV_OFC_CTY_CD = v_ofc_cty_cd 
                    AND      A.N3PTY_INV_YRMON = v_yrmon 
                    AND      A.N3PTY_BIL_TP_CD = v_bil_tp_cd 
                ) 
            WHEN MATCHED THEN 
                UPDATE 
                SET      N3PTY_INV_SEQ = B.NEXT_SEQ 
                       , LST_N3PTY_INV_NO = N3PTY_INV_OFC_CTY_CD || N3PTY_INV_YRMON || N3PTY_BIL_TP_CD || TRIM(TO_CHAR(B.NEXT_SEQ,'000')) 
                       , UPD_USR_ID = in_user_id 
                       , UPD_DT = SYSDATE 
            WHEN NOT MATCHED THEN 
                INSERT 
                ( 
                         N3PTY_INV_OFC_CTY_CD 
                       , N3PTY_INV_YRMON 
                       , N3PTY_BIL_TP_CD 
                       , N3PTY_INV_SEQ 
                       , LST_N3PTY_INV_NO 
                       , CRE_USR_ID 
                       , CRE_DT 
                       , UPD_USR_ID 
                       , UPD_DT 
                ) VALUES 
                ( 
                         v_ofc_cty_cd 
                       , v_yrmon 
                       , v_bil_tp_cd 
                       , 1 
                       , v_ofc_cty_cd || v_yrmon || v_bil_tp_cd || TRIM(TO_CHAR(1,'000')) 
                       , in_user_id 
                       , SYSDATE 
                       , in_user_id 
                       , SYSDATE 
                ) 
            ; 
             
 
            ------------------------------------- 
            n_affected_rows := SQL%ROWCOUNT; --- affected rows 
             
            IF n_affected_rows != 1 THEN  --- abnormal  
                DBMS_OUTPUT.PUT_LINE('affected rows : ' || n_affected_rows); 
                v_lst_inv_no := NULL;  
            ELSE --- normal  
                ----- Getting 3PB No.  
                SELECT   LST_N3PTY_INV_NO  
                INTO     v_n3pty_inv_no  
                FROM     TPB_INV_NO_GEN A  
                WHERE    1 = 1 
                AND      A.N3PTY_INV_OFC_CTY_CD = v_ofc_cty_cd  
                AND      A.N3PTY_INV_YRMON = v_yrmon   
                AND      A.N3PTY_BIL_TP_CD = v_bil_tp_cd  
                ;  
            END IF; 
 
        END IF; 
      
 
         
        --- ====== IF TPB INV NO. is valid =========== 
        IF LENGTHB(v_n3pty_inv_no) = 11 THEN ---------------------- 
                 
            ----- INSERT INTO TPB_INVOICE ------------------------------     
            SELECT   NVL(MAX(N3PTY_INV_RVIS_SEQ),0) + 1 AS NEW_N3PTY_INV_RVIS_SEQ  
            INTO     v_n3pty_inv_rvis_seq  
            FROM     TPB_INV_RVIS  
            WHERE    1 = 1 
            AND      N3PTY_INV_NO = v_n3pty_inv_no 
            ;   
 
            ----- INSERT INTO TPB_INVOICE ------------------------------     
            INSERT INTO TPB_INVOICE 
            (  
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
                     v_n3pty_inv_no 
                   , v_n3pty_inv_rvis_seq 
                   , in_cost_ofc_cd 
                   , 'N' 
                   , NULL 
                   , v_n3pty_inv_no 
                   , in_user_id 
                   , SYSDATE 
                   , in_user_id 
                   , SYSDATE  
            );  
 
            ----- INSERT INTO TPB_INV_RVIS ------------------------------     
            INSERT INTO TPB_INV_RVIS 
            ( 
                     N3PTY_INV_NO 
                   , N3PTY_INV_RVIS_SEQ 
                   , N3PTY_INV_RVIS_CD 
                   , N3PTY_DELT_TP_CD 
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
                   , RCV_DUE_DT 
                   , RGST_NO 
                   , N3PTY_INV_STS_CD 
                   , CURR_CD 
                   , MON_XCH_RT 
                   , NET_AMT 
                   , VAT_AMT 
                   , INV_AMT 
                   , LOCL_TAX_AMT 
                   , N2ND_LOCL_TAX_AMT 
                   , INV_ISS_LOCL_DT 
                   , INV_ISS_GDT 
                   , INV_UPD_LOCL_DT 
                   , INV_UPD_GDT 
                   , IF_BL_NO 
                   , CRE_USR_ID 
                   , CRE_DT 
                   , UPD_USR_ID 
                   , UPD_DT 
                   , IDA_TAX_SEQ 
                   , CLT_AGN_FLG 
            ) 
            VALUES 
            ( 
                     v_n3pty_inv_no 
                   , v_n3pty_inv_rvis_seq 
                   , 'ORG' 
                   , 'N' 
                   , in_vndr_cust_div_cd 
                   , UPPER(in_src_vndr_cnt_cd) 
                   , in_src_vndr_seq 
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
                   , SYSDATE + 15 
                   , in_rgst_no 
                   , 'N' 
                   , in_cfm_curr_cd 
                   , TPB_GET_USD_XCH_RT_FNC(in_cfm_curr_cd, NVL(TPB_GET_LCL_DATE_FNC(SYSDATE,in_cost_ofc_cd),SYSDATE) ) 
                   , TO_NUMBER(in_ttl_amt) 
                   , TO_NUMBER(in_tax) 
                   , TO_NUMBER(in_ttl_amt) + TO_NUMBER(in_tax) + TO_NUMBER(in_locl_tax_amt) + TO_NUMBER(in_n2nd_locl_tax_amt) 
                   , TO_NUMBER(in_locl_tax_amt) 
                   , TO_NUMBER(in_n2nd_locl_tax_amt) 
                   , SYSDATE 
                   , SYSDATE 
                   , SYSDATE 
                   , SYSDATE 
                   , v_n3pty_inv_no 
                   , in_user_id 
                   , SYSDATE 
                   , in_user_id 
                   , SYSDATE 
                   , TO_NUMBER(in_ida_tax_seq) 
                   , 'N' 
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
                         AND      INV_ISS_OFC_CD = in_cost_ofc_cd 
                         AND      ROWNUM = 1 
                     )  
            WHERE    1 = 1 
            AND      N3PTY_INV_NO = v_n3pty_inv_no 
            AND      N3PTY_INV_RVIS_SEQ = v_n3pty_inv_rvis_seq  
            ; 
 
            --- ====== UPDATE TPB OUTSTANDING GROUP =========== 
            UPDATE   TPB_OTS_GRP B  
            SET      N3PTY_INV_NO = v_n3pty_inv_no 
                   , INV_AMT = TPB_GET_INV_CURR_CHG_FNC(in_cfm_curr_cd, B.curr_cd, (TO_NUMBER(in_ttl_amt) + TO_NUMBER(in_tax) + TO_NUMBER(in_locl_tax_amt) + TO_NUMBER(in_n2nd_locl_tax_amt)), SYSDATE) 
                   , UPD_USR_ID = in_user_id 
                   , UPD_DT = SYSDATE 
            WHERE    1 = 1 
            AND      N3PTY_NO = v_n3pty_no 
            ; 
 
            --- ====== ADD OUTSTANDING GROUP STATUS =========== 
            TPB_ADD_OTS_GRP_STS_PRC(v_n3pty_no, 'I', in_user_id);  
 
            --- ====== ADD OUTSTANDING GROUP RECOVERY ACTIVITY =========== 
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'','Invoice created.','A','',in_user_ofc_cd,in_user_id); 
 
        END IF; -------------------------------------------                                 
 
 
        ----------------------------------  
        --4. CREATE TPB INVOICE DETAIL 
        ----------------------------------  
        INSERT INTO TPB_INV_RVIS_DTL 
        ( 
                 N3PTY_INV_NO 
               , N3PTY_INV_RVIS_SEQ 
               , N3PTY_INV_RVIS_DTL_SEQ 
               , N3PTY_NO 
               , OTS_DTL_SEQ 
               , N3PTY_DELT_TP_CD 
               , N3PTY_BIL_TP_CD 
               , OTS_AMT 
               , INV_DTL_AMT 
               , ACCT_CD 
               , CRE_USR_ID 
               , CRE_DT 
               , UPD_USR_ID 
               , UPD_DT 
               , VAT_DTL_AMT 
               , ACCT_NM 
               , VSL_CD 
               , SKD_VOY_NO 
               , SKD_DIR_CD 
               , FINC_DIR_CD 
               , GL_DT 
        ) 
        VALUES 
        ( 
                 v_n3pty_inv_no 
               , v_n3pty_inv_rvis_seq 
               , 1 
               , v_n3pty_no 
               , v_ots_dtl_seq 
               , 'N' 
               , in_bil_tp_cd 
               , in_ttl_amt 
               , in_ttl_amt 
               , v_acct_cd 
               , in_user_id 
               , SYSDATE 
               , in_user_id 
               , SYSDATE 
               , v_dtl_vat 
               , ( SELECT ACCT_ENG_NM VAL FROM MDM_ACCOUNT WHERE ACCT_CD = v_acct_cd ) 
               , 'CNTC' 
               , SUBSTR(in_cost_prd_fm_dt,3,4) 
               , 'M' 
               , 'MM' 
               , v_gl_dt 
        ); 
      
      
        --- ====== UPDATE TPB OUTSTANDING GROUP =========== 
        UPDATE   TPB_OTS_DTL A  
        SET      INV_AMT = TPB_GET_INV_CURR_CHG_FNC(in_cfm_curr_cd, A.cfm_curr_cd, TO_NUMBER(in_ttl_amt), SYSDATE) 
               , UPD_USR_ID = in_user_id 
               , UPD_DT = SYSDATE 
        WHERE    1 = 1 
        AND      OTS_DTL_SEQ = v_ots_dtl_seq  
        AND      N3PTY_NO = v_n3pty_no 
        ;  
 
        --- ====== ADD OUTSTANDING GROUP STATUS =========== 
        TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'I', in_user_id); 
 
        --- ====== ADD OUTSTANDING GROUP RECOVERY ACTIVITY =========== 
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Invoice created.','A','',in_user_ofc_cd,in_user_id); 
    EXCEPTION 
    /* 사용자정의 오류 */ 
        WHEN USER_DEFINED_CNTC_PNT_EXCPT THEN 
            out_rtn_cd  := '10'; 
            v_message   := '10'; 
            DBMS_OUTPUT.PUT_LINE('Failed to save data. Please check and fill out Contact Points of 3rd Party(Customer, S/P) in MDM, then try again.'); 
    END; 
      
    out_tpb_no := v_n3pty_no; 
    out_inv_no := v_n3pty_inv_no; 
 
    DBMS_OUTPUT.PUT_LINE('out_tpb_no: '||out_tpb_no); 
    DBMS_OUTPUT.PUT_LINE('out_inv_no: '||out_inv_no); 
    DBMS_OUTPUT.PUT_LINE('out_rtn_cd: '||out_rtn_cd); 
 
EXCEPTION 
    
    WHEN NO_DATA_FOUND THEN 
        v_message   := '11'; 
        DBMS_OUTPUT.PUT_LINE('NO_DATA_FOUND EXCEPTION - '|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd); 
 
    WHEN OTHERS THEN 
        v_message   := '19'; 
        DBMS_OUTPUT.PUT_LINE('WHEN OTHERS EXCEPTION -'|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd); 
 
END TPB_CRE_IF_DATA_REV_PRC 
;