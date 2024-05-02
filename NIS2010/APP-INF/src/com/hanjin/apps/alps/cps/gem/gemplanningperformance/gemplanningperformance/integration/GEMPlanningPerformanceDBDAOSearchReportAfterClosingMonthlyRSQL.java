/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchReportAfterClosingMonthlyRSQL.java
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

public class GEMPlanningPerformanceDBDAOSearchReportAfterClosingMonthlyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchReportAfterClosingMonthlyRSQL(){
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
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchReportAfterClosingMonthlyRSQL").append("\n"); 
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
		query.append("SELECT RSLT_YRMON" ).append("\n"); 
		query.append("      ,DECODE(SUBSTR(RSLT_YRMON,5,2),'01','Jan','02','Feb','03','Mar','04','Apr','05','May','06','Jun','07','Jul','08','Aug','09','Sep','10','Oct','11','Nov','12','Dec')||'-'||SUBSTR(RSLT_YRMON,3,2) RSLT_YRMON01" ).append("\n"); 
		query.append("      ,L_3" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("      ,LCL_SAL" ).append("\n"); 
		query.append("      ,LCL_NON_SAL" ).append("\n"); 
		query.append("      ,USD_SAL" ).append("\n"); 
		query.append("      ,USD_NON_SAL" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.RSLT_YRMON      " ).append("\n"); 
		query.append("              ,B.PRNT_OFC_CD AS L_3" ).append("\n"); 
		query.append("              ,A.OFC_CD" ).append("\n"); 
		query.append("              ,B.LOCL_CURR_CD" ).append("\n"); 
		query.append("              ,MAX(C.USD_LOCL_XCH_RT) AS USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("              ,SUM(DECODE(D.SALY_FLG, 'Y', A.GEN_EXPN_INIT_AMT/B.RQST_UT_VAL, 0)) + SUM(DECODE(D.SALY_FLG, 'Y', A.GEN_EXPN_ADD_AMT/B.RQST_UT_VAL, 0)) + SUM(DECODE(D.SALY_FLG, 'Y', A.GEN_EXPN_TRNS_AMT/B.RQST_UT_VAL, 0)) AS LCL_SAL" ).append("\n"); 
		query.append("              ,SUM(DECODE(D.SALY_FLG, 'N', A.GEN_EXPN_INIT_AMT/B.RQST_UT_VAL, 0)) + SUM(DECODE(D.SALY_FLG, 'N', A.GEN_EXPN_ADD_AMT/B.RQST_UT_VAL, 0)) + SUM(DECODE(D.SALY_FLG, 'N', A.GEN_EXPN_TRNS_AMT/B.RQST_UT_VAL, 0)) AS LCL_NON_SAL" ).append("\n"); 
		query.append("              ,SUM(DECODE(D.SALY_FLG, 'Y', A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT, 0)) + SUM(DECODE(D.SALY_FLG, 'Y', A.GEN_EXPN_ADD_AMT/C.USD_LOCL_XCH_RT, 0)) + SUM(DECODE(D.SALY_FLG, 'Y', A.GEN_EXPN_TRNS_AMT/C.USD_LOCL_XCH_RT, 0)) AS USD_SAL" ).append("\n"); 
		query.append("              ,SUM(DECODE(D.SALY_FLG, 'N', A.GEN_EXPN_INIT_AMT/C.USD_LOCL_XCH_RT, 0)) + SUM(DECODE(D.SALY_FLG, 'N', A.GEN_EXPN_ADD_AMT/C.USD_LOCL_XCH_RT, 0)) + SUM(DECODE(D.SALY_FLG, 'N', A.GEN_EXPN_TRNS_AMT/C.USD_LOCL_XCH_RT, 0)) AS USD_NON_SAL" ).append("\n"); 
		query.append("          FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("              ,GEM_OFFICE B" ).append("\n"); 
		query.append("              ,GEM_XCH_RT C" ).append("\n"); 
		query.append("              ,GEM_EXPENSE D" ).append("\n"); 
		query.append("              ,GEM_EXPN_GRP_V E" ).append("\n"); 
		query.append("         WHERE A.RSLT_YRMON BETWEEN @[from_rslt_yrmon] AND @[to_rslt_yrmon]" ).append("\n"); 
		query.append("           AND A.OFC_CO_DIV_CD = 'O'   " ).append("\n"); 
		query.append("           AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("           AND B.RGN_OFC_FLG = 'Y'" ).append("\n"); 
		query.append("           AND A.RSLT_YRMON = C.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("           AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("           AND C.GEN_EXPN_XCH_RT_DIV_CD = 'M' " ).append("\n"); 
		query.append("           AND A.GEN_EXPN_CD = D.GEN_EXPN_CD" ).append("\n"); 
		query.append("           AND A.GEN_EXPN_CD BETWEEN DECODE (@[sch_expense_from], '', '111111', @[sch_expense_from]) AND DECODE (@[sch_expense_to], '', '999999', @[sch_expense_to])" ).append("\n"); 
		query.append("           AND A.GEN_EXPN_CD = E.GEN_EXPN_CD" ).append("\n"); 
		query.append("           #if (${sch_expense_group} != '') " ).append("\n"); 
		query.append("           AND E.GEM_EXPN_GRP_CD1 = @[sch_expense_group]" ).append("\n"); 
		query.append("           #end           " ).append("\n"); 
		query.append("           #if(${sch_tic_cd} != '')" ).append("\n"); 
		query.append("           AND E.TIC_CD = @[sch_tic_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        GROUP BY A.RSLT_YRMON      " ).append("\n"); 
		query.append("              ,B.PRNT_OFC_CD" ).append("\n"); 
		query.append("              ,B.LOCL_CURR_CD" ).append("\n"); 
		query.append("              ,A.OFC_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#if(${sls_ofc_div_cd} != '' || ${ofc_expn_cd} != '')" ).append("\n"); 
		query.append("   WHERE OFC_CD IN (" ).append("\n"); 
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
		query.append("ORDER BY RSLT_YRMON" ).append("\n"); 
		query.append("        ,L_3" ).append("\n"); 
		query.append("        ,OFC_CD" ).append("\n"); 

	}
}