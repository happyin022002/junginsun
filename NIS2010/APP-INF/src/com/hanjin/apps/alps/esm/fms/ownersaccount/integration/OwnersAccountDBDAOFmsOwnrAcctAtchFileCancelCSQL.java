/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnersAccountDBDAOFmsOwnrAcctAtchFileCancelCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOFmsOwnrAcctAtchFileCancelCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FmsOwnrAcctAtchFile 등록
	  * </pre>
	  */
	public OwnersAccountDBDAOFmsOwnrAcctAtchFileCancelCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOFmsOwnrAcctAtchFileCancelCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_OWNR_ACCT_ATCH_FILE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" ATCH_FILE_OA_LNK_ID" ).append("\n"); 
		query.append(",ATCH_FILE_OA_LNK_SEQ" ).append("\n"); 
		query.append(",FILE_SAV_ID" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT @[new_csr_no] || SUBSTR(@[atch_file_oa_lnk_id],21,4)" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("     FROM FMS_OWNR_ACCT_ATCH_FILE F" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND F.ATCH_FILE_OA_LNK_ID = @[atch_file_oa_lnk_id]" ).append("\n"); 
		query.append("    AND F.ATCH_FILE_OA_LNK_SEQ = @[atch_file_oa_lnk_seq]" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT F.ATCH_FILE_OA_LNK_SEQ" ).append("\n"); 
		query.append("    FROM FMS_OWNR_ACCT_ATCH_FILE F" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND F.ATCH_FILE_OA_LNK_ID = @[atch_file_oa_lnk_id]" ).append("\n"); 
		query.append("    AND F.ATCH_FILE_OA_LNK_SEQ = @[atch_file_oa_lnk_seq]" ).append("\n"); 
		query.append(")  AS ATCH_FILE_OA_LNK_SEQ" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT F.FILE_SAV_ID" ).append("\n"); 
		query.append("    FROM FMS_OWNR_ACCT_ATCH_FILE F" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND F.ATCH_FILE_OA_LNK_ID = @[atch_file_oa_lnk_id]" ).append("\n"); 
		query.append("    AND F.ATCH_FILE_OA_LNK_SEQ = @[atch_file_oa_lnk_seq]" ).append("\n"); 
		query.append(")   AS FILE_SAV_ID" ).append("\n"); 
		query.append(",@[usr_id]  AS CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE    AS CRE_DT" ).append("\n"); 
		query.append(",@[usr_id]  AS UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE    AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}