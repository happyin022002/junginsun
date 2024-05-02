/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsReportDBDAOsearchUsLastForeignPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsReportDBDAOsearchUsLastForeignPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd와 last foreign port를 이용해 crr_cd를 조회한다.
	  * </pre>
	  */
	public CndCustomsReportDBDAOsearchUsLastForeignPortRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsReportDBDAOsearchUsLastForeignPortRSQL").append("\n"); 
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
		query.append("SELECT MD.CRR_CD, SV4.VPS_PORT_CD L_POL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT SV2.VSL_CD," ).append("\n"); 
		query.append("      MAX(SV2.CLPT_SEQ) CLPT_SEQ," ).append("\n"); 
		query.append("      SV2.SKD_VOY_NO," ).append("\n"); 
		query.append("      SV2.SKD_DIR_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT VSL_CD," ).append("\n"); 
		query.append("          SKD_VOY_NO," ).append("\n"); 
		query.append("          SKD_DIR_CD," ).append("\n"); 
		query.append("          MIN(CLPT_SEQ) CLPT_SEQ" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("          AND NVL(SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("        GROUP BY VSL_CD, SKD_VOY_NO , SKD_DIR_CD ) SV1," ).append("\n"); 
		query.append("      VSK_VSL_PORT_SKD SV2," ).append("\n"); 
		query.append("      MDM_VSL_CNTR VC" ).append("\n"); 
		query.append("    WHERE SV1.VSl_CD = SV2.VSL_CD" ).append("\n"); 
		query.append("      AND SV1.SKD_VOY_NO = SV2.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND SV1.SKD_DIR_CD = SV2.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND NVL(SV2.SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("      AND SV2.CLPT_SEQ < SV1.CLPT_SEQ" ).append("\n"); 
		query.append("      AND SV1.VSL_CD = VC.VSL_CD" ).append("\n"); 
		query.append("      AND SV1.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND SV1.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND SV1.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND SV2.VPS_PORT_CD NOT IN (" ).append("\n"); 
		query.append("        SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("        WHERE CNT_CD = 'CA'" ).append("\n"); 
		query.append("          AND CSTMS_DIV_ID='CANAL_LOC_CD' )" ).append("\n"); 
		query.append("    GROUP BY SV2.VSL_CD, SV2.SKD_VOY_NO, SV2.SKD_DIR_CD ) SV3," ).append("\n"); 
		query.append("  MDM_VSL_CNTR MD," ).append("\n"); 
		query.append("  VSK_VSL_PORT_SKD SV4" ).append("\n"); 
		query.append("WHERE SV3.VSL_CD = MD.VSL_CD " ).append("\n"); 
		query.append("  AND SV3.VSl_CD = SV4.VSL_CD" ).append("\n"); 
		query.append("  AND SV3.SKD_VOY_NO = SV4.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND SV3.SKD_DIR_CD = SV4.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND SV3.CLPT_SEQ = SV4.CLPT_SEQ" ).append("\n"); 

	}
}