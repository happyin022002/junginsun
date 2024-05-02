/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SettlementClaimDBDAOModifySettlementUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.03.03 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementClaimDBDAOModifySettlementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement 수정
	  * </pre>
	  */
	public SettlementClaimDBDAOModifySettlementUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_stl_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_stl_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_stl_rmk",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_stl_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_stl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_stl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_stl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_stl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.integration").append("\n"); 
		query.append("FileName : SettlementClaimDBDAOModifySettlementUSQL").append("\n"); 
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
		query.append("    CNI_CGO_CLM_STL" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	CGO_CLM_STL_TP_CD		= @[cgo_clm_stl_tp_cd]" ).append("\n"); 
		query.append(",	CGO_CLM_STL_DT			= @[cgo_clm_stl_dt]" ).append("\n"); 
		query.append(",	CGO_CLM_STL_USD_AMT		= @[cgo_clm_stl_usd_amt]" ).append("\n"); 
		query.append(",	CGO_CLM_STL_LOCL_CURR_CD	= @[cgo_clm_stl_locl_curr_cd]" ).append("\n"); 
		query.append(",	CGO_CLM_STL_LOCL_AMT		= @[cgo_clm_stl_locl_amt]" ).append("\n"); 
		query.append(",	CGO_CLM_STL_XCH_RT		= @[cgo_clm_stl_xch_rt]" ).append("\n"); 
		query.append(",	CGO_CLM_STL_RMK			= @[cgo_clm_stl_rmk]" ).append("\n"); 
		query.append(",	CGO_CLM_STL_DESC		= @[cgo_clm_stl_desc]" ).append("\n"); 
		query.append(",	UPD_USR_ID			= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT				= CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 

	}
}