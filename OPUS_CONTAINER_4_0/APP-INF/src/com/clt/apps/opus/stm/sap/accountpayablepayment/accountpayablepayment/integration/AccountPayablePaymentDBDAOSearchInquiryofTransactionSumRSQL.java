/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchInquiryofTransactionSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchInquiryofTransactionSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInquiryofTransactionSum
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchInquiryofTransactionSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchInquiryofTransactionSumRSQL").append("\n"); 
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
		query.append("SELECT TRIM(SAP_GET_CUR_AMT_FNC(STI.CURRENCY_CODE, SUM(STI.PAYMENT_AMOUNT)))   AS PAYMENT_AMOUNT" ).append("\n"); 
		query.append("     , TRIM(SAP_GET_CUR_AMT_FNC(STI.CURRENCY_CODE, SUM(STI.RECEIPT_AMOUNT)))   AS RECEIPT_AMOUNT" ).append("\n"); 
		query.append("FROM   SAP_TRX_INQ_V STI" ).append("\n"); 
		query.append("WHERE  STI.BANK_ACCOUNT_SEQ = @[bank_acct_seq]" ).append("\n"); 
		query.append("AND    STI.CLEARED_DATE >= TO_DATE(REPLACE(@[fr_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND    STI.CLEARED_DATE <  TO_DATE(REPLACE(@[to_dt],'-',''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("GROUP BY STI.CURRENCY_CODE" ).append("\n"); 

	}
}