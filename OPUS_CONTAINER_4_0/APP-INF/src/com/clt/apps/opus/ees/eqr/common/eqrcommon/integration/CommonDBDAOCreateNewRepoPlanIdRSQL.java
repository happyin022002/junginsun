/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonDBDAOCreateNewRepoPlanIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOCreateNewRepoPlanIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 새로운 REPO_PLN_ID를 생성한다.
	  * 1. REPOXXXXXXW000 의 형태로 생성하며 
	  * 2. XXXXXX 의 주차에 REPO PLAN ID 가 없는 경우는 SEQ = 999 를 먼저 생성함.
	  *     - 금요일에 최초로 생성하는 PLAN을 SEQ = 999로 KEEPING 하여 일요일 엔진이
	  *        문제가 발생하면 대체하여 사용함.
	  *    - SAMPLE:REPO201025W999
	  * 3. 999 이후에는 000부터 순차적으로 생성함.
	  * </pre>
	  */
	public CommonDBDAOCreateNewRepoPlanIdRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOCreateNewRepoPlanIdRSQL").append("\n"); 
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
		query.append("SELECT MAX(TO_NUMBER(SUBSTR(REPO_PLN_ID,12,3)) + 1) REPO_MAX" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE SUBSTR(REPO_PLN_ID,5,6) = SUBSTR(@[repo_plan_id],5,6)" ).append("\n"); 
		query.append("AND   SUBSTR(REPO_PLN_ID, 12, 3) <> '999'" ).append("\n"); 

	}
}