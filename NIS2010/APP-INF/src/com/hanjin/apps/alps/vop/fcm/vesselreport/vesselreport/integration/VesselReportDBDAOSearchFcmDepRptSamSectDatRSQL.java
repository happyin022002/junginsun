/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOSearchFcmDepRptSamSectDatRSQL.java
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

public class VesselReportDBDAOSearchFcmDepRptSamSectDatRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FCM DEPARTURE REPORT ERROR SAME SECTION DATA 조회 쿼리 - FcmDepRptErrClsVO 형태
	  * </pre>
	  */
	public VesselReportDBDAOSearchFcmDepRptSamSectDatRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_dzn_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_dep_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchFcmDepRptSamSectDatRSQL").append("\n"); 
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
		query.append("    -- Departure Report 에서 동일 Dep Port, 동일 노선, 동일 선형, 동일 Bound 를 추출하기 위한 쿼리" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.VSL_CD" ).append("\n"); 
		query.append("        ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,T1.DEP_PORT_CD" ).append("\n"); 
		query.append("        ,T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,T2.CNTR_DZN_CAPA" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT T1, MDM_VSL_CNTR T2" ).append("\n"); 
		query.append("    WHERE T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("    AND T1.DEP_PORT_CD = @[dep_port_cd]" ).append("\n"); 
		query.append("    AND T1.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("    AND T2.CNTR_DZN_CAPA = @[cntr_dzn_capa]" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VSK_SKD_TMP AS (" ).append("\n"); 
		query.append("    -- Last Port Schedule 를 추출하기 위한 쿼리" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.VSL_CD" ).append("\n"); 
		query.append("        ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,T1.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,LAG(T1.VSL_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_VSL_CD" ).append("\n"); 
		query.append("		,LAG(T1.SKD_VOY_NO) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_SKD_VOY_NO" ).append("\n"); 
		query.append("		,LAG(T1.SKD_DIR_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,LAG(T1.VPS_PORT_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_PORT_CD" ).append("\n"); 
		query.append("        ,LAG(T1.CLPT_IND_SEQ) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD T1, MDM_VSL_SVC_LANE_DIR T2" ).append("\n"); 
		query.append("    WHERE T1.SLAN_CD = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("    AND T1.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("    AND NVL(T1.SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("    AND T1.VSL_CD IN (" ).append("\n"); 
		query.append("        SELECT VSL_CD" ).append("\n"); 
		query.append("        FROM FCM_DEP_RPT_TMP" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("FCM_DEP_RPT_SAM_TMP AS (" ).append("\n"); 
		query.append("    -- Departure Report Same Section Data 조회 " ).append("\n"); 
		query.append("    SELECT T1.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            T1.VSL_CD" ).append("\n"); 
		query.append("            ,CONCAT(T1.SKD_VOY_NO, T1.SKD_DIR_CD) AS SKD_VOY_NO" ).append("\n"); 
		query.append("            ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("            ,T1.DEP_PORT_CD" ).append("\n"); 
		query.append("            ,T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            ,T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("            ,T2.LAST_VSL_CD" ).append("\n"); 
		query.append("            ,T2.LAST_SKD_VOY_NO" ).append("\n"); 
		query.append("            ,T2.LAST_SKD_DIR_CD" ).append("\n"); 
		query.append("            ,T2.LAST_PORT_CD AS LST_DEP_PORT_CD" ).append("\n"); 
		query.append("            ,T2.LAST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("            ,@[cntr_dzn_capa] AS CNTR_DZN_CAPA" ).append("\n"); 
		query.append("            ,T1.NVGT_ML_DIST AS NVGT_ML_DIST_CTNT" ).append("\n"); 
		query.append("            ,T1.ENG_ML_DIST AS ENG_ML_DIST_CTNT" ).append("\n"); 
		query.append("            ,T1.MNVR_IN_ML_DIST AS MNVR_IN_ML_DIST_CTNT" ).append("\n"); 
		query.append("            ,T1.MNVR_OUT_ML_DIST AS MNVR_OUT_ML_DIST_CTNT" ).append("\n"); 
		query.append("            ,T1.AVG_SPD AS AVG_SPD_CTNT" ).append("\n"); 
		query.append("            ,T1.AVG_RPM_PWR AS AVG_RPM_PWR_CTNT" ).append("\n"); 
		query.append("            ,'' AS AVG_PRLR_PCH_VAL" ).append("\n"); 
		query.append("            ,'' AS SAIL_TM_HRS" ).append("\n"); 
		query.append("            ,T1.ARR_FOIL_WGT AS ARR_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.ARR_LOW_SULP_FOIL_WGT AS ARR_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.ARR_DOIL_WGT AS ARR_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.ARR_LOW_SULP_DOIL_WGT AS ARR_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.DEP_FOIL_WGT AS DEP_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.DEP_LOW_SULP_FOIL_WGT AS DEP_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.DEP_DOIL_WGT AS DEP_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.DEP_LOW_SULP_DOIL_WGT AS DEP_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("            ,'' AS SEA_STMNG_MN_ENG_TTL_QTY" ).append("\n"); 
		query.append("            ,'' AS AVG_PORT_TTL_QTY" ).append("\n"); 
		query.append("            ,'' AS AVG_PORT_TTL_HR_QTY" ).append("\n"); 
		query.append("            ,T1.SEA_MN_FOIL_CSM_QTY AS SEA_MN_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SEA_GNR_FOIL_CSM_QTY AS SEA_GNR_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SEA_BLR_FOIL_CSM_QTY AS SEA_BLR_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SEA_MN_LOW_SULP_FOIL_CSM_QTY AS SEA_MN_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SEA_GNR_LOW_SULP_FOIL_CSM_QTY AS SEA_GNR_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SEA_BLR_LOW_SULP_FOIL_CSM_QTY AS SEA_BLR_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SEA_MN_DOIL_CSM_QTY AS SEA_MN_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SEA_GNR_DOIL_CSM_QTY AS SEA_GNR_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SEA_BLR_DOIL_CSM_QTY AS SEA_BLR_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SEA_MN_LOW_SULP_DOIL_CSM_QTY AS SEA_MN_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SEA_GNR_LOW_SULP_DOIL_CSM_QTY AS SEA_GNR_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SEA_BLR_LOW_SULP_DOIL_CSM_QTY AS SEA_BLR_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_MN_FOIL_CSM_QTY AS PORT_MN_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_GNR_FOIL_CSM_QTY AS PORT_GNR_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_BLR_FOIL_CSM_QTY AS PORT_BLR_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_MN_LOW_SULP_FOIL_CSM_QTY AS PORT_MN_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_GNR_LOW_SULP_FOIL_CSM_QTY AS PORT_GNR_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_BLR_LOW_SULP_FOIL_CSM_QTY AS PORT_BLR_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_MN_DOIL_CSM_QTY AS PORT_MN_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_GNR_DOIL_CSM_QTY AS PORT_GNR_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_BLR_DOIL_CSM_QTY AS PORT_BLR_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_MN_LOW_SULP_DOIL_CSM_QTY AS PORT_MN_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_GNR_LOW_SULP_DOIL_CSM_QTY AS PORT_GNR_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.PORT_BLR_LOW_SULP_DOIL_CSM_QTY AS PORT_BLR_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_FOIL_BDR_WGT AS SPL_FOIL_BDR_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_FOIL_ACT_WGT AS SPL_FOIL_ACT_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_FOIL_SULP_WGT AS SPL_FOIL_SULP_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_LOW_SULP_FOIL_BDR_WGT AS SPL_LOW_SULP_FOIL_BDR_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_LOW_SULP_FOIL_ACT_WGT AS SPL_LOW_SULP_FOIL_ACT_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_LOW_SULP_FOIL_SULP_WGT AS SPL_LOW_SULP_FOIL_SULP_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_DOIL_BDR_WGT AS SPL_DOIL_BDR_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_DOIL_ACT_WGT AS SPL_DOIL_ACT_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_DOIL_SULP_WGT AS SPL_DOIL_SULP_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_LOW_SULP_DOIL_BDR_WGT AS SPL_LOW_SULP_DOIL_BDR_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_LOW_SULP_DOIL_ACT_WGT AS SPL_LOW_SULP_DOIL_ACT_CTNT" ).append("\n"); 
		query.append("            ,T1.SPL_LOW_SULP_DOIL_SULP_WGT AS SPL_LOW_SULP_DOIL_SULP_CTNT" ).append("\n"); 
		query.append("            ,T1.NXT_PORT_CD" ).append("\n"); 
		query.append("            ,NVL2(NXT_PORT_ETA_DT,TO_CHAR(NXT_PORT_ETA_DT, 'YYYYMMDDHH24MI'),'') AS NXT_PORT_ETA_DT" ).append("\n"); 
		query.append("            ,T1.RMN_DIST AS RMN_DIST_CTNT" ).append("\n"); 
		query.append("            ,T1.RMN_AVG_SPD AS RMN_AVG_SPD_CTNT" ).append("\n"); 
		query.append("            ,NVL2(T1.SB_ENG_DT,TO_CHAR(T1.SB_ENG_DT, 'YYYYMMDDHH24MI'),'') AS SB_ENG_DT" ).append("\n"); 
		query.append("            ,NVL2(T1.PLT_IN_DT,TO_CHAR(T1.PLT_IN_DT, 'YYYYMMDDHH24MI'),'') AS PLT_IN_DT" ).append("\n"); 
		query.append("            ,NVL2(T1.BFR_BRTH_ANK_DRP_DT,TO_CHAR(T1.BFR_BRTH_ANK_DRP_DT, 'YYYYMMDDHH24MI'),'') AS BFR_BRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("            ,NVL2(T1.BFR_BRTH_ANK_OFF_DT,TO_CHAR(T1.BFR_BRTH_ANK_OFF_DT, 'YYYYMMDDHH24MI'),'') AS BFR_BRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("            ,NVL2(T1.VPS_ETB_DT,TO_CHAR(T1.VPS_ETB_DT, 'YYYYMMDDHH24MI'),'') AS VPS_ETB_DT" ).append("\n"); 
		query.append("            ,NVL2(T1.CGO_WRK_ST_DT,TO_CHAR(T1.CGO_WRK_ST_DT, 'YYYYMMDDHH24MI'),'') AS CGO_WRK_ST_DT" ).append("\n"); 
		query.append("            ,NVL2(T1.CGO_WRK_END_DT, TO_CHAR(T1.CGO_WRK_END_DT, 'YYYYMMDDHH24MI'),'') AS CGO_WRK_END_DT" ).append("\n"); 
		query.append("            ,NVL2(T1.VPS_ETD_DT,TO_CHAR(T1.VPS_ETD_DT, 'YYYYMMDDHH24MI'),'') AS VPS_ETD_DT" ).append("\n"); 
		query.append("            ,NVL2(T1.AFT_UNBRTH_ANK_DRP_DT,TO_CHAR(T1.AFT_UNBRTH_ANK_DRP_DT, 'YYYYMMDDHH24MI'),'') AS AFT_UNBRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("            ,NVL2(T1.AFT_UNBRTH_ANK_OFF_DT,TO_CHAR(T1.AFT_UNBRTH_ANK_OFF_DT, 'YYYYMMDDHH24MI'),'') AS AFT_UNBRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("            ,NVL2(T1.PLT_OUT_DT,TO_CHAR(T1.PLT_OUT_DT, 'YYYYMMDDHH24MI'),'') AS PLT_OUT_DT" ).append("\n"); 
		query.append("            ,NVL2(T1.RUP_DT,TO_CHAR(T1.RUP_DT, 'YYYYMMDDHH24MI'),'') AS RUP_DT" ).append("\n"); 
		query.append("            ,T1.ARR_FWDDR_HGT AS ARR_FWDDR_CTNT" ).append("\n"); 
		query.append("            ,T1.ARR_MID_DRFT_HGT AS ARR_MID_DRFT_CTNT" ).append("\n"); 
		query.append("            ,T1.ARR_AFTDR_HGT AS ARR_AFTDR_CTNT" ).append("\n"); 
		query.append("            ,T1.ARR_GM_HGT AS ARR_GM_CTNT" ).append("\n"); 
		query.append("            ,T1.DEP_FWDDR_HGT AS DEP_FWDDR_CTNT" ).append("\n"); 
		query.append("            ,T1.DEP_MID_DRFT_HGT AS DEP_MID_DRFT_CTNT" ).append("\n"); 
		query.append("            ,T1.DEP_AFTDR_HGT AS DEP_AFTDR_CTNT" ).append("\n"); 
		query.append("            ,T1.DEP_GM_HGT AS DEP_GM_CTNT" ).append("\n"); 
		query.append("            ,T1.FULL_CNTR_OBRD_TEU AS FCNTR_OBRD_TEU_CTNT" ).append("\n"); 
		query.append("            ,T1.MTY_CNTR_OBRD_TEU AS MCNTR_OBRD_TEU_CTNT" ).append("\n"); 
		query.append("            ,T1.TTL_CNTR_OBRD_TEU AS TTL_CNTR_OBRD_TEU_CTNT" ).append("\n"); 
		query.append("            ,T1.DEP_CGO_WGT AS DEP_CGO_CTNT" ).append("\n"); 
		query.append("            ,T1.DEP_DPL_WGT AS DEP_DPL_CTNT" ).append("\n"); 
		query.append("            ,T1.RF_CNTR_DCHG_KNT AS RF_CNTR_DCHG_KNT_CTNT" ).append("\n"); 
		query.append("            ,T1.RF_CNTR_LOD_KNT AS RF_CNTR_LOD_KNT_CTNT" ).append("\n"); 
		query.append("            ,T1.RF_CNTR_OBRD_KNT AS RF_CNTR_OBRD_KNT_CTNT" ).append("\n"); 
		query.append("            ,T1.CRE_USR_ID" ).append("\n"); 
		query.append("            ,T1.CRE_DT" ).append("\n"); 
		query.append("            ,T1.UPD_USR_ID" ).append("\n"); 
		query.append("            ,T1.UPD_DT " ).append("\n"); 
		query.append("        FROM FCM_DEP_RPT T1, VSK_SKD_TMP T2" ).append("\n"); 
		query.append("        WHERE T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("        AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND T1.DEP_PORT_CD = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND T1.DEP_PORT_CD = @[dep_port_cd]" ).append("\n"); 
		query.append("        AND T2.LAST_PORT_CD = @[lst_dep_port_cd]" ).append("\n"); 
		query.append("        AND T1.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("        AND T1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        ORDER BY UPD_DT DESC" ).append("\n"); 
		query.append("    ) T1" ).append("\n"); 
		query.append("    WHERE ROWNUM < 7" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", " ).append("\n"); 
		query.append("FCM_DEP_RPT_SAM_T AS (" ).append("\n"); 
		query.append("    -- Last Port 의 Oil 정보 추출 " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            T2.DEP_FOIL_WGT || '|' || T2.DEP_LOW_SULP_FOIL_WGT || '|' || T2.DEP_DOIL_WGT || '|' || T2.DEP_LOW_SULP_DOIL_WGT || '|' AS OIL_INFO" ).append("\n"); 
		query.append("        FROM FCM_DEP_RPT T2 " ).append("\n"); 
		query.append("        WHERE T2.VSL_CD = T1.LAST_VSL_CD " ).append("\n"); 
		query.append("        AND T2.SKD_VOY_NO = T1.LAST_SKD_VOY_NO " ).append("\n"); 
		query.append("        AND T2.SKD_DIR_CD = T1.LAST_SKD_DIR_CD" ).append("\n"); 
		query.append("        AND T2.DEP_PORT_CD = T1.LST_DEP_PORT_CD" ).append("\n"); 
		query.append("        AND T2.CLPT_IND_SEQ = T1.LAST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ) AS OIL_INFO" ).append("\n"); 
		query.append("    ,T1.* " ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT_SAM_TMP T1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     SUBSTR(T1.OIL_INFO, 1, INSTR(T1.OIL_INFO, '|', 1, 1) - 1) AS LST_DEP_FOIL_CTNT" ).append("\n"); 
		query.append("    ,SUBSTR(T1.OIL_INFO, INSTR(T1.OIL_INFO, '|', 1, 1)+1, INSTR(T1.OIL_INFO, '|', 1, 2) - INSTR(T1.OIL_INFO, '|', 1, 1)-1) AS LST_DEP_LOW_SULP_FOIL_CTNT" ).append("\n"); 
		query.append("    ,SUBSTR(T1.OIL_INFO, INSTR(T1.OIL_INFO, '|', 1, 2)+1, INSTR(T1.OIL_INFO, '|', 1, 3) - INSTR(T1.OIL_INFO, '|', 1, 2)-1) AS LST_DEP_DOIL_CTNT" ).append("\n"); 
		query.append("    ,SUBSTR(T1.OIL_INFO, INSTR(T1.OIL_INFO, '|', 1, 3)+1, INSTR(T1.OIL_INFO, '|', 1, 4) - INSTR(T1.OIL_INFO, '|', 1, 3)-1) AS LST_DEP_LOW_SULP_DOIL_CTNT" ).append("\n"); 
		query.append("    , T1.*" ).append("\n"); 
		query.append("FROM FCM_DEP_RPT_SAM_T T1" ).append("\n"); 

	}
}