/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCstSkdSimRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchCstSkdSimRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCstSkdSimRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCstSkdSimRSQL").append("\n"); 
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
		query.append("SELECT 0 AS SEQ" ).append("\n"); 
		query.append("       , T2.VSL_CD" ).append("\n"); 
		query.append("       , T2.SKD_VOY_NO" ).append("\n"); 
		query.append("       , T2.SKD_DIR_CD" ).append("\n"); 
		query.append("       , T2.VSL_CD || T2.SKD_VOY_NO || T2.SKD_DIR_CD AS VVD " ).append("\n"); 
		query.append("       , T2.SLAN_CD AS VSL_SLAN_CD" ).append("\n"); 
		query.append("	   , T2.SKD_STS_CD " ).append("\n"); 
		query.append("       , T2.SKD_VOY_TP_CD" ).append("\n"); 
		query.append("	   , T2.SKD_USD_IND_CD" ).append("\n"); 
		query.append("       , T2.PF_SKD_TP_CD" ).append("\n"); 
		query.append("	   , T2.ST_PORT_CD" ).append("\n"); 
		query.append("	   , TO_CHAR(T2.N1ST_PORT_BRTH_DT, 'YYYYMMDDHH24MI') AS N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("       , T2.PSDO_VVD_CD" ).append("\n"); 
		query.append("       , T2.CO_CD" ).append("\n"); 
		query.append("       , T2.SKD_RMK" ).append("\n"); 
		query.append("       , T1.CRE_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(T1.CRE_DT, 'YYYYMMDDHH24MI') AS CRE_DT" ).append("\n"); 
		query.append("       , T1.UPD_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(T3.UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("       , T3.VPS_PORT_CD" ).append("\n"); 
		query.append("       , T3.CLPT_IND_SEQ" ).append("\n"); 
		query.append("       , T3.CLPT_SEQ" ).append("\n"); 
		query.append("       , T3.SLAN_CD" ).append("\n"); 
		query.append("       , T3.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("       , T3.YD_CD" ).append("\n"); 
		query.append("       , DECODE(T3.YD_CD, NULL, '', SUBSTR(T3.YD_CD, 6, 2)) AS TML_CD" ).append("\n"); 
		query.append("       , T3.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("       , TO_CHAR(T3.PF_ETA_DT, 'YYYYMMDDHH24MI') AS PF_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T3.PF_ETB_DT, 'YYYYMMDDHH24MI') AS PF_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T3.PF_ETD_DT, 'YYYYMMDDHH24MI') AS PF_ETD_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T3.INIT_ETA_DT, 'YYYYMMDDHH24MI') AS INIT_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T3.INIT_ETB_DT, 'YYYYMMDDHH24MI') AS INIT_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T3.INIT_ETD_DT, 'YYYYMMDDHH24MI') AS INIT_ETD_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T3.VPS_ETA_DT, 'YYYYMMDDHH24MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T3.VPS_ETB_DT, 'YYYYMMDDHH24MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T3.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("       , T3.VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("       , T3.VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append("       , T3.VPS_LOC_CD AS VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append("       , T3.SHP_CALL_NO" ).append("\n"); 
		query.append("       , T3.SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append("       , T3.SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append("       , T3.TML_VSL_CD" ).append("\n"); 
		query.append("       , T3.TML_VOY_NO" ).append("\n"); 
		query.append("       , TO_CHAR(T3.FT_DT, 'YYYYMMDDHH24MI') AS FT_DT" ).append("\n"); 
		query.append("       , T3.PLISM_YD_CD" ).append("\n"); 
		query.append("       , T3.PLISM_VSL_CD" ).append("\n"); 
		query.append("       , T3.PLISM_VOY_NO" ).append("\n"); 
		query.append("       , T3.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("       , T3.TURN_PORT_FLG" ).append("\n"); 
		query.append("       , T3.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("       , T3.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("       , T3.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("       , T3.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       , T3.IB_CGO_QTY" ).append("\n"); 
		query.append("       , T3.OB_CGO_QTY" ).append("\n"); 
		query.append("       , T3.VPS_RMK" ).append("\n"); 
		query.append("       , T3.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("       , T3.PHS_IO_RMK" ).append("\n"); 
		query.append("       , T3.SKD_BRTH_NO" ).append("\n"); 
		query.append("       , T3.INIT_SKD_INP_FLG" ).append("\n"); 
		query.append("       , T3.OFC_INP_FLG" ).append("\n"); 
		query.append("       , T3.NOON_RPT_INP_FLG" ).append("\n"); 
		query.append("       , T3.DEP_RPT_INP_FLG" ).append("\n"); 
		query.append("       , T3.ACT_INP_FLG" ).append("\n"); 
		query.append("       , T3.PRT_CHK_FLG" ).append("\n"); 
		query.append("--	   , EDI_SND_KNT" ).append("\n"); 
		query.append("--	   , T3.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("--	   , T3.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("--	   , T3.PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append("--	   , T3.TTL_DLAY_HRS" ).append("\n"); 
		query.append("--	   , T3.TS_PORT_CD" ).append("\n"); 
		query.append("--	   , T3.USD_FLG" ).append("\n"); 
		query.append("       , CASE WHEN ROUND(ROUND(TO_CHAR(T3.VPS_ETD_DT - T3.PF_ETD_DT)*24, 1)) > 0" ).append("\n"); 
		query.append("              THEN LPAD(TRUNC(TO_CHAR(T3.VPS_ETD_DT - T3.PF_ETD_DT)), 2, '0') || 'D-' || LPAD(MOD(ROUND(ROUND(TO_CHAR(T3.VPS_ETD_DT - T3.PF_ETD_DT)*24, 1)),24), 2, '0') || 'H'" ).append("\n"); 
		query.append("              ELSE ''" ).append("\n"); 
		query.append("         END AS DLAY_DATE_TEXT" ).append("\n"); 
		query.append("       , CASE WHEN ROUND(ROUND(TO_CHAR(T3.VPS_ETA_DT - LAG(T3.VPS_ETD_DT) OVER (ORDER BY VPS_ETB_DT))*24, 1)) > 0" ).append("\n"); 
		query.append("              THEN LPAD(TRUNC(TO_CHAR(T3.VPS_ETA_DT - LAG(T3.VPS_ETD_DT) OVER (ORDER BY VPS_ETB_DT))), 2, '0') || 'D-' || LPAD(MOD(ROUND(ROUND(TO_CHAR(T3.VPS_ETA_DT - LAG(T3.VPS_ETD_DT) OVER (ORDER BY VPS_ETB_DT))*24, 1)),24), 2, '0') || 'H'" ).append("\n"); 
		query.append("              ELSE ''" ).append("\n"); 
		query.append("         END AS SEA_DATE_TEXT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT GMT_HRS/60.0 FROM MDM_LOCATION" ).append("\n"); 
		query.append("             WHERE LOC_CD = T3.VPS_PORT_CD" ).append("\n"); 
		query.append("         ) AS TIME_DIFF" ).append("\n"); 
		query.append("       , ROUND(T3.VPS_ETD_DT - T3.PF_ETD_DT, 1) AS DELAY_DATE" ).append("\n"); 
		query.append("       , CASE WHEN ROUND(ROUND(TO_CHAR(T3.VPS_ETD_DT - T3.PF_ETD_DT)*24, 1)) > 0" ).append("\n"); 
		query.append("              THEN 'R'" ).append("\n"); 
		query.append("              WHEN ROUND(ROUND(TO_CHAR(T3.VPS_ETD_DT - T3.PF_ETD_DT)*24, 1)) < 0" ).append("\n"); 
		query.append("              THEN 'B'" ).append("\n"); 
		query.append("              ELSE 'D'" ).append("\n"); 
		query.append("         END AS DELAY_FLG" ).append("\n"); 
		query.append("	   , CASE WHEN T3.ACT_INP_FLG = 'Y' THEN 'Actual' " ).append("\n"); 
		query.append("	          WHEN T3.DEP_RPT_INP_FLG = 'Y' THEN 'Departure'" ).append("\n"); 
		query.append("			  WHEN T3.NOON_RPT_INP_FLG = 'Y' THEN 'Noon'" ).append("\n"); 
		query.append("			  WHEN T3.OFC_INP_FLG = 'Y' THEN 'HQ/RSO'" ).append("\n"); 
		query.append("			  WHEN T3.INIT_SKD_INP_FLG = 'Y' THEN 'Initial'" ).append("\n"); 
		query.append("			  ELSE ''" ).append("\n"); 
		query.append("	     END AS UPD_STS" ).append("\n"); 
		query.append("       , T3.LNK_DIST" ).append("\n"); 
		query.append("       , T3.LNK_SPD" ).append("\n"); 
		query.append("       , T3.TZTM_HRS" ).append("\n"); 
		query.append("       , T3.MNVR_IN_HRS" ).append("\n"); 
		query.append("       , T3.MNVR_OUT_HRS" ).append("\n"); 
		query.append("       , T3.CRN_KNT" ).append("\n"); 
		query.append("       , T3.TML_PROD_QTY" ).append("\n"); 
		query.append("       , T3.PORT_WRK_HRS AS ACT_WRK_HRS" ).append("\n"); 
		query.append("       , T3.PORT_BUF_HRS" ).append("\n"); 
		query.append("       , T3.SEA_BUF_HRS" ).append("\n"); 
		query.append("--       , T3.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("--       , T3.ETB_DY_CD" ).append("\n"); 
		query.append("--       , T3.ETB_DY_NO" ).append("\n"); 
		query.append("--       , T3.ETB_TM_HRMNT" ).append("\n"); 
		query.append("--       , T3.ETD_DY_CD" ).append("\n"); 
		query.append("--       , T3.ETD_DY_NO" ).append("\n"); 
		query.append("--       , T3.ETD_TM_HRMNT" ).append("\n"); 
		query.append("--		 , PF_SPD" ).append("\n"); 
		query.append("--       , T3.SEA_BUF_SPD" ).append("\n"); 
		query.append("--       , T3.IB_IPCGO_QTY" ).append("\n"); 
		query.append("--       , T3.IB_OCN_CGO_QTY" ).append("\n"); 
		query.append("--       , T3.OB_IPCGO_QTY" ).append("\n"); 
		query.append("--       , T3.OB_OCN_CGO_QTY" ).append("\n"); 
		query.append("       , T3.AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append("       , T3.USR_HDN_FLG" ).append("\n"); 
		query.append("       , T3.ADD_BNK_CSM_QTY" ).append("\n"); 
		query.append("       , T3.ADD_BNK_COST_AMT" ).append("\n"); 
		query.append("       , T3.TML_HNDL_20FT_TTL_QTY" ).append("\n"); 
		query.append("       , T3.TML_HNDL_40FT_TTL_QTY" ).append("\n"); 
		query.append("       , T3.TML_HNDL_20FT_TTL_AMT" ).append("\n"); 
		query.append("       , T3.TML_HNDL_40FT_TTL_AMT" ).append("\n"); 
		query.append("       , T3.PE_USD_TTL_AMT" ).append("\n"); 
		query.append("	   , T3.CLPT_IND_SEQ AS NEW_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	   , (" ).append("\n"); 
		query.append("	       SELECT  'X'" ).append("\n"); 
		query.append("	       FROM    VSK_SWAP_CST_PORT" ).append("\n"); 
		query.append("	       WHERE   VSL_CD           = T3.VSL_CD" ).append("\n"); 
		query.append("	       AND     SKD_VOY_NO       = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("	       AND     SKD_DIR_CD       = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("	       AND     CLPT_SEQ         > T3.CLPT_SEQ" ).append("\n"); 
		query.append("	       AND     ACT_INP_FLG = 'Y'" ).append("\n"); 
		query.append("		   --AND	   PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("	       AND     ROWNUM = 1" ).append("\n"); 
		query.append("	   	 ) AS BFR_ACT_FLG" ).append("\n"); 
		query.append("       , T2.PF_SKD_TP_CD AS PF_SVC_TP_CD" ).append("\n"); 
		query.append("       , T1.VSL_SIM_TP_CD" ).append("\n"); 
		query.append("       , (SELECT COUNT(*) FROM VSK_SWAP_CST_VVD WHERE SIM_DT = T1.SIM_DT AND SIM_NO = T1.SIM_NO) AS BOUND" ).append("\n"); 
		query.append("       , '' AS RTV_FLG" ).append("\n"); 
		query.append("       , T1.DIFF_RMK" ).append("\n"); 
		query.append("       , T1.SIM_DT" ).append("\n"); 
		query.append("       , T1.SIM_NO" ).append("\n"); 
		query.append("	   ,(SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = T3.VPS_PORT_CD ) AS CONTI_CD" ).append("\n"); 
		query.append("  FROM VSK_SWAP_CST_SIM T1" ).append("\n"); 
		query.append("       , VSK_SWAP_CST_VVD T2" ).append("\n"); 
		query.append("       , VSK_SWAP_CST_PORT T3" ).append("\n"); 
		query.append(" WHERE T1.SIM_DT = T2.SIM_DT" ).append("\n"); 
		query.append("   AND T1.SIM_NO = T2.SIM_NO" ).append("\n"); 
		query.append("   AND T2.SIM_DT = T3.SIM_DT" ).append("\n"); 
		query.append("   AND T2.SIM_NO = T3.SIM_NO" ).append("\n"); 
		query.append("   AND T2.VSL_CD = T3.VSL_CD" ).append("\n"); 
		query.append("   AND T2.SKD_VOY_NO = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND T2.SKD_DIR_CD = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND T1.SIM_DT = TO_DATE(@[sim_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   AND T1.SIM_NO = TO_NUMBER(@[sim_no])" ).append("\n"); 
		query.append(" ORDER BY T2.N1ST_PORT_BRTH_DT, T3.CLPT_SEQ" ).append("\n"); 

	}
}