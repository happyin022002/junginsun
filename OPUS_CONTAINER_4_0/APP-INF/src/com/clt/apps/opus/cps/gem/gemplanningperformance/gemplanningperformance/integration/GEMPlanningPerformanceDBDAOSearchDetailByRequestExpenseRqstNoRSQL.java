/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchDetailByRequestExpenseRqstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.30 
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

public class GEMPlanningPerformanceDBDAOSearchDetailByRequestExpenseRqstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPS_GEM_0019화면의 Request Expense의 Target이 Detail RQST NO인경우 ExcelDown 버튼 클릭시 조회
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchDetailByRequestExpenseRqstNoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_status",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchDetailByRequestExpenseRqstNoRSQL").append("\n"); 
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
		query.append("SELECT X.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("      ,X.OFC_STS" ).append("\n"); 
		query.append("      ,X.RHQLBU_STS" ).append("\n"); 
		query.append("      ,X.TIC_STS" ).append("\n"); 
		query.append("      ,X.COM_STS" ).append("\n"); 
		query.append("      ,X.OFC_CD" ).append("\n"); 
		query.append("      ,X.RHQ_OFC_CD" ).append("\n"); 
		query.append("      ,X.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,X.RQST_UT_VAL" ).append("\n"); 
		query.append("      ,X.GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,X.EXPN_ABBR_NM" ).append("\n"); 
		query.append("      ,X.TIC_CD" ).append("\n"); 
		query.append("      ,X.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("      ,X.GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("      ,X.JAN_AMT" ).append("\n"); 
		query.append("      ,X.FEB_AMT    " ).append("\n"); 
		query.append("      ,X.MAR_AMT " ).append("\n"); 
		query.append("      ,X.APR_AMT " ).append("\n"); 
		query.append("      ,X.MAY_AMT " ).append("\n"); 
		query.append("      ,X.JUN_AMT " ).append("\n"); 
		query.append("      ,X.JUL_AMT " ).append("\n"); 
		query.append("      ,X.AUG_AMT " ).append("\n"); 
		query.append("      ,X.SEP_AMT " ).append("\n"); 
		query.append("      ,X.OCT_AMT " ).append("\n"); 
		query.append("      ,X.NOV_AMT " ).append("\n"); 
		query.append("      ,X.DEC_AMT " ).append("\n"); 
		query.append("      ,X.OFC_TOTAL  " ).append("\n"); 
		query.append("      ,X.RHQlBU_TOTAL" ).append("\n"); 
		query.append("      ,X.TIC_TOTAL" ).append("\n"); 
		query.append("      ,X.COM_TOTAL" ).append("\n"); 
		query.append("      ,X.GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append("      ,X.RQST_OPIN_RMK" ).append("\n"); 
		query.append("      ,X.CRE_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("      ,A.OFC_STS" ).append("\n"); 
		query.append("      ,A.RHQLBU_STS" ).append("\n"); 
		query.append("      ,A.TIC_STS" ).append("\n"); 
		query.append("      ,A.COM_STS" ).append("\n"); 
		query.append("      ,A.OFC_CD" ).append("\n"); 
		query.append("      ,A.RHQ_OFC_CD" ).append("\n"); 
		query.append("      ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,A.RQST_UT_VAL" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,A.EXPN_ABBR_NM" ).append("\n"); 
		query.append("      ,A.TIC_CD" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.JAN_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.JAN_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.JAN_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) JAN_AMT" ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.FEB_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.FEB_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.FEB_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) FEB_AMT    " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.MAR_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.MAR_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.MAR_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) MAR_AMT " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.APR_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.APR_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.APR_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) APR_AMT " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.MAY_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.MAY_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.MAY_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) MAY_AMT " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.JUN_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.JUN_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.JUN_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) JUN_AMT " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.JUL_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.JUL_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.JUL_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) JUL_AMT " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.AUG_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.AUG_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.AUG_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) AUG_AMT " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.SEP_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.SEP_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.SEP_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) SEP_AMT " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.OCT_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.OCT_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.OCT_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) OCT_AMT " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.NOV_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.NOV_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.NOV_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) NOV_AMT " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.DEC_AMT" ).append("\n"); 
		query.append("                   , 'USD', (A.DEC_AMT*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.DEC_AMT*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) DEC_AMT " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.OFC_TOTAL" ).append("\n"); 
		query.append("                   , 'USD', (A.OFC_TOTAL*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.OFC_TOTAL*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) OFC_TOTAL  " ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.RHQlBU_TOTAL" ).append("\n"); 
		query.append("                   , 'USD', (A.RHQlBU_TOTAL*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.RHQlBU_TOTAL*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) RHQlBU_TOTAL" ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.TIC_TOTAL" ).append("\n"); 
		query.append("                   , 'USD', (A.TIC_TOTAL*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.TIC_TOTAL*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) TIC_TOTAL" ).append("\n"); 
		query.append("      ,DECODE(@[sch_cur], 'LCL', A.COM_TOTAL" ).append("\n"); 
		query.append("                   , 'USD', (A.COM_TOTAL*A.RQST_UT_VAL)/B.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   , 'KRW', ((((A.COM_TOTAL*A.RQST_UT_VAL)/1000)/B.USD_LOCL_XCH_RT)*B.USD_KRW_XCH_RT )) COM_TOTAL" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append("      ,A.RQST_OPIN_RMK" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("              ,MAX(DECODE(C.GEN_EXPN_APRO_STEP_CD, 'RQ', C.GEN_EXPN_APSTS_CD)) OFC_STS" ).append("\n"); 
		query.append("              ,MAX(DECODE(C.GEN_EXPN_APRO_STEP_CD, 'HQ', C.GEN_EXPN_APSTS_CD)) RHQLBU_STS" ).append("\n"); 
		query.append("              ,MAX(DECODE(C.GEN_EXPN_APRO_STEP_CD, 'TC', C.GEN_EXPN_APSTS_CD)) TIC_STS" ).append("\n"); 
		query.append("              ,MAX(DECODE(C.GEN_EXPN_APRO_STEP_CD, 'CO', C.GEN_EXPN_APSTS_CD)) COM_STS" ).append("\n"); 
		query.append("              ,C.OFC_CD" ).append("\n"); 
		query.append("              ,MAX(CASE WHEN D.GEN_EXPN_OFC_LVL = '4' AND B.OFC_CD <> D.PRNT_OFC_CD THEN D.PRNT_OFC_CD END) RHQ_OFC_CD" ).append("\n"); 
		query.append("              ,MAX(D.LOCL_CURR_CD) LOCL_CURR_CD" ).append("\n"); 
		query.append("              ,MAX(D.RQST_UT_VAL) RQST_UT_VAL" ).append("\n"); 
		query.append("              ,C.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,MAX(DECODE (@[sch_lang], 'K', E.KRN_ABBR_NM, 'E', E.ENG_ABBR_NM)) EXPN_ABBR_NM" ).append("\n"); 
		query.append("              ,MAX(E.TIC_CD) TIC_CD" ).append("\n"); 
		query.append("              ,C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("              ,MAX(B.GEN_EXPN_ITM_DESC) GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.JAN_AMT ELSE 0 END) JAN_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.FEB_AMT ELSE 0 END) FEB_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.MAR_AMT ELSE 0 END) MAR_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.APR_AMT ELSE 0 END) APR_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.MAY_AMT ELSE 0 END) MAY_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.JUN_AMT ELSE 0 END) JUN_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.JUL_AMT ELSE 0 END) JUL_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.AUG_AMT ELSE 0 END) AUG_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.SEP_AMT ELSE 0 END) SEP_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.OCT_AMT ELSE 0 END) OCT_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.NOV_AMT ELSE 0 END) NOV_AMT" ).append("\n"); 
		query.append("              ,SUM(CASE WHEN DECODE('ALL', 'RQ', 'RQ', 'HQ', 'HQ', 'TC', 'TC', 'CO', 'CO', 'ALL', B.CRNT_GEN_EXPN_APRO_STEP_CD ) = C.GEN_EXPN_APRO_STEP_CD THEN C.DEC_AMT ELSE 0 END) DEC_AMT" ).append("\n"); 
		query.append("              ,SUM(DECODE(C.GEN_EXPN_APRO_STEP_CD, 'RQ', C.JAN_AMT+C.FEB_AMT+C.MAR_AMT+C.APR_AMT+C.MAY_AMT+C.JUN_AMT+C.JUL_AMT+C.AUG_AMT+C.SEP_AMT+C.OCT_AMT+C.NOV_AMT+C.DEC_AMT, 0)) OFC_TOTAL" ).append("\n"); 
		query.append("              ,SUM(DECODE(C.GEN_EXPN_APRO_STEP_CD, 'HQ', C.JAN_AMT+C.FEB_AMT+C.MAR_AMT+C.APR_AMT+C.MAY_AMT+C.JUN_AMT+C.JUL_AMT+C.AUG_AMT+C.SEP_AMT+C.OCT_AMT+C.NOV_AMT+C.DEC_AMT, 0)) RHQlBU_TOTAL" ).append("\n"); 
		query.append("              ,SUM(DECODE(C.GEN_EXPN_APRO_STEP_CD, 'TC', C.JAN_AMT+C.FEB_AMT+C.MAR_AMT+C.APR_AMT+C.MAY_AMT+C.JUN_AMT+C.JUL_AMT+C.AUG_AMT+C.SEP_AMT+C.OCT_AMT+C.NOV_AMT+C.DEC_AMT, 0)) TIC_TOTAL" ).append("\n"); 
		query.append("              ,SUM(DECODE(C.GEN_EXPN_APRO_STEP_CD, 'CO', C.JAN_AMT+C.FEB_AMT+C.MAR_AMT+C.APR_AMT+C.MAY_AMT+C.JUN_AMT+C.JUL_AMT+C.AUG_AMT+C.SEP_AMT+C.OCT_AMT+C.NOV_AMT+C.DEC_AMT, 0)) COM_TOTAL" ).append("\n"); 
		query.append("              ,MAX(B.GEN_EXPN_CALC_BSS_DESC) GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append("              ,MAX(B.RQST_OPIN_RMK) RQST_OPIN_RMK" ).append("\n"); 
		query.append("              ,MAX(A.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("          FROM GEM_REQUEST A" ).append("\n"); 
		query.append("              ,GEM_ITEM B" ).append("\n"); 
		query.append("              ,GEM_APRO_STEP C" ).append("\n"); 
		query.append("              ,GEM_OFFICE D" ).append("\n"); 
		query.append("              ,GEM_EXPENSE E" ).append("\n"); 
		query.append("         WHERE A.PLN_YRMON LIKE @[sch_yrmon]||'%'" ).append("\n"); 
		query.append("		   AND A.GEN_EXPN_RQST_TP_CD = 'EI'" ).append("\n"); 
		query.append("           AND A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("           AND B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("           AND B.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("           AND B.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("           AND B.GEN_EXPN_ITM_NO = C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("           AND B.GEN_EXPN_TRNS_DIV_CD = C.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("           AND B.GEN_EXPN_RQST_SEQ = C.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("           AND B.OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("           AND B.GEN_EXPN_CD = E.GEN_EXPN_CD" ).append("\n"); 
		query.append("#if(${sch_app_div_gbn} != '')" ).append("\n"); 
		query.append("           AND C.GEN_EXPN_APRO_STEP_CD = @[sch_app_div_gbn]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${sch_status} != '')" ).append("\n"); 
		query.append("           AND C.GEN_EXPN_APSTS_CD = @[sch_status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_com_div} != '')" ).append("\n"); 
		query.append("           AND D.OFC_CO_DIV_CD = @[sch_com_div]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_slay_flg} != '') " ).append("\n"); 
		query.append("           AND E.SALY_FLG = @[sch_slay_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_tic_cd} != '')" ).append("\n"); 
		query.append("           AND E.TIC_CD = @[sch_tic_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("         GROUP BY C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                 ,C.OFC_CD" ).append("\n"); 
		query.append("                 ,C.GEN_EXPN_CD" ).append("\n"); 
		query.append("                 ,C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("     ,GEM_XCH_RT B" ).append("\n"); 
		query.append(" WHERE B.ACCT_XCH_RT_YRMON = @[sch_yrmon]||'00'" ).append("\n"); 
		query.append("   AND B.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("   AND B.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("#if(${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("   AND (A.OFC_CD = @[auth_ofc_cd] OR A.TIC_CD = @[auth_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("   AND (A.OFC_CD IN ( SELECT L_4 FROM GEM_OFC_LEVEL_V WHERE L_3 = @[auth_ofc_cd]) OR A.TIC_CD = @[auth_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X      " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   X.OFC_CD IN (SELECT     OFC_CD" ).append("\n"); 
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

	}
}