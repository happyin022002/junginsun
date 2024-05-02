/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOAuthAproUsrDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOAuthAproUsrDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization Approval Route 새로운 상세정보를 입력합니다.
	  * </pre>
	  */
	public ApprovalDBDAOAuthAproUsrDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auth_apro_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_usr_jb_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_rout_usr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOAuthAproUsrDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO COM_AUTH_APRO_DFLT_ROUT_USR(" ).append("\n"); 
		query.append("	AUTH_APRO_ROUT_SEQ" ).append("\n"); 
		query.append(",	AUTH_APRO_ROUT_USR_SEQ" ).append("\n"); 
		query.append(",	AUTH_APRO_USR_ID" ).append("\n"); 
		query.append(",	AUTH_APRO_USR_NM" ).append("\n"); 
		query.append(",	AUTH_APRO_OFC_CD" ).append("\n"); 
		query.append(",	AUTH_APRO_USR_JB_TIT_NM" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[auth_apro_rout_seq]" ).append("\n"); 
		query.append(",	@[auth_apro_rout_usr_seq]" ).append("\n"); 
		query.append(",	@[auth_apro_usr_id]" ).append("\n"); 
		query.append(",	@[auth_apro_usr_nm]" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("	 SELECT OFC_CD" ).append("\n"); 
		query.append("       FROM COM_USER" ).append("\n"); 
		query.append("      WHERE EP_ID = @[auth_apro_usr_id]" ).append("\n"); 
		query.append("        AND USE_FLG = 'Y'" ).append("\n"); 
		query.append("      UNION " ).append("\n"); 
		query.append("	 SELECT OFC_CD" ).append("\n"); 
		query.append("       FROM COM_USER" ).append("\n"); 
		query.append("      WHERE USR_ID = @[auth_apro_usr_id]" ).append("\n"); 
		query.append("        AND USE_FLG = 'Y'" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(",	@[auth_apro_usr_jb_tit_nm]" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	@[usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}