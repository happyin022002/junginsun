/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceSAPTypeCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.05 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceSAPTypeCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR No을 기준으로 SAP으로 I/F 할 Type을 파악한다.
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceSAPTypeCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceSAPTypeCheckRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN SIH.INV_TP_LU_CD = 'STANDARD' AND MO.FINC_RGN_CD = '11' THEN 'STANDARD JP'" ).append("\n"); 
		query.append("             WHEN SIH.INV_TP_LU_CD = 'STANDARD' AND MO.FINC_RGN_CD <> '11' THEN 'STANDARD NON JP'" ).append("\n"); 
		query.append("             WHEN SIH.INV_TP_LU_CD = 'CREDIT' AND MO.FINC_RGN_CD = '11' THEN 'CREDIT JP'" ).append("\n"); 
		query.append("             WHEN SIH.INV_TP_LU_CD = 'CREDIT' AND MO.FINC_RGN_CD <> '11' THEN 'CREDIT NON JP'" ).append("\n"); 
		query.append("             WHEN SIH.INV_TP_LU_CD = 'PREPAYMENT' AND MO.FINC_RGN_CD = '11' THEN 'PREPAYMENT JP'" ).append("\n"); 
		query.append("             WHEN SIH.INV_TP_LU_CD = 'PREPAYMENT' AND MO.FINC_RGN_CD <> '11' THEN 'PREPAYMENT NON JP'" ).append("\n"); 
		query.append("        END  AS SLIP_TYPE" ).append("\n"); 
		query.append("      , CASE WHEN SIH.INV_TP_LU_CD IN ('STANDARD', 'CREDIT') AND SIH.ATTR_CATE_NM = 'INVOICES' AND SIH.ATTR_CTNT2 IS NOT NULL AND SIH.INV_AMT = 0" ).append("\n"); 
		query.append("              AND (SELECT COUNT(SID.INV_SEQ) FROM SAP_INV_DTL SID, SCO_LEGR_CD_CMB SLCC WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("                   AND    SLCC.SGM_CTNT4 = (SELECT  SLD.LU_CD FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("                                            WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'ASA CLEARING ACCOUNT' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                                            AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND SLH.LU_APPL_CD = 'SAP'AND ROWNUM = 1)) > 0 THEN 'Y'" ).append("\n"); 
		query.append("        ELSE 'N' END AS ASA_FLAG" ).append("\n"); 
		query.append("      , SIH.ATTR_CATE_NM AS CATEGORY_NAME -- REFUND,  ARAPOFFSET, INVOICES" ).append("\n"); 
		query.append("      , CASE WHEN (SELECT COUNT(SPS.INV_SEQ) FROM SAP_PAY_SKD SPS WHERE SPS.INV_SEQ = SIH.INV_SEQ AND SPS.INV_HLD_FLG = 'Y') > 0 THEN 'Y'" ).append("\n"); 
		query.append("        ELSE 'N' END AS HOLD_FLAG" ).append("\n"); 
		query.append("      , SIH.INV_NO   AS CSR_NO" ).append("\n"); 
		query.append("      , SIH.INV_TP_LU_CD AS INVOICE_TYPE" ).append("\n"); 
		query.append("      , SIH.INV_SEQ      AS INV_SEQ" ).append("\n"); 
		query.append("      , NVL(SIH.ATTR_CTNT15, 'N')  AS APPROVAL_FLAG" ).append("\n"); 
		query.append("      , (SELECT COUNT(SID2.INV_DTRB_SEQ) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.LINE_TP_LU_CD = 'TAX') AS TAX_COUNT" ).append("\n"); 
		query.append("      , (SELECT COUNT(SID2.INV_DTRB_SEQ) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.LINE_TP_LU_CD = 'ITEM'  -- 2014/10/06 ITEM인 경우에만 추가" ).append("\n"); 
		query.append("         AND    SID2.DTRB_VAT_CD IN (SELECT  SLD.LU_CD FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("                                     WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'AP TAX CODE' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                                     AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND SLH.LU_APPL_CD = 'SAP'AND SLD.ATTR_CTNT2 = 'Y')) AS ITEM_TAX_COUNT      " ).append("\n"); 
		query.append("      , (SELECT COUNT(SID2.INV_DTRB_SEQ) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.LINE_TP_LU_CD = 'WITHHOLDING TAX') AS WTAX_COUNT" ).append("\n"); 
		query.append("      , (SELECT COUNT(SID2.INV_DTRB_SEQ) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY'" ).append("\n"); 
		query.append("         AND    NVL(SID2.RVS_FLG, 'N') = 'N') AS PREPAY_COUNT --- 2014/10/02 UNAPPLY된 내역 제외" ).append("\n"); 
		query.append("      , DECODE(SIH.INV_CXL_DT, NULL, 'N', 'Y') AS CANCEL_FLAG" ).append("\n"); 
		query.append("      , NVL((SELECT  'Y' " ).append("\n"); 
		query.append("             FROM    SCO_LEGR_CD_CMB SLCC, SCO_LU_HDR SLH, SCO_LU_DTL SLD " ).append("\n"); 
		query.append("             WHERE   SLCC.CD_CMB_SEQ = SIH.LIAB_CD_CMB_SEQ" ).append("\n"); 
		query.append("             AND     SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'AP ACCRUAL ACCOUNT' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("             AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("             AND     SLCC.SGM_CTNT4 = SLD.LU_CD), 'N') AS ACCRUAL_FLAG" ).append("\n"); 
		query.append("      , CASE WHEN (SELECT COUNT(SID2.INV_DTRB_SEQ) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY'" ).append("\n"); 
		query.append("                   AND    NVL(SID2.RVS_FLG, 'N') = 'N') = 0 THEN 'N'" ).append("\n"); 
		query.append("             WHEN ((SELECT  SID3.DTRB_AMT FROM SAP_INV_DTL SID2, SAP_INV_DTL SID3" ).append("\n"); 
		query.append("                   WHERE   SID2.INV_SEQ = SIH.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY' AND NVL(SID2.RVS_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                   AND     SID2.PPAY_INV_SEQ = SID3.INV_SEQ AND SID2.PPAY_LINE_NO = SID3.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                  (SELECT  ABS(SUM(SID3.DTRB_AMT)) FROM SAP_INV_DTL SID2, SAP_INV_DTL SID3" ).append("\n"); 
		query.append("                   WHERE   SID2.INV_SEQ = SIH.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY' AND NVL(SID2.RVS_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                   AND     SID2.PPAY_INV_SEQ = SID3.PPAY_INV_SEQ AND SID2.PPAY_LINE_NO = SID3.PPAY_LINE_NO AND SID3.INV_DTRB_SEQ <= SID2.INV_DTRB_SEQ)) > 0 THEN 'Y'" ).append("\n"); 
		query.append("        ELSE 'N' END AS PPAY_REMAINING_FLAG  -- 2014/10/06 선급금 정산외 추가 정산금액 존재 여부 파악..." ).append("\n"); 
		query.append("		,'' USR_ID" ).append("\n"); 
		query.append("		,'' SLIP_INTERFACE_SEQ" ).append("\n"); 
		query.append("		, ( SELECT  SLD.lU_CD		 " ).append("\n"); 
		query.append("		    FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("		          , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("		    WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("		    AND     SLH.LU_TP_CD = 'FUNCTIONAL CURRENCY'" ).append("\n"); 
		query.append("		    AND     SLH.LU_APPL_CD = 'SCO'" ).append("\n"); 
		query.append("		    AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("		    AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE " ).append("\n"); 
		query.append("		    AND     ROWNUM = 1 ) AS FUNCTIONAL_CURRENCY" ).append("\n"); 
		query.append("      , CASE WHEN ((SELECT COUNT(SID2.INV_DTRB_SEQ) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY'" ).append("\n"); 
		query.append("                   AND    NVL(SID2.RVS_FLG, 'N') = 'N') > 0) " ).append("\n"); 
		query.append("                  AND (SELECT COUNT(DISTINCT LINE_RATE) FROM (SELECT NVL(SID1.DTRB_XCH_RT,1) AS LINE_RATE FROM SAP_INV_DTL SID1, SAP_INV_HDR SIH1 WHERE SIH1.INV_SEQ = SID1.INV_SEQ" ).append("\n"); 
		query.append("                                                              AND    SIH1.INV_NO = @[csr_no] AND SID1.LINE_TP_LU_CD <> 'PREPAY'" ).append("\n"); 
		query.append("                                                              UNION ALL" ).append("\n"); 
		query.append("                                                              SELECT NVL(SIH1.INV_XCH_RT, 1) AS LINE_RATE FROM SAP_INV_DTL SID2, SAP_INV_HDR SIH1, SAP_INV_HDR SIH2 " ).append("\n"); 
		query.append("                                                              WHERE  SID2.INV_SEQ = SIH2.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY' AND NVL(SID2.RVS_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("                                                              AND    SID2.PPAY_INV_SEQ = SIH1.INV_SEQ" ).append("\n"); 
		query.append("                                                              AND    SIH2.INV_NO = @[csr_no]" ).append("\n"); 
		query.append("                                                              AND    (SELECT  COUNT(SID3.INV_DTRB_SEQ) FROM SAP_INV_DTL SID3 " ).append("\n"); 
		query.append("                                                                      WHERE   SID2.PPAY_INV_SEQ = SID3.PPAY_INV_SEQ AND SID2.PPAY_LINE_NO = SID3.PPAY_LINE_NO AND SID2.INV_DTRB_SEQ > SID3.INV_DTRB_SEQ) = 0  " ).append("\n"); 
		query.append("                                                              UNION ALL" ).append("\n"); 
		query.append("                                                              SELECT NVL(SIH1.INV_XCH_RT, 1) AS LINE_RATE FROM SAP_INV_DTL SID2, SAP_INV_HDR SIH1, SAP_INV_HDR SIH2, SAP_INV_DTL SID5" ).append("\n"); 
		query.append("                                                              WHERE  SID2.INV_SEQ = SIH2.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY' AND NVL(SID2.RVS_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("                                                              AND    SID5.INV_SEQ = SIH1.INV_SEQ" ).append("\n"); 
		query.append("                                                              AND    SIH2.INV_NO = @[csr_no]" ).append("\n"); 
		query.append("                                                              AND    (SELECT  COUNT(SID3.INV_DTRB_SEQ) FROM SAP_INV_DTL SID3 " ).append("\n"); 
		query.append("                                                                      WHERE   SID2.PPAY_INV_SEQ = SID3.PPAY_INV_SEQ AND SID2.PPAY_LINE_NO = SID3.PPAY_LINE_NO AND SID2.INV_DTRB_SEQ > SID3.INV_DTRB_SEQ) > 0" ).append("\n"); 
		query.append("                                                              AND    SID5.INV_DTRB_SEQ = (SELECT  MAX(SID4.INV_DTRB_SEQ) FROM SAP_INV_DTL SID4 WHERE SID2.PPAY_INV_SEQ = SID4.PPAY_INV_SEQ" ).append("\n"); 
		query.append("                                                                                          AND     SID2.PPAY_LINE_NO = SID4.PPAY_LINE_NO AND SID4.INV_DTRB_SEQ < SID2.INV_DTRB_SEQ) ) ) > 1 " ).append("\n"); 
		query.append("                  AND (SELECT SUM(SID5.DTRB_AMT) FROM SAP_INV_DTL SID5 WHERE SIH.INV_SEQ = SID5.INV_SEQ AND NVL(SID5.RVS_FLG, 'N') = 'N') <= 0 THEN 'Y' ELSE 'N' END AS PPAY_EX_DIFF_FLAG" ).append("\n"); 
		query.append("      , CASE WHEN ((SELECT COUNT(SID2.INV_DTRB_SEQ) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY'" ).append("\n"); 
		query.append("                   AND    NVL(SID2.RVS_FLG, 'N') = 'N') > 0) " ).append("\n"); 
		query.append("                  AND (SELECT COUNT(DISTINCT LINE_RATE) FROM (SELECT NVL(SID1.DTRB_XCH_RT,1) AS LINE_RATE FROM SAP_INV_DTL SID1, SAP_INV_HDR SIH1 WHERE SIH1.INV_SEQ = SID1.INV_SEQ" ).append("\n"); 
		query.append("                                                              AND    SIH1.INV_NO = @[csr_no] AND SID1.LINE_TP_LU_CD <> 'PREPAY'" ).append("\n"); 
		query.append("                                                              UNION ALL" ).append("\n"); 
		query.append("                                                              SELECT NVL(SIH1.INV_XCH_RT, 1) AS LINE_RATE FROM SAP_INV_DTL SID2, SAP_INV_HDR SIH1, SAP_INV_HDR SIH2 " ).append("\n"); 
		query.append("                                                              WHERE  SID2.INV_SEQ = SIH2.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY' AND NVL(SID2.RVS_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("                                                              AND    SID2.PPAY_INV_SEQ = SIH1.INV_SEQ" ).append("\n"); 
		query.append("                                                              AND    SIH2.INV_NO = @[csr_no]" ).append("\n"); 
		query.append("                                                              AND    (SELECT  COUNT(SID3.INV_DTRB_SEQ) FROM SAP_INV_DTL SID3 " ).append("\n"); 
		query.append("                                                                      WHERE   SID2.PPAY_INV_SEQ = SID3.PPAY_INV_SEQ AND SID2.PPAY_LINE_NO = SID3.PPAY_LINE_NO AND SID2.INV_DTRB_SEQ > SID3.INV_DTRB_SEQ) = 0  " ).append("\n"); 
		query.append("                                                              UNION ALL" ).append("\n"); 
		query.append("                                                              SELECT NVL(SIH1.INV_XCH_RT, 1) AS LINE_RATE FROM SAP_INV_DTL SID2, SAP_INV_HDR SIH1, SAP_INV_HDR SIH2, SAP_INV_DTL SID5" ).append("\n"); 
		query.append("                                                              WHERE  SID2.INV_SEQ = SIH2.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY' AND NVL(SID2.RVS_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("                                                              AND    SID5.INV_SEQ = SIH1.INV_SEQ" ).append("\n"); 
		query.append("                                                              AND    SIH2.INV_NO = @[csr_no]" ).append("\n"); 
		query.append("                                                              AND    (SELECT  COUNT(SID3.INV_DTRB_SEQ) FROM SAP_INV_DTL SID3 " ).append("\n"); 
		query.append("                                                                      WHERE   SID2.PPAY_INV_SEQ = SID3.PPAY_INV_SEQ AND SID2.PPAY_LINE_NO = SID3.PPAY_LINE_NO AND SID2.INV_DTRB_SEQ > SID3.INV_DTRB_SEQ) > 0" ).append("\n"); 
		query.append("                                                              AND    SID5.INV_DTRB_SEQ = (SELECT  MAX(SID4.INV_DTRB_SEQ) FROM SAP_INV_DTL SID4 WHERE SID2.PPAY_INV_SEQ = SID4.PPAY_INV_SEQ" ).append("\n"); 
		query.append("                                                                                          AND     SID2.PPAY_LINE_NO = SID4.PPAY_LINE_NO AND SID4.INV_DTRB_SEQ < SID2.INV_DTRB_SEQ) ) ) > 1 THEN " ).append("\n"); 
		query.append("                  (SELECT  SUM(SID.DTRB_FUNC_AMT) FROM SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD <> 'PREPAY' AND NVL(SID.RVS_FLG, 'N') = 'N') + " ).append("\n"); 
		query.append("                  (SELECT  SUM(ROUND((((SELECT  SID2.DTRB_AMT FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                                        WHERE   SID.PPAY_INV_SEQ = SID2.INV_SEQ AND SID.PPAY_LINE_NO = SID2.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                                   NVL((SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                                        WHERE   SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ AND SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ >= SID2.INV_DTRB_SEQ), 0)) +" ).append("\n"); 
		query.append("                                     (((SELECT  SID2.DTRB_AMT FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                                        WHERE   SID.PPAY_INV_SEQ = SID2.INV_SEQ AND SID.PPAY_LINE_NO = SID2.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                                   NVL((SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                                        WHERE   SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ AND SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ > SID2.INV_DTRB_SEQ), 0)) -" ).append("\n"); 
		query.append("                                      ((SELECT  SID2.DTRB_AMT FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                                        WHERE   SID.PPAY_INV_SEQ = SID2.INV_SEQ AND SID.PPAY_LINE_NO = SID2.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                                   NVL((SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                                        WHERE   SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ AND SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ >= SID2.INV_DTRB_SEQ), 0)))" ).append("\n"); 
		query.append("                                                - ABS(SID.DTRB_AMT)) " ).append("\n"); 
		query.append("                                   * NVL(SIH.INV_XCH_RT,1), (SELECT  DP_PRCS_KNT FROM MDM_CURRENCY MC " ).append("\n"); 
		query.append("                                                      WHERE   MC.CURR_CD = (SELECT  SLD.lU_CD FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("                                                                            WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'FUNCTIONAL CURRENCY'" ).append("\n"); 
		query.append("                                                                            AND     SLH.LU_APPL_CD = 'SCO' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y' AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE " ).append("\n"); 
		query.append("                                                                            AND     ROWNUM = 1) AND DELT_FLG = 'N' AND ROWNUM=1))) " ).append("\n"); 
		query.append("                   FROM    SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD = 'PREPAY' AND NVL(SID.RVS_FLG, 'N') = 'N') -" ).append("\n"); 
		query.append("                  (SELECT  SUM(ROUND(((SELECT  SID2.DTRB_AMT FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                                       WHERE   SID.PPAY_INV_SEQ = SID2.INV_SEQ AND SID.PPAY_LINE_NO = SID2.DTRB_LINE_NO AND ROWNUM = 1) -" ).append("\n"); 
		query.append("                                  NVL((SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                                       WHERE   SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ AND SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ > SID2.INV_DTRB_SEQ), 0))" ).append("\n"); 
		query.append("                                    * (DECODE(NVL((SELECT  ABS(SUM(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2" ).append("\n"); 
		query.append("                                                   WHERE   SID.PPAY_INV_SEQ = SID2.PPAY_INV_SEQ AND SID.PPAY_LINE_NO = SID2.PPAY_LINE_NO AND SID.INV_DTRB_SEQ > SID2.INV_DTRB_SEQ), 0), 0," ).append("\n"); 
		query.append("                                                  (SELECT NVL(SIH2.INV_XCH_RT,1) FROM SAP_INV_HDR SIH2 WHERE SIH2.INV_SEQ = SID.PPAY_INV_SEQ AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                                  (SELECT  NVL(SIH2.INV_XCH_RT, 1) FROM SAP_INV_HDR SIH2, SAP_INV_DTL SID2 WHERE SIH2.INV_SEQ = SID2.INV_SEQ " ).append("\n"); 
		query.append("                                                   AND     SID2.INV_DTRB_SEQ = (SELECT  MAX(SID3.INV_DTRB_SEQ) FROM SAP_INV_DTL SID3 WHERE SID.PPAY_INV_SEQ = SID3.PPAY_INV_SEQ" ).append("\n"); 
		query.append("                                                   AND     SID.PPAY_LINE_NO = SID3.PPAY_LINE_NO AND SID.INV_DTRB_SEQ > SID3.INV_DTRB_SEQ)))), " ).append("\n"); 
		query.append("                                      (SELECT  DP_PRCS_KNT FROM MDM_CURRENCY MC " ).append("\n"); 
		query.append("                                       WHERE   MC.CURR_CD = (SELECT  SLD.lU_CD FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("                                                             WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'FUNCTIONAL CURRENCY'" ).append("\n"); 
		query.append("                                                             AND     SLH.LU_APPL_CD = 'SCO' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y' AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE " ).append("\n"); 
		query.append("                                                             AND     ROWNUM = 1) AND DELT_FLG = 'N' AND ROWNUM=1)))" ).append("\n"); 
		query.append("                   FROM    SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD = 'PREPAY' AND NVL(SID.RVS_FLG, 'N') = 'N') ELSE 0 END PREPAY_ROUND" ).append("\n"); 
		query.append("      , CASE WHEN (SELECT COUNT(SID2.INV_DTRB_SEQ) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY'" ).append("\n"); 
		query.append("                   AND    NVL(SID2.RVS_FLG, 'N') = 'N') > 0 AND SIH.AP_INV_SRC_CD NOT IN ('AR', 'Manual Invoice Entry', 'FMS') THEN 'Y' ELSE 'N' END AS UPSTREAM_APPLY" ).append("\n"); 
		query.append("      , CASE WHEN (SELECT SUM(SID2.DTRB_AMT) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND NVL(SID2.RVS_FLG, 'N') = 'N') = 0 THEN 'Y' ELSE 'N' END AS FULL_APPLY_FLAG" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE   SIH.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND     SIH.INV_NO = @[csr_no]" ).append("\n"); 

	}
}