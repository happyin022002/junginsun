/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnewaySimulateDBDAOSearchOneWayExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.11.10 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnewaySimulateDBDAOSearchOneWayExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_ONE_WY_OFFR에서 One Way Offer Exist 정보 검색
	  * </pre>
	  */
	public OnewaySimulateDBDAOSearchOneWayExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.integration").append("\n"); 
		query.append("FileName : OnewaySimulateDBDAOSearchOneWayExistRSQL").append("\n"); 
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
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append("NVL(SUM(${key}),0)  OFFER${key}" ).append("\n"); 
		query.append("#if($velocityCount < $arrtpszcd.size())" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpszcd})" ).append("\n"); 
		query.append(", MAX(DECODE(CNTR_TPSZ_CD , '$key', CNTR_QTY)) ${key}" ).append("\n"); 
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
		query.append("REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND FCAST_YRWK  BETWEEN @[fm_pln_yrwk]  AND @[to_pln_yrwk]" ).append("\n"); 
		query.append("AND FM_ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND TO_ECC_CD = D.ECC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("FCAST_YRWK" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}