/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAOAddApproverUsrIdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.07.09 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi, DukWoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JobCodeManagementDBDAOAddApproverUsrIdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JobCodeManagementDBDAOAddApproverUsrIdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.jobcodemanagement.integration ").append("\n"); 
		query.append("FileName : JobCodeManagementDBDAOAddApproverUsrIdCSQL").append("\n"); 
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
		query.append("INSERT INTO COM_OFC_ROLE_APRO_USR (" ).append("\n"); 
		query.append("USR_ID," ).append("\n"); 
		query.append("APRO_OFC_CD," ).append("\n"); 
		query.append("APRO_OFC_NM," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("(SELECT USR_ID FROM COM_USER WHERE EP_ID = @[apro_usr_id])," ).append("\n"); 
		query.append("(SELECT OFC_CD FROM COM_USER WHERE EP_ID = @[apro_usr_id])," ).append("\n"); 
		query.append("(SELECT OFC_ENG_NM FROM MDM_ORGANIZATION WHERE OFC_CD = (SELECT OFC_CD FROM COM_USER WHERE EP_ID = @[apro_usr_id]))," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}