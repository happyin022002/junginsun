/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAOsearchProgJobListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JobCodeManagementDBDAOsearchProgJobListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JobCodeManagementDBDAOsearchProgJobListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.jobcodemanagement.integration").append("\n"); 
		query.append("FileName : JobCodeManagementDBDAOsearchProgJobListRSQL").append("\n"); 
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
		query.append("#if(${fcmd} == '2')" ).append("\n"); 
		query.append("SELECT LEVEL, " ).append("\n"); 
		query.append("CHECKBOX CHECK_VAL, " ).append("\n"); 
		query.append("'' LVL," ).append("\n"); 
		query.append("USR_ROLE_CD," ).append("\n"); 
		query.append("USR_ROLE_NM," ).append("\n"); 
		query.append("USR_ROLE_DESC," ).append("\n"); 
		query.append("JOBS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.USR_ROLE_CD, " ).append("\n"); 
		query.append("A.USR_ROLE_NM," ).append("\n"); 
		query.append("A.PRNT_USR_ROLE_CD," ).append("\n"); 
		query.append("A.USR_ROLE_DESC," ).append("\n"); 
		query.append("DECODE(B.usr_role_cd,NULL,'0','1') CHECKBOX  ," ).append("\n"); 
		query.append("DECODE(B.usr_role_cd,NULL,'X',0,'X','O') JOBS" ).append("\n"); 
		query.append("FROM COM_USR_ROLE A, COM_PGM_ROLE B" ).append("\n"); 
		query.append("WHERE A.USR_ROLE_CD = B.USR_ROLE_CD(+)" ).append("\n"); 
		query.append("AND B.PGM_NO(+) = @[pgm_no]" ).append("\n"); 
		query.append("AND A.USR_ROLE_TP_CD = 'J'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH PRNT_USR_ROLE_CD IS NULL" ).append("\n"); 
		query.append("CONNECT BY PRIOR USR_ROLE_CD = PRNT_USR_ROLE_CD" ).append("\n"); 
		query.append("order siblings by usr_role_cd" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.USR_ROLE_CD," ).append("\n"); 
		query.append("A.USR_ROLE_NM" ).append("\n"); 
		query.append("FROM COM_USR_ROLE A, COM_PGM_ROLE B " ).append("\n"); 
		query.append("WHERE B.PGM_NO = @[pgm_no]" ).append("\n"); 
		query.append("AND A.USR_ROLE_CD = B.USR_ROLE_CD" ).append("\n"); 
		query.append("order by a.usr_role_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}