CREATE OR REPLACE PROCEDURE NISADM.TPB_CRE_IF_DATA_TES_PRC

 /*******************************************************************************
   1. Object Name      : TPB_CRE_IF_DATA_TES_PRC
   2. Version          : 1.6
   3. Create Date      : 2008.09.04
   4. Sub System       : Third Party Billing
   5. Author           : Sun, CHOI
   6. Description      : From TES To TPB (Inbound) Interface
                         -------------------------------------------------------
                         BEGIN 
                             TPB_CRE_IF_DATA_TES_PRC('NYCBB','-6') ;
                             -- DBMS_OUTPUT.PUT_LINE('');
                         END; 
                         -------------------------------------------------------
   7. Revision History : 2008.09.04  Kim Jin-seung   1.0  Created
                         2008.11.05  Kim Jin-seung   1.1  2008.11.10  기준으로 Interface 결과 Data 테이블 변경 수용하도록 처리 - tpb_ots_dtl_seq1 사용
                         2009.08.17  Park Sung-Jin   1.2  ALPS Migration
                         2010.01.07  Jong-Geon Byeon 1.3  NIS2010 ALPS간 EQ_KND_CD 단일화 작업
                         2010.05.18  Jong-Geon Byeon 1.4  COST OFFICE CODE Column 추가
                         2010.05.19  Sun, CHOI       1.5  TES_N3RD_PTY_IF Table TES-TPB I/F STATUS UPDATE SQL 실행 시, SQL%FOUND Check 추가
                         2010.12.17  Jong-Geon Byeon 1.6  New CSR 작성시 TPB로의 I/F Logic 보완
 *******************************************************************************/

-- ===== Arguments ========================================
(    
    in_tml_if_ofc_cd  IN VARCHAR2,  -- KEY1 : tml_if_ofc_cd
    in_tml_if_seq     IN VARCHAR2,  -- KEY2 : tml_if_seq
    in_user_ofc_cd    IN VARCHAR2,  -- user office code  
    in_user_id        IN VARCHAR2,  -- user id
    in_csr_no_cxl_flg IN VARCHAR2   -- CSR_NO_CXL_FLG
) 
AUTHID CURRENT_USER

IS 

-- ===== DECLARE ==========================================
    v_src_sys_cd    VARCHAR2(3); -- TES
    v_ots_dtl_seq   TPB_OTS_DTL.ots_dtl_seq%TYPE;
    
-- ===== BEGIN, EXCEPTION and END ======================================
BEGIN

    ----- Initiate varibles 
    v_src_sys_cd  := 'TES';
    

    SELECT TPB_OTS_DTL_SEQ1.NEXTVAL 
      INTO v_ots_dtl_seq
      FROM DUAL
    ; 
    
    ---------------------------------- 
    INSERT INTO TPB_OTS_DTL (
           OTS_DTL_SEQ, SRC_IF_SEQ_NO, N3PTY_BIL_TP_CD,
           IF_RHQ_CD,
           IF_OFC_CD,
           OFC_CD,
           COST_OFC_CD,
           N3PTY_SRC_SUB_SYS_CD, N3PTY_EXPN_TP_CD, N3PTY_SRC_NO, SO_NO, CSR_NO,
           SRC_VNDR_CNT_CD, SRC_VNDR_SEQ, VNDR_CUST_DIV_CD, VNDR_CNT_CD, VNDR_SEQ,
           CUST_CNT_CD, CUST_SEQ, N3PTY_OFC_CD, EQ_NO, EQ_TPSZ_CD,
           TML_INV_TP_CD, YD_CD, BKG_NO,
           BL_NO, SKD_DIR_CD, FINC_DIR_CD, VSL_CD,
           SKD_VOY_NO, IF_CURR_CD, ACCT_CD, LGS_COST_CD, IF_AMT,
           IF_RMK, N3PTY_IF_TP_CD, N3PTY_CFM_CD, N3PTY_DELT_TP_CD,
           IF_USR_ID, IF_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID,
           UPD_DT, EQ_KND_CD, GL_DT, VVD_CD, MNL_INP_TP_CD, CSR_NO_CXL_FLG  --, LGS_COST_CD_SEQ
    )   
    SELECT v_ots_dtl_seq, TML_IF_SEQ, N3PTY_BIL_TP_CD,
           TPB_GET_HNDL_OFC_FNC('R',TPB_GET_N3PTY_OFC_CD_FNC(TML_IF_OFC_CD)),
           TML_IF_OFC_CD,
           --TPB_GET_N3PTY_OFC_CD_FNC(TML_IF_OFC_CD),
           (
              SELECT TPB_GET_N3PTY_OFC_CD_FNC(DECODE(COUNT(O.OFC_CD),0,MAX(H.INV_OFC_CD),MAX(H.COST_OFC_CD))) AS OFC_CD
                FROM TES_TML_SO_HDR H, MDM_ORGANIZATION O
               WHERE H.INV_OFC_CD = O.OFC_CD(+)
                 AND O.REP_CUST_CNT_CD(+) = 'US'
                 AND O.OFC_KND_CD(+) = '2'
                 AND H.TML_SO_OFC_CTY_CD = I.TML_SO_OFC_CTY_CD
                 AND H.TML_SO_SEQ = I.TML_SO_SEQ
           ) AS OFC_CD,
           (
              SELECT H.COST_OFC_CD
                FROM TES_TML_SO_HDR H
               WHERE H.TML_SO_OFC_CTY_CD = I.TML_SO_OFC_CTY_CD
                 AND H.TML_SO_SEQ = I.TML_SO_SEQ
           ) AS COST_OFC_CD,
           v_src_sys_cd, v_src_sys_cd, INV_NO, TML_SO_OFC_CTY_CD || TML_SO_SEQ, CSR_NO, 
           NULL, VNDR_SEQ, VNDR_CUST_DIV_CD, VNDR_CNT_CD, N3PTY_VNDR_SEQ, 
           CUST_CNT_CD, CUST_SEQ, N3PTY_OFC_CD, CNTR_NO, CNTR_TPSZ_CD, 
           TML_INV_TP_CD, YD_CD, BKG_NO,
           BL_NO, SUBSTRB(FINC_SKD_DIR_CD,1,1), SUBSTRB(FINC_SKD_DIR_CD,1,2), FINC_VSL_CD, 
           FINC_SKD_VOY_NO, CURR_CD, ACCT_CD, LGS_COST_CD, IF_AMT, 
           IF_RMK, 'S', 'I', 'N', 
           NVL(UPD_USR_ID,CRE_USR_ID), SYSDATE, NVL(UPD_USR_ID,CRE_USR_ID), SYSDATE, NVL(UPD_USR_ID,CRE_USR_ID), 
           SYSDATE, 'U' EQ_KND_CD, GL_DT, VVD_CD, DECODE(GNTE_DIV_FLG,'Y','G',GNTE_DIV_FLG), NVL(in_csr_no_cxl_flg,'N')   --, TML_SO_DTL_SEQ
      FROM TES_N3RD_PTY_IF I
     WHERE TML_N3PTY_IF_STS_CD IN ('N') -- , 'P') -- Interface 대상만 
       AND TML_IF_OFC_CD = in_tml_if_ofc_cd 
       AND TML_IF_SEQ = in_tml_if_seq 
    ; 
     
    ---------------------------------- 
    IF SQL%FOUND THEN
        UPDATE TES_N3RD_PTY_IF 
           SET TML_N3PTY_IF_STS_CD = 'P', 
               UPD_DT = SYSDATE 
         WHERE TML_N3PTY_IF_STS_CD = 'N' 
           AND TML_IF_OFC_CD = in_tml_if_ofc_cd 
           AND TML_IF_SEQ = in_tml_if_seq 
        ;
    END IF
    ; 
    ----------------------------------
    TPB_ADD_OTS_DTL_STS_PRC(v_ots_dtl_seq, 'Z', in_user_id); 
    TPB_ADD_OTS_DTL_RCVR_ACT_PRC('S',v_ots_dtl_seq,'','Interfaced from '||v_src_sys_cd||'.','A','',in_user_ofc_cd,in_user_id);
            



--EXCEPTION
--    WHEN OTHERS THEN
--        v_lst_no := NULL;
--        DBMS_OUTPUT.PUT_LINE('SQL Error : ' || TO_CHAR(SQLCODE) || ' / ' || SQLERRM ); 
END

-- ===== End of Procedure ==================================
;