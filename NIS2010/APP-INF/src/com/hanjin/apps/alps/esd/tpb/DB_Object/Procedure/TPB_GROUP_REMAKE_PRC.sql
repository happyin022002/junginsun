CREATE OR REPLACE PROCEDURE NISADM.TPB_GROUP_REMAKE_PRC

/*******************************************************************************
1. Object Name      : TPB_GROUP_REMAKE_PRC
2. Version          : 1.1
3. Create Date      : 2008-10-28
4. Sub System       : Third Party Billing
5. Author           : Sun, Choi
6. Description      : TPB Group Remaking
                      -------------------------------------------------------
                      DECLARE 

					  BEGIN 
					      TPB_GROUP_REMAKE_PRC(,,,,) ;
					  END; 
                      -------------------------------------------------------
7. Revision History : 2008.09.22  Kim Jin-seung    1.0  Created
                      2009.09.02  Sun CHOI         1.1  ALPS Migration
*******************************************************************************/

-- ===== Arguments ========================================
( 
    in_ots_dtl_seq   IN VARCHAR2   --- key
    ,in_n3pty_no     IN VARCHAR2   --- 
    ,in_user_ofc_cd  IN VARCHAR2
    ,in_user_id      IN VARCHAR2   --- user id
) 
authid CURRENT_USER
IS 

-- ===== DECLARE ==========================================

    v_n3pty_no_old          VARCHAR2(14); 
    v_n3pty_no_dp_seq_old   NUMBER(4); 

-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

    --- Initiate varibles 
    
    --===== GET old TPB No. Display Seq 
    SELECT MAX(A.n3pty_no), MAX(A.n3pty_no_dp_seq) 
      INTO v_n3pty_no_old, v_n3pty_no_dp_seq_old 
      FROM TPB_OTS_DTL A, 
           TPB_OTS_GRP B, 
           TPB_OTS_GRP_STS C 
     WHERE A.ots_dtl_seq = TO_CHAR(in_ots_dtl_seq) -- in_ots_dtl_seq
       AND A.n3pty_no = B.n3pty_no 
       AND B.n3pty_no = C.n3pty_no 
       AND C.ots_sts_lst_flg = 'Y'
       AND C.ots_sts_cd IN ('O','M','J') 
       AND A.n3pty_delt_tp_cd IN ('N','S') 
       AND B.n3pty_delt_tp_cd = 'N'
    ; 
    
    ----------- 현재 작업이 유효한 상태인 경우로 판단 ---------------
    IF ( v_n3pty_no_old IS NOT NULL ) THEN 

        ----------- in_n3pty_no IS VALID 
        IF ( in_n3pty_no IS NOT NULL AND LENGTHB(in_n3pty_no)=14 ) THEN 
        
            --===== UPDATE TPB_OTS_DTL - CURRENT : NEW TPB NO, NEW N3PTY_NO_DP_SEQ =====
            UPDATE TPB_OTS_DTL A
               SET n3pty_no = in_n3pty_no,  -- in_n3pty_no
                   n3pty_no_dp_seq = ( SELECT NVL(MAX(n3pty_no_dp_seq),0) + 1 
                                         FROM TPB_OTS_DTL K
                                        WHERE n3pty_no = in_n3pty_no -- in_n3pty_no
                                          AND ots_dtl_seq != TO_CHAR(in_ots_dtl_seq)
                                      )
             WHERE ots_dtl_seq = TO_CHAR(in_ots_dtl_seq) -- in_ots_dtl_seq
               AND n3pty_delt_tp_cd IN ('N','S') 
            ; 
            
            --===== UPDATE TPB_OTS_DTL - OLD TPB NO : RESORT N3PTY_NO_DP_SEQ =====
            UPDATE TPB_OTS_DTL 
               SET n3pty_no_dp_seq = n3pty_no_dp_seq - 1 
             WHERE n3pty_no = v_n3pty_no_old -- v_n3pty_no_old 
               AND n3pty_no_dp_seq > v_n3pty_no_dp_seq_old -- v_n3pty_no_dp_seq_old 
               AND n3pty_delt_tp_cd IN ('N','S')
            ; 
            
            --===== UPDATE TPB_OTS_GRP : NEW TPB NO =====
            UPDATE TPB_OTS_GRP B
               SET ( n3pty_delt_tp_cd, n3pty_expn_tp_cd, n3pty_bil_tp_cd, curr_cd, 
                     ots_amt, inv_amt, clt_amt, 
                     adj_amt, bal_amt, rev_amt  
                   ) = ( SELECT DECODE( COUNT(0), 0, 'D', 'N'), 
                                DECODE( COUNT(DISTINCT K.n3pty_expn_tp_cd), 0, NULL, 1, MAX(K.n3pty_expn_tp_cd), 'MIX') , 
                                DECODE( COUNT(DISTINCT K.n3pty_bil_tp_cd), 0, NULL, 1, MAX(K.n3pty_bil_tp_cd), 'MX') , 
                                DECODE( COUNT(DISTINCT K.cfm_curr_cd), 0, NULL, 1, MAX(K.cfm_curr_cd), NULL), 
                                SUM(K.ots_amt) AS ots_amt, 
                                SUM(K.inv_amt) AS inv_amt, 
                                SUM(K.clt_amt) AS clt_amt, 
                                SUM(K.adj_amt) AS adj_amt, 
                                SUM(K.bal_amt) AS bal_amt, 
                                SUM(K.rev_amt) AS rev_amt 
                           FROM TPB_OTS_DTL K
                          WHERE 1=1 
                            AND n3pty_no = in_n3pty_no -- v_n3pty_no_old
                            AND n3pty_delt_tp_cd IN ('N','S')
                        ), 
                   upd_dt = SYSDATE, 
                   upd_usr_id = in_user_id 
             WHERE 1=1 
               AND n3pty_no = in_n3pty_no -- in_n3pty_no
               AND n3pty_delt_tp_cd = 'N'
            ;
        
            --===== UPDATE TPB_OTS_GRP : OLD TPB NO =====
            UPDATE TPB_OTS_GRP B
               SET ( n3pty_delt_tp_cd, n3pty_expn_tp_cd, n3pty_bil_tp_cd, curr_cd, 
                    ots_amt, inv_amt, clt_amt, 
                    adj_amt, bal_amt, rev_amt  
                   ) = ( SELECT DECODE( COUNT(0), 0, 'D', 'N'), 
                                DECODE( COUNT(DISTINCT K.n3pty_expn_tp_cd), 0, NULL, 1, MAX(K.n3pty_expn_tp_cd), 'MIX') , 
                                DECODE( COUNT(DISTINCT K.n3pty_bil_tp_cd), 0, NULL, 1, MAX(K.n3pty_bil_tp_cd), 'MX') , 
                                DECODE( COUNT(DISTINCT K.cfm_curr_cd), 0, NULL, 1, MAX(K.cfm_curr_cd), NULL), 
                                SUM(K.ots_amt) AS ots_amt, 
                                SUM(K.inv_amt) AS inv_amt, 
                                SUM(K.clt_amt) AS clt_amt, 
                                SUM(K.adj_amt) AS adj_amt, 
                                SUM(K.bal_amt) AS bal_amt, 
                                SUM(K.rev_amt) AS rev_amt 
                           FROM TPB_OTS_DTL K
                          WHERE 1=1 
                            AND n3pty_no = v_n3pty_no_old -- v_n3pty_no_old
                            AND n3pty_delt_tp_cd IN ('N','S')
                        ), 
                   upd_dt = SYSDATE, 
                   upd_usr_id = in_user_id 
              WHERE 1=1 
                AND n3pty_no = v_n3pty_no_old -- v_n3pty_no_old
                AND n3pty_delt_tp_cd = 'N'
            ;
        
            --===== ADD STATUS AND RECOVERY ACTIVITY =====
            -- TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'D', v_user_id); 
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',in_ots_dtl_seq,'','TPB Group Remaking : '||v_n3pty_no_old||' => '||in_n3pty_no,'A','',in_user_ofc_cd,in_user_id);
            -- TPB_ADD_OTS_GRP_STS_PRC(v_n3pty_no, 'O', v_user_id); 
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no_old,'','TPB Group Remaking : A detail item was moved to '||in_n3pty_no,'A','',in_user_ofc_cd,in_user_id);
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(in_n3pty_no,'','TPB Group Remaking : A detail item was added from '||v_n3pty_no_old,'A','',in_user_ofc_cd,in_user_id);
    
    
        ----------- in_n3pty_no IS NOT VALID 
        ELSE 


            --===== UPDATE TPB_OTS_DTL - CURRENT : NEW TPB NO, NEW N3PTY_NO_DP_SEQ =====
            UPDATE TPB_OTS_DTL A
               SET n3pty_no = NULL,  -- in_n3pty_no
                   n3pty_no_dp_seq = NULL, 
                   cfm_amt = NULL, 
                   cfm_rmk = NULL, 
                   ots_amt = NULL, 
                   inv_amt = NULL, 
                   clt_amt = NULL, 
                   adj_amt = NULL, 
                   bal_amt = NULL, 
                   rev_amt = NULL, 
                   cfm_dt = NULL, 
                   n3pty_cfm_cd = 'I', -- Initially interfaced
                   cfm_ofc_cd = NULL, 
                   cfm_usr_id = NULL, 
                   cfm_curr_cd = NULL, 
                   upd_dt = SYSDATE, 
                   upd_usr_id = in_user_id 
             WHERE ots_dtl_seq = TO_CHAR(in_ots_dtl_seq) -- in_ots_dtl_seq
               AND n3pty_delt_tp_cd IN ('N','S')
            ; 
            
            --===== UPDATE TPB_OTS_DTL - OLD TPB NO : RESORT N3PTY_NO_DP_SEQ =====
            UPDATE TPB_OTS_DTL 
               SET n3pty_no_dp_seq = n3pty_no_dp_seq - 1 
             WHERE n3pty_no = v_n3pty_no_old -- v_n3pty_no_old 
               AND n3pty_no_dp_seq > v_n3pty_no_dp_seq_old -- v_n3pty_no_dp_seq_old 
               AND n3pty_delt_tp_cd IN ('N','S')
            ; 
            
            --===== UPDATE TPB_OTS_GRP : OLD TPB NO =====
            UPDATE TPB_OTS_GRP B
               SET ( n3pty_delt_tp_cd, n3pty_expn_tp_cd, n3pty_bil_tp_cd, curr_cd, 
                     ots_amt, inv_amt, clt_amt, 
                     adj_amt, bal_amt, rev_amt  
                   ) = ( SELECT DECODE( COUNT(0), 0, 'D', 'N'), 
                                DECODE( COUNT(DISTINCT K.n3pty_expn_tp_cd), 0, NULL, 1, MAX(K.n3pty_expn_tp_cd), 'MIX') , 
                                DECODE( COUNT(DISTINCT K.n3pty_bil_tp_cd), 0, NULL, 1, MAX(K.n3pty_bil_tp_cd), 'MX') , 
                                DECODE( COUNT(DISTINCT K.cfm_curr_cd), 0, NULL, 1, MAX(K.cfm_curr_cd), NULL), 
                                SUM(K.ots_amt) AS ots_amt, 
                                SUM(K.inv_amt) AS inv_amt, 
                                SUM(K.clt_amt) AS clt_amt, 
                                SUM(K.adj_amt) AS adj_amt, 
                                SUM(K.bal_amt) AS bal_amt, 
                                SUM(K.rev_amt) AS rev_amt 
                           FROM TPB_OTS_DTL K
                          WHERE 1=1 
                            AND n3pty_no = v_n3pty_no_old -- v_n3pty_no_old
                            AND n3pty_delt_tp_cd IN ('N','S')
                        ), 
                   upd_dt = SYSDATE, 
                   upd_usr_id = in_user_id 
             WHERE 1=1 
               AND n3pty_no = v_n3pty_no_old -- v_n3pty_no_old
               AND n3pty_delt_tp_cd = 'N'
            ;
        
            --===== ADD STATUS AND RECOVERY ACTIVITY =====
            -- TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'D', v_user_id); 
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',in_ots_dtl_seq,'','TPB Group Remaking : it was become a Candidate. '||v_n3pty_no_old||' => (none)','A','',in_user_ofc_cd,in_user_id);
            -- TPB_ADD_OTS_GRP_STS_PRC(v_n3pty_no, 'O', v_user_id); 
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no_old,'','TPB Group Remaking : A detail item was moved to the Candidate. ','A','',in_user_ofc_cd,in_user_id);
    
    
        END IF ; 
    
    END IF ; 


--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_inv_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END

-- ===== End of Procedure ==================================
;