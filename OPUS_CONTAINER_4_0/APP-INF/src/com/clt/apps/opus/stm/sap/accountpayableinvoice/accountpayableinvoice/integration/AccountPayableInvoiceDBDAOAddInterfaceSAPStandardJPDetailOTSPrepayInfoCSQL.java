/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPDetailOTSPrepayInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.23 
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

public class AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPDetailOTSPrepayInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddInterfaceSAPStandardJPDetailOTSPrepayInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPDetailOTSPrepayInfoCSQL(){
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
		query.append("FileName : AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPDetailOTSPrepayInfoCSQL").append("\n"); 
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
		query.append("         SELECT  SAP_IF_TO_SAP_SEQ.NEXTVAL           AS IF_SEQ" ).append("\n"); 
		query.append("               , @[slip_interface_seq]               AS SLIP_IF_SEQ_NO" ).append("\n"); 
		query.append("               , NULL                                AS RECORD_ID" ).append("\n"); 
		query.append("               , '1000'                              AS COMPANY_CODE" ).append("\n"); 
		query.append("               , 'U5'                                AS DOCUMENT_TYPE" ).append("\n"); 
		query.append("               , TO_CHAR(SIH.INV_DT, 'YYYYMMDD')     AS DOCUMENT_DATE" ).append("\n"); 
		query.append("               , SIH.GL_DT                           AS POSTING_DATE" ).append("\n"); 
		query.append("               , SUBSTR(SIH.INV_NO, 1, 16)           AS REFERENCE_DOCUMENT_NO" ).append("\n"); 
		query.append("               , 'OPR305' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') AS DOCUMENT_HEADER_TEXT" ).append("\n"); 
		query.append("               , SIH.INV_CURR_CD                     AS CURRENCE_CODE" ).append("\n"); 
		query.append("               , NULL                                AS TAX_CALCULATE_AUTO_FLAG" ).append("\n"); 
		query.append("               , CASE WHEN SID.LINE_TP_LU_CD = 'PREPAY' AND ((SELECT  SID2.DTRB_AMT FROM SAP_INV_DTL SID2 WHERE SID.PPAY_INV_SEQ = SID2.INV_SEQ" ).append("\n"); 
		query.append("                                                              AND     SID.PPAY_LINE_NO = SID2.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                                                             (SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2 WHERE SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ" ).append("\n"); 
		query.append("                                                              AND     SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ >= SID2.INV_DTRB_SEQ)) < 0 THEN '11'" ).append("\n"); 
		query.append("                      WHEN SID.LINE_TP_LU_CD = 'PREPAY' AND ((SELECT  SID2.DTRB_AMT FROM SAP_INV_DTL SID2 WHERE SID.PPAY_INV_SEQ = SID2.INV_SEQ" ).append("\n"); 
		query.append("                                                              AND     SID.PPAY_LINE_NO = SID2.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                                                             (SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2 WHERE SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ" ).append("\n"); 
		query.append("                                                              AND     SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ >= SID2.INV_DTRB_SEQ)) >= 0 THEN '01'" ).append("\n"); 
		query.append("                 ELSE '01' END                       AS POST_KEY" ).append("\n"); 
		query.append("               , NULL                                AS TAX_ON_SALES" ).append("\n"); 
		query.append("               , CASE WHEN SIH.INV_CURR_CD = @[functional_currency] THEN NULL" ).append("\n"); 
		query.append("                 ELSE ROUND((((SELECT  SID2.DTRB_AMT FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                               WHERE   SID.PPAY_INV_SEQ = SID2.INV_SEQ AND SID.PPAY_LINE_NO = SID2.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                          NVL((SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                               WHERE   SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ AND SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ >= SID2.INV_DTRB_SEQ), 0)) +" ).append("\n"); 
		query.append("                            (((SELECT  SID2.DTRB_AMT FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                               WHERE   SID.PPAY_INV_SEQ = SID2.INV_SEQ AND SID.PPAY_LINE_NO = SID2.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                          NVL((SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                               WHERE   SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ AND SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ > SID2.INV_DTRB_SEQ), 0)) -" ).append("\n"); 
		query.append("                             ((SELECT  SID2.DTRB_AMT FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                               WHERE   SID.PPAY_INV_SEQ = SID2.INV_SEQ AND SID.PPAY_LINE_NO = SID2.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                          NVL((SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                               WHERE   SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ AND SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ >= SID2.INV_DTRB_SEQ), 0)))" ).append("\n"); 
		query.append("                               - ABS(SID.DTRB_AMT))" ).append("\n"); 
		query.append("                             * SIH.INV_XCH_RT, (SELECT  DP_PRCS_KNT FROM MDM_CURRENCY MC WHERE MC.CURR_CD = @[functional_currency] AND DELT_FLG = 'N' AND ROWNUM=1))" ).append("\n"); 
		query.append("                 END                                 AS LOCAL_AMOUNT --- 2015/01/16 건별 환율 적용에서 전체금액으로 대체 처리" ).append("\n"); 
		query.append("               , (SELECT  SID2.DTRB_AMT FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                  WHERE   SID.PPAY_INV_SEQ = SID2.INV_SEQ AND SID.PPAY_LINE_NO = SID2.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                 NVL((SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                      WHERE   SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ AND SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ >= SID2.INV_DTRB_SEQ), 0)" ).append("\n"); 
		query.append("                                                     AS DOCUMENT_AMOUNT" ).append("\n"); 
		query.append("               , NULL                                AS LOCAL_TAX_AMOUNT" ).append("\n"); 
		query.append("               , NULL                                AS DOCUMENT_TAX_AMOUNT" ).append("\n"); 
		query.append("               , SUBSTR(SIH.INV_NO, 1, 16)           AS ASSIGNMENT_NUMBER" ).append("\n"); 
		query.append("               , NULL                                AS ITEM_TEXT" ).append("\n"); 
		query.append("               , NULL                                AS PLANNING_DATE" ).append("\n"); 
		query.append("               , NULL                                AS COST_CENTER " ).append("\n"); 
		query.append("               , NULL                                AS ORDER_NUMBER" ).append("\n"); 
		query.append("               , NULL                                AS MAIN_ASSET_NUMBER" ).append("\n"); 
		query.append("               , NULL                                AS ASSET_SUB_NUMBER" ).append("\n"); 
		query.append("               , NULL                                AS ASSET_TRANSACTION_TYPE" ).append("\n"); 
		query.append("               , NULL                                AS ASSET_VALUE_DATE" ).append("\n"); 
		query.append("               , NULL                                AS GL_ACCOUNT_NO" ).append("\n"); 
		query.append("               , 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') AS CUSTOMER_NUMBER  -- 2015.03.30 변경 --- Office SAP-ID  (Code Conversion)" ).append("\n"); 
		query.append("               , NULL                                AS VENDOR_ACCOUNT_NO" ).append("\n"); 
		query.append("               , SIH.GL_DT                           AS CALCULATE_DUE_DATE" ).append("\n"); 
		query.append("               , NULL                                AS PAYMENT_METHOD " ).append("\n"); 
		query.append("               , NULL                                AS STATE_CENTRAL_BANK" ).append("\n"); 
		query.append("               , NULL                                AS MATERIAL_NO" ).append("\n"); 
		query.append("               , NULL                                AS QUANTITY" ).append("\n"); 
		query.append("               , NULL                                AS BASE_UNIT" ).append("\n"); 
		query.append("               , NULL                                AS PROFIT_CENTER " ).append("\n"); 
		query.append("               , '5226500000'                        AS ALTERNATIVE_ACCOUNT_NO -- 2015.01.19 하드코딩  2014.10.23 변경  --- VTM의 G/L Account 처리 MA.MODI_ACCT_CD " ).append("\n"); 
		query.append("               , NVL((SELECT MT.MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = SID.ATTR_CTNT7 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                     NVL((SELECT DECODE(MVSL.VSL_SLAN_CD, 'COM', NULL, 'CNT', NULL, MVSL.MODI_COST_CTR_CD) FROM MDM_VSL_SVC_LANE MVSL WHERE MVSL.VSL_SLAN_CD = SID.ATTR_CTNT14), " ).append("\n"); 
		query.append("                            NVL(DECODE((SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                        AND     SSCC.SRC_CD = MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("                                                              --(SELECT MIN(MA3.MODI_ACCT_CD) FROM SAP_INV_DTL SID1, SCO_LEGR_CD_CMB SLCC2, MDM_ACCOUNT MA3" ).append("\n"); 
		query.append("                                                              -- WHERE  SID1.DTRB_CD_CMB_SEQ = SLCC2.CD_CMB_SEQ AND SLCC2.SGM_CTNT4 = MA3.ACCT_CD" ).append("\n"); 
		query.append("                                                              -- AND    SID1.INV_SEQ = SIH.INV_SEQ AND SID1.LINE_TP_LU_CD NOT IN ('PREPAY', 'TAX') AND SID1.ATTR_CTNT14 IS NOT NULL " ).append("\n"); 
		query.append("                                                              -- AND    SID1.DTRB_LINE_NO = (SELECT MIN(SID2.DTRB_LINE_NO) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.ATTR_CTNT1 = SID.ATTR_CTNT1)) " ).append("\n"); 
		query.append("                                        AND     SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1), 'ZH', MO.MODI_COST_CTR_CD," ).append("\n"); 
		query.append("                                       (SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                        AND     SSCC.SRC_CD = MA.MODI_ACCT_CD" ).append("\n"); 
		query.append("                                                              --(SELECT MIN(MA3.MODI_ACCT_CD) FROM SAP_INV_DTL SID1, SCO_LEGR_CD_CMB SLCC2, MDM_ACCOUNT MA3" ).append("\n"); 
		query.append("                                                              -- WHERE  SID1.DTRB_CD_CMB_SEQ = SLCC2.CD_CMB_SEQ AND SLCC2.SGM_CTNT4 = MA3.ACCT_CD" ).append("\n"); 
		query.append("                                                              -- AND    SID1.INV_SEQ = SIH.INV_SEQ AND SID1.LINE_TP_LU_CD NOT IN ('PREPAY', 'TAX') AND SID1.ATTR_CTNT14 IS NOT NULL " ).append("\n"); 
		query.append("                                                              -- AND    SID1.DTRB_LINE_NO = (SELECT MIN(SID2.DTRB_LINE_NO) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.ATTR_CTNT1 = SID.ATTR_CTNT1))" ).append("\n"); 
		query.append("                                        AND     SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1)), --2015.02.11 수정 " ).append("\n"); 
		query.append("                                 'A106') ) )         AS BIZ_PARTNER_REF_KEY1 --2015.02.09 수정 --2015.01.28 수정 -- Profit Center (Code Conversion)  --2015.01.26 수정" ).append("\n"); 
		query.append("               , NULL                                AS BIZ_PARTNER_REF_KEY2 " ).append("\n"); 
		query.append("               , NULL                                AS LINE_ITEM_REF_KEY    " ).append("\n"); 
		query.append("               , NULL                                AS INSTRUCTION_KEY1" ).append("\n"); 
		query.append("               , NULL                                AS INSTRUCTION_KEY2" ).append("\n"); 
		query.append("               , NULL                                AS INSTRUCTION_KEY3" ).append("\n"); 
		query.append("               , NULL                                AS PAYMENT_REFERENCE" ).append("\n"); 
		query.append("               , NULL                                AS AUTOMATIC_PAY_CURRENCY" ).append("\n"); 
		query.append("               , NULL                                AS PAYMENT_CURR_AMOUNT" ).append("\n"); 
		query.append("               , 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') AS CONTRACT_NUMBER  -- 2015.03.30 변경 --- Office SAP-ID  (Code Conversion)" ).append("\n"); 
		query.append("               , 'Z'                                 AS CONTRACT_TYPE" ).append("\n"); 
		query.append("               , NULL                                AS PAYMENT_REASON" ).append("\n"); 
		query.append("               , NULL                                AS CLASSIFICATION" ).append("\n"); 
		query.append("               , NULL                                AS ACTIVITY_PLACE " ).append("\n"); 
		query.append("               , NULL                                AS ENTERTAINMENT_EXP_ID" ).append("\n"); 
		query.append("               , NULL                                AS BUDGET_MANAGE_DIVISION" ).append("\n"); 
		query.append("               , NULL                                AS ACTIVITY_DATE" ).append("\n"); 
		query.append("               , NULL                                AS VESSEL    " ).append("\n"); 
		query.append("               , NULL                                AS VVL_CODE  " ).append("\n"); 
		query.append("               , NULL                                AS HOUSE_BANK" ).append("\n"); 
		query.append("               , NULL                                AS PAYMENT_BLOCK_KEY" ).append("\n"); 
		query.append("               , @[usr_id]                           AS CRE_USR_ID" ).append("\n"); 
		query.append("               , SYSDATE                             AS CRE_DT" ).append("\n"); 
		query.append("               , @[usr_id]                           AS UPD_USR_ID" ).append("\n"); 
		query.append("               , SYSDATE                             AS UPD_DT" ).append("\n"); 
		query.append("               , 'N'                                 AS INTERFACE_FLAG" ).append("\n"); 
		query.append("               , NULL                                AS INTERFACE_FILE_ID" ).append("\n"); 
		query.append("               , NULL                                AS INTERFACE_DATE" ).append("\n"); 
		query.append("               , 'PREPAY(REMAIN)'                    AS IF_ITEM_CATEGROY" ).append("\n"); 
		query.append("         FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("               , SAP_INV_DTL SID" ).append("\n"); 
		query.append("               , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("               , MDM_ACCOUNT MA " ).append("\n"); 
		query.append("               , MDM_ORGANIZATION MO " ).append("\n"); 
		query.append("               , MDM_VENDOR MV --2015.01.26 추가" ).append("\n"); 
		query.append("               , MDM_ORGANIZATION MO2 --2015.03.30 추가" ).append("\n"); 
		query.append("               , MDM_LOCATION ML --2015.03.30 추가" ).append("\n"); 
		query.append("         WHERE   SIH.INV_SEQ = SID.INV_SEQ " ).append("\n"); 
		query.append("         AND     SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("         AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ --2015.01.26 추가" ).append("\n"); 
		query.append("         AND     SLCC.SGM_CTNT4 = MA.ACCT_CD " ).append("\n"); 
		query.append("         AND     SIH.OFC_CD = MO.OFC_CD " ).append("\n"); 
		query.append("         AND     MV.OFC_CD = MO2.OFC_CD -- 2015.03.30 추가" ).append("\n"); 
		query.append("         AND     MO2.LOC_CD = ML.LOC_CD -- 2015.03.30 추가" ).append("\n"); 
		query.append("         AND     SID.LINE_TP_LU_CD = 'PREPAY' " ).append("\n"); 
		query.append("         AND     NVL(SID.RVS_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("         AND     ((SELECT  SID2.DTRB_AMT FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                   WHERE   SID.PPAY_INV_SEQ = SID2.INV_SEQ AND SID.PPAY_LINE_NO = SID2.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                  (SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                   WHERE   SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ AND SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ >= SID2.INV_DTRB_SEQ)) > 0" ).append("\n"); 
		query.append("         AND     SIH.INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}