/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchBKGInterfaceCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchBKGInterfaceCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search BKG Interface Count
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchBKGInterfaceCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchBKGInterfaceCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(BKG_NO) CNT" ).append("\n"); 
		query.append("FROM INV_BKG_IF_MN" ).append("\n"); 
		query.append("WHERE BKG_NO IN ( SELECT BKG_NO FROM INV_AR_MN WHERE BL_SRC_NO IN (${bl_nos}) )" ).append("\n"); 
		query.append("AND INV_BAT_CD <> 'Y'" ).append("\n"); 

	}
}