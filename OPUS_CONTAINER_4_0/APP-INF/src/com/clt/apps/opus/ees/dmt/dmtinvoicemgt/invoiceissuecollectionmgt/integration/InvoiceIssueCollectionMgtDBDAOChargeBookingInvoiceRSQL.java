/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOChargeBookingInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.21 
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

public class InvoiceIssueCollectionMgtDBDAOChargeBookingInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeBookingInvoice
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOChargeBookingInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOChargeBookingInvoiceRSQL").append("\n"); 
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
		query.append("SELECT '' DMDT_INV_NO" ).append("\n"); 
		query.append(", '' CRE_DT" ).append("\n"); 
		query.append(", '' CRE_OFC_CD" ).append("\n"); 
		query.append(", '' CRE_CNT_CD" ).append("\n"); 
		query.append(", '' CRE_USR_ID" ).append("\n"); 
		query.append(", '' CRE_USR_NM" ).append("\n"); 
		query.append(", '' UPD_USR_ID" ).append("\n"); 
		query.append(", '' UPD_USR_NM" ).append("\n"); 
		query.append(", '' DMDT_INV_STS_CD" ).append("\n"); 
		query.append(", '' DMDT_INV_STS_NM" ).append("\n"); 
		query.append(", '' DMDT_AR_IF_CD" ).append("\n"); 
		query.append(", '' AR_IF_DT" ).append("\n"); 
		query.append(", '' AR_IF_OFC_CD" ).append("\n"); 
		query.append(", '' AR_IF_USR_ID" ).append("\n"); 
		query.append(", '' AR_IF_USR_NM" ).append("\n"); 
		query.append(", '' CR_INV_NO" ).append("\n"); 
		query.append(", '' BKG_NO" ).append("\n"); 
		query.append(", '' BL_NO" ).append("\n"); 
		query.append(", '' DMDT_TRF_CD" ).append("\n"); 
		query.append(", '' SC_NO" ).append("\n"); 
		query.append(", '' OFC_CD" ).append("\n"); 
		query.append(", '' VVD_CD" ).append("\n"); 
		query.append(", '' POR_CD" ).append("\n"); 
		query.append(", '' POL_CD" ).append("\n"); 
		query.append(", '' POD_CD" ).append("\n"); 
		query.append(", '' DEL_CD" ).append("\n"); 
		query.append(", '' RD" ).append("\n"); 
		query.append(", '' BKG_CUST_CD" ).append("\n"); 
		query.append(", '' BKG_CUST_NM" ).append("\n"); 
		query.append(", '' ACT_CUST_CD" ).append("\n"); 
		query.append(", '' ACT_CUST_NM" ).append("\n"); 
		query.append(", '' ISS_DT_PRN_FLG" ).append("\n"); 
		query.append(", '' CR_TERM_DYS" ).append("\n"); 
		query.append(", '' PAYER_CD" ).append("\n"); 
		query.append(", '' PAYER_NM" ).append("\n"); 
		query.append(", '' NTC_KNT_CD" ).append("\n"); 
		query.append(", '' OVER_DAY" ).append("\n"); 
		query.append(", '' DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(", '' CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append(", '' PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(", '' PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(", '' PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append(", '' TRUCKER_CD" ).append("\n"); 
		query.append(", '' TRUCKER_NM" ).append("\n"); 
		query.append(", '' INV_REF_NO" ).append("\n"); 
		query.append(", '' INV_RMK" ).append("\n"); 
		query.append(", '' INV_RMK1" ).append("\n"); 
		query.append(", '' INV_RMK2" ).append("\n"); 
		query.append(", '' CHG_CURR_CD" ).append("\n"); 
		query.append(", '' ORG_CHG_AMT" ).append("\n"); 
		query.append(", '' DMDT_EXPT_AMT" ).append("\n"); 
		query.append(", '' CHG_DC_AMT" ).append("\n"); 
		query.append(", '' BIL_AMT" ).append("\n"); 
		query.append(", '' AFT_INV_ADJ_AMT" ).append("\n"); 
		query.append(", '' INV_CURR_CD" ).append("\n"); 
		query.append(", '' INV_XCH_RT" ).append("\n"); 
		query.append(", '' CNTR_CNT" ).append("\n"); 
		query.append(", '' TOT_AMT" ).append("\n"); 
		query.append(", '' DC_AMT" ).append("\n"); 
		query.append(", '' INV_CHG_AMT" ).append("\n"); 
		query.append(", '' TAX_RTO" ).append("\n"); 
		query.append(", '' TAX_AMT" ).append("\n"); 
		query.append(", '' INV_AMT" ).append("\n"); 
		query.append(", '' CHG_TYPE" ).append("\n"); 
		query.append(", '' RFA_NO" ).append("\n"); 
		query.append(", '' ISSUE_DAY" ).append("\n"); 
		query.append(", '' OVER_DAY" ).append("\n"); 
		query.append(", '' NTC_KNT_CD" ).append("\n"); 
		query.append(", '' SVR_ID" ).append("\n"); 
		query.append(", '' BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append(", '' MNL_INV_SND_FLG" ).append("\n"); 
		query.append(", '' CNTR_NO" ).append("\n"); 
		query.append(", '' VSL_CD" ).append("\n"); 
		query.append(", '' SKD_VOY_NO" ).append("\n"); 
		query.append(", '' SKD_DIR_CD" ).append("\n"); 
		query.append(", '' VPS_PORT_CD" ).append("\n"); 
		query.append(", '' MN_ORG_CHG_AMT" ).append("\n"); 
		query.append(", '' MN_BIL_AMT" ).append("\n"); 
		query.append(", '' DUE_DATE" ).append("\n"); 
		query.append(", '' DMDT_CXL_RSN_CD" ).append("\n"); 
		query.append(", '' CXL_RMK" ).append("\n"); 
		query.append(", '' INV_HLD_RSN_CD" ).append("\n"); 
		query.append(", '' INV_HLD_RMK" ).append("\n"); 
		query.append(", '' DMDT_CXL_RSN_NM" ).append("\n"); 
		query.append(", '' INV_HLD_RSN_NM" ).append("\n"); 
		query.append(", '' UPD_DT" ).append("\n"); 
		query.append(", '' UPD_OFC_CD" ).append("\n"); 
		query.append(", '' MNL_INV_RMK" ).append("\n"); 
		query.append(", '' FAX_EMAIL_SND_CNT" ).append("\n"); 
		query.append(", '' CR_AR_YN" ).append("\n"); 
		query.append(", '' INV_TAX_RTO" ).append("\n"); 
		query.append(", '' VNDR_SEQ" ).append("\n"); 
		query.append(", '' VNDR_NM" ).append("\n"); 
		query.append(", '' CALLER" ).append("\n"); 
		query.append(", '' INV_PRT_FLG" ).append("\n"); 
		query.append(", '' CNT_CD" ).append("\n"); 
		query.append(", '' USE_RT_CURR" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}