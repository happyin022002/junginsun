/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FmsFileUploadDBDAOFileUploadListOADSQL.java
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

public class FmsFileUploadDBDAOFileUploadListOADSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FmsFileUploadDBDAOFileUploadListOADSQL
	  * </pre>
	  */
	public FmsFileUploadDBDAOFileUploadListOADSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_oa_lnk_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_oa_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.integration").append("\n"); 
		query.append("FileName : FmsFileUploadDBDAOFileUploadListOADSQL").append("\n"); 
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
		query.append("DELETE FROM FMS_OWNR_ACCT_ATCH_FILE " ).append("\n"); 
		query.append(" WHERE ATCH_FILE_OA_LNK_ID  = @[atch_file_oa_lnk_id]" ).append("\n"); 
		query.append("   AND ATCH_FILE_OA_LNK_SEQ = @[atch_file_oa_lnk_seq]" ).append("\n"); 

	}
}