/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportDBDAOFcmDepRptLogVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.23 
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

public class VesselReportDBDAOFcmDepRptLogVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FCM_DEP_RPT_LOG - insert
	  * </pre>
	  */
	public VesselReportDBDAOFcmDepRptLogVOCSQL(){
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
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("incnr_slg_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_drft_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_mn_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spl_low_sulp_oil_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rmn_avg_spd ",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_mn_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_rsn_for_mgn_tm ",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aft_unbrth_ank_drp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nxt_drft_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("plt_in_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_lon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("blk_cgo_tp_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmn_sdg_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOFcmDepRptLogVOCSQL").append("\n"); 
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
		query.append("INSERT INTO FCM_DEP_RPT_LOG (" ).append("\n"); 
		query.append("RCV_DT" ).append("\n"); 
		query.append(",RCV_SEQ" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",VOY_DIR_CD" ).append("\n"); 
		query.append(",VSL_SLAN_CD" ).append("\n"); 
		query.append(",DEP_PORT_CD" ).append("\n"); 
		query.append(",CLPT_IND_SEQ" ).append("\n"); 
		query.append(",GMT_TD_HRS" ).append("\n"); 
		query.append(",NXT_PORT_CD" ).append("\n"); 
		query.append(",NXT_PORT_ETA_DT" ).append("\n"); 
		query.append(",RMN_DIST" ).append("\n"); 
		query.append(",RMN_AVG_SPD" ).append("\n"); 
		query.append(",ARR_DRFT_CTNT" ).append("\n"); 
		query.append(",DEP_DRFT_CTNT" ).append("\n"); 
		query.append(",NXT_DRFT_CTNT" ).append("\n"); 
		query.append(",ARR_ROB_CTNT" ).append("\n"); 
		query.append(",DEP_ROB_CTNT" ).append("\n"); 
		query.append(",NXT_ROB_CTNT" ).append("\n"); 
		query.append(",SPL_OIL_CTNT" ).append("\n"); 
		query.append(",NVGT_ML_DIST" ).append("\n"); 
		query.append(",AVG_SPD" ).append("\n"); 
		query.append(",AVG_RPM_PWR" ).append("\n"); 
		query.append(",BLK_LOD_DCHG_STS_CD" ).append("\n"); 
		query.append(",BLK_CGO_TP_CD1" ).append("\n"); 
		query.append(",BLK_HLD_LOAD_CTNT" ).append("\n"); 
		query.append(",SB_ENG_DT" ).append("\n"); 
		query.append(",PLT_IN_DT" ).append("\n"); 
		query.append(",VPS_ETB_DT" ).append("\n"); 
		query.append(",CGO_WRK_ST_DT" ).append("\n"); 
		query.append(",CGO_WRK_END_DT" ).append("\n"); 
		query.append(",VPS_ETD_DT" ).append("\n"); 
		query.append(",PLT_OUT_DT" ).append("\n"); 
		query.append(",RUP_DT" ).append("\n"); 
		query.append(",DEP_RMK" ).append("\n"); 
		query.append(",DEP_STS_CD" ).append("\n"); 
		query.append(",RUN_HRS_IN_HV_WE" ).append("\n"); 
		query.append(",SEA_DNST" ).append("\n"); 
		query.append(",DET_RSN_CTNT" ).append("\n"); 
		query.append(",ENG_ML_DIST" ).append("\n"); 
		query.append(",MNVR_IN_ML_DIST" ).append("\n"); 
		query.append(",MNVR_OUT_ML_DIST" ).append("\n"); 
		query.append(",BLK_DEP_CGO_TTL_WGT" ).append("\n"); 
		query.append(",BFR_BRTH_ANK_DRP_DT" ).append("\n"); 
		query.append(",BFR_BRTH_ANK_OFF_DT" ).append("\n"); 
		query.append(",AFT_UNBRTH_ANK_DRP_DT" ).append("\n"); 
		query.append(",AFT_UNBRTH_ANK_OFF_DT" ).append("\n"); 
		query.append(",SEA_FUEL_CSM_CTNT" ).append("\n"); 
		query.append(",PORT_FUEL_CSM_CTNT" ).append("\n"); 
		query.append(",REF_NO" ).append("\n"); 
		query.append(",CNTR_CGO_CTNT" ).append("\n"); 
		query.append(",BLK_CGO_TP_CD2" ).append("\n"); 
		query.append(",BLK_CGO_TP_CD3" ).append("\n"); 
		query.append(",BLK_CGO_TP_CD4" ).append("\n"); 
		query.append(",BLK_CGO_TP_CD5" ).append("\n"); 
		query.append(",SEA_LOW_SULP_FUEL_CSM_CTNT" ).append("\n"); 
		query.append(",PORT_LOW_SULP_FUEL_CSM_CTNT" ).append("\n"); 
		query.append(",SPL_LOW_SULP_OIL_CTNT" ).append("\n"); 
		query.append(",DEP_CGO_WGT" ).append("\n"); 
		query.append(",DEP_DPL_WGT" ).append("\n"); 
		query.append(",TTL_SLG_WGT" ).append("\n"); 
		query.append(",FO_SLG_WGT" ).append("\n"); 
		query.append(",INCNR_SLG_WGT" ).append("\n"); 
		query.append(",DPL_SLG_WGT" ).append("\n"); 
		query.append(",DPL_SLG_SP" ).append("\n"); 
		query.append(",RMN_SDG_WGT" ).append("\n"); 
		query.append(",FOIL_PURF_DCHG_ITVAL" ).append("\n"); 
		query.append(",CAP_NM" ).append("\n"); 
		query.append(",CF_ENG_NM" ).append("\n"); 
		query.append(",DEP_LAT" ).append("\n"); 
		query.append(",DEP_LON" ).append("\n"); 
		query.append(",DEP_RPM_PWR" ).append("\n"); 
		query.append(",DEP_RPM_MAX_PWR" ).append("\n"); 
		query.append(",DEP_RPM_MIN_PWR" ).append("\n"); 
		query.append(",DEP_RPM_UUSD_FM" ).append("\n"); 
		query.append(",DEP_RPM_UUSD_TO" ).append("\n"); 
		query.append(",DEP_ARR_PLT_MGN_HRS" ).append("\n"); 
		query.append(",DEP_ARR_PLT_MGN_MNTS" ).append("\n"); 
		query.append(",DEP_RSN_FOR_MGN_TM" ).append("\n"); 
		query.append(",ARR_LAT" ).append("\n"); 
		query.append(",ARR_LON" ).append("\n"); 
		query.append(",ARR_SAIL_HRS" ).append("\n"); 
		query.append(",ARR_NVGT_ML" ).append("\n"); 
		query.append(",ARR_ENG_ML" ).append("\n"); 
		query.append(",ARR_RPM_PWR" ).append("\n"); 
		query.append(",ARR_MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",ARR_MN_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",ARR_GNR_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",ARR_GNR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",ARR_BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",ARR_BLR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",ARR_DOIL_CSM_QTY" ).append("\n"); 
		query.append(",ARR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append(",EAI_IF_ID" ).append("\n"); 
		query.append(",IF_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append(" NVL(TO_DATE(@[rcv_dt], 'YYYYMMDDHH24MISS'), SYSDATE)   " ).append("\n"); 
		query.append(",@[rcv_seq]                      " ).append("\n"); 
		query.append(",@[vsl_cd]                                      " ).append("\n"); 
		query.append(",@[voy_dir_cd]                   " ).append("\n"); 
		query.append(",@[vsl_slan_cd]                  " ).append("\n"); 
		query.append(",@[dep_port_cd]                  " ).append("\n"); 
		query.append(",@[clpt_ind_seq]                 " ).append("\n"); 
		query.append(",@[gmt_td_hrs]                   " ).append("\n"); 
		query.append(",@[nxt_port_cd]                  " ).append("\n"); 
		query.append(",@[nxt_port_eta_dt]              " ).append("\n"); 
		query.append(",@[rmn_dist]                    " ).append("\n"); 
		query.append(",@[rmn_avg_spd ]                 " ).append("\n"); 
		query.append(",@[arr_drft_ctnt]                " ).append("\n"); 
		query.append(",@[dep_drft_ctnt]                " ).append("\n"); 
		query.append(",@[nxt_drft_ctnt]                " ).append("\n"); 
		query.append(",@[arr_rob_ctnt]                 " ).append("\n"); 
		query.append(",@[dep_rob_ctnt]                 " ).append("\n"); 
		query.append(",@[nxt_rob_ctnt]                 " ).append("\n"); 
		query.append(",@[spl_oil_ctnt]                 " ).append("\n"); 
		query.append(",@[nvgt_ml_dist]                 " ).append("\n"); 
		query.append(",@[avg_spd]                      " ).append("\n"); 
		query.append(",@[avg_rpm_pwr]                 " ).append("\n"); 
		query.append(",@[blk_lod_dchg_sts_cd]          " ).append("\n"); 
		query.append(",@[blk_cgo_tp_cd1]               " ).append("\n"); 
		query.append(",@[blk_hld_load_ctnt]            " ).append("\n"); 
		query.append(",@[sb_eng_dt]                    " ).append("\n"); 
		query.append(",@[plt_in_dt]                    " ).append("\n"); 
		query.append(",@[vps_etb_dt]                   " ).append("\n"); 
		query.append(",@[cgo_wrk_st_dt]                " ).append("\n"); 
		query.append(",@[cgo_wrk_end_dt]               " ).append("\n"); 
		query.append(",@[vps_etd_dt]                   " ).append("\n"); 
		query.append(",@[plt_out_dt]                   " ).append("\n"); 
		query.append(",@[rup_dt]                       " ).append("\n"); 
		query.append(",@[dep_rmk]                      " ).append("\n"); 
		query.append(",@[dep_sts_cd]                  " ).append("\n"); 
		query.append(",@[run_hrs_in_hv_we]             " ).append("\n"); 
		query.append(",@[sea_dnst]                     " ).append("\n"); 
		query.append(",@[det_rsn_ctnt]                 " ).append("\n"); 
		query.append(",@[eng_ml_dist]                  " ).append("\n"); 
		query.append(",@[mnvr_in_ml_dist]              " ).append("\n"); 
		query.append(",@[mnvr_out_ml_dist]             " ).append("\n"); 
		query.append(",@[blk_dep_cgo_ttl_wgt]          " ).append("\n"); 
		query.append(",@[bfr_brth_ank_drp_dt]          " ).append("\n"); 
		query.append(",@[bfr_brth_ank_off_dt]          " ).append("\n"); 
		query.append(",@[aft_unbrth_ank_drp_dt]        " ).append("\n"); 
		query.append(",@[aft_unbrth_ank_off_dt]        " ).append("\n"); 
		query.append(",@[sea_fuel_csm_ctnt]            " ).append("\n"); 
		query.append(",@[port_fuel_csm_ctnt]           " ).append("\n"); 
		query.append(",@[ref_no]                       " ).append("\n"); 
		query.append(",@[cntr_cgo_ctnt]                " ).append("\n"); 
		query.append(",@[blk_cgo_tp_cd2]               " ).append("\n"); 
		query.append(",@[blk_cgo_tp_cd3]               " ).append("\n"); 
		query.append(",@[blk_cgo_tp_cd4]               " ).append("\n"); 
		query.append(",@[blk_cgo_tp_cd5]               " ).append("\n"); 
		query.append(",@[sea_low_sulp_fuel_csm_ctnt]   " ).append("\n"); 
		query.append(",@[port_low_sulp_fuel_csm_ctnt]  " ).append("\n"); 
		query.append(",@[spl_low_sulp_oil_ctnt]        " ).append("\n"); 
		query.append(",@[dep_cgo_wgt]                  " ).append("\n"); 
		query.append(",@[dep_dpl_wgt]                  " ).append("\n"); 
		query.append(",@[ttl_slg_wgt]                  " ).append("\n"); 
		query.append(",@[fo_slg_wgt]                   " ).append("\n"); 
		query.append(",@[incnr_slg_wgt]                " ).append("\n"); 
		query.append(",@[dpl_slg_wgt]                  " ).append("\n"); 
		query.append(",@[dpl_slg_sp]                   " ).append("\n"); 
		query.append(",@[rmn_sdg_wgt]                  " ).append("\n"); 
		query.append(",@[foil_purf_dchg_itval]         " ).append("\n"); 
		query.append(",@[cap_nm]                       " ).append("\n"); 
		query.append(",@[cf_eng_nm]                    " ).append("\n"); 
		query.append(",@[dep_lat]                      " ).append("\n"); 
		query.append(",@[dep_lon]                      " ).append("\n"); 
		query.append(",@[dep_rpm_pwr]                  " ).append("\n"); 
		query.append(",@[dep_rpm_max_pwr]              " ).append("\n"); 
		query.append(",@[dep_rpm_min_pwr]              " ).append("\n"); 
		query.append(",@[dep_rpm_uusd_fm]              " ).append("\n"); 
		query.append(",@[dep_rpm_uusd_to]              " ).append("\n"); 
		query.append(",@[dep_arr_plt_mgn_hrs]          " ).append("\n"); 
		query.append(",@[dep_arr_plt_mgn_mnts]         " ).append("\n"); 
		query.append(",@[dep_rsn_for_mgn_tm ]          " ).append("\n"); 
		query.append(",@[arr_lat]                      " ).append("\n"); 
		query.append(",@[arr_lon]                      " ).append("\n"); 
		query.append(",@[arr_sail_hrs]                 " ).append("\n"); 
		query.append(",@[arr_nvgt_ml]                  " ).append("\n"); 
		query.append(",@[arr_eng_ml]                   " ).append("\n"); 
		query.append(",@[arr_rpm_pwr]                  " ).append("\n"); 
		query.append(",@[arr_mn_foil_csm_qty]          " ).append("\n"); 
		query.append(",@[arr_mn_low_sulp_foil_csm_qty] " ).append("\n"); 
		query.append(",@[arr_gnr_foil_csm_qty]         " ).append("\n"); 
		query.append(",@[arr_gnr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append(",@[arr_blr_foil_csm_qty]        " ).append("\n"); 
		query.append(",@[arr_blr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append(",@[arr_doil_csm_qty]             " ).append("\n"); 
		query.append(",@[arr_low_sulp_doil_csm_qty]    " ).append("\n"); 
		query.append(",@[eai_if_id]                    " ).append("\n"); 
		query.append(",'Y'                                         " ).append("\n"); 
		query.append(",@[cre_usr_id]                   " ).append("\n"); 
		query.append(",SYSDATE " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}