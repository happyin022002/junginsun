/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchDetailByRequestExpenseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.12.17 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchDetailByRequestExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPS_GEM_0019_02 관련 Request expense of Initial Data조회
	  * 2010.10.26 이준범 [CHM-201006703-01]
	  * 1) 해당 메뉴
	  *    -  GEM > Report > Detaill _ Yearly Expense (After/Before Closing
	  * 2) 조건
	  *   - Year : 2011
	  *   - Condition : Request expense of Initial
	  *   - Target : Initial (Summarized)
	  * 3) 보완내용 
	  *   - 리포트의 Y, AC 열에 본사팀 승인 건 Data도 보여줄것
	  *     * Y열   : Next Year Planning(USD) / RQST /RHQ l BU
	  *     * AC열 : Next Year Planning(LCL) / RQST /RHQ l BU 
	  *     * 본사팀 승인 data는 아래에 포함되어 있슴
	  *       - Z열   : Next Year Planning(USD) / RQST /OFC
	  *       - AD열 : Next Year Planning(LCL) / RQST /OFC
	  * 2010.12.17 진마리아[CHM-201007600-01]
	  * 비용 데이터 검색 기준을 3년간 1번이라도 사용된 경우가 모두 포함되고 Office div가 변경된 경우도 모두 조회되도록 로직 변경
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchDetailByRequestExpenseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lvl3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sch_com_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_slay_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sch_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lvl1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_hohq_gbn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sch_app_div_gbn",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sch_cur",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchDetailByRequestExpenseRSQL").append("\n"); 
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
		query.append("SELECT X.OFC_EXPN " ).append("\n"); 
		query.append("      ,X.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,X.RQST_UT_VAL" ).append("\n"); 
		query.append("      ,X.YRMON" ).append("\n"); 
		query.append("      ,X.OFC_CD" ).append("\n"); 
		query.append("      ,X.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("      ,X.RHQ_OFC_CD" ).append("\n"); 
		query.append("      ,X.RGN_OFC_FLG" ).append("\n"); 
		query.append("      ,X.SLS_OFC_FLG" ).append("\n"); 
		query.append("      ,X.GEN_EXPN_CD      " ).append("\n"); 
		query.append("      ,X.EXPN_NAME" ).append("\n"); 
		query.append("      ,X.TIC_CD" ).append("\n"); 
		query.append("      ,X.LVL1_NAME" ).append("\n"); 
		query.append("      ,X.LVL2_NAME" ).append("\n"); 
		query.append("      ,Y.EX_RATE_PLAN_PRE" ).append("\n"); 
		query.append("      ,Y.EX_RATE_AVG" ).append("\n"); 
		query.append("      ,Y.EX_RATE_PLAN" ).append("\n"); 
		query.append("      ,X.PERF_USD_YEAR1" ).append("\n"); 
		query.append("      ,X.PERF_USD_AMT1" ).append("\n"); 
		query.append("      ,X.PERF_USD_YEAR2" ).append("\n"); 
		query.append("      ,X.PERF_USD_AMT2" ).append("\n"); 
		query.append("      ,X.PERF_USD_YEAR3" ).append("\n"); 
		query.append("      ,X.PERF_USD_AMT3" ).append("\n"); 
		query.append("      ,X.ASSI_USD_YEAR1" ).append("\n"); 
		query.append("      ,X.ASSI_USD_AMT1" ).append("\n"); 
		query.append("      ,X.ASSI_USD_YEAR2" ).append("\n"); 
		query.append("      ,X.ASSI_USD_AMT2" ).append("\n"); 
		query.append("      ,X.PLAN_USD_COM_AMT" ).append("\n"); 
		query.append("      ,X.PLAN_USD_TIC_AMT" ).append("\n"); 
		query.append("      ,X.PLAN_USD_RHQ_AMT" ).append("\n"); 
		query.append("      ,X.PLAN_USD_OFC_AMT" ).append("\n"); 
		query.append("      ,X.PLAN_LCL_COM_AMT" ).append("\n"); 
		query.append("      ,X.PLAN_LCL_TIC_AMT" ).append("\n"); 
		query.append("      ,X.PLAN_LCL_RHQ_AMT" ).append("\n"); 
		query.append("      ,X.PLAN_LCL_OFC_AMT" ).append("\n"); 
		query.append("      ,X.PERF_LCL_YEAR1" ).append("\n"); 
		query.append("      ,X.PERF_LCL_EST_AMT" ).append("\n"); 
		query.append("      ,X.PERF_LCL_PFM_AMT" ).append("\n"); 
		query.append("      ,X.PERF_LCL_PLAN_AMT" ).append("\n"); 
		query.append("      ,X.PERF_LCL_YEAR2" ).append("\n"); 
		query.append("      ,X.PERF_LCL_AMT2" ).append("\n"); 
		query.append("      ,X.PERF_LCL_YEAR3" ).append("\n"); 
		query.append("      ,X.PERF_LCL_AMT3" ).append("\n"); 
		query.append("      ,X.ASSI_LCL_YEAR1" ).append("\n"); 
		query.append("      ,X.ASSI_LCL_AMT1" ).append("\n"); 
		query.append("      ,X.ASSI_LCL_YEAR2" ).append("\n"); 
		query.append("      ,X.ASSI_LCL_AMT2" ).append("\n"); 
		query.append("      ,X.ASSI_LCL_YEAR3" ).append("\n"); 
		query.append("      ,X.ASSI_LCL_AMT3" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.OFC_CD||A.GEN_EXPN_CD OFC_EXPN " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', C.LOCL_CURR_CD, 'KRW', 'KRW', 'USD', 'USD') LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,C.LOCL_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', C.RQST_UT_VAL, 'KRW', '1000', 'USD', '1' ) RQST_UT_VAL" ).append("\n"); 
		query.append("      ,A.YRMON" ).append("\n"); 
		query.append("      ,A.OFC_CD" ).append("\n"); 
		query.append("      ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("      ,CASE WHEN GEN_EXPN_OFC_LVL = '4' AND B.OFC_CD <> C.PRNT_OFC_CD THEN C.PRNT_OFC_CD END RHQ_OFC_CD" ).append("\n"); 
		query.append("      ,C.RGN_OFC_FLG" ).append("\n"); 
		query.append("      ,D.SALY_FLG AS SLS_OFC_FLG" ).append("\n"); 
		query.append("      ,D.GEN_EXPN_CD      " ).append("\n"); 
		query.append("      ,DECODE(@[sch_lang], 'K', D.KRN_ABBR_NM, 'E', D.ENG_ABBR_NM) EXPN_NAME" ).append("\n"); 
		query.append("      ,D.TIC_CD" ).append("\n"); 
		query.append("      ,DECODE(@[sch_lang], 'K', D.KRN_ABBR_NM_1, 'E', D.ENG_ABBR_NM_1) LVL1_NAME" ).append("\n"); 
		query.append("      ,DECODE(@[sch_lang], 'K', D.KRN_ABBR_NM_2, 'E', D.ENG_ABBR_NM_2) LVL2_NAME" ).append("\n"); 
		query.append("      ,B.YM_1 PERF_USD_YEAR1" ).append("\n"); 
		query.append("      ,B.CONV_PPFM_AMT_1 PERF_USD_AMT1" ).append("\n"); 
		query.append("      ,B.YM_2 PERF_USD_YEAR2" ).append("\n"); 
		query.append("      ,B.CONV_PPFM_AMT_2 PERF_USD_AMT2" ).append("\n"); 
		query.append("      ,B.YM_3 PERF_USD_YEAR3" ).append("\n"); 
		query.append("      ,B.CONV_PPFM_AMT_3 PERF_USD_AMT3" ).append("\n"); 
		query.append("      ,B.YM_3 ASSI_USD_YEAR1" ).append("\n"); 
		query.append("      ,B.CONV_PPLAN_AMT_1 ASSI_USD_AMT1" ).append("\n"); 
		query.append("      ,B.YM_3 ASSI_USD_YEAR2" ).append("\n"); 
		query.append("      ,B.CONV_PPLAN_AMT_2 ASSI_USD_AMT2" ).append("\n"); 
		query.append("      ,A.CO_USD_AMT PLAN_USD_COM_AMT" ).append("\n"); 
		query.append("      ,A.TC_USD_AMT PLAN_USD_TIC_AMT" ).append("\n"); 
		query.append("      ,DECODE(A.HQ_USD_AMT, 0, A.RQ_USD_AMT, A.HQ_USD_AMT) PLAN_USD_RHQ_AMT" ).append("\n"); 
		query.append("      ,A.RQ_USD_AMT PLAN_USD_OFC_AMT" ).append("\n"); 
		query.append("      ,A.CO_AMT PLAN_LCL_COM_AMT" ).append("\n"); 
		query.append("      ,A.TC_AMT PLAN_LCL_TIC_AMT" ).append("\n"); 
		query.append("      ,DECODE(A.HQ_AMT, 0, A.RQ_AMT, A.HQ_AMT) PLAN_LCL_RHQ_AMT" ).append("\n"); 
		query.append("      ,A.RQ_AMT PLAN_LCL_OFC_AMT" ).append("\n"); 
		query.append("      ,B.YM_3 PERF_LCL_YEAR1" ).append("\n"); 
		query.append("      ,B.EST_AMT PERF_LCL_EST_AMT" ).append("\n"); 
		query.append("      ,B.PPFM_AMT_3 PERF_LCL_PFM_AMT" ).append("\n"); 
		query.append("      ,B.PPLAN_AMT PERF_LCL_PLAN_AMT" ).append("\n"); 
		query.append("      ,B.YM_1 PERF_LCL_YEAR2" ).append("\n"); 
		query.append("      ,B.PPFM_AMT_1 PERF_LCL_AMT2" ).append("\n"); 
		query.append("      ,B.YM_2 PERF_LCL_YEAR3" ).append("\n"); 
		query.append("      ,B.PPFM_AMT_2 PERF_LCL_AMT3" ).append("\n"); 
		query.append("      ,B.YM_1 ASSI_LCL_YEAR1" ).append("\n"); 
		query.append("      ,B.PLAN_AMT_1 ASSI_LCL_AMT1" ).append("\n"); 
		query.append("      ,B.YM_2 ASSI_LCL_YEAR2" ).append("\n"); 
		query.append("      ,B.PLAN_AMT_2 ASSI_LCL_AMT2" ).append("\n"); 
		query.append("      ,B.YM_3 ASSI_LCL_YEAR3" ).append("\n"); 
		query.append("      ,B.PLAN_AMT_3 ASSI_LCL_AMT3" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT @[sch_yrmon] YRMON" ).append("\n"); 
		query.append("              ,B.OFC_CD" ).append("\n"); 
		query.append("              ,B.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,B.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN A.GEN_EXPN_APRO_STEP_CD = DECODE(@[sch_app_div_gbn], 'ALL', 'RQ', 'RQ', 'RQ', '') AND A.GEN_EXPN_APSTS_CD = 'AP' THEN A.JAN_AMT + A.FEB_AMT + A.MAR_AMT + A.APR_AMT + A.MAY_AMT + A.JUN_AMT + A.JUL_AMT + A.AUG_AMT + A.SEP_AMT + A.OCT_AMT + A.NOV_AMT + A.DEC_AMT ELSE 0 END) RQ_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN A.GEN_EXPN_APRO_STEP_CD = DECODE(@[sch_app_div_gbn], 'ALL', 'HQ', 'HQ', 'HQ', '') AND A.GEN_EXPN_APSTS_CD = 'AP' THEN A.JAN_AMT + A.FEB_AMT + A.MAR_AMT + A.APR_AMT + A.MAY_AMT + A.JUN_AMT + A.JUL_AMT + A.AUG_AMT + A.SEP_AMT + A.OCT_AMT + A.NOV_AMT + A.DEC_AMT ELSE 0 END) HQ_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN A.GEN_EXPN_APRO_STEP_CD = DECODE(@[sch_app_div_gbn], 'ALL', 'TC', 'TC', 'TC', '') AND A.GEN_EXPN_APSTS_CD = 'AP' THEN A.JAN_AMT + A.FEB_AMT + A.MAR_AMT + A.APR_AMT + A.MAY_AMT + A.JUN_AMT + A.JUL_AMT + A.AUG_AMT + A.SEP_AMT + A.OCT_AMT + A.NOV_AMT + A.DEC_AMT ELSE 0 END) TC_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN A.GEN_EXPN_APRO_STEP_CD = DECODE(@[sch_app_div_gbn], 'ALL', 'CO', 'CO', 'CO', '') AND A.GEN_EXPN_APSTS_CD = 'AP' THEN A.JAN_AMT + A.FEB_AMT + A.MAR_AMT + A.APR_AMT + A.MAY_AMT + A.JUN_AMT + A.JUL_AMT + A.AUG_AMT + A.SEP_AMT + A.OCT_AMT + A.NOV_AMT + A.DEC_AMT ELSE 0 END) CO_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN A.GEN_EXPN_APRO_STEP_CD = DECODE(@[sch_app_div_gbn], 'ALL', 'RQ', 'RQ', 'RQ', '') AND A.GEN_EXPN_APSTS_CD = 'AP' THEN A.CONV_JAN_AMT + A.CONV_FEB_AMT + A.CONV_MAR_AMT + A.CONV_APR_AMT + A.CONV_MAY_AMT + A.CONV_JUN_AMT + A.CONV_JUL_AMT + A.CONV_AUG_AMT + A.CONV_SEP_AMT + A.CONV_OCT_AMT + A.CONV_NOV_AMT + A.CONV_DEC_AMT ELSE 0 END) RQ_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN A.GEN_EXPN_APRO_STEP_CD = DECODE(@[sch_app_div_gbn], 'ALL', 'HQ', 'HQ', 'HQ', '') AND A.GEN_EXPN_APSTS_CD = 'AP' THEN A.CONV_JAN_AMT + A.CONV_FEB_AMT + A.CONV_MAR_AMT + A.CONV_APR_AMT + A.CONV_MAY_AMT + A.CONV_JUN_AMT + A.CONV_JUL_AMT + A.CONV_AUG_AMT + A.CONV_SEP_AMT + A.CONV_OCT_AMT + A.CONV_NOV_AMT + A.CONV_DEC_AMT ELSE 0 END) HQ_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN A.GEN_EXPN_APRO_STEP_CD = DECODE(@[sch_app_div_gbn], 'ALL', 'TC', 'TC', 'TC', '') AND A.GEN_EXPN_APSTS_CD = 'AP' THEN A.CONV_JAN_AMT + A.CONV_FEB_AMT + A.CONV_MAR_AMT + A.CONV_APR_AMT + A.CONV_MAY_AMT + A.CONV_JUN_AMT + A.CONV_JUL_AMT + A.CONV_AUG_AMT + A.CONV_SEP_AMT + A.CONV_OCT_AMT + A.CONV_NOV_AMT + A.CONV_DEC_AMT ELSE 0 END) TC_USD_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN A.GEN_EXPN_APRO_STEP_CD = DECODE(@[sch_app_div_gbn], 'ALL', 'CO', 'CO', 'CO', '') AND A.GEN_EXPN_APSTS_CD = 'AP' THEN A.CONV_JAN_AMT + A.CONV_FEB_AMT + A.CONV_MAR_AMT + A.CONV_APR_AMT + A.CONV_MAY_AMT + A.CONV_JUN_AMT + A.CONV_JUL_AMT + A.CONV_AUG_AMT + A.CONV_SEP_AMT + A.CONV_OCT_AMT + A.CONV_NOV_AMT + A.CONV_DEC_AMT ELSE 0 END) CO_USD_AMT" ).append("\n"); 
		query.append("          FROM (      " ).append("\n"); 
		query.append("                SELECT SUBSTR(A.PLN_YRMON,1,4) YRMON" ).append("\n"); 
		query.append("                      ,B.OFC_CD" ).append("\n"); 
		query.append("                      ,B.GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,C.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                      ,B.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("                      ,B.GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append("                      ,B.JAN_AMT" ).append("\n"); 
		query.append("                      ,B.FEB_AMT" ).append("\n"); 
		query.append("                      ,B.MAR_AMT" ).append("\n"); 
		query.append("                      ,B.APR_AMT" ).append("\n"); 
		query.append("                      ,B.MAY_AMT" ).append("\n"); 
		query.append("                      ,B.JUN_AMT" ).append("\n"); 
		query.append("                      ,B.JUL_AMT" ).append("\n"); 
		query.append("                      ,B.AUG_AMT" ).append("\n"); 
		query.append("                      ,B.SEP_AMT" ).append("\n"); 
		query.append("                      ,B.OCT_AMT" ).append("\n"); 
		query.append("                      ,B.NOV_AMT" ).append("\n"); 
		query.append("                      ,B.DEC_AMT" ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.JAN_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.JAN_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                        , 'LCL', (B.JAN_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_JAN_AMT" ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.FEB_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.FEB_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                        , 'LCL', (B.FEB_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_FEB_AMT" ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.MAR_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.MAR_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                        , 'LCL', (B.MAR_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_MAR_AMT" ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.APR_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.APR_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                        , 'LCL', (B.APR_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_APR_AMT" ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.MAY_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.MAY_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                        , 'LCL', (B.MAY_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_MAY_AMT" ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.JUN_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.JUN_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                        , 'LCL', (B.JUN_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_JUN_AMT" ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.JUL_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.JUL_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                        , 'LCL', (B.JUL_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_JUL_AMT" ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.AUG_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.AUG_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                        , 'LCL', (B.AUG_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_AUG_AMT" ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.SEP_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.SEP_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                        , 'LCL', (B.SEP_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_SEP_AMT                   " ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.OCT_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.OCT_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                        , 'LCL', (B.OCT_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_OCT_AMT" ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.NOV_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.NOV_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                        , 'LCL', (B.NOV_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_NOV_AMT" ).append("\n"); 
		query.append("                      ,DECODE(@[sch_cur], 'KRW', (((B.DEC_AMT*C.RQST_UT_VAL)/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                        , 'USD', (B.DEC_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                        , 'LCL', (B.DEC_AMT*C.RQST_UT_VAL)/D.USD_LOCL_XCH_RT ) CONV_DEC_AMT   " ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                              ,B.OFC_CD" ).append("\n"); 
		query.append("                              ,B.GEN_EXPN_CD" ).append("\n"); 
		query.append("                              ,B.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                              ,B.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("                              ,B.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("                              ,A.PLN_YRMON" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                                      ,PLN_YRMON" ).append("\n"); 
		query.append("                                  FROM GEM_REQUEST" ).append("\n"); 
		query.append("                                 WHERE PLN_YRMON = @[sch_yrmon]||'00' " ).append("\n"); 
		query.append("                                   AND GEN_EXPN_RQST_TP_CD = 'EI'" ).append("\n"); 
		query.append("                               ) A" ).append("\n"); 
		query.append("                              ,GEM_ITEM B" ).append("\n"); 
		query.append("                         WHERE A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                      ,GEM_APRO_STEP B" ).append("\n"); 
		query.append("                      ,GEM_OFFICE C" ).append("\n"); 
		query.append("                      ,GEM_XCH_RT D" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                   AND A.OFC_CD           = B.OFC_CD" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_CD      = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_ITM_NO  = B.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_TRNS_DIV_CD = B.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("                   AND A.GEN_EXPN_RQST_SEQ = B.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("                   AND B.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("                   AND C.LOCL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("                   AND D.ACCT_XCH_RT_YRMON = A.PLN_YRMON" ).append("\n"); 
		query.append("                   AND D.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT DISTINCT " ).append("\n"); 
		query.append("                       OFC_CD" ).append("\n"); 
		query.append("                      ,GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                  FROM GEM_RSLT_SMRY" ).append("\n"); 
		query.append("                 WHERE RSLT_YRMON BETWEEN TO_CHAR(@[sch_yrmon]-'3'||'01') AND @[sch_yrmon]||'12'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT B.OFC_CD" ).append("\n"); 
		query.append("                      ,B.GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,C.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                              ,PLN_YRMON" ).append("\n"); 
		query.append("                          FROM GEM_REQUEST" ).append("\n"); 
		query.append("                         WHERE PLN_YRMON = @[sch_yrmon] ||'00' " ).append("\n"); 
		query.append("                           AND GEN_EXPN_RQST_TP_CD = 'EI'" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                      ,GEM_ITEM B" ).append("\n"); 
		query.append("                      ,GEM_OFFICE C" ).append("\n"); 
		query.append("                 WHERE A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                   AND B.OFC_CD = C.OFC_CD              " ).append("\n"); 
		query.append("               ) B" ).append("\n"); 
		query.append("          WHERE A.OFC_CD(+) = B.OFC_CD" ).append("\n"); 
		query.append("            AND A.GEN_EXPN_CD(+) = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("            AND A.OFC_CO_DIV_CD(+) = B.OFC_CO_DIV_CD                 " ).append("\n"); 
		query.append("      GROUP BY B.OFC_CD" ).append("\n"); 
		query.append("              ,B.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,B.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT @[sch_yrmon] YRMON" ).append("\n"); 
		query.append("              ,B.OFC_CD" ).append("\n"); 
		query.append("              ,B.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,B.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("              ,SUM(A.CONV_PPLAN_AMT_1) CONV_PPLAN_AMT_1" ).append("\n"); 
		query.append("              ,SUM(A.CONV_PPLAN_AMT_2) CONV_PPLAN_AMT_2" ).append("\n"); 
		query.append("              ,SUM(DECODE(A.YYYY, @[sch_yrmon]-'3', YYYY)) YM_1" ).append("\n"); 
		query.append("              ,SUM(A.CONV_PPFM_AMT_1) CONV_PPFM_AMT_1   " ).append("\n"); 
		query.append("              ,SUM(DECODE(A.YYYY, @[sch_yrmon]-'2', YYYY)) YM_2" ).append("\n"); 
		query.append("              ,SUM(A.CONV_PPFM_AMT_2) CONV_PPFM_AMT_2  " ).append("\n"); 
		query.append("              ,SUM(DECODE(A.YYYY, @[sch_yrmon]-'1', YYYY)) YM_3" ).append("\n"); 
		query.append("              ,SUM(A.CONV_PPFM_AMT_3 + A.CONV_PPLAN_AMT) CONV_PPFM_AMT_3" ).append("\n"); 
		query.append("              ,SUM(A.EST_AMT) EST_AMT" ).append("\n"); 
		query.append("              ,SUM(A.PPFM_AMT_3) PPFM_AMT_3" ).append("\n"); 
		query.append("              ,SUM(A.PPLAN_AMT) PPLAN_AMT" ).append("\n"); 
		query.append("              ,SUM(A.PPFM_AMT_1) PPFM_AMT_1" ).append("\n"); 
		query.append("              ,SUM(A.PPFM_AMT_2) PPFM_AMT_2" ).append("\n"); 
		query.append("              ,SUM(A.PLAN_AMT_1) PLAN_AMT_1" ).append("\n"); 
		query.append("              ,SUM(A.PLAN_AMT_2) PLAN_AMT_2" ).append("\n"); 
		query.append("              ,SUM(A.PLAN_AMT_3) PLAN_AMT_3              " ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT YYYY" ).append("\n"); 
		query.append("                      ,OFC_CD" ).append("\n"); 
		query.append("                      ,GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'3', PLAN_AMT, 0 )) PLAN_AMT_1" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'2', PLAN_AMT, 0 )) PLAN_AMT_2" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'1', PLAN_AMT, 0 )) PLAN_AMT_3" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'3', PPFM_AMT, 0 )) PPFM_AMT_1" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'2', PPFM_AMT, 0 )) PPFM_AMT_2" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'1', PPFM_AMT, 0 )) PPFM_AMT_3" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'1', PPLAN_AMT, 0 )) PPLAN_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'1', EST_AMT, 0 )) EST_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'3', CONV_PPFM_AMT, 0 )) CONV_PPFM_AMT_1" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'2', CONV_PPFM_AMT, 0 )) CONV_PPFM_AMT_2" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'1', CONV_PPFM_AMT, 0 )) CONV_PPFM_AMT_3" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'1', CONV_PPLAN_AMT, 0 )) CONV_PPLAN_AMT" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'1', CONV_PPLAN_AMT_1, 0 )) CONV_PPLAN_AMT_1" ).append("\n"); 
		query.append("                      ,SUM(DECODE(YYYY, @[sch_yrmon]-'1', CONV_PPLAN_AMT_2, 0 )) CONV_PPLAN_AMT_2" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT SUBSTR(A.RSLT_YRMON,1,4) YYYY" ).append("\n"); 
		query.append("                              ,A.OFC_CD" ).append("\n"); 
		query.append("                              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                              ,(A.PLAN_AMT/A.RQST_UT_VAL) PLAN_AMT" ).append("\n"); 
		query.append("                              ,DECODE(A.PPFM_AMT, 0, 0" ).append("\n"); 
		query.append("                                                , DECODE(@[sch_cur], 'KRW', ((A.PPFM_AMT/1000)/B.USD_LOCL_XCH_RT) * B.USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                                                   , 'USD', A.PPFM_AMT/B.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                                                   , 'LCL', A.PPFM_AMT/B.USD_LOCL_XCH_RT ) ) CONV_PPFM_AMT" ).append("\n"); 
		query.append("                              ,(A.PPFM_AMT/A.RQST_UT_VAL) PPFM_AMT" ).append("\n"); 
		query.append("                              ,DECODE(A.PPLAN_AMT, 0, 0" ).append("\n"); 
		query.append("                                                , DECODE(@[sch_cur], 'KRW', ((A.PPLAN_AMT/1000)/B.USD_LOCL_XCH_RT) * B.USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                                                   , 'USD', A.PPLAN_AMT/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                                                   , 'LCL', A.PPLAN_AMT/B.USD_LOCL_XCH_RT ) ) CONV_PPLAN_AMT                             " ).append("\n"); 
		query.append("                              ,(A.PPLAN_AMT/A.RQST_UT_VAL) PPLAN_AMT" ).append("\n"); 
		query.append("                              ,DECODE(A.PLAN_AMT, 0, 0" ).append("\n"); 
		query.append("                                                , DECODE(@[sch_cur], 'KRW', ((A.PLAN_AMT/1000)/C.USD_LOCL_XCH_RT) * C.USD_KRW_XCH_RT " ).append("\n"); 
		query.append("                                                                   , 'USD', A.PLAN_AMT/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                                                   , 'LCL', A.PLAN_AMT/C.USD_LOCL_XCH_RT ) )  CONV_PPLAN_AMT_1" ).append("\n"); 
		query.append("                              ,DECODE(A.PLAN_AMT, 0, 0" ).append("\n"); 
		query.append("                                                , DECODE(@[sch_cur], 'KRW', ((A.PLAN_AMT/1000)/D.USD_LOCL_XCH_RT) * D.USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                                                   , 'USD', A.PLAN_AMT/D.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("                                                                   , 'LCL', A.PLAN_AMT/D.USD_LOCL_XCH_RT ) ) CONV_PPLAN_AMT_2                              " ).append("\n"); 
		query.append("                              ,(A.PPFM_AMT/A.RQST_UT_VAL) + (A.PPLAN_AMT/A.RQST_UT_VAL) EST_AMT" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT RSLT_YRMON" ).append("\n"); 
		query.append("                                      ,OFC_CD" ).append("\n"); 
		query.append("                                      ,GEN_EXPN_CD" ).append("\n"); 
		query.append("                                      ,OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                                      ,LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      ,RQST_UT_VAL" ).append("\n"); 
		query.append("                                      ,PLAN_AMT" ).append("\n"); 
		query.append("                                      ,CASE WHEN RSLT_YRMON <= YRMON THEN SLP_PERF_AMT ELSE 0 END PPFM_AMT" ).append("\n"); 
		query.append("                                      ,CASE WHEN RSLT_YRMON >  YRMON THEN PLAN_AMT     ELSE 0 END PPLAN_AMT" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                        SELECT A.RSLT_YRMON" ).append("\n"); 
		query.append("                                              ,A.OFC_CD" ).append("\n"); 
		query.append("                                              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                                              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                                              ,B.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                              ,B.RQST_UT_VAL" ).append("\n"); 
		query.append("                                              ,SUM(A.GEN_EXPN_INIT_AMT) + SUM(A.GEN_EXPN_ADD_AMT) + SUM(A.GEN_EXPN_TRNS_AMT) PLAN_AMT" ).append("\n"); 
		query.append("                                              ,SUM(A.SLP_PERF_AMT) SLP_PERF_AMT" ).append("\n"); 
		query.append("                                              ,( SELECT MAX(CLZ_YRMON) FROM GEM_MON_CLZ WHERE CLZ_YRMON LIKE @[sch_yrmon]-'1'||'%' AND CLZ_DIV_CD = 'IN' AND CLZ_FLG = 'Y' ) AS YRMON                                              " ).append("\n"); 
		query.append("                                          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("                                              ,GEM_OFFICE B" ).append("\n"); 
		query.append("                                         WHERE A.RSLT_YRMON BETWEEN @[sch_yrmon]-'3'||'01' AND @[sch_yrmon]||'12'" ).append("\n"); 
		query.append("                                           AND A.OFC_CD = B.OFC_CD " ).append("\n"); 
		query.append("                                      GROUP BY A.RSLT_YRMON" ).append("\n"); 
		query.append("                                              ,A.OFC_CD" ).append("\n"); 
		query.append("                                              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("                                              ,A.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                                              ,B.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                              ,B.RQST_UT_VAL   " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                               ) A" ).append("\n"); 
		query.append("                              ,(" ).append("\n"); 
		query.append("                                SELECT A.YRMON" ).append("\n"); 
		query.append("                                      ,A.CURR_CD" ).append("\n"); 
		query.append("                                      ,CASE WHEN A.YRMON <= A.CLZ_YRMON THEN B.USD_LOCL_XCH_RT ELSE C.USD_LOCL_XCH_RT END USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                      ,CASE WHEN A.YRMON <= A.CLZ_YRMON THEN B.LOCL_KRW_XCH_RT ELSE C.LOCL_KRW_XCH_RT END LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("                                      ,CASE WHEN A.YRMON <= A.CLZ_YRMON THEN B.USD_KRW_XCH_RT ELSE C.USD_KRW_XCH_RT END USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                        SELECT B.YRMON" ).append("\n"); 
		query.append("                                              ,A.CURR_CD" ).append("\n"); 
		query.append("                                              ,( SELECT MAX(CLZ_YRMON) FROM GEM_MON_CLZ WHERE CLZ_YRMON LIKE @[sch_yrmon]-'1'||'%' AND CLZ_DIV_CD = 'IN' AND CLZ_FLG = 'Y' ) AS CLZ_YRMON" ).append("\n"); 
		query.append("                                          FROM (" ).append("\n"); 
		query.append("                                                SELECT DISTINCT CURR_CD " ).append("\n"); 
		query.append("                                                  FROM GEM_XCH_RT" ).append("\n"); 
		query.append("                                                 WHERE ACCT_XCH_RT_YRMON LIKE @[sch_yrmon]-'1'||'%'" ).append("\n"); 
		query.append("                                               )A" ).append("\n"); 
		query.append("                                              ,(" ).append("\n"); 
		query.append("                                                SELECT @[sch_yrmon]-'1'||TRIM(TO_CHAR(ROWNUM,'00')) YRMON" ).append("\n"); 
		query.append("                                                  FROM DUAL " ).append("\n"); 
		query.append("                                               CONNECT BY LEVEL <= 12" ).append("\n"); 
		query.append("                                               ) B           " ).append("\n"); 
		query.append("                                       ) A" ).append("\n"); 
		query.append("                                      ,GEM_XCH_RT B" ).append("\n"); 
		query.append("                                      ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                                 WHERE A.YRMON   = B.ACCT_XCH_RT_YRMON(+)" ).append("\n"); 
		query.append("                                   AND A.CURR_CD = B.CURR_CD(+)" ).append("\n"); 
		query.append("                                   AND B.GEN_EXPN_XCH_RT_DIV_CD(+) = 'M'" ).append("\n"); 
		query.append("                                   AND A.CURR_CD = C.CURR_CD(+)" ).append("\n"); 
		query.append("                                   AND C.ACCT_XCH_RT_YRMON(+) = @[sch_yrmon]-'1'||'00'" ).append("\n"); 
		query.append("                                   AND C.GEN_EXPN_XCH_RT_DIV_CD(+) = 'I' " ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                 SELECT ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                                       ,CURR_CD" ).append("\n"); 
		query.append("                                       ,USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                       ,LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("                                       ,USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                                   FROM GEM_XCH_RT" ).append("\n"); 
		query.append("                                  WHERE ACCT_XCH_RT_YRMON BETWEEN @[sch_yrmon]-'3'||'01' AND @[sch_yrmon]-'2'||'12'" ).append("\n"); 
		query.append("                                    AND GEN_EXPN_XCH_RT_DIV_CD = 'M'" ).append("\n"); 
		query.append("                                    AND DELT_FLG = 'N'          " ).append("\n"); 
		query.append("                               ) B" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("                              ,GEM_XCH_RT D    " ).append("\n"); 
		query.append("                         WHERE A.RSLT_YRMON   = B.YRMON            " ).append("\n"); 
		query.append("                           AND A.LOCL_CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("                           AND A.LOCL_CURR_CD = C.CURR_CD(+)" ).append("\n"); 
		query.append("                           AND A.LOCL_CURR_CD = D.CURR_CD(+)" ).append("\n"); 
		query.append("                           AND C.ACCT_XCH_RT_YRMON(+) = @[sch_yrmon]-'1'||'00'" ).append("\n"); 
		query.append("                           AND C.GEN_EXPN_XCH_RT_DIV_CD(+) = 'I'" ).append("\n"); 
		query.append("                           AND C.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("                           AND D.ACCT_XCH_RT_YRMON(+) = @[sch_yrmon]||'00'" ).append("\n"); 
		query.append("                           AND D.GEN_EXPN_XCH_RT_DIV_CD(+) = 'I'" ).append("\n"); 
		query.append("                           AND D.DELT_FLG(+) = 'N' " ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                  GROUP BY YYYY" ).append("\n"); 
		query.append("                          ,OFC_CD" ).append("\n"); 
		query.append("                          ,GEN_EXPN_CD" ).append("\n"); 
		query.append("                          ,OFC_CO_DIV_CD" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT DISTINCT " ).append("\n"); 
		query.append("                       OFC_CD" ).append("\n"); 
		query.append("                      ,GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                  FROM GEM_RSLT_SMRY" ).append("\n"); 
		query.append("                 WHERE RSLT_YRMON BETWEEN TO_CHAR(@[sch_yrmon]-'3'||'01') AND @[sch_yrmon]||'12'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT B.OFC_CD" ).append("\n"); 
		query.append("                      ,B.GEN_EXPN_CD" ).append("\n"); 
		query.append("                      ,C.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                              ,PLN_YRMON" ).append("\n"); 
		query.append("                          FROM GEM_REQUEST" ).append("\n"); 
		query.append("                         WHERE PLN_YRMON = @[sch_yrmon]||'00' " ).append("\n"); 
		query.append("                           AND GEN_EXPN_RQST_TP_CD = 'EI'" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                      ,GEM_ITEM B" ).append("\n"); 
		query.append("                      ,GEM_OFFICE C" ).append("\n"); 
		query.append("                 WHERE A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                   AND B.OFC_CD = C.OFC_CD              " ).append("\n"); 
		query.append("               ) B" ).append("\n"); 
		query.append("          WHERE A.OFC_CD(+) = B.OFC_CD" ).append("\n"); 
		query.append("            AND A.GEN_EXPN_CD(+) = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("            AND A.OFC_CO_DIV_CD(+) = B.OFC_CO_DIV_CD                   " ).append("\n"); 
		query.append("         GROUP BY B.OFC_CD" ).append("\n"); 
		query.append("                 ,B.GEN_EXPN_CD" ).append("\n"); 
		query.append("                 ,B.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("     ,GEM_OFFICE C" ).append("\n"); 
		query.append("     ,GEM_EXPN_GRP_V D" ).append("\n"); 
		query.append(" WHERE A.YRMON = B.YRMON" ).append("\n"); 
		query.append("   AND A.OFC_CD= B.OFC_CD" ).append("\n"); 
		query.append("   AND A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("   AND A.OFC_CO_DIV_CD = B.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("   AND B.OFC_CD = C.OFC_CD(+)" ).append("\n"); 
		query.append("   AND B.GEN_EXPN_CD = D.GEN_EXPN_CD(+)     " ).append("\n"); 
		query.append("#if(${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("   AND (B.OFC_CD = @[auth_ofc_cd] OR D.TIC_CD = @[auth_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("   AND ( B.OFC_CD IN ( SELECT L_4 FROM GEM_OFC_LEVEL_V WHERE L_3 = @[auth_ofc_cd]) OR D.TIC_CD = @[auth_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ) X" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("  SELECT A.CURR_CD" ).append("\n"); 
		query.append("        ,DECODE(@[sch_cur], 'KRW', A.LOCL_KRW_XCH_RT/A.CURR_CNT, A.USD_LOCL_XCH_RT/A.CURR_CNT ) EX_RATE_AVG" ).append("\n"); 
		query.append("        ,DECODE(@[sch_cur], 'KRW', C.LOCL_KRW_XCH_RT, C.USD_LOCL_XCH_RT ) EX_RATE_PLAN_PRE" ).append("\n"); 
		query.append("        ,DECODE(@[sch_cur], 'KRW', D.LOCL_KRW_XCH_RT, D.USD_LOCL_XCH_RT ) EX_RATE_PLAN" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT CURR_CD" ).append("\n"); 
		query.append("              ,SUM(USD_LOCL_XCH_RT) USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("              ,SUM(LOCL_KRW_XCH_RT) LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("              ,MAX(CURR_CNT) CURR_CNT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                      ,CURR_CD" ).append("\n"); 
		query.append("                      ,USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                      ,LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("                      ,COUNT(CURR_CD) OVER (PARTITION BY SUBSTR(ACCT_XCH_RT_YRMON,1,4), CURR_CD) AS CURR_CNT" ).append("\n"); 
		query.append("                  FROM GEM_XCH_RT" ).append("\n"); 
		query.append("                 WHERE ACCT_XCH_RT_YRMON LIKE @[sch_yrmon]-'1'||'%'" ).append("\n"); 
		query.append("                   AND GEN_EXPN_XCH_RT_DIV_CD = 'M'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       GROUP BY CURR_CD    " ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append("        ,GEM_XCH_RT C" ).append("\n"); 
		query.append("        ,GEM_XCH_RT D" ).append("\n"); 
		query.append("   WHERE A.CURR_CD = C.CURR_CD(+)" ).append("\n"); 
		query.append("     AND A.CURR_CD = D.CURR_CD(+)" ).append("\n"); 
		query.append("     AND C.ACCT_XCH_RT_YRMON(+) = @[sch_yrmon]-'1'||'00'" ).append("\n"); 
		query.append("     AND C.GEN_EXPN_XCH_RT_DIV_CD(+) = 'I'" ).append("\n"); 
		query.append("     AND C.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("     AND D.ACCT_XCH_RT_YRMON(+) = @[sch_yrmon]||'00'" ).append("\n"); 
		query.append("     AND D.GEN_EXPN_XCH_RT_DIV_CD(+) = 'I'" ).append("\n"); 
		query.append("     AND D.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append(" ) Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND X.CURR_CD = Y.CURR_CD" ).append("\n"); 
		query.append("  AND X.OFC_CD IN (SELECT     OFC_CD" ).append("\n"); 
		query.append("                   FROM       GEM_OFC_HIS" ).append("\n"); 
		query.append("                   START WITH OFC_CD IN (SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("                                         FROM            GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("                                         WHERE           1 = 1" ).append("\n"); 
		query.append("                                         #if(${sch_hohq_gbn} != '')" ).append("\n"); 
		query.append("                                         AND             RGN_OFC_FLG = @[sch_hohq_gbn]" ).append("\n"); 
		query.append("                                         #end" ).append("\n"); 
		query.append("                                         #if(${sch_lvl3} != '' && ${ofc_expn_cd} != '') AND L_4 = @[sch_lvl3] #end	" ).append("\n"); 
		query.append("                                         #if(${sch_lvl1} != '' && ${sch_lvl2} != '' && ${sch_lvl3} != '' && ${ofc_expn_cd} == '' ) AND L_4 = @[sch_lvl3] #end" ).append("\n"); 
		query.append("                                         #if(${sch_lvl1} != '' && ${sch_lvl2} != '' && ${sch_lvl3} == '') AND L_3 = @[sch_lvl2] #end" ).append("\n"); 
		query.append("                                         #if(${sch_lvl1} != '' && ${sch_lvl2} == '' && ${sch_lvl3} == '') AND L_2 = @[sch_lvl1] #end	" ).append("\n"); 
		query.append("                                         #if(${sch_lvl3} == '' && ${ofc_expn_cd} != '') AND L_4 = @[ofc_expn_cd] #end	  " ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                   CONNECT BY PRIOR OFC_CD = BFR_OFC_CD)" ).append("\n"); 
		query.append("AND   X.GEN_EXPN_CD IN (SELECT L_4" ).append("\n"); 
		query.append("                        FROM   GEM_EXPN_LEVEL_V" ).append("\n"); 
		query.append("                        WHERE  1 = 1" ).append("\n"); 
		query.append("                        AND    L_4 BETWEEN DECODE (@[sch_expense_from], '', '111111', @[sch_expense_from]) AND DECODE (@[sch_expense_to], '', '999999', @[sch_expense_to])" ).append("\n"); 
		query.append("                        #if (${sch_expense_group} != '')" ).append("\n"); 
		query.append("                        AND    L_1 = @[sch_expense_group]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#if (${sch_tic_cd} != '')" ).append("\n"); 
		query.append("AND   X.TIC_CD = @[sch_tic_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_slay_flg} != '')" ).append("\n"); 
		query.append("AND   X.SLS_OFC_FLG = @[sch_slay_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_com_div} != '')" ).append("\n"); 
		query.append("AND   X.OFC_CO_DIV_CD = @[sch_com_div]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY X.OFC_EXPN" ).append("\n"); 

	}
}