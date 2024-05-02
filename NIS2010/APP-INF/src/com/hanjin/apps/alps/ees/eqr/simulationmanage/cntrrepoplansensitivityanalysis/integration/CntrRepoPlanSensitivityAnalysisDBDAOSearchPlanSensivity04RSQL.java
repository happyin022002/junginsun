/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity04RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.04.14 채창호
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

public class CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity04RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Storage 민김도 조회
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity04RSQL(){
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
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity04RSQL").append("\n"); 
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
		query.append("SELECT 	B.WEEK" ).append("\n"); 
		query.append(", B.SENS_TYP SENSITY" ).append("\n"); 
		query.append(", B.OBJ_TXT  OBJ" ).append("\n"); 
		query.append(", B.FM_ECC_CD FM_LOC" ).append("\n"); 
		query.append(", B.TO_ECC_CD  TO_LOC" ).append("\n"); 
		query.append(", B.CNTR_TPSZ_CD TS_TYPE" ).append("\n"); 
		query.append(", B.CNTR_QTY VOL" ).append("\n"); 
		query.append(", B.CURR_COST 	CURR_COST" ).append("\n"); 
		query.append(", E.STO_RNG_MIN_QTY COST_RANGE" ).append("\n"); 
		query.append(", E.STO_RNG_MAX_QTY	COST_RANGE1" ).append("\n"); 
		query.append("FROM ( SELECT SUBSTR(PLN_YRWK,1,4) || '-' || SUBSTR(PLN_YRWK,5,2) WEEK,REPO_PLN_ID" ).append("\n"); 
		query.append(", PLN_YRWK" ).append("\n"); 
		query.append(", @[sens_typ] SENS_TYP" ).append("\n"); 
		query.append(", @[obj_txt] OBJ_TXT" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", '' TO_ECC_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", SUM(CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append(", (select DECODE(SUBSTR(CNTR_TPSZ_CD,2,2) , '2', STO_20FT_COST_AMT" ).append("\n"); 
		query.append(", '4', STO_40FT_COST_AMT" ).append("\n"); 
		query.append(", '5', STO_40FT_COST_AMT" ).append("\n"); 
		query.append(", '7', STO_45FT_COST_AMT)  FROM EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE ECC_CD = FM_ECC_CD ) CURR_COST" ).append("\n"); 
		query.append("FROM ( SELECT  /*+ LEADING(N) FULL(N) FULL(M) */ REPO_PLN_ID" ).append("\n"); 
		query.append(", PLN_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", FM_DT" ).append("\n"); 
		query.append(", FM_WK" ).append("\n"); 
		query.append(", TO_DT" ).append("\n"); 
		query.append(", TO_WK" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_QTY" ).append("\n"); 
		query.append("FROM ( SELECT   A.REPO_PLN_ID" ).append("\n"); 
		query.append(", A.PLN_YRWK" ).append("\n"); 
		query.append(", B.FM_ECC_CD" ).append("\n"); 
		query.append(", B.FM_ETD_DT" ).append("\n"); 
		query.append(", TO_CHAR(B.FM_ETD_DT, 'YYYYMMDD') FM_DT" ).append("\n"); 
		query.append(",  B.TO_ETB_DT" ).append("\n"); 
		query.append(", TO_CHAR(B.TO_ETB_DT, 'YYYYMMDD') TO_DT" ).append("\n"); 
		query.append(", F.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", F.CNTR_QTY" ).append("\n"); 
		query.append("FROM EQR_INLND_TRSP_PLN A" ).append("\n"); 
		query.append(", EQR_VSL_LODG_DCHG_PLN B" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) C" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) D" ).append("\n"); 
		query.append(", EQR_VSL_LODG_DCHG_PLN_QTY F" ).append("\n"); 
		query.append(", EQR_INLND_TRSP_PLN_QTY G" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.FM_ECC_CD = B.FM_ECC_CD" ).append("\n"); 
		query.append("AND B.FM_ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND B.TO_ECC_CD = D.ECC_CD" ).append("\n"); 
		query.append("AND B.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND F.CNTR_TPSZ_CD IN (${arrtpszcd})" ).append("\n"); 
		query.append("AND B.REPO_PLN_ID = F.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.PLN_YRWK    = F.PLN_YRWK" ).append("\n"); 
		query.append("AND B.PLN_SEQ     = F.PLN_SEQ" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = G.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = G.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = G.PLN_SEQ" ).append("\n"); 
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
		query.append("AND M.FM_WK BETWEEN @[fmstartprd] AND @[fmendprd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY REPO_PLN_ID, PLN_YRWK, FM_ECC_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append(") B, EQR_CNTR_HNDL_COST_RNG E" ).append("\n"); 
		query.append("WHERE B.REPO_PLN_ID  = E.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.FM_ECC_CD 	  = E.ECC_CD" ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD = E.CNTR_SZ_CD" ).append("\n"); 
		query.append("AND B.PLN_YRWK     = E.PLN_YRWK" ).append("\n"); 
		query.append("ORDER BY B.PLN_YRWK, B.FM_ECC_CD, B.CNTR_TPSZ_CD" ).append("\n"); 

	}
}