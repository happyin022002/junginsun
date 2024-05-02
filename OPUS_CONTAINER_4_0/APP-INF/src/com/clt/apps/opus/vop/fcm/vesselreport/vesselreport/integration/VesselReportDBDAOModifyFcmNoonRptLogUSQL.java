/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselReportDBDAOModifyFcmNoonRptLogUSQL.java
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

public class VesselReportDBDAOModifyFcmNoonRptLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VesselReportDBDAOModifyFcmNoonRptLogUSQL
	  * </pre>
	  */
	public VesselReportDBDAOModifyFcmNoonRptLogUSQL(){
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
		params.put("noon_rpt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dg_sail_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lod_ind_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wnd_frc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_rpt_tj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mn_low_sulp_foil_csm_qty ",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mn_low_sulp_doil_csm_qty ",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("noon_rpt_lat",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("voy_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bilge_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOModifyFcmNoonRptLogUSQL").append("\n"); 
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
		query.append("UPDATE FCM_NOON_RPT_LOG" ).append("\n"); 
		query.append("SET    VSL_CD                     = @[vsl_cd]" ).append("\n"); 
		query.append("      ,VOY_DIR_CD                 = @[voy_dir_cd]" ).append("\n"); 
		query.append("      ,VSL_SLAN_CD                = @[vsl_slan_cd]" ).append("\n"); 
		query.append("      ,REF_NO                     = @[ref_no]" ).append("\n"); 
		query.append("      ,NOON_RPT_DT                = (CASE WHEN LENGTH(@[noon_rpt_dt])<=12 THEN" ).append("\n"); 
		query.append("                                               TO_DATE(RPAD(@[noon_rpt_dt], 12, '0'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                          ELSE" ).append("\n"); 
		query.append("                                               TO_DATE(SUBSTR(@[noon_rpt_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("      ,NOON_RPT_LAT               = @[noon_rpt_lat]" ).append("\n"); 
		query.append("      ,NOON_RPT_LON               = @[noon_rpt_lon]" ).append("\n"); 
		query.append("      ,WND_FRC                    = @[wnd_frc]" ).append("\n"); 
		query.append("      ,SEA_FRC                    = @[sea_frc]" ).append("\n"); 
		query.append("      ,VIS_RNG_NO                 = @[vis_rng_no]" ).append("\n"); 
		query.append("      ,SAIL_HRMNT                 = @[sail_hrmnt]" ).append("\n"); 
		query.append("      ,NVGT_ML_DIST               = @[nvgt_ml_dist]" ).append("\n"); 
		query.append("      ,SAIL_AVG_SPD               = @[sail_avg_spd]" ).append("\n"); 
		query.append("      ,MN_PWR                     = @[mn_pwr]" ).append("\n"); 
		query.append("      ,ENG_ML_DIST                = @[eng_ml_dist]" ).append("\n"); 
		query.append("      ,SAIL_AVG_RPM_PWR           = @[sail_avg_rpm_pwr]" ).append("\n"); 
		query.append("      ,SLP_RT                     = @[slp_rt]" ).append("\n"); 
		query.append("      ,LOD_IND_QTY                = @[lod_ind_qty]" ).append("\n"); 
		query.append("      ,RMN_DIST                   = @[rmn_dist]" ).append("\n"); 
		query.append("      ,RMN_AVG_SPD                = @[rmn_avg_spd]" ).append("\n"); 
		query.append("      ,CRS_NO                     = @[crs_no]" ).append("\n"); 
		query.append("      ,MN_FOIL_CSM_QTY            = @[mn_foil_csm_qty]" ).append("\n"); 
		query.append("      ,MN_LOW_SULP_FOIL_CSM_QTY   = @[mn_low_sulp_foil_csm_qty ]" ).append("\n"); 
		query.append("      ,GNR_FOIL_CSM_QTY           = @[gnr_foil_csm_qty]" ).append("\n"); 
		query.append("      ,GNR_LOW_SULP_FOIL_CSM_QTY  = @[gnr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("      ,BLR_FOIL_CSM_QTY           = @[blr_foil_csm_qty]" ).append("\n"); 
		query.append("      ,BLR_LOW_SULP_FOIL_CSM_QTY  = @[blr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("      ,MN_DOIL_CSM_QTY            = @[mn_doil_csm_qty]" ).append("\n"); 
		query.append("      ,MN_LOW_SULP_DOIL_CSM_QTY   = @[mn_low_sulp_doil_csm_qty ]" ).append("\n"); 
		query.append("      ,NXT_PORT_CD                = @[nxt_port_cd]" ).append("\n"); 
		query.append("      ,NXT_PORT_ETA_DT            = (CASE WHEN LENGTH(@[nxt_port_eta_dt])<=12 THEN" ).append("\n"); 
		query.append("                                               TO_DATE(RPAD(@[nxt_port_eta_dt], 12, '0'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                          ELSE" ).append("\n"); 
		query.append("                                               TO_DATE(SUBSTR(@[nxt_port_eta_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("      ,BILGE_CHK_FLG              = @[bilge_chk_flg]" ).append("\n"); 
		query.append("      ,HLD_GAS_CHK_FLG            = @[hld_gas_chk_flg]" ).append("\n"); 
		query.append("      ,HLD_TEMP_CHK_FLG           = @[hld_temp_chk_flg]" ).append("\n"); 
		query.append("      ,BLST_XCH_FLG               = @[blst_xch_flg]" ).append("\n"); 
		query.append("      ,HLD_CLN_FLG                = @[hld_cln_flg]" ).append("\n"); 
		query.append("      ,PSC_PRPR_FLG               = @[psc_prpr_flg]" ).append("\n"); 
		query.append("      ,DG_SAIL_FLG                = @[dg_sail_flg]" ).append("\n"); 
		query.append("      ,DG_SAIL_RMK                = @[dg_sail_rmk]" ).append("\n"); 
		query.append("      ,VSL_RPT_TJ_TP_CD           = @[vsl_rpt_tj_tp_cd]" ).append("\n"); 
		query.append("      ,EAI_IF_ID                  = @[eai_if_id]" ).append("\n"); 
		query.append("      ,IF_FLG                     = 'N'" ).append("\n"); 
		query.append("      ,CRE_USR_ID                 = @[cre_usr_id]" ).append("\n"); 
		query.append("      ,CRE_DT                     = SYSDATE" ).append("\n"); 
		query.append("      ,UPD_USR_ID                 = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT                     = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND RCV_DT=@[rcv_dt]" ).append("\n"); 
		query.append("AND RCV_SEQ=@[rcv_seq]" ).append("\n"); 

	}
}