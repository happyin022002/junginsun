/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchBankAccountAdjustmentListRSQL.java
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

public class AccountPayablePaymentDBDAOSearchBankAccountAdjustmentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bank Account의 Balance 정보를 조회
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchBankAccountAdjustmentListRSQL(){
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
		query.append("FileName : AccountPayablePaymentDBDAOSearchBankAccountAdjustmentListRSQL").append("\n"); 
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
		query.append("SELECT  SBA.BANK_NM" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("      , SBA.BANK_BRNC_NM" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NO" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NM" ).append("\n"); 
		query.append("      , SBA.CURR_CD" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_TP_MN_NM" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_TP_SUB_NM" ).append("\n"); 
		query.append("      , TO_CHAR(TO_DATE(@[bank_stmt_dt], 'YYYY-MM-DD'),'YYYY-MM-DD') AS BANK_STMT_DT  --TO_CHAR(SBA.BANK_STMT_DT, 'YYYY-MM-DD') AS BANK_STMT_DT" ).append("\n"); 
		query.append("      , OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA.CTRL_BGN_BAL_AMT) AS CTRL_BGN_BAL_AMT" ).append("\n"); 
		query.append("      , OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA.CTRL_TTL_RCT_AMT) AS CTRL_TTL_RCT_AMT" ).append("\n"); 
		query.append("      , OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA.CTRL_TTL_PAY_AMT) AS CTRL_TTL_PAY_AMT" ).append("\n"); 
		query.append("      , SBBA2.BANK_STMT_DESC AS BANK_STMT_DESC" ).append("\n"); 
		query.append("      , (SELECT NVL(DP_PRCS_KNT, 0) FROM MDM_CURRENCY M WHERE M.CURR_CD = SBA.CURR_CD AND ROWNUM = 1 ) AS INV_CURR_PRCS" ).append("\n"); 
		query.append("      , SBBA.CRE_USR_ID AS USR_ID" ).append("\n"); 
		query.append("      , OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, NVL(STI2.RECEIPT_AMOUNT, 0)) AS RECEIPT_AMT_TODAY" ).append("\n"); 
		query.append("      , OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, NVL(STI2.PAYMENT_AMOUNT, 0)) AS PAYMENT_AMT_TODAY" ).append("\n"); 
		query.append("      , CASE WHEN NVL(TO_CHAR(SBBA2.BANK_STMT_DT,'YYYYMMDD'), REPLACE(@[bank_stmt_dt],'-')) = REPLACE(@[bank_stmt_dt],'-') THEN TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA2.CTRL_TTL_RCT_AMT))" ).append("\n"); 
		query.append("             ELSE TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, 0))" ).append("\n"); 
		query.append("        END AS AFT_TTL_RCT_AMT" ).append("\n"); 
		query.append("      , CASE WHEN NVL(TO_CHAR(SBBA2.BANK_STMT_DT,'YYYYMMDD'), REPLACE(@[bank_stmt_dt],'-')) = REPLACE(@[bank_stmt_dt],'-') THEN TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA2.CTRL_TTL_PAY_AMT))" ).append("\n"); 
		query.append("             ELSE TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, 0))" ).append("\n"); 
		query.append("        END AS AFT_TTL_PAY_AMT" ).append("\n"); 
		query.append("      , CASE WHEN NVL(TO_CHAR(SBBA2.BANK_STMT_DT,'YYYYMMDD'), REPLACE(@[bank_stmt_dt],'-')) = REPLACE(@[bank_stmt_dt],'-') THEN TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA2.CTRL_ENDG_BAL_AMT))" ).append("\n"); 
		query.append("             ELSE TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SBA.CURR_CD, SBBA2.CTRL_BGN_BAL_AMT + SBBA2.CTRL_TTL_RCT_AMT - SBBA2.CTRL_TTL_PAY_AMT))" ).append("\n"); 
		query.append("        END AS AFT_ENDG_BAL_AMT" ).append("\n"); 
		query.append("      , DECODE(SBBA2.BANK_STMT_DT, NULL, 'N', 'Y') AS ADJ_CHK" ).append("\n"); 
		query.append("      , DECODE(STI2.BANK_ACCOUNT_SEQ, NULL, 'N', 'Y') AS TRX_CHK" ).append("\n"); 
		query.append("      , CASE WHEN SBBA2.BANK_STMT_DT IS NOT NULL THEN '0' ELSE" ).append("\n"); 
		query.append("             CASE WHEN STI2.BANK_ACCOUNT_SEQ IS NOT NULL THEN '1' ELSE '0' END " ).append("\n"); 
		query.append("        END AS SAVE_CHK  -- 1 SAVE 대상, 0 SAVE 대상이 아님." ).append("\n"); 
		query.append("FROM    (SELECT  SBA.BANK_NM" ).append("\n"); 
		query.append("               , SBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("               , SBA.BANK_BRNC_NM" ).append("\n"); 
		query.append("               , SBA.BANK_ACCT_NO" ).append("\n"); 
		query.append("               , SBA.BANK_ACCT_NM" ).append("\n"); 
		query.append("               , SBA.CURR_CD" ).append("\n"); 
		query.append("               , SBA.BANK_ACCT_TP_MN_NM" ).append("\n"); 
		query.append("               , SBA.BANK_ACCT_TP_SUB_NM" ).append("\n"); 
		query.append("               , NVL(MAX(SBBA.BANK_STMT_DT), TO_DATE(@[bank_stmt_dt],'YYYY-MM-DD') - 1) AS BANK_STMT_DT" ).append("\n"); 
		query.append("         FROM    (SELECT  SBB.BANK_NM" ).append("\n"); 
		query.append("                        , SBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("                        , SBB.BANK_BRNC_NM" ).append("\n"); 
		query.append("                        , SBA.BANK_ACCT_NO" ).append("\n"); 
		query.append("                        , SBA.BANK_ACCT_NM" ).append("\n"); 
		query.append("                        , SBA.CURR_CD" ).append("\n"); 
		query.append("                        , (SELECT SLD.LU_DESC " ).append("\n"); 
		query.append("                           FROM   SCO_LU_DTL SLD " ).append("\n"); 
		query.append("                           WHERE  SLD.LU_TP_CD = 'BANK ACCOUNT TYPE(L)'" ).append("\n"); 
		query.append("                           AND    SLD.LU_CD = SBA.BANK_ACCT_TP_MN_CD " ).append("\n"); 
		query.append("                           AND    ROWNUM = 1) AS BANK_ACCT_TP_MN_NM" ).append("\n"); 
		query.append("                        , (SELECT SLD.LU_DESC " ).append("\n"); 
		query.append("                           FROM   SCO_LU_DTL SLD " ).append("\n"); 
		query.append("                           WHERE  SLD.LU_TP_CD = 'BANK ACCOUNT TYPE(M)' " ).append("\n"); 
		query.append("                           AND    SLD.LU_CD = SBA.BANK_ACCT_TP_SUB_CD " ).append("\n"); 
		query.append("                           AND    ROWNUM = 1) AS BANK_ACCT_TP_SUB_NM" ).append("\n"); 
		query.append("                  FROM    SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("                        , SAP_BANK_BRNC SBB" ).append("\n"); 
		query.append("                  WHERE   1 = 1 " ).append("\n"); 
		query.append("                  AND     SBA.BANK_BRNC_SEQ = SBB.BANK_BRNC_SEQ" ).append("\n"); 
		query.append("                  AND     SBA.BANK_ACCT_TP_NM = 'INTERNAL'" ).append("\n"); 
		query.append("                  AND     ((DECODE(@[ctrl_ofc], 'AP', SBA.AP_CTRL_OFC_CD, 'AR', SBA.AR_OFC_CD) = @[ofc_cd])" ).append("\n"); 
		query.append("                           OR (@[ctrl_ofc] = 'ALL' AND (SBA.AP_CTRL_OFC_CD = @[ofc_cd] OR SBA.AR_OFC_CD = @[ofc_cd]))) " ).append("\n"); 
		query.append("                  #if (${inv_curr_cd} != '')" ).append("\n"); 
		query.append("                    AND   SBA.CURR_CD =@[inv_curr_cd]" ).append("\n"); 
		query.append("                  #end   " ).append("\n"); 
		query.append("                  #if (${bank_acct_tp_mn_cd} != '')" ).append("\n"); 
		query.append("                    AND   SBA.BANK_ACCT_TP_MN_CD =@[bank_acct_tp_mn_cd]" ).append("\n"); 
		query.append("                  #end " ).append("\n"); 
		query.append("                  #if (${bank_acct_tp_sub_cd} != '')" ).append("\n"); 
		query.append("                    AND   SBA.BANK_ACCT_TP_SUB_CD =@[bank_acct_tp_sub_cd]" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                 ) SBA" ).append("\n"); 
		query.append("               , SAP_BANK_BAL_ADJ SBBA" ).append("\n"); 
		query.append("         WHERE   1 = 1" ).append("\n"); 
		query.append("         AND     SBA.BANK_ACCT_SEQ = SBBA.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("         AND     SBBA.BANK_STMT_DT(+) < TO_DATE(@[bank_stmt_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("         GROUP   BY SBA.BANK_NM" ).append("\n"); 
		query.append("                  , SBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("                  , SBA.BANK_BRNC_NM" ).append("\n"); 
		query.append("                  , SBA.BANK_ACCT_NO" ).append("\n"); 
		query.append("                  , SBA.BANK_ACCT_NM" ).append("\n"); 
		query.append("                  , SBA.CURR_CD" ).append("\n"); 
		query.append("                  , SBA.BANK_ACCT_TP_MN_NM" ).append("\n"); 
		query.append("                  , SBA.BANK_ACCT_TP_SUB_NM   " ).append("\n"); 
		query.append("        ) SBA" ).append("\n"); 
		query.append("      , SAP_BANK_BAL_ADJ SBBA" ).append("\n"); 
		query.append("      , SAP_BANK_BAL_ADJ SBBA2" ).append("\n"); 
		query.append("      , (SELECT  STI.BANK_ACCOUNT_SEQ" ).append("\n"); 
		query.append("               , SUM(STI.PAYMENT_AMOUNT)         AS PAYMENT_AMOUNT" ).append("\n"); 
		query.append("               , SUM(STI.RECEIPT_AMOUNT)         AS RECEIPT_AMOUNT" ).append("\n"); 
		query.append("         FROM    SAP_TRX_INQ_V STI" ).append("\n"); 
		query.append("         WHERE   STI.CLEARED_DATE = TO_DATE(@[bank_stmt_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("         GROUP   BY STI.BANK_ACCOUNT_SEQ) STI2" ).append("\n"); 
		query.append("WHERE   SBA.BANK_ACCT_SEQ = SBBA.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("AND     SBA.BANK_STMT_DT  = SBBA.BANK_STMT_DT(+)" ).append("\n"); 
		query.append("AND     SBA.BANK_ACCT_SEQ = SBBA2.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("AND     SBBA2.BANK_STMT_DT(+) = TO_DATE(@[bank_stmt_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     SBA.BANK_ACCT_SEQ = STI2.BANK_ACCOUNT_SEQ(+)" ).append("\n"); 
		query.append("ORDER   BY SBA.BANK_NM" ).append("\n"); 
		query.append("         , SBA.BANK_ACCT_SEQ" ).append("\n"); 

	}
}