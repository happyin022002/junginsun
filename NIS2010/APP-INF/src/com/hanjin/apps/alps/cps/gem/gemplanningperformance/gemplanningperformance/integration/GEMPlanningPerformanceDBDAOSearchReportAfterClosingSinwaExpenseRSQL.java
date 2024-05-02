/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchReportAfterClosingSinwaExpenseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
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

public class GEMPlanningPerformanceDBDAOSearchReportAfterClosingSinwaExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchReportAfterClosingSinwaExpenseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchReportAfterClosingSinwaExpenseRSQL").append("\n"); 
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
		query.append("SELECT A.RSLT_YRMON      " ).append("\n"); 
		query.append("      ,DECODE(SUBSTR(A.RSLT_YRMON,5,2),'01','Jan','02','Feb','03','Mar','04','Apr','05','May','06','Jun','07','Jul','08','Aug','09','Sep','10','Oct','11','Nov','12','Dec')||'-'||SUBSTR(A.RSLT_YRMON,3,2) RSLT_YRMON01" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,DECODE('K','K',C.KRN_ABBR_NM, C.ENG_ABBR_NM) AS ABBR_NM" ).append("\n"); 
		query.append("      ,B.PRNT_OFC_CD AS L_3" ).append("\n"); 
		query.append("      ,A.OFC_CD" ).append("\n"); 
		query.append("      ,B.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,B.RQST_UT_VAL" ).append("\n"); 
		query.append("      ,DECODE(C.SALY_FLG,'Y','급여성','N','비급여성') AS SAL_TYPE" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_INIT_AMT + A.GEN_EXPN_ADD_AMT + A.GEN_EXPN_TRNS_AMT AS LCL_SAL " ).append("\n"); 
		query.append("  FROM GEM_RSLT_SMRY A" ).append("\n"); 
		query.append("      ,GEM_OFFICE B" ).append("\n"); 
		query.append("      ,GEM_EXPENSE C" ).append("\n"); 
		query.append(" WHERE A.RSLT_YRMON BETWEEN @[from_rslt_yrmon] AND @[to_rslt_yrmon]" ).append("\n"); 
		query.append("   AND A.OFC_CO_DIV_CD = 'O'   " ).append("\n"); 
		query.append("   AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("   AND B.PRNT_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("   AND B.RGN_OFC_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("ORDER BY A.RSLT_YRMON" ).append("\n"); 
		query.append("        ,A.OFC_CD " ).append("\n"); 
		query.append("        ,A.GEN_EXPN_CD" ).append("\n"); 

	}
}