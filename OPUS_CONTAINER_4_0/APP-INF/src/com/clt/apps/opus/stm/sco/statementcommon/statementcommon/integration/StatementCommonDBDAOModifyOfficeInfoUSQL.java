/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOModifyOfficeInfoUSQL.java
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

public class StatementCommonDBDAOModifyOfficeInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCO_LU_DTL 테이블 수정
	  * </pre>
	  */
	public StatementCommonDBDAOModifyOfficeInfoUSQL(){
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
		params.put("agn_ots_lmt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : StatementCommonDBDAOModifyOfficeInfoUSQL").append("\n"); 
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
		query.append("UPDATE SCO_OFC_INFO" ).append("\n"); 
		query.append("   SET OFC_ENTR_LVL_CD     = @[ofc_entr_lvl_cd]" ).append("\n"); 
		query.append("      ,OFC_INQ_LVL_CD      = @[ofc_inq_lvl_cd]" ).append("\n"); 
		query.append("      ,OFC_BRNC_AGN_TP_CD  = @[ofc_brnc_agn_tp_cd]" ).append("\n"); 
		query.append("      ,BANK_CTRL_CD        = @[bank_ctrl_cd]" ).append("\n"); 
		query.append("      ,BANK_CHG_ACCT_CD    = @[bank_chg_acct_cd]" ).append("\n"); 
		query.append("      ,LOCL_CURR_CD        = @[locl_curr_cd]" ).append("\n"); 
		query.append("      ,AGN_CMB_CD          = @[agn_cmb_cd]" ).append("\n"); 
		query.append("      ,AGN_PFX_CD          = @[agn_pfx_cd]" ).append("\n"); 
		query.append("      ,AGN_CURR_CD         = @[agn_curr_cd]" ).append("\n"); 
		query.append("      ,AGN_OTS_LMT_AMT     = @[agn_ots_lmt_amt]" ).append("\n"); 
		query.append("      ,AGN_OTS_LMT_FLG     = @[agn_ots_lmt_flg]" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,OTS_CATE_CD         = @[ots_cate_cd]" ).append("\n"); 
		query.append("      ,OTS_CD              = @[ots_cd]" ).append("\n"); 
		query.append("      ,OVPAY_TP_CD         = @[ovpay_tp_cd]" ).append("\n"); 
		query.append("      ,MISC_LSS_LMT_AMT    = TO_NUMBER(REPLACE(@[misc_lss_lmt_amt],',',''))" ).append("\n"); 
		query.append("      ,MISC_INCM_LMT_AMT   = TO_NUMBER(REPLACE(@[misc_incm_lmt_amt],',',''))" ).append("\n"); 
		query.append("      ,OTS_IF_FLG          = @[ots_if_flg]" ).append("\n"); 
		query.append("      ,REP_OTS_OFC_CD      = @[rep_ots_ofc_cd]" ).append("\n"); 
		query.append("      ,ENBL_FLG            = @[enbl_flg]" ).append("\n"); 
		query.append("      ,RCT_TP_CD           = @[rct_tp_cd]" ).append("\n"); 
		query.append("      ,RCT_DOC_CD          = @[rct_doc_cd]" ).append("\n"); 
		query.append("      ,RCT_UNAPY_FLG       = @[rct_unapy_flg]" ).append("\n"); 
		query.append("      ,BANK_OFC            = @[bank_ofc]" ).append("\n"); 
		query.append("	  ,RCT_OFC_TIT_NM	   = @[rct_ofc_tit_nm]                          " ).append("\n"); 
		query.append("	  ,RCT_OFC_ADDR		   = @[rct_ofc_addr]                              " ).append("\n"); 
		query.append("	  ,RCT_OFC_TELCM_FAX_NO_CTNT	= @[rct_ofc_telcm_fax_no_ctnt]    " ).append("\n"); 
		query.append("	  ,RCT_TIT_NM		   = @[rct_tit_nm]                                  " ).append("\n"); 
		query.append("	  ,RCT_RMK			   = @[rct_rmk]                                        " ).append("\n"); 
		query.append("	  ,RCT_SPCL_RMK		   = @[rct_spcl_rmk]                              " ).append("\n"); 
		query.append("	  ,RCT_OFC_SPCL_NO_CTNT= @[rct_ofc_spcl_no_ctnt]              " ).append("\n"); 
		query.append("	  ,AR_PRN_TIT_NM	   = @[ar_prn_tit_nm]  " ).append("\n"); 
		query.append("      ,AR_CR_CUST_PRN_CTNT = @[ar_cr_cust_prn_ctnt]" ).append("\n"); 
		query.append("	  ,AR_PRN_CTNT		   = @[ar_prn_ctnt]" ).append("\n"); 
		query.append("      ,OFC_WRTF_TP_CD1     = @[ofc_wrtf_tp_cd1]" ).append("\n"); 
		query.append("      ,OFC_WRTF_TP_CD2     = @[ofc_wrtf_tp_cd2]" ).append("\n"); 
		query.append("      ,OFC_WRTF_TP_CD3     = @[ofc_wrtf_tp_cd3]" ).append("\n"); 
		query.append("      ,OFC_WRTF_TP_CD4     = @[ofc_wrtf_tp_cd4]" ).append("\n"); 
		query.append("      ,OFC_WRTF_TP_CD5     = @[ofc_wrtf_tp_cd5]" ).append("\n"); 
		query.append("	  ,OFC_ADJ_TP_CD1      = @[ofc_adj_tp_cd1]" ).append("\n"); 
		query.append("      ,OFC_ADJ_TP_CD2      = @[ofc_adj_tp_cd2]" ).append("\n"); 
		query.append("      ,OFC_ADJ_TP_CD3      = @[ofc_adj_tp_cd3]" ).append("\n"); 
		query.append("      ,OFC_ADJ_TP_CD4      = @[ofc_adj_tp_cd4]" ).append("\n"); 
		query.append("      ,OFC_ADJ_TP_CD5      = @[ofc_adj_tp_cd5]" ).append("\n"); 
		query.append("      ,UPD_USR_ID          = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT              = SYSDATE" ).append("\n"); 
		query.append("      ,REF_EML             = @[ref_eml]" ).append("\n"); 
		query.append(" WHERE OFC_CD              = @[ofc_cd]" ).append("\n"); 

	}
}