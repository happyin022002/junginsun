/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit03RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.12.01 채창호
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

public class CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit03RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * New Van Delivery Max/New Van Delivery Min 민감도 조회
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit03RSQL(){
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
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit03RSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(PLN_YRWK,1,4) || '-' || SUBSTR(PLN_YRWK,5,2) WEEK" ).append("\n"); 
		query.append(", @[sens_typ] SENSITY" ).append("\n"); 
		query.append(", @[obj_txt] OBJ" ).append("\n"); 
		query.append(", '' LANE" ).append("\n"); 
		query.append(", '' VVD" ).append("\n"); 
		query.append(", B.ECC_CD FM_LOC" ).append("\n"); 
		query.append(", '' TO_LOC" ).append("\n"); 
		query.append(", B.CNTR_TPSZ_CD  ts_type" ).append("\n"); 
		query.append("#if (${limitObj} == 'X')" ).append("\n"); 
		query.append(", SUM(CNTR_VOL_QTY)  CURR_LIMIT" ).append("\n"); 
		query.append(", SUM(UPPR_BND_QTY)  SHADOW_PRC" ).append("\n"); 
		query.append(", SUM(UPPR_RNG_MIN_QTY) LIMIT_LANG" ).append("\n"); 
		query.append(", SUM(UPPR_RNG_MAX_QTY) LIMIT_LANG1" ).append("\n"); 
		query.append("#elseif (${limitObj} == 'N')" ).append("\n"); 
		query.append(", SUM(CNTR_VOL_QTY) CURR_LIMIT" ).append("\n"); 
		query.append(", SUM(LOWR_BND_QTY) SHADOW_PRC" ).append("\n"); 
		query.append(", SUM(LOWR_RNG_MIN_QTY) LIMIT_LANG" ).append("\n"); 
		query.append(", SUM(LOWR_RNG_MAX_QTY) LIMIT_LANG1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN A" ).append("\n"); 
		query.append(", EQR_NEW_VAN_SKD_SHDW B" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) C" ).append("\n"); 
		query.append(", EQR_NEW_VAN_LONG_TERM D" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD IN (${arrtpszcd})" ).append("\n"); 
		query.append("AND B.PLN_YRWK BETWEEN @[fmstartprd] AND @[fmendprd]" ).append("\n"); 
		query.append("AND D.PLN_YRMON = B.PLN_YRWK" ).append("\n"); 
		query.append("AND D.ECC_CD    = B.ECC_CD" ).append("\n"); 
		query.append("#if (${limitObj} == 'X')" ).append("\n"); 
		query.append("AND D.CNTR_DE_STS_CD ='A'" ).append("\n"); 
		query.append("#elseif (${limitObj} == 'N')" ).append("\n"); 
		query.append("AND D.CNTR_DE_STS_CD ='L'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND D.CNTR_TPSZ_CD =  B.CNTR_TPSZ_CD" ).append("\n"); 
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
		query.append("GROUP BY B.PLN_YRWK, B.ECC_CD, B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY B.PLN_YRWK, B.ECC_CD, B.CNTR_TPSZ_CD" ).append("\n"); 

	}
}