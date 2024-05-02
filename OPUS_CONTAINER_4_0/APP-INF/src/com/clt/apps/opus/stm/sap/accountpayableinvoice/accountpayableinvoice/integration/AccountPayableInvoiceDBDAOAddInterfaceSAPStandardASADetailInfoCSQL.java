/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddInterfaceSAPStandardASADetailInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
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

public class AccountPayableInvoiceDBDAOAddInterfaceSAPStandardASADetailInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddInterfaceSAPStandardASADetailInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddInterfaceSAPStandardASADetailInfoCSQL(){
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
		query.append("FileName : AccountPayableInvoiceDBDAOAddInterfaceSAPStandardASADetailInfoCSQL").append("\n"); 
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
		query.append("      ( AP_IF_SEQ" ).append("\n"); 
		query.append("      , IF_SEQ_NO" ).append("\n"); 
		query.append("      , REC_ID" ).append("\n"); 
		query.append("      , ACCT_CO_CD" ).append("\n"); 
		query.append("      , IF_DOC_TP_CD" ).append("\n"); 
		query.append("      , DOC_DT" ).append("\n"); 
		query.append("      , PST_DT" ).append("\n"); 
		query.append("      , REF_DOC_NO" ).append("\n"); 
		query.append("      , DOC_HDR_CD" ).append("\n"); 
		query.append("      , CURR_CD" ).append("\n"); 
		query.append("      , TAX_CALC_AUTO_FLG" ).append("\n"); 
		query.append("      , PST_KEY_CD" ).append("\n"); 
		query.append("      , VAT_TAX_CD" ).append("\n"); 
		query.append("      , LOCL_AMT" ).append("\n"); 
		query.append("      , DOC_AMT" ).append("\n"); 
		query.append("      , LOCL_TAX_AMT" ).append("\n"); 
		query.append("      , DOC_TAX_AMT" ).append("\n"); 
		query.append("      , ASGN_NO" ).append("\n"); 
		query.append("      , ITM_DESC" ).append("\n"); 
		query.append("      , PLN_DT" ).append("\n"); 
		query.append("      , COST_CTR_CD" ).append("\n"); 
		query.append("      , ORD_NO" ).append("\n"); 
		query.append("      , MN_ASET_NO" ).append("\n"); 
		query.append("      , SUB_ASET_NO" ).append("\n"); 
		query.append("      , ASET_TJ_TP_CD" ).append("\n"); 
		query.append("      , ASET_VAL_DT" ).append("\n"); 
		query.append("      , GL_ACCT_NO" ).append("\n"); 
		query.append("      , CUST_NO" ).append("\n"); 
		query.append("      , VNDR_CRTR_ACCT_NO" ).append("\n"); 
		query.append("      , DUE_DT_CALC_BSEL_DT" ).append("\n"); 
		query.append("      , PAY_MZD_CD" ).append("\n"); 
		query.append("      , STE_CNTRL_BANK_IND_CD" ).append("\n"); 
		query.append("      , MTRL_NO" ).append("\n"); 
		query.append("      , FUEL_LAND_QTY" ).append("\n"); 
		query.append("      , MEAS_BSE_UT_CD" ).append("\n"); 
		query.append("      , PFITCTR_CD" ).append("\n"); 
		query.append("      , ALTN_ACCT_NO" ).append("\n"); 
		query.append("      , BIZ_PRNR_REF_KEY_CD1" ).append("\n"); 
		query.append("      , BIZ_PRNR_REF_KEY_CD2" ).append("\n"); 
		query.append("      , LINE_ITM_REF_KEY_CD" ).append("\n"); 
		query.append("      , INSTR_KEY_CD1" ).append("\n"); 
		query.append("      , INSTR_KEY_CD2" ).append("\n"); 
		query.append("      , INSTR_KEY_CD3" ).append("\n"); 
		query.append("      , PAY_REF_CD" ).append("\n"); 
		query.append("      , AUTOMTC_PAY_CURR_CD" ).append("\n"); 
		query.append("      , PAY_CURR_AMT" ).append("\n"); 
		query.append("      , CTRT_NO" ).append("\n"); 
		query.append("      , CTRT_TP_CD" ).append("\n"); 
		query.append("      , PAY_RSN_CD" ).append("\n"); 
		query.append("      , CLSS_CD" ).append("\n"); 
		query.append("      , ACT_PLC_CD" ).append("\n"); 
		query.append("      , ENTR_EXPN_ID" ).append("\n"); 
		query.append("      , BUD_MGMT_DIV_CD" ).append("\n"); 
		query.append("      , ACT_DT" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , VVL_CD" ).append("\n"); 
		query.append("      , HUS_BANK_ID" ).append("\n"); 
		query.append("      , PAY_BLCK_KEY_CD" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append("      , IF_FLG" ).append("\n"); 
		query.append("      , IF_FILE_ID" ).append("\n"); 
		query.append("      , IF_DT" ).append("\n"); 
		query.append("      , IF_ITM_CATE_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      SELECT  SAP_IF_TO_SAP_SEQ.NEXTVAL           AS IF_SEQ" ).append("\n"); 
		query.append("            , @[slip_interface_seq]               AS SLIP_IF_SEQ_NO" ).append("\n"); 
		query.append("            , NULL                                AS RECORD_ID" ).append("\n"); 
		query.append("            , '1000'                              AS COMPANY_CODE" ).append("\n"); 
		query.append("            , 'H5'                                AS DOCUMENT_TYPE" ).append("\n"); 
		query.append("            , TO_CHAR(SIH.INV_DT, 'YYYYMMDD')     AS DOCUMENT_DATE" ).append("\n"); 
		query.append("            , SIH.GL_DT                           AS POSTING_DATE" ).append("\n"); 
		query.append("            , SUBSTR(SIH.INV_NO, 1, 16)           AS REFERENCE_DOCUMENT_NO" ).append("\n"); 
		query.append("            , 'OPR305' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') AS DOCUMENT_HEADER_TEXT" ).append("\n"); 
		query.append("            , SIH.INV_CURR_CD                     AS CURRENCE_CODE" ).append("\n"); 
		query.append("            , NULL                                AS TAX_CALCULATE_AUTO_FLAG" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') AND SID.DTRB_AMT < 0 THEN '50' --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') AND SID.DTRB_AMT >= 0 THEN '40' --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.ACCT_CD IN ('954116', '954115', '954117') AND SID.DTRB_AMT < 0 THEN '11' --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.ACCT_CD IN ('954116', '954115', '954117') AND SID.DTRB_AMT >= 0 THEN '01' --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("              ELSE '40' END                       AS POST_KEY" ).append("\n"); 
		query.append("            , CASE WHEN MA.ACCT_CD IN ('954116', '954115', '954117') THEN NULL ELSE 'F0' END AS TAX_ON_SALES --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("            , DECODE(SIH.INV_CURR_CD, @[functional_currency], NULL, ABS(NVL(SID.DTRB_FUNC_AMT, 0))) AS LOCAL_AMOUNT -- 2014.10.27 금액수정" ).append("\n"); 
		query.append("            , ABS(NVL(SID.DTRB_AMT, 0))           AS DOCUMENT_AMOUNT" ).append("\n"); 
		query.append("            , NULL                                AS LOCAL_TAX_AMOUNT" ).append("\n"); 
		query.append("            , NULL                                AS DOCUMENT_TAX_AMOUNT" ).append("\n"); 
		query.append("            , SUBSTR(SIH.INV_NO, 1, 16)           AS ASSIGNMENT_NUMBER" ).append("\n"); 
		query.append("            , CASE WHEN MA.ACCT_CD IN ('954116', '954115', '954117') THEN NULL ELSE SIH.OFC_CD || ':' || CU.USR_NM END AS ITEM_TEXT --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("            , NULL                                AS PLANNING_DATE" ).append("\n"); 
		query.append("            , CASE WHEN MA.MODI_ACCT_CD LIKE '814%' THEN 'ZSGA' --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN MA.MODI_ACCT_CD = '8705300000' THEN 'Z002' --Overseas Income Tax(P123)" ).append("\n"); 
		query.append("                   WHEN MA.ACCT_CD IN ('954116', '954115', '954117') THEN NULL ELSE" ).append("\n"); 
		query.append("                   NVL((SELECT MT.MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = SID.ATTR_CTNT7 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                       NVL((SELECT DECODE(MVSL.VSL_SLAN_CD, 'COM', NULL, 'CNT', NULL, MVSL.MODI_COST_CTR_CD) FROM MDM_VSL_SVC_LANE MVSL WHERE MVSL.VSL_SLAN_CD = SID.ATTR_CTNT14), " ).append("\n"); 
		query.append("                                   NVL(DECODE((SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                               AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1), 'ZH', MO.MODI_COST_CTR_CD," ).append("\n"); 
		query.append("                                              (SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                               AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1)), --2015.02.11 수정 " ).append("\n"); 
		query.append("                                   'A106') ) ) END      AS COST_CENTER  --- 2015.10.01 REV(Local) 계정 추가  " ).append("\n"); 
		query.append("            , NULL                                AS ORDER_NUMBER" ).append("\n"); 
		query.append("            , NULL                                AS MAIN_ASSET_NUMBER" ).append("\n"); 
		query.append("            , NULL                                AS ASSET_SUB_NUMBER" ).append("\n"); 
		query.append("            , NULL                                AS ASSET_TRANSACTION_TYPE" ).append("\n"); 
		query.append("            , NULL                                AS ASSET_VALUE_DATE" ).append("\n"); 
		query.append("            , CASE WHEN MA.ACCT_CD IN ('954116', '954115', '954117') THEN NULL ELSE MA.MODI_ACCT_CD END AS GL_ACCOUNT_NO --- 2015.10.01 REV(Local) 계정 추가 " ).append("\n"); 
		query.append("            , CASE WHEN MA.ACCT_CD IN ('954116', '954115', '954117') THEN MO.MODI_AGN_CD ELSE NULL END AS CUSTOMER_NUMBER  --- 2015.10.01 REV(Local) 계정 추가 " ).append("\n"); 
		query.append("            , NULL                                AS VENDOR_ACCOUNT_NO" ).append("\n"); 
		query.append("            , NULL                                AS CALCULATE_DUE_DATE" ).append("\n"); 
		query.append("            , NULL                                AS PAYMENT_METHOD -- Payment Method (Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS STATE_CENTRAL_BANK" ).append("\n"); 
		query.append("            , NULL                                AS MATERIAL_NO" ).append("\n"); 
		query.append("            , NULL                                AS QUANTITY" ).append("\n"); 
		query.append("            , NULL                                AS BASE_UNIT" ).append("\n"); 
		query.append("            , CASE WHEN MA.MODI_ACCT_CD LIKE '814%' THEN 'ZSGA' --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN MA.MODI_ACCT_CD = '8705300000' THEN 'Z002' --Overseas Income Tax(P123)" ).append("\n"); 
		query.append("                   WHEN MA.ACCT_CD IN ('954116', '954115', '954117') THEN NULL ELSE" ).append("\n"); 
		query.append("                   NVL((SELECT MT.MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = SID.ATTR_CTNT7 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                       NVL((SELECT DECODE(MVSL.VSL_SLAN_CD, 'COM', NULL, 'CNT', NULL, MVSL.MODI_COST_CTR_CD) FROM MDM_VSL_SVC_LANE MVSL WHERE MVSL.VSL_SLAN_CD = SID.ATTR_CTNT14), " ).append("\n"); 
		query.append("                                   NVL(DECODE((SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                               AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1), 'ZH', MO.MODI_COST_CTR_CD," ).append("\n"); 
		query.append("                                              (SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                               AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1)), --2015.02.11 수정 " ).append("\n"); 
		query.append("                                   'A106') ) ) END     AS PROFIT_CENTER  --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("            , CASE WHEN MA.ACCT_CD IN ('954116', '954115', '954117') THEN MA.MODI_ACCT_CD ELSE NULL END AS ALTERNATIVE_ACCOUNT_NO --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("            , CASE WHEN MA.ACCT_CD IN ('954116', '954115', '954117') THEN 'A106' ELSE NULL END AS BIZ_PARTNER_REF_KEY1  --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("            , NULL                                AS BIZ_PARTNER_REF_KEY2 -- GT " ).append("\n"); 
		query.append("            , NULL                                AS LINE_ITEM_REF_KEY    -- Office SAP-ID (Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS INSTRUCTION_KEY1" ).append("\n"); 
		query.append("            , NULL                                AS INSTRUCTION_KEY2" ).append("\n"); 
		query.append("            , NULL                                AS INSTRUCTION_KEY3" ).append("\n"); 
		query.append("            , DECODE(MA.ACCT_CD, '954116', '35', '954115', '31', NULL) AS PAYMENT_REFERENCE --2015.10.20 WITHHOLDING or VAT  " ).append("\n"); 
		query.append("            , NULL                                AS AUTOMATIC_PAY_CURRENCY" ).append("\n"); 
		query.append("            , NULL                                AS PAYMENT_CURR_AMOUNT" ).append("\n"); 
		query.append("            , CASE WHEN MA.ACCT_CD IN ('954116', '954115', '954117') THEN MO.MODI_AGN_CD ELSE 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') END AS CONTRACT_NUMBER  --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("            , 'Z'                                 AS CONTRACT_TYPE" ).append("\n"); 
		query.append("            , NULL                                AS PAYMENT_REASON" ).append("\n"); 
		query.append("            , NULL                                AS CLASSIFICATION" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.MODI_ACCT_CD LIKE '814%' THEN '2550' --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') THEN --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                        NVL((SELECT ML.MODI_LOC_CD FROM MDM_YARD MY, MDM_LOCATION ML WHERE MY.LOC_CD = ML.LOC_CD AND MY.YD_CD = SID.ATTR_CTNT12 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                            NVL((SELECT ML.MODI_LOC_CD FROM MDM_ORGANIZATION MO2, MDM_LOCATION ML WHERE MO2.LOC_CD = ML.LOC_CD AND MO2.OFC_CD = SID.ATTR_CTNT12 AND ROWNUM = 1), " ).append("\n"); 
		query.append("                                  (SELECT ML.MODI_LOC_CD FROM MDM_LOCATION ML WHERE ML.LOC_CD = SID.ATTR_CTNT12 AND ROWNUM = 1))) -- 2013.10.23 변경 --POL DTX code (Code Conversion)" ).append("\n"); 
		query.append("              ELSE NULL END                       AS ACTIVITY_PLACE " ).append("\n"); 
		query.append("            , NULL                                AS ENTERTAINMENT_EXP_ID" ).append("\n"); 
		query.append("            , NULL                                AS BUDGET_MANAGE_DIVISION" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') THEN --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                        SUBSTR(REPLACE(REPLACE(SID.ATTR_CTNT11, '/', ''), '-', ''), 1, 8) ELSE NULL END -- 2014.10.29 --2014.10.23 변경" ).append("\n"); 
		query.append("                                                  AS ACTIVITY_DATE" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.MODI_ACCT_CD LIKE '814%' THEN NULL --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.MODI_ACCT_CD = '8705300000' THEN NULL --Overseas Income Tax(P123)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.MODI_ACCT_CD = '5400269051' THEN NULL --Offset Account 951111, 953111" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND SUBSTR(SLCC.SGM_CTNT6, 1, 4) NOT IN ('CFDR', '0000', 'CNTC', 'COMC') AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') THEN --- 2015.10.01 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                        (SELECT MVC.MODI_VSL_CD FROM MDM_VSL_CNTR MVC WHERE MVC.VSL_CD = SUBSTR(SLCC.SGM_CTNT6, 1, 4) AND ROWNUM = 1) --2014.10.23 변경 --Trunk Vessel DTX code (Code Conversion)" ).append("\n"); 
		query.append("              ELSE NULL END                       AS VESSEL" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.MODI_ACCT_CD LIKE '814%' THEN NULL --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.MODI_ACCT_CD = '8705300000' THEN NULL --Overseas Income Tax(P123)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND MA.MODI_ACCT_CD = '5400269051' THEN NULL --Offset Account 951111, 953111" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT', 'WITHHOLDING TAX') AND SUBSTR(SLCC.SGM_CTNT6, 1, 4) NOT IN ('CFDR', '0000', 'CNTC', 'COMC') AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') THEN --- 2015.10.01 REV(Local) 계정 추가 " ).append("\n"); 
		query.append("                        (SELECT MVC.MODI_VSL_CD FROM MDM_VSL_CNTR MVC WHERE MVC.VSL_CD = SUBSTR(SLCC.SGM_CTNT6, 1, 4) AND ROWNUM = 1) || SUBSTR(SLCC.SGM_CTNT6, 6, 3) ||" ).append("\n"); 
		query.append("                        (SELECT SUBSTR(MVSLD.MODI_VSL_SLAN_DIR_CD, 1, 1) FROM MDM_VSL_SVC_LANE_DIR MVSLD " ).append("\n"); 
		query.append("                         WHERE  MVSLD.VSL_SLAN_CD = NVL(SID.ATTR_CTNT14, (SELECT VVS.VSL_SLAN_CD FROM VSK_VSL_SKD VVS WHERE VVS.VSL_CD||VVS.SKD_VOY_NO||VVS.SKD_DIR_CD = SUBSTR(SLCC.SGM_CTNT6, 1, 9) AND ROWNUM = 1))" ).append("\n"); 
		query.append("                         AND    MVSLD.VSL_SLAN_DIR_CD = SUBSTR(SLCC.SGM_CTNT6, 9, 1)) -- 2014.10.23 변경  --Trunk VVD DTX code (Code Conversion)" ).append("\n"); 
		query.append("              ELSE NULL END                       AS VVL_CODE" ).append("\n"); 
		query.append("            , NULL                                AS HOUSE_BANK" ).append("\n"); 
		query.append("            , NULL                                AS PAYMENT_BLOCK_KEY" ).append("\n"); 
		query.append("            , @[usr_id]                           AS CRE_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                             AS CRE_DT" ).append("\n"); 
		query.append("            , @[usr_id]                           AS UPD_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                             AS UPD_DT" ).append("\n"); 
		query.append("            , 'N'                                 AS INTERFACE_FLAG" ).append("\n"); 
		query.append("            , NULL                                AS INTERFACE_FILE_ID" ).append("\n"); 
		query.append("            , NULL                                AS INTERFACE_DATE" ).append("\n"); 
		query.append("            , CASE WHEN MA.MODI_ACCT_CD LIKE '814%' THEN 'OTHER TAX/DUES' --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN MA.MODI_ACCT_CD = '8705300000' THEN 'Overseas Income Tax' --Overseas Income Tax(P123)" ).append("\n"); 
		query.append("                   WHEN MA.MODI_ACCT_CD = '5400269051' THEN 'REV(Clearing)' --Offset Account 951111, 953111, 954111" ).append("\n"); 
		query.append("                   WHEN MA.ACCT_CD IN ('954116', '954115', '954117') THEN 'REV(LOCAL)' ELSE 'REV' END AS IF_ITEM_CATEGROY" ).append("\n"); 
		query.append("      FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("            , SAP_INV_DTL SID" ).append("\n"); 
		query.append("            , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("            , COM_USER CU  -- 2014.10.17 -- User 정보 추가" ).append("\n"); 
		query.append("            , MDM_ACCOUNT MA -- 2014.10.23 추가" ).append("\n"); 
		query.append("            , MDM_ORGANIZATION MO  --2015.01.20 추가" ).append("\n"); 
		query.append("            , MDM_VENDOR MV --2015.01.21 추가" ).append("\n"); 
		query.append("            , MDM_ORGANIZATION MO2 --2015.03.30 추가" ).append("\n"); 
		query.append("            , MDM_LOCATION ML --2015.03.30 추가" ).append("\n"); 
		query.append("      WHERE   SIH.INV_SEQ = SID.INV_SEQ " ).append("\n"); 
		query.append("      AND     SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("      AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ --2015.01.21 추가" ).append("\n"); 
		query.append("      AND     SIH.CRE_USR_ID = CU.USR_ID  -- 2014.10.17 -- User 정보 추가" ).append("\n"); 
		query.append("      AND     SLCC.SGM_CTNT4 = MA.ACCT_CD -- 2014.10.23 추가 " ).append("\n"); 
		query.append("      AND     SIH.OFC_CD = MO.OFC_CD --2015.01.20 추가" ).append("\n"); 
		query.append("      AND     MV.OFC_CD = MO2.OFC_CD -- 2015.03.30 추가" ).append("\n"); 
		query.append("      AND     MO2.LOC_CD = ML.LOC_CD -- 2015.03.30 추가" ).append("\n"); 
		query.append("      AND     SID.DTRB_AMT <> 0 --2015.02.03 추가" ).append("\n"); 
		query.append("      AND     SLCC.SGM_CTNT4 <> (SELECT  SLD.LU_CD FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("                                 WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'ASA CLEARING ACCOUNT' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                                 AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND SLH.LU_APPL_CD = 'SAP'AND ROWNUM = 1)" ).append("\n"); 
		query.append("      AND     SIH.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("      AND     SLCC.SGM_CTNT4 NOT IN (SELECT  SLD.LU_CD FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD   " ).append("\n"); 
		query.append("                                     WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'AP TAX ACCOUNT' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                                     AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND SLH.LU_APPL_CD = 'SAP'AND SLD.ATTR_CTNT1 IN ('EXTERNAL', 'INTERNAL', 'WITHHOLDING'))" ).append("\n"); 

	}
}