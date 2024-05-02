/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.23 채창호
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

public class CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost내에서의 Rail/Water/Truck 구하기
	  * </pre>
	  */
	public CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity01RSQL(){
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
		query.append("FileName : CntrRepoPlanSensitivityAnalysisDBDAOSearchPlanSensivity01RSQL").append("\n"); 
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
		query.append(", B.FM_ECC_CD  FM_LOC" ).append("\n"); 
		query.append(", B.TO_ECC_CD  TO_LOC" ).append("\n"); 
		query.append(", F.CNTR_TPSZ_CD  TS_TYPE" ).append("\n"); 
		query.append(", SUM(F.CNTR_QTY) VOL" ).append("\n"); 
		query.append(", (select DECODE(SUBSTR(CNTR_TPSZ_CD,2,2)  , '2',TZ_20FT_COST_AMT" ).append("\n"); 
		query.append(", '4',TZ_40FT_COST_AMT" ).append("\n"); 
		query.append(", '5',TZ_40FT_COST_AMT" ).append("\n"); 
		query.append(", '7',TZ_45FT_COST_AMT)" ).append("\n"); 
		query.append("FROM EQR_ECC_LNK" ).append("\n"); 
		query.append("WHERE FM_ECC_CD = B.FM_ECC_CD" ).append("\n"); 
		query.append("AND TO_ECC_CD= B.TO_ECC_CD" ).append("\n"); 
		query.append("AND TRSP_MOD_CD = B.TRSP_MOD_CD) CURR_COST" ).append("\n"); 
		query.append(", RNG_MIN_QTY COST_RANGE" ).append("\n"); 
		query.append(", RNG_MAX_QTY COST_RANGE1" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN A" ).append("\n"); 
		query.append(", EQR_INLND_TRSP_PLN B" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) C" ).append("\n"); 
		query.append(", (SELECT ECC_CD, LCC_CD, RCC_CD FROM EQR_ECC_MST) D" ).append("\n"); 
		query.append(", EQR_TRSP_COST_RNG E" ).append("\n"); 
		query.append(", EQR_INLND_TRSP_PLN_QTY F" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.FM_ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND B.TO_ECC_CD = D.ECC_CD" ).append("\n"); 
		query.append("AND B.REPO_PLN_ID 	= E.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.FM_ECC_CD 		= E.FM_ECC_CD" ).append("\n"); 
		query.append("AND B.TO_ECC_CD 		= E.TO_ECC_CD" ).append("\n"); 
		query.append("AND F.CNTR_TPSZ_CD 	= E.CNTR_SZ_CD" ).append("\n"); 
		query.append("AND B.PLN_YRWK 		= E.PLN_YRWK" ).append("\n"); 
		query.append("AND B.TRSP_MOD_CD 	= E.TRSP_MOD_CD" ).append("\n"); 
		query.append("AND A.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND F.CNTR_TPSZ_CD IN (${arrtpszcd})" ).append("\n"); 
		query.append("AND B.TRSP_MOD_CD = @[costobj]" ).append("\n"); 
		query.append("AND FM_YRWK BETWEEN @[fmstartprd] AND @[fmendprd]" ).append("\n"); 
		query.append("AND B.REPO_PLN_ID = F.REPO_PLN_ID" ).append("\n"); 
		query.append("AND B.PLN_YRWK    = F.PLN_YRWK" ).append("\n"); 
		query.append("AND B.PLN_SEQ     = F.PLN_SEQ" ).append("\n"); 
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
		query.append("#if (${fmtype} != '' && ${totype} != '')" ).append("\n"); 
		query.append("AND TO_YRWK BETWEEN @[tostartprd] AND @[toendprd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("GROUP BY B.PLN_YRWK, B.FM_ECC_CD, B.TO_ECC_CD, F.CNTR_TPSZ_CD ,B.TRSP_MOD_CD, RNG_MIN_QTY, RNG_MAX_QTY" ).append("\n"); 
		query.append("ORDER BY B.PLN_YRWK, B.FM_ECC_CD, B.TO_ECC_CD, F.CNTR_TPSZ_CD ,B.TRSP_MOD_CD" ).append("\n"); 

	}
}