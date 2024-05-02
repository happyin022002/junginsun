/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchComparisonPlanningRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchComparisonPlanningRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수립된 비용계획에 대한 요청 정보를 승인단계별로 비교 조회한다
	  * 2011.01.31 이준범[CHM-201108626-01]
	  * 요청사항 : SELPLL- >SELLIC  관련 문제 연관 해소
	  * 보완내역 : 조직 변경으로 인한 조직 코드 변경시 과거 데이터를 조회 할 수 있도록
	  *                History Table(GEM_OFC_HIS) 검색하도록 SQL 수정  
	  * 2014.10.23 이준범 [CHM-201432508-01]
	  * 요청사항: [GEM] 결산작업을 위한 데이터 업데이트 지원
	  * 보완: SELPLI 하드코딩 부분 삭제 
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchComparisonPlanningRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cur",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_expense_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lang",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_expense_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_expense_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_tic_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchComparisonPlanningRSQL").append("\n"); 
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
		query.append("SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("      ,GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("	  ,GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("      ,GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("      ,FM_OFC_CD" ).append("\n"); 
		query.append("      ,TO_OFC_CD" ).append("\n"); 
		query.append("      ,FM_GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,TO_GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,FM_ABBR_NM" ).append("\n"); 
		query.append("      ,TO_ABBR_NM" ).append("\n"); 
		query.append("      ,PLN_YR" ).append("\n"); 
		query.append("      ,FM_LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,TO_LOCL_CURR_CD" ).append("\n"); 
		query.append("	  ,FM_RQST_UT_VAL" ).append("\n"); 
		query.append("	  ,TO_RQST_UT_VAL                   " ).append("\n"); 
		query.append("      ,FM_RQ_AMT" ).append("\n"); 
		query.append("      ,TO_RQ_AMT                 " ).append("\n"); 
		query.append("      ,FM_HQ_AMT" ).append("\n"); 
		query.append("      ,TO_HQ_AMT     " ).append("\n"); 
		query.append("      ,FM_TC_AMT" ).append("\n"); 
		query.append("      ,TO_TC_AMT   " ).append("\n"); 
		query.append("      ,FM_CO_AMT" ).append("\n"); 
		query.append("      ,TO_CO_AMT " ).append("\n"); 
		query.append("      ,(FM_RQ_AMT - FM_CO_AMT ) FM_DIFF" ).append("\n"); 
		query.append("      ,(TO_RQ_AMT - TO_CO_AMT ) TO_DIFF" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("              ,NVL(FM_GEN_EXPN_CD, TO_GEN_EXPN_CD) GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,NVL(FM_GEN_EXPN_ITM_NO, TO_GEN_EXPN_ITM_NO) GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("              ,GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("              ,GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("              ,FM_OFC_CD" ).append("\n"); 
		query.append("              ,TO_OFC_CD" ).append("\n"); 
		query.append("              ,FM_GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,TO_GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,DECODE(@[sch_lang], 'K', FM_KRN_ABBR_NM" ).append("\n"); 
		query.append("                         , 'E', FM_ENG_ABBR_NM ) FM_ABBR_NM" ).append("\n"); 
		query.append("              ,DECODE(@[sch_lang], 'K', TO_KRN_ABBR_NM" ).append("\n"); 
		query.append("                         , 'E', TO_ENG_ABBR_NM ) TO_ABBR_NM" ).append("\n"); 
		query.append("              ,PLN_YR" ).append("\n"); 
		query.append("              ,DECODE(@[ofc_cur], 'LCL', FM_LOCL_CURR_CD" ).append("\n"); 
		query.append("                           , 'USD', DECODE(FM_LOCL_CURR_CD,NULL,NULL,'USD')" ).append("\n"); 
		query.append("                           , 'KRW', DECODE(FM_LOCL_CURR_CD,NULL,NULL,'KRW') ) FM_LOCL_CURR_CD" ).append("\n"); 
		query.append("              ,DECODE(@[ofc_cur], 'LCL', TO_LOCL_CURR_CD" ).append("\n"); 
		query.append("                           , 'USD', DECODE(TO_LOCL_CURR_CD,NULL,NULL,'USD')" ).append("\n"); 
		query.append("                           , 'KRW', DECODE(TO_LOCL_CURR_CD,NULL,NULL,'KRW') ) TO_LOCL_CURR_CD  " ).append("\n"); 
		query.append("              ,DECODE(@[ofc_cur], 'LCL', FM_RQST_UT_VAL, 'KRW', DECODE(FM_RQST_UT_VAL,NULL,NULL,'1000'), 'USD', DECODE(FM_RQST_UT_VAL,NULL,NULL,'1') ) FM_RQST_UT_VAL  " ).append("\n"); 
		query.append("			  ,DECODE(@[ofc_cur], 'LCL', TO_RQST_UT_VAL, 'KRW', DECODE(TO_RQST_UT_VAL,NULL,NULL,'1000'), 'USD', DECODE(TO_RQST_UT_VAL,NULL,NULL,'1') ) TO_RQST_UT_VAL  " ).append("\n"); 
		query.append("              ,DECODE(@[ofc_cur], 'LCL', FM_RQ_AMT" ).append("\n"); 
		query.append("                           , 'USD', (FM_RQ_AMT*FM_RQST_UT_VAL)/FM_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           , 'KRW', (((FM_RQ_AMT*FM_RQST_UT_VAL)/1000)/FM_USD_LOCL_XCH_RT)*FM_USD_KRW_XCH_RT ) FM_RQ_AMT" ).append("\n"); 
		query.append("              ,DECODE(@[ofc_cur], 'LCL', TO_RQ_AMT" ).append("\n"); 
		query.append("                           , 'USD', (TO_RQ_AMT*TO_RQST_UT_VAL)/TO_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           , 'KRW', (((TO_RQ_AMT*TO_RQST_UT_VAL)/1000)/TO_USD_LOCL_XCH_RT)*TO_USD_KRW_XCH_RT ) TO_RQ_AMT                 " ).append("\n"); 
		query.append("              ,DECODE(@[ofc_cur], 'LCL', FM_HQ_AMT" ).append("\n"); 
		query.append("                           , 'USD', (FM_HQ_AMT*FM_RQST_UT_VAL)/FM_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           , 'KRW', (((FM_HQ_AMT*FM_RQST_UT_VAL)/1000)/FM_USD_LOCL_XCH_RT)*FM_USD_KRW_XCH_RT ) FM_HQ_AMT" ).append("\n"); 
		query.append("              ,DECODE(@[ofc_cur], 'LCL', TO_HQ_AMT" ).append("\n"); 
		query.append("                           , 'USD', (TO_HQ_AMT*TO_RQST_UT_VAL)/TO_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           , 'KRW', (((TO_HQ_AMT*TO_RQST_UT_VAL)/1000)/TO_USD_LOCL_XCH_RT)*TO_USD_KRW_XCH_RT ) TO_HQ_AMT     " ).append("\n"); 
		query.append("              ,DECODE(@[ofc_cur], 'LCL', FM_TC_AMT" ).append("\n"); 
		query.append("                           , 'USD', (FM_TC_AMT*FM_RQST_UT_VAL)/FM_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           , 'KRW', (((FM_TC_AMT*FM_RQST_UT_VAL)/1000)/FM_USD_LOCL_XCH_RT)*FM_USD_KRW_XCH_RT ) FM_TC_AMT" ).append("\n"); 
		query.append("              ,DECODE(@[ofc_cur], 'LCL', TO_TC_AMT" ).append("\n"); 
		query.append("                           , 'USD', (TO_TC_AMT*TO_RQST_UT_VAL)/TO_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           , 'KRW', (((TO_TC_AMT*TO_RQST_UT_VAL)/1000)/TO_USD_LOCL_XCH_RT)*TO_USD_KRW_XCH_RT ) TO_TC_AMT   " ).append("\n"); 
		query.append("              ,DECODE(@[ofc_cur], 'LCL', FM_CO_AMT" ).append("\n"); 
		query.append("                           , 'USD', (FM_CO_AMT*FM_RQST_UT_VAL)/FM_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           , 'KRW', (((FM_CO_AMT*FM_RQST_UT_VAL)/1000)/FM_USD_LOCL_XCH_RT)*FM_USD_KRW_XCH_RT ) FM_CO_AMT" ).append("\n"); 
		query.append("              ,DECODE(@[ofc_cur], 'LCL', TO_CO_AMT" ).append("\n"); 
		query.append("                           , 'USD', (TO_CO_AMT*TO_RQST_UT_VAL)/TO_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                           , 'KRW', (((TO_CO_AMT*TO_RQST_UT_VAL)/1000)/TO_USD_LOCL_XCH_RT)*TO_USD_KRW_XCH_RT ) TO_CO_AMT                                                         " ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT SUBSTR(A.PLN_YRMON,1,4) PLN_YR" ).append("\n"); 
		query.append("                      ,C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                      ,C.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("                      ,C.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'F', C.OFC_CD)) FM_OFC_CD" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'T', C.OFC_CD)) TO_OFC_CD" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'F', C.GEN_EXPN_CD)) FM_GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'T', C.GEN_EXPN_CD)) TO_GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'F', C.GEN_EXPN_ITM_NO)) FM_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'T', C.GEN_EXPN_ITM_NO)) TO_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'F', D.KRN_ABBR_NM)) FM_KRN_ABBR_NM" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'T', D.KRN_ABBR_NM)) TO_KRN_ABBR_NM" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'F', D.ENG_ABBR_NM)) FM_ENG_ABBR_NM" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'T', D.ENG_ABBR_NM)) TO_ENG_ABBR_NM" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'F', E.LOCL_CURR_CD)) FM_LOCL_CURR_CD" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'T', E.LOCL_CURR_CD)) TO_LOCL_CURR_CD    " ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'F', E.RQST_UT_VAL)) FM_RQST_UT_VAL" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'T', E.RQST_UT_VAL)) TO_RQST_UT_VAL              " ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'F', F.USD_LOCL_XCH_RT)) FM_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'T', F.USD_LOCL_XCH_RT)) TO_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'F', F.USD_KRW_XCH_RT)) FM_USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                      ,MAX(DECODE(C.GEN_EXPN_TRNS_DIV_CD, 'T', F.USD_KRW_XCH_RT)) TO_USD_KRW_XCH_RT            " ).append("\n"); 
		query.append("                      ,SUM(CASE WHEN C.GEN_EXPN_TRNS_DIV_CD = 'F' AND C.GEN_EXPN_APRO_STEP_CD = 'RQ' THEN C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT ELSE 0 END) FM_RQ_AMT" ).append("\n"); 
		query.append("                      ,SUM(CASE WHEN C.GEN_EXPN_TRNS_DIV_CD = 'T' AND C.GEN_EXPN_APRO_STEP_CD = 'RQ' THEN C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT ELSE 0 END) TO_RQ_AMT" ).append("\n"); 
		query.append("                      ,SUM(CASE WHEN C.GEN_EXPN_TRNS_DIV_CD = 'F' AND C.GEN_EXPN_APRO_STEP_CD = 'HQ' THEN C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT ELSE 0 END) FM_HQ_AMT" ).append("\n"); 
		query.append("                      ,SUM(CASE WHEN C.GEN_EXPN_TRNS_DIV_CD = 'T' AND C.GEN_EXPN_APRO_STEP_CD = 'HQ' THEN C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT ELSE 0 END) TO_HQ_AMT" ).append("\n"); 
		query.append("                      ,SUM(CASE WHEN C.GEN_EXPN_TRNS_DIV_CD = 'F' AND C.GEN_EXPN_APRO_STEP_CD = 'TC' THEN C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT ELSE 0 END) FM_TC_AMT" ).append("\n"); 
		query.append("                      ,SUM(CASE WHEN C.GEN_EXPN_TRNS_DIV_CD = 'T' AND C.GEN_EXPN_APRO_STEP_CD = 'TC' THEN C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT ELSE 0 END) TO_TC_AMT" ).append("\n"); 
		query.append("                      ,SUM(CASE WHEN C.GEN_EXPN_TRNS_DIV_CD = 'F' AND C.GEN_EXPN_APRO_STEP_CD = 'CO' THEN C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT ELSE 0 END) FM_CO_AMT" ).append("\n"); 
		query.append("                      ,SUM(CASE WHEN C.GEN_EXPN_TRNS_DIV_CD = 'T' AND C.GEN_EXPN_APRO_STEP_CD = 'CO' THEN C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT ELSE 0 END) TO_CO_AMT" ).append("\n"); 
		query.append("                  FROM GEM_REQUEST A" ).append("\n"); 
		query.append("                      ,GEM_ITEM B" ).append("\n"); 
		query.append("                      ,GEM_APRO_STEP C" ).append("\n"); 
		query.append("                      ,GEM_EXPN_GRP_V D" ).append("\n"); 
		query.append("                      ,GEM_OFFICE E" ).append("\n"); 
		query.append("                      ,GEM_XCH_RT F" ).append("\n"); 
		query.append("		      		  ,GEM_EXPENSE G" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("		   #if(${rslt_yrmon} != '')" ).append("\n"); 
		query.append("		   AND A.PLN_YRMON LIKE @[rslt_yrmon]||'%'" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if (${gen_expn_rqst_tp_cd} == 'EI') " ).append("\n"); 
		query.append("		   AND A.GEN_EXPN_RQST_TP_CD = 'EI'" ).append("\n"); 
		query.append("		   #else " ).append("\n"); 
		query.append("		   AND A.GEN_EXPN_RQST_TP_CD IN ('ET','EA')" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                   AND B.CRNT_GEN_EXPN_APRO_STEP_CD = 'CO'" ).append("\n"); 
		query.append("                   AND B.CRNT_GEN_EXPN_APSTS_CD = 'AP'" ).append("\n"); 
		query.append("                   AND B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                   AND B.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("                   AND B.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("                   AND B.GEN_EXPN_ITM_NO = C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                   AND B.GEN_EXPN_TRNS_DIV_CD = C.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("                   AND B.GEN_EXPN_RQST_SEQ = C.GEN_EXPN_RQST_SEQ    " ).append("\n"); 
		query.append("                   AND B.GEN_EXPN_CD = D.GEN_EXPN_CD  " ).append("\n"); 
		query.append("		   AND C.GEN_EXPN_CD = G.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("		   #if (${sch_expense_group} != '') " ).append("\n"); 
		query.append("		   AND D.GEM_EXPN_GRP_CD1 = @[sch_expense_group]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   AND C.GEN_EXPN_CD BETWEEN DECODE (@[sch_expense_from], '', '111111', @[sch_expense_from]) AND DECODE (@[sch_expense_to], '', '999999', @[sch_expense_to])" ).append("\n"); 
		query.append("           #if(${sch_tic_cd} != '')" ).append("\n"); 
		query.append("           AND G.TIC_CD = @[sch_tic_cd]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_co} == 'O')" ).append("\n"); 
		query.append("		   AND E.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_co} == 'S')" ).append("\n"); 
		query.append("		   AND E.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   AND B.OFC_CD = E.OFC_CD" ).append("\n"); 
		query.append("           AND F.ACCT_XCH_RT_YRMON = SUBSTR(@[rslt_yrmon],1,4)||'00'" ).append("\n"); 
		query.append("           AND E.LOCL_CURR_CD = F.CURR_CD" ).append("\n"); 
		query.append("           AND F.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("#if(${auth_flg} == 'YYNN')" ).append("\n"); 
		query.append("           AND ( B.OFC_CD IN ( SELECT OFC_CD      " ).append("\n"); 
		query.append("                                 FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                           START WITH OFC_CD IN  ( SELECT L_4 " ).append("\n"); 
		query.append("                                                     FROM GEM_OFC_LEVEL_V " ).append("\n"); 
		query.append("                                                    WHERE L_3 = @[login_office] ) " ).append("\n"); 
		query.append("                     CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ))" ).append("\n"); 
		query.append("#elseif(${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("           AND (B.OFC_CD IN (SELECT OFC_CD      " ).append("\n"); 
		query.append("                               FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                         START WITH OFC_CD IN (@[login_office])" ).append("\n"); 
		query.append("                   CONNECT BY PRIOR OFC_CD = BFR_OFC_CD )" ).append("\n"); 
		query.append("               OR G.TIC_CD = @[login_office] )" ).append("\n"); 
		query.append("#elseif(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("		   AND ( B.OFC_CD IN ( SELECT OFC_CD      " ).append("\n"); 
		query.append("                                 FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                           START WITH OFC_CD IN  ( SELECT L_4 " ).append("\n"); 
		query.append("                                                     FROM GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("                                                    WHERE L_3 = @[login_office] )" ).append("\n"); 
		query.append("                     CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) " ).append("\n"); 
		query.append("               OR G.TIC_CD = @[login_office] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 GROUP BY SUBSTR(A.PLN_YRMON,1,4)" ).append("\n"); 
		query.append("                         ,C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                         ,C.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("                         ,C.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("               ) " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if(${sls_ofc_div_cd} != '' || ${ofc_expn_cd} != '')" ).append("\n"); 
		query.append("   WHERE ( FM_OFC_CD IN (" ).append("\n"); 
		query.append("	SELECT OFC_CD      " ).append("\n"); 
		query.append("  	FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("	START WITH OFC_CD IN (   " ).append("\n"); 
		query.append("        SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("          FROM GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("		   #if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("           AND RGN_OFC_FLG LIKE @[sls_ofc_div_cd]||'%'" ).append("\n"); 
		query.append("		   #end		" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} != '') " ).append("\n"); 
		query.append("		   AND L_4 LIKE @[ofc_lvl3]||'%' " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   AND L_3 LIKE @[ofc_lvl2]||'%' " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} == '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   AND L_2 LIKE @[ofc_lvl1]||'%' " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("           #if (${ofc_expn_cd} != '') " ).append("\n"); 
		query.append("		   AND L_4 LIKE @[ofc_expn_cd]||'%' " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("        OR TO_OFC_CD IN (" ).append("\n"); 
		query.append("	SELECT OFC_CD      " ).append("\n"); 
		query.append("  	FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("	START WITH OFC_CD IN (   " ).append("\n"); 
		query.append("        SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("          FROM GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("		   #if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("           AND RGN_OFC_FLG LIKE @[sls_ofc_div_cd]||'%'" ).append("\n"); 
		query.append("		   #end		" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} != '') " ).append("\n"); 
		query.append("		   AND L_4 LIKE @[ofc_lvl3]||'%' " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   AND L_3 LIKE @[ofc_lvl2]||'%' " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} == '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   AND L_2 LIKE @[ofc_lvl1]||'%' " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		  " ).append("\n"); 
		query.append("           #if (${ofc_expn_cd} != '') " ).append("\n"); 
		query.append("		   AND L_4 LIKE @[ofc_expn_cd]||'%' " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("    ) )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY FM_OFC_CD||TO_OFC_CD" ).append("\n"); 
		query.append("         ,FM_GEN_EXPN_CD||TO_GEN_EXPN_CD" ).append("\n"); 
		query.append("         ,GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 

	}
}