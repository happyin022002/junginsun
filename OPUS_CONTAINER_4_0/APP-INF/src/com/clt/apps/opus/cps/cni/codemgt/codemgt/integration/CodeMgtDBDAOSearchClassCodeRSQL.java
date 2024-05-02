/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodeMgtDBDAOSearchClassCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.03.18 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeMgtDBDAOSearchClassCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Class Code 조회
	  * </pre>
	  */
	public CodeMgtDBDAOSearchClassCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : CodeMgtDBDAOSearchClassCodeRSQL").append("\n"); 
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
		query.append("	CLSS_CLM_MISC_CD" ).append("\n"); 
		query.append(",	CLSS_CLM_MISC_NM" ).append("\n"); 
		query.append(",	CLSS_CLM_MISC_ABBR_NM" ).append("\n"); 
		query.append(",	CLSS_CLM_MISC_RMK" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR (CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR (UPD_DT, 'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("FROM CNI_CLSS_MISC_CD" ).append("\n"); 
		query.append("ORDER BY CLSS_CLM_MISC_NM" ).append("\n"); 

	}
}