/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VODAOTransferRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.13 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VODAOTransferRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Transfer VO
	  * </pre>
	  */
	public VODAOTransferRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo").append("\n"); 
		query.append("FileName : VODAOTransferRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' fm_gen_expn_rqst_seq" ).append("\n"); 
		query.append(",'' fm_ofc_cd" ).append("\n"); 
		query.append(",'' fm_gen_expn_cd" ).append("\n"); 
		query.append(",'' fm_rqst_locl_amt" ).append("\n"); 
		query.append(",'' fm_rqst_usd_amt" ).append("\n"); 
		query.append(",'' fm_gen_expn_trns_div_cd" ).append("\n"); 
		query.append(",'' fm_sls_ofc_div_cd" ).append("\n"); 
		query.append(",'' fm_ofc_lvl1" ).append("\n"); 
		query.append(",'' fm_ofc_lvl2" ).append("\n"); 
		query.append(",'' fm_eng_abbr_nm" ).append("\n"); 
		query.append(",'' fm_krn_abbr_nm" ).append("\n"); 
		query.append(",'' fm_locl_curr_cd" ).append("\n"); 
		query.append(",'' fm_rqst_ut_val" ).append("\n"); 
		query.append(",'' fm_usd_locl_xch_rt" ).append("\n"); 
		query.append(",'' fm_tic_cd" ).append("\n"); 
		query.append(",'' fm_chk_assigned" ).append("\n"); 
		query.append(",'' fm_gen_expn_itm_no" ).append("\n"); 
		query.append(",'' fm_gen_expn_itm_desc" ).append("\n"); 
		query.append(",'' fm_gen_expn_calc_bss_desc" ).append("\n"); 
		query.append(",'' fm_rqst_opin_rmk" ).append("\n"); 
		query.append(",'' fm_jan_amt" ).append("\n"); 
		query.append(",'' fm_feb_amt" ).append("\n"); 
		query.append(",'' fm_mar_amt" ).append("\n"); 
		query.append(",'' fm_apr_amt" ).append("\n"); 
		query.append(",'' fm_may_amt" ).append("\n"); 
		query.append(",'' fm_jun_amt" ).append("\n"); 
		query.append(",'' fm_jul_amt" ).append("\n"); 
		query.append(",'' fm_aug_amt" ).append("\n"); 
		query.append(",'' fm_sep_amt" ).append("\n"); 
		query.append(",'' fm_oct_amt" ).append("\n"); 
		query.append(",'' fm_nov_amt" ).append("\n"); 
		query.append(",'' fm_dec_amt" ).append("\n"); 
		query.append(",'' fm_ttl" ).append("\n"); 
		query.append(",'' fm_rqst_jan_amt" ).append("\n"); 
		query.append(",'' fm_rqst_feb_amt" ).append("\n"); 
		query.append(",'' fm_rqst_mar_amt" ).append("\n"); 
		query.append(",'' fm_rqst_apr_amt" ).append("\n"); 
		query.append(",'' fm_rqst_may_amt" ).append("\n"); 
		query.append(",'' fm_rqst_jun_amt" ).append("\n"); 
		query.append(",'' fm_rqst_jul_amt" ).append("\n"); 
		query.append(",'' fm_rqst_aug_amt" ).append("\n"); 
		query.append(",'' fm_rqst_sep_amt" ).append("\n"); 
		query.append(",'' fm_rqst_oct_amt" ).append("\n"); 
		query.append(",'' fm_rqst_nov_amt" ).append("\n"); 
		query.append(",'' fm_rqst_dec_amt" ).append("\n"); 
		query.append(",'' to_ofc_cd" ).append("\n"); 
		query.append(",'' to_gen_expn_cd" ).append("\n"); 
		query.append(",'' to_rqst_locl_amt" ).append("\n"); 
		query.append(",'' to_rqst_usd_amt" ).append("\n"); 
		query.append(",'' to_gen_expn_rqst_seq" ).append("\n"); 
		query.append(",'' to_gen_expn_trns_div_cd" ).append("\n"); 
		query.append(",'' to_sls_ofc_div_cd" ).append("\n"); 
		query.append(",'' to_ofc_lvl1" ).append("\n"); 
		query.append(",'' to_ofc_lvl2" ).append("\n"); 
		query.append(",'' to_eng_abbr_nm" ).append("\n"); 
		query.append(",'' to_krn_abbr_nm" ).append("\n"); 
		query.append(",'' to_locl_curr_cd" ).append("\n"); 
		query.append(",'' to_rqst_ut_val" ).append("\n"); 
		query.append(",'' to_usd_locl_xch_rt" ).append("\n"); 
		query.append(",'' to_tic_cd" ).append("\n"); 
		query.append(",'' to_chk_assigned" ).append("\n"); 
		query.append(",'' to_gen_expn_itm_no" ).append("\n"); 
		query.append(",'' to_gen_expn_itm_desc" ).append("\n"); 
		query.append(",'' to_gen_expn_calc_bss_desc" ).append("\n"); 
		query.append(",'' to_rqst_opin_rmk" ).append("\n"); 
		query.append(",'' to_jan_amt" ).append("\n"); 
		query.append(",'' to_feb_amt" ).append("\n"); 
		query.append(",'' to_mar_amt" ).append("\n"); 
		query.append(",'' to_apr_amt" ).append("\n"); 
		query.append(",'' to_may_amt" ).append("\n"); 
		query.append(",'' to_jun_amt" ).append("\n"); 
		query.append(",'' to_jul_amt" ).append("\n"); 
		query.append(",'' to_aug_amt" ).append("\n"); 
		query.append(",'' to_sep_amt" ).append("\n"); 
		query.append(",'' to_oct_amt" ).append("\n"); 
		query.append(",'' to_nov_amt" ).append("\n"); 
		query.append(",'' to_dec_amt" ).append("\n"); 
		query.append(",'' to_ttl" ).append("\n"); 
		query.append(",'' to_rqst_jan_amt" ).append("\n"); 
		query.append(",'' to_rqst_feb_amt" ).append("\n"); 
		query.append(",'' to_rqst_mar_amt" ).append("\n"); 
		query.append(",'' to_rqst_apr_amt" ).append("\n"); 
		query.append(",'' to_rqst_may_amt" ).append("\n"); 
		query.append(",'' to_rqst_jun_amt" ).append("\n"); 
		query.append(",'' to_rqst_jul_amt" ).append("\n"); 
		query.append(",'' to_rqst_aug_amt" ).append("\n"); 
		query.append(",'' to_rqst_sep_amt" ).append("\n"); 
		query.append(",'' to_rqst_oct_amt" ).append("\n"); 
		query.append(",'' to_rqst_nov_amt" ).append("\n"); 
		query.append(",'' to_rqst_dec_amt" ).append("\n"); 
		query.append(",'' retrieve_yn" ).append("\n"); 
		query.append(",'' itm_upd_dt" ).append("\n"); 
		query.append(",'' req_upd_dt" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}