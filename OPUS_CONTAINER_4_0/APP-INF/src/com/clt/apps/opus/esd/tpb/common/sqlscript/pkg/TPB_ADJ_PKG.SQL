CREATE OR REPLACE PACKAGE OPUSADM.TPB_ADJ_PKG

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
7. Revision History : 2008.10.20 김진승  최초 생성
                      2009.10.01 최  선   Migration
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
        in_ra_rmk2                  IN VARCHAR2     -- RECOVERY ACTIVITY 2
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
        in_ra_rmk                   IN VARCHAR2     -- RECOVERY ACTIVITY  
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

GRANT EXECUTE ON OPUSADM.TPB_ADJ_PKG TO OPUSDEV;
GRANT EXECUTE ON OPUSADM.TPB_ADJ_PKG TO OPUS_ROLE;