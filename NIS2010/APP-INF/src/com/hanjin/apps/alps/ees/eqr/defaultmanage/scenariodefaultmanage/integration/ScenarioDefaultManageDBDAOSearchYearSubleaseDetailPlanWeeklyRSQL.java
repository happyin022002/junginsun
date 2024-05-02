/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchYearSubleaseDetailPlanWeeklyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchYearSubleaseDetailPlanWeeklyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_sublease + eqr_slse_perf 테이블 데이터 조회(Weekly)
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchYearSubleaseDetailPlanWeeklyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plnyr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchYearSubleaseDetailPlanWeeklyRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("E.FM_RCC_CD S3_FM_RCC_CD," ).append("\n"); 
		query.append("E.FM_ECC_CD S3_FM_ECC_CD," ).append("\n"); 
		query.append("E.TO_ECC_CD S3_TO_ECC_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD S3_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("TO_CHAR(NVL(ROUND(MAX(SLSE_RTO),2),0), '990.99')||'%' S3_DMST_RTO," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 1, CNTR_VOL_QTY)) S3_1_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 2, CNTR_VOL_QTY)) S3_2_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 3, CNTR_VOL_QTY)) S3_3_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 4, CNTR_VOL_QTY)) S3_4_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 5, CNTR_VOL_QTY)) S3_5_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 6, CNTR_VOL_QTY)) S3_6_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 7, CNTR_VOL_QTY)) S3_7_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 8, CNTR_VOL_QTY)) S3_8_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 9, CNTR_VOL_QTY)) S3_9_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 10, CNTR_VOL_QTY)) S3_10_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 11, CNTR_VOL_QTY)) S3_11_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 12, CNTR_VOL_QTY)) S3_12_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 13, CNTR_VOL_QTY)) S3_13_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 14, CNTR_VOL_QTY)) S3_14_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 15, CNTR_VOL_QTY)) S3_15_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 16, CNTR_VOL_QTY)) S3_16_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 17, CNTR_VOL_QTY)) S3_17_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 18, CNTR_VOL_QTY)) S3_18_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 19, CNTR_VOL_QTY)) S3_19_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 20, CNTR_VOL_QTY)) S3_20_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 21, CNTR_VOL_QTY)) S3_21_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 22, CNTR_VOL_QTY)) S3_22_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 23, CNTR_VOL_QTY)) S3_23_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 24, CNTR_VOL_QTY)) S3_24_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 25, CNTR_VOL_QTY)) S3_25_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 26, CNTR_VOL_QTY)) S3_26_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 27, CNTR_VOL_QTY)) S3_27_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 28, CNTR_VOL_QTY)) S3_28_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 29, CNTR_VOL_QTY)) S3_29_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 30, CNTR_VOL_QTY)) S3_30_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 31, CNTR_VOL_QTY)) S3_31_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 32, CNTR_VOL_QTY)) S3_32_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 33, CNTR_VOL_QTY)) S3_33_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 34, CNTR_VOL_QTY)) S3_34_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 35, CNTR_VOL_QTY)) S3_35_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 36, CNTR_VOL_QTY)) S3_36_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 37, CNTR_VOL_QTY)) S3_37_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 38, CNTR_VOL_QTY)) S3_38_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 39, CNTR_VOL_QTY)) S3_39_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 40, CNTR_VOL_QTY)) S3_40_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 41, CNTR_VOL_QTY)) S3_41_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 42, CNTR_VOL_QTY)) S3_42_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 43, CNTR_VOL_QTY)) S3_43_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 44, CNTR_VOL_QTY)) S3_44_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 45, CNTR_VOL_QTY)) S3_45_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 46, CNTR_VOL_QTY)) S3_46_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 47, CNTR_VOL_QTY)) S3_47_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 48, CNTR_VOL_QTY)) S3_48_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 49, CNTR_VOL_QTY)) S3_49_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 50, CNTR_VOL_QTY)) S3_50_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 51, CNTR_VOL_QTY)) S3_51_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 52, CNTR_VOL_QTY)) S3_52_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM(DECODE(E.WEEK, 53, CNTR_VOL_QTY)) S3_53_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX(SUBSTR(PLN_YRWK,1,4)) S3_PLN_YR," ).append("\n"); 
		query.append("E.TIMEGAP" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${fm_to_at} == '1')" ).append("\n"); 
		query.append("#if (${fm_type_by} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${fm_type_by} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${fm_type_by} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${at_type_by} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${at_type_by} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${at_type_by} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE A.FM_ECC_CD = ECC_CD" ).append("\n"); 
		query.append(") FM_ECC_CD," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("#if (${fm_to_at} == '1')" ).append("\n"); 
		query.append("#if (${to_type_by} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${to_type_by} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${to_type_by} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${at_type_by} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${at_type_by} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${at_type_by} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE A.TO_ECC_CD = ECC_CD" ).append("\n"); 
		query.append(") TO_ECC_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT RCC_CD" ).append("\n"); 
		query.append("FROM EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE A.FM_ECC_CD = ECC_CD" ).append("\n"); 
		query.append(") FM_RCC_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("MAX(CNTR_VOL_QTY)CNTR_VOL_QTY," ).append("\n"); 
		query.append("PLN_YRWK," ).append("\n"); 
		query.append("(TO_NUMBER(SUBSTR(PLN_YRWK,5,2)))WEEK," ).append("\n"); 
		query.append("DECODE(A.CRE_DT, A.UPD_DT, 'N', 'Y')TIMEGAP," ).append("\n"); 
		query.append("SLSE_RTO" ).append("\n"); 
		query.append("FROM EQR_SUBLEASE A, EQR_WK_PRD B," ).append("\n"); 
		query.append("#if (${fm_to_at} == '1')" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if ($arrFmEccCd.size() > 0)" ).append("\n"); 
		query.append("#if (${fm_type} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${fm_type} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#elseif (${fm_type} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrFmEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrFmEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) C," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") C," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if ($arrToEccCd.size() > 0)" ).append("\n"); 
		query.append("#if (${to_type} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${to_type} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#elseif (${to_type} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrToEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrToEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) D," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") D," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${at_type} != '' && $arrAtEccCd.size() > 0)" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${at_type} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${at_type} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#elseif (${at_type} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrAtEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrAtEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) C," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("EQR_SLSE_PERF E" ).append("\n"); 
		query.append("WHERE A.PLN_YRWK = B.PLN_YR || B.PLN_WK" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = E.FM_ECC_CD(+)" ).append("\n"); 
		query.append("AND A.TO_ECC_CD = E.TO_ECC_CD(+)" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("#if (${fm_to_at} == '1')" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = C.ECC_CD AND A.TO_ECC_CD = D.ECC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${at_type} != '' && $arrAtEccCd.size() > 0)" ).append("\n"); 
		query.append("AND (A.FM_ECC_CD = C.ECC_CD OR A.TO_ECC_CD = C.ECC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SUBSTR (A.PLN_YRWK, 1, 4) = @[plnyr]" ).append("\n"); 
		query.append("#if ($arrTpszcd.size() > 0)" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrTpszcd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrTpszcd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.FM_ECC_CD, A.TO_ECC_CD, A.CNTR_TPSZ_CD, PLN_YRWK,A.CRE_DT, A.UPD_DT, SLSE_RTO" ).append("\n"); 
		query.append(") E" ).append("\n"); 
		query.append("GROUP BY E.FM_RCC_CD, E.FM_ECC_CD, E.TO_ECC_CD, CNTR_TPSZ_CD, E.TIMEGAP" ).append("\n"); 
		query.append("ORDER BY E.FM_RCC_CD, E.FM_ECC_CD, E.TO_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 

	}
}