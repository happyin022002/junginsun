CREATE OR REPLACE PACKAGE BODY OPUSADM.TPB_ADJ_PKG
 
IS 

/*******************************************************************************
   1. Object Name      : TPB_ADJ_PKG
   2. Version          : 1.2
   3. Create Date      : 2008-09-30
   4. Sub System       : Third Party Billing
   5. Author           : Sun, CHOI
   6. Description      : TPB Invoice Creation Package Body 
                         ------------------------------------------------------
                         DECLARE  
 
                         BEGIN 
                            TPB_ADJ_PKG...1. (,,,,) ; 
                            TPB_ADJ_PKG...2. (,,,,) ; 
                            TPB_ADJ_PKG.GET_ROC_OUT_OFC_FNC() ;
                         END;
                         ------------------------------------------------------
   7. Revision History : 2008.09.30 김진승 Created
                         2009.01.30 오완기 TPB Recovery Activity REMARK
                         2009.09.24 최  선  Migration
                         2011.01.17 변종건 [CHM-201108299-01] Adjustment History 구분(ROC/WO)
*******************************************************************************/

/*===============================================================================================
 * CRE_ADJ_REQ_PRC : CREATE TPB ADJUSTMENT REQUEST
 *===============================================================================================*/ 
 
PROCEDURE CRE_ADJ_REQ_PRC 
 
-- ===== Arguments ======================================== 
(     
 
    in_n3pty_no                 IN VARCHAR2, 
    in_user_ofc_cd              IN VARCHAR2, 
    in_user_id                  IN VARCHAR2, 
     
    in_n3pty_stl_tp_cd          IN VARCHAR2, 
    in_stl_rqst_rmk             IN VARCHAR2, 
    in_stl_to_clt_cng_ofc_cd    IN VARCHAR2,  
     
    in_file_no                  IN VARCHAR2,  
    in_ra_rmk1                  IN VARCHAR2,  --- RECOVERY ACTIVITY 1 
    in_ra_rmk2                  IN VARCHAR2   --- RECOVERY ACTIVITY 2 
 
)  
 
IS  
 
-- ===== DECLARE ========================================== 
  --v_n3pty_inv_no              TPB_INVOICE.n3pty_inv_no%TYPE;          -- temp TPB Inv No. 
  --v_n3pty_inv_rvis_seq        TPB_INV_RVIS.n3pty_inv_rvis_seq%TYPE;   -- n3pty_inv_rvis_seq 
 
    v_act_rmk                   TPB_OTS_GRP_RCVR_ACT.ACT_RMK%TYPE; 
    v_tmp_ofc_cd                VARCHAR2(6); 
    v_tmp                       VARCHAR2(100); 
 
-- ===== BEGIN, EXCEPTION and END ====================================== 
BEGIN 
 
    --- Initiate varibles  
     
    --- ====== IF TPB INV NO. is valid =========== 
    IF LENGTHB(in_n3pty_no) = 14 THEN ---------------------- 
 
        INSERT INTO TPB_ADJ_STS ( 
            n3pty_no,  
            adj_sts_seq,  
            stl_sts_lst_flg, n3pty_stl_tp_cd, 
            stl_rqst_ofc_cd, stl_rqst_dt, stl_rqst_usr_id, stl_rqst_rmk, 
            stl_to_clt_cng_ofc_cd, stl_clt_ofc_cng_amt, 
            cre_usr_id, cre_dt, upd_usr_id, upd_dt 
        ) 
        SELECT in_n3pty_no,  
               ( SELECT NVL(MAX(adj_sts_seq),0)+1 FROM TPB_ADJ_STS C WHERE n3pty_no = in_n3pty_no) next_seq,  
               '+', in_n3pty_stl_tp_cd,  
               in_user_ofc_cd, SYSDATE, in_user_id, in_stl_rqst_rmk,  
               DECODE(in_n3pty_stl_tp_cd,'O',in_stl_to_clt_cng_ofc_cd,NULL), DECODE(in_n3pty_stl_tp_cd,'O',bal_amt,NULL),  
               in_user_id, SYSDATE, in_user_id, SYSDATE  
          FROM TPB_OTS_GRP A  
         WHERE A.n3pty_no = in_n3pty_no  
           --- Not a auto-deleted thing(s)  
           AND A.n3pty_delt_tp_cd = 'N'  
           --- Now Adjustment Pre-Requested Status  
           AND EXISTS ( SELECT * FROM TPB_OTS_GRP_STS B  
                         WHERE B.n3pty_no = A.n3pty_no  
                           AND B.ots_sts_lst_flg = 'Y'  
                           AND B.ots_sts_cd IN ('O','J','M')  
                       )  
        ;
 
        UPDATE TPB_ADJ_STS C  
           SET stl_sts_lst_flg = DECODE(stl_sts_lst_flg, 'Y','N', '+','Y', stl_sts_lst_flg),  
               upd_usr_id = in_user_id,  
               upd_dt = SYSDATE  
         WHERE n3pty_no = in_n3pty_no  
           AND stl_sts_lst_flg IN ('Y','+')  
           --- Now Adjustment-Requested Status  
           AND EXISTS ( SELECT * FROM TPB_OTS_GRP_STS B  
                         WHERE B.n3pty_no = C.n3pty_no  
                           AND B.ots_sts_lst_flg = 'Y'  
                           AND B.ots_sts_cd IN ('O','J','M')  
                       )  
           --- Not a auto-deleted thing(s)  
           AND EXISTS ( SELECT * FROM TPB_OTS_GRP A  
                         WHERE A.n3pty_delt_tp_cd = 'N'  
                           AND A.n3pty_no = C.n3pty_no  
                       )  
        ;  
 
        SELECT DECODE(in_n3pty_stl_tp_cd,  
    	       'D', A.ofc_cd,  
    	       'C', A.ofc_cd,  
    	       'W', TPB_GET_HNDL_OFC_FNC('R',a.ofc_cd),  
    	       'O', in_stl_to_clt_cng_ofc_cd,  
    	       'the appropriate office' 
    	       ) next_step_ofc,  
        	   commcode_pkg.get_comdtl_name_fnc('CD00589', in_n3pty_stl_tp_cd) args2   
          INTO v_tmp_ofc_cd, v_tmp  
          FROM TPB_OTS_GRP A, 
               TPB_OTS_GRP_STS B
         WHERE A.n3pty_no = B.n3pty_no  
           --- Not a auto-deleted thing(s)  
           AND A.n3pty_delt_tp_cd = 'N'  
           --- Now Adjustment Pre-Requested Status  
           AND B.ots_sts_lst_flg = 'Y'  
           -- AND b.ots_sts_cd IN ('O','L','J') -- we cannot find outstanding status  
           AND A.n3pty_no = in_n3pty_no   
           AND ROWNUM = 1  
        ; 
 
        --- ----- RECOVERY ACTIVITY REMARK ----- ---         
      --v_act_rmk := 'Adjustment requested to ['||v_tmp_ofc_cd||'] due to ['||v_tmp||']';		--2009-01-30 
		v_act_rmk := '['||v_tmp||'] requested to '||v_tmp_ofc_cd||'.';  
 
        --- ====== ADD OUTSTANDING GROUP STATUS =========== 
        TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, 'R', in_user_id);  
        TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
        --- ====== ADD OUTSTANDING DETAIL STATUS =========== 
        ----- DETAIL -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'R', in_user_id);   
        ---  1) INSERT TPB_OTS_DTL_STS 
        INSERT INTO TPB_OTS_DTL_STS ( 
            ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt,  
            cre_usr_id, cre_dt, upd_usr_id, upd_dt 
        )  
        SELECT ots_dtl_seq, ots_dtl_sts_seq + 1, 'E', '+', SYSDATE,  
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
        ;
 
 
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
 
        --- ======= USER RECOVERY ACTIVITY ==================== 
        IF ( LENGTHB(in_ra_rmk1) > 0 ) THEN 
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',in_ra_rmk1,'A',in_file_no,in_user_ofc_cd,in_user_id); 
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',in_ra_rmk1,'A',in_file_no,in_user_ofc_cd,in_user_id); 
        END IF; 
 
        IF ( in_n3pty_stl_tp_cd = 'W' AND LENGTHB(in_ra_rmk2) > 0 ) THEN 
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',in_ra_rmk2,'A',in_file_no,in_user_ofc_cd,in_user_id); 
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',in_ra_rmk2,'A',in_file_no,in_user_ofc_cd,in_user_id); 
        END IF; 
 
 
    END IF; ------------------------------------------- 
 
--EXCEPTION 
--    WHEN OTHERS THEN 
--        v_lst_no := NULL; 
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  
      
 
END 
-- ===== End of Procedure ================================== 
; 
 
 
/*===============================================================================================
 * CRE_ADJ_APP_PRC : CREATE TPB ADJUSTMENT APPROVAL/REJECT  
 *===============================================================================================*/ 
 
PROCEDURE CRE_ADJ_APP_PRC 
 
-- ===== Arguments ======================================== 
(     
    in_action                   IN VARCHAR2,    -- Approval Action Type : ''(Null) / J / E 
    in_n3pty_no                 IN VARCHAR2,    -- 3rd Party No.  
    in_req_amt                  IN NUMBER,      -- Request Amount  Amount ( not used, bal_amt or roc_amt instead of this 
    in_stl_fwrd_ofc_cd          IN VARCHAR2,    -- Adjustment Forward Office Code  
    in_stl_cpy_ofc_cd           IN VARCHAR2,    -- Adjustment Copy Office Code  
    in_stl_rmk                  IN VARCHAR2,    -- Remarks  
    in_user_ofc_cd              IN VARCHAR2,    -- user office code   
    in_user_id                  IN VARCHAR2,    -- user id  
 
    in_file_no                  IN VARCHAR2,  
    in_ra_rmk                   IN VARCHAR2     -- RECOVERY ACTIVITY  
)  
 
IS  
 
-- ===== DECLARE ========================================== 
    v_stl_tp_cd                 TPB_ADJ_STS.n3pty_stl_tp_cd%TYPE;       -- settlement type code 
    v_new_n3pty_no              TPB_OTS_GRP.n3pty_no%TYPE;              -- new 3rd Party No. (Case R.O.C Approval) 
    v_current_if_ofc_cd         TPB_OTS_GRP.ofc_cd%TYPE;                -- current if_ofc_cd (Case R.O.C Approval) 
    v_new_if_ofc_cd             TPB_ADJ_STS.stl_to_clt_cng_ofc_cd%TYPE; -- new if_ofc_cd (Case R.O.C Approval) 
    n_ots_amt_origin            TPB_OTS_GRP.ots_amt%TYPE;               -- ots_amt original  
    n_ots_amt_gap               TPB_OTS_GRP.ots_amt%TYPE;               -- ots_amt - stl_clt_ofc_cng_amt value 
    v_before_ots_sts_cd         TPB_OTS_GRP_STS.ots_sts_cd%TYPE;        -- before R.O.C .. last Outstanding Status Code 
 
    v_n3pty_expn_tp_cd          TPB_OTS_GRP.n3pty_expn_tp_cd%TYPE;      -- n3pty_expn_tp_cd; to decide Head Office to forward  
    v_office_level              VARCHAR2(1);                            -- user office level; G(General Office) / R(R.HQ) / H(Head Office) 
 
    v_isOK                      VARCHAR2(1);                            -- Status Check - Continue  
    v_proc_type                 VARCHAR2(3);                            -- to process type 
                                /* ------------------- 
                                PROC
                                ------------------- 
                                    A / R	    AR1 
                                    A / R / F	ARF 
                                    A / R(F)	AR2 
                                    R / F	    RF 
                                    A(F) / R    AR3 
                                ------------------- */ 
    n_affected_rows             NUMBER(8); -- Affected Rows Count 
     
    v_roc_from_ofc_cd           TPB_ADJ_STS.stl_to_clt_cng_ofc_cd%TYPE; -- ROC-FROM OFC -- 2008-04-02 Added 
    v_roc_from_rhq_cd           TPB_ADJ_STS.stl_to_clt_cng_ofc_cd%TYPE; -- ROC-FROM RHQ -- 2008-04-02 Added 
    v_roc_to_ofc_cd             TPB_ADJ_STS.stl_to_clt_cng_ofc_cd%TYPE; -- ROC-TO OFC -- 2008-04-02 Added 
    v_roc_to_rhq_cd             TPB_ADJ_STS.stl_to_clt_cng_ofc_cd%TYPE; -- ROC-TO RHQ -- 2008-04-02 Added 
    v_next_stl_fwrd_ofc_cd      TPB_ADJ_STS.stl_fwrd_ofc_cd%TYPE;       -- ROC-TO RHQ -- 2008-04-02 Added 
    v_stl_rqst_ofc_cd           TPB_ADJ_STS.stl_rqst_ofc_cd%TYPE; 
 
    v_act_rmk                   TPB_OTS_GRP_RCVR_ACT.ACT_RMK%TYPE; 
        
    v_ots_sts_cd                TPB_OTS_GRP_STS.OTS_STS_CD%TYPE; 
 
-- ===== BEGIN, EXCEPTION  ====================================== 
BEGIN 
 
    --- Initiate varibles  
    v_stl_tp_cd                 := NULL;  
    v_new_n3pty_no              := NULL;  
    v_new_if_ofc_cd             := NULL; 
    n_ots_amt_gap               := NULL;  
    v_before_ots_sts_cd         := NULL;  
     
    v_office_level              := NULL; 
     
    v_isOK                      := NULL; 
    v_proc_type                 := NULL; 
 
    v_roc_from_ofc_cd           := NULL; 
    v_roc_from_rhq_cd           := NULL; 
    v_roc_to_ofc_cd             := NULL; 
    v_roc_to_rhq_cd             := NULL; 
     
 
    --///// Current Status Check ///////////////////////////////// 
 
    --- Getting Office Level  
    SELECT office_level  
      INTO v_office_level  
      FROM (  
            ----- HO ----- 
            SELECT 'H' office_level, ofc_cd   
              FROM TPB_HNDL_OFC  
             WHERE 1=1 
               AND n3pty_ofc_tp_cd IN ('H')  
               AND delt_flg = 'N'  
               AND ofc_cd = in_user_ofc_cd   
            -----     
            UNION 
            ----- RHQ ----- 
            SELECT 'R' office_level, ofc_cd   
              FROM TPB_HNDL_OFC  
             WHERE 1=1 
               AND n3pty_ofc_tp_cd IN ('R')  
               AND delt_flg = 'N'  
               AND ofc_cd = in_user_ofc_cd   
            -----     
            UNION 
            ----- GO ----- 
            SELECT 'G' office_level, ofc_cd   
              FROM TPB_HNDL_OFC  
             WHERE 1=1 
               AND n3pty_ofc_tp_cd IN ('T')  
               AND delt_flg = 'N'  
               AND ofc_cd = in_user_ofc_cd   
            ) A 
     WHERE 1=1      
       AND ROWNUM = 1 
    ;  
     
    --- Validity Check  Type Check 
    SELECT 'Y' isOK, a.n3pty_expn_tp_cd, c.n3pty_stl_tp_cd,  
           DECODE( c.n3pty_stl_tp_cd,  
                'D', 'AR1',  
                'C', 'AR1',  
                'W', DECODE( v_office_level, 'R','ARF', 'H','AR1', '-'),  
                'O', DECODE( v_office_level,  
                             'G','AR2',  
                             'H','AR1',  
                             'R', DECODE(TPB_GET_HNDL_OFC_FNC('R',a.ofc_cd),   
                                      TPB_GET_HNDL_OFC_FNC('R',c.stl_to_clt_cng_ofc_cd), 'AR1',  
                                      DECODE(c.stl_fwrd_ofc_cd,  
                                          TPB_GET_HNDL_OFC_FNC('R',c.stl_to_clt_cng_ofc_cd), 'AR2',  
                                          TPB_GET_HNDL_OFC_FNC('R',c.stl_rqst_ofc_cd), 'AR3',  
                                          '-' 
                                      )   
                                  ),   
                             '-'  
                     )  
           ) proc_type  
      INTO v_isOK, v_n3pty_expn_tp_cd, v_stl_tp_cd,  
           v_proc_type  
      FROM TPB_OTS_GRP_STS B, 
           TPB_ADJ_STS C, 
           TPB_OTS_GRP A  
     WHERE A.n3pty_no = B.n3pty_no  
       AND A.n3pty_no = C.n3pty_no  
       AND C.stl_sts_lst_flg = 'Y'  --- Active  Adjustment 
       AND B.ots_sts_lst_flg = 'Y'  --- Now Adjustment-Requested Status 
       AND B.ots_sts_cd = 'R'  
       AND A.n3pty_delt_tp_cd = 'N' --- Not a auto-deleted thing(s)  
       AND A.n3pty_no = in_n3pty_no --- in_n3pty_no  
    ;     
     
    --- Validity Check  Type Check 
    SELECT DECODE( v_proc_type,  
                'AR2', DECODE( stl_fwrd_ofc_cd,  
                         NULL, TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd),  
                         TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd), TPB_GET_HNDL_OFC_FNC('R',stl_rqst_ofc_cd),  
                         NULL  
                       ),   
                'AR3', NVL2( stl_fwrd_ofc_cd,  
                            DECODE(v_n3pty_expn_tp_cd, 'TES',(SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000004'), 'TRS',(SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000004'), (SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000005')), 
                            NULL 
                       ),  
                NVL2( C.stl_fwrd_ofc_cd,  
                    DECODE(A.n3pty_expn_tp_cd, 'TES',(SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000004'), 'TRS',(SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000004'), (SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000005')), 
                    NULL 
                )  
           ) next_stl_fwrd_ofc_cd, c.stl_rqst_ofc_cd 
      INTO v_next_stl_fwrd_ofc_cd, v_stl_rqst_ofc_cd  
      FROM TPB_OTS_GRP_STS B, 
           TPB_ADJ_STS C, 
           TPB_OTS_GRP A  
     WHERE A.n3pty_no = B.n3pty_no 
       AND A.n3pty_no = C.n3pty_no  
       AND C.stl_sts_lst_flg = 'Y'  -- Active Adjustment 
       AND B.ots_sts_lst_flg = 'Y'  -- Now Adjustment-Requested Status 
       AND B.ots_sts_cd = 'R'  
       AND A.n3pty_delt_tp_cd = 'N' -- Not a auto-deleted thing(s)  
       AND A.n3pty_no = in_n3pty_no -- in_n3pty_no  
    ;     
 
 
    IF ( v_isOK = 'Y' ) THEN  
     
        --=== Action : null(Forward) ================================ 
        IF ( in_action IS NULL OR in_action = '' ) AND ( in_stl_fwrd_ofc_cd IS NOT NULL ) THEN  
     
            ----- Update Outstanding Adjustment (Forward) ----- 
            UPDATE TPB_ADJ_STS C  
               SET stl_fwrd_ofc_cd = NVL2( stl_fwrd_ofc_cd,  
                                        DECODE(v_n3pty_expn_tp_cd, 'TES',(SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000004'), 'TRS',(SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000004'), (SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000005')), 
                                        NULL 
                                          ), 
                   stl_fwrd_dt = NVL2(in_stl_fwrd_ofc_cd,SYSDATE,NULL),  
                   stl_fwrd_usr_id = NVL2(in_stl_fwrd_ofc_cd,in_user_id,NULL), 
                   stl_cpy_ofc_cd = in_stl_cpy_ofc_cd,  
                   stl_cpy_dt = NVL2(in_stl_cpy_ofc_cd,SYSDATE,NULL),  
                   stl_cpy_usr_id = NVL2(in_stl_cpy_ofc_cd,in_user_id,NULL),  
                   stl_apro_rmk = in_stl_rmk,  
                   upd_usr_id = in_user_id,  
                   upd_dt = SYSDATE  
             WHERE n3pty_no = in_n3pty_no  
               -- Active  Adjustment 
               AND stl_sts_lst_flg = 'Y'  
               AND ROWNUM = 1  
            ; 
     
          --TPB_GEN_CLT_MSG_PRC( in_n3pty_no, NULL, NULL,  
          --                      'Adjustment was Forwarded To '||v_next_stl_fwrd_ofc_cd||'.',  
          --                      NULL, in_user_ofc_cd, in_user_id  
          -- );   
          
            ------- Rercovery Activity -------- 
            IF v_stl_tp_cd = 'O' THEN
                v_act_rmk := 'ROC is forwarded To '||v_next_stl_fwrd_ofc_cd||'.';
            ELSE
                v_act_rmk := 'Adjustment was Forwarded To '||v_next_stl_fwrd_ofc_cd||'.';
            END IF;
            
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);     
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
 
        --=== Action : Reject ======================================= 
        ELSIF ( in_action = 'J' ) THEN  
 
            ----- Reject As Forward ----- -------------------------- 
            IF v_proc_type = 'AR2' THEN  
 
                ----- Update Outstanding Adjustment (Forward) ----- 
                UPDATE TPB_ADJ_STS C  
                   SET stl_fwrd_ofc_cd = DECODE(stl_fwrd_ofc_cd,  
                                          NULL, TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd), -- Reject As Forward ... to ROC-To RHQ  -- 2008-04-01 
                                          TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd), TPB_GET_HNDL_OFC_FNC('R',stl_rqst_ofc_cd), -- Reject As Forward ... to ROC-From RHQ  -- 2008-04-01 
                                          NULL  
                                         ),   
                       stl_fwrd_dt = SYSDATE,  
                       stl_fwrd_usr_id = in_user_id,  
                       stl_cpy_ofc_cd = in_stl_cpy_ofc_cd,  
                       stl_cpy_dt = NVL2(in_stl_cpy_ofc_cd,SYSDATE,NULL),  
                       stl_cpy_usr_id = NVL2(in_stl_cpy_ofc_cd,in_user_id,NULL),  
                       stl_apro_rmk = in_stl_rmk,  
                       upd_usr_id = in_user_id,  
                       upd_dt = SYSDATE  
                 WHERE n3pty_no = in_n3pty_no  
                   -- Active  Adjustment 
                   AND stl_sts_lst_flg = 'Y'  
                   AND ROWNUM = 1  
                ; 
 
              --TPB_GEN_CLT_MSG_PRC( in_n3pty_no, NULL, NULL,  
              --                      'Adjustment forwarded To '||v_next_stl_fwrd_ofc_cd||'.',  
              --                      NULL, in_user_ofc_cd, in_user_id  
              -- );   
 
              ------- Rercovery Activity -------- 
            IF v_stl_tp_cd = 'O' THEN
                v_act_rmk := 'ROC is forwarded To '||v_next_stl_fwrd_ofc_cd||'.';
            ELSE
                v_act_rmk := 'Adjustment was Forwarded To '||v_next_stl_fwrd_ofc_cd||'.';
            END IF;
            
              TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);     
              TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
            ----- ELSE ( Reject ) ----- ---------------- 
            ELSE  
             
                ----- Update Outstanding Adjustment ----- 
                UPDATE TPB_ADJ_STS C   
                   SET stl_rjct_ofc_cd = in_user_ofc_cd,  
                       stl_rjct_dt = SYSDATE,  
                       stl_rjct_usr_id = in_user_id,  
                       stl_rjct_rmk = in_stl_rmk,  
                       stl_cpy_ofc_cd = in_stl_cpy_ofc_cd,  
                       stl_cpy_dt = NVL2(in_stl_cpy_ofc_cd,SYSDATE,NULL),  
                       stl_cpy_usr_id = NVL2(in_stl_cpy_ofc_cd,in_user_id,NULL),  
                       upd_usr_id = in_user_id,  
                       upd_dt = SYSDATE  
                 WHERE n3pty_no = in_n3pty_no  
                   -- Active  Adjustment 
                   AND stl_sts_lst_flg = 'Y'  
                   AND ROWNUM = 1  
                ; 
         
 
                --- ====== ADD OUTSTANDING GROUP STATUS =========== 
                SELECT DECODE(v_stl_tp_cd, 'C','K', 'D','K', 'O','J', 'W','J', 'J')  
                  INTO v_ots_sts_cd 
                  FROM DUAL  
                ;  
                 
                 
                TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, v_ots_sts_cd, in_user_id);  
         
         
                --- ====== ADD OUTSTANDING DETAIL STATUS =========== 
                ----- DETAIL -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'R', in_user_id);   
                ---  1) INSERT TPB_OTS_DTL_STS 
                INSERT INTO TPB_OTS_DTL_STS ( 
                    ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt,  
                    cre_usr_id, cre_dt, upd_usr_id, upd_dt 
                )  
                SELECT ots_dtl_seq, ots_dtl_sts_seq + 1, v_ots_sts_cd, '+', SYSDATE,  
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
                ; 
 
                --- ====== ADD Recovery Activity =========== 
                -- TPB_GEN_CLT_MSG_PRC( in_n3pty_no, 'A320', NULL, in_user_ofc_cd, NULL, in_user_ofc_cd, in_user_id ); 
                --v_act_rmk := 'Adjustment rejected by '||in_user_ofc_cd||'.';
                IF v_stl_tp_cd = 'O' THEN
                    v_act_rmk := 'ROC is rejected by '||in_user_ofc_cd||'.';
                ELSIF v_stl_tp_cd = 'W' THEN
                    v_act_rmk := 'W/O is rejected by '||in_user_ofc_cd||'.';
                END IF; 
                
                TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
                TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
 
                v_act_rmk := 'Responsible Office was changed to '||v_stl_rqst_ofc_cd||'.';  
                TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
                TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
                 
            END IF; ----- / Reject As Forward ------------- 
 
     
        --=== Action : Approval ===================================== 
        ELSIF ( in_action = 'E' ) THEN  
 
 
            ----- Approval As Forward ----- -------------------------- 
            IF v_proc_type = 'AR3' THEN  
 
                ----- Update Outstanding Adjustment (Forward) ----- 
                UPDATE TPB_ADJ_STS C  
                   SET stl_fwrd_ofc_cd = NVL2( stl_fwrd_ofc_cd,  
                                         DECODE(v_n3pty_expn_tp_cd, 'TES',(SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000004'), 'TRS',(SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000004'), (SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE SUB_SYS_CD='TPB' AND OFC_GRP_ID = '000005')), 
                                         NULL 
                                         ), 
                       stl_fwrd_dt = SYSDATE,  
                       stl_fwrd_usr_id = in_user_id,  
                       stl_cpy_ofc_cd = in_stl_cpy_ofc_cd,  
                       stl_cpy_dt = NVL2(in_stl_cpy_ofc_cd,SYSDATE,NULL),  
                       stl_cpy_usr_id = NVL2(in_stl_cpy_ofc_cd,in_user_id,NULL),  
                       stl_apro_rmk = in_stl_rmk,  
                       upd_usr_id = in_user_id,  
                       upd_dt = SYSDATE  
                 WHERE n3pty_no = in_n3pty_no  
                   -- Active  Adjustment 
                   AND stl_sts_lst_flg = 'Y'  
                   AND ROWNUM = 1  
                ; 
 
                --TPB_GEN_CLT_MSG_PRC( in_n3pty_no, NULL, NULL,  
                --                    'Adjustment forwarded To '||v_next_stl_fwrd_ofc_cd||'.',  
                --                    NULL, in_user_ofc_cd, in_user_id  
                -- );   
                --- ====== ADD Recovery Activity =========== 
                --TPB_GEN_CLT_MSG_PRC( in_n3pty_no, 'A320', NULL, in_user_ofc_cd, NULL, in_user_ofc_cd, in_user_id ); 
                --v_act_rmk := 'Adjustment forwarded To '||v_next_stl_fwrd_ofc_cd||'.';  
                IF v_stl_tp_cd = 'O' THEN
                    v_act_rmk := 'ROC is forwarded To '||v_next_stl_fwrd_ofc_cd||'.'; 
                ELSE 
                    v_act_rmk := 'Adjustment forwarded To '||v_next_stl_fwrd_ofc_cd||'.';              
                END IF;
                
                TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
                TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
 
            ----- ELSE ( Approval ) ----- ---------------- 
            ELSE  
 
 
                ----- Getting Adjustment Type Code, New Office Code ----- 
                SELECT C.n3pty_stl_tp_cd, A.ofc_cd, C.stl_to_clt_cng_ofc_cd, A.ots_amt,  
                    -- A.ots_amt - tpb_get_loc_amt_fnc(NVL(n_req_amt,0.0), A.curr_cd, A.cfm_dt) ots_amt_gap,    -- roc_amt In USD  
                       A.ots_amt - NVL(C.stl_clt_ofc_cng_amt,0.0) ots_amt_gap,                                  -- roc_amt In Local 
                       ( SELECT ots_sts_cd  
                           FROM TPB_OTS_GRP_STS S  
                          WHERE S.n3pty_no = A.n3pty_no  
                            AND S.ots_sts_seq = NVL( 
                                ( SELECT MAX(ots_sts_seq)  
                                    FROM TPB_OTS_GRP_STS T  
                                   WHERE T.n3pty_no = S.n3pty_no  
                                     AND T.ots_sts_cd != 'R'  
                                 ), 0) 
                            AND ROWNUM=1  
                       ) ots_sts_cd -- Getting Final Status Before Requesting 
                  INTO v_stl_tp_cd, v_current_if_ofc_cd, v_new_if_ofc_cd, n_ots_amt_origin,  
                       n_ots_amt_gap,  
                       v_before_ots_sts_cd   
                  FROM TPB_OTS_GRP_STS B, 
                       TPB_ADJ_STS C, 
                       TPB_OTS_GRP A  
                 WHERE A.n3pty_no = B.n3pty_no 
                   AND A.n3pty_no = C.n3pty_no  
                   AND C.stl_sts_lst_flg = 'Y'  --- Active  Adjustment 
                   AND B.ots_sts_lst_flg = 'Y'  --- Now Adjustment-Requested Status 
                   AND B.ots_sts_cd = 'R'  
                   AND A.n3pty_delt_tp_cd = 'N' --- Not a auto-deleted thing(s)  
                   AND A.n3pty_no = in_n3pty_no  
                ; 
         
                ----- Adjustment Type : General ----- 
                IF ( v_stl_tp_cd IS NOT NULL AND v_stl_tp_cd != 'O' ) THEN  
         
                    ----- Update Outstanding Group -----  
                    UPDATE TPB_OTS_GRP A  
                       SET bal_amt = 0.0,  
                           adj_amt = ots_amt - NVL(clt_amt,0.0),  
                           upd_usr_id = in_user_id,  
                           upd_dt = SYSDATE  
                     WHERE n3pty_no = in_n3pty_no   
                       -- Not a auto-deleted thing(s)  
                       AND A.n3pty_delt_tp_cd = 'N'  
                    ; 
                     
                    ----- Update Outstanding Detail -----  
                    UPDATE TPB_OTS_DTL A
                       SET bal_amt = 0.0,  
                           adj_amt = ots_amt - NVL(clt_amt,0.0),  
                           upd_usr_id = in_user_id,  
                           upd_dt = SYSDATE  
                     WHERE n3pty_no = in_n3pty_no   
                       -- Not a auto-deleted thing(s)  
                       AND A.n3pty_delt_tp_cd = 'N'  
                    ; 
                     
                    ----- Update Outstanding Adjustment -----  
                    UPDATE TPB_ADJ_STS C   
                       SET stl_apro_ofc_cd = in_user_ofc_cd,  
                           stl_apro_dt = SYSDATE,  
                           stl_apro_usr_id = in_user_id,  
                           stl_apro_rmk = in_stl_rmk,  
                           stl_cpy_ofc_cd = in_stl_cpy_ofc_cd,  
                           stl_cpy_dt = NVL2(in_stl_cpy_ofc_cd,SYSDATE,NULL),  
                           stl_cpy_usr_id = NVL2(in_stl_cpy_ofc_cd,in_user_id,NULL),  
                           upd_usr_id = in_user_id,  
                           upd_dt = SYSDATE  
                     WHERE n3pty_no = in_n3pty_no   
                       -- Active  Adjustment + Not R.O.C  
                       AND stl_sts_lst_flg = 'Y'  
                       AND n3pty_stl_tp_cd != 'O'  
                       AND ROWNUM = 1  
                    ; 
                 
     
                    --- ====== ADD OUTSTANDING GROUP STATUS -- T =========== 
                    v_ots_sts_cd := 'T';  
                    TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, v_ots_sts_cd, in_user_id); -- ADJUSTMENT APPROVAL 
             
                    --- ====== ADD OUTSTANDING DETAIL STATUS -- T =========== 
                    ----- DETAIL -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'R', in_user_id);   
                    ---  1) INSERT TPB_OTS_DTL_STS 
                    INSERT INTO TPB_OTS_DTL_STS ( 
                        ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt,  
                        cre_usr_id, cre_dt, upd_usr_id, upd_dt 
                    )  
                    SELECT ots_dtl_seq, ots_dtl_sts_seq + 1, v_ots_sts_cd, '+', SYSDATE,  
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
                    ; 
 
                     
                    --- ====== ADD OUTSTANDING GROUP STATUS -- E =========== 
                    v_ots_sts_cd := 'E';  
                    TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, v_ots_sts_cd, in_user_id); -- ADJUSTMENT APPROVAL 
             
                    --- ====== ADD OUTSTANDING DETAIL STATUS -- E =========== 
                    ----- DETAIL -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'R', in_user_id);   
                    ---  1) INSERT TPB_OTS_DTL_STS 
                    INSERT INTO TPB_OTS_DTL_STS ( 
                        ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt,  
                        cre_usr_id, cre_dt, upd_usr_id, upd_dt 
                    )  
                    SELECT ots_dtl_seq, ots_dtl_sts_seq + 1, v_ots_sts_cd, '+', SYSDATE,  
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
                    ; 
                     
                    --- ====== ADD Recovery Activity -- T =========== 
                    -- TPB_GEN_CLT_MSG_PRC( in_n3pty_no, 'A311', NULL, in_user_ofc_cd, NULL, in_user_ofc_cd, in_user_id ); 
                    --v_act_rmk := 'Adjustment approved by '||in_user_ofc_cd||'.'; 									--* 1.1 Modified : 2009-01-30 O Wan-Ki 
					v_act_rmk := 'W/O approved by '||in_user_ofc_cd||' --- Case closed'; 
                    TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
                    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
                    --- ====== ADD Recovery Activity -- E =========== 
                    --TPB_GEN_CLT_MSG_PRC( in_n3pty_no, 'A312', NULL, NULL, NULL, in_user_ofc_cd, in_user_id ); 
                    --v_act_rmk := 'Closed due to adjustment approved.'; 											--* 1.1 Modified : 2009-01-30 O Wan-Ki 
                    --TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);		--* 1.1 Modified : 2009-01-30 O Wan-Ki 
                    --TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);	--* 1.1 Modified : 2009-01-30 O Wan-Ki 
 
         
                ----- Adjustment Type : R.O.C ----- 
                ELSIF ( v_stl_tp_cd = 'O' ) THEN  
         
 
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
                           upd_usr_id = in_user_id,  
                           upd_dt = SYSDATE  
                     WHERE n3pty_no = in_n3pty_no   
                       -- Not a auto-deleted thing(s)  
                       AND A.n3pty_delt_tp_cd = 'N'  
                    ; 
                     
                    ----- Update Outstanding Group -----  
                    UPDATE TPB_OTS_GRP A  
                       SET ofc_cd = v_new_if_ofc_cd,  
                           curr_cd = NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'),  
                           ots_amt = ( SELECT SUM(ots_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                           bal_amt = ( SELECT SUM(bal_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                           rev_amt = ( SELECT SUM(rev_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                           adj_amt = ( SELECT SUM(adj_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                           upd_usr_id = in_user_id,  
                           upd_dt = SYSDATE  
                     WHERE n3pty_no = in_n3pty_no   
                        -- Not a auto-deleted thing(s)  
                       AND A.n3pty_delt_tp_cd = 'N'  
                    ; 
                     
                    ----- Update  Current Outstanding Adjustment ----- 
                    UPDATE TPB_ADJ_STS c   
                       SET stl_apro_ofc_cd = in_user_ofc_cd,  
                           stl_apro_dt = SYSDATE,  
                           stl_apro_usr_id = in_user_id,  
                           stl_apro_rmk = in_stl_rmk,  
                           stl_cpy_ofc_cd = in_stl_cpy_ofc_cd,  
                           stl_cpy_dt = NVL2(in_stl_cpy_ofc_cd,SYSDATE,NULL),  
                           stl_cpy_usr_id = NVL2(in_stl_cpy_ofc_cd,in_user_id,NULL),  
                           upd_usr_id = in_user_id,  
                           upd_dt = SYSDATE  
                     WHERE n3pty_no = in_n3pty_no   
                       -- Active  Adjustment + Only R.O.C  
                       AND stl_sts_lst_flg = 'Y'  
                       AND n3pty_stl_tp_cd = 'O'  
                       AND ROWNUM = 1  
                    ; 
                     
            
                    --- ====== ADD OUTSTANDING GROUP STATUS -- T =========== 
                    v_ots_sts_cd := 'T';  
                    TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, v_ots_sts_cd, in_user_id); -- ADJUSTMENT APPROVAL 
             
                    --- ====== ADD OUTSTANDING DETAIL STATUS -- T =========== 
                    ----- DETAIL -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'R', in_user_id);   
                    ---  1) INSERT TPB_OTS_DTL_STS 
                    INSERT INTO TPB_OTS_DTL_STS ( 
                        ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt,  
                        cre_usr_id, cre_dt, upd_usr_id, upd_dt 
                    )  
                    SELECT ots_dtl_seq, ots_dtl_sts_seq + 1, v_ots_sts_cd, '+', SYSDATE,  
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
                    ; 
                     
                    --- ====== ADD Recovery Activity -- T =========== 
                    --v_act_rmk := 'Adjustment approved by '||in_user_ofc_cd||'.';				--* 1.1 Modified : 2009-01-30 O Wan-Ki  
					v_act_rmk := '[Responsible Office Change] approved by '||in_user_ofc_cd||'.'; 
                    TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
                    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
 
                    --- ====== ADD OUTSTANDING GROUP STATUS -- O =========== 
                    v_ots_sts_cd := 'O';  
                    TPB_ADD_OTS_GRP_STS_PRC(in_n3pty_no, v_ots_sts_cd, in_user_id); -- ADJUSTMENT APPROVAL 
             
                    --- ====== ADD OUTSTANDING DETAIL STATUS -- O =========== 
                    ----- DETAIL -- TPB_ADD_OTS_DTL_STS_PRC(in_ots_dtl_seq, 'R', in_user_id);   
                    ---  1) INSERT TPB_OTS_DTL_STS 
                    INSERT INTO TPB_OTS_DTL_STS ( 
                        ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt,  
                        cre_usr_id, cre_dt, upd_usr_id, upd_dt 
                    )  
                    SELECT ots_dtl_seq, ots_dtl_sts_seq + 1, v_ots_sts_cd, '+', SYSDATE,  
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
                    ; 
                     
 
                    --- ====== ADD Recovery Activity -- T =========== 
                    v_act_rmk := 'Responsible Office was changed to '||v_new_if_ofc_cd||'.';  
                    TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
                    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
     
                END IF; 
                ----- / Adjustment Type ----- 
         
            END IF;  
            ----- / Approval As Forward ------------- 
 
        END IF;  
        --=== / Action ============================================== 
         
        --- ======= USER RECOVERY ACTIVITY ==================== 
        IF ( LENGTHB(in_ra_rmk) > 0 ) THEN 
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',in_ra_rmk,'A',in_file_no,in_user_ofc_cd,in_user_id); 
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',in_ra_rmk,'A',in_file_no,in_user_ofc_cd,in_user_id); 
        END IF; 
 
     
    END IF;  
    --///// Current Status Check ///////////////////////////////// 
 
--EXCEPTION 
--    WHEN OTHERS THEN 
--        v_lst_no := NULL; 
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  
      
 
END 
 
-- ===== End of Procedure ================================== 
; 
 


/*===============================================================================================
 * DEL_ADJ_REQ_PRC : REMOVE TPB ADJUSTMENT REQUEST 
 *===============================================================================================*/ 
 
PROCEDURE DEL_ADJ_REQ_PRC 
 
-- ===== Arguments ======================================== 
(     
    in_n3pty_no                 IN VARCHAR2,    -- 3rd Party No.  
    in_user_ofc_cd              IN VARCHAR2,    -- user office code   
    in_user_id                  IN VARCHAR2     -- user id  
)  
 
IS  
 
-- ===== DECLARE ========================================== 
  --v_n3pty_inv_no              TPB_INVOICE.n3pty_inv_no%TYPE;          -- temp TPB Inv No. 
  --v_n3pty_inv_rvis_seq        TPB_INV_RVIS.n3pty_inv_rvis_seq%TYPE;   -- n3pty_inv_rvis_seq 
 
    v_act_rmk                   TPB_OTS_GRP_RCVR_ACT.ACT_RMK%TYPE; 
    v_tmp_ofc_cd                VARCHAR2(6); 
    v_tmp                       VARCHAR2(100); 
	v_adj_tp			        VARCHAR2(2); 
 
-- ===== BEGIN, EXCEPTION and END ====================================== 
BEGIN 
 
    --- Initiate varibles  
     
    --- ====== IF TPB INV NO. is valid =========== 
    IF LENGTHB(in_n3pty_no) = 14 THEN ---------------------- 
		 
		SELECT n3pty_stl_tp_cd  
		  INTO v_adj_tp 
		  FROM TPB_ADJ_STS 
		 WHERE 1=1 
		   AND n3pty_no = in_n3pty_no 
		   AND stl_sts_lst_flg = 'Y' 
		; 
 
        --===== remove adjustment request ===== 
        DELETE 
          FROM TPB_ADJ_STS c  
         WHERE n3pty_no = in_n3pty_no  
           -- Active, Requested Settlement & Same With Office Requested 
           AND stl_sts_lst_flg = 'Y'  
           AND stl_rqst_ofc_cd = in_user_ofc_cd  
           -- Now Adjustment-Requested Status  
           AND EXISTS ( SELECT * FROM TPB_OTS_GRP_STS b  
                         WHERE b.n3pty_no = c.n3pty_no  
                           AND b.ots_sts_lst_flg = 'Y'  
                           AND b.ots_sts_cd = 'R'  
                      )  
           -- Not a auto-deleted thing(s)  
           AND EXISTS ( SELECT * FROM TPB_OTS_GRP a  
                         WHERE a.n3pty_delt_tp_cd = 'N'  
                           AND a.n3pty_no = c.n3pty_no  
                      )  
        ; 
         
        --===== recover final adjustment ===== 
        UPDATE TPB_ADJ_STS C  
           SET stl_sts_lst_flg = DECODE( adj_sts_seq, ( SELECT MAX(adj_sts_seq) FROM TPB_ADJ_STS X WHERE X.n3pty_no = C.n3pty_no ), 'Y', 'N' ),  
               upd_usr_id = in_user_id,  
               upd_dt = SYSDATE  
         WHERE n3pty_no = in_n3pty_no  
           AND adj_sts_seq = ( SELECT NVL(MAX(adj_sts_seq),0) FROM TPB_ADJ_STS Y WHERE Y.n3pty_no = C.n3pty_no )  
           -- Now Adjustment-Requested Status  
           AND EXISTS ( SELECT * FROM TPB_OTS_GRP_STS B  
                         WHERE B.n3pty_no = C.n3pty_no  
                           AND B.ots_sts_lst_flg = 'Y'  
                           AND B.ots_sts_cd = 'R'  
                       )  
           -- Not a auto-deleted thing(s)  
           AND EXISTS ( SELECT * FROM TPB_OTS_GRP A  
                         WHERE A.n3pty_delt_tp_cd = 'N'  
                           AND A.n3pty_no = c.n3pty_no  
                       )  
        ; 
         
        --===== recover final tpb status - 1 ===== 
        INSERT INTO TPB_OTS_GRP_STS (  
            n3pty_no,  
            ots_sts_seq,  
            ots_sts_cd,  
            ots_sts_lst_flg, ots_sts_cre_dt,  
            cre_usr_id, cre_dt, upd_usr_id, upd_dt  
        )  
        SELECT in_n3pty_no AS n3pty_no,  
               ( SELECT NVL(MAX(ots_sts_seq),0)+1 FROM TPB_OTS_GRP_STS WHERE n3pty_no = in_n3pty_no ) ots_sts_seq,  
               ( SELECT ots_sts_cd FROM TPB_OTS_GRP_STS S  
                  WHERE S.n3pty_no = in_n3pty_no  
                    AND S.ots_sts_seq = NVL(  
                        ( SELECT MAX(ots_sts_seq) FROM TPB_OTS_GRP_STS T  
                           WHERE T.n3pty_no = S.n3pty_no 
                             AND T.ots_sts_cd != 'R'  
                        ), 0)  
                    AND ROWNUM=1  
               ) ots_sts_cd,  
               '+' ots_sts_lst_flg, SYSDATE ots_sts_cre_dt,  
               in_user_id AS cre_usr_id, SYSDATE cre_dt, in_user_id AS upd_usr_id, SYSDATE upd_dt  
          FROM DUAL  
         WHERE 1=1  
           -- Now Adjustment-Requested Status  
           AND EXISTS ( SELECT * FROM TPB_OTS_GRP_STS B  
                         WHERE B.n3pty_no = in_n3pty_no  
                           AND B.ots_sts_lst_flg = 'Y'  
                           AND B.ots_sts_cd = 'R'  
                       )  
           -- Not a auto-deleted thing(s)  
           AND EXISTS ( SELECT * FROM TPB_OTS_GRP A  
                         WHERE A.n3pty_delt_tp_cd = 'N'  
                           AND A.n3pty_no = in_n3pty_no  
                       )  
        ; 
         
        --===== recover final tpb status - 2 ===== 
        UPDATE TPB_OTS_GRP_STS B  
           SET ots_sts_lst_flg = DECODE(ots_sts_lst_flg, 'Y','N', '+','Y', ots_sts_lst_flg),  
               upd_usr_id = in_user_id,  
               upd_dt = SYSDATE  
         WHERE n3pty_no = in_n3pty_no  
           -- Now Adjustment-Requested Status  
           AND ( ( ots_sts_lst_flg = 'Y' AND ots_sts_cd = 'R' ) OR ots_sts_lst_flg = '+' )  
           -- Not a auto-deleted thing(s)  
           AND EXISTS ( SELECT * FROM TPB_OTS_GRP A  
                         WHERE A.n3pty_delt_tp_cd = 'N'  
                           AND A.n3pty_no = B.n3pty_no  
                       )  
        ; 
         
        --===== Add Recovery Activity ===== 
		--* 1.1 Modified : 2009-01-30 O Wan-Ki      TPB Recovery Activity REMARK
        IF v_adj_tp = 'O' THEN  
			v_act_rmk := '[Responsible Office Change] request was cancelled.'; 
		ELSIF v_adj_tp = 'W' THEN 
			v_act_rmk := '[Write-Off] request was cancelled.'; 
		ELSE 
			v_act_rmk := 'Adjustment request was cancelled.'; 
		END IF; 
         
		TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
     
 
    END IF; ------------------------------------------- 
 
--EXCEPTION 
--    WHEN OTHERS THEN 
--        v_lst_no := NULL; 
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  
      
 
END 
-- ===== End of Procedure ================================== 
; 



/*===============================================================================================
 * GET_ROC_IN_OFC_FNC : GET ROC-IN OFFICE (ROC) 
 *===============================================================================================*/
 
FUNCTION GET_ROC_IN_OFC_FNC 
 
-- ===== Arguments ======================================== 
(     
    in_n3pty_no                 IN VARCHAR2  
)  
 
     
RETURN VARCHAR2                 -- RETURN TYPE  
 
IS  
 
-- ===== DECLARE ========================================== 
    v_rtn                       VARCHAR2(100); -- VALID Y/N 
 
 
-- ===== BEGIN, EXCEPTION  ====================================== 
BEGIN 
 
    --- Initiate varibles  
    v_rtn := NULL;  
 
    ---- ROC-IN OFFICE 
    SELECT ( SELECT J.stl_to_clt_cng_ofc_cd  
               FROM TPB_ADJ_STS J  
              WHERE J.n3pty_no = in_n3pty_no  
                AND adj_sts_seq = ( SELECT MAX(adj_sts_seq)  
                                      FROM TPB_ADJ_STS K  
                                     WHERE K.n3pty_no = J.n3pty_no  
                                       AND K.stl_sts_lst_flg='N'  
                                       AND K.n3pty_stl_tp_cd='O'
                                   )  
           ) AS roc_in   
      INTO v_rtn  
      FROM DUAL  
    ;  
     
    --- Returning Result  
    RETURN v_rtn;  
 
EXCEPTION 
    WHEN OTHERS THEN 
        v_rtn := NULL; 
        RETURN v_rtn;  
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  
 
END 
 
-- ===== End of Function ================================== 
; 
 

/*===============================================================================================
 * GET_ROC_OUT_OFC_FNC : GET ROC-OUT OFFICE (ROC) 
 *===============================================================================================*/
 
FUNCTION GET_ROC_OUT_OFC_FNC 
 
-- ===== Arguments ======================================== 
(     
    in_n3pty_no                 IN VARCHAR2  
)  
 
     
RETURN VARCHAR2                 -- RETURN TYPE  
 
IS  
 
-- ===== DECLARE ========================================== 
    v_rtn                       VARCHAR2(100); -- VALID Y/N 
 
 
-- ===== BEGIN, EXCEPTION  ====================================== 
BEGIN 
 
    --- Initiate varibles  
    v_rtn := NULL;  
 
    ---- ROC-OUT OFFICE 
    SELECT ( SELECT J.stl_rqst_ofc_cd FROM TPB_ADJ_STS J  
              WHERE J.n3pty_no = in_n3pty_no  
                AND adj_sts_seq = ( SELECT MAX(adj_sts_seq)  
                                      FROM TPB_ADJ_STS K  
                                     WHERE K.n3pty_no = J.n3pty_no  
                                       AND K.stl_sts_lst_flg='N'  
                                       AND K.n3pty_stl_tp_cd='O'  
                                       AND adj_sts_seq < ( SELECT MAX(adj_sts_seq)  
                                                             FROM TPB_ADJ_STS K  
                                                            WHERE K.n3pty_no = J.n3pty_no  
                                                              AND K.stl_sts_lst_flg='N'  
                                                              AND K.n3pty_stl_tp_cd='O'  
                                                          )  
                                  )  
           ) AS roc_out   
      INTO v_rtn  
      FROM DUAL  
    ;  
     
    --- Returning Result  
    RETURN v_rtn;  
 
EXCEPTION 
    WHEN OTHERS THEN 
        v_rtn := NULL; 
        RETURN v_rtn;  
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  
 
END 
 
-- ===== End of Function ================================== 
; 
 
 
-- ===============================================================================================
 
END 
-- ===== End of Package ================================== 
;