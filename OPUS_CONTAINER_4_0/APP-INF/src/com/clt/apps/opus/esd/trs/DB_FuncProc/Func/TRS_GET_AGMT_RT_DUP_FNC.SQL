CREATE OR REPLACE FUNCTION TRS_GET_AGMT_RT_DUP_FNC (
  P_TRSP_TMP_SEQ  IN NUMBER
, P_SR            IN NUMBER)
RETURN VARCHAR2
AUTHID CURRENT_USER
IS
/******************************************************************************
   Name         :   TRS_GET_AGMT_RT_DUP_FNC
   Purpose      :   Agreement Rate duplication을 체크하는 Function
   Table        :   TRS_TRSP_AGMT_TMP
   Ver          :   1.0
   Date         :   2010.04.66
   System       :   e-NIS > TRS
   Author       :   최종혁
   History      :   
******************************************************************************/
V_DUP    VARCHAR2(1000);
R_RETURN VARCHAR2(1000);

-- 중복체크
BEGIN
    SELECT 
      MAX(DECODE(SUB_ROW_NO, 0, RMK))
    ||MAX(DECODE(SUB_ROW_NO, 1, RMK))
    ||MAX(DECODE(SUB_ROW_NO, 2, RMK))
    ||MAX(DECODE(SUB_ROW_NO, 3, RMK))
    ||MAX(DECODE(SUB_ROW_NO, 4, RMK))
    ||MAX(DECODE(SUB_ROW_NO, 5, RMK))
    ||MAX(DECODE(SUB_ROW_NO, 6, RMK))
    ||MAX(DECODE(SUB_ROW_NO, 7, RMK))
    ||MAX(DECODE(SUB_ROW_NO, 8, RMK))
    ||MAX(DECODE(SUB_ROW_NO, 9, RMK)) RMK
    INTO V_DUP
      FROM (
        SELECT
            CASE WHEN
            (
                SELECT 1
                  FROM TRS_AGMT_HDR   A
                      ,TRS_AGMT_RT_TP C
                      ,TRS_AGMT_NOD   D
                      ,TRS_AGMT_EQ_RT E
                 WHERE A.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD
                   AND A.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ
                   AND C.TRSP_AGMT_OFC_CTY_CD   = D.TRSP_AGMT_OFC_CTY_CD
                   AND C.TRSP_AGMT_SEQ          = D.TRSP_AGMT_SEQ
                   AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO
                   AND D.TRSP_AGMT_OFC_CTY_CD   = E.TRSP_AGMT_OFC_CTY_CD
                   AND D.TRSP_AGMT_SEQ          = E.TRSP_AGMT_SEQ
                   AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO
                   AND D.TRSP_AGMT_NOD_SEQ      = E.TRSP_AGMT_NOD_SEQ
                   AND C.TRSP_AGMT_OFC_CTY_CD   = TT.TRSP_AGMT_OFC_CTY_CD
                   AND C.TRSP_AGMT_SEQ          = TT.TRSP_AGMT_SEQ
                   AND C.TRSP_AGMT_RT_TP_CD     = TT.TRSP_AGMT_RT_TP_CD
                   AND C.CGO_TP_CD              = TT.CGO_TP_CD
                   AND C.CUST_NOMI_TRKR_FLG     = TT.CUST_NOMI_TRKR_FLG
                   AND C.CUST_CNT_CD            = TT.CUST_CNT_CD
                   AND C.CUST_SEQ               = TT.CUST_SEQ
                   AND C.TRSP_COST_MOD_CD       = TT.TRSP_COST_MOD_CD
                   AND C.AGMT_TRSP_TP_CD        = TT.AGMT_TRSP_TP_CD
                   AND C.CMDT_GRP_CD            = TT.CMDT_GRP_CD
                   AND C.RAIL_SVC_TP_CD         = TT.RAIL_SVC_TP_CD
                   AND D.FM_NOD_CD              = TT.FM_NOD_CD
                   AND D.VIA_NOD_CD             = TT.VIA_NOD_CD
                   AND D.DOR_NOD_CD             = TT.DOR_NOD_CD
                   AND D.TO_NOD_CD              = TT.TO_NOD_CD
                   AND D.TRSP_AGMT_DIST         = TT.TRSP_AGMT_DIST
                   AND D.DIST_MEAS_UT_CD        = TT.DIST_MEAS_UT_CD
                   AND D.TRSP_DIST_TP_CD        = TT.TRSP_DIST_TP_CD
                   AND E.TRSP_AGMT_EQ_TP_SZ_CD  = TT.TRSP_AGMT_EQ_TP_CD||TT.TRSP_AGMT_EQ_SZ_CD
                   AND E.EQ_KND_CD              = TT.EQ_KND_CD            
                   AND E.WTR_RCV_TERM_CD        = TT.WTR_RCV_TERM_CD      
                   AND E.WTR_DE_TERM_CD         = TT.WTR_DE_TERM_CD       
                   AND E.TRSP_AGMT_BDL_QTY      = TT.TRSP_AGMT_BDL_QTY    
                   AND E.TO_WGT                 = TT.TO_WGT               
                   AND E.WGT_MEAS_UT_CD         = TT.WGT_MEAS_UT_CD     
                   AND ROWNUM = 1  
            )
            IS NOT NULL THEN ','|| TT.TRSP_AGMT_EQ_TP_CD||TT.TRSP_AGMT_EQ_SZ_CD END RMK
            ,TT.ROW_NO SR
            ,TT.SUB_ROW_NO
        FROM TRS_AGMT_TMP TT
        WHERE TT.TRSP_TMP_SEQ = P_TRSP_TMP_SEQ
          AND TT.ROW_NO       = P_SR
          AND NVL(TT.DELT_FLG,'N') = 'N'
          AND TT.RT_UPD_STS_CD = 'I'
    )
    GROUP BY SR;

    IF LENGTH(V_DUP) > 0 THEN
        R_RETURN := V_DUP||' Dup! ';
    END IF;

RETURN r_return;

END ;