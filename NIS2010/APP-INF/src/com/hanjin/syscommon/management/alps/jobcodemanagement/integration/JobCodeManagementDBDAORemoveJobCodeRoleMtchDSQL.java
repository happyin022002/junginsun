/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAORemoveJobCodeRoleMtchDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.05.30 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JobCodeManagementDBDAORemoveJobCodeRoleMtchDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JobCodeManagementDBDAORemoveJobCodeRoleMtchDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_role_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.jobcodemanagement.integration").append("\n"); 
		query.append("FileName : JobCodeManagementDBDAORemoveJobCodeRoleMtchDSQL").append("\n"); 
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
		query.append("DELETE FROM COM_USR_ROLE_MTCH" ).append("\n"); 
		query.append(" WHERE USR_ID = @[rqst_usr_id]" ).append("\n"); 
		query.append("   AND USR_ROLE_CD = @[usr_role_cd]" ).append("\n"); 

	}
}