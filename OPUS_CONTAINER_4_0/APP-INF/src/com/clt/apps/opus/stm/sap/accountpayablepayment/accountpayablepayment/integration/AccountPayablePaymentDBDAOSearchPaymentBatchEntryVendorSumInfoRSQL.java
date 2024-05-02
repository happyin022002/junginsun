/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchPaymentBatchEntryVendorSumInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.25 
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

public class AccountPayablePaymentDBDAOSearchPaymentBatchEntryVendorSumInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPaymentBatchEntryVendorSumInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchPaymentBatchEntryVendorSumInfoRSQL(){
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
		params.put("pay_bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchPaymentBatchEntryVendorSumInfoRSQL").append("\n"); 
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
		query.append("SELECT  SSI.PAY_BAT_SEQ" ).append("\n"); 
		query.append("      , SSI.PAY_BAT_NM" ).append("\n"); 
		query.append("      , SSI.VNDR_NO" ).append("\n"); 
		query.append("      , SUM(SSI.PAY_AMT) AS PAY_AMT" ).append("\n"); 
		query.append("      , SISC.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("      , (SELECT  NVL(ATTR_CTNT1,0) + 1 AS PAY_NO" ).append("\n"); 
		query.append("         FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("               , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("         WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("         AND     SLH.LU_TP_CD = 'PAYMENT METHOD'" ).append("\n"); 
		query.append("         AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("         AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("         AND     SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("         AND     LU_CD = SISC.PAY_MZD_LU_CD) AS DOC_FIRST_NO" ).append("\n"); 
		query.append("      , (SELECT  NVL(ATTR_CTNT1,0) + 1 AS PAY_NO" ).append("\n"); 
		query.append("         FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("               , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("         WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("         AND     SLH.LU_TP_CD = 'PAYMENT METHOD'" ).append("\n"); 
		query.append("         AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("         AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("         AND     SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("         AND     LU_CD = SISC.PAY_MZD_LU_CD) + COUNT(SSI.VNDR_NO) AS DOC_LAST_NO" ).append("\n"); 
		query.append("FROM    SAP_SEL_INV SSI" ).append("\n"); 
		query.append("      , SAP_INV_SEL_CRTE SISC" ).append("\n"); 
		query.append("WHERE   SSI.PAY_BAT_SEQ = SISC.PAY_BAT_SEQ" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_NM = SISC.PAY_BAT_NM" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_SEQ = @[pay_bat_seq]" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_NM = @[pay_bat_nm]" ).append("\n"); 
		query.append("GROUP   BY SSI.PAY_BAT_SEQ" ).append("\n"); 
		query.append("         , SSI.PAY_BAT_NM" ).append("\n"); 
		query.append("         , SSI.VNDR_NO" ).append("\n"); 
		query.append("         , SISC.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("         , SISC.PAY_MZD_LU_CD" ).append("\n"); 

	}
}