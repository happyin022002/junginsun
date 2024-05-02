/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCstSkdBerthWdoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.03 
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

public class VesselScheduleMgtDBDAOCstSkdBerthWdoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Port의 Vessel Berth 정보를 조회합니다.
	  * ======================================================================
	  * 2011.04.20 Daily Berth Window 로직 변경
	  * 2015.11.03 Phase Out 된 Port 도 조회 되도록 수정
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCstSkdBerthWdoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCstSkdBerthWdoRSQL").append("\n"); 
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
		query.append("WITH PORT_SKD AS (" ).append("\n"); 
		query.append("                        SELECT     T3.SLAN_CD" ).append("\n"); 
		query.append("                                  , LAG (T5.VSL_SVC_TP_CD) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS PRE_SVC_TP_CD " ).append("\n"); 
		query.append("                                  , T5.VSL_SVC_TP_CD " ).append("\n"); 
		query.append("                                  , LEAD(T5.VSL_SVC_TP_CD) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS NXT_SVC_TP_CD" ).append("\n"); 
		query.append("                                  , LAG (T3.VSL_CD       ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS PRE_VSL_CD  " ).append("\n"); 
		query.append("                                  , LAG (T3.SKD_VOY_NO   ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS PRE_VOY_NO" ).append("\n"); 
		query.append("                                  , LAG (T3.SKD_DIR_CD   ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS PRE_DIR_CD" ).append("\n"); 
		query.append("                                  , LAG (T3.VPS_PORT_CD  ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS PRE_PORT_CD" ).append("\n"); 
		query.append("                                  , LAG (T3.CLPT_SEQ     ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS PRE_CLPT_SEQ" ).append("\n"); 
		query.append("                                  , LAG (T3.VPS_ETD_DT  ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)         AS PRE_VPS_ETD_DT" ).append("\n"); 
		query.append("                                  , T3.VSL_CD" ).append("\n"); 
		query.append("                                  , T3.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  , T3.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  , T4.VSL_SLAN_DIR_SEQ AS DIR_SEQ" ).append("\n"); 
		query.append("                                  , T3.VPS_PORT_CD" ).append("\n"); 
		query.append("                                  , T3.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                  , T3.CLPT_SEQ" ).append("\n"); 
		query.append("                                  , T3.VPS_ETA_DT" ).append("\n"); 
		query.append("                                  , T3.VPS_ETB_DT" ).append("\n"); 
		query.append("                                  , T3.VPS_ETD_DT" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                                  , LEAD(T3.VSL_CD       ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS NXT_VSL_CD" ).append("\n"); 
		query.append("                                  , LEAD(T3.SKD_VOY_NO   ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS NXT_VOY_NO" ).append("\n"); 
		query.append("                                  , LEAD(T3.SKD_DIR_CD   ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS NXT_DIR_CD" ).append("\n"); 
		query.append("                                  , LEAD(T3.VPS_PORT_CD  ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS NXT_PORT_CD" ).append("\n"); 
		query.append("                                  , LEAD(T3.CLPT_SEQ     ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS NXT_CLPT_SEQ" ).append("\n"); 
		query.append("                                  , LEAD(T3.VPS_ETA_DT   ) OVER (PARTITION BY T5.VSL_SVC_TP_CD, T3.VSL_CD ORDER BY T3.VPS_ETB_DT, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ)        AS NXT_VPS_ETA_DT" ).append("\n"); 
		query.append("                        FROM        VSK_VSL_PORT_SKD T3" ).append("\n"); 
		query.append("                                  , MDM_VSL_SVC_LANE_DIR T4" ).append("\n"); 
		query.append("                                  , MDM_VSL_SVC_LANE T5" ).append("\n"); 
		query.append("                        WHERE       1=1" ).append("\n"); 
		query.append("                        AND         T3.SLAN_CD      = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("                        AND         T3.SKD_DIR_CD   = T4.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                        AND         T3.SLAN_CD      = T5.VSL_SLAN_CD" ).append("\n"); 
		query.append("                        AND         T3.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                        AND         NVL(T3.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                        --AND         NVL(T3.SKD_CNG_STS_CD, ' ') <> 'O'" ).append("\n"); 
		query.append("						AND			T3.VPS_ETA_DT BETWEEN	TO_DATE(@[fm_dt], 'YYYY-MM-DD') - 100	AND	TO_DATE(@[to_dt], 'YYYY-MM-DD') + 100" ).append("\n"); 
		query.append("                        ORDER BY    T3.VSL_CD, T3.SKD_VOY_NO, T4.VSL_SLAN_DIR_SEQ, T3.SKD_DIR_CD, T3.CLPT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  T1.SLAN_CD" ).append("\n"); 
		query.append("        , M.PRE_VSL_CD || M.PRE_VOY_NO || M.PRE_DIR_CD AS PRE_VVD" ).append("\n"); 
		query.append("        , M.PRE_PORT_CD" ).append("\n"); 
		query.append("        , M.PRE_VPS_ETD_DT AS PRE_ETD_DT" ).append("\n"); 
		query.append("        , T1.VSL_CD" ).append("\n"); 
		query.append("        , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("		, T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("        , T1.VPS_PORT_CD" ).append("\n"); 
		query.append("        , M.NXT_VSL_CD || M.NXT_VOY_NO || M.NXT_DIR_CD AS NXT_VVD" ).append("\n"); 
		query.append("        , M.NXT_PORT_CD" ).append("\n"); 
		query.append("        , M.NXT_VPS_ETA_DT AS NXT_ETA_DT" ).append("\n"); 
		query.append("        , T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , T1.CLPT_SEQ" ).append("\n"); 
		query.append("        , T1.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("        , T1.YD_CD" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("			SELECT YD_NM FROM MDM_YARD" ).append("\n"); 
		query.append("			 WHERE LOC_CD = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("			   AND YD_CD = T1.YD_CD" ).append("\n"); 
		query.append("	     ) AS YD_NM" ).append("\n"); 
		query.append("        , T1.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("        , TO_CHAR(T1.PF_ETA_DT, 'YYYYMMDDHH24MI') AS PF_ETA_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.PF_ETB_DT, 'YYYYMMDDHH24MI') AS PF_ETB_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.PF_ETD_DT, 'YYYYMMDDHH24MI') AS PF_ETD_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.INIT_ETA_DT, 'YYYYMMDDHH24MI') AS INIT_ETA_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.INIT_ETB_DT, 'YYYYMMDDHH24MI') AS INIT_ETB_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.INIT_ETD_DT, 'YYYYMMDDHH24MI') AS INIT_ETD_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.VPS_ETA_DT, 'YYYYMMDDHH24MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.VPS_ETB_DT, 'YYYYMMDDHH24MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("        , T1.VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("        , T1.VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append("        , T1.VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append("        , T1.SHP_CALL_NO" ).append("\n"); 
		query.append("        , T1.SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append("        , T1.SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append("        , T1.TML_VSL_CD" ).append("\n"); 
		query.append("        , T1.TML_VOY_NO" ).append("\n"); 
		query.append("        , TO_CHAR(T1.FT_DT, 'YYYYMMDDHH24MI') AS FT_DT" ).append("\n"); 
		query.append("		, NVL(TO_CHAR(T1.FT_DT, 'YYYYMMDDHH24MI'),  DECODE(SUBSTR(T1.VPS_PORT_CD, 1, 2), 'KR', TO_CHAR((T1.VPS_ETB_DT - 5), 'YYYYMMDDHH24MI'), NULL)) AS FREE_TM_DT" ).append("\n"); 
		query.append("        , T1.PLISM_YD_CD" ).append("\n"); 
		query.append("        , T1.PLISM_VSL_CD" ).append("\n"); 
		query.append("        , T1.PLISM_VOY_NO" ).append("\n"); 
		query.append("		, T1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("        , T1.TURN_PORT_FLG" ).append("\n"); 
		query.append("        , T1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("        , T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("        , T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("        , T1.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , T1.IB_CGO_QTY" ).append("\n"); 
		query.append("        , T1.OB_CGO_QTY" ).append("\n"); 
		query.append("		, NVL(T1.IB_CGO_QTY, 0) + NVL(T1.OB_CGO_QTY, 0) AS CGO_TTL" ).append("\n"); 
		query.append("        , T1.VPS_RMK" ).append("\n"); 
		query.append("        , RTRIM(REPLACE(T1.VPS_RMK, CHR(13)||CHR(10),' ')) AS WIN_RMK 	/* 화면 조회 용 */" ).append("\n"); 
		query.append("        , T1.PHS_IO_RSN_CD" ).append("\n"); 
		query.append("        , T1.PHS_IO_RMK" ).append("\n"); 
		query.append("        , T1.SKD_BRTH_NO" ).append("\n"); 
		query.append("        , T1.INIT_SKD_INP_FLG" ).append("\n"); 
		query.append("        , T1.OFC_INP_FLG" ).append("\n"); 
		query.append("        , T1.NOON_RPT_INP_FLG" ).append("\n"); 
		query.append("        , T1.DEP_RPT_INP_FLG" ).append("\n"); 
		query.append("        , T1.ACT_INP_FLG" ).append("\n"); 
		query.append("        , T1.PRT_CHK_FLG" ).append("\n"); 
		query.append("        , T1.CRE_USR_ID" ).append("\n"); 
		query.append("        , TO_CHAR(T1.CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("        , T1.UPD_USR_ID" ).append("\n"); 
		query.append("        , TO_CHAR(T1.UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T1.UPD_DT, 'YYYYMMDDHH24MI') AS UPD_DT_TXT" ).append("\n"); 
		query.append("        , T1.EDI_SND_KNT" ).append("\n"); 
		query.append("        , T1.PORT_SKP_TP_CD" ).append("\n"); 
		query.append("        , T1.PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("        , T1.PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append("        , T1.TTL_DLAY_HRS" ).append("\n"); 
		query.append("        , T1.TS_PORT_CD" ).append("\n"); 
		query.append("        , T1.USD_FLG" ).append("\n"); 
		query.append("        , NVL(T1.LNK_SPD, 0) AS LNK_SPD" ).append("\n"); 
		query.append("		, NVL(T1.SEA_BUF_HRS, 0) AS SEA_BUF_HRS" ).append("\n"); 
		query.append("		, NVL(T1.PORT_BUF_HRS, 0) AS PORT_BUF_HRS" ).append("\n"); 
		query.append("		, NVL(T1.TZTM_HRS, 0) AS TZTM_HRS" ).append("\n"); 
		query.append("		, NVL(T1.PORT_WRK_HRS, 0) AS ACT_WRK_HRS" ).append("\n"); 
		query.append("		, NVL(T1.LNK_DIST, 0) AS LNK_DIST" ).append("\n"); 
		query.append("		, NVL(T1.MNVR_OUT_HRS, 0) AS MNVR_OUT_HRS" ).append("\n"); 
		query.append("		, NVL(T1.MNVR_IN_HRS, 0) AS MNVR_IN_HRS" ).append("\n"); 
		query.append("		, T2.VSL_SVC_TP_CD" ).append("\n"); 
		query.append("		, '' AS LANE_GRP" ).append("\n"); 
		query.append("		, '' AS LANE_GRP_NM" ).append("\n"); 
		query.append("		, '' AS USR_ID" ).append("\n"); 
		query.append("		, '' AS FM_DT" ).append("\n"); 
		query.append("		, '' AS TO_DT" ).append("\n"); 
		query.append("		, '' AS EXT_MSG_FLG" ).append("\n"); 
		query.append("		, '' AS USR_INFO" ).append("\n"); 
		query.append("		, '' AS PORT_POS" ).append("\n"); 
		query.append("		, '' AS HEADER_SEQ" ).append("\n"); 
		query.append("		, '' AS DIFF_RMK" ).append("\n"); 
		query.append("		, '' AS USR_NM" ).append("\n"); 
		query.append("		, '' AS MPHN_NO" ).append("\n"); 
		query.append("		, '' AS FAX_NO" ).append("\n"); 
		query.append("		, '' AS USR_EML" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("			SELECT  UQ_VSL_ID_NO" ).append("\n"); 
		query.append("			FROM    BKG_VSL_DCHG_YD" ).append("\n"); 
		query.append("			WHERE   VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("			AND     SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND     SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND     PORT_CD = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("			AND     CLPT_IND_SEQ = T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			AND		ROWNUM = 1" ).append("\n"); 
		query.append("		  ) AS UQ_VSL_ID_NO" ).append("\n"); 
		query.append("	   	, (" ).append("\n"); 
		query.append("			SELECT  'X'" ).append("\n"); 
		query.append("			FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("			WHERE   VSL_CD           = T1.VSL_CD" ).append("\n"); 
		query.append("			AND     SKD_VOY_NO       = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND     SKD_DIR_CD       = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND     CLPT_SEQ         > T1.CLPT_SEQ" ).append("\n"); 
		query.append("			AND     ACT_INP_FLG = 'Y'" ).append("\n"); 
		query.append("			AND     ROWNUM = 1" ).append("\n"); 
		query.append("	   	  ) AS BFR_ACT_FLG" ).append("\n"); 
		query.append("        , DECODE(TO_CHAR(T1.PF_ETA_DT, 'D'), 1, 'SUN', 2, 'MON', 3, 'TUE', 4, 'WED', 5, 'THU', 6, 'FRI', 7, 'SAT')  AS PF_ETA_DY" ).append("\n"); 
		query.append("        , DECODE(TO_CHAR(T1.PF_ETB_DT, 'D'), 1, 'SUN', 2, 'MON', 3, 'TUE', 4, 'WED', 5, 'THU', 6, 'FRI', 7, 'SAT')  AS PF_ETB_DY" ).append("\n"); 
		query.append("        , DECODE(TO_CHAR(T1.PF_ETD_DT, 'D'), 1, 'SUN', 2, 'MON', 3, 'TUE', 4, 'WED', 5, 'THU', 6, 'FRI', 7, 'SAT')  AS PF_ETD_DY" ).append("\n"); 
		query.append("        , (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = T1.VSL_CD) AS VSL_ENG_NM" ).append("\n"); 
		query.append("		, COUNT(*) OVER() TOTAL_CNT" ).append("\n"); 
		query.append("		, ROW_NUMBER() OVER(ORDER BY T1.SLAN_CD, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD) RNUM" ).append("\n"); 
		query.append("		, (SELECT SKD_CNG_STS_CD FROM VSK_VSL_PORT_SKD WHERE VSL_CD=T1.VSL_CD AND SKD_VOY_NO=T1.SKD_VOY_NO AND SKD_DIR_CD=T1.SKD_DIR_CD AND CLPT_SEQ ='1') AS FIRST_SKIP_FLG" ).append("\n"); 
		query.append("		, (SELECT MAX(CLPT_SEQ) FROM VSK_VSL_PORT_SKD WHERE VSL_CD=T1.VSL_CD AND SKD_VOY_NO=T1.SKD_VOY_NO AND SKD_DIR_CD=T1.SKD_DIR_CD AND TURN_PORT_IND_CD NOT IN ('V', 'D', 'F')) AS MAX_SEQ" ).append("\n"); 
		query.append("		, (SELECT SKD_CNG_STS_CD FROM VSK_VSL_PORT_SKD WHERE VSL_CD=T1.VSL_CD AND SKD_VOY_NO=T1.SKD_VOY_NO AND SKD_DIR_CD=T1.SKD_DIR_CD AND CLPT_SEQ " ).append("\n"); 
		query.append("		   = (SELECT MAX(CLPT_SEQ) FROM VSK_VSL_PORT_SKD WHERE VSL_CD=T1.VSL_CD AND SKD_VOY_NO=T1.SKD_VOY_NO AND SKD_DIR_CD=T1.SKD_DIR_CD AND TURN_PORT_IND_CD NOT IN ('V', 'D', 'F'))) AS LAST_SKIP_FLG" ).append("\n"); 
		query.append("  FROM  VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("		, (SELECT * FROM MDM_VSL_SVC_LANE WHERE DELT_FLG = 'N' AND VSL_TP_CD = 'C') T2" ).append("\n"); 
		query.append("		, PORT_SKD M" ).append("\n"); 
		query.append("         WHERE	1 = 1" ).append("\n"); 
		query.append("           AND  (T1.SKD_CNG_STS_CD IS NULL OR T1.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("           AND  T1.TURN_PORT_IND_CD NOT IN ('V', 'D', 'F')" ).append("\n"); 
		query.append("           AND	T1.SLAN_CD          = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("		   AND     M.VSL_CD        = T1.VSL_CD (+)" ).append("\n"); 
		query.append("		   AND     M.SKD_VOY_NO    = T1.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("		   AND     M.SKD_DIR_CD    = T1.SKD_DIR_CD   (+)" ).append("\n"); 
		query.append("		   AND     M.VPS_PORT_CD   = T1.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("		   AND     M.CLPT_IND_SEQ  = T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		   AND     M.CLPT_SEQ      = T1.CLPT_SEQ" ).append("\n"); 
		query.append("        #if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("           AND	T1.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_dir_cd} != '' && ${skd_dir_cd} != 'ALL')" ).append("\n"); 
		query.append("           AND	T1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${yd_cd} != '') " ).append("\n"); 
		query.append("           AND	T1.YD_CD IN (" ).append("\n"); 
		query.append("        	#foreach( $key IN ${yd_cd}) " ).append("\n"); 
		query.append("        		#if($velocityCount < $yd_cd.size())" ).append("\n"); 
		query.append("          		'$key'," ).append("\n"); 
		query.append("        		#else" ).append("\n"); 
		query.append("        		'$key'" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        		) " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${lane_grp} == 'L')" ).append("\n"); 
		query.append("        	#if (${slan_cd} != '')" ).append("\n"); 
		query.append("           AND	T1.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #elseif (${lane_grp} == 'G')" ).append("\n"); 
		query.append("           AND	T1.SLAN_CD IN (" ).append("\n"); 
		query.append("        						SELECT VSL_SLAN_CD " ).append("\n"); 
		query.append("        						FROM VSK_USR_LANE_GRP" ).append("\n"); 
		query.append("        						WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("        						AND LANE_GRP_NM = @[lane_grp_nm]" ).append("\n"); 
		query.append("        					   )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           AND	T1.VPS_ETB_DT BETWEEN	TO_DATE(@[fm_dt], 'YYYY-MM-DD')	AND	TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("        #if (${vsl_svc_tp_cd} == 'O')" ).append("\n"); 
		query.append("           AND  T2.VSL_SVC_TP_CD 		= 'O'" ).append("\n"); 
		query.append("        #elseif (${vsl_svc_tp_cd} == 'T') " ).append("\n"); 
		query.append("           AND  T2.VSL_SVC_TP_CD 		!= 'O'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        -- ORDER BY T1.SLAN_CD, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND RNUM BETWEEN (@[page_no]-1)*@[pagerows]+1 AND @[page_no]*@[pagerows]" ).append("\n"); 

	}
}