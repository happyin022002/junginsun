/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselReportDBDAOAddFcmDepRptCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.21
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.02.21 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOAddFcmDepRptCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create departure report.
	  * =======================
	  * </pre>
	  */
	public VesselReportDBDAOAddFcmDepRptCSQL(){
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
		params.put("arr_gnr_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fo_slg_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_lod_dchg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_nvgt_ml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_cgo_tp_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_dep_cgo_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("det_rsn_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpl_slg_sp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_blr_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_dnst",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_rob_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("incnr_slg_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_drft_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_mn_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cap_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_drft_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_low_sulp_fuel_csm_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_rsn_for_mgn_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_hld_load_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gmt_td_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_oil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_gnr_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("run_hrs_in_hv_we",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_rob_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_rpm_uusd_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_fuel_csm_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nxt_drpt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cf_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnvr_out_ml_dist",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_lat",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_lat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cgo_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("voy_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_purf_dchg_itval",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_wrk_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_mn_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_low_sulp_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spl_oil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sea_fuel_csm_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_rpm_min_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_arr_plt_mgn_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_slg_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nvgt_ml_dist",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_eng_ml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_blr_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_rpm_uusd_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_sail_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("avg_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_rpm_max_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_arr_plt_mgn_mnts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nxt_rob_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_low_sulp_fuel_csm_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_lon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dpl_slg_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blK_cgo_tp_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_lon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("blk_cgo_tp_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_cgo_tp_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_cgo_tp_cd4",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rmn_sdg_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOAddFcmDepRptCSQL").append("\n"); 
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
		query.append("MERGE INTO FCM_DEP_RPT" ).append("\n"); 
		query.append("USING DUAL ON(" ).append("\n"); 
		query.append("    VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO   = SUBSTR(@[voy_dir_cd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD   = SUBSTR(@[voy_dir_cd], 5, 1)" ).append("\n"); 
		query.append("AND DEP_PORT_CD  = @[dep_port_cd]" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = DECODE(@[clpt_ind_seq], 'F', '1', 'S', '2', 'T', '3')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET " ).append("\n"); 
		query.append("REF_NO                 = @[ref_no]                ," ).append("\n"); 
		query.append("VSL_SLAN_CD            = @[vsl_slan_cd]           ," ).append("\n"); 
		query.append("GMT_TD_HRS             = @[gmt_td_hrs]            ," ).append("\n"); 
		query.append("NXT_PORT_CD            = @[nxt_port_cd]           ," ).append("\n"); 
		query.append("DEP_STS_CD             = @[dep_sts_cd]            ," ).append("\n"); 
		query.append("RMN_DIST               = @[rmn_dist]              ," ).append("\n"); 
		query.append("RMN_AVG_SPD            = @[rmn_avg_spd]           ," ).append("\n"); 
		query.append("NXT_PORT_ETA_DT        = (CASE WHEN LENGTH(@[nxt_port_eta_dt]      )<=12 THEN TO_DATE(RPAD(@[nxt_port_eta_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[nxt_port_eta_dt]      , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("SB_ENG_DT              = (CASE WHEN LENGTH(@[sb_eng_dt]            )<=12 THEN TO_DATE(RPAD(@[sb_eng_dt]            , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[sb_eng_dt]            , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("PLT_IN_DT              = (CASE WHEN LENGTH(@[plt_in_dt]            )<=12 THEN TO_DATE(RPAD(@[plt_in_dt]            , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[plt_in_dt]            , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("BFR_BRTH_ANK_DRP_DT    = (CASE WHEN LENGTH(@[bfr_brth_ank_drp_dt]  )<=12 THEN TO_DATE(RPAD(@[bfr_brth_ank_drp_dt]  , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[bfr_brth_ank_drp_dt]  , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("BFR_BRTH_ANK_OFF_DT    = (CASE WHEN LENGTH(@[bfr_brth_ank_off_dt]  )<=12 THEN TO_DATE(RPAD(@[bfr_brth_ank_off_dt]  , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[bfr_brth_ank_off_dt]  , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("VPS_ETB_DT             = (CASE WHEN LENGTH(@[vps_etb_dt]           )<=12 THEN TO_DATE(RPAD(@[vps_etb_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[vps_etb_dt]           , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("CGO_WRK_ST_DT          = (CASE WHEN LENGTH(@[cgo_wrk_st_dt]        )<=12 THEN TO_DATE(RPAD(@[cgo_wrk_st_dt]        , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[cgo_wrk_st_dt]        , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("CGO_WRK_END_DT         = (CASE WHEN LENGTH(@[cgo_wrk_end_dt]       )<=12 THEN TO_DATE(RPAD(@[cgo_wrk_end_dt]       , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[cgo_wrk_end_dt]       , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("VPS_ETD_DT             = (CASE WHEN LENGTH(@[vps_etd_dt]           )<=12 THEN TO_DATE(RPAD(@[vps_etd_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[vps_etd_dt]           , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("AFT_UNBRTH_ANK_DRP_DT  = (CASE WHEN LENGTH(@[aft_unbrth_ank_drp_dt])<=12 THEN TO_DATE(RPAD(@[aft_unbrth_ank_drp_dt], 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[aft_unbrth_ank_drp_dt], 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("AFT_UNBRTH_ANK_OFF_DT  = (CASE WHEN LENGTH(@[aft_unbrth_ank_off_dt])<=12 THEN TO_DATE(RPAD(@[aft_unbrth_ank_off_dt], 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[aft_unbrth_ank_off_dt], 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("PLT_OUT_DT             = (CASE WHEN LENGTH(@[plt_out_dt]           )<=12 THEN TO_DATE(RPAD(@[plt_out_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[plt_out_dt]           , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("RUP_DT                 = (CASE WHEN LENGTH(@[rup_dt]               )<=12 THEN TO_DATE(RPAD(@[rup_dt]               , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[rup_dt]               , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("MNVR_IN_ML_DIST        = @[mnvr_in_ml_dist]       ," ).append("\n"); 
		query.append("MNVR_OUT_ML_DIST       = @[mnvr_out_ml_dist]      ," ).append("\n"); 
		query.append("NVGT_ML_DIST           = @[nvgt_ml_dist]          ," ).append("\n"); 
		query.append("ENG_ML_DIST            = @[eng_ml_dist]           ," ).append("\n"); 
		query.append("AVG_SPD                = @[avg_spd]               ," ).append("\n"); 
		query.append("AVG_RPM_PWR            = @[avg_rpm_pwr]           ," ).append("\n"); 
		query.append("RUN_HRS_IN_HV_WE       = @[run_hrs_in_hv_we]      ," ).append("\n"); 
		query.append("SEA_DET_RSN_CD1                 = SUBSTR(SUBSTR(@[det_rsn_ctnt], 1,                                INSTR(@[det_rsn_ctnt], '|', 1, 1) - 1), 1, 1)                                      ," ).append("\n"); 
		query.append("SEA_DET_RSN_HRS1                = SUBSTR(SUBSTR(@[det_rsn_ctnt], 1,                                INSTR(@[det_rsn_ctnt], '|', 1, 1) - 1), 2)                                         ," ).append("\n"); 
		query.append("SEA_DET_RSN_CD2                 = SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 1)+1, INSTR(@[det_rsn_ctnt], '|', 1, 2) - INSTR(@[det_rsn_ctnt], '|', 1, 1)-1), 1, 1) ," ).append("\n"); 
		query.append("SEA_DET_RSN_HRS2                = SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 1)+1, INSTR(@[det_rsn_ctnt], '|', 1, 2) - INSTR(@[det_rsn_ctnt], '|', 1, 1)-1), 2)    ," ).append("\n"); 
		query.append("SEA_DET_RSN_CD3                 = SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 2)+1, INSTR(@[det_rsn_ctnt], '|', 1, 3) - INSTR(@[det_rsn_ctnt], '|', 1, 2)-1), 1, 1) ," ).append("\n"); 
		query.append("SEA_DET_RSN_HRS3                = SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 2)+1, INSTR(@[det_rsn_ctnt], '|', 1, 3) - INSTR(@[det_rsn_ctnt], '|', 1, 2)-1), 2)    ," ).append("\n"); 
		query.append("PORT_DET_RSN_CD1                = SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 3)+1, INSTR(@[det_rsn_ctnt], '|', 1, 4) - INSTR(@[det_rsn_ctnt], '|', 1, 3)-1), 1, 1) ," ).append("\n"); 
		query.append("PORT_DET_RSN_HRS1               = SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 3)+1, INSTR(@[det_rsn_ctnt], '|', 1, 4) - INSTR(@[det_rsn_ctnt], '|', 1, 3)-1), 2)    ," ).append("\n"); 
		query.append("PORT_DET_RSN_CD2                = SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 4)+1, INSTR(@[det_rsn_ctnt], '|', 1, 5) - INSTR(@[det_rsn_ctnt], '|', 1, 4)-1), 1, 1) ," ).append("\n"); 
		query.append("PORT_DET_RSN_HRS2               = SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 4)+1, INSTR(@[det_rsn_ctnt], '|', 1, 5) - INSTR(@[det_rsn_ctnt], '|', 1, 4)-1), 2)    ," ).append("\n"); 
		query.append("PORT_DET_RSN_CD3                = SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 5)+1, INSTR(@[det_rsn_ctnt], '|', 1, 6) - INSTR(@[det_rsn_ctnt], '|', 1, 5)-1), 1, 1) ," ).append("\n"); 
		query.append("PORT_DET_RSN_HRS3               = SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 5)+1, INSTR(@[det_rsn_ctnt], '|', 1, 6) - INSTR(@[det_rsn_ctnt], '|', 1, 5)-1), 2)    ," ).append("\n"); 
		query.append("ARR_FWDDR_HGT                   = SUBSTR(@[arr_drft_ctnt],                                 1, INSTR(@[arr_drft_ctnt], '|', 1, 1) -                                 1)                 ," ).append("\n"); 
		query.append("ARR_MID_DRFT_HGT                = SUBSTR(@[arr_drft_ctnt], INSTR(@[arr_drft_ctnt], '|', 1, 1)+1, INSTR(@[arr_drft_ctnt], '|', 1, 2) - INSTR(@[arr_drft_ctnt], '|', 1, 1)-1)           ," ).append("\n"); 
		query.append("ARR_AFTDR_HGT                   = SUBSTR(@[arr_drft_ctnt], INSTR(@[arr_drft_ctnt], '|', 1, 2)+1, INSTR(@[arr_drft_ctnt], '|', 1, 3) - INSTR(@[arr_drft_ctnt], '|', 1, 2)-1)           ," ).append("\n"); 
		query.append("ARR_GM_HGT                      = SUBSTR(@[arr_drft_ctnt], INSTR(@[arr_drft_ctnt], '|', 1, 3)+1, INSTR(@[arr_drft_ctnt], '|', 1, 4) - INSTR(@[arr_drft_ctnt], '|', 1, 3)-1)           ," ).append("\n"); 
		query.append("ARR_FOIL_WGT                    = SUBSTR(@[arr_rob_ctnt],                                1, INSTR(@[arr_rob_ctnt], '|', 1, 1) -                                1)                     ," ).append("\n"); 
		query.append("ARR_DOIL_WGT                    = SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 1)+1, INSTR(@[arr_rob_ctnt], '|', 1, 2) - INSTR(@[arr_rob_ctnt], '|', 1, 1)-1)               ," ).append("\n"); 
		query.append("ARR_FRSH_WTR_WGT                = SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 2)+1, INSTR(@[arr_rob_ctnt], '|', 1, 3) - INSTR(@[arr_rob_ctnt], '|', 1, 2)-1)               ," ).append("\n"); 
		query.append("ARR_BLST_WGT                    = SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 3)+1, INSTR(@[arr_rob_ctnt], '|', 1, 4) - INSTR(@[arr_rob_ctnt], '|', 1, 3)-1)               ," ).append("\n"); 
		query.append("ARR_LOW_SULP_FOIL_WGT           = SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 4)+1, INSTR(@[arr_rob_ctnt], '|', 1, 5) - INSTR(@[arr_rob_ctnt], '|', 1, 4)-1)               ," ).append("\n"); 
		query.append("ARR_LOW_SULP_DOIL_WGT           = SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 5)+1, INSTR(@[arr_rob_ctnt], '|', 1, 6) - INSTR(@[arr_rob_ctnt], '|', 1, 5)-1)               ," ).append("\n"); 
		query.append("DEP_FWDDR_HGT                   = SUBSTR(@[dep_drft_ctnt],                                 1, INSTR(@[dep_drft_ctnt], '|', 1, 1) -                                 1)                 ," ).append("\n"); 
		query.append("DEP_MID_DRFT_HGT                = SUBSTR(@[dep_drft_ctnt], INSTR(@[dep_drft_ctnt], '|', 1, 1)+1, INSTR(@[dep_drft_ctnt], '|', 1, 2) - INSTR(@[dep_drft_ctnt], '|', 1, 1)-1)           ," ).append("\n"); 
		query.append("DEP_AFTDR_HGT                   = SUBSTR(@[dep_drft_ctnt], INSTR(@[dep_drft_ctnt], '|', 1, 2)+1, INSTR(@[dep_drft_ctnt], '|', 1, 3) - INSTR(@[dep_drft_ctnt], '|', 1, 2)-1)           ," ).append("\n"); 
		query.append("DEP_GM_HGT                      = SUBSTR(@[dep_drft_ctnt], INSTR(@[dep_drft_ctnt], '|', 1, 3)+1, INSTR(@[dep_drft_ctnt], '|', 1, 4) - INSTR(@[dep_drft_ctnt], '|', 1, 3)-1)           ," ).append("\n"); 
		query.append("DEP_FOIL_WGT                    = SUBSTR(@[dep_rob_ctnt],                                1, INSTR(@[dep_rob_ctnt], '|', 1, 1) -                                1)                     ," ).append("\n"); 
		query.append("DEP_DOIL_WGT                    = SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 1)+1, INSTR(@[dep_rob_ctnt], '|', 1, 2) - INSTR(@[dep_rob_ctnt], '|', 1, 1)-1)               ," ).append("\n"); 
		query.append("DEP_FRSH_WTR_WGT                = SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 2)+1, INSTR(@[dep_rob_ctnt], '|', 1, 3) - INSTR(@[dep_rob_ctnt], '|', 1, 2)-1)               ," ).append("\n"); 
		query.append("DEP_BLST_WGT                    = SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 3)+1, INSTR(@[dep_rob_ctnt], '|', 1, 4) - INSTR(@[dep_rob_ctnt], '|', 1, 3)-1)               ," ).append("\n"); 
		query.append("DEP_LOW_SULP_FOIL_WGT           = SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 4)+1, INSTR(@[dep_rob_ctnt], '|', 1, 5) - INSTR(@[dep_rob_ctnt], '|', 1, 4)-1)               ," ).append("\n"); 
		query.append("DEP_LOW_SULP_DOIL_WGT           = SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 5)+1, INSTR(@[dep_rob_ctnt], '|', 1, 6) - INSTR(@[dep_rob_ctnt], '|', 1, 5)-1)               ," ).append("\n"); 
		query.append("NXT_FWDDR_HGT                   = SUBSTR(@[nxt_drpt_ctnt],                                 1, INSTR(@[nxt_drpt_ctnt], '|', 1, 1) -                                 1)                 ," ).append("\n"); 
		query.append("NXT_MID_DRFT_HGT                = SUBSTR(@[nxt_drpt_ctnt], INSTR(@[nxt_drpt_ctnt], '|', 1, 1)+1, INSTR(@[nxt_drpt_ctnt], '|', 1, 2) - INSTR(@[nxt_drpt_ctnt], '|', 1, 1)-1)           ," ).append("\n"); 
		query.append("NXT_AFTDR_HGT                   = SUBSTR(@[nxt_drpt_ctnt], INSTR(@[nxt_drpt_ctnt], '|', 1, 2)+1, INSTR(@[nxt_drpt_ctnt], '|', 1, 3) - INSTR(@[nxt_drpt_ctnt], '|', 1, 2)-1)           ," ).append("\n"); 
		query.append("NXT_GM_HGT                      = SUBSTR(@[nxt_drpt_ctnt], INSTR(@[nxt_drpt_ctnt], '|', 1, 3)+1, INSTR(@[nxt_drpt_ctnt], '|', 1, 4) - INSTR(@[nxt_drpt_ctnt], '|', 1, 3)-1)           ," ).append("\n"); 
		query.append("NXT_FOIL_WGT                    = SUBSTR(@[nxt_rob_ctnt],                                1, INSTR(@[nxt_rob_ctnt], '|', 1, 1) -                                1)                     ," ).append("\n"); 
		query.append("NXT_DOIL_WGT                    = SUBSTR(@[nxt_rob_ctnt], INSTR(@[nxt_rob_ctnt], '|', 1, 1)+1, INSTR(@[nxt_rob_ctnt], '|', 1, 2) - INSTR(@[nxt_rob_ctnt], '|', 1, 1)-1)               ," ).append("\n"); 
		query.append("NXT_FRSH_WTR_WGT                = SUBSTR(@[nxt_rob_ctnt], INSTR(@[nxt_rob_ctnt], '|', 1, 2)+1, INSTR(@[nxt_rob_ctnt], '|', 1, 3) - INSTR(@[nxt_rob_ctnt], '|', 1, 2)-1)               ," ).append("\n"); 
		query.append("NXT_BLST_WGT                    = SUBSTR(@[nxt_rob_ctnt], INSTR(@[nxt_rob_ctnt], '|', 1, 3)+1, INSTR(@[nxt_rob_ctnt], '|', 1, 4) - INSTR(@[nxt_rob_ctnt], '|', 1, 3)-1)               ," ).append("\n"); 
		query.append("NXT_LOW_SULP_FOIL_WGT           = SUBSTR(@[nxt_rob_ctnt], INSTR(@[nxt_rob_ctnt], '|', 1, 4)+1, INSTR(@[nxt_rob_ctnt], '|', 1, 5) - INSTR(@[nxt_rob_ctnt], '|', 1, 4)-1)               ," ).append("\n"); 
		query.append("NXT_LOW_SULP_DOIL_WGT           = SUBSTR(@[nxt_rob_ctnt], INSTR(@[nxt_rob_ctnt], '|', 1, 5)+1, INSTR(@[nxt_rob_ctnt], '|', 1, 6) - INSTR(@[nxt_rob_ctnt], '|', 1, 5)-1)               ," ).append("\n"); 
		query.append("SEA_MN_FOIL_CSM_QTY             = SUBSTR(@[sea_fuel_csm_ctnt],                                     1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1) -                                     1)         , " ).append("\n"); 
		query.append("SEA_GNR_FOIL_CSM_QTY            = SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1)-1)   ," ).append("\n"); 
		query.append("SEA_BLR_FOIL_CSM_QTY            = SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2)-1)   ," ).append("\n"); 
		query.append("SEA_MN_DOIL_CSM_QTY             = SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3)-1)   ," ).append("\n"); 
		query.append("SEA_GNR_DOIL_CSM_QTY            = SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4)-1)   ," ).append("\n"); 
		query.append("SEA_BLR_DOIL_CSM_QTY            = SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5)-1)   ," ).append("\n"); 
		query.append("SEA_MN_LOW_SULP_FOIL_CSM_QTY    = SUBSTR(@[sea_low_sulp_fuel_csm_ctnt],                                              1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1) -                                              1)           ," ).append("\n"); 
		query.append("SEA_GNR_LOW_SULP_FOIL_CSM_QTY   = SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1)-1)     ," ).append("\n"); 
		query.append("SEA_BLR_LOW_SULP_FOIL_CSM_QTY   = SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2)-1)     ," ).append("\n"); 
		query.append("SEA_MN_LOW_SULP_DOIL_CSM_QTY    = SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3)-1)     ," ).append("\n"); 
		query.append("SEA_GNR_LOW_SULP_DOIL_CSM_QTY   = SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4)-1)     ," ).append("\n"); 
		query.append("SEA_BLR_LOW_SULP_DOIL_CSM_QTY   = SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5)-1)     ," ).append("\n"); 
		query.append("PORT_MN_FOIL_CSM_QTY            = SUBSTR(@[port_fuel_csm_ctnt],                                      1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 1) -                                      1)                                           ," ).append("\n"); 
		query.append("PORT_GNR_FOIL_CSM_QTY           = SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 1)-1)                                     ," ).append("\n"); 
		query.append("PORT_BLR_FOIL_CSM_QTY           = SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 2)-1)                                     ," ).append("\n"); 
		query.append("PORT_MN_DOIL_CSM_QTY            = SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 3)-1)                                     ," ).append("\n"); 
		query.append("PORT_GNR_DOIL_CSM_QTY           = SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 4)-1)                                     ," ).append("\n"); 
		query.append("PORT_BLR_DOIL_CSM_QTY           = SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 5)-1)                                     ," ).append("\n"); 
		query.append("PORT_MN_LOW_SULP_FOIL_CSM_QTY   = SUBSTR(@[port_low_sulp_fuel_csm_ctnt],                                               1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1) -                                               1)       ," ).append("\n"); 
		query.append("PORT_GNR_LOW_SULP_FOIL_CSM_QTY  = SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1)-1) ," ).append("\n"); 
		query.append("PORT_BLR_LOW_SULP_FOIL_CSM_QTY  = SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2)-1) ," ).append("\n"); 
		query.append("PORT_MN_LOW_SULP_DOIL_CSM_QTY   = SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3)-1) ," ).append("\n"); 
		query.append("PORT_GNR_LOW_SULP_DOIL_CSM_QTY  = SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4)-1) ," ).append("\n"); 
		query.append("PORT_BLR_LOW_SULP_DOIL_CSM_QTY  = SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5)-1) ," ).append("\n"); 
		query.append("SPL_FOIL_BDR_WGT                = SUBSTR(@[spl_oil_ctnt],                                1, INSTR(@[spl_oil_ctnt], '|', 1, 1) -                                1)                                                                   ," ).append("\n"); 
		query.append("SPL_FOIL_ACT_WGT                = SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 1)+1, INSTR(@[spl_oil_ctnt], '|', 1, 2) - INSTR(@[spl_oil_ctnt], '|', 1, 1)-1)                                                             ," ).append("\n"); 
		query.append("SPL_FOIL_SULP_WGT               = SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 2)+1, INSTR(@[spl_oil_ctnt], '|', 1, 3) - INSTR(@[spl_oil_ctnt], '|', 1, 2)-1)                                                             ," ).append("\n"); 
		query.append("SPL_FOIL_BRG_WGT1               = SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 3)+1, INSTR(@[spl_oil_ctnt], '|', 1, 4) - INSTR(@[spl_oil_ctnt], '|', 1, 3)-1)                                                             ," ).append("\n"); 
		query.append("SPL_FOIL_BRG_WGT2               = SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 4)+1, INSTR(@[spl_oil_ctnt], '|', 1, 5) - INSTR(@[spl_oil_ctnt], '|', 1, 4)-1)                                                             ," ).append("\n"); 
		query.append("SPL_DOIL_BDR_WGT                = SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 5)+1, INSTR(@[spl_oil_ctnt], '|', 1, 6) - INSTR(@[spl_oil_ctnt], '|', 1, 5)-1)                                                             ," ).append("\n"); 
		query.append("SPL_DOIL_ACT_WGT                = SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 6)+1, INSTR(@[spl_oil_ctnt], '|', 1, 7) - INSTR(@[spl_oil_ctnt], '|', 1, 6)-1)                                                             ," ).append("\n"); 
		query.append("SPL_DOIL_SULP_WGT               = SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 7)+1, INSTR(@[spl_oil_ctnt], '|', 1, 8) - INSTR(@[spl_oil_ctnt], '|', 1, 7)-1)                                                             ," ).append("\n"); 
		query.append("SPL_DOIL_BRG_WGT1               = SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 8)+1, INSTR(@[spl_oil_ctnt], '|', 1, 9) - INSTR(@[spl_oil_ctnt], '|', 1, 8)-1)                                                             ," ).append("\n"); 
		query.append("SPL_DOIL_BRG_WGT2               = SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 9)+1, INSTR(@[spl_oil_ctnt], '|', 1,10) - INSTR(@[spl_oil_ctnt], '|', 1, 9)-1)                                                             ," ).append("\n"); 
		query.append("SPL_FRSH_WTR_ACT_WGT            = SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1,10)+1, INSTR(@[spl_oil_ctnt], '|', 1,11) - INSTR(@[spl_oil_ctnt], '|', 1,10)-1)                                                             ," ).append("\n"); 
		query.append("SPL_LOW_SULP_FOIL_BDR_WGT       = SUBSTR(@[spl_low_sulp_oil_ctnt],                                         1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1) -                                         1)                               ," ).append("\n"); 
		query.append("SPL_LOW_SULP_FOIL_ACT_WGT       = SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 2) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1)-1)                         ," ).append("\n"); 
		query.append("SPL_LOW_SULP_FOIL_SULP_WGT      = SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 2)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 3) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 2)-1)                         ," ).append("\n"); 
		query.append("SPL_LOW_SULP_FOIL_BRG_WGT1      = SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 3)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 4) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 3)-1)                         ," ).append("\n"); 
		query.append("SPL_LOW_SULP_FOIL_BRG_WGT2      = SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 4)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 5) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 4)-1)                         ," ).append("\n"); 
		query.append("SPL_LOW_SULP_DOIL_BDR_WGT       = SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 5)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 5)-1)                         ," ).append("\n"); 
		query.append("SPL_LOW_SULP_DOIL_ACT_WGT       = SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 7) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6)-1)                         ," ).append("\n"); 
		query.append("SPL_LOW_SULP_DOIL_SULP_WGT      = SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 7)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 8) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 7)-1)                         ," ).append("\n"); 
		query.append("SPL_LOW_SULP_DOIL_BRG_WGT1      = SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 8)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 9) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 8)-1)                         ," ).append("\n"); 
		query.append("SPL_LOW_SULP_DOIL_BRG_WGT2      = SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 9)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1,10) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 9)-1)                         ," ).append("\n"); 
		query.append("SEA_DNST                        = @[sea_dnst]," ).append("\n"); 
		query.append("FULL_CNTR_OBRD_TEU              = SUBSTR(@[cntr_cgo_ctnt],                                 1, INSTR(@[cntr_cgo_ctnt], '|', 1, 1) -                                 1)       ," ).append("\n"); 
		query.append("MTY_CNTR_OBRD_TEU               = SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 1)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 2) - INSTR(@[cntr_cgo_ctnt], '|', 1, 1)-1) ," ).append("\n"); 
		query.append("TTL_CNTR_OBRD_TEU               = SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 2)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 3) - INSTR(@[cntr_cgo_ctnt], '|', 1, 2)-1) ," ).append("\n"); 
		query.append("RF_CNTR_DCHG_KNT                = SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 3)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 4) - INSTR(@[cntr_cgo_ctnt], '|', 1, 3)-1) ," ).append("\n"); 
		query.append("RF_CNTR_LOD_KNT                 = SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 4)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 5) - INSTR(@[cntr_cgo_ctnt], '|', 1, 4)-1) ," ).append("\n"); 
		query.append("RF_CNTR_OBRD_KNT                = SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 5)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 6) - INSTR(@[cntr_cgo_ctnt], '|', 1, 5)-1) ," ).append("\n"); 
		query.append("DEP_CGO_WGT          = @[dep_cgo_wgt], " ).append("\n"); 
		query.append("DEP_DPL_WGT          = @[dep_dpl_wgt]," ).append("\n"); 
		query.append("BLK_LOD_DCHG_STS_CD  = @[blk_lod_dchg_sts_cd]," ).append("\n"); 
		query.append("BLK_CGO_TP_CD1       = @[blk_cgo_tp_cd1]," ).append("\n"); 
		query.append("BLK_CGO_TP_CD2       = @[blk_cgo_tp_cd2]," ).append("\n"); 
		query.append("BLK_CGO_TP_CD3       = @[blk_cgo_tp_cd3]," ).append("\n"); 
		query.append("BLK_CGO_TP_CD4       = @[blk_cgo_tp_cd4]," ).append("\n"); 
		query.append("BLk_CGO_TP_CD5       = @[blK_cgo_tp_cd5]," ).append("\n"); 
		query.append("BLK_HLD_LOAD_QTY1    = SUBSTR(@[blk_hld_load_ctnt],                                     1, INSTR(@[blk_hld_load_ctnt], '|', 1, 1) -                                     1) ," ).append("\n"); 
		query.append("BLK_HLD_LOAD_QTY2    = SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 1)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 2) - INSTR(@[blk_hld_load_ctnt], '|', 1, 1)-1) ," ).append("\n"); 
		query.append("BLK_HLD_LOAD_QTY3    = SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 2)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 3) - INSTR(@[blk_hld_load_ctnt], '|', 1, 2)-1) ," ).append("\n"); 
		query.append("BLK_HLD_LOAD_QTY4    = SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 3)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 4) - INSTR(@[blk_hld_load_ctnt], '|', 1, 3)-1) ," ).append("\n"); 
		query.append("BLK_HLD_LOAD_QTY5    = SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 4)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 5) - INSTR(@[blk_hld_load_ctnt], '|', 1, 4)-1) ," ).append("\n"); 
		query.append("BLK_HLD_LOAD_QTY6    = SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 5)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 6) - INSTR(@[blk_hld_load_ctnt], '|', 1, 5)-1) ," ).append("\n"); 
		query.append("BLK_HLD_LOAD_QTY7    = SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 6)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 7) - INSTR(@[blk_hld_load_ctnt], '|', 1, 6)-1) ," ).append("\n"); 
		query.append("BLK_HLD_LOAD_QTY8    = SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 7)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 8) - INSTR(@[blk_hld_load_ctnt], '|', 1, 7)-1) ," ).append("\n"); 
		query.append("BLK_HLD_LOAD_QTY9    = SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 8)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 9) - INSTR(@[blk_hld_load_ctnt], '|', 1, 8)-1) ," ).append("\n"); 
		query.append("BLK_DEP_CGO_TTL_WGT            = @[blk_dep_cgo_ttl_wgt]," ).append("\n"); 
		query.append("TTL_SLG_WGT                    = @[ttl_slg_wgt]," ).append("\n"); 
		query.append("FO_SLG_WGT                     = @[fo_slg_wgt]," ).append("\n"); 
		query.append("INCNR_SLG_WGT                  = @[incnr_slg_wgt]," ).append("\n"); 
		query.append("DPL_SLG_WGT                    = @[dpl_slg_wgt]," ).append("\n"); 
		query.append("DPL_SLG_SP                     = @[dpl_slg_sp]," ).append("\n"); 
		query.append("RMN_SDG_WGT                    = @[rmn_sdg_wgt]," ).append("\n"); 
		query.append("FOIL_PURF_DCHG_ITVAL           = @[foil_purf_dchg_itval]," ).append("\n"); 
		query.append("DEP_RMK                        = @[dep_rmk]," ).append("\n"); 
		query.append("ARR_LAT                        = @[arr_lat]," ).append("\n"); 
		query.append("ARR_LON                        = @[arr_lon]," ).append("\n"); 
		query.append("ARR_SAIL_HRS                   = @[arr_sail_hrs]," ).append("\n"); 
		query.append("ARR_NVGT_ML                    = @[arr_nvgt_ml]," ).append("\n"); 
		query.append("ARR_ENG_ML                     = @[arr_eng_ml]," ).append("\n"); 
		query.append("ARR_RPM_PWR                    = @[arr_rpm_pwr]," ).append("\n"); 
		query.append("ARR_MN_FOIL_CSM_QTY            = @[arr_mn_foil_csm_qty]," ).append("\n"); 
		query.append("ARR_MN_LOW_SULP_FOIL_CSM_QTY   = @[arr_mn_low_sulp_foil_csm_qty]," ).append("\n"); 
		query.append("ARR_GNR_FOIL_CSM_QTY           = @[arr_gnr_foil_csm_qty]," ).append("\n"); 
		query.append("ARR_GNR_LOW_SULP_FOIL_CSM_QTY  = @[arr_gnr_low_sulp_foil_csm_qty]," ).append("\n"); 
		query.append("ARR_BLR_FOIL_CSM_QTY           = @[arr_blr_foil_csm_qty]," ).append("\n"); 
		query.append("ARR_BLR_LOW_SULP_FOIL_CSM_QTY  = @[arr_blr_low_sulp_foil_csm_qty]," ).append("\n"); 
		query.append("ARR_DOIL_CSM_QTY               = @[arr_doil_csm_qty]," ).append("\n"); 
		query.append("ARR_LOW_SULP_DOIL_CSM_QTY      = @[arr_low_sulp_doil_csm_qty]," ).append("\n"); 
		query.append("DEP_LAT                        = @[dep_lat]," ).append("\n"); 
		query.append("DEP_LON                        = @[dep_lon]," ).append("\n"); 
		query.append("DEP_RPM_PWR                    = @[dep_rpm_pwr]," ).append("\n"); 
		query.append("DEP_RPM_MAX_PWR                = @[dep_rpm_max_pwr]," ).append("\n"); 
		query.append("DEP_RPM_MIN_PWR                = @[dep_rpm_min_pwr]," ).append("\n"); 
		query.append("DEP_RPM_UUSD_FM                = @[dep_rpm_uusd_fm]," ).append("\n"); 
		query.append("DEP_RPM_UUSD_TO                = @[dep_rpm_uusd_to]," ).append("\n"); 
		query.append("DEP_ARR_PLT_MGN_HRS            = @[dep_arr_plt_mgn_hrs]," ).append("\n"); 
		query.append("DEP_ARR_PLT_MGN_MNTS           = @[dep_arr_plt_mgn_mnts]," ).append("\n"); 
		query.append("DEP_RSN_FOR_MGN_TM             = @[dep_rsn_for_mgn_tm]," ).append("\n"); 
		query.append("CAP_NM                         = @[cap_nm]," ).append("\n"); 
		query.append("CF_ENG_NM                      = @[cf_eng_nm]," ).append("\n"); 
		query.append("UPD_USR_ID                     = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT                         = SYSDATE" ).append("\n"); 
		query.append("WHERE VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND   SKD_VOY_NO   = SUBSTR(@[voy_dir_cd], 1, 4)" ).append("\n"); 
		query.append("AND   SKD_DIR_CD   = SUBSTR(@[voy_dir_cd], 5, 1)" ).append("\n"); 
		query.append("AND   DEP_PORT_CD  = @[dep_port_cd]" ).append("\n"); 
		query.append("AND   CLPT_IND_SEQ = DECODE(@[clpt_ind_seq], 'F', '1', 'S', '2', 'T', '3')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("    VSL_CD                          ," ).append("\n"); 
		query.append("    SKD_VOY_NO                      ," ).append("\n"); 
		query.append("    SKD_DIR_CD                      ," ).append("\n"); 
		query.append("    DEP_PORT_CD                     ," ).append("\n"); 
		query.append("    CLPT_IND_SEQ                    ," ).append("\n"); 
		query.append("    REF_NO                          ," ).append("\n"); 
		query.append("    VSL_SLAN_CD                     ," ).append("\n"); 
		query.append("    GMT_TD_HRS                      ," ).append("\n"); 
		query.append("    NXT_PORT_CD                     ," ).append("\n"); 
		query.append("    DEP_STS_CD                      ," ).append("\n"); 
		query.append("    RMN_DIST                        ," ).append("\n"); 
		query.append("    RMN_AVG_SPD                     ," ).append("\n"); 
		query.append("    NXT_PORT_ETA_DT                 ," ).append("\n"); 
		query.append("    SB_ENG_DT                       ," ).append("\n"); 
		query.append("    PLT_IN_DT                       ," ).append("\n"); 
		query.append("    BFR_BRTH_ANK_DRP_DT             ," ).append("\n"); 
		query.append("    BFR_BRTH_ANK_OFF_DT             ," ).append("\n"); 
		query.append("    VPS_ETB_DT                      ," ).append("\n"); 
		query.append("    CGO_WRK_ST_DT                   ," ).append("\n"); 
		query.append("    CGO_WRK_END_DT                  ," ).append("\n"); 
		query.append("    VPS_ETD_DT                      ," ).append("\n"); 
		query.append("    AFT_UNBRTH_ANK_DRP_DT           ," ).append("\n"); 
		query.append("    AFT_UNBRTH_ANK_OFF_DT           ," ).append("\n"); 
		query.append("    PLT_OUT_DT                      ," ).append("\n"); 
		query.append("    RUP_DT                          ," ).append("\n"); 
		query.append("    MNVR_IN_ML_DIST                 ," ).append("\n"); 
		query.append("    MNVR_OUT_ML_DIST                ," ).append("\n"); 
		query.append("    NVGT_ML_DIST                    ," ).append("\n"); 
		query.append("    ENG_ML_DIST                     ," ).append("\n"); 
		query.append("    AVG_SPD                         ," ).append("\n"); 
		query.append("    AVG_RPM_PWR                     ," ).append("\n"); 
		query.append("    RUN_HRS_IN_HV_WE                ," ).append("\n"); 
		query.append("    SEA_DET_RSN_CD1                 ," ).append("\n"); 
		query.append("    SEA_DET_RSN_HRS1                ," ).append("\n"); 
		query.append("    SEA_DET_RSN_CD2                 ," ).append("\n"); 
		query.append("    SEA_DET_RSN_HRS2                ," ).append("\n"); 
		query.append("    SEA_DET_RSN_CD3                 ," ).append("\n"); 
		query.append("    SEA_DET_RSN_HRS3                ," ).append("\n"); 
		query.append("    PORT_DET_RSN_CD1                ," ).append("\n"); 
		query.append("    PORT_DET_RSN_HRS1               ," ).append("\n"); 
		query.append("    PORT_DET_RSN_CD2                ," ).append("\n"); 
		query.append("    PORT_DET_RSN_HRS2               ," ).append("\n"); 
		query.append("    PORT_DET_RSN_CD3                ," ).append("\n"); 
		query.append("    PORT_DET_RSN_HRS3               ," ).append("\n"); 
		query.append("    ARR_FWDDR_HGT                   ," ).append("\n"); 
		query.append("    ARR_MID_DRFT_HGT                ," ).append("\n"); 
		query.append("    ARR_AFTDR_HGT                   ," ).append("\n"); 
		query.append("    ARR_GM_HGT                      ," ).append("\n"); 
		query.append("    ARR_FOIL_WGT                    ," ).append("\n"); 
		query.append("    ARR_DOIL_WGT                    ," ).append("\n"); 
		query.append("    ARR_FRSH_WTR_WGT                ," ).append("\n"); 
		query.append("    ARR_BLST_WGT                    ," ).append("\n"); 
		query.append("    ARR_LOW_SULP_FOIL_WGT           ," ).append("\n"); 
		query.append("    ARR_LOW_SULP_DOIL_WGT           ," ).append("\n"); 
		query.append("    DEP_FWDDR_HGT                   ," ).append("\n"); 
		query.append("    DEP_MID_DRFT_HGT                ," ).append("\n"); 
		query.append("    DEP_AFTDR_HGT                   ," ).append("\n"); 
		query.append("    DEP_GM_HGT                      ," ).append("\n"); 
		query.append("    DEP_FOIL_WGT                    ," ).append("\n"); 
		query.append("    DEP_DOIL_WGT                    ," ).append("\n"); 
		query.append("    DEP_FRSH_WTR_WGT                ," ).append("\n"); 
		query.append("    DEP_BLST_WGT                    ," ).append("\n"); 
		query.append("    DEP_LOW_SULP_FOIL_WGT           ," ).append("\n"); 
		query.append("    DEP_LOW_SULP_DOIL_WGT           ," ).append("\n"); 
		query.append("    NXT_FWDDR_HGT                   ," ).append("\n"); 
		query.append("    NXT_MID_DRFT_HGT                ," ).append("\n"); 
		query.append("    NXT_AFTDR_HGT                   ," ).append("\n"); 
		query.append("    NXT_GM_HGT                      ," ).append("\n"); 
		query.append("    NXT_FOIL_WGT                    ," ).append("\n"); 
		query.append("    NXT_DOIL_WGT                    ," ).append("\n"); 
		query.append("    NXT_FRSH_WTR_WGT                ," ).append("\n"); 
		query.append("    NXT_BLST_WGT                    ," ).append("\n"); 
		query.append("    NXT_LOW_SULP_FOIL_WGT           ," ).append("\n"); 
		query.append("    NXT_LOW_SULP_DOIL_WGT           ," ).append("\n"); 
		query.append("    SEA_MN_FOIL_CSM_QTY             ," ).append("\n"); 
		query.append("    SEA_GNR_FOIL_CSM_QTY            ," ).append("\n"); 
		query.append("    SEA_BLR_FOIL_CSM_QTY            ," ).append("\n"); 
		query.append("    SEA_MN_DOIL_CSM_QTY             ," ).append("\n"); 
		query.append("    SEA_GNR_DOIL_CSM_QTY            ," ).append("\n"); 
		query.append("    SEA_BLR_DOIL_CSM_QTY            ," ).append("\n"); 
		query.append("    SEA_MN_LOW_SULP_FOIL_CSM_QTY    ," ).append("\n"); 
		query.append("    SEA_GNR_LOW_SULP_FOIL_CSM_QTY   ," ).append("\n"); 
		query.append("    SEA_BLR_LOW_SULP_FOIL_CSM_QTY   ," ).append("\n"); 
		query.append("    SEA_MN_LOW_SULP_DOIL_CSM_QTY    ," ).append("\n"); 
		query.append("    SEA_GNR_LOW_SULP_DOIL_CSM_QTY   ," ).append("\n"); 
		query.append("    SEA_BLR_LOW_SULP_DOIL_CSM_QTY   ," ).append("\n"); 
		query.append("    PORT_MN_FOIL_CSM_QTY            ," ).append("\n"); 
		query.append("    PORT_GNR_FOIL_CSM_QTY           ," ).append("\n"); 
		query.append("    PORT_BLR_FOIL_CSM_QTY           ," ).append("\n"); 
		query.append("    PORT_MN_DOIL_CSM_QTY            ," ).append("\n"); 
		query.append("    PORT_GNR_DOIL_CSM_QTY           ," ).append("\n"); 
		query.append("    PORT_BLR_DOIL_CSM_QTY           ," ).append("\n"); 
		query.append("    PORT_MN_LOW_SULP_FOIL_CSM_QTY   ," ).append("\n"); 
		query.append("    PORT_GNR_LOW_SULP_FOIL_CSM_QTY  ," ).append("\n"); 
		query.append("    PORT_BLR_LOW_SULP_FOIL_CSM_QTY  ," ).append("\n"); 
		query.append("    PORT_MN_LOW_SULP_DOIL_CSM_QTY   ," ).append("\n"); 
		query.append("    PORT_GNR_LOW_SULP_DOIL_CSM_QTY  ," ).append("\n"); 
		query.append("    PORT_BLR_LOW_SULP_DOIL_CSM_QTY  ," ).append("\n"); 
		query.append("    SPL_FOIL_BDR_WGT                ," ).append("\n"); 
		query.append("    SPL_FOIL_ACT_WGT                ," ).append("\n"); 
		query.append("    SPL_FOIL_SULP_WGT               ," ).append("\n"); 
		query.append("    SPL_FOIL_BRG_WGT1               ," ).append("\n"); 
		query.append("    SPL_FOIL_BRG_WGT2               ," ).append("\n"); 
		query.append("    SPL_DOIL_BDR_WGT                ," ).append("\n"); 
		query.append("    SPL_DOIL_ACT_WGT                ," ).append("\n"); 
		query.append("    SPL_DOIL_SULP_WGT               ," ).append("\n"); 
		query.append("    SPL_DOIL_BRG_WGT1               ," ).append("\n"); 
		query.append("    SPL_DOIL_BRG_WGT2               ," ).append("\n"); 
		query.append("    SPL_FRSH_WTR_ACT_WGT            ," ).append("\n"); 
		query.append("    SPL_LOW_SULP_FOIL_BDR_WGT       ," ).append("\n"); 
		query.append("    SPL_LOW_SULP_FOIL_ACT_WGT       ," ).append("\n"); 
		query.append("    SPL_LOW_SULP_FOIL_SULP_WGT      ," ).append("\n"); 
		query.append("    SPL_LOW_SULP_FOIL_BRG_WGT1      ," ).append("\n"); 
		query.append("    SPL_LOW_SULP_FOIL_BRG_WGT2      ," ).append("\n"); 
		query.append("    SPL_LOW_SULP_DOIL_BDR_WGT       ," ).append("\n"); 
		query.append("    SPL_LOW_SULP_DOIL_ACT_WGT       ," ).append("\n"); 
		query.append("    SPL_LOW_SULP_DOIL_SULP_WGT      ," ).append("\n"); 
		query.append("    SPL_LOW_SULP_DOIL_BRG_WGT1      ," ).append("\n"); 
		query.append("    SPL_LOW_SULP_DOIL_BRG_WGT2      ," ).append("\n"); 
		query.append("    SEA_DNST                        ," ).append("\n"); 
		query.append("    FULL_CNTR_OBRD_TEU              ," ).append("\n"); 
		query.append("    MTY_CNTR_OBRD_TEU               ," ).append("\n"); 
		query.append("    TTL_CNTR_OBRD_TEU               ," ).append("\n"); 
		query.append("    RF_CNTR_DCHG_KNT                ," ).append("\n"); 
		query.append("    RF_CNTR_LOD_KNT                 ," ).append("\n"); 
		query.append("    RF_CNTR_OBRD_KNT                ," ).append("\n"); 
		query.append("    DEP_CGO_WGT                     ," ).append("\n"); 
		query.append("    DEP_DPL_WGT                     ," ).append("\n"); 
		query.append("    BLK_LOD_DCHG_STS_CD             ," ).append("\n"); 
		query.append("    BLK_CGO_TP_CD1                  ," ).append("\n"); 
		query.append("    BLK_CGO_TP_CD2                  ," ).append("\n"); 
		query.append("    BLK_CGO_TP_CD3                  ," ).append("\n"); 
		query.append("    BLK_CGO_TP_CD4                  ," ).append("\n"); 
		query.append("    BLk_CGO_TP_CD5                  ," ).append("\n"); 
		query.append("    BLK_HLD_LOAD_QTY1               ," ).append("\n"); 
		query.append("    BLK_HLD_LOAD_QTY2               ," ).append("\n"); 
		query.append("    BLK_HLD_LOAD_QTY3               ," ).append("\n"); 
		query.append("    BLK_HLD_LOAD_QTY4               ," ).append("\n"); 
		query.append("    BLK_HLD_LOAD_QTY5               ," ).append("\n"); 
		query.append("    BLK_HLD_LOAD_QTY6               ," ).append("\n"); 
		query.append("    BLK_HLD_LOAD_QTY7               ," ).append("\n"); 
		query.append("    BLK_HLD_LOAD_QTY8               ," ).append("\n"); 
		query.append("    BLK_HLD_LOAD_QTY9               ," ).append("\n"); 
		query.append("    BLK_DEP_CGO_TTL_WGT             ," ).append("\n"); 
		query.append("    TTL_SLG_WGT                     ," ).append("\n"); 
		query.append("    FO_SLG_WGT                      ," ).append("\n"); 
		query.append("    INCNR_SLG_WGT                   ," ).append("\n"); 
		query.append("    DPL_SLG_WGT                     ," ).append("\n"); 
		query.append("    DPL_SLG_SP                      ," ).append("\n"); 
		query.append("    RMN_SDG_WGT                     ," ).append("\n"); 
		query.append("    FOIL_PURF_DCHG_ITVAL            ," ).append("\n"); 
		query.append("    DEP_RMK                         ," ).append("\n"); 
		query.append("    ARR_LAT                         ," ).append("\n"); 
		query.append("    ARR_LON                         ," ).append("\n"); 
		query.append("    ARR_SAIL_HRS                    ," ).append("\n"); 
		query.append("    ARR_NVGT_ML                     ," ).append("\n"); 
		query.append("    ARR_ENG_ML                      ," ).append("\n"); 
		query.append("    ARR_RPM_PWR                     ," ).append("\n"); 
		query.append("    ARR_MN_FOIL_CSM_QTY             ," ).append("\n"); 
		query.append("    ARR_MN_LOW_SULP_FOIL_CSM_QTY    ," ).append("\n"); 
		query.append("    ARR_GNR_FOIL_CSM_QTY            ," ).append("\n"); 
		query.append("    ARR_GNR_LOW_SULP_FOIL_CSM_QTY   ," ).append("\n"); 
		query.append("    ARR_BLR_FOIL_CSM_QTY            ," ).append("\n"); 
		query.append("    ARR_BLR_LOW_SULP_FOIL_CSM_QTY   ," ).append("\n"); 
		query.append("    ARR_DOIL_CSM_QTY                ," ).append("\n"); 
		query.append("    ARR_LOW_SULP_DOIL_CSM_QTY       ," ).append("\n"); 
		query.append("    DEP_LAT                         ," ).append("\n"); 
		query.append("    DEP_LON                         ," ).append("\n"); 
		query.append("    DEP_RPM_PWR                     ," ).append("\n"); 
		query.append("    DEP_RPM_MAX_PWR                 ," ).append("\n"); 
		query.append("    DEP_RPM_MIN_PWR                 ," ).append("\n"); 
		query.append("    DEP_RPM_UUSD_FM                 ," ).append("\n"); 
		query.append("    DEP_RPM_UUSD_TO                 ," ).append("\n"); 
		query.append("    DEP_ARR_PLT_MGN_HRS             ," ).append("\n"); 
		query.append("    DEP_ARR_PLT_MGN_MNTS            ," ).append("\n"); 
		query.append("    DEP_RSN_FOR_MGN_TM              ," ).append("\n"); 
		query.append("    CAP_NM                          ," ).append("\n"); 
		query.append("    CF_ENG_NM                       ," ).append("\n"); 
		query.append("    CRE_USR_ID                      ," ).append("\n"); 
		query.append("    CRE_DT                          ," ).append("\n"); 
		query.append("    UPD_USR_ID                      ," ).append("\n"); 
		query.append("    UPD_DT                          " ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("    @[vsl_cd]                                            ," ).append("\n"); 
		query.append("    SUBSTR(@[voy_dir_cd], 1, 4)                          ," ).append("\n"); 
		query.append("    SUBSTR(@[voy_dir_cd], 5, 1)                          ," ).append("\n"); 
		query.append("    @[dep_port_cd]                                       ," ).append("\n"); 
		query.append("    DECODE(@[clpt_ind_seq], 'F', '1', 'S', '2', 'T', '3')," ).append("\n"); 
		query.append("    @[ref_no]                ," ).append("\n"); 
		query.append("    @[vsl_slan_cd]           ," ).append("\n"); 
		query.append("    @[gmt_td_hrs]            ," ).append("\n"); 
		query.append("    @[nxt_port_cd]           ," ).append("\n"); 
		query.append("    @[dep_sts_cd]            ," ).append("\n"); 
		query.append("    @[rmn_dist]              ," ).append("\n"); 
		query.append("    @[rmn_avg_spd]           ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[nxt_port_eta_dt]      )<=12 THEN TO_DATE(RPAD(@[nxt_port_eta_dt]      , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[nxt_port_eta_dt]      , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[sb_eng_dt]            )<=12 THEN TO_DATE(RPAD(@[sb_eng_dt]            , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[sb_eng_dt]            , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[plt_in_dt]            )<=12 THEN TO_DATE(RPAD(@[plt_in_dt]            , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[plt_in_dt]            , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[bfr_brth_ank_drp_dt]  )<=12 THEN TO_DATE(RPAD(@[bfr_brth_ank_drp_dt]  , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[bfr_brth_ank_drp_dt]  , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[bfr_brth_ank_off_dt]  )<=12 THEN TO_DATE(RPAD(@[bfr_brth_ank_off_dt]  , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[bfr_brth_ank_off_dt]  , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[vps_etb_dt]           )<=12 THEN TO_DATE(RPAD(@[vps_etb_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[vps_etb_dt]           , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[cgo_wrk_st_dt]        )<=12 THEN TO_DATE(RPAD(@[cgo_wrk_st_dt]        , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[cgo_wrk_st_dt]        , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[cgo_wrk_end_dt]       )<=12 THEN TO_DATE(RPAD(@[cgo_wrk_end_dt]       , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[cgo_wrk_end_dt]       , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[vps_etd_dt]           )<=12 THEN TO_DATE(RPAD(@[vps_etd_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[vps_etd_dt]           , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[aft_unbrth_ank_drp_dt])<=12 THEN TO_DATE(RPAD(@[aft_unbrth_ank_drp_dt], 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[aft_unbrth_ank_drp_dt], 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[aft_unbrth_ank_off_dt])<=12 THEN TO_DATE(RPAD(@[aft_unbrth_ank_off_dt], 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[aft_unbrth_ank_off_dt], 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[plt_out_dt]           )<=12 THEN TO_DATE(RPAD(@[plt_out_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[plt_out_dt]           , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    (CASE WHEN LENGTH(@[rup_dt]               )<=12 THEN TO_DATE(RPAD(@[rup_dt]               , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[rup_dt]               , 1, 12), 'YYYYMMDDHH24MI') END) ," ).append("\n"); 
		query.append("    @[mnvr_in_ml_dist]       ," ).append("\n"); 
		query.append("    @[mnvr_out_ml_dist]      ," ).append("\n"); 
		query.append("    @[nvgt_ml_dist]          ," ).append("\n"); 
		query.append("    @[eng_ml_dist]           ," ).append("\n"); 
		query.append("    @[avg_spd]               ," ).append("\n"); 
		query.append("    @[avg_rpm_pwr]           ," ).append("\n"); 
		query.append("    @[run_hrs_in_hv_we]      ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], 1,                                INSTR(@[det_rsn_ctnt], '|', 1, 1) - 1), 1, 1)                                      ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], 1,                                INSTR(@[det_rsn_ctnt], '|', 1, 1) - 1), 2)                                         ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 1)+1, INSTR(@[det_rsn_ctnt], '|', 1, 2) - INSTR(@[det_rsn_ctnt], '|', 1, 1)-1), 1, 1) ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 1)+1, INSTR(@[det_rsn_ctnt], '|', 1, 2) - INSTR(@[det_rsn_ctnt], '|', 1, 1)-1), 2)    ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 2)+1, INSTR(@[det_rsn_ctnt], '|', 1, 3) - INSTR(@[det_rsn_ctnt], '|', 1, 2)-1), 1, 1) ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 2)+1, INSTR(@[det_rsn_ctnt], '|', 1, 3) - INSTR(@[det_rsn_ctnt], '|', 1, 2)-1), 2)    ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 3)+1, INSTR(@[det_rsn_ctnt], '|', 1, 4) - INSTR(@[det_rsn_ctnt], '|', 1, 3)-1), 1, 1) ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 3)+1, INSTR(@[det_rsn_ctnt], '|', 1, 4) - INSTR(@[det_rsn_ctnt], '|', 1, 3)-1), 2)    ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 4)+1, INSTR(@[det_rsn_ctnt], '|', 1, 5) - INSTR(@[det_rsn_ctnt], '|', 1, 4)-1), 1, 1) ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 4)+1, INSTR(@[det_rsn_ctnt], '|', 1, 5) - INSTR(@[det_rsn_ctnt], '|', 1, 4)-1), 2)    ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 5)+1, INSTR(@[det_rsn_ctnt], '|', 1, 6) - INSTR(@[det_rsn_ctnt], '|', 1, 5)-1), 1, 1) ," ).append("\n"); 
		query.append("    SUBSTR(SUBSTR(@[det_rsn_ctnt], INSTR(@[det_rsn_ctnt], '|', 1, 5)+1, INSTR(@[det_rsn_ctnt], '|', 1, 6) - INSTR(@[det_rsn_ctnt], '|', 1, 5)-1), 2)    ," ).append("\n"); 
		query.append("    SUBSTR(@[arr_drft_ctnt],                                 1, INSTR(@[arr_drft_ctnt], '|', 1, 1) -                                 1)                 ," ).append("\n"); 
		query.append("    SUBSTR(@[arr_drft_ctnt], INSTR(@[arr_drft_ctnt], '|', 1, 1)+1, INSTR(@[arr_drft_ctnt], '|', 1, 2) - INSTR(@[arr_drft_ctnt], '|', 1, 1)-1)           ," ).append("\n"); 
		query.append("    SUBSTR(@[arr_drft_ctnt], INSTR(@[arr_drft_ctnt], '|', 1, 2)+1, INSTR(@[arr_drft_ctnt], '|', 1, 3) - INSTR(@[arr_drft_ctnt], '|', 1, 2)-1)           ," ).append("\n"); 
		query.append("    SUBSTR(@[arr_drft_ctnt], INSTR(@[arr_drft_ctnt], '|', 1, 3)+1, INSTR(@[arr_drft_ctnt], '|', 1, 4) - INSTR(@[arr_drft_ctnt], '|', 1, 3)-1)           ," ).append("\n"); 
		query.append("    SUBSTR(@[arr_rob_ctnt],                                1, INSTR(@[arr_rob_ctnt], '|', 1, 1) -                                1)                     ," ).append("\n"); 
		query.append("    SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 1)+1, INSTR(@[arr_rob_ctnt], '|', 1, 2) - INSTR(@[arr_rob_ctnt], '|', 1, 1)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 2)+1, INSTR(@[arr_rob_ctnt], '|', 1, 3) - INSTR(@[arr_rob_ctnt], '|', 1, 2)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 3)+1, INSTR(@[arr_rob_ctnt], '|', 1, 4) - INSTR(@[arr_rob_ctnt], '|', 1, 3)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 4)+1, INSTR(@[arr_rob_ctnt], '|', 1, 5) - INSTR(@[arr_rob_ctnt], '|', 1, 4)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 5)+1, INSTR(@[arr_rob_ctnt], '|', 1, 6) - INSTR(@[arr_rob_ctnt], '|', 1, 5)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[dep_drft_ctnt],                                 1, INSTR(@[dep_drft_ctnt], '|', 1, 1) -                                 1)                 ," ).append("\n"); 
		query.append("    SUBSTR(@[dep_drft_ctnt], INSTR(@[dep_drft_ctnt], '|', 1, 1)+1, INSTR(@[dep_drft_ctnt], '|', 1, 2) - INSTR(@[dep_drft_ctnt], '|', 1, 1)-1)           ," ).append("\n"); 
		query.append("    SUBSTR(@[dep_drft_ctnt], INSTR(@[dep_drft_ctnt], '|', 1, 2)+1, INSTR(@[dep_drft_ctnt], '|', 1, 3) - INSTR(@[dep_drft_ctnt], '|', 1, 2)-1)           ," ).append("\n"); 
		query.append("    SUBSTR(@[dep_drft_ctnt], INSTR(@[dep_drft_ctnt], '|', 1, 3)+1, INSTR(@[dep_drft_ctnt], '|', 1, 4) - INSTR(@[dep_drft_ctnt], '|', 1, 3)-1)           ," ).append("\n"); 
		query.append("    SUBSTR(@[dep_rob_ctnt],                                1, INSTR(@[dep_rob_ctnt], '|', 1, 1) -                                1)                     ," ).append("\n"); 
		query.append("    SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 1)+1, INSTR(@[dep_rob_ctnt], '|', 1, 2) - INSTR(@[dep_rob_ctnt], '|', 1, 1)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 2)+1, INSTR(@[dep_rob_ctnt], '|', 1, 3) - INSTR(@[dep_rob_ctnt], '|', 1, 2)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 3)+1, INSTR(@[dep_rob_ctnt], '|', 1, 4) - INSTR(@[dep_rob_ctnt], '|', 1, 3)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 4)+1, INSTR(@[dep_rob_ctnt], '|', 1, 5) - INSTR(@[dep_rob_ctnt], '|', 1, 4)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 5)+1, INSTR(@[dep_rob_ctnt], '|', 1, 6) - INSTR(@[dep_rob_ctnt], '|', 1, 5)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[nxt_drpt_ctnt],                                 1, INSTR(@[nxt_drpt_ctnt], '|', 1, 1) -                                 1)                 ," ).append("\n"); 
		query.append("    SUBSTR(@[nxt_drpt_ctnt], INSTR(@[nxt_drpt_ctnt], '|', 1, 1)+1, INSTR(@[nxt_drpt_ctnt], '|', 1, 2) - INSTR(@[nxt_drpt_ctnt], '|', 1, 1)-1)           ," ).append("\n"); 
		query.append("    SUBSTR(@[nxt_drpt_ctnt], INSTR(@[nxt_drpt_ctnt], '|', 1, 2)+1, INSTR(@[nxt_drpt_ctnt], '|', 1, 3) - INSTR(@[nxt_drpt_ctnt], '|', 1, 2)-1)           ," ).append("\n"); 
		query.append("    SUBSTR(@[nxt_drpt_ctnt], INSTR(@[nxt_drpt_ctnt], '|', 1, 3)+1, INSTR(@[nxt_drpt_ctnt], '|', 1, 4) - INSTR(@[nxt_drpt_ctnt], '|', 1, 3)-1)           ," ).append("\n"); 
		query.append("    SUBSTR(@[nxt_rob_ctnt],                                1, INSTR(@[nxt_rob_ctnt], '|', 1, 1) -                                1)                     ," ).append("\n"); 
		query.append("    SUBSTR(@[nxt_rob_ctnt], INSTR(@[nxt_rob_ctnt], '|', 1, 1)+1, INSTR(@[nxt_rob_ctnt], '|', 1, 2) - INSTR(@[nxt_rob_ctnt], '|', 1, 1)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[nxt_rob_ctnt], INSTR(@[nxt_rob_ctnt], '|', 1, 2)+1, INSTR(@[nxt_rob_ctnt], '|', 1, 3) - INSTR(@[nxt_rob_ctnt], '|', 1, 2)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[nxt_rob_ctnt], INSTR(@[nxt_rob_ctnt], '|', 1, 3)+1, INSTR(@[nxt_rob_ctnt], '|', 1, 4) - INSTR(@[nxt_rob_ctnt], '|', 1, 3)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[nxt_rob_ctnt], INSTR(@[nxt_rob_ctnt], '|', 1, 4)+1, INSTR(@[nxt_rob_ctnt], '|', 1, 5) - INSTR(@[nxt_rob_ctnt], '|', 1, 4)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[nxt_rob_ctnt], INSTR(@[nxt_rob_ctnt], '|', 1, 5)+1, INSTR(@[nxt_rob_ctnt], '|', 1, 6) - INSTR(@[nxt_rob_ctnt], '|', 1, 5)-1)               ," ).append("\n"); 
		query.append("    SUBSTR(@[sea_fuel_csm_ctnt],                                     1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1) -                                     1)         , " ).append("\n"); 
		query.append("    SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1)-1)   ," ).append("\n"); 
		query.append("    SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2)-1)   ," ).append("\n"); 
		query.append("    SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3)-1)   ," ).append("\n"); 
		query.append("    SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4)-1)   ," ).append("\n"); 
		query.append("    SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5)-1)   ," ).append("\n"); 
		query.append("    SUBSTR(@[sea_low_sulp_fuel_csm_ctnt],                                              1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1) -                                              1)           ," ).append("\n"); 
		query.append("    SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1)-1)     ," ).append("\n"); 
		query.append("    SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2)-1)     ," ).append("\n"); 
		query.append("    SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3)-1)     ," ).append("\n"); 
		query.append("    SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4)-1)     ," ).append("\n"); 
		query.append("    SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5)-1)     ," ).append("\n"); 
		query.append("    SUBSTR(@[port_fuel_csm_ctnt],                                      1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 1) -                                      1)                                           ," ).append("\n"); 
		query.append("    SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 1)-1)                                     ," ).append("\n"); 
		query.append("    SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 2)-1)                                     ," ).append("\n"); 
		query.append("    SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 3)-1)                                     ," ).append("\n"); 
		query.append("    SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 4)-1)                                     ," ).append("\n"); 
		query.append("    SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 5)-1)                                     ," ).append("\n"); 
		query.append("    SUBSTR(@[port_low_sulp_fuel_csm_ctnt],                                               1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1) -                                               1)       ," ).append("\n"); 
		query.append("    SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_oil_ctnt],                                1, INSTR(@[spl_oil_ctnt], '|', 1, 1) -                                1)                                                                   ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 1)+1, INSTR(@[spl_oil_ctnt], '|', 1, 2) - INSTR(@[spl_oil_ctnt], '|', 1, 1)-1)                                                             ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 2)+1, INSTR(@[spl_oil_ctnt], '|', 1, 3) - INSTR(@[spl_oil_ctnt], '|', 1, 2)-1)                                                             ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 3)+1, INSTR(@[spl_oil_ctnt], '|', 1, 4) - INSTR(@[spl_oil_ctnt], '|', 1, 3)-1)                                                             ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 4)+1, INSTR(@[spl_oil_ctnt], '|', 1, 5) - INSTR(@[spl_oil_ctnt], '|', 1, 4)-1)                                                             ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 5)+1, INSTR(@[spl_oil_ctnt], '|', 1, 6) - INSTR(@[spl_oil_ctnt], '|', 1, 5)-1)                                                             ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 6)+1, INSTR(@[spl_oil_ctnt], '|', 1, 7) - INSTR(@[spl_oil_ctnt], '|', 1, 6)-1)                                                             ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 7)+1, INSTR(@[spl_oil_ctnt], '|', 1, 8) - INSTR(@[spl_oil_ctnt], '|', 1, 7)-1)                                                             ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 8)+1, INSTR(@[spl_oil_ctnt], '|', 1, 9) - INSTR(@[spl_oil_ctnt], '|', 1, 8)-1)                                                             ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 9)+1, INSTR(@[spl_oil_ctnt], '|', 1,10) - INSTR(@[spl_oil_ctnt], '|', 1, 9)-1)                                                             ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1,10)+1, INSTR(@[spl_oil_ctnt], '|', 1,11) - INSTR(@[spl_oil_ctnt], '|', 1,10)-1)                                                             ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_low_sulp_oil_ctnt],                                         1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1) -                                         1)                               ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 2) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1)-1)                         ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 2)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 3) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 2)-1)                         ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 3)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 4) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 3)-1)                         ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 4)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 5) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 4)-1)                         ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 5)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 5)-1)                         ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 7) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6)-1)                         ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 7)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 8) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 7)-1)                         ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 8)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 9) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 8)-1)                         ," ).append("\n"); 
		query.append("    SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 9)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1,10) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 9)-1)                         ," ).append("\n"); 
		query.append("    @[sea_dnst]," ).append("\n"); 
		query.append("    SUBSTR(@[cntr_cgo_ctnt],                                 1, INSTR(@[cntr_cgo_ctnt], '|', 1, 1) -                                 1)       ," ).append("\n"); 
		query.append("    SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 1)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 2) - INSTR(@[cntr_cgo_ctnt], '|', 1, 1)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 2)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 3) - INSTR(@[cntr_cgo_ctnt], '|', 1, 2)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 3)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 4) - INSTR(@[cntr_cgo_ctnt], '|', 1, 3)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 4)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 5) - INSTR(@[cntr_cgo_ctnt], '|', 1, 4)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 5)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 6) - INSTR(@[cntr_cgo_ctnt], '|', 1, 5)-1) ," ).append("\n"); 
		query.append("    @[dep_cgo_wgt], " ).append("\n"); 
		query.append("    @[dep_dpl_wgt]," ).append("\n"); 
		query.append("    @[blk_lod_dchg_sts_cd]," ).append("\n"); 
		query.append("    @[blk_cgo_tp_cd1]," ).append("\n"); 
		query.append("    @[blk_cgo_tp_cd2]," ).append("\n"); 
		query.append("    @[blk_cgo_tp_cd3]," ).append("\n"); 
		query.append("    @[blk_cgo_tp_cd4]," ).append("\n"); 
		query.append("    @[blK_cgo_tp_cd5]," ).append("\n"); 
		query.append("    SUBSTR(@[blk_hld_load_ctnt],                                     1, INSTR(@[blk_hld_load_ctnt], '|', 1, 1) -                                     1) ," ).append("\n"); 
		query.append("    SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 1)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 2) - INSTR(@[blk_hld_load_ctnt], '|', 1, 1)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 2)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 3) - INSTR(@[blk_hld_load_ctnt], '|', 1, 2)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 3)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 4) - INSTR(@[blk_hld_load_ctnt], '|', 1, 3)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 4)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 5) - INSTR(@[blk_hld_load_ctnt], '|', 1, 4)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 5)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 6) - INSTR(@[blk_hld_load_ctnt], '|', 1, 5)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 6)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 7) - INSTR(@[blk_hld_load_ctnt], '|', 1, 6)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 7)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 8) - INSTR(@[blk_hld_load_ctnt], '|', 1, 7)-1) ," ).append("\n"); 
		query.append("    SUBSTR(@[blk_hld_load_ctnt], INSTR(@[blk_hld_load_ctnt], '|', 1, 8)+1, INSTR(@[blk_hld_load_ctnt], '|', 1, 9) - INSTR(@[blk_hld_load_ctnt], '|', 1, 8)-1) ," ).append("\n"); 
		query.append("    @[blk_dep_cgo_ttl_wgt]," ).append("\n"); 
		query.append("    @[ttl_slg_wgt]," ).append("\n"); 
		query.append("    @[fo_slg_wgt]," ).append("\n"); 
		query.append("    @[incnr_slg_wgt]," ).append("\n"); 
		query.append("    @[dpl_slg_wgt]," ).append("\n"); 
		query.append("    @[dpl_slg_sp]," ).append("\n"); 
		query.append("    @[rmn_sdg_wgt]," ).append("\n"); 
		query.append("    @[foil_purf_dchg_itval]," ).append("\n"); 
		query.append("    @[dep_rmk]," ).append("\n"); 
		query.append("    @[arr_lat]," ).append("\n"); 
		query.append("    @[arr_lon]," ).append("\n"); 
		query.append("    @[arr_sail_hrs]," ).append("\n"); 
		query.append("    @[arr_nvgt_ml]," ).append("\n"); 
		query.append("    @[arr_eng_ml]," ).append("\n"); 
		query.append("    @[arr_rpm_pwr]," ).append("\n"); 
		query.append("    @[arr_mn_foil_csm_qty]," ).append("\n"); 
		query.append("    @[arr_mn_low_sulp_foil_csm_qty]," ).append("\n"); 
		query.append("    @[arr_gnr_foil_csm_qty]," ).append("\n"); 
		query.append("    @[arr_gnr_low_sulp_foil_csm_qty]," ).append("\n"); 
		query.append("    @[arr_blr_foil_csm_qty]," ).append("\n"); 
		query.append("    @[arr_blr_low_sulp_foil_csm_qty]," ).append("\n"); 
		query.append("    @[arr_doil_csm_qty]," ).append("\n"); 
		query.append("    @[arr_low_sulp_doil_csm_qty]," ).append("\n"); 
		query.append("    @[dep_lat]," ).append("\n"); 
		query.append("    @[dep_lon]," ).append("\n"); 
		query.append("    @[dep_rpm_pwr]," ).append("\n"); 
		query.append("    @[dep_rpm_max_pwr]," ).append("\n"); 
		query.append("    @[dep_rpm_min_pwr]," ).append("\n"); 
		query.append("    @[dep_rpm_uusd_fm]," ).append("\n"); 
		query.append("    @[dep_rpm_uusd_to]," ).append("\n"); 
		query.append("    @[dep_arr_plt_mgn_hrs]," ).append("\n"); 
		query.append("    @[dep_arr_plt_mgn_mnts]," ).append("\n"); 
		query.append("    @[dep_rsn_for_mgn_tm]," ).append("\n"); 
		query.append("    @[cap_nm]," ).append("\n"); 
		query.append("    @[cf_eng_nm]," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}