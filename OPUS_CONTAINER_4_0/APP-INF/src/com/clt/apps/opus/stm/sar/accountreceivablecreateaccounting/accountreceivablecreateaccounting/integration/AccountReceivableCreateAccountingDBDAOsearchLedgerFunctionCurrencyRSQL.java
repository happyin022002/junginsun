/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCreateAccountingDBDAOsearchLedgerFunctionCurrencyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCreateAccountingDBDAOsearchLedgerFunctionCurrencyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Function Currency
	  * </pre>
	  */
	public AccountReceivableCreateAccountingDBDAOsearchLedgerFunctionCurrencyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.integration").append("\n"); 
		query.append("FileName : AccountReceivableCreateAccountingDBDAOsearchLedgerFunctionCurrencyRSQL").append("\n"); 
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
		query.append("SELECT LU_CD FUNC_CURR" ).append("\n"); 
		query.append("FROM SCO_LU_DTL " ).append("\n"); 
		query.append("WHERE LU_TP_CD = 'FUNCTIONAL CURRENCY'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}