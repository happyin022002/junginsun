/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddBankAccountAdjustmentCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24 
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

public class AccountPayablePaymentDBDAOAddBankAccountAdjustmentCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bank Account의 Balance 정보 저장
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddBankAccountAdjustmentCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_stmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_endg_bal_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_bgn_bal_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ttl_pay_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_stmt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ttl_rct_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddBankAccountAdjustmentCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_BANK_BAL_ADJ" ).append("\n"); 
		query.append("( BANK_ACCT_SEQ" ).append("\n"); 
		query.append(" ,BANK_STMT_DT" ).append("\n"); 
		query.append(" ,CTRL_BGN_BAL_AMT" ).append("\n"); 
		query.append(" ,CTRL_TTL_RCT_AMT" ).append("\n"); 
		query.append(" ,CTRL_TTL_PAY_AMT" ).append("\n"); 
		query.append(" ,CTRL_ENDG_BAL_AMT" ).append("\n"); 
		query.append(" ,BANK_STMT_DESC" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("( @[bank_acct_seq]" ).append("\n"); 
		query.append(" ,TO_DATE(@[bank_stmt_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append(" ,@[ctrl_bgn_bal_amt]" ).append("\n"); 
		query.append(" ,@[ctrl_ttl_rct_amt]" ).append("\n"); 
		query.append(" ,@[ctrl_ttl_pay_amt]" ).append("\n"); 
		query.append(" ,@[ctrl_endg_bal_amt]" ).append("\n"); 
		query.append(" ,@[bank_stmt_desc]" ).append("\n"); 
		query.append(" ,@[usr_id]" ).append("\n"); 
		query.append(" ,SYSDATE" ).append("\n"); 
		query.append(" ,@[usr_id]" ).append("\n"); 
		query.append(" ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}