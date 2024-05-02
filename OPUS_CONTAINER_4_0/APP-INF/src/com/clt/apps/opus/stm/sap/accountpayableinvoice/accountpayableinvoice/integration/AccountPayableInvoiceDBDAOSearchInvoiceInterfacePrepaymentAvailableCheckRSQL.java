/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfacePrepaymentAvailableCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.12 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfacePrepaymentAvailableCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfacePrepaymentAvailableCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfacePrepaymentAvailableCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_inv_line_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_aply_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfacePrepaymentAvailableCheckRSQL").append("\n"); 
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
		query.append("SELECT  PREPAY_INV_NO  AS PREPAY_INVOICE_NUMBER" ).append("\n"); 
		query.append("   FROM    (SELECT  SIH.INV_SEQ              AS INV_SEQ" ).append("\n"); 
		query.append("                  , SID.DTRB_LINE_NO         AS PREPAY_LINE_NUM" ).append("\n"); 
		query.append("                  , (SELECT  SUM(NVL(SID2.PPAY_RMN_AMT, SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SID.INV_SEQ AND SID2.DTRB_LINE_NO = SID.DTRB_LINE_NO" ).append("\n"); 
		query.append("                     AND     SID2.LINE_TP_LU_CD IN ('ITEM', 'ACCRUAL', 'REC_TAX', 'NONREC_TAX' ) AND NVL(SID2.RVS_FLG, 'N') <> 'Y') AS PREPAY_AMOUNT_REMAINING" ).append("\n"); 
		query.append("                  , SID.DTRB_AMT             AS LINE_AMOUNT" ).append("\n"); 
		query.append("                  , SID.ACCTG_DT             AS ACCOUNTING_DATE" ).append("\n"); 
		query.append("                  , SID.EFF_YRMON            AS PERIOD_NAME" ).append("\n"); 
		query.append("                  , SID.DTRB_DESC            AS LINE_DESC" ).append("\n"); 
		query.append("                  , SIH.INV_NO               AS PREPAY_INV_NO" ).append("\n"); 
		query.append("                  , SIH.INV_DT               AS INV_DT" ).append("\n"); 
		query.append("                  , SIH.INV_CURR_CD          AS INV_CURR_CD" ).append("\n"); 
		query.append("                  , SIH.INV_PAY_CURR_CD      AS INV_PAY_CURR_CD" ).append("\n"); 
		query.append("                  , SIH.VNDR_NO              AS VENDOR_NO" ).append("\n"); 
		query.append("                  , MV.VNDR_LGL_ENG_NM       AS VENDOR_NAME" ).append("\n"); 
		query.append("                  , SIH.ERY_STL_DT           AS ERY_STL_DT" ).append("\n"); 
		query.append("            FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("                  , SAP_INV_DTL SID" ).append("\n"); 
		query.append("                  , MDM_VENDOR MV" ).append("\n"); 
		query.append("            WHERE   SIH.INV_SEQ = SID.INV_SEQ" ).append("\n"); 
		query.append("            AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ " ).append("\n"); 
		query.append("            AND     SIH.INV_TP_LU_CD = 'PREPAYMENT'" ).append("\n"); 
		query.append("            AND     SID.LINE_TP_LU_CD = 'ITEM'" ).append("\n"); 
		query.append("            AND     SIH.PAY_STS_FLG = 'Y'" ).append("\n"); 
		query.append("            AND     SIH.ERY_STL_DT <= SYSDATE" ).append("\n"); 
		query.append("            AND     (SELECT  SUM(NVL(SID2.PPAY_RMN_AMT, SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2 WHERE SID2.INV_SEQ = SID.INV_SEQ AND SID2.DTRB_LINE_NO = SID.DTRB_LINE_NO" ).append("\n"); 
		query.append("                     AND     SID2.LINE_TP_LU_CD IN ('ITEM', 'ACCRUAL', 'REC_TAX', 'NONREC_TAX' ) AND NVL(SID2.RVS_FLG, 'N') <> 'Y') > 0" ).append("\n"); 
		query.append("            AND     NVL(SID.RVS_FLG, 'N') <> 'Y')" ).append("\n"); 
		query.append("   WHERE   PREPAY_INV_NO =  @[ppay_inv_no]" ).append("\n"); 
		query.append("   AND     PREPAY_LINE_NUM = @[ppay_inv_line_no]" ).append("\n"); 
		query.append("   AND     PREPAY_AMOUNT_REMAINING >= @[ppay_aply_amt]" ).append("\n"); 

	}
}