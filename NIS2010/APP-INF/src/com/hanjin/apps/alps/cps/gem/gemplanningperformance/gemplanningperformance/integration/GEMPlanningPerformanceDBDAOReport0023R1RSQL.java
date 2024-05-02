/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOReport0023R1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.08.14 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOReport0023R1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * init 레포트 Query1
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOReport0023R1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_expn_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_xch_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOReport0023R1RSQL").append("\n"); 
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
		query.append("SELECT A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append(",B.GEM_EXPN_GRP_CD1" ).append("\n"); 
		query.append(",B.GEM_EXPN_GRP_CD2" ).append("\n"); 
		query.append(",DECODE (@[lang_div], 'KOR', B.KRN_ABBR_NM_1, B.ENG_ABBR_NM_1) EXPN_GRP_ABBR_NM1" ).append("\n"); 
		query.append(",DECODE (@[lang_div], 'KOR', B.KRN_ABBR_NM_2, B.ENG_ABBR_NM_2) EXPN_GRP_ABBR_NM2" ).append("\n"); 
		query.append(",A.GEN_EXPN_CD" ).append("\n"); 
		query.append(",A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append(",A.GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append(",A.GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append(",A.RQST_OPIN_RMK" ).append("\n"); 
		query.append(",A.JAN_AMT ASG_JAN_AMT" ).append("\n"); 
		query.append(",A.FEB_AMT ASG_FEB_AMT" ).append("\n"); 
		query.append(",A.MAR_AMT ASG_MAR_AMT" ).append("\n"); 
		query.append(",A.APR_AMT ASG_APR_AMT" ).append("\n"); 
		query.append(",A.MAY_AMT ASG_MAY_AMT" ).append("\n"); 
		query.append(",A.JUN_AMT ASG_JUN_AMT" ).append("\n"); 
		query.append(",A.JUL_AMT ASG_JUL_AMT" ).append("\n"); 
		query.append(",A.AUG_AMT ASG_AUG_AMT" ).append("\n"); 
		query.append(",A.SEP_AMT ASG_SEP_AMT" ).append("\n"); 
		query.append(",A.OCT_AMT ASG_OCT_AMT" ).append("\n"); 
		query.append(",A.NOV_AMT ASG_NOV_AMT" ).append("\n"); 
		query.append(",A.DEC_AMT ASG_DEC_AMT" ).append("\n"); 
		query.append(",(  A.JAN_AMT" ).append("\n"); 
		query.append("+ A.FEB_AMT" ).append("\n"); 
		query.append("+ A.MAR_AMT" ).append("\n"); 
		query.append("+ A.APR_AMT" ).append("\n"); 
		query.append("+ A.MAY_AMT" ).append("\n"); 
		query.append("+ A.JUN_AMT" ).append("\n"); 
		query.append("+ A.JUL_AMT" ).append("\n"); 
		query.append("+ A.AUG_AMT" ).append("\n"); 
		query.append("+ A.SEP_AMT" ).append("\n"); 
		query.append("+ A.OCT_AMT" ).append("\n"); 
		query.append("+ A.NOV_AMT" ).append("\n"); 
		query.append("+ A.DEC_AMT ) ASG_SUM_AMT" ).append("\n"); 
		query.append(",G.RQST_OFC_CD" ).append("\n"); 
		query.append(",DECODE(  F.GEN_EXPN_APRO_STEP_CD , 'RQ', (  F.JAN_AMT" ).append("\n"); 
		query.append("+ F.FEB_AMT" ).append("\n"); 
		query.append("+ F.MAR_AMT" ).append("\n"); 
		query.append("+ F.APR_AMT" ).append("\n"); 
		query.append("+ F.MAY_AMT" ).append("\n"); 
		query.append("+ F.JUN_AMT" ).append("\n"); 
		query.append("+ F.JUL_AMT" ).append("\n"); 
		query.append("+ F.AUG_AMT" ).append("\n"); 
		query.append("+ F.SEP_AMT" ).append("\n"); 
		query.append("+ F.OCT_AMT" ).append("\n"); 
		query.append("+ F.NOV_AMT" ).append("\n"); 
		query.append("+ F.DEC_AMT" ).append("\n"); 
		query.append(")  , 0 ) SUM_AMT" ).append("\n"); 
		query.append(",DECODE(  F.GEN_EXPN_APRO_STEP_CD , A.CRNT_GEN_EXPN_APRO_STEP_CD, ( F.JAN_AMT" ).append("\n"); 
		query.append("+ F.FEB_AMT" ).append("\n"); 
		query.append("+ F.MAR_AMT" ).append("\n"); 
		query.append("+ F.APR_AMT" ).append("\n"); 
		query.append("+ F.MAY_AMT" ).append("\n"); 
		query.append("+ F.JUN_AMT" ).append("\n"); 
		query.append("+ F.JUL_AMT" ).append("\n"); 
		query.append("+ F.AUG_AMT" ).append("\n"); 
		query.append("+ F.SEP_AMT" ).append("\n"); 
		query.append("+ F.OCT_AMT" ).append("\n"); 
		query.append("+ F.NOV_AMT" ).append("\n"); 
		query.append("+ F.DEC_AMT" ).append("\n"); 
		query.append(")  , 0 ) AD_AMT" ).append("\n"); 
		query.append(",C.LOCL_CURR_CD" ).append("\n"); 
		query.append(",C.RQST_UT_VAL" ).append("\n"); 
		query.append(",D.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append(",D.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append(",D.LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append(",E.TIC_CD" ).append("\n"); 
		query.append(",F.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append(",F.OFC_CD" ).append("\n"); 
		query.append(",F.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append(",DECODE (@[lang_div], 'KOR', E.KRN_ABBR_NM, E.ENG_ABBR_NM) EXPN_ABBR_NM" ).append("\n"); 
		query.append(",'0' USD_AMT" ).append("\n"); 
		query.append("FROM   GEM_ITEM A, GEM_EXPN_GRP_V B, GEM_OFFICE C, GEM_XCH_RT D, GEM_EXPENSE E, GEM_APRO_STEP F, GEM_REQUEST G" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_CD = E.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND    A.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND    D.ACCT_XCH_RT_YRMON(+) =    @[acct_xch_rt_yrmon] || '00'" ).append("\n"); 
		query.append("AND    D.CURR_CD(+) = C.LOCL_CURR_CD" ).append("\n"); 
		query.append("AND    D.GEN_EXPN_XCH_RT_DIV_CD(+) = 'I'" ).append("\n"); 
		query.append("AND    F.GEN_EXPN_RQST_NO = A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND    G.GEN_EXPN_RQST_NO = A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND    F.OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("AND    F.GEN_EXPN_CD = A.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND    F.GEN_EXPN_ITM_NO = A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("AND    F.GEN_EXPN_TRNS_DIV_CD = A.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("AND    F.GEN_EXPN_RQST_SEQ = A.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("AND    F.GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("#if (${gen_expn_rqst_seq} != '')" ).append("\n"); 
		query.append("AND    A.GEN_EXPN_RQST_SEQ = @[gen_expn_rqst_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("B.GEM_EXPN_GRP_CD1 ," ).append("\n"); 
		query.append("F.GEN_EXPN_RQST_SEQ ," ).append("\n"); 
		query.append("F.GEN_EXPN_TRNS_DIV_CD ," ).append("\n"); 
		query.append("A.GEN_EXPN_CD," ).append("\n"); 
		query.append("SUM_AMT" ).append("\n"); 

	}
}