/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AuthorizationAssignmentDBDAOAuthAproOfcRSQL.java
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

public class AuthorizationAssignmentDBDAOAuthAproOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_AUTH_APRO_OFC 테이블 조회
	  * </pre>
	  */
	public AuthorizationAssignmentDBDAOAuthAproOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("prc_ofc_auth_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration").append("\n"); 
		query.append("FileName : AuthorizationAssignmentDBDAOAuthAproOfcRSQL").append("\n"); 
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
		query.append("SELECT A.PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("     , A.PRC_OFC_AUTH_TP_CD" ).append("\n"); 
		query.append("     , A.AUTH_APRO_OFC_CD" ).append("\n"); 
		query.append("	 , CASE WHEN M.OFC_ENG_NM IS NULL THEN 'This Office is removed from the database.'" ).append("\n"); 
		query.append("			ELSE M.OFC_ENG_NM" ).append("\n"); 
		query.append("             END AUTH_APRO_OFC_NM" ).append("\n"); 
		query.append("     , A.AUTH_APRO_DESC" ).append("\n"); 
		query.append("     , A.AUTH_APRO_USE_FLG" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.UPD_DT" ).append("\n"); 
		query.append("  FROM PRI_AUTH_APRO_OFC A, MDM_ORGANIZATION M" ).append("\n"); 
		query.append(" WHERE A.PRC_CTRT_TP_CD = @[prc_ctrt_tp_cd]" ).append("\n"); 
		query.append("   AND A.PRC_OFC_AUTH_TP_CD = @[prc_ofc_auth_tp_cd]" ).append("\n"); 
		query.append("   AND A.AUTH_APRO_USE_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.AUTH_APRO_OFC_CD = M.OFC_CD(+)" ).append("\n"); 
		query.append(" ORDER BY A.AUTH_APRO_USE_FLG DESC, A.AUTH_APRO_OFC_CD ASC" ).append("\n"); 

	}
}