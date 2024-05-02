/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAODocTurnTimeInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAODocTurnTimeInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAODocTurnTimeInVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAODocTurnTimeInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocTurnTimeInVORSQL").append("\n"); 
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
		query.append("'usr_id' usr_id," ).append("\n"); 
		query.append("'period_from_dt' period_from_dt," ).append("\n"); 
		query.append("'period_to_dt' period_to_dt," ).append("\n"); 
		query.append("'vvd_cd' vvd_cd," ).append("\n"); 
		query.append("'bkg_no' bkg_no," ).append("\n"); 
		query.append("'pol_cd' pol_cd," ).append("\n"); 
		query.append("'pod_cd' pod_cd," ).append("\n"); 
		query.append("'pfm_by_queue_cd' pfm_by_queue_cd," ).append("\n"); 
		query.append("'pfm_by_pic' pfm_by_pic," ).append("\n"); 
		query.append("'bkg_ofc_cd' bkg_ofc_cd," ).append("\n"); 
		query.append("'sr_knd_cd' sr_knd_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}