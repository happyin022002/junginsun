/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchDisposalPFMCByRegionByBuyerListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.12
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.07.12 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchDisposalPFMCByRegionByBuyerListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDisposalPFMCByRegionByBuyerListDataRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchDisposalPFMCByRegionByBuyerListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("buyer_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_kind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchDisposalPFMCByRegionByBuyerListDataRSQL").append("\n"); 
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
		query.append("WITH PARAM" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("SELECT EQ_KIND," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 1, TPSZ)) TS01, MAX(DECODE(RNK, 2, TPSZ)) TS02, MAX(DECODE(RNK, 3, TPSZ)) TS03, MAX(DECODE(RNK, 4, TPSZ)) TS04, MAX(DECODE(RNK, 5, TPSZ)) TS05," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 6, TPSZ)) TS06, MAX(DECODE(RNK, 7, TPSZ)) TS07, MAX(DECODE(RNK, 8, TPSZ)) TS08, MAX(DECODE(RNK, 9, TPSZ)) TS09, MAX(DECODE(RNK, 10, TPSZ)) TS10," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 11, TPSZ)) TS11, MAX(DECODE(RNK, 12, TPSZ)) TS12, MAX(DECODE(RNK, 13, TPSZ)) TS13, MAX(DECODE(RNK, 14, TPSZ)) TS14, MAX(DECODE(RNK, 15, TPSZ)) TS15," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 16, TPSZ)) TS16, MAX(DECODE(RNK, 17, TPSZ)) TS17, MAX(DECODE(RNK, 18, TPSZ)) TS18, MAX(DECODE(RNK, 19, TPSZ)) TS19, MAX(DECODE(RNK, 20, TPSZ)) TS20," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 21, TPSZ)) TS21, MAX(DECODE(RNK, 22, TPSZ)) TS22, MAX(DECODE(RNK, 23, TPSZ)) TS23, MAX(DECODE(RNK, 24, TPSZ)) TS24, MAX(DECODE(RNK, 25, TPSZ)) TS25," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 26, TPSZ)) TS26, MAX(DECODE(RNK, 27, TPSZ)) TS27, MAX(DECODE(RNK, 28, TPSZ)) TS28, MAX(DECODE(RNK, 29, TPSZ)) TS29, MAX(DECODE(RNK, 30, TPSZ)) TS30" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  EQ_KIND, TPSZ, ROW_NUMBER() OVER(ORDER BY EQ_KIND, DP_SEQ) RNK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'U' EQ_KIND,  A.CNTR_TPSZ_CD    TPSZ, A.RPT_DP_SEQ DP_SEQ" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("WHERE 'U' = @[eq_kind]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.EQ_KND_CD EQ_KIND, A.EQ_TPSZ_CD    TPSZ, A.DP_SEQ DP_SEQ" ).append("\n"); 
		query.append("FROM CGM_EQ_TP_SZ A" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = @[eq_kind]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY EQ_KIND" ).append("\n"); 
		query.append("), DUMMY_COL AS (" ).append("\n"); 
		query.append("SELECT 'Q' DCOL FROM DUAL  --QTY" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'S' DCOL FROM DUAL  --AMOUNT" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Z' DCOL FROM DUAL  --AVG" ).append("\n"); 
		query.append("), DISP_QTY AS(" ).append("\n"); 
		query.append("SELECT  MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(DD.MNR_PRNR_SEQ, DD.MNR_PRNR_CNT_CD) BUYER_CD," ).append("\n"); 
		query.append("MAX(MP.MNR_PRNR_LGL_ENG_NM) BUYER_NM," ).append("\n"); 
		query.append("DH.RQST_OFC_CD OFC_CD," ).append("\n"); 
		query.append("DH.CURR_CD," ).append("\n"); 
		query.append("C.DCOL," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS01, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS01, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS01, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS01, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS01_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS02, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS02, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS02, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS02, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS02_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS03, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS03, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS03, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS03, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS03_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS04, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS04, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS04, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS04, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS04_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS05, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS05, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS05, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS05, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS05_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS06, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS06, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS06, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS06, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS06_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS07, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS07, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS07, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS07, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS07_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS08, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS08, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS08, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS08, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS08_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS09, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS09, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS09, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS09, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS09_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS10, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS10, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS10, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS10, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS10_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS11, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS11, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS11, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS11, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS11_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS12, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS12, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS12, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS12, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS12_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS13, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS13, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS13, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS13, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS13_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS14, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS14, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS14, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS14, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS14_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS15, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS15, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS15, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS15, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS15_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS16, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS16, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS16, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS16, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS16_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS17, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS17, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS17, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS17, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS17_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS18, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS18, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS18, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS18, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS18_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS19, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS19, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS19, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS19, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS19_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS20, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS20, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS20, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS20, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS20_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS21, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS21, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS21, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS21, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS21_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS22, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS22, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS22, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS22, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS22_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS23, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS23, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS23, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS23, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS23_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS24, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS24, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS24, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS24, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS24_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS25, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS25, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS25, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS25, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS25_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS26, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS26, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS26, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS26, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS26_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS27, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS27, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS27, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS27, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS27_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS28, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS28, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS28, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS28, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS28_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS29, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS29, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS29, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS29, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS29_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS30, DD.EQ_TPSZ_CD, DD.DISP_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS30, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS30, DD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), DH.CURR_CD, 'USD', DD.PART_AMT)))/" ).append("\n"); 
		query.append("SUM(DECODE(P.TS30, DD.EQ_TPSZ_CD, DD.DISP_QTY)), 2)" ).append("\n"); 
		query.append("END TS30_P" ).append("\n"); 
		query.append("FROM  PARAM P, DUMMY_COL C, MNR_DISP_HDR DH, MNR_DISP_DTL DD, MNR_PARTNER MP" ).append("\n"); 
		query.append("WHERE DH.DISP_NO = DD.DISP_NO" ).append("\n"); 
		query.append("AND   DH.EQ_KND_CD = @[eq_kind]" ).append("\n"); 
		query.append("AND   DH.APRO_DT BETWEEN TO_DATE(@[from_mon], 'yyyy-mm') AND ADD_MONTHS(TO_DATE(@[to_mon], 'yyyy-mm'), 1)" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A')" ).append("\n"); 
		query.append("AND   DH.RQST_OFC_CD = DECODE('ALL', 'ALL', DH.RQST_OFC_CD, @[ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   DD.MNR_PRNR_CNT_CD = MP.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("AND   DD.MNR_PRNR_SEQ    = MP.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("#if (${buyer_code} != '')" ).append("\n"); 
		query.append("AND   DD.MNR_PRNR_CNT_CD = NVL(SUBSTR(@[buyer_code],0,2), DD.MNR_PRNR_CNT_CD)" ).append("\n"); 
		query.append("AND   DD.MNR_PRNR_SEQ    = NVL(SUBSTR(@[buyer_code],3,8), DD.MNR_PRNR_SEQ)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(DD.MNR_PRNR_SEQ, DD.MNR_PRNR_CNT_CD), DH.RQST_OFC_CD, DH.CURR_CD, C.DCOL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  RHQ, BUYER_CD, BUYER_NM, OFC_CD, CURR_CD, DECODE(TYPE, 'Q', 'QTY', 'S', 'AMT', 'Z', 'AVG') TYPE," ).append("\n"); 
		query.append("DECODE(TYPE, 'Q', '1', 'S', '2', 'Z', '3') TYPE2," ).append("\n"); 
		query.append("DECODE(RHQ,'RHQ'," ).append("\n"); 
		query.append("'N' || '|'  || TS01_P || '|'  || 'N' || '|'  || TS02_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS03_P || '|'  || 'N' || '|'  || TS04_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS05_P || '|'  || 'N' || '|'  || TS06_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS07_P || '|'  || 'N' || '|'  || TS08_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS09_P || '|'  || 'N' || '|'  || TS10_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS11_P || '|'  || 'N' || '|'  || TS12_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS13_P || '|'  || 'N' || '|'  || TS14_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS15_P || '|'  || 'N' || '|'  || TS16_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS17_P || '|'  || 'N' || '|'  || TS18_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS19_P || '|'  || 'N' || '|'  || TS20_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS21_P || '|'  || 'N' || '|'  || TS22_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS23_P || '|'  || 'N' || '|'  || TS24_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS25_P || '|'  || 'N' || '|'  || TS26_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS27_P || '|'  || 'N' || '|'  || TS28_P  || '|' ||" ).append("\n"); 
		query.append("'N' || '|'  || TS29_P || '|'  || 'N' || '|'  || TS30_P, '')  AS TITLE," ).append("\n"); 
		query.append("TS01_P, TS02_P, TS03_P, TS04_P, TS05_P," ).append("\n"); 
		query.append("TS06_P, TS07_P, TS08_P, TS09_P, TS10_P," ).append("\n"); 
		query.append("TS11_P, TS12_P, TS13_P, TS14_P, TS15_P," ).append("\n"); 
		query.append("TS16_P, TS17_P, TS18_P, TS19_P, TS20_P," ).append("\n"); 
		query.append("TS21_P, TS22_P, TS23_P, TS24_P, TS25_P," ).append("\n"); 
		query.append("TS26_P, TS27_P, TS28_P, TS29_P, TS30_P" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'RHQ' RHQ,  'BUYER' BUYER_CD, 'BUYER NM' BUYER_NM, 'OFFICE' OFC_CD,'CURR' CURR_CD, 'TYPE' TYPE," ).append("\n"); 
		query.append("NVL(P.TS01,'N') TS01_P, NVL(P.TS02,'N') TS02_P," ).append("\n"); 
		query.append("NVL(P.TS03,'N') TS03_P, NVL(P.TS04,'N') TS04_P," ).append("\n"); 
		query.append("NVL(P.TS05,'N') TS05_P, NVL(P.TS06,'N') TS06_P," ).append("\n"); 
		query.append("NVL(P.TS07,'N') TS07_P, NVL(P.TS08,'N') TS08_P," ).append("\n"); 
		query.append("NVL(P.TS09,'N') TS09_P, NVL(P.TS10,'N') TS10_P," ).append("\n"); 
		query.append("NVL(P.TS11,'N') TS11_P, NVL(P.TS12,'N') TS12_P," ).append("\n"); 
		query.append("NVL(P.TS13,'N') TS13_P, NVL(P.TS14,'N') TS14_P," ).append("\n"); 
		query.append("NVL(P.TS15,'N') TS15_P, NVL(P.TS16,'N') TS16_P," ).append("\n"); 
		query.append("NVL(P.TS17,'N') TS17_P, NVL(P.TS18,'N') TS18_P," ).append("\n"); 
		query.append("NVL(P.TS19,'N') TS19_P, NVL(P.TS20,'N') TS20_P," ).append("\n"); 
		query.append("NVL(P.TS21,'N') TS21_P, NVL(P.TS22,'N') TS22_P," ).append("\n"); 
		query.append("NVL(P.TS23,'N') TS23_P, NVL(P.TS24,'N') TS24_P," ).append("\n"); 
		query.append("NVL(P.TS25,'N') TS25_P, NVL(P.TS26,'N') TS26_P," ).append("\n"); 
		query.append("NVL(P.TS27,'N') TS27_P, NVL(P.TS28,'N') TS28_P," ).append("\n"); 
		query.append("NVL(P.TS29,'N') TS29_P, NVL(P.TS30,'N') TS30_P" ).append("\n"); 
		query.append("FROM PARAM P" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(DQ.OFC_CD) RHQ," ).append("\n"); 
		query.append("BUYER_CD, BUYER_NM," ).append("\n"); 
		query.append("DQ.OFC_CD OFC_CD, DQ.CURR_CD, DQ.DCOL TYPE," ).append("\n"); 
		query.append("TO_CHAR(DQ.TS01_P) TS01_P, TO_CHAR(DQ.TS02_P) TS02_P, TO_CHAR(DQ.TS03_P) TS03_P, TO_CHAR(DQ.TS04_P) TS04_P, TO_CHAR(DQ.TS05_P) TS05_P," ).append("\n"); 
		query.append("TO_CHAR(DQ.TS06_P) TS06_P, TO_CHAR(DQ.TS07_P) TS07_P, TO_CHAR(DQ.TS08_P) TS08_P, TO_CHAR(DQ.TS09_P) TS09_P, TO_CHAR(DQ.TS10_P) TS10_P," ).append("\n"); 
		query.append("TO_CHAR(DQ.TS11_P) TS11_P, TO_CHAR(DQ.TS12_P) TS12_P, TO_CHAR(DQ.TS13_P) TS13_P, TO_CHAR(DQ.TS14_P) TS14_P, TO_CHAR(DQ.TS15_P) TS15_P," ).append("\n"); 
		query.append("TO_CHAR(DQ.TS16_P) TS16_P, TO_CHAR(DQ.TS17_P) TS17_P, TO_CHAR(DQ.TS18_P) TS18_P, TO_CHAR(DQ.TS19_P) TS19_P, TO_CHAR(DQ.TS20_P) TS20_P," ).append("\n"); 
		query.append("TO_CHAR(DQ.TS21_P) TS21_P, TO_CHAR(DQ.TS22_P) TS22_P, TO_CHAR(DQ.TS23_P) TS23_P, TO_CHAR(DQ.TS24_P) TS24_P, TO_CHAR(DQ.TS25_P) TS25_P," ).append("\n"); 
		query.append("TO_CHAR(DQ.TS26_P) TS26_P, TO_CHAR(DQ.TS27_P) TS27_P, TO_CHAR(DQ.TS28_P) TS28_P, TO_CHAR(DQ.TS29_P) TS29_P, TO_CHAR(DQ.TS30_P) TS30_P" ).append("\n"); 
		query.append("FROM  DISP_QTY DQ" ).append("\n"); 
		query.append("WHERE DQ.OFC_CD = DQ.OFC_CD" ).append("\n"); 
		query.append("#if (${rhq} != 'A')" ).append("\n"); 
		query.append("AND   MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(DQ.OFC_CD) = DECODE('ALL', 'ALL', MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(DQ.OFC_CD), @[rhq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY TITLE, RHQ, BUYER_CD, BUYER_NM, OFC_CD, TYPE2" ).append("\n"); 

	}
}