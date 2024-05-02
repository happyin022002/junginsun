/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonDBDAOSearchMaxRepoPlanIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.29
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2010.06.29 신용찬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN YONGCHAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchMaxRepoPlanIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * REPO PLAN ID 중에 배포된 최근 PLAN ID 를 검색
	  * - 리턴형식 (WEEK, SEQ)
	  * </pre>
	  */
	public CommonDBDAOSearchMaxRepoPlanIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchMaxRepoPlanIdRSQL").append("\n"); 
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
		query.append("SUBSTR(REPO_PLN_ID, 5, 4)||SUBSTR(REPO_PLN_ID, 9, 2) WEEK" ).append("\n"); 
		query.append(",SUBSTR(REPO_PLN_ID, 12, 3) SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(REPO_PLN_ID)	 REPO_PLN_ID" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND REPO_PLN_DTRB_FLG = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}