/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRInvAgmtLnkDBDAOInsComApFileCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
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

public class CSRInvAgmtLnkDBDAOInsComApFileCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_AP_FILE_UPLD INSERT
	  * </pre>
	  */
	public CSRInvAgmtLnkDBDAOInsComApFileCSQL(){
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
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CSRInvAgmtLnkDBDAOInsComApFileCSQL").append("\n"); 
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
		query.append("  INTO COM_AP_FILE_UPLD( ATCH_FILE_ID, AP_FILE_DIV_CD, CSR_NO, SUB_SYS_ID, INV_VNDR_SEQ, INV_NO, CSR_FILE_UPLD_TP_CD, FILE_SAV_ID, FILE_NM, FILE_RMK, ERR_RMK, DELT_FLG, DELT_USR_ID, DELT_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES( TO_CHAR(SYSDATE, 'YYYYMMDD')||LPAD(COM_AP_FILE_UPLD_SEQ.NEXTVAL, 12, '0'), -- ATCH_FILE_ID" ).append("\n"); 
		query.append("               'C', -- AP_FILE_DIV_CD" ).append("\n"); 
		query.append("               @[csr_no], -- CSR_NO" ).append("\n"); 
		query.append("               '', -- SUB_SYS_ID" ).append("\n"); 
		query.append("               '', -- INV_VNDR_SEQ" ).append("\n"); 
		query.append("               '', -- INV_NO" ).append("\n"); 
		query.append("               @[csr_file_upld_tp_cd], -- CSR_FILE_UPLD_TP_CD" ).append("\n"); 
		query.append("               @[file_sav_id], -- FILE_SAV_ID" ).append("\n"); 
		query.append("               @[file_nm], -- FILE_NM" ).append("\n"); 
		query.append("               '', -- FILE_RMK" ).append("\n"); 
		query.append("               '', -- ERR_RMK" ).append("\n"); 
		query.append("               'N', -- DELT_FLG" ).append("\n"); 
		query.append("               '', -- DELT_USR_ID" ).append("\n"); 
		query.append("               NULL, -- DELT_DT" ).append("\n"); 
		query.append("               @[cre_usr_id], -- CRE_USR_ID" ).append("\n"); 
		query.append("               SYSDATE, -- CRE_DT" ).append("\n"); 
		query.append("               @[cre_usr_id], -- UPD_USR_ID" ).append("\n"); 
		query.append("               SYSDATE -- UPD_DT" ).append("\n"); 
		query.append("               )" ).append("\n"); 

	}
}