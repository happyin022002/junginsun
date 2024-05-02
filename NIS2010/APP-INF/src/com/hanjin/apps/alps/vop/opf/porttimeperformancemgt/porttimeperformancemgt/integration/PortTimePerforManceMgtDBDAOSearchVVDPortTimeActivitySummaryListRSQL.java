/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PortTimePerforManceMgtDBDAOSearchVVDPortTimeActivitySummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerforManceMgtDBDAOSearchVVDPortTimeActivitySummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD별 Port Time Activity의 입력 현황 정보를 조회 한다.
	  * History------------------------------------------------------------------------------------
	  * 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
	  * 2012.05.04 조경완 [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건
	  * 2012.07.30 김상근 [CHM-201219138] Port Time Activity Report by VVD 의 항목 계산수식 변경
	  * 2015.08.17 김기원 CHM-201537021  조직코드 변경
	  * 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가
	  * </pre>
	  */
	public PortTimePerforManceMgtDBDAOSearchVVDPortTimeActivitySummaryListRSQL(){
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
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerforManceMgtDBDAOSearchVVDPortTimeActivitySummaryListRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN (GROUPING_VVD = 1 AND GROUPING_SLAN_CD = 1) THEN 'G.Avg' ELSE RHQ END AS RHQ " ).append("\n"); 
		query.append("     , YD_CD " ).append("\n"); 
		query.append("     , SLAN_CD " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1 AND GROUPING_SLAN_CD = 0) THEN 'S.Avg' WHEN (GROUPING_VVD = 1 AND GROUPING_SLAN_CD = 0) THEN NULL ELSE VVD END AS VVD " ).append("\n"); 
		query.append("     , CLPT_IND_SEQ " ).append("\n"); 
		query.append("     , TDR_MVS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1 OR GROUPING_SLAN_CD = 1) THEN NULL ELSE TO_CHAR(DRIFTING_START_BBO,'YYYY-MM-DD HH24:MI') END AS DRIFTING_START_BBO     " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(DRIFTING_END_BBO), -1, '-' || TO_CHAR(CEIL(DRIFTING_END_BBO * 24)), TO_CHAR(FLOOR(DRIFTING_END_BBO * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(DRIFTING_END_BBO * 24 * 60, 60))), '00')) ELSE DECODE(PTA0021_CHK, 'N', '', REPLACE(DECODE(SIGN(DRIFTING_END_BBO), -1, '-' || TO_CHAR(CEIL(DRIFTING_END_BBO * 24)), TO_CHAR(FLOOR(DRIFTING_END_BBO * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(DRIFTING_END_BBO * 24 * 60, 60))), '00'))) END AS DRIFTING_END_BBO " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1 OR GROUPING_SLAN_CD = 1) THEN NULL ELSE TO_CHAR(ANCHOR_DROP_VMS,'YYYY-MM-DD HH24:MI') END AS ANCHOR_DROP_VMS     " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(ANCHOR_AWAY_VMS), -1, '-' || TO_CHAR(CEIL(ANCHOR_AWAY_VMS * 24)), TO_CHAR(FLOOR(ANCHOR_AWAY_VMS * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(ANCHOR_AWAY_VMS * 24 * 60, 60))), '00')) ELSE DECODE(PTA0023_CHK, 'N', '', REPLACE(DECODE(SIGN(ANCHOR_AWAY_VMS), -1, '-' || TO_CHAR(CEIL(ANCHOR_AWAY_VMS * 24)), TO_CHAR(FLOOR(ANCHOR_AWAY_VMS * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(ANCHOR_AWAY_VMS * 24 * 60, 60))), '00'))) END AS ANCHOR_AWAY_VMS " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1 OR GROUPING_SLAN_CD = 1) THEN NULL ELSE TO_CHAR(ANCHOR_DROP_BBO,'YYYY-MM-DD HH24:MI') END AS ANCHOR_DROP_BBO     " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(ANCHOR_AWAY_BBO), -1, '-' || TO_CHAR(CEIL(ANCHOR_AWAY_BBO * 24)), TO_CHAR(FLOOR(ANCHOR_AWAY_BBO * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(ANCHOR_AWAY_BBO * 24 * 60, 60))), '00')) ELSE DECODE(PTA0025_CHK, 'N', '', REPLACE(DECODE(SIGN(ANCHOR_AWAY_BBO), -1, '-' || TO_CHAR(CEIL(ANCHOR_AWAY_BBO * 24)), TO_CHAR(FLOOR(ANCHOR_AWAY_BBO * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(ANCHOR_AWAY_BBO * 24 * 60, 60))), '00'))) END AS ANCHOR_AWAY_BBO " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(PILOT_ON_BOARD_ARR), -1, '-' || TO_CHAR(CEIL(PILOT_ON_BOARD_ARR * 24)), TO_CHAR(FLOOR(PILOT_ON_BOARD_ARR * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(PILOT_ON_BOARD_ARR * 24 * 60, 60))), '00')) ELSE DECODE(PTA0001_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(PILOT_ON_BOARD_ARR), -1, '-' || TO_CHAR(CEIL(PILOT_ON_BOARD_ARR * 24)), TO_CHAR(FLOOR(PILOT_ON_BOARD_ARR * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(PILOT_ON_BOARD_ARR * 24 * 60, 60))), '00'))) END AS PILOT_ON_BOARD_ARR " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN NULL ELSE PILOT_ON_BOARD_ARR_RMK END AS PILOT_ON_BOARD_ARR_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(SAILING_IN), -1, '-' || TO_CHAR(CEIL(SAILING_IN * 24)), TO_CHAR(FLOOR(SAILING_IN * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(SAILING_IN * 24 * 60, 60))), '00')) ELSE DECODE(PTA0002_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(SAILING_IN), -1, '-' || TO_CHAR(CEIL(SAILING_IN * 24)), TO_CHAR(FLOOR(SAILING_IN * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(SAILING_IN * 24 * 60, 60))), '00'))) END AS SAILING_IN " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN NULL ELSE SAILING_IN_RMK END AS SAILING_IN_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(MOORING_ALL_LINES_FAST), -1, '-' || TO_CHAR(CEIL(MOORING_ALL_LINES_FAST * 24)), TO_CHAR(FLOOR(MOORING_ALL_LINES_FAST * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(MOORING_ALL_LINES_FAST * 24 * 60, 60))), '00')) ELSE DECODE(PTA0003_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(MOORING_ALL_LINES_FAST), -1, '-' || TO_CHAR(CEIL(MOORING_ALL_LINES_FAST * 24)), TO_CHAR(FLOOR(MOORING_ALL_LINES_FAST * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(MOORING_ALL_LINES_FAST * 24 * 60, 60))), '00'))) END AS MOORING_ALL_LINES_FAST " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN NULL ELSE MOORING_ALL_LINES_FAST_RMK END AS MOORING_ALL_LINES_FAST_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(GANGWAY_DOWN), -1, '-' || TO_CHAR(CEIL(GANGWAY_DOWN * 24)), TO_CHAR(FLOOR(GANGWAY_DOWN * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(GANGWAY_DOWN * 24 * 60, 60))), '00')) ELSE DECODE(PTA0004_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(GANGWAY_DOWN), -1, '-' || TO_CHAR(CEIL(GANGWAY_DOWN * 24)), TO_CHAR(FLOOR(GANGWAY_DOWN * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(GANGWAY_DOWN * 24 * 60, 60))), '00'))) END AS GANGWAY_DOWN " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN NULL ELSE GANGWAY_DOWN_RMK END AS GANGWAY_DOWN_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(SAFETY_NET), -1, '-' || TO_CHAR(CEIL(SAFETY_NET * 24)), TO_CHAR(FLOOR(SAFETY_NET * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(SAFETY_NET * 24 * 60, 60))), '00')) ELSE DECODE(PTA0005_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(SAFETY_NET), -1, '-' || TO_CHAR(CEIL(SAFETY_NET * 24)), TO_CHAR(FLOOR(SAFETY_NET * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(SAFETY_NET * 24 * 60, 60))), '00'))) END AS SAFETY_NET " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN NULL ELSE SAFETY_NET_RMK END AS SAFETY_NET_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(QUARANTINE_ON_BOARD), -1, '-' || TO_CHAR(CEIL(QUARANTINE_ON_BOARD * 24)), TO_CHAR(FLOOR(QUARANTINE_ON_BOARD * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(QUARANTINE_ON_BOARD * 24 * 60, 60))), '00')) ELSE DECODE(PTA0006_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(QUARANTINE_ON_BOARD), -1, '-' || TO_CHAR(CEIL(QUARANTINE_ON_BOARD * 24)), TO_CHAR(FLOOR(QUARANTINE_ON_BOARD * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(QUARANTINE_ON_BOARD * 24 * 60, 60))), '00'))) END AS QUARANTINE_ON_BOARD " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN NULL ELSE QUARANTINE_ON_BOARD_RMK END AS QUARANTINE_ON_BOARD_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("           OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(IMMIGRATION_AGENT_ON_BOARD), -1, '-' || TO_CHAR(CEIL(IMMIGRATION_AGENT_ON_BOARD * 24)), TO_CHAR(FLOOR(IMMIGRATION_AGENT_ON_BOARD * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(IMMIGRATION_AGENT_ON_BOARD * 24 * 60, 60))), '00')) ELSE DECODE(PTA0007_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(IMMIGRATION_AGENT_ON_BOARD), -1, '-' || TO_CHAR(CEIL(IMMIGRATION_AGENT_ON_BOARD * 24)), TO_CHAR(FLOOR(IMMIGRATION_AGENT_ON_BOARD * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(IMMIGRATION_AGENT_ON_BOARD * 24 * 60, 60))), '00'))) END AS IMMIGRATION_AGENT_ON_BOARD " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE IMMIGRATION_AGENT_ON_BOARD_RMK END AS IMMIGRATION_AGENT_ON_BOARD_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(CUSTOMS_INSPECTION_ON_BOARD), -1, '-' || TO_CHAR(CEIL(CUSTOMS_INSPECTION_ON_BOARD * 24)), TO_CHAR(FLOOR(CUSTOMS_INSPECTION_ON_BOARD * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(CUSTOMS_INSPECTION_ON_BOARD * 24 * 60, 60))), '00')) ELSE DECODE(PTA0008_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(CUSTOMS_INSPECTION_ON_BOARD), -1, '-' || TO_CHAR(CEIL(CUSTOMS_INSPECTION_ON_BOARD * 24)), TO_CHAR(FLOOR(CUSTOMS_INSPECTION_ON_BOARD * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(CUSTOMS_INSPECTION_ON_BOARD * 24 * 60, 60))), '00'))) END AS CUSTOMS_INSPECTION_ON_BOARD " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE CUSTOMS_ON_BOARD_RMK END AS CUSTOMS_ON_BOARD_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(LASHER_ON_BOARD), -1, '-' || TO_CHAR(CEIL(LASHER_ON_BOARD * 24)), TO_CHAR(FLOOR(LASHER_ON_BOARD * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(LASHER_ON_BOARD * 24 * 60, 60))), '00')) ELSE DECODE(PTA0009_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(LASHER_ON_BOARD), -1, '-' || TO_CHAR(CEIL(LASHER_ON_BOARD * 24)), TO_CHAR(FLOOR(LASHER_ON_BOARD * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(LASHER_ON_BOARD * 24 * 60, 60))), '00'))) END AS LASHER_ON_BOARD " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE LASHER_ON_BOARD_RMK END AS LASHER_ON_BOARD_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(GANG_MOVE_TO_BERTH), -1, '-' || TO_CHAR(CEIL(GANG_MOVE_TO_BERTH * 24)), TO_CHAR(FLOOR(GANG_MOVE_TO_BERTH * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(GANG_MOVE_TO_BERTH * 24 * 60, 60))), '00')) ELSE DECODE(PTA0010_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(GANG_MOVE_TO_BERTH), -1, '-' || TO_CHAR(CEIL(GANG_MOVE_TO_BERTH * 24)), TO_CHAR(FLOOR(GANG_MOVE_TO_BERTH * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(GANG_MOVE_TO_BERTH * 24 * 60, 60))), '00'))) END AS GANG_MOVE_TO_BERTH " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE GANG_MOVE_TO_BERTH_RMK END AS GANG_MOVE_TO_BERTH_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(GANTRY_CRANE_READY), -1, '-' || TO_CHAR(CEIL(GANTRY_CRANE_READY * 24)), TO_CHAR(FLOOR(GANTRY_CRANE_READY * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(GANTRY_CRANE_READY * 24 * 60, 60))), '00')) ELSE DECODE(PTA0011_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(GANTRY_CRANE_READY), -1, '-' || TO_CHAR(CEIL(GANTRY_CRANE_READY * 24)), TO_CHAR(FLOOR(GANTRY_CRANE_READY * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(GANTRY_CRANE_READY * 24 * 60, 60))), '00'))) END AS GANTRY_CRANE_READY " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE GANTRY_CRANE_READY_RMK END AS GANTRY_CRANE_READY_RMK " ).append("\n"); 
		query.append("     , REPLACE(DECODE(SIGN(OPERATION), -1, '-' || TO_CHAR(CEIL(OPERATION * 24)), TO_CHAR(FLOOR(OPERATION * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(OPERATION * 24 * 60, 60))), '00')) AS OPERATION " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE OPERATION_FIRST_RMK||'/'||OPERATION_LAST_RMK END AS OPERATION_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(LASHING_SINGED_OFF), -1, '-' || TO_CHAR(CEIL(LASHING_SINGED_OFF * 24)), TO_CHAR(FLOOR(LASHING_SINGED_OFF * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(LASHING_SINGED_OFF * 24 * 60, 60))), '00')) ELSE DECODE(PTA0012_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(LASHING_SINGED_OFF), -1, '-' || TO_CHAR(CEIL(LASHING_SINGED_OFF * 24)), TO_CHAR(FLOOR(LASHING_SINGED_OFF * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(LASHING_SINGED_OFF * 24 * 60, 60))), '00'))) END AS LASHING_SINGED_OFF " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE LASHING_SINGED_OFF_RMK END AS LASHING_SINGED_OFF_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(PILOT_ON_BOARD_DEP), -1, '-' || TO_CHAR(CEIL(PILOT_ON_BOARD_DEP * 24)), TO_CHAR(FLOOR(PILOT_ON_BOARD_DEP * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(PILOT_ON_BOARD_DEP * 24 * 60, 60))), '00')) ELSE DECODE(PTA0013_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(PILOT_ON_BOARD_DEP), -1, '-' || TO_CHAR(CEIL(PILOT_ON_BOARD_DEP * 24)), TO_CHAR(FLOOR(PILOT_ON_BOARD_DEP * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(PILOT_ON_BOARD_DEP * 24 * 60, 60))), '00'))) END AS PILOT_ON_BOARD_DEP " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE PILOT_ON_BOARD_DEP_RMK END AS PILOT_ON_BOARD_DEP_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(AGENT_OFF_BOARD), -1, '-' || TO_CHAR(CEIL(AGENT_OFF_BOARD * 24)), TO_CHAR(FLOOR(AGENT_OFF_BOARD * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(AGENT_OFF_BOARD * 24 * 60, 60))), '00')) ELSE DECODE(PTA0014_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(AGENT_OFF_BOARD), -1, '-' || TO_CHAR(CEIL(AGENT_OFF_BOARD * 24)), TO_CHAR(FLOOR(AGENT_OFF_BOARD * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(AGENT_OFF_BOARD * 24 * 60, 60))), '00'))) END AS AGENT_OFF_BOARD " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE AGENT_OFF_BOARD_RMK END AS AGENT_OFF_BOARD_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(GANGWAY_UP), -1, '-' || TO_CHAR(CEIL(GANGWAY_UP * 24)), TO_CHAR(FLOOR(GANGWAY_UP * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(GANGWAY_UP * 24 * 60, 60))), '00')) ELSE DECODE(PTA0015_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(GANGWAY_UP), -1, '-' || TO_CHAR(CEIL(GANGWAY_UP * 24)), TO_CHAR(FLOOR(GANGWAY_UP * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(GANGWAY_UP * 24 * 60, 60))), '00'))) END AS GANGWAY_UP " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE GANGWAY_UP_RMK END AS GANGWAY_UP_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN REPLACE(DECODE(SIGN(TUG_BOAT_READY), -1, '-' || TO_CHAR(CEIL(TUG_BOAT_READY * 24)), TO_CHAR(FLOOR(TUG_BOAT_READY * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(TUG_BOAT_READY * 24 * 60, 60))), '00')) ELSE DECODE(PTA0016_CHK, 'N', 'Combined', REPLACE(DECODE(SIGN(TUG_BOAT_READY), -1, '-' || TO_CHAR(CEIL(TUG_BOAT_READY * 24)), TO_CHAR(FLOOR(TUG_BOAT_READY * 24))), '--', '-') || ':' || LTRIM(TO_CHAR(ROUND(ABS(MOD(TUG_BOAT_READY * 24 * 60, 60))), '00'))) END AS TUG_BOAT_READY " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE TUG_BOAT_READY_RMK END AS TUG_BOAT_READY_RMK " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE DECODE(PTA0017_CHK, 'N', 'Combined', UNMOORING_ALL_LINES_RELEASE) END AS UNMOORING_ALL_LINES_RELEASE " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1" ).append("\n"); 
		query.append("          OR GROUPING_SLAN_CD = 1) THEN NULL ELSE UNMOORING_RELEASE_RMK END AS UNMOORING_RELEASE_RMK " ).append("\n"); 
		query.append("     , TWIN_LIFT " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1  OR GROUPING_SLAN_CD = 1) THEN NULL ELSE TWIN_LIFT_RMK END AS TWIN_LIFT_RMK " ).append("\n"); 
		query.append("     , DUAL_CYCLE " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1  OR GROUPING_SLAN_CD = 1) THEN NULL ELSE DUAL_CYCLE_RMK END AS DUAL_CYCLE_RMK " ).append("\n"); 
		query.append("     , RESTOW " ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1  OR GROUPING_SLAN_CD = 1) THEN NULL ELSE RESTOW_RMK END AS RESTOW_RMK" ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1 OR GROUPING_SLAN_CD = 1) THEN NULL ELSE TO_CHAR(PLT_IN_DT         ,'YYYY-MM-DD HH24:MI') END AS PLT_IN_DT" ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1 OR GROUPING_SLAN_CD = 1) THEN NULL ELSE TO_CHAR(PLT_OUT_DT        ,'YYYY-MM-DD HH24:MI') END AS PLT_OUT_DT" ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1 OR GROUPING_SLAN_CD = 1) THEN NULL ELSE TO_CHAR(PORT_TM_ACT_UPD_DT,'YYYY-MM-DD HH24:MI') END AS PORT_TM_ACT_UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1  OR GROUPING_SLAN_CD = 1) THEN NULL ELSE NVL2(STW_DIF_HRS, DECODE(SIGN(STW_DIF_HRS), -1, 'N', 'Y') ,'N') END AS STW_DIF_HRS_FLG" ).append("\n"); 
		query.append("     , CASE WHEN (GROUPING_VVD = 1  OR GROUPING_SLAN_CD = 1) THEN NULL ELSE STW_DIF_HRS END AS STW_DIF_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (    " ).append("\n"); 
		query.append("    SELECT RHQ " ).append("\n"); 
		query.append("         , YD_CD " ).append("\n"); 
		query.append("         , SLAN_CD " ).append("\n"); 
		query.append("         , VVD " ).append("\n"); 
		query.append("         , CLPT_IND_SEQ " ).append("\n"); 
		query.append("         , GROUPING(VVD ) AS GROUPING_VVD" ).append("\n"); 
		query.append("         , GROUPING(SLAN_CD ) AS GROUPING_SLAN_CD " ).append("\n"); 
		query.append("         , ROW_NUMBER() OVER (ORDER BY RHQ, YD_CD, SLAN_CD, VVD) AS SEQ " ).append("\n"); 
		query.append("         , ROUND(AVG(TDR_MVS ), 1) AS TDR_MVS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , MAX(DECODE(PTA0020_CHK, 'Y', DRIFTING_START_BBO )) AS DRIFTING_START_BBO " ).append("\n"); 
		query.append("         , MAX(DRIFTING_START_BBO_RMK ) AS DRIFTING_START_BBO_RMK " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         , AVG(DRIFTING_END_BBO ) AS DRIFTING_END_BBO " ).append("\n"); 
		query.append("         , MAX(DRIFTING_END_BBO_RMK ) AS DRIFTING_END_BBO_RMK " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         , MAX(DECODE(PTA0022_CHK, 'Y', ANCHOR_DROP_VMS )) AS ANCHOR_DROP_VMS " ).append("\n"); 
		query.append("         , MAX(ANCHOR_DROP_VMS_RMK ) AS ANCHOR_DROP_VMS_RMK " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         , AVG(ANCHOR_AWAY_VMS ) AS ANCHOR_AWAY_VMS " ).append("\n"); 
		query.append("         , MAX(ANCHOR_AWAY_VMS_RMK ) AS ANCHOR_AWAY_VMS_RMK " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         , MAX(DECODE(PTA0024_CHK, 'Y', ANCHOR_DROP_BBO )) AS ANCHOR_DROP_BBO " ).append("\n"); 
		query.append("         , MAX(ANCHOR_DROP_BBO_RMK ) AS ANCHOR_DROP_BBO_RMK " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         , AVG(ANCHOR_AWAY_BBO ) AS ANCHOR_AWAY_BBO " ).append("\n"); 
		query.append("         , MAX(ANCHOR_AWAY_BBO_RMK ) AS ANCHOR_AWAY_BBO_RMK  " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0001_CHK, 'Y', PILOT_ON_BOARD_ARR )) AS PILOT_ON_BOARD_ARR " ).append("\n"); 
		query.append("         , MAX(PILOT_ON_BOARD_ARR_RMK ) AS PILOT_ON_BOARD_ARR_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0002_CHK, 'Y',SAILING_IN )) AS SAILING_IN " ).append("\n"); 
		query.append("         , MAX(SAILING_IN_RMK ) AS SAILING_IN_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0003_CHK, 'Y',MOORING_ALL_LINES_FAST )) AS MOORING_ALL_LINES_FAST " ).append("\n"); 
		query.append("         , MAX(MOORING_ALL_LINES_FAST_RMK ) AS MOORING_ALL_LINES_FAST_RMK" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0004_CHK, 'Y',GANGWAY_DOWN )) AS GANGWAY_DOWN " ).append("\n"); 
		query.append("         , MAX(GANGWAY_DOWN_RMK ) AS GANGWAY_DOWN_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0005_CHK, 'Y',SAFETY_NET )) AS SAFETY_NET " ).append("\n"); 
		query.append("         , MAX(SAFETY_NET_RMK ) AS SAFETY_NET_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0006_CHK, 'Y', QUARANTINE_ON_BOARD )) AS QUARANTINE_ON_BOARD" ).append("\n"); 
		query.append("         , MAX(QUARANTINE_ON_BOARD_RMK ) AS QUARANTINE_ON_BOARD_RMK" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0007_CHK, 'Y',IMMIGRATION_AGENT_ON_BOARD )) AS IMMIGRATION_AGENT_ON_BOARD " ).append("\n"); 
		query.append("         , MAX(IMMIGRATION_AGENT_ON_BOARD_RMK) AS IMMIGRATION_AGENT_ON_BOARD_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0008_CHK, 'Y',CUSTOMS_INSPECTION_ON_BOARD)) AS CUSTOMS_INSPECTION_ON_BOARD " ).append("\n"); 
		query.append("         , MAX(CUSTOMS_ON_BOARD_RMK) AS CUSTOMS_ON_BOARD_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0009_CHK, 'Y',LASHER_ON_BOARD )) AS LASHER_ON_BOARD " ).append("\n"); 
		query.append("         , MAX(LASHER_ON_BOARD_RMK ) AS LASHER_ON_BOARD_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0010_CHK, 'Y',GANG_MOVE_TO_BERTH )) AS GANG_MOVE_TO_BERTH " ).append("\n"); 
		query.append("         , MAX(GANG_MOVE_TO_BERTH_RMK ) AS GANG_MOVE_TO_BERTH_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0011_CHK, 'Y',GANTRY_CRANE_READY )) AS GANTRY_CRANE_READY " ).append("\n"); 
		query.append("         , MAX(GANTRY_CRANE_READY_RMK ) AS GANTRY_CRANE_READY_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(OPERATION ) AS OPERATION " ).append("\n"); 
		query.append("         , MAX(OPERATION_FIRST_RMK ) AS OPERATION_FIRST_RMK " ).append("\n"); 
		query.append("         , MAX(OPERATION_LAST_RMK ) AS OPERATION_LAST_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0012_CHK, 'Y',LASHING_SINGED_OFF )) AS LASHING_SINGED_OFF " ).append("\n"); 
		query.append("         , MAX(LASHING_SINGED_OFF_RMK ) AS LASHING_SINGED_OFF_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0013_CHK, 'Y',PILOT_ON_BOARD_DEP )) AS PILOT_ON_BOARD_DEP " ).append("\n"); 
		query.append("         , MAX(PILOT_ON_BOARD_DEP_RMK ) AS PILOT_ON_BOARD_DEP_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0014_CHK, 'Y',AGENT_OFF_BOARD )) AS AGENT_OFF_BOARD " ).append("\n"); 
		query.append("         , MAX(AGENT_OFF_BOARD_RMK ) AS AGENT_OFF_BOARD_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0015_CHK, 'Y',GANGWAY_UP )) AS GANGWAY_UP " ).append("\n"); 
		query.append("         , MAX(GANGWAY_UP_RMK ) AS GANGWAY_UP_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , AVG(DECODE(PTA0016_CHK, 'Y',TUG_BOAT_READY )) AS TUG_BOAT_READY " ).append("\n"); 
		query.append("         , MAX(TUG_BOAT_READY_RMK ) AS TUG_BOAT_READY_RMK " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("         , MAX(UNMOORING_ALL_LINES_RELEASE) AS UNMOORING_ALL_LINES_RELEASE " ).append("\n"); 
		query.append("         , MAX(UNMOORING_RELEASE_RMK) AS UNMOORING_RELEASE_RMK " ).append("\n"); 
		query.append("         , ROUND(AVG(TWIN_LIFT ), 1) AS TWIN_LIFT " ).append("\n"); 
		query.append("         , MAX(TWIN_LIFT_RMK ) AS TWIN_LIFT_RMK " ).append("\n"); 
		query.append("         , ROUND(AVG(DUAL_CYCLE ), 1) AS DUAL_CYCLE " ).append("\n"); 
		query.append("         , MAX(DUAL_CYCLE_RMK ) AS DUAL_CYCLE_RMK " ).append("\n"); 
		query.append("         , ROUND(AVG(RESTOW ), 1) AS RESTOW " ).append("\n"); 
		query.append("         , MAX(RESTOW_RMK ) AS RESTOW_RMK " ).append("\n"); 
		query.append("         , MAX(PTA0001_CHK) AS PTA0001_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0002_CHK) AS PTA0002_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0003_CHK) AS PTA0003_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0004_CHK) AS PTA0004_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0005_CHK) AS PTA0005_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0006_CHK) AS PTA0006_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0007_CHK) AS PTA0007_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0008_CHK) AS PTA0008_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0009_CHK) AS PTA0009_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0010_CHK) AS PTA0010_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0011_CHK) AS PTA0011_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0012_CHK) AS PTA0012_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0013_CHK) AS PTA0013_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0014_CHK) AS PTA0014_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0015_CHK) AS PTA0015_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0016_CHK) AS PTA0016_CHK " ).append("\n"); 
		query.append("         , MAX(PTA0017_CHK) AS PTA0017_CHK" ).append("\n"); 
		query.append("         , MAX(PTA0020_CHK) AS PTA0020_CHK" ).append("\n"); 
		query.append("         , MAX(PTA0021_CHK) AS PTA0021_CHK" ).append("\n"); 
		query.append("         , MAX(PTA0022_CHK) AS PTA0022_CHK" ).append("\n"); 
		query.append("         , MAX(PTA0023_CHK) AS PTA0023_CHK" ).append("\n"); 
		query.append("         , MAX(PTA0024_CHK) AS PTA0024_CHK" ).append("\n"); 
		query.append("         , MAX(PTA0025_CHK) AS PTA0025_CHK" ).append("\n"); 
		query.append("         , MAX(PLT_IN_DT)            AS PLT_IN_DT" ).append("\n"); 
		query.append("         , MAX(PLT_OUT_DT)           AS PLT_OUT_DT" ).append("\n"); 
		query.append("         , MAX(PORT_TM_ACT_UPD_DT)   AS PORT_TM_ACT_UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , MAX((SELECT NVL(ROUND((H.ACT_BRTH_DT - H.TRSM_LOCL_DT)*24,2), -1) " ).append("\n"); 
		query.append("                   FROM (" ).append("\n"); 
		query.append("                            SELECT" ).append("\n"); 
		query.append("                            H.SLAN_CD," ).append("\n"); 
		query.append("                            H.VSL_CD," ).append("\n"); 
		query.append("                            H.SKD_VOY_NO," ).append("\n"); 
		query.append("                            H.SKD_DIR_CD," ).append("\n"); 
		query.append("                            H.VPS_PORT_CD," ).append("\n"); 
		query.append("                            H.CLPT_IND_SEQ, " ).append("\n"); 
		query.append("                            AK.ACT_BRTH_DT," ).append("\n"); 
		query.append("                            H.TRSM_LOCL_DT," ).append("\n"); 
		query.append("                            ROW_NUMBER() OVER(PARTITION BY " ).append("\n"); 
		query.append("                            H.VSL_CD," ).append("\n"); 
		query.append("                            H.SKD_VOY_NO," ).append("\n"); 
		query.append("                            H.SKD_DIR_CD," ).append("\n"); 
		query.append("                            H.VPS_PORT_CD," ).append("\n"); 
		query.append("                            H.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                            ORDER BY H.TRSM_HIS_SEQ DESC) RN" ).append("\n"); 
		query.append("                            FROM" ).append("\n"); 
		query.append("                            VSK_VSL_PORT_SKD_TRSM_HIS H," ).append("\n"); 
		query.append("                            VSK_ACT_PORT_SKD AK" ).append("\n"); 
		query.append("                            WHERE 1=1" ).append("\n"); 
		query.append("                            AND H.VSL_CD         = AK.VSL_CD           (+)" ).append("\n"); 
		query.append("                            AND H.SKD_VOY_NO     = AK.SKD_VOY_NO       (+)" ).append("\n"); 
		query.append("                            AND H.SKD_DIR_CD     = AK.SKD_DIR_CD       (+)" ).append("\n"); 
		query.append("                            AND H.VPS_PORT_CD    = AK.VPS_PORT_CD      (+)" ).append("\n"); 
		query.append("                            AND H.CLPT_IND_SEQ   = AK.CLPT_IND_SEQ     (+) " ).append("\n"); 
		query.append("                            AND H.ACT_CRR_CD    = 'SML'" ).append("\n"); 
		query.append("                            AND H.TRSM_PURP_CD	= 'STW'" ).append("\n"); 
		query.append("                        ) H" ).append("\n"); 
		query.append("                        WHERE H.RN = 1 " ).append("\n"); 
		query.append("                        AND H.SLAN_CD        = D.SLAN_CD" ).append("\n"); 
		query.append("                        AND H.VSL_CD         = D.VSL_CD" ).append("\n"); 
		query.append("                        AND H.SKD_VOY_NO     = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND H.SKD_DIR_CD     = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND H.VPS_PORT_CD    = D.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND H.CLPT_IND_SEQ   = D.CLPT_IND_SEQ                                               " ).append("\n"); 
		query.append("                 )) AS STW_DIF_HRS     -- VSK > Pre stowage plan CHECK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM (    " ).append("\n"); 
		query.append("        SELECT  RHQ, YD_CD, SLAN_CD, VVD, CLPT_IND_SEQ" ).append("\n"); 
		query.append("              , MAX(VSL_CD) VSL_CD, MAX(SKD_VOY_NO) SKD_VOY_NO, MAX(SKD_DIR_CD) SKD_DIR_CD  " ).append("\n"); 
		query.append("              , MAX(VPS_PORT_CD) VPS_PORT_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              , MAX(TDR_MVS) TDR_MVS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0020', WRK_PERF_DT)), '') AS DRIFTING_START_BBO " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0020', WRK_PERF_DT)), 'Y', 'N') AS PTA0020_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0020', DIFF_RMK)), 'N') AS DRIFTING_START_BBO_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0021', WRK_PERF_DT)) - MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0020', WRK_PERF_DT)), 0) AS DRIFTING_END_BBO " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0021', WRK_PERF_DT)), 'Y', 'N') AS PTA0021_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0021', DIFF_RMK)), 'N') AS DRIFTING_END_BBO_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0022', WRK_PERF_DT)), '') AS ANCHOR_DROP_VMS " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0022', WRK_PERF_DT)), 'Y', 'N') AS PTA0022_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0022', DIFF_RMK)), 'N') AS ANCHOR_DROP_VMS_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0023', WRK_PERF_DT)) - MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0022', WRK_PERF_DT)), 0) AS ANCHOR_AWAY_VMS" ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0023', WRK_PERF_DT)), 'Y', 'N') AS PTA0023_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0023', DIFF_RMK)), 'N') AS ANCHOR_AWAY_VMS_RMK" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0024', WRK_PERF_DT)), '') AS ANCHOR_DROP_BBO " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0024', WRK_PERF_DT)), 'Y', 'N') AS PTA0024_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0024', DIFF_RMK)), 'N') AS ANCHOR_DROP_BBO_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0025', WRK_PERF_DT)) - MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0024', WRK_PERF_DT)), 0) AS ANCHOR_AWAY_BBO " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0025', WRK_PERF_DT)), 'Y', 'N') AS PTA0025_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0025', DIFF_RMK)), 'N') AS ANCHOR_AWAY_BBO_RMK " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0001', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS PILOT_ON_BOARD_ARR " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0001', WRK_PERF_DT)), 'Y', 'N') AS PTA0001_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0001', DIFF_RMK)), 'N') AS PILOT_ON_BOARD_ARR_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0002', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS SAILING_IN " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0002', WRK_PERF_DT)), 'Y', 'N') AS PTA0002_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0002', DIFF_RMK)), 'N') AS SAILING_IN_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0003', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS MOORING_ALL_LINES_FAST " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0003', WRK_PERF_DT)), 'Y', 'N') AS PTA0003_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0003', DIFF_RMK)), 'N') AS MOORING_ALL_LINES_FAST_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0004', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS GANGWAY_DOWN" ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0004', WRK_PERF_DT)), 'Y', 'N') AS PTA0004_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0004', DIFF_RMK)), 'N') AS GANGWAY_DOWN_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0005', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS SAFETY_NET " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0005', WRK_PERF_DT)), 'Y', 'N') AS PTA0005_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0005', DIFF_RMK)), 'N') AS SAFETY_NET_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0006', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS QUARANTINE_ON_BOARD " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0006', WRK_PERF_DT)), 'Y', 'N') AS PTA0006_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0006', DIFF_RMK)), 'N') AS QUARANTINE_ON_BOARD_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0007', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS IMMIGRATION_AGENT_ON_BOARD " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0007', WRK_PERF_DT)), 'Y', 'N') AS PTA0007_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0007', DIFF_RMK)), 'N') AS IMMIGRATION_AGENT_ON_BOARD_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0008', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS CUSTOMS_INSPECTION_ON_BOARD " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0008', WRK_PERF_DT)), 'Y', 'N') AS PTA0008_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0008', DIFF_RMK)), 'N') AS CUSTOMS_ON_BOARD_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0009', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS LASHER_ON_BOARD " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0009', WRK_PERF_DT)), 'Y', 'N') AS PTA0009_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0009', DIFF_RMK)), 'N') AS LASHER_ON_BOARD_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0010', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS GANG_MOVE_TO_BERTH " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0010', WRK_PERF_DT)), 'Y', 'N') AS PTA0010_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0010', DIFF_RMK)), 'N') AS GANG_MOVE_TO_BERTH_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0011', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS GANTRY_CRANE_READY " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0011', WRK_PERF_DT)), 'Y', 'N') AS PTA0011_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0011', DIFF_RMK)), 'N') AS GANTRY_CRANE_READY_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0018', ACT_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS OPERATION " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0018', DIFF_RMK)), 'N') AS OPERATION_FIRST_RMK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0019', DIFF_RMK)), 'N') AS OPERATION_LAST_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0012', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS LASHING_SINGED_OFF " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0012', WRK_PERF_DT)), 'Y', 'N') AS PTA0012_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0012', DIFF_RMK)), 'N') AS LASHING_SINGED_OFF_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0013', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS PILOT_ON_BOARD_DEP " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0013', WRK_PERF_DT)), 'Y', 'N') AS PTA0013_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0013', DIFF_RMK)), 'N') AS PILOT_ON_BOARD_DEP_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0014', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS AGENT_OFF_BOARD " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0014', WRK_PERF_DT)), 'Y', 'N') AS PTA0014_CHK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0014', DIFF_RMK)), 'N') AS AGENT_OFF_BOARD_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0015', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS GANGWAY_UP     " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0015', WRK_PERF_DT)), 'Y', 'N') AS PTA0015_CHK " ).append("\n"); 
		query.append("              , NVL(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0015', DIFF_RMK)), 'N') AS GANGWAY_UP_RMK     " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0016', TIME_NEXT_WRK_PERF_DT - WRK_PERF_DT)), 0) AS TUG_BOAT_READY " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0016', WRK_PERF_DT)), 'Y', 'N') AS PTA0016_CHK " ).append("\n"); 
		query.append("              , NVL(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0016', DIFF_RMK)), 'N') AS TUG_BOAT_READY_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("--              , MAX(TO_CHAR(WRK_PERF_DT, 'YYYY-MM-DD HH24:MI')) AS UNMOORING_ALL_LINES_RELEASE        UNMOORING_ALL_LINES_RELEASE 값은 항상 자기 값을 가지도록 수정함(기존로직 변경사항)   " ).append("\n"); 
		query.append("              , MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0017', TO_CHAR(WRK_PERF_DT, 'YYYY-MM-DD HH24:MI'))) AS UNMOORING_ALL_LINES_RELEASE " ).append("\n"); 
		query.append("              , NVL2(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0017', WRK_PERF_DT)), 'Y', 'N') AS PTA0017_CHK " ).append("\n"); 
		query.append("              , NVL(MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'PTA0017', DIFF_RMK)), 'N') AS UNMOORING_RELEASE_RMK " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'CHT0001', CNTR_HNDL_KNT )), 0) AS TWIN_LIFT " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'CHT0001', DIFF_RMK )), 'N') AS TWIN_LIFT_RMK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'CHT0002', CNTR_HNDL_KNT )), 0) AS DUAL_CYCLE " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'CHT0002', DIFF_RMK )), 'N') AS DUAL_CYCLE_RMK " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'CHT0003', CNTR_HNDL_KNT )), 0) AS RESTOW " ).append("\n"); 
		query.append("              , NVL (MAX(DECODE(ACT_GEN_CD_VAL_CTNT, 'CHT0003', DIFF_RMK)), 'N') AS RESTOW_RMK" ).append("\n"); 
		query.append("              , MAX(PLT_IN_DT)            AS PLT_IN_DT" ).append("\n"); 
		query.append("              , MAX(PLT_OUT_DT)           AS PLT_OUT_DT" ).append("\n"); 
		query.append("              , MAX(PORT_TM_ACT_UPD_DT)   AS PORT_TM_ACT_UPD_DT" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("            SELECT  T1.DP_SEQ, T1.ACT_GEN_CD_ID, T1.ACT_GEN_CD_VAL_DESC, T2.VSL_CD||T2.SKD_VOY_NO||T2.SKD_DIR_CD AS VVD, T2.VPS_PORT_CD, T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  , T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  , ACT_GEN_CD_VAL_CTNT" ).append("\n"); 
		query.append("                  , WRK_PERF_DT" ).append("\n"); 
		query.append("                  , CASE WHEN ACT_GEN_CD_ID = 'CD00001' THEN LEAD(ACT_GEN_CD_VAL_CTNT) OVER (PARTITION BY ACT_GEN_CD_ID, T2.VSL_CD||T2.SKD_VOY_NO||T2.SKD_DIR_CD, T2.VPS_PORT_CD, T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    ORDER BY WRK_PERF_DT ASC, DP_SEQ ASC) END AS TIME_NEXT_ITEM" ).append("\n"); 
		query.append("                  , CASE WHEN ACT_GEN_CD_ID = 'CD00001' THEN LEAD(WRK_PERF_DT) OVER (PARTITION BY ACT_GEN_CD_ID, T2.VSL_CD||T2.SKD_VOY_NO||T2.SKD_DIR_CD, T2.VPS_PORT_CD, T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    ORDER BY WRK_PERF_DT ASC, DP_SEQ ASC) END AS TIME_NEXT_WRK_PERF_DT" ).append("\n"); 
		query.append("                  , CASE WHEN ACT_GEN_CD_ID = 'CD00001' THEN LEAD(ACT_GEN_CD_VAL_CTNT) OVER (PARTITION BY ACT_GEN_CD_ID, T2.VSL_CD||T2.SKD_VOY_NO||T2.SKD_DIR_CD, T2.VPS_PORT_CD, T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    ORDER BY DP_SEQ ASC) END AS ACT_NEXT_ITEM" ).append("\n"); 
		query.append("                  , CASE WHEN ACT_GEN_CD_ID = 'CD00001' THEN LEAD(WRK_PERF_DT) OVER (PARTITION BY ACT_GEN_CD_ID, T2.VSL_CD||T2.SKD_VOY_NO||T2.SKD_DIR_CD, T2.VPS_PORT_CD, T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    ORDER BY DP_SEQ ASC) END AS ACT_NEXT_WRK_PERF_DT" ).append("\n"); 
		query.append("                  , CNTR_HNDL_KNT" ).append("\n"); 
		query.append("                  , OP_STPG_CTNT" ).append("\n"); 
		query.append("                  , SUBSTR(T3.YD_CD, 1, 5) ||'(' || SUBSTR(T3.YD_CD, 6, 2) || ')' AS YD_CD" ).append("\n"); 
		query.append("                  , T3.SLAN_CD" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                        SELECT CASE WHEN NVL(ML.DELT_FLG, 'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN '' " ).append("\n"); 
		query.append("                                    ELSE (SELECT O.OFC_N3RD_LVL_CD FROM MAS_OFC_LVL O WHERE O.OFC_CD = ML.EQ_CTRL_OFC_CD AND O.OFC_APLY_TO_YRMON ='999912' AND O.OFC_LVL < 9)" ).append("\n"); 
		query.append("--										CASE WHEN ML.CONTI_CD IN ('E','F') AND ML.LOC_CD NOT IN('EGAIS','ZADUR','RUVVO') THEN 'HAMRU' " ).append("\n"); 
		query.append("--                                              WHEN ML.CONTI_CD = 'M' THEN 'NYCRA' " ).append("\n"); 
		query.append("--                                              WHEN ML.CONTI_CD = 'A'  AND ML.SCONTI_CD = 'AF' THEN DECODE(ML.CNT_CD,'KR','SELIB','JP','TYOIB','SHARC') " ).append("\n"); 
		query.append("--                                              WHEN (ML.CONTI_CD = 'A' AND ML.SCONTI_CD <> 'AF') OR ML.LOC_CD IN ('EGAIS', 'ZADUR') THEN 'SINRS'" ).append("\n"); 
		query.append("--											  WHEN ML.CONTI_CD  IN ('E') AND ML.LOC_CD = 'RUVVO' THEN 'VVOIA' " ).append("\n"); 
		query.append("--                                              ELSE '' END " ).append("\n"); 
		query.append("									END" ).append("\n"); 
		query.append("                        FROM MDM_LOCATION ML" ).append("\n"); 
		query.append("                        WHERE ML.LOC_CD = T2.VPS_PORT_CD ) AS RHQ " ).append("\n"); 
		query.append("                  , T4.MVS AS TDR_MVS" ).append("\n"); 
		query.append("                  , DIFF_RMK" ).append("\n"); 
		query.append("                  , DR.PLT_IN_DT" ).append("\n"); 
		query.append("                  , DR.PLT_OUT_DT" ).append("\n"); 
		query.append("                  , T2.UPD_DT           AS PORT_TM_ACT_UPD_DT" ).append("\n"); 
		query.append("            FROM    OPF_GEN_CD_DTL      T1" ).append("\n"); 
		query.append("                  , OPF_PORT_TM_ACT     T2" ).append("\n"); 
		query.append("                  , VSK_VSL_PORT_SKD    T3" ).append("\n"); 
		query.append("                  , TDR_HEADER          T4" ).append("\n"); 
		query.append("                  , FCM_DEP_RPT         DR" ).append("\n"); 
		query.append("            WHERE   1=1" ).append("\n"); 
		query.append("                AND     T3.VSL_CD               = DR.VSL_CD         (+)" ).append("\n"); 
		query.append("                AND     T3.SKD_VOY_NO           = DR.SKD_VOY_NO     (+)" ).append("\n"); 
		query.append("                AND     T3.SKD_DIR_CD           = DR.SKD_DIR_CD     (+)" ).append("\n"); 
		query.append("                AND     T3.VPS_PORT_CD          = DR.DEP_PORT_CD    (+)" ).append("\n"); 
		query.append("                AND     T3.CLPT_IND_SEQ         = DR.CLPT_IND_SEQ   (+) " ).append("\n"); 
		query.append("                AND     T1.ACT_GEN_CD_VAL_CTNT  = T2.PORT_ACT_CTNT  (+)" ).append("\n"); 
		query.append("                AND     T2.VSL_CD               = T3.VSL_CD         (+)" ).append("\n"); 
		query.append("                AND     T2.SKD_VOY_NO           = T3.SKD_VOY_NO     (+)" ).append("\n"); 
		query.append("                AND     T2.SKD_DIR_CD           = T3.SKD_DIR_CD     (+)" ).append("\n"); 
		query.append("                AND     T2.VPS_PORT_CD          = T3.VPS_PORT_CD    (+)" ).append("\n"); 
		query.append("                AND     T2.CLPT_IND_SEQ         = T3.CLPT_IND_SEQ   (+)" ).append("\n"); 
		query.append("                AND     T2.VSL_CD               = T4.VSL_CD         (+)" ).append("\n"); 
		query.append("                AND     T2.SKD_VOY_NO           = T4.VOY_NO         (+)" ).append("\n"); 
		query.append("                AND     T2.SKD_DIR_CD           = T4.DIR_CD         (+)" ).append("\n"); 
		query.append("                AND     T2.VPS_PORT_CD          = T4.PORT_CD        (+)" ).append("\n"); 
		query.append("                AND     T2.CLPT_IND_SEQ         = T4.CALL_IND       (+)" ).append("\n"); 
		query.append("#if(${slan_cd} != '')" ).append("\n"); 
		query.append("                AND     T3.SLAN_CD              = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${port_cd} != '')" ).append("\n"); 
		query.append("                AND     T3.VPS_PORT_CD          = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND     T1.ACT_GEN_CD_ID        IN ('CD00001', 'CD00002')" ).append("\n"); 
		query.append("                AND     ((T1.ACT_GEN_CD_ID      = 'CD00001'  AND T2.WRK_PERF_DT IS NOT NULL) OR T1.ACT_GEN_CD_ID = 'CD00002')" ).append("\n"); 
		query.append("                AND     T3.VPS_ETD_DT           BETWEEN TO_DATE(REPLACE(@[fr_dt], '-', ''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("				AND     T2.PORT_ACT_CTNT   LIKE 'PTA%'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("#if(${rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND     RHQ    = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY RHQ, SLAN_CD,VVD, YD_CD, CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ) D" ).append("\n"); 
		query.append("    WHERE   1=1" ).append("\n"); 
		query.append("    GROUP BY GROUPING SETS((RHQ, YD_CD, SLAN_CD, VVD,CLPT_IND_SEQ), (RHQ, YD_CD, SLAN_CD), ())" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("ORDER BY SEQ" ).append("\n"); 

	}
}