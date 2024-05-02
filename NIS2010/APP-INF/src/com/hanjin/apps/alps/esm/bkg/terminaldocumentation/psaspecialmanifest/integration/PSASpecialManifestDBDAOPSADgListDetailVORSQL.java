/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOPSADgListDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.10.11 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOPSADgListDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSADgListDetailVO 생성을 위해 사용
	  * </pre>
	  */
	public PSASpecialManifestDBDAOPSADgListDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOPSADgListDetailVORSQL").append("\n"); 
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
		query.append("'' brth_yd_cd" ).append("\n"); 
		query.append(",'' svc_rqst_no" ).append("\n"); 
		query.append(",'' vsl_cd" ).append("\n"); 
		query.append(",'' imdg_un_no_seq" ).append("\n"); 
		query.append(",'' dcgo_seq" ).append("\n"); 
		query.append(",'' out_imdg_pck_qty1" ).append("\n"); 
		query.append(",'' bl_no" ).append("\n"); 
		query.append(",'' imdg_comp_grp_cd" ).append("\n"); 
		query.append(",'' pol_cd" ).append("\n"); 
		query.append(",'' eta_t" ).append("\n"); 
		query.append(",'' cntr_tpsz_cd" ).append("\n"); 
		query.append(",'' fdr_vvd_id" ).append("\n"); 
		query.append(",'' crnt_cell_psn_no_cnt" ).append("\n"); 
		query.append(",'' in_imdg_pck_cd1" ).append("\n"); 
		query.append(",'' imdg_un_no" ).append("\n"); 
		query.append(",'' upd_usr_id" ).append("\n"); 
		query.append(",'' packages" ).append("\n"); 
		query.append(",'' call_sgn_no" ).append("\n"); 
		query.append(",'' net_wgt" ).append("\n"); 
		query.append(",'' dg_short_nm" ).append("\n"); 
		query.append(",'' cntr_cnt" ).append("\n"); 
		query.append(",'' agent" ).append("\n"); 
		query.append(",'' cntr_cgo_seq" ).append("\n"); 
		query.append(",'' fwrd_nm" ).append("\n"); 
		query.append(",'' pod_cd" ).append("\n"); 
		query.append(",'' bkg_no" ).append("\n"); 
		query.append(",'' cre_usr_id" ).append("\n"); 
		query.append(",'' lloyd_no" ).append("\n"); 
		query.append(",'' ack_rcv_sts_cd" ).append("\n"); 
		query.append(",'' yd_nm" ).append("\n"); 
		query.append(",'' hzd_desc" ).append("\n"); 
		query.append(",'' imdg_clss_cd" ).append("\n"); 
		query.append(",'' out_imdg_pck_cd1" ).append("\n"); 
		query.append(",'' grs_wgt" ).append("\n"); 
		query.append(",'' fdr_vsl_nm" ).append("\n"); 
		query.append(",'' imdg_pck_grp_cd" ).append("\n"); 
		query.append(",'' flsh_pnt_cdo_temp" ).append("\n"); 
		query.append(",'' send_type" ).append("\n"); 
		query.append(",'' etd_t" ).append("\n"); 
		query.append(",'' ems_no" ).append("\n"); 
		query.append(",'' in_pck_desc" ).append("\n"); 
		query.append(",'' local_db_yn" ).append("\n"); 
		query.append(",'' vsl_eng_nm" ).append("\n"); 
		query.append(",'' scr_file_no" ).append("\n"); 
		query.append(",'' etd_d" ).append("\n"); 
		query.append(",'' vsl_cnt_cd" ).append("\n"); 
		query.append(",'' dcgo_mrn_polut_cd" ).append("\n"); 
		query.append(",'' dg_cntr_seq" ).append("\n"); 
		query.append(",'' dg_short_nm_cnt" ).append("\n"); 
		query.append(",'' cell_psn_no" ).append("\n"); 
		query.append(",'' group_cnt" ).append("\n"); 
		query.append(",'' fdr_svc_rqst_no" ).append("\n"); 
		query.append(",'' auto_snd_tp_cd" ).append("\n"); 
		query.append(",'' fdr_vsl_lloyd_no" ).append("\n"); 
		query.append(",'' first_msg_snd_no" ).append("\n"); 
		query.append(",'' c_type" ).append("\n"); 
		query.append(",'' cntr_no" ).append("\n"); 
		query.append(",'' in_imdg_pck_qty1" ).append("\n"); 
		query.append(",'' out_pck_desc" ).append("\n"); 
		query.append(",'' imdg_subs_rsk_lbl_cd2" ).append("\n"); 
		query.append(",'' seq" ).append("\n"); 
		query.append(",'' imdg_subs_rsk_lbl_cd1" ).append("\n"); 
		query.append(",'' prp_shp_nm" ).append("\n"); 
		query.append(",'' merge_bl_no" ).append("\n"); 
		query.append(",'' msg_snd_no" ).append("\n"); 
		query.append(",'' imdg_subs_rsk_lbl_cd4" ).append("\n"); 
		query.append(",'' fwrd_id" ).append("\n"); 
		query.append(",'' eta_d" ).append("\n"); 
		query.append(",'' crr_dt" ).append("\n"); 
		query.append(",'' imdg_subs_rsk_lbl_cd3" ).append("\n"); 
		query.append(",'' imdg_lmt_qty_flg" ).append("\n"); 
		query.append(",'' CNMV_STS_CD" ).append("\n"); 
		query.append(",'' TNK_CNTR_FLG" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}