/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchBankAccountByOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.01 
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

public class AccountPayableCommonDBDAOSearchBankAccountByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0100 - data inquiry
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchBankAccountByOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchBankAccountByOfficeRSQL").append("\n"); 
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
		query.append("SELECT  SBA.OPN_OFC_CD             AS OPN_OFC_CD" ).append("\n"); 
		query.append("      , SBA.ATTR_CTNT2             AS DEPOSIT_DIV" ).append("\n"); 
		query.append("      , (SELECT SLD.LU_DESC " ).append("\n"); 
		query.append("         FROM SCO_LU_DTL SLD " ).append("\n"); 
		query.append("         WHERE SLD.LU_TP_CD = 'BANK ACCOUNT TYPE(L)' " ).append("\n"); 
		query.append("         AND SLD.LU_CD = SBA.BANK_ACCT_TP_MN_CD " ).append("\n"); 
		query.append("         AND ROWNUM = 1) 		   AS BANK_ACCT_TP_MN_NM" ).append("\n"); 
		query.append("      , (SELECT SLD.LU_DESC " ).append("\n"); 
		query.append("      	 FROM SCO_LU_DTL SLD " ).append("\n"); 
		query.append("      	 WHERE SLD.LU_TP_CD = 'BANK ACCOUNT TYPE(M)' " ).append("\n"); 
		query.append("      	 AND SLD.LU_CD = SBA.BANK_ACCT_TP_SUB_CD " ).append("\n"); 
		query.append("      	 AND ROWNUM = 1)           AS BANK_ACCT_TP_SUB_NM" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NM           AS BANK_ACCT_NM" ).append("\n"); 
		query.append("      , SBA.ATTR_CTNT5             AS ACCOUNT_HOLDER" ).append("\n"); 
		query.append("      , SBB.BANK_NM                AS BANK_NM" ).append("\n"); 
		query.append("      , SBB.BANK_BRNC_NM           AS BANK_BRNC_NM" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NO           AS BANK_ACCT_NO" ).append("\n"); 
		query.append("      , SBA.CURR_CD                AS CURR_CD" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_ST_DT        AS BANK_ACCT_ST_DT" ).append("\n"); 
		query.append("      , SBA.INACT_DT               AS INACT_DT" ).append("\n"); 
		query.append("      , SBA.AP_CTRL_OFC_CD         AS AP_CTRL_OFC_CD" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD , SBA.ATTR_CTNT8)) AS LIMIT_AMOUNT" ).append("\n"); 
		query.append("FROM    SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("      , SAP_BANK_BRNC SBB" ).append("\n"); 
		query.append("WHERE   SBA.BANK_BRNC_SEQ = SBB.BANK_BRNC_SEQ" ).append("\n"); 
		query.append("  AND   SBA.OPN_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if     (${ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("  AND   SBA.AP_CTRL_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if     (${bank_nm} != '')" ).append("\n"); 
		query.append("  AND   SBB.BANK_NM = @[bank_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if     (${bank_acct_tp} != '')" ).append("\n"); 
		query.append("  AND   SBA.BANK_ACCT_TP_MN_CD = @[bank_acct_tp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if     (${inact_flag} == 'A')" ).append("\n"); 
		query.append("  AND   SBA.INACT_DT IS NULL" ).append("\n"); 
		query.append("#elseif (${inact_flag} == 'O')" ).append("\n"); 
		query.append("  AND   SBA.INACT_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}