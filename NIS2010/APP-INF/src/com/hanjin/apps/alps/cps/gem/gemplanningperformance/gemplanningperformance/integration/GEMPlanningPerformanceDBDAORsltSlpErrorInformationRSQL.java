/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAORsltSlpErrorInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAORsltSlpErrorInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SLIP Error Information 정보를 보여줌
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAORsltSlpErrorInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAORsltSlpErrorInformationRSQL").append("\n"); 
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
		query.append("SELECT SLP_TJ_NO" ).append("\n"); 
		query.append("	  ,SLP_SEQ_NO" ).append("\n"); 
		query.append("      ,SLP_CURR_CD" ).append("\n"); 
		query.append("      ,SLP_CTR_CD" ).append("\n"); 
		query.append("      ,NVL(ACCT_CD, SUBS_ACCT_CD) AS ACCT_CD" ).append("\n"); 
		query.append("      ,GL_EFF_DT" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,SLP_AMT" ).append("\n"); 
		query.append("      ,SLP_IF_ERR_RSN" ).append("\n"); 
		query.append("FROM GEM_SLP_IF" ).append("\n"); 
		query.append("WHERE SLP_IF_FLG='N'" ).append("\n"); 

	}
}