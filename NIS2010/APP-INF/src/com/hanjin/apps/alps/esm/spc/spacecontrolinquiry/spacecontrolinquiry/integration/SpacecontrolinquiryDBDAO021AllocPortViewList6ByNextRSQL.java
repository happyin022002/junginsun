/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAO021AllocPortViewList6ByNextRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.12.17 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAO021AllocPortViewList6ByNextRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 한국지점 팀별 차주 Projection 현황
	  * 2012.11.22 최윤성 [CHM-201221575-01] Daily Forecast Status - FCST&BKG PFMC by S.Office 탭 전일에 대한 BSE_DT를 History 의 MAX 을 가지고 오도록 수정
	  * 2013.12.05 김시몬 [CHM-201326854] SAQ project로 인한 SPC 변경건_테이블 변경
	  * 2014.01.13 김시몬 [선처리] SELSC/TYOSC RHQ변경에 따른 SQM SPC_OFC_LVL추가
	  * 2014.03.25 김시몬 [선처리] SQM 분기구하는 로직 관련 보완
	  * 2015.03.03 CHM-201534458 SQM QTA주가 변경 관련 적용 요청
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAO021AllocPortViewList6ByNextRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_office1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAO021AllocPortViewList6ByNextRSQL").append("\n"); 
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
		query.append("WITH VVDS AS (" ).append("\n"); 
		query.append("    SELECT   DISTINCT " ).append("\n"); 
		query.append("             PRE.TRD_CD" ).append("\n"); 
		query.append("           , PRE.RLANE_CD" ).append("\n"); 
		query.append("           , PRE.VSL_CD" ).append("\n"); 
		query.append("           , PRE.SKD_VOY_NO" ).append("\n"); 
		query.append("           , PRE.DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("           , SPC_CONTI_CONV_FNC(R.TO_CONTI_CD, PRE.RLANE_CD, PRE.DIR_CD) AS CONTI_CD" ).append("\n"); 
		query.append("           , TO_CHAR(S.VPS_ETD_DT, 'YYYYMMDD') AS PUS_ETD_DT" ).append("\n"); 
		query.append("           , PRE.SLS_YRMON" ).append("\n"); 
		query.append("           , PRE.COST_WK" ).append("\n"); 
		query.append("           , @[rhq1] AS SLS_RHQ_CD" ).append("\n"); 
		query.append("           , @[sales_office1] AS SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("           , CASE WHEN PRE.COST_YRMON >= '201501' " ).append("\n"); 
		query.append("                  THEN CEIL(TO_NUMBER(SUBSTR(PRE.COST_YRMON, -2))/3)||'Q' " ).append("\n"); 
		query.append("                  ELSE CEIL(TO_NUMBER(DECODE(PRE.COST_WK,'00','01','53','52',PRE.COST_WK))/13)||'Q'" ).append("\n"); 
		query.append("             END BSE_QTR_CD --2015.03.04 CHM-201534435 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("           , SUBSTR(PRE.COST_YRMON, 1,4) AS BSE_YR" ).append("\n"); 
		query.append("        FROM MAS_MON_VVD PRE" ).append("\n"); 
		query.append("           , VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("           , MDM_DTL_REV_LANE R" ).append("\n"); 
		query.append("     WHERE PRE.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND SUBSTR(PRE.SLS_YRMON, 1, 4)||PRE.COST_WK = (" ).append("\n"); 
		query.append("                                                       SELECT MIN(SUBSTR(M1.SLS_YRMON, 1, 4)||M1.COST_WK)" ).append("\n"); 
		query.append("                                                         FROM MAS_MON_VVD M1," ).append("\n"); 
		query.append("                                                              MAS_MON_VVD M," ).append("\n"); 
		query.append("                                                              SPC_TGT_VVD S" ).append("\n"); 
		query.append("                                                        WHERE M1.TRD_CD = PRE.TRD_CD" ).append("\n"); 
		query.append("                                                          AND M1.RLANE_CD = PRE.RLANE_CD" ).append("\n"); 
		query.append("                                                          AND M1.DIR_CD = PRE.DIR_CD" ).append("\n"); 
		query.append("                                                          AND M1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                          AND M1.TRD_CD = M.TRD_CD" ).append("\n"); 
		query.append("                                                          AND M1.RLANE_CD = M.RLANE_CD" ).append("\n"); 
		query.append("                                                          AND M1.DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append("                                                          AND M.TRD_CD = S.TRD_CD" ).append("\n"); 
		query.append("                                                          AND M.RLANE_CD = S.RLANE_CD" ).append("\n"); 
		query.append("                                                          AND M.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("                                                          AND M.SKD_VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                          AND M.DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                          AND SUBSTR(M1.SLS_YRMON, 1, 4)||M1.COST_WK > SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("       AND S.VSL_CD = PRE.VSL_CD" ).append("\n"); 
		query.append("       AND S.SKD_VOY_NO = PRE.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND S.SKD_DIR_CD = PRE.DIR_CD" ).append("\n"); 
		query.append("       AND S.VPS_PORT_CD = 'KRPUS'" ).append("\n"); 
		query.append("       AND NVL(S.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("       AND S.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("       AND PRE.TRD_CD  = R.TRD_CD" ).append("\n"); 
		query.append("       AND PRE.RLANE_CD = R.RLANE_CD" ).append("\n"); 
		query.append("       AND R.FM_CONTI_CD = 'A'" ).append("\n"); 
		query.append("       AND R.TO_CONTI_CD = DECODE(PRE.TRD_CD, 'EMS', 'M', R.TO_CONTI_CD)" ).append("\n"); 
		query.append("       AND CLPT_IND_SEQ = (SELECT MIN(CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                             FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                            WHERE VSL_CD = PRE.VSL_CD" ).append("\n"); 
		query.append("                              AND SKD_VOY_NO = PRE.SKD_VOY_NO" ).append("\n"); 
		query.append("                              AND SKD_DIR_CD = PRE.DIR_CD" ).append("\n"); 
		query.append("                              AND VPS_PORT_CD = S.VPS_PORT_CD" ).append("\n"); 
		query.append("                              AND NVL(SKD_CNG_STS_CD, 'X') <> 'S' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", HIS_DATA AS (" ).append("\n"); 
		query.append("    SELECT D.TRD_CD," ).append("\n"); 
		query.append("           D.RLANE_CD," ).append("\n"); 
		query.append("           D.VSL_CD," ).append("\n"); 
		query.append("           D.SKD_VOY_NO," ).append("\n"); 
		query.append("           D.SKD_DIR_CD," ).append("\n"); 
		query.append("           T.CONTI_CD," ).append("\n"); 
		query.append("           T.PUS_ETD_DT," ).append("\n"); 
		query.append("           D.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           D.SLS_OFC_CD," ).append("\n"); 
		query.append("           NVL(S.SLS_REP_OFC_TEAM_CD, D.SLS_OFC_CD) AS TEAM_CD, " ).append("\n"); 
		query.append("           D.SREP_CD," ).append("\n"); 
		query.append("           NVL(D.FCAST_20FT_QTY, 0) + ( NVL(D.FCAST_40FT_QTY, 0) + NVL(D.FCAST_40FT_HC_QTY, 0) + NVL(D.FCAST_45FT_HC_QTY, 0) + NVL(D.FCAST_53FT_QTY, 0) ) * 2 AS PRE_FCAST_QTY" ).append("\n"); 
		query.append("      FROM VVDS T," ).append("\n"); 
		query.append("           SPC_DLY_FCAST_SLS_REP_HIS D," ).append("\n"); 
		query.append("           SPC_SLS_REP_TEAM_IF S" ).append("\n"); 
		query.append("     WHERE T.TRD_CD     = D.TRD_CD" ).append("\n"); 
		query.append("       AND T.RLANE_CD   = D.RLANE_CD" ).append("\n"); 
		query.append("       AND T.VSL_CD     = D.VSL_CD" ).append("\n"); 
		query.append("       AND T.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND T.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND D.SLS_RHQ_CD = T.SLS_RHQ_CD" ).append("\n"); 
		query.append("       AND D.SLS_RGN_OFC_CD = T.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("       AND D.CTRT_CUST_CNT_CD = '00'" ).append("\n"); 
		query.append("       AND D.SREP_CD = S.SREP_USR_ID" ).append("\n"); 
		query.append("       AND D.BSE_DT = (SELECT " ).append("\n"); 
		query.append("                              MAX(H.BSE_DT) " ).append("\n"); 
		query.append("                         FROM SPC_DLY_FCAST_SLS_REP_HIS H" ).append("\n"); 
		query.append("                        WHERE H.TRD_CD     = D.TRD_CD" ).append("\n"); 
		query.append("                          AND H.RLANE_CD   = D.RLANE_CD" ).append("\n"); 
		query.append("                          AND H.VSL_CD     = D.VSL_CD" ).append("\n"); 
		query.append("                          AND H.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND H.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND H.SLS_RHQ_CD = D.SLS_RHQ_CD" ).append("\n"); 
		query.append("                          AND H.SLS_RGN_OFC_CD = D.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", FCAST_DATA AS (" ).append("\n"); 
		query.append("    SELECT D.TRD_CD," ).append("\n"); 
		query.append("           D.RLANE_CD," ).append("\n"); 
		query.append("           D.VSL_CD," ).append("\n"); 
		query.append("           D.SKD_VOY_NO," ).append("\n"); 
		query.append("           D.SKD_DIR_CD," ).append("\n"); 
		query.append("           T.CONTI_CD," ).append("\n"); 
		query.append("           T.PUS_ETD_DT," ).append("\n"); 
		query.append("           D.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           D.SLS_OFC_CD," ).append("\n"); 
		query.append("           NVL(S.SLS_REP_OFC_TEAM_CD, D.SLS_OFC_CD) AS TEAM_CD, " ).append("\n"); 
		query.append("           D.SREP_USR_ID AS SREP_CD," ).append("\n"); 
		query.append("           NVL(D.FCAST_20FT_QTY, NVL(D.CFM_TTL_QTY, 0)) + ( NVL(D.FCAST_40FT_QTY, 0) + NVL(D.CFM_40FT_HC_QTY, 0) + NVL(D.CFM_45FT_HC_QTY, 0) + NVL(D.CFM_53FT_QTY, 0) ) * 2 AS TODAY_FCAST_QTY" ).append("\n"); 
		query.append("      FROM VVDS T," ).append("\n"); 
		query.append("           SPC_DLY_FCAST_CUST D," ).append("\n"); 
		query.append("           SPC_SLS_REP_TEAM_IF S" ).append("\n"); 
		query.append("     WHERE T.TRD_CD = D.TRD_CD" ).append("\n"); 
		query.append("       AND T.RLANE_CD = D.RLANE_CD" ).append("\n"); 
		query.append("       AND T.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("       AND T.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND T.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND D.SREP_USR_ID = S.SREP_USR_ID" ).append("\n"); 
		query.append("       AND D.SLS_RHQ_CD  = T.SLS_RHQ_CD" ).append("\n"); 
		query.append("       AND D.SLS_RGN_OFC_CD = T.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", ALOC_DATA AS (" ).append("\n"); 
		query.append("    SELECT A.TRD_CD," ).append("\n"); 
		query.append("           A.RLANE_CD," ).append("\n"); 
		query.append("           A.VSL_CD," ).append("\n"); 
		query.append("           A.SKD_VOY_NO," ).append("\n"); 
		query.append("           A.SKD_DIR_CD," ).append("\n"); 
		query.append("           T.CONTI_CD," ).append("\n"); 
		query.append("           T.PUS_ETD_DT," ).append("\n"); 
		query.append("           A.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           A.SLS_OFC_CD," ).append("\n"); 
		query.append("           A.SLS_OFC_CD AS TEAM_CD," ).append("\n"); 
		query.append("           SUM(A.ASGN_TTL_QTY) RGN_ALLOC_QTY," ).append("\n"); 
		query.append("           SUM(A.BKG_AVAL_TTL_QTY) ALLOC_QTY" ).append("\n"); 
		query.append("      FROM VVDS T," ).append("\n"); 
		query.append("           SPC_ALOC_POL_POD A" ).append("\n"); 
		query.append("     WHERE T.TRD_CD = A.TRD_CD" ).append("\n"); 
		query.append("       AND T.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("       AND T.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("       AND T.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND T.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A.SLS_RHQ_CD = T.SLS_RHQ_CD" ).append("\n"); 
		query.append("       AND A.SLS_RGN_OFC_CD = T.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("     GROUP BY A.TRD_CD," ).append("\n"); 
		query.append("           A.RLANE_CD," ).append("\n"); 
		query.append("           A.VSL_CD," ).append("\n"); 
		query.append("           A.SKD_VOY_NO," ).append("\n"); 
		query.append("           A.SKD_DIR_CD," ).append("\n"); 
		query.append("           T.CONTI_CD," ).append("\n"); 
		query.append("           T.PUS_ETD_DT," ).append("\n"); 
		query.append("           A.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           A.SLS_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", QTA_DATA AS (" ).append("\n"); 
		query.append("    SELECT MQ.TRD_CD, " ).append("\n"); 
		query.append("           MQ.RLANE_CD, " ).append("\n"); 
		query.append("           MQ.VSL_CD, " ).append("\n"); 
		query.append("           MQ.SKD_VOY_NO, " ).append("\n"); 
		query.append("           MQ.SKD_DIR_CD, " ).append("\n"); 
		query.append("           T.CONTI_CD," ).append("\n"); 
		query.append("           T.PUS_ETD_DT," ).append("\n"); 
		query.append("           T.SLS_RGN_OFC_CD AS SLS_RGN_OFC_CD, " ).append("\n"); 
		query.append("           R.SLS_OFC_CD, " ).append("\n"); 
		query.append("           R.SLS_REP_OFC_TEAM_CD AS TEAM_CD," ).append("\n"); 
		query.append("           R.TEAM_QTA_RTO," ).append("\n"); 
		query.append("           ROUND(MQ.LOD_QTY * R.TEAM_QTA_RTO / 100) AS TEAM_QTA" ).append("\n"); 
		query.append("      FROM VVDS T," ).append("\n"); 
		query.append("           SQM_QTA_RLSE_VER MQR," ).append("\n"); 
		query.append("           SQM_CFM_QTA      MQ ," ).append("\n"); 
		query.append("           SPC_TEAM_QTA_RTO R," ).append("\n"); 
		query.append("           SPC_OFC_LVL      O" ).append("\n"); 
		query.append("     WHERE MQR.BSE_YR          = T.BSE_YR" ).append("\n"); 
		query.append("       --AND MQR.BSE_QTR_CD      = CEIL(TO_NUMBER(DECODE(T.COST_WK,'00','01','53','52',T.COST_WK))/13)||'Q' --CEIL(TO_NUMBER(SUBSTR(T.SLS_YRMON, 5, 4)) / 3)||'Q'" ).append("\n"); 
		query.append("       -- CHM-201534458 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("	   AND MQR.BSE_QTR_CD      = T.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND MQR.SQM_VER_STS_CD  = 'R'" ).append("\n"); 
		query.append("       AND MQR.BSE_TP_CD       = 'Q' -- 분기 20131205추가" ).append("\n"); 
		query.append("       AND MQ.QTA_RLSE_VER_NO  = MQR.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("       AND MQ.BSE_TP_CD        = MQR.BSE_TP_CD -- 분기 20131205추가    " ).append("\n"); 
		query.append("       AND MQ.BSE_YR           = MQR.BSE_YR" ).append("\n"); 
		query.append("       AND MQ.BSE_QTR_CD       = MQR.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND MQ.QTA_TGT_CD       = 'D'" ).append("\n"); 
		query.append("       AND MQ.OFC_VW_CD        = 'L'       " ).append("\n"); 
		query.append("       AND MQ.TRD_CD           = T.TRD_CD" ).append("\n"); 
		query.append("       AND MQ.RLANE_CD         = T.RLANE_CD" ).append("\n"); 
		query.append("       AND MQ.DIR_CD           = T.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND MQ.VSL_CD           = T.VSL_CD" ).append("\n"); 
		query.append("       AND MQ.SKD_VOY_NO       = T.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND MQ.SKD_DIR_CD       = T.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND O.N2ND_PRNT_OFC_CD  = T.SLS_RHQ_CD" ).append("\n"); 
		query.append("       AND SPC_SCR_OFC_CONV_FNC(MQ.RGN_OFC_CD,'') = T.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("       AND MQ.TRD_CD           = R.TRD_CD" ).append("\n"); 
		query.append("       AND MQ.RLANE_CD         = R.RLANE_CD" ).append("\n"); 
		query.append("       AND SPC_SCR_OFC_CONV_FNC(MQ.RGN_OFC_CD,'') = R.SLS_RGN_OFC_CD   " ).append("\n"); 
		query.append("       --AND MQ.BSE_YR           = R.BSE_YR" ).append("\n"); 
		query.append("       --AND MQ.BSE_QTR_CD       = R.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND SUBSTR(T.SLS_YRMON,1,4) || T.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("       --AND MQ.RGN_OFC_CD        = O.OFC_CD" ).append("\n"); 
		query.append("       AND (" ).append("\n"); 
		query.append("             SELECT NVL(MAX(ROC.CONV_RGN_OFC_CD), MQ.RGN_OFC_CD)" ).append("\n"); 
		query.append("               FROM SPC_RGN_OFC_CONV ROC" ).append("\n"); 
		query.append("              WHERE ROC.SLS_RGN_OFC_CD = MQ.RGN_OFC_CD" ).append("\n"); 
		query.append("           ) = O.OFC_CD" ).append("\n"); 
		query.append("       AND R.BSE_YR||R.BSE_QTR_CD = (SELECT /*+INDEX_DESC(Q XPKSPC_TEAM_QTA_RTO) */" ).append("\n"); 
		query.append("                                            BSE_YR||BSE_QTR_CD" ).append("\n"); 
		query.append("                                       FROM SPC_TEAM_QTA_RTO Q" ).append("\n"); 
		query.append("                                      WHERE Q.TRD_CD = R.TRD_CD" ).append("\n"); 
		query.append("                                        AND Q.SUB_TRD_CD = R.SUB_TRD_CD" ).append("\n"); 
		query.append("                                        AND Q.RLANE_CD = R.RLANE_CD" ).append("\n"); 
		query.append("                                        AND Q.BSE_YR = MQR.BSE_YR" ).append("\n"); 
		query.append("                                        AND Q.BSE_QTR_CD <= MQR.BSE_QTR_CD" ).append("\n"); 
		query.append("                                        AND ROWNUM = 1)" ).append("\n"); 
		query.append("       AND NOT EXISTS (SELECT 'A' " ).append("\n"); 
		query.append("                         FROM SPC_TEAM_QTA_RTO" ).append("\n"); 
		query.append("                        WHERE TRD_CD = MQ.TRD_CD" ).append("\n"); 
		query.append("                          AND RLANE_CD = MQ.RLANE_CD" ).append("\n"); 
		query.append("                          AND VSL_CD = MQ.VSL_CD" ).append("\n"); 
		query.append("                          AND SKD_VOY_NO = MQ.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND SKD_DIR_CD = MQ.SKD_DIR_CD)" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("    SELECT MQ.TRD_CD, " ).append("\n"); 
		query.append("           MQ.RLANE_CD, " ).append("\n"); 
		query.append("           MQ.VSL_CD, " ).append("\n"); 
		query.append("           MQ.SKD_VOY_NO, " ).append("\n"); 
		query.append("           MQ.SKD_DIR_CD, " ).append("\n"); 
		query.append("           T.CONTI_CD," ).append("\n"); 
		query.append("           T.PUS_ETD_DT," ).append("\n"); 
		query.append("           T.SLS_RGN_OFC_CD AS SLS_RGN_OFC_CD, " ).append("\n"); 
		query.append("           R.SLS_OFC_CD, " ).append("\n"); 
		query.append("           R.SLS_REP_OFC_TEAM_CD AS TEAM_CD," ).append("\n"); 
		query.append("           R.TEAM_QTA_RTO," ).append("\n"); 
		query.append("           ROUND(MQ.LOD_QTY * R.TEAM_QTA_RTO / 100) AS TEAM_QTA" ).append("\n"); 
		query.append("      FROM VVDS T," ).append("\n"); 
		query.append("           SQM_QTA_RLSE_VER MQR," ).append("\n"); 
		query.append("           SQM_CFM_QTA      MQ ," ).append("\n"); 
		query.append("           SPC_TEAM_QTA_RTO R," ).append("\n"); 
		query.append("           SPC_OFC_LVL      O" ).append("\n"); 
		query.append("     WHERE MQR.BSE_YR          = T.BSE_YR" ).append("\n"); 
		query.append("       --AND MQR.BSE_QTR_CD      = CEIL(TO_NUMBER(DECODE(T.COST_WK,'00','01','53','52',T.COST_WK))/13)||'Q' --CEIL(TO_NUMBER(SUBSTR(T.SLS_YRMON, 5, 4)) / 3)||'Q'" ).append("\n"); 
		query.append("	   -- CHM-201534458 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("	   AND MQR.BSE_QTR_CD      = T.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND MQR.SQM_VER_STS_CD  = 'R'" ).append("\n"); 
		query.append("       AND MQR.BSE_TP_CD       = 'Q' -- 분기 20131205추가" ).append("\n"); 
		query.append("       AND MQ.QTA_RLSE_VER_NO  = MQR.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("       AND MQ.BSE_TP_CD        = MQR.BSE_TP_CD -- 분기 20131205추가    " ).append("\n"); 
		query.append("       AND MQ.BSE_YR           = MQR.BSE_YR" ).append("\n"); 
		query.append("       AND MQ.BSE_QTR_CD       = MQR.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND MQ.QTA_TGT_CD       = 'D'" ).append("\n"); 
		query.append("       AND MQ.OFC_VW_CD        = 'L'" ).append("\n"); 
		query.append("       AND MQ.TRD_CD           = T.TRD_CD" ).append("\n"); 
		query.append("       AND MQ.RLANE_CD         = T.RLANE_CD" ).append("\n"); 
		query.append("       AND MQ.DIR_CD           = T.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND MQ.VSL_CD           = T.VSL_CD" ).append("\n"); 
		query.append("       AND MQ.SKD_VOY_NO       = T.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND MQ.SKD_DIR_CD       = T.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND O.N2ND_PRNT_OFC_CD  = T.SLS_RHQ_CD" ).append("\n"); 
		query.append("       AND SPC_SCR_OFC_CONV_FNC(MQ.RGN_OFC_CD,'') = T.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("       AND MQ.TRD_CD           = R.TRD_CD" ).append("\n"); 
		query.append("       AND MQ.RLANE_CD         = R.RLANE_CD" ).append("\n"); 
		query.append("       AND SPC_SCR_OFC_CONV_FNC(MQ.RGN_OFC_CD,'') = R.SLS_RGN_OFC_CD   " ).append("\n"); 
		query.append("       AND MQ.VSL_CD           = R.VSL_CD" ).append("\n"); 
		query.append("       AND MQ.SKD_VOY_NO       = R.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND MQ.SKD_DIR_CD       = R.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND SUBSTR(T.SLS_YRMON,1,4) || T.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("       --AND MQ.RGN_OFC_CD        = O.OFC_CD" ).append("\n"); 
		query.append("       AND (" ).append("\n"); 
		query.append("             SELECT NVL(MAX(ROC.CONV_RGN_OFC_CD), MQ.RGN_OFC_CD)" ).append("\n"); 
		query.append("               FROM SPC_RGN_OFC_CONV ROC" ).append("\n"); 
		query.append("              WHERE ROC.SLS_RGN_OFC_CD = MQ.RGN_OFC_CD" ).append("\n"); 
		query.append("           ) = O.OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ALL_DATA AS (" ).append("\n"); 
		query.append("    SELECT CONTI_CD," ).append("\n"); 
		query.append("           RLANE_CD," ).append("\n"); 
		query.append("           VSL_CD, " ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           PUS_ETD_DT," ).append("\n"); 
		query.append("           SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           SLS_OFC_CD," ).append("\n"); 
		query.append("           TEAM_CD," ).append("\n"); 
		query.append("           SUM(TEAM_QTA) AS TEAM_QTA," ).append("\n"); 
		query.append("           SUM(PRE_FCAST_QTY) AS PRE_FCAST_QTY," ).append("\n"); 
		query.append("           SUM(TODAY_FCAST_QTY) AS TODAY_FCAST_QTY," ).append("\n"); 
		query.append("           SUM(RGN_ALOC_QTY) AS RGN_ALOC_QTY," ).append("\n"); 
		query.append("           SUM(ALOC_QTY) AS ALOC_QTY," ).append("\n"); 
		query.append("           CASE WHEN SLS_OFC_CD IS NULL THEN 6" ).append("\n"); 
		query.append("                WHEN TEAM_CD IS NULL AND SLS_OFC_CD = 'PUSBS' THEN 5" ).append("\n"); 
		query.append("                WHEN TEAM_CD IS NULL AND SLS_OFC_CD = 'SELSC' THEN 4" ).append("\n"); 
		query.append("                WHEN TEAM_CD = 'SELBS' THEN 3" ).append("\n"); 
		query.append("                WHEN TEAM_CD = 'SELBK' THEN 2" ).append("\n"); 
		query.append("                ELSE 1" ).append("\n"); 
		query.append("           END RNUM" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD, " ).append("\n"); 
		query.append("                   VSL_CD," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   CONTI_CD," ).append("\n"); 
		query.append("                   PUS_ETD_DT," ).append("\n"); 
		query.append("                   SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                   SLS_OFC_CD," ).append("\n"); 
		query.append("                   TEAM_CD," ).append("\n"); 
		query.append("                   0 AS TEAM_QTA," ).append("\n"); 
		query.append("                   PRE_FCAST_QTY," ).append("\n"); 
		query.append("                   0 AS TODAY_FCAST_QTY," ).append("\n"); 
		query.append("                   0 AS RGN_ALOC_QTY," ).append("\n"); 
		query.append("                   0 AS ALOC_QTY" ).append("\n"); 
		query.append("              FROM HIS_DATA" ).append("\n"); 
		query.append("             UNION ALL " ).append("\n"); 
		query.append("            SELECT TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD, " ).append("\n"); 
		query.append("                   VSL_CD," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   CONTI_CD," ).append("\n"); 
		query.append("                   PUS_ETD_DT," ).append("\n"); 
		query.append("                   SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                   SLS_OFC_CD," ).append("\n"); 
		query.append("                   TEAM_CD," ).append("\n"); 
		query.append("                   0 AS TEAM_QTA," ).append("\n"); 
		query.append("                   0 AS PRE_FCAST_QTY," ).append("\n"); 
		query.append("                   TODAY_FCAST_QTY," ).append("\n"); 
		query.append("                   0 AS RGN_ALOC_QTY," ).append("\n"); 
		query.append("                   0 AS ALOC_QTY" ).append("\n"); 
		query.append("              FROM FCAST_DATA" ).append("\n"); 
		query.append("             UNION ALL " ).append("\n"); 
		query.append("            SELECT TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD, " ).append("\n"); 
		query.append("                   VSL_CD," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   CONTI_CD," ).append("\n"); 
		query.append("                   PUS_ETD_DT," ).append("\n"); 
		query.append("                   SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                   SLS_OFC_CD," ).append("\n"); 
		query.append("                   TEAM_CD," ).append("\n"); 
		query.append("                   TEAM_QTA," ).append("\n"); 
		query.append("                   0 AS PRE_FCAST_QTY," ).append("\n"); 
		query.append("                   0 AS TODAY_FCAST_QTY," ).append("\n"); 
		query.append("                   0 AS RGN_ALOC_QTY," ).append("\n"); 
		query.append("                   0 AS ALOC_QTY" ).append("\n"); 
		query.append("              FROM QTA_DATA" ).append("\n"); 
		query.append("             UNION ALL " ).append("\n"); 
		query.append("            SELECT TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD, " ).append("\n"); 
		query.append("                   VSL_CD," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   CONTI_CD," ).append("\n"); 
		query.append("                   PUS_ETD_DT," ).append("\n"); 
		query.append("                   SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                   SLS_OFC_CD," ).append("\n"); 
		query.append("                   TEAM_CD," ).append("\n"); 
		query.append("                   0 AS TEAM_QTA," ).append("\n"); 
		query.append("                   0 AS PRE_FCAST_QTY," ).append("\n"); 
		query.append("                   0 AS TODAY_FCAST_QTY," ).append("\n"); 
		query.append("                   RGN_ALLOC_QTY AS RGN_ALOC_QTY," ).append("\n"); 
		query.append("                   ALLOC_QTY AS ALOC_QTY" ).append("\n"); 
		query.append("              FROM ALOC_DATA" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                                (SLS_RGN_OFC_CD, SLS_OFC_CD, TEAM_CD)," ).append("\n"); 
		query.append("                                (SLS_RGN_OFC_CD, SLS_OFC_CD)," ).append("\n"); 
		query.append("                                (SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("                                (CONTI_CD, SLS_RGN_OFC_CD, SLS_OFC_CD, TEAM_CD)," ).append("\n"); 
		query.append("                                (CONTI_CD, SLS_RGN_OFC_CD, SLS_OFC_CD)," ).append("\n"); 
		query.append("                                (CONTI_CD, SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("                                (CONTI_CD, RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, PUS_ETD_DT, SLS_RGN_OFC_CD, SLS_OFC_CD, TEAM_CD)," ).append("\n"); 
		query.append("                                (CONTI_CD, RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, PUS_ETD_DT, SLS_RGN_OFC_CD, SLS_OFC_CD)," ).append("\n"); 
		query.append("                                (CONTI_CD, RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, PUS_ETD_DT, SLS_RGN_OFC_CD)" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("     HAVING NOT NVL(TEAM_CD, 'X') IN ('SELSC', 'PUSBS')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD,  " ).append("\n"); 
		query.append("       VVD1,     " ).append("\n"); 
		query.append("       AQ_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#set($primate = 'new_dur')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6'])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("       SUM(QTA${key}1) AS QTA${key}1," ).append("\n"); 
		query.append("       SUM(FCT${key}1) AS FCT${key}1," ).append("\n"); 
		query.append("       SUM(BKG${key}1) AS BKG${key}1," ).append("\n"); 
		query.append("       DECODE(SUM(QTA${key}1), 0, 0, ROUND(SUM(BKG${key}1)/SUM(QTA${key}1) * 100)) AS PREF${key}1," ).append("\n"); 
		query.append("       SUM(ALC${key}1) AS ALC${key}1," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       '' AS T" ).append("\n"); 
		query.append("  FROM (    " ).append("\n"); 
		query.append("    SELECT DECODE(CONTI_CD, 'M', 'USA', 'E', 'EUR', 'Grand') AS TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD," ).append("\n"); 
		query.append("           VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD1," ).append("\n"); 
		query.append("           PUS_ETD_DT AS AQ_CD," ).append("\n"); 
		query.append("           VSL_CD, " ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           PUS_ETD_DT," ).append("\n"); 
		query.append("           SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           SLS_OFC_CD," ).append("\n"); 
		query.append("           TEAM_CD," ).append("\n"); 
		query.append("           RNUM," ).append("\n"); 
		query.append("           C1.CPY_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 1, DECODE(RNUM , C1.CPY_NO, TEAM_QTA, 0), 0) AS QTA11," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 1, DECODE(RNUM , C1.CPY_NO, PRE_FCAST_QTY, 0), 0) AS FCT11," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 1, DECODE(RNUM , C1.CPY_NO, TODAY_FCAST_QTY, 0), 0) AS BKG11," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 1, DECODE(RNUM , C1.CPY_NO, ALOC_QTY, 0), 0) AS ALC11," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 2, DECODE(RNUM , C1.CPY_NO, TEAM_QTA, 0), 0) AS QTA21," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 2, DECODE(RNUM , C1.CPY_NO, PRE_FCAST_QTY, 0), 0) AS FCT21," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 2, DECODE(RNUM , C1.CPY_NO, TODAY_FCAST_QTY, 0), 0) AS BKG21," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 2, DECODE(RNUM , C1.CPY_NO, ALOC_QTY, 0), 0) AS ALC21," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 3, DECODE(RNUM , C1.CPY_NO, TEAM_QTA, 0), 0) AS QTA31," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 3, DECODE(RNUM , C1.CPY_NO, PRE_FCAST_QTY, 0), 0) AS FCT31," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 3, DECODE(RNUM , C1.CPY_NO, TODAY_FCAST_QTY, 0), 0) AS BKG31," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 3, DECODE(RNUM , C1.CPY_NO, ALOC_QTY, 0), 0) AS ALC31," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 4, DECODE(RNUM , C1.CPY_NO, TEAM_QTA, 0), 0) AS QTA41," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 4, DECODE(RNUM , C1.CPY_NO, PRE_FCAST_QTY, 0), 0) AS FCT41," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 4, DECODE(RNUM , C1.CPY_NO, TODAY_FCAST_QTY, 0), 0) AS BKG41," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 4, DECODE(RNUM , C1.CPY_NO, ALOC_QTY, 0), 0) AS ALC41," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 5, DECODE(RNUM , C1.CPY_NO, TEAM_QTA, 0), 0) AS QTA51," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 5, DECODE(RNUM , C1.CPY_NO, PRE_FCAST_QTY, 0), 0) AS FCT51," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 5, DECODE(RNUM , C1.CPY_NO, TODAY_FCAST_QTY, 0), 0) AS BKG51," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 5, DECODE(RNUM , C1.CPY_NO, ALOC_QTY, 0), 0) AS ALC51," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 6, DECODE(RNUM , C1.CPY_NO, TEAM_QTA, 0), 0) AS QTA61," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 6, DECODE(RNUM , C1.CPY_NO, PRE_FCAST_QTY, 0), 0) AS FCT61," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 6, DECODE(RNUM , C1.CPY_NO, TODAY_FCAST_QTY, 0), 0) AS BKG61," ).append("\n"); 
		query.append("           DECODE(C1.CPY_NO, 6, DECODE(RNUM , C1.CPY_NO, RGN_ALOC_QTY, 0), 0) AS ALC61," ).append("\n"); 
		query.append("           '' AS T" ).append("\n"); 
		query.append("      FROM ALL_DATA A," ).append("\n"); 
		query.append("           (SELECT CPY_NO " ).append("\n"); 
		query.append("              FROM COM_CPY_NO " ).append("\n"); 
		query.append("             WHERE CPY_NO > 0 " ).append("\n"); 
		query.append("               AND CPY_NO < 7) C1" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append(" GROUP BY AQ_CD," ).append("\n"); 
		query.append("       TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD,  " ).append("\n"); 
		query.append("       VVD1,     " ).append("\n"); 
		query.append("       VSL_CD, " ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD    " ).append("\n"); 
		query.append("ORDER BY DECODE(TRD_CD, 'Grand', '9', TRD_CD) DESC, RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, AQ_CD DESC" ).append("\n"); 

	}
}