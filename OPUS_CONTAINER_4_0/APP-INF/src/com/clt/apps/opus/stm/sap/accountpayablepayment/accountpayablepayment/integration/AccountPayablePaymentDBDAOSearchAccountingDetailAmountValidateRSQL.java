/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountingDetailAmountValidateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : ORKIM
*@LastVersion : 1.0
* 2014.05.22 ORKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ORKIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchAccountingDetailAmountValidateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAccountingDetailAmountValidate
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountingDetailAmountValidateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountingDetailAmountValidateRSQL").append("\n"); 
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
		query.append("SELECT  SUM(NVL(SAED.INP_DR_AMT, 0))   AS ENTERED_DR_SUM" ).append("\n"); 
		query.append("      , SUM(NVL(SAED.INP_CR_AMT, 0))   AS ENTERED_CR_SUM" ).append("\n"); 
		query.append("      , SUM(NVL(SAED.ACCT_DR_AMT, 0))  AS ACCOUNTED_DR_SUM" ).append("\n"); 
		query.append("      , SUM(NVL(SAED.ACCT_CR_AMT, 0))  AS ACCOUNTED_CR_SUM" ).append("\n"); 
		query.append("FROM    SAP_ACCTG_EVNT_DTL SAED" ).append("\n"); 
		query.append("WHERE   SAED.ACCTG_HDR_SEQ = @[acctg_hdr_seq]" ).append("\n"); 

	}
}