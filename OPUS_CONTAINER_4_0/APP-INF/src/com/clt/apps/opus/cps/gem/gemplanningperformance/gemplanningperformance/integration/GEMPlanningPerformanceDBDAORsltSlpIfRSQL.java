/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAORsltSlpIfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.24 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAORsltSlpIfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GEM_SLP_IF연동관련 Temp VO
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAORsltSlpIfRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT '' CODE" ).append("\n"); 
		query.append(",'' LOCL_CURR_CD" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' SUB_OFC_CD" ).append("\n"); 
		query.append(",'' EXPN_CD" ).append("\n"); 
		query.append(",'' SUB_EXPN_CD" ).append("\n"); 
		query.append(",'' OFC_CO_DIV_CD" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration ").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAORsltSlpIfRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}