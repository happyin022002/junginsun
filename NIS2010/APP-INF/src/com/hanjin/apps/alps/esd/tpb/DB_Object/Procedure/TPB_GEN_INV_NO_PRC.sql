CREATE OR REPLACE PROCEDURE NISADM."TPB_GEN_INV_NO_PRC"
/*******************************************************************************
   1. Object Name      : TPB_GEN_INV_NO_PRC
   2. Version          : 1.2
   3. Create Date      : 2007.05.31
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : 3rd Party Invoice No. Generating
                         -------------------------------------------------------
                         DECLARE
                            lst_n3pty_inv_no VARCHAR2(11);
                         BEGIN
                             TPB_GEN_INV_NO_PRC('PUSBTF', 'XX', '_user_id_', lst_n3pty_inv_no) ;
                             DBMS_OUTPUT.PUT_LINE('3rd Party Invoice No. : ' || lst_n3pty_inv_no);
                         END;
                         -------------------------------------------------------
   7. Revision History : 2006.10.20  Kim Jin-seung  1.0  Created
                         2007.05.31  Kim Jin-seung  1.1  Corrected ==> (n3pty_inv_ofc_cty_cd, n3pty_inv_yrmon, n3pty_bil_tp_cd) 차원에서 n3pty_inv_seq 생성
                         2009.09.08  Park Sung-Jin  1.2  ALPS Migration
                         2017.09.11  JG Byeon       1.3  India Tax 및 India Invoice No. 채번 규칙 변경
*******************************************************************************/


-- ===== Arguments ========================================
(
    v_ofc_cd                        IN VARCHAR2,  -- office code to get city code
    v_bil_tp_cd                     IN VARCHAR2,  -- billing type code
    v_user_id                       IN VARCHAR2,  -- user id
    v_lst_inv_no                    OUT VARCHAR2   -- 3rd Party Invoice No. (in failure : Null)
)
AUTHID CURRENT_USER
IS

-- ===== DECLARE ==========================================
v_ofc_cty_cd                        TPB_INV_NO_GEN.N3PTY_INV_OFC_CTY_CD%TYPE;  -- CITY CODE
v_yrmon                             TPB_INV_NO_GEN.N3PTY_INV_YRMON%TYPE; -- YEAR/MONTH
n_affected_rows                     NUMBER(8);
v_cnt_cd                            MDM_LOCATION.CNT_CD%TYPE;
v_ser_no_seq                        COM_SER_NO_CTNT.SER_NO_SEQ%TYPE;
v_ser_no_cnt                        NUMBER(8);

-- ===== BEGIN, EXCEPTION  ======================================
BEGIN

    DBMS_OUTPUT.ENABLE;

    --- Initiate varibles
    v_ofc_cty_cd := SUBSTRB(TRIM(v_ofc_cd),1,3);
    v_lst_inv_no := NULL;

    DBMS_OUTPUT.PUT_LINE('abc1 '||v_ofc_cty_cd);

    -- v_yrmon := TO_CHAR(SYSDATE,'YYMM') ;
    SELECT   TO_CHAR(SYSDATE,'YY') || DECODE( TO_NUMBER(TO_CHAR(SYSDATE,'MM')), 10, 'A', 11, 'B', 12, 'C', TO_NUMBER(TO_CHAR(SYSDATE,'MM')) )
    INTO     v_yrmon
    FROM     DUAL
    ;

    DBMS_OUTPUT.PUT_LINE('abc2 '||v_yrmon);
    
    SELECT   L.CNT_CD
    INTO     v_cnt_cd
    FROM     MDM_ORGANIZATION O
           , MDM_LOCATION L
    WHERE    1 = 1
    AND      O.LOC_CD = L.LOC_CD
    AND      O.OFC_CD = v_ofc_cd
    ;

    IF v_cnt_cd = 'IN' AND LENGTHB(v_ofc_cty_cd) = 3 THEN
        -- India Invoice
        
        SELECT   NVL(MAX(SER_NO_SEQ),0) + 1 AS NEXT_SEQ
               , COUNT(1) AS CNT
        INTO     v_ser_no_seq
               , v_ser_no_cnt
        FROM     COM_SER_NO_CTNT
        WHERE    1 = 1
        AND      MDL_ID = 'TPB'
        AND      SER_NO_DIV_CD = 'II'
        AND      ATTR_CTNT1 = v_ofc_cty_cd
        AND      ATTR_CTNT2 = CASE WHEN TO_CHAR(SYSDATE,'MM') IN ('01','02','03') THEN TO_CHAR(SYSDATE - 365,'YYYY') ELSE TO_CHAR(SYSDATE,'YYYY') END --매년 4월 Seq가 1로 초기화 됨. 1월, 2월, 3월 귀속 연도는 전년도임
        ;
               
        IF v_ser_no_cnt > 0 THEN
            UPDATE   COM_SER_NO_CTNT
            SET      SER_NO_SEQ = v_ser_no_seq
                   , ATTR_CTNT3 = v_ofc_cty_cd || TO_CHAR(SYSDATE,'YYMM') || TRIM(TO_CHAR(v_ser_no_seq,'0000'))
                   , UPD_USR_ID = v_user_id
                   , UPD_DT = SYSDATE
            WHERE    1 = 1
            AND      MDL_ID = 'TPB'
            AND      SER_NO_DIV_CD = 'II'
            AND      ATTR_CTNT1 = v_ofc_cty_cd
            AND      ATTR_CTNT2 = CASE WHEN TO_CHAR(SYSDATE,'MM') IN ('01','02','03') THEN TO_CHAR(SYSDATE - 365,'YYYY') ELSE TO_CHAR(SYSDATE,'YYYY') END --매년 4월 Seq가 1로 초기화 됨. 1월, 2월, 3월 귀속 연도는 전년도임
            ;
        ELSE
            INSERT INTO COM_SER_NO_CTNT
            ( 
                     MDL_ID
                   , SER_NO_DIV_CD
                   , SER_NO_DIV_SEQ
                   , SER_NO_SEQ
                   , ATTR_CTNT1
                   , ATTR_CTNT2
                   , ATTR_CTNT3
                   , CRE_USR_ID
                   , CRE_DT
                   , UPD_USR_ID
                   , UPD_DT
            )
            VALUES
            ( 
                     'TPB'
                   , 'II'
                   , (
                       SELECT   NVL(MAX(SER_NO_DIV_SEQ),0) + 1
                       FROM     COM_SER_NO_CTNT
                       WHERE    1 = 1
                       AND      MDL_ID = 'TPB'
                       AND      SER_NO_DIV_CD = 'II'
                     )
                   , v_ser_no_seq
                   , v_ofc_cty_cd
                   , CASE WHEN TO_CHAR(SYSDATE,'MM') IN ('01','02','03') THEN TO_CHAR(SYSDATE - 365,'YYYY') ELSE TO_CHAR(SYSDATE,'YYYY') END
                   , v_ofc_cty_cd || TO_CHAR(SYSDATE,'YYMM') || TRIM(TO_CHAR(v_ser_no_seq,'0000'))
                   , v_user_id
                   , SYSDATE
                   , v_user_id
                   , SYSDATE 
            )
            ;
        END IF;
        
        SELECT   ATTR_CTNT3
        INTO     v_lst_inv_no
        FROM     COM_SER_NO_CTNT
        WHERE    1 = 1
        AND      MDL_ID = 'TPB'
        AND      SER_NO_DIV_CD = 'II'
        AND      ATTR_CTNT1 = v_ofc_cty_cd
        AND      ATTR_CTNT2 = CASE WHEN TO_CHAR(SYSDATE,'MM') IN ('01','02','03') THEN TO_CHAR(SYSDATE - 365,'YYYY') ELSE TO_CHAR(SYSDATE,'YYYY') END --매년 4월 Seq가 1로 초기화 됨. 1월, 2월, 3월 귀속 연도는 전년도임
        ;
        
    ELSIF ( LENGTHB(v_ofc_cty_cd) = 3 ) AND (LENGTHB(v_bil_tp_cd) = 2) THEN ----------------------
        -- General Invoice

        MERGE INTO TPB_INV_NO_GEN A
        USING (
                SELECT   NVL(MAX(N3PTY_INV_SEQ),0) + 1 AS NEXT_SEQ
                FROM     TPB_INV_NO_GEN
                WHERE    1 = 1
                AND      N3PTY_INV_OFC_CTY_CD = v_ofc_cty_cd
                AND      N3PTY_INV_YRMON = v_yrmon
                AND      N3PTY_BIL_TP_CD = v_bil_tp_cd
              ) b
           ON ( 
                         A.N3PTY_INV_OFC_CTY_CD = v_ofc_cty_cd
                AND      A.N3PTY_INV_YRMON = v_yrmon
                AND      A.N3PTY_BIL_TP_CD = v_bil_tp_cd
              )
        WHEN MATCHED THEN
                UPDATE
                SET      N3PTY_INV_SEQ = B.NEXT_SEQ
                       , LST_N3PTY_INV_NO = N3PTY_INV_OFC_CTY_CD || N3PTY_INV_YRMON || N3PTY_BIL_TP_CD || TRIM(TO_CHAR(B.NEXT_SEQ,'000'))
                       , UPD_USR_ID = v_user_id
                       , UPD_DT = SYSDATE
        WHEN NOT MATCHED THEN
                INSERT
                (
                         n3pty_inv_ofc_cty_cd
                       , n3pty_inv_yrmon
                       , n3pty_bil_tp_cd
                       , n3pty_inv_seq
                       , lst_n3pty_inv_no
                       , cre_usr_id
                       , cre_dt
                       , upd_usr_id
                       , upd_dt
                )
                VALUES
                (
                         v_ofc_cty_cd
                       , v_yrmon
                       , v_bil_tp_cd
                       , 1
                       , v_ofc_cty_cd || v_yrmon || v_bil_tp_cd || TRIM(TO_CHAR(1,'000'))
                       , v_user_id
                       , SYSDATE
                       , v_user_id
                       , SYSDATE
                )
        ;
        
        n_affected_rows := SQL%ROWCOUNT; --- affected rows

        IF n_affected_rows != 1 THEN  --- abnormal
            DBMS_OUTPUT.PUT_LINE('affected rows : ' || n_affected_rows);
            v_lst_inv_no := NULL;
        ELSE
            SELECT   LST_N3PTY_INV_NO
            INTO     v_lst_inv_no
            FROM     TPB_INV_NO_GEN A
            WHERE    1 = 1
            AND      A.N3PTY_INV_OFC_CTY_CD = v_ofc_cty_cd
            AND      A.N3PTY_INV_YRMON = v_yrmon
            AND      A.N3PTY_BIL_TP_CD = v_bil_tp_cd
            ;
        END IF;

    END IF;

EXCEPTION
    WHEN OTHERS THEN
        v_lst_inv_no := NULL;
        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM );

END
;