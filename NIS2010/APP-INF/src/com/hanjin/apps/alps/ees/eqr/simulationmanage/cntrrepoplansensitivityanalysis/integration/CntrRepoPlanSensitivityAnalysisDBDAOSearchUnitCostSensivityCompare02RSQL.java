/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchUnitCostSensivityCompare02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.24 채창호
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

public class CntrRepoPlanSensitivityAnalysisDBDAOSearchUnitCostSensivityCompare02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 민감도 비교분석의 단가버젼 데이터 조회
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOSearchUnitCostSensivityCompare02RSQL(){
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
		params.put("sheetcostcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toendprd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchUnitCostSensivityCompare02RSQL").append("\n"); 
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
		query.append("#if(${sheetcostcd} == 'O')" ).append("\n"); 
		query.append(", '' FM_ECC_CD" ).append("\n"); 
		query.append(", ECC_CD TO_ECC_CD" ).append("\n"); 
		query.append("#elseif(${sheetcostcd} == 'F')" ).append("\n"); 
		query.append(", ECC_CD FM_ECC_CD" ).append("\n"); 
		query.append(", '' TO_ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD	 TS" ).append("\n"); 
		query.append(", SUM(ID1_VOL)	  PLN_ID_VOL" ).append("\n"); 
		query.append(", SUM(ID1_COST)  PLN_ID_COST" ).append("\n"); 
		query.append(", SUM(ID2_VOL)	  PLN_ID2_VOL" ).append("\n"); 
		query.append(", SUM(ID2_COST)  PLN_ID2_COST" ).append("\n"); 
		query.append(", SUM(ID1_VOL) - SUM(ID2_VOL)	 DIFF_VOL" ).append("\n"); 
		query.append(", SUM(ID1_COST) - SUM(ID2_COST) DIFF_COST" ).append("\n"); 
		query.append("FROM (SELECT B.PLN_YRWK" ).append("\n"); 
		query.append(", '' LANE" ).append("\n"); 
		query.append(", '' VVD" ).append("\n"); 
		query.append(", B.ECC_CD" ).append("\n"); 
		query.append(", D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", D.CNTR_QTY ID1_VOL" ).append("\n"); 
		query.append(", D.ONF_HIR_COST_AMT ID1_COST" ).append("\n"); 
		query.append(", 0 ID2_VOL" ).append("\n"); 
		query.append(", 0 ID2_COST" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN A" ).append("\n"); 
		query.append(", EQR_ONF_HIR_PLN B" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) C" ).append("\n"); 
		query.append(", EQR_ONF_HIR_PLN_QTY D" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND B.PLN_YRWK = @[sheet1Week]" ).append("\n"); 
		query.append("AND B.ONF_HIR_DIV_CD = @[sheetcostcd]" ).append("\n"); 
		query.append("AND D.CNTR_TPSZ_CD IN (${arrtpszcd})" ).append("\n"); 
		query.append("AND B.REPO_PLN_ID = D.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.PLN_YRWK    = D.PLN_YRWK" ).append("\n"); 
		query.append("AND B.PLN_SEQ     = D.PLN_SEQ" ).append("\n"); 
		query.append("#if(${sheetcostcd} == 'O')" ).append("\n"); 
		query.append("AND B.PLN_YRWK BETWEEN @[tostartprd] AND @[toendprd]" ).append("\n"); 
		query.append("#if (${toecccd} != '')" ).append("\n"); 
		query.append("#if (${totype} == 'R')" ).append("\n"); 
		query.append("AND C.RCC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'L')" ).append("\n"); 
		query.append("AND C.LCC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'E')" ).append("\n"); 
		query.append("AND C.ECC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif(${sheetcostcd} == 'F')" ).append("\n"); 
		query.append("AND B.PLN_YRWK BETWEEN @[fmstartprd] AND @[fmendprd]" ).append("\n"); 
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
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT B.PLN_YRWK" ).append("\n"); 
		query.append(", '' LANE" ).append("\n"); 
		query.append(", '' VVD" ).append("\n"); 
		query.append(", B.ECC_CD" ).append("\n"); 
		query.append(", D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", 0 ID1_VOL" ).append("\n"); 
		query.append(", 0 ID1_COST" ).append("\n"); 
		query.append(", D.CNTR_QTY ID2_VOL" ).append("\n"); 
		query.append(", D.ONF_HIR_COST_AMT ID2_COST" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN A" ).append("\n"); 
		query.append(", EQR_ONF_HIR_PLN B" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) C" ).append("\n"); 
		query.append(", EQR_ONF_HIR_PLN_QTY D" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = @[repo_pln_id2]" ).append("\n"); 
		query.append("AND B.PLN_YRWK = @[sheet1Week]" ).append("\n"); 
		query.append("AND B.ONF_HIR_DIV_CD = @[sheetcostcd]" ).append("\n"); 
		query.append("AND D.CNTR_TPSZ_CD IN (${arrtpszcd})" ).append("\n"); 
		query.append("AND B.REPO_PLN_ID = D.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.PLN_YRWK    = D.PLN_YRWK" ).append("\n"); 
		query.append("AND B.PLN_SEQ     = D.PLN_SEQ" ).append("\n"); 
		query.append("#if(${sheetcostcd} == 'O')" ).append("\n"); 
		query.append("AND B.PLN_YRWK BETWEEN @[tostartprd] AND @[toendprd]" ).append("\n"); 
		query.append("#if (${toecccd} != '')" ).append("\n"); 
		query.append("#if (${totype} == 'R')" ).append("\n"); 
		query.append("AND C.RCC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'L')" ).append("\n"); 
		query.append("AND C.LCC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${totype} == 'E')" ).append("\n"); 
		query.append("AND C.ECC_CD IN (${arrtoecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif(${sheetcostcd} == 'F')" ).append("\n"); 
		query.append("AND B.PLN_YRWK BETWEEN @[fmstartprd] AND @[fmendprd]" ).append("\n"); 
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
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY PLN_YRWK, LANE, VVD, ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY PLN_YRWK, LANE, VVD, ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 

	}
}