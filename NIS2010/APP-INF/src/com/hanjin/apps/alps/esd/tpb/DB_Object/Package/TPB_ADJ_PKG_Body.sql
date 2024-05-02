CREATE OR REPLACE PACKAGE BODY NISADM."TPB_ADJ_PKG"
 
IS 

/***************************************************************************************************
   1. Object Name      : TPB_ADJ_PKG
   2. Version          : 1.4
   3. Create Date      : 2008-09-30
   4. Sub System       : Third Party Billing
   5. Author           : Sun, CHOI
   6. Description      : TPB Invoice Creation Package Body 
                         ---------------------------------------------------------------------------
                         DECLARE  
 
                         BEGIN 
                            TPB_ADJ_PKG...1. (,,,,) ; 
                            TPB_ADJ_PKG...2. (,,,,) ; 
                            TPB_ADJ_PKG.GET_ROC_OUT_OFC_FNC() ;
                         END;
                         ---------------------------------------------------------------------------
   7. Revision History : 2008.09.30 김진승 Created
                         2009.01.30 오완기 TPB Recovery Activity REMARK
                         2009.09.24 최  선 ALPS Migration
                         2010.10.21 안정선 [CHM-201005566-01] 2nd Review
                         2011.01.17 변종건 [CHM-201108299-01] Adjustment History 구분(ROC/WO)
                         2011.03.10 안정선 [CHM-201108299-01] OTS_STS_DTL_CD 추가
                         2012.05.17 조원주 [CHM-201216957] W/O reason 추가
                         2012.09.25 조원주 [CHM-201220286-01] [TPB-W/O] Reason RHQ W/O reason반영
                         2012.12.31 안정선 [CHM-201220985] [TPB] PSO에 대한 3자구상 개발관련
                         2014.06.18 js     [CHM-201430629] [TPB] ROC  2nd Review시 COL OFC code 변경(SELCOL->SELCON)
                         2014.07.31 JS     [CHM-201430873] [TPB] SELBB/TYOBB ROC 절차 변경
                         2014.08.18 JS     [SRM-201446826] [TPB] PUSCOV 조직 code 변경 (PUSMOV)
                         2014.08.27 JS     [CHM-201431586] [TPB] SELBB/TYOBB WRITE-OFF REQUEST시 본사 검토
                         2014.08.28 JS     [CHM-2014082718] TPEBB에서 REJ 했는데 SHAAS로 안넘어 가고
                         2014.09.26 JS     [CHM-201431586-2] [TPB] SELBB/TYOBB WRITE-OFF REQUEST시 본사 검토
                         2015.02.13 JS     [CHM-201534044] TPB ROC 본사 승인 권한 추가 요청 (TES, TRS)
                                            가. 현행
                                             "TES"case 승인 오피스 : "SELCON"
                                             "TRS"case 승인 오피스 : "SELCON"
                                            나. To be 
                                             "TES"case 승인 오피스 : "SELCOT"
                                             "TRS"case 승인 오피스 : "SELCON" 
                                              기타 M&R 및 PSO는 COE및 MOV 현행 유지 
                       2015.08.05 Kim Hyun Hwa[CHM-201537151]그룹사 표준 코드 시행 프로그램 수정                         
****************************************************************************************************/

/*==================================================================================================
 * CRE_ADJ_REQ_PRC : CREATE TPB ADJUSTMENT REQUEST
 *==================================================================================================*/ 
 
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
    in_ra_rmk2                  IN VARCHAR2,  --- RECOVERY ACTIVITY 2 
    in_wrtf_rsn_cd              IN VARCHAR2     -- W/O reason
 
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
            stl_to_clt_cng_ofc_cd, stl_clt_ofc_cng_amt, wrtf_rsn_cd,
            cre_usr_id, cre_dt, upd_usr_id, upd_dt 
        ) 
        SELECT in_n3pty_no,  
               ( SELECT NVL(MAX(adj_sts_seq),0)+1 FROM TPB_ADJ_STS C WHERE n3pty_no = in_n3pty_no) next_seq,  
               '+', in_n3pty_stl_tp_cd,  
               in_user_ofc_cd, SYSDATE, in_user_id, in_stl_rqst_rmk,  
               DECODE(in_n3pty_stl_tp_cd,'O',in_stl_to_clt_cng_ofc_cd,NULL), DECODE(in_n3pty_stl_tp_cd,'O',bal_amt,NULL), in_wrtf_rsn_cd,
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
               wrtf_rsn_cd = in_wrtf_rsn_cd,
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
 
        --[CHM-201431586] [TPB] SELBB/TYOBB WRITE-OFF REQUEST시 본사 검토
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
        
        --- ----- [CHM-201431586-2] [TPB] SELBB/TYOBB WRITE-OFF REQUEST시 본사 검토
--        IF ( in_n3pty_stl_tp_cd = 'W' ) THEN        
--        --- ----- #if (${s_user_ofc_cd} == 'SELCON' || ${s_user_ofc_cd} == 'SELCOE' || ${s_user_ofc_cd} == 'POSMOV') 
--                         SELECT DECODE(in_n3pty_stl_tp_cd,'W','HO',v_tmp_ofc_cd) INTO v_tmp_ofc_cd
--                         FROM  TPB_OTS_GRP C, TPB_ADJ_AMT_SET S
--                         WHERE C.n3pty_no = in_n3pty_no   
--                         AND TPB_GET_USD_AMT_FNC(C.OTS_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD))>=S.N3PTY_BIL_ADJ_AMT   --ex.over$1000forHOReview
--                         AND S.N3PTY_BIL_ADJ_OFC_CD = in_user_ofc_cd
--                         ;
--        --- ----- #elsif (${s_user_ofc_cd} == 'SELBB' || ${s_user_ofc_cd} == 'TYOBB') 	
----                                   AND C.OFC_CD IN (SELECT N3PTY_BIL_ADJ_OFC_CD 
----                                                    FROM TPB_ADJ_AMT_SET 
----                                                    WHERE N3PTY_BIL_ADJ_OFC_CD IN (SELECT OFC_CD FROM TPB_HNDL_OFC WHERE N3PTY_CTRL_OFC_CD = @[s_user_ofc_cd] AND DELT_FLG='N')
----                                                    AND TPB_GET_USD_AMT_FNC(C.OTS_AMT,C.CURR_CD,TPB_GET_LCL_DATE_FNC(C.CFM_DT,C.OFC_CD))<N3PTY_BIL_ADJ_AMT )  --ex.under$1000forSELBB/TYOBB Review
--        --- ----- #end    
--        END IF;
 
        --- ----- RECOVERY ACTIVITY REMARK ----- ---         
      --v_act_rmk := 'Adjustment requested to ['||v_tmp_ofc_cd||'] due to ['||v_tmp||']';		--2009-01-30 
	  --v_act_rmk := '['||v_tmp||'] requested to '||v_tmp_ofc_cd||'.';  
	  --- ----- [CHM-201431586-2] [TPB] SELBB/TYOBB WRITE-OFF REQUEST시 본사 검토
	    v_act_rmk := '['||v_tmp||'] Requested.'; 
 
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
        
        
        ----Clear FOR 2ND Review 
        UPDATE TPB_ADJ_N2ND_RVW_HIS
           SET STL_STS_LST_FLG = 'N'
         WHERE n3pty_no = in_n3pty_no
           AND STL_STS_LST_FLG = 'Y';
           
        /*----Adjust Status Detail Code 추가
        <IS NULL: STL_FWRD_OFC_CD&STL_RJCT_OFC_CD&STL_APRO_OFC_CD>
        CD02799	R4	W/O requeted to RHQ	      N3PTY_STL_TP_CD='O'
        CD02799	R5	ROC requeted to Office	  N3PTY_STL_TP_CD='W'        */
        UPDATE TPB_OTS_GRP
           SET OTS_STS_DTL_CD = DECODE(in_n3pty_stl_tp_cd,'O','R5','R4')
         WHERE N3PTY_NO = in_n3pty_no;
 
 
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
    in_ra_rmk                   IN VARCHAR2,    -- RECOVERY ACTIVITY  
    in_n2nd_rvw_flg             IN VARCHAR2,     -- Second Review : 'Y' / 'N' 
    in_wrtf_rsn_cd              IN VARCHAR2     -- RHQ W/O reason
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
 
 
    v_act_rmk                   TPB_OTS_GRP_RCVR_ACT.ACT_RMK%TYPE; 
        
    v_ots_sts_cd                TPB_OTS_GRP_STS.OTS_STS_CD%TYPE;
    v_rvw_cnt                   NUMBER(3);                              -- 2nd Review Count 
    v_rvw_cnt_log               VARCHAR2(2); 
    v_n2nd_rvw_aval_flg	        VARCHAR2(1):='';
    v_adj_n2nd_rvw_sts_cd	    VARCHAR2(2):='';   
    v_adj_n2nd_rvw_seq          NUMBER(3);
    v_adj_app_chk               VARCHAR2(1):='';
    
    v_rofc_cd                   TPB_ADJ_STS.stl_fwrd_ofc_cd%TYPE;
    
    v_ots_sts_cd_val            VARCHAR2(10):='';
    v_tp_cd                     VARCHAR2(1):='';
    
    v_roc_proc_flg              VARCHAR2(1):='N';                       -- SELBB/TYOBB ROC 

 
-- ===== BEGIN, EXCEPTION  ====================================== 
BEGIN 
    DBMS_OUTPUT.disable;
--      DBMS_OUTPUT.enable;
 
    --- Initiate varibles  
    v_stl_tp_cd                 := NULL;  
    v_new_n3pty_no              := NULL;  
    v_new_if_ofc_cd             := NULL; 
    n_ots_amt_gap               := NULL;  
    v_before_ots_sts_cd         := NULL;  
     
    v_office_level              := NULL;
    v_rofc_cd                   := NULL;        ----2010.10.21
     
    v_isOK                      := NULL; 
    v_proc_type                 := NULL; 
 
    v_roc_from_ofc_cd           := NULL; 
    v_roc_from_rhq_cd           := NULL; 
    v_roc_to_ofc_cd             := NULL; 
    v_roc_to_rhq_cd             := NULL; 
    
    
 
    --///// Current Status Check ///////////////////////////////// 
 
    --- Getting Office Level  
    SELECT office_level, rhq_cd  
      INTO v_office_level, v_rofc_cd  
      FROM (  
            ----- HO ----- 
            SELECT 'H' office_level, ofc_cd, rhq_cd   
              FROM TPB_HNDL_OFC  
             WHERE 1=1 
               AND n3pty_ofc_tp_cd IN ('H')  
               AND delt_flg = 'N'  
               AND ofc_cd = in_user_ofc_cd   
            -----     
            UNION 
            ----- RHQ ----- 
            SELECT 'R' office_level, ofc_cd, rhq_cd   
              FROM TPB_HNDL_OFC  
             WHERE 1=1 
               AND n3pty_ofc_tp_cd IN ('S')  
               AND delt_flg = 'N'  
               AND ofc_cd = in_user_ofc_cd   
            -----     
            UNION 
            ----- GO ----- 
            SELECT 'G' office_level, ofc_cd, rhq_cd   
              FROM TPB_HNDL_OFC  
             WHERE 1=1 
               AND n3pty_ofc_tp_cd IN ('T')  
               AND delt_flg = 'N'  
               AND ofc_cd = in_user_ofc_cd   
            ) A 
     WHERE 1=1      
       AND ROWNUM = 1 
    ;
    
 DBMS_OUTPUT.PUT_LINE('v_office_level=['||v_office_level||'] v_rofc_cd=['||v_rofc_cd||']');
    
    ----Before Adjustment chkeck for 2nd Review   
    SELECT DECODE(OTS_STS_CD,'O','Y','N')  INTO v_adj_app_chk
    FROM TPB_OTS_GRP_STS
    WHERE N3PTY_NO = in_n3pty_no
    AND   OTS_STS_LST_FLG='Y' 
    ;
    
--    SELECT NVL2(STL_APRO_OFC_CD,'Y','N') INTO v_adj_app_chk
--    FROM TPB_ADJ_STS
--    WHERE N3PTY_NO = in_n3pty_no
--    AND STL_STS_LST_FLG = 'Y'
--    ;

 DBMS_OUTPUT.PUT_LINE('v_adj_app_chk=['||v_adj_app_chk||']');    
     
    ----2nd Review Check : 2010.10.21
    IF in_n2nd_rvw_flg = 'Y' THEN  
 DBMS_OUTPUT.PUT_LINE('[0]');       
    
            --- Validity Check  Type Check 
            SELECT 'Y' isOK, a.n3pty_expn_tp_cd, c.n3pty_stl_tp_cd,  
                   DECODE( c.n3pty_stl_tp_cd,  
                        'D', 'AR1',  
                        'C', 'AR1',  
                        'W', DECODE( v_office_level, 'R','ARF', 'H','AR1', '-'),  
                        'O', DECODE( v_office_level,  
                                     'G','AR2',  
                                     'H','AR1',  
                                     'R', DECODE(TPB_GET_HNDL_OFC_FNC('R',STL_RQST_OFC_CD),   
                                              TPB_GET_HNDL_OFC_FNC('R',STL_TO_CLT_CNG_OFC_CD), 'AR1',  
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
                   TPB_ADJ_N2ND_RVW_HIS C, 
                   TPB_OTS_GRP A  
             WHERE A.n3pty_no = B.n3pty_no  
               AND A.n3pty_no = C.n3pty_no  
               AND C.stl_sts_lst_flg = 'Y'  --- Active  Adjustment 
               AND C.ADJ_N2ND_RVW_STS_CD = DECODE(C.UPD_USR_ID
                             ,TPB_GET_HNDL_OFC_FNC('R',C.STL_TO_CLT_CNG_OFC_CD),'R2'
                             ,TPB_GET_HNDL_OFC_FNC('R',C.STL_RQST_OFC_CD),'R3','R4')    --자기가 한 결정만 재검토가 가능토록
               AND C.UPD_USR_ID in (in_user_ofc_cd, v_rofc_cd)                          --결정할 Office 가 로그인, RHQ 대행 반영
               AND B.ots_sts_lst_flg = 'Y'  --- Now Adjustment-Requested Status 
               AND B.ots_sts_cd IN ('R','O','J')
               AND A.n3pty_delt_tp_cd = 'N' --- Not a auto-deleted thing(s)  
               AND A.n3pty_no = in_n3pty_no --- in_n3pty_no  
            ;     
 DBMS_OUTPUT.PUT_LINE('[1]');              
             
            --- Validity Check  Type Check 
            SELECT DECODE( v_proc_type,  
                        'AR2', DECODE( stl_fwrd_ofc_cd,  
                                 NULL, TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd),  
                                 TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd), TPB_GET_HNDL_OFC_FNC('R',stl_rqst_ofc_cd),  
                                 NULL  
                               ),   
                        'AR3', NVL2( stl_fwrd_ofc_cd,  
                                    --DECODE(v_n3pty_expn_tp_cd, 'TES','SELCOL', 'TRS','SELCOL', 'SELCOE'),   [CHM-201220985]
                                   -- DECODE(v_n3pty_expn_tp_cd, 'TES','SELCOT', 'TRS','SELCON', 'MNR','SELCOE', 'PUSMOV'), --조직변경
                                    DECODE(v_n3pty_expn_tp_cd, 'TES','SELOPA', 'TRS','SELOPB', 'MNR','SELOPE', 'PUSMOV'),
                                    NULL 
                               ),  
                        NVL2( C.stl_fwrd_ofc_cd,  
                            --DECODE(A.n3pty_expn_tp_cd, 'TES','SELCOL', 'TRS','SELCOL', 'SELCOE'),   [CHM-201220985]
                            --DECODE(A.n3pty_expn_tp_cd, 'TES','SELCOT', 'TRS','SELCON', 'MNR','SELCOE', 'PUSMOV'),
                            DECODE(v_n3pty_expn_tp_cd, 'TES','SELOPA', 'TRS','SELOPB', 'MNR','SELOPE', 'PUSMOV'), -- 조직변경
                            NULL 
                        )  
                   ) next_stl_fwrd_ofc_cd  
              INTO v_next_stl_fwrd_ofc_cd  
              FROM TPB_OTS_GRP_STS B, 
                   TPB_ADJ_N2ND_RVW_HIS C, 
                   TPB_OTS_GRP A  
             WHERE A.n3pty_no = B.n3pty_no 
               AND A.n3pty_no = C.n3pty_no  
               AND C.stl_sts_lst_flg = 'Y'  -- Active Adjustment 
               AND C.ADJ_N2ND_RVW_STS_CD = DECODE(C.UPD_USR_ID
                             ,TPB_GET_HNDL_OFC_FNC('R',C.STL_TO_CLT_CNG_OFC_CD),'R2'
                             ,TPB_GET_HNDL_OFC_FNC('R',C.STL_RQST_OFC_CD),'R3','R4')    --자기가 한 결정만 재검토가 가능토록
               AND C.UPD_USR_ID in (in_user_ofc_cd, v_rofc_cd)                          --결정할 Office 가 로그인, RHQ 대행 반영               
               AND B.ots_sts_lst_flg = 'Y'  -- Now Adjustment-Requested Status 
               AND B.ots_sts_cd IN ('R','O','J')
               AND A.n3pty_delt_tp_cd = 'N' -- Not a auto-deleted thing(s)  
               AND A.n3pty_no = in_n3pty_no -- in_n3pty_no  
            ;     
 DBMS_OUTPUT.PUT_LINE('[2]');              
            
            ---- Validity Check 2nd Review Status & Available
--            SELECT N2ND_RVW_AVAL_FLG, ADJ_N2ND_RVW_STS_CD INTO v_n2nd_rvw_aval_flg, v_adj_n2nd_rvw_sts_cd
--            FROM TPB_ADJ_N2ND_RVW_HIS
--            WHERE N3PTY_NO = in_n3pty_no
--            AND   STL_STS_LST_FLG   = 'Y'
            SELECT H.ADJ_N2ND_RVW_SEQ, H.N2ND_RVW_AVAL_FLG, H.ADJ_N2ND_RVW_STS_CD INTO v_adj_n2nd_rvw_seq, v_n2nd_rvw_aval_flg, v_adj_n2nd_rvw_sts_cd
            FROM  TPB_ADJ_STS S, TPB_ADJ_N2ND_RVW_HIS H
            WHERE S.N3PTY_NO = in_n3pty_no
            AND   S.STL_STS_LST_FLG = 'Y'
            AND   H.N3PTY_NO = S.N3PTY_NO
            AND   H.ADJ_STS_SEQ = S.ADJ_STS_SEQ
            AND   H.stl_sts_lst_flg = 'Y'     
            AND   H.ADJ_N2ND_RVW_STS_CD = DECODE(H.UPD_USR_ID
                                         ,TPB_GET_HNDL_OFC_FNC('R',S.STL_TO_CLT_CNG_OFC_CD),'R2'
                                         ,TPB_GET_HNDL_OFC_FNC('R',S.STL_RQST_OFC_CD),'R3','R4')    --자기가 한 결정만 재검토가 가능토록
            AND   H.UPD_USR_ID in (in_user_ofc_cd, v_rofc_cd)                          --결정할 Office 가 로그인, RHQ 대행 반영                              
            ;
            
 DBMS_OUTPUT.PUT_LINE('[3]');  
             
    ELSE
    
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
                                    --DECODE(v_n3pty_expn_tp_cd, 'TES','SELCOL', 'TRS','SELCOL', 'SELCOE'),     [CHM-201220985]
                                    --DECODE(v_n3pty_expn_tp_cd, 'TES','SELCOT', 'TRS','SELCON', 'MNR', 'SELCOE', 'PUSMOV'), -- 조직변경
                                    DECODE(v_n3pty_expn_tp_cd, 'TES','SELOPA', 'TRS','SELOPB', 'MNR','SELOPE', 'PUSMOV'),
                                    NULL 
                               ),  
                        NVL2( C.stl_fwrd_ofc_cd,  
                            --DECODE(A.n3pty_expn_tp_cd, 'TES','SELCOL', 'TRS','SELCOL', 'SELCOE'),   [CHM-201220985]
                            --DECODE(A.n3pty_expn_tp_cd, 'TES','SELCOT', 'TRS','SELCON', 'MNR', 'SELCOE', 'PUSMOV'), -- 조직변경
                            DECODE(v_n3pty_expn_tp_cd, 'TES','SELOPA', 'TRS','SELOPB', 'MNR','SELOPE', 'PUSMOV'),    
                            NULL 
                        )  
                   ) next_stl_fwrd_ofc_cd  
              INTO v_next_stl_fwrd_ofc_cd  
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
    
    END IF;        
 
 DBMS_OUTPUT.PUT_LINE('v_isOK, v_n3pty_expn_tp_cd, v_stl_tp_cd,v_proc_type=['||v_isOK||','||v_n3pty_expn_tp_cd||','||v_stl_tp_cd||','||v_proc_type||']');
 DBMS_OUTPUT.PUT_LINE('v_next_stl_fwrd_ofc_cd=['||v_next_stl_fwrd_ofc_cd||']');
 DBMS_OUTPUT.PUT_LINE('v_adj_n2nd_rvw_seq, v_n2nd_rvw_aval_flg, v_adj_n2nd_rvw_sts_cd=['||v_adj_n2nd_rvw_seq||','||v_n2nd_rvw_aval_flg||','||v_stl_tp_cd||','||v_adj_n2nd_rvw_sts_cd||']');

 
 --[CHM-201430873] [TPB] SELBB/TYOBB ROC 절차 변경::START---------------------------
    IF ( v_next_stl_fwrd_ofc_cd = 'SELIB' OR v_next_stl_fwrd_ofc_cd = 'TYOIB' ) THEN 
        -- 조직변경 
        --SELECT DECODE(v_n3pty_expn_tp_cd, 'TES','SELCOT', 'TRS','SELCON', 'MNR','SELCOE', 'PUSMOV')
        SELECT DECODE(v_n3pty_expn_tp_cd, 'TES','SELOPA', 'TRS','SELOPB', 'MNR','SELOPE', 'PUSMOV')    
          INTO v_next_stl_fwrd_ofc_cd
        FROM   DUAL;
        
        --SELBB/TYOBB 산하 점소간 ROC 여부 체크 : ex)ROC-out[PUSBB] - ROC-in[SELBB]  --case1 SELBB 산하 점소 간
        --SELBB/TYOBB 산하 점소간 ROC 여부 체크 : ex)ROC-out[SELBB] - ROC-in[PUSBB]  --case1 SELBB 산하 점소 간 
        --20140820 산한점소간 Reject인 경우만 체크 보완
        IF  (in_action <> 'E') THEN
            SELECT CASE WHEN TPB_GET_HNDL_OFC_FNC('C',stl_rqst_ofc_cd) = 'SELSC'--'SELBB'
                         AND TPB_GET_HNDL_OFC_FNC('C',stl_to_clt_cng_ofc_cd) = 'SELSC'--'SELBB'     
                         AND stl_to_clt_cng_ofc_cd <> stl_rqst_ofc_cd
                        THEN  'Y'
                        ELSE  'N'
                   END 
              INTO v_roc_proc_flg
            FROM TPB_ADJ_STS
             WHERE n3pty_no = in_n3pty_no  
               AND stl_sts_lst_flg = 'Y'  
               AND ROWNUM = 1  
            ;    
        END IF;    
        
        IF v_roc_proc_flg = 'Y' THEN
            SELECT stl_rqst_ofc_cd 
                INTO v_next_stl_fwrd_ofc_cd            
            FROM TPB_ADJ_STS
             WHERE n3pty_no = in_n3pty_no  
               AND stl_sts_lst_flg = 'Y'  
               AND ROWNUM = 1  
            ;             
            
        END IF;        
        
        
    END IF;    
 --[CHM-201430873] [TPB] SELBB/TYOBB ROC 절차 변경::END-----------------------------
 
 
    IF ( v_isOK = 'Y' ) THEN  
     
        --=== Action : null(Forward) ================================ 
        IF ( in_action IS NULL OR in_action = '' ) AND ( in_stl_fwrd_ofc_cd IS NOT NULL ) THEN  
        DBMS_OUTPUT.PUT_LINE('Action : null(Forward)');
            ----- Update Outstanding Adjustment (Forward) ----- 
            UPDATE TPB_ADJ_STS C  
               SET stl_fwrd_ofc_cd = NVL2( stl_fwrd_ofc_cd,  
                                        --DECODE(v_n3pty_expn_tp_cd, 'TES','SELCOL', 'TRS','SELCOL', 'SELCOE'),       [CHM-201220985]
                                       -- DECODE(v_n3pty_expn_tp_cd, 'TES','SELCOT', 'TRS','SELCON', 'MNR','SELCOE', 'PUSMOV'), -- 조직변경
                                         DECODE(v_n3pty_expn_tp_cd, 'TES','SELOPA', 'TRS','SELOPB', 'MNR','SELOPE', 'PUSMOV'),
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

                DBMS_OUTPUT.PUT_LINE('Reject As Forward'); 
                ----- Update Recovery Outstanding Adjustment & Review Count for 2nd Review : 2010.10.21   
                IF in_n2nd_rvw_flg = 'Y' THEN
                
                    ----UPDATE COPY Adjustment : 2010.10.21
                    IF v_office_level = 'R' AND v_adj_n2nd_rvw_sts_cd = 'R2' THEN  
                    
                    
    DBMS_OUTPUT.PUT_LINE('v_office_level:'||v_office_level||' v_adj_n2nd_rvw_sts_cd:'||v_adj_n2nd_rvw_sts_cd);
                        ----Before Adjustment Check : v_adj_app_chk= 'Y'
----                        IF v_adj_app_chk= 'N' THEN
                                    ----- Getting Adjustment Type Code, New Office Code ----- 
                                    SELECT C.n3pty_stl_tp_cd, A.ofc_cd, C.STL_RQST_OFC_CD ofc_cd,  A.ots_amt,
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
                                           TPB_ADJ_N2ND_RVW_HIS C, 
                                           TPB_OTS_GRP A  
                                     WHERE A.n3pty_no = B.n3pty_no 
                                       AND A.n3pty_no = C.n3pty_no  
                                       AND C.stl_sts_lst_flg = 'Y'  --- Active  Adjustment 
                                       AND B.ots_sts_lst_flg = 'Y'  --- Now Adjustment-Requested Status 
                                       AND B.ots_sts_cd IN ('O','R','J') 
                                       AND A.n3pty_delt_tp_cd = 'N' --- Not a auto-deleted thing(s)  
                                       AND A.n3pty_no = in_n3pty_no
                                       AND C.ADJ_N2ND_RVW_SEQ > 0
                                    ;   
        DBMS_OUTPUT.PUT_LINE('Before v_adj_app_chk= Y, v_stl_tp_cd:'||v_stl_tp_cd||' v_current_if_ofc_cd:'||v_current_if_ofc_cd||' v_new_if_ofc_cd:'||v_new_if_ofc_cd||' n_ots_amt_origin:'||n_ots_amt_origin||' n_ots_amt_gap:'||n_ots_amt_gap||' v_before_ots_sts_cd:'||v_before_ots_sts_cd);                     
                            
                                    ----- Update Outstanding Detail -----  
                                    UPDATE TPB_OTS_DTL A  
                                       SET ofc_cd = v_new_if_ofc_cd,  
                                           cfm_curr_cd = NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'),  
                                           cfm_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                                           ots_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                                           bal_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                                           rev_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt) 
                                                   - TPB_GET_INV_CURR_CHG_ROC_FNC(A.if_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.if_amt, A.cfm_dt),  
                                           adj_amt = NULL
                                           ,upd_usr_id = in_user_id,  
                                           upd_dt = SYSDATE  
                                     WHERE n3pty_no = in_n3pty_no   
                                       AND A.n3pty_delt_tp_cd = 'N'  
                                    ; 
        DBMS_OUTPUT.PUT_LINE(' Update Outstanding Detail['||SQL%ROWCOUNT||']');                              
                                    ----- Update Outstanding Group -----  
                                    UPDATE TPB_OTS_GRP A  
                                       SET ofc_cd = v_new_if_ofc_cd,  
                                           curr_cd = NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'),  
                                           ots_amt = ( SELECT SUM(ots_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                                           bal_amt = ( SELECT SUM(bal_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                                           rev_amt = ( SELECT SUM(rev_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                                           adj_amt = ( SELECT SUM(adj_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' )  
                                           ,upd_usr_id = in_user_id,  
                                           upd_dt = SYSDATE  
                                     WHERE n3pty_no = in_n3pty_no   
                                        -- Not a auto-deleted thing(s)  
                                       AND A.n3pty_delt_tp_cd = 'N'  
                                    ; 
        DBMS_OUTPUT.PUT_LINE(' Update Outstanding Group['||SQL%ROWCOUNT||']');                              
                                    ----- Update  Current Outstanding Adjustment ----- 
                                    UPDATE TPB_ADJ_STS c   
                                       SET stl_apro_ofc_cd = in_user_ofc_cd,  
                                           stl_apro_dt = SYSDATE,  
                                           stl_apro_usr_id = in_user_id,  
                                           stl_apro_rmk = in_stl_rmk,  
                                           stl_cpy_ofc_cd = in_stl_cpy_ofc_cd,  
                                           stl_cpy_dt = NVL2(in_stl_cpy_ofc_cd,SYSDATE,NULL),  
                                           stl_cpy_usr_id = NVL2(in_stl_cpy_ofc_cd,in_user_id,NULL)  
                                           ,upd_usr_id = in_user_id,  
                                           upd_dt = SYSDATE  
                                     WHERE n3pty_no = in_n3pty_no   
                                       -- Active  Adjustment + Only R.O.C  
                                       AND stl_sts_lst_flg = 'Y'  
                                       AND n3pty_stl_tp_cd = 'O'  
                                       AND ROWNUM = 1  
                                    ; 
        DBMS_OUTPUT.PUT_LINE(' Update Current Outstanding Adjustment['||SQL%ROWCOUNT||']');   
                                    --- ====== ADD OUTSTANDING GROUP STATUS -- O =========== 
                                    v_ots_sts_cd := 'O';  
                                    UPDATE tpb_ots_grp
                                    SET ots_sts_cd = v_ots_sts_cd
                                    WHERE n3pty_no = in_n3pty_no
                                    ;
        DBMS_OUTPUT.PUT_LINE(' OUTSTANDING GROUP STATUS -- O['||SQL%ROWCOUNT||']');                        
                                    --- ====== ADD OUTSTANDING DETAIL STATUS -- O =========== 
                                    UPDATE TPB_OTS_DTL_STS  
                                       SET ots_sts_cd = v_ots_sts_cd,
                                           upd_usr_id = in_user_id,  
                                           upd_dt = SYSDATE 
                                     WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no )  
                                     AND ots_sts_lst_flg = 'Y' 
                                    ; 
        DBMS_OUTPUT.PUT_LINE(' OUTSTANDING DETAIL STATUS -- O['||SQL%ROWCOUNT||']');          
                             

----                        END IF;                      
                    
                    
                        UPDATE TPB_ADJ_STS A
                           SET (N3PTY_STL_TP_CD
                                            ,STL_RQST_OFC_CD
                                            ,STL_APRO_OFC_CD
                                            ,STL_TO_CLT_CNG_OFC_CD
                                            ,STL_RJCT_OFC_CD
                                            ,STL_CLT_OFC_CNG_AMT
                                            ,STL_FWRD_OFC_CD
                                            ,STL_CPY_OFC_CD
                                            ,STL_RJCT_DT
                                            ,STL_RQST_DT
                                            ,STL_RJCT_USR_ID
                                            ,STL_RQST_USR_ID
                                            ,STL_APRO_DT
                                            ,STL_APRO_USR_ID
                                            ,STL_FWRD_DT
                                            ,STL_FWRD_USR_ID
                                            ,STL_CPY_DT
                                            ,STL_CPY_USR_ID
                                            ,STL_RQST_RMK
                                            ,STL_APRO_RMK
                                            ,STL_RJCT_RMK
                                            ,STL_STS_LST_FLG
                               ) = (SELECT  N3PTY_STL_TP_CD
                                            ,STL_RQST_OFC_CD
                                            ,STL_APRO_OFC_CD
                                            ,STL_TO_CLT_CNG_OFC_CD
                                            ,STL_RJCT_OFC_CD
                                            ,STL_CLT_OFC_CNG_AMT
                                            ,STL_FWRD_OFC_CD
                                            ,STL_CPY_OFC_CD
                                            ,STL_RJCT_DT
                                            ,STL_RQST_DT
                                            ,STL_RJCT_USR_ID
                                            ,STL_RQST_USR_ID
                                            ,STL_APRO_DT
                                            ,STL_APRO_USR_ID
                                            ,STL_FWRD_DT
                                            ,STL_FWRD_USR_ID
                                            ,STL_CPY_DT
                                            ,STL_CPY_USR_ID
                                            ,STL_RQST_RMK
                                            ,STL_APRO_RMK
                                            ,STL_RJCT_RMK
                                            ,STL_STS_LST_FLG
                                            FROM TPB_ADJ_N2ND_RVW_HIS
                                            WHERE N3PTY_NO =  A.N3PTY_NO
                                            AND ADJ_STS_SEQ = A.ADJ_STS_SEQ  
                                            AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록
                                            AND ROWNUM=1  )
                        WHERE n3pty_no = in_n3pty_no  
                        -- Active  Adjustment 
                        AND stl_sts_lst_flg = 'Y'  
                        AND ROWNUM = 1  
                        ; 
                        
                        ----Upate Review Count : 2010.10.21
                        UPDATE TPB_ADJ_N2ND_RVW_HIS
                           SET ADJ_N2ND_RVW_SEQ = ADJ_N2ND_RVW_SEQ + 1
                         WHERE (N3PTY_NO,ADJ_STS_SEQ) = (SELECT N3PTY_NO,ADJ_STS_SEQ 
                                                         FROM   TPB_ADJ_STS
                                                         WHERE n3pty_no = in_n3pty_no  
                                                         AND stl_sts_lst_flg = 'Y'  
                                                         AND ROWNUM = 1  )
                         AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록
                         AND ROWNUM=1 
                        ;
                        
--test
 select ots_sts_cd into v_ots_sts_cd 
 from   tpb_ots_grp
 where  n3pty_no = in_n3pty_no ;                      
 DBMS_OUTPUT.PUT_LINE('test [Current OTS_STS_CD]'||v_ots_sts_cd||'-->change to [R]');                          
                        
                        ----Update OTS_STS_CD 
                        /*TPB_OTS_DTL_STS
                        TPB_OTS_GRP
                        TPB_OTS_GRP_STS*/ 
                        UPDATE TPB_OTS_GRP  
                           SET OTS_STS_CD = 'R',  
                               upd_dt = SYSDATE 
                         WHERE n3pty_no = in_n3pty_no  
                         AND   OTS_STS_CD <> 'R'
                        ; 
                        ----Update OTS_STS_CD 
                        UPDATE TPB_OTS_DTL_STS  
                           SET OTS_STS_CD = 'R',  
                               upd_dt = SYSDATE 
                         WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no )  
                         AND   ots_sts_lst_flg = 'Y'
                         AND   OTS_STS_CD <> 'R'
                        ; 
                        ----Update OTS_STS_CD 
                        UPDATE TPB_OTS_GRP_STS  
                           SET OTS_STS_CD = 'R',  
                               upd_dt = SYSDATE 
                         WHERE n3pty_no = in_n3pty_no   
                         AND   ots_sts_lst_flg = 'Y'
                         AND   OTS_STS_CD <> 'R'
                        ; 
                                            
                    END IF;    
                        
                END IF;
 
                ----- Update Outstanding Adjustment (Forward) ----- 
/*
                   SET stl_fwrd_ofc_cd = DECODE(stl_fwrd_ofc_cd,  
                                          NULL, TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd), -- Reject As Forward ... to ROC-To RHQ  -- 2008-04-01 
                                          TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd), TPB_GET_HNDL_OFC_FNC('R',stl_rqst_ofc_cd), -- Reject As Forward ... to ROC-From RHQ  -- 2008-04-01 
                                          NULL  
                                         ),   
*/                
                -----------[CHM-201430873] [TPB] SELBB/TYOBB ROC 절차 변경
                IF v_roc_proc_flg = 'N' THEN
                    UPDATE TPB_ADJ_STS C  
                       SET stl_fwrd_ofc_cd = DECODE(stl_fwrd_ofc_cd,  
                                              NULL, (CASE WHEN TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd) IN ('SELIB','TYOIB') 
                                                  --  THEN DECODE(v_n3pty_expn_tp_cd, 'TES','SELCOT', 'TRS','SELCON', 'MNR','SELCOE', 'PUSMOV') --조직변경
                                                    THEN DECODE(v_n3pty_expn_tp_cd, 'TES','SELOPA', 'TRS','SELOPB', 'MNR','SELOPE', 'PUSMOV')
                                                    WHEN TPB_GET_HNDL_OFC_FNC('R',stl_rqst_ofc_cd) IN ('SELIB','TYOIB') 
                                                     AND TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd) NOT IN ('SELIB','TYOIB')
                                                    THEN TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd)
                                                    ELSE TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd) -- Reject As Forward ... to ROC-To RHQ  -- 2008-04-01  [CHM-2014082718]
                                                    END), -- Reject As Forward ... to ROC-To RHQ  -- 2008-04-01 
                                              TPB_GET_HNDL_OFC_FNC('R',stl_to_clt_cng_ofc_cd),
                                              (CASE WHEN TPB_GET_HNDL_OFC_FNC('R',stl_rqst_ofc_cd) IN ('SELIB','TYOIB')
                                                   -- THEN DECODE(v_n3pty_expn_tp_cd, 'TES','SELCOT', 'TRS','SELCON', 'MNR','SELCOE', 'PUSMOV') --조직변경
                                                    THEN DECODE(v_n3pty_expn_tp_cd, 'TES','SELOPA', 'TRS','SELOPB', 'MNR','SELOPE', 'PUSMOV')
                                                    ELSE TPB_GET_HNDL_OFC_FNC('R',stl_rqst_ofc_cd)
                                                    END), -- Reject As Forward ... to ROC-From RHQ  -- 2008-04-01 
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
                    
                            
                      ------- 2nd Review Log Edit for Rercovery Activity : 2010.10.21
                      IF in_n2nd_rvw_flg = 'Y' AND v_office_level = 'R' AND v_adj_n2nd_rvw_sts_cd = 'R2' THEN
                            SELECT ADJ_N2ND_RVW_SEQ INTO v_rvw_cnt 
                            FROM TPB_ADJ_N2ND_RVW_HIS 
                            WHERE (N3PTY_NO,ADJ_STS_SEQ) = (SELECT N3PTY_NO,ADJ_STS_SEQ 
                                                            FROM   TPB_ADJ_STS
                                                            WHERE n3pty_no = in_n3pty_no  
                                                            AND stl_sts_lst_flg = 'Y'  
                                                            AND ROWNUM = 1  )
                            AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록                               
                            AND ROWNUM=1 ;
                               
                            if    v_rvw_cnt = 1 then v_rvw_cnt_log:='st';
                            elsif v_rvw_cnt = 2 then v_rvw_cnt_log:='nd';
                            elsif v_rvw_cnt = 3 then v_rvw_cnt_log:='rd';
                            elsif v_rvw_cnt > 3 then v_rvw_cnt_log:='th';
                            end if;
                               
                            v_act_rmk := '['||v_rvw_cnt||v_rvw_cnt_log||' Review] '||'ROC is forwarded To '||v_next_stl_fwrd_ofc_cd||'.';
                      ELSIF v_stl_tp_cd = 'O' THEN
                            v_act_rmk := 'ROC is forwarded To '||v_next_stl_fwrd_ofc_cd||'.';
                      ELSE
                            v_act_rmk := 'Adjustment was Forwarded To '||v_next_stl_fwrd_ofc_cd||'.';
                      END IF; 
         
                      ------- Rercovery Activity -------- 
                      --v_act_rmk := 'Adjustment was Forwarded To '||v_next_stl_fwrd_ofc_cd||'.';  
                      TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);     
                      TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);                     
                    
                ELSE
                
                ----[CHM-201430873] [TPB] SELBB/TYOBB ROC 절차 변경
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
                           upd_dt = SYSDATE,
                           wrtf_rsn_cd = decode(v_stl_tp_cd,'W',nvl(in_wrtf_rsn_cd,''),wrtf_rsn_cd)  -- RHQ W/O reason   
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
                    IF v_stl_tp_cd = 'O' THEN
                        v_act_rmk := 'ROC is rejected by '||in_user_ofc_cd||'.';
                    END IF; 
                    
                    -- TPB_GEN_CLT_MSG_PRC( in_n3pty_no, 'A320', NULL, in_user_ofc_cd, NULL, in_user_ofc_cd, in_user_id ); 
                    --v_act_rmk := 'Adjustment rejected by '||in_user_ofc_cd||'.';  
                    TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
                    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id);                 
                
                END IF;                        
 
 
            ----- ELSE ( Reject ) ----- ---------------- 
            ELSE  
DBMS_OUTPUT.PUT_LINE('Reject'); 
             
                ----UPDATE Recovery Adjustment : 2010.10.21
                IF in_n2nd_rvw_flg = 'Y' 
                   AND ( (v_office_level = 'R' AND v_adj_n2nd_rvw_sts_cd = 'R2')    ----ROC-IN  RHQ  
                      OR (v_office_level = 'R' AND v_adj_n2nd_rvw_sts_cd = 'R3')    ----ROC-OUT RHQ
                      OR (v_office_level = 'H' AND v_adj_n2nd_rvw_sts_cd = 'R4')    ----HO
                   ) THEN 
DBMS_OUTPUT.PUT_LINE('v_office_level:'||v_office_level||' v_adj_n2nd_rvw_sts_cd:'||v_adj_n2nd_rvw_sts_cd);
                    ----Before Adjustment Check : v_adj_app_chk= 'Y'
----                    IF v_adj_app_chk= 'N' THEN
                            ----- Getting Adjustment Type Code, New Office Code ----- 
                            SELECT C.n3pty_stl_tp_cd, A.ofc_cd, C.STL_RQST_OFC_CD ofc_cd,  A.ots_amt,
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
                                   TPB_ADJ_N2ND_RVW_HIS C, 
                                   TPB_OTS_GRP A  
                             WHERE A.n3pty_no = B.n3pty_no 
                               AND A.n3pty_no = C.n3pty_no  
                               AND C.stl_sts_lst_flg = 'Y'  --- Active  Adjustment 
                               AND B.ots_sts_lst_flg = 'Y'  --- Now Adjustment-Requested Status 
                               AND B.ots_sts_cd IN ('O','R','J') 
                               AND A.n3pty_delt_tp_cd = 'N' --- Not a auto-deleted thing(s)  
                               AND A.n3pty_no = in_n3pty_no
                               AND C.ADJ_N2ND_RVW_SEQ > 0
                            ;   
DBMS_OUTPUT.PUT_LINE('Before v_adj_app_chk= Y, v_stl_tp_cd:'||v_stl_tp_cd||' v_current_if_ofc_cd:'||v_current_if_ofc_cd||' v_new_if_ofc_cd:'||v_new_if_ofc_cd||' n_ots_amt_origin:'||n_ots_amt_origin||' n_ots_amt_gap:'||n_ots_amt_gap||' v_before_ots_sts_cd:'||v_before_ots_sts_cd);                     
                    
                            ----- Update Outstanding Detail -----  
                            UPDATE TPB_OTS_DTL A  
                               SET ofc_cd = v_new_if_ofc_cd,  
                                   cfm_curr_cd = NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'),  
                                   cfm_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                                   ots_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                                   bal_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                                   rev_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt) 
                                           - TPB_GET_INV_CURR_CHG_ROC_FNC(A.if_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.if_amt, A.cfm_dt),  
                                   adj_amt = NULL
                                   ,upd_usr_id = in_user_id,  
                                   upd_dt = SYSDATE  
                             WHERE n3pty_no = in_n3pty_no   
                               AND A.n3pty_delt_tp_cd = 'N'  
                            ; 
DBMS_OUTPUT.PUT_LINE(' Update Outstanding Detail['||SQL%ROWCOUNT||']');                              
                            ----- Update Outstanding Group -----  
                            UPDATE TPB_OTS_GRP A  
                               SET ofc_cd = v_new_if_ofc_cd,  
                                   curr_cd = NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'),  
                                   ots_amt = ( SELECT SUM(ots_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                                   bal_amt = ( SELECT SUM(bal_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                                   rev_amt = ( SELECT SUM(rev_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                                   adj_amt = ( SELECT SUM(adj_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' )  
                                   ,upd_usr_id = in_user_id,  
                                   upd_dt = SYSDATE  
                             WHERE n3pty_no = in_n3pty_no   
                                -- Not a auto-deleted thing(s)  
                               AND A.n3pty_delt_tp_cd = 'N'  
                            ; 
DBMS_OUTPUT.PUT_LINE(' Update Outstanding Group['||SQL%ROWCOUNT||']');                              
                            ----- Update  Current Outstanding Adjustment ----- 
                            UPDATE TPB_ADJ_STS c   
                               SET stl_apro_ofc_cd = in_user_ofc_cd,  
                                   stl_apro_dt = SYSDATE,  
                                   stl_apro_usr_id = in_user_id,  
                                   stl_apro_rmk = in_stl_rmk,  
                                   stl_cpy_ofc_cd = in_stl_cpy_ofc_cd,  
                                   stl_cpy_dt = NVL2(in_stl_cpy_ofc_cd,SYSDATE,NULL),  
                                   stl_cpy_usr_id = NVL2(in_stl_cpy_ofc_cd,in_user_id,NULL)  
                                   ,upd_usr_id = in_user_id,  
                                   upd_dt = SYSDATE  
                             WHERE n3pty_no = in_n3pty_no   
                               -- Active  Adjustment + Only R.O.C  
                               AND stl_sts_lst_flg = 'Y'  
                               AND n3pty_stl_tp_cd = 'O'  
                               AND ROWNUM = 1  
                            ; 
DBMS_OUTPUT.PUT_LINE(' Update Current Outstanding Adjustment['||SQL%ROWCOUNT||']');   
                            --- ====== ADD OUTSTANDING GROUP STATUS -- O =========== 
                            v_ots_sts_cd := 'O';  
                            UPDATE tpb_ots_grp
                            SET ots_sts_cd = v_ots_sts_cd
                            WHERE n3pty_no = in_n3pty_no
                            ;
DBMS_OUTPUT.PUT_LINE(' OUTSTANDING GROUP STATUS -- O['||SQL%ROWCOUNT||']');                        
                            --- ====== ADD OUTSTANDING DETAIL STATUS -- O =========== 
                            UPDATE TPB_OTS_DTL_STS  
                               SET ots_sts_cd = v_ots_sts_cd,
                                   upd_usr_id = in_user_id,  
                                   upd_dt = SYSDATE 
                             WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no )  
                             AND ots_sts_lst_flg = 'Y' 
                            ; 
DBMS_OUTPUT.PUT_LINE(' OUTSTANDING DETAIL STATUS -- O['||SQL%ROWCOUNT||']');          
                             

----                    END IF;  
                
                   
                    --Recovery for 2nd Review
                    UPDATE TPB_ADJ_STS A
                       SET (N3PTY_STL_TP_CD
                                        ,STL_RQST_OFC_CD
                                        ,STL_APRO_OFC_CD
                                        ,STL_TO_CLT_CNG_OFC_CD
                                        ,STL_RJCT_OFC_CD
                                        ,STL_CLT_OFC_CNG_AMT
                                        ,STL_FWRD_OFC_CD
                                        ,STL_CPY_OFC_CD
                                        ,STL_RJCT_DT
                                        ,STL_RQST_DT
                                        ,STL_RJCT_USR_ID
                                        ,STL_RQST_USR_ID
                                        ,STL_APRO_DT
                                        ,STL_APRO_USR_ID
                                        ,STL_FWRD_DT
                                        ,STL_FWRD_USR_ID
                                        ,STL_CPY_DT
                                        ,STL_CPY_USR_ID
                                        ,STL_RQST_RMK
                                        ,STL_APRO_RMK
                                        ,STL_RJCT_RMK
                                        ,STL_STS_LST_FLG
                           ) = (SELECT  N3PTY_STL_TP_CD
                                        ,STL_RQST_OFC_CD
                                        ,STL_APRO_OFC_CD
                                        ,STL_TO_CLT_CNG_OFC_CD
                                        ,STL_RJCT_OFC_CD
                                        ,STL_CLT_OFC_CNG_AMT
                                        ,STL_FWRD_OFC_CD
                                        ,STL_CPY_OFC_CD
                                        ,STL_RJCT_DT
                                        ,STL_RQST_DT
                                        ,STL_RJCT_USR_ID
                                        ,STL_RQST_USR_ID
                                        ,STL_APRO_DT
                                        ,STL_APRO_USR_ID
                                        ,STL_FWRD_DT
                                        ,STL_FWRD_USR_ID
                                        ,STL_CPY_DT
                                        ,STL_CPY_USR_ID
                                        ,STL_RQST_RMK
                                        ,STL_APRO_RMK
                                        ,STL_RJCT_RMK
                                        ,STL_STS_LST_FLG
                                        FROM TPB_ADJ_N2ND_RVW_HIS
                                        WHERE N3PTY_NO =  A.N3PTY_NO
                                        AND ADJ_STS_SEQ = A.ADJ_STS_SEQ  
                                        AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록
                                        AND ROWNUM=1  )
                    WHERE n3pty_no = in_n3pty_no  
                    -- Active  Adjustment 
                    AND stl_sts_lst_flg = 'Y'  
                    AND ROWNUM = 1  
                    ; 
                    
                    
                    DBMS_OUTPUT.PUT_LINE('Recovery UPDATE Recovery Adjustment ['||SQL%ROWCOUNT||']');
                    
                    ----Upate Review Count : 2010.10.21
                    UPDATE TPB_ADJ_N2ND_RVW_HIS
                       SET ADJ_N2ND_RVW_SEQ = ADJ_N2ND_RVW_SEQ + 1
                     WHERE (N3PTY_NO,ADJ_STS_SEQ) = (SELECT N3PTY_NO,ADJ_STS_SEQ 
                                                     FROM   TPB_ADJ_STS
                                                     WHERE n3pty_no = in_n3pty_no  
                                                     AND stl_sts_lst_flg = 'Y'  
                                                     AND ROWNUM = 1  )
                       AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록                              
                       AND ROWNUM=1 
                    ;
                    DBMS_OUTPUT.PUT_LINE('Update Adjustment Count++ ['||SQL%ROWCOUNT||']');
                                        
                END IF;                    
             
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
                       upd_dt = SYSDATE,
                       wrtf_rsn_cd = decode(v_stl_tp_cd,'W',nvl(in_wrtf_rsn_cd,''),wrtf_rsn_cd)  -- RHQ W/O reason   
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
                IF in_n2nd_rvw_flg = 'Y' 
                   AND ( (v_office_level = 'R' AND v_adj_n2nd_rvw_sts_cd = 'R2')    ----ROC-IN  RHQ  
                      OR (v_office_level = 'R' AND v_adj_n2nd_rvw_sts_cd = 'R3')    ----ROC-OUT RHQ
                      OR (v_office_level = 'H' AND v_adj_n2nd_rvw_sts_cd = 'R4')    ----HO
                   ) THEN 
                   
                    SELECT ADJ_N2ND_RVW_SEQ INTO v_rvw_cnt 
                    FROM TPB_ADJ_N2ND_RVW_HIS 
                    WHERE (N3PTY_NO,ADJ_STS_SEQ) = (SELECT N3PTY_NO,ADJ_STS_SEQ 
                                                    FROM   TPB_ADJ_STS
                                                    WHERE n3pty_no = in_n3pty_no  
                                                    AND stl_sts_lst_flg = 'Y'  
                                                    AND ROWNUM = 1  )
                    AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록                                
                    AND ROWNUM=1 ;
                       
                    if    v_rvw_cnt = 1 then v_rvw_cnt_log:='st';
                    elsif v_rvw_cnt = 2 then v_rvw_cnt_log:='nd';
                    elsif v_rvw_cnt = 3 then v_rvw_cnt_log:='rd';
                    elsif v_rvw_cnt > 3 then v_rvw_cnt_log:='th';
                    end if;
                       
                    v_act_rmk := '['||v_rvw_cnt||v_rvw_cnt_log||' Review] '||'ROC is rejected by '||in_user_ofc_cd||'.';                  
                ELSIF v_stl_tp_cd = 'O' THEN
                    v_act_rmk := 'ROC is rejected by '||in_user_ofc_cd||'.';
                ELSIF v_stl_tp_cd = 'W' THEN
                    v_act_rmk := 'W/O is rejected by '||in_user_ofc_cd||'.';
                END IF; 
                
                -- TPB_GEN_CLT_MSG_PRC( in_n3pty_no, 'A320', NULL, in_user_ofc_cd, NULL, in_user_ofc_cd, in_user_id ); 
                --v_act_rmk := 'Adjustment rejected by '||in_user_ofc_cd||'.';  
                TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
                TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
 
 
                 
            END IF; ----- / Reject As Forward ------------- 
 
     
        --=== Action : Approval ===================================== 
        ELSIF ( in_action = 'E' ) THEN  
 
 
            ----- Approval As Forward ----- -------------------------- 
            IF v_proc_type = 'AR3' THEN  
                DBMS_OUTPUT.PUT_LINE('Approval As Forward');
                ----UPDATE Recovery Adjustment : 2010.10.21
                IF in_n2nd_rvw_flg = 'Y' 
                  AND (v_office_level = 'R' AND v_adj_n2nd_rvw_sts_cd = 'R3') THEN  
                  
                                    ----- Getting Adjustment Type Code, New Office Code ----- 
                                    SELECT C.n3pty_stl_tp_cd, A.ofc_cd, C.STL_RQST_OFC_CD ofc_cd,  A.ots_amt,
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
                                           TPB_ADJ_N2ND_RVW_HIS C, 
                                           TPB_OTS_GRP A  
                                     WHERE A.n3pty_no = B.n3pty_no 
                                       AND A.n3pty_no = C.n3pty_no  
                                       AND C.stl_sts_lst_flg = 'Y'  --- Active  Adjustment 
                                       AND B.ots_sts_lst_flg = 'Y'  --- Now Adjustment-Requested Status 
                                       AND B.ots_sts_cd IN ('O','R','J') 
                                       AND A.n3pty_delt_tp_cd = 'N' --- Not a auto-deleted thing(s)  
                                       AND A.n3pty_no = in_n3pty_no
                                       AND C.ADJ_N2ND_RVW_SEQ > 0
                                    ;   
        DBMS_OUTPUT.PUT_LINE('Before v_adj_app_chk= Y, v_stl_tp_cd:'||v_stl_tp_cd||' v_current_if_ofc_cd:'||v_current_if_ofc_cd||' v_new_if_ofc_cd:'||v_new_if_ofc_cd||' n_ots_amt_origin:'||n_ots_amt_origin||' n_ots_amt_gap:'||n_ots_amt_gap||' v_before_ots_sts_cd:'||v_before_ots_sts_cd);                     
                            
                                    ----- Update Outstanding Detail -----  
                                    UPDATE TPB_OTS_DTL A  
                                       SET ofc_cd = v_new_if_ofc_cd,  
                                           cfm_curr_cd = NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'),  
                                           cfm_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                                           ots_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                                           bal_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt), 
                                           rev_amt = TPB_GET_INV_CURR_CHG_ROC_FNC(A.cfm_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.cfm_amt, A.cfm_dt) 
                                                   - TPB_GET_INV_CURR_CHG_ROC_FNC(A.if_curr_cd, NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'), A.if_amt, A.cfm_dt),  
                                           adj_amt = NULL
                                           ,upd_usr_id = in_user_id,  
                                           upd_dt = SYSDATE  
                                     WHERE n3pty_no = in_n3pty_no   
                                       AND A.n3pty_delt_tp_cd = 'N'  
                                    ; 
        DBMS_OUTPUT.PUT_LINE(' Update Outstanding Detail['||SQL%ROWCOUNT||']');                              
                                    ----- Update Outstanding Group -----  
                                    UPDATE TPB_OTS_GRP A  
                                       SET ofc_cd = v_new_if_ofc_cd,  
                                           curr_cd = NVL(TPB_GET_OFC_BIL_CURR_CD_FNC(v_new_if_ofc_cd),'USD'),  
                                           ots_amt = ( SELECT SUM(ots_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                                           bal_amt = ( SELECT SUM(bal_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                                           rev_amt = ( SELECT SUM(rev_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' ),  
                                           adj_amt = ( SELECT SUM(adj_amt) FROM TPB_OTS_DTL K WHERE K.n3pty_no = a.n3pty_no AND n3pty_delt_tp_cd = 'N' )  
                                           ,upd_usr_id = in_user_id,  
                                           upd_dt = SYSDATE  
                                     WHERE n3pty_no = in_n3pty_no   
                                        -- Not a auto-deleted thing(s)  
                                       AND A.n3pty_delt_tp_cd = 'N'  
                                    ; 
        DBMS_OUTPUT.PUT_LINE(' Update Outstanding Group['||SQL%ROWCOUNT||']');                              
                                    ----- Update  Current Outstanding Adjustment ----- 
                                    UPDATE TPB_ADJ_STS c   
                                       SET stl_apro_ofc_cd = in_user_ofc_cd,  
                                           stl_apro_dt = SYSDATE,  
                                           stl_apro_usr_id = in_user_id,  
                                           stl_apro_rmk = in_stl_rmk,  
                                           stl_cpy_ofc_cd = in_stl_cpy_ofc_cd,  
                                           stl_cpy_dt = NVL2(in_stl_cpy_ofc_cd,SYSDATE,NULL),  
                                           stl_cpy_usr_id = NVL2(in_stl_cpy_ofc_cd,in_user_id,NULL)  
                                           ,upd_usr_id = in_user_id,  
                                           upd_dt = SYSDATE  
                                     WHERE n3pty_no = in_n3pty_no   
                                       -- Active  Adjustment + Only R.O.C  
                                       AND stl_sts_lst_flg = 'Y'  
                                       AND n3pty_stl_tp_cd = 'O'  
                                       AND ROWNUM = 1  
                                    ; 
        DBMS_OUTPUT.PUT_LINE(' Update Current Outstanding Adjustment['||SQL%ROWCOUNT||']');   
                                    --- ====== ADD OUTSTANDING GROUP STATUS -- O =========== 
                                    v_ots_sts_cd := 'O';  
                                    UPDATE tpb_ots_grp
                                    SET ots_sts_cd = v_ots_sts_cd
                                    WHERE n3pty_no = in_n3pty_no
                                    ;
        DBMS_OUTPUT.PUT_LINE(' OUTSTANDING GROUP STATUS -- O['||SQL%ROWCOUNT||']');                        
                                    --- ====== ADD OUTSTANDING DETAIL STATUS -- O =========== 
                                    UPDATE TPB_OTS_DTL_STS  
                                       SET ots_sts_cd = v_ots_sts_cd,
                                           upd_usr_id = in_user_id,  
                                           upd_dt = SYSDATE 
                                     WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no )  
                                     AND ots_sts_lst_flg = 'Y' 
                                    ; 
        DBMS_OUTPUT.PUT_LINE(' OUTSTANDING DETAIL STATUS -- O['||SQL%ROWCOUNT||']');          
                  
                  
                  
                    UPDATE TPB_ADJ_STS A
                       SET (N3PTY_STL_TP_CD
                                        ,STL_RQST_OFC_CD
                                        ,STL_APRO_OFC_CD
                                        ,STL_TO_CLT_CNG_OFC_CD
                                        ,STL_RJCT_OFC_CD
                                        ,STL_CLT_OFC_CNG_AMT
                                        ,STL_FWRD_OFC_CD
                                        ,STL_CPY_OFC_CD
                                        ,STL_RJCT_DT
                                        ,STL_RQST_DT
                                        ,STL_RJCT_USR_ID
                                        ,STL_RQST_USR_ID
                                        ,STL_APRO_DT
                                        ,STL_APRO_USR_ID
                                        ,STL_FWRD_DT
                                        ,STL_FWRD_USR_ID
                                        ,STL_CPY_DT
                                        ,STL_CPY_USR_ID
                                        ,STL_RQST_RMK
                                        ,STL_APRO_RMK
                                        ,STL_RJCT_RMK
                                        ,STL_STS_LST_FLG
                           ) = (SELECT  N3PTY_STL_TP_CD
                                        ,STL_RQST_OFC_CD
                                        ,STL_APRO_OFC_CD
                                        ,STL_TO_CLT_CNG_OFC_CD
                                        ,STL_RJCT_OFC_CD
                                        ,STL_CLT_OFC_CNG_AMT
                                        ,STL_FWRD_OFC_CD
                                        ,STL_CPY_OFC_CD
                                        ,STL_RJCT_DT
                                        ,STL_RQST_DT
                                        ,STL_RJCT_USR_ID
                                        ,STL_RQST_USR_ID
                                        ,STL_APRO_DT
                                        ,STL_APRO_USR_ID
                                        ,STL_FWRD_DT
                                        ,STL_FWRD_USR_ID
                                        ,STL_CPY_DT
                                        ,STL_CPY_USR_ID
                                        ,STL_RQST_RMK
                                        ,STL_APRO_RMK
                                        ,STL_RJCT_RMK
                                        ,STL_STS_LST_FLG
                                        FROM TPB_ADJ_N2ND_RVW_HIS
                                        WHERE N3PTY_NO =  A.N3PTY_NO
                                        AND ADJ_STS_SEQ = A.ADJ_STS_SEQ
                                        AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록  
                                        AND ROWNUM=1  )
                    WHERE n3pty_no = in_n3pty_no  
                    -- Active  Adjustment 
                    AND stl_sts_lst_flg = 'Y'  
                    AND ROWNUM = 1  
                    ; 
                    
                    ----Upate Review Count : 2010.10.21
                    UPDATE TPB_ADJ_N2ND_RVW_HIS
                       SET ADJ_N2ND_RVW_SEQ = ADJ_N2ND_RVW_SEQ + 1
                     WHERE (N3PTY_NO,ADJ_STS_SEQ) = (SELECT N3PTY_NO,ADJ_STS_SEQ 
                                                     FROM   TPB_ADJ_STS
                                                     WHERE n3pty_no = in_n3pty_no  
                                                     AND stl_sts_lst_flg = 'Y'  
                                                     AND ROWNUM = 1  )
                       AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록                              
                       AND ROWNUM=1 
                    ;
                    
                        ----Update OTS_STS_CD 
                        /*TPB_OTS_DTL_STS
                        TPB_OTS_GRP
                        TPB_OTS_GRP_STS*/ 
                        UPDATE TPB_OTS_GRP  
                           SET OTS_STS_CD = 'R',  
                               upd_dt = SYSDATE 
                         WHERE n3pty_no = in_n3pty_no  
                         AND   OTS_STS_CD <> 'R'
                        ; 
                        ----Update OTS_STS_CD 
                        UPDATE TPB_OTS_DTL_STS  
                           SET OTS_STS_CD = 'R',  
                               upd_dt = SYSDATE 
                         WHERE ots_dtl_seq IN ( SELECT ots_dtl_seq FROM TPB_OTS_DTL WHERE n3pty_no = in_n3pty_no )  
                         AND   ots_sts_lst_flg = 'Y'
                         AND   OTS_STS_CD <> 'R'
                        ; 
                        ----Update OTS_STS_CD 
                        UPDATE TPB_OTS_GRP_STS  
                           SET OTS_STS_CD = 'R',  
                               upd_dt = SYSDATE 
                         WHERE n3pty_no = in_n3pty_no   
                         AND   ots_sts_lst_flg = 'Y'
                         AND   OTS_STS_CD <> 'R'
                        ; 
                                        
                END IF;           
                                
 
                ----- Update Outstanding Adjustment (Forward) ----- 
                UPDATE TPB_ADJ_STS C  
                   SET stl_fwrd_ofc_cd = NVL2( stl_fwrd_ofc_cd,  
                                         --DECODE(v_n3pty_expn_tp_cd, 'TES','SELCOL', 'TRS','SELCOL', 'SELCOE'),      [CHM-201220985]
                                        -- DECODE(v_n3pty_expn_tp_cd, 'TES','SELCOT', 'TRS','SELCON', 'MNR','SELCOE', 'PUSMOV'), --조직변경
                                         DECODE(v_n3pty_expn_tp_cd, 'TES','SELOPA', 'TRS','SELOPB', 'MNR','SELOPE', 'PUSMOV'),
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
                IF in_n2nd_rvw_flg = 'Y' 
                  AND (v_office_level = 'R' AND v_adj_n2nd_rvw_sts_cd = 'R3') THEN  
                      
                    SELECT ADJ_N2ND_RVW_SEQ INTO v_rvw_cnt 
                    FROM TPB_ADJ_N2ND_RVW_HIS 
                    WHERE (N3PTY_NO,ADJ_STS_SEQ) = (SELECT N3PTY_NO,ADJ_STS_SEQ 
                                                    FROM   TPB_ADJ_STS
                                                    WHERE n3pty_no = in_n3pty_no  
                                                    AND stl_sts_lst_flg = 'Y'  
                                                    AND ROWNUM = 1  )
                    AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록                                
                    AND ROWNUM=1 ;
                       
                    if    v_rvw_cnt = 1 then v_rvw_cnt_log:='st';
                    elsif v_rvw_cnt = 2 then v_rvw_cnt_log:='nd';
                    elsif v_rvw_cnt = 3 then v_rvw_cnt_log:='rd';
                    elsif v_rvw_cnt > 3 then v_rvw_cnt_log:='th';
                    end if;
                       
                    v_act_rmk := '['||v_rvw_cnt||v_rvw_cnt_log||' Review] '||'ROC is forwarded To '||v_next_stl_fwrd_ofc_cd||'.';
                ELSIF v_stl_tp_cd = 'O' THEN
                    v_act_rmk := 'ROC is forwarded To '||v_next_stl_fwrd_ofc_cd||'.'; 
                ELSE 
                    v_act_rmk := 'Adjustment forwarded To '||v_next_stl_fwrd_ofc_cd||'.';              
                END IF; 
                
                --v_act_rmk := 'Adjustment forwarded To '||v_next_stl_fwrd_ofc_cd||'.';  
                TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
                TPB_ADD_OTS_DTL_RCVR_ACT_PRC('M',in_n3pty_no,'',v_act_rmk,'A','',in_user_ofc_cd,in_user_id); 
                

 
            ----- ELSE ( Approval ) ----- ---------------- 
            ELSE  
                DBMS_OUTPUT.PUT_LINE('Approval');
                
---- [CHM-201430873] [TPB] SELBB/TYOBB ROC 절차 변경 : v_roc_proc_flg = 'Y' & in_action = 'E'
---- TPB_ADJ_STS table만 reject 내용 업데이트
                   
                ---- 2010.10.21: 2nd Review인 경우 ots_sts_cd IN ('R','O','J') 아닌 경우 ots_sts_cd = 'R'.
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
                   AND B.ots_sts_cd IN ('R',decode(in_n2nd_rvw_flg,'Y','O','R'),decode(in_n2nd_rvw_flg,'Y','J','R'))  
                   AND A.n3pty_delt_tp_cd = 'N' --- Not a auto-deleted thing(s)  
                   AND A.n3pty_no = in_n3pty_no  
                ;                
                
         
                ----- Adjustment Type : General ----- 
                IF ( v_stl_tp_cd IS NOT NULL AND v_stl_tp_cd != 'O' ) THEN  
                
 DBMS_OUTPUT.PUT_LINE('Adjustment Type : General');             
 
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
                           upd_dt = SYSDATE,
                           wrtf_rsn_cd = decode(v_stl_tp_cd,'W',nvl(in_wrtf_rsn_cd,''),wrtf_rsn_cd)  -- RHQ W/O reason   
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
---- [CHM-201430873] [TPB] SELBB/TYOBB ROC 절차 변경 : v_roc_proc_flg = 'Y' & in_action = 'E'                
                    DBMS_OUTPUT.PUT_LINE('Approval-R.O.C');
                    ----UPDATE Recovery Adjustment : 2010.10.21
                    IF in_n2nd_rvw_flg = 'Y' 
                      AND ((v_office_level = 'R' AND v_adj_n2nd_rvw_sts_cd = 'R2') 
                        OR (v_office_level = 'H' AND v_adj_n2nd_rvw_sts_cd = 'R4') 
                          ) THEN  
                        UPDATE TPB_ADJ_STS A
                           SET (N3PTY_STL_TP_CD
                                            ,STL_RQST_OFC_CD
                                            ,STL_APRO_OFC_CD
                                            ,STL_TO_CLT_CNG_OFC_CD
                                            ,STL_RJCT_OFC_CD
                                            ,STL_CLT_OFC_CNG_AMT
                                            ,STL_FWRD_OFC_CD
                                            ,STL_CPY_OFC_CD
                                            ,STL_RJCT_DT
                                            ,STL_RQST_DT
                                            ,STL_RJCT_USR_ID
                                            ,STL_RQST_USR_ID
                                            ,STL_APRO_DT
                                            ,STL_APRO_USR_ID
                                            ,STL_FWRD_DT
                                            ,STL_FWRD_USR_ID
                                            ,STL_CPY_DT
                                            ,STL_CPY_USR_ID
                                            ,STL_RQST_RMK
                                            ,STL_APRO_RMK
                                            ,STL_RJCT_RMK
                                            ,STL_STS_LST_FLG
                               ) = (SELECT  N3PTY_STL_TP_CD
                                            ,STL_RQST_OFC_CD
                                            ,STL_APRO_OFC_CD
                                            ,STL_TO_CLT_CNG_OFC_CD
                                            ,STL_RJCT_OFC_CD
                                            ,STL_CLT_OFC_CNG_AMT
                                            ,STL_FWRD_OFC_CD
                                            ,STL_CPY_OFC_CD
                                            ,STL_RJCT_DT
                                            ,STL_RQST_DT
                                            ,STL_RJCT_USR_ID
                                            ,STL_RQST_USR_ID
                                            ,STL_APRO_DT
                                            ,STL_APRO_USR_ID
                                            ,STL_FWRD_DT
                                            ,STL_FWRD_USR_ID
                                            ,STL_CPY_DT
                                            ,STL_CPY_USR_ID
                                            ,STL_RQST_RMK
                                            ,STL_APRO_RMK
                                            ,STL_RJCT_RMK
                                            ,STL_STS_LST_FLG
                                            FROM TPB_ADJ_N2ND_RVW_HIS
                                            WHERE N3PTY_NO =  A.N3PTY_NO
                                            AND ADJ_STS_SEQ = A.ADJ_STS_SEQ
                                            AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록  
                                            AND ROWNUM=1  )
                        WHERE n3pty_no = in_n3pty_no  
                        -- Active  Adjustment 
                        AND stl_sts_lst_flg = 'Y'  
                        AND ROWNUM = 1  
                        ; 
                        
                        ----Upate Review Count : 2010.10.21
                        UPDATE TPB_ADJ_N2ND_RVW_HIS
                           SET ADJ_N2ND_RVW_SEQ = ADJ_N2ND_RVW_SEQ + 1
                         WHERE (N3PTY_NO,ADJ_STS_SEQ) = (SELECT N3PTY_NO,ADJ_STS_SEQ 
                                                         FROM   TPB_ADJ_STS
                                                         WHERE n3pty_no = in_n3pty_no  
                                                         AND stl_sts_lst_flg = 'Y'  
                                                         AND ROWNUM = 1  )
                           AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록                              
                           AND ROWNUM=1 
                        ;
                                            
                    END IF;           
 
 ----[CHM-201430873] [TPB] SELBB/TYOBB ROC 절차 변경 : v_roc_proc_flg = 'Y' & in_action = 'E'
                    IF v_roc_proc_flg = 'N' THEN
 
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
                    
                    ELSE 
                    
                        ----- Update  Current Outstanding Adjustment ----- 
                        UPDATE TPB_ADJ_STS c   
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
                           -- Active  Adjustment + Only R.O.C  
                           AND stl_sts_lst_flg = 'Y'  
                           AND n3pty_stl_tp_cd = 'O'  
                           AND ROWNUM = 1  
                        ;                     
                    
                    END IF; 
                     
            
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
 ----[CHM-201430873] [TPB] SELBB/TYOBB ROC 절차 변경 : v_roc_proc_flg = 'Y' & in_action = 'E'
                    IF v_roc_proc_flg = 'N' THEN
					   v_act_rmk := '[Responsible Office Change] approved by '||in_user_ofc_cd||'.'; 
					ELSE
					   v_act_rmk := '[Responsible Office Change] rejected by '||in_user_ofc_cd||'.'; 
					END IF;
					   
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
                     
 
                    --- ====== ADD Recovery Activity -- O =========== 
                    IF in_n2nd_rvw_flg = 'Y' 
                      AND ((v_office_level = 'R' AND v_adj_n2nd_rvw_sts_cd = 'R2') 
                        OR (v_office_level = 'H' AND v_adj_n2nd_rvw_sts_cd = 'R4') 
                          ) THEN  
                          
                        SELECT ADJ_N2ND_RVW_SEQ INTO v_rvw_cnt 
                        FROM TPB_ADJ_N2ND_RVW_HIS 
                        WHERE (N3PTY_NO,ADJ_STS_SEQ) = (SELECT N3PTY_NO,ADJ_STS_SEQ 
                                                        FROM   TPB_ADJ_STS
                                                        WHERE n3pty_no = in_n3pty_no  
                                                        AND stl_sts_lst_flg = 'Y'  
                                                        AND ROWNUM = 1  )
                        AND ADJ_N2ND_RVW_STS_CD = v_adj_n2nd_rvw_sts_cd    --자기가 한 결정만 재검토가 가능토록                                
                        AND ROWNUM=1 ;
                           
                        if    v_rvw_cnt = 1 then v_rvw_cnt_log:='st';
                        elsif v_rvw_cnt = 2 then v_rvw_cnt_log:='nd';
                        elsif v_rvw_cnt = 3 then v_rvw_cnt_log:='rd';
                        elsif v_rvw_cnt > 3 then v_rvw_cnt_log:='th';
                        end if;
                           
                        v_act_rmk := '['||v_rvw_cnt||v_rvw_cnt_log||' Review] '||'Responsible Office was changed to '||v_new_if_ofc_cd||'.';                  
                    ELSE 
                        v_act_rmk := 'Responsible Office was changed to '||v_new_if_ofc_cd||'.';              
                    END IF; 
                    --v_act_rmk := 'Responsible Office was changed to '||v_new_if_ofc_cd||'.';  
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
 
         ----Update 1st Review FOR 2ND Review 
        UPDATE TPB_ADJ_N2ND_RVW_HIS
           SET ADJ_N2ND_RVW_SEQ=1
         WHERE (N3PTY_NO,ADJ_STS_SEQ) = (SELECT N3PTY_NO,ADJ_STS_SEQ 
                                        FROM   TPB_ADJ_STS
                                        WHERE n3pty_no = in_n3pty_no  
                                        AND stl_sts_lst_flg = 'Y'  
                                        AND ROWNUM = 1  )
         AND ADJ_N2ND_RVW_STS_CD = DECODE(in_n2nd_rvw_flg,'Y',v_adj_n2nd_rvw_sts_cd,ADJ_N2ND_RVW_STS_CD)    --WHEN Current 1st Review  
         AND ADJ_N2ND_RVW_SEQ=0; 
         
         DBMS_OUTPUT.PUT_LINE('Update 1st Review FOR 2ND Review ['||SQL%ROWCOUNT||']');     
         


        /*----Adjust Satatus Detail Code 추가  : v_office_level
        <STL_APRO_OFC_CD>
        CD02799	T1	ROC accepted by Office	
        CD02799	T2	ROC accepted by RHQ	
        CD02799	T3	ROC accepted by HO	    
        CD02799	T4	W/O approved by RHQ	    N3PTY_STL_TP_CD='W'

        <STL_RJCT_OFC_CD>
        CD02799	J1	ROC rejected by Office	
        CD02799	J2	ROC rejected by RHQ	
        CD02799	J3	ROC rejected by HO	    
        CD02799	J4	W/O rejected by RHQ	    N3PTY_STL_TP_CD='W'

        <STL_FWRD_OFC_CD>
        CD02799	R1	ROC forwarded to Office	
        CD02799	R2	ROC forwarded to RHQ	
        CD02799	R3	ROC forwarded to HO	    */
        
        SELECT DECODE(STL_APRO_OFC_CD,NULL,DECODE(STL_RJCT_OFC_CD,NULL,DECODE(STL_FWRD_OFC_CD,NULL,'Requested','Forwarded'),'Rejected'),'Accepted') ots_sts_cd_val
               , N3PTY_STL_TP_CD tp_cd
               , DECODE(STL_APRO_OFC_CD,NULL,DECODE(STL_RJCT_OFC_CD,NULL,DECODE(STL_FWRD_OFC_CD,NULL,STL_RQST_OFC_CD,STL_FWRD_OFC_CD),STL_RJCT_OFC_CD),STL_APRO_OFC_CD) rofc_cd
               INTO v_ots_sts_cd_val, v_tp_cd, v_rofc_cd
        FROM TPB_ADJ_STS S
        WHERE N3PTY_NO = in_n3pty_no AND STL_STS_LST_FLG ='Y';
        
        --- Getting Office Level  
        SELECT office_level  --, rhq_cd  
          INTO v_office_level  --, v_rofc_cd  
          FROM (  
                ----- HO ----- 
                SELECT 'H' office_level, ofc_cd, rhq_cd   
                  FROM TPB_HNDL_OFC  
                 WHERE 1=1 
                   AND n3pty_ofc_tp_cd IN ('H')  
                   AND delt_flg = 'N'  
                   AND ofc_cd = v_rofc_cd   
                -----     
                UNION 
                ----- RHQ ----- 
                SELECT 'R' office_level, ofc_cd, rhq_cd   
                  FROM TPB_HNDL_OFC  
                 WHERE 1=1 
                   AND n3pty_ofc_tp_cd IN ('S')  
                   AND delt_flg = 'N'  
                   AND ofc_cd = v_rofc_cd   
                -----     
                UNION 
                ----- GO ----- 
                SELECT 'G' office_level, ofc_cd, rhq_cd   
                  FROM TPB_HNDL_OFC  
                 WHERE 1=1 
                   AND n3pty_ofc_tp_cd IN ('T')  
                   AND delt_flg = 'N'  
                   AND ofc_cd = v_rofc_cd   
                ) A 
         WHERE 1=1      
           AND ROWNUM = 1 
        ;        
        
        if (v_ots_sts_cd_val='Accepted') then
            UPDATE TPB_OTS_GRP
               SET OTS_STS_DTL_CD = DECODE(v_tp_cd,'W','T4',DECODE(v_office_level,'G','T1','R','T2','H','T3'))
             WHERE N3PTY_NO = in_n3pty_no;        
        elsif (v_ots_sts_cd_val='Rejected') then
            UPDATE TPB_OTS_GRP
               SET OTS_STS_DTL_CD = DECODE(v_tp_cd,'W','J4',DECODE(v_office_level,'G','J1','R','J2','H','J3'))
             WHERE N3PTY_NO = in_n3pty_no;        
        elsif (v_ots_sts_cd_val='Forwarded') then
            UPDATE TPB_OTS_GRP
               SET OTS_STS_DTL_CD = DECODE(v_office_level,'G','R1','R','R2','H','R3')
             WHERE N3PTY_NO = in_n3pty_no;             
        end if;
        
                    
     
    END IF;  
    --///// Current Status Check ///////////////////////////////// 
    
    
 

EXCEPTION 
    WHEN OTHERS THEN 
--        v_lst_no := NULL; 
        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  
      
 
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
        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  
 
END 
 
-- ===== End of Function ================================== 
; 
 
 
-- ===============================================================================================
 
END 
;