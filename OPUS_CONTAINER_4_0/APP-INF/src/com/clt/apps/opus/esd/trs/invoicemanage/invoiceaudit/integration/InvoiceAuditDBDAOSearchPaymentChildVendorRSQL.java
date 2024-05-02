/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchPaymentChildVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.07
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.12.07 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchPaymentChildVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WO SP의 PaymentChildVendor 를 가져온다
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchPaymentChildVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchPaymentChildVendorRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("	F.VNDR_SEQ		" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("	MDM_VENDOR F	" ).append("\n"); 
		query.append("WHERE	" ).append("\n"); 
		query.append("	F.VNDR_SEQ	= @[vndr_seq]		" ).append("\n"); 
		query.append("UNION	" ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("	F.VNDR_SEQ		" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("	MDM_VENDOR F	" ).append("\n"); 
		query.append("WHERE	" ).append("\n"); 
		query.append("	F.PRNT_VNDR_SEQ	= @[vndr_seq]" ).append("\n"); 

	}
}