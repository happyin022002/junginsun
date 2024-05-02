/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AuthorizationAssignmentDBDAOChangeUserVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.09
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2011.08.09 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationAssignmentDBDAOChangeUserVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Change User
	  * </pre>
	  */
	public AuthorizationAssignmentDBDAOChangeUserVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration").append("\n"); 
		query.append("FileName : AuthorizationAssignmentDBDAOChangeUserVORSQL").append("\n"); 
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
		query.append("SELECT A.USR_ID " ).append("\n"); 
		query.append("     , A.USR_NM" ).append("\n"); 
		query.append("     , A.OFC_CD" ).append("\n"); 
		query.append("	 , A.USR_PWD" ).append("\n"); 
		query.append("     , B.SREP_CD" ).append("\n"); 
		query.append("FROM  COM_USER A" ).append("\n"); 
		query.append("	, MDM_SLS_REP B" ).append("\n"); 
		query.append("WHERE A.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND   A.USR_ID = B.EMPE_CD(+)" ).append("\n"); 
		query.append("AND   A.USE_FLG = 'Y'" ).append("\n"); 

	}
}