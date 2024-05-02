/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JooFileUploadDBDAOCsrFileUploadListCSQL.java
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

public class JooFileUploadDBDAOCsrFileUploadListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 파일 업로드 등록
	  * </pre>
	  */
	public JooFileUploadDBDAOCsrFileUploadListCSQL(){
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
		params.put("file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_agmt_file_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.integration").append("\n"); 
		query.append("FileName : JooFileUploadDBDAOCsrFileUploadListCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_CSR_ATCH_FILE" ).append("\n"); 
		query.append("( CSR_NO" ).append("\n"); 
		query.append(" ,FILE_SEQ" ).append("\n"); 
		query.append(" ,FILE_SAV_ID" ).append("\n"); 
		query.append(" ,FILE_NM" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,JO_AGMT_FILE_TP_CD " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  @[csr_no] 		AS CSR_NO" ).append("\n"); 
		query.append(" ,(SELECT NVL(MAX(FILE_SEQ),0)+1 FROM JOO_CSR_ATCH_FILE WHERE CSR_NO = @[csr_no]) AS FILE_SEQ" ).append("\n"); 
		query.append(" ,@[file_sav_id] 	AS FILE_SAV_ID" ).append("\n"); 
		query.append(" ,@[file_nm]		AS FILE_NM" ).append("\n"); 
		query.append(" ,SYSDATE			AS CRE_DT" ).append("\n"); 
		query.append(" ,@[upd_usr_id]		AS CRE_USR_ID" ).append("\n"); 
		query.append(" ,SYSDATE			AS UPD_DT" ).append("\n"); 
		query.append(" ,@[upd_usr_id]		AS UPD_USR_ID" ).append("\n"); 
		query.append(" ,@[jo_agmt_file_tp_cd]	AS JO_AGMT_FILE_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}