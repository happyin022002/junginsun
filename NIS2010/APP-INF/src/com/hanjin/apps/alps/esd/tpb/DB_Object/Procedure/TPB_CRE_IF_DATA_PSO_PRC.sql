CREATE OR REPLACE PROCEDURE NISADM.TPB_CRE_IF_DATA_PSO_PRC

 /*******************************************************************************
   1. Object Name      : TPB_CRE_IF_DATA_PSO_PRC
   2. Version          : 1.0
   3. Create Date      : 2012.12.31
   4. Sub System       : Third Party Billing
   5. Author           : An Jeong-Seon
   6. Description      : From PSO To TPB (Inbound) Interface
                         -------------------------------------------------------

   7. Revision History : 2012.12.31 An Jeong-Seon   1.0  Created
 *******************************************************************************/

-- ===== Arguments ========================================
(    
    i_n3pty_bil_tp_cd          in     VARCHAR2, 
    i_if_ofc_cd                in     VARCHAR2, 
    i_vvd_cd                   in     VARCHAR2,  
    i_src_vndr_cnt_cd          in     VARCHAR2, 
    i_src_vndr_seq             in     VARCHAR2, 
    i_vsl_cd                   in     VARCHAR2,  
    i_skd_voy_no               in     VARCHAR2,  
    i_skd_dir_cd               in     VARCHAR2,  
    i_yd_cd                    in     VARCHAR2,  
    i_vndr_cnt_cd              in     VARCHAR2,  
    i_vndr_seq                 in     VARCHAR2,      
    i_vndr_lgl_eng_nm          in     VARCHAR2,  
    i_if_curr_cd               in     VARCHAR2,      
    i_if_amt                   in     VARCHAR2,      
    i_if_rmk                   in     VARCHAR2,   
    i_acct_cd                  in     VARCHAR2,   
    i_lgs_cost_cd              in     VARCHAR2,       
    
    i_user_id                  in     VARCHAR2,    -- user id  
    i_cost_ofc_cd              in     VARCHAR2, 
    i_act_atd_inp_dt           in     VARCHAR2, 
    i_tml_nm                   in     VARCHAR2, 
    i_acct_nm                  in     VARCHAR2, 
    i_so_dtl_seq               in     VARCHAR2,
    i_pso_if_seq               in     VARCHAR2
    
    ,i_n3pty_src_no            in     VARCHAR2
) 
 
AUTHID CURRENT_USER

IS 

-- ===== DECLARE ==========================================
    v_src_sys_cd    VARCHAR2(3); -- TES
    v_ots_dtl_seq   TPB_OTS_DTL.ots_dtl_seq%TYPE;
-- ========================================================
    in_n3pty_bil_tp_cd          TPB_OTS_DTL.n3pty_bil_tp_cd%TYPE; 
    in_if_ofc_cd                TPB_OTS_DTL.if_ofc_cd%TYPE; 
    in_vvd_cd                   TPB_OTS_DTL.vvd_cd%TYPE;  
    in_src_vndr_cnt_cd          TPB_OTS_DTL.src_vndr_cnt_cd%TYPE; 
    in_src_vndr_seq             TPB_OTS_DTL.src_vndr_seq%TYPE; 
    in_vsl_cd                   TPB_OTS_DTL.vsl_cd%TYPE;  
    in_skd_voy_no               TPB_OTS_DTL.skd_voy_no%TYPE;  
    in_skd_dir_cd               TPB_OTS_DTL.skd_dir_cd%TYPE;  
    in_yd_cd                    TPB_OTS_DTL.yd_cd%TYPE;  
    in_vndr_cnt_cd              TPB_OTS_DTL.vndr_cnt_cd%TYPE;  
    in_vndr_seq                 TPB_OTS_DTL.vndr_seq%TYPE;      
    in_vndr_lgl_eng_nm          TPB_OTS_DTL.vndr_lgl_eng_nm%TYPE;  
    in_if_curr_cd               TPB_OTS_DTL.if_curr_cd%TYPE;      
    in_if_amt                   TPB_OTS_DTL.if_amt%TYPE;      
    in_if_rmk                   TPB_OTS_DTL.if_rmk%TYPE;   
    in_acct_cd                  TPB_OTS_DTL.acct_cd%TYPE;   
    in_lgs_cost_cd              TPB_OTS_DTL.lgs_cost_cd%TYPE;       
    
    in_user_id                  TPB_OTS_DTL.cre_usr_id%TYPE;    -- user id  
    in_cost_ofc_cd              TPB_OTS_DTL.cost_ofc_cd%TYPE; 
    in_act_atd_inp_dt           TPB_OTS_DTL.act_atd_inp_dt%TYPE; 
    in_tml_nm                   TPB_OTS_DTL.tml_nm%TYPE; 
    in_acct_nm                  TPB_OTS_DTL.acct_nm%TYPE; 
    in_so_dtl_seq               TPB_OTS_DTL.so_dtl_seq%TYPE;
    in_pso_if_seq               TPB_OTS_DTL.pso_if_seq%TYPE;     
    
    in_n3pty_src_no             TPB_OTS_DTL.n3pty_src_no%TYPE;   
    
-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

    ----- Initiate varibles 
    v_src_sys_cd  := 'PSO';
    in_n3pty_bil_tp_cd := i_n3pty_bil_tp_cd;
    in_if_ofc_cd       := i_if_ofc_cd; 
    in_vvd_cd          := i_vvd_cd;  
    in_src_vndr_cnt_cd := i_src_vndr_cnt_cd; 
    in_src_vndr_seq    := i_src_vndr_seq; 
    in_vsl_cd          := i_vsl_cd;  
    in_skd_voy_no      := i_skd_voy_no;  
    in_skd_dir_cd      := i_skd_dir_cd;  
    in_yd_cd           := i_yd_cd;  
    in_vndr_cnt_cd     := i_vndr_cnt_cd;  
    in_vndr_seq        := i_vndr_seq;      
    in_vndr_lgl_eng_nm := i_vndr_lgl_eng_nm;  
    in_if_curr_cd      := i_if_curr_cd;      
    in_if_amt          := i_if_amt;      
    in_if_rmk          := i_if_rmk;   
    in_acct_cd         := i_acct_cd;   
    in_lgs_cost_cd     := i_lgs_cost_cd;       
    
    in_user_id         := i_user_id;    -- user id  
    in_cost_ofc_cd     := i_cost_ofc_cd; 
    in_act_atd_inp_dt  := TO_DATE(i_act_atd_inp_dt,'YYYY/MM/DD HH24:MI:SS'); 
    in_tml_nm          := i_tml_nm; 
    in_acct_nm         := i_acct_nm; 
    in_so_dtl_seq      := i_so_dtl_seq;
    in_pso_if_seq      := i_pso_if_seq;
    
    in_n3pty_src_no    := i_n3pty_src_no;

    ---------------------------------- 
    SELECT tpb_ots_dtl_seq1.nextval 
    INTO v_ots_dtl_seq
    FROM DUAL
    ; 

    ---------------------------------- 
    INSERT INTO TPB_OTS_DTL ( 
        OTS_DTL_SEQ, 
        N3PTY_BIL_TP_CD,
        N3PTY_EXPN_TP_CD, 
        IF_RHQ_CD, 
        IF_OFC_CD, 
        OFC_CD, 
        N3PTY_SRC_SUB_SYS_CD, 
      --------------------- 
        N3PTY_SRC_NO, 
      --------------------- 
        VVD_CD, 
        SRC_VNDR_CNT_CD, 
        SRC_VNDR_SEQ, 
        VSL_CD,
        SKD_VOY_NO,
        SKD_DIR_CD,
        FINC_DIR_CD,
        YD_CD,
        VNDR_CNT_CD,
        VNDR_SEQ,
        VNDR_LGL_ENG_NM,
        
        IF_CURR_CD,
        IF_AMT,
        IF_RMK,
        ACCT_CD,
        N3PTY_DELT_TP_CD,
        LGS_COST_CD,
        IF_USR_ID, 
        IF_DT, 
        CRE_USR_ID, 
        CRE_DT, 
        UPD_USR_ID, 
        UPD_DT,
        COST_OFC_CD,
        CSR_NO_CXL_FLG,
        ACT_ATD_INP_DT,
        TML_NM,
        ACCT_NM
      --------------------- 
        ,SO_DTL_SEQ
        ,PSO_IF_SEQ
        ,N3PTY_CFM_CD
        ,N3PTY_IF_TP_CD
      --------------------- 
    ) SELECT 
        v_ots_dtl_seq, 
        in_n3pty_bil_tp_cd,
        v_src_sys_cd,
        TPB_GET_HNDL_OFC_FNC('R',TPB_GET_N3PTY_OFC_CD_FNC(in_if_ofc_cd)), 
        in_if_ofc_cd, 
        TPB_GET_N3PTY_OFC_CD_FNC(in_if_ofc_cd), 
        v_src_sys_cd, 
      --------------------- 
        in_n3pty_src_no, 
      ---------------------    
        in_vvd_cd,       
        in_src_vndr_cnt_cd, 
        in_src_vndr_seq, 
        in_vsl_cd,
        in_skd_voy_no,
        in_skd_dir_cd,
        (in_skd_dir_cd||in_skd_dir_cd),
        in_yd_cd,    
        in_vndr_cnt_cd,
        in_vndr_seq,    
        in_vndr_lgl_eng_nm,
        
        in_if_curr_cd,
        in_if_amt,
        in_if_rmk,
        in_acct_cd,
        'N',
        in_lgs_cost_cd, 
        in_user_id, 
        SYSDATE, 
        in_user_id, 
        SYSDATE, 
        in_user_id, 
        SYSDATE,
        in_cost_ofc_cd,
        'N',
        in_act_atd_inp_dt,
        in_tml_nm,
        in_acct_nm
      --------------------- 
        ,in_so_dtl_seq
        ,in_pso_if_seq
        ,'I'
        ,'S'
      ---------------------        
    FROM DUAL 
    ;

     
    TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'Z', in_user_id); 
    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Interfaced from '||v_src_sys_cd||'.','A','',in_if_ofc_cd,in_user_id);

 

    ---------------------------------- 
--    IF SQL%FOUND THEN
--        UPDATE TES_N3RD_PTY_IF 
--           SET TML_N3PTY_IF_STS_CD = 'P', 
--               UPD_DT = SYSDATE 
--         WHERE TML_N3PTY_IF_STS_CD = 'N' 
--           AND TML_IF_OFC_CD = in_tml_if_ofc_cd 
--           AND TML_IF_SEQ = in_tml_if_seq 
--        ;
--    END IF
--    ; 
    ----------------------------------
          

--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
END

-- ===== End of Procedure ==================================
;