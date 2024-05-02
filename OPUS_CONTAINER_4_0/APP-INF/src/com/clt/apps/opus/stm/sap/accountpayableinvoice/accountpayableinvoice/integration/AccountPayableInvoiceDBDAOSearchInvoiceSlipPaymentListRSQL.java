/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceSlipPaymentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceSlipPaymentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0030 Invoice Slip Inquiry - Invoice Payment List Retrieve
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceSlipPaymentListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceSlipPaymentListRSQL").append("\n"); 
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
		query.append("SELECT  SBA.BANK_ACCT_NO             AS BANK_ACCT_NO" ).append("\n"); 
		query.append("      , SPH.PAY_NO                   AS PAY_NO" ).append("\n"); 
		query.append("      , SPH.PAY_MZD_LU_CD            AS PAY_MZD_LU_CD" ).append("\n"); 
		query.append("      , DECODE(SPH.PAY_TP_CD, 'M', 'Manual', 'B', 'Batch') AS PAY_TP_CD" ).append("\n"); 
		query.append("      , SPH.DOC_SEQ                  AS DOC_SEQ" ).append("\n"); 
		query.append("      , SPH.CURR_CD                  AS CURR_CD" ).append("\n"); 
		query.append("      , SPH.PAY_DT                   AS PAY_DT" ).append("\n"); 
		query.append("      , SPD.ACCTG_PST_FLG            AS ACCTG_PST_FLG" ).append("\n"); 
		query.append("      , OPUSADM.SAP_GET_CUR_AMT_FNC(SPH.CURR_CD, SPD.PAY_AMT) AS PAY_AMT" ).append("\n"); 
		query.append("FROM    SAP_PAY_HDR SPH" ).append("\n"); 
		query.append("      , SAP_PAY_DTL SPD" ).append("\n"); 
		query.append("      , SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("WHERE   SPH.PAY_SEQ = SPD.PAY_SEQ" ).append("\n"); 
		query.append("AND     SPH.BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("AND     SPD.INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}