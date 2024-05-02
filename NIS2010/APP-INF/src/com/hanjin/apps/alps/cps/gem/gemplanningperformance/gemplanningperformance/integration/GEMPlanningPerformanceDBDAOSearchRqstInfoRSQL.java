/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchRqstInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.08.27 박창준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK CHANG JUNE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchRqstInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 유형별(계획비용,추가배정,예산이관) Request 요청된 정보를 상세조회한다
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchRqstInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_trns_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchRqstInfoRSQL").append("\n"); 
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
		query.append(",A.GEN_EXPN_RQST_NO GEN_EXPN_RQST_NO1" ).append("\n"); 
		query.append(",A.GEN_EXPN_RQST_NO GEN_EXPN_RQST_NO2" ).append("\n"); 
		query.append(",A.GEN_EXPN_RQST_NO GEN_EXPN_RQST_NO3" ).append("\n"); 
		query.append(",A.GEN_EXPN_RQST_NO GEN_EXPN_RQST_NO4" ).append("\n"); 
		query.append(",MAX(A.GEN_EXPN_CD) GEN_EXPN_CD" ).append("\n"); 
		query.append(",MAX(A.GEN_EXPN_RQST_SEQ) GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append(", 'Office' FIELD_ONE" ).append("\n"); 
		query.append(", 'Expense' FIELD_TWO" ).append("\n"); 
		query.append(", 'Office' FIELD_TREE" ).append("\n"); 
		query.append(", 'Expense' FIELD_FOUR" ).append("\n"); 
		query.append(", 'CUR' FIELD_ONE1" ).append("\n"); 
		query.append(", 'UNIT' FIELD_TWO1" ).append("\n"); 
		query.append(", 'CUR' FIELD_TREE1" ).append("\n"); 
		query.append(", 'UNIT' FIELD_FOUR1" ).append("\n"); 
		query.append(", 'RQST AMT' FIELD_ONE2" ).append("\n"); 
		query.append(",NVL(MAX (CASE" ).append("\n"); 
		query.append("WHEN A.GEN_EXPN_TRNS_DIV_CD = 'F'" ).append("\n"); 
		query.append("AND     A.GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("THEN   A.JAN_AMT" ).append("\n"); 
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
		query.append("+ A.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("),0) FIELD_TWO2" ).append("\n"); 
		query.append(", 'RQST AMT' FIELD_TREE2" ).append("\n"); 
		query.append(",NVL(MAX (CASE" ).append("\n"); 
		query.append("WHEN A.GEN_EXPN_TRNS_DIV_CD = 'T'" ).append("\n"); 
		query.append("AND     A.GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("THEN   A.JAN_AMT" ).append("\n"); 
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
		query.append("+ A.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("),0) FIELD_FOUR2" ).append("\n"); 
		query.append(", 'Item NO' FIELD_ONE3" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_ITM_NO, '  ')) FIELD_TWO3" ).append("\n"); 
		query.append(", 'Item NO' FIELD_TREE3" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_ITM_NO, '  ')) FIELD_FOUR3" ).append("\n"); 
		query.append(", 'Item' FIELD_ONE4" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_ITM_DESC, ' ')) FIELD_TWO4" ).append("\n"); 
		query.append(", 'Item' FIELD_TREE4" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_ITM_DESC, ' ')) FIELD_FOUR4" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'F', A.GEN_EXPN_CD, '')) FM_GEN_EXPN_CD" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'T', A.GEN_EXPN_CD, '')) TO_GEN_EXPN_CD" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'F', A.OFC_CD, '')) FM_OFC_CD" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'T', A.OFC_CD, '')) TO_OFC_CD" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'F', D.LOCL_CURR_CD, '')) FM_LOCL_CURR_CD" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'T', D.LOCL_CURR_CD, '')) TO_LOCL_CURR_CD" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'F', D.RQST_UT_VAL, '')) FM_RQST_UT_VAL" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'T', D.RQST_UT_VAL, '')) TO_RQST_UT_VAL" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_ITM_NO, '  ')) FM_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_ITM_NO, '  ')) FM_GEN_EXPN_ITM_NO1" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_ITM_NO, '  ')) TO_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_ITM_NO, '  ')) TO_GEN_EXPN_ITM_NO1" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_ITM_DESC, ' ')) FM_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_ITM_DESC, ' ')) FM_GEN_EXPN_ITM_DESC1" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_ITM_DESC, ' ')) TO_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append(",MAX (DECODE (A.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_ITM_DESC, ' ')) TO_GEN_EXPN_ITM_DESC1" ).append("\n"); 
		query.append(",MAX (C.PLN_YRMON) PLN_YRMON" ).append("\n"); 
		query.append(",NVL(MAX (CASE" ).append("\n"); 
		query.append("WHEN A.GEN_EXPN_TRNS_DIV_CD = 'F'" ).append("\n"); 
		query.append("AND     A.GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("THEN   A.JAN_AMT" ).append("\n"); 
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
		query.append("+ A.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("),0) FM_RQ_AMT" ).append("\n"); 
		query.append(",NVL(MAX (CASE" ).append("\n"); 
		query.append("WHEN A.GEN_EXPN_TRNS_DIV_CD = 'F'" ).append("\n"); 
		query.append("AND     A.GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("THEN   A.JAN_AMT" ).append("\n"); 
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
		query.append("+ A.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("),0) FM_RQ_AMT1" ).append("\n"); 
		query.append(",NVL(MAX (CASE" ).append("\n"); 
		query.append("WHEN A.GEN_EXPN_TRNS_DIV_CD = 'T'" ).append("\n"); 
		query.append("AND     A.GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("THEN   A.JAN_AMT" ).append("\n"); 
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
		query.append("+ A.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("),0) TO_RQ_AMT" ).append("\n"); 
		query.append(",NVL(MAX (CASE" ).append("\n"); 
		query.append("WHEN A.GEN_EXPN_TRNS_DIV_CD = 'T'" ).append("\n"); 
		query.append("AND     A.GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("THEN   A.JAN_AMT" ).append("\n"); 
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
		query.append("+ A.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("),0) TO_RQ_AMT1" ).append("\n"); 
		query.append("FROM GEM_APRO_STEP A, GEM_ITEM B, GEM_REQUEST C, GEM_OFFICE D" ).append("\n"); 
		query.append("WHERE B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND B.GEN_EXPN_RQST_NO = A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND B.OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("AND B.GEN_EXPN_CD = A.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND B.GEN_EXPN_ITM_NO = A.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("AND B.GEN_EXPN_TRNS_DIV_CD = A.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("AND B.GEN_EXPN_RQST_SEQ = A.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("AND A.OFC_CD = D.OFC_CD(+)" ).append("\n"); 
		query.append("AND C.PLN_YRMON LIKE @[pln_yrmon]||'%'" ).append("\n"); 
		query.append("#if (${gen_expn_rqst_tp_cd} == 'EI')" ).append("\n"); 
		query.append("AND C.GEN_EXPN_RQST_TP_CD = 'EI'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND C.GEN_EXPN_RQST_TP_CD IN ('ET','EA')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${gen_expn_rqst_seq} != '')" ).append("\n"); 
		query.append("AND A.GEN_EXPN_RQST_SEQ = @[gen_expn_rqst_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${gen_expn_trns_div_cd} != '')" ).append("\n"); 
		query.append("AND A.GEN_EXPN_TRNS_DIV_CD = @[gen_expn_trns_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${gen_expn_rqst_no} != '')" ).append("\n"); 
		query.append("AND A.GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.GEN_EXPN_RQST_NO, A.GEN_EXPN_RQST_SEQ" ).append("\n"); 

	}
}