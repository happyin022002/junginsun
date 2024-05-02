/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOInvoiceIssueRDPreviewVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.12.30 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOInvoiceIssueRDPreviewVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE ISSUE RD DETAIL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOInvoiceIssueRDPreviewVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOInvoiceIssueRDPreviewVORSQL").append("\n"); 
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
		query.append("'' CNTR_NO" ).append("\n"); 
		query.append(",'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' FM_MVMT_DT" ).append("\n"); 
		query.append(",'' TO_MVMT_DT" ).append("\n"); 
		query.append(",'' FT_CMNC_DT" ).append("\n"); 
		query.append(",'' FT_END_DT" ).append("\n"); 
		query.append(",'' FT_DYS" ).append("\n"); 
		query.append(",'' FT_OVR_UND_DYS" ).append("\n"); 
		query.append(",'' INV_RT_AMT" ).append("\n"); 
		query.append(",'' RT_OVR_DYS" ).append("\n"); 
		query.append(",'' INV_AMOUNT" ).append("\n"); 
		query.append(",'' CHG_CURR_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}