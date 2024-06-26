/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CodSimulateDBDAODeleteRepoPlanIdDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAODeleteRepoPlanIdDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_EQ_REPO_PLN 데이타 삭제
	  * </pre>
	  */
	public CodSimulateDBDAODeleteRepoPlanIdDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration ").append("\n"); 
		query.append("FileName : CodSimulateDBDAODeleteRepoPlanIdDSQL").append("\n"); 
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
		query.append("DELETE FROM" ).append("\n"); 
		query.append("	EQR_EQ_REPO_PLN " ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 

	}
}