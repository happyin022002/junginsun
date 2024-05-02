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

public class TPBFileUploadDBDAODeleteUploadFilesCOMDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeleteRemoveUploadFiles
	  * </pre>
	  */
	public TPBFileUploadDBDAODeleteUploadFilesCOMDSQL(){
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
		query.append("FileName : TPBFileUploadDBDAODeleteUploadFilesD2SQL").append("\n"); 
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
		query.append("UPDATE COM_UPLD_FILE" ).append("\n"); 
		query.append("SET DELT_FLG = 'Y'," ).append("\n"); 
		query.append("UPD_USR_ID = @[s_user_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE FILE_SAV_ID = ( SELECT FILE_PHYS_NM FROM TPB_TTL_FILE_MGMT WHERE FILE_NO = @[s_file_no] AND FILE_NO_SEQ = @[s_temp_file_no_seq] AND CRE_USR_ID = @[s_user_id] )" ).append("\n"); 
		query.append("AND CRE_USR_ID = @[s_user_id]" ).append("\n"); 

	}
}