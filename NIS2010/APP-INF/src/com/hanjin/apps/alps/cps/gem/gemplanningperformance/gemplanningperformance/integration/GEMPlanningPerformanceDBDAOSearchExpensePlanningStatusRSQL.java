/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchExpensePlanningStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.12
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.10.12 김창헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Chang Hun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchExpensePlanningStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계획비용 요청에 대한 현황을 조회한다
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchExpensePlanningStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_gen_expn_apro_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_tic_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_gen_expn_apsts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_apro_auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchExpensePlanningStatusRSQL").append("\n"); 
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
		query.append("SELECT   GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("        ,GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("        ,FM_GEN_EXPN_CD" ).append("\n"); 
		query.append("        ,TO_GEN_EXPN_CD" ).append("\n"); 
		query.append("        ,NVL (FM_GEN_EXPN_ITM_NO, TO_GEN_EXPN_ITM_NO) FM_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("        ,TO_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("        ,NVL (FM_GEN_EXPN_ITM_DESC, TO_GEN_EXPN_ITM_DESC) FM_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("        ,TO_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("        ,FM_OFC_CD" ).append("\n"); 
		query.append("        ,TO_OFC_CD" ).append("\n"); 
		query.append("        ,NVL (FM_RQST_OFC_CD, TO_RQST_OFC_CD) RQST_OFC_CD" ).append("\n"); 
		query.append("        ,FM_RQ_AMT" ).append("\n"); 
		query.append("        ,TO_RQ_AMT" ).append("\n"); 
		query.append("        ,FM_AD_AMT" ).append("\n"); 
		query.append("        ,TO_AD_AMT" ).append("\n"); 
		query.append("        ,NVL (FM_CRNT_GEN_EXPN_APRO_STEP_CD, TO_CRNT_GEN_EXPN_APRO_STEP_CD) CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("        ,NVL (FM_CRNT_GEN_EXPN_APSTS_CD, TO_CRNT_GEN_EXPN_APSTS_CD) CRNT_GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append("        ,DECODE(FM_CRNT_GEN_EXPN_APSTS_CD ,'RJ' ,'0','0') CRNT_GEN_EXPN_APSTS_CD_RJ" ).append("\n"); 
		query.append("        ,DECODE(FM_CRNT_GEN_EXPN_APSTS_CD ,'AP' ,'0','0') CRNT_GEN_EXPN_APSTS_CD_AP" ).append("\n"); 
		query.append("        ,NVL(FM_AP1,TO_AP1) AP1" ).append("\n"); 
		query.append("        ,NVL(FM_AP2,TO_AP2) AP2" ).append("\n"); 
		query.append("        ,NVL(FM_AP3,TO_AP3) AP3" ).append("\n"); 
		query.append("        ,NVL(FM_AP4,TO_AP4) AP4" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append("        ,NVL (FM_GEN_EXPN_APRO_AUTH_OFC_CD, TO_GEN_EXPN_APRO_AUTH_OFC_CD) GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append("        ,FM_LOCL_CURR_CD" ).append("\n"); 
		query.append("        ,TO_LOCL_CURR_CD" ).append("\n"); 
		query.append("        ,FM_UT_VAL" ).append("\n"); 
		query.append("        ,TO_UT_VAL" ).append("\n"); 
		query.append("        ,FM_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("        ,FM_LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("        ,FM_USD_KRW_XCH_RT" ).append("\n"); 
		query.append("        ,TO_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("        ,TO_LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("        ,TO_USD_KRW_XCH_RT" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,FM_ENG_ABBR_NM" ).append("\n"); 
		query.append("        ,TO_ENG_ABBR_NM" ).append("\n"); 
		query.append("        ,FM_KRN_ABBR_NM" ).append("\n"); 
		query.append("        ,TO_KRN_ABBR_NM" ).append("\n"); 
		query.append("        ,REQ_UPD_DT" ).append("\n"); 
		query.append("        ,ITM_UPD_DT" ).append("\n"); 
		query.append("FROM     (SELECT GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append("                ,GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                ,GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("                ,FM_OFC_CD" ).append("\n"); 
		query.append("                ,TO_OFC_CD" ).append("\n"); 
		query.append("                ,FM_GEN_EXPN_CD" ).append("\n"); 
		query.append("                ,TO_GEN_EXPN_CD" ).append("\n"); 
		query.append("                ,FM_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                ,TO_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                ,FM_CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("                ,TO_CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("                ,FM_CRNT_GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append("                ,TO_CRNT_GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append("                ,FM_RQST_OFC_CD" ).append("\n"); 
		query.append("                ,TO_RQST_OFC_CD" ).append("\n"); 
		query.append("                ,FM_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("                ,TO_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("                ,FM_LOCL_CURR_CD" ).append("\n"); 
		query.append("                ,TO_LOCL_CURR_CD" ).append("\n"); 
		query.append("                ,NVL(FM_UT_VAL , '0') FM_UT_VAL" ).append("\n"); 
		query.append("                ,NVL(TO_UT_VAL , '0') TO_UT_VAL        " ).append("\n"); 
		query.append("                ,FM_AP1" ).append("\n"); 
		query.append("                ,TO_AP1" ).append("\n"); 
		query.append("                ,FM_AP2" ).append("\n"); 
		query.append("                ,TO_AP2" ).append("\n"); 
		query.append("                ,FM_AP3" ).append("\n"); 
		query.append("                ,TO_AP3" ).append("\n"); 
		query.append("                ,FM_AP4" ).append("\n"); 
		query.append("                ,TO_AP4" ).append("\n"); 
		query.append("                ,FM_GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append("                ,TO_GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append("                ,NVL(FM_USD_LOCL_XCH_RT,'0') FM_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                ,NVL(FM_LOCL_KRW_XCH_RT,'0') FM_LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("                ,NVL(FM_USD_KRW_XCH_RT,'0') FM_USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                ,NVL(TO_USD_LOCL_XCH_RT,'0') TO_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                ,NVL(TO_LOCL_KRW_XCH_RT,'0') TO_LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("                ,NVL(TO_USD_KRW_XCH_RT,'0') TO_USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                ,CRE_USR_ID" ).append("\n"); 
		query.append("                ,CRE_DT" ).append("\n"); 
		query.append("                ,FM_RQ_AMT" ).append("\n"); 
		query.append("                ,TO_RQ_AMT" ).append("\n"); 
		query.append("                ,FM_AD_AMT" ).append("\n"); 
		query.append("                ,TO_AD_AMT" ).append("\n"); 
		query.append("                ,FM_ENG_ABBR_NM" ).append("\n"); 
		query.append("                ,TO_ENG_ABBR_NM" ).append("\n"); 
		query.append("                ,FM_KRN_ABBR_NM" ).append("\n"); 
		query.append("                ,TO_KRN_ABBR_NM" ).append("\n"); 
		query.append("                ,TO_CHAR(REQ_UPD_DT,'YYYYMMDDHH24MISS') REQ_UPD_DT" ).append("\n"); 
		query.append("                ,TO_CHAR(ITM_UPD_DT,'YYYYMMDDHH24MISS') ITM_UPD_DT" ).append("\n"); 
		query.append("          FROM   (SELECT   A.GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append("                          ,A.GEN_EXPN_RQST_NO GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                          ,B.GEN_EXPN_RQST_SEQ GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("                          ,MAX (A.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("                          ,MAX (A.CRE_DT) CRE_DT" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.OFC_CD)) FM_OFC_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.OFC_CD)) TO_OFC_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_CD)) FM_GEN_EXPN_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_CD)) TO_GEN_EXPN_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_ITM_NO)) FM_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_ITM_NO)) TO_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.CRNT_GEN_EXPN_APRO_STEP_CD)) FM_CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.CRNT_GEN_EXPN_APRO_STEP_CD)) TO_CRNT_GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.CRNT_GEN_EXPN_APSTS_CD)) FM_CRNT_GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.CRNT_GEN_EXPN_APSTS_CD)) TO_CRNT_GEN_EXPN_APSTS_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', A.RQST_OFC_CD)) FM_RQST_OFC_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', A.RQST_OFC_CD)) TO_RQST_OFC_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_ITM_DESC)) FM_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_ITM_DESC)) TO_GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', D.LOCL_CURR_CD)) FM_LOCL_CURR_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', D.LOCL_CURR_CD)) TO_LOCL_CURR_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', D.RQST_UT_VAL)) FM_UT_VAL" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', D.RQST_UT_VAL)) TO_UT_VAL" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', DECODE (C.GEN_EXPN_APRO_STEP_CD, 'RQ', C.GEN_EXPN_APSTS_CD))) FM_AP1" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', DECODE (C.GEN_EXPN_APRO_STEP_CD, 'RQ', C.GEN_EXPN_APSTS_CD))) TO_AP1" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', DECODE (C.GEN_EXPN_APRO_STEP_CD, 'HQ', C.GEN_EXPN_APSTS_CD))) FM_AP2" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', DECODE (C.GEN_EXPN_APRO_STEP_CD, 'HQ', C.GEN_EXPN_APSTS_CD))) TO_AP2" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', DECODE (C.GEN_EXPN_APRO_STEP_CD, 'TC', C.GEN_EXPN_APSTS_CD))) FM_AP3" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', DECODE (C.GEN_EXPN_APRO_STEP_CD, 'TC', C.GEN_EXPN_APSTS_CD))) TO_AP3" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', DECODE (C.GEN_EXPN_APRO_STEP_CD, 'CO', C.GEN_EXPN_APSTS_CD))) FM_AP4" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', DECODE (C.GEN_EXPN_APRO_STEP_CD, 'CO', C.GEN_EXPN_APSTS_CD))) TO_AP4" ).append("\n"); 
		query.append("                         -- ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', DECODE (B.CRNT_GEN_EXPN_APRO_STEP_CD, 'RQ', B.CRNT_GEN_EXPN_APSTS_CD))) FM_AP1" ).append("\n"); 
		query.append("                         -- ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', DECODE (B.CRNT_GEN_EXPN_APRO_STEP_CD, 'RQ', B.CRNT_GEN_EXPN_APSTS_CD))) TO_AP1" ).append("\n"); 
		query.append("                         -- ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', DECODE (B.CRNT_GEN_EXPN_APRO_STEP_CD, 'HQ', B.CRNT_GEN_EXPN_APSTS_CD))) FM_AP2" ).append("\n"); 
		query.append("                         -- ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', DECODE (B.CRNT_GEN_EXPN_APRO_STEP_CD, 'HQ', B.CRNT_GEN_EXPN_APSTS_CD))) TO_AP2" ).append("\n"); 
		query.append("                         -- ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', DECODE (B.CRNT_GEN_EXPN_APRO_STEP_CD, 'TC', B.CRNT_GEN_EXPN_APSTS_CD))) FM_AP3" ).append("\n"); 
		query.append("                         -- ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', DECODE (B.CRNT_GEN_EXPN_APRO_STEP_CD, 'TC', B.CRNT_GEN_EXPN_APSTS_CD))) TO_AP3" ).append("\n"); 
		query.append("                         -- ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', DECODE (B.CRNT_GEN_EXPN_APRO_STEP_CD, 'CO', B.CRNT_GEN_EXPN_APSTS_CD))) FM_AP4" ).append("\n"); 
		query.append("                         -- ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', DECODE (B.CRNT_GEN_EXPN_APRO_STEP_CD, 'CO', B.CRNT_GEN_EXPN_APSTS_CD))) TO_AP4" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.GEN_EXPN_APRO_AUTH_OFC_CD)) FM_GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', B.GEN_EXPN_APRO_AUTH_OFC_CD)) TO_GEN_EXPN_APRO_AUTH_OFC_CD" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', F.USD_LOCL_XCH_RT)) FM_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', F.USD_LOCL_XCH_RT)) TO_USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', F.LOCL_KRW_XCH_RT)) FM_LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', F.LOCL_KRW_XCH_RT)) TO_LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', F.USD_KRW_XCH_RT)) FM_USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', F.USD_KRW_XCH_RT)) TO_USD_KRW_XCH_RT" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', E.ENG_ABBR_NM)) FM_ENG_ABBR_NM" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', E.ENG_ABBR_NM)) TO_ENG_ABBR_NM" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', E.KRN_ABBR_NM)) FM_KRN_ABBR_NM" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'T', E.KRN_ABBR_NM)) TO_KRN_ABBR_NM" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', A.UPD_DT)) REQ_UPD_DT" ).append("\n"); 
		query.append("                          ,MAX (DECODE (B.GEN_EXPN_TRNS_DIV_CD, 'F', B.UPD_DT)) ITM_UPD_DT" ).append("\n"); 
		query.append("                          ,NVL (MAX (CASE" ).append("\n"); 
		query.append("                                         WHEN B.GEN_EXPN_TRNS_DIV_CD = 'F'" ).append("\n"); 
		query.append("                                     AND     C.GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("                                             THEN   C.JAN_AMT" ).append("\n"); 
		query.append("                                                  + C.FEB_AMT" ).append("\n"); 
		query.append("                                                  + C.MAR_AMT" ).append("\n"); 
		query.append("                                                  + C.APR_AMT" ).append("\n"); 
		query.append("                                                  + C.MAY_AMT" ).append("\n"); 
		query.append("                                                  + C.JUN_AMT" ).append("\n"); 
		query.append("                                                  + C.JUL_AMT" ).append("\n"); 
		query.append("                                                  + C.AUG_AMT" ).append("\n"); 
		query.append("                                                  + C.SEP_AMT" ).append("\n"); 
		query.append("                                                  + C.OCT_AMT" ).append("\n"); 
		query.append("                                                  + C.NOV_AMT" ).append("\n"); 
		query.append("                                                  + C.DEC_AMT" ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                               ,0" ).append("\n"); 
		query.append("                               ) FM_RQ_AMT" ).append("\n"); 
		query.append("                          ,NVL (MAX (CASE" ).append("\n"); 
		query.append("                                         WHEN B.GEN_EXPN_TRNS_DIV_CD = 'T'" ).append("\n"); 
		query.append("                                     AND     C.GEN_EXPN_APRO_STEP_CD = 'RQ'" ).append("\n"); 
		query.append("                                             THEN   C.JAN_AMT" ).append("\n"); 
		query.append("                                                  + C.FEB_AMT" ).append("\n"); 
		query.append("                                                  + C.MAR_AMT" ).append("\n"); 
		query.append("                                                  + C.APR_AMT" ).append("\n"); 
		query.append("                                                  + C.MAY_AMT" ).append("\n"); 
		query.append("                                                  + C.JUN_AMT" ).append("\n"); 
		query.append("                                                  + C.JUL_AMT" ).append("\n"); 
		query.append("                                                  + C.AUG_AMT" ).append("\n"); 
		query.append("                                                  + C.SEP_AMT" ).append("\n"); 
		query.append("                                                  + C.OCT_AMT" ).append("\n"); 
		query.append("                                                  + C.NOV_AMT" ).append("\n"); 
		query.append("                                                  + C.DEC_AMT" ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                               ,0" ).append("\n"); 
		query.append("                               ) TO_RQ_AMT" ).append("\n"); 
		query.append("                          ,NVL (MAX (CASE" ).append("\n"); 
		query.append("                                         WHEN B.GEN_EXPN_TRNS_DIV_CD = 'F'" ).append("\n"); 
		query.append("                                     AND     B.CRNT_GEN_EXPN_APRO_STEP_CD = C.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("                                             THEN   C.JAN_AMT" ).append("\n"); 
		query.append("                                                  + C.FEB_AMT" ).append("\n"); 
		query.append("                                                  + C.MAR_AMT" ).append("\n"); 
		query.append("                                                  + C.APR_AMT" ).append("\n"); 
		query.append("                                                  + C.MAY_AMT" ).append("\n"); 
		query.append("                                                  + C.JUN_AMT" ).append("\n"); 
		query.append("                                                  + C.JUL_AMT" ).append("\n"); 
		query.append("                                                  + C.AUG_AMT" ).append("\n"); 
		query.append("                                                  + C.SEP_AMT" ).append("\n"); 
		query.append("                                                  + C.OCT_AMT" ).append("\n"); 
		query.append("                                                  + C.NOV_AMT" ).append("\n"); 
		query.append("                                                  + C.DEC_AMT" ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                               ,0" ).append("\n"); 
		query.append("                               ) FM_AD_AMT" ).append("\n"); 
		query.append("                          ,NVL (MAX (CASE" ).append("\n"); 
		query.append("                                         WHEN B.GEN_EXPN_TRNS_DIV_CD = 'T'" ).append("\n"); 
		query.append("                                     AND     B.CRNT_GEN_EXPN_APRO_STEP_CD = C.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("                                             THEN   C.JAN_AMT" ).append("\n"); 
		query.append("                                                  + C.FEB_AMT" ).append("\n"); 
		query.append("                                                  + C.MAR_AMT" ).append("\n"); 
		query.append("                                                  + C.APR_AMT" ).append("\n"); 
		query.append("                                                  + C.MAY_AMT" ).append("\n"); 
		query.append("                                                  + C.JUN_AMT" ).append("\n"); 
		query.append("                                                  + C.JUL_AMT" ).append("\n"); 
		query.append("                                                  + C.AUG_AMT" ).append("\n"); 
		query.append("                                                  + C.SEP_AMT" ).append("\n"); 
		query.append("                                                  + C.OCT_AMT" ).append("\n"); 
		query.append("                                                  + C.NOV_AMT" ).append("\n"); 
		query.append("                                                  + C.DEC_AMT" ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                               ,0" ).append("\n"); 
		query.append("                               ) TO_AD_AMT" ).append("\n"); 
		query.append("                  FROM     (SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                                  ,RQST_OFC_CD" ).append("\n"); 
		query.append("                                  ,GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append("                                  ,PLN_YRMON" ).append("\n"); 
		query.append("                                  ,CRE_USR_ID" ).append("\n"); 
		query.append("                                  ,CRE_DT" ).append("\n"); 
		query.append("                                  ,UPD_DT" ).append("\n"); 
		query.append("                            FROM   GEM_REQUEST" ).append("\n"); 
		query.append("                            WHERE  PLN_YRMON LIKE @[pln_yrmon] || '%'							" ).append("\n"); 
		query.append("                            #if (${gen_expn_rqst_tp_cd} != '')" ).append("\n"); 
		query.append("                            AND    GEN_EXPN_RQST_TP_CD IN (${gen_expn_rqst_tp_cd})" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                           ) A" ).append("\n"); 
		query.append("                          ,GEM_ITEM B                                                                                                                                                  -- FROM 데이타 --" ).append("\n"); 
		query.append("                          ,GEM_APRO_STEP C" ).append("\n"); 
		query.append("                          ,GEM_OFFICE D" ).append("\n"); 
		query.append("                          ,GEM_EXPENSE E" ).append("\n"); 
		query.append("                          ,GEM_XCH_RT F" ).append("\n"); 
		query.append("                  WHERE    1 = 1" ).append("\n"); 
		query.append("                  AND      A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                  AND      B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                  AND      B.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("                  AND      B.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("                  AND      B.GEN_EXPN_ITM_NO = C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("                  AND      B.GEN_EXPN_TRNS_DIV_CD = C.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("                  AND      B.GEN_EXPN_RQST_SEQ = C.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("                  -- AND      C.GEN_EXPN_APRO_STEP_CD IN ('RQ', B.CRNT_GEN_EXPN_APRO_STEP_CD)" ).append("\n"); 
		query.append("                  AND      B.OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("                  AND      B.GEN_EXPN_CD = E.GEN_EXPN_CD" ).append("\n"); 
		query.append("                  AND      F.ACCT_XCH_RT_YRMON =    @[pln_yrmon] || '00'" ).append("\n"); 
		query.append("                  AND      F.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("                  AND      F.CURR_CD = D.LOCL_CURR_CD" ).append("\n"); 
		query.append("                  #if (${auth_flg} == 'YNYY')" ).append("\n"); 
		query.append("                  -- YNYY 사무국" ).append("\n"); 
		query.append("                  AND  B.CRNT_GEN_EXPN_APRO_STEP_CD = 'CO'" ).append("\n"); 
		query.append("                  AND  B.CRNT_GEN_EXPN_APSTS_CD <> 'AP'" ).append("\n"); 
		query.append("                  #else" ).append("\n"); 
		query.append("				  #end" ).append("\n"); 
		query.append("                  GROUP BY A.GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append("                          ,A.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                          ,B.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${role_ofc_cd} != '' && ${tic_auth_ofc_cd} == '')" ).append("\n"); 
		query.append("    AND (A.FM_OFC_CD IN (${role_ofc_cd}) OR A.TO_OFC_CD IN (${role_ofc_cd}))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gen_expn_rqst_no} != '')" ).append("\n"); 
		query.append("    AND      A.GEN_EXPN_RQST_NO = @[gen_expn_rqst_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_gen_expn_apro_step_cd} != '')" ).append("\n"); 
		query.append("    AND      A.FM_CRNT_GEN_EXPN_APRO_STEP_CD = @[crnt_gen_expn_apro_step_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_gen_expn_apsts_cd} != '')" ).append("\n"); 
		query.append("    AND      A.FM_CRNT_GEN_EXPN_APSTS_CD = @[crnt_gen_expn_apsts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND    (A.FM_OFC_CD = @[fm_ofc_cd] OR A.TO_OFC_CD = @[fm_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_gen_expn_cd} != '')" ).append("\n"); 
		query.append("    AND    (A.FM_GEN_EXPN_CD = @[fm_gen_expn_cd] OR A.TO_GEN_EXPN_CD = @[fm_gen_expn_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_gen_expn_cd_grp} != '')" ).append("\n"); 
		query.append("    AND    A.FM_GEN_EXPN_CD IN ( SELECT  GEN_EXPN_CD" ).append("\n"); 
		query.append("                                   FROM  GEM_EXPN_GRP_V" ).append("\n"); 
		query.append("                                  WHERE  GEM_EXPN_GRP_CD1 IN (${fm_gen_expn_cd_grp}))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_tic_cd} != '')" ).append("\n"); 
		query.append("    AND    A.FM_GEN_EXPN_CD IN ( SELECT GEN_EXPN_CD" ).append("\n"); 
		query.append("                             FROM   GEM_EXPN_GRP_V" ).append("\n"); 
		query.append("                             WHERE  TIC_CD = @[fm_tic_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gen_expn_apro_auth_ofc_cd} != '') " ).append("\n"); 
		query.append("    AND    (A.FM_GEN_EXPN_APRO_AUTH_OFC_CD = @[gen_expn_apro_auth_ofc_cd] OR" ).append("\n"); 
		query.append("            A.TO_GEN_EXPN_APRO_AUTH_OFC_CD = @[gen_expn_apro_auth_ofc_cd])" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("#if (${sum_up} == 'E')" ).append("\n"); 
		query.append("         FM_GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,  FM_OFC_CD" ).append("\n"); 
		query.append("      ,  FM_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("      ,  CRE_DT DESC" ).append("\n"); 
		query.append("#elseif (${sum_up} == 'O')         " ).append("\n"); 
		query.append("         FM_OFC_CD" ).append("\n"); 
		query.append("      ,  FM_GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,  FM_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("      ,  CRE_DT DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("      ,  GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("      ,  FM_GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,  FM_OFC_CD" ).append("\n"); 
		query.append("      ,  FM_GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("      ,  CRE_DT DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}