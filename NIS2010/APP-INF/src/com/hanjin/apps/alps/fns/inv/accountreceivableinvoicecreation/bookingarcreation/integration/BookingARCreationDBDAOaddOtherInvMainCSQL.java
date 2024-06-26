/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingARCreationDBDAOaddOtherInvMainCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOaddOtherInvMainCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOaddOtherInvMainCSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOaddOtherInvMainCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_feu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_trns_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_decl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ar_offst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_tax_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_decl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_decl_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vvd_cxl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_xch_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("si_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slp_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hjs_stf_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_decl_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("whf_mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_decl_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_n3rd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_split_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_clr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_corr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_org_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obrd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trnk_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_delt_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clr_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_decl_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_usd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_corr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_src_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOaddOtherInvMainCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_MN" ).append("\n"); 
		query.append("(AR_IF_NO" ).append("\n"); 
		query.append(",BL_NO	" ).append("\n"); 
		query.append(",BL_TP_CD	" ).append("\n"); 
		query.append(",BL_SRC_NO	" ).append("\n"); 
		query.append(",INV_SRC_NO	" ).append("\n"); 
		query.append(",BKG_NO	 " ).append("\n"); 
		query.append(",BKG_CORR_NO	" ).append("\n"); 
		query.append(",BKG_CORR_DT	" ).append("\n"); 
		query.append(",VVD_TRNS_FLG	" ).append("\n"); 
		query.append(",ACT_CUST_CNT_CD -- 10	" ).append("\n"); 
		query.append(",ACT_CUST_SEQ	" ).append("\n"); 
		query.append(",AR_OFC_CD	" ).append("\n"); 
		query.append(",REV_TP_CD	" ).append("\n"); 
		query.append(",REV_SRC_CD	" ).append("\n"); 
		query.append(",VSL_CD	" ).append("\n"); 
		query.append(",SKD_VOY_NO	" ).append("\n"); 
		query.append(",SKD_DIR_CD	" ).append("\n"); 
		query.append(",LOCL_CURR_CD	" ).append("\n"); 
		query.append(",SVC_SCP_CD	" ).append("\n"); 
		query.append(",SAIL_DT -- 20	" ).append("\n"); 
		query.append(",SAIL_ARR_DT	" ).append("\n"); 
		query.append(",SLAN_CD	" ).append("\n"); 
		query.append(",IO_BND_CD	" ).append("\n"); 
		query.append(",TRNK_VSL_CD	" ).append("\n"); 
		query.append(",TRNK_SKD_VOY_NO	" ).append("\n"); 
		query.append(",TRNK_SKD_DIR_CD	" ).append("\n"); 
		query.append(",POR_CD	" ).append("\n"); 
		query.append(",POL_CD	" ).append("\n"); 
		query.append(",POD_CD	" ).append("\n"); 
		query.append(",DEL_CD	-- 30" ).append("\n"); 
		query.append(",CUST_CR_FLG	" ).append("\n"); 
		query.append(",INV_CUST_CNT_CD	" ).append("\n"); 
		query.append(",INV_CUST_SEQ	" ).append("\n"); 
		query.append(",FRT_FWRD_CNT_CD	" ).append("\n"); 
		query.append(",FRT_FWRD_CUST_SEQ	" ).append("\n"); 
		query.append(",CGO_WGT	" ).append("\n"); 
		query.append(",CGO_MEAS_QTY	" ).append("\n"); 
		query.append(",BKG_TEU_QTY	" ).append("\n"); 
		query.append(",BKG_FEU_QTY	" ).append("\n"); 
		query.append(",SC_NO -- 40" ).append("\n"); 
		query.append(",RFA_NO	" ).append("\n"); 
		query.append(",SREP_CD	" ).append("\n"); 
		query.append(",MST_BL_NO	" ).append("\n"); 
		query.append(",CXL_FLG	" ).append("\n"); 
		query.append(",DUE_DT	" ).append("\n"); 
		query.append(",BL_INV_IF_DT	" ).append("\n"); 
		query.append(",BL_INV_CFM_DT	" ).append("\n"); 
		query.append(",GL_EFF_DT	" ).append("\n"); 
		query.append(",INV_RMK	" ).append("\n"); 
		query.append(",INV_DELT_DIV_CD -- 50	" ).append("\n"); 
		query.append(",BKG_REF_NO	" ).append("\n"); 
		query.append(",INV_REF_NO	" ).append("\n"); 
		query.append(",SI_REF_NO	" ).append("\n"); 
		query.append(",HJS_STF_CTNT" ).append("\n"); 
		query.append(",INV_SPLIT_CD	" ).append("\n"); 
		query.append(",INV_VVD_CXL_CD	" ).append("\n"); 
		query.append(",DEST_TRNS_SVC_MOD_CD	" ).append("\n"); 
		query.append(",ACCT_XCH_RT_YRMON	" ).append("\n"); 
		query.append(",WHF_DECL_NO	" ).append("\n"); 
		query.append(",WHF_DECL_CFM_DT  -- 60	" ).append("\n"); 
		query.append(",WHF_DECL_VSL_CD	" ).append("\n"); 
		query.append(",WHF_DECL_VOY_NO	" ).append("\n"); 
		query.append(",WHF_DECL_DIR_CD	" ).append("\n"); 
		query.append(",WHF_DECL_OFC_CD" ).append("\n"); 
		query.append(",WHF_MRN_NO	" ).append("\n"); 
		query.append(",USD_XCH_RT	" ).append("\n"); 
		query.append(",XCH_RT_USD_TP_CD	" ).append("\n"); 
		query.append(",XCH_RT_N3RD_TP_CD	" ).append("\n"); 
		query.append(",XCH_RT_DT -- 70	" ).append("\n"); 
		query.append(",OBRD_DT	" ).append("\n"); 
		query.append(",INV_TTL_LOCL_AMT	" ).append("\n"); 
		query.append(",TRSP_RQST_ORD_FLG	" ).append("\n"); 
		query.append(",EDI_SND_DT	" ).append("\n"); 
		query.append(",REV_VSL_CD	" ).append("\n"); 
		query.append(",REV_SKD_VOY_NO	" ).append("\n"); 
		query.append(",REV_SKD_DIR_CD	" ).append("\n"); 
		query.append(",REV_DIR_CD	" ).append("\n"); 
		query.append(",RLANE_CD	" ).append("\n"); 
		query.append(",ZN_IOC_CD	-- 80" ).append("\n"); 
		query.append(",CR_TERM_DYS	" ).append("\n"); 
		query.append(",AR_TAX_IND_CD	" ).append("\n"); 
		query.append(",AR_CTY_CD	" ).append("\n"); 
		query.append(",SLS_OFC_CD	" ).append("\n"); 
		query.append(",INV_ORG_OFC_CD	" ).append("\n"); 
		query.append(",SLP_NO	" ).append("\n"); 
		query.append(",AP_AR_OFFST_NO	" ).append("\n"); 
		query.append(",CLR_STS_FLG	" ).append("\n"); 
		query.append(",CLR_DT	" ).append("\n"); 
		query.append(",ACCT_CD -- 90	" ).append("\n"); 
		query.append(",IF_SEQ	" ).append("\n"); 
		query.append(",TAX_XCH_RT	" ).append("\n"); 
		query.append(",INV_ISS_FLG " ).append("\n"); 
		query.append(",INV_CLR_FLG" ).append("\n"); 
		query.append(",INV_SVC_SCP_CD" ).append("\n"); 
		query.append(",CRE_USR_ID	" ).append("\n"); 
		query.append(",CRE_DT	" ).append("\n"); 
		query.append(",UPD_USR_ID	" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CR_INV_NO" ).append("\n"); 
		query.append(",IDA_STE_CD" ).append("\n"); 
		query.append(",IDA_PAN_NO" ).append("\n"); 
		query.append(",IDA_GST_RGST_NO" ).append("\n"); 
		query.append(",IDA_SPCL_ECN_ZN_UT_FLG)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(@[ar_if_no]" ).append("\n"); 
		query.append(",DECODE(@[bkg_no], NULL, NULL, @[bl_no])	" ).append("\n"); 
		query.append(",@[bl_tp_cd]	" ).append("\n"); 
		query.append(",@[bl_src_no]	" ).append("\n"); 
		query.append(",@[inv_src_no]	" ).append("\n"); 
		query.append(",@[bkg_no]	" ).append("\n"); 
		query.append(",@[bkg_corr_no]	" ).append("\n"); 
		query.append(",TO_DATE(@[bkg_corr_dt]	,'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",NVL(@[vvd_trns_flg],'N')	" ).append("\n"); 
		query.append(",@[act_cust_cnt_cd] -- 10	" ).append("\n"); 
		query.append(",@[act_cust_seq]	" ).append("\n"); 
		query.append(",@[ar_ofc_cd]" ).append("\n"); 
		query.append(",@[rev_tp_cd]	" ).append("\n"); 
		query.append(",@[rev_src_cd]	" ).append("\n"); 
		query.append(",@[vsl_cd]	" ).append("\n"); 
		query.append(",@[skd_voy_no]	" ).append("\n"); 
		query.append(",@[skd_dir_cd]	" ).append("\n"); 
		query.append(",@[locl_curr_cd]	" ).append("\n"); 
		query.append(",@[svc_scp_cd]	" ).append("\n"); 
		query.append(",@[sail_dt]	-- 20" ).append("\n"); 
		query.append(",REPLACE(@[sail_arr_dt], '-', '')" ).append("\n"); 
		query.append(",@[slan_cd]	" ).append("\n"); 
		query.append(",@[io_bnd_cd]	" ).append("\n"); 
		query.append(",@[trnk_vsl_cd]	" ).append("\n"); 
		query.append(",@[trnk_skd_voy_no]	" ).append("\n"); 
		query.append(",@[trnk_skd_dir_cd]	" ).append("\n"); 
		query.append(",@[por_cd]	" ).append("\n"); 
		query.append(",@[pol_cd]	" ).append("\n"); 
		query.append(",@[pod_cd]	" ).append("\n"); 
		query.append(",@[del_cd] -- 30" ).append("\n"); 
		query.append(",NVL(@[cust_cr_flg],'N')	" ).append("\n"); 
		query.append(",@[inv_cust_cnt_cd]	" ).append("\n"); 
		query.append(",@[inv_cust_seq]	" ).append("\n"); 
		query.append(",@[frt_fwrd_cnt_cd]	" ).append("\n"); 
		query.append(",@[frt_fwrd_cust_seq]	" ).append("\n"); 
		query.append(",NVL(@[cgo_wgt],0)		" ).append("\n"); 
		query.append(",NVL(@[cgo_meas_qty],0)		" ).append("\n"); 
		query.append(",NVL(@[bkg_teu_qty],0)		" ).append("\n"); 
		query.append(",NVL(@[bkg_feu_qty],0)		" ).append("\n"); 
		query.append(",@[sc_no] -- 40" ).append("\n"); 
		query.append(",@[rfa_no]	" ).append("\n"); 
		query.append(",@[srep_cd]	" ).append("\n"); 
		query.append(",@[mst_bl_no]	" ).append("\n"); 
		query.append(",NVL(@[cxl_flg]	,'N')	" ).append("\n"); 
		query.append(",REPLACE(@[due_dt], '-', '')" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ar_ofc_cd]),'YYYYMMDD')" ).append("\n"); 
		query.append(",@[bl_inv_cfm_dt]" ).append("\n"); 
		query.append(",@[gl_eff_dt]	" ).append("\n"); 
		query.append(",@[inv_rmk]	" ).append("\n"); 
		query.append(",@[inv_delt_div_cd] -- 50	" ).append("\n"); 
		query.append(",@[bkg_ref_no]	" ).append("\n"); 
		query.append(",@[inv_ref_no]	" ).append("\n"); 
		query.append(",@[si_ref_no]	" ).append("\n"); 
		query.append(",@[hjs_stf_ctnt]	" ).append("\n"); 
		query.append(",@[inv_split_cd]	" ).append("\n"); 
		query.append(",@[inv_vvd_cxl_cd]	" ).append("\n"); 
		query.append(",@[dest_trns_svc_mod_cd]	" ).append("\n"); 
		query.append(",@[acct_xch_rt_yrmon]	" ).append("\n"); 
		query.append(",@[whf_decl_no]	" ).append("\n"); 
		query.append(",@[whf_decl_cfm_dt] -- 60	" ).append("\n"); 
		query.append(",@[whf_decl_vsl_cd]	" ).append("\n"); 
		query.append(",@[whf_decl_voy_no]" ).append("\n"); 
		query.append(",@[whf_decl_dir_cd]	" ).append("\n"); 
		query.append(",@[whf_decl_ofc_cd]	" ).append("\n"); 
		query.append(",@[whf_mrn_no]	" ).append("\n"); 
		query.append(",NVL(@[usd_xch_rt],'0')	" ).append("\n"); 
		query.append(",@[xch_rt_usd_tp_cd]	" ).append("\n"); 
		query.append(",@[xch_rt_n3rd_tp_cd]	" ).append("\n"); 
		query.append(",@[xch_rt_dt] -- 70	" ).append("\n"); 
		query.append(",@[obrd_dt]	" ).append("\n"); 
		query.append(",NVL((SELECT SUM(INV_TTL_LOCL_AMT)" ).append("\n"); 
		query.append("        FROM (SELECT A.CURR_CD, ROUND(NVL(SUM(A.CHG_AMT)*A.INV_XCH_RT,0),B.DP_PRCS_KNT) INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("                FROM INV_AR_CHG A, MDM_CURRENCY B" ).append("\n"); 
		query.append("               WHERE A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("                 AND B.CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("               GROUP BY A.CURR_CD, A.INV_XCH_RT, B.DP_PRCS_KNT)),0)" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",TO_DATE(@[edi_snd_dt]	,'YYYY/MM/DD HH24:MI:SS')	" ).append("\n"); 
		query.append(",@[rev_vsl_cd]	" ).append("\n"); 
		query.append(",@[rev_skd_voy_no]	" ).append("\n"); 
		query.append(",@[rev_skd_dir_cd]	" ).append("\n"); 
		query.append(",@[rev_dir_cd]	" ).append("\n"); 
		query.append(",@[rlane_cd]	" ).append("\n"); 
		query.append(",@[zn_ioc_cd] -- 80	" ).append("\n"); 
		query.append(",NVL(@[cr_term_dys],0) 	" ).append("\n"); 
		query.append(",@[ar_tax_ind_cd]	" ).append("\n"); 
		query.append(",@[ar_cty_cd]	" ).append("\n"); 
		query.append(",@[sls_ofc_cd]	" ).append("\n"); 
		query.append(",@[inv_org_ofc_cd]	" ).append("\n"); 
		query.append(",@[slp_no]	" ).append("\n"); 
		query.append(",@[ap_ar_offst_no]	" ).append("\n"); 
		query.append(",NVL(@[clr_sts_flg],'N')	" ).append("\n"); 
		query.append(",@[clr_dt]	" ).append("\n"); 
		query.append(",@[acct_cd]	 -- 90" ).append("\n"); 
		query.append(",DECODE(@[bl_inv_cfm_dt],'','',(SELECT NVL((SELECT MAX(IF_SEQ) FROM INV_AR_MN WHERE BL_SRC_NO = @[bl_src_no]), 0) + 1 FROM DUAL))" ).append("\n"); 
		query.append(",NVL(@[tax_xch_rt],0)" ).append("\n"); 
		query.append(",NVL(@[inv_iss_flg],'N')" ).append("\n"); 
		query.append(",NVL(@[inv_clr_flg],'N')" ).append("\n"); 
		query.append(",@[inv_svc_scp_cd]" ).append("\n"); 
		query.append(",@[cre_usr_id]	" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]	" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cr_inv_no]" ).append("\n"); 
		query.append(",(DECODE(@[ar_ofc_cd], 'BOMSC', (SELECT C.IDA_STE_CD " ).append("\n"); 
		query.append("                                 FROM MDM_CUSTOMER A," ).append("\n"); 
		query.append("                                      MDM_LOCATION B," ).append("\n"); 
		query.append("                                      MDM_STATE C" ).append("\n"); 
		query.append("                                 WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("                                 AND B.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("                                 AND B.STE_CD = C.STE_CD" ).append("\n"); 
		query.append("                                 AND A.CUST_CNT_CD = @[act_cust_cnt_cd] " ).append("\n"); 
		query.append("                                 AND A.CUST_SEQ = @[act_cust_seq]), ''))" ).append("\n"); 
		query.append(",(DECODE(@[ar_ofc_cd], 'BOMSC', (SELECT IDA_PAN_NO FROM MDM_CUSTOMER WHERE CUST_CNT_CD = @[act_cust_cnt_cd] AND CUST_SEQ = @[act_cust_seq]), ''))" ).append("\n"); 
		query.append(",(DECODE(@[ar_ofc_cd], 'BOMSC', (SELECT IDA_GST_RGST_NO FROM MDM_CUSTOMER WHERE CUST_CNT_CD = @[act_cust_cnt_cd] AND CUST_SEQ = @[act_cust_seq]), ''))" ).append("\n"); 
		query.append(",(DECODE(@[ar_ofc_cd], 'BOMSC', (SELECT IDA_SPCL_ECN_ZN_UT_FLG FROM MDM_CUSTOMER WHERE CUST_CNT_CD = @[act_cust_cnt_cd] AND CUST_SEQ = @[act_cust_seq]), ''))" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}