/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IMDGJMSQueueEAIDAOScgImdgClssCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.15
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2014.07.15 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Won, Jong-Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGJMSQueueEAIDAOScgImdgClssCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_IMDG_CLSS_CD Select
	  * </pre>
	  */
	public IMDGJMSQueueEAIDAOScgImdgClssCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGJMSQueueEAIDAOScgImdgClssCdVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("IMDG_CLSS_CD, IMDG_CLSS_CD_DESC, DELT_FLG, " ).append("\n"); 
		query.append("   CRE_USR_ID, CRE_DT, UPD_USR_ID, " ).append("\n"); 
		query.append("   UPD_DT, EAI_IF_FLG, EAI_EVNT_DT, " ).append("\n"); 
		query.append("   EAI_IF_ID" ).append("\n"); 
		query.append("FROM SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("	AND EAI_IF_FLG is null" ).append("\n"); 

	}
}