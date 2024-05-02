/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryTradeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.07.20 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchSpaceControlInquiryTradeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * - Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
	  * -2011.06.01 [ CHM-201111305-01] 김종준 R5와 동일하게 R9이 적용될 수 있도록 쿼리수정
	  * -2011.07.05 [ CHM-201111880-01] 김종준control by HO 화면 보완 - IPC, TS 관련
	  * 2012.12.03 [CHM-201221639] 김시몬 R9와 동일하게 R8이 적용될 수 있도록 쿼리수정
	  * - 2013.09.23 [선반영] 김시몬 lodable = 0 인 경우 divid zero 에러 관련 수정
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * 2013.12.05 김시몬 [CHM-201326854] SAQ project로 인한 SPC 변경건_테이블 변경
	  * 2014.01.13 김시몬 [선처리] SELSC/TYOSC RHQ변경에 따른 SQM SPC_OFC_LVL추가
	  * 2014.03.25 김시몬 [선처리] SQM 분기구하는 로직 관련 보완
	  * 2015.03.03 CHM-201534458 SQM QTA주가 변경 관련 적용 요청
	  * 2015.09.16 이혜민 선반영 SPC_CONTI_CONV_FNC 태울때 SLAN_CD를 인자로 가져가던것 RLANE_CD로 수정 (RLANE_CD로 가져가야 제대로 펑션을 탐)
	  * 2016.07.05 CHM-201642241 VGM(BKG상 표시되는 또 다른 WGT 정보) 도입 관련 SPC 사항
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchSpaceControlInquiryTradeListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("only_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_txt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onc_ipc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("week2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryTradeListVORSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("    SELECT @[year]     AS YR_FR     ," ).append("\n"); 
		query.append("           @[week]     AS WK_FR     ," ).append("\n"); 
		query.append("           @[year2]    AS YR_TO     ," ).append("\n"); 
		query.append("           @[week2]    AS WK_TO     ," ).append("\n"); 
		query.append("           SUBSTR(@[rhq_txt],1,5)  AS OFC_CD    ," ).append("\n"); 
		query.append("           @[trade]    AS TRD_CD    ," ).append("\n"); 
		query.append("           @[subtrade] AS SUB_TRD_CD," ).append("\n"); 
		query.append("           @[lane]     AS RLANE_CD  ," ).append("\n"); 
		query.append("           @[bound]    AS DIR_CD    ," ).append("\n"); 
		query.append("           @[onc_ipc]  AS IOC_CD    ," ).append("\n"); 
		query.append("           @[only_vvd] AS VVD" ).append("\n"); 
		query.append("      FROM DUAL  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq_txt} == 'SHARC,SINRS') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT @[year]     AS YR_FR     ," ).append("\n"); 
		query.append("           @[week]     AS WK_FR     ," ).append("\n"); 
		query.append("           @[year2]    AS YR_TO     ," ).append("\n"); 
		query.append("           @[week2]    AS WK_TO     ," ).append("\n"); 
		query.append("           SUBSTR(@[rhq_txt],7,5)  AS OFC_CD    ," ).append("\n"); 
		query.append("           @[trade]    AS TRD_CD    ," ).append("\n"); 
		query.append("           @[subtrade] AS SUB_TRD_CD," ).append("\n"); 
		query.append("           @[lane]     AS RLANE_CD  ," ).append("\n"); 
		query.append("           @[bound]    AS DIR_CD    ," ).append("\n"); 
		query.append("           @[onc_ipc]  AS IOC_CD    ," ).append("\n"); 
		query.append("           @[only_vvd] AS VVD" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VVDS AS (" ).append("\n"); 
		query.append("    SELECT SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           V.SLS_YRMON ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           V.IOC_CD    ," ).append("\n"); 
		query.append("           P.OFC_CD AS OFC_CD    ," ).append("\n"); 
		query.append("           SPC_GET_WK_VVD_BSA_FNC('VOL'    , RL.REP_TRD_CD, V.RLANE_CD, V.DIR_CD, SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD) AS BSA     ," ).append("\n"); 
		query.append("		   SPC_GET_WK_VVD_BSA_FNC('WGT'    , RL.REP_TRD_CD, V.RLANE_CD, V.DIR_CD, SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD) AS BSA_WGT     ," ).append("\n"); 
		query.append("           SPC_GET_WK_VVD_BSA_FNC('VOL_LOD', RL.REP_TRD_CD, V.RLANE_CD, V.DIR_CD, SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD) AS LOADABLE" ).append("\n"); 
		query.append("           , CASE WHEN V.COST_YRMON >= '201501' " ).append("\n"); 
		query.append("                  THEN CEIL(TO_NUMBER(SUBSTR(V.COST_YRMON, -2))/3)||'Q' " ).append("\n"); 
		query.append("                  ELSE CEIL(TO_NUMBER(DECODE(V.COST_WK,'00','01','53','52',V.COST_WK))/13)||'Q'" ).append("\n"); 
		query.append("             END BSE_QTR_CD --2015.03.04 CHM-201534435 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("          , SUBSTR(V.COST_YRMON, 1,4) AS BSE_YR" ).append("\n"); 
		query.append("      FROM MDM_REV_LANE RL," ).append("\n"); 
		query.append("           MAS_MON_VVD  V ," ).append("\n"); 
		query.append("           PARAMS       P" ).append("\n"); 
		query.append("     WHERE RL.RLANE_CD = V.RLANE_CD" ).append("\n"); 
		query.append("       AND V.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("       AND V.IOC_CD     LIKE P.IOC_CD     || '%'" ).append("\n"); 
		query.append("       AND V.DIR_CD     LIKE P.DIR_CD     || '%'" ).append("\n"); 
		query.append("       AND V.RLANE_CD   LIKE P.RLANE_CD   || '%'" ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD LIKE P.SUB_TRD_CD || '%'" ).append("\n"); 
		query.append("       AND V.TRD_CD   <> 'COM'" ).append("\n"); 
		query.append("       AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.TRD_CD LIKE P.TRD_CD || '%'" ).append("\n"); 
		query.append("       AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK BETWEEN YR_FR||WK_FR AND YR_TO||WK_TO" ).append("\n"); 
		query.append("       AND P.VVD IS NULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           V.SLS_YRMON ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           V.IOC_CD," ).append("\n"); 
		query.append("           P.OFC_CD AS OFC_CD    ," ).append("\n"); 
		query.append("           SPC_GET_WK_VVD_BSA_FNC('VOL'    , RL.REP_TRD_CD, V.RLANE_CD, V.DIR_CD, SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD) AS BSA     ," ).append("\n"); 
		query.append("           SPC_GET_WK_VVD_BSA_FNC('WGT'    , RL.REP_TRD_CD, V.RLANE_CD, V.DIR_CD, SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD) AS BSA_WGT," ).append("\n"); 
		query.append("           SPC_GET_WK_VVD_BSA_FNC('VOL_LOD', RL.REP_TRD_CD, V.RLANE_CD, V.DIR_CD, SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD) AS LOADABLE" ).append("\n"); 
		query.append("           , CASE WHEN V.COST_YRMON >= '201501' " ).append("\n"); 
		query.append("                  THEN CEIL(TO_NUMBER(SUBSTR(V.COST_YRMON, -2))/3)||'Q' " ).append("\n"); 
		query.append("                  ELSE CEIL(TO_NUMBER(DECODE(V.COST_WK,'00','01','53','52',V.COST_WK))/13)||'Q'" ).append("\n"); 
		query.append("             END BSE_QTR_CD --2015.03.04 CHM-201534435 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("          , SUBSTR(V.COST_YRMON, 1,4) AS BSE_YR" ).append("\n"); 
		query.append("      FROM MDM_REV_LANE RL," ).append("\n"); 
		query.append("           MAS_MON_VVD  V ," ).append("\n"); 
		query.append("           PARAMS       P" ).append("\n"); 
		query.append("     WHERE RL.RLANE_CD  = V.RLANE_CD" ).append("\n"); 
		query.append("       AND V.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("       AND V.DIR_CD     = SUBSTR(P.VVD, 9, 1)" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = SUBSTR(P.VVD, 5, 4)" ).append("\n"); 
		query.append("       AND V.VSL_CD     = SUBSTR(P.VVD, 1, 4)" ).append("\n"); 
		query.append("       AND V.IOC_CD LIKE P.IOC_CD || '%'" ).append("\n"); 
		query.append("       AND P.VVD IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", QTA_DATA AS (" ).append("\n"); 
		query.append("    SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD    ," ).append("\n"); 
		query.append("           M.OFC_CD    ," ).append("\n"); 
		query.append("           ROUND(SUM(D.LOD_QTY)) AS VOL," ).append("\n"); 
		query.append("           SUM((D.GRS_RPB_REV - D.PA_CM_UC_AMT) * D.LOD_QTY) AS CM" ).append("\n"); 
		query.append("      FROM VVDS             M," ).append("\n"); 
		query.append("           SQM_CFM_QTA      D," ).append("\n"); 
		query.append("           SQM_QTA_RLSE_VER B," ).append("\n"); 
		query.append("           SPC_OFC_LVL      O" ).append("\n"); 
		query.append("     WHERE B.BSE_YR           = M.BSE_YR" ).append("\n"); 
		query.append("       --AND B.BSE_QTR_CD       = CEIL(TO_NUMBER(DECODE(M.COST_WK,'00','01','53','52',M.COST_WK))/13)||'Q' --CEIL(TO_NUMBER(SUBSTR(M.SLS_YRMON, 5, 2)) / 3)||'Q'" ).append("\n"); 
		query.append("	   -- CHM-201534458 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("	   AND B.BSE_QTR_CD      = M.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND B.SQM_VER_STS_CD   = 'R'" ).append("\n"); 
		query.append("       AND B.BSE_TP_CD        = 'Q' -- 분기 20131205추가" ).append("\n"); 
		query.append("       AND D.QTA_RLSE_VER_NO  = B.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("       AND D.BSE_TP_CD        = B.BSE_TP_CD -- 분기 20131205추가 " ).append("\n"); 
		query.append("       AND D.BSE_YR           = B.BSE_YR" ).append("\n"); 
		query.append("       AND D.BSE_QTR_CD       = B.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND D.QTA_TGT_CD       = 'D'" ).append("\n"); 
		query.append("       AND D.OFC_VW_CD        = 'L'  -- 20131205추가" ).append("\n"); 
		query.append("       AND D.TRD_CD           = M.TRD_CD" ).append("\n"); 
		query.append("       AND D.RLANE_CD         = M.RLANE_CD" ).append("\n"); 
		query.append("       AND D.DIR_CD           = M.DIR_CD" ).append("\n"); 
		query.append("       AND D.VSL_CD           = M.VSL_CD" ).append("\n"); 
		query.append("       AND D.SKD_VOY_NO       = M.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND D.SKD_DIR_CD       = M.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND (M.OFC_CD IS NULL OR O.N2ND_PRNT_OFC_CD = M.OFC_CD OR D.AQ_CD = M.OFC_CD)" ).append("\n"); 
		query.append("       AND M.COST_YR || M.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("       --AND D.RGN_OFC_CD        = O.OFC_CD" ).append("\n"); 
		query.append("       AND (" ).append("\n"); 
		query.append("             SELECT NVL(MAX(ROC.CONV_RGN_OFC_CD), D.RGN_OFC_CD)" ).append("\n"); 
		query.append("               FROM SPC_RGN_OFC_CONV ROC" ).append("\n"); 
		query.append("              WHERE ROC.SLS_RGN_OFC_CD = D.RGN_OFC_CD" ).append("\n"); 
		query.append("           ) = O.OFC_CD" ).append("\n"); 
		query.append("  GROUP BY M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD	   ," ).append("\n"); 
		query.append("           M.OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", FCST_DATA AS (" ).append("\n"); 
		query.append("    SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD    ," ).append("\n"); 
		query.append("           M.OFC_CD    ," ).append("\n"); 
		query.append("           NVL(SUM(DECODE(D.IOC_TS_CD, 'T', 0, NVL(D.CFM_TTL_QTY, 0) + NVL(D.FCAST_40FT_HC_QTY, 0) * 2 + NVL(D.FCAST_45FT_HC_QTY, 0) * 2 +  NVL(D.FCAST_53FT_QTY, 0) * 2)),0)  AS VOL," ).append("\n"); 
		query.append("           NVL(SUM(DECODE(D.IOC_TS_CD, 'T', 0, D.CFM_TTL_WGT)),0) AS WGT," ).append("\n"); 
		query.append("           NVL(SUM(DECODE(D.IOC_TS_CD, 'T', NVL(D.CFM_TTL_QTY, 0) + NVL(D.FCAST_40FT_HC_QTY, 0) * 2 + NVL(D.FCAST_45FT_HC_QTY, 0) * 2 +  NVL(D.FCAST_53FT_QTY, 0) * 2)),0)  AS FCT_TC_VOL," ).append("\n"); 
		query.append("           NVL(SUM(DECODE(D.IOC_TS_CD, 'T', D.CFM_TTL_WGT)),0) FCT_TC_WGT" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("      FROM VVDS               M," ).append("\n"); 
		query.append("           SPC_DLY_FCAST_CUST D" ).append("\n"); 
		query.append("     WHERE D.TRD_CD     = M.TRD_CD" ).append("\n"); 
		query.append("       AND D.SUB_TRD_CD = M.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND D.RLANE_CD   = M.RLANE_CD" ).append("\n"); 
		query.append("       AND D.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("       AND D.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("       AND D.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND D.SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND D.IOC_CD  = M.IOC_CD  -- AND D.IOC_TS_CD  = M.IOC_CD" ).append("\n"); 
		query.append("       AND (M.OFC_CD IS NULL OR D.SLS_RHQ_CD = M.OFC_CD OR D.SLS_AQ_CD = M.OFC_CD)" ).append("\n"); 
		query.append("  GROUP BY M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD	   ," ).append("\n"); 
		query.append("           M.OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ALOC_DATA AS (" ).append("\n"); 
		query.append("    SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD    ," ).append("\n"); 
		query.append("           M.OFC_CD    ," ).append("\n"); 
		query.append("           SUM(DECODE(D.TS_FLG, 'N', D.ASGN_TTL_QTY)) AS VOL," ).append("\n"); 
		query.append("           SUM(DECODE(D.TS_FLG, 'N', D.ASGN_TTL_WGT)) AS WGT," ).append("\n"); 
		query.append("           SUM(DECODE(D.TS_FLG, 'Y', D.ASGN_TTL_QTY)) AS ALC_TS_VOL," ).append("\n"); 
		query.append("           SUM(DECODE(D.TS_FLG, 'Y', D.ASGN_TTL_WGT)) AS ALC_TS_WGT " ).append("\n"); 
		query.append("      FROM VVDS             M," ).append("\n"); 
		query.append("           SPC_ALOC_POL_POD D" ).append("\n"); 
		query.append("     WHERE D.TRD_CD     = M.TRD_CD" ).append("\n"); 
		query.append("       AND D.SUB_TRD_CD = M.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND D.RLANE_CD   = M.RLANE_CD" ).append("\n"); 
		query.append("       AND D.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("       AND D.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("       AND D.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND D.SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND DECODE(TS_FLG, 'Y', DECODE(D.RLANE_CD, 'IMUAE', 'O', D.IOC_CD), D.IOC_CD) = M.IOC_CD" ).append("\n"); 
		query.append("       AND (M.OFC_CD IS NULL OR D.SLS_RHQ_CD = M.OFC_CD OR D.SLS_AQ_CD = M.OFC_CD)" ).append("\n"); 
		query.append("       AND DECODE(TS_FLG, 'N', '1', DECODE(M.OFC_CD, M.OFC_CD, '1', SLS_RHQ_CD)) = DECODE(TS_FLG, 'N', '1', DECODE(M.OFC_CD, M.OFC_CD, '1', SLS_OFC_CD))" ).append("\n"); 
		query.append("  GROUP BY M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD	   ," ).append("\n"); 
		query.append("           M.OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BKG_DATA AS (" ).append("\n"); 
		query.append("    SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD    ," ).append("\n"); 
		query.append("           M.OFC_CD    ," ).append("\n"); 
		query.append("           SUM(TTL_FIRM) AS TTL_FIRM, " ).append("\n"); 
		query.append("           SUM(TTL_WAIT) AS TTL_WAIT," ).append("\n"); 
		query.append("           SUM(WGT) AS WGT," ).append("\n"); 
		query.append("           SUM(BKG_VOL_VGM) AS BKG_VOL_VGM," ).append("\n"); 
		query.append("		   SUM(BKG_WGT_VGM) AS BKG_WGT_VGM," ).append("\n"); 
		query.append("           SUM(BKG_TS_VOL) AS BKG_TS_VOL," ).append("\n"); 
		query.append("           SUM(BKG_TS_WGT) AS BKG_TS_WGT," ).append("\n"); 
		query.append("           SUM(BKG_TS_VOL_VGM) AS BKG_TS_VOL_VGM," ).append("\n"); 
		query.append("		   SUM(BKG_TS_WGT_VGM) AS BKG_TS_WGT_VGM" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("                   M.SUB_TRD_CD," ).append("\n"); 
		query.append("                   M.RLANE_CD  ," ).append("\n"); 
		query.append("                   M.DIR_CD    ," ).append("\n"); 
		query.append("                   M.COST_YR   ," ).append("\n"); 
		query.append("                   M.COST_WK   ," ).append("\n"); 
		query.append("                   M.VSL_CD    ," ).append("\n"); 
		query.append("                   M.SKD_VOY_NO," ).append("\n"); 
		query.append("                   M.SKD_DIR_CD," ).append("\n"); 
		query.append("                   M.IOC_CD    ," ).append("\n"); 
		query.append("                   M.OFC_CD    ," ).append("\n"); 
		query.append("                   DECODE(TS_FLG, 'N',DECODE(BKG_STS_CD, 'F', TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)), 0)) AS TTL_FIRM," ).append("\n"); 
		query.append("                   DECODE(TS_FLG, 'N',DECODE(BKG_STS_CD, 'W', TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)), 0)) AS TTL_WAIT," ).append("\n"); 
		query.append("                   DECODE(TS_FLG, 'N',TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0))) AS WGT, " ).append("\n"); 
		query.append("                   DECODE(TS_FLG, 'N', BKG_VOL_VGM,0) AS BKG_VOL_VGM, " ).append("\n"); 
		query.append("				   DECODE(TS_FLG, 'N', BKG_WGT_VGM,0) AS BKG_WGT_VGM, " ).append("\n"); 
		query.append("                   DECODE(TS_FLG, 'Y', TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0))) AS BKG_TS_VOL," ).append("\n"); 
		query.append("                   DECODE(TS_FLG, 'Y', TO_NUMBER(NVL(SUBSTR(VAL,  99, 14), 0))) AS BKG_TS_WGT," ).append("\n"); 
		query.append("                   DECODE(TS_FLG, 'Y', BKG_VOL_VGM,0) AS BKG_TS_VOL_VGM," ).append("\n"); 
		query.append("				   DECODE(TS_FLG, 'Y', BKG_WGT_VGM,0) AS BKG_TS_WGT_VGM" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                   SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("                       M.SUB_TRD_CD," ).append("\n"); 
		query.append("                       M.RLANE_CD  ," ).append("\n"); 
		query.append("                       M.DIR_CD    ," ).append("\n"); 
		query.append("                       M.COST_YR   ," ).append("\n"); 
		query.append("                       M.COST_WK   ," ).append("\n"); 
		query.append("                       M.VSL_CD    ," ).append("\n"); 
		query.append("                       M.SKD_VOY_NO," ).append("\n"); 
		query.append("                       M.SKD_DIR_CD," ).append("\n"); 
		query.append("                       M.IOC_CD    ," ).append("\n"); 
		query.append("                       B.BKG_STS_CD ," ).append("\n"); 
		query.append("                       M.OFC_CD 	," ).append("\n"); 
		query.append("          			   (SELECT  TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY), 'FM0000000000.000') " ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '5', Q.OP_CNTR_QTY, '9', Q.OP_CNTR_QTY, '8', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')	--R9,R8에 대해서 R5과 동일하게 HC으로 처리되도록 추가" ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '7', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')  " ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(Q.CNTR_TPSZ_CD, 'DW', Q.OP_CNTR_QTY, 'DX', Q.OP_CNTR_QTY, 0)) , 'FM0000000000.000')  " ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 1, 1), 'R', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("								|| TO_CHAR((R.ACT_WGT * DECODE(R.ACT_WGT,'LBS', 0.00045, 0.001)) " ).append("\n"); 
		query.append("										+ SUM(Q.OP_CNTR_QTY * (SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                   												 FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("                  												WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000')" ).append("\n"); 
		query.append("               		 		  FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("              	    		 WHERE B.BKG_NO = Q.BKG_NO) VAL," ).append("\n"); 
		query.append("                       BV.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("						DECODE(BV.VSL_PRE_PST_CD, 'T', 'N', 'Y') AS TS_FLG" ).append("\n"); 
		query.append("						,(" ).append("\n"); 
		query.append("						SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Z.CNTR_TPSZ_CD), '2', 1, 2)* Z.OP_CNTR_QTY) " ).append("\n"); 
		query.append("						FROM BKG_QUANTITY Z " ).append("\n"); 
		query.append("						WHERE Z.BKG_NO= B.BKG_NO AND OP_CNTR_QTY > 0 " ).append("\n"); 
		query.append("						AND EXISTS ( SELECT 1 FROM BKG_CONTAINER C WHERE C.BKG_NO= Z.BKG_NO AND VGM_WGT>0 AND VGM_WGT IS NOT NULL )" ).append("\n"); 
		query.append("						) AS BKG_VOL_VGM						" ).append("\n"); 
		query.append("						,(SELECT SUM(NVL(Z.VGM_WGT,0) * DECODE(Z.VGM_WGT_UT_CD,'LBS',0.00045,0.001)) FROM BKG_CONTAINER Z WHERE Z.BKG_NO= B.BKG_NO AND VGM_WGT>0 AND VGM_WGT IS NOT NULL) AS BKG_WGT_VGM" ).append("\n"); 
		query.append("                  FROM BKG_VVD BV," ).append("\n"); 
		query.append("                       BKG_BOOKING        B  ," ).append("\n"); 
		query.append("                       VVDS      M,   " ).append("\n"); 
		query.append("                       BKG_BL_DOC  R ," ).append("\n"); 
		query.append("                       MDM_DTL_REV_LANE   DRL," ).append("\n"); 
		query.append("                       MDM_REV_LANE       RL ,          " ).append("\n"); 
		query.append("                       SPC_OFC_LVL O" ).append("\n"); 
		query.append("                 WHERE B.BKG_NO         = BV.BKG_NO" ).append("\n"); 
		query.append("                   AND B.BKG_NO           = R.BKG_NO" ).append("\n"); 
		query.append("                   AND B.BKG_STS_CD    IN ('W','F')" ).append("\n"); 
		query.append("                   AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             	   AND M.VSL_CD         = BV.VSL_CD" ).append("\n"); 
		query.append("            	   AND M.SKD_VOY_NO     = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("            	   AND M.SKD_DIR_CD     = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   AND RL.VSL_SLAN_CD = BV.SLAN_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                   AND (M.OFC_CD IS NULL OR M.OFC_CD = (SELECT N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("                                                         FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                                                        WHERE OFC_CD = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD, '')" ).append("\n"); 
		query.append("                                                          AND M.COST_YR || M.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK)" ).append("\n"); 
		query.append("                                         OR M.OFC_CD = (SELECT N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                                                         FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                                                        WHERE OFC_CD = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD, '')" ).append("\n"); 
		query.append("                                                          AND M.COST_YR || M.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK))" ).append("\n"); 
		query.append("                   AND O.OFC_CD         = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD)                   " ).append("\n"); 
		query.append("                   AND M.COST_YR || M.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                   AND DRL.RLANE_CD        = M.RLANE_CD" ).append("\n"); 
		query.append("                   AND DRL.VSL_SLAN_DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append("                   AND DRL.IOC_CD          = M.IOC_CD " ).append("\n"); 
		query.append("                   AND DRL.TRD_CD          = M.TRD_CD" ).append("\n"); 
		query.append("                   AND DRL.SUB_TRD_CD      = M.SUB_TRD_CD" ).append("\n"); 
		query.append("                   AND DRL.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("                   AND DRL.RLANE_CD        = RL.RLANE_CD" ).append("\n"); 
		query.append("                   AND DRL.FM_CONTI_CD     =( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, M.RLANE_CD, M.DIR_CD)" ).append("\n"); 
		query.append("                                                FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                                               WHERE L.LOC_CD = BV.POL_CD )" ).append("\n"); 
		query.append("                   AND DRL.TO_CONTI_CD     =( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, M.RLANE_CD, M.DIR_CD)" ).append("\n"); 
		query.append("                                                FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                                               WHERE L.LOC_CD = BV.POD_CD )" ).append("\n"); 
		query.append("                   AND RL.RLANE_CD    = M.RLANE_CD" ).append("\n"); 
		query.append("                   AND RL.VSL_TP_CD   = 'C'" ).append("\n"); 
		query.append("                   AND RL.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("               ) M" ).append("\n"); 
		query.append("         ) M" ).append("\n"); 
		query.append("  GROUP BY M.TRD_CD    ," ).append("\n"); 
		query.append("          M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD	   ," ).append("\n"); 
		query.append("           M.OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  SELECT Z.TRD_CD    ," ).append("\n"); 
		query.append("         Z.SUB_TRD_CD," ).append("\n"); 
		query.append("         Z.RLANE_CD  ," ).append("\n"); 
		query.append("         Z.DIR_CD    ," ).append("\n"); 
		query.append("         Z.IOC_CD    ," ).append("\n"); 
		query.append("         Z.COST_YR||Z.COST_WK                 AS COST_WK," ).append("\n"); 
		query.append("         Z.VSL_CD||Z.SKD_VOY_NO||Z.SKD_DIR_CD AS VVD    ," ).append("\n"); 
		query.append("         V.BSA     ,V.BSA_WGT     ," ).append("\n"); 
		query.append("         V.LOADABLE," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         --DECODE(V.BSA, 0, 100, SUM(FCT_VOL) / V.LOADABLE * 100) AS LF," ).append("\n"); 
		query.append("         DECODE(V.BSA, 0, 100, DECODE(V.LOADABLE,0,100,SUM(FCT_VOL) / V.LOADABLE * 100)) AS LF," ).append("\n"); 
		query.append("		 DECODE(V.BSA_WGT, 0, 100, DECODE(V.BSA_WGT,0,100,SUM(BKG_WGT) / V.BSA_WGT * 100)) AS WGT_LF," ).append("\n"); 
		query.append("         SUM(QTA_VOL)             AS QTA_VOL ," ).append("\n"); 
		query.append("         SUM(QTA_CMB)             AS QTA_CMB ," ).append("\n"); 
		query.append("         SUM(FCT_VOL)             AS FCT_VOL ," ).append("\n"); 
		query.append("         SUM(FCT_WGT)             AS FCT_WGT ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         SUM(FCT_TC_VOL)          AS FCT_TC_VOL ," ).append("\n"); 
		query.append("         SUM(FCT_TC_WGT)          AS FCT_TC_WGT ," ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         SUM(ALC_VOL)             AS ALC_VOL ," ).append("\n"); 
		query.append("         SUM(ALC_WGT)             AS ALC_WGT ," ).append("\n"); 
		query.append("         SUM(ALC_TS_VOL)          AS ALC_TS_VOL  ," ).append("\n"); 
		query.append("         SUM(ALC_TS_WGT)          AS ALC_TS_WGT  ," ).append("\n"); 
		query.append("         SUM(BKG_FIRM)            AS BKG_FIRM," ).append("\n"); 
		query.append("         SUM(BKG_WAIT)            AS BKG_WAIT," ).append("\n"); 
		query.append("         SUM(BKG_FIRM + BKG_WAIT) AS BKG_TTL ," ).append("\n"); 
		query.append("         SUM(BKG_WGT)             AS BKG_WGT," ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         SUM(BKG_TS_VOL)          AS BKG_TS_VOL," ).append("\n"); 
		query.append("         SUM(BKG_TS_WGT)          AS BKG_TS_WGT" ).append("\n"); 
		query.append("         ,NVL(SUM(BKG_VOL_VGM),0)        AS BKG_VOL_VGM" ).append("\n"); 
		query.append("		 ,NVL(SUM(BKG_WGT_VGM),0)        AS BKG_WGT_VGM" ).append("\n"); 
		query.append("         ,NVL(SUM(BKG_TS_VOL_VGM),0)     AS BKG_TS_VOL_VGM" ).append("\n"); 
		query.append("		 ,NVL(SUM(BKG_TS_WGT_VGM),0)     AS BKG_TS_WGT_VGM" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR   ," ).append("\n"); 
		query.append("                   COST_WK   ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   IOC_CD    ," ).append("\n"); 
		query.append("                   OFC_CD    ," ).append("\n"); 
		query.append("                   VOL  AS QTA_VOL ," ).append("\n"); 
		query.append("                   DECODE(VOL, 0, 0, CM / VOL) AS QTA_CMB," ).append("\n"); 
		query.append("                   NULL AS FCT_VOL ," ).append("\n"); 
		query.append("                   NULL AS FCT_WGT ," ).append("\n"); 
		query.append("                   NULL AS FCT_TC_VOL ," ).append("\n"); 
		query.append("                   NULL AS FCT_TC_WGT ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   NULL AS ALC_VOL ," ).append("\n"); 
		query.append("                   NULL AS ALC_WGT ," ).append("\n"); 
		query.append("                   NULL AS ALC_TS_VOL  ," ).append("\n"); 
		query.append("                   NULL AS ALC_TS_WGT  ," ).append("\n"); 
		query.append("                   NULL AS BKG_FIRM," ).append("\n"); 
		query.append("                   NULL AS BKG_WAIT," ).append("\n"); 
		query.append("                   NULL AS BKG_WGT," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   NULL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                   NULL AS BKG_TS_WGT" ).append("\n"); 
		query.append("                   ,NULL BKG_VOL_VGM,NULL BKG_WGT_VGM" ).append("\n"); 
		query.append("				   ,NULL BKG_TS_VOL_VGM,NULL BKG_TS_WGT_VGM" ).append("\n"); 
		query.append("              FROM QTA_DATA" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR   ," ).append("\n"); 
		query.append("                   COST_WK   ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   IOC_CD    ," ).append("\n"); 
		query.append("                   OFC_CD    ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   VOL       ," ).append("\n"); 
		query.append("                   WGT       ," ).append("\n"); 
		query.append("                   FCT_TC_VOL AS FCT_TC_VOL ," ).append("\n"); 
		query.append("                   FCT_TC_WGT AS FCT_TC_WGT ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   NULL AS ALC_TS_VOL  ," ).append("\n"); 
		query.append("                   NULL AS ALC_TS_WGT  ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL     ," ).append("\n"); 
		query.append("                   NULL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                   NULL AS BKG_TS_WGT" ).append("\n"); 
		query.append("                   ,NULL BKG_WGT_VGM" ).append("\n"); 
		query.append("				   ,NULL BKG_VOL_VGM" ).append("\n"); 
		query.append("				   ,NULL BKG_TS_WGT_VGM" ).append("\n"); 
		query.append("				   ,NULL BKG_TS_VOL_VGM" ).append("\n"); 
		query.append("              FROM FCST_DATA" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR   ," ).append("\n"); 
		query.append("                   COST_WK   ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   IOC_CD    ," ).append("\n"); 
		query.append("                   OFC_CD    ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL AS FCT_TC_VOL ," ).append("\n"); 
		query.append("                   NULL AS FCT_TC_WGT ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   VOL       ," ).append("\n"); 
		query.append("                   WGT       ," ).append("\n"); 
		query.append("                   ALC_TS_VOL AS ALC_TS_VOL  ," ).append("\n"); 
		query.append("                   ALC_TS_WGT AS ALC_TS_WGT  ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL," ).append("\n"); 
		query.append("                   NULL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                   NULL AS BKG_TS_WGT                   " ).append("\n"); 
		query.append("                   ,NULL BKG_VOL_VGM" ).append("\n"); 
		query.append("				   ,NULL BKG_WGT_VGM" ).append("\n"); 
		query.append("				   ,NULL BKG_TS_VOL_VGM" ).append("\n"); 
		query.append("				   ,NULL BKG_TS_WGT_VGM" ).append("\n"); 
		query.append("              FROM ALOC_DATA" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR   ," ).append("\n"); 
		query.append("                   COST_WK   ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   IOC_CD    ," ).append("\n"); 
		query.append("                   OFC_CD    ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL AS FCT_TC_VOL ," ).append("\n"); 
		query.append("                   NULL AS FCT_TC_WGT ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL AS ALC_TS_VOL  ," ).append("\n"); 
		query.append("                   NULL AS ALC_TS_WGT  ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   TTL_FIRM  ," ).append("\n"); 
		query.append("                   TTL_WAIT  ," ).append("\n"); 
		query.append("                   WGT," ).append("\n"); 
		query.append("                   BKG_TS_VOL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                   BKG_TS_WGT AS BKG_TS_WGT              " ).append("\n"); 
		query.append("                   ,BKG_VOL_VGM" ).append("\n"); 
		query.append("				   ,BKG_WGT_VGM" ).append("\n"); 
		query.append("				   ,BKG_TS_VOL_VGM " ).append("\n"); 
		query.append("				   ,BKG_TS_WGT_VGM " ).append("\n"); 
		query.append("              FROM BKG_DATA" ).append("\n"); 
		query.append("         ) Z," ).append("\n"); 
		query.append("         VVDS V" ).append("\n"); 
		query.append("   WHERE Z.TRD_CD     = V.TRD_CD" ).append("\n"); 
		query.append("     AND Z.SUB_TRD_CD = V.SUB_TRD_CD" ).append("\n"); 
		query.append("     AND Z.RLANE_CD   = V.RLANE_CD" ).append("\n"); 
		query.append("     AND Z.DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("     AND Z.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("     AND Z.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND Z.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND Z.IOC_CD     = V.IOC_CD" ).append("\n"); 
		query.append("     AND Z.OFC_CD     = V.OFC_CD" ).append("\n"); 
		query.append("GROUP BY Z.TRD_CD    ," ).append("\n"); 
		query.append("         Z.SUB_TRD_CD," ).append("\n"); 
		query.append("         Z.RLANE_CD  ," ).append("\n"); 
		query.append("         Z.DIR_CD    ," ).append("\n"); 
		query.append("         V.BSA       ,V.BSA_WGT," ).append("\n"); 
		query.append("         V.LOADABLE  ," ).append("\n"); 
		query.append("         Z.COST_YR   ," ).append("\n"); 
		query.append("         Z.COST_WK   ," ).append("\n"); 
		query.append("         Z.VSL_CD    ," ).append("\n"); 
		query.append("         Z.SKD_VOY_NO," ).append("\n"); 
		query.append("         Z.SKD_DIR_CD," ).append("\n"); 
		query.append("         Z.IOC_CD" ).append("\n"); 
		query.append("ORDER BY Z.TRD_CD    , " ).append("\n"); 
		query.append("         Z.SUB_TRD_CD," ).append("\n"); 
		query.append("         Z.RLANE_CD  ," ).append("\n"); 
		query.append("         Z.DIR_CD    ," ).append("\n"); 
		query.append("         Z.COST_YR   ," ).append("\n"); 
		query.append("         Z.COST_WK   ," ).append("\n"); 
		query.append("         Z.VSL_CD    ," ).append("\n"); 
		query.append("         Z.SKD_VOY_NO," ).append("\n"); 
		query.append("         Z.SKD_DIR_CD," ).append("\n"); 
		query.append("         Z.IOC_CD" ).append("\n"); 

	}
}