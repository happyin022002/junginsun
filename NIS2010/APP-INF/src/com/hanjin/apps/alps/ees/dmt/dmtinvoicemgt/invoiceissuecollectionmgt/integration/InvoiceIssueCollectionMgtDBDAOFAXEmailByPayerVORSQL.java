/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOFAXEmailByPayerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.12.17 김태균
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

public class InvoiceIssueCollectionMgtDBDAOFAXEmailByPayerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FAX EMAIL VO
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOFAXEmailByPayerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOFAXEmailByPayerVORSQL").append("\n"); 
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
		query.append("'' AS PAYER_CD" ).append("\n"); 
		query.append(",'' AS PAYER_GUBUN" ).append("\n"); 
		query.append(",'' AS OFC_CD" ).append("\n"); 
		query.append(",'' AS DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' AS IO_BND_CD" ).append("\n"); 
		query.append(",'' AS FAX" ).append("\n"); 
		query.append(",'' AS EMAIL" ).append("\n"); 
		query.append(",'' AS FAX_NOS" ).append("\n"); 
		query.append(",'' AS EMAIL_NOS" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}