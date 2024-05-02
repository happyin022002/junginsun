/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryPolPodListVORSQL.java
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

public class SpacecontrolinquiryDBDAOSearchSpaceControlInquiryPolPodListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * - Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
	  * 2011.06.01 이석준 [ CHM-201111304-01] Reefer Size에 상관없이 Q'ty 가져오도록 수정
	  * 2011.06.01 [CHM-201111305-01] 김종준 R5와 동일하게 R9이 적용될 수 있도록 쿼리수정
	  * 2011.07.05 [CHM-201111880-01] 김종준control by HO 화면 보완 - IPC, TS 관련
	  * 2011.08.18 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - WAFIE Allocaion 정보는 제외하고 보이도록 쿼리수정
	  * 2012.12.03 [CHM-201221639] 김시몬 R9와 동일하게 R8이 적용될 수 있도록 쿼리수정
	  * 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.03.06 진마리아 Firm, Wating BKG 삭제
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * 2014.08.05 CHM-201431081 SPC Allocation Control Option 추가 보완 요청
	  * 2014.08.06 CHM-201431081 SPC Allocation Control Option 추가 보완 요청(ECC)
	  * 2015.07.16 Arie [CHM-201537094] MAS CMB 산출 로직 변경 적용 - dem/det 추가 CM = REV+DEM/DET-COST TTL
	  * 2015.09.16 이혜민 선반영 SPC_CONTI_CONV_FNC 태울때 SLAN_CD를 인자로 가져가던것 RLANE_CD로 수정 (RLANE_CD로 가져가야 제대로 펑션을 탐)
	  * 2016.07.05 CHM-201642241 VGM(BKG상 표시되는 또 다른 WGT 정보) 도입 관련 SPC 사항
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchSpaceControlInquiryPolPodListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq_gso",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_pod",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryPolPodListVORSQL").append("\n"); 
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
		query.append("    SELECT P.OFC_CD    ," ).append("\n"); 
		query.append("           P.TRD_CD    ," ).append("\n"); 
		query.append("           P.SUB_TRD_CD," ).append("\n"); 
		query.append("           P.RLANE_CD  ," ).append("\n"); 
		query.append("           P.DIR_CD    ," ).append("\n"); 
		query.append("           P.IOC_CD    ," ).append("\n"); 
		query.append("           SUBSTR(P.VVD, 1, 4) AS VSL_CD    ," ).append("\n"); 
		query.append("           SUBSTR(P.VVD, 5, 4) AS SKD_VOY_NO," ).append("\n"); 
		query.append("           SUBSTR(P.VVD, 9)    AS SKD_DIR_CD," ).append("\n"); 
		query.append("           P.OFC_DIV   ," ).append("\n"); 
		query.append("           P.PORT_DIV  ," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 5, 2) AS COST_MON," ).append("\n"); 
		query.append("           V.COST_WK," ).append("\n"); 
		query.append("           -- 20140728 추가" ).append("\n"); 
		query.append("           NVL(DECODE(CO.CTRL_ECC_FLG,'Y','E',DECODE(CO.CTRL_LOC_FLG,'Y','L','N')),'N') AS CTRL_DEST, -- E = ECC, L = LOCATION" ).append("\n"); 
		query.append("           NVL(CO.CTRL_DEST_LVL_CD, 'N')     AS CTRL_DEST_LVL  ,                                      -- D = BKG_POD, T = BKG_DEL" ).append("\n"); 
		query.append("           NVL(CO.CTRL_USA_SVC_MOD_FLG, 'N') AS CTRL_USA                                              -- Y = LOCAL/IPI" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              SELECT SUBSTR(@[rhq_txt],1,5)  AS OFC_CD ," ).append("\n"); 
		query.append("                     @[trade]    AS TRD_CD    ," ).append("\n"); 
		query.append("                     @[subtrade] AS SUB_TRD_CD," ).append("\n"); 
		query.append("                     @[lane]     AS RLANE_CD  ," ).append("\n"); 
		query.append("                     @[bound]    AS DIR_CD    ," ).append("\n"); 
		query.append("                     @[onc_ipc]  AS IOC_CD    ," ).append("\n"); 
		query.append("                     @[vvd]      AS VVD       ," ).append("\n"); 
		query.append("                     @[rhq_gso]  AS OFC_DIV   ," ).append("\n"); 
		query.append("                     @[pol_pod]  AS PORT_DIV" ).append("\n"); 
		query.append("                FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq_txt} == 'SHARC,SINRS') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              SELECT SUBSTR(@[rhq_txt],7,5)  AS OFC_CD  ," ).append("\n"); 
		query.append("                     @[trade]    AS TRD_CD    ," ).append("\n"); 
		query.append("                     @[subtrade] AS SUB_TRD_CD," ).append("\n"); 
		query.append("                     @[lane]     AS RLANE_CD  ," ).append("\n"); 
		query.append("                     @[bound]    AS DIR_CD    ," ).append("\n"); 
		query.append("                     @[onc_ipc]  AS IOC_CD    ," ).append("\n"); 
		query.append("                     @[vvd]      AS VVD       ," ).append("\n"); 
		query.append("                     @[rhq_gso]  AS OFC_DIV   ," ).append("\n"); 
		query.append("                     @[pol_pod]  AS PORT_DIV" ).append("\n"); 
		query.append("                FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ) P," ).append("\n"); 
		query.append("           MAS_MON_VVD V," ).append("\n"); 
		query.append("           SPC_ALOC_CTRL_OPT CO  -- 20140728 추가" ).append("\n"); 
		query.append("     WHERE V.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("       AND V.IOC_CD     = P.IOC_CD" ).append("\n"); 
		query.append("       AND V.VSL_CD     = SUBSTR(P.VVD, 1, 4)" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = SUBSTR(P.VVD, 5, 4)" ).append("\n"); 
		query.append("       AND V.DIR_CD     = SUBSTR(P.VVD, 9)" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = CO.RLANE_CD  (+)" ).append("\n"); 
		query.append("       AND V.DIR_CD     = CO.DIR_CD    (+)" ).append("\n"); 
		query.append("       AND V.VSL_CD     = CO.VSL_CD    (+)" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = CO.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND V.DIR_CD     = CO.SKD_DIR_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_pod} != 'DEL')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", FCST_DATA AS (" ).append("\n"); 
		query.append("    SELECT DECODE(M.OFC_DIV, 'RHQ', D.SLS_RHQ_CD, D.SLS_RGN_OFC_CD) AS OFC_CD ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           -- 20140728 추가" ).append("\n"); 
		query.append("           DECODE(D.USA_BKG_MOD_CD,'OTH','OTHERS',D.USA_BKG_MOD_CD) AS USA_BKG_MOD_CD, -- SPC_DLY_FCAST_CUST.LOCAL/IPI" ).append("\n"); 
		query.append("           DECODE(M.PORT_DIV, 'POL', D.POL_YD_CD, D.POD_YD_CD)      AS PORT_CD," ).append("\n"); 
		query.append("           D.DEST_LOC_CD,    -- SPC_DLY_FCAST_CUST.DEST   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           SUM(D.CFM_TTL_QTY)      AS VOL_TTL," ).append("\n"); 
		query.append("           SUM(D.CFM_40FT_HC_QTY)  AS VOL_HC ," ).append("\n"); 
		query.append("           SUM(D.CFM_45FT_HC_QTY)  AS VOL_45 ," ).append("\n"); 
		query.append("           SUM(D.CFM_53FT_QTY)     AS VOL_53 ," ).append("\n"); 
		query.append("           SUM(D.CFM_RF_QTY)       AS VOL_RF ," ).append("\n"); 
		query.append("           SUM(D.CFM_TTL_WGT)      AS WGT_TTL," ).append("\n"); 
		query.append("           SUM(D.CFM_20FT_DRY_QTY) AS VOL_D2 ," ).append("\n"); 
		query.append("           SUM(D.CFM_40FT_DRY_QTY) AS VOL_D4 ," ).append("\n"); 
		query.append("           SUM(D.CFM_RD_QTY)       AS VOL_RD" ).append("\n"); 
		query.append("      FROM PARAMS             M," ).append("\n"); 
		query.append("           SPC_DLY_FCAST_CUST D" ).append("\n"); 
		query.append("     WHERE D.TRD_CD     = M.TRD_CD" ).append("\n"); 
		query.append("       AND D.SUB_TRD_CD = M.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND D.RLANE_CD   = M.RLANE_CD" ).append("\n"); 
		query.append("       AND D.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("       AND D.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("       AND D.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND D.SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND D.IOC_TS_CD  = M.IOC_CD" ).append("\n"); 
		query.append("       AND (M.OFC_CD IS NULL OR D.SLS_RHQ_CD = M.OFC_CD OR D.SLS_AQ_CD = M.OFC_CD)" ).append("\n"); 
		query.append("  GROUP BY DECODE(M.OFC_DIV, 'RHQ', D.SLS_RHQ_CD, D.SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("           DECODE(M.PORT_DIV, 'POL', D.POL_YD_CD, D.POD_YD_CD)," ).append("\n"); 
		query.append("           -- 20140728 추가" ).append("\n"); 
		query.append("           DECODE(D.USA_BKG_MOD_CD,'OTH','OTHERS',D.USA_BKG_MOD_CD)," ).append("\n"); 
		query.append("           D.DEST_LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ALOC_DATA AS (" ).append("\n"); 
		query.append("    SELECT DECODE(M.OFC_DIV, 'RHQ', D.SLS_RHQ_CD, D.SLS_RGN_OFC_CD) AS OFC_CD ," ).append("\n"); 
		query.append("           -- 20140728 추가" ).append("\n"); 
		query.append("           DECODE(D.USA_BKG_MOD_CD,'OTH','OTHERS',D.USA_BKG_MOD_CD)   AS USA_BKG_MOD_CD, -- SPC_ALOC_POL_POD.LOCAL/IPI" ).append("\n"); 
		query.append("           DECODE(M.PORT_DIV, 'POL', D.POL_YD_CD, D.POD_YD_CD)        AS PORT_CD," ).append("\n"); 
		query.append("           D.DEST_LOC_CD,    -- SPC_ALOC_POL_POD.DEST              " ).append("\n"); 
		query.append("           SUM(D.ASGN_TTL_QTY)      AS VOL_TTL," ).append("\n"); 
		query.append("           SUM(D.ASGN_40FT_HC_QTY)  AS VOL_HC ," ).append("\n"); 
		query.append("           SUM(D.ASGN_45FT_HC_QTY)  AS VOL_45 ," ).append("\n"); 
		query.append("           SUM(D.ASGN_53FT_QTY)     AS VOL_53 ," ).append("\n"); 
		query.append("           SUM(D.ASGN_RF_QTY)       AS VOL_RF ," ).append("\n"); 
		query.append("           SUM(D.ASGN_TTL_WGT)      AS WGT_TTL," ).append("\n"); 
		query.append("           SUM(D.ASGN_20FT_DRY_QTY) AS VOL_D2 ," ).append("\n"); 
		query.append("           SUM(D.ASGN_40FT_DRY_QTY) AS VOL_D4 ," ).append("\n"); 
		query.append("           SUM(D.ASGN_RD_QTY)       AS VOL_RD " ).append("\n"); 
		query.append("      FROM PARAMS           M," ).append("\n"); 
		query.append("           SPC_ALOC_POL_POD D" ).append("\n"); 
		query.append("     WHERE D.TRD_CD     = M.TRD_CD" ).append("\n"); 
		query.append("       AND D.SUB_TRD_CD = M.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND D.RLANE_CD   = M.RLANE_CD" ).append("\n"); 
		query.append("       AND D.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("       AND D.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("       AND D.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND D.SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND D.IOC_CD     = M.IOC_CD" ).append("\n"); 
		query.append("       AND (M.OFC_CD IS NULL OR D.SLS_RHQ_CD = M.OFC_CD OR D.SLS_AQ_CD = M.OFC_CD)" ).append("\n"); 
		query.append("       AND D.TS_FLG     = 'N'" ).append("\n"); 
		query.append("       AND D.POL_YD_CD  <> 'XXXXXXX'" ).append("\n"); 
		query.append("  GROUP BY DECODE(M.OFC_DIV, 'RHQ', D.SLS_RHQ_CD, D.SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("           DECODE(M.PORT_DIV, 'POL', D.POL_YD_CD, D.POD_YD_CD)," ).append("\n"); 
		query.append("           -- 20140728 추가" ).append("\n"); 
		query.append("           DECODE(D.USA_BKG_MOD_CD,'OTH','OTHERS',D.USA_BKG_MOD_CD)," ).append("\n"); 
		query.append("           D.DEST_LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", BKG_DATA AS (" ).append("\n"); 
		query.append("   SELECT OFC_CD" ).append("\n"); 
		query.append("  		, PORT_CD" ).append("\n"); 
		query.append("  		-- 20140728 추가" ).append("\n"); 
		query.append("  		, USA_BKG_MOD_CD" ).append("\n"); 
		query.append("        , DEST_LOC_CD" ).append("\n"); 
		query.append("  		, SUM(BKG_TTL) AS BKG_TTL" ).append("\n"); 
		query.append("  		, SUM(BKG_20)  AS BKG_20" ).append("\n"); 
		query.append("  		, SUM(BKG_40)  AS BKG_40" ).append("\n"); 
		query.append("  		, SUM(BKG_D2)  AS BKG_D2  -- D2" ).append("\n"); 
		query.append("        , SUM(BKG_D4)  AS BKG_D4  -- D4" ).append("\n"); 
		query.append("  		, SUM(BKG_HC)  AS BKG_HC" ).append("\n"); 
		query.append("  		, SUM(BKG_45)  AS BKG_45" ).append("\n"); 
		query.append("  		, SUM(BKG_53)  AS BKG_53" ).append("\n"); 
		query.append("  		, SUM(BKG_RF)  AS BKG_RF" ).append("\n"); 
		query.append("  		, SUM(BKG_RD)  AS BKG_RD  -- RD" ).append("\n"); 
		query.append("  		, SUM(BKG_WGT) AS BKG_WGT, SUM(BKG_VOL_VGM) AS BKG_VOL_VGM, SUM(BKG_WGT_VGM) AS BKG_WGT_VGM" ).append("\n"); 
		query.append("   	 FROM" ).append("\n"); 
		query.append("    	(  SELECT DECODE(OFC_DIV , 'RHQ', N2ND_PRNT_OFC_CD, N4TH_PRNT_OFC_CD) AS OFC_CD" ).append("\n"); 
		query.append("      			, DECODE(PORT_DIV , 'POL', NVL(POL_YD_CD, POL_CD), 'POD', NVL(POD_YD_CD, POD_CD), NVL(BKG_POD_YD_CD, BKG_POD_CD)) AS PORT_CD" ).append("\n"); 
		query.append("      			 -- 20140728 추가(S)" ).append("\n"); 
		query.append("      			 ,CASE WHEN M.CTRL_DEST = 'E' THEN	                                                      " ).append("\n"); 
		query.append("                       NVL((SELECT D.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("                              FROM SPC_ALOC_LANE_CTRL_OPT_DTL D," ).append("\n"); 
		query.append("                                   MDM_LOCATION               ML1," ).append("\n"); 
		query.append("                                   MDM_EQ_ORZ_CHT             ME1" ).append("\n"); 
		query.append("                             WHERE M.RLANE_CD         = D.RLANE_CD" ).append("\n"); 
		query.append("                               AND SPC_GET_REP_TRD_FNC(M.RLANE_CD)     = D.TRD_CD" ).append("\n"); 
		query.append("                               AND SPC_GET_REP_SUB_TRD_FNC(M.RLANE_CD) = D.SUB_TRD_CD" ).append("\n"); 
		query.append("                               AND M.SKD_DIR_CD       = D.DIR_CD " ).append("\n"); 
		query.append("                               AND D.ALOC_CTRL_TP_CD  = M.CTRL_DEST" ).append("\n"); 
		query.append("                               AND ML1.LOC_CD         = M.DEST_PORT" ).append("\n"); 
		query.append("                               AND ME1.SCC_CD         = ML1.SCC_CD" ).append("\n"); 
		query.append("                               AND D.CTRL_LOC_ACCT_CD = ME1.ECC_CD" ).append("\n"); 
		query.append("                       ),'XXXXX')" ).append("\n"); 
		query.append("                 WHEN M.CTRL_DEST = 'L' THEN	                                                      " ).append("\n"); 
		query.append("                       NVL((SELECT D.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("                              FROM SPC_ALOC_LANE_CTRL_OPT_DTL D" ).append("\n"); 
		query.append("                             WHERE M.RLANE_CD         = D.RLANE_CD" ).append("\n"); 
		query.append("                               AND SPC_GET_REP_TRD_FNC(M.RLANE_CD)     = D.TRD_CD" ).append("\n"); 
		query.append("                               AND SPC_GET_REP_SUB_TRD_FNC(M.RLANE_CD) = D.SUB_TRD_CD" ).append("\n"); 
		query.append("                               AND M.SKD_DIR_CD       = D.DIR_CD " ).append("\n"); 
		query.append("                               AND D.ALOC_CTRL_TP_CD  = M.CTRL_DEST" ).append("\n"); 
		query.append("                               AND D.CTRL_LOC_ACCT_CD = M.DEST_PORT" ).append("\n"); 
		query.append("                       ),'XXXXX')" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                      'XXXXX'" ).append("\n"); 
		query.append("                 END AS DEST_LOC_CD" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                 ,DECODE(USA_BKG_MOD_CD,'OTH','OTHERS',USA_BKG_MOD_CD) AS USA_BKG_MOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 ,TO_NUMBER(NVL(SUBSTR(VAL, 1,  14), 0))                              AS BKG_TTL" ).append("\n"); 
		query.append("                 ,TO_NUMBER(NVL(SUBSTR(VAL, 15, 14), 0))                              AS BKG_20" ).append("\n"); 
		query.append("                 ,TO_NUMBER(NVL(SUBSTR(VAL, 29, 14), 0))                              AS BKG_40" ).append("\n"); 
		query.append("                 ,TO_NUMBER(NVL(SUBSTR(VAL, 43, 14), 0))                              AS BKG_D2   -- 20140728 추가 D2" ).append("\n"); 
		query.append("                 ,TO_NUMBER(NVL(SUBSTR(VAL, 57, 14), 0))                              AS BKG_D4   -- 20140728 추가 D4" ).append("\n"); 
		query.append("                 ,TO_NUMBER(NVL(SUBSTR(VAL, 71, 14), 0))                              AS BKG_HC" ).append("\n"); 
		query.append("                 ,TO_NUMBER(NVL(SUBSTR(VAL, 85, 14), 0))                              AS BKG_45" ).append("\n"); 
		query.append("                 ,TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0))                              AS BKG_53" ).append("\n"); 
		query.append("                 ,TO_NUMBER(NVL(SUBSTR(VAL,113, 14), 0))                              AS BKG_RF" ).append("\n"); 
		query.append("                 ,TO_NUMBER(NVL(SUBSTR(VAL,127, 14), 0))                              AS BKG_RD   -- 20140728 추가 RD" ).append("\n"); 
		query.append("                 ,TO_NUMBER(NVL(SUBSTR(VAL,141, 14), 0))                              AS BKG_WGT ,BKG_VOL_VGM,BKG_WGT_VGM" ).append("\n"); 
		query.append("       		 FROM" ).append("\n"); 
		query.append("        		(  SELECT B.BKG_STS_CD" ).append("\n"); 
		query.append("          				, O.N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("          				, O.N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("          				, M.OFC_DIV" ).append("\n"); 
		query.append("          				, M.PORT_DIV" ).append("\n"); 
		query.append("          				, BV.POL_YD_CD" ).append("\n"); 
		query.append("          				, BV.POL_CD" ).append("\n"); 
		query.append("          				, BV.POD_YD_CD" ).append("\n"); 
		query.append("          				, BV.POD_CD" ).append("\n"); 
		query.append("          				, B.POD_NOD_CD AS BKG_POD_YD_CD" ).append("\n"); 
		query.append("          				, B.POD_CD AS BKG_POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          				-- 20140728 추가(S)" ).append("\n"); 
		query.append("                        ,CASE WHEN M.CTRL_USA = 'Y' AND (SUBSTR(B.POL_CD,1,2) IN ('US','CA') OR SUBSTR(B.POD_CD,1,2) IN ('US','CA')) THEN" ).append("\n"); 
		query.append("                             NVL(SPC_USA_MODE_FNC(B.RCV_TERM_CD, B.DE_TERM_CD, B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD),'OTHERS') -- SPC_DLY_FCAST_CUST.LOCAL/IPI -- SPC_DLY_FCAST_CUST.LOCAL/IPI" ).append("\n"); 
		query.append("                         ELSE" ).append("\n"); 
		query.append("                             'OTHERS'" ).append("\n"); 
		query.append("                         END AS USA_BKG_MOD_CD" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                        ,M.RLANE_CD" ).append("\n"); 
		query.append("                        ,M.SKD_DIR_CD" ).append("\n"); 
		query.append("                        ,M.CTRL_DEST" ).append("\n"); 
		query.append("                        ,DECODE(M.CTRL_DEST_LVL,'T',B.DEL_CD,B.POD_CD) AS DEST_PORT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          				, (SELECT  TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY), 'FM0000000000.000') " ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("								--20140728 " ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD,1,2), 'D2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') -- D2" ).append("\n"); 
		query.append("				                || TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD,1,2), 'D4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') -- D4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '5', Q.OP_CNTR_QTY, '9', Q.OP_CNTR_QTY, '8', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')	--R9,R8에 대해서 R5과 동일하게 HC으로 처리되도록 추가" ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '7', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')  " ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(Q.CNTR_TPSZ_CD, 'DW', Q.OP_CNTR_QTY, 'DX', Q.OP_CNTR_QTY, 0)) , 'FM0000000000.000')  " ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 1, 1), 'R', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("								--20140728 " ).append("\n"); 
		query.append("								|| TO_CHAR(SUM(CASE WHEN Q.CNTR_TPSZ_CD LIKE 'R%' AND Q.EQ_SUBST_CNTR_TPSZ_CD LIKE 'D%' THEN Q.EQ_SUBST_CGO_QTY ELSE 0 END), 'FM0000000000.000')--RD" ).append("\n"); 
		query.append("								|| TO_CHAR((R.ACT_WGT * DECODE(R.ACT_WGT,'LBS', 0.00045, 0.001)) " ).append("\n"); 
		query.append("										+ SUM(Q.OP_CNTR_QTY * (SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                   												 FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("                  												WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000')" ).append("\n"); 
		query.append("               		 		  FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("              	    		 WHERE B.BKG_NO = Q.BKG_NO) VAL" ).append("\n"); 
		query.append("						,(" ).append("\n"); 
		query.append("						SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Z.CNTR_TPSZ_CD), '2', 1, 2)* Z.OP_CNTR_QTY) " ).append("\n"); 
		query.append("						FROM BKG_QUANTITY Z " ).append("\n"); 
		query.append("						WHERE Z.BKG_NO= B.BKG_NO AND OP_CNTR_QTY > 0 " ).append("\n"); 
		query.append("						AND EXISTS ( SELECT 1 FROM BKG_CONTAINER C WHERE C.BKG_NO= Z.BKG_NO AND VGM_WGT>0 AND VGM_WGT IS NOT NULL )" ).append("\n"); 
		query.append("						) AS BKG_VOL_VGM" ).append("\n"); 
		query.append("						,(SELECT SUM(NVL(Z.VGM_WGT,0) * DECODE(Z.VGM_WGT_UT_CD,'LBS',0.00045,0.001)) FROM BKG_CONTAINER Z WHERE Z.BKG_NO= B.BKG_NO AND VGM_WGT>0 AND VGM_WGT IS NOT NULL) AS BKG_WGT_VGM							 " ).append("\n"); 
		query.append("           			 FROM BKG_VVD BV" ).append("\n"); 
		query.append("          				, BKG_BOOKING B" ).append("\n"); 
		query.append("          				, PARAMS M" ).append("\n"); 
		query.append("          				, BKG_BL_DOC R" ).append("\n"); 
		query.append("          				, MDM_DTL_REV_LANE DRL" ).append("\n"); 
		query.append("          				, MDM_REV_LANE RL" ).append("\n"); 
		query.append("          				, SPC_OFC_LVL O" ).append("\n"); 
		query.append("          			WHERE B.BKG_NO         = BV.BKG_NO" ).append("\n"); 
		query.append("            		  AND B.BKG_NO         = R.BKG_NO" ).append("\n"); 
		query.append("            		  AND B.BKG_STS_CD    IN ('W','F')" ).append("\n"); 
		query.append("            		  AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("--            		  AND M.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("--            		  AND M.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("--            		  AND M.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("            		  AND M.VSL_CD         = BV.VSL_CD" ).append("\n"); 
		query.append("            		  AND M.SKD_VOY_NO     = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("            		  AND M.SKD_DIR_CD     = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("            		  AND RL.VSL_SLAN_CD   = BV.SLAN_CD" ).append("\n"); 
		query.append("            		  AND (M.OFC_CD IS NULL " ).append("\n"); 
		query.append("							OR M.OFC_CD = (SELECT N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("               								 FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("              								WHERE OFC_CD = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD, '')" ).append("\n"); 
		query.append("                							  AND M.COST_YR || M.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK )" ).append("\n"); 
		query.append("            				OR M.OFC_CD = (SELECT N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("               								 FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("              							    WHERE OFC_CD = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD, '')" ).append("\n"); 
		query.append("                							  AND M.COST_YR || M.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK ))" ).append("\n"); 
		query.append("            		  AND O.OFC_CD = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD)" ).append("\n"); 
		query.append("            		  AND M.COST_YR || M.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("            		  AND DRL.RLANE_CD        = M.RLANE_CD" ).append("\n"); 
		query.append("            		  AND DRL.VSL_SLAN_DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append("            		  AND DRL.IOC_CD          = M.IOC_CD" ).append("\n"); 
		query.append("            		  AND DRL.TRD_CD          = M.TRD_CD" ).append("\n"); 
		query.append("            		  AND DRL.SUB_TRD_CD      = M.SUB_TRD_CD" ).append("\n"); 
		query.append("            		  AND DRL.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("            		  AND DRL.RLANE_CD        = RL.RLANE_CD" ).append("\n"); 
		query.append("            		  AND DRL.FM_CONTI_CD     = (SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, M.RLANE_CD, M.DIR_CD)" ).append("\n"); 
		query.append("               									   FROM MDM_LOCATION L" ).append("\n"); 
		query.append("             									  WHERE L.LOC_CD = BV.POL_CD )" ).append("\n"); 
		query.append("            		  AND DRL.TO_CONTI_CD 	  = (SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, M.RLANE_CD, M.DIR_CD)" ).append("\n"); 
		query.append("               									   FROM MDM_LOCATION L" ).append("\n"); 
		query.append("              									  WHERE L.LOC_CD = BV.POD_CD )" ).append("\n"); 
		query.append("            		  AND RL.RLANE_CD  = M.RLANE_CD" ).append("\n"); 
		query.append("            		  AND RL.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("            		  AND RL.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("        	  ) M" ).append("\n"); 
		query.append("    	)A" ).append("\n"); 
		query.append("	GROUP BY OFC_CD, PORT_CD," ).append("\n"); 
		query.append("			 USA_BKG_MOD_CD, DEST_LOC_CD --20140728" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", WK_CMB AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT RNUM," ).append("\n"); 
		query.append("           COST_YRWK," ).append("\n"); 
		query.append("           OFC_CD," ).append("\n"); 
		query.append("           TS_FLG," ).append("\n"); 
		query.append("           IOC_CD," ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           USA_BKG_MOD_CD,           " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           POL_YD_CD," ).append("\n"); 
		query.append("           POD_YD_CD," ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           DEST_LOC_CD," ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           SUM(BKG_REV)          AS BKG_REV,NVL(SUM(DMDT_COM_AMT),0) AS DMDT_COM_AMT," ).append("\n"); 
		query.append("           SUM(ESTM_CM_COST_AMT) AS ESTM_CM_COST_AMT," ).append("\n"); 
		query.append("           SUM(BKG_TTL_QTY)      AS BKG_TTL_QTY," ).append("\n"); 
		query.append("           SUM(BKG_TTL_WGT)      AS BKG_TTL_WGT," ).append("\n"); 
		query.append("           MAX(PORT_DIV)         AS PORT_DIV" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT T.RNUM," ).append("\n"); 
		query.append("                   BAR.COST_YRWK," ).append("\n"); 
		query.append("                   DECODE(P.OFC_DIV, 'RHQ', DECODE(BAR.SLS_AQ_CD, ' ', BAR.SLS_RHQ_CD, BAR.SLS_AQ_CD), BAR.SLS_OFC_CD) OFC_CD," ).append("\n"); 
		query.append("                   BAR.TS_FLG," ).append("\n"); 
		query.append("                   BAR.IOC_CD," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   CASE WHEN P.CTRL_USA = 'Y' THEN" ).append("\n"); 
		query.append("                        DECODE(BAR.USA_BKG_MOD_CD,'OTH','OTHERS',BAR.USA_BKG_MOD_CD) -- SPC_BKG_AVG_REV.LOCAL/IPI" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                        'OTHERS'" ).append("\n"); 
		query.append("                   END AS USA_BKG_MOD_CD," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   CASE WHEN P.CTRL_DEST <> 'N' THEN	" ).append("\n"); 
		query.append("                        NVL((SELECT D.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("                               FROM SPC_ALOC_LANE_CTRL_OPT_DTL D," ).append("\n"); 
		query.append("                                    MDM_LOCATION               ML1," ).append("\n"); 
		query.append("                                    MDM_LOCATION               ML2," ).append("\n"); 
		query.append("                                    MDM_EQ_ORZ_CHT             ME1," ).append("\n"); 
		query.append("                                    MDM_EQ_ORZ_CHT             ME2" ).append("\n"); 
		query.append("                              WHERE P.RLANE_CD         = D.RLANE_CD" ).append("\n"); 
		query.append("                                AND SPC_GET_REP_TRD_FNC(P.RLANE_CD)     = D.TRD_CD" ).append("\n"); 
		query.append("                                AND SPC_GET_REP_SUB_TRD_FNC(P.RLANE_CD) = D.SUB_TRD_CD" ).append("\n"); 
		query.append("                                AND P.SKD_DIR_CD       = D.DIR_CD " ).append("\n"); 
		query.append("                                AND D.ALOC_CTRL_TP_CD  = P.CTRL_DEST" ).append("\n"); 
		query.append("                                AND ML1.LOC_CD         = BAR.BKG_POD_CD" ).append("\n"); 
		query.append("                                AND ME1.SCC_CD         = ML1.SCC_CD" ).append("\n"); 
		query.append("                                AND ML2.LOC_CD         = BAR.BKG_DEL_CD" ).append("\n"); 
		query.append("                                AND ME2.SCC_CD         = ML2.SCC_CD" ).append("\n"); 
		query.append("                                AND D.CTRL_LOC_ACCT_CD = DECODE(P.CTRL_DEST_LVL,'T',DECODE(P.CTRL_DEST,'E',ME2.ECC_CD,'L',BAR.BKG_DEL_CD),DECODE(P.CTRL_DEST,'E',ME1.ECC_CD,'L',BAR.BKG_POD_CD))" ).append("\n"); 
		query.append("                           ),'XXXXX')" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                        'XXXXX'" ).append("\n"); 
		query.append("                   END AS DEST_LOC_CD," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   BAR.POL_YD_CD," ).append("\n"); 
		query.append("                   BAR.POD_YD_CD," ).append("\n"); 
		query.append("                   BAR.BKG_REV, BAR.DMDT_COM_AMT," ).append("\n"); 
		query.append("                   BAR.ESTM_CM_COST_AMT," ).append("\n"); 
		query.append("                   BAR.BKG_TTL_QTY," ).append("\n"); 
		query.append("                   BAR.USD_BKG_TTL_WGT AS BKG_TTL_WGT," ).append("\n"); 
		query.append("                   PORT_DIV" ).append("\n"); 
		query.append("             FROM SPC_BKG_AVG_REV   BAR," ).append("\n"); 
		query.append("                  (SELECT DISTINCT DENSE_RANK() OVER (ORDER BY COST_YRWK) AS RNUM," ).append("\n"); 
		query.append("                          COST_YRWK" ).append("\n"); 
		query.append("                     FROM SPC_BKG_AVG_REV" ).append("\n"); 
		query.append("                  ) T," ).append("\n"); 
		query.append("                  PARAMS            P  " ).append("\n"); 
		query.append("            WHERE BAR.COST_YRWK  = T.COST_YRWK" ).append("\n"); 
		query.append("              AND BAR.OFC_KND_CD = '3'" ).append("\n"); 
		query.append("              AND BAR.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("              AND BAR.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("              AND BAR.DIR_CD     = P.DIR_CD" ).append("\n"); 
		query.append("              AND BAR.IOC_CD     = P.IOC_CD" ).append("\n"); 
		query.append("              AND BAR.SLS_RHQ_CD = P.OFC_CD" ).append("\n"); 
		query.append("              AND BAR.POL_YD_CD <> '00000'" ).append("\n"); 
		query.append("              AND BAR.POD_YD_CD <> '00000'" ).append("\n"); 
		query.append("              AND BAR.IOC_CD = DECODE(P.IOC_CD, 'O', 'O', 'OT', 'O', 'I')" ).append("\n"); 
		query.append("              AND BAR.TS_FLG = DECODE(P.IOC_CD, 'T', 'Y', 'TT', 'Y', 'N')" ).append("\n"); 
		query.append("              AND P.IOC_CD       <> 'E'" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     GROUP BY  RNUM," ).append("\n"); 
		query.append("           COST_YRWK," ).append("\n"); 
		query.append("           OFC_CD," ).append("\n"); 
		query.append("           TS_FLG," ).append("\n"); 
		query.append("           IOC_CD," ).append("\n"); 
		query.append("           USA_BKG_MOD_CD,  " ).append("\n"); 
		query.append("           POL_YD_CD," ).append("\n"); 
		query.append("           POD_YD_CD," ).append("\n"); 
		query.append("           DEST_LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT OFC_CD ," ).append("\n"); 
		query.append("       USA_BKG_MOD_CD,                       " ).append("\n"); 
		query.append("       PORT_CD," ).append("\n"); 
		query.append("       DECODE(DEST_LOC_CD1,'XXXXX','OTHERS',DEST_LOC_CD1) AS DEST_LOC_CD," ).append("\n"); 
		query.append("       -- 주차별 CMB" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_QTY), 0, 1, SUM(BAR.BKG_TTL_QTY)))" ).append("\n"); 
		query.append("            FROM WK_CMB BAR" ).append("\n"); 
		query.append("           WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("             AND SUBSTR(Z.PORT_CD,1,5) = DECODE(BAR.PORT_DIV, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("             AND BAR.USA_BKG_MOD_CD = Z.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("             AND BAR.DEST_LOC_CD    = Z.DEST_LOC_CD1" ).append("\n"); 
		query.append("             AND BAR.RNUM = 1" ).append("\n"); 
		query.append("       ) AS CMB1," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_WGT), 0, 1, SUM(BAR.BKG_TTL_WGT)))" ).append("\n"); 
		query.append("            FROM WK_CMB BAR" ).append("\n"); 
		query.append("           WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("             AND SUBSTR(Z.PORT_CD,1,5) = DECODE(BAR.PORT_DIV, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("             AND BAR.USA_BKG_MOD_CD = Z.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("             AND BAR.DEST_LOC_CD    = Z.DEST_LOC_CD1" ).append("\n"); 
		query.append("             AND BAR.RNUM = 1" ).append("\n"); 
		query.append("       ) AS CMB_WGT1," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_QTY), 0, 1, SUM(BAR.BKG_TTL_QTY)))" ).append("\n"); 
		query.append("            FROM WK_CMB BAR" ).append("\n"); 
		query.append("           WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("             AND SUBSTR(Z.PORT_CD,1,5) = DECODE(BAR.PORT_DIV, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("             AND BAR.USA_BKG_MOD_CD = Z.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("             AND BAR.DEST_LOC_CD    = Z.DEST_LOC_CD1" ).append("\n"); 
		query.append("             AND BAR.RNUM = 2" ).append("\n"); 
		query.append("       ) AS CMB2," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_WGT), 0, 1, SUM(BAR.BKG_TTL_WGT)))" ).append("\n"); 
		query.append("            FROM WK_CMB BAR" ).append("\n"); 
		query.append("           WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("             AND SUBSTR(Z.PORT_CD,1,5) = DECODE(BAR.PORT_DIV, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("             AND BAR.USA_BKG_MOD_CD = Z.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("             AND BAR.DEST_LOC_CD    = Z.DEST_LOC_CD1" ).append("\n"); 
		query.append("             AND BAR.RNUM = 2" ).append("\n"); 
		query.append("       ) AS CMB_WGT2," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_QTY), 0, 1, SUM(BAR.BKG_TTL_QTY)))" ).append("\n"); 
		query.append("            FROM WK_CMB BAR" ).append("\n"); 
		query.append("           WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("             AND SUBSTR(Z.PORT_CD,1,5) = DECODE(BAR.PORT_DIV, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("             AND BAR.USA_BKG_MOD_CD = Z.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("             AND BAR.DEST_LOC_CD    = Z.DEST_LOC_CD1" ).append("\n"); 
		query.append("             AND BAR.RNUM = 3" ).append("\n"); 
		query.append("       ) AS CMB3," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_WGT), 0, 1, SUM(BAR.BKG_TTL_WGT)))" ).append("\n"); 
		query.append("            FROM WK_CMB BAR" ).append("\n"); 
		query.append("           WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("             AND SUBSTR(Z.PORT_CD,1,5) = DECODE(BAR.PORT_DIV, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("             AND BAR.USA_BKG_MOD_CD = Z.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("             AND BAR.DEST_LOC_CD    = Z.DEST_LOC_CD1" ).append("\n"); 
		query.append("             AND BAR.RNUM = 3" ).append("\n"); 
		query.append("       ) AS CMB_WGT3," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_QTY), 0, 1, SUM(BAR.BKG_TTL_QTY)))" ).append("\n"); 
		query.append("            FROM WK_CMB BAR" ).append("\n"); 
		query.append("           WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("             AND SUBSTR(Z.PORT_CD,1,5) = DECODE(BAR.PORT_DIV, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("             AND BAR.USA_BKG_MOD_CD = Z.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("             AND BAR.DEST_LOC_CD    = Z.DEST_LOC_CD1" ).append("\n"); 
		query.append("             AND BAR.RNUM = 4" ).append("\n"); 
		query.append("       ) AS CMB4," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_WGT), 0, 1, SUM(BAR.BKG_TTL_WGT)))" ).append("\n"); 
		query.append("            FROM WK_CMB BAR" ).append("\n"); 
		query.append("           WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("             AND SUBSTR(Z.PORT_CD,1,5) = DECODE(BAR.PORT_DIV, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("             AND BAR.USA_BKG_MOD_CD = Z.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("             AND BAR.DEST_LOC_CD    = Z.DEST_LOC_CD1" ).append("\n"); 
		query.append("             AND BAR.RNUM = 4" ).append("\n"); 
		query.append("       ) AS CMB_WGT4," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       FC_TTL_TEU," ).append("\n"); 
		query.append("       FCT_VOL," ).append("\n"); 
		query.append("       FCT_HC ," ).append("\n"); 
		query.append("       FCT_45 ," ).append("\n"); 
		query.append("       FCT_53 ," ).append("\n"); 
		query.append("       FCT_RF ," ).append("\n"); 
		query.append("       FCT_WGT," ).append("\n"); 
		query.append("       FCT_D2 ," ).append("\n"); 
		query.append("       FCT_D4 ," ).append("\n"); 
		query.append("       FCT_RD ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ALC_VOL," ).append("\n"); 
		query.append("       ALC_HC ," ).append("\n"); 
		query.append("       ALC_45 ," ).append("\n"); 
		query.append("       ALC_53 ," ).append("\n"); 
		query.append("       ALC_RF ," ).append("\n"); 
		query.append("       ALC_WGT," ).append("\n"); 
		query.append("       ALC_D2 ," ).append("\n"); 
		query.append("       ALC_D4 ," ).append("\n"); 
		query.append("       ALC_RD ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       BKG_VOL," ).append("\n"); 
		query.append("       BKG_20 ," ).append("\n"); 
		query.append("       BKG_40 ," ).append("\n"); 
		query.append("       BKG_HC ," ).append("\n"); 
		query.append("       BKG_45 ," ).append("\n"); 
		query.append("       BKG_53 ," ).append("\n"); 
		query.append("       BKG_RF ," ).append("\n"); 
		query.append("       BKG_WGT,BKG_VOL_VGM,BKG_WGT_VGM," ).append("\n"); 
		query.append("       BKG_D2 ," ).append("\n"); 
		query.append("       BKG_D4 ," ).append("\n"); 
		query.append("       BKG_RD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("      SELECT OFC_CD ," ).append("\n"); 
		query.append("             USA_BKG_MOD_CD,                       " ).append("\n"); 
		query.append("             PORT_CD," ).append("\n"); 
		query.append("             DEST_LOC_CD AS DEST_LOC_CD1," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             SUM(NVL(FCT_VOL, 0) + NVL(FCT_HC, 0) * 2 + NVL(FCT_45, 0) * 2 + NVL(FCT_53, 0) * 2) AS FC_TTL_TEU," ).append("\n"); 
		query.append("             SUM(FCT_VOL) AS FCT_VOL," ).append("\n"); 
		query.append("             SUM(FCT_HC)  AS FCT_HC ," ).append("\n"); 
		query.append("             SUM(FCT_45)  AS FCT_45 ," ).append("\n"); 
		query.append("             SUM(FCT_53)  AS FCT_53 ," ).append("\n"); 
		query.append("             SUM(FCT_RF)  AS FCT_RF ," ).append("\n"); 
		query.append("             SUM(FCT_WGT) AS FCT_WGT," ).append("\n"); 
		query.append("             SUM(FCT_D2)  AS FCT_D2 ," ).append("\n"); 
		query.append("             SUM(FCT_D4)  AS FCT_D4 ," ).append("\n"); 
		query.append("             SUM(FCT_RD)  AS FCT_RD ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             NVL(SUM(ALC_VOL),0) AS ALC_VOL," ).append("\n"); 
		query.append("             NVL(SUM(ALC_HC),0)  AS ALC_HC ," ).append("\n"); 
		query.append("             NVL(SUM(ALC_45),0)  AS ALC_45 ," ).append("\n"); 
		query.append("             NVL(SUM(ALC_53),0)  AS ALC_53 ," ).append("\n"); 
		query.append("             NVL(SUM(ALC_RF),0)  AS ALC_RF ," ).append("\n"); 
		query.append("             NVL(SUM(ALC_WGT),0) AS ALC_WGT," ).append("\n"); 
		query.append("             NVL(SUM(ALC_D2),0)  AS ALC_D2 ," ).append("\n"); 
		query.append("             NVL(SUM(ALC_D4),0)  AS ALC_D4 ," ).append("\n"); 
		query.append("             NVL(SUM(ALC_RD),0)  AS ALC_RD ," ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("             SUM(BKG_VOL) AS BKG_VOL," ).append("\n"); 
		query.append("             SUM(BKG_20)  AS BKG_20 ," ).append("\n"); 
		query.append("             SUM(BKG_40)  AS BKG_40 ," ).append("\n"); 
		query.append("             SUM(BKG_HC)  AS BKG_HC ," ).append("\n"); 
		query.append("             SUM(BKG_45)  AS BKG_45 ," ).append("\n"); 
		query.append("             SUM(BKG_53)  AS BKG_53 ," ).append("\n"); 
		query.append("             SUM(BKG_RF)  AS BKG_RF ," ).append("\n"); 
		query.append("             SUM(BKG_WGT) AS BKG_WGT,SUM(BKG_VOL_VGM) AS BKG_VOL_VGM,SUM(BKG_WGT_VGM) AS BKG_WGT_VGM," ).append("\n"); 
		query.append("             SUM(BKG_D2)  AS BKG_D2 ," ).append("\n"); 
		query.append("             SUM(BKG_D4)  AS BKG_D4 ," ).append("\n"); 
		query.append("             SUM(BKG_RD)  AS BKG_RD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT ''   AS OFC_CD ," ).append("\n"); 
		query.append("                       ''   AS USA_BKG_MOD_CD," ).append("\n"); 
		query.append("                       ''   AS PORT_CD," ).append("\n"); 
		query.append("                       ''   AS DEST_LOC_CD," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       0    AS FCT_VOL," ).append("\n"); 
		query.append("                       0    AS FCT_HC ," ).append("\n"); 
		query.append("                       0    AS FCT_45 ," ).append("\n"); 
		query.append("                       0    AS FCT_53 ," ).append("\n"); 
		query.append("                       0    AS FCT_RF ," ).append("\n"); 
		query.append("                       0    AS FCT_WGT," ).append("\n"); 
		query.append("                       0    AS FCT_D2 ," ).append("\n"); 
		query.append("                       0    AS FCT_D4 ," ).append("\n"); 
		query.append("                       0    AS FCT_RD ," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       NULL AS ALC_VOL," ).append("\n"); 
		query.append("                       NULL AS ALC_HC ," ).append("\n"); 
		query.append("                       NULL AS ALC_45 ," ).append("\n"); 
		query.append("                       NULL AS ALC_53 ," ).append("\n"); 
		query.append("                       NULL AS ALC_RF ," ).append("\n"); 
		query.append("                       NULL AS ALC_WGT," ).append("\n"); 
		query.append("                       NULL AS ALC_D2 ," ).append("\n"); 
		query.append("                       NULL AS ALC_D4 ," ).append("\n"); 
		query.append("                       NULL AS ALC_RD ," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       0    AS BKG_VOL," ).append("\n"); 
		query.append("                       0    AS BKG_20 ," ).append("\n"); 
		query.append("                       0    AS BKG_40 ," ).append("\n"); 
		query.append("                       0    AS BKG_HC ," ).append("\n"); 
		query.append("                       0    AS BKG_45 ," ).append("\n"); 
		query.append("                       0    AS BKG_53 ," ).append("\n"); 
		query.append("                       0    AS BKG_RF ," ).append("\n"); 
		query.append("                       0    AS BKG_WGT, 0    AS BKG_VOL_VGM,0    AS BKG_WGT_VGM," ).append("\n"); 
		query.append("                       0    AS BKG_D2 ," ).append("\n"); 
		query.append("                       0    AS BKG_D4 ," ).append("\n"); 
		query.append("                       0    AS BKG_RD " ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("                 WHERE ROWNUM = 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_pod} != 'DEL')" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("                SELECT OFC_CD ," ).append("\n"); 
		query.append("                       USA_BKG_MOD_CD,                       " ).append("\n"); 
		query.append("                       PORT_CD," ).append("\n"); 
		query.append("                       DEST_LOC_CD," ).append("\n"); 
		query.append("                       VOL_TTL," ).append("\n"); 
		query.append("                       VOL_HC ," ).append("\n"); 
		query.append("                       VOL_45 ," ).append("\n"); 
		query.append("                       VOL_53 ," ).append("\n"); 
		query.append("                       VOL_RF ," ).append("\n"); 
		query.append("                       WGT_TTL," ).append("\n"); 
		query.append("                       VOL_D2 ," ).append("\n"); 
		query.append("                       VOL_D4 ," ).append("\n"); 
		query.append("                       VOL_RD ," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       NULL AS ALC_VOL," ).append("\n"); 
		query.append("                       NULL AS ALC_HC ," ).append("\n"); 
		query.append("                       NULL AS ALC_45 ," ).append("\n"); 
		query.append("                       NULL AS ALC_53 ," ).append("\n"); 
		query.append("                       NULL AS ALC_RF ," ).append("\n"); 
		query.append("                       NULL AS ALC_WGT," ).append("\n"); 
		query.append("                       NULL AS ALC_D2 ," ).append("\n"); 
		query.append("                       NULL AS ALC_D4 ," ).append("\n"); 
		query.append("                       NULL AS ALC_RD ," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0,0,0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0" ).append("\n"); 
		query.append("                  FROM FCST_DATA" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT OFC_CD ," ).append("\n"); 
		query.append("                       USA_BKG_MOD_CD,                       " ).append("\n"); 
		query.append("                       PORT_CD," ).append("\n"); 
		query.append("                       DEST_LOC_CD," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       VOL_TTL," ).append("\n"); 
		query.append("                       VOL_HC ," ).append("\n"); 
		query.append("                       VOL_45 ," ).append("\n"); 
		query.append("                       VOL_53 ," ).append("\n"); 
		query.append("                       VOL_RF ," ).append("\n"); 
		query.append("                       WGT_TTL," ).append("\n"); 
		query.append("                       VOL_D2 ," ).append("\n"); 
		query.append("                       VOL_D4 ," ).append("\n"); 
		query.append("                       VOL_RD ," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0,0,0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0" ).append("\n"); 
		query.append("                  FROM ALOC_DATA" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT OFC_CD ," ).append("\n"); 
		query.append("                       USA_BKG_MOD_CD,                       " ).append("\n"); 
		query.append("                       PORT_CD," ).append("\n"); 
		query.append("                       DEST_LOC_CD," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       0," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       NULL AS ALC_VOL," ).append("\n"); 
		query.append("                       NULL AS ALC_HC ," ).append("\n"); 
		query.append("                       NULL AS ALC_45 ," ).append("\n"); 
		query.append("                       NULL AS ALC_53 ," ).append("\n"); 
		query.append("                       NULL AS ALC_RF ," ).append("\n"); 
		query.append("                       NULL AS ALC_WGT," ).append("\n"); 
		query.append("                       NULL AS ALC_D2 ," ).append("\n"); 
		query.append("                       NULL AS ALC_D4 ," ).append("\n"); 
		query.append("                       NULL AS ALC_RD ," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       BKG_TTL," ).append("\n"); 
		query.append("                       BKG_20 ," ).append("\n"); 
		query.append("                       BKG_40 ," ).append("\n"); 
		query.append("                       BKG_HC ," ).append("\n"); 
		query.append("                       BKG_45 ," ).append("\n"); 
		query.append("                       BKG_53 ," ).append("\n"); 
		query.append("                       BKG_RF ," ).append("\n"); 
		query.append("                       BKG_WGT,BKG_VOL_VGM,BKG_WGT_VGM," ).append("\n"); 
		query.append("                       BKG_D2 ," ).append("\n"); 
		query.append("                       BKG_D4 ," ).append("\n"); 
		query.append("                       BKG_RD " ).append("\n"); 
		query.append("                  FROM BKG_DATA" ).append("\n"); 
		query.append("             ) Z" ).append("\n"); 
		query.append("    GROUP BY OFC_CD," ).append("\n"); 
		query.append("             USA_BKG_MOD_CD,                       " ).append("\n"); 
		query.append("             PORT_CD," ).append("\n"); 
		query.append("             DEST_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("    ORDER BY OFC_CD," ).append("\n"); 
		query.append("             USA_BKG_MOD_CD,                       " ).append("\n"); 
		query.append("             PORT_CD," ).append("\n"); 
		query.append("             DEST_LOC_CD1" ).append("\n"); 

	}
}