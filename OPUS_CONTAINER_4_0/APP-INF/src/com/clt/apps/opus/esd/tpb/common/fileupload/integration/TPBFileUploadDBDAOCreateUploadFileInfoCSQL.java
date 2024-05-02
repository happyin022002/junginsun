/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TPBFileUploadDBDAOCreateUploadFileInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.fileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TPBFileUploadDBDAOCreateUploadFileInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateUploadFileInfo
	  * </pre>
	  */
	public TPBFileUploadDBDAOCreateUploadFileInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_path_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_lgc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_phys_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("file_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.fileupload.integration").append("\n"); 
		query.append("FileName : TPBFileUploadDBDAOCreateUploadFileInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO TPB_TTL_FILE_MGMT (" ).append("\n"); 
		query.append("	file_no, " ).append("\n"); 
		query.append("	file_no_seq, " ).append("\n"); 
		query.append("	delt_flg," ).append("\n"); 
		query.append("	file_lgc_nm, " ).append("\n"); 
		query.append("	file_phys_nm, " ).append("\n"); 
		query.append("	file_path_nm," ).append("\n"); 
		query.append("	cre_usr_id, " ).append("\n"); 
		query.append("	cre_dt, " ).append("\n"); 
		query.append("	upd_usr_id, " ).append("\n"); 
		query.append("	upd_dt" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	@[file_no], " ).append("\n"); 
		query.append("	@[file_no_seq], " ).append("\n"); 
		query.append("	'N'," ).append("\n"); 
		query.append("	REPLACE(@[file_lgc_nm],'''',''), " ).append("\n"); 
		query.append("	@[file_phys_nm], " ).append("\n"); 
		query.append("	@[file_path_nm]," ).append("\n"); 
		query.append("	@[cre_usr_id], " ).append("\n"); 
		query.append("	SYSDATE, " ).append("\n"); 
		query.append("	@[upd_usr_id], " ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}