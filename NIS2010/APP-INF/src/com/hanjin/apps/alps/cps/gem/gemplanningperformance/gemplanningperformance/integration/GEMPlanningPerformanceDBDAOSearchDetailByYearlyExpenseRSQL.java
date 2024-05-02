/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchDetailByYearlyExpenseRSQL.java
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

public class GEMPlanningPerformanceDBDAOSearchDetailByYearlyExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPS_GEM_0019화면의 DownExcel 버튼 클릭시 Yearly Expense 정보를 조회
	  * 2011.01.31 이준범[CHM-201108626-01]
	  * 요청사항 : SELPLL- >SELLIC  관련 문제 연관 해소
	  * 보완내역 : 조직 변경으로 인한 조직 코드 변경시 과거 데이터를 조회 할 수 있도록
	  *                History Table(GEM_OFC_HIS) 검색하도록 SQL 수정 
	  * 
	  * 2012.12.12 Ticket ID : CHM-201221037
	  * 설계자 : 강환, 개발자 : 원종규
	  * Title : 일부 법인 비용주관팀 로직 변경에 따른 조회(inquiry/Report) 기능 보완 요청
	  * Description : SELPLI에서 승인하는 비용항목 조회시 SELPLI의 산하 조직이 조회되도록 수정  
	  * 2014.10.23 이준범 [CHM-201432508-01]
	  * 요청사항: [GEM] 결산작업을 위한 데이터 업데이트 지원
	  * 보완: SELPLI 하드코딩 부분 삭제 
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchDetailByYearlyExpenseRSQL(){
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
		params.put("sch_target",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sch_tic_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchDetailByYearlyExpenseRSQL").append("\n"); 
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
		query.append("SELECT  X.PLN_YRMON " ).append("\n"); 
		query.append("	   ,X.LVL1_CODE" ).append("\n"); 
		query.append("	   ,X.LVL1_NAME" ).append("\n"); 
		query.append("	   ,X.LVL2_CODE" ).append("\n"); 
		query.append("	   ,X.LVL2_NAME" ).append("\n"); 
		query.append("	   ,X.LVL4_CODE" ).append("\n"); 
		query.append("	   ,X.LVL4_NAME" ).append("\n"); 
		query.append("	   ,X.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("	   ,X.GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("	   ,X.LVL4_TIC" ).append("\n"); 
		query.append("	   ,X.OFC_CD" ).append("\n"); 
		query.append("	   ,X.RHQ" ).append("\n"); 
		query.append("	   ,X.LOCL_CURR_CD" ).append("\n"); 
		query.append("	   ,X.RQST_UT_VAL " ).append("\n"); 
		query.append("	   ,X.SALY_FLG " ).append("\n"); 
		query.append("	   ,X.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("	   ,X.JAN" ).append("\n"); 
		query.append("	   ,X.FEB" ).append("\n"); 
		query.append("	   ,X.MAR" ).append("\n"); 
		query.append("	   ,X.APR" ).append("\n"); 
		query.append("	   ,X.MAY" ).append("\n"); 
		query.append("	   ,X.JUN" ).append("\n"); 
		query.append("	   ,X.JUL" ).append("\n"); 
		query.append("	   ,X.AUG               " ).append("\n"); 
		query.append("	   ,X.SEP" ).append("\n"); 
		query.append("	   ,X.OCT               " ).append("\n"); 
		query.append("	   ,X.NOV" ).append("\n"); 
		query.append("	   ,X.DEC" ).append("\n"); 
		query.append("	   ,X.INT_TTL " ).append("\n"); 
		query.append("	   ,X.ADD_TTL " ).append("\n"); 
		query.append("	   ,X.TRN_TTL" ).append("\n"); 
		query.append("	   ,X.GRD_TTL" ).append("\n"); 
		query.append("	   ,X.CAL_BASIS" ).append("\n"); 
		query.append("	   ,X.RQST_OPIN_RMK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT A.PLN_YRMON " ).append("\n"); 
		query.append("          ,C.GEM_EXPN_GRP_CD1  LVL1_CODE" ).append("\n"); 
		query.append("          ,DECODE(@[sch_lang], 'E', C.ENG_ABBR_NM_1, 'K', C.KRN_ABBR_NM_1) LVL1_NAME" ).append("\n"); 
		query.append("          ,C.GEM_EXPN_GRP_CD2 LVL2_CODE" ).append("\n"); 
		query.append("          ,DECODE(@[sch_lang], 'E', C.ENG_ABBR_NM_2, 'K', C.KRN_ABBR_NM_2) LVL2_NAME" ).append("\n"); 
		query.append("          ,C.GEN_EXPN_CD LVL4_CODE" ).append("\n"); 
		query.append("          ,DECODE(@[sch_lang], 'E', C.ENG_ABBR_NM, 'K', C.KRN_ABBR_NM) LVL4_NAME" ).append("\n"); 
		query.append("          ,A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("          ,A.GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("          ,C.TIC_CD LVL4_TIC" ).append("\n"); 
		query.append("          ,A.OFC_CD" ).append("\n"); 
		query.append("          ,CASE WHEN B.GEN_EXPN_OFC_LVL = '4' AND A.OFC_CD <> B.PRNT_OFC_CD THEN B.PRNT_OFC_CD END RHQ" ).append("\n"); 
		query.append("		  ,DECODE(@[sch_cur], 'LCL', B.LOCL_CURR_CD" ).append("\n"); 
		query.append("                   , 'KRW', 'KRW'" ).append("\n"); 
		query.append("                   , 'USD', 'USD' ) LOCL_CURR_CD" ).append("\n"); 
		query.append("      	  ,DECODE(@[sch_cur], 'LCL', B.RQST_UT_VAL" ).append("\n"); 
		query.append("                   , 'KRW', '1000'" ).append("\n"); 
		query.append("                   , 'USD', '1' ) RQST_UT_VAL" ).append("\n"); 
		query.append("          ,C.SALY_FLG " ).append("\n"); 
		query.append("          ,B.OFC_CO_DIV_CD" ).append("\n"); 
		query.append("          ,A.JAN_AMT JAN" ).append("\n"); 
		query.append("          ,A.FEB_AMT FEB" ).append("\n"); 
		query.append("          ,A.MAR_AMT MAR" ).append("\n"); 
		query.append("          ,A.APR_AMT APR" ).append("\n"); 
		query.append("          ,A.MAY_AMT MAY" ).append("\n"); 
		query.append("          ,A.JUN_AMT JUN" ).append("\n"); 
		query.append("          ,A.JUL_AMT JUL" ).append("\n"); 
		query.append("          ,A.AUG_AMT AUG               " ).append("\n"); 
		query.append("          ,A.SEP_AMT SEP" ).append("\n"); 
		query.append("          ,A.OCT_AMT OCT               " ).append("\n"); 
		query.append("          ,A.NOV_AMT NOV" ).append("\n"); 
		query.append("          ,A.DEC_AMT DEC" ).append("\n"); 
		query.append("          ,A.INT_TTL " ).append("\n"); 
		query.append("          ,A.ADD_TTL " ).append("\n"); 
		query.append("          ,A.TRN_TTL" ).append("\n"); 
		query.append("          ,(A.INT_TTL + A.ADD_TTL + A.TRN_TTL) GRD_TTL" ).append("\n"); 
		query.append("          ,A.GEN_EXPN_CALC_BSS_DESC CAL_BASIS" ).append("\n"); 
		query.append("          ,A.RQST_OPIN_RMK" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("    SELECT A.OFC_CD" ).append("\n"); 
		query.append("          ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("          ,A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.JAN_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.JAN_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.JAN_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) JAN_AMT   " ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.FEB_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.FEB_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.FEB_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) FEB_AMT   " ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.MAR_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.MAR_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.MAR_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) MAR_AMT   " ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.APR_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.APR_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.APR_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) APR_AMT   " ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.MAY_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.MAY_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.MAY_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) MAY_AMT   " ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.JUN_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.JUN_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.JUN_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) JUN_AMT" ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.JUL_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.JUL_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.JUL_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) JUL_AMT" ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.AUG_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.AUG_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.AUG_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) AUG_AMT                   " ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.SEP_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.SEP_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.SEP_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) SEP_AMT" ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.OCT_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.OCT_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.OCT_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) OCT_AMT                   " ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.NOV_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.NOV_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.NOV_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) NOV_AMT" ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.DEC_AMT" ).append("\n"); 
		query.append("                       , 'USD', (A.DEC_AMT*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.DEC_AMT*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) DEC_AMT" ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.INT_TTL" ).append("\n"); 
		query.append("                       , 'USD', (A.INT_TTL*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.INT_TTL*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) INT_TTL" ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.ADD_TTL" ).append("\n"); 
		query.append("                       , 'USD', (A.ADD_TTL*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.ADD_TTL*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) ADD_TTL" ).append("\n"); 
		query.append("          ,SUM(DECODE(@[sch_cur], 'LCL', A.TRN_TTL" ).append("\n"); 
		query.append("                       , 'USD', (A.TRN_TTL*B.RQST_UT_VAL)/C.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                       , 'KRW', (((A.TRN_TTL*B.RQST_UT_VAL)/1000)/C.USD_LOCL_XCH_RT)*C.USD_KRW_XCH_RT )) TRN_TTL" ).append("\n"); 
		query.append("          ,MAX(A.GEN_EXPN_ITM_DESC) GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("          ,MAX(A.GEN_EXPN_CALC_BSS_DESC) GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append("          ,MAX(A.RQST_OPIN_RMK) RQST_OPIN_RMK" ).append("\n"); 
		query.append("          ,MAX(SUBSTR(A.PLN_YRMON,1,4)) PLN_YRMON" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT C.OFC_CD" ).append("\n"); 
		query.append("                  ,C.GEN_EXPN_CD" ).append("\n"); 
		query.append("                  ,C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                  ,C.JAN_AMT" ).append("\n"); 
		query.append("                  ,C.FEB_AMT" ).append("\n"); 
		query.append("                  ,C.MAR_AMT" ).append("\n"); 
		query.append("                  ,C.APR_AMT" ).append("\n"); 
		query.append("                  ,C.MAY_AMT" ).append("\n"); 
		query.append("                  ,C.JUN_AMT" ).append("\n"); 
		query.append("                  ,C.JUL_AMT" ).append("\n"); 
		query.append("                  ,C.AUG_AMT" ).append("\n"); 
		query.append("                  ,C.SEP_AMT" ).append("\n"); 
		query.append("                  ,C.OCT_AMT" ).append("\n"); 
		query.append("                  ,C.NOV_AMT" ).append("\n"); 
		query.append("                  ,C.DEC_AMT" ).append("\n"); 
		query.append("                  ,DECODE(A.GEN_EXPN_RQST_TP_CD, 'EI', C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT, 0) INT_TTL" ).append("\n"); 
		query.append("                  ,DECODE(A.GEN_EXPN_RQST_TP_CD, 'EA', C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT, 0) ADD_TTL" ).append("\n"); 
		query.append("                  ,DECODE(A.GEN_EXPN_RQST_TP_CD, 'ET', C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT, 0) TRN_TTL" ).append("\n"); 
		query.append("                  ,B.GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("                  ,B.GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append("                  ,B.RQST_OPIN_RMK" ).append("\n"); 
		query.append("                  ,A.PLN_YRMON" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                          ,GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append("                          ,SUBSTR(PLN_YRMON,1,4)||'00' PLN_YRMON" ).append("\n"); 
		query.append("                      FROM GEM_REQUEST" ).append("\n"); 
		query.append("                     WHERE PLN_YRMON LIKE @[sch_yrmon]||'%'" ).append("\n"); 
		query.append("					   #if(${sch_target} != 'PE')" ).append("\n"); 
		query.append("                       AND GEN_EXPN_RQST_TP_CD = @[sch_target]" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("                   ) A" ).append("\n"); 
		query.append("                  ,GEM_ITEM B" ).append("\n"); 
		query.append("                  ,GEM_APRO_STEP C" ).append("\n"); 
		query.append("             WHERE A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("               AND B.CRNT_GEN_EXPN_APRO_STEP_CD = 'CO'" ).append("\n"); 
		query.append("               AND B.CRNT_GEN_EXPN_APSTS_CD = 'AP'" ).append("\n"); 
		query.append("               AND B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("               AND B.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("               AND B.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("               AND B.GEN_EXPN_ITM_NO = C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("               AND B.GEN_EXPN_TRNS_DIV_CD = C.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("               AND B.GEN_EXPN_RQST_SEQ = C.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("               AND B.CRNT_GEN_EXPN_APRO_STEP_CD = C.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("           ) A" ).append("\n"); 
		query.append("          ,GEM_OFFICE B" ).append("\n"); 
		query.append("          ,GEM_XCH_RT C" ).append("\n"); 
		query.append("     WHERE A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("       AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("       AND C.ACCT_XCH_RT_YRMON = A.PLN_YRMON" ).append("\n"); 
		query.append("       AND C.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("     GROUP BY A.OFC_CD" ).append("\n"); 
		query.append("             ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("             ,A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("     ,GEM_OFFICE B" ).append("\n"); 
		query.append("     ,GEM_EXPN_GRP_V C" ).append("\n"); 
		query.append("    WHERE A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("      AND A.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("#if(${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("      AND ( A.OFC_CD IN (SELECT OFC_CD      " ).append("\n"); 
		query.append("                           FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                     START WITH OFC_CD IN (@[auth_ofc_cd])" ).append("\n"); 
		query.append("               CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) " ).append("\n"); 
		query.append("           OR C.TIC_CD = @[auth_ofc_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("      AND ( A.OFC_CD IN ( SELECT OFC_CD      " ).append("\n"); 
		query.append("                            FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                      START WITH OFC_CD IN ( SELECT L_4 " ).append("\n"); 
		query.append("                                               FROM GEM_OFC_LEVEL_V " ).append("\n"); 
		query.append("                                              WHERE L_3 = @[auth_ofc_cd] )" ).append("\n"); 
		query.append("                CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) OR C.TIC_CD = @[auth_ofc_cd] )   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   X.OFC_CD IN (SELECT     OFC_CD" ).append("\n"); 
		query.append("                   FROM       GEM_OFC_HIS" ).append("\n"); 
		query.append("                   START WITH OFC_CD IN (SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("                                         FROM            GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("                                         WHERE           1 = 1" ).append("\n"); 
		query.append("										 #if(${sch_hohq_gbn} != '')" ).append("\n"); 
		query.append("                                         AND             RGN_OFC_FLG = @[sch_hohq_gbn]" ).append("\n"); 
		query.append("                                         #end            " ).append("\n"); 
		query.append("                                         #if(${sch_lvl3} != '' && ${ofc_expn_cd} != '') AND L_4 = @[sch_lvl3] #end	" ).append("\n"); 
		query.append("                                         #if(${sch_lvl1} != '' && ${sch_lvl2} != '' && ${sch_lvl3} != '' && ${ofc_expn_cd} == '' ) AND L_4 = @[sch_lvl3] #end" ).append("\n"); 
		query.append("                                         #if(${sch_lvl1} != '' && ${sch_lvl2} != '' && ${sch_lvl3} == '') AND L_3 = @[sch_lvl2] #end" ).append("\n"); 
		query.append("                                         #if(${sch_lvl1} != '' && ${sch_lvl2} == '' && ${sch_lvl3} == '') AND L_2 = @[sch_lvl1] #end	" ).append("\n"); 
		query.append("                                         #if(${sch_lvl3} == '' && ${ofc_expn_cd} != '') AND L_4 = @[ofc_expn_cd] #end	        " ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                   CONNECT BY PRIOR OFC_CD = BFR_OFC_CD)" ).append("\n"); 
		query.append("AND   X.LVL4_CODE IN (SELECT L_4" ).append("\n"); 
		query.append("                        FROM   GEM_EXPN_LEVEL_V" ).append("\n"); 
		query.append("                        WHERE  1 = 1" ).append("\n"); 
		query.append("						AND    L_4 BETWEEN DECODE (@[sch_expense_from], '', '111111', @[sch_expense_from]) AND DECODE (@[sch_expense_to], '', '999999', @[sch_expense_to])" ).append("\n"); 
		query.append("                        #if (${sch_expense_group} != '')" ).append("\n"); 
		query.append("						AND    L_1 IN (${sch_expense_group})" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#if(${sch_tic_cd} != '')                       " ).append("\n"); 
		query.append("      AND X.LVL4_TIC = @[sch_tic_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sch_slay_flg} != '')" ).append("\n"); 
		query.append("AND   X.SALY_FLG = @[sch_slay_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_com_div} != '')" ).append("\n"); 
		query.append("AND   X.OFC_CO_DIV_CD = @[sch_com_div]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY X.LVL4_CODE" ).append("\n"); 

	}
}