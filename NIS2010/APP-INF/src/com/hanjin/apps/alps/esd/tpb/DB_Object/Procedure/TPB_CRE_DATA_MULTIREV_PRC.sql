CREATE OR REPLACE PROCEDURE NISADM.TPB_CRE_DATA_MULTIREV_PRC

 /******************************************************************************************************
   1. Object Name      : TPB_CRE_DATA_MULTIREV_PRC
   2. Version          : 1.0
   3. Create Date      : 2015.01.02
   4. Sub System       : Third Party Billing
   5. Author           : JS, AN
   6. Description      : Logistic Revenue TPB Data Creation - Multiple 
                         -------------------------------------------------------
   7. Revision History : 2015.01.02  Creation
                         2015.01.29  [CHM-201533789]TPB_Logistics Revenue 관련 오류 및 기능 보완 요청 
                                     -multi는 mdm_vndr_cntc_pnt 체크하지 않기로  
                         2015.03.11  lgs_cost_cd 에 Cost_ofc_cd가 들어가고 있어서 수정함.
                         2015.08.25  Gl date 정보 추가(in_cost_prd_fm_dt), VVD의 Month를 cost_prd_fm_dt 와 동일하게 함.  
                                     EQ no 저장 추가
                         2015.11.18  India local tax(SBC charge) 로직 보완
                         2016.05.19  India local tax(KKC charge) 로직 보완
 *******************************************************************************************************/
 
-- ===== Arguments ========================================
(    
        in_n3pty_tp_cd     in VARCHAR2,     -- Interface Type : "R"
        in_expn_tp_cd      in VARCHAR2,     -- Expense Type : 
        in_bil_tp_cd       in VARCHAR2,     -- Logistic Rev.Code
        in_cost_ofc_cd     in VARCHAR2,     -- Cost Office
        in_cost_prd_fm_dt  in VARCHAR2,     -- Cost Period   : ex) 2014-10 이면 20141001 : 해당월 첫째날
        in_cost_prd_to_dt  in VARCHAR2,     -- Cost Period    : ex) 2014-10 이면 20141031 : 해당월 마지막날
        in_cfm_curr_cd     in VARCHAR2,     -- Currency
        
        in_src_vndr_cnt_cd in VARCHAR2,     -- |PLISM S/P No.
        in_src_vndr_seq    in VARCHAR2,     -- |PLISM S/P No.
        in_vndr_cnt_cd     in VARCHAR2,     -- |HJS S/P No.
        in_vndr_seq        in VARCHAR2,     -- |HJS S/P No.
        in_src_inv_no      in VARCHAR2,     -- |PLISM INV No.
        in_bkg_no          in VARCHAR2,     -- |I/B BKG No.
        in_yd_cd           in VARCHAR2,     -- |ORN CY
        in_new_bkg         in VARCHAR2,     -- |O/B BKG No.
        in_cntr_rtn_yd_cd  in VARCHAR2,     -- |Return CY
        in_cntr_rtn_dt     in VARCHAR2,     -- |Return Date
        in_rev_inv_rt      in VARCHAR2,     -- |Rate
        in_inv_amt         in VARCHAR2,     -- |AMT
        in_tax             in VARCHAR2,     -- |Tax total
        in_tax_amt         in VARCHAR2,     -- |Tax  -- TVA
        in_locl_tax_amt    in VARCHAR2,     -- india SBC Tax 
        in_n2nd_locl_tax_amt  in VARCHAR2,  -- india KKC Tax                                                              
        in_ttl_amt         in VARCHAR2,     -- |RCVD AMT

        in_re_yd_cd        in VARCHAR2,     -- Yard in Head        
        
        in_user_ofc_cd     in VARCHAR2,     -- user office code
        in_user_id         in VARCHAR2,     -- user id 
        in_eq_no           in VARCHAR2,     -- eq_no 
        out_tpb_no        out VARCHAR2,     -- TPB_No
        out_inv_no        out VARCHAR2      -- TPB_INV_No    
) 
authid CURRENT_USER

IS 

-- ===== DECLARE ==========================================
   

    v_src_sys_cd            VARCHAR2(3); 
    v_null_sys_cd           VARCHAR2(1); 
--    out_tpb_no              VARCHAR2(100); 
--    out_inv_no              VARCHAR2(100); 
    v_ots_dtl_seq           TPB_OTS_DTL.ots_dtl_seq%TYPE;
    v_n3pty_no              TPB_OTS_DTL.n3pty_no%TYPE;

    v_n3pty_inv_no          TPB_INVOICE.n3pty_inv_no%TYPE;
    out_n3pty_inv_no        TPB_INVOICE.n3pty_inv_no%TYPE;
    v_n3pty_inv_rvis_seq    TPB_INVOICE.lst_n3pty_inv_rvis_seq%TYPE;
    out_n3pty_inv_rvis_seq  TPB_INVOICE.lst_n3pty_inv_rvis_seq%TYPE;
    
    in_vndr_cust_nm         MDM_VENDOR.vndr_lgl_eng_nm%TYPE;
    in_vndr_cust_addr       MDM_VENDOR.ENG_ADDR%TYPE;
    in_vndr_cust_eml        mdm_vndr_cntc_pnt.vndr_eml%TYPE;
    in_fax_no               mdm_vndr_cntc_pnt.fax_no%TYPE;
    in_phn_no               mdm_vndr_cntc_pnt.phn_no%TYPE;
    in_rgst_no              MDM_VENDOR.rgst_no%TYPE;
    in_cty_nm               MDM_VENDOR.chk_de_cty_nm%TYPE;
    in_ste_cd               MDM_VENDOR.chk_de_ste_cd%TYPE;
    in_zip_cd               MDM_VENDOR.zip_cd%TYPE;

    in_ida_tax_seq          TPB_INV_RVIS.ida_tax_seq%TYPE;
     
    v_ida_flg               VARCHAR2(01) := 'N';
    
    v_ofc_cty_cd            TPB_INV_NO_GEN.n3pty_inv_ofc_cty_cd%TYPE;
    v_yrmon                 TPB_INV_NO_GEN.n3pty_inv_yrmon%TYPE;
    v_bil_tp_cd             TPB_INV_NO_GEN.n3pty_bil_tp_cd%TYPE;
    v_lst_inv_no            TPB_INV_NO_GEN.lst_n3pty_inv_no%TYPE;
    
    v_acct_cd               TPB_N3RD_PTY_BIL_TP.rev_acct_cd%TYPE;
    v_gl_dt                 VARCHAR2(8);
    v_dtl_vat               VARCHAR2(20); 
 
-- ========================================================
v_err_cd              VARCHAR2(10) := '000000';
v_err_cd_1            VARCHAR2(02) := '00';
v_err_cd_2            VARCHAR2(02) := '00';
v_message             VARCHAR2(500);



v_execute_row         NUMBER;
n_affected_rows       number(8); 
    
-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

--    DBMS_OUTPUT.enable;  
    DBMS_OUTPUT.disable;  


    ----- Initiate varibles 
    v_src_sys_cd  := in_expn_tp_cd;
    v_null_sys_cd := '';
    v_n3pty_no := '';
    v_n3pty_inv_no := '';
    v_n3pty_inv_rvis_seq := 0;
    v_gl_dt := in_cost_prd_fm_dt;
    v_dtl_vat:= in_tax ;

    SELECT REV_ACCT_CD INTO v_acct_cd
    FROM TPB_N3RD_PTY_BIL_TP
    WHERE N3PTY_TP_CD = 'R'
    AND N3PTY_EXPN_TP_CD = in_expn_tp_cd
    AND N3PTY_BIL_TP_CD = in_bil_tp_cd
    ;

    DBMS_OUTPUT.PUT_LINE('1');
    ---------------------------------- 
    --1. create candidate
    ---------------------------------- 
    SELECT tpb_ots_dtl_seq1.nextval ots_dtl_seq INTO v_ots_dtl_seq
    FROM DUAL;
    
    DBMS_OUTPUT.PUT_LINE('--2--');

    ---------------------------------- 
    INSERT INTO TPB_OTS_DTL ( 
        ots_dtl_seq, 
        n3pty_tp_cd,
        n3pty_src_sub_sys_cd, 
        n3pty_expn_tp_cd, 
        n3pty_bil_tp_cd,         
        acct_cd,  
        ofc_cd, 
        cost_ofc_cd, --lgs_cost_cd,
        
        n3pty_src_no, 
        VNDR_CUST_DIV_CD,
        VNDR_CNT_CD,
        VNDR_SEQ,        

        cost_prd_fm_dt, 
        cost_prd_to_dt,
        if_curr_cd, 
        if_amt,

        n3pty_cfm_cd,  --I 
        n3pty_if_tp_cd, --M
        n3pty_delt_tp_cd, --N
        if_usr_id, 
        if_dt, 
        if_rhq_cd, 
        if_ofc_cd, 
        cre_usr_id, 
        cre_dt, 
        upd_usr_id, 
        upd_dt 
        
        ,if_rmk                         -- |PLISM INV No.
        ,bkg_no                         -- |I/B BKG No.
        ,yd_cd                          -- |ORN CY
        ,FILE_NO                        -- |O/B BKG No.
        ,cntr_rtn_yd_cd                 -- |Return CY
        ,cntr_rtn_dt                    -- |Return Date
        ,SO_DTL_SEQ                     -- |Rate
        ,inv_amt                        -- |AMT
        
        ,vsl_cd
        ,skd_voy_no
        ,skd_dir_cd
        ,finc_dir_cd
        ,cost_expt_flg        
        
        ,re_yd_cd
        ,gl_dt
        ,eq_no
    ) SELECT 
        v_ots_dtl_seq,
        in_n3pty_tp_cd,     
        in_expn_tp_cd,      
        in_expn_tp_cd,      
        in_bil_tp_cd,       
        v_acct_cd,                      --TPB_N3RD_PTY_BIL_TP . ACCT_CD
        in_cost_ofc_cd,     
        in_cost_ofc_cd,     
        in_src_vndr_cnt_cd||in_src_vndr_seq,    -- |PLISM S/P No.
        
        'V',
        in_vndr_cnt_cd,
        in_vndr_seq,
        
        in_cost_prd_fm_dt,  
        in_cost_prd_to_dt,  
        in_cfm_curr_cd,     
        in_inv_amt,             

        'I',
        'M',
        'N',
        in_user_id,         
        sysdate,
        TPB_GET_HNDL_OFC_FNC('R',TPB_GET_N3PTY_OFC_CD_FNC(in_user_ofc_cd)),
        in_user_ofc_cd,
        in_user_id,         
        sysdate,
        in_user_id,         
        sysdate
        
        ,in_src_inv_no                             -- |PLISM INV No.
        ,in_bkg_no                                 -- |I/B BKG No.
        ,in_yd_cd                                  -- |ORN CY
        ,in_new_bkg                                -- |O/B BKG No.
        ,in_cntr_rtn_yd_cd                         -- |Return CY
        ,TO_DATE(in_cntr_rtn_dt,'YYYYMMDD')              -- |Return Date
        ,in_rev_inv_rt                             -- |Rate
        ,in_inv_amt                                -- |AMT    
        
        ,'CNTC'
        --,TO_CHAR(SYSDATE,'YYMM') 
        , SUBSTR(in_cost_prd_fm_dt,3,4)
        ,'M'
        ,'MM'
        ,'N' 
        
        ,in_re_yd_cd
        ,v_gl_dt
        ,in_eq_no
    FROM DUAL 
    ;

     
    TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'Z', in_user_id); 
    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Interfaced from '||v_src_sys_cd||'.','A','',in_user_ofc_cd,in_user_id);

--    COMMIT;
--DBMS_OUTPUT.PUT_LINE('S1');



    ---------------------------------- 
    --2. create tpb 
    ---------------------------------- 
    TPB_CANDIDATE_CONFIRM_PRC(v_null_sys_cd
                            , 'I'
                            ,v_ots_dtl_seq
                            ,in_cost_ofc_cd
                            ,in_user_id
                            ,v_null_sys_cd
                            ,v_null_sys_cd
                            ,in_cfm_curr_cd
                            ,in_inv_amt
                            , 'V'
                            ,in_vndr_cnt_cd
                            ,in_vndr_seq
                            , v_null_sys_cd
                            , v_null_sys_cd
                            , in_cost_ofc_cd
                            , v_n3pty_no
     )
     ;
    
        
    ----------------------------------
--   COMMIT;
DBMS_OUTPUT.PUT_LINE('S2');


    ---------------------------------- 
    --3. create tpb invoice
    ---------------------------------- 

    SELECT DECODE(C.CNT_CD,'IN','Y','N') INTO v_ida_flg
    FROM MDM_ORGANIZATION B, (SELECT C.* FROM MDM_LOCATION C WHERE NVL(C.DELT_FLG,'N') <> 'Y') C
    WHERE 1 = 1
    AND B.OFC_CD = in_cost_ofc_cd
    AND NVL(B.DELT_FLG,'N') <> 'Y'
    AND B.LOC_CD = C.LOC_CD;
    
    DBMS_OUTPUT.PUT_LINE('S2-0');

    IF v_ida_flg = 'Y' THEN
        SELECT IDA_TAX_SEQ into in_ida_tax_seq
    --    ,EXPN_TAX
    --    ,EDU_TAX
    --    ,HIGH_EDU_TAX
        FROM TPB_IDA_TAX
        WHERE 1 = 1
        AND EFF_DT = ( SELECT MAX(EFF_DT) FROM TPB_IDA_TAX WHERE EFF_DT < SYSDATE AND (DELT_FLG != 'Y' OR DELT_FLG IS NULL) GROUP BY OFC_CD )
        AND (DELT_FLG != 'Y' OR DELT_FLG IS NULL)
        ;
        v_dtl_vat:= '0' ;
    ELSE
        SELECT 0 into in_ida_tax_seq FROM DUAL;
        v_dtl_vat:= in_tax ;
        
    END IF;   


    DBMS_OUTPUT.PUT_LINE('S2-1');
    
--    --- ====== get tpb invoice no. =========== 
    SELECT N3PTY_NO INTO v_n3pty_no
    FROM TPB_OTS_DTL
    WHERE OTS_DTL_SEQ = v_ots_dtl_seq;

    DBMS_OUTPUT.PUT_LINE('S2-2 '||v_n3pty_no);                            

--    --- ====== get tpb invoice no. =========== 
--    TPB_GEN_INV_NO_PRC(in_cost_ofc_cd, in_bil_tp_cd, in_user_id, v_n3pty_inv_no); 
    --- Initiate varibles 
    v_ofc_cty_cd := SUBSTRB(TRIM(in_cost_ofc_cd),1,3); 
    v_lst_inv_no := NULL;   
    v_bil_tp_cd := in_bil_tp_cd;

DBMS_OUTPUT.PUT_LINE('g0 '||v_ofc_cty_cd); 
    -- v_yrmon := TO_CHAR(SYSDATE,'YYMM') ; 
    SELECT TO_CHAR(SYSDATE,'YY') || 
        DECODE( TO_NUMBER(TO_CHAR(SYSDATE,'MM')), 
            10, 'A',
            11, 'B',
            12, 'C',
            TO_NUMBER(TO_CHAR(SYSDATE,'MM'))
        ) 
    INTO v_yrmon 
    FROM DUAL 
    ; 
DBMS_OUTPUT.PUT_LINE('g1 '||v_yrmon); 
    
    --- ====== IF City Code is valid ===========
    IF ( LENGTHB(v_ofc_cty_cd) = 3 ) AND (LENGTHB(v_bil_tp_cd) = 2) THEN ----------------------

DBMS_OUTPUT.PUT_LINE('g2 v_ofc_cty_cd :'||v_ofc_cty_cd); 
        --- ========================================
        --- seq++  3rd party no 
        --- ========================================

        ----- Update(Insert) seq / 3PB No.------------------------------    
        MERGE INTO tpb_inv_no_gen a 
            USING (
                SELECT NVL(MAX(n3pty_inv_seq),0)+1 next_seq   
                FROM tpb_inv_no_gen  
                WHERE  n3pty_inv_ofc_cty_cd = v_ofc_cty_cd 
                    AND n3pty_inv_yrmon = v_yrmon 
                    AND n3pty_bil_tp_cd = v_bil_tp_cd    --- Changed By Kim Jin-seung In 2007-05-31
            ) b 
            ON ( a.n3pty_inv_ofc_cty_cd = v_ofc_cty_cd 
                AND a.n3pty_inv_yrmon = v_yrmon  
                AND a.n3pty_bil_tp_cd = v_bil_tp_cd ) 
        WHEN MATCHED THEN 
            UPDATE SET  
                n3pty_inv_seq = b.next_seq,  
                lst_n3pty_inv_no = n3pty_inv_ofc_cty_cd || n3pty_inv_yrmon || n3pty_bil_tp_cd 
                               || TRIM(TO_CHAR(b.next_seq,'000')), 
                upd_usr_id = in_user_id, 
                upd_dt = SYSDATE 
        WHEN NOT MATCHED THEN 
            INSERT  ( 
                n3pty_inv_ofc_cty_cd, n3pty_inv_yrmon, n3pty_bil_tp_cd, n3pty_inv_seq, 
                lst_n3pty_inv_no, 
                cre_usr_id, cre_dt, upd_usr_id, upd_dt 
            ) VALUES ( 
                v_ofc_cty_cd, v_yrmon, v_bil_tp_cd, 1, 
                v_ofc_cty_cd || v_yrmon || v_bil_tp_cd || TRIM(TO_CHAR(1,'000')), 
                in_user_id, SYSDATE, in_user_id, SYSDATE 
            ) 
        ;
        
        
DBMS_OUTPUT.PUT_LINE('g3 '); 
        -------------------------------------
        n_affected_rows := SQL%ROWCOUNT; --- affected rows
        
        IF n_affected_rows != 1 THEN  --- abnormal 
            DBMS_OUTPUT.PUT_LINE('affected rows : ' || n_affected_rows);
            v_lst_inv_no := NULL; 
        ELSE --- normal 
            ----- Getting 3PB No. 
            SELECT lst_n3pty_inv_no 
            INTO v_n3pty_inv_no 
            FROM tpb_inv_no_gen a 
            WHERE a.n3pty_inv_ofc_cty_cd = v_ofc_cty_cd 
                AND a.n3pty_inv_yrmon = v_yrmon  
                AND a.n3pty_bil_tp_cd = v_bil_tp_cd 
            ; 
        END IF; ---

    END IF; -------------------------------------------
--    COMMIT;
    
DBMS_OUTPUT.PUT_LINE('g4 ');      


--    SELECT lst_n3pty_inv_no 
--    INTO out_n3pty_inv_no  
--    FROM tpb_inv_no_gen 
--    WHERE lst_n3pty_inv_no = v_n3pty_inv_no 
--    FOR UPDATE NOWAIT 
--    ;    
    
--ㅡ<multi는 mdm_vndr_cntc_pnt 체크하지 않기로-20150129>
--        SELECT m.FAX_NO  
--              ,m.PHN_NO 
--              ,B.ENG_ADDR  AS VNDR_CUST_ADDR  
--              ,B.VNDR_LGL_ENG_NM  AS VNDR_CUST_NM
--              ,VNDR_EML AS VNDR_CUST_EML
--              ,(SELECT TAX_ID FROM MDM_VENDOR WHERE VNDR_SEQ = in_vndr_seq) RGST_NO
--              ,B.chk_de_cty_nm, B.chk_de_ste_cd, B.zip_cd 
--        INTO  in_fax_no,in_phn_no,in_vndr_cust_addr,in_vndr_cust_nm,in_vndr_cust_eml, in_rgst_no
--              ,in_cty_nm, in_ste_cd, in_zip_cd
--         FROM MDM_VENDOR B 
--              ,mdm_vndr_cntc_pnt m
--         WHERE 1 = 1
--           AND B.VNDR_SEQ = in_vndr_seq
--           and b.vndr_seq = m.vndr_seq(+)
--           AND M.delt_flg = 'N'
--           AND ROWNUM = 1
--           ;
DBMS_OUTPUT.PUT_LINE('g4-1 '); 
    
--        --- ====== IF TPB INV NO. is valid ===========
        IF LENGTHB(v_n3pty_inv_no) = 11 THEN ----------------------

 DBMS_OUTPUT.PUT_LINE('g4-2 ');            
            ----- insert into tpb_invoice ------------------------------    
            SELECT NVL(MAX(n3pty_inv_rvis_seq),0) + 1 AS new_n3pty_inv_rvis_seq 
            INTO v_n3pty_inv_rvis_seq 
            FROM tpb_inv_rvis 
            WHERE n3pty_inv_no = v_n3pty_inv_no
            ;  
DBMS_OUTPUT.PUT_LINE('g4-3 '); 
            ----- insert into tpb_invoice ------------------------------    
            INSERT INTO tpb_invoice ( 
                n3pty_inv_no, lst_n3pty_inv_rvis_seq, ofc_cd, n3pty_delt_tp_cd, lnk_n3pty_inv_no, 
                if_bl_no, cre_usr_id, cre_dt, upd_usr_id, upd_dt 
            ) VALUES ( 
                v_n3pty_inv_no, v_n3pty_inv_rvis_seq, in_cost_ofc_cd, 'N', NULL, 
                v_n3pty_inv_no, in_user_id, SYSDATE, in_user_id, SYSDATE 
            ); 
DBMS_OUTPUT.PUT_LINE('g4-4 '); 
            ----- insert into tpb_inv_rvis ------------------------------    
            INSERT INTO tpb_inv_rvis (
                n3pty_inv_no, n3pty_inv_rvis_seq, n3pty_inv_rvis_cd, n3pty_delt_tp_cd, 
                vndr_cust_div_cd, 
                vndr_cnt_cd, vndr_seq, vndr_cust_nm, 
                vndr_cust_addr, vndr_cust_eml, cty_nm, ste_cd, zip_cd, 
                fax_no, phn_no, 
                --usr_inp_ctnt1, usr_inp_ctnt2, 
                rcv_due_dt, rgst_no, 
                n3pty_inv_sts_cd, curr_cd,  
                mon_xch_rt, 
                net_amt,vat_amt,inv_amt,locl_tax_amt, n2nd_locl_tax_amt, 
                inv_iss_locl_dt,inv_iss_gdt,inv_upd_locl_dt,inv_upd_gdt, 
                if_bl_no,cre_usr_id,cre_dt,upd_usr_id,upd_dt,ida_tax_seq
                ,clt_agn_flg
            ) VALUES (
                v_n3pty_inv_no, v_n3pty_inv_rvis_seq, 'ORG', 'N', 
                'V', 
                in_vndr_cnt_cd,in_vndr_seq, in_vndr_cust_nm, 
                in_vndr_cust_addr, in_vndr_cust_eml, in_cty_nm, in_ste_cd, in_zip_cd, 
                in_fax_no, in_phn_no, 
                --in_usr_inp_ctnt1, in_usr_inp_ctnt2, 
                (SYSDATE+15), in_rgst_no, 
                'N', in_cfm_curr_cd,
                TPB_GET_USD_XCH_RT_FNC(in_cfm_curr_cd, NVL(TPB_GET_LCL_DATE_FNC(SYSDATE,in_cost_ofc_cd),SYSDATE) ),
                TO_NUMBER(in_inv_amt), TO_NUMBER(in_tax_amt), TO_NUMBER(in_inv_amt)+TO_NUMBER(in_tax),TO_NUMBER(in_locl_tax_amt), TO_NUMBER(in_n2nd_locl_tax_amt),
                SYSDATE, SYSDATE, SYSDATE, SYSDATE, 
                v_n3pty_inv_no, in_user_id, SYSDATE, in_user_id, SYSDATE, TO_NUMBER(in_ida_tax_seq)
                ,'N'
            ); 
  DBMS_OUTPUT.PUT_LINE('g4-5 ');           
            
            UPDATE tpb_inv_rvis
            SET (co_nm, ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, inv_rmk1, inv_rmk2 ) 
                = ( SELECT co_nm, ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, inv_rmk1, inv_rmk2 
                    FROM tpb_inv_sh_set       
                    WHERE inv_iss_ofc_cd = in_user_ofc_cd AND ROWNUM = 1
                  ) 
            WHERE n3pty_inv_no = v_n3pty_inv_no AND n3pty_inv_rvis_seq = v_n3pty_inv_rvis_seq 
            ; 
            
--            TPB_INV_CRE_PKG.UPD_OTS_GRP_INFO(
--                in_n3pty_no, out_n3pty_inv_no, in_user_ofc_cd, in_user_id ,in_curr_cd , in_sum_inv_amt);

DBMS_OUTPUT.PUT_LINE('g4-6 '); 

            --- ====== UPDATE TPB OUTSTANDING GROUP ===========
            UPDATE TPB_OTS_GRP B 
            SET n3pty_inv_no = v_n3pty_inv_no, 
                inv_amt = TPB_GET_INV_CURR_CHG_FNC(in_cfm_curr_cd, B.curr_cd, TO_NUMBER(in_inv_amt)+TO_NUMBER(in_tax), SYSDATE), 
                upd_usr_id = in_user_id, 
                upd_dt = SYSDATE
            WHERE n3pty_no = v_n3pty_no
            ; 
DBMS_OUTPUT.PUT_LINE('g4-7 '); 
            --- ====== ADD OUTSTANDING GROUP STATUS ===========
            TPB_ADD_OTS_GRP_STS_PRC(v_n3pty_no, 'I', in_user_id); 
DBMS_OUTPUT.PUT_LINE('g4-8 '); 
            --- ====== ADD OUTSTANDING GROUP RECOVERY ACTIVITY ===========
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'','Invoice created.','A','',in_user_ofc_cd,in_user_id);
DBMS_OUTPUT.PUT_LINE('g4-9 '); 


            


        END IF; -------------------------------------------                                
                                
                                
    ----------------------------------
--    COMMIT;
DBMS_OUTPUT.PUT_LINE('S3');    


    ---------------------------------- 
    --4. create tpb invoice detail
    ---------------------------------- 
                 insert into TPB_INV_RVIS_DTL(      
                                    n3pty_inv_no, 
                                    n3pty_inv_rvis_seq, 
                                    n3pty_inv_rvis_dtl_seq, 
                                    n3pty_no, 
                                    ots_dtl_seq, 
                                    n3pty_delt_tp_cd, 
                                    n3pty_bil_tp_cd, 
                                    ots_amt, 
                                    inv_dtl_amt, 
                                    acct_cd, 
                                    cre_usr_id, 
                                    cre_dt, 
                                    upd_usr_id, 
                                    upd_dt, 
                                    vat_dtl_amt,
                                    acct_nm,
                                    vsl_cd, skd_voy_no, skd_dir_cd, finc_dir_cd,
                                    gl_dt
                  ) VALUES (
                                    v_n3pty_inv_no, 
                                    v_n3pty_inv_rvis_seq, 
                                    1,
                                    v_n3pty_no,
                                    v_ots_dtl_seq,
                                    'N', 
                                    in_bil_tp_cd,
                                    in_inv_amt,
                                    in_inv_amt,
                                    v_acct_cd, 
                                    in_user_id, 
                                    SYSDATE, 
                                    in_user_id, 
                                    SYSDATE, 
                                    v_dtl_vat,
                                    (SELECT  ACCT_ENG_NM VAL
                                       FROM    MDM_ACCOUNT
                                       WHERE   ACCT_CD = v_acct_cd
                                    )
                                    ,'CNTC'
                                    --,TO_CHAR(SYSDATE,'YYMM')
                                    ,SUBSTR(in_cost_prd_fm_dt,3,4)
                                    ,'M'
                                    ,'MM'
                                    ,v_gl_dt
                                                      
                  );
 DBMS_OUTPUT.PUT_LINE('S4-0');
 
            --- ====== UPDATE TPB OUTSTANDING GROUP ===========
            UPDATE TPB_OTS_DTL A 
            SET inv_amt = TPB_GET_INV_CURR_CHG_FNC(in_cfm_curr_cd, A.cfm_curr_cd, TO_NUMBER(in_ttl_amt), SYSDATE), 
                upd_usr_id = in_user_id, 
                upd_dt = SYSDATE
            WHERE ots_dtl_seq = v_ots_dtl_seq 
                AND n3pty_no = v_n3pty_no
            ; 
 DBMS_OUTPUT.PUT_LINE('S4-1');
            --- ====== ADD OUTSTANDING GROUP STATUS ===========
            TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'I', in_user_id); 

            --- ====== ADD OUTSTANDING GROUP RECOVERY ACTIVITY ===========
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Invoice created.','A','',in_user_ofc_cd,in_user_id);   
    ----------------------------------
--    COMMIT;    
DBMS_OUTPUT.PUT_LINE('S4');    



--EXCEPTION
--    WHEN OTHERS THEN
--             DBMS_OUTPUT.PUT_LINE('%%TPB_CRE_IF_DATA_REV_FNC%% <OTHERS> ERROR MSG = ['||SQLERRM||']');
--             ROLLBACK;
       
     out_tpb_no := v_n3pty_no; 
     out_inv_no := v_n3pty_inv_no; 
    
     DBMS_OUTPUT.PUT_LINE('out_tpb_no: '||out_tpb_no);   
     DBMS_OUTPUT.PUT_LINE('out_inv_no: '||out_inv_no);      
     
     EXCEPTION

              WHEN NO_DATA_FOUND THEN
              v_message := '11';
              DBMS_OUTPUT.PUT_LINE(' NO_DATA_FOUND EXCEPTION- '|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd);
--              ROLLBACK;

              WHEN OTHERS THEN
              v_message := '19';
              DBMS_OUTPUT.PUT_LINE('WHEN OTHERS EXCEPTION-'|| v_message||'-'||TO_CHAR(SQLCODE)||SQLERRM||v_err_cd);
--              ROLLBACK;

END TPB_CRE_DATA_MULTIREV_PRC

-- ===== End of Procedure ==================================
;