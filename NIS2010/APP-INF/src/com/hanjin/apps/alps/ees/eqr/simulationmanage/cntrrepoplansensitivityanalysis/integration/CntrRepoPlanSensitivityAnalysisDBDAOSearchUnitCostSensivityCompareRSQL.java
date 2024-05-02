/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchUnitCostSensivityCompareRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.11.18 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanSensitivityAnalysisDBDAOSearchUnitCostSensivityCompareRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 민감도 비교분석의 단가버젼 데이터 조회
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOSearchUnitCostSensivityCompareRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmstartprd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet1Week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmendprd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tostartprd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toendprd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchUnitCostSensivityCompareRSQL").append("\n"); 
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
		query.append("SELECT	SUBSTR(PLN_YRWK,1,4) || '-' || SUBSTR(PLN_YRWK,5,2) WEEK" ).append("\n"); 
		query.append(", LANE" ).append("\n"); 
		query.append(", VVD" ).append("\n"); 
		query.append("#if(${sheetcostcd} == 'L')" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append("#elseif(${sheetcostcd} == 'D')" ).append("\n"); 
		query.append(", '' FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD  TS" ).append("\n"); 
		query.append(", SUM(ID1_VOL)   PLN_ID_VOL" ).append("\n"); 
		query.append(", SUM(ID1_COST)  PLN_ID_COST" ).append("\n"); 
		query.append(", SUM(ID2_VOL)   PLN_ID2_VOL" ).append("\n"); 
		query.append(", SUM(ID2_COST)  PLN_ID2_COST" ).append("\n"); 
		query.append(", SUM(ID1_VOL) - SUM(ID2_VOL)    DIFF_VOL" ).append("\n"); 
		query.append(", SUM(ID1_COST) - SUM(ID2_COST)  DIFF_COST" ).append("\n"); 
		query.append("FROM (SELECT REPO_PLN_ID" ).append("\n"); 
		query.append(", PLN_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", FM_DT" ).append("\n"); 
		query.append(", FM_WK" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(", TO_DT" ).append("\n"); 
		query.append(", TO_WK" ).append("\n"); 
		query.append(", LANE, VVD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_QTY ID1_VOL" ).append("\n"); 
		query.append(", LODG_DCHG_COST_AMT ID1_COST" ).append("\n"); 
		query.append(", 0 ID2_VOL" ).append("\n"); 
		query.append(", 0 ID2_COST" ).append("\n"); 
		query.append("FROM (SELECT A.REPO_PLN_ID" ).append("\n"); 
		query.append(", B.PLN_YRWK" ).append("\n"); 
		query.append(", B.FM_ECC_CD" ).append("\n"); 
		query.append(", B.FM_ETD_DT" ).append("\n"); 
		query.append(", TO_CHAR(B.FM_ETD_DT, 'YYYYMMDD') FM_DT" ).append("\n"); 
		query.append(", B.TO_ECC_CD" ).append("\n"); 
		query.append(", B.TO_ETB_DT" ).append("\n"); 
		query.append(", TO_CHAR(B.TO_ETB_DT, 'YYYYMMDD') TO_DT" ).append("\n"); 
		query.append(", B.VSL_LANE_CD LANE" ).append("\n"); 
		query.append(", B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(", E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", E.CNTR_QTY" ).append("\n"); 
		query.append(", E.LODG_DCHG_COST_AMT" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN A" ).append("\n"); 
		query.append(", EQR_VSL_LODG_DCHG_PLN B" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) C" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) D" ).append("\n"); 
		query.append(", EQR_VSL_LODG_DCHG_PLN_QTY E" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.FM_ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND B.TO_ECC_CD = D.ECC_CD" ).append("\n"); 
		query.append("AND B.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND B.PLN_YRWK = @[sheet1Week]" ).append("\n"); 
		query.append("AND E.CNTR_TPSZ_CD IN (${arrtpszcd})" ).append("\n"); 
		query.append("AND B.REPO_PLN_ID = E.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.PLN_YRWK    = E.PLN_YRWK" ).append("\n"); 
		query.append("AND B.PLN_SEQ     = E.PLN_SEQ" ).append("\n"); 
		query.append("#if (${fmecccd} != '')" ).append("\n"); 
		query.append("#if (${fmtype} == 'R')" ).append("\n"); 
		query.append("AND C.RCC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'L')" ).append("\n"); 
		query.append("AND C.LCC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'E')" ).append("\n"); 
		query.append("AND C.ECC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${toecccd} != '')" ).append("\n"); 
		query.append("#if (${totype} == 'R')" ).append("\n"); 
		query.append("AND D.RCC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'L')" ).append("\n"); 
		query.append("AND D.LCC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'E')" ).append("\n"); 
		query.append("AND D.ECC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") L" ).append("\n"); 
		query.append(", (SELECT PLN_YR || PLN_WK FM_WK, WK_ST_DT, WK_END_DT FROM EQR_WK_PRD) M" ).append("\n"); 
		query.append(", (SELECT PLN_YR || PLN_WK TO_WK, WK_ST_DT, WK_END_DT FROM EQR_WK_PRD) N" ).append("\n"); 
		query.append("WHERE L.FM_DT BETWEEN M.WK_ST_DT AND M.WK_END_DT" ).append("\n"); 
		query.append("AND L.TO_DT BETWEEN N.WK_ST_DT AND N.WK_END_DT" ).append("\n"); 
		query.append("#if(${sheetcostcd} != 'D' || ${fmtype} != '' ||  ${totype} != '' )" ).append("\n"); 
		query.append("AND M.FM_WK BETWEEN @[fmstartprd] AND @[fmendprd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sheetcostcd} != 'L' || ${fmtype} != '' ||  ${totype} != '' )" ).append("\n"); 
		query.append("AND N.TO_WK BETWEEN @[tostartprd] AND @[toendprd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT REPO_PLN_ID" ).append("\n"); 
		query.append(", PLN_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", FM_DT" ).append("\n"); 
		query.append(", FM_WK" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(", TO_DT" ).append("\n"); 
		query.append(", TO_WK" ).append("\n"); 
		query.append(", LANE" ).append("\n"); 
		query.append(", VVD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", 0 ID1_VOL" ).append("\n"); 
		query.append(", 0 ID1_COST" ).append("\n"); 
		query.append(", CNTR_QTY ID2_VOL" ).append("\n"); 
		query.append(", LODG_DCHG_COST_AMT ID2_COST" ).append("\n"); 
		query.append("FROM (SELECT A.REPO_PLN_ID" ).append("\n"); 
		query.append(", B.PLN_YRWK" ).append("\n"); 
		query.append(", B.FM_ECC_CD" ).append("\n"); 
		query.append(", B.FM_ETD_DT" ).append("\n"); 
		query.append(", TO_CHAR(B.FM_ETD_DT, 'YYYYMMDD') FM_DT" ).append("\n"); 
		query.append(", B.TO_ECC_CD" ).append("\n"); 
		query.append(", B.TO_ETB_DT" ).append("\n"); 
		query.append(", TO_CHAR(B.TO_ETB_DT, 'YYYYMMDD') TO_DT" ).append("\n"); 
		query.append(", B.VSL_LANE_CD LANE" ).append("\n"); 
		query.append(", B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(", E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", E.CNTR_QTY" ).append("\n"); 
		query.append(", E.LODG_DCHG_COST_AMT" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN A" ).append("\n"); 
		query.append(", EQR_VSL_LODG_DCHG_PLN B" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) C" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) D" ).append("\n"); 
		query.append(", EQR_VSL_LODG_DCHG_PLN_QTY E" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.FM_ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND B.TO_ECC_CD = D.ECC_CD" ).append("\n"); 
		query.append("AND B.REPO_PLN_ID = @[repo_pln_id2]" ).append("\n"); 
		query.append("AND B.PLN_YRWK = @[sheet1Week]" ).append("\n"); 
		query.append("AND E.CNTR_TPSZ_CD IN (${arrtpszcd})" ).append("\n"); 
		query.append("AND B.REPO_PLN_ID = E.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.PLN_YRWK    = E.PLN_YRWK" ).append("\n"); 
		query.append("AND B.PLN_SEQ     = E.PLN_SEQ" ).append("\n"); 
		query.append("#if (${fmecccd} != '')" ).append("\n"); 
		query.append("#if (${fmtype} == 'R')" ).append("\n"); 
		query.append("AND C.RCC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'L')" ).append("\n"); 
		query.append("AND C.LCC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'E')" ).append("\n"); 
		query.append("AND C.ECC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${toecccd} != '')" ).append("\n"); 
		query.append("#if (${totype} == 'R')" ).append("\n"); 
		query.append("AND D.RCC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'L')" ).append("\n"); 
		query.append("AND D.LCC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'E')" ).append("\n"); 
		query.append("AND D.ECC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") L" ).append("\n"); 
		query.append(", (SELECT PLN_YR || PLN_WK FM_WK, WK_ST_DT, WK_END_DT FROM EQR_WK_PRD) M" ).append("\n"); 
		query.append(", (SELECT PLN_YR || PLN_WK TO_WK, WK_ST_DT, WK_END_DT FROM EQR_WK_PRD) N" ).append("\n"); 
		query.append("WHERE L.FM_DT BETWEEN M.WK_ST_DT AND M.WK_END_DT" ).append("\n"); 
		query.append("AND L.TO_DT BETWEEN N.WK_ST_DT AND N.WK_END_DT" ).append("\n"); 
		query.append("#if(${sheetcostcd} != 'D' || ${fmtype} != '' ||  ${totype} != '' )" ).append("\n"); 
		query.append("AND M.FM_WK BETWEEN @[fmstartprd] AND @[fmendprd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sheetcostcd} != 'L' || ${fmtype} != '' ||  ${totype} != '' )" ).append("\n"); 
		query.append("AND N.TO_WK BETWEEN @[tostartprd] AND @[toendprd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if(${sheetcostcd} == 'L')" ).append("\n"); 
		query.append("GROUP BY PLN_YRWK, LANE, VVD, FM_ECC_CD,TO_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY PLN_YRWK, LANE, VVD, FM_ECC_CD,TO_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#elseif(${sheetcostcd} == 'D')" ).append("\n"); 
		query.append("GROUP BY PLN_YRWK, LANE, VVD, TO_ECC_CD,TO_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY PLN_YRWK, LANE, VVD, TO_ECC_CD,TO_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}