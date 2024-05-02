/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRApprovalCommonManagementDBDAOAproStepAndCmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.22 
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

public class CSRApprovalCommonManagementDBDAOAproStepAndCmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approval Step & Comments
	  * </pre>
	  */
	public CSRApprovalCommonManagementDBDAOAproStepAndCmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration").append("\n"); 
		query.append("FileName : CSRApprovalCommonManagementDBDAOAproStepAndCmtRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("A.APRO_RQST_NO" ).append("\n"); 
		query.append(", A.APRO_RQST_SEQ" ).append("\n"); 
		query.append(", A.APRO_USR_ID" ).append("\n"); 
		query.append(", A.APRO_USR_NM" ).append("\n"); 
		query.append(", A.APRO_OFC_CD" ).append("\n"); 
		query.append(", A.APRO_CD" ).append("\n"); 
		query.append(", A.APRO_DT" ).append("\n"); 
		query.append(", A.APRO_RMK" ).append("\n"); 
		query.append(", CASE " ).append("\n"); 
		query.append("  WHEN EXISTS (" ).append("\n"); 
		query.append("    SELECT 'X'" ).append("\n"); 
		query.append("    FROM COM_USER U" ).append("\n"); 
		query.append("    WHERE NVL(U.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("    AND U.USR_ID = @[login_usr_id]" ).append("\n"); 
		query.append("    AND U.USR_ID = A.APRO_USR_ID" ).append("\n"); 
		query.append("    --AND U.OFC_CD = A.APRO_OFC_CD" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  THEN 'Y'" ).append("\n"); 
		query.append("  ELSE 'N'" ).append("\n"); 
		query.append("  END EDITABLE_YN" ).append("\n"); 
		query.append(", AP_COM_CHK_CURR_APRO_USR_FNC((SELECT D.CSR_NO FROM COM_APRO_CSR_DTL D WHERE D.APRO_RQST_NO = A.APRO_RQST_NO),@[login_usr_id]) CHK_CURR_APRO_USR_YN" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    ROW_NUMBER() OVER (ORDER BY APRO_RQST_SEQ DESC) NO" ).append("\n"); 
		query.append("    , APRO_RQST_NO" ).append("\n"); 
		query.append("    , APRO_RQST_SEQ" ).append("\n"); 
		query.append("    , APRO_USR_ID" ).append("\n"); 
		query.append("    , APRO_USR_NM" ).append("\n"); 
		query.append("    , APRO_OFC_CD" ).append("\n"); 
		query.append("    , DECODE(NVL(APSTS_CD, ''), 'C', 'Approved', 'R', 'Disapproved', '') APRO_CD" ).append("\n"); 
		query.append("    , TO_CHAR(APRO_DT, 'yyyy-mm-dd hh24:mi') APRO_DT" ).append("\n"); 
		query.append("    , USR_CMT_CTNT APRO_RMK" ).append("\n"); 
		query.append("    FROM COM_APRO_RQST_ROUT" ).append("\n"); 
		query.append("    WHERE APRO_RQST_NO = @[apro_rqst_no]" ).append("\n"); 
		query.append("    ORDER BY APRO_RQST_SEQ DESC" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}