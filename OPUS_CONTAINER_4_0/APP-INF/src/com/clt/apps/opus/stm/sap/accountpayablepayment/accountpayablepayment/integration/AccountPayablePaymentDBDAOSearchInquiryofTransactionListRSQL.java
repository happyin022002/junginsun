/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchInquiryofTransactionListRSQL.java
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

public class AccountPayablePaymentDBDAOSearchInquiryofTransactionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry of Transaction
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchInquiryofTransactionListRSQL(){
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
		query.append("FileName : AccountPayablePaymentDBDAOSearchInquiryofTransactionListRSQL").append("\n"); 
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
		query.append("SELECT STI.TYPE_MEANING" ).append("\n"); 
		query.append("     , STI.BANK_ACCOUNT_SEQ    -- Hidden" ).append("\n"); 
		query.append("     , STI.TRX_NUMBER" ).append("\n"); 
		query.append("     , STI.CURRENCY_CODE" ).append("\n"); 
		query.append("     , TRIM(SAP_GET_CUR_AMT_FNC(STI.CURRENCY_CODE, STI.AMOUNT)) AMOUNT" ).append("\n"); 
		query.append("     , STI.CAL_AMOUNT          -- Hidden" ).append("\n"); 
		query.append("     , STI.PAYMENT_AMOUNT      -- Hidden" ).append("\n"); 
		query.append("     , STI.RECEIPT_AMOUNT      -- Hidden" ).append("\n"); 
		query.append("     , TO_CHAR(STI.CLEARED_DATE, 'YYYY-MM-DD') AS CLEARED_DATE" ).append("\n"); 
		query.append("     , STI.AGENT_NAME" ).append("\n"); 
		query.append("     , STI.BATCH_NAME" ).append("\n"); 
		query.append("     , STI.SOURCE" ).append("\n"); 
		query.append("     , STI.TRANSACTION_ID      -- Hidden" ).append("\n"); 
		query.append("     , STI.DESCRIPTION" ).append("\n"); 
		query.append("     , STI.EXCHANGE_RATE" ).append("\n"); 
		query.append("     , TRIM(SAP_GET_CUR_AMT_FNC(STI.CURRENCY_CODE, STI.LCL_AMOUNT)) LCL_AMOUNT" ).append("\n"); 
		query.append("     , STI.CAL_LCL_AMOUNT      -- Hidden" ).append("\n"); 
		query.append("     , STI.PAYMENT_LCL_AMOUNT  -- Hidden" ).append("\n"); 
		query.append("     , STI.RECEIPT_LCL_AMOUNT  -- Hidden" ).append("\n"); 
		query.append("     , STI.REFERENCE_TYPE" ).append("\n"); 
		query.append("     , STI.REFERENCE_NUMBER    " ).append("\n"); 
		query.append("     , STI.SLIP_STATUS         -- Hidden" ).append("\n"); 
		query.append("     ,(SELECT DP_PRCS_KNT FROM MDM_CURRENCY MC WHERE MC.CURR_CD = STI.CURRENCY_CODE AND DELT_FLG = 'N' AND ROWNUM=1) AS CURR_POINT " ).append("\n"); 
		query.append("FROM   SAP_TRX_INQ_V STI" ).append("\n"); 
		query.append("WHERE  STI.BANK_ACCOUNT_SEQ = @[bank_acct_seq]" ).append("\n"); 
		query.append("AND    STI.CLEARED_DATE >= TO_DATE(REPLACE(@[fr_dt],'-','') , 'YYYYMMDD')" ).append("\n"); 
		query.append("AND    STI.CLEARED_DATE <  TO_DATE(REPLACE(@[to_dt],'-',''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("ORDER  BY STI.CLEARED_DATE, STI.TYPE_MEANING, STI.SOURCE" ).append("\n"); 

	}
}