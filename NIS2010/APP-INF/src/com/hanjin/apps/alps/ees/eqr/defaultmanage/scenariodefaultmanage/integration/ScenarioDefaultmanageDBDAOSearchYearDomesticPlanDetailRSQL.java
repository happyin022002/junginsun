/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultmanageDBDAOSearchYearDomesticPlanDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.11.17 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultmanageDBDAOSearchYearDomesticPlanDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchYearDomesticPlanDetail
	  * </pre>
	  */
	public ScenarioDefaultmanageDBDAOSearchYearDomesticPlanDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultmanageDBDAOSearchYearDomesticPlanDetailRSQL").append("\n"); 
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
		query.append("#if (${monthweek} == '1')" ).append("\n"); 
		query.append("SELECT 	    E.FM_ECC_CD   FM_ECC_CD" ).append("\n"); 
		query.append(", E.TO_ECC_CD   TO_ECC_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD  CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", TO_CHAR(NVL(ROUND(MAX(DMST_RTO),2),0), '990.99')||'%' S2_DMST_RTO" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 01, CNTR_VOL_QTY)) S2_1_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 02, CNTR_VOL_QTY)) S2_2_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 03, CNTR_VOL_QTY)) S2_3_CNTR_VOL_QTY" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 04, CNTR_VOL_QTY)) S2_4_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 05, CNTR_VOL_QTY)) S2_5_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 06, CNTR_VOL_QTY)) S2_6_CNTR_VOL_QTY" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 07, CNTR_VOL_QTY)) S2_7_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 08, CNTR_VOL_QTY)) S2_8_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 09, CNTR_VOL_QTY)) S2_9_CNTR_VOL_QTY" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 10, CNTR_VOL_QTY)) S2_10_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 11, CNTR_VOL_QTY)) S2_11_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 12, CNTR_VOL_QTY)) S2_12_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", '2' FLAG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(		SELECT" ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("#if (${fmtypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtypeby} == 'E' || ${fmtypeby} == '' )" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${attypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'E' || ${attypeby} == '')" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM EQR_ECC_MST WHERE A.FM_ECC_CD = ECC_CD) FM_ECC_CD" ).append("\n"); 
		query.append(", (	SELECT" ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("#if (${totypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totypeby} == 'E' || ${totypeby} == '' )" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${attypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'E' || ${attypeby} == '')" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM EQR_ECC_MST WHERE A.TO_ECC_CD = ECC_CD) TO_ECC_CD" ).append("\n"); 
		query.append(", (SELECT RCC_CD FROM EQR_ECC_MST WHERE A.FM_ECC_CD = ECC_CD) FM_RCC_CD" ).append("\n"); 
		query.append(",  A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",  MIN(PLN_MON)PLN_MON" ).append("\n"); 
		query.append(",  PLN_YRWK" ).append("\n"); 
		query.append(",  MAX(CNTR_VOL_QTY) CNTR_VOL_QTY" ).append("\n"); 
		query.append(",  DMST_RTO" ).append("\n"); 
		query.append("FROM EQR_DMST_PLN A, EQR_WK_PRD B," ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${fmecccd} != '')" ).append("\n"); 
		query.append("#if (${fmtype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrfmecccd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrfmecccd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) C ," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") C," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${attype} != '')" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${attype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attype} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arratecccd})" ).append("\n"); 
		query.append("#if($velocityCount < $arratecccd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) C," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${toecccd} != '')" ).append("\n"); 
		query.append("#if (${totype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtoecccd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrtoecccd.size())" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("EQR_DMST_PERF E" ).append("\n"); 
		query.append("WHERE 		A.PLN_YRWK = B.PLN_YR || B.PLN_WK" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = E.FM_ECC_CD(+)" ).append("\n"); 
		query.append("AND A.TO_ECC_CD = E.TO_ECC_CD(+)" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = C.ECC_CD AND A.TO_ECC_CD = D.ECC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${attype} != '')" ).append("\n"); 
		query.append("AND (A.FM_ECC_CD = C.ECC_CD OR A.TO_ECC_CD = C.ECC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SUBSTR (A.PLN_YRWK, 1, 4) = @[pln_yrwk]" ).append("\n"); 
		query.append("#if (${cntrtpszcd} != '')" ).append("\n"); 
		query.append("AND a.cntr_tpsz_cd IN(" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrcntrtpszcd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrcntrtpszcd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.FM_ECC_CD, A.TO_ECC_CD, A.CNTR_TPSZ_CD, PLN_YRWK, DMST_RTO" ).append("\n"); 
		query.append(") E" ).append("\n"); 
		query.append("GROUP BY E.FM_ECC_CD, E.TO_ECC_CD, E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY E.FM_ECC_CD, E.TO_ECC_CD, E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT 	  E.FM_ECC_CD  S3_FM_ECC_CD" ).append("\n"); 
		query.append(", E.TO_ECC_CD  S3_TO_ECC_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD  S3_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", TO_CHAR(NVL(ROUND(MAX(DMST_RTO),2),0), '990.99')||'%' S3_DMST_RTO" ).append("\n"); 
		query.append("#foreach( $key in ${week})" ).append("\n"); 
		query.append(", SUM(DECODE(E.WEEK, '$key', CNTR_VOL_QTY)) S3_${key}_CNTR_VOL_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", MAX(SUBSTR(PLN_YRWK,1,4)) PLN_YRWK" ).append("\n"); 
		query.append(", MAX (E.TIMEGAP) TIMEGAP" ).append("\n"); 
		query.append(", '3' FLAG" ).append("\n"); 
		query.append("FROM (SELECT" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("#if (${fmtypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtypeby} == 'E' || ${fmtypeby} == '' )" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${attypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'E' || ${attypeby} == '')" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM EQR_ECC_MST WHERE A.FM_ECC_CD = ECC_CD) FM_ECC_CD" ).append("\n"); 
		query.append(",(SELECT" ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("#if (${totypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totypeby} == 'E' || ${totypeby} == '' )" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${attypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attypeby} == 'E' || ${attypeby} == '')" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM EQR_ECC_MST WHERE A.TO_ECC_CD = ECC_CD) TO_ECC_CD" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", MAX(CNTR_VOL_QTY)CNTR_VOL_QTY" ).append("\n"); 
		query.append(",PLN_YRWK" ).append("\n"); 
		query.append(",(TO_NUMBER(SUBSTR(PLN_YRWK,5,2)))WEEK" ).append("\n"); 
		query.append(", DECODE(A.CRE_DT, A.UPD_DT, 'N', 'Y')TIMEGAP" ).append("\n"); 
		query.append(", DMST_RTO" ).append("\n"); 
		query.append("FROM EQR_DMST_PLN A, EQR_WK_PRD B," ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${fmecccd} != '')" ).append("\n"); 
		query.append("#if (${fmtype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrfmecccd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrfmecccd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) C ," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") C," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${attype} != '')" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${attype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attype} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arratecccd})" ).append("\n"); 
		query.append("#if($velocityCount < $arratecccd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) C," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${toecccd} != '')" ).append("\n"); 
		query.append("#if (${totype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD	IN (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtoecccd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrtoecccd.size())" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("EQR_DMST_PERF E" ).append("\n"); 
		query.append("WHERE A.PLN_YRWK = B.PLN_YR || B.PLN_WK" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = E.FM_ECC_CD(+)" ).append("\n"); 
		query.append("AND A.TO_ECC_CD = E.TO_ECC_CD(+)" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = C.ECC_CD AND A.TO_ECC_CD = D.ECC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${attype} != '')" ).append("\n"); 
		query.append("AND (A.FM_ECC_CD = C.ECC_CD OR A.TO_ECC_CD = C.ECC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SUBSTR (A.PLN_YRWK, 1, 4) = @[pln_yrwk]" ).append("\n"); 
		query.append("#if (${cntrtpszcd} != '')" ).append("\n"); 
		query.append("AND a.cntr_tpsz_cd IN(" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrcntrtpszcd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrcntrtpszcd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.FM_ECC_CD, A.TO_ECC_CD, A.CNTR_TPSZ_CD, PLN_YRWK, A.CRE_DT, A.UPD_DT, DMST_RTO" ).append("\n"); 
		query.append(") E" ).append("\n"); 
		query.append("GROUP BY E.FM_ECC_CD, E.TO_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY E.FM_ECC_CD, E.TO_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}