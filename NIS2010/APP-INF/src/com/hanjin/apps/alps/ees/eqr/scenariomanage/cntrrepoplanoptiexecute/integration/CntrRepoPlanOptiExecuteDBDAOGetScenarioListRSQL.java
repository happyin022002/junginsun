/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanOptiExecuteDBDAOGetScenarioListRSQL.java
*@FileTitle : run_optimizer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.28 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanOptiExecuteDBDAOGetScenarioListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Scenario List 조회
	  * </pre>
	  */
	public CntrRepoPlanOptiExecuteDBDAOGetScenarioListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.integration ").append("\n"); 
		query.append("FileName : CntrRepoPlanOptiExecuteDBDAOGetScenarioListRSQL").append("\n"); 
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
		query.append("SELECT SCNR_ID" ).append("\n"); 
		query.append(",SCNR_RMK" ).append("\n"); 
		query.append(",SUBSTR(SCNR_ID,5,6) SCNR_WK" ).append("\n"); 
		query.append("FROM EQR_SCNR_MST" ).append("\n"); 
		query.append("WHERE REPO_PLN_CRE_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY SCNR_ID ASC" ).append("\n"); 

	}
}