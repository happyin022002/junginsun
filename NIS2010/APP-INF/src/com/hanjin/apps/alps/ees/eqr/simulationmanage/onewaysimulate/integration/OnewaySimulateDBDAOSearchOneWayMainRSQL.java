/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnewaySimulateDBDAOSearchOneWayMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.04 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnewaySimulateDBDAOSearchOneWayMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_ONE_WY_OFFR에서 One Way Offer 정보 검색
	  * </pre>
	  */
	public OnewaySimulateDBDAOSearchOneWayMainRSQL(){
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
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.integration").append("\n"); 
		query.append("FileName : OnewaySimulateDBDAOSearchOneWayMainRSQL").append("\n"); 
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
		query.append("A.FCAST_YRWK" ).append("\n"); 
		query.append(", A.FM_ECC_CD" ).append("\n"); 
		query.append(", A.TO_ECC_CD" ).append("\n"); 
		query.append(", A.Division" ).append("\n"); 
		query.append("#foreach( ${key} in ${cntrTpSzList})" ).append("\n"); 
		query.append(", A.PLAN${key.field1}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", A.numm" ).append("\n"); 
		query.append(", @[repo_pln_id] repo_pln_id" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("##-------------------------Forecast VDL 구하기 ----------------------------------------" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append("#foreach( ${key} in ${cntrTpSzList})" ).append("\n"); 
		query.append(", ${key.field1}  PLAN${key.field1}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 'Forecast VOL' Division" ).append("\n"); 
		query.append(", '1' numm" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append("#foreach( ${key} in ${cntrTpSzList})" ).append("\n"); 
		query.append(", SUM(DECODE(CNTR_TPSZ_CD , '${key.field1}', CNTR_VOL_QTY)) ${key.field1}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_VOL_QTY" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY FCAST_YRWK, FM_ECC_CD , TO_ECC_CD , CNTR_TPSZ_CD  ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_OB_FCAST" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
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
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
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
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID =  @[scnr_id]" ).append("\n"); 
		query.append("AND FCAST_YRWK  BETWEEN @[fm_yrwk]  AND @[to_yrwk]" ).append("\n"); 
		query.append("AND fm_ecc_cd = c.ecc_cd" ).append("\n"); 
		query.append("AND to_ecc_cd = d.ecc_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("##--------------------------- O/F offer 구하기 --------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append("#foreach( ${key} in ${cntrTpSzList})" ).append("\n"); 
		query.append(", ${key.field1}  OFFER${key.field1}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 'O/F Offer' Division" ).append("\n"); 
		query.append(", '2' numm" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append("#foreach( ${key} in ${cntrTpSzList})" ).append("\n"); 
		query.append(", MAX(DECODE(CNTR_TPSZ_CD , '${key.field1}', CNTR_QTY) ${key.field1}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_QTY" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY FCAST_YRWK, FM_ECC_CD , TO_ECC_CD , CNTR_TPSZ_CD   ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ONE_WY_OFFR" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
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
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
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
		query.append("WHERE" ).append("\n"); 
		query.append("REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND FCAST_YRWK  BETWEEN @[fm_yrwk]  AND @[to_yrwk]" ).append("\n"); 
		query.append("AND fm_ecc_cd = c.ecc_cd" ).append("\n"); 
		query.append("AND to_ecc_cd = d.ecc_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'1' numm" ).append("\n"); 
		query.append(",  'Forecast VOL' Division" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("UNION all" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'2' numm" ).append("\n"); 
		query.append(",  'O/F Offer' Division" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.numm = B.numm" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS FCAST_YRWK" ).append("\n"); 
		query.append(", '' AS FM_ECC_CD" ).append("\n"); 
		query.append(", '' AS TO_ECC_CD" ).append("\n"); 
		query.append(", A.Division" ).append("\n"); 
		query.append("#foreach( ${key} in ${cntrTpSzList})" ).append("\n"); 
		query.append(", 	CASE WHEN A.NUMM = 1" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("SUM(A.PLAN${key.field1})" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE WHEN ${key.field2} - SUM(A.PLAN${key.field1}) > 0" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("SUM(A.PLAN${key.field1}) + ( ${key.field2} - SUM(A.PLAN${key.field1}))" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("SUM(A.PLAN${key.field1}) + ( ${key.field2} - SUM(A.PLAN${key.field1}))" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END   PLNAD2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", A.numm" ).append("\n"); 
		query.append(", @[repo_pln_id] repo_pln_id" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("##-------------------------Forecast VDL 구하기 ----------------------------------------" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append("#foreach( ${key} in ${cntrTpSzList})" ).append("\n"); 
		query.append(", ${key.field1}  PLAN${key.field1}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 'Forecast VOL' Division" ).append("\n"); 
		query.append(", '1' numm" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(", SUM(DECODE(CNTR_TPSZ_CD , '$key', CNTR_VOL_QTY)) ${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_VOL_QTY" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY FCAST_YRWK, FM_ECC_CD , TO_ECC_CD , CNTR_TPSZ_CD  ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_OB_FCAST" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
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
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
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
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("AND FCAST_YRWK  BETWEEN @[fm_yrwk]  AND @[to_yrwk]" ).append("\n"); 
		query.append("AND fm_ecc_cd = c.ecc_cd" ).append("\n"); 
		query.append("AND to_ecc_cd = d.ecc_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("##--------------------------- O/F offer 구하기 --------------------------------------------------------------------------" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append("#foreach( ${key} in ${cntrTpSzList})" ).append("\n"); 
		query.append(", ROUND(${key.field1}/DECODE(${key.field1}SUM,0,1,D2SUM) * ${key.field2},0)  OFFER${key.field1}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 'O/F Offer' Division" ).append("\n"); 
		query.append(", '2' numm" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(", SUM(DECODE(CNTR_TPSZ_CD , '$key', CNTR_VOL_QTY)) ${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM(DECODE(CNTR_TPSZ_CD , '$key', CNTR_VOL_QTY))" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_OB_FCAST" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
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
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
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
		query.append("WHERE" ).append("\n"); 
		query.append("SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("AND FCAST_YRWK  BETWEEN  @[fm_yrwk] AND @[to_yrwk]" ).append("\n"); 
		query.append("AND fm_ecc_cd = c.ecc_cd" ).append("\n"); 
		query.append("AND to_ecc_cd = d.ecc_cd" ).append("\n"); 
		query.append(") ${key}SUM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_QTY" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY FCAST_YRWK, FM_ECC_CD , TO_ECC_CD , CNTR_TPSZ_CD  ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ONE_WY_OFFR" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
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
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ecc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("eqr_ecc_mst" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1 = 1" ).append("\n"); 
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
		query.append("WHERE" ).append("\n"); 
		query.append("REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND FCAST_YRWK  BETWEEN @[fm_yrwk]  AND @[to_yrwk]" ).append("\n"); 
		query.append("AND fm_ecc_cd = c.ecc_cd" ).append("\n"); 
		query.append("AND to_ecc_cd = d.ecc_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'1' numm" ).append("\n"); 
		query.append(",  'Forecast VOL' Division" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("UNION all" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'2' numm" ).append("\n"); 
		query.append(",  'O/F Offer' Division" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.numm = B.numm" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.Division" ).append("\n"); 
		query.append(", A.numm" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("1" ).append("\n"); 
		query.append(",2" ).append("\n"); 
		query.append(",3" ).append("\n"); 
		query.append(",numm" ).append("\n"); 
		query.append(",FCAST_DT" ).append("\n"); 

	}
}