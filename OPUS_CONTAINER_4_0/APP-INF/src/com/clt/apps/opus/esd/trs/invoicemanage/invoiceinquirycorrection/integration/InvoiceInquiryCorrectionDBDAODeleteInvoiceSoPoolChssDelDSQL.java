/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAODeleteInvoiceSoPoolChssDelDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.27
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.12.27 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryCorrectionDBDAODeleteInvoiceSoPoolChssDelDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Pool Chassis Reposition 정보를 삭제
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAODeleteInvoiceSoPoolChssDelDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryCorrectionDBDAODeleteInvoiceSoPoolChssDelDSQL").append("\n"); 
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
		query.append("DELETE FROM TRS_TRSP_POOL_CHSS_INV" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("INV_NO			= @[inv_no]" ).append("\n"); 
		query.append("AND INV_VNDR_SEQ	= @[inv_vndr_seq]" ).append("\n"); 

	}
}