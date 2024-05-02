/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchYearSubleaseDetailPlanMonthlyRSQL.java
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

public class ScenarioDefaultManageDBDAOSearchYearSubleaseDetailPlanMonthlyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_sublease + eqr_slse_perf 테이블 데이터 조회(Monthly)
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchYearSubleaseDetailPlanMonthlyRSQL(){
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
		query.append("FileName : ScenarioDefaultManageDBDAOSearchYearSubleaseDetailPlanMonthlyRSQL").append("\n"); 
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
		query.append("E.FM_RCC_CD S2_FM_RCC_CD," ).append("\n"); 
		query.append("E.FM_ECC_CD S2_FM_ECC_CD," ).append("\n"); 
		query.append("E.TO_ECC_CD S2_TO_ECC_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("TO_CHAR(NVL(ROUND(MAX(SLSE_RTO),2),0), '990.99')||'%' S2_DMST_RTO," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 01, CNTR_VOL_QTY)) S2_1_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 02, CNTR_VOL_QTY)) S2_2_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 03, CNTR_VOL_QTY)) S2_3_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 04, CNTR_VOL_QTY)) S2_4_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 05, CNTR_VOL_QTY)) S2_5_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 06, CNTR_VOL_QTY)) S2_6_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 07, CNTR_VOL_QTY)) S2_7_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 08, CNTR_VOL_QTY)) S2_8_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 09, CNTR_VOL_QTY)) S2_9_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 10, CNTR_VOL_QTY)) S2_10_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 11, CNTR_VOL_QTY)) S2_11_CNTR_VOL_QTY," ).append("\n"); 
		query.append("SUM (DECODE (PLN_MON, 12, CNTR_VOL_QTY)) S2_12_CNTR_VOL_QTY" ).append("\n"); 
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
		query.append("FROM EQR_ECC_MST WHERE A.FM_ECC_CD = ECC_CD" ).append("\n"); 
		query.append(") FM_ECC_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
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
		query.append("FROM EQR_ECC_MST WHERE A.TO_ECC_CD = ECC_CD" ).append("\n"); 
		query.append(") TO_ECC_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT RCC_CD FROM EQR_ECC_MST WHERE A.FM_ECC_CD = ECC_CD" ).append("\n"); 
		query.append(") FM_RCC_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("MIN(PLN_MON)PLN_MON," ).append("\n"); 
		query.append("PLN_YRWK," ).append("\n"); 
		query.append("MAX(CNTR_VOL_QTY)CNTR_VOL_QTY," ).append("\n"); 
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
		query.append("GROUP BY A.FM_ECC_CD, A.TO_ECC_CD, A.CNTR_TPSZ_CD, PLN_YRWK, SLSE_RTO" ).append("\n"); 
		query.append(") E" ).append("\n"); 
		query.append("GROUP BY E.FM_RCC_CD, E.FM_ECC_CD, E.TO_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY E.FM_RCC_CD, E.FM_ECC_CD, E.TO_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 

	}
}