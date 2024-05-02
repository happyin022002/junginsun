/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchReportAfterClosingMonthlyCommentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.08.12 박창준
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

public class GEMPlanningPerformanceDBDAOSearchReportAfterClosingMonthlyCommentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report 커맨트
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchReportAfterClosingMonthlyCommentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchReportAfterClosingMonthlyCommentRSQL").append("\n"); 
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
		query.append("SELECT '※ 급여성 비용은 H/S급여, R/S급여, 상여금, 제수당, 잡급 포함' AS RSLT_YRMON01," ).append("\n"); 
		query.append("'※ 급여성 비용은 H/S급여, R/S급여, 상여금, 제수당, 잡급 포함' AS L_3," ).append("\n"); 
		query.append("'※ 급여성 비용은 H/S급여, R/S급여, 상여금, 제수당, 잡급 포함' AS OFC_CD," ).append("\n"); 
		query.append("'※ 급여성 비용은 H/S급여, R/S급여, 상여금, 제수당, 잡급 포함' AS LOCL_CURR_CD," ).append("\n"); 
		query.append("'※ 급여성 비용은 H/S급여, R/S급여, 상여금, 제수당, 잡급 포함' AS USD_LOCL_XCH_RT," ).append("\n"); 
		query.append("'※ 급여성 비용은 H/S급여, R/S급여, 상여금, 제수당, 잡급 포함' AS LCL_SAL," ).append("\n"); 
		query.append("'※ 급여성 비용은 H/S급여, R/S급여, 상여금, 제수당, 잡급 포함' AS LCL_NON_SAL," ).append("\n"); 
		query.append("'※ 급여성 비용은 H/S급여, R/S급여, 상여금, 제수당, 잡급 포함' AS USD_SAL," ).append("\n"); 
		query.append("'※ 급여성 비용은 H/S급여, R/S급여, 상여금, 제수당, 잡급 포함' AS USD_NON_SAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '※ USD 적용환율 = 각 해당 월 경리환율' AS RSLT_YRMON01," ).append("\n"); 
		query.append("'※ USD 적용환율 = 각 해당 월 경리환율' AS L_3," ).append("\n"); 
		query.append("'※ USD 적용환율 = 각 해당 월 경리환율' AS OFC_CD," ).append("\n"); 
		query.append("'※ USD 적용환율 = 각 해당 월 경리환율' AS LOCL_CURR_CD," ).append("\n"); 
		query.append("'※ USD 적용환율 = 각 해당 월 경리환율' AS USD_LOCL_XCH_RT," ).append("\n"); 
		query.append("'※ USD 적용환율 = 각 해당 월 경리환율' AS LCL_SAL," ).append("\n"); 
		query.append("'※ USD 적용환율 = 각 해당 월 경리환율' AS LCL_NON_SAL," ).append("\n"); 
		query.append("'※ USD 적용환율 = 각 해당 월 경리환율' AS USD_SAL," ).append("\n"); 
		query.append("'※ USD 적용환율 = 각 해당 월 경리환율' AS USD_NON_SAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '※ NYCNA는 미주지역 9개점소 포함금액임(NYCNA,NYCBB,ATLBB,ATLSC,CHIBB,HOUBB,LGBBB,SEABB,TORBB)' AS RSLT_YRMON01," ).append("\n"); 
		query.append("'※ NYCNA는 미주지역 9개점소 포함금액임(NYCNA,NYCBB,ATLBB,ATLSC,CHIBB,HOUBB,LGBBB,SEABB,TORBB)' AS L_3," ).append("\n"); 
		query.append("'※ NYCNA는 미주지역 9개점소 포함금액임(NYCNA,NYCBB,ATLBB,ATLSC,CHIBB,HOUBB,LGBBB,SEABB,TORBB)' AS OFC_CD," ).append("\n"); 
		query.append("'※ NYCNA는 미주지역 9개점소 포함금액임(NYCNA,NYCBB,ATLBB,ATLSC,CHIBB,HOUBB,LGBBB,SEABB,TORBB)' AS LOCL_CURR_CD," ).append("\n"); 
		query.append("'※ NYCNA는 미주지역 9개점소 포함금액임(NYCNA,NYCBB,ATLBB,ATLSC,CHIBB,HOUBB,LGBBB,SEABB,TORBB)' AS USD_LOCL_XCH_RT," ).append("\n"); 
		query.append("'※ NYCNA는 미주지역 9개점소 포함금액임(NYCNA,NYCBB,ATLBB,ATLSC,CHIBB,HOUBB,LGBBB,SEABB,TORBB)' AS LCL_SAL," ).append("\n"); 
		query.append("'※ NYCNA는 미주지역 9개점소 포함금액임(NYCNA,NYCBB,ATLBB,ATLSC,CHIBB,HOUBB,LGBBB,SEABB,TORBB)' AS LCL_NON_SAL," ).append("\n"); 
		query.append("'※ NYCNA는 미주지역 9개점소 포함금액임(NYCNA,NYCBB,ATLBB,ATLSC,CHIBB,HOUBB,LGBBB,SEABB,TORBB)' AS USD_SAL," ).append("\n"); 
		query.append("'※ NYCNA는 미주지역 9개점소 포함금액임(NYCNA,NYCBB,ATLBB,ATLSC,CHIBB,HOUBB,LGBBB,SEABB,TORBB)' AS USD_NON_SAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '※ SHADSC : 남중국 Area Director 배정 예산' AS RSLT_YRMON01," ).append("\n"); 
		query.append("'※ SHADSC : 남중국 Area Director 배정 예산' AS L_3," ).append("\n"); 
		query.append("'※ SHADSC : 남중국 Area Director 배정 예산' AS OFC_CD," ).append("\n"); 
		query.append("'※ SHADSC : 남중국 Area Director 배정 예산' AS LOCL_CURR_CD," ).append("\n"); 
		query.append("'※ SHADSC : 남중국 Area Director 배정 예산' AS USD_LOCL_XCH_RT," ).append("\n"); 
		query.append("'※ SHADSC : 남중국 Area Director 배정 예산' AS LCL_SAL," ).append("\n"); 
		query.append("'※ SHADSC : 남중국 Area Director 배정 예산' AS LCL_NON_SAL," ).append("\n"); 
		query.append("'※ SHADSC : 남중국 Area Director 배정 예산' AS USD_SAL," ).append("\n"); 
		query.append("'※ SHADSC : 남중국 Area Director 배정 예산' AS USD_NON_SAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 

	}
}