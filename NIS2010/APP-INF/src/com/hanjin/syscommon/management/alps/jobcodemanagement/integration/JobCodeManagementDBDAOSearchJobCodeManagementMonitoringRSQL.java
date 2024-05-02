/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAOSearchJobCodeManagementMonitoringRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier :허은정
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
 * @author Heo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JobCodeManagementDBDAOSearchJobCodeManagementMonitoringRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JobCodeManagementDBDAOSearchJobCodeManagementMonitoringRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apsts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.jobcodemanagement.integration").append("\n"); 
		query.append("FileName : JobCodeManagementDBDAOSearchJobCodeManagementMonitoringRSQL").append("\n"); 
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
		query.append("SELECT HDR.RQST_USR_ID," ).append("\n"); 
		query.append("HDR.RQST_USR_NM," ).append("\n"); 
		query.append("HDR.RQST_OFC_CD," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION MDM , COM_INTG_CD_DTL DTL" ).append("\n"); 
		query.append("WHERE MDM.OFC_TP_CD = DTL.INTG_CD_VAL_CTNT " ).append("\n"); 
		query.append("AND DTL.INTG_CD_ID = 'CD00818'" ).append("\n"); 
		query.append("AND MDM.OFC_CD = HDR.RQST_OFC_CD) AS OFC_TP_CD," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD03205'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = ROUT.APSTS_CD) AS APSTS_NM," ).append("\n"); 
		query.append("TO_CHAR(HDR.RQST_ST_DT, 'YYYY-MM-DD') AS RQST_ST_DT," ).append("\n"); 
		query.append("TO_CHAR(ROUT.APRO_DT, 'YYYY-MM-DD') AS APRO_DT," ).append("\n"); 
		query.append("ROUT.APRO_USR_NM," ).append("\n"); 
		query.append("HDR.USR_ROLE_CD," ).append("\n"); 
		query.append("(SELECT USR_ROLE_NM" ).append("\n"); 
		query.append("FROM COM_USR_ROLE" ).append("\n"); 
		query.append("WHERE USR_ROLE_CD = HDR.USR_ROLE_CD) AS USR_ROLE_NM," ).append("\n"); 
		query.append("ROUT.APRO_RMK," ).append("\n"); 
		query.append("HDR.RQST_RMK," ).append("\n"); 
		query.append("ROUT.APRO_RQST_NO," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD03202'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = USR_ROLE_RQST_TP_CD) AS USR_ROLE_RQST_TP_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT HDR.APRO_RQST_NO, " ).append("\n"); 
		query.append("HDR.RQST_USR_ID," ).append("\n"); 
		query.append("HDR.RQST_USR_NM," ).append("\n"); 
		query.append("HDR.RQST_OFC_CD," ).append("\n"); 
		query.append("HDR.RQST_ST_DT," ).append("\n"); 
		query.append("HDR.RQST_RMK," ).append("\n"); 
		query.append("DTL.USR_ROLE_CD," ).append("\n"); 
		query.append("DTL.USR_ROLE_RQST_TP_CD" ).append("\n"); 
		query.append("FROM COM_APRO_ROLE_RQST_HDR HDR, COM_APRO_ROLE_DTL DTL " ).append("\n"); 
		query.append("WHERE HDR.APRO_RQST_NO = DTL.APRO_RQST_NO" ).append("\n"); 
		query.append("#if (${date_fm} != '' && ${date_to} != '')" ).append("\n"); 
		query.append("AND HDR.RQST_ST_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${apsts_cd} != '')" ).append("\n"); 
		query.append("AND HDR.APSTS_CD = @[apsts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_ofc_cd} != '')" ).append("\n"); 
		query.append("AND HDR.RQST_OFC_CD LIKE @[rqst_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") HDR," ).append("\n"); 
		query.append("COM_APRO_ROLE_RQST_ROUT ROUT" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND HDR.APRO_RQST_NO = ROUT.APRO_RQST_NO" ).append("\n"); 
		query.append("ORDER BY ROUT.APRO_RQST_NO DESC" ).append("\n"); 

	}
}