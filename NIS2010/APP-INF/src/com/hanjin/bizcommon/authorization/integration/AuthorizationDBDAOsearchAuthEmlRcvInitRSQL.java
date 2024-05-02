/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOsearchAuthEmlRcvInitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.authorization.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationDBDAOsearchAuthEmlRcvInitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization 첫번째 이메일 수신자 정보를 가져온다.
	  * </pre>
	  */
	public AuthorizationDBDAOsearchAuthEmlRcvInitRSQL(){
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
		query.append("Path : com.hanjin.bizcommon.authorization.integration ").append("\n"); 
		query.append("FileName : AuthorizationDBDAOsearchAuthEmlRcvInitRSQL").append("\n"); 
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
		query.append("SELECT R.AUTH_APRO_USR_ID, U.USR_EML FROM COM_AUTH_APRO_RQST Q, COM_AUTH_APRO_RQST_ROUT R, COM_USER U" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND Q.AUTH_APRO_RQST_NO = @[auth_apro_rqst_no]" ).append("\n"); 
		query.append("AND Q.AUTH_APRO_RQST_NO = R.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("AND Q.CRNT_AUTH_APRO_RQST_SEQ = R.AUTH_APRO_RQST_ROUT_SEQ " ).append("\n"); 
		query.append("AND U.USR_ID = R.AUTH_APRO_USR_ID" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}