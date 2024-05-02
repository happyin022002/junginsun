/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOMultiSingleTrsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOMultiSingleTrsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CY & DOOR S/O Creation
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOMultiSingleTrsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_rsn_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_free_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_srt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_nod_pln_dt_hms",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_cfm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_pln_dt_hms",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_kgs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_dist_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mty_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_cfm_upd_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_cfm_upd_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_cstms_clr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmb_so_rlt_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rqst_ord_rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_addr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upln_so_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlt_stop_de_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_cntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aval_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mty_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_nod_pln_dt_hms",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunkvvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_nxt_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_de_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_instr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fctry_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbstatus",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_dtl_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_pull_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_cfm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("feedervvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcvde_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lbs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_lod_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOMultiSingleTrsCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_SVC_ORD ( " ).append("\n"); 
		query.append("       TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("     , TRSP_SO_SEQ        " ).append("\n"); 
		query.append("     , COST_ACT_GRP_CD" ).append("\n"); 
		query.append("     , FM_NOD_CD" ).append("\n"); 
		query.append("     , TO_NOD_CD" ).append("\n"); 
		query.append("     , VIA_NOD_CD" ).append("\n"); 
		query.append("     , DOR_NOD_CD" ).append("\n"); 
		query.append("     , EQ_KND_CD" ).append("\n"); 
		query.append("     , EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , ORG_EQ_TPSZ_CD " ).append("\n"); 
		query.append("     , TRSP_BND_CD" ).append("\n"); 
		query.append("     , EQ_NO" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , ORG_BKG_NO " ).append("\n"); 
		query.append("     , BL_NO" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("     , DOR_DE_ADDR" ).append("\n"); 
		query.append("     , TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("     , TRSP_SO_STS_CD " ).append("\n"); 
		query.append("     , TRSP_SO_TP_CD " ).append("\n"); 
		query.append("     , CNTR_WGT" ).append("\n"); 
		query.append("     , WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("     , CGO_TP_CD" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     , DOR_SVC_TP_CD" ).append("\n"); 
		query.append("     , MLT_STOP_DE_FLG" ).append("\n"); 
		query.append("     , INTER_RMK" ).append("\n"); 
		query.append("     , SPCL_INSTR_RMK" ).append("\n"); 
		query.append("     , TRSP_SO_CMB_TP_CD " ).append("\n"); 
		query.append("     , N1ST_NOD_PLN_DT " ).append("\n"); 
		query.append("     , DOR_NOD_PLN_DT" ).append("\n"); 
		query.append("     , LST_NOD_PLN_DT" ).append("\n"); 
		query.append("     , CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("     , TRSP_SO_CMB_SEQ " ).append("\n"); 
		query.append("     , CMB_SO_RLT_STS_FLG " ).append("\n"); 
		query.append("     , TRSP_SO_CMB_SRT_NO" ).append("\n"); 
		query.append("     , COP_NO" ).append("\n"); 
		query.append("     , COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("     , ORG_COP_NO " ).append("\n"); 
		query.append("     , ORG_COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("     , VSL_CD " ).append("\n"); 
		query.append("     , SKD_VOY_NO " ).append("\n"); 
		query.append("     , SKD_DIR_CD " ).append("\n"); 
		query.append("     , FDR_VSL_CD " ).append("\n"); 
		query.append("     , FDR_SKD_VOY_NO " ).append("\n"); 
		query.append("     , FDR_SKD_DIR_CD " ).append("\n"); 
		query.append("     , BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append("     , POR_CD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , DEL_CD" ).append("\n"); 
		query.append("     , SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("     , IBD_CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , REPO_PLN_ID " ).append("\n"); 
		query.append("     , PLN_YRWK " ).append("\n"); 
		query.append("     , REF_ID " ).append("\n"); 
		query.append("     , REF_SEQ " ).append("\n"); 
		query.append("     , TRSP_MTY_COST_MOD_CD " ).append("\n"); 
		query.append("     , TRSP_MTY_RQST_DT" ).append("\n"); 
		query.append("     , SLAN_CD " ).append("\n"); 
		query.append("     , IB_VVD_CD" ).append("\n"); 
		query.append("     , OB_VVD_CD" ).append("\n"); 
		query.append("     , TRSP_NXT_PORT_CD" ).append("\n"); 
		query.append("     , TRO_SEQ" ).append("\n"); 
		query.append("     , TRO_SUB_SEQ" ).append("\n"); 
		query.append("     , CNTR_PKUP_NO" ).append("\n"); 
		query.append("     , AVAL_DT" ).append("\n"); 
		query.append("     , LST_FREE_DT" ).append("\n"); 
		query.append("     , UPLN_SO_FLG" ).append("\n"); 
		query.append("     , FCTRY_NM" ).append("\n"); 
		query.append("     , CNTC_PSON_NM" ).append("\n"); 
		query.append("     , CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("     , CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append("     , ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("     , ACT_CUST_SEQ" ).append("\n"); 
		query.append("     , ACT_CUST_ADDR_SEQ" ).append("\n"); 
		query.append("     , CSTMS_CLR_NO" ).append("\n"); 
		query.append("     , DOR_ARR_DT" ).append("\n"); 
		query.append("     , REP_CMDT_CD" ).append("\n"); 
		query.append("     , REV_CURR_CD" ).append("\n"); 
		query.append("     , TRSP_RQST_ORD_REV_AMT" ).append("\n"); 
		query.append("     , CNTR_KGS_WGT" ).append("\n"); 
		query.append("     , CNTR_LBS_WGT" ).append("\n"); 
		query.append("     , TRO_CFM_OFC_CD" ).append("\n"); 
		query.append("     , TRO_CFM_USR_ID" ).append("\n"); 
		query.append("     , TRO_CFM_UPD_DT" ).append("\n"); 
		query.append("     , TRO_REP_CMDT_CD" ).append("\n"); 
		query.append("     , TRO_LOD_REF_NO" ).append("\n"); 
		query.append("     , DOR_PST_CD" ).append("\n"); 
		query.append("     , CONTI_CD " ).append("\n"); 
		query.append("     , DELT_FLG " ).append("\n"); 
		query.append("     , CRE_OFC_CD" ).append("\n"); 
		query.append("     , CRE_DT " ).append("\n"); 
		query.append("     , CRE_USR_ID " ).append("\n"); 
		query.append("     , UPD_DT " ).append("\n"); 
		query.append("     , UPD_USR_ID " ).append("\n"); 
		query.append("     , LOCL_CRE_DT" ).append("\n"); 
		query.append("     , LOCL_UPD_DT" ).append("\n"); 
		query.append("     , LSE_CNTR_FLG" ).append("\n"); 
		query.append("     , TTL_DIST" ).append("\n"); 
		query.append("     , LNK_DIST_DIV_CD" ).append("\n"); 
		query.append("	 , CNG_RSN_DESC" ).append("\n"); 
		query.append("	 , PRE_PULL_FLG" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("       substr(@[cre_ofc_cd],1,3)" ).append("\n"); 
		query.append("     , @[trsp_so_seq]     " ).append("\n"); 
		query.append("     , @[cost_act_grp_cd]" ).append("\n"); 
		query.append("     , @[fm_nod_cd]||@[fm_nod_yard]" ).append("\n"); 
		query.append("     , @[to_nod_cd]||@[to_nod_yard]" ).append("\n"); 
		query.append("     , @[via_nod_cd]||@[via_nod_yard]" ).append("\n"); 
		query.append("     , @[dor_nod_cd]||@[dor_nod_yard]" ).append("\n"); 
		query.append("     , 'U' --" ).append("\n"); 
		query.append("     , @[eq_tpsz_cd]" ).append("\n"); 
		query.append("     , @[eq_tpsz_cd] -- org_eq_tpsz_cd" ).append("\n"); 
		query.append("     , @[trsp_bnd_cd]" ).append("\n"); 
		query.append("     , @[eq_no]" ).append("\n"); 
		query.append("     , @[bkg_no]" ).append("\n"); 
		query.append("     , @[bkg_no] -- org_bkg_no" ).append("\n"); 
		query.append("     , @[bl_no]" ).append("\n"); 
		query.append("     , DECODE(@[cust_cnt_cd], '0', '', @[cust_cnt_cd])" ).append("\n"); 
		query.append("     , DECODE(@[cust_seq], '0', '', @[cust_seq])" ).append("\n"); 
		query.append("     , @[trsp_cost_dtl_mod_cd]" ).append("\n"); 
		query.append("     , @[dor_de_addr]" ).append("\n"); 
		query.append("     , @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("     , 'C' -- trsp_so_sts_cd" ).append("\n"); 
		query.append("     , 'Y' -- trsp_so_tp_cd" ).append("\n"); 
		query.append("     , @[cntr_wgt]" ).append("\n"); 
		query.append("     , @[wgt_meas_ut_cd]" ).append("\n"); 
		query.append("     , @[cgo_tp_cd]" ).append("\n"); 
		query.append("     , @[cmdt_cd]" ).append("\n"); 
		query.append("     , @[dor_svc_tp_cd]" ).append("\n"); 
		query.append("     , @[mlt_stop_de_flg]" ).append("\n"); 
		query.append("     , @[inter_rmk]" ).append("\n"); 
		query.append("     , @[spcl_instr_rmk]" ).append("\n"); 
		query.append("     , @[trsp_so_cmb_tp_cd] -- Combined 관련 컬럼" ).append("\n"); 
		query.append("     , TO_DATE(@[n1st_nod_pln_dt]||@[n1st_nod_pln_dt_hms], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("     , TO_DATE(@[dor_nod_pln_dt]||@[dor_nod_pln_dt_hms], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("     , TO_DATE(@[lst_nod_pln_dt]||@[lst_nod_pln_dt_hms], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("     , @[cust_nomi_trkr_flg]" ).append("\n"); 
		query.append("     , DECODE(@[cbstatus], 'CF', @[trsp_so_cmb_seq], 'CS', @[trsp_so_cmb_seq], null) -- Combined 관련 컬럼 (trsp_so_cmb_seq)" ).append("\n"); 
		query.append("     , DECODE(@[cbstatus], 'CF', @[cmb_so_rlt_sts_flg], 'CS', @[cmb_so_rlt_sts_flg], null) -- Combined 관련 컬럼 (cmb_so_rlt_sts_flg)" ).append("\n"); 
		query.append("     , DECODE(@[cbstatus], 'CF', @[trsp_so_cmb_srt_no], 'CS', @[trsp_so_cmb_srt_no], null) -- Combined 관련 컬럼 (trsp_so_cmb_srt_no)" ).append("\n"); 
		query.append("     , @[cop_no]" ).append("\n"); 
		query.append("     , @[cost_act_grp_seq]" ).append("\n"); 
		query.append("     , @[cop_no] -- org_cop_no" ).append("\n"); 
		query.append("     , @[cost_act_grp_seq] -- org_cost_act_grp_seq" ).append("\n"); 
		query.append("     , SUBSTR(@[trunkvvd],1,4) --vsl_cd" ).append("\n"); 
		query.append("     , SUBSTR(@[trunkvvd],5,4) --skd_voy_no " ).append("\n"); 
		query.append("     , SUBSTR(@[trunkvvd],9)   --skd_dir_cd" ).append("\n"); 
		query.append("     , SUBSTR(@[feedervvd],1,4) --fdr_vsl_cd" ).append("\n"); 
		query.append("     , SUBSTR(@[feedervvd],5,4) --fdr_skd_voy_no " ).append("\n"); 
		query.append("     , SUBSTR(@[feedervvd],9)   --fdr_skd_dir_cd" ).append("\n"); 
		query.append("     , @[bkg_rcvde_term_cd]" ).append("\n"); 
		query.append("     , @[por_cd]" ).append("\n"); 
		query.append("     , @[pol_cd]" ).append("\n"); 
		query.append("     , @[pod_cd]" ).append("\n"); 
		query.append("     , @[del_cd]" ).append("\n"); 
		query.append("     , @[spcl_cgo_cntr_tp_cd]" ).append("\n"); 
		query.append("     , @[ibd_cstms_clr_loc_cd]" ).append("\n"); 
		query.append("     , @[vndr_seq]" ).append("\n"); 
		query.append("     , @[repo_pln_id]" ).append("\n"); 
		query.append("     , @[pln_yrwk]" ).append("\n"); 
		query.append("     , @[ref_id]" ).append("\n"); 
		query.append("     , @[ref_seq]" ).append("\n"); 
		query.append("     , @[trsp_mty_cost_mod_cd]" ).append("\n"); 
		query.append("     , @[trsp_mty_rqst_dt]" ).append("\n"); 
		query.append("     , @[slan_cd]" ).append("\n"); 
		query.append("     , @[ib_vvd_cd]" ).append("\n"); 
		query.append("     , @[ob_vvd_cd]" ).append("\n"); 
		query.append("     , @[trsp_nxt_port_cd]" ).append("\n"); 
		query.append("     , @[tro_seq]" ).append("\n"); 
		query.append("     , @[tro_sub_seq]" ).append("\n"); 
		query.append("     , @[cntr_pkup_no]" ).append("\n"); 
		query.append("     , TO_DATE(@[aval_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("     , TO_DATE(@[lst_free_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("     , @[upln_so_flg]" ).append("\n"); 
		query.append("     , @[fctry_nm]" ).append("\n"); 
		query.append("     , @[cntc_pson_nm]" ).append("\n"); 
		query.append("     , @[cntc_pson_phn_no]" ).append("\n"); 
		query.append("     , @[cntc_pson_fax_no]" ).append("\n"); 
		query.append("     , @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("     , @[act_cust_seq]" ).append("\n"); 
		query.append("     , @[act_cust_addr_seq]" ).append("\n"); 
		query.append("     , @[cstms_clr_no]" ).append("\n"); 
		query.append("     , TO_DATE(@[dor_arr_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("     , @[rep_cmdt_cd]" ).append("\n"); 
		query.append("     , @[rev_curr_cd]" ).append("\n"); 
		query.append("     , @[trsp_rqst_ord_rev_amt]" ).append("\n"); 
		query.append("     , @[cntr_kgs_wgt]" ).append("\n"); 
		query.append("     , @[cntr_lbs_wgt]" ).append("\n"); 
		query.append("     , @[tro_cfm_ofc_cd]" ).append("\n"); 
		query.append("     , @[tro_cfm_usr_id]" ).append("\n"); 
		query.append("     , TO_DATE(@[tro_cfm_upd_dt1]||@[tro_cfm_upd_dt2], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("     , @[tro_rep_cmdt_cd]" ).append("\n"); 
		query.append("     , @[tro_lod_ref_no]" ).append("\n"); 
		query.append("     , @[dor_pst_cd]" ).append("\n"); 
		query.append("     , @[fm_loc_conti_cd] -- conti_cd" ).append("\n"); 
		query.append("     , 'N'            -- delt_flg  " ).append("\n"); 
		query.append("     , @[cre_ofc_cd] -- cre_ofc_cd" ).append("\n"); 
		query.append("     , sysdate       -- cre_dt" ).append("\n"); 
		query.append("     , @[cre_usr_id] -- cre_usr_id" ).append("\n"); 
		query.append("     , sysdate       -- upd_dt" ).append("\n"); 
		query.append("     , @[cre_usr_id] -- upd_usr_id" ).append("\n"); 
		query.append("     , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]) -- loc_cre_dt" ).append("\n"); 
		query.append("     , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]) -- loc_upd_dt" ).append("\n"); 
		query.append("     , @[lse_cntr_flg]" ).append("\n"); 
		query.append("     , @[ttl_dist]" ).append("\n"); 
		query.append("     , @[lnk_dist_div_cd]" ).append("\n"); 
		query.append("	 , REPLACE(@[cng_rsn_desc], CHR(13)||CHR(10), ' ')" ).append("\n"); 
		query.append("     , @[pre_pull_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}