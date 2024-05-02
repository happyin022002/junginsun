/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPDetailOverseasTAXInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.02 
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

public class AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPDetailOverseasTAXInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddInterfaceSAPStandardNonJPDetailOverseasTAXInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPDetailOverseasTAXInfoCSQL(){
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
		query.append("FileName : AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPDetailOverseasTAXInfoCSQL").append("\n"); 
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
		query.append("            , CASE WHEN SID.DTRB_AMT < 0 THEN '11'           " ).append("\n"); 
		query.append("                   WHEN SID.DTRB_AMT >= 0 THEN '01'" ).append("\n"); 
		query.append("              ELSE '01' END                       AS POST_KEY" ).append("\n"); 
		query.append("            , NULL                                AS TAX_ON_SALES" ).append("\n"); 
		query.append("            , DECODE(SIH.INV_CURR_CD, @[functional_currency], NULL, ABS(NVL(SID.DTRB_FUNC_AMT, 0))) AS LOCAL_AMOUNT  -- 2014.10.27 금액수정" ).append("\n"); 
		query.append("            , ABS(NVL(SID.DTRB_AMT, 0))           AS DOCUMENT_AMOUNT" ).append("\n"); 
		query.append("            , NULL                                AS LOCAL_TAX_AMOUNT" ).append("\n"); 
		query.append("            , NULL                                AS DOCUMENT_TAX_AMOUNT" ).append("\n"); 
		query.append("            , SUBSTR(SIH.INV_NO, 1, 16)           AS ASSIGNMENT_NUMBER" ).append("\n"); 
		query.append("            , NULL                                AS ITEM_TEXT" ).append("\n"); 
		query.append("            , NULL                                AS PLANNING_DATE" ).append("\n"); 
		query.append("            , NULL                                AS COST_CENTER   -- Profit Center(Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS ORDER_NUMBER" ).append("\n"); 
		query.append("            , NULL                                AS MAIN_ASSET_NUMBER" ).append("\n"); 
		query.append("            , NULL                                AS ASSET_SUB_NUMBER" ).append("\n"); 
		query.append("            , NULL                                AS ASSET_TRANSACTION_TYPE" ).append("\n"); 
		query.append("            , NULL                                AS ASSET_VALUE_DATE" ).append("\n"); 
		query.append("            , NULL                                AS GL_ACCOUNT_NO --- VTM의 G/L Account 처리" ).append("\n"); 
		query.append("            , MO.MODI_AGN_CD                      AS CUSTOMER_NUMBER  -- 2015.01.08 변경 --- Office SAP-ID  (Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS VENDOR_ACCOUNT_NO" ).append("\n"); 
		query.append("            , NULL                                AS CALCULATE_DUE_DATE" ).append("\n"); 
		query.append("            , NULL                                AS PAYMENT_METHOD -- Payment Method (Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS STATE_CENTRAL_BANK" ).append("\n"); 
		query.append("            , NULL                                AS MATERIAL_NO" ).append("\n"); 
		query.append("            , NULL                                AS QUANTITY" ).append("\n"); 
		query.append("            , NULL                                AS BASE_UNIT" ).append("\n"); 
		query.append("            , NULL                                AS PROFIT_CENTER -- Profit Center(Code Conversion)" ).append("\n"); 
		query.append("            , '5360000000'                        AS ALTERNATIVE_ACCOUNT_NO   --- VTM의 G/L Account 처리" ).append("\n"); 
		query.append("            , 'A106'                              AS BIZ_PARTNER_REF_KEY1 --2015.01.26 수정 -- Profit Center (Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS BIZ_PARTNER_REF_KEY2 -- GT " ).append("\n"); 
		query.append("            , NULL                                AS LINE_ITEM_REF_KEY    -- Office SAP-ID (Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS INSTRUCTION_KEY1" ).append("\n"); 
		query.append("            , NULL                                AS INSTRUCTION_KEY2" ).append("\n"); 
		query.append("            , NULL                                AS INSTRUCTION_KEY3" ).append("\n"); 
		query.append("            , '31'                                AS PAYMENT_REFERENCE" ).append("\n"); 
		query.append("            , NULL                                AS AUTOMATIC_PAY_CURRENCY" ).append("\n"); 
		query.append("            , NULL                                AS PAYMENT_CURR_AMOUNT" ).append("\n"); 
		query.append("            , MO.MODI_AGN_CD                      AS CONTRACT_NUMBER    -- 2015.01.08 변경 --- Office SAP-ID  (Code Conversion)" ).append("\n"); 
		query.append("            , 'Z'                                 AS CONTRACT_TYPE" ).append("\n"); 
		query.append("            , NULL                                AS PAYMENT_REASON" ).append("\n"); 
		query.append("            , NULL                                AS CLASSIFICATION" ).append("\n"); 
		query.append("            , NULL                                AS ACTIVITY_PLACE  --POL DTX code (Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS ENTERTAINMENT_EXP_ID" ).append("\n"); 
		query.append("            , NULL                                AS BUDGET_MANAGE_DIVISION" ).append("\n"); 
		query.append("            , NULL                                AS ACTIVITY_DATE" ).append("\n"); 
		query.append("            , NULL                                AS VESSEL  --Trunk Vessel DTX code (Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS VVL_CODE --Trunk VVD DTX code (Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS HOUSE_BANK" ).append("\n"); 
		query.append("            , NULL                                AS PAYMENT_BLOCK_KEY" ).append("\n"); 
		query.append("            , @[usr_id]                           AS CRE_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                             AS CRE_DT" ).append("\n"); 
		query.append("            , @[usr_id]                           AS UPD_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE                             AS UPD_DT" ).append("\n"); 
		query.append("            , 'N'                                 AS INTERFACE_FLAG" ).append("\n"); 
		query.append("            , NULL                                AS INTERFACE_FILE_ID" ).append("\n"); 
		query.append("            , NULL                                AS INTERFACE_DATE" ).append("\n"); 
		query.append("            , 'TAX(OVERSEAS)'                     AS IF_ITEM_CATEGROY" ).append("\n"); 
		query.append("      FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("            , SAP_INV_DTL SID" ).append("\n"); 
		query.append("            , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("            , MDM_ORGANIZATION MO -- 2014.10.23 추가 " ).append("\n"); 
		query.append("      WHERE   SIH.INV_SEQ = SID.INV_SEQ " ).append("\n"); 
		query.append("      AND     SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("      AND     SIH.OFC_CD = MO.OFC_CD -- 2014.10.23 추가 " ).append("\n"); 
		query.append("      AND     SID.LINE_TP_LU_CD <> 'PREPAY'   " ).append("\n"); 
		query.append("      AND     SID.DTRB_AMT <> 0 --2015.02.03 추가" ).append("\n"); 
		query.append("      AND     SIH.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("      AND     SLCC.SGM_CTNT4 IN (SELECT  SLD.LU_CD FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD  " ).append("\n"); 
		query.append("                                 WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'AP TAX ACCOUNT' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                                 AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND SLH.LU_APPL_CD = 'SAP'AND SLD.ATTR_CTNT1 IN ('EXTERNAL', 'INTERNAL'))" ).append("\n"); 

	}
}