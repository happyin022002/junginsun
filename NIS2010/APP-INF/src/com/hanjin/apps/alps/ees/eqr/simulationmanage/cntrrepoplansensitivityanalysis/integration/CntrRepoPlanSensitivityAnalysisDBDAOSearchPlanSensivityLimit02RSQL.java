/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.04.15 채창호
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

public class CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Residual Capa 민감도 조회
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit02RSQL(){
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
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivityLimit02RSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(FM_WK,1,4) || '-' || SUBSTR(FM_WK,5,2) WEEK" ).append("\n"); 
		query.append(", @[sens_typ] SENSITY" ).append("\n"); 
		query.append(", @[obj_txt] OBJ" ).append("\n"); 
		query.append(", LANE" ).append("\n"); 
		query.append(", VVD" ).append("\n"); 
		query.append(", ECC_CD FM_LOC" ).append("\n"); 
		query.append(", '' TO_LOC" ).append("\n"); 
		query.append(", 'TEU' ts_type" ).append("\n"); 
		query.append(", SUM(VSL_RSDL_SPC)   CURR_LIMIT" ).append("\n"); 
		query.append(", SUM(SHDW_COST_AMT)  SHADOW_PRC" ).append("\n"); 
		query.append(", '' LIMIT_LANG" ).append("\n"); 
		query.append("FROM( SELECT L.REPO_PLN_ID" ).append("\n"); 
		query.append(", L.FM_DT" ).append("\n"); 
		query.append(", M.FM_WK" ).append("\n"); 
		query.append(", L.LANE" ).append("\n"); 
		query.append(", L.VVD" ).append("\n"); 
		query.append(", L.ECC_CD" ).append("\n"); 
		query.append(", L.SHDW_COST_AMT" ).append("\n"); 
		query.append(", L.SCNR_ID" ).append("\n"); 
		query.append(", L.VSL_RSDL_SPC" ).append("\n"); 
		query.append("FROM ( SELECT A.REPO_PLN_ID" ).append("\n"); 
		query.append(", A.SCNR_ID" ).append("\n"); 
		query.append(", C.VSL_ETA_DT" ).append("\n"); 
		query.append(", TO_CHAR(C.VSL_ETA_DT, 'YYYYMMDD') FM_DT" ).append("\n"); 
		query.append(", B.ECC_CD ECC_CD" ).append("\n"); 
		query.append(", B.SHDW_COST_AMT SHDW_COST_AMT" ).append("\n"); 
		query.append(", C.VSL_SLAN_CD LANE" ).append("\n"); 
		query.append(", B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(", B.VSL_RSDL_SPC" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN A" ).append("\n"); 
		query.append(", EQR_RSDL_CAPA_SHDW B" ).append("\n"); 
		query.append(", EQR_SCNR_VSL_SKD C" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) D" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.SCNR_ID = C.SCNR_ID" ).append("\n"); 
		query.append("AND B.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.ECC_CD = C.VSL_LOC_CD" ).append("\n"); 
		query.append("AND C.VSL_CALL_IND_CD = '1'" ).append("\n"); 
		query.append("AND B.ECC_CD = D.ECC_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("#if (${fmecccd} != '')" ).append("\n"); 
		query.append("#if (${fmtype} == 'R')" ).append("\n"); 
		query.append("AND D.RCC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'L')" ).append("\n"); 
		query.append("AND D.LCC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmtype} == 'E')" ).append("\n"); 
		query.append("AND D.ECC_CD IN (${arrfmecccd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") L" ).append("\n"); 
		query.append(", (SELECT PLN_YR || PLN_WK FM_WK, WK_ST_DT, WK_END_DT FROM EQR_WK_PRD) M" ).append("\n"); 
		query.append("WHERE L.FM_DT BETWEEN M.WK_ST_DT AND M.WK_END_DT" ).append("\n"); 
		query.append("AND FM_WK BETWEEN @[fmstartprd] AND @[fmendprd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY FM_WK, LANE, VVD, ECC_CD" ).append("\n"); 
		query.append("ORDER BY FM_WK, LANE, VVD, ECC_CD" ).append("\n"); 

	}
}