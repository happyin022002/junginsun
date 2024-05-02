/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AudPerfDAOSearchPerfSpDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.12.17 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.audperf.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AudPerfDAOSearchPerfSpDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AudPerfDAOSearchPerfSpDtlListRSQL DESC 
	  * </pre>
	  */
	public AudPerfDAOSearchPerfSpDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ym",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_mdl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_compare_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.audperf.integration").append("\n"); 
		query.append("FileName : AudPerfDAOSearchPerfSpDtlListRSQL").append("\n"); 
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
		query.append("WITH M1 AS (" ).append("\n"); 
		query.append("   SELECT A.TJ_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("          ,@[s_ym] AS STND_YM" ).append("\n"); 
		query.append("          ,SUBSTR(A.GL_DT, 1, 6) AS GL_YM" ).append("\n"); 
		query.append("          ,CASE WHEN A.SRC_CTNT = 'SO_TRANS' THEN 'TRS'" ).append("\n"); 
		query.append("                WHEN A.SRC_CTNT = 'SO_TERMINAL' THEN 'TES'" ).append("\n"); 
		query.append("                WHEN A.SRC_CTNT = 'SO_PORT' THEN 'PSO'" ).append("\n"); 
		query.append("                WHEN A.SRC_CTNT = 'SO_M&R' THEN 'M&R'" ).append("\n"); 
		query.append("           END AS MDL_CD" ).append("\n"); 
		query.append("          ,A.VNDR_NO" ).append("\n"); 
		query.append("          ,COUNT(DISTINCT A.VNDR_NO||B.ATTR_CTNT1) INV_QTY" ).append("\n"); 
		query.append("          ,A.CSR_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("          ,SUM(B.INV_AMT) AS CURR_AMT" ).append("\n"); 
		query.append("          ,SUM((SELECT ROUND((B.INV_AMT / X.USD_LOCL_XCH_RT), 2)" ).append("\n"); 
		query.append("                  FROM GL_MON_XCH_RT X" ).append("\n"); 
		query.append("                 WHERE X.CURR_CD = A.CSR_CURR_CD" ).append("\n"); 
		query.append("                   AND X.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                   AND X.ACCT_XCH_RT_YRMON = SUBSTR(A.GL_DT, 1, 6)))  AS USD_AMT" ).append("\n"); 
		query.append("          ,CASE WHEN SUBSTR(A.GL_DT, 1, 6) = @[s_ym] THEN '1'" ).append("\n"); 
		query.append("                WHEN SUBSTR(A.GL_DT, 1, 6) = (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(@[s_ym]||'01', 'YYYYMMDD'), -1), 'YYYYMM') FROM DUAL) THEN '2'" ).append("\n"); 
		query.append("                WHEN SUBSTR(A.GL_DT, 1, 6) = (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(@[s_ym]||'01', 'YYYYMMDD'), -12), 'YYYYMM') FROM DUAL) THEN '3'" ).append("\n"); 
		query.append("           END AS YM_TP_CD" ).append("\n"); 
		query.append("      FROM AP_INV_HDR  A" ).append("\n"); 
		query.append("          ,AP_INV_DTRB B" ).append("\n"); 
		query.append("          ,MDM_ORGANIZATION O" ).append("\n"); 
		query.append("     WHERE A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("       AND O.OFC_CD = A.TJ_OFC_CD" ).append("\n"); 
		query.append("       AND A.IF_FLG IS NOT NULL " ).append("\n"); 
		query.append("       AND (A.PAY_DT IS NOT NULL OR (O.SO_IF_CD = 'O' AND A.ATTR_CTNT2 IS NOT NULL ) )" ).append("\n"); 
		query.append("	#if (${s_compare_mon} == '1')" ).append("\n"); 
		query.append("       -- 당월로 조회 (s_compare_mon : 1)" ).append("\n"); 
		query.append("       AND A.GL_DT BETWEEN @[s_ym]||'01' AND (SELECT TO_CHAR(LAST_DAY(TO_DATE(@[s_ym]||'01', 'YYYYMMDD')), 'YYYYMMDD') FROM DUAL)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_compare_mon} == '3')" ).append("\n"); 
		query.append("       -- Show Comparison Month로 조회 (s_compare_mon : 3)" ).append("\n"); 
		query.append("       AND (  (A.GL_DT BETWEEN (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(@[s_ym]||'01', 'YYYYMMDD'), -1), 'YYYYMMDD') FROM DUAL) AND (SELECT TO_CHAR(LAST_DAY(TO_DATE(@[s_ym]||'01', 'YYYYMMDD')), 'YYYYMMDD') FROM DUAL)" ).append("\n"); 
		query.append("         OR(A.GL_DT BETWEEN (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(@[s_ym]||'01', 'YYYYMMDD'), -12), 'YYYYMMDD') FROM DUAL) AND (SELECT TO_CHAR(LAST_DAY(ADD_MONTHS(TO_DATE(@[s_ym]||'01', 'YYYYMMDD'), -12)), 'YYYYMMDD') FROM DUAL) )))" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("       AND A.SRC_CTNT IN ('SO_TRANS', 'SO_TERMINAL', 'SO_PORT', 'SO_M&R')" ).append("\n"); 
		query.append("       AND B.FTU_USE_CTNT1 IS NOT NULL" ).append("\n"); 
		query.append("       #if ( ${s_rhq_yn} == 'Y' )" ).append("\n"); 
		query.append("          AND A.TJ_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                               WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                             CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                               START WITH OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("           AND A.TJ_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("	#if (${s_mdl_cd} != '')" ).append("\n"); 
		query.append("       AND A.SRC_CTNT  = @[s_mdl_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    GROUP BY A.TJ_OFC_CD" ).append("\n"); 
		query.append("           , A.SRC_CTNT, A.VNDR_NO, A.CSR_CURR_CD, SUBSTR(A.GL_DT, 1, 6)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MM.OFC_CD" ).append("\n"); 
		query.append("      ,CASE WHEN MM.YM_TP_CD = '1' THEN (SELECT TO_CHAR(TO_DATE(@[s_ym]||'01', 'YYYYMMDD'), 'YYYY-MM') FROM DUAL)" ).append("\n"); 
		query.append("            WHEN MM.YM_TP_CD = '2' THEN (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(@[s_ym]||'01', 'YYYYMMDD'), -1), 'YYYY-MM') FROM DUAL)" ).append("\n"); 
		query.append("            WHEN MM.YM_TP_CD = '3' THEN (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(@[s_ym]||'01', 'YYYYMMDD'), -12), 'YYYY-MM') FROM DUAL)" ).append("\n"); 
		query.append("       END AS GL_MON" ).append("\n"); 
		query.append("      ,MM.MDL_CD" ).append("\n"); 
		query.append("      ,MM.VNDR_NO" ).append("\n"); 
		query.append("      ,C1.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("      ,C1.LOC_CD" ).append("\n"); 
		query.append("      ,M1.INV_QTY" ).append("\n"); 
		query.append("      ,MM.CURR_CD" ).append("\n"); 
		query.append("      ,M1.CURR_AMT" ).append("\n"); 
		query.append("      ,M1.USD_AMT" ).append("\n"); 
		query.append("      ,MM.STND_YM" ).append("\n"); 
		query.append("      ,MM.YM_TP_CD" ).append("\n"); 
		query.append("      ,1 ORD" ).append("\n"); 
		query.append("      ,'' AS S_YM" ).append("\n"); 
		query.append("      ,'' AS S_COMPARE_MON" ).append("\n"); 
		query.append("      ,'' AS S_MDL_CD" ).append("\n"); 
		query.append("      ,'' AS S_OFC_CD" ).append("\n"); 
		query.append("      ,'' as S_RHQ_YN" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT M.OFC_CD, M.STND_YM, M.MDL_CD, M.VNDR_NO, N.YM_TP_CD, M.CURR_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT OFC_CD, STND_YM, MDL_CD, VNDR_NO, CURR_CD" ).append("\n"); 
		query.append("                  FROM M1" ).append("\n"); 
		query.append("                 GROUP BY OFC_CD, STND_YM, MDL_CD, VNDR_NO, CURR_CD" ).append("\n"); 
		query.append("               ) M" ).append("\n"); 
		query.append("              ,(SELECT ROWNUM AS YM_TP_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               CONNECT BY LEVEL <= @[s_compare_mon]" ).append("\n"); 
		query.append("               ) N" ).append("\n"); 
		query.append("       ) MM" ).append("\n"); 
		query.append("      ,M1" ).append("\n"); 
		query.append("      ,MDM_VENDOR  C1" ).append("\n"); 
		query.append(" WHERE MM.OFC_CD  = M1.OFC_CD(+)" ).append("\n"); 
		query.append("   AND MM.STND_YM = M1.STND_YM(+)" ).append("\n"); 
		query.append("   AND MM.MDL_CD  = M1.MDL_CD(+)" ).append("\n"); 
		query.append("   AND MM.VNDR_NO = M1.VNDR_NO(+)" ).append("\n"); 
		query.append("   AND MM.CURR_CD = M1.CURR_CD(+)" ).append("\n"); 
		query.append("   AND MM.YM_TP_CD = M1.YM_TP_CD(+)" ).append("\n"); 
		query.append("   AND MM.VNDR_NO  = C1.VNDR_SEQ(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'TOTAL' OFC_CD" ).append("\n"); 
		query.append("      ,CASE WHEN MM.YM_TP_CD = '1' THEN (SELECT TO_CHAR(TO_DATE(@[s_ym]||'01', 'YYYYMMDD'), ' YYYY-MM ') FROM DUAL)" ).append("\n"); 
		query.append("            WHEN MM.YM_TP_CD = '2' THEN (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(@[s_ym]||'01', 'YYYYMMDD'), -1), ' YYYY-MM ') FROM DUAL)" ).append("\n"); 
		query.append("            WHEN MM.YM_TP_CD = '3' THEN (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(@[s_ym]||'01', 'YYYYMMDD'), -12), ' YYYY-MM ') FROM DUAL)" ).append("\n"); 
		query.append("       END AS GL_MON" ).append("\n"); 
		query.append("      ,MM.MDL_CD" ).append("\n"); 
		query.append("      ,NULL VNDR_NO" ).append("\n"); 
		query.append("      ,NULL VNDR_NM" ).append("\n"); 
		query.append("      ,NULL LOC_CD" ).append("\n"); 
		query.append("      ,SUM(M1.INV_QTY) INV_QTY" ).append("\n"); 
		query.append("      ,MM.CURR_CD" ).append("\n"); 
		query.append("      ,SUM(M1.CURR_AMT) CURR_AMT" ).append("\n"); 
		query.append("      ,SUM(M1.USD_AMT) USD_AMT" ).append("\n"); 
		query.append("      ,MM.STND_YM" ).append("\n"); 
		query.append("      ,MM.YM_TP_CD" ).append("\n"); 
		query.append("      ,2 ORD" ).append("\n"); 
		query.append("      ,'' AS S_YM" ).append("\n"); 
		query.append("      ,'' AS S_COMPARE_MON" ).append("\n"); 
		query.append("      ,'' AS S_MDL_CD" ).append("\n"); 
		query.append("      ,'' AS S_OFC_CD" ).append("\n"); 
		query.append("      ,'' as S_RHQ_YN" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT M.OFC_CD, M.STND_YM, M.MDL_CD, M.VNDR_NO, N.YM_TP_CD, M.CURR_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT OFC_CD, STND_YM, MDL_CD, VNDR_NO, CURR_CD" ).append("\n"); 
		query.append("                  FROM M1" ).append("\n"); 
		query.append("                 GROUP BY OFC_CD, STND_YM, MDL_CD, VNDR_NO, CURR_CD" ).append("\n"); 
		query.append("               ) M" ).append("\n"); 
		query.append("              ,(SELECT ROWNUM AS YM_TP_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               CONNECT BY LEVEL <= @[s_compare_mon]" ).append("\n"); 
		query.append("               ) N" ).append("\n"); 
		query.append("       ) MM" ).append("\n"); 
		query.append("      ,M1" ).append("\n"); 
		query.append("      ,MDM_VENDOR  C1" ).append("\n"); 
		query.append(" WHERE MM.OFC_CD  = M1.OFC_CD(+)" ).append("\n"); 
		query.append("   AND MM.STND_YM = M1.STND_YM(+)" ).append("\n"); 
		query.append("   AND MM.MDL_CD  = M1.MDL_CD(+)" ).append("\n"); 
		query.append("   AND MM.VNDR_NO = M1.VNDR_NO(+)" ).append("\n"); 
		query.append("   AND MM.CURR_CD = M1.CURR_CD(+)" ).append("\n"); 
		query.append("   AND MM.YM_TP_CD = M1.YM_TP_CD(+)" ).append("\n"); 
		query.append("   AND MM.VNDR_NO  = C1.VNDR_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY MM.MDL_CD, MM.CURR_CD, MM.STND_YM, MM.YM_TP_CD" ).append("\n"); 
		query.append("ORDER BY ORD, MDL_CD, OFC_CD, VNDR_NO, CURR_CD ASC, GL_MON DESC" ).append("\n"); 

	}
}