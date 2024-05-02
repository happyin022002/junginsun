/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineVndrInvNoDupCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.14 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineVndrInvNoDupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineVndrInvNoDupCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineVndrInvNoDupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineVndrInvNoDupCheckRSQL").append("\n"); 
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
		query.append("      SELECT  'Duplicated Of Vendor Invoice No :' || VENDOR_INVOICE_NO || ' [' || INVOICE_NUM || ']' AS VNDR_DUP_REASON" ).append("\n"); 
		query.append("      FROM    (SELECT SID.ATTR_CTNT1    AS VENDOR_INVOICE_NO" ).append("\n"); 
		query.append("                    , SIH.INV_NO        AS INVOICE_NUM" ).append("\n"); 
		query.append("               FROM   SAP_INV_DTL SID" ).append("\n"); 
		query.append("                    , SAP_INV_HDR SIH" ).append("\n"); 
		query.append("               WHERE  SID.INV_SEQ = SIH.INV_SEQ" ).append("\n"); 
		query.append("               AND    SIH.VNDR_NO = (SELECT  MV.VNDR_SEQ" ).append("\n"); 
		query.append("                                     FROM    MDM_VENDOR MV" ).append("\n"); 
		query.append("                                     WHERE   MV.VNDR_SEQ = @[vndr_no]" ).append("\n"); 
		query.append("                                     AND     ROWNUM = 1)" ).append("\n"); 
		query.append("               AND    SIH.INV_NO <> NVL(@[csr_no], 'xxx')   " ).append("\n"); 
		query.append("               AND    SIH.INV_TP_LU_CD = 'STANDARD'" ).append("\n"); 
		query.append("               AND    SIH.ATTR_CATE_NM = 'Invoices'" ).append("\n"); 
		query.append("               AND    SIH.INV_CXL_DT IS NULL ) DUP_VENDOR_INVOICE" ).append("\n"); 
		query.append("      WHERE   VENDOR_INVOICE_NO = @[attr_ctnt1]  " ).append("\n"); 
		query.append("      AND     ROWNUM = 1" ).append("\n"); 

	}
}