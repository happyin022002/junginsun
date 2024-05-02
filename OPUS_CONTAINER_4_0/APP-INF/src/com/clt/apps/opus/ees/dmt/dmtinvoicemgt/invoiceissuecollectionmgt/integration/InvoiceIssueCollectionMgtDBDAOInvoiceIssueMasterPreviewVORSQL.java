/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOInvoiceIssueMasterPreviewVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.01.12 김태균
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

public class InvoiceIssueCollectionMgtDBDAOInvoiceIssueMasterPreviewVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE ISSUE RD MASTER PREVIEW
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOInvoiceIssueMasterPreviewVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOInvoiceIssueMasterPreviewVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("'' RD_SH_ADDR1" ).append("\n"); 
		query.append(",'' RD_SH_ADDR2" ).append("\n"); 
		query.append(",'' RD_SH_ADDR3" ).append("\n"); 
		query.append(",'' RD_INVOICE_TITLE" ).append("\n"); 
		query.append(",'' RD_CANCEL_NOTE" ).append("\n"); 
		query.append(",'' RD_CUST_NM" ).append("\n"); 
		query.append(",'' RD_PAYR_ADDR" ).append("\n"); 
		query.append(",'' RD_ATTN_NM" ).append("\n"); 
		query.append(",'' RD_PHN_NO" ).append("\n"); 
		query.append(",'' RD_FAX_NO" ).append("\n"); 
		query.append(",'' RD_SH_HD_N1ST_MSG" ).append("\n"); 
		query.append(",'' RD_SH_HD_N2ND_MSG" ).append("\n"); 
		query.append(",'' RD_SH_HD_N3RD_MSG" ).append("\n"); 
		query.append(",'' RD_SH_HD_N4TH_MSG" ).append("\n"); 
		query.append(",'' RD_SH_HD_N5TH_MSG" ).append("\n"); 
		query.append(",'' RD_DMDT_INV_NO" ).append("\n"); 
		query.append(",'' RD_ISSUE_DAY" ).append("\n"); 
		query.append(",'' RD_DUE_DATE" ).append("\n"); 
		query.append(",'' RD_DUE_DAY" ).append("\n"); 
		query.append(",'' RD_NTC_KNT_CD" ).append("\n"); 
		query.append(",'' RD_CRE_USR_NM" ).append("\n"); 
		query.append(",'' RD_CUST_CD" ).append("\n"); 
		query.append(",'' RD_INV_REF_NO" ).append("\n"); 
		query.append(",'' RD_CUST_VAT_NO" ).append("\n"); 
		query.append(",'' RD_VVD_CD" ).append("\n"); 
		query.append(",'' RD_VSL_ENG_NM" ).append("\n"); 
		query.append(",'' RD_ARR" ).append("\n"); 
		query.append(",'' RD_DEP" ).append("\n"); 
		query.append(",'' RD_BL_NO" ).append("\n"); 
		query.append(",'' RD_BKG_NO" ).append("\n"); 
		query.append(",'' RD_CMDT_NM" ).append("\n"); 
		query.append(",'' RD_DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' RD_DMDT_TRF_NM" ).append("\n"); 
		query.append(",'' RD_BKG_RCV_TERM_NM" ).append("\n"); 
		query.append(",'' RD_BKG_DEL_TERM_NM" ).append("\n"); 
		query.append(",'' RD_POD" ).append("\n"); 
		query.append(",'' RD_POD_NM" ).append("\n"); 
		query.append(",'' RD_DEL" ).append("\n"); 
		query.append(",'' RD_DEL_NM" ).append("\n"); 
		query.append(",'' RD_TRUCKER_NM" ).append("\n"); 
		query.append(",'' RD_INV_RMK1" ).append("\n"); 
		query.append(",'' RD_INV_RMK2" ).append("\n"); 
		query.append(",'' RD_SH_RMK1" ).append("\n"); 
		query.append(",'' RD_SH_RMK2" ).append("\n"); 
		query.append(",'' RD_SH_RMK3" ).append("\n"); 
		query.append(",'' RD_SH_RMK4" ).append("\n"); 
		query.append(",'' RD_SH_RMK5" ).append("\n"); 
		query.append(",'' RD_SH_RMK6" ).append("\n"); 
		query.append(",'' RD_SH_RMK7" ).append("\n"); 
		query.append(",'' RD_SH_RMK8" ).append("\n"); 
		query.append(",'' RD_SH_RMK9" ).append("\n"); 
		query.append(",'' RD_SH_RMK10" ).append("\n"); 
		query.append(",'' RD_SH_RMK11" ).append("\n"); 
		query.append(",'' RD_SH_RMK12" ).append("\n"); 
		query.append(",'' RD_SH_RMK13" ).append("\n"); 
		query.append(",'' RD_SH_RMK14" ).append("\n"); 
		query.append(",'' RD_ORG_CHG_AMT" ).append("\n"); 
		query.append(",'' RD_ORG_CURR_CD" ).append("\n"); 
		query.append(",'' RD_INV_XCH_RT" ).append("\n"); 
		query.append(",'' RD_TOT_AMT" ).append("\n"); 
		query.append(",'' RD_INV_CURR_CD" ).append("\n"); 
		query.append(",'' RD_DC_AMT" ).append("\n"); 
		query.append(",'' RD_INV_CHG_AMT" ).append("\n"); 
		query.append(",'' RD_TAX_RTO" ).append("\n"); 
		query.append(",'' RD_TAX_AMT" ).append("\n"); 
		query.append(",'' RD_INV_AMT" ).append("\n"); 
		query.append(",'' RD_TAX_AMT_PRN_FLG" ).append("\n"); 
		query.append(",'' RD_DC_AMT_FLG" ).append("\n"); 
		query.append(",'' RD_CUST_REF_PRN_FLG" ).append("\n"); 
		query.append(",'' RD_CUST_VAT_PRN_FLG" ).append("\n"); 
		query.append(",'' RD_PHN_FAX_PRN_FLG" ).append("\n"); 
		query.append(",'' RD_DAYS_DISP" ).append("\n"); 
		query.append(",'' RD_DMDT_INV_STS_CD" ).append("\n"); 
		query.append(",'' RD_CRE_CNT_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' POR_CD" ).append("\n"); 
		query.append(",'' DEL_CD" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}