/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchPerformanceInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.08.10 박창준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK CHANG JUNE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchPerformanceInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 비용계획을 요청중인 조직의 현재까지의 실적 정보를 조회한다
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchPerformanceInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchPerformanceInquiryRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'FM' FM_TO," ).append("\n"); 
		query.append("A.OFC_CD, A.GEN_EXPN_CD," ).append("\n"); 
		query.append("B.LOCL_CURR_CD," ).append("\n"); 
		query.append("B.RQST_UT_VAL," ).append("\n"); 
		query.append("YEAR_ASS_EXP/B.RQST_UT_VAL YEAR_ASS_EXP," ).append("\n"); 
		query.append("YTD_ASS_EXP/B.RQST_UT_VAL YTD_ASS_EXP," ).append("\n"); 
		query.append("YTD_PERF/B.RQST_UT_VAL YTD_PERF," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("NVL( MAX (CASE" ).append("\n"); 
		query.append("WHEN A.GEN_EXPN_TRNS_DIV_CD = 'F'" ).append("\n"); 
		query.append("AND     A.GEN_EXPN_APRO_STEP_CD = B.CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("THEN   A.JAN_AMT" ).append("\n"); 
		query.append("+ A.FEB_AMT" ).append("\n"); 
		query.append("+ A.MAR_AMT" ).append("\n"); 
		query.append("+ A.APR_AMT" ).append("\n"); 
		query.append("+ A.MAY_AMT" ).append("\n"); 
		query.append("+ A.JUN_AMT" ).append("\n"); 
		query.append("+ A.JUL_AMT" ).append("\n"); 
		query.append("+ A.AUG_AMT" ).append("\n"); 
		query.append("+ A.SEP_AMT" ).append("\n"); 
		query.append("+ A.OCT_AMT" ).append("\n"); 
		query.append("+ A.NOV_AMT" ).append("\n"); 
		query.append("+ A.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("),0) AD_AMT" ).append("\n"); 
		query.append("FROM GEM_APRO_STEP A, GEM_ITEM B, GEM_REQUEST C" ).append("\n"); 
		query.append("WHERE    B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_RQST_NO = A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND      B.OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_CD = A.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_ITM_NO = A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_TRNS_DIV_CD = A.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_RQST_SEQ = A.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_APRO_AUTH_OFC_CD = A.GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append("AND      C.GEN_EXPN_RQST_TP_CD = @[gen_expn_rqst_tp_cd]" ).append("\n"); 
		query.append("AND      C.PLN_YRMON LIKE SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'%'" ).append("\n"); 
		query.append("AND A.OFC_CD = @[fm_ofc_cd]" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = @[fm_gen_expn_cd]) AD_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT   OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",SUM (YEAR_ASS_EXP) YEAR_ASS_EXP" ).append("\n"); 
		query.append(",SUM (YTD_ASS_EXP) YTD_ASS_EXP" ).append("\n"); 
		query.append(",SUM (YTD_PERF) YTD_PERF" ).append("\n"); 
		query.append("FROM     (SELECT OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",   A.GEN_EXPN_INIT_AMT" ).append("\n"); 
		query.append("+ A.GEN_EXPN_ADD_AMT" ).append("\n"); 
		query.append("+ A.GEN_EXPN_TRNS_AMT YEAR_ASS_EXP" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN RSLT_YRMON BETWEEN SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'01' AND TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("THEN (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END YTD_ASS_EXP" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN RSLT_YRMON BETWEEN SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'01' AND TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("THEN SLP_PERF_AMT" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END YTD_PERF" ).append("\n"); 
		query.append("FROM   GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("WHERE  A.RSLT_YRMON LIKE SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'%'" ).append("\n"); 
		query.append("AND A.OFC_CD = @[fm_ofc_cd]" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = @[fm_gen_expn_cd])" ).append("\n"); 
		query.append("GROUP BY OFC_CD, GEN_EXPN_CD) A," ).append("\n"); 
		query.append("GEM_OFFICE B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'FM' FM_TO," ).append("\n"); 
		query.append("OFC_CD, GEN_EXPN_CD," ).append("\n"); 
		query.append("'USD' LOCL_CURR_CD," ).append("\n"); 
		query.append("1 RQST_UT_VAL," ).append("\n"); 
		query.append("(SELECT AAA.YEAR_ASS_EXP/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'00' AND GEN_EXPN_XCH_RT_DIV_CD = 'I' AND CURR_CD = AAA.LOCL_CURR_CD) YEAR_ASS_EXP," ).append("\n"); 
		query.append("(SELECT AAA.YTD_ASS_EXP/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'00' AND GEN_EXPN_XCH_RT_DIV_CD = 'I' AND CURR_CD = AAA.LOCL_CURR_CD) YTD_ASS_EXP," ).append("\n"); 
		query.append("AAA.YTD_PERF YTD_PERF," ).append("\n"); 
		query.append("(SELECT AAA.AD_AMT/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'00' AND GEN_EXPN_XCH_RT_DIV_CD = 'I' AND CURR_CD = AAA.LOCL_CURR_CD)*AAA.RQST_UT_VAL AD_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT A.OFC_CD, A.GEN_EXPN_CD," ).append("\n"); 
		query.append("B.LOCL_CURR_CD," ).append("\n"); 
		query.append("B.RQST_UT_VAL," ).append("\n"); 
		query.append("YEAR_ASS_EXP," ).append("\n"); 
		query.append("YTD_ASS_EXP," ).append("\n"); 
		query.append("YTD_PERF," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("NVL( MAX (CASE" ).append("\n"); 
		query.append("WHEN A.GEN_EXPN_TRNS_DIV_CD = 'F'" ).append("\n"); 
		query.append("AND     A.GEN_EXPN_APRO_STEP_CD = B.CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("THEN   A.JAN_AMT" ).append("\n"); 
		query.append("+ A.FEB_AMT" ).append("\n"); 
		query.append("+ A.MAR_AMT" ).append("\n"); 
		query.append("+ A.APR_AMT" ).append("\n"); 
		query.append("+ A.MAY_AMT" ).append("\n"); 
		query.append("+ A.JUN_AMT" ).append("\n"); 
		query.append("+ A.JUL_AMT" ).append("\n"); 
		query.append("+ A.AUG_AMT" ).append("\n"); 
		query.append("+ A.SEP_AMT" ).append("\n"); 
		query.append("+ A.OCT_AMT" ).append("\n"); 
		query.append("+ A.NOV_AMT" ).append("\n"); 
		query.append("+ A.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("),0) AD_AMT" ).append("\n"); 
		query.append("FROM GEM_APRO_STEP A, GEM_ITEM B, GEM_REQUEST C" ).append("\n"); 
		query.append("WHERE    B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_RQST_NO = A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND      B.OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_CD = A.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_ITM_NO = A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_TRNS_DIV_CD = A.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_RQST_SEQ = A.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_APRO_AUTH_OFC_CD = A.GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append("AND      C.GEN_EXPN_RQST_TP_CD = @[gen_expn_rqst_tp_cd]" ).append("\n"); 
		query.append("AND      C.PLN_YRMON LIKE SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'%'" ).append("\n"); 
		query.append("AND A.OFC_CD = @[fm_ofc_cd]" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = @[fm_gen_expn_cd]) AD_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT   OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",SUM (YEAR_ASS_EXP) YEAR_ASS_EXP" ).append("\n"); 
		query.append(",SUM (YTD_ASS_EXP) YTD_ASS_EXP" ).append("\n"); 
		query.append(",SUM (YTD_PERF) YTD_PERF" ).append("\n"); 
		query.append("FROM     (SELECT A.OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",   A.GEN_EXPN_INIT_AMT" ).append("\n"); 
		query.append("+ A.GEN_EXPN_ADD_AMT" ).append("\n"); 
		query.append("+ A.GEN_EXPN_TRNS_AMT YEAR_ASS_EXP" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN RSLT_YRMON BETWEEN SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'01' AND TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("THEN (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END YTD_ASS_EXP" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN RSLT_YRMON BETWEEN SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'01' AND TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("THEN (SELECT A.SLP_PERF_AMT/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON AND GEN_EXPN_XCH_RT_DIV_CD = 'M' AND CURR_CD = B.LOCL_CURR_CD)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END YTD_PERF" ).append("\n"); 
		query.append("FROM   GEM_RSLT_SMRY A, GEM_OFFICE B" ).append("\n"); 
		query.append("WHERE  A.RSLT_YRMON LIKE SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'%'" ).append("\n"); 
		query.append("AND A.OFC_CD = @[fm_ofc_cd]" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = @[fm_gen_expn_cd]" ).append("\n"); 
		query.append("AND A.OFC_CD = B.OFC_CD(+))" ).append("\n"); 
		query.append("GROUP BY OFC_CD, GEN_EXPN_CD) A," ).append("\n"); 
		query.append("GEM_OFFICE B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = B.OFC_CD(+)) AAA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${to_ofc_cd} != '' && ${to_gen_expn_cd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'TO' FM_TO," ).append("\n"); 
		query.append("A.OFC_CD, A.GEN_EXPN_CD," ).append("\n"); 
		query.append("B.LOCL_CURR_CD," ).append("\n"); 
		query.append("B.RQST_UT_VAL," ).append("\n"); 
		query.append("YEAR_ASS_EXP/B.RQST_UT_VAL YEAR_ASS_EXP," ).append("\n"); 
		query.append("YTD_ASS_EXP/B.RQST_UT_VAL YTD_ASS_EXP," ).append("\n"); 
		query.append("YTD_PERF/B.RQST_UT_VAL YTD_PERF," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("NVL( MAX (CASE" ).append("\n"); 
		query.append("WHEN A.GEN_EXPN_TRNS_DIV_CD = 'T'" ).append("\n"); 
		query.append("AND     A.GEN_EXPN_APRO_STEP_CD = B.CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("THEN   A.JAN_AMT" ).append("\n"); 
		query.append("+ A.FEB_AMT" ).append("\n"); 
		query.append("+ A.MAR_AMT" ).append("\n"); 
		query.append("+ A.APR_AMT" ).append("\n"); 
		query.append("+ A.MAY_AMT" ).append("\n"); 
		query.append("+ A.JUN_AMT" ).append("\n"); 
		query.append("+ A.JUL_AMT" ).append("\n"); 
		query.append("+ A.AUG_AMT" ).append("\n"); 
		query.append("+ A.SEP_AMT" ).append("\n"); 
		query.append("+ A.OCT_AMT" ).append("\n"); 
		query.append("+ A.NOV_AMT" ).append("\n"); 
		query.append("+ A.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("),0) AD_AMT" ).append("\n"); 
		query.append("FROM GEM_APRO_STEP A, GEM_ITEM B, GEM_REQUEST C" ).append("\n"); 
		query.append("WHERE    B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_RQST_NO = A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND      B.OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_CD = A.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_ITM_NO = A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_TRNS_DIV_CD = A.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_RQST_SEQ = A.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_APRO_AUTH_OFC_CD = A.GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append("AND      C.GEN_EXPN_RQST_TP_CD = @[gen_expn_rqst_tp_cd]" ).append("\n"); 
		query.append("AND      C.PLN_YRMON LIKE SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'%'" ).append("\n"); 
		query.append("AND A.OFC_CD = @[to_ofc_cd]" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = @[to_gen_expn_cd]) AD_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT   OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",SUM (YEAR_ASS_EXP) YEAR_ASS_EXP" ).append("\n"); 
		query.append(",SUM (YTD_ASS_EXP) YTD_ASS_EXP" ).append("\n"); 
		query.append(",SUM (YTD_PERF) YTD_PERF" ).append("\n"); 
		query.append("FROM     (SELECT OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",   A.GEN_EXPN_INIT_AMT" ).append("\n"); 
		query.append("+ A.GEN_EXPN_ADD_AMT" ).append("\n"); 
		query.append("+ A.GEN_EXPN_TRNS_AMT YEAR_ASS_EXP" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN RSLT_YRMON BETWEEN SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'01' AND TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("THEN (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END YTD_ASS_EXP" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN RSLT_YRMON BETWEEN SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'01' AND TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("THEN SLP_PERF_AMT" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END YTD_PERF" ).append("\n"); 
		query.append("FROM   GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("WHERE  A.RSLT_YRMON LIKE SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'%'" ).append("\n"); 
		query.append("AND A.OFC_CD = @[to_ofc_cd]" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = @[to_gen_expn_cd])" ).append("\n"); 
		query.append("GROUP BY OFC_CD, GEN_EXPN_CD) A," ).append("\n"); 
		query.append("GEM_OFFICE B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'TO' FM_TO," ).append("\n"); 
		query.append("OFC_CD, GEN_EXPN_CD," ).append("\n"); 
		query.append("'USD' LOCL_CURR_CD," ).append("\n"); 
		query.append("1 RQST_UT_VAL," ).append("\n"); 
		query.append("(SELECT AAA.YEAR_ASS_EXP/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'00' AND GEN_EXPN_XCH_RT_DIV_CD = 'I' AND CURR_CD = AAA.LOCL_CURR_CD) YEAR_ASS_EXP," ).append("\n"); 
		query.append("(SELECT AAA.YTD_ASS_EXP/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'00' AND GEN_EXPN_XCH_RT_DIV_CD = 'I' AND CURR_CD = AAA.LOCL_CURR_CD) YTD_ASS_EXP," ).append("\n"); 
		query.append("AAA.YTD_PERF YTD_PERF," ).append("\n"); 
		query.append("(SELECT AAA.AD_AMT/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'00' AND GEN_EXPN_XCH_RT_DIV_CD = 'I' AND CURR_CD = AAA.LOCL_CURR_CD)*AAA.RQST_UT_VAL AD_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT A.OFC_CD, A.GEN_EXPN_CD," ).append("\n"); 
		query.append("B.LOCL_CURR_CD," ).append("\n"); 
		query.append("B.RQST_UT_VAL," ).append("\n"); 
		query.append("YEAR_ASS_EXP," ).append("\n"); 
		query.append("YTD_ASS_EXP," ).append("\n"); 
		query.append("YTD_PERF," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("NVL( MAX (CASE" ).append("\n"); 
		query.append("WHEN A.GEN_EXPN_TRNS_DIV_CD = 'T'" ).append("\n"); 
		query.append("AND     A.GEN_EXPN_APRO_STEP_CD = B.CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("THEN   A.JAN_AMT" ).append("\n"); 
		query.append("+ A.FEB_AMT" ).append("\n"); 
		query.append("+ A.MAR_AMT" ).append("\n"); 
		query.append("+ A.APR_AMT" ).append("\n"); 
		query.append("+ A.MAY_AMT" ).append("\n"); 
		query.append("+ A.JUN_AMT" ).append("\n"); 
		query.append("+ A.JUL_AMT" ).append("\n"); 
		query.append("+ A.AUG_AMT" ).append("\n"); 
		query.append("+ A.SEP_AMT" ).append("\n"); 
		query.append("+ A.OCT_AMT" ).append("\n"); 
		query.append("+ A.NOV_AMT" ).append("\n"); 
		query.append("+ A.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("),0) AD_AMT" ).append("\n"); 
		query.append("FROM GEM_APRO_STEP A, GEM_ITEM B, GEM_REQUEST C" ).append("\n"); 
		query.append("WHERE    B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_RQST_NO = A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND      B.OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_CD = A.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_ITM_NO = A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_TRNS_DIV_CD = A.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_RQST_SEQ = A.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_APRO_AUTH_OFC_CD = A.GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append("AND      C.GEN_EXPN_RQST_TP_CD = @[gen_expn_rqst_tp_cd]" ).append("\n"); 
		query.append("AND      C.PLN_YRMON LIKE SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'%'" ).append("\n"); 
		query.append("AND A.OFC_CD = @[to_ofc_cd]" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = @[to_gen_expn_cd]) AD_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT   OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",SUM (YEAR_ASS_EXP) YEAR_ASS_EXP" ).append("\n"); 
		query.append(",SUM (YTD_ASS_EXP) YTD_ASS_EXP" ).append("\n"); 
		query.append(",SUM (YTD_PERF) YTD_PERF" ).append("\n"); 
		query.append("FROM     (SELECT A.OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",   A.GEN_EXPN_INIT_AMT" ).append("\n"); 
		query.append("+ A.GEN_EXPN_ADD_AMT" ).append("\n"); 
		query.append("+ A.GEN_EXPN_TRNS_AMT YEAR_ASS_EXP" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN RSLT_YRMON BETWEEN SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'01' AND TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("THEN (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END YTD_ASS_EXP" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN RSLT_YRMON BETWEEN SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'01' AND TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("THEN (SELECT A.SLP_PERF_AMT/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON AND GEN_EXPN_XCH_RT_DIV_CD = 'M' AND CURR_CD = B.LOCL_CURR_CD)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END YTD_PERF" ).append("\n"); 
		query.append("FROM   GEM_RSLT_SMRY A, GEM_OFFICE B" ).append("\n"); 
		query.append("WHERE  A.RSLT_YRMON LIKE SUBSTR(TO_CHAR(SYSDATE, 'YYYYMM'),1,4)||'%'" ).append("\n"); 
		query.append("AND A.OFC_CD = @[to_ofc_cd]" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = @[to_gen_expn_cd]" ).append("\n"); 
		query.append("AND A.OFC_CD = B.OFC_CD(+))" ).append("\n"); 
		query.append("GROUP BY OFC_CD, GEN_EXPN_CD) A," ).append("\n"); 
		query.append("GEM_OFFICE B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = B.OFC_CD(+)) AAA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}