/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOAddBkgBookingCSQL.java
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

public class GeneralBookingReceiptDBDAOAddBkgBookingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking정보 저장 
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOAddBkgBookingCSQL(){
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
		params.put("stwg_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sam_cnee_ntfy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fumg_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cust_apro_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scac_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnd_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cust_apro_cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_subst_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_trunk_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_skp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fd_grd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnl_bkg_no_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_cust_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ocp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("my_fwrd_vsl_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_por_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hcmt_cmb_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOAddBkgBookingCSQL").append("\n"); 
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
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	BL_NO_TP" ).append("\n"); 
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
		query.append(",	OB_SLS_OFC_CD" ).append("\n"); 
		query.append(",	OB_SREP_CD" ).append("\n"); 
		query.append(",	IB_SLS_OFC_CD" ).append("\n"); 
		query.append(",	EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(",	BKG_CRE_DT" ).append("\n"); 
		query.append(", 	BKG_CRE_GDT" ).append("\n"); 
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
		query.append(",	SPLIT_RTO" ).append("\n"); 
		query.append(",	SC_NO" ).append("\n"); 
		query.append(",	RFA_NO" ).append("\n"); 
		query.append(",	TAA_NO" ).append("\n"); 
		query.append(",	AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append(",	AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append(",	MTY_CRE_SVR_CD" ).append("\n"); 
		query.append(",	MTY_BKG_STS_CD" ).append("\n"); 
		query.append(",	MTY_SPLIT_AVAL_CD" ).append("\n"); 
		query.append(",	XTER_BKG_RQST_CD" ).append("\n"); 
		query.append(",	XTER_BKG_RQST_REF_NO" ).append("\n"); 
		query.append(",	SI_FLG" ).append("\n"); 
		query.append(",	XTER_SI_CD" ).append("\n"); 
		query.append(",	XTER_SI_REF_NO" ).append("\n"); 
		query.append(",	XTER_RQST_AUTO_NTC_FLG" ).append("\n"); 
		query.append(",	XTER_BKG_KNT" ).append("\n"); 
		query.append(",	XTER_SI_KNT" ).append("\n"); 
		query.append(",	XTER_RQST_CUST_RMK" ).append("\n"); 
		query.append(",	OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append(",	MY_FWRD_CD" ).append("\n"); 
		query.append(",	MY_FWRD_VSL_DESC" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	PCTL_NO" ).append("\n"); 
		query.append(",   EDI_HLD_FLG" ).append("\n"); 
		query.append(",	PORT_SKP_FLG" ).append("\n"); 
		query.append(",	FUMG_LOC_CD" ).append("\n"); 
		query.append(",	FUMG_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	FUMG_CNTC_PHN_NO" ).append("\n"); 
		query.append(",	FUMG_DIFF_RMK" ).append("\n"); 
		query.append(",	SPCL_HIDE_LNR_FLG" ).append("\n"); 
		query.append(",	CRR_SOC_FLG" ).append("\n"); 
		query.append(",	VEH_CMDT_FLG" ).append("\n"); 
		query.append(",	NEW_CUST_APRO_FLG" ).append("\n"); 
		query.append(",   NEW_CUST_APRO_CMDT_NM" ).append("\n"); 
		query.append(",	NEW_CUST_APRO_RMK" ).append("\n"); 
		query.append(",   IDA_HLG_TP_CD" ).append("\n"); 
		query.append(",   NON_DG_CHEM_FLG" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append(",	@[bl_no]" ).append("\n"); 
		query.append(",	'0'" ).append("\n"); 
		query.append(",	DECODE(NVL(@[dcgo_flg]||@[rc_flg]||@[awk_cgo_flg]||@[bb_cgo_flg], 'N'), 'N', 'F', 'W')" ).append("\n"); 
		query.append(",	NVL(@[bkg_cgo_tp_cd],'F')" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	@[svc_scp_cd]" ).append("\n"); 
		query.append(",	SUBSTR(@[bkg_trunk_vvd], 1, 4)" ).append("\n"); 
		query.append(",	SUBSTR(@[bkg_trunk_vvd], 5, 4)" ).append("\n"); 
		query.append(",	SUBSTR(@[bkg_trunk_vvd], 9, 1)" ).append("\n"); 
		query.append(",	@[rev_dir_cd]" ).append("\n"); 
		query.append(",	@[rcv_term_cd]" ).append("\n"); 
		query.append(",	@[de_term_cd]" ).append("\n"); 
		query.append(",	@[bkg_por_cd]" ).append("\n"); 
		query.append(",	DECODE(LENGTH(@[bkg_por_yd_cd]), 2, @[bkg_por_cd]||@[bkg_por_yd_cd], @[bkg_por_yd_cd])" ).append("\n"); 
		query.append(",	@[bkg_pol_cd]" ).append("\n"); 
		query.append(",	DECODE(LENGTH(@[bkg_pol_yd_cd]), 2, @[bkg_pol_cd]||@[bkg_pol_yd_cd], @[bkg_pol_yd_cd])" ).append("\n"); 
		query.append(",	@[bkg_pod_cd]" ).append("\n"); 
		query.append(",	DECODE(LENGTH(@[bkg_pod_yd_cd]), 2, @[bkg_pod_cd]||@[bkg_pod_yd_cd], @[bkg_pod_yd_cd])" ).append("\n"); 
		query.append(",	@[ocp_cd]" ).append("\n"); 
		query.append(",	@[bkg_del_cd]" ).append("\n"); 
		query.append(",	DECODE(LENGTH(@[bkg_del_yd_cd]), 2, @[bkg_del_cd]||@[bkg_del_yd_cd], @[bkg_del_yd_cd])" ).append("\n"); 
		query.append(",	@[fnl_dest_cd]" ).append("\n"); 
		query.append(",   null" ).append("\n"); 
		query.append(",   null" ).append("\n"); 
		query.append(",	@[mty_pkup_yd_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[mty_pkup_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[full_rtn_yd_cd]" ).append("\n"); 
		query.append(",	@[full_pkup_yd_cd]" ).append("\n"); 
		query.append(",	@[mty_rtn_yd_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[mty_dor_arr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	TO_DATE(@[lodg_due_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	TO_DATE(@[de_due_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	TO_DATE(@[ib_del_de_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[org_trns_svc_mod_cd]" ).append("\n"); 
		query.append(",	@[org_trns_mod_cd]" ).append("\n"); 
		query.append(",	(SELECT SCONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[bkg_por_cd])" ).append("\n"); 
		query.append(",	@[dest_trns_svc_mod_cd]" ).append("\n"); 
		query.append(",	@[dest_trns_mod_cd]" ).append("\n"); 
		query.append(",	(SELECT SCONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[bkg_del_cd])" ).append("\n"); 
		query.append(",	@[stop_off_loc_cd]" ).append("\n"); 
		query.append(",	@[stop_off_cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[stop_off_cntc_phn_no]" ).append("\n"); 
		query.append(",	@[stop_off_diff_rmk]" ).append("\n"); 
		query.append(",	@[sls_rhq_cd]" ).append("\n"); 
		query.append(",	@[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append(",	@[bkg_ofc_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	(SELECT OFC_CD FROM MDM_SLS_REP WHERE SREP_CD = UPPER(@[ob_srep_cd]))" ).append("\n"); 
		query.append(",	UPPER(@[ob_srep_cd])" ).append("\n"); 
		query.append(",	(SELECT FINC_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = @[bkg_del_cd])" ).append("\n"); 
		query.append(",	(SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = DECODE(LENGTH(@[mty_pkup_yd_cd]),5,@[mty_pkup_yd_cd],@[bkg_por_cd]) AND DELT_FLG = 'N')" ).append("\n"); 
		query.append(",	GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,NVL(BKG_COM_USER_LOC_FNC(@[cre_usr_id]),@[bkg_por_cd]))" ).append("\n"); 
		query.append(",	GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,'GMT')" ).append("\n"); 
		query.append(",	null" ).append("\n"); 
		query.append(",	@[cmdt_cd]" ).append("\n"); 
		query.append(",	(select rep_cmdt_cd from mdm_commodity where cmdt_cd = @[cmdt_cd])" ).append("\n"); 
		query.append(",	NVL(@[dcgo_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[rc_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[awk_cgo_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[bb_cgo_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[rd_cgo_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[hngr_flg],'N')" ).append("\n"); 
		query.append(",	@[rail_blk_cd]" ).append("\n"); 
		query.append(",	NVL(@[prct_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[spcl_hide_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[soc_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[eq_subst_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[fd_grd_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[flex_hgt_flg],'N')" ).append("\n"); 
		query.append(",	@[stwg_cd]" ).append("\n"); 
		query.append(",	@[stwg_rmk]" ).append("\n"); 
		query.append(",	@[blck_stwg_cd]" ).append("\n"); 
		query.append(",	NVL(@[all_mtr_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[dbl_bkg_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[ap_brog_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[cust_to_ord_flg],'N')" ).append("\n"); 
		query.append(",	NVL((SELECT 'C'" ).append("\n"); 
		query.append("            FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("            WHERE HRD_CDG_ID = 'KR_PANTOS_CUSTOMER'" ).append("\n"); 
		query.append("            AND ATTR_CTNT1 = @[s_cust_cnt_cd]" ).append("\n"); 
		query.append("            AND ATTR_CTNT2 = @[s_cust_seq]), " ).append("\n"); 
		query.append("		(SELECT DECODE(RVIS_CNTR_CUST_TP_CD, 'B', 'S', 'C') " ).append("\n"); 
		query.append("		  	  FROM MDM_CUSTOMER" ).append("\n"); 
		query.append(" 		 	  WHERE CUST_CNT_CD = @[s_cust_cnt_cd]" ).append("\n"); 
		query.append("		    	AND CUST_SEQ = @[s_cust_seq]))" ).append("\n"); 
		query.append(",	NVL(@[sam_cnee_ntfy_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[alt_cust_cfm_flg],'N')" ).append("\n"); 
		query.append(",	DECODE(NVL(@[dcgo_flg]||@[rc_flg]||@[awk_cgo_flg]||@[bb_cgo_flg], 'N'), 'N', 'N', 'Y')" ).append("\n"); 
		query.append(",	NVL(@[wt_rsn_hld_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[shp_bak_flg],'N')" ).append("\n"); 
		query.append(",	case when length(@[bkg_no]) <> 12 and 'Y' = (select 'Y' from bkg_chn_agn        where chn_agn_cd = substr(@[bkg_no], 5, 2) and rownum = 1) " ).append("\n"); 
		query.append("			then 'Y'" ).append("\n"); 
		query.append("         when length(@[bkg_no]) =  12 and 'Y' = (select 'Y' from bkg_chn_bkg_no_gen where chn_agn_cd = substr(@[bkg_no], 3, 2) and rownum = 1) " ).append("\n"); 
		query.append("			then 'Y'" ).append("\n"); 
		query.append("		 else NVL(@[mnl_bkg_no_flg],'N') end" ).append("\n"); 
		query.append(",	NVL(@[bl_iss_blck_flg],'N')" ).append("\n"); 
		query.append(",	null" ).append("\n"); 
		query.append(",	@[scac_cd]" ).append("\n"); 
		query.append(",	case when length(@[bkg_no]) <> 12 and 'Y' = (select 'Y' from bkg_chn_agn        where chn_agn_cd = substr(@[bkg_no], 5, 2) and rownum = 1) " ).append("\n"); 
		query.append("			then substr(@[bkg_no], 5, 2)" ).append("\n"); 
		query.append("         when length(@[bkg_no]) =  12 and 'Y' = (select 'Y' from bkg_chn_bkg_no_gen where chn_agn_cd = substr(@[bkg_no], 3, 2) and rownum = 1) " ).append("\n"); 
		query.append("			then substr(@[bkg_no], 3, 2)" ).append("\n"); 
		query.append("		 else null end" ).append("\n"); 
		query.append(",	@[usa_cstms_file_cd]" ).append("\n"); 
		query.append(",	@[cnd_cstms_file_cd]" ).append("\n"); 
		query.append(",	@[twn_so_no]" ).append("\n"); 
		query.append(",	@[inter_rmk]" ).append("\n"); 
		query.append(",	@[xter_rmk]" ).append("\n"); 
		query.append(",	NVL(@[inter_rmk_aud_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[split_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[hcmt_cmb_flg],'N')" ).append("\n"); 
		query.append(",	'B'" ).append("\n"); 
		query.append(",	1" ).append("\n"); 
		query.append(",	@[sc_no]" ).append("\n"); 
		query.append(",	@[rfa_no]" ).append("\n"); 
		query.append(",	@[taa_no]" ).append("\n"); 
		query.append(",	@[agmt_act_cnt_cd]" ).append("\n"); 
		query.append(",	@[agmt_act_cust_seq]" ).append("\n"); 
		query.append(",	@[mty_cre_svr_cd]" ).append("\n"); 
		query.append(",	@[mty_bkg_sts_cd]" ).append("\n"); 
		query.append(",	@[mty_split_aval_cd]" ).append("\n"); 
		query.append(",	DECODE(NVL(@[xter_bkg_rqst_cd], 'NIS'), 'OFF', 'NIS', NVL(@[xter_bkg_rqst_cd], 'NIS'))" ).append("\n"); 
		query.append(",	@[xter_bkg_rqst_ref_no]" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	null" ).append("\n"); 
		query.append(",	@[xter_si_ref_no]" ).append("\n"); 
		query.append(",	NVL(@[xter_rqst_auto_ntc_flg],'N')" ).append("\n"); 
		query.append(",	@[xter_bkg_knt]" ).append("\n"); 
		query.append(",	@[xter_si_knt]" ).append("\n"); 
		query.append(",	@[xter_rqst_cust_rmk]" ).append("\n"); 
		query.append(",	NVL(@[ovr_void_slt_qty],0)" ).append("\n"); 
		query.append(",	@[my_fwrd_cd]" ).append("\n"); 
		query.append(",	@[my_fwrd_vsl_desc]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[pctl_no]" ).append("\n"); 
		query.append(",	NVL(@[edi_hld_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[port_skp_flg],'N')" ).append("\n"); 
		query.append(",	@[fumg_loc_cd]" ).append("\n"); 
		query.append(",	@[fumg_cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[fumg_cntc_phn_no]" ).append("\n"); 
		query.append(",	@[fumg_diff_rmk]" ).append("\n"); 
		query.append(",	NVL(@[spcl_hide_lnr_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[crr_soc_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[veh_cmdt_flg],'N')" ).append("\n"); 
		query.append(",   NVL(@[new_cust_apro_flg],'N')" ).append("\n"); 
		query.append(",   @[new_cust_apro_cmdt_nm]" ).append("\n"); 
		query.append(",   @[new_cust_apro_rmk] " ).append("\n"); 
		query.append(",   @[ida_hlg_tp_cd]" ).append("\n"); 
		query.append(",   NVL(@[non_dg_chem_flg],'N')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}