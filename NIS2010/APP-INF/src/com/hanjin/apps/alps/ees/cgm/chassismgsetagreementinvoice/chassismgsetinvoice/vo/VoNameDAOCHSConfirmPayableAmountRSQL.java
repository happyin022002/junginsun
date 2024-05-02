/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VoNameDAOCHSConfirmPayableAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.04 조재성
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

public class VoNameDAOCHSConfirmPayableAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20100104 chg_seq 추가.
	  * </pre>
	  */
	public VoNameDAOCHSConfirmPayableAmountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo").append("\n"); 
		query.append("FileName : VoNameDAOCHSConfirmPayableAmountRSQL").append("\n"); 
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
		query.append("'' AS INV_CUST_EQ_NO," ).append("\n"); 
		query.append("'' AS EQ_NO," ).append("\n"); 
		query.append("'' AS INV_NO," ).append("\n"); 
		query.append("'' AS AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("'' AS AGMT_SEQ," ).append("\n"); 
		query.append("'' AS AGMT_VER_NO," ).append("\n"); 
		query.append("'' AS AGMT_NO," ).append("\n"); 
		query.append("'' AS AGMT_LSTM_CD," ).append("\n"); 
		query.append("'' AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("'' AS INV_REF_NO," ).append("\n"); 
		query.append("'' AS LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("'' AS CHG_CD," ).append("\n"); 
		query.append("'' AS CHG_SEQ," ).append("\n"); 
		query.append("'' AS EQ_ONH_LOC_CD," ).append("\n"); 
		query.append("'' AS EQ_ONH_DT," ).append("\n"); 
		query.append("'' AS EQ_BIL_ST_DT," ).append("\n"); 
		query.append("'' AS EQ_OFFH_LOC_CD," ).append("\n"); 
		query.append("'' AS EQ_OFFH_DT," ).append("\n"); 
		query.append("'' AS LSE_USE_DYS," ).append("\n"); 
		query.append("'' AS LSE_RT_AMT," ).append("\n"); 
		query.append("'' AS LSE_CHG_AMT," ).append("\n"); 
		query.append("'' AS INV_EQ_NO," ).append("\n"); 
		query.append("'' AS INV_BIL_ST_DT," ).append("\n"); 
		query.append("'' AS INV_BIL_END_DT," ).append("\n"); 
		query.append("'' AS INV_EQ_ONH_LOC_NM," ).append("\n"); 
		query.append("'' AS INV_EQ_OFFH_LOC_NM," ).append("\n"); 
		query.append("'' AS INV_LSE_USE_DYS," ).append("\n"); 
		query.append("'' AS INV_LSE_RT_AMT," ).append("\n"); 
		query.append("'' AS INV_TAX_AMT," ).append("\n"); 
		query.append("'' AS INV_CR_AMT," ).append("\n"); 
		query.append("'' AS INV_LSE_CHG_AMT," ).append("\n"); 
		query.append("'' AS AUD_UMCH_EQ_STS_EVNT_YD_CD," ).append("\n"); 
		query.append("'' AS AUD_UMCH_EQ_STS_EVNT_DT," ).append("\n"); 
		query.append("'' AS AUD_UMCH_EQ_ASET_STS_CD," ).append("\n"); 
		query.append("'' AS PAY_CHG_AUD_RMK," ).append("\n"); 
		query.append("'' AS COST_YRMON," ).append("\n"); 
		query.append("'' AS EQ_KND_CD," ).append("\n"); 
		query.append("'' AS CHG_CRE_SEQ," ).append("\n"); 
		query.append("'' AS VNDR_SEQ," ).append("\n"); 
		query.append("'' AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("'' AS EQ_ASET_STS_CD," ).append("\n"); 
		query.append("'' AS STS_EVNT_DT," ).append("\n"); 
		query.append("'' AS PAY_LSE_CHG_STS_CD," ).append("\n"); 
		query.append("'' AS COST_CD," ).append("\n"); 
		query.append("'' AS ACCT_CD," ).append("\n"); 
		query.append("'' AS CRE_USR_ID," ).append("\n"); 
		query.append("'' AS UPD_USR_ID," ).append("\n"); 
		query.append("'' AS PAY_INV_SEQ," ).append("\n"); 
		query.append("'' AS CURR_CD," ).append("\n"); 
		query.append("'' AS COST_OFC_CD," ).append("\n"); 
		query.append("'' AS ISS_OFC_CD," ).append("\n"); 
		query.append("'' AS CHG_SMRY_AMT," ).append("\n"); 
		query.append("'' AS INV_SMRY_AMT," ).append("\n"); 
		query.append("'' AS INV_DT," ).append("\n"); 
		query.append("'' AS INV_USR_ID," ).append("\n"); 
		query.append("'' AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}