/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TESCommonDBDAOTesCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOTesCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES Common
	  * </pre>
	  */
	public TESCommonDBDAOTesCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.vo").append("\n"); 
		query.append("FileName : TESCommonDBDAOTesCommonRSQL").append("\n"); 
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
		query.append("-- mode_ 뒤에 _(언더바) 제거되야함" ).append("\n"); 
		query.append("		'' mode_" ).append("\n"); 
		query.append("		, '' coid" ).append("\n"); 
		query.append("		, '' vvd " ).append("\n"); 
		query.append("		, '' idx " ).append("\n"); 
		query.append("		, '' functionName " ).append("\n"); 
		query.append("		, '' def " ).append("\n"); 
		query.append("		, '' f_cmd " ).append("\n"); 
		query.append("		, '' exe_perf_log_seq" ).append("\n"); 
		query.append("		, '' ofc_cd" ).append("\n"); 
		query.append("		, '' usr_id" ).append("\n"); 
		query.append("		, '' jb_tp_cd" ).append("\n"); 
		query.append("		, '' pgm_url" ).append("\n"); 
		query.append("		, '' row_cnt" ).append("\n"); 
		query.append("		, '' param_val" ).append("\n"); 
		query.append("		, '' com_list_yn" ).append("\n"); 
		query.append("		, '' inv_ofc_cd " ).append("\n"); 
		query.append("		, '' calc_cost_grp_cd " ).append("\n"); 
		query.append("		, '' param_lgs_cost_cd " ).append("\n"); 
		query.append("		, '' from_date " ).append("\n"); 
		query.append("		, '' to_date " ).append("\n"); 
		query.append("		, '' atb_dt " ).append("\n"); 
		query.append("		, '' min_wrk_dt " ).append("\n"); 
		query.append("		, '' max_wrk_dt " ).append("\n"); 
		query.append("		, '' ex " ).append("\n"); 
		query.append("		, '' st " ).append("\n"); 
		query.append("		, '' yn " ).append("\n"); 
		query.append("		, '' n3pty_bil_cs_cd " ).append("\n"); 
		query.append("		, '' curr_list " ).append("\n"); 
		query.append("		, '' curr_date " ).append("\n"); 
		query.append("		, '' cntr_tpsz_cd" ).append("\n"); 
		query.append("		, '' mt_a_lgs_cost_cd" ).append("\n"); 
		query.append("		, '' on_a_lgs_cost_cd" ).append("\n"); 
		query.append("		, '' ot_a_lgs_cost_cd" ).append("\n"); 
		query.append("		, '' os_a_lgs_cost_cd" ).append("\n"); 
		query.append("		, '' st_a_lgs_cost_cd" ).append("\n"); 
		query.append("		, '' carr_cd" ).append("\n"); 
		query.append("		, '' is_existing_ofc_cd" ).append("\n"); 
		query.append("		, '' is_valid_yd_cd" ).append("\n"); 
		query.append("		, '' delt_flg" ).append("\n"); 
		query.append("		, '' vndr_seq_existing" ).append("\n"); 
		query.append("		, '' vndr_lgl_eng_nm" ).append("\n"); 
		query.append("		, '' yd_chr_inv_tp_cd" ).append("\n"); 
		query.append("		, '' yd_fcty_tp_cfs_flg" ).append("\n"); 
		query.append("		, '' yd_fcty_tp_rail_rmp_flg" ).append("\n"); 
		query.append("		, '' yd_oshp_cd" ).append("\n"); 
		query.append("		, '' real_file_name" ).append("\n"); 
		query.append("		, '' saved_file_name" ).append("\n"); 
		query.append("		, '' saved_path" ).append("\n"); 
		query.append("		, '' tmp_mgst_no" ).append("\n"); 
		query.append("		, '' csr_status" ).append("\n"); 
		query.append("		, '' act_tp" ).append("\n"); 
		query.append("		, '' no_ofc_cd" ).append("\n"); 
		query.append("		, '' cre_ofc_cd" ).append("\n"); 
		query.append("		, '' no_yd_cd" ).append("\n"); 
		query.append("		, '' inv_rgst_no" ).append("\n"); 
		query.append("		, '' inv_rgst_seq " ).append("\n"); 
		query.append("		, '' fm_prd_dt                          																											    " ).append("\n"); 
		query.append("		, '' to_prd_dt                          																											    " ).append("\n"); 
		query.append("		, '' cost_cd_inv_tp_cd                  																											    " ).append("\n"); 
		query.append("		, '' iss_dt" ).append("\n"); 
		query.append("		, '' cntr_no" ).append("\n"); 
		query.append("		, '' eq_no" ).append("\n"); 
		query.append("		, '' agmt_ftr_inv_tp_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}