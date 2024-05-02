/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOAddVskDepRptCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.03.09 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOAddVskDepRptCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VMS 시스템에서 입력 받은 Departure Report를 생성한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOAddVskDepRptCSQL(){
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
		params.put("port_blr_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_mn_low_sulp_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nvgt_dist",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sea_gnr_low_sulp_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_mn_low_sulp_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_mid_drft_hgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_blr_low_sulp_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_mn_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_frsh_wtr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_gnr_low_sulp_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_aftdr_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_gm_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_blr_low_sulp_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sea_mn_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plt_lst_unld_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_gnr_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_mn_low_sulp_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_gnr_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_mn_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_aftdr_hgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_mn_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_slg_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crn_wrk_cmpl_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_gnr_low_sulp_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_blr_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_gnr_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spl_low_sulp_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_frsh_wtr_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_blr_low_sulp_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_gnr_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crn_wrk_cmnc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_blst_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_blr_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_mid_drft_hgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sea_blr_low_sulp_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_blr_fuel_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_low_sulp_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_blst_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_mn_low_sulp_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_gnr_low_sulp_dzl_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spl_frsh_wtr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOAddVskDepRptCSQL").append("\n"); 
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
		query.append("MERGE INTO VSK_DEP_RPT A" ).append("\n"); 
		query.append("USING DUAL ON (A.VSL_CD           = @[vsl_cd]	" ).append("\n"); 
		query.append("               AND A.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("               AND A.SKD_DIR_CD   = @[skd_dir_cd]	" ).append("\n"); 
		query.append("               AND A.VPS_PORT_CD  = @[vps_port_cd]" ).append("\n"); 
		query.append("			   AND A.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("			   )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      UPDATE SET " ).append("\n"); 
		query.append("		 NXT_PORT_CD                    =		@[nxt_port_cd]                                       " ).append("\n"); 
		query.append("		,NXT_PORT_ETA_DT                =		TO_DATE(@[nxt_port_eta_dt], 'YYYYMMDDHH24MISS')      " ).append("\n"); 
		query.append("		,RMN_DIST                       =		NVL(@[rmn_dist]                 , 0)                          " ).append("\n"); 
		query.append("		,RMN_AVG_SPD                    =		NVL(@[rmn_avg_spd]              , 0)                          " ).append("\n"); 
		query.append("		,ARR_FWDDR_HGT                  =		NVL(@[arr_fwddr_hgt]            , 0)                          " ).append("\n"); 
		query.append("		,ARR_MID_DRFT_HGT               =		NVL(@[arr_mid_drft_hgt]         , 0)                          " ).append("\n"); 
		query.append("		,ARR_AFTDR_HGT                  =		NVL(@[arr_aftdr_hgt]            , 0)                          " ).append("\n"); 
		query.append("		,ARR_GM_HGT                     =		NVL(@[arr_gm_hgt]               , 0)                          " ).append("\n"); 
		query.append("		,ARR_FOIL_WGT                   =		NVL(@[arr_foil_wgt]             , 0)                          " ).append("\n"); 
		query.append("		,ARR_DOIL_WGT                   =		NVL(@[arr_doil_wgt]             , 0)                          " ).append("\n"); 
		query.append("		,ARR_FRSH_WTR_WGT               =		NVL(@[arr_frsh_wtr_wgt]         , 0)                          " ).append("\n"); 
		query.append("		,ARR_BLST_WGT                   =		NVL(@[arr_blst_wgt]             , 0)                          " ).append("\n"); 
		query.append("		,ARR_LOW_SULP_FOIL_WGT          =		NVL(@[arr_low_sulp_foil_wgt]    , 0)                          " ).append("\n"); 
		query.append("		,ARR_LOW_SULP_DOIL_WGT          =		NVL(@[arr_low_sulp_doil_wgt]    , 0)                          " ).append("\n"); 
		query.append("		,DEP_FWDDR_HGT                  =		NVL(@[dep_fwddr_hgt]            , 0)                          " ).append("\n"); 
		query.append("		,DEP_MID_DRFT_HGT               =		NVL(@[dep_mid_drft_hgt]         , 0)                          " ).append("\n"); 
		query.append("		,DEP_AFTDR_HGT                  =		NVL(@[dep_aftdr_hgt]            , 0)                          " ).append("\n"); 
		query.append("		,DEP_GM_HGT                     =		NVL(@[dep_gm_hgt]               , 0)                          " ).append("\n"); 
		query.append("		,DEP_FOIL_WGT                   =		NVL(@[dep_foil_wgt]             , 0)                          " ).append("\n"); 
		query.append("		,DEP_DOIL_WGT                   =		NVL(@[dep_doil_wgt]             , 0)                          " ).append("\n"); 
		query.append("		,DEP_FRSH_WTR_WGT               =		NVL(@[dep_frsh_wtr_wgt]         , 0)                          " ).append("\n"); 
		query.append("		,DEP_BLST_WGT                   =		NVL(@[dep_blst_wgt]             , 0)                          " ).append("\n"); 
		query.append("		,DEP_LOW_SULP_FOIL_WGT          =		NVL(@[dep_low_sulp_foil_wgt]    , 0)                          " ).append("\n"); 
		query.append("		,DEP_LOW_SULP_DOIL_WGT          =		NVL(@[dep_low_sulp_doil_wgt]    , 0)                          " ).append("\n"); 
		query.append("		,SPL_FOIL_WGT                   =		NVL(@[spl_foil_wgt]             , 0)                          " ).append("\n"); 
		query.append("		,SPL_DOIL_WGT                   =		NVL(@[spl_doil_wgt]             , 0)                          " ).append("\n"); 
		query.append("		,SPL_FRSH_WTR_WGT               =		NVL(@[spl_frsh_wtr_wgt]         , 0)                          " ).append("\n"); 
		query.append("		,SPL_LOW_SULP_FOIL_WGT          =		NVL(@[spl_low_sulp_foil_wgt]    , 0)                          " ).append("\n"); 
		query.append("		,SPL_LOW_SULP_DOIL_WGT          =		NVL(@[spl_low_sulp_doil_wgt]    , 0)                          " ).append("\n"); 
		query.append("		,NVGT_DIST                      =		NVL(@[nvgt_dist]                , 0)                          " ).append("\n"); 
		query.append("		,ENG_ML_DIST                    =		NVL(@[eng_ml_dist]              , 0)                          " ).append("\n"); 
		query.append("		,AVG_SPD                        =		NVL(@[avg_spd]                  , 0)                          " ).append("\n"); 
		query.append("		,AVG_RPM_PWR                    =		NVL(@[avg_rpm_pwr]              , 0)                          " ).append("\n"); 
		query.append("		,ACT_BRTH_DT                    =		TO_DATE(@[act_brth_dt], 'YYYYMMDDHH24MISS')          " ).append("\n"); 
		query.append("		,CRN_WRK_CMNC_DT                =		TO_DATE(@[crn_wrk_cmnc_dt], 'YYYYMMDDHH24MISS')      " ).append("\n"); 
		query.append("		,CRN_WRK_CMPL_DT                =		TO_DATE(@[crn_wrk_cmpl_dt], 'YYYYMMDDHH24MISS')      " ).append("\n"); 
		query.append("		,ACT_DEP_DT                     =		TO_DATE(@[act_dep_dt], 'YYYYMMDDHH24MISS')           " ).append("\n"); 
		query.append("		,MNVR_IN_ML_DIST                =		NVL(@[mnvr_in_ml_dist]          , 0)" ).append("\n"); 
		query.append("		,MNVR_OUT_ML_DIST               =		NVL(@[mnvr_out_ml_dist]         , 0)" ).append("\n"); 
		query.append("		,BFR_BRTH_ANK_DRP_DT            =		TO_DATE(@[bfr_brth_ank_drp_dt], 'YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("		,BFR_BRTH_ANK_OFF_DT            =		TO_DATE(@[bfr_brth_ank_off_dt], 'YYYYMMDDHH24MISS')  " ).append("\n"); 
		query.append("		,AFT_UNBRTH_ANK_DRP_DT          =		TO_DATE(@[aft_unbrth_ank_drp_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,AFT_UNBRTH_ANK_OFF_DT          =		TO_DATE(@[aft_unbrth_ank_off_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,SEA_MN_FUEL_CSM_WGT            =		NVL(@[sea_mn_fuel_csm_wgt]               , 0)" ).append("\n"); 
		query.append("		,SEA_GNR_FUEL_CSM_WGT           =		NVL(@[sea_gnr_fuel_csm_wgt]              , 0)" ).append("\n"); 
		query.append("		,SEA_BLR_FUEL_CSM_WGT           =		NVL(@[sea_blr_fuel_csm_wgt]              , 0)" ).append("\n"); 
		query.append("		,SEA_MN_DZL_CSM_WGT             =		NVL(@[sea_mn_dzl_csm_wgt]                , 0)" ).append("\n"); 
		query.append("		,SEA_GNR_DZL_CSM_WGT            =		NVL(@[sea_gnr_dzl_csm_wgt]               , 0)" ).append("\n"); 
		query.append("		,SEA_BLR_DZL_CSM_WGT            =		NVL(@[sea_blr_dzl_csm_wgt]               , 0)" ).append("\n"); 
		query.append("		,SEA_MN_LOW_SULP_FUEL_CSM_WGT   =		NVL(@[sea_mn_low_sulp_fuel_csm_wgt]      , 0)" ).append("\n"); 
		query.append("		,SEA_GNR_LOW_SULP_FUEL_CSM_WGT  =		NVL(@[sea_gnr_low_sulp_fuel_csm_wgt]     , 0)" ).append("\n"); 
		query.append("		,SEA_BLR_LOW_SULP_FUEL_CSM_WGT  =		NVL(@[sea_blr_low_sulp_fuel_csm_wgt]     , 0)" ).append("\n"); 
		query.append("		,SEA_MN_LOW_SULP_DZL_CSM_WGT    =		NVL(@[sea_mn_low_sulp_dzl_csm_wgt]       , 0)" ).append("\n"); 
		query.append("		,SEA_GNR_LOW_SULP_DZL_CSM_WGT   =		NVL(@[sea_gnr_low_sulp_dzl_csm_wgt]      , 0)" ).append("\n"); 
		query.append("		,SEA_BLR_LOW_SULP_DZL_CSM_WGT   =		NVL(@[sea_blr_low_sulp_dzl_csm_wgt]      , 0)" ).append("\n"); 
		query.append("		,PORT_MN_FUEL_CSM_WGT           =		NVL(@[port_mn_fuel_csm_wgt]              , 0)" ).append("\n"); 
		query.append("		,PORT_GNR_FUEL_CSM_WGT          =		NVL(@[port_gnr_fuel_csm_wgt]             , 0)" ).append("\n"); 
		query.append("		,PORT_BLR_FUEL_CSM_WGT          =		NVL(@[port_blr_fuel_csm_wgt]             , 0)" ).append("\n"); 
		query.append("		,PORT_MN_DZL_CSM_WGT            =		NVL(@[port_mn_dzl_csm_wgt]               , 0)" ).append("\n"); 
		query.append("		,PORT_GNR_DZL_CSM_WGT           =		NVL(@[port_gnr_dzl_csm_wgt]              , 0)" ).append("\n"); 
		query.append("		,PORT_BLR_DZL_CSM_WGT           =		NVL(@[port_blr_dzl_csm_wgt]              , 0)" ).append("\n"); 
		query.append("		,PORT_MN_LOW_SULP_FUEL_CSM_WGT  =		NVL(@[port_mn_low_sulp_fuel_csm_wgt]     , 0)" ).append("\n"); 
		query.append("		,PORT_GNR_LOW_SULP_FUEL_CSM_WGT =		NVL(@[port_gnr_low_sulp_fuel_csm_wgt]    , 0)" ).append("\n"); 
		query.append("		,PORT_BLR_LOW_SULP_FUEL_CSM_WGT =		NVL(@[port_blr_low_sulp_fuel_csm_wgt]    , 0)" ).append("\n"); 
		query.append("		,PORT_MN_LOW_SULP_DZL_CSM_WGT   =		NVL(@[port_mn_low_sulp_dzl_csm_wgt]      , 0)" ).append("\n"); 
		query.append("		,PORT_GNR_LOW_SULP_DZL_CSM_WGT  =		NVL(@[port_gnr_low_sulp_dzl_csm_wgt]     , 0)" ).append("\n"); 
		query.append("		,PORT_BLR_LOW_SULP_DZL_CSM_WGT  =		NVL(@[port_blr_low_sulp_dzl_csm_wgt]     , 0)" ).append("\n"); 
		query.append("		,ACT_ARR_DT                     =		TO_DATE(@[act_arr_dt], 'YYYYMMDDHH24MISS')           " ).append("\n"); 
		query.append("		,PLT_LST_UNLD_DT                =		TO_DATE(@[plt_lst_unld_dt], 'YYYYMMDDHH24MISS')      " ).append("\n"); 
		query.append("		,TTL_SLG_WGT                    =		NVL(@[ttl_slg_wgt]                       , 0)" ).append("\n"); 
		query.append("		,UPD_USR_ID                     =		@[cre_usr_id]                                        " ).append("\n"); 
		query.append("		,UPD_DT                         =		SYSDATE                                                 " ).append("\n"); 
		query.append("      WHERE  1=1" ).append("\n"); 
		query.append("      AND    A.VSL_CD      = @[vsl_cd]	" ).append("\n"); 
		query.append("      AND    A.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("      AND    A.SKD_DIR_CD  = @[skd_dir_cd]	" ).append("\n"); 
		query.append("      AND    A.VPS_PORT_CD  = @[vps_port_cd] " ).append("\n"); 
		query.append("	  AND    A.CLPT_IND_SEQ = @[clpt_ind_seq] " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	INSERT (" ).append("\n"); 
		query.append("		 VSL_CD                         --VARCHAR2(4) not null,     " ).append("\n"); 
		query.append("		,SKD_VOY_NO                     --VARCHAR2(4) not null,     " ).append("\n"); 
		query.append("		,SKD_DIR_CD                     --VARCHAR2(1) not null,     " ).append("\n"); 
		query.append("		,VPS_PORT_CD                    --VARCHAR2(5) not null,     " ).append("\n"); 
		query.append("		,CLPT_IND_SEQ                   --VARCHAR2(2) not null,     " ).append("\n"); 
		query.append("		,NXT_PORT_CD                    --VARCHAR2(5),              " ).append("\n"); 
		query.append("		,NXT_PORT_ETA_DT                --DATE,                     " ).append("\n"); 
		query.append("		,RMN_DIST                       --NUMBER(6) default 0,      " ).append("\n"); 
		query.append("		,RMN_AVG_SPD                    --NUMBER(5,3) default 0,    " ).append("\n"); 
		query.append("		,ARR_FWDDR_HGT                  --NUMBER(8,3) default 0,    " ).append("\n"); 
		query.append("		,ARR_MID_DRFT_HGT               --NUMBER(8,3) default 0,    " ).append("\n"); 
		query.append("		,ARR_AFTDR_HGT                  --NUMBER(8,3) default 0,    " ).append("\n"); 
		query.append("		,ARR_GM_HGT                     --NUMBER(8,3) default 0,    " ).append("\n"); 
		query.append("		,ARR_FOIL_WGT                   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,ARR_DOIL_WGT                   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,ARR_FRSH_WTR_WGT               --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,ARR_BLST_WGT                   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,ARR_LOW_SULP_FOIL_WGT          --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,ARR_LOW_SULP_DOIL_WGT          --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,DEP_FWDDR_HGT                  --NUMBER(8,3) default 0,    " ).append("\n"); 
		query.append("		,DEP_MID_DRFT_HGT               --NUMBER(8,3) default 0,    " ).append("\n"); 
		query.append("		,DEP_AFTDR_HGT                  --NUMBER(8,3) default 0,    " ).append("\n"); 
		query.append("		,DEP_GM_HGT                     --NUMBER(8,3) default 0,    " ).append("\n"); 
		query.append("		,DEP_FOIL_WGT                   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,DEP_DOIL_WGT                   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,DEP_FRSH_WTR_WGT               --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,DEP_BLST_WGT                   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,DEP_LOW_SULP_FOIL_WGT          --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,DEP_LOW_SULP_DOIL_WGT          --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SPL_FOIL_WGT                   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SPL_DOIL_WGT                   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SPL_FRSH_WTR_WGT               --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SPL_LOW_SULP_FOIL_WGT          --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SPL_LOW_SULP_DOIL_WGT          --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,NVGT_DIST                      --NUMBER(6) default 0,      " ).append("\n"); 
		query.append("		,ENG_ML_DIST                    --NUMBER(6) default 0,      " ).append("\n"); 
		query.append("		,AVG_SPD                        --NUMBER(5,3) default 0,    " ).append("\n"); 
		query.append("		,AVG_RPM_PWR                    --NUMBER(6) default 0,      " ).append("\n"); 
		query.append("		,ACT_BRTH_DT                    --DATE,                     " ).append("\n"); 
		query.append("		,CRN_WRK_CMNC_DT                --DATE,                     " ).append("\n"); 
		query.append("		,CRN_WRK_CMPL_DT                --DATE,                     " ).append("\n"); 
		query.append("		,ACT_DEP_DT                     --DATE,                     " ).append("\n"); 
		query.append("		,MNVR_IN_ML_DIST                --NUMBER(6) default 0,      " ).append("\n"); 
		query.append("		,MNVR_OUT_ML_DIST               --NUMBER(6) default 0,      " ).append("\n"); 
		query.append("		,BFR_BRTH_ANK_DRP_DT            --DATE,                     " ).append("\n"); 
		query.append("		,BFR_BRTH_ANK_OFF_DT            --DATE,                     " ).append("\n"); 
		query.append("		,AFT_UNBRTH_ANK_DRP_DT          --DATE,                     " ).append("\n"); 
		query.append("		,AFT_UNBRTH_ANK_OFF_DT          --DATE,                     " ).append("\n"); 
		query.append("		,SEA_MN_FUEL_CSM_WGT            --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SEA_GNR_FUEL_CSM_WGT           --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SEA_BLR_FUEL_CSM_WGT           --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SEA_MN_DZL_CSM_WGT             --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SEA_GNR_DZL_CSM_WGT            --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SEA_BLR_DZL_CSM_WGT            --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SEA_MN_LOW_SULP_FUEL_CSM_WGT   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SEA_GNR_LOW_SULP_FUEL_CSM_WGT  --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SEA_BLR_LOW_SULP_FUEL_CSM_WGT  --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SEA_MN_LOW_SULP_DZL_CSM_WGT    --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SEA_GNR_LOW_SULP_DZL_CSM_WGT   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,SEA_BLR_LOW_SULP_DZL_CSM_WGT   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_MN_FUEL_CSM_WGT           --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_GNR_FUEL_CSM_WGT          --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_BLR_FUEL_CSM_WGT          --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_MN_DZL_CSM_WGT            --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_GNR_DZL_CSM_WGT           --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_BLR_DZL_CSM_WGT           --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_MN_LOW_SULP_FUEL_CSM_WGT  --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_GNR_LOW_SULP_FUEL_CSM_WGT --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_BLR_LOW_SULP_FUEL_CSM_WGT --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_MN_LOW_SULP_DZL_CSM_WGT   --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_GNR_LOW_SULP_DZL_CSM_WGT  --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,PORT_BLR_LOW_SULP_DZL_CSM_WGT  --NUMBER(13,3) default 0,   " ).append("\n"); 
		query.append("		,CRE_USR_ID                     --VARCHAR2(20) not null,    " ).append("\n"); 
		query.append("		,CRE_DT                         --DATE default SYSDATE not n" ).append("\n"); 
		query.append("		,UPD_USR_ID                     --VARCHAR2(20) not null,    " ).append("\n"); 
		query.append("		,UPD_DT                         --DATE default SYSDATE not n" ).append("\n"); 
		query.append("		,ACT_ARR_DT                     --DATE,                     " ).append("\n"); 
		query.append("		,PLT_LST_UNLD_DT                --DATE,                     " ).append("\n"); 
		query.append("		,TTL_SLG_WGT                    --NUMBER(13,3) default 0    " ).append("\n"); 
		query.append("	) VALUES( " ).append("\n"); 
		query.append("		 @[vsl_cd]" ).append("\n"); 
		query.append("		,@[skd_voy_no]" ).append("\n"); 
		query.append("		,@[skd_dir_cd]" ).append("\n"); 
		query.append("		,@[vps_port_cd]" ).append("\n"); 
		query.append("		,@[clpt_ind_seq]" ).append("\n"); 
		query.append("		,@[nxt_port_cd]" ).append("\n"); 
		query.append("		,TO_DATE(@[nxt_port_eta_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,NVL(@[rmn_dist]                , 0)" ).append("\n"); 
		query.append("		,NVL(@[rmn_avg_spd]             , 0)" ).append("\n"); 
		query.append("		,NVL(@[arr_fwddr_hgt]           , 0)" ).append("\n"); 
		query.append("		,NVL(@[arr_mid_drft_hgt]        , 0)" ).append("\n"); 
		query.append("		,NVL(@[arr_aftdr_hgt]           , 0)" ).append("\n"); 
		query.append("		,NVL(@[arr_gm_hgt]              , 0)" ).append("\n"); 
		query.append("		,NVL(@[arr_foil_wgt]            , 0)" ).append("\n"); 
		query.append("		,NVL(@[arr_doil_wgt]            , 0)" ).append("\n"); 
		query.append("		,NVL(@[arr_frsh_wtr_wgt]        , 0)" ).append("\n"); 
		query.append("		,NVL(@[arr_blst_wgt]            , 0)" ).append("\n"); 
		query.append("		,NVL(@[arr_low_sulp_foil_wgt]   , 0)" ).append("\n"); 
		query.append("		,NVL(@[arr_low_sulp_doil_wgt]   , 0)" ).append("\n"); 
		query.append("		,NVL(@[dep_fwddr_hgt]           , 0)" ).append("\n"); 
		query.append("		,NVL(@[dep_mid_drft_hgt]        , 0)" ).append("\n"); 
		query.append("		,NVL(@[dep_aftdr_hgt]           , 0)" ).append("\n"); 
		query.append("		,NVL(@[dep_gm_hgt]              , 0)" ).append("\n"); 
		query.append("		,NVL(@[dep_foil_wgt]            , 0)" ).append("\n"); 
		query.append("		,NVL(@[dep_doil_wgt]            , 0)" ).append("\n"); 
		query.append("		,NVL(@[dep_frsh_wtr_wgt]        , 0)" ).append("\n"); 
		query.append("		,NVL(@[dep_blst_wgt]            , 0)" ).append("\n"); 
		query.append("		,NVL(@[dep_low_sulp_foil_wgt]   , 0)" ).append("\n"); 
		query.append("		,NVL(@[dep_low_sulp_doil_wgt]   , 0)" ).append("\n"); 
		query.append("		,NVL(@[spl_foil_wgt]            , 0)" ).append("\n"); 
		query.append("		,NVL(@[spl_doil_wgt]            , 0)" ).append("\n"); 
		query.append("		,NVL(@[spl_frsh_wtr_wgt]        , 0)" ).append("\n"); 
		query.append("		,NVL(@[spl_low_sulp_foil_wgt]   , 0)" ).append("\n"); 
		query.append("		,NVL(@[spl_low_sulp_doil_wgt]   , 0)" ).append("\n"); 
		query.append("		,NVL(@[nvgt_dist]               , 0)" ).append("\n"); 
		query.append("		,NVL(@[eng_ml_dist]             , 0)" ).append("\n"); 
		query.append("		,NVL(@[avg_spd]                 , 0)" ).append("\n"); 
		query.append("		,NVL(@[avg_rpm_pwr]             , 0)" ).append("\n"); 
		query.append("		,TO_DATE(@[act_brth_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,TO_DATE(@[crn_wrk_cmnc_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,TO_DATE(@[crn_wrk_cmpl_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,TO_DATE(@[act_dep_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,NVL(@[mnvr_in_ml_dist]         , 0)" ).append("\n"); 
		query.append("		,NVL(@[mnvr_out_ml_dist]        , 0)" ).append("\n"); 
		query.append("		,TO_DATE(@[bfr_brth_ank_drp_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,TO_DATE(@[bfr_brth_ank_off_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,TO_DATE(@[aft_unbrth_ank_drp_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,TO_DATE(@[aft_unbrth_ank_off_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,NVL(@[sea_mn_fuel_csm_wgt]              , 0)" ).append("\n"); 
		query.append("		,NVL(@[sea_gnr_fuel_csm_wgt]             , 0)" ).append("\n"); 
		query.append("		,NVL(@[sea_blr_fuel_csm_wgt]             , 0)" ).append("\n"); 
		query.append("		,NVL(@[sea_mn_dzl_csm_wgt]               , 0)" ).append("\n"); 
		query.append("		,NVL(@[sea_gnr_dzl_csm_wgt]              , 0)" ).append("\n"); 
		query.append("		,NVL(@[sea_blr_dzl_csm_wgt]              , 0)" ).append("\n"); 
		query.append("		,NVL(@[sea_mn_low_sulp_fuel_csm_wgt]     , 0)" ).append("\n"); 
		query.append("		,NVL(@[sea_gnr_low_sulp_fuel_csm_wgt]    , 0)" ).append("\n"); 
		query.append("		,NVL(@[sea_blr_low_sulp_fuel_csm_wgt]    , 0)" ).append("\n"); 
		query.append("		,NVL(@[sea_mn_low_sulp_dzl_csm_wgt]      , 0)" ).append("\n"); 
		query.append("		,NVL(@[sea_gnr_low_sulp_dzl_csm_wgt]     , 0)" ).append("\n"); 
		query.append("		,NVL(@[sea_blr_low_sulp_dzl_csm_wgt]     , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_mn_fuel_csm_wgt]             , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_gnr_fuel_csm_wgt]            , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_blr_fuel_csm_wgt]            , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_mn_dzl_csm_wgt]              , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_gnr_dzl_csm_wgt]             , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_blr_dzl_csm_wgt]             , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_mn_low_sulp_fuel_csm_wgt]    , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_gnr_low_sulp_fuel_csm_wgt]   , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_blr_low_sulp_fuel_csm_wgt]   , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_mn_low_sulp_dzl_csm_wgt]     , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_gnr_low_sulp_dzl_csm_wgt]    , 0)" ).append("\n"); 
		query.append("		,NVL(@[port_blr_low_sulp_dzl_csm_wgt]    , 0)" ).append("\n"); 
		query.append("		,@[cre_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,@[cre_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,TO_DATE(@[act_arr_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,TO_DATE(@[plt_lst_unld_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		,NVL(@[ttl_slg_wgt]                      , 0)" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}