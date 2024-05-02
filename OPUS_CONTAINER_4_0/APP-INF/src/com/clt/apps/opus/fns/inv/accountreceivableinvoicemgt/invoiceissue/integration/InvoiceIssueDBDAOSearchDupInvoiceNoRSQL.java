/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchDupInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.14 
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

public class InvoiceIssueDBDAOSearchDupInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Dup Invoice No
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchDupInvoiceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchDupInvoiceNoRSQL").append("\n"); 
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
		query.append("SELECT A.BL_SRC_NO" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("     INV_AR_STUP_OFC B," ).append("\n"); 
		query.append("	 INV_AR_ISS_DTL C" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("AND A.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("AND (B.OTS_SMRY_CD = 'INV' OR (B.OTS_SMRY_CD = 'BL' AND B.INV_DUP_FLG = 'N'))" ).append("\n"); 
		query.append("AND A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND A.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY A.BL_SRC_NO" ).append("\n"); 
		query.append("HAVING COUNT(DISTINCT C.INV_NO) > 1" ).append("\n"); 

	}
}