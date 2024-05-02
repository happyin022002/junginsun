/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ManualARCreationDBDAOSearchRevenueAcctMaxEndDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOSearchRevenueAcctMaxEndDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRevenueAcctMaxEndDate
	  * </pre>
	  */
	public ManualARCreationDBDAOSearchRevenueAcctMaxEndDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOSearchRevenueAcctMaxEndDateRSQL").append("\n"); 
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
		query.append("SELECT MAX(FM_ACCT_END_DT) AS FM_ACCT_END_DT, MAX(TO_ACCT_END_DT) AS TO_ACCT_END_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT MAX(ACCT_END_DT) AS FM_ACCT_END_DT, '' AS TO_ACCT_END_DT" ).append("\n"); 
		query.append("FROM SAR_ACCT_MTX" ).append("\n"); 
		query.append("WHERE ACCT_CTNT1 = 'REV'" ).append("\n"); 
		query.append("AND ACCT_CTNT4 = 'MTH'" ).append("\n"); 
		query.append("AND REV_ACCT_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND NVL(ACCT_END_DT, REPLACE(@[gl_eff_dt],'-','')) < REPLACE(@[gl_eff_dt],'-','')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '', MIN(ACCT_END_DT) AS TO_ACCT_END_DT" ).append("\n"); 
		query.append("FROM SAR_ACCT_MTX" ).append("\n"); 
		query.append("WHERE ACCT_CTNT1 = 'REV'" ).append("\n"); 
		query.append("AND ACCT_CTNT4 = 'MTH'" ).append("\n"); 
		query.append("AND REV_ACCT_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND NVL(ACCT_END_DT, REPLACE(@[gl_eff_dt],'-','')) >= REPLACE(@[gl_eff_dt],'-','')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}