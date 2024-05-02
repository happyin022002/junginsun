/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchRepairPFMCByEqNoDataCCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.07
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.03.07 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchRepairPFMCByEqNoDataCCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&R 실적을 EQ No별 인건비/자재비로 각각 구분하여 조회
	  * * --------------------------------------------------------
	  * * History
	  * * 2012.01.18 김상수 [CSR선처리] Guideline & PFMC > General Performance > PFMC by EQ No 보완
	  * *                                           - 조회조건 중 [USD Only] 항목이 적용되지 않는 부분 수정
	  * * 2013.01.03 조경완 [CHM-201222154-01] ALPS MNR-Repair-Repair Inquiry화면에서 multi 조회 요청 건
	  * *                                           - EQ_NO 조회조건절 변경
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchRepairPFMCByEqNoDataCCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("manu_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unit_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchRepairPFMCByEqNoDataCCRSQL").append("\n"); 
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
		query.append("WITH LV_EQ_V AS (" ).append("\n"); 
		query.append("    SELECT 'U' EQ_TYPE," ).append("\n"); 
		query.append("      A.CNTR_NO EQ_NO," ).append("\n"); 
		query.append("      A.LSTM_CD LSTM_CD," ).append("\n"); 
		query.append("      A.RF_MKR_SEQ EQ_RF_MKR_SEQ," ).append("\n"); 
		query.append("      A.MFTR_VNDR_SEQ EQ_MKR_SEQ," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND A.MFTR_VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("      ) AS MKR_NM," ).append("\n"); 
		query.append("      TO_CHAR (A.MFT_DT, 'YYYY-MM-DD') MANU_DT" ).append("\n"); 
		query.append("    FROM MST_CONTAINER A" ).append("\n"); 
		query.append("#if (${eq_type} == 'A' || ${eq_type} == 'A,U,Z,G' || ${eq_type} == 'U' || ${eq_type} == 'U,Z' || ${eq_type} == 'U,G') " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#elseif (${eq_type} == 'Z' || ${eq_type} == 'G' || ${eq_type} == 'Z,G') " ).append("\n"); 
		query.append("    WHERE 1=0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT A.EQ_KND_CD EQ_TYPE," ).append("\n"); 
		query.append("      A.EQ_NO EQ_NO," ).append("\n"); 
		query.append("      A.AGMT_LSTM_CD LSTM_CD," ).append("\n"); 
		query.append("      0 EQ_RF_MKR_SEQ," ).append("\n"); 
		query.append("      0 EQ_MKR_SEQ," ).append("\n"); 
		query.append("      '' MKR_NM," ).append("\n"); 
		query.append("      TO_CHAR (A.MFT_DT, 'YYYY-MM-DD') MANU_DT" ).append("\n"); 
		query.append("    FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("#if (${eq_type} == 'A' || ${eq_type} == 'A,U,Z,G' || ${eq_type} == 'Z' || ${eq_type} == 'G' || ${eq_type} == 'U,Z' || ${eq_type} == 'U,G' || ${eq_type} == 'Z,G') " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#elseif (${eq_type} == 'U') " ).append("\n"); 
		query.append("    WHERE 1=0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("( SELECT A.MNR_CD_DP_DESC		" ).append("\n"); 
		query.append("  FROM MNR_GEN_CD A" ).append("\n"); 
		query.append("  WHERE A.PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("  AND A.MNR_CD_ID = RD.MNR_VRFY_TP_CD) AS VERIFY_RESULT" ).append("\n"); 
		query.append(",OD.ACCT_CD AS ACCT_CD" ).append("\n"); 
		query.append(",OD.MNR_ORD_OFC_CTY_CD AS MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(",OD.MNR_ORD_SEQ AS MNR_ORD_SEQ" ).append("\n"); 
		query.append(",OD.MNR_ORD_OFC_CTY_CD || OD.MNR_ORD_SEQ AS WO_NO" ).append("\n"); 
		query.append(",DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD) AS WO_CURRENCY" ).append("\n"); 
		query.append(",OD.CRE_DT AS WO_DATE" ).append("\n"); 
		query.append(",TO_CHAR(OD.CRE_DT, 'yyyy-mm-dd') WO_DATE" ).append("\n"); 
		query.append(",RH.VNDR_SEQ" ).append("\n"); 
		query.append(",(SELECT MV.VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = RH.VNDR_SEQ AND ROWNUM =1) AS VNDR_SEQ_NM" ).append("\n"); 
		query.append(",MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RH.COST_OFC_CD) AS RHQ_NM" ).append("\n"); 
		query.append(",RH.COST_OFC_CD  AS OFC_CD" ).append("\n"); 
		query.append(",OD.MNR_RT_TP_CD AS MNR_RT_TP_CD" ).append("\n"); 
		query.append(",RH.RQST_EQ_NO AS EQ_NO" ).append("\n"); 
		query.append(",RH.EQ_TPSZ_CD AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(",ESV.LSTM_CD AS TERM" ).append("\n"); 
		query.append(",ESV.MKR_NM AS MANUDACTURER_NAME" ).append("\n"); 
		query.append(",ESV.MANU_DT AS MANU_DT" ).append("\n"); 
		query.append(",RH.RPR_YD_CD AS REPAIR_YARD" ).append("\n"); 
		query.append(",RD.EQ_CMPO_CD AS EQ_CMPO_CD" ).append("\n"); 
		query.append(", (SELECT MCD.EQ_CMPO_NM" ).append("\n"); 
		query.append("	FROM MNR_EQ_CMPO_CD MCD" ).append("\n"); 
		query.append("	WHERE MCD.EQ_CMPO_GRP_TP_CD = '3'" ).append("\n"); 
		query.append("	AND MCD.EQ_CMPO_CD = RD.EQ_CMPO_CD" ).append("\n"); 
		query.append("	AND ROWNUM = 1) AS EQ_CMPO_NM" ).append("\n"); 
		query.append(", RD.EQ_RPR_CD AS EQ_RPR_CD" ).append("\n"); 
		query.append(", (SELECT MROD.EQ_CEDEX_OTR_CD_NM" ).append("\n"); 
		query.append("	FROM MNR_CEDEX_OTR_CD MROD" ).append("\n"); 
		query.append("	WHERE MROD.EQ_CEDEX_OTR_TP_CD = 'RPR'" ).append("\n"); 
		query.append("	AND MROD.EQ_CEDEX_OTR_CD = RD.EQ_RPR_CD" ).append("\n"); 
		query.append("	AND ROWNUM = 1) AS EQ_RPR_NM" ).append("\n"); 
		query.append(", RD.TRF_DIV_CD AS TRF_DIV_CD" ).append("\n"); 
		query.append(",(SELECT MCR.MNR_RLT_CD_DESC" ).append("\n"); 
		query.append("  FROM MNR_CD_RLT MCR" ).append("\n"); 
		query.append(" WHERE MCR.EQ_CEDEX_RLT_TP_CD = 'CTV'" ).append("\n"); 
		query.append("   AND MCR.COST_GRP_CD LIKE SUBSTR(RD.COST_CD, 0, 3) || '%'" ).append("\n"); 
		query.append("   AND MCR.FM_RLT_CD = (RD.EQ_CMPO_CD || RD.EQ_RPR_CD)" ).append("\n"); 
		query.append("   AND MCR.TO_RLT_CD = RD.TRF_DIV_CD" ).append("\n"); 
		query.append("   AND ROWNUM = 1) AS TRF_DIV_NM" ).append("\n"); 
		query.append(", RD.EQ_LOC_CD AS EQ_LOC_CD" ).append("\n"); 
		query.append(", RD.EQ_DMG_CD AS EQ_DMG_CD" ).append("\n"); 
		query.append(", (SELECT MROD.EQ_CEDEX_OTR_CD_NM" ).append("\n"); 
		query.append("FROM MNR_CEDEX_OTR_CD MROD" ).append("\n"); 
		query.append("WHERE MROD.EQ_CEDEX_OTR_CD = RD.EQ_DMG_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS EQ_DMG_NM" ).append("\n"); 
		query.append(", RH.CURR_CD AS CURRENCY" ).append("\n"); 
		query.append(", RD.RPR_QTY ||' '|| RD.RPR_SZ_NO AS QTY_SIZE" ).append("\n"); 
		query.append(",RD.RPR_LBR_HRS" ).append("\n"); 
		query.append(",ESV.EQ_RF_MKR_SEQ" ).append("\n"); 
		query.append(",(SELECT MVD.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MVD" ).append("\n"); 
		query.append("WHERE MVD.VNDR_SEQ = ESV.EQ_RF_MKR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS EQ_RF_MKR_NM" ).append("\n"); 
		query.append(",ESV.EQ_MKR_SEQ" ).append("\n"); 
		query.append(",(SELECT MVD.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MVD" ).append("\n"); 
		query.append("WHERE MVD.VNDR_SEQ = ESV.EQ_MKR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS EQ_MKR_NM" ).append("\n"); 
		query.append(",(SELECT ELC.EQ_LOC_NM" ).append("\n"); 
		query.append("FROM MNR_EQ_LOC_CD ELC" ).append("\n"); 
		query.append("WHERE ELC.EQ_LOC_CD = RD.EQ_LOC_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS EQ_LOC_NM" ).append("\n"); 
		query.append(",SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT)) WO_AMT " ).append("\n"); 
		query.append(",SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.LBR_COST_AMT)) LBR_COST_AMT " ).append("\n"); 
		query.append(",SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MTRL_COST_AMT)) MTRL_COST_AMT" ).append("\n"); 
		query.append(",SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.CRE_DT, 'YYYYMM'), RH.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', RH.CURR_CD), RD.MNR_WRK_AMT)) E_TOTAL_AMT" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR RH" ).append("\n"); 
		query.append("   , MNR_RPR_RQST_DTL RD" ).append("\n"); 
		query.append("   , MNR_ORD_HDR OH" ).append("\n"); 
		query.append("   , MNR_ORD_DTL OD" ).append("\n"); 
		query.append("   , LV_EQ_V ESV" ).append("\n"); 
		query.append("WHERE RH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   RH.RQST_EQ_NO      = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_SEQ    = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND   RH.RPR_RQST_LST_VER_FLG = RD.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("AND   RH.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND   RH.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("AND   OD.MNR_ORD_OFC_CTY_CD(+) = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   OD.MNR_ORD_SEQ(+)        = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   ESV.EQ_NO(+)   = RH.RQST_EQ_NO" ).append("\n"); 
		query.append("AND   ESV.EQ_TYPE(+) = RH.EQ_KND_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("	AND   OH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[fm_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND   RH.RQST_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[fm_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[to_dt], 'YYYY-MM-DD'), MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+ 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_type} != 'A' && ${eq_type} != 'A,U,Z,G')" ).append("\n"); 
		query.append("AND RH.EQ_KND_CD IN (" ).append("\n"); 
		query.append("	#foreach ($user_eqTypes IN ${eqTypes})" ).append("\n"); 
		query.append("		#if($velocityCount < $eqTypes.size())" ).append("\n"); 
		query.append("			'$user_eqTypes'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$user_eqTypes'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_sz_cd} != '') " ).append("\n"); 
		query.append("	AND	RH.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("			#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("				'$user_tpszCds'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_tpszCds'" ).append("\n"); 
		query.append("			#end	" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A') " ).append("\n"); 
		query.append("AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(RH.COST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A') " ).append("\n"); 
		query.append("AND RH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("AND RH.VNDR_SEQ   = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${acct_cd} != '') " ).append("\n"); 
		query.append("	#if (${acct_cd} != 'A')" ).append("\n"); 
		query.append("	AND OD.ACCT_CD   = @[acct_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != '') " ).append("\n"); 
		query.append("	#if (${lstm_cd} != 'A') " ).append("\n"); 
		query.append("	AND ESV.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${manu_vndr_seq} != '') " ).append("\n"); 
		query.append("	#if (${manu_vndr_seq} != 'A') " ).append("\n"); 
		query.append("	AND ESV.EQ_MKR_SEQ = @[manu_vndr_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_date} != '' && ${to_date} != '') " ).append("\n"); 
		query.append("AND ESV.MANU_DT BETWEEN @[from_date] AND @[to_date]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${unit_vndr_seq} != '') " ).append("\n"); 
		query.append("	#if (${unit_vndr_seq} != 'A') " ).append("\n"); 
		query.append("	AND ESV.EQ_RF_MKR_SEQ = @[unit_vndr_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_list} != '')" ).append("\n"); 
		query.append("	AND	RH.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_eqNos IN ${eqNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("				'$user_eqNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_eqNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${verify_result} != '') " ).append("\n"); 
		query.append("	AND RD.MNR_VRFY_TP_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_verifyResults IN ${verifyResults})" ).append("\n"); 
		query.append("			#if($velocityCount < $verifyResults.size())" ).append("\n"); 
		query.append("				'$user_verifyResults'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_verifyResults'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY OD.MNR_VRFY_TP_CD, RD.MNR_VRFY_TP_CD" ).append("\n"); 
		query.append(",OD.ACCT_CD,OD.MNR_ORD_OFC_CTY_CD,OD.MNR_ORD_SEQ,RH.CURR_CD,OD.COST_AMT" ).append("\n"); 
		query.append(",OD.CRE_DT,RH.VNDR_SEQ,RH.COST_OFC_CD,OD.MNR_RT_TP_CD" ).append("\n"); 
		query.append(",RH.RQST_EQ_NO ,RH.EQ_TPSZ_CD,ESV.LSTM_CD,ESV.MKR_NM,ESV.MANU_DT,RH.RPR_YD_CD" ).append("\n"); 
		query.append(",RD.EQ_CMPO_CD,RD.EQ_RPR_CD,RD.TRF_DIV_CD,RD.COST_CD,RD.EQ_LOC_CD" ).append("\n"); 
		query.append(",RD.EQ_DMG_CD,RD.MTRL_COST_AMT,RD.RPR_QTY,RD.RPR_SZ_NO,RD.LBR_COST_AMT" ).append("\n"); 
		query.append(",RD.RPR_LBR_HRS,ESV.EQ_RF_MKR_SEQ,ESV.EQ_MKR_SEQ" ).append("\n"); 

	}
}