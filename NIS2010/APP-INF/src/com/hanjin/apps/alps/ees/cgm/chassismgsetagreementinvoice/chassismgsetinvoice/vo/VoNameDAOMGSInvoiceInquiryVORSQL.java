/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VoNameDAOMGSInvoiceInquiryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.12.28 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoNameDAOMGSInvoiceInquiryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091228 2036 start.
	  * </pre>
	  */
	public VoNameDAOMGSInvoiceInquiryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo").append("\n"); 
		query.append("FileName : VoNameDAOMGSInvoiceInquiryVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS PAY_INV_SEQ" ).append("\n"); 
		query.append(", '' AS COST_YRMON" ).append("\n"); 
		query.append(", '' AS INV_ISS_DT" ).append("\n"); 
		query.append(", '' AS INV_RCV_DT" ).append("\n"); 
		query.append(", '' AS INV_CFM_DT" ).append("\n"); 
		query.append(", '' AS AP_IF_DT" ).append("\n"); 
		query.append(", '' AS INVOICE_DATE" ).append("\n"); 
		query.append(", '' AS COST_OFC_CD" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS VNDR_SEQ" ).append("\n"); 
		query.append(", '' AS VNDR_NM" ).append("\n"); 
		query.append(", '' AS CHSS_MGST_INV_KND_CD" ).append("\n"); 
		query.append(", '' AS INV_NO" ).append("\n"); 
		query.append(", '' AS CSR_NO" ).append("\n"); 
		query.append(", '' AS INV_CSR_NO_CHK" ).append("\n"); 
		query.append(", '' AS INV_CSR_NO" ).append("\n"); 
		query.append(", '' AS CHSS_MGST_INV_STS_CD" ).append("\n"); 
		query.append(", '' AS INV_STS_CD" ).append("\n"); 
		query.append(", '' AS INV_STS_NM" ).append("\n"); 
		query.append(", '' AS CHSS_MSST_INV_KND_CD" ).append("\n"); 
		query.append(", '' AS	REV_VVD" ).append("\n"); 
		query.append(", '' AS CHG_SMRY_AMT" ).append("\n"); 
		query.append(", '' AS INV_TAX_CLT_TP_CD" ).append("\n"); 
		query.append(", '' AS INV_TAX_RT" ).append("\n"); 
		query.append(", '' AS INV_SMRY_AMT" ).append("\n"); 
		query.append(", '' AS USR_NM" ).append("\n"); 
		query.append(", '' AS INV_FM_DATE" ).append("\n"); 
		query.append(", '' AS INV_TO_DATE" ).append("\n"); 
		query.append(", '' AS INV_STATUS" ).append("\n"); 
		query.append(", '' AS AGMT_NO" ).append("\n"); 
		query.append(", '' AS AGMT_LSTM_CD" ).append("\n"); 
		query.append(", '' AS ACCT_CD" ).append("\n"); 
		query.append(", '' AS EQ_NO" ).append("\n"); 
		query.append(", '' AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(", '' AS CURR_CD" ).append("\n"); 
		query.append(", '' AS CHG_CD" ).append("\n"); 
		query.append(", '' AS PAY_TAX_AMT" ).append("\n"); 
		query.append(", '' AS PAY_CR_AMT" ).append("\n"); 
		query.append(", '' AS PAY_LSE_CHG_AMT" ).append("\n"); 
		query.append(", '' AS EQ_KND_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}