/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStatusListInVO1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.28
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2012.12.28 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLStatusListInVO1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLStatusListInVO1RSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStatusListInVO1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStatusListInVO1RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("/* StatusReportInVO */" ).append("\n"); 
		query.append("      '' p_bkg_rpt_knd_cd" ).append("\n"); 
		query.append("    , '' p_grid_type" ).append("\n"); 
		query.append("    , '' p_report_type" ).append("\n"); 
		query.append("    , '' curr_page" ).append("\n"); 
		query.append("    , '' rows_per_page" ).append("\n"); 
		query.append("	, '' last_orderby" ).append("\n"); 
		query.append("	, '' orderby" ).append("\n"); 
		query.append("	, '' orderby_select" ).append("\n"); 
		query.append("    , '' ORDERBY_TITLE_SQL" ).append("\n"); 
		query.append("    , '' ORDERBY_TITLE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , '' p_bkg_rpt_knd_cd" ).append("\n"); 
		query.append("    , '' vvd_cd" ).append("\n"); 
		query.append("    , '' trunk_flag" ).append("\n"); 
		query.append("    , '' lane_cd" ).append("\n"); 
		query.append("    , '' dir_cd" ).append("\n"); 
		query.append("    , '' pol_cd" ).append("\n"); 
		query.append("    , '' pol_yard_cd" ).append("\n"); 
		query.append("    , '' pol_local" ).append("\n"); 
		query.append("    , '' pol_ts" ).append("\n"); 
		query.append("    , '' pod_cd" ).append("\n"); 
		query.append("    , '' pod_yard_cd" ).append("\n"); 
		query.append("    , '' pod_local" ).append("\n"); 
		query.append("    , '' pod_ts" ).append("\n"); 
		query.append("    , '' por_cd" ).append("\n"); 
		query.append("    , '' del_cd" ).append("\n"); 
		query.append("    , '' r_term" ).append("\n"); 
		query.append("    , '' d_term" ).append("\n"); 
		query.append("    , '' zone_cd" ).append("\n"); 
		query.append("    , '' deli_mode" ).append("\n"); 
		query.append("    , '' board_from_dt" ).append("\n"); 
		query.append("    , '' board_to_dt" ).append("\n"); 
		query.append("    , '' bkg_from_dt" ).append("\n"); 
		query.append("    , '' bkg_to_dt" ).append("\n"); 
		query.append("    , '' eta_from_dt" ).append("\n"); 
		query.append("    , '' eta_to_dt" ).append("\n"); 
		query.append("    , '' bkg_kind" ).append("\n"); 
		query.append("    , '' b_ofc_cd" ).append("\n"); 
		query.append("    , '' b_ofc_cd_sub" ).append("\n"); 
		query.append("    , '' b_staff_id" ).append("\n"); 
		query.append("    , '' ca_flag" ).append("\n"); 
		query.append("    , '' agent_cd" ).append("\n"); 
		query.append("    , '' agent_cd_all" ).append("\n"); 
		query.append("    , '' eq_type" ).append("\n"); 
		query.append("    , '' cmdt_cd" ).append("\n"); 
		query.append("    , '' cmdt_nm" ).append("\n"); 
		query.append("    , '' wgt_from" ).append("\n"); 
		query.append("    , '' wgt_to" ).append("\n"); 
		query.append("    , '' so_no" ).append("\n"); 
		query.append("    , '' l_ofc_cd" ).append("\n"); 
		query.append("    , '' l_ofc_cd_sub" ).append("\n"); 
		query.append("    , '' dept_cd" ).append("\n"); 
		query.append("    , '' l_rep_id" ).append("\n"); 
		query.append("    , '' c_ofc_cd" ).append("\n"); 
		query.append("    , '' c_ofc_cd_sub" ).append("\n"); 
		query.append("    , '' c_rep_id" ).append("\n"); 
		query.append("    , '' ctr_rfa_cd" ).append("\n"); 
		query.append("    , '' ctr_rfa_no" ).append("\n"); 
		query.append("    , '' s_mode_ori" ).append("\n"); 
		query.append("    , '' s_mode_dest" ).append("\n"); 
		query.append("    , '' s_route_ori" ).append("\n"); 
		query.append("    , '' s_route_dest" ).append("\n"); 
		query.append("    , '' fv_pre_pst_cd" ).append("\n"); 
		query.append("    , '' fv_vvd_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , '' fv_pol_cd" ).append("\n"); 
		query.append("    , '' fv_pol_yard_cd" ).append("\n"); 
		query.append("    , '' fv_pol_local" ).append("\n"); 
		query.append("    , '' fv_pod_cd" ).append("\n"); 
		query.append("    , '' fv_pod_yard_cd" ).append("\n"); 
		query.append("    , '' fv_pod_local" ).append("\n"); 
		query.append("    , '' cust_tp_cd_s" ).append("\n"); 
		query.append("    , '' cust_tp_cd_c" ).append("\n"); 
		query.append("    , '' cust_tp_cd_n" ).append("\n"); 
		query.append("    , '' cust_tp_cd_f" ).append("\n"); 
		query.append("    , '' cust_tp_cd_a" ).append("\n"); 
		query.append("    , '' cust_tp_cd_g" ).append("\n"); 
		query.append("    , '' cust_cnt_cd" ).append("\n"); 
		query.append("    , '' cust_seq" ).append("\n"); 
		query.append("    , '' cust_nm" ).append("\n"); 
		query.append("    , '' cust_tp_cd" ).append("\n"); 
		query.append("    , '' sp_cargo_dg" ).append("\n"); 
		query.append("    , '' sp_cargo_rf" ).append("\n"); 
		query.append("    , '' sp_cargo_ak" ).append("\n"); 
		query.append("    , '' sp_cargo_bb" ).append("\n"); 
		query.append("    , '' sp_cargo_hg" ).append("\n"); 
		query.append("    , '' sp_cargo_soc" ).append("\n"); 
		query.append("    , '' sp_cargo_eq" ).append("\n"); 
		query.append("    , '' sp_cargo_rd" ).append("\n"); 
		query.append("    , '' sp_cargo_pm" ).append("\n"); 
		query.append("    , '' sp_cargo_pc" ).append("\n"); 
		query.append("    , '' sp_cargo_fg" ).append("\n"); 
		query.append("    , '' sp_cargo_hd" ).append("\n"); 
		query.append("    , '' sp_cargo_rb" ).append("\n"); 
		query.append("    , '' cargo_tp_f" ).append("\n"); 
		query.append("    , '' cargo_tp_p" ).append("\n"); 
		query.append("    , '' cargo_tp_r" ).append("\n"); 
		query.append("    , '' bkg_sts_cd_f" ).append("\n"); 
		query.append("    , '' bkg_sts_cd_x" ).append("\n"); 
		query.append("    , '' bkg_sts_cd_a" ).append("\n"); 
		query.append("    , '' bkg_sts_cd_w" ).append("\n"); 
		query.append("    , '' non_sp_cargo" ).append("\n"); 
		query.append("    , '' holding" ).append("\n"); 
		query.append("    , '' bl_type_a" ).append("\n"); 
		query.append("    , '' bl_type_s" ).append("\n"); 
		query.append("    , '' rev" ).append("\n"); 
		query.append("    , '' non_rev" ).append("\n"); 
		query.append("    , '' aes_y" ).append("\n"); 
		query.append("    , '' aes_n" ).append("\n"); 
		query.append("    , '' stop_cargo" ).append("\n"); 
		query.append("    , '' ro_y" ).append("\n"); 
		query.append("    , '' ro_n" ).append("\n"); 
		query.append("    , '' caed_y" ).append("\n"); 
		query.append("    , '' caed_n" ).append("\n"); 
		query.append("    , '' crn_no_flag" ).append("\n"); 
		query.append("	, ' ' AS certi_d           " ).append("\n"); 
		query.append("	, ' ' AS certi_a           " ).append("\n"); 
		query.append("	, ' ' AS certi_b          " ).append("\n"); 
		query.append("	, ' ' AS certi_g               " ).append("\n"); 
		query.append("	, ' ' AS certi_c" ).append("\n"); 
		query.append("	, ' ' AS certi_checks" ).append("\n"); 
		query.append("    , '' certi_y" ).append("\n"); 
		query.append("    , '' certi_n" ).append("\n"); 
		query.append("    , '' rd_yn" ).append("\n"); 
		query.append("	, '' rate_check" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}