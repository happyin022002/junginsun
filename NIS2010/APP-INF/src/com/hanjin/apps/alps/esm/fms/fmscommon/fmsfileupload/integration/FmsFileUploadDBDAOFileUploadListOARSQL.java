/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FmsFileUploadDBDAOFileUploadListOARSQL.java
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

public class FmsFileUploadDBDAOFileUploadListOARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FmsFileUploadDBDAOFileUploadListOARSQL
	  * </pre>
	  */
	public FmsFileUploadDBDAOFileUploadListOARSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.integration").append("\n"); 
		query.append("FileName : FmsFileUploadDBDAOFileUploadListOARSQL").append("\n"); 
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
		query.append("SELECT /*+INDEX_DESC(F XPKFMS_ATCH_FILE) */" ).append("\n"); 
		query.append("       F.ATCH_FILE_OA_LNK_ID ," ).append("\n"); 
		query.append("       F.ATCH_FILE_OA_LNK_SEQ ," ).append("\n"); 
		query.append("       F.FILE_SAV_ID ," ).append("\n"); 
		query.append("       C.FILE_PATH_URL ," ).append("\n"); 
		query.append("       C.FILE_UPLD_NM ," ).append("\n"); 
		query.append("       TO_CHAR (F.UPD_DT, 'YYYY-MM-DD') UPD_DT ," ).append("\n"); 
		query.append("       F.UPD_USR_ID ," ).append("\n"); 
		query.append("       '0' AS FILE_DOWNLOAD" ).append("\n"); 
		query.append("  FROM FMS_OWNR_ACCT_ATCH_FILE F," ).append("\n"); 
		query.append("       COM_UPLD_FILE C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND F.ATCH_FILE_OA_LNK_ID = @[csr_no]" ).append("\n"); 
		query.append("   AND F.FILE_SAV_ID = C.FILE_SAV_ID " ).append("\n"); 

	}
}