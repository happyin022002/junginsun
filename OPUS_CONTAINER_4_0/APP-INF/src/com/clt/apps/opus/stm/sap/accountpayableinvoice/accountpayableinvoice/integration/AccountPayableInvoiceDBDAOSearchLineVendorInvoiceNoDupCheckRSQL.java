/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchLineVendorInvoiceNoDupCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchLineVendorInvoiceNoDupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Input된 Header의 증빙 Type이 "Invoices" 이면, Line의 DFF 항목중 Vendor Invoice No 값은 중복으로 작성을 할 수 없는 Validation을 체크 한다. (동일 전표에서는 상관 없음)
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchLineVendorInvoiceNoDupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vendor_invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vendor_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchLineVendorInvoiceNoDupCheckRSQL").append("\n"); 
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
		query.append("SELECT 'E' AS VALUE1" ).append("\n"); 
		query.append("      ,'Duplicated Of Supplier Invoice No :' || VENDOR_INVOICE_NO || ' [' || INVOICE_NUM || ']' AS VALUE2" ).append("\n"); 
		query.append("FROM   (SELECT SID.ATTR_CTNT1    AS VENDOR_INVOICE_NO" ).append("\n"); 
		query.append("             , SIH.INV_NO        AS INVOICE_NUM" ).append("\n"); 
		query.append("        FROM   SAP_INV_DTL SID" ).append("\n"); 
		query.append("             , SAP_INV_HDR SIH" ).append("\n"); 
		query.append("        WHERE  SID.INV_SEQ = SIH.INV_SEQ" ).append("\n"); 
		query.append("        AND    SIH.VNDR_NO = (SELECT  MV.VNDR_SEQ" ).append("\n"); 
		query.append("                              FROM    MDM_VENDOR MV" ).append("\n"); 
		query.append("                              WHERE   MV.VNDR_SEQ = @[vendor_no]  " ).append("\n"); 
		query.append("                              AND     ROWNUM = 1)" ).append("\n"); 
		query.append("        AND    SIH.INV_NO <> NVL(@[inv_no], 'xxx')   " ).append("\n"); 
		query.append("        AND    SIH.INV_TP_LU_CD = 'STANDARD'" ).append("\n"); 
		query.append("        AND    SIH.ATTR_CATE_NM = 'INVOICES'" ).append("\n"); 
		query.append("        AND    SIH.INV_CXL_DT IS NULL " ).append("\n"); 
		query.append("        UNION  ALL" ).append("\n"); 
		query.append("        SELECT INV_NO_V.INV_NO   AS VENDOR_INVOICE_NO" ).append("\n"); 
		query.append("             , NVL(INV_NO_V.CSR_NO, INV_NO_V.REF_PK) AS INVOICE_NUM" ).append("\n"); 
		query.append("        FROM   AP_INV_NO_CHK_V INV_NO_V " ).append("\n"); 
		query.append("        WHERE  -- INV_NO_V.INV_NO = UPPER('JO_TPB_TEST')   AND  " ).append("\n"); 
		query.append("               INV_NO_V.VNDR_SEQ = @[vendor_no]  " ).append("\n"); 
		query.append("        AND    INV_NO_V.MDL_CD <> 'SAP'" ).append("\n"); 
		query.append("        AND    NVL(INV_NO_V.CSR_NO, 'yyy') <> NVL(@[inv_no], 'xxx') " ).append("\n"); 
		query.append("        ) DUP_VENDOR_INVOICE" ).append("\n"); 
		query.append("WHERE  VENDOR_INVOICE_NO = UPPER(@[vendor_invoice_no])  " ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}