/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MakeVODAOUncollectedCargoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAOUncollectedCargoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Uncollected Cargo 조회 Data 
	  * </pre>
	  */
	public MakeVODAOUncollectedCargoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : MakeVODAOUncollectedCargoRSQL").append("\n"); 
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
		query.append("select 	'' uc_cs_no" ).append("\n"); 
		query.append("		,'' bl_no" ).append("\n"); 
		query.append("		,'' uc_seq" ).append("\n"); 
		query.append("		, '' hndl_rhq_cd" ).append("\n"); 
		query.append("		, '' hndl_brnc_cd" ).append("\n"); 
		query.append("		, '' hndl_hdlr_usr_id" ).append("\n"); 
		query.append("		, '' hndl_upd_id" ).append("\n"); 
		query.append("		, '' hndl_upd_dt" ).append("\n"); 
		query.append("		, '' kntr_rhq_cd" ).append("\n"); 
		query.append("		, '' kntr_brnc_cd" ).append("\n"); 
		query.append("		, '' kntr_hdlr_usr_id" ).append("\n"); 
		query.append("		, '' kntr_upd_id" ).append("\n"); 
		query.append("		, '' kntr_upd_dt" ).append("\n"); 
		query.append("		, '' uc_sts_cd" ).append("\n"); 
		query.append("		, '' uc_ropn_flg" ).append("\n"); 
		query.append("		, '' uc_ofc_trns_flg" ).append("\n"); 
		query.append("		, '' cnee_uc_dt" ).append("\n"); 
		query.append("		, '' uc_clz_dt" ).append("\n"); 
		query.append("		, '' uc_dys" ).append("\n"); 
		query.append("		, '' uc_dchg_dys" ).append("\n"); 
		query.append("		, '' ctrt_ttl_vol_ctnt" ).append("\n"); 
		query.append("		, '' uc_ctrt_ttl_vol" ).append("\n"); 
		query.append("		, '' cntr_list" ).append("\n"); 
		query.append("		, '' uc_ctrt_rmk" ).append("\n"); 
		query.append("		, '' uc_rsn_cd" ).append("\n"); 
		query.append("		, '' uc_rsn_desc" ).append("\n"); 
		query.append("		, '' uc_inv_amt" ).append("\n"); 
		query.append("		, '' uc_inv_curr_cd" ).append("\n"); 
		query.append("		, '' uc_inv_xch_rt" ).append("\n"); 
		query.append("		, '' uc_inv_usd_amt" ).append("\n"); 
		query.append("		, '' uc_crnt_amt" ).append("\n"); 
		query.append("		, '' uc_crnt_curr_cd" ).append("\n"); 
		query.append("		, '' uc_crnt_xch_rt" ).append("\n"); 
		query.append("		, '' uc_crnt_usd_amt" ).append("\n"); 
		query.append("		, '' uc_obl_hld_cd" ).append("\n"); 
		query.append("		, '' uc_piclb_cd" ).append("\n"); 
		query.append("		, '' uc_piclb_ref_no" ).append("\n"); 
		query.append("		, '' uc_do_iss_dt" ).append("\n"); 
		query.append("		, '' uc_disp_opt_cd" ).append("\n"); 
		query.append("		, '' aban_ltr_shpr_dt" ).append("\n"); 
		query.append("		, '' aban_ltr_cnee_dt" ).append("\n"); 
		query.append("		, '' uc_cgo_loc_nm" ).append("\n"); 
		query.append("		, '' uc_cgo_n1st_ntc_dt" ).append("\n"); 
		query.append("		, '' uc_cgo_n2nd_ntc_dt" ).append("\n"); 
		query.append("		, '' uc_cgo_n3rd_ntc_dt" ).append("\n"); 
		query.append("		, '' uc_cgo_fnl_ntc_dt" ).append("\n"); 
		query.append("		, '' uc_cgo_ntc_rmk" ).append("\n"); 
		query.append("		, '' ots_oft_amt" ).append("\n"); 
		query.append("		, '' ots_otr_amt" ).append("\n"); 
		query.append("		, '' ots_dmdt_amt" ).append("\n"); 
		query.append("		, '' ots_dmdt_dt" ).append("\n"); 
		query.append("		, '' ots_sto_amt" ).append("\n"); 
		query.append("		, '' ots_sto_dt" ).append("\n"); 
		query.append("		, '' ots_otr_cost_amt" ).append("\n"); 
		query.append("		, '' ots_otr_cost_dt" ).append("\n"); 
		query.append("		, '' ots_rcvr_amt" ).append("\n"); 
		query.append("		, '' ots_insur_cvr_amt" ).append("\n"); 
		query.append("		, '' ots_rmk" ).append("\n"); 
		query.append("		, '' fact_fnd_act_desc" ).append("\n"); 
		query.append("		, '' hndl_ofc_opin_desc" ).append("\n"); 
		query.append("		, '' kntr_ofc_opin_desc" ).append("\n"); 
		query.append("		, '' cre_usr_id" ).append("\n"); 
		query.append("		, '' cre_dt" ).append("\n"); 
		query.append("		, '' upd_usr_id" ).append("\n"); 
		query.append("		, '' upd_dt" ).append("\n"); 
		query.append("		, '' vvd" ).append("\n"); 
		query.append("		, '' vsl_nm" ).append("\n"); 
		query.append("		, '' por" ).append("\n"); 
		query.append("		, '' por_dt" ).append("\n"); 
		query.append("		, '' pol" ).append("\n"); 
		query.append("		, '' pod" ).append("\n"); 
		query.append("		, '' del_cd" ).append("\n"); 
		query.append("		, '' del_dt" ).append("\n"); 
		query.append("		, '' pol_etd" ).append("\n"); 
		query.append("		, '' pod_eta" ).append("\n"); 
		query.append("		, '' shpr" ).append("\n"); 
		query.append("		, '' cnee" ).append("\n"); 
		query.append("		, '' noti" ).append("\n"); 
		query.append("		, '' frwd" ).append("\n"); 
		query.append("		, '' cmdt" ).append("\n"); 
		query.append("		, '' prepaid" ).append("\n"); 
		query.append("		, '' collect" ).append("\n"); 
		query.append("		, '' today" ).append("\n"); 
		query.append("		, '' file_cnt" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}