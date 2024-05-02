/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOEu24ExsListOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.20
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.10.20 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOEu24ExsListOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOEu24ExsListOBRSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOEu24ExsListOBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOEu24ExsListOBRSQL").append("\n"); 
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
		query.append("'' edi_rcv_dt" ).append("\n"); 
		query.append(",'' p_from_mt" ).append("\n"); 
		query.append(",'' p_ack_status" ).append("\n"); 
		query.append(",'' p_lane" ).append("\n"); 
		query.append(",'' edi_rcv_seq" ).append("\n"); 
		query.append(",'' nrcv_bl_cnt" ).append("\n"); 
		query.append(",'' total_ens_amt" ).append("\n"); 
		query.append(",'' mrn_no" ).append("\n"); 
		query.append(",'' bl_no" ).append("\n"); 
		query.append(",'' total_hamur_mcf" ).append("\n"); 
		query.append(",'' p_pofe_yd" ).append("\n"); 
		query.append(",'' total_nycna_ens" ).append("\n"); 
		query.append(",'' p_bl_no" ).append("\n"); 
		query.append(",'' total_vvd_cnt" ).append("\n"); 
		query.append(",'' pol_ofc_cd" ).append("\n"); 
		query.append(",'' pol" ).append("\n"); 
		query.append(",'' unsent_bl_cnt" ).append("\n"); 
		query.append(",'' ens_send_gmt_dt" ).append("\n"); 
		query.append(",'' total_shaas_ens" ).append("\n"); 
		query.append(",'' total_shaas_mcf" ).append("\n"); 
		query.append(",'' p_b_ofc_cd" ).append("\n"); 
		query.append(",'' ack_rcv_dt" ).append("\n"); 
		query.append(",'' total_mcf_amt" ).append("\n"); 
		query.append(",'' p_rhq_gb" ).append("\n"); 
		query.append(",'' rhq" ).append("\n"); 
		query.append(",'' pod" ).append("\n"); 
		query.append(",'' bkg_ofc_cd" ).append("\n"); 
		query.append(",'' p_vvd" ).append("\n"); 
		query.append(",'' pod_yd" ).append("\n"); 
		query.append(",'' p_date_gb" ).append("\n"); 
		query.append(",'' ens_snt_acc" ).append("\n"); 
		query.append(",'' p_to_mt" ).append("\n"); 
		query.append(",'' ct" ).append("\n"); 
		query.append(",'' vvd" ).append("\n"); 
		query.append(",'' p_pol" ).append("\n"); 
		query.append(",'' bkg_no" ).append("\n"); 
		query.append(",'' ens_unsnt_cnt" ).append("\n"); 
		query.append(",'' donld_bl_cnt" ).append("\n"); 
		query.append(",'' p_type" ).append("\n"); 
		query.append(",'' result" ).append("\n"); 
		query.append(",'' p_status" ).append("\n"); 
		query.append(",'' total_sinwa_mcf" ).append("\n"); 
		query.append(",'' pofe" ).append("\n"); 
		query.append(",'' dnl_cnt" ).append("\n"); 
		query.append(",'' ens_amt" ).append("\n"); 
		query.append(",'' bkg_sts_cd" ).append("\n"); 
		query.append(",'' p_cancel_yn" ).append("\n"); 
		query.append(",'' ens_send_dt" ).append("\n"); 
		query.append(",'' sent_bl_cnt" ).append("\n"); 
		query.append(",'' ens_snt_donld" ).append("\n"); 
		query.append(",'' lane" ).append("\n"); 
		query.append(",'' bnd_tp_cd" ).append("\n"); 
		query.append(",'' ack_rcv_gmt_dt" ).append("\n"); 
		query.append(",'' total_hamur_ens" ).append("\n"); 
		query.append(",'' del_yd" ).append("\n"); 
		query.append(",'' result2" ).append("\n"); 
		query.append(",'' bl_tot_cnt" ).append("\n"); 
		query.append(",'' rej_bl_cnt" ).append("\n"); 
		query.append(",'' ens_snt_nrcv" ).append("\n"); 
		query.append(",'' pofe_yd" ).append("\n"); 
		query.append(",'' acc_bl_cnt" ).append("\n"); 
		query.append(",'' ens_amd_cnt" ).append("\n"); 
		query.append(",'' del" ).append("\n"); 
		query.append(",'' sent_success_cnt" ).append("\n"); 
		query.append(",'' p_search_pofe_yard_cd" ).append("\n"); 
		query.append(",'' total_amd_cnt" ).append("\n"); 
		query.append(",'' ens_snt_rej" ).append("\n"); 
		query.append(",'' sent_fail_cnt" ).append("\n"); 
		query.append(",'' r_cnt" ).append("\n"); 
		query.append(",'' ack" ).append("\n"); 
		query.append(",'' a_cnt" ).append("\n"); 
		query.append(",'' p_multi_pope_yn" ).append("\n"); 
		query.append(",'' p_to_dt" ).append("\n"); 
		query.append(",'' p_pofe" ).append("\n"); 
		query.append(",'' total_sinwa_ens" ).append("\n"); 
		query.append(",'' bpol_yd" ).append("\n"); 
		query.append(",'' cntrs" ).append("\n"); 
		query.append(",'' total_nycna_mcf" ).append("\n"); 
		query.append(",'' ens_snt_cnt" ).append("\n"); 
		query.append(",'' mcf_amt" ).append("\n"); 
		query.append(",'' total_bl_cnt" ).append("\n"); 
		query.append(",'' pol_yd" ).append("\n"); 
		query.append(",'' p_from_dt" ).append("\n"); 
		query.append(",'' bpol" ).append("\n"); 
		query.append(",'' p_fdr_yn" ).append("\n"); 
		query.append(",'' nr_cnt" ).append("\n"); 
		query.append(",'' p_pol_yd" ).append("\n"); 
		query.append(",'' sent_type" ).append("\n"); 
		query.append(",'' h_cnt" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}