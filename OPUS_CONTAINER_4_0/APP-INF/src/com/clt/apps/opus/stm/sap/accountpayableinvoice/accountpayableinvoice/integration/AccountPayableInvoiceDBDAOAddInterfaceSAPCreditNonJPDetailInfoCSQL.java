/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOAddInterfaceSAPCreditNonJPDetailInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.03 
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

public class AccountPayableInvoiceDBDAOAddInterfaceSAPCreditNonJPDetailInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddInterfaceSAPCreditNonJPDetailInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOAddInterfaceSAPCreditNonJPDetailInfoCSQL(){
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
		query.append("FileName : AccountPayableInvoiceDBDAOAddInterfaceSAPCreditNonJPDetailInfoCSQL").append("\n"); 
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
		query.append("            , 'H7'                                AS DOCUMENT_TYPE" ).append("\n"); 
		query.append("            , TO_CHAR(SIH.INV_DT, 'YYYYMMDD')     AS DOCUMENT_DATE" ).append("\n"); 
		query.append("            , SIH.GL_DT                           AS POSTING_DATE" ).append("\n"); 
		query.append("            , SUBSTR(SIH.INV_NO, 1, 16)           AS REFERENCE_DOCUMENT_NO" ).append("\n"); 
		query.append("            , 'OPR305' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') AS DOCUMENT_HEADER_TEXT" ).append("\n"); 
		query.append("            , SIH.INV_CURR_CD                     AS CURRENCE_CODE" ).append("\n"); 
		query.append("            , NULL                                AS TAX_CALCULATE_AUTO_FLAG" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD = 'TAX' AND SID.DTRB_AMT < 0 THEN '11'" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD = 'TAX' AND SID.DTRB_AMT >= 0 THEN '01'" ).append("\n"); 
		query.append("                   WHEN (SID.LINE_TP_LU_CD = 'WITHHOLDING TAX' OR MA.ACCT_CD = '211691') AND SID.DTRB_AMT < 0 THEN '11'" ).append("\n"); 
		query.append("                   WHEN (SID.LINE_TP_LU_CD = 'WITHHOLDING TAX' OR MA.ACCT_CD = '211691') AND SID.DTRB_AMT >= 0 THEN '01'" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM <> 'REFUND' AND MA.ACCT_CD IN ('954116', '954115', '954117') AND SID.DTRB_AMT < 0 THEN '11'  --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM <> 'REFUND' AND MA.ACCT_CD IN ('954116', '954115', '954117') AND SID.DTRB_AMT >= 0 THEN '01' --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM <> 'REFUND' AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') AND SID.DTRB_AMT < 0 THEN '50' --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM <> 'REFUND' AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') AND SID.DTRB_AMT >= 0 THEN '40' --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM = 'REFUND'" ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'Y' AND SID.DTRB_AMT < 0 THEN '50'" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM = 'REFUND'" ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'Y' AND SID.DTRB_AMT >= 0 THEN '40'" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' " ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N' AND SID.DTRB_AMT < 0 THEN '11'" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' " ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N' AND SID.DTRB_AMT >= 0 THEN '01'" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' AND SID.DTRB_AMT < 0 THEN '50'" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' AND SID.DTRB_AMT >= 0 THEN '40'" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'N' AND MA.ACCT_CD IN ('954116', '954115', '954117') AND SID.DTRB_AMT < 0 THEN '11'  --2017.01.03 Rev Local Add" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'N' AND MA.ACCT_CD IN ('954116', '954115', '954117') AND SID.DTRB_AMT >= 0 THEN '01' --2017.01.03 Rev Local Add" ).append("\n"); 
		query.append("              ELSE '50' END                       AS POST_KEY" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD NOT LIKE '954%' AND MA.ACCT_CD <> '211691' THEN 'F0' ELSE NULL END AS TAX_ON_SALES" ).append("\n"); 
		query.append("            , CASE WHEN SIH.AP_INV_SRC_CD = 'AR' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN DECODE(SIH.INV_CURR_CD, @[functional_currency], NULL, ABS(NVL(SID.DTRB_FUNC_AMT, 0))) " ).append("\n"); 
		query.append("                   ELSE DECODE(SIH.INV_CURR_CD, @[functional_currency], NULL, ABS(NVL(SID.DTRB_FUNC_AMT, 0))) END AS LOCAL_AMOUNT -- 2014.10.27 금액수정" ).append("\n"); 
		query.append("            , CASE WHEN SIH.AP_INV_SRC_CD = 'AR' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN ABS(NVL(SID.DTRB_AMT, 0)) " ).append("\n"); 
		query.append("                   ELSE ABS(NVL(SID.DTRB_AMT, 0)) END AS DOCUMENT_AMOUNT" ).append("\n"); 
		query.append("            , NULL                                AS LOCAL_TAX_AMOUNT" ).append("\n"); 
		query.append("            , NULL                                AS DOCUMENT_TAX_AMOUNT" ).append("\n"); 
		query.append("            , CASE WHEN SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') THEN SUBSTR(SIH.INV_NO, 1, 16)" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' THEN SUBSTR(SIH.ATTR_CTNT4, 4, 16) " ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'ARAPOFFSET' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' THEN SUBSTR(SIH.ATTR_CTNT2, 4, 16) " ).append("\n"); 
		query.append("              ELSE SUBSTR(SIH.INV_NO, 1, 16) END AS ASSIGNMENT_NUMBER" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('ARAPOFFSET') AND MA.ACCT_CD NOT LIKE '954%' AND MA.ACCT_CD <> '211691' --2015.02.13 수정" ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("                        THEN SIH.OFC_CD || ':' || CU.USR_NM " ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' " ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N' THEN SIH.OFC_CD || ':' || CU.USR_NM ELSE NULL END  --2014.10.17 USER 정보 추가" ).append("\n"); 
		query.append("                                                  AS ITEM_TEXT" ).append("\n"); 
		query.append("            , CASE WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y'" ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N'" ).append("\n"); 
		query.append("                                                    THEN NVL((SELECT SR.RCT_DPS_DT FROM SAR_RECEIPT SR WHERE SR.RCT_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1),  " ).append("\n"); 
		query.append("                                                              (SELECT SAH.ADJ_DT FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1))" ).append("\n"); 
		query.append("                   ELSE NULL END                  AS PLANNING_DATE" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD LIKE '814%' THEN 'ZSGA' --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD = '8705300000' THEN 'Z002' --Overseas Income Tax(P123)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD IN ('954113', '954116', '954115', '954117', '954114') THEN 'Z002'  --2017.01.03 Rev Local Add" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD NOT LIKE '954%' AND MA.ACCT_CD <> '211691' THEN " ).append("\n"); 
		query.append("                        NVL((SELECT MT.MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = SID.ATTR_CTNT7 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                            NVL((SELECT DECODE(MVSL.VSL_SLAN_CD, 'COM', NULL, 'CNT', NULL, MVSL.MODI_COST_CTR_CD) FROM MDM_VSL_SVC_LANE MVSL WHERE MVSL.VSL_SLAN_CD = SID.ATTR_CTNT14), " ).append("\n"); 
		query.append("                                   NVL(DECODE((SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                               AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1), 'ZH', MO.MODI_COST_CTR_CD," ).append("\n"); 
		query.append("                                              (SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                               AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1)), --2015.02.11 수정 " ).append("\n"); 
		query.append("                                        'A106') ) )" ).append("\n"); 
		query.append("                   WHEN SIH.AP_INV_SRC_CD = 'AR' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN" ).append("\n"); 
		query.append("                   NVL((SELECT DECODE(MVSL.VSL_SLAN_CD, 'COM', NULL, 'CNT', NULL, MVSL.MODI_COST_CTR_CD) FROM MDM_VSL_SVC_LANE MVSL WHERE MVSL.VSL_SLAN_CD = SID.ATTR_CTNT14), --2015.02.04 수정" ).append("\n"); 
		query.append("                          NVL(DECODE((SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                      AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1), 'ZH', MO.MODI_COST_CTR_CD," ).append("\n"); 
		query.append("                                     (SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                      AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1)), --2015.02.11 수정 " ).append("\n"); 
		query.append("                                'A106') )" ).append("\n"); 
		query.append("              ELSE NULL END --2015.02.09 수정 --2015.01.28 수정" ).append("\n"); 
		query.append("                                                  AS COST_CENTER -- Profit Center(Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS ORDER_NUMBER" ).append("\n"); 
		query.append("            , NULL                                AS MAIN_ASSET_NUMBER" ).append("\n"); 
		query.append("            , NULL                                AS ASSET_SUB_NUMBER" ).append("\n"); 
		query.append("            , NULL                                AS ASSET_TRANSACTION_TYPE" ).append("\n"); 
		query.append("            , NULL                                AS ASSET_VALUE_DATE" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD <> '211691' AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') THEN MA.MODI_ACCT_CD --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM = 'ARAPOFFSET' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' THEN '5400269051' " ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'Y' THEN '5400269051'" ).append("\n"); 
		query.append("                   WHEN SIH.AP_INV_SRC_CD = 'AR' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 ) AND ROWNUM = 1),'N') = 'Y' THEN '8225101000'" ).append("\n"); 
		query.append("                   WHEN SIH.AP_INV_SRC_CD = 'AR' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN '8325401000'" ).append("\n"); 
		query.append("                   WHEN SIH.AP_INV_SRC_CD <> 'AR' AND MA.ACCT_CD IN ('954113', '954116', '954115', '954117', '954114') THEN '8705300000' --2017.01.03 Overseas Income Tax(P123)" ).append("\n"); 
		query.append("              ELSE NULL END -- 2015.01.19 수정  2014.10.23 수정 --- VTM의 G/L Account 처리" ).append("\n"); 
		query.append("                                                  AS GL_ACCOUNT_NO" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('TAX', 'WITHHOLDING TAX', 'FREIGHT') OR  MA.ACCT_CD = '211691' OR MA.ACCT_CD IN ('954116', '954115', '954117') THEN --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                        MO.MODI_AGN_CD   --2015.01.08 변경 --- Office SAP-ID  (Code Conversion)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD = 'PREPAY' THEN 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0')" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y'" ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N'" ).append("\n"); 
		query.append("                        AND NVL((SELECT SR.RCT_CUST_CNT_CD FROM SAR_RECEIPT SR WHERE SR.RCT_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                (SELECT SAH.BIL_TO_CUST_CNT_CD FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1)) = 'TB' " ).append("\n"); 
		query.append("                                 THEN NVL((SELECT 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') " ).append("\n"); 
		query.append("                                           FROM   SAR_RECEIPT SR, MDM_VENDOR MV, MDM_ORGANIZATION MO, MDM_LOCATION ML " ).append("\n"); 
		query.append("                                           WHERE  SR.RCT_NO = SIH.ATTR_CTNT4 AND MV.OFC_CD = MO.OFC_CD(+) AND MO.LOC_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("                                           AND    MV.RFND_PSDO_CUST_CD = SR.RCT_CUST_CNT_CD||TRIM(TO_CHAR(SR.RCT_CUST_SEQ, '000000')) AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                          (SELECT 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') " ).append("\n"); 
		query.append("                                           FROM   SAR_ADJ_HDR SAH, MDM_VENDOR MV, MDM_ORGANIZATION MO, MDM_LOCATION ML " ).append("\n"); 
		query.append("                                           WHERE  SAH.ADJ_NO = SIH.ATTR_CTNT4 AND MV.OFC_CD = MO.OFC_CD(+) AND MO.LOC_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("                                           AND    MV.RFND_PSDO_CUST_CD = SAH.BIL_TO_CUST_CNT_CD||TRIM(TO_CHAR(SAH.BIL_TO_CUST_SEQ, '000000')) AND ROWNUM = 1))" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y'" ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N'" ).append("\n"); 
		query.append("                        AND NVL((SELECT SR.RCT_CUST_CNT_CD FROM SAR_RECEIPT SR WHERE SR.RCT_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                (SELECT SAH.BIL_TO_CUST_CNT_CD FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1)) <> 'TB'         " ).append("\n"); 
		query.append("                                 THEN NVL((SELECT 'G1' || SR.RCT_CUST_CNT_CD || LPAD(TO_CHAR(SR.RCT_CUST_SEQ), 6, '0') " ).append("\n"); 
		query.append("                                           FROM   SAR_RECEIPT SR WHERE SR.RCT_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1),  " ).append("\n"); 
		query.append("                                          (SELECT 'G1' || SAH.BIL_TO_CUST_CNT_CD || LPAD(TO_CHAR(SAH.BIL_TO_CUST_SEQ), 6, '0') " ).append("\n"); 
		query.append("                                           FROM   SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1))" ).append("\n"); 
		query.append("                   ELSE NULL END                  AS CUSTOMER_NUMBER" ).append("\n"); 
		query.append("            , NULL                                AS VENDOR_ACCOUNT_NO" ).append("\n"); 
		query.append("            , CASE WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' " ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N'" ).append("\n"); 
		query.append("                                                    THEN NVL((SELECT SR.RCT_DPS_DT FROM SAR_RECEIPT SR WHERE SR.RCT_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1),  " ).append("\n"); 
		query.append("                                                              (SELECT SAH.ADJ_DT FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1))" ).append("\n"); 
		query.append("                   ELSE NULL END                  AS CALCULATE_DUE_DATE" ).append("\n"); 
		query.append("            , NULL                                AS PAYMENT_METHOD -- Payment Method (Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS STATE_CENTRAL_BANK" ).append("\n"); 
		query.append("            , NULL                                AS MATERIAL_NO" ).append("\n"); 
		query.append("            , NULL                                AS QUANTITY" ).append("\n"); 
		query.append("            , NULL                                AS BASE_UNIT" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD LIKE '814%' THEN 'ZSGA' --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD = '8705300000' THEN 'Z002' --Overseas Income Tax(P123)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD NOT LIKE '954%' AND MA.ACCT_CD <> '211691' THEN " ).append("\n"); 
		query.append("                        NVL((SELECT MT.MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = SID.ATTR_CTNT7 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                            NVL((SELECT DECODE(MVSL.VSL_SLAN_CD, 'COM', NULL, 'CNT', NULL, MVSL.MODI_COST_CTR_CD) FROM MDM_VSL_SVC_LANE MVSL WHERE MVSL.VSL_SLAN_CD = SID.ATTR_CTNT14), " ).append("\n"); 
		query.append("                                   NVL(DECODE((SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                               AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1), 'ZH', MO.MODI_COST_CTR_CD," ).append("\n"); 
		query.append("                                              (SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                               AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1)), --2015.02.11 수정 " ).append("\n"); 
		query.append("                                        'A106') ) ) --2015.02.09수정 --2015.01.28 수정 -- Profit Center(Code Conversion)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM = 'ARAPOFFSET' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' THEN 'A106' " ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'Y' THEN 'A106'" ).append("\n"); 
		query.append("                   WHEN SIH.AP_INV_SRC_CD = 'AR' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN " ).append("\n"); 
		query.append("                        NVL((SELECT DECODE(MVSL.VSL_SLAN_CD, 'COM', NULL, 'CNT', NULL, MVSL.MODI_COST_CTR_CD) FROM MDM_VSL_SVC_LANE MVSL WHERE MVSL.VSL_SLAN_CD = SID.ATTR_CTNT14), --2015.02.04 수정" ).append("\n"); 
		query.append("                           NVL(DECODE((SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                       AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1), 'ZH', MO.MODI_COST_CTR_CD," ).append("\n"); 
		query.append("                                      (SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                       AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1)), --2015.02.11 수정 " ).append("\n"); 
		query.append("                                'A106') )" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD LIKE '954%' AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') THEN 'A106' ELSE NULL END --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                                                  AS PROFIT_CENTER " ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('TAX', 'WITHHOLDING TAX', 'FREIGHT') OR  MA.ACCT_CD = '211691' OR MA.ACCT_CD IN ('954116', '954115', '954117') THEN '5360000000' --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' " ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N' THEN '5400269050'" ).append("\n"); 
		query.append("                   --WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN MA.MODI_ACCT_CD  -- 2014.10.23 변경 " ).append("\n"); 
		query.append("                   ELSE NULL END --- VTM의 G/L Account 처리" ).append("\n"); 
		query.append("                                                  AS ALTERNATIVE_ACCOUNT_NO " ).append("\n"); 
		query.append("            , CASE WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' " ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N' THEN 'A106'" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('TAX', 'WITHHOLDING TAX') OR  MA.ACCT_CD = '211691' OR MA.ACCT_CD IN ('954116', '954115', '954117') THEN 'A106' --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD = 'PREPAY' THEN NVL((SELECT MVSL.MODI_COST_CTR_CD FROM MDM_VSL_SVC_LANE MVSL WHERE MVSL.VSL_SLAN_CD = SID.ATTR_CTNT14), --2015.02.04 수정" ).append("\n"); 
		query.append("                                                                NVL(DECODE((SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                                                            AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1), 'ZH', MO.MODI_COST_CTR_CD," ).append("\n"); 
		query.append("                                                                           (SELECT  SSCC.TGT_CD FROM SCO_STMT_CD_CONV SSCC WHERE SSCC.CONV_TP_CD = 'GL ACCT OF PROFIT CENTER'" ).append("\n"); 
		query.append("                                                                            AND     SSCC.SRC_CD = MA.MODI_ACCT_CD AND SSCC.USE_FLG = 'Y' AND SSCC.DELT_FLG = 'N' AND ROWNUM = 1)), --2015.02.11 수정  " ).append("\n"); 
		query.append("                                                                      'A106') )" ).append("\n"); 
		query.append("                   ELSE NULL END                  AS BIZ_PARTNER_REF_KEY1 --2015.01.26 추가 -- Profit Center (Code Conversion)" ).append("\n"); 
		query.append("            , CASE WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' " ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N' THEN 'GT' ELSE NULL END AS BIZ_PARTNER_REF_KEY2 -- GT " ).append("\n"); 
		query.append("            , NULL                                AS LINE_ITEM_REF_KEY    -- Office SAP-ID (Code Conversion)" ).append("\n"); 
		query.append("            , NULL                                AS INSTRUCTION_KEY1" ).append("\n"); 
		query.append("            , NULL                                AS INSTRUCTION_KEY2" ).append("\n"); 
		query.append("            , NULL                                AS INSTRUCTION_KEY3" ).append("\n"); 
		query.append("            , CASE WHEN SIH.AP_INV_SRC_CD = 'AR' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'N' AND MA.ACCT_CD IN ('954116', '954115', '954117') THEN NULL --2017.01.03 Rev Local Add" ).append("\n"); 
		query.append("                   ELSE DECODE(SID.LINE_TP_LU_CD, 'TAX', '31', 'WITHHOLDING TAX', '35', DECODE(MA.ACCT_CD, '211691', '35', '954116', '35', '954115', '31', NULL)) END AS PAYMENT_REFERENCE --2015.10.20 WITHHOLDING or VAT  " ).append("\n"); 
		query.append("            , NULL                                AS AUTOMATIC_PAY_CURRENCY" ).append("\n"); 
		query.append("            , NULL                                AS PAYMENT_CURR_AMOUNT" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD <> '211691' AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') THEN 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') --- 2015.10.14 REV(Local) 계정 추가 --2015.03.30 수정" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('TAX', 'WITHHOLDING TAX') OR  MA.ACCT_CD = '211691' OR MA.ACCT_CD IN ('954116', '954115', '954117') THEN --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                        MO.MODI_AGN_CD   -- 2015.01.08 변경  --- Office SAP-ID  (Code Conversion)" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y'" ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N'" ).append("\n"); 
		query.append("                        AND NVL((SELECT SR.RCT_CUST_CNT_CD FROM SAR_RECEIPT SR WHERE SR.RCT_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                (SELECT SAH.BIL_TO_CUST_CNT_CD FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1)) = 'TB' " ).append("\n"); 
		query.append("                                 THEN NVL((SELECT 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') " ).append("\n"); 
		query.append("                                           FROM   SAR_RECEIPT SR, MDM_VENDOR MV, MDM_ORGANIZATION MO, MDM_LOCATION ML " ).append("\n"); 
		query.append("                                           WHERE  SR.RCT_NO = SIH.ATTR_CTNT4 AND MV.OFC_CD = MO.OFC_CD(+) AND MO.LOC_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("                                           AND    MV.RFND_PSDO_CUST_CD = SR.RCT_CUST_CNT_CD||TRIM(TO_CHAR(SR.RCT_CUST_SEQ, '000000')) AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                          (SELECT 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') " ).append("\n"); 
		query.append("                                           FROM   SAR_ADJ_HDR SAH, MDM_VENDOR MV, MDM_ORGANIZATION MO, MDM_LOCATION ML " ).append("\n"); 
		query.append("                                           WHERE  SAH.ADJ_NO = SIH.ATTR_CTNT4 AND MV.OFC_CD = MO.OFC_CD(+) AND MO.LOC_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("                                           AND    MV.RFND_PSDO_CUST_CD = SAH.BIL_TO_CUST_CNT_CD||TRIM(TO_CHAR(SAH.BIL_TO_CUST_SEQ, '000000')) AND ROWNUM = 1))" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y'" ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N'" ).append("\n"); 
		query.append("                        AND NVL((SELECT SR.RCT_CUST_CNT_CD FROM SAR_RECEIPT SR WHERE SR.RCT_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                (SELECT SAH.BIL_TO_CUST_CNT_CD FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1)) <> 'TB'         " ).append("\n"); 
		query.append("                                 THEN NVL((SELECT 'G1' || SR.RCT_CUST_CNT_CD || LPAD(TO_CHAR(SR.RCT_CUST_SEQ), 6, '0') " ).append("\n"); 
		query.append("                                           FROM   SAR_RECEIPT SR WHERE SR.RCT_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1),  " ).append("\n"); 
		query.append("                                          (SELECT 'G1' || SAH.BIL_TO_CUST_CNT_CD || LPAD(TO_CHAR(SAH.BIL_TO_CUST_SEQ), 6, '0') " ).append("\n"); 
		query.append("                                           FROM   SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND ROWNUM = 1))" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN " ).append("\n"); 
		query.append("                        'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0')" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'Y' THEN 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0')" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'ARAPOFFSET' THEN 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0') --2015.03.30 수정" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD = 'PREPAY' THEN 'G5'|| ML.CNT_CD || LPAD(TO_CHAR(MV.VNDR_SEQ),6, '0')" ).append("\n"); 
		query.append("              ELSE NULL END                       AS CONTRACT_NUMBER" ).append("\n"); 
		query.append("            , 'Z'                                 AS CONTRACT_TYPE  -- DECODE(SIH.ATTR_CATE_NM, 'ARAPOFFSET', NULL, 'Z')" ).append("\n"); 
		query.append("            , NULL                                AS PAYMENT_REASON" ).append("\n"); 
		query.append("            , NULL                                AS CLASSIFICATION" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD LIKE '814%' THEN '2550' --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD NOT LIKE '954%' AND MA.ACCT_CD <> '211691' THEN " ).append("\n"); 
		query.append("                        NVL((SELECT ML.MODI_LOC_CD FROM MDM_YARD MY, MDM_LOCATION ML WHERE MY.LOC_CD = ML.LOC_CD AND MY.YD_CD = SID.ATTR_CTNT12 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                            NVL((SELECT ML.MODI_LOC_CD FROM MDM_ORGANIZATION MO2, MDM_LOCATION ML WHERE MO2.LOC_CD = ML.LOC_CD AND MO2.OFC_CD = SID.ATTR_CTNT12 AND ROWNUM = 1), " ).append("\n"); 
		query.append("                                  (SELECT ML.MODI_LOC_CD FROM MDM_LOCATION ML WHERE ML.LOC_CD = SID.ATTR_CTNT12 AND ROWNUM = 1))) -- 2013.10.23 변경 --POL DTX code (Code Conversion)" ).append("\n"); 
		query.append("                   WHEN SIH.AP_INV_SRC_CD = 'AR' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN " ).append("\n"); 
		query.append("                        NVL((SELECT ML.MODI_LOC_CD FROM MDM_YARD MY, MDM_LOCATION ML WHERE MY.LOC_CD = ML.LOC_CD AND MY.YD_CD = SID.ATTR_CTNT12 AND ROWNUM = 1)," ).append("\n"); 
		query.append("                            NVL((SELECT ML.MODI_LOC_CD FROM MDM_ORGANIZATION MO2, MDM_LOCATION ML WHERE MO2.LOC_CD = ML.LOC_CD AND MO2.OFC_CD = SID.ATTR_CTNT12 AND ROWNUM = 1), " ).append("\n"); 
		query.append("                                  (SELECT ML.MODI_LOC_CD FROM MDM_LOCATION ML WHERE ML.LOC_CD = SID.ATTR_CTNT12 AND ROWNUM = 1)))" ).append("\n"); 
		query.append("              ELSE NULL END                       AS ACTIVITY_PLACE" ).append("\n"); 
		query.append("            , NULL                                AS ENTERTAINMENT_EXP_ID" ).append("\n"); 
		query.append("            , NULL                                AS BUDGET_MANAGE_DIVISION" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD NOT LIKE '954%' AND MA.ACCT_CD <> '211691' THEN --2015.02.05 수정" ).append("\n"); 
		query.append("                        SUBSTR(REPLACE(REPLACE(SID.ATTR_CTNT11, '/', ''), '-', ''), 1, 8) " ).append("\n"); 
		query.append("                   WHEN SIH.AP_INV_SRC_CD = 'AR' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 OR SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN " ).append("\n"); 
		query.append("                        SUBSTR(REPLACE(REPLACE(SID.ATTR_CTNT11, '/', ''), '-', ''), 1, 8) ELSE NULL END -- 2014.10.29 --2014.10.23 변경" ).append("\n"); 
		query.append("                                                  AS ACTIVITY_DATE" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD LIKE '814%' THEN NULL --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD = '8705300000' THEN NULL --Overseas Income Tax(P123)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD NOT LIKE '954%' AND MA.ACCT_CD <> '211691' AND SUBSTR(SLCC.SGM_CTNT6, 1, 4) NOT IN ('CFDR', '0000', 'CNTC', 'COMC') THEN " ).append("\n"); 
		query.append("                        (SELECT MVC.MODI_VSL_CD FROM MDM_VSL_CNTR MVC WHERE MVC.VSL_CD = SUBSTR(SLCC.SGM_CTNT6, 1, 4) AND ROWNUM = 1) --2014.10.23 변경 --Trunk Vessel DTX code (Code Conversion)" ).append("\n"); 
		query.append("              ELSE NULL END                       AS VESSEL" ).append("\n"); 
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD LIKE '814%' THEN NULL --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD = '8705300000' THEN NULL --Overseas Income Tax(P123)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD NOT LIKE '954%' AND MA.ACCT_CD <> '211691' AND SUBSTR(SLCC.SGM_CTNT6, 1, 4) NOT IN ('CFDR', '0000', 'CNTC', 'COMC') THEN " ).append("\n"); 
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
		query.append("            , CASE WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD LIKE '814%' THEN 'OTHER TAX/DUES' --OTHER TAX/DUES(P120)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.MODI_ACCT_CD = '8705300000' THEN 'Overseas Income Tax' --Overseas Income Tax(P123)" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD NOT LIKE '954%' AND MA.ACCT_CD <> '211691' THEN 'ITEM(PL)'" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD LIKE '954%' AND MA.ACCT_CD IN ('954116', '954115', '954117') THEN 'ITEM(CLR)_REV(LCL)' --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN SID.LINE_TP_LU_CD IN ('ITEM', 'MISCELLANEOUS', 'FREIGHT') AND SIH.ATTR_CATE_NM NOT IN ('REFUND', 'ARAPOFFSET') AND MA.ACCT_CD LIKE '954%' AND MA.ACCT_CD NOT IN ('954116', '954115', '954117') THEN 'ITEM(CLEAR)' --- 2015.10.14 REV(Local) 계정 추가" ).append("\n"); 
		query.append("                   WHEN MA.ACCT_CD = '211691' THEN 'WITHHOLDING TAX(ITEM)'" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' " ).append("\n"); 
		query.append("                        AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'N' THEN 'ITEM(REFUND)'" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ADJ_HDR SAH WHERE SAH.ADJ_NO = SIH.ATTR_CTNT4 AND SAH.ADJ_TP_CD = 'EX' AND ROWNUM = 1), 'N') = 'Y' THEN 'ITEM(ADJUST_EX)'" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'N' AND  MA.ACCT_CD IN ('954116', '954115', '954117')  THEN 'REV(CLEAR)' --2017.01.03 Rev Local Add" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 ) AND ROWNUM = 1),'N') = 'Y' THEN 'ITEM(REFUND/GAIN)'" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'REFUND' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN 'ITEM(REFUND/LOSS)'" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'ARAPOFFSET' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND SAM.AR_ACCT_CD = SLCC.SGM_CTNT4 AND ROWNUM = 1),'N') = 'Y' THEN 'OFFSET' " ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'ARAPOFFSET' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_INCM_ACCT_CD = SLCC.SGM_CTNT4 ) AND ROWNUM = 1),'N') = 'Y' THEN 'OFFSET/GAIN'" ).append("\n"); 
		query.append("                   WHEN SIH.ATTR_CATE_NM = 'ARAPOFFSET' AND NVL((SELECT  'Y' FROM SAR_ACCT_MTX SAM WHERE SAM.PAY_ACCT_CD IS NOT NULL AND (SAM.LEGR_XCH_DIFF_LSS_ACCT_CD = SLCC.SGM_CTNT4) AND ROWNUM = 1),'N') = 'Y' THEN 'OFFSET/LOSS' " ).append("\n"); 
		query.append("              ELSE SID.LINE_TP_LU_CD END AS IF_ITEM_CATEGROY" ).append("\n"); 
		query.append("      FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("            , SAP_INV_DTL SID" ).append("\n"); 
		query.append("            , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("            , COM_USER CU  -- 2014.10.17 -- User 정보 추가" ).append("\n"); 
		query.append("            , MDM_ACCOUNT MA -- 2014.10.23 추가" ).append("\n"); 
		query.append("            , MDM_ORGANIZATION MO -- 2014.10.23 추가" ).append("\n"); 
		query.append("            , MDM_VENDOR MV --2015.01.21 추가" ).append("\n"); 
		query.append("            , MDM_ORGANIZATION MO2 --2015.03.30 추가" ).append("\n"); 
		query.append("            , MDM_LOCATION ML --2015.03.30 추가" ).append("\n"); 
		query.append("      WHERE   SIH.INV_SEQ = SID.INV_SEQ " ).append("\n"); 
		query.append("      AND     SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("      AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ --2015.01.21 추가" ).append("\n"); 
		query.append("      AND     SIH.CRE_USR_ID = CU.USR_ID  -- 2014.10.17 -- User 정보 추가" ).append("\n"); 
		query.append("      AND     SLCC.SGM_CTNT4 = MA.ACCT_CD -- 2014.10.23 추가 " ).append("\n"); 
		query.append("      AND     SIH.OFC_CD = MO.OFC_CD -- 2014.10.23 추가 " ).append("\n"); 
		query.append("      AND     MV.OFC_CD = MO2.OFC_CD -- 2015.03.30 추가" ).append("\n"); 
		query.append("      AND     MO2.LOC_CD = ML.LOC_CD -- 2015.03.30 추가" ).append("\n"); 
		query.append("      AND     SIH.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("      AND     SID.DTRB_AMT <> 0 --2015.02.03 추가" ).append("\n"); 
		query.append("      AND     SLCC.SGM_CTNT4 NOT IN (SELECT  SLD.LU_CD FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD   -- 2014/10/06 해외부가세 제외 처리" ).append("\n"); 
		query.append("                                     WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'AP TAX ACCOUNT' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                                     AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND SLH.LU_APPL_CD = 'SAP'AND SLD.ATTR_CTNT1 IN ('EXTERNAL', 'INTERNAL'))" ).append("\n"); 

	}
}