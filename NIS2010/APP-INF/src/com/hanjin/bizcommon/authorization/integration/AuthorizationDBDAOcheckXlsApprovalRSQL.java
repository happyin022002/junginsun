/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOcheckXlsApprovalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.authorization.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationDBDAOcheckXlsApprovalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 액셀 결재인지 확인
	  * </pre>
	  */
	public AuthorizationDBDAOcheckXlsApprovalRSQL(){
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
		query.append("Path : com.hanjin.bizcommon.authorization.integration").append("\n"); 
		query.append("FileName : AuthorizationDBDAOcheckXlsApprovalRSQL").append("\n"); 
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
		query.append("SELECT PGM_BTN_NM as XLS_DOWN_CHK FROM COM_AUTH_PGM_BTN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AUTH_PGM_BTN_SEQ = (" ).append("\n"); 
		query.append("SELECT AUTH_PGM_BTN_SEQ FROM COM_AUTH_APRO_RQST" ).append("\n"); 
		query.append("WHERE AUTH_APRO_RQST_NO = @[auth_apro_rqst_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}