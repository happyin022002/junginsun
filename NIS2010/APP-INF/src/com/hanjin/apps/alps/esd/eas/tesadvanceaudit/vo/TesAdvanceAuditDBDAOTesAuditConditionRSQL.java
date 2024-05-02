/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesAuditConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2016.03.17 yOnghO
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

public class TesAdvanceAuditDBDAOTesAuditConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAS TES Audit Condition Common Parameter
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesAuditConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesAuditConditionRSQL").append("\n"); 
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
		query.append("		  '' as batch_tp_cd" ).append("\n"); 
		query.append("		, '' as to_datetime" ).append("\n"); 
		query.append("		, '' as s_aud_ofc_cd" ).append("\n"); 
		query.append("		, '' as s_auto_expn_aud_sts_cd" ).append("\n"); 
		query.append("		, '' as s_bat_rslt_cd" ).append("\n"); 
		query.append("		, '' as s_calc_cost_grp_cd" ).append("\n"); 
		query.append("		, '' as s_calc_tp_cd" ).append("\n"); 
		query.append("		, '' as s_cntr_tpsz_cd" ).append("\n"); 
		query.append("		, '' as s_cntr_vsl_clss_capa" ).append("\n"); 
		query.append("		, '' as s_cost_calc_mzd_cd" ).append("\n"); 
		query.append("		, '' as s_csr_no" ).append("\n"); 
		query.append("		, '' as s_csr_sts_cd" ).append("\n"); 
		query.append("		, '' as s_diff_rto" ).append("\n"); 
		query.append("		, '' as s_diff_sgn" ).append("\n"); 
		query.append("		, '' as s_eac_flg" ).append("\n"); 
		query.append("		, '' as s_expn_aud_sts_cd" ).append("\n"); 
		query.append("		, '' as s_expn_aud_tgt_flg" ).append("\n"); 
		query.append("		, '' as s_fm_prd_dt" ).append("\n"); 
		query.append("		, '' as s_fm_dt" ).append("\n"); 
		query.append("		, '' as s_from_inv_cfm_dt" ).append("\n"); 
		query.append("		, '' as s_inv_cfm_dt" ).append("\n"); 
		query.append("		, '' as s_inv_no" ).append("\n"); 
		query.append("		, '' as s_inv_ofc_cd" ).append("\n"); 
		query.append("		, '' as s_io_bnd_cd" ).append("\n"); 
		query.append("		, '' as s_lane_cd" ).append("\n"); 
		query.append("		, '' as s_lgs_cost_dtl_cd" ).append("\n"); 
		query.append("		, '' as s_lgs_cost_subj_cd" ).append("\n"); 
		query.append("		, '' as s_loc_cd" ).append("\n"); 
		query.append("		, '' as s_nod_cd" ).append("\n"); 
		query.append("		, '' as s_prd_ym" ).append("\n"); 
		query.append("		, '' as s_rhq_ofc_cd" ).append("\n"); 
		query.append("		, '' as s_skd_dir_cd" ).append("\n"); 
		query.append("		, '' as s_skd_voy_no" ).append("\n"); 
		query.append("		, '' as s_tml_inv_tp_cd" ).append("\n"); 
		query.append("		, '' as s_to_inv_cfm_dt" ).append("\n"); 
		query.append("		, '' as s_to_prd_dt" ).append("\n"); 
		query.append("		, '' as s_to_dt" ).append("\n"); 
		query.append("		, '' as s_vndr_seq" ).append("\n"); 
		query.append("		, '' as s_vsl_cd" ).append("\n"); 
		query.append("		, '' as s_vvd" ).append("\n"); 
		query.append("		, '' as s_yd_cd" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}