/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAODocQueueReportByPolListInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.17 김경섭
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

public class PerformanceReportDBDAODocQueueReportByPolListInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAODocQueueReportByPolListInVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAODocQueueReportByPolListInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocQueueReportByPolListInVORSQL").append("\n"); 
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
		query.append("' ' period_gubun" ).append("\n"); 
		query.append(", ' ' etd_from_dt" ).append("\n"); 
		query.append(", ' ' etd_to_dt" ).append("\n"); 
		query.append(", ' ' pol_cd" ).append("\n"); 
		query.append(", ' ' total_vvd" ).append("\n"); 
		query.append(", ' ' bst_match" ).append("\n"); 
		query.append(", ' ' sr_from_dt" ).append("\n"); 
		query.append(", ' ' sr_to_dt" ).append("\n"); 
		query.append(", ' ' bkg_ofc" ).append("\n"); 
		query.append(", ' ' list_by_queue" ).append("\n"); 
		query.append(", ' ' pct_from_dt" ).append("\n"); 
		query.append(", ' ' pct_to_dt" ).append("\n"); 
		query.append(", ' ' queue_source" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' ui_id" ).append("\n"); 
		query.append(", ' ' usr_id" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' curr_page" ).append("\n"); 
		query.append(", ' ' rows_per_page" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}