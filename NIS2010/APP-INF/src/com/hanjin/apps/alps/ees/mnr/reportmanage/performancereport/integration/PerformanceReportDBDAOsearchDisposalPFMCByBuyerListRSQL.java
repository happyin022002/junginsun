/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOsearchDisposalPFMCByBuyerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.30
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.11.30 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOsearchDisposalPFMCByBuyerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Buyer별 매각실적 현황목록을 조회합니다.
	  * 2011.11.30 남궁진호 [CHM-201007327-01]  Buyer 코드 이관작업에 따른 가상 Anonymous Buyer(ZZ999999) 코드를 정리
	  * </pre>
	  */
	public PerformanceReportDBDAOsearchDisposalPFMCByBuyerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_end_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_disp_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_str_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_disp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOsearchDisposalPFMCByBuyerListRSQL").append("\n"); 
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
		query.append("WITH TEMP_PFMC AS (" ).append("\n"); 
		query.append("    SELECT  A.DISP_NO, B.DISP_SOLD_DT AS APRO_DT, A.EQ_KND_CD, A.RQST_OFC_CD, A.CURR_CD," ).append("\n"); 
		query.append("            MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(A.RQST_OFC_CD) AS RHQ_CD," ).append("\n"); 
		query.append("            B.DISP_DTL_SEQ, B.EQ_TPSZ_CD, B.DISP_QTY, B.PART_AMT, B.DISP_YD_CD, " ).append("\n"); 
		query.append("            MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(B.DISP_SOLD_DT, 'YYYYMM'), A.CURR_CD, 'USD', B.PART_AMT) AS CAL_PART_AMT," ).append("\n"); 
		query.append("            CASE WHEN B.MNR_PRNR_SEQ IS NOT NULL " ).append("\n"); 
		query.append("                 THEN MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(B.MNR_PRNR_SEQ, B.MNR_PRNR_CNT_CD)" ).append("\n"); 
		query.append("                 WHEN B.NIS_PRNR_VNDR_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                 THEN MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(B.NIS_PRNR_VNDR_SEQ, B.NIS_PRNR_CNT_CD)" ).append("\n"); 
		query.append("                 ELSE 'ZZ999999' END CUST_CD, " ).append("\n"); 
		query.append("            CASE WHEN B.MNR_PRNR_SEQ IS NOT NULL THEN C.MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append("                 WHEN B.NIS_PRNR_VNDR_SEQ IS NOT NULL THEN B.NIS_PRNR_VNDR_ABBR_NM" ).append("\n"); 
		query.append("                 ELSE 'Anonymous Buyer' END CUST_NM, " ).append("\n"); 
		query.append("            TO_CHAR(B.DISP_SOLD_DT, 'YYYYMM') AS APRO_MON," ).append("\n"); 
		query.append("            SUM(B.DISP_QTY) OVER() AS DISP_TOT," ).append("\n"); 
		query.append("            SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(B.DISP_SOLD_DT, 'YYYYMM'), " ).append("\n"); 
		query.append("                A.CURR_CD, 'USD', B.PART_AMT)) OVER() AS CAL_PART_TOT                                                                            " ).append("\n"); 
		query.append("    FROM    MNR_DISP_HDR A," ).append("\n"); 
		query.append("            MNR_DISP_DTL B," ).append("\n"); 
		query.append("            MNR_PARTNER C" ).append("\n"); 
		query.append("    WHERE   A.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("    AND     B.MNR_PRNR_CNT_CD = C.MNR_PRNR_CNT_CD(+)" ).append("\n"); 
		query.append("    AND     B.MNR_PRNR_SEQ    = C.MNR_PRNR_SEQ(+)" ).append("\n"); 
		query.append("    AND     B.DISP_SOLD_DT IS NOT NULL " ).append("\n"); 
		query.append("    AND		B.DISP_SOLD_DT BETWEEN TO_DATE(@[p_str_evnt_dt],'YYYYMMDD') AND TO_DATE(@[p_end_evnt_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("#if (${p_eq_knd_cd} != '' )" ).append("\n"); 
		query.append("    AND     A.EQ_KND_CD = @[p_eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_rhq_cd} != '' )" ).append("\n"); 
		query.append("	AND     MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(A.RQST_OFC_CD) = @[p_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_ofc_cd} != '' )" ).append("\n"); 
		query.append("	AND     A.RQST_OFC_CD = @[p_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_disp_tp_cd} != '' )" ).append("\n"); 
		query.append("	AND     A.DISP_TP_CD = @[p_disp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_disp_rsn_cd} != '' )" ).append("\n"); 
		query.append("	AND     B.DISP_RSN_CD = @[p_disp_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_cust_cd} != '')" ).append("\n"); 
		query.append("	AND     B.MNR_PRNR_CNT_CD = SUBSTR(@[p_cust_cd],0,2)" ).append("\n"); 
		query.append("	AND     B.MNR_PRNR_SEQ = SUBSTR(@[p_cust_cd],3,8)" ).append("\n"); 
		query.append("#end            " ).append("\n"); 
		query.append("), TEMP_TPSZ AS (" ).append("\n"); 
		query.append("    SELECT  EQ_KND_CD, EQ_TPSZ_CD, " ).append("\n"); 
		query.append("            ROW_NUMBER() OVER(PARTITION BY EQ_KND_CD ORDER BY DP_SEQ) AS RPT_DP_SEQ" ).append("\n"); 
		query.append("    FROM   (SELECT  EQ_KND_CD, EQ_TPSZ_CD, DP_SEQ" ).append("\n"); 
		query.append("            FROM    CGM_EQ_TP_SZ" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT  'U' AS EQ_KND_CD, CNTR_TPSZ_CD, RPT_DP_SEQ   " ).append("\n"); 
		query.append("            FROM    MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("            )                            " ).append("\n"); 
		query.append("), TEMP_SEQ AS (" ).append("\n"); 
		query.append("    SELECT  LEVEL AS RSLT_TP_SEQ, " ).append("\n"); 
		query.append("            DECODE(LEVEL, 1,'QTY',2,'AMT',3,'AVG') AS RSLT_TP_NM  " ).append("\n"); 
		query.append("    FROM    DUAL  CONNECT BY LEVEL <= 3            " ).append("\n"); 
		query.append(")                                             " ).append("\n"); 
		query.append("SELECT  NVL(A.CUST_CD, 'G.TTL') AS CUST_CD," ).append("\n"); 
		query.append("        CASE WHEN A.CURR_CD IS NOT NULL THEN A.CUST_NM" ).append("\n"); 
		query.append("             WHEN A.CUST_CD IS NOT NULL THEN 'S.TTL' END CUST_NM, " ).append("\n"); 
		query.append("        NVL(A.CURR_CD, 'USD') AS CURR_CD, " ).append("\n"); 
		query.append("        A.CURR_CNT, A.RSLT_TP_SEQ, A.RSLT_TP_NM,               " ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP00, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP00, 0), '999,999,990.00')) END PFMC_TPSZ_DP00," ).append("\n"); 
		query.append("        LTRIM(TO_CHAR(NVL(A.RATO_TPSZ_DP00, 0), '999,990.00'))||'%' AS RATO_TPSZ_DP00,     " ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP01, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP01, 0), '999,999,990.00')) END PFMC_TPSZ_DP01," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP02, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP02, 0), '999,999,990.00')) END PFMC_TPSZ_DP02," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP03, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP03, 0), '999,999,990.00')) END PFMC_TPSZ_DP03," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP04, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP04, 0), '999,999,990.00')) END PFMC_TPSZ_DP04," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP05, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP05, 0), '999,999,990.00')) END PFMC_TPSZ_DP05," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP06, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP06, 0), '999,999,990.00')) END PFMC_TPSZ_DP06," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP07, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP07, 0), '999,999,990.00')) END PFMC_TPSZ_DP07," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP08, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP08, 0), '999,999,990.00')) END PFMC_TPSZ_DP08," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP09, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP09, 0), '999,999,990.00')) END PFMC_TPSZ_DP09," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP10, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP10, 0), '999,999,990.00')) END PFMC_TPSZ_DP10," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP11, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP11, 0), '999,999,990.00')) END PFMC_TPSZ_DP11," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP12, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP12, 0), '999,999,990.00')) END PFMC_TPSZ_DP12," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP13, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP13, 0), '999,999,990.00')) END PFMC_TPSZ_DP13," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP14, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP14, 0), '999,999,990.00')) END PFMC_TPSZ_DP14," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP15, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP15, 0), '999,999,990.00')) END PFMC_TPSZ_DP15," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP16, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP16, 0), '999,999,990.00')) END PFMC_TPSZ_DP16," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP17, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP17, 0), '999,999,990.00')) END PFMC_TPSZ_DP17," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP18, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP18, 0), '999,999,990.00')) END PFMC_TPSZ_DP18," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP19, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP19, 0), '999,999,990.00')) END PFMC_TPSZ_DP19," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP20, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP20, 0), '999,999,990.00')) END PFMC_TPSZ_DP20," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP21, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP21, 0), '999,999,990.00')) END PFMC_TPSZ_DP21," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP22, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP22, 0), '999,999,990.00')) END PFMC_TPSZ_DP22," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP23, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP23, 0), '999,999,990.00')) END PFMC_TPSZ_DP23," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP24, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP24, 0), '999,999,990.00')) END PFMC_TPSZ_DP24," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP25, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP25, 0), '999,999,990.00')) END PFMC_TPSZ_DP25," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP26, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP26, 0), '999,999,990.00')) END PFMC_TPSZ_DP26," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP27, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP27, 0), '999,999,990.00')) END PFMC_TPSZ_DP27," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP28, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP28, 0), '999,999,990.00')) END PFMC_TPSZ_DP28," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP29, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP29, 0), '999,999,990.00')) END PFMC_TPSZ_DP29," ).append("\n"); 
		query.append("        CASE WHEN A.RSLT_TP_SEQ = 1 THEN LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP30, 0), '999,999,990'))" ).append("\n"); 
		query.append("             ELSE LTRIM(TO_CHAR(NVL(A.PFMC_TPSZ_DP30, 0), '999,999,990.00')) END PFMC_TPSZ_DP30                         " ).append("\n"); 
		query.append("FROM   (SELECT  A.CUST_CD, MAX(A.CUST_NM) AS CUST_NM, " ).append("\n"); 
		query.append("                A.CURR_CD, MAX(A.CURR_CNT) AS CURR_CNT, A.RSLT_TP_SEQ, " ).append("\n"); 
		query.append("                MAX(A.RSLT_TP_NM) AS RSLT_TP_NM," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP00) AS PFMC_TPSZ_DP00, MAX(A.PFMC_TPSZ_DP01) AS PFMC_TPSZ_DP01," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP02) AS PFMC_TPSZ_DP02, MAX(A.PFMC_TPSZ_DP03) AS PFMC_TPSZ_DP03," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP04) AS PFMC_TPSZ_DP04, MAX(A.PFMC_TPSZ_DP05) AS PFMC_TPSZ_DP05," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP06) AS PFMC_TPSZ_DP06, MAX(A.PFMC_TPSZ_DP07) AS PFMC_TPSZ_DP07," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP08) AS PFMC_TPSZ_DP08, MAX(A.PFMC_TPSZ_DP09) AS PFMC_TPSZ_DP09," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP10) AS PFMC_TPSZ_DP10, MAX(A.PFMC_TPSZ_DP11) AS PFMC_TPSZ_DP11," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP12) AS PFMC_TPSZ_DP12, MAX(A.PFMC_TPSZ_DP13) AS PFMC_TPSZ_DP13," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP14) AS PFMC_TPSZ_DP14, MAX(A.PFMC_TPSZ_DP15) AS PFMC_TPSZ_DP15," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP16) AS PFMC_TPSZ_DP16, MAX(A.PFMC_TPSZ_DP17) AS PFMC_TPSZ_DP17," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP18) AS PFMC_TPSZ_DP18, MAX(A.PFMC_TPSZ_DP19) AS PFMC_TPSZ_DP19," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP20) AS PFMC_TPSZ_DP20, MAX(A.PFMC_TPSZ_DP21) AS PFMC_TPSZ_DP21," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP22) AS PFMC_TPSZ_DP22, MAX(A.PFMC_TPSZ_DP23) AS PFMC_TPSZ_DP23," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP24) AS PFMC_TPSZ_DP24, MAX(A.PFMC_TPSZ_DP25) AS PFMC_TPSZ_DP25," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP26) AS PFMC_TPSZ_DP26, MAX(A.PFMC_TPSZ_DP27) AS PFMC_TPSZ_DP27," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP28) AS PFMC_TPSZ_DP28, MAX(A.PFMC_TPSZ_DP29) AS PFMC_TPSZ_DP29," ).append("\n"); 
		query.append("                MAX(A.PFMC_TPSZ_DP30) AS PFMC_TPSZ_DP30, MAX(A.RATO_TPSZ_DP00) AS RATO_TPSZ_DP00                    " ).append("\n"); 
		query.append("        FROM   (SELECT  A.CUST_CD, A.CUST_NM, A.CURR_CD, A.CURR_CNT, A.RSLT_TP_SEQ, A.RSLT_TP_NM," ).append("\n"); 
		query.append("                        A.PFMC_TPSZ_DP00, A.PFMC_TPSZ_DP01, A.PFMC_TPSZ_DP02, A.PFMC_TPSZ_DP03, " ).append("\n"); 
		query.append("                        A.PFMC_TPSZ_DP04, A.PFMC_TPSZ_DP05, A.PFMC_TPSZ_DP06, A.PFMC_TPSZ_DP07, " ).append("\n"); 
		query.append("                        A.PFMC_TPSZ_DP08, A.PFMC_TPSZ_DP09, A.PFMC_TPSZ_DP10, A.PFMC_TPSZ_DP11, " ).append("\n"); 
		query.append("                        A.PFMC_TPSZ_DP12, A.PFMC_TPSZ_DP13, A.PFMC_TPSZ_DP14, A.PFMC_TPSZ_DP15, " ).append("\n"); 
		query.append("                        A.PFMC_TPSZ_DP16, A.PFMC_TPSZ_DP17, A.PFMC_TPSZ_DP18, A.PFMC_TPSZ_DP19, " ).append("\n"); 
		query.append("                        A.PFMC_TPSZ_DP20, A.PFMC_TPSZ_DP21, A.PFMC_TPSZ_DP22, A.PFMC_TPSZ_DP23, " ).append("\n"); 
		query.append("                        A.PFMC_TPSZ_DP24, A.PFMC_TPSZ_DP25, A.PFMC_TPSZ_DP26, A.PFMC_TPSZ_DP27, " ).append("\n"); 
		query.append("                        A.PFMC_TPSZ_DP28, A.PFMC_TPSZ_DP29, A.PFMC_TPSZ_DP30, A.RATO_TPSZ_DP00                   " ).append("\n"); 
		query.append("                FROM   (SELECT  A.CUST_CD, A.CUST_NM, A.CURR_CD, A.CURR_CNT, B.RSLT_TP_SEQ, B.RSLT_TP_NM,                                                                                                                                                  " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP00 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP00" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP00,0,0, A.AMT_DP00 / A.QTY_DP00) END PFMC_TPSZ_DP00,                                                         " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP00 / A.QTY_DISP * 100" ).append("\n"); 
		query.append("                                     WHEN B.RSLT_TP_SEQ = 2 THEN A.CAL_DP00 / A.AMT_PART * 100" ).append("\n"); 
		query.append("                                     ELSE (A.CAL_DP00 / A.QTY_DP00) / (A.AMT_PART / A.QTY_DISP) * 100 END RATO_TPSZ_DP00,                                                                                                                              " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP01 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP01" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP01,0,0, A.AMT_DP01 / A.QTY_DP01) END PFMC_TPSZ_DP01,                                 " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP02 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP02 " ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP02,0,0, A.AMT_DP02 / A.QTY_DP02) END PFMC_TPSZ_DP02,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP03 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP03" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP03,0,0, A.AMT_DP03 / A.QTY_DP03) END PFMC_TPSZ_DP03,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP04 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP04" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP04,0,0, A.AMT_DP04 / A.QTY_DP04) END PFMC_TPSZ_DP04,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP05 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP05 " ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP05,0,0, A.AMT_DP05 / A.QTY_DP05) END PFMC_TPSZ_DP05,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP06 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP06" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP06,0,0, A.AMT_DP06 / A.QTY_DP06) END PFMC_TPSZ_DP06,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP07 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP07" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP07,0,0, A.AMT_DP07 / A.QTY_DP07) END PFMC_TPSZ_DP07,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP08 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP08" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP08,0,0, A.AMT_DP08 / A.QTY_DP08) END PFMC_TPSZ_DP08,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP09 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP09" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP09,0,0, A.AMT_DP09 / A.QTY_DP09) END PFMC_TPSZ_DP09,                            " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP10 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP10" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP10,0,0, A.AMT_DP10 / A.QTY_DP10) END PFMC_TPSZ_DP10,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP11 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP11" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP11,0,0, A.AMT_DP11 / A.QTY_DP11) END PFMC_TPSZ_DP11,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP12 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP12" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP12,0,0, A.AMT_DP12 / A.QTY_DP12) END PFMC_TPSZ_DP12,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP13 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP13" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP13,0,0, A.AMT_DP13 / A.QTY_DP13) END PFMC_TPSZ_DP13,                            " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP14 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP14" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP14,0,0, A.AMT_DP14 / A.QTY_DP14) END PFMC_TPSZ_DP14,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP15 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP15" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP15,0,0, A.AMT_DP15 / A.QTY_DP15) END PFMC_TPSZ_DP15,                            " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP16 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP16 " ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP16,0,0, A.AMT_DP16 / A.QTY_DP16) END PFMC_TPSZ_DP16,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP17 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP17" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP17,0,0, A.AMT_DP17 / A.QTY_DP17) END PFMC_TPSZ_DP17,                            " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP18 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP18" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP18,0,0, A.AMT_DP18 / A.QTY_DP18) END PFMC_TPSZ_DP18,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP19 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP19" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP19,0,0, A.AMT_DP19 / A.QTY_DP19) END PFMC_TPSZ_DP19,                            " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP20 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP20" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP20,0,0, A.AMT_DP20 / A.QTY_DP20) END PFMC_TPSZ_DP20,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP21 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP21" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP21,0,0, A.AMT_DP21 / A.QTY_DP21) END PFMC_TPSZ_DP21,                            " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP22 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP22" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP22,0,0, A.AMT_DP22 / A.QTY_DP22) END PFMC_TPSZ_DP22,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP23 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP23" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP23,0,0, A.AMT_DP23 / A.QTY_DP23) END PFMC_TPSZ_DP23,                            " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP24 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP24" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP24,0,0, A.AMT_DP24 / A.QTY_DP24) END PFMC_TPSZ_DP24,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP25 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP25" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP25,0,0, A.AMT_DP25 / A.QTY_DP25) END PFMC_TPSZ_DP25,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP26 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP26" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP26,0,0, A.AMT_DP26 / A.QTY_DP26) END PFMC_TPSZ_DP26,                            " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP27 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP27" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP27,0,0, A.AMT_DP27 / A.QTY_DP27) END PFMC_TPSZ_DP27,                                " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP28 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP28" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP28,0,0, A.AMT_DP28 / A.QTY_DP28) END PFMC_TPSZ_DP28,                        " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP29 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP29" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP29,0,0, A.AMT_DP29 / A.QTY_DP29) END PFMC_TPSZ_DP29,                                                                          " ).append("\n"); 
		query.append("                                CASE WHEN B.RSLT_TP_SEQ = 1 THEN A.QTY_DP30 WHEN B.RSLT_TP_SEQ = 2 THEN A.AMT_DP30" ).append("\n"); 
		query.append("                                     ELSE DECODE(A.QTY_DP30,0,0, A.AMT_DP30 / A.QTY_DP30) END PFMC_TPSZ_DP30                " ).append("\n"); 
		query.append("                        FROM   (SELECT  A.CUST_CD, A.CUST_NM, A.CURR_CD, A.CURR_CNT, A.QTY_DISP, " ).append("\n"); 
		query.append("                                        A.AMT_PART, A.QTY_DP00, A.CAL_AMT_DP00 AS CAL_DP00," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP00, A.CAL_AMT_DP00) AS AMT_DP00," ).append("\n"); 
		query.append("                                        A.QTY_DP01, A.QTY_DP02, A.QTY_DP03, A.QTY_DP04, A.QTY_DP05, " ).append("\n"); 
		query.append("                                        A.QTY_DP06, A.QTY_DP07, A.QTY_DP08, A.QTY_DP09, A.QTY_DP10, " ).append("\n"); 
		query.append("                                        A.QTY_DP11, A.QTY_DP12, A.QTY_DP13, A.QTY_DP14, A.QTY_DP15, " ).append("\n"); 
		query.append("                                        A.QTY_DP16, A.QTY_DP17, A.QTY_DP18, A.QTY_DP19, A.QTY_DP20, " ).append("\n"); 
		query.append("                                        A.QTY_DP21, A.QTY_DP22, A.QTY_DP23, A.QTY_DP24, A.QTY_DP25, " ).append("\n"); 
		query.append("                                        A.QTY_DP26, A.QTY_DP27, A.QTY_DP28, A.QTY_DP29, A.QTY_DP30,                                        " ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP01, A.CAL_AMT_DP01) AS AMT_DP01," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP02, A.CAL_AMT_DP02) AS AMT_DP02," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP03, A.CAL_AMT_DP03) AS AMT_DP03," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP04, A.CAL_AMT_DP04) AS AMT_DP04," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP05, A.CAL_AMT_DP05) AS AMT_DP05," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP06, A.CAL_AMT_DP06) AS AMT_DP06," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP07, A.CAL_AMT_DP07) AS AMT_DP07," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP08, A.CAL_AMT_DP08) AS AMT_DP08," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP09, A.CAL_AMT_DP09) AS AMT_DP09," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP10, A.CAL_AMT_DP10) AS AMT_DP10," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP11, A.CAL_AMT_DP11) AS AMT_DP11," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP12, A.CAL_AMT_DP12) AS AMT_DP12," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP13, A.CAL_AMT_DP13) AS AMT_DP13," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP14, A.CAL_AMT_DP14) AS AMT_DP14," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP15, A.CAL_AMT_DP15) AS AMT_DP15," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP16, A.CAL_AMT_DP16) AS AMT_DP16," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP17, A.CAL_AMT_DP17) AS AMT_DP17," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP18, A.CAL_AMT_DP18) AS AMT_DP18," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP19, A.CAL_AMT_DP19) AS AMT_DP19," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP20, A.CAL_AMT_DP20) AS AMT_DP20," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP21, A.CAL_AMT_DP21) AS AMT_DP21," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP22, A.CAL_AMT_DP22) AS AMT_DP22," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP23, A.CAL_AMT_DP23) AS AMT_DP23," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP24, A.CAL_AMT_DP24) AS AMT_DP24," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP25, A.CAL_AMT_DP25) AS AMT_DP25," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP26, A.CAL_AMT_DP26) AS AMT_DP26," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP27, A.CAL_AMT_DP27) AS AMT_DP27," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP28, A.CAL_AMT_DP28) AS AMT_DP28," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP29, A.CAL_AMT_DP29) AS AMT_DP29," ).append("\n"); 
		query.append("                                        NVL2(A.CURR_CD, A.AMT_DP30, A.CAL_AMT_DP30) AS AMT_DP30" ).append("\n"); 
		query.append("                                FROM   (SELECT  A.CUST_CD, A.CUST_NM, A.CURR_CD," ).append("\n"); 
		query.append("                                                COUNT(*) OVER(PARTITION BY A.CUST_CD, A.CUST_NM) -1 AS CURR_CNT," ).append("\n"); 
		query.append("                                                MAX(A.DISP_TOT) AS QTY_DISP, " ).append("\n"); 
		query.append("                                                MAX(A.CAL_PART_TOT) AS AMT_PART," ).append("\n"); 
		query.append("                                                SUM(A.DISP_QTY) AS QTY_DP00, " ).append("\n"); 
		query.append("                                                SUM(A.PART_AMT) AS AMT_DP00," ).append("\n"); 
		query.append("                                                SUM(A.CAL_PART_AMT) AS CAL_AMT_DP00, " ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 1 THEN A.DISP_QTY END) AS QTY_DP01," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 2 THEN A.DISP_QTY END) AS QTY_DP02,  " ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 3 THEN A.DISP_QTY END) AS QTY_DP03," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 4 THEN A.DISP_QTY END) AS QTY_DP04," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 5 THEN A.DISP_QTY END) AS QTY_DP05," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 6 THEN A.DISP_QTY END) AS QTY_DP06," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 7 THEN A.DISP_QTY END) AS QTY_DP07," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 8 THEN A.DISP_QTY END) AS QTY_DP08," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 9 THEN A.DISP_QTY END) AS QTY_DP09," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =10 THEN A.DISP_QTY END) AS QTY_DP10," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =11 THEN A.DISP_QTY END) AS QTY_DP11," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =12 THEN A.DISP_QTY END) AS QTY_DP12," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =13 THEN A.DISP_QTY END) AS QTY_DP13," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =14 THEN A.DISP_QTY END) AS QTY_DP14," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =15 THEN A.DISP_QTY END) AS QTY_DP15," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =16 THEN A.DISP_QTY END) AS QTY_DP16," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =17 THEN A.DISP_QTY END) AS QTY_DP17," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =18 THEN A.DISP_QTY END) AS QTY_DP18," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =19 THEN A.DISP_QTY END) AS QTY_DP19," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =20 THEN A.DISP_QTY END) AS QTY_DP20," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =21 THEN A.DISP_QTY END) AS QTY_DP21," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =22 THEN A.DISP_QTY END) AS QTY_DP22,  " ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =23 THEN A.DISP_QTY END) AS QTY_DP23," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =24 THEN A.DISP_QTY END) AS QTY_DP24," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =25 THEN A.DISP_QTY END) AS QTY_DP25," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =26 THEN A.DISP_QTY END) AS QTY_DP26," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =27 THEN A.DISP_QTY END) AS QTY_DP27," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =28 THEN A.DISP_QTY END) AS QTY_DP28," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =29 THEN A.DISP_QTY END) AS QTY_DP29," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =30 THEN A.DISP_QTY END) AS QTY_DP30," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 1 THEN A.PART_AMT END) AS AMT_DP01," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 2 THEN A.PART_AMT END) AS AMT_DP02,  " ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 3 THEN A.PART_AMT END) AS AMT_DP03," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 4 THEN A.PART_AMT END) AS AMT_DP04," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 5 THEN A.PART_AMT END) AS AMT_DP05," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 6 THEN A.PART_AMT END) AS AMT_DP06," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 7 THEN A.PART_AMT END) AS AMT_DP07," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 8 THEN A.PART_AMT END) AS AMT_DP08," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 9 THEN A.PART_AMT END) AS AMT_DP09," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =10 THEN A.PART_AMT END) AS AMT_DP10," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =11 THEN A.PART_AMT END) AS AMT_DP11," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =12 THEN A.PART_AMT END) AS AMT_DP12," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =13 THEN A.PART_AMT END) AS AMT_DP13," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =14 THEN A.PART_AMT END) AS AMT_DP14," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =15 THEN A.PART_AMT END) AS AMT_DP15," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =16 THEN A.PART_AMT END) AS AMT_DP16," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =17 THEN A.PART_AMT END) AS AMT_DP17," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =18 THEN A.PART_AMT END) AS AMT_DP18," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =19 THEN A.PART_AMT END) AS AMT_DP19," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =20 THEN A.PART_AMT END) AS AMT_DP20," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =21 THEN A.PART_AMT END) AS AMT_DP21," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =22 THEN A.PART_AMT END) AS AMT_DP22,  " ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =23 THEN A.PART_AMT END) AS AMT_DP23," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =24 THEN A.PART_AMT END) AS AMT_DP24," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =25 THEN A.PART_AMT END) AS AMT_DP25," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =26 THEN A.PART_AMT END) AS AMT_DP26," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =27 THEN A.PART_AMT END) AS AMT_DP27," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =28 THEN A.PART_AMT END) AS AMT_DP28," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =29 THEN A.PART_AMT END) AS AMT_DP29," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =30 THEN A.PART_AMT END) AS AMT_DP30,                                        " ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 1 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP01," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 2 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP02,  " ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 3 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP03," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 4 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP04," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 5 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP05," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 6 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP06," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 7 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP07," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 8 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP08," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ = 9 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP09," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =10 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP10," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =11 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP11," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =12 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP12," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =13 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP13," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =14 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP14," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =15 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP15," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =16 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP16," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =17 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP17," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =18 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP18," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =19 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP19," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =20 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP20," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =21 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP21," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =22 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP22,  " ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =23 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP23," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =24 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP24," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =25 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP25," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =26 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP26," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =27 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP27," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =28 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP28," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =29 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP29," ).append("\n"); 
		query.append("                                                SUM(CASE WHEN B.RPT_DP_SEQ =30 THEN A.CAL_PART_AMT END) AS CAL_AMT_DP30          " ).append("\n"); 
		query.append("                                        FROM    TEMP_PFMC A," ).append("\n"); 
		query.append("                                                TEMP_TPSZ B" ).append("\n"); 
		query.append("                                        WHERE   A.EQ_KND_CD  = B.EQ_KND_CD" ).append("\n"); 
		query.append("                                        AND     A.EQ_TPSZ_CD = B.EQ_TPSZ_CD              " ).append("\n"); 
		query.append("                                        GROUP BY ROLLUP(A.CUST_CD, A.CUST_NM, A.CURR_CD)" ).append("\n"); 
		query.append("                                        ) A" ).append("\n"); 
		query.append("                                ) A," ).append("\n"); 
		query.append("                                TEMP_SEQ B        " ).append("\n"); 
		query.append("                        ) A                               " ).append("\n"); 
		query.append("                ) A                                        " ).append("\n"); 
		query.append("        GROUP BY A.CUST_CD, A.CURR_CD, A.RSLT_TP_SEQ" ).append("\n"); 
		query.append("        ORDER BY A.CUST_CD, A.CURR_CD, A.RSLT_TP_SEQ        " ).append("\n"); 
		query.append("        ) A        " ).append("\n"); 
		query.append("--WHERE   A.CURR_CD IS NOT NULL OR A.CURR_CNT != 1" ).append("\n"); 

	}
}