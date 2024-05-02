/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOReport0025R1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.08.05 진윤오
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

public class GEMPlanningPerformanceDBDAOReport0025R1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * adjustment report print
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOReport0025R1RSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOReport0025R1RSQL").append("\n"); 
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
		query.append("SELECT   A.GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append(",A.GEN_EXPN_RQST_NO GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append(",B.GEN_EXPN_RQST_SEQ GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append(",MAX (A.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append(",MAX (A.CRE_DT) CRE_DT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.OFC_CD)) FM_OFC_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.OFC_CD)) TO_OFC_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_CD)) FM_GEN_EXPN_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_CD)) TO_GEN_EXPN_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', G.GEM_EXPN_GRP_CD1)) GEM_EXPN_GRP_CD1" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', G.GEM_EXPN_GRP_CD2)) GEM_EXPN_GRP_CD2" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', DECODE (@[lang_div], 'KOR', G.KRN_ABBR_NM_1, G.ENG_ABBR_NM_1))) FM_EXPN_GRP_ABBR_NM1" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', DECODE (@[lang_div], 'KOR', G.KRN_ABBR_NM_1, G.ENG_ABBR_NM_1))) TO_EXPN_GRP_ABBR_NM1" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', DECODE (@[lang_div], 'KOR', G.KRN_ABBR_NM_2, G.ENG_ABBR_NM_2))) FM_EXPN_GRP_ABBR_NM2" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', DECODE (@[lang_div], 'KOR', G.KRN_ABBR_NM_2, G.ENG_ABBR_NM_2))) TO_EXPN_GRP_ABBR_NM2" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', DECODE (@[lang_div], 'KOR', G.KRN_ABBR_NM, G.ENG_ABBR_NM))) FM_EXPN_ABBR_NM" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', DECODE (@[lang_div], 'KOR', G.KRN_ABBR_NM, G.ENG_ABBR_NM))) TO_EXPN_ABBR_NM" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', E.TIC_CD)) FM_TIC_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', E.TIC_CD)) TO_TIC_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_ITM_NO)) FM_GEN_EXPN_ITEM_NO" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_ITM_NO)) TO_GEN_EXPN_ITEM_NO" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.CRNT_GEN_EXPN_APRO_STEP_CD)) FM_CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.CRNT_GEN_EXPN_APRO_STEP_CD)) TO_CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.CRNT_GEN_EXPN_APSTS_CD)) FM_CRNT_GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.CRNT_GEN_EXPN_APSTS_CD)) TO_CRNT_GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', A.RQST_OFC_CD)) FM_RQST_OFC_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', A.RQST_OFC_CD)) TO_RQST_OFC_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_ITM_DESC)) FM_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_ITM_DESC)) TO_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_CALC_BSS_DESC)) FM_GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_CALC_BSS_DESC)) TO_GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.RQST_OPIN_RMK)) FM_RQST_OPIN_RMK" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.RQST_OPIN_RMK)) TO_RQST_OPIN_RMK" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', D.LOCL_CURR_CD)) FM_LOCL_CURR_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', D.LOCL_CURR_CD)) TO_LOCL_CURR_CD" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', D.RQST_UT_VAL)) FM_UT_VAL" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', D.RQST_UT_VAL)) TO_UT_VAL" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', F.USD_LOCL_XCH_RT)) FM_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', F.USD_LOCL_XCH_RT)) TO_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', F.LOCL_KRW_XCH_RT)) FM_LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', F.LOCL_KRW_XCH_RT)) TO_LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', F.USD_KRW_XCH_RT)) FM_USD_KRW_XCH_RT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', F.USD_KRW_XCH_RT)) TO_USD_KRW_XCH_RT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.JAN_AMT)) FM_ASG_JAN_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.FEB_AMT)) FM_ASG_FEB_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.MAR_AMT)) FM_ASG_MAR_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.APR_AMT)) FM_ASG_APR_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.MAY_AMT)) FM_ASG_MAY_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.JUN_AMT)) FM_ASG_JUN_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.JUL_AMT)) FM_ASG_JUL_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.AUG_AMT)) FM_ASG_AUG_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.SEP_AMT)) FM_ASG_SEP_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.OCT_AMT)) FM_ASG_OCT_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.NOV_AMT)) FM_ASG_NOV_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.DEC_AMT)) FM_ASG_DEC_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.JAN_AMT)) TO_ASG_JAN_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.FEB_AMT)) TO_ASG_FEB_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.MAR_AMT)) TO_ASG_MAR_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.APR_AMT)) TO_ASG_APR_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.MAY_AMT)) TO_ASG_MAY_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.JUN_AMT)) TO_ASG_JUN_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.JUL_AMT)) TO_ASG_JUL_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.AUG_AMT)) TO_ASG_AUG_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.SEP_AMT)) TO_ASG_SEP_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.OCT_AMT)) TO_ASG_OCT_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.NOV_AMT)) TO_ASG_NOV_AMT" ).append("\n"); 
		query.append(",MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.DEC_AMT)) TO_ASG_DEC_AMT" ).append("\n"); 
		query.append(",NVL (MAX (CASE" ).append("\n"); 
		query.append("WHEN B.GEN_EXPN_TRNS_DIV_CD = 'F'" ).append("\n"); 
		query.append("AND     C.GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("THEN   C.JAN_AMT" ).append("\n"); 
		query.append("+ C.FEB_AMT" ).append("\n"); 
		query.append("+ C.MAR_AMT" ).append("\n"); 
		query.append("+ C.APR_AMT" ).append("\n"); 
		query.append("+ C.MAY_AMT" ).append("\n"); 
		query.append("+ C.JUN_AMT" ).append("\n"); 
		query.append("+ C.JUL_AMT" ).append("\n"); 
		query.append("+ C.AUG_AMT" ).append("\n"); 
		query.append("+ C.SEP_AMT" ).append("\n"); 
		query.append("+ C.OCT_AMT" ).append("\n"); 
		query.append("+ C.NOV_AMT" ).append("\n"); 
		query.append("+ C.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(") FM_RQ_AMT" ).append("\n"); 
		query.append(",NVL (MAX (CASE" ).append("\n"); 
		query.append("WHEN B.GEN_EXPN_TRNS_DIV_CD = 'T'" ).append("\n"); 
		query.append("AND     C.GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("THEN   C.JAN_AMT" ).append("\n"); 
		query.append("+ C.FEB_AMT" ).append("\n"); 
		query.append("+ C.MAR_AMT" ).append("\n"); 
		query.append("+ C.APR_AMT" ).append("\n"); 
		query.append("+ C.MAY_AMT" ).append("\n"); 
		query.append("+ C.JUN_AMT" ).append("\n"); 
		query.append("+ C.JUL_AMT" ).append("\n"); 
		query.append("+ C.AUG_AMT" ).append("\n"); 
		query.append("+ C.SEP_AMT" ).append("\n"); 
		query.append("+ C.OCT_AMT" ).append("\n"); 
		query.append("+ C.NOV_AMT" ).append("\n"); 
		query.append("+ C.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(") TO_RQ_AMT" ).append("\n"); 
		query.append(",NVL (MAX (CASE" ).append("\n"); 
		query.append("WHEN B.GEN_EXPN_TRNS_DIV_CD = 'F'" ).append("\n"); 
		query.append("AND     B.CRNT_GEN_EXPN_APRO_STEP_CD = C.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("THEN   C.JAN_AMT" ).append("\n"); 
		query.append("+ C.FEB_AMT" ).append("\n"); 
		query.append("+ C.MAR_AMT" ).append("\n"); 
		query.append("+ C.APR_AMT" ).append("\n"); 
		query.append("+ C.MAY_AMT" ).append("\n"); 
		query.append("+ C.JUN_AMT" ).append("\n"); 
		query.append("+ C.JUL_AMT" ).append("\n"); 
		query.append("+ C.AUG_AMT" ).append("\n"); 
		query.append("+ C.SEP_AMT" ).append("\n"); 
		query.append("+ C.OCT_AMT" ).append("\n"); 
		query.append("+ C.NOV_AMT" ).append("\n"); 
		query.append("+ C.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(") FM_AD_AMT" ).append("\n"); 
		query.append(",NVL (MAX (CASE" ).append("\n"); 
		query.append("WHEN B.GEN_EXPN_TRNS_DIV_CD = 'T'" ).append("\n"); 
		query.append("AND     B.CRNT_GEN_EXPN_APRO_STEP_CD = C.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("THEN   C.JAN_AMT" ).append("\n"); 
		query.append("+ C.FEB_AMT" ).append("\n"); 
		query.append("+ C.MAR_AMT" ).append("\n"); 
		query.append("+ C.APR_AMT" ).append("\n"); 
		query.append("+ C.MAY_AMT" ).append("\n"); 
		query.append("+ C.JUN_AMT" ).append("\n"); 
		query.append("+ C.JUL_AMT" ).append("\n"); 
		query.append("+ C.AUG_AMT" ).append("\n"); 
		query.append("+ C.SEP_AMT" ).append("\n"); 
		query.append("+ C.OCT_AMT" ).append("\n"); 
		query.append("+ C.NOV_AMT" ).append("\n"); 
		query.append("+ C.DEC_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(") TO_AD_AMT" ).append("\n"); 
		query.append(",'0' FM_USD_AMT" ).append("\n"); 
		query.append(",'0' TO_USD_AMT" ).append("\n"); 
		query.append(",'0' FM_AD_USD_AMT" ).append("\n"); 
		query.append(",'0' TO_AD_USD_AMT" ).append("\n"); 
		query.append("FROM     GEM_REQUEST A, GEM_ITEM B                                                                                                                                                     -- FROM 데이타 --" ).append("\n"); 
		query.append(",GEM_APRO_STEP C, GEM_OFFICE D, GEM_EXPENSE E, GEM_XCH_RT F , GEM_EXPN_GRP_V G" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("AND      B.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_ITM_NO = C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_TRNS_DIV_CD = C.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_RQST_SEQ = C.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("AND      C.GEN_EXPN_APRO_STEP_CD IN ('RQ', B.CRNT_GEN_EXPN_APRO_STEP_CD)" ).append("\n"); 
		query.append("AND      B.OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_CD = E.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND      F.ACCT_XCH_RT_YRMON =    SUBSTR (A.PLN_YRMON, 1, 4) || '00'" ).append("\n"); 
		query.append("AND      F.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("AND      F.CURR_CD = D.LOCL_CURR_CD" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_CD = G.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND      A.GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("#if (${gen_expn_rqst_seq} != '')" ).append("\n"); 
		query.append("AND      B.GEN_EXPN_RQST_SEQ = @[gen_expn_rqst_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.GEN_EXPN_RQST_TP_CD, A.GEN_EXPN_RQST_NO, B.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("GEM_EXPN_GRP_CD1" ).append("\n"); 
		query.append(", GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append(", FM_GEN_EXPN_CD" ).append("\n"); 
		query.append(", FM_RQ_AMT" ).append("\n"); 
		query.append(", FM_GEN_EXPN_ITEM_NO" ).append("\n"); 
		query.append(", TO_EXPN_GRP_ABBR_NM1" ).append("\n"); 
		query.append(", TO_GEN_EXPN_CD" ).append("\n"); 
		query.append(", TO_GEN_EXPN_ITEM_NO" ).append("\n"); 

	}
}