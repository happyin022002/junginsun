/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FmsFileUploadDBDAOFileUploadListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.12 
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

public class FmsFileUploadDBDAOFileUploadListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FmsFileUploadDBDAOFileUploadListRSQL
	  * </pre>
	  */
	public FmsFileUploadDBDAOFileUploadListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.integration").append("\n"); 
		query.append("FileName : FmsFileUploadDBDAOFileUploadListRSQL").append("\n"); 
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
		query.append("#if(${vnor_itm_seq} != '')" ).append("\n"); 
		query.append("    SELECT /*+INDEX_DESC(F XPKFMS_ATCH_FILE) */" ).append("\n"); 
		query.append("           F.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("          ,F.ATCH_FILE_LNK_SEQ" ).append("\n"); 
		query.append("          ,F.FILE_SAV_ID" ).append("\n"); 
		query.append("          ,C.FILE_PATH_URL " ).append("\n"); 
		query.append("          ,C.FILE_UPLD_NM" ).append("\n"); 
		query.append("          ,TO_CHAR (F.UPD_DT, 'YYYY-MM-DD') UPD_DT  " ).append("\n"); 
		query.append("          ,F.UPD_USR_ID" ).append("\n"); 
		query.append("    	  ,'0' AS FILE_DOWNLOAD" ).append("\n"); 
		query.append("      FROM FMS_VNOR_ITM D, FMS_ATCH_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("     AND D.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("     AND D.VNOR_SEQ = @[vnor_seq]" ).append("\n"); 
		query.append("     AND D.VNOR_ITM_SEQ = @[vnor_itm_seq]" ).append("\n"); 
		query.append("     AND D.ATCH_FILE_FLET_LNK_ID = F.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("     AND F.FILE_SAV_ID  = C.FILE_SAV_ID" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT /*+INDEX_DESC(F XPKFMS_ATCH_FILE) */" ).append("\n"); 
		query.append("           F.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("          ,F.ATCH_FILE_LNK_SEQ" ).append("\n"); 
		query.append("          ,F.FILE_SAV_ID" ).append("\n"); 
		query.append("          ,C.FILE_PATH_URL " ).append("\n"); 
		query.append("          ,C.FILE_UPLD_NM" ).append("\n"); 
		query.append("          ,TO_CHAR (F.UPD_DT, 'YYYY-MM-DD') UPD_DT  " ).append("\n"); 
		query.append("          ,F.UPD_USR_ID" ).append("\n"); 
		query.append("    	  ,'0' AS FILE_DOWNLOAD" ).append("\n"); 
		query.append("      FROM FMS_BUNKER D, FMS_ATCH_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("     AND D.FLET_CTRT_NO = @[vsl_cd]" ).append("\n"); 
		query.append("     AND D.BNK_SEQ = @[vnor_seq]" ).append("\n"); 
		query.append("     AND D.ATCH_FILE_FLET_LNK_ID = F.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("     AND F.FILE_SAV_ID  = C.FILE_SAV_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}