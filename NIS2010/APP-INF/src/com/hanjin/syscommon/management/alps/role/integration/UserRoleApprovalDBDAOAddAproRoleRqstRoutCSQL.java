/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserRoleApprovalDBDAOAddAproRoleRqstRoutCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.03 
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

public class UserRoleApprovalDBDAOAddAproRoleRqstRoutCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PROGRAM ROLE(JOB)의 신규/삭제 결재요청에 대한 결재라인 정보 및 하나의 Request 건에 대하여 결제 History를 저장한다.
	  * </pre>
	  */
	public UserRoleApprovalDBDAOAddAproRoleRqstRoutCSQL(){
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
		params.put("apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.role.integration").append("\n"); 
		query.append("FileName : UserRoleApprovalDBDAOAddAproRoleRqstRoutCSQL").append("\n"); 
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
		query.append("INSERT INTO COM_APRO_ROLE_RQST_ROUT (" ).append("\n"); 
		query.append("    APRO_RQST_NO," ).append("\n"); 
		query.append("    APRO_RQST_SEQ," ).append("\n"); 
		query.append("    APRO_USR_ID," ).append("\n"); 
		query.append("    APRO_USR_NM," ).append("\n"); 
		query.append("    APRO_OFC_CD," ).append("\n"); 
		query.append("    APRO_OFC_NM," ).append("\n"); 
		query.append("    APRO_DT," ).append("\n"); 
		query.append("    APSTS_CD," ).append("\n"); 
		query.append("	DELT_FLG," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[apro_rqst_no]," ).append("\n"); 
		query.append("    @[apro_rqst_seq]," ).append("\n"); 
		query.append("    @[apro_usr_id]," ).append("\n"); 
		query.append("    @[apro_usr_nm]," ).append("\n"); 
		query.append("    (SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[apro_usr_id])," ).append("\n"); 
		query.append("    (SELECT OFC_ENG_NM FROM MDM_ORGANIZATION WHERE OFC_CD = (SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[apro_usr_id]))," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    'P'," ).append("\n"); 
		query.append("	'N'," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}