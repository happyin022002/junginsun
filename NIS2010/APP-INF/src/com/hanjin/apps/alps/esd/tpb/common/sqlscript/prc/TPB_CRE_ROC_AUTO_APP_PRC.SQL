CREATE OR REPLACE PROCEDURE NISADM.TPB_CRE_ROC_AUTO_APP_PRC

/*******************************************************************************
1. Object Name      : TPB_CRE_ROC_AUTO_APP_PRC
2. Version          : 1.4
3. Create Date      : 2008.06.30
4. Sub System       : Third Party Billing
5. Author           : Sun, Choi
6. Description      : 3rd Party Adjustment ROC Auto-Approval
                      -------------------------------------------------------
                      DECLARE 
                      BEGIN 
                        TPB_CRE_ROC_AUTO_APP_PRC() ;
                        DBMS_OUTPUT.PUT_LINE('');
                      END;
                      -------------------------------------------------------
7. Revision History : 2008.06.30  Kim Jin-seung   1.0  최초 생성
                      2008.07.03  Kim Jin-seung   1.1  ROC Approval Step 건은 대상에서 제외
                      2008.12.24  Kim Jin-seung   1.2  신규 테이블로 대상 변경
                      2009.09.14  Sun CHOI        1.3  ALPS Migration
                      2010.12.27  Jong-Geon Byeon 1.4  [CHM-201007764-01] [TPB] 점소간 ROC Auto-approval 기한 설정 변경
*******************************************************************************/

-- ===== Arguments ========================================
(    
    v_user_ofc_cd           IN VARCHAR2, -- user office code  
    v_user_id               IN VARCHAR2  -- user id 
) 
authid CURRENT_USER
IS 

-- ===== DECLARE ==========================================

    v_n3pty_no              TPB_OTS_GRP.n3pty_no%TYPE;  -- 3rd Party No. 
    v_stl_rmk               VARCHAR2(100) := 'ROC approved automatically By System batch processing';  -- Remarks 

    -------------------
    v_stl_tp_cd             TPB_ADJ_STS.n3pty_stl_tp_cd%TYPE;       -- settlement type code
    v_new_n3pty_no          TPB_OTS_GRP.n3pty_no%TYPE;              -- new 3rd Party No. (Case R.O.C Approval)
    v_current_if_ofc_cd     TPB_OTS_GRP.ofc_cd%TYPE;                -- current if_ofc_cd (Case R.O.C Approval)
    v_new_if_ofc_cd         TPB_ADJ_STS.stl_to_clt_cng_ofc_cd%TYPE; -- new if_ofc_cd (Case R.O.C Approval)
    n_ots_amt_origin        TPB_OTS_GRP.ots_amt%TYPE;               -- ots_amt original 
    n_ots_amt_gap           TPB_OTS_GRP.ots_amt%TYPE;               -- ots_amt - stl_clt_ofc_cng_amt value
    v_before_ots_sts_cd     TPB_OTS_GRP_STS.ots_sts_cd%TYPE;        -- before R.O.C .. last Outstanding Status Code

    v_act_rmk               TPB_OTS_GRP_RCVR_ACT.ACT_RMK%TYPE;
    v_ots_sts_cd            TPB_OTS_GRP_STS.OTS_STS_CD%TYPE;

    -------------------
    CURSOR CUR_DATA 
    IS 
        SELECT A.n3pty_no, C.n3pty_stl_tp_cd, A.ofc_cd, C.stl_to_clt_cng_ofc_cd, A.ots_amt, 
            -- A.ots_amt - tpb_get_loc_amt_fnc(NVL(n_req_amt,0.0), A.curr_cd, A.cfm_dt) AS ots_amt_gap, -- roc_amt In USD 
               A.ots_amt - NVL(c.stl_clt_ofc_cng_amt,0.0) AS ots_amt_gap, -- roc_amt In Local
               ( SELECT ots_sts_cd 
                   FROM tpb_ots_grp_sts S 
                  WHERE S.n3pty_no = A.n3pty_no 
                    AND S.ots_sts_seq = NVL(
                        ( SELECT MAX(ots_sts_seq) 
                            FROM tpb_ots_grp_sts T 
                           WHERE T.n3pty_no = s.n3pty_no 
                             AND T.ots_sts_cd != 'R' 
                         ), 0)
                    AND ROWNUM=1 
                ) AS ots_sts_cd -- Getting Final Status Before Requesting
          FROM TPB_OTS_GRP_STS B, 
               TPB_ADJ_STS C, 
               TPB_OTS_GRP A 
         WHERE A.n3pty_no = B.n3pty_no 
           AND A.n3pty_no = C.n3pty_no 
           AND A.n3pty_delt_tp_cd = 'N'
           AND B.ots_sts_lst_flg = 'Y' 
           AND B.ots_sts_cd = 'R'       -- Adjustment Requested
           AND C.stl_sts_lst_flg = 'Y' 
           AND C.n3pty_stl_tp_cd = 'O'  -- ROC type
           AND C.stl_fwrd_ofc_cd IS NULL -- 승인 단계를 거치지 않은 경우 -- In 2008-07-03
           AND C.stl_rqst_dt < SYSDATE - DECODE((CASE WHEN ROUND(SYSDATE-TO_DATE('20110101','YYYYMMDD'))>0 THEN 1 ELSE -1 END),1,20,30)    --[CHM-201007764-01] [TPB] 점소간 ROC Auto-approval 기한 설정 변경
--           AND C.stl_rqst_dt < SYSDATE - DECODE((CASE WHEN ROUND(SYSDATE-TO_DATE('20101228'))>0 THEN 1 ELSE -1 END),1,20,30)    --[CHM-201007764-01] [TPB] 점소간 ROC Auto-approval 기한 설정 변경
--           AND C.stl_rqst_dt < SYSDATE - DECODE(SIGN(SYSDATE - TO_DATE('20110101')),1,20,30)    --[CHM-201007764-01] [TPB] 점소간 ROC Auto-approval 기한 설정 변경
;

-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles 
    v_stl_tp_cd         := NULL; 
    v_new_n3pty_no      := NULL; 
    v_new_if_ofc_cd     := NULL;
    n_ots_amt_gap       := NULL; 
    v_before_ots_sts_cd := NULL; 
    

    ----- cursor fetch -----
    FOR CUR_DATA_REC IN CUR_DATA LOOP 
    
        --- getting record data
        v_n3pty_no          := CUR_DATA_REC.n3pty_no; 
        v_stl_tp_cd         := CUR_DATA_REC.n3pty_stl_tp_cd;
        v_current_if_ofc_cd := CUR_DATA_REC.ofc_cd;
        v_new_if_ofc_cd     := CUR_DATA_REC.stl_to_clt_cng_ofc_cd;
        n_ots_amt_origin    := CUR_DATA_REC.ots_amt;
        n_ots_amt_gap       := CUR_DATA_REC.ots_amt_gap;
        v_before_ots_sts_cd := CUR_DATA_REC.ots_sts_cd;
        

        ----- Update Outstanding Detail ----- 
        UPDATE TPB_OTS_DTL A
           SET ofc_cd = v_new_if_ofc_cd, 
               cfm_curr_cd = NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'),
               cfm_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt),
               ots_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt),
               bal_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt),
               rev_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt)
                       - TPB_GET_INV_CURR_CHG_ROC_FNC(A.if_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.if_amt, A.cfm_dt),
               adj_amt = NULL,
               upd_usr_id = v_user_id, 
               upd_dt = SYSDATE 
         WHERE n3pty_no = v_n3pty_no  
           --- Not a auto-deleted thing(s) 
           AND A.n3pty_delt_tp_cd = 'N' 
        ;
                    
        ------ Update Outstanding Group ------ 
        UPDATE TPB_OTS_GRP A 
           SET ofc_cd = v_new_if_ofc_cd, 
               curr_cd = NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), 
               ots_amt = ( SELECT SUM(ots_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = A.n3pty_no AND n3pty_delt_tp_cd = 'N' ), 
               bal_amt = ( SELECT SUM(bal_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = A.n3pty_no AND n3pty_delt_tp_cd = 'N' ), 
               rev_amt = ( SELECT SUM(rev_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = A.n3pty_no AND n3pty_delt_tp_cd = 'N' ), 
               adj_amt = ( SELECT SUM(adj_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = A.n3pty_no AND n3pty_delt_tp_cd = 'N' ), 
               upd_usr_id = v_user_id, 
               upd_dt = SYSDATE 
         WHERE n3pty_no = v_n3pty_no  
           --- Not a auto-deleted thing(s) 
           AND A.n3pty_delt_tp_cd = 'N' 
        ;
        
        ------ Update  Current Outstanding Adjustment ------
        UPDATE TPB_ADJ_STS C  
           SET stl_apro_ofc_cd = v_user_ofc_cd, 
               stl_apro_dt = SYSDATE, 
               stl_apro_usr_id = v_user_id, 
               stl_apro_rmk = v_stl_rmk, 
               upd_usr_id = v_user_id, 
               upd_dt = SYSDATE 
         WHERE n3pty_no = v_n3pty_no  
           --- Active  Adjustment + Only R.O.C 
           AND stl_sts_lst_flg = 'Y' 
           AND n3pty_stl_tp_cd = 'O' 
           AND ROWNUM = 1 
        ;
        
                    
        --- ====== ADD OUTSTANDING GROUP STATUS -- T ===========
        v_ots_sts_cd := 'T'; 
        TPB_ADD_OTS_GRP_STS_PRC(v_n3pty_no, v_ots_sts_cd, v_user_id); -- ADJUSTMENT APPROVAL
            
        --- ====== ADD OUTSTANDING DETAIL STATUS -- T ===========
        ----- DETAIL -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'R', v_user_id);  
        ---  1) INSERT TPB_OTS_DTL_STS
        INSERT INTO TPB_OTS_DTL_STS (
            ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt, 
            cre_usr_id, cre_dt, upd_usr_id, upd_dt
        ) 
        SELECT 
            ots_dtl_seq, ots_dtl_sts_seq + 1, v_ots_sts_cd, '+', SYSDATE, 
            v_user_id, SYSDATE, v_user_id, SYSDATE 
          FROM TPB_OTS_DTL_STS 
         WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = v_n3pty_no ) 
           AND ots_sts_lst_flg = 'Y'
        ;
        ---  2) INSERT TPB_OTS_DTL_STS
        UPDATE TPB_OTS_DTL_STS 
           SET ots_sts_lst_flg = DECODE(ots_sts_lst_flg,'Y','N','+','Y',ots_sts_lst_flg), 
               upd_usr_id = v_user_id, 
               upd_dt = SYSDATE
         WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = v_n3pty_no ) 
        ;
        
                    
        --- ====== ADD Recovery Activity -- T ===========
        v_act_rmk := 'ROC approved by '||v_user_ofc_cd||'.'; 
        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'',v_act_rmk,'A','',v_user_ofc_cd,v_user_id);
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',v_n3pty_no,'',v_act_rmk,'A','',v_user_ofc_cd,v_user_id);

        --- ====== ADD OUTSTANDING GROUP STATUS -- O ===========
        v_ots_sts_cd := 'O'; 
        TPB_ADD_OTS_GRP_STS_PRC(v_n3pty_no, v_ots_sts_cd, v_user_id); -- ADJUSTMENT APPROVAL


        --- ====== ADD OUTSTANDING DETAIL STATUS -- O ===========
        ----- DETAIL -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'R', v_user_id);  
        ---  1) INSERT TPB_OTS_DTL_STS
        INSERT INTO TPB_OTS_DTL_STS (
            ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt, 
            cre_usr_id, cre_dt, upd_usr_id, upd_dt
        ) 
        SELECT 
            ots_dtl_seq, ots_dtl_sts_seq + 1, v_ots_sts_cd, '+', SYSDATE, 
            v_user_id, SYSDATE, v_user_id, SYSDATE 
          FROM TPB_OTS_DTL_STS 
         WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = v_n3pty_no ) 
           AND ots_sts_lst_flg = 'Y'
        ;
        ---  2) INSERT TPB_OTS_DTL_STS
        UPDATE TPB_OTS_DTL_STS 
           SET ots_sts_lst_flg = DECODE(ots_sts_lst_flg,'Y','N','+','Y',ots_sts_lst_flg), 
               upd_usr_id = v_user_id, 
               upd_dt = SYSDATE
         WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = v_n3pty_no ) 
        ;
        
        
        --- ====== ADD Recovery Activity -- T ===========
        v_act_rmk := 'Responsible Office was changed to '||v_new_if_ofc_cd||'.'; 
        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'',v_act_rmk,'A','',v_user_ofc_cd,v_user_id);
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',v_n3pty_no,'',v_act_rmk,'A','',v_user_ofc_cd,v_user_id);


--------------------------------------

    END LOOP;


--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     
END
-- ===== End of Procedure ==================================
;