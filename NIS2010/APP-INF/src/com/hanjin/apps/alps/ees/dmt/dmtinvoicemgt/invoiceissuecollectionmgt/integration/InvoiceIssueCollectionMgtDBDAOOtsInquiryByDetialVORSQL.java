/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOOtsInquiryByDetialVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOOtsInquiryByDetialVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO생성
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOOtsInquiryByDetialVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOOtsInquiryByDetialVORSQL").append("\n"); 
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
		query.append("'' isseof" ).append("\n"); 
		query.append(",'' blnooo" ).append("\n"); 
		query.append(",'' bilamt" ).append("\n"); 
		query.append(",'' payrcd" ).append("\n"); 
		query.append(",'' tarftp" ).append("\n"); 
		query.append(",'' comamt" ).append("\n"); 
		query.append(",'' invnoo" ).append("\n"); 
		query.append(",'' issedt" ).append("\n"); 
		query.append(",'' invamt" ).append("\n"); 
		query.append(",'' currcy" ).append("\n"); 
		query.append(",'' sheetp" ).append("\n"); 
		query.append(",'' taxamt" ).append("\n"); 
		query.append(",'' invovd" ).append("\n"); 
		query.append(",'' bkgnoo" ).append("\n"); 
		query.append(",'' vvdcdd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}