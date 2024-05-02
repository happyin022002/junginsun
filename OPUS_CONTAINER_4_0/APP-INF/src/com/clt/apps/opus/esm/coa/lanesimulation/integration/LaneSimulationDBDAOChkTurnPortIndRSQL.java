/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOChkTurnPortIndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.02.08 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOChkTurnPortIndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal Info 테이블에서
	  * 해당 sim_dt, sim_no의 turning port indicator 정보를 조회한다.
	  * </pre>
	  */
	public LaneSimulationDBDAOChkTurnPortIndRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration ").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOChkTurnPortIndRSQL").append("\n"); 
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
		query.append("TURN_PORT_IND_CD" ).append("\n"); 
		query.append("FROM COA_SIM_TML_INFO" ).append("\n"); 
		query.append("WHERE SIM_DT=@[f_sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO=@[f_sim_no]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}