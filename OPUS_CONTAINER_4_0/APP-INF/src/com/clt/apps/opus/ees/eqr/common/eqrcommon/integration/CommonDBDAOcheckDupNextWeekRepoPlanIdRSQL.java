/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOcheckDupNextWeekRepoPlanIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.27
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.05.27 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOcheckDupNextWeekRepoPlanIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * duplicate check
	  * </pre>
	  */
	public CommonDBDAOcheckDupNextWeekRepoPlanIdRSQL(){
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
		query.append("FileName : CommonDBDAOcheckDupNextWeekRepoPlanIdRSQL").append("\n"); 
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
		query.append("SELECT COUNT(REPO_PLN_ID) CNT" ).append("\n"); 
		query.append("FROM EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 

	}
}