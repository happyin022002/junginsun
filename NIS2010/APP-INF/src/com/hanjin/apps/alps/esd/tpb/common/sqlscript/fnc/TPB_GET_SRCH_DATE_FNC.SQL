CREATE OR REPLACE FUNCTION NISADM.TPB_GET_SRCH_DATE_FNC

/*******************************************************************************
   1. Object Name      : TPB_GET_SRCH_DATE_FNC
   2. Version          : 1.1
   3. Create Date      : 2007.04.07
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : (TPB) GETTING LOCAL TIME WITH OFFICE CODE FOR SEARCH CONDITION
                         ------------------------------------------------------
                         SELECT TPB_GET_SRCH_DATE_FNC('2007-04-05','YYYY-MM-DD','NYCBB') FROM DUAL ; 
                         ------------------------------------------------------
   7. Revision History : 2007.04.07  Kim Jin-seung  1.0  Created
                         2009.08.14  Choi Sun       1.1  ALPS Migration
*******************************************************************************/

-- ===== Arguments ========================================
(   
    in_dateStr     in VARCHAR2, -- DATE VALUE String
    in_dateFormat  in VARCHAR2, -- DATE FORMAT String
    in_ofc_cd      in VARCHAR2  -- Local Office Code         
) 


RETURN DATE -- RETURN TYPE 
AUTHID CURRENT_USER
IS 

-- ===== DECLARE ==========================================
d_system_dateVal DATE; -- value to return 
n_svr_gmt_gap NUMBER(2); -- The Gap Between GMT Time And DB Server Local Time (Unit: hour)

-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles 
    d_system_dateVal := NULL; 
    n_svr_gmt_gap := 9; -- The Gap Between GMT Time And DB Server( Seoul Korea) Local Time (Unit: hour)
        -- Or We can use like under ... (USE OFFICE CODE WHICH DB SERVER LOCATED  ... )
        -- n_svr_gmt_gap := GLOBALDATE_PKG.GET_GMTHRS_FNC('SELHO')/60; 

    --- Getting (LOCAL TO SYSTEM DATE)
    SELECT GLOBALDATE_PKG.TIME_CONV_FNC( 
                GLOBALDATE_PKG.GET_LOCCD_FNC(in_ofc_cd),
                TO_DATE(in_dateStr,in_dateFormat) + ( n_svr_gmt_gap / 24 ), 
                'GMT'
           ) 
    INTO d_system_dateVal 
    FROM DUAL 
    ;

    --- Returning Result 
    RETURN d_system_dateVal; 

EXCEPTION
    WHEN OTHERS THEN
        RETURN NULL; --- Returning NULL     

END

-- ===== End of Function ==================================
;