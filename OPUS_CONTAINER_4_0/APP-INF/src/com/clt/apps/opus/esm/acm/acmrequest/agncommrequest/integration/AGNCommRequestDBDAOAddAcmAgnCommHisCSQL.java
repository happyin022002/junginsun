/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmAgnCommHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmAgnCommHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAcmAgnCommHis
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmAgnCommHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmAgnCommHisCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_COMM_HIS" ).append("\n"); 
		query.append("(BKG_NO, AGN_CD, IO_BND_CD, AC_TP_CD, AC_SEQ, CALC_NO, BDR_FLG, AC_STS_CD, PPD_AMT, CRNT_AMT, IF_AMT, CRNT_REV_AMT, DDCT_CHG_AMT, DDCT_TRSP_AMT, DDCT_SPCL_CMPN_AMT, COMM_FX_AMT, REV_DIV_CD, COMM_RT, AGN_AGMT_NO, AGN_AGMT_SEQ, LOC_DIV_CD, LOC_CD, AR_OFC_CD, AP_OFC_CD, AP_CTR_CD, COMM_STND_COST_CD, SAIL_ARR_DT, AC_OCCR_INFO_CD, AC_SLAN_CD, AC_RLANE_CD, AC_VSL_CD, AC_SKD_VOY_NO, AC_SKD_DIR_CD, AC_REV_DIR_CD, CURR_CD, XCH_RT_APLY_LVL, PAY_XCH_RT, PAY_PPD_AMT, PAY_CRNT_AMT, PAY_IF_AMT, OFC_CHR_CD, VNDR_CNT_CD, VNDR_SEQ, ACCL_FLG, RQST_USR_ID, RQST_DT, RQST_GDT, AUD_NO, AUD_USR_ID, AUD_DT, AUD_GDT, CSR_NO, APRO_USR_ID, APRO_DT, APRO_GDT, GL_DT, ASA_NO, INV_TAX_RT, IF_USR_ID, IF_DT, IF_GDT, AC_PROC_DESC, PPD_OFRT_AMT, PPD_CHG_AMT, CLT_OFRT_AMT, CLT_CHG_AMT, AGN_INFO_SEQ, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT BKG_NO,AGN_CD,IO_BND_CD,AC_TP_CD,AC_SEQ,@[calc_no] AS CALC_NO,BDR_FLG,AC_STS_CD,PPD_AMT,CRNT_AMT,IF_AMT,CRNT_REV_AMT,DDCT_CHG_AMT,DDCT_TRSP_AMT,DDCT_SPCL_CMPN_AMT,COMM_FX_AMT,REV_DIV_CD,COMM_RT,AGN_AGMT_NO,AGN_AGMT_SEQ,LOC_DIV_CD,LOC_CD,AR_OFC_CD,AP_OFC_CD,AP_CTR_CD,COMM_STND_COST_CD,SAIL_ARR_DT,AC_OCCR_INFO_CD,AC_SLAN_CD,AC_RLANE_CD,AC_VSL_CD,AC_SKD_VOY_NO,AC_SKD_DIR_CD,AC_REV_DIR_CD,CURR_CD,XCH_RT_APLY_LVL,PAY_XCH_RT,PAY_PPD_AMT,PAY_CRNT_AMT,PAY_IF_AMT,OFC_CHR_CD,VNDR_CNT_CD,VNDR_SEQ,ACCL_FLG,RQST_USR_ID,RQST_DT,RQST_GDT,AUD_NO,AUD_USR_ID,AUD_DT,AUD_GDT,CSR_NO,APRO_USR_ID,APRO_DT,APRO_GDT,GL_DT,ASA_NO,INV_TAX_RT,IF_USR_ID,IF_DT,IF_GDT,AC_PROC_DESC,PPD_OFRT_AMT,PPD_CHG_AMT,CLT_OFRT_AMT,CLT_CHG_AMT,AGN_INFO_SEQ,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT" ).append("\n"); 
		query.append("FROM ACM_AGN_COMM" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}