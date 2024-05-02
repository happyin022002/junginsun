/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SetupDBDAOmodifyFcmDepRptErrRtSetupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.setup.setup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SetupDBDAOmodifyFcmDepRptErrRtSetupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * merge
	  * </pre>
	  */
	public SetupDBDAOmodifyFcmDepRptErrRtSetupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sb_eng_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wrk_st_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_low_sulp_foil_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_in_ml_dist_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_brth_ank_drp_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr_dchg_knt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_stmng_mn_eng_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_low_sulp_doil_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcntr_obrd_teu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_foil_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_ttl_hr_rt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rup_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr_obrd_knt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_doil_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eng_ml_dist_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_low_sulp_doil_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_brth_ank_off_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_cntr_obrd_teu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_low_sulp_foil_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_rpm_pwr_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_etd_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_cgo_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prlr_pch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_spd_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_unbrth_ank_drp_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnvr_out_ml_dist_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_doil_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_ttl_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wrk_end_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plt_out_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_foil_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mcntr_obrd_teu_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plt_in_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvgt_ml_dist_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_tm_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr_lod_knt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_unbrth_ank_off_dt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.setup.setup.integration").append("\n"); 
		query.append("FileName : SetupDBDAOmodifyFcmDepRptErrRtSetupCSQL").append("\n"); 
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
		query.append("MERGE INTO FCM_DEP_RPT_ERR_RT_SET A" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON ( VSL_CD = @[vsl_cd] )" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append(" UPDATE  SET  " ).append("\n"); 
		query.append("        NVGT_ML_DIST_RT          = @[nvgt_ml_dist_rt]" ).append("\n"); 
		query.append("      , ENG_ML_DIST_RT           = @[eng_ml_dist_rt]" ).append("\n"); 
		query.append("      , MNVR_IN_ML_DIST_RT       = @[mnvr_in_ml_dist_rt]" ).append("\n"); 
		query.append("      , MNVR_OUT_ML_DIST_RT      = @[mnvr_out_ml_dist_rt] " ).append("\n"); 
		query.append("      , AVG_SPD_RT               = @[avg_spd_rt]" ).append("\n"); 
		query.append("      , AVG_RPM_PWR_RT           = @[avg_rpm_pwr_rt]" ).append("\n"); 
		query.append("      , PRLR_PCH_RT              = @[prlr_pch_rt]" ).append("\n"); 
		query.append("      , SAIL_TM_RT               = @[sail_tm_rt]" ).append("\n"); 
		query.append("      , ARR_FOIL_RT              = @[arr_foil_rt]" ).append("\n"); 
		query.append("      , ARR_LOW_SULP_FOIL_RT     = @[arr_low_sulp_foil_rt]" ).append("\n"); 
		query.append("      , ARR_DOIL_RT              = @[arr_doil_rt]" ).append("\n"); 
		query.append("      , ARR_LOW_SULP_DOIL_RT     = @[arr_low_sulp_doil_rt]" ).append("\n"); 
		query.append("      , DEP_FOIL_RT              = @[dep_foil_rt]" ).append("\n"); 
		query.append("      , DEP_LOW_SULP_FOIL_RT     = @[dep_low_sulp_foil_rt]" ).append("\n"); 
		query.append("      , DEP_DOIL_RT              = @[dep_doil_rt]" ).append("\n"); 
		query.append("      , DEP_LOW_SULP_DOIL_RT     = @[dep_low_sulp_doil_rt]" ).append("\n"); 
		query.append("      , SEA_STMNG_MN_ENG_RT      = @[sea_stmng_mn_eng_rt]" ).append("\n"); 
		query.append("      , PORT_TTL_RT              = @[port_ttl_rt]" ).append("\n"); 
		query.append("      , PORT_TTL_HR_RT_RT        = @[port_ttl_hr_rt_rt]" ).append("\n"); 
		query.append("      , SB_ENG_DT_RT             = @[sb_eng_dt_rt]" ).append("\n"); 
		query.append("      , PLT_IN_DT_RT             = @[plt_in_dt_rt]" ).append("\n"); 
		query.append("      , BFR_BRTH_ANK_DRP_DT_RT   = @[bfr_brth_ank_drp_dt_rt]" ).append("\n"); 
		query.append("      , BFR_BRTH_ANK_OFF_DT_RT   = @[bfr_brth_ank_off_dt_rt]" ).append("\n"); 
		query.append("      , VPS_ETB_DT_RT            = @[vps_etb_dt_rt]" ).append("\n"); 
		query.append("      , CGO_WRK_ST_DT_RT         = @[cgo_wrk_st_dt_rt]" ).append("\n"); 
		query.append("      , CGO_WRK_END_DT_RT        = @[cgo_wrk_end_dt_rt]" ).append("\n"); 
		query.append("      , VPS_ETD_DT_RT            = @[vps_etd_dt_rt]" ).append("\n"); 
		query.append("      , AFT_UNBRTH_ANK_DRP_DT_RT = @[aft_unbrth_ank_drp_dt_rt]" ).append("\n"); 
		query.append("      , AFT_UNBRTH_ANK_OFF_DT_RT = @[aft_unbrth_ank_off_dt_rt]" ).append("\n"); 
		query.append("      , PLT_OUT_DT_RT            = @[plt_out_dt_rt]" ).append("\n"); 
		query.append("      , RUP_DT_RT                = @[rup_dt_rt]  " ).append("\n"); 
		query.append("      , FCNTR_OBRD_TEU_RT        = @[fcntr_obrd_teu_rt]" ).append("\n"); 
		query.append("      , MCNTR_OBRD_TEU_RT        = @[mcntr_obrd_teu_rt]" ).append("\n"); 
		query.append("      , TTL_CNTR_OBRD_TEU_RT     = @[ttl_cntr_obrd_teu_rt]" ).append("\n"); 
		query.append("      , DEP_CGO_RT               = @[dep_cgo_rt]" ).append("\n"); 
		query.append("      , RF_CNTR_DCHG_KNT_RT      = @[rf_cntr_dchg_knt_rt]" ).append("\n"); 
		query.append("      , RF_CNTR_LOD_KNT_RT       = @[rf_cntr_lod_knt_rt]" ).append("\n"); 
		query.append("      , RF_CNTR_OBRD_KNT_RT      = @[rf_cntr_obrd_knt_rt]" ).append("\n"); 
		query.append("      , UPD_USR_ID               = @[cre_usr_id]" ).append("\n"); 
		query.append("      , UPD_DT                   = sysdate" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("NVGT_ML_DIST_RT," ).append("\n"); 
		query.append("ENG_ML_DIST_RT," ).append("\n"); 
		query.append("MNVR_IN_ML_DIST_RT," ).append("\n"); 
		query.append("MNVR_OUT_ML_DIST_RT," ).append("\n"); 
		query.append("AVG_SPD_RT," ).append("\n"); 
		query.append("AVG_RPM_PWR_RT," ).append("\n"); 
		query.append("PRLR_PCH_RT," ).append("\n"); 
		query.append("SAIL_TM_RT," ).append("\n"); 
		query.append("ARR_FOIL_RT," ).append("\n"); 
		query.append("ARR_LOW_SULP_FOIL_RT," ).append("\n"); 
		query.append("ARR_DOIL_RT," ).append("\n"); 
		query.append("ARR_LOW_SULP_DOIL_RT," ).append("\n"); 
		query.append("DEP_FOIL_RT," ).append("\n"); 
		query.append("DEP_LOW_SULP_FOIL_RT," ).append("\n"); 
		query.append("DEP_DOIL_RT," ).append("\n"); 
		query.append("DEP_LOW_SULP_DOIL_RT," ).append("\n"); 
		query.append("SEA_STMNG_MN_ENG_RT," ).append("\n"); 
		query.append("PORT_TTL_RT," ).append("\n"); 
		query.append("PORT_TTL_HR_RT_RT," ).append("\n"); 
		query.append("SB_ENG_DT_RT," ).append("\n"); 
		query.append("PLT_IN_DT_RT," ).append("\n"); 
		query.append("BFR_BRTH_ANK_DRP_DT_RT," ).append("\n"); 
		query.append("BFR_BRTH_ANK_OFF_DT_RT," ).append("\n"); 
		query.append("VPS_ETB_DT_RT," ).append("\n"); 
		query.append("CGO_WRK_ST_DT_RT," ).append("\n"); 
		query.append("CGO_WRK_END_DT_RT," ).append("\n"); 
		query.append("VPS_ETD_DT_RT," ).append("\n"); 
		query.append("AFT_UNBRTH_ANK_DRP_DT_RT," ).append("\n"); 
		query.append("AFT_UNBRTH_ANK_OFF_DT_RT," ).append("\n"); 
		query.append("PLT_OUT_DT_RT," ).append("\n"); 
		query.append("RUP_DT_RT," ).append("\n"); 
		query.append("FCNTR_OBRD_TEU_RT," ).append("\n"); 
		query.append("MCNTR_OBRD_TEU_RT," ).append("\n"); 
		query.append("TTL_CNTR_OBRD_TEU_RT," ).append("\n"); 
		query.append("DEP_CGO_RT," ).append("\n"); 
		query.append("RF_CNTR_DCHG_KNT_RT," ).append("\n"); 
		query.append("RF_CNTR_LOD_KNT_RT," ).append("\n"); 
		query.append("RF_CNTR_OBRD_KNT_RT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT )" ).append("\n"); 
		query.append("VALUES  " ).append("\n"); 
		query.append("(@[vsl_cd]," ).append("\n"); 
		query.append("@[nvgt_ml_dist_rt]," ).append("\n"); 
		query.append("@[eng_ml_dist_rt]," ).append("\n"); 
		query.append("@[mnvr_in_ml_dist_rt]," ).append("\n"); 
		query.append("@[mnvr_out_ml_dist_rt]," ).append("\n"); 
		query.append("@[avg_spd_rt]," ).append("\n"); 
		query.append("@[avg_rpm_pwr_rt]," ).append("\n"); 
		query.append("@[prlr_pch_rt]," ).append("\n"); 
		query.append("@[sail_tm_rt]," ).append("\n"); 
		query.append("@[arr_foil_rt]," ).append("\n"); 
		query.append("@[arr_low_sulp_foil_rt]," ).append("\n"); 
		query.append("@[arr_doil_rt]," ).append("\n"); 
		query.append("@[arr_low_sulp_doil_rt]," ).append("\n"); 
		query.append("@[dep_foil_rt]," ).append("\n"); 
		query.append("@[dep_low_sulp_foil_rt]," ).append("\n"); 
		query.append("@[dep_doil_rt]," ).append("\n"); 
		query.append("@[dep_low_sulp_doil_rt]," ).append("\n"); 
		query.append("@[sea_stmng_mn_eng_rt]," ).append("\n"); 
		query.append("@[port_ttl_rt]," ).append("\n"); 
		query.append("@[port_ttl_hr_rt_rt]," ).append("\n"); 
		query.append("@[sb_eng_dt_rt]," ).append("\n"); 
		query.append("@[plt_in_dt_rt]," ).append("\n"); 
		query.append("@[bfr_brth_ank_drp_dt_rt]," ).append("\n"); 
		query.append("@[bfr_brth_ank_off_dt_rt]," ).append("\n"); 
		query.append("@[vps_etb_dt_rt]," ).append("\n"); 
		query.append("@[cgo_wrk_st_dt_rt]," ).append("\n"); 
		query.append("@[cgo_wrk_end_dt_rt]," ).append("\n"); 
		query.append("@[vps_etd_dt_rt]," ).append("\n"); 
		query.append("@[aft_unbrth_ank_drp_dt_rt]," ).append("\n"); 
		query.append("@[aft_unbrth_ank_off_dt_rt]," ).append("\n"); 
		query.append("@[plt_out_dt_rt]," ).append("\n"); 
		query.append("@[rup_dt_rt]," ).append("\n"); 
		query.append("@[fcntr_obrd_teu_rt]," ).append("\n"); 
		query.append("@[mcntr_obrd_teu_rt]," ).append("\n"); 
		query.append("@[ttl_cntr_obrd_teu_rt]," ).append("\n"); 
		query.append("@[dep_cgo_rt]," ).append("\n"); 
		query.append("@[rf_cntr_dchg_knt_rt]," ).append("\n"); 
		query.append("@[rf_cntr_lod_knt_rt]," ).append("\n"); 
		query.append("@[rf_cntr_obrd_knt_rt]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("sysdate )" ).append("\n"); 

	}
}