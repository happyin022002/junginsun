/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOCancelInvoiceParamVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.15 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOCancelInvoiceParamVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOCancelInvoiceParamVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOCancelInvoiceParamVORSQL").append("\n"); 
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
		query.append("'' AS DMDT_INV_NO" ).append("\n"); 
		query.append(",'' AS CRE_OFC_CD" ).append("\n"); 
		query.append(",'' AS DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' AS DMDT_CXL_RSN_CD" ).append("\n"); 
		query.append(",'' AS CXL_RMK" ).append("\n"); 
		query.append(",'' AS INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",'' AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}