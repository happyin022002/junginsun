/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOOtsInquiryBySummaryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOOtsInquiryBySummaryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOOtsInquiryBySummaryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOOtsInquiryBySummaryVORSQL").append("\n"); 
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
		query.append("SELECT '' PAYERC" ).append("\n"); 
		query.append(",'' PAYERN" ).append("\n"); 
		query.append(",'' INVOCN" ).append("\n"); 
		query.append(",'' INVOCR" ).append("\n"); 
		query.append(",'' BLLAMT" ).append("\n"); 
		query.append(",'' TAXAMT" ).append("\n"); 
		query.append(",'' TOTAMT" ).append("\n"); 
		query.append(",'' USEFLG" ).append("\n"); 
		query.append(",'' DMIFYN" ).append("\n"); 
		query.append(",'' DTICYN" ).append("\n"); 
		query.append(",'' DMOFYN" ).append("\n"); 
		query.append(",'' DTOCYN" ).append("\n"); 
		query.append(",'' CTICYN" ).append("\n"); 
		query.append(",'' CTOCYN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}