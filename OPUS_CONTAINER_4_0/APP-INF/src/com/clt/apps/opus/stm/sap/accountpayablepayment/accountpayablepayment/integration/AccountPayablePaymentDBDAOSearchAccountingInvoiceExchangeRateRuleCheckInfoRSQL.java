/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountingInvoiceExchangeRateRuleCheckInfoRSQL.java
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

public class AccountPayablePaymentDBDAOSearchAccountingInvoiceExchangeRateRuleCheckInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Accounting에서 Invoice에 대한 처리시 기준이 되는 소스의 Line에 대한 Exchange Rate 처리 기준 정보를 가져온다
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountingInvoiceExchangeRateRuleCheckInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountingInvoiceExchangeRateRuleCheckInfoRSQL").append("\n"); 
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
		query.append("SELECT  SLD.lU_CD AS EX_RATE_BASE" ).append("\n"); 
		query.append("FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("      , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("AND     SLH.LU_TP_CD = 'AP EXCHANGE RATE METHOD'" ).append("\n"); 
		query.append("AND     SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE " ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

	}
}