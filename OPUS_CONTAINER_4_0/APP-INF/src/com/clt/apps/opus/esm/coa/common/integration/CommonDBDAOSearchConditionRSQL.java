/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonDBDAOSearchConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.29
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.10.29 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면의 Object들의 VO를 생성한다.
	  * </pre>
	  */
	public CommonDBDAOSearchConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchConditionRSQL").append("\n"); 
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
		query.append("SELECT '' AS f_trd_cd" ).append("\n"); 
		query.append("      ,'' AS f_rlane_cd" ).append("\n"); 
		query.append("      ,'' AS f_slan_cd" ).append("\n"); 
		query.append("      ,'' AS f_vsl_cd" ).append("\n"); 
		query.append("      ,'' AS f_skd_voy_no" ).append("\n"); 
		query.append("      ,'' AS f_dir_cd" ).append("\n"); 
		query.append("      ,'' AS f_bkg_no" ).append("\n"); 
		query.append("      ,'' AS f_pro_vw     -- Profit view" ).append("\n"); 
		query.append("      ,'' AS f_ofc_vw     -- Office View" ).append("\n"); 
		query.append("      ,'' AS f_pro_lvl    -- Profit Level" ).append("\n"); 
		query.append("      ,'' AS f_ofc_lvl    -- Office Level" ).append("\n"); 
		query.append("      ,'' AS f_ofc_cd     -- Office Code" ).append("\n"); 
		query.append("      ,'' AS f_bkg_por_cd" ).append("\n"); 
		query.append("      ,'' AS f_rev_pol_cd" ).append("\n"); 
		query.append("      ,'' AS f_rev_pod_cd" ).append("\n"); 
		query.append("      ,'' AS f_bkg_del_cd" ).append("\n"); 
		query.append("      ,'' AS f_shpr_cd" ).append("\n"); 
		query.append("      ,'' AS f_sc_no" ).append("\n"); 
		query.append("      ,'' AS f_rfa_no" ).append("\n"); 
		query.append("      ,'' AS f_key_acct_group_cd" ).append("\n"); 
		query.append("      ,'' AS f_key_acct_indvl_cd" ).append("\n"); 
		query.append("      ,'' AS f_cmdt_cd" ).append("\n"); 
		query.append("      ,'' AS f_usa_bkg_mod_cd" ).append("\n"); 
		query.append("      ,'' AS f_cntr_tpsz_cd" ).append("\n"); 
		query.append("      ,'' AS f_por" ).append("\n"); 
		query.append("      ,'' AS f_del" ).append("\n"); 
		query.append("      ,'' AS f_cost_yrmon" ).append("\n"); 
		query.append("      ,'' AS f_cost_yr" ).append("\n"); 
		query.append("      ,'' AS f_cost_fm_mon" ).append("\n"); 
		query.append("      ,'' AS f_cntr_tpsz_cd" ).append("\n"); 
		query.append("      ,'' AS f_cbo_rcc" ).append("\n"); 
		query.append("      ,'' AS f_cbo_lcc" ).append("\n"); 
		query.append("      ,'' AS f_cbo_ecc" ).append("\n"); 
		query.append("      ,'' AS f_loc" ).append("\n"); 
		query.append("      ,'' AS f_ecc" ).append("\n"); 
		query.append("      ,'' AS f_x_lev" ).append("\n"); 
		query.append("      ,'' AS f_wtr_term_cd" ).append("\n"); 
		query.append("      ,'' AS f_calc_term_cd" ).append("\n"); 
		query.append("      ,'' AS f_loc_cd" ).append("\n"); 
		query.append("      ,'' AS f_full_mty_cd" ).append("\n"); 
		query.append("      ,'' AS f_locl_curr_cd" ).append("\n"); 
		query.append("      ,'' AS f_cntr_tpsz_cd" ).append("\n"); 
		query.append("      ,'' AS f_spcl_cgo_dg_flg" ).append("\n"); 
		query.append("      ,'' AS f_spcl_cgo_bb_flg" ).append("\n"); 
		query.append("      ,'' AS f_spcl_cgo_awk_flg" ).append("\n"); 
		query.append("      ,'' AS f_spcl_cgo_rf_flg" ).append("\n"); 
		query.append("      ,'' AS f_act_grp_cd" ).append("\n"); 
		query.append("      ,'' AS f_cost_loc_grp_cd" ).append("\n"); 
		query.append("      ,'' AS f_from" ).append("\n"); 
		query.append("      ,'' AS f_to" ).append("\n"); 
		query.append("      ,'' AS f_pod" ).append("\n"); 
		query.append("      ,'' AS f_ecc_cd" ).append("\n"); 
		query.append("      ,'' AS f_lcc_cd" ).append("\n"); 
		query.append("      ,'' AS f_rcc_cd" ).append("\n"); 
		query.append("      ,'' AS f_sim_dt" ).append("\n"); 
		query.append("      ,'' AS f_sim_no" ).append("\n"); 
		query.append("      ,'' AS f_mty_ecc_cd" ).append("\n"); 
		query.append("      ,'' AS f_mty_lcc_cd" ).append("\n"); 
		query.append("      ,'' AS f_mty_rcc_cd" ).append("\n"); 
		query.append("      ,'' AS f_svc_trns_prc_cnt_cd" ).append("\n"); 
		query.append("      ,'' AS f_ofc_act_cd" ).append("\n"); 
		query.append("      ,'' AS f_chkprd" ).append("\n"); 
		query.append("      ,'' AS f_year" ).append("\n"); 
		query.append("      ,'' AS f_fm_mon" ).append("\n"); 
		query.append("      ,'' AS f_to_mon" ).append("\n"); 
		query.append("      ,'' AS f_fm_wk" ).append("\n"); 
		query.append("      ,'' AS f_to_wk" ).append("\n"); 
		query.append("      ,'' AS f_ioc_cd" ).append("\n"); 
		query.append("      ,'' AS f_pctl_no" ).append("\n"); 
		query.append("      ,'' AS f_ecc_cd2" ).append("\n"); 
		query.append("      ,'' AS f_rd_ind" ).append("\n"); 
		query.append("      ,'' AS f_rout_no" ).append("\n"); 
		query.append("      ,'' AS f_ori_dest" ).append("\n"); 
		query.append("      ,'' AS f_from_ecc" ).append("\n"); 
		query.append("      ,'' AS f_to_ecc" ).append("\n"); 
		query.append("      ,'' AS f_from_ecc_cd" ).append("\n"); 
		query.append("      ,'' AS f_pod_ecc_cd" ).append("\n"); 
		query.append("      ,'' AS f_to_ecc_cd" ).append("\n"); 
		query.append("      ,'' AS f_rev_yrmon" ).append("\n"); 
		query.append("      ,'' AS f_cust_cnt_cd" ).append("\n"); 
		query.append("      ,'' AS f_cust_seq" ).append("\n"); 
		query.append("      ,'' AS f_sls_mon" ).append("\n"); 
		query.append("      ,'' AS f_rhq_cd" ).append("\n"); 
		query.append("      ,'' AS f_sls_ofc_cd" ).append("\n"); 
		query.append("      ,'' AS f_excl_sub" ).append("\n"); 
		query.append("      ,'' AS f_skd_dir_cd" ).append("\n"); 
		query.append("      ,'' AS f_shpr" ).append("\n"); 
		query.append("      ,'' AS f_view_tpsz" ).append("\n"); 
		query.append("      ,'' AS f_bkg_disp" ).append("\n"); 
		query.append("      ,'' AS f_bkg_sts" ).append("\n"); 
		query.append("      ,'' AS f_dir_sts" ).append("\n"); 
		query.append("      ,'' AS f_soc_sts" ).append("\n"); 
		query.append("      ,'' AS f_wk_sts" ).append("\n"); 
		query.append("      ,'' AS f_wk_cd" ).append("\n"); 
		query.append("      ,'' AS istrade" ).append("\n"); 
		query.append("      ,'' AS f_sub_trd_cd" ).append("\n"); 
		query.append("      ,'' AS f_comm_loc_cd" ).append("\n"); 
		query.append("      ,'' AS f_tml_cd" ).append("\n"); 
		query.append("      ,'' AS f_1st" ).append("\n"); 
		query.append("      ,'' AS f_2nd" ).append("\n"); 
		query.append("      ,'' AS f_3td" ).append("\n"); 
		query.append("      ,'' AS f_4th" ).append("\n"); 
		query.append("      ,'' AS f_inout" ).append("\n"); 
		query.append("      ,'' AS f_chkDel" ).append("\n"); 
		query.append("      ,'' AS f_selTrade" ).append("\n"); 
		query.append("      ,'' AS f_selRlane" ).append("\n"); 
		query.append("      ,'' AS f_selDir" ).append("\n"); 
		query.append("      ,'' AS f_selIOC" ).append("\n"); 
		query.append("      ,'' AS f_selSlane" ).append("\n"); 
		query.append("      ,'' AS f_type_cd" ).append("\n"); 
		query.append("      ,'' AS f_chkPrevCre" ).append("\n"); 
		query.append("      ,'' AS f_yrType" ).append("\n"); 
		query.append("      ,'' AS f_yearweek" ).append("\n"); 
		query.append("      ,'' AS f_selClass" ).append("\n"); 
		query.append("      ,'' AS f_sdate" ).append("\n"); 
		query.append("      ,'' AS f_header" ).append("\n"); 
		query.append("      ,'' AS f_selVessel" ).append("\n"); 
		query.append("      ,'' AS f_cobTrade" ).append("\n"); 
		query.append("      ,'' AS f_cobLane" ).append("\n"); 
		query.append("      ,'' AS f_vessel" ).append("\n"); 
		query.append("      ,'' AS f_voyage" ).append("\n"); 
		query.append("      ,'' AS f_dir" ).append("\n"); 
		query.append("      ,'' AS f_strPrcNm" ).append("\n"); 
		query.append("      ,'' AS f_chk_bsaZrFlg" ).append("\n"); 
		query.append("      ,'' AS f_strChkPrd" ).append("\n"); 
		query.append("      ,'' AS f_strYear" ).append("\n"); 
		query.append("      ,'' AS f_strFmWeek" ).append("\n"); 
		query.append("      ,'' AS f_strToWeek" ).append("\n"); 
		query.append("      ,'' AS f_strFmMonth" ).append("\n"); 
		query.append("      ,'' AS f_strToMonth" ).append("\n"); 
		query.append("      ,'' AS f_strTrade" ).append("\n"); 
		query.append("      ,'' AS f_strLane" ).append("\n"); 
		query.append("      ,'' AS f_strVessel" ).append("\n"); 
		query.append("      ,'' AS f_strVoyage" ).append("\n"); 
		query.append("      ,'' AS f_strDir" ).append("\n"); 
		query.append("      ,'' AS f_strType" ).append("\n"); 
		query.append("      ,'' AS f_cobCost" ).append("\n"); 
		query.append("      ,'' AS f_selCapa" ).append("\n"); 
		query.append("      ,'' AS f_sMon" ).append("\n"); 
		query.append("      ,'' AS f_eMon" ).append("\n"); 
		query.append("      ,'' AS f_sWeek" ).append("\n"); 
		query.append("      ,'' AS f_eWeek" ).append("\n"); 
		query.append("      ,'' AS f_cobIoc" ).append("\n"); 
		query.append("      ,'' AS f_selCost" ).append("\n"); 
		query.append("      ,'' AS f_yearMonth" ).append("\n"); 
		query.append("      ,'' AS f_cobDir" ).append("\n"); 
		query.append("      ,'' AS f_cboTrade  " ).append("\n"); 
		query.append("	  ,'' AS f_cboSlane" ).append("\n"); 
		query.append("      ,'' AS f_vsl_cd2   " ).append("\n"); 
		query.append("      ,'' AS f_crr_cd    " ).append("\n"); 
		query.append("      ,'' AS f_h_trd_cd  " ).append("\n"); 
		query.append("      ,'' AS f_h_rlane_cd" ).append("\n"); 
		query.append("      ,'' AS f_h_dir_cd  " ).append("\n"); 
		query.append("      ,'' AS f_h_ioc_cd  " ).append("\n"); 
		query.append("      ,'' AS f_selGroup    " ).append("\n"); 
		query.append("      ,'' AS f_headerNM    " ).append("\n"); 
		query.append("      ,'' AS f_sls_mon" ).append("\n"); 
		query.append("      ,'' AS f_shipper     " ).append("\n"); 
		query.append("      ,'' AS f_rfa         " ).append("\n"); 
		query.append("      ,'' AS f_bkg_no_split" ).append("\n"); 
		query.append("      ,'' AS f_excl_sts    " ).append("\n"); 
		query.append("      ,'' AS f_group       " ).append("\n"); 
		query.append("      ,'' AS f_savename    " ).append("\n"); 
		query.append("      ,'' AS f_divideName  " ).append("\n"); 
		query.append("      ,'' AS f_bkg_pol_cd" ).append("\n"); 
		query.append("      ,'' AS f_bkg_pod_cd" ).append("\n"); 
		query.append("	  ,'' AS f_op_view" ).append("\n"); 
		query.append("	  ,'' AS f_avg_suvgrp" ).append("\n"); 
		query.append("	  ,'' AS f_avg_grp_cd" ).append("\n"); 
		query.append("	  ,'' AS f_coa_cd" ).append("\n"); 
		query.append("	  ,'' AS f_src_mon" ).append("\n"); 
		query.append("	  ,'' AS f_tar_mon" ).append("\n"); 
		query.append("	  ,'' AS f_op_lane_tp_cd" ).append("\n"); 
		query.append("      ,'' AS f_taa_no" ).append("\n"); 
		query.append("      ,'' AS f_sim" ).append("\n"); 
		query.append("	  ,'' AS f_mdm_charge_cd" ).append("\n"); 
		query.append("	  ,'' AS f_mdm_charge_type_cd" ).append("\n"); 
		query.append("	  ,'' AS f_mlt_trd_indvl_cd" ).append("\n"); 
		query.append("	  ,'' AS f_ias_sub_grp_cd" ).append("\n"); 
		query.append("	  ,'' AS f_mlt_trd_group_cd" ).append("\n"); 
		query.append("	  ,'' AS f_mon" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}