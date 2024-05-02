/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPHeaderTaxInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.24 
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

public class AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPHeaderTaxInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddInterfaceSAPStandardNonJPHeaderTaxInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPHeaderTaxInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("functional_currency",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slip_interface_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPHeaderTaxInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_AP_IF " ).append("\n"); 
		query.append("         ( AP_IF_SEQ" ).append("\n"); 
		query.append("         , IF_SEQ_NO" ).append("\n"); 
		query.append("         , REC_ID" ).append("\n"); 
		query.append("         , ACCT_CO_CD" ).append("\n"); 
		query.append("         , IF_DOC_TP_CD" ).append("\n"); 
		query.append("         , DOC_DT" ).append("\n"); 
		query.append("         , PST_DT" ).append("\n"); 
		query.append("         , REF_DOC_NO" ).append("\n"); 
		query.append("         , DOC_HDR_CD" ).append("\n"); 
		query.append("         , CURR_CD" ).append("\n"); 
		query.append("         , TAX_CALC_AUTO_FLG" ).append("\n"); 
		query.append("         , PST_KEY_CD" ).append("\n"); 
		query.append("         , VAT_TAX_CD" ).append("\n"); 
		query.append("         , LOCL_AMT" ).append("\n"); 
		query.append("         , DOC_AMT" ).append("\n"); 
		query.append("         , LOCL_TAX_AMT" ).append("\n"); 
		query.append("         , DOC_TAX_AMT" ).append("\n"); 
		query.append("         , ASGN_NO" ).append("\n"); 
		query.append("         , ITM_DESC" ).append("\n"); 
		query.append("         , PLN_DT" ).append("\n"); 
		query.append("         , COST_CTR_CD" ).append("\n"); 
		query.append("         , ORD_NO" ).append("\n"); 
		query.append("         , MN_ASET_NO" ).append("\n"); 
		query.append("         , SUB_ASET_NO" ).append("\n"); 
		query.append("         , ASET_TJ_TP_CD" ).append("\n"); 
		query.append("         , ASET_VAL_DT" ).append("\n"); 
		query.append("         , GL_ACCT_NO" ).append("\n"); 
		query.append("         , CUST_NO" ).append("\n"); 
		query.append("         , VNDR_CRTR_ACCT_NO" ).append("\n"); 
		query.append("         , DUE_DT_CALC_BSEL_DT" ).append("\n"); 
		query.append("         , PAY_MZD_CD" ).append("\n"); 
		query.append("         , STE_CNTRL_BANK_IND_CD" ).append("\n"); 
		query.append("         , MTRL_NO" ).append("\n"); 
		query.append("         , FUEL_LAND_QTY" ).append("\n"); 
		query.append("         , MEAS_BSE_UT_CD" ).append("\n"); 
		query.append("         , PFITCTR_CD" ).append("\n"); 
		query.append("         , ALTN_ACCT_NO" ).append("\n"); 
		query.append("         , BIZ_PRNR_REF_KEY_CD1" ).append("\n"); 
		query.append("         , BIZ_PRNR_REF_KEY_CD2" ).append("\n"); 
		query.append("         , LINE_ITM_REF_KEY_CD" ).append("\n"); 
		query.append("         , INSTR_KEY_CD1" ).append("\n"); 
		query.append("         , INSTR_KEY_CD2" ).append("\n"); 
		query.append("         , INSTR_KEY_CD3" ).append("\n"); 
		query.append("         , PAY_REF_CD" ).append("\n"); 
		query.append("         , AUTOMTC_PAY_CURR_CD" ).append("\n"); 
		query.append("         , PAY_CURR_AMT" ).append("\n"); 
		query.append("         , CTRT_NO" ).append("\n"); 
		query.append("         , CTRT_TP_CD" ).append("\n"); 
		query.append("         , PAY_RSN_CD" ).append("\n"); 
		query.append("         , CLSS_CD" ).append("\n"); 
		query.append("         , ACT_PLC_CD" ).append("\n"); 
		query.append("         , ENTR_EXPN_ID" ).append("\n"); 
		query.append("         , BUD_MGMT_DIV_CD" ).append("\n"); 
		query.append("         , ACT_DT" ).append("\n"); 
		query.append("         , VSL_CD" ).append("\n"); 
		query.append("         , VVL_CD" ).append("\n"); 
		query.append("         , HUS_BANK_ID" ).append("\n"); 
		query.append("         , PAY_BLCK_KEY_CD" ).append("\n"); 
		query.append("         , CRE_USR_ID" ).append("\n"); 
		query.append("         , CRE_DT" ).append("\n"); 
		query.append("         , UPD_USR_ID" ).append("\n"); 
		query.append("         , UPD_DT" ).append("\n"); 
		query.append("         , IF_FLG" ).append("\n"); 
		query.append("         , IF_FILE_ID" ).append("\n"); 
		query.append("         , IF_DT" ).append("\n"); 
		query.append("         , IF_ITM_CATE_CD" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("         SELECT SAP_IF_TO_SAP_SEQ.NEXTVAL           AS IF_SEQ" ).append("\n"); 
		query.append("              , SLIP_IF_SEQ_NO" ).append("\n"); 
		query.append("              , RECORD_ID" ).append("\n"); 
		query.append("              , COMPANY_CODE" ).append("\n"); 
		query.append("              , DOCUMENT_TYPE" ).append("\n"); 
		query.append("              ,	DOCUMENT_DATE" ).append("\n"); 
		query.append("              ,	POSTING_DATE" ).append("\n"); 
		query.append("              , REFERENCE_DOCUMENT_NO" ).append("\n"); 
		query.append("              ,	DOCUMENT_HEADER_TEXT" ).append("\n"); 
		query.append("              ,	CURRENCE_CODE" ).append("\n"); 
		query.append("              ,	TAX_CALCULATE_AUTO_FLAG" ).append("\n"); 
		query.append("              ,	POST_KEY" ).append("\n"); 
		query.append("              ,	TAX_ON_SALES" ).append("\n"); 
		query.append("              ,	LOCAL_AMOUNT" ).append("\n"); 
		query.append("              ,	DOCUMENT_AMOUNT" ).append("\n"); 
		query.append("              ,	LOCAL_TAX_AMOUNT" ).append("\n"); 
		query.append("              ,	DOCUMENT_TAX_AMOUNT" ).append("\n"); 
		query.append("              ,	ASSIGNMENT_NUMBER" ).append("\n"); 
		query.append("              ,	ITEM_TEXT" ).append("\n"); 
		query.append("              ,	PLANNING_DATE" ).append("\n"); 
		query.append("              ,	COST_CENTER" ).append("\n"); 
		query.append("              ,	ORDER_NUMBER" ).append("\n"); 
		query.append("              ,	MAIN_ASSET_NUMBER" ).append("\n"); 
		query.append("              ,	ASSET_SUB_NUMBER" ).append("\n"); 
		query.append("              ,	ASSET_TRANSACTION_TYPE" ).append("\n"); 
		query.append("              ,	ASSET_VALUE_DATE" ).append("\n"); 
		query.append("              ,	GL_ACCOUNT_NO" ).append("\n"); 
		query.append("              ,	CUSTOMER_NUMBER" ).append("\n"); 
		query.append("              ,	VENDOR_ACCOUNT_NO" ).append("\n"); 
		query.append("              ,	CALCULATE_DUE_DATE" ).append("\n"); 
		query.append("              ,	PAYMENT_METHOD" ).append("\n"); 
		query.append("              ,	STATE_CENTRAL_BANK" ).append("\n"); 
		query.append("              ,	MATERIAL_NO" ).append("\n"); 
		query.append("              ,	QUANTITY" ).append("\n"); 
		query.append("              ,	BASE_UNIT" ).append("\n"); 
		query.append("              ,	PROFIT_CENTER" ).append("\n"); 
		query.append("              ,	ALTERNATIVE_ACCOUNT_NO" ).append("\n"); 
		query.append("              ,	BIZ_PARTNER_REF_KEY1" ).append("\n"); 
		query.append("              ,	BIZ_PARTNER_REF_KEY2" ).append("\n"); 
		query.append("              ,	LINE_ITEM_REF_KEY" ).append("\n"); 
		query.append("              ,	INSTRUCTION_KEY1" ).append("\n"); 
		query.append("              ,	INSTRUCTION_KEY2" ).append("\n"); 
		query.append("              ,	INSTRUCTION_KEY3" ).append("\n"); 
		query.append("              ,	PAYMENT_REFERENCE" ).append("\n"); 
		query.append("              ,	AUTOMATIC_PAY_CURRENCY" ).append("\n"); 
		query.append("              ,	PAYMENT_CURR_AMOUNT" ).append("\n"); 
		query.append("              ,	CONTRACT_NUMBER" ).append("\n"); 
		query.append("              ,	CONTRACT_TYPE" ).append("\n"); 
		query.append("              ,	PAYMENT_REASON" ).append("\n"); 
		query.append("              ,	CLASSIFICATION" ).append("\n"); 
		query.append("              ,	ACTIVITY_PLACE" ).append("\n"); 
		query.append("              ,	ENTERTAINMENT_EXP_ID" ).append("\n"); 
		query.append("              ,	BUDGET_MANAGE_DIVISION" ).append("\n"); 
		query.append("              ,	ACTIVITY_DATE" ).append("\n"); 
		query.append("              ,	VESSEL" ).append("\n"); 
		query.append("              ,	VVL_CODE" ).append("\n"); 
		query.append("              ,	HOUSE_BANK" ).append("\n"); 
		query.append("              ,	PAYMENT_BLOCK_KEY" ).append("\n"); 
		query.append("              ,	CRE_USR_ID" ).append("\n"); 
		query.append("              ,	CRE_DT" ).append("\n"); 
		query.append("              ,	UPD_USR_ID" ).append("\n"); 
		query.append("              ,	UPD_DT" ).append("\n"); 
		query.append("              ,	INTERFACE_FLAG" ).append("\n"); 
		query.append("              ,	INTERFACE_FILE_ID" ).append("\n"); 
		query.append("              ,	INTERFACE_DATE" ).append("\n"); 
		query.append("              ,	IF_ITEM_CATEGROY" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT  MAX(SLIP_IF_SEQ_NO) AS SLIP_IF_SEQ_NO" ).append("\n"); 
		query.append("                      , MAX(RECORD_ID) AS RECORD_ID" ).append("\n"); 
		query.append("                      , MAX(COMPANY_CODE) AS COMPANY_CODE" ).append("\n"); 
		query.append("                      , MAX(DOCUMENT_TYPE) AS DOCUMENT_TYPE" ).append("\n"); 
		query.append("                      , MAX(DOCUMENT_DATE) AS DOCUMENT_DATE" ).append("\n"); 
		query.append("                      , MAX(POSTING_DATE) AS POSTING_DATE" ).append("\n"); 
		query.append("                      , MAX(REFERENCE_DOCUMENT_NO) AS REFERENCE_DOCUMENT_NO" ).append("\n"); 
		query.append("                      , MAX(DOCUMENT_HEADER_TEXT) AS DOCUMENT_HEADER_TEXT" ).append("\n"); 
		query.append("                      , MAX(CURRENCE_CODE) AS CURRENCE_CODE" ).append("\n"); 
		query.append("                      , MAX(TAX_CALCULATE_AUTO_FLAG) AS TAX_CALCULATE_AUTO_FLAG" ).append("\n"); 
		query.append("                      , CASE WHEN SUM(DTRB_AMT) < 0 THEN '21'" ).append("\n"); 
		query.append("                            WHEN SUM(DTRB_AMT) >= 0 THEN '31'" ).append("\n"); 
		query.append("                            ELSE '31' END AS POST_KEY" ).append("\n"); 
		query.append("                      , MAX(TAX_ON_SALES) AS TAX_ON_SALES" ).append("\n"); 
		query.append("                      , DECODE(CURRENCE_CODE, @[functional_currency], NULL, ABS(SUM(DTRB_FUNC_AMT))) AS LOCAL_AMOUNT" ).append("\n"); 
		query.append("                      , ABS(SUM(DTRB_AMT)) AS DOCUMENT_AMOUNT" ).append("\n"); 
		query.append("                      , MAX(LOCAL_TAX_AMOUNT) AS LOCAL_TAX_AMOUNT" ).append("\n"); 
		query.append("                      , MAX(DOCUMENT_TAX_AMOUNT) AS DOCUMENT_TAX_AMOUNT" ).append("\n"); 
		query.append("                      , MAX(ASSIGNMENT_NUMBER) AS ASSIGNMENT_NUMBER" ).append("\n"); 
		query.append("                      , MAX(ITEM_TEXT) AS ITEM_TEXT" ).append("\n"); 
		query.append("                      , MAX(PLANNING_DATE) AS PLANNING_DATE" ).append("\n"); 
		query.append("                      , NULL AS COST_CENTER" ).append("\n"); 
		query.append("                      , MAX(ORDER_NUMBER) AS ORDER_NUMBER" ).append("\n"); 
		query.append("                      , MAX(MAIN_ASSET_NUMBER) AS MAIN_ASSET_NUMBER" ).append("\n"); 
		query.append("                      , MAX(ASSET_SUB_NUMBER) AS ASSET_SUB_NUMBER" ).append("\n"); 
		query.append("                      , MAX(ASSET_TRANSACTION_TYPE) AS ASSET_TRANSACTION_TYPE" ).append("\n"); 
		query.append("                      , MAX(ASSET_VALUE_DATE) AS ASSET_VALUE_DATE" ).append("\n"); 
		query.append("                      , MAX(GL_ACCOUNT_NO) AS GL_ACCOUNT_NO" ).append("\n"); 
		query.append("                      , MAX(CUSTOMER_NUMBER) AS CUSTOMER_NUMBER" ).append("\n"); 
		query.append("                      , MAX(VENDOR_ACCOUNT_NO) AS VENDOR_ACCOUNT_NO" ).append("\n"); 
		query.append("                      , MAX(CALCULATE_DUE_DATE) AS CALCULATE_DUE_DATE" ).append("\n"); 
		query.append("                      , MAX(PAYMENT_METHOD) AS PAYMENT_METHOD" ).append("\n"); 
		query.append("                      , MAX(STATE_CENTRAL_BANK) AS STATE_CENTRAL_BANK" ).append("\n"); 
		query.append("                      , MAX(MATERIAL_NO) AS MATERIAL_NO" ).append("\n"); 
		query.append("                      , MAX(QUANTITY) AS QUANTITY" ).append("\n"); 
		query.append("                      , MAX(BASE_UNIT) AS BASE_UNIT" ).append("\n"); 
		query.append("                      , MAX(PROFIT_CENTER) AS PROFIT_CENTER" ).append("\n"); 
		query.append("                      , MAX(ALTERNATIVE_ACCOUNT_NO) AS ALTERNATIVE_ACCOUNT_NO" ).append("\n"); 
		query.append("                      , DECODE(SUBSTR(NVL(COST_CENTER, BIZ_PARTNER_REF_KEY1), 1, 1), 'Z', 'A106', NVL(COST_CENTER, BIZ_PARTNER_REF_KEY1))  AS BIZ_PARTNER_REF_KEY1 --20161024" ).append("\n"); 
		query.append("                      , MAX(BIZ_PARTNER_REF_KEY2) AS BIZ_PARTNER_REF_KEY2" ).append("\n"); 
		query.append("                      , MAX(LINE_ITEM_REF_KEY) AS LINE_ITEM_REF_KEY" ).append("\n"); 
		query.append("                      , MAX(INSTRUCTION_KEY1) AS INSTRUCTION_KEY1" ).append("\n"); 
		query.append("                      , MAX(INSTRUCTION_KEY2) AS INSTRUCTION_KEY2" ).append("\n"); 
		query.append("                      , MAX(INSTRUCTION_KEY3) AS INSTRUCTION_KEY3" ).append("\n"); 
		query.append("                      , PAYMENT_REFERENCE" ).append("\n"); 
		query.append("                      , MAX(AUTOMATIC_PAY_CURRENCY) AS AUTOMATIC_PAY_CURRENCY" ).append("\n"); 
		query.append("                      , MAX(PAYMENT_CURR_AMOUNT) AS PAYMENT_CURR_AMOUNT" ).append("\n"); 
		query.append("                      , MAX(CONTRACT_NUMBER) AS CONTRACT_NUMBER" ).append("\n"); 
		query.append("                      , MAX(CONTRACT_TYPE) AS CONTRACT_TYPE" ).append("\n"); 
		query.append("                      , MAX(PAYMENT_REASON) AS PAYMENT_REASON" ).append("\n"); 
		query.append("                      , MAX(CLASSIFICATION) AS CLASSIFICATION" ).append("\n"); 
		query.append("                      , MAX(ACTIVITY_PLACE) AS ACTIVITY_PLACE " ).append("\n"); 
		query.append("                      , MAX(ENTERTAINMENT_EXP_ID) AS ENTERTAINMENT_EXP_ID" ).append("\n"); 
		query.append("                      , MAX(BUDGET_MANAGE_DIVISION) AS BUDGET_MANAGE_DIVISION" ).append("\n"); 
		query.append("                      , MAX(ACTIVITY_DATE) AS ACTIVITY_DATE" ).append("\n"); 
		query.append("                      , MAX(VESSEL) AS VESSEL" ).append("\n"); 
		query.append("                      , MAX(VVL_CODE) AS VVL_CODE" ).append("\n"); 
		query.append("                      , MAX(HOUSE_BANK) AS HOUSE_BANK" ).append("\n"); 
		query.append("                      , MAX(PAYMENT_BLOCK_KEY) AS PAYMENT_BLOCK_KEY" ).append("\n"); 
		query.append("                      , MAX(CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append("                      , MAX(CRE_DT) AS CRE_DT" ).append("\n"); 
		query.append("                      , MAX(UPD_USR_ID) AS UPD_USR_ID" ).append("\n"); 
		query.append("                      , MAX(UPD_DT) AS UPD_DT" ).append("\n"); 
		query.append("                      , MAX(INTERFACE_FLAG) AS INTERFACE_FLAG" ).append("\n"); 
		query.append("                      , MAX(INTERFACE_FILE_ID) AS INTERFACE_FILE_ID" ).append("\n"); 
		query.append("                      , MAX(INTERFACE_DATE) AS INTERFACE_DATE" ).append("\n"); 
		query.append("                      , 'LIABILITY(TAX)' AS IF_ITEM_CATEGROY" ).append("\n"); 
		query.append("                FROM    (     " ).append("\n"); 
		query.append("                        SELECT  @[slip_interface_seq]               AS SLIP_IF_SEQ_NO" ).append("\n"); 
		query.append("                              , NULL                                AS RECORD_ID" ).append("\n"); 
		query.append("                              , '1000'                              AS COMPANY_CODE" ).append("\n"); 
		query.append("                              , 'H5'                                AS DOCUMENT_TYPE" ).append("\n"); 
		query.append("                              , TO_CHAR(SIH.INV_DT, 'YYYYMMDD')     AS DOCUMENT_DATE" ).append("\n"); 
		query.append("                              , SIH.GL_DT                           AS POSTING_DATE" ).append("\n"); 
		query.append("                              , SUBSTR(SIH.INV_NO, 1, 16)           AS REFERENCE_DOCUMENT_NO" ).append("\n"); 
		query.append("                              , 'OPR305' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') AS DOCUMENT_HEADER_TEXT" ).append("\n"); 
		query.append("                              , SIH.INV_CURR_CD                     AS CURRENCE_CODE" ).append("\n"); 
		query.append("                              , NULL                                AS TAX_CALCULATE_AUTO_FLAG" ).append("\n"); 
		query.append("                              , NULL                                AS POST_KEY" ).append("\n"); 
		query.append("                              , NULL                                AS TAX_ON_SALES" ).append("\n"); 
		query.append("                              , SID.DTRB_FUNC_AMT                   AS DTRB_FUNC_AMT " ).append("\n"); 
		query.append("                              , SID.DTRB_AMT                        AS DTRB_AMT" ).append("\n"); 
		query.append("                              , NULL                                AS LOCAL_TAX_AMOUNT" ).append("\n"); 
		query.append("                              , NULL                                AS DOCUMENT_TAX_AMOUNT" ).append("\n"); 
		query.append("                              , SUBSTR(SIH.INV_NO, 1, 16)           AS ASSIGNMENT_NUMBER" ).append("\n"); 
		query.append("                              , SIH.OFC_CD || ':' || CU.USR_NM      AS ITEM_TEXT    " ).append("\n"); 
		query.append("                              , NULL                                AS PLANNING_DATE" ).append("\n"); 
		query.append("                              , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD LIKE '814%' THEN 'ZSGA' --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                                     WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD = '8705300000' THEN 'Z002' --Overseas Income Tax(P123)" ).append("\n"); 
		query.append("                                     WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD NOT LIKE '954%' AND MA.ACCT_CD <> '211691' THEN " ).append("\n"); 
		query.append("                                     NVL((SELECT MT.MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = SID.ATTR_CTNT7 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                         NVL((SELECT DECODE(MVSL.VSL_SLAN_CD, 'COM', NULL, 'CNT', NULL, MVSL.MODI_COST_CTR_CD) FROM MDM_VSL_SVC_LANE MVSL WHERE MVSL.VSL_SLAN_CD = SID.ATTR_CTNT14), " ).append("\n"); 
		query.append("                                                NVL(DECODE((SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                                            AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1), 'ZH', MO.MODI_COST_CTR_CD," ).append("\n"); 
		query.append("                                                           (SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                                            AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1)), --2015.02.11 수정 " ).append("\n"); 
		query.append("                                                     'A106') ) )" ).append("\n"); 
		query.append("                                     WHEN SIH.AP_INV_SRC_CD = 'AR' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN" ).append("\n"); 
		query.append("                                     NVL((SELECT DECODE(MVSL.VSL_SLAN_CD, 'COM', NULL, 'CNT', NULL, MVSL.MODI_COST_CTR_CD) FROM MDM_VSL_SVC_LANE MVSL WHERE MVSL.VSL_SLAN_CD = SID.ATTR_CTNT14), --2015.02.04 수정" ).append("\n"); 
		query.append("                                            NVL(DECODE((SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                                        AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1), 'ZH', MO.MODI_COST_CTR_CD," ).append("\n"); 
		query.append("                                                       (SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                                        AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1)), --2015.02.11 수정 " ).append("\n"); 
		query.append("                                                  'A106') ) " ).append("\n"); 
		query.append("                                     WHEN SID.LINE_TP_LU_CD = 'WITHHOLDING TAX' THEN NULL ELSE NULL END" ).append("\n"); 
		query.append("                                                                    AS COST_CENTER " ).append("\n"); 
		query.append("                              , NULL                                AS ORDER_NUMBER" ).append("\n"); 
		query.append("                              , NULL                                AS MAIN_ASSET_NUMBER" ).append("\n"); 
		query.append("                              , NULL                                AS ASSET_SUB_NUMBER" ).append("\n"); 
		query.append("                              , NULL                                AS ASSET_TRANSACTION_TYPE" ).append("\n"); 
		query.append("                              , NULL                                AS ASSET_VALUE_DATE" ).append("\n"); 
		query.append("                              , NULL                                AS GL_ACCOUNT_NO" ).append("\n"); 
		query.append("                              , NULL                                AS CUSTOMER_NUMBER" ).append("\n"); 
		query.append("                              , 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') AS VENDOR_ACCOUNT_NO  --2015.03.30 수정" ).append("\n"); 
		query.append("                              , (SELECT TO_CHAR(SPS.DUE_DT, 'YYYYMMDD') FROM SAP_PAY_SKD SPS WHERE SPS.INV_SEQ = SIH.INV_SEQ AND ROWNUM = 1) AS CALCULATE_DUE_DATE" ).append("\n"); 
		query.append("                              , SUBSTR(SIH.PAY_MZD_LU_CD, 1, 1)     AS PAYMENT_METHOD " ).append("\n"); 
		query.append("                              , '218'                               AS STATE_CENTRAL_BANK" ).append("\n"); 
		query.append("                              , NULL                                AS MATERIAL_NO" ).append("\n"); 
		query.append("                              , NULL                                AS QUANTITY" ).append("\n"); 
		query.append("                              , NULL                                AS BASE_UNIT" ).append("\n"); 
		query.append("                              , NULL                                AS PROFIT_CENTER " ).append("\n"); 
		query.append("                              , '6038001000'                        AS ALTERNATIVE_ACCOUNT_NO  --2015.01.20" ).append("\n"); 
		query.append("                              , NVL((SELECT MT.MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = SID.ATTR_CTNT7 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                    NVL((SELECT DECODE(MVSL.VSL_SLAN_CD, 'COM', NULL, 'CNT', NULL, MVSL.MODI_COST_CTR_CD) FROM MDM_VSL_SVC_LANE MVSL WHERE MVSL.VSL_SLAN_CD = SID.ATTR_CTNT14), " ).append("\n"); 
		query.append("                                           NVL(DECODE((SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                                       AND     SSCC.SRC_CD = (SELECT MIN(MA3.MODI_ACCT_CD) FROM SAP_INV_DTL SID1, SCO_LEGR_CD_CMB SLCC2, MDM_ACCOUNT MA3" ).append("\n"); 
		query.append("                                                                              WHERE  SID1.DTRB_CD_CMB_SEQ = SLCC2.CD_CMB_SEQ AND SLCC2.SGM_CTNT4 = MA3.ACCT_CD" ).append("\n"); 
		query.append("                                                                              AND    SID1.INV_SEQ = SIH.INV_SEQ AND SID1.LINE_TP_LU_CD NOT IN ('PREPAY', 'TAX') AND SID1.ATTR_CTNT14 IS NOT NULL " ).append("\n"); 
		query.append("                                                                              AND    SID1.DTRB_LINE_NO = (SELECT MIN(SID2.DTRB_LINE_NO) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.ATTR_CTNT1 = SID.ATTR_CTNT1)) " ).append("\n"); 
		query.append("                                                       AND     SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1), 'ZH', MO.MODI_COST_CTR_CD," ).append("\n"); 
		query.append("                                                       (SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                                        AND     SSCC.SRC_CD = (SELECT MIN(MA3.MODI_ACCT_CD) FROM SAP_INV_DTL SID1, SCO_LEGR_CD_CMB SLCC2, MDM_ACCOUNT MA3" ).append("\n"); 
		query.append("                                                                               WHERE  SID1.DTRB_CD_CMB_SEQ = SLCC2.CD_CMB_SEQ AND SLCC2.SGM_CTNT4 = MA3.ACCT_CD" ).append("\n"); 
		query.append("                                                                               AND    SID1.INV_SEQ = SIH.INV_SEQ AND SID1.LINE_TP_LU_CD NOT IN ('PREPAY', 'TAX') AND SID1.ATTR_CTNT14 IS NOT NULL " ).append("\n"); 
		query.append("                                                                               AND    SID1.DTRB_LINE_NO = (SELECT MIN(SID2.DTRB_LINE_NO) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.ATTR_CTNT1 = SID.ATTR_CTNT1))" ).append("\n"); 
		query.append("                                                        AND     SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1)), --2015.02.11 수정 " ).append("\n"); 
		query.append("                                                'A106') ) )         AS BIZ_PARTNER_REF_KEY1 --2015.02.09 수정 --2015.01.28 수정 " ).append("\n"); 
		query.append("                              , 'GT'                                AS BIZ_PARTNER_REF_KEY2 " ).append("\n"); 
		query.append("                              , MO.MODI_AGN_CD                      AS LINE_ITEM_REF_KEY   -- 2015.01.08 변경 -- Office SAP-ID (Code Conversion)" ).append("\n"); 
		query.append("                              , NULL                                AS INSTRUCTION_KEY1" ).append("\n"); 
		query.append("                              , NULL                                AS INSTRUCTION_KEY2" ).append("\n"); 
		query.append("                              , NULL                                AS INSTRUCTION_KEY3" ).append("\n"); 
		query.append("                              , SID.ATTR_CTNT1                      AS PAYMENT_REFERENCE " ).append("\n"); 
		query.append("                              , NULL                                AS AUTOMATIC_PAY_CURRENCY" ).append("\n"); 
		query.append("                              , NULL                                AS PAYMENT_CURR_AMOUNT" ).append("\n"); 
		query.append("                              , 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') AS CONTRACT_NUMBER --2015.03.30 수정" ).append("\n"); 
		query.append("                              , 'Z'                                 AS CONTRACT_TYPE" ).append("\n"); 
		query.append("                              , NULL                                AS PAYMENT_REASON" ).append("\n"); 
		query.append("                              , NULL                                AS CLASSIFICATION" ).append("\n"); 
		query.append("                               , NULL                                AS ACTIVITY_PLACE " ).append("\n"); 
		query.append("                              , NULL                                AS ENTERTAINMENT_EXP_ID" ).append("\n"); 
		query.append("                              , NULL                                AS BUDGET_MANAGE_DIVISION" ).append("\n"); 
		query.append("                              , NULL                                AS ACTIVITY_DATE" ).append("\n"); 
		query.append("                              , NULL                                AS VESSEL" ).append("\n"); 
		query.append("                              , NULL                                AS VVL_CODE" ).append("\n"); 
		query.append("                              , NULL                                AS HOUSE_BANK" ).append("\n"); 
		query.append("                              , NULL                                AS PAYMENT_BLOCK_KEY" ).append("\n"); 
		query.append("                              , @[usr_id]                           AS CRE_USR_ID" ).append("\n"); 
		query.append("                              , SYSDATE                             AS CRE_DT" ).append("\n"); 
		query.append("                              , @[usr_id]                           AS UPD_USR_ID" ).append("\n"); 
		query.append("                              , SYSDATE                             AS UPD_DT" ).append("\n"); 
		query.append("                              , 'N'                                 AS INTERFACE_FLAG" ).append("\n"); 
		query.append("                              , NULL                                AS INTERFACE_FILE_ID" ).append("\n"); 
		query.append("                              , NULL                                AS INTERFACE_DATE" ).append("\n"); 
		query.append("                              , SID.ATTR_CTNT14                     AS SERVICE_LANE" ).append("\n"); 
		query.append("                        FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("                              , SAP_INV_DTL SID" ).append("\n"); 
		query.append("                              , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("                              , COM_USER CU  " ).append("\n"); 
		query.append("                              , MDM_ACCOUNT MA " ).append("\n"); 
		query.append("                              , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                              , MDM_VENDOR MV --2015.01.21 추가 " ).append("\n"); 
		query.append("                              , MDM_ORGANIZATION MO2 --2015.03.30 추가" ).append("\n"); 
		query.append("                              , MDM_LOCATION ML --2015.03.30 추가" ).append("\n"); 
		query.append("                        WHERE   SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("                        AND     SIH.INV_SEQ = SID.INV_SEQ " ).append("\n"); 
		query.append("                        AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ --2015.01.21 추가" ).append("\n"); 
		query.append("                        AND     SIH.CRE_USR_ID = CU.USR_ID  " ).append("\n"); 
		query.append("                        AND     SLCC.SGM_CTNT4 = MA.ACCT_CD " ).append("\n"); 
		query.append("                        AND     SIH.OFC_CD = MO.OFC_CD  " ).append("\n"); 
		query.append("                        AND     MV.OFC_CD = MO2.OFC_CD -- 2015.03.30 추가" ).append("\n"); 
		query.append("                        AND     MO2.LOC_CD = ML.LOC_CD -- 2015.03.30 추가" ).append("\n"); 
		query.append("                        AND     SIH.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("                        AND     SID.LINE_TP_LU_CD NOT IN ( 'PREPAY' )" ).append("\n"); 
		query.append("                        AND     SID.DTRB_AMT <> 0)" ).append("\n"); 
		query.append("               GROUP   BY DECODE(SUBSTR(NVL(COST_CENTER, BIZ_PARTNER_REF_KEY1), 1, 1), 'Z', 'A106', NVL(COST_CENTER, BIZ_PARTNER_REF_KEY1)), PAYMENT_REFERENCE, CURRENCE_CODE, SERVICE_LANE" ).append("\n"); 
		query.append("               HAVING  SUM(DTRB_AMT) <> 0 " ).append("\n"); 
		query.append("               )" ).append("\n"); 

	}
}