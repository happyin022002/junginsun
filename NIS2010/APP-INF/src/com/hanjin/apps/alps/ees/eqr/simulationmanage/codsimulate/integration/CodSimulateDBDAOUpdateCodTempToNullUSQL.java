/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAOUpdateCodTempToNullUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.07 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOUpdateCodTempToNullUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_VSL_LDIS_PLN_COD_TMP 테이블의 특정 REPO PLAN ID 데이터를 NULL로 변경
	  * </pre>
	  */
	public CodSimulateDBDAOUpdateCodTempToNullUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOUpdateCodTempToNullUSQL").append("\n"); 
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
		query.append("UPDATE EQR_VSL_PLN_COD_QTY" ).append("\n"); 
		query.append("SET PRE_PLN_DCHG_LOC_CD = null," ).append("\n"); 
		query.append("PRE_PLN_CNTR_QTY    = null," ).append("\n"); 
		query.append("COD_DCHG_PLN_FLG    = null" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID =@[repo_pln_id]" ).append("\n"); 
		query.append("AND PLN_YRWK IN( SELECT PLN_YRWK FROM EQR_VSL_LDIS_PLN_COD_TMP WHERE REPO_PLN_ID =@[repo_pln_id] AND PAST_REPO_PLN_FLG NOT IN('Y'))" ).append("\n"); 
		query.append("AND PLN_SEQ  IN( SELECT PLN_SEQ  FROM EQR_VSL_LDIS_PLN_COD_TMP WHERE REPO_PLN_ID =@[repo_pln_id] AND PAST_REPO_PLN_FLG NOT IN('Y'))" ).append("\n"); 
		query.append("AND COD_SIM_FLG NOT IN ('N')" ).append("\n"); 

	}
}