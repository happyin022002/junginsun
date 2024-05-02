/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SimulationDBDAOMaxSimnoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.02 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAOMaxSimnoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sim_no max 값을 구함
	  * </pre>
	  */
	public SimulationDBDAOMaxSimnoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOMaxSimnoRSQL").append("\n"); 
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
		query.append("SELECT MAX(BNK_CSM_SIM_NO) SIMNO" ).append("\n"); 
		query.append("FROM FCM_BNK_CSM_PF_SIM " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SUBSTR(BNK_CSM_SIM_NO,0,6) = TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 

	}
}