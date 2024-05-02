/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOConfirmChargeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.14 
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

public class InvoiceIssueCollectionMgtDBDAOConfirmChargeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOConfirmChargeListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOConfirmChargeListVORSQL").append("\n"); 
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
		query.append("SELECT '' AS CHECK_BOX" ).append("\n"); 
		query.append(", '' AS CHECK_SEQ" ).append("\n"); 
		query.append(", '' AS BKG_NO" ).append("\n"); 
		query.append(", '' AS BL_NO" ).append("\n"); 
		query.append(", '' AS CNTR_CNT" ).append("\n"); 
		query.append(", '' AS GB" ).append("\n"); 
		query.append(", '' AS CNTR_NO" ).append("\n"); 
		query.append(", '' AS OFC_CD" ).append("\n"); 
		query.append(", '' AS DMDT_TRF_CD" ).append("\n"); 
		query.append(", '' AS ACT_CNT_CD" ).append("\n"); 
		query.append(", '' AS ACT_CUST_SEQ" ).append("\n"); 
		query.append(", '' AS CUST_CD" ).append("\n"); 
		query.append(", '' AS CUST_NM" ).append("\n"); 
		query.append(", '' AS SC_NO" ).append("\n"); 
		query.append(", '' AS RFA_NO" ).append("\n"); 
		query.append(", '' AS AR_CURR_CD" ).append("\n"); 
		query.append(", '' AS VSL_CD" ).append("\n"); 
		query.append(", '' AS SKD_VOY_NO" ).append("\n"); 
		query.append(", '' AS SKD_DIR_CD" ).append("\n"); 
		query.append(", '' AS POL_CD" ).append("\n"); 
		query.append(", '' AS POD_CD" ).append("\n"); 
		query.append(", '' AS POR_CD" ).append("\n"); 
		query.append(", '' AS DEL_CD" ).append("\n"); 
		query.append(", '' AS INV_AMT" ).append("\n"); 
		query.append(", '' AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(", '' AS ORG_CHG_AMT" ).append("\n"); 
		query.append(", '' AS SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append(", '' AS AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(", '' AS BIL_AMT" ).append("\n"); 
		query.append(", '' AS INV_XCH_RT" ).append("\n"); 
		query.append(", '' AS DMDT_INV_NO" ).append("\n"); 
		query.append(", '' AS DMDT_INV_STS_CD" ).append("\n"); 
		query.append(", '' AS DMDT_AR_IF_CD" ).append("\n"); 
		query.append(", '' AS INV_TAX_RTO" ).append("\n"); 
		query.append(", '' AS INV_TAX_AMT" ).append("\n"); 
		query.append(", '' AS INV_PAYABLE_AMT" ).append("\n"); 
		query.append(", '' AS ERR_CODE" ).append("\n"); 
		query.append(", '' AS ERR_MSG" ).append("\n"); 
		query.append(", '' AS CHG_CUST_CNT_CD" ).append("\n"); 
		query.append(", '' AS CHG_CUST_SEQ" ).append("\n"); 
		query.append(", '' AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}