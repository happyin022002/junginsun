/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DodFileUploadDBDAOCreateAtchFileLnkIdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.13
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.13 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DodFileUploadDBDAOCreateAtchFileLnkIdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 첨부파일 ID 생성
	  * </pre>
	  */
	public DodFileUploadDBDAOCreateAtchFileLnkIdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.integration").append("\n"); 
		query.append("FileName : DodFileUploadDBDAOCreateAtchFileLnkIdCSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE, 'YYYYMMDD')|| (SELECT LPAD(COUNT(1)+1,5,0) FROM (SELECT DISTINCT ATCH_FILE_LNK_ID FROM DOD_ATCH_FILE WHERE SUBSTR(ATCH_FILE_LNK_ID, 0, 8) = TO_CHAR(SYSDATE, 'YYYYMMDD')) A)" ).append("\n"); 
		query.append("	   ATCH_FILE_LNK_ID " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}