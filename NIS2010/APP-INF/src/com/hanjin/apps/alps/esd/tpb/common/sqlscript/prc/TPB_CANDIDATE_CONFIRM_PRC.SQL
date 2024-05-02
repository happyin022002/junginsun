CREATE OR REPLACE PROCEDURE NISADM.TPB_CANDIDATE_CONFIRM_PRC  
/*******************************************************************************  
   1. Object Name      : TPB_CANDIDATE_CONFIRM_PRC  
   2. Version          : 1.4  
   3. Create Date      : 2008.09.19  
   4. Sub System       : Third Party Billing  
   5. Author           : Sun, Choi
   6. Description      : Confirm TPB Candidate  
                         -------------------------------------------------------  
                         DECLARE   
                             v_n3pty_no VARCHAR2(11);   
                         BEGIN   
                             TPB_CANDIDATE_CONFIRM_PRC(:v_n3pty_no,:v_grp_n3pty_no,'I',123,'PUSBO','TES_PUSBO','CONFIRM REMARK', '??', 'KRW', 3000, 'C',NULL,NULL,'KR','1',NULL) ;  
                             DBMS_OUTPUT.PUT_LINE('3rd Party TPB No. : ' || v_n3pty_no);  
                         END;   
                         -------------------------------------------------------  
   7. Revision History : 2008.09.19  Kim Jin-seung      1.0  Created  
                         2008.11.20  Kim Jin-seung      1.1  'G' case, curr_cd - use v_curr_cd  
                         2008.11.24  Kim Jin-seung      1.2  'G' case, 3RD PARTY ... patch   
                         2008.12.02  Kim Jin-seung      1.3  'G' case, curr_cd ... patch (not use 'MX')  
                         2009.09.01  Park Sung-Jin      1.4  ALPS Migration  
                         2009.09.02  O Wan-Ki           1.5  I/F Currency와 Confirm Currency 의 차이가 발생하였 경우,  
                                                             Revenue Amount 부분에서 Invalid Value를 내는 문제보완
                         2010.10.08  Jong Geon Byeon    1.6  Group Confirm의 경우 Expense Type이 다를 경우 Confirm불가. Expense Type에 MIX 허용되지 않게 수정
*******************************************************************************/  
  
-- ===== Arguments ========================================  
(   
    v_grp_n3pty_no IN TPB_OTS_DTL.n3pty_no%TYPE --- TPB No to be reused in group confirmation  
    ,v_cfm_type     IN VARCHAR2   --- confirm type : I / G / N / R  
    ,v_ots_dtl_seq  IN VARCHAR2   --- key  
    ,v_user_ofc_cd  IN VARCHAR2   --- user office code  
    ,v_user_id      IN VARCHAR2   --- user id  
    ,v_cfm_rmk			  IN VARCHAR2  
    ,v_n3pty_non_cfm_rsn_cd IN VARCHAR2  
    ,v_curr_cd			  IN VARCHAR2  
    ,v_cfm_amt			  IN VARCHAR2  
  
    ,v_vndr_cust_div_cd IN VARCHAR2  
    ,v_vndr_cnt_cd		  IN VARCHAR2  
    ,v_vndr_seq		  IN VARCHAR2  
    ,v_cust_cnt_cd		  IN VARCHAR2  
    ,v_cust_seq		  IN VARCHAR2  
    ,v_n3pty_ofc_cd	  IN VARCHAR2    
  
    ,v_n3pty_no     OUT TPB_OTS_DTL.n3pty_no%TYPE --- TPB No to be generated  
      
)   
  
IS   
  
-- ===== DECLARE ==========================================  
    v_grp_n3pty_no_in   TPB_OTS_DTL.n3pty_no%TYPE; 
    v_ofc_cd            TPB_OTS_DTL.ofc_cd%TYPE; -- tpb office code  
    v_n3pty_valid_yn    VARCHAR2(1);  
    v_valid_cnt         NUMBER(3);  
      
    v_n3pty_bil_tp_cd   VARCHAR2(2);              --2009.09.02  
    v_if_curr_cd        TPB_OTS_DTL.if_curr_cd%TYPE;--2009.09.02
    v_valid_yn          VARCHAR2(1);
  
-- ===== BEGIN, EXCEPTION and END ======================================  
BEGIN  
  
    --- Initiate varibles   
    v_n3pty_no := NULL;   
    v_n3pty_bil_tp_cd := NULL;  --2009.09.02  
    v_if_curr_cd := NULL;       --2009.09.02  
     
    /* 2009.09.02 */  
    SELECT n3pty_bil_tp_cd INTO v_n3pty_bil_tp_cd FROM TPB_OTS_DTL  
    WHERE ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq);   
    SELECT if_curr_cd INTO v_if_curr_cd FROM TPB_OTS_DTL  
    WHERE ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq);  
  
    --- ====== Individual Confirm =================== ========================================  
    IF v_cfm_type = 'I' THEN -----------------------  
  
        -- 0-1) CHECK LOGIC -  3RD PARTY CHECK   
        SELECT   
            TPB_CHECK_3RD_PARTY_VALID_FNC(  
                v_vndr_cust_div_cd,   
                DECODE( v_vndr_cust_div_cd,   
                    'V', v_vndr_seq,   
                    'C', v_cust_cnt_cd || v_cust_seq,   
                    'S', v_n3pty_ofc_cd,   
                    NULL  
                )  
           )  
        INTO v_n3pty_valid_yn  
        FROM DUAL   
        ;   
          
        -- 0-2) CHECK LOGIC - STATUS VALID COUNT   
        SELECT COUNT(0) CNT    
        INTO v_valid_cnt  
        FROM TPB_OTS_DTL    
        WHERE 1=1   
            AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
            AND n3pty_delt_tp_cd IN ('N','S')   
            AND n3pty_cfm_cd IN ('I','R')  -- CD01476  
        ;   
          
        --- 정상적일 경우 ---------------------  
        IF ( v_n3pty_valid_yn = 'Y' AND v_valid_cnt > 0 ) THEN   
              
            /* 2009.09.02 */  
            SELECT n3pty_bil_tp_cd INTO v_n3pty_bil_tp_cd FROM TPB_OTS_DTL  
            WHERE ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq);   
            SELECT if_curr_cd INTO v_if_curr_cd FROM TPB_OTS_DTL  
            WHERE ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq);  
  
            -- 1) GET NEW TPB No.  
            SELECT ofc_cd INTO v_ofc_cd FROM TPB_OTS_DTL WHERE ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq);   
            TPB_GEN_TPB_NO_PRC(v_ofc_cd, v_user_id, v_n3pty_no); --- GET v_n3pty_no  
                  
            -- 2) UPDATE TPB_OTS_DTL  
            UPDATE TPB_OTS_DTL   
            SET n3pty_no = v_n3pty_no,   
                n3pty_no_dp_seq = 1,   
                n3pty_cfm_cd = 'Y',   
                cfm_rmk = v_cfm_rmk,    
                  
                cfm_ofc_cd = v_user_ofc_cd, 	  
                cfm_usr_id = v_user_id,   
                cfm_dt = SYSDATE,   
                  
                upd_usr_id = v_user_id,   
                upd_dt = SYSDATE,   
              
                cfm_curr_cd = v_curr_cd,   
                cfm_amt = TO_NUMBER(v_cfm_amt),   
                ots_amt = TO_NUMBER(v_cfm_amt),   
                bal_amt = TO_NUMBER(v_cfm_amt),   
--                rev_amt = NVL(v_cfm_amt,0.0) - NVL(if_amt,0.0), --2009.09.02  
                      
                vndr_cust_div_cd = v_vndr_cust_div_cd,   
                vndr_cnt_cd = DECODE(v_vndr_cust_div_cd, 'V', v_vndr_cnt_cd, NULL),   
                vndr_seq = DECODE(v_vndr_cust_div_cd, 'V', v_vndr_seq, NULL),   
                vndr_lgl_eng_nm = DECODE(v_vndr_cust_div_cd,'V',TPB_GET_3RD_PARTY_NAME_FNC(v_vndr_cust_div_cd,v_vndr_seq),NULL),   
                cust_cnt_cd = DECODE(v_vndr_cust_div_cd, 'C', v_cust_cnt_cd, NULL),   
                cust_seq = DECODE(v_vndr_cust_div_cd, 'C', v_cust_seq, NULL),   
                cust_lgl_eng_nm = DECODE(v_vndr_cust_div_cd,'C',TPB_GET_3RD_PARTY_NAME_FNC(v_vndr_cust_div_cd,v_cust_cnt_cd||v_cust_seq),NULL),   
                n3pty_ofc_cd = DECODE(v_vndr_cust_div_cd, 'S', v_n3pty_ofc_cd, NULL)   
  
            WHERE 1=1   
                AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
            ;  
              
            /* 2009.09.02 rev_amt 에러방지 */  
            IF v_n3pty_bil_tp_cd = 'JO' AND v_if_curr_cd = v_curr_cd THEN  
                UPDATE TPB_OTS_DTL  
                SET rev_amt = NVL(v_cfm_amt,0.0) - NVL(if_amt,0.0)  
                WHERE 1=1   
                    AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
                ;  
            END IF  
            ;  
              
            -- 3) INSERT INTO TPB_OTS_GRP   
            INSERT INTO TPB_OTS_GRP (  
                n3pty_no, n3pty_inv_no, ofc_cd, n3pty_delt_tp_cd, cfm_dt,   
                cre_usr_id, cre_dt, upd_usr_id, upd_dt,   
                n3pty_expn_tp_cd, n3pty_bil_tp_cd, vsl_cd, skd_voy_no, finc_dir_cd,   
                ots_amt, inv_amt, clt_amt, adj_amt, bal_amt,   
                rev_amt, vndr_cust_div_cd, vndr_seq, cust_cnt_cd, cust_seq,   
                n3pty_ofc_cd, curr_cd                  
            )   
            SELECT   
                v_n3pty_no, NULL, v_ofc_cd, 'N', SYSDATE,   
                v_user_id, SYSDATE, v_user_id, SYSDATE,   
                n3pty_expn_tp_cd, n3pty_bil_tp_cd, vsl_cd, skd_voy_no, finc_dir_cd,   
                ots_amt, inv_amt, clt_amt, adj_amt, bal_amt,   
                rev_amt, vndr_cust_div_cd, vndr_seq, cust_cnt_cd, cust_seq,   
                n3pty_ofc_cd, cfm_curr_cd   
            FROM TPB_OTS_DTL  
            WHERE 1=1   
                AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
            ;  
  
            -- 4) INSERT/UPDATE TPB_OTS_DTL_STS AND INSERT TPB_OTS_DTL_RCVR_ACT  
            TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'O', v_user_id);   
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Confirmed. - '||v_cfm_rmk,'A','',v_user_ofc_cd,v_user_id);  
  
            -- 5) INSERT/UDPATE TPB_OTS_GRP_STS AND INSERT TPB_OTS_GRP_RCVR_ACT  
            TPB_ADD_OTS_GRP_STS_PRC(v_n3pty_no, 'O', v_user_id);   
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'','Confirmed.','A','',v_user_ofc_cd,v_user_id);  
  
        END IF; -------------------------------  
  
      
    --- ====== Group Confirm =================== ========================================  
    ELSIF v_cfm_type = 'G' THEN -----------------------  
  
        -- 0-1) CHECK LOGIC -  3RD PARTY CHECK   
        SELECT   
            TPB_CHECK_3RD_PARTY_VALID_FNC(  
                v_vndr_cust_div_cd,   
                DECODE( v_vndr_cust_div_cd,   
                    'V', v_vndr_seq,   
                    'C', v_cust_cnt_cd || v_cust_seq,   
                    'S', v_n3pty_ofc_cd,   
                    NULL  
                )  
           )  
        INTO v_n3pty_valid_yn 
        FROM DUAL   
        ; 
          
        -- 0-2) CHECK LOGIC - STATUS VALID COUNT   
        SELECT COUNT(0) CNT    
        INTO v_valid_cnt 
        FROM TPB_OTS_DTL 
        WHERE 1=1   
            AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
            AND n3pty_delt_tp_cd IN ('N','S')   
            AND n3pty_cfm_cd IN ('I','R')  -- CD01476  
        ;   
          
        --- 정상적일 경우 ---------------------  
        IF ( v_n3pty_valid_yn = 'Y' AND v_valid_cnt > 0 ) THEN   
  
            ---- *) Group 1st Deatil Case ----  
            v_grp_n3pty_no_in := NULL; 
            IF( TO_NUMBER(v_grp_n3pty_no) > 0) THEN 
                SELECT lst_n3pty_no INTO v_grp_n3pty_no_in 
                FROM TPB_NO_GEN  
                WHERE n3pty_appl_cd = 'TPB' 
                AND n3pty_ofc_cty_cd = SUBSTRB(TRIM(v_user_ofc_cd),1,3) 
                AND n3pty_yrmon = TO_CHAR(SYSDATE,'YYMM'); 
            END IF; 
 
            --IF ( v_grp_n3pty_no IS NULL OR LENGTHB(v_grp_n3pty_no) != 14 ) THEN   
            IF ( v_grp_n3pty_no_in IS NULL OR LENGTHB(v_grp_n3pty_no_in) != 14 ) THEN 
              
                -- 1) GET NEW TPB No. 
                SELECT ofc_cd INTO v_ofc_cd FROM TPB_OTS_DTL WHERE ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq); 
                TPB_GEN_TPB_NO_PRC(v_ofc_cd, v_user_id, v_n3pty_no); --- GET v_n3pty_no 
  
                -- 2) INSERT INTO TPB_OTS_GRP   
                INSERT INTO TPB_OTS_GRP (  
                    n3pty_no, n3pty_inv_no, ofc_cd, n3pty_delt_tp_cd, cfm_dt,   
                    cre_usr_id, cre_dt, upd_usr_id, upd_dt,   
                    n3pty_expn_tp_cd, n3pty_bil_tp_cd, vsl_cd, skd_voy_no, finc_dir_cd,   
                    --- ots_amt, inv_amt, clt_amt, adj_amt, bal_amt, rev_amt,   
                    vndr_cust_div_cd, vndr_seq, cust_cnt_cd, cust_seq, n3pty_ofc_cd,   
                    curr_cd                  
                )   
                SELECT   
                    v_n3pty_no, NULL, v_ofc_cd, 'N', SYSDATE,   
                    v_user_id, SYSDATE, v_user_id, SYSDATE,   
                    n3pty_expn_tp_cd, n3pty_bil_tp_cd, vsl_cd, skd_voy_no, finc_dir_cd,   
                    --- ots_amt, inv_amt, clt_amt, adj_amt, bal_amt, rev_amt,   
                    v_vndr_cust_div_cd AS vndr_cust_div_cd,   
                    DECODE(v_vndr_cust_div_cd, 'V', v_vndr_seq, NULL) AS vndr_seq,   
                    DECODE(v_vndr_cust_div_cd, 'C', v_cust_cnt_cd, NULL) AS cust_cnt_cd,   
                    DECODE(v_vndr_cust_div_cd, 'C', v_cust_seq, NULL) AS cust_seq,   
                    DECODE(v_vndr_cust_div_cd, 'S', v_n3pty_ofc_cd, NULL) AS n3pty_ofc_cd,   
                    v_curr_cd   
                FROM TPB_OTS_DTL  
                WHERE 1=1   
                    AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
                ;                  
                      
                -- 3) UPDATE TPB_OTS_DTL  
                UPDATE TPB_OTS_DTL   
                SET n3pty_no = v_n3pty_no,   
                    n3pty_no_dp_seq = ( SELECT NVL(MAX(n3pty_no_dp_seq),0)+1   
                                        FROM TPB_OTS_DTL   
                                        WHERE n3pty_no = v_n3pty_no   
                                      ),   
                    n3pty_cfm_cd = 'Y',   
                    cfm_rmk = v_cfm_rmk,    
                      
                    cfm_ofc_cd = v_user_ofc_cd, 	  
                    cfm_usr_id = v_user_id,   
                    cfm_dt = SYSDATE,   
                      
                    upd_usr_id = v_user_id,   
                    upd_dt = SYSDATE,   
                  
                    cfm_curr_cd = v_curr_cd,   
                    cfm_amt = TO_NUMBER(v_cfm_amt),   
                    ots_amt = TO_NUMBER(v_cfm_amt),   
                    bal_amt = TO_NUMBER(v_cfm_amt),   
--                    rev_amt = NVL(v_cfm_amt,0.0) - NVL(if_amt,0.0), --2009.09.02  
                          
                    vndr_cust_div_cd = v_vndr_cust_div_cd,   
                    vndr_cnt_cd = DECODE(v_vndr_cust_div_cd, 'V', v_vndr_cnt_cd, NULL),   
                    vndr_seq = DECODE(v_vndr_cust_div_cd, 'V', v_vndr_seq, NULL),   
                    vndr_lgl_eng_nm = DECODE(v_vndr_cust_div_cd,'V',TPB_GET_3RD_PARTY_NAME_FNC(v_vndr_cust_div_cd,v_vndr_seq),NULL),   
                    cust_cnt_cd = DECODE(v_vndr_cust_div_cd, 'C', v_cust_cnt_cd, NULL),   
                    cust_seq = DECODE(v_vndr_cust_div_cd, 'C', v_cust_seq, NULL),   
                    cust_lgl_eng_nm = DECODE(v_vndr_cust_div_cd,'C',TPB_GET_3RD_PARTY_NAME_FNC(v_vndr_cust_div_cd,v_cust_cnt_cd||v_cust_seq),NULL),   
                    n3pty_ofc_cd = DECODE(v_vndr_cust_div_cd, 'S', v_n3pty_ofc_cd, NULL)   
      
                WHERE 1=1   
                    AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
                ;  
                  
                /* 2009.09.02 rev_amt 에러방지 */  
                IF v_n3pty_bil_tp_cd = 'JO' AND v_if_curr_cd = v_curr_cd THEN  
                    UPDATE TPB_OTS_DTL  
                    SET rev_amt = NVL(v_cfm_amt,0.0) - NVL(if_amt,0.0)  
                    WHERE 1=1   
                        AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
                    ;  
                END IF  
                ;  
                  
                  
                -- 2) UPDATE TPB_OTS_GRP 2 (Amount)  
                UPDATE TPB_OTS_GRP B  
                SET   
                    (  
                        ots_amt, inv_amt, clt_amt, adj_amt, bal_amt, rev_amt    
                    ) = (  
                        SELECT   
                            NVL(B.ots_amt,0)+NVL(K.ots_amt,0) AS ots_amt,   
                            NVL(B.inv_amt,0)+NVL(K.inv_amt,0) AS inv_amt,   
                            NVL(B.clt_amt,0)+NVL(K.clt_amt,0) AS clt_amt,   
                            NVL(B.adj_amt,0)+NVL(K.adj_amt,0) AS adj_amt,   
                            NVL(B.bal_amt,0)+NVL(K.bal_amt,0) AS bal_amt,   
                            NVL(B.rev_amt,0)+NVL(K.rev_amt,0) AS rev_amt   
                        FROM TPB_OTS_DTL K  
                        WHERE 1=1   
                            AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
                    )  
                 WHERE 1=1   
                    AND n3pty_no = v_n3pty_no   
                ;  
      
                -- 3) INSERT/UPDATE TPB_OTS_DTL_STS AND INSERT TPB_OTS_DTL_RCVR_ACT  
                TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'O', v_user_id);   
                TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Confirmed. - '||v_cfm_rmk,'A','',v_user_ofc_cd,v_user_id);  
      
                -- 4) INSERT/UDPATE TPB_OTS_GRP_STS AND INSERT TPB_OTS_GRP_RCVR_ACT  
                TPB_ADD_OTS_GRP_STS_PRC(v_n3pty_no, 'O', v_user_id);   
                TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'','Confirmed.','A','',v_user_ofc_cd,v_user_id);  
              
              
            ---- *) Group NOT 1st  Deatil Case ----  
            ELSE  
              
                -- 1) GET NEW TPB No.   
                v_n3pty_no := v_grp_n3pty_no_in; 
                
                /* Expense Type이 다른 경우에는 Group Confirm이 허용되지 않음. Validation Check */
                SELECT DECODE(N3PTY_EXPN_TP_CD,(SELECT N3PTY_EXPN_TP_CD FROM TPB_OTS_DTL WHERE OTS_DTL_SEQ = TO_NUMBER(v_ots_dtl_seq)),'Y','N') VALID_YN
                  INTO v_valid_yn
                  FROM TPB_OTS_GRP
                 WHERE 1 = 1
                   AND N3PTY_NO = v_n3pty_no;
                
                IF ( v_valid_yn = 'Y' ) THEN

                    -- 2) UPDATE TPB_OTS_GRP 1  
                    /* Expense Type이 다른 경우에는 Group Confirm이 허용되지 않음. 그러므로 N3PTY_EXPN_TP_CD 컬럼에 MIX를 넣어주는 부분 주석처리 */
                    UPDATE TPB_OTS_GRP B  
                    SET   
                        (  
--                            n3pty_expn_tp_cd,   
                            n3pty_bil_tp_cd,   
                            curr_cd  
                        ) = (  
                            SELECT   
--                                DECODE(B.n3pty_expn_tp_cd,K.n3pty_expn_tp_cd,B.n3pty_expn_tp_cd,'MIX') AS n3pty_expn_tp_cd,   
                                DECODE(B.n3pty_bil_tp_cd,K.n3pty_bil_tp_cd,B.n3pty_bil_tp_cd,'MX') AS n3pty_bil_tp_cd,    
                                DECODE(B.curr_cd,K.cfm_curr_cd,B.curr_cd, v_curr_cd) AS curr_cd   
                            FROM TPB_OTS_DTL K  
                            WHERE 1=1   
                                AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
                        )  
                     WHERE 1=1   
                        AND n3pty_no = v_n3pty_no   
                    ;  
                          
                 
                    -- 3) UPDATE TPB_OTS_DTL  
                    UPDATE TPB_OTS_DTL   
                    SET n3pty_no = v_n3pty_no,   
                        n3pty_no_dp_seq = ( SELECT NVL(MAX(n3pty_no_dp_seq),0)+1   
                                            FROM TPB_OTS_DTL   
                                            WHERE n3pty_no = v_n3pty_no   
                                          ),   
                        n3pty_cfm_cd = 'Y',   
                        cfm_rmk = v_cfm_rmk,    
                          
                        cfm_ofc_cd = v_user_ofc_cd, 	  
                        cfm_usr_id = v_user_id,   
                        cfm_dt = SYSDATE,   
                          
                        upd_usr_id = v_user_id,   
                        upd_dt = SYSDATE,   
                      
                        cfm_curr_cd = v_curr_cd,   
                        cfm_amt = TO_NUMBER(v_cfm_amt),   
                        ots_amt = TO_NUMBER(v_cfm_amt),   
                        bal_amt = TO_NUMBER(v_cfm_amt),   
    --                    rev_amt = NVL(v_cfm_amt,0.0) - NVL(if_amt,0.0), --2009.09.02  
                              
                        vndr_cust_div_cd = v_vndr_cust_div_cd,   
                        vndr_cnt_cd = DECODE(v_vndr_cust_div_cd, 'V', v_vndr_cnt_cd, NULL),   
                        vndr_seq = DECODE(v_vndr_cust_div_cd, 'V', v_vndr_seq, NULL),   
                        vndr_lgl_eng_nm = DECODE(v_vndr_cust_div_cd,'V',TPB_GET_3RD_PARTY_NAME_FNC(v_vndr_cust_div_cd,v_vndr_seq),NULL),   
                        cust_cnt_cd = DECODE(v_vndr_cust_div_cd, 'C', v_cust_cnt_cd, NULL),   
                        cust_seq = DECODE(v_vndr_cust_div_cd, 'C', v_cust_seq, NULL),   
                        cust_lgl_eng_nm = DECODE(v_vndr_cust_div_cd,'C',TPB_GET_3RD_PARTY_NAME_FNC(v_vndr_cust_div_cd,v_cust_cnt_cd||v_cust_seq),NULL),   
                        n3pty_ofc_cd = DECODE(v_vndr_cust_div_cd, 'S', v_n3pty_ofc_cd, NULL)   
          
                    WHERE 1=1   
                        AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
                    ;  
          
                    /* 2009.09.02 rev_amt 에러방지 */  
                    IF v_n3pty_bil_tp_cd = 'JO' AND v_if_curr_cd = v_curr_cd THEN  
                        UPDATE TPB_OTS_DTL  
                        SET rev_amt = NVL(v_cfm_amt,0.0) - NVL(if_amt,0.0)  
                        WHERE 1=1   
                            AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
                        ;  
                    END IF  
                    ;  
                      
                    -- 2) UPDATE TPB_OTS_GRP 2 (Amount)  
                    UPDATE TPB_OTS_GRP B  
                    SET   
                        (  
                            ots_amt, inv_amt, clt_amt, adj_amt, bal_amt, rev_amt    
                        ) = (  
                            SELECT   
                                NVL(B.ots_amt,0)+NVL(K.ots_amt,0) AS ots_amt,   
                                NVL(B.inv_amt,0)+NVL(K.inv_amt,0) AS inv_amt,   
                                NVL(B.clt_amt,0)+NVL(K.clt_amt,0) AS clt_amt,   
                                NVL(B.adj_amt,0)+NVL(K.adj_amt,0) AS adj_amt,   
                                NVL(B.bal_amt,0)+NVL(K.bal_amt,0) AS bal_amt,   
                                NVL(B.rev_amt,0)+NVL(K.rev_amt,0) AS rev_amt   
                            FROM TPB_OTS_DTL K  
                            WHERE 1=1   
                                AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
                        )  
                     WHERE 1=1   
                        AND n3pty_no = v_n3pty_no   
                    ;  
      
      
                    -- 3) INSERT/UPDATE TPB_OTS_DTL_STS AND INSERT TPB_OTS_DTL_RCVR_ACT  
                    TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'O', v_user_id);   
                    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Confirmed. - '||v_cfm_rmk,'A','',v_user_ofc_cd,v_user_id);  
          
                    -- 4) INSERT/UDPATE TPB_OTS_GRP_STS AND INSERT TPB_OTS_GRP_RCVR_ACT  
                    --- in case of group ... aleady inserted at just 1st detail outstanding  
                    --- TPB_ADD_OTS_GRP_STS_PRC(v_n3pty_no, 'O', v_user_id);   
                    --- TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'','Confirmed.','A','',v_user_ofc_cd,v_user_id);
                END IF;
                  
            END IF; ----  
  
      
        END IF; -------------------------------  
      
  
    --- ====== Non-Confirm =================== ========================================  
    ELSIF v_cfm_type = 'N' THEN -----------------------  
  
        -- 0) CHECK LOGIC - STATUS VALID COUNT   
        SELECT COUNT(0) CNT    
        INTO v_valid_cnt  
        FROM TPB_OTS_DTL    
        WHERE 1=1   
            AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
            AND n3pty_delt_tp_cd IN ('N','S')   
            AND n3pty_cfm_cd IN ('I','R')  -- CD01476  
        ;   
          
        --- 정상적일 경우 ---------------------  
        IF ( v_valid_cnt > 0 ) THEN   
  
            -- 1) UPDATE TPB_OTS_DTL  
            UPDATE TPB_OTS_DTL   
            SET   
                n3pty_cfm_cd = 'N',   
                cfm_rmk = v_cfm_rmk,    
                n3pty_non_cfm_rsn_cd = v_n3pty_non_cfm_rsn_cd,   
                  
                cfm_ofc_cd = v_user_ofc_cd, 	  
                cfm_usr_id = v_user_id,   
                cfm_dt = SYSDATE,   
                  
                upd_usr_id = v_user_id,   
                upd_dt = SYSDATE   
  
            WHERE 1=1   
                AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
            ;  
  
            -- 2) INSERT TPB_OTS_DTL_RCVR_ACT  
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Non-confirmed. - '||v_cfm_rmk,'A','',v_user_ofc_cd,v_user_id);  
  
  
        END IF; -------------------------------  
  
  
    --- ====== Review for Non-Confirm ===========================================================  
    ELSIF v_cfm_type = 'R' THEN -----------------------  
  
        -- 0) CHECK LOGIC - STATUS VALID COUNT   
        SELECT COUNT(0) CNT    
        INTO v_valid_cnt  
        FROM TPB_OTS_DTL    
        WHERE 1=1   
            AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
            AND n3pty_delt_tp_cd IN ('N','S')   
            AND n3pty_cfm_cd IN ('N')  -- CD01476  
        ;   
          
        --- 정상적일 경우 ---------------------  
        IF ( v_valid_cnt > 0 ) THEN   
  
            -- 1) UPDATE TPB_OTS_DTL  
            UPDATE TPB_OTS_DTL   
            SET   
                n3pty_cfm_cd = 'R',   
                cfm_rmk = v_cfm_rmk,    
  
                rvw_ofc_cd = v_user_ofc_cd, 	  
                rvw_usr_id = v_user_id,   
                rvw_dt = SYSDATE,   
                  
                upd_usr_id = v_user_id,   
                upd_dt = SYSDATE   
  
            WHERE 1=1   
                AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
            ;  
  
            -- 2) INSERT TPB_OTS_DTL_RCVR_ACT  
            TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'R', v_user_id);   
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Reviewed. - '||v_cfm_rmk,'A','',v_user_ofc_cd,v_user_id);  
      
        END IF; -------------------------------  
          
    --- ====== Non-Confirm by RHQ ===============================================================  
    ELSIF v_cfm_type = 'D' THEN -----------------------  
  
        -- 0) CHECK LOGIC - STATUS VALID COUNT   
        SELECT COUNT(0) CNT    
        INTO v_valid_cnt  
        FROM TPB_OTS_DTL    
        WHERE 1=1   
            AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
            AND n3pty_delt_tp_cd IN ('N','S')   
            AND n3pty_cfm_cd IN ('N')  -- CD01476  
        ;   
          
        --- 정상적일 경우 ---------------------  
        IF ( v_valid_cnt > 0 ) THEN   
  
            -- 1) UPDATE TPB_OTS_DTL  
            UPDATE TPB_OTS_DTL   
            SET   
                cfm_rmk = v_cfm_rmk,    
  
                rvw_ofc_cd = v_user_ofc_cd, 	  
                rvw_usr_id = v_user_id,   
                rvw_dt = SYSDATE,   
                  
                upd_usr_id = v_user_id,   
                upd_dt = SYSDATE,   
                  
                n3pty_delt_tp_cd = 'D'  
  
            WHERE 1=1   
                AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)   
            ;  
  
            -- 2) INSERT TPB_OTS_DTL_RCVR_ACT  
            TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'D', v_user_id);   
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Reviewed. - '||v_cfm_rmk,'A','',v_user_ofc_cd,v_user_id);  
              
              
      
        END IF; -------------------------------  
  
  
    END IF; -------------------------------------------  
  
  
--EXCEPTION  
--    WHEN OTHERS THEN  
--        v_n3pty_no := NULL;  
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );   
       
  
END  
  
-- ===== End of Procedure ==================================  
;