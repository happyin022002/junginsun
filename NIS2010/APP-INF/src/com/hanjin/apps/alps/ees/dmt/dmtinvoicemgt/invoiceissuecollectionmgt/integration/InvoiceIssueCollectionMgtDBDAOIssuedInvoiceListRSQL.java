/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOIssuedInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.20
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.05.20 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOIssuedInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Issued Invoice Inquiry List리턴 VO
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOIssuedInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOIssuedInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT  '' AS DMDT_INV_NO" ).append("\n"); 
		query.append("		,'' AS INV_PRT_FLG" ).append("\n"); 
		query.append("		,'' AS DMDT_AR_IF_CD" ).append("\n"); 
		query.append("		,'' AS DMDT_INV_STS_CD" ).append("\n"); 
		query.append("		,'' AS DMDT_TRF_CD" ).append("\n"); 
		query.append("		,'' AS BKG_NO" ).append("\n"); 
		query.append("		,'' AS BL_NO" ).append("\n"); 
		query.append("		,'' AS CNTR_NO" ).append("\n"); 
		query.append("		,'' AS FT_DYS" ).append("\n"); 
		query.append("		,'' AS SC_NO" ).append("\n"); 
		query.append("		,'' AS RFA_NO" ).append("\n"); 
		query.append("		,'' AS CHG_CURR_CD" ).append("\n"); 
		query.append("		,'' AS ORG_CHG_AMT" ).append("\n"); 
		query.append("		,'' AS DMDT_EXPT_AMT" ).append("\n"); 
		query.append("		,'' AS DC_AMT" ).append("\n"); 
		query.append("		,'' AS BIL_AMT" ).append("\n"); 
		query.append("		,'' AS INV_CURR_CD" ).append("\n"); 
		query.append("		,'' AS INV_CHG_AMT" ).append("\n"); 
		query.append("		,'' AS TAX_AMT" ).append("\n"); 
		query.append("		,'' AS INV_AMT" ).append("\n"); 
		query.append("		,'' AS PORT" ).append("\n"); 
		query.append("		,'' AS CRE_DT" ).append("\n"); 
		query.append("		,'' AS CRE_OFC_CD" ).append("\n"); 
		query.append("		,'' AS ISSUE_ID" ).append("\n"); 
		query.append("		,'' AS ISSUE_NM" ).append("\n"); 
		query.append("		,'' AS AR_IF_DT" ).append("\n"); 
		query.append("		,'' AS AR_IF_OFC_CD" ).append("\n"); 
		query.append("		,'' AS AR_IF_USR_ID" ).append("\n"); 
		query.append("		,'' AS AR_IF_USR_NM" ).append("\n"); 
		query.append("		,'' AS INV_OVER" ).append("\n"); 
		query.append("		,'' AS ACT_PAYR_CD" ).append("\n"); 
		query.append("		,'' AS ACT_PAYR_NM" ).append("\n"); 
		query.append("		,'' AS CR_INV_NO" ).append("\n"); 
		query.append("		,'' AS CTRT_OFC" ).append("\n"); 
		query.append("		,'' AS ACT_DELT_FLG" ).append("\n"); 
		query.append("		,'' AS AR_IF_NO" ).append("\n"); 
		query.append("		,'' AS INV_RMK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}