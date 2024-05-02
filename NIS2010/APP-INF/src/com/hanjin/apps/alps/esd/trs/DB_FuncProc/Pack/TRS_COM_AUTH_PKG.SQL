CREATE OR REPLACE PACKAGE TRS_COM_AUTH_PKG
AUTHID CURRENT_USER
IS
/*******************************************************************************
   1. Object Name      : GET_WO_PRE_SCG_COMP_FNG
   2. Version          : 1.0
   3. Create Date      : 2015.07.20
   4. Sub System       : TRS
   5. Author           : 9014787
   6. Description      : Authorization 관련 Surcharge 정보 조회
   7. Revision History : 
*******************************************************************************/
    FUNCTION GET_WO_PRE_SCG_COMP_FNG (
        v_WO_PRV_GRP_SEQ IN VARCHAR2, v_SCG_GRP_SEQ IN VARCHAR2, v_TRSP_WO_OFC_CTY_CD IN VARCHAR2 , v_TRSP_WO_SEQ IN NUMBER)
        RETURN  NUMBER;

END TRS_COM_AUTH_PKG;
/
CREATE OR REPLACE PACKAGE BODY TRS_COM_AUTH_PKG AS

/*******************************************************************************
   1. Object Name      : GET_WO_PRE_SCG_COMP_FNG
   2. Version          : 1.0
   3. Create Date      : 2015.07.20
   4. Sub System       : TRS
   5. Author           : 9014787
   6. Description      : Authorization 관련 Surcharge 정보 조회
   7. Revision History : 
*******************************************************************************/
    FUNCTION GET_WO_PRE_SCG_COMP_FNG(v_WO_PRV_GRP_SEQ IN VARCHAR2, v_SCG_GRP_SEQ IN VARCHAR2, v_TRSP_WO_OFC_CTY_CD IN VARCHAR2 , v_TRSP_WO_SEQ IN NUMBER)
    RETURN NUMBER IS
      OUT_NAME   NUMBER(15);
    BEGIN

	SELECT MAX(CASE WHEN SDT.LGS_COST_CD = SDT_P.LGS_COST_CD THEN ( CASE WHEN SDT.SCG_AMT = SDT_P.SCG_AMT THEN 0 ELSE 1 END) ELSE 1 END) KEEP(DENSE_RANK FIRST ORDER BY 1  ASC) AS ADDI_FLG
		   INTO   OUT_NAME
	  FROM (SELECT WO_PRV_GRP_SEQ, TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, LGS_COST_CD, SCG_AMT
			  FROM TRS_TRSP_SCG_DTL_TMP
			 WHERE 1=1
			   AND LGS_COST_CD IN (SELECT LGS_COST_CD FROM TES_LGS_COST WHERE LGS_COST_SUBJ_CD IN ('SC', 'SM') AND (SUBSTR(LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(LGS_COST_CD, 3, 4) <> 'OTAX'))
			   AND WO_PRV_GRP_SEQ = v_SCG_GRP_SEQ
			   AND (TRSP_SO_OFC_CTY_CD,
						   TRSP_SO_SEQ) IN (SELECT TRSP_SO_OFC_CTY_CD,
						   TRSP_SO_SEQ
					  FROM TRS_TRSP_WRK_ORD_PRV_TMP
					 WHERE 1=1
					   AND WO_PRV_GRP_SEQ = v_WO_PRV_GRP_SEQ
					   AND TRSP_WO_OFC_CTY_CD = v_TRSP_WO_OFC_CTY_CD
					   AND TRSP_WO_SEQ = v_TRSP_WO_SEQ) ) SDT FULL OUTER JOIN 
		   (SELECT WO_PRV_GRP_SEQ, TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, LGS_COST_CD, SCG_AMT
			  FROM TRS_TRSP_SCG_DTL_TMP ISDT_P
			 WHERE 1=1
			   AND LGS_COST_CD IN (SELECT LGS_COST_CD FROM TES_LGS_COST WHERE LGS_COST_SUBJ_CD IN ('SC', 'SM') AND (SUBSTR(LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(LGS_COST_CD, 3, 4) <> 'OTAX'))
			   AND WO_PRV_GRP_SEQ = (SELECT MAX(IB.SCG_DTL_TMP_SEQ) WO_PRV_GRP_SEQ 
									   FROM TRS_TRSP_SO_HIS IA, TRS_TRSP_WRK_ORD_HIS IB
									  WHERE 1=1
										AND IA.TRSP_SO_EVNT_CD    = 'WI'
										AND IA.TRSP_WO_OFC_CTY_CD = v_TRSP_WO_OFC_CTY_CD
										AND IA.TRSP_WO_SEQ        = v_TRSP_WO_SEQ
										AND IA.TRSP_SO_OFC_CTY_CD = ISDT_P.TRSP_SO_OFC_CTY_CD 
										AND IA.TRSP_SO_SEQ        = ISDT_P.TRSP_SO_SEQ
										AND IB.TRSP_WO_OFC_CTY_CD = v_TRSP_WO_OFC_CTY_CD
										AND IB.TRSP_WO_SEQ        = v_TRSP_WO_SEQ)
			   AND (TRSP_SO_OFC_CTY_CD,
						   TRSP_SO_SEQ) IN (SELECT TRSP_SO_OFC_CTY_CD,
						   TRSP_SO_SEQ
					  FROM TRS_TRSP_WRK_ORD_PRV_TMP
					 WHERE 1=1
					   AND WO_PRV_GRP_SEQ = v_WO_PRV_GRP_SEQ
					   AND TRSP_WO_OFC_CTY_CD = v_TRSP_WO_OFC_CTY_CD
					   AND TRSP_WO_SEQ = v_TRSP_WO_SEQ) ) SDT_P ON (SDT.LGS_COST_CD = SDT_P.LGS_COST_CD )
	   AND SDT.TRSP_SO_OFC_CTY_CD = SDT_P.TRSP_SO_OFC_CTY_CD
	   AND SDT.TRSP_SO_SEQ = SDT_P.TRSP_SO_SEQ;


    RETURN   OUT_NAME;
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
        RETURN '';


    END;


END TRS_COM_AUTH_PKG;