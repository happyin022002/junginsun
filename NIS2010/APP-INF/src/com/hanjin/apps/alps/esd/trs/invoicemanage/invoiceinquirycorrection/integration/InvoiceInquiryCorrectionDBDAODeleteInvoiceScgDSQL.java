/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAODeleteInvoiceScgDSQL.java
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

public class InvoiceInquiryCorrectionDBDAODeleteInvoiceScgDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge 정보를 삭제
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAODeleteInvoiceScgDSQL(){
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
		query.append("FileName : InvoiceInquiryCorrectionDBDAODeleteInvoiceScgDSQL").append("\n"); 
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
		query.append("DELETE FROM TRS_TRSP_SCG_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("TRSP_SO_SEQ	IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TRSP_SO_SEQ FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("INV_NO			= @[inv_no]" ).append("\n"); 
		query.append("AND INV_VNDR_SEQ	= @[inv_vndr_seq]" ).append("\n"); 
		query.append("/* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("AND HJL_NO IS NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND 	   NVL(SCG_AMT, 0)	= 0" ).append("\n"); 
		query.append("/* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("AND HJL_NO IS NULL" ).append("\n"); 

	}
}