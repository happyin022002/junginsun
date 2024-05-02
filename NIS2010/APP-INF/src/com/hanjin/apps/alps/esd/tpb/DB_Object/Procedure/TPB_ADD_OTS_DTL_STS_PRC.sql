CREATE OR REPLACE PROCEDURE NISADM.TPB_ADD_OTS_DTL_STS_PRC

 /*******************************************************************************
   1. Object Name      : TPB_ADD_OTS_DTL_STS_PRC
   2. Version          : 1.1
   3. Create Date      : 2008.09.22
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : Add New Outstanding Detail Status
                         -------------------------------------------------------
                         DECLARE 

                         BEGIN 
                             TPB_ADD_OTS_DTL_STS_PRC('1','O','user id') ;
                         END; 
                         -------------------------------------------------------
   7. Revision History : 2008.09.22  Kim Jin-seung  1.0  Created
                         2009.08.10  Park Sung-Jin  1.1  ALPS Migration
 *******************************************************************************/

-- ===== Arguments ========================================
( 
    v_ots_dtl_seq  IN VARCHAR2   --- key
   ,v_ots_sts_cd  IN VARCHAR2   --- status code 
   ,v_user_id      IN VARCHAR2   --- user id
)

authid CURRENT_USER

IS 

-- ===== DECLARE ==========================================


-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

    --- Initiate varibles 

    ---  1) INSERT TPB_OTS_DTL_STS
    INSERT INTO TPB_OTS_DTL_STS (
        ots_dtl_seq, ots_dtl_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt, 
        cre_usr_id, cre_dt, upd_usr_id, upd_dt
    ) 
    SELECT 
        TO_NUMBER(v_ots_dtl_seq), 
        ( SELECT NVL(MAX(ots_dtl_sts_seq),0)+1 
          FROM TPB_OTS_DTL_STS 
          WHERE ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq) 
        ),
        v_ots_sts_cd, '+', SYSDATE, 
        v_user_id, SYSDATE, v_user_id, SYSDATE 
    FROM DUAL
    ;
    
    ---  2) INSERT TPB_OTS_DTL_STS
    UPDATE TPB_OTS_DTL_STS 
    SET ots_sts_lst_flg = DECODE(ots_sts_lst_flg,'Y','N','+','Y',ots_sts_lst_flg), 
        upd_usr_id = v_user_id, 
        upd_dt = SYSDATE
    WHERE ots_dtl_seq = TO_NUMBER(v_ots_dtl_seq)
        AND ots_sts_lst_flg IN ('Y','+')
    ;            


--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_inv_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END

-- ===== End of Procedure ==================================
;