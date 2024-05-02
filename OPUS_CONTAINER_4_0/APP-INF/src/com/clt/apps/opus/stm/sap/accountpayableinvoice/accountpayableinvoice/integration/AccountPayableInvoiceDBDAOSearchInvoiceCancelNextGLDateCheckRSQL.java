/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceCancelNextGLDateCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceCancelNextGLDateCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvoiceCancelNextGLDateCheck
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceCancelNextGLDateCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceCancelNextGLDateCheckRSQL").append("\n"); 
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
		query.append("SELECT  MIN(SP.EFF_YRMON) || '01'  AS NEXT_GL_DATE" ).append("\n"); 
		query.append("FROM    SCO_PERIOD SP" ).append("\n"); 
		query.append("WHERE   SP.EFF_YRMON >= SUBSTR(REPLACE(@[gl_date],'-'),0,6)  " ).append("\n"); 
		query.append("AND     SP.PRD_APPL_CD = 'AP'" ).append("\n"); 
		query.append("AND     SP.PRD_STS_CD = 'O'" ).append("\n"); 

	}
}