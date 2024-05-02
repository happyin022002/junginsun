/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchBillingCaseCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.08.20 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsearchBillingCaseCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBillingCaseCode
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsearchBillingCaseCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsearchBillingCaseCodeRSQL").append("\n"); 
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
		query.append("N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("FROM TPB_N3RD_PTY_BIL_TP" ).append("\n"); 
		query.append("WHERE N3PTY_EXPN_TP_CD = 'TRS'" ).append("\n"); 
		query.append("AND N3PTY_IF_TP_CD = 'S'" ).append("\n"); 
		query.append("AND ACT_FLG = 'Y'" ).append("\n"); 

	}
}