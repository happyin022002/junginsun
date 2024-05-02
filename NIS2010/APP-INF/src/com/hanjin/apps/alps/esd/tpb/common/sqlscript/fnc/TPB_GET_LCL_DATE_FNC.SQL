CREATE OR REPLACE FUNCTION NISADM.TPB_GET_LCL_DATE_FNC

/*******************************************************************************
   1. Object Name      : TPB_GET_LCL_DATE_FNC
   2. Version          : 1.1
   3. Create Date      : 2007.04.05
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : (TPB) GETTING LOCAL TIME WITH OFFICE CODE 
   7. Revision History : 2007.04.05  Kim Jin-seung  1.0  Created
                         2009.08.31  Park Sung-Jin  1.1  ALPS Migration
   * ex) 
     SELECT TPB_GET_LCL_DATE_FNC(SYSDATE,'NYCBB') FROM DUAL ; 
*******************************************************************************/

-- ===== Arguments ========================================
(   
    in_dateVal     in DATE,     -- DATE VALUE 
    in_ofc_cd      in VARCHAR2  -- Local Office code     
) 


RETURN DATE -- RETURN TYPE 
AUTHID CURRENT_USER
IS 

-- ===== DECLARE ==========================================
d_local_dateVal DATE; -- value to return 
n_svr_gmt_gap NUMBER(2); -- The Gap Between GMT Time And DB Server Local Time (Unit: hour)

-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles 
    d_local_dateVal := NULL; 
    n_svr_gmt_gap := 9; -- The Gap Between GMT Time And DB Server( Seoul Korea) Local Time (Unit: hour)
        -- Or We can use like under ... (USE OFFICE CODE WHICH DB SERVER LOCATED  ... )
        -- n_svr_gmt_gap := GLOBALDATE_PKG.GET_GMTHRS_FNC('SELHO')/60; 

    --- Getting ofc_cd
    SELECT GLOBALDATE_PKG.TIME_CONV_FNC( 
                'GMT', 
                in_dateVal - ( n_svr_gmt_gap / 24 ), 
                GLOBALDATE_PKG.GET_LOCCD_FNC(in_ofc_cd)
           ) 
    INTO d_local_dateVal
    FROM DUAL
    ;



    --- Returning Result 
    RETURN d_local_dateVal; 

END

-- ===== End of Function ==================================
;