CREATE OR REPLACE PROCEDURE TRS_MDM_RSCH_MST_DAT_EFF_PRC (    P_MST_AREA_NM  IN   VARCHAR2
                                                            , P_EFF_CD       IN   VARCHAR2
                                                            , P_RTN_CD       OUT  VARCHAR2
                                                            , P_RTN_DESC     OUT  VARCHAR2 )
AUTHID CURRENT_USER
IS
/*###################################################################
  # -- Type    : PROCEDURE
  # -- Author  : CHO POONG YEON
  # -- Created : MAY 25, 2008
  # -- Modify  : JULY 03, 2008
  # -- 특이사항 
  #     (1) MDM에서 제공하는 Procedure수정
  #     (2) HJSCOM_EFF_TBL_LST에 입력된 정보에 따라 처리한 결과를 
  #         HJSCOM_MST_DAT_EFF_RSLT 에 넣습니다.
  #     (3) MODULE을 구분할 수 있는 명확한 구분자가 없어서 
  #         임의로 BIZ_AREA_NM으로 구분하게 처리합니다. 
  #         나중에 MODULE구분자가 생기면 명확하게 구분하도록 수정해야합니다.. 
  # -- Purpose : RESEARCH MDM EFFECT.
  # __________________________________________________________________
  #####################################################################*/

    TYPE                      MY_CURS_TYPE IS REF CURSOR;
    CURS                      MY_CURS_TYPE;
    L_SQL                     VARCHAR2(4000);

    L_MST_AREA_NM             VARCHAR2(20);
    L_TBL_NM                  VARCHAR2(50);
    L_COL_NM                  VARCHAR2(50);
    L_RET_VENDOR_CD           VARCHAR2(6);
    L_BIZ_AREA_NM             VARCHAR2(50);
    L_TJ_YRMON                VARCHAR2(50);
    L_COUNT                   NUMBER;

    E_EXCEPTION               EXCEPTION;
  
BEGIN
    P_RTN_CD    :=  'S';
    P_RTN_DESC  :=  NULL;

    FOR C1  IN  ( SELECT  MST_AREA_NM
                         , BIZ_AREA_NM
                         , TBL_NM
                         , COL_NM
                         , TJ_DT_COL_NM
                         , SQL_COND_CTNT
                   FROM    HJSCOM_EFF_TBL_LST
                   WHERE   MST_AREA_NM  =  P_MST_AREA_NM AND BIZ_AREA_NM LIKE 'TRS%' ) 
    LOOP
        L_SQL   := 'SELECT '  || '''' || C1.MST_AREA_NM || ''''
                || ', '       || '''' || C1.BIZ_AREA_NM || ''''
                || ', '       || '''' || C1.TBL_NM      || ''''
                || ', '       || '''' || C1.COL_NM      || ''''
                || ', '       || C1.COL_NM
                || ', TO_CHAR('|| C1.TJ_DT_COL_NM||',''YYYYMM'')'
                || ', '       || 'COUNT(*) '
                || 'FROM '    || C1.TBL_NM              || ' '
                || 'WHERE '   || C1.COL_NM              || ' IN (' || P_EFF_CD || ') '
                || 'AND '     || C1.SQL_COND_CTNT       || ' '
                || 'GROUP BY '|| C1.COL_NM           
                || ', TO_CHAR('|| C1.TJ_DT_COL_NM||',''YYYYMM'')';
--        DBMS_OUTPUT.PUT_LINE ( ' SQL  ==> ' || SUBSTR(L_SQL, 1, 200) );
--        DBMS_OUTPUT.PUT_LINE ( SUBSTR(L_SQL, 201) );
          
        OPEN  CURS  FOR  L_SQL; 
        LOOP 
            FETCH  CURS  INTO L_MST_AREA_NM  , L_BIZ_AREA_NM
                            , L_TBL_NM       , L_COL_NM
                            , L_RET_VENDOR_CD, L_TJ_YRMON
                            , L_COUNT; 
            EXIT WHEN CURS%NOTFOUND;
            BEGIN
                INSERT  INTO  HJSCOM_MST_DAT_EFF_RSLT
                            ( MST_AREA_NM
                            , BIZ_AREA_NM
                            , TBL_NM
                            , COL_NM
                            , COL_VAL
                            , TJ_YRMON
                            , ROW_KNT )
                     VALUES ( L_MST_AREA_NM
                            , L_BIZ_AREA_NM
                            , L_TBL_NM
                            , L_COL_NM
                            , L_RET_VENDOR_CD
                            , L_TJ_YRMON
                            , L_COUNT)
                 ;
                            
                EXCEPTION
                WHEN  OTHERS  THEN
                    P_RTN_CD    :=  'E';
                    P_RTN_DESC  :=  'Effect Result insert error. ==> '||SQLERRM;
                    RAISE  e_exception;
            END;

        END LOOP; 
        CLOSE CURS; 
    END LOOP;
    
    EXCEPTION
    WHEN  E_EXCEPTION  THEN
        NULL;
    WHEN  OTHERS  THEN
        P_RTN_CD    :=  'E';
        P_RTN_DESC  :=  'Exception error. ==> '||SQLERRM;

END TRS_MDM_RSCH_MST_DAT_EFF_PRC;