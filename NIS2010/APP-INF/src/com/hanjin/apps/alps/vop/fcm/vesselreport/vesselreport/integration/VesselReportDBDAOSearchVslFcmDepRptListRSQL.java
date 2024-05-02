/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VesselReportDBDAOSearchVslFcmDepRptListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
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

public class VesselReportDBDAOSearchVslFcmDepRptListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Departure Report Inquiry 조회
	  * </pre>
	  */
	public VesselReportDBDAOSearchVslFcmDepRptListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("last_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dep_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchVslFcmDepRptListRSQL").append("\n"); 
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
		query.append("WITH VSL_SKD_1 AS (" ).append("\n"); 
		query.append("    -- Last Port 를 추출하기 위한 쿼리" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        T1.VSL_CD" ).append("\n"); 
		query.append("        ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,T1.SLAN_CD" ).append("\n"); 
		query.append("        ,LAG (T1.VPS_PORT_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS LAST_PORT_CD" ).append("\n"); 
		query.append("        ,T1.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,T1.VPS_ETD_DT AS VSK_ETD_DT" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD T1, MDM_VSL_SVC_LANE_DIR T2" ).append("\n"); 
		query.append("    WHERE T1.SLAN_CD = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("    AND T1.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("    AND NVL(T1.SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("    AND T1.VSL_CD IN (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        T1.VSL_CD" ).append("\n"); 
		query.append("        FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("        WHERE T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("        AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("        AND T1.CRR_CD='SML'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#if(${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("    AND T1.VPS_ETD_DT BETWEEN ADD_MONTHS(TO_DATE(@[fm_dt], 'YYYY-MM-DD'), -2) AND TO_DATE(@[to_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("	AND T1.SLAN_CD IN (" ).append("\n"); 
		query.append("	#foreach($sVslSlanCd in ${vel_vsl_slan_cd})" ).append("\n"); 
		query.append("		'$sVslSlanCd'," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_cd} != '' )" ).append("\n"); 
		query.append("    AND T1.VSL_CD IN (                     " ).append("\n"); 
		query.append("	#foreach($sVslCd in ${vel_vsl_cd})  " ).append("\n"); 
		query.append("		'$sVslCd',  " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("		'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VSL_SKD_2 AS (" ).append("\n"); 
		query.append("    -- Last Port 포함 Vessel Schedule 기준 데이터를 추출하기 위한 쿼리" ).append("\n"); 
		query.append("    SELECT T1.*" ).append("\n"); 
		query.append("    FROM VSL_SKD_1 T1, VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("    WHERE T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("    AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND T1.VPS_PORT_CD = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("    AND T1.CLPT_IND_SEQ = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND T2.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("    AND NVL(T2.SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("    AND T1.VSL_CD IN (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        T1.VSL_CD" ).append("\n"); 
		query.append("        FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("        WHERE T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("        AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("        AND T1.CRR_CD='SML'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#if(${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("    AND T2.VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("	AND T2.SLAN_CD IN (" ).append("\n"); 
		query.append("	#foreach($sVslSlanCd in ${vel_vsl_slan_cd})" ).append("\n"); 
		query.append("		'$sVslSlanCd'," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_cd} != '' )" ).append("\n"); 
		query.append("    AND T2.VSL_CD IN (                     " ).append("\n"); 
		query.append("	#foreach($sVslCd in ${vel_vsl_cd})  " ).append("\n"); 
		query.append("		'$sVslCd',  " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("		'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${last_port} != '' )" ).append("\n"); 
		query.append("	AND T1.LAST_PORT_CD = @[last_port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${dep_port} != '' )" ).append("\n"); 
		query.append("	AND T2.VPS_PORT_CD = @[dep_port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${skd_dir_cd} != '' )" ).append("\n"); 
		query.append("    AND T2.SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    -- Vessel Schedule 기준 Departure Report" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        'Y' AS VSK_FLG," ).append("\n"); 
		query.append("		DECODE(DEP.CLPT_IND_SEQ, NULL, 'N', 'Y') AS DEP_FLG," ).append("\n"); 
		query.append("		SKD.SKD_VOY_NO," ).append("\n"); 
		query.append("		SKD.SKD_DIR_CD," ).append("\n"); 
		query.append("		SKD.CLPT_IND_SEQ," ).append("\n"); 
		query.append("        DECODE(DEP.AVG_EXPT_FLG, NULL, 'N', DEP.AVG_EXPT_FLG) AS AVG_EXPT_FLG," ).append("\n"); 
		query.append("        (SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR WHERE VSL_CD = SKD.VSL_CD) AS CNTR_DZN_CAPA," ).append("\n"); 
		query.append("        SKD.VSL_CD," ).append("\n"); 
		query.append("        SKD.SKD_VOY_NO || SKD.SKD_DIR_CD AS SKD_VOY_DIR," ).append("\n"); 
		query.append("        SKD.SLAN_CD AS VSL_SLAN_CD," ).append("\n"); 
		query.append("        SKD.LAST_PORT_CD," ).append("\n"); 
		query.append("        SKD.VPS_PORT_CD AS DEP_PORT_CD," ).append("\n"); 
		query.append("		TO_CHAR(SKD.VSK_ETD_DT, 'YYYY.MM.DD HH24:MI') AS VSK_ETD_DT," ).append("\n"); 
		query.append("        NVGT_ML_DIST," ).append("\n"); 
		query.append("        ENG_ML_DIST," ).append("\n"); 
		query.append("        MNVR_IN_ML_DIST," ).append("\n"); 
		query.append("        MNVR_OUT_ML_DIST," ).append("\n"); 
		query.append("        AVG_SPD," ).append("\n"); 
		query.append("        AVG_RPM_PWR," ).append("\n"); 
		query.append("        CASE WHEN ROUND(AVG_SPD, 1) <> 0 AND ROUND(AVG_RPM_PWR, 1) <> 0 AND ((NVGT_ML_DIST / AVG_SPD) * 60 * AVG_RPM_PWR) <> 0" ).append("\n"); 
		query.append("            THEN ROUND(ENG_ML_DIST / ((NVGT_ML_DIST / AVG_SPD) * 60 * AVG_RPM_PWR), 7)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS PRO_PITCH," ).append("\n"); 
		query.append("        CASE WHEN ROUND(AVG_SPD, 1) <> 0" ).append("\n"); 
		query.append("            THEN ROUND(NVGT_ML_DIST / AVG_SPD, 1)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SAILING_TIME," ).append("\n"); 
		query.append("		CASE WHEN ROUND(NVL(SEA_MN_FOIL_CSM_QTY, 0) + NVL(SEA_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_MN_DOIL_CSM_QTY, 0) + NVL(SEA_MN_LOW_SULP_DOIL_CSM_QTY, 0), 1) <> 0" ).append("\n"); 
		query.append("            THEN ROUND(NVL(SEA_MN_FOIL_CSM_QTY, 0) + NVL(SEA_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_MN_DOIL_CSM_QTY, 0) + NVL(SEA_MN_LOW_SULP_DOIL_CSM_QTY, 0), 1)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_STEAMING_ME," ).append("\n"); 
		query.append("		CASE WHEN ROUND(NVL(SEA_MN_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(SEA_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("			    + NVL(SEA_MN_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(SEA_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_DOIL_CSM_QTY, 0), 1) <> 0" ).append("\n"); 
		query.append("            THEN ROUND(NVL(SEA_MN_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(SEA_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("			    + NVL(SEA_MN_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(SEA_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_DOIL_CSM_QTY, 0), 1)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_STEAMING_TTL," ).append("\n"); 
		query.append("		CASE WHEN ROUND(NVL(PORT_MN_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(PORT_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("			    + NVL(PORT_MN_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(PORT_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_DOIL_CSM_QTY, 0), 1) <> 0" ).append("\n"); 
		query.append("            THEN ROUND(NVL(PORT_MN_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(PORT_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("			    + NVL(PORT_MN_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(PORT_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_DOIL_CSM_QTY, 0), 1)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS HARBOR_IN_PORT_TTL," ).append("\n"); 
		query.append("        SEA_MN_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_GNR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_BLR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN SEA_MN_FOIL_CSM_QTY IS NOT NULL OR SEA_GNR_FOIL_CSM_QTY IS NOT NULL OR SEA_BLR_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(SEA_MN_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_TTL_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_MN_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_GNR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_BLR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN SEA_MN_LOW_SULP_FOIL_CSM_QTY IS NOT NULL OR SEA_GNR_LOW_SULP_FOIL_CSM_QTY IS NOT NULL OR SEA_BLR_LOW_SULP_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(SEA_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_TTL_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_MN_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_GNR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_BLR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN SEA_MN_DOIL_CSM_QTY IS NOT NULL OR SEA_GNR_DOIL_CSM_QTY IS NOT NULL OR SEA_BLR_DOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(SEA_MN_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_TTL_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_MN_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_GNR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_BLR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN SEA_MN_LOW_SULP_DOIL_CSM_QTY IS NOT NULL OR SEA_GNR_LOW_SULP_DOIL_CSM_QTY IS NOT NULL OR SEA_BLR_LOW_SULP_DOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(SEA_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_TTL_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_MN_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_GNR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_BLR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN PORT_MN_FOIL_CSM_QTY IS NOT NULL OR PORT_GNR_FOIL_CSM_QTY IS NOT NULL OR PORT_BLR_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(PORT_MN_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS PORT_TTL_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_MN_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_GNR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_BLR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN PORT_MN_LOW_SULP_FOIL_CSM_QTY IS NOT NULL OR PORT_GNR_LOW_SULP_FOIL_CSM_QTY IS NOT NULL OR PORT_BLR_LOW_SULP_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(PORT_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS PORT_TTL_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_MN_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_GNR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_BLR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN PORT_MN_DOIL_CSM_QTY IS NOT NULL OR PORT_GNR_DOIL_CSM_QTY IS NOT NULL OR PORT_BLR_DOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(PORT_MN_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS PORT_TTL_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_MN_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_GNR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_BLR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN PORT_MN_LOW_SULP_DOIL_CSM_QTY IS NOT NULL OR PORT_GNR_LOW_SULP_DOIL_CSM_QTY IS NOT NULL OR PORT_BLR_LOW_SULP_DOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(PORT_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS PORT_TTL_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        ARR_FOIL_WGT," ).append("\n"); 
		query.append("        ARR_LOW_SULP_FOIL_WGT," ).append("\n"); 
		query.append("        ARR_DOIL_WGT," ).append("\n"); 
		query.append("        ARR_LOW_SULP_DOIL_WGT," ).append("\n"); 
		query.append("        ARR_FRSH_WTR_WGT," ).append("\n"); 
		query.append("        ARR_BLST_WGT," ).append("\n"); 
		query.append("        DEP_FOIL_WGT," ).append("\n"); 
		query.append("        DEP_LOW_SULP_FOIL_WGT," ).append("\n"); 
		query.append("        DEP_DOIL_WGT," ).append("\n"); 
		query.append("        DEP_LOW_SULP_DOIL_WGT," ).append("\n"); 
		query.append("        DEP_FRSH_WTR_WGT," ).append("\n"); 
		query.append("        DEP_BLST_WGT," ).append("\n"); 
		query.append("        SPL_FOIL_BDR_WGT," ).append("\n"); 
		query.append("        SPL_FOIL_ACT_WGT," ).append("\n"); 
		query.append("        SPL_FOIL_SULP_WGT," ).append("\n"); 
		query.append("        SPL_FOIL_BRG_WGT1," ).append("\n"); 
		query.append("        SPL_FOIL_BRG_WGT2," ).append("\n"); 
		query.append("        SPL_LOW_SULP_FOIL_BDR_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_FOIL_ACT_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_FOIL_SULP_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_FOIL_BRG_WGT1," ).append("\n"); 
		query.append("        SPL_LOW_SULP_FOIL_BRG_WGT2," ).append("\n"); 
		query.append("        SPL_DOIL_BDR_WGT," ).append("\n"); 
		query.append("        SPL_DOIL_ACT_WGT," ).append("\n"); 
		query.append("        SPL_DOIL_SULP_WGT," ).append("\n"); 
		query.append("        SPL_DOIL_BRG_WGT1," ).append("\n"); 
		query.append("        SPL_DOIL_BRG_WGT2," ).append("\n"); 
		query.append("        SPL_LOW_SULP_DOIL_BDR_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_DOIL_ACT_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_DOIL_SULP_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_DOIL_BRG_WGT1," ).append("\n"); 
		query.append("        SPL_LOW_SULP_DOIL_BRG_WGT2," ).append("\n"); 
		query.append("        NXT_PORT_CD," ).append("\n"); 
		query.append("        TO_CHAR(NXT_PORT_ETA_DT, 'YYYY.MM.DD HH24:MI') AS NXT_PORT_ETA_DT," ).append("\n"); 
		query.append("        RMN_DIST," ).append("\n"); 
		query.append("        RMN_AVG_SPD," ).append("\n"); 
		query.append("        TO_CHAR(SB_ENG_DT, 'YYYY.MM.DD HH24:MI') AS SB_ENG_DT," ).append("\n"); 
		query.append("        TO_CHAR(PLT_IN_DT, 'YYYY.MM.DD HH24:MI') AS PLT_IN_DT," ).append("\n"); 
		query.append("        TO_CHAR(BFR_BRTH_ANK_DRP_DT, 'YYYY.MM.DD HH24:MI') AS BFR_BRTH_ANK_DRP_DT," ).append("\n"); 
		query.append("        TO_CHAR(BFR_BRTH_ANK_OFF_DT, 'YYYY.MM.DD HH24:MI') AS BFR_BRTH_ANK_OFF_DT," ).append("\n"); 
		query.append("        TO_CHAR(VPS_ETB_DT, 'YYYY.MM.DD HH24:MI') AS VPS_ETB_DT," ).append("\n"); 
		query.append("        TO_CHAR(CGO_WRK_ST_DT, 'YYYY.MM.DD HH24:MI') AS CGO_WRK_ST_DT," ).append("\n"); 
		query.append("        TO_CHAR(CGO_WRK_END_DT, 'YYYY.MM.DD HH24:MI') AS CGO_WRK_END_DT," ).append("\n"); 
		query.append("        TO_CHAR(VPS_ETD_DT, 'YYYY.MM.DD HH24:MI') AS VPS_ETD_DT," ).append("\n"); 
		query.append("        TO_CHAR(AFT_UNBRTH_ANK_DRP_DT, 'YYYY.MM.DD HH24:MI') AS AFT_UNBRTH_ANK_DRP_DT," ).append("\n"); 
		query.append("        TO_CHAR(AFT_UNBRTH_ANK_OFF_DT, 'YYYY.MM.DD HH24:MI') AS AFT_UNBRTH_ANK_OFF_DT," ).append("\n"); 
		query.append("        TO_CHAR(PLT_OUT_DT, 'YYYY.MM.DD HH24:MI') AS PLT_OUT_DT," ).append("\n"); 
		query.append("        TO_CHAR(RUP_DT, 'YYYY.MM.DD HH24:MI') AS RUP_DT," ).append("\n"); 
		query.append("        ARR_FWDDR_HGT," ).append("\n"); 
		query.append("        ARR_MID_DRFT_HGT," ).append("\n"); 
		query.append("        ARR_AFTDR_HGT," ).append("\n"); 
		query.append("        ARR_GM_HGT," ).append("\n"); 
		query.append("        DEP_FWDDR_HGT," ).append("\n"); 
		query.append("        DEP_MID_DRFT_HGT," ).append("\n"); 
		query.append("        DEP_AFTDR_HGT," ).append("\n"); 
		query.append("        DEP_GM_HGT," ).append("\n"); 
		query.append("        FULL_CNTR_OBRD_TEU," ).append("\n"); 
		query.append("        MTY_CNTR_OBRD_TEU," ).append("\n"); 
		query.append("        TTL_CNTR_OBRD_TEU," ).append("\n"); 
		query.append("        DEP_CGO_WGT," ).append("\n"); 
		query.append("        DEP_DPL_WGT," ).append("\n"); 
		query.append("        RF_CNTR_DCHG_KNT," ).append("\n"); 
		query.append("        RF_CNTR_LOD_KNT," ).append("\n"); 
		query.append("        RF_CNTR_OBRD_KNT" ).append("\n"); 
		query.append("    FROM VSL_SKD_2 SKD, FCM_DEP_RPT DEP" ).append("\n"); 
		query.append("    WHERE SKD.VSL_CD = DEP.VSL_CD(+)" ).append("\n"); 
		query.append("    AND SKD.SKD_VOY_NO = DEP.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND SKD.SKD_DIR_CD = DEP.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND SKD.VPS_PORT_CD = DEP.DEP_PORT_CD(+)" ).append("\n"); 
		query.append("    AND SKD.CLPT_IND_SEQ = DEP.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    -- Vessel Schedule 에 존재하지 않는 Departure Report" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        'N' AS VSK_FLG," ).append("\n"); 
		query.append("		'Y' AS DEP_FLG," ).append("\n"); 
		query.append("		SKD_VOY_NO," ).append("\n"); 
		query.append("		SKD_DIR_CD," ).append("\n"); 
		query.append("		CLPT_IND_SEQ," ).append("\n"); 
		query.append("        AVG_EXPT_FLG," ).append("\n"); 
		query.append("        (SELECT CNTR_DZN_CAPA FROM MDM_VSL_CNTR WHERE VSL_CD = DEP.VSL_CD) AS CNTR_DZN_CAPA," ).append("\n"); 
		query.append("        VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO || SKD_DIR_CD AS SKD_VOY_DIR," ).append("\n"); 
		query.append("        VSL_SLAN_CD," ).append("\n"); 
		query.append("        NULL AS LAST_PORT_CD," ).append("\n"); 
		query.append("        DEP_PORT_CD," ).append("\n"); 
		query.append("		NULL AS VSK_ETD_DT," ).append("\n"); 
		query.append("        NVGT_ML_DIST," ).append("\n"); 
		query.append("        ENG_ML_DIST," ).append("\n"); 
		query.append("        MNVR_IN_ML_DIST," ).append("\n"); 
		query.append("        MNVR_OUT_ML_DIST," ).append("\n"); 
		query.append("        AVG_SPD," ).append("\n"); 
		query.append("        AVG_RPM_PWR," ).append("\n"); 
		query.append("        CASE WHEN ROUND(AVG_SPD, 1) <> 0 AND ROUND(AVG_RPM_PWR, 1) <> 0 AND ((NVGT_ML_DIST / AVG_SPD) * 60 * AVG_RPM_PWR) <> 0" ).append("\n"); 
		query.append("            THEN ROUND(ENG_ML_DIST / ((NVGT_ML_DIST / AVG_SPD) * 60 * AVG_RPM_PWR), 7)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS PRO_PITCH," ).append("\n"); 
		query.append("        CASE WHEN ROUND(AVG_SPD, 1) <> 0" ).append("\n"); 
		query.append("            THEN ROUND(NVGT_ML_DIST / AVG_SPD, 1)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SAILING_TIME," ).append("\n"); 
		query.append("		CASE WHEN ROUND(NVL(SEA_MN_FOIL_CSM_QTY, 0) + NVL(SEA_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_MN_DOIL_CSM_QTY, 0) + NVL(SEA_MN_LOW_SULP_DOIL_CSM_QTY, 0), 1) <> 0" ).append("\n"); 
		query.append("            THEN ROUND(NVL(SEA_MN_FOIL_CSM_QTY, 0) + NVL(SEA_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_MN_DOIL_CSM_QTY, 0) + NVL(SEA_MN_LOW_SULP_DOIL_CSM_QTY, 0), 1)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_STEAMING_ME," ).append("\n"); 
		query.append("		CASE WHEN ROUND(NVL(SEA_MN_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(SEA_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("			    + NVL(SEA_MN_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(SEA_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_DOIL_CSM_QTY, 0), 1) <> 0" ).append("\n"); 
		query.append("            THEN ROUND(NVL(SEA_MN_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(SEA_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("			    + NVL(SEA_MN_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(SEA_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_DOIL_CSM_QTY, 0), 1)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_STEAMING_TTL," ).append("\n"); 
		query.append("		CASE WHEN ROUND(NVL(PORT_MN_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(PORT_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("			    + NVL(PORT_MN_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(PORT_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_DOIL_CSM_QTY, 0), 1) <> 0" ).append("\n"); 
		query.append("            THEN ROUND(NVL(PORT_MN_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(PORT_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("			    + NVL(PORT_MN_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("                + NVL(PORT_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_DOIL_CSM_QTY, 0), 1)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS HARBOR_IN_PORT_TTL," ).append("\n"); 
		query.append("        SEA_MN_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_GNR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_BLR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN SEA_MN_FOIL_CSM_QTY IS NOT NULL OR SEA_GNR_FOIL_CSM_QTY IS NOT NULL OR SEA_BLR_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(SEA_MN_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_TTL_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_MN_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_GNR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_BLR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN SEA_MN_LOW_SULP_FOIL_CSM_QTY IS NOT NULL OR SEA_GNR_LOW_SULP_FOIL_CSM_QTY IS NOT NULL OR SEA_BLR_LOW_SULP_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(SEA_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_TTL_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_MN_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_GNR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_BLR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN SEA_MN_DOIL_CSM_QTY IS NOT NULL OR SEA_GNR_DOIL_CSM_QTY IS NOT NULL OR SEA_BLR_DOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(SEA_MN_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_TTL_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_MN_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_GNR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        SEA_BLR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN SEA_MN_LOW_SULP_DOIL_CSM_QTY IS NOT NULL OR SEA_GNR_LOW_SULP_DOIL_CSM_QTY IS NOT NULL OR SEA_BLR_LOW_SULP_DOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(SEA_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(SEA_BLR_LOW_SULP_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS SEA_TTL_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_MN_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_GNR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_BLR_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN PORT_MN_FOIL_CSM_QTY IS NOT NULL OR PORT_GNR_FOIL_CSM_QTY IS NOT NULL OR PORT_BLR_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(PORT_MN_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS PORT_TTL_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_MN_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_GNR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_BLR_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN PORT_MN_LOW_SULP_FOIL_CSM_QTY IS NOT NULL OR PORT_GNR_LOW_SULP_FOIL_CSM_QTY IS NOT NULL OR PORT_BLR_LOW_SULP_FOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(PORT_MN_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_FOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_FOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS PORT_TTL_LOW_SULP_FOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_MN_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_GNR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_BLR_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN PORT_MN_DOIL_CSM_QTY IS NOT NULL OR PORT_GNR_DOIL_CSM_QTY IS NOT NULL OR PORT_BLR_DOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(PORT_MN_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS PORT_TTL_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_MN_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_GNR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        PORT_BLR_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        CASE WHEN PORT_MN_LOW_SULP_DOIL_CSM_QTY IS NOT NULL OR PORT_GNR_LOW_SULP_DOIL_CSM_QTY IS NOT NULL OR PORT_BLR_LOW_SULP_DOIL_CSM_QTY IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(PORT_MN_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_GNR_LOW_SULP_DOIL_CSM_QTY, 0) + NVL(PORT_BLR_LOW_SULP_DOIL_CSM_QTY, 0)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS PORT_TTL_LOW_SULP_DOIL_CSM_QTY," ).append("\n"); 
		query.append("        ARR_FOIL_WGT," ).append("\n"); 
		query.append("        ARR_LOW_SULP_FOIL_WGT," ).append("\n"); 
		query.append("        ARR_DOIL_WGT," ).append("\n"); 
		query.append("        ARR_LOW_SULP_DOIL_WGT," ).append("\n"); 
		query.append("        ARR_FRSH_WTR_WGT," ).append("\n"); 
		query.append("        ARR_BLST_WGT," ).append("\n"); 
		query.append("        DEP_FOIL_WGT," ).append("\n"); 
		query.append("        DEP_LOW_SULP_FOIL_WGT," ).append("\n"); 
		query.append("        DEP_DOIL_WGT," ).append("\n"); 
		query.append("        DEP_LOW_SULP_DOIL_WGT," ).append("\n"); 
		query.append("        DEP_FRSH_WTR_WGT," ).append("\n"); 
		query.append("        DEP_BLST_WGT," ).append("\n"); 
		query.append("        SPL_FOIL_BDR_WGT," ).append("\n"); 
		query.append("        SPL_FOIL_ACT_WGT," ).append("\n"); 
		query.append("        SPL_FOIL_SULP_WGT," ).append("\n"); 
		query.append("        SPL_FOIL_BRG_WGT1," ).append("\n"); 
		query.append("        SPL_FOIL_BRG_WGT2," ).append("\n"); 
		query.append("        SPL_LOW_SULP_FOIL_BDR_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_FOIL_ACT_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_FOIL_SULP_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_FOIL_BRG_WGT1," ).append("\n"); 
		query.append("        SPL_LOW_SULP_FOIL_BRG_WGT2," ).append("\n"); 
		query.append("        SPL_DOIL_BDR_WGT," ).append("\n"); 
		query.append("        SPL_DOIL_ACT_WGT," ).append("\n"); 
		query.append("        SPL_DOIL_SULP_WGT," ).append("\n"); 
		query.append("        SPL_DOIL_BRG_WGT1," ).append("\n"); 
		query.append("        SPL_DOIL_BRG_WGT2," ).append("\n"); 
		query.append("        SPL_LOW_SULP_DOIL_BDR_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_DOIL_ACT_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_DOIL_SULP_WGT," ).append("\n"); 
		query.append("        SPL_LOW_SULP_DOIL_BRG_WGT1," ).append("\n"); 
		query.append("        SPL_LOW_SULP_DOIL_BRG_WGT2," ).append("\n"); 
		query.append("        NXT_PORT_CD," ).append("\n"); 
		query.append("        TO_CHAR(NXT_PORT_ETA_DT, 'YYYY.MM.DD HH24:MI') AS NXT_PORT_ETA_DT," ).append("\n"); 
		query.append("        RMN_DIST," ).append("\n"); 
		query.append("        RMN_AVG_SPD," ).append("\n"); 
		query.append("        TO_CHAR(SB_ENG_DT, 'YYYY.MM.DD HH24:MI') AS SB_ENG_DT," ).append("\n"); 
		query.append("        TO_CHAR(PLT_IN_DT, 'YYYY.MM.DD HH24:MI') AS PLT_IN_DT," ).append("\n"); 
		query.append("        TO_CHAR(BFR_BRTH_ANK_DRP_DT, 'YYYY.MM.DD HH24:MI') AS BFR_BRTH_ANK_DRP_DT," ).append("\n"); 
		query.append("        TO_CHAR(BFR_BRTH_ANK_OFF_DT, 'YYYY.MM.DD HH24:MI') AS BFR_BRTH_ANK_OFF_DT," ).append("\n"); 
		query.append("        TO_CHAR(VPS_ETB_DT, 'YYYY.MM.DD HH24:MI') AS VPS_ETB_DT," ).append("\n"); 
		query.append("        TO_CHAR(CGO_WRK_ST_DT, 'YYYY.MM.DD HH24:MI') AS CGO_WRK_ST_DT," ).append("\n"); 
		query.append("        TO_CHAR(CGO_WRK_END_DT, 'YYYY.MM.DD HH24:MI') AS CGO_WRK_END_DT," ).append("\n"); 
		query.append("        TO_CHAR(VPS_ETD_DT, 'YYYY.MM.DD HH24:MI') AS VPS_ETD_DT," ).append("\n"); 
		query.append("        TO_CHAR(AFT_UNBRTH_ANK_DRP_DT, 'YYYY.MM.DD HH24:MI') AS AFT_UNBRTH_ANK_DRP_DT," ).append("\n"); 
		query.append("        TO_CHAR(AFT_UNBRTH_ANK_OFF_DT, 'YYYY.MM.DD HH24:MI') AS AFT_UNBRTH_ANK_OFF_DT," ).append("\n"); 
		query.append("        TO_CHAR(PLT_OUT_DT, 'YYYY.MM.DD HH24:MI') AS PLT_OUT_DT," ).append("\n"); 
		query.append("        TO_CHAR(RUP_DT, 'YYYY.MM.DD HH24:MI') AS RUP_DT," ).append("\n"); 
		query.append("        ARR_FWDDR_HGT," ).append("\n"); 
		query.append("        ARR_MID_DRFT_HGT," ).append("\n"); 
		query.append("        ARR_AFTDR_HGT," ).append("\n"); 
		query.append("        ARR_GM_HGT," ).append("\n"); 
		query.append("        DEP_FWDDR_HGT," ).append("\n"); 
		query.append("        DEP_MID_DRFT_HGT," ).append("\n"); 
		query.append("        DEP_AFTDR_HGT," ).append("\n"); 
		query.append("        DEP_GM_HGT," ).append("\n"); 
		query.append("        FULL_CNTR_OBRD_TEU," ).append("\n"); 
		query.append("        MTY_CNTR_OBRD_TEU," ).append("\n"); 
		query.append("        TTL_CNTR_OBRD_TEU," ).append("\n"); 
		query.append("        DEP_CGO_WGT," ).append("\n"); 
		query.append("        DEP_DPL_WGT," ).append("\n"); 
		query.append("        RF_CNTR_DCHG_KNT," ).append("\n"); 
		query.append("        RF_CNTR_LOD_KNT," ).append("\n"); 
		query.append("        RF_CNTR_OBRD_KNT" ).append("\n"); 
		query.append("    FROM FCM_DEP_RPT DEP" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("    AND VSL_CD IN (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        T1.VSL_CD" ).append("\n"); 
		query.append("        FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("        WHERE T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("        AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("        AND T1.CRR_CD='SML'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#if(${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("    AND NVL(VPS_ETD_DT, RUP_DT) BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("	AND VSL_SLAN_CD IN (" ).append("\n"); 
		query.append("	#foreach($sVslSlanCd in ${vel_vsl_slan_cd})" ).append("\n"); 
		query.append("		'$sVslSlanCd'," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_cd} != '' )" ).append("\n"); 
		query.append("    AND VSL_CD IN (                     " ).append("\n"); 
		query.append("	#foreach($sVslCd in ${vel_vsl_cd})  " ).append("\n"); 
		query.append("		'$sVslCd',  " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("		'') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${dep_port} != '' )" ).append("\n"); 
		query.append("	AND DEP_PORT_CD = @[dep_port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${skd_dir_cd} != '' )" ).append("\n"); 
		query.append("    AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND NOT EXISTS (" ).append("\n"); 
		query.append("        SELECT 1" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("        WHERE SKD.VSL_CD = DEP.VSL_CD" ).append("\n"); 
		query.append("        AND SKD.SKD_VOY_NO = DEP.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND SKD.SKD_DIR_CD = DEP.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND SKD.VPS_PORT_CD = DEP.DEP_PORT_CD" ).append("\n"); 
		query.append("        AND SKD.CLPT_IND_SEQ = DEP.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND SKD.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("        AND NVL(SKD.SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("        AND SKD.VSL_CD IN (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("            T1.VSL_CD" ).append("\n"); 
		query.append("            FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("            WHERE T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("            AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("            AND T1.CRR_CD='SML'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY VSL_CD, NVL(RUP_DT, VSK_ETD_DT) DESC" ).append("\n"); 

	}
}