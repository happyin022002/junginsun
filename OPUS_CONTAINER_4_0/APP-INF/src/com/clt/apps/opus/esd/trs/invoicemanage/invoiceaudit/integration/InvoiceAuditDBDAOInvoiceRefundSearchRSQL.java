/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAuditDBDAOInvoiceRefundSearchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.08.04 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOInvoiceRefundSearchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceRefundSearch
	  * </pre>
	  */
	public InvoiceAuditDBDAOInvoiceRefundSearchRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOInvoiceRefundSearchRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' inv_no," ).append("\n"); 
		query.append("'' paymt_sp_cd," ).append("\n"); 
		query.append("'' combo_svc_provider," ).append("\n"); 
		query.append("'' inv_curr_cd," ).append("\n"); 
		query.append("0 inv_bzc_amt," ).append("\n"); 
		query.append("0 inv_vat_amt," ).append("\n"); 
		query.append("0 inv_ttl_amt," ).append("\n"); 
		query.append("'' usr_id," ).append("\n"); 
		query.append("'' ofc_cd," ).append("\n"); 
		query.append("'' inv_rcv_dt," ).append("\n"); 
		query.append("'' inv_iss_dt," ).append("\n"); 
		query.append("0 inv_whld_tax_amt" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}