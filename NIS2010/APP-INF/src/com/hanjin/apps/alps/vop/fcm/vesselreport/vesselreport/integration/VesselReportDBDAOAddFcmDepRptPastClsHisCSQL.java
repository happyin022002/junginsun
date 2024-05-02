/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOAddFcmDepRptPastClsHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOAddFcmDepRptPastClsHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FCM DEPARTURE REPORT ERROR Past Cleansing History 생성
	  * </pre>
	  */
	public VesselReportDBDAOAddFcmDepRptPastClsHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_gnr_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_mn_low_sulp_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_gnr_low_sulp_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eng_ml_dist_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_mn_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr_obrd_knt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_gnr_low_sulp_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_blr_low_sulp_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_aftdr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_cgo_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_mid_drft_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_dep_low_sulp_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_blr_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmn_avg_spd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_port_rup_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_low_sulp_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sb_eng_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plt_out_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_gnr_low_sulp_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wrk_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_doil_sulp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mcntr_obrd_teu_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_unbrth_ank_drp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_dep_low_sulp_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_mn_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvgt_ml_dist_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_rpt_err_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_foil_bdr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_out_ml_dist_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_doil_sulp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_blr_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_prlr_pch_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_dep_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_dep_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_unbrth_ank_off_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_gnr_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_tm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_in_ml_dist_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_brth_ank_drp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_spd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_fwddr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_foil_bdr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_brth_ank_off_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_rpm_pwr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_blr_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr_lod_knt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_blr_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_mn_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_dpl_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_port_ttl_hr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_port_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_dep_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_doil_act_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_aftdr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_foil_act_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_blr_low_sulp_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_foil_sulp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_fwddr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_stmng_mn_eng_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_cntr_obrd_teu_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_gnr_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmn_dist_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_gm_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_mn_low_sulp_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_low_sulp_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_doil_bdr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr_dchg_knt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_foil_sulp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_gnr_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sea_mn_low_sulp_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcntr_obrd_teu_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_gnr_low_sulp_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_doil_bdr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_blr_low_sulp_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_low_sulp_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_doil_act_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nxt_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_mid_drft_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wrk_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_blr_low_sulp_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_mn_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_mn_low_sulp_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plt_in_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_dep_doil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nxt_port_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_gm_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_foil_act_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rup_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_low_sulp_foil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOAddFcmDepRptPastClsHisCSQL").append("\n"); 
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
		query.append("INSERT INTO FCM_DEP_RPT_CLS_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	DEP_RPT_CLS_SEQ	," ).append("\n"); 
		query.append("	VSL_CD	," ).append("\n"); 
		query.append("	SKD_VOY_NO	," ).append("\n"); 
		query.append("	SKD_DIR_CD	," ).append("\n"); 
		query.append("	DEP_PORT_CD	," ).append("\n"); 
		query.append("	CLPT_IND_SEQ	," ).append("\n"); 
		query.append("	DEP_RPT_ERR_TP_CD	," ).append("\n"); 
		query.append("	VSL_SLAN_CD	," ).append("\n"); 
		query.append("	NVGT_ML_DIST_CTNT	," ).append("\n"); 
		query.append("	ENG_ML_DIST_CTNT	," ).append("\n"); 
		query.append("	MNVR_IN_ML_DIST_CTNT	," ).append("\n"); 
		query.append("	MNVR_OUT_ML_DIST_CTNT	," ).append("\n"); 
		query.append("	AVG_SPD_CTNT	," ).append("\n"); 
		query.append("	AVG_RPM_PWR_CTNT	," ).append("\n"); 
		query.append("	ARR_FOIL_CTNT	," ).append("\n"); 
		query.append("	ARR_LOW_SULP_FOIL_CTNT	," ).append("\n"); 
		query.append("	ARR_DOIL_CTNT	," ).append("\n"); 
		query.append("	ARR_LOW_SULP_DOIL_CTNT	," ).append("\n"); 
		query.append("	DEP_FOIL_CTNT	," ).append("\n"); 
		query.append("	DEP_LOW_SULP_FOIL_CTNT	," ).append("\n"); 
		query.append("	DEP_DOIL_CTNT	," ).append("\n"); 
		query.append("	DEP_LOW_SULP_DOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_MN_FOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_GNR_FOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_BLR_FOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_MN_LOW_SULP_FOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_GNR_LOW_SULP_FOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_BLR_LOW_SULP_FOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_MN_DOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_GNR_DOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_BLR_DOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_MN_LOW_SULP_DOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_GNR_LOW_SULP_DOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_BLR_LOW_SULP_DOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_MN_FOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_GNR_FOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_BLR_FOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_MN_LOW_SULP_FOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_GNR_LOW_SULP_FOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_BLR_LOW_SULP_FOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_MN_DOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_GNR_DOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_BLR_DOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_MN_LOW_SULP_DOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_GNR_LOW_SULP_DOIL_CTNT	," ).append("\n"); 
		query.append("	PORT_BLR_LOW_SULP_DOIL_CTNT	," ).append("\n"); 
		query.append("	SPL_FOIL_BDR_CTNT	," ).append("\n"); 
		query.append("	SPL_FOIL_ACT_CTNT	," ).append("\n"); 
		query.append("	SPL_FOIL_SULP_CTNT	," ).append("\n"); 
		query.append("	SPL_LOW_SULP_FOIL_BDR_CTNT	," ).append("\n"); 
		query.append("	SPL_LOW_SULP_FOIL_ACT_CTNT	," ).append("\n"); 
		query.append("	SPL_LOW_SULP_FOIL_SULP_CTNT	," ).append("\n"); 
		query.append("	SPL_DOIL_BDR_CTNT	," ).append("\n"); 
		query.append("	SPL_DOIL_ACT_CTNT	," ).append("\n"); 
		query.append("	SPL_DOIL_SULP_CTNT	," ).append("\n"); 
		query.append("	SPL_LOW_SULP_DOIL_BDR_CTNT	," ).append("\n"); 
		query.append("	SPL_LOW_SULP_DOIL_ACT_CTNT	," ).append("\n"); 
		query.append("	SPL_LOW_SULP_DOIL_SULP_CTNT	," ).append("\n"); 
		query.append("	NXT_PORT_CD	," ).append("\n"); 
		query.append("	NXT_PORT_ETA_DT	," ).append("\n"); 
		query.append("	RMN_DIST_CTNT	," ).append("\n"); 
		query.append("	RMN_AVG_SPD_CTNT	," ).append("\n"); 
		query.append("	SB_ENG_DT	," ).append("\n"); 
		query.append("	PLT_IN_DT	," ).append("\n"); 
		query.append("	BFR_BRTH_ANK_DRP_DT	," ).append("\n"); 
		query.append("	BFR_BRTH_ANK_OFF_DT	," ).append("\n"); 
		query.append("	VPS_ETB_DT	," ).append("\n"); 
		query.append("	CGO_WRK_ST_DT	," ).append("\n"); 
		query.append("	CGO_WRK_END_DT	," ).append("\n"); 
		query.append("	VPS_ETD_DT	," ).append("\n"); 
		query.append("	AFT_UNBRTH_ANK_DRP_DT	," ).append("\n"); 
		query.append("	AFT_UNBRTH_ANK_OFF_DT	," ).append("\n"); 
		query.append("	PLT_OUT_DT	," ).append("\n"); 
		query.append("	RUP_DT	," ).append("\n"); 
		query.append("	ARR_FWDDR_CTNT	," ).append("\n"); 
		query.append("	ARR_MID_DRFT_CTNT	," ).append("\n"); 
		query.append("	ARR_AFTDR_CTNT	," ).append("\n"); 
		query.append("	ARR_GM_CTNT	," ).append("\n"); 
		query.append("	DEP_FWDDR_CTNT	," ).append("\n"); 
		query.append("	DEP_MID_DRFT_CTNT	," ).append("\n"); 
		query.append("	DEP_AFTDR_CTNT	," ).append("\n"); 
		query.append("	DEP_GM_CTNT	," ).append("\n"); 
		query.append("	FCNTR_OBRD_TEU_CTNT	," ).append("\n"); 
		query.append("	MCNTR_OBRD_TEU_CTNT	," ).append("\n"); 
		query.append("	TTL_CNTR_OBRD_TEU_CTNT	," ).append("\n"); 
		query.append("	DEP_CGO_CTNT	," ).append("\n"); 
		query.append("	DEP_DPL_CTNT	," ).append("\n"); 
		query.append("	RF_CNTR_DCHG_KNT_CTNT	," ).append("\n"); 
		query.append("	RF_CNTR_LOD_KNT_CTNT	," ).append("\n"); 
		query.append("	RF_CNTR_OBRD_KNT_CTNT	," ).append("\n"); 
		query.append("	OLD_VSL_CD	," ).append("\n"); 
		query.append("	OLD_SKD_VOY_NO	," ).append("\n"); 
		query.append("	OLD_SKD_DIR_CD	," ).append("\n"); 
		query.append("	OLD_DEP_PORT_CD	," ).append("\n"); 
		query.append("	OLD_CLPT_IND_SEQ	," ).append("\n"); 
		query.append("	CRE_USR_ID	," ).append("\n"); 
		query.append("	CRE_DT	," ).append("\n"); 
		query.append("	UPD_USR_ID	," ).append("\n"); 
		query.append("	UPD_DT	," ).append("\n"); 
		query.append("	LST_DEP_PORT_CD	," ).append("\n"); 
		query.append("	AVG_PRLR_PCH_VAL	," ).append("\n"); 
		query.append("	SAIL_TM_HRS	," ).append("\n"); 
		query.append("	LST_DEP_FOIL_CTNT	," ).append("\n"); 
		query.append("	LST_DEP_LOW_SULP_FOIL_CTNT	," ).append("\n"); 
		query.append("	LST_DEP_DOIL_CTNT	," ).append("\n"); 
		query.append("	LST_DEP_LOW_SULP_DOIL_CTNT	," ).append("\n"); 
		query.append("	SEA_STMNG_MN_ENG_TTL_QTY	," ).append("\n"); 
		query.append("	AVG_PORT_TTL_QTY	," ).append("\n"); 
		query.append("	AVG_PORT_TTL_HR_QTY	," ).append("\n"); 
		query.append("	LST_PORT_RUP_DT	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("	FCM_DEP_RPT_CLS_SEQ.NEXTVAL	," ).append("\n"); 
		query.append("	@[vsl_cd]	," ).append("\n"); 
		query.append("    SUBSTR(@[skd_voy_no], 1, 4)	," ).append("\n"); 
		query.append("    SUBSTR(@[skd_voy_no], 5, 1)	," ).append("\n"); 
		query.append("	@[dep_port_cd]	," ).append("\n"); 
		query.append("	@[clpt_ind_seq]	," ).append("\n"); 
		query.append("	@[dep_rpt_err_tp_cd]	," ).append("\n"); 
		query.append("	@[vsl_slan_cd]	," ).append("\n"); 
		query.append("	@[nvgt_ml_dist_ctnt]	," ).append("\n"); 
		query.append("	@[eng_ml_dist_ctnt]	," ).append("\n"); 
		query.append("	@[mnvr_in_ml_dist_ctnt]	," ).append("\n"); 
		query.append("	@[mnvr_out_ml_dist_ctnt]	," ).append("\n"); 
		query.append("	@[avg_spd_ctnt]	," ).append("\n"); 
		query.append("	@[avg_rpm_pwr_ctnt]	," ).append("\n"); 
		query.append("	@[arr_foil_ctnt]	," ).append("\n"); 
		query.append("	@[arr_low_sulp_foil_ctnt]	," ).append("\n"); 
		query.append("	@[arr_doil_ctnt]	," ).append("\n"); 
		query.append("	@[arr_low_sulp_doil_ctnt]	," ).append("\n"); 
		query.append("	@[dep_foil_ctnt]	," ).append("\n"); 
		query.append("	@[dep_low_sulp_foil_ctnt]	," ).append("\n"); 
		query.append("	@[dep_doil_ctnt]	," ).append("\n"); 
		query.append("	@[dep_low_sulp_doil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_mn_foil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_gnr_foil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_blr_foil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_mn_low_sulp_foil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_gnr_low_sulp_foil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_blr_low_sulp_foil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_mn_doil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_gnr_doil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_blr_doil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_mn_low_sulp_doil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_gnr_low_sulp_doil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_blr_low_sulp_doil_ctnt]	," ).append("\n"); 
		query.append("	@[port_mn_foil_ctnt]	," ).append("\n"); 
		query.append("	@[port_gnr_foil_ctnt]	," ).append("\n"); 
		query.append("	@[port_blr_foil_ctnt]	," ).append("\n"); 
		query.append("	@[port_mn_low_sulp_foil_ctnt]	," ).append("\n"); 
		query.append("	@[port_gnr_low_sulp_foil_ctnt]	," ).append("\n"); 
		query.append("	@[port_blr_low_sulp_foil_ctnt]	," ).append("\n"); 
		query.append("	@[port_mn_doil_ctnt]	," ).append("\n"); 
		query.append("	@[port_gnr_doil_ctnt]	," ).append("\n"); 
		query.append("	@[port_blr_doil_ctnt]	," ).append("\n"); 
		query.append("	@[port_mn_low_sulp_doil_ctnt]	," ).append("\n"); 
		query.append("	@[port_gnr_low_sulp_doil_ctnt]	," ).append("\n"); 
		query.append("	@[port_blr_low_sulp_doil_ctnt]	," ).append("\n"); 
		query.append("	@[spl_foil_bdr_ctnt]	," ).append("\n"); 
		query.append("	@[spl_foil_act_ctnt]	," ).append("\n"); 
		query.append("	@[spl_foil_sulp_ctnt]	," ).append("\n"); 
		query.append("	@[spl_low_sulp_foil_bdr_ctnt]	," ).append("\n"); 
		query.append("	@[spl_low_sulp_foil_act_ctnt]	," ).append("\n"); 
		query.append("	@[spl_low_sulp_foil_sulp_ctnt]	," ).append("\n"); 
		query.append("	@[spl_doil_bdr_ctnt]	," ).append("\n"); 
		query.append("	@[spl_doil_act_ctnt]	," ).append("\n"); 
		query.append("	@[spl_doil_sulp_ctnt]	," ).append("\n"); 
		query.append("	@[spl_low_sulp_doil_bdr_ctnt]	," ).append("\n"); 
		query.append("	@[spl_low_sulp_doil_act_ctnt]	," ).append("\n"); 
		query.append("	@[spl_low_sulp_doil_sulp_ctnt]	," ).append("\n"); 
		query.append("	@[nxt_port_cd]	," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[nxt_port_eta_dt]      )<=12 THEN TO_DATE(RPAD(@[nxt_port_eta_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[nxt_port_eta_dt]      , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	@[rmn_dist_ctnt]	," ).append("\n"); 
		query.append("	@[rmn_avg_spd_ctnt]	," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[sb_eng_dt]            )<=12 THEN TO_DATE(RPAD(@[sb_eng_dt]            , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[sb_eng_dt]            , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[plt_in_dt]            )<=12 THEN TO_DATE(RPAD(@[plt_in_dt]            , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[plt_in_dt]            , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[bfr_brth_ank_drp_dt]  )<=12 THEN TO_DATE(RPAD(@[bfr_brth_ank_drp_dt]  , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[bfr_brth_ank_drp_dt]  , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[bfr_brth_ank_off_dt]  )<=12 THEN TO_DATE(RPAD(@[bfr_brth_ank_off_dt]  , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[bfr_brth_ank_off_dt]  , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[vps_etb_dt]           )<=12 THEN TO_DATE(RPAD(@[vps_etb_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[vps_etb_dt]           , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[cgo_wrk_st_dt]        )<=12 THEN TO_DATE(RPAD(@[cgo_wrk_st_dt]        , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[cgo_wrk_st_dt]        , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[cgo_wrk_end_dt]       )<=12 THEN TO_DATE(RPAD(@[cgo_wrk_end_dt]       , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[cgo_wrk_end_dt]       , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[vps_etd_dt]           )<=12 THEN TO_DATE(RPAD(@[vps_etd_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[vps_etd_dt]           , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[aft_unbrth_ank_drp_dt])<=12 THEN TO_DATE(RPAD(@[aft_unbrth_ank_drp_dt], 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[aft_unbrth_ank_drp_dt], 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[aft_unbrth_ank_off_dt])<=12 THEN TO_DATE(RPAD(@[aft_unbrth_ank_off_dt], 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[aft_unbrth_ank_off_dt], 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[plt_out_dt]           )<=12 THEN TO_DATE(RPAD(@[plt_out_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[plt_out_dt]           , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[rup_dt]               )<=12 THEN TO_DATE(RPAD(@[rup_dt]               , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[rup_dt]               , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("	@[arr_fwddr_ctnt]	," ).append("\n"); 
		query.append("	@[arr_mid_drft_ctnt]	," ).append("\n"); 
		query.append("	@[arr_aftdr_ctnt]	," ).append("\n"); 
		query.append("	@[arr_gm_ctnt]	," ).append("\n"); 
		query.append("	@[dep_fwddr_ctnt]	," ).append("\n"); 
		query.append("	@[dep_mid_drft_ctnt]	," ).append("\n"); 
		query.append("	@[dep_aftdr_ctnt]	," ).append("\n"); 
		query.append("	@[dep_gm_ctnt]	," ).append("\n"); 
		query.append("	@[fcntr_obrd_teu_ctnt]	," ).append("\n"); 
		query.append("	@[mcntr_obrd_teu_ctnt]	," ).append("\n"); 
		query.append("	@[ttl_cntr_obrd_teu_ctnt]	," ).append("\n"); 
		query.append("	@[dep_cgo_ctnt]	," ).append("\n"); 
		query.append("	@[dep_dpl_ctnt]	," ).append("\n"); 
		query.append("	@[rf_cntr_dchg_knt_ctnt]	," ).append("\n"); 
		query.append("	@[rf_cntr_lod_knt_ctnt]	," ).append("\n"); 
		query.append("	@[rf_cntr_obrd_knt_ctnt]	," ).append("\n"); 
		query.append("	@[old_vsl_cd]	," ).append("\n"); 
		query.append("	@[old_skd_voy_no]	," ).append("\n"); 
		query.append("	@[old_skd_dir_cd]	," ).append("\n"); 
		query.append("	@[old_dep_port_cd]	," ).append("\n"); 
		query.append("	@[old_clpt_ind_seq]	," ).append("\n"); 
		query.append("	@[cre_usr_id]	," ).append("\n"); 
		query.append("	SYSDATE	," ).append("\n"); 
		query.append("	@[upd_usr_id]	," ).append("\n"); 
		query.append("	SYSDATE	," ).append("\n"); 
		query.append("	@[lst_dep_port_cd]	," ).append("\n"); 
		query.append("	@[avg_prlr_pch_val]	," ).append("\n"); 
		query.append("	@[sail_tm_hrs]	," ).append("\n"); 
		query.append("	@[lst_dep_foil_ctnt]	," ).append("\n"); 
		query.append("	@[lst_dep_low_sulp_foil_ctnt]	," ).append("\n"); 
		query.append("	@[lst_dep_doil_ctnt]	," ).append("\n"); 
		query.append("	@[lst_dep_low_sulp_doil_ctnt]	," ).append("\n"); 
		query.append("	@[sea_stmng_mn_eng_ttl_qty]	," ).append("\n"); 
		query.append("	@[avg_port_ttl_qty]	," ).append("\n"); 
		query.append("	@[avg_port_ttl_hr_qty]	," ).append("\n"); 
		query.append("	(CASE WHEN LENGTH(@[lst_port_rup_dt]      )<=12 THEN TO_DATE(RPAD(@[lst_port_rup_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[lst_port_rup_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}