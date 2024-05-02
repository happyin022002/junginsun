/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CniCommonDBDAOSearchUserRoleOfficeAreaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.08
*@LastModifier : 강환
*@LastVersion : 1.0
* 2013.08.08 강환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwan, Kang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CniCommonDBDAOSearchUserRoleOfficeAreaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자 Role , Office , Area정보 취득
	  * </pre>
	  */
	public CniCommonDBDAOSearchUserRoleOfficeAreaRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.cps.cni.common.integration").append("\n"); 
		query.append("FileName : CniCommonDBDAOSearchUserRoleOfficeAreaRSQL").append("\n"); 
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
		query.append("    CGO_CLM_USR_ROLE_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_USR_ROLE_MTCH" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND CGO_CLM_USR_ROLE_CD LIKE 'CNI%'" ).append("\n"); 

	}
}