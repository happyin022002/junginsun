/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOEu24EnsListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.13
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.09.13 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOEu24EnsListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOEu24EnsListVORSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOEu24EnsListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOEu24EnsListVORSQL").append("\n"); 
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
		query.append("/* Eu24EnsList	VO */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  ' ' AS a_cnt" ).append("\n"); 
		query.append(", ' ' AS acc_bl_cnt" ).append("\n"); 
		query.append(", ' ' AS ack" ).append("\n"); 
		query.append(", ' ' AS ack_rcv_dt" ).append("\n"); 
		query.append(", ' ' AS ack_rcv_gmt_dt" ).append("\n"); 
		query.append(", ' ' AS bkg_no" ).append("\n"); 
		query.append(", ' ' AS bkg_ofc_cd" ).append("\n"); 
		query.append(", ' ' AS bkg_sts_cd" ).append("\n"); 
		query.append(", ' ' AS bl_no" ).append("\n"); 
		query.append(", ' ' AS bl_tot_cnt" ).append("\n"); 
		query.append(", ' ' AS cntrs" ).append("\n"); 
		query.append(", ' ' AS cond_lane" ).append("\n"); 
		query.append(", ' ' AS ct" ).append("\n"); 
		query.append(", ' ' AS ca_cnt" ).append("\n"); 
		query.append(", ' ' AS del" ).append("\n"); 
		query.append(", ' ' AS del_yd" ).append("\n"); 
		query.append(", ' ' AS dnl_cnt" ).append("\n"); 
		query.append(", ' ' AS donld_bl_cnt" ).append("\n"); 
		query.append(", ' ' AS edi_rcv_dt" ).append("\n"); 
		query.append(", ' ' AS edi_rcv_seq" ).append("\n"); 
		query.append(", ' ' AS ens_amd_cnt" ).append("\n"); 
		query.append(", ' ' AS ens_amt" ).append("\n"); 
		query.append(", ' ' AS ens_send_dt" ).append("\n"); 
		query.append(", ' ' AS ens_send_gmt_dt" ).append("\n"); 
		query.append(", ' ' AS ens_snt_acc" ).append("\n"); 
		query.append(", ' ' AS ens_snt_cnt" ).append("\n"); 
		query.append(", ' ' AS ens_snt_donld" ).append("\n"); 
		query.append(", ' ' AS ens_snt_nrcv" ).append("\n"); 
		query.append(", ' ' AS ens_snt_rej" ).append("\n"); 
		query.append(", ' ' AS ens_unsnt_cnt" ).append("\n"); 
		query.append(", ' ' AS lane" ).append("\n"); 
		query.append(", ' ' AS mcf_amt" ).append("\n"); 
		query.append(", ' ' AS mrn_no" ).append("\n"); 
		query.append(", ' ' AS nr_cnt" ).append("\n"); 
		query.append(", ' ' AS nrcv_bl_cnt" ).append("\n"); 
		query.append(", ' ' AS p_ack_status" ).append("\n"); 
		query.append(", ' ' AS p_b_ofc_cd" ).append("\n"); 
		query.append(", ' ' AS p_bl_no" ).append("\n"); 
		query.append(", ' ' AS p_cancel_yn" ).append("\n"); 
		query.append(", ' ' AS p_date_gb" ).append("\n"); 
		query.append(", ' ' AS p_fdr_yn" ).append("\n"); 
		query.append(", ' ' AS p_from_dt" ).append("\n"); 
		query.append(", ' ' AS p_from_mt" ).append("\n"); 
		query.append(", ' ' AS p_lane" ).append("\n"); 
		query.append(", ' ' AS p_multi_pope_yn" ).append("\n"); 
		query.append(", ' ' AS p_pofe" ).append("\n"); 
		query.append(", ' ' AS p_pofe_yd" ).append("\n"); 
		query.append(", ' ' AS p_pol" ).append("\n"); 
		query.append(", ' ' AS p_pol_yd" ).append("\n"); 
		query.append(", ' ' AS p_rhq_gb" ).append("\n"); 
		query.append(", ' ' AS p_search_pofe_yard_cd" ).append("\n"); 
		query.append(", ' ' AS p_sent_type" ).append("\n"); 
		query.append(", ' ' AS p_status" ).append("\n"); 
		query.append(", ' ' AS p_to_dt" ).append("\n"); 
		query.append(", ' ' AS p_to_mt" ).append("\n"); 
		query.append(", ' ' AS p_type" ).append("\n"); 
		query.append(", ' ' AS p_vvd" ).append("\n"); 
		query.append(", ' ' AS pod" ).append("\n"); 
		query.append(", ' ' AS pod_yd" ).append("\n"); 
		query.append(", ' ' AS pofe" ).append("\n"); 
		query.append(", ' ' AS pofe_yd" ).append("\n"); 
		query.append(", ' ' AS pol" ).append("\n"); 
		query.append(", ' ' AS pol_ofc_cd" ).append("\n"); 
		query.append(", ' ' AS pol_yd" ).append("\n"); 
		query.append(", ' ' AS r_cnt" ).append("\n"); 
		query.append(", ' ' AS rej_bl_cnt" ).append("\n"); 
		query.append(", ' ' AS result" ).append("\n"); 
		query.append(", ' ' AS result2" ).append("\n"); 
		query.append(", ' ' AS rhq" ).append("\n"); 
		query.append(", ' ' AS sent_bl_cnt" ).append("\n"); 
		query.append(", ' ' AS sent_fail_cnt" ).append("\n"); 
		query.append(", ' ' AS sent_success_cnt" ).append("\n"); 
		query.append(", ' ' AS sent_type" ).append("\n"); 
		query.append(", ' ' AS total_amd_cnt" ).append("\n"); 
		query.append(", ' ' AS total_bl_cnt" ).append("\n"); 
		query.append(", ' ' AS total_ens_amt" ).append("\n"); 
		query.append(", ' ' AS total_hamur_ens" ).append("\n"); 
		query.append(", ' ' AS total_hamur_mcf" ).append("\n"); 
		query.append(", ' ' AS total_mcf_amt" ).append("\n"); 
		query.append(", ' ' AS total_nycna_ens" ).append("\n"); 
		query.append(", ' ' AS total_nycna_mcf" ).append("\n"); 
		query.append(", ' ' AS total_shaas_ens" ).append("\n"); 
		query.append(", ' ' AS total_shaas_mcf" ).append("\n"); 
		query.append(", ' ' AS total_sinwa_ens" ).append("\n"); 
		query.append(", ' ' AS total_sinwa_mcf" ).append("\n"); 
		query.append(", ' ' AS total_vvd_cnt" ).append("\n"); 
		query.append(", ' ' AS unsent_bl_cnt" ).append("\n"); 
		query.append(", ' ' AS vps_eta_dt" ).append("\n"); 
		query.append(", ' ' AS vps_etb_dt" ).append("\n"); 
		query.append(", ' ' AS vvd" ).append("\n"); 
		query.append(", ' ' AS goods_item_no" ).append("\n"); 
		query.append(", ' ' AS al_cnt" ).append("\n"); 
		query.append("-- 130913 일치" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}