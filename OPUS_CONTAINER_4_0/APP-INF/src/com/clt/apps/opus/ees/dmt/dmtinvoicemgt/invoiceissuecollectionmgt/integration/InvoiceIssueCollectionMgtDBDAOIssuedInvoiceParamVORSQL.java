/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOIssuedInvoiceParamVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOIssuedInvoiceParamVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue
	  * Issued Invoice Inquiry
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOIssuedInvoiceParamVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOIssuedInvoiceParamVORSQL").append("\n"); 
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
		query.append("SELECT '' S_OFC_CD" ).append("\n"); 
		query.append("	,'' S_ISSUE_OFC" ).append("\n"); 
		query.append("	,'' S_DMDT_TRF_CD" ).append("\n"); 
		query.append("	,'' S_GROUP_BY" ).append("\n"); 
		query.append("	,'' S_CHG_TYPE" ).append("\n"); 
		query.append("	,'' DATE_CNTR" ).append("\n"); 
		query.append("	,'' FM_CFM_DT" ).append("\n"); 
		query.append("	,'' TO_CFM_DT" ).append("\n"); 
		query.append("	,'' S_BKG_NO" ).append("\n"); 
		query.append("	,'' S_BL_NO" ).append("\n"); 
		query.append("	,'' S_CNTR_NO" ).append("\n"); 
		query.append("	,'' S_CUST_CD" ).append("\n"); 
		query.append("	,'' S_SC_NO" ).append("\n"); 
		query.append("	,'' S_RFA_NO" ).append("\n"); 
		query.append("	,'' S_INVOICE_NO" ).append("\n"); 
		query.append("	,'' DMDT_CHG_STS_CDS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' S_DMDT_AR_IF_CD" ).append("\n"); 
		query.append("	,'' S_DMDT_INV_STS_CD" ).append("\n"); 
		query.append("	,'' S_OFC_CHECK" ).append("\n"); 
		query.append("	,'' S_ISSUE_FM" ).append("\n"); 
		query.append("	,'' S_ISSUE_TO" ).append("\n"); 
		query.append("--	,'' S_INV_OVER" ).append("\n"); 
		query.append("	,'' S_INV_OVER_FM" ).append("\n"); 
		query.append("	,'' S_INV_OVER_TO" ).append("\n"); 
		query.append("	,'' S_ISSUE_USR_ID" ).append("\n"); 
		query.append("	,'' S_INV_CHECK" ).append("\n"); 
		query.append("	,'' S_INVOICE_NO" ).append("\n"); 
		query.append("	,'' S_PAYER_CD" ).append("\n"); 
		query.append("	,'' S_CUST_GUBUN" ).append("\n"); 
		query.append("	,'' CALLER" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' OFC_CD" ).append("\n"); 
		query.append("	,'' S_CNTR_NO" ).append("\n"); 
		query.append("	,'' PGM_ID" ).append("\n"); 
		query.append("	,'' SESSION_RHQ_OFC_CD" ).append("\n"); 
		query.append("	,'' INV_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}