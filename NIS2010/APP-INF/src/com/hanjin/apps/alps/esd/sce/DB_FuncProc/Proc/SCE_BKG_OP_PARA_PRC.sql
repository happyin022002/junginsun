CREATE OR REPLACE PROCEDURE SCE_BKG_OP_PARA_PRC
(
    IN_BKG_RCV_DT     IN VARCHAR2,
    IN_BKG_RCV_NO     IN VARCHAR2,
    IN_PARA_SEQ       IN VARCHAR2,
    IN_PARA_STR       IN VARCHAR2  -- parameter 가 array 였을 경우 param[0], param[1] 의 형태로 입력
)
authid current_user 
IS
/*******************************************************************************
   1. Object Name      : SCE_BKG_OP_PARA_PRC
   2. Version          : 1.0
   3. Create Date      : 2009.10.16
   4. Sub System       : SCE
   5. Author           : 김인수
   6. Description      : Booking operation 의 parameter 관리
   7. Revision History : 2009.10.16 김인수 최초 생성
                                                2010.02.10 김인수 commit 삭제
*******************************************************************************/

BEGIN
    INSERT INTO SCE_BKG_OP_PARA
    (
        BKG_RCV_DT,
        BKG_RCV_NO,
        BKG_PARA_SEQ,
        BKG_PARA_SUB_SEQ,
        BKG_PARA_CTNT,
        CRE_USR_ID,
        CRE_DT,
        UPD_USR_ID,
        UPD_DT
              
    )
    SELECT
        IN_BKG_RCV_DT,
        IN_BKG_RCV_NO,
        IN_PARA_SEQ,
        ROWNUM AS BKG_PARA_SUB_SEQ,
        COLUMN_VALUE AS BKG_PARA_CTNT,
        'SYSTEM',
        SYSDATE,
        'SYSTEM',
        SYSDATE
     FROM TABLE (SCE_STR_SPLIT_FNC(IN_PARA_STR, ',')) ;

    --COMMIT
  
EXCEPTION
    WHEN OTHERS
    THEN
        ROLLBACK;
        
        RAISE PROGRAM_ERROR;
END;
/
