CREATE OR REPLACE PACKAGE NISADM."TPB_ADJ_PKG"

IS

/*******************************************************************************
1. Object Name      : TPB_ADJ_PKG
2. Version          : 1.1
3. Create Date      : 2008.10.20
4. Sub System       : Third Party Billing
5. Author           : Sun, Choi
6. Description      : TPB Adjustment Package
                      -------------------------------------------------------
                      DECLARE 
                      BEGIN 
                         TPB_ADJ_PKG...1. (,,,,) ;
                         TPB_ADJ_PKG...2. (,,,,) ;
                         TPB_ADJ_PKG.GET_ROC_OUT_OFC_FNC() ;
                      END;
                      -------------------------------------------------------
7. Revision History : 2008.10.20  Kim Jin-seung  1.0  최초 생성
                      2009.10.01  Sun CHOI       1.1  ALPS Migration
                      2010.10.21  Jeong-Seon AN  1.2  ROC 2nd Review기능 추가
                      2012.05.17  Won-Joo CHO    1.3  [CHM-201216957] W/O reason 추가
                      2012.09.25 조원주 [CHM-201220286-01] [TPB-W/O] Reason RHQ W/O reason반영
*******************************************************************************/

    --- CREATE TPB ADJUSTMENT REQUEST 
    PROCEDURE CRE_ADJ_REQ_PRC(
        in_n3pty_no                 IN VARCHAR2,
        in_user_ofc_cd              IN VARCHAR2,
        in_user_id                  IN VARCHAR2,
        
        in_n3pty_stl_tp_cd          IN VARCHAR2,
        in_stl_rqst_rmk             IN VARCHAR2,
        in_stl_to_clt_cng_ofc_cd    IN VARCHAR2, 
        
        in_file_no                  IN VARCHAR2, 
        in_ra_rmk1                  IN VARCHAR2,    -- RECOVERY ACTIVITY 1
        in_ra_rmk2                  IN VARCHAR2,    -- RECOVERY ACTIVITY 2
        in_wrtf_rsn_cd              IN VARCHAR2     -- W/O reason
    );
    
    --- CREATE TPB ADJUSTMENT APPROVAL/REJECT 
    PROCEDURE CRE_ADJ_APP_PRC(
        in_action                   IN VARCHAR2,    -- Approval Action Type : ''(Null) / J / E
        in_n3pty_no                 IN VARCHAR2,    -- 3rd Party No. 
        in_req_amt                  IN NUMBER,      -- Request Amount  Amount ( not used, bal_amt or roc_amt instead of this )
        in_stl_fwrd_ofc_cd          IN VARCHAR2,    -- Adjustment Forward Office Code 
        in_stl_cpy_ofc_cd           IN VARCHAR2,    -- Adjustment Copy Office Code 
        in_stl_rmk                  IN VARCHAR2,    -- Remarks 
        in_user_ofc_cd              IN VARCHAR2,    -- user office code  
        in_user_id                  IN VARCHAR2,    -- user id 

        in_file_no                  IN VARCHAR2, 
        in_ra_rmk                   IN VARCHAR2,    -- RECOVERY ACTIVITY  
        in_n2nd_rvw_flg             IN VARCHAR2,     -- Second Review : 'Y' / 'N' 
        in_wrtf_rsn_cd              IN VARCHAR2     -- W/O reason
    );

    --- REMOVE TPB ADJUSTMENT REQUEST 
    PROCEDURE DEL_ADJ_REQ_PRC(
        in_n3pty_no                 IN VARCHAR2,    -- 3rd Party No. 
        in_user_ofc_cd              IN VARCHAR2,    -- user office code  
        in_user_id                  IN VARCHAR2     -- user id 
    );
    
    --- GET ROC-IN OFFICE (ROC)
    FUNCTION GET_ROC_IN_OFC_FNC(
        in_n3pty_no                 IN VARCHAR2 
    )
    RETURN VARCHAR2
    ;

    --- GET ROC-OUT OFFICE (ROC)
    FUNCTION GET_ROC_OUT_OFC_FNC(
        in_n3pty_no                 IN VARCHAR2 
    )
    RETURN VARCHAR2
    ;

    
END

-- ===== End of Pakage ==================================
;