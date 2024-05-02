/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonDBDAOChcekRepoPlanIdRowRSQL.java
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

public class CommonDBDAOChcekRepoPlanIdRowRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * plan 주차의 row 존재확인
	  * 
	  * <Change History>
	  * 1	2010.07.14	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CommonDBDAOChcekRepoPlanIdRowRSQL(){
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
		query.append("FileName : CommonDBDAOChcekRepoPlanIdRowRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) ROW_CNT" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE SUBSTR(REPO_PLN_ID, 5, 6) = SUBSTR(@[repo_plan_id], 5, 6)" ).append("\n"); 

	}
}