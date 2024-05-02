/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAOSearchCodTargetDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.11.09 채창호
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

public class CodSimulateDBDAOSearchCodTargetDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_VSL_LDIS_PLN_COD_TMP , EQR_VSL_PLN_COD_QTY 테이블에서 COD 대상인 데이터 검색
	  * </pre>
	  */
	public CodSimulateDBDAOSearchCodTargetDataRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOSearchCodTargetDataRSQL").append("\n"); 
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
		query.append("A.REPO_PLN_ID," ).append("\n"); 
		query.append("A.PLN_YRWK," ).append("\n"); 
		query.append("A.PLN_SEQ," ).append("\n"); 
		query.append("TRSP_MOD_CD," ).append("\n"); 
		query.append("VSL_LANE_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("FM_ECC_CD," ).append("\n"); 
		query.append("FM_YD_CD," ).append("\n"); 
		query.append("TO_CHAR (FM_ETD_DT ,'YYYY-MM-DD HH24:MI:SS') FM_ETD_DT," ).append("\n"); 
		query.append("TO_ECC_CD," ).append("\n"); 
		query.append("TO_CHAR (TO_ETB_DT ,'YYYY-MM-DD HH24:MI:SS') TO_ETB_DT," ).append("\n"); 
		query.append("TO_YD_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_QTY," ).append("\n"); 
		query.append("LODG_DCHG_COST_AMT," ).append("\n"); 
		query.append("COD_SIM_FLG," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR (sysdate ,'YYYY-MM-DD HH24:MI:SS') CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("PRE_PLN_CNTR_QTY," ).append("\n"); 
		query.append("COD_DCHG_PLN_FLG," ).append("\n"); 
		query.append("PRE_PLN_DCHG_LOC_CD," ).append("\n"); 
		query.append("PRE_PLN_TS_FLG," ).append("\n"); 
		query.append("TO_CHAR (sysdate ,'YYYY-MM-DD HH24:MI:SS') UPD_DT ," ).append("\n"); 
		query.append("PAST_REPO_PLN_FLG" ).append("\n"); 
		query.append("FROM  EQR_VSL_LDIS_PLN_COD_TMP  A," ).append("\n"); 
		query.append("EQR_VSL_PLN_COD_QTY       B" ).append("\n"); 
		query.append("WHERE A.REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND  B.COD_SIM_FLG = 'Y'" ).append("\n"); 
		query.append("AND  A.REPO_PLN_ID = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND  A.PLN_YRWK    = B.PLN_YRWK" ).append("\n"); 
		query.append("AND  A.PLN_SEQ     = B.PLN_SEQ" ).append("\n"); 

	}
}