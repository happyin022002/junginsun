/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOMakeEurTroMstVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2010.01.05 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOMakeEurTroMstVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOMakeEurTroMstVO
	  * </pre>
	  */
	public TransferOrderIssueDBDAOMakeEurTroMstVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOMakeEurTroMstVORSQL").append("\n"); 
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
		query.append("SELECT '' SO_DT, CNTR_PKUP_YD_CD, CXL_FLG, AWK_CGO_SEQ," ).append("\n"); 
		query.append("--ALL_IN_RT_FLG," ).append("\n"); 
		query.append("ALL_IN_RT_CD," ).append("\n"); 
		query.append("'' HLG_TP_CD_OLD," ).append("\n"); 
		query.append("PCTL_NO, CORR_FLG, CNTR_RTN_YD_CD, CFM_CURR_CD, CSTMS_CLR_NO, '' WGT_UT_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD, CFM_USR_ID, UPD_USR_ID, '' CNTR_RTN_DT_HHMI, CGO_WGT," ).append("\n"); 
		query.append("'' CNTR_PRT_FLG, '' SO_NO, '' REP_CMDT_NM, '' CNTR_TPSZ_CD_OLD, CFM_DT, CFM_HLG_TP_CD," ).append("\n"); 
		query.append("'' SO_OFC_CD, TRO_PROC_CD, CFM_VAT_FLG, CRE_USR_ID, BKG_NO, RQST_SUB_SEQ," ).append("\n"); 
		query.append("RC_SEQ, CFM_UPD_DT, CURR_CD, SO_CTY_CD, TRNS_REV_AMT," ).append("\n"); 
		query.append("'' SO_USR_ID, ACT_CNT_CD, CRE_OFC_CD, VAT_FLG, SPCL_INSTR_RMK, HLG_TP_CD," ).append("\n"); 
		query.append("T1_DOC_FLG, CNTR_RTN_DT," ).append("\n"); 
		query.append("--CFM_ALL_IN_RT_FLG," ).append("\n"); 
		query.append("CFM_ALL_IN_RT_CD," ).append("\n"); 
		query.append("'' TRO_CMDT_CD," ).append("\n"); 
		query.append("TRO_SEQ, CFM_REV_AMT, ACT_CUST_SEQ, CORR_NO," ).append("\n"); 
		query.append("BKG_TRSP_MZD_CD, IO_BND_CD, CFM_FLG, CFM_OFC_CD," ).append("\n"); 
		query.append("'' CNTR_PKUP_DT_HHMI," ).append("\n"); 
		query.append("CNTR_PKUP_DT, CNTR_NO, REP_CMDT_CD," ).append("\n"); 
		query.append("'' SO_USR_NM," ).append("\n"); 
		query.append("'' CFM_USR_NM," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("EUR_TRNS_TP_CD" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO" ).append("\n"); 

	}
}