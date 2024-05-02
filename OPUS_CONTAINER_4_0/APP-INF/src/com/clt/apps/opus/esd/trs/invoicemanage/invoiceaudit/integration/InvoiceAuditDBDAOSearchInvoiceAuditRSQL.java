/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchInvoiceAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.08.27 손은주(TRS)
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

public class InvoiceAuditDBDAOSearchInvoiceAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Audit & Confirm Search
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchInvoiceAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchInvoiceAuditRSQL").append("\n"); 
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
		query.append("'' if_sys_knd_cd_param" ).append("\n"); 
		query.append(",'' if_sys_knd_cd" ).append("\n"); 
		query.append(",'' trsp_inv_act_sts_cd_param" ).append("\n"); 
		query.append(",'' trsp_inv_aud_sts_cd_param" ).append("\n"); 
		query.append(",'' trsp_inv_aud_sts_cd" ).append("\n"); 
		query.append(",'' combo_svc_provider" ).append("\n"); 
		query.append(",'' apply_currency" ).append("\n"); 
		query.append(",'' inv_amt" ).append("\n"); 
		query.append(",'' vat_amt" ).append("\n"); 
		query.append(",'' wht_amt" ).append("\n"); 
		query.append(",'' tot_amt" ).append("\n"); 
		query.append(",'' recieve_dt" ).append("\n"); 
		query.append(",'' issue_dt" ).append("\n"); 
		query.append(",'' TRSP_SO_VNDR_NO" ).append("\n"); 
		query.append(",'' FORM_CRE_USR_ID" ).append("\n"); 
		query.append(",'' PROV_USR_ID" ).append("\n"); 
		query.append(",'' PROV_PHN_ID" ).append("\n"); 
		query.append(",'' FORM_USR_OFC_CD" ).append("\n"); 
		query.append(",'' invoice_no" ).append("\n"); 
		query.append(",'' mode_param" ).append("\n"); 
		query.append(",'' inv_no_param" ).append("\n"); 
		query.append(",'' inv_vndr_seq_param" ).append("\n"); 
		query.append(",'' paymt_sp_cd" ).append("\n"); 
		query.append(",'' wo_no" ).append("\n"); 
		query.append(",'' booking_no" ).append("\n"); 
		query.append(",'' bl_no" ).append("\n"); 
		query.append(",'' eq_no_text" ).append("\n"); 
		query.append(",'' so_no" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}