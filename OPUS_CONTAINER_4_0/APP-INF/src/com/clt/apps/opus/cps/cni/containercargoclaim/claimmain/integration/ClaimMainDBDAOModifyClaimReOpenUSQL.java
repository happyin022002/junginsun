/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOModifyClaimReOpenUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.03.19 정행룡
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOModifyClaimReOpenUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Claim ReOpen
	  * </pre>
	  */
	public ClaimMainDBDAOModifyClaimReOpenUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOModifyClaimReOpenUSQL").append("\n"); 
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
		query.append("UPDATE CNI_CGO_CLM SET" ).append("\n"); 
		query.append("       CS_CLZ_ROPN_FLG     = 'Y'" ).append("\n"); 
		query.append("     , CS_CLZ_ROPN_DT      = TO_CHAR(CNI_GET_GMT_FNC(@[upd_usr_id]),'YYYYMMDD')" ).append("\n"); 
		query.append("     , CS_CLZ_ROPN_OFC_CD  = (SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[upd_usr_id])" ).append("\n"); 
		query.append("     , CS_CLZ_ROPN_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_USR_ID          = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT              = CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("#if (${cgo_clm_stl_tp_cd} == 'RP' || ${cgo_clm_stl_tp_cd} == 'TD' || ${cgo_clm_stl_tp_cd} == 'TB' || ${cgo_clm_stl_tp_cd} == 'WD' || ${cgo_clm_stl_tp_cd} == 'DS') " ).append("\n"); 
		query.append("	 , CLM_STL_APPL_DT     = ''" ).append("\n"); 
		query.append("	 , CLM_STL_APPL_USR_ID = ''" ).append("\n"); 
		query.append("	 , CLM_STL_APPL_OFC_CD = ''" ).append("\n"); 
		query.append("	 , CLM_STL_AUTH_DT     = ''" ).append("\n"); 
		query.append("	 , CLM_STL_AUTH_USR_ID = ''" ).append("\n"); 
		query.append("	 , CLM_STL_AUTH_OFC_CD = ''" ).append("\n"); 
		query.append("	 , CLM_STL_AUTH_CD     = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}