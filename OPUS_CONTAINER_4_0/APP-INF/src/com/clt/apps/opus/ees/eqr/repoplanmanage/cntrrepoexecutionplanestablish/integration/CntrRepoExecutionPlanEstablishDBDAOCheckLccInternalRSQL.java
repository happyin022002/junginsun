/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOCheckLccInternalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
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

public class CntrRepoExecutionPlanEstablishDBDAOCheckLccInternalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * REPO Execution 화면상에서 Lcc Internal을 관리하는 탭상에 From Loc. & To Loc. 콤보를 생성하는 로직
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOCheckLccInternalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOCheckLccInternalRSQL").append("\n"); 
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
		query.append("SELECT YD_CD," ).append("\n"); 
		query.append("       REPLACE(YD_NM, '''', ' ') YD_NM," ).append("\n"); 
		query.append("	   '' AS LOCYARD_SEARCHWORD                                           " ).append("\n"); 
		query.append("  FROM MDM_YARD   								            " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND DELT_FLG <> 'Y'                  								 " ).append("\n"); 
		query.append("   AND LOC_CD IN ( 											" ).append("\n"); 
		query.append("				  SELECT SCC_CD 								" ).append("\n"); 
		query.append("				    FROM MDM_EQ_ORZ_CHT 						" ).append("\n"); 
		query.append("				   WHERE LCC_CD LIKE '${locyard_searchword}%' " ).append("\n"); 
		query.append("			      ) 											 " ).append("\n"); 
		query.append(" ORDER BY YD_CD" ).append("\n"); 

	}
}