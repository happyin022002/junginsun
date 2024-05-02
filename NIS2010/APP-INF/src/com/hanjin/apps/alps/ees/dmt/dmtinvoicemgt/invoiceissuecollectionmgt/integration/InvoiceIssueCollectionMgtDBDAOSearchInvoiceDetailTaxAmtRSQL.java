/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailTaxAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.01.13 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailTaxAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Detail의 Tax Amt를 구한다.
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailTaxAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtl_tax_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailTaxAmtRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN (SELECT SUBSTR(LOC_CD,1,2) " ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                  WHERE OFC_CD = A.CRE_OFC_CD) = 'VN' THEN ((A.CNTR_INV_AMT / (1 - @[dtl_tax_rto] * 0.01)) * (@[dtl_tax_rto] * 0.01))" ).append("\n"); 
		query.append("            ELSE ((@[dtl_tax_rto] * 0.01) * A.CNTR_INV_AMT )" ).append("\n"); 
		query.append("            END AS CALC_TAX_AMT" ).append("\n"); 
		query.append("FROM DMT_INV_DTL A" ).append("\n"); 
		query.append("WHERE DMDT_INV_NO	= @[invoice_no] " ).append("\n"); 
		query.append("AND CRE_OFC_CD 		= @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND INV_DTL_SEQ 	= @[inv_dtl_seq]" ).append("\n"); 

	}
}