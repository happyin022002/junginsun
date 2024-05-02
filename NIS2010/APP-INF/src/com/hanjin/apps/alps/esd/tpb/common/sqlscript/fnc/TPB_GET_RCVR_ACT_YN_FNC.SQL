CREATE OR REPLACE FUNCTION NISADM.TPB_GET_RCVR_ACT_YN_FNC

/*******************************************************************************
   1. Object Name      : TPB_GET_RCVR_ACT_YN_FNC
   2. Version          : 1.1
   3. Create Date      : 2008.09.25
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : 3rd Party Collection Active Count Y/N (1/0)
                         ------------------------------------------------------
                         SELECT TPB_GET_RCVR_ACT_YN_FNC() FROM DUAL ;
                         ------------------------------------------------------
   7. Revision History : 2008.09.25  Kim Jin-seung  1.0  Created
                         2009.08.14  Choi Sun       1.1  ALPS Migration
*******************************************************************************/

-- ===== Arguments ========================================
(
    v_n3pty_no      IN VARCHAR2 -- 3rd Party No.
--    , v_ots_dtl_seq   IN VARCHAR2  -- Outstanding Deatil Seq
)


RETURN NUMBER -- RETURN TYPE
AUTHID CURRENT_USER
IS

-- ===== DECLARE ==========================================
    rcvr_act_yn  NUMBER(1);     -- USD AMOUNTS (CHANGED)


-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    --- Initiate varibles
    rcvr_act_yn := 0;

    --- Getting  Collection Active Count Y/N (1/0)
    SELECT
        ( SELECT COUNT(*) 
          FROM TPB_OTS_GRP_RCVR_ACT t 
          WHERE t.n3pty_no=v_n3pty_no 
            AND n3pty_clt_rmk_tp_cd='M' 
            AND ROWNUM=1 
        ) AS rcvr_act_yn
    INTO rcvr_act_yn
    FROM DUAL
    ;

    --- Returning Result
    RETURN rcvr_act_yn;

END

-- ===== End of Function ==================================
;