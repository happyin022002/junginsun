CREATE OR REPLACE PROCEDURE SCE_BKG_OP_HIS_PRC
(
    IN_BKG_RCV_DT     IN VARCHAR2,
    IN_BKG_RCV_NO     IN VARCHAR2,
    IN_BKG_NO         IN VARCHAR2,
    IN_CNTR_NO        IN VARCHAR2,
    IN_BKG_EVNT_TP_CD IN VARCHAR2,
    IN_BKG_EVNT_RMK   IN VARCHAR2,
    IN_PCTL_NO        IN VARCHAR2,
    IN_TRO_SEQ        IN VARCHAR2,
    IN_TRO_SUB_SEQ    IN VARCHAR2,
    IN_IO_BND_CD      IN VARCHAR2,
    IN_CONTI_CD       IN VARCHAR2,
    IN_PRT_FLG        IN VARCHAR2
)
authid current_user 
IS
/******************************************************************************
  1.Name       : 김인수
  2.Create Date: 2009-10-15
  3.Description: 
      - 용도: COP Booking operation history 관리
      - 파라미터:     IN_BKG_RCV_DT     IN VARCHAR2,
                    IN_BKG_RCV_NO     IN VARCHAR2,
                    IN_BKG_NO         IN VARCHAR2,
                    IN_BKG_EVNT_DT    IN VARCHAR2,
                    IN_CNTR_NO        IN VARCHAR2,
                    IN_BKG_EVNT_TP_CD IN VARCHAR2,
                    IN_BKG_EVNT_RMK   IN VARCHAR2,
                    IN_PCTL_NO        IN VARCHAR2,
                    IN_TRO_SEQ        IN VARCHAR2,
                    IN_TRO_SUB_SEQ    IN VARCHAR2,
                    IN_IO_BND_CD      IN VARCHAR2,
                    IN_CONTI_CD       IN VARCHAR2,
                    IN_PRT_FLG        IN VARCHAR2
       - 특이사항 
  4.Revision History 
    2009-10-15 iskim : 최초 생성
    2010-02-10 iskim : commit 삭제

******************************************************************************/

BEGIN

    INSERT INTO SCE_BKG_OP_HIS
    (
        BKG_RCV_DT    ,
        BKG_RCV_NO    , 
        BKG_NO        , 
        BKG_EVNT_DT   , 
        CNTR_NO       , 
        BKG_EVNT_TP_CD, 
        BKG_EVNT_RMK  , 
        PCTL_NO       , 
        TRO_SEQ       , 
        TRO_SUB_SEQ   , 
        IO_BND_CD     , 
        CONTI_CD      , 
        PRT_FLG       ,
        CRE_USR_ID    ,
        CRE_DT        ,
        UPD_USR_ID    ,
        UPD_DT          
    )
    VALUES
    (
        IN_BKG_RCV_DT    , 
        IN_BKG_RCV_NO    , 
        IN_BKG_NO        , 
        sysdate          , 
        IN_CNTR_NO       , 
        IN_BKG_EVNT_TP_CD, 
        IN_BKG_EVNT_RMK  , 
        IN_PCTL_NO       , 
        IN_TRO_SEQ       , 
        IN_TRO_SUB_SEQ   , 
        IN_IO_BND_CD     , 
        IN_CONTI_CD      , 
        IN_PRT_FLG       ,
        'SYSTEM'         ,
        SYSDATE          ,
        'SYSTEM'         ,
        SYSDATE   
    ) ;

    --COMMIT;
  
EXCEPTION
    WHEN OTHERS
    THEN
        ROLLBACK;
        
        RAISE PROGRAM_ERROR;
END;
/
