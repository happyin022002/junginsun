/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportDBDAOFcmNoonRptLogVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.26 
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

public class VesselReportDBDAOFcmNoonRptLogVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NoonRpt 스케줄러로 데이타 생성
	  * </pre>
	  */
	public VesselReportDBDAOFcmNoonRptLogVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("noon_rpt_lon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_low_sulp_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("noon_rpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_sail_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psc_prpr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hld_cln_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_ind_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vis_rng_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wnd_frc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eng_ml_dist",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sea_frc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("blr_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sail_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("noon_rpt_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hld_gas_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnr_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnr_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blst_xch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_sail_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bilge_chk_flg ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hld_temp_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_pwr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mn_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_avg_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("noon_rpt_lat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blr_low_sulp_foil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_doil_csm_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_avg_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOFcmNoonRptLogVOCSQL").append("\n"); 
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
		query.append("INSERT INTO FCM_NOON_RPT_LOG(" ).append("\n"); 
		query.append("RCV_DT" ).append("\n"); 
		query.append(",RCV_SEQ" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",VOY_DIR_CD" ).append("\n"); 
		query.append(",VSL_SLAN_CD" ).append("\n"); 
		query.append(",NOON_RPT_DT" ).append("\n"); 
		query.append(",NOON_RPT_LAT" ).append("\n"); 
		query.append(",NOON_RPT_LON" ).append("\n"); 
		query.append(",SAIL_HRMNT" ).append("\n"); 
		query.append(",NVGT_ML_DIST" ).append("\n"); 
		query.append(",ENG_ML_DIST" ).append("\n"); 
		query.append(",WND_FRC" ).append("\n"); 
		query.append(",SEA_FRC" ).append("\n"); 
		query.append(",VIS_RNG_NO" ).append("\n"); 
		query.append(",SAIL_AVG_SPD" ).append("\n"); 
		query.append(",SAIL_AVG_RPM_PWR" ).append("\n"); 
		query.append(",SLP_RT" ).append("\n"); 
		query.append(",RMN_DIST" ).append("\n"); 
		query.append(",RMN_AVG_SPD" ).append("\n"); 
		query.append(",CRS_NO" ).append("\n"); 
		query.append(",MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",MN_DOIL_CSM_QTY" ).append("\n"); 
		query.append(",NXT_PORT_CD" ).append("\n"); 
		query.append(",NXT_PORT_ETA_DT" ).append("\n"); 
		query.append(",NOON_RPT_RMK" ).append("\n"); 
		query.append(",DG_SAIL_FLG" ).append("\n"); 
		query.append(",DG_SAIL_RMK" ).append("\n"); 
		query.append(",BILGE_CHK_FLG" ).append("\n"); 
		query.append(",HLD_TEMP_CHK_FLG" ).append("\n"); 
		query.append(",HLD_GAS_CHK_FLG" ).append("\n"); 
		query.append(",BLST_XCH_FLG" ).append("\n"); 
		query.append(",HLD_CLN_FLG" ).append("\n"); 
		query.append(",PSC_PRPR_FLG" ).append("\n"); 
		query.append(",REF_NO" ).append("\n"); 
		query.append(",GNR_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",MN_PWR" ).append("\n"); 
		query.append(",LOD_IND_QTY" ).append("\n"); 
		query.append(",MN_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",GNR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",BLR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append(",MN_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append(",EAI_IF_ID" ).append("\n"); 
		query.append(",IF_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append(" NVL(TO_DATE(@[rcv_dt], 'YYYYMMDDHH24MISS'), SYSDATE)" ).append("\n"); 
		query.append(",@[rcv_seq] " ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[voy_dir_cd]" ).append("\n"); 
		query.append(",@[vsl_slan_cd]" ).append("\n"); 
		query.append(",@[noon_rpt_dt]" ).append("\n"); 
		query.append(",@[noon_rpt_lat]" ).append("\n"); 
		query.append(",@[noon_rpt_lon]" ).append("\n"); 
		query.append(",@[sail_hrmnt]" ).append("\n"); 
		query.append(",@[nvgt_ml_dist]" ).append("\n"); 
		query.append(",@[eng_ml_dist]" ).append("\n"); 
		query.append(",@[wnd_frc]" ).append("\n"); 
		query.append(",@[sea_frc]" ).append("\n"); 
		query.append(",@[vis_rng_no]" ).append("\n"); 
		query.append(",@[sail_avg_spd]" ).append("\n"); 
		query.append(",@[sail_avg_rpm_pwr]" ).append("\n"); 
		query.append(",@[slp_rt]" ).append("\n"); 
		query.append(",@[rmn_dist]" ).append("\n"); 
		query.append(",@[rmn_avg_spd]" ).append("\n"); 
		query.append(",@[crs_no]" ).append("\n"); 
		query.append(",@[mn_foil_csm_qty]" ).append("\n"); 
		query.append(",@[mn_doil_csm_qty]" ).append("\n"); 
		query.append(",@[nxt_port_cd]" ).append("\n"); 
		query.append(",@[nxt_port_eta_dt]" ).append("\n"); 
		query.append(",@[noon_rpt_rmk]" ).append("\n"); 
		query.append(",@[dg_sail_flg]" ).append("\n"); 
		query.append(",@[dg_sail_rmk]" ).append("\n"); 
		query.append(",@[bilge_chk_flg ]" ).append("\n"); 
		query.append(",@[hld_temp_chk_flg]" ).append("\n"); 
		query.append(",@[hld_gas_chk_flg]" ).append("\n"); 
		query.append(",@[blst_xch_flg]" ).append("\n"); 
		query.append(",@[hld_cln_flg]" ).append("\n"); 
		query.append(",@[psc_prpr_flg]" ).append("\n"); 
		query.append(",@[ref_no]" ).append("\n"); 
		query.append(",@[gnr_foil_csm_qty]" ).append("\n"); 
		query.append(",@[blr_foil_csm_qty]" ).append("\n"); 
		query.append(",@[mn_pwr]" ).append("\n"); 
		query.append(",@[lod_ind_qty]" ).append("\n"); 
		query.append(",@[mn_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append(",@[gnr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append(",@[blr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append(",@[mn_low_sulp_doil_csm_qty]  " ).append("\n"); 
		query.append(",@[eai_if_id]                    " ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",@[cre_usr_id]                   " ).append("\n"); 
		query.append(",SYSDATE  " ).append("\n"); 
		query.append(",@[upd_usr_id]  " ).append("\n"); 
		query.append(",SYSDATE                                        " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}