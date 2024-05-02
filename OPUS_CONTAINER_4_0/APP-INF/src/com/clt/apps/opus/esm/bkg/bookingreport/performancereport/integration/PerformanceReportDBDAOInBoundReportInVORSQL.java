/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOInBoundReportInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.29 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOInBoundReportInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOInBoundReportInVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOInBoundReportInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOInBoundReportInVORSQL").append("\n"); 
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
		query.append("/* For In VO */" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("'eta_from_dt' eta_from_dt," ).append("\n"); 
		query.append("'eta_to_dt' eta_to_dt," ).append("\n"); 
		query.append("'cntr_cd' cntr_cd," ).append("\n"); 
		query.append("'ofc_cd' ofc_cd," ).append("\n"); 
		query.append("'staff_id' staff_id," ).append("\n"); 
		query.append("'lane_cd' lane_cd," ).append("\n"); 
		query.append("'vvd_cd' vvd_cd," ).append("\n"); 
		query.append("'pod_cd' pod_cd," ).append("\n"); 
		query.append("'del_cd' del_cd," ).append("\n"); 
		query.append("'dura_cd' dura_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}