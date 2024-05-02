/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOGetMassSimulationNoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOGetMassSimulationNoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetMassSimulationNoInfo
	  * </pre>
	  */
	public ACMSimulationDBDAOGetMassSimulationNoInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetMassSimulationNoInfoRSQL").append("\n"); 
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
		query.append("SELECT 'S' || (SELECT TO_CHAR(SYSDATE, 'YYMMDD') || TO_CHAR( NVL( MAX(SUBSTR(BAT_ITM_NM, 8,4)) + 1, '1') , 'FM0000')" ).append("\n"); 
		query.append("                 FROM ACM_CALC_BAT " ).append("\n"); 
		query.append("                WHERE COMM_TP_CD = 'S' " ).append("\n"); 
		query.append("                  AND SUBSTR(BAT_ITM_NM, 2,6) = TO_CHAR(SYSDATE, 'YYMMDD')) AS SIM_NO" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}