/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAOSearchUsrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.06.04 최덕우
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

public class JobCodeManagementDBDAOSearchUsrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JobCodeManagementDBDAOSearchUsrListRSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.jobcodemanagement.integration").append("\n"); 
		query.append("FileName : JobCodeManagementDBDAOSearchUsrListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(B.USR_ID,NULL,'0','1') AS CHECK_VAL," ).append("\n"); 
		query.append("A.USR_ID," ).append("\n"); 
		query.append("USR_NM," ).append("\n"); 
		query.append("USR_LOCL_NM," ).append("\n"); 
		query.append("(SELECT USR_NM FROM COM_USER WHERE USR_ID = B.UPD_USR_ID) AS UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(B.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("FROM COM_USER A," ).append("\n"); 
		query.append("COM_USR_ROLE_MTCH B" ).append("\n"); 
		query.append("WHERE A.USR_ID = B.USR_ID(+)" ).append("\n"); 
		query.append("#if (${usr_role_cd} != '')" ).append("\n"); 
		query.append("AND B.USR_ROLE_CD(+) = @[usr_role_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.USE_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY A.USR_ID" ).append("\n"); 

	}
}