/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchInquiryofTrxBeginBalanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.10 
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

public class AccountPayablePaymentDBDAOSearchInquiryofTrxBeginBalanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInquiryofTrxBeginBalance
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchInquiryofTrxBeginBalanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : AccountPayablePaymentDBDAOSearchInquiryofTrxBeginBalanceRSQL").append("\n"); 
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
		query.append("SELECT  SBBA.CTRL_BGN_BAL_AMT " ).append("\n"); 
		query.append("FROM    SAP_BANK_BAL_ADJ SBBA" ).append("\n"); 
		query.append("WHERE   SBBA.BANK_ACCT_SEQ  = @[bank_acct_seq]" ).append("\n"); 
		query.append("AND     SBBA.BANK_STMT_DT IN (SELECT  MAX(SBBA2.BANK_STMT_DT)" ).append("\n"); 
		query.append("                              FROM    SAP_BANK_BAL_ADJ SBBA2" ).append("\n"); 
		query.append("                              WHERE   SBBA2.BANK_ACCT_SEQ = @[bank_acct_seq]" ).append("\n"); 
		query.append("                              AND     SBBA2.BANK_STMT_DT <= TO_DATE(REPLACE(@[fr_dt],'-',''), 'YYYYMMDD'))" ).append("\n"); 

	}
}