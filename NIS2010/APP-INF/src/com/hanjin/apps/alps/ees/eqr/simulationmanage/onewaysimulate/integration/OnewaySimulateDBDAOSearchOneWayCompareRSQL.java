/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnewaySimulateDBDAOSearchOneWayCompareRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.09 정은호
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

public class OnewaySimulateDBDAOSearchOneWayCompareRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PLAN ID별 실적에 대한 비교 조회 데이터
	  * </pre>
	  */
	public OnewaySimulateDBDAOSearchOneWayCompareRSQL(){
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
		params.put("to_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.integration").append("\n"); 
		query.append("FileName : OnewaySimulateDBDAOSearchOneWayCompareRSQL").append("\n"); 
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
		query.append("PLN_YRWK AS FCAST_YRWK" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(", MAX(DECODE ( FLAG ,'A' , AMT${key})) OLDMTYCOST${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(", MAX(DECODE ( FLAG ,'B' , AMT${key})) NEWMTCOST${key}" ).append("\n"); 
		query.append(", MAX(DECODE ( FLAG ,'C' , AMT${key})) NEWOFCOST${key}" ).append("\n"); 
		query.append(", NVL(MAX(DECODE ( FLAG ,'B' , AMT${key})),0) + NVL(MAX(DECODE ( FLAG ,'C' , AMT${key})),0) NEWTCOST${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(", NVL(MAX(DECODE ( FLAG ,'A' , AMT${key})),0) - NVL(MAX(DECODE ( FLAG ,'B' , AMT${key})),0) DIFFCOST${key}" ).append("\n"); 
		query.append(", MAX(DECODE ( FLAG ,'B' , AMT${key})) DIFFMTCOST${key}" ).append("\n"); 
		query.append(", NVL(MAX(DECODE ( FLAG ,'B' , AMT${key})),0) + NVL(MAX(DECODE ( FLAG ,'C' , AMT${key})),0) DIFFTCOST${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YRWK" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(", SUM(DECODE ( CNTR_TPSZ_CD , '$key' , AMT)) AMT${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 'A' FLAG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.PLN_YRWK" ).append("\n"); 
		query.append(", B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", B.LODG_DCHG_COST_AMT  AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_VSL_LODG_DCHG_PLN A" ).append("\n"); 
		query.append(", EQR_VSL_LODG_DCHG_PLN_QTY B" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
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
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
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
		query.append("A.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND TO_CHAR(A.FM_ETD_DT,'YYYYMMDD') BETWEEN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_ST_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK = @[fm_yrwk]" ).append("\n"); 
		query.append(") AND (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_END_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK = @[to_yrwk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TO_CHAR(A.TO_ETB_DT,'YYYYMMDD') BETWEEN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_ST_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK = @[fm_to_yrwk]" ).append("\n"); 
		query.append(") AND (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_END_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK =@[to_to_yrwk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${tpszcd} != '')" ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD IN (${arrcntrtpzcd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = c.ECC_CD" ).append("\n"); 
		query.append("AND A.TO_ECC_CD = d.ECC_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = B.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = B.PLN_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.PLN_YRWK" ).append("\n"); 
		query.append(", B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", B.TRSP_COST_AMT AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_INLND_TRSP_PLN A" ).append("\n"); 
		query.append(", EQR_INLND_TRSP_PLN_QTY B" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
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
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
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
		query.append("A.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND A.PLN_YRWK BETWEEN @[fm_yrwk] AND @[to_yrwk]" ).append("\n"); 
		query.append("AND A.TO_YRWK  BETWEEN @[fm_to_yrwk]  AND @[to_to_yrwk]" ).append("\n"); 
		query.append("#if (${tpszcd} != '')" ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD IN (${arrcntrtpzcd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = c.ECC_CD" ).append("\n"); 
		query.append("AND A.TO_ECC_CD = d.ECC_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = B.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = B.PLN_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN.PLN_YRWK" ).append("\n"); 
		query.append(", QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", QTY.ONF_HIR_COST_AMT   AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ONF_HIR_PLN  PLN" ).append("\n"); 
		query.append(", EQR_ONF_HIR_PLN_QTY QTY" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
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
		query.append("WHERE" ).append("\n"); 
		query.append("PLN.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND PLN.PLN_YRWK BETWEEN @[fm_yrwk] AND  @[to_yrwk]" ).append("\n"); 
		query.append("#if (${tpszcd} != '')" ).append("\n"); 
		query.append("AND QTY.CNTR_TPSZ_CD IN (${arrcntrtpzcd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ( PLN.ECC_CD = c.ECC_CD OR PLN.ECC_CD = c.ECC_CD )" ).append("\n"); 
		query.append("AND PLN.REPO_PLN_ID = QTY.REPO_PLN_ID" ).append("\n"); 
		query.append("AND PLN.PLN_YRWK    = QTY.PLN_YRWK" ).append("\n"); 
		query.append("AND PLN.PLN_SEQ     = QTY.PLN_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("PLN_YRWK" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YRWK" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(", SUM(DECODE ( CNTR_TPSZ_CD , '$key' , AMT)) AMT${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 'B' FLAG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.PLN_YRWK" ).append("\n"); 
		query.append(", B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", B.LODG_DCHG_COST_AMT  AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_VSL_LODG_DCHG_PLN A" ).append("\n"); 
		query.append(", EQR_VSL_LODG_DCHG_PLN_QTY B" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
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
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
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
		query.append("A.REPO_PLN_ID = @[new_repo_pln_id]" ).append("\n"); 
		query.append("AND TO_CHAR(A.FM_ETD_DT,'YYYYMMDD') BETWEEN	(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_ST_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK = @[fm_yrwk]" ).append("\n"); 
		query.append(") AND (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_END_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK = @[to_yrwk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TO_CHAR(A.TO_ETB_DT,'YYYYMMDD') BETWEEN	(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_ST_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK = @[fm_to_yrwk]" ).append("\n"); 
		query.append(") AND (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_END_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK =@[to_to_yrwk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${tpszcd} != '')" ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD IN (${arrcntrtpzcd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = c.ECC_CD" ).append("\n"); 
		query.append("AND A.TO_ECC_CD = d.ECC_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = B.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = B.PLN_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.PLN_YRWK" ).append("\n"); 
		query.append(", B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", B.TRSP_COST_AMT AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_INLND_TRSP_PLN A" ).append("\n"); 
		query.append(", EQR_INLND_TRSP_PLN_QTY B" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
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
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
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
		query.append("A.REPO_PLN_ID = @[new_repo_pln_id]" ).append("\n"); 
		query.append("AND A.PLN_YRWK BETWEEN @[fm_yrwk]  AND @[to_yrwk]" ).append("\n"); 
		query.append("AND A.TO_YRWK  BETWEEN @[fm_to_yrwk]  AND @[to_to_yrwk]" ).append("\n"); 
		query.append("#if (${tpszcd} != '')" ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD IN (${arrcntrtpzcd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = c.ECC_CD" ).append("\n"); 
		query.append("AND A.TO_ECC_CD = d.ECC_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = B.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = B.PLN_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN.PLN_YRWK" ).append("\n"); 
		query.append(", QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", QTY.ONF_HIR_COST_AMT   AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ONF_HIR_PLN  PLN" ).append("\n"); 
		query.append(", EQR_ONF_HIR_PLN_QTY QTY" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
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
		query.append("WHERE" ).append("\n"); 
		query.append("PLN.REPO_PLN_ID = @[new_repo_pln_id]" ).append("\n"); 
		query.append("AND PLN.PLN_YRWK BETWEEN @[fm_yrwk] AND  @[to_yrwk]" ).append("\n"); 
		query.append("#if (${tpszcd} != '')" ).append("\n"); 
		query.append("AND QTY.CNTR_TPSZ_CD IN (${arrcntrtpzcd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ( PLN.ECC_CD = c.ECC_CD OR PLN.ECC_CD = c.ECC_CD )" ).append("\n"); 
		query.append("AND PLN.REPO_PLN_ID = QTY.REPO_PLN_ID" ).append("\n"); 
		query.append("AND PLN.PLN_YRWK    = QTY.PLN_YRWK" ).append("\n"); 
		query.append("AND PLN.PLN_SEQ     = QTY.PLN_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("PLN_YRWK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YRWK" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(", SUM(DECODE ( CNTR_TPSZ_CD , '$key' , 0)) AMT${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 'C' FLAG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.PLN_YRWK" ).append("\n"); 
		query.append(", B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", B.LODG_DCHG_COST_AMT  AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_VSL_LODG_DCHG_PLN A" ).append("\n"); 
		query.append(", EQR_VSL_LODG_DCHG_PLN_QTY B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.REPO_PLN_ID = @[new_repo_pln_id]" ).append("\n"); 
		query.append("AND TO_CHAR(A.FM_ETD_DT,'YYYYMMDD') BETWEEN  (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_ST_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK = @[fm_yrwk]" ).append("\n"); 
		query.append(") AND (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_END_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK = @[to_yrwk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TO_CHAR(A.TO_ETB_DT,'YYYYMMDD') BETWEEN	(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_ST_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK = @[fm_to_yrwk]" ).append("\n"); 
		query.append(") AND (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("WK_END_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR || PLN_WK =@[to_to_yrwk]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${tpszcd} != '')" ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD IN (${arrcntrtpzcd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = B.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = B.PLN_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.PLN_YRWK" ).append("\n"); 
		query.append(", B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", B.TRSP_COST_AMT      AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_INLND_TRSP_PLN A" ).append("\n"); 
		query.append(", EQR_INLND_TRSP_PLN_QTY B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.REPO_PLN_ID = @[new_repo_pln_id]" ).append("\n"); 
		query.append("AND A.PLN_YRWK BETWEEN @[fm_yrwk]  AND @[to_yrwk]" ).append("\n"); 
		query.append("AND A.TO_YRWK  BETWEEN @[fm_to_yrwk]  AND @[to_to_yrwk]" ).append("\n"); 
		query.append("#if (${tpszcd} != '')" ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD IN (${arrcntrtpzcd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = B.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = B.PLN_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN.PLN_YRWK" ).append("\n"); 
		query.append(", QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", QTY.ONF_HIR_COST_AMT   AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ONF_HIR_PLN  PLN" ).append("\n"); 
		query.append(", EQR_ONF_HIR_PLN_QTY QTY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN.REPO_PLN_ID = @[new_repo_pln_id]" ).append("\n"); 
		query.append("AND PLN.PLN_YRWK BETWEEN @[fm_yrwk] AND  @[to_yrwk]" ).append("\n"); 
		query.append("#if (${tpszcd} != '')" ).append("\n"); 
		query.append("AND QTY.CNTR_TPSZ_CD IN (${arrcntrtpzcd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND PLN.REPO_PLN_ID = QTY.REPO_PLN_ID" ).append("\n"); 
		query.append("AND PLN.PLN_YRWK    = QTY.PLN_YRWK" ).append("\n"); 
		query.append("AND PLN.PLN_SEQ     = QTY.PLN_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY PLN_YRWK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("PLN_YRWK" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("PLN_YRWK" ).append("\n"); 

	}
}