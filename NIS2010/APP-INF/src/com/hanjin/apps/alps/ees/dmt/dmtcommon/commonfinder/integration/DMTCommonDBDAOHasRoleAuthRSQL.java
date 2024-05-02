/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DMTCommonDBDAOHasRoleAuthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.26
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.07.26 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOHasRoleAuthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자가 주어진 Role 권한을 가지고 있는지 조회하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOHasRoleAuthRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOHasRoleAuthRSQL").append("\n"); 
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
		query.append("SELECT  T1.USR_ROLE_CD" ).append("\n"); 
		query.append("FROM    DMT_USR_ROLE_MTCH T1" ).append("\n"); 
		query.append("WHERE   T1.USR_ID    = @[usr_id]" ).append("\n"); 
		query.append("AND     T1.USR_ROLE_CD IN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        #foreach( $role_cd in ${role_cd_list} )" ).append("\n"); 
		query.append("          #if($velocityCount < $role_cd_list.size()) '$role_cd', #else '$role_cd' #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("ORDER BY T1.USR_ROLE_CD" ).append("\n"); 

	}
}