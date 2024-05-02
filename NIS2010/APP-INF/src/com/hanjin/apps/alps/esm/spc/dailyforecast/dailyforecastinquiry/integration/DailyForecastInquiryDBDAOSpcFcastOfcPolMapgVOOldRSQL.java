/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DailyForecastInquiryDBDAOSpcFcastOfcPolMapgVOOldRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.11.14 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastInquiryDBDAOSpcFcastOfcPolMapgVOOldRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
	  * 2010.11.16 남궁진호 [CHM-201007114-01] SPC_CONTI_CONV_FNC Function 사용 
	  * 2011.01.03 최윤성 [CHM-201008093-01] Office Level Table 생성
	  *  - SPC_ORGANIZATION_V 대신 SPC_OFC_LVL 로 대체
	  * 2011.04.11 김종준 [CHM-201110033-01] ALPS/SPC의 TS booking status 기능보완 요청 
	  *  -T/S VVD 및 T/S ETB DATE  필드 추가 
	  * 2011.05.06 최성민[CHM-201110577-01] ALPS/SPC의 TS booking status 기능보완 요청 
	  *  - Pre/Post T/S ETB Date 항목 추가 
	  * -2011.06.01 [ CHM-201111305-01] 김종준 R5와 동일하게 R9이 적용될 수 있도록 쿼리수정
	  * -2012.12.03 [CHM-201221639] 김시몬 R9와 동일하게 R8이 적용될 수 있도록 쿼리수정
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * * 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선 
	  * </pre>
	  */
	public DailyForecastInquiryDBDAOSpcFcastOfcPolMapgVOOldRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_conti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_lane6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_lane4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_lane5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_lane2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_lane3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_lane1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_pst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.integration").append("\n"); 
		query.append("FileName : DailyForecastInquiryDBDAOSpcFcastOfcPolMapgVOOldRSQL").append("\n"); 
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
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("SELECT @[year]        AS YR         ," ).append("\n"); 
		query.append("           @[week]        AS WK         ," ).append("\n"); 
		query.append("           @[duration]    AS DUR        ," ).append("\n"); 
		query.append("           @[lane]        AS LANE       ," ).append("\n"); 
		query.append("           @[vvd]         AS VVD        , " ).append("\n"); 
		query.append("           @[rhq_cd]      AS RHQ_CD     ," ).append("\n"); 
		query.append("           @[ofc_cd]      AS OFC_CD     ," ).append("\n"); 
		query.append("           @[ts_lane1]    AS TS_LANE1   ," ).append("\n"); 
		query.append("           @[ts_lane2]    AS TS_LANE2   ," ).append("\n"); 
		query.append("           @[ts_lane3]    AS TS_LANE3   ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           @[ts_conti]    AS TS_CONTI   , " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           @[ts_lane4]    AS TS_LANE4   ," ).append("\n"); 
		query.append("           @[ts_lane5]    AS TS_LANE5   ," ).append("\n"); 
		query.append("           @[ts_lane6]    AS TS_LANE6   ," ).append("\n"); 
		query.append("           @[pre_pst_flg] AS PRE_PST_FLG," ).append("\n"); 
		query.append("           @[pol1]        AS POL1       ," ).append("\n"); 
		query.append("           @[pol2]        AS POL2       ," ).append("\n"); 
		query.append("           @[pol3]        AS POL3       ," ).append("\n"); 
		query.append("           @[pol4]        AS POL4       ," ).append("\n"); 
		query.append("           @[pol5]        AS POL5       ," ).append("\n"); 
		query.append("           @[pol6]        AS POL6       ," ).append("\n"); 
		query.append("           @[pod1]        AS POD1       ," ).append("\n"); 
		query.append("           @[pod2]        AS POD2       ," ).append("\n"); 
		query.append("           @[pod3]        AS POD3       ," ).append("\n"); 
		query.append("           @[pod4]        AS POD4       ," ).append("\n"); 
		query.append("           @[pod5]        AS POD5       ," ).append("\n"); 
		query.append("           @[pod6]        AS POD6" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CPARAMS AS (" ).append("\n"); 
		query.append("    SELECT P.YR         ," ).append("\n"); 
		query.append("           P.WK         ," ).append("\n"); 
		query.append("           P.DUR        ," ).append("\n"); 
		query.append("           P.LANE       ," ).append("\n"); 
		query.append("           P.VVD        ," ).append("\n"); 
		query.append("           P.RHQ_CD     ," ).append("\n"); 
		query.append("           P.OFC_CD     ," ).append("\n"); 
		query.append("           L.CONTI_CD AS CONTI," ).append("\n"); 
		query.append("           P.TS_LANE1   ," ).append("\n"); 
		query.append("           P.TS_LANE2   ," ).append("\n"); 
		query.append("           P.TS_LANE3   ," ).append("\n"); 
		query.append("           P.TS_LANE4   ," ).append("\n"); 
		query.append("           P.TS_LANE5   ," ).append("\n"); 
		query.append("           P.TS_LANE6   ," ).append("\n"); 
		query.append("           P.PRE_PST_FLG," ).append("\n"); 
		query.append("           P.POL1       ," ).append("\n"); 
		query.append("           P.POL2       ," ).append("\n"); 
		query.append("           P.POL3       ," ).append("\n"); 
		query.append("           P.POL4       ," ).append("\n"); 
		query.append("           P.POL5       ," ).append("\n"); 
		query.append("           P.POL6       ," ).append("\n"); 
		query.append("           P.POD1       ," ).append("\n"); 
		query.append("           P.POD2       ," ).append("\n"); 
		query.append("           P.POD3       ," ).append("\n"); 
		query.append("           P.POD4       ," ).append("\n"); 
		query.append("           P.POD5       ," ).append("\n"); 
		query.append("           P.POD6       ," ).append("\n"); 
		query.append("           P.TS_CONTI" ).append("\n"); 
		query.append("      FROM MDM_LOCATION     L," ).append("\n"); 
		query.append("           MDM_ORGANIZATION O," ).append("\n"); 
		query.append("           PARAMS           P" ).append("\n"); 
		query.append("     WHERE P.RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("       AND O.OFC_CD = P.RHQ_CD" ).append("\n"); 
		query.append("       AND L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT P.YR         ," ).append("\n"); 
		query.append("           P.WK         ," ).append("\n"); 
		query.append("           P.DUR        ," ).append("\n"); 
		query.append("           P.LANE       ," ).append("\n"); 
		query.append("           P.VVD        ," ).append("\n"); 
		query.append("           P.RHQ_CD     ," ).append("\n"); 
		query.append("           P.OFC_CD     ," ).append("\n"); 
		query.append("           NULL AS CONTI," ).append("\n"); 
		query.append("           P.TS_LANE1   ," ).append("\n"); 
		query.append("           P.TS_LANE2   ," ).append("\n"); 
		query.append("           P.TS_LANE3   ," ).append("\n"); 
		query.append("           P.TS_LANE4   ," ).append("\n"); 
		query.append("           P.TS_LANE5   ," ).append("\n"); 
		query.append("           P.TS_LANE6   ," ).append("\n"); 
		query.append("           P.PRE_PST_FLG," ).append("\n"); 
		query.append("           P.POL1       ," ).append("\n"); 
		query.append("           P.POL2       ," ).append("\n"); 
		query.append("           P.POL3       ," ).append("\n"); 
		query.append("           P.POL4       ," ).append("\n"); 
		query.append("           P.POL5       ," ).append("\n"); 
		query.append("           P.POL6       ," ).append("\n"); 
		query.append("           P.POD1       ," ).append("\n"); 
		query.append("           P.POD2       ," ).append("\n"); 
		query.append("           P.POD3       ," ).append("\n"); 
		query.append("           P.POD4       ," ).append("\n"); 
		query.append("           P.POD5       ," ).append("\n"); 
		query.append("           P.POD6       ," ).append("\n"); 
		query.append("           P.TS_CONTI" ).append("\n"); 
		query.append("      FROM PARAMS           P" ).append("\n"); 
		query.append("     WHERE P.RHQ_CD IS NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", WEEKS AS (" ).append("\n"); 
		query.append("    SELECT /*+ INDEX(PRD XPKMAS_WK_PRD)*/" ).append("\n"); 
		query.append("          PRD.COST_YR  ," ).append("\n"); 
		query.append("          PRD.COST_WK  ," ).append("\n"); 
		query.append("          P.LANE       ," ).append("\n"); 
		query.append("          P.VVD        ," ).append("\n"); 
		query.append("          P.RHQ_CD     ," ).append("\n"); 
		query.append("          P.OFC_CD     ," ).append("\n"); 
		query.append("          P.CONTI      ," ).append("\n"); 
		query.append("          P.TS_LANE1   ," ).append("\n"); 
		query.append("          P.TS_LANE2   ," ).append("\n"); 
		query.append("          P.TS_LANE3   ," ).append("\n"); 
		query.append("          P.TS_LANE4   ," ).append("\n"); 
		query.append("          P.TS_LANE5   ," ).append("\n"); 
		query.append("          P.TS_LANE6   ," ).append("\n"); 
		query.append("          P.PRE_PST_FLG," ).append("\n"); 
		query.append("          P.POL1       ," ).append("\n"); 
		query.append("          P.POL2       ," ).append("\n"); 
		query.append("          P.POL3       ," ).append("\n"); 
		query.append("          P.POL4       ," ).append("\n"); 
		query.append("          P.POL5       ," ).append("\n"); 
		query.append("          P.POL6       ," ).append("\n"); 
		query.append("          P.POD1       ," ).append("\n"); 
		query.append("          P.POD2       ," ).append("\n"); 
		query.append("          P.POD3       ," ).append("\n"); 
		query.append("          P.POD4       ," ).append("\n"); 
		query.append("          P.POD5       ," ).append("\n"); 
		query.append("          P.POD6	   ," ).append("\n"); 
		query.append("          P.TS_CONTI" ).append("\n"); 
		query.append("     FROM MAS_WK_PRD PRD," ).append("\n"); 
		query.append("          CPARAMS    P" ).append("\n"); 
		query.append("	WHERE P.VVD IS NULL" ).append("\n"); 
		query.append("	  AND PRD.COST_YR||PRD.COST_WK >= P.YR||P.WK" ).append("\n"); 
		query.append("	  AND ROWNUM <= P.DUR" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VVDS AS (" ).append("\n"); 
		query.append("    SELECT V.TRD_CD     AS REP_TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK," ).append("\n"); 
		query.append("           P.RHQ_CD ," ).append("\n"); 
		query.append("           P.OFC_CD ," ).append("\n"); 
		query.append("           P.CONTI  ," ).append("\n"); 
		query.append("           P.TS_LANE1||P.TS_LANE2||P.TS_LANE3||P.TS_LANE4||P.TS_LANE5||P.TS_LANE6 AS TS_LANE," ).append("\n"); 
		query.append("           P.TS_LANE1   ," ).append("\n"); 
		query.append("           P.TS_LANE2   ," ).append("\n"); 
		query.append("           P.TS_LANE3   ," ).append("\n"); 
		query.append("           P.TS_LANE4   ," ).append("\n"); 
		query.append("           P.TS_LANE5   ," ).append("\n"); 
		query.append("           P.TS_LANE6   ," ).append("\n"); 
		query.append("           P.PRE_PST_FLG," ).append("\n"); 
		query.append("           P.POL1||P.POL2||P.POL3||P.POL4||P.POL5||P.POL6 AS POL," ).append("\n"); 
		query.append("           P.POL1," ).append("\n"); 
		query.append("           P.POL2," ).append("\n"); 
		query.append("           P.POL3," ).append("\n"); 
		query.append("           P.POL4," ).append("\n"); 
		query.append("           P.POL5," ).append("\n"); 
		query.append("           P.POL6," ).append("\n"); 
		query.append("           P.POD1||P.POD2||P.POD3||P.POD4||P.POD5||P.POD6 AS POD," ).append("\n"); 
		query.append("           P.POD1," ).append("\n"); 
		query.append("           P.POD2," ).append("\n"); 
		query.append("           P.POD3," ).append("\n"); 
		query.append("           P.POD4," ).append("\n"); 
		query.append("           P.POD5," ).append("\n"); 
		query.append("           P.POD6," ).append("\n"); 
		query.append("           P.TS_CONTI" ).append("\n"); 
		query.append("      FROM MDM_LOCATION L ," ).append("\n"); 
		query.append("           MDM_REV_LANE RL," ).append("\n"); 
		query.append("           MAS_MON_VVD  V ," ).append("\n"); 
		query.append("           WEEKS        P" ).append("\n"); 
		query.append("     WHERE P.VVD IS NULL" ).append("\n"); 
		query.append("       AND RL.RLANE_CD   = V.RLANE_CD" ).append("\n"); 
		query.append("       AND RL.REP_TRD_CD = V.TRD_CD" ).append("\n"); 
		query.append("       AND V.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("       AND V.RLANE_CD   <> 'RBCCO'" ).append("\n"); 
		query.append("       AND L.LOC_CD      = V.LST_LODG_PORT_CD" ).append("\n"); 
		query.append("       /** CHM-201007114-01 처리" ).append("\n"); 
		query.append("         AND DECODE(L.CONTI_CD, 'F', DECODE(V.RLANE_CD, 'INXTP', 'A', 'E'), L.CONTI_CD) = P.CONTI " ).append("\n"); 
		query.append("       **/" ).append("\n"); 
		query.append("	   AND (P.CONTI IS NULL OR P.CONTI   = SPC_CONTI_CONV_FNC(L.CONTI_CD, V.RLANE_CD, V.DIR_CD)   )" ).append("\n"); 
		query.append("       AND V.RLANE_CD LIKE P.LANE||'%'" ).append("\n"); 
		query.append("       AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK = P.COST_YR||P.COST_WK" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT V.TRD_CD     AS REP_TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK," ).append("\n"); 
		query.append("           P.RHQ_CD ," ).append("\n"); 
		query.append("           P.OFC_CD ," ).append("\n"); 
		query.append("           P.CONTI  ," ).append("\n"); 
		query.append("           P.TS_LANE1||P.TS_LANE2||P.TS_LANE3||P.TS_LANE4||P.TS_LANE5||P.TS_LANE6 AS TS_LANE," ).append("\n"); 
		query.append("           P.TS_LANE1   ," ).append("\n"); 
		query.append("           P.TS_LANE2   ," ).append("\n"); 
		query.append("           P.TS_LANE3   ," ).append("\n"); 
		query.append("           P.TS_LANE4   ," ).append("\n"); 
		query.append("           P.TS_LANE5   ," ).append("\n"); 
		query.append("           P.TS_LANE6   ," ).append("\n"); 
		query.append("           P.PRE_PST_FLG," ).append("\n"); 
		query.append("           P.POL1||P.POL2||P.POL3||P.POL4||P.POL5||P.POL6 AS POL," ).append("\n"); 
		query.append("           P.POL1," ).append("\n"); 
		query.append("           P.POL2," ).append("\n"); 
		query.append("           P.POL3," ).append("\n"); 
		query.append("           P.POL4," ).append("\n"); 
		query.append("           P.POL5," ).append("\n"); 
		query.append("           P.POL6," ).append("\n"); 
		query.append("           P.POD1||P.POD2||P.POD3||P.POD4||P.POD5||P.POD6 AS POD," ).append("\n"); 
		query.append("           P.POD1," ).append("\n"); 
		query.append("           P.POD2," ).append("\n"); 
		query.append("           P.POD3," ).append("\n"); 
		query.append("           P.POD4," ).append("\n"); 
		query.append("           P.POD5," ).append("\n"); 
		query.append("           P.POD6," ).append("\n"); 
		query.append("           P.TS_CONTI" ).append("\n"); 
		query.append("      FROM MDM_LOCATION L ," ).append("\n"); 
		query.append("           MDM_REV_LANE RL," ).append("\n"); 
		query.append("           MAS_MON_VVD  V ," ).append("\n"); 
		query.append("           CPARAMS      P" ).append("\n"); 
		query.append("     WHERE P.VVD IS NOT NULL" ).append("\n"); 
		query.append("       AND RL.RLANE_CD   = V.RLANE_CD" ).append("\n"); 
		query.append("       AND RL.REP_TRD_CD = V.TRD_CD" ).append("\n"); 
		query.append("       AND V.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("       AND V.RLANE_CD   <> 'RBCCO'" ).append("\n"); 
		query.append("       AND L.LOC_CD      = V.LST_LODG_PORT_CD" ).append("\n"); 
		query.append("       /** CHM-201007114-01 처리" ).append("\n"); 
		query.append("       AND DECODE(L.CONTI_CD, 'F', DECODE(V.RLANE_CD, 'INXTP', 'A', 'E'), L.CONTI_CD) = P.CONTI" ).append("\n"); 
		query.append("       **/" ).append("\n"); 
		query.append("	   AND (P.CONTI IS NULL OR P.CONTI   = SPC_CONTI_CONV_FNC(L.CONTI_CD, V.RLANE_CD, V.DIR_CD)   )" ).append("\n"); 
		query.append("       AND V.VSL_CD     = SUBSTR(P.VVD, 1, 4)" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = SUBSTR(P.VVD, 5, 4)" ).append("\n"); 
		query.append("       AND V.DIR_CD     = SUBSTR(P.VVD, 9, 1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BKG AS (" ).append("\n"); 
		query.append("    SELECT YRWK    ," ).append("\n"); 
		query.append("           RLANE_CD," ).append("\n"); 
		query.append("           Z.VVD   ," ).append("\n"); 
		query.append("           NVL(SLAN_CD, 'FDR') AS SLAN_CD," ).append("\n"); 
		query.append("           TS_VVD ," ).append("\n"); 
		query.append("           TS_ETB_DT," ).append("\n"); 
		query.append("           TS2_VVD ," ).append("\n"); 
		query.append("           TS2_ETB_DT," ).append("\n"); 
		query.append("           DECODE(Z.PRE_PST_FLG, 'S', POD_CD, POL_CD) AS TS_PORT ," ).append("\n"); 
		query.append("           DECODE(Z.PRE_PST_FLG, 'S', POL_CD, POD_CD) AS BKG_PORT," ).append("\n"); 
		query.append("           DECODE(Z.OFC_CD, NULL, O.N4TH_PRNT_OFC_CD, NVL(O.N5TH_PRNT_OFC_CD, SLS_OFC_CD)) AS SLS_OFC_CD," ).append("\n"); 
		query.append("           Z.OFC_CD       ," ).append("\n"); 
		query.append("           BKG_TTL_QTY    ," ).append("\n"); 
		query.append("           BKG_RF20_QTY   ," ).append("\n"); 
		query.append("           BKG_RF40_QTY   ," ).append("\n"); 
		query.append("           BKG_TTL_WGT    ," ).append("\n"); 
		query.append("           BKG_20FT_QTY   ," ).append("\n"); 
		query.append("           BKG_40FT_QTY   ," ).append("\n"); 
		query.append("           BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("           BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("           BKG_53FT_QTY   " ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT COST_YR||COST_WK AS YRWK," ).append("\n"); 
		query.append("                     RHQ_CD  ," ).append("\n"); 
		query.append("                     RLANE_CD," ).append("\n"); 
		query.append("                     VVD     ," ).append("\n"); 
		query.append("                     SLAN_CD ," ).append("\n"); 
		query.append("                     TS_VVD   ," ).append("\n"); 
		query.append("                     TS_ETB_DT," ).append("\n"); 
		query.append("                     TS2_VVD   ," ).append("\n"); 
		query.append("                     TS2_ETB_DT," ).append("\n"); 
		query.append("                     POL_CD  ," ).append("\n"); 
		query.append("                     POD_CD  ," ).append("\n"); 
		query.append("                     OB_SLS_OFC_CD AS SLS_OFC_CD," ).append("\n"); 
		query.append("                     OFC_CD     ," ).append("\n"); 
		query.append("                     PRE_PST_FLG," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0))) AS BKG_TTL_QTY    ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 15, 14), 0))) AS BKG_20FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 29, 14), 0))) AS BKG_40FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 43, 14), 0))) AS BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 57, 14), 0))) AS BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 71, 14), 0))) AS BKG_53FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 85, 14), 0))) AS BKG_RF20_QTY   ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0))) AS BKG_RF40_QTY   ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 113, 14), 0))) AS BKG_TTL_WGT" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("							   V.COST_YR," ).append("\n"); 
		query.append("                               V.COST_WK," ).append("\n"); 
		query.append("                               V.RHQ_CD ," ).append("\n"); 
		query.append("                               V.RLANE_CD," ).append("\n"); 
		query.append("                               V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("                               BV.SLAN_CD," ).append("\n"); 
		query.append("                               BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD AS TS_VVD," ).append("\n"); 
		query.append("                               BV1.VSL_CD||BV1.SKD_VOY_NO||BV1.SKD_DIR_CD AS TS2_VVD," ).append("\n"); 
		query.append("                               (SELECT TO_CHAR(VPS_ETB_DT , 'YYYYMMDD')" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                 WHERE VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND VPS_PORT_CD = DECODE(BV.VSL_PRE_PST_CD, 'S', BV.POD_CD, BV.POL_CD)" ).append("\n"); 
		query.append("                                   AND CLPT_IND_SEQ = DECODE(BV.VSL_PRE_PST_CD, 'S', BV.POD_CLPT_IND_SEQ, BV.POL_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                                   AND 'S' <> NVL(SKD_CNG_STS_CD, 'X')) AS TS_ETB_DT,  " ).append("\n"); 
		query.append("                               (SELECT TO_CHAR(VPS_ETB_DT , 'YYYYMMDD')" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                 WHERE VSL_CD = BV1.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO = BV1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD = BV1.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pre_pst_flg} == 'U') " ).append("\n"); 
		query.append("                                   AND VPS_PORT_CD = DECODE(BV1.VSL_PRE_PST_CD, 'S', BV1.POL_CD, BV1.POD_CD)" ).append("\n"); 
		query.append("                                   AND CLPT_IND_SEQ = DECODE(BV1.VSL_PRE_PST_CD, 'S', BV1.POL_CLPT_IND_SEQ, BV1.POD_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                                   AND VPS_PORT_CD = DECODE(BV1.VSL_PRE_PST_CD, 'U', BV1.POD_CD, BV1.POL_CD)" ).append("\n"); 
		query.append("                                   AND CLPT_IND_SEQ = DECODE(BV1.VSL_PRE_PST_CD, 'U', BV1.POD_CLPT_IND_SEQ, BV1.POL_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND 'S' <> NVL(SKD_CNG_STS_CD, 'X')) AS TS2_ETB_DT,                             " ).append("\n"); 
		query.append("                               BV.POL_CD AS POL_CD," ).append("\n"); 
		query.append("                               BV.POD_CD AS POD_CD," ).append("\n"); 
		query.append("                               SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD) AS OB_SLS_OFC_CD," ).append("\n"); 
		query.append("                               V.OFC_CD," ).append("\n"); 
		query.append("                               V.PRE_PST_FLG," ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                 SELECT    TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("										|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '5', Q.OP_CNTR_QTY, '9', Q.OP_CNTR_QTY, '8', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')	--R9,R8에 대해서 R5과 동일하게 HC으로 처리되도록 추가" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '7', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(Q.CNTR_TPSZ_CD, 'DW', Q.OP_CNTR_QTY, 'DX', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'R', DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0), 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'R', DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 0, Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY), 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        || TO_CHAR((R.ACT_WGT * DECODE(R.ACT_WGT,'LBS', 0.00045, 0.001)) + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                                                                                                                                   FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("                                                                                                                                  WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000')" ).append("\n"); 
		query.append("                                   FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                                  WHERE B.BKG_NO = Q.BKG_NO" ).append("\n"); 
		query.append("                               ) VAL," ).append("\n"); 
		query.append("                               V.TS_CONTI" ).append("\n"); 
		query.append("                          FROM BKG_VVD     BV," ).append("\n"); 
		query.append("                               BKG_BOOKING B ," ).append("\n"); 
		query.append("                               VVDS        V ," ).append("\n"); 
		query.append("                               BKG_BL_DOC  R ," ).append("\n"); 
		query.append("                               BKG_VVD     BV1" ).append("\n"); 
		query.append("                         WHERE BV.BKG_NO          = B.BKG_NO" ).append("\n"); 
		query.append("                           AND BV1.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("                           AND B.BKG_NO           = R.BKG_NO" ).append("\n"); 
		query.append("                           AND BV.VSL_PRE_PST_CD IN (V.PRE_PST_FLG)" ).append("\n"); 
		query.append("                           AND B.VSL_CD           = V.VSL_CD" ).append("\n"); 
		query.append("                           AND B.SKD_VOY_NO       = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND B.SKD_DIR_CD       = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND (V.TS_LANE IS NULL OR BV.SLAN_CD IN (V.TS_LANE1, V.TS_LANE2, V.TS_LANE3, V.TS_LANE4, V.TS_LANE5, V.TS_LANE6))" ).append("\n"); 
		query.append("                           AND (V.POL IS NULL OR BV.POL_CD LIKE V.POL1||'%')" ).append("\n"); 
		query.append("                           AND (V.POD IS NULL OR BV.POD_CD LIKE V.POD1||'%')" ).append("\n"); 
		query.append("#if (${pre_pst_flg} == 'U') " ).append("\n"); 
		query.append("                           AND BV1.VSL_SEQ = BV.VSL_SEQ - 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("						   AND BV1.VSL_SEQ = DECODE(BV.VSL_SEQ , (SELECT MAX(VSL_SEQ) FROM BKG_VVD WHERE BKG_NO = BV.BKG_NO AND VSL_PRE_PST_CD = 'S'), 0, (BV.VSL_SEQ + 1))" ).append("\n"); 
		query.append("#end                         " ).append("\n"); 
		query.append("                           AND (V.TS_CONTI IS NULL OR V.TS_CONTI = (SELECT SPC_CONTI_CONV_FNC(CONTI_CD, V.RLANE_CD, V.DIR_CD) FROM MDM_LOCATION " ).append("\n"); 
		query.append("                                                                     WHERE LOC_CD = DECODE(BV.VSL_PRE_PST_CD, 'S', BV.POD_CD, BV.POL_CD)))                           " ).append("\n"); 
		query.append("                           AND B.BKG_STS_CD    IN('W','F')" ).append("\n"); 
		query.append("                           AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("            GROUP BY COST_YR||COST_WK," ).append("\n"); 
		query.append("                     RHQ_CD          ," ).append("\n"); 
		query.append("                     RLANE_CD        ," ).append("\n"); 
		query.append("                     VVD             ," ).append("\n"); 
		query.append("                     SLAN_CD         ," ).append("\n"); 
		query.append("                     TS_VVD          ," ).append("\n"); 
		query.append("                     TS_ETB_DT       ," ).append("\n"); 
		query.append("                     TS2_VVD         ," ).append("\n"); 
		query.append("                     TS2_ETB_DT      ," ).append("\n"); 
		query.append("                     POL_CD          ," ).append("\n"); 
		query.append("                     POD_CD          ," ).append("\n"); 
		query.append("                     OB_SLS_OFC_CD   ," ).append("\n"); 
		query.append("                     OFC_CD          ," ).append("\n"); 
		query.append("                     PRE_PST_FLG" ).append("\n"); 
		query.append("           ) Z," ).append("\n"); 
		query.append("           SPC_OFC_LVL O" ).append("\n"); 
		query.append("     WHERE O.OFC_CD = Z.SLS_OFC_CD" ).append("\n"); 
		query.append("       AND (Z.OFC_CD IS NULL OR O.N4TH_PRNT_OFC_CD = Z.OFC_CD) " ).append("\n"); 
		query.append("	   AND (Z.RHQ_CD IS NULL OR Z.RHQ_CD = O.N2ND_PRNT_OFC_CD)     " ).append("\n"); 
		query.append("       AND Z.YRWK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", BKG_LIST  AS (" ).append("\n"); 
		query.append("  SELECT YRWK," ).append("\n"); 
		query.append("         DECODE(SLAN_CD, 'RBC', 'FDR', SLAN_CD) AS SLAN_CD," ).append("\n"); 
		query.append("         TS_VVD," ).append("\n"); 
		query.append("		 TS_ETB_DT," ).append("\n"); 
		query.append("         TS_PORT," ).append("\n"); 
		query.append("         TS2_VVD," ).append("\n"); 
		query.append("		 TS2_ETB_DT," ).append("\n"); 
		query.append("         BKG_PORT," ).append("\n"); 
		query.append("         SLS_OFC_CD," ).append("\n"); 
		query.append("         RLANE_CD," ).append("\n"); 
		query.append("         VVD," ).append("\n"); 
		query.append("         7 - LOG(2, GROUPING_ID(YRWK, SLAN_CD, TS_VVD, TS_PORT, TS2_VVD, BKG_PORT, SLS_OFC_CD, VVD) + 1) AS LVL," ).append("\n"); 
		query.append("         SUM(BKG_TTL_QTY)     AS BKG_TTL_QTY    ," ).append("\n"); 
		query.append("         SUM(BKG_RF20_QTY)    AS BKG_RF20_QTY   ," ).append("\n"); 
		query.append("         SUM(BKG_RF40_QTY)    AS BKG_RF40_QTY   ," ).append("\n"); 
		query.append("         SUM(BKG_TTL_WGT)     AS BKG_TTL_WGT    ," ).append("\n"); 
		query.append("         SUM(BKG_20FT_QTY)    AS BKG_20FT_QTY   ," ).append("\n"); 
		query.append("         SUM(BKG_40FT_QTY)    AS BKG_40FT_QTY   ," ).append("\n"); 
		query.append("         SUM(BKG_40FT_HC_QTY) AS BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("         SUM(BKG_45FT_HC_QTY) AS BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("         SUM(BKG_53FT_QTY)    AS BKG_53FT_QTY" ).append("\n"); 
		query.append("    FROM BKG B" ).append("\n"); 
		query.append("group by grouping sets (" ).append("\n"); 
		query.append("                         (YRWK, SLAN_CD, TS_VVD, TS_ETB_DT, TS_PORT, TS2_VVD, TS2_ETB_DT, BKG_PORT, SLS_OFC_CD, RLANE_CD, VVD)," ).append("\n"); 
		query.append("                         (YRWK, SLAN_CD, TS_VVD, TS_ETB_DT, TS_PORT, TS2_VVD, TS2_ETB_DT, BKG_PORT, SLS_OFC_CD)," ).append("\n"); 
		query.append("                         (YRWK, SLAN_CD, TS_VVD, TS_ETB_DT, TS_PORT, TS2_VVD, TS2_ETB_DT, BKG_PORT)," ).append("\n"); 
		query.append("                         (YRWK, SLAN_CD, TS_VVD, TS_ETB_DT, TS_PORT, TS2_VVD, TS2_ETB_DT)," ).append("\n"); 
		query.append("                         (YRWK, SLAN_CD, TS_VVD, TS_ETB_DT, TS_PORT)," ).append("\n"); 
		query.append("                         (YRWK, SLAN_CD, TS_VVD)," ).append("\n"); 
		query.append("                         (YRWK, SLAN_CD)" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("ORDER BY YRWK," ).append("\n"); 
		query.append("         DECODE(SLAN_CD, 'FDR', 'ZZZ', SLAN_CD)," ).append("\n"); 
		query.append("         NVL(TS_VVD, 	'000000000')," ).append("\n"); 
		query.append("         NVL(TS_ETB_DT, '00000000')," ).append("\n"); 
		query.append("         NVL(TS_PORT, 	'00000')," ).append("\n"); 
		query.append("         NVL(TS2_VVD, 	'000000000')," ).append("\n"); 
		query.append("         NVL(TS2_ETB_DT,'00000000')," ).append("\n"); 
		query.append("         NVL(BKG_PORT  ,'00000')," ).append("\n"); 
		query.append("         NVL(SLS_OFC_CD,'00000')," ).append("\n"); 
		query.append("         NVL(RLANE_CD  ,'00000')," ).append("\n"); 
		query.append("         VVD," ).append("\n"); 
		query.append("         LVL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    YRWK," ).append("\n"); 
		query.append("    SLAN_CD," ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL)  = 1 THEN" ).append("\n"); 
		query.append("        TS_VVD" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(TS_VVD,'-')" ).append("\n"); 
		query.append("    END TS_VVD," ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL) IN (1,2) THEN" ).append("\n"); 
		query.append("        TS_ETB_DT" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(TS_ETB_DT,'-')" ).append("\n"); 
		query.append("    END TS_ETB_DT," ).append("\n"); 
		query.append("    TS_PORT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	CASE WHEN TRUNC(LVL) IN (1,2,3) THEN" ).append("\n"); 
		query.append("        TS2_VVD" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(TS2_VVD,'-')" ).append("\n"); 
		query.append("    END TS2_VVD," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL) IN (1,2,3) THEN" ).append("\n"); 
		query.append("        TS2_ETB_DT" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(TS2_ETB_DT,'-')" ).append("\n"); 
		query.append("    END TS2_ETB_DT," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    BKG_PORT," ).append("\n"); 
		query.append("    SLS_OFC_CD," ).append("\n"); 
		query.append("    RLANE_CD," ).append("\n"); 
		query.append("    VVD," ).append("\n"); 
		query.append("    LVL," ).append("\n"); 
		query.append("    BKG_TTL_QTY    ," ).append("\n"); 
		query.append("    BKG_RF20_QTY   ," ).append("\n"); 
		query.append("    BKG_RF40_QTY   ," ).append("\n"); 
		query.append("    BKG_TTL_WGT    ," ).append("\n"); 
		query.append("    BKG_20FT_QTY   ," ).append("\n"); 
		query.append("    BKG_40FT_QTY   ," ).append("\n"); 
		query.append("    BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("    BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("    BKG_53FT_QTY" ).append("\n"); 
		query.append("FROM BKG_LIST" ).append("\n"); 

	}
}
