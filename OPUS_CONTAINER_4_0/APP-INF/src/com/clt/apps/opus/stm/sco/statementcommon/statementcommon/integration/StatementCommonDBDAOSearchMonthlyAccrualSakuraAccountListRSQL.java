/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOSearchMonthlyAccrualSakuraAccountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchMonthlyAccrualSakuraAccountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Accrual sakura Account Code
	  * </pre>
	  */
	public StatementCommonDBDAOSearchMonthlyAccrualSakuraAccountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchMonthlyAccrualSakuraAccountListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.MODI_ACCT_CD AS CODE" ).append("\n"); 
		query.append("     , A.MODI_ACCT_CD AS NAME" ).append("\n"); 
		query.append("  FROM MDM_ACCOUNT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.JNL_CRE_FLG = 'Y'" ).append("\n"); 
		query.append("   AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("   AND A.MODI_ACCT_CD IS NOT NULL" ).append("\n"); 
		query.append(" ORDER BY A.MODI_ACCT_CD" ).append("\n"); 

	}
}