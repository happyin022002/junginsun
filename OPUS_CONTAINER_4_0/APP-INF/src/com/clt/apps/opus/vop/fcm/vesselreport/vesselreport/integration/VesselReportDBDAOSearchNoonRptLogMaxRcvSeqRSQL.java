/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselReportDBDAOSearchNoonRptLogMaxRcvSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.21
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.02.21 진마리아
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

public class VesselReportDBDAOSearchNoonRptLogMaxRcvSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search max sequence of noon report log for update.
	  * =====================================================
	  * </pre>
	  */
	public VesselReportDBDAOSearchNoonRptLogMaxRcvSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchNoonRptLogMaxRcvSeqRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE, 'YYYYMMDD') RCV_DT" ).append("\n"); 
		query.append("     , NVL(MAX(RCV_SEQ), 0)+1 RCV_SEQ" ).append("\n"); 
		query.append("FROM   FCM_NOON_RPT_LOG" ).append("\n"); 
		query.append("WHERE  RCV_DT = TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 

	}
}