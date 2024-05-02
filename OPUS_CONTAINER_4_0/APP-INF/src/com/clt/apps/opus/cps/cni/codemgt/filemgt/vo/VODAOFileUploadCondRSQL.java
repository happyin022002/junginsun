/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VODAOFileUploadCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.11 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.filemgt.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VODAOFileUploadCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FileUploadCond VO생성
	  * </pre>
	  */
	public VODAOFileUploadCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.filemgt.vo").append("\n"); 
		query.append("FileName : VODAOFileUploadCondRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' CLM_FILE_SEQ" ).append("\n"); 
		query.append(",'' CLM_FILE_TP_CD" ).append("\n"); 
		query.append(",'' CGO_CLM_REF_NO" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}