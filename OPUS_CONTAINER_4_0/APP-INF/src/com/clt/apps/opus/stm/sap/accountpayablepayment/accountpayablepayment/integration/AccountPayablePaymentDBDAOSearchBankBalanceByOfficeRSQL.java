/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchBankBalanceByOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.20 
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

public class AccountPayablePaymentDBDAOSearchBankBalanceByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0130 inquiry query
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchBankBalanceByOfficeRSQL(){
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
		params.put("bank_acct_tp_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_tp_mn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchBankBalanceByOfficeRSQL").append("\n"); 
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
		query.append("SELECT SBB.BANK_NM				AS BANK_NM" ).append("\n"); 
		query.append("      , SBB.BANK_BRNC_NM		AS BANK_BRNC_NM" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NO		AS BANK_ACCT_NO" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NM		AS BANK_ACCT_NM" ).append("\n"); 
		query.append("      , SBA.CURR_CD             AS CURR_CD" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA.CTRL_BGN_BAL_AMT))    AS BGN_BAL_AMT" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA.CTRL_TTL_RCT_AMT))    AS TTL_RCT_AMT" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA.CTRL_TTL_PAY_AMT))    AS TTL_PAY_AMT" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA.CTRL_ENDG_BAL_AMT))   AS ENDG_BAL_AMT" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, NVL(SBBA_1.CTRL_BGN_BAL_AMT, 0)))  AS CTRL_BGN_BAL_AMT" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, NVL(SBBA_1.CTRL_TTL_RCT_AMT, 0)))  AS CTRL_TTL_RCT_AMT" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, NVL(SBBA_1.CTRL_TTL_PAY_AMT, 0)))  AS CTRL_TTL_PAY_AMT" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, NVL(SBBA_1.CTRL_ENDG_BAL_AMT, 0))) AS CTRL_ENDG_BAL_AMT" ).append("\n"); 
		query.append("      , TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA.CTRL_ENDG_BAL_AMT - NVL(SBBA_1.CTRL_ENDG_BAL_AMT, 0))) AS DIFFERENCE" ).append("\n"); 
		query.append("      , SBBA.BANK_STMT_DESC		AS BANK_STMT_DESC" ).append("\n"); 
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
		query.append("FROM SAP_BANK_BAL_ADJ SBBA" ).append("\n"); 
		query.append("    , SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("    , SAP_BANK_BRNC SBB" ).append("\n"); 
		query.append("    , (SELECT SBBA.BANK_ACCT_SEQ " ).append("\n"); 
		query.append("            , SBBA.CTRL_BGN_BAL_AMT" ).append("\n"); 
		query.append("            , SBBA.CTRL_TTL_RCT_AMT" ).append("\n"); 
		query.append("            , SBBA.CTRL_TTL_PAY_AMT" ).append("\n"); 
		query.append("            , SBBA.CTRL_ENDG_BAL_AMT" ).append("\n"); 
		query.append("            , SBBA.BANK_STMT_DT" ).append("\n"); 
		query.append("       FROM   SAP_BANK_BAL_ADJ SBBA" ).append("\n"); 
		query.append("       WHERE  (SBBA.BANK_ACCT_SEQ, SBBA.BANK_STMT_DT) IN (SELECT  SBBA1.BANK_ACCT_SEQ, MAX(SBBA1.BANK_STMT_DT)" ).append("\n"); 
		query.append("                                                          FROM    SAP_BANK_BAL_ADJ SBBA1" ).append("\n"); 
		query.append("                                                          WHERE   SBBA1.BANK_ACCT_SEQ = SBBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("                                                          AND     SBBA1.BANK_STMT_DT < TO_DATE('2014-06-19','YYYY-MM-DD')" ).append("\n"); 
		query.append("                                                          GROUP   BY SBBA1.BANK_ACCT_SEQ)) SBBA_1" ).append("\n"); 
		query.append("WHERE SBBA.BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("AND SBBA.BANK_ACCT_SEQ = SBBA_1.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("AND SBA.BANK_BRNC_SEQ = SBB.BANK_BRNC_SEQ" ).append("\n"); 
		query.append("AND SBA.BANK_ACCT_TP_NM = 'INTERNAL'" ).append("\n"); 
		query.append("AND ((DECODE(@[ctrl_ofc], 'AP', SBA.AP_CTRL_OFC_CD, 'AR', SBA.AR_OFC_CD) = @[ofc_cd])" ).append("\n"); 
		query.append("     OR (@[ctrl_ofc] ='ALL' AND (SBA.AP_CTRL_OFC_CD = @[ofc_cd] OR SBA.AR_OFC_CD = @[ofc_cd])))" ).append("\n"); 
		query.append("AND SBBA.BANK_STMT_DT = TO_DATE(@[bank_stmt_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#if (${inv_curr_cd} != '')" ).append("\n"); 
		query.append("AND SBA.CURR_CD =@[inv_curr_cd]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${bank_acct_tp_mn_cd} != '')" ).append("\n"); 
		query.append("AND SBA.BANK_ACCT_TP_MN_CD =@[bank_acct_tp_mn_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${bank_acct_tp_sub_cd} != '')" ).append("\n"); 
		query.append("AND SBA.BANK_ACCT_TP_SUB_CD =@[bank_acct_tp_sub_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}