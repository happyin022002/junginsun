/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAOSearchApproverManagementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.31
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.07.31 최덕우
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

public class JobCodeManagementDBDAOSearchApproverManagementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JobCodeManagementDBDAOSearchApproverManagementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.jobcodemanagement.integration").append("\n"); 
		query.append("FileName : JobCodeManagementDBDAOSearchApproverManagementRSQL").append("\n"); 
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
		query.append("SELECT APRO.USR_ID AS APRO_USR_ID," ).append("\n"); 
		query.append("USR.USR_NM AS APRO_USR_NM," ).append("\n"); 
		query.append("APRO.APRO_OFC_NM AS OFC_NM," ).append("\n"); 
		query.append("CASE WHEN APRO.APRO_OFC_CD=USR.OFC_CD THEN 1 ELSE 0 END CHG_YN," ).append("\n"); 
		query.append("TO_CHAR(APRO.UPD_DT,'YYYY-MM-DD') AS UPD_DT," ).append("\n"); 
		query.append("APRO.UPD_USR_ID," ).append("\n"); 
		query.append("(SELECT USR_NM FROM COM_USER WHERE USR_ID = APRO.UPD_USR_ID) AS UPD_USR_NM," ).append("\n"); 
		query.append("APRO.APRO_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("FROM COM_OFC_ROLE_APRO_USR APRO, COM_USER USR" ).append("\n"); 
		query.append("WHERE USR.USR_ID=APRO.USR_ID" ).append("\n"); 
		query.append("#if (${apro_usr_id} != '')" ).append("\n"); 
		query.append("AND UPPER(APRO.USR_ID) = UPPER(@[apro_usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${apro_usr_nm} != '')" ).append("\n"); 
		query.append("AND UPPER(USR.USR_NM) LIKE '%'||UPPER(@[apro_usr_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND UPPER(APRO.APRO_OFC_CD) = UPPER(@[ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY APRO.UPD_DT" ).append("\n"); 

	}
}