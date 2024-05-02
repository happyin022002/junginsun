/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchUsaEdiLayoutListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.03.15 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchUsaEdiLayoutListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUsaEdiLayoutList
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchUsaEdiLayoutListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchUsaEdiLayoutListRSQL").append("\n"); 
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
		query.append("A.EDI_MSG_TP_CD" ).append("\n"); 
		query.append(", A.FLT_FILE_COL_SEQ" ).append("\n"); 
		query.append(", A.FLT_FILE_UT_SEQ" ).append("\n"); 
		query.append(", A.COL_NM" ).append("\n"); 
		query.append(", A.COL_LVL" ).append("\n"); 
		query.append(", A.COL_KND_CD" ).append("\n"); 
		query.append(", A.COL_LEN" ).append("\n"); 
		query.append(", A.COL_DESC" ).append("\n"); 
		query.append(", A.CRE_OFC_CD" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", A.CRE_DT" ).append("\n"); 
		query.append(", A.UPD_USR_ID" ).append("\n"); 
		query.append(", A.UPD_DT" ).append("\n"); 
		query.append(", A.DELT_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_EDI_USA_FLT_FILE_PRTP A" ).append("\n"); 
		query.append("WHERE A.EDI_MSG_TP_CD	= '204'" ).append("\n"); 
		query.append("ORDER BY A.FLT_FILE_UT_SEQ" ).append("\n"); 

	}
}