CREATE OR REPLACE PACKAGE OPUSADM.HOM_MLT_RTN_PKG
AUTHID CURRENT_USER
AS

/*******************************************************************************
   1. Object Name      : HOM_MLT_RTN_PKG
   2. Version          : 1.0
   3. Create Date      : 2011.07.01
   4. Sub System       : HOM
   5. Author           : 류선우
   6. Description      : HOMPAGE DATA 를 String 으로 가져와 ALPS DATA 를 조회할때
                         TABLE 로 환원하는 PACKAGE
   7. Revision History : 2011.07.01 류선우 최초 생성
                         2011.09.15 Row 구분자가 없으면 Column 으로만 분리, 또는 Column 구분자가 없으면 Row 로만 분리하도록 로직 수정
                         2011.09.15 Input String 의 맨 마지막에 Row 구분자가 있을때, 무한 Loop 가 발생하는 에러 수정
                         2011.09.15 HOM_DMY_TBL_TYPE 에 SEQ 칼럼 추가된 부분 반영
                         2011.09.22 HOM_DMY_TBL_TYPE 에 COL_5 ~ COL_10 칼럼 추가된 부분 반영
                         2011.09.22 HOM_DMY_TBL_TYPE 에 COL_11 ~ COL_15 칼럼 추가된 부분 반영
                         2011.10.13 HOM_TBL_TO_STR_FNC 추가 ( SYS_CONNECT_BY_PATH 대체 용도 )
                         2011.12.22 COL_16 ~ COL_20 칼럼 추가
*******************************************************************************/

  TYPE SPLIT_TBL IS TABLE OF HOM_DMY_TBL_TYPE  ;

  TYPE COL_N IS TABLE OF LONG(32000) INDEX BY BINARY_INTEGER  ;

  FUNCTION HOM_TBL_TO_STR_FNC(v_cur SYS_REFCURSOR, v_row_split IN VARCHAR2 := ',') RETURN VARCHAR2  ;

  FUNCTION HOM_STR_TO_TBL_FNC(v_str IN LONG, v_row_split IN VARCHAR2, v_col_split IN VARCHAR2 := NULL) RETURN SPLIT_TBL PIPELINED ;

END HOM_MLT_RTN_PKG
;
/

CREATE OR REPLACE PACKAGE BODY OPUSADM.HOM_MLT_RTN_PKG
AS

/*******************************************************************************
   1. Object Name      : HOM_MLT_RTN_PKG
   2. Version          : 1.0
   3. Create Date      : 2011.07.01
   4. Sub System       : HOM
   5. Author           : 류선우
   6. Description      : HOMPAGE DATA 를 String 으로 가져와 ALPS DATA 를 조회할때
                         TABLE 로 환원하는 PACKAGE
   7. Revision History : 2011.07.01 류선우 최초 생성
                         2011.09.15 Row 구분자가 없으면 Column 으로만 분리, 또는 Column 구분자가 없으면 Row 로만 분리하도록 로직 수정
                         2011.09.15 Input String 의 맨 마지막에 Row 구분자가 있을때, 무한 Loop 가 발생하는 에러 수정
                         2011.09.15 HOM_DMY_TBL_TYPE 에 SEQ 칼럼 추가된 부분 반영
                         2011.09.22 HOM_DMY_TBL_TYPE 에 COL_6 ~ COL_10 칼럼 추가된 부분 반영
                         2011.09.22 HOM_DMY_TBL_TYPE 에 COL_11 ~ COL_15 칼럼 추가된 부분 반영
                         2011.10.13 HOM_TBL_TO_STR_FNC 추가 ( SYS_CONNECT_BY_PATH 대체 용도 )
                         2011.12.22 COL_16 ~ COL_20 칼럼 추가
*******************************************************************************/

FUNCTION HOM_TBL_TO_STR_FNC(v_cur SYS_REFCURSOR, v_row_split IN VARCHAR2 := ',') RETURN VARCHAR2
IS

  ttl_str   VARCHAR2(4000)  ;
  row_str   VARCHAR2(4000)  ;
BEGIN

  ttl_str := NULL ;

  LOOP

    FETCH v_cur INTO row_str  ;

    EXIT WHEN v_cur%NOTFOUND  ;

    IF ttl_str IS NOT NULL THEN
      ttl_str := ttl_str || v_row_split ;
    END IF  ;

    ttl_str := ttl_str || row_str ;

  END LOOP  ;

  CLOSE v_cur ;

  RETURN ttl_str  ;


EXCEPTION
  WHEN OTHERS THEN
    CLOSE v_cur ;

END HOM_TBL_TO_STR_FNC
;


FUNCTION HOM_STR_TO_TBL_FNC(v_str IN LONG, v_row_split IN VARCHAR2, v_col_split IN VARCHAR2 := NULL) RETURN SPLIT_TBL PIPELINED
IS

  i_idx     NUMBER  := 0    ;
  j_idx     NUMBER  := 0    ;

  ttl_str   LONG(32000)  ;
  row_str   LONG(32000)  ;
  col_str   LONG(32000)  ;

  col_arr   COL_N ;

  arr_size  NUMBER  := 20    ;

  seq       NUMBER(6)       ;
BEGIN

  ttl_str := v_str  ;
  seq     := 0      ;

  LOOP
    seq   := seq + 1  ;

    IF v_row_split IS NULL THEN
      i_idx   := 0  ;
    ELSE
      i_idx   := NVL(INSTR(ttl_str, v_row_split), 0)  ;
    END IF;

    IF i_idx > 0 THEN
      row_str := SUBSTR(ttl_str, 1, i_idx - 1)  ;
      ttl_str := SUBSTR(ttl_str, i_idx + LENGTH(v_row_split)) ;
    ELSE
      row_str := ttl_str  ;
    END IF;


    FOR n IN 0..arr_size-1 LOOP
      col_arr(n)  := NULL ;
    END LOOP  ;


    IF  row_str IS NULL OR v_col_split IS NULL THEN
      col_arr(0)  := row_str  ;
    ELSE
      FOR n IN 0..arr_size-1 LOOP

        j_idx := INSTR(row_str, v_col_split)  ;

        IF j_idx > 0 THEN
          col_arr(n)  := SUBSTR(row_str, 1, j_idx - 1)  ;
          row_str     := SUBSTR(row_str, j_idx + LENGTH(v_col_split)) ;
        ELSE
          col_arr(n)  := row_str  ;
        END IF;

        IF j_idx <= 0 THEN
          EXIT  ;
        END IF  ;

      END LOOP  ;
    END IF;

    PIPE ROW(HOM_DMY_TBL_TYPE(seq, col_arr(0), col_arr(1), col_arr(2) ,col_arr(3), col_arr(4), col_arr(5), col_arr(6), col_arr(7), col_arr(8), col_arr(9), col_arr(10), col_arr(11), col_arr(12), col_arr(13), col_arr(14), col_arr(15), col_arr(16), col_arr(17), col_arr(18), col_arr(19)));

    IF i_idx <= 0 THEN
      EXIT  ;
    END IF  ;

  END LOOP;

  RETURN  ;

END HOM_STR_TO_TBL_FNC
;

END HOM_MLT_RTN_PKG
;
/

