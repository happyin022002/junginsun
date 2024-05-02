/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity03RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.04.13 채창호
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

public class CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity03RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trshipment 민감도 조회
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity03RSQL(){
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
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity03RSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(A.PLN_YRWK,1,4) || '-' || SUBSTR(A.PLN_YRWK,5,2) WEEK" ).append("\n"); 
		query.append(", @[sens_typ] SENSITY" ).append("\n"); 
		query.append(", @[obj_txt] OBJ" ).append("\n"); 
		query.append(", A.ECC_CD TO_LOC" ).append("\n"); 
		query.append("--	, '' TO_LOC" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD TS_TYPE" ).append("\n"); 
		query.append(", SUM(CNTR_QTY) VOL" ).append("\n"); 
		query.append(", (SELECT ROUND(AMT / QTY)" ).append("\n"); 
		query.append("FROM ( SELECT 	A.ECC_CD ," ).append("\n"); 
		query.append("SUM(DECODE(C.CNTR_TPSZ_CD, '2'" ).append("\n"); 
		query.append(", STO_20FT_COST_AMT" ).append("\n"); 
		query.append(", '4', STO_40FT_COST_AMT" ).append("\n"); 
		query.append(", '5', STO_40FT_COST_AMT" ).append("\n"); 
		query.append(", '7', STO_45FT_COST_AMT)) AMT ," ).append("\n"); 
		query.append("COUNT(DECODE(C.CNTR_TPSZ_CD, '2'" ).append("\n"); 
		query.append(", STO_20FT_COST_AMT" ).append("\n"); 
		query.append(", '4', STO_40FT_COST_AMT" ).append("\n"); 
		query.append(", '5', STO_40FT_COST_AMT" ).append("\n"); 
		query.append(", '7', STO_45FT_COST_AMT)) QTY" ).append("\n"); 
		query.append("FROM EQR_ECC_MST A," ).append("\n"); 
		query.append("EQR_TS_TML B," ).append("\n"); 
		query.append("(SELECT ECC_CD," ).append("\n"); 
		query.append("SUBSTR(CNTR_TPSZ_CD, 2, 2) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM EQR_LDIS_TS_PLN" ).append("\n"); 
		query.append("GROUP BY ECC_CD," ).append("\n"); 
		query.append("SUBSTR(CNTR_TPSZ_CD, 2, 2) ) C" ).append("\n"); 
		query.append("WHERE B.ECC_CD = A.ECC_CD" ).append("\n"); 
		query.append("AND C.ECC_CD = A.ECC_CD" ).append("\n"); 
		query.append("AND A.TS_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("GROUP BY A.ECC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ECC_CD = A.ECC_CD )   CURR_COST" ).append("\n"); 
		query.append(", TS_RNG_MIN_QTY COST_RANGE" ).append("\n"); 
		query.append(", TS_RNG_MAX_QTY COST_RANGE1" ).append("\n"); 
		query.append("FROM EQR_LDIS_TS_PLN A" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) B" ).append("\n"); 
		query.append(", EQR_CNTR_HNDL_COST_RNG C" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND A.ECC_CD = B.ECC_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID  = C.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.ECC_CD 	  = C.ECC_CD" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = C.CNTR_SZ_CD" ).append("\n"); 
		query.append("AND A.PLN_YRWK     = C.PLN_YRWK" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD IN (${arrtpszcd})" ).append("\n"); 
		query.append("AND A.PLN_YRWK BETWEEN @[fmstartprd] AND @[fmendprd]" ).append("\n"); 
		query.append("#if (${fmecccd} != '')" ).append("\n"); 
		query.append("#if (${fmtype} == 'R')" ).append("\n"); 
		query.append("AND B.RCC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'L')" ).append("\n"); 
		query.append("AND B.LCC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'E')" ).append("\n"); 
		query.append("AND B.ECC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.PLN_YRWK, A.ECC_CD, CNTR_TPSZ_CD, TS_RNG_MIN_QTY, TS_RNG_MAX_QTY" ).append("\n"); 
		query.append("ORDER BY A.PLN_YRWK, A.ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 

	}
}