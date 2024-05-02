/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceReasonListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2010.01.25 문중철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceReasonListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_4006
	  * Manual Invoice Report by Office
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceReasonListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceReasonListRSQL").append("\n"); 
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
		query.append("SELECT INTG_CD_VAL_CTNT||'||'||INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_dtl" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01975'" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ DESC" ).append("\n"); 

	}
}