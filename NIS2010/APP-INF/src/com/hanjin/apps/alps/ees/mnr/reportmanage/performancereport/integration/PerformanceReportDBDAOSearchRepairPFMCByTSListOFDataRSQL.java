/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchRepairPFMCByTSListOFDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.22 박명신
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

public class PerformanceReportDBDAOSearchRepairPFMCByTSListOFDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRepairPFMCByTSListOFData
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchRepairPFMCByTSListOFDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("manu_yr_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("manu_yr_to",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PerformanceReportDBDAOSearchRepairPFMCByTSListOFDataRSQL").append("\n"); 
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
		query.append("WITH EQ_LIST" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("SELECT EQ_KIND," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 1, TPSZ))  TS01, MAX(DECODE(RNK, 2, TPSZ))  TS02, MAX(DECODE(RNK, 3, TPSZ))  TS03, MAX(DECODE(RNK, 4,  TPSZ)) TS04, MAX(DECODE(RNK, 5,  TPSZ)) TS05," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 6, TPSZ))  TS06, MAX(DECODE(RNK, 7, TPSZ))  TS07, MAX(DECODE(RNK, 8, TPSZ))  TS08, MAX(DECODE(RNK, 9,  TPSZ)) TS09, MAX(DECODE(RNK, 10, TPSZ)) TS10," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 11, TPSZ)) TS11, MAX(DECODE(RNK, 12, TPSZ)) TS12, MAX(DECODE(RNK, 13, TPSZ)) TS13, MAX(DECODE(RNK, 14, TPSZ)) TS14, MAX(DECODE(RNK, 15, TPSZ)) TS15," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 16, TPSZ)) TS16, MAX(DECODE(RNK, 17, TPSZ)) TS17, MAX(DECODE(RNK, 18, TPSZ)) TS18, MAX(DECODE(RNK, 19, TPSZ)) TS19, MAX(DECODE(RNK, 20, TPSZ)) TS20," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 21, TPSZ)) TS21, MAX(DECODE(RNK, 22, TPSZ)) TS22, MAX(DECODE(RNK, 23, TPSZ)) TS23, MAX(DECODE(RNK, 24, TPSZ)) TS24, MAX(DECODE(RNK, 25, TPSZ)) TS25," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 26, TPSZ)) TS26, MAX(DECODE(RNK, 27, TPSZ)) TS27, MAX(DECODE(RNK, 28, TPSZ)) TS28, MAX(DECODE(RNK, 29, TPSZ)) TS29, MAX(DECODE(RNK, 30, TPSZ)) TS30" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  EQ_KIND, TPSZ, ROW_NUMBER() OVER(ORDER BY EQ_KIND, DP_SEQ) RNK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'U' EQ_KIND,  A.CNTR_TPSZ_CD TPSZ, A.RPT_DP_SEQ DP_SEQ" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("#if (${eq_type} != 'A')" ).append("\n"); 
		query.append("AND   'U' = @[eq_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_sz_cd} != '')" ).append("\n"); 
		query.append("AND	A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("'$user_tpszCds'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_tpszCds'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.EQ_KND_CD EQ_KIND, A.EQ_TPSZ_CD TPSZ, A.DP_SEQ DP_SEQ" ).append("\n"); 
		query.append("FROM CGM_EQ_TP_SZ A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${eq_type} != 'A')" ).append("\n"); 
		query.append("AND   A.EQ_KND_CD = @[eq_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_sz_cd} != '')" ).append("\n"); 
		query.append("AND	A.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("'$user_tpszCds'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_tpszCds'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY EQ_KIND" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", DUMMY_COL AS (" ).append("\n"); 
		query.append("SELECT 'Q' DCOL FROM DUAL  --QTY" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'S' DCOL FROM DUAL  --AMOUNT" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Z' DCOL FROM DUAL  --AVG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("LV_PFMC AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(OH.COST_OFC_CD)) RHQ," ).append("\n"); 
		query.append("OH.COST_OFC_CD OFC_CD, C.DCOL," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS01, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS01, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS01, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS01, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS01_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS02, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS02, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS02, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS02, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS02_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS03, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS03, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS03, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS03, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS03_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS04, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS04, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS04, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS04, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS04_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS05, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS05, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS05, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS05, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS05_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS06, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS06, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS06, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS06, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS06_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS07, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS07, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS07, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS07, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS07_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS08, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS08, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS08, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS08, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS08_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS09, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS09, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS09, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS09, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS09_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS10, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS10, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS10, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS10, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS10_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS11, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS11, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS11, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS11, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS11_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS12, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS12, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS12, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS12, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS12_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS13, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS13, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS13, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS13, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS13_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS14, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS14, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS14, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS14, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS14_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS15, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS15, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS15, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS15, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS15_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS16, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS16, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS16, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS16, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS16_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS17, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS17, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS17, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS17, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS17_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS18, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS18, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS18, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS18, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS18_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS19, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS19, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS19, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS19, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS19_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS20, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS20, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS20, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS20, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS20_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS21, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS21, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS21, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS21, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS21_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS22, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS22, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS22, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS22, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS22_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS23, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS23, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS23, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS23, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS23_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS24, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS24, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS24, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS24, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS24_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS25, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS25, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS25, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS25, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS25_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS26, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS26, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS26, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS26, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS26_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS27, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS27, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS27, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS27, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS27_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS28, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS28, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS28, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS28, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS28_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS29, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS29, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS29, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS29, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS29_P," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Q' THEN SUM(DECODE(P.TS30, OD.EQ_TPSZ_CD, OD.RPR_QTY))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'S' THEN" ).append("\n"); 
		query.append("SUM(DECODE(P.TS30, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("WHEN C.DCOL = 'Z' THEN" ).append("\n"); 
		query.append("ROUND(SUM(DECODE(P.TS30, OD.EQ_TPSZ_CD, MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(OH.CRE_DT, 'YYYYMM'), OH.CURR_CD, 'USD', OD.COST_AMT)))" ).append("\n"); 
		query.append("/SUM(DECODE(P.TS30, OD.EQ_TPSZ_CD, OD.RPR_QTY)), 2)" ).append("\n"); 
		query.append("END TS30_P" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR OH, MNR_ORD_DTL OD, EQ_LIST P, DUMMY_COL C, MNR_PAY_INV_WRK IW" ).append("\n"); 
		query.append("#if ((${manu_yr_fr} != '' && ${manu_yr_to} != '') || ${lstm_cd} != 'A' || ${mkr_nm} != 'A')" ).append("\n"); 
		query.append(", MNR_EQ_STS_V ESV" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_period_type} == 'EI' || ${mnr_warr_flg} == 'Y')" ).append("\n"); 
		query.append(",MNR_RPR_RQST_HDR RH" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   OH.MNR_ORD_SEQ        = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   OD.EQ_NO IS NOT NULL" ).append("\n"); 
		query.append("AND   OD.RPR_QTY > 0" ).append("\n"); 
		query.append("AND   OD.EQ_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("AND   OD.ACCT_CD <> '512125'" ).append("\n"); 
		query.append("#if (${report_period_type} == 'WI')" ).append("\n"); 
		query.append("AND   OH.CRE_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND   OD.PAY_INV_SEQ = IW.PAY_INV_SEQ(+)" ).append("\n"); 
		query.append("#elseif(${report_period_type} == 'EI')" ).append("\n"); 
		query.append("AND   RH.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   RH.MNR_ORD_SEQ = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   RH.CRE_DT BETWEEN  TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND   OD.PAY_INV_SEQ = IW.PAY_INV_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   IW.CRE_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND   OD.PAY_INV_SEQ = IW.PAY_INV_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_type} != 'A')" ).append("\n"); 
		query.append("AND   OH.EQ_KND_CD  = @[eq_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A')" ).append("\n"); 
		query.append("AND   MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(OH.COST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A')" ).append("\n"); 
		query.append("AND   OH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND   OH.VNDR_SEQ   = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${manu_yr_fr} != '' && ${manu_yr_to} != '') || ${lstm_cd} != 'A' || ${mkr_nm} != 'A')" ).append("\n"); 
		query.append("AND   OD.EQ_NO = ESV.EQ_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${manu_yr_fr} != '' && ${manu_yr_to} != '')" ).append("\n"); 
		query.append("AND   SUBSTR(ESV.MANU_DT,0,4) BETWEEN @[manu_yr_fr] AND @[manu_yr_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != 'A' && ${lstm_cd} != '')" ).append("\n"); 
		query.append("AND   ESV.LSTM_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_lstmCds IN ${lstmCds})" ).append("\n"); 
		query.append("#if($velocityCount < $lstmCds.size())" ).append("\n"); 
		query.append("'$user_lstmCds'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_lstmCds'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_warr_flg} == 'Y')" ).append("\n"); 
		query.append("AND RH.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND RH.MNR_ORD_SEQ = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND RH.MNR_WARR_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY OH.COST_OFC_CD, C.DCOL" ).append("\n"); 
		query.append("ORDER BY MAX(MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(OH.COST_OFC_CD)), OH.COST_OFC_CD, C.DCOL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("RSV.RHQ, RSV.OFC_CD, 'USD' AS CURR_CD, RSV.DCOL," ).append("\n"); 
		query.append("DECODE(RSV.RHQ,'AAA', NVL(P.TS01,'N') || '|' || NVL(P.TS02,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS03,'N') || '|' || NVL(P.TS04,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS05,'N') || '|' || NVL(P.TS06,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS07,'N') || '|' || NVL(P.TS08,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS09,'N') || '|' || NVL(P.TS10,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS11,'N') || '|' || NVL(P.TS12,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS13,'N') || '|' || NVL(P.TS14,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS15,'N') || '|' || NVL(P.TS16,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS17,'N') || '|' || NVL(P.TS18,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS19,'N') || '|' || NVL(P.TS20,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS21,'N') || '|' || NVL(P.TS22,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS23,'N') || '|' || NVL(P.TS24,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS25,'N') || '|' || NVL(P.TS26,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS27,'N') || '|' || NVL(P.TS28,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS29,'N') || '|' || NVL(P.TS30,'N'),'') AS TITLE," ).append("\n"); 
		query.append("RSV.TS01  ,RSV.TS02" ).append("\n"); 
		query.append(",RSV.TS03  ,RSV.TS04" ).append("\n"); 
		query.append(",RSV.TS05  ,RSV.TS06" ).append("\n"); 
		query.append(",RSV.TS07  ,RSV.TS08" ).append("\n"); 
		query.append(",RSV.TS09  ,RSV.TS10" ).append("\n"); 
		query.append(",RSV.TS11  ,RSV.TS12" ).append("\n"); 
		query.append(",RSV.TS13  ,RSV.TS14" ).append("\n"); 
		query.append(",RSV.TS15  ,RSV.TS16" ).append("\n"); 
		query.append(",RSV.TS17  ,RSV.TS18" ).append("\n"); 
		query.append(",RSV.TS19  ,RSV.TS20" ).append("\n"); 
		query.append(",RSV.TS21  ,RSV.TS22" ).append("\n"); 
		query.append(",RSV.TS23  ,RSV.TS24" ).append("\n"); 
		query.append(",RSV.TS25  ,RSV.TS26" ).append("\n"); 
		query.append(",RSV.TS27  ,RSV.TS28" ).append("\n"); 
		query.append(",RSV.TS29  ,RSV.TS30" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'AAA' AS RHQ, 'OFFICE' AS OFC_CD, '' AS DCOL, '0' AS DCOL2," ).append("\n"); 
		query.append("NVL(P.TS01,'N') AS TS01,  NVL(P.TS02,'N') AS TS02," ).append("\n"); 
		query.append("NVL(P.TS03,'N') AS TS03,  NVL(P.TS04,'N') AS TS04," ).append("\n"); 
		query.append("NVL(P.TS05,'N') AS TS05,  NVL(P.TS06,'N') AS TS06," ).append("\n"); 
		query.append("NVL(P.TS07,'N') AS TS07,  NVL(P.TS08,'N') AS TS08," ).append("\n"); 
		query.append("NVL(P.TS09,'N') AS TS09,  NVL(P.TS10,'N') AS TS10," ).append("\n"); 
		query.append("NVL(P.TS11,'N') AS TS11,  NVL(P.TS12,'N') AS TS12," ).append("\n"); 
		query.append("NVL(P.TS13,'N') AS TS13,  NVL(P.TS14,'N') AS TS14," ).append("\n"); 
		query.append("NVL(P.TS15,'N') AS TS15,  NVL(P.TS16,'N') AS TS16," ).append("\n"); 
		query.append("NVL(P.TS17,'N') AS TS17,  NVL(P.TS18,'N') AS TS18," ).append("\n"); 
		query.append("NVL(P.TS19,'N') AS TS19,  NVL(P.TS20,'N') AS TS20," ).append("\n"); 
		query.append("NVL(P.TS21,'N') AS TS21,  NVL(P.TS22,'N') AS TS22," ).append("\n"); 
		query.append("NVL(P.TS23,'N') AS TS23,  NVL(P.TS24,'N') AS TS24," ).append("\n"); 
		query.append("NVL(P.TS25,'N') AS TS25,  NVL(P.TS26,'N') AS TS26," ).append("\n"); 
		query.append("NVL(P.TS27,'N') AS TS27,  NVL(P.TS28,'N') AS TS28," ).append("\n"); 
		query.append("NVL(P.TS29,'N') AS TS29,  NVL(P.TS30,'N') AS TS30" ).append("\n"); 
		query.append("FROM EQ_LIST P" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.RHQ ,A.OFC_CD, DECODE(DCOL, 'Q', 'QTY', 'S', 'AMT', 'Z', 'AVG') DCOL," ).append("\n"); 
		query.append("DECODE(DCOL, 'Q', '1', 'S', '2', 'Z', '3') DCOL2" ).append("\n"); 
		query.append(",TO_CHAR(A.TS01_P) AS TS01	,TO_CHAR(A.TS02_P) AS TS02" ).append("\n"); 
		query.append(",TO_CHAR(A.TS03_P) AS TS03	,TO_CHAR(A.TS04_P) AS TS04" ).append("\n"); 
		query.append(",TO_CHAR(A.TS05_P) AS TS05	,TO_CHAR(A.TS06_P) AS TS06" ).append("\n"); 
		query.append(",TO_CHAR(A.TS07_P) AS TS07	,TO_CHAR(A.TS08_P) AS TS08" ).append("\n"); 
		query.append(",TO_CHAR(A.TS09_P) AS TS09	,TO_CHAR(A.TS10_P) AS TS10" ).append("\n"); 
		query.append(",TO_CHAR(A.TS11_P) AS TS11	,TO_CHAR(A.TS12_P) AS TS12" ).append("\n"); 
		query.append(",TO_CHAR(A.TS13_P) AS TS13	,TO_CHAR(A.TS14_P) AS TS14" ).append("\n"); 
		query.append(",TO_CHAR(A.TS15_P) AS TS15	,TO_CHAR(A.TS16_P) AS TS16" ).append("\n"); 
		query.append(",TO_CHAR(A.TS17_P) AS TS17	,TO_CHAR(A.TS18_P) AS TS18" ).append("\n"); 
		query.append(",TO_CHAR(A.TS19_P) AS TS19	,TO_CHAR(A.TS20_P) AS TS20" ).append("\n"); 
		query.append(",TO_CHAR(A.TS21_P) AS TS21	,TO_CHAR(A.TS22_P) AS TS22" ).append("\n"); 
		query.append(",TO_CHAR(A.TS23_P) AS TS23	,TO_CHAR(A.TS24_P) AS TS24" ).append("\n"); 
		query.append(",TO_CHAR(A.TS25_P) AS TS25	,TO_CHAR(A.TS26_P) AS TS26" ).append("\n"); 
		query.append(",TO_CHAR(A.TS27_P) AS TS27	,TO_CHAR(A.TS28_P) AS TS28" ).append("\n"); 
		query.append(",TO_CHAR(A.TS29_P) AS TS29	,TO_CHAR(A.TS30_P) AS TS30" ).append("\n"); 
		query.append("FROM LV_PFMC A,EQ_LIST P" ).append("\n"); 
		query.append(") RSV,EQ_LIST P" ).append("\n"); 
		query.append("ORDER BY RSV.RHQ, RSV.OFC_CD, RSV.DCOL2" ).append("\n"); 

	}
}