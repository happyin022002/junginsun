/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : OrganizationDBDAOAddOfcCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.organization.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OrganizationDBDAOAddOfcCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 Organization 정보를 등록한다.
	  * </pre>
	  */
	public OrganizationDBDAOAddOfcCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_cr_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_agn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cmmc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("doc_rcvr_hide_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_url",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_ip",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_svr_srch_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_locl_lang_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("team_mgr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ho_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fx_curr_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_rfa_sc_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_if_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_hide_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_brk_brnc_rqst_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_pson_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_if_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("team_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_cr_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subs_co_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_sls_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cr_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_psdo_ofc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_rep_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_euro_curr_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.organization.integration").append("\n"); 
		query.append("FileName : OrganizationDBDAOAddOfcCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_ORGANIZATION(" ).append("\n"); 
		query.append("             OFC_CD" ).append("\n"); 
		query.append("            ,OFC_ENG_NM" ).append("\n"); 
		query.append("            ,OFC_ADDR" ).append("\n"); 
		query.append("            ,OFC_ZIP_CD" ).append("\n"); 
		query.append("            ,OFC_KND_CD" ).append("\n"); 
		query.append("            ,AGN_KND_CD" ).append("\n"); 
		query.append("			,VNDR_CNT_CD" ).append("\n"); 
		query.append("            ,VNDR_SEQ" ).append("\n"); 
		query.append("            ,INTL_PHN_NO" ).append("\n"); 
		query.append("            ,OFC_PHN_NO" ).append("\n"); 
		query.append("            ,INTL_FAX_NO" ).append("\n"); 
		query.append("            ,OFC_FAX_NO" ).append("\n"); 
		query.append("            ,OFC_PSON_KNT" ).append("\n"); 
		query.append("            ,OFC_RMK" ).append("\n"); 
		query.append("            ,LOC_CD" ).append("\n"); 
		query.append("            ,BIL_CURR_CD" ).append("\n"); 
		query.append("            ,AR_CURR_CD" ).append("\n"); 
		query.append("            ,AR_CTR_CD" ).append("\n"); 
		query.append("            ,PRNT_OFC_CD" ).append("\n"); 
		query.append("            ,OPN_DT" ).append("\n"); 
		query.append("            ,CLZ_DT" ).append("\n"); 
		query.append("            ,FINC_RGN_CD" ).append("\n"); 
		query.append("            ,AR_OFC_CD" ).append("\n"); 
		query.append("            ,AR_CTRL_OFC_CD" ).append("\n"); 
		query.append("            ,AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("            ,IB_CR_TERM_DYS" ).append("\n"); 
		query.append("            ,OB_CR_TERM_DYS" ).append("\n"); 
		query.append("            ,SUB_AGN_FLG" ).append("\n"); 
		query.append("            ,REP_CUST_CNT_CD" ).append("\n"); 
		query.append("            ,REP_CUST_SEQ" ).append("\n"); 
		query.append("            ,INV_PFX_CD" ).append("\n"); 
		query.append("            ,AP_OFC_CD" ).append("\n"); 
		query.append("            ,AP_CTRL_OFC_CD" ).append("\n"); 
		query.append("            ,AP_HO_ACCT_CD" ).append("\n"); 
		query.append("            ,AP_CTR_CD" ).append("\n"); 
		query.append("            ,FX_CURR_RT" ).append("\n"); 
		query.append("            ,AP_EURO_CURR_USE_FLG" ).append("\n"); 
		query.append("            ,USA_BRK_BRNC_RQST_CTRL_OFC_CD" ).append("\n"); 
		query.append("            ,ASA_CR_TERM_DYS" ).append("\n"); 
		query.append("            ,SO_IF_CD" ).append("\n"); 
		query.append("            ,SLS_OFC_USE_FLG" ).append("\n"); 
		query.append("            ,SLS_OFC_DIV_CD" ).append("\n"); 
		query.append("            ,OFC_TAX_ID" ).append("\n"); 
		query.append("            ,OFC_RFA_SC_USE_FLG" ).append("\n"); 
		query.append("            ,FAX_IP" ).append("\n"); 
		query.append("            ,BFR_OFC_CD" ).append("\n"); 
		query.append("            ,MODI_OFC_CD" ).append("\n"); 
		query.append("            ,OFC_CMMC_CD" ).append("\n"); 
		query.append("            ,OFC_TP_CD" ).append("\n"); 
		query.append("            ,PRC_OFC_CD" ).append("\n"); 
		query.append("            ,OFC_URL" ).append("\n"); 
		query.append("            ,OFC_REP_EML" ).append("\n"); 
		query.append("            ,BKG_SVR_SRCH_ROUT_CD" ).append("\n"); 
		query.append("            ,OFC_SLS_DELT_FLG" ).append("\n"); 
		query.append("            ,DOC_RCVR_HIDE_FLG" ).append("\n"); 
		query.append("            ,FINC_HIDE_FLG" ).append("\n"); 
		query.append("            ,FINC_PSDO_OFC_FLG" ).append("\n"); 
		query.append("            ,SUBS_CO_FLG" ).append("\n"); 
		query.append("            ,GL_CTR_CD" ).append("\n"); 
		query.append("            ,TEAM_MGR_NM" ).append("\n"); 
		query.append("            ,TEAM_FAX_NO" ).append("\n"); 
		query.append("            ,OFC_LOCL_LANG_ADDR" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            ,DELT_FLG" ).append("\n"); 
		query.append("            ,EAI_EVNT_DT" ).append("\n"); 
		query.append("            ,EAI_IF_ID" ).append("\n"); 
		query.append("			,COMM_IF_IND_CD" ).append("\n"); 
		query.append("           )                     " ).append("\n"); 
		query.append("    VALUES(  @[ofc_cd]" ).append("\n"); 
		query.append("            ,@[ofc_eng_nm]" ).append("\n"); 
		query.append("            ,@[ofc_addr]" ).append("\n"); 
		query.append("            ,@[ofc_zip_cd]" ).append("\n"); 
		query.append("            ,@[ofc_knd_cd]" ).append("\n"); 
		query.append("            ,@[agn_knd_cd]" ).append("\n"); 
		query.append("			,@[vndr_cnt_cd]" ).append("\n"); 
		query.append("            ,@[vndr_cd_seq]" ).append("\n"); 
		query.append("            ,@[intl_phn_no]" ).append("\n"); 
		query.append("            ,@[ofc_phn_no]" ).append("\n"); 
		query.append("            ,@[intl_fax_no]" ).append("\n"); 
		query.append("            ,@[ofc_fax_no]" ).append("\n"); 
		query.append("            ,@[ofc_pson_knt]" ).append("\n"); 
		query.append("            ,@[ofc_rmk]" ).append("\n"); 
		query.append("            ,@[loc_cd]" ).append("\n"); 
		query.append("            ,@[bil_curr_cd]" ).append("\n"); 
		query.append("            ,@[ar_curr_cd]" ).append("\n"); 
		query.append("            ,@[ar_ctr_cd]" ).append("\n"); 
		query.append("            ,@[prnt_ofc_cd]" ).append("\n"); 
		query.append("            ,TO_DATE(@[opn_dt],'YYYY/MM/DD')" ).append("\n"); 
		query.append("            ,TO_DATE(@[clz_dt],'YYYY/MM/DD')" ).append("\n"); 
		query.append("            ,@[finc_rgn_cd]" ).append("\n"); 
		query.append("            ,@[ar_ofc_cd]" ).append("\n"); 
		query.append("            ,@[ar_ctrl_ofc_cd]" ).append("\n"); 
		query.append("            ,@[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("            ,@[ib_cr_term_dys]" ).append("\n"); 
		query.append("            ,@[ob_cr_term_dys]" ).append("\n"); 
		query.append("            ,@[sub_agn_flg]" ).append("\n"); 
		query.append("            ,SUBSTR(@[rep_cust_cd],1,2)" ).append("\n"); 
		query.append("            ,TRIM(SUBSTR(@[rep_cust_cd],3,6))" ).append("\n"); 
		query.append("            ,@[inv_pfx_cd]" ).append("\n"); 
		query.append("            ,@[ap_ofc_cd]" ).append("\n"); 
		query.append("            ,@[ap_ctrl_ofc_cd]" ).append("\n"); 
		query.append("            ,@[ap_ho_acct_cd]" ).append("\n"); 
		query.append("            ,@[ap_ctr_cd]" ).append("\n"); 
		query.append("            ,@[fx_curr_rt]" ).append("\n"); 
		query.append("            ,@[ap_euro_curr_use_flg]" ).append("\n"); 
		query.append("            ,@[usa_brk_brnc_rqst_ctrl_ofc_cd]" ).append("\n"); 
		query.append("            ,@[asa_cr_term_dys]" ).append("\n"); 
		query.append("            ,@[so_if_cd]" ).append("\n"); 
		query.append("            ,@[sls_ofc_use_flg]" ).append("\n"); 
		query.append("            ,@[sls_ofc_div_cd]" ).append("\n"); 
		query.append("            ,@[ofc_tax_id]" ).append("\n"); 
		query.append("            ,@[ofc_rfa_sc_use_flg]" ).append("\n"); 
		query.append("            ,@[fax_ip]" ).append("\n"); 
		query.append("            ,@[bfr_ofc_cd]" ).append("\n"); 
		query.append("            ,@[modi_ofc_cd]" ).append("\n"); 
		query.append("            ,@[ofc_cmmc_cd]" ).append("\n"); 
		query.append("            ,@[ofc_tp_cd]" ).append("\n"); 
		query.append("            ,@[prc_ofc_cd]" ).append("\n"); 
		query.append("            ,@[ofc_url]" ).append("\n"); 
		query.append("            ,@[ofc_rep_eml]" ).append("\n"); 
		query.append("            ,@[bkg_svr_srch_rout_cd]" ).append("\n"); 
		query.append("            ,@[ofc_sls_delt_flg]" ).append("\n"); 
		query.append("            ,@[doc_rcvr_hide_flg]" ).append("\n"); 
		query.append("            ,@[finc_hide_flg]" ).append("\n"); 
		query.append("            ,@[finc_psdo_ofc_flg]" ).append("\n"); 
		query.append("            ,@[subs_co_flg]" ).append("\n"); 
		query.append("            ,@[gl_ctr_cd]" ).append("\n"); 
		query.append("            ,@[team_mgr_nm]" ).append("\n"); 
		query.append("            ,@[team_fax_no]" ).append("\n"); 
		query.append("            ,@[ofc_locl_lang_addr]" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[delt_flg]" ).append("\n"); 
		query.append("            ,@[eai_evnt_dt]" ).append("\n"); 
		query.append("            ,@[eai_if_id]" ).append("\n"); 
		query.append("			,@[comm_if_ind_cd]" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}