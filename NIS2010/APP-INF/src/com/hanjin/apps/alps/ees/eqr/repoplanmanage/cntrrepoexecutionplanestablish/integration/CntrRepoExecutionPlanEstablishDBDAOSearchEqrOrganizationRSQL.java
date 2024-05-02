/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchEqrOrganizationRSQL.java
*@FileTitle : EQR Organization Chart
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.09.07 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
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
		query.append(",LCC_CD" ).append("\n"); 
		query.append(",ECC_CD" ).append("\n"); 
		query.append(",SCC_CD" ).append("\n"); 
		query.append("FROM	MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE	DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY 1,2,3,4" ).append("\n"); 

	}
}