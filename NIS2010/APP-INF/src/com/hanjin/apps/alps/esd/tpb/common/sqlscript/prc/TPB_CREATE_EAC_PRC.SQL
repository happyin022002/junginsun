CREATE OR REPLACE PROCEDURE NISADM.TPB_CREATE_EAC_PRC

/*******************************************************************************
1. Object Name      : TPB_CREATE_EAC_PRC
2. Version          : 1.6
3. Create Date      : 2010.01.08
4. Sub System       : Third Party Billing
5. Author           : Sun, Choi
6. Description      : CREATE TPB BY EAC
                      -------------------------------------------------------
                      DECLARE 
                      BEGIN 
                          TPB_CREATE_EAC_PRC() ;
                      END;
                      -------------------------------------------------------
7. Revision History : 2008.09.23  Kim Jin-seung  1.0  최초 생성
                      2008.11.10  Kim Jin-seung  1.1  sequence change
                      2009.01.15  O Wan-Ki       1.2  TPB VVD 9Digit Role 
                      2009.02.11  O Wan-Ki       1.3  TPB_OTS_GRP - OFC_CD Insert 보완.
                      2009.08.19  Sun, CHOI      1.4  ALPS Migration
                      2009.09.16  Sun, CHOI      1.5  EAC 등록 처리 변경.
                      2010.01.08  Sun, CHOI      1.6  EQ_TP_CD -> EQ_KND_CD 전환
*******************************************************************************/

(
     in_reg_type          IN VARCHAR2
    ,in_n3pty_no          IN VARCHAR2
    ,in_n3pty_expn_tp_cd  IN VARCHAR2
    ,in_n3pty_bil_tp_cd   IN VARCHAR2
    ,in_eac_tp_cd         IN VARCHAR2
    ,in_if_ofc_cd		  IN VARCHAR2
    ,in_if_amt			  IN VARCHAR2
    ,in_curr_cd			  IN VARCHAR2
    ,in_bkg_no			  IN VARCHAR2
    ,in_bkg_no_split	  IN VARCHAR2
    ,in_bl_no_chk		  IN VARCHAR2
    ,in_bl_no			  IN VARCHAR2
    ,in_bl_no_tp		  IN VARCHAR2
    ,in_vsl_cd			  IN VARCHAR2
    ,in_skd_voy_no		  IN VARCHAR2
    ,in_skd_dir_cd		  IN VARCHAR2
    ,in_eq_knd_cd		  IN VARCHAR2
    ,in_eq_no			  IN VARCHAR2
    ,in_eq_tpsz_cd		  IN VARCHAR2
    ,in_n3pty_src_no	  IN VARCHAR2
    ,in_so_no			  IN VARCHAR2
    ,in_vndr_cust_div_cd  IN VARCHAR2
    ,in_vndr_cnt_cd		  IN VARCHAR2
    ,in_vndr_seq		  IN VARCHAR2
    ,in_cust_cnt_cd		  IN VARCHAR2
    ,in_cust_seq		  IN VARCHAR2
    ,in_n3pty_ofc_cd	  IN VARCHAR2
    ,in_if_rmk			  IN VARCHAR2
    ,in_src_vndr_cnt_cd	  IN VARCHAR2
    ,in_src_vndr_seq 	  IN VARCHAR2
    ,in_dt          	  IN VARCHAR2
    ,in_yd_cd             IN VARCHAR2
    ,in_file_no			  IN VARCHAR2
    ,in_user_id			  IN VARCHAR2
    ,in_user_ofc_cd       IN VARCHAR2   
    ,in_sys_area_grp_id   IN VARCHAR2 
    ,out_n3pty_no         OUT VARCHAR2      
)
AUTHID CURRENT_USER

IS 
  --v_n3pty_no          tpb_ots_dtl.n3pty_no%TYPE;
  --v_max_ots_seq       tpb_ots_sts.ots_seq%TYPE; 
    v_vndr_lgl_eng_nm   tpb_ots_dtl.vndr_lgl_eng_nm%TYPE;
    v_cust_lgl_eng_nm   tpb_ots_dtl.cust_lgl_eng_nm%TYPE;   
    v_bkg_vsl_cd        VARCHAR2 (4);--coa_bkg_info.vsl_cd%TYPE;
    v_bkg_skd_voy_no    VARCHAR2 (4);--coa_bkg_info.skd_voy_no%TYPE;
    v_bkg_finc_dir_cd   VARCHAR2 (2);--coa_bkg_info.finc_dir_cd%TYPE;
    v_skd_dir_cd        tpb_ots_dtl.skd_dir_cd%TYPE;
    v_rev_vvd_cd        VARCHAR2(10);

    v_ots_dtl_seq       tpb_ots_dtl.ots_dtl_seq%TYPE;
  
BEGIN
    -- get 3rd Party Name 
    IF in_vndr_cust_div_cd = 'V' THEN
    
        SELECT vndr_lgl_eng_nm
          INTO v_vndr_lgl_eng_nm
          FROM MDM_VENDOR
         WHERE vndr_seq = in_vndr_seq
           AND ROWNUM = 1;
           
    ELSIF in_vndr_cust_div_cd = 'C' THEN

        SELECT cust_lgl_eng_nm
          INTO v_cust_lgl_eng_nm
          FROM MDM_CUSTOMER
         WHERE cust_cnt_cd = in_cust_cnt_cd
           AND cust_seq = in_cust_seq
           AND ROWNUM = 1; 
           
    END IF;

    -- Booking Number / VVD  으로 Revenue VVD 찾기
    v_skd_dir_cd := in_skd_dir_cd;

    IF in_bkg_no IS NOT NULL THEN   

        -- SELECT TPB_BKG_REV_VVD_FNC(in_bkg_no, DECODE(NVL(in_bkg_no_split,''),'','  ',in_bkg_no_split)) 
        SELECT TPB_BKG_REV_VVD_FNC(in_bkg_no)
          INTO v_rev_vvd_cd
          FROM DUAL;

        v_bkg_vsl_cd        := SUBSTR(v_rev_vvd_cd,1,4);
        v_bkg_skd_voy_no    := SUBSTR(v_rev_vvd_cd,5,4);
        v_bkg_finc_dir_cd   := SUBSTR(v_rev_vvd_cd,9);        


        IF v_bkg_finc_dir_cd IS NOT NULL THEN
            v_skd_dir_cd := SUBSTR(v_bkg_finc_dir_cd,1,1);
        END IF;
      
    ELSE

        IF in_yd_cd IS NOT NULL AND (in_vsl_cd||in_skd_voy_no||in_skd_dir_cd ) IS NOT NULL THEN  

            FOR vvd_list IN ( SELECT AR.slan_dir_cd||AR.rlane_dir_cd  cd
                                FROM ar_finc_dir_conv AR, 
                                (SELECT sconti_cd 
                                   FROM MDM_LOCATION 
                                  WHERE loc_cd = in_yd_cd 
                                    AND delt_flg = 'N') LOC,    -- 입력된 Location 정보
                                (SELECT slan_cd 
                                   FROM BKG_VVD -- bkg_bkg_vvd 
                                  WHERE vsl_cd = in_vsl_cd
                                    AND skd_voy_no = in_skd_voy_no
                                    AND skd_dir_cd = in_skd_dir_cd 
                                    AND ROWNUM = 1) VVD         -- 입력된 VVD
                             WHERE VVD.slan_cd = AR.slan_cd
                               AND LOC.sconti_cd = AR.sconti_cd
                               AND ROWNUM = 1
                             )
            LOOP
                v_bkg_finc_dir_cd := vvd_list.cd;
            END LOOP;
        END IF;
    END IF;


    -----============ REGISTER AS INDIVIDUAL CASE --------------------
    IF ( in_reg_type = 'I' OR ( in_reg_type = 'G' AND ( in_n3pty_no IS NULL OR LENGTHB(in_n3pty_no) < 14 ) ) ) THEN 
        -- DBMS_OUTPUT.PUT_LINE('SQL Error : ' || 'in_reg_type==>' || in_reg_type || 'in_n3pty_no==>' || in_n3pty_no ); 
        -- get Next ots_dtl_seq
        SELECT tpb_ots_dtl_seq1.nextval
          INTO v_ots_dtl_seq 
          FROM DUAL; 
        -- DBMS_OUTPUT.PUT_LINE('SQL Error : ' || 'v_ots_dtl_seq==>' || v_ots_dtl_seq );     
        -- INSERT INTO TPB_OTS_DTL
        INSERT INTO TPB_OTS_DTL (
            ots_dtl_seq, 
            n3pty_expn_tp_cd, n3pty_src_sub_sys_cd, eac_tp_cd, if_ofc_cd, 
            if_rhq_cd, 
            if_curr_cd, if_amt, 
          --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)  
          --cfm_curr_cd, cfm_amt, ots_amt, bal_amt,
            bkg_no, --bkg_no_split, --bl_no_chk, 
            bl_no, --bl_no_tp, 
            vsl_cd, 
            skd_voy_no,
            skd_dir_cd, eq_knd_cd, eq_no, 
            eq_tpsz_cd, n3pty_src_no, so_no, vndr_cust_div_cd, vndr_cnt_cd, 
            vndr_seq, cust_cnt_cd, cust_seq, n3pty_ofc_cd, 
          --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
          --cfm_rmk, 
            n3pty_delt_tp_cd, file_no, cre_usr_id, n3pty_bil_tp_cd, 
          --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
          --cfm_dt, 
            cre_dt, upd_usr_id, upd_dt, vndr_lgl_eng_nm, 
            cust_lgl_eng_nm, src_vndr_cnt_cd, src_vndr_seq, yd_cd, 
            finc_dir_cd, 
            if_usr_id, if_dt, --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(added)
            n3pty_if_tp_cd, 
            n3pty_cfm_cd, 
          --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
          --cfm_usr_id, cfm_ofc_cd, 
            ofc_cd,
            estm_sys_area_grp_id --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(added)
        ) VALUES (
             v_ots_dtl_seq
           , in_n3pty_expn_tp_cd, in_n3pty_expn_tp_cd, in_eac_tp_cd, in_if_ofc_cd
           , TPB_GET_HNDL_OFC_FNC('R',TPB_GET_N3PTY_OFC_CD_FNC(in_if_ofc_cd))              
           , in_curr_cd, in_if_amt 
         --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added) 
         --, in_curr_cd, in_if_amt, in_if_amt, in_if_amt
           , in_bkg_no --|| in_bkg_no_split--, in_bkg_no_split, in_bl_no_chk
           , in_bl_no --|| in_bl_no_chk || in_bl_no_tp--, in_bl_no_tp
           , DECODE(v_bkg_vsl_cd,NULL,in_vsl_cd,v_bkg_vsl_cd)
           , DECODE(v_bkg_skd_voy_no,NULL,in_skd_voy_no,v_bkg_skd_voy_no)
           , v_skd_dir_cd, in_eq_knd_cd, in_eq_no
           , in_eq_tpsz_cd, in_n3pty_src_no, in_so_no, in_vndr_cust_div_cd, in_vndr_cnt_cd
           , in_vndr_seq, in_cust_cnt_cd, in_cust_seq, in_n3pty_ofc_cd
         --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
         --, in_if_rmk
           , 'N', in_file_no, in_user_id, in_n3pty_bil_tp_cd
         --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
         --, NVL( 
         --     GLOBALDATE_PKG.TIME_CONV_FNC( GLOBALDATE_PKG.GET_LOCCD_FNC(in_user_ofc_cd),TO_DATE(in_dt,'YYYY-MM-DD HH24:MI'), 'GMT')+9/24, 
         --     TO_DATE(in_dt,'YYYY-MM-DD') 
         -- )
           , SYSDATE, in_user_id, SYSDATE, v_vndr_lgl_eng_nm
           , v_cust_lgl_eng_nm, in_src_vndr_cnt_cd, in_src_vndr_seq, in_yd_cd
         --, DECODE(v_bkg_finc_dir_cd,NULL,NULL,v_bkg_finc_dir_cd)
           , DECODE(v_bkg_finc_dir_cd,NULL,v_skd_dir_cd||v_skd_dir_cd,v_bkg_finc_dir_cd) --* 1.2 Modified : 2009-01-15  O Wan-Ki - TPB VVD Role
           , in_user_id, SYSDATE --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(added)
           , 'M'
           , 'I' --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.('Y' --> 'I')
         --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
         --, in_user_id, in_user_ofc_cd
           , TPB_GET_N3PTY_OFC_CD_FNC(in_if_ofc_cd)
           , in_sys_area_grp_id
        ); 


        -- get TPB No.
        --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
        -- TPB_GEN_TPB_NO_PRC(in_if_ofc_cd, in_user_id, out_n3pty_no) ; 


        -- INSERT INTO TPB_OTS_GRP 
        --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
        /*
        INSERT INTO TPB_OTS_GRP (
            n3pty_no, n3pty_inv_no, ofc_cd, n3pty_delt_tp_cd, cfm_dt, 
            cre_usr_id, cre_dt, upd_usr_id, upd_dt, 
            n3pty_expn_tp_cd, n3pty_bil_tp_cd, vsl_cd, skd_voy_no, finc_dir_cd, 
            ots_amt, inv_amt, clt_amt, adj_amt, bal_amt, 
            rev_amt, vndr_cust_div_cd, vndr_seq, cust_cnt_cd, cust_seq, 
            n3pty_ofc_cd, curr_cd                
        ) 
        SELECT 
          --out_n3pty_no, NULL, in_user_ofc_cd, 'N', SYSDATE,
          --* 1.3 Modified : 2009-02-11  O Wan-Ki - TPB_OTS_GRP - OFC_CD Insert 보완.
            out_n3pty_no, NULL, in_if_ofc_cd, 'N', SYSDATE,
            in_user_id, SYSDATE, in_user_id, SYSDATE, 
            n3pty_expn_tp_cd, n3pty_bil_tp_cd, vsl_cd, skd_voy_no, finc_dir_cd, 
            ots_amt, inv_amt, clt_amt, adj_amt, bal_amt, 
            rev_amt, vndr_cust_div_cd, vndr_seq, cust_cnt_cd, cust_seq, 
            n3pty_ofc_cd, cfm_curr_cd 
          FROM TPB_OTS_DTL
         WHERE 1=1 
           AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq) 
        ;
        */
        
        -- UPDATE TPB_OTS_DTL
        --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(주석 처리 추가)
        /*
        UPDATE TPB_OTS_DTL 
           SET n3pty_no = out_n3pty_no, 
               n3pty_no_dp_seq = ( SELECT NVL(MAX(n3pty_no_dp_seq),0)+1 
                                     FROM TPB_OTS_DTL 
                                    WHERE n3pty_no = out_n3pty_no 
                                  )  
         WHERE ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq) 
        ;
        */

        -- 3) INSERT/UPDATE TPB_OTS_DTL_STS AND INSERT TPB_OTS_DTL_RCVR_ACT
        TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'O', in_user_id); 

        --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(Confirmed by EAC.-->Registered by EAC.)
        --TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Confirmed by EAC.','A','',in_user_ofc_cd,in_user_id);
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Registered by EAC.','A','',in_user_ofc_cd,in_user_id);

        -- 4) INSERT/UDPATE TPB_OTS_GRP_STS AND INSERT TPB_OTS_GRP_RCVR_ACT
        --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
        --TPB_ADD_OTS_GRP_STS_PRC(out_n3pty_no, 'O', in_user_id); 
        
        --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
        --TPB_ADD_OTS_GRP_RCVR_ACT_PRC(out_n3pty_no,'','Confirmed by EAC.','A','',in_user_ofc_cd,in_user_id);

                
    -----============ REGISTER AS GROUP CASE --------------------
    ELSIF ( in_reg_type = 'G' AND LENGTHB(in_n3pty_no) = 14 ) THEN 
    -- DBMS_OUTPUT.PUT_LINE('SQL Error : ' || 'in_reg_type==>' || in_reg_type || 'in_n3pty_no==>' || in_n3pty_no); 
        -- get Next ots_dtl_seq
        SELECT tpb_ots_dtl_seq1.NEXTVAL
          INTO v_ots_dtl_seq 
          FROM DUAL
        ; 
    
        -- INSERT INTO TPB_OTS_DTL
        INSERT INTO TPB_OTS_DTL (
            ots_dtl_seq, 
            n3pty_expn_tp_cd, n3pty_src_sub_sys_cd, eac_tp_cd, if_ofc_cd, 
            if_rhq_cd, 
            if_curr_cd, if_amt, 
          --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)  
          --cfm_curr_cd, cfm_amt, ots_amt, bal_amt,
            bkg_no, --bkg_no_split, bl_no_chk, 
            bl_no, -- bl_no_tp, 
            vsl_cd, 
            skd_voy_no, 
            skd_dir_cd, eq_knd_cd, eq_no, 
            eq_tpsz_cd, n3pty_src_no, so_no, vndr_cust_div_cd, vndr_cnt_cd, 
            vndr_seq, cust_cnt_cd, cust_seq, n3pty_ofc_cd, 
          --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
          --cfm_rmk, 
            n3pty_delt_tp_cd, file_no, cre_usr_id, n3pty_bil_tp_cd, 
          --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
          --cfm_dt, 
            cre_dt, upd_usr_id, upd_dt, vndr_lgl_eng_nm, 
            cust_lgl_eng_nm, src_vndr_cnt_cd, src_vndr_seq, yd_cd, 
            finc_dir_cd, 
            if_usr_id, if_dt, --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(added)
            n3pty_if_tp_cd, 
            n3pty_cfm_cd, 
          --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
          --cfm_usr_id, cfm_ofc_cd, 
            ofc_cd,
            estm_sys_area_grp_id --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(added)
        ) VALUES (
             v_ots_dtl_seq
           , in_n3pty_expn_tp_cd, in_n3pty_expn_tp_cd, in_eac_tp_cd, in_if_ofc_cd
           , TPB_GET_HNDL_OFC_FNC('R',TPB_GET_N3PTY_OFC_CD_FNC(in_if_ofc_cd))
           , in_curr_cd, in_if_amt 
         --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added) 
         --, in_curr_cd, in_if_amt, in_if_amt, in_if_amt
           , in_bkg_no --|| in_bkg_no_split--, in_bkg_no_split, in_bl_no_chk
           , in_bl_no --|| in_bl_no_chk || in_bl_no_tp--, in_bl_no_tp
           , DECODE(v_bkg_vsl_cd,NULL,in_vsl_cd,v_bkg_vsl_cd)
           , DECODE(v_bkg_skd_voy_no,NULL,in_skd_voy_no,v_bkg_skd_voy_no)
           , v_skd_dir_cd, in_eq_knd_cd, in_eq_no
           , in_eq_tpsz_cd, in_n3pty_src_no, in_so_no, in_vndr_cust_div_cd, in_vndr_cnt_cd
           , in_vndr_seq, in_cust_cnt_cd, in_cust_seq, in_n3pty_ofc_cd
         --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
         --, in_if_rmk
           , 'N', in_file_no, in_user_id, in_n3pty_bil_tp_cd
         --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
         --, NVL( 
         --     GLOBALDATE_PKG.TIME_CONV_FNC( GLOBALDATE_PKG.GET_LOCCD_FNC(in_user_ofc_cd),TO_DATE(in_dt,'YYYY-MM-DD HH24:MI'), 'GMT')+9/24, 
         --     TO_DATE(in_dt,'YYYY-MM-DD') 
         -- )
           , SYSDATE, in_user_id, SYSDATE, v_vndr_lgl_eng_nm
           , v_cust_lgl_eng_nm, in_src_vndr_cnt_cd, in_src_vndr_seq, in_yd_cd
         --, DECODE(v_bkg_finc_dir_cd,NULL,NULL,v_bkg_finc_dir_cd)
           , DECODE(v_bkg_finc_dir_cd,NULL,v_skd_dir_cd||v_skd_dir_cd,v_bkg_finc_dir_cd) --* 1.2 Modified : 2009-01-15  O Wan-Ki - TPB VVD Role
           , in_user_id, SYSDATE --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(added)
           , 'M'
           , 'I' --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.('Y' --> 'I')
         --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
         --, in_user_id, in_user_ofc_cd
           , TPB_GET_N3PTY_OFC_CD_FNC(in_if_ofc_cd)
           , in_sys_area_grp_id
        ); 
    
        -- get TPB No.
        out_n3pty_no := in_n3pty_no; 

        -- UPDATE TPB_OTS_DTL -- TPB NO
        --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
        /*
        UPDATE TPB_OTS_DTL 
           SET n3pty_no = out_n3pty_no, 
               n3pty_no_dp_seq = ( SELECT NVL(MAX(n3pty_no_dp_seq),0)+1 
                                     FROM TPB_OTS_DTL 
                                    WHERE n3pty_no = out_n3pty_no 
                                  )  
         WHERE ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq) 
        ;
        */

        ---- UPDATE INTO TPB_OTS_GRP 1
        --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
        /*
        UPDATE TPB_OTS_GRP B
           SET ( n3pty_expn_tp_cd, 
                 n3pty_bil_tp_cd, 
                 curr_cd
                ) = ( SELECT DECODE(B.n3pty_expn_tp_cd,K.n3pty_expn_tp_cd,B.n3pty_expn_tp_cd,'MIX') AS n3pty_expn_tp_cd, 
                             DECODE(B.n3pty_bil_tp_cd,K.n3pty_bil_tp_cd,B.n3pty_bil_tp_cd,'MX') AS n3pty_bil_tp_cd,  
                             DECODE(B.curr_cd,K.cfm_curr_cd,B.curr_cd,'MX') AS curr_cd 
                        FROM TPB_OTS_DTL K
                       WHERE 1=1 
                         AND ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq) 
                     )
         WHERE 1=1 
           AND n3pty_no = out_n3pty_no 
        ;
        */

        ---- UPDATE INTO TPB_OTS_GRP 2
        --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(comment added)
        /*
        UPDATE TPB_OTS_GRP B
           SET ( ots_amt, 
                 inv_amt, 
                 clt_amt, 
                 adj_amt, 
                 bal_amt, 
                 rev_amt  
                ) = ( SELECT NVL(B.ots_amt,0)+NVL(K.ots_amt,0) AS ots_amt, 
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
            AND n3pty_no = out_n3pty_no 
        ;
        */
        
        -- 3) INSERT/UPDATE TPB_OTS_DTL_STS AND INSERT TPB_OTS_DTL_RCVR_ACT
        TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'O', in_user_id); 

        --* 1.5 Modified : 2009-09-16  Sun CHOI - EAC 등록 처리 변경.(Confirmed by EAC.-->Registered by EAC.)
        --TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Confirmed by EAC.','A','',in_user_ofc_cd,in_user_id);
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Registered by EAC.','A','',in_user_ofc_cd,in_user_id);

        -- 4) INSERT/UDPATE TPB_OTS_GRP_STS AND INSERT TPB_OTS_GRP_RCVR_ACT
        --TPB_ADD_OTS_GRP_STS_PRC(out_n3pty_no, 'O', in_user_id); 
        --TPB_ADD_OTS_GRP_RCVR_ACT_PRC(out_n3pty_no,'','Confirmed by EAC.','A','',in_user_ofc_cd,in_user_id);

    END IF; -------------------------------------------------------------

--EXCEPTION
--    WHEN OTHERS THEN
--        out_err_msg := 'SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 

END
;