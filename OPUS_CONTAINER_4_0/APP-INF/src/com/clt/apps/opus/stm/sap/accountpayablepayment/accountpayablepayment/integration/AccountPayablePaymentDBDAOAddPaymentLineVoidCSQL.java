/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddPaymentLineVoidCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.12 
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

public class AccountPayablePaymentDBDAOAddPaymentLineVoidCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayablePaymentDBDAOAddPaymentLineVoidCSQL
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddPaymentLineVoidCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddPaymentLineVoidCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_PAY_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        INV_PAY_SEQ," ).append("\n"); 
		query.append("        PAY_SEQ," ).append("\n"); 
		query.append("        INV_SEQ," ).append("\n"); 
		query.append("        ACCTG_DT," ).append("\n"); 
		query.append("        PAY_AMT," ).append("\n"); 
		query.append("        EFF_YRMON," ).append("\n"); 
		query.append("        ACCTG_PST_FLG," ).append("\n"); 
		query.append("        PAY_FUNC_AMT," ).append("\n"); 
		query.append("        LIAB_CD_CMB_SEQ," ).append("\n"); 
		query.append("		XTER_BANK_ACCT_SEQ," ).append("\n"); 
		query.append("		REMIT_VNDR_NO," ).append("\n"); 
		query.append("		RVS_FLG," ).append("\n"); 
		query.append("		PAY_SKD_NO," ).append("\n"); 
		query.append("		PRNT_RVS_INV_PAY_SEQ," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  SAP_PAY_DTL_SEQ.NEXTVAL," ).append("\n"); 
		query.append("        PAY_SEQ," ).append("\n"); 
		query.append("        INV_SEQ," ).append("\n"); 
		query.append("        TO_DATE(@[pay_dt], 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        PAY_AMT * (-1)," ).append("\n"); 
		query.append("        SUBSTR(REPLACE(@[pay_dt],'-',''), 1, 6)," ).append("\n"); 
		query.append("        'N'," ).append("\n"); 
		query.append("        PAY_FUNC_AMT * (-1)," ).append("\n"); 
		query.append("        LIAB_CD_CMB_SEQ," ).append("\n"); 
		query.append("		XTER_BANK_ACCT_SEQ," ).append("\n"); 
		query.append("		REMIT_VNDR_NO," ).append("\n"); 
		query.append("		'Y'," ).append("\n"); 
		query.append("		PAY_SKD_NO," ).append("\n"); 
		query.append("		INV_PAY_SEQ," ).append("\n"); 
		query.append("        @[usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[usr_id]," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append("FROM SAP_PAY_DTL" ).append("\n"); 
		query.append("WHERE PAY_SEQ = @[pay_seq]" ).append("\n"); 

	}
}