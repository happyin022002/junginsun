/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchUpstreamInvoiceAccountedRoundCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchUpstreamInvoiceAccountedRoundCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Upstream module interfaced standard slip에 대한 Partially apply시 Accounted 금액에 대한 Round 금액 발생 여부 파악
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchUpstreamInvoiceAccountedRoundCheckRSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchUpstreamInvoiceAccountedRoundCheckRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN ((SELECT COUNT(SID2.INV_DTRB_SEQ) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SIH.INV_SEQ AND SID2.LINE_TP_LU_CD = 'PREPAY'" ).append("\n"); 
		query.append("                   AND    NVL(SID2.RVS_FLG, 'N') = 'N') > 0) " ).append("\n"); 
		query.append("                  AND (SELECT COUNT(DISTINCT LINE_RATE) FROM (SELECT NVL(SID1.DTRB_XCH_RT,1) AS LINE_RATE FROM SAP_INV_DTL SID1, SAP_INV_HDR SIH1 WHERE SIH1.INV_SEQ = SID1.INV_SEQ" ).append("\n"); 
		query.append("                                                              AND    SIH1.INV_NO = @[csr_no] AND SID1.LINE_TP_LU_CD <> 'PREPAY' AND NVL(SID1.RVS_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("                                                              AND    TO_NUMBER(NVL(SID1.GLO_ATTR_CTNT1, 0)) <> 0" ).append("\n"); 
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
		query.append("                                                                                          AND     SID2.PPAY_LINE_NO = SID4.PPAY_LINE_NO AND SID4.INV_DTRB_SEQ < SID2.INV_DTRB_SEQ) ) ) = 1 THEN " ).append("\n"); 
		query.append("                  (SELECT  SUM(NVL(ROUND(NVL(SID.GLO_ATTR_CTNT1, 0) * NVL(SID.DTRB_XCH_RT, SIH.INV_XCH_RT), " ).append("\n"); 
		query.append("                                  (SELECT  DP_PRCS_KNT FROM MDM_CURRENCY MC WHERE MC.CURR_CD = 'JPY' AND DELT_FLG = 'N' AND ROWNUM=1)), NVL(SID.GLO_ATTR_CTNT1, 0))) FROM SAP_INV_DTL SID " ).append("\n"); 
		query.append("                   WHERE   SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD <> 'PREPAY' AND NVL(SID.RVS_FLG, 'N') = 'N' AND TO_NUMBER(NVL(SID.GLO_ATTR_CTNT1, 0)) <> 0) + " ).append("\n"); 
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
		query.append("                                   * SIH.INV_XCH_RT, (SELECT  DP_PRCS_KNT FROM MDM_CURRENCY MC " ).append("\n"); 
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
		query.append("                   FROM    SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD = 'PREPAY' AND NVL(SID.RVS_FLG, 'N') = 'N') ELSE 0 END PREPAY_ROUND_AMT" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE   SIH.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND     SIH.INV_NO = @[csr_no]" ).append("\n"); 

	}
}