/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOCheckSZPBBInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.01.27 김태균
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

public class InvoiceIssueCollectionMgtDBDAOCheckSZPBBInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SZPBB를 통하여 INVOICE 생성여부 체크
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOCheckSZPBBInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOCheckSZPBBInvoiceRSQL").append("\n"); 
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
		query.append("SELECT SUTH_CHN_ISS_FLG" ).append("\n"); 
		query.append("FROM DMT_INV_MN" ).append("\n"); 
		query.append("WHERE DMDT_INV_NO = @[invoice_no]" ).append("\n"); 

	}
}