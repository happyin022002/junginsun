/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchPaymentPossibleInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchPaymentPossibleInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPaymentPossibleInvoiceList
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchPaymentPossibleInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchPaymentPossibleInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT  SIH.INV_NO                          AS INV_NO" ).append("\n"); 
		query.append("      , SIH.INV_SEQ                         AS INV_SEQ" ).append("\n"); 
		query.append("      , TO_CHAR(SIH.INV_DT,'YYYYMMDD')      AS INV_DT" ).append("\n"); 
		query.append("      , SIH.VNDR_NO                         AS VNDR_NO" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM                  AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , SIH.INV_CURR_CD                     AS PAY_CURR_CD" ).append("\n"); 
		query.append("      , TRIM(SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SIH.INV_AMT))  INV_AMT" ).append("\n"); 
		query.append("      , TO_CHAR(SPS.DUE_DT,'YYYYMMDD')      AS DUE_DT" ).append("\n"); 
		query.append("      , SIH.INV_DESC                        AS INV_DESC" ).append("\n"); 
		query.append("      , TRIM(SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SPS.PAY_RMN_AMT))  PAY_AMT" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NO                    AS BANK_ACCT_NO" ).append("\n"); 
		query.append("      , @[pay_bat_seq]                      AS PAY_BAT_SEQ" ).append("\n"); 
		query.append("      , @[pay_bat_nm]                       AS PAY_BAT_NM" ).append("\n"); 
		query.append("	  , SPS.PAY_SKD_NO                      AS PAY_SKD_NO" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAP_PAY_SKD SPS" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("      , SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("WHERE   SIH.INV_SEQ = SPS.INV_SEQ " ).append("\n"); 
		query.append("AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ " ).append("\n"); 
		query.append("AND     SPS.XTER_BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("AND     SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("AND     NVL(SIH.PAY_STS_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND     NVL(SPS.PAY_STS_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND     NVL(SPS.INV_HLD_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND     SPS.PAY_BAT_RUN_SEQ IS NULL" ).append("\n"); 
		query.append("AND     SIH.AP_APSTS_CD = 'MANUALLY APPROVED'" ).append("\n"); 
		query.append("AND     SIH.INV_NO LIKE NVL(@[inv_no], '')||'%'" ).append("\n"); 

	}
}