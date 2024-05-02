/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOsearchAuthSndEmlPgmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24 
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

public class AuthorizationDBDAOsearchAuthSndEmlPgmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auth 메일 발송 내용 중 요청 화면 정보 조회
	  * </pre>
	  */
	public AuthorizationDBDAOsearchAuthSndEmlPgmRSQL(){
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
		query.append("FileName : AuthorizationDBDAOsearchAuthSndEmlPgmRSQL").append("\n"); 
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
		query.append("SELECT H.RQST_USR_ID" ).append("\n"); 
		query.append("	  ,H.RQST_USR_NM" ).append("\n"); 
		query.append("	  ,P.SUB_SYS_CD" ).append("\n"); 
		query.append("	  ,C.PGM_NM" ).append("\n"); 
		query.append("	  ,TO_CHAR(H.RQST_ST_DT, 'YYYY/MM/DD HH24:MI:SS') AS RQST_ST_DT" ).append("\n"); 
		query.append("	  --,H.AUTH_APRO_RQST_RMK" ).append("\n"); 
		query.append("	  ,U.USR_EML" ).append("\n"); 
		query.append("FROM  COM_AUTH_APRO_RQST H, COM_AUTH_PGM_BTN B, COM_AUTH_PGM P, COM_PROGRAM C, COM_USER U" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.AUTH_APRO_RQST_NO = @[auth_apro_rqst_no]" ).append("\n"); 
		query.append("AND H.AUTH_PGM_BTN_SEQ = B.AUTH_PGM_BTN_SEQ" ).append("\n"); 
		query.append("AND B.AUTH_PGM_SEQ = P.AUTH_PGM_SEQ" ).append("\n"); 
		query.append("AND P.PGM_NO = C.PGM_NO" ).append("\n"); 
		query.append("AND H.RQST_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("AND NVL(H.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(B.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(P.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(C.USE_FLG,'N') = 'Y'" ).append("\n"); 

	}
}