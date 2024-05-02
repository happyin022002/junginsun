/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FmsFileUploadDBDAOFileUploadListOACSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FmsFileUploadDBDAOFileUploadListOACSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FmsFileUploadDBDAOFileUploadListOACSQL
	  * </pre>
	  */
	public FmsFileUploadDBDAOFileUploadListOACSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.integration").append("\n"); 
		query.append("FileName : FmsFileUploadDBDAOFileUploadListOACSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO FMS_OWNR_ACCT_ATCH_FILE " ).append("\n"); 
		query.append("  ( ATCH_FILE_OA_LNK_ID " ).append("\n"); 
		query.append("  , ATCH_FILE_OA_LNK_SEQ " ).append("\n"); 
		query.append("  , FILE_SAV_ID , CRE_DT " ).append("\n"); 
		query.append("  , CRE_USR_ID " ).append("\n"); 
		query.append("  , UPD_DT " ).append("\n"); 
		query.append("  , UPD_USR_ID )" ).append("\n"); 
		query.append("  SELECT @[atch_file_lnk_id] AS ATCH_FILE_OA_LNK_ID ," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(ATCH_FILE_OA_LNK_SEQ), 0)+1" ).append("\n"); 
		query.append("          FROM FMS_OWNR_ACCT_ATCH_FILE" ).append("\n"); 
		query.append("         WHERE ATCH_FILE_OA_LNK_ID = @[atch_file_lnk_id]) AS ATCH_FILE_OA_LNK_SEQ ," ).append("\n"); 
		query.append("       @[file_sav_id] AS FILE_SAV_ID ," ).append("\n"); 
		query.append("       SYSDATE AS CRE_DT ," ).append("\n"); 
		query.append("       @[upd_usr_id] AS CRE_USR_ID ," ).append("\n"); 
		query.append("       SYSDATE AS UPD_DT ," ).append("\n"); 
		query.append("       @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM DUAL " ).append("\n"); 

	}
}