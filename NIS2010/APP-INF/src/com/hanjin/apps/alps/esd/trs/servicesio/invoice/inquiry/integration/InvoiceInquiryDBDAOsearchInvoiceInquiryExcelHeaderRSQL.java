/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceInquiryDBDAOsearchInvoiceInquiryExcelHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryDBDAOsearchInvoiceInquiryExcelHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Inquiry Excel Header 정보를 조회 한다.
	  * </pre>
	  */
	public InvoiceInquiryDBDAOsearchInvoiceInquiryExcelHeaderRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryDBDAOsearchInvoiceInquiryExcelHeaderRSQL").append("\n"); 
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
		query.append("SELECT  VD.VNDR_SEQ                                AS VNDR_CODE" ).append("\n"); 
		query.append(", NVL(VD.VNDR_LGL_ENG_NM,'')                 AS FULL_NAME" ).append("\n"); 
		query.append(", NVL(VD.ENG_ADDR,'')                        AS ENG_ADDR" ).append("\n"); 
		query.append(", NVL(VD_CNTC.PHN_NO,'')                     AS PHN_NO" ).append("\n"); 
		query.append(", NVL(VD_CNTC.FAX_NO ,'')                    AS FAX_NO" ).append("\n"); 
		query.append(", NVL(VD.CNTC_PSON_NM,'')                    AS CNTC_PSON_NM" ).append("\n"); 
		query.append("FROM  MDM_VENDOR  			  	 VD" ).append("\n"); 
		query.append(",MDM_VNDR_CNTC_PNT			 VD_CNTC" ).append("\n"); 
		query.append("WHERE VD.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND VD.VNDR_SEQ                             = VD_CNTC.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND VD_CNTC.PRMRY_CHK_FLG (+)               = 'Y'" ).append("\n"); 
		query.append("AND VD_CNTC.PHN_NO (+)                      IS NOT NULL" ).append("\n"); 
		query.append("AND VD.DELT_FLG                             = 'N'" ).append("\n"); 
		query.append("AND VD_CNTC.DELT_FLG (+)                    = 'N'" ).append("\n"); 

	}
}