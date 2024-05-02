/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SimulationDBDAOSearchCapaOfTrndLineRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.25
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.25 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.simulation.simulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAOSearchCapaOfTrndLineRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trnd Line이 생성되어 있는 Capa를 조회한다.
	  * </pre>
	  */
	public SimulationDBDAOSearchCapaOfTrndLineRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOSearchCapaOfTrndLineRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT VSL_CLSS_CD" ).append("\n"); 
		query.append("FROM FCM_TRND_LINE" ).append("\n"); 
		query.append("WHERE VSL_CLSS_CD IS NOT NULL" ).append("\n"); 
		query.append("AND TRND_LINE_USE_TP_CD='N'" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER(VSL_CLSS_CD)" ).append("\n"); 

	}
}