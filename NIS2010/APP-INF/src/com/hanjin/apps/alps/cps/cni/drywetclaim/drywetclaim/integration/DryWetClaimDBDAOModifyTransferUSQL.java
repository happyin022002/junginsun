/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DryWetClaimDBDAOModifyTransferUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.04.20 양정란
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOModifyTransferUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DWC Transfer update
	  * </pre>
	  */
	public DryWetClaimDBDAOModifyTransferUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_to_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_trns_auth_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trns_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_to_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOModifyTransferUSQL").append("\n"); 
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
		query.append("UPDATE" ).append("\n"); 
		query.append("    CNI_DW_TRNS" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("    CLM_TRNS_AUTH_CD = @[clm_trns_auth_cd]" ).append("\n"); 
		query.append("  , TRNS_TO_OFC_CD   = @[trns_to_ofc_cd]" ).append("\n"); 
		query.append("  , TRNS_TO_USR_ID   = @[trns_to_usr_id]" ).append("\n"); 
		query.append("#if (${trns_to_dt} != '')" ).append("\n"); 
		query.append("  , TRNS_TO_DT       = @[trns_to_dt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  , TRNS_TO_DT       = TO_CHAR(CNI_GET_GMT_FNC(@[upd_usr_id]), 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  , TRNS_RMK         = @[trns_rmk]" ).append("\n"); 
		query.append("  , UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append("  , UPD_DT           = CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    DW_CLM_NO = @[dw_clm_no]" ).append("\n"); 

	}
}