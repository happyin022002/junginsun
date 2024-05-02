/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSingleTransportationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.11
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.04.11 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSingleTransportationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O 입력용 VO를 생성하기 위한 TEMP SQL
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSingleTransportationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSingleTransportationRSQL").append("\n"); 
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
		query.append("'' trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(", '' trsp_so_seq" ).append("\n"); 
		query.append(", '' cost_act_grp_cd" ).append("\n"); 
		query.append(", '' fm_nod_cd" ).append("\n"); 
		query.append(", '' to_nod_cd" ).append("\n"); 
		query.append(", '' via_nod_cd" ).append("\n"); 
		query.append(", '' dor_nod_cd" ).append("\n"); 
		query.append(", '' fm_nod_cd2" ).append("\n"); 
		query.append(", '' to_nod_cd2" ).append("\n"); 
		query.append(", '' via_nod_cd2" ).append("\n"); 
		query.append(", '' dor_nod_cd2" ).append("\n"); 
		query.append(", '' eq_knd_cd" ).append("\n"); 
		query.append(", '' eq_tpsz_cd" ).append("\n"); 
		query.append(", '' trsp_bnd_cd" ).append("\n"); 
		query.append(", '' eq_no" ).append("\n"); 
		query.append(", '' bkg_no" ).append("\n"); 
		query.append(", '' bkg_no_split" ).append("\n"); 
		query.append(", '' bl_no" ).append("\n"); 
		query.append(", '' bl_no_tp" ).append("\n"); 
		query.append(", '' bl_no_chk" ).append("\n"); 
		query.append(", '' lgs_cost_cd" ).append("\n"); 
		query.append(", '' trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append(", '' trsp_crr_mod_cd" ).append("\n"); 
		query.append(", '' trsp_crr_mod_cd2" ).append("\n"); 
		query.append(", '' trsp_so_sts_cd" ).append("\n"); 
		query.append(", '' trsp_so_tp_cd" ).append("\n"); 
		query.append(", '' n3pty_bil_flg" ).append("\n"); 
		query.append(", '' curr_cd" ).append("\n"); 
		query.append(", '' bzc_amt" ).append("\n"); 
		query.append(", '' etc_add_amt" ).append("\n"); 
		query.append(", '' fuel_scg_amt" ).append("\n"); 
		query.append(", '' nego_amt" ).append("\n"); 
		query.append(", '' ovr_wgt_scg_amt" ).append("\n"); 
		query.append(", '' cntr_wgt" ).append("\n"); 
		query.append(", '' wgt_meas_ut_cd" ).append("\n"); 
		query.append(", '' cgo_tp_cd" ).append("\n"); 
		query.append(", '' cmdt_cd" ).append("\n"); 
		query.append(", '' dor_svc_tp_cd" ).append("\n"); 
		query.append(", '' dor_de_addr" ).append("\n"); 
		query.append(", '' mlt_stop_de_flg" ).append("\n"); 
		query.append(", '' spl_iss_rsn" ).append("\n"); 
		query.append(", '' trsp_purp_rsn" ).append("\n"); 
		query.append(", '' trns_rqst_ofc_cd" ).append("\n"); 
		query.append(", '' trns_rqst_usr_id" ).append("\n"); 
		query.append(", '' trns_rqst_rsn" ).append("\n"); 
		query.append(", '' cmb_so_rlt_sts_flg" ).append("\n"); 
		query.append(", '' trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append(", '' trsp_wo_seq" ).append("\n"); 
		query.append(", '' repo_ref_no" ).append("\n"); 
		query.append(", '' repo_ref_seq" ).append("\n"); 
		query.append(", '' chss_mgst_trsp_tp_cd" ).append("\n"); 
		query.append(", '' inter_rmk" ).append("\n"); 
		query.append(", '' spcl_instr_rmk" ).append("\n"); 
		query.append(", '' cre_ofc_cd" ).append("\n"); 
		query.append(", '' cre_dt" ).append("\n"); 
		query.append(", '' cre_usr_id" ).append("\n"); 
		query.append(", '' upd_dt" ).append("\n"); 
		query.append(", '' upd_usr_id" ).append("\n"); 
		query.append(", '' vndr_seq" ).append("\n"); 
		query.append(", '' trsp_so_cmb_tp_cd" ).append("\n"); 
		query.append(", '' trsp_so_cmb_seq" ).append("\n"); 
		query.append(", '' delt_flg" ).append("\n"); 
		query.append(", '' fm_nod_yard" ).append("\n"); 
		query.append(", '' to_nod_yard" ).append("\n"); 
		query.append(", '' via_nod_yard" ).append("\n"); 
		query.append(", '' dor_nod_yard" ).append("\n"); 
		query.append(", '' fm_nod_yard2" ).append("\n"); 
		query.append(", '' to_nod_yard2" ).append("\n"); 
		query.append(", '' via_nod_yard2" ).append("\n"); 
		query.append(", '' dor_nod_yard2" ).append("\n"); 
		query.append(", '' n1st_nod_pln_dt" ).append("\n"); 
		query.append(", '' n1st_nod_pln_dt_hms" ).append("\n"); 
		query.append(", '' dor_nod_pln_dt" ).append("\n"); 
		query.append(", '' dor_nod_pln_dt_hms" ).append("\n"); 
		query.append(", '' lst_nod_pln_dt" ).append("\n"); 
		query.append(", '' lst_nod_pln_dt_hms" ).append("\n"); 
		query.append(", '' if_sys_knd_cd" ).append("\n"); 
		query.append(", '' wo_iss_sts_cd" ).append("\n"); 
		query.append(", '' wo_iss_knt" ).append("\n"); 
		query.append(", '' cust_nomi_trkr_flg" ).append("\n"); 
		query.append(", '' vsl_cd" ).append("\n"); 
		query.append(", '' skd_voy_no" ).append("\n"); 
		query.append(", '' skd_dir_cd" ).append("\n"); 
		query.append(", '' fdr_vsl_cd" ).append("\n"); 
		query.append(", '' fdr_skd_voy_no" ).append("\n"); 
		query.append(", '' fdr_skd_dir_cd" ).append("\n"); 
		query.append(", '' trsp_mty_rqst_dt" ).append("\n"); 
		query.append(", '' slan_cd" ).append("\n"); 
		query.append(", '' cop_no" ).append("\n"); 
		query.append(", '' cost_act_grp_seq" ).append("\n"); 
		query.append(", '' lst_loc_cd" ).append("\n"); 
		query.append(", '' trunkvvd" ).append("\n"); 
		query.append(", '' feedervvd" ).append("\n"); 
		query.append(", '' bkg_rcvde_term_cd" ).append("\n"); 
		query.append(", '' por_cd" ).append("\n"); 
		query.append(", '' pol_cd" ).append("\n"); 
		query.append(", '' pod_cd" ).append("\n"); 
		query.append(", '' del_cd" ).append("\n"); 
		query.append(", '' bkg_edi_ref_no" ).append("\n"); 
		query.append(", '' spcl_cgo_cntr_tp_cd" ).append("\n"); 
		query.append(", '' ownr_co_cd" ).append("\n"); 
		query.append(", '' lstm_cd" ).append("\n"); 
		query.append(", '' imdt_ext_flg" ).append("\n"); 
		query.append(", '' cntr_pkup_no" ).append("\n"); 
		query.append(", '' cgor_frt_pay_ind_flg" ).append("\n"); 
		query.append(", '' cgor_org_bl_rcvr_ind_flg" ).append("\n"); 
		query.append(", '' cgor_cstms_acpt_re_ind_flg" ).append("\n"); 
		query.append(", '' ibd_cstms_clr_loc_cd" ).append("\n"); 
		query.append(", '' cntr_pkup_yd_cd" ).append("\n"); 
		query.append(", '' shpr_cust_nm" ).append("\n"); 
		query.append(", '' cnee_cust_nm" ).append("\n"); 
		query.append(", '' ntfy_cust_nm" ).append("\n"); 
		query.append(", '' lstm_exp_flg" ).append("\n"); 
		query.append(", '' aval_dt" ).append("\n"); 
		query.append(", '' aval_dt_hms" ).append("\n"); 
		query.append(", '' lst_free_dt" ).append("\n"); 
		query.append(", '' lst_free_dt_hms" ).append("\n"); 
		query.append(", '' sc_no" ).append("\n"); 
		query.append(", '' repo_pln_id" ).append("\n"); 
		query.append(", '' pln_yrwk" ).append("\n"); 
		query.append(", '' ref_id" ).append("\n"); 
		query.append(", '' ref_seq" ).append("\n"); 
		query.append(", '' trsp_mty_cost_mod_cd" ).append("\n"); 
		query.append(", '' trsp_rqst_bkg_flg" ).append("\n"); 
		query.append(", '' ib_vvd_cd" ).append("\n"); 
		query.append(", '' ob_vvd_cd" ).append("\n"); 
		query.append(", '' trsp_cost_dtl_mod_sep" ).append("\n"); 
		query.append(", '' upln_so_flg" ).append("\n"); 
		query.append(", '' trsp_nxt_port_cd" ).append("\n"); 
		query.append(", '' tro_seq" ).append("\n"); 
		query.append(", '' tro_sub_seq" ).append("\n"); 
		query.append(", '' cntr_sub_flg" ).append("\n"); 
		query.append(", '' sub_eq_tpsz_cd" ).append("\n"); 
		query.append(", '' conti_cd" ).append("\n"); 
		query.append(", '' fm_loc_conti_cd" ).append("\n"); 
		query.append(", '' cust_cnt_cd" ).append("\n"); 
		query.append(", '' cust_seq" ).append("\n"); 
		query.append(", '' act_cust_cnt_cd" ).append("\n"); 
		query.append(", '' act_cust_seq" ).append("\n"); 
		query.append(", '' act_cust_addr_seq" ).append("\n"); 
		query.append(", '' fctry_nm" ).append("\n"); 
		query.append(", '' cntc_pson_phn_no" ).append("\n"); 
		query.append(", '' cntc_pson_fax_no" ).append("\n"); 
		query.append(", '' cntc_pson_nm" ).append("\n"); 
		query.append(", '' cstms_clr_no" ).append("\n"); 
		query.append(", '' dor_arr_dt" ).append("\n"); 
		query.append(", '' rep_cmdt_cd" ).append("\n"); 
		query.append(", '' rev_curr_cd" ).append("\n"); 
		query.append(", '' trsp_rqst_ord_rev_amt" ).append("\n"); 
		query.append(", '' cntr_kgs_wgt" ).append("\n"); 
		query.append(", '' cntr_lbs_wgt" ).append("\n"); 
		query.append(", '' tro_cfm_ofc_cd" ).append("\n"); 
		query.append(", '' tro_cfm_usr_id" ).append("\n"); 
		query.append(", '' tro_cfm_upd_dt1" ).append("\n"); 
		query.append(", '' tro_cfm_upd_dt2" ).append("\n"); 
		query.append(", '' tro_cfm_rev_amt" ).append("\n"); 
		query.append(", '' tro_rep_cmdt_cd" ).append("\n"); 
		query.append(", '' tro_lod_ref_no" ).append("\n"); 
		query.append(", '' dor_pst_cd" ).append("\n"); 
		query.append(", '' ex_sep_data" ).append("\n"); 
		query.append(", '' trsp_rqst_ord_bnd_cd" ).append("\n"); 
		query.append(", '' trsp_rqst_ord_seq" ).append("\n"); 
		query.append(", '' cmdt_name" ).append("\n"); 
		query.append(", '' cnee_cnt_cd" ).append("\n"); 
		query.append(", '' shpr_cnt_cd" ).append("\n"); 
		query.append(", '' cnee_seq" ).append("\n"); 
		query.append(", '' shpr_seq" ).append("\n"); 
		query.append(", '' trsp_so_cmb_srt_no" ).append("\n"); 
		query.append(", '' trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append(", '' ctrl_ofc_cd" ).append("\n"); 
		query.append(", '' lse_cntr_flg" ).append("\n"); 
		query.append(", '' org_to_yd_cd" ).append("\n"); 
		query.append(", '' cbstatus" ).append("\n"); 
		query.append(", '' rail_cmb_thru_tp_cd" ).append("\n"); 
		query.append(", '' rfa_no" ).append("\n"); 
		query.append(", '' mst_lcl_cd" ).append("\n"); 
		query.append(", '' bkg_cgo_tp_cd" ).append("\n"); 
		query.append(", '' trsp_so_sts_nm" ).append("\n"); 
		query.append(", '' rail_cre_dt" ).append("\n"); 
		query.append(", '' rail_to_nod_cd" ).append("\n"); 
		query.append(", '' pod_conti_cd" ).append("\n"); 
		query.append(", '' act_grp_cd -- cop replan" ).append("\n"); 
		query.append(", '' rpln_umch_flg" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}