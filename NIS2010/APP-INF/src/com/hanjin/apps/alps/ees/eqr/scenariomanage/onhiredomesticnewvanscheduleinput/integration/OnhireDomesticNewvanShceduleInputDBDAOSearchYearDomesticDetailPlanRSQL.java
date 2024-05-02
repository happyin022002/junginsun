/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanShceduleInputDBDAOSearchYearDomesticDetailPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireDomesticNewvanShceduleInputDBDAOSearchYearDomesticDetailPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_scnr_dmst + eqr_dmst_perf 테이블의 데이터 조회
	  * </pre>
	  */
	public OnhireDomesticNewvanShceduleInputDBDAOSearchYearDomesticDetailPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmPlnYrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toPlnYrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration").append("\n"); 
		query.append("FileName : OnhireDomesticNewvanShceduleInputDBDAOSearchYearDomesticDetailPlanRSQL").append("\n"); 
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
		query.append("E.FM_ECC_CD," ).append("\n"); 
		query.append("E.TO_ECC_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("TO_CHAR(NVL(ROUND(SUM(DMST_RTO)/16,2),0),'990.99')||'%' DMST_RTO," ).append("\n"); 
		query.append("#foreach( $key in ${arr})" ).append("\n"); 
		query.append("SUM (DECODE (PLN_YRWK, '$key', CNTR_VOL_QTY)) AS S2_${key}_CNTR_VOL_QTY," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("MAX (SCNR_ID) SCNR_ID," ).append("\n"); 
		query.append("MAX(TIMEGAP) TIMEGAP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("#if (${fmtypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${fmtypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${fmtypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${attypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${attypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${attypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE A.FM_ECC_CD = ECC_CD" ).append("\n"); 
		query.append(") FM_ECC_CD," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("#if (${totypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${totypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${totypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${attypeby} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${attypeby} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${attypeby} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE A.TO_ECC_CD = ECC_CD" ).append("\n"); 
		query.append(") TO_ECC_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("PLN_MON," ).append("\n"); 
		query.append("MAX(CNTR_VOL_QTY)CNTR_VOL_QTY," ).append("\n"); 
		query.append("DMST_RTO," ).append("\n"); 
		query.append("A.PLN_YRWK ," ).append("\n"); 
		query.append("A.SCNR_ID," ).append("\n"); 
		query.append("DECODE(A.CRE_DT, A.UPD_DT, 'N', 'Y') TIMEGAP" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_DMST A," ).append("\n"); 
		query.append("EQR_WK_PRD B," ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if ($arrFmEccCd.size() > 0)" ).append("\n"); 
		query.append("#if (${fmtype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${fmtype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#elseif (${fmtype} == 'E')" ).append("\n"); 
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
		query.append("#if (${totype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${totype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#elseif (${totype} == 'E')" ).append("\n"); 
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
		query.append("#if (${attype} != '' && $arrAtEccCd.size() > 0)" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${attype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${attype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#elseif (${attype} == 'E')" ).append("\n"); 
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
		query.append("EQR_DMST_PERF E" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.PLN_YRWK = B.PLN_YR || B.PLN_WK" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = E.FM_ECC_CD(+)" ).append("\n"); 
		query.append("AND A.TO_ECC_CD = E.TO_ECC_CD(+)" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("#if (${fmtoat} == '1')" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = C.ECC_CD AND A.TO_ECC_CD = D.ECC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${attype} != '' && $arrAtEccCd.size() > 0)" ).append("\n"); 
		query.append("AND (A.FM_ECC_CD = C.ECC_CD OR A.TO_ECC_CD = C.ECC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.PLN_YRWK BETWEEN @[fmPlnYrwk] AND @[toPlnYrwk]" ).append("\n"); 
		query.append("AND A.SCNR_ID = @[scnr_id]" ).append("\n"); 
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
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.FM_ECC_CD," ).append("\n"); 
		query.append("A.TO_ECC_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("PLN_MON," ).append("\n"); 
		query.append("PLN_YRWK," ).append("\n"); 
		query.append("DMST_RTO," ).append("\n"); 
		query.append("A.SCNR_ID," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append(") E" ).append("\n"); 
		query.append("GROUP BY E.FM_ECC_CD, E.TO_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY E.FM_ECC_CD, E.TO_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 

	}
}