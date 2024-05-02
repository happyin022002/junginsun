/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOcheckAuthDuplAproRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.05 
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

public class AuthorizationDBDAOcheckAuthDuplAproRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auth 동시 결재 Check
	  * </pre>
	  */
	public AuthorizationDBDAOcheckAuthDuplAproRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.authorization.integration").append("\n"); 
		query.append("FileName : AuthorizationDBDAOcheckAuthDuplAproRSQL").append("\n"); 
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
		query.append("SELECT NVL((" ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("    CASE WHEN R.AUTH_APSTS_CD = 'C'" ).append("\n"); 
		query.append("    THEN 'Y'" ).append("\n"); 
		query.append("    ELSE 'N'" ).append("\n"); 
		query.append("    END CHK_VAL" ).append("\n"); 
		query.append("    FROM COM_AUTH_APRO_RQST Q, COM_AUTH_APRO_RQST_ROUT R" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND Q.AUTH_APRO_RQST_NO = @[auth_apro_rqst_no]" ).append("\n"); 
		query.append("    AND Q.AUTH_APRO_RQST_NO = R.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("    AND R.AUTH_APRO_USR_ID IN ( SELECT C.USR_ID FROM COM_USER C " ).append("\n"); 
		query.append("                                WHERE C.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                                AND NVL(C.USE_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT C.EP_ID FROM COM_USER C" ).append("\n"); 
		query.append("                                WHERE C.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                                AND NVL(C.USE_FLG, 'N') = 'Y' )" ).append("\n"); 
		query.append("),'X') CHK_VAL " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}