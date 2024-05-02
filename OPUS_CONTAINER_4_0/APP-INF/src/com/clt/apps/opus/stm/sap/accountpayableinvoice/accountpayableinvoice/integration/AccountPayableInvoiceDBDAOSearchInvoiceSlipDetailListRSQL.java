/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceSlipDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.23 
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

public class AccountPayableInvoiceDBDAOSearchInvoiceSlipDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0030 Invoice Slip Inquiry - Invoice Detail List Retrieve
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceSlipDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceSlipDetailListRSQL").append("\n"); 
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
		query.append("SELECT  SID.DTRB_LINE_NO        AS DTRB_LINE_NO" ).append("\n"); 
		query.append("      , SID.LINE_TP_LU_CD       AS LINE_TP_LU_CD" ).append("\n"); 
		query.append("      , SID.ACCTG_PST_FLG       AS ACCTG_PST_FLG" ).append("\n"); 
		query.append("      , SID.ACCTG_DT            AS ACCTG_DT" ).append("\n"); 
		query.append("      , OPUSADM.SAP_GET_CUR_AMT_FNC(@[inv_curr_cd], SID.DTRB_AMT )  AS DTRB_AMT" ).append("\n"); 
		query.append("      , SID.DTRB_VAT_CD         AS DTRB_VAT_CD" ).append("\n"); 
		query.append("      , ATX.AP_TAX_NM           AS VAT_NAME" ).append("\n"); 
		query.append("      , SID.ATTR_CTNT1          AS VENDOR_INV_NO" ).append("\n"); 
		query.append("      , SID.ATTR_CTNT2          AS VENDOR_INV_DATE" ).append("\n"); 
		query.append("      , SID.DTRB_DESC           AS DTRB_DESC" ).append("\n"); 
		query.append("FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("      , ( SELECT  D.LU_CD AS TAX_NO" ).append("\n"); 
		query.append("                , D.LU_DESC AS AP_TAX_NM" ).append("\n"); 
		query.append("          FROM  SCO_LU_HDR H, SCO_LU_DTL D" ).append("\n"); 
		query.append("          WHERE H.LU_TP_CD = D.LU_TP_CD " ).append("\n"); 
		query.append("          AND   H.LU_TP_CD = 'AP TAX CODE'" ).append("\n"); 
		query.append("          AND   H.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("          AND   D.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("          ORDER BY D.DP_SEQ" ).append("\n"); 
		query.append("        )  ATX" ).append("\n"); 
		query.append("WHERE   SID.DTRB_VAT_CD = ATX.TAX_NO(+)" ).append("\n"); 
		query.append("AND     SID.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("ORDER BY SID.DTRB_LINE_NO" ).append("\n"); 

	}
}