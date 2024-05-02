/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCstSkdByPfSkdSimRSQL.java
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

public class VesselScheduleMgtDBDAOSearchCstSkdByPfSkdSimRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proforma Schedule 을 조회합니다.
	  * 
	  * History
	  * 2012.10.24 CHM-201220527-01 진마리아 Departure/Noon Report 데이터를 FCM 데이터와 I/F하도록 변경 요청
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCstSkdByPfSkdSimRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pf_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCstSkdByPfSkdSimRSQL").append("\n"); 
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
		query.append("SELECT @[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append("       , @[skd_voy_no] AS SKD_VOY_NO" ).append("\n"); 
		query.append("       , SKD_DIR_CD" ).append("\n"); 
		query.append("       , @[vsl_cd] || @[skd_voy_no] || SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("       , T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("       , 'ACT' AS SKD_STS_CD" ).append("\n"); 
		query.append("       , '' AS SKD_VOY_TP_CD" ).append("\n"); 
		query.append("	   , '' AS SKD_USD_IND_CD" ).append("\n"); 
		query.append("       , T2.PF_SVC_TP_CD AS PF_SKD_TP_CD" ).append("\n"); 
		query.append("	   , (" ).append("\n"); 
		query.append("	       SELECT  PORT_CD " ).append("\n"); 
		query.append("	       FROM    VSK_PF_SKD_DTL " ).append("\n"); 
		query.append("	       WHERE   VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("           AND     PF_SVC_TP_CD    = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("           AND     SKD_DIR_CD      = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND     PORT_ROTN_SEQ   = (" ).append("\n"); 
		query.append("                                        SELECT  MIN(PORT_ROTN_SEQ)" ).append("\n"); 
		query.append("                                        FROM    VSK_PF_SKD_DTL " ).append("\n"); 
		query.append("                                        WHERE   VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("                                        AND     PF_SVC_TP_CD    = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("                                        AND     SKD_DIR_CD      = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("	     ) AS ST_PORT_CD" ).append("\n"); 
		query.append("	   , '' AS N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("       , '' AS PSDO_VVD_CD" ).append("\n"); 
		query.append("       , '' AS CO_CD" ).append("\n"); 
		query.append("       , '' AS SKD_RMK" ).append("\n"); 
		query.append("       , '' AS CRE_USR_ID" ).append("\n"); 
		query.append("       , '' AS CRE_DT" ).append("\n"); 
		query.append("       , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("       , '' AS UPD_DT" ).append("\n"); 
		query.append("       , T2.PORT_CD AS VPS_PORT_CD" ).append("\n"); 
		query.append("       , '' AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("       , '' AS CLPT_SEQ" ).append("\n"); 
		query.append("	   , T2.VSL_SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append("       , '' AS PORT_SKD_STS_CD" ).append("\n"); 
		query.append("       , YD_CD" ).append("\n"); 
		query.append("       , DECODE(YD_CD, NULL, '', SUBSTR(YD_CD, 6, 2)) AS TML_CD" ).append("\n"); 
		query.append("       , '' AS CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("#if (${pf_etb_dt} != '') " ).append("\n"); 
		query.append("       , TO_CHAR(TO_DATE(TO_CHAR(TO_DATE(SUBSTR(@[pf_etb_dt], 1, 8), 'YYYYMMDD') + (ETB_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETB_TM_HRMNT, 'YYYYMMDD HH24:MI') - NUMTODSINTERVAL(MNVR_IN_HRS,'HOUR'), 'YYYYMMDDHH24MI') AS PF_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(TO_DATE(TO_CHAR(TO_DATE(SUBSTR(@[pf_etb_dt], 1, 8), 'YYYYMMDD') + (ETB_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETB_TM_HRMNT, 'YYYYMMDD HH24:MI'), 'YYYYMMDDHH24MI') AS PF_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(TO_DATE(TO_CHAR(TO_DATE(SUBSTR(@[pf_etb_dt], 1, 8), 'YYYYMMDD') + (ETB_DY_NO - FIRST_VALUE(ETB_DY_NO) OVER (ORDER BY PORT_ROTN_SEQ)), 'YYYYMMDD') || ETD_TM_HRMNT, 'YYYYMMDD HH24:MI'), 'YYYYMMDDHH24MI') AS PF_ETD_DT" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("       , '' AS PF_ETA_DT" ).append("\n"); 
		query.append("       , '' AS PF_ETB_DT" ).append("\n"); 
		query.append("       , '' AS PF_ETD_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       , TO_CHAR(T1.START_DATE + (TO_DATE(TO_CHAR(SYSDATE + T2.ETB_DY_NO, 'YYYYMMDD') || T2.ETB_TM_HRMNT, 'YYYYMMDDHH24MI') - TO_DATE(TO_CHAR(SYSDATE + T1.CUR_ETB_DY_NO, 'YYYYMMDD') || T1.CUR_ETB_TM_HRMNT, 'YYYYMMDDHH24MI')) - NUMTODSINTERVAL(MNVR_IN_HRS,'HOUR'), 'YYYYMMDDHH24MI') AS INIT_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.START_DATE + (TO_DATE(TO_CHAR(SYSDATE + T2.ETB_DY_NO, 'YYYYMMDD') || T2.ETB_TM_HRMNT, 'YYYYMMDDHH24MI') - TO_DATE(TO_CHAR(SYSDATE + T1.CUR_ETB_DY_NO, 'YYYYMMDD') || T1.CUR_ETB_TM_HRMNT, 'YYYYMMDDHH24MI')), 'YYYYMMDDHH24MI') AS INIT_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.START_DATE + (TO_DATE(TO_CHAR(SYSDATE + T2.ETD_DY_NO, 'YYYYMMDD') || T2.ETD_TM_HRMNT, 'YYYYMMDDHH24MI') - TO_DATE(TO_CHAR(SYSDATE + T1.CUR_ETB_DY_NO, 'YYYYMMDD') || T1.CUR_ETB_TM_HRMNT, 'YYYYMMDDHH24MI')), 'YYYYMMDDHH24MI') AS INIT_ETD_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.START_DATE + (TO_DATE(TO_CHAR(SYSDATE + T2.ETB_DY_NO, 'YYYYMMDD') || T2.ETB_TM_HRMNT, 'YYYYMMDDHH24MI') - TO_DATE(TO_CHAR(SYSDATE + T1.CUR_ETB_DY_NO, 'YYYYMMDD') || T1.CUR_ETB_TM_HRMNT, 'YYYYMMDDHH24MI')) - NUMTODSINTERVAL(MNVR_IN_HRS,'HOUR'), 'YYYYMMDDHH24MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.START_DATE + (TO_DATE(TO_CHAR(SYSDATE + T2.ETB_DY_NO, 'YYYYMMDD') || T2.ETB_TM_HRMNT, 'YYYYMMDDHH24MI') - TO_DATE(TO_CHAR(SYSDATE + T1.CUR_ETB_DY_NO, 'YYYYMMDD') || T1.CUR_ETB_TM_HRMNT, 'YYYYMMDDHH24MI')), 'YYYYMMDDHH24MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(T1.START_DATE + (TO_DATE(TO_CHAR(SYSDATE + T2.ETD_DY_NO, 'YYYYMMDD') || T2.ETD_TM_HRMNT, 'YYYYMMDDHH24MI') - TO_DATE(TO_CHAR(SYSDATE + T1.CUR_ETB_DY_NO, 'YYYYMMDD') || T1.CUR_ETB_TM_HRMNT, 'YYYYMMDDHH24MI')), 'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("       , '' AS VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("       , '' AS VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append("       , '' AS VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append("       , '' AS SHP_CALL_NO" ).append("\n"); 
		query.append("       , '' AS SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append("       , TURN_PORT_FLG" ).append("\n"); 
		query.append("       , TURN_PORT_FLG AS TURN_PORT_IND_CD" ).append("\n"); 
		query.append("       , LNK_DIST" ).append("\n"); 
		query.append("       , LNK_SPD" ).append("\n"); 
		query.append("       , TZTM_HRS" ).append("\n"); 
		query.append("       , MNVR_IN_HRS" ).append("\n"); 
		query.append("       , MNVR_OUT_HRS" ).append("\n"); 
		query.append("       , CRN_KNT" ).append("\n"); 
		query.append("       , TML_PROD_QTY" ).append("\n"); 
		query.append("       , ACT_WRK_HRS" ).append("\n"); 
		query.append("       , NVL(PORT_BUF_HRS, 0) AS PORT_BUF_HRS" ).append("\n"); 
		query.append("       , NVL(SEA_BUF_HRS, 0) AS SEA_BUF_HRS" ).append("\n"); 
		query.append("       , PORT_ROTN_SEQ" ).append("\n"); 
		query.append("       , ETB_DY_CD" ).append("\n"); 
		query.append("       , ETB_DY_NO" ).append("\n"); 
		query.append("       , ETB_TM_HRMNT" ).append("\n"); 
		query.append("       , ETD_DY_CD" ).append("\n"); 
		query.append("       , ETD_DY_NO" ).append("\n"); 
		query.append("       , ETD_TM_HRMNT" ).append("\n"); 
		query.append("       , LNK_SPD AS PF_SPD" ).append("\n"); 
		query.append("       , SEA_BUF_SPD" ).append("\n"); 
		query.append("       , IB_IPCGO_QTY" ).append("\n"); 
		query.append("       , IB_OCN_CGO_QTY" ).append("\n"); 
		query.append("       , OB_IPCGO_QTY" ).append("\n"); 
		query.append("       , OB_OCN_CGO_QTY" ).append("\n"); 
		query.append("       , T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("			SELECT  ROUND((FOC_HR / POWER(SPD_P, 3)) * POWER((T2.LNK_SPD / (1 - (SLIP / 100))), 3) * 24, 1)" ).append("\n"); 
		query.append("			FROM    (" ).append("\n"); 
		query.append("						SELECT  T11.*," ).append("\n"); 
		query.append("								ROUND(((SPD_P - SPD_O)/SPD_P) * 100, 1)   AS SLIP," ).append("\n"); 
		query.append("								ROUND(BUNK_CONS / (DIST_O / SPD_O), 2)  AS FOC_HR" ).append("\n"); 
		query.append("						FROM    (" ).append("\n"); 
		query.append("									SELECT  /*+INDEX_DESC(T XPKVSK_NOON_RPT) */" ).append("\n"); 
		query.append("											NXT_PORT_CD     AS NXT_PORT_CD," ).append("\n"); 
		query.append("											NXT_PORT_ETA_DT AS NXT_PORT_ETA_DT," ).append("\n"); 
		query.append("											NVGT_ML_DIST       AS DIST_O," ).append("\n"); 
		query.append("											ENG_ML_DIST     AS DIST_P," ).append("\n"); 
		query.append("											SAIL_AVG_SPD    AS SPD_O," ).append("\n"); 
		query.append("											ROUND(ENG_ML_DIST / (NVGT_ML_DIST / SAIL_AVG_SPD),1) AS SPD_P," ).append("\n"); 
		query.append("											ROUND(VSK_REMOVE_NONE_NUMERIC_FNC(MN_FOIL_CSM_QTY))    AS BUNK_CONS" ).append("\n"); 
		query.append("									FROM    FCM_NOON_RPT T" ).append("\n"); 
		query.append("									WHERE   VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("									AND     ROWNUM      = 1" ).append("\n"); 
		query.append("								) T11" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("        ) AS BNK_UNIT_QTY" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT  ACT_PRC" ).append("\n"); 
		query.append("            FROM    VSK_BNK_PRC T11," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                        SELECT  MAX(TO_CHAR(VPS_ETB_DT, 'YYYYMMDD') || DEP_PORT_CD ) CURR_PORT" ).append("\n"); 
		query.append("                        FROM    FCM_DEP_RPT" ).append("\n"); 
		query.append("                        WHERE   VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND     VSK_REMOVE_NONE_NUMERIC_FNC(NVL(SPL_FOIL_ACT_WGT,0)) > 0" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("            WHERE   1 = 1" ).append("\n"); 
		query.append("            AND     PORT_CD             = SUBSTR(CURR_PORT, 9)" ).append("\n"); 
		query.append("            AND     FOIL_DOIL_DIV_CD    = 'F'" ).append("\n"); 
		query.append("            AND     EVNT_DT             = TO_DATE(SUBSTR(CURR_PORT, 1, 8), 'YYYYMMDD')" ).append("\n"); 
		query.append("        ) AS BNK_UNIT_AMT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT  SUM(TTL_CHG_AMT)" ).append("\n"); 
		query.append("			FROM    PSO_VSL_CLSS_TRF" ).append("\n"); 
		query.append("			WHERE   BSE_YR      = TO_CHAR(T1.START_DATE + (TO_DATE(TO_CHAR(SYSDATE + T2.ETB_DY_NO, 'YYYYMMDD') || T2.ETB_TM_HRMNT, 'YYYYMMDDHH24MI') - TO_DATE(TO_CHAR(SYSDATE + T1.CUR_ETB_DY_NO, 'YYYYMMDD') || T1.CUR_ETB_TM_HRMNT, 'YYYYMMDDHH24MI')) - NUMTODSINTERVAL(T2.MNVR_IN_HRS,'HOUR'), 'YYYY')" ).append("\n"); 
		query.append("			AND     BSE_QTR_CD  = TO_CHAR(T1.START_DATE + (TO_DATE(TO_CHAR(SYSDATE + T2.ETB_DY_NO, 'YYYYMMDD') || T2.ETB_TM_HRMNT, 'YYYYMMDDHH24MI') - TO_DATE(TO_CHAR(SYSDATE + T1.CUR_ETB_DY_NO, 'YYYYMMDD') || T1.CUR_ETB_TM_HRMNT, 'YYYYMMDDHH24MI')) - NUMTODSINTERVAL(T2.MNVR_IN_HRS,'HOUR'), 'Q') || 'Q'" ).append("\n"); 
		query.append("			AND     YD_CD       = T2.YD_CD" ).append("\n"); 
		query.append("			AND     CNTR_VSL_CLSS_CAPA = " ).append("\n"); 
		query.append("			        (" ).append("\n"); 
		query.append("			            SELECT  CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("			            FROM    MDM_VSL_CNTR" ).append("\n"); 
		query.append("			            WHERE   VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("			            AND     DELT_FLG    = 'N'" ).append("\n"); 
		query.append("			        )" ).append("\n"); 
		query.append("        ) AS PE_USD_TTL_AMT" ).append("\n"); 
		query.append("FROM	(	/* FROM - TO 에 의해 START DATE를 생성한다. */" ).append("\n"); 
		query.append("			SELECT	VSL_SLAN_CD, PF_SVC_TP_CD, CUR_PORT_ROTN_SEQ" ).append("\n"); 
		query.append("					, TO_DATE(@[vps_etd_dt], 'YYYYMMDDHH24MI') +" ).append("\n"); 
		query.append("						(TO_DATE(TO_CHAR(SYSDATE + CUR_ETB_DY_NO, 'YYYYMMDD') || CUR_ETB_TM_HRMNT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("						- TO_DATE(TO_CHAR(SYSDATE + ETD_DY_NO, 'YYYYMMDD') || ETD_TM_HRMNT, 'YYYYMMDDHH24MI')) AS START_DATE" ).append("\n"); 
		query.append("					, CUR_ETB_DY_NO, CUR_ETB_TM_HRMNT" ).append("\n"); 
		query.append("			FROM	(" ).append("\n"); 
		query.append("						SELECT	/* Phase Out Port에 ETD와 Next Port에 ETB 를 조회한다. */" ).append("\n"); 
		query.append("								ROW_NUMBER() OVER (ORDER BY PORT_ROTN_SEQ) AS NO" ).append("\n"); 
		query.append("								, PORT_ROTN_SEQ, ETB_DY_NO, ETB_TM_HRMNT, ETD_DY_NO, ETD_TM_HRMNT" ).append("\n"); 
		query.append("								, LAST_VALUE(ETB_DY_NO		) OVER ( ) AS CUR_ETB_DY_NO" ).append("\n"); 
		query.append("								, LAST_VALUE(ETB_TM_HRMNT	) OVER ( ) AS CUR_ETB_TM_HRMNT" ).append("\n"); 
		query.append("								, LAST_VALUE(PORT_ROTN_SEQ	) OVER ( ) AS CUR_PORT_ROTN_SEQ" ).append("\n"); 
		query.append("								, VSL_SLAN_CD, PF_SVC_TP_CD" ).append("\n"); 
		query.append("						FROM	VSK_PF_SKD_DTL T1" ).append("\n"); 
		query.append("						WHERE	PORT_ROTN_SEQ	>= (	/* Phase Out Cancel된 Port Seq를 조회한다. */" ).append("\n"); 
		query.append("										SELECT	S.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("										FROM	VSK_PF_SKD_DTL S" ).append("\n"); 
		query.append("										WHERE 	S.VSL_SLAN_CD	= T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("										AND		S.PF_SVC_TP_CD	= T1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("										AND		S.SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("										AND		S.PORT_CD		= @[vps_port_cd]" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						AND		T1.VSL_SLAN_CD		= @[vsl_slan_cd]" ).append("\n"); 
		query.append("						AND		T1.PF_SVC_TP_CD		= @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("						AND		T1.TURN_PORT_IND_CD	!= 'F'" ).append("\n"); 
		query.append("						AND		ROWNUM				<= 2" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			WHERE	NO	= 1					" ).append("\n"); 
		query.append("		) T1, VSK_PF_SKD_DTL T2" ).append("\n"); 
		query.append("WHERE	1					= 1" ).append("\n"); 
		query.append("AND		T1.VSL_SLAN_CD		= T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND		T1.PF_SVC_TP_CD		= T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("AND		T2.PORT_ROTN_SEQ	>= CUR_PORT_ROTN_SEQ" ).append("\n"); 
		query.append("AND		T2.TURN_PORT_IND_CD != 'F'" ).append("\n"); 
		query.append("ORDER BY T2.PORT_ROTN_SEQ" ).append("\n"); 

	}
}