/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchSupplierBankValiInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.18 
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

public class AccountPayableInvoiceDBDAOSearchSupplierBankValiInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSupplierBankValiInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchSupplierBankValiInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vendor_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchSupplierBankValiInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(SV.PAY_PRIO_CD,'99')   AS VALUE1" ).append("\n"); 
		query.append("     , S.BANK_ACCT_SEQ          AS VALUE2" ).append("\n"); 
		query.append("     , S.BANK_ACCT_VNDR_SEQ     AS VALUE3" ).append("\n"); 
		query.append("     ,S.CURR_CD" ).append("\n"); 
		query.append("     ,S.BANK_ACCT_VNDR_SEQ" ).append("\n"); 
		query.append("FROM SAP_BANK_ACCT S, SAP_VENDOR SV" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND S.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("AND S.BANK_ACCT_VNDR_SEQ = @[vendor_no]" ).append("\n"); 
		query.append("AND S.BANK_ACCT_VNDR_SEQ = TO_NUMBER(SV.VNDR_NO(+))" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}