/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TPBFileUploadDBDAODeleteUploadFilesDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.01.04 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.fileupload.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TPBFileUploadDBDAODeleteUploadFilesDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeleteRemoveUploadFiles
	  * </pre>
	  */
	public TPBFileUploadDBDAODeleteUploadFilesDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_temp_file_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_file_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.fileupload.integration ").append("\n"); 
		query.append("FileName : TPBFileUploadDBDAODeleteUploadFilesDSQL").append("\n"); 
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
		query.append("UPDATE TPB_TTL_FILE_MGMT" ).append("\n"); 
		query.append("SET delt_flg = 'Y'," ).append("\n"); 
		query.append("upd_usr_id = @[s_user_id]," ).append("\n"); 
		query.append("upd_dt = SYSDATE" ).append("\n"); 
		query.append("WHERE file_no = @[s_file_no]" ).append("\n"); 
		query.append("AND file_no_seq = @[s_temp_file_no_seq]" ).append("\n"); 
		query.append("AND cre_usr_id = @[s_user_id]" ).append("\n"); 

	}
}