/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOSearchDepRptStandardDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.11 
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

public class VesselReportDBDAOSearchDepRptStandardDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Departure Report Validation Check를 위한 Standard Data를 조회한다.
	  * </pre>
	  */
	public VesselReportDBDAOSearchDepRptStandardDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_low_sulp_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("avg_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_low_sulp_foil_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_rf_cntr_obrd_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_port_rup_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sb_eng_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sea_low_sulp_fuel_csm_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_doil_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("avg_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchDepRptStandardDataRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("-- Departure Report 기준 데이터" ).append("\n"); 
		query.append("DEP_RPT AS (" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		@[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append("		, SUBSTR(@[voy_dir_cd], 1, 4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("		, SUBSTR(@[voy_dir_cd], 5, 1) AS SKD_DIR_CD" ).append("\n"); 
		query.append("		, @[dep_port_cd] AS DEP_PORT_CD" ).append("\n"); 
		query.append("		, DECODE(@[clpt_ind_seq], 'F', '1', 'S', '2', 'T', '3') AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , @[lst_vsl_cd] AS LST_VSL_CD" ).append("\n"); 
		query.append("        , @[lst_skd_voy_no] AS LST_SKD_VOY_NO" ).append("\n"); 
		query.append("        , @[lst_skd_dir_cd] AS LST_SKD_DIR_CD" ).append("\n"); 
		query.append("		, @[lst_port_cd] AS LST_PORT_CD" ).append("\n"); 
		query.append("        , @[lst_clpt_ind_seq] AS LST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		, TO_DATE(@[sb_eng_dt], 'YYYYMMDDHH24MI') AS SB_ENG_DT" ).append("\n"); 
		query.append("		, TO_DATE(@[lst_port_rup_dt], 'YYYYMMDDHH24MI') AS LST_PORT_RUP_DT" ).append("\n"); 
		query.append("		, (SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR WHERE VSL_CD = @[vsl_cd]) AS DEP_CAPA" ).append("\n"); 
		query.append("		, @[eng_ml_dist] AS ENG_ML_DIST" ).append("\n"); 
		query.append("		, @[nvgt_ml_dist] AS NVGT_ML_DIST" ).append("\n"); 
		query.append("		, @[avg_spd] AS AVG_SPD" ).append("\n"); 
		query.append("		, @[avg_rpm_pwr] AS AVG_RPM_PWR" ).append("\n"); 
		query.append("		, TO_DATE(@[rup_dt], 'YYYYMMDDHH24MI') AS RUP_DT" ).append("\n"); 
		query.append("        , @[lst_foil_wgt] AS LST_FOIL_WGT" ).append("\n"); 
		query.append("        , @[lst_low_sulp_foil_wgt] AS LST_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("        , @[lst_doil_wgt] AS LST_DOIL_WGT" ).append("\n"); 
		query.append("        , @[lst_low_sulp_doil_wgt] AS LST_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("		, @[lst_rf_cntr_obrd_knt] AS LST_RF_CNTR_OBRD_KNT" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_fuel_csm_ctnt], 1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1) - 1) AS SEA_MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 1)-1) AS SEA_GNR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 2)-1) AS SEA_BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 3)-1) AS SEA_MN_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 4)-1) AS SEA_GNR_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_fuel_csm_ctnt], INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[sea_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[sea_fuel_csm_ctnt], '|', 1, 5)-1) AS SEA_BLR_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], 1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1) - 1) AS SEA_MN_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 1)-1) AS SEA_GNR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 2)-1) AS SEA_BLR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 3)-1) AS SEA_MN_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 4)-1) AS SEA_GNR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[sea_low_sulp_fuel_csm_ctnt], INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[sea_low_sulp_fuel_csm_ctnt], '|', 1, 5)-1) AS SEA_BLR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[arr_rob_ctnt], 1, INSTR(@[arr_rob_ctnt], '|', 1, 1) - 1) AS ARR_FOIL_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 1)+1, INSTR(@[arr_rob_ctnt], '|', 1, 2) - INSTR(@[arr_rob_ctnt], '|', 1, 1)-1) AS ARR_DOIL_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 4)+1, INSTR(@[arr_rob_ctnt], '|', 1, 5) - INSTR(@[arr_rob_ctnt], '|', 1, 4)-1) AS ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[arr_rob_ctnt], INSTR(@[arr_rob_ctnt], '|', 1, 5)+1, INSTR(@[arr_rob_ctnt], '|', 1, 6) - INSTR(@[arr_rob_ctnt], '|', 1, 5)-1) AS ARR_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[port_fuel_csm_ctnt], 1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 1) - 1) AS PORT_MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 1)-1) AS PORT_GNR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 2)-1) AS PORT_BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 3)-1) AS PORT_MN_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 4)-1) AS PORT_GNR_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[port_fuel_csm_ctnt], INSTR(@[port_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[port_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[port_fuel_csm_ctnt], '|', 1, 5)-1) AS PORT_BLR_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[port_low_sulp_fuel_csm_ctnt], 1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1) - 1) AS PORT_MN_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 1)-1) AS PORT_GNR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 2)-1) AS PORT_BLR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 3)-1) AS PORT_MN_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 4)-1) AS PORT_GNR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[port_low_sulp_fuel_csm_ctnt], INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5)+1, INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 6) - INSTR(@[port_low_sulp_fuel_csm_ctnt], '|', 1, 5)-1) AS PORT_BLR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        , SUBSTR(@[spl_oil_ctnt], 1, INSTR(@[spl_oil_ctnt], '|', 1, 1) - 1) AS SPL_FOIL_BDR_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 1)+1, INSTR(@[spl_oil_ctnt], '|', 1, 2) - INSTR(@[spl_oil_ctnt], '|', 1, 1)-1) AS SPL_FOIL_ACT_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 5)+1, INSTR(@[spl_oil_ctnt], '|', 1, 6) - INSTR(@[spl_oil_ctnt], '|', 1, 5)-1) AS SPL_DOIL_BDR_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[spl_oil_ctnt], INSTR(@[spl_oil_ctnt], '|', 1, 6)+1, INSTR(@[spl_oil_ctnt], '|', 1, 7) - INSTR(@[spl_oil_ctnt], '|', 1, 6)-1) AS SPL_DOIL_ACT_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[spl_low_sulp_oil_ctnt], 1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1) - 1) AS SPL_LOW_SULP_FOIL_BDR_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 2) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 1)-1) AS SPL_LOW_SULP_FOIL_ACT_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 5)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 5)-1) AS SPL_LOW_SULP_DOIL_BDR_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[spl_low_sulp_oil_ctnt], INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6)+1, INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 7) - INSTR(@[spl_low_sulp_oil_ctnt], '|', 1, 6)-1) AS SPL_LOW_SULP_DOIL_ACT_WGT" ).append("\n"); 
		query.append("        , SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 3)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 4) - INSTR(@[cntr_cgo_ctnt], '|', 1, 3)-1) AS RF_CNTR_DCHG_KNT" ).append("\n"); 
		query.append("        , SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 4)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 5) - INSTR(@[cntr_cgo_ctnt], '|', 1, 4)-1) AS RF_CNTR_LOD_KNT" ).append("\n"); 
		query.append("        , SUBSTR(@[cntr_cgo_ctnt], INSTR(@[cntr_cgo_ctnt], '|', 1, 5)+1, INSTR(@[cntr_cgo_ctnt], '|', 1, 6) - INSTR(@[cntr_cgo_ctnt], '|', 1, 5)-1) AS RF_CNTR_OBRD_KNT" ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- Dep Port VSK" ).append("\n"); 
		query.append(", DEP_PORT_VSK AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,T1.VPS_ETA_DT" ).append("\n"); 
		query.append("        ,T1.VPS_ETB_DT" ).append("\n"); 
		query.append("        ,T1.VPS_ETD_DT" ).append("\n"); 
		query.append("		,T1.SLAN_CD" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD T1, DEP_RPT T2" ).append("\n"); 
		query.append("    WHERE T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("    AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T1.VPS_PORT_CD = T2.DEP_PORT_CD" ).append("\n"); 
		query.append("    AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- Last Port VSK" ).append("\n"); 
		query.append(", LST_PORT_VSK AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,T1.VPS_ETB_DT" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD T1, DEP_RPT T2" ).append("\n"); 
		query.append("    WHERE T1.VSL_CD = T2.LST_VSL_CD" ).append("\n"); 
		query.append("    AND T1.SKD_VOY_NO = T2.LST_SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T2.LST_SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T1.VPS_PORT_CD = T2.LST_PORT_CD" ).append("\n"); 
		query.append("    AND T1.CLPT_IND_SEQ = T2.LST_CLPT_IND_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- Departure Port 기준 MDM Location 데이터" ).append("\n"); 
		query.append(", MDM_DEP_PORT AS (" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		(T1.GMT_HRS / 60) AS GMT" ).append("\n"); 
		query.append("		, T1.CNT_CD" ).append("\n"); 
		query.append("        , T1.STE_CD" ).append("\n"); 
		query.append("		, T2.VPS_ETB_DT" ).append("\n"); 
		query.append("	FROM MDM_LOCATION T1, DEP_PORT_VSK T2" ).append("\n"); 
		query.append("	WHERE T1.LOC_CD = T2.VPS_PORT_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- Last Port 기준 MDM Location 데이터" ).append("\n"); 
		query.append(", MDM_LST_PORT AS (" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		(T1.GMT_HRS / 60) AS GMT" ).append("\n"); 
		query.append("		, T1.CNT_CD" ).append("\n"); 
		query.append("        , T1.STE_CD" ).append("\n"); 
		query.append("		, T2.VPS_ETB_DT" ).append("\n"); 
		query.append("	FROM MDM_LOCATION T1, LST_PORT_VSK T2" ).append("\n"); 
		query.append("	WHERE T1.LOC_CD = T2.VPS_PORT_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- Departure Port 기준 MDM DAYLIGHT 데이터" ).append("\n"); 
		query.append(", MDM_DEP_PORT_DYLGT AS (" ).append("\n"); 
		query.append("	SELECT (MIN(DST_MNTS) / 60) AS DYLGT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT DST_MNTS" ).append("\n"); 
		query.append("        FROM MDM_DYLGT_SAV_TM T1, MDM_DEP_PORT T2" ).append("\n"); 
		query.append("        WHERE T1.DST_CNT_CD = T2.CNT_CD" ).append("\n"); 
		query.append("        AND T1.DST_NOT_APLY_STE_CD = T2.STE_CD" ).append("\n"); 
		query.append("        AND TO_DATE(T1.ST_DST_DT || T1.ST_DST_HRMNT, 'YYYYMMDDHH24MI') <= T2.VPS_ETB_DT" ).append("\n"); 
		query.append("        AND TO_DATE(T1.END_DST_DT || T1.END_DST_HRMNT, 'YYYYMMDDHH24MI') >= T2.VPS_ETB_DT" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DST_MNTS" ).append("\n"); 
		query.append("        FROM MDM_DYLGT_SAV_TM T1, MDM_DEP_PORT T2" ).append("\n"); 
		query.append("        WHERE T1.DST_CNT_CD = T2.CNT_CD" ).append("\n"); 
		query.append("        AND T1.DST_NOT_APLY_STE_CD IS NULL" ).append("\n"); 
		query.append("        AND TO_DATE(T1.ST_DST_DT || T1.ST_DST_HRMNT, 'YYYYMMDDHH24MI') <= T2.VPS_ETB_DT" ).append("\n"); 
		query.append("        AND TO_DATE(T1.END_DST_DT || T1.END_DST_HRMNT, 'YYYYMMDDHH24MI') >= T2.VPS_ETB_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- Last Port 기준 MDM DAYLIGHT 데이터" ).append("\n"); 
		query.append(", MDM_LST_PORT_DYLGT AS (" ).append("\n"); 
		query.append("	SELECT (MIN(DST_MNTS) / 60) AS DYLGT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT DST_MNTS" ).append("\n"); 
		query.append("        FROM MDM_DYLGT_SAV_TM T1, MDM_LST_PORT T2" ).append("\n"); 
		query.append("        WHERE T1.DST_CNT_CD = T2.CNT_CD" ).append("\n"); 
		query.append("        AND T1.DST_NOT_APLY_STE_CD = T2.STE_CD" ).append("\n"); 
		query.append("        AND TO_DATE(T1.ST_DST_DT || T1.ST_DST_HRMNT, 'YYYYMMDDHH24MI') <= T2.VPS_ETB_DT" ).append("\n"); 
		query.append("        AND TO_DATE(T1.END_DST_DT || T1.END_DST_HRMNT, 'YYYYMMDDHH24MI') >= T2.VPS_ETB_DT" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DST_MNTS" ).append("\n"); 
		query.append("        FROM MDM_DYLGT_SAV_TM T1, MDM_LST_PORT T2" ).append("\n"); 
		query.append("        WHERE T1.DST_CNT_CD = T2.CNT_CD" ).append("\n"); 
		query.append("        AND T1.DST_NOT_APLY_STE_CD IS NULL" ).append("\n"); 
		query.append("        AND TO_DATE(T1.ST_DST_DT || T1.ST_DST_HRMNT, 'YYYYMMDDHH24MI') <= T2.VPS_ETB_DT" ).append("\n"); 
		query.append("        AND TO_DATE(T1.END_DST_DT || T1.END_DST_HRMNT, 'YYYYMMDDHH24MI') >= T2.VPS_ETB_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- 동일 선형 AVG. Pro.Pitch 6개월 데이터" ).append("\n"); 
		query.append(", FCM_AVG_CAPA AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        ROUND(AVG(T1.ENG_ML_DIST / ((T1.NVGT_ML_DIST / T1.AVG_SPD) * 60 * T1.AVG_RPM_PWR)), 7) AS AVG_PRLR_PCH_VAL" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT T1, MDM_VSL_CNTR T2, DEP_RPT T3" ).append("\n"); 
		query.append("    WHERE T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("    AND T2.CNTR_DZN_CAPA = T3.DEP_CAPA" ).append("\n"); 
		query.append("    AND T1.UPD_DT >= ADD_MONTHS(SYSDATE, -6)" ).append("\n"); 
		query.append("    AND T1.AVG_EXPT_FLG <> 'Y'" ).append("\n"); 
		query.append("    AND (NVL(T1.ENG_ML_DIST, '') <> '' OR T1.ENG_ML_DIST <> '0')" ).append("\n"); 
		query.append("    AND (NVL(T1.NVGT_ML_DIST, '') <> '' OR T1.NVGT_ML_DIST <> '0')" ).append("\n"); 
		query.append("    AND (NVL(T1.AVG_SPD, '') <> '' OR T1.AVG_SPD <> '0')" ).append("\n"); 
		query.append("    AND (NVL(T1.AVG_RPM_PWR, '') <> '' OR T1.AVG_RPM_PWR <> '0')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- Last Port 포함 VSK 데이터 - Departure Report 6개월 데이터 추출용" ).append("\n"); 
		query.append(", VSK_INFO AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.VSL_CD" ).append("\n"); 
		query.append("        ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,T1.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,LAG (T1.VPS_PORT_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_PORT_CD" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD T1, MDM_VSL_SVC_LANE_DIR T2" ).append("\n"); 
		query.append("    WHERE T1.SLAN_CD = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("    AND T1.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("    AND NVL(T1.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("    AND T1.VSL_CD IN (" ).append("\n"); 
		query.append("        SELECT VSL_CD" ).append("\n"); 
		query.append("        FROM FCM_DEP_RPT_ERR_RT_SET" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    AND T1.VPS_ETD_DT >= ADD_MONTHS(SYSDATE, -9)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- Last Port 포함 Departure Report 6개월 데이터" ).append("\n"); 
		query.append(", FCM_DEP_RPT_VSK AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.VSL_CD" ).append("\n"); 
		query.append("        ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,T1.DEP_PORT_CD" ).append("\n"); 
		query.append("        ,T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,T2.LAST_PORT_CD" ).append("\n"); 
		query.append("        ,T1.NVGT_ML_DIST" ).append("\n"); 
		query.append("        ,T1.MNVR_IN_ML_DIST" ).append("\n"); 
		query.append("        ,T1.MNVR_OUT_ML_DIST" ).append("\n"); 
		query.append("        ,(SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR WHERE VSL_CD = T1.VSL_CD) AS CNTR_DZN_CAPA" ).append("\n"); 
		query.append("        ,((" ).append("\n"); 
		query.append("            T1.PORT_MN_FOIL_CSM_QTY + T1.PORT_GNR_FOIL_CSM_QTY + T1.PORT_BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("            + T1.PORT_MN_DOIL_CSM_QTY + T1.PORT_GNR_DOIL_CSM_QTY + T1.PORT_BLR_DOIL_CSM_QTY" ).append("\n"); 
		query.append("            + T1.PORT_MN_LOW_SULP_FOIL_CSM_QTY + T1.PORT_GNR_LOW_SULP_FOIL_CSM_QTY + T1.PORT_BLR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("            + T1.PORT_MN_LOW_SULP_DOIL_CSM_QTY + T1.PORT_GNR_LOW_SULP_DOIL_CSM_QTY + T1.PORT_BLR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ) / ((RUP_DT - SB_ENG_DT) * 24)) AS PORT_TTL_HR_QTY" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT T1, VSK_INFO T2" ).append("\n"); 
		query.append("    WHERE T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("    AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T1.DEP_PORT_CD = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("    AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND T1.UPD_DT >= ADD_MONTHS(SYSDATE, -6)" ).append("\n"); 
		query.append("    AND T1.AVG_EXPT_FLG <> 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("-- Class Standard Data" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT DEP_CAPA FROM DEP_RPT" ).append("\n"); 
		query.append(") AS CNTR_DZN_CAPA" ).append("\n"); 
		query.append("-- Vessel Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("	SELECT VSL_CD FROM DEP_RPT" ).append("\n"); 
		query.append(") AS VSL_CD" ).append("\n"); 
		query.append("-- Lane Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("	SELECT SLAN_CD FROM DEP_PORT_VSK" ).append("\n"); 
		query.append(") AS VSL_SLAN_CD" ).append("\n"); 
		query.append("-- Last Port Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("	SELECT VPS_PORT_CD FROM LST_PORT_VSK" ).append("\n"); 
		query.append(") AS LST_DEP_PORT_CD" ).append("\n"); 
		query.append("-- Dep Port Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("	SELECT DEP_PORT_CD FROM DEP_RPT" ).append("\n"); 
		query.append(") AS DEP_PORT_CD" ).append("\n"); 
		query.append("-- LAST LINE Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("	SELECT TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	FROM DEP_PORT_VSK" ).append("\n"); 
		query.append(") AS VPS_ETD_DT" ).append("\n"); 
		query.append("-- S/B ENG Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("	SELECT TO_CHAR(VPS_ETA_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	FROM DEP_PORT_VSK" ).append("\n"); 
		query.append(") AS SB_ENG_DT" ).append("\n"); 
		query.append("-- Sailing Time Standard Data" ).append("\n"); 
		query.append(",ROUND((" ).append("\n"); 
		query.append("	(SELECT (SB_ENG_DT - LST_PORT_RUP_DT) * 24 FROM DEP_RPT)" ).append("\n"); 
		query.append("	- (SELECT GMT FROM MDM_DEP_PORT)" ).append("\n"); 
		query.append("	- (SELECT NVL(DYLGT, 0) FROM MDM_DEP_PORT_DYLGT)" ).append("\n"); 
		query.append("	+ (SELECT GMT FROM MDM_LST_PORT)" ).append("\n"); 
		query.append("	+ (SELECT NVL(DYLGT, 0) FROM MDM_LST_PORT_DYLGT)" ).append("\n"); 
		query.append("), 1) AS SAIL_TM_HRS" ).append("\n"); 
		query.append("-- AVG. Pro.Pitch Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT AVG_PRLR_PCH_VAL FROM FCM_AVG_CAPA" ).append("\n"); 
		query.append(") AS AVG_PRLR_PCH_VAL" ).append("\n"); 
		query.append("-- RPM Standard Data" ).append("\n"); 
		query.append(",CASE WHEN (SELECT NVL(AVG_SPD, '0') FROM DEP_RPT) != '0'" ).append("\n"); 
		query.append("    THEN ROUND((" ).append("\n"); 
		query.append("        SELECT ENG_ML_DIST / (NVGT_ML_DIST / AVG_SPD * 60 * (SELECT AVG_PRLR_PCH_VAL FROM FCM_AVG_CAPA))" ).append("\n"); 
		query.append("        FROM DEP_RPT" ).append("\n"); 
		query.append("    ), 1)" ).append("\n"); 
		query.append("    ELSE NULL" ).append("\n"); 
		query.append("END AS AVG_RPM_PWR_CTNT" ).append("\n"); 
		query.append("-- Miles Eng Standard Data" ).append("\n"); 
		query.append(",ROUND((" ).append("\n"); 
		query.append("    (SELECT AVG_PRLR_PCH_VAL FROM FCM_AVG_CAPA)" ).append("\n"); 
		query.append("    * (SELECT AVG_RPM_PWR FROM DEP_RPT)" ).append("\n"); 
		query.append("    * (" ).append("\n"); 
		query.append("        (SELECT (SB_ENG_DT - LST_PORT_RUP_DT) * 24 FROM DEP_RPT)" ).append("\n"); 
		query.append("        - (SELECT GMT FROM MDM_DEP_PORT)" ).append("\n"); 
		query.append("        - (SELECT NVL(DYLGT, 0) FROM MDM_DEP_PORT_DYLGT)" ).append("\n"); 
		query.append("        + (SELECT GMT FROM MDM_LST_PORT)" ).append("\n"); 
		query.append("        + (SELECT NVL(DYLGT, 0) FROM MDM_LST_PORT_DYLGT)" ).append("\n"); 
		query.append("    ) * 60" ).append("\n"); 
		query.append(")) AS ENG_ML_DIST_CTNT" ).append("\n"); 
		query.append("-- Miles Obs Standard Data" ).append("\n"); 
		query.append(",ROUND((" ).append("\n"); 
		query.append("    SELECT AVG(NVGT_ML_DIST)" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT_VSK" ).append("\n"); 
		query.append("    WHERE DEP_PORT_CD = (SELECT DEP_PORT_CD FROM DEP_RPT)" ).append("\n"); 
		query.append("    AND LAST_PORT_CD = (SELECT LST_PORT_CD FROM DEP_RPT)" ).append("\n"); 
		query.append(")) AS NVGT_ML_DIST_CTNT" ).append("\n"); 
		query.append("-- SPD Standard Data" ).append("\n"); 
		query.append(",CASE WHEN (SELECT SB_ENG_DT - LST_PORT_RUP_DT FROM DEP_RPT) <> 0" ).append("\n"); 
		query.append("    THEN ROUND((" ).append("\n"); 
		query.append("        (SELECT NVGT_ML_DIST FROM DEP_RPT)" ).append("\n"); 
		query.append("        / (" ).append("\n"); 
		query.append("            (SELECT (SB_ENG_DT - LST_PORT_RUP_DT) * 24 FROM DEP_RPT)" ).append("\n"); 
		query.append("            - (SELECT GMT FROM MDM_DEP_PORT)" ).append("\n"); 
		query.append("            - (SELECT NVL(DYLGT, 0) FROM MDM_DEP_PORT_DYLGT)" ).append("\n"); 
		query.append("            + (SELECT GMT FROM MDM_LST_PORT)" ).append("\n"); 
		query.append("            + (SELECT NVL(DYLGT, 0) FROM MDM_LST_PORT_DYLGT)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ), 1)" ).append("\n"); 
		query.append("    ELSE NULL" ).append("\n"); 
		query.append("END AS AVG_SPD_CTNT" ).append("\n"); 
		query.append("-- Miles In Standard Data" ).append("\n"); 
		query.append(",ROUND((" ).append("\n"); 
		query.append("    SELECT AVG(MNVR_IN_ML_DIST)" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT_VSK" ).append("\n"); 
		query.append("    WHERE DEP_PORT_CD = (SELECT DEP_PORT_CD FROM DEP_RPT)" ).append("\n"); 
		query.append(")) AS MNVR_IN_ML_DIST_CTNT" ).append("\n"); 
		query.append("-- Miles Out Standard Data" ).append("\n"); 
		query.append(",ROUND((" ).append("\n"); 
		query.append("    SELECT AVG(MNVR_OUT_ML_DIST)" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT_VSK" ).append("\n"); 
		query.append("    WHERE LAST_PORT_CD = (SELECT LST_PORT_CD FROM DEP_RPT)" ).append("\n"); 
		query.append(")) AS MNVR_OUT_ML_DIST_CTNT" ).append("\n"); 
		query.append("-- Sea Steaming Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT '' FROM DUAL" ).append("\n"); 
		query.append(") AS SEA_STMNG_MN_ENG_TTL_QTY" ).append("\n"); 
		query.append("-- AVG. HarborInport FOC/HR Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT ROUND(AVG(PORT_TTL_HR_QTY), 10)" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT_VSK" ).append("\n"); 
		query.append("    WHERE DEP_PORT_CD = (SELECT DEP_PORT_CD FROM DEP_RPT)" ).append("\n"); 
		query.append("    AND CNTR_DZN_CAPA = (SELECT DEP_CAPA FROM DEP_RPT)" ).append("\n"); 
		query.append(") AS AVG_PORT_TTL_HR_QTY" ).append("\n"); 
		query.append("-- Harbor/In Port Standard Data" ).append("\n"); 
		query.append(",ROUND((" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT AVG(PORT_TTL_HR_QTY)" ).append("\n"); 
		query.append("        FROM FCM_DEP_RPT_VSK" ).append("\n"); 
		query.append("        WHERE DEP_PORT_CD = (SELECT DEP_PORT_CD FROM DEP_RPT)" ).append("\n"); 
		query.append("        AND CNTR_DZN_CAPA = (SELECT DEP_CAPA FROM DEP_RPT)" ).append("\n"); 
		query.append("    ) * ((SELECT RUP_DT - SB_ENG_DT FROM DEP_RPT) * 24)" ).append("\n"); 
		query.append("), 1) AS AVG_PORT_TTL_QTY" ).append("\n"); 
		query.append("-- Rob(Arr) F.O Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT LST_FOIL_WGT - (SEA_MN_FOIL_CSM_QTY + SEA_GNR_FOIL_CSM_QTY + SEA_BLR_FOIL_CSM_QTY)" ).append("\n"); 
		query.append("    FROM DEP_RPT" ).append("\n"); 
		query.append(") AS ARR_FOIL_CTNT" ).append("\n"); 
		query.append("-- Rob(Arr) LS F.O Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT LST_LOW_SULP_FOIL_WGT - (SEA_MN_LOW_SULP_FOIL_CSM_QTY + SEA_GNR_LOW_SULP_FOIL_CSM_QTY + SEA_BLR_LOW_SULP_FOIL_CSM_QTY)" ).append("\n"); 
		query.append("    FROM DEP_RPT" ).append("\n"); 
		query.append(") AS ARR_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("-- Rob(Arr) D.O Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT LST_DOIL_WGT - (SEA_MN_DOIL_CSM_QTY + SEA_GNR_DOIL_CSM_QTY + SEA_BLR_DOIL_CSM_QTY)" ).append("\n"); 
		query.append("    FROM DEP_RPT" ).append("\n"); 
		query.append(") AS ARR_DOIL_CTNT" ).append("\n"); 
		query.append("-- Rob(Arr) LS D.O Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT LST_LOW_SULP_DOIL_WGT - (SEA_MN_LOW_SULP_DOIL_CSM_QTY + SEA_GNR_LOW_SULP_DOIL_CSM_QTY + SEA_BLR_LOW_SULP_DOIL_CSM_QTY)" ).append("\n"); 
		query.append("    FROM DEP_RPT" ).append("\n"); 
		query.append(") AS ARR_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("-- Rob(Dep) F.O Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        ARR_FOIL_WGT" ).append("\n"); 
		query.append("        - (PORT_MN_FOIL_CSM_QTY + PORT_GNR_FOIL_CSM_QTY + PORT_BLR_FOIL_CSM_QTY)" ).append("\n"); 
		query.append("        + DECODE(NVL(SPL_FOIL_BDR_WGT, ''), '', DECODE(NVL(SPL_FOIL_ACT_WGT, ''), '', '0', SPL_FOIL_ACT_WGT), SPL_FOIL_BDR_WGT)" ).append("\n"); 
		query.append("    FROM DEP_RPT" ).append("\n"); 
		query.append(") AS DEP_FOIL_CTNT" ).append("\n"); 
		query.append("-- Rob(Dep) LS F.O Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("    - (PORT_MN_LOW_SULP_FOIL_CSM_QTY + PORT_GNR_LOW_SULP_FOIL_CSM_QTY + PORT_BLR_LOW_SULP_FOIL_CSM_QTY)" ).append("\n"); 
		query.append("     + DECODE(NVL(SPL_LOW_SULP_FOIL_BDR_WGT, ''), '', DECODE(NVL(SPL_LOW_SULP_FOIL_ACT_WGT, ''), '', '0', SPL_LOW_SULP_FOIL_ACT_WGT), SPL_LOW_SULP_FOIL_BDR_WGT)" ).append("\n"); 
		query.append("    FROM DEP_RPT" ).append("\n"); 
		query.append(") AS DEP_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("-- Rob(Dep) D.O Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT ARR_DOIL_WGT" ).append("\n"); 
		query.append("    - (PORT_MN_DOIL_CSM_QTY + PORT_GNR_DOIL_CSM_QTY + PORT_BLR_DOIL_CSM_QTY)" ).append("\n"); 
		query.append("    + DECODE(NVL(SPL_DOIL_BDR_WGT, ''), '', DECODE(NVL(SPL_DOIL_ACT_WGT, ''), '', '0', SPL_DOIL_ACT_WGT), SPL_DOIL_BDR_WGT)" ).append("\n"); 
		query.append("    FROM DEP_RPT" ).append("\n"); 
		query.append(") AS DEP_DOIL_CTNT" ).append("\n"); 
		query.append("-- Rob(Dep) LS D.O Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT ARR_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("    - (PORT_MN_LOW_SULP_DOIL_CSM_QTY + PORT_GNR_LOW_SULP_DOIL_CSM_QTY + PORT_BLR_LOW_SULP_DOIL_CSM_QTY)" ).append("\n"); 
		query.append("    + DECODE(NVL(SPL_LOW_SULP_DOIL_BDR_WGT, ''), '', DECODE(NVL(SPL_LOW_SULP_DOIL_ACT_WGT, ''), '', '0', SPL_LOW_SULP_DOIL_ACT_WGT), SPL_LOW_SULP_DOIL_BDR_WGT)" ).append("\n"); 
		query.append("    FROM DEP_RPT" ).append("\n"); 
		query.append(") AS DEP_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("-- FIRST LINE Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("	SELECT TO_CHAR(VPS_ETB_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	FROM DEP_PORT_VSK" ).append("\n"); 
		query.append(") AS VPS_ETB_DT" ).append("\n"); 
		query.append("-- R/F CNTR Disch. Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT LST_RF_CNTR_OBRD_KNT - RF_CNTR_OBRD_KNT + RF_CNTR_LOD_KNT" ).append("\n"); 
		query.append("    FROM DEP_RPT" ).append("\n"); 
		query.append(") AS RF_CNTR_DCHG_KNT_CTNT" ).append("\n"); 
		query.append("-- R/F CNTR Load Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT RF_CNTR_OBRD_KNT - LST_RF_CNTR_OBRD_KNT + RF_CNTR_DCHG_KNT" ).append("\n"); 
		query.append("    FROM DEP_RPT" ).append("\n"); 
		query.append(") AS RF_CNTR_LOD_KNT_CTNT" ).append("\n"); 
		query.append("-- R/F CNTR On Board Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT LST_RF_CNTR_OBRD_KNT - RF_CNTR_DCHG_KNT + RF_CNTR_LOD_KNT" ).append("\n"); 
		query.append("    FROM DEP_RPT" ).append("\n"); 
		query.append(") AS RF_CNTR_OBRD_KNT_CTNT" ).append("\n"); 
		query.append("-- On Board CNTR Full Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM BAY_PLAN T1, DEP_RPT T2" ).append("\n"); 
		query.append("    WHERE T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("    AND T1.VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T1.DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T1.PORT_CD = T2.DEP_PORT_CD" ).append("\n"); 
		query.append("    AND T1.CALL_IND = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND T1.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("    AND T1.FE = 'F'" ).append("\n"); 
		query.append(") AS FCNTR_OBRD_TEU_CTNT" ).append("\n"); 
		query.append("-- On Board CNTR Em'ty Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM BAY_PLAN T1, DEP_RPT T2" ).append("\n"); 
		query.append("    WHERE T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("    AND T1.VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T1.DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T1.PORT_CD = T2.DEP_PORT_CD" ).append("\n"); 
		query.append("    AND T1.CALL_IND = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND T1.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("    AND T1.FE = 'E'" ).append("\n"); 
		query.append(") AS MCNTR_OBRD_TEU_CTNT" ).append("\n"); 
		query.append("-- On Board CNTR Total Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM BAY_PLAN T1, DEP_RPT T2" ).append("\n"); 
		query.append("    WHERE T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("    AND T1.VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T1.DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T1.PORT_CD = T2.DEP_PORT_CD" ).append("\n"); 
		query.append("    AND T1.CALL_IND = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND T1.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append(") AS TTL_CNTR_OBRD_TEU_CTNT" ).append("\n"); 
		query.append("-- On Board CNTR Cargo Weight Standard Data" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT SUM(WEIGHT)" ).append("\n"); 
		query.append("    FROM BAY_PLAN T1, DEP_RPT T2" ).append("\n"); 
		query.append("    WHERE T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("    AND T1.VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T1.DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T1.PORT_CD = T2.DEP_PORT_CD" ).append("\n"); 
		query.append("    AND T1.CALL_IND = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND T1.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append(") AS DEP_CGO_CTNT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}