/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ACMSimulationDBDAOGetMaxSimulationNoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.08
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2013.01.08 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOGetMaxSimulationNoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Simulation No. 의 max값을 구한다.
	  * </pre>
	  */
	public ACMSimulationDBDAOGetMaxSimulationNoInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration ").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetMaxSimulationNoInfoRSQL").append("\n"); 
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
		query.append("SELECT 'S' || TO_CHAR(SYSDATE, 'YYMMDD') || TO_CHAR( NVL( MAX(SUBSTR(SIM_NO, 8, 3)) + 1, '1') , 'FM000') AS SIM_NO" ).append("\n"); 
		query.append("  FROM ACM_SIM_BKG_INFO" ).append("\n"); 
		query.append(" WHERE SUBSTR(SIM_NO, 2, 6) = TO_CHAR(SYSDATE, 'YYMMDD')" ).append("\n"); 

	}
}