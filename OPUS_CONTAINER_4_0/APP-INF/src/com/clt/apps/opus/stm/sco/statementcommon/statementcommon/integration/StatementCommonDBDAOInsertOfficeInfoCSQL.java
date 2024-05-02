/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOInsertOfficeInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOInsertOfficeInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert Office Information
	  * </pre>
	  */
	public StatementCommonDBDAOInsertOfficeInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_doc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("misc_lss_lmt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_prn_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_cr_cust_prn_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("enbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_spcl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_inq_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_prn_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_ots_lmt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_brnc_agn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_wrtf_tp_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("misc_incm_lmt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_chg_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_entr_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_unapy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_telcm_fax_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_adj_tp_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_adj_tp_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_adj_tp_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_adj_tp_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_spcl_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_wrtf_tp_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_wrtf_tp_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cmb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_wrtf_tp_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovpay_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_wrtf_tp_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_adj_tp_cd5",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOInsertOfficeInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SCO_OFC_INFO" ).append("\n"); 
		query.append("(  OFC_CD," ).append("\n"); 
		query.append("   OFC_ENTR_LVL_CD," ).append("\n"); 
		query.append("   OFC_INQ_LVL_CD," ).append("\n"); 
		query.append("   OFC_BRNC_AGN_TP_CD," ).append("\n"); 
		query.append("   BANK_CTRL_CD," ).append("\n"); 
		query.append("   BANK_CHG_ACCT_CD," ).append("\n"); 
		query.append("   LOCL_CURR_CD," ).append("\n"); 
		query.append("   AGN_CMB_CD," ).append("\n"); 
		query.append("   AGN_PFX_CD," ).append("\n"); 
		query.append("   AGN_CURR_CD," ).append("\n"); 
		query.append("   AGN_OTS_LMT_AMT," ).append("\n"); 
		query.append("   AGN_OTS_LMT_FLG," ).append("\n"); 
		query.append("   OTS_CATE_CD," ).append("\n"); 
		query.append("   OTS_CD," ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   OVPAY_TP_CD," ).append("\n"); 
		query.append("   MISC_LSS_LMT_AMT," ).append("\n"); 
		query.append("   MISC_INCM_LMT_AMT," ).append("\n"); 
		query.append("   OTS_IF_FLG," ).append("\n"); 
		query.append("   REP_OTS_OFC_CD," ).append("\n"); 
		query.append("   ENBL_FLG," ).append("\n"); 
		query.append("   RCT_TP_CD," ).append("\n"); 
		query.append("   RCT_DOC_CD," ).append("\n"); 
		query.append("   RCT_UNAPY_FLG," ).append("\n"); 
		query.append("   BANK_OFC," ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   RCT_OFC_TIT_NM," ).append("\n"); 
		query.append("   RCT_OFC_ADDR," ).append("\n"); 
		query.append("   RCT_OFC_TELCM_FAX_NO_CTNT," ).append("\n"); 
		query.append("   RCT_TIT_NM," ).append("\n"); 
		query.append("   RCT_RMK," ).append("\n"); 
		query.append("   RCT_SPCL_RMK," ).append("\n"); 
		query.append("   RCT_OFC_SPCL_NO_CTNT,  " ).append("\n"); 
		query.append("   AR_PRN_TIT_NM," ).append("\n"); 
		query.append("   AR_CR_CUST_PRN_CTNT," ).append("\n"); 
		query.append("   AR_PRN_CTNT,  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   OFC_WRTF_TP_CD1," ).append("\n"); 
		query.append("   OFC_WRTF_TP_CD2," ).append("\n"); 
		query.append("   OFC_WRTF_TP_CD3," ).append("\n"); 
		query.append("   OFC_WRTF_TP_CD4," ).append("\n"); 
		query.append("   OFC_WRTF_TP_CD5," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   OFC_ADJ_TP_CD1," ).append("\n"); 
		query.append("   OFC_ADJ_TP_CD2," ).append("\n"); 
		query.append("   OFC_ADJ_TP_CD3," ).append("\n"); 
		query.append("   OFC_ADJ_TP_CD4," ).append("\n"); 
		query.append("   OFC_ADJ_TP_CD5," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT," ).append("\n"); 
		query.append("   REF_EML" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(  @[ofc_cd]," ).append("\n"); 
		query.append("   @[ofc_entr_lvl_cd]," ).append("\n"); 
		query.append("   @[ofc_inq_lvl_cd]," ).append("\n"); 
		query.append("   @[ofc_brnc_agn_tp_cd]," ).append("\n"); 
		query.append("   @[bank_ctrl_cd]," ).append("\n"); 
		query.append("   @[bank_chg_acct_cd]," ).append("\n"); 
		query.append("   @[locl_curr_cd]," ).append("\n"); 
		query.append("   @[agn_cmb_cd]," ).append("\n"); 
		query.append("   @[agn_pfx_cd]," ).append("\n"); 
		query.append("   @[agn_curr_cd]," ).append("\n"); 
		query.append("   @[agn_ots_lmt_amt]," ).append("\n"); 
		query.append("   @[agn_ots_lmt_flg]," ).append("\n"); 
		query.append("   @[ots_cate_cd]," ).append("\n"); 
		query.append("   @[ots_cd]," ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   @[ovpay_tp_cd]," ).append("\n"); 
		query.append("   @[misc_lss_lmt_amt]," ).append("\n"); 
		query.append("   @[misc_incm_lmt_amt]," ).append("\n"); 
		query.append("   @[ots_if_flg]," ).append("\n"); 
		query.append("   @[rep_ots_ofc_cd]," ).append("\n"); 
		query.append("   @[enbl_flg]," ).append("\n"); 
		query.append("   @[rct_tp_cd]," ).append("\n"); 
		query.append("   @[rct_doc_cd]," ).append("\n"); 
		query.append("   @[rct_unapy_flg]," ).append("\n"); 
		query.append("   @[bank_ofc]," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   @[rct_ofc_tit_nm]," ).append("\n"); 
		query.append("   @[rct_ofc_addr]," ).append("\n"); 
		query.append("   @[rct_ofc_telcm_fax_no_ctnt]," ).append("\n"); 
		query.append("   @[rct_tit_nm]," ).append("\n"); 
		query.append("   @[rct_rmk]," ).append("\n"); 
		query.append("   @[rct_spcl_rmk]," ).append("\n"); 
		query.append("   @[rct_ofc_spcl_no_ctnt]," ).append("\n"); 
		query.append("   @[ar_prn_tit_nm]," ).append("\n"); 
		query.append("   @[ar_cr_cust_prn_ctnt]," ).append("\n"); 
		query.append("   @[ar_prn_ctnt]," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   @[ofc_wrtf_tp_cd1]," ).append("\n"); 
		query.append("   @[ofc_wrtf_tp_cd2]," ).append("\n"); 
		query.append("   @[ofc_wrtf_tp_cd3]," ).append("\n"); 
		query.append("   @[ofc_wrtf_tp_cd4]," ).append("\n"); 
		query.append("   @[ofc_wrtf_tp_cd5]," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   @[ofc_adj_tp_cd1]," ).append("\n"); 
		query.append("   @[ofc_adj_tp_cd2]," ).append("\n"); 
		query.append("   @[ofc_adj_tp_cd3]," ).append("\n"); 
		query.append("   @[ofc_adj_tp_cd4]," ).append("\n"); 
		query.append("   @[ofc_adj_tp_cd5]," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   @[cre_usr_id]," ).append("\n"); 
		query.append("   SYSDATE," ).append("\n"); 
		query.append("   @[upd_usr_id]," ).append("\n"); 
		query.append("   SYSDATE," ).append("\n"); 
		query.append("   @[ref_eml]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}