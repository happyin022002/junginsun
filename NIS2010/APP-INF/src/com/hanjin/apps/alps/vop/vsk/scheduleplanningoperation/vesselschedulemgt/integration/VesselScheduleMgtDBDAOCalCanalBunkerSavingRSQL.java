/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCalCanalBunkerSavingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.24
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.10.24 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCalCanalBunkerSavingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선박의 최대 선속으로 인한 Bunker 비용과 Canal Surcharge 비용 차이를 조회합니다.
	  * 
	  * History
	  * 2012.10.24 CHM-201220527-01 진마리아 Departure/Noon Report 데이터를 FCM 데이터와 I/F하도록 변경 요청
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCalCanalBunkerSavingRSQL(){
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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCalCanalBunkerSavingRSQL").append("\n"); 
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
		query.append("--SELECT " ).append("\n"); 
		query.append("--'' VSL_CD," ).append("\n"); 
		query.append("--'' SKD_VOY_NO," ).append("\n"); 
		query.append("--'' SKD_DIR_CD," ).append("\n"); 
		query.append("--'' VPS_PORT_CD," ).append("\n"); 
		query.append("--'' LMT_TM_SCG_RTO," ).append("\n"); 
		query.append("--'' ETA_SPEED," ).append("\n"); 
		query.append("--'' ADD_BUNKER_CONSUM_QTY," ).append("\n"); 
		query.append("--'' ADD_BUNKER_CONSUM_AMOUNT," ).append("\n"); 
		query.append("--'' NEXT_PORT_ETA_SPEED," ).append("\n"); 
		query.append("--'' ADD_BUNKER_CONSUM_02," ).append("\n"); 
		query.append("--'' ADD_BUNKER_AMOUNT_02," ).append("\n"); 
		query.append("--'' RESULT," ).append("\n"); 
		query.append("--'' FM_PORT," ).append("\n"); 
		query.append("--'' TO_PORT," ).append("\n"); 
		query.append("--'' REPORTED_DATE," ).append("\n"); 
		query.append("--'' NXT_PORT_ETA," ).append("\n"); 
		query.append("--'' REMAIN_DIST," ).append("\n"); 
		query.append("--'' REMAIN_SPD," ).append("\n"); 
		query.append("--'' WIND_DIR_SCALE," ).append("\n"); 
		query.append("--'' SEA_DIR_SCALE," ).append("\n"); 
		query.append("--'' SUPPLY_BUNKER_QTY," ).append("\n"); 
		query.append("--'' SUPPLY_BUNKER_PORT," ).append("\n"); 
		query.append("--'' ACTUAL_BUNKER_PRICE," ).append("\n"); 
		query.append("--'' REMAIN_BUNKER," ).append("\n"); 
		query.append("--'' BUNKER_CONSUM_BY_ETA," ).append("\n"); 
		query.append("--'' COURSE_ORG," ).append("\n"); 
		query.append("--'' CANAL_TZ_SURCHG_AMT," ).append("\n"); 
		query.append("--'' SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("--'' NEXT_PORT," ).append("\n"); 
		query.append("--'' CTS_1ST," ).append("\n"); 
		query.append("--'' CTS_2ND," ).append("\n"); 
		query.append("--'' CTS_3RD" ).append("\n"); 
		query.append("--FROM DUAL" ).append("\n"); 
		query.append("SELECT	LMT_TM_SCG_RTO" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(ETA_SPEED, '999,990.9')) ETA_SPEED" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(ADD_BUNKER_CONSUM_QTY, '999,999,990.9')) ADD_BUNKER_CONSUM_QTY" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(ADD_BUNKER_CONSUM_AMOUNT, '999,999,990.9')) ADD_BUNKER_CONSUM_AMOUNT" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(NEXT_PORT_ETA_SPEED, '999,990.9')) NEXT_PORT_ETA_SPEED" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(ADD_BUNKER_CONSUM_02, '999,999,990.9')) ADD_BUNKER_CONSUM_02" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(ADD_BUNKER_AMOUNT_02, '999,999,990.9')) ADD_BUNKER_AMOUNT_02" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(CANAL_TZ_SURCHG_AMT + ADD_BUNKER_CONSUM_AMOUNT + ADD_BUNKER_AMOUNT_02, '999,999,990.9')) AS RESULT" ).append("\n"); 
		query.append("    	, FM_PORT" ).append("\n"); 
		query.append("    	, TO_PORT" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(REPORTED_DATE, 'YYYY-MM-DD HH24:MI')) REPORTED_DATE" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(NXT_PORT_ETA, 'YYYY-MM-DD HH24:MI')) NXT_PORT_ETA" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(REMAIN_DIST, '999,999,990.9')) REMAIN_DIST" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(REMAIN_SPD, '999,999,990.9')) REMAIN_SPD" ).append("\n"); 
		query.append("    	, WIND_DIR_SCALE" ).append("\n"); 
		query.append("    	, SEA_DIR_SCALE" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(SUPPLY_BUNKER_QTY, '999,999,990.9')) SUPPLY_BUNKER_QTY" ).append("\n"); 
		query.append("    	, SUPPLY_BUNKER_PORT" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(ACTUAL_BUNKER_PRICE, '999,990.9')) ACTUAL_BUNKER_PRICE" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(REMAIN_BUNKER, '999,999,990.9')) REMAIN_BUNKER" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(BUNKER_CONSUM_BY_ETA, '999,999,990.9')) BUNKER_CONSUM_BY_ETA" ).append("\n"); 
		query.append("    	, COURSE_ORG" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(CANAL_TZ_SURCHG_AMT, '999,999,990.9')) CANAL_TZ_SURCHG_AMT" ).append("\n"); 
		query.append("    	, TRIM(TO_CHAR(0, '999,999,990.9')) SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("    	, THRTH_PORT AS NEXT_PORT" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(ROUND((NVL(TTL_CHG_AMT, 0) * 0.03), 1), '999,990.9')) AS CTS_1ST" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(ROUND((NVL(TTL_CHG_AMT, 0) * 0.05), 1), '999,990.9')) AS CTS_2ND" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(ROUND((NVL(TTL_CHG_AMT, 0) * 0.10), 1), '999,990.9')) AS CTS_3RD" ).append("\n"); 
		query.append("FROM	(/*T41*/" ).append("\n"); 
		query.append("		SELECT	LMT_TM_SCG_RTO" ).append("\n"); 
		query.append("				, ETA_SPEED" ).append("\n"); 
		query.append("				, ROUND((ROUND((T31.FOC_HR / POWER(T31.SPD_P, 3)) * POWER((T31.ETA_SPEED / (1 - (T31.SLIP / 100))), 3) * 24, 1) -" ).append("\n"); 
		query.append("		          ROUND((T31.FOC_HR / POWER(T31.SPD_P, 3)) * POWER((T31.REMAIN_SPD / (1 - (T31.SLIP / 100))), 3) * 24, 1)) *" ).append("\n"); 
		query.append("		         (ABS( T31.FM_NEXT_LIMIT_ETA  - T31.NXT_PORT_ETA)),1) AS ADD_BUNKER_CONSUM_QTY														/* Last Port에서 스에즈까지 추가 사용되는 Bunker량	*/" ).append("\n"); 
		query.append("		        , (ROUND((ROUND((T31.FOC_HR / POWER(T31.SPD_P, 3)) * POWER((T31.ETA_SPEED / (1 - (T31.SLIP / 100))), 3) * 24, 1) -" ).append("\n"); 
		query.append("		          ROUND((T31.FOC_HR / POWER(T31.SPD_P, 3)) * POWER((T31.REMAIN_SPD / (1 - (T31.SLIP / 100))), 3) * 24, 1)) *" ).append("\n"); 
		query.append("		         ( ABS(T31.FM_NEXT_LIMIT_ETA  - T31.NXT_PORT_ETA)),1) * ACTUAL_BUNKER_PRICE)  			 	AS ADD_BUNKER_CONSUM_AMOUNT			/* Last Port에서 스에즈까지 추가 사용되는 Bunker 금액 */" ).append("\n"); 
		query.append("		        , ROUND(EGSUZ_THIRT_PORT_DISTANCE / ((THRTH_PORT_GMT_ETA - EGSUZ_PORT_GMT_ETD) * 24), 1) 	AS NEXT_PORT_ETA_SPEED				/* 스에즈~다음 Port까지 갈때 Avg. Speed		*/" ).append("\n"); 
		query.append("				, ROUND((ROUND((FOC_HR / POWER(SPD_P, 3)) * POWER((ROUND(EGSUZ_THIRT_PORT_DISTANCE / ((THRTH_PORT_GMT_ETA - EGSUZ_PORT_GMT_ETD) * 24), 1) / (1 - (SLIP / 100))), 3) * 24, 1) -" ).append("\n"); 
		query.append("			        ROUND((FOC_HR / POWER(SPD_P, 3)) * POWER(( THRTH_PF_SPEED / (1 - (SLIP / 100))), 3) * 24, 1)) *" ).append("\n"); 
		query.append("			        ( THRTH_PORT_GMT_ETA - EGSUZ_PORT_GMT_ETD),1) 											AS ADD_BUNKER_CONSUM_02 /* 스에즈~다음 Port까지 가는데 추가 사용되는 Bunker량 */" ).append("\n"); 
		query.append("			    , (ROUND((ROUND((FOC_HR / POWER(SPD_P, 3)) * POWER((ROUND(EGSUZ_THIRT_PORT_DISTANCE / ((THRTH_PORT_GMT_ETA - EGSUZ_PORT_GMT_ETD) * 24), 1) / (1 - (SLIP / 100))), 3) * 24, 1) -" ).append("\n"); 
		query.append("			        ROUND((FOC_HR / POWER(SPD_P, 3)) * POWER(( THRTH_PF_SPEED / (1 - (SLIP / 100))), 3) * 24, 1)) *" ).append("\n"); 
		query.append("			        ( THRTH_PORT_GMT_ETA - EGSUZ_PORT_GMT_ETD),1)) * ACTUAL_BUNKER_PRICE					AS ADD_BUNKER_AMOUNT_02 /* 스에즈~다음 Port까지 가는데 추가 사용되는 Bunker량 */" ).append("\n"); 
		query.append("				, FM_PORT" ).append("\n"); 
		query.append("				, TO_PORT" ).append("\n"); 
		query.append("				, REPORTED_DATE" ).append("\n"); 
		query.append("				, NXT_PORT_ETA" ).append("\n"); 
		query.append("				, REMAIN_DIST" ).append("\n"); 
		query.append("				, REMAIN_SPD" ).append("\n"); 
		query.append("				, WIND_DIR_SCALE" ).append("\n"); 
		query.append("				, SEA_DIR_SCALE" ).append("\n"); 
		query.append("				, SUPPLY_BUNKER_QTY" ).append("\n"); 
		query.append("				, SUPPLY_BUNKER_PORT" ).append("\n"); 
		query.append("				, ACTUAL_BUNKER_PRICE" ).append("\n"); 
		query.append("				, REMAIN_BUNKER" ).append("\n"); 
		query.append("--				, ROUND((ROUND((T31.FOC_HR / POWER(T31.SPD_P, 3)) * POWER((T31.REMAIN_SPD / (1 - (T31.SLIP / 100))), 3) * 24, 1)) *" ).append("\n"); 
		query.append("--		         ( T31.NXT_PORT_ETA  - T31.REPORTED_DATE),1) 												AS BUNKER_CONSUM_BY_ETA		/* Last Port에서 스에즈까지 추가 사용되는 Bunker량	*/" ).append("\n"); 
		query.append("				, (ROUND((T31.FOC_HR / POWER(T31.SPD_P, 3)) * POWER((T31.REMAIN_SPD / (1 - (T31.SLIP / 100))), 3), 1)) AS BUNKER_CONSUM_BY_ETA /* ETA(REMAIN_SPD)에 따른 시간간 Bunker 소모량 */" ).append("\n"); 
		query.append("				, COURSE_ORG" ).append("\n"); 
		query.append("				, MDM_MAX_SPD" ).append("\n"); 
		query.append("				, SVC_SCP_BND_CD" ).append("\n"); 
		query.append("				, SCG_TO_LMT_HRMNT" ).append("\n"); 
		query.append("				, ACTUAL_MAX_SPEED" ).append("\n"); 
		query.append("				, FM_NEXT_LIMIT_ETA" ).append("\n"); 
		query.append("				, EGSUZ_PORT_GMT_ETD" ).append("\n"); 
		query.append("				, THRTH_PF_SPEED" ).append("\n"); 
		query.append("				, EGSUZ_THIRT_PORT_DISTANCE" ).append("\n"); 
		query.append("				, THRTH_PORT_GMT_ETA" ).append("\n"); 
		query.append("				, THRTH_PORT" ).append("\n"); 
		query.append("				, CANAL_TZ_SURCHG_AMT" ).append("\n"); 
		query.append("				, SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("				, CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("		FROM	( /*T31*/" ).append("\n"); 
		query.append("				SELECT	LMT_TM_SCG_RTO" ).append("\n"); 
		query.append("						, VSL_CD" ).append("\n"); 
		query.append("						, SKD_DIR_CD" ).append("\n"); 
		query.append("						, FM_PORT" ).append("\n"); 
		query.append("						, TO_PORT" ).append("\n"); 
		query.append("						, REPORTED_DATE" ).append("\n"); 
		query.append("						, NXT_PORT_ETA" ).append("\n"); 
		query.append("						, REMAIN_DIST" ).append("\n"); 
		query.append("						, REMAIN_SPD" ).append("\n"); 
		query.append("						, WIND_DIR_SCALE" ).append("\n"); 
		query.append("						, SEA_DIR_SCALE" ).append("\n"); 
		query.append("						, SUPPLY_BUNKER_QTY" ).append("\n"); 
		query.append("						, SUPPLY_BUNKER_PORT" ).append("\n"); 
		query.append("						, ACTUAL_BUNKER_PRICE" ).append("\n"); 
		query.append("						, REMAIN_BUNKER" ).append("\n"); 
		query.append("--						, BUNKER_CONSUM_BY_ETA" ).append("\n"); 
		query.append("						, COURSE_ORG" ).append("\n"); 
		query.append("						, MDM_MAX_SPD" ).append("\n"); 
		query.append("						, SVC_SCP_BND_CD" ).append("\n"); 
		query.append("						, SCG_TO_LMT_HRMNT				" ).append("\n"); 
		query.append("						, ACTUAL_MAX_SPEED" ).append("\n"); 
		query.append("						, DIST_O" ).append("\n"); 
		query.append("						, SPD_O" ).append("\n"); 
		query.append("						, SPD_P" ).append("\n"); 
		query.append("						, BUNK_CONS " ).append("\n"); 
		query.append("						, SLIP" ).append("\n"); 
		query.append("						, FOC_HR" ).append("\n"); 
		query.append("						, ROUND(T21.REMAIN_DIST / ((GLOBALDATE_PKG.TIME_CONV_FNC(T21.TO_PORT, TO_DATE(TO_CHAR(T21.NXT_PORT_ETA + T21.TZ_SURCHG_TIME_CALC, 'YYYYMMDD') || T21.SCG_TO_LMT_HRMNT, 'YYYYMMDDHH24MI'), 'GMT')" ).append("\n"); 
		query.append("									- T21.REPORTED_DATE) * 24 ), 1) 	AS ETA_SPEED" ).append("\n"); 
		query.append("						, TO_DATE(TO_CHAR(T21.NXT_PORT_ETA + T21.TZ_SURCHG_TIME_CALC, 'YYYYMMDD') || T21.SCG_TO_LMT_HRMNT, 'YYYYMMDDHH24MI') AS FM_NEXT_LIMIT_ETA" ).append("\n"); 
		query.append("						, (GLOBALDATE_PKG.TIME_CONV_FNC(T21.TO_PORT," ).append("\n"); 
		query.append("							CASE WHEN SVC_SCP_BND_CD||CNL_TZ_SEQ_CD = 'N1' THEN	/* NORTH BOUND & FIRST CONVOY	*/" ).append("\n"); 
		query.append("								TO_DATE(TO_CHAR(T21.NXT_PORT_ETA + T21.TZ_ETD_TIME_CALC, 'YYYYMMDD') || '1600', 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("							WHEN SVC_SCP_BND_CD||CNL_TZ_SEQ_CD = 'N2' THEN		/* NORTH BOUND & SECOND CONVOY	*/" ).append("\n"); 
		query.append("								TO_DATE(TO_CHAR(T21.NXT_PORT_ETA + T21.TZ_ETD_TIME_CALC, 'YYYYMMDD') || '1800', 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("							WHEN SVC_SCP_BND_CD||CNL_TZ_SEQ_CD = 'S1' THEN		/* SOUTH BOUND & FIRST CONVOY	*/" ).append("\n"); 
		query.append("								TO_DATE(TO_CHAR(T21.NXT_PORT_ETA + T21.TZ_ETD_TIME_CALC, 'YYYYMMDD') || '1600', 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("							WHEN SVC_SCP_BND_CD||CNL_TZ_SEQ_CD = 'S2' THEN		/* SOUTH BOUND & SECOND CONVOY	*/" ).append("\n"); 
		query.append("								TO_DATE(TO_CHAR(T21.NXT_PORT_ETA + T21.TZ_ETD_TIME_CALC, 'YYYYMMDD') || '2300', 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("							END" ).append("\n"); 
		query.append("							, 'GMT')) AS EGSUZ_PORT_GMT_ETD					/* 스웨즈 출항 GMT ETD DATE				*/" ).append("\n"); 
		query.append("						, THRTH_PF_SPEED" ).append("\n"); 
		query.append("						, GLOBALDATE_PKG.TIME_CONV_FNC(T21.THRTH_PORT, THRTH_ETA, 'GMT') AS THRTH_PORT_GMT_ETA	/* 스에즈 이후 도착 PORT GMT ETA DATE	*/				" ).append("\n"); 
		query.append("						, THRTH_PORT" ).append("\n"); 
		query.append("						, EGSUZ_THIRT_PORT_DISTANCE" ).append("\n"); 
		query.append("						, CANAL_TZ_SURCHG_AMT" ).append("\n"); 
		query.append("						, SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("						, CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("				FROM	( /*T21*/" ).append("\n"); 
		query.append("						SELECT	T12.LMT_TM_SCG_RTO || '%' 		AS LMT_TM_SCG_RTO" ).append("\n"); 
		query.append("								, VSL_CD" ).append("\n"); 
		query.append("								, SKD_DIR_CD" ).append("\n"); 
		query.append("								, FM_PORT" ).append("\n"); 
		query.append("								, TO_PORT" ).append("\n"); 
		query.append("								, REPORTED_DATE" ).append("\n"); 
		query.append("								, NXT_PORT_ETA" ).append("\n"); 
		query.append("								, REMAIN_DIST" ).append("\n"); 
		query.append("								, REMAIN_SPD" ).append("\n"); 
		query.append("								, WIND_DIR_SCALE" ).append("\n"); 
		query.append("								, SEA_DIR_SCALE" ).append("\n"); 
		query.append("								, SUPPLY_BUNKER_QTY" ).append("\n"); 
		query.append("								, SUPPLY_BUNKER_PORT" ).append("\n"); 
		query.append("								, ACTUAL_BUNKER_PRICE" ).append("\n"); 
		query.append("								, REMAIN_BUNKER" ).append("\n"); 
		query.append("								, COURSE_ORG" ).append("\n"); 
		query.append("								, MDM_MAX_SPD" ).append("\n"); 
		query.append("								, CNL_TZ_SEQ_CD" ).append("\n"); 
		query.append("								, CASE WHEN T12.SVC_SCP_BND_CD = 'N' THEN	/* NORTH BOUND */" ).append("\n"); 
		query.append("										CASE WHEN ( NXT_PORT_ETA_TIME >= '0601' AND NXT_PORT_ETA_TIME <= '2359') THEN" ).append("\n"); 
		query.append("											1	/* ETA 시간이 0601 ~ 2359 일 경우에 'N' BOUND에서는 그 다음날 통항해야 함. 따라서, ETA + 1에 통항하게 됨 */" ).append("\n"); 
		query.append("										ELSE" ).append("\n"); 
		query.append("											0" ).append("\n"); 
		query.append("										END" ).append("\n"); 
		query.append("									ELSE									/* SOUTH BOUND */" ).append("\n"); 
		query.append("										CASE WHEN ( NXT_PORT_ETA_TIME >= '0601' AND NXT_PORT_ETA_TIME <= '1859') THEN" ).append("\n"); 
		query.append("												CASE WHEN T12.CNL_TZ_SEQ_CD = '1' THEN	/* FIRST COMVOY		*/" ).append("\n"); 
		query.append("													/* 0000 ~ 0059 는 FIRST CONVOY 지만 실제 날짜는 익일로 처리 */" ).append("\n"); 
		query.append("													CASE WHEN T12.SCG_TO_LMT_HRMNT >= '0000' AND T12.SCG_TO_LMT_HRMNT <='0059' THEN" ).append("\n"); 
		query.append("										                 1" ).append("\n"); 
		query.append("									                ELSE" ).append("\n"); 
		query.append("										                 0" ).append("\n"); 
		query.append("									                END" ).append("\n"); 
		query.append("												ELSE									/* SECOND COMVOY	*/" ).append("\n"); 
		query.append("													1" ).append("\n"); 
		query.append("												END" ).append("\n"); 
		query.append("											WHEN ( NXT_PORT_ETA_TIME >= '0000' AND NXT_PORT_ETA_TIME <= '0600') THEN" ).append("\n"); 
		query.append("												CASE WHEN T12.CNL_TZ_SEQ_CD = '1' THEN	/* FIRST COMVOY		*/" ).append("\n"); 
		query.append("													/* 0000 ~ 0059 는 FIRST CONVOY 지만 실제 날짜는 당일로 처리 */" ).append("\n"); 
		query.append("													CASE WHEN T12.SCG_TO_LMT_HRMNT >= '0000' AND T12.SCG_TO_LMT_HRMNT <='0059' THEN" ).append("\n"); 
		query.append("										                 0" ).append("\n"); 
		query.append("									                ELSE" ).append("\n"); 
		query.append("										                 -1" ).append("\n"); 
		query.append("									                END" ).append("\n"); 
		query.append("												ELSE									/* SECOND COMVOY	*/" ).append("\n"); 
		query.append("													0" ).append("\n"); 
		query.append("												END" ).append("\n"); 
		query.append("											ELSE" ).append("\n"); 
		query.append("												0										/* 일반적인 경우	*/" ).append("\n"); 
		query.append("										END						" ).append("\n"); 
		query.append("									END AS TZ_SURCHG_TIME_CALC		/* 통항 가능 시간을 감안한다. +1, OR 0 을 한다. */" ).append("\n"); 
		query.append("								, CASE WHEN ( NXT_PORT_ETA_TIME >= '0601' AND NXT_PORT_ETA_TIME <= '2359') THEN" ).append("\n"); 
		query.append("										1	/* ETA 시간이 0601 ~ 2359 일 경우에 'N' BOUND에서는 그 다음날 통항해야 함. 따라서, ETA + 1에 통항하게 됨 */" ).append("\n"); 
		query.append("									ELSE" ).append("\n"); 
		query.append("										0" ).append("\n"); 
		query.append("									END AS TZ_ETD_TIME_CALC			/* 통항 후 출항 ETD 시간 계산시 사용. */" ).append("\n"); 
		query.append("								, T12.SVC_SCP_BND_CD	AS SVC_SCP_BND_CD" ).append("\n"); 
		query.append("								, T12.SCG_TO_LMT_HRMNT	AS SCG_TO_LMT_HRMNT				" ).append("\n"); 
		query.append("								, /* COURSE에 반대 방향과 (Wind 와 Sea) 과 같을 경우 */" ).append("\n"); 
		query.append("								  /* Wind 와 Sea 상태 중 계급 6/6,은 0.5 노트 감속, 7/6,6/7,7/7은 1.0노트 감속 8/7,7/8,8/8은 1.5노트 감속하여 Max. Speed의 값을 가감함. */" ).append("\n"); 
		query.append("								(MDM_MAX_SPD - (CASE WHEN (WIND_DIR = COURSE_OBJ_DIR) OR (SEA_DIR = COURSE_OBJ_DIR) THEN" ).append("\n"); 
		query.append("													(CASE	WHEN (WIND_SEA_SCALE = '6/6') THEN -0.5" ).append("\n"); 
		query.append("														WHEN (WIND_SEA_SCALE = '7/6' OR WIND_SEA_SCALE = '6/7' OR WIND_SEA_SCALE = '7/7') THEN -1.0" ).append("\n"); 
		query.append("														WHEN (WIND_SEA_SCALE = '8/7' OR WIND_SEA_SCALE = '7/8' OR WIND_SEA_SCALE = '8/8') THEN -1.5" ).append("\n"); 
		query.append("														ELSE 0 END	)" ).append("\n"); 
		query.append("												ELSE 0 END)" ).append("\n"); 
		query.append("								) 															AS ACTUAL_MAX_SPEED" ).append("\n"); 
		query.append("								, DIST_O" ).append("\n"); 
		query.append("								, SPD_O" ).append("\n"); 
		query.append("								, SPD_P" ).append("\n"); 
		query.append("								, BUNK_CONS " ).append("\n"); 
		query.append("								, ROUND(((T11.SPD_P - T11.SPD_O)/ T11.SPD_P) * 100, 1)		AS SLIP" ).append("\n"); 
		query.append("				                , ROUND(T11.BUNK_CONS / (T11.DIST_O / T11.SPD_O), 2)		AS FOC_HR" ).append("\n"); 
		query.append("				                , THRTH_PF_SPEED" ).append("\n"); 
		query.append("								, THRTH_ETA" ).append("\n"); 
		query.append("								, THRTH_PORT" ).append("\n"); 
		query.append("								, T12.LMT_TM_SCG_RTO * CUR_BASE_AMOUT						AS CANAL_TZ_SURCHG_AMT" ).append("\n"); 
		query.append("								, (	SELECT	STND_DIST" ).append("\n"); 
		query.append("									FROM	VSK_PORT_DIST	S" ).append("\n"); 
		query.append("									WHERE	TO_PORT		= S.FM_LOC_CD" ).append("\n"); 
		query.append("									AND		THRTH_PORT	= S.TO_LOC_CD" ).append("\n"); 
		query.append("									) 								AS EGSUZ_THIRT_PORT_DISTANCE" ).append("\n"); 
		query.append("								, SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("								, CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("						FROM	(/* T11 */" ).append("\n"); 
		query.append("								SELECT	T1.VSL_CD			AS VSL_CD" ).append("\n"); 
		query.append("										, T1.SKD_DIR_CD		AS SKD_DIR_CD" ).append("\n"); 
		query.append("										, T2.DEP_PORT_CD	AS FM_PORT" ).append("\n"); 
		query.append("										, T3.NXT_PORT_CD	AS TO_PORT" ).append("\n"); 
		query.append("										, T3.NOON_RPT_DT	AS REPORTED_DATE" ).append("\n"); 
		query.append("										, NVL(T3.NXT_PORT_ETA_DT, T2.NXT_PORT_ETA_DT )		AS NXT_PORT_ETA 		/* 수에즈 예상 도착 DATE 표시 */" ).append("\n"); 
		query.append("										, TO_CHAR(NVL(T3.NXT_PORT_ETA_DT, T2.NXT_PORT_ETA_DT), 'HH24MI')	AS NXT_PORT_ETA_TIME /* 수에즈 예상 도착 TIME 표시 */" ).append("\n"); 
		query.append("										, NVL(T3.RMN_DIST		, T2.RMN_DIST	)			AS REMAIN_DIST				/* 수에즈까지 남은 거리 */" ).append("\n"); 
		query.append("										, NVL(T3.RMN_AVG_SPD	, T2.RMN_AVG_SPD)			AS REMAIN_SPD				/* 현재 SPEED */" ).append("\n"); 
		query.append("										, T3.WND_DIR_CTNT 	|| T3.WND_SCL_NO				AS WIND_DIR_SCALE		/* 바람에 방향과 세기 표시	*/" ).append("\n"); 
		query.append("										, T3.WND_DIR_CTNT 									AS WIND_DIR				/* 바람에 방향 표시 		*/" ).append("\n"); 
		query.append("										, T3.OCN_CRNT_CTNT	|| T3.SEA_STE_NO				AS SEA_DIR_SCALE		/* 조류에 방향과 세기 표시	*/" ).append("\n"); 
		query.append("										, T3.OCN_CRNT_CTNT									AS SEA_DIR				/* 조류에 방향 표시         */" ).append("\n"); 
		query.append("										, T3.WND_SCL_NO		|| '/' || T3.SEA_STE_NO			AS WIND_SEA_SCALE" ).append("\n"); 
		query.append("										, VSK_REMOVE_NONE_NUMERIC_FNC(NVL(T4.SPL_FOIL_ACT_WGT,0)) + VSK_REMOVE_NONE_NUMERIC_FNC(NVL(T4.SPL_LOW_SULP_FOIL_ACT_WGT,0))	AS SUPPLY_BUNKER_QTY	/* 가장 최근에 수급한 BUNKER 량 표시 */" ).append("\n"); 
		query.append("										, T4.DEP_PORT_CD									AS SUPPLY_BUNKER_PORT" ).append("\n"); 
		query.append("										, (" ).append("\n"); 
		query.append("											/* WORKING COMMANCE DATE과  BUNKER PRICE에 입력날짜가 정확이 MAPPING 되지 않음" ).append("\n"); 
		query.append("											따라서, 단가 입력 기간을 -2 ~ +2로 잡았음.(확인 필요)" ).append("\n"); 
		query.append("											*/" ).append("\n"); 
		query.append("											SELECT	MAX(ACT_PRC) " ).append("\n"); 
		query.append("											FROM	VSK_BNK_PRC" ).append("\n"); 
		query.append("											WHERE	PORT_CD				= T4.DEP_PORT_CD" ).append("\n"); 
		query.append("											AND		FOIL_DOIL_DIV_CD	= 'F'	/* BUNKER만 */" ).append("\n"); 
		query.append("											AND		TO_DATE(TO_CHAR(T4.CGO_WRK_ST_DT, 'YYYYMMDD'), 'YYYYMMDD') BETWEEN EVNT_DT - 2 AND  EVNT_DT + 2" ).append("\n"); 
		query.append("											) AS ACTUAL_BUNKER_PRICE" ).append("\n"); 
		query.append("										, ((VSK_REMOVE_NONE_NUMERIC_FNC(NVL(T2.DEP_FOIL_WGT,0)) + VSK_REMOVE_NONE_NUMERIC_FNC(NVL(T2.DEP_LOW_SULP_FOIL_WGT,0)))  	/* LAST PORT 출항 당시 BUNKER 양 */" ).append("\n"); 
		query.append("										- ( SELECT	SUM(VSK_REMOVE_NONE_NUMERIC_FNC(NVL(MN_FOIL_CSM_QTY,0)))						/* LAST PORT 출항 이후 현재까지 BUNKER 사용량	*/" ).append("\n"); 
		query.append("											FROM	FCM_NOON_RPT S" ).append("\n"); 
		query.append("											WHERE	1			= 1" ).append("\n"); 
		query.append("											AND		T1.VSL_CD		= S.VSL_CD " ).append("\n"); 
		query.append("											AND     T1.SKD_VOY_NO	= S.SKD_VOY_NO" ).append("\n"); 
		query.append("											AND     T1.SKD_DIR_CD	= S.SKD_DIR_CD" ).append("\n"); 
		query.append("											AND		S.NXT_PORT_CD	= 'EGSUZ'	/* 수에즈 도착 전까지 사용한 BUNKER를 산출한다. */" ).append("\n"); 
		query.append("										)) 													AS REMAIN_BUNKER" ).append("\n"); 
		query.append("										, T3.CRS_NO 										AS COURSE_ORG" ).append("\n"); 
		query.append("										/* 현재 COURSE에 반대(180도)에 해당하는 방위값을 찾는다 */" ).append("\n"); 
		query.append("										, (CASE WHEN MOD((T3.CRS_NO + 180), 360) >= 350 OR MOD((T3.CRS_NO + 180), 360) <= 011 THEN 'N'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 012 OR MOD((T3.CRS_NO + 180), 360) <= 034 THEN 'NNE'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 035 OR MOD((T3.CRS_NO + 180), 360) <= 056 THEN 'NE'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 057 OR MOD((T3.CRS_NO + 180), 360) <= 079 THEN 'ENE'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 080 OR MOD((T3.CRS_NO + 180), 360) <= 101 THEN 'E'			" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 102 OR MOD((T3.CRS_NO + 180), 360) <= 124 THEN 'ESE'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 125 OR MOD((T3.CRS_NO + 180), 360) <= 147 THEN 'SE'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 148 OR MOD((T3.CRS_NO + 180), 360) <= 169 THEN 'SSE'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 170 OR MOD((T3.CRS_NO + 180), 360) <= 192 THEN 'S'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 193 OR MOD((T3.CRS_NO + 180), 360) <= 214 THEN 'SSW'			" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 215 OR MOD((T3.CRS_NO + 180), 360) <= 237 THEN 'SW'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 238 OR MOD((T3.CRS_NO + 180), 360) <= 260 THEN 'WSW'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 261 OR MOD((T3.CRS_NO + 180), 360) <= 281 THEN 'W'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 282 OR MOD((T3.CRS_NO + 180), 360) <= 304 THEN 'WNW'" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 305 OR MOD((T3.CRS_NO + 180), 360) <= 327 THEN 'NW'			" ).append("\n"); 
		query.append("												WHEN MOD((T3.CRS_NO + 180), 360) >= 328 OR MOD((T3.CRS_NO + 180), 360) <= 349 THEN 'NNW'" ).append("\n"); 
		query.append("											END" ).append("\n"); 
		query.append("										) 																AS COURSE_OBJ_DIR" ).append("\n"); 
		query.append("										, (	SELECT	MAX_SPD" ).append("\n"); 
		query.append("											FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("											WHERE	VSL_CD	= T1.VSL_CD" ).append("\n"); 
		query.append("										) 																AS MDM_MAX_SPD" ).append("\n"); 
		query.append("										, (	SELECT	CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("											FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("											WHERE	VSL_CD	= T1.VSL_CD)                                AS CNTR_VSL_CLSS_CAPA																																						" ).append("\n"); 
		query.append("										, T3.NVGT_ML_DIST      											AS DIST_O" ).append("\n"); 
		query.append("										, T3.SAIL_AVG_SPD    											AS SPD_O" ).append("\n"); 
		query.append("										, ROUND(T3.ENG_ML_DIST / (T3.NVGT_ML_DIST / T3.SAIL_AVG_SPD),1)	AS SPD_P" ).append("\n"); 
		query.append("										, ROUND(VSK_REMOVE_NONE_NUMERIC_FNC(NVL(T3.MN_FOIL_CSM_QTY,0))) AS BUNK_CONS" ).append("\n"); 
		query.append("										, (" ).append("\n"); 
		query.append("											SELECT	STND_SVC_SPD" ).append("\n"); 
		query.append("											FROM	VSK_VSL_SKD S1, VSK_PF_SKD S2" ).append("\n"); 
		query.append("											WHERE	1 = 1" ).append("\n"); 
		query.append("											AND		T1.VSL_CD		= S1.VSL_CD" ).append("\n"); 
		query.append("											AND		T1.SKD_VOY_NO	= S1.SKD_VOY_NO" ).append("\n"); 
		query.append("											AND		T1.SKD_DIR_CD	= S1.SKD_DIR_CD" ).append("\n"); 
		query.append("											AND		S1.VSL_SLAN_CD	= S2.VSL_SLAN_CD" ).append("\n"); 
		query.append("											AND		S1.PF_SKD_TP_CD	= S2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("											) 															AS THRTH_PF_SPEED	/* 수에즈 ~ NEXT PORT 까지 P/F SPEED	*/" ).append("\n"); 
		query.append("										, T5.VPS_ETA_DT													AS THRTH_ETA		/* 수에즈 다음 도착 ETA					*/" ).append("\n"); 
		query.append("										, T5.VPS_PORT_CD												AS THRTH_PORT       /* 수에즈 다음 도착 PORT				*/" ).append("\n"); 
		query.append("										, T6.CUR_BASE_AMOUT												AS CUR_BASE_AMOUT	/* 최신 통항 BASE AMOUNT				*/" ).append("\n"); 
		query.append("										, T6.SUZ_NET_TONG_WGT											AS SUZ_NET_TONG_WGT /* 수에즈 CANEL NET TON					*/" ).append("\n"); 
		query.append("								FROM	VSK_VSL_PORT_SKD		T1" ).append("\n"); 
		query.append("										, FCM_DEP_RPT			T2" ).append("\n"); 
		query.append("										, FCM_NOON_RPT			T3" ).append("\n"); 
		query.append("										, FCM_DEP_RPT			T4" ).append("\n"); 
		query.append("										, VSK_VSL_PORT_SKD		T5" ).append("\n"); 
		query.append("										, (" ).append("\n"); 
		query.append("											SELECT	MAX(DECODE(SEQ, 1, BASE_AMT)) * MAX(DECODE(SEQ, 2, BASE_AMT)) AS CUR_BASE_AMOUT, MAX(DECODE(SEQ, 2, SUZ_NET_TONG_WGT)) AS SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("											FROM	(" ).append("\n"); 
		query.append("														SELECT	/* 동일 VESSEL CLASS로 통항했던 선박 중 INVOICE 금액 조회 */" ).append("\n"); 
		query.append("																1 AS SEQ, DECODE(NVL(MAX(LOCL_XCH_RT), 0), 0, 0, NVL(MAX(RQST_AMT), 0) / NVL(MAX(LOCL_XCH_RT), 0)) AS BASE_AMT" ).append("\n"); 
		query.append("																, 0 AS SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("														FROM	PSO_CNL_TZ_FEE		T1" ).append("\n"); 
		query.append("																, PSO_CNL_TZ_FEE_DTL	T2		" ).append("\n"); 
		query.append("														WHERE	1	= 1" ).append("\n"); 
		query.append("														AND		T1.PSO_BZTP_CD	= T2.PSO_BZTP_CD" ).append("\n"); 
		query.append("														AND		T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("														AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("														AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("														AND		T1.YD_CD		= T2.YD_CD" ).append("\n"); 
		query.append("														AND		T1.CALL_SEQ		= T2.CALL_SEQ" ).append("\n"); 
		query.append("														AND		T1.CNL_TZ_BZTP_CD		= 'I'		/* INVOICE		*/" ).append("\n"); 
		query.append("														AND		T1.CNL_TZ_PROC_STS_CD	= 'A'		/* 승인된 건	*/" ).append("\n"); 
		query.append("														--AND		T1.VNDR_SEQ		= VNDR_SEQ" ).append("\n"); 
		query.append("														AND		T2.ROWID		=	NVL(" ).append("\n"); 
		query.append("																						(	/* 동일 VESSEL CODE가 가장 최신에 통행했던 정보 조회한다. */" ).append("\n"); 
		query.append("																							SELECT	/*+ INDEX_DESC (S XAK1PSO_CNL_TZ_FEE_DTL) */" ).append("\n"); 
		query.append("																						  			S.ROWID" ).append("\n"); 
		query.append("																							FROM	PSO_CNL_TZ_FEE_DTL S" ).append("\n"); 
		query.append("																							WHERE	1 = 1" ).append("\n"); 
		query.append("																							AND		S.PSO_BZTP_CD		= '5' 			/* 전도금 & Invoice 업무 		*/" ).append("\n"); 
		query.append("																							AND		S.VSL_CD			= @[vsl_cd]		/* 입력된 VESSEL CODE			*/" ).append("\n"); 
		query.append("																							AND		S.YD_CD				= 'EGSUZT1'		/* 수에즈 						*/" ).append("\n"); 
		query.append("																							AND		S.LGS_COST_CD		= 'CNTFCT'		/* 운하 통항비(INVOICE)	COST CODE*/" ).append("\n"); 
		query.append("																							AND     S.CRE_DT			<= SYSDATE" ).append("\n"); 
		query.append("																							AND		ROWNUM    			= 1" ).append("\n"); 
		query.append("																						), " ).append("\n"); 
		query.append("																						(	/* 동일 VESSEL CLASS가 가장 최신에 통행했던 정보 조회한다. */" ).append("\n"); 
		query.append("																							SELECT	/*+ INDEX_DESC (S XAK1PSO_CNL_TZ_FEE_DTL) */" ).append("\n"); 
		query.append("																						  			S.ROWID" ).append("\n"); 
		query.append("																							FROM	PSO_CNL_TZ_FEE_DTL S" ).append("\n"); 
		query.append("																							WHERE	1 = 1" ).append("\n"); 
		query.append("																							AND		S.PSO_BZTP_CD		= '5' 			/* 전도금 & Invoice 업무 		*/" ).append("\n"); 
		query.append("																							AND		S.VSL_CD			= (	SELECT	VSL_CD" ).append("\n"); 
		query.append("																															FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("																															WHERE	CNTR_VSL_CLSS_CAPA = (	SELECT	CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("																																							FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("																																							WHERE	VSL_CD = @[vsl_cd])" ).append("\n"); 
		query.append("																															AND		ROWNUM	= 1" ).append("\n"); 
		query.append("																															)" ).append("\n"); 
		query.append("																							AND		S.YD_CD				= 'EGSUZT1'		/* 수에즈 						*/" ).append("\n"); 
		query.append("																							AND		S.LGS_COST_CD		= 'CNTFCT'		/* 운하 통항비(INVOICE) 	COST CODE*/" ).append("\n"); 
		query.append("																							AND     S.CRE_DT			<= SYSDATE" ).append("\n"); 
		query.append("																							AND		ROWNUM    			= 1" ).append("\n"); 
		query.append("																						))" ).append("\n"); 
		query.append("														UNION ALL" ).append("\n"); 
		query.append("														SELECT	/* 동일 VESSEL CLASS로 통항했던 선박 중 INVOICE가 처리된 것 SDR(SUEZ DALLOR) 조회 */" ).append("\n"); 
		query.append("																2, NVL(MAX(LOCL_XCH_RT), 0) AS CUR_SDR, NVL(MAX(T1.SUZ_NET_TONG_WGT), 0) AS SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("														FROM	PSO_CNL_TZ_FEE		T1" ).append("\n"); 
		query.append("																, PSO_CNL_TZ_FEE_DTL	T2		" ).append("\n"); 
		query.append("														WHERE	1	= 1" ).append("\n"); 
		query.append("														AND		T1.PSO_BZTP_CD	= T2.PSO_BZTP_CD" ).append("\n"); 
		query.append("														AND		T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("														AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("														AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("														AND		T1.YD_CD		= T2.YD_CD" ).append("\n"); 
		query.append("														AND		T1.CALL_SEQ		= T2.CALL_SEQ" ).append("\n"); 
		query.append("														AND		T1.CNL_TZ_BZTP_CD		= 'I'		/* INVOICE		*/" ).append("\n"); 
		query.append("														AND		T1.CNL_TZ_PROC_STS_CD	= 'A'		/* 승인된 건	*/" ).append("\n"); 
		query.append("														--AND		T1.VNDR_SEQ		= VNDR_SEQ" ).append("\n"); 
		query.append("														AND		T2.ROWID		=	(" ).append("\n"); 
		query.append("																							SELECT	/*+ INDEX_DESC (S XAK1PSO_CNL_TZ_FEE_DTL) */" ).append("\n"); 
		query.append("																						  			S.ROWID" ).append("\n"); 
		query.append("																							FROM	PSO_CNL_TZ_FEE_DTL S" ).append("\n"); 
		query.append("																							WHERE	1 = 1" ).append("\n"); 
		query.append("																							AND		S.PSO_BZTP_CD		= '5' 			/* 전도금 & Invoice 업무 		*/" ).append("\n"); 
		query.append("																							AND		S.VSL_CD			= (	SELECT	VSL_CD" ).append("\n"); 
		query.append("																															FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("																															WHERE	CNTR_VSL_CLSS_CAPA = (	SELECT	CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("																																							FROM	MDM_VSL_CNTR" ).append("\n"); 
		query.append("																																							WHERE	VSL_CD	= @[vsl_cd])" ).append("\n"); 
		query.append("																															AND		ROWNUM	= 1" ).append("\n"); 
		query.append("																															)" ).append("\n"); 
		query.append("																							AND		S.YD_CD				= 'EGSUZT1'		/* 수에즈 						*/" ).append("\n"); 
		query.append("																							AND		S.LGS_COST_CD		= 'CNTFCT'		/* 운하 통항비(INVOICE)	COST CODE*/" ).append("\n"); 
		query.append("																							AND     S.CRE_DT			<= SYSDATE" ).append("\n"); 
		query.append("																							AND		ROWNUM    			= 1" ).append("\n"); 
		query.append("																						)" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("										) T6" ).append("\n"); 
		query.append("								WHERE	1 = 1" ).append("\n"); 
		query.append("								AND		T1.VSL_CD		= T2.VSL_CD			(+)" ).append("\n"); 
		query.append("								AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO		(+)" ).append("\n"); 
		query.append("								AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("								AND		T1.VPS_PORT_CD	= T2.DEP_PORT_CD	(+)" ).append("\n"); 
		query.append("								AND		T1.CLPT_IND_SEQ	= T2.CLPT_IND_SEQ	(+)" ).append("\n"); 
		query.append("								AND		T1.VSL_CD		= T3.VSL_CD			(+)" ).append("\n"); 
		query.append("								AND		T1.SKD_VOY_NO	= T3.SKD_VOY_NO		(+)" ).append("\n"); 
		query.append("								AND		T1.SKD_DIR_CD	= T3.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("								AND		T1.VSL_CD		= T5.VSL_CD" ).append("\n"); 
		query.append("								AND		T1.SKD_VOY_NO	= T5.SKD_VOY_NO" ).append("\n"); 
		query.append("								AND		T1.SKD_DIR_CD	= T5.SKD_DIR_CD							" ).append("\n"); 
		query.append("								AND		T1.CLPT_SEQ		= T5.CLPT_SEQ	- 2			/* 수에즈 다음 PORT를 의미함.	*/" ).append("\n"); 
		query.append("								AND		T3.ROWID		=" ).append("\n"); 
		query.append("										(	SELECT	/*+ INDEX_DESC (S XPKVSK_NOON_RPT) */" ).append("\n"); 
		query.append("										  			S.ROWID" ).append("\n"); 
		query.append("											FROM	FCM_NOON_RPT S" ).append("\n"); 
		query.append("											WHERE	1 = 1" ).append("\n"); 
		query.append("											AND		T1.VSL_CD		= S.VSL_CD " ).append("\n"); 
		query.append("											AND     T1.SKD_VOY_NO	= S.SKD_VOY_NO" ).append("\n"); 
		query.append("											AND     T1.SKD_DIR_CD	= S.SKD_DIR_CD" ).append("\n"); 
		query.append("											AND		S.NXT_PORT_CD	= 'EGSUZ'" ).append("\n"); 
		query.append("											AND		ROWNUM    		= 1" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("								AND		T4.ROWID		=" ).append("\n"); 
		query.append("										(	/* 가장 최신에 BUNKER를 수급한 DEPARTURE REPORT를 조회한다. */" ).append("\n"); 
		query.append("											SELECT	/*+ INDEX_DESC (S XAK1VSK_DEP_RPT) */" ).append("\n"); 
		query.append("										  			S.ROWID" ).append("\n"); 
		query.append("											FROM	FCM_DEP_RPT S" ).append("\n"); 
		query.append("											WHERE	1 = 1" ).append("\n"); 
		query.append("											AND		S.VSL_CD			= T1.VSL_CD" ).append("\n"); 
		query.append("											AND     S.NXT_PORT_ETA_DT	<= T2.NXT_PORT_ETA_DT" ).append("\n"); 
		query.append("											AND     VSK_REMOVE_NONE_NUMERIC_FNC(NVL(S.SPL_FOIL_ACT_WGT,0)) > 0" ).append("\n"); 
		query.append("											AND		ROWNUM    			= 1" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("								AND		T1.VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("								AND		T1.SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("								AND		T1.SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("								AND		T1.VPS_PORT_CD	= @[vps_port_cd]" ).append("\n"); 
		query.append("								) T11, VSK_PORT_CNL_PASS_COND T12" ).append("\n"); 
		query.append("						WHERE	1 = 1" ).append("\n"); 
		query.append("						AND		T12.LOC_CD			= T11.TO_PORT" ).append("\n"); 
		query.append("						AND		T12.SVC_SCP_BND_CD	= DECODE(T11.SKD_DIR_CD, 'W', 'N', 'E', 'S')" ).append("\n"); 
		query.append("						) T21" ).append("\n"); 
		query.append("				) T31" ).append("\n"); 
		query.append("		) T41, PSO_VSL_CLSS_TRF T42" ).append("\n"); 
		query.append("WHERE	T42.BSE_YR				(+)	= SUBSTR(TO_CHAR(TO_DATE(T41.NXT_PORT_ETA), 'YYYYMMDD'), 1, 4)" ).append("\n"); 
		query.append("AND     T42.BSE_QTR_CD          (+) = TO_CHAR(TO_DATE(T41.NXT_PORT_ETA), 'Q') || 'Q'" ).append("\n"); 
		query.append("AND		T42.YD_CD		        (+)	= 'EGSUZT1'		/* 수에즈 							*/" ).append("\n"); 
		query.append("AND		T42.LGS_COST_CD			(+)	= 'CNTFCT'		/* 운하 통항비(INVOICE)	COST CODE	*/" ).append("\n"); 
		query.append("AND     T42.CNTR_VSL_CLSS_CAPA  (+) = T41.CNTR_VSL_CLSS_CAPA" ).append("\n"); 

	}
}