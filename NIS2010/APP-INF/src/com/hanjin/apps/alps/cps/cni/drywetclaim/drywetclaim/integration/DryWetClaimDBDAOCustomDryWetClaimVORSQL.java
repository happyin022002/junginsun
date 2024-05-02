/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DryWetClaimDBDAOCustomDryWetClaimVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.04.23 정행룡
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOCustomDryWetClaimVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dry & Wet Claim List 저장시 VO
	  * </pre>
	  */
	public DryWetClaimDBDAOCustomDryWetClaimVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOCustomDryWetClaimVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  '' DW_CLM_NO" ).append("\n"); 
		query.append(", '' DW_CLM_TP_CD" ).append("\n"); 
		query.append(", '' DW_CO_CD" ).append("\n"); 
		query.append(", '' DW_CLM_REF_VVD_NO" ).append("\n"); 
		query.append(", '' VSL_ENG_NM" ).append("\n"); 
		query.append(", '' INCI_PLC_TP_CD" ).append("\n"); 
		query.append(", '' INCI_OCCR_DT" ).append("\n"); 
		query.append(", '' CRE_OFC_CD" ).append("\n"); 
		query.append(", '' HDLR_OFC_CD" ).append("\n"); 
		query.append(", '' HDLR_USR_ID" ).append("\n"); 
		query.append(", '' TM_BAR_DT" ).append("\n"); 
		query.append(", '' LIT_DT" ).append("\n"); 
		query.append(", '' DW_CLM_STS_CD" ).append("\n"); 
		query.append(", '' DW_CLM_STS_CD_ORG" ).append("\n"); 
		query.append(", '' DW_CLM_ATT_DEF_TP_CD" ).append("\n"); 
		query.append(", '' PRLM_CLM_NTFY_DT" ).append("\n"); 
		query.append(", '' CS_CLZ_DT" ).append("\n"); 
		query.append(", '' ARBT_DT" ).append("\n"); 
		query.append(", '' CLMT_CLM_PTY_NO" ).append("\n"); 
		query.append(", '' CLMT_CTNT" ).append("\n"); 
		query.append(", '' INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(", '' DDCT_USD_AMT" ).append("\n"); 
		query.append(", '' DEFT_CLM_PTY_NO" ).append("\n"); 
		query.append(", '' DEFT_CTNT" ).append("\n"); 
		query.append(", '' LABL_PTY_CLM_PTY_NO" ).append("\n"); 
		query.append(", '' LABL_PTY_CTNT" ).append("\n"); 
		query.append(", '' LABL_PTY_TM_BAR_DT" ).append("\n"); 
		query.append(", '' CLM_LOCL_CURR_CD" ).append("\n"); 
		query.append(", '' CLM_LOCL_AMT" ).append("\n"); 
		query.append(", '' FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append(", '' CLM_XCH_RT" ).append("\n"); 
		query.append(", '' CLM_USD_AMT" ).append("\n"); 
		query.append(", '' CLM_STL_LOCL_CURR_CD" ).append("\n"); 
		query.append(", '' CLM_STL_LOCL_AMT" ).append("\n"); 
		query.append(", '' CLM_STL_DT" ).append("\n"); 
		query.append(", '' CLM_STL_XCH_RT" ).append("\n"); 
		query.append(", '' CLM_STL_USD_AMT" ).append("\n"); 
		query.append(", '' LABL_PTY_FILE_LOCL_CURR_CD" ).append("\n"); 
		query.append(", '' LABL_PTY_FILE_LOCL_AMT" ).append("\n"); 
		query.append(", '' LABL_PTY_FILE_DT" ).append("\n"); 
		query.append(", '' LABL_PTY_FILE_XCH_RT" ).append("\n"); 
		query.append(", '' LABL_PTY_FILE_USD_AMT" ).append("\n"); 
		query.append(", '' LABL_PTY_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append(", '' LABL_PTY_RCVR_LOCL_AMT" ).append("\n"); 
		query.append(", '' LABL_PTY_RCVR_DT" ).append("\n"); 
		query.append(", '' LABL_PTY_RCVR_XCH_RT" ).append("\n"); 
		query.append(", '' LABL_PTY_RCVR_USD_AMT" ).append("\n"); 
		query.append(", '' INSUR_FILE_LOCL_CURR_CD" ).append("\n"); 
		query.append(", '' INSUR_FILE_LOCL_AMT" ).append("\n"); 
		query.append(", '' INSUR_FILE_DT" ).append("\n"); 
		query.append(", '' INSUR_FILE_XCH_RT" ).append("\n"); 
		query.append(", '' INSUR_FILE_USD_AMT" ).append("\n"); 
		query.append(", '' INSUR_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append(", '' INSUR_RCVR_LOCL_AMT" ).append("\n"); 
		query.append(", '' INSUR_RCVR_DT" ).append("\n"); 
		query.append(", '' INSUR_RCVR_XCH_RT" ).append("\n"); 
		query.append(", '' INSUR_RCVR_USD_AMT" ).append("\n"); 
		query.append(", '' DW_CLM_CS_DESC" ).append("\n"); 
		query.append(", '' INCI_DEV_DESC" ).append("\n"); 
		query.append(", '' HDLR_STL_OPIN_DESC" ).append("\n"); 
		query.append(", '' CLMT_AGN_CLM_PTY_NO" ).append("\n"); 
		query.append(", '' CLMT_AGN_TP_CD" ).append("\n"); 
		query.append(", '' CLMT_AGN_APNT_DT" ).append("\n"); 
		query.append(", '' CLMT_AGN_REF_NO" ).append("\n"); 
		query.append(", '' DEFT_AGN_CLM_PTY_NO" ).append("\n"); 
		query.append(", '' DEFT_AGN_TP_CD" ).append("\n"); 
		query.append(", '' DEFT_AGN_APNT_DT" ).append("\n"); 
		query.append(", '' DEFT_AGN_REF_NO" ).append("\n"); 
		query.append(", '' TRNS_FLG" ).append("\n"); 
		query.append(", '' CLM_TRNS_AUTH_CD" ).append("\n"); 
		query.append(", '' TRNS_SEQ" ).append("\n"); 
		query.append(", '' CRE_USR_ID" ).append("\n"); 
		query.append(", '' CRE_DT" ).append("\n"); 
		query.append(", '' UPD_USR_ID" ).append("\n"); 
		query.append(", '' UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}