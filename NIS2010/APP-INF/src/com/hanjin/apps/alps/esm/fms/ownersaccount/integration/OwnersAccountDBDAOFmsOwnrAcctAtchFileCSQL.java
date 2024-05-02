/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOFmsOwnrAcctAtchFileCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.04.27 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOFmsOwnrAcctAtchFileCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FmsOwnrAcctAtchFile 등록
	  * </pre>
	  */
	public OwnersAccountDBDAOFmsOwnrAcctAtchFileCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("atch_file_oa_lnk_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOFmsOwnrAcctAtchFileCSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT @[csr_no] || F.SLP_SEQ_NO " ).append("\n"); 
		query.append("    FROM FMS_CSUL_SLP F" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND F.SLP_TP_CD = SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("    AND F.SLP_FUNC_CD = SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("    AND F.SLP_OFC_CD = DECODE(LENGTH(@[csr_no]), 19, SUBSTR(@[csr_no], 4, 5), SUBSTR(@[csr_no], 4, 6))" ).append("\n"); 
		query.append("    AND F.SLP_ISS_DT = DECODE(LENGTH(@[csr_no]), 19, SUBSTR(@[csr_no], 9, 6), SUBSTR(@[csr_no], 10, 6))" ).append("\n"); 
		query.append("    AND F.SLP_SER_NO = DECODE(LENGTH(@[csr_no]), 19, SUBSTR(@[csr_no], 15, 5), SUBSTR(@[csr_no], 16, 5))" ).append("\n"); 
		query.append("    AND F.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("    AND F.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("    AND F.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("    AND F.REV_DIR_CD = SUBSTR(@[vvd],10,1)" ).append("\n"); 
		query.append(")           AS ATCH_FILE_OA_LNK_ID" ).append("\n"); 
		query.append(",@[atch_file_oa_lnk_seq]        AS ATCH_FILE_OA_LNK_SEQ" ).append("\n"); 
		query.append(",@[file_sav_id]  AS FILE_SAV_ID" ).append("\n"); 
		query.append(",@[usr_id]  AS CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE    AS CRE_DT" ).append("\n"); 
		query.append(",@[usr_id]  AS UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE    AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}