/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOMakeRefIDRepoExePlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOMakeRefIDRepoExePlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ref Id Select
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOMakeRefIDRepoExePlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_plan_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_repo_plan_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onf_hir_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOMakeRefIDRepoExePlanRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(@[old_repo_plan_id] , 7, 4)" ).append("\n"); 
		query.append("       ||SUBSTR(@[old_repo_plan_id] , 12, 4)" ).append("\n"); 
		query.append("       ||@[onf_hir_div_cd]" ).append("\n"); 
		query.append("       ||LTRIM(TO_CHAR(NVL(MAX(SUBSTR(REF_ID, -3))+1, 001), '000')) SEQ        " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    ${table_name}                                                           " ).append("\n"); 
		query.append("WHERE REPO_PLN_ID            = @[repo_plan_id]  -- repo plan id                                                               " ).append("\n"); 
		query.append("AND   REF_ID LIKE SUBSTR(@[old_repo_plan_id] , 7, 4)||SUBSTR(@[old_repo_plan_id] , 12, 4)||@[onf_hir_div_cd]||'%'" ).append("\n"); 
		query.append("AND   LENGTH(REF_ID) = 12" ).append("\n"); 

	}
}