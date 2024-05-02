/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOUserRoleVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOUserRoleVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자의 ROLE 정보를 저장할 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOUserRoleVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.dmtcommonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOUserRoleVORSQL").append("\n"); 
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
		query.append("SELECT	'' USR_ID" ).append("\n"); 
		query.append(",	'' USR_ROLE_CD" ).append("\n"); 
		query.append(",	'' PGM_NO" ).append("\n"); 
		query.append(",	'' IS_AUTHORIZED" ).append("\n"); 
		query.append(",	'' ETC1" ).append("\n"); 
		query.append(",	'' ETC2" ).append("\n"); 
		query.append(",	'' ETC3" ).append("\n"); 
		query.append(",	'' ETC4" ).append("\n"); 
		query.append(",	'' ETC5" ).append("\n"); 
		query.append(",	'' ETC6" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}