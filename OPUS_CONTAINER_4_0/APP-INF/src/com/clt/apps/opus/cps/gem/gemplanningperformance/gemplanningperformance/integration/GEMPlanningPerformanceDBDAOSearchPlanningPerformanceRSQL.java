/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchPlanningPerformanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchPlanningPerformanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 확정된 비용계획과 비용실적 정보 조회
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchPlanningPerformanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("login_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_rslt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("perf_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_diff_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("closing_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cur",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_rslt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("com_ratio_num",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_closing_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchPlanningPerformanceRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD, GEN_EXPN_CD, OFC_CO_DIV_CD, ABBR_NM, LOCL_CURR_CD, RQST_UT_VAL, YEAR_ASS_EXP, MON_ASS_EXP, MON_PERF, RATIO, YTD_ASS_EXP, YTD_PERF, RATIO1, DIFF, GEN_EXPN_OVR_RTO_RSN, RSLT_YRMON" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT A.OFC_CD" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("	  ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("      ,DECODE(@[sch_lang], 'K', C.KRN_ABBR_NM" ).append("\n"); 
		query.append("                 , 'E', C.ENG_ABBR_NM ) ABBR_NM" ).append("\n"); 
		query.append("	  ,DECODE(@[ofc_cur], 'LCL', A.LOCL_CURR_CD, 'KRW', 'KRW', 'USD', 'USD' ) LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,DECODE(@[ofc_cur], 'LCL', A.RQST_UT_VAL, 'KRW', '1000', 'USD', '1' ) RQST_UT_VAL" ).append("\n"); 
		query.append("      ,A.YEAR_ASS_EXP" ).append("\n"); 
		query.append("      ,A.MON_ASS_EXP MON_ASS_EXP" ).append("\n"); 
		query.append("      ,A.MON_PERF MON_PERF" ).append("\n"); 
		query.append("      ,DECODE(A.MON_ASS_EXP, 0, 0, (A.MON_PERF/A.MON_ASS_EXP)*100) RATIO      " ).append("\n"); 
		query.append("      ,A.YTD_ASS_EXP YTD_ASS_EXP" ).append("\n"); 
		query.append("      ,A.YTD_PERF YTD_PERF" ).append("\n"); 
		query.append("      ,DECODE(A.YTD_ASS_EXP, 0, 0, (A.YTD_PERF/A.YTD_ASS_EXP)*100) RATIO1" ).append("\n"); 
		query.append("      ,(A.YTD_ASS_EXP - A.YTD_PERF) DIFF" ).append("\n"); 
		query.append("      ,GEN_EXPN_OVR_RTO_RSN AS GEN_EXPN_OVR_RTO_RSN" ).append("\n"); 
		query.append("      ,DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) AS RSLT_YRMON" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.OFC_CD" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("              ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("              ,A.RQST_UT_VAL      " ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'LCL', A.YEAR_ASS_EXP/A.RQST_UT_VAL" ).append("\n"); 
		query.append("                               , 'USD', A.YEAR_ASS_EXP/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                               , 'KRW', ((A.YEAR_ASS_EXP/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) YEAR_ASS_EXP" ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'LCL', A.MON_ASS_EXP/A.RQST_UT_VAL" ).append("\n"); 
		query.append("                               , 'USD', A.MON_ASS_EXP/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                               , 'KRW', ((A.MON_ASS_EXP/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) MON_ASS_EXP      " ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'LCL', A.MON_PERF/A.RQST_UT_VAL" ).append("\n"); 
		query.append("                               , 'USD', A.MON_PERF/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                               , 'KRW', ((A.MON_PERF/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) MON_PERF" ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'LCL', A.YTD_ASS_EXP/A.RQST_UT_VAL" ).append("\n"); 
		query.append("                               , 'USD', A.YTD_ASS_EXP/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                               , 'KRW', ((A.YTD_ASS_EXP/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) YTD_ASS_EXP                       " ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'LCL', A.YTD_PERF/A.RQST_UT_VAL" ).append("\n"); 
		query.append("                               , 'USD', A.YTD_PERF/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                               , 'KRW', ((A.YTD_PERF/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) YTD_PERF" ).append("\n"); 
		query.append("	      ,(SELECT MAX(GEN_EXPN_OVR_RTO_RSN) FROM GEM_RSLT_SMRY WHERE RSLT_YRMON = DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) AND OFC_CD = A.OFC_CD AND A.GEN_EXPN_CD = GEN_EXPN_CD) GEN_EXPN_OVR_RTO_RSN" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A.OFC_CD" ).append("\n"); 
		query.append("                      ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                      ,B.LOCL_CURR_CD" ).append("\n"); 
		query.append("                      ,B.RQST_UT_VAL" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,A.RSLT_YRMON" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT YEAR_ASS_EXP" ).append("\n"); 
		query.append("                      ,CASE WHEN A.RSLT_YRMON BETWEEN DECODE(@[perf_div],'Y',@[from_closing_date],@[from_rslt_yrmon]) AND DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) THEN (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT) " ).append("\n"); 
		query.append("                            ELSE 0                                                 " ).append("\n"); 
		query.append("                        END MON_ASS_EXP" ).append("\n"); 
		query.append("                      ,CASE WHEN A.RSLT_YRMON BETWEEN DECODE(@[perf_div],'Y',@[from_closing_date],@[from_rslt_yrmon]) AND DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) THEN A.SLP_PERF_AMT" ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                        END MON_PERF                                                 " ).append("\n"); 
		query.append("                      ,CASE WHEN A.RSLT_YRMON BETWEEN SUBSTR(@[from_rslt_yrmon], 1, 4)||'01' AND DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) THEN (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT) " ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                        END YTD_ASS_EXP" ).append("\n"); 
		query.append("                      ,CASE WHEN A.RSLT_YRMON BETWEEN SUBSTR(@[from_rslt_yrmon], 1, 4)||'01' AND DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) THEN A.SLP_PERF_AMT" ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                        END YTD_PERF" ).append("\n"); 
		query.append("                    FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                      ,GEM_OFFICE B" ).append("\n"); 
		query.append("                    WHERE A.RSLT_YRMON LIKE SUBSTR(@[from_rslt_yrmon], 1, 4)||'%'" ).append("\n"); 
		query.append("                    AND A.GEN_EXPN_CD BETWEEN DECODE (@[sch_expense_from], '', '111111', @[sch_expense_from]) AND DECODE (@[sch_expense_to], '', '999999', @[sch_expense_to]) " ).append("\n"); 
		query.append("                    AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT B.YRMON" ).append("\n"); 
		query.append("                      ,A.CURR_CD" ).append("\n"); 
		query.append("                      ,A.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                      ,A.LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("                      ,A.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                  FROM GEM_XCH_RT A" ).append("\n"); 
		query.append("                      ,(" ).append("\n"); 
		query.append("                        SELECT SUBSTR(@[from_rslt_yrmon], 1, 4)||TRIM(TO_CHAR(ROWNUM,'00')) YRMON" ).append("\n"); 
		query.append("                          FROM DUAL " ).append("\n"); 
		query.append("                       CONNECT BY LEVEL <= 12" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)||'00'" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               ) B" ).append("\n"); 
		query.append("              ,GEM_XCH_RT C      " ).append("\n"); 
		query.append("         WHERE A.RSLT_YRMON   = B.YRMON" ).append("\n"); 
		query.append("           AND A.LOCL_CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("           AND A.RSLT_YRMON   = C.ACCT_XCH_RT_YRMON(+)" ).append("\n"); 
		query.append("           AND A.LOCL_CURR_CD = C.CURR_CD(+)" ).append("\n"); 
		query.append("           AND C.GEN_EXPN_XCH_RT_DIV_CD(+) = 'M'" ).append("\n"); 
		query.append("           AND C.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("         GROUP BY A.OFC_CD" ).append("\n"); 
		query.append("                 ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                 ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                 ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("                 ,A.RQST_UT_VAL         " ).append("\n"); 
		query.append("       ) A," ).append("\n"); 
		query.append("      GEM_OFFICE B, GEM_EXPENSE C, GEM_EXPN_GRP_V D" ).append("\n"); 
		query.append("    WHERE A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("	AND A.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("	AND A.GEN_EXPN_CD = D.GEN_EXPN_CD" ).append("\n"); 
		query.append("	#if (${sch_expense_group} != '') " ).append("\n"); 
		query.append("	AND D.GEM_EXPN_GRP_CD1 = @[sch_expense_group]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${sch_tic_cd} != '')" ).append("\n"); 
		query.append("	AND C.TIC_CD = @[sch_tic_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if(${ofc_co} == 'O')" ).append("\n"); 
		query.append("	AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${ofc_co} == 'S')" ).append("\n"); 
		query.append("	AND A.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("-- (YNYN) 일때 -- 비용주관팀           " ).append("\n"); 
		query.append("     AND (A.OFC_CD = @[login_office] OR C.TIC_CD = @[login_office])" ).append("\n"); 
		query.append("#elseif(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("-- (YYYN) 일때 -- BU CTRL||비용주관" ).append("\n"); 
		query.append("     AND ( A.OFC_CD IN ( SELECT L_4 FROM GEM_OFC_LEVEL_V WHERE L_3 = @[login_office] ) OR C.TIC_CD = @[login_office] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${expn_dep} == 'FAC')" ).append("\n"); 
		query.append("   AND 1 = DECODE(A.GEN_EXPN_CD, '240601', DECODE(A.OFC_CO_DIV_CD, 'O', 0 , 1 ) , 1 )  " ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT C.TIC_CD OFC_CD" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("	  ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("      ,DECODE(@[sch_lang], 'K', C.KRN_ABBR_NM" ).append("\n"); 
		query.append("                 , 'E', C.ENG_ABBR_NM ) ABBR_NM" ).append("\n"); 
		query.append("	  ,DECODE(@[ofc_cur], 'LCL', A.LOCL_CURR_CD, 'KRW', 'KRW', 'USD', 'USD' ) LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,DECODE(@[ofc_cur], 'LCL', A.RQST_UT_VAL, 'KRW', '1000', 'USD', '1' ) RQST_UT_VAL" ).append("\n"); 
		query.append("      ,A.YEAR_ASS_EXP" ).append("\n"); 
		query.append("      ,A.MON_ASS_EXP MON_ASS_EXP" ).append("\n"); 
		query.append("      ,A.MON_PERF MON_PERF" ).append("\n"); 
		query.append("      ,DECODE(A.MON_ASS_EXP, 0, 0, (A.MON_PERF/A.MON_ASS_EXP)*100) RATIO      " ).append("\n"); 
		query.append("      ,A.YTD_ASS_EXP YTD_ASS_EXP" ).append("\n"); 
		query.append("      ,A.YTD_PERF YTD_PERF" ).append("\n"); 
		query.append("      ,DECODE(A.YTD_ASS_EXP, 0, 0, (A.YTD_PERF/A.YTD_ASS_EXP)*100) RATIO1" ).append("\n"); 
		query.append("      ,(A.YTD_ASS_EXP - A.YTD_PERF) DIFF" ).append("\n"); 
		query.append("      ,GEN_EXPN_OVR_RTO_RSN AS GEN_EXPN_OVR_RTO_RSN" ).append("\n"); 
		query.append("      ,DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) AS RSLT_YRMON" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("       SELECT  D.TIC_CD" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,MAX(DECODE(D.TIC_CD, A.OFC_CD, A.OFC_CO_DIV_CD)) OFC_CO_DIV_CD" ).append("\n"); 
		query.append("              ,MAX(DECODE(D.TIC_CD, A.OFC_CD, A.LOCL_CURR_CD)) LOCL_CURR_CD" ).append("\n"); 
		query.append("              ,MAX(DECODE(D.TIC_CD, A.OFC_CD, A.RQST_UT_VAL)) RQST_UT_VAL" ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'LCL', ((A.YEAR_ASS_EXP/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                    , 'USD', A.YEAR_ASS_EXP/B.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                    , 'KRW', ((A.YEAR_ASS_EXP/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) YEAR_ASS_EXP" ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'LCL', ((A.MON_ASS_EXP/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                    , 'USD', A.MON_ASS_EXP/B.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                    , 'KRW', ((A.MON_ASS_EXP/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) MON_ASS_EXP" ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'LCL', ((A.MON_PERF/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                    , 'USD', A.MON_PERF/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                    , 'KRW', ((A.MON_PERF/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) MON_PERF " ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'LCL', ((A.YTD_ASS_EXP/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT  " ).append("\n"); 
		query.append("                                    , 'USD', A.YTD_ASS_EXP/B.USD_LOCL_XCH_RT                            " ).append("\n"); 
		query.append("                                    , 'KRW', ((A.YTD_ASS_EXP/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) YTD_ASS_EXP" ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'LCL', ((A.YTD_PERF/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                    , 'USD', A.YTD_PERF/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                    , 'KRW', ((A.YTD_PERF/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) YTD_PERF" ).append("\n"); 
		query.append("	      ,(SELECT MAX(GEN_EXPN_OVR_RTO_RSN) FROM GEM_RSLT_SMRY WHERE RSLT_YRMON = DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) AND OFC_CD = D.TIC_CD AND A.GEN_EXPN_CD = GEN_EXPN_CD) GEN_EXPN_OVR_RTO_RSN" ).append("\n"); 
		query.append("	       FROM (" ).append("\n"); 
		query.append("                SELECT A.OFC_CD" ).append("\n"); 
		query.append("                      ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                      ,B.LOCL_CURR_CD" ).append("\n"); 
		query.append("                      ,B.RQST_UT_VAL" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,A.RSLT_YRMON" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT YEAR_ASS_EXP" ).append("\n"); 
		query.append("                      ,CASE WHEN A.RSLT_YRMON BETWEEN DECODE(@[perf_div],'Y',@[from_closing_date],@[from_rslt_yrmon]) AND DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) THEN (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT) " ).append("\n"); 
		query.append("                            ELSE 0                                                 " ).append("\n"); 
		query.append("                        END MON_ASS_EXP" ).append("\n"); 
		query.append("                      ,CASE WHEN A.RSLT_YRMON BETWEEN DECODE(@[perf_div],'Y',@[from_closing_date],@[from_rslt_yrmon]) AND DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) THEN A.SLP_PERF_AMT" ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                        END MON_PERF " ).append("\n"); 
		query.append("                      ,CASE WHEN A.RSLT_YRMON BETWEEN SUBSTR(@[from_rslt_yrmon], 1, 4)||'01' AND DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) THEN (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT) " ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                        END YTD_ASS_EXP" ).append("\n"); 
		query.append("                      ,CASE WHEN A.RSLT_YRMON BETWEEN SUBSTR(@[from_rslt_yrmon], 1, 4)||'01' AND DECODE(@[perf_div],'Y',@[closing_date],@[to_rslt_yrmon]) THEN A.SLP_PERF_AMT" ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                        END YTD_PERF" ).append("\n"); 
		query.append("                    FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                      ,GEM_OFFICE B" ).append("\n"); 
		query.append("                    WHERE A.RSLT_YRMON LIKE SUBSTR(@[from_rslt_yrmon], 1, 4)||'%'" ).append("\n"); 
		query.append("                    AND A.GEN_EXPN_CD BETWEEN DECODE (@[sch_expense_from], '', '111111', @[sch_expense_from]) AND DECODE (@[sch_expense_to], '', '999999', @[sch_expense_to])" ).append("\n"); 
		query.append("                    AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                    AND A.GEN_EXPN_CD = '240601'" ).append("\n"); 
		query.append("                    AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT B.YRMON" ).append("\n"); 
		query.append("                      ,A.CURR_CD" ).append("\n"); 
		query.append("                      ,A.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                      ,A.LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("                      ,A.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                  FROM GEM_XCH_RT A" ).append("\n"); 
		query.append("                      ,(" ).append("\n"); 
		query.append("                        SELECT SUBSTR(@[from_rslt_yrmon], 1, 4)||TRIM(TO_CHAR(ROWNUM,'00')) YRMON" ).append("\n"); 
		query.append("                          FROM DUAL " ).append("\n"); 
		query.append("                       CONNECT BY LEVEL <= 12" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)||'00'" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               ) B" ).append("\n"); 
		query.append("              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("              ,GEM_EXPENSE D      " ).append("\n"); 
		query.append("         WHERE A.RSLT_YRMON   = B.YRMON" ).append("\n"); 
		query.append("           AND A.LOCL_CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("           AND A.RSLT_YRMON   = C.ACCT_XCH_RT_YRMON(+)" ).append("\n"); 
		query.append("           AND A.LOCL_CURR_CD = C.CURR_CD(+)" ).append("\n"); 
		query.append("           AND C.GEN_EXPN_XCH_RT_DIV_CD(+) = 'M'" ).append("\n"); 
		query.append("           AND C.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("           AND A.GEN_EXPN_CD = D.GEN_EXPN_CD" ).append("\n"); 
		query.append("         GROUP BY D.TIC_CD " ).append("\n"); 
		query.append("                 ,A.GEN_EXPN_CD   " ).append("\n"); 
		query.append("       ) A," ).append("\n"); 
		query.append("      GEM_OFFICE B, GEM_EXPENSE C, GEM_EXPN_GRP_V D" ).append("\n"); 
		query.append("    WHERE D.TIC_CD = B.OFC_CD" ).append("\n"); 
		query.append("	AND A.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("	AND A.GEN_EXPN_CD = D.GEN_EXPN_CD" ).append("\n"); 
		query.append("	#if (${sch_expense_group} != '') " ).append("\n"); 
		query.append("	AND D.GEM_EXPN_GRP_CD1 = @[sch_expense_group]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${sch_tic_cd} != '')" ).append("\n"); 
		query.append("	AND C.TIC_CD = @[sch_tic_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if(${ofc_co} == 'O')" ).append("\n"); 
		query.append("	AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${ofc_co} == 'S')" ).append("\n"); 
		query.append("	AND A.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("	-- (YNYN) 일때 -- 비용주관팀           " ).append("\n"); 
		query.append("     AND (A.TIC_CD = @[login_office] OR C.TIC_CD = @[login_office])" ).append("\n"); 
		query.append("	#elseif(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("	-- (YYYN) 일때 -- BU CTRL||비용주관" ).append("\n"); 
		query.append("     AND ( A.TIC_CD IN ( SELECT L_4 FROM GEM_OFC_LEVEL_V WHERE L_3 = @[login_office] ) OR C.TIC_CD = @[login_office] )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sls_ofc_div_cd} != '' || ${ofc_expn_cd} != '')" ).append("\n"); 
		query.append("   	AND OFC_CD in (" ).append("\n"); 
		query.append("	SELECT OFC_CD      " ).append("\n"); 
		query.append("  	FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("	START WITH OFC_CD IN (    " ).append("\n"); 
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
		query.append("	)" ).append("\n"); 
		query.append("	CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${com_ratio} == '1')" ).append("\n"); 
		query.append("AND RATIO1 < @[com_ratio_num]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${com_ratio} == '2')" ).append("\n"); 
		query.append("AND RATIO1 >= @[com_ratio_num]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${com_diff} == '1')" ).append("\n"); 
		query.append("AND DIFF < @[com_diff_num]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${com_diff} == '2')" ).append("\n"); 
		query.append("AND DIFF >= @[com_diff_num]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sub_total} == 'Office')" ).append("\n"); 
		query.append("ORDER BY OFC_CD, GEN_EXPN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sub_total} == 'Expense')" ).append("\n"); 
		query.append("ORDER BY GEN_EXPN_CD, OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sub_total} == 'NO')" ).append("\n"); 
		query.append("ORDER BY OFC_CD, GEN_EXPN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}