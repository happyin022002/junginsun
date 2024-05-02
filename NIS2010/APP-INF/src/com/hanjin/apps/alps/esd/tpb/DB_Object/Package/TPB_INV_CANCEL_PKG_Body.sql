CREATE OR REPLACE PACKAGE BODY NISADM.TPB_INV_CANCEL_PKG 
 
IS 
/******************************************************************************* 
   1. Object Name      : TPB_INV_CANCEL_PKGBODY 
   2. Version          : 1.6 
   3. Create Date      : 2008.12.05 
   4. Sub System       : TPB 
   5. Author           : Sun, Choi 
   6. Description      : TPB Invoice Cancel Package Body 
                         ------------------------------------------------------ 
                         DECLARE  
 
                         BEGIN  
                            TPB_INV_CANCEL_PKG...1. (,,,,) ; 
                            TPB_INV_CANCEL_PKG...2. (,,,,) ; 
                            TPB_INV_CANCEL_PKG...3. (,,,,) ; 
                         END;  
                         ------------------------------------------------------ 
   7. Revision History : 2008.10.06  Kim Jin-seung      1.0  Created 
                         2008.11.21  Kim Jin-seung      1.1  credit note check 보완 
                         2008.12.05  Kim Jin-seung      1.2  Add PRC UPD_OTS_GRP_RMK_INFO, UPD_OTS_DTL_RMK_INFO 
                         2009.10.26  Park Sung-Jin      1.3  ALPS Migration 
                         2010.01.08  Sun, CHOI          1.4  EQ_TP_CD -> EQ_KND_CD 전환 
                         2010.04.23  Sun, CHOI          1.5  Cancel 처리시, ida_tax_seq 처리 추가 
                         2010.07.01  Jong-Geon Byeon    1.6  TPB_INV_RVIS_DTl.VAT_DTL_AMT 추가 
                         2012.12.31  Jeong-Seon An           CHM-201220985 PSO에 대한 3자구상 개발관련 
                         2015.11-12  Kim Hyun-Hwa       India SBC 금액정보 추가 
                         2016.05-19  Kim Hyun-Hwa       India KKC 금액정보 추가 2016.06.01 적용 
                         2016.05-26  KIm Hyun-hwa       Microsoft  EDI 전송용 Load Id 추가(5/31적용) 
*******************************************************************************/ 
 
 
/*############################################################################################### 
 *# UPD_INV_RVIS : UPDATE TPB INVOICE MAIN, REVISION DATA  
 *###############################################################################################*/ 
 
PROCEDURE UPD_INV_RVIS 
 
-- ===== Arguments ======================================== 
(     
    in_user_ofc_cd           IN VARCHAR2, 
    in_user_id          IN VARCHAR2, 
     
    in_n3pty_no        IN VARCHAR2, 
    in_n3pty_inv_no    IN VARCHAR2, 
    in_n3pty_inv_rvis_seq IN VARCHAR2,  
    in_remark           IN VARCHAR2, 
 
    out_n3pty_inv_no    OUT VARCHAR2, -------- 
    out_new_creditnote_seq OUT VARCHAR2, -------- credit note  
    out_new_creditnote_cd OUT VARCHAR2 -------- credit note  
)  
 
IS  
 
-- ===== DECLARE ========================================== 
--    v_n3pty_inv_no tpb_invoice.n3pty_inv_no%TYPE; -- temp TPB Inv No. 
 
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
        END AS new_creditnote_cd--,  
--        DECODE( SUBSTRB(r.n3pty_inv_rvis_cd,1,1), 'C', r.n3pty_inv_rvis_seq+1, r.n3pty_inv_rvis_seq+2 ) AS new_rvis_seq,  
--        CASE  
--            WHEN v.n3pty_delt_tp_cd != 'N'  
--                THEN NULL  
--            WHEN r.n3pty_inv_rvis_cd = 'ORG' OR r.n3pty_inv_rvis_cd IS NULL  
--                THEN 'R01'  
--            WHEN SUBSTRB(n3pty_inv_rvis_cd,1,1) = 'R' AND TO_NUMBER(SUBSTRB(n3pty_inv_rvis_cd,2,2))+1 < 100  
--                THEN 'R'|| TRIM(LPAD(TO_CHAR(TO_NUMBER(SUBSTRB(n3pty_inv_rvis_cd,2,2))+1), 2, '0'))  
--            WHEN SUBSTRB(n3pty_inv_rvis_cd,1,1) = 'R' AND TO_NUMBER(SUBSTRB(n3pty_inv_rvis_cd,2,2))+1 >= 100  
--                THEN NULL  
--            WHEN SUBSTRB(n3pty_inv_rvis_cd,1,1) != 'R'  
--                THEN 'R01'  
--        END AS new_rvis_cd  
    INTO v_now_rvis_seq, v_now_rvis_cd,  
         out_new_creditnote_seq, out_new_creditnote_cd--,  
--         out_new_rvis_seq, out_new_rvis_cd  
    FROM tpb_inv_rvis r, tpb_invoice v  
    WHERE 1=1  
        AND r.n3pty_inv_no = v.n3pty_inv_no 
        AND r.n3pty_inv_rvis_seq = v.lst_n3pty_inv_rvis_seq  
        AND v.n3pty_inv_no = in_n3pty_inv_no  
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
                n3pty_inv_no, n3pty_inv_rvis_seq, ida_tax_seq, n3pty_inv_rvis_cd, n3pty_delt_tp_cd, co_nm,  
                ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, vndr_cust_div_cd,  
                vndr_cnt_cd, vndr_seq, cust_cnt_cd, cust_seq, vndr_cust_nm,  
                vndr_cust_addr, vndr_cust_eml, cty_nm, ste_cd, zip_cd,  
                fax_no, phn_no, vndr_cust_ref_rmk, usr_inp_ctnt1, usr_inp_ctnt2,  
                rcv_due_dt, rgst_no, inv_desc, inv_rmk1, inv_rmk2,  
                n3pty_inv_if_tp_cd, n3pty_inv_upd_flg, n3pty_inv_sts_cd, clt_agn_flg, clt_agn_rmk,  
                clt_agn_dt, ar_if_dt, curr_cd, mon_xch_rt, net_amt,  
                vat_amt, add_amt, ddct_amt, inv_amt, clt_amt, locl_tax_amt, n2nd_locl_tax_amt, 
                clt_dt, inv_iss_locl_dt, inv_iss_gdt, inv_upd_locl_dt, inv_upd_gdt,  
                fax_eml_snd_no, if_bl_no, cre_usr_id, cre_dt, upd_usr_id,  
                upd_dt            
            )  
            SELECT  
                n3pty_inv_no, out_new_creditnote_seq, ida_tax_seq, out_new_creditnote_cd, 'D' AS n3pty_delt_tp_cd, co_nm,  
                ofc_addr, ofc_phn_no, ofc_fax_no, bil_to_loc_div_cd, vndr_cust_div_cd,  
                vndr_cnt_cd, vndr_seq, cust_cnt_cd, cust_seq, vndr_cust_nm,  
                vndr_cust_addr, vndr_cust_eml, cty_nm, ste_cd, zip_cd,  
                fax_no, phn_no, vndr_cust_ref_rmk, usr_inp_ctnt1, usr_inp_ctnt2,  
                rcv_due_dt, rgst_no, inv_desc, inv_rmk1, inv_rmk2,  
                NULL n3pty_inv_if_tp_cd, n3pty_inv_upd_flg, n3pty_inv_sts_cd, clt_agn_flg, clt_agn_rmk, -- n3pty_inv_sts_cd는 최종상태 대로 처리; 즉 ERP I/F 되었으면 ERP I/F처리하고 안되었으면 안되게 처리 
                NULL clt_agn_dt, NVL2(ar_if_dt,SYSDATE,NULL), curr_cd, mon_xch_rt, (-1)*net_amt,  
                (-1)*vat_amt, (-1)*add_amt, (-1)*ddct_amt, (-1)*inv_amt, (-1)*clt_amt,  (-1)*nvl(locl_tax_amt,0), (-1)*nvl(n2nd_locl_tax_amt,0), 
                NVL2(clt_dt,SYSDATE,NULL), SYSDATE inv_iss_locl_dt, SYSDATE inv_iss_gdt, SYSDATE inv_upd_locl_dt, SYSDATE inv_upd_gdt,  
                fax_eml_snd_no, if_bl_no, upd_usr_id, SYSDATE cre_dt, upd_usr_id,  
                SYSDATE upd_dt                 
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
    --[CHM-201220985] START----------------------------------------------------- 
                ,act_atd_inp_dt 
                ,tml_nm 
                ,acct_nm 
    --[CHM-201220985]   END-----------------------------------------------------  
                ,lod_id       
                ,add_amt 
            )  
            SELECT  
                n3pty_inv_no, out_new_creditnote_seq,  
                n3pty_inv_rvis_dtl_seq,  
                n3pty_no, ots_dtl_seq,  
                'D' n3pty_delt_tp_cd, n3pty_bil_tp_cd, eq_knd_cd, eq_no, eq_tpsz_cd,  
                bkg_no, bl_no, 
                vsl_cd, skd_voy_no, skd_dir_cd, finc_dir_cd, yd_cd,  
                fm_nod_cd, via_nod_cd, to_nod_cd, dor_nod_cd, new_eq_no,  
                new_cntr_seal_no, lst_free_dt, ots_amt, corr_ots_amt, (-1)*rev_amt,  
                (-1)*inv_dtl_amt, pkup_dt, ft_ovr_dys, cita_no, cntr_wgt,  
                n3pty_cntr_wgt_ut_cd, wt_hrs, occr_dt, new_vsl_cd, new_skd_voy_no,  
                new_skd_dir_cd, new_bkg_no, acct_cd, lgs_cost_cd, so_no,  
                csr_no, gl_dt, vvd_cd, estm_sys_area_grp_id, in_user_id,  
                SYSDATE, in_user_id, SYSDATE, (-1)*vat_dtl_amt 
    --[CHM-201220985] START----------------------------------------------------- 
                ,act_atd_inp_dt 
                ,tml_nm 
                ,acct_nm 
    --[CHM-201220985]   END-----------------------------------------------------  
                ,lod_id   
                ,(-1)*add_amt                    
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
            lst_n3pty_inv_rvis_seq = TO_NUMBER(out_new_creditnote_seq),  
            n3pty_delt_tp_cd = 'D', ---  
            upd_usr_id = in_user_id,  
            upd_dt = SYSDATE  
        WHERE n3pty_inv_no = in_n3pty_inv_no  
        ;   
         
         
     
    TPB_INV_CANCEL_PKG.UPD_OTS_GRP_RMK_INFO( 
        in_n3pty_no, in_n3pty_inv_no, out_new_creditnote_seq, 
        out_new_creditnote_cd, in_user_ofc_cd, in_user_id, in_remark); 
    TPB_INV_CANCEL_PKG.UPD_OTS_DTL_RMK_INFO( 
        in_n3pty_no, in_n3pty_inv_no, out_new_creditnote_seq, 
        out_new_creditnote_cd, in_user_ofc_cd, in_user_id, in_remark); 
 
    END IF; ------------------------------------------- 
 
 
 
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
 
    in_new_creditnote_seq IN VARCHAR2, -------- credit note  
    in_new_creditnote_cd IN VARCHAR2, -------- credit note  
 
    in_user_ofc_cd      IN VARCHAR2, 
    in_user_id          IN VARCHAR2 
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
    SET n3pty_inv_no = NULL, ---  
        inv_amt = 0,  
        clt_amt = 0,  
        bal_amt = (ots_amt - NVL(adj_amt,0)), 
        upd_usr_id = in_user_id,  
        upd_dt = SYSDATE 
    WHERE 1=1 
        AND n3pty_no = in_n3pty_no  
        AND n3pty_inv_no = in_n3pty_inv_no  
        AND n3pty_delt_tp_cd = 'N'  
    ;  
 
    --- ====== ADD OUTSTANDING GROUP STATUS =========== 
    TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, 'O', in_user_id);  
  
    --- ====== ADD OUTSTANDING GROUP RECOVERY ACTIVITY =========== 
    --- FOR CREDIT NOTE 
    IF TO_NUMBER(in_new_creditnote_seq) > 0 THEN  
        v_act_rmk := 'The Credit Note version ['||in_new_creditnote_cd||'] was revised.';  
        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);     
    END IF;  
 
    --- FOR CANCEL 
    v_act_rmk := 'Invoice '||'['||in_n3pty_inv_no||'] was cancelled.';  
    TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
 
 
--EXCEPTION 
--    WHEN OTHERS THEN 
--        v_lst_no := NULL; 
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  
      
 
END 
-- ===== End of Procedure ================================== 
; 
 
 
/*############################################################################################### 
 *# UPD_OTS_GRP_INFO : UPDATE Outstanding Group Data with Remark 
 *###############################################################################################*/ 
 
PROCEDURE UPD_OTS_GRP_RMK_INFO 
 
-- ===== Arguments ======================================== 
(     
    in_n3pty_no         IN VARCHAR2, 
    in_n3pty_inv_no     IN VARCHAR2, 
 
    in_new_creditnote_seq IN VARCHAR2, -------- credit note  
    in_new_creditnote_cd IN VARCHAR2, -------- credit note  
 
    in_user_ofc_cd      IN VARCHAR2, 
    in_user_id          IN VARCHAR2,  
         
    in_remark           IN VARCHAR2 --- USER REMARK 
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
    SET n3pty_inv_no = NULL, ---  
        inv_amt = 0,  
        clt_amt = 0,  
        bal_amt = (ots_amt - NVL(adj_amt,0)), 
        upd_usr_id = in_user_id,  
        upd_dt = SYSDATE 
    WHERE 1=1 
        AND n3pty_no = in_n3pty_no  
        AND n3pty_inv_no = in_n3pty_inv_no  
        AND n3pty_delt_tp_cd = 'N'  
    ;  
 
    --- ====== ADD OUTSTANDING GROUP STATUS =========== 
    TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, 'O', in_user_id);  
  
    --- ====== ADD OUTSTANDING GROUP RECOVERY ACTIVITY =========== 
    --- FOR CREDIT NOTE 
    IF TO_NUMBER(in_new_creditnote_seq) > 0 THEN  
        v_act_rmk := 'The Credit Note version ['||in_new_creditnote_cd||'] was revised.';  
        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);     
    END IF;  
 
    --- FOR CANCEL 
    v_act_rmk := 'Invoice '||'['||in_n3pty_inv_no||'] was cancelled. (Reason) ' || in_remark;  
    TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
 
 
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
    in_n3pty_inv_no     IN VARCHAR2, 
 
    in_new_creditnote_seq IN VARCHAR2, -------- credit note  
    in_new_creditnote_cd IN VARCHAR2, -------- credit note  
 
    in_user_ofc_cd      IN VARCHAR2, 
    in_user_id          IN VARCHAR2 
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
    SET inv_amt = 0,  
        clt_amt = 0, 
        bal_amt = (ots_amt - NVL(adj_amt,0)), 
        upd_usr_id = in_user_id,  
        upd_dt = SYSDATE 
    WHERE 1=1  
        AND n3pty_no = in_n3pty_no 
    ;  
 
 
    --- ====== ADD OUTSTANDING DETAIL STATUS =========== 
    -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'Y', in_user_id);   
    ---  1) INSERT TPB_OTS_DTL_STS 
    INSERT INTO TPB_OTS_DTL_STS ( 
        ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt,  
        cre_usr_id, cre_dt, upd_usr_id, upd_dt 
    )  
    SELECT  
        ots_dtl_seq,  
        ots_dtl_sts_seq + 1, 
        'O', '+', SYSDATE,  
        in_user_id, SYSDATE, in_user_id, SYSDATE  
    FROM TPB_OTS_DTL_STS  
    WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no )  
        AND ots_sts_lst_flg = 'Y' 
    ; 
    ---  2) INSERT TPB_OTS_DTL_STS 
    UPDATE TPB_OTS_DTL_STS  
    SET ots_sts_lst_flg = DECODE(ots_sts_lst_flg,'Y','N','+','Y',ots_sts_lst_flg),  
        upd_usr_id = in_user_id,  
        upd_dt = SYSDATE 
    WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no )  
        AND ots_sts_lst_flg IN ('Y','+') 
    ;    
         
 
    --- ====== ADD OUTSTANDING DETAIL RECOVERY ACTIVITY =========== 
    --- FOR CREDIT NOTE 
    IF TO_NUMBER(in_new_creditnote_seq) > 0 THEN  
        v_act_rmk := 'The Credit Note version ['||in_new_creditnote_cd||'] was revised.';  
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
    END IF;  
 
    --- FOR REVISION  
    v_act_rmk := 'Invoice '||'['||in_n3pty_inv_no||'] was cancelled.';  
    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
 
 
--EXCEPTION 
--    WHEN OTHERS THEN 
--        v_lst_no := NULL; 
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  
      
 
END 
-- ===== End of Procedure ================================== 
; 
 
 
/*############################################################################################### 
 *# UPD_OTS_DTL_RMK_INFO : UPDATE Outstanding Detail Data with Remark 
 *###############################################################################################*/ 
 
PROCEDURE UPD_OTS_DTL_RMK_INFO 
 
-- ===== Arguments ======================================== 
(     
    in_n3pty_no         IN VARCHAR2, 
    in_n3pty_inv_no     IN VARCHAR2, 
 
    in_new_creditnote_seq IN VARCHAR2, -------- credit note  
    in_new_creditnote_cd IN VARCHAR2, -------- credit note  
 
    in_user_ofc_cd      IN VARCHAR2, 
    in_user_id          IN VARCHAR2,  
         
    in_remark           IN VARCHAR2   ----- USER REMARK 
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
    SET inv_amt = 0,  
        clt_amt = 0, 
        bal_amt = (ots_amt - NVL(adj_amt,0)), 
        upd_usr_id = in_user_id,  
        upd_dt = SYSDATE 
    WHERE 1=1  
        AND n3pty_no = in_n3pty_no 
    ;  
 
 
    --- ====== ADD OUTSTANDING DETAIL STATUS =========== 
    -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'Y', in_user_id);   
    ---  1) INSERT TPB_OTS_DTL_STS 
    INSERT INTO TPB_OTS_DTL_STS ( 
        ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt,  
        cre_usr_id, cre_dt, upd_usr_id, upd_dt 
    )  
    SELECT  
        ots_dtl_seq,  
        ots_dtl_sts_seq + 1, 
        'O', '+', SYSDATE,  
        in_user_id, SYSDATE, in_user_id, SYSDATE  
    FROM TPB_OTS_DTL_STS  
    WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no )  
        AND ots_sts_lst_flg = 'Y' 
    ; 
    ---  2) INSERT TPB_OTS_DTL_STS 
    UPDATE TPB_OTS_DTL_STS  
    SET ots_sts_lst_flg = DECODE(ots_sts_lst_flg,'Y','N','+','Y',ots_sts_lst_flg),  
        upd_usr_id = in_user_id,  
        upd_dt = SYSDATE 
    WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no )  
        AND ots_sts_lst_flg IN ('Y','+') 
    ;    
         
 
    --- ====== ADD OUTSTANDING DETAIL RECOVERY ACTIVITY =========== 
    --- FOR CREDIT NOTE 
    IF TO_NUMBER(in_new_creditnote_seq) > 0 THEN  
        v_act_rmk := 'The Credit Note version ['||in_new_creditnote_cd||'] was revised.';  
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
    END IF;  
 
    --- FOR REVISION  
    v_act_rmk := 'Invoice '||'['||in_n3pty_inv_no||'] was cancelled. (Reason) ' || in_remark;  
    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
 
 
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