/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselReportDBDAOAddFcmNoonRptCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.08
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.08 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOAddFcmNoonRptCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create noon report.
	  * ============================================================================
	  * </pre>
	  */
	public VesselReportDBDAOAddFcmNoonRptCSQL(){
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
		params.put("noon_rpt_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nxt_port_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOAddFcmNoonRptCSQL").append("\n"); 
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
		query.append("MERGE INTO FCM_NOON_RPT" ).append("\n"); 
		query.append("USING DUAL ON(" ).append("\n"); 
		query.append("     VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND  SKD_VOY_NO   = SUBSTR(@[voy_dir_cd], 1, 4)" ).append("\n"); 
		query.append("AND  SKD_DIR_CD   = SUBSTR(@[voy_dir_cd], 5, 1)" ).append("\n"); 
		query.append("AND  NOON_RPT_DT  = (CASE WHEN LENGTH(@[noon_rpt_dt])<=12 THEN" ).append("\n"); 
		query.append("                         TO_DATE(RPAD(@[noon_rpt_dt], 12, '0'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                     ELSE" ).append("\n"); 
		query.append("                         TO_DATE(SUBSTR(@[noon_rpt_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      VSL_SLAN_CD               = @[vsl_slan_cd]" ).append("\n"); 
		query.append("    , REF_NO                    = @[ref_no]" ).append("\n"); 
		query.append("    , NOON_RPT_LAT              = @[noon_rpt_lat]" ).append("\n"); 
		query.append("    , NOON_RPT_LON              = @[noon_rpt_lon]" ).append("\n"); 
		query.append("    , WND_DIR_CTNT              = REGEXP_SUBSTR(@[wnd_frc], '[A-Z]+')" ).append("\n"); 
		query.append("    , WND_SCL_NO                = DECODE(LENGTH(REGEXP_SUBSTR(@[wnd_frc], '[0-9]+')), 1, REGEXP_SUBSTR(@[wnd_frc], '[0-9]+'), '')" ).append("\n"); 
		query.append("    , OCN_CRNT_CTNT             = REGEXP_SUBSTR(@[sea_frc], '[A-Z]+')" ).append("\n"); 
		query.append("    , SEA_STE_NO                = DECODE(LENGTH(REGEXP_SUBSTR(@[sea_frc], '[0-9]+')), 1, REGEXP_SUBSTR(@[sea_frc], '[0-9]+'), '')" ).append("\n"); 
		query.append("    , VIS_RNG_NO                = @[vis_rng_no]" ).append("\n"); 
		query.append("    , SAIL_HRMNT                = REPLACE(@[sail_hrmnt], ' ', '0')" ).append("\n"); 
		query.append("    , NVGT_ML_DIST              = @[nvgt_ml_dist]" ).append("\n"); 
		query.append("    , SAIL_AVG_SPD              = @[sail_avg_spd]" ).append("\n"); 
		query.append("    , MN_PWR                    = @[mn_pwr]" ).append("\n"); 
		query.append("    , ENG_ML_DIST               = @[eng_ml_dist]" ).append("\n"); 
		query.append("    , SAIL_AVG_RPM_PWR          = @[sail_avg_rpm_pwr]" ).append("\n"); 
		query.append("    , SLP_RT                    = @[slp_rt]" ).append("\n"); 
		query.append("    , LOD_IND_QTY               = @[lod_ind_qty]" ).append("\n"); 
		query.append("    , RMN_DIST                  = @[rmn_dist]" ).append("\n"); 
		query.append("    , RMN_AVG_SPD               = @[rmn_avg_spd]" ).append("\n"); 
		query.append("    , CRS_NO                    = @[crs_no]" ).append("\n"); 
		query.append("    , MN_FOIL_CSM_QTY           = @[mn_foil_csm_qty]" ).append("\n"); 
		query.append("    , MN_LOW_SULP_FOIL_CSM_QTY  = @[mn_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("    , GNR_FOIL_CSM_QTY          = @[gnr_foil_csm_qty]" ).append("\n"); 
		query.append("    , GNR_LOW_SULP_FOIL_CSM_QTY = @[gnr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("    , BLR_FOIL_CSM_QTY          = @[blr_foil_csm_qty]" ).append("\n"); 
		query.append("    , BLR_LOW_SULP_FOIL_CSM_QTY = @[blr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("    , MN_DOIL_CSM_QTY           = @[mn_doil_csm_qty]" ).append("\n"); 
		query.append("    , MN_LOW_SULP_DOIL_CSM_QTY  = @[mn_low_sulp_doil_csm_qty]" ).append("\n"); 
		query.append("    , NXT_PORT_CD               = @[nxt_port_cd]" ).append("\n"); 
		query.append("    , NXT_PORT_ETA_DT           = (CASE WHEN LENGTH(@[nxt_port_eta_dt])<=12 THEN" ).append("\n"); 
		query.append("                                       TO_DATE(RPAD(@[nxt_port_eta_dt], 12, '0'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                       TO_DATE(SUBSTR(@[nxt_port_eta_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("    , BILGE_CHK_FLG             = @[bilge_chk_flg]" ).append("\n"); 
		query.append("    , HLD_GAS_CHK_FLG           = @[hld_gas_chk_flg]" ).append("\n"); 
		query.append("    , HLD_TEMP_CHK_FLG          = @[hld_temp_chk_flg]" ).append("\n"); 
		query.append("    , BLST_XCH_FLG              = @[blst_xch_flg]" ).append("\n"); 
		query.append("    , HLD_CLN_FLG               = @[hld_cln_flg]" ).append("\n"); 
		query.append("    , PSC_PRPR_FLG              = @[psc_prpr_flg]" ).append("\n"); 
		query.append("    , DG_SAIL_FLG               = @[dg_sail_flg]" ).append("\n"); 
		query.append("    , DG_SAIL_RMK               = @[dg_sail_rmk]" ).append("\n"); 
		query.append("    , NOON_RPT_RMK              = @[noon_rpt_rmk]" ).append("\n"); 
		query.append("    , UPD_USR_ID                = @[upd_usr_id]" ).append("\n"); 
		query.append("    , UPD_DT                    = SYSDATE" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO   = SUBSTR(@[voy_dir_cd], 1, 4)" ).append("\n"); 
		query.append("AND    SKD_DIR_CD   = SUBSTR(@[voy_dir_cd], 5, 1)" ).append("\n"); 
		query.append("AND    NOON_RPT_DT  = (CASE WHEN LENGTH(@[noon_rpt_dt])<=12 THEN" ).append("\n"); 
		query.append("                           TO_DATE(RPAD(@[noon_rpt_dt], 12, '0'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                       ELSE" ).append("\n"); 
		query.append("                           TO_DATE(SUBSTR(@[noon_rpt_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("      VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , NOON_RPT_DT" ).append("\n"); 
		query.append("    , VSL_SLAN_CD" ).append("\n"); 
		query.append("    , REF_NO" ).append("\n"); 
		query.append("    , NOON_RPT_LAT" ).append("\n"); 
		query.append("    , NOON_RPT_LON" ).append("\n"); 
		query.append("    , WND_DIR_CTNT" ).append("\n"); 
		query.append("    , WND_SCL_NO" ).append("\n"); 
		query.append("    , OCN_CRNT_CTNT" ).append("\n"); 
		query.append("    , SEA_STE_NO" ).append("\n"); 
		query.append("    , VIS_RNG_NO" ).append("\n"); 
		query.append("    , SAIL_HRMNT" ).append("\n"); 
		query.append("    , NVGT_ML_DIST" ).append("\n"); 
		query.append("    , SAIL_AVG_SPD" ).append("\n"); 
		query.append("    , MN_PWR" ).append("\n"); 
		query.append("    , ENG_ML_DIST" ).append("\n"); 
		query.append("    , SAIL_AVG_RPM_PWR" ).append("\n"); 
		query.append("    , SLP_RT" ).append("\n"); 
		query.append("    , LOD_IND_QTY" ).append("\n"); 
		query.append("    , RMN_DIST" ).append("\n"); 
		query.append("    , RMN_AVG_SPD" ).append("\n"); 
		query.append("    , CRS_NO" ).append("\n"); 
		query.append("    , MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append("    , MN_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("    , GNR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("    , GNR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("    , BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("    , BLR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("    , MN_DOIL_CSM_QTY" ).append("\n"); 
		query.append("    , MN_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("    , NXT_PORT_CD" ).append("\n"); 
		query.append("    , NXT_PORT_ETA_DT" ).append("\n"); 
		query.append("    , BILGE_CHK_FLG" ).append("\n"); 
		query.append("    , HLD_GAS_CHK_FLG" ).append("\n"); 
		query.append("    , HLD_TEMP_CHK_FLG" ).append("\n"); 
		query.append("    , BLST_XCH_FLG" ).append("\n"); 
		query.append("    , HLD_CLN_FLG" ).append("\n"); 
		query.append("    , PSC_PRPR_FLG" ).append("\n"); 
		query.append("    , DG_SAIL_FLG" ).append("\n"); 
		query.append("    , DG_SAIL_RMK" ).append("\n"); 
		query.append("    , NOON_RPT_RMK" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("      @[vsl_cd]" ).append("\n"); 
		query.append("    , SUBSTR(@[voy_dir_cd], 1, 4)" ).append("\n"); 
		query.append("    , SUBSTR(@[voy_dir_cd], 5, 1)" ).append("\n"); 
		query.append("    , (CASE WHEN LENGTH(@[noon_rpt_dt])<=12 THEN" ).append("\n"); 
		query.append("           TO_DATE(RPAD(@[noon_rpt_dt], 12, '0'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("           TO_DATE(SUBSTR(@[noon_rpt_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("    , @[vsl_slan_cd]" ).append("\n"); 
		query.append("    , @[ref_no]" ).append("\n"); 
		query.append("    , @[noon_rpt_lat]" ).append("\n"); 
		query.append("    , @[noon_rpt_lon]" ).append("\n"); 
		query.append("    , REGEXP_SUBSTR(@[wnd_frc], '[A-Z]+')" ).append("\n"); 
		query.append("    , DECODE(LENGTH(REGEXP_SUBSTR(@[wnd_frc], '[0-9]+')), 1, REGEXP_SUBSTR(@[wnd_frc], '[0-9]+'), '')" ).append("\n"); 
		query.append("    , REGEXP_SUBSTR(@[sea_frc], '[A-Z]+')" ).append("\n"); 
		query.append("    , DECODE(LENGTH(REGEXP_SUBSTR(@[sea_frc], '[0-9]+')), 1, REGEXP_SUBSTR(@[sea_frc], '[0-9]+'), '')" ).append("\n"); 
		query.append("    , @[vis_rng_no]" ).append("\n"); 
		query.append("    , REPLACE(@[sail_hrmnt], ' ', '0')" ).append("\n"); 
		query.append("    , @[nvgt_ml_dist]" ).append("\n"); 
		query.append("    , @[sail_avg_spd]" ).append("\n"); 
		query.append("    , @[mn_pwr]" ).append("\n"); 
		query.append("    , @[eng_ml_dist]" ).append("\n"); 
		query.append("    , @[sail_avg_rpm_pwr]" ).append("\n"); 
		query.append("    , @[slp_rt]" ).append("\n"); 
		query.append("    , @[lod_ind_qty]" ).append("\n"); 
		query.append("    , @[rmn_dist]" ).append("\n"); 
		query.append("    , @[rmn_avg_spd]" ).append("\n"); 
		query.append("    , @[crs_no]" ).append("\n"); 
		query.append("    , @[mn_foil_csm_qty]" ).append("\n"); 
		query.append("    , @[mn_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("    , @[gnr_foil_csm_qty]" ).append("\n"); 
		query.append("    , @[gnr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("    , @[blr_foil_csm_qty]" ).append("\n"); 
		query.append("    , @[blr_low_sulp_foil_csm_qty]" ).append("\n"); 
		query.append("    , @[mn_doil_csm_qty]" ).append("\n"); 
		query.append("    , @[mn_low_sulp_doil_csm_qty]" ).append("\n"); 
		query.append("    , @[nxt_port_cd]" ).append("\n"); 
		query.append("    , (CASE WHEN LENGTH(@[nxt_port_eta_dt])<=12 THEN" ).append("\n"); 
		query.append("           TO_DATE(RPAD(@[nxt_port_eta_dt], 12, '0'), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("           TO_DATE(SUBSTR(@[nxt_port_eta_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("    , @[bilge_chk_flg]" ).append("\n"); 
		query.append("    , @[hld_gas_chk_flg]" ).append("\n"); 
		query.append("    , @[hld_temp_chk_flg]" ).append("\n"); 
		query.append("    , @[blst_xch_flg]" ).append("\n"); 
		query.append("    , @[hld_cln_flg]" ).append("\n"); 
		query.append("    , @[psc_prpr_flg]" ).append("\n"); 
		query.append("    , @[dg_sail_flg]" ).append("\n"); 
		query.append("    , @[dg_sail_rmk]" ).append("\n"); 
		query.append("    , @[noon_rpt_rmk]" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}