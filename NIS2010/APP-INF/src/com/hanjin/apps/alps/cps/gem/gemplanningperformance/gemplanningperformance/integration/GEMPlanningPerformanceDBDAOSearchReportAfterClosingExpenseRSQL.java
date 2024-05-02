/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchReportAfterClosingExpenseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.29 
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

public class GEMPlanningPerformanceDBDAOSearchReportAfterClosingExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 기간에 대한 비목별 집행실적 분석 Report
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchReportAfterClosingExpenseRSQL(){
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
		params.put("sch_lang",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sch_expense_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_tic_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchReportAfterClosingExpenseRSQL").append("\n"); 
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
		query.append("SELECT MAX(E.GEM_EXPN_GRP_CD1) AS L_1" ).append("\n"); 
		query.append("      ,MAX(DECODE(@[sch_lang], 'K', E.KRN_ABBR_NM_1, E.ENG_ABBR_NM_1 )) AS ABBR_NM01" ).append("\n"); 
		query.append("      ,MAX(E.GEM_EXPN_GRP_CD2) AS L_2" ).append("\n"); 
		query.append("      ,MAX(DECODE(@[sch_lang], 'K', E.KRN_ABBR_NM_2, E.ENG_ABBR_NM_2 )) AS ABBR_NM02" ).append("\n"); 
		query.append("      ,F.GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,MAX(DECODE(@[sch_lang], 'K', E.KRN_ABBR_NM, E.ENG_ABBR_NM )) AS ABBR_NM" ).append("\n"); 
		query.append("      ,SUM(A.USD_ASSIGNED) AS USD_ASSIGNED" ).append("\n"); 
		query.append("      ,SUM(A.USD_ACC_PERF_AMT) AS USD_ACC_PERF_AMT" ).append("\n"); 
		query.append("      ,SUM(B.USD_ACC_PERF_AMT01) AS USD_ACC_PERF_AMT01" ).append("\n"); 
		query.append("      ,SUM(C.USD_ASSIGNED02) AS USD_ASSIGNED02" ).append("\n"); 
		query.append("      ,SUM(C.USD_ACC_PERF_AMT02) AS USD_ACC_PERF_AMT02" ).append("\n"); 
		query.append("      ,SUM(D.USD_ACC_PERF_AMT03) AS USD_ACC_PERF_AMT03" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT RSLT_YRMON" ).append("\n"); 
		query.append("              ,OFC_CD" ).append("\n"); 
		query.append("              ,GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,GEN_EXPN_INIT_AMT + GEN_EXPN_ADD_AMT + GEN_EXPN_TRNS_AMT AS USD_ASSIGNED" ).append("\n"); 
		query.append("              ,SLP_PERF_AMT AS USD_ACC_PERF_AMT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT SUBSTR(A.RSLT_YRMON, 1, 4) AS RSLT_YRMON " ).append("\n"); 
		query.append("                      ,A.OFC_CD" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                       , 'KRW', ((A.GEN_EXPN_INIT_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_INIT_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_ADD_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                       , 'KRW', ((A.GEN_EXPN_ADD_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_ADD_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_TRNS_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                       , 'KRW', ((A.GEN_EXPN_TRNS_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_TRNS_AMT    " ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                       , 'KRW', ((A.SLP_PERF_AMT*1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT)) AS SLP_PERF_AMT                                                      " ).append("\n"); 
		query.append("                  FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                      ,GEM_OFFICE B" ).append("\n"); 
		query.append("                      ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                      ,GEM_XCH_RT D" ).append("\n"); 
		query.append("                 WHERE A.RSLT_YRMON BETWEEN @[from_rslt_yrmon] AND @[to_rslt_yrmon]" ).append("\n"); 
		query.append("                   AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD <> '240601'" ).append("\n"); 
		query.append("                   AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                   AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                   AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)||'00'" ).append("\n"); 
		query.append("                   AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                   AND B.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("                   AND D.ACCT_XCH_RT_YRMON = A.RSLT_YRMON" ).append("\n"); 
		query.append("                   AND D.GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("              GROUP BY SUBSTR(A.RSLT_YRMON, 1, 4)" ).append("\n"); 
		query.append("                      ,A.OFC_CD" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT SUBSTR(A.RSLT_YRMON, 1, 4) AS RSLT_YRMON " ).append("\n"); 
		query.append("                      ,E.TIC_CD AS OFC_CD" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                       , 'KRW', ((A.GEN_EXPN_INIT_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_INIT_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_ADD_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                       , 'KRW', ((A.GEN_EXPN_ADD_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_ADD_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_TRNS_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                       , 'KRW', ((A.GEN_EXPN_TRNS_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_TRNS_AMT    " ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                       , 'KRW', ((A.SLP_PERF_AMT*1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT)) AS SLP_PERF_AMT                                                      " ).append("\n"); 
		query.append("                  FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                      ,GEM_OFFICE B" ).append("\n"); 
		query.append("                      ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                      ,GEM_XCH_RT D" ).append("\n"); 
		query.append("                      ,GEM_EXPENSE E" ).append("\n"); 
		query.append("                 WHERE A.RSLT_YRMON BETWEEN @[from_rslt_yrmon] AND @[to_rslt_yrmon]" ).append("\n"); 
		query.append("                   AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD = '240601'" ).append("\n"); 
		query.append("                   AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                   AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                   AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)||'00'" ).append("\n"); 
		query.append("                   AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                   AND B.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("                   AND D.ACCT_XCH_RT_YRMON = A.RSLT_YRMON" ).append("\n"); 
		query.append("                   AND D.GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD = E.GEN_EXPN_CD" ).append("\n"); 
		query.append("              GROUP BY SUBSTR(A.RSLT_YRMON, 1, 4)" ).append("\n"); 
		query.append("                      ,E.TIC_CD" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,(                " ).append("\n"); 
		query.append("        SELECT SUBSTR(A.RSLT_YRMON, 1, 4) AS RSLT_YRMON " ).append("\n"); 
		query.append("              ,A.OFC_CD" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'USD', (A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                               , 'KRW', ((A.SLP_PERF_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS USD_ACC_PERF_AMT01                                                      " ).append("\n"); 
		query.append("          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("              ,GEM_OFFICE B" ).append("\n"); 
		query.append("              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("         WHERE A.RSLT_YRMON BETWEEN @[from_rslt_yrmon]-'100' AND @[to_rslt_yrmon]-'100'" ).append("\n"); 
		query.append("           AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("           AND A.GEN_EXPN_CD <> '240601'" ).append("\n"); 
		query.append("           AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("           AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("           AND C.ACCT_XCH_RT_YRMON = A.RSLT_YRMON" ).append("\n"); 
		query.append("           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("      GROUP BY SUBSTR(A.RSLT_YRMON, 1, 4)" ).append("\n"); 
		query.append("              ,A.OFC_CD" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("      UNION ALL              " ).append("\n"); 
		query.append("        SELECT SUBSTR(A.RSLT_YRMON, 1, 4) AS RSLT_YRMON " ).append("\n"); 
		query.append("              ,D.TIC_CD AS OFC_CD" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'USD', (A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                               , 'KRW', ((A.SLP_PERF_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS USD_ACC_PERF_AMT01                                                      " ).append("\n"); 
		query.append("          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("              ,GEM_OFFICE B" ).append("\n"); 
		query.append("              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("              ,GEM_EXPENSE D" ).append("\n"); 
		query.append("         WHERE A.RSLT_YRMON BETWEEN @[from_rslt_yrmon]-'100' AND @[to_rslt_yrmon]-'100'" ).append("\n"); 
		query.append("           AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("           AND A.GEN_EXPN_CD = '240601'" ).append("\n"); 
		query.append("           AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("           AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("           AND C.ACCT_XCH_RT_YRMON = A.RSLT_YRMON" ).append("\n"); 
		query.append("           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("           AND A.GEN_EXPN_CD = D.GEN_EXPN_CD" ).append("\n"); 
		query.append("      GROUP BY SUBSTR(A.RSLT_YRMON, 1, 4)" ).append("\n"); 
		query.append("              ,D.TIC_CD" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT RSLT_YRMON" ).append("\n"); 
		query.append("              ,OFC_CD" ).append("\n"); 
		query.append("              ,GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,GEN_EXPN_INIT_AMT + GEN_EXPN_ADD_AMT + GEN_EXPN_TRNS_AMT AS USD_ASSIGNED02" ).append("\n"); 
		query.append("              ,SLP_PERF_AMT AS USD_ACC_PERF_AMT02" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT SUBSTR(A.RSLT_YRMON, 1, 4) AS RSLT_YRMON " ).append("\n"); 
		query.append("                      ,A.OFC_CD" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                        , 'KRW', ((A.GEN_EXPN_INIT_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_INIT_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_ADD_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                        , 'KRW', ((A.GEN_EXPN_ADD_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_ADD_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_TRNS_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                        , 'KRW', ((A.GEN_EXPN_TRNS_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_TRNS_AMT    " ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                        , 'KRW', ((A.SLP_PERF_AMT*1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT)) AS SLP_PERF_AMT                                                      " ).append("\n"); 
		query.append("                  FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                      ,GEM_OFFICE B" ).append("\n"); 
		query.append("                      ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                      ,GEM_XCH_RT D" ).append("\n"); 
		query.append("                 WHERE A.RSLT_YRMON BETWEEN SUBSTR(@[from_rslt_yrmon], 1, 4)||'01' AND @[to_rslt_yrmon]" ).append("\n"); 
		query.append("                   AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD <> '240601'" ).append("\n"); 
		query.append("                   AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                   AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                   AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)||'00'" ).append("\n"); 
		query.append("                   AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                   AND B.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("                   AND D.ACCT_XCH_RT_YRMON = A.RSLT_YRMON" ).append("\n"); 
		query.append("                   AND D.GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("              GROUP BY SUBSTR(A.RSLT_YRMON, 1, 4)" ).append("\n"); 
		query.append("                      ,A.OFC_CD" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD  " ).append("\n"); 
		query.append("               )                      " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT RSLT_YRMON" ).append("\n"); 
		query.append("              ,OFC_CD" ).append("\n"); 
		query.append("              ,GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,GEN_EXPN_INIT_AMT + GEN_EXPN_ADD_AMT + GEN_EXPN_TRNS_AMT AS USD_ASSIGNED02" ).append("\n"); 
		query.append("              ,SLP_PERF_AMT AS USD_ACC_PERF_AMT02" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT SUBSTR(A.RSLT_YRMON, 1, 4) AS RSLT_YRMON " ).append("\n"); 
		query.append("                      ,E.TIC_CD AS OFC_CD" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                        , 'KRW', ((A.GEN_EXPN_INIT_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_INIT_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_ADD_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                        , 'KRW', ((A.GEN_EXPN_ADD_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_ADD_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.GEN_EXPN_TRNS_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                        , 'KRW', ((A.GEN_EXPN_TRNS_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS GEN_EXPN_TRNS_AMT    " ).append("\n"); 
		query.append("                      ,SUM(DECODE(@[ofc_cur], 'USD', (A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                        , 'KRW', ((A.SLP_PERF_AMT*1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT)) AS SLP_PERF_AMT                                                      " ).append("\n"); 
		query.append("                  FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                      ,GEM_OFFICE B" ).append("\n"); 
		query.append("                      ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                      ,GEM_XCH_RT D" ).append("\n"); 
		query.append("                      ,GEM_EXPENSE E" ).append("\n"); 
		query.append("                 WHERE A.RSLT_YRMON BETWEEN SUBSTR(@[from_rslt_yrmon], 1, 4)||'01' AND @[to_rslt_yrmon]" ).append("\n"); 
		query.append("                   AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD = '240601'" ).append("\n"); 
		query.append("                   AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                   AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                   AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)||'00'" ).append("\n"); 
		query.append("                   AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                   AND B.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("                   AND D.ACCT_XCH_RT_YRMON = A.RSLT_YRMON" ).append("\n"); 
		query.append("                   AND D.GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD  = E.GEN_EXPN_CD" ).append("\n"); 
		query.append("              GROUP BY SUBSTR(A.RSLT_YRMON, 1, 4)" ).append("\n"); 
		query.append("                      ,E.TIC_CD" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD  " ).append("\n"); 
		query.append("               )                                       " ).append("\n"); 
		query.append("      ) C" ).append("\n"); 
		query.append("     ,(" ).append("\n"); 
		query.append("        SELECT SUBSTR(A.RSLT_YRMON, 1, 4) AS RSLT_YRMON " ).append("\n"); 
		query.append("              ,A.OFC_CD" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'USD', (A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                               , 'KRW', ((A.SLP_PERF_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS USD_ACC_PERF_AMT03                                                      " ).append("\n"); 
		query.append("          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("              ,GEM_OFFICE B" ).append("\n"); 
		query.append("              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("         WHERE A.RSLT_YRMON BETWEEN SUBSTR(@[from_rslt_yrmon]-'100', 1, 4)||'01' AND @[to_rslt_yrmon]-'100'" ).append("\n"); 
		query.append("           AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("           AND A.GEN_EXPN_CD <> '240601'" ).append("\n"); 
		query.append("           AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("           AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("           AND C.ACCT_XCH_RT_YRMON = A.RSLT_YRMON" ).append("\n"); 
		query.append("           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("      GROUP BY SUBSTR(A.RSLT_YRMON, 1, 4)" ).append("\n"); 
		query.append("              ,A.OFC_CD" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD  " ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("        SELECT SUBSTR(A.RSLT_YRMON, 1, 4) AS RSLT_YRMON " ).append("\n"); 
		query.append("              ,D.TIC_CD AS OFC_CD" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,SUM(DECODE(@[ofc_cur], 'USD', (A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                               , 'KRW', ((A.SLP_PERF_AMT*1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT)) AS USD_ACC_PERF_AMT03                                                      " ).append("\n"); 
		query.append("          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("              ,GEM_OFFICE B" ).append("\n"); 
		query.append("              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("              ,GEM_EXPENSE D" ).append("\n"); 
		query.append("         WHERE A.RSLT_YRMON BETWEEN SUBSTR(@[from_rslt_yrmon]-'100', 1, 4)||'01' AND @[to_rslt_yrmon]-'100'" ).append("\n"); 
		query.append("           AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("           AND A.GEN_EXPN_CD = '240601'" ).append("\n"); 
		query.append("           AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("           AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("           AND C.ACCT_XCH_RT_YRMON = A.RSLT_YRMON" ).append("\n"); 
		query.append("           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("           AND A.GEN_EXPN_CD = D.GEN_EXPN_CD" ).append("\n"); 
		query.append("      GROUP BY SUBSTR(A.RSLT_YRMON, 1, 4)" ).append("\n"); 
		query.append("              ,D.TIC_CD" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD      " ).append("\n"); 
		query.append("       ) D             " ).append("\n"); 
		query.append("      ,GEM_EXPN_GRP_V E" ).append("\n"); 
		query.append("      ,( " ).append("\n"); 
		query.append("         SELECT DISTINCT OFC_CD, GEN_EXPN_CD" ).append("\n"); 
		query.append("           FROM GEM_RSLT_SMRY" ).append("\n"); 
		query.append("          WHERE RSLT_YRMON BETWEEN @[from_rslt_yrmon]-'100' AND @[to_rslt_yrmon]" ).append("\n"); 
		query.append("            AND OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("       ) F" ).append("\n"); 
		query.append("WHERE F.GEN_EXPN_CD = A.GEN_EXPN_CD(+)      " ).append("\n"); 
		query.append("  AND F.GEN_EXPN_CD = B.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("  AND F.GEN_EXPN_CD = C.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("  AND F.GEN_EXPN_CD = D.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("  AND F.GEN_EXPN_CD = E.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("  AND F.OFC_CD = A.OFC_CD(+)" ).append("\n"); 
		query.append("  AND F.OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("  AND F.OFC_CD = C.OFC_CD(+)" ).append("\n"); 
		query.append("  AND F.OFC_CD = D.OFC_CD(+)" ).append("\n"); 
		query.append("  AND F.GEN_EXPN_CD BETWEEN DECODE (@[sch_expense_from], '', '111111', @[sch_expense_from]) AND DECODE (@[sch_expense_to], '', '999999', @[sch_expense_to])" ).append("\n"); 
		query.append("#if (${sch_expense_group} != '') " ).append("\n"); 
		query.append("AND E.GEM_EXPN_GRP_CD1 = @[sch_expense_group]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_tic_cd} != '')" ).append("\n"); 
		query.append("AND E.TIC_CD = @[sch_tic_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sls_ofc_div_cd} != '' || ${ofc_expn_cd} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CD IN (" ).append("\n"); 
		query.append("	SELECT OFC_CD      " ).append("\n"); 
		query.append("  	FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("	START WITH OFC_CD IN (    " ).append("\n"); 
		query.append("        SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("          FROM GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("		   #if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("           AND RGN_OFC_FLG LIKE @[sls_ofc_div_cd]||'%'" ).append("\n"); 
		query.append("		   #end		" ).append("\n"); 
		query.append("		   #if(${ofc_lvl3} != '' && ${ofc_expn_cd} != '') " ).append("\n"); 
		query.append("		   AND L_4 = @[ofc_lvl3]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} != '' && ${ofc_expn_cd} == '') " ).append("\n"); 
		query.append("		   AND L_4 = @[ofc_lvl3] " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   AND L_3 = @[ofc_lvl2] " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_lvl1} != '' && ${ofc_lvl2} == '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   AND L_2 = @[ofc_lvl1] " ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("		   #if(${ofc_lvl3} == '' && ${ofc_expn_cd} != '') " ).append("\n"); 
		query.append("		   AND L_4 = @[ofc_expn_cd]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("GROUP BY F.GEN_EXPN_CD" ).append("\n"); 
		query.append("ORDER BY L_1" ).append("\n"); 
		query.append("        ,L_2" ).append("\n"); 
		query.append("        ,F.GEN_EXPN_CD" ).append("\n"); 

	}
}