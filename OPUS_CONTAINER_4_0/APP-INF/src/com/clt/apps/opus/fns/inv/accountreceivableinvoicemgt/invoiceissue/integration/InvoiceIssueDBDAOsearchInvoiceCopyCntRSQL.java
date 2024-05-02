/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchInvoiceCopyCntRSQL.java
*@FileTitle : AccountReceivableInvoiceMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.17 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOsearchInvoiceCopyCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOsearchInvoiceCopyCntRSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchInvoiceCopyCntRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT CPY_INV_KNT COPY_CNT" ).append("\n"); 
		query.append("FROM INV_AR_STUP_OFC" ).append("\n"); 
		query.append("WHERE AR_OFC_CD = @[ofc_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchInvoiceCopyCntRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}