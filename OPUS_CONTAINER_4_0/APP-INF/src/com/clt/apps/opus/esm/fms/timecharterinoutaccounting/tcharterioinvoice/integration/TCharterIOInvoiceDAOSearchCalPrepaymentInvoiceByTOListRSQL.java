/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceByTOListRSQL.java
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

public class TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceByTOListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create TO
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceByTOListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("months",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flet_ctrt_tp_gb",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ppay_hir_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ori_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acmm_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceByTOListRSQL").append("\n"); 
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
		query.append("           AND ROWNUM = 1 " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("     , V_PARAM AS (" ).append("\n"); 
		query.append("        SELECT @[flet_ctrt_no] AS FLET_CTRT_NO" ).append("\n"); 
		query.append("             , @[ori_eff_dt] AS ORI_EFF_DT" ).append("\n"); 
		query.append("             , @[ori_exp_dt] AS ORI_EXP_DT" ).append("\n"); 
		query.append("             , CASE WHEN SUBSTR(@[ori_eff_dt],1,6) = SUBSTR(@[ori_exp_dt],1,6) THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("               END AS CON_EQUAL_MONTH_FLG2" ).append("\n"); 
		query.append("             , @[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append("             , @[ppay_hir_no] AS PPAY_HIR_NO" ).append("\n"); 
		query.append("             , @[ori_inv_usd_dys] AS ORI_INV_USD_DYS" ).append("\n"); 
		query.append("             , @[inv_usd_dys] AS INV_USD_DYS" ).append("\n"); 
		query.append("             , @[acmm_rt_amt] AS ACMM_RT_AMT" ).append("\n"); 
		query.append("             , @[flet_brog_rt_amt] AS FLET_BROG_RT_AMT" ).append("\n"); 
		query.append("             , @[months] AS MONTHS" ).append("\n"); 
		query.append("             , @[flet_ctrt_tp_gb] AS FLET_CTRT_TP_GB" ).append("\n"); 
		query.append("             , 'Hire' || ' ' || @[vsl_cd] || ' ' || @[ppay_hir_no] || DECODE(@[ppay_hir_no],'1','st','2','nd','3','rd','th') AS PRE_INV_DESC" ).append("\n"); 
		query.append("          FROM DUAL " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("     , V_PARAM_MONTH AS (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("             , CASE WHEN SUBSTR(CON_EFF_NEXT_MONTH,1,6) = SUBSTR(ORI_EXP_DT,1,6) THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("               END AS CON_EQUAL_MONTH_FLG" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT ROWNUM AS ITEMKEY" ).append("\n"); 
		query.append("                     , A.*" ).append("\n"); 
		query.append("                     , DECODE(DIFF,0,ORI_EFF_DT,TO_CHAR(ADD_MONTHS(TO_DATE(A.MIN_YM,'YYYYMM'), DIFF),'YYYYMMDDHH24MI')) AS CON_EFF_NEXT_MONTH" ).append("\n"); 
		query.append("                  FROM (SELECT A.*" ).append("\n"); 
		query.append("                             , TO_CHAR(ADD_MONTHS(TO_DATE(A.MIN_YM,'YYYYMM'),LEVEL-1),'YYYYMM') AS ORI_EFF_YM" ).append("\n"); 
		query.append("                             , LEVEL-1 AS DIFF" ).append("\n"); 
		query.append("                          FROM (SELECT A.*" ).append("\n"); 
		query.append("                                     , SUBSTR(A.ORI_EFF_DT,1,6) MIN_YM" ).append("\n"); 
		query.append("                                     , SUBSTR(A.ORI_EXP_DT,1,6) MAX_YM" ).append("\n"); 
		query.append("                                  FROM V_PARAM A " ).append("\n"); 
		query.append("                                ) A " ).append("\n"); 
		query.append("                        CONNECT BY LEVEL <= MONTHS_BETWEEN(ADD_MONTHS(TO_DATE(A.MAX_YM,'YYYYMM'), 1), TO_DATE(A.MIN_YM, 'YYYYMM')) " ).append("\n"); 
		query.append("                        ) A " ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("         WHERE ORI_EXP_DT <> CON_EFF_NEXT_MONTH /*Next Eff DT 와 ori_exp_dt 가 동일 하면 skip 하도록 한다.*/" ).append("\n"); 
		query.append("         ORDER BY A.ORI_EFF_DT " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELeCT * FROM V_PARAM_MONTH;    " ).append("\n"); 
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
		query.append("--SELECT * FROM V_PARM_HIRE;" ).append("\n"); 
		query.append("   , V_PARAM_HIRE_MONTH AS (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("             , CASE WHEN SUBSTR(CON_EFF_NEXT_MONTH,1,6) = SUBSTR(ORI_EXP_DT,1,6) THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("               END AS CON_EQUAL_MONTH_FLG" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT ROWNUM AS ITEMKEY" ).append("\n"); 
		query.append("                     , A.*" ).append("\n"); 
		query.append("                     , DECODE(DIFF,0,NOW_HIRE_EFF_DT,TO_CHAR(ADD_MONTHS(TO_DATE(A.MIN_YM,'YYYYMM'), DIFF),'YYYYMMDDHH24MI')) AS CON_EFF_NEXT_MONTH" ).append("\n"); 
		query.append("                  FROM (SELECT A.*" ).append("\n"); 
		query.append("                             , TO_CHAR(ADD_MONTHS(TO_DATE(A.MIN_YM,'YYYYMM'),LEVEL-1),'YYYYMM') AS ORI_EFF_YM" ).append("\n"); 
		query.append("                             , LEVEL-1 AS DIFF" ).append("\n"); 
		query.append("                          FROM (SELECT A.*" ).append("\n"); 
		query.append("                                     , SUBSTR(A.NOW_HIRE_EFF_DT,1,6) MIN_YM" ).append("\n"); 
		query.append("                                     , SUBSTR(A.NOW_HIRE_EXP_DT,1,6) MAX_YM" ).append("\n"); 
		query.append("                                  FROM V_PARM_HIRE A " ).append("\n"); 
		query.append("                                ) A " ).append("\n"); 
		query.append("                        CONNECT BY LEVEL <= MONTHS_BETWEEN(ADD_MONTHS(TO_DATE(A.MAX_YM,'YYYYMM'), 1), TO_DATE(A.MIN_YM, 'YYYYMM')) " ).append("\n"); 
		query.append("                        ) A " ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("         WHERE ORI_EXP_DT <> CON_EFF_NEXT_MONTH /*Next Eff DT 와 ori_exp_dt 가 동일 하면 skip 하도록 한다.*/" ).append("\n"); 
		query.append("         ORDER BY A.ORI_EFF_DT " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT * FROM V_PARAM_HIRE_MONTH;" ).append("\n"); 
		query.append("SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("     , ACCT_CD" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , INV_AMT" ).append("\n"); 
		query.append("     , ORI_INV_AMT" ).append("\n"); 
		query.append("     , CURR_CD2" ).append("\n"); 
		query.append("     , INV_AMT2" ).append("\n"); 
		query.append("     , ORI_INV_AMT2" ).append("\n"); 
		query.append("     , 'N' AS SLP_TP_CD" ).append("\n"); 
		query.append("     , INV_DESC" ).append("\n"); 
		query.append("     , FLET_CTRT_NO" ).append("\n"); 
		query.append("     , ROWNUM INV_DTL_SEQ" ).append("\n"); 
		query.append("     , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("     , EFF_DT" ).append("\n"); 
		query.append("     , EXP_DT" ).append("\n"); 
		query.append("     , INV_USD_DYS" ).append("\n"); 
		query.append("     , SORTKEY SORT_KEY" ).append("\n"); 
		query.append("  FROM (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("             , ACCT_CD" ).append("\n"); 
		query.append("             , CURR_CD" ).append("\n"); 
		query.append("             , INV_AMT" ).append("\n"); 
		query.append("             , ORI_INV_AMT" ).append("\n"); 
		query.append("             , CURR_CD2" ).append("\n"); 
		query.append("             , INV_AMT2" ).append("\n"); 
		query.append("             , ORI_INV_AMT2" ).append("\n"); 
		query.append("             , INV_DESC" ).append("\n"); 
		query.append("             , FLET_CTRT_NO" ).append("\n"); 
		query.append("             , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("             , EFF_DT" ).append("\n"); 
		query.append("             , EXP_DT" ).append("\n"); 
		query.append("             , SORTKEY" ).append("\n"); 
		query.append("             , ITEMKEY" ).append("\n"); 
		query.append("             , TO_DATE(EXP_DT,'YYYYMMDDHH24MI') - TO_DATE(EFF_DT,'YYYYMMDDHH24MI') AS INV_USD_DYS" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                /*1.TO : Time Charter Hire start */" ).append("\n"); 
		query.append("                SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                     , ACCT_CD" ).append("\n"); 
		query.append("                     , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                     , CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT,'999,999,999,999,999,990.00')) AS INV_AMT" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT,'999,999,999,999,999,990.00')) AS ORI_INV_AMT" ).append("\n"); 
		query.append("                     , CURR_CD2 AS CURR_CD2" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT2,'999,999,999,999,999,990.00')) AS INV_AMT2" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT2,'999,999,999,999,999,990.00')) AS ORI_INV_AMT2" ).append("\n"); 
		query.append("                     , INV_DESC AS INV_DESC" ).append("\n"); 
		query.append("                     , FLET_CTRT_NO AS FLET_CTRT_NO" ).append("\n"); 
		query.append("                     , EFF_DT AS EFF_DT" ).append("\n"); 
		query.append("                     , EXP_DT AS EXP_DT" ).append("\n"); 
		query.append("                     , ITEMKEY" ).append("\n"); 
		query.append("                     , '1' SORTKEY" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD ,NULL) CURR_CD" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'F',HIR_RT_N1ST_AMT  ,NULL) INV_AMT" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD ,NULL) CURR_CD2" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'S',HIR_RT_N1ST_AMT  ,NULL) INV_AMT2" ).append("\n"); 
		query.append("                             , INV_DESC" ).append("\n"); 
		query.append("                             , FLET_CTRT_NO" ).append("\n"); 
		query.append("                             , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                             , EFF_DT" ).append("\n"); 
		query.append("                             , EXP_DT" ).append("\n"); 
		query.append("                             , ITEMKEY" ).append("\n"); 
		query.append("                          FROM (SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                                     , HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                     , SUM(HIR_RT_N1ST_AMT) AS HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , MIN(INV_DESC) INV_DESC" ).append("\n"); 
		query.append("                                     , MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                     , MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     , MIN(EFF_DT) EFF_DT" ).append("\n"); 
		query.append("                                     , MIN(EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                                     , ITEMKEY" ).append("\n"); 
		query.append("                                  FROM (SELECT AC.ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , AC.ACCT_CD" ).append("\n"); 
		query.append("                                             , PM.HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                             , CASE WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' THEN " ).append("\n"); 
		query.append("                                                         FMS_HIRCURAMT1_FNC(PM.FLET_CTRT_NO, PM.CON_EFF_NEXT_MONTH, PM.NOW_HIRE_EXP_DT)" ).append("\n"); 
		query.append("                                                    ELSE " ).append("\n"); 
		query.append("                                                         FMS_HIRCURAMT1_FNC(PM.FLET_CTRT_NO, PM.CON_EFF_NEXT_MONTH, TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYYMMDDHH24MI'))" ).append("\n"); 
		query.append("                                               END HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                             , CASE WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' AND SUBSTR(PM.NOW_HIRE_EXP_DT,9,4) = '0000' THEN " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N1ST_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                                    WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' AND SUBSTR(PM.NOW_HIRE_EXP_DT,9,4) != '0000' THEN " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N1ST_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                                    ELSE " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N1ST_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                               END INV_DESC" ).append("\n"); 
		query.append("                                             , AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , 'F' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                             , PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , PM.CON_EFF_NEXT_MONTH AS EFF_DT" ).append("\n"); 
		query.append("                                             , DECODE(PM.CON_EQUAL_MONTH_FLG,'Y', PM.NOW_HIRE_EXP_DT, TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYYMMDDHH24MI')) AS EXP_DT" ).append("\n"); 
		query.append("                                             , PM.ORI_EFF_YM" ).append("\n"); 
		query.append("                                             , PM.ITEMKEY" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                             , V_ACCT_CD AC" ).append("\n"); 
		query.append("                                             , V_PARAM_HIRE_MONTH PM" ).append("\n"); 
		query.append("                                         WHERE FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                                      FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                                     WHERE FLET_CTRT_NO = PM.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND DECODE(PM.CON_EQUAL_MONTH_FLG,'Y', TO_DATE(PM.ORI_EXP_DT,'YYYYMMDDHH24MI'), TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI')) " ).append("\n"); 
		query.append("                                                                                               <= ( SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                                      FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                                     WHERE FLET_CTRT_NO = PM.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           AND AC.FLET_ACCT_CATE_CD = 'TC' " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 WHERE HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("                                 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                     , ITEMKEY" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                                     , HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                     , SUM(HIR_RT_N1ST_AMT) AS HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , MIN(INV_DESC) INV_DESC" ).append("\n"); 
		query.append("                                     , MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                     , MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     , MIN(EFF_DT) EFF_DT" ).append("\n"); 
		query.append("                                     , MIN(EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                                     , ITEMKEY" ).append("\n"); 
		query.append("                                  FROM (SELECT AC.ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , AC.ACCT_CD" ).append("\n"); 
		query.append("                                             , HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                             , CASE WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' THEN " ).append("\n"); 
		query.append("                                                         FMS_HIRCURAMT2_FNC(PM.FLET_CTRT_NO, PM.CON_EFF_NEXT_MONTH, PM.NOW_HIRE_EXP_DT)" ).append("\n"); 
		query.append("                                                    ELSE " ).append("\n"); 
		query.append("                                                         FMS_HIRCURAMT2_FNC(PM.FLET_CTRT_NO, PM.CON_EFF_NEXT_MONTH, TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYYMMDDHH24MI'))" ).append("\n"); 
		query.append("                                               END HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                             , CASE WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' AND SUBSTR(PM.NOW_HIRE_EXP_DT,9,4) = '0000' THEN " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N2ND_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                                    WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' AND SUBSTR(PM.NOW_HIRE_EXP_DT,9,4) != '0000' THEN " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N2ND_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                                    ELSE " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N2ND_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                               END INV_DESC" ).append("\n"); 
		query.append("                                             , AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , 'S' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                             , PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , PM.CON_EFF_NEXT_MONTH AS EFF_DT" ).append("\n"); 
		query.append("                                             , DECODE(PM.CON_EQUAL_MONTH_FLG,'Y', PM.NOW_HIRE_EXP_DT, PM.CON_EFF_NEXT_MONTH) AS EXP_DT" ).append("\n"); 
		query.append("                                             , PM.ORI_EFF_YM" ).append("\n"); 
		query.append("                                             , PM.ITEMKEY" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                             , V_ACCT_CD AC" ).append("\n"); 
		query.append("                                             , V_PARAM_HIRE_MONTH PM" ).append("\n"); 
		query.append("                                         WHERE FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                                      FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                                     WHERE FLET_CTRT_NO = PM.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND DECODE(PM.CON_EQUAL_MONTH_FLG , 'Y', TO_DATE(PM.ORI_EXP_DT,'YYYYMMDDHH24MI') ,TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'))" ).append("\n"); 
		query.append("                                                                                               <= (SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                                      FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                                     WHERE FLET_CTRT_NO = PM.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND PM.HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           AND AC.FLET_ACCT_CATE_CD = 'TC' " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 WHERE HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("                                 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                     , ITEMKEY " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                /*1.TO : Time Charter Hire  e n d*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                /* 2. TO : C/V/E Lumpsum Cost : other start*/" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                     , ACCT_CD" ).append("\n"); 
		query.append("                     , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                     , CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT,'999,999,999,999,999,990.00')) AS INV_AMT" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT,'999,999,999,999,999,990.00')) AS ORI_INV_AMT" ).append("\n"); 
		query.append("                     , CURR_CD2 AS CURR_CD2" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT2,'999,999,999,999,999,990.00')) AS INV_AMT2" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT2,'999,999,999,999,999,990.00')) AS ORI_INV_AMT2" ).append("\n"); 
		query.append("                     , INV_DESC AS INV_DESC" ).append("\n"); 
		query.append("                     , FLET_CTRT_NO AS FLET_CTRT_NO" ).append("\n"); 
		query.append("                     , EFF_DT AS EFF_DT" ).append("\n"); 
		query.append("                     , EXP_DT AS EXP_DT" ).append("\n"); 
		query.append("                     , ITEMKEY" ).append("\n"); 
		query.append("                     , '2' SORTKEY" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                             , HIR_CURR_N1ST_CD AS CURR_CD" ).append("\n"); 
		query.append("                             , HIR_RT_N1ST_AMT AS INV_AMT" ).append("\n"); 
		query.append("                             , NULL AS CURR_CD2" ).append("\n"); 
		query.append("                             , NULL AS INV_AMT2" ).append("\n"); 
		query.append("                             , NULL AS ORI_INV_AMT2" ).append("\n"); 
		query.append("                             , INV_DESC" ).append("\n"); 
		query.append("                             , FLET_CTRT_NO" ).append("\n"); 
		query.append("                             , EFF_DT" ).append("\n"); 
		query.append("                             , EXP_DT" ).append("\n"); 
		query.append("                             , ITEMKEY" ).append("\n"); 
		query.append("                          FROM (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , ACCT_CD" ).append("\n"); 
		query.append("                                     , HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                     , HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , INV_DESC" ).append("\n"); 
		query.append("                                     , FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     , ROWNUM AS INV_DTL_SEQ" ).append("\n"); 
		query.append("                                     , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , EFF_DT" ).append("\n"); 
		query.append("                                     , EXP_DT" ).append("\n"); 
		query.append("                                     , ITEMKEY" ).append("\n"); 
		query.append("                                  FROM (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , ACCT_CD" ).append("\n"); 
		query.append("                                             , MIN(HIR_CURR_N1ST_CD) HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                             , SUM(HIR_RT_N1ST_AMT) AS HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                             , INV_DESC" ).append("\n"); 
		query.append("                                             , MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , MIN(EFF_DT) EFF_DT" ).append("\n"); 
		query.append("                                             , MAX(EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                                             , ITEMKEY" ).append("\n"); 
		query.append("                                          FROM (SELECT (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                                                          FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("                                                         WHERE ACCT_CD = FO.ACCT_CD" ).append("\n"); 
		query.append("                                                           AND ACCT_ITM_SEQ = FO.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                                           AND ROWNUM =1) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                                     , FO.ACCT_CD" ).append("\n"); 
		query.append("                                                     , CASE WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' THEN " ).append("\n"); 
		query.append("                                                                 FMS_OTRAMT_FNC(PM.FLET_CTRT_NO, FO.ACCT_CD, FO.ACCT_ITM_SEQ, PM.CON_EFF_NEXT_MONTH, PM.ORI_EXP_DT)" ).append("\n"); 
		query.append("                                                            ELSE " ).append("\n"); 
		query.append("                                                                 FMS_OTRAMT_FNC(PM.FLET_CTRT_NO, FO.ACCT_CD, FO.ACCT_ITM_SEQ, PM.CON_EFF_NEXT_MONTH, TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYYMMDDHH24MI'))" ).append("\n"); 
		query.append("                                                       END HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                                     , FO.CURR_CD AS HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                                     , CASE WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' AND SUBSTR(PM.ORI_EXP_DT,9,4) = '0000' THEN " ).append("\n"); 
		query.append("                                                                 PM.PRE_INV_DESC || ' ' || FO.CURR_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(TO_DATE(PM.ORI_EXP_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                                            WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' AND SUBSTR(PM.ORI_EXP_DT,9,4) != '0000' THEN " ).append("\n"); 
		query.append("                                                                 PM.PRE_INV_DESC || ' ' || FO.CURR_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(TO_DATE(PM.ORI_EXP_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                                            ELSE " ).append("\n"); 
		query.append("                                                                 PM.PRE_INV_DESC || ' ' || FO.CURR_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                                       END INV_DESC" ).append("\n"); 
		query.append("                                                     , FO.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                                     , FO.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                                     , PM.CON_EFF_NEXT_MONTH AS EFF_DT" ).append("\n"); 
		query.append("                                                     , DECODE(PM.CON_EQUAL_MONTH_FLG,'Y', PM.ORI_EXP_DT, TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYYMMDDHH24MI')) AS EXP_DT" ).append("\n"); 
		query.append("                                                     , PM.ORI_EFF_YM" ).append("\n"); 
		query.append("                                                     , PM.ITEMKEY" ).append("\n"); 
		query.append("                                                  FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                                     , FMS_OTR_EXPN FO" ).append("\n"); 
		query.append("                                                     , V_PARAM_MONTH PM" ).append("\n"); 
		query.append("                                                 WHERE FC.FLET_CTRT_NO = FO.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                                   AND FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                                   AND TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                                              FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                                             WHERE FLET_CTRT_NO = PM.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                                   AND DECODE(PM.CON_EQUAL_MONTH_FLG,'Y', TO_DATE(PM.ORI_EXP_DT,'YYYYMMDDHH24MI'), ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1)) " ).append("\n"); 
		query.append("                                                                                                       <= (SELECT CASE WHEN MAX(EXP_DT) >= DECODE(PM.CON_EQUAL_MONTH_FLG,'Y', TO_DATE(PM.ORI_EXP_DT,'YYYYMMDDHH24MI'), ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1)) " ).append("\n"); 
		query.append("                                                                                                                       THEN MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                                                  ELSE MAX(EXP_DT) + 1" ).append("\n"); 
		query.append("                                                                                                                  END EXP_DT" ).append("\n"); 
		query.append("                                                                                                              FROM FMS_OTR_EXPN" ).append("\n"); 
		query.append("                                                                                                             WHERE FLET_CTRT_NO = PM.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                                         GROUP BY ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , ACCT_CD" ).append("\n"); 
		query.append("                                             , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , INV_DESC" ).append("\n"); 
		query.append("                                             , ITEMKEY " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 WHERE HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("                                 ORDER BY ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , ACCT_CD" ).append("\n"); 
		query.append("                                     , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , ITEMKEY " ).append("\n"); 
		query.append("                               ) " ).append("\n"); 
		query.append("                       )                      " ).append("\n"); 
		query.append("                /* 2. TO : C/V/E Lumpsum Cost : other e n d*/ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				/* 3. TO :Address Commission  start*/" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                     , ACCT_CD" ).append("\n"); 
		query.append("                     , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                     , CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT,'999,999,999,999,999,990.00')) AS INV_AMT" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT,'999,999,999,999,999,990.00')) AS ORI_INV_AMT" ).append("\n"); 
		query.append("                     , CURR_CD2 AS CURR_CD2" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT2,'999,999,999,999,999,990.00')) AS INV_AMT2" ).append("\n"); 
		query.append("                     , TRIM(TO_CHAR(INV_AMT2,'999,999,999,999,999,990.00')) AS ORI_INV_AMT2" ).append("\n"); 
		query.append("                     , INV_DESC AS INV_DESC" ).append("\n"); 
		query.append("                     , FLET_CTRT_NO AS FLET_CTRT_NO" ).append("\n"); 
		query.append("                     , EFF_DT AS EFF_DT" ).append("\n"); 
		query.append("                     , EXP_DT AS EXP_DT" ).append("\n"); 
		query.append("                     , ITEMKEY" ).append("\n"); 
		query.append("                     , '3' SORTKEY" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD ,NULL) CURR_CD" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'F',HIR_RT_N1ST_AMT  ,NULL) INV_AMT" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD ,NULL) CURR_CD2" ).append("\n"); 
		query.append("                             , DECODE(FLET_CURR_CHK_CD,'S',HIR_RT_N1ST_AMT  ,NULL) INV_AMT2" ).append("\n"); 
		query.append("                             , INV_DESC" ).append("\n"); 
		query.append("                             , FLET_CTRT_NO" ).append("\n"); 
		query.append("                             , EFF_DT" ).append("\n"); 
		query.append("                             , EXP_DT" ).append("\n"); 
		query.append("                             , ITEMKEY" ).append("\n"); 
		query.append("                          FROM (SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                                     , HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                     , SUM(HIR_RT_N1ST_AMT) AS HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , INV_DESC" ).append("\n"); 
		query.append("                                     , MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                     , MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     , MIN(EFF_DT) EFF_DT" ).append("\n"); 
		query.append("                                     , MIN(EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                                     , ITEMKEY" ).append("\n"); 
		query.append("                                  FROM (SELECT AC.ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , AC.ACCT_CD" ).append("\n"); 
		query.append("                                             , HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                             , CASE WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' THEN " ).append("\n"); 
		query.append("                                                         -1 * FMS_HIRCURAMT1_FNC(PM.FLET_CTRT_NO, PM.CON_EFF_NEXT_MONTH, PM.NOW_HIRE_EXP_DT) * TO_NUMBER(PM.ACMM_RT_AMT/100)" ).append("\n"); 
		query.append("                                                    ELSE " ).append("\n"); 
		query.append("                                                         -1 * FMS_HIRCURAMT1_FNC(PM.FLET_CTRT_NO, PM.CON_EFF_NEXT_MONTH, TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYYMMDDHH24MI')) * TO_NUMBER(PM.ACMM_RT_AMT/100)" ).append("\n"); 
		query.append("                                               END HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                             , CASE WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' AND SUBSTR(PM.NOW_HIRE_EXP_DT,9,4) = '0000' THEN " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N1ST_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                                    WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' AND SUBSTR(PM.NOW_HIRE_EXP_DT,9,4) != '0000' THEN " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N1ST_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                                    ELSE " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N1ST_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                               END INV_DESC" ).append("\n"); 
		query.append("                                             , AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , 'F' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                             , PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , PM.CON_EFF_NEXT_MONTH AS EFF_DT" ).append("\n"); 
		query.append("                                             , DECODE(PM.CON_EQUAL_MONTH_FLG,'Y', PM.NOW_HIRE_EXP_DT, TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYYMMDDHH24MI')) AS EXP_DT" ).append("\n"); 
		query.append("                                             , PM.ORI_EFF_YM" ).append("\n"); 
		query.append("                                             , PM.ITEMKEY" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                             , V_ACCT_CD AC" ).append("\n"); 
		query.append("                                             , V_PARAM_HIRE_MONTH PM" ).append("\n"); 
		query.append("                                         WHERE FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                                      FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                                     WHERE FLET_CTRT_NO = PM.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND DECODE(PM.CON_EQUAL_MONTH_FLG,'Y', TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI'), TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI')) " ).append("\n"); 
		query.append("                                                                                               <= (SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                                      FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                                     WHERE FLET_CTRT_NO = PM.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           AND AC.FLET_ACCT_CATE_CD = 'AD' " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 WHERE HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("                                 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                                     , INV_DESC" ).append("\n"); 
		query.append("                                     , ITEMKEY" ).append("\n"); 
		query.append("                                 UNION ALL" ).append("\n"); 
		query.append("                                SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM" ).append("\n"); 
		query.append("                                     , MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                                     , HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                     , SUM(HIR_RT_N1ST_AMT) AS HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                     , INV_DESC" ).append("\n"); 
		query.append("                                     , MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                     , MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                     , MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("                                     , MIN(EFF_DT) EFF_DT" ).append("\n"); 
		query.append("                                     , MIN(EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                                     , ITEMKEY" ).append("\n"); 
		query.append("                                  FROM (SELECT AC.ACCT_ITM_NM" ).append("\n"); 
		query.append("                                             , AC.ACCT_CD" ).append("\n"); 
		query.append("                                             , HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                             , CASE WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' THEN " ).append("\n"); 
		query.append("                                                         -1 * FMS_HIRCURAMT2_FNC(PM.FLET_CTRT_NO, PM.CON_EFF_NEXT_MONTH, PM.NOW_HIRE_EXP_DT) * TO_NUMBER(PM.ACMM_RT_AMT/100)" ).append("\n"); 
		query.append("                                                    ELSE " ).append("\n"); 
		query.append("                                                         -1 * FMS_HIRCURAMT2_FNC(PM.FLET_CTRT_NO, PM.CON_EFF_NEXT_MONTH, TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYYMMDDHH24MI')) * TO_NUMBER(PM.ACMM_RT_AMT/100)" ).append("\n"); 
		query.append("                                               END HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                                             , CASE WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' AND SUBSTR(PM.NOW_HIRE_EXP_DT,9,4) = '0000' THEN " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N2ND_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                                    WHEN PM.CON_EQUAL_MONTH_FLG = 'Y' AND SUBSTR(PM.NOW_HIRE_EXP_DT,9,4) != '0000' THEN " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N2ND_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                                    ELSE " ).append("\n"); 
		query.append("                                                         PM.PRE_INV_DESC || ' ' || HIR_CURR_N2ND_CD || ' ' || '(' || TO_CHAR(TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI'),'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(PM.CON_EFF_NEXT_MONTH,1,6),'YYYYMM'),1),'YYYY-MM-DD HH24:MI') || ')'" ).append("\n"); 
		query.append("                                               END INV_DESC" ).append("\n"); 
		query.append("                                             , AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                                             , 'S' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("                                             , PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                             , PM.CON_EFF_NEXT_MONTH AS EFF_DT" ).append("\n"); 
		query.append("                                             , DECODE(PM.CON_EQUAL_MONTH_FLG,'Y', PM.NOW_HIRE_EXP_DT, PM.CON_EFF_NEXT_MONTH) AS EXP_DT" ).append("\n"); 
		query.append("                                             , PM.ORI_EFF_YM" ).append("\n"); 
		query.append("                                             , PM.ITEMKEY" ).append("\n"); 
		query.append("                                          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                                             , V_ACCT_CD AC" ).append("\n"); 
		query.append("                                             , V_PARAM_HIRE_MONTH PM" ).append("\n"); 
		query.append("                                         WHERE FC.FLET_CTRT_NO = PM.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                           AND TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI') >= ( SELECT MIN(EFF_DT)" ).append("\n"); 
		query.append("                                                                                                      FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                                     WHERE FLET_CTRT_NO = PM.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND DECODE(PM.CON_EQUAL_MONTH_FLG , 'Y', TO_DATE(PM.NOW_HIRE_EXP_DT,'YYYYMMDDHH24MI') ,TO_DATE(PM.CON_EFF_NEXT_MONTH,'YYYYMMDDHH24MI')) " ).append("\n"); 
		query.append("                                                                                               <= (SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("                                                                                                      FROM FMS_HIRE" ).append("\n"); 
		query.append("                                                                                                     WHERE FLET_CTRT_NO = PM.FLET_CTRT_NO)" ).append("\n"); 
		query.append("                                           AND HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           AND AC.FLET_ACCT_CATE_CD = 'AD' " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                 WHERE HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("                                 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                                     , INV_DESC" ).append("\n"); 
		query.append("                                     , ITEMKEY " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                 WHERE @[acmm_flg] = 'Y'" ).append("\n"); 
		query.append("				/* 3. TO :Address Commission  e n d*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         ORDER BY SORTKEY ASC" ).append("\n"); 
		query.append("             , ACCT_ITM_NM ASC" ).append("\n"); 
		query.append("             , ACCT_CD ASC" ).append("\n"); 
		query.append("             , ITEMKEY ASC" ).append("\n"); 
		query.append("             , CURR_CD ASC" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}