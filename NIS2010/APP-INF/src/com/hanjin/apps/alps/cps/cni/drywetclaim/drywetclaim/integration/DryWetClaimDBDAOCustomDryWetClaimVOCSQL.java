/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DryWetClaimDBDAOCustomDryWetClaimVOCSQL.java
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

public class DryWetClaimDBDAOCustomDryWetClaimVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public DryWetClaimDBDAOCustomDryWetClaimVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inci_plc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rcvr_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_file_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_file_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_file_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rcvr_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_tm_bar_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_file_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_file_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_agn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rcvr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inci_dev_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_file_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_rcvr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_rcvr_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_agn_apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rcvr_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prlm_clm_ntfy_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deft_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_file_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arbt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lit_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_agn_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_stl_opin_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_rcvr_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_file_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deft_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_rcvr_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ddct_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_rcvr_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_cs_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tm_bar_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deft_agn_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_file_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_file_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_rcvr_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deft_agn_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deft_agn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmal_clm_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inci_occr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_agn_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deft_agn_apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_att_def_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOCustomDryWetClaimVOCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_DW_CLM (" ).append("\n"); 
		query.append("  DW_CLM_NO" ).append("\n"); 
		query.append(", DW_CLM_TP_CD" ).append("\n"); 
		query.append(", DW_CO_CD" ).append("\n"); 
		query.append(", DW_CLM_REF_VVD_NO" ).append("\n"); 
		query.append(", VSL_ENG_NM" ).append("\n"); 
		query.append(", INCI_PLC_TP_CD" ).append("\n"); 
		query.append(", INCI_OCCR_DT" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", HDLR_OFC_CD" ).append("\n"); 
		query.append(", HDLR_USR_ID" ).append("\n"); 
		query.append(", TM_BAR_DT" ).append("\n"); 
		query.append(", LIT_DT" ).append("\n"); 
		query.append(", DW_CLM_STS_CD" ).append("\n"); 
		query.append(", DW_CLM_ATT_DEF_TP_CD" ).append("\n"); 
		query.append(", PRLM_CLM_NTFY_DT" ).append("\n"); 
		query.append(", CS_CLZ_DT" ).append("\n"); 
		query.append(", ARBT_DT" ).append("\n"); 
		query.append(", CLMT_CLM_PTY_NO" ).append("\n"); 
		query.append(", CLMT_CTNT" ).append("\n"); 
		query.append(", INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(", DDCT_USD_AMT" ).append("\n"); 
		query.append(", DEFT_CLM_PTY_NO" ).append("\n"); 
		query.append(", DEFT_CTNT" ).append("\n"); 
		query.append(", LABL_PTY_CLM_PTY_NO" ).append("\n"); 
		query.append(", LABL_PTY_CTNT" ).append("\n"); 
		query.append(", LABL_PTY_TM_BAR_DT" ).append("\n"); 
		query.append(", CLM_LOCL_CURR_CD" ).append("\n"); 
		query.append(", CLM_LOCL_AMT" ).append("\n"); 
		query.append(", FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append(", CLM_XCH_RT" ).append("\n"); 
		query.append(", CLM_USD_AMT" ).append("\n"); 
		query.append(", CLM_STL_LOCL_CURR_CD" ).append("\n"); 
		query.append(", CLM_STL_LOCL_AMT" ).append("\n"); 
		query.append(", CLM_STL_DT" ).append("\n"); 
		query.append(", CLM_STL_XCH_RT" ).append("\n"); 
		query.append(", CLM_STL_USD_AMT" ).append("\n"); 
		query.append(", LABL_PTY_FILE_LOCL_CURR_CD" ).append("\n"); 
		query.append(", LABL_PTY_FILE_LOCL_AMT" ).append("\n"); 
		query.append(", LABL_PTY_FILE_DT" ).append("\n"); 
		query.append(", LABL_PTY_FILE_XCH_RT" ).append("\n"); 
		query.append(", LABL_PTY_FILE_USD_AMT" ).append("\n"); 
		query.append(", LABL_PTY_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append(", LABL_PTY_RCVR_LOCL_AMT" ).append("\n"); 
		query.append(", LABL_PTY_RCVR_DT" ).append("\n"); 
		query.append(", LABL_PTY_RCVR_XCH_RT" ).append("\n"); 
		query.append(", LABL_PTY_RCVR_USD_AMT" ).append("\n"); 
		query.append(", INSUR_FILE_LOCL_CURR_CD" ).append("\n"); 
		query.append(", INSUR_FILE_LOCL_AMT" ).append("\n"); 
		query.append(", INSUR_FILE_DT" ).append("\n"); 
		query.append(", INSUR_FILE_XCH_RT" ).append("\n"); 
		query.append(", INSUR_FILE_USD_AMT" ).append("\n"); 
		query.append(", INSUR_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append(", INSUR_RCVR_LOCL_AMT" ).append("\n"); 
		query.append(", INSUR_RCVR_DT" ).append("\n"); 
		query.append(", INSUR_RCVR_XCH_RT" ).append("\n"); 
		query.append(", INSUR_RCVR_USD_AMT" ).append("\n"); 
		query.append(", DW_CLM_CS_DESC" ).append("\n"); 
		query.append(", INCI_DEV_DESC" ).append("\n"); 
		query.append(", HDLR_STL_OPIN_DESC" ).append("\n"); 
		query.append(", CLMT_AGN_CLM_PTY_NO" ).append("\n"); 
		query.append(", CLMT_AGN_TP_CD" ).append("\n"); 
		query.append(", CLMT_AGN_APNT_DT" ).append("\n"); 
		query.append(", CLMT_AGN_REF_NO" ).append("\n"); 
		query.append(", DEFT_AGN_CLM_PTY_NO" ).append("\n"); 
		query.append(", DEFT_AGN_TP_CD" ).append("\n"); 
		query.append(", DEFT_AGN_APNT_DT" ).append("\n"); 
		query.append(", DEFT_AGN_REF_NO" ).append("\n"); 
		query.append(", TRNS_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append(" @[dw_clm_no]" ).append("\n"); 
		query.append(",@[dw_clm_tp_cd]" ).append("\n"); 
		query.append(",@[dw_co_cd]" ).append("\n"); 
		query.append(",@[dw_clm_ref_vvd_no]" ).append("\n"); 
		query.append(",@[vsl_eng_nm]" ).append("\n"); 
		query.append(",@[inci_plc_tp_cd]" ).append("\n"); 
		query.append(",REPLACE(@[inci_occr_dt],'-')" ).append("\n"); 
		query.append(",@[cre_ofc_cd]" ).append("\n"); 
		query.append(",@[hdlr_ofc_cd]" ).append("\n"); 
		query.append(",@[hdlr_usr_id]" ).append("\n"); 
		query.append(",REPLACE(@[tm_bar_dt],'-')" ).append("\n"); 
		query.append(",REPLACE(@[lit_dt],'-')" ).append("\n"); 
		query.append(",@[dw_clm_sts_cd]" ).append("\n"); 
		query.append(",@[dw_clm_att_def_tp_cd]" ).append("\n"); 
		query.append(",REPLACE(@[prlm_clm_ntfy_dt],'-')" ).append("\n"); 
		query.append(",REPLACE(@[cs_clz_dt],'-')" ).append("\n"); 
		query.append(",REPLACE(@[arbt_dt],'-')" ).append("\n"); 
		query.append(",@[clmt_clm_pty_no]" ).append("\n"); 
		query.append(",@[clmt_ctnt]" ).append("\n"); 
		query.append(",@[insur_clm_pty_no]" ).append("\n"); 
		query.append(",REPLACE(@[ddct_usd_amt],',')" ).append("\n"); 
		query.append(",@[deft_clm_pty_no]" ).append("\n"); 
		query.append(",@[deft_ctnt]" ).append("\n"); 
		query.append(",@[labl_pty_clm_pty_no]" ).append("\n"); 
		query.append(",@[labl_pty_ctnt]" ).append("\n"); 
		query.append(",REPLACE(@[labl_pty_tm_bar_dt],'-')" ).append("\n"); 
		query.append(",@[clm_locl_curr_cd]" ).append("\n"); 
		query.append(",REPLACE(@[clm_locl_amt],',')" ).append("\n"); 
		query.append(",REPLACE(@[fmal_clm_rcv_dt],'-')" ).append("\n"); 
		query.append(",REPLACE(@[clm_xch_rt],',')" ).append("\n"); 
		query.append(",REPLACE(@[clm_usd_amt],',')" ).append("\n"); 
		query.append(",@[clm_stl_locl_curr_cd]" ).append("\n"); 
		query.append(",REPLACE(@[clm_stl_locl_amt],',')" ).append("\n"); 
		query.append(",REPLACE(@[clm_stl_dt],'-')" ).append("\n"); 
		query.append(",REPLACE(@[clm_stl_xch_rt],',')" ).append("\n"); 
		query.append(",REPLACE(@[clm_stl_usd_amt],',')" ).append("\n"); 
		query.append(",@[labl_pty_file_locl_curr_cd]" ).append("\n"); 
		query.append(",REPLACE(@[labl_pty_file_locl_amt],',')" ).append("\n"); 
		query.append(",REPLACE(@[labl_pty_file_dt],'-')" ).append("\n"); 
		query.append(",REPLACE(@[labl_pty_file_xch_rt],',')" ).append("\n"); 
		query.append(",REPLACE(@[labl_pty_file_usd_amt],',')" ).append("\n"); 
		query.append(",@[labl_pty_rcvr_locl_curr_cd]" ).append("\n"); 
		query.append(",REPLACE(@[labl_pty_rcvr_locl_amt],',')" ).append("\n"); 
		query.append(",REPLACE(@[labl_pty_rcvr_dt],'-')" ).append("\n"); 
		query.append(",REPLACE(@[labl_pty_rcvr_xch_rt],',')" ).append("\n"); 
		query.append(",REPLACE(@[labl_pty_rcvr_usd_amt],',')" ).append("\n"); 
		query.append(",@[insur_file_locl_curr_cd]" ).append("\n"); 
		query.append(",REPLACE(@[insur_file_locl_amt],',')" ).append("\n"); 
		query.append(",REPLACE(@[insur_file_dt],'-')" ).append("\n"); 
		query.append(",REPLACE(@[insur_file_xch_rt],',')" ).append("\n"); 
		query.append(",REPLACE(@[insur_file_usd_amt],',')" ).append("\n"); 
		query.append(",@[insur_rcvr_locl_curr_cd]" ).append("\n"); 
		query.append(",REPLACE(@[insur_rcvr_locl_amt],',')" ).append("\n"); 
		query.append(",REPLACE(@[insur_rcvr_dt],'-')" ).append("\n"); 
		query.append(",REPLACE(@[insur_rcvr_xch_rt],',')" ).append("\n"); 
		query.append(",REPLACE(@[insur_rcvr_usd_amt],',')" ).append("\n"); 
		query.append(",@[dw_clm_cs_desc]" ).append("\n"); 
		query.append(",@[inci_dev_desc]" ).append("\n"); 
		query.append(",@[hdlr_stl_opin_desc]" ).append("\n"); 
		query.append(",@[clmt_agn_clm_pty_no]" ).append("\n"); 
		query.append(",@[clmt_agn_tp_cd]" ).append("\n"); 
		query.append(",REPLACE(@[clmt_agn_apnt_dt],'-')" ).append("\n"); 
		query.append(",@[clmt_agn_ref_no]" ).append("\n"); 
		query.append(",@[deft_agn_clm_pty_no]" ).append("\n"); 
		query.append(",@[deft_agn_tp_cd]" ).append("\n"); 
		query.append(",REPLACE(@[deft_agn_apnt_dt],'-')" ).append("\n"); 
		query.append(",@[deft_agn_ref_no]" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}