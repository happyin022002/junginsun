/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchCaSummaryReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchCaSummaryReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchCaSummaryReportRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchCaSummaryReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchCaSummaryReportRSQL").append("\n"); 
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
		query.append("SELECT B.GUBUN, " ).append("\n"); 
		query.append("       DECODE(B.GUBUN, 2, 'RHQ Sub Total', 3, 'Grand Total', A.SLS_RHQ_CD) SLS_RHQ_CD, " ).append("\n"); 
		query.append("       DECODE(B.GUBUN, 1, A.BKG_OFC_CD,     '') BKG_OFC_CD," ).append("\n"); 
		query.append("       DECODE(B.GUBUN, 1, A.CORR_OFC_CD,    '') CORR_OFC_CD," ).append("\n"); 
		query.append("       DECODE(B.GUBUN, 1, A.CTRT_OFC_CD,    '') CTRT_OFC_CD," ).append("\n"); 
		query.append("       DECODE(B.GUBUN, 1, A.POR_CD,         '') POR_CD," ).append("\n"); 
		query.append("       DECODE(B.GUBUN, 1, A.POL_CD,         '') POL_CD," ).append("\n"); 
		query.append("       DECODE(B.GUBUN, 1, A.POD_CD,         '') POD_CD," ).append("\n"); 
		query.append("       DECODE(B.GUBUN, 1, A.DEL_CD,         '') DEL_CD, " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       DECODE(B.GUBUN, 1, COUNT(A.BL_NO),   '') BL_NO_CNT, " ).append("\n"); 
		query.append("       DECODE(B.GUBUN, 1, COUNT(A.CORR_NO), '') CORR_NO_CNT, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'M', 1)), 0) CA_RSN_CD_M, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'C', 1)), 0) CA_RSN_CD_C, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'G', 1)), 0) CA_RSN_CD_G, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'A', 1)), 0) CA_RSN_CD_A, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'R', 1)), 0) CA_RSN_CD_R,   " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.RAT_FLG,   'Y', 1)), 0)  HAUL_C, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.EXPN_FLG,  'Y', 1)), 0)  HAUL_M," ).append("\n"); 
		query.append("       DECODE(COUNT(A.DOC_PERF_EXPT_CD), 0, SUM(DECODE(A.RAT_FLG, 'Y', 1)), " ).append("\n"); 
		query.append("                                            COUNT(A.DOC_PERF_EXPT_CD)) EXERRPT, " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.RAT_FLG,   'Y', 1)), 0) RAT_FLG_Y, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.RAT_FLG,   'N', 1)), 0) RAT_FLG_N, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.EXPN_FLG,  'Y', 1)), 0) EXPN_FLG, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'A', 1)), 0) CA_KIND_A, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'B', 1)), 0) CA_KIND_B, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'C', 1)), 0) CA_KIND_C, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'D', 1)), 0) CA_KIND_D, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'E', 1)), 0) CA_KIND_E, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'G', 1)), 0) CA_KIND_F, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'G', 1)), 0) CA_KIND_G, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'H', 1)), 0) CA_KIND_H, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'I', 1)), 0) CA_KIND_I, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'J', 1)), 0) CA_KIND_J, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.CA_RSN_CD, 'K', 1)), 0) CA_KIND_K" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT /*+ INDEX(BKG XAK3BKG_BOOKING) USE_NL(BKG, CA) */ " ).append("\n"); 
		query.append("               BKG.SLS_RGN_OFC_CD SLS_RHQ_CD, " ).append("\n"); 
		query.append("               CA.CORR_OFC_CD, " ).append("\n"); 
		query.append("               BKG.BKG_OFC_CD, " ).append("\n"); 
		query.append("               BKG.CTRT_OFC_CD, " ).append("\n"); 
		query.append("               BKG.POR_CD," ).append("\n"); 
		query.append("               BKG.POL_CD," ).append("\n"); 
		query.append("               BKG.POD_CD," ).append("\n"); 
		query.append("               BKG.DEL_CD," ).append("\n"); 
		query.append("               BKG.BL_NO, " ).append("\n"); 
		query.append("               CA.CORR_NO, " ).append("\n"); 
		query.append("               CA.CA_RSN_CD, " ).append("\n"); 
		query.append("               CA.RAT_FLG, " ).append("\n"); 
		query.append("               CA.EXPN_FLG, " ).append("\n"); 
		query.append("               CA.DOC_PERF_EXPT_CD  " ).append("\n"); 
		query.append("          FROM BKG_CORRECTION CA, " ).append("\n"); 
		query.append("               BKG_BOOKING    BKG  " ).append("\n"); 
		query.append("         WHERE CA.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("           AND BKG.BKG_CRE_DT BETWEEN TO_DATE('2009-01-01', 'YYYY-MM-DD') " ).append("\n"); 
		query.append("                                  AND TO_DATE('2009-02-01'||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')  " ).append("\n"); 
		query.append("           AND CA.CORR_DT BETWEEN TO_DATE('2009-01-01', 'YYYY-MM-DD') " ).append("\n"); 
		query.append("                              AND TO_DATE('2009-02-01'||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND BKG.BKG_STS_CD IN ('F','S')" ).append("\n"); 
		query.append("           AND BKG_CGO_TP_CD = 'F'  " ).append("\n"); 
		query.append("       ) A, " ).append("\n"); 
		query.append("       (SELECT ROWNUM GUBUN" ).append("\n"); 
		query.append("          FROM COM_ERR_MSG" ).append("\n"); 
		query.append("         WHERE ROWNUM <= 3 " ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("  GROUP BY B.GUBUN, " ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 3, '', A.SLS_RHQ_CD), " ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 2, 'RHQ Sub Total', 3, 'Grand Total', A.SLS_RHQ_CD),  " ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.BKG_OFC_CD, ''), " ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.CORR_OFC_CD, ''), " ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.CTRT_OFC_CD, ''), " ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.POR_CD, '')," ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.POL_CD, '')," ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.POD_CD, '')," ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.DEL_CD, '') " ).append("\n"); 
		query.append("  ORDER BY DECODE(B.GUBUN, 3, '', A.SLS_RHQ_CD), " ).append("\n"); 
		query.append("           B.GUBUN, " ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.BKG_OFC_CD, ''), " ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.CORR_OFC_CD, ''), " ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.CTRT_OFC_CD, ''), " ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.POR_CD, '')," ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.POL_CD, '')," ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.POD_CD, '')," ).append("\n"); 
		query.append("           DECODE(B.GUBUN, 1, A.DEL_CD, '')" ).append("\n"); 

	}
}