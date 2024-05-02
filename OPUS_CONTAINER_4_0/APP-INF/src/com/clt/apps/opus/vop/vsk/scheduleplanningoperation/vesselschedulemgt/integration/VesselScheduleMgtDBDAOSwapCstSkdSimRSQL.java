/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSwapCstSkdSimRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSwapCstSkdSimRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Costal SKD Update & Simulation에 필요한 Port SKD 정보와 PF SKD 정보를 조회한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSwapCstSkdSimRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSwapCstSkdSimRSQL").append("\n"); 
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
		query.append("SELECT 	 T51.SEQ" ).append("\n"); 
		query.append("       , T51.VSL_CD" ).append("\n"); 
		query.append("       , T51.SKD_VOY_NO" ).append("\n"); 
		query.append("       , T51.SKD_DIR_CD" ).append("\n"); 
		query.append("       , T51.VSL_CD||T51.SKD_VOY_NO||T51.SKD_DIR_CD 		AS VVD" ).append("\n"); 
		query.append("       , T51.VSL_SLAN_CD" ).append("\n"); 
		query.append("	   , T51.SKD_STS_CD" ).append("\n"); 
		query.append("       , T51.SKD_VOY_TP_CD" ).append("\n"); 
		query.append("	   , T51.SKD_USD_IND_CD" ).append("\n"); 
		query.append("       , T51.PF_SKD_TP_CD" ).append("\n"); 
		query.append("	   , T51.ST_PORT_CD" ).append("\n"); 
		query.append("	   , TO_CHAR(T51.N1ST_PORT_BRTH_DT, 'YYYYMMDDHH24MI') 	AS N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("       , T51.PSDO_VVD_CD" ).append("\n"); 
		query.append("       , T51.CO_CD" ).append("\n"); 
		query.append("       , REPLACE(T51.SKD_RMK,CHR(1),'') 					AS SKD_RMK" ).append("\n"); 
		query.append("       , T51.CRE_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(T51.CRE_DT,'YYYYMMDDHH24MI') 				AS CRE_DT" ).append("\n"); 
		query.append("       , T51.UPD_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(T51.UPD_DT,'YYYYMMDDHH24MISS') 			AS UPD_DT" ).append("\n"); 
		query.append("       , T51.VPS_PORT_CD" ).append("\n"); 
		query.append("       , T51.CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , T51.CLPT_SEQ" ).append("\n"); 
		query.append("       , CASE	WHEN T51.TURN_PORT_IND_CD IN ('Y','N') THEN" ).append("\n"); 
		query.append("                (SELECT    MIN(PS.CLPT_SEQ)" ).append("\n"); 
		query.append("              	FROM      VSK_VSL_PORT_SKD      PS" ).append("\n"); 
		query.append("              	WHERE     PS.VSL_CD             = T51.VSL_CD" ).append("\n"); 
		query.append("              	AND       PS.SKD_VOY_NO         = T51.SKD_VOY_NO" ).append("\n"); 
		query.append("              	AND       PS.SKD_DIR_CD         = T51.SKD_DIR_CD" ).append("\n"); 
		query.append("              	AND       PS.TURN_SKD_VOY_NO    IS NOT NULL" ).append("\n"); 
		query.append("              	AND       PS.TURN_PORT_IND_CD   IN ('Y','N')" ).append("\n"); 
		query.append("              	)" ).append("\n"); 
		query.append("              	ELSE NULL" ).append("\n"); 
		query.append("		 END	FIRST_TURN_PORT_CLPT_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , T51.SLAN_CD" ).append("\n"); 
		query.append("       , T51.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("       , T51.YD_CD" ).append("\n"); 
		query.append("       , DECODE(T51.YD_CD, NULL, '', SUBSTR(T51.YD_CD, 6, 2)) AS TML_CD" ).append("\n"); 
		query.append("       , T51.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("       , TO_CHAR(T51.PF_ETA_DT, 'YYYYMMDDHH24MI') AS PF_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T51.PF_ETB_DT, 'YYYYMMDDHH24MI') AS PF_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T51.PF_ETD_DT, 'YYYYMMDDHH24MI') AS PF_ETD_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T51.INIT_ETA_DT, 'YYYYMMDDHH24MI') AS INIT_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T51.INIT_ETB_DT, 'YYYYMMDDHH24MI') AS INIT_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T51.INIT_ETD_DT, 'YYYYMMDDHH24MI') AS INIT_ETD_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T51.VPS_ETA_DT, 'YYYYMMDDHH24MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T51.VPS_ETB_DT, 'YYYYMMDDHH24MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T51.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("       , T51.VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("       , T51.VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append("       , T51.VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append("       , T51.SHP_CALL_NO" ).append("\n"); 
		query.append("       , T51.SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(T51.SHP_CALL_NO_UPD_DT, 'YYYYMMDDHH24MI') AS SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append("       , T51.TML_VSL_CD" ).append("\n"); 
		query.append("       , T51.TML_VOY_NO" ).append("\n"); 
		query.append("       , TO_CHAR(T51.FT_DT, 'YYYYMMDDHH24MI') AS FT_DT" ).append("\n"); 
		query.append("       , T51.PLISM_YD_CD" ).append("\n"); 
		query.append("       , T51.PLISM_VSL_CD" ).append("\n"); 
		query.append("       , T51.PLISM_VOY_NO" ).append("\n"); 
		query.append("       , T51.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("       , T51.TURN_PORT_FLG" ).append("\n"); 
		query.append("       , T51.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("       , T51.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("       , T51.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("       , T51.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       , T51.IB_CGO_QTY" ).append("\n"); 
		query.append("       , T51.OB_CGO_QTY" ).append("\n"); 
		query.append("       , T51.VPS_RMK" ).append("\n"); 
		query.append("       , RTRIM(REPLACE(T51.VPS_RMK, CHR(13)||CHR(10),' ')) AS WIN_RMK 	/* 화면 조회 용 */" ).append("\n"); 
		query.append("       , T51.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("       , T51.PHS_IO_RMK" ).append("\n"); 
		query.append("       , T51.SKD_BRTH_NO" ).append("\n"); 
		query.append("       , T51.INIT_SKD_INP_FLG" ).append("\n"); 
		query.append("       , T51.OFC_INP_FLG" ).append("\n"); 
		query.append("--       , T51.NOON_RPT_INP_FLG	/* Data 불일치로 사용안함 */" ).append("\n"); 
		query.append("       , 'N'   AS NOON_RPT_INP_FLG" ).append("\n"); 
		query.append("--       , T51.DEP_RPT_INP_FLG	/* Data 불일치로 사용안함 */" ).append("\n"); 
		query.append("       , T51.DEP_RPT_FLG    AS DEP_RPT_INP_FLG" ).append("\n"); 
		query.append("       , T51.ACT_INP_FLG" ).append("\n"); 
		query.append("       , T51.PRT_CHK_FLG" ).append("\n"); 
		query.append("	   , T51.EDI_SND_KNT" ).append("\n"); 
		query.append("	   , T51.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("	   , T51.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("	   , T51.PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append("	   , T51.TTL_DLAY_HRS" ).append("\n"); 
		query.append("	   , T51.TS_PORT_CD" ).append("\n"); 
		query.append("	   , T51.USD_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , T51.IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("       , T51.OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("	   , T51.CSSM_VOY_INIT_CRE_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , CASE	 WHEN T51.TURN_PORT_IND_CD IN ('Y','N') THEN" ).append("\n"); 
		query.append("           	   (SELECT    PS.IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("            	FROM      VSK_VSL_PORT_SKD      PS" ).append("\n"); 
		query.append("            	WHERE     PS.VSL_CD             = T51.VSL_CD" ).append("\n"); 
		query.append("            	AND       PS.SKD_VOY_NO         = T51.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("            	AND       PS.SKD_DIR_CD         = T51.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("            	AND       PS.VPS_PORT_CD        = T51.VPS_PORT_CD" ).append("\n"); 
		query.append("            	AND       PS.CLPT_IND_SEQ       = T51.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("            	)" ).append("\n"); 
		query.append("            	ELSE ''" ).append("\n"); 
		query.append("        END TURN_IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , T51.VT_ADD_CALL_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , NVL(T51.SKP_CALL_FLG, DECODE(T51.SKD_CNG_STS_CD, 'S', 'Y')) SKP_CALL_FLG" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("	   --:2016-07-08:--, NVL(T51.ADD_CALL_FLG, DECODE(T51.SKD_CNG_STS_CD, 'A', 'Y')) ADD_CALL_FLG " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , CASE 	WHEN T51.VT_ADD_CALL_FLG = 'Y' THEN ''" ).append("\n"); 
		query.append("     			WHEN T51.ADD_CALL_FLG    = 'Y' OR T51.SKD_CNG_STS_CD = 'A' THEN 'Y'" ).append("\n"); 
		query.append("     			ELSE ''" ).append("\n"); 
		query.append("	     END 	AS ADD_CALL_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , T51.VSL_RENM_OLD_VSL_CD" ).append("\n"); 
		query.append("       , T51.VSL_RENM_OLD_VSL_ENG_NM" ).append("\n"); 
		query.append("       , T51.VSL_RENM_NEW_VSL_CD" ).append("\n"); 
		query.append("       , T51.VSL_RENM_NEW_VSL_ENG_NM" ).append("\n"); 
		query.append("       , T51.VSLD_WKS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , DECODE(T51.AUTO_SKD_CNG_FLG, 'Y', '1', 'N', '0', T51.AUTO_SKD_CNG_FLG) AS AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append("       , CASE WHEN ROUND(ROUND(TO_CHAR(T51.VPS_ETD_DT - NVL(T51.PF_ETD_DT, T51.INIT_ETD_DT))*24, 1)) > 0" ).append("\n"); 
		query.append("              THEN LPAD(TRUNC(TO_CHAR(T51.VPS_ETD_DT - NVL(T51.PF_ETD_DT, T51.INIT_ETD_DT))), 2, '0') || 'D-' || LPAD(MOD(ROUND(ROUND(TO_CHAR(T51.VPS_ETD_DT - NVL(T51.PF_ETD_DT, T51.INIT_ETD_DT))*24, 1)),24), 2, '0') || 'H'" ).append("\n"); 
		query.append("              ELSE ''" ).append("\n"); 
		query.append("         END AS DLAY_DATE_TEXT" ).append("\n"); 
		query.append("       , CASE WHEN ROUND(ROUND(TO_CHAR(TO_NUMBER(T51.VPS_ETA_DT - LAG(T51.VPS_ETD_DT) OVER (ORDER BY SEQ)) " ).append("\n"); 
		query.append("                   - ABS(TO_NUMBER(NVL(T51.PF_ETA_DT, T51.INIT_ETA_DT) - LAG(NVL(T51.PF_ETD_DT, T51.INIT_ETD_DT)) OVER (ORDER BY SEQ))))*24, 1)) > 0" ).append("\n"); 
		query.append("              THEN LPAD(TRUNC(TO_CHAR(TO_NUMBER(T51.VPS_ETA_DT - LAG(T51.VPS_ETD_DT) OVER (ORDER BY SEQ)) " ).append("\n"); 
		query.append("                   - ABS(TO_NUMBER(NVL(T51.PF_ETA_DT, T51.INIT_ETA_DT) - LAG(NVL(T51.PF_ETD_DT, T51.INIT_ETD_DT)) OVER (ORDER BY SEQ))))), 2, '0') || 'D-' || LPAD(MOD(ROUND(ROUND(TO_CHAR(TO_NUMBER(T51.VPS_ETA_DT - LAG(T51.VPS_ETD_DT) OVER (ORDER BY SEQ)) - TO_NUMBER(NVL(T51.PF_ETA_DT, T51.INIT_ETA_DT) - LAG(NVL(T51.PF_ETD_DT, T51.INIT_ETD_DT)) OVER (ORDER BY SEQ)))*24, 1)),24), 2, '0') || 'H'" ).append("\n"); 
		query.append("              ELSE ''" ).append("\n"); 
		query.append("         END AS SEA_DATE_TEXT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT GMT_HRS/60.0 FROM MDM_LOCATION" ).append("\n"); 
		query.append("             WHERE LOC_CD = T51.VPS_PORT_CD" ).append("\n"); 
		query.append("         ) AS TIME_DIFF" ).append("\n"); 
		query.append("       , ROUND(T51.VPS_ETD_DT - T51.PF_ETD_DT, 1) AS DELAY_DATE" ).append("\n"); 
		query.append("       , CASE WHEN ROUND(ROUND(TO_CHAR(T51.VPS_ETA_DT - T51.INIT_ETA_DT)*24, 1)) > 0" ).append("\n"); 
		query.append("              THEN 'D'" ).append("\n"); 
		query.append("              WHEN ROUND(ROUND(TO_CHAR(T51.VPS_ETA_DT - T51.INIT_ETA_DT)*24, 1)) < 0" ).append("\n"); 
		query.append("              THEN 'A'" ).append("\n"); 
		query.append("              ELSE 'X'" ).append("\n"); 
		query.append("         END AS ETA_DELAY_FLG" ).append("\n"); 
		query.append("       , CASE WHEN ROUND(ROUND(TO_CHAR(T51.VPS_ETB_DT - T51.INIT_ETB_DT)*24, 1)) > 0" ).append("\n"); 
		query.append("              THEN 'D'" ).append("\n"); 
		query.append("              WHEN ROUND(ROUND(TO_CHAR(T51.VPS_ETB_DT - T51.INIT_ETB_DT)*24, 1)) < 0" ).append("\n"); 
		query.append("              THEN 'A'" ).append("\n"); 
		query.append("              ELSE 'X'" ).append("\n"); 
		query.append("         END AS ETB_DELAY_FLG" ).append("\n"); 
		query.append("       , CASE WHEN ROUND(ROUND(TO_CHAR(T51.VPS_ETD_DT - T51.INIT_ETD_DT)*24, 1)) > 0" ).append("\n"); 
		query.append("              THEN 'D'" ).append("\n"); 
		query.append("              WHEN ROUND(ROUND(TO_CHAR(T51.VPS_ETD_DT - T51.INIT_ETD_DT)*24, 1)) < 0" ).append("\n"); 
		query.append("              THEN 'A'" ).append("\n"); 
		query.append("              ELSE 'X'" ).append("\n"); 
		query.append("         END AS ETD_DELAY_FLG" ).append("\n"); 
		query.append("	   , CASE WHEN T51.ACT_INP_FLG 		= 'Y' THEN 'Actual' " ).append("\n"); 
		query.append("	          WHEN T51.DEP_RPT_FLG 		= 'Y' THEN 'Departure'" ).append("\n"); 
		query.append("			  --WHEN T51.NOON_RPT_INP_FLG = 'Y' THEN 'Noon'" ).append("\n"); 
		query.append("			  WHEN T51.OFC_INP_FLG 		= 'Y' THEN 'HQ/RSO'" ).append("\n"); 
		query.append("			  WHEN T51.INIT_SKD_INP_FLG = 'Y' THEN 'Initial'" ).append("\n"); 
		query.append("			  ELSE ''" ).append("\n"); 
		query.append("	     END AS UPD_STS" ).append("\n"); 
		query.append("	   /*, NVL(T51.LNK_DIST, (" ).append("\n"); 
		query.append("                            CASE WHEN T51.NXT_PORT = T52.NXT_PORT THEN NVL(T52.LNK_DIST, 0)" ).append("\n"); 
		query.append("	                             ELSE 0" ).append("\n"); 
		query.append("	                        END" ).append("\n"); 
		query.append("	                       )" ).append("\n"); 
		query.append("	        ) AS LNK_DIST*/" ).append("\n"); 
		query.append("	   , NVL(T51.LNK_DIST, NVL(T52.LNK_DIST, 0)) AS LNK_DIST" ).append("\n"); 
		query.append("       , NVL(T51.LNK_SPD, NVL(T52.LNK_SPD, 0)) AS LNK_SPD" ).append("\n"); 
		query.append("	   , NVL(T51.SEA_BUF_HRS, NVL(T52.SEA_BUF_HRS, 0)) AS SEA_BUF_HRS" ).append("\n"); 
		query.append("	   , NVL(T51.PORT_BUF_HRS, NVL(T52.PORT_BUF_HRS, 0)) AS PORT_BUF_HRS" ).append("\n"); 
		query.append("	   , NVL(T51.TZTM_HRS, NVL(T52.TZTM_HRS, 0)) AS TZTM_HRS" ).append("\n"); 
		query.append("	   , NVL(T51.PORT_WRK_HRS, NVL(T52.ACT_WRK_HRS, 0)) AS ACT_WRK_HRS" ).append("\n"); 
		query.append("	   , NVL(T51.MNVR_OUT_HRS, NVL(T52.MNVR_OUT_HRS, 0)) AS MNVR_OUT_HRS" ).append("\n"); 
		query.append("	   , NVL(T51.MNVR_IN_HRS, NVL(T52.MNVR_IN_HRS, 0)) AS MNVR_IN_HRS" ).append("\n"); 
		query.append("       , NVL(T52.LNK_DIST, 0) AS PF_LNK_DIST" ).append("\n"); 
		query.append("       , NVL(T52.LNK_SPD, 0) AS PF_LNK_SPD" ).append("\n"); 
		query.append("       , NVL(T52.SEA_BUF_HRS, 0) AS PF_SEA_BUF_HRS" ).append("\n"); 
		query.append("       , NVL(T52.PORT_BUF_HRS, 0) AS PF_PORT_BUF_HRS" ).append("\n"); 
		query.append("       , NVL(T52.TZTM_HRS, 0) AS PF_TZTM_HRS" ).append("\n"); 
		query.append("       , NVL(T52.ACT_WRK_HRS, 0) AS PF_ACT_WRK_HRS" ).append("\n"); 
		query.append("       , NVL(T52.MNVR_OUT_HRS, 0) AS PF_MNVR_OUT_HRS" ).append("\n"); 
		query.append("       , NVL(T52.MNVR_IN_HRS, 0) AS PF_MNVR_IN_HRS" ).append("\n"); 
		query.append("       , T52.CRN_KNT" ).append("\n"); 
		query.append("       , T52.TML_PROD_QTY" ).append("\n"); 
		query.append("       --::2015-04-23::--, CASE WHEN T51.TURN_PORT_FLG = 'Y' AND T51.TURN_PORT_IND_CD = 'N' THEN 1 ELSE T52.PORT_ROTN_SEQ END PORT_ROTN_SEQ" ).append("\n"); 
		query.append("       , CASE WHEN T51.TURN_PORT_FLG = 'Y' AND T51.TURN_PORT_IND_CD = 'N' THEN 1 " ).append("\n"); 
		query.append("              WHEN T51.PF_ETB_DT IS NULL                                  THEN NULL" ).append("\n"); 
		query.append("              ELSE T52.PORT_ROTN_SEQ " ).append("\n"); 
		query.append("         END PORT_ROTN_SEQ" ).append("\n"); 
		query.append("       , T52.ETB_DY_CD" ).append("\n"); 
		query.append("       , T52.ETB_DY_NO" ).append("\n"); 
		query.append("       , T52.ETB_TM_HRMNT" ).append("\n"); 
		query.append("       , T52.ETD_DY_CD" ).append("\n"); 
		query.append("       , T52.ETD_DY_NO" ).append("\n"); 
		query.append("       , T52.ETD_TM_HRMNT" ).append("\n"); 
		query.append("       , T52.LNK_SPD AS PF_SPD" ).append("\n"); 
		query.append("       , T52.SEA_BUF_SPD" ).append("\n"); 
		query.append("       , T52.IB_IPCGO_QTY" ).append("\n"); 
		query.append("       , T52.IB_OCN_CGO_QTY" ).append("\n"); 
		query.append("       , T52.OB_IPCGO_QTY" ).append("\n"); 
		query.append("       , T52.OB_OCN_CGO_QTY" ).append("\n"); 
		query.append("	     --::2015-04-18::--" ).append("\n"); 
		query.append("       , NVL(T52.PF_SVC_TP_CD,T51.PF_SKD_TP_CD)	AS PF_SVC_TP_CD" ).append("\n"); 
		query.append("       , '' AS VSL_SIM_TP_CD" ).append("\n"); 
		query.append("       , '' AS BOUND" ).append("\n"); 
		query.append("       , '' AS RTV_FLG" ).append("\n"); 
		query.append("       , '' AS DIFF_RMK" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("			SELECT  ROUND((FOC_HR / POWER(SPD_P, 3)) * POWER((NVL(T51.LNK_SPD, NVL(T52.LNK_SPD, 0)) / (1 - (SLIP / 100))), 3) * 24, 1)" ).append("\n"); 
		query.append("			FROM    (" ).append("\n"); 
		query.append("						SELECT  T1.*," ).append("\n"); 
		query.append("								ROUND(((SPD_P - SPD_O)/SPD_P) * 100, 1)   AS SLIP," ).append("\n"); 
		query.append("								ROUND(BUNK_CONS / (DIST_O / SPD_O), 2)  AS FOC_HR" ).append("\n"); 
		query.append("						FROM    (" ).append("\n"); 
		query.append("									SELECT  /*+INDEX_DESC(T XPKVSK_NOON_RPT) */" ).append("\n"); 
		query.append("											NXT_PORT_CD     AS NXT_PORT_CD," ).append("\n"); 
		query.append("											NXT_PORT_ETA_DT AS NXT_PORT_ETA_DT," ).append("\n"); 
		query.append("											NVGT_DIST       AS DIST_O," ).append("\n"); 
		query.append("											ENG_ML_DIST     AS DIST_P," ).append("\n"); 
		query.append("											CRNT_ACT_SPD    AS SPD_O," ).append("\n"); 
		query.append("											ROUND(ENG_ML_DIST / (NVGT_DIST / CRNT_ACT_SPD),1) AS SPD_P," ).append("\n"); 
		query.append("											ROUND(FOIL_CSM_WGT)    AS BUNK_CONS" ).append("\n"); 
		query.append("									FROM    VSK_NOON_RPT T" ).append("\n"); 
		query.append("									WHERE   VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                                    AND     CRNT_ACT_SPD > 0" ).append("\n"); 
		query.append("									AND		NVGT_DIST > 0" ).append("\n"); 
		query.append("									AND     ENG_ML_DIST > 0" ).append("\n"); 
		query.append("									AND     ROWNUM      = 1" ).append("\n"); 
		query.append("								) T1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("        ) AS BNK_UNIT_QTY" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT  ACT_PRC" ).append("\n"); 
		query.append("            FROM    VSK_BNK_PRC T1," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                        SELECT  MAX(TO_CHAR(ACT_BRTH_DT, 'YYYYMMDD') || VPS_PORT_CD ) CURR_PORT" ).append("\n"); 
		query.append("                        FROM    VSK_DEP_RPT" ).append("\n"); 
		query.append("                        WHERE   VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND     SPL_FOIL_WGT    > 0" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("            WHERE   1 = 1" ).append("\n"); 
		query.append("            AND     PORT_CD             = SUBSTR(CURR_PORT, 9)" ).append("\n"); 
		query.append("            AND     FOIL_DOIL_DIV_CD    = 'F'" ).append("\n"); 
		query.append("            AND     EVNT_DT             = TO_DATE(SUBSTR(CURR_PORT, 1, 8), 'YYYYMMDD')" ).append("\n"); 
		query.append("        ) AS BNK_UNIT_AMT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT  SUM(TTL_CHG_AMT)" ).append("\n"); 
		query.append("			FROM    PSO_VSL_CLSS_TRF" ).append("\n"); 
		query.append("			WHERE   BSE_YR      = TO_CHAR(T51.VPS_ETA_DT, 'YYYY')" ).append("\n"); 
		query.append("			AND     BSE_QTR_CD  = TO_CHAR(T51.VPS_ETA_DT, 'Q')" ).append("\n"); 
		query.append("			AND     YD_CD       = T51.YD_CD" ).append("\n"); 
		query.append("			AND     CNTR_VSL_CLSS_CAPA = " ).append("\n"); 
		query.append("			        (" ).append("\n"); 
		query.append("			            SELECT  CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("			            FROM    MDM_VSL_CNTR" ).append("\n"); 
		query.append("			            WHERE   VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("			            AND     DELT_FLG    = 'N'" ).append("\n"); 
		query.append("			        )" ).append("\n"); 
		query.append("        ) AS PE_USD_TTL_AMT" ).append("\n"); 
		query.append("       , '' AS SIM_DT" ).append("\n"); 
		query.append("       , '' AS SIM_NO" ).append("\n"); 
		query.append("	   , '' AS CNG_LANE_CD" ).append("\n"); 
		query.append("	   , '' AS CNG_VSL_CD" ).append("\n"); 
		query.append("	   , '' AS CNG_SKD_VOY_NO" ).append("\n"); 
		query.append("	   , '' AS CNG_SKD_DIR_CD" ).append("\n"); 
		query.append("	   , '' AS ADD_BNK_CSM_QTY" ).append("\n"); 
		query.append("	   , '' AS ADD_BNK_COST_AMT" ).append("\n"); 
		query.append("	   , '' AS TML_HNDL_20FT_TTL_QTY" ).append("\n"); 
		query.append("	   , '' AS TML_HNDL_40FT_TTL_QTY" ).append("\n"); 
		query.append("	   , '' AS TML_HNDL_20FT_TTL_AMT" ).append("\n"); 
		query.append("	   , '' AS TML_HNDL_40FT_TTL_AMT" ).append("\n"); 
		query.append("	   , '' AS TS_20FT_TTL_QTY" ).append("\n"); 
		query.append("	   , '' AS TS_40FT_TTL_QTY" ).append("\n"); 
		query.append("	   , '' AS TS_20FT_TTL_AMT" ).append("\n"); 
		query.append("	   , '' AS TS_40FT_TTL_AMT" ).append("\n"); 
		query.append("	   , 'N' AS USR_HDN_FLG" ).append("\n"); 
		query.append("	   /*, (" ).append("\n"); 
		query.append("			SELECT  'X'" ).append("\n"); 
		query.append("                    FROM    BKG_VVD S" ).append("\n"); 
		query.append("                    WHERE   1 = 1" ).append("\n"); 
		query.append("                    AND     S.VSL_CD           = T51.VSL_CD" ).append("\n"); 
		query.append("                    AND     S.SKD_VOY_NO       = T51.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     S.SKD_DIR_CD       = T51.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND     S.POL_CD           = T51.VPS_PORT_CD" ).append("\n"); 
		query.append("                    AND     S.POL_CLPT_IND_SEQ = T51.CLPT_IND_SEQ" ).append("\n"); 
		query.append("					AND 	ROWNUM = 1" ).append("\n"); 
		query.append("		 ) AS BKG_FLG*/" ).append("\n"); 
		query.append("	   , T51.CLPT_IND_SEQ AS NEW_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	   , (" ).append("\n"); 
		query.append("	       SELECT  'X'" ).append("\n"); 
		query.append("	       FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("	       WHERE   VSL_CD           = T51.VSL_CD" ).append("\n"); 
		query.append("	       AND     SKD_VOY_NO       = T51.SKD_VOY_NO" ).append("\n"); 
		query.append("	       AND     SKD_DIR_CD       = T51.SKD_DIR_CD" ).append("\n"); 
		query.append("	       AND     CLPT_SEQ         > T51.CLPT_SEQ" ).append("\n"); 
		query.append("	       AND     ACT_INP_FLG = 'Y'" ).append("\n"); 
		query.append("		   --AND	   PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("	       AND     ROWNUM = 1" ).append("\n"); 
		query.append("	   	 ) AS BFR_ACT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , DECODE(T51.ADD_CALL_XTER_FLG,'Y','1','0')	AS ADD_CALL_XTER_FLG" ).append("\n"); 
		query.append("	   , T51.PRIV_CALL_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , CASE	WHEN T51.TURN_PORT_IND_CD IN ('Y','N') AND T51.TURN_SKD_VOY_NO IS NOT NULL THEN ROW_NUMBER() OVER (PARTITION BY T51.VSL_CD, T51.SKD_VOY_NO, T51.SKD_DIR_CD ORDER BY DECODE(T51.TURN_SKD_VOY_NO,NULL,9,1) ASC, T51.CLPT_SEQ ASC)" ).append("\n"); 
		query.append("        		ELSE NULL" ).append("\n"); 
		query.append("    	 END    REAL_CLPT_SEQ" ).append("\n"); 
		query.append("  	   , CASE	WHEN T51.TURN_PORT_IND_CD IN ('Y','N') THEN NULL" ).append("\n"); 
		query.append("           		ELSE RANK() OVER (PARTITION BY T51.VSL_CD,T51.SKD_VOY_NO,T51.SKD_DIR_CD ORDER BY DECODE(T51.TURN_PORT_IND_CD,'F',1,'D',2,'V',2,9) ASC, T51.VPS_ETB_DT ASC) " ).append("\n"); 
		query.append("         END    VIR_PORT_CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		--===============================================================================" ).append("\n"); 
		query.append("		--===============================================================================" ).append("\n"); 
		query.append("		SELECT   T41.VVD_POSITION" ).append("\n"); 
		query.append("			   , T41.LVL 										AS SEQ" ).append("\n"); 
		query.append("			   , T41.VSL_SLAN_CD" ).append("\n"); 
		query.append("			   , T41.SKD_STS_CD" ).append("\n"); 
		query.append("		       , T41.SKD_VOY_TP_CD" ).append("\n"); 
		query.append("			   , T41.SKD_USD_IND_CD" ).append("\n"); 
		query.append("		       , T41.PF_SKD_TP_CD" ).append("\n"); 
		query.append("			   , T41.ST_PORT_CD" ).append("\n"); 
		query.append("			   , T41.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("		       , T41.PSDO_VVD_CD" ).append("\n"); 
		query.append("		       , T41.CO_CD" ).append("\n"); 
		query.append("		       , T41.SKD_RMK" ).append("\n"); 
		query.append("			   , T41.CRE_USR_ID 								AS SKD_CRE_USE_ID" ).append("\n"); 
		query.append("			   , T41.CRE_DT AS SKD_CRE_DT" ).append("\n"); 
		query.append("			   , T41.UPD_USR_ID 								AS SKD_UPD_USE_ID" ).append("\n"); 
		query.append("			   , T41.UPD_DT 									AS SKD_UPD_DT" ).append("\n"); 
		query.append("			   , T42.*" ).append("\n"); 
		query.append("			   , LEAD(T42.VPS_PORT_CD) OVER (ORDER BY CLPT_SEQ) AS NXT_PORT" ).append("\n"); 
		query.append("               , NVL(( /* DEPARTURE REPORT 입력 여부 */" ).append("\n"); 
		query.append("                        SELECT  'Y'" ).append("\n"); 
		query.append("                        FROM    VSK_DEP_RPT S" ).append("\n"); 
		query.append("                        WHERE   S.VSL_CD        = T42.VSL_CD" ).append("\n"); 
		query.append("                        AND     S.SKD_VOY_NO    = T42.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND     S.SKD_DIR_CD    = T42.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND     S.VPS_PORT_CD   = T42.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND     S.CLPT_IND_SEQ  = T42.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                        ), 'N') AS DEP_RPT_FLG" ).append("\n"); 
		query.append("		  FROM (" ).append("\n"); 
		query.append("                SELECT  T31.VVD_POSITION" ).append("\n"); 
		query.append("					,	T31.LVL" ).append("\n"); 
		query.append("					, 	T32.*" ).append("\n"); 
		query.append("					,	ROW_NUMBER() 	OVER (ORDER BY LVL) AS VVD_SEQ" ).append("\n"); 
		query.append("					,	COUNT(*) 		OVER () 			AS MAX_VVD" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						--===============================================================================" ).append("\n"); 
		query.append("						/* 조회 조건의 이전 항차 */" ).append("\n"); 
		query.append("                        SELECT	DISTINCT -LEVEL 	AS LVL" ).append("\n"); 
		query.append("							,	VSL_CD" ).append("\n"); 
		query.append("							,	TURN_SKD_VOY_NO 	AS SKD_VOY_NO" ).append("\n"); 
		query.append("							,	TURN_SKD_DIR_CD 	AS SKD_DIR_CD" ).append("\n"); 
		query.append("							,	'PRE' 				AS VVD_POSITION" ).append("\n"); 
		query.append("                        FROM 	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                        WHERE 	LEVEL 				<= FLOOR(TO_NUMBER(@[bound])/2)" ).append("\n"); 
		query.append("                        AND  	(TURN_SKD_VOY_NO 	IS NOT NULL OR TURN_SKD_DIR_CD IS NOT NULL)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        START 	WITH VSL_CD 		= @[vsl_cd] AND SKD_VOY_NO = @[skd_voy_no] AND SKD_DIR_CD = @[skd_dir_cd] AND TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("                        CONNECT BY PRIOR TURN_SKD_VOY_NO 	= SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND PRIOR TURN_SKD_DIR_CD 	= SKD_DIR_CD  " ).append("\n"); 
		query.append("                                AND PRIOR VSL_CD          	= VSL_CD" ).append("\n"); 
		query.append("                        AND  	TURN_PORT_IND_CD 	IN ('Y','N')" ).append("\n"); 
		query.append("                        AND  	LEVEL 				<= FLOOR(TO_NUMBER(@[bound])/2)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* 조회 조건의 항차 */ " ).append("\n"); 
		query.append("                        SELECT 0 AS LVL, @[vsl_cd] AS VSL_CD, @[skd_voy_no] AS SKD_VOY_NO, @[skd_dir_cd] AS SKD_DIR_CD, 'CUR' AS VVD_POSITION FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* 조회 조건의 이후 항차 */" ).append("\n"); 
		query.append("                        SELECT 	DISTINCT LEVEL 		AS LVL" ).append("\n"); 
		query.append("							,	VSL_CD" ).append("\n"); 
		query.append("							,	TURN_SKD_VOY_NO 	AS SKD_VOY_NO" ).append("\n"); 
		query.append("							,	TURN_SKD_DIR_CD 	AS SKD_DIR_CD" ).append("\n"); 
		query.append("							,	'NXT' 				AS VVD_POSITION" ).append("\n"); 
		query.append("                        FROM 	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                        WHERE 	LEVEL 				<= FLOOR(TO_NUMBER(@[bound])/2)" ).append("\n"); 
		query.append("                        AND  	(TURN_SKD_VOY_NO IS NOT NULL OR TURN_SKD_DIR_CD IS NOT NULL)" ).append("\n"); 
		query.append("                        START 	WITH VSL_CD 		= @[vsl_cd] AND SKD_VOY_NO = @[skd_voy_no] AND SKD_DIR_CD = @[skd_dir_cd] AND TURN_PORT_IND_CD IN ('D','V','F')" ).append("\n"); 
		query.append("                        CONNECT BY PRIOR TURN_SKD_VOY_NO  = SKD_VOY_NO " ).append("\n"); 
		query.append("                                AND PRIOR TURN_SKD_DIR_CD = SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND PRIOR VSL_CD          = VSL_CD" ).append("\n"); 
		query.append("                        AND  	TURN_PORT_IND_CD 	IN ('D','V','F')" ).append("\n"); 
		query.append("                        AND  	LEVEL 				<= FLOOR(TO_NUMBER(@[bound])/2)" ).append("\n"); 
		query.append("						--===============================================================================" ).append("\n"); 
		query.append("                        ) 							T31" ).append("\n"); 
		query.append("					,	VSK_VSL_SKD 				T32" ).append("\n"); 
		query.append("                WHERE   T31.VSL_CD      			= T32.VSL_CD" ).append("\n"); 
		query.append("                AND     T31.SKD_VOY_NO   			= T32.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     T31.SKD_DIR_CD   			= T32.SKD_DIR_CD      " ).append("\n"); 
		query.append("               ) T41" ).append("\n"); 
		query.append("			,	VSK_VSL_PORT_SKD 					T42" ).append("\n"); 
		query.append("		WHERE 	T41.VSL_CD       					= T42.VSL_CD" ).append("\n"); 
		query.append("		AND 	T41.SKD_VOY_NO   					= T42.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND 	T41.SKD_DIR_CD   					= T42.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND 	CASE WHEN T41.VVD_SEQ = T41.MAX_VVD THEN 1" ).append("\n"); 
		query.append("                     ELSE " ).append("\n"); 
		query.append("                         CASE WHEN T42.TURN_PORT_IND_CD IN ('D','V','F') THEN 0 ELSE 1 " ).append("\n"); 
		query.append("                         END " ).append("\n"); 
		query.append("                END 								= 1		/* 맨 마지막 PORT 만 Virtual 이 나오기 위한 조건 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		--::2016-07-21:by TOP::-----------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("		AND		'*'                       			= CASE 	WHEN T41.VVD_POSITION IN ('PRE','CUR') AND T42.VT_ADD_CALL_FLG = 'Y' AND FLOOR(TO_NUMBER(@[bound])/2) > 0	THEN 'N/A'" ).append("\n"); 
		query.append("                                                  			WHEN T41.VVD_POSITION = 'NXT'		   AND T42.VT_ADD_CALL_FLG = 'Y' AND FLOOR(TO_NUMBER(@[bound])/2) > LVL THEN 'N/A'" ).append("\n"); 
		query.append("															ELSE '*'" ).append("\n"); 
		query.append("                                             		  END" ).append("\n"); 
		query.append("		----------------------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("		--===============================================================================" ).append("\n"); 
		query.append("		--===============================================================================" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			) T51" ).append("\n"); 
		query.append("		,	(" ).append("\n"); 
		query.append("			SELECT	T1.VSL_SLAN_CD, T1.PF_SVC_TP_CD, T1.PORT_CD, DECODE(VIRT_FLG, 'V', T1.DIR_CD2, T2.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("					, T1.CLPT_SEQ, T2.PORT_ROTN_SEQ, T2.YD_CD, CALL_YD_IND_SEQ, TURN_PORT_FLG, TURN_PORT_IND_CD, ETB_DY_CD, ETB_DY_NO" ).append("\n"); 
		query.append("					, ETB_TM_HRMNT, ETD_DY_CD, ETD_DY_NO, ETD_TM_HRMNT, LNK_DIST, LNK_SPD, TZTM_HRS" ).append("\n"); 
		query.append("					, SEA_BUF_HRS, SEA_BUF_SPD, MNVR_IN_HRS, MNVR_OUT_HRS" ).append("\n"); 
		query.append("					, IB_IPCGO_QTY, IB_OCN_CGO_QTY, OB_IPCGO_QTY" ).append("\n"); 
		query.append("					, OB_OCN_CGO_QTY,TML_PROD_QTY,CRN_KNT,ACT_WRK_HRS,PORT_BUF_HRS,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT" ).append("\n"); 
		query.append("					, LEAD(T1.PORT_CD) OVER (ORDER BY T1.VSL_SLAN_CD, T1.PF_SVC_TP_CD, DIR_CD2, T2.PORT_ROTN_SEQ) AS NXT_PORT" ).append("\n"); 
		query.append("			FROM	(" ).append("\n"); 
		query.append("					SELECT	  NVL(T3.VSL_SLAN_CD	, T1.VSL_SLAN_CD	) AS VSL_SLAN_CD" ).append("\n"); 
		query.append("							, NVL(T3.PF_SVC_TP_CD	, T1.PF_SVC_TP_CD	) AS PF_SVC_TP_CD" ).append("\n"); 
		query.append("							, NVL(T3.PORT_CD		, T1.PORT_CD		) AS PORT_CD" ).append("\n"); 
		query.append("							, DECODE(T3.SKD_DIR_CD, NULL," ).append("\n"); 
		query.append("														(	SELECT	S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("															FROM	MDM_VSL_SVC_LANE_DIR S" ).append("\n"); 
		query.append("															WHERE	1 = 1" ).append("\n"); 
		query.append("															AND		T1.VSL_SLAN_CD	= S.VSL_SLAN_CD" ).append("\n"); 
		query.append("															AND		T1.SKD_DIR_CD	!= S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("															AND		S.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("															AND		ROWNUM			= 1" ).append("\n"); 
		query.append("														), " ).append("\n"); 
		query.append("														T1.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("							, DECODE(T3.CLPT_SEQ, NULL, (	SELECT	T1.CLPT_SEQ" ).append("\n"); 
		query.append("															FROM	VSK_PF_SKD_DTL M" ).append("\n"); 
		query.append("															WHERE	1 = 1" ).append("\n"); 
		query.append("															AND		T1.VSL_SLAN_CD	= M.VSL_SLAN_CD" ).append("\n"); 
		query.append("															AND		T1.PF_SVC_TP_CD	= M.PF_SVC_TP_CD" ).append("\n"); 
		query.append("															AND		T1.SKD_DIR_CD	= " ).append("\n"); 
		query.append("																					(	SELECT	S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("																						FROM	MDM_VSL_SVC_LANE_DIR S" ).append("\n"); 
		query.append("																						WHERE	1 = 1" ).append("\n"); 
		query.append("																						AND		T1.VSL_SLAN_CD	= S.VSL_SLAN_CD" ).append("\n"); 
		query.append("																						AND		T1.SKD_DIR_CD	= S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("																						AND		S.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("																					)" ).append("\n"); 
		query.append("															AND		T1.PORT_CD		= M.PORT_CD" ).append("\n"); 
		query.append("															AND		T1.CLPT_SEQ		= M.CLPT_SEQ" ).append("\n"); 
		query.append("															AND     M.TURN_PORT_IND_CD != 'F'" ).append("\n"); 
		query.append("														), T1.CLPT_SEQ) AS CLPT_SEQ" ).append("\n"); 
		query.append("							, DECODE(T3.SKD_DIR_CD, NULL, 'V', 'N') 	AS VIRT_FLG" ).append("\n"); 
		query.append("							, T1.SKD_DIR_CD 							AS DIR_CD2" ).append("\n"); 
		query.append("					FROM  	VSK_PF_CALL_PORT 		T1" ).append("\n"); 
		query.append("						,	MDM_VSL_SVC_LANE_DIR 	T2" ).append("\n"); 
		query.append("						,	VSK_PF_SKD_DTL 			T3" ).append("\n"); 
		query.append("					WHERE  	1	= 1" ).append("\n"); 
		query.append("					AND		T1.VSL_SLAN_CD			= T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("					AND		T1.SKD_DIR_CD			= T2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("					AND		T1.VSL_SLAN_CD			= T3.VSL_SLAN_CD 		(+)" ).append("\n"); 
		query.append("					AND		T1.PF_SVC_TP_CD			= T3.PF_SVC_TP_CD		(+)" ).append("\n"); 
		query.append("					AND		T1.SKD_DIR_CD			= T3.SKD_DIR_CD			(+)" ).append("\n"); 
		query.append("					AND		T1.PORT_CD				= T3.PORT_CD			(+)" ).append("\n"); 
		query.append("					AND		T1.CLPT_SEQ				= T3.CLPT_SEQ			(+)" ).append("\n"); 
		query.append("					AND     T3.TURN_PORT_IND_CD(+) != 'F'" ).append("\n"); 
		query.append("					) 								T1" ).append("\n"); 
		query.append("				,	VSK_PF_SKD_DTL 					T2" ).append("\n"); 
		query.append("			WHERE	1 = 1" ).append("\n"); 
		query.append("			AND		T1.VSL_SLAN_CD 					= T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("			AND		T1.PF_SVC_TP_CD 				= T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("			AND		T1.PORT_CD  					= T2.PORT_CD" ).append("\n"); 
		query.append("			AND		T1.SKD_DIR_CD 					= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND		T1.CLPT_SEQ  					= T2.CLPT_SEQ" ).append("\n"); 
		query.append("			) T52" ).append("\n"); 
		query.append("WHERE 		T51.VSL_SLAN_CD  						= T52.VSL_SLAN_CD   (+)" ).append("\n"); 
		query.append("AND 		T51.PF_SKD_TP_CD 						= T52.PF_SVC_TP_CD 	(+)" ).append("\n"); 
		query.append("AND 		T51.SKD_DIR_CD   						= T52.SKD_DIR_CD 	(+)" ).append("\n"); 
		query.append("AND 		T51.VPS_PORT_CD  						= T52.PORT_CD 		(+)" ).append("\n"); 
		query.append("AND 		T51.CLPT_IND_SEQ 						= T52.CLPT_SEQ		(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 	SEQ										ASC" ).append("\n"); 
		query.append("		,	CLPT_SEQ								ASC" ).append("\n"); 
		query.append("		,	VPS_ETB_DT								ASC" ).append("\n"); 

	}
}