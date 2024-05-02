/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesInvoiceAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.30
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2016.03.30 yOnghO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOnghO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesInvoiceAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES Auto Audit Common VO 생성
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesInvoiceAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesInvoiceAuditRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("  		  '' as amt_aud_tgt_flg" ).append("\n"); 
		query.append("		, '' as atb_dt" ).append("\n"); 
		query.append("		, '' as atch_file_lnk_id" ).append("\n"); 
		query.append("		, '' as aud_case_dtl_qty" ).append("\n"); 
		query.append("		, '' as aud_dtl_tgt_qty" ).append("\n"); 
		query.append("		, '' as aud_lgs_cost_cd_qty" ).append("\n"); 
		query.append("		, '' as aud_upd_dt" ).append("\n"); 
		query.append("		, '' as aud_upd_usr_id" ).append("\n"); 
		query.append("		, '' as aud_upd_usr_nm" ).append("\n"); 
		query.append("		, '' as auto_aud_bat_seq" ).append("\n"); 
		query.append("		, '' as auto_expn_aud_sts_cd" ).append("\n"); 
		query.append("		, '' as awk_cgo_qty" ).append("\n"); 
		query.append("		, '' as awk_bb_cgo_qty" ).append("\n"); 
		query.append("		, '' as bat_amt_rslt_cd" ).append("\n"); 
		query.append("		, '' as bat_amt_rslt_cd_qty" ).append("\n"); 
		query.append("		, '' as bat_estm_vol_rslt_cd" ).append("\n"); 
		query.append("		, '' as bat_estm_vol_rslt_cd_qty" ).append("\n"); 
		query.append("		, '' as bat_prog_sts_cd" ).append("\n"); 
		query.append("		, '' as batch_tp_cd" ).append("\n"); 
		query.append("		, '' as bat_rslt" ).append("\n"); 
		query.append("		, '' as bat_vol_rslt_cd" ).append("\n"); 
		query.append("		, '' as bat_vol_rslt_cd_qty" ).append("\n"); 
		query.append("		, '' as bb_cgo_qty" ).append("\n"); 
		query.append("		, '' as calc_cost_grp_cd" ).append("\n"); 
		query.append("		, '' as calc_tp_cd_ctnt" ).append("\n"); 
		query.append("		, '' as chk" ).append("\n"); 
		query.append("		, '' as cfs_cgo_qty" ).append("\n"); 
		query.append("		, '' as cost_ofc_cd" ).append("\n"); 
		query.append("		, '' as cntr_tpsz_cd" ).append("\n"); 
		query.append("		, '' as cntr_ttl_qty" ).append("\n"); 
		query.append("		, '' as cre_usr_id" ).append("\n"); 
		query.append("		, '' as cre_ofc_cd" ).append("\n"); 
		query.append("		, '' as csr_no" ).append("\n"); 
		query.append("		, '' as csr_sts_cd" ).append("\n"); 
		query.append("		, '' as curr_cd" ).append("\n"); 
		query.append("		, '' as diff_rto" ).append("\n"); 
		query.append("		, '' as dcgo_qty" ).append("\n"); 
		query.append("		, '' as dg_rc_qty" ).append("\n"); 
		query.append("		, '' as eac_flg" ).append("\n"); 
		query.append("		, '' as expn_aud_estm_amt" ).append("\n"); 
		query.append("		, '' as expn_aud_rslt_cd" ).append("\n"); 
		query.append("		, '' as expn_aud_rslt_rmk" ).append("\n"); 
		query.append("		, '' as expn_aud_rslt_usr_id" ).append("\n"); 
		query.append("		, '' as expn_aud_rslt_usr_nm" ).append("\n"); 
		query.append("		, '' as expn_aud_seq" ).append("\n"); 
		query.append("		, '' as expn_aud_sts_cd" ).append("\n"); 
		query.append("		, '' as fm_prd_dt" ).append("\n"); 
		query.append("		, '' as full_mty_cd" ).append("\n"); 
		query.append("		, '' as hngr_cgo_qty" ).append("\n"); 
		query.append("		, '' as inv_amt" ).append("\n"); 
		query.append("		, '' as inv_cfm_dt" ).append("\n"); 
		query.append("		, '' as inv_cfm_dt_ymd" ).append("\n"); 
		query.append("		, '' as inv_cre_usr_nm" ).append("\n"); 
		query.append("		, '' as inv_no" ).append("\n"); 
		query.append("		, '' as inv_ofc_cd" ).append("\n"); 
		query.append("		, '' as inv_prd_dt" ).append("\n"); 
		query.append("		, '' as io_bnd_cd" ).append("\n"); 
		query.append("		, '' as iss_dt" ).append("\n"); 
		query.append("		, '' as pay_dt" ).append("\n"); 
		query.append("		, '' as pay_due_dt" ).append("\n"); 
		query.append("		, '' as pay_term" ).append("\n"); 
		query.append("		, '' as prd_ym" ).append("\n"); 
		query.append("		, '' as rhq_cd" ).append("\n"); 
		query.append("		, '' as rc_qty" ).append("\n"); 
		query.append("		, '' as s_save_tp_cd" ).append("\n"); 
		query.append("		, '' as sel_aud_cd" ).append("\n"); 
		query.append("		, '' as skd_dir_cd" ).append("\n"); 
		query.append("		, '' as skd_voy_no" ).append("\n"); 
		query.append("		, '' as tml_inv_rjct_sts_cd" ).append("\n"); 
		query.append("		, '' as tml_inv_tp_cd" ).append("\n"); 
		query.append("		, '' as to_prd_dt" ).append("\n"); 
		query.append("		, '' as ts_flg" ).append("\n"); 
		query.append("		, '' as upd_dt" ).append("\n"); 
		query.append("		, '' as upd_usr_id" ).append("\n"); 
		query.append("		, '' as vndr_seq" ).append("\n"); 
		query.append("		, '' as vol_aud_tgt_qty" ).append("\n"); 
		query.append("		, '' as vrfy_rslt_cd_ctnt" ).append("\n"); 
		query.append("		, '' as vsl_cd" ).append("\n"); 
		query.append("		, '' as vvd" ).append("\n"); 
		query.append("		, '' as yd_cd" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}