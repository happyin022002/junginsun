/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOSearchDepRptLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
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

public class VesselReportDBDAOSearchDepRptLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Departure Report Log 정보를 조회한다.
	  * </pre>
	  */
	public VesselReportDBDAOSearchDepRptLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchDepRptLogRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	RCV_DT" ).append("\n"); 
		query.append("	,RCV_SEQ" ).append("\n"); 
		query.append("	,VSL_CD" ).append("\n"); 
		query.append("	,VOY_DIR_CD" ).append("\n"); 
		query.append("	,VSL_SLAN_CD" ).append("\n"); 
		query.append("	,DEP_PORT_CD" ).append("\n"); 
		query.append("	,CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,GMT_TD_HRS" ).append("\n"); 
		query.append("	,NXT_PORT_CD" ).append("\n"); 
		query.append("	,TO_CHAR(NXT_PORT_ETA_DT, 'YYYYMMDDHH24MI') AS NXT_PORT_ETA_DT" ).append("\n"); 
		query.append("	,RMN_DIST" ).append("\n"); 
		query.append("	,RMN_AVG_SPD" ).append("\n"); 
		query.append("	,ARR_DRFT_CTNT" ).append("\n"); 
		query.append("	,DEP_DRFT_CTNT" ).append("\n"); 
		query.append("	,NXT_DRFT_CTNT" ).append("\n"); 
		query.append("	,ARR_ROB_CTNT" ).append("\n"); 
		query.append("	,DEP_ROB_CTNT" ).append("\n"); 
		query.append("	,NXT_ROB_CTNT" ).append("\n"); 
		query.append("	,SPL_OIL_CTNT" ).append("\n"); 
		query.append("	,NVGT_ML_DIST" ).append("\n"); 
		query.append("	,AVG_SPD" ).append("\n"); 
		query.append("	,AVG_RPM_PWR" ).append("\n"); 
		query.append("	,BLK_LOD_DCHG_STS_CD" ).append("\n"); 
		query.append("	,BLK_CGO_TP_CD1" ).append("\n"); 
		query.append("	,BLK_HLD_LOAD_CTNT" ).append("\n"); 
		query.append("	,TO_CHAR(SB_ENG_DT, 'YYYYMMDDHH24MI') AS SB_ENG_DT" ).append("\n"); 
		query.append("	,TO_CHAR(PLT_IN_DT, 'YYYYMMDDHH24MI') AS PLT_IN_DT" ).append("\n"); 
		query.append("	,TO_CHAR(VPS_ETB_DT, 'YYYYMMDDHH24MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("	,TO_CHAR(CGO_WRK_ST_DT, 'YYYYMMDDHH24MI') AS CGO_WRK_ST_DT" ).append("\n"); 
		query.append("	,TO_CHAR(CGO_WRK_END_DT, 'YYYYMMDDHH24MI') AS CGO_WRK_END_DT" ).append("\n"); 
		query.append("	,TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("	,TO_CHAR(PLT_OUT_DT, 'YYYYMMDDHH24MI') AS PLT_OUT_DT" ).append("\n"); 
		query.append("	,TO_CHAR(RUP_DT, 'YYYYMMDDHH24MI') AS RUP_DT" ).append("\n"); 
		query.append("	,DEP_RMK" ).append("\n"); 
		query.append("	,DEP_STS_CD" ).append("\n"); 
		query.append("	,RUN_HRS_IN_HV_WE" ).append("\n"); 
		query.append("	,SEA_DNST" ).append("\n"); 
		query.append("	,DET_RSN_CTNT" ).append("\n"); 
		query.append("	,ENG_ML_DIST" ).append("\n"); 
		query.append("	,MNVR_IN_ML_DIST" ).append("\n"); 
		query.append("	,MNVR_OUT_ML_DIST" ).append("\n"); 
		query.append("	,BLK_DEP_CGO_TTL_WGT" ).append("\n"); 
		query.append("	,TO_CHAR(BFR_BRTH_ANK_DRP_DT, 'YYYYMMDDHH24MI') AS BFR_BRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("	,TO_CHAR(BFR_BRTH_ANK_OFF_DT, 'YYYYMMDDHH24MI') AS BFR_BRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("	,TO_CHAR(AFT_UNBRTH_ANK_DRP_DT, 'YYYYMMDDHH24MI') AS AFT_UNBRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("	,TO_CHAR(AFT_UNBRTH_ANK_OFF_DT, 'YYYYMMDDHH24MI') AS AFT_UNBRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("	,SEA_FUEL_CSM_CTNT" ).append("\n"); 
		query.append("	,PORT_FUEL_CSM_CTNT" ).append("\n"); 
		query.append("	,REF_NO" ).append("\n"); 
		query.append("	,CNTR_CGO_CTNT" ).append("\n"); 
		query.append("	,BLK_CGO_TP_CD2" ).append("\n"); 
		query.append("	,BLK_CGO_TP_CD3" ).append("\n"); 
		query.append("	,BLK_CGO_TP_CD4" ).append("\n"); 
		query.append("	,BLK_CGO_TP_CD5" ).append("\n"); 
		query.append("	,SEA_LOW_SULP_FUEL_CSM_CTNT" ).append("\n"); 
		query.append("	,PORT_LOW_SULP_FUEL_CSM_CTNT" ).append("\n"); 
		query.append("	,SPL_LOW_SULP_OIL_CTNT" ).append("\n"); 
		query.append("	,DEP_CGO_WGT" ).append("\n"); 
		query.append("	,DEP_DPL_WGT" ).append("\n"); 
		query.append("	,TTL_SLG_WGT" ).append("\n"); 
		query.append("	,FO_SLG_WGT" ).append("\n"); 
		query.append("	,INCNR_SLG_WGT" ).append("\n"); 
		query.append("	,DPL_SLG_WGT" ).append("\n"); 
		query.append("	,DPL_SLG_SP" ).append("\n"); 
		query.append("	,RMN_SDG_WGT" ).append("\n"); 
		query.append("	,FOIL_PURF_DCHG_ITVAL" ).append("\n"); 
		query.append("	,CAP_NM" ).append("\n"); 
		query.append("	,CF_ENG_NM" ).append("\n"); 
		query.append("	,DEP_LAT" ).append("\n"); 
		query.append("	,DEP_LON" ).append("\n"); 
		query.append("	,DEP_RPM_PWR" ).append("\n"); 
		query.append("	,DEP_RPM_MAX_PWR" ).append("\n"); 
		query.append("	,DEP_RPM_MIN_PWR" ).append("\n"); 
		query.append("	,DEP_RPM_UUSD_FM" ).append("\n"); 
		query.append("	,DEP_RPM_UUSD_TO" ).append("\n"); 
		query.append("	,DEP_ARR_PLT_MGN_HRS" ).append("\n"); 
		query.append("	,DEP_ARR_PLT_MGN_MNTS" ).append("\n"); 
		query.append("	,DEP_RSN_FOR_MGN_TM" ).append("\n"); 
		query.append("	,ARR_LAT" ).append("\n"); 
		query.append("	,ARR_LON" ).append("\n"); 
		query.append("	,ARR_SAIL_HRS" ).append("\n"); 
		query.append("	,ARR_NVGT_ML" ).append("\n"); 
		query.append("	,ARR_ENG_ML" ).append("\n"); 
		query.append("	,ARR_RPM_PWR" ).append("\n"); 
		query.append("	,ARR_MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append("	,ARR_MN_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("	,ARR_GNR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("	,ARR_GNR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("	,ARR_BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("	,ARR_BLR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("	,ARR_DOIL_CSM_QTY" ).append("\n"); 
		query.append("	,ARR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("	,EAI_IF_ID" ).append("\n"); 
		query.append("	,IF_FLG" ).append("\n"); 
		query.append("	,EAI_IF_RMK" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,VSL_RPT_TJ_TP_CD" ).append("\n"); 
		query.append("	,OLD_VSL_CD" ).append("\n"); 
		query.append("	,OLD_VOY_DIR_CD" ).append("\n"); 
		query.append("	,OLD_VSL_SLAN_CD" ).append("\n"); 
		query.append("	,OLD_DEP_PORT_CD" ).append("\n"); 
		query.append("	,OLD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM FCM_DEP_RPT_LOG" ).append("\n"); 
		query.append("WHERE RCV_DT = @[rcv_dt]" ).append("\n"); 
		query.append("AND RCV_SEQ = @[rcv_seq]" ).append("\n"); 

	}
}