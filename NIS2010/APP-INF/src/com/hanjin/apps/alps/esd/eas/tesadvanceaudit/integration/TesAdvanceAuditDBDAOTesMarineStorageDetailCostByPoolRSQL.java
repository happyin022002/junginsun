/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesMarineStorageDetailCostByPoolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesMarineStorageDetailCostByPoolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesMarineStorageDetailCostByPool
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesMarineStorageDetailCostByPoolRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesMarineStorageDetailCostByPoolRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT   Z.CALC_TP_CD" ).append("\n"); 
		query.append("  , Z.LGS_COST_CD" ).append("\n"); 
		query.append("  , (SELECT LGS_COST_FULL_NM  FROM TES_LGS_COST WHERE LGS_COST_CD = Z.LGS_COST_CD) AS LGS_COST_FULL_NM " ).append("\n"); 
		query.append("  , Z.FP_CALC_PRD_CD" ).append("\n"); 
		query.append("  , Z.PRD_YM" ).append("\n"); 
		query.append("  , Z.STK_VOL_QTY" ).append("\n"); 
		query.append("  , Z.INV_VOL_QTY" ).append("\n"); 
		query.append("  , Z.DIFF_VOL_QTY" ).append("\n"); 
		query.append("  , Z.FP_TEU_QTY" ).append("\n"); 
		query.append("  , Z.OVR_VOL_QTY" ).append("\n"); 
		query.append("  , Z.VOL_TR_UT_CD" ).append("\n"); 
		query.append("  , Z.CTRT_RT" ).append("\n"); 
		query.append("  , Z.CURR_CD" ).append("\n"); 
		query.append("  , Z.INV_XCH_RT" ).append("\n"); 
		query.append("  , Z.INV_AMT" ).append("\n"); 
		query.append("  , Z.CALC_AMT" ).append("\n"); 
		query.append("  , Z.CALC_RMK" ).append("\n"); 
		query.append("  , Z.INV_OFC_CD" ).append("\n"); 
		query.append("  , Z.INV_NO" ).append("\n"); 
		query.append("  , Z.YD_CD" ).append("\n"); 
		query.append("  , Z.VNDR_SEQ" ).append("\n"); 
		query.append("  , (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = Z.YD_CD) AS YD_NM" ).append("\n"); 
		query.append("  , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = Z.VNDR_SEQ) AS VNDR_NM  " ).append("\n"); 
		query.append("  , Z.INV_CFM_DT" ).append("\n"); 
		query.append("  , Z.FM_PRD_DT" ).append("\n"); 
		query.append("  , Z.TO_PRD_DT" ).append("\n"); 
		query.append("  , Z.TML_INV_TP_CD" ).append("\n"); 
		query.append("  , Z.TML_CALC_IND_CD" ).append("\n"); 
		query.append("  , Z.STO_DYS_IND_CD" ).append("\n"); 
		query.append("  , Z.CALC_COST_GRP_CD" ).append("\n"); 
		query.append("  , Z.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  , Z.TML_AGMT_SEQ" ).append("\n"); 
		query.append("  , Z.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("  , Z.TML_AGMT_OFC_CTY_CD || LPAD(Z.TML_AGMT_SEQ, 5, '0') AS AGMT_NO" ).append("\n"); 
		query.append("  , SUBSTR(LPAD(Z.TML_AGMT_VER_NO, 4, '0'), 0, 2 ) || '.' || SUBSTR(LPAD(Z.TML_AGMT_VER_NO, 4, '0'), 3, 2 ) AS AGMT_VER_NO" ).append("\n"); 
		query.append("  , Z.TOT_VOL" ).append("\n"); 
		query.append("  , Z.TOT_AMT" ).append("\n"); 
		query.append("  , DECODE(Z.CALC_TP_CD, 'A', Z.CTRT_RT, ROUND( Z.TOT_AMT / DECODE(Z.TOT_VOL, 0, 1, Z.TOT_VOL), 2) ) AS AVG_RT" ).append("\n"); 
		query.append("  , Z.ESTM_VOL" ).append("\n"); 
		query.append("  , DECODE(Z.CALC_TP_CD, 'A', Z.ESTM_VOL * Z.CTRT_RT * NVL(INV_XCH_RT, 1), Z.ESTM_VOL * ROUND( Z.TOT_AMT / DECODE(Z.TOT_VOL, 0, 1, Z.TOT_VOL), 2) * NVL(INV_XCH_RT, 1) ) AS ESTM_AMT" ).append("\n"); 
		query.append("  , CASE WHEN EXPN_MAX_PRMT_RTO < (1 - (CASE WHEN CALC_TP_CD = 'A'" ).append("\n"); 
		query.append("              THEN Z.ESTM_VOL * Z.CTRT_RT" ).append("\n"); 
		query.append("              ELSE Z.ESTM_VOL * ROUND( Z.TOT_AMT / DECODE(Z.TOT_VOL, 0, 1, Z.TOT_VOL), 2)" ).append("\n"); 
		query.append("             END) / DECODE(Z.INV_AMT, 0, 1, Z.INV_AMT)) * 100" ).append("\n"); 
		query.append("    THEN 'Y'" ).append("\n"); 
		query.append("    END AS EXCEED_AVG_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  , DECODE(( SELECT EAC_NO" ).append("\n"); 
		query.append("   FROM   EAS_TML_AUD E" ).append("\n"); 
		query.append("       , EAS_TML_AUD_DTL EA" ).append("\n"); 
		query.append("   WHERE  1 = 1" ).append("\n"); 
		query.append("   AND    E.INV_NO      = Z.INV_NO" ).append("\n"); 
		query.append("   AND    E.YD_CD       = Z.YD_CD" ).append("\n"); 
		query.append("   AND    E.VNDR_SEQ    = Z.VNDR_SEQ" ).append("\n"); 
		query.append("   AND    E.INV_CFM_DT  = Z.INV_CFM_DT" ).append("\n"); 
		query.append("   AND    E.INV_NO      = EA.INV_NO(+)" ).append("\n"); 
		query.append("   AND    E.VNDR_SEQ    = EA.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND    E.INV_CFM_DT  = EA.INV_CFM_DT(+)" ).append("\n"); 
		query.append("   AND    E.EXPN_AUD_SEQ   = EA.EXPN_AUD_SEQ(+)" ).append("\n"); 
		query.append("   AND    Z.CALC_TP_CD     = EA.CALC_TP_CD(+)" ).append("\n"); 
		query.append("   AND    Z.LGS_COST_CD = EA.LGS_COST_CD(+)" ).append("\n"); 
		query.append("   AND    Z.FP_CALC_PRD_CD = EA.FP_CALC_PRD_CD (+)" ).append("\n"); 
		query.append("    ), NULL, 'N', 'Y') AS EAC_FLG" ).append("\n"); 
		query.append("  , ( SELECT EXPN_AUD_SEQ" ).append("\n"); 
		query.append("   FROM EAS_TML_AUD E" ).append("\n"); 
		query.append("   WHERE  1    = 1" ).append("\n"); 
		query.append("   AND    E.INV_NO      = Z.INV_NO" ).append("\n"); 
		query.append("   AND    E.YD_CD       = Z.YD_CD" ).append("\n"); 
		query.append("   AND    E.VNDR_SEQ    = Z.VNDR_SEQ" ).append("\n"); 
		query.append("   AND    E.INV_CFM_DT  = Z.INV_CFM_DT" ).append("\n"); 
		query.append("    ) AS EXPN_AUD_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  SELECT   A.CALC_TP_CD" ).append("\n"); 
		query.append("    , A.LGS_COST_CD" ).append("\n"); 
		query.append("    , A.FP_CALC_PRD_CD" ).append("\n"); 
		query.append("    , A.PRD_YM" ).append("\n"); 
		query.append("    , A.STK_VOL_QTY" ).append("\n"); 
		query.append("    , A.INV_VOL_QTY" ).append("\n"); 
		query.append("    , A.DIFF_VOL_QTY" ).append("\n"); 
		query.append("    , A.FP_TEU_QTY" ).append("\n"); 
		query.append("    , A.OVR_VOL_QTY" ).append("\n"); 
		query.append("    , A.VOL_TR_UT_CD" ).append("\n"); 
		query.append("    , A.CTRT_RT" ).append("\n"); 
		query.append("    , A.CURR_CD" ).append("\n"); 
		query.append("    , A.INV_XCH_RT" ).append("\n"); 
		query.append("    , A.INV_AMT" ).append("\n"); 
		query.append("    , A.CALC_AMT" ).append("\n"); 
		query.append("    , A.CALC_RMK" ).append("\n"); 
		query.append("    , A.YD_CD" ).append("\n"); 
		query.append("    , A.INV_OFC_CD" ).append("\n"); 
		query.append("    , A.INV_NO" ).append("\n"); 
		query.append("    , A.VNDR_SEQ" ).append("\n"); 
		query.append("    , A.INV_CFM_DT" ).append("\n"); 
		query.append("    , A.FM_PRD_DT" ).append("\n"); 
		query.append("    , A.TO_PRD_DT" ).append("\n"); 
		query.append("    , A.TML_INV_TP_CD" ).append("\n"); 
		query.append("    , A.TML_CALC_IND_CD" ).append("\n"); 
		query.append("    , A.STO_DYS_IND_CD" ).append("\n"); 
		query.append("    , A.CALC_COST_GRP_CD" ).append("\n"); 
		query.append("    , A.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    , A.TML_AGMT_SEQ" ).append("\n"); 
		query.append("    , A.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("    , A.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("    , ( SELECT SUM(X.CNTR_TTL_QTY)" ).append("\n"); 
		query.append("      FROM EAS_TML_STO_TTL_QTY X" ).append("\n"); 
		query.append("      WHERE 1 = 1" ).append("\n"); 
		query.append("      AND  X.TML_AUD_YRMON  = A.PRD_YM" ).append("\n"); 
		query.append("      AND  X.YD_CD    = A.YD_CD" ).append("\n"); 
		query.append("      AND  X.FULL_MTY_CD  = 'M'" ).append("\n"); 
		query.append("      AND  X.STO_AUD_QTY_CLSS_CD IN ('T', 'I')" ).append("\n"); 
		query.append("      ) AS TOT_VOL" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    , ( SELECT SUM(X.CNTR_TTL_AMT)" ).append("\n"); 
		query.append("      FROM EAS_TML_STO_TTL_AMT X" ).append("\n"); 
		query.append("      WHERE 1 = 1" ).append("\n"); 
		query.append("      AND  X.TML_AUD_YRMON  = A.PRD_YM" ).append("\n"); 
		query.append("      AND  X.YD_CD    = A.YD_CD" ).append("\n"); 
		query.append("      AND  X.TML_INV_TP_CD  = 'ST'" ).append("\n"); 
		query.append("      AND  X.CALC_COST_GRP_CD = 'SP'" ).append("\n"); 
		query.append("      AND  X.LGS_COST_CD  = A.LGS_COST_CD" ).append("\n"); 
		query.append("      AND  X.CURR_CD   = A.CURR_CD" ).append("\n"); 
		query.append("      ) AS TOT_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    , ( SELECT SUM(X.CNTR_TTL_QTY)" ).append("\n"); 
		query.append("      FROM EAS_TML_STO_YD_DLY_QTY X" ).append("\n"); 
		query.append("      WHERE 1 = 1" ).append("\n"); 
		query.append("      AND  X.YD_CD    = A.YD_CD" ).append("\n"); 
		query.append("      AND  X.FULL_MTY_CD  = 'M'" ).append("\n"); 
		query.append("      AND  X.STO_AUD_QTY_CLSS_CD IN ('T', 'I')" ).append("\n"); 
		query.append("      AND  X.CNMV_DT BETWEEN A.FM_PRD_DT AND A.TO_PRD_DT" ).append("\n"); 
		query.append("      ) AS ESTM_VOL" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT   D.CALC_TP_CD" ).append("\n"); 
		query.append("      , D.LGS_COST_CD" ).append("\n"); 
		query.append("      --, DECODE(MAX(D.FP_CALC_PRD_CD), 'D', 'DAY', 'M', 'MONTH') AS FP_CALC_PRD_CD" ).append("\n"); 
		query.append("	  , MAX(D.FP_CALC_PRD_CD) AS FP_CALC_PRD_CD" ).append("\n"); 
		query.append("      , MAX(TO_CHAR(ADD_MONTHS(TO_DATE(AD.FM_PRD_DT, 'YYYYMMDD'),-1), 'YYYYMM')) AS PRD_YM" ).append("\n"); 
		query.append("      , SUM(D.STK_VOL_QTY) AS STK_VOL_QTY" ).append("\n"); 
		query.append("      , SUM(D.INV_VOL_QTY) AS INV_VOL_QTY" ).append("\n"); 
		query.append("      , SUM(D.DIFF_VOL_QTY) AS DIFF_VOL_QTY" ).append("\n"); 
		query.append("      , SUM(D.FP_TEU_QTY) AS FP_TEU_QTY" ).append("\n"); 
		query.append("      , SUM(D.OVR_VOL_QTY) AS OVR_VOL_QTY" ).append("\n"); 
		query.append("      , MAX(D.VOL_TR_UT_CD) AS VOL_TR_UT_CD" ).append("\n"); 
		query.append("      , MAX(D.CTRT_RT) AS CTRT_RT " ).append("\n"); 
		query.append("      , MAX(H.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("      , MAX(D.INV_XCH_RT) AS INV_XCH_RT" ).append("\n"); 
		query.append("      , SUM(D.INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("      , SUM(D.CALC_AMT) AS CALC_AMT" ).append("\n"); 
		query.append("      , MAX(D.CALC_RMK) AS CALC_RMK" ).append("\n"); 
		query.append("      , MAX(H.YD_CD) AS YD_CD" ).append("\n"); 
		query.append("      , MAX(H.INV_OFC_CD) AS INV_OFC_CD" ).append("\n"); 
		query.append("      , MAX(H.INV_NO) AS INV_NO" ).append("\n"); 
		query.append("      , MAX(H.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("      , MAX(H.INV_CFM_DT) AS INV_CFM_DT" ).append("\n"); 
		query.append("      , MAX(AD.FM_PRD_DT) AS FM_PRD_DT" ).append("\n"); 
		query.append("      , MAX(AD.TO_PRD_DT) AS TO_PRD_DT" ).append("\n"); 
		query.append("      , MAX(H.TML_INV_TP_CD) AS TML_INV_TP_CD" ).append("\n"); 
		query.append("      , MAX(H.TML_CALC_IND_CD) AS TML_CALC_IND_CD" ).append("\n"); 
		query.append("      , MAX(H.STO_DYS_IND_CD) AS STO_DYS_IND_CD" ).append("\n"); 
		query.append("      , MAX(D.CALC_COST_GRP_CD ) AS CALC_COST_GRP_CD " ).append("\n"); 
		query.append("      , MAX(D.TML_AGMT_OFC_CTY_CD) AS TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      , MAX(D.TML_AGMT_SEQ) AS TML_AGMT_SEQ" ).append("\n"); 
		query.append("      , MAX(D.TML_AGMT_VER_NO) AS TML_AGMT_VER_NO" ).append("\n"); 
		query.append("      , MAX(AC.EXPN_MAX_PRMT_RTO) AS EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("    FROM TES_TML_SO_HDR H" ).append("\n"); 
		query.append("      , TES_TML_SO_DTL D" ).append("\n"); 
		query.append("      , TES_TML_SO_COST SC" ).append("\n"); 
		query.append("      , EAS_TML_AUTO_AUD_CRTE AC" ).append("\n"); 
		query.append("      , EAS_TML_AUD AD" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("    AND  H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND  H.TML_SO_SEQ  = D.TML_SO_SEQ" ).append("\n"); 
		query.append("    AND  D.LGS_COST_CD  = SC.LGS_COST_CD" ).append("\n"); 
		query.append("    AND  D.LGS_COST_CD  = AC.LGS_COST_CD" ).append("\n"); 
		query.append("    AND  AC.AUD_OFC_CD  = EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(H.INV_OFC_CD)" ).append("\n"); 
		query.append("    AND  H.INV_NO     = AD.INV_NO" ).append("\n"); 
		query.append("    AND  H.VNDR_SEQ   = AD.VNDR_SEQ" ).append("\n"); 
		query.append("    AND  H.INV_CFM_DT = AD.INV_CFM_DT" ).append("\n"); 
		query.append("    AND  SC.EAS_AUD_FLG  = 'Y'" ).append("\n"); 
		query.append("    AND  H.TML_INV_TP_CD  = 'ST'" ).append("\n"); 
		query.append("    AND  D.CALC_COST_GRP_CD = 'SP'" ).append("\n"); 
		query.append("    AND  H.YD_CD    = @[s_yd_cd]" ).append("\n"); 
		query.append("    AND  H.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("    AND  H.INV_NO   = @[s_inv_no]" ).append("\n"); 
		query.append("    GROUP BY  D.CALC_TP_CD" ).append("\n"); 
		query.append("      , D.LGS_COST_CD" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("  ) Z" ).append("\n"); 

	}
}