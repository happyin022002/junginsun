/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOCheckAuthApprovalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOCheckAuthApprovalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization 최종 결재 여부 확인
	  * </pre>
	  */
	public ApprovalDBDAOCheckAuthApprovalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOCheckAuthApprovalRSQL").append("\n"); 
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
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("CASE R.AUTH_APSTS_CD " ).append("\n"); 
		query.append("WHEN 'C' THEN 'C' " ).append("\n"); 
		query.append("WHEN 'R' THEN 'R' " ).append("\n"); 
		query.append("ELSE 'P' END CRNT_STS" ).append("\n"); 
		query.append("FROM COM_AUTH_APRO_RQST_ROUT R" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND R.AUTH_APRO_RQST_NO = @[auth_apro_rqst_no] " ).append("\n"); 
		query.append("AND R.AUTH_APRO_RQST_ROUT_SEQ = (SELECT MAX(X.AUTH_APRO_RQST_ROUT_SEQ)" ).append("\n"); 
		query.append("                                 FROM COM_AUTH_APRO_RQST_ROUT X" ).append("\n"); 
		query.append("                                 WHERE X.AUTH_APRO_RQST_NO = R.AUTH_APRO_RQST_NO)" ).append("\n"); 
		query.append("),'X') CRNT_STS FROM DUAL" ).append("\n"); 

	}
}