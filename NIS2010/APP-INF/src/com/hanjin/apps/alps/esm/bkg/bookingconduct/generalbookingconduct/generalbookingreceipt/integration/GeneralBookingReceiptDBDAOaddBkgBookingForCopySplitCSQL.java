/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOaddBkgBookingForCopySplitCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOaddBkgBookingForCopySplitCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOaddBkgBookingForCopySplitCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flex_hgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_hld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ib_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_hlg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("split_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_si_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_si_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sam_cnee_ntfy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fumg_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_si_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_bkg_rqst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("split_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_auto_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pre_vvd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_act_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_blk_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnd_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trns_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_split_aval_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_subst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_svc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("si_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("de_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_bkg_rqst_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fumg_cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("veh_cmdt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aloc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("non_dg_chem_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fumg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("alt_cust_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_port_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_off_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("split_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fd_grd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wt_rsn_hld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_blck_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_bkg_no_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fumg_diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_hide_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_bak_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_soc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ocp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("my_fwrd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wt_rsn_spcl_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("my_fwrd_vsl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk_aud_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("twn_so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_bkg_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_brog_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_del_de_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_off_diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_to_ord_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("all_mtr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_hide_lnr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_cust_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_void_slt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blck_stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_off_cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adv_shtg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dbl_bkg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcmt_cmb_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_off_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_trns_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_cre_svr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_rt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOaddBkgBookingForCopySplitCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_BOOKING (" ).append("\n"); 
		query.append("OB_SLS_OFC_CD" ).append("\n"); 
		query.append(",	OB_SREP_CD" ).append("\n"); 
		query.append(",	IB_SLS_OFC_CD" ).append("\n"); 
		query.append(",	EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(",	BKG_CRE_DT" ).append("\n"); 
		query.append(",   BKG_CRE_GDT" ).append("\n"); 
		query.append(",	PORT_CLZ_DT" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	REP_CMDT_CD" ).append("\n"); 
		query.append(",	DCGO_FLG" ).append("\n"); 
		query.append(",	RC_FLG" ).append("\n"); 
		query.append(",	AWK_CGO_FLG" ).append("\n"); 
		query.append(",	BB_CGO_FLG" ).append("\n"); 
		query.append(",	RD_CGO_FLG" ).append("\n"); 
		query.append(",	HNGR_FLG" ).append("\n"); 
		query.append(",	RAIL_BLK_CD" ).append("\n"); 
		query.append(",	PRCT_FLG" ).append("\n"); 
		query.append(",	SPCL_HIDE_FLG" ).append("\n"); 
		query.append(",	SOC_FLG" ).append("\n"); 
		query.append(",	EQ_SUBST_FLG" ).append("\n"); 
		query.append(",	FD_GRD_FLG" ).append("\n"); 
		query.append(",	FLEX_HGT_FLG" ).append("\n"); 
		query.append(",	STWG_CD" ).append("\n"); 
		query.append(",	STWG_RMK" ).append("\n"); 
		query.append(",	BLCK_STWG_CD" ).append("\n"); 
		query.append(",	ALL_MTR_FLG" ).append("\n"); 
		query.append(",	DBL_BKG_FLG" ).append("\n"); 
		query.append(",	AP_BROG_FLG" ).append("\n"); 
		query.append(",	CUST_TO_ORD_FLG" ).append("\n"); 
		query.append(",	KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append(",	SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append(",	ALT_CUST_CFM_FLG" ).append("\n"); 
		query.append(",	WT_RSN_SPCL_CGO_FLG" ).append("\n"); 
		query.append(",	WT_RSN_HLD_FLG" ).append("\n"); 
		query.append(",	SHP_BAK_FLG" ).append("\n"); 
		query.append(",	MNL_BKG_NO_FLG" ).append("\n"); 
		query.append(",	BL_ISS_BLCK_FLG" ).append("\n"); 
		query.append(",	CA_INSP_DUE_DT" ).append("\n"); 
		query.append(",	SCAC_CD" ).append("\n"); 
		query.append(",	CHN_AGN_CD" ).append("\n"); 
		query.append(",	USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",	CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",	TWN_SO_NO" ).append("\n"); 
		query.append(",	INTER_RMK" ).append("\n"); 
		query.append(",	XTER_RMK" ).append("\n"); 
		query.append(",	INTER_RMK_AUD_FLG" ).append("\n"); 
		query.append(",	SPLIT_FLG" ).append("\n"); 
		query.append(",	HCMT_CMB_FLG" ).append("\n"); 
		query.append(",	BKG_CRE_TP_CD" ).append("\n"); 
		query.append(",	TO_BKG_NO" ).append("\n"); 
		query.append(",	FM_BKG_NO" ).append("\n"); 
		query.append(",	ADV_SHTG_CD" ).append("\n"); 
		query.append(",	SPLIT_RSN_CD" ).append("\n"); 
		query.append(",	SPLIT_RTO" ).append("\n"); 
		query.append(",	SPLIT_DT" ).append("\n"); 
		query.append(",   SPLIT_GDT" ).append("\n"); 
		query.append(",	SC_NO" ).append("\n"); 
		query.append(",	RFA_NO" ).append("\n"); 
		query.append(",	TAA_NO" ).append("\n"); 
		query.append(",	AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append(",	AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append(",	MTY_CRE_SVR_CD" ).append("\n"); 
		query.append(",	MTY_BKG_STS_CD" ).append("\n"); 
		query.append(",	MTY_POD_FLG" ).append("\n"); 
		query.append(",	MTY_PRE_VVD_FLG" ).append("\n"); 
		query.append(",	MTY_PORT_FLG" ).append("\n"); 
		query.append(",	MTY_SPLIT_AVAL_CD" ).append("\n"); 
		query.append(",	XTER_BKG_RQST_CD" ).append("\n"); 
		query.append(",	XTER_BKG_RQST_REF_NO" ).append("\n"); 
		query.append(",	SI_FLG" ).append("\n"); 
		query.append(",	XTER_SI_CD" ).append("\n"); 
		query.append(",	XTER_SI_REF_NO" ).append("\n"); 
		query.append(",	XTER_RQST_AUTO_NTC_FLG" ).append("\n"); 
		query.append(",   EDI_HLD_FLG" ).append("\n"); 
		query.append(",	XTER_BKG_KNT" ).append("\n"); 
		query.append(",	XTER_SI_KNT" ).append("\n"); 
		query.append(",	XTER_RQST_CUST_RMK" ).append("\n"); 
		query.append(",	OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append(",	MY_FWRD_CD" ).append("\n"); 
		query.append(",	MY_FWRD_VSL_DESC" ).append("\n"); 
		query.append(",	PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(",	PST_RLY_PORT_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	BL_TP_CD" ).append("\n"); 
		query.append(", 	BL_NO_TP" ).append("\n"); 
		query.append(",	BKG_STS_CD" ).append("\n"); 
		query.append(",	BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	REV_DIR_CD" ).append("\n"); 
		query.append(",	RCV_TERM_CD" ).append("\n"); 
		query.append(",	DE_TERM_CD" ).append("\n"); 
		query.append(",	POR_CD" ).append("\n"); 
		query.append(",	POR_NOD_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POL_NOD_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	POD_NOD_CD" ).append("\n"); 
		query.append(",	OCP_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(",	DEL_NOD_CD" ).append("\n"); 
		query.append(",	FNL_DEST_CD" ).append("\n"); 
		query.append(",	POL_ETD_DT" ).append("\n"); 
		query.append(",	POD_ETA_DT" ).append("\n"); 
		query.append(",	MTY_PKUP_YD_CD" ).append("\n"); 
		query.append(",	MTY_PKUP_DT" ).append("\n"); 
		query.append(",	FULL_RTN_YD_CD" ).append("\n"); 
		query.append(",	FULL_PKUP_YD_CD" ).append("\n"); 
		query.append(",	MTY_RTN_YD_CD" ).append("\n"); 
		query.append(",	MTY_DOR_ARR_DT" ).append("\n"); 
		query.append(",	LODG_DUE_DT" ).append("\n"); 
		query.append(",	DE_DUE_DT" ).append("\n"); 
		query.append(",	IB_DEL_DE_DT" ).append("\n"); 
		query.append(",	ORG_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append(",	ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append(",	ORG_SCONTI_CD" ).append("\n"); 
		query.append(",	DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append(",	DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append(",	DEST_SCONTI_CD" ).append("\n"); 
		query.append(",	STOP_OFF_LOC_CD" ).append("\n"); 
		query.append(",	STOP_OFF_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	STOP_OFF_CNTC_PHN_NO" ).append("\n"); 
		query.append(",	STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append(",	SLS_RHQ_CD" ).append("\n"); 
		query.append(",	SLS_RGN_OFC_CD" ).append("\n"); 
		query.append(",	BKG_OFC_CD" ).append("\n"); 
		query.append(",	DOC_USR_ID" ).append("\n"); 
		query.append(",   PCTL_NO" ).append("\n"); 
		query.append(",   ALOC_STS_CD" ).append("\n"); 
		query.append(",   ALOC_SVC_CD" ).append("\n"); 
		query.append(",   BKG_ALOC_TP_CD" ).append("\n"); 
		query.append(",   FUMG_LOC_CD" ).append("\n"); 
		query.append(",   FUMG_CNTC_PSON_NM" ).append("\n"); 
		query.append(",   FUMG_CNTC_PHN_NO" ).append("\n"); 
		query.append(",   FUMG_DIFF_RMK" ).append("\n"); 
		query.append(",   SPCL_HIDE_LNR_FLG" ).append("\n"); 
		query.append(",   CRR_SOC_FLG" ).append("\n"); 
		query.append(",   NON_RT_STS_CD" ).append("\n"); 
		query.append(",   VEH_CMDT_FLG" ).append("\n"); 
		query.append(",   IDA_HLG_TP_CD" ).append("\n"); 
		query.append(",   NON_DG_CHEM_FLG" ).append("\n"); 
		query.append(") VALUES( @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append(",	@[ob_srep_cd]" ).append("\n"); 
		query.append(",	@[ib_sls_ofc_cd]" ).append("\n"); 
		query.append(",	@[eq_ctrl_ofc_cd]" ).append("\n"); 
		query.append(",	GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,BKG_COM_USER_LOC_FNC(@[cre_usr_id]))" ).append("\n"); 
		query.append(",   GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', sysdate, 'GMT')" ).append("\n"); 
		query.append(",	TO_DATE(@[port_clz_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[cmdt_cd]" ).append("\n"); 
		query.append(",	@[rep_cmdt_cd]" ).append("\n"); 
		query.append(",	@[dcgo_flg]" ).append("\n"); 
		query.append(",	@[rc_flg]" ).append("\n"); 
		query.append(",	@[awk_cgo_flg]" ).append("\n"); 
		query.append(",	@[bb_cgo_flg]" ).append("\n"); 
		query.append(",	nvl(@[rd_cgo_flg],'N')" ).append("\n"); 
		query.append(",	@[hngr_flg]" ).append("\n"); 
		query.append(",	@[rail_blk_cd]" ).append("\n"); 
		query.append(",	@[prct_flg]" ).append("\n"); 
		query.append(",	@[spcl_hide_flg]" ).append("\n"); 
		query.append(",	@[soc_flg]" ).append("\n"); 
		query.append(",	@[eq_subst_flg]" ).append("\n"); 
		query.append(",	@[fd_grd_flg]" ).append("\n"); 
		query.append(",	@[flex_hgt_flg]" ).append("\n"); 
		query.append(",	@[stwg_cd]" ).append("\n"); 
		query.append(",	@[stwg_rmk]" ).append("\n"); 
		query.append(",	@[blck_stwg_cd]" ).append("\n"); 
		query.append(",	@[all_mtr_flg]" ).append("\n"); 
		query.append(",	@[dbl_bkg_flg]" ).append("\n"); 
		query.append(",	@[ap_brog_flg]" ).append("\n"); 
		query.append(",	@[cust_to_ord_flg]" ).append("\n"); 
		query.append(",	@[kr_cstms_cust_tp_cd]" ).append("\n"); 
		query.append(",	@[sam_cnee_ntfy_flg]" ).append("\n"); 
		query.append(",	@[alt_cust_cfm_flg]" ).append("\n"); 
		query.append(",	@[wt_rsn_spcl_cgo_flg]" ).append("\n"); 
		query.append(",	@[wt_rsn_hld_flg]" ).append("\n"); 
		query.append(",	@[shp_bak_flg]" ).append("\n"); 
		query.append(",	case when length(@[bkg_no]) <> 12 and 'Y' = (select 'Y' from bkg_chn_agn        where chn_agn_cd = substr(@[bkg_no], 5, 2) and rownum = 1) " ).append("\n"); 
		query.append("			then 'Y'" ).append("\n"); 
		query.append("         when length(@[bkg_no]) =  12 and 'Y' = (select 'Y' from bkg_chn_bkg_no_gen where chn_agn_cd = substr(@[bkg_no], 3, 2) and rownum = 1) " ).append("\n"); 
		query.append("			then 'Y'" ).append("\n"); 
		query.append("		 when length((select chn_agn_cd from bkg_booking where bkg_no = @[fm_bkg_no] and @[bkg_cre_tp_cd] = 'S')) = 2 " ).append("\n"); 
		query.append("			then 'Y'" ).append("\n"); 
		query.append("		 else NVL(@[mnl_bkg_no_flg],'N') end" ).append("\n"); 
		query.append(",	@[bl_iss_blck_flg]" ).append("\n"); 
		query.append(",	null" ).append("\n"); 
		query.append(",	@[scac_cd]" ).append("\n"); 
		query.append(",	case when length(@[bkg_no]) <> 12 and 'Y' = (select 'Y' from bkg_chn_agn        where chn_agn_cd = substr(@[bkg_no], 5, 2) and rownum = 1) " ).append("\n"); 
		query.append("			then substr(@[bkg_no], 5, 2)" ).append("\n"); 
		query.append("         when length(@[bkg_no]) =  12 and 'Y' = (select 'Y' from bkg_chn_bkg_no_gen where chn_agn_cd = substr(@[bkg_no], 3, 2) and rownum = 1) " ).append("\n"); 
		query.append("			then substr(@[bkg_no], 3, 2)" ).append("\n"); 
		query.append("		 when length((select chn_agn_cd from bkg_booking where bkg_no = @[fm_bkg_no] and @[bkg_cre_tp_cd] = 'S')) = 2 " ).append("\n"); 
		query.append("			then (select chn_agn_cd from bkg_booking where bkg_no = @[fm_bkg_no])" ).append("\n"); 
		query.append("		 else null end" ).append("\n"); 
		query.append(",	@[usa_cstms_file_cd]" ).append("\n"); 
		query.append(",	@[cnd_cstms_file_cd]" ).append("\n"); 
		query.append(",	@[twn_so_no]" ).append("\n"); 
		query.append(",	@[inter_rmk]" ).append("\n"); 
		query.append(",	@[xter_rmk]" ).append("\n"); 
		query.append(",	@[inter_rmk_aud_flg]" ).append("\n"); 
		query.append(",	@[split_flg]" ).append("\n"); 
		query.append(",	@[hcmt_cmb_flg]" ).append("\n"); 
		query.append(",	@[bkg_cre_tp_cd]" ).append("\n"); 
		query.append(",	@[to_bkg_no]" ).append("\n"); 
		query.append(",	@[fm_bkg_no]" ).append("\n"); 
		query.append(",	@[adv_shtg_cd]" ).append("\n"); 
		query.append(",	@[split_rsn_cd]" ).append("\n"); 
		query.append(",	@[split_rto]" ).append("\n"); 
		query.append(",	DECODE(@[bkg_cre_tp_cd], 'S', GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,BKG_COM_USER_LOC_FNC(@[cre_usr_id])), NULL)" ).append("\n"); 
		query.append(",   DECODE(@[bkg_cre_tp_cd], 'S', GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', sysdate, 'GMT'), NULL)" ).append("\n"); 
		query.append(",	@[sc_no]" ).append("\n"); 
		query.append(",	@[rfa_no]" ).append("\n"); 
		query.append(",	@[taa_no]" ).append("\n"); 
		query.append(",	@[agmt_act_cnt_cd]" ).append("\n"); 
		query.append(",	@[agmt_act_cust_seq]" ).append("\n"); 
		query.append(",	@[mty_cre_svr_cd]" ).append("\n"); 
		query.append(",	@[mty_bkg_sts_cd]" ).append("\n"); 
		query.append(",	@[mty_pod_flg]" ).append("\n"); 
		query.append(",	@[mty_pre_vvd_flg]" ).append("\n"); 
		query.append(",	@[mty_port_flg]" ).append("\n"); 
		query.append(",	@[mty_split_aval_cd]" ).append("\n"); 
		query.append(",	@[xter_bkg_rqst_cd]" ).append("\n"); 
		query.append(",	@[xter_bkg_rqst_ref_no]" ).append("\n"); 
		query.append(",	@[si_flg]" ).append("\n"); 
		query.append(",	@[xter_si_cd]" ).append("\n"); 
		query.append(",	@[xter_si_ref_no]" ).append("\n"); 
		query.append(",	nvl(@[xter_rqst_auto_ntc_flg], 'N')" ).append("\n"); 
		query.append(",   nvl(@[edi_hld_flg], 'N')" ).append("\n"); 
		query.append(",	@[xter_bkg_knt]" ).append("\n"); 
		query.append(",	@[xter_si_knt]" ).append("\n"); 
		query.append(",	@[xter_rqst_cust_rmk]" ).append("\n"); 
		query.append(",	@[ovr_void_slt_qty]" ).append("\n"); 
		query.append(",	@[my_fwrd_cd]" ).append("\n"); 
		query.append(",	@[my_fwrd_vsl_desc]" ).append("\n"); 
		query.append(",	@[pre_rly_port_cd]" ).append("\n"); 
		query.append(",	@[pst_rly_port_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[bkg_no]" ).append("\n"); 
		query.append(",	@[bl_no]" ).append("\n"); 
		query.append(",   NULL" ).append("\n"); 
		query.append(",   nvl(@[bl_no_tp], '0')" ).append("\n"); 
		query.append(",	@[bkg_sts_cd]" ).append("\n"); 
		query.append(",	@[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append(",	@[slan_cd]" ).append("\n"); 
		query.append(",	@[svc_scp_cd]" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[rev_dir_cd]" ).append("\n"); 
		query.append(",	@[rcv_term_cd]" ).append("\n"); 
		query.append(",	@[de_term_cd]" ).append("\n"); 
		query.append(",	@[por_cd]" ).append("\n"); 
		query.append(",	@[por_nod_cd]" ).append("\n"); 
		query.append(",	@[pol_cd]" ).append("\n"); 
		query.append(",	@[pol_nod_cd]" ).append("\n"); 
		query.append(",	@[pod_cd]" ).append("\n"); 
		query.append(",	@[pod_nod_cd]" ).append("\n"); 
		query.append(",	@[ocp_cd]" ).append("\n"); 
		query.append(",	@[del_cd]" ).append("\n"); 
		query.append(",	@[del_nod_cd]" ).append("\n"); 
		query.append(",	@[fnl_dest_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[pol_etd_dt],    'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	TO_DATE(@[pod_eta_dt],    'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[mty_pkup_yd_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[mty_pkup_dt],   'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[full_rtn_yd_cd]" ).append("\n"); 
		query.append(",	@[full_pkup_yd_cd]" ).append("\n"); 
		query.append(",	@[mty_rtn_yd_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[mty_dor_arr_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	TO_DATE(@[lodg_due_dt],   'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	TO_DATE(@[de_due_dt],     'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	TO_DATE(@[ib_del_de_dt],  'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[org_trns_svc_mod_cd]" ).append("\n"); 
		query.append(",	@[org_trns_mod_cd]" ).append("\n"); 
		query.append(",	@[org_sconti_cd]" ).append("\n"); 
		query.append(",	@[dest_trns_svc_mod_cd]" ).append("\n"); 
		query.append(",	@[dest_trns_mod_cd]" ).append("\n"); 
		query.append(",	@[dest_sconti_cd]" ).append("\n"); 
		query.append(",	@[stop_off_loc_cd]" ).append("\n"); 
		query.append(",	@[stop_off_cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[stop_off_cntc_phn_no]" ).append("\n"); 
		query.append(",	@[stop_off_diff_rmk]" ).append("\n"); 
		query.append(",	@[sls_rhq_cd]" ).append("\n"); 
		query.append(",	@[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append(",	@[bkg_ofc_cd]" ).append("\n"); 
		query.append(",	@[doc_usr_id]" ).append("\n"); 
		query.append(",   @[pctl_no]" ).append("\n"); 
		query.append(",   @[aloc_sts_cd]" ).append("\n"); 
		query.append(",   @[aloc_svc_cd]" ).append("\n"); 
		query.append(",   @[bkg_aloc_tp_cd]" ).append("\n"); 
		query.append(",	@[fumg_loc_cd]" ).append("\n"); 
		query.append(",	@[fumg_cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[fumg_cntc_phn_no]" ).append("\n"); 
		query.append(",	@[fumg_diff_rmk]" ).append("\n"); 
		query.append(",	@[spcl_hide_lnr_flg]" ).append("\n"); 
		query.append(",	@[crr_soc_flg]" ).append("\n"); 
		query.append(",   @[non_rt_sts_cd]" ).append("\n"); 
		query.append(",	@[veh_cmdt_flg]" ).append("\n"); 
		query.append(",   @[ida_hlg_tp_cd]" ).append("\n"); 
		query.append(",   @[non_dg_chem_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}