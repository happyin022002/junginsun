/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOEur24BlGeneralInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.03
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.03.03 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOEur24BlGeneralInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOEur24BlGeneralInfoVORSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOEur24BlGeneralInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOEur24BlGeneralInfoVORSQL").append("\n"); 
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
		query.append("/* Eur24BlGeneralInfoVO" ).append("\n"); 
		query.append("import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlInfoVO;" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  ' ' AS por_cd" ).append("\n"); 
		query.append(", ' ' AS vsl_cd" ).append("\n"); 
		query.append(", ' ' AS pol_nm" ).append("\n"); 
		query.append(", ' ' AS snd_dt" ).append("\n"); 
		query.append(", ' ' AS bl_no" ).append("\n"); 
		query.append(", ' ' AS pol_cd" ).append("\n"); 
		query.append(", ' ' AS bkg_pod_cd" ).append("\n"); 
		query.append(", ' ' AS vsl_eng_nm" ).append("\n"); 
		query.append(", ' ' AS cmdt_cd" ).append("\n"); 
		query.append(", ' ' AS msg_func_id" ).append("\n"); 
		query.append(", ' ' AS cstms_desc" ).append("\n"); 
		query.append(", ' ' AS wgt_ut_cd" ).append("\n"); 
		query.append(", ' ' AS meas_qty" ).append("\n"); 
		query.append(", ' ' AS pck_qty" ).append("\n"); 
		query.append(", ' ' AS rcv_term_cd" ).append("\n"); 
		query.append(", ' ' AS pod_yd_cd" ).append("\n"); 
		query.append(", ' ' AS meas_ut_cd" ).append("\n"); 
		query.append(", ' ' AS mvmt_ref_no" ).append("\n"); 
		query.append(", ' ' AS pck_tp_cd" ).append("\n"); 
		query.append(", ' ' AS cstms_port_cd" ).append("\n"); 
		query.append(", ' ' AS bkg_pol_cd" ).append("\n"); 
		query.append(", ' ' AS pod_nm" ).append("\n"); 
		query.append(", ' ' AS del_nm" ).append("\n"); 
		query.append(", ' ' AS cstms_decl_dt" ).append("\n"); 
		query.append(", ' ' AS del_cd" ).append("\n"); 
		query.append(", ' ' AS skd_voy_no" ).append("\n"); 
		query.append(", ' ' AS skd_dir_cd" ).append("\n"); 
		query.append(", ' ' AS act_wgt" ).append("\n"); 
		query.append(", ' ' AS pod_cd" ).append("\n"); 
		query.append(", ' ' AS vvd" ).append("\n"); 
		query.append(", ' ' AS de_term_cd" ).append("\n"); 
		query.append(", ' ' AS lloyd_no" ).append("\n"); 
		query.append(", ' ' AS trsp_doc_no" ).append("\n"); 
		query.append(", ' ' AS pol_yd_cd" ).append("\n"); 
		query.append(", ' ' AS msg_snd_no" ).append("\n"); 
		query.append(", ' ' AS decl_loc_cd" ).append("\n"); 
		query.append(", ' ' AS type_cd" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(", ' ' AS err_yn" ).append("\n"); 
		query.append(", ' ' AS ens_edi_svc_flg" ).append("\n"); 
		query.append(", ' ' AS exs_edi_svc_flg" ).append("\n"); 
		query.append(", ' ' AS dr_yn" ).append("\n"); 
		query.append(", ' ' AS kts_send_dt" ).append("\n"); 
		query.append(", ' ' AS ata_yn" ).append("\n"); 
		query.append(", ' ' AS arn_yn" ).append("\n"); 
		query.append(", ' ' AS rcv_mvmt_ref_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS bl_mrn_yn" ).append("\n"); 
		query.append(", ' ' AS err_yns" ).append("\n"); 
		query.append(", ' ' AS kts_send_dt1" ).append("\n"); 
		query.append(", ' ' AS kts_send_dt2" ).append("\n"); 
		query.append(", ' ' AS mvmt_ref_no1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS prev_doc_no" ).append("\n"); 
		query.append(", ' ' AS prev_doc_nos" ).append("\n"); 
		query.append(", ' ' AS search_prev_doc_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS local_time" ).append("\n"); 
		query.append(", ' ' AS ack_cd" ).append("\n"); 
		query.append(", ' ' AS his_ack_cd" ).append("\n"); 
		query.append(", ' ' AS msg_func_hold" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS trsm_blck_flg" ).append("\n"); 
		query.append(", ' ' AS trsm_val" ).append("\n"); 
		query.append("-- 20140303 일치" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}