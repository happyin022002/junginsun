/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselReportDBDAOModifyFcmDepRptLogUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.04 
* 1.0 Creation
* 
* 2014.04.07 박다은 [CHM-201429498] [FCM] Vessel Report Status-Departure Report VMS I/F rule 변경 관련 조치
=========================================================*/
package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOModifyFcmDepRptLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VesselReportDBDAOFcmDepRptLogVOCSQL
	  * </pre>
	  */
	public VesselReportDBDAOModifyFcmDepRptLogUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("incnr_slg_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_mn_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_rsn_for_mgn_tm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cf_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_lat",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_wrk_end_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aft_unbrth_ank_drp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_slg_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_arr_plt_mgn_mnts",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_lon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bfr_brth_ank_drp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("blk_dep_cgo_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dpl_slg_sp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_rpt_tj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_gnr_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_cgo_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_mn_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_arr_plt_mgn_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_rpm_max_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_voy_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("blk_cgo_tp_cd5",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : VesselReportDBDAOModifyFcmDepRptLogUSQL").append("\n"); 
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
		query.append("UPDATE FCM_DEP_RPT_LOG" ).append("\n"); 
		query.append("SET    VSL_CD                        =@[vsl_cd]" ).append("\n"); 
		query.append("      ,VOY_DIR_CD                    =@[voy_dir_cd]" ).append("\n"); 
		query.append("      ,VSL_SLAN_CD                   =@[vsl_slan_cd]" ).append("\n"); 
		query.append("      ,DEP_PORT_CD                   =@[dep_port_cd]" ).append("\n"); 
		query.append("      ,CLPT_IND_SEQ                  =@[clpt_ind_seq]" ).append("\n"); 
		query.append("      ,GMT_TD_HRS                    =@[gmt_td_hrs]" ).append("\n"); 
		query.append("      ,NXT_PORT_CD                   =@[nxt_port_cd]" ).append("\n"); 
		query.append("      ,NXT_PORT_ETA_DT               =(CASE WHEN LENGTH(@[nxt_port_eta_dt])<=12 THEN" ).append("\n"); 
		query.append("                                                TO_DATE(RPAD(@[nxt_port_eta_dt], 12, '0'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                            ELSE" ).append("\n"); 
		query.append("                                                TO_DATE(SUBSTR(@[nxt_port_eta_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("      ,RMN_DIST                      =@[rmn_dist]" ).append("\n"); 
		query.append("      ,RMN_AVG_SPD                   =@[rmn_avg_spd]" ).append("\n"); 
		query.append("      ,ARR_DRFT_CTNT                 =@[arr_drft_ctnt]      " ).append("\n"); 
		query.append("      ,DEP_DRFT_CTNT                 =@[dep_drft_ctnt]      " ).append("\n"); 
		query.append("      ,NXT_DRFT_CTNT                 =@[nxt_drft_ctnt]      " ).append("\n"); 
		query.append("      ,ARR_ROB_CTNT                  =@[arr_rob_ctnt]       " ).append("\n"); 
		query.append("      ,DEP_ROB_CTNT                  =@[dep_rob_ctnt]       " ).append("\n"); 
		query.append("      ,NXT_ROB_CTNT                  =@[nxt_rob_ctnt]       " ).append("\n"); 
		query.append("      ,SPL_OIL_CTNT                  =@[spl_oil_ctnt]       " ).append("\n"); 
		query.append("      ,NVGT_ML_DIST                  =@[nvgt_ml_dist]       " ).append("\n"); 
		query.append("      ,AVG_SPD                       =@[avg_spd]            " ).append("\n"); 
		query.append("      ,AVG_RPM_PWR                   =@[avg_rpm_pwr]        " ).append("\n"); 
		query.append("      ,BLK_LOD_DCHG_STS_CD           =@[blk_lod_dchg_sts_cd]" ).append("\n"); 
		query.append("      ,BLK_CGO_TP_CD1                =@[blk_cgo_tp_cd1]     " ).append("\n"); 
		query.append("      ,BLK_HLD_LOAD_CTNT             =@[blk_hld_load_ctnt]  " ).append("\n"); 
		query.append("      ,SB_ENG_DT                     =(CASE WHEN LENGTH(@[sb_eng_dt])<=12 THEN                              " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[sb_eng_dt], 12, '0'), 'YYYYMMDDHH24MI')     " ).append("\n"); 
		query.append("                                             ELSE                                                           " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[sb_eng_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("      ,PLT_IN_DT                     =(CASE WHEN LENGTH(@[plt_in_dt])<=12 THEN                                   " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[plt_in_dt], 12, '0'), 'YYYYMMDDHH24MI')          " ).append("\n"); 
		query.append("                                             ELSE                                                                " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[plt_in_dt], 1, 12), 'YYYYMMDDHH24MI') END)     " ).append("\n"); 
		query.append("      ,VPS_ETB_DT                    =(CASE WHEN LENGTH(@[vps_etb_dt])<=12 THEN                                  " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[vps_etb_dt], 12, '0'), 'YYYYMMDDHH24MI')         " ).append("\n"); 
		query.append("                                             ELSE                                                                " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[vps_etb_dt], 1, 12), 'YYYYMMDDHH24MI') END)    " ).append("\n"); 
		query.append("      ,CGO_WRK_ST_DT                 =(CASE WHEN LENGTH(@[cgo_wrk_st_dt])<=12 THEN                               " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[cgo_wrk_st_dt], 12, '0'), 'YYYYMMDDHH24MI')      " ).append("\n"); 
		query.append("                                             ELSE                                                                " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[cgo_wrk_st_dt], 1, 12), 'YYYYMMDDHH24MI') END) " ).append("\n"); 
		query.append("      ,CGO_WRK_END_DT                =(CASE WHEN LENGTH(@[cgo_wrk_end_dt])<=12 THEN                              " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[cgo_wrk_end_dt], 12, '0'), 'YYYYMMDDHH24MI')     " ).append("\n"); 
		query.append("                                             ELSE                                                                " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[cgo_wrk_end_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("      ,VPS_ETD_DT                    =(CASE WHEN LENGTH(@[vps_etd_dt])<=12 THEN                                  " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[vps_etd_dt], 12, '0'), 'YYYYMMDDHH24MI')         " ).append("\n"); 
		query.append("                                             ELSE                                                                " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[vps_etd_dt], 1, 12), 'YYYYMMDDHH24MI') END)    " ).append("\n"); 
		query.append("      ,PLT_OUT_DT                    =(CASE WHEN LENGTH(@[plt_out_dt])<=12 THEN                                  " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[plt_out_dt], 12, '0'), 'YYYYMMDDHH24MI')         " ).append("\n"); 
		query.append("                                             ELSE                                                                " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[plt_out_dt], 1, 12), 'YYYYMMDDHH24MI') END)    " ).append("\n"); 
		query.append("      ,RUP_DT                        =(CASE WHEN LENGTH(@[rup_dt])<=12 THEN                                      " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[rup_dt], 12, '0'), 'YYYYMMDDHH24MI')             " ).append("\n"); 
		query.append("                                             ELSE                                                                " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[rup_dt], 1, 12), 'YYYYMMDDHH24MI') END)        " ).append("\n"); 
		query.append("      ,DEP_RMK                       =@[dep_rmk]            " ).append("\n"); 
		query.append("      ,DEP_STS_CD                    =@[dep_sts_cd]         " ).append("\n"); 
		query.append("      ,RUN_HRS_IN_HV_WE              =@[run_hrs_in_hv_we]   " ).append("\n"); 
		query.append("      ,SEA_DNST                      =@[sea_dnst]           " ).append("\n"); 
		query.append("      ,DET_RSN_CTNT                  =@[det_rsn_ctnt]       " ).append("\n"); 
		query.append("      ,ENG_ML_DIST                   =@[eng_ml_dist]        " ).append("\n"); 
		query.append("      ,MNVR_IN_ML_DIST               =@[mnvr_in_ml_dist]    " ).append("\n"); 
		query.append("      ,MNVR_OUT_ML_DIST              =@[mnvr_out_ml_dist]   " ).append("\n"); 
		query.append("      ,BLK_DEP_CGO_TTL_WGT           =@[blk_dep_cgo_ttl_wgt]" ).append("\n"); 
		query.append("      ,BFR_BRTH_ANK_DRP_DT           =(CASE WHEN LENGTH(@[bfr_brth_ank_drp_dt])<=12 THEN                                " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[bfr_brth_ank_drp_dt], 12, '0'), 'YYYYMMDDHH24MI')       " ).append("\n"); 
		query.append("                                             ELSE                                                                       " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[bfr_brth_ank_drp_dt], 1, 12), 'YYYYMMDDHH24MI') END)  " ).append("\n"); 
		query.append("      ,BFR_BRTH_ANK_OFF_DT           =(CASE WHEN LENGTH(@[bfr_brth_ank_off_dt])<=12 THEN                                " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[bfr_brth_ank_off_dt], 12, '0'), 'YYYYMMDDHH24MI')       " ).append("\n"); 
		query.append("                                             ELSE                                                                       " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[bfr_brth_ank_off_dt], 1, 12), 'YYYYMMDDHH24MI') END)  " ).append("\n"); 
		query.append("      ,AFT_UNBRTH_ANK_DRP_DT         =(CASE WHEN LENGTH(@[aft_unbrth_ank_drp_dt])<=12 THEN                              " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[aft_unbrth_ank_drp_dt], 12, '0'), 'YYYYMMDDHH24MI')     " ).append("\n"); 
		query.append("                                             ELSE                                                                       " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[aft_unbrth_ank_drp_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("      ,AFT_UNBRTH_ANK_OFF_DT         =(CASE WHEN LENGTH(@[aft_unbrth_ank_off_dt])<=12 THEN                              " ).append("\n"); 
		query.append("                                                 TO_DATE(RPAD(@[aft_unbrth_ank_off_dt], 12, '0'), 'YYYYMMDDHH24MI')     " ).append("\n"); 
		query.append("                                             ELSE                                                                       " ).append("\n"); 
		query.append("                                                 TO_DATE(SUBSTR(@[aft_unbrth_ank_off_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("      ,SEA_FUEL_CSM_CTNT             =@[sea_fuel_csm_ctnt]          " ).append("\n"); 
		query.append("      ,PORT_FUEL_CSM_CTNT            =@[port_fuel_csm_ctnt]         " ).append("\n"); 
		query.append("      ,REF_NO                        =@[ref_no]                     " ).append("\n"); 
		query.append("      ,CNTR_CGO_CTNT                 =@[cntr_cgo_ctnt]              " ).append("\n"); 
		query.append("      ,BLK_CGO_TP_CD2                =@[blk_cgo_tp_cd2]             " ).append("\n"); 
		query.append("      ,BLK_CGO_TP_CD3                =@[blk_cgo_tp_cd3]             " ).append("\n"); 
		query.append("      ,BLK_CGO_TP_CD4                =@[blk_cgo_tp_cd4]             " ).append("\n"); 
		query.append("      ,BLK_CGO_TP_CD5                =@[blk_cgo_tp_cd5]             " ).append("\n"); 
		query.append("      ,SEA_LOW_SULP_FUEL_CSM_CTNT    =@[sea_low_sulp_fuel_csm_ctnt] " ).append("\n"); 
		query.append("      ,PORT_LOW_SULP_FUEL_CSM_CTNT   =@[port_low_sulp_fuel_csm_ctnt]" ).append("\n"); 
		query.append("      ,SPL_LOW_SULP_OIL_CTNT         =@[spl_low_sulp_oil_ctnt]      " ).append("\n"); 
		query.append("      ,DEP_CGO_WGT                   =@[dep_cgo_wgt]                " ).append("\n"); 
		query.append("      ,DEP_DPL_WGT                   =@[dep_dpl_wgt]                " ).append("\n"); 
		query.append("      ,TTL_SLG_WGT                   =@[ttl_slg_wgt]                " ).append("\n"); 
		query.append("      ,FO_SLG_WGT                    =@[fo_slg_wgt]                 " ).append("\n"); 
		query.append("      ,INCNR_SLG_WGT                 =@[incnr_slg_wgt]              " ).append("\n"); 
		query.append("      ,DPL_SLG_WGT                   =@[dpl_slg_wgt]                " ).append("\n"); 
		query.append("      ,DPL_SLG_SP                    =@[dpl_slg_sp]                 " ).append("\n"); 
		query.append("      ,RMN_SDG_WGT                   =@[rmn_sdg_wgt]                " ).append("\n"); 
		query.append("      ,FOIL_PURF_DCHG_ITVAL          =@[foil_purf_dchg_itval]       " ).append("\n"); 
		query.append("      ,CAP_NM                        =@[cap_nm]                     " ).append("\n"); 
		query.append("      ,CF_ENG_NM                     =@[cf_eng_nm]                  " ).append("\n"); 
		query.append("      ,DEP_LAT                       =@[dep_lat]                    " ).append("\n"); 
		query.append("      ,DEP_LON                       =@[dep_lon]                    " ).append("\n"); 
		query.append("      ,DEP_RPM_PWR                   =@[dep_rpm_pwr]                " ).append("\n"); 
		query.append("      ,DEP_RPM_MAX_PWR               =@[dep_rpm_max_pwr]            " ).append("\n"); 
		query.append("      ,DEP_RPM_MIN_PWR               =@[dep_rpm_min_pwr]            " ).append("\n"); 
		query.append("      ,DEP_RPM_UUSD_FM               =@[dep_rpm_uusd_fm]            " ).append("\n"); 
		query.append("      ,DEP_RPM_UUSD_TO               =@[dep_rpm_uusd_to]            " ).append("\n"); 
		query.append("      ,DEP_ARR_PLT_MGN_HRS           =@[dep_arr_plt_mgn_hrs]        " ).append("\n"); 
		query.append("      ,DEP_ARR_PLT_MGN_MNTS          =@[dep_arr_plt_mgn_mnts]       " ).append("\n"); 
		query.append("      ,DEP_RSN_FOR_MGN_TM            =@[dep_rsn_for_mgn_tm]         " ).append("\n"); 
		query.append("      ,ARR_LAT                       =@[arr_lat]                    " ).append("\n"); 
		query.append("      ,ARR_LON                       =@[arr_lon]                    " ).append("\n"); 
		query.append("      ,ARR_SAIL_HRS                  =@[arr_sail_hrs]               " ).append("\n"); 
		query.append("      ,ARR_NVGT_ML                   =@[arr_nvgt_ml]                " ).append("\n"); 
		query.append("      ,ARR_ENG_ML                    =@[arr_eng_ml]                 " ).append("\n"); 
		query.append("      ,ARR_RPM_PWR                   =@[arr_rpm_pwr]                " ).append("\n"); 
		query.append("      ,ARR_MN_FOIL_CSM_QTY           =@[arr_mn_foil_csm_qty]        " ).append("\n"); 
		query.append("      ,ARR_MN_LOW_SULP_FOIL_CSM_QTY  =@[arr_mn_low_sulp_foil_csm_qty] " ).append("\n"); 
		query.append("      ,ARR_GNR_FOIL_CSM_QTY          =@[arr_gnr_foil_csm_qty]         " ).append("\n"); 
		query.append("      ,ARR_GNR_LOW_SULP_FOIL_CSM_QTY =@[arr_gnr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("      ,ARR_BLR_FOIL_CSM_QTY          =@[arr_blr_foil_csm_qty]         " ).append("\n"); 
		query.append("      ,ARR_BLR_LOW_SULP_FOIL_CSM_QTY =@[arr_blr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("      ,ARR_DOIL_CSM_QTY              =@[arr_doil_csm_qty]             " ).append("\n"); 
		query.append("      ,ARR_LOW_SULP_DOIL_CSM_QTY     =@[arr_low_sulp_doil_csm_qty]    " ).append("\n"); 
		query.append("      ,VSL_RPT_TJ_TP_CD              =@[vsl_rpt_tj_tp_cd]" ).append("\n"); 
		query.append("      ,EAI_IF_ID                     =@[eai_if_id]                    " ).append("\n"); 
		query.append("      ,IF_FLG                        ='N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,OLD_VSL_CD					 =@[old_vsl_cd]" ).append("\n"); 
		query.append("      ,OLD_VOY_DIR_CD				 =@[old_voy_dir_cd]" ).append("\n"); 
		query.append("      ,OLD_VSL_SLAN_CD				 =@[old_vsl_slan_cd]" ).append("\n"); 
		query.append("      ,OLD_DEP_PORT_CD				 =@[old_dep_port_cd]" ).append("\n"); 
		query.append("      ,OLD_CLPT_IND_SEQ				 =@[old_clpt_ind_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,CRE_USR_ID                    =@[cre_usr_id]" ).append("\n"); 
		query.append("      ,CRE_DT                        =SYSDATE      " ).append("\n"); 
		query.append("      ,UPD_USR_ID                    =@[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT                        =SYSDATE      " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND RCV_DT=@[rcv_dt]" ).append("\n"); 
		query.append("AND RCV_SEQ=@[rcv_seq]" ).append("\n"); 

	}
}