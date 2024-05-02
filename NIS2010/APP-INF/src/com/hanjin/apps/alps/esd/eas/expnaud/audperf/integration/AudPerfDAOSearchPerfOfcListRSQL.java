/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AudPerfDAOSearchPerfOfcListRSQL.java
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

public class AudPerfDAOSearchPerfOfcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AudPerfDAOSearchPerfOfcListRSQL DESC 
	  * </pre>
	  */
	public AudPerfDAOSearchPerfOfcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_ym",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_ym",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_yn",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AudPerfDAOSearchPerfOfcListRSQL").append("\n"); 
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
		query.append("-- MON1, MON2, MON3는 없어도 조회결과에는 영향이 없으나 조회속도 향상을 위하여 추가" ).append("\n"); 
		query.append("WITH MON1 AS (" ).append("\n"); 
		query.append("#if (${s_compare_mon} == '1' || ${s_compare_mon} == '3')" ).append("\n"); 
		query.append("SELECT A.ROWID" ).append("\n"); 
		query.append("      ,SUBSTR(A.GL_DT, 1, 6) AS GL_YM" ).append("\n"); 
		query.append("      ,A.*" ).append("\n"); 
		query.append("  FROM AP_INV_HDR  A" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION O" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND O.OFC_CD = A.TJ_OFC_CD" ).append("\n"); 
		query.append("   AND A.IF_FLG IS NOT NULL" ).append("\n"); 
		query.append("   AND (A.PAY_DT IS NOT NULL OR (O.SO_IF_CD = 'O' AND A.ATTR_CTNT2 IS NOT NULL ) )" ).append("\n"); 
		query.append("   AND A.GL_DT BETWEEN @[s_fm_ym]||'01' AND (SELECT TO_CHAR(LAST_DAY(TO_DATE(@[s_to_ym]||'01', 'YYYYMMDD')), 'YYYYMMDD') FROM DUAL)" ).append("\n"); 
		query.append("   AND A.SRC_CTNT IN ('SO_TRANS', 'SO_TERMINAL', 'SO_PORT', 'SO_M&R')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_compare_mon} == '3')" ).append("\n"); 
		query.append(",MON2 AS (" ).append("\n"); 
		query.append("SELECT A.ROWID -- 전월" ).append("\n"); 
		query.append("      ,SUBSTR(A.GL_DT, 1, 6) AS GL_YM" ).append("\n"); 
		query.append("      ,A.*" ).append("\n"); 
		query.append("  FROM AP_INV_HDR  A" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION O" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND O.OFC_CD = A.TJ_OFC_CD" ).append("\n"); 
		query.append("   AND A.IF_FLG IS NOT NULL" ).append("\n"); 
		query.append("   AND (A.PAY_DT IS NOT NULL OR (O.SO_IF_CD = 'O' AND A.ATTR_CTNT2 IS NOT NULL ) )" ).append("\n"); 
		query.append("   AND A.GL_DT BETWEEN (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(@[s_fm_ym]||'01', 'YYYYMMDD'), -1), 'YYYYMMDD') FROM DUAL)" ).append("\n"); 
		query.append("                   AND (SELECT TO_CHAR(LAST_DAY(ADD_MONTHS(TO_DATE(@[s_to_ym]||'01', 'YYYYMMDD'), -1)), 'YYYYMMDD') FROM DUAL)" ).append("\n"); 
		query.append("   AND A.SRC_CTNT IN ('SO_TRANS', 'SO_TERMINAL', 'SO_PORT', 'SO_M&R')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",MON3 AS (" ).append("\n"); 
		query.append("SELECT A.ROWID -- 전년 동기" ).append("\n"); 
		query.append("      ,SUBSTR(A.GL_DT, 1, 6) AS GL_YM   " ).append("\n"); 
		query.append("      ,A.*      " ).append("\n"); 
		query.append("  FROM AP_INV_HDR  A" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION O" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND O.OFC_CD = A.TJ_OFC_CD" ).append("\n"); 
		query.append("   AND A.IF_FLG IS NOT NULL" ).append("\n"); 
		query.append("   AND (A.PAY_DT IS NOT NULL OR (O.SO_IF_CD = 'O' AND A.ATTR_CTNT2 IS NOT NULL ) )" ).append("\n"); 
		query.append("   AND A.GL_DT BETWEEN (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(@[s_fm_ym]||'01', 'YYYYMMDD'), -12), 'YYYYMMDD') FROM DUAL)" ).append("\n"); 
		query.append("                   AND (SELECT TO_CHAR(LAST_DAY(ADD_MONTHS(TO_DATE(@[s_to_ym]||'01', 'YYYYMMDD'), -12)), 'YYYYMMDD') FROM DUAL)" ).append("\n"); 
		query.append("   AND A.SRC_CTNT IN ('SO_TRANS', 'SO_TERMINAL', 'SO_PORT', 'SO_M&R')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",M1 AS (" ).append("\n"); 
		query.append("    SELECT RHQ_CD" ).append("\n"); 
		query.append("          ,OFC_CD" ).append("\n"); 
		query.append("          ,(SELECT TO_CHAR(ADD_MONTHS(TO_DATE(GL_YM||'01', 'YYYYMMDD'), STND_CAL_MON), 'YYYYMM') FROM DUAL) STND_YM" ).append("\n"); 
		query.append("          ,GL_YM" ).append("\n"); 
		query.append("          ,YM_TP_CD" ).append("\n"); 
		query.append("          ,SUM(INV_TES_QTY) INV_TES_QTY" ).append("\n"); 
		query.append("          ,ROUND(SUM(INV_TES_AMT),2) INV_TES_AMT" ).append("\n"); 
		query.append("          ,SUM(INV_TRS_QTY) INV_TRS_QTY" ).append("\n"); 
		query.append("          ,ROUND(SUM(INV_TRS_AMT),2) INV_TRS_AMT" ).append("\n"); 
		query.append("          ,SUM(INV_MNR_QTY) INV_MNR_QTY" ).append("\n"); 
		query.append("          ,ROUND(SUM(INV_MNR_AMT),2) INV_MNR_AMT" ).append("\n"); 
		query.append("          ,SUM(INV_PSO_QTY) INV_PSO_QTY" ).append("\n"); 
		query.append("          ,ROUND(SUM(INV_PSO_AMT),2) INV_PSO_AMT" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            -- 1. 조회 년월로 조회" ).append("\n"); 
		query.append("		#if (${s_compare_mon} == '1' || ${s_compare_mon} == '3')" ).append("\n"); 
		query.append("            SELECT (SELECT TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(OFC_CD) FROM DUAL) AS RHQ_CD" ).append("\n"); 
		query.append("                  ,DECODE(@[s_rhq_yn], 'Y', (SELECT TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(OFC_CD) FROM DUAL), OFC_CD) OFC_CD" ).append("\n"); 
		query.append("                  ,GL_YM" ).append("\n"); 
		query.append("                  ,0 STND_CAL_MON" ).append("\n"); 
		query.append("                  ,YM_TP_CD" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TERMINAL' THEN INV_CNT END INV_TES_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TERMINAL' THEN USD_AMT END INV_TES_AMT" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TRANS' THEN INV_CNT END INV_TRS_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TRANS' THEN USD_AMT END INV_TRS_AMT" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_M&R' THEN INV_CNT END INV_MNR_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_M&R' THEN USD_AMT END INV_MNR_AMT" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_PORT' THEN INV_CNT END INV_PSO_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_PORT' THEN USD_AMT END INV_PSO_AMT" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    SELECT A.TJ_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("                          ,A.GL_YM" ).append("\n"); 
		query.append("                          ,SRC_CTNT AS MDL_CD" ).append("\n"); 
		query.append("                          ,COUNT(DISTINCT A.VNDR_NO||B.ATTR_CTNT1) INV_CNT" ).append("\n"); 
		query.append("                          ,SUM((SELECT ROUND((B.INV_AMT / X.USD_LOCL_XCH_RT), 2)" ).append("\n"); 
		query.append("                                  FROM GL_MON_XCH_RT X" ).append("\n"); 
		query.append("                                 WHERE X.CURR_CD = A.CSR_CURR_CD" ).append("\n"); 
		query.append("                                   AND X.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                                   AND X.ACCT_XCH_RT_YRMON = SUBSTR(A.GL_DT, 1, 6)))  AS USD_AMT" ).append("\n"); 
		query.append("                          ,'1' YM_TP_CD -- 당월자료" ).append("\n"); 
		query.append("                      FROM MON1 A" ).append("\n"); 
		query.append("                          ,AP_INV_DTRB B" ).append("\n"); 
		query.append("                     WHERE A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("                       AND B.FTU_USE_CTNT1 IS NOT NULL" ).append("\n"); 
		query.append("					#if ( ${s_rhq_ofc_cd} != '' )" ).append("\n"); 
		query.append("                       AND A.TJ_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                            WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                          CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                                            START WITH OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_ofc_cd} != '' )" ).append("\n"); 
		query.append("                       AND A.TJ_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_mdl_cd} != '' )" ).append("\n"); 
		query.append("                       AND A.SRC_CTNT  = @[s_mdl_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_lgs_cost_cd} != '' )" ).append("\n"); 
		query.append("                       AND B.FTU_USE_CTNT1 = @[s_lgs_cost_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_cgo_tp_cd} != '' )" ).append("\n"); 
		query.append("                       AND B.FTU_USE_CTNT1 IN (SELECT X.LGS_COST_CD" ).append("\n"); 
		query.append("                                                 FROM TABLE(EAS_EXPN_AUD_PKG.GET_LGS_COST_DIV_FNC()) X" ).append("\n"); 
		query.append("                                                WHERE X.CGO_TP_CD = @[s_cgo_tp_cd]" ).append("\n"); 
		query.append("                                              ) -- Cargo Type 으로 조회" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("                    GROUP BY A.TJ_OFC_CD, SRC_CTNT, SUBSTR(A.GL_DT, 1, 6)" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            --------------------------------  UNION ALL 아래는 s_compare_mon이 3일 경우만 실행되도록 한다." ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${s_compare_mon} == '3')" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            -- 2. 조회 전월로 조회" ).append("\n"); 
		query.append("            SELECT (SELECT TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(OFC_CD) FROM DUAL) AS RHQ_CD" ).append("\n"); 
		query.append("                  ,DECODE(@[s_rhq_yn], 'Y', (SELECT TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(OFC_CD) FROM DUAL), OFC_CD) OFC_CD" ).append("\n"); 
		query.append("                  ,GL_YM" ).append("\n"); 
		query.append("                  ,1 STND_CAL_MON" ).append("\n"); 
		query.append("                  ,YM_TP_CD" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TERMINAL' THEN INV_CNT END INV_TES_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TERMINAL' THEN USD_AMT END INV_TES_AMT" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TRANS' THEN INV_CNT END INV_TRS_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TRANS' THEN USD_AMT END INV_TRS_AMT" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_M&R' THEN INV_CNT END INV_MNR_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_M&R' THEN USD_AMT END INV_MNR_AMT" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_PORT' THEN INV_CNT END INV_PSO_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_PORT' THEN USD_AMT END INV_PSO_AMT" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    SELECT A.TJ_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("                          ,A.GL_YM" ).append("\n"); 
		query.append("                          ,SRC_CTNT AS MDL_CD" ).append("\n"); 
		query.append("                          ,COUNT(DISTINCT A.VNDR_NO||B.ATTR_CTNT1) INV_CNT" ).append("\n"); 
		query.append("                          ,SUM((SELECT ROUND((B.INV_AMT / X.USD_LOCL_XCH_RT), 2)" ).append("\n"); 
		query.append("                                  FROM GL_MON_XCH_RT X" ).append("\n"); 
		query.append("                                 WHERE X.CURR_CD = A.CSR_CURR_CD" ).append("\n"); 
		query.append("                                   AND X.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                                   AND X.ACCT_XCH_RT_YRMON = SUBSTR(A.GL_DT, 1, 6)))  AS USD_AMT" ).append("\n"); 
		query.append("                          ,'2' YM_TP_CD -- 전월자료" ).append("\n"); 
		query.append("                      FROM MON2 A" ).append("\n"); 
		query.append("                          ,AP_INV_DTRB B" ).append("\n"); 
		query.append("                     WHERE A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("                       AND B.FTU_USE_CTNT1 IS NOT NULL" ).append("\n"); 
		query.append("					#if ( ${s_rhq_ofc_cd} != '' )" ).append("\n"); 
		query.append("                       AND A.TJ_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                            WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                          CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                                            START WITH OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_ofc_cd} != '' )" ).append("\n"); 
		query.append("                       AND A.TJ_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_mdl_cd} != '' )" ).append("\n"); 
		query.append("                       AND A.SRC_CTNT  = @[s_mdl_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_lgs_cost_cd} != '' )" ).append("\n"); 
		query.append("                       AND B.FTU_USE_CTNT1 = @[s_lgs_cost_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_cgo_tp_cd} != '' )" ).append("\n"); 
		query.append("                       AND B.FTU_USE_CTNT1 IN (SELECT X.LGS_COST_CD" ).append("\n"); 
		query.append("                                                 FROM TABLE(EAS_EXPN_AUD_PKG.GET_LGS_COST_DIV_FNC()) X" ).append("\n"); 
		query.append("                                                WHERE X.CGO_TP_CD = @[s_cgo_tp_cd]" ).append("\n"); 
		query.append("                                              ) -- Cargo Type 으로 조회" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("                    GROUP BY A.TJ_OFC_CD, SRC_CTNT, SUBSTR(A.GL_DT, 1, 6)" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            -- 3. 전년동기로 조회" ).append("\n"); 
		query.append("            SELECT (SELECT TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(OFC_CD) FROM DUAL) AS RHQ_CD" ).append("\n"); 
		query.append("                  ,DECODE(@[s_rhq_yn], 'Y', (SELECT TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(OFC_CD) FROM DUAL), OFC_CD) OFC_CD" ).append("\n"); 
		query.append("                  ,GL_YM" ).append("\n"); 
		query.append("                  ,12 STND_CAL_MON" ).append("\n"); 
		query.append("                  ,YM_TP_CD" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TERMINAL' THEN INV_CNT END INV_TES_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TERMINAL' THEN USD_AMT END INV_TES_AMT" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TRANS' THEN INV_CNT END INV_TRS_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_TRANS' THEN USD_AMT END INV_TRS_AMT" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_M&R' THEN INV_CNT END INV_MNR_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_M&R' THEN USD_AMT END INV_MNR_AMT" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_PORT' THEN INV_CNT END INV_PSO_QTY" ).append("\n"); 
		query.append("                  ,CASE WHEN MDL_CD = 'SO_PORT' THEN USD_AMT END INV_PSO_AMT" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    SELECT A.TJ_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("                          ,A.GL_YM" ).append("\n"); 
		query.append("                          ,SRC_CTNT AS MDL_CD" ).append("\n"); 
		query.append("                          ,COUNT(DISTINCT A.VNDR_NO||B.ATTR_CTNT1) INV_CNT" ).append("\n"); 
		query.append("                          ,SUM((SELECT ROUND((B.INV_AMT / X.USD_LOCL_XCH_RT), 2)" ).append("\n"); 
		query.append("                                  FROM GL_MON_XCH_RT X" ).append("\n"); 
		query.append("                                 WHERE X.CURR_CD = A.CSR_CURR_CD" ).append("\n"); 
		query.append("                                   AND X.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                                   AND X.ACCT_XCH_RT_YRMON = SUBSTR(A.GL_DT, 1, 6)))  AS USD_AMT" ).append("\n"); 
		query.append("                          ,'3' YM_TP_CD -- 전년동기 자료" ).append("\n"); 
		query.append("                      FROM MON3 A" ).append("\n"); 
		query.append("                          ,AP_INV_DTRB B" ).append("\n"); 
		query.append("                     WHERE A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("                       AND B.FTU_USE_CTNT1 IS NOT NULL" ).append("\n"); 
		query.append("					#if ( ${s_rhq_ofc_cd} != '' )" ).append("\n"); 
		query.append("                       AND A.TJ_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                            WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                          CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                                            START WITH OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_ofc_cd} != '' )" ).append("\n"); 
		query.append("                       AND A.TJ_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_mdl_cd} != '' )" ).append("\n"); 
		query.append("                       AND A.SRC_CTNT  = @[s_mdl_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_lgs_cost_cd} != '' )" ).append("\n"); 
		query.append("                       AND B.FTU_USE_CTNT1 = @[s_lgs_cost_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if ( ${s_cgo_tp_cd} != '' )" ).append("\n"); 
		query.append("                       AND B.FTU_USE_CTNT1 IN (SELECT X.LGS_COST_CD" ).append("\n"); 
		query.append("                                                 FROM TABLE(EAS_EXPN_AUD_PKG.GET_LGS_COST_DIV_FNC()) X" ).append("\n"); 
		query.append("                                                WHERE X.CGO_TP_CD = @[s_cgo_tp_cd]" ).append("\n"); 
		query.append("                                              ) -- Cargo Type 으로 조회" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("                    GROUP BY A.TJ_OFC_CD, SRC_CTNT, SUBSTR(A.GL_DT, 1, 6)" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("    GROUP BY RHQ_CD, OFC_CD, STND_CAL_MON, GL_YM, YM_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MM.RHQ_CD" ).append("\n"); 
		query.append("      ,MM.OFC_CD" ).append("\n"); 
		query.append("      ,MM.STND_YM" ).append("\n"); 
		query.append("      ,CASE WHEN MM.YM_TP_CD = '1' THEN MM.STND_YM" ).append("\n"); 
		query.append("            WHEN MM.YM_TP_CD = '2' THEN (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(MM.STND_YM||'01', 'YYYYMMDD'), -1), 'YYYYMM') FROM DUAL)" ).append("\n"); 
		query.append("            WHEN MM.YM_TP_CD = '3' THEN (SELECT TO_CHAR(ADD_MONTHS(TO_DATE(MM.STND_YM||'01', 'YYYYMMDD'), -12), 'YYYYMM') FROM DUAL)" ).append("\n"); 
		query.append("       END AS GL_MON" ).append("\n"); 
		query.append("      ,MM.YM_TP_CD" ).append("\n"); 
		query.append("      ,M1.INV_TES_QTY" ).append("\n"); 
		query.append("      ,M1.INV_TES_AMT" ).append("\n"); 
		query.append("      ,M1.INV_TRS_QTY" ).append("\n"); 
		query.append("      ,M1.INV_TRS_AMT" ).append("\n"); 
		query.append("      ,M1.INV_MNR_QTY" ).append("\n"); 
		query.append("      ,M1.INV_MNR_AMT" ).append("\n"); 
		query.append("      ,M1.INV_PSO_QTY" ).append("\n"); 
		query.append("      ,M1.INV_PSO_AMT" ).append("\n"); 
		query.append("		, '' as S_RHQ_YN" ).append("\n"); 
		query.append("		, '' as S_FM_YM" ).append("\n"); 
		query.append("		, '' as S_TO_YM" ).append("\n"); 
		query.append("		, '' as S_RHQ_OFC_CD" ).append("\n"); 
		query.append("		, '' as S_COMPARE_MON" ).append("\n"); 
		query.append("		, '' as S_OFC_CD" ).append("\n"); 
		query.append("		, '' as S_MDL_CD" ).append("\n"); 
		query.append("		, '' as S_LGS_COST_CD" ).append("\n"); 
		query.append("		, '' as S_CGO_TP_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT M.RHQ_CD, M.OFC_CD, M.STND_YM, N.YM_TP_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT RHQ_CD, OFC_CD, STND_YM" ).append("\n"); 
		query.append("                  FROM M1" ).append("\n"); 
		query.append("                 GROUP BY RHQ_CD, OFC_CD, STND_YM" ).append("\n"); 
		query.append("               ) M" ).append("\n"); 
		query.append("              ,(SELECT ROWNUM AS YM_TP_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               CONNECT BY LEVEL <= @[s_compare_mon]" ).append("\n"); 
		query.append("               ) N" ).append("\n"); 
		query.append("       ) MM" ).append("\n"); 
		query.append("      ,M1" ).append("\n"); 
		query.append(" WHERE MM.RHQ_CD  = M1.RHQ_CD(+)" ).append("\n"); 
		query.append("   AND MM.OFC_CD  = M1.OFC_CD(+)" ).append("\n"); 
		query.append("   AND MM.STND_YM = M1.STND_YM(+)" ).append("\n"); 
		query.append("   AND MM.YM_TP_CD = M1.YM_TP_CD(+)" ).append("\n"); 
		query.append("ORDER BY MM.RHQ_CD, MM.OFC_CD, MM.STND_YM, MM.YM_TP_CD" ).append("\n"); 

	}
}