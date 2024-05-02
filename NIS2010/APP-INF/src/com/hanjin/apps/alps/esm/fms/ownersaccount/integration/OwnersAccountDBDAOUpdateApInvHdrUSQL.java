/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOUpdateApInvHdrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.05.11 민정호
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

public class OwnersAccountDBDAOUpdateApInvHdrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update ap invoice header
	  * </pre>
	  */
	public OwnersAccountDBDAOUpdateApInvHdrUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOUpdateApInvHdrUSQL").append("\n"); 
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
		query.append("UPDATE AP_INV_HDR  " ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append(" RQST_APRO_STEP_FLG = null" ).append("\n"); 
		query.append(",AP_ACCT_VER_NO = null" ).append("\n"); 
		query.append(",CSR_APRO_TP_CD = null" ).append("\n"); 
		query.append(",CSR_APRO_STEP_ASGN_RQST_DT = null" ).append("\n"); 
		query.append(",CSR_APRO_STEP_ASGN_DT = null" ).append("\n"); 
		query.append(",CSR_APRO_CMPL_DT = null" ).append("\n"); 
		query.append(",CSR_CXL_DT = null" ).append("\n"); 
		query.append(",CSR_RJCT_DT = null" ).append("\n"); 
		query.append(",GW_CSR_RQST_ID = null" ).append("\n"); 
		query.append(",APRO_USR_JB_TIT_CD = null" ).append("\n"); 
		query.append(",GW_APRO_URL_CTNT = null" ).append("\n"); 
		query.append(",AGMT_DOC_CFM_CD = null" ).append("\n"); 
		query.append(",GW_AGMT_DOC_CFM_CD = null" ).append("\n"); 
		query.append(",AGMT_FILE_CFM_CD = null" ).append("\n"); 
		query.append(",CSR_GEN_EXPN_ACCT_FLG = null" ).append("\n"); 
		query.append(",EXE_ACT_TP_CD = null" ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no]" ).append("\n"); 

	}
}