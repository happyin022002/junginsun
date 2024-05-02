/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PnlReportDBDAOSearchSvcScpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PnlReportDBDAOSearchSvcScpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.11 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 의 Service Scope 콤보 Item
	  * </pre>
	  */
	public PnlReportDBDAOSearchSvcScpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.integration").append("\n"); 
		query.append("FileName : PnlReportDBDAOSearchSvcScpRSQL").append("\n"); 
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
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append("FROM    MDM_SVC_SCP" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_xcld_svc_scp} == 'Y')" ).append("\n"); 
		query.append("AND     SVC_SCP_CD NOT IN ('TPE','TPW','ACE','ACW','TAE','TAW','ASE','ASW','MMW','MME','SAN','SAS','CAN','CAS','CSE','CME','MWS','MWN','CCS','CCN','CLN','CLS','ISA')" ).append("\n"); 
		query.append("#elseif (${s_xcld_svc_scp} == 'N')" ).append("\n"); 
		query.append("AND     SVC_SCP_CD IN ('TPE','TPW','ACE','ACW','TAE','TAW','ASE','ASW','MMW','MME','SAN','SAS','CAN','CAS','CSE','CME','MWS','MWN','CCS','CCN','CLN','CLS','ISA')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}