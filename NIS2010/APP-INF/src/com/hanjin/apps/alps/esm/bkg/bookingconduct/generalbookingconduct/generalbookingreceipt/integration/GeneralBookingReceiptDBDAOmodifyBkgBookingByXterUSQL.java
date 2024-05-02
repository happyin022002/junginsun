/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyBkgBookingByXterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.27
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.08.27 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyBkgBookingByXterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBkgBookingByXter
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyBkgBookingByXterUSQL(){
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
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("last_pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_no1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sam_cnee_ntfy_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("first_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("last_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("last_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inter_rmk_aud_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_trns_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("first_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("si_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stop_off_diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("blck_stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("first_pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyBkgBookingByXterUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BOOKING SET " ).append("\n"); 
		query.append("	BL_NO    = @[bl_no]" ).append("\n"); 
		query.append(",	BL_TP_CD = @[bl_tp_cd]" ).append("\n"); 
		query.append(",	BKG_CGO_TP_CD = NVL(@[bkg_cgo_tp_cd],BKG_CGO_TP_CD)" ).append("\n"); 
		query.append(",	SLAN_CD = (" ).append("\n"); 
		query.append("				SELECT 	VSL_SLAN_CD " ).append("\n"); 
		query.append("				FROM 	VSK_VSL_SKD" ).append("\n"); 
		query.append("	 		   	WHERE 	VSL_CD = SUBSTR(@[bkg_trunk_vvd], 1, 4) " ).append("\n"); 
		query.append("				AND 	SKD_VOY_NO = SUBSTR(@[bkg_trunk_vvd], 5, 4) " ).append("\n"); 
		query.append("               	AND 	SKD_DIR_CD = SUBSTR(@[bkg_trunk_vvd], 9, 1) " ).append("\n"); 
		query.append("				AND 	ROWNUM = 1" ).append("\n"); 
		query.append("			  )" ).append("\n"); 
		query.append(",	SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append(",	VSL_CD      = SUBSTR(@[bkg_trunk_vvd], 1, 4)" ).append("\n"); 
		query.append(",	SKD_VOY_NO  = SUBSTR(@[bkg_trunk_vvd], 5, 4)" ).append("\n"); 
		query.append(",	SKD_DIR_CD  = SUBSTR(@[bkg_trunk_vvd], 9, 1)" ).append("\n"); 
		query.append(",	REV_DIR_CD  = @[rev_dir_cd]" ).append("\n"); 
		query.append(",	RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append(",	DE_TERM_CD  = @[de_term_cd]" ).append("\n"); 
		query.append(",	POR_CD      = @[bkg_por_cd]" ).append("\n"); 
		query.append(",	POR_NOD_CD  = @[bkg_por_yd_cd]" ).append("\n"); 
		query.append(",	POL_CD      = @[bkg_pol_cd]" ).append("\n"); 
		query.append(",	POL_NOD_CD  = @[bkg_pol_yd_cd]" ).append("\n"); 
		query.append(",	POD_CD      = @[bkg_pod_cd]" ).append("\n"); 
		query.append(",	POD_NOD_CD  = @[bkg_pod_yd_cd]" ).append("\n"); 
		query.append(",	OCP_CD      = @[ocp_cd]" ).append("\n"); 
		query.append(",	DEL_CD      = @[bkg_del_cd]" ).append("\n"); 
		query.append(",	DEL_NOD_CD  = @[bkg_yd_cd]" ).append("\n"); 
		query.append(",	POL_ETD_DT  = (" ).append("\n"); 
		query.append("					SELECT VPS_ETD_DT FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("					WHERE  VSL_CD = SUBSTR(@[first_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("			 	    AND	   SKD_VOY_NO = SUBSTR(@[first_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("			        AND	   SKD_DIR_CD = SUBSTR(@[first_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("					AND    CLPT_IND_SEQ = @[first_pol_clpt_ind_seq]" ).append("\n"); 
		query.append("			        AND	   VPS_PORT_CD = @[first_pol_cd]	" ).append("\n"); 
		query.append("					AND    ROWNUM = 1" ).append("\n"); 
		query.append("			 	 )" ).append("\n"); 
		query.append(",	POD_ETA_DT  = (" ).append("\n"); 
		query.append("					SELECT VPS_ETA_DT FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("					WHERE  VSL_CD = SUBSTR(@[last_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("			 	    AND	   SKD_VOY_NO = SUBSTR(@[last_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("			        AND	   SKD_DIR_CD = SUBSTR(@[last_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("					AND    CLPT_IND_SEQ = @[last_pod_clpt_ind_seq]" ).append("\n"); 
		query.append("			        AND	   VPS_PORT_CD = @[last_pod_cd]	" ).append("\n"); 
		query.append("                    AND    ROWNUM = 1" ).append("\n"); 
		query.append("				 )" ).append("\n"); 
		query.append(",	MTY_PKUP_YD_CD = @[mty_pkup_yd_cd]" ).append("\n"); 
		query.append(",	MTY_PKUP_DT    = TO_DATE(@[mty_pkup_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	FULL_RTN_YD_CD = @[full_rtn_yd_cd]" ).append("\n"); 
		query.append(",	MTY_DOR_ARR_DT = TO_DATE(@[mty_dor_arr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	LODG_DUE_DT    = TO_DATE(@[lodg_due_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	DE_DUE_DT      = TO_DATE(@[de_due_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	ORG_TRNS_SVC_MOD_CD  = @[org_trns_svc_mod_cd]" ).append("\n"); 
		query.append(",	ORG_TRNS_MOD_CD      = @[org_trns_mod_cd]" ).append("\n"); 
		query.append(",	ORG_SCONTI_CD        = @[org_sconti_cd]" ).append("\n"); 
		query.append(",	DEST_TRNS_SVC_MOD_CD = @[dest_trns_svc_mod_cd]" ).append("\n"); 
		query.append(",	DEST_TRNS_MOD_CD     = @[dest_trns_mod_cd]" ).append("\n"); 
		query.append(",	DEST_SCONTI_CD       = @[dest_sconti_cd]" ).append("\n"); 
		query.append(",	STOP_OFF_LOC_CD      = @[stop_off_loc_cd]" ).append("\n"); 
		query.append(",	STOP_OFF_CNTC_PSON_NM= @[stop_off_cntc_pson_nm]" ).append("\n"); 
		query.append(",	STOP_OFF_CNTC_PHN_NO = @[stop_off_cntc_phn_no]" ).append("\n"); 
		query.append(",	STOP_OFF_DIFF_RMK    = @[stop_off_diff_rmk]" ).append("\n"); 
		query.append(",	BKG_OFC_CD    = @[bkg_ofc_cd]" ).append("\n"); 
		query.append(",	CTRT_OFC_CD   = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append(",	CTRT_SREP_CD  = @[ctrt_srep_cd]" ).append("\n"); 
		query.append(",	OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append(",	OB_SREP_CD    = @[ob_srep_cd]" ).append("\n"); 
		query.append(",	IB_SLS_OFC_CD = @[ib_sls_ofc_cd]" ).append("\n"); 
		query.append(",	CMDT_CD       = @[cmdt_cd]" ).append("\n"); 
		query.append(",	REP_CMDT_CD   = @[rep_cmdt_cd]" ).append("\n"); 
		query.append(",	DCGO_FLG      = NVL(@[dcgo_flg],'N')" ).append("\n"); 
		query.append(",	RC_FLG        = NVL(@[rc_flg],'N')" ).append("\n"); 
		query.append(",	AWK_CGO_FLG   = NVL(@[awk_cgo_flg],'N')" ).append("\n"); 
		query.append(",	BB_CGO_FLG    = NVL(@[bb_cgo_flg],'N')" ).append("\n"); 
		query.append(",	RD_CGO_FLG    = NVL(@[rd_cgo_flg],'N')" ).append("\n"); 
		query.append(",	HNGR_FLG      = NVL(@[hngr_flg],'N')" ).append("\n"); 
		query.append(",	RAIL_BLK_CD   = @[rail_blk_cd]" ).append("\n"); 
		query.append(",	PRCT_FLG      = NVL(@[prct_flg],'N')" ).append("\n"); 
		query.append(",	SPCL_HIDE_FLG = NVL(@[spcl_hide_flg],'N')" ).append("\n"); 
		query.append(",	SOC_FLG       = NVL(@[soc_flg],'N')" ).append("\n"); 
		query.append(",	EQ_SUBST_FLG  = NVL(@[eq_subst_flg],'N')" ).append("\n"); 
		query.append(",	FD_GRD_FLG    = NVL(@[fd_grd_flg],'N')" ).append("\n"); 
		query.append(",	FLEX_HGT_FLG  = NVL(@[flex_hgt_flg],'N')" ).append("\n"); 
		query.append(",	STWG_CD       = @[stwg_cd]" ).append("\n"); 
		query.append(",	STWG_RMK      = @[stwg_rmk]" ).append("\n"); 
		query.append(",	BLCK_STWG_CD  = @[blck_stwg_cd]" ).append("\n"); 
		query.append(",	ALL_MTR_FLG   = NVL(@[all_mtr_flg],'N')" ).append("\n"); 
		query.append(",	DBL_BKG_FLG   = NVL(@[dbl_bkg_flg],'N')" ).append("\n"); 
		query.append(",	AP_BROG_FLG   = NVL(@[ap_brog_flg],'N')" ).append("\n"); 
		query.append(",	CUST_TO_ORD_FLG     = NVL(@[cust_to_ord_flg],'N')" ).append("\n"); 
		query.append(",	SAM_CNEE_NTFY_FLG   = NVL(@[sam_cnee_ntfy_flg],'N')" ).append("\n"); 
		query.append(",	ALT_CUST_CFM_FLG    = NVL(@[alt_cust_cfm_flg],'N')" ).append("\n"); 
		query.append(",	WT_RSN_SPCL_CGO_FLG = NVL(@[wt_rsn_spcl_cgo_flg],'N')" ).append("\n"); 
		query.append(",	WT_RSN_HLD_FLG    = NVL(@[wt_rsn_hld_flg],'N')" ).append("\n"); 
		query.append(",	SHP_BAK_FLG       = NVL(@[shp_bak_flg],'N')" ).append("\n"); 
		query.append(",	MNL_BKG_NO_FLG    = NVL(@[mnl_bkg_no_flg],'N')" ).append("\n"); 
		query.append(",	BL_ISS_BLCK_FLG   = NVL(@[bl_iss_blck_flg],'N')" ).append("\n"); 
		query.append(",	SCAC_CD           = @[scac_cd]" ).append("\n"); 
		query.append(",	USA_CSTMS_FILE_CD = @[usa_cstms_file_cd]" ).append("\n"); 
		query.append(",	CND_CSTMS_FILE_CD = @[cnd_cstms_file_cd]" ).append("\n"); 
		query.append(",	INTER_RMK         = @[inter_rmk]" ).append("\n"); 
		query.append(",	XTER_RMK          = @[xter_rmk]" ).append("\n"); 
		query.append(",	INTER_RMK_AUD_FLG = NVL(@[inter_rmk_aud_flg],'N')" ).append("\n"); 
		query.append(",	SC_NO  = @[sc_no1] ||@[sc_no2]" ).append("\n"); 
		query.append(",	RFA_NO = @[rfa_no1]||@[rfa_no2]" ).append("\n"); 
		query.append(",	XTER_BKG_RQST_CD = NVL(XTER_BKG_RQST_CD, @[xter_bkg_rqst_cd])" ).append("\n"); 
		query.append(",	SI_FLG           = NVL(@[si_flg],'N')" ).append("\n"); 
		query.append(",	PRE_RLY_PORT_CD  = @[pre_rly_port_cd]" ).append("\n"); 
		query.append(",	PST_RLY_PORT_CD  = @[pst_rly_port_cd]" ).append("\n"); 
		query.append(",	UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}