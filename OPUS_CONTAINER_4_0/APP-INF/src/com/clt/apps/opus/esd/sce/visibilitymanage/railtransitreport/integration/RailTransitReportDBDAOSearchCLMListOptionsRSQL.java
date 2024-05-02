/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailTransitReportDBDAOSearchCLMListOptionsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.08.07 전병석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Byoung Suk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReportDBDAOSearchCLMListOptionsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for Search options
	  * </pre>
	  */
	public RailTransitReportDBDAOSearchCLMListOptionsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.integration").append("\n"); 
		query.append("FileName : RailTransitReportDBDAOSearchCLMListOptionsRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' cntr_no," ).append("\n"); 
		query.append("'' arr_dt1," ).append("\n"); 
		query.append("'' arr_dt2," ).append("\n"); 
		query.append("'' row_size," ).append("\n"); 
		query.append("'' i_page" ).append("\n"); 
		query.append("from dual" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}