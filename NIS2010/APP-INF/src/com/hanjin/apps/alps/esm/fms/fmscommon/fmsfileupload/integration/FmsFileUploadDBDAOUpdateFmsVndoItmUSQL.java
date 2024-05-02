/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FmsFileUploadDBDAOUpdateFmsVndoItmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
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

public class FmsFileUploadDBDAOUpdateFmsVndoItmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FMS VNOR ITM 수정
	  * </pre>
	  */
	public FmsFileUploadDBDAOUpdateFmsVndoItmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : FmsFileUploadDBDAOUpdateFmsVndoItmUSQL").append("\n"); 
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
		query.append("    UPDATE FMS_VNOR_ITM F" ).append("\n"); 
		query.append("    SET F.ATCH_FILE_FLET_LNK_ID = @[atch_file_lnk_id]" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND F.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    AND F.VNOR_SEQ = @[vnor_seq]" ).append("\n"); 
		query.append("    AND F.VNOR_ITM_SEQ = @[vnor_itm_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    UPDATE FMS_BUNKER F" ).append("\n"); 
		query.append("    SET  F.ATCH_FILE_FLET_LNK_ID = @[atch_file_lnk_id]" ).append("\n"); 
		query.append("        ,F.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("        ,F.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND F.FLET_CTRT_NO = @[vsl_cd]" ).append("\n"); 
		query.append("    AND F.BNK_SEQ = @[vnor_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}