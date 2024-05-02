/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAODeleteEqrAllWeeksPlanAccessGrantDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAODeleteEqrAllWeeksPlanAccessGrantDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR All-Weeks' Plan Access Grant 삭제
	  * 
	  * <Change History>
	  * 1	2010.05.04	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAODeleteEqrAllWeeksPlanAccessGrantDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAODeleteEqrAllWeeksPlanAccessGrantDSQL").append("\n"); 
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
		query.append("DELETE FROM EQR_EXE_PLN_USR" ).append("\n"); 
		query.append("WHERE EXE_PLN_USR_ID = @[usr_id]" ).append("\n"); 

	}
}