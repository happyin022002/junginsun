/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAuditDBDAOInvoiceRefundRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.07.28 손은주(TRS)
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

public class InvoiceAuditDBDAOInvoiceRefundRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceRefund VO
	  * </pre>
	  */
	public InvoiceAuditDBDAOInvoiceRefundRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOInvoiceRefundRSQL").append("\n"); 
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
		query.append("''	INV_NO" ).append("\n"); 
		query.append(",null	INV_VNDR_SEQ" ).append("\n"); 
		query.append(",''	SUB_INV_SEQ" ).append("\n"); 
		query.append(",''	TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(",''	TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(",''	EQ_TPSZ_CD" ).append("\n"); 
		query.append(",0	TRSP_RFND_QTY" ).append("\n"); 
		query.append(",0	TRSP_RFND_INV_AMT" ).append("\n"); 
		query.append(",0	TRSP_RFND_UC_RT" ).append("\n"); 
		query.append(",''	HNDL_PRD_FM_DT" ).append("\n"); 
		query.append(",''	HNDL_PRD_TO_DT" ).append("\n"); 
		query.append(",'N'	DELT_FLG" ).append("\n"); 
		query.append(",''	CRE_OFC_CD" ).append("\n"); 
		query.append(",''	CSR_RFND_MON_KNT" ).append("\n"); 
		query.append(",0	CSR_RFND_CORR_AMT" ).append("\n"); 
		query.append(",null	HJL_INV_VNDR_SEQ" ).append("\n"); 
		query.append(",null	HJL_TRSP_RFND_QTY" ).append("\n"); 
		query.append(",null	HJL_TRSP_RFND_UC_RT" ).append("\n"); 
		query.append(",null	HJL_TRSP_RFND_INV_AMT" ).append("\n"); 
		query.append(",null	HJL_HNDL_PRD_FM_DT" ).append("\n"); 
		query.append(",null	HJL_HNDL_PRD_TO_DT" ).append("\n"); 
		query.append(",null	CRE_USR_ID" ).append("\n"); 
		query.append(",null	CRE_DT" ).append("\n"); 
		query.append(",null	UPD_USR_ID" ).append("\n"); 
		query.append(",null	UPD_DT" ).append("\n"); 
		query.append(",null combo_svc_provider" ).append("\n"); 
		query.append(",'' inv_curr_cd" ).append("\n"); 
		query.append(",0 inv_whld_tax_amt" ).append("\n"); 
		query.append(",'' insflag" ).append("\n"); 
		query.append(",'' inv_no" ).append("\n"); 
		query.append(",null paymt_sp_cd" ).append("\n"); 
		query.append(", '' usr_id" ).append("\n"); 
		query.append(",'' ofc_cd" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}