/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchARAcctListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchARAcctListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR Acount list
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchARAcctListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchARAcctListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SAM.AR_ACCT_CD AS AR_ACCT_CD, MA.ACCT_ENG_NM AS ACCT_TP_NM" ).append("\n"); 
		query.append("FROM   SAR_ACCT_MTX SAM," ).append("\n"); 
		query.append("       MDM_ACCOUNT MA" ).append("\n"); 
		query.append("WHERE  SAM.AR_ACCT_CD = MA.ACCT_CD" ).append("\n"); 
		query.append("AND    ACCT_CTNT1 = 'REC'" ).append("\n"); 

	}
}