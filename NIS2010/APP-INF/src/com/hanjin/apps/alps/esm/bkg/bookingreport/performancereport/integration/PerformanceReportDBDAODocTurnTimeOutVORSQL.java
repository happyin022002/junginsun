/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAODocTurnTimeOutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.28 김경섭
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

public class PerformanceReportDBDAODocTurnTimeOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAODocTurnTimeOutVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAODocTurnTimeOutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocTurnTimeOutVORSQL").append("\n"); 
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
		query.append("/* For VO */" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("'mdst' mdst," ).append("\n"); 
		query.append("'queue' queue," ).append("\n"); 
		query.append("'pic' pic," ).append("\n"); 
		query.append("'bkg_no' bkg_no," ).append("\n"); 
		query.append("'sr_kind' sr_kind," ).append("\n"); 
		query.append("'DPCS_WRK_GRP_CD' DPCS_WRK_GRP_CD," ).append("\n"); 
		query.append("'SR_AMD_TP_CD' SR_AMD_TP_CD," ).append("\n"); 
		query.append("'AVG_ELAPSED_TIME_HH' AVG_ELAPSED_TIME_HH," ).append("\n"); 
		query.append("'AVG_ELAPSED_TIME_MI' AVG_ELAPSED_TIME_MI," ).append("\n"); 
		query.append("'AVG_ELAPSED_TIME_SS' AVG_ELAPSED_TIME_SS," ).append("\n"); 
		query.append("'GRP_QUE_CNT' GRP_QUE_CNT," ).append("\n"); 
		query.append("'GRP_TOTAL_ELAPSED_TIME' GRP_TOTAL_ELAPSED_TIME," ).append("\n"); 
		query.append("'SEQ' seq_no ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'vvd_cd' vvd_cd," ).append("\n"); 
		query.append("'pol_cd' pol_cd," ).append("\n"); 
		query.append("'pod_cd' pod_cd," ).append("\n"); 
		query.append("' ' elapsed_time_hh," ).append("\n"); 
		query.append("' ' elapsed_time_mi," ).append("\n"); 
		query.append("' ' elapsed_time_ss," ).append("\n"); 
		query.append("'elapsed_time' elapsed_time" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}