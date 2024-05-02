/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportDBDAOMaxNoonRcvSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOMaxNoonRcvSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FCM_NOON_RPT_LOG table  max seq
	  * </pre>
	  */
	public VesselReportDBDAOMaxNoonRcvSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration ").append("\n"); 
		query.append("FileName : VesselReportDBDAOMaxNoonRcvSeqRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("select MAX(RCV_SEQ) rcvseq from FCM_NOON_RPT_LOG where SUBSTR(RCV_SEQ,0,8) = to_char(sysdate,'yyyymmdd')" ).append("\n"); 

	}
}