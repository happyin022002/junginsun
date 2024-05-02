/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddInvoiceInterfacePayScheduleInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOAddInvoiceInterfacePayScheduleInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOAddInvoiceInterfacePayScheduleInfoCSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddInvoiceInterfacePayScheduleInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_bank_acct_vndr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("creation_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_bank_acct_prio_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_term_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_term_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_pay_mzd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOAddInvoiceInterfacePayScheduleInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_PAY_SKD" ).append("\n"); 
		query.append("(  INV_SEQ" ).append("\n"); 
		query.append(" , PAY_SKD_NO" ).append("\n"); 
		query.append(" , PAY_RMN_AMT" ).append("\n"); 
		query.append(" , DUE_DT" ).append("\n"); 
		query.append(" , PAY_GRS_AMT" ).append("\n"); 
		query.append(" , INV_HLD_FLG" ).append("\n"); 
		query.append(" , PAY_MZD_LU_CD" ).append("\n"); 
		query.append(" , PAY_PRIO_CD" ).append("\n"); 
		query.append(" , PAY_STS_FLG" ).append("\n"); 
		query.append(" , INV_BAT_SEQ" ).append("\n"); 
		query.append(" , ATTR_CTNT1" ).append("\n"); 
		query.append(" , ATTR_CTNT2" ).append("\n"); 
		query.append(" , ATTR_CTNT3" ).append("\n"); 
		query.append(" , ATTR_CTNT4" ).append("\n"); 
		query.append(" , ATTR_CTNT5" ).append("\n"); 
		query.append(" , ATTR_CTNT6" ).append("\n"); 
		query.append(" , ATTR_CTNT7" ).append("\n"); 
		query.append(" , ATTR_CTNT8" ).append("\n"); 
		query.append(" , ATTR_CTNT9" ).append("\n"); 
		query.append(" , ATTR_CTNT10" ).append("\n"); 
		query.append(" , ATTR_CTNT11" ).append("\n"); 
		query.append(" , ATTR_CTNT12" ).append("\n"); 
		query.append(" , ATTR_CTNT13" ).append("\n"); 
		query.append(" , ATTR_CTNT14" ).append("\n"); 
		query.append(" , ATTR_CTNT15" ).append("\n"); 
		query.append(" , ATTR_CATE_NM" ).append("\n"); 
		query.append(" , XTER_BANK_ACCT_SEQ" ).append("\n"); 
		query.append(" , PAY_BAT_RUN_SEQ" ).append("\n"); 
		query.append(" , REMIT_VNDR_NO" ).append("\n"); 
		query.append(" , CRE_USR_ID" ).append("\n"); 
		query.append(" , CRE_DT" ).append("\n"); 
		query.append(" , UPD_USR_ID" ).append("\n"); 
		query.append(" , UPD_DT" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(  @[inv_seq]" ).append("\n"); 
		query.append(" , 1" ).append("\n"); 
		query.append(" , @[inv_amt]" ).append("\n"); 
		query.append(" , TO_DATE(@[inv_term_dt],'YYYYMMDD') + TO_NUMBER(REPLACE(@[inv_term_nm], 'O', ''))  " ).append("\n"); 
		query.append(" , @[inv_amt]" ).append("\n"); 
		query.append(" , 'N'" ).append("\n"); 
		query.append(" , @[ap_pay_mzd_lu_cd]" ).append("\n"); 
		query.append(" , @[vndr_bank_acct_prio_cd]" ).append("\n"); 
		query.append(" , 'N'" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , @[vndr_bank_acct_seq]" ).append("\n"); 
		query.append(" , ''" ).append("\n"); 
		query.append(" , DECODE(@[vndr_bank_acct_seq], NULL, '', @[vndr_bank_acct_vndr_no])" ).append("\n"); 
		query.append(" , @[creation_user]" ).append("\n"); 
		query.append(" , SYSDATE" ).append("\n"); 
		query.append(" , @[usr_id]" ).append("\n"); 
		query.append(" , SYSDATE" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}