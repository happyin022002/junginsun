/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchCalOffhireInvoiceListSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchCalOffhireInvoiceListSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchCalOffhireInvoiceListSumRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchCalOffhireInvoiceListSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_inv_usd_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bunker_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_usd_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_brog_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acmm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acmm_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_offh_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchCalOffhireInvoiceListSumRSQL").append("\n"); 
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
		query.append("WITH V_ACCT_CD AS (" ).append("\n"); 
		query.append("        SELECT A.ACCT_CD" ).append("\n"); 
		query.append("             , A.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("             , A.ACCT_ITM_NM" ).append("\n"); 
		query.append("             , B.FLET_ACCT_CATE_CD" ).append("\n"); 
		query.append("             , '1' AS SORT_KEY" ).append("\n"); 
		query.append("          FROM FMS_ACCT_ITM A" ).append("\n"); 
		query.append("             , FMS_ACCT_CATE B" ).append("\n"); 
		query.append("         WHERE A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("           AND A.ACCT_ITM_SEQ = B.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("           AND B.FLET_ACCT_CATE_CD = 'TC'" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT A.ACCT_CD" ).append("\n"); 
		query.append("             , A.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("             , A.ACCT_ITM_NM" ).append("\n"); 
		query.append("             , B.FLET_ACCT_CATE_CD" ).append("\n"); 
		query.append("             , '3' AS SORT_KEY" ).append("\n"); 
		query.append("          FROM FMS_ACCT_ITM A" ).append("\n"); 
		query.append("             , FMS_ACCT_CATE B" ).append("\n"); 
		query.append("         WHERE A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("           AND A.ACCT_ITM_SEQ = B.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("           AND B.FLET_ACCT_CATE_CD = 'AD'" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT A.ACCT_CD" ).append("\n"); 
		query.append("             , A.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("             , A.ACCT_ITM_NM" ).append("\n"); 
		query.append("             , B.FLET_ACCT_CATE_CD" ).append("\n"); 
		query.append("             , '4' AS SORT_KEY" ).append("\n"); 
		query.append("          FROM FMS_ACCT_ITM A" ).append("\n"); 
		query.append("             , FMS_ACCT_CATE B" ).append("\n"); 
		query.append("         WHERE A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("           AND A.ACCT_ITM_SEQ = B.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("           AND B.FLET_ACCT_CATE_CD = 'BR'" ).append("\n"); 
		query.append("           AND ROWNUM = 1 " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("     , V_PARAM AS (" ).append("\n"); 
		query.append("        SELECT @[flet_ctrt_no] AS FLET_CTRT_NO" ).append("\n"); 
		query.append("             , @[ori_eff_dt] AS ORI_EFF_DT" ).append("\n"); 
		query.append("             , @[ori_exp_dt] AS ORI_EXP_DT" ).append("\n"); 
		query.append("             , REPLACE(@[eff_dt],'-') AS EFF_DT" ).append("\n"); 
		query.append("             , REPLACE(@[exp_dt],'-') AS EXP_DT" ).append("\n"); 
		query.append("             , @[bunker_vvd] AS BUNKER_VVD" ).append("\n"); 
		query.append("             , @[flet_offh_rsn_cd] AS FLET_OFFH_RSN_CD" ).append("\n"); 
		query.append("             , @[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append("             , @[ori_inv_usd_dys] AS ORI_INV_USD_DYS" ).append("\n"); 
		query.append("             , @[inv_usd_dys] AS INV_USD_DYS" ).append("\n"); 
		query.append("             , @[acmm_rt_amt] AS ACMM_RT_AMT" ).append("\n"); 
		query.append("             , @[flet_brog_rt_amt] AS FLET_BROG_RT_AMT" ).append("\n"); 
		query.append("             , '' AS MONTHS" ).append("\n"); 
		query.append("             , 'Off-hire' AS TXT_OFF_HIRE" ).append("\n"); 
		query.append("             , 'Dry Dock' AS TXT_DRY_DOCK" ).append("\n"); 
		query.append("          FROM DUAL " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    , V_PARM_HIRE AS (" ).append("\n"); 
		query.append("        SELECT VP.*" ).append("\n"); 
		query.append("             , CASE WHEN TO_DATE(VP.ORI_EFF_DT,'YYYYMMDDHH24MI') >= FH.EFF_DT THEN VP.ORI_EFF_DT " ).append("\n"); 
		query.append("                    ELSE TO_CHAR(FH.EFF_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("               END NOW_HIRE_EFF_DT" ).append("\n"); 
		query.append("             , CASE WHEN TO_DATE(VP.ORI_EXP_DT,'YYYYMMDDHH24MI') >= FH.EXP_DT THEN TO_CHAR(FH.EXP_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                    ELSE VP.ORI_EXP_DT " ).append("\n"); 
		query.append("               END NOW_HIRE_EXP_DT" ).append("\n"); 
		query.append("             , FH.EFF_DT AS HIRE_EFF_DT" ).append("\n"); 
		query.append("             , FH.EXP_DT AS HIRE_EXP_DT" ).append("\n"); 
		query.append("             , FH.HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("             , FH.HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("             , FH.HIR_RT_N2ND_AMT" ).append("\n"); 
		query.append("             , FH.HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("          FROM FMS_HIRE FH" ).append("\n"); 
		query.append("             , V_PARAM VP" ).append("\n"); 
		query.append("         WHERE FH.FLET_CTRT_NO = VP.FLET_CTRT_NO" ).append("\n"); 
		query.append("           AND TO_DATE(VP.ORI_EFF_DT,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                             WHERE FLET_CTRT_NO = VP.FLET_CTRT_NO)" ).append("\n"); 
		query.append("           AND TO_DATE(VP.ORI_EXP_DT,'YYYYMMDDHH24MI') <= ( SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                             WHERE FLET_CTRT_NO = VP.FLET_CTRT_NO)" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT PH.* FROM V_PARM_HIRE PH;" ).append("\n"); 
		query.append("SELECT CURR_CD" ).append("\n"); 
		query.append("     , INV_AMT" ).append("\n"); 
		query.append("     , CURR_CD2" ).append("\n"); 
		query.append("     , INV_AMT2" ).append("\n"); 
		query.append("  FROM (SELECT CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("             , CASE WHEN CURR_CD IN ('KRW','JPY','PAB') THEN " ).append("\n"); 
		query.append("                         TRIM(TO_CHAR(ROUND(SUM(INV_AMT),2),'999,999,999,999,999,999'))" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                         TRIM(TO_CHAR(ROUND(SUM(INV_AMT),2),'999,999,999,999,999,999.00')) " ).append("\n"); 
		query.append("                END INV_AMT " ).append("\n"); 
		query.append("             , CURR_CD2 AS CURR_CD2" ).append("\n"); 
		query.append("             , CASE WHEN CURR_CD2 IN ('KRW','JPY','PAB') THEN " ).append("\n"); 
		query.append("                         TRIM(TO_CHAR(ROUND(SUM(INV_AMT2),2),'999,999,999,999,999,999'))" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                         TRIM(TO_CHAR(ROUND(SUM(INV_AMT2),2),'999,999,999,999,999,999.00')) " ).append("\n"); 
		query.append("               END INV_AMT2" ).append("\n"); 
		query.append("          FROM (SELECT ACCT_CD" ).append("\n"); 
		query.append("                     , CURR_CD" ).append("\n"); 
		query.append("                     , INV_AMT" ).append("\n"); 
		query.append("                     , CURR_CD2" ).append("\n"); 
		query.append("                     , INV_AMT2" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        /*--1. Offhire Time Charter Hire start */" ).append("\n"); 
		query.append("                        SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'F',HIR_RT_N1ST_AMT,0) INV_AMT" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'S',HIR_RT_N1ST_AMT,0) INV_AMT2" ).append("\n"); 
		query.append("                             , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                             , '1' SORTKEY" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                                     , HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                     , SUM(HIR_RT_N1ST_AMT) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                  FROM (SELECT AC.ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , AC.ACCT_CD" ).append("\n"); 
		query.append("                                             , HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                             , FMS_HIRCURAMT1_FNC(PM.FLET_CTRT_NO, PM.NOW_HIRE_EFF_DT, PM.NOW_HIRE_EXP_DT) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                             , AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , 'F' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                             , PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EFF_DT" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EXP_DT" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                             , V_ACCT_CD AC" ).append("\n"); 
		query.append("                                             , V_PARM_HIRE PM" ).append("\n"); 
		query.append("                                         WHERE FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EFF_DT,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI') <= ( SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           AND AC.FLET_ACCT_CATE_CD = 'TC' " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 WHERE HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("                                 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                                     , HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                     , SUM(HIR_RT_N1ST_AMT) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                  FROM (SELECT AC.ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , AC.ACCT_CD" ).append("\n"); 
		query.append("                                             , HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                             , FMS_HIRCURAMT2_FNC(PM.FLET_CTRT_NO, PM.NOW_HIRE_EFF_DT, PM.NOW_HIRE_EXP_DT) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                             , 'N' SLP_TP_CD" ).append("\n"); 
		query.append("                                             , DECODE(PM.FLET_OFFH_RSN_CD,'O',PM.TXT_OFF_HIRE, PM.TXT_DRY_DOCK) || ' ' || SUBSTR(PM.BUNKER_VVD,1,9) || ' ' || '(' || TO_CHAR(TO_DATE(PM.NOW_HIRE_EFF_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ')' AS INV_DESC" ).append("\n"); 
		query.append("                                             , AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , 'S' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                             , PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EFF_DT" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EXP_DT" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                             , V_ACCT_CD AC" ).append("\n"); 
		query.append("                                             , V_PARM_HIRE PM" ).append("\n"); 
		query.append("                                         WHERE FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EFF_DT,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI') <= ( SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           AND AC.FLET_ACCT_CATE_CD = 'TC' " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 WHERE HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("                                 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                          /*1. Offhire Time Charter Hire e n d */  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                          /*2. Offhire Other start */" ).append("\n"); 
		query.append("                         UNION ALL" ).append("\n"); 
		query.append("                        SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , HIR_CURR_N1ST_CD AS CURR_CD" ).append("\n"); 
		query.append("                             , HIR_RT_N1ST_AMT AS INV_AMT" ).append("\n"); 
		query.append("                             , NULL AS CURR_CD2" ).append("\n"); 
		query.append("                             , NULL AS INV_AMT2" ).append("\n"); 
		query.append("                             , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                             , '2' SORTKEY" ).append("\n"); 
		query.append("                          FROM (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , ACCT_CD" ).append("\n"); 
		query.append("                                     , MIN(HIR_CURR_N1ST_CD) HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                     , FMS_OTRAMT_FNC(MIN(FLET_CTRT_NO), ACCT_CD, ACCT_ITM_SEQ, MIN(ORI_EFF_DT), MIN(ORI_EXP_DT)) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , MIN(ORI_EFF_DT) EFF_DT" ).append("\n"); 
		query.append("                                     , MAX(ORI_EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                                  FROM (SELECT (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                                                  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("                                                 WHERE ACCT_CD = FO.ACCT_CD" ).append("\n"); 
		query.append("                                                   AND ACCT_ITM_SEQ = FO.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                                   AND ROWNUM =1) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , FO.ACCT_CD" ).append("\n"); 
		query.append("                                             , FO.CURR_CD HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                             , FO.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , FO.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , FO.EFF_DT" ).append("\n"); 
		query.append("                                             , FO.EXP_DT" ).append("\n"); 
		query.append("                                             , PM.ORI_EFF_DT" ).append("\n"); 
		query.append("                                             , PM.ORI_EXP_DT" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                             , FMS_OTR_EXPN FO" ).append("\n"); 
		query.append("                                             , V_PARAM PM" ).append("\n"); 
		query.append("                                         WHERE FC.FLET_CTRT_NO = FO.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.ORI_EFF_DT,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_OTR_EXPN" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.ORI_EXP_DT,'YYYYMMDDHH24MI') <= ( SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_OTR_EXPN" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO) " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 GROUP BY ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , ACCT_CD" ).append("\n"); 
		query.append("                                     , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                               ) " ).append("\n"); 
		query.append("                          /*2. Offhire Other e n d */  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         /*3. Offhire Address Commission start*/" ).append("\n"); 
		query.append("                         UNION ALL" ).append("\n"); 
		query.append("                        SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'F',HIR_RT_N1ST_AMT,0) INV_AMT" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'S',HIR_RT_N1ST_AMT,0) INV_AMT2" ).append("\n"); 
		query.append("                             , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                             , '3' SORTKEY" ).append("\n"); 
		query.append("                          FROM (SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                                     , HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                     , SUM(HIR_RT_N1ST_AMT) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                  FROM (SELECT AC.ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , AC.ACCT_CD" ).append("\n"); 
		query.append("                                             , HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                             , -1 * FMS_HIRCURAMT1_FNC(PM.FLET_CTRT_NO, PM.NOW_HIRE_EFF_DT, PM.NOW_HIRE_EXP_DT) * TO_NUMBER(PM.ACMM_RT_AMT/100) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                             , AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , 'F' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                             , PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EFF_DT" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EXP_DT" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                             , V_ACCT_CD AC" ).append("\n"); 
		query.append("                                             , V_PARM_HIRE PM" ).append("\n"); 
		query.append("                                         WHERE FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EFF_DT,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI') <= ( SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           AND AC.FLET_ACCT_CATE_CD = 'AD' " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 WHERE HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("                                 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                                     , HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                     , SUM(HIR_RT_N1ST_AMT) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                  FROM (SELECT AC.ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , AC.ACCT_CD" ).append("\n"); 
		query.append("                                             , HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                             , -1 * FMS_HIRCURAMT2_FNC(PM.FLET_CTRT_NO, PM.NOW_HIRE_EFF_DT, PM.NOW_HIRE_EXP_DT) * TO_NUMBER(PM.ACMM_RT_AMT/100) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                             , AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , 'S' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                             , PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EFF_DT" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EXP_DT" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                             , V_ACCT_CD AC" ).append("\n"); 
		query.append("                                             , V_PARM_HIRE PM" ).append("\n"); 
		query.append("                                         WHERE FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EFF_DT,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI') <= ( SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           AND AC.FLET_ACCT_CATE_CD = 'AD' " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 WHERE HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("                                 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                         WHERE @[acmm_flg] = 'Y'" ).append("\n"); 
		query.append("                         /*3. Offhire Address Commission e n d*/ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         /*4. Offhire Brokerage start*/" ).append("\n"); 
		query.append("                         UNION ALL" ).append("\n"); 
		query.append("                        SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'F',HIR_RT_N1ST_AMT,0) INV_AMT" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'S',HIR_RT_N1ST_AMT,0) INV_AMT2" ).append("\n"); 
		query.append("                             , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                             , '4' SORTKEY" ).append("\n"); 
		query.append("                          FROM (SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                                     , HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                     , SUM(HIR_RT_N1ST_AMT) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                  FROM (SELECT AC.ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , AC.ACCT_CD" ).append("\n"); 
		query.append("                                             , HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                             , FMS_HIRCURAMT1_FNC(PM.FLET_CTRT_NO, PM.NOW_HIRE_EFF_DT, PM.NOW_HIRE_EXP_DT) * TO_NUMBER(PM.FLET_BROG_RT_AMT/100) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                             , AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , 'F' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                             , PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EFF_DT" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EXP_DT" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                             , V_ACCT_CD AC" ).append("\n"); 
		query.append("                                             , V_PARM_HIRE PM" ).append("\n"); 
		query.append("                                         WHERE FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EFF_DT,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI') <= ( SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           AND AC.FLET_ACCT_CATE_CD = 'BR' " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 WHERE HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("                                 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                                     , HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                     , SUM(HIR_RT_N1ST_AMT) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                  FROM (SELECT AC.ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , AC.ACCT_CD" ).append("\n"); 
		query.append("                                             , HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                             , FMS_HIRCURAMT2_FNC(PM.FLET_CTRT_NO, PM.NOW_HIRE_EFF_DT, PM.NOW_HIRE_EXP_DT) * TO_NUMBER(PM.FLET_BROG_RT_AMT/100) HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                             , AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , 'S' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                             , PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EFF_DT" ).append("\n"); 
		query.append("                                             , PM.NOW_HIRE_EXP_DT" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                             , V_ACCT_CD AC" ).append("\n"); 
		query.append("                                             , V_PARM_HIRE PM" ).append("\n"); 
		query.append("                                         WHERE FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EFF_DT,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI') <= ( SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                             WHERE FLET_CTRT_NO = FC.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           AND AC.FLET_ACCT_CATE_CD = 'BR' " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 WHERE HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("                                 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                         WHERE @[brog_flg] = 'Y'" ).append("\n"); 
		query.append("                         /*4. Offhire Brokerage e n d*/  " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         GROUP BY CURR_CD" ).append("\n"); 
		query.append("             , CURR_CD2" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}