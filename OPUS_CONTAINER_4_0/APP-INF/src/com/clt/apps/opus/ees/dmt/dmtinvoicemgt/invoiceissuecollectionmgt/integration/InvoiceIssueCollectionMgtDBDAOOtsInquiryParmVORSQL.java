/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOOtsInquiryParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.18 
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

public class InvoiceIssueCollectionMgtDBDAOOtsInquiryParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOOtsInquiryParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOOtsInquiryParmVORSQL").append("\n"); 
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
		query.append("'' FRDT" ).append("\n"); 
		query.append(",'' CUTP" ).append("\n"); 
		query.append(",'' TINVNO" ).append("\n"); 
		query.append(",'' CUNO" ).append("\n"); 
		query.append(",'' RFAN" ).append("\n"); 
		query.append(",'' TODT" ).append("\n"); 
		query.append(",'' ARIF" ).append("\n"); 
		query.append(",'' SCNO" ).append("\n"); 
		query.append(",'' PAYC" ).append("\n"); 
		query.append(",'' CNTRINVNO" ).append("\n"); 
		query.append(",'' TFTP" ).append("\n"); 
		query.append(",'' H_RHQ_OFF" ).append("\n"); 
		query.append(",'' SHEETP" ).append("\n"); 
		query.append(",'' TFTP2" ).append("\n"); 
		query.append(",'' PAYN" ).append("\n"); 
		query.append(",'' H_USR_OFF" ).append("\n"); 
		query.append(",'' INVNO" ).append("\n"); 
		query.append(",'' CUDE" ).append("\n"); 
		query.append(",'' TJSPNO" ).append("\n"); 
		query.append(",'' RMRK" ).append("\n"); 
		query.append(",'' ISOF" ).append("\n"); 
		query.append(",'' CREOF" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}