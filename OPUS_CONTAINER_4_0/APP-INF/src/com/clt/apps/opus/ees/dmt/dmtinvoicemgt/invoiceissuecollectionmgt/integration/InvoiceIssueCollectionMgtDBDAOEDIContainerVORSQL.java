/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOEDIContainerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.01.07 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOEDIContainerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDIContainerVO
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOEDIContainerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOEDIContainerVORSQL").append("\n"); 
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
		query.append("SELECT '' BKG_NO" ).append("\n"); 
		query.append(",'' SVR_ID" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CNTR_CYC_NO" ).append("\n"); 
		query.append(",'' FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",'' INVOICE_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}