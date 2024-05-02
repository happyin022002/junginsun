/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselReportDBDAOVslNoonRptNotRcvVORSQL.java
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

public class VesselReportDBDAOVslNoonRptNotRcvVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주어진 조건에 대한 Lane별 Noon Report Not Receive 현황을 조회한다.
	  * </pre>
	  */
	public VesselReportDBDAOVslNoonRptNotRcvVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOVslNoonRptNotRcvVORSQL").append("\n"); 
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
		query.append("'' VSL_SLAN_CD," ).append("\n"); 
		query.append("'' VVD," ).append("\n"); 
		query.append("'' DEP_PORT_CD," ).append("\n"); 
		query.append("'' NXT_PORT_CD," ).append("\n"); 
		query.append("'' RPT_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}