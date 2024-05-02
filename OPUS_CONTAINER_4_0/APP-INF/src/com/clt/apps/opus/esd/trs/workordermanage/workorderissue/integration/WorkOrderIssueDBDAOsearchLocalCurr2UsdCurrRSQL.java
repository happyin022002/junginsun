/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchLocalCurr2UsdCurrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.09.22 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsearchLocalCurr2UsdCurrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLocalCurr2UsdCurr
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsearchLocalCurr2UsdCurrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CURR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("LOCAL_TOT_AMT",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration ").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsearchLocalCurr2UsdCurrRSQL").append("\n"); 
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
		query.append("ROUND((TO_NUMBER( @[LOCAL_TOT_AMT] ) / RAT.USD_LOCL_XCH_RT),2) WO_TOT_AMT_USD" ).append("\n"); 
		query.append("FROM   GL_MON_XCH_RT RAT" ).append("\n"); 
		query.append("WHERE  RAT.CURR_CD								= @[CURR_CD]" ).append("\n"); 
		query.append("AND    RAT.ACCT_XCH_RT_LVL						= '1'" ).append("\n"); 
		query.append("AND    RAT.ACCT_XCH_RT_YRMON					=" ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD]),'YYYYMM')" ).append("\n"); 

	}
}