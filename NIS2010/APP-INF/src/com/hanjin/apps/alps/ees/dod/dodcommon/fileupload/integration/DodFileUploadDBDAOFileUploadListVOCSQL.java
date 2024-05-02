/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DodFileUploadDBDAOFileUploadListVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.08 손진환
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

public class DodFileUploadDBDAOFileUploadListVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public DodFileUploadDBDAOFileUploadListVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.integration").append("\n"); 
		query.append("FileName : DodFileUploadDBDAOFileUploadListVOCSQL").append("\n"); 
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
		query.append("INSERT INTO DOD_ATCH_FILE" ).append("\n"); 
		query.append("( ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append(" ,ATCH_FILE_LNK_SEQ" ).append("\n"); 
		query.append(" ,FILE_SAV_ID" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  @[atch_file_lnk_id] AS ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append(" ,(SELECT NVL(MAX(ATCH_FILE_LNK_SEQ),0)+1 FROM DOD_ATCH_FILE WHERE ATCH_FILE_LNK_ID = @[atch_file_lnk_id]) AS ATCH_FILE_LNK_SEQ" ).append("\n"); 
		query.append(" ,@[file_sav_id] 	AS FILE_SAV_ID" ).append("\n"); 
		query.append(" ,SYSDATE			AS CRE_DT" ).append("\n"); 
		query.append(" ,@[upd_usr_id]		AS CRE_USR_ID" ).append("\n"); 
		query.append(" ,SYSDATE			AS UPD_DT" ).append("\n"); 
		query.append(" ,@[upd_usr_id]		AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}