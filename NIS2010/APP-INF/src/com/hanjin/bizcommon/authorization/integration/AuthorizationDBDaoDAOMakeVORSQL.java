/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDaoDAOMakeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.20 
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

public class AuthorizationDBDaoDAOMakeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO생성용
	  * </pre>
	  */
	public AuthorizationDBDaoDAOMakeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.authorization.integration").append("\n"); 
		query.append("FileName : AuthorizationDBDaoDAOMakeVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' SUB_SYS_CD_AUTH," ).append("\n"); 
		query.append("'' PGM_NO," ).append("\n"); 
		query.append("'' PGM_NM," ).append("\n"); 
		query.append("'' AUTH_APRO_ROUT_USR_SEQ," ).append("\n"); 
		query.append("'' AUTH_APRO_JB_TIT_NM," ).append("\n"); 
		query.append("'' AUTH_APRO_USR_ID," ).append("\n"); 
		query.append("'' AUTH_APRO_ROUT_SEQ," ).append("\n"); 
		query.append("'' AUTH_APRO_USR_NM," ).append("\n"); 
		query.append("'' AUTH_APRO_OFC_CD," ).append("\n"); 
		query.append("'' AUTH_APRO_OFC_NM," ).append("\n"); 
		query.append("'' AUTH_APRO_TP_CD," ).append("\n"); 
		query.append("'' OFC_CD_AUTH," ).append("\n"); 
		query.append("'' OFC_CD," ).append("\n"); 
		query.append("'' USR_ID," ).append("\n"); 
		query.append("'' USR_NM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}