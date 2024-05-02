/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAOSearchInvoiceConfrimAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.09.10 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryCorrectionDBDAOSearchInvoiceConfrimAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO의 Invoice Total Amt를 가져온다.
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAOSearchInvoiceConfrimAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_INV_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryCorrectionDBDAOSearchInvoiceConfrimAmtRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("SUM( NVL(B.INV_BZC_AMT,0)" ).append("\n"); 
		query.append("+ NVL(B.INV_ETC_ADD_AMT,0)) INV_TOT_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_INV_WRK A" ).append("\n"); 
		query.append(",		TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.INV_NO 		= @[FORM_INV_NO]" ).append("\n"); 
		query.append("AND	A.INV_VNDR_SEQ	= @[FORM_INV_VNDR_SEQ]" ).append("\n"); 
		query.append("AND 	A.INV_NO 	= B.INV_NO" ).append("\n"); 
		query.append("AND 	A.INV_VNDR_SEQ 	= B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND 	B.TRSP_INV_ACT_STS_CD 	= 'C'" ).append("\n"); 
		query.append("/* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("AND   A.HJL_NO IS NULL" ).append("\n"); 
		query.append("AND   B.HJL_NO IS NULL" ).append("\n"); 

	}
}