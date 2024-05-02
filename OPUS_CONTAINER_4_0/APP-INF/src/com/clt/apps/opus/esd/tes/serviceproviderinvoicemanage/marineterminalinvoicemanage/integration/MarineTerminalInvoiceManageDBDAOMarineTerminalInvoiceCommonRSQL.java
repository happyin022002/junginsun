/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOMarineTerminalInvoiceCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOMarineTerminalInvoiceCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MarineTerminalInvoiceCommon
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOMarineTerminalInvoiceCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOMarineTerminalInvoiceCommonRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("	''	tmp_if_amt," ).append("\n"); 
		query.append("	''	rvis_calc_cost_grp_cd," ).append("\n"); 
		query.append("	''	temp_lgs_cost_cd," ).append("\n"); 
		query.append("	''	vvd_type," ).append("\n"); 
		query.append("	''	rvis_cntr_tpsz_cd," ).append("\n"); 
		query.append("	''	revisedvol_sum," ).append("\n"); 
		query.append("	''	tmp_cost_cd," ).append("\n"); 
		query.append("	''	rvis_div," ).append("\n"); 
		query.append("	''	fm_tp," ).append("\n"); 
		query.append("	''	rvis_rmk," ).append("\n"); 
		query.append("	''	rvis_tml_so_rvis_list_seq," ).append("\n"); 
		query.append("	''	vvd_skd_dir_cd," ).append("\n"); 
		query.append("	''	vvd_skd_voy_no2," ).append("\n"); 
		query.append("	''	vvd_skd_voy_no," ).append("\n"); 
		query.append("	''	tml_so_dtl_seq," ).append("\n"); 
		query.append("	''	rvis_lgs_cost_cd," ).append("\n"); 
		query.append("	''	tmp_ctrt_rt," ).append("\n"); 
		query.append("	''	reverify_yn," ).append("\n"); 
		query.append("	''	delete_mode," ).append("\n"); 
		query.append("	''	rvis_rhnd_rsn_cd," ).append("\n"); 
		query.append("	''	tmp_inv_xch_rt," ).append("\n"); 
		query.append("	''	cost_calc_flg," ).append("\n"); 
		query.append("	''	inv_date_type," ).append("\n"); 
		query.append("	''	del_if_seq," ).append("\n"); 
		query.append("	''	vvd2," ).append("\n"); 
		query.append("	''	rvis_tml_so_dtl_seq," ).append("\n"); 
		query.append("	''	rvis_tml_so_seq," ).append("\n"); 
		query.append("	''	rvis_tml_so_ofc_cty_cd," ).append("\n"); 
		query.append("	''	ts_tp," ).append("\n"); 
		query.append("	''	rvis_locl_cre_dt," ).append("\n"); 
		query.append("	''	rvis_cntr_no," ).append("\n"); 
		query.append("	''	tml_so_seq," ).append("\n"); 
		query.append("	''	rvis_gate_in_flg," ).append("\n"); 
		query.append("	''	rvis_cre_dt," ).append("\n"); 
		query.append("	''	revisedvol_minus," ).append("\n"); 
		query.append("	''	tmp_dtl_seq," ).append("\n"); 
		query.append("	''	all_tp," ).append("\n"); 
		query.append("	''	cost_code," ).append("\n"); 
		query.append("	''	rvis_cre_usr_id," ).append("\n"); 
		query.append("	''	file_import_yn," ).append("\n"); 
		query.append("	''	rvis_ind_flg," ).append("\n"); 
		query.append("	''	vvd_vsl_cd," ).append("\n"); 
		query.append("	''	cntr_sty_code," ).append("\n"); 
		query.append("	''	rvis_locl_upd_dt," ).append("\n"); 
		query.append("	''	rvis_upd_dt," ).append("\n"); 
		query.append("	''	rvis_tml_inv_tp_cd," ).append("\n"); 
		query.append("	''	del_cntr_seq," ).append("\n"); 
		query.append("	''	flg_yn," ).append("\n"); 
		query.append("	''	tmp_calc_vol_qty," ).append("\n"); 
		query.append("	''	wo_no," ).append("\n"); 
		query.append("	''	rvis_bkg_no," ).append("\n"); 
		query.append("	''	rvis_cntr_sty_cd," ).append("\n"); 
		query.append("	''	rvis_vsl_cd," ).append("\n"); 
		query.append("	''	tmp_rvis_vol_qty," ).append("\n"); 
		query.append("	''	src_ofc," ).append("\n"); 
		query.append("	''	io_bnd_cd2," ).append("\n"); 
		query.append("	''	rvis_inv_gate_out_dt," ).append("\n"); 
		query.append("	''	rvis_gate_out_flg," ).append("\n"); 
		query.append("	''	rvis_skd_voy_no," ).append("\n"); 
		query.append("	''	rvis_tml_rvis_tp_cd," ).append("\n"); 
		query.append("	''	rvis_cuz_cntr_no," ).append("\n"); 
		query.append("	''	rvis_upd_usr_id," ).append("\n"); 
		query.append("	''	rvis_tml_so_cntr_list_seq," ).append("\n"); 
		query.append("	''	rvis_inv_gate_in_dt," ).append("\n"); 
		query.append("	''	atb_dt2," ).append("\n"); 
		query.append("	''	rvis_skd_dir_cd," ).append("\n"); 
		query.append("	''	tml_so_ofc_cty_cd," ).append("\n"); 
		query.append("	''  rvis_ins_flg" ).append("\n"); 
		query.append("from dual	                  " ).append("\n"); 

	}
}