CREATE OR REPLACE PROCEDURE NISADM.TPB_CRE_IF_DATA_MNR_PRC

 /*******************************************************************************
   1. Object Name      : TPB_CRE_IF_DATA_MNR_PRC
   2. Version          : 1.4
   3. Create Date      : 2008.11.05
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : From MNR To TPB (Inbound) Interface
                         -------------------------------------------------------
                         DECLARE
                         BEGIN 
                             TPB_CRE_IF_DATA_MNR_PRC(.....) ;
                             -- DBMS_OUTPUT.PUT_LINE('');
                         END; 
                         -------------------------------------------------------
   7. Revision History : 2008.11.05  Kim Jin-seung   1.0  Created
                         2009.08.10  O Wan-Ki        1.1  ALPS Migration
                         2009.10.23  Sun, CHOI       1.2  in_n3pty_src_no 을 UTF8로 변환된 data로 받기로 하여, UTF8 변환 처리 제거
                         2009.12.24  Jong-Geon Byeon 1.3  기존 NIS <-> eNIS간 Equip Type Code가 동일하지 않았음(UZG-CHG)
                         2010.01.07  Jong-Geon Byeon 1.4  NIS2010 ALPS간 EQ_KND_CD 단일화 작업
 *******************************************************************************/

-- ===== Arguments ========================================
(    
    in_eq_knd_cd       in VARCHAR2, 
    in_if_ofc_cd       in VARCHAR2, 
    in_n3pty_src_no    in VARCHAR2, 
    in_src_vndr_cnt_cd in VARCHAR2, 
    in_src_vndr_seq    in VARCHAR2, 
    
    in_eq_no           in VARCHAR2, 
    in_eq_tpsz_cd      in VARCHAR2, 
    in_curr_cd         in VARCHAR2, 
    in_lgs_cost_cd     in VARCHAR2, 
    in_acct_cd         in VARCHAR2, 

    in_if_amt          in VARCHAR2, 
    in_estm_svr_id     in VARCHAR2, 
    in_estm_dtl_seq_no in VARCHAR2, 
    in_estm_rvis_no    in VARCHAR2, 
    in_estm_seq_no     in VARCHAR2, 

    in_user_ofc_cd     in VARCHAR2, -- user office code
    in_user_id         in VARCHAR2  -- user id   
) 
authid CURRENT_USER

IS 

-- ===== DECLARE ==========================================
    v_src_sys_cd    VARCHAR2(3); -- TES
    v_ots_dtl_seq   TPB_OTS_DTL.ots_dtl_seq%TYPE;
    
-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

    ----- Initiate varibles 
    v_src_sys_cd  := 'MNR';


    ---------------------------------- 
    SELECT tpb_ots_dtl_seq1.nextval 
    INTO v_ots_dtl_seq
    FROM DUAL
    ; 

    ---------------------------------- 
    INSERT INTO TPB_OTS_DTL ( 
        ots_dtl_seq, 
        n3pty_bil_tp_cd, 
        if_rhq_cd, if_ofc_cd, ofc_cd, n3pty_src_sub_sys_cd, 
        n3pty_expn_tp_cd, n3pty_src_no, src_vndr_cnt_cd, src_vndr_seq, 
        eq_no, eq_tpsz_cd, eq_knd_cd, if_curr_cd, lgs_cost_cd, acct_cd, 
        if_amt, n3pty_if_tp_cd, n3pty_cfm_cd, n3pty_delt_tp_cd, 
        if_usr_id, if_dt, estm_sys_area_grp_id, estm_dtl_seq_no, estm_rvis_no, 
        estm_seq_no, cre_usr_id, cre_dt, upd_usr_id, upd_dt 
    ) SELECT 
        v_ots_dtl_seq, 
        DECODE(in_eq_knd_cd,'U','CD','Z','ZD','G','GD','--'),
        TPB_GET_HNDL_OFC_FNC('R',TPB_GET_N3PTY_OFC_CD_FNC(in_if_ofc_cd)), in_if_ofc_cd, TPB_GET_N3PTY_OFC_CD_FNC(in_if_ofc_cd), 'MNR', 
        v_src_sys_cd, in_n3pty_src_no, in_src_vndr_cnt_cd, in_src_vndr_seq, 
        in_eq_no, in_eq_tpsz_cd, in_eq_knd_cd, in_curr_cd, in_lgs_cost_cd, in_acct_cd, 
        TO_NUMBER(in_if_amt), 'S', 'I', 'N', 
        in_user_id, SYSDATE, in_estm_svr_id, in_estm_dtl_seq_no, in_estm_rvis_no, 
        in_estm_seq_no, in_user_id, SYSDATE, in_user_id, SYSDATE 
    FROM DUAL 
    ;

     
    TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'Z', in_user_id); 
    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Interfaced from '||v_src_sys_cd||'.','A','',in_user_ofc_cd,in_user_id);

 

--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END

-- ===== End of Procedure ==================================
;