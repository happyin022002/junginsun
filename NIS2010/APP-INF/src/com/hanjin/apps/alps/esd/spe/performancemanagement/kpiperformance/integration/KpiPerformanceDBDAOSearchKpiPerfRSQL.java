/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KpiPerformanceDBDAOSearchKpiPerfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 노영현
*@LastVersion : 1.0
* 2015.02.24 노영현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author N.Y.H
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KpiPerformanceDBDAOSearchKpiPerfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public KpiPerformanceDBDAOSearchKpiPerfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.integration").append("\n"); 
		query.append("FileName : KpiPerformanceDBDAOSearchKpiPerfRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      '' AS EG_ID" ).append("\n"); 
		query.append("    , '' AS EG_NM" ).append("\n"); 
		query.append("    , '' AS SP_KPI_ID" ).append("\n"); 
		query.append("    , '' AS SP_KPI_NM" ).append("\n"); 
		query.append("	, '' AS SP_KPI_TP_CD" ).append("\n"); 
		query.append("	, '' AS SP_KPI_TP_NM" ).append("\n"); 
		query.append("    , '' AS EV_YR" ).append("\n"); 
		query.append("	, '' AS EV_SVC_CATE_CD" ).append("\n"); 
		query.append("	, '' AS EV_SVC_CATE_NM" ).append("\n"); 
		query.append("    , '' AS SP_SEQ" ).append("\n"); 
		query.append("    , '' AS SP_NM" ).append("\n"); 
		query.append("    , '' AS JAN_RTO" ).append("\n"); 
		query.append("    , '' AS FEB_RTO" ).append("\n"); 
		query.append("    , '' AS MAR_RTO" ).append("\n"); 
		query.append("    , '' AS APR_RTO" ).append("\n"); 
		query.append("    , '' AS MAY_RTO" ).append("\n"); 
		query.append("    , '' AS JUN_RTO" ).append("\n"); 
		query.append("    , '' AS JUL_RTO" ).append("\n"); 
		query.append("    , '' AS AUG_RTO" ).append("\n"); 
		query.append("    , '' AS SEP_RTO" ).append("\n"); 
		query.append("    , '' AS OCT_RTO" ).append("\n"); 
		query.append("    , '' AS NOV_RTO" ).append("\n"); 
		query.append("    , '' AS DEC_RTO" ).append("\n"); 
		query.append("    , '' AS CRE_USR_ID" ).append("\n"); 
		query.append("    , '' AS CRE_DT" ).append("\n"); 
		query.append("    , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("    , '' AS UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, '' AS KPI_TGT_RTO" ).append("\n"); 
		query.append("    , '' AS KPI_WGT_RTO" ).append("\n"); 
		query.append("	, '' AS SCORE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, '' AS S_EV_YR" ).append("\n"); 
		query.append("	, '' AS S_EG_RHQ_CD" ).append("\n"); 
		query.append("	, '' AS S_EG_OFC_CD" ).append("\n"); 
		query.append("	, '' AS S_EV_SVC_CATE_CD" ).append("\n"); 
		query.append("	, '' AS S_SP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, '' AS HAS_SAVED" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}