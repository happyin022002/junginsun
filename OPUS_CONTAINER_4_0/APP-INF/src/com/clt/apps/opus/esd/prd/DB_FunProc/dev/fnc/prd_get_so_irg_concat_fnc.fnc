CREATE OR REPLACE FUNCTION OPUSADM.PRD_GET_SO_IRG_CONCAT_FNC
(
  SO_ROUTE       IN VARCHAR2
 ,V_IRG_ORG_NOD  IN VARCHAR2 DEFAULT NULL
 ,V_IRG_DEST_NOD IN VARCHAR2 DEFAULT NULL
 ,V_IRG_ROUT_SEQ IN VARCHAR2 DEFAULT NULL
)
RETURN VARCHAR2 authid current_user 
IS
  rtStr  VARCHAR2(800) := NULL;
  irgStr VARCHAR2(400) := NULL;
BEGIN
  DBMS_OUTPUT.disable;
  rtStr := SO_ROUTE;
  BEGIN
    SELECT (SELECT REPLACE(MAX('%' || D1.ROUT_ORG_NOD_CD ||
                               SYS_CONNECT_BY_PATH(D1.TRSP_MOD_CD || '@*' ||
                                                   NVL(INLND_ROUT_CMB_FLG, 'N') || '@*' ||
                                                   'XXX' || '@*' ||
                                                   D1.LNK_DEST_NOD_CD
                                                  ,'-') || '%')
                          ,'@*'
                          ,'-')
              FROM PRD_INLND_ROUT_DTL D1 --, PRD_INLND_ROUT_MST M1 
             WHERE 1 = 1                  
               AND D1.ROUT_ORG_NOD_CD = M1.ROUT_ORG_NOD_CD
               AND D1.ROUT_DEST_NOD_CD = M1.ROUT_DEST_NOD_CD
               AND D1.ROUT_SEQ = M1.ROUT_SEQ
             START WITH D1.ROUT_ORG_NOD_CD = M1.ROUT_ORG_NOD_CD
                    AND D1.ROUT_DEST_NOD_CD = M1.ROUT_DEST_NOD_CD
                    AND D1.ROUT_SEQ = M1.ROUT_SEQ
                    AND D1.ROUT_DTL_SEQ = 1
            CONNECT BY PRIOR D1.ROUT_DTL_SEQ = D1.ROUT_DTL_SEQ - 1
                   AND D1.ROUT_ORG_NOD_CD = M1.ROUT_ORG_NOD_CD
                   AND D1.ROUT_DEST_NOD_CD = M1.ROUT_DEST_NOD_CD
                   AND D1.ROUT_SEQ = M1.ROUT_SEQ) IRG_STR
      INTO irgStr
      FROM PRD_INLND_ROUT_MST M1
     WHERE 1 = 1
       AND M1.ROUT_ORG_NOD_CD = V_IRG_ORG_NOD
       AND M1.ROUT_DEST_NOD_CD = V_IRG_DEST_NOD
       AND M1.ROUT_SEQ = V_IRG_ROUT_SEQ;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      null;
  END;
  SELECT CASE
           WHEN rtStr IS NULL THEN irgStr --SO 없을떼
           WHEN INSTR(rtStr ,SUBSTR(REGEXP_SUBSTR(irgStr, '[-%].{7}[-%]', 1, 1), 2, 7)) < 1 THEN REPLACE(rtStr || irgStr, '%%', '%') -- so에 irg 시작 node 가 없을때
           ELSE REGEXP_REPLACE(rtStr, SUBSTR(REGEXP_SUBSTR(irgStr, '[-%].{7}[-%]', 1, 1),2,7) ,REPLACE(irgStr, '%', '')) -- so 에 일치 node 있으면 irg 로 replace
         END
    INTO rtStr
    FROM DUAL;
  RETURN rtStr;
END PRD_GET_SO_IRG_CONCAT_FNC;
/