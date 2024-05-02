/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOFromToRepoPlnIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.28 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOFromToRepoPlnIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_EQ_REPO_PLN 의 fromToRepoPLnId 조회
	  * </pre>
	  */
	public CommonDBDAOFromToRepoPlnIdRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOFromToRepoPlnIdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("REPO_PLN_ID1," ).append("\n"); 
		query.append("REPO_PLN_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT(SUBSTR(REPO_PLN_ID ,0,10) ) REPO_PLN_ID1," ).append("\n"); 
		query.append("REPO_PLN_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SUBSTR(REPO_PLN_ID ,0,10) < @[repo_pln_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM BETWEEN 1 AND 8" ).append("\n"); 
		query.append("UNION  ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT(SUBSTR(REPO_PLN_ID ,0,10) ) REPO_PLN_ID1 ," ).append("\n"); 
		query.append("REPO_PLN_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SUBSTR(REPO_PLN_ID ,0,10) = @[repo_pln_id]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("REPO_PLN_ID1 ," ).append("\n"); 
		query.append("REPO_PLN_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT(SUBSTR(REPO_PLN_ID ,0,10) ) REPO_PLN_ID1 ," ).append("\n"); 
		query.append("REPO_PLN_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SUBSTR(REPO_PLN_ID ,0,10) > @[repo_pln_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM BETWEEN 1 AND 8" ).append("\n"); 
		query.append("ORDER BY REPO_PLN_ID" ).append("\n"); 

	}
}