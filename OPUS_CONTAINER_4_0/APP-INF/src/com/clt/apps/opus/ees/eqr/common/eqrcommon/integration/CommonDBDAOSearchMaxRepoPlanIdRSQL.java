/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchMaxRepoPlanIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.15
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2014.10.15 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
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
	  * --> 2014.05.27 yongchan shin, search current next week's repo plan id
	  * </pre>
	  */
	public CommonDBDAOSearchMaxRepoPlanIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
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
		query.append("SELECT --SUBSTR(REPO_PLN_ID, 5, 4)||SUBSTR(REPO_PLN_ID, 9, 2) WEEK 	" ).append("\n"); 
		query.append("       SUBSTR(REPO_PLN_ID, 5, 6)  WEEK 	" ).append("\n"); 
		query.append("      ,TRIM(TO_CHAR(SUBSTR(REPO_PLN_ID, 12, 4), '0000')) SEQ		  								" ).append("\n"); 
		query.append("FROM 												  				" ).append("\n"); 
		query.append("(  																" ).append("\n"); 
		query.append("    --SELECT MAX(REPO_PLN_ID)	 REPO_PLN_ID				  			" ).append("\n"); 
		query.append("    --FROM EQR_EQ_REPO_PLN				      						" ).append("\n"); 
		query.append("    --WHERE DELT_FLG = 'N'   		                                " ).append("\n"); 
		query.append("    --AND REPO_PLN_DTRB_FLG = 'Y'    " ).append("\n"); 
		query.append("    SELECT MAX(REPO_PLN_ID)	 REPO_PLN_ID" ).append("\n"); 
		query.append("    FROM EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("    WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND REPO_PLN_DTRB_FLG = 'Y'" ).append("\n"); 
		query.append("    AND SUBSTR(REPO_PLN_ID, 5, 6) = (" ).append("\n"); 
		query.append("                                      -- Current +1 week " ).append("\n"); 
		query.append("                                      SELECT PLN_YR||PLN_WK                           					" ).append("\n"); 
		query.append("                                      FROM EQR_WK_PRD                               					" ).append("\n"); 
		query.append("                                      WHERE TO_CHAR(SYSDATE+7,'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT" ).append("\n"); 
		query.append("                                    )									" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}