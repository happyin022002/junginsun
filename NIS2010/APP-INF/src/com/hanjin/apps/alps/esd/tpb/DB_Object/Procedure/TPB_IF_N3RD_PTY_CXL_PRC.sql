CREATE OR REPLACE PROCEDURE NISADM.TPB_IF_N3RD_PTY_CXL_PRC

/*******************************************************************************
   1. Object Name      : TPB_IF_N3RD_PTY_CXL_PRC
   2. Version          : 1.1
   3. Create Date      : 2009.04.07
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : Interfaced TPB Cancelation
                         ------------------------------------------------------
                         DECLARE 
                             v_n3pty_no VARCHAR2(11); 
                         BEGIN 
                             TPB_IF_N3RD_PTY_CXL_PRC();
                             DBMS_OUTPUT.PUT_LINE('3rd Party TPB No. : ' || v_n3pty_no);
                         END;
                         ------------------------------------------------------
   7. Revision History : 2009.04.07  O Wan-Ki  1.0  Creation
                         2009.08.27  O Wan-Ki  1.1  ALPS Migration
*******************************************************************************/

-- ===== Arguments ========================================
(
     in_usr_ofc_cd           IN VARCHAR2
    ,in_usr_id               IN VARCHAR2
    ,in_ofc_cd               IN VARCHAR2
    ,in_cxl_seq              IN VARCHAR2
    ,in_org_seq              IN VARCHAR2
    ,isNoticeOnly            IN VARCHAR2
)
authid CURRENT_USER
IS

-- ===== DECLARE ==========================================
    
     v_isvalid                  NUMBER(2);
     v_n3pty_no                 VARCHAR2(14);
     v_n3pty_inv_no             VARCHAR2(11);
     v_grp_cnt                  NUMBER(2);
     v_rhq_cd                   VARCHAR2(6);

-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN
    --########################### 1.Start - Validation Check ###########################
     v_isvalid := 1;
    
IF isNoticeOnly = '0' THEN

    --1.1.Data Existance
        --1.1.1.Cancel Flag
        SELECT count(1) * v_isvalid
          INTO v_isvalid
          FROM TPB_OTS_DTL d
         WHERE d.n3pty_delt_tp_cd = 'N'
           AND d.ots_dtl_seq = in_cxl_seq
           AND d.cxl_flg = 'Y';

        --1.1.2.Original Candidate
        IF v_isvalid = 1 AND in_org_seq IS NOT NULL THEN
            SELECT count(1) * v_isvalid
              INTO v_isvalid
              FROM TPB_OTS_DTL d
             WHERE d.n3pty_delt_tp_cd = 'N'
               AND d.ots_dtl_seq = in_org_seq
               AND d.cxl_flg IS NULL;
        END IF;
        
    
    --1.2.Office Privilege
    
        IF v_isvalid = 1 AND in_org_seq IS NOT NULL THEN
        
            --1.2.2.Remove Privilege for Candidate
            SELECT count(1) * v_isvalid
              INTO v_isvalid
              FROM TPB_OTS_DTL d
             WHERE d.cxl_flg IS NULL
               AND d.ofc_cd = in_usr_ofc_cd
               AND d.ots_dtl_seq = in_org_seq;
            
        END IF;
    ----------------------------- 1.End - Validation Check ---------------------------
    
    
    
    
    
    
    --########################### 2.Start Removing Process ###########################
    
    
    --2.1.Remove
    
        IF v_isvalid =1 THEN
                
            --save values
            SELECT n3pty_no
              INTO v_n3pty_no
              FROM tpb_ots_dtl
             WHERE ots_dtl_seq = in_org_seq;
            
            SELECT count(1)
              INTO v_grp_cnt
              FROM tpb_ots_dtl
             WHERE n3pty_no = v_n3pty_no;
            
            IF v_n3pty_no IS NOT NULL THEN
                SELECT n3pty_inv_no
                  INTO v_n3pty_inv_no
                  FROM tpb_ots_grp
                 WHERE n3pty_no = v_n3pty_no;
            END IF;
            
            --2.1.1.Remove - Cancel Flag
            UPDATE tpb_ots_dtl
               SET n3pty_delt_tp_cd = 'D' 
             WHERE cxl_flg = 'Y' 
               AND ots_dtl_seq = in_cxl_seq;
              

            
            --2.1.1.1.Add Recovery Activities
            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',in_cxl_seq,'','Deleted with '||in_org_seq,'A','',in_usr_ofc_cd,in_usr_id);
            
            
            
            
            --2.1.2.Remove - Original Candidate
            IF in_org_seq IS NOT NULL THEN
                
                UPDATE tpb_ots_dtl
                   SET n3pty_cfm_cd = 'N'
                      ,n3pty_non_cfm_rsn_cd = 'CN'
                      ,cfm_rmk = 'S/O Canceled'
                      ,n3pty_no = '' 
                 WHERE cxl_flg IS NULL 
                   AND ots_dtl_seq = in_org_seq;
                    
                SELECT DISTINCT rhq_cd 
                  INTO v_rhq_cd
                  FROM tpb_hndl_ofc
                 WHERE rhq_cd IS NOT NULL 
                   AND ofc_cd = (
                                   SELECT DECODE(ofc_cd,NULL,if_ofc_cd,ofc_cd)
                                     FROM tpb_ots_dtl
                                    WHERE ots_dtl_seq = in_org_seq
                                );
                
                --Add recovery Activities
                TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',in_org_seq,'','Non-confirm Requested to '||v_rhq_cd,'A','',in_usr_ofc_cd,in_usr_id);
                
            END IF;
            
            
            
            
            
            --2.1.3.Remove - Group
            IF v_n3pty_no IS NOT NULL AND v_grp_cnt = 1 AND v_n3pty_inv_no IS NULL THEN
            
                UPDATE tpb_ots_grp
                   SET n3pty_delt_tp_cd = 'D' 
                 WHERE n3pty_no = v_n3pty_no;
                


                --Add recovery Activities
                TPB_ADD_OTS_GRP_RCVR_ACT_PRC(v_n3pty_no,'','Deleted by S/O Cancel','A','',in_usr_ofc_cd,in_usr_id);
                
            END IF;
            
        END IF;

ELSIF isNoticeOnly = '1' THEN
    
    
    --1.1.Data Existance
    --1.1.1.Cancel Flag
    ----------------------------- Start - Validation Check -------------------------
    
        SELECT count(1) * v_isvalid
          INTO v_isvalid
          FROM TPB_OTS_DTL d
         WHERE d.n3pty_delt_tp_cd = 'N'
           AND d.ots_dtl_seq = in_cxl_seq
           AND d.cxl_flg = 'Y';

    ----------------------------- End - Validation Check ---------------------------
    
    

       --######### Only Cancel Flag Delete ########### 
        IF v_isvalid =1 THEN

            UPDATE tpb_ots_dtl
               SET n3pty_delt_tp_cd = 'D' 
             WHERE cxl_flg = 'Y' 
               AND ots_dtl_seq = in_cxl_seq;


            TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',in_cxl_seq,'','Deleted without '||in_org_seq,'A','',in_usr_ofc_cd,in_usr_id);
        
        END IF;
    
END IF;


--EXCEPTION
--    WHEN OTHERS THEN
--        v_n3pty_no := NULL;
--        v_ots_dtl_seq := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );  

END

-- ===== End of Procedure ==================================
;