/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchTotalLossPerformanceListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * ----------------------------------------------------------
	  * 2012.02.27 신혜정 [CHM-201216419] Payer 기준으로 조회할 수 있는 조건 추가 구현(payer code, payer type 조건 추가)
	  * 2012.03.05 신혜정 [선처리] Lessor 코드 조회 보완
	  * 2013.02.13 조경완 [CHM-201322896-01] ALPS MNR-Total Loss Logic 검토 및 수정 요청
	  * 2013.06.20 조경완 [CHM-201324955-01] ALPS MNR-TOTAL-Total Loss Performance 조회 시, complete 건 조회 에러 요청
	  * 2013.12.16 최덕우 [CHM-201328048] ALPS-MNR-Total Loss 모듈에 문제점 검토 및 logic 수정 요청
	  * 2014-01-08 Jonghee HAN [CHM-201328248] Performance조회시 Recovery 금액 반영 수정 요청
	  * 2014-02-17 Jonghee HAN WITH PARAM 조회 조건 추가 FPMC 향상
	  * 2015-06-15 박정민 [CHM-201536250] [CSR전환] Total Loss Performance 데이터 검증 요청
	  *                  Responsible OFC 미입력건 Req OFC로 대체 하던 내용 수정
	  *                  RHQ, OFC 모두 RES OFC, REQ OFC별로 구분하여 검색하도록 수정
	  * 2015-10-01 박정민 [CHM-201538166] 3자 구상 실적에 local currency 추가 요청 3rd Party및 Disposal항목에 Currency Code 및 USD변환 금액 추가
	  * ----------------------------------------------------------
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
		params.put("ttl_lss_dtl_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payer_code",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("buyer_code",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_days",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
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
		query.append("AS (SELECT MTRD.TTL_LSS_NO, MTRD.TTL_LSS_DTL_SEQ, MTRD.MNR_INV_TP_CD, MTLC.CLT_AMT, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MTRH.TTL_LSS_DT, 'YYYYMM'), MTLC.CURR_CD, 'USD', MTLC.CLT_AMT) CLT_USD_AMT, MTLC.CURR_CD CLT_CURR_CD" ).append("\n"); 
		query.append("      FROM MNR_TTL_LSS_RQST_HDR MTRH, MNR_TTL_LSS_RQST_DTL MTRD, MNR_TTL_LSS_CLT MTLC" ).append("\n"); 
		query.append("     WHERE MTRH.TTL_LSS_NO = MTRD.TTL_LSS_NO" ).append("\n"); 
		query.append("       AND MTRD.TTL_LSS_NO = MTLC.TTL_LSS_NO" ).append("\n"); 
		query.append("       AND MTRD.TTL_LSS_DTL_SEQ IN MTLC.TTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append("    #if (${rhq} != 'A' && ${rhq} != '')" ).append("\n"); 
		query.append("		#if (${in_office_tp} == 'A')" ).append("\n"); 
		query.append("			AND (MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MTRH.RQST_OFC_CD)  = @[rhq] OR MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MTRH.RESPB_OFC_CD)  = @[rhq])" ).append("\n"); 
		query.append("		#elseif (${in_office_tp} == 'S')" ).append("\n"); 
		query.append("			AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MTRH.RESPB_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("		#elseif (${in_office_tp} == 'Q')" ).append("\n"); 
		query.append("			AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MTRH.RQST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eq_kind} != 'A')" ).append("\n"); 
		query.append("       AND MTRD.EQ_KND_CD  = @[eq_kind]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${in_office_tp} == 'A')" ).append("\n"); 
		query.append("    	#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("       AND (MTRH.RQST_OFC_CD = @[ofc_cd] OR MTRH.RESPB_OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("	#elseif (${in_office_tp} == 'S')" ).append("\n"); 
		query.append("		#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("       AND MTRH.RESPB_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#elseif (${in_office_tp} == 'Q')" ).append("\n"); 
		query.append("		#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("       AND MTRH.RQST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${in_search_dt_tp} == 'R')" ).append("\n"); 
		query.append("       AND MTRH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999    " ).append("\n"); 
		query.append("    #elseif (${in_search_dt_tp} == 'C')" ).append("\n"); 
		query.append("       AND MTRH.TTL_LSS_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("    #else  " ).append("\n"); 
		query.append("       AND MTRD.TTL_LSS_CMPL_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${in_days} != '')" ).append("\n"); 
		query.append("      AND MTRH.TTL_LSS_DT < ( GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], SYSDATE, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) - @[in_days] )" ).append("\n"); 
		query.append("      AND MTRD.TTL_LSS_CMPL_DT IS NULL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${in_status_tp} != '')" ).append("\n"); 
		query.append("       AND MTRH.TTL_LSS_STS_CD IN (" ).append("\n"); 
		query.append("        #foreach ($user_inStatusTps IN ${inStatusTps})" ).append("\n"); 
		query.append("        #if($velocityCount < $inStatusTps.size())" ).append("\n"); 
		query.append("            '$user_inStatusTps'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_inStatusTps'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${statusPandC} == 'P')" ).append("\n"); 
		query.append("        AND MTRD.TTL_LSS_CMPL_DT IS NULL" ).append("\n"); 
		query.append("    #elseif(${statusPandC} == 'C')" ).append("\n"); 
		query.append("        AND MTRD.TTL_LSS_CMPL_DT IS NOT NULL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${eq_no} != '')" ).append("\n"); 
		query.append("       AND MTRD.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("        #foreach ($user_eqNos IN ${eqNos})" ).append("\n"); 
		query.append("          #if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("            '$user_eqNos'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_eqNos'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${total_loss_no} != '')" ).append("\n"); 
		query.append("       AND MTRH.TTL_LSS_NO IN (" ).append("\n"); 
		query.append("        #foreach ($user_totalLossNos IN ${totalLossNos})" ).append("\n"); 
		query.append("          #if($velocityCount < $totalLossNos.size())" ).append("\n"); 
		query.append("            '$user_totalLossNos'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_totalLossNos'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${rsn_cd_all_flg} != 'Y')" ).append("\n"); 
		query.append("    #if (${rsn_cd} != 'A' || ${rsn_cd} != '')" ).append("\n"); 
		query.append("       AND MTRH.TTL_LSS_RSN_CD IN(" ).append("\n"); 
		query.append("		#foreach ($user_rsnCds IN ${rsnCds})" ).append("\n"); 
		query.append("          #if($velocityCount < $rsnCds.size())" ).append("\n"); 
		query.append("            '$user_rsnCds'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_rsnCds'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end		" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${ttl_lss_dtl_rsn_cd} != 'A')" ).append("\n"); 
		query.append("       AND MTRH.TTL_LSS_DTL_RSN_CD = @[ttl_lss_dtl_rsn_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	#if(${close_tp_all_flg} != 'Y')" ).append("\n"); 
		query.append("    #if (${ttl_lss_cmpl_cd} != 'A' || ${ttl_lss_cmpl_cd} != '')" ).append("\n"); 
		query.append("       AND (MTRD.TTL_LSS_CMPL_CD IN(" ).append("\n"); 
		query.append("		#foreach ($user_ttlLssCmplCds IN ${ttlLssCmplCds})" ).append("\n"); 
		query.append("          #if($velocityCount < $ttlLssCmplCds.size())" ).append("\n"); 
		query.append("            '$user_ttlLssCmplCds'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_ttlLssCmplCds'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      ) OR MTRD.TTL_LSS_CMPL_CD IS NULL)" ).append("\n"); 
		query.append("    #end		" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${payer_code} != '')" ).append("\n"); 
		query.append("       AND MTRD.MNR_PRNR_SEQ = @[payer_code]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${usa_edi_cd} != '')" ).append("\n"); 
		query.append("       AND MTRD.USA_EDI_CD IN (" ).append("\n"); 
		query.append("        #foreach ($user_usaEdiCds IN ${usaEdiCds})" ).append("\n"); 
		query.append("          #if($velocityCount < $usaEdiCds.size())" ).append("\n"); 
		query.append("            '$user_usaEdiCds'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_usaEdiCds'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${buyer_code} != '')" ).append("\n"); 
		query.append("       AND MTRD.TTL_LSS_BUYR_SEQ = @[buyer_code]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    UNION ALL   " ).append("\n"); 
		query.append("    SELECT MTRD.TTL_LSS_NO, MTRD.TTL_LSS_DTL_SEQ, MTRD.MNR_INV_TP_CD, BOD.CLT_FRT_AMT + BOD.CLT_TAX_AMT CLT_AMT, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MTRH.TTL_LSS_DT, 'YYYYMM'), BOD.BL_CURR_CD, 'USD', BOD.CLT_FRT_AMT + BOD.CLT_TAX_AMT) CLT_USD_AMT, BOD.BL_CURR_CD CLT_CURR_CD" ).append("\n"); 
		query.append("      FROM MNR_TTL_LSS_RQST_HDR MTRH, MNR_TTL_LSS_RQST_DTL MTRD, BKG_OTS_DTL BOD" ).append("\n"); 
		query.append("     WHERE MTRH.TTL_LSS_NO = MTRD.TTL_LSS_NO" ).append("\n"); 
		query.append("       AND MTRD.INV_NO = BOD.CLT_BL_NO" ).append("\n"); 
		query.append("       AND MTRD.MNR_INV_TP_CD = 'DS'" ).append("\n"); 
		query.append("    #if (${rhq} != 'A' && ${rhq} != '')" ).append("\n"); 
		query.append("		#if (${in_office_tp} == 'A')" ).append("\n"); 
		query.append("			AND (MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MTRH.RQST_OFC_CD)  = @[rhq] OR MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MTRH.RESPB_OFC_CD)  = @[rhq])" ).append("\n"); 
		query.append("		#elseif (${in_office_tp} == 'S')" ).append("\n"); 
		query.append("			AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MTRH.RESPB_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("		#elseif (${in_office_tp} == 'Q')" ).append("\n"); 
		query.append("			AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MTRH.RQST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eq_kind} != 'A')" ).append("\n"); 
		query.append("       AND MTRD.EQ_KND_CD  = @[eq_kind]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${in_office_tp} == 'A')" ).append("\n"); 
		query.append("    	#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("       AND (MTRH.RQST_OFC_CD = @[ofc_cd] OR MTRH.RESPB_OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("	#elseif (${in_office_tp} == 'S')" ).append("\n"); 
		query.append("		#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("       AND MTRH.RESPB_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#elseif (${in_office_tp} == 'Q')" ).append("\n"); 
		query.append("		#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("       AND MTRH.RQST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${in_search_dt_tp} == 'R')" ).append("\n"); 
		query.append("       AND MTRH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999    " ).append("\n"); 
		query.append("    #elseif (${in_search_dt_tp} == 'C')" ).append("\n"); 
		query.append("       AND MTRH.TTL_LSS_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("    #else  " ).append("\n"); 
		query.append("       AND MTRD.TTL_LSS_CMPL_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${in_days} != '')" ).append("\n"); 
		query.append("      AND MTRH.TTL_LSS_DT < ( GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], SYSDATE, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) - @[in_days] )" ).append("\n"); 
		query.append("      AND MTRD.TTL_LSS_CMPL_DT IS NULL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${in_status_tp} != '')" ).append("\n"); 
		query.append("       AND MTRH.TTL_LSS_STS_CD IN (" ).append("\n"); 
		query.append("        #foreach ($user_inStatusTps IN ${inStatusTps})" ).append("\n"); 
		query.append("        #if($velocityCount < $inStatusTps.size())" ).append("\n"); 
		query.append("            '$user_inStatusTps'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_inStatusTps'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if(${statusPandC} == 'P')" ).append("\n"); 
		query.append("        AND MTRD.TTL_LSS_CMPL_DT IS NULL" ).append("\n"); 
		query.append("    #elseif(${statusPandC} == 'C')" ).append("\n"); 
		query.append("        AND MTRD.TTL_LSS_CMPL_DT IS NOT NULL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${eq_no} != '')" ).append("\n"); 
		query.append("       AND MTRD.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("        #foreach ($user_eqNos IN ${eqNos})" ).append("\n"); 
		query.append("          #if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("            '$user_eqNos'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_eqNos'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${total_loss_no} != '')" ).append("\n"); 
		query.append("       AND MTRH.TTL_LSS_NO IN (" ).append("\n"); 
		query.append("        #foreach ($user_totalLossNos IN ${totalLossNos})" ).append("\n"); 
		query.append("          #if($velocityCount < $totalLossNos.size())" ).append("\n"); 
		query.append("            '$user_totalLossNos'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_totalLossNos'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${rsn_cd_all_flg} != 'Y')" ).append("\n"); 
		query.append("	#if (${rsn_cd} != 'A' || ${rsn_cd} != '')" ).append("\n"); 
		query.append("       AND MTRH.TTL_LSS_RSN_CD IN(" ).append("\n"); 
		query.append("		#foreach ($user_rsnCds IN ${rsnCds})" ).append("\n"); 
		query.append("          #if($velocityCount < $rsnCds.size())" ).append("\n"); 
		query.append("            '$user_rsnCds'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_rsnCds'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${ttl_lss_dtl_rsn_cd} != 'A')" ).append("\n"); 
		query.append("       AND MTRH.TTL_LSS_DTL_RSN_CD = @[ttl_lss_dtl_rsn_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	#if(${close_tp_all_flg} != 'Y')" ).append("\n"); 
		query.append("    #if (${ttl_lss_cmpl_cd} != 'A' || ${ttl_lss_cmpl_cd} != '')" ).append("\n"); 
		query.append("       AND (MTRD.TTL_LSS_CMPL_CD IN(" ).append("\n"); 
		query.append("		#foreach ($user_ttlLssCmplCds IN ${ttlLssCmplCds})" ).append("\n"); 
		query.append("          #if($velocityCount < $ttlLssCmplCds.size())" ).append("\n"); 
		query.append("            '$user_ttlLssCmplCds'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_ttlLssCmplCds'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      ) OR MTRD.TTL_LSS_CMPL_CD IS NULL)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${payer_code} != '')" ).append("\n"); 
		query.append("       AND MTRD.MNR_PRNR_SEQ = @[payer_code]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${usa_edi_cd} != '')" ).append("\n"); 
		query.append("       AND MTRD.USA_EDI_CD IN (" ).append("\n"); 
		query.append("        #foreach ($user_usaEdiCds IN ${usaEdiCds})" ).append("\n"); 
		query.append("          #if($velocityCount < $usaEdiCds.size())" ).append("\n"); 
		query.append("            '$user_usaEdiCds'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_usaEdiCds'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${buyer_code} != '')" ).append("\n"); 
		query.append("       AND MTRD.TTL_LSS_BUYR_SEQ = @[buyer_code]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   DECODE(TTS.TTL_LSS_NO,'','',DENSE_RANK() OVER (PARTITION BY TSV.MNR_INV_TP_CD ORDER BY TTS.TTL_LSS_NO ASC)) TMPSEQ" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','Total',TTS.TTL_LSS_NO) TTL_LSS_NO" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',TTS.RQST_OFC_CD) RQST_OFC_CD" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',TTS.APRO_OFC_CD) APRO_OFC_CD" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',TTS.RESPB_OFC_CD) RESPB_OFC_CD" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',TTS.TTL_LSS_DT)  TTL_LSS_DT" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',TTS.RQST_DT) RQST_DT" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',TTS.TTL_LSS_STS_NM) TTL_LSS_STS_NM" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',NVL(TTS.TTL_LSS_CFM_DT,'Proccessing')) TTL_LSS_CFM_DT" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',TTS.TTL_LSS_RSN_NM) TTL_LSS_RSN_NM" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',TTS.TTL_LSS_DTL_RSN_NM) TTL_LSS_DTL_RSN_NM" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',TSV.RQST_EQ_NO) RQST_EQ_NO" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',(SELECT MNR_CD_DESC FROM  MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00072' AND MNR_CD_ID = TSV.TTL_LSS_CMPL_CD)) TTL_LSS_DTL_CMPL_NM" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',TO_CHAR(TSV.TTL_LSS_CMPL_DT, 'yyyy-mm-dd')) TTL_LSS_DTL_CMPL_DT" ).append("\n"); 
		query.append("  ,TTS.DV_EQ_QTY" ).append("\n"); 
		query.append("  ,TTS.DV_DV_VAL" ).append("\n"); 
		query.append("  ,TTS.DV_EXP" ).append("\n"); 
		query.append("  ,TTS.DV_BAL" ).append("\n"); 
		query.append("  ,TTS.TP_EQ_QTY" ).append("\n"); 
		query.append("  ,TTS.TP_DV_VAL" ).append("\n"); 
		query.append("  ,TTS.TP_CURR_CD" ).append("\n"); 
		query.append("  ,TTS.TP_EXP" ).append("\n"); 
		query.append("  ,TTS.TP_USD_EXP" ).append("\n"); 
		query.append("  ,TTS.TP_BAL" ).append("\n"); 
		query.append("  ,TTS.DS_EQ_QTY" ).append("\n"); 
		query.append("  ,TTS.DS_DV_VAL" ).append("\n"); 
		query.append("  ,TTS.DS_CURR_CD" ).append("\n"); 
		query.append("  ,TTS.DS_EXP" ).append("\n"); 
		query.append("  ,TTS.DS_USD_EXP" ).append("\n"); 
		query.append("  ,TTS.DS_BAL" ).append("\n"); 
		query.append("  ,TTS.SC_EQ_QTY" ).append("\n"); 
		query.append("  ,TTS.SC_DV_VAL" ).append("\n"); 
		query.append("  ,TTS.SC_EXP" ).append("\n"); 
		query.append("  ,TTS.SC_BAL" ).append("\n"); 
		query.append("  ,TTS.IR_EQ_QTY" ).append("\n"); 
		query.append("  ,TTS.IR_DV_VAL" ).append("\n"); 
		query.append("  ,TTS.IR_EXP" ).append("\n"); 
		query.append("  ,TTS.IR_BAL" ).append("\n"); 
		query.append("  ,TTS.CLT_AMT" ).append("\n"); 
		query.append("  ,DECODE(TTS.TTL_LSS_NO,'','',TTS.TTL_LSS_N3PTY_TP_CD) TTL_LSS_N3PTY_TP_CD" ).append("\n"); 
		query.append("  ,NVL(TTS.USA_EDI_CD, ' ') USA_EDI_CD" ).append("\n"); 
		query.append("  ,NVL(DECODE(TTS.TTL_LSS_N3PTY_TP_CD, 'S', (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                                            FROM MDM_VENDOR" ).append("\n"); 
		query.append("                                          WHERE VNDR_SEQ = TTS.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("                                            AND NVL(DELT_FLG, 'N') <> 'Y') " ).append("\n"); 
		query.append("                                  , 'C', (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                            FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                                          WHERE CUST_CNT_CD = TTS.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("                                            AND CUST_SEQ = TTS.MNR_PRNR_SEQ)" ).append("\n"); 
		query.append("                                  ,  DECODE(TTS.MNR_INV_TP_CD,'DV',(SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                                                                      FROM MDM_VENDOR" ).append("\n"); 
		query.append("                                                                    WHERE VNDR_SEQ = TTS.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("                                                                      AND NVL(DELT_FLG, 'N') <> 'Y')" ).append("\n"); 
		query.append("                                  ,'')" ).append("\n"); 
		query.append("  ), ' ') PAYER_NAME  " ).append("\n"); 
		query.append("  ,(SELECT NVL((SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("  	FROM MDM_VENDOR" ).append("\n"); 
		query.append("    WHERE VNDR_SEQ = TTS.TTL_LSS_BUYR_SEQ" ).append("\n"); 
		query.append("    	AND NVL(DELT_FLG, 'N') <> 'Y'), ' ')" ).append("\n"); 
		query.append("   FROM DUAL      " ).append("\n"); 
		query.append("  ) BUYER_NAME  " ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_DTL TSV," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         TH.TTL_LSS_NO" ).append("\n"); 
		query.append("        ,MAX(TH.RQST_OFC_CD) RQST_OFC_CD" ).append("\n"); 
		query.append("        ,MAX(TH.APRO_OFC_CD) APRO_OFC_CD" ).append("\n"); 
		query.append("        ,MAX(TH.RESPB_OFC_CD) RESPB_OFC_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(MAX(TH.TTL_LSS_DT), 'yyyy-mm-dd') TTL_LSS_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(TH.RQST_DT),@[user_ofc_cd]), 'yyyy-mm-dd') RQST_DT" ).append("\n"); 
		query.append("        ,MAX((SELECT MNR_CD_DP_DESC" ).append("\n"); 
		query.append("              FROM MNR_GEN_CD" ).append("\n"); 
		query.append("              WHERE PRNT_CD_ID='CD00039'" ).append("\n"); 
		query.append("                AND MNR_CD_ID=TH.TTL_LSS_STS_CD" ).append("\n"); 
		query.append("            )) AS TTL_LSS_STS_NM" ).append("\n"); 
		query.append("        ,TO_CHAR(DECODE(MAX(TH.TTL_LSS_STS_CD),'HE',GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(TH.TTL_LSS_CFM_DT),@[user_ofc_cd]),null), 'yyyy-mm-dd') TTL_LSS_CFM_DT" ).append("\n"); 
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
		query.append("        ,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DV', 1)),0) DV_EQ_QTY" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DV', NVL(TD.DPC_VAL_AMT,0))),0) DV_DV_VAL" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DV', NVL(TTL_LSS_BIL_AMT,0))),0) DV_EXP" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DV', NVL(TD.DPC_VAL_AMT,0))),0) - NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DV', NVL(TTL_LSS_BIL_AMT,0))),0) DV_BAL" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(CP.MNR_INV_TP_CD, 'TP', 1, 0)), 0) TP_EQ_QTY" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'TP', NVL(TD.DPC_VAL_AMT,0))), 0) TP_DV_VAL" ).append("\n"); 
		query.append("        ,NVL(MAX(DECODE(CP.MNR_INV_TP_CD, 'TP', NVL(CP.CLT_CURR_CD,''))), ' ') TP_CURR_CD" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(CP.MNR_INV_TP_CD, 'TP', NVL(CP.CLT_AMT,0))), 0) TP_EXP" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(CP.MNR_INV_TP_CD, 'TP', NVL(CP.CLT_USD_AMT,0))), 0) TP_USD_EXP" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'TP', NVL(TD.DPC_VAL_AMT,0))), 0) - NVL(SUM(DECODE(CP.MNR_INV_TP_CD, 'TP', NVL(CP.CLT_AMT,0))), 0) TP_BAL" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(CP.MNR_INV_TP_CD, 'DS', 1, 0)), 0) DS_EQ_QTY" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DS', NVL(TD.DPC_VAL_AMT,0))), 0) DS_DV_VAL" ).append("\n"); 
		query.append("        ,NVL(MAX(DECODE(CP.MNR_INV_TP_CD, 'DS', NVL(CP.CLT_CURR_CD,''))), ' ') DS_CURR_CD" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(CP.MNR_INV_TP_CD, 'DS', NVL(CP.CLT_AMT,0))), 0) DS_EXP" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(CP.MNR_INV_TP_CD, 'DS', NVL(CP.CLT_USD_AMT,0))), 0) DS_USD_EXP" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DS', NVL(TD.DPC_VAL_AMT,0))), 0) - NVL(SUM(DECODE(CP.MNR_INV_TP_CD, 'DS', NVL(CP.CLT_AMT,0))), 0) DS_BAL" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'SC', 1)),0) SC_EQ_QTY" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'SC', NVL(TD.DPC_VAL_AMT,0))),0) SC_DV_VAL" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'SC', NVL(TTL_LSS_INCM_AMT,0))),0) - NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'SC', NVL(TTL_LSS_EXPN_AMT,0))),0) SC_EXP" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'SC', NVL(TD.DPC_VAL_AMT,0))),0) - NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DV', NVL(TTL_LSS_BIL_AMT,0))),0) SC_BAL" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'IR', 1)),0) IR_EQ_QTY" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'IR', NVL(TD.DPC_VAL_AMT,0))),0) IR_DV_VAL" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'IR', NVL(TTL_LSS_EXPN_AMT,0))),0) IR_EXP" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'IR', NVL(TD.DPC_VAL_AMT,0))),0) - NVL(SUM(DECODE(TD.MNR_INV_TP_CD, 'DV', NVL(TTL_LSS_BIL_AMT,0))),0) IR_BAL " ).append("\n"); 
		query.append("        ,MAX(" ).append("\n"); 
		query.append("             (SELECT" ).append("\n"); 
		query.append("                 SUM(NVL(BOD.CLT_FRT_AMT,0) + NVL(BOD.CLT_TAX_AMT,0)) " ).append("\n"); 
		query.append("                  + MAX((SELECT SUM(NVL(MTLC.CLT_AMT,0))" ).append("\n"); 
		query.append("                         FROM MNR_TTL_LSS_CLT MTLC" ).append("\n"); 
		query.append("                         WHERE TD.TTL_LSS_NO=MTLC.TTL_LSS_NO))" ).append("\n"); 
		query.append("              FROM MNR_DISP_DTL MDD, BKG_OTS_DTL BOD " ).append("\n"); 
		query.append("              WHERE TD.RQST_EQ_NO      = MDD.EQ_NO(+)" ).append("\n"); 
		query.append("                AND MDD.INV_NO      = BOD.CLT_BL_NO(+)" ).append("\n"); 
		query.append("                AND BOD.OFC_CD(+) > ' '" ).append("\n"); 
		query.append("                AND TD.MNR_INV_TP_CD = 'DS'" ).append("\n"); 
		query.append("          ))  CLT_AMT  " ).append("\n"); 
		query.append("        , MAX(TD.TTL_LSS_N3PTY_TP_CD) AS TTL_LSS_N3PTY_TP_CD   " ).append("\n"); 
		query.append("		, MAX(TD.USA_EDI_CD) AS USA_EDI_CD" ).append("\n"); 
		query.append("        , MAX(TD.MNR_PRNR_SEQ) AS MNR_PRNR_SEQ" ).append("\n"); 
		query.append("        , MAX(TD.MNR_INV_TP_CD) MNR_INV_TP_CD" ).append("\n"); 
		query.append("        , MAX(TD.MNR_PRNR_CNT_CD) MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("		, MAX(TD.TTL_LSS_BUYR_SEQ) TTL_LSS_BUYR_SEQ" ).append("\n"); 
		query.append("    FROM MNR_TTL_LSS_RQST_HDR TH, MNR_TTL_LSS_RQST_DTL TD,MNR_EQ_STS_V MV, CLT_PARAM CP" ).append("\n"); 
		query.append("    WHERE  TH.TTL_LSS_NO = TD.TTL_LSS_NO" ).append("\n"); 
		query.append("    AND TD.RQST_EQ_NO = MV.EQ_NO" ).append("\n"); 
		query.append("    AND CP.TTL_LSS_NO(+) = TD.TTL_LSS_NO" ).append("\n"); 
		query.append("    AND CP.TTL_LSS_DTL_SEQ(+) IN TD.TTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append("    #if (${eq_kind} != 'A')" ).append("\n"); 
		query.append("    AND   TD.EQ_KND_CD  = @[eq_kind]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rhq} != 'A' && ${rhq} != '')" ).append("\n"); 
		query.append("		#if (${in_office_tp} == 'A')" ).append("\n"); 
		query.append("			AND (MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(TH.RQST_OFC_CD)  = @[rhq] OR MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(TH.RESPB_OFC_CD)  = @[rhq])" ).append("\n"); 
		query.append("		#elseif (${in_office_tp} == 'S')" ).append("\n"); 
		query.append("			AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(TH.RESPB_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("		#elseif (${in_office_tp} == 'Q')" ).append("\n"); 
		query.append("			AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(TH.RQST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${in_office_tp} == 'A')" ).append("\n"); 
		query.append("    	#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("    	AND   (TH.RQST_OFC_CD = @[ofc_cd] OR TH.RESPB_OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("	#elseif (${in_office_tp} == 'S')" ).append("\n"); 
		query.append("		#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("		AND TH.RESPB_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#elseif (${in_office_tp} == 'Q')" ).append("\n"); 
		query.append("		#if (${ofc_cd} != 'A' && ${ofc_cd} != '')" ).append("\n"); 
		query.append("		AND TH.RQST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${in_search_dt_tp} == 'R')" ).append("\n"); 
		query.append("        AND TH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999    " ).append("\n"); 
		query.append("    #elseif (${in_search_dt_tp} == 'C')" ).append("\n"); 
		query.append("      AND TH.TTL_LSS_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("    #else  " ).append("\n"); 
		query.append("      AND TD.TTL_LSS_CMPL_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[fm_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${in_days} != '')" ).append("\n"); 
		query.append("      AND TH.TTL_LSS_DT < ( GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], SYSDATE, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) - @[in_days] )" ).append("\n"); 
		query.append("      AND TD.TTL_LSS_CMPL_DT IS NULL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${in_status_tp} != '')" ).append("\n"); 
		query.append("       AND TH.TTL_LSS_STS_CD IN (" ).append("\n"); 
		query.append("        #foreach ($user_inStatusTps IN ${inStatusTps})" ).append("\n"); 
		query.append("        #if($velocityCount < $inStatusTps.size())" ).append("\n"); 
		query.append("            '$user_inStatusTps'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_inStatusTps'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if(${statusPandC} == 'P')" ).append("\n"); 
		query.append("        AND TD.TTL_LSS_CMPL_DT IS NULL" ).append("\n"); 
		query.append("    #elseif(${statusPandC} == 'C')" ).append("\n"); 
		query.append("        AND TD.TTL_LSS_CMPL_DT IS NOT NULL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${eq_no} != '')" ).append("\n"); 
		query.append("      AND	TD.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("        #foreach ($user_eqNos IN ${eqNos})" ).append("\n"); 
		query.append("          #if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("            '$user_eqNos'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_eqNos'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${total_loss_no} != '')" ).append("\n"); 
		query.append("      AND	TH.TTL_LSS_NO IN (" ).append("\n"); 
		query.append("        #foreach ($user_totalLossNos IN ${totalLossNos})" ).append("\n"); 
		query.append("          #if($velocityCount < $totalLossNos.size())" ).append("\n"); 
		query.append("            '$user_totalLossNos'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_totalLossNos'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${rsn_cd_all_flg} != 'Y')" ).append("\n"); 
		query.append("	#if (${rsn_cd} != 'A' || ${rsn_cd} != '')" ).append("\n"); 
		query.append("       AND TH.TTL_LSS_RSN_CD IN(" ).append("\n"); 
		query.append("		#foreach ($user_rsnCds IN ${rsnCds})" ).append("\n"); 
		query.append("          #if($velocityCount < $rsnCds.size())" ).append("\n"); 
		query.append("            '$user_rsnCds'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_rsnCds'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${ttl_lss_dtl_rsn_cd} != 'A')" ).append("\n"); 
		query.append("    AND   TH.TTL_LSS_DTL_RSN_CD = @[ttl_lss_dtl_rsn_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${close_tp_all_flg} != 'Y')" ).append("\n"); 
		query.append("    #if (${ttl_lss_cmpl_cd} != 'A' || ${ttl_lss_cmpl_cd} != '')" ).append("\n"); 
		query.append("       AND (TD.TTL_LSS_CMPL_CD IN(" ).append("\n"); 
		query.append("		#foreach ($user_ttlLssCmplCds IN ${ttlLssCmplCds})" ).append("\n"); 
		query.append("          #if($velocityCount < $ttlLssCmplCds.size())" ).append("\n"); 
		query.append("            '$user_ttlLssCmplCds'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_ttlLssCmplCds'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      ) OR TD.TTL_LSS_CMPL_CD IS NULL)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${vndr_seq} != '')" ).append("\n"); 
		query.append("    AND   MV.LESSOR_CD = @[vndr_seq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${payer_code} != '')" ).append("\n"); 
		query.append("	AND TD.MNR_PRNR_SEQ = @[payer_code]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${usa_edi_cd} != '')" ).append("\n"); 
		query.append("      AND	TD.USA_EDI_CD IN (" ).append("\n"); 
		query.append("        #foreach ($user_usaEdiCds IN ${usaEdiCds})" ).append("\n"); 
		query.append("          #if($velocityCount < $usaEdiCds.size())" ).append("\n"); 
		query.append("            '$user_usaEdiCds'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            '$user_usaEdiCds'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end			  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${buyer_code} != '')" ).append("\n"); 
		query.append("	AND TD.TTL_LSS_BUYR_SEQ = @[buyer_code]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(TH.TTL_LSS_NO)" ).append("\n"); 
		query.append(") TTS" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append(", MNR_EQ_STS_V MV" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE TTS.TTL_LSS_NO = TSV.TTL_LSS_NO(+)" ).append("\n"); 
		query.append("AND TSV.MNR_INV_TP_CD(+) = 'DV'" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND MV.LESSOR_CD = @[vndr_seq]" ).append("\n"); 
		query.append("AND TSV.RQST_EQ_NO = MV.EQ_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${statusPandC} == 'P')" ).append("\n"); 
		query.append("AND TSV.TTL_LSS_CMPL_DT(+) IS NULL" ).append("\n"); 
		query.append("#elseif(${statusPandC} == 'C')" ).append("\n"); 
		query.append("AND TSV.TTL_LSS_CMPL_DT(+) IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${close_tp_all_flg} != 'Y')" ).append("\n"); 
		query.append("#if (${ttl_lss_cmpl_cd} != 'A' || ${ttl_lss_cmpl_cd} != '')" ).append("\n"); 
		query.append("   AND ( TSV.TTL_LSS_CMPL_CD IN(" ).append("\n"); 
		query.append("    #foreach ($user_ttlLssCmplCds IN ${ttlLssCmplCds})" ).append("\n"); 
		query.append("      #if($velocityCount < $ttlLssCmplCds.size())" ).append("\n"); 
		query.append("        '$user_ttlLssCmplCds'," ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        '$user_ttlLssCmplCds'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("    #end			  " ).append("\n"); 
		query.append("   ) OR TSV.TTL_LSS_CMPL_CD IS NULL" ).append("\n"); 
		query.append("   OR TTS.TTL_LSS_NO IS NULL  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}