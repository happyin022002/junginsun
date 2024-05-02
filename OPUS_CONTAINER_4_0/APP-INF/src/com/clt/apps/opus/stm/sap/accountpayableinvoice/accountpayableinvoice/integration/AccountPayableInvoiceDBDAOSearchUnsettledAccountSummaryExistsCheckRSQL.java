/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchUnsettledAccountSummaryExistsCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.20 
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

public class AccountPayableInvoiceDBDAOSearchUnsettledAccountSummaryExistsCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchUnsettledAccountSummaryExistsCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchUnsettledAccountSummaryExistsCheckRSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchUnsettledAccountSummaryExistsCheckRSQL").append("\n"); 
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
		query.append("SELECT  SUS.UNSTL_YRMON AS VALUE0" ).append("\n"); 
		query.append("FROM    SAP_UNSTL_SMRY SUS" ).append("\n"); 
		query.append("WHERE   SUS.UNSTL_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[gl_dt],'-',''), 'YYYYMMDD'), -1), 'YYYYMM')" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 
		query.append("UNION   ALL" ).append("\n"); 
		query.append("SELECT  SUBSTR(SIH.GL_DT, 1, 6) AS VALUE0" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("WHERE   NOT EXISTS (SELECT 'A' FROM SAP_INV_HDR SIH2 WHERE SIH2.GL_DT LIKE TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[gl_dt],'-',''), 'YYYYMMDD'), -1), 'YYYYMM') || '%' AND ROWNUM = 1)" ).append("\n"); 
		query.append("AND     SIH.GL_DT LIKE TO_CHAR(TO_DATE(REPLACE(@[gl_dt],'-',''), 'YYYYMMDD'), 'YYYYMM') || '%'" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

	}
}