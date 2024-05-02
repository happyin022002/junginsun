CREATE OR REPLACE PROCEDURE SCE_COP_DEL_PRC(STARTNO IN  NUMBER, ENDNO IN NUMBER)
AUTHID CURRENT_USER
IS
    V_LOG_SEQ         MIG_LOG.MIG_LOG_SEQ%TYPE;
    V_LOG_SEQ2         MIG_LOG.MIG_LOG_SEQ%TYPE;
    V_LOG_SEQ3         MIG_LOG.MIG_LOG_SEQ%TYPE;

    V_WORK_SEQ        MIG_LOG.WORK_SEQ%TYPE;
    V_SYS_NM          MIG_LOG.SYS_NM%TYPE;
    V_PROG_NM         MIG_LOG.PROG_NM%TYPE;
    V_OWN_NM          VARCHAR2(30);
    V_ENT_NM          MIG_LOG.ENT_NM%TYPE;
    V_TAB_NM          MIG_LOG.TAB_NM%TYPE;
    V_ACT_TP          MIG_LOG.ACT_TP%TYPE;
    
    V_INS_ROW_CNT     MIG_LOG.INS_ROW_CNT%TYPE;
    V_PRC_ROW_CNT     MIG_LOG.INS_ROW_CNT%TYPE;    
    
    V_INS_SCE_COP_DTL_CNT     MIG_LOG.INS_ROW_CNT%TYPE;
    V_SCE_COP_DTL_CNT     MIG_LOG.INS_ROW_CNT%TYPE;
    
    V_INS_SCE_PLN_SO_LIST_CNT     MIG_LOG.INS_ROW_CNT%TYPE;
    V_SCE_PLN_SO_LIST_CNT     MIG_LOG.INS_ROW_CNT%TYPE;
    
    V_INS_PROD_CTL_QTY_CNT     MIG_LOG.INS_ROW_CNT%TYPE;
    V_PRC_PROD_CTL_QTY_CNT     MIG_LOG.INS_ROW_CNT%TYPE;  
     
    V_INS_BKG_COP_MAP_CNT     MIG_LOG.INS_ROW_CNT%TYPE;
    V_PRC_BKG_COP_MAP_CNT     MIG_LOG.INS_ROW_CNT%TYPE;
    
    V_INS_PROD_CTL_VAL_CHK_CNT     MIG_LOG.INS_ROW_CNT%TYPE;
    V_PRC_PROD_CTL_VAL_CHK_CNT     MIG_LOG.INS_ROW_CNT%TYPE;
    
    V_INS_SCE_COP_HDR_CNT     MIG_LOG.INS_ROW_CNT%TYPE;
    V_SCE_COP_HDR_CNT     MIG_LOG.INS_ROW_CNT%TYPE;  
       
    V_LOG_MSG         MIG_LOG.LOG_MSG%TYPE;
    V_LOG_MSG_MAIN    MIG_LOG.LOG_MSG%TYPE;
    V_AUTHOR_NM       MIG_LOG.AUTHOR_NM%TYPE;
    V_WORK_GRP_ID     MIG_LOG.WORK_GRP_ID%TYPE;
    V_SUB_STEP_DESC   MIG_LOG_SUB_STEP.SUB_STEP_DESC%TYPE;
    V_LOG_SUB_SEQ     MIG_LOG_SUB_STEP.MIG_LOG_SUB_SEQ%TYPE;

    V_ERRNO           MIG_LOG.ERR_TP%TYPE;
    V_ERRMSG          MIG_LOG.LOG_MSG%TYPE;
    V_ERRNO_SUB_STEP  MIG_LOG_SUB_STEP.ERR_TP%TYPE;

    ARRAY_SIZE  CONSTANT NUMBER := 10000;
    TYPE ARRAY_PCTL_NO IS VARRAY(10000) OF VARCHAR2(100);
    VA_COP_NO  ARRAY_PCTL_NO;
    I           NUMBER;

    /*
     * SCE Purge������̺� �� Master ���̺��� Ű�� SCE_COP_HDR.COP_NO ��
     * SCE PURGE Delete���� SCE���� �������� �ʴ� �͸� ���������� �����Ѵ�.
     */
    CURSOR COP_NO_CUR IS
        SELECT COP_NO
        FROM PUG_COP_NO
        WHERE ROWNUM BETWEEN STARTNO AND ENDNO
--        FROM SCE_COP_HDR A
--        WHERE CRE_DT < TO_DATE('200801010000','YYYYMMDDHH24MI')
--        AND NOT EXISTS ( SELECT 1 FROM BKG_BOOKING B WHERE A.BKG_NO = B.BKG_NO)
        ;

BEGIN

    V_WORK_SEQ      := 1;
          
    V_SYS_NM        := 'SCE';
    V_PROG_NM       := 'SCE PURGE';
    V_OWN_NM        := 'NISADM';
    V_ENT_NM        := 'SCE';
    V_TAB_NM        := 'SCE_COP_HDR';
    V_INS_ROW_CNT   := 0;
    V_LOG_MSG       := '';
    V_LOG_MSG_MAIN  := '';
    V_ERRNO         := '';
    V_WORK_GRP_ID   := '${WORK_GRP_ID}';
    
    -- LOG START
    MIG_UTL_PURGE.PRC_MIG_PGM_LOG (
        I_LOG_MODE => 'LOG_START',  I_LOG_SEQ => NULL,      I_WORK_SEQ => V_WORK_SEQ,   I_SYS_NM => V_SYS_NM,       I_PROG_NM=> V_PROG_NM,
        I_ENT_NM => V_ENT_NM,       I_TAB_NM => 'SCE_COP_DTL',   I_ACT_TP   => 'D',          I_INS_ROW_CNT => 0,         I_LOG_MSG => V_LOG_MSG_MAIN,
        I_AUTHOR_NM => V_AUTHOR_NM, O_LOG_SEQ => V_LOG_SEQ, O_ERRNO => V_ERRNO,         O_ERRMSG => V_ERRMSG,       I_WORK_GRP_ID => V_WORK_GRP_ID);
--        
    -- LOG START
    MIG_UTL_PURGE.PRC_MIG_PGM_LOG (
        I_LOG_MODE => 'LOG_START',  I_LOG_SEQ => NULL,      I_WORK_SEQ => V_WORK_SEQ,   I_SYS_NM => V_SYS_NM,       I_PROG_NM=> V_PROG_NM,
        I_ENT_NM => V_ENT_NM,       I_TAB_NM => 'SCE_PLN_SO_LIST',   I_ACT_TP   => 'D',          I_INS_ROW_CNT => 0,         I_LOG_MSG => V_LOG_MSG_MAIN,
        I_AUTHOR_NM => V_AUTHOR_NM, O_LOG_SEQ => V_LOG_SEQ2, O_ERRNO => V_ERRNO,         O_ERRMSG => V_ERRMSG,       I_WORK_GRP_ID => V_WORK_GRP_ID);

        --        
    -- LOG START
    MIG_UTL_PURGE.PRC_MIG_PGM_LOG (
        I_LOG_MODE => 'LOG_START',  I_LOG_SEQ => NULL,      I_WORK_SEQ => V_WORK_SEQ,   I_SYS_NM => V_SYS_NM,       I_PROG_NM=> V_PROG_NM,
        I_ENT_NM => V_ENT_NM,       I_TAB_NM => 'SCE_COP_HDR',   I_ACT_TP   => 'D',          I_INS_ROW_CNT => 0,         I_LOG_MSG => V_LOG_MSG_MAIN,
        I_AUTHOR_NM => V_AUTHOR_NM, O_LOG_SEQ => V_LOG_SEQ3, O_ERRNO => V_ERRNO,         O_ERRMSG => V_ERRMSG,       I_WORK_GRP_ID => V_WORK_GRP_ID);
                
--         --        
--    -- LOG START
--    MIG_UTL_PURGE.PRC_MIG_PGM_LOG (
--        I_LOG_MODE => 'LOG_START',  I_LOG_SEQ => NULL,      I_WORK_SEQ => V_WORK_SEQ,   I_SYS_NM => V_SYS_NM,       I_PROG_NM=> V_PROG_NM,
--        I_ENT_NM => V_ENT_NM,       I_TAB_NM => 'PRD_BKG_COP_MAP',   I_ACT_TP   => 'D',          I_INS_ROW_CNT => 0,         I_LOG_MSG => V_LOG_MSG_MAIN,
--        I_AUTHOR_NM => V_AUTHOR_NM, O_LOG_SEQ => V_LOG_SEQ4, O_ERRNO => V_ERRNO,         O_ERRMSG => V_ERRMSG,       I_WORK_GRP_ID => V_WORK_GRP_ID);
--                
--         --        
--    -- LOG START
--    MIG_UTL_PURGE.PRC_MIG_PGM_LOG (
--        I_LOG_MODE => 'LOG_START',  I_LOG_SEQ => NULL,      I_WORK_SEQ => V_WORK_SEQ,   I_SYS_NM => V_SYS_NM,       I_PROG_NM=> V_PROG_NM,
--        I_ENT_NM => V_ENT_NM,       I_TAB_NM => 'PRD_PROD_CTL_VAL_CHK',   I_ACT_TP   => 'D',          I_INS_ROW_CNT => 0,         I_LOG_MSG => V_LOG_MSG_MAIN,
--        I_AUTHOR_NM => V_AUTHOR_NM, O_LOG_SEQ => V_LOG_SEQ5, O_ERRNO => V_ERRNO,         O_ERRMSG => V_ERRMSG,       I_WORK_GRP_ID => V_WORK_GRP_ID);
--                
--          --        
--    -- LOG START
--    MIG_UTL_PURGE.PRC_MIG_PGM_LOG (
--        I_LOG_MODE => 'LOG_START',  I_LOG_SEQ => NULL,      I_WORK_SEQ => V_WORK_SEQ,   I_SYS_NM => V_SYS_NM,       I_PROG_NM=> V_PROG_NM,
--        I_ENT_NM => V_ENT_NM,       I_TAB_NM => 'SCE_COP_HDR',   I_ACT_TP   => 'D',          I_INS_ROW_CNT => 0,         I_LOG_MSG => V_LOG_MSG_MAIN,
--        I_AUTHOR_NM => V_AUTHOR_NM, O_LOG_SEQ => V_LOG_SEQ6, O_ERRNO => V_ERRNO,         O_ERRMSG => V_ERRMSG,       I_WORK_GRP_ID => V_WORK_GRP_ID);
                
           
        
         V_SUB_STEP_DESC := 'DATA_PURGE';    
    

    OPEN COP_NO_CUR;
    LOOP
        FETCH COP_NO_CUR BULK COLLECT INTO VA_COP_NO LIMIT ARRAY_SIZE;
        
        -- SUB STEP LOG START
            MIG_UTL_PURGE.PRC_MIG_PGM_LOG_SUB_STEP (
               I_LOG_MODE => 'LOG_START',      I_LOG_SEQ => V_LOG_SEQ,      I_LOG_SUB_SEQ => NULL,  I_SUB_STEP_DESC => V_SUB_STEP_DESC,
               I_ACT_TP   => 'D',              I_PRC_ROW_CNT => 0,          I_LOG_MSG => NULL,
               O_LOG_SUB_SEQ => V_LOG_SUB_SEQ, O_ERRNO => V_ERRNO_SUB_STEP, O_ERRMSG => V_ERRMSG );
                       

        FORALL I IN VA_COP_NO.FIRST..VA_COP_NO.LAST
            DELETE SCE_COP_DTL    WHERE COP_NO = VA_COP_NO(I); -- 20
            DBMS_OUTPUT.PUT_LINE('[' ||  SQL%ROWCOUNT  || '] 1 ');
            V_SCE_COP_DTL_CNT := SQL%ROWCOUNT;
            V_INS_SCE_COP_DTL_CNT := V_INS_SCE_COP_DTL_CNT + V_SCE_COP_DTL_CNT;
          COMMIT;  
            -- SUB STEP LOG FINISH
            MIG_UTL_PURGE.PRC_MIG_PGM_LOG_SUB_STEP (
               I_LOG_MODE => 'LOG_FINISH',     I_LOG_SEQ => V_LOG_SEQ,      I_LOG_SUB_SEQ => V_LOG_SUB_SEQ,  I_SUB_STEP_DESC => V_SUB_STEP_DESC,
               I_PRC_ROW_CNT => V_SCE_COP_DTL_CNT, I_LOG_MSG => V_LOG_MSG,    
               O_LOG_SUB_SEQ => V_LOG_SUB_SEQ, O_ERRNO => V_ERRNO_SUB_STEP, O_ERRMSG => V_ERRMSG  );
               
               
--               
                 
         -- SUB STEP LOG START
            MIG_UTL_PURGE.PRC_MIG_PGM_LOG_SUB_STEP (
               I_LOG_MODE => 'LOG_START',      I_LOG_SEQ => V_LOG_SEQ2,      I_LOG_SUB_SEQ => NULL,  I_SUB_STEP_DESC => V_SUB_STEP_DESC,
               I_ACT_TP   => 'D',              I_PRC_ROW_CNT => 0,          I_LOG_MSG => NULL,
               O_LOG_SUB_SEQ => V_LOG_SUB_SEQ, O_ERRNO => V_ERRNO_SUB_STEP, O_ERRMSG => V_ERRMSG );
                 
        FORALL I IN VA_COP_NO.FIRST..VA_COP_NO.LAST
             DELETE SCE_PLN_SO_LIST WHERE COP_NO = VA_COP_NO(I); -- 20
             DBMS_OUTPUT.PUT_LINE('[' ||  SQL%ROWCOUNT  || '] 2 ');
             V_SCE_PLN_SO_LIST_CNT := SQL%ROWCOUNT;
            V_INS_SCE_PLN_SO_LIST_CNT := V_INS_SCE_PLN_SO_LIST_CNT + V_SCE_PLN_SO_LIST_CNT;
        COMMIT;        
             -- SUB STEP LOG FINISH
            MIG_UTL_PURGE.PRC_MIG_PGM_LOG_SUB_STEP (
               I_LOG_MODE => 'LOG_FINISH',     I_LOG_SEQ => V_LOG_SEQ2,      I_LOG_SUB_SEQ => V_LOG_SUB_SEQ,  I_SUB_STEP_DESC => V_SUB_STEP_DESC,
               I_PRC_ROW_CNT => V_SCE_PLN_SO_LIST_CNT, I_LOG_MSG => V_LOG_MSG,    
               O_LOG_SUB_SEQ => V_LOG_SUB_SEQ, O_ERRNO => V_ERRNO_SUB_STEP, O_ERRMSG => V_ERRMSG  );

         -- SUB STEP LOG START
            MIG_UTL_PURGE.PRC_MIG_PGM_LOG_SUB_STEP (
               I_LOG_MODE => 'LOG_START',      I_LOG_SEQ => V_LOG_SEQ3,      I_LOG_SUB_SEQ => NULL,  I_SUB_STEP_DESC => V_SUB_STEP_DESC,
               I_ACT_TP   => 'D',              I_PRC_ROW_CNT => 0,          I_LOG_MSG => NULL,
               O_LOG_SUB_SEQ => V_LOG_SUB_SEQ, O_ERRNO => V_ERRNO_SUB_STEP, O_ERRMSG => V_ERRMSG );
                 
        FORALL I IN VA_COP_NO.FIRST..VA_COP_NO.LAST
             DELETE SCE_COP_HDR WHERE COP_NO = VA_COP_NO(I); -- 20
             DBMS_OUTPUT.PUT_LINE('[' ||  SQL%ROWCOUNT  || '] 2 ');
             V_SCE_COP_HDR_CNT := SQL%ROWCOUNT;
            V_INS_SCE_COP_HDR_CNT := V_INS_SCE_COP_HDR_CNT + V_SCE_COP_HDR_CNT;
           COMMIT;     
             -- SUB STEP LOG FINISH
            MIG_UTL_PURGE.PRC_MIG_PGM_LOG_SUB_STEP (
               I_LOG_MODE => 'LOG_FINISH',     I_LOG_SEQ => V_LOG_SEQ3,      I_LOG_SUB_SEQ => V_LOG_SUB_SEQ,  I_SUB_STEP_DESC => V_SUB_STEP_DESC,
               I_PRC_ROW_CNT => V_SCE_COP_HDR_CNT, I_LOG_MSG => V_LOG_MSG,    
               O_LOG_SUB_SEQ => V_LOG_SUB_SEQ, O_ERRNO => V_ERRNO_SUB_STEP, O_ERRMSG => V_ERRMSG  );

        EXIT WHEN COP_NO_CUR%NOTFOUND;
    END LOOP;


    -- LOG FINISH
    MIG_UTL_PURGE.PRC_MIG_PGM_LOG (
        I_LOG_MODE => 'LOG_FINISH', I_LOG_SEQ => V_LOG_SEQ, I_WORK_SEQ => V_WORK_SEQ,       I_SYS_NM => V_SYS_NM,       I_PROG_NM=> V_PROG_NM,
        I_ENT_NM => V_ENT_NM,       I_TAB_NM =>  'SCE_COP_DTL',   I_INS_ROW_CNT => V_INS_SCE_COP_DTL_CNT, I_LOG_MSG => V_LOG_MSG_MAIN,     I_AUTHOR_NM => V_AUTHOR_NM,
        O_LOG_SEQ => V_LOG_SEQ,     O_ERRNO => V_ERRNO,     O_ERRMSG => V_ERRMSG );

    MIG_UTL_PURGE.PRC_MIG_PGM_LOG (
        I_LOG_MODE => 'LOG_FINISH', I_LOG_SEQ => V_LOG_SEQ2, I_WORK_SEQ => V_WORK_SEQ,       I_SYS_NM => V_SYS_NM,       I_PROG_NM=> V_PROG_NM,
        I_ENT_NM => V_ENT_NM,       I_TAB_NM =>  'SCE_PLN_SO_LIST',   I_INS_ROW_CNT => V_INS_SCE_PLN_SO_LIST_CNT, I_LOG_MSG => V_LOG_MSG_MAIN,     I_AUTHOR_NM => V_AUTHOR_NM,
        O_LOG_SEQ => V_LOG_SEQ,     O_ERRNO => V_ERRNO,     O_ERRMSG => V_ERRMSG );
        
                
    MIG_UTL_PURGE.PRC_MIG_PGM_LOG (
        I_LOG_MODE => 'LOG_FINISH', I_LOG_SEQ => V_LOG_SEQ3, I_WORK_SEQ => V_WORK_SEQ,       I_SYS_NM => V_SYS_NM,       I_PROG_NM=> V_PROG_NM,
        I_ENT_NM => V_ENT_NM,       I_TAB_NM =>  'SCE_COP_HDR',   I_INS_ROW_CNT => V_INS_SCE_COP_HDR_CNT, I_LOG_MSG => V_LOG_MSG_MAIN,     I_AUTHOR_NM => V_AUTHOR_NM,
        O_LOG_SEQ => V_LOG_SEQ,     O_ERRNO => V_ERRNO,     O_ERRMSG => V_ERRMSG );
             
                    
    V_INS_ROW_CNT := 0;   -- SUB STEP PROCESS COUNT CLEAR
    
    COMMIT;
    CLOSE COP_NO_CUR;
EXCEPTION WHEN OTHERS THEN
    CLOSE COP_NO_CUR;
    COMMIT;
END;
/