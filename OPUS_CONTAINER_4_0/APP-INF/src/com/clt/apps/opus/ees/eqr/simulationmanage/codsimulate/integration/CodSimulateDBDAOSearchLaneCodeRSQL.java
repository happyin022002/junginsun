/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodSimulateDBDAOSearchLaneCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.05.04 채창호
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

public class CodSimulateDBDAOSearchLaneCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 시나리오 테이블에서 입력된 lane 코드가 있는지 확인 한다.
	  * </pre>
	  */
	public CodSimulateDBDAOSearchLaneCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOSearchLaneCodeRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM EQR_SCNR_VSL_SKD A," ).append("\n"); 
		query.append("(SELECT SCNR_ID FROM EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID =@[repo_pln_id]) B" ).append("\n"); 
		query.append("WHERE A.SCNR_ID = B.SCNR_ID" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD =@[vsl_lane_cd]" ).append("\n"); 

	}
}