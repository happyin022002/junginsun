/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOAddFcmDepRptErrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.10 
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

public class VesselReportDBDAOAddFcmDepRptErrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Departure Report Error 등록
	  * </pre>
	  */
	public VesselReportDBDAOAddFcmDepRptErrCSQL(){
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
		params.put("avg_mnvr_in_ml_dist",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("avg_port_ttl_hr_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_rob_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("avg_nvgt_ml_dist",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("err_itm_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_wrk_st_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("avg_prlr_pch_val",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bfr_brth_ank_drp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avg_mnvr_out_ml_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rup_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOAddFcmDepRptErrCSQL").append("\n"); 
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
		query.append("INSERT INTO FCM_DEP_RPT_ERR (" ).append("\n"); 
		query.append("	DEP_RPT_ERR_SEQ" ).append("\n"); 
		query.append("	,VSL_CD" ).append("\n"); 
		query.append("	,SKD_VOY_NO" ).append("\n"); 
		query.append("	,SKD_DIR_CD" ).append("\n"); 
		query.append("	,DEP_PORT_CD" ).append("\n"); 
		query.append("	,CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,DEP_RPT_ERR_TP_CD" ).append("\n"); 
		query.append("	,VSL_SLAN_CD" ).append("\n"); 
		query.append("	,NVGT_ML_DIST_CTNT" ).append("\n"); 
		query.append("	,AVG_NVGT_ML_DIST" ).append("\n"); 
		query.append("	,ENG_ML_DIST_CTNT" ).append("\n"); 
		query.append("	,MNVR_IN_ML_DIST_CTNT" ).append("\n"); 
		query.append("	,AVG_MNVR_IN_ML_DIST" ).append("\n"); 
		query.append("	,MNVR_OUT_ML_DIST_CTNT" ).append("\n"); 
		query.append("	,AVG_MNVR_OUT_ML_DIST" ).append("\n"); 
		query.append("	,AVG_SPD_CTNT" ).append("\n"); 
		query.append("	,AVG_RPM_PWR_CTNT" ).append("\n"); 
		query.append("	,AVG_PRLR_PCH_VAL" ).append("\n"); 
		query.append("	,ARR_FOIL_CTNT" ).append("\n"); 
		query.append("	,ARR_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("	,ARR_DOIL_CTNT" ).append("\n"); 
		query.append("	,ARR_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("	,DEP_FOIL_CTNT" ).append("\n"); 
		query.append("	,DEP_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("	,DEP_DOIL_CTNT" ).append("\n"); 
		query.append("	,DEP_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("	,AVG_PORT_TTL_QTY" ).append("\n"); 
		query.append("	,AVG_PORT_TTL_HR_QTY" ).append("\n"); 
		query.append("	,SEA_MN_FOIL_CTNT" ).append("\n"); 
		query.append("	,SEA_GNR_FOIL_CTNT" ).append("\n"); 
		query.append("	,SEA_BLR_FOIL_CTNT" ).append("\n"); 
		query.append("	,SEA_MN_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("	,SEA_GNR_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("	,SEA_BLR_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("	,SEA_MN_DOIL_CTNT" ).append("\n"); 
		query.append("	,SEA_GNR_DOIL_CTNT" ).append("\n"); 
		query.append("	,SEA_BLR_DOIL_CTNT" ).append("\n"); 
		query.append("	,SEA_MN_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("	,SEA_GNR_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("	,SEA_BLR_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_MN_FOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_GNR_FOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_BLR_FOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_MN_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_GNR_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_BLR_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_MN_DOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_GNR_DOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_BLR_DOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_MN_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_GNR_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("	,PORT_BLR_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("	,SPL_FOIL_BDR_CTNT" ).append("\n"); 
		query.append("	,SPL_FOIL_ACT_CTNT" ).append("\n"); 
		query.append("	,SPL_FOIL_SULP_CTNT" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_FOIL_BDR_CTNT" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_FOIL_ACT_CTNT" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_FOIL_SULP_CTNT" ).append("\n"); 
		query.append("	,SPL_DOIL_BDR_CTNT" ).append("\n"); 
		query.append("	,SPL_DOIL_ACT_CTNT" ).append("\n"); 
		query.append("	,SPL_DOIL_SULP_CTNT" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_DOIL_BDR_CTNT" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_DOIL_ACT_CTNT" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_DOIL_SULP_CTNT" ).append("\n"); 
		query.append("	,NXT_PORT_CD" ).append("\n"); 
		query.append("	,NXT_PORT_ETA_DT" ).append("\n"); 
		query.append("	,RMN_DIST_CTNT" ).append("\n"); 
		query.append("	,RMN_AVG_SPD_CTNT" ).append("\n"); 
		query.append("	,SB_ENG_DT" ).append("\n"); 
		query.append("	,PLT_IN_DT" ).append("\n"); 
		query.append("	,BFR_BRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("	,BFR_BRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("	,VPS_ETB_DT" ).append("\n"); 
		query.append("	,CGO_WRK_ST_DT" ).append("\n"); 
		query.append("	,CGO_WRK_END_DT" ).append("\n"); 
		query.append("	,VPS_ETD_DT" ).append("\n"); 
		query.append("	,AFT_UNBRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("	,AFT_UNBRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("	,PLT_OUT_DT" ).append("\n"); 
		query.append("	,RUP_DT" ).append("\n"); 
		query.append("	,ARR_FWDDR_CTNT" ).append("\n"); 
		query.append("	,ARR_MID_DRFT_CTNT" ).append("\n"); 
		query.append("	,ARR_AFTDR_CTNT" ).append("\n"); 
		query.append("	,ARR_GM_CTNT" ).append("\n"); 
		query.append("	,DEP_FWDDR_CTNT" ).append("\n"); 
		query.append("	,DEP_MID_DRFT_CTNT" ).append("\n"); 
		query.append("	,DEP_AFTDR_CTNT" ).append("\n"); 
		query.append("	,DEP_GM_CTNT" ).append("\n"); 
		query.append("	,FCNTR_OBRD_TEU_CTNT" ).append("\n"); 
		query.append("	,MCNTR_OBRD_TEU_CTNT" ).append("\n"); 
		query.append("	,TTL_CNTR_OBRD_TEU_CTNT" ).append("\n"); 
		query.append("	,DEP_CGO_CTNT" ).append("\n"); 
		query.append("	,DEP_DPL_CTNT" ).append("\n"); 
		query.append("	,RF_CNTR_DCHG_KNT_CTNT" ).append("\n"); 
		query.append("	,RF_CNTR_LOD_KNT_CTNT" ).append("\n"); 
		query.append("	,RF_CNTR_OBRD_KNT_CTNT" ).append("\n"); 
		query.append("	,ERR_ITM_CTNT" ).append("\n"); 
		query.append("	,RCV_EAI_IF_ID" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,RCV_DT" ).append("\n"); 
		query.append("	,RCV_SEQ" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	FCM_DEP_RPT_ERR_SEQ.NEXTVAL" ).append("\n"); 
		query.append("	,@[vsl_cd]" ).append("\n"); 
		query.append("	,SUBSTR(@[voy_dir_cd], 1, 4)" ).append("\n"); 
		query.append("	,SUBSTR(@[voy_dir_cd], 5, 1)" ).append("\n"); 
		query.append("	,@[dep_port_cd]" ).append("\n"); 
		query.append("	,DECODE(@[clpt_ind_seq], 'F', '1', 'S', '2', 'T', '3')" ).append("\n"); 
		query.append("	,@[dep_rpt_err_tp_cd]" ).append("\n"); 
		query.append("	,@[vsl_slan_cd]" ).append("\n"); 
		query.append("	,@[nvgt_ml_dist]" ).append("\n"); 
		query.append("	,@[avg_nvgt_ml_dist]" ).append("\n"); 
		query.append("	,@[eng_ml_dist]" ).append("\n"); 
		query.append("	,@[mnvr_in_ml_dist]" ).append("\n"); 
		query.append("	,@[avg_mnvr_in_ml_dist]" ).append("\n"); 
		query.append("	,@[mnvr_out_ml_dist]" ).append("\n"); 
		query.append("	,@[avg_mnvr_out_ml_dist]" ).append("\n"); 
		query.append("	,@[avg_spd]" ).append("\n"); 
		query.append("	,@[avg_rpm_pwr]" ).append("\n"); 
		query.append("	,@[avg_prlr_pch_val]" ).append("\n"); 
		query.append("	,SUBSTR(@[arr_rob_ctnt], 1, INSTR(@[arr_rob_ctnt], '|', 1, 1) - 1)" ).append("\n"); 
		query.append("	,SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 4) + 1, INSTR(@[arr_rob_ctnt], '|', 1, 5) - INSTR(@[arr_rob_ctnt], '|', 1, 4)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 1)+1, INSTR(@[arr_rob_ctnt], '|', 1, 2) - INSTR(@[arr_rob_ctnt], '|', 1, 1)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 5)+1, INSTR(@[arr_rob_ctnt], '|', 1, 6) - INSTR(@[arr_rob_ctnt], '|', 1, 5)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[dep_rob_ctnt], 1, INSTR(@[dep_rob_ctnt], '|', 1, 1) - 1)" ).append("\n"); 
		query.append("	,SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 4)+1, INSTR(@[dep_rob_ctnt], '|', 1, 5) - INSTR(@[dep_rob_ctnt], '|', 1, 4)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 1)+1, INSTR(@[dep_rob_ctnt], '|', 1, 2) - INSTR(@[dep_rob_ctnt], '|', 1, 1)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[dep_rob_ctnt], INSTR(@[dep_rob_ctnt], '|', 1, 5)+1, INSTR(@[dep_rob_ctnt], '|', 1, 6) - INSTR(@[dep_rob_ctnt], '|', 1, 5)-1)" ).append("\n"); 
		query.append("	,@[avg_port_ttl_qty]" ).append("\n"); 
		query.append("	,@[avg_port_ttl_hr_qty]" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_fuel_csm_ctnt], 1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1) - 1)" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], 1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1) - 1)" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_fuel_csm_ctnt], 1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 1) - 1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 1)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 2)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_low_sulp_fuel_csm_ctnt], 1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1) - 1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 3)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 4)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 5)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_oil_ctnt], 1, INSTR(@[spl_oil_ctnt], '|', 1, 1) - 1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 1)+1, INSTR(@[spl_oil_ctnt], '|', 1, 2) - INSTR(@[spl_oil_ctnt], '|', 1, 1)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 2)+1, INSTR(@[spl_oil_ctnt], '|', 1, 3) - INSTR(@[spl_oil_ctnt], '|', 1, 2)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_low_sulp_oil_ctnt], 1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1) - 1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 2) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 2)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 3) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 2)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 5)+1, INSTR(@[spl_oil_ctnt], '|', 1, 6) - INSTR(@[spl_oil_ctnt], '|', 1, 5)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 6)+1, INSTR(@[spl_oil_ctnt], '|', 1, 7) - INSTR(@[spl_oil_ctnt], '|', 1, 6)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 7)+1, INSTR(@[spl_oil_ctnt], '|', 1, 8) - INSTR(@[spl_oil_ctnt], '|', 1, 7)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 5)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 5)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 7) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 7)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 8) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 7)-1)" ).append("\n"); 
		query.append("	,@[nxt_port_cd]" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[nxt_port_eta_dt])<=12 THEN TO_DATE(RPAD(@[nxt_port_eta_dt], 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[nxt_port_eta_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,@[rmn_dist]" ).append("\n"); 
		query.append("	,@[rmn_avg_spd]" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[sb_eng_dt]            )<=12 THEN TO_DATE(RPAD(@[sb_eng_dt]            , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[sb_eng_dt]            , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[plt_in_dt]            )<=12 THEN TO_DATE(RPAD(@[plt_in_dt]            , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[plt_in_dt]            , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[bfr_brth_ank_drp_dt]  )<=12 THEN TO_DATE(RPAD(@[bfr_brth_ank_drp_dt]  , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[bfr_brth_ank_drp_dt]  , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[bfr_brth_ank_off_dt]  )<=12 THEN TO_DATE(RPAD(@[bfr_brth_ank_off_dt]  , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[bfr_brth_ank_off_dt]  , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[vps_etb_dt]           )<=12 THEN TO_DATE(RPAD(@[vps_etb_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[vps_etb_dt]           , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[cgo_wrk_st_dt]        )<=12 THEN TO_DATE(RPAD(@[cgo_wrk_st_dt]        , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[cgo_wrk_st_dt]        , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[cgo_wrk_end_dt]       )<=12 THEN TO_DATE(RPAD(@[cgo_wrk_end_dt]       , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[cgo_wrk_end_dt]       , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[vps_etd_dt]           )<=12 THEN TO_DATE(RPAD(@[vps_etd_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[vps_etd_dt]           , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[aft_unbrth_ank_drp_dt])<=12 THEN TO_DATE(RPAD(@[aft_unbrth_ank_drp_dt], 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[aft_unbrth_ank_drp_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[aft_unbrth_ank_off_dt])<=12 THEN TO_DATE(RPAD(@[aft_unbrth_ank_off_dt], 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[aft_unbrth_ank_off_dt], 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[plt_out_dt]           )<=12 THEN TO_DATE(RPAD(@[plt_out_dt]           , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[plt_out_dt]           , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,(CASE WHEN LENGTH(@[rup_dt]               )<=12 THEN TO_DATE(RPAD(@[rup_dt]               , 12, '0'), 'YYYYMMDDHH24MI') ELSE TO_DATE(SUBSTR(@[rup_dt]               , 1, 12), 'YYYYMMDDHH24MI') END)" ).append("\n"); 
		query.append("	,SUBSTR(@[arr_drft_ctnt],                                 1, INSTR(@[arr_drft_ctnt], '|', 1, 1) -                                 1)" ).append("\n"); 
		query.append("	,SUBSTR(@[arr_drft_ctnt], INSTR(@[arr_drft_ctnt], '|', 1, 1)+1, INSTR(@[arr_drft_ctnt], '|', 1, 2) - INSTR(@[arr_drft_ctnt], '|', 1, 1)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[arr_drft_ctnt], INSTR(@[arr_drft_ctnt], '|', 1, 2)+1, INSTR(@[arr_drft_ctnt], '|', 1, 3) - INSTR(@[arr_drft_ctnt], '|', 1, 2)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[arr_drft_ctnt], INSTR(@[arr_drft_ctnt], '|', 1, 3)+1, INSTR(@[arr_drft_ctnt], '|', 1, 4) - INSTR(@[arr_drft_ctnt], '|', 1, 3)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[dep_drft_ctnt],                                 1, INSTR(@[dep_drft_ctnt], '|', 1, 1) -                                 1)" ).append("\n"); 
		query.append("	,SUBSTR(@[dep_drft_ctnt], INSTR(@[dep_drft_ctnt], '|', 1, 1)+1, INSTR(@[dep_drft_ctnt], '|', 1, 2) - INSTR(@[dep_drft_ctnt], '|', 1, 1)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[dep_drft_ctnt], INSTR(@[dep_drft_ctnt], '|', 1, 2)+1, INSTR(@[dep_drft_ctnt], '|', 1, 3) - INSTR(@[dep_drft_ctnt], '|', 1, 2)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[dep_drft_ctnt], INSTR(@[dep_drft_ctnt], '|', 1, 3)+1, INSTR(@[dep_drft_ctnt], '|', 1, 4) - INSTR(@[dep_drft_ctnt], '|', 1, 3)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[cntr_cgo_ctnt],                                 1, INSTR(@[cntr_cgo_ctnt], '|', 1, 1) -                                 1)" ).append("\n"); 
		query.append("	,SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 1)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 2) - INSTR(@[cntr_cgo_ctnt], '|', 1, 1)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 2)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 3) - INSTR(@[cntr_cgo_ctnt], '|', 1, 2)-1)" ).append("\n"); 
		query.append("	,@[dep_cgo_wgt]" ).append("\n"); 
		query.append("	,@[dep_dpl_wgt]" ).append("\n"); 
		query.append("	,SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 3)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 4) - INSTR(@[cntr_cgo_ctnt], '|', 1, 3)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 4)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 5) - INSTR(@[cntr_cgo_ctnt], '|', 1, 4)-1)" ).append("\n"); 
		query.append("	,SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 5)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 6) - INSTR(@[cntr_cgo_ctnt], '|', 1, 5)-1)" ).append("\n"); 
		query.append("	,@[err_itm_ctnt]" ).append("\n"); 
		query.append("	,@[eai_if_id]" ).append("\n"); 
		query.append("	,@[cre_usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,@[upd_usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,@[rcv_dt]" ).append("\n"); 
		query.append("	,@[rcv_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}