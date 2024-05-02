CREATE OR REPLACE PROCEDURE NISADM.TPB_MODIFY_OTS_DTL_PRC

/*******************************************************************************
1. Object Name      : TPB_MODIFY_OTS_DTL_PRC
2. Version          : 1.4
3. Create Date      : 2008.09.23
4. Sub System       : Third Party Billing
5. Author           : Sun, Choi
6. Description      : TPB Modification
                      -------------------------------------------------------
                      DECLARE 
                      BEGIN 
                          TPB_MODIFY_OTS_DTL_PRC() ;
                      END;
                      -------------------------------------------------------
7. Revision History : 2008.10.02  O Wan-Ki       1.0  최초 생성
                      2008.11.19  O Wan-Ki       1.1
                      2009.01.15  O Wan-Ki       1.2  VVD 9DIGIT
                      2009.08.28  O Wan-Ki       1.3  FINC_DIR_CD 1length 오류패치
                      2009.09.09  Sun CHOI       1.4  ALPS Migration
*******************************************************************************/


-- ===== Arguments ========================================
(
    v_ots_dtl_seq           IN TPB_OTS_DTL.ots_dtl_seq%TYPE --key : tpb_ots_dtl
    ,v_n3pty_no             IN TPB_OTS_DTL.n3pty_no%TYPE    --key : tpb_ots_grp
    ,n3pty_no_dp_seq        IN TPB_OTS_DTL.n3pty_no%TYPE    --change only 1 in n3pty_no_dp_seq
    ,v_user_ofc_cd          IN VARCHAR2
    ,v_user_id              IN VARCHAR2
    
    ,v_eq_no                IN VARCHAR2
    ,v_bkg_no               IN VARCHAR2
  --,v_bkg_no_split         IN VARCHAR2
    ,v_bl_no                IN VARCHAR2
  --,v_bl_no_tp             IN VARCHAR2
    
  --,v_bl_no_chk            IN VARCHAR2    
    ,v_vsl_cd               IN VARCHAR2
    ,v_skd_voy_no           IN VARCHAR2
    ,v_finc_dir_cd          IN VARCHAR2
    ,v_vvd_cd               IN VARCHAR2
    
    ,v_vndr_cust_div_cd     IN VARCHAR2
    ,v_vndr_seq             IN VARCHAR2
    ,v_cust_cnt_cd          IN VARCHAR2
    ,v_cust_seq             IN VARCHAR2
    ,v_n3pty_ofc_cd         IN VARCHAR2
  --,v_curr_cd				IN VARCHAR2
  --,v_cfm_amt				IN VARCHAR2
)
authid CURRENT_USER
IS

-- ===== DECLARE ===========================================
	
	v_n3pty_bil_tp_cd		TPB_OTS_DTL.n3pty_bil_tp_cd%TYPE;
	v_isvalid               NUMBER(2);
	m_finc_dir_cd           VARCHAR2(2);  /* 2009-08-28 */

-- ===== BEGIN, EXCEPTION and END ==========================
BEGIN

    -- 1.Validation Check ----------------------------------
    v_isvalid := 1;
    -- 1.1.Is Invoiced
    SELECT COUNT(0)*v_isvalid
      INTO v_isvalid
      FROM TPB_OTS_GRP
     WHERE 1=1
       AND n3pty_no = v_n3pty_no
       AND n3pty_inv_no IS NULL
       AND n3pty_delt_tp_cd = 'N'
    ;

    -- 2.UPDATE --------------------------------------------
    IF v_isvalid = 1 THEN 

    	v_n3pty_bil_tp_cd := NULL;
    	
    	SELECT n3pty_bil_tp_cd
    	  INTO v_n3pty_bil_tp_cd
    	  FROM TPB_OTS_DTL
    	 WHERE ots_dtl_seq = v_ots_dtl_seq
    	;
    	
    	m_finc_dir_cd := v_finc_dir_cd;
    	
    	IF LENGTH(v_finc_dir_cd) = 1 THEN 
    	   m_finc_dir_cd := v_finc_dir_cd || v_finc_dir_cd;
    	END IF;
    	
--    	IF v_n3pty_bil_tp_cd != 'JO' THEN

    	-- 2.1.UPDATE TPB_OTS_DTL
    		UPDATE TPB_OTS_DTL
    		   SET upd_usr_id 		= v_user_id
    	          ,upd_dt 			= SYSDATE 
    			  ,bkg_no			= v_bkg_no			
    			--,bkg_no_split		= v_bkg_no_split	    
    			  ,bl_no            = v_bl_no             
    			--,bl_no_tp         = v_bl_no_tp          
    			--,bl_no_chk        = v_bl_no_chk         
    			  ,vsl_cd     		= v_vsl_cd     	    
    			  ,skd_voy_no		= v_skd_voy_no
    			--,finc_dir_cd		= v_finc_dir_cd /* 2009-08-28 */
    			  ,finc_dir_cd		= m_finc_dir_cd /* 2009-08-28 */
				--,skd_dir_cd	    = SUBSTR(v_finc_dir_cd,1,1) /* 2009-08-28 */--* 1.2 Modified : 2009-01-15 O Wan-Ki - VVD 9DIGIT
                  ,skd_dir_cd		= SUBSTR(m_finc_dir_cd,1,1) /* 2009-08-28 */
    			  ,eq_no			= v_eq_no
    			  ,vndr_cust_div_cd	= v_vndr_cust_div_cd
    			  ,vndr_seq			= DECODE(v_vndr_cust_div_cd, 'V', v_vndr_seq, NULL)
    			  ,vndr_lgl_eng_nm	= DECODE(v_vndr_cust_div_cd, 'V', TPB_GET_3RD_PARTY_NAME_FNC(v_vndr_cust_div_cd,v_vndr_seq),NULL)
    			  ,cust_cnt_cd		= DECODE(v_vndr_cust_div_cd, 'C', v_cust_cnt_cd, NULL)
    			  ,cust_seq			= DECODE(v_vndr_cust_div_cd, 'C', v_cust_seq, NULL)
    			  ,cust_lgl_eng_nm 	= DECODE(v_vndr_cust_div_cd, 'C', TPB_GET_3RD_PARTY_NAME_FNC(v_vndr_cust_div_cd,v_cust_cnt_cd||v_cust_seq),NULL)
    			  ,n3pty_ofc_cd		= DECODE(v_vndr_cust_div_cd, 'S', v_n3pty_ofc_cd, NULL)   				
                --,curr_cd			= v_curr_cd
                --,cfm_amt			= TO_NUMBER(v_cfm_amt)
                --,ots_amt 			= TO_NUMBER(v_cfm_amt)
                --,bal_amt 			= TO_NUMBER(v_cfm_amt)
                --,rev_amt 			= NVL(v_cfm_amt,0.0) - NVL(if_amt,0.0)				
    		 WHERE 1=1
    		   AND ots_dtl_seq     = TO_NUMBER( v_ots_dtl_seq )
    		;

        -- 2.2.UPDATE TPB_OTS_GRP
            UPDATE TPB_OTS_GRP
               SET vsl_cd     		= v_vsl_cd     	    
    			  ,skd_voy_no		= v_skd_voy_no		                    
--    			  ,finc_dir_cd		= v_finc_dir_cd /* 2009-08-28 */ 
                  ,finc_dir_cd		= m_finc_dir_cd /* 2009-08-28 */
    			  ,vndr_cust_div_cd	= v_vndr_cust_div_cd
    			  ,vndr_seq			= DECODE(v_vndr_cust_div_cd, 'V', v_vndr_seq, NULL)
    			  ,cust_cnt_cd		= DECODE(v_vndr_cust_div_cd, 'C', v_cust_cnt_cd, NULL)
    			  ,cust_seq			= DECODE(v_vndr_cust_div_cd, 'C', v_cust_seq, NULL)
    			  ,n3pty_ofc_cd		= DECODE(v_vndr_cust_div_cd, 'S', v_n3pty_ofc_cd, NULL)
             WHERE 1=1
               AND n3pty_no = v_n3pty_no
            ;
               
--    	END IF; --IF v_n3pty_bil_tp_cd = 'JO' THEN
    	
    	-- 2.3.INSERT/UPDATE TPB_OTS_DTL_STS AND INSERT TPB_OTS_DTL_RCVR_ACT
        TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Modified.','A','',v_user_ofc_cd,v_user_id);
 
        -- 2.4.INSERT/UDPATE TPB_OTS_GRP_STS AND INSERT TPB_OTS_GRP_RCVR_ACT
        IF n3pty_no_dp_seq = 1 THEN
            TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'','Modified.','A','',v_user_ofc_cd,v_user_id);
        END IF;

    END IF; --IF ( v_isvalid = 1 ) THEN
    
--EXCEPTION
--    WHEN OTHERS THEN
--        v_n3pty_no := NULL;
--        v_ots_dtl_seq := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  

END

-- ===== End of Procedure ==================================
;