/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOsearchNoEmlAddrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.08 
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

public class AuthorizationDBDAOsearchNoEmlAddrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 결재자 중 E-mail 유/무 확인
	  * </pre>
	  */
	public AuthorizationDBDAOsearchNoEmlAddrRSQL(){
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
		query.append("FileName : AuthorizationDBDAOsearchNoEmlAddrRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(B.USR_ID,'-')),'-') AS NO_EML_APRO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("A.USR_ID, ROWNUM ROW_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    U.USR_EML, U.USR_ID, 'R' USR_TP" ).append("\n"); 
		query.append("    FROM COM_AUTH_APRO_RQST H, COM_USER U" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND H.RQST_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("    AND H.AUTH_APRO_RQST_NO = @[auth_apro_rqst_no]" ).append("\n"); 
		query.append("    AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    --AND NVL(H.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("    AND NVL(U.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    U.USR_EML" ).append("\n"); 
		query.append("	, U.USR_ID, 'A' USR_TP" ).append("\n"); 
		query.append("    FROM COM_AUTH_APRO_RQST H, COM_AUTH_APRO_RQST_ROUT R, COM_USER U" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND H.AUTH_APRO_RQST_NO = R.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("    AND H.AUTH_APRO_RQST_NO = @[auth_apro_rqst_no]" ).append("\n"); 
		query.append("    AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    --AND NVL(H.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("    AND R.AUTH_APRO_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("    AND NVL(U.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.USR_EML IS NULL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("START WITH ROW_ID = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 

	}
}