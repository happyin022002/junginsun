/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOInvoiceGroupParamRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.23 
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

public class InvoiceIssueCollectionMgtDBDAOInvoiceGroupParamRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation - Group Param
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOInvoiceGroupParamRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOInvoiceGroupParamRSQL").append("\n"); 
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
		query.append("'' AS INV_QTY" ).append("\n"); 
		query.append(",'' AS TOT_BIL_AMT" ).append("\n"); 
		query.append(",'' AS TOT_TAX_AMT" ).append("\n"); 
		query.append(",'' AS TOT_PAYABLE_AMT" ).append("\n"); 
		query.append(",''	AS PAYER_CD" ).append("\n"); 
		query.append(",'' AS PAYER_NM" ).append("\n"); 
		query.append(",'' AS ISSUE_DATE" ).append("\n"); 
		query.append(",'' AS USR_OFC" ).append("\n"); 
		query.append(",'' AS INV_CURR_CD" ).append("\n"); 
		query.append(",'' AS USR_NAME" ).append("\n"); 
		query.append(",'' AS TAX_AMT" ).append("\n"); 
		query.append(",'' AS S_GROUP_BY" ).append("\n"); 
		query.append(",'' AS S_CHARGE_TYPE" ).append("\n"); 
		query.append(",'' AS ERR_CODE" ).append("\n"); 
		query.append(",'' AS ERR_MSG" ).append("\n"); 
		query.append(",'' AS BACKENDJOB_ID" ).append("\n"); 
		query.append(",'' AS BACKENDJOB_KEY" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}