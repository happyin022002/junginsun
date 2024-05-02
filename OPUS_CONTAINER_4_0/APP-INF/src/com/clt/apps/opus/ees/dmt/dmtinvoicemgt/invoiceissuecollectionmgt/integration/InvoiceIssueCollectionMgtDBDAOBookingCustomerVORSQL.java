/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOBookingCustomerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.23 
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

public class InvoiceIssueCollectionMgtDBDAOBookingCustomerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회된 Booking Customer 정보를 저장하기 위한 VO 객체
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOBookingCustomerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOBookingCustomerVORSQL").append("\n"); 
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
		query.append("SELECT	BKG_NO" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	CUST_NM" ).append("\n"); 
		query.append(",	'' CUST_CD_C" ).append("\n"); 
		query.append(",	'' CUST_CD_S" ).append("\n"); 
		query.append(",	'' CUST_CD_N" ).append("\n"); 
		query.append(",	'' CUST_NM_C" ).append("\n"); 
		query.append(",	'' CUST_NM_S" ).append("\n"); 
		query.append(",	'' CUST_NM_N" ).append("\n"); 
		query.append("FROM	BKG_CUSTOMER" ).append("\n"); 

	}
}