/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOMarineTerminalInvoiceCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.03.19 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
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
		query.append("select '' cost_code, '' cntr_sty_code, '' inv_date_type, '' rvis_div, '' vvd_type, '' all_tp, '' fm_tp, '' ts_tp, '' wo_no, '' file_import_yn" ).append("\n"); 
		query.append(",'' reverify_yn, '' del_if_seq, '' del_cntr_seq, '' temp_lgs_cost_cd, '' delete_mode, '' edi_flg, '' cost_calc_flg" ).append("\n"); 
		query.append(", '' tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", '' tml_so_seq" ).append("\n"); 
		query.append(", '' tml_so_dtl_seq" ).append("\n"); 
		query.append(", ''	rvis_tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", ''	rvis_tml_so_seq" ).append("\n"); 
		query.append(", ''	rvis_tml_so_dtl_seq" ).append("\n"); 
		query.append(", ''	rvis_tml_so_rvis_list_seq" ).append("\n"); 
		query.append(", ''	rvis_tml_inv_tp_cd" ).append("\n"); 
		query.append(", ''	rvis_calc_cost_grp_cd" ).append("\n"); 
		query.append(", ''	rvis_tml_rvis_tp_cd" ).append("\n"); 
		query.append(", ''	rvis_lgs_cost_cd" ).append("\n"); 
		query.append(", ''	rvis_ind_flg" ).append("\n"); 
		query.append(", ''	rvis_gate_in_flg" ).append("\n"); 
		query.append(", ''	rvis_gate_out_flg" ).append("\n"); 
		query.append(", ''	rvis_inv_gate_in_dt" ).append("\n"); 
		query.append(", ''	rvis_inv_gate_out_dt" ).append("\n"); 
		query.append(", ''	rvis_cntr_no" ).append("\n"); 
		query.append(", ''	rvis_cntr_tpsz_cd" ).append("\n"); 
		query.append(", ''	rvis_cntr_sty_cd" ).append("\n"); 
		query.append(", ''	rvis_bkg_no" ).append("\n"); 
		query.append(", ''	rvis_vsl_cd" ).append("\n"); 
		query.append(", ''	rvis_skd_voy_no" ).append("\n"); 
		query.append(", ''	rvis_skd_dir_cd" ).append("\n"); 
		query.append(", ''	rvis_cuz_cntr_no" ).append("\n"); 
		query.append(", ''	rvis_rhnd_rsn_cd" ).append("\n"); 
		query.append(", ''	rvis_rmk" ).append("\n"); 
		query.append(", ''	rvis_cre_usr_id" ).append("\n"); 
		query.append(", ''	rvis_cre_dt" ).append("\n"); 
		query.append(", ''	rvis_upd_usr_id" ).append("\n"); 
		query.append(", ''	rvis_upd_dt" ).append("\n"); 
		query.append(", ''	rvis_locl_cre_dt" ).append("\n"); 
		query.append(", ''	rvis_locl_upd_dt" ).append("\n"); 
		query.append(", ''	rvis_tml_so_cntr_list_seq" ).append("\n"); 
		query.append(", ''    flg_yn" ).append("\n"); 
		query.append(", ''	vvd_skd_voy_no2" ).append("\n"); 
		query.append(", ''	vvd2" ).append("\n"); 
		query.append(", ''    revisedVol_sum" ).append("\n"); 
		query.append(", ''	revisedVol_minus" ).append("\n"); 
		query.append(", ''	vvd_vsl_cd" ).append("\n"); 
		query.append(", ''	vvd_skd_voy_no" ).append("\n"); 
		query.append(", ''	vvd_skd_dir_cd" ).append("\n"); 
		query.append(", ''	io_bnd_cd2" ).append("\n"); 
		query.append(", ''	atb_dt2" ).append("\n"); 
		query.append(", ''	tmp_if_amt" ).append("\n"); 
		query.append(", ''	tmp_calc_vol_qty" ).append("\n"); 
		query.append(", ''	tmp_rvis_vol_qty" ).append("\n"); 
		query.append(", ''	tmp_ctrt_rt" ).append("\n"); 
		query.append(", ''	tmp_inv_xch_rt" ).append("\n"); 
		query.append(", ''	tmp_dtl_seq" ).append("\n"); 
		query.append(", ''	tmp_cost_cd" ).append("\n"); 
		query.append(", ''	src_ofc" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}