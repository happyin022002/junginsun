/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOsearchSubSysCdAuthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.29 
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

public class AuthorizationDBDAOsearchSubSysCdAuthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auth 관련 모듈 조회
	  * </pre>
	  */
	public AuthorizationDBDAOsearchSubSysCdAuthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.authorization.integration ").append("\n"); 
		query.append("FileName : AuthorizationDBDAOsearchSubSysCdAuthRSQL").append("\n"); 
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
		query.append("DISTINCT P.SUB_SYS_CD AS SUB_SYS_CD_AUTH, P.SUB_SYS_CD AS SUB_SYS_CD" ).append("\n"); 
		query.append("FROM COM_AUTH_PGM P" ).append("\n"); 
		query.append("WHERE NVL(P.USE_FLG,'N') = 'Y'" ).append("\n"); 

	}
}