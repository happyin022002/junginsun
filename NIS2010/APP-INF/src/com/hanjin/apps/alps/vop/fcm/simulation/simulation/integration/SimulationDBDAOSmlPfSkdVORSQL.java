/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SimulationDBDAOSmlPfSkdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAOSmlPfSkdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_PF_SKD 조회
	  * </pre>
	  */
	public SimulationDBDAOSmlPfSkdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration ").append("\n"); 
		query.append("FileName : SimulationDBDAOSmlPfSkdVORSQL").append("\n"); 
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
		query.append("		ROW_NUMBER() OVER (ORDER BY PORT_ROTN_SEQ ASC) AS ROW_SEQ" ).append("\n"); 
		query.append("        , TT.VSL_SLAN_CD" ).append("\n"); 
		query.append("        ,TT.PF_SVC_TP_CD" ).append("\n"); 
		query.append("        ,TT.SLAN_STND_FLG" ).append("\n"); 
		query.append("        ,TT.SVC_DUR_DYS" ).append("\n"); 
		query.append("        ,TT.STND_SVC_SPD" ).append("\n"); 
		query.append("        ,TT.BRTH_ITVAL_DYS" ).append("\n"); 
		query.append("        ,TT.MML_USD_FLG" ).append("\n"); 
		query.append("        ,TT.SIM_DT" ).append("\n"); 
		query.append("        ,TT.SIM_NO" ).append("\n"); 
		query.append("        ,TT.N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append("        ,TT.N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append("        ,TT.N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append("        ,TT.N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append("        ,TT.N3RD_VSL_CLSS_CD" ).append("\n"); 
		query.append("        ,TT.N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append("        ,TT.CLPT_KNT" ).append("\n"); 
		query.append("        ,TT.TTL_DIST" ).append("\n"); 
		query.append("        ,TT.MAX_SPD" ).append("\n"); 
		query.append("        ,TT.AVG_SPD" ).append("\n"); 
		query.append("        ,TT.DELT_FLG" ).append("\n"); 
		query.append("        ,TT.PF_SKD_RMK" ).append("\n"); 
		query.append("        ,TT.CRE_DT" ).append("\n"); 
		query.append("		,TT.UPD_DT" ).append("\n"); 
		query.append("		,TT.CRE_USR_ID" ).append("\n"); 
		query.append("		,TT.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TT.PORT_CD" ).append("\n"); 
		query.append("        ,TT.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,TT.CLPT_SEQ" ).append("\n"); 
		query.append("        ,TT.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("        ,TT.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("        ,TT.TURN_PORT_FLG" ).append("\n"); 
		query.append("        ,TT.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("        ,TT.ETB_DY_CD" ).append("\n"); 
		query.append("        ,TT.ETB_DY_NO" ).append("\n"); 
		query.append("        ,TT.ETB_TM_HRMNT" ).append("\n"); 
		query.append("        ,TT.ETD_DY_CD" ).append("\n"); 
		query.append("        ,TT.ETD_DY_NO" ).append("\n"); 
		query.append("        ,TT.ETD_TM_HRMNT" ).append("\n"); 
		query.append("        ,TT.LNK_DIST" ).append("\n"); 
		query.append("        ,TT.LNK_SPD" ).append("\n"); 
		query.append("        ,TT.TZTM_HRS" ).append("\n"); 
		query.append("        ,TT.SEA_BUF_HRS" ).append("\n"); 
		query.append("        ,TT.SEA_BUF_SPD" ).append("\n"); 
		query.append("        ,TT.MNVR_IN_HRS" ).append("\n"); 
		query.append("        ,TT.MNVR_OUT_HRS" ).append("\n"); 
		query.append("        ,TT.IB_IPCGO_QTY" ).append("\n"); 
		query.append("        ,TT.IB_OCN_CGO_QTY" ).append("\n"); 
		query.append("        ,TT.OB_IPCGO_QTY" ).append("\n"); 
		query.append("        ,TT.OB_OCN_CGO_QTY" ).append("\n"); 
		query.append("        ,TT.TML_PROD_QTY" ).append("\n"); 
		query.append("        ,TT.CRN_KNT" ).append("\n"); 
		query.append("        ,TT.ACT_WRK_HRS" ).append("\n"); 
		query.append("        ,TT.PORT_BUF_HRS" ).append("\n"); 
		query.append("        ,TT.YD_CD" ).append("\n"); 
		query.append("        ,TT.VSL_SLAN_NM" ).append("\n"); 
		query.append("        ,TT.VSL_SVC_TP_CD" ).append("\n"); 
		query.append("		,TT.FDR_DIV_CD" ).append("\n"); 
		query.append("        ,TT.TEMP_YD_CD" ).append("\n"); 
		query.append("        ,TT.ZD" ).append("\n"); 
		query.append("        ,TT.MAX_LNK_SPD AS TOT_MAX_SPD        	" ).append("\n"); 
		query.append("        ,TT.MIN_MAX_SPD" ).append("\n"); 
		query.append("		,CHECK_WK_TM" ).append("\n"); 
		query.append("		,CRANE_WK_TM" ).append("\n"); 
		query.append("		,CHECK_VSL_SKD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("        T.VSL_SLAN_CD" ).append("\n"); 
		query.append("        ,T.PF_SVC_TP_CD" ).append("\n"); 
		query.append("        ,T.SLAN_STND_FLG" ).append("\n"); 
		query.append("        ,T.SVC_DUR_DYS" ).append("\n"); 
		query.append("        ,T.STND_SVC_SPD" ).append("\n"); 
		query.append("        ,T.BRTH_ITVAL_DYS" ).append("\n"); 
		query.append("        ,T.MML_USD_FLG" ).append("\n"); 
		query.append("        ,T.SIM_DT" ).append("\n"); 
		query.append("        ,T.SIM_NO" ).append("\n"); 
		query.append("        ,T.N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append("        ,T.N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append("        ,T.N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append("        ,T.N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append("        ,T.N3RD_VSL_CLSS_CD" ).append("\n"); 
		query.append("        ,T.N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append("        ,T.CLPT_KNT" ).append("\n"); 
		query.append("        ,T.TTL_DIST" ).append("\n"); 
		query.append("        ,T.MAX_SPD" ).append("\n"); 
		query.append("        ,T.AVG_SPD" ).append("\n"); 
		query.append("        ,T.DELT_FLG" ).append("\n"); 
		query.append("        ,T.PF_SKD_RMK" ).append("\n"); 
		query.append("        ,T.CRE_DT" ).append("\n"); 
		query.append("        ,T.UPD_DT" ).append("\n"); 
		query.append("		,T.CRE_USR_ID" ).append("\n"); 
		query.append("		,T.UPD_USR_ID" ).append("\n"); 
		query.append("        ,T.PORT_CD" ).append("\n"); 
		query.append("        ,T.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,T.CLPT_SEQ" ).append("\n"); 
		query.append("        ,T.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("        ,T.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("        ,T.TURN_PORT_FLG" ).append("\n"); 
		query.append("        ,T.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("        ,T.ETB_DY_CD" ).append("\n"); 
		query.append("        ,T.ETB_DY_NO" ).append("\n"); 
		query.append("        ,T.ETB_TM_HRMNT" ).append("\n"); 
		query.append("        ,T.ETD_DY_CD" ).append("\n"); 
		query.append("        ,T.ETD_DY_NO" ).append("\n"); 
		query.append("        ,T.ETD_TM_HRMNT" ).append("\n"); 
		query.append("        ,T.LNK_DIST" ).append("\n"); 
		query.append("        ,T.LNK_SPD" ).append("\n"); 
		query.append("        ,T.TZTM_HRS" ).append("\n"); 
		query.append("        ,T.SEA_BUF_HRS" ).append("\n"); 
		query.append("        ,T.SEA_BUF_SPD" ).append("\n"); 
		query.append("        ,T.MNVR_IN_HRS" ).append("\n"); 
		query.append("        ,T.MNVR_OUT_HRS" ).append("\n"); 
		query.append("        ,T.IB_IPCGO_QTY" ).append("\n"); 
		query.append("        ,T.IB_OCN_CGO_QTY" ).append("\n"); 
		query.append("        ,T.OB_IPCGO_QTY" ).append("\n"); 
		query.append("        ,T.OB_OCN_CGO_QTY" ).append("\n"); 
		query.append("        ,T.TML_PROD_QTY" ).append("\n"); 
		query.append("        ,T.CRN_KNT" ).append("\n"); 
		query.append("        ,T.ACT_WRK_HRS" ).append("\n"); 
		query.append("        ,T.PORT_BUF_HRS" ).append("\n"); 
		query.append("        ,T.YD_CD" ).append("\n"); 
		query.append("        ,T.VSL_SLAN_NM" ).append("\n"); 
		query.append("        ,T.VSL_SVC_TP_CD" ).append("\n"); 
		query.append("		,T.FDR_DIV_CD" ).append("\n"); 
		query.append("        ,T.TEMP_YD_CD" ).append("\n"); 
		query.append("        ,T.ZD" ).append("\n"); 
		query.append("        ,T.MAX_LNK_SPD        " ).append("\n"); 
		query.append("        ,T.AVG_LNK_SPD" ).append("\n"); 
		query.append("        ,T.AVG_SEA_BUF_SPD        " ).append("\n"); 
		query.append("        ,NVL(T.SUM_SEA_BUFF_HRS , 0) + NVL(T.SUM_PORT_BUF_HRS, 0)   AS TOT_BUF_RAT_1" ).append("\n"); 
		query.append("        ,NVL(T.SUM_TZTH_HRS     , 0) + NVL(T.SUM_SEA_BUFF_HRS, 0) + " ).append("\n"); 
		query.append("         NVL(T.SUM_MNVR_IN_HRS  , 0) + NVL(T.SUM_MNVR_OUT_HRS, 0) + " ).append("\n"); 
		query.append("         NVL(T.SUM_ACT_WRK_HRS  , 0) + NVL(T.SUM_PORT_BUF_HRS, 0)   AS TOT_BUF_RAT_2" ).append("\n"); 
		query.append("        ,NVL(T.SUM_SEA_BUFF_HRS , 0)                                AS SEA_BUF_RAT_1" ).append("\n"); 
		query.append("        ,NVL(T.SUM_TZTH_HRS     , 0) + NVL(T.SUM_SEA_BUFF_HRS, 0) +" ).append("\n"); 
		query.append("         NVL(T.SUM_MNVR_IN_HRS  , 0) + NVL(T.SUM_MNVR_OUT_HRS, 0)   AS SEA_BUF_RAT_2        " ).append("\n"); 
		query.append("        ,NVL(T.SUM_PORT_BUF_HRS , 0)                                AS PORT_BUF_RAT_1" ).append("\n"); 
		query.append("        ,NVL(T.SUM_ACT_WRK_HRS  , 0) + NVL(T.SUM_PORT_BUF_HRS, 0)   AS PORT_BUF_RAT_2        " ).append("\n"); 
		query.append("        ,NVL(T.AVG_LNK_SPD      , 0)                                AS PF_SPD_RAT_1" ).append("\n"); 
		query.append("        ,NVL(T.MIN_MAX_SPD      , 0)                                AS PF_SPD_RAT_2        " ).append("\n"); 
		query.append("        ,NVL(T.SUM_TZTH_HRS     , 0) + NVL(T.SUM_SEA_BUFF_HRS, 0)   AS BUF_SPD_RAT_1" ).append("\n"); 
		query.append("        ,NVL(T.SUM_LNK_DIST     , 0)                                AS BUF_SPD_RAT_2" ).append("\n"); 
		query.append("        ,NVL(T.MIN_MAX_SPD      , 0)                                AS BUF_SPD_RAT_3" ).append("\n"); 
		query.append("        ,MIN_MAX_SPD" ).append("\n"); 
		query.append("		,CHECK_WK_TM" ).append("\n"); 
		query.append("		,CRANE_WK_TM" ).append("\n"); 
		query.append("		,CHECK_VSL_SKD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (SELECT" ).append("\n"); 
		query.append("            T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("            ,T1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("            ,T1.SLAN_STND_FLG" ).append("\n"); 
		query.append("            ,T1.SVC_DUR_DYS" ).append("\n"); 
		query.append("            ,T1.STND_SVC_SPD" ).append("\n"); 
		query.append("            ,T1.BRTH_ITVAL_DYS" ).append("\n"); 
		query.append("            ,T1.MML_USD_FLG" ).append("\n"); 
		query.append("            ,T1.SIM_DT " ).append("\n"); 
		query.append("            ,T1.SIM_NO" ).append("\n"); 
		query.append("            ,T1.N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append("            ,T1.N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append("            ,T1.N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append("            ,T1.N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append("            ,T1.N3RD_VSL_CLSS_CD" ).append("\n"); 
		query.append("            ,T1.N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append("            ,T1.CLPT_KNT" ).append("\n"); 
		query.append("            ,T1.TTL_DIST" ).append("\n"); 
		query.append("            ,T1.MAX_SPD" ).append("\n"); 
		query.append("            ,T1.AVG_SPD" ).append("\n"); 
		query.append("            ,T1.DELT_FLG" ).append("\n"); 
		query.append("            ,T1.PF_SKD_RMK" ).append("\n"); 
		query.append("           	,TO_CHAR(T1.CRE_DT,'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("			,TO_CHAR(T1.UPD_DT,'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("			,T1.CRE_USR_ID" ).append("\n"); 
		query.append("			,T1.UPD_USR_ID" ).append("\n"); 
		query.append("            ,T2.PORT_CD" ).append("\n"); 
		query.append("            ,T2.SKD_DIR_CD" ).append("\n"); 
		query.append("            ,T2.CLPT_SEQ" ).append("\n"); 
		query.append("            ,T2.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("            ,T2.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("            ,T2.TURN_PORT_FLG" ).append("\n"); 
		query.append("            ,T2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("            ,T2.ETB_DY_CD" ).append("\n"); 
		query.append("            ,T2.ETB_DY_NO" ).append("\n"); 
		query.append("            ,T2.ETB_TM_HRMNT" ).append("\n"); 
		query.append("            ,T2.ETD_DY_CD" ).append("\n"); 
		query.append("            ,T2.ETD_DY_NO" ).append("\n"); 
		query.append("            ,T2.ETD_TM_HRMNT" ).append("\n"); 
		query.append("            ,T2.LNK_DIST" ).append("\n"); 
		query.append("            ,T2.LNK_SPD" ).append("\n"); 
		query.append("            ,T2.TZTM_HRS" ).append("\n"); 
		query.append("            ,T2.SEA_BUF_HRS" ).append("\n"); 
		query.append("            ,T2.SEA_BUF_SPD" ).append("\n"); 
		query.append("            ,T2.MNVR_IN_HRS" ).append("\n"); 
		query.append("            ,T2.MNVR_OUT_HRS" ).append("\n"); 
		query.append("            ,T2.IB_IPCGO_QTY" ).append("\n"); 
		query.append("            ,T2.IB_OCN_CGO_QTY" ).append("\n"); 
		query.append("            ,T2.OB_IPCGO_QTY" ).append("\n"); 
		query.append("            ,T2.OB_OCN_CGO_QTY" ).append("\n"); 
		query.append("            ,T2.TML_PROD_QTY" ).append("\n"); 
		query.append("            ,T2.CRN_KNT" ).append("\n"); 
		query.append("            ,T2.ACT_WRK_HRS" ).append("\n"); 
		query.append("            ,T2.PORT_BUF_HRS" ).append("\n"); 
		query.append("            ,T2.YD_CD" ).append("\n"); 
		query.append("            ,T3.VSL_SLAN_NM" ).append("\n"); 
		query.append("            ,T3.VSL_SVC_TP_CD" ).append("\n"); 
		query.append("			,T3.FDR_DIV_CD" ).append("\n"); 
		query.append("            ,SUBSTR(T2.YD_CD,6,7) AS TEMP_YD_CD" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("                    SELECT  GMT_HRS / 60" ).append("\n"); 
		query.append("                    FROM    MDM_LOCATION" ).append("\n"); 
		query.append("                    WHERE   LOC_CD = T2.PORT_CD " ).append("\n"); 
		query.append("                ) AS ZD" ).append("\n"); 
		query.append("            ,MAX(T2.LNK_SPD     ) OVER () AS MAX_LNK_SPD" ).append("\n"); 
		query.append("			,SUM(T2.LNK_SPD     ) OVER () / DECODE( COUNT(*) OVER () - 1, 0, 1, COUNT(*) OVER () - 1) AS AVG_LNK_SPD" ).append("\n"); 
		query.append("            ,AVG(T2.SEA_BUF_SPD ) OVER () AS AVG_SEA_BUF_SPD" ).append("\n"); 
		query.append("            ,SUM(T2.SEA_BUF_SPD ) OVER () AS SUM_SEA_BUF_SPD" ).append("\n"); 
		query.append("            ,SUM(T2.ACT_WRK_HRS ) OVER () AS SUM_ACT_WRK_HRS" ).append("\n"); 
		query.append("            ,SUM(T2.MNVR_IN_HRS ) OVER () AS SUM_MNVR_IN_HRS" ).append("\n"); 
		query.append("            ,SUM(T2.MNVR_OUT_HRS) OVER () AS SUM_MNVR_OUT_HRS" ).append("\n"); 
		query.append("            ,SUM(T2.PORT_BUF_HRS) OVER () AS SUM_PORT_BUF_HRS" ).append("\n"); 
		query.append("            ,SUM(T2.TZTM_HRS    ) OVER () AS SUM_TZTH_HRS" ).append("\n"); 
		query.append("            ,SUM(T2.SEA_BUF_HRS ) OVER () AS SUM_SEA_BUFF_HRS" ).append("\n"); 
		query.append("            ,SUM(T2.LNK_DIST    ) OVER () AS SUM_LNK_DIST" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("                SELECT NVL(MIN(MAX_SPD), 0)" ).append("\n"); 
		query.append("                FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("                WHERE (CNTR_VSL_CLSS_CAPA = T1.N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append("                OR CNTR_VSL_CLSS_CAPA = T1.N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append("                OR CNTR_VSL_CLSS_CAPA = T1.N3RD_VSL_CLSS_CD)" ).append("\n"); 
		query.append("				AND NVL(MAX_SPD, 0)    > 0" ).append("\n"); 
		query.append("            ) AS MIN_MAX_SPD" ).append("\n"); 
		query.append("			,NVL((SELECT	'N'			/* ??? ??: PORT, GANG WORK START TIME?? ??? : 'N', ????? : 'Y' ???. */" ).append("\n"); 
		query.append("				  FROM	DUAL  /* P/F SKD ????? 'N'?? ??츦 d?? ??? ???? ?ð?8?? ??????.		*/" ).append("\n"); 
		query.append("				  WHERE	1 = 1" ).append("\n"); 
		query.append("				  AND	EXISTS (SELECT	'X'" ).append("\n"); 
		query.append("				   				FROM	VSK_PORT_GNG_STRC S" ).append("\n"); 
		query.append("								WHERE	S.LOC_CD		= T2.PORT_CD" ).append("\n"); 
		query.append("								AND	S.GNG_WRK_ST_HRMNT	= T2.ETB_TM_HRMNT" ).append("\n"); 
		query.append("				)),'Y') AS CHECK_WK_TM" ).append("\n"); 
		query.append("	      ,T4.CRANE_WK_TM" ).append("\n"); 
		query.append("		  ,NVL((" ).append("\n"); 
		query.append("				SELECT 'Y'" ).append("\n"); 
		query.append("				FROM VSK_VSL_SKD S" ).append("\n"); 
		query.append("				WHERE S.VSL_SLAN_CD  = T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("				AND  S.PF_SKD_TP_CD  = T1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("				AND  ROWNUM   = 1" ).append("\n"); 
		query.append("		  ), 'N')  AS CHECK_VSL_SKD	  " ).append("\n"); 
		query.append("    FROM VSK_PF_SKD T1, VSK_PF_SKD_DTL T2, MDM_VSL_SVC_LANE T3," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT LOC_CD, MAX( DECODE(SEQ, 01, TM))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 02), 1, CHR(10)|| MAX( DECODE(SEQ, 02, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 03), 1, CHR(10)|| MAX( DECODE(SEQ, 03, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 04), 1, CHR(10)|| MAX( DECODE(SEQ, 04, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 05), 1, CHR(10)|| MAX( DECODE(SEQ, 05, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 06), 1, CHR(10)|| MAX( DECODE(SEQ, 06, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 07), 1, CHR(10)|| MAX( DECODE(SEQ, 07, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 08), 1, CHR(10)|| MAX( DECODE(SEQ, 08, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 09), 1, CHR(10)|| MAX( DECODE(SEQ, 09, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 10), 1, CHR(10)|| MAX( DECODE(SEQ, 10, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 11), 1, CHR(10)|| MAX( DECODE(SEQ, 11, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 12), 1, CHR(10)|| MAX( DECODE(SEQ, 12, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 13), 1, CHR(10)|| MAX( DECODE(SEQ, 13, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 14), 1, CHR(10)|| MAX( DECODE(SEQ, 14, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 15), 1, CHR(10)|| MAX( DECODE(SEQ, 15, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 16), 1, CHR(10)|| MAX( DECODE(SEQ, 16, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 17), 1, CHR(10)|| MAX( DECODE(SEQ, 17, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 18), 1, CHR(10)|| MAX( DECODE(SEQ, 18, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 19), 1, CHR(10)|| MAX( DECODE(SEQ, 19, TM)))" ).append("\n"); 
		query.append("			|| DECODE(SIGN(CNT + 1 - 20), 1, CHR(10)|| MAX( DECODE(SEQ, 20, TM))) AS CRANE_WK_TM" ).append("\n"); 
		query.append("			FROM ( SELECT LOC_CD" ).append("\n"); 
		query.append("					, ROW_NUMBER() OVER (PARTITION BY LOC_CD ORDER BY CRN_SEQ) AS SEQ" ).append("\n"); 
		query.append("					, SUBSTR(GNG_WRK_ST_HRMNT, 1, 2) || ':' || SUBSTR(GNG_WRK_ST_HRMNT, 3, 2) AS TM" ).append("\n"); 
		query.append("					, COUNT(*) OVER (PARTITION BY LOC_CD) AS CNT" ).append("\n"); 
		query.append("				FROM VSK_PORT_GNG_STRC" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			GROUP BY LOC_CD, CNT" ).append("\n"); 
		query.append("		) T4				" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND T1.VSL_SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("    #if (${pf_svc_tp_cd} != '')        " ).append("\n"); 
		query.append("    AND T1.PF_SVC_TP_CD=@[pf_svc_tp_cd]" ).append("\n"); 
		query.append("    #end                               " ).append("\n"); 
		query.append("    #if (${slan_stnd_flg} == 'Y')   " ).append("\n"); 
		query.append("    AND T1.SLAN_STND_FLG='Y'        " ).append("\n"); 
		query.append("    #end                            " ).append("\n"); 
		query.append("    AND T1.VSL_SLAN_CD=T3.VSL_SLAN_CD  " ).append("\n"); 
		query.append("    AND T1.VSL_SLAN_CD=T2.VSL_SLAN_CD  " ).append("\n"); 
		query.append("    AND T1.PF_SVC_TP_CD=T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("    #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("    AND T2.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_svc_tp_cd} == 'T')       " ).append("\n"); 
		query.append("    AND T3.VSL_SVC_TP_CD<>'O'           " ).append("\n"); 
		query.append("    #end                                " ).append("\n"); 
		query.append("    #if (${vsl_svc_tp_cd} == 'F')       " ).append("\n"); 
		query.append("    AND T3.VSL_SVC_TP_CD='O'            " ).append("\n"); 
		query.append("    #end                                " ).append("\n"); 
		query.append("    AND T3.DELT_FLG='N'" ).append("\n"); 
		query.append("    AND T3.VSL_TP_CD='C' /*컨테이너선*/" ).append("\n"); 
		query.append("    AND T2.PORT_CD = T4.LOC_CD(+)" ).append("\n"); 
		query.append("    )T" ).append("\n"); 
		query.append("    ORDER BY PORT_ROTN_SEQ" ).append("\n"); 
		query.append(") TT" ).append("\n"); 

	}
}