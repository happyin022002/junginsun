/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSLeaseInvoiceSaveDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.05.04 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSLeaseInvoiceSaveDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091208 1030 add
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSLeaseInvoiceSaveDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSLeaseInvoiceSaveDataRSQL").append("\n"); 
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
		query.append("INV_NO" ).append("\n"); 
		query.append(",INV_REF_NO" ).append("\n"); 
		query.append(",INV_EQ_NO" ).append("\n"); 
		query.append(",INV_CUST_EQ_NO" ).append("\n"); 
		query.append(",INV_EQ_ONH_DT" ).append("\n"); 
		query.append(",INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append(",INV_EQ_OFFH_DT" ).append("\n"); 
		query.append(",INV_EQ_OFFH_LOC_NM" ).append("\n"); 
		query.append(",INV_BIL_ST_DT" ).append("\n"); 
		query.append(",INV_BIL_END_DT" ).append("\n"); 
		query.append(",INV_LSE_USE_DYS" ).append("\n"); 
		query.append(",INV_LSE_RT_AMT" ).append("\n"); 
		query.append(",INV_LSE_CHG_AMT" ).append("\n"); 
		query.append(",INV_TAX_AMT" ).append("\n"); 
		query.append(",INV_CR_AMT" ).append("\n"); 
		query.append(",VRFY_RSLT_DESC" ).append("\n"); 
		query.append(",CHG_CD" ).append("\n"); 
		query.append(",COST_CD" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",AGMT_SEQ" ).append("\n"); 
		query.append(",AGMT_VER_NO" ).append("\n"); 
		query.append(",VRFY_SCS_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",EQ_NO" ).append("\n"); 
		query.append(",COST_YRMON" ).append("\n"); 
		query.append(",LSE_USE_DYS" ).append("\n"); 
		query.append(",LSE_RT_AMT" ).append("\n"); 
		query.append(",LSE_CHG_AMT" ).append("\n"); 
		query.append(",LSE_CHG_AUD_STS_CD" ).append("\n"); 
		query.append(",LSE_CHG_AUD_RSLT_RSN_CD" ).append("\n"); 
		query.append(",AGMT_LSTM_CD" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append(",CHG_CRE_SEQ" ).append("\n"); 
		query.append(",LSE_CHG_STS_CD" ).append("\n"); 
		query.append(",PAY_LSE_CHG_STS_CD" ).append("\n"); 
		query.append(",INV_SMRY_AMT" ).append("\n"); 
		query.append(",CR_SMRY_AMT" ).append("\n"); 
		query.append(",TAX_SMRY_AMT" ).append("\n"); 
		query.append(",EQ_ASET_STS_CD" ).append("\n"); 
		query.append(",AUD_UMCH_EQ_STS_EVNT_YD_CD" ).append("\n"); 
		query.append(",AUD_UMCH_EQ_ASET_STS_CD" ).append("\n"); 
		query.append(",AUD_UMCH_EQ_STS_EVNT_DT" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",INV_CHG_TP_NM" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM CGM_LSE_INV_TMP" ).append("\n"); 

	}
}