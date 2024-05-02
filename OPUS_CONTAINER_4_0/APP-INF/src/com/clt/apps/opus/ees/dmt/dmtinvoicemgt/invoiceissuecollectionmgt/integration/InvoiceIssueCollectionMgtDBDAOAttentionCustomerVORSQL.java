/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOAttentionCustomerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOAttentionCustomerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회된 Attention Customer 정보를 저장하는 VO 객체 생성용 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOAttentionCustomerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOAttentionCustomerVORSQL").append("\n"); 
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
		query.append("SELECT	DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",	PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",	PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",	PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append("FROM	DMT_PAYR_CNTC_PNT" ).append("\n"); 

	}
}