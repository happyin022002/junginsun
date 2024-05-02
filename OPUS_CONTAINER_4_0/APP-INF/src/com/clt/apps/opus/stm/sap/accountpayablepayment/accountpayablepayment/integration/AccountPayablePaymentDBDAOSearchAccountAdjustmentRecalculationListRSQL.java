/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountAdjustmentRecalculationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.01 
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

public class AccountPayablePaymentDBDAOSearchAccountAdjustmentRecalculationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bank Account의 Balance 재계산 정보 조회
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountAdjustmentRecalculationListRSQL(){
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
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountAdjustmentRecalculationListRSQL").append("\n"); 
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
		query.append("SELECT BANK_ACCT_SEQ" ).append("\n"); 
		query.append("      ,TO_CHAR(BANK_STMT_DT, 'YYYY-MM-DD') AS BANK_STMT_DT" ).append("\n"); 
		query.append("      ,CTRL_BGN_BAL_AMT" ).append("\n"); 
		query.append("      ,CTRL_TTL_RCT_AMT" ).append("\n"); 
		query.append("      ,CTRL_TTL_PAY_AMT" ).append("\n"); 
		query.append("      ,CTRL_ENDG_BAL_AMT" ).append("\n"); 
		query.append("      ,BANK_STMT_DESC" ).append("\n"); 
		query.append("  FROM SAP_BANK_BAL_ADJ" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND BANK_ACCT_SEQ = @[bank_acct_seq]" ).append("\n"); 
		query.append("   AND BANK_STMT_DT = TO_DATE(@[bank_stmt_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append(" ORDER BY BANK_STMT_DT" ).append("\n"); 

	}
}