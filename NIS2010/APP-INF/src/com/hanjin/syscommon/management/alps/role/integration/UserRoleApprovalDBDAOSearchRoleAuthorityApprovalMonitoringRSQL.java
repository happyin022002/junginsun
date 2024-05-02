/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : UserRoleApprovalDBDAOSearchRoleAuthorityApprovalMonitoringRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserRoleApprovalDBDAOSearchRoleAuthorityApprovalMonitoringRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public UserRoleApprovalDBDAOSearchRoleAuthorityApprovalMonitoringRSQL(){
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
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apsts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.role.integration").append("\n"); 
		query.append("FileName : UserRoleApprovalDBDAOSearchRoleAuthorityApprovalMonitoringRSQL").append("\n"); 
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
		query.append("SELECT  HDR.RQST_USR_ID," ).append("\n"); 
		query.append("        HDR.RQST_USR_NM," ).append("\n"); 
		query.append("        HDR.RQST_OFC_CD," ).append("\n"); 
		query.append("        TO_CHAR(HDR.RQST_ST_DT, 'YYYY-MM-DD') AS RQST_ST_DT," ).append("\n"); 
		query.append("        DECODE(ROUT.APSTS_CD, 'P', '', TO_CHAR(ROUT.APRO_DT, 'YYYY-MM-DD')) AS APRO_DT," ).append("\n"); 
		query.append("        HDR.ROLE_MODULE," ).append("\n"); 
		query.append("		(SELECT wm_concat(usr_nm) FROM com_user a WHERE usr_id in (SELECT usr_id FROM com_usr_pgm_mtch WHERE pgm_no = HDR.ROLE_MODULE) and a.usr_auth_tp_cd = 'S' and a.use_flg = 'Y') ROLE_AUTH," ).append("\n"); 
		query.append("		-- Oracle 11g Upgrade 시 wm_concat(usr_nm) 을 ListAgg(usr_nm, ',') WITHIN GROUP(ORDER BY rownum) 로 변경" ).append("\n"); 
		query.append("        DECODE(ROUT.APSTS_CD, 'C',HDR.USR_ROLE_CD,'') USR_ROLE_CD," ).append("\n"); 
		query.append("        ROUT.APSTS_CD," ).append("\n"); 
		query.append("		DECODE(ROUT.APSTS_CD, 'P','',ROUT.APRO_USR_NM||'\n'||(SELECT USR_EML FROM COM_USER CU WHERE CU.USR_ID = ROUT.APRO_USR_ID)) APRO_USR_ID, " ).append("\n"); 
		query.append("        ROUT.APRO_RMK," ).append("\n"); 
		query.append("        HDR.RQST_RMK," ).append("\n"); 
		query.append("        ROUT.APRO_RQST_NO," ).append("\n"); 
		query.append("		(DECODE(ROUT.APSTS_CD, 'P',HDR.USR_ROLE_CD,NVL((select DTL2.USR_ROLE_CD from COM_APRO_ROLE_DTL DTL2 where  ROUT.APRO_RQST_NO = DTL2.APRO_RQST_NO and  DTL2.APSTS_CD <> 'P'),HDR.USR_ROLE_CD))) AS ORG_USR_ROLE_CD     " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT  HDR.APRO_RQST_NO, " ).append("\n"); 
		query.append("            HDR.RQST_USR_ID," ).append("\n"); 
		query.append("            HDR.RQST_USR_NM," ).append("\n"); 
		query.append("            HDR.RQST_OFC_CD," ).append("\n"); 
		query.append("            HDR.RQST_ST_DT," ).append("\n"); 
		query.append("            HDR.RQST_RMK," ).append("\n"); 
		query.append("            DTL.USR_ROLE_CD," ).append("\n"); 
		query.append("            SUBSTR(DTL.USR_ROLE_CD,1,3) AS ROLE_MODULE" ).append("\n"); 
		query.append("    FROM    COM_APRO_ROLE_RQST_HDR HDR, COM_APRO_ROLE_DTL DTL " ).append("\n"); 
		query.append("    WHERE   HDR.APRO_RQST_NO = DTL.APRO_RQST_NO" ).append("\n"); 
		query.append("		#if (${date_fm} != '' && ${date_to} != '')" ).append("\n"); 
		query.append("            AND HDR.RQST_ST_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${rqst_ofc_cd} != '')" ).append("\n"); 
		query.append("		   AND HDR.RQST_OFC_CD LIKE @[rqst_ofc_cd]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${rqst_usr_id} != '')" ).append("\n"); 
		query.append("		   AND HDR.RQST_USR_ID LIKE @[rqst_usr_id]||'%'" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${usr_role_cd} != '')" ).append("\n"); 
		query.append("		   AND DTL.USR_ROLE_CD LIKE @[usr_role_cd]||'%'" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		   ) HDR," ).append("\n"); 
		query.append("    COM_APRO_ROLE_RQST_ROUT ROUT" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("    AND HDR.APRO_RQST_NO = ROUT.APRO_RQST_NO" ).append("\n"); 
		query.append("		#if (${apsts_cd} != '')" ).append("\n"); 
		query.append("		   AND ROUT.APSTS_CD = @[apsts_cd]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${role_module} != '')" ).append("\n"); 
		query.append("		   AND ROLE_MODULE in ('${role_module}')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("ORDER BY ROUT.APRO_RQST_NO DESC" ).append("\n"); 

	}
}