/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOModifyGwStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOModifyGwStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GwStatus정보 갱신
	  * </pre>
	  */
	public ClaimMainDBDAOModifyGwStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_auth_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_auth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_auth_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_appl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_auth_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_appl_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOModifyGwStatusUSQL").append("\n"); 
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
		query.append("UPDATE CNI_CGO_CLM SET " ).append("\n"); 
		query.append("    CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 
		query.append("#if (${clm_stl_appl_dt} != '') " ).append("\n"); 
		query.append(",	CLM_STL_APPL_DT = @[clm_stl_appl_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${clm_stl_appl_usr_id} != '') " ).append("\n"); 
		query.append(",	CLM_STL_APPL_USR_ID = @[clm_stl_appl_usr_id]" ).append("\n"); 
		query.append(",	CLM_STL_APPL_OFC_CD = (SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[clm_stl_appl_usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${clm_stl_auth_dt} != '') " ).append("\n"); 
		query.append(",	CLM_STL_AUTH_DT = @[clm_stl_auth_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${clm_stl_auth_usr_id} != '') " ).append("\n"); 
		query.append(",	CLM_STL_AUTH_USR_ID = @[clm_stl_auth_usr_id]" ).append("\n"); 
		query.append(",	CLM_STL_AUTH_OFC_CD = (SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[clm_stl_auth_usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${clm_stl_auth_rmk} != '') " ).append("\n"); 
		query.append(",	CLM_STL_AUTH_RMK = @[clm_stl_auth_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${clm_stl_auth_no} != '') " ).append("\n"); 
		query.append(",	CLM_STL_AUTH_NO = @[clm_stl_auth_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",   CLM_STL_AUTH_CD = @[clm_stl_auth_cd]" ).append("\n"); 
		query.append(",	UPD_USR_ID = NVL(@[clm_stl_auth_usr_id],@[clm_stl_appl_usr_id])" ).append("\n"); 
		query.append(",	UPD_DT = CNI_GET_GMT_FNC(NVL(@[clm_stl_auth_usr_id],@[clm_stl_appl_usr_id]))" ).append("\n"); 
		query.append("WHERE	CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}