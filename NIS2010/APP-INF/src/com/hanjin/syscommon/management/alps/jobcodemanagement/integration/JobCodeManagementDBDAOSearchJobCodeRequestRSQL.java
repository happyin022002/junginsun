/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAOSearchJobCodeRequestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.03
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.06.03 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi, DukWoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JobCodeManagementDBDAOSearchJobCodeRequestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JobCodeManagementDBDAOSearchJobCodeRequestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.jobcodemanagement.integration").append("\n"); 
		query.append("FileName : JobCodeManagementDBDAOSearchJobCodeRequestRSQL").append("\n"); 
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
		query.append("SELECT DECODE((SELECT COUNT(USR_ROLE_CD)" ).append("\n"); 
		query.append("FROM COM_USR_ROLE_MTCH" ).append("\n"); 
		query.append("WHERE USR_ID = @[rqst_usr_id]" ).append("\n"); 
		query.append("AND USR_ROLE_CD = ROL.USR_ROLE_CD), 0, '0', '1') AS CHECK_VAL," ).append("\n"); 
		query.append("ROL.USR_ROLE_CD," ).append("\n"); 
		query.append("ROL.USR_ROLE_NM," ).append("\n"); 
		query.append("DECODE((SELECT COUNT(USR_ROLE_CD)" ).append("\n"); 
		query.append("FROM COM_PGM_ROLE" ).append("\n"); 
		query.append("WHERE USR_ROLE_CD = ROL.USR_ROLE_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1), 0, 'X', 'O') AS PGM_ASGN" ).append("\n"); 
		query.append("FROM COM_USR_ROLE ROL," ).append("\n"); 
		query.append("(SELECT *" ).append("\n"); 
		query.append("FROM COM_USR_ROLE_MTCH" ).append("\n"); 
		query.append("WHERE USR_ID = @[rqst_usr_id]) MTCH" ).append("\n"); 
		query.append("WHERE ROL.USR_ROLE_CD = MTCH.USR_ROLE_CD(+)" ).append("\n"); 
		query.append("AND ROL.USR_ROLE_CD IN (SELECT USR_ROLE_CD" ).append("\n"); 
		query.append("FROM COM_OFC_ROLE_MTCH" ).append("\n"); 
		query.append("WHERE OFC_CD = @[rqst_ofc_cd])" ).append("\n"); 

	}
}