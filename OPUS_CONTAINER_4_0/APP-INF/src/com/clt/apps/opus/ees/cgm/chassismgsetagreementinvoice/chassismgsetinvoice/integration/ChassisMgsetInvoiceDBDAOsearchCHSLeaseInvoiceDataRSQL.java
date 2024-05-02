/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchCHSLeaseInvoiceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.12.09 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae-Shung, Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOsearchCHSLeaseInvoiceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091208 1030 추가사항
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchCHSLeaseInvoiceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchCHSLeaseInvoiceDataRSQL").append("\n"); 
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
		query.append(",TO_CHAR(INV_EQ_ONH_DT,'YYYY-MM-DD') AS INV_EQ_ONH_DT" ).append("\n"); 
		query.append(",INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append(",TO_CHAR(INV_EQ_OFFH_DT,'YYYY-MM-DD') AS INV_EQ_OFFH_DT" ).append("\n"); 
		query.append(",INV_EQ_OFFH_LOC_NM" ).append("\n"); 
		query.append(",TO_CHAR(INV_BIL_ST_DT,'YYYY-MM-DD') AS INV_BIL_ST_DT" ).append("\n"); 
		query.append(",TO_CHAR(INV_BIL_END_DT,'YYYY-MM-DD') AS INV_BIL_END_DT" ).append("\n"); 
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
		query.append("WHERE" ).append("\n"); 
		query.append("CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 

	}
}