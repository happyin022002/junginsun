/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TPBFileUploadDBDAOSearchGetNextFileNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.01.13 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.fileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TPBFileUploadDBDAOSearchGetNextFileNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchGetNextFileNo
	  * </pre>
	  */
	public TPBFileUploadDBDAOSearchGetNextFileNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.fileupload.integration").append("\n"); 
		query.append("FileName : TPBFileUploadDBDAOSearchGetNextFileNoRSQL").append("\n"); 
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
		query.append("SELECT TPB_TTL_FILE_MGMT_SEQ1.NEXTVAL AS tpb_ttl_file_mgmt_seq" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 

	}
}