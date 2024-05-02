/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCommonDBDAOSearchDemDetOfficeListByRHQRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.08.12 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchDemDetOfficeListByRHQRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public DMTCommonDBDAOSearchDemDetOfficeListByRHQRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchDemDetOfficeListByRHQRSQL").append("\n"); 
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
		query.append("SELECT   Y.DMDT_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION O," ).append("\n"); 
		query.append("         (SELECT DISTINCT YY.DMDT_OFC_CD DMDT_OFC_CD" ).append("\n"); 
		query.append("                     FROM MDM_YARD YY" ).append("\n"); 
		query.append("                    WHERE YY.DMDT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("                      AND NVL (YY.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                      AND (DEM_IB_CLT_FLG = 'Y' OR DEM_OB_CLT_FLG = 'Y')) Y," ).append("\n"); 
		query.append("         COM_SYS_AREA_GRP_ID S" ).append("\n"); 
		query.append("   WHERE Y.DMDT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("     AND NVL (O.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("     AND SUBSTR (O.LOC_CD, 1, 2) = S.CNT_CD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${ofc_cd} == '')" ).append("\n"); 
		query.append("		AND S.SYS_AREA_GRP_ID IN ('USA', 'EUR', 'CHN', 'KOR', 'SWA')" ).append("\n"); 
		query.append("	#elseif (${ofc_cd} == 'NYCRA')" ).append("\n"); 
		query.append("		AND S.SYS_AREA_GRP_ID = 'USA'" ).append("\n"); 
		query.append("	#elseif (${ofc_cd} == 'HAMRU')" ).append("\n"); 
		query.append("		AND (S.SYS_AREA_GRP_ID = 'EUR' AND Y.DMDT_OFC_CD <> 'AISBA') " ).append("\n"); 
		query.append("	#elseif (${ofc_cd} == 'SHARC')" ).append("\n"); 
		query.append("		AND S.SYS_AREA_GRP_ID IN ('CHN', 'KOR')" ).append("\n"); 
		query.append("	#elseif (${ofc_cd} == 'SINRS')" ).append("\n"); 
		query.append("		AND (S.SYS_AREA_GRP_ID = 'SWA' OR Y.DMDT_OFC_CD = 'AISBA')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     AND S.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("ORDER BY Y.DMDT_OFC_CD" ).append("\n"); 

	}
}