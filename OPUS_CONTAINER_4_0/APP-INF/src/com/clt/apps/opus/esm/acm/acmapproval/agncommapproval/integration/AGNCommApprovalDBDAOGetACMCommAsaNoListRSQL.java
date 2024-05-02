/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommApprovalDBDAOGetACMCommAsaNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOGetACMCommAsaNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AGNCommApprovalDBDAOGetACMCommAsaNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOGetACMCommAsaNoListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.ASA_NO AS ASA_NO," ).append("\n"); 
		query.append("  A.ASA_NO||' ('||A.CURR_CD||', ' ||TO_CHAR(TO_DATE(A.ASA_PRD_FM_DT, 'YYYYMMDD'), 'YYYY/MM/DD') ||' ~ ' ||TO_CHAR(TO_DATE(A.ASA_PRD_TO_DT, 'YYYYMMDD'), 'YYYY/MM/DD') ||')' AS ASA_NAME," ).append("\n"); 
		query.append("  A.ASA_PRD_FM_DT" ).append("\n"); 
		query.append("FROM SAR_ASA_MST A," ).append("\n"); 
		query.append("  MDM_ORGANIZATION B," ).append("\n"); 
		query.append("  MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE A.AGN_CD IN (" ).append("\n"); 
		query.append("    SELECT DISTINCT AR_OFC_CD" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("       AND OFC_CD = @[agn_cd]" ).append("\n"); 
		query.append("        OR AR_OFC_CD = @[agn_cd])" ).append("\n"); 
		query.append("  AND A.OFC_CD IN (" ).append("\n"); 
		query.append("    SELECT DISTINCT AR_OFC_CD" ).append("\n"); 
		query.append("     FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND OFC_CD = @[agn_cd]" ).append("\n"); 
		query.append("       OR AR_OFC_CD = @[agn_cd])         " ).append("\n"); 
		query.append("--  AND A.EXPN_EFF_DT IS NULL" ).append("\n"); 
		query.append("--  AND A.AC_EFF_DT IS NULL" ).append("\n"); 
		query.append("  AND A.ASA_FSH_DT IS NULL" ).append("\n"); 
		query.append("  AND A.ASA_APRO_DT IS NULL" ).append("\n"); 
		query.append("--  AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("  AND A.AGN_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("  AND A.CURR_CD = B.AR_CURR_CD" ).append("\n"); 
		query.append("  AND NVL(B.SO_IF_CD, ' ') = 'O'" ).append("\n"); 
		query.append("  AND B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("  AND SYSDATE BETWEEN TO_DATE(A.ASA_PRD_FM_DT, 'YYYYMMDD') AND TO_DATE(A.ASA_PRD_TO_DT, 'YYYYMMDD') + 16" ).append("\n"); 
		query.append("ORDER BY 3 DESC" ).append("\n"); 

	}
}