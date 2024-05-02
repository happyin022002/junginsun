/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchSlipInqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.17
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.05.17 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchSlipInqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP 에서 I/F 받은 전표 정보 조회
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchSlipInqRSQL(){
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
		params.put("slp_tj_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sch_expense_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_tic_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchSlipInqRSQL").append("\n"); 
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
		query.append(" SLP_TJ_NO" ).append("\n"); 
		query.append(",SLP_TJ_NO1" ).append("\n"); 
		query.append(",SLP_SEQ_NO" ).append("\n"); 
		query.append(",SLP_SEQ_NO1" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",SUB_OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",ABBR_NM" ).append("\n"); 
		query.append(",SUB_GEN_EXPN_CD" ).append("\n"); 
		query.append(",SUB_ABBR_NM" ).append("\n"); 
		query.append(",TIC_CD" ).append("\n"); 
		query.append(",TIC_CD1" ).append("\n"); 
		query.append(",SLP_CURR_CD" ).append("\n"); 
		query.append(",SLP_CURR_CD1" ).append("\n"); 
		query.append(",GL_EFF_DT" ).append("\n"); 
		query.append(",GL_EFF_DT1" ).append("\n"); 
		query.append(",SLP_AMT" ).append("\n"); 
		query.append(",SLP_AMT1" ).append("\n"); 
		query.append(",GEN_EXPN_FNL_LOCL_AMT" ).append("\n"); 
		query.append(",SLP_PERF_AMT" ).append("\n"); 
		query.append(",SLP_DESC" ).append("\n"); 
		query.append(",SLP_DESC1" ).append("\n"); 
		query.append(",RATIO" ).append("\n"); 
		query.append(",RATIO1" ).append("\n"); 
		query.append(",TOTAL" ).append("\n"); 
		query.append(",ROW_NUM" ).append("\n"); 
		query.append(",SLP_VNDR_CD" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.SLP_TJ_NO, A.SLP_TJ_NO SLP_TJ_NO1, A.SLP_SEQ_NO, A.SLP_SEQ_NO SLP_SEQ_NO1, A.OFC_CD, A.SUB_OFC_CD, A.GEN_EXPN_CD, " ).append("\n"); 
		query.append("#if (${sch_lang} == 'E')" ).append("\n"); 
		query.append("B.ENG_ABBR_NM ABBR_NM, " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_lang} == 'K')" ).append("\n"); 
		query.append("B.KRN_ABBR_NM ABBR_NM, " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_lang} == '')" ).append("\n"); 
		query.append("'' ABBR_NM," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("A.SUB_GEN_EXPN_CD" ).append("\n"); 
		query.append(", (SELECT " ).append("\n"); 
		query.append("#if (${sch_lang} == 'E')" ).append("\n"); 
		query.append("ENG_ABBR_NM ABBR_NM " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_lang} == 'K')" ).append("\n"); 
		query.append("KRN_ABBR_NM ABBR_NM " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_lang} == '')" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM GEM_EXPENSE WHERE GEN_EXPN_CD = A.SUB_GEN_EXPN_CD) SUB_ABBR_NM" ).append("\n"); 
		query.append(", B.TIC_CD, B.TIC_CD TIC_CD1" ).append("\n"); 
		query.append(", DECODE(@[ofc_cur], 'Slip', A.SLP_CURR_CD, 'USD', 'USD', 'KRW', 'KRW' ) SLP_CURR_CD" ).append("\n"); 
		query.append(", DECODE(@[ofc_cur], 'Slip', A.SLP_CURR_CD, 'USD', 'USD', 'KRW', 'KRW' ) SLP_CURR_CD1" ).append("\n"); 
		query.append(", A.GL_EFF_DT, A.GL_EFF_DT GL_EFF_DT1" ).append("\n"); 
		query.append(", DECODE(@[ofc_cur], 'Slip', A.SLP_AMT, 'USD', (SELECT A.SLP_AMT/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON AND GEN_EXPN_XCH_RT_DIV_CD = 'M' AND CURR_CD = A.SLP_CURR_CD), 'KRW', (SELECT (A.SLP_AMT/USD_LOCL_XCH_RT)*USD_KRW_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON AND GEN_EXPN_XCH_RT_DIV_CD = 'M' AND CURR_CD = A.SLP_CURR_CD) ) SLP_AMT" ).append("\n"); 
		query.append(", DECODE(@[ofc_cur], 'Slip', A.SLP_AMT, 'USD', (SELECT A.SLP_AMT/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON AND GEN_EXPN_XCH_RT_DIV_CD = 'M' AND CURR_CD = A.SLP_CURR_CD), 'KRW', (SELECT (A.SLP_AMT/USD_LOCL_XCH_RT)*USD_KRW_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON AND GEN_EXPN_XCH_RT_DIV_CD = 'M' AND CURR_CD = A.SLP_CURR_CD) ) SLP_AMT1" ).append("\n"); 
		query.append(", DECODE(@[ofc_cur], 'Slip', A.GEN_EXPN_FNL_LOCL_AMT, 'USD', (SELECT A.GEN_EXPN_FNL_LOCL_AMT/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON AND GEN_EXPN_XCH_RT_DIV_CD = 'M' AND CURR_CD = A.SLP_CURR_CD), 'KRW', (SELECT (A.GEN_EXPN_FNL_LOCL_AMT/USD_LOCL_XCH_RT)*USD_KRW_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON AND GEN_EXPN_XCH_RT_DIV_CD = 'M' AND CURR_CD = A.SLP_CURR_CD) ) GEN_EXPN_FNL_LOCL_AMT" ).append("\n"); 
		query.append(", DECODE(@[ofc_cur], 'Slip', A.SLP_PERF_AMT, 'USD', (SELECT A.SLP_PERF_AMT/USD_LOCL_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON AND GEN_EXPN_XCH_RT_DIV_CD = 'M' AND CURR_CD = A.SLP_CURR_CD), 'KRW', (SELECT (A.SLP_PERF_AMT/USD_LOCL_XCH_RT)*USD_KRW_XCH_RT FROM GEM_XCH_RT WHERE ACCT_XCH_RT_YRMON = A.RSLT_YRMON AND GEN_EXPN_XCH_RT_DIV_CD = 'M' AND CURR_CD = A.SLP_CURR_CD) ) SLP_PERF_AMT" ).append("\n"); 
		query.append(", A.SLP_DESC, A.SLP_DESC SLP_DESC1" ).append("\n"); 
		query.append(", TO_NUMBER(ROUND(DECODE(A.GEN_EXPN_FNL_LOCL_AMT,NULL,0,0,0,A.SLP_PERF_AMT/A.GEN_EXPN_FNL_LOCL_AMT)*100,2)) RATIO" ).append("\n"); 
		query.append(", TO_NUMBER(ROUND(DECODE(A.GEN_EXPN_FNL_LOCL_AMT,NULL,0,0,0,A.SLP_PERF_AMT/A.GEN_EXPN_FNL_LOCL_AMT)*100,2)) RATIO1" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER(ORDER BY A.SLP_TJ_NO, A.SLP_SEQ_NO, A.OFC_CD, A.SUB_OFC_CD, A.GEN_EXPN_CD, A.SUB_GEN_EXPN_CD) ROW_NUM" ).append("\n"); 
		query.append(", COUNT(*) OVER() TOTAL" ).append("\n"); 
		query.append(", A.ACCT_CD" ).append("\n"); 
		query.append(", A.SLP_VNDR_CD" ).append("\n"); 
		query.append("FROM GEM_SLP_PERF A, GEM_EXPENSE B, GEM_EXPN_GRP_V C" ).append("\n"); 
		query.append("WHERE A.GEN_EXPN_CD = B.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = C.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slp_tj_no} != '') " ).append("\n"); 
		query.append("AND A.SLP_TJ_NO = @[slp_tj_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sch_expense_group} != '') " ).append("\n"); 
		query.append("AND C.GEM_EXPN_GRP_CD1 = @[sch_expense_group]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD BETWEEN DECODE (@[sch_expense_from], '', '111111', @[sch_expense_from]) AND DECODE (@[sch_expense_to], '', '999999', @[sch_expense_to])" ).append("\n"); 
		query.append("#if(${sch_tic_cd} != '')" ).append("\n"); 
		query.append("AND B.TIC_CD = @[sch_tic_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.RSLT_YRMON BETWEEN @[from_rslt_yrmon] AND @[to_rslt_yrmon]" ).append("\n"); 
		query.append("#if(${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("AND (A.OFC_CD = @[login_office] OR C.TIC_CD = @[login_office] )" ).append("\n"); 
		query.append("#elseif(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("AND ( A.OFC_CD IN ( SELECT L_4 FROM GEM_OFC_LEVEL_V WHERE L_3 = @[login_office] ) OR C.TIC_CD = @[login_office] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sls_ofc_div_cd} != '' || ${ofc_expn_cd} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CD in (" ).append("\n"); 
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
		query.append(")" ).append("\n"); 
		query.append("#if (${start_page} != '') " ).append("\n"); 
		query.append("WHERE ROW_NUM BETWEEN ${start_page} AND ${end_page}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}