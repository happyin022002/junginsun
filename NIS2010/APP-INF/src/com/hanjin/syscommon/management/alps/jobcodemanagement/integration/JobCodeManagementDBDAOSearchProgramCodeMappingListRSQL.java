/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAOSearchProgramCodeMappingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.05
*@LastModifier :허은정
*@LastVersion : 1.0
* 2013.09.05 허은정
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Heo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JobCodeManagementDBDAOSearchProgramCodeMappingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JobCodeManagementDBDAOSearchProgramCodeMappingListRSQL(){
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
		query.append("FileName : JobCodeManagementDBDAOSearchProgramCodeMappingListRSQL").append("\n"); 
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
		query.append("SELECT ROL.USR_ROLE_CD," ).append("\n"); 
		query.append("ROL.USR_ROLE_NM," ).append("\n"); 
		query.append("ROL.USR_ROLE_DESC," ).append("\n"); 
		query.append("DECODE(PGM_NO,NULL,'X','O') AS PGM_ASS " ).append("\n"); 
		query.append("FROM  COM_PGM_ROLE PGM , COM_USR_ROLE ROL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PGM.USR_ROLE_CD = ROL.USR_ROLE_CD" ).append("\n"); 
		query.append("AND PGM.PGM_NO = @[pgm_no]" ).append("\n"); 
		query.append("AND ROL.USR_ROLE_TP_CD = 'J'" ).append("\n"); 

	}
}