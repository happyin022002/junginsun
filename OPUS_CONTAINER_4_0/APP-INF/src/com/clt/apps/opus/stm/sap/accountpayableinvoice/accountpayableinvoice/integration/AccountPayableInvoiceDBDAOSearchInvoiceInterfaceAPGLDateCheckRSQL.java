/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPGLDateCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.09
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.09 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPGLDateCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPGLDateCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPGLDateCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPGLDateCheckRSQL").append("\n"); 
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
		query.append("SELECT  PRD_STS_CD  AS AP_PERIOD_USE_FLAG" ).append("\n"); 
		query.append("FROM    SCO_PERIOD" ).append("\n"); 
		query.append("WHERE   EFF_YRMON = SUBSTR(REPLACE(@[gl_dt], '-'), 0, 6) " ).append("\n"); 
		query.append("AND     PRD_APPL_CD = 'AP'" ).append("\n"); 

	}
}