/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExpensePlanDBDAOExpensePlanPerformanceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpensePlanDBDAOExpensePlanPerformanceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 년간/월별 장비임차 형태별 임차료 실적을 조회한다.
	  * 2010.09.06 남궁진호 [CHM-201005772-01] Container & Chassis 에 실적 비용을 가져 오는 기준을 다르게 적용, Chassis 실적 비용은 추정에 Actual 금액으로 적용.
	  * </pre>
	  */
	public ExpensePlanDBDAOExpensePlanPerformanceListRSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.integration").append("\n"); 
		query.append("FileName : ExpensePlanDBDAOExpensePlanPerformanceListRSQL").append("\n"); 
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
		query.append("WITH PARAM AS (    " ).append("\n"); 
		query.append("#if (${ver_seq} == '') 	" ).append("\n"); 
		query.append("	SELECT  NVL(MAX(PLN_YR),@[pln_yr])  AS PLN_YR," ).append("\n"); 
		query.append("            NVL(MAX(VER_SEQ),1)         AS VER_SEQ," ).append("\n"); 
		query.append("            @[eq_knd_cd]                AS EQ_KND_NM      " ).append("\n"); 
		query.append("    FROM    LSE_EQ_EXPN_PLN" ).append("\n"); 
		query.append("    WHERE   PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SELECT  @[pln_yr]  AS PLN_YR," ).append("\n"); 
		query.append("            @[ver_seq] AS VER_SEQ," ).append("\n"); 
		query.append("			@[eq_knd_cd] AS EQ_KND_NM                        " ).append("\n"); 
		query.append("    FROM    DUAL           " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   PLN_YR " ).append("\n"); 
		query.append("       , VER_SEQ" ).append("\n"); 
		query.append("       , EQ_KND_NM" ).append("\n"); 
		query.append("       , EQ_TERM_NM" ).append("\n"); 
		query.append("       , RSLT_TP_SEQ" ).append("\n"); 
		query.append("       , RSLT_TP" ).append("\n"); 
		query.append("       , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_01) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_01) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_01) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_01, '9,999,999,990.00') END) MNTH_01" ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_02) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_02) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_02) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_02, '9,999,999,990.00') END) MNTH_02" ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_03) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_03) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_03) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_03, '9,999,999,990.00') END) MNTH_03" ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(FRST_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(FRST_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(FRST_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(FRST_QURT_TOT, '9,999,999,990.00') END) FRST_QURT_TOT" ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_04) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_04) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_04) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_04, '9,999,999,990.00') END) MNTH_04" ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_05) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_05) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_05) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_05, '9,999,999,990.00') END) MNTH_05" ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_06) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_06) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_06) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_06, '9,999,999,990.00') END) MNTH_06     " ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(SCND_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(SCND_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(SCND_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(SCND_QURT_TOT, '9,999,999,990.00') END) SCND_QURT_TOT" ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_07) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_07) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_07) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_07, '9,999,999,990.00') END) MNTH_07             " ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_08) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_08) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_08) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_08, '9,999,999,990.00') END) MNTH_08       " ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_09) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_09) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_09) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_09, '9,999,999,990.00') END) MNTH_09        " ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(THRD_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(THRD_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(THRD_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(THRD_QURT_TOT, '9,999,999,990.00') END) THRD_QURT_TOT   " ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_10) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_10) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_10) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_10, '9,999,999,990.00') END) MNTH_10" ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_11) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_11) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_11) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_11, '9,999,999,990.00') END) MNTH_11" ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(MNTH_12) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(MNTH_12) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(MNTH_12) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(MNTH_12, '9,999,999,990.00') END) MNTH_12" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(FRTH_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(FRTH_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(FRTH_QURT_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(FRTH_QURT_TOT, '9,999,999,990.00') END) FRTH_QURT_TOT" ).append("\n"); 
		query.append("        , TRIM(" ).append("\n"); 
		query.append("            CASE WHEN (RSLT_TP_SEQ = 3) THEN" ).append("\n"); 
		query.append("            TO_CHAR(" ).append("\n"); 
		query.append("            DECODE(SUM(YR_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("            ROUND((" ).append("\n"); 
		query.append("                SUM(YR_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                SUM(YR_TOT) OVER (PARTITION BY RK ORDER BY RSLT_TP_SEQ ASC RANGE BETWEEN 2 PRECEDING AND 2 PRECEDING)" ).append("\n"); 
		query.append("                ) * 100, 1)), '9,999,999,990.0') || ' %'" ).append("\n"); 
		query.append("            ELSE TO_CHAR(YR_TOT, '9,999,999,990.00') END) YR_TOT                               " ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  DENSE_RANK() OVER (PARTITION BY Z.PLN_YR, VER_SEQ ORDER BY Z.PLN_YR, VER_SEQ, " ).append("\n"); 
		query.append("                                   DECODE(Z.EQ_KND_NM, 'CNTR', 1, 'CHSS', 2, 3)," ).append("\n"); 
		query.append("                                          DECODE(Z.EQ_TERM_NM, 'LP', 1, 'OL', 2, 'LT', 3, 'ST', 4, 'LS', 5, 'SB', 6," ).append("\n"); 
		query.append("                                                               'SO', 7, 'NP', 8, 'CP', 9,'MG.SET',10,11)" ).append("\n"); 
		query.append("                                   ) AS RK" ).append("\n"); 
		query.append("                , Z.PLN_YR" ).append("\n"); 
		query.append("                , P.VER_SEQ" ).append("\n"); 
		query.append("                , NVL(Z.EQ_KND_NM, 'G.TTL') AS EQ_KND_NM " ).append("\n"); 
		query.append("                , CASE WHEN Z.EQ_KND_NM IS NULL THEN EQ_TERM_NM" ).append("\n"); 
		query.append("                       ELSE NVL(Z.EQ_TERM_NM, 'S.TTL') END AS EQ_TERM_NM                                 " ).append("\n"); 
		query.append("                , Z.RSLT_TP_SEQ" ).append("\n"); 
		query.append("                , Z.RSLT_TP" ).append("\n"); 
		query.append("                , Z.MNTH_01" ).append("\n"); 
		query.append("                , Z.MNTH_02" ).append("\n"); 
		query.append("                , Z.MNTH_03" ).append("\n"); 
		query.append("                , Z.FRST_QURT_TOT" ).append("\n"); 
		query.append("                , Z.MNTH_04" ).append("\n"); 
		query.append("                , Z.MNTH_05" ).append("\n"); 
		query.append("                , Z.MNTH_06" ).append("\n"); 
		query.append("                , Z.SCND_QURT_TOT" ).append("\n"); 
		query.append("                , Z.MNTH_07" ).append("\n"); 
		query.append("                , Z.MNTH_08" ).append("\n"); 
		query.append("                , Z.MNTH_09" ).append("\n"); 
		query.append("                , Z.THRD_QURT_TOT" ).append("\n"); 
		query.append("                , Z.MNTH_10" ).append("\n"); 
		query.append("                , Z.MNTH_11" ).append("\n"); 
		query.append("                , Z.MNTH_12" ).append("\n"); 
		query.append("                , Z.FRTH_QURT_TOT" ).append("\n"); 
		query.append("                , Z.YR_TOT" ).append("\n"); 
		query.append("        FROM    PARAM P," ).append("\n"); 
		query.append("        	   (SELECT  X.PLN_YR, X.RSLT_TP_SEQ, X.EQ_TERM_NM," ).append("\n"); 
		query.append("                        CASE WHEN X.RSLT_TP_SEQ = 1 THEN 'Plan'" ).append("\n"); 
		query.append("                             WHEN X.RSLT_TP_SEQ = 2 THEN 'PFMC'" ).append("\n"); 
		query.append("                             WHEN X.RSLT_TP_SEQ = 3 THEN 'Ratio' END RSLT_TP, " ).append("\n"); 
		query.append("                        DECODE(X.EQ_KND_CD,'U','CNTR','Z','CHSS') EQ_KND_NM, " ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'JAN' THEN X.EXPN_AMT END) MNTH_01," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'FEB' THEN X.EXPN_AMT END) MNTH_02," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'MAR' THEN X.EXPN_AMT END) MNTH_03," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD IN('JAN','FEB','MAR') THEN X.EXPN_AMT END) FRST_QURT_TOT," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'APR' THEN X.EXPN_AMT END) MNTH_04,        " ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'MAY' THEN X.EXPN_AMT END) MNTH_05," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'JUN' THEN X.EXPN_AMT END) MNTH_06," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD IN('APR','MAY','JUN') THEN X.EXPN_AMT END) SCND_QURT_TOT," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'JUL' THEN X.EXPN_AMT END) MNTH_07," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'AUG' THEN X.EXPN_AMT END) MNTH_08," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'SEP' THEN X.EXPN_AMT END) MNTH_09," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD IN('JUL','AUG','SEP') THEN X.EXPN_AMT END) THRD_QURT_TOT," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'OCT' THEN X.EXPN_AMT END) MNTH_10," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'NOV' THEN X.EXPN_AMT END) MNTH_11," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD = 'DEC' THEN X.EXPN_AMT END) MNTH_12," ).append("\n"); 
		query.append("                        SUM(CASE WHEN X.EXPN_MON_CD IN('OCT','NOV','DEC') THEN X.EXPN_AMT END) FRTH_QURT_TOT," ).append("\n"); 
		query.append("                        SUM(X.EXPN_AMT) YR_TOT" ).append("\n"); 
		query.append("                FROM   (SELECT  AA.PLN_YR, CC.RSLT_TP_SEQ, AA.EQ_KND_CD," ).append("\n"); 
		query.append("                                AA.EQ_TERM_NM, AA.EXPN_MON_CD," ).append("\n"); 
		query.append("                                CASE WHEN CC.RSLT_TP_SEQ = 1 THEN AA.EXPN_AMT" ).append("\n"); 
		query.append("                                     WHEN CC.RSLT_TP_SEQ = 2 THEN BB.EXPN_AMT" ).append("\n"); 
		query.append("                                     WHEN CC.RSLT_TP_SEQ = 3 " ).append("\n"); 
		query.append("                                     THEN DECODE(NVL(AA.EXPN_AMT,0),0,0, ROUND(BB.EXPN_AMT/AA.EXPN_AMT*100, 1))" ).append("\n"); 
		query.append("                                END EXPN_AMT" ).append("\n"); 
		query.append("                        FROM   (SELECT  A.PLN_YR, 1 RSLT_TP_SEQ, A.EQ_KND_CD" ).append("\n"); 
		query.append("--                                , A.EQ_TERM_NM /* CHSS LT, ST를 LS로 통합하고, N/P, C/P에 '/' 제거 */" ).append("\n"); 
		query.append("                                        , CASE WHEN EQ_KND_CD = 'Z' THEN " ).append("\n"); 
		query.append("                                             CASE WHEN (EQ_TERM_NM = 'LT') THEN 'LS'" ).append("\n"); 
		query.append("                                                  WHEN (EQ_TERM_NM = 'ST') THEN 'LS'" ).append("\n"); 
		query.append("                                                  ELSE REPLACE(A.EQ_TERM_NM, '/', '') END" ).append("\n"); 
		query.append("                                           ELSE A.EQ_TERM_NM END AS EQ_TERM_NM         " ).append("\n"); 
		query.append("                                        , A.EXPN_MON_CD, SUM(A.EXPN_AMT) AS EXPN_AMT     " ).append("\n"); 
		query.append("                                FROM    PARAM P," ).append("\n"); 
		query.append("                                        LSE_EQ_EXPN_PLN A               " ).append("\n"); 
		query.append("                                WHERE   1 = 1" ).append("\n"); 
		query.append("                                AND     A.PLN_YR = P.PLN_YR" ).append("\n"); 
		query.append("                                AND     A.VER_SEQ = P.VER_SEQ" ).append("\n"); 
		query.append("                                GROUP BY A.PLN_YR,  A.EQ_KND_CD" ).append("\n"); 
		query.append("                                        , CASE WHEN EQ_KND_CD = 'Z' THEN " ).append("\n"); 
		query.append("                                               CASE WHEN (EQ_TERM_NM = 'LT') THEN 'LS'" ).append("\n"); 
		query.append("                                                    WHEN (EQ_TERM_NM = 'ST') THEN 'LS'" ).append("\n"); 
		query.append("                                                    ELSE REPLACE(A.EQ_TERM_NM, '/', '') END" ).append("\n"); 
		query.append("                                          ELSE A.EQ_TERM_NM END" ).append("\n"); 
		query.append("                                        , A.EXPN_MON_CD        " ).append("\n"); 
		query.append("                                ) AA, " ).append("\n"); 
		query.append("                               (SELECT  NVL(BB.PLN_YR, P.PLN_YR) AS PLN_YR, " ).append("\n"); 
		query.append("                                        2 RSLT_TP_SEQ, 'U' AS EQ_KND_CD, " ).append("\n"); 
		query.append("                                        AA.EQ_TERM_NM,  AA.EXPN_MON_CD, " ).append("\n"); 
		query.append("                                        NVL(BB.EXPN_AMT, 0) AS EXPN_AMT   " ).append("\n"); 
		query.append("                                FROM    PARAM P," ).append("\n"); 
		query.append("                                       (SELECT  A.EXPN_MON, A.EXPN_MON_CD, B.EQ_TERM_NM" ).append("\n"); 
		query.append("                                        FROM   (SELECT  LEVEL AS EXPN_MON," ).append("\n"); 
		query.append("                                                        TO_CHAR(ADD_MONTHS(TO_DATE('200901', 'YYYYMM'), LEVEL -1), " ).append("\n"); 
		query.append("                                                           'MON', 'NLS_DATE_LANGUAGE = American') EXPN_MON_CD                             " ).append("\n"); 
		query.append("                                                FROM    DUAL" ).append("\n"); 
		query.append("                                                CONNECT BY LEVEL <= 12) A,             " ).append("\n"); 
		query.append("                                               (SELECT EQ_TERM_NM" ).append("\n"); 
		query.append("												FROM (SELECT 'LP' AS EQ_TERM_NM FROM DUAL  " ).append("\n"); 
		query.append("                                                UNION SELECT 'OL' FROM DUAL" ).append("\n"); 
		query.append("                                                UNION SELECT 'LT' FROM DUAL" ).append("\n"); 
		query.append("                                                UNION SELECT 'ST' FROM DUAL" ).append("\n"); 
		query.append("                                                UNION SELECT 'SB' FROM DUAL" ).append("\n"); 
		query.append("                                                UNION SELECT 'SO' FROM DUAL)" ).append("\n"); 
		query.append("									#if (${eq_term_nm} != '')" ).append("\n"); 
		query.append("										WHERE  EQ_TERM_NM IN (" ).append("\n"); 
		query.append("											#foreach($key IN ${eq_term_nm_seq})" ).append("\n"); 
		query.append("												#if($velocityCount < $eq_term_nm_seq.size())" ).append("\n"); 
		query.append("													'$key'," ).append("\n"); 
		query.append("												#else" ).append("\n"); 
		query.append("													'$key'" ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("											#end" ).append("\n"); 
		query.append("		                        				)" ).append("\n"); 
		query.append("									#end												" ).append("\n"); 
		query.append("												) B" ).append("\n"); 
		query.append("                                        ) AA,   " ).append("\n"); 
		query.append("                                       (SELECT  PLN_YR, EQ_TERM_NM, " ).append("\n"); 
		query.append("                                                TO_CHAR(EXPN_MON_CD,'MON','NLS_DATE_LANGUAGE = American') AS EXPN_MON_CD," ).append("\n"); 
		query.append("                                                SUM(EXPN_AMT) AS EXPN_AMT" ).append("\n"); 
		query.append("                                        FROM   (SELECT  SUBSTR(A.CHG_COST_YRMON, 1,4) AS PLN_YR," ).append("\n"); 
		query.append("                                                        A.LSTM_CD AS EQ_TERM_NM," ).append("\n"); 
		query.append("                                                        TO_DATE(A.CHG_COST_YRMON,'YYYYMM') AS EXPN_MON_CD,        " ).append("\n"); 
		query.append("                                                        NVL(A.PAY_RNTL_COST_AMT, 0) AS EXPN_AMT" ).append("\n"); 
		query.append("                                                FROM    LSE_PAY_RNTL_CHG A," ).append("\n"); 
		query.append("                                                        PARAM P" ).append("\n"); 
		query.append("                                                WHERE   A.CHG_COST_YRMON LIKE P.PLN_YR||'%'" ).append("\n"); 
		query.append("                                                AND     A.LSTM_CD IN ('LP','OL','LT','ST','SB')                                " ).append("\n"); 
		query.append("                                                UNION ALL" ).append("\n"); 
		query.append("                                                SELECT  P.PLN_YR AS PLN_YR," ).append("\n"); 
		query.append("                                                        'LP' AS EQ_TERM_NM," ).append("\n"); 
		query.append("                                                        TO_DATE(A.SKD_VOY_NO,'YYMM') AS EXPN_MON_CD," ).append("\n"); 
		query.append("                                                        A.PAY_AMT AS EXPN_AMT" ).append("\n"); 
		query.append("                                                FROM    LSE_OP_LSE A," ).append("\n"); 
		query.append("                                                        PARAM P" ).append("\n"); 
		query.append("                                                WHERE   A.SKD_VOY_NO LIKE SUBSTR(P.PLN_YR,3)||'%' " ).append("\n"); 
		query.append("                                                AND     A.AP_IF_FLG = 'Y'                                                                " ).append("\n"); 
		query.append("                                                UNION ALL                                " ).append("\n"); 
		query.append("                                                SELECT  SUBSTR(A.QTY_YRMON, 1,4) AS PLN_YR," ).append("\n"); 
		query.append("                                                        A.LSTM_CD AS EQ_TERM_NM," ).append("\n"); 
		query.append("                                                        TO_DATE(A.QTY_YRMON,'YYYYMM') AS EXPN_MON_CD," ).append("\n"); 
		query.append("                                                        - NVL(A.INV_AMT, 0) AS EXPN_AMT" ).append("\n"); 
		query.append("                                                FROM    LSE_RCV_RNTL_CHG A," ).append("\n"); 
		query.append("                                                        PARAM P" ).append("\n"); 
		query.append("                                                WHERE   A.QTY_YRMON LIKE P.PLN_YR||'%'" ).append("\n"); 
		query.append("                                                AND     A.LSTM_CD = 'SO'                                " ).append("\n"); 
		query.append("                                                AND     A.CXL_FLG = 'N'" ).append("\n"); 
		query.append("                                                AND     A.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                )        " ).append("\n"); 
		query.append("                                        GROUP BY PLN_YR, EQ_TERM_NM, EXPN_MON_CD                                                " ).append("\n"); 
		query.append("                                        ) BB" ).append("\n"); 
		query.append("                                WHERE   AA.EXPN_MON_CD = BB.EXPN_MON_CD(+)" ).append("\n"); 
		query.append("                                AND     AA.EQ_TERM_NM  = BB.EQ_TERM_NM(+)" ).append("\n"); 
		query.append("							#if (${eq_knd_cd} != '')" ).append("\n"); 
		query.append("								AND     P.EQ_KND_NM = 'CNTR'" ).append("\n"); 
		query.append("							#end    " ).append("\n"); 
		query.append("                                UNION " ).append("\n"); 
		query.append("                                SELECT  NVL(BB.PLN_YR, P.PLN_YR) AS PLN_YR, " ).append("\n"); 
		query.append("                                        2 RSLT_TP_SEQ, 'Z' AS EQ_KND_CD, " ).append("\n"); 
		query.append("                                        AA.EQ_TERM_NM,  AA.EXPN_MON_CD, " ).append("\n"); 
		query.append("                                        NVL(BB.EXPN_AMT, 0) AS EXPN_AMT   " ).append("\n"); 
		query.append("                                FROM    PARAM P," ).append("\n"); 
		query.append("                                       (SELECT  A.EXPN_MON, A.EXPN_MON_CD, B.EQ_TERM_NM" ).append("\n"); 
		query.append("                                        FROM   (SELECT	LEVEL AS EXPN_MON," ).append("\n"); 
		query.append("                                                        TO_CHAR(ADD_MONTHS(TO_DATE('200901', 'YYYYMM'), LEVEL -1), " ).append("\n"); 
		query.append("                                                           'MON', 'NLS_DATE_LANGUAGE = American') EXPN_MON_CD                             " ).append("\n"); 
		query.append("                                                FROM	DUAL" ).append("\n"); 
		query.append("                                                CONNECT BY LEVEL <= 12) A,             " ).append("\n"); 
		query.append("                                               (SELECT EQ_TERM_NM" ).append("\n"); 
		query.append("												FROM (SELECT 'LP' AS EQ_TERM_NM FROM DUAL  " ).append("\n"); 
		query.append("                                                	  UNION SELECT 'OL' FROM DUAL" ).append("\n"); 
		query.append("                                                	  UNION SELECT 'LS' FROM DUAL   " ).append("\n"); 
		query.append("                                               	      UNION SELECT 'NP' FROM DUAL" ).append("\n"); 
		query.append("                                                      UNION SELECT 'CP' FROM DUAL" ).append("\n"); 
		query.append("                                                      UNION SELECT 'MG.SET' FROM DUAL)" ).append("\n"); 
		query.append("											#if (${eq_term_nm} != '')" ).append("\n"); 
		query.append("											    WHERE  EQ_TERM_NM IN (" ).append("\n"); 
		query.append("												#foreach($key IN ${eq_term_nm_seq})" ).append("\n"); 
		query.append("													#if($velocityCount < $eq_term_nm_seq.size())" ).append("\n"); 
		query.append("														DECODE('$key','LT','LS','ST','LS','$key')," ).append("\n"); 
		query.append("													#else" ).append("\n"); 
		query.append("														DECODE('$key','LT','LS','ST','LS','$key')" ).append("\n"); 
		query.append("													#end" ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("		                        					)" ).append("\n"); 
		query.append("											#end												" ).append("\n"); 
		query.append("											) B" ).append("\n"); 
		query.append("                                        ) AA," ).append("\n"); 
		query.append("                                        (   SELECT  SUBSTR(REV_YRMON,1,4)     AS PLN_YR" ).append("\n"); 
		query.append("                                                , DECODE(CNTR_TPSZ_CD, 'LT', 'LS', 'ST', 'LS', CNTR_TPSZ_CD)    AS EQ_TERM_NM" ).append("\n"); 
		query.append("                                                , TO_CHAR(TO_DATE(REV_YRMON, 'YYYYMM'), 'MON', 'NLS_DATE_LANGUAGE = American') AS EXPN_MON_CD" ).append("\n"); 
		query.append("                                                , SUM(ACT_AMT)  AS EXPN_AMT" ).append("\n"); 
		query.append("                                        FROM    GL_ESTM_IF_ERP  T," ).append("\n"); 
		query.append("												PARAM P" ).append("\n"); 
		query.append("                                        WHERE   1 = 1" ).append("\n"); 
		query.append("                                        AND     SYS_SRC_ID  = 'CHS'" ).append("\n"); 
		query.append("                                        AND     EXE_YRMON   =" ).append("\n"); 
		query.append("                                                (" ).append("\n"); 
		query.append("                                                    SELECT  MAX(S.EXE_YRMON)" ).append("\n"); 
		query.append("                                                    FROM    GL_ESTM_IF_ERP  S" ).append("\n"); 
		query.append("                                                    WHERE   T.EXE_YRMON   LIKE P.PLN_YR||'%'" ).append("\n"); 
		query.append("                                                    AND     T.SYS_SRC_ID   = S.SYS_SRC_ID" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                        GROUP BY REV_YRMON, DECODE(CNTR_TPSZ_CD, 'LT', 'LS', 'ST', 'LS', CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                                        UNION ALL" ).append("\n"); 
		query.append("                                        SELECT  SUBSTR(REV_YRMON,1,4)       AS PLN_YR" ).append("\n"); 
		query.append("                                                , 'MG.SET'                  AS EQ_TERM_NM" ).append("\n"); 
		query.append("                                                , TO_CHAR(TO_DATE(REV_YRMON, 'YYYYMM'), 'MON', 'NLS_DATE_LANGUAGE = American') AS EXPN_MON_CD" ).append("\n"); 
		query.append("                                                , SUM(ACT_AMT)  AS EXPN_AMT" ).append("\n"); 
		query.append("                                        FROM    GL_ESTM_IF_ERP  T," ).append("\n"); 
		query.append("												PARAM P" ).append("\n"); 
		query.append("                                        WHERE   1 = 1" ).append("\n"); 
		query.append("                                        AND     SYS_SRC_ID  = 'MGS'" ).append("\n"); 
		query.append("                                        AND     EXE_YRMON   =" ).append("\n"); 
		query.append("                                                (" ).append("\n"); 
		query.append("                                                    SELECT  MAX(S.EXE_YRMON)" ).append("\n"); 
		query.append("                                                    FROM    GL_ESTM_IF_ERP  S" ).append("\n"); 
		query.append("                                                    WHERE   T.EXE_YRMON   LIKE P.PLN_YR||'%'" ).append("\n"); 
		query.append("                                                    AND     T.SYS_SRC_ID   = S.SYS_SRC_ID" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                        GROUP BY REV_YRMON" ).append("\n"); 
		query.append("                                       ) BB" ).append("\n"); 
		query.append("                                WHERE   AA.EXPN_MON_CD = BB.EXPN_MON_CD(+)" ).append("\n"); 
		query.append("                                AND     AA.EQ_TERM_NM  = BB.EQ_TERM_NM (+)" ).append("\n"); 
		query.append("							#if (${eq_knd_cd} != '')" ).append("\n"); 
		query.append("								AND     P.EQ_KND_NM = 'CHSS'" ).append("\n"); 
		query.append("							#end    " ).append("\n"); 
		query.append("                                ) BB, " ).append("\n"); 
		query.append("                               (SELECT 1 AS RSLT_TP_SEQ       FROM DUAL" ).append("\n"); 
		query.append("                                UNION SELECT 2 AS RSLT_TP_SEQ FROM DUAL" ).append("\n"); 
		query.append("                                UNION SELECT 3 AS RSLT_TP_SEQ FROM DUAL " ).append("\n"); 
		query.append("                                ) CC" ).append("\n"); 
		query.append("                        WHERE   AA.PLN_YR       = BB.PLN_YR" ).append("\n"); 
		query.append("                        AND     AA.EQ_KND_CD    = BB.EQ_KND_CD" ).append("\n"); 
		query.append("                        AND     AA.EQ_TERM_NM   = BB.EQ_TERM_NM" ).append("\n"); 
		query.append("                        AND     AA.EXPN_MON_CD  = BB.EXPN_MON_CD                                     " ).append("\n"); 
		query.append("                        ) X     " ).append("\n"); 
		query.append("                WHERE	1 = 1 " ).append("\n"); 
		query.append("	#if (${expn_mon_cd} != '')" ).append("\n"); 
		query.append("   	            AND     X.EXPN_MON_CD IN (" ).append("\n"); 
		query.append("		#foreach($key IN ${expn_mon_cd_seq})" ).append("\n"); 
		query.append("			#if($velocityCount < $expn_mon_cd_seq.size())" ).append("\n"); 
		query.append("				'$key'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$key'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		                                )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                GROUP BY ROLLUP(X.PLN_YR, X.RSLT_TP_SEQ, X.EQ_KND_CD, X.EQ_TERM_NM)         " ).append("\n"); 
		query.append("                ORDER BY X.EQ_KND_CD" ).append("\n"); 
		query.append("                        , DECODE(X.EQ_TERM_NM,  'LP', 1,'OL', 2,'LT', 3,'ST', 4,'LS', 5,'SB', 6,'SO', 7,'NP', 8,'CP', 9,'MG.SET',10,11)" ).append("\n"); 
		query.append("                        , X.RSLT_TP_SEQ   " ).append("\n"); 
		query.append("                ) Z" ).append("\n"); 
		query.append("        WHERE   Z.RSLT_TP_SEQ IS NOT NULL " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}