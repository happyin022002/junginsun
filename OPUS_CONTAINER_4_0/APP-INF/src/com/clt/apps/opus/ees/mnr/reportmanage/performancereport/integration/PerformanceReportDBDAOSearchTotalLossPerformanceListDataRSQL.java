/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchTotalLossPerformanceListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchTotalLossPerformanceListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTotalLossPerformanceListData
	  * 2014-02-17 Jonghee HAN WITH PARAM 조회 조건 추가 FPMC 향상
	  * ------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchTotalLossPerformanceListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_dtl_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_lss_cmpl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_kind",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchTotalLossPerformanceListDataRSQL").append("\n"); 
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
		query.append("WITH CLT_PARAM " ).append("\n"); 
		query.append("AS (SELECT MTRD.TTL_LSS_NO, MTRD.TTL_LSS_DTL_SEQ, MTRD.MNR_INV_TP_CD, MTLC.CLT_AMT, MTLC.CURR_CD" ).append("\n"); 
		query.append("      FROM MNR_TTL_LSS_RQST_HDR MTRH, MNR_TTL_LSS_RQST_DTL MTRD, MNR_TTL_LSS_CLT MTLC" ).append("\n"); 
		query.append("     WHERE MTRH.TTL_LSS_NO = MTRD.TTL_LSS_NO" ).append("\n"); 
		query.append("       AND MTRD.TTL_LSS_NO = MTLC.TTL_LSS_NO" ).append("\n"); 
		query.append("       AND MTRD.TTL_LSS_DTL_SEQ IN MTLC.TTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append("#if (${eq_kind} != 'A')" ).append("\n"); 
		query.append("AND   MTRD.EQ_KND_CD  = @[eq_kind]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A')" ).append("\n"); 
		query.append("AND   MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MTRH.RQST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("AND   (MTRH.RQST_OFC_CD = @[ofc_cd] OR MTRH.RESPB_OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_search_dt_tp} == 'R')" ).append("\n"); 
		query.append("    AND MTRH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999    " ).append("\n"); 
		query.append("#elseif (${in_search_dt_tp} == 'C')" ).append("\n"); 
		query.append("	AND MTRH.TTL_LSS_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("#else	" ).append("\n"); 
		query.append("	AND MTRD.TTL_LSS_CMPL_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("#end	 	" ).append("\n"); 
		query.append("#if (${in_status_tp} == 'S')" ).append("\n"); 
		query.append("	 AND MTRH.TTL_LSS_STS_CD IN ('HS') " ).append("\n"); 
		query.append("#elseif (${in_status_tp} == 'R')" ).append("\n"); 
		query.append("     AND MTRH.TTL_LSS_STS_CD IN ('HR')" ).append("\n"); 
		query.append("#elseif (${in_status_tp} == 'P')" ).append("\n"); 
		query.append("     AND MTRH.TTL_LSS_STS_CD IN ('HA','HC')" ).append("\n"); 
		query.append("#elseif (${in_status_tp} == 'C') " ).append("\n"); 
		query.append("     AND MTRH.TTL_LSS_STS_CD IN ('HE')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${eq_no} != '')" ).append("\n"); 
		query.append("	AND	MTRD.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_eqNos IN ${eqNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("				'$user_eqNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_eqNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${total_loss_no} != '')" ).append("\n"); 
		query.append("	AND	MTRH.TTL_LSS_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_totalLossNos IN ${totalLossNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $totalLossNos.size())" ).append("\n"); 
		query.append("				'$user_totalLossNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_totalLossNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if (${rsn_cd} != 'A')" ).append("\n"); 
		query.append("AND   MTRH.TTL_LSS_RSN_CD = @[rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ttl_lss_dtl_rsn_cd} != 'A')" ).append("\n"); 
		query.append("AND   MTRH.TTL_LSS_DTL_RSN_CD = @[ttl_lss_dtl_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ttl_lss_cmpl_cd} != 'A')" ).append("\n"); 
		query.append("AND   MTRD.TTL_LSS_CMPL_CD = @[ttl_lss_cmpl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    UNION ALL   " ).append("\n"); 
		query.append("    SELECT MTRD.TTL_LSS_NO, MTRD.TTL_LSS_DTL_SEQ, MTRD.MNR_INV_TP_CD, BOD.RCT_AMT CLT_AMT, BOD.CURR_CD" ).append("\n"); 
		query.append("      FROM MNR_TTL_LSS_RQST_HDR MTRH, MNR_TTL_LSS_RQST_DTL MTRD, MNR_DISP_DTL MDD," ).append("\n"); 
		query.append("		(SELECT BL_NO CLT_BL_NO, BL_CURR_CD CURR_CD," ).append("\n"); 
		query.append("            SUM(RCT_AMT) RCT_AMT" ).append("\n"); 
		query.append("          FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("         GROUP BY BL_NO, BL_CURR_CD) BOD" ).append("\n"); 
		query.append("     WHERE MTRH.TTL_LSS_NO = MTRD.TTL_LSS_NO" ).append("\n"); 
		query.append("       AND MTRD.RQST_EQ_NO = MDD.EQ_NO" ).append("\n"); 
		query.append("       AND MTRD.MNR_INV_TP_CD = 'DS'" ).append("\n"); 
		query.append("       AND MDD.INV_NO = BOD.CLT_BL_NO" ).append("\n"); 
		query.append("#if (${eq_kind} != 'A')" ).append("\n"); 
		query.append("AND   MTRD.EQ_KND_CD  = @[eq_kind]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A')" ).append("\n"); 
		query.append("AND   MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MTRH.RQST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("AND   (MTRH.RQST_OFC_CD = @[ofc_cd] OR MTRH.RESPB_OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_search_dt_tp} == 'R')" ).append("\n"); 
		query.append("    AND MTRH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999    " ).append("\n"); 
		query.append("#elseif (${in_search_dt_tp} == 'C')" ).append("\n"); 
		query.append("	AND MTRH.TTL_LSS_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("#else	" ).append("\n"); 
		query.append("	AND MTRD.TTL_LSS_CMPL_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("#end	 	" ).append("\n"); 
		query.append("#if (${in_status_tp} == 'S')" ).append("\n"); 
		query.append("	 AND MTRH.TTL_LSS_STS_CD IN ('HS') " ).append("\n"); 
		query.append("#elseif (${in_status_tp} == 'R')" ).append("\n"); 
		query.append("     AND MTRH.TTL_LSS_STS_CD IN ('HR')" ).append("\n"); 
		query.append("#elseif (${in_status_tp} == 'P')" ).append("\n"); 
		query.append("     AND MTRH.TTL_LSS_STS_CD IN ('HA','HC')" ).append("\n"); 
		query.append("#elseif (${in_status_tp} == 'C') " ).append("\n"); 
		query.append("     AND MTRH.TTL_LSS_STS_CD IN ('HE')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${eq_no} != '')" ).append("\n"); 
		query.append("	AND	MTRD.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_eqNos IN ${eqNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("				'$user_eqNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_eqNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${total_loss_no} != '')" ).append("\n"); 
		query.append("	AND	MTRH.TTL_LSS_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_totalLossNos IN ${totalLossNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $totalLossNos.size())" ).append("\n"); 
		query.append("				'$user_totalLossNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_totalLossNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if (${rsn_cd} != 'A')" ).append("\n"); 
		query.append("AND   MTRH.TTL_LSS_RSN_CD = @[rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ttl_lss_dtl_rsn_cd} != 'A')" ).append("\n"); 
		query.append("AND   MTRH.TTL_LSS_DTL_RSN_CD = @[ttl_lss_dtl_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ttl_lss_cmpl_cd} != 'A')" ).append("\n"); 
		query.append("AND   MTRD.TTL_LSS_CMPL_CD = @[ttl_lss_cmpl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  DENSE_RANK() OVER (ORDER BY TH.TTL_LSS_NO ASC) TMPSEQ" ).append("\n"); 
		query.append("        ,TH.TTL_LSS_NO" ).append("\n"); 
		query.append("        ,TD.RQST_EQ_NO" ).append("\n"); 
		query.append("        ,MAX(TH.RQST_OFC_CD) RQST_OFC_CD" ).append("\n"); 
		query.append("        ,MAX(TH.APRO_OFC_CD) APRO_OFC_CD" ).append("\n"); 
		query.append("        ,MAX(DECODE(TH.RESPB_OFC_CD,null,TH.RQST_OFC_CD,'',TH.RQST_OFC_CD,TH.RESPB_OFC_CD)) RESPB_OFC_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(MAX(TH.TTL_LSS_DT), 'yyyy-mm-dd') TTL_LSS_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(TH.RQST_DT),'SINHO'), 'yyyy-mm-dd') RQST_DT" ).append("\n"); 
		query.append("        ,MAX((SELECT MNR_CD_DP_DESC" ).append("\n"); 
		query.append("              FROM MNR_GEN_CD" ).append("\n"); 
		query.append("              WHERE PRNT_CD_ID='CD00039'" ).append("\n"); 
		query.append("                AND MNR_CD_ID=TH.TTL_LSS_STS_CD" ).append("\n"); 
		query.append("            )) AS TTL_LSS_STS_NM" ).append("\n"); 
		query.append("        ,TO_CHAR(DECODE(MAX(TH.TTL_LSS_STS_CD),'HE',GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(TH.TTL_LSS_CFM_DT),'SINHO'),null), 'yyyy-mm-dd') TTL_LSS_CFM_DT" ).append("\n"); 
		query.append("        ,MAX((SELECT MNR_CD_DP_DESC" ).append("\n"); 
		query.append("              FROM MNR_GEN_CD" ).append("\n"); 
		query.append("              WHERE PRNT_CD_ID='TR'" ).append("\n"); 
		query.append("                AND MNR_CD_ID=TH.TTL_LSS_RSN_CD" ).append("\n"); 
		query.append("            )) AS TTL_LSS_RSN_NM" ).append("\n"); 
		query.append("        ,MAX((SELECT MNR_CD_DP_DESC" ).append("\n"); 
		query.append("              FROM MNR_GEN_CD" ).append("\n"); 
		query.append("              WHERE PRNT_CD_ID=TH.TTL_LSS_RSN_CD" ).append("\n"); 
		query.append("                AND MNR_CD_ID=TH.TTL_LSS_DTL_RSN_CD" ).append("\n"); 
		query.append("            )) AS TTL_LSS_DTL_RSN_NM" ).append("\n"); 
		query.append("        ,MAX((SELECT MNR_CD_DESC FROM  MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00072' AND MNR_CD_ID = TD.TTL_LSS_CMPL_CD)) TTL_LSS_DTL_CMPL_NM" ).append("\n"); 
		query.append("        ,TO_CHAR(MAX(TD.TTL_LSS_CMPL_DT), 'yyyy-mm-dd') TTL_LSS_DTL_CMPL_DT" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DV', NVL(TD.DPC_VAL_AMT,0))),0) DV_DV_VAL" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DV', NVL(TTL_LSS_BIL_AMT,0))),0) DV_EXP" ).append("\n"); 
		query.append("        ,MAX(DECODE(TD.MNR_INV_TP_CD, 'DV', TD.CURR_CD, '')) DV_CURR_CD" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'TP', NVL(TTL_LSS_BIL_AMT,0))),0) TP_EXP" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(CP.MNR_INV_TP_CD, 'TP', NVL(CP.CLT_AMT,0))), 0) TP_COL" ).append("\n"); 
		query.append("        ,MAX(DECODE(TD.MNR_INV_TP_CD, 'TP', TD.CURR_CD, '')) TP_CURR_CD" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DS', NVL(TTL_LSS_BIL_AMT,0))),0) DS_EXP" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(CP.MNR_INV_TP_CD, 'DS', NVL(CP.CLT_AMT,0))), 0) DS_COL" ).append("\n"); 
		query.append("        ,MAX(DECODE(TD.MNR_INV_TP_CD, 'DS', TD.CURR_CD, '')) DS_CURR_CD" ).append("\n"); 
		query.append("        ,MAX(TH.TTL_LSS_RMK) TTL_LSS_RMK" ).append("\n"); 
		query.append("        ,MAX(TH.FILE_SEQ) FILE_SEQ" ).append("\n"); 
		query.append("		,MAX(TH.TTL_LSS_STS_CD) TTL_LSS_STS_CD" ).append("\n"); 
		query.append("        ,MAX(MV.AGMT_CTY_CD||LPAD(MV.AGMT_SEQ, 6, '0')) AS  AGMT_SEQ" ).append("\n"); 
		query.append("        ,MAX(MV.CRNT_YD_CD) AS CRNT_YD_CD" ).append("\n"); 
		query.append("        ,MAX(MV.LESSOR_NM) AS LESSOR_NM" ).append("\n"); 
		query.append("        ,MAX(MV.EQ_TPSZ_CD) AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ,MAX(MST_COMMON_PKG.MST_RU_LBL_GET_FNC(MV.EQ_NO)) AS RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("        ,MAX(MST_COMMON_PKG.MST_RU_TP_GET_FNC(MV.EQ_NO)) AS RSTR_USG_LBL_TP" ).append("\n"); 
		query.append("        ,MAX(MST_COMMON_PKG.MST_RU_VAL_GET_FNC(MV.EQ_NO)) AS RSTR_USG_LBL_VAL" ).append("\n"); 
		query.append("        ,MAX(MV.CTRT_NO) AS CTRT_NO" ).append("\n"); 
		query.append("    FROM MNR_TTL_LSS_RQST_HDR TH, MNR_TTL_LSS_RQST_DTL TD, CLT_PARAM CP, MNR_EQ_STS_V MV" ).append("\n"); 
		query.append("#if (${rstr_usg_lbl} != '')" ).append("\n"); 
		query.append(", MST_CONTAINER MC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    WHERE  TH.TTL_LSS_NO = TD.TTL_LSS_NO" ).append("\n"); 
		query.append("    AND CP.TTL_LSS_NO(+) = TD.TTL_LSS_NO" ).append("\n"); 
		query.append("    AND CP.TTL_LSS_DTL_SEQ(+) IN TD.TTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append("    AND TD.RQST_EQ_NO = MV.EQ_NO(+)" ).append("\n"); 
		query.append("#if (${eq_kind} != 'A')" ).append("\n"); 
		query.append("AND   TD.EQ_KND_CD  = @[eq_kind]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A')" ).append("\n"); 
		query.append("AND   MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(TH.RQST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("AND   (TH.RQST_OFC_CD = @[ofc_cd] OR TH.RESPB_OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_search_dt_tp} == 'R')" ).append("\n"); 
		query.append("    AND TH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999    " ).append("\n"); 
		query.append("#elseif (${in_search_dt_tp} == 'C')" ).append("\n"); 
		query.append("	AND TH.TTL_LSS_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("#else	" ).append("\n"); 
		query.append("	AND TD.TTL_LSS_CMPL_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("#end	 	" ).append("\n"); 
		query.append("#if (${in_status_tp} == 'S')" ).append("\n"); 
		query.append("	 AND TH.TTL_LSS_STS_CD IN ('HS', 'HJ')" ).append("\n"); 
		query.append("#elseif (${in_status_tp} == 'R')" ).append("\n"); 
		query.append("     AND TH.TTL_LSS_STS_CD IN ('HR')" ).append("\n"); 
		query.append("#elseif (${in_status_tp} == 'P')" ).append("\n"); 
		query.append("     AND TH.TTL_LSS_STS_CD IN ('HA','HC')" ).append("\n"); 
		query.append("#elseif (${in_status_tp} == 'C') " ).append("\n"); 
		query.append("     AND TH.TTL_LSS_STS_CD IN ('HE')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${eq_no} != '')" ).append("\n"); 
		query.append("	AND	TD.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_eqNos IN ${eqNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("				'$user_eqNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_eqNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${total_loss_no} != '')" ).append("\n"); 
		query.append("	AND	TH.TTL_LSS_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_totalLossNos IN ${totalLossNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $totalLossNos.size())" ).append("\n"); 
		query.append("				'$user_totalLossNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_totalLossNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if (${rsn_cd} != 'A')" ).append("\n"); 
		query.append("AND   TH.TTL_LSS_RSN_CD = @[rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ttl_lss_dtl_rsn_cd} != 'A')" ).append("\n"); 
		query.append("AND   TH.TTL_LSS_DTL_RSN_CD = @[ttl_lss_dtl_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ttl_lss_cmpl_cd} != 'A')" ).append("\n"); 
		query.append("AND   TD.TTL_LSS_CMPL_CD = @[ttl_lss_cmpl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND MV.LESSOR_CD = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rstr_usg_lbl} != '')" ).append("\n"); 
		query.append("AND TD.RQST_EQ_NO = MC.CNTR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				AND	" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("				MC.RSTR_USG_TP_LBL_NM1 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				MC.RSTR_USG_TP_LBL_NM2 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				MC.RSTR_USG_TP_LBL_NM3 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				MC.RSTR_USG_TP_LBL_NM4 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				MC.RSTR_USG_TP_LBL_NM5 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				MC.RSTR_USG_TP_LBL_NM6 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				MC.RSTR_USG_TP_LBL_NM7 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				MC.RSTR_USG_TP_LBL_NM8 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				MC.RSTR_USG_TP_LBL_NM9 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				MC.RSTR_USG_TP_LBL_NM10 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				MC.RSTR_USG_TP_LBL_NM11 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("    GROUP BY TH.TTL_LSS_NO, TD.RQST_EQ_NO" ).append("\n"); 

	}
}