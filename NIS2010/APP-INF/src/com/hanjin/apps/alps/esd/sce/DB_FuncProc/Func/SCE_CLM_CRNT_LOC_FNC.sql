CREATE OR REPLACE FUNCTION SCE_CLM_CRNT_LOC_FNC ( V_CNTR_NO VARCHAR2 )

/*******************************************************************************
   1. OBJECT NAME      : SCE_CLM_CRNT_LOC_FNC
   2. VERSION          : 1.0
   3. CREATE DATE      : 2011.08.16
   4. SUB SYSTEM       : SCE
   5. AUTHOR           : 김인수
   6. DESCRIPTION      : V_CNTR_NO 를 받아 CLM 상 현재 LOCATION CODE 를 반환한다.
   7. REVISION HISTORY : 2011.08.16 김인수 최초 생성
*******************************************************************************/

RETURN VARCHAR2
AUTHID CURRENT_USER 
IS
    V_LOC_CD VARCHAR2(100);

BEGIN
    
    SELECT  LOC_CD INTO V_LOC_CD
        FROM 
            ( SELECT  LEAD (CNTR_NO) OVER (ORDER BY CNTR_NO, CNMV_YR, CNMV_ID_NO, CLM_SEQ) AS STP, T1.*
            FROM 
                ( SELECT  
                    SC.CNTR_NO, SC.CNMV_YR, SC.CNMV_ID_NO, SC.CLM_SEQ,
                    MAX(TTR.EQ_TPSZ_CD) CNTR_TPSZ_CD,
                    MAX(SC.FULL_MTY_CD) FULL_MTY_CD,
                    MAX(SCS.CLM_SGHT_ABBR_NM) CLM_SGHT_ABBR_NM,
                    MAX(CASE
                        WHEN SRS.LOC_CD IS NULL
                        THEN SC.ARR_LOC_NM
                        ELSE SC.ARR_LOC_NM||' ('||SRS.LOC_CD||')'
                        END ) LOC_CD,
                    MAX(SC.ARR_STE_CD) ARR_STE_CD,
                    MAX(TO_CHAR(SC.ARR_DT, 'YYYY-MM-DD')) ARR_DATE,
                    MAX(TO_CHAR(SC.ARR_DT, 'HH24:MI')) ARR_TIME,
                    MAX(SC.CLM_CRR_NM) CLM_CRR_NM,
                    MAX(SC.TRSP_MOD_TP_CD) TRSP_MOD_TP_CD,
                    MAX(TTR.FM_NOD_CD) FM_NOD_CD,
                    MAX(SC.ARR_STE_CD) FM_STE_CD,
                    MAX(TTR.TO_NOD_CD) TO_NOD_CD,
                    MAX(SC.DEP_STE_CD) TO_STE_CD,
                    MAX(SC.DEP_LOC_NM) DEP_LOC_NM,
                    MAX(SC.TRN_NO) TRN_NO,
                    MAX(SC.FCAR_NO) FCAR_NO                 
                  FROM 
                    (SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ 
                        ,CNTR_NO,CNMV_YR,CNMV_ID_NO,CLM_SEQ
                        ,FULL_MTY_CD,ARR_DT,ARR_LOC_NM,ARR_STE_CD
                        ,CLM_CRR_NM,TRSP_MOD_TP_CD,DEP_STE_CD,TRN_NO,FCAR_NO
                        ,CLM_SGHT_CD,ARR_SPLC_CD
                        ,DEP_LOC_NM
                    FROM  SCE_CLM
                    WHERE CNTR_NO = V_CNTR_NO
                     UNION
                    SELECT SUBSTR(MAX(TO_CHAR(STR.CRE_DT, 'YYYYMMDD')
                        ||STR.TRSP_SO_OFC_CTY_CD
                        ||TO_CHAR(STR.TRSP_SO_SEQ,'000000000')), 9, 3) TRSP_SO_OFC_CTY_CD
                        ,TO_NUMBER(SUBSTR(MAX(TO_CHAR(STR.CRE_DT, 'YYYYMMDD')
                        ||STR.TRSP_SO_OFC_CTY_CD
                        ||TO_CHAR(STR.TRSP_SO_SEQ,'000000000')),12, 21)) TRSP_SO_SEQ
                        ,CNTR_NO,CNMV_YR,CNMV_ID_NO,CLM_SEQ
                        ,MAX(CMC.FULL_MTY_CD),MAX(CMC.ARR_DT),MAX(CMC.ARR_LOC_NM),MAX(CMC.ARR_STE_CD)
                        ,MAX(CMC.CLM_CRR_NM),MAX(CMC.TRSP_MOD_TP_CD),MAX(CMC.DEP_STE_CD)
                        ,MAX(CMC.TRN_NO),MAX(CMC.FCAR_NO),MAX(CMC.CLM_SGHT_CD),MAX(CMC.ARR_SPLC_CD)
                        ,MAX(CMC.DEP_LOC_NM)
                    FROM   TRS_TRSP_RAIL_BIL_ORD   STR
                    ,SCE_RAIL_SPLC RSS
                    ,SCE_CLM_IF    CMC
                    WHERE CMC.CNTR_NO        = V_CNTR_NO
                    AND   CMC.SO_MAPG_STS_CD != '52'
                    AND   CMC.CNTR_NO        = STR.EQ_NO
                    AND   SUBSTR(STR.TO_NOD_CD, 1, 5) = RSS.LOC_CD
                    AND   STR.DELT_FLG       = 'N'
                    AND   RSS.SPLC_CD        > 500
                    GROUP BY CMC.CNTR_NO,CMC.CNMV_YR,CMC.CNMV_ID_NO,CMC.CLM_SEQ ) SC,
                    SCE_CLM_SGHT SCS,
                    TRS_TRSP_RAIL_BIL_ORD TTR,
                    SCE_RAIL_SPLC SRS
    
                WHERE   SC.CLM_SGHT_CD = SCS.CLM_SGHT_CD
                AND     SC.ARR_SPLC_CD = SRS.SPLC_CD(+)
                AND     SC.TRSP_SO_OFC_CTY_CD = TTR.TRSP_SO_OFC_CTY_CD
                                    AND     SC.TRSP_SO_SEQ = TTR.TRSP_SO_SEQ
            
            
                GROUP BY SC.CNTR_NO, SC.CNMV_YR, SC.CNMV_ID_NO, SC.CLM_SEQ
                ORDER BY MAX(TO_CHAR(SC.ARR_DT, 'YYYY-MM-DD')) , MAX(TO_CHAR(SC.ARR_DT, 'HH24:MI')
            )
        ) T1 
    ) T2
    WHERE STP IS NULL;

RETURN V_LOC_CD;

END;
/
