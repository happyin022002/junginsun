CREATE OR REPLACE PROCEDURE NISADM.TPB_ADD_OTS_GRP_STS_PRC

/*******************************************************************************
1. Object Name      : TPB_ADD_OTS_GRP_STS_PRC
2. Version          : 1.2
3. Create Date      : 2008.09.22
4. Sub System       : Third Party Billing
5. Author           : Sun, Choi
6. Description      : TPB_ADJ_STS 테이블의 상태 추가 및
                      TPB_OTS_GRP 테이블의 OTS_STS_CD 컬럼에 상태코드 Merge 처리
                      -------------------------------------------------------
                      DECLARE 
                      BEGIN 
                          TPB_ADD_OTS_GRP_STS_PRC(:n3pty_no,:ots_sts_cd,:usr_id) ;
                      END;
                      -------------------------------------------------------
7. Revision History : 2008.09.22  Kim Jin-seung  1.0  Creation
                      2009.08.27  O Wan-Ki       1.1  ALPS Migration
                      2009.08.27  O Wan-Ki       1.2  TPB_OTS_GRP 테이블의 OTS_STS_CD 컬럼에 최종상태코드 갱신 로직추가 
*******************************************************************************/

-- ===== Arguments ========================================
( 
    v_n3pty_no  IN VARCHAR2   --- key
    ,v_ots_sts_cd  IN VARCHAR2   --- status code 
    ,v_user_id      IN VARCHAR2   --- user id
) 
AUTHID CURRENT_USER
IS 

-- ===== DECLARE ==========================================


-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

    --- Initiate varibles 

    ---  1) INSERT TPB_OTS_GRP_STS
    INSERT INTO TPB_OTS_GRP_STS (
        n3pty_no, ots_sts_seq, ots_sts_cd, ots_sts_lst_flg, ots_sts_cre_dt, 
        cre_usr_id, cre_dt, upd_usr_id, upd_dt
    ) 
    SELECT 
        v_n3pty_no, 
        ( SELECT NVL(MAX(ots_sts_seq),0)+1 
          FROM TPB_OTS_GRP_STS 
          WHERE n3pty_no = v_n3pty_no  
        ),
        v_ots_sts_cd, '+', SYSDATE, 
        v_user_id, SYSDATE, v_user_id, SYSDATE 
    FROM DUAL
    ;
    
    ---  2) UPDATE TPB_OTS_GRP_STS
    UPDATE TPB_OTS_GRP_STS 
    SET ots_sts_lst_flg = DECODE(ots_sts_lst_flg,'Y','N','+','Y',ots_sts_lst_flg), 
        upd_usr_id = v_user_id, 
        upd_dt = SYSDATE
    WHERE n3pty_no = v_n3pty_no 
        AND ots_sts_lst_flg IN ('Y','+')
    ;
    
    ---  3) UPDATE TPB_OTS_GRP:OTS_STS_CD : 2009.08.27
    UPDATE tpb_ots_grp
    SET ots_sts_cd = v_ots_sts_cd
    WHERE n3pty_no = v_n3pty_no
    ;

--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_inv_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
     

END

-- ===== End of Procedure ==================================
;