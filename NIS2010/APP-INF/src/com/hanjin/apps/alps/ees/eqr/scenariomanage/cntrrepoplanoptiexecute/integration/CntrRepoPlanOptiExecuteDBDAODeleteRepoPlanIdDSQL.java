/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanOptiExecuteDBDAODeleteRepoPlanIdDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.12.18 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanOptiExecuteDBDAODeleteRepoPlanIdDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_eq_repo_pln 테이블에 해당 repo plan id 삭제
	  * </pre>
	  */
	public CntrRepoPlanOptiExecuteDBDAODeleteRepoPlanIdDSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanOptiExecuteDBDAODeleteRepoPlanIdDSQL").append("\n"); 
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
		query.append("DELETE EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = @[repo_plan_id]" ).append("\n"); 
		query.append("AND REPO_PLN_AUTO_GEN_FLG IN('Y','N')" ).append("\n"); 

	}
}