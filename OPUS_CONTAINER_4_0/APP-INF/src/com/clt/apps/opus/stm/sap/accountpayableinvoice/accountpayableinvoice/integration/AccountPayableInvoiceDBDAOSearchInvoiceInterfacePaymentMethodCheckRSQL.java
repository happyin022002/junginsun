/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfacePaymentMethodCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.29 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfacePaymentMethodCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfacePaymentMethodCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfacePaymentMethodCheckRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfacePaymentMethodCheckRSQL").append("\n"); 
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
		query.append("SELECT   NVL(DECODE(MV.PAY_MZD_CD, 'CSH', 'CASH'" ).append("\n"); 
		query.append("                                 , 'CHK', 'CHECK'" ).append("\n"); 
		query.append("                                 , 'CKG', 'CHECK(G/EXP)'" ).append("\n"); 
		query.append("                                 , 'CKO', 'CHECK(O/EXP)'" ).append("\n"); 
		query.append("                                 , 'CLE', 'CLEARING'" ).append("\n"); 
		query.append("                                 , 'CMA', 'CMS ACH'" ).append("\n"); 
		query.append("                                 , 'CMG', 'CMS CHECK(G/EXP)'" ).append("\n"); 
		query.append("                                 , 'CMO', 'CMS CHECK(O/EXP)'" ).append("\n"); 
		query.append("                                 , 'CMW', 'CMS WIRE'" ).append("\n"); 
		query.append("                                 , 'EFT', 'EFT'" ).append("\n"); 
		query.append("                                 , 'WIR', 'WIRE'" ).append("\n"); 
		query.append("                                 , 'AUD', 'AUTO DEBIT'" ).append("\n"); 
		query.append("                                 , 'ICO', 'CMS ICO'" ).append("\n"); 
		query.append("                                 , 'IDD', 'CMS IDD'" ).append("\n"); 
		query.append("                                 , MV.PAY_MZD_CD), MV.PAY_MZD_CD) AS PAYMENT_METHOD  " ).append("\n"); 
		query.append("       , MV.PAY_TERM_TP_CD AS PAY_TERM_TP_CD" ).append("\n"); 
		query.append("       , NVL(MV.BANK_ACCT_FLG, 'N') AS BANK_ACCT_FLG" ).append("\n"); 
		query.append("FROM     MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE    MV.VNDR_SEQ = TO_NUMBER(@[vndr_no])" ).append("\n"); 
		query.append("AND      NVL(MV.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}