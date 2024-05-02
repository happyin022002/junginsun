/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchSubsidiaryActualResultsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.09.01 박창준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK CHANG JUNE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchSubsidiaryActualResultsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현지법인의 실적을 월별로 조회한다
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchSubsidiaryActualResultsRSQL(){
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
		params.put("lang_div",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchSubsidiaryActualResultsRSQL").append("\n"); 
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
		query.append("SELECT A.RSLT_YRMON" ).append("\n"); 
		query.append(",A.OFC_CD" ).append("\n"); 
		query.append(",A.GEN_EXPN_CD" ).append("\n"); 
		query.append(",DECODE(@[lang_div], 'KOR', C.KRN_ABBR_NM, 'ENG', C.ENG_ABBR_NM) ABBR_NM" ).append("\n"); 
		query.append(",B.LOCL_CURR_CD" ).append("\n"); 
		query.append(",B.RQST_UT_VAL" ).append("\n"); 
		query.append(",A.PERF_AMT" ).append("\n"); 
		query.append(",(A.GEN_EXPN_AMT/B.RQST_UT_VAL) GEN_EXPN_AMT" ).append("\n"); 
		query.append(",(A.SLP_PERF_AMT/B.RQST_UT_VAL) SLP_PERF_AMT" ).append("\n"); 
		query.append(",((A.SLP_PERF_AMT/B.RQST_UT_VAL)-A.PERF_AMT) SLP_PERF_AMT01" ).append("\n"); 
		query.append(",'%' RATIO" ).append("\n"); 
		query.append(",A.GEN_EXPN_OVR_RTO_RSN" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append(",A.CRE_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT @[pln_yr]||@[pln_mon] RSLT_YRMON" ).append("\n"); 
		query.append(",A.OFC_CD" ).append("\n"); 
		query.append(",A.GEN_EXPN_CD" ).append("\n"); 
		query.append(",SUM(NVL(B.PERF_AMT,0)) PERF_AMT" ).append("\n"); 
		query.append(",SUM(A.GEN_EXPN_AMT) GEN_EXPN_AMT" ).append("\n"); 
		query.append(",SUM(A.SLP_PERF_AMT) SLP_PERF_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(A.RSLT_YRMON, @[pln_yr]||@[pln_mon], A.GEN_EXPN_OVR_RTO_RSN)) GEN_EXPN_OVR_RTO_RSN" ).append("\n"); 
		query.append(",MAX(NVL(DECODE(B.RSLT_YRMON, @[pln_yr]||@[pln_mon], B.UPD_DT), A.UPD_DT)) CRE_DT" ).append("\n"); 
		query.append(",MAX(B.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT RSLT_YRMON" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",SUM(GEN_EXPN_INIT_AMT + GEN_EXPN_ADD_AMT + GEN_EXPN_TRNS_AMT) GEN_EXPN_AMT" ).append("\n"); 
		query.append(",SUM(SLP_PERF_AMT) SLP_PERF_AMT" ).append("\n"); 
		query.append(",MAX(GEN_EXPN_OVR_RTO_RSN) GEN_EXPN_OVR_RTO_RSN" ).append("\n"); 
		query.append(",MAX(UPD_DT) UPD_DT" ).append("\n"); 
		query.append("FROM GEM_RSLT_SMRY" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${pln_yr} != '' && ${pln_mon} != '')" ).append("\n"); 
		query.append("AND RSLT_YRMON BETWEEN @[pln_yr]||'01' AND @[pln_yr]||@[pln_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("GROUP BY RSLT_YRMON" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT RSLT_YRMON" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",PERF_AMT" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append("FROM GEM_SUBS_PERF" ).append("\n"); 
		query.append("WHERE RSLT_YRMON = @[pln_yr]||@[pln_mon]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.RSLT_YRMON  = B.RSLT_YRMON(+)" ).append("\n"); 
		query.append("AND A.OFC_CD      = B.OFC_CD(+)" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = B.GEN_EXPN_CD(+)" ).append("\n"); 
		query.append("GROUP BY @[pln_yr]||@[pln_mon]" ).append("\n"); 
		query.append(",A.OFC_CD" ).append("\n"); 
		query.append(",A.GEN_EXPN_CD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",GEM_OFFICE B" ).append("\n"); 
		query.append(",GEM_EXPENSE C" ).append("\n"); 
		query.append("WHERE A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND A.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("#if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD in (" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("START WITH OFC_CD IN (" ).append("\n"); 
		query.append("SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("FROM GEM_OFC_LEVEL_V A, GEM_OFFICE B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.L_4 = B.OFC_CD" ).append("\n"); 
		query.append("AND B.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("#if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("AND A.RGN_OFC_FLG LIKE @[sls_ofc_div_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} != '')" ).append("\n"); 
		query.append("AND A.L_4 LIKE @[ofc_lvl3]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} == '')" ).append("\n"); 
		query.append("AND A.L_3 LIKE @[ofc_lvl2]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ofc_lvl1} != '' && ${ofc_lvl2} == '' && ${ofc_lvl3} == '')" ).append("\n"); 
		query.append("AND A.L_2 LIKE @[ofc_lvl1]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.OFC_CD" ).append("\n"); 
		query.append(",A.GEN_EXPN_CD" ).append("\n"); 

	}
}