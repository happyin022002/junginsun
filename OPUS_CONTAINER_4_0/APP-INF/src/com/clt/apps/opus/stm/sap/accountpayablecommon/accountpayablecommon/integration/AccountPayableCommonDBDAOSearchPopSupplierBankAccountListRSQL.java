/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopSupplierBankAccountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchPopSupplierBankAccountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM-SAP-0032 Supplier Bank Account Popup
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopSupplierBankAccountListRSQL(){
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
		params.put("bank_acct_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchPopSupplierBankAccountListRSQL").append("\n"); 
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
		query.append("SELECT SBA.BANK_ACCT_NO        AS BANK_ACCT_NO" ).append("\n"); 
		query.append("     , SBA.BANK_ACCT_VNDR_SEQ  AS VNDR_SEQ" ).append("\n"); 
		query.append("     , SBA.CURR_CD             AS CURR_CD" ).append("\n"); 
		query.append("     , MV.VNDR_LGL_ENG_NM      AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , SBA.BANK_ACCT_SEQ       AS BANK_ACCT_SEQ" ).append("\n"); 
		query.append("FROM   SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("     , MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE  SBA.BANK_ACCT_VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${call_flag} != 'INVOICE') " ).append("\n"); 
		query.append("  #if  (${vndr_seq} != '')" ).append("\n"); 
		query.append("  AND SBA.BANK_ACCT_VNDR_SEQ LIKE @[vndr_seq]||'%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  AND SBA.INACT_DT IS NULL" ).append("\n"); 
		query.append("  #if  (${vndr_seq} != '')" ).append("\n"); 
		query.append("  AND SBA.BANK_ACCT_VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${curr_cd} != '')" ).append("\n"); 
		query.append("  AND SBA.CURR_CD = UPPER(@[curr_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bank_acct_tp_nm} != '') " ).append("\n"); 
		query.append("  AND SBA.BANK_ACCT_TP_NM = @[bank_acct_tp_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("  AND MV.VNDR_LGL_ENG_NM LIKE @[vndr_lgl_eng_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DECODE(BANK_ACCT_PRIO_CD, 'Y', 1, 2), SBA.BANK_ACCT_NO" ).append("\n"); 

	}
}