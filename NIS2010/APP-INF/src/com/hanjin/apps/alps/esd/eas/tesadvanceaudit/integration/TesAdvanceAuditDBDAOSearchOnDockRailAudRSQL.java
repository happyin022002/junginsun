/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOSearchOnDockRailAudRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.30 
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

public class TesAdvanceAuditDBDAOSearchOnDockRailAudRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * On-Dock Invoice를 심사한다.
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOSearchOnDockRailAudRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOSearchOnDockRailAudRSQL").append("\n"); 
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
		query.append("SELECT INV_NO" ).append("\n"); 
		query.append("		, VNDR_SEQ" ).append("\n"); 
		query.append("		, TO_CHAR(MAX(INV_CFM_DT), 'YYYYMMDDHH24MISS') AS INV_CFM_DT" ).append("\n"); 
		query.append("		, MAX(TML_INV_TP_CD) AS TML_INV_TP_CD" ).append("\n"); 
		query.append("		, MAX(YD_CD) AS YD_CD" ).append("\n"); 
		query.append("		, TO_CHAR(MAX(ISS_DT), 'YYYYMMDDHH24MISS') ISS_DT" ).append("\n"); 
		query.append("		, MAX(EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(INV_OFC_CD)) AS RHQ_CD" ).append("\n"); 
		query.append("		, MAX(INV_OFC_CD) AS INV_OFC_CD" ).append("\n"); 
		query.append("		, MAX(COST_OFC_CD) AS COST_OFC_CD" ).append("\n"); 
		query.append("		, MAX(CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("		, SUM(INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("		, SUM(INV_AMT) AS EXPN_AUD_ESTM_AMT		     " ).append("\n"); 
		query.append("		, COUNT(DISTINCT ERR_LGS_COST_CD) AS AUD_LGS_COST_CD_QTY" ).append("\n"); 
		query.append("		, WM_CONCAT(DISTINCT VRFY_RSLT_CD_CTNT) AS VRFY_RSLT_CD_CTNT" ).append("\n"); 
		query.append("		, SUM(NVL(VOL_AUD_TGT_QTY, 0)) AS VOL_AUD_TGT_QTY" ).append("\n"); 
		query.append("		, 'S' AS BAT_VOL_RSLT_CD" ).append("\n"); 
		query.append("		, 'S' AS BAT_AMT_RSLT_CD" ).append("\n"); 
		query.append("		, 'S' AS BAT_ESTM_VOL_RSLT_CD" ).append("\n"); 
		query.append("		, LEAST(MIN(VRFY_RSLT_AUD_CD), MIN(VOL_AOTO_AUD_CD), MIN(CALC_TP_CD_AUD) ) AS AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("		, COUNT(1) AS AUD_DTL_TGT_QTY" ).append("\n"); 
		query.append("		, WM_CONCAT(DISTINCT CALC_TP_CD) AS CALC_TP_CD_CTNT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT AAA.*" ).append("\n"); 
		query.append("				, CASE WHEN VRFY_RSLT_CD_CTNT IS NOT NULL THEN 'F' ELSE 'S'" ).append("\n"); 
		query.append("				  END AS VRFY_RSLT_AUD_CD" ).append("\n"); 
		query.append("				, CASE WHEN NVL(VOL_AUD_TGT_QTY, 0) > 0 THEN 'C' ELSE 'S'" ).append("\n"); 
		query.append("				  END VOL_AOTO_AUD_CD" ).append("\n"); 
		query.append("				, CASE WHEN CALC_TP_CD = 'M' THEN 'C' ELSE 'S'" ).append("\n"); 
		query.append("				  END CALC_TP_CD_AUD" ).append("\n"); 
		query.append("				, (CASE WHEN VRFY_RSLT_CD_CTNT IS NOT NULL THEN LGS_COST_CD" ).append("\n"); 
		query.append("						WHEN NVL(VOL_AUD_TGT_QTY, 0) > 0 THEN LGS_COST_CD" ).append("\n"); 
		query.append("						WHEN CALC_TP_CD = 'M' THEN LGS_COST_CD" ).append("\n"); 
		query.append("				  END) ERR_LGS_COST_CD" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT AA.*" ).append("\n"); 
		query.append("						, (CASE WHEN AA.CALC_VOL_QTY <> AA.RVIS_VOL_QTY THEN 1 ELSE 0 END) AS VOL_AUD_TGT_QTY" ).append("\n"); 
		query.append("						, (SELECT	WM_CONCAT(DISTINCT X.DSCR_IND_CD)" ).append("\n"); 
		query.append("							FROM	TES_TML_SO_CNTR_LIST X" ).append("\n"); 
		query.append("							WHERE	X.TML_SO_OFC_CTY_CD         = AA.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("							AND		X.TML_SO_SEQ                = AA.TML_SO_SEQ" ).append("\n"); 
		query.append("							AND		NVL(X.CNTR_TPSZ_CD, 'N')    = NVL(AA.CNTR_TPSZ_CD, 'N')" ).append("\n"); 
		query.append("							AND		DECODE(X.CNTR_STY_CD, 'F', 'F', 'M') = SUBSTR(AA.LGS_COST_CD, 6, 1)" ).append("\n"); 
		query.append("							AND		NVL(X.DCGO_CLSS_CD, 'N')    = AA.DCGO_FLG" ).append("\n"); 
		query.append("							AND		DECODE(TO_CHAR(X.WRK_DT,'DY'), 'SAT', 'SA', 'SUN', 'SU', 'HOL', 'HO', 'WD') = AA.TML_WRK_DY_CD " ).append("\n"); 
		query.append("							AND		(X.VRFY_RSLT_IND_CD = 'CO' AND X.MODI_FLG = 'Y')" ).append("\n"); 
		query.append("						  ) AS VRFY_RSLT_CD_CTNT" ).append("\n"); 
		query.append("				FROM	(" ).append("\n"); 
		query.append("						SELECT  D.LGS_COST_CD" ).append("\n"); 
		query.append("								, D.CALC_TP_CD" ).append("\n"); 
		query.append("								, D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("								, D.TML_WRK_DY_CD" ).append("\n"); 
		query.append("								, DECODE(NVL(D.DCGO_IND_CD, 'N'), 'N', 'N', 'Y') AS DCGO_FLG" ).append("\n"); 
		query.append("								, SUM(D.CALC_VOL_QTY) AS CALC_VOL_QTY" ).append("\n"); 
		query.append("								, SUM(D.RVIS_VOL_QTY) AS RVIS_VOL_QTY" ).append("\n"); 
		query.append("								, MAX(D.VOL_TR_UT_CD) AS VOL_TR_UT_CD" ).append("\n"); 
		query.append("								, MAX(D.CTRT_RT) AS CTRT_RT" ).append("\n"); 
		query.append("								, MAX(H.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("								, MAX(D.INV_XCH_RT) AS INV_XCH_RT" ).append("\n"); 
		query.append("								, SUM(D.INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("								, SUM(D.CALC_AMT) AS CALC_AMT" ).append("\n"); 
		query.append("								, MAX(D.CALC_RMK) AS CALC_RMK" ).append("\n"); 
		query.append("								, MAX(D.N3PTY_FLG) AS N3PTY_FLG" ).append("\n"); 
		query.append("								, MAX(H.YD_CD) AS YD_CD" ).append("\n"); 
		query.append("								, MAX(H.INV_OFC_CD) AS INV_OFC_CD" ).append("\n"); 
		query.append("								, MAX(H.INV_NO) AS INV_NO" ).append("\n"); 
		query.append("								, MAX(H.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("								, MAX(H.INV_CFM_DT) AS INV_CFM_DT" ).append("\n"); 
		query.append("								, MAX(H.TML_INV_TP_CD) AS TML_INV_TP_CD" ).append("\n"); 
		query.append("								, MAX(H.TML_SO_OFC_CTY_CD) AS TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("								, MAX(H.TML_SO_SEQ) AS TML_SO_SEQ" ).append("\n"); 
		query.append("								, MAX(H.COST_OFC_CD) AS COST_OFC_CD" ).append("\n"); 
		query.append("								, MAX(H.ISS_DT) AS ISS_DT" ).append("\n"); 
		query.append("						FROM 	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("								, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("						WHERE	1	= 1" ).append("\n"); 
		query.append("						AND		H.TML_SO_OFC_CTY_CD     = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("						AND		H.TML_SO_SEQ            = D.TML_SO_SEQ" ).append("\n"); 
		query.append("						AND		NVL(H.DELT_FLG, 'N')    <> 'Y'" ).append("\n"); 
		query.append("						AND		H.TML_INV_STS_CD        <> 'R'" ).append("\n"); 
		query.append("						AND		H.TML_INV_RJCT_STS_CD   <> 'RJ'" ).append("\n"); 
		query.append("						AND		H.TML_INV_TP_CD         = 'ON'" ).append("\n"); 
		query.append("						AND		H.VNDR_SEQ              = @[vndr_seq]" ).append("\n"); 
		query.append("						AND		H.INV_NO                = @[inv_no]" ).append("\n"); 
		query.append("						GROUP BY D.LGS_COST_CD" ).append("\n"); 
		query.append("								, D.CALC_TP_CD" ).append("\n"); 
		query.append("								, D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("								, D.TML_WRK_DY_CD" ).append("\n"); 
		query.append("								, DECODE(NVL(D.DCGO_IND_CD, 'N'), 'N', 'N', 'Y')" ).append("\n"); 
		query.append("						) AA" ).append("\n"); 
		query.append("				) AAA" ).append("\n"); 
		query.append("		) AAAA" ).append("\n"); 
		query.append("GROUP BY INV_NO" ).append("\n"); 
		query.append("		, VNDR_SEQ" ).append("\n"); 
		query.append("		, TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		, TML_SO_SEQ" ).append("\n"); 

	}
}