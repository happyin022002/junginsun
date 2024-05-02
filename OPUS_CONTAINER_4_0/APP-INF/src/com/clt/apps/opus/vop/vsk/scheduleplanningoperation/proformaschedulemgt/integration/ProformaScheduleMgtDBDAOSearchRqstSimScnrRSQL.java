/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchRqstSimScnrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.03.17 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchRqstSimScnrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRqstSimScnr
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchRqstSimScnrRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchRqstSimScnrRSQL").append("\n"); 
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
		query.append("SELECT ROW_NUMBER() OVER ( ORDER BY PORT_ROTN_SEQ ASC) AS ROW_SEQ ," ).append("\n"); 
		query.append("  	T.VSL_SLAN_CD ," ).append("\n"); 
		query.append("	T.PF_SVC_TP_CD ," ).append("\n"); 
		query.append("	T.PORT_CD ," ).append("\n"); 
		query.append("	T.SKD_DIR_CD ," ).append("\n"); 
		query.append("    (SELECT" ).append("\n"); 
		query.append("        CASE WHEN DIR1 IS NULL AND DIR2 IS NULL THEN" ).append("\n"); 
		query.append("            'W|E|N|S'" ).append("\n"); 
		query.append("        WHEN DIR1 IS NULL OR DIR2 IS NULL THEN" ).append("\n"); 
		query.append("            NVL(DIR1, '') || NVL(DIR2, '')" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            DIR1 || '|' || DIR2" ).append("\n"); 
		query.append("        END AS MDM_SKD_DIR_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT MAX(DIR1) DIR1, MAX(DIR2) DIR2" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                DECODE(VSL_SLAN_DIR_SEQ, 1, VSL_SLAN_DIR_CD) AS DIR1, " ).append("\n"); 
		query.append("                DECODE(VSL_SLAN_DIR_SEQ, 2, VSL_SLAN_DIR_CD) AS DIR2" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT VSL_SLAN_DIR_CD, ROW_NUMBER() OVER(PARTITION BY VSL_SLAN_CD ORDER BY VSL_SLAN_DIR_SEQ) VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("                FROM MDM_VSL_SVC_LANE_DIR T1, COA_SIM_INFO T2" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND T1.VSL_SLAN_CD=T2.SLAN_CD" ).append("\n"); 
		query.append("                AND T1.DELT_FLG='N'" ).append("\n"); 
		query.append("                AND	T2.SIM_DT			= @[sim_dt]" ).append("\n"); 
		query.append("                AND	T2.SIM_NO			= TRIM(TO_CHAR(TO_NUMBER(@[sim_no]), '000'))				      	" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )) AS MDM_SKD_DIR_CD," ).append("\n"); 
		query.append("	T.CLPT_SEQ ," ).append("\n"); 
		query.append("	T.PORT_ROTN_SEQ ," ).append("\n"); 
		query.append("	T.YD_CD ," ).append("\n"); 
		query.append("	T.CALL_YD_IND_SEQ ," ).append("\n"); 
		query.append("	T.TURN_PORT_FLG ," ).append("\n"); 
		query.append("	T.TURN_PORT_IND_CD ," ).append("\n"); 
		query.append("	T.ETB_DY_CD ," ).append("\n"); 
		query.append("	NVL(T.ETB_DY_NO,0) AS ETB_DY_NO," ).append("\n"); 
		query.append("	T.ETB_TM_HRMNT ," ).append("\n"); 
		query.append("	T.ETD_DY_CD ," ).append("\n"); 
		query.append("	NVL(T.ETD_DY_NO,0) AS ETD_DY_NO ," ).append("\n"); 
		query.append("	T.ETD_TM_HRMNT ," ).append("\n"); 
		query.append("	NVL(T.LNK_DIST,0) AS LNK_DIST ," ).append("\n"); 
		query.append("	NVL(T.LNK_SPD,0) AS LNK_SPD ," ).append("\n"); 
		query.append("	NVL(T.TZTM_HRS,0) AS TZTM_HRS ," ).append("\n"); 
		query.append("	NVL(T.SEA_BUF_HRS,0) AS SEA_BUF_HRS ," ).append("\n"); 
		query.append("	NVL(T.SEA_BUF_SPD,0) AS SEA_BUF_SPD ," ).append("\n"); 
		query.append("	NVL(T.MNVR_IN_HRS,0) AS MNVR_IN_HRS ," ).append("\n"); 
		query.append("	NVL(T.MNVR_OUT_HRS,0) AS MNVR_OUT_HRS ," ).append("\n"); 
		query.append("	NVL(T.IB_IPCGO_QTY,0) AS IB_IPCGO_QTY ," ).append("\n"); 
		query.append("	NVL(T.IB_OCN_CGO_QTY,0) AS IB_OCN_CGO_QTY ," ).append("\n"); 
		query.append("	NVL(T.OB_IPCGO_QTY,0) AS OB_IPCGO_QTY ," ).append("\n"); 
		query.append("	NVL(T.OB_OCN_CGO_QTY,0) AS OB_OCN_CGO_QTY ," ).append("\n"); 
		query.append("	NVL(T.TML_PROD_QTY,0) AS TML_PROD_QTY ," ).append("\n"); 
		query.append("	NVL(T.CRN_KNT,0) AS CRN_KNT," ).append("\n"); 
		query.append("	NVL(T.ACT_WRK_HRS,0) AS ACT_WRK_HRS ," ).append("\n"); 
		query.append("	NVL(T.PORT_BUF_HRS,0) AS PORT_BUF_HRS ," ).append("\n"); 
		query.append("  	T.ZD ," ).append("\n"); 
		query.append("  	T.SLAN_STND_FLG ," ).append("\n"); 
		query.append("  	T.SVC_DUR_DYS ," ).append("\n"); 
		query.append("  	T.AVG_SPD 	AS STND_SVC_SPD ," ).append("\n"); 
		query.append("  	T.BRTH_ITVAL_DYS ," ).append("\n"); 
		query.append("  	T.MML_USD_FLG ," ).append("\n"); 
		query.append("  	T.SIM_DT ," ).append("\n"); 
		query.append("  	T.SIM_NO ," ).append("\n"); 
		query.append("  	T.N1ST_VSL_CLSS_CD ," ).append("\n"); 
		query.append("  	T.N1ST_VSL_CLSS_KNT ," ).append("\n"); 
		query.append("  	T.N2ND_VSL_CLSS_CD ," ).append("\n"); 
		query.append("  	T.N2ND_VSL_CLSS_KNT ," ).append("\n"); 
		query.append("  	T.N3RD_VSL_CLSS_CD ," ).append("\n"); 
		query.append("  	T.N3RD_VSL_CLSS_KNT ," ).append("\n"); 
		query.append("  	T.CLPT_KNT ," ).append("\n"); 
		query.append("  	T.TTL_DIST ," ).append("\n"); 
		query.append("  	T.MAX_SPD ," ).append("\n"); 
		query.append("  	T.AVG_SPD ," ).append("\n"); 
		query.append("  	T.DELT_FLG ," ).append("\n"); 
		query.append("  	T.PF_SKD_RMK ," ).append("\n"); 
		query.append("  	T.MAX_SPD	AS TOT_MAX_SPD ," ).append("\n"); 
		query.append("  	T.AVG_SPD AS TOT_AVG_SPD ," ).append("\n"); 
		query.append("  	ROUND(T.AVG_SEA_BUF_SPD, 1) AS SEA_BUF_SPD ," ).append("\n"); 
		query.append("  	DECODE(T.BOT_TOT_BUF_RAT,0,0,ROUND((DECODE(T.SUM_SEA_BUFF_HRS, NULL, 0, T.SUM_SEA_BUFF_HRS) +DECODE(T.SUM_PORT_BUF_HRS, NULL, 0, T.SUM_PORT_BUF_HRS))/ T.BOT_TOT_BUF_RAT, 1)) AS TOT_BUF_RAT ," ).append("\n"); 
		query.append("  	DECODE(T.BOT_SEA_BUF_RAT,0,0,ROUND(DECODE(T.SUM_SEA_BUFF_HRS, NULL, 0, T.SUM_SEA_BUFF_HRS)/T.BOT_SEA_BUF_RAT, 1)) AS SEA_BUF_RAT ," ).append("\n"); 
		query.append("  	DECODE(T.BOT_PORT_BUF_RAT,0,0,ROUND(DECODE(T.SUM_PORT_BUF_HRS, NULL, 0, T.SUM_PORT_BUF_HRS)/T.BOT_PORT_BUF_RAT, 1)) AS PORT_BUF_RAT ," ).append("\n"); 
		query.append("  	ROUND(DECODE(T.AVG_SPD, NULL, 0, T.AVG_SPD) / DECODE(T.MIN_MAX_SPD, NULL, 1, 0, 1, MIN_MAX_SPD)*100, 1) AS PF_SPD_RAT ," ).append("\n"); 
		query.append("  	DECODE(T.BOT_BUF_SPD_RAT,0,0,ROUND(DECODE(T.SUM_LNK_DIST, NULL, 1, 0, 1, SUM_LNK_DIST)/T.BOT_BUF_SPD_RAT )/DECODE(T.MIN_MAX_SPD, NULL, 1, 0, 1, MIN_MAX_SPD)*100, 1) AS BUF_SPD_RAT ," ).append("\n"); 
		query.append("  	MIN_MAX_SPD ," ).append("\n"); 
		query.append("  	T.CHECK_WK_TM ," ).append("\n"); 
		query.append("  	CRANE_WK_TM" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("		SELECT SLAN_CD				AS VSL_SLAN_CD" ).append("\n"); 
		query.append("	      , '' 						AS PF_SVC_TP_CD" ).append("\n"); 
		query.append("	      , SUBSTR(T2.TML_CD, 1, 5) AS PORT_CD" ).append("\n"); 
		query.append("	      , T2.SKD_DIR_CD" ).append("\n"); 
		query.append("	      , T2.VSL_DBL_CALL_SEQ		AS CLPT_SEQ" ).append("\n"); 
		query.append("	      , T2.PORT_SEQ				AS PORT_ROTN_SEQ" ).append("\n"); 
		query.append("	      , SUBSTR(T2.TML_CD, 6, 7)	AS YD_CD" ).append("\n"); 
		query.append("	      , ROW_NUMBER() OVER (PARTITION BY T2.TML_CD ORDER BY T2.PORT_SEQ) AS CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("	      , T2.TURN_PORT_FLG						      " ).append("\n"); 
		query.append("	      ,	CASE	WHEN T2.PORT_SEQ		= 1 			THEN 'N'" ).append("\n"); 
		query.append("	      			WHEN T2.PORT_SEQ 		= T4.TTL_CNT	THEN 'F'" ).append("\n"); 
		query.append("	      			WHEN T2.TURN_PORT_FLG	= 'Y'			THEN 'Y'" ).append("\n"); 
		query.append("	      			WHEN T2.TURN_PORT_FLG	= 'N'			THEN 'N'" ).append("\n"); 
		query.append("	      	END AS TURN_PORT_IND_CD	      " ).append("\n"); 
		query.append("	      , T2.ETB_DY_CD" ).append("\n"); 
		query.append("	      , T2.ETB_DY_NO" ).append("\n"); 
		query.append("	      , T2.ETB_TM_HRMNT" ).append("\n"); 
		query.append("	      , T2.ETD_DY_CD" ).append("\n"); 
		query.append("	      , T2.ETD_DY_NO" ).append("\n"); 
		query.append("	      , T2.ETD_TM_HRMNT" ).append("\n"); 
		query.append("	      , T2.LNK_DIST" ).append("\n"); 
		query.append("	      , T2.LNK_SPD" ).append("\n"); 
		query.append("	      , T2.TZTM_HRS" ).append("\n"); 
		query.append("	      , T2.SEA_BUF_HRS" ).append("\n"); 
		query.append("	      , T2.SEA_BUF_SPD" ).append("\n"); 
		query.append("	      , T2.MNVR_IN_HRS" ).append("\n"); 
		query.append("	      , T2.MNVR_OUT_HRS" ).append("\n"); 
		query.append("	      , T2.IB_IPCGO_QTY" ).append("\n"); 
		query.append("	      , T2.IB_OCN_CGO_QTY" ).append("\n"); 
		query.append("	      , T2.OB_IPCGO_QTY" ).append("\n"); 
		query.append("	      , T2.OB_OCN_CGO_QTY" ).append("\n"); 
		query.append("	      , T2.TML_PROD_QTY" ).append("\n"); 
		query.append("	      , T2.CRN_KNT" ).append("\n"); 
		query.append("	      , T2.ACT_WRK_HRS" ).append("\n"); 
		query.append("	      , T2.PORT_BUF_HRS" ).append("\n"); 
		query.append("	      , (" ).append("\n"); 
		query.append("	        SELECT GMT_HRS / 60" ).append("\n"); 
		query.append("	        FROM MDM_LOCATION" ).append("\n"); 
		query.append("	        WHERE LOC_CD = SUBSTR(T2.TML_CD, 1, 5) ) AS ZD" ).append("\n"); 
		query.append("	      , 'N'					AS SLAN_STND_FLG" ).append("\n"); 
		query.append("	      , T1.SVC_DUR_DYS		AS SVC_DUR_DYS" ).append("\n"); 
		query.append("	      , DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.LNK_SPD )) OVER (), 0, 0," ).append("\n"); 
		query.append("	      		SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.LNK_SPD )) OVER ()  / (TTL_CNT - 1 )" ).append("\n"); 
		query.append("	      	)						AS STND_SVC_SPD" ).append("\n"); 
		query.append("	      , BRTH_ITVAL_DYS			AS BRTH_ITVAL_DYS" ).append("\n"); 
		query.append("	      , 'N'						AS MML_USD_FLG" ).append("\n"); 
		query.append("	      , T1.SIM_DT				AS SIM_DT" ).append("\n"); 
		query.append("	      , T1.SIM_NO				AS SIM_NO" ).append("\n"); 
		query.append("	      , T5.N1ST_VSL_CLSS_CD		AS N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append("	      , T5.N1ST_VSL_CLSS_KNT	AS N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append("	      , T5.N2ND_VSL_CLSS_CD		AS N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append("	      , T5.N2ND_VSL_CLSS_KNT	AS N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append("	      , T5.N3RD_VSL_CLSS_CD		AS N3RD_VSL_CLSS_CD" ).append("\n"); 
		query.append("	      , T5.N3RD_VSL_CLSS_KNT	AS N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append("	      ,	DECODE(TTL_CNT, 0, 0, TTL_CNT - 1)								AS CLPT_KNT		/* 마지막 PORT를 제외한 CALLING PORT 수		*/" ).append("\n"); 
		query.append("	      ,	SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.LNK_DIST)) OVER () AS TTL_DIST	/* 마지막 ROW에 DISTANCE 제외한 총 거리 	*/" ).append("\n"); 
		query.append("	      ,	MAX ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.LNK_SPD )) OVER () AS MAX_SPD		/* 마지막 ROW에 DISTANCE 제외한 최대 속도	*/" ).append("\n"); 
		query.append("	      , DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.LNK_SPD )) OVER (), 0, 0," ).append("\n"); 
		query.append("	      		SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.LNK_SPD )) OVER ()  / (TTL_CNT - 1 )" ).append("\n"); 
		query.append("	      	)				AS AVG_SPD		/* 마지막 ROW에 DISTANCE 제외한 평균 속도	*/" ).append("\n"); 
		query.append("	      , 'N'				AS DELT_FLG" ).append("\n"); 
		query.append("	      , T1.SIM_RMK		AS PF_SKD_RMK" ).append("\n"); 
		query.append("	      , DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.SEA_BUF_SPD)) OVER (), 0, 0," ).append("\n"); 
		query.append("	      		 SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.SEA_BUF_SPD)) OVER () / (TTL_CNT - 1 ) " ).append("\n"); 
		query.append("	      	) 					AS AVG_SEA_BUF_SPD" ).append("\n"); 
		query.append("	      , (DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.TZTM_HRS		)) OVER (), 0, 0, T2.TZTM_HRS)" ).append("\n"); 
		query.append("	       +DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.SEA_BUF_HRS	)) OVER (), 0, 0, T2.SEA_BUF_HRS)" ).append("\n"); 
		query.append("	       +DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.MNVR_IN_HRS	)) OVER (), 0, 0, T2.MNVR_IN_HRS)" ).append("\n"); 
		query.append("	       +DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.MNVR_OUT_HRS	)) OVER (), 0, 0, T2.MNVR_OUT_HRS)" ).append("\n"); 
		query.append("	       +DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.ACT_WRK_HRS	)) OVER (), 0, 0, T2.ACT_WRK_HRS)" ).append("\n"); 
		query.append("	       +DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.PORT_BUF_HRS	)) OVER (), 0, 0, T2.PORT_BUF_HRS))*100 AS BOT_TOT_BUF_RAT" ).append("\n"); 
		query.append("	      ,(DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.TZTM_HRS		)) OVER (), 0, 0, T2.TZTM_HRS)" ).append("\n"); 
		query.append("	       +DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.SEA_BUF_HRS	)) OVER (), 0, 0, T2.SEA_BUF_HRS)" ).append("\n"); 
		query.append("	       +DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.MNVR_IN_HRS	)) OVER (), 0, 0, T2.MNVR_IN_HRS)" ).append("\n"); 
		query.append("	       +DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.MNVR_OUT_HRS	)) OVER (), 0, 0, T2.MNVR_OUT_HRS))*100 AS BOT_SEA_BUF_RAT" ).append("\n"); 
		query.append("	      ,(DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.ACT_WRK_HRS	)) OVER (), 0, 0, T2.ACT_WRK_HRS)" ).append("\n"); 
		query.append("	       +DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.PORT_BUF_HRS	)) OVER (), 0, 0, T2.PORT_BUF_HRS))*100 AS BOT_PORT_BUF_RAT" ).append("\n"); 
		query.append("	      ,(DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.TZTM_HRS		)) OVER (), 0, 0, T2.TZTM_HRS)" ).append("\n"); 
		query.append("	       +DECODE(SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.SEA_BUF_HRS	)) OVER (), 0, 0, T2.SEA_BUF_HRS)) AS BOT_BUF_SPD_RAT" ).append("\n"); 
		query.append("	      , SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.SEA_BUF_SPD	)) OVER () AS SUM_SEA_BUF_SPD	" ).append("\n"); 
		query.append("	      , SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.ACT_WRK_HRS	)) OVER () AS SUM_ACT_WRK_HRS	" ).append("\n"); 
		query.append("		  , SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.MNVR_IN_HRS	)) OVER () AS SUM_MNVR_IN_HRS" ).append("\n"); 
		query.append("		  , SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.MNVR_OUT_HRS	)) OVER () AS SUM_MNVR_OUT_HRS" ).append("\n"); 
		query.append("		  , SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.PORT_BUF_HRS	)) OVER () AS SUM_PORT_BUF_HRS							  " ).append("\n"); 
		query.append("	      , SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.TZTM_HRS		)) OVER () AS SUM_TZTH_HRS" ).append("\n"); 
		query.append("	      , SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.SEA_BUF_HRS	)) OVER () AS SUM_SEA_BUFF_HRS" ).append("\n"); 
		query.append("	      , SUM ( DECODE( T2.PORT_SEQ, T4.TTL_CNT, 0,  T2.LNK_DIST		)) OVER () AS SUM_LNK_DIST" ).append("\n"); 
		query.append("	      , (" ).append("\n"); 
		query.append("	        SELECT NVL(MIN(MAX_SPD), 1)" ).append("\n"); 
		query.append("	        FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("	        WHERE (CNTR_VSL_CLSS_CAPA	= T5.N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append("	              OR CNTR_VSL_CLSS_CAPA = T5.N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append("	              OR CNTR_VSL_CLSS_CAPA = T5.N3RD_VSL_CLSS_CD)" ).append("\n"); 
		query.append("	          AND NVL(MAX_SPD, 0) > 0 )      AS MIN_MAX_SPD		/* 입력된 CLASS 중에 가장 작은 MAX SPEED	*/" ).append("\n"); 
		query.append("	      , NVL((" ).append("\n"); 
		query.append("	            SELECT 'N' /* 입력 받은 PORT, GANG WORK START TIME이 일치 : 'N', 불일치 : 'Y' 표시. */" ).append("\n"); 
		query.append("	            FROM DUAL /* P/F SKD 작성시 'N'일 경우를 정상 작업 가능 시간으로 판단한다. */" ).append("\n"); 
		query.append("	            WHERE 1 = 1" ).append("\n"); 
		query.append("	              AND EXISTS (" ).append("\n"); 
		query.append("	                SELECT 'X'" ).append("\n"); 
		query.append("	                FROM VSK_PORT_GNG_STRC S" ).append("\n"); 
		query.append("	                WHERE S.LOC_CD = SUBSTR(T2.TML_CD, 1, 5)" ).append("\n"); 
		query.append("	                  AND S.GNG_WRK_ST_HRMNT = T2.ETB_TM_HRMNT )), 'Y') AS CHECK_WK_TM ," ).append("\n"); 
		query.append("	      T3.CRANE_WK_TM" ).append("\n"); 
		query.append("	    FROM COA_SIM_INFO T1," ).append("\n"); 
		query.append("	      COA_SIM_TML_INFO T2 ," ).append("\n"); 
		query.append("	      (" ).append("\n"); 
		query.append("	        SELECT LOC_CD," ).append("\n"); 
		query.append("	          MAX( DECODE(SEQ, 01, TM)) || DECODE(SIGN(CNT + 1 - 02), 1, CHR(10)|| MAX( DECODE(SEQ, 02, TM))) || DECODE(SIGN(CNT + 1 - 03), 1, CHR(10)|| MAX( DECODE(SEQ, 03, TM))) || DECODE(SIGN(CNT + 1 - 04), 1, CHR(10)|| MAX( DECODE(SEQ, 04, TM))) || DECODE(SIGN(CNT + 1 - 05), 1, CHR(10)|| MAX( DECODE(SEQ, 05, TM))) || DECODE(SIGN(CNT + 1 - 06), 1, CHR(10)|| MAX( DECODE(SEQ, 06, TM))) || DECODE(SIGN(CNT + 1 - 07), 1, CHR(10)|| MAX( DECODE(SEQ, 07, TM))) || DECODE(SIGN(CNT + 1 - 08), 1, CHR(10)|| MAX( DECODE(SEQ, 08, TM))) || DECODE(SIGN(CNT + 1 - 09), 1, CHR(10)|| MAX( DECODE(SEQ, 09, TM))) || DECODE(SIGN(CNT + 1 - 10), 1, CHR(10)|| MAX( DECODE(SEQ, 10, TM))) || DECODE(SIGN(CNT + 1 - 11), 1, CHR(10)|| MAX( DECODE(SEQ, 11, TM))) || DECODE(SIGN(CNT + 1 - 12), 1, CHR(10)|| MAX( DECODE(SEQ, 12, TM))) || DECODE(SIGN(CNT + 1 - 13), 1, CHR(10)|| MAX( DECODE(SEQ, 13, TM))) || DECODE(SIGN(CNT + 1 - 14), 1, CHR(10)|| MAX( DECODE(SEQ, 14, TM))) || DECODE(SIGN(CNT + 1 - 15), 1, CHR(10)|| MAX( DECODE(SEQ, 15, TM))) || DECODE(SIGN(CNT + 1 - 16), 1, CHR(10)|| MAX( DECODE(SEQ, 16, TM))) || DECODE(SIGN(CNT + 1 - 17), 1, CHR(10)|| MAX( DECODE(SEQ, 17, TM))) || DECODE(SIGN(CNT + 1 - 18), 1, CHR(10)|| MAX( DECODE(SEQ, 18, TM))) || DECODE(SIGN(CNT + 1 - 19), 1, CHR(10)|| MAX( DECODE(SEQ, 19, TM))) || DECODE(SIGN(CNT + 1 - 20), 1, CHR(10)|| MAX( DECODE(SEQ, 20, TM))) AS CRANE_WK_TM" ).append("\n"); 
		query.append("	        FROM (" ).append("\n"); 
		query.append("	            SELECT LOC_CD ," ).append("\n"); 
		query.append("	              ROW_NUMBER() OVER (PARTITION BY LOC_CD" ).append("\n"); 
		query.append("	                ORDER BY CRN_SEQ) AS SEQ ," ).append("\n"); 
		query.append("	              SUBSTR(GNG_WRK_ST_HRMNT, 1, 2) || ':' || SUBSTR(GNG_WRK_ST_HRMNT, 3, 2) AS TM ," ).append("\n"); 
		query.append("	              COUNT(*) OVER (PARTITION BY LOC_CD) AS CNT" ).append("\n"); 
		query.append("	            FROM VSK_PORT_GNG_STRC )" ).append("\n"); 
		query.append("	        GROUP BY LOC_CD, CNT ) T3," ).append("\n"); 
		query.append("	        (" ).append("\n"); 
		query.append("	        	SELECT	COUNT(*)		AS TTL_CNT	/* 총 ROW 수 */" ).append("\n"); 
		query.append("	        	FROM	COA_SIM_TML_INFO" ).append("\n"); 
		query.append("	        	WHERE	1		= 1" ).append("\n"); 
		query.append("	        	AND 	SIM_DT	= @[sim_dt]" ).append("\n"); 
		query.append("	      		AND		SIM_NO	= TRIM(TO_CHAR(TO_NUMBER(@[sim_no]), '000'))" ).append("\n"); 
		query.append("	        ) T4," ).append("\n"); 
		query.append("	        (	SELECT	MAX(DECODE(NO, 1, VSL_CLSS_CAPA	)) AS N1ST_VSL_CLSS_CD	/* 투입 VESSEL CAPA, 척수를 분리한다.*/" ).append("\n"); 
		query.append("						, MAX(DECODE(NO, 1, VSL_CNT		, 0	)) AS N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append("						, MAX(DECODE(NO, 2, VSL_CLSS_CAPA	)) AS N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append("						, MAX(DECODE(NO, 2, VSL_CNT		, 0	)) AS N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append("						, MAX(DECODE(NO, 3, VSL_CLSS_CAPA	)) AS N3RD_VSL_CLSS_CD" ).append("\n"); 
		query.append("						, MAX(DECODE(NO, 3, VSL_CNT		, 0	)) AS N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append("				FROM	(" ).append("\n"); 
		query.append("						SELECT ROWNUM NO, VSL_CLSS_CAPA, VSL_CNT" ).append("\n"); 
		query.append("						FROM	(" ).append("\n"); 
		query.append("									SELECT	VSL_CLSS_CAPA" ).append("\n"); 
		query.append("											,COUNT(DISTINCT VSL_CD) AS VSL_CNT " ).append("\n"); 
		query.append("									FROM	COA_SIM_VSL_SET_INFO" ).append("\n"); 
		query.append("									WHERE	1		= 1" ).append("\n"); 
		query.append("									AND		SIM_DT	= @[sim_dt]" ).append("\n"); 
		query.append("									AND		SIM_NO	= TRIM(TO_CHAR(TO_NUMBER(@[sim_no]), '000'))" ).append("\n"); 
		query.append("									AND		VSL_CLSS_CAPA IS NOT NULL" ).append("\n"); 
		query.append("									GROUP BY VSL_CLSS_CAPA" ).append("\n"); 
		query.append("									ORDER BY 1 DESC" ).append("\n"); 
		query.append("						    	)" ).append("\n"); 
		query.append("						WHERE	ROWNUM <= 3" ).append("\n"); 
		query.append("				    	)" ).append("\n"); 
		query.append("	        )	T5					        " ).append("\n"); 
		query.append("	    WHERE	T1.SIM_DT			= T2.SIM_DT" ).append("\n"); 
		query.append("	    AND		T1.SIM_NO			= T2.SIM_NO" ).append("\n"); 
		query.append("		AND		T1.SIM_DT			= @[sim_dt]" ).append("\n"); 
		query.append("	    AND		T1.SIM_NO			= TRIM(TO_CHAR(TO_NUMBER(@[sim_no]), '000'))				      	" ).append("\n"); 
		query.append("		AND		T3.LOC_CD	(+)		= SUBSTR(T2.TML_CD, 1, 5)				      	" ).append("\n"); 
		query.append("	    AND		SUBSTR(T2.TML_CD, 1, 5)	= T3.LOC_CD (+)" ).append("\n"); 
		query.append("      )T" ).append("\n"); 
		query.append("ORDER BY T.PORT_ROTN_SEQ" ).append("\n"); 

	}
}