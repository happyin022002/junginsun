/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselReportDBDAOSearchFcmDepRptErrClsRSQL.java
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

public class VesselReportDBDAOSearchFcmDepRptErrClsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Departure Report 중 Validation Check를 통과하지 못 한 Error Report 정보 관리 화면 VO
	  * </pre>
	  */
	public VesselReportDBDAOSearchFcmDepRptErrClsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_rpt_err_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchFcmDepRptErrClsRSQL").append("\n"); 
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
		query.append("WITH FCM_DEP_RPT_ERR_T AS " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT DEP_RPT_ERR_SEQ ," ).append("\n"); 
		query.append("            VSL_CD ," ).append("\n"); 
		query.append("            CONCAT(SKD_VOY_NO, SKD_DIR_CD) AS SKD_VOY_NO," ).append("\n"); 
		query.append("            SKD_DIR_CD ," ).append("\n"); 
		query.append("            VSL_SLAN_CD ," ).append("\n"); 
		query.append("            DEP_PORT_CD ," ).append("\n"); 
		query.append("            CLPT_IND_SEQ ," ).append("\n"); 
		query.append("            DEP_RPT_ERR_TP_CD ," ).append("\n"); 
		query.append("            NVGT_ML_DIST_CTNT ," ).append("\n"); 
		query.append("            AVG_NVGT_ML_DIST ," ).append("\n"); 
		query.append("            ENG_ML_DIST_CTNT ," ).append("\n"); 
		query.append("            MNVR_IN_ML_DIST_CTNT ," ).append("\n"); 
		query.append("            AVG_MNVR_IN_ML_DIST ," ).append("\n"); 
		query.append("            MNVR_OUT_ML_DIST_CTNT ," ).append("\n"); 
		query.append("            AVG_MNVR_OUT_ML_DIST ," ).append("\n"); 
		query.append("            AVG_SPD_CTNT ," ).append("\n"); 
		query.append("            AVG_RPM_PWR_CTNT ," ).append("\n"); 
		query.append("            AVG_PRLR_PCH_VAL ," ).append("\n"); 
		query.append("            '' AS SAIL_TM_HRS ," ).append("\n"); 
		query.append("            ARR_FOIL_CTNT ," ).append("\n"); 
		query.append("            ARR_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("            ARR_DOIL_CTNT ," ).append("\n"); 
		query.append("            ARR_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("            DEP_FOIL_CTNT ," ).append("\n"); 
		query.append("            DEP_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("            DEP_DOIL_CTNT ," ).append("\n"); 
		query.append("            DEP_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("            '' AS SEA_STMNG_MN_ENG_TTL_QTY ," ).append("\n"); 
		query.append("            AVG_PORT_TTL_QTY ," ).append("\n"); 
		query.append("            AVG_PORT_TTL_HR_QTY ," ).append("\n"); 
		query.append("            SEA_MN_FOIL_CTNT ," ).append("\n"); 
		query.append("            SEA_GNR_FOIL_CTNT ," ).append("\n"); 
		query.append("            SEA_BLR_FOIL_CTNT ," ).append("\n"); 
		query.append("            SEA_MN_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("            SEA_GNR_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("            SEA_BLR_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("            SEA_MN_DOIL_CTNT ," ).append("\n"); 
		query.append("            SEA_GNR_DOIL_CTNT ," ).append("\n"); 
		query.append("            SEA_BLR_DOIL_CTNT ," ).append("\n"); 
		query.append("            SEA_MN_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("            SEA_GNR_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("            SEA_BLR_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_MN_FOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_GNR_FOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_BLR_FOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_MN_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_GNR_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_BLR_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_MN_DOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_GNR_DOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_BLR_DOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_MN_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_GNR_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("            PORT_BLR_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("            SPL_FOIL_BDR_CTNT ," ).append("\n"); 
		query.append("            SPL_FOIL_ACT_CTNT ," ).append("\n"); 
		query.append("            SPL_FOIL_SULP_CTNT ," ).append("\n"); 
		query.append("            SPL_LOW_SULP_FOIL_BDR_CTNT ," ).append("\n"); 
		query.append("            SPL_LOW_SULP_FOIL_ACT_CTNT ," ).append("\n"); 
		query.append("            SPL_LOW_SULP_FOIL_SULP_CTNT ," ).append("\n"); 
		query.append("            SPL_DOIL_BDR_CTNT ," ).append("\n"); 
		query.append("            SPL_DOIL_ACT_CTNT ," ).append("\n"); 
		query.append("            SPL_DOIL_SULP_CTNT ," ).append("\n"); 
		query.append("            SPL_LOW_SULP_DOIL_BDR_CTNT ," ).append("\n"); 
		query.append("            SPL_LOW_SULP_DOIL_ACT_CTNT ," ).append("\n"); 
		query.append("            SPL_LOW_SULP_DOIL_SULP_CTNT ," ).append("\n"); 
		query.append("            NXT_PORT_CD ," ).append("\n"); 
		query.append("            NVL2(NXT_PORT_ETA_DT,TO_CHAR(NXT_PORT_ETA_DT, 'YYYYMMDDHH24MI'),'') AS NXT_PORT_ETA_DT ," ).append("\n"); 
		query.append("            RMN_DIST_CTNT ," ).append("\n"); 
		query.append("            RMN_AVG_SPD_CTNT ," ).append("\n"); 
		query.append("            NVL2(SB_ENG_DT,TO_CHAR(SB_ENG_DT, 'YYYYMMDDHH24MI'),'') AS SB_ENG_DT ," ).append("\n"); 
		query.append("            NVL2(PLT_IN_DT,TO_CHAR(PLT_IN_DT, 'YYYYMMDDHH24MI'),'') AS PLT_IN_DT ," ).append("\n"); 
		query.append("            NVL2(BFR_BRTH_ANK_DRP_DT,TO_CHAR(BFR_BRTH_ANK_DRP_DT, 'YYYYMMDDHH24MI'),'') AS BFR_BRTH_ANK_DRP_DT ," ).append("\n"); 
		query.append("            NVL2(BFR_BRTH_ANK_OFF_DT,TO_CHAR(BFR_BRTH_ANK_OFF_DT, 'YYYYMMDDHH24MI'),'') AS BFR_BRTH_ANK_OFF_DT ," ).append("\n"); 
		query.append("            NVL2(VPS_ETB_DT,TO_CHAR(VPS_ETB_DT, 'YYYYMMDDHH24MI'),'') AS VPS_ETB_DT ," ).append("\n"); 
		query.append("            NVL2(CGO_WRK_ST_DT,TO_CHAR(CGO_WRK_ST_DT, 'YYYYMMDDHH24MI'),'') AS CGO_WRK_ST_DT ," ).append("\n"); 
		query.append("            NVL2(CGO_WRK_END_DT, TO_CHAR(CGO_WRK_END_DT, 'YYYYMMDDHH24MI'),'') AS CGO_WRK_END_DT ," ).append("\n"); 
		query.append("            NVL2(VPS_ETD_DT,TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MI'),'') AS VPS_ETD_DT ," ).append("\n"); 
		query.append("            NVL2(AFT_UNBRTH_ANK_DRP_DT,TO_CHAR(AFT_UNBRTH_ANK_DRP_DT, 'YYYYMMDDHH24MI'),'') AS AFT_UNBRTH_ANK_DRP_DT ," ).append("\n"); 
		query.append("            NVL2(AFT_UNBRTH_ANK_OFF_DT,TO_CHAR(AFT_UNBRTH_ANK_OFF_DT, 'YYYYMMDDHH24MI'),'') AS AFT_UNBRTH_ANK_OFF_DT ," ).append("\n"); 
		query.append("            NVL2(PLT_OUT_DT,TO_CHAR(PLT_OUT_DT, 'YYYYMMDDHH24MI'),'') AS PLT_OUT_DT ," ).append("\n"); 
		query.append("            NVL2(RUP_DT,TO_CHAR(RUP_DT, 'YYYYMMDDHH24MI'),'') AS RUP_DT ," ).append("\n"); 
		query.append("            ARR_FWDDR_CTNT ," ).append("\n"); 
		query.append("            ARR_MID_DRFT_CTNT ," ).append("\n"); 
		query.append("            ARR_AFTDR_CTNT ," ).append("\n"); 
		query.append("            ARR_GM_CTNT ," ).append("\n"); 
		query.append("            DEP_FWDDR_CTNT ," ).append("\n"); 
		query.append("            DEP_MID_DRFT_CTNT ," ).append("\n"); 
		query.append("            DEP_AFTDR_CTNT ," ).append("\n"); 
		query.append("            DEP_GM_CTNT ," ).append("\n"); 
		query.append("            FCNTR_OBRD_TEU_CTNT ," ).append("\n"); 
		query.append("            MCNTR_OBRD_TEU_CTNT ," ).append("\n"); 
		query.append("            TTL_CNTR_OBRD_TEU_CTNT ," ).append("\n"); 
		query.append("            DEP_CGO_CTNT ," ).append("\n"); 
		query.append("            DEP_DPL_CTNT ," ).append("\n"); 
		query.append("            RF_CNTR_DCHG_KNT_CTNT ," ).append("\n"); 
		query.append("            RF_CNTR_LOD_KNT_CTNT ," ).append("\n"); 
		query.append("            RF_CNTR_OBRD_KNT_CTNT ," ).append("\n"); 
		query.append("            LOWER(ERR_ITM_CTNT) AS ERR_ITM_CTNT," ).append("\n"); 
		query.append("            RCV_EAI_IF_ID ," ).append("\n"); 
		query.append("            CRE_USR_ID ," ).append("\n"); 
		query.append("            CRE_DT ," ).append("\n"); 
		query.append("            UPD_USR_ID ," ).append("\n"); 
		query.append("            UPD_DT ," ).append("\n"); 
		query.append("            RCV_DT ," ).append("\n"); 
		query.append("            RCV_SEQ" ).append("\n"); 
		query.append("        FROM FCM_DEP_RPT_ERR" ).append("\n"); 
		query.append("        WHERE VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("        AND DEP_RPT_ERR_SEQ = @[dep_rpt_err_seq]" ).append("\n"); 
		query.append("		#if( ${dep_rpt_err_tp_cd} != '' )" ).append("\n"); 
		query.append("    		AND DEP_RPT_ERR_TP_CD IN (" ).append("\n"); 
		query.append("				#foreach($sDepRptErrTpCd in ${dep_rpt_err_tp_cd})" ).append("\n"); 
		query.append("				'$sDepRptErrTpCd'," ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				'')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ," ).append("\n"); 
		query.append("    VSL_SKD_T AS " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        -- Last Port 를 추출하기 위한 쿼리" ).append("\n"); 
		query.append("		SELECT ROWNUM AS RN, LST_DEP_PORT_CD_T.* FROM " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("   	        SELECT" ).append("\n"); 
		query.append("   	            T1.VSL_CD ," ).append("\n"); 
		query.append("                T1.SKD_VOY_NO ," ).append("\n"); 
		query.append("                T1.SKD_DIR_CD ," ).append("\n"); 
		query.append("                T1.SLAN_CD ," ).append("\n"); 
		query.append("                LAG (T1.VPS_PORT_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LST_DEP_PORT_CD ," ).append("\n"); 
		query.append("                T1.VPS_PORT_CD ," ).append("\n"); 
		query.append("                T1.CLPT_IND_SEQ ," ).append("\n"); 
		query.append("                T1.VPS_ETD_DT AS VSK_ETD_DT" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD T1, MDM_VSL_SVC_LANE_DIR T2" ).append("\n"); 
		query.append("            WHERE T1.SLAN_CD = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND T1.SKD_DIR_CD = T2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                AND T1.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("                AND NVL(T1.SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("                AND T1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("		) LST_DEP_PORT_CD_T" ).append("\n"); 
		query.append("        -- RCV_DT 로 조회" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ," ).append("\n"); 
		query.append("    DEP_RPT_T AS " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        -- Last Port 의 F.O, LS F.O, D.O, LS D.O, R/UP ENG, On Board 추출 쿼리" ).append("\n"); 
		query.append("        SELECT T8.VSL_CD," ).append("\n"); 
		query.append("            T8.DEP_FOIL_WGT," ).append("\n"); 
		query.append("            T8.DEP_DOIL_WGT," ).append("\n"); 
		query.append("            T8.DEP_LOW_SULP_FOIL_WGT," ).append("\n"); 
		query.append("            T8.DEP_LOW_SULP_DOIL_WGT," ).append("\n"); 
		query.append("            NVL2(T8.RUP_DT,TO_CHAR(T8.RUP_DT, 'YYYYMMDDHH24MI'),'') AS RUP_DT," ).append("\n"); 
		query.append("            T8.RF_CNTR_OBRD_KNT" ).append("\n"); 
		query.append("        FROM FCM_DEP_RPT T8," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT T6.VSL_CD," ).append("\n"); 
		query.append("                T6.SKD_VOY_NO," ).append("\n"); 
		query.append("                T6.SKD_DIR_CD," ).append("\n"); 
		query.append("                T6.VPS_PORT_CD," ).append("\n"); 
		query.append("                T6.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            FROM VSL_SKD_T T6" ).append("\n"); 
		query.append("            WHERE T6.RN = (" ).append("\n"); 
		query.append("                            SELECT T4.RN - 1 AS BEFORE_RN " ).append("\n"); 
		query.append("                            FROM VSL_SKD_T T4, FCM_DEP_RPT_ERR_T T5" ).append("\n"); 
		query.append("                            WHERE T4.VSL_CD = T5.VSL_CD" ).append("\n"); 
		query.append("                                AND T4.SKD_VOY_NO = SUBSTR(T5.SKD_VOY_NO, 1, 4)" ).append("\n"); 
		query.append("                                AND T4.SKD_DIR_CD = SUBSTR(T5.SKD_VOY_NO, 5)" ).append("\n"); 
		query.append("                                AND T4.VPS_PORT_CD = T5.DEP_PORT_CD " ).append("\n"); 
		query.append("                                AND T4.CLPT_IND_SEQ = T5.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                AND ROWNUM = 1" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("        ) T7" ).append("\n"); 
		query.append("        WHERE T8.VSL_CD = T7.VSL_CD" ).append("\n"); 
		query.append("            AND T8.SKD_VOY_NO = T7.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND T8.SKD_DIR_CD = T7.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND T8.DEP_PORT_CD = T7.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND T8.CLPT_IND_SEQ = T7.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM = 1 " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT LST_DEP_PORT_CD " ).append("\n"); 
		query.append("    FROM VSL_SKD_T" ).append("\n"); 
		query.append("    WHERE SKD_VOY_NO = SUBSTR(T9.SKD_VOY_NO, 1, 4)" ).append("\n"); 
		query.append("        AND SKD_DIR_CD = SUBSTR(T9.SKD_VOY_NO, 5)" ).append("\n"); 
		query.append("        AND VPS_PORT_CD = T9.DEP_PORT_CD" ).append("\n"); 
		query.append("        AND SKD_DIR_CD = T9.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND CLPT_IND_SEQ = T9.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append(") AS LST_DEP_PORT_CD ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT CNTR_DZN_CAPA" ).append("\n"); 
		query.append("    FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("    WHERE VSL_CD = T9.VSL_CD" ).append("\n"); 
		query.append("        AND ROWNUM = 1 " ).append("\n"); 
		query.append(") AS CNTR_DZN_CAPA ," ).append("\n"); 
		query.append("T10.DEP_FOIL_WGT AS LST_DEP_FOIL_CTNT ," ).append("\n"); 
		query.append("T10.DEP_LOW_SULP_FOIL_WGT AS LST_DEP_LOW_SULP_FOIL_CTNT ," ).append("\n"); 
		query.append("T10.DEP_DOIL_WGT AS LST_DEP_DOIL_CTNT ," ).append("\n"); 
		query.append("T10.DEP_LOW_SULP_DOIL_WGT AS LST_DEP_LOW_SULP_DOIL_CTNT ," ).append("\n"); 
		query.append("T10.RUP_DT AS LST_PORT_RUP_DT, " ).append("\n"); 
		query.append("T10.RF_CNTR_OBRD_KNT AS LST_RF_CNTR_OBRD_KNT_CTNT," ).append("\n"); 
		query.append("T9.*" ).append("\n"); 
		query.append("FROM FCM_DEP_RPT_ERR_T T9 LEFT OUTER JOIN DEP_RPT_T T10 " ).append("\n"); 
		query.append("ON T9.VSL_CD = T10.VSL_CD" ).append("\n"); 

	}
}