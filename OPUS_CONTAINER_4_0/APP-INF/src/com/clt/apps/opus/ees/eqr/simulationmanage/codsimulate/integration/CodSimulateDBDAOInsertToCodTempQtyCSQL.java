/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAOInsertToCodTempQtyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.02 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOInsertToCodTempQtyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 REPO PLAN ID의 데이터를 EQR_VSL_LODG_DCHG_PLN 에서  EQR_VSL_LDIS_PLN_COD_TMP 테이블로 입력
	  * </pre>
	  */
	public CodSimulateDBDAOInsertToCodTempQtyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_user_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOInsertToCodTempQtyCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_VSL_PLN_COD_QTY" ).append("\n"); 
		query.append("( REPO_PLN_ID" ).append("\n"); 
		query.append(",PLN_YRWK" ).append("\n"); 
		query.append(",PLN_SEQ" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CNTR_QTY" ).append("\n"); 
		query.append(",LODG_DCHG_COST_AMT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",PRE_PLN_CNTR_QTY" ).append("\n"); 
		query.append(",COD_SIM_FLG" ).append("\n"); 
		query.append(",COD_DCHG_PLN_FLG" ).append("\n"); 
		query.append(",PRE_PLN_DCHG_LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(SELECT REPO_PLN_ID" ).append("\n"); 
		query.append(", PLN_YRWK" ).append("\n"); 
		query.append(", PLN_SEQ" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_QTY" ).append("\n"); 
		query.append(", LODG_PORT_COST_AMT" ).append("\n"); 
		query.append(", @[cre_user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", CNTR_QTY" ).append("\n"); 
		query.append(", 'N' COD_SIM_FLG" ).append("\n"); 
		query.append(", 'N' COD_DCHG_PLN_FLG" ).append("\n"); 
		query.append(", (SELECT  TO_ECC_CD" ).append("\n"); 
		query.append("FROM  EQR_VSL_LODG_DCHG_PLN" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = A.REPO_PLN_ID" ).append("\n"); 
		query.append("AND PLN_SEQ     = A.PLN_SEQ" ).append("\n"); 
		query.append("AND PLN_YRWK    = A.PLN_YRWK" ).append("\n"); 
		query.append(") PRE_PLN_DCHG_LOC_CD" ).append("\n"); 
		query.append("FROM EQR_VSL_LODG_DCHG_PLN_QTY A" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID =@[repo_pln_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}