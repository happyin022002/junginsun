/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceDBDAOSearchMonFoilSavCostForCreRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.02 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.performance.performance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceDBDAOSearchMonFoilSavCostForCreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Monthly Fuel Saving Cost 생성을 위하여 정보를 조회한다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * 2012.07.02 이혜민    CHM-201218617-01 [FCM] Departure Report  값을   M/E HS F.O , M/E LS F.O ,  M/E D.O ,  M/E LS D.O 총합으로 수정.
	  * 2013.01.02 진마리아 CHM-201322241-01 FCM 사용 하지않는 소스 및 화면 정리
	  * </pre>
	  */
	public PerformanceDBDAOSearchMonFoilSavCostForCreRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_cost_cre_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.performance.performance.integration").append("\n"); 
		query.append("FileName : PerformanceDBDAOSearchMonFoilSavCostForCreRSQL").append("\n"); 
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
		query.append("SELECT K.SAV_COST_CRE_YRMON," ).append("\n"); 
		query.append("       K.VSL_CLSS_CD," ).append("\n"); 
		query.append("       K.VSL_CD," ).append("\n"); 
		query.append("       K.SKD_VOY_NO," ).append("\n"); 
		query.append("       K.SKD_DIR_CD," ).append("\n"); 
		query.append("       K.VVD," ).append("\n"); 
		query.append("       K.VPS_PORT_CD," ).append("\n"); 
		query.append("       K.CLPT_IND_SEQ," ).append("\n"); 
		query.append("       K.VSL_SLAN_CD," ).append("\n"); 
		query.append("       K.NVGT_DIST," ).append("\n"); 
		query.append("       K.AVG_SPD," ).append("\n"); 
		query.append("       K.AVG_RPM_PWR," ).append("\n"); 
		query.append("       K.PORT_PAIR_SEA_FOIL_CSM_WGT," ).append("\n"); 
		query.append("       @[sav_itm_cd] SAV_ITM_CD," ).append("\n"); 
		query.append("       (SELECT ROUND(N1ST_COEF_VAL*K.AVG_SPD*K.AVG_SPD+N2ND_COEF_VAL*K.AVG_SPD+TRND_LINE_CONS_VAL,4)" ).append("\n"); 
		query.append("       FROM FCM_SAV_ITM_RGST" ).append("\n"); 
		query.append("       WHERE SAV_ITM_CD=@[sav_itm_cd]" ).append("\n"); 
		query.append("       AND ITM_TRND_LINE_CD='01'--LOAD의 TRND LINE" ).append("\n"); 
		query.append("       AND CNTR_VSL_CLSS_CAPA=K.VSL_CLSS_CD" ).append("\n"); 
		query.append("	#if (${sav_itm_cd} == '02') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.FOIL_ADTV_CD" ).append("\n"); 
		query.append("	#elseif (${sav_itm_cd} == '03') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.HL_PNT_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("       ) LOD_IND_QTY," ).append("\n"); 
		query.append("       (SELECT ROUND(N1ST_COEF_VAL*K.AVG_SPD*K.AVG_SPD+N2ND_COEF_VAL*K.AVG_SPD+TRND_LINE_CONS_VAL,4)" ).append("\n"); 
		query.append("       FROM FCM_SAV_ITM_RGST" ).append("\n"); 
		query.append("       WHERE SAV_ITM_CD=@[sav_itm_cd]" ).append("\n"); 
		query.append("       AND ITM_TRND_LINE_CD='02'--FOC의 TRND LINE" ).append("\n"); 
		query.append("       AND CNTR_VSL_CLSS_CAPA=K.VSL_CLSS_CD" ).append("\n"); 
		query.append("	#if (${sav_itm_cd} == '02') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.FOIL_ADTV_CD" ).append("\n"); 
		query.append("	#elseif (${sav_itm_cd} == '03') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.HL_PNT_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("       ) FOIL_CSM_WGT," ).append("\n"); 
		query.append("       (SELECT N1ST_COEF_VAL" ).append("\n"); 
		query.append("       FROM FCM_SAV_ITM_RGST" ).append("\n"); 
		query.append("       WHERE SAV_ITM_CD=@[sav_itm_cd]" ).append("\n"); 
		query.append("       AND ITM_TRND_LINE_CD='03'--SAVING RATIO의 TRND LINE" ).append("\n"); 
		query.append("       AND CNTR_VSL_CLSS_CAPA=K.VSL_CLSS_CD" ).append("\n"); 
		query.append("	#if (${sav_itm_cd} == '02') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.FOIL_ADTV_CD" ).append("\n"); 
		query.append("	#elseif (${sav_itm_cd} == '03') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.HL_PNT_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("       ) SAV_RTO_N1ST," ).append("\n"); 
		query.append("       (SELECT N2ND_COEF_VAL" ).append("\n"); 
		query.append("       FROM FCM_SAV_ITM_RGST" ).append("\n"); 
		query.append("       WHERE SAV_ITM_CD=@[sav_itm_cd]" ).append("\n"); 
		query.append("       AND ITM_TRND_LINE_CD='03'--SAVING RATIO의 TRND LINE" ).append("\n"); 
		query.append("       AND CNTR_VSL_CLSS_CAPA=K.VSL_CLSS_CD" ).append("\n"); 
		query.append("	#if (${sav_itm_cd} == '02') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.FOIL_ADTV_CD" ).append("\n"); 
		query.append("	#elseif (${sav_itm_cd} == '03') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.HL_PNT_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("       ) SAV_RTO_N2ND," ).append("\n"); 
		query.append("       (SELECT TRND_LINE_CONS_VAL" ).append("\n"); 
		query.append("       FROM FCM_SAV_ITM_RGST" ).append("\n"); 
		query.append("       WHERE SAV_ITM_CD=@[sav_itm_cd]" ).append("\n"); 
		query.append("       AND ITM_TRND_LINE_CD='03'--SAVING RATIO의 TRND LINE" ).append("\n"); 
		query.append("       AND CNTR_VSL_CLSS_CAPA=K.VSL_CLSS_CD" ).append("\n"); 
		query.append("	#if (${sav_itm_cd} == '02') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.FOIL_ADTV_CD" ).append("\n"); 
		query.append("	#elseif (${sav_itm_cd} == '03') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.HL_PNT_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("       ) SAV_RTO_CONS," ).append("\n"); 
		query.append("       (SELECT DISTINCT ITM_CSM_RTO" ).append("\n"); 
		query.append("       FROM FCM_SAV_ITM_RGST" ).append("\n"); 
		query.append("       WHERE SAV_ITM_CD=@[sav_itm_cd]" ).append("\n"); 
		query.append("       AND CNTR_VSL_CLSS_CAPA=K.VSL_CLSS_CD" ).append("\n"); 
		query.append("	#if (${sav_itm_cd} == '02') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.FOIL_ADTV_CD" ).append("\n"); 
		query.append("	#elseif (${sav_itm_cd} == '03') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.HL_PNT_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("       ) ITM_CSM_RTO," ).append("\n"); 
		query.append("       (SELECT DISTINCT ITM_UT_PRC" ).append("\n"); 
		query.append("       FROM FCM_SAV_ITM_RGST" ).append("\n"); 
		query.append("       WHERE SAV_ITM_CD=@[sav_itm_cd]" ).append("\n"); 
		query.append("       AND CNTR_VSL_CLSS_CAPA=K.VSL_CLSS_CD" ).append("\n"); 
		query.append("	#if (${sav_itm_cd} == '02') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.FOIL_ADTV_CD" ).append("\n"); 
		query.append("	#elseif (${sav_itm_cd} == '03') " ).append("\n"); 
		query.append("       AND SAV_CSM_SUB_ITM_CD=K.HL_PNT_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("       ) ITM_UT_PRC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT TO_CHAR(V.VPS_ETA_DT,'YYYY-MM') SAV_COST_CRE_YRMON," ).append("\n"); 
		query.append("               (SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR WHERE VSL_CD=V.VSL_CD) VSL_CLSS_CD," ).append("\n"); 
		query.append("               V.VSL_CD," ).append("\n"); 
		query.append("               V.SKD_VOY_NO, " ).append("\n"); 
		query.append("               V.SKD_DIR_CD," ).append("\n"); 
		query.append("               V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("               V.VPS_PORT_CD," ).append("\n"); 
		query.append("               V.CLPT_IND_SEQ, " ).append("\n"); 
		query.append("               V.VPS_ETA_DT," ).append("\n"); 
		query.append("               V.CLPT_SEQ," ).append("\n"); 
		query.append("               V.SLAN_CD VSL_SLAN_CD," ).append("\n"); 
		query.append("               D.NVGT_ML_DIST NVGT_DIST," ).append("\n"); 
		query.append("               D.AVG_SPD," ).append("\n"); 
		query.append("               D.AVG_RPM_PWR," ).append("\n"); 
		query.append("               NVL(D.SEA_MN_FOIL_CSM_QTY,0)+NVL(D.SEA_MN_DOIL_CSM_QTY,0)+NVL(D.SEA_MN_LOW_SULP_FOIL_CSM_QTY ,0)+NVL(D.SEA_MN_LOW_SULP_DOIL_CSM_QTY ,0) PORT_PAIR_SEA_FOIL_CSM_WGT," ).append("\n"); 
		query.append("               R.TBCGR_COFF_FLG," ).append("\n"); 
		query.append("               R.FOIL_ADTV_CD," ).append("\n"); 
		query.append("               R.HL_PNT_CD" ).append("\n"); 
		query.append("        FROM FCM_DEP_RPT D, VSK_VSL_PORT_SKD V, FCM_VSL_CNTR_RGST R" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND V.VSL_CD = D.VSL_CD(+)" ).append("\n"); 
		query.append("        AND V.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND V.SKD_DIR_CD = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND V.VPS_PORT_CD = D.DEP_PORT_CD(+)" ).append("\n"); 
		query.append("        AND V.CLPT_IND_SEQ = D.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("        AND V.SLAN_CD = D.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("        AND V.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("        AND NVL(V.SKD_CNG_STS_CD,' ')<>'S'" ).append("\n"); 
		query.append("        AND TO_CHAR(V.VPS_ETA_DT,'YYYYMM')=@[sav_cost_cre_yrmon]" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("        AND V.SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND V.VSL_CD = R.VSL_CD" ).append("\n"); 
		query.append("	#if (${sav_itm_cd} == '01') " ).append("\n"); 
		query.append("        AND R.TBCGR_COFF_FLG='Y'" ).append("\n"); 
		query.append("	#elseif (${sav_itm_cd} == '02') " ).append("\n"); 
		query.append("        AND R.FOIL_ADTV_CD IS NOT NULL" ).append("\n"); 
		query.append("	#elseif (${sav_itm_cd} == '03')" ).append("\n"); 
		query.append("        AND R.HL_PNT_CD IS NOT NULL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("        AND (V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.VPS_PORT_CD) NOT IN " ).append("\n"); 
		query.append("                 (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD" ).append("\n"); 
		query.append("                  FROM FCM_MON_FUEL_OIL_SAV_COST" ).append("\n"); 
		query.append("                  WHERE VSL_CD=V.VSL_CD" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO=V.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD=V.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND VPS_PORT_CD=V.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND SAV_ITM_CD=@[sav_itm_cd]" ).append("\n"); 
		query.append("                  AND SAV_COST_CRE_YRMON != @[sav_cost_cre_yrmon])" ).append("\n"); 
		query.append(") K" ).append("\n"); 
		query.append("ORDER BY VSL_CLSS_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CLPT_SEQ" ).append("\n"); 

	}
}