/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOupdateSarOtsDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOupdateSarOtsDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update SAR_OTS_DTL
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOupdateSarOtsDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrtf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrtf_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("adj_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOupdateSarOtsDtlUSQL").append("\n"); 
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
		query.append("UPDATE SAR_OTS_DTL" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("      INV_AMT = NVL(@[inv_amt], INV_UPD_DT)" ).append("\n"); 
		query.append("    , INV_UPD_DT = NVL(@[inv_upd_dt], RCT_AMT)" ).append("\n"); 
		query.append("    , RCT_AMT = NVL(@[rct_amt], RCT_UPD_DT)" ).append("\n"); 
		query.append("    , RCT_UPD_DT = NVL(@[rct_upd_dt], ADJ_AMT)" ).append("\n"); 
		query.append("    , ADJ_AMT = NVL(@[adj_amt], ADJ_UPD_DT)" ).append("\n"); 
		query.append("    , ADJ_UPD_DT = NVL(@[adj_upd_dt], BAL_AMT)" ).append("\n"); 
		query.append("    , BAL_AMT = NVL(@[bal_amt], BAL_UPD_DT)" ).append("\n"); 
		query.append("    , BAL_UPD_DT = NVL(@[bal_upd_dt], WRTF_AMT)" ).append("\n"); 
		query.append("    , WRTF_AMT = NVL(@[wrtf_amt], WRTF_UPD_DT)" ).append("\n"); 
		query.append("    , WRTF_UPD_DT = NVL(@[wrtf_upd_dt], LOCL_XCH_RT)" ).append("\n"); 
		query.append("    , LOCL_XCH_RT = NVL(@[locl_xch_rt], USD_XCH_RT)" ).append("\n"); 
		query.append("    , USD_XCH_RT =  NVL(@[usd_xch_rt], BAL_LOCL_AM)" ).append("\n"); 
		query.append("    , BAL_LOCL_AMT = NVL(@[bal_locl_amt], BAL_USD_AMT)" ).append("\n"); 
		query.append("    , BAL_USD_AMT = NVL(@[bal_usd_amt], UPD_USR_ID)" ).append("\n"); 
		query.append("    , UPD_USR_ID = NVL(@[upd_usr_id], UPD_DT)" ).append("\n"); 
		query.append("    , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("AND OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("AND BL_NO= @[ots_ofc_cd]" ).append("\n"); 
		query.append("AND INV_NO=@[inv_no]" ).append("\n"); 
		query.append("AND BL_CURR_CD = @[bl_curr_cd]" ).append("\n"); 
		query.append("AND CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 

	}
}