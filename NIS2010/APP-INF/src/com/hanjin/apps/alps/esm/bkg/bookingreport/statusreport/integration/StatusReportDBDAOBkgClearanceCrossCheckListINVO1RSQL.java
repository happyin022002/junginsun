/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StatusReportDBDAOBkgClearanceCrossCheckListINVO1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOBkgClearanceCrossCheckListINVO1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOBkgClearanceCrossCheckListINVO1RSQL
	  * </pre>
	  */
	public StatusReportDBDAOBkgClearanceCrossCheckListINVO1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOBkgClearanceCrossCheckListINVO1RSQL").append("\n"); 
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
		query.append("' ' dense_rank," ).append("\n"); 
		query.append("' ' dense_rank2," ).append("\n"); 
		query.append("' ' aes_yn," ).append("\n"); 
		query.append("' ' pkg," ).append("\n"); 
		query.append("' ' pod_cd," ).append("\n"); 
		query.append("' ' qty_bkg," ).append("\n"); 
		query.append("' ' qty_cntr," ).append("\n"); 
		query.append("' ' rcv_term_cd," ).append("\n"); 
		query.append("' ' receiving," ).append("\n"); 
		query.append("' ' rnum," ).append("\n"); 
		query.append("' ' rows_per_page," ).append("\n"); 
		query.append("' ' shipper," ).append("\n"); 
		query.append("' ' consignee," ).append("\n"); 
		query.append("' ' special_a," ).append("\n"); 
		query.append("' ' special_b," ).append("\n"); 
		query.append("' ' special_d," ).append("\n"); 
		query.append("' ' special_r," ).append("\n"); 
		query.append("' ' st," ).append("\n"); 
		query.append("' ' sz," ).append("\n"); 
		query.append("' ' total_apprval," ).append("\n"); 
		query.append("' ' total_bkg," ).append("\n"); 
		query.append("' ' total_bkg_f," ).append("\n"); 
		query.append("' ' total_bkg_t," ).append("\n"); 
		query.append("' ' total_bl," ).append("\n"); 
		query.append("' ' total_cfm," ).append("\n"); 
		query.append("' ' total_charge," ).append("\n"); 
		query.append("' ' total_cm," ).append("\n"); 
		query.append("' ' total_cnt," ).append("\n"); 
		query.append("' ' total_ctrl_f," ).append("\n"); 
		query.append("' ' total_ctrl_t," ).append("\n"); 
		query.append("' ' total_issue," ).append("\n"); 
		query.append("' ' total_md," ).append("\n"); 
		query.append("' ' total_receiving," ).append("\n"); 
		query.append("' ' total_vl," ).append("\n"); 
		query.append("' ' via," ).append("\n"); 
		query.append("' ' vol," ).append("\n"); 
		query.append("' ' weight," ).append("\n"); 
		query.append("' ' aes," ).append("\n"); 
		query.append("' ' apprval," ).append("\n"); 
		query.append("' ' bdr," ).append("\n"); 
		query.append("' ' bkg_cgo_tp_cd," ).append("\n"); 
		query.append("' ' bkg_no," ).append("\n"); 
		query.append("' ' bkg_sts_cd," ).append("\n"); 
		query.append("' ' bl_no," ).append("\n"); 
		query.append("' ' charge," ).append("\n"); 
		query.append("' ' cm," ).append("\n"); 
		query.append("' ' cntr_cfm_flg," ).append("\n"); 
		query.append("' ' cntr_no," ).append("\n"); 
		query.append("' ' ctr_rnum," ).append("\n"); 
		query.append("' ' curr_page," ).append("\n"); 
		query.append("' ' de_term_cd," ).append("\n"); 
		query.append("' ' del_cd," ).append("\n"); 
		query.append("' ' ff," ).append("\n"); 
		query.append("' ' firm," ).append("\n"); 
		query.append("' ' issue," ).append("\n"); 
		query.append("' ' md," ).append("\n"); 
		query.append("' ' measuere," ).append("\n"); 
		query.append("' ' ob_sls_ofc_cd," ).append("\n"); 
		query.append("' ' p_apod_cd," ).append("\n"); 
		query.append("' ' p_apod_lt," ).append("\n"); 
		query.append("' ' p_awk_cgo_flg," ).append("\n"); 
		query.append("' ' p_bb_cgo_flg," ).append("\n"); 
		query.append("' ' p_bdr_flg," ).append("\n"); 
		query.append("' ' p_bkg_cust_tp_cd," ).append("\n"); 
		query.append("' ' p_bkg_ofc_cd," ).append("\n"); 
		query.append("' ' p_bkg_sts_cd," ).append("\n"); 
		query.append("' ' p_cnmv_sts_cd," ).append("\n"); 
		query.append("' ' p_cust_cnt_cd," ).append("\n"); 
		query.append("' ' p_cust_nm," ).append("\n"); 
		query.append("' ' p_cust_seq," ).append("\n"); 
		query.append("' ' p_dcgo_flg," ).append("\n"); 
		query.append("' ' p_de_term_cd," ).append("\n"); 
		query.append("' ' p_del_cd," ).append("\n"); 
		query.append("' ' p_doc_usr_id," ).append("\n"); 
		query.append("' ' p_eq_type," ).append("\n"); 
		query.append("' ' p_no_good," ).append("\n"); 
		query.append("' ' p_ob_sls_ofc_cd," ).append("\n"); 
		query.append("' ' p_ob_srep_cd," ).append("\n"); 
		query.append("' ' p_obl_iss_ofc_cd," ).append("\n"); 
		query.append("' ' p_ofc_cd," ).append("\n"); 
		query.append("' ' p_pol_cd," ).append("\n"); 
		query.append("' ' p_pol_lt," ).append("\n"); 
		query.append("' ' p_pol_yd_cd," ).append("\n"); 
		query.append("' ' p_por_cd," ).append("\n"); 
		query.append("' ' p_rc_flg," ).append("\n"); 
		query.append("' ' p_rcv_term_cd," ).append("\n"); 
		query.append("' ' p_si_flg," ).append("\n"); 
		query.append("' ' p_vvd," ).append("\n"); 
		query.append("' ' p_zone_cd," ).append("\n"); 
		query.append("' ' el_no," ).append("\n"); 
		query.append("' ' dde," ).append("\n"); 
		query.append("' ' peb," ).append("\n"); 
		query.append("' ' caed," ).append("\n"); 
		query.append("' ' seal," ).append("\n"); 
		query.append("' ' tax_id," ).append("\n"); 
		query.append("' ' rows_per_bkg," ).append("\n"); 
		query.append("' ' shipper_code," ).append("\n"); 
		query.append("' ' por," ).append("\n"); 
		query.append("' ' pol," ).append("\n"); 
		query.append("' ' pod," ).append("\n"); 
		query.append("' ' del," ).append("\n"); 
		query.append("' ' por_nod_cd," ).append("\n"); 
		query.append("' ' del_nod_cd," ).append("\n"); 
		query.append("' ' broker," ).append("\n"); 
		query.append("' ' bkg_ofc_no," ).append("\n"); 
		query.append("' ' hitchment_yn," ).append("\n"); 
		query.append("' ' tvvd," ).append("\n"); 
		query.append("' ' p_dpcs_flg," ).append("\n"); 
		query.append("' ' dpcs_i," ).append("\n"); 
		query.append("' ' dpcs_r," ).append("\n"); 
		query.append("' ' dpcs_q," ).append("\n"); 
		query.append("' ' dpcs_f," ).append("\n"); 
		query.append("' ' dpcs_sts," ).append("\n"); 
		query.append("' ' dpcs_ttl," ).append("\n"); 
		query.append("' ' dpcs_input," ).append("\n"); 
		query.append("' ' dpcs_rate," ).append("\n"); 
		query.append("' ' dpcs_qa," ).append("\n"); 
		query.append("' ' dpcs_bl_proof," ).append("\n"); 
		query.append("' ' status_complete," ).append("\n"); 
		query.append("' ' status_pending," ).append("\n"); 
		query.append("' ' status_open," ).append("\n"); 
		query.append("' ' p_del_conti" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("dual" ).append("\n"); 

	}
}