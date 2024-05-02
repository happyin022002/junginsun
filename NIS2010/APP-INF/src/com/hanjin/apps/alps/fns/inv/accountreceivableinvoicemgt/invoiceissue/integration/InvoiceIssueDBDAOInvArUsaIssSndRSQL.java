/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvArUsaIssSndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.02.02 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOInvArUsaIssSndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvArUsaIssSnd
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvArUsaIssSndRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvArUsaIssSndRSQL").append("\n"); 
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
		query.append("SELECT BL_SRC_NO" ).append("\n"); 
		query.append(",SND_SEQ" ).append("\n"); 
		query.append(",INV_ISS_SND_TP_CD" ).append("\n"); 
		query.append(",INV_SND_CUST_NO" ).append("\n"); 
		query.append(",INV_SND_DT" ).append("\n"); 
		query.append(",INV_SND_NO" ).append("\n"); 
		query.append(",AR_OFC_CD" ).append("\n"); 
		query.append(",SAIL_ARR_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT FROM INV_AR_USA_ISS_SND" ).append("\n"); 

	}
}