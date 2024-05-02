/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOsearchDisposalPFMCByRCCListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.12.23 박명신
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

public class PerformanceReportDBDAOsearchDisposalPFMCByRCCListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RCC/LCC/SCC 지역별 매각실적 현황목록을 조회합니다.
	  * </pre>
	  */
	public PerformanceReportDBDAOsearchDisposalPFMCByRCCListRSQL(){
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
		params.put("p_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("p_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOsearchDisposalPFMCByRCCListRSQL").append("\n"); 
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
		query.append("WITH TEMP_DROP AS (" ).append("\n"); 
		query.append("SELECT  A.DISP_NO, A.APRO_DT, A.EQ_KND_CD, A.CURR_CD," ).append("\n"); 
		query.append("A.DISP_DTL_SEQ, A.EQ_TPSZ_CD, A.DISP_QTY, A.DISP_YD_CD," ).append("\n"); 
		query.append("A.PART_AMT, A.CAL_PART_AMT, B.RPT_DP_SEQ," ).append("\n"); 
		query.append("C.LOC_CD, C.SCC_CD, C.LCC_CD, C.RCC_CD," ).append("\n"); 
		query.append("TO_CHAR(A.APRO_DT, 'YYYYMM') AS APRO_MON," ).append("\n"); 
		query.append("SUM(A.DISP_QTY) OVER() DISP_TOT" ).append("\n"); 
		query.append("FROM   (SELECT  A.DISP_NO, B.DISP_SOLD_DT AS APRO_DT, A.EQ_KND_CD, A.CURR_CD," ).append("\n"); 
		query.append("B.DISP_DTL_SEQ, B.EQ_TPSZ_CD, B.DISP_QTY, B.PART_AMT, B.DISP_YD_CD," ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(B.DISP_SOLD_DT, 'YYYYMM')," ).append("\n"); 
		query.append("A.CURR_CD, 'USD', B.PART_AMT) AS CAL_PART_AMT" ).append("\n"); 
		query.append("FROM    MNR_DISP_HDR A," ).append("\n"); 
		query.append("MNR_DISP_DTL B" ).append("\n"); 
		query.append("WHERE   A.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("AND     B.DISP_SOLD_DT IS NOT NULL" ).append("\n"); 
		query.append("AND     B.DISP_SOLD_DT BETWEEN TO_DATE(@[p_str_evnt_dt],'YYYYMMDD') AND TO_DATE(@[p_end_evnt_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("#if (${p_eq_knd_cd} != '' )" ).append("\n"); 
		query.append("AND     A.EQ_KND_CD = @[p_eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_disp_tp_cd} != '' )" ).append("\n"); 
		query.append("AND     A.DISP_TP_CD = @[p_disp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_disp_rsn_cd} != '' )" ).append("\n"); 
		query.append("AND     B.DISP_RSN_CD = @[p_disp_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_cust_cd} != '')" ).append("\n"); 
		query.append("AND     B.MNR_PRNR_CNT_CD = SUBSTR(@[p_cust_cd],0,2)" ).append("\n"); 
		query.append("AND     B.MNR_PRNR_SEQ = SUBSTR(@[p_cust_cd],3,8)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(SELECT  EQ_KND_CD, EQ_TPSZ_CD," ).append("\n"); 
		query.append("ROW_NUMBER() OVER(PARTITION BY EQ_KND_CD ORDER BY DP_SEQ) AS RPT_DP_SEQ" ).append("\n"); 
		query.append("FROM   (SELECT  EQ_KND_CD, EQ_TPSZ_CD, DP_SEQ" ).append("\n"); 
		query.append("FROM    CGM_EQ_TP_SZ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'U' AS EQ_KND_CD, CNTR_TPSZ_CD, RPT_DP_SEQ" ).append("\n"); 
		query.append("FROM    MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(SELECT  A.LOC_CD, A.RGN_CD, A.SCC_CD, A.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("C.LCC_CD, C.ECC_CD, C.RCC_CD" ).append("\n"); 
		query.append("FROM    MDM_LOCATION A," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("WHERE   A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE   A.EQ_KND_CD  = B.EQ_KND_CD" ).append("\n"); 
		query.append("AND     A.EQ_TPSZ_CD = B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("AND     SUBSTR(A.DISP_YD_CD,1,5) = C.LOC_CD" ).append("\n"); 
		query.append("#if (${p_loc_cd} != '')" ).append("\n"); 
		query.append("#if (${p_loc_tp} == 'RCC')" ).append("\n"); 
		query.append("AND    	C.RCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("#elseif (${p_loc_tp} == 'LCC')" ).append("\n"); 
		query.append("AND    	C.LCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    	C.SCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  CASE WHEN A.RCC_CD IS NULL THEN 0" ).append("\n"); 
		query.append("WHEN A.LCC_CD IS NULL THEN 0" ).append("\n"); 
		query.append("WHEN A.SCC_CD IS NULL THEN 1" ).append("\n"); 
		query.append("ELSE 2 END LEVEL_NO," ).append("\n"); 
		query.append("CASE WHEN A.RCC_CD IS NULL THEN NVL(A.LOC_CD, 'G.TTL')" ).append("\n"); 
		query.append("WHEN A.LCC_CD IS NULL THEN A.RCC_CD" ).append("\n"); 
		query.append("WHEN A.SCC_CD IS NULL THEN A.LCC_CD" ).append("\n"); 
		query.append("ELSE A.SCC_CD END LOC_CD," ).append("\n"); 
		query.append("A.RCC_CD, A.LCC_CD, A.SCC_CD," ).append("\n"); 
		query.append("A.DISP_QTY_TOT," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio'" ).append("\n"); 
		query.append("THEN LTRIM(TO_CHAR(A.DISP_QTY_CNT / A.DISP_QTY_TOT * 100, '990.00'))||'%'" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(A.DISP_QTY_CNT, '999,999,990')) END DISP_QTY_CNT," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN NULL" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(A.DISP_QTY_CNT / A.DISP_QTY_TOT * 100, '990.00'))||'%'" ).append("\n"); 
		query.append("END DISP_QTY_RTO," ).append("\n"); 
		query.append("LTRIM(TO_CHAR(A.CAL_PART_AMT_TOT, '999,999,990.00')) AS CAL_PART_AMT_TOT," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP01, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP01, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP01, 0), '999,999,990')) END TPSZ_DP01," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP02, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP02, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP02, 0), '999,999,990')) END TPSZ_DP02," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP03, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP03, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP03, 0), '999,999,990')) END TPSZ_DP03," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP04, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP04, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP04, 0), '999,999,990')) END TPSZ_DP04," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP05, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP05, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP05, 0), '999,999,990')) END TPSZ_DP05," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP06, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP06, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP06, 0), '999,999,990')) END TPSZ_DP06," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP07, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP07, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP07, 0), '999,999,990')) END TPSZ_DP07," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP08, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP08, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP08, 0), '999,999,990')) END TPSZ_DP08," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP09, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP09, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP09, 0), '999,999,990')) END TPSZ_DP09," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP10, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP10, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP10, 0), '999,999,990')) END TPSZ_DP10," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP11, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP11, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP11, 0), '999,999,990')) END TPSZ_DP11," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP12, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP12, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP12, 0), '999,999,990')) END TPSZ_DP12," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP13, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP13, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP13, 0), '999,999,990')) END TPSZ_DP13," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP14, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP14, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP14, 0), '999,999,990')) END TPSZ_DP14," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP15, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP15, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP15, 0), '999,999,990')) END TPSZ_DP15," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP16, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP16, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP16, 0), '999,999,990')) END TPSZ_DP16," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP17, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP17, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP17, 0), '999,999,990')) END TPSZ_DP17," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP18, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP18, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP18, 0), '999,999,990')) END TPSZ_DP18," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP19, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP19, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP19, 0), '999,999,990')) END TPSZ_DP19," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP20, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP20, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP20, 0), '999,999,990')) END TPSZ_DP20," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP21, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP21, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP21, 0), '999,999,990')) END TPSZ_DP21," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP22, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP22, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP22, 0), '999,999,990')) END TPSZ_DP22," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP23, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP23, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP23, 0), '999,999,990')) END TPSZ_DP23," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP24, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP24, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP24, 0), '999,999,990')) END TPSZ_DP24," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP25, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP25, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP25, 0), '999,999,990')) END TPSZ_DP25," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP26, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP26, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP26, 0), '999,999,990')) END TPSZ_DP26," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP27, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP27, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP27, 0), '999,999,990')) END TPSZ_DP27," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP28, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP28, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP28, 0), '999,999,990')) END TPSZ_DP28," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP29, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP29, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP29, 0), '999,999,990')) END TPSZ_DP29," ).append("\n"); 
		query.append("CASE WHEN A.LOC_CD = 'Ratio' THEN LTRIM(TO_CHAR(A.TPSZ_DP30, '990.00'))||'%'" ).append("\n"); 
		query.append("WHEN A.LOC_CD IN('G.AMT','G.AVG') THEN LTRIM(TO_CHAR(A.TPSZ_DP30, '999,999,990.00'))" ).append("\n"); 
		query.append("ELSE LTRIM(TO_CHAR(NVL(A.TPSZ_DP30, 0), '999,999,990')) END TPSZ_DP30" ).append("\n"); 
		query.append("FROM   (SELECT  '' AS LOC_CD, A.RCC_CD, A.LCC_CD, A.SCC_CD," ).append("\n"); 
		query.append("MAX(A.DISP_TOT) AS DISP_QTY_TOT," ).append("\n"); 
		query.append("SUM(A.DISP_QTY) AS DISP_QTY_CNT," ).append("\n"); 
		query.append("SUM(A.PART_AMT) AS PART_AMT_TOT," ).append("\n"); 
		query.append("SUM(A.CAL_PART_AMT) AS CAL_PART_AMT_TOT," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 1 THEN A.DISP_QTY END) AS TPSZ_DP01," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 2 THEN A.DISP_QTY END) AS TPSZ_DP02," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 3 THEN A.DISP_QTY END) AS TPSZ_DP03," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 4 THEN A.DISP_QTY END) AS TPSZ_DP04," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 5 THEN A.DISP_QTY END) AS TPSZ_DP05," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 6 THEN A.DISP_QTY END) AS TPSZ_DP06," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 7 THEN A.DISP_QTY END) AS TPSZ_DP07," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 8 THEN A.DISP_QTY END) AS TPSZ_DP08," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 9 THEN A.DISP_QTY END) AS TPSZ_DP09," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =10 THEN A.DISP_QTY END) AS TPSZ_DP10," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =11 THEN A.DISP_QTY END) AS TPSZ_DP11," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =12 THEN A.DISP_QTY END) AS TPSZ_DP12," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =13 THEN A.DISP_QTY END) AS TPSZ_DP13," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =14 THEN A.DISP_QTY END) AS TPSZ_DP14," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =15 THEN A.DISP_QTY END) AS TPSZ_DP15," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =16 THEN A.DISP_QTY END) AS TPSZ_DP16," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =17 THEN A.DISP_QTY END) AS TPSZ_DP17," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =18 THEN A.DISP_QTY END) AS TPSZ_DP18," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =19 THEN A.DISP_QTY END) AS TPSZ_DP19," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =20 THEN A.DISP_QTY END) AS TPSZ_DP20," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =21 THEN A.DISP_QTY END) AS TPSZ_DP21," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =22 THEN A.DISP_QTY END) AS TPSZ_DP22," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =23 THEN A.DISP_QTY END) AS TPSZ_DP23," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =24 THEN A.DISP_QTY END) AS TPSZ_DP24," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =25 THEN A.DISP_QTY END) AS TPSZ_DP25," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =26 THEN A.DISP_QTY END) AS TPSZ_DP26," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =27 THEN A.DISP_QTY END) AS TPSZ_DP27," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =28 THEN A.DISP_QTY END) AS TPSZ_DP28," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =29 THEN A.DISP_QTY END) AS TPSZ_DP29," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =30 THEN A.DISP_QTY END) AS TPSZ_DP30" ).append("\n"); 
		query.append("FROM    TEMP_DROP A" ).append("\n"); 
		query.append("GROUP BY ROLLUP(A.RCC_CD, A.LCC_CD, A.SCC_CD)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'G.AMT' AS LOC_CD, '' AS RCC_CD, '' AS LCC_CD, '' AS SCC_CD," ).append("\n"); 
		query.append("MAX(A.DISP_TOT) AS DISP_QTY_TOT," ).append("\n"); 
		query.append("SUM(A.DISP_QTY) AS DISP_QTY_CNT," ).append("\n"); 
		query.append("SUM(A.CAL_PART_AMT) AS PART_AMT_TOT," ).append("\n"); 
		query.append("SUM(A.CAL_PART_AMT) AS CAL_PART_AMT_TOT," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 1 THEN A.CAL_PART_AMT END) AS TPSZ_DP01," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 2 THEN A.CAL_PART_AMT END) AS TPSZ_DP02," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 3 THEN A.CAL_PART_AMT END) AS TPSZ_DP03," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 4 THEN A.CAL_PART_AMT END) AS TPSZ_DP04," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 5 THEN A.CAL_PART_AMT END) AS TPSZ_DP05," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 6 THEN A.CAL_PART_AMT END) AS TPSZ_DP06," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 7 THEN A.CAL_PART_AMT END) AS TPSZ_DP07," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 8 THEN A.CAL_PART_AMT END) AS TPSZ_DP08," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 9 THEN A.CAL_PART_AMT END) AS TPSZ_DP09," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =10 THEN A.CAL_PART_AMT END) AS TPSZ_DP10," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =11 THEN A.CAL_PART_AMT END) AS TPSZ_DP11," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =12 THEN A.CAL_PART_AMT END) AS TPSZ_DP12," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =13 THEN A.CAL_PART_AMT END) AS TPSZ_DP13," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =14 THEN A.CAL_PART_AMT END) AS TPSZ_DP14," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =15 THEN A.CAL_PART_AMT END) AS TPSZ_DP15," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =16 THEN A.CAL_PART_AMT END) AS TPSZ_DP16," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =17 THEN A.CAL_PART_AMT END) AS TPSZ_DP17," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =18 THEN A.CAL_PART_AMT END) AS TPSZ_DP18," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =19 THEN A.CAL_PART_AMT END) AS TPSZ_DP19," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =20 THEN A.CAL_PART_AMT END) AS TPSZ_DP20," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =21 THEN A.CAL_PART_AMT END) AS TPSZ_DP21," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =22 THEN A.CAL_PART_AMT END) AS TPSZ_DP22," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =23 THEN A.CAL_PART_AMT END) AS TPSZ_DP23," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =24 THEN A.CAL_PART_AMT END) AS TPSZ_DP24," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =25 THEN A.CAL_PART_AMT END) AS TPSZ_DP25," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =26 THEN A.CAL_PART_AMT END) AS TPSZ_DP26," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =27 THEN A.CAL_PART_AMT END) AS TPSZ_DP27," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =28 THEN A.CAL_PART_AMT END) AS TPSZ_DP28," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =29 THEN A.CAL_PART_AMT END) AS TPSZ_DP29," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =30 THEN A.CAL_PART_AMT END) AS TPSZ_DP30" ).append("\n"); 
		query.append("FROM    TEMP_DROP A" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'G.AVG' AS LOC_CD, '' AS RCC_CD, '' AS LCC_CD, '' AS SCC_CD," ).append("\n"); 
		query.append("MAX(A.DISP_TOT) AS DISP_QTY_TOT," ).append("\n"); 
		query.append("SUM(A.DISP_QTY) AS DISP_QTY_CNT," ).append("\n"); 
		query.append("SUM(A.CAL_PART_AMT) AS PART_AMT_TOT," ).append("\n"); 
		query.append("NULL AS CAL_PART_AMT_TOT," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 1 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ = 1 THEN A.DISP_QTY END) AS TPSZ_DP01," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 2 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ = 2 THEN A.DISP_QTY END) AS TPSZ_DP02," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 3 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ = 3 THEN A.DISP_QTY END) AS TPSZ_DP03," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 4 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ = 4 THEN A.DISP_QTY END) AS TPSZ_DP04," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 5 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ = 5 THEN A.DISP_QTY END) AS TPSZ_DP05," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 6 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ = 6 THEN A.DISP_QTY END) AS TPSZ_DP06," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 7 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ = 7 THEN A.DISP_QTY END) AS TPSZ_DP07," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 8 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ = 8 THEN A.DISP_QTY END) AS TPSZ_DP08," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 9 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ = 9 THEN A.DISP_QTY END) AS TPSZ_DP09," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =10 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =10 THEN A.DISP_QTY END) AS TPSZ_DP10," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =11 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =11 THEN A.DISP_QTY END) AS TPSZ_DP11," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =12 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =12 THEN A.DISP_QTY END) AS TPSZ_DP12," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =13 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =13 THEN A.DISP_QTY END) AS TPSZ_DP13," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =14 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =14 THEN A.DISP_QTY END) AS TPSZ_DP14," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =15 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =15 THEN A.DISP_QTY END) AS TPSZ_DP15," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =16 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =16 THEN A.DISP_QTY END) AS TPSZ_DP16," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =17 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =17 THEN A.DISP_QTY END) AS TPSZ_DP17," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =18 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =18 THEN A.DISP_QTY END) AS TPSZ_DP18," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =19 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =19 THEN A.DISP_QTY END) AS TPSZ_DP19," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =20 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =20 THEN A.DISP_QTY END) AS TPSZ_DP20," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =21 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =21 THEN A.DISP_QTY END) AS TPSZ_DP21," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =22 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =22 THEN A.DISP_QTY END) AS TPSZ_DP22," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =23 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =23 THEN A.DISP_QTY END) AS TPSZ_DP23," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =24 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =24 THEN A.DISP_QTY END) AS TPSZ_DP24," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =25 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =25 THEN A.DISP_QTY END) AS TPSZ_DP25," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =26 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =26 THEN A.DISP_QTY END) AS TPSZ_DP26," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =27 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =27 THEN A.DISP_QTY END) AS TPSZ_DP27," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =28 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =28 THEN A.DISP_QTY END) AS TPSZ_DP28," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =29 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =29 THEN A.DISP_QTY END) AS TPSZ_DP29," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =30 THEN A.CAL_PART_AMT END) / SUM(CASE WHEN A.RPT_DP_SEQ =30 THEN A.DISP_QTY END) AS TPSZ_DP30" ).append("\n"); 
		query.append("FROM    TEMP_DROP A" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'Ratio' AS LOC_CD, '' AS RCC_CD, '' AS LCC_CD, '' AS SCC_CD," ).append("\n"); 
		query.append("MAX(A.DISP_TOT) AS DISP_QTY_TOT," ).append("\n"); 
		query.append("SUM(A.DISP_QTY) AS DISP_QTY_CNT," ).append("\n"); 
		query.append("SUM(A.CAL_PART_AMT) AS PART_AMT_TOT," ).append("\n"); 
		query.append("NULL AS CAL_PART_AMT_TOT," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 1 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP01," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 2 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP02," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 3 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP03," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 4 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP04," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 5 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP05," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 6 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP06," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 7 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP07," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 8 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP08," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ = 9 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP09," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =10 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP10," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =11 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP11," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =12 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP12," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =13 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP13," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =14 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP14," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =15 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP15," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =16 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP16," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =17 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP17," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =18 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP18," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =19 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP19," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =20 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP20," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =21 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP21," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =22 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP22," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =23 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP23," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =24 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP24," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =25 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP25," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =26 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP26," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =27 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP27," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =28 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP28," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =29 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP29," ).append("\n"); 
		query.append("SUM(CASE WHEN A.RPT_DP_SEQ =30 THEN A.DISP_QTY END) / MAX(A.DISP_TOT) * 100 AS TPSZ_DP30" ).append("\n"); 
		query.append("FROM    TEMP_DROP A" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY DECODE(A.LOC_CD, 'Ratio',3,'G.AVG',2,'G.AMT',1,0), A.RCC_CD, DECODE(A.LCC_CD, '',0,1)," ).append("\n"); 
		query.append("A.LCC_CD, DECODE(A.SCC_CD, '',0,1), A.SCC_CD" ).append("\n"); 

	}
}