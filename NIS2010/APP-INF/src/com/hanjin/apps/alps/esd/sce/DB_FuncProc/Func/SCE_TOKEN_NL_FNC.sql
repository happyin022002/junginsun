CREATE OR REPLACE FUNCTION SCE_TOKEN_NL_FNC ( ag_src VARCHAR2, ag_start NUMBER )
RETURN VARCHAR2
authid current_user 
IS
    lv_pos1 NUMBER;
    lv_pos2 NUMBER;
BEGIN
    IF ag_start = 1 THEN
        lv_pos1 := 1;
    ELSE
        lv_pos1 := INSTR( ag_src || CHR(13)||CHR(10) || CHR(13)||CHR(10)  || CHR(13)||CHR(10) || CHR(13)||CHR(10), CHR(13), 1, ag_start - 1 ) + 2;
    END IF;
    lv_pos2 := INSTR( ag_src || CHR(13)||CHR(10) || CHR(13)||CHR(10) || CHR(13)||CHR(10) || CHR(13)||CHR(10), CHR(13), 1, ag_start ) - 1;
    IF lv_pos2 < 0 THEN
        lv_pos2 := 1000;
    END IF;
    RETURN (SUBSTR(ag_src, lv_pos1, lv_pos2 - lv_pos1 + 1));
END SCE_TOKEN_NL_FNC;
/
