/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmOrganizationDBDAOAddMdmOrganizationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmOrganizationDBDAOAddMdmOrganizationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for insert mdm_organization
	  * </pre>
	  */
	public ReceiveQueueMdmOrganizationDBDAOAddMdmOrganizationCSQL(){
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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_url",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_agn_stl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rep_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("so_if_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_ofc_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_krn_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_sls_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gl_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("opn_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bfr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmOrganizationDBDAOAddMdmOrganizationCSQL").append("\n"); 
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
		query.append("INSERT INTO mdm_organization (" ).append("\n"); 
		query.append("ofc_cd" ).append("\n"); 
		query.append(",ofc_cmmc_cd" ).append("\n"); 
		query.append(",ofc_eng_nm" ).append("\n"); 
		query.append(",ofc_krn_nm" ).append("\n"); 
		query.append(",ofc_addr" ).append("\n"); 
		query.append(",ofc_zip_cd" ).append("\n"); 
		query.append(",ofc_knd_cd" ).append("\n"); 
		query.append(",agn_knd_cd" ).append("\n"); 
		query.append(",ofc_tp_cd" ).append("\n"); 
		query.append(",ofc_pson_knt" ).append("\n"); 
		query.append(",ofc_rmk" ).append("\n"); 
		query.append(",loc_cd" ).append("\n"); 
		query.append(",prnt_ofc_cd" ).append("\n"); 
		query.append(",prc_ofc_cd" ).append("\n"); 
		query.append(",sls_ofc_div_cd" ).append("\n"); 
		query.append(",intl_phn_no" ).append("\n"); 
		query.append(",ofc_phn_no" ).append("\n"); 
		query.append(",intl_fax_no" ).append("\n"); 
		query.append(",ofc_fax_no" ).append("\n"); 
		query.append(",fax_ip" ).append("\n"); 
		query.append(",ofc_url" ).append("\n"); 
		query.append(",opn_dt" ).append("\n"); 
		query.append(",clz_dt" ).append("\n"); 
		query.append(",sls_ofc_use_flg" ).append("\n"); 
		query.append(",ofc_sls_delt_flg" ).append("\n"); 
		query.append(",doc_rcvr_hide_flg" ).append("\n"); 
		query.append(",ofc_rfa_sc_use_flg" ).append("\n"); 
		query.append(",finc_hide_flg" ).append("\n"); 
		query.append(",finc_rgn_cd" ).append("\n"); 
		query.append(",ar_curr_cd" ).append("\n"); 
		query.append(",ar_ctr_cd" ).append("\n"); 
		query.append(",ar_ofc_cd" ).append("\n"); 
		query.append(",ar_hd_qtr_ofc_cd" ).append("\n"); 
		query.append(",ar_ctrl_ofc_cd" ).append("\n"); 
		query.append(",ib_cr_term_dys" ).append("\n"); 
		query.append(",ob_cr_term_dys" ).append("\n"); 
		query.append(",sub_agn_flg" ).append("\n"); 
		query.append(",rep_cust_seq" ).append("\n"); 
		query.append(",inv_pfx_cd" ).append("\n"); 
		query.append(",usa_brk_brnc_rqst_ctrl_ofc_cd" ).append("\n"); 
		query.append(",asa_cr_term_dys" ).append("\n"); 
		query.append(",fx_curr_rt" ).append("\n"); 
		query.append(",ofc_tax_id" ).append("\n"); 
		query.append(",bil_curr_cd" ).append("\n"); 
		query.append(",vndr_cnt_cd" ).append("\n"); 
		query.append(",vndr_seq" ).append("\n"); 
		query.append(",ap_ofc_cd" ).append("\n"); 
		query.append(",ap_ctrl_ofc_cd" ).append("\n"); 
		query.append(",ap_ho_acct_cd" ).append("\n"); 
		query.append(",ap_euro_curr_use_flg" ).append("\n"); 
		query.append(",so_if_cd" ).append("\n"); 
		query.append(",comm_if_ind_cd" ).append("\n"); 
		query.append(",finc_psdo_ofc_flg" ).append("\n"); 
		query.append(",bfr_ofc_cd" ).append("\n"); 
		query.append(",modi_ofc_cd" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append(",delt_flg" ).append("\n"); 
		query.append(",rep_cust_cnt_cd" ).append("\n"); 
		query.append(",ap_ctr_cd" ).append("\n"); 
		query.append(",ofc_rep_eml" ).append("\n"); 
		query.append(",bkg_svr_srch_rout_cd" ).append("\n"); 
		query.append(",subs_co_flg" ).append("\n"); 
		query.append(",gl_ctr_cd" ).append("\n"); 
		query.append(",eai_evnt_dt" ).append("\n"); 
		query.append(",ofc_locl_lang_addr" ).append("\n"); 
		query.append(",ar_agn_stl_cd" ).append("\n"); 
		query.append(",eai_if_id" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[ofc_cd]									--	 ofc_cd" ).append("\n"); 
		query.append(", @[ofc_cmmc_cd]                            --  ,ofc_cmmc_cd" ).append("\n"); 
		query.append(", @[ofc_eng_nm]                             --  ,ofc_eng_nm" ).append("\n"); 
		query.append(", @[ofc_krn_nm]                             --  ,ofc_krn_nm" ).append("\n"); 
		query.append(", @[ofc_addr]                               --  ,ofc_addr" ).append("\n"); 
		query.append(", @[ofc_zip_cd]                             --  ,ofc_zip_cd" ).append("\n"); 
		query.append(", @[ofc_knd_cd]                             --  ,ofc_knd_cd" ).append("\n"); 
		query.append(", @[agn_knd_cd]                             --  ,agn_knd_cd" ).append("\n"); 
		query.append(", @[ofc_tp_cd]                              --  ,ofc_tp_cd" ).append("\n"); 
		query.append(", @[ofc_pson_knt]                           --  ,ofc_pson_knt" ).append("\n"); 
		query.append(", @[ofc_rmk]                                --  ,ofc_rmk" ).append("\n"); 
		query.append(", @[loc_cd]                                 --  ,loc_cd" ).append("\n"); 
		query.append(", @[prnt_ofc_cd]                            --  ,prnt_ofc_cd" ).append("\n"); 
		query.append(", @[prc_ofc_cd]                             --  ,prc_ofc_cd" ).append("\n"); 
		query.append(", @[sls_ofc_div_cd]                         --  ,sls_ofc_div_cd" ).append("\n"); 
		query.append(", @[intl_phn_no]                            --  ,intl_phn_no" ).append("\n"); 
		query.append(", @[ofc_phn_no]                             --  ,ofc_phn_no" ).append("\n"); 
		query.append(", @[intl_fax_no]                            --  ,intl_fax_no" ).append("\n"); 
		query.append(", @[ofc_fax_no]                             --  ,ofc_fax_no" ).append("\n"); 
		query.append(", @[fax_ip]                                 --  ,fax_ip" ).append("\n"); 
		query.append(", @[ofc_url]	                            --  ,ofc_url" ).append("\n"); 
		query.append(", to_date(@[opn_dt],'yyyymmddhh24miss')     --  ,opn_dt" ).append("\n"); 
		query.append(", to_date(@[clz_dt],'yyyymmddhh24miss')     --  ,clz_dt" ).append("\n"); 
		query.append(", @[sls_ofc_use_flg]                        --  ,sls_ofc_use_flg" ).append("\n"); 
		query.append(", @[ofc_sls_delt_flg]                       --  ,ofc_sls_delt_flg" ).append("\n"); 
		query.append(", @[doc_rcvr_hide_flg]                      --  ,doc_rcvr_hide_flg" ).append("\n"); 
		query.append(", @[ofc_rfa_sc_use_flg]                     --  ,ofc_rfa_sc_use_flg" ).append("\n"); 
		query.append(", @[finc_hide_flg]                          --  ,finc_hide_flg" ).append("\n"); 
		query.append(", @[finc_rgn_cd]                            --  ,finc_rgn_cd" ).append("\n"); 
		query.append(", @[ar_curr_cd]                             --  ,ar_curr_cd" ).append("\n"); 
		query.append(", @[ar_ctr_cd]                              --  ,ar_ctr_cd" ).append("\n"); 
		query.append(", @[ar_ofc_cd]                              --  ,ar_ofc_cd" ).append("\n"); 
		query.append(", @[ar_hd_qtr_ofc_cd]                       --  ,ar_hd_qtr_ofc_cd" ).append("\n"); 
		query.append(", @[ar_ctrl_ofc_cd]                         --  ,ar_ctrl_ofc_cd" ).append("\n"); 
		query.append(", @[ib_cr_term_dys]              			--  ,ib_cr_term_dys" ).append("\n"); 
		query.append(", @[ob_cr_term_dys]				            --  ,ob_cr_term_dys" ).append("\n"); 
		query.append(", @[sub_agn_flg]                            --  ,sub_agn_flg" ).append("\n"); 
		query.append(", @[rep_cust_seq]			                --  ,rep_cust_seq" ).append("\n"); 
		query.append(", @[inv_pfx_cd]                             --  ,inv_pfx_cd" ).append("\n"); 
		query.append(", @[usa_brk_brnc_rqst_ctrl_ofc_cd]          --  ,usa_brk_brnc_rqst_ctrl_ofc_cd" ).append("\n"); 
		query.append(", @[asa_cr_term_dys]			            --  ,asa_cr_term_dys" ).append("\n"); 
		query.append(", @[fx_curr_rt]			                  	--  ,fx_curr_rt" ).append("\n"); 
		query.append(", @[ofc_tax_id]                             --  ,ofc_tax_id" ).append("\n"); 
		query.append(", @[bil_curr_cd]                            --  ,bil_curr_cd" ).append("\n"); 
		query.append(", @[vndr_cnt_cd]                            --  ,vndr_cnt_cd" ).append("\n"); 
		query.append(", @[vndr_seq]			                    --  ,vndr_seq" ).append("\n"); 
		query.append(", @[ap_ofc_cd]                              --  ,ap_ofc_cd" ).append("\n"); 
		query.append(", @[ap_ctrl_ofc_cd]                         --  ,ap_ctrl_ofc_cd" ).append("\n"); 
		query.append(", @[ap_ho_acct_cd]                          --  ,ap_ho_acct_cd" ).append("\n"); 
		query.append(", @[ap_euro_curr_use_flg]                   --  ,ap_euro_curr_use_flg" ).append("\n"); 
		query.append(", @[so_if_cd]                               --  ,so_if_cd" ).append("\n"); 
		query.append(", @[comm_if_ind_cd]                         --  ,comm_if_ind_cd" ).append("\n"); 
		query.append(", @[finc_psdo_ofc_flg]	                    --  ,finc_psdo_ofc_flg" ).append("\n"); 
		query.append(", @[bfr_ofc_cd]                             --  ,bfr_ofc_cd" ).append("\n"); 
		query.append(", @[modi_ofc_cd]                            --  ,modi_ofc_cd" ).append("\n"); 
		query.append(", @[cre_usr_id]                             --  ,cre_usr_id" ).append("\n"); 
		query.append(", to_date(@[cre_dt],'yyyymmddhh24miss')     --  ,cre_dt" ).append("\n"); 
		query.append(", @[upd_usr_id]                             --  ,upd_usr_id" ).append("\n"); 
		query.append(", to_date(@[upd_dt],'yyyymmddhh24miss')     --  ,upd_dt" ).append("\n"); 
		query.append(", @[delt_flg]                               --  ,delt_flg" ).append("\n"); 
		query.append(", @[rep_cust_cnt_cd]                        --  ,rep_cust_cnt_cd" ).append("\n"); 
		query.append(", @[ap_ctr_cd]                              --  ,ap_ctr_cd" ).append("\n"); 
		query.append(", @[ofc_rep_eml]                            --  ,ofc_rep_eml" ).append("\n"); 
		query.append(", @[bkg_svr_srch_rout_cd]                   --  ,bkg_svr_srch_rout_cd" ).append("\n"); 
		query.append(", @[subs_co_flg]                            --  ,subs_co_flg" ).append("\n"); 
		query.append(", @[gl_ctr_cd]                              --  ,gl_ctr_cd" ).append("\n"); 
		query.append(", to_date(@[eai_evnt_dt],'yyyymmddhh24miss')--  ,eai_evnt_dt" ).append("\n"); 
		query.append(", @[ofc_locl_lang_addr]                     --  ,ofc_locl_lang_addr" ).append("\n"); 
		query.append(", @[ar_agn_stl_cd]							--  ,ar_agn_stl_cd" ).append("\n"); 
		query.append(", @[eai_if_id]                              --  ,eai_if_id" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}