/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CanalTransitFeeInvoiceBCDBDAOsearchCanalTzOwnerAccountInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeInvoiceBCDBDAOsearchCanalTzOwnerAccountInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * O/A비용을 FMS에서 보여주기 위함.
	  * </pre>
	  */
	public CanalTransitFeeInvoiceBCDBDAOsearchCanalTzOwnerAccountInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeInvoiceBCDBDAOsearchCanalTzOwnerAccountInterfaceRSQL").append("\n"); 
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
		query.append("SELECT X.VSL_CD,      " ).append("\n"); 
		query.append("       X.SKD_VOY_NO,                " ).append("\n"); 
		query.append("       X.SKD_DIR_CD, " ).append("\n"); 
		query.append("       SUBSTR(X.YD_CD,1,5) AS YD_CD ," ).append("\n"); 
		query.append("       RLANE_DIR_CD,  " ).append("\n"); 
		query.append("       SUM(X.RQST_AMT) AS RQST_AMT, " ).append("\n"); 
		query.append("       WM_CONCAT(X.FILE_SAV_ID) AS FILE_SAV_ID," ).append("\n"); 
		query.append("       'PSO-OA-'||SUBSTR(X.YD_CD,1,5)||'-'||X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD AS RMK," ).append("\n"); 
		query.append("       MIN(TO_CHAR(X.VPS_ETD_DT,'YYYY-MM-DD')) AS INVOICE_DT," ).append("\n"); 
		query.append("       MAX(X.INV_NO)||MAX(X.CALL_SEQ) AS INV_NO" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append(" SELECT  A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.YD_CD,  B.RQST_AMT, D.FILE_SAV_ID," ).append("\n"); 
		query.append("        ( SELECT L.RLANE_DIR_CD" ).append("\n"); 
		query.append("	        FROM VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("  		      	 AR_MST_REV_VVD L" ).append("\n"); 
		query.append("	       WHERE V.VSL_CD                 = L.VSL_CD" ).append("\n"); 
		query.append("		     AND V.SKD_VOY_NO             = L.SKD_VOY_NO" ).append("\n"); 
		query.append("		     AND V.SKD_DIR_CD             = L.SKD_DIR_CD" ).append("\n"); 
		query.append("		     AND V.SLAN_CD                = L.SLAN_CD" ).append("\n"); 
		query.append("		     AND V.VSL_CD                 = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("		     AND V.SKD_VOY_NO             = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("		     AND V.SKD_DIR_CD             = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("		     AND V.VPS_PORT_CD            = (SELECT SUBSTR(X.YD_CD, 1, 5)" ).append("\n"); 
		query.append("   										       FROM PSO_CHARGE X" ).append("\n"); 
		query.append("    									      WHERE ISS_CTY_CD = (SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("        													  		     ISS_CTY_CD" ).append("\n"); 
		query.append("      														        FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("      														       WHERE T1.ISS_CTY_CD = 'PUS'" ).append("\n"); 
		query.append("    														         AND T1.SO_SEQ      >= 0" ).append("\n"); 
		query.append("      															     AND ROWNUM         <=1" ).append("\n"); 
		query.append("     														)" ).append("\n"); 
		query.append("    									        AND SO_SEQ =(SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("        															SO_SEQ" ).append("\n"); 
		query.append("      														  FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("      														 WHERE T1.ISS_CTY_CD = 'PUS'" ).append("\n"); 
		query.append("      														   AND T1.SO_SEQ      >= 0" ).append("\n"); 
		query.append("     														   AND ROWNUM         <=1" ).append("\n"); 
		query.append("      														 )" ).append("\n"); 
		query.append("    									)" ).append("\n"); 
		query.append("		AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("		AND L.RLANE_CD = NVL(PSO_GET_REV_LANE_FNC(substr(@[vvd], 1, 4), substr(@[vvd], 5, 4),  substr(@[vvd], 9, 1), V.VPS_PORT_CD), L.RLANE_CD) ) AS RLANE_DIR_CD," ).append("\n"); 
		query.append("     ( SELECT MIN(VPS_ETD_DT)" ).append("\n"); 
		query.append("         FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("        WHERE VSL_CD        = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("          AND SKD_VOY_NO    = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          AND SKD_DIR_CD    = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("          AND VPS_PORT_CD   = SUBSTR(A.YD_CD,1,5) ) AS VPS_ETD_DT," ).append("\n"); 
		query.append("       A.CALL_SEQ , " ).append("\n"); 
		query.append("       DECODE (VNDR_LGL_ENG_NM,NULL, ' ', SUBSTR (VNDR_LGL_ENG_NM, 1, 1))|| '-'||@[vvd]|| '-INV-' AS INV_NO" ).append("\n"); 
		query.append("FROM PSO_CNL_TZ_FEE A, PSO_CNL_TZ_FEE_DTL B, PSO_CNL_TZ_ATCH_FILE C, COM_UPLD_FILE D, MDM_VENDOR E" ).append("\n"); 
		query.append("WHERE A.PSO_BZTP_CD        = B.PSO_BZTP_CD" ).append("\n"); 
		query.append("  AND A.VSL_CD             = B.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO         = B.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD         = B.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.YD_CD              = B.YD_CD" ).append("\n"); 
		query.append("  AND A.CNL_TZ_BZTP_CD     = 'I'" ).append("\n"); 
		query.append("  AND A.CALL_SEQ           = B.CALL_SEQ" ).append("\n"); 
		query.append("  AND A.VSL_CD             = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO         = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD         = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("  AND B.LGS_COST_CD        LIKE 'CNOW%' " ).append("\n"); 
		query.append("  AND A.CNL_TZ_PROC_STS_CD = 'A' " ).append("\n"); 
		query.append("  AND C.LGS_COST_CD        = B.LGS_COST_CD" ).append("\n"); 
		query.append("  AND C.CALL_SEQ           = A.CALL_SEQ" ).append("\n"); 
		query.append("  AND C.VSL_CD             = A.VSL_CD" ).append("\n"); 
		query.append("  AND C.SKD_VOY_NO         = A.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND C.SKD_DIR_CD         = A.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND C.YD_CD              = A.YD_CD" ).append("\n"); 
		query.append("  AND A.PSO_BZTP_CD        = '5'" ).append("\n"); 
		query.append("  AND C.FILE_SAV_ID        = D.FILE_SAV_ID " ).append("\n"); 
		query.append("  AND E.VNDR_SEQ           = A.VNDR_SEQ ) X" ).append("\n"); 
		query.append("  GROUP BY X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, SUBSTR(X.YD_CD,1,5), X.RLANE_DIR_CD," ).append("\n"); 
		query.append("   'PSO-OA-'||SUBSTR(X.YD_CD,1,5)||'-'||X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD" ).append("\n"); 

	}
}