/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOsearchAuthSndEmlAproDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.26 
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

public class AuthorizationDBDAOsearchAuthSndEmlAproDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auth 결재관련 메일 내용 중 결재자 목록 및 내역 정보 조회
	  * </pre>
	  */
	public AuthorizationDBDAOsearchAuthSndEmlAproDtlRSQL(){
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
		query.append("FileName : AuthorizationDBDAOsearchAuthSndEmlAproDtlRSQL").append("\n"); 
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
		query.append("SELECT R.AUTH_APRO_RQST_ROUT_SEQ, R.AUTH_APRO_USR_ID, R.AUTH_APRO_USR_NM," ).append("\n"); 
		query.append("CASE WHEN R.AUTH_APSTS_CD = 'C'" ).append("\n"); 
		query.append("THEN TO_CHAR(R.AUTH_APRO_DT,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END AUTH_APRO_DT," ).append("\n"); 
		query.append("CASE WHEN R.AUTH_APSTS_CD = 'R'" ).append("\n"); 
		query.append("THEN TO_CHAR(R.AUTH_APRO_DT,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END AUTH_RJCT_DT" ).append("\n"); 
		query.append("FROM COM_AUTH_APRO_RQST H, COM_AUTH_APRO_RQST_ROUT R" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.AUTH_APRO_RQST_NO = @[auth_apro_rqst_no]" ).append("\n"); 
		query.append("AND H.AUTH_APRO_RQST_NO = R.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("ORDER BY R.AUTH_APRO_RQST_ROUT_SEQ ASC" ).append("\n"); 

	}
}