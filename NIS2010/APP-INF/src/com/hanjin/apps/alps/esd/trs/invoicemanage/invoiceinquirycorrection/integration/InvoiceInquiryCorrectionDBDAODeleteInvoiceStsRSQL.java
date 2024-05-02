/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAODeleteInvoiceStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.09.10 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryCorrectionDBDAODeleteInvoiceStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Delete 가능여부 조회
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAODeleteInvoiceStsRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration ").append("\n"); 
		query.append("FileName : InvoiceInquiryCorrectionDBDAODeleteInvoiceStsRSQL").append("\n"); 
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
		query.append("SELECT INV_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_WRK" ).append("\n"); 
		query.append("WHERE INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("AND INV_VNDR_SEQ        = @[inv_vndr_seq]" ).append("\n"); 
		query.append("AND TRSP_INV_AUD_STS_CD NOT IN ('RC','SV','CF')" ).append("\n"); 
		query.append("AND HJL_NO IS NULL" ).append("\n"); 

	}
}