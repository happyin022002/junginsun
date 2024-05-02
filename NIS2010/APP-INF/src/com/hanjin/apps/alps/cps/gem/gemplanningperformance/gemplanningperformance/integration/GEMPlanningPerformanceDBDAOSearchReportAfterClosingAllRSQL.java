/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchReportAfterClosingAllRSQL.java
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

public class GEMPlanningPerformanceDBDAOSearchReportAfterClosingAllRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조직별 예산과 실적을 조회한다
	  * 2011.01.31 이준범[CHM-201108626-01]
	  * 요청사항 : SELPLL- >SELLIC  관련 문제 연관 해소
	  * 보완내역 : 조직 변경으로 인한 조직 코드 변경시 과거 데이터를 조회 할 수 있도록
	  *                History Table(GEM_OFC_HIS) 검색하도록 SQL 수정  
	  * 
	  * 2012.12.12 Ticket ID : CHM-201221037
	  * 설계자 : 강환, 개발자 : 원종규
	  * Title : 일부 법인 비용주관팀 로직 변경에 따른 조회(inquiry/Report) 기능 보완 요청
	  * Description : SELPLI에서 승인하는 비용항목 조회시 SELPLI의 산하 조직이 조회되도록 수정
	  * 
	  * 2014.10.23 이준범 [CHM-201432508-01]
	  * 요청사항: [GEM] 결산작업을 위한 데이터 업데이트 지원
	  * 보완: SELPLI 하드코딩 부분 삭제 
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchReportAfterClosingAllRSQL(){
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
		params.put("ofc_co",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sch_expense_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_sal",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sch_tic_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchReportAfterClosingAllRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_CD||A.GEN_EXPN_CD AS OFFICE_EXPENSE" ).append("\n"); 
		query.append("      ,DECODE(@[ofc_cur], 'LCL', B.LOCL_CURR_CD" ).append("\n"); 
		query.append("                   , 'USD', 'USD'" ).append("\n"); 
		query.append("                   , 'KRW', 'KRW' ) AS LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,DECODE(@[ofc_cur], 'LCL', B.RQST_UT_VAL" ).append("\n"); 
		query.append("                   , 'USD', 1" ).append("\n"); 
		query.append("                   , 'KRW', 1000 ) AS RQST_UT_VAL" ).append("\n"); 
		query.append("      ,SUBSTR(@[from_rslt_yrmon], 1, 4) RT_YR " ).append("\n"); 
		query.append("#if(${monthly_view} == 'Y') " ).append("\n"); 
		query.append("	  ,SUBSTR(A.RSLT_YRMON, 5, 2) RT_FM_MON " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	  ,SUBSTR(@[from_rslt_yrmon],5,2) RT_FM_MON " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("	  ,SUBSTR(@[to_rslt_yrmon],5,2) RT_TO_MON" ).append("\n"); 
		query.append("      ,A.OFC_CD" ).append("\n"); 
		query.append("#if(${sub_office_view} == 'Y')" ).append("\n"); 
		query.append("      ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,DECODE(A.OFC_CO_DIV_CD, 'O', 'HJS', 'S', 'OS', 'E', 'ETC') OFC_CO_DIV_CD   " ).append("\n"); 
		query.append("      ,( SELECT L_2 FROM GEM_OFC_LEVEL_V WHERE L_4 = A.OFC_CD ) AS LEVEL_2" ).append("\n"); 
		query.append("      ,CASE WHEN GEN_EXPN_OFC_LVL = '4' AND A.OFC_CD <> B.PRNT_OFC_CD THEN B.PRNT_OFC_CD END LEVEL_3" ).append("\n"); 
		query.append("      ,DECODE(B.RGN_OFC_FLG, 'Y',DECODE(@[sch_lang],'K','해외','FOREIGN'),DECODE(@[sch_lang],'K','국내','DOMESTIC')) AS RGN_OFC_FLG " ).append("\n"); 
		query.append("      ,C.SALY_FLG AS SLS_OFC_FLG" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,DECODE(@[sch_lang],'K',C.KRN_ABBR_NM, C.ENG_ABBR_NM) AS ABBR_NM" ).append("\n"); 
		query.append("      ,C.TIC_CD" ).append("\n"); 
		query.append("      ,DECODE(@[sch_lang],'K',C.KRN_ABBR_NM_1, C.ENG_ABBR_NM_1) AS ABBR_NM01      " ).append("\n"); 
		query.append("      ,DECODE(@[sch_lang],'K',C.KRN_ABBR_NM_2, C.ENG_ABBR_NM_2) AS ABBR_NM02" ).append("\n"); 
		query.append("      ,DECODE(@[sch_lang],'K',C.KRN_ABBR_NM_3, C.ENG_ABBR_NM_3) AS ABBR_NM03" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_INIT_AMT01 AS GEN_EXPN_INIT_AMT" ).append("\n"); 
		query.append("      ,A.PLAN_ASSN_AMT01 AS LCL_ASSIGNED" ).append("\n"); 
		query.append("      ,A.SLP_PERF_AMT01 AS SLP_PERF_AMT" ).append("\n"); 
		query.append("      ,A.USD_PLAN_INIT_AMT01 AS USD_EXPN_INIT_AMT" ).append("\n"); 
		query.append("      ,A.USD_PLAN_ASSN_AMT01 AS USD_ASSIGNED" ).append("\n"); 
		query.append("      ,A.USD_PLAN_PERF_AMT01 AS USD_PERF_AMT" ).append("\n"); 
		query.append("      ,A.USD_ACCT_INIT_AMT01 AS USD_ACC_EXPN_INIT_AMT" ).append("\n"); 
		query.append("      ,A.USD_ACCT_ASSN_AMT01 AS USD_ACC_ASSIGNED" ).append("\n"); 
		query.append("      ,A.USD_ACCT_PERF_AMT01 AS USD_ACC_PERF_AMT" ).append("\n"); 
		query.append("      ,A.LCL_RATIO01 AS RATIO_BA" ).append("\n"); 
		query.append("      ,A.USD_RATIO01 AS RATIO_FC" ).append("\n"); 
		query.append("      ,A.PLAN_USD_LOCL_XCH_RT AS USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("      ,A.ACCT_USD_LOCL_XCH_RT AS USD_ACC_LOCL_XCH_RT" ).append("\n"); 
		query.append("      ,A.SLP_PERF_AMT02 AS SLP_PERF_AMT01" ).append("\n"); 
		query.append("      ,A.USD_PLAN_PERF_AMT02 AS USD_PERF_AMT01" ).append("\n"); 
		query.append("      ,A.USD_ACCT_PERF_AMT02 AS USD_ACC_PERF_AMT01" ).append("\n"); 
		query.append("      ,A.LCL_RATIO02 AS LCL_RATIO01" ).append("\n"); 
		query.append("      ,A.USD_RATIO02 AS USD_RATIO01" ).append("\n"); 
		query.append("      ,A.SLP_PERF_AMT03 AS SLP_PERF_AMT02" ).append("\n"); 
		query.append("      ,A.USD_PLAN_PERF_AMT03 AS USD_PERF_AMT02" ).append("\n"); 
		query.append("      ,A.USD_ACCT_PERF_AMT03 AS USD_ACC_PERF_AMT02" ).append("\n"); 
		query.append("      ,A.LCL_RATIO03 AS LCL_RATIO02" ).append("\n"); 
		query.append("      ,A.USD_RATIO03 AS USD_RATIO02" ).append("\n"); 
		query.append("      ,A.SLP_PERF_AMT04 AS SLP_PERF_AMT03" ).append("\n"); 
		query.append("      ,A.USD_PLAN_PERF_AMT04 AS USD_PERF_AMT03" ).append("\n"); 
		query.append("      ,A.USD_ACCT_PERF_AMT04 AS USD_ACC_PERF_AMT03" ).append("\n"); 
		query.append("      ,A.LCL_RATIO04 AS LCL_RATIO03" ).append("\n"); 
		query.append("      ,A.USD_RATIO04 AS USD_RATIO03   " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.OFC_CD" ).append("\n"); 
		query.append("#if(${monthly_view} == 'Y')" ).append("\n"); 
		query.append("	      ,A.RSLT_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sub_office_view} == 'Y')" ).append("\n"); 
		query.append("              ,A.SUB_OFC_CD  -- SUB OFFICE VIEW 선택시 추가" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("              ,SUM(A.GEN_EXPN_INIT_AMT01) AS GEN_EXPN_INIT_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.PLAN_ASSN_AMT01) AS PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.SLP_PERF_AMT01) AS SLP_PERF_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_INIT_AMT01) AS USD_PLAN_INIT_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_ASSN_AMT01) AS USD_PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_PERF_AMT01) AS USD_PLAN_PERF_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_INIT_AMT01) AS USD_ACCT_INIT_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_ASSN_AMT01) AS USD_ACCT_ASSN_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_PERF_AMT01) AS USD_ACCT_PERF_AMT01" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.PLAN_ASSN_AMT01), 0, 0, (SUM(A.SLP_PERF_AMT01)/SUM(A.PLAN_ASSN_AMT01))*100 ) AS LCL_RATIO01" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.USD_PLAN_ASSN_AMT01), 0, 0, (SUM(A.USD_PLAN_PERF_AMT01)/SUM(A.USD_PLAN_ASSN_AMT01))*100 ) AS USD_RATIO01" ).append("\n"); 
		query.append("              ,MAX(A.PLAN_USD_LOCL_XCH_RT) AS PLAN_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("              ,MAX(A.ACCT_USD_LOCL_XCH_RT) AS ACCT_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("              ,SUM(A.SLP_PERF_AMT02) SLP_PERF_AMT02      " ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_PERF_AMT02) AS USD_PLAN_PERF_AMT02" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_PERF_AMT02) AS USD_ACCT_PERF_AMT02" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.PLAN_ASSN_AMT02), 0, 0, (SUM(A.SLP_PERF_AMT02)/SUM(A.PLAN_ASSN_AMT02))*100 ) AS LCL_RATIO02" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.USD_PLAN_ASSN_AMT02), 0, 0, (SUM(A.USD_ACCT_PERF_AMT02)/SUM(A.USD_PLAN_ASSN_AMT02))*100 ) AS USD_RATIO02   " ).append("\n"); 
		query.append("              ,SUM(A.SLP_PERF_AMT03) SLP_PERF_AMT03        " ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_PERF_AMT03) AS USD_PLAN_PERF_AMT03" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_PERF_AMT03) AS USD_ACCT_PERF_AMT03" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.PLAN_ASSN_AMT03), 0, 0, (SUM(A.SLP_PERF_AMT03)/SUM(A.PLAN_ASSN_AMT03))*100 ) AS LCL_RATIO03" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.USD_PLAN_ASSN_AMT03), 0, 0, (SUM(A.USD_ACCT_PERF_AMT03)/SUM(A.USD_PLAN_ASSN_AMT03))*100 ) AS USD_RATIO03" ).append("\n"); 
		query.append("              ,SUM(A.SLP_PERF_AMT04) SLP_PERF_AMT04" ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_PERF_AMT04) AS USD_PLAN_PERF_AMT04" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_PERF_AMT04) AS USD_ACCT_PERF_AMT04" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.PLAN_ASSN_AMT04), 0, 0, (SUM(A.SLP_PERF_AMT04)/SUM(A.PLAN_ASSN_AMT04))*100 ) AS LCL_RATIO04" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.USD_PLAN_ASSN_AMT04), 0, 0, (SUM(A.USD_ACCT_PERF_AMT04)/SUM(A.USD_PLAN_ASSN_AMT04))*100 ) AS USD_RATIO04" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A.RSLT_YRMON " ).append("\n"); 
		query.append("                      ,A.OFC_CD" ).append("\n"); 
		query.append("                      ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                      ,NVL(A.GEN_EXPN_INIT_AMT01, 0) AS GEN_EXPN_INIT_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.PLAN_ASSN_AMT01, 0) AS PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.SLP_PERF_AMT01, 0) AS SLP_PERF_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_PLAN_INIT_AMT01, 0) AS USD_PLAN_INIT_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_PLAN_ASSN_AMT01, 0) AS USD_PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_PLAN_PERF_AMT01, 0) AS USD_PLAN_PERF_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_ACCT_INIT_AMT01, 0) AS USD_ACCT_INIT_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_ACCT_ASSN_AMT01, 0) AS USD_ACCT_ASSN_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_ACCT_PERF_AMT01, 0) AS USD_ACCT_PERF_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.PLAN_USD_LOCL_XCH_RT, 0) AS PLAN_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                      ,NVL(A.ACCT_USD_LOCL_XCH_RT, 0) AS ACCT_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                      ,NVL(B.PLAN_ASSN_AMT02, 0) AS PLAN_ASSN_AMT02" ).append("\n"); 
		query.append("                      ,NVL(B.SLP_PERF_AMT02, 0) AS SLP_PERF_AMT02" ).append("\n"); 
		query.append("                      ,NVL(B.USD_PLAN_ASSN_AMT02, 0) AS USD_PLAN_ASSN_AMT02" ).append("\n"); 
		query.append("                      ,NVL(B.USD_PLAN_PERF_AMT02, 0) AS USD_PLAN_PERF_AMT02" ).append("\n"); 
		query.append("                      ,NVL(B.USD_ACCT_PERF_AMT02, 0) AS USD_ACCT_PERF_AMT02" ).append("\n"); 
		query.append("                      ,NVL(C.PLAN_ASSN_AMT03, 0) AS PLAN_ASSN_AMT03" ).append("\n"); 
		query.append("                      ,NVL(C.SLP_PERF_AMT03, 0) AS SLP_PERF_AMT03" ).append("\n"); 
		query.append("                      ,NVL(C.USD_PLAN_ASSN_AMT03, 0) AS USD_PLAN_ASSN_AMT03" ).append("\n"); 
		query.append("                      ,NVL(C.USD_PLAN_PERF_AMT03, 0) AS USD_PLAN_PERF_AMT03" ).append("\n"); 
		query.append("                      ,NVL(C.USD_ACCT_PERF_AMT03, 0) AS USD_ACCT_PERF_AMT03" ).append("\n"); 
		query.append("                      ,NVL(D.PLAN_ASSN_AMT04, 0) AS PLAN_ASSN_AMT04" ).append("\n"); 
		query.append("                      ,NVL(D.SLP_PERF_AMT04, 0) AS SLP_PERF_AMT04" ).append("\n"); 
		query.append("                      ,NVL(D.USD_PLAN_ASSN_AMT04, 0) AS USD_PLAN_ASSN_AMT04" ).append("\n"); 
		query.append("                      ,NVL(D.USD_PLAN_PERF_AMT04, 0) AS USD_PLAN_PERF_AMT04" ).append("\n"); 
		query.append("                      ,NVL(D.USD_ACCT_PERF_AMT04, 0) AS USD_ACCT_PERF_AMT04" ).append("\n"); 
		query.append("                      ,NVL(A.GEN_EXPN_INIT_AMT01, 0) + NVL(A.PLAN_ASSN_AMT01, 0) + NVL(A.SLP_PERF_AMT01, 0)" ).append("\n"); 
		query.append("                            + NVL(A.USD_PLAN_INIT_AMT01, 0) + NVL(A.USD_PLAN_ASSN_AMT01, 0) + NVL(A.USD_PLAN_PERF_AMT01, 0)" ).append("\n"); 
		query.append("                            + NVL(A.USD_ACCT_INIT_AMT01, 0) + NVL(A.USD_ACCT_ASSN_AMT01, 0) + NVL(A.USD_ACCT_PERF_AMT01, 0)" ).append("\n"); 
		query.append("                            + NVL(B.SLP_PERF_AMT02, 0) + NVL(B.USD_PLAN_PERF_AMT02, 0) + NVL(B.USD_ACCT_PERF_AMT02, 0)" ).append("\n"); 
		query.append("                            + NVL(C.SLP_PERF_AMT03, 0) + NVL(C.USD_PLAN_PERF_AMT03, 0) + NVL(C.USD_ACCT_PERF_AMT03, 0)" ).append("\n"); 
		query.append("                            + NVL(D.SLP_PERF_AMT04, 0) + NVL(D.USD_PLAN_PERF_AMT04, 0) + NVL(D.USD_ACCT_PERF_AMT04, 0) AS AMT_TOT                      " ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.RSLT_YRMON " ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD " ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.GEN_EXPN_INIT_AMT/B.RQST_UT_VAL" ).append("\n"); 
		query.append("                                           , 'USD', A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.GEN_EXPN_INIT_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS GEN_EXPN_INIT_AMT01" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/B.RQST_UT_VAL" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/B.RQST_UT_VAL" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS SLP_PERF_AMT01" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.GEN_EXPN_INIT_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_INIT_AMT01" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_PERF_AMT01     " ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.GEN_EXPN_INIT_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.GEN_EXPN_INIT_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.GEN_EXPN_INIT_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS USD_ACCT_INIT_AMT01     " ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS USD_ACCT_ASSN_AMT01   " ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS USD_ACCT_PERF_AMT01     " ).append("\n"); 
		query.append("                              ,C.USD_LOCL_XCH_RT AS PLAN_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                              ,D.USD_LOCL_XCH_RT AS ACCT_USD_LOCL_XCH_RT             " ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT A.RSLT_YRMON " ).append("\n"); 
		query.append("                                      ,A.OFC_CD" ).append("\n"); 
		query.append("                                      ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                                      ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                                      ,SUM(NVL(B.GEN_EXPN_INIT_AMT, 0)) GEN_EXPN_INIT_AMT " ).append("\n"); 
		query.append("                                      ,SUM(NVL(B.GEN_EXPN_ADD_AMT, 0)) GEN_EXPN_ADD_AMT" ).append("\n"); 
		query.append("                                      ,SUM(NVL(B.GEN_EXPN_TRNS_AMT, 0)) GEN_EXPN_TRNS_AMT" ).append("\n"); 
		query.append("                                      ,SUM(NVL(B.SLP_PERF_AMT, 0)) SLP_PERF_AMT" ).append("\n"); 
		query.append("                                  FROM ( " ).append("\n"); 
		query.append("                                        SELECT SUBSTR(@[from_rslt_yrmon],1,4)||B.MM RSLT_YRMON" ).append("\n"); 
		query.append("                                              ,A.OFC_CD" ).append("\n"); 
		query.append("                                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                                              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                                              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                                          FROM ( " ).append("\n"); 
		query.append("                                                SELECT DISTINCT OFC_CD, SUB_OFC_CD, GEN_EXPN_CD, OFC_CO_DIV_CD " ).append("\n"); 
		query.append("                                                  FROM GEM_RSLT_SMRY" ).append("\n"); 
		query.append("                                                 WHERE RSLT_YRMON BETWEEN TO_CHAR(@[from_rslt_yrmon]-'300'||'01') AND SUBSTR(@[to_rslt_yrmon], 1, 4)||'12'" ).append("\n"); 
		query.append("                                               ) A" ).append("\n"); 
		query.append("                                              ,( " ).append("\n"); 
		query.append("                                                SELECT TRIM(TO_CHAR(ROWNUM, '00')) MM " ).append("\n"); 
		query.append("                                                  FROM DUAL CONNECT BY LEVEL <= 12 " ).append("\n"); 
		query.append("                                               ) B    " ).append("\n"); 
		query.append("                                       ) A" ).append("\n"); 
		query.append("                                      ,GEM_RSLT_SMRY B" ).append("\n"); 
		query.append("                                 WHERE A.RSLT_YRMON  = B.RSLT_YRMON(+)" ).append("\n"); 
		query.append("                                   AND A.OFC_CD      = B.OFC_CD(+)" ).append("\n"); 
		query.append("                                   AND A.SUB_OFC_CD  = B.SUB_OFC_CD(+)" ).append("\n"); 
		query.append("                                   AND A.GEN_EXPN_CD = B.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("                                   AND A.OFC_CO_DIV_CD = B.OFC_CO_DIV_CD(+)  " ).append("\n"); 
		query.append("                              GROUP BY A.RSLT_YRMON " ).append("\n"); 
		query.append("                                      ,A.OFC_CD" ).append("\n"); 
		query.append("                                      ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                                      ,A.OFC_CO_DIV_CD                          " ).append("\n"); 
		query.append("                               ) A" ).append("\n"); 
		query.append("                              ,GEM_OFFICE B" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                              ,(" ).append("\n"); 
		query.append("                                SELECT A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                                      ,A.CURR_CD" ).append("\n"); 
		query.append("                                      ,B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                      ,B.LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("                                      ,B.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                        SELECT B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                                              ,A.CURR_CD" ).append("\n"); 
		query.append("                                          FROM (" ).append("\n"); 
		query.append("                                                SELECT DISTINCT CURR_CD" ).append("\n"); 
		query.append("                                                  FROM GEM_XCH_RT" ).append("\n"); 
		query.append("                                                 WHERE ACCT_XCH_RT_YRMON LIKE SUBSTR(@[from_rslt_yrmon], 1, 4)||'%'" ).append("\n"); 
		query.append("                                               ) A" ).append("\n"); 
		query.append("                                              ,(" ).append("\n"); 
		query.append("                                                SELECT SUBSTR(@[from_rslt_yrmon], 1, 4)||TRIM(TO_CHAR(ROWNUM, '00')) ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                                                  FROM DUAL CONNECT BY LEVEL <= 12" ).append("\n"); 
		query.append("                                               ) B" ).append("\n"); 
		query.append("                                       ) A" ).append("\n"); 
		query.append("                                      ,GEM_XCH_RT B" ).append("\n"); 
		query.append("                                 WHERE A.ACCT_XCH_RT_YRMON = B.ACCT_XCH_RT_YRMON(+)" ).append("\n"); 
		query.append("                                   AND A.CURR_CD = B.CURR_CD(+)" ).append("\n"); 
		query.append("                                   AND B.GEN_EXPN_XCH_RT_DIV_CD(+) = 'M'" ).append("\n"); 
		query.append("                               ) D" ).append("\n"); 
		query.append("                         WHERE A.RSLT_YRMON BETWEEN @[from_rslt_yrmon] AND @[to_rslt_yrmon]" ).append("\n"); 
		query.append("                           AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD  = C.CURR_CD" ).append("\n"); 
		query.append("                           AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)||'00' " ).append("\n"); 
		query.append("                           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I' " ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD  = D.CURR_CD" ).append("\n"); 
		query.append("                           AND A.RSLT_YRMON    = D.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("#if(${expn_dep} == 'FAC')                           " ).append("\n"); 
		query.append("                           AND 1 = DECODE(A.GEN_EXPN_CD, '240601', DECODE(A.OFC_CO_DIV_CD, 'O', 0 , 1 ) , 1 )  -- Depreciation (240601) : Divide 선택시 제외     " ).append("\n"); 
		query.append("#end                                          " ).append("\n"); 
		query.append("                       ) A    " ).append("\n"); 
		query.append("                      ,( " ).append("\n"); 
		query.append("                        SELECT SUBSTR(@[from_rslt_yrmon], 1, 4)||SUBSTR(A.RSLT_YRMON , 5,2) RSLT_YRMON" ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD " ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/B.RQST_UT_VAL" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) AS PLAN_ASSN_AMT02" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/B.RQST_UT_VAL" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT )) AS SLP_PERF_AMT02" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) AS USD_PLAN_ASSN_AMT02" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) AS USD_PLAN_PERF_AMT02" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT )) AS USD_ACCT_PERF_AMT02" ).append("\n"); 
		query.append("                          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                              ,GEM_OFFICE B" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT D   " ).append("\n"); 
		query.append("                         WHERE A.RSLT_YRMON BETWEEN TO_CHAR(@[from_rslt_yrmon]-'100') AND TO_CHAR(@[to_rslt_yrmon]-'100')" ).append("\n"); 
		query.append("                           AND A.OFC_CD = B.OFC_CD " ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                           AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)-'1'||'00'  " ).append("\n"); 
		query.append("                           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("                           AND A.RSLT_YRMON = D.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                           AND D.GEN_EXPN_XCH_RT_DIV_CD = 'M'" ).append("\n"); 
		query.append("#if(${expn_dep} == 'FAC')                           " ).append("\n"); 
		query.append("                           AND 1 = DECODE(A.GEN_EXPN_CD, '240601', DECODE(A.OFC_CO_DIV_CD, 'O', 0 , 1 ) , 1 )  -- Depreciation (240601) : Divide 선택시 제외   " ).append("\n"); 
		query.append("#end                " ).append("\n"); 
		query.append("                      GROUP BY SUBSTR(@[from_rslt_yrmon], 1, 4)||SUBSTR(A.RSLT_YRMON , 5,2) " ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD " ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD           " ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                      ,( " ).append("\n"); 
		query.append("                        SELECT SUBSTR(@[from_rslt_yrmon], 1, 4)||SUBSTR(A.RSLT_YRMON , 5,2) RSLT_YRMON" ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/B.RQST_UT_VAL" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) AS PLAN_ASSN_AMT03" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/B.RQST_UT_VAL" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT )) AS SLP_PERF_AMT03" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) AS USD_PLAN_ASSN_AMT03" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) AS USD_PLAN_PERF_AMT03" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT )) AS USD_ACCT_PERF_AMT03" ).append("\n"); 
		query.append("                          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                              ,GEM_OFFICE B" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT D   " ).append("\n"); 
		query.append("                         WHERE A.RSLT_YRMON BETWEEN TO_CHAR(@[from_rslt_yrmon]-'200') AND TO_CHAR(@[to_rslt_yrmon]-'200')" ).append("\n"); 
		query.append("                           AND A.OFC_CD = B.OFC_CD " ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                           AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)-'2'||'00'  " ).append("\n"); 
		query.append("                           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("                           AND A.RSLT_YRMON = D.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                           AND D.GEN_EXPN_XCH_RT_DIV_CD = 'M'" ).append("\n"); 
		query.append("#if(${expn_dep} == 'FAC')                           " ).append("\n"); 
		query.append("                           AND 1 = DECODE(A.GEN_EXPN_CD, '240601', DECODE(A.OFC_CO_DIV_CD, 'O', 0 , 1 ) , 1 )  -- Depreciation (240601) : Divide 선택시 제외   " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("                      GROUP BY SUBSTR(@[from_rslt_yrmon], 1, 4)||SUBSTR(A.RSLT_YRMON , 5,2) " ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD " ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD                          " ).append("\n"); 
		query.append("                       ) C" ).append("\n"); 
		query.append("                      ,( " ).append("\n"); 
		query.append("                        SELECT SUBSTR(@[from_rslt_yrmon], 1, 4)||SUBSTR(A.RSLT_YRMON , 5,2) RSLT_YRMON" ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/B.RQST_UT_VAL" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) AS PLAN_ASSN_AMT04" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/B.RQST_UT_VAL" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT )) AS SLP_PERF_AMT04" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) AS USD_PLAN_ASSN_AMT04" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) AS USD_PLAN_PERF_AMT04" ).append("\n"); 
		query.append("                              ,SUM(DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT )) AS USD_ACCT_PERF_AMT04" ).append("\n"); 
		query.append("                          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                              ,GEM_OFFICE B" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT D   " ).append("\n"); 
		query.append("                         WHERE A.RSLT_YRMON BETWEEN TO_CHAR(@[from_rslt_yrmon]-'300') AND TO_CHAR(@[to_rslt_yrmon]-'300')" ).append("\n"); 
		query.append("                           AND A.OFC_CD = B.OFC_CD " ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                           AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)-'3'||'00'  " ).append("\n"); 
		query.append("                           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("                           AND A.RSLT_YRMON = D.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                           AND D.GEN_EXPN_XCH_RT_DIV_CD = 'M'" ).append("\n"); 
		query.append("#if(${expn_dep} == 'FAC')" ).append("\n"); 
		query.append("                           AND 1 = DECODE(A.GEN_EXPN_CD, '240601', DECODE(A.OFC_CO_DIV_CD, 'O', 0 , 1 ) , 1 )  -- Depreciation (240601) : Divide 선택시 제외   " ).append("\n"); 
		query.append("#end                    " ).append("\n"); 
		query.append("                      GROUP BY SUBSTR(@[from_rslt_yrmon], 1, 4)||SUBSTR(A.RSLT_YRMON , 5,2) " ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD " ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD        " ).append("\n"); 
		query.append("                      ) D" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.RSLT_YRMON  = B.RSLT_YRMON(+)" ).append("\n"); 
		query.append("                   AND A.OFC_CD      = B.OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.SUB_OFC_CD  = B.SUB_OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD = B.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("                   AND A.OFC_CO_DIV_CD = B.OFC_CO_DIV_CD(+)" ).append("\n"); 
		query.append("                   AND A.RSLT_YRMON  = C.RSLT_YRMON(+)" ).append("\n"); 
		query.append("                   AND A.OFC_CD      = C.OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.SUB_OFC_CD  = C.SUB_OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD = C.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("                   AND A.OFC_CO_DIV_CD = C.OFC_CO_DIV_CD(+)" ).append("\n"); 
		query.append("                   AND A.RSLT_YRMON  = D.RSLT_YRMON(+)" ).append("\n"); 
		query.append("                   AND A.OFC_CD      = D.OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.SUB_OFC_CD  = D.SUB_OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD = D.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("                   AND A.OFC_CO_DIV_CD = D.OFC_CO_DIV_CD(+)" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("              ,GEM_EXPENSE B " ).append("\n"); 
		query.append("         WHERE A.GEN_EXPN_CD = B.GEN_EXPN_CD     " ).append("\n"); 
		query.append("           AND A.AMT_TOT <> 0 " ).append("\n"); 
		query.append("#if(${auth_flg} == 'YNYN')           " ).append("\n"); 
		query.append("           AND ( A.OFC_CD IN (SELECT OFC_CD      " ).append("\n"); 
		query.append("                                FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                          START WITH OFC_CD IN (@[login_office])" ).append("\n"); 
		query.append("                    CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) " ).append("\n"); 
		query.append("                OR B.TIC_CD = @[login_office] )" ).append("\n"); 
		query.append("#elseif(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("           AND ( A.OFC_CD IN ( SELECT OFC_CD      " ).append("\n"); 
		query.append("                                 FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                           START WITH OFC_CD IN ( SELECT L_4 " ).append("\n"); 
		query.append("                                                    FROM GEM_OFC_LEVEL_V " ).append("\n"); 
		query.append("                                                   WHERE L_3 = @[login_office] )" ).append("\n"); 
		query.append("                     CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) OR B.TIC_CD = @[login_office] )    " ).append("\n"); 
		query.append("#end                                      " ).append("\n"); 
		query.append("      GROUP BY A.OFC_CD" ).append("\n"); 
		query.append("#if(${monthly_view} == 'Y')      " ).append("\n"); 
		query.append("              ,A.RSLT_YRMON" ).append("\n"); 
		query.append("#end              " ).append("\n"); 
		query.append("#if(${sub_office_view} == 'Y')              " ).append("\n"); 
		query.append("              ,A.SUB_OFC_CD  -- SUB OFFICE VIEW 선택시 추가" ).append("\n"); 
		query.append("#end              " ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,A.OFC_CO_DIV_CD  " ).append("\n"); 
		query.append("#if(${expn_dep} == 'FAC')                  " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT B.TIC_CD AS OFC_CD" ).append("\n"); 
		query.append("#if(${monthly_view} == 'Y')" ).append("\n"); 
		query.append("	      ,A.RSLT_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sub_office_view} == 'Y')              " ).append("\n"); 
		query.append("              ,B.TIC_CD AS SUB_OFC_CD  " ).append("\n"); 
		query.append("#end              " ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,A.OFC_CO_DIV_CD      " ).append("\n"); 
		query.append("              ,SUM(A.GEN_EXPN_INIT_AMT01) AS GEN_EXPN_INIT_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.PLAN_ASSN_AMT01) AS PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.SLP_PERF_AMT01) AS SLP_PERF_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_INIT_AMT01) AS USD_PLAN_INIT_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_ASSN_AMT01) AS USD_PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_PERF_AMT01) AS USD_PLAN_PERF_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_INIT_AMT01) AS USD_ACCT_INIT_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_ASSN_AMT01) AS USD_ACCT_ASSN_AMT01" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_PERF_AMT01) AS USD_ACCT_PERF_AMT01" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.PLAN_ASSN_AMT01), 0, 0, (SUM(A.SLP_PERF_AMT01)/SUM(A.PLAN_ASSN_AMT01))*100 ) AS LCL_RATIO01" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.USD_PLAN_ASSN_AMT01), 0, 0, (SUM(A.USD_PLAN_PERF_AMT01)/SUM(A.USD_PLAN_ASSN_AMT01))*100 ) AS USD_RATIO01" ).append("\n"); 
		query.append("              ,MAX(A.PLAN_USD_LOCL_XCH_RT) AS PLAN_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("              ,MAX(A.ACCT_USD_LOCL_XCH_RT) AS ACCT_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("              ,SUM(A.SLP_PERF_AMT02) SLP_PERF_AMT02      " ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_PERF_AMT02) AS USD_PLAN_PERF_AMT02" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_PERF_AMT02) AS USD_ACCT_PERF_AMT02" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.PLAN_ASSN_AMT02), 0, 0, (SUM(A.SLP_PERF_AMT02)/SUM(A.PLAN_ASSN_AMT02))*100 ) AS LCL_RATIO02" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.USD_PLAN_ASSN_AMT02), 0, 0, (SUM(A.USD_ACCT_PERF_AMT02)/SUM(A.USD_PLAN_ASSN_AMT02))*100 ) AS USD_RATIO02   " ).append("\n"); 
		query.append("              ,SUM(A.SLP_PERF_AMT03) SLP_PERF_AMT03        " ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_PERF_AMT03) AS USD_PLAN_PERF_AMT03" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_PERF_AMT03) AS USD_ACCT_PERF_AMT03" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.PLAN_ASSN_AMT03), 0, 0, (SUM(A.SLP_PERF_AMT03)/SUM(A.PLAN_ASSN_AMT03))*100 ) AS LCL_RATIO03" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.USD_PLAN_ASSN_AMT03), 0, 0, (SUM(A.USD_ACCT_PERF_AMT03)/SUM(A.USD_PLAN_ASSN_AMT03))*100 ) AS USD_RATIO03" ).append("\n"); 
		query.append("              ,SUM(A.SLP_PERF_AMT04) SLP_PERF_AMT04" ).append("\n"); 
		query.append("              ,SUM(A.USD_PLAN_PERF_AMT04) AS USD_PLAN_PERF_AMT04" ).append("\n"); 
		query.append("              ,SUM(A.USD_ACCT_PERF_AMT04) AS USD_ACCT_PERF_AMT04" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.PLAN_ASSN_AMT04), 0, 0, (SUM(A.SLP_PERF_AMT04)/SUM(A.PLAN_ASSN_AMT04))*100 ) AS LCL_RATIO04" ).append("\n"); 
		query.append("              ,DECODE(SUM(A.USD_PLAN_ASSN_AMT04), 0, 0, (SUM(A.USD_ACCT_PERF_AMT04)/SUM(A.USD_PLAN_ASSN_AMT04))*100 ) AS USD_RATIO04" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A.RSLT_YRMON" ).append("\n"); 
		query.append("                      ,A.OFC_CD" ).append("\n"); 
		query.append("                      ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,NVL(A.OFC_CO_DIV_CD, 'O') AS OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                      ,NVL(A.GEN_EXPN_INIT_AMT01, 0) AS GEN_EXPN_INIT_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.PLAN_ASSN_AMT01, 0) AS PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.SLP_PERF_AMT01, 0) AS SLP_PERF_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_PLAN_INIT_AMT01, 0) AS USD_PLAN_INIT_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_PLAN_ASSN_AMT01, 0) AS USD_PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_PLAN_PERF_AMT01, 0) AS USD_PLAN_PERF_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_ACCT_INIT_AMT01, 0) AS USD_ACCT_INIT_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_ACCT_ASSN_AMT01, 0) AS USD_ACCT_ASSN_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.USD_ACCT_PERF_AMT01, 0) AS USD_ACCT_PERF_AMT01" ).append("\n"); 
		query.append("                      ,NVL(A.PLAN_USD_LOCL_XCH_RT, 0) AS PLAN_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                      ,NVL(A.ACCT_USD_LOCL_XCH_RT, 0) AS ACCT_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                      ,NVL(B.PLAN_ASSN_AMT02, 0) AS PLAN_ASSN_AMT02" ).append("\n"); 
		query.append("                      ,NVL(B.SLP_PERF_AMT02, 0) AS SLP_PERF_AMT02" ).append("\n"); 
		query.append("                      ,NVL(B.USD_PLAN_ASSN_AMT02, 0) AS USD_PLAN_ASSN_AMT02" ).append("\n"); 
		query.append("                      ,NVL(B.USD_PLAN_PERF_AMT02, 0) AS USD_PLAN_PERF_AMT02" ).append("\n"); 
		query.append("                      ,NVL(B.USD_ACCT_PERF_AMT02, 0) AS USD_ACCT_PERF_AMT02" ).append("\n"); 
		query.append("                      ,NVL(C.PLAN_ASSN_AMT03, 0) AS PLAN_ASSN_AMT03" ).append("\n"); 
		query.append("                      ,NVL(C.SLP_PERF_AMT03, 0) AS SLP_PERF_AMT03" ).append("\n"); 
		query.append("                      ,NVL(C.USD_PLAN_ASSN_AMT03, 0) AS USD_PLAN_ASSN_AMT03" ).append("\n"); 
		query.append("                      ,NVL(C.USD_PLAN_PERF_AMT03, 0) AS USD_PLAN_PERF_AMT03" ).append("\n"); 
		query.append("                      ,NVL(C.USD_ACCT_PERF_AMT03, 0) AS USD_ACCT_PERF_AMT03" ).append("\n"); 
		query.append("                      ,NVL(D.PLAN_ASSN_AMT04, 0) AS PLAN_ASSN_AMT04" ).append("\n"); 
		query.append("                      ,NVL(D.SLP_PERF_AMT04, 0) AS SLP_PERF_AMT04" ).append("\n"); 
		query.append("                      ,NVL(D.USD_PLAN_ASSN_AMT04, 0) AS USD_PLAN_ASSN_AMT04" ).append("\n"); 
		query.append("                      ,NVL(D.USD_PLAN_PERF_AMT04, 0) AS USD_PLAN_PERF_AMT04" ).append("\n"); 
		query.append("                      ,NVL(D.USD_ACCT_PERF_AMT04, 0) AS USD_ACCT_PERF_AMT04" ).append("\n"); 
		query.append("                      ,NVL(A.GEN_EXPN_INIT_AMT01, 0) + NVL(A.PLAN_ASSN_AMT01, 0) + NVL(A.SLP_PERF_AMT01, 0)" ).append("\n"); 
		query.append("                            + NVL(A.USD_PLAN_INIT_AMT01, 0) + NVL(A.USD_PLAN_ASSN_AMT01, 0) + NVL(A.USD_PLAN_PERF_AMT01, 0)" ).append("\n"); 
		query.append("                            + NVL(A.USD_ACCT_INIT_AMT01, 0) + NVL(A.USD_ACCT_ASSN_AMT01, 0) + NVL(A.USD_ACCT_PERF_AMT01, 0)" ).append("\n"); 
		query.append("                            + NVL(B.SLP_PERF_AMT02, 0) + NVL(B.USD_PLAN_PERF_AMT02, 0) + NVL(B.USD_ACCT_PERF_AMT02, 0)" ).append("\n"); 
		query.append("                            + NVL(C.SLP_PERF_AMT03, 0) + NVL(C.USD_PLAN_PERF_AMT03, 0) + NVL(C.USD_ACCT_PERF_AMT03, 0)" ).append("\n"); 
		query.append("                            + NVL(D.SLP_PERF_AMT04, 0) + NVL(D.USD_PLAN_PERF_AMT04, 0) + NVL(D.USD_ACCT_PERF_AMT04, 0) AS AMT_TOT" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.RSLT_YRMON " ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', ((A.GEN_EXPN_INIT_AMT/B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.GEN_EXPN_INIT_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS GEN_EXPN_INIT_AMT01" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', ((A.SLP_PERF_AMT/B.RQST_UT_VAL)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS SLP_PERF_AMT01" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.GEN_EXPN_INIT_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_INIT_AMT01                                   " ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_ASSN_AMT01" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_PERF_AMT01     " ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.GEN_EXPN_INIT_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.GEN_EXPN_INIT_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.GEN_EXPN_INIT_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS USD_ACCT_INIT_AMT01     " ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS USD_ACCT_ASSN_AMT01   " ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS USD_ACCT_PERF_AMT01" ).append("\n"); 
		query.append("                              ,C.USD_LOCL_XCH_RT AS PLAN_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                              ,D.USD_LOCL_XCH_RT AS ACCT_USD_LOCL_XCH_RT             " ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT A.RSLT_YRMON " ).append("\n"); 
		query.append("                                      ,A.OFC_CD" ).append("\n"); 
		query.append("                                      ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                                      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                                      ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                                      ,NVL(B.GEN_EXPN_INIT_AMT, 0) GEN_EXPN_INIT_AMT " ).append("\n"); 
		query.append("                                      ,NVL(B.GEN_EXPN_ADD_AMT, 0) GEN_EXPN_ADD_AMT" ).append("\n"); 
		query.append("                                      ,NVL(B.GEN_EXPN_TRNS_AMT, 0) GEN_EXPN_TRNS_AMT" ).append("\n"); 
		query.append("                                      ,NVL(B.SLP_PERF_AMT, 0) SLP_PERF_AMT" ).append("\n"); 
		query.append("                                  FROM ( " ).append("\n"); 
		query.append("                                        SELECT SUBSTR(@[from_rslt_yrmon],1,4)||B.MM RSLT_YRMON" ).append("\n"); 
		query.append("                                              ,A.OFC_CD" ).append("\n"); 
		query.append("                                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                                              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                                              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                                          FROM ( " ).append("\n"); 
		query.append("                                                SELECT DISTINCT OFC_CD, SUB_OFC_CD, GEN_EXPN_CD, OFC_CO_DIV_CD " ).append("\n"); 
		query.append("                                                  FROM GEM_RSLT_SMRY" ).append("\n"); 
		query.append("                                                 WHERE RSLT_YRMON BETWEEN TO_CHAR(@[from_rslt_yrmon]-'300')||'01' AND SUBSTR(@[to_rslt_yrmon], 1, 4)||'12'" ).append("\n"); 
		query.append("                                                   AND GEN_EXPN_CD = '240601'" ).append("\n"); 
		query.append("                                                   AND OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("                                               ) A" ).append("\n"); 
		query.append("                                              ,( " ).append("\n"); 
		query.append("                                                SELECT TRIM(TO_CHAR(ROWNUM, '00')) MM " ).append("\n"); 
		query.append("                                                  FROM DUAL CONNECT BY LEVEL <= 12 " ).append("\n"); 
		query.append("                                               ) B    " ).append("\n"); 
		query.append("                                       ) A" ).append("\n"); 
		query.append("                                      ,GEM_RSLT_SMRY B" ).append("\n"); 
		query.append("                                 WHERE A.RSLT_YRMON  = B.RSLT_YRMON(+)" ).append("\n"); 
		query.append("                                   AND A.OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("                                   AND A.SUB_OFC_CD = B.SUB_OFC_CD(+)" ).append("\n"); 
		query.append("                                   AND A.GEN_EXPN_CD = B.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("                                   AND A.OFC_CO_DIV_CD  = B.OFC_CO_DIV_CD(+)" ).append("\n"); 
		query.append("                               ) A" ).append("\n"); 
		query.append("                              ,GEM_OFFICE B" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                              ,(" ).append("\n"); 
		query.append("                                SELECT A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                                      ,A.CURR_CD" ).append("\n"); 
		query.append("                                      ,B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                      ,B.LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("                                      ,B.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                        SELECT B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                                              ,A.CURR_CD" ).append("\n"); 
		query.append("                                          FROM (" ).append("\n"); 
		query.append("                                                SELECT DISTINCT CURR_CD" ).append("\n"); 
		query.append("                                                  FROM GEM_XCH_RT" ).append("\n"); 
		query.append("                                                 WHERE ACCT_XCH_RT_YRMON LIKE SUBSTR(@[from_rslt_yrmon], 1, 4)||'%'" ).append("\n"); 
		query.append("                                               ) A" ).append("\n"); 
		query.append("                                              ,(" ).append("\n"); 
		query.append("                                                SELECT SUBSTR(@[from_rslt_yrmon], 1, 4)||TRIM(TO_CHAR(ROWNUM, '00')) ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                                                  FROM DUAL CONNECT BY LEVEL <= 12" ).append("\n"); 
		query.append("                                               ) B" ).append("\n"); 
		query.append("                                       ) A" ).append("\n"); 
		query.append("                                      ,GEM_XCH_RT B" ).append("\n"); 
		query.append("                                 WHERE A.ACCT_XCH_RT_YRMON = B.ACCT_XCH_RT_YRMON(+)" ).append("\n"); 
		query.append("                                   AND A.CURR_CD = B.CURR_CD(+)" ).append("\n"); 
		query.append("                                   AND B.GEN_EXPN_XCH_RT_DIV_CD(+) = 'M'" ).append("\n"); 
		query.append("                               ) D" ).append("\n"); 
		query.append("                         WHERE A.RSLT_YRMON BETWEEN @[from_rslt_yrmon] AND @[to_rslt_yrmon]" ).append("\n"); 
		query.append("                           AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD  = C.CURR_CD" ).append("\n"); 
		query.append("                           AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)||'00' " ).append("\n"); 
		query.append("                           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I' " ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD  = D.CURR_CD" ).append("\n"); 
		query.append("                           AND A.RSLT_YRMON    = D.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                       ) A    " ).append("\n"); 
		query.append("                      ,( " ).append("\n"); 
		query.append("                        SELECT SUBSTR(@[from_rslt_yrmon], 1, 4)||SUBSTR(A.RSLT_YRMON , 5,2) RSLT_YRMON" ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD " ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS PLAN_ASSN_AMT02" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', ((A.SLP_PERF_AMT/B.RQST_UT_VAL)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS SLP_PERF_AMT02" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_ASSN_AMT02" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_PERF_AMT02" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS USD_ACCT_PERF_AMT02" ).append("\n"); 
		query.append("                          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                              ,GEM_OFFICE B" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT D   " ).append("\n"); 
		query.append("                         WHERE A.RSLT_YRMON BETWEEN TO_CHAR(@[from_rslt_yrmon]-'100') AND TO_CHAR(@[to_rslt_yrmon]-'100')" ).append("\n"); 
		query.append("                           AND A.GEN_EXPN_CD = '240601'" ).append("\n"); 
		query.append("                           AND A.OFC_CO_DIV_CD = 'O'" ).append("\n"); 
		query.append("                           AND A.OFC_CD = B.OFC_CD " ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                           AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)-'1'||'00'  " ).append("\n"); 
		query.append("                           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("                           AND A.RSLT_YRMON = D.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                           AND D.GEN_EXPN_XCH_RT_DIV_CD = 'M'" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                      ,( " ).append("\n"); 
		query.append("                        SELECT SUBSTR(@[from_rslt_yrmon], 1, 4)||SUBSTR(A.RSLT_YRMON , 5,2) RSLT_YRMON" ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS PLAN_ASSN_AMT03" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', ((A.SLP_PERF_AMT/B.RQST_UT_VAL)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS SLP_PERF_AMT03" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_ASSN_AMT03" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_PERF_AMT03" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS USD_ACCT_PERF_AMT03" ).append("\n"); 
		query.append("                          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                              ,GEM_OFFICE B" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT D   " ).append("\n"); 
		query.append("                         WHERE A.RSLT_YRMON BETWEEN TO_CHAR(@[from_rslt_yrmon]-'200') AND TO_CHAR(@[to_rslt_yrmon]-'200')" ).append("\n"); 
		query.append("                           AND A.GEN_EXPN_CD = '240601'" ).append("\n"); 
		query.append("                           AND A.OFC_CO_DIV_CD = 'O'                 " ).append("\n"); 
		query.append("                           AND A.OFC_CD = B.OFC_CD " ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                           AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)-'2'||'00'  " ).append("\n"); 
		query.append("                           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("                           AND A.RSLT_YRMON = D.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                           AND D.GEN_EXPN_XCH_RT_DIV_CD = 'M'" ).append("\n"); 
		query.append("                       ) C" ).append("\n"); 
		query.append("                      ,( " ).append("\n"); 
		query.append("                        SELECT SUBSTR(@[from_rslt_yrmon], 1, 4)||SUBSTR(A.RSLT_YRMON , 5,2) RSLT_YRMON" ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.SUB_OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD " ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD                     " ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS PLAN_ASSN_AMT04" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', ((A.SLP_PERF_AMT/B.RQST_UT_VAL)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS SLP_PERF_AMT04" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', (A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', (((A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_ASSN_AMT04" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT ) AS USD_PLAN_PERF_AMT04" ).append("\n"); 
		query.append("                              ,DECODE(@[ofc_cur], 'LCL', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'USD', A.SLP_PERF_AMT/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                           , 'KRW', ((A.SLP_PERF_AMT/1000)/D.USD_LOCL_XCH_RT)*D.USD_KRW_XCH_RT ) AS USD_ACCT_PERF_AMT04" ).append("\n"); 
		query.append("                          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                              ,GEM_OFFICE B" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT D   " ).append("\n"); 
		query.append("                         WHERE A.RSLT_YRMON BETWEEN TO_CHAR(@[from_rslt_yrmon]-'300') AND TO_CHAR(@[to_rslt_yrmon]-'300')" ).append("\n"); 
		query.append("                           AND A.GEN_EXPN_CD = '240601'" ).append("\n"); 
		query.append("                           AND A.OFC_CO_DIV_CD = 'O'                 " ).append("\n"); 
		query.append("                           AND A.OFC_CD = B.OFC_CD " ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                           AND C.ACCT_XCH_RT_YRMON = SUBSTR(@[from_rslt_yrmon], 1, 4)-'3'||'00'  " ).append("\n"); 
		query.append("                           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                           AND B.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("                           AND A.RSLT_YRMON = D.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                           AND D.GEN_EXPN_XCH_RT_DIV_CD = 'M'                      " ).append("\n"); 
		query.append("                      ) D" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.RSLT_YRMON  = B.RSLT_YRMON(+)" ).append("\n"); 
		query.append("                   AND A.OFC_CD      = B.OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.SUB_OFC_CD  = B.SUB_OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD = B.GEN_EXPN_CD(+)           " ).append("\n"); 
		query.append("                   AND A.RSLT_YRMON  = C.RSLT_YRMON(+)" ).append("\n"); 
		query.append("                   AND A.OFC_CD      = C.OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.SUB_OFC_CD  = C.SUB_OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD = C.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("                   AND A.RSLT_YRMON  = D.RSLT_YRMON(+)" ).append("\n"); 
		query.append("                   AND A.OFC_CD      = D.OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.SUB_OFC_CD  = D.SUB_OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD = D.GEN_EXPN_CD(+)           " ).append("\n"); 
		query.append("               ) A " ).append("\n"); 
		query.append("              ,GEM_EXPENSE B " ).append("\n"); 
		query.append("         WHERE A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("           AND A.AMT_TOT <> 0" ).append("\n"); 
		query.append("#if(${auth_flg} == 'YNYN')           " ).append("\n"); 
		query.append("           AND ( A.OFC_CD IN (SELECT OFC_CD      " ).append("\n"); 
		query.append("                                FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                          START WITH OFC_CD IN (@[login_office])" ).append("\n"); 
		query.append("                    CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) " ).append("\n"); 
		query.append("                OR B.TIC_CD = @[login_office] )" ).append("\n"); 
		query.append("#elseif(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("           AND ( A.OFC_CD IN ( SELECT OFC_CD      " ).append("\n"); 
		query.append("                                 FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                           START WITH OFC_CD IN ( SELECT L_4 " ).append("\n"); 
		query.append("                                                    FROM GEM_OFC_LEVEL_V " ).append("\n"); 
		query.append("                                                   WHERE L_3 = @[login_office] )" ).append("\n"); 
		query.append("                     CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) OR B.TIC_CD = @[login_office] )    " ).append("\n"); 
		query.append("#end                     " ).append("\n"); 
		query.append("      GROUP BY B.TIC_CD " ).append("\n"); 
		query.append("#if(${monthly_view} == 'Y')      " ).append("\n"); 
		query.append("              ,A.RSLT_YRMON  " ).append("\n"); 
		query.append("#end                          " ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,A.OFC_CO_DIV_CD " ).append("\n"); 
		query.append("#end              " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,GEM_OFFICE B" ).append("\n"); 
		query.append("      ,GEM_EXPN_GRP_V C " ).append("\n"); 
		query.append(" WHERE A.OFC_CD = B.OFC_CD(+)  " ).append("\n"); 
		query.append("   AND A.GEN_EXPN_CD = C.GEN_EXPN_CD(+) " ).append("\n"); 
		query.append("   AND A.GEN_EXPN_CD BETWEEN DECODE (@[sch_expense_from], '', '111111', @[sch_expense_from]) AND DECODE (@[sch_expense_to], '', '999999', @[sch_expense_to]) -- Expense 조건" ).append("\n"); 
		query.append("#if(${ofc_co} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CO_DIV_CD = @[ofc_co] -- Company 조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ofc_sal} != '')" ).append("\n"); 
		query.append("   AND C.SALY_FLG = @[ofc_sal] -- Salary 조건" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${sch_expense_group} != '') " ).append("\n"); 
		query.append("   AND C.GEM_EXPN_GRP_CD1 IN (${sch_expense_group}) -- Expense Group 조건" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if(${sch_tic_cd} != '')" ).append("\n"); 
		query.append("   AND C.TIC_CD = @[sch_tic_cd]" ).append("\n"); 
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
		query.append("		   " ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY OFFICE_EXPENSE, RT_FM_MON" ).append("\n"); 

	}
}