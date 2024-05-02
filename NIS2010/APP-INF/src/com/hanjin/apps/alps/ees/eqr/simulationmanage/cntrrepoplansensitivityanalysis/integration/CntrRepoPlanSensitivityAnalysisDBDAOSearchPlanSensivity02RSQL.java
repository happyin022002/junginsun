/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.22 채창호
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

public class CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ON/Off Hire 민감도 조회 쿼리
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity02RSQL(){
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
		params.put("sens_typ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obj_txt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("costobj",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity02RSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(B.PLN_YRWK,1,4) || '-' || SUBSTR(B.PLN_YRWK,5,2) WEEK" ).append("\n"); 
		query.append(", @[sens_typ] SENSITY" ).append("\n"); 
		query.append(", @[obj_txt] OBJ" ).append("\n"); 
		query.append("#if (${costobj} == 'O')" ).append("\n"); 
		query.append("--	, '' FM_LOC" ).append("\n"); 
		query.append(", B.ECC_CD FM_LOC" ).append("\n"); 
		query.append("#elseif (${costobj} == 'F')" ).append("\n"); 
		query.append(", B.ECC_CD FM_LOC" ).append("\n"); 
		query.append("--   , '' FM_LOC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", D.CNTR_TPSZ_CD TS_TYPE" ).append("\n"); 
		query.append(", SUM(D.CNTR_QTY) VOL" ).append("\n"); 
		query.append(", SUM(D.ONF_HIR_COST_AMT) CURR_COST" ).append("\n"); 
		query.append(", '' COST_RANGE" ).append("\n"); 
		query.append(", '' COST_RANGE1" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN A" ).append("\n"); 
		query.append(", EQR_ONF_HIR_PLN B" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) C" ).append("\n"); 
		query.append(", EQR_ONF_HIR_PLN_QTY D" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND B.ONF_HIR_DIV_CD = @[costobj]" ).append("\n"); 
		query.append("AND D.CNTR_TPSZ_CD IN (${arrtpszcd})" ).append("\n"); 
		query.append("AND B.REPO_PLN_ID = D.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.PLN_YRWK    = D.PLN_YRWK" ).append("\n"); 
		query.append("AND B.PLN_SEQ     = D.PLN_SEQ" ).append("\n"); 
		query.append("#if (${costobj} == 'O')" ).append("\n"); 
		query.append("AND B.PLN_YRWK BETWEEN @[tostartprd] AND @[toendprd]" ).append("\n"); 
		query.append("#elseif (${costobj} == 'F')" ).append("\n"); 
		query.append("AND B.PLN_YRWK BETWEEN @[fmstartprd] AND @[fmendprd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${costobj} == 'O')" ).append("\n"); 
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
		query.append("#elseif (${costobj} == 'F')" ).append("\n"); 
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
		query.append("GROUP BY B.PLN_YRWK, B.ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY B.PLN_YRWK, B.ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 

	}
}