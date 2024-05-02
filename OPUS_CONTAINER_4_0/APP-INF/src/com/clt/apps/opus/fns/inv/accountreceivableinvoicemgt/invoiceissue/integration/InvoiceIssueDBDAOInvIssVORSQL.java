/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvIssVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.01.07 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Han Dong Hoon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOInvIssVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssVO
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvIssVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvIssVORSQL").append("\n"); 
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
		query.append("SELECT	'' ISS_DT" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' USER_ID" ).append("\n"); 
		query.append(",'' INV_PFX_CD" ).append("\n"); 
		query.append(",'' INV_MAX_SEQ" ).append("\n"); 
		query.append(",'' WRK_NO" ).append("\n"); 
		query.append(",'' INV_SEQ" ).append("\n"); 
		query.append(",'' INV_MLT_BL_ISS_FLG" ).append("\n"); 
		query.append(",'' INV_DUP_FLG" ).append("\n"); 
		query.append(",'' OTS_SMRY_CD" ).append("\n"); 
		query.append(",'' INV_ISS_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}