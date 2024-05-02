/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountingInvoiceSectionCheckCsrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchAccountingInvoiceSectionCheckCsrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Accounting 처리시 CSR No별로 하는 경우 해당 Invoice의 구분 값으로 Invoice만 처리 할지 Apply까지 모두 처리 할지 여부를 판단
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountingInvoiceSectionCheckCsrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountingInvoiceSectionCheckCsrNoRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN (SELECT COUNT(SID.LINE_TP_LU_CD) FROM SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD = 'PREPAY') = 0 THEN " ).append("\n"); 
		query.append("             'INVOICE'" ).append("\n"); 
		query.append("             WHEN (SELECT COUNT(SID.LINE_TP_LU_CD) FROM SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD = 'PREPAY') > 0 " ).append("\n"); 
		query.append("             AND  (SELECT COUNT(SID.LINE_TP_LU_CD) FROM SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD <> 'PREPAY' AND NVL(SID.ACCTG_PST_FLG, 'N') <> 'Y') = 0 THEN" ).append("\n"); 
		query.append("             'PREPAY' " ).append("\n"); 
		query.append("             WHEN (SELECT COUNT(SID.LINE_TP_LU_CD) FROM SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD = 'PREPAY') > 0 " ).append("\n"); 
		query.append("             AND  (SELECT COUNT(SID.LINE_TP_LU_CD) FROM SAP_INV_DTL SID WHERE SID.INV_SEQ = SIH.INV_SEQ AND SID.LINE_TP_LU_CD <> 'PREPAY' AND NVL(SID.ACCTG_PST_FLG, 'N') <> 'Y') > 0 THEN" ).append("\n"); 
		query.append("             'ALL' ELSE 'INVOICE' END AS INV_STATUS " ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("WHERE   SIH.INV_NO = @[inv_no]" ).append("\n"); 

	}
}