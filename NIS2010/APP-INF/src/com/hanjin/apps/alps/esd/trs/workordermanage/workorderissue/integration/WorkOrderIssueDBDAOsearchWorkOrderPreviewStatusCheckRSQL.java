/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchWorkOrderPreviewStatusCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.28
*@LastModifier : YOO Sunoh
*@LastVersion : 1.0
* 2011.12.28 YOO Sunoh
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOO Sunoh
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsearchWorkOrderPreviewStatusCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderPreviewStatusCheck
	  * WorkOrderPreview 시행 전에 issue 상태체크 조회
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsearchWorkOrderPreviewStatusCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsearchWorkOrderPreviewStatusCheckRSQL").append("\n"); 
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
		query.append("SELECT NVL(TRS_JOIN_FNC(CURSOR(SELECT TRSP_SO_OFC_CTY_CD || TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if($r_sonumber.size() > 0)" ).append("\n"); 
		query.append("AND ( TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ )  IN (" ).append("\n"); 
		query.append("#foreach($key IN ${r_sonumber})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("(SUBSTR('$key',1,3),SUBSTR('$key',4))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",(SUBSTR('$key',1,3),SUBSTR('$key',4))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("AND HJL_NO IS NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("),'N') AS CHECK_SO_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}