/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOModifyFcmDepRptUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
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

public class VesselReportDBDAOModifyFcmDepRptUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify departure report.
	  * </pre>
	  */
	public VesselReportDBDAOModifyFcmDepRptUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("arr_fwddr_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_doil_sulp_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_mn_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sea_gnr_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_gm_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_blr_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eng_ml_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_doil_sulp_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_low_sulp_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_cntr_obrd_teu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_mid_drft_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_foil_bdr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmn_avg_spd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_mn_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_low_sulp_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_mn_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_blr_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_mn_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr_lod_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_gnr_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_aftdr_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_low_sulp_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_doil_bdr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_mn_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_gm_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_in_ml_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_foil_act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_blr_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_gnr_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_cntr_obrd_teu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_mn_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_out_ml_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_blr_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_dpl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_blr_low_sulp_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_foil_act_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_cntr_obrd_teu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_aftdr_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_blr_low_sulp_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr_dchg_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_blr_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aft_unbrth_ank_drp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spl_doil_bdr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_blr_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr_obrd_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spl_foil_bdr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvgt_ml_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_gnr_low_sulp_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_gnr_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_fwddr_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_mn_low_sulp_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_low_sulp_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_mn_low_sulp_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_gnr_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_doil_act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_foil_sulp_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_gnr_low_sulp_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("plt_in_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rmn_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_mid_drft_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_foil_sulp_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spl_low_sulp_doil_act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_gnr_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOModifyFcmDepRptUSQL").append("\n"); 
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
		query.append("UPDATE FCM_DEP_RPT SET" ).append("\n"); 
		query.append("	VSL_SLAN_CD						=	@[vsl_slan_cd]" ).append("\n"); 
		query.append("	,NVGT_ML_DIST					=	@[nvgt_ml_dist]" ).append("\n"); 
		query.append("	,ENG_ML_DIST					=	@[eng_ml_dist]" ).append("\n"); 
		query.append("	,MNVR_IN_ML_DIST				=	@[mnvr_in_ml_dist]" ).append("\n"); 
		query.append("	,MNVR_OUT_ML_DIST				=	@[mnvr_out_ml_dist]" ).append("\n"); 
		query.append("	,AVG_SPD						=	@[avg_spd]" ).append("\n"); 
		query.append("	,AVG_RPM_PWR					=	@[avg_rpm_pwr]" ).append("\n"); 
		query.append("	,ARR_FOIL_WGT					=	@[arr_foil_wgt]" ).append("\n"); 
		query.append("	,ARR_LOW_SULP_FOIL_WGT			=	@[arr_low_sulp_foil_wgt]" ).append("\n"); 
		query.append("	,ARR_DOIL_WGT					=	@[arr_doil_wgt]" ).append("\n"); 
		query.append("	,ARR_LOW_SULP_DOIL_WGT			=	@[arr_low_sulp_doil_wgt]" ).append("\n"); 
		query.append("	,DEP_FOIL_WGT					=	@[dep_foil_wgt]" ).append("\n"); 
		query.append("	,DEP_LOW_SULP_FOIL_WGT			=	@[dep_low_sulp_foil_wgt]" ).append("\n"); 
		query.append("	,DEP_DOIL_WGT					=	@[dep_doil_wgt]" ).append("\n"); 
		query.append("	,DEP_LOW_SULP_DOIL_WGT			=	@[dep_low_sulp_doil_wgt]" ).append("\n"); 
		query.append("	,SEA_MN_FOIL_CSM_QTY			=	@[sea_mn_foil_csm_qty]" ).append("\n"); 
		query.append("	,SEA_GNR_FOIL_CSM_QTY			=	@[sea_gnr_foil_csm_qty]" ).append("\n"); 
		query.append("	,SEA_BLR_FOIL_CSM_QTY			=	@[sea_blr_foil_csm_qty]" ).append("\n"); 
		query.append("	,SEA_MN_LOW_SULP_FOIL_CSM_QTY	=	@[sea_mn_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("	,SEA_GNR_LOW_SULP_FOIL_CSM_QTY	=	@[sea_gnr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("	,SEA_BLR_LOW_SULP_FOIL_CSM_QTY	=	@[sea_blr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("	,SEA_MN_DOIL_CSM_QTY			=	@[sea_mn_doil_csm_qty]" ).append("\n"); 
		query.append("	,SEA_GNR_DOIL_CSM_QTY			=	@[sea_gnr_doil_csm_qty]" ).append("\n"); 
		query.append("	,SEA_BLR_DOIL_CSM_QTY			=	@[sea_blr_doil_csm_qty]" ).append("\n"); 
		query.append("	,SEA_MN_LOW_SULP_DOIL_CSM_QTY	=	@[sea_mn_low_sulp_doil_csm_qty]" ).append("\n"); 
		query.append("	,SEA_GNR_LOW_SULP_DOIL_CSM_QTY	=	@[sea_gnr_low_sulp_doil_csm_qty]" ).append("\n"); 
		query.append("	,SEA_BLR_LOW_SULP_DOIL_CSM_QTY	=	@[sea_blr_low_sulp_doil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_MN_FOIL_CSM_QTY			=	@[port_mn_foil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_GNR_FOIL_CSM_QTY			=	@[port_gnr_foil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_BLR_FOIL_CSM_QTY			=	@[port_blr_foil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_MN_LOW_SULP_FOIL_CSM_QTY	=	@[port_mn_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_GNR_LOW_SULP_FOIL_CSM_QTY	=	@[port_gnr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_BLR_LOW_SULP_FOIL_CSM_QTY	=	@[port_blr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_MN_DOIL_CSM_QTY			=	@[port_mn_doil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_GNR_DOIL_CSM_QTY			=	@[port_gnr_doil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_BLR_DOIL_CSM_QTY			=	@[port_blr_doil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_MN_LOW_SULP_DOIL_CSM_QTY	=	@[port_mn_low_sulp_doil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_GNR_LOW_SULP_DOIL_CSM_QTY	=	@[port_gnr_low_sulp_doil_csm_qty]" ).append("\n"); 
		query.append("	,PORT_BLR_LOW_SULP_DOIL_CSM_QTY	=	@[port_blr_low_sulp_doil_csm_qty]" ).append("\n"); 
		query.append("	,SPL_FOIL_BDR_WGT				=	@[spl_foil_bdr_wgt]" ).append("\n"); 
		query.append("	,SPL_FOIL_ACT_WGT				=	@[spl_foil_act_wgt]" ).append("\n"); 
		query.append("	,SPL_FOIL_SULP_WGT				=	@[spl_foil_sulp_wgt]" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_FOIL_BDR_WGT		=	@[spl_low_sulp_foil_bdr_wgt]" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_FOIL_ACT_WGT		=	@[spl_low_sulp_foil_act_wgt]" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_FOIL_SULP_WGT		=	@[spl_low_sulp_foil_sulp_wgt]" ).append("\n"); 
		query.append("	,SPL_DOIL_BDR_WGT				=	@[spl_doil_bdr_wgt]" ).append("\n"); 
		query.append("	,SPL_DOIL_ACT_WGT				=	@[spl_doil_act_wgt]" ).append("\n"); 
		query.append("	,SPL_DOIL_SULP_WGT				=	@[spl_doil_sulp_wgt]" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_DOIL_BDR_WGT		=	@[spl_low_sulp_doil_bdr_wgt]" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_DOIL_ACT_WGT		=	@[spl_low_sulp_doil_act_wgt]" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_DOIL_SULP_WGT		=	@[spl_low_sulp_doil_sulp_wgt]" ).append("\n"); 
		query.append("	,NXT_PORT_CD					=	@[nxt_port_cd]" ).append("\n"); 
		query.append("	,NXT_PORT_ETA_DT				=	(CASE WHEN LENGTH(@[nxt_port_eta_dt]      	)<=12 THEN TO_DATE(RPAD(@[nxt_port_eta_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[nxt_port_eta_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,RMN_DIST						=	@[rmn_dist]" ).append("\n"); 
		query.append("	,RMN_AVG_SPD					=	@[rmn_avg_spd]" ).append("\n"); 
		query.append("	,SB_ENG_DT						=	(CASE WHEN LENGTH(@[sb_eng_dt]      		)<=12 THEN TO_DATE(RPAD(@[sb_eng_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[sb_eng_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,PLT_IN_DT						=	(CASE WHEN LENGTH(@[plt_in_dt]      		)<=12 THEN TO_DATE(RPAD(@[plt_in_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[plt_in_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,BFR_BRTH_ANK_DRP_DT			=	(CASE WHEN LENGTH(@[bfr_brth_ank_drp_dt]    )<=12 THEN TO_DATE(RPAD(@[bfr_brth_ank_drp_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[bfr_brth_ank_drp_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,BFR_BRTH_ANK_OFF_DT			=	(CASE WHEN LENGTH(@[bfr_brth_ank_off_dt]    )<=12 THEN TO_DATE(RPAD(@[bfr_brth_ank_off_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[bfr_brth_ank_off_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,VPS_ETB_DT						=	(CASE WHEN LENGTH(@[vps_etb_dt]      		)<=12 THEN TO_DATE(RPAD(@[vps_etb_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[vps_etb_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,CGO_WRK_ST_DT					=	(CASE WHEN LENGTH(@[cgo_wrk_st_dt]      	)<=12 THEN TO_DATE(RPAD(@[cgo_wrk_st_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[cgo_wrk_st_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,CGO_WRK_END_DT					=	(CASE WHEN LENGTH(@[cgo_wrk_end_dt]      	)<=12 THEN TO_DATE(RPAD(@[cgo_wrk_end_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[cgo_wrk_end_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,VPS_ETD_DT						=	(CASE WHEN LENGTH(@[vps_etd_dt]      		)<=12 THEN TO_DATE(RPAD(@[vps_etd_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[vps_etd_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,AFT_UNBRTH_ANK_DRP_DT			=	(CASE WHEN LENGTH(@[aft_unbrth_ank_drp_dt]  )<=12 THEN TO_DATE(RPAD(@[aft_unbrth_ank_drp_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[aft_unbrth_ank_drp_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,AFT_UNBRTH_ANK_OFF_DT			=	(CASE WHEN LENGTH(@[aft_unbrth_ank_off_dt]  )<=12 THEN TO_DATE(RPAD(@[aft_unbrth_ank_off_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[aft_unbrth_ank_off_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,PLT_OUT_DT						=	(CASE WHEN LENGTH(@[plt_out_dt]      		)<=12 THEN TO_DATE(RPAD(@[plt_out_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[plt_out_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,RUP_DT							=	(CASE WHEN LENGTH(@[rup_dt]      			)<=12 THEN TO_DATE(RPAD(@[rup_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[rup_dt]      , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,ARR_FWDDR_HGT					=	@[arr_fwddr_hgt]" ).append("\n"); 
		query.append("	,ARR_MID_DRFT_HGT				=	@[arr_mid_drft_hgt]" ).append("\n"); 
		query.append("	,ARR_AFTDR_HGT					=	@[arr_aftdr_hgt]" ).append("\n"); 
		query.append("	,ARR_GM_HGT						=	@[arr_gm_hgt]" ).append("\n"); 
		query.append("	,DEP_FWDDR_HGT					=	@[dep_fwddr_hgt]" ).append("\n"); 
		query.append("	,DEP_MID_DRFT_HGT				=	@[dep_mid_drft_hgt]" ).append("\n"); 
		query.append("	,DEP_AFTDR_HGT					=	@[dep_aftdr_hgt]" ).append("\n"); 
		query.append("	,DEP_GM_HGT						=	@[dep_gm_hgt]" ).append("\n"); 
		query.append("	,FULL_CNTR_OBRD_TEU				=	@[full_cntr_obrd_teu]" ).append("\n"); 
		query.append("	,MTY_CNTR_OBRD_TEU				=	@[mty_cntr_obrd_teu]" ).append("\n"); 
		query.append("	,TTL_CNTR_OBRD_TEU				=	@[ttl_cntr_obrd_teu]" ).append("\n"); 
		query.append("	,DEP_CGO_WGT					=	@[dep_cgo_wgt]" ).append("\n"); 
		query.append("	,DEP_DPL_WGT					=	@[dep_dpl_wgt]" ).append("\n"); 
		query.append("	,RF_CNTR_DCHG_KNT				=	@[rf_cntr_dchg_knt]" ).append("\n"); 
		query.append("	,RF_CNTR_LOD_KNT				=	@[rf_cntr_lod_knt]" ).append("\n"); 
		query.append("	,RF_CNTR_OBRD_KNT				=	@[rf_cntr_obrd_knt]" ).append("\n"); 
		query.append("	,UPD_USR_ID						=	@[upd_usr_id]" ).append("\n"); 
		query.append("	,UPD_DT							=	SYSDATE" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND DEP_PORT_CD  = @[dep_port_cd]" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 

	}
}