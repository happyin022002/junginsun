/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchEqrOrganizationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.13 
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

public class CntrRepoExecutionPlanEstablishDBDAOSearchEqrOrganizationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_EQ_ORZ_CHT 테이블에서 RCC, LCC, ECC, SCC data를 조회
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchEqrOrganizationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchEqrOrganizationRSQL").append("\n"); 
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
		query.append("SELECT	 RCC_CD" ).append("\n"); 
		query.append("		,LCC_CD" ).append("\n"); 
		query.append("		,ECC_CD" ).append("\n"); 
		query.append("		,SCC_CD" ).append("\n"); 
		query.append("FROM	MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE	DELT_FLG = 'N'  " ).append("\n"); 
		query.append("ORDER BY 1,2,3,4" ).append("\n"); 

	}
}