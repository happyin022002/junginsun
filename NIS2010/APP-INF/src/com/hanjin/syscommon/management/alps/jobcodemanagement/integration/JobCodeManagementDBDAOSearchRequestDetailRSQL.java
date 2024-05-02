/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAOSearchRequestDetailRSQL.java
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

public class JobCodeManagementDBDAOSearchRequestDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JobCodeManagementDBDAOSearchRequestDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.jobcodemanagement.integration").append("\n"); 
		query.append("FileName : JobCodeManagementDBDAOSearchRequestDetailRSQL").append("\n"); 
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
		query.append("SELECT DTL.USR_ROLE_CD," ).append("\n"); 
		query.append("(SELECT USR_ROLE_NM FROM COM_USR_ROLE WHERE USR_ROLE_CD = DTL.USR_ROLE_CD) AS USR_ROLE_NM," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD03202'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = DTL.USR_ROLE_RQST_TP_CD) AS USR_ROLE_RQST_TP_NM," ).append("\n"); 
		query.append("DTL.USR_ROLE_RQST_TP_CD," ).append("\n"); 
		query.append("DECODE((SELECT COUNT(PGM_NO) FROM COM_PGM_ROLE WHERE USR_ROLE_CD = DTL.USR_ROLE_CD AND ROWNUM=1),0,'X','O') AS PGM_ASGN" ).append("\n"); 
		query.append("FROM COM_APRO_ROLE_DTL DTL" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND APRO_RQST_NO = @[apro_rqst_no]" ).append("\n"); 

	}
}