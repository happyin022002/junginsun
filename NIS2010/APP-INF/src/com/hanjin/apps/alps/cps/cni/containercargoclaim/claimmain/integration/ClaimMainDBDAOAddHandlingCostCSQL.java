/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOAddHandlingCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.03.31 양정란
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOAddHandlingCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HandlingCost 입력
	  * </pre>
	  */
	public ClaimMainDBDAOAddHandlingCostCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_cost_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOAddHandlingCostCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO" ).append("\n"); 
		query.append("    CNI_CGO_CLM_COST" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        CGO_CLM_PAY_NO" ).append("\n"); 
		query.append("      , CGO_CLM_NO" ).append("\n"); 
		query.append("      , CLM_COST_TP_CD" ).append("\n"); 
		query.append("      , CLM_PTY_NO" ).append("\n"); 
		query.append("      , COST_DESC" ).append("\n"); 
		query.append("      , INV_NO" ).append("\n"); 
		query.append("      , INV_DT" ).append("\n"); 
		query.append("      , INV_AMT" ).append("\n"); 
		query.append("      , LOCL_CURR_CD" ).append("\n"); 
		query.append("      , INV_XCH_RT" ).append("\n"); 
		query.append("      , INV_USD_AMT" ).append("\n"); 
		query.append("      , PAY_DT" ).append("\n"); 
		query.append("      , INV_RMK" ).append("\n"); 
		query.append("      , INV_RGST_NO" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("      CNI_CLM_PTY_NO_SEQ.NEXTVAL" ).append("\n"); 
		query.append("      , @[cgo_clm_no]" ).append("\n"); 
		query.append("      , @[clm_cost_tp_cd]" ).append("\n"); 
		query.append("      , @[clm_pty_no]" ).append("\n"); 
		query.append("      , @[cost_desc]" ).append("\n"); 
		query.append("      , @[inv_no]" ).append("\n"); 
		query.append("      , @[inv_dt]" ).append("\n"); 
		query.append("      , @[inv_amt]" ).append("\n"); 
		query.append("      , @[locl_curr_cd]" ).append("\n"); 
		query.append("      , @[inv_xch_rt]" ).append("\n"); 
		query.append("      , @[inv_usd_amt]" ).append("\n"); 
		query.append("      , TO_DATE(@[pay_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("      , @[inv_rmk]" ).append("\n"); 
		query.append("      , @[inv_rgst_no]" ).append("\n"); 
		query.append("      , @[cre_usr_id]" ).append("\n"); 
		query.append("      , cni_get_gmt_fnc (@[upd_usr_id])" ).append("\n"); 
		query.append("      , @[upd_usr_id]" ).append("\n"); 
		query.append("      , cni_get_gmt_fnc (@[upd_usr_id])" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}