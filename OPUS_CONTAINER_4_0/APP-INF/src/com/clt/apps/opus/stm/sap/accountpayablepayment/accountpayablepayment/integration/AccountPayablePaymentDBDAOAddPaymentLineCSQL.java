/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddPaymentLineCSQL.java
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

public class AccountPayablePaymentDBDAOAddPaymentLineCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayablePaymentDBDAOAddPaymentLineCSQL
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddPaymentLineCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("liab_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acctg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_skd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_func_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remit_vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddPaymentLineCSQL").append("\n"); 
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
		query.append("  INV_PAY_SEQ," ).append("\n"); 
		query.append("  PAY_SEQ," ).append("\n"); 
		query.append("  INV_SEQ," ).append("\n"); 
		query.append("  ACCTG_DT," ).append("\n"); 
		query.append("  PAY_AMT," ).append("\n"); 
		query.append("  EFF_YRMON," ).append("\n"); 
		query.append("  ACCTG_PST_FLG," ).append("\n"); 
		query.append("  PAY_FUNC_AMT," ).append("\n"); 
		query.append("  LIAB_CD_CMB_SEQ,	" ).append("\n"); 
		query.append("  XTER_BANK_ACCT_SEQ," ).append("\n"); 
		query.append("  REMIT_VNDR_NO," ).append("\n"); 
		query.append("  PAY_SKD_NO," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("  SAP_PAY_DTL_SEQ.NEXTVAL," ).append("\n"); 
		query.append("  @[pay_seq], " ).append("\n"); 
		query.append("  @[inv_seq]," ).append("\n"); 
		query.append("  TO_DATE(@[acctg_dt], 'YYYY-MM-DD')," ).append("\n"); 
		query.append("  REPLACE(@[pay_amt],',','')," ).append("\n"); 
		query.append("  SUBSTR(REPLACE(@[acctg_dt],'-',''), 1, 6)," ).append("\n"); 
		query.append("  'N'," ).append("\n"); 
		query.append("  REPLACE(@[pay_func_amt],',','')," ).append("\n"); 
		query.append("  @[liab_cd_cmb_seq]," ).append("\n"); 
		query.append("  @[xter_bank_acct_seq]," ).append("\n"); 
		query.append("  @[remit_vndr_no]," ).append("\n"); 
		query.append("  @[pay_skd_no]," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}