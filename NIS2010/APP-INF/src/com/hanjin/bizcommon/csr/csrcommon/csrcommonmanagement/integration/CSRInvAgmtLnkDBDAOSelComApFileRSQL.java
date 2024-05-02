/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRInvAgmtLnkDBDAOSelComApFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRInvAgmtLnkDBDAOSelComApFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_AP_FILE_UPLD SELECT
	  * </pre>
	  */
	public CSRInvAgmtLnkDBDAOSelComApFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_file_upld_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration").append("\n"); 
		query.append("FileName : CSRInvAgmtLnkDBDAOSelComApFileRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN F.CRE_USR_ID IS NOT NULL" ).append("\n"); 
		query.append("   AND F.CRE_USR_ID = @[cre_usr_id] THEN 'Y'" ).append("\n"); 
		query.append("         ELSE 'N'" ).append("\n"); 
		query.append("       END EDITABLE_YN ," ).append("\n"); 
		query.append("       F.ATCH_FILE_ID," ).append("\n"); 
		query.append("       F.CRE_USR_ID," ).append("\n"); 
		query.append("       C.FILE_UPLD_NM AS FILE_NM," ).append("\n"); 
		query.append("       C.FILE_PATH_URL," ).append("\n"); 
		query.append("       F.FILE_RMK," ).append("\n"); 
		query.append("       U.USR_NM," ).append("\n"); 
		query.append("       U.OFC_CD," ).append("\n"); 
		query.append("       C.FILE_SAV_ID" ).append("\n"); 
		query.append("  FROM COM_AP_FILE_UPLD F," ).append("\n"); 
		query.append("       AP_INV_HDR A," ).append("\n"); 
		query.append("       COM_UPLD_FILE C," ).append("\n"); 
		query.append("       COM_USER U" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND F.AP_FILE_DIV_CD = 'C' --CSR유형" ).append("\n"); 
		query.append("   AND F.CSR_NO = @[csr_no] --12SHAMBB14121600038" ).append("\n"); 
		query.append("   AND F.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("   AND F.CSR_FILE_UPLD_TP_CD = @[csr_file_upld_tp_cd] -- FA : Agmt File / FU : 일반 FILE (화면의 TAB구분자)" ).append("\n"); 
		query.append("   AND NVL(F.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 
		query.append("   AND NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND F.CRE_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("   AND NVL(U.USE_FLG, 'N') = 'Y'" ).append("\n"); 

	}
}