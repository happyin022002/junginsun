/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountingDetailValidateInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.08 
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

public class AccountPayablePaymentDBDAOSearchAccountingDetailValidateInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAccountingDetailValidateInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountingDetailValidateInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accounting_request_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountingDetailValidateInfoRSQL").append("\n"); 
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
		query.append("SELECT  SAE.ACCTG_EVNT_SEQ      			AS ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("      , SAE.ACCTG_EVNT_TP_CD    			AS ACCTG_EVNT_TP_CD" ).append("\n"); 
		query.append("      , SAE.ACCTG_SRC_SEQ       			AS ACCTG_SRC_SEQ" ).append("\n"); 
		query.append("      , SAEH.ACCTG_HDR_SEQ      			AS ACCTG_HDR_SEQ" ).append("\n"); 
		query.append("      , TO_CHAR(SAEH.ACCTG_DT,'YYYYMMDD')   AS ACCTG_DT" ).append("\n"); 
		query.append("      , '' ACCTG_ERR_CD" ).append("\n"); 
		query.append("FROM    SAP_ACCTG_EVNT SAE" ).append("\n"); 
		query.append("      , SAP_ACCTG_EVNT_HDR SAEH" ).append("\n"); 
		query.append("WHERE   SAE.ACCTG_EVNT_SEQ = SAEH.ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("AND     SAEH.ACCTG_RQST_SEQ = @[accounting_request_id]" ).append("\n"); 

	}
}