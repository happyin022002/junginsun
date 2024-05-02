/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TPBFileUploadDBDAOSearchUploadFileInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.fileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TPBFileUploadDBDAOSearchUploadFileInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUploadFileInfo
	  * </pre>
	  */
	public TPBFileUploadDBDAOSearchUploadFileInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_file_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.fileupload.integration").append("\n"); 
		query.append("FileName : TPBFileUploadDBDAOSearchUploadFileInfoRSQL").append("\n"); 
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
		query.append("SELECT file_no," ).append("\n"); 
		query.append("       file_no_seq," ).append("\n"); 
		query.append("       file_lgc_nm," ).append("\n"); 
		query.append("       file_phys_nm," ).append("\n"); 
		query.append("       file_path_nm," ).append("\n"); 
		query.append("       cre_usr_id," ).append("\n"); 
		query.append("       TO_CHAR(TPB_GET_LCL_DATE_FNC(cre_dt,@[s_user_ofc_cd]),'YYYY/MM/DD HH24:MI:SS') AS cre_dt," ).append("\n"); 
		query.append("       upd_usr_id," ).append("\n"); 
		query.append("       TO_CHAR(TPB_GET_LCL_DATE_FNC(upd_dt,@[s_user_ofc_cd]),'YYYY/MM/DD HH24:MI:SS') AS upd_dt" ).append("\n"); 
		query.append("  FROM TPB_TTL_FILE_MGMT" ).append("\n"); 
		query.append(" WHERE file_no = @[s_file_no]" ).append("\n"); 
		query.append("   AND delt_flg = 'N'" ).append("\n"); 
		query.append(" ORDER BY file_no_seq" ).append("\n"); 

	}
}