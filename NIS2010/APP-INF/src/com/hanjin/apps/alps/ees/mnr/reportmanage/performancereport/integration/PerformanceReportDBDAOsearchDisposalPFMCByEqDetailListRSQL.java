/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOsearchDisposalPFMCByEqDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOsearchDisposalPFMCByEqDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 장비별 매각실적 상세목록을 조회합니다.
	  * --------------------------------------------------------
	  * History
	  * 2011.11.30 남궁진호 [CHM-201007327-01]   Disposal Performance를 장비별 Detail 내역 조회
	  * 2011.11.21 김상수 [CHM-201114548-01] sheet에 새로 추가된 DB컬럼 Book Vale 조회 추가
	  * 2012.07.16 김창헌 [CHM-201218975-01] EQ TP/SZ 조건 추가
	  * 2013.01.03 조경완 [CHM-201218975-01] ALPS MNR-DISPOSAL-DISPOSAL PERFORMANCE-BY EQ에서 OVER DAY LOGIC 변경 요청
	  * </pre>
	  */
	public PerformanceReportDBDAOsearchDisposalPFMCByEqDetailListRSQL(){
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
		params.put("p_str_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("p_end_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PerformanceReportDBDAOsearchDisposalPFMCByEqDetailListRSQL").append("\n"); 
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
		query.append("SELECT A.RHQ_CD," ).append("\n"); 
		query.append("A.RQST_OFC_CD," ).append("\n"); 
		query.append("A.APRO_OFC_CD," ).append("\n"); 
		query.append("A.DISP_PKUP_ST_DT," ).append("\n"); 
		query.append("A.DISP_PKUP_END_DT," ).append("\n"); 
		query.append("TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') AS CRE_DT," ).append("\n"); 
		query.append("A.OVER_DATE AS OVER_DATE," ).append("\n"); 
		query.append("A.EQ_KND_CD," ).append("\n"); 
		query.append("A.EQ_NO," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.MANU_DT," ).append("\n"); 
		query.append("A.DISP_TP_CD," ).append("\n"); 
		query.append("A.DISP_NO," ).append("\n"); 
		query.append("A.DISP_DTL_SEQ," ).append("\n"); 
		query.append("TO_CHAR(A.DISP_SOLD_DT, 'YYYY-MM-DD') AS DISP_SOLD_DT," ).append("\n"); 
		query.append("A.CUST_CD," ).append("\n"); 
		query.append("A.CUST_NM," ).append("\n"); 
		query.append("B.RCC_CD," ).append("\n"); 
		query.append("B.LCC_CD," ).append("\n"); 
		query.append("B.SCC_CD," ).append("\n"); 
		query.append("B.LOC_CD," ).append("\n"); 
		query.append("A.DISP_YD_CD," ).append("\n"); 
		query.append("(SELECT MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID = 'CD00038'" ).append("\n"); 
		query.append("AND MNR_CD_ID = A.DISP_RSN_CD) AS DISP_RSN_CD," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("A.PART_AMT," ).append("\n"); 
		query.append("A.CAL_PART_AMT," ).append("\n"); 
		query.append("A.DISP_UT_PRC," ).append("\n"); 
		query.append("A.DISP_TRF_UT_PRC," ).append("\n"); 
		query.append("A.DISP_VRFY_TP_CD," ).append("\n"); 
		query.append("(SELECT MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID = 'CD00080'" ).append("\n"); 
		query.append("AND MNR_CD_ID = A.DISP_VRFY_TP_CD) AS DISP_VRFY_TP_NM," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.DISP_RSN_CD != 'C'" ).append("\n"); 
		query.append("THEN A.RPR_COST_AMT" ).append("\n"); 
		query.append("END AS RPR_COST_AMT," ).append("\n"); 
		query.append("A.BK_VAL_AMT," ).append("\n"); 
		query.append("A.INV_NO," ).append("\n"); 
		query.append("TO_CHAR(A.ISS_DT, 'YYYY-MM-DD') AS ISS_DT" ).append("\n"); 
		query.append("FROM (SELECT A.DISP_NO," ).append("\n"); 
		query.append("B.DISP_SOLD_DT," ).append("\n"); 
		query.append("B.CRE_DT," ).append("\n"); 
		query.append("A.EQ_KND_CD," ).append("\n"); 
		query.append("A.DISP_TP_CD," ).append("\n"); 
		query.append("A.RQST_OFC_CD," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(A.RQST_OFC_CD) AS RHQ_CD," ).append("\n"); 
		query.append("TO_CHAR(A.DISP_PKUP_ST_DT, 'YYYY-MM-DD') AS DISP_PKUP_ST_DT," ).append("\n"); 
		query.append("TO_CHAR(A.DISP_PKUP_END_DT, 'YYYY-MM-DD') AS DISP_PKUP_END_DT," ).append("\n"); 
		query.append("TO_CHAR(A.DISP_PKUP_ST_DT, 'YYYYMMDD') AS DISP_PKUP_ST_DT_VAL," ).append("\n"); 
		query.append("A.DISP_PKUP_END_DT AS DISP_PKUP_END_DT_VAL," ).append("\n"); 
		query.append("A.APRO_OFC_CD," ).append("\n"); 
		query.append("B.DISP_DTL_SEQ," ).append("\n"); 
		query.append("B.EQ_TPSZ_CD," ).append("\n"); 
		query.append("B.DISP_QTY," ).append("\n"); 
		query.append("B.PART_AMT," ).append("\n"); 
		query.append("B.DISP_YD_CD," ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(B.DISP_SOLD_DT, 'YYYYMM'), A.CURR_CD, 'USD', B.PART_AMT) AS CAL_PART_AMT," ).append("\n"); 
		query.append("D.MANU_DT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN B.MNR_PRNR_SEQ IS NOT NULL" ).append("\n"); 
		query.append("THEN MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(B.MNR_PRNR_SEQ, B.MNR_PRNR_CNT_CD)" ).append("\n"); 
		query.append("WHEN B.NIS_PRNR_VNDR_SEQ IS NOT NULL" ).append("\n"); 
		query.append("THEN MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(B.NIS_PRNR_VNDR_SEQ, B.NIS_PRNR_CNT_CD)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'ZZ999999'" ).append("\n"); 
		query.append("END AS CUST_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN B.MNR_PRNR_SEQ IS NOT NULL" ).append("\n"); 
		query.append("THEN C.MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append("WHEN B.NIS_PRNR_VNDR_SEQ IS NOT NULL" ).append("\n"); 
		query.append("THEN B.NIS_PRNR_VNDR_ABBR_NM" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'Anonymous Buyer'" ).append("\n"); 
		query.append("END AS CUST_NM," ).append("\n"); 
		query.append("B.EQ_NO," ).append("\n"); 
		query.append("B.DISP_RSN_CD," ).append("\n"); 
		query.append("B.DISP_UT_PRC," ).append("\n"); 
		query.append("B.DISP_TRF_UT_PRC," ).append("\n"); 
		query.append("D.RPR_COST_AMT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN B.DISP_VRFY_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("THEN B.DISP_VRFY_TP_CD" ).append("\n"); 
		query.append("WHEN B.DISP_RSN_CD != 'C'" ).append("\n"); 
		query.append("THEN 'DA'" ).append("\n"); 
		query.append("WHEN B.DISP_TRF_UT_PRC IS NULL" ).append("\n"); 
		query.append("THEN 'NT'" ).append("\n"); 
		query.append("WHEN B.DISP_UT_PRC >= B.DISP_TRF_UT_PRC" ).append("\n"); 
		query.append("THEN 'SS'" ).append("\n"); 
		query.append("WHEN B.DISP_UT_PRC < B.DISP_TRF_UT_PRC" ).append("\n"); 
		query.append("THEN 'UP'" ).append("\n"); 
		query.append("END AS DISP_VRFY_TP_CD," ).append("\n"); 
		query.append("B.BK_VAL_AMT," ).append("\n"); 
		query.append("B.INV_NO," ).append("\n"); 
		query.append("E.ISS_DT," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(TO_CHAR(B.DISP_SOLD_DT, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(E.ISS_DT, 'YYYYMMDD'), 'YYYYMMDD')) AS OVER_DATE" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR A," ).append("\n"); 
		query.append("MNR_DISP_DTL B," ).append("\n"); 
		query.append("MNR_PARTNER C," ).append("\n"); 
		query.append("MNR_EQ_STS_V D," ).append("\n"); 
		query.append("MNR_RCV_INV_WRK E" ).append("\n"); 
		query.append("WHERE A.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = D.EQ_TYPE" ).append("\n"); 
		query.append("AND B.EQ_NO = D.EQ_NO" ).append("\n"); 
		query.append("AND B.EQ_TPSZ_CD = D.EQ_TPSZ_CD" ).append("\n"); 
		query.append("AND B.MNR_PRNR_CNT_CD = C.MNR_PRNR_CNT_CD(+)" ).append("\n"); 
		query.append("AND B.MNR_PRNR_SEQ = C.MNR_PRNR_SEQ(+)" ).append("\n"); 
		query.append("AND B.DISP_SOLD_DT IS NOT NULL" ).append("\n"); 
		query.append("AND B.INV_NO = E.INV_NO) A," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT A.LOC_CD," ).append("\n"); 
		query.append("A.RGN_CD," ).append("\n"); 
		query.append("A.SCC_CD," ).append("\n"); 
		query.append("A.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("C.LCC_CD," ).append("\n"); 
		query.append("C.ECC_CD," ).append("\n"); 
		query.append("C.RCC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("WHERE A.SCC_CD = C.SCC_CD) B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE SUBSTR(A.DISP_YD_CD, 1, 5) = B.LOC_CD" ).append("\n"); 
		query.append("AND A.DISP_SOLD_DT BETWEEN TO_DATE(@[p_str_evnt_dt], 'YYYY-MM-DD') AND TO_DATE(@[p_end_evnt_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#if (${p_str_cre_dt} != '' && ${p_end_cre_dt} != '')" ).append("\n"); 
		query.append("AND A.CRE_DT BETWEEN TO_DATE(@[p_str_cre_dt], 'YYYY-MM-DD') AND TO_DATE(@[p_end_cre_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_eq_knd_cd} != '' )" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[p_eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '' )" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("'$user_tpszCds'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_tpszCds'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_disp_tp_cd} != '' )" ).append("\n"); 
		query.append("AND A.DISP_TP_CD = @[p_disp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_disp_rsn_cd} != '' )" ).append("\n"); 
		query.append("AND A.DISP_RSN_CD = @[p_disp_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_cust_cd} != '')" ).append("\n"); 
		query.append("AND A.CUST_CD = @[p_cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_loc_cd} != '')" ).append("\n"); 
		query.append("#if (${p_loc_tp} == 'RCC')" ).append("\n"); 
		query.append("AND B.RCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("#elseif (${p_loc_tp} == 'LCC')" ).append("\n"); 
		query.append("AND B.LCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND B.SCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.DISP_NO," ).append("\n"); 
		query.append("A.DISP_DTL_SEQ," ).append("\n"); 
		query.append("A.DISP_SOLD_DT," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.EQ_NO" ).append("\n"); 

	}
}