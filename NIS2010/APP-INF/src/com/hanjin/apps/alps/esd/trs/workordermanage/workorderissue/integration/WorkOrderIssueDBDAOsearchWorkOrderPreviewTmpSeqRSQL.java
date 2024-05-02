/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchWorkOrderPreviewTmpSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsearchWorkOrderPreviewTmpSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderPreviewTmpSeq
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsearchWorkOrderPreviewTmpSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration ").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsearchWorkOrderPreviewTmpSeqRSQL").append("\n"); 
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
		query.append("SELECT TRS_TRSP_WRK_ORD_PRV_TMP_SEQ1.NEXTVAL GROUP_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}