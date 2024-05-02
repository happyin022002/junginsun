/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingActualCostUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOModifyAfterBookingActualCostUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOModifyAfterBookingActualCost
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOModifyAfterBookingActualCostUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_act_cost_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aft_bkg_act_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_act_cost_itm_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_act_cost_itm_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_act_cost_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingActualCostUSQL").append("\n"); 
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
		query.append("MERGE INTO DMT_AFT_BKG_ACT_COST_RQST" ).append("\n"); 
		query.append("  USING DUAL" ).append("\n"); 
		query.append("  ON (      AFT_EXPT_DAR_NO          =   @[aft_expt_dar_no]" ).append("\n"); 
		query.append("     AND    AFT_BKG_ACT_COST_ITM_LVL =   TO_NUMBER(@[aft_bkg_act_cost_itm_lvl])" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("      SET AFT_BKG_ACT_COST_AMT      =   @[aft_bkg_act_cost_amt]" ).append("\n"); 
		query.append("        , AFT_BKG_ACT_COST_RMK      =   @[aft_bkg_act_cost_rmk]" ).append("\n"); 
		query.append("        , UPD_USR_ID    =   @[upd_usr_id]" ).append("\n"); 
		query.append("        , UPD_DT        =   nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("          , AFT_BKG_ACT_COST_ITM_LVL" ).append("\n"); 
		query.append("          , AFT_BKG_ACT_COST_ITM_NM" ).append("\n"); 
		query.append("          , AFT_BKG_ACT_COST_CURR_CD" ).append("\n"); 
		query.append("          , AFT_BKG_ACT_COST_AMT" ).append("\n"); 
		query.append("          , AFT_BKG_ACT_COST_RMK" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("    		@[aft_expt_dar_no]" ).append("\n"); 
		query.append("    	   ,TO_NUMBER(@[aft_bkg_act_cost_itm_lvl])" ).append("\n"); 
		query.append("    	   ,@[aft_bkg_act_cost_itm_nm]" ).append("\n"); 
		query.append("    	   ,@[aft_bkg_act_cost_curr_cd]" ).append("\n"); 
		query.append("    	   ,@[aft_bkg_act_cost_amt]" ).append("\n"); 
		query.append("    	   ,@[aft_bkg_act_cost_rmk]" ).append("\n"); 
		query.append("    	   ,@[upd_usr_id]" ).append("\n"); 
		query.append("    	   ,nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("    	   ,@[upd_usr_id]" ).append("\n"); 
		query.append("    	   ,nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}