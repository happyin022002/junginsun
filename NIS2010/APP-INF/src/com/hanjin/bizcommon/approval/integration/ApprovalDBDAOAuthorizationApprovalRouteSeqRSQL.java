/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOAuthorizationApprovalRouteSeqRSQL.java
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

public class ApprovalDBDAOAuthorizationApprovalRouteSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization Approval Route Seq조회
	  * </pre>
	  */
	public ApprovalDBDAOAuthorizationApprovalRouteSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd_auth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_sys_cd_auth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOAuthorizationApprovalRouteSeqRSQL").append("\n"); 
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
		query.append("SELECT AUTH_APRO_ROUT_SEQ" ).append("\n"); 
		query.append("FROM COM_AUTH_APRO_DFLT_ROUT" ).append("\n"); 
		query.append("WHERE SUB_SYS_CD = DECODE(@[sub_sys_cd_auth],'TLL','MNR',@[sub_sys_cd_auth])" ).append("\n"); 
		query.append("   AND OFC_CD     = @[ofc_cd_auth]" ).append("\n"); 
		query.append("   AND PGM_NO     = @[pgm_no]" ).append("\n"); 
		query.append("   #if(${auth_apro_tp_cd} == 'AF')" ).append("\n"); 
		query.append("  	 AND AUTH_APRO_TP_CD = @[auth_apro_tp_cd]" ).append("\n"); 
		query.append("   #elseif(${auth_apro_tp_cd} == 'BF')" ).append("\n"); 
		query.append("  	 AND AUTH_APRO_TP_CD = @[auth_apro_tp_cd]   " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("	AND NVL(DELT_FLG, 'Y') = 'N' " ).append("\n"); 

	}
}