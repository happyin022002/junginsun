/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOSearchFcmDepRptClsRSQL.java
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

public class VesselReportDBDAOSearchFcmDepRptClsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FCM DEPARTURE REPORT Cleansing 을 위한 데이터 조회
	  * </pre>
	  */
	public VesselReportDBDAOSearchFcmDepRptClsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchFcmDepRptClsRSQL").append("\n"); 
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
		query.append("WITH FCM_DEP_RPT_TMP AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,VSL_SLAN_CD" ).append("\n"); 
		query.append("        ,DEP_PORT_CD" ).append("\n"); 
		query.append("        ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,REF_NO" ).append("\n"); 
		query.append("        ,GMT_TD_HRS" ).append("\n"); 
		query.append("        ,NXT_PORT_CD" ).append("\n"); 
		query.append("        ,DEP_STS_CD" ).append("\n"); 
		query.append("        ,RMN_DIST" ).append("\n"); 
		query.append("        ,RMN_AVG_SPD" ).append("\n"); 
		query.append("        ,NVL2(NXT_PORT_ETA_DT,TO_CHAR(NXT_PORT_ETA_DT, 'YYYYMMDDHH24MI'),'') AS NXT_PORT_ETA_DT" ).append("\n"); 
		query.append("        ,NVL2(SB_ENG_DT,TO_CHAR(SB_ENG_DT, 'YYYYMMDDHH24MI'),'') AS SB_ENG_DT" ).append("\n"); 
		query.append("        ,NVL2(PLT_IN_DT,TO_CHAR(PLT_IN_DT, 'YYYYMMDDHH24MI'),'') AS PLT_IN_DT" ).append("\n"); 
		query.append("        ,NVL2(BFR_BRTH_ANK_DRP_DT,TO_CHAR(BFR_BRTH_ANK_DRP_DT, 'YYYYMMDDHH24MI'),'') AS BFR_BRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("        ,NVL2(BFR_BRTH_ANK_OFF_DT,TO_CHAR(BFR_BRTH_ANK_OFF_DT, 'YYYYMMDDHH24MI'),'') AS BFR_BRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("        ,NVL2(VPS_ETB_DT,TO_CHAR(VPS_ETB_DT, 'YYYYMMDDHH24MI'),'') AS VPS_ETB_DT" ).append("\n"); 
		query.append("        ,NVL2(CGO_WRK_ST_DT,TO_CHAR(CGO_WRK_ST_DT, 'YYYYMMDDHH24MI'),'') AS CGO_WRK_ST_DT" ).append("\n"); 
		query.append("        ,NVL2(CGO_WRK_END_DT,TO_CHAR(CGO_WRK_END_DT, 'YYYYMMDDHH24MI'),'') AS CGO_WRK_END_DT" ).append("\n"); 
		query.append("        ,NVL2(VPS_ETD_DT,TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MI'),'') AS VPS_ETD_DT" ).append("\n"); 
		query.append("        ,NVL2(AFT_UNBRTH_ANK_DRP_DT,TO_CHAR(AFT_UNBRTH_ANK_DRP_DT, 'YYYYMMDDHH24MI'),'') AS AFT_UNBRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("        ,NVL2(AFT_UNBRTH_ANK_OFF_DT,TO_CHAR(AFT_UNBRTH_ANK_OFF_DT, 'YYYYMMDDHH24MI'),'') AS AFT_UNBRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("        ,NVL2(PLT_OUT_DT,TO_CHAR(PLT_OUT_DT, 'YYYYMMDDHH24MI'),'') AS PLT_OUT_DT" ).append("\n"); 
		query.append("        ,NVL2(RUP_DT,TO_CHAR(RUP_DT, 'YYYYMMDDHH24MI'),'') AS RUP_DT" ).append("\n"); 
		query.append("        ,MNVR_IN_ML_DIST" ).append("\n"); 
		query.append("        ,MNVR_OUT_ML_DIST" ).append("\n"); 
		query.append("        ,NVGT_ML_DIST" ).append("\n"); 
		query.append("        ,ENG_ML_DIST" ).append("\n"); 
		query.append("        ,AVG_SPD" ).append("\n"); 
		query.append("        ,AVG_RPM_PWR" ).append("\n"); 
		query.append("        ,RUN_HRS_IN_HV_WE" ).append("\n"); 
		query.append("        ,SEA_DET_RSN_CD1" ).append("\n"); 
		query.append("        ,SEA_DET_RSN_HRS1" ).append("\n"); 
		query.append("        ,SEA_DET_RSN_CD2" ).append("\n"); 
		query.append("        ,SEA_DET_RSN_HRS2" ).append("\n"); 
		query.append("        ,SEA_DET_RSN_CD3" ).append("\n"); 
		query.append("        ,SEA_DET_RSN_HRS3" ).append("\n"); 
		query.append("        ,PORT_DET_RSN_CD1" ).append("\n"); 
		query.append("        ,PORT_DET_RSN_HRS1" ).append("\n"); 
		query.append("        ,PORT_DET_RSN_CD2" ).append("\n"); 
		query.append("        ,PORT_DET_RSN_HRS2" ).append("\n"); 
		query.append("        ,PORT_DET_RSN_CD3" ).append("\n"); 
		query.append("        ,PORT_DET_RSN_HRS3" ).append("\n"); 
		query.append("        ,ARR_FWDDR_HGT" ).append("\n"); 
		query.append("        ,ARR_MID_DRFT_HGT" ).append("\n"); 
		query.append("        ,ARR_AFTDR_HGT" ).append("\n"); 
		query.append("        ,ARR_GM_HGT" ).append("\n"); 
		query.append("        ,ARR_FOIL_WGT" ).append("\n"); 
		query.append("        ,ARR_DOIL_WGT" ).append("\n"); 
		query.append("        ,ARR_FRSH_WTR_WGT" ).append("\n"); 
		query.append("        ,ARR_BLST_WGT" ).append("\n"); 
		query.append("        ,ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("        ,ARR_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("        ,DEP_FWDDR_HGT" ).append("\n"); 
		query.append("        ,DEP_MID_DRFT_HGT" ).append("\n"); 
		query.append("        ,DEP_AFTDR_HGT" ).append("\n"); 
		query.append("        ,DEP_GM_HGT" ).append("\n"); 
		query.append("        ,DEP_FOIL_WGT" ).append("\n"); 
		query.append("        ,DEP_DOIL_WGT" ).append("\n"); 
		query.append("        ,DEP_FRSH_WTR_WGT" ).append("\n"); 
		query.append("        ,DEP_BLST_WGT" ).append("\n"); 
		query.append("        ,DEP_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("        ,DEP_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("        ,NXT_FWDDR_HGT" ).append("\n"); 
		query.append("        ,NXT_MID_DRFT_HGT" ).append("\n"); 
		query.append("        ,NXT_AFTDR_HGT" ).append("\n"); 
		query.append("        ,NXT_GM_HGT" ).append("\n"); 
		query.append("        ,NXT_FOIL_WGT" ).append("\n"); 
		query.append("        ,NXT_DOIL_WGT" ).append("\n"); 
		query.append("        ,NXT_FRSH_WTR_WGT" ).append("\n"); 
		query.append("        ,NXT_BLST_WGT" ).append("\n"); 
		query.append("        ,NXT_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("        ,NXT_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("        ,SEA_MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SEA_GNR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SEA_BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SEA_MN_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SEA_GNR_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SEA_BLR_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SEA_MN_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SEA_GNR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SEA_BLR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SEA_MN_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SEA_GNR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SEA_BLR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_GNR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_MN_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_GNR_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_BLR_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_MN_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_GNR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_BLR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_MN_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_GNR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,PORT_BLR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,SPL_FOIL_BDR_WGT" ).append("\n"); 
		query.append("        ,SPL_FOIL_ACT_WGT" ).append("\n"); 
		query.append("        ,SPL_FOIL_SULP_WGT" ).append("\n"); 
		query.append("        ,SPL_FOIL_BRG_WGT1" ).append("\n"); 
		query.append("        ,SPL_FOIL_BRG_WGT2" ).append("\n"); 
		query.append("        ,SPL_DOIL_BDR_WGT" ).append("\n"); 
		query.append("        ,SPL_DOIL_ACT_WGT" ).append("\n"); 
		query.append("        ,SPL_DOIL_SULP_WGT" ).append("\n"); 
		query.append("        ,SPL_DOIL_BRG_WGT1" ).append("\n"); 
		query.append("        ,SPL_DOIL_BRG_WGT2" ).append("\n"); 
		query.append("        ,SPL_FRSH_WTR_ACT_WGT" ).append("\n"); 
		query.append("        ,SPL_LOW_SULP_FOIL_BDR_WGT" ).append("\n"); 
		query.append("        ,SPL_LOW_SULP_FOIL_ACT_WGT" ).append("\n"); 
		query.append("        ,SPL_LOW_SULP_FOIL_SULP_WGT" ).append("\n"); 
		query.append("        ,SPL_LOW_SULP_FOIL_BRG_WGT1" ).append("\n"); 
		query.append("        ,SPL_LOW_SULP_FOIL_BRG_WGT2" ).append("\n"); 
		query.append("        ,SPL_LOW_SULP_DOIL_BDR_WGT" ).append("\n"); 
		query.append("        ,SPL_LOW_SULP_DOIL_ACT_WGT" ).append("\n"); 
		query.append("        ,SPL_LOW_SULP_DOIL_SULP_WGT" ).append("\n"); 
		query.append("        ,SPL_LOW_SULP_DOIL_BRG_WGT1" ).append("\n"); 
		query.append("        ,SPL_LOW_SULP_DOIL_BRG_WGT2" ).append("\n"); 
		query.append("        ,SEA_DNST" ).append("\n"); 
		query.append("        ,FULL_CNTR_OBRD_TEU" ).append("\n"); 
		query.append("        ,MTY_CNTR_OBRD_TEU" ).append("\n"); 
		query.append("        ,TTL_CNTR_OBRD_TEU" ).append("\n"); 
		query.append("        ,RF_CNTR_DCHG_KNT" ).append("\n"); 
		query.append("        ,RF_CNTR_LOD_KNT" ).append("\n"); 
		query.append("        ,RF_CNTR_OBRD_KNT" ).append("\n"); 
		query.append("        ,DEP_CGO_WGT" ).append("\n"); 
		query.append("        ,DEP_DPL_WGT" ).append("\n"); 
		query.append("        ,BLK_LOD_DCHG_STS_CD" ).append("\n"); 
		query.append("        ,BLK_CGO_TP_CD1" ).append("\n"); 
		query.append("        ,BLK_CGO_TP_CD2" ).append("\n"); 
		query.append("        ,BLK_CGO_TP_CD3" ).append("\n"); 
		query.append("        ,BLK_CGO_TP_CD4" ).append("\n"); 
		query.append("        ,BLK_CGO_TP_CD5" ).append("\n"); 
		query.append("        ,BLK_HLD_LOAD_QTY1" ).append("\n"); 
		query.append("        ,BLK_HLD_LOAD_QTY2" ).append("\n"); 
		query.append("        ,BLK_HLD_LOAD_QTY3" ).append("\n"); 
		query.append("        ,BLK_HLD_LOAD_QTY4" ).append("\n"); 
		query.append("        ,BLK_HLD_LOAD_QTY5" ).append("\n"); 
		query.append("        ,BLK_HLD_LOAD_QTY6" ).append("\n"); 
		query.append("        ,BLK_HLD_LOAD_QTY7" ).append("\n"); 
		query.append("        ,BLK_HLD_LOAD_QTY8" ).append("\n"); 
		query.append("        ,BLK_HLD_LOAD_QTY9" ).append("\n"); 
		query.append("        ,BLK_DEP_CGO_TTL_WGT" ).append("\n"); 
		query.append("        ,TTL_SLG_WGT" ).append("\n"); 
		query.append("        ,FO_SLG_WGT" ).append("\n"); 
		query.append("        ,INCNR_SLG_WGT" ).append("\n"); 
		query.append("        ,DPL_SLG_WGT" ).append("\n"); 
		query.append("        ,DPL_SLG_SP" ).append("\n"); 
		query.append("        ,RMN_SDG_WGT" ).append("\n"); 
		query.append("        ,FOIL_PURF_DCHG_ITVAL" ).append("\n"); 
		query.append("        ,DEP_RMK" ).append("\n"); 
		query.append("        ,ARR_LAT" ).append("\n"); 
		query.append("        ,ARR_LON" ).append("\n"); 
		query.append("        ,ARR_SAIL_HRS" ).append("\n"); 
		query.append("        ,ARR_NVGT_ML" ).append("\n"); 
		query.append("        ,ARR_ENG_ML" ).append("\n"); 
		query.append("        ,ARR_RPM_PWR" ).append("\n"); 
		query.append("        ,ARR_MN_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,ARR_MN_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,ARR_GNR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,ARR_GNR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,ARR_BLR_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,ARR_BLR_LOW_SULP_FOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,ARR_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,ARR_LOW_SULP_DOIL_CSM_QTY" ).append("\n"); 
		query.append("        ,DEP_LAT" ).append("\n"); 
		query.append("        ,DEP_LON" ).append("\n"); 
		query.append("        ,DEP_RPM_PWR" ).append("\n"); 
		query.append("        ,DEP_RPM_MAX_PWR" ).append("\n"); 
		query.append("        ,DEP_RPM_MIN_PWR" ).append("\n"); 
		query.append("        ,DEP_RPM_UUSD_FM" ).append("\n"); 
		query.append("        ,DEP_RPM_UUSD_TO" ).append("\n"); 
		query.append("        ,DEP_ARR_PLT_MGN_HRS" ).append("\n"); 
		query.append("        ,DEP_ARR_PLT_MGN_MNTS" ).append("\n"); 
		query.append("        ,DEP_RSN_FOR_MGN_TM" ).append("\n"); 
		query.append("        ,CAP_NM" ).append("\n"); 
		query.append("        ,CF_ENG_NM" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT" ).append("\n"); 
		query.append("    WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("    AND DEP_PORT_CD = @[dep_port_cd]" ).append("\n"); 
		query.append("    AND CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", " ).append("\n"); 
		query.append("VSK_SKD_TMP AS (" ).append("\n"); 
		query.append("    -- Last Port Schedule 를 추출하기 위한 쿼리" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.VSL_CD" ).append("\n"); 
		query.append("        ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,T1.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,LAG(T1.VSL_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LST_VSL_CD" ).append("\n"); 
		query.append("		,LAG(T1.SKD_VOY_NO) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LST_SKD_VOY_NO" ).append("\n"); 
		query.append("		,LAG(T1.SKD_DIR_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LST_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,LAG(T1.VPS_PORT_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LST_DEP_PORT_CD" ).append("\n"); 
		query.append("        ,LAG(T1.CLPT_IND_SEQ) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD T1, MDM_VSL_SVC_LANE_DIR T2" ).append("\n"); 
		query.append("    WHERE T1.SLAN_CD = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("    AND T1.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("    AND NVL(T1.SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("    AND T1.VSL_CD IN (" ).append("\n"); 
		query.append("        SELECT VSL_CD FROM FCM_DEP_RPT_TMP" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("FCM_DEP_RPT_CLS_TMP AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T2.LST_VSL_CD," ).append("\n"); 
		query.append("        T2.LST_SKD_VOY_NO," ).append("\n"); 
		query.append("        T2.LST_SKD_DIR_CD," ).append("\n"); 
		query.append("        T2.LST_DEP_PORT_CD," ).append("\n"); 
		query.append("        T2.LST_CLPT_IND_SEQ," ).append("\n"); 
		query.append("        T1.* " ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT_TMP T1, VSK_SKD_TMP T2" ).append("\n"); 
		query.append("    WHERE T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("    AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T1.DEP_PORT_CD = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("    AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", " ).append("\n"); 
		query.append("FCM_DEP_RPT_CLS_T AS (" ).append("\n"); 
		query.append("    -- Last Port 의 정보 추출 " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            T2.DEP_FOIL_WGT || '|' " ).append("\n"); 
		query.append("            || T2.DEP_LOW_SULP_FOIL_WGT || '|' " ).append("\n"); 
		query.append("            || T2.DEP_DOIL_WGT || '|' " ).append("\n"); 
		query.append("            || T2.DEP_LOW_SULP_DOIL_WGT || '|' " ).append("\n"); 
		query.append("            || T2.RF_CNTR_OBRD_KNT || '|'  " ).append("\n"); 
		query.append("            || NVL2(T2.RUP_DT,TO_CHAR(T2.RUP_DT, 'YYYYMMDDHH24MI'),'') || '|' AS LST_DAT" ).append("\n"); 
		query.append("        FROM FCM_DEP_RPT T2 " ).append("\n"); 
		query.append("        WHERE T2.VSL_CD = T1.LST_VSL_CD " ).append("\n"); 
		query.append("        AND T2.SKD_VOY_NO = T1.LST_SKD_VOY_NO " ).append("\n"); 
		query.append("        AND T2.SKD_DIR_CD = T1.LST_SKD_DIR_CD" ).append("\n"); 
		query.append("        AND T2.DEP_PORT_CD = T1.LST_DEP_PORT_CD" ).append("\n"); 
		query.append("        AND T2.CLPT_IND_SEQ = T1.LST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ) AS LST_DAT" ).append("\n"); 
		query.append("    ,T1.* " ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT_CLS_TMP T1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT CNTR_DZN_CAPA" ).append("\n"); 
		query.append("        FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("        WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("        AND ROWNUM = 1 " ).append("\n"); 
		query.append("    ) AS CNTR_DZN_CAPA" ).append("\n"); 
		query.append("    ,SUBSTR(T1.LST_DAT, 1, INSTR(T1.LST_DAT, '|', 1, 1) - 1) AS LST_DEP_FOIL_CTNT" ).append("\n"); 
		query.append("    ,SUBSTR(T1.LST_DAT, INSTR(T1.LST_DAT, '|', 1, 1)+1, INSTR(T1.LST_DAT, '|', 1, 2) - INSTR(T1.LST_DAT, '|', 1, 1)-1) AS LST_DEP_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("    ,SUBSTR(T1.LST_DAT, INSTR(T1.LST_DAT, '|', 1, 2)+1, INSTR(T1.LST_DAT, '|', 1, 3) - INSTR(T1.LST_DAT, '|', 1, 2)-1) AS LST_DEP_DOIL_CTNT" ).append("\n"); 
		query.append("    ,SUBSTR(T1.LST_DAT, INSTR(T1.LST_DAT, '|', 1, 3)+1, INSTR(T1.LST_DAT, '|', 1, 4) - INSTR(T1.LST_DAT, '|', 1, 3)-1) AS LST_DEP_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("    ,SUBSTR(T1.LST_DAT, INSTR(T1.LST_DAT, '|', 1, 4)+1, INSTR(T1.LST_DAT, '|', 1, 5) - INSTR(T1.LST_DAT, '|', 1, 4)-1) AS LST_RF_CNTR_OBRD_KNT_CTNT" ).append("\n"); 
		query.append("    ,SUBSTR(T1.LST_DAT, INSTR(T1.LST_DAT, '|', 1, 5)+1, INSTR(T1.LST_DAT, '|', 1, 6) - INSTR(T1.LST_DAT, '|', 1, 5)-1) AS LST_PORT_RUP_DT" ).append("\n"); 
		query.append("    ,T1.* " ).append("\n"); 
		query.append("FROM FCM_DEP_RPT_CLS_T T1" ).append("\n"); 

	}
}