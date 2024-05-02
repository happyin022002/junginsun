/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchOfficeExpenseMatrixLIstByExpenseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.04.16 진윤오
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

public class GEMPlanningPerformanceDBDAOSearchOfficeExpenseMatrixLIstByExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 비용계획을 요청할수 있는 집행단위 조직이 사용할수 있는 비용코드(Expense Code)를 조회한다
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchOfficeExpenseMatrixLIstByExpenseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_lvl1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchOfficeExpenseMatrixLIstByExpenseRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${pln_yr} != '' && ${pln_mon} != '')" ).append("\n"); 
		query.append("@[pln_yr]||@[pln_mon] RSLT_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pln_yr} == '' || ${pln_mon} == '')" ).append("\n"); 
		query.append("'' RSLT_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,B.OFC_CD" ).append("\n"); 
		query.append("      ,B.GEN_EXPN_CD" ).append("\n"); 
		query.append("#if (${lang_div} == 'ENG')" ).append("\n"); 
		query.append(",D.ENG_ABBR_NM ABBR_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lang_div} == 'KOR')" ).append("\n"); 
		query.append(",D.KRN_ABBR_NM ABBR_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lang_div} == '')" ).append("\n"); 
		query.append(",'' ABBR_NM" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("      ,E.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,E.RQST_UT_VAL" ).append("\n"); 
		query.append("      ,NVL(C.PERF_AMT/E.RQST_UT_VAL,0) PERF_AMT" ).append("\n"); 
		query.append("      ,DECODE(E.RQST_UT_VAL,0,0,NULL,0,(NVL(A.INIT_AMT,0)+NVL(A.ADD_AMT,0)+NVL(A.TRNS_AMT,0))/E.RQST_UT_VAL) GEN_EXPN_AMT" ).append("\n"); 
		query.append("      ,DECODE(E.RQST_UT_VAL,0,0,NULL,0,(NVL(A.PERF_AMT,0))/E.RQST_UT_VAL) SLP_PERF_AMT" ).append("\n"); 
		query.append("      ,(DECODE(E.RQST_UT_VAL,0,0,NULL,0,(NVL(A.PERF_AMT,0))/E.RQST_UT_VAL) - NVL(C.PERF_AMT/E.RQST_UT_VAL,0)) SLP_PERF_AMT01" ).append("\n"); 
		query.append("	  ,'%' RATIO" ).append("\n"); 
		query.append("      ,GEN_EXPN_OVR_RTO_RSN " ).append("\n"); 
		query.append("      ,TO_CHAR(SYSDATE, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("	  ,C.CRE_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT OFC_CD" ).append("\n"); 
		query.append("              ,GEN_EXPN_CD              " ).append("\n"); 
		query.append("              ,SUM(GEN_EXPN_INIT_AMT) INIT_AMT" ).append("\n"); 
		query.append("              ,SUM(GEN_EXPN_ADD_AMT) ADD_AMT" ).append("\n"); 
		query.append("              ,SUM(GEN_EXPN_TRNS_AMT) TRNS_AMT" ).append("\n"); 
		query.append("              ,SUM(SLP_PERF_AMT) PERF_AMT              " ).append("\n"); 
		query.append("              ,MAX(DECODE(RSLT_YRMON, @[pln_yr]||@[pln_mon], GEN_EXPN_OVR_RTO_RSN)) GEN_EXPN_OVR_RTO_RSN" ).append("\n"); 
		query.append("          FROM GEM_RSLT_SMRY" ).append("\n"); 
		query.append("         WHERE RSLT_YRMON BETWEEN @[pln_yr]||'01' AND @[pln_yr]||@[pln_mon]" ).append("\n"); 
		query.append("		   AND OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("           AND OFC_CD IN (" ).append("\n"); 
		query.append("							SELECT OFC_CD      " ).append("\n"); 
		query.append("  							FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("							START WITH OFC_CD IN (    " ).append("\n"); 
		query.append("        						SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("          						FROM GEM_OFC_LEVEL_V A, GEM_OFFICE B" ).append("\n"); 
		query.append("         						WHERE 1=1" ).append("\n"); 
		query.append("								AND A.L_4 = B.OFC_CD" ).append("\n"); 
		query.append("                                AND B.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("		   						#if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("           						AND A.RGN_OFC_FLG LIKE @[sls_ofc_div_cd]||'%'" ).append("\n"); 
		query.append("		   						#end		" ).append("\n"); 
		query.append("		   						#if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} != '') " ).append("\n"); 
		query.append("		   						AND A.L_4 LIKE @[ofc_lvl3]||'%' " ).append("\n"); 
		query.append("		   						#end" ).append("\n"); 
		query.append("		   						#if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   						AND A.L_3 LIKE @[ofc_lvl2]||'%' " ).append("\n"); 
		query.append("		   						#end" ).append("\n"); 
		query.append("		   						#if(${ofc_lvl1} != '' && ${ofc_lvl2} == '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   						AND A.L_2 LIKE @[ofc_lvl1]||'%' " ).append("\n"); 
		query.append("		   						#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("    					)" ).append("\n"); 
		query.append("            GROUP BY OFC_CD, GEN_EXPN_CD " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,( SELECT OFC_CD" ).append("\n"); 
		query.append("               ,GEN_EXPN_CD" ).append("\n"); 
		query.append("           FROM GEM_OFC_MTX" ).append("\n"); 
		query.append("          WHERE OFC_CD IN (" ).append("\n"); 
		query.append("							SELECT OFC_CD      " ).append("\n"); 
		query.append("  							FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("							START WITH OFC_CD IN (    " ).append("\n"); 
		query.append("        						SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("          						FROM GEM_OFC_LEVEL_V A, GEM_OFFICE B" ).append("\n"); 
		query.append("         						WHERE 1=1" ).append("\n"); 
		query.append("								AND A.L_4 = B.OFC_CD" ).append("\n"); 
		query.append("                                AND B.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("		   						#if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("           						AND A.RGN_OFC_FLG LIKE @[sls_ofc_div_cd]||'%'" ).append("\n"); 
		query.append("		   						#end		" ).append("\n"); 
		query.append("		   						#if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} != '') " ).append("\n"); 
		query.append("		   						AND A.L_4 LIKE @[ofc_lvl3]||'%' " ).append("\n"); 
		query.append("		   						#end" ).append("\n"); 
		query.append("		   						#if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   						AND A.L_3 LIKE @[ofc_lvl2]||'%' " ).append("\n"); 
		query.append("		   						#end" ).append("\n"); 
		query.append("		   						#if(${ofc_lvl1} != '' && ${ofc_lvl2} == '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   						AND A.L_2 LIKE @[ofc_lvl1]||'%' " ).append("\n"); 
		query.append("		   						#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("    						)" ).append("\n"); 
		query.append("          AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("      ,( SELECT OFC_CD" ).append("\n"); 
		query.append("               ,GEN_EXPN_CD              " ).append("\n"); 
		query.append("               ,PERF_AMT " ).append("\n"); 
		query.append("			   ,CRE_USR_ID" ).append("\n"); 
		query.append("           FROM GEM_SUBS_PERF" ).append("\n"); 
		query.append("          WHERE RSLT_YRMON = @[pln_yr]||@[pln_mon]" ).append("\n"); 
		query.append("            AND OFC_CD IN (" ).append("\n"); 
		query.append("							SELECT OFC_CD      " ).append("\n"); 
		query.append("  							FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("							START WITH OFC_CD IN (    " ).append("\n"); 
		query.append("        						SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("          						FROM GEM_OFC_LEVEL_V A, GEM_OFFICE B" ).append("\n"); 
		query.append("         						WHERE 1=1" ).append("\n"); 
		query.append("								AND A.L_4 = B.OFC_CD" ).append("\n"); 
		query.append("                                AND B.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("		   						#if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("           						AND A.RGN_OFC_FLG LIKE @[sls_ofc_div_cd]||'%'" ).append("\n"); 
		query.append("		   						#end		" ).append("\n"); 
		query.append("		   						#if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} != '') " ).append("\n"); 
		query.append("		   						AND A.L_4 LIKE @[ofc_lvl3]||'%' " ).append("\n"); 
		query.append("		   						#end" ).append("\n"); 
		query.append("		   						#if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   						AND A.L_3 LIKE @[ofc_lvl2]||'%' " ).append("\n"); 
		query.append("		   						#end" ).append("\n"); 
		query.append("		   						#if(${ofc_lvl1} != '' && ${ofc_lvl2} == '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   						AND A.L_2 LIKE @[ofc_lvl1]||'%' " ).append("\n"); 
		query.append("		   						#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("    						)" ).append("\n"); 
		query.append("       ) C  " ).append("\n"); 
		query.append("      ,GEM_EXPENSE D " ).append("\n"); 
		query.append("      ,GEM_OFFICE E     " ).append("\n"); 
		query.append(" WHERE B.OFC_CD = A.OFC_CD(+)" ).append("\n"); 
		query.append("   AND B.GEN_EXPN_CD = A.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("   AND B.OFC_CD = C.OFC_CD(+)" ).append("\n"); 
		query.append("   AND B.GEN_EXPN_CD = C.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("   AND B.GEN_EXPN_CD = D.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("   AND B.OFC_CD = E.OFC_CD(+)" ).append("\n"); 
		query.append("#if (${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("   AND D.TIC_CD LIKE @[login_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("   AND D.TIC_CD LIKE @[login_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RSLT_YRMON, OFC_CD, GEN_EXPN_CD" ).append("\n"); 

	}
}