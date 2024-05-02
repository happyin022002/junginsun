/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAOSearchJobCodeInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 허은정
*@LastVersion : 1.0
* 2013.09.04 허은정
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author heo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JobCodeManagementDBDAOSearchJobCodeInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JobCodeManagementDBDAOSearchJobCodeInquiryRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.jobcodemanagement.integration").append("\n"); 
		query.append("FileName : JobCodeManagementDBDAOSearchJobCodeInquiryRSQL").append("\n"); 
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
		query.append("SELECT USR.USR_ID," ).append("\n"); 
		query.append("USR.USR_NM," ).append("\n"); 
		query.append("USR.OFC_CD," ).append("\n"); 
		query.append("ROL.USR_ROLE_CD," ).append("\n"); 
		query.append("ROL.USR_ROLE_NM," ).append("\n"); 
		query.append("DECODE((SELECT COUNT(USR_ROLE_CD) FROM COM_PGM_ROLE WHERE USR_ROLE_CD = ROL.USR_ROLE_CD AND ROWNUM = 1), 0, 'X', 'O') AS PGM_ASGN," ).append("\n"); 
		query.append("ROL.USR_ROLE_DESC" ).append("\n"); 
		query.append("FROM COM_USER USR," ).append("\n"); 
		query.append("COM_USR_ROLE_MTCH MTCH," ).append("\n"); 
		query.append("COM_USR_ROLE ROL" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append("AND USR.USR_ID LIKE @[usr_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND USR.USR_ID = MTCH.USR_ID" ).append("\n"); 
		query.append("#if (${usr_nm} != '')" ).append("\n"); 
		query.append("AND USR.USR_NM LIKE @[usr_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND USR.OFC_CD LIKE @[ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MTCH.USR_ROLE_CD = ROL.USR_ROLE_CD" ).append("\n"); 
		query.append("AND ROL.USR_ROLE_TP_CD = 'J'" ).append("\n"); 

	}
}