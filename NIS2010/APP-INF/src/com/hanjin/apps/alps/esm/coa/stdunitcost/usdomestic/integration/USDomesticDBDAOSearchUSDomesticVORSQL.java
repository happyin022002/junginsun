/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : USDomesticDBDAOSearchUSDomesticVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.05.29 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOSearchUSDomesticVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUSDomesticVO
	  * </pre>
	  */
	public USDomesticDBDAOSearchUSDomesticVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOSearchUSDomesticVORSQL").append("\n"); 
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
		query.append("SELECT '' f_cost_yrmon" ).append("\n"); 
		query.append("     , '' f_cost_loc_grp_cd" ).append("\n"); 
		query.append("     , '' f_ecc_cd" ).append("\n"); 
		query.append("     , '' f_cntr_tpsz_cd" ).append("\n"); 
		query.append("     , '' f_dom_rev_det" ).append("\n"); 
		query.append("     , '' f_cre_start_dt" ).append("\n"); 
		query.append("     , '' f_cre_end_dt" ).append("\n"); 
		query.append("     , '' cost_yrmon" ).append("\n"); 
		query.append("     , '' org_rail_loc_cd" ).append("\n"); 
		query.append("     , '' rail_hub" ).append("\n"); 
		query.append("     , '' cost_loc_grp_cd" ).append("\n"); 
		query.append("     , '' cntr_tpsz_cd" ).append("\n"); 
		query.append("     , '' dmst_vol_qty" ).append("\n"); 
		query.append("     , '' railg_amt" ).append("\n"); 
		query.append("     , '' eq_rntl_scg_amt" ).append("\n"); 
		query.append("     , '' fuel_scg_amt" ).append("\n"); 
		query.append("     , '' hzd_mtrl_scg_amt" ).append("\n"); 
		query.append("     , '' dmst_ttl_frt_rev_amt" ).append("\n"); 
		query.append("     , '' dom_rev_uc_amt" ).append("\n"); 
		query.append("     , '' rail_so_vol_qty" ).append("\n"); 
		query.append("     , '' rail_agmt_amt" ).append("\n"); 
		query.append("     , '' rail_uc_amt" ).append("\n"); 
		query.append("     , '' usa_dmst_cost_amt" ).append("\n"); 
		query.append("     , '' usa_dmst_uc_amt" ).append("\n"); 
		query.append("     , '' sim_mty_cost_amt" ).append("\n"); 
		query.append("     , '' init_sim_mty_uc_amt" ).append("\n"); 
		query.append("     , '' sim_mty_uc_amt" ).append("\n"); 
		query.append("     , '' fcntr_ib_vol_qty" ).append("\n"); 
		query.append("     , '' usa_dmst_sav_cost_amt" ).append("\n"); 
		query.append("     , '' init_usa_dmst_sav_ut_amt" ).append("\n"); 
		query.append("     , '' usa_dmst_sav_ut_amt" ).append("\n"); 
		query.append("     , '' cre_usr_id" ).append("\n"); 
		query.append("     , '' cre_dt" ).append("\n"); 
		query.append("     , '' upd_usr_id" ).append("\n"); 
		query.append("     , '' upd_dt   " ).append("\n"); 
		query.append("     , '' eq_offh_qty          " ).append("\n"); 
		query.append("     , '' sub_lse_out_qty      " ).append("\n"); 
		query.append("     , '' disp_qty             " ).append("\n"); 
		query.append("     , '' cnd_dmst_qty         " ).append("\n"); 
		query.append("     , '' offh_ttl_qty         " ).append("\n"); 
		query.append("     , '' offh_sim_mty_cost_amt    " ).append("\n"); 
		query.append("     , '' eq_offh_sav_amt " ).append("\n"); 
		query.append("     , '' eq_offh_sav_uc_amt   " ).append("\n"); 
		query.append("     , '' eq_offh_sav_uc_init_amt   " ).append("\n"); 
		query.append("     , '' trp_qty              " ).append("\n"); 
		query.append("     , '' trp_amt              " ).append("\n"); 
		query.append("     , '' trp_uc_amt           " ).append("\n"); 
		query.append("     , '' trp_sim_mty_cost_amt      " ).append("\n"); 
		query.append("     , '' trp_sav_amt  " ).append("\n"); 
		query.append("     , '' trp_cr_uc_amt" ).append("\n"); 
		query.append("     , '' trp_cr_uc_init_amt " ).append("\n"); 
		query.append("     , '' row_num" ).append("\n"); 
		query.append("     , '' eq_offh_fnl_uc_amt" ).append("\n"); 
		query.append("     , '' eq_offh_fnl_uc_init_amt   " ).append("\n"); 
		query.append("     , '' dmst_rail_inv_amt" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}