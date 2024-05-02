/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchIdaBankInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchIdaBankInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchIdaBankInfoRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchIdaBankInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchIdaBankInfoRSQL").append("\n"); 
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
		query.append("SELECT  ATTR_CTNT1  AS IDA_BANK_ACCT_NO" ).append("\n"); 
		query.append("       ,ATTR_CTNT2  AS IDA_BANK_IFSC_CD" ).append("\n"); 
		query.append("  FROM  DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append(" WHERE  HRD_CDG_ID = 'IDA_TAX_INFO'" ).append("\n"); 

	}
}