CREATE OR REPLACE PACKAGE NISADM.TPB_INV_CANCEL_PKG 
AUTHID CURRENT_USER 
IS 
/******************************************************************************* 
   1. Object Name      : TPB_INV_CANCEL_PKG 
   2. Version          : 1.3 
   3. Create Date      : 2008.12.05 
   4. Sub System       : TPB 
   5. Author           : Sun, CHOI 
   6. Description      : TPB Invoice Cancel Pakage 
                         ------------------------------------------------------ 
                         DECLARE  
 
                         BEGIN  
                            TPB_INV_CANCEL_PKG...1. (,,,,) ; 
                            TPB_INV_CANCEL_PKG...2. (,,,,) ; 
                            TPB_INV_CANCEL_PKG...3. (,,,,) ; 
                         END;  
                         ------------------------------------------------------ 
   7. Revision History : 2008.10.06  Kim Jin-seung  1.0  Created 
                         2008.12.05  Kim Jin-seung  1.1  Add PRC UPD_OTS_GRP_RMK_INFO, UPD_OTS_DTL_RMK_INFO 
                         2009.10.26  Park Sung-Jin  1.2  ALPS Migration 
                         2010.01.08  Sun, CHOI      1.3  EQ_TP_CD -> EQ_KND_CD 전환 
                         2015.11-12  KIm Hyun-hwa       India SBC 금액정보 추가 
                         2016.05-19  KIm Hyun-hwa       India KKC 금액정보 추가 2016.06.01 적용 
                         2016.05-26  KIm Hyun-hwa       Microsoft  EDI 전송용 Load Id 추가(5/31적용) 
                         2016.07-18  Song Jeong-In      Billing Type Code 별 Add Amount 추가(VGM) 
*******************************************************************************/ 
 
    --- UPDATE TPB INVOICE MAIN, REVISION DATA  
    PROCEDURE UPD_INV_RVIS( 
        in_user_ofc_cd           IN VARCHAR2, 
        in_user_id          IN VARCHAR2, 
         
        in_n3pty_no        IN VARCHAR2, 
        in_n3pty_inv_no    IN VARCHAR2, 
        in_n3pty_inv_rvis_seq IN VARCHAR2, 
        in_remark           IN VARCHAR2, 
     
        out_n3pty_inv_no    OUT VARCHAR2, -------- 
        out_new_creditnote_seq OUT VARCHAR2, -------- credit note  
        out_new_creditnote_cd OUT VARCHAR2 -------- credit note  
    ); 
     
 
    --- UPDATE Outstanding Group Data  
    PROCEDURE UPD_OTS_GRP_INFO( 
        in_n3pty_no         IN VARCHAR2, 
        in_n3pty_inv_no     IN VARCHAR2, 
     
        in_new_creditnote_seq IN VARCHAR2, -------- credit note  
        in_new_creditnote_cd IN VARCHAR2, -------- credit note  
     
        in_user_ofc_cd      IN VARCHAR2, 
        in_user_id          IN VARCHAR2 
    ); 
 
    --- UPDATE Outstanding Group Data with Remark 
    PROCEDURE UPD_OTS_GRP_RMK_INFO( 
        in_n3pty_no         IN VARCHAR2, 
        in_n3pty_inv_no     IN VARCHAR2, 
     
        in_new_creditnote_seq IN VARCHAR2, -------- credit note  
        in_new_creditnote_cd IN VARCHAR2, -------- credit note  
     
        in_user_ofc_cd      IN VARCHAR2, 
        in_user_id          IN VARCHAR2,  
         
        in_remark           IN VARCHAR2 
    ); 
     
    --- UPDATE Outstanding Detail Data  
    PROCEDURE UPD_OTS_DTL_INFO( 
        in_n3pty_no         IN VARCHAR2, 
        in_n3pty_inv_no     IN VARCHAR2, 
     
        in_new_creditnote_seq IN VARCHAR2, -------- credit note  
        in_new_creditnote_cd IN VARCHAR2, -------- credit note  
     
        in_user_ofc_cd      IN VARCHAR2, 
        in_user_id          IN VARCHAR2 
    ); 
 
    --- UPDATE Outstanding Detail Data with Remark 
    PROCEDURE UPD_OTS_DTL_RMK_INFO( 
        in_n3pty_no         IN VARCHAR2, 
        in_n3pty_inv_no     IN VARCHAR2, 
     
        in_new_creditnote_seq IN VARCHAR2, -------- credit note  
        in_new_creditnote_cd IN VARCHAR2, -------- credit note  
     
        in_user_ofc_cd      IN VARCHAR2, 
        in_user_id          IN VARCHAR2,  
         
        in_remark           IN VARCHAR2 
    ); 
 
END 
 
-- ===== End of Pakage ================================== 
;