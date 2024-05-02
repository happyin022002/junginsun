/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationDBDAOcreateAuthorizationAproRqstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.authorization.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationDBDAOcreateAuthorizationAproRqstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_AUTH_APRO_RQST 추가
	  * </pre>
	  */
	public AuthorizationDBDAOcreateAuthorizationAproRqstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_jb_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_pgm_btn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_rqst_rsn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.authorization.integration").append("\n"); 
		query.append("FileName : AuthorizationDBDAOcreateAuthorizationAproRqstCSQL").append("\n"); 
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
		query.append("INSERT INTO COM_AUTH_APRO_RQST ( " ).append("\n"); 
		query.append("  AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append(", AUTH_PGM_BTN_SEQ" ).append("\n"); 
		query.append(", AUTH_APSTS_CD" ).append("\n"); 
		query.append(", CRNT_AUTH_APRO_RQST_SEQ" ).append("\n"); 
		query.append(", RQST_USR_ID" ).append("\n"); 
		query.append(", RQST_USR_NM" ).append("\n"); 
		query.append(", RQST_OFC_CD" ).append("\n"); 
		query.append(", RQST_OFC_NM" ).append("\n"); 
		query.append(", RQST_USR_JB_TIT_NM" ).append("\n"); 
		query.append(", RQST_ST_DT" ).append("\n"); 
		query.append(", RQST_END_DT" ).append("\n"); 
		query.append(", CFM_FLG" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", AUTH_APRO_RQST_RMK" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("  @[auth_apro_rqst_no]" ).append("\n"); 
		query.append(", @[auth_pgm_btn_seq]" ).append("\n"); 
		query.append(", 'P'" ).append("\n"); 
		query.append(", '1'" ).append("\n"); 
		query.append(", @[rqst_usr_id]" ).append("\n"); 
		query.append(", @[rqst_usr_nm]" ).append("\n"); 
		query.append(", @[rqst_ofc_cd]" ).append("\n"); 
		query.append(", @[rqst_ofc_nm]" ).append("\n"); 
		query.append(", @[rqst_usr_jb_tit_nm]" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[rqst_ofc_cd])" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", @[rqst_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[rqst_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[auth_rqst_rsn]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}