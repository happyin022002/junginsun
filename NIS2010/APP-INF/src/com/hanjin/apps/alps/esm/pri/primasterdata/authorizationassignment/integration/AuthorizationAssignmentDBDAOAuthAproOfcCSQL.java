/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AuthorizationAssignmentDBDAOAuthAproOfcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AuthorizationAssignmentDBDAOAuthAproOfcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_AUTH_APRO_OFC 테이블 Merge
	  * </pre>
	  */
	public AuthorizationAssignmentDBDAOAuthAproOfcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_ofc_auth_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration").append("\n"); 
		query.append("FileName : AuthorizationAssignmentDBDAOAuthAproOfcCSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_AUTH_APRO_OFC" ).append("\n"); 
		query.append("    USING (SELECT @[auth_apro_ofc_cd] NEW_AUTH_APRO_OFC_CD" ).append("\n"); 
		query.append("     			 ,@[prc_ctrt_tp_cd] NEW_PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("    			 ,@[prc_ofc_auth_tp_cd] NEW_PRC_OFC_AUTH_TP_CD" ).append("\n"); 
		query.append("    		 FROM DUAL)" ).append("\n"); 
		query.append("    ON (AUTH_APRO_OFC_CD = NEW_AUTH_APRO_OFC_CD AND PRC_CTRT_TP_CD = NEW_PRC_CTRT_TP_CD AND PRC_OFC_AUTH_TP_CD = NEW_PRC_OFC_AUTH_TP_CD)" ).append("\n"); 
		query.append("    WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE SET AUTH_APRO_USE_FLG =  @[auth_apro_use_flg] , UPD_USR_ID = @[upd_usr_id], UPD_DT = SYSDATE" ).append("\n"); 
		query.append("    WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("      INSERT(PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("            , PRC_OFC_AUTH_TP_CD" ).append("\n"); 
		query.append("            , AUTH_APRO_OFC_CD" ).append("\n"); 
		query.append("            , AUTH_APRO_USE_FLG" ).append("\n"); 
		query.append("            , CRE_USR_ID" ).append("\n"); 
		query.append("            , CRE_DT" ).append("\n"); 
		query.append("            , UPD_USR_ID" ).append("\n"); 
		query.append("            , UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      VALUES( @[prc_ctrt_tp_cd]" ).append("\n"); 
		query.append("            , @[prc_ofc_auth_tp_cd]" ).append("\n"); 
		query.append("            , @[auth_apro_ofc_cd]" ).append("\n"); 
		query.append("            , @[auth_apro_use_flg]" ).append("\n"); 
		query.append("            , @[cre_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , @[upd_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}