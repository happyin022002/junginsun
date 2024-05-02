CREATE OR REPLACE FUNCTION SCE_STR_SPLIT_FNC
(
    P_LIST IN VARCHAR2,
    P_DEL IN VARCHAR2 
)  RETURN NISADM.SPLIT_TBL authid current_user PIPELINED 


/*******************************************************************************
   1. Object Name      : SCE_STR_SPLIT_FNC
   2. Version          : 1.0
   3. Create Date      : 2009.10.26
   4. Sub System       : SCE
   5. Author           : 김인수
   6. Description      : P_DEL 로 구분 가능한 P_LIST 를 split 하여 TABLE 형태로 return
   7. Revision History : 2009.10.26 김인수 최초 생성
*******************************************************************************/

IS
    L_IDX    PLS_INTEGER;
    L_LIST    VARCHAR2(32767) := P_LIST;

    L_VALUE    VARCHAR2(32767);
BEGIN
    LOOP
        L_IDX := INSTR(L_LIST,P_DEL);
        IF L_IDX > 0 THEN
            PIPE ROW(SUBSTR(L_LIST,1,L_IDX-1));
            L_LIST := SUBSTR(L_LIST,L_IDX+LENGTH(P_DEL));

        ELSE
            PIPE ROW(L_LIST);
            EXIT;
        END IF;
    END LOOP;
    RETURN;
END SCE_STR_SPLIT_FNC;
/
