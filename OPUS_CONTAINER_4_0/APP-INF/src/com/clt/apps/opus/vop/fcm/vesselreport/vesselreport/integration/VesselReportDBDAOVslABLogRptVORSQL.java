/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselReportDBDAOVslABLogRptVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.11 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOVslABLogRptVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주어진 조건에 대한 Lane별 ABLOG Report 현황을 조회한다.
	  * </pre>
	  */
	public VesselReportDBDAOVslABLogRptVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOVslABLogRptVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" ''IBFLAG," ).append("\n"); 
		query.append(" '' MSS_MTCH_RPT_CNT," ).append("\n"); 
		query.append(" '' ABLOG_RPT_CNT," ).append("\n"); 
		query.append(" '' VSL_SLAN_CD," ).append("\n"); 
		query.append(" '' MSS_RPT_CNT," ).append("\n"); 
		query.append(" '' VVD_CNT     " ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}