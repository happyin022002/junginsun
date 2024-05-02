/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JooFileUploadDBDAOCsrFileUploadListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.03.18 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JooFileUploadDBDAOCsrFileUploadListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 파일 업로드 목록
	  * </pre>
	  */
	public JooFileUploadDBDAOCsrFileUploadListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.integration").append("\n"); 
		query.append("FileName : JooFileUploadDBDAOCsrFileUploadListRSQL").append("\n"); 
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
		query.append("SELECT /*+INDEX_DESC(J XPKJOO_CSR_ATCH_FILE) */" ).append("\n"); 
		query.append("       CSR_NO" ).append("\n"); 
		query.append("      ,FILE_SEQ" ).append("\n"); 
		query.append("      ,FILE_SAV_ID" ).append("\n"); 
		query.append("      ,FILE_NM" ).append("\n"); 
		query.append("	  ,'0' FILE_DOWNLOAD" ).append("\n"); 
		query.append("      ,TO_CHAR (UPD_DT, 'YYYY-MM-DD') UPD_DT  " ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,JO_AGMT_FILE_TP_CD" ).append("\n"); 
		query.append("  FROM JOO_CSR_ATCH_FILE J" ).append("\n"); 
		query.append(" WHERE CSR_NO = @[csr_no]" ).append("\n"); 

	}
}