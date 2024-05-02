/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DMTCommonDBDAOSearchDemDetOfficeListByRHQRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.21 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimTaeKyun
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
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
		query.append("	#elseif (${ofc_cd} == 'USA')" ).append("\n"); 
		query.append("		AND S.SYS_AREA_GRP_ID = 'USA'" ).append("\n"); 
		query.append("	#elseif (${ofc_cd} == 'EUR')" ).append("\n"); 
		query.append("		AND (S.SYS_AREA_GRP_ID = 'EUR' AND Y.DMDT_OFC_CD NOT IN (SELECT OFC_CD FROM TABLE( COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001','DMT')))) " ).append("\n"); 
		query.append("	#elseif (${ofc_cd} == 'CHN')" ).append("\n"); 
		query.append("		AND S.SYS_AREA_GRP_ID IN ('CHN', 'KOR')" ).append("\n"); 
		query.append("	#elseif (${ofc_cd} == 'SWA')" ).append("\n"); 
		query.append("		AND (S.SYS_AREA_GRP_ID = 'SWA' OR Y.DMDT_OFC_CD IN (SELECT OFC_CD FROM TABLE( COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001','DMT'))))" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("     AND S.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("ORDER BY Y.DMDT_OFC_CD" ).append("\n"); 

	}
}