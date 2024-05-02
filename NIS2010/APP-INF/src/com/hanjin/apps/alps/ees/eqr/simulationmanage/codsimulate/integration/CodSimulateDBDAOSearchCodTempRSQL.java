/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAOSearchCodTempRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.11.13 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOSearchCodTempRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 REPO PLAN ID의 데이터를 EQR_VSL_LDIS_PLN_COD_TMP 테이블에서 조회
	  * </pre>
	  */
	public CodSimulateDBDAOSearchCodTempRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOSearchCodTempRSQL").append("\n"); 
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
		query.append("PLN_YRWK" ).append("\n"); 
		query.append(",CASE WHEN PAST_REPO_PLN_FLG = 'Y'  THEN '1' ELSE '0' END AS PAST_REPO_PLN_FLG" ).append("\n"); 
		query.append(",VSL_LANE_CD LAND_CD" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 
		query.append(",FM_ECC_CD FM_ECC_CD_TMP" ).append("\n"); 
		query.append(",FM_ETD_DT" ).append("\n"); 
		query.append(",FM_YD_CD  FM_YARD" ).append("\n"); 
		query.append(",TO_ECC_CD TO_ECC_CD_TMP" ).append("\n"); 
		query.append(",TO_ETB_DT" ).append("\n"); 
		query.append(",TO_YD_CD  TO_YARD" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrtpszcd.size())" ).append("\n"); 
		query.append("NVL(SUM(DECODE(CNTR_TPSZ_CD ,'$key',CNTR_QTY)),0) +" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("NVL(SUM(DECODE(CNTR_TPSZ_CD ,'$key',CNTR_QTY)),0) TOTAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(",SUM(DECODE(CNTR_TPSZ_CD ,'$key',CNTR_QTY)) ${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",REPO_PLN_ID" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",FM_ECC_CD" ).append("\n"); 
		query.append(",TO_ECC_CD" ).append("\n"); 
		query.append(", FM_ECC_CD  FM_ECC_CD_TMP1" ).append("\n"); 
		query.append(", FM_ETD_DT  FM_ETD_DT1" ).append("\n"); 
		query.append(", TO_ECC_CD  TO_ECC_CD_TMP1" ).append("\n"); 
		query.append(", TO_ETB_DT  TO_ETB_DT1" ).append("\n"); 
		query.append(",'N' fm_ecc_cd_flg" ).append("\n"); 
		query.append(",'N' to_ecc_cd_flg" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(",'N'  ${key}_flag" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(", VSL_LANE_CD||VVD||FM_ECC_CD||'$key'||DECODE(PAST_REPO_PLN_FLG , 'Y' , '1','0')  SUM_CNTP_CODE${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- CSRNO : R200806027055 의거 변경" ).append("\n"); 
		query.append(", PRE_PLN_TS_FLG" ).append("\n"); 
		query.append(", PLN_SEQ" ).append("\n"); 
		query.append(", PLN_SEQ  PLN_SEQ1" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.PLN_YRWK," ).append("\n"); 
		query.append("A.PLN_SEQ," ).append("\n"); 
		query.append("(SELECT DECODE(CO_CD,'H','H','D','S','S','S') CO_CD FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = A.VSL_LANE_CD) CO_CD," ).append("\n"); 
		query.append("A.VSL_LANE_CD," ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("A.FM_ECC_CD," ).append("\n"); 
		query.append("A.TO_ECC_CD," ).append("\n"); 
		query.append("TO_CHAR(A.FM_ETD_DT,'YYYY-MM-DD HH24:MI:SS') FM_ETD_DT," ).append("\n"); 
		query.append("A.FM_YD_CD," ).append("\n"); 
		query.append("TO_CHAR(A.TO_ETB_DT,'YYYY-MM-DD HH24:MI:SS') TO_ETB_DT," ).append("\n"); 
		query.append("A.TO_YD_CD," ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("B.CNTR_QTY," ).append("\n"); 
		query.append("A.REPO_PLN_ID," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD," ).append("\n"); 
		query.append("A.PAST_REPO_PLN_FLG," ).append("\n"); 
		query.append("-- CSRNO : R200806027055 의거 변경" ).append("\n"); 
		query.append("A.PRE_PLN_TS_FLG" ).append("\n"); 
		query.append("FROM EQR_VSL_LDIS_PLN_COD_TMP A" ).append("\n"); 
		query.append(", EQR_VSL_PLN_COD_QTY B" ).append("\n"); 
		query.append(", ( SELECT ecc_cd FROM eqr_ecc_mst WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${fmecccd} != '')" ).append("\n"); 
		query.append("#if (${fmtype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") c" ).append("\n"); 
		query.append(", (SELECT ecc_cd FROM eqr_ecc_mst WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${toecccd} != '')" ).append("\n"); 
		query.append("#if (${totype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'E')" ).append("\n"); 
		query.append("AND ECC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") d" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND TO_CHAR(A.TO_ETB_DT,'YYYYMMDD') BETWEEN" ).append("\n"); 
		query.append("(SELECT WK_ST_DT FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[fm_yrwk] )" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(SELECT WK_END_DT FROM EQR_WK_PRD WHERE PLN_YR || PLN_WK = @[to_yrwk] )" ).append("\n"); 
		query.append("AND fm_ecc_cd = c.ecc_cd AND to_ecc_cd = d.ecc_cd" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = B.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = B.PLN_SEQ" ).append("\n"); 
		query.append("--   AND B.CNTR_TPSZ_CD IN (${arrcntrtpzcd})" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("AND VSL_LANE_CD IN(${lane})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND VSL_CD||SKD_VOY_NO||SKD_DIR_CD IN (${vvd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trade} != '')" ).append("\n"); 
		query.append("AND VSL_LANE_CD IN (SELECT SLAN_CD FROM COA_MON_VVD WHERE TRD_CD IN ( ${trade} ))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${conti} != '')" ).append("\n"); 
		query.append("AND VSL_LANE_CD IN (SELECT SLAN_CD FROM COA_MON_VVD WHERE TRD_CD IN (SELECT TRD_CD FROM MDM_TRADE WHERE FM_CONTI_CD =@[conti]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--		CSRNO : R200806027055의거 변경" ).append("\n"); 
		query.append("GROUP BY PLN_YRWK, CO_CD,  VSL_LANE_CD, VVD, FM_ECC_CD, TO_ECC_CD, FM_ETD_DT, FM_YD_CD,TO_ETB_DT , TO_YD_CD ,REPO_PLN_ID ,VSL_CD ,SKD_VOY_NO ,SKD_DIR_CD , PAST_REPO_PLN_FLG, PRE_PLN_TS_FLG ,PLN_SEQ" ).append("\n"); 
		query.append("ORDER BY PLN_YRWK, CO_CD,  VSL_LANE_CD, VVD" ).append("\n"); 

	}
}