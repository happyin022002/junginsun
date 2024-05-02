/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchEqrAllWeeksPlanAccessGrantRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOSearchEqrAllWeeksPlanAccessGrantRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR All-Weeks' Plan Access Grant 조회
	  * 
	  * <Change History>
	  * 1	2010.05.04	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchEqrAllWeeksPlanAccessGrantRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchEqrAllWeeksPlanAccessGrantRSQL").append("\n"); 
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
		query.append("SELECT B.USR_ID" ).append("\n"); 
		query.append(", B.USR_NM" ).append("\n"); 
		query.append(", B.OFC_CD" ).append("\n"); 
		query.append(", A.USR_RMK" ).append("\n"); 
		query.append("FROM EQR_EXE_PLN_USR A" ).append("\n"); 
		query.append(", COM_USER B" ).append("\n"); 
		query.append("WHERE A.EXE_PLN_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("AND   B.USE_FLG = 'Y'" ).append("\n"); 

	}
}