/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionMtdItemListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.12
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.06.12 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionMtdItemListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreRestrictionMtdItemListSqlName
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionMtdItemListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_n2nd_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_lmt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rada_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rada_trsp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_tnk_rstr_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_spcl_provi_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbm_per_hr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwrd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_lcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_lmt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_in_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_polut_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_n1st_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_expt_qty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_n2nd_imdg_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ltd_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_n1st_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reefer_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n2nd_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_lmt_qty_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_co_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n4th_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("certi_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_temp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkwd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n1st_imdg_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n2nd_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_n2nd_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n1st_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ems_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hgt_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_n1st_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lf_sd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("b_b_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_dtl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_sd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dim_wdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_comp_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_n2nd_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rada_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n2nd_imdg_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_n2nd_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_pck_rstr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_n1st_imdg_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flsh_pnt_cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_explo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n1st_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hzd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_stwg_rqst_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_rspn_gid_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n2nd_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_temp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_in_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("void_slt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_n1st_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vltg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_intmd_bc_rstr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_n2nd_imdg_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_n1st_imdg_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rada_skd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_rspn_gid_chr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vent_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_expt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_capa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dim_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionMtdItemListRSQL").append("\n"); 
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
		query.append("WITH IN_CGO_LIST_TBL AS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" @[n3rd_imdg_subs_rsk_lbl_cd]   AS N3RD_IMDG_SUBS_RSK_LBL_CD   " ).append("\n"); 
		query.append(",@[spcl_cgo_rqst_seq]           AS SPCL_CGO_RQST_SEQ           " ).append("\n"); 
		query.append(",@[imdg_un_no_seq]              AS IMDG_UN_NO_SEQ              " ).append("\n"); 
		query.append(",@[imdg_subs_rsk_lbl_rmk]       AS IMDG_SUBS_RSK_LBL_RMK       " ).append("\n"); 
		query.append(",@[rada_skd_no]                 AS RADA_SKD_NO                 " ).append("\n"); 
		query.append(",@[n4th_imdg_subs_rsk_lbl_cd]   AS N4TH_IMDG_SUBS_RSK_LBL_CD   " ).append("\n"); 
		query.append(",@[imdg_comp_grp_cd]            AS IMDG_COMP_GRP_CD            " ).append("\n"); 
		query.append(",@[cntr_tpsz_cd]                AS CNTR_TPSZ_CD                " ).append("\n"); 
		query.append(",@[imdg_un_no]                  AS IMDG_UN_NO                  " ).append("\n"); 
		query.append(",@[upd_usr_id]                  AS UPD_USR_ID                  " ).append("\n"); 
		query.append(",@[hcdg_flg]                    AS HCDG_FLG                    " ).append("\n"); 
		query.append(",@[auth_ofc_cd]                 AS AUTH_OFC_CD                 " ).append("\n"); 
		query.append(",@[hcdg_intmd_bc_rstr_desc]     AS HCDG_INTMD_BC_RSTR_DESC     " ).append("\n"); 
		query.append(",@[spcl_cgo_cate_cd]            AS SPCL_CGO_CATE_CD            " ).append("\n"); 
		query.append(",@[reefer_flag]                 AS REEFER_FLAG                 " ).append("\n"); 
		query.append(",@[skd_voy_no]                  AS SKD_VOY_NO                  " ).append("\n"); 
		query.append(",@[void_slt_qty]                AS VOID_SLT_QTY                " ).append("\n"); 
		query.append(",@[pod_cd]                      AS POD_CD                      " ).append("\n"); 
		query.append(",@[hgt_ovr_dim_len]             AS HGT_OVR_DIM_LEN             " ).append("\n"); 
		query.append(",@[intmd_n2nd_imdg_pck_desc]    AS INTMD_N2ND_IMDG_PCK_DESC    " ).append("\n"); 
		query.append(",@[rada_amt]                    AS RADA_AMT                    " ).append("\n"); 
		query.append(",@[net_explo_wgt]               AS NET_EXPLO_WGT               " ).append("\n"); 
		query.append(",@[cmdt_desc]                   AS CMDT_DESC                   " ).append("\n"); 
		query.append(",@[awk_flg]                     AS AWK_FLG                     " ).append("\n"); 
		query.append(",@[emer_rspn_gid_no]            AS EMER_RSPN_GID_NO            " ).append("\n"); 
		query.append(",@[cbm_per_hr_qty]              AS CBM_PER_HR_QTY              " ).append("\n"); 
		query.append(",@[auth_usr_id]                 AS AUTH_USR_ID                 " ).append("\n"); 
		query.append(",@[cnee_dtl_desc]               AS CNEE_DTL_DESC               " ).append("\n"); 
		query.append(",@[imdg_clss_cd]                AS IMDG_CLSS_CD                " ).append("\n"); 
		query.append(",@[emer_cntc_phn_no]            AS EMER_CNTC_PHN_NO            " ).append("\n"); 
		query.append(",@[imdg_pck_grp_cd]             AS IMDG_PCK_GRP_CD             " ).append("\n"); 
		query.append(",@[meas_tp_cd]                  AS MEAS_TP_CD                  " ).append("\n"); 
		query.append(",@[flsh_pnt_cdo_temp]           AS FLSH_PNT_CDO_TEMP           " ).append("\n"); 
		query.append(",@[imdg_lmt_qty_meas_ut_cd]     AS IMDG_LMT_QTY_MEAS_UT_CD     " ).append("\n"); 
		query.append(",@[intmd_n2nd_imdg_pck_qty]     AS INTMD_N2ND_IMDG_PCK_QTY     " ).append("\n"); 
		query.append(",@[intmd_n1st_imdg_pck_qty]     AS INTMD_N1ST_IMDG_PCK_QTY     " ).append("\n"); 
		query.append(",@[n1st_imdg_subs_rsk_lbl_cd]   AS N1ST_IMDG_SUBS_RSK_LBL_CD   " ).append("\n"); 
		query.append(",@[imdg_lmt_qty]                AS IMDG_LMT_QTY                " ).append("\n"); 
		query.append(",@[in_n1st_imdg_pck_cd]         AS IN_N1ST_IMDG_PCK_CD         " ).append("\n"); 
		query.append(",@[out_n2nd_imdg_pck_qty]       AS OUT_N2ND_IMDG_PCK_QTY       " ).append("\n"); 
		query.append(",@[ems_no]                      AS EMS_NO                      " ).append("\n"); 
		query.append(",@[max_in_pck_qty]              AS MAX_IN_PCK_QTY              " ).append("\n"); 
		query.append(",@[in_n2nd_imdg_pck_desc]       AS IN_N2ND_IMDG_PCK_DESC       " ).append("\n"); 
		query.append(",@[intmd_n1st_imdg_pck_cd]      AS INTMD_N1ST_IMDG_PCK_CD      " ).append("\n"); 
		query.append(",@[pck_tp_cd]                   AS PCK_TP_CD                   " ).append("\n"); 
		query.append(",@[fdo_temp]                    AS FDO_TEMP                    " ).append("\n"); 
		query.append(",@[spcl_stwg_rqst_desc]         AS SPCL_STWG_RQST_DESC         " ).append("\n"); 
		query.append(",@[slan_cd]                     AS SLAN_CD                     " ).append("\n"); 
		query.append(",@[diff_rmk]                    AS DIFF_RMK                    " ).append("\n"); 
		query.append(",@[crr_flg]                     AS CRR_FLG                     " ).append("\n"); 
		query.append(",@[out_n2nd_imdg_pck_desc]      AS OUT_N2ND_IMDG_PCK_DESC      " ).append("\n"); 
		query.append(",@[auth_sts_cd]                 AS AUTH_STS_CD                 " ).append("\n"); 
		query.append(",@[out_n1st_imdg_pck_cd]        AS OUT_N1ST_IMDG_PCK_CD        " ).append("\n"); 
		query.append(",@[vsl_cd]                      AS VSL_CD                      " ).append("\n"); 
		query.append(",@[ttl_dim_wdt]                 AS TTL_DIM_WDT                 " ).append("\n"); 
		query.append(",@[expt_qty_flg]                AS EXPT_QTY_FLG                " ).append("\n"); 
		query.append(",@[psa_no]                      AS PSA_NO                      " ).append("\n"); 
		query.append(",@[in_n2nd_imdg_pck_qty]        AS IN_N2ND_IMDG_PCK_QTY        " ).append("\n"); 
		query.append(",@[dcgo_sts_cd]                 AS DCGO_STS_CD                 " ).append("\n"); 
		query.append(",@[emer_cntc_pson_nm]           AS EMER_CNTC_PSON_NM           " ).append("\n"); 
		query.append(",@[imdg_spcl_provi_no]          AS IMDG_SPCL_PROVI_NO          " ).append("\n"); 
		query.append(",@[out_n2nd_imdg_pck_cd]        AS OUT_N2ND_IMDG_PCK_CD        " ).append("\n"); 
		query.append(",@[crr_cd]                      AS CRR_CD                      " ).append("\n"); 
		query.append(",@[lf_sd_ovr_dim_len]           AS LF_SD_OVR_DIM_LEN           " ).append("\n"); 
		query.append(",@[pol_cd]                      AS POL_CD                      " ).append("\n"); 
		query.append(",@[in_n2nd_imdg_pck_cd]         AS IN_N2ND_IMDG_PCK_CD         " ).append("\n"); 
		query.append(",@[fwrd_ovr_dim_len]            AS FWRD_OVR_DIM_LEN            " ).append("\n"); 
		query.append(",@[wgt_ut_cd]                   AS WGT_UT_CD                   " ).append("\n"); 
		query.append(",@[in_n1st_imdg_pck_qty]        AS IN_N1ST_IMDG_PCK_QTY        " ).append("\n"); 
		query.append(",@[mrn_polut_flg]               AS MRN_POLUT_FLG               " ).append("\n"); 
		query.append(",@[cntr_ref_no]                 AS CNTR_REF_NO                 " ).append("\n"); 
		query.append(",@[auth_dt]                     AS AUTH_DT                     " ).append("\n"); 
		query.append(",@[net_wgt]                     AS NET_WGT                     " ).append("\n"); 
		query.append(",@[spcl_cntr_seq]               AS SPCL_CNTR_SEQ               " ).append("\n"); 
		query.append(",@[port_flg]                    AS PORT_FLG                    " ).append("\n"); 
		query.append(",@[ttl_dim_hgt]                 AS TTL_DIM_HGT                 " ).append("\n"); 
		query.append(",@[vent_rto]                    AS VENT_RTO                    " ).append("\n"); 
		query.append(",@[cre_usr_id]                  AS CRE_USR_ID                  " ).append("\n"); 
		query.append(",@[cgo_lcl_flg]                 AS CGO_LCL_FLG                 " ).append("\n"); 
		query.append(",@[hzd_desc]                    AS HZD_DESC                    " ).append("\n"); 
		query.append(",@[ttl_dim_len]                 AS TTL_DIM_LEN                 " ).append("\n"); 
		query.append(",@[cgo_rqst_dt]                 AS CGO_RQST_DT                 " ).append("\n"); 
		query.append(",@[emer_rspn_gid_chr_no]        AS EMER_RSPN_GID_CHR_NO        " ).append("\n"); 
		query.append(",@[apro_ref_no]                 AS APRO_REF_NO                 " ).append("\n"); 
		query.append(",@[emer_temp_ctnt]              AS EMER_TEMP_CTNT              " ).append("\n"); 
		query.append(",@[grs_wgt]                     AS GRS_WGT                     " ).append("\n"); 
		query.append(",@[pi_flg]                      AS PI_FLG                      " ).append("\n"); 
		query.append(",@[rt_sd_ovr_dim_len]           AS RT_SD_OVR_DIM_LEN           " ).append("\n"); 
		query.append(",@[spcl_cgo_seq]                AS SPCL_CGO_SEQ                " ).append("\n"); 
		query.append(",@[cre_dt]                      AS CRE_DT                      " ).append("\n"); 
		query.append(",@[seg_flg]                     AS SEG_FLG                     " ).append("\n"); 
		query.append(",@[rada_trsp_no]                AS RADA_TRSP_NO                " ).append("\n"); 
		query.append(",@[max_in_pck_tp_cd]            AS MAX_IN_PCK_TP_CD            " ).append("\n"); 
		query.append(",@[rada_ut_cd]                  AS RADA_UT_CD                  " ).append("\n"); 
		query.append(",@[intmd_n1st_imdg_pck_desc]    AS INTMD_N1ST_IMDG_PCK_DESC    " ).append("\n"); 
		query.append(",@[imdg_expt_qty_cd]            AS IMDG_EXPT_QTY_CD            " ).append("\n"); 
		query.append(",@[certi_no]                    AS CERTI_NO                    " ).append("\n"); 
		query.append(",@[meas_qty]                    AS MEAS_QTY                    " ).append("\n"); 
		query.append(",@[pck_qty]                     AS PCK_QTY                     " ).append("\n"); 
		query.append(",@[out_n1st_imdg_pck_qty]       AS OUT_N1ST_IMDG_PCK_QTY       " ).append("\n"); 
		query.append(",@[hcdg_pck_rstr_desc]          AS HCDG_PCK_RSTR_DESC          " ).append("\n"); 
		query.append(",@[in_n1st_imdg_pck_desc]       AS IN_N1ST_IMDG_PCK_DESC       " ).append("\n"); 
		query.append(",@[b_b_flag]                    AS B_B_FLAG                    " ).append("\n"); 
		query.append(",@[intmd_n2nd_imdg_pck_cd]      AS INTMD_N2ND_IMDG_PCK_CD      " ).append("\n"); 
		query.append(",@[imdg_expt_qty_flg]           AS IMDG_EXPT_QTY_FLG           " ).append("\n"); 
		query.append(",@[n2nd_imdg_subs_rsk_lbl_cd]   AS N2ND_IMDG_SUBS_RSK_LBL_CD   " ).append("\n"); 
		query.append(",@[upd_dt]                      AS UPD_DT                      " ).append("\n"); 
		query.append(",@[mdt_flg]                     AS MDT_FLG                     " ).append("\n"); 
		query.append(",@[clod_flg]                    AS CLOD_FLG                    " ).append("\n"); 
		query.append(",@[bkwd_ovr_dim_len]            AS BKWD_OVR_DIM_LEN            " ).append("\n"); 
		query.append(",@[grs_capa_qty]                AS GRS_CAPA_QTY                    " ).append("\n"); 
		query.append(",@[imdg_co_grp_cd]              AS IMDG_CO_GRP_CD              " ).append("\n"); 
		query.append(",@[skd_dir_cd]                  AS SKD_DIR_CD                  " ).append("\n"); 
		query.append(",@[bkg_ref_no]                  AS BKG_REF_NO                  " ).append("\n"); 
		query.append(",@[vltg_no]                     AS VLTG_NO                     " ).append("\n"); 
		query.append(",@[dg_flg]                      AS DG_FLG                      " ).append("\n"); 
		query.append(",@[cgo_opr_cd]                  AS CGO_OPR_CD                  " ).append("\n"); 
		query.append(",@[cdo_temp]                    AS CDO_TEMP                    " ).append("\n"); 
		query.append(",@[ctrl_temp_ctnt]              AS CTRL_TEMP_CTNT              " ).append("\n"); 
		query.append(",@[hcdg_tnk_rstr_desc]          AS HCDG_TNK_RSTR_DESC          " ).append("\n"); 
		query.append(",@[out_n1st_imdg_pck_desc]      AS OUT_N1ST_IMDG_PCK_DESC      " ).append("\n"); 
		query.append(",@[prp_shp_nm]                  AS PRP_SHP_NM                  " ).append("\n"); 
		query.append(",@[ltd_qty_flg]                 AS LTD_QTY_FLG                 " ).append("\n"); 
		query.append(",@[imdg_lmt_qty_flg]            AS IMDG_LMT_QTY_FLG            " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,REPLACE((SELECT ERR_MSG " ).append("\n"); 
		query.append("                  FROM COM_ERR_MSG" ).append("\n"); 
		query.append("                 WHERE ERR_MSG_CD = 'SCG60034' " ).append("\n"); 
		query.append("               ), '$', NVL2(I.IMDG_UN_NO, '', 'UN NO.')||NVL2(I.PRP_SHP_NM, '', '/ PROPER Shipping Name(PSN)')" ).append("\n"); 
		query.append("                       ||NVL2(I.IMDG_CLSS_CD, '', '/ Class')||NVL2(MRN_POLUT_FLG, '', '/ Marine Pollution')" ).append("\n"); 
		query.append("                       ||NVL2(I.EMER_CNTC_PHN_NO, '', '/ Emergency Contact')||NVL2(I.OUT_N1ST_IMDG_PCK_CD, '', '/ Type of Outer Package')" ).append("\n"); 
		query.append("                       ||NVL2(I.OUT_N1ST_IMDG_PCK_QTY, '', '/ Piece count of Outer Packaging Type')) MTD_DESC" ).append("\n"); 
		query.append("  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append(" WHERE I.IMDG_UN_NO IS NULL" ).append("\n"); 
		query.append("    OR I.PRP_SHP_NM IS NULL" ).append("\n"); 
		query.append("    OR I.IMDG_CLSS_CD IS NULL" ).append("\n"); 
		query.append("    OR I.MRN_POLUT_FLG IS NULL" ).append("\n"); 
		query.append("    OR I.EMER_CNTC_PHN_NO IS NULL" ).append("\n"); 
		query.append("    OR I.OUT_N1ST_IMDG_PCK_CD IS NULL" ).append("\n"); 
		query.append("    OR I.OUT_N1ST_IMDG_PCK_QTY IS NULL" ).append("\n"); 
		query.append("--UNION ALL" ).append("\n"); 
		query.append("--SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("--      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("--      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("--      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("--      ,REPLACE((SELECT ERR_MSG " ).append("\n"); 
		query.append("--                  FROM COM_ERR_MSG" ).append("\n"); 
		query.append("--                 WHERE ERR_MSG_CD = 'SCG60035' " ).append("\n"); 
		query.append("--              ), '$', DECODE(I.IMDG_CLSS_CD, S.IMDG_CLSS_CD, 'Class', '')" ).append("\n"); 
		query.append("--                       ||DECODE(I.PRP_SHP_NM, S.PRP_SHP_NM, '/PROPER Shipping Name(PSN)', '')) MTD_DESC" ).append("\n"); 
		query.append("--  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append("--      ,SCG_IMDG_UN_NO S" ).append("\n"); 
		query.append("-- WHERE I.IMDG_UN_NO = S.IMDG_UN_NO" ).append("\n"); 
		query.append("--   AND DECODE(I.IMDG_PCK_GRP_CD, 'I', '1', 'II', '2', 'III', '3', NULL, '4', I.IMDG_PCK_GRP_CD) = NVL(S.IMDG_PCK_GRP_CD, '4')" ).append("\n"); 
		query.append("--   AND (I.IMDG_CLSS_CD <> S.IMDG_CLSS_CD" ).append("\n"); 
		query.append("--        OR I.PRP_SHP_NM <> S.PRP_SHP_NM" ).append("\n"); 
		query.append("--        OR I.IMDG_COMP_GRP_CD <> S.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("--       )" ).append("\n"); 
		query.append("--   AND I.PRP_SHP_NM IS NOT NULL" ).append("\n"); 
		query.append("--   AND I.IMDG_CLSS_CD IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT ERR_MSG " ).append("\n"); 
		query.append("          FROM COM_ERR_MSG" ).append("\n"); 
		query.append("         WHERE ERR_MSG_CD = 'SCG60036' " ).append("\n"); 
		query.append("       ) MTD_DESC" ).append("\n"); 
		query.append("  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append("      ,SCG_IMDG_UN_NO_SPCL_PROVI S" ).append("\n"); 
		query.append("      ,SCG_IMDG_UN_NO U" ).append("\n"); 
		query.append(" WHERE I.IMDG_UN_NO = S.IMDG_UN_NO" ).append("\n"); 
		query.append("   AND I.IMDG_UN_NO = U.IMDG_UN_NO" ).append("\n"); 
		query.append("   AND DECODE(I.IMDG_PCK_GRP_CD, 'I', '1', 'II', '2', 'III', '3', NULL, '4', I.IMDG_PCK_GRP_CD) = NVL(U.IMDG_PCK_GRP_CD, '4')" ).append("\n"); 
		query.append("   AND U.IMDG_UN_NO_SEQ = S.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("   AND (S.IMDG_SPCL_PROVI_NO = '318'" ).append("\n"); 
		query.append("        OR S.IMDG_SPCL_PROVI_NO = '274'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND (INSTR(I.PRP_SHP_NM, '(') = 0" ).append("\n"); 
		query.append("        OR INSTR(I.PRP_SHP_NM, ')') = 0" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND I.HZD_DESC IS NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT ERR_MSG " ).append("\n"); 
		query.append("          FROM COM_ERR_MSG" ).append("\n"); 
		query.append("         WHERE ERR_MSG_CD = 'SCG60037' " ).append("\n"); 
		query.append("       ) MTD_DESC" ).append("\n"); 
		query.append("  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append(" WHERE INSTR(UPPER(I.PRP_SHP_NM), ' AND ') <> 0" ).append("\n"); 
		query.append("    OR INSTR(UPPER(I.PRP_SHP_NM), ' OR ') <> 0" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT ERR_MSG " ).append("\n"); 
		query.append("          FROM COM_ERR_MSG" ).append("\n"); 
		query.append("         WHERE ERR_MSG_CD = 'SCG60039' " ).append("\n"); 
		query.append("       ) MTD_DESC" ).append("\n"); 
		query.append("  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append(" WHERE I.IMDG_CLSS_CD = '3'" ).append("\n"); 
		query.append("   AND I.FLSH_PNT_CDO_TEMP IS NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT ERR_MSG " ).append("\n"); 
		query.append("          FROM COM_ERR_MSG" ).append("\n"); 
		query.append("         WHERE ERR_MSG_CD = 'SCG60040' " ).append("\n"); 
		query.append("       ) MTD_DESC" ).append("\n"); 
		query.append("  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append(" WHERE I.IMDG_CLSS_CD = '3'" ).append("\n"); 
		query.append("   AND DECODE(I.IMDG_PCK_GRP_CD, 'I', '1', 'II', '2', 'III', '3', I.IMDG_PCK_GRP_CD) < 3" ).append("\n"); 
		query.append("   AND I.FLSH_PNT_CDO_TEMP > 23" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT ERR_MSG " ).append("\n"); 
		query.append("          FROM COM_ERR_MSG" ).append("\n"); 
		query.append("         WHERE ERR_MSG_CD = 'SCG60041' " ).append("\n"); 
		query.append("       ) MTD_DESC" ).append("\n"); 
		query.append("  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append(" WHERE I.IMDG_CLSS_CD = '3'" ).append("\n"); 
		query.append("   AND DECODE(I.IMDG_PCK_GRP_CD, 'I', '1', 'II', '2', 'III', '3', I.IMDG_PCK_GRP_CD) = '3'" ).append("\n"); 
		query.append("   AND (I.FLSH_PNT_CDO_TEMP < 23" ).append("\n"); 
		query.append("        OR I.FLSH_PNT_CDO_TEMP > 60" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND I.IMDG_CLSS_CD <> '5.2'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT ERR_MSG " ).append("\n"); 
		query.append("          FROM COM_ERR_MSG" ).append("\n"); 
		query.append("         WHERE ERR_MSG_CD = 'SCG60042' " ).append("\n"); 
		query.append("       ) MTD_DESC" ).append("\n"); 
		query.append("  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append(" WHERE (I.IMDG_CLSS_CD <> '3'" ).append("\n"); 
		query.append("        AND I.IMDG_SUBS_RSK_LBL_RMK <> '3'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND I.FLSH_PNT_CDO_TEMP IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT ERR_MSG " ).append("\n"); 
		query.append("          FROM COM_ERR_MSG" ).append("\n"); 
		query.append("         WHERE ERR_MSG_CD = 'SCG60044' " ).append("\n"); 
		query.append("       ) MTD_DESC" ).append("\n"); 
		query.append("  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append("      ,SCG_IMDG_UN_NO S" ).append("\n"); 
		query.append(" WHERE I.IMDG_UN_NO = S.IMDG_UN_NO" ).append("\n"); 
		query.append("   AND DECODE(I.IMDG_PCK_GRP_CD, 'I', '1', 'II', '2', 'III', '3', NULL, '4', I.IMDG_PCK_GRP_CD) = NVL(S.IMDG_PCK_GRP_CD, '4')" ).append("\n"); 
		query.append("   AND I.MRN_POLUT_FLG IS NOT NULL" ).append("\n"); 
		query.append("   AND I.MRN_POLUT_FLG = 'N'" ).append("\n"); 
		query.append("   AND S.IMDG_MRN_POLUT_CD IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT ERR_MSG " ).append("\n"); 
		query.append("          FROM COM_ERR_MSG" ).append("\n"); 
		query.append("         WHERE ERR_MSG_CD = 'SCG60047' " ).append("\n"); 
		query.append("       ) MTD_DESC" ).append("\n"); 
		query.append("  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append(" WHERE I.IMDG_CLSS_CD = '1'" ).append("\n"); 
		query.append("   AND I.NET_EXPLO_WGT IS NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT ERR_MSG " ).append("\n"); 
		query.append("          FROM COM_ERR_MSG" ).append("\n"); 
		query.append("         WHERE ERR_MSG_CD = 'SCG60045' " ).append("\n"); 
		query.append("       ) MTD_DESC" ).append("\n"); 
		query.append("  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append("      ,SCG_IMDG_UN_NO S" ).append("\n"); 
		query.append(" WHERE I.IMDG_UN_NO = S.IMDG_UN_NO" ).append("\n"); 
		query.append("   AND DECODE(I.IMDG_PCK_GRP_CD, 'I', '1', 'II', '2', 'III', '3', NULL, '4', I.IMDG_PCK_GRP_CD) = NVL(S.IMDG_PCK_GRP_CD, '4')" ).append("\n"); 
		query.append("   AND I.MRN_POLUT_FLG IS NOT NULL" ).append("\n"); 
		query.append("   AND I.MRN_POLUT_FLG = S.IMDG_MRN_POLUT_CD " ).append("\n"); 
		query.append("   AND INSTR(UPPER(I.PRP_SHP_NM), 'MARINE POLLUTANT') = 0" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT I.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,I.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,I.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,(SELECT ERR_MSG " ).append("\n"); 
		query.append("          FROM COM_ERR_MSG" ).append("\n"); 
		query.append("         WHERE ERR_MSG_CD = 'SCG60046' " ).append("\n"); 
		query.append("       ) MTD_DESC" ).append("\n"); 
		query.append("  FROM IN_CGO_LIST_TBL I" ).append("\n"); 
		query.append(" WHERE I.DCGO_STS_CD = 'L'" ).append("\n"); 
		query.append("   AND I.GRS_CAPA_QTY IS NULL" ).append("\n"); 

	}
}