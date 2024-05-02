/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOaddAdvancedBlByBlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.07 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOaddAdvancedBlByBlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addAdvancedBlByBl
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOaddAdvancedBlByBlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ack_rcv_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_snd_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ack_rjct_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_if_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ack_proc_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_cmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ack_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("avc_note_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ack_rjct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_loc_gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tz_yd_zip_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tz_yd_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_mf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_file_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tz_yd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_mf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_file_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_snd_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_file_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_to_ord_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ack_key_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ams_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_lst_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tz_yd_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_trsm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tz_yd_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tz_yd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tz_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOaddAdvancedBlByBlCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        CNT_CD" ).append("\n"); 
		query.append("       ,BL_NO" ).append("\n"); 
		query.append("       ,BKG_NO" ).append("\n"); 
		query.append("       ,VSL_CD" ).append("\n"); 
		query.append("       ,SKD_VOY_NO" ).append("\n"); 
		query.append("       ,SKD_DIR_CD" ).append("\n"); 
		query.append("       ,SLAN_CD" ).append("\n"); 
		query.append("       ,VSL_ARR_DT" ).append("\n"); 
		query.append("       ,CSTMS_PORT_CD" ).append("\n"); 
		query.append("       ,CSTMS_POL_CD" ).append("\n"); 
		query.append("       ,CSTMS_POD_CD" ).append("\n"); 
		query.append("       ,CSTMS_LOC_CD" ).append("\n"); 
		query.append("       ,FROB_FLG" ).append("\n"); 
		query.append("       ,POR_CD" ).append("\n"); 
		query.append("       ,POL_CD" ).append("\n"); 
		query.append("       ,POD_CD" ).append("\n"); 
		query.append("       ,DEL_CD" ).append("\n"); 
		query.append("       ,POD_NOD_CD" ).append("\n"); 
		query.append("       ,DEL_NOD_CD" ).append("\n"); 
		query.append("       ,CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("       ,USA_LST_LOC_CD" ).append("\n"); 
		query.append("       ,HUB_LOC_CD" ).append("\n"); 
		query.append("       ,PCK_QTY" ).append("\n"); 
		query.append("       ,AMS_PCK_TP_CD" ).append("\n"); 
		query.append("       ,CGO_WGT" ).append("\n"); 
		query.append("       ,WGT_UT_CD" ).append("\n"); 
		query.append("       ,MEAS_QTY" ).append("\n"); 
		query.append("       ,MEAS_UT_CD" ).append("\n"); 
		query.append("       ,RCV_TERM_CD" ).append("\n"); 
		query.append("       ,DE_TERM_CD" ).append("\n"); 
		query.append("       ,BDR_FLG" ).append("\n"); 
		query.append("       ,BDR_DT" ).append("\n"); 
		query.append("       ,BDR_OFC_CD" ).append("\n"); 
		query.append("       ,CA_FLG" ).append("\n"); 
		query.append("       ,CA_ISS_DT" ).append("\n"); 
		query.append("       ,CA_NO" ).append("\n"); 
		query.append("       ,SCAC_CD" ).append("\n"); 
		query.append("       ,FULL_MTY_CD" ).append("\n"); 
		query.append("       ,MF_STS_CD" ).append("\n"); 
		query.append("       ,IF_FLG" ).append("\n"); 
		query.append("       ,IF_DT" ).append("\n"); 
		query.append("       ,MF_NO" ).append("\n"); 
		query.append("       ,PRE_MF_NO" ).append("\n"); 
		query.append("       ,CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("       ,CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append("       ,CSTMS_ACK_KEY_NO" ).append("\n"); 
		query.append("       ,CSTMS_ACK_RCV_RSLT_CD" ).append("\n"); 
		query.append("       ,CSTMS_ACK_PROC_RSLT_CD" ).append("\n"); 
		query.append("       ,CSTMS_ACK_RJCT_CD" ).append("\n"); 
		query.append("       ,CSTMS_ACK_RJCT_MSG" ).append("\n"); 
		query.append("       ,CSTMS_ACK_RCV_DT" ).append("\n"); 
		query.append("       ,USR_CMT_CTNT" ).append("\n"); 
		query.append("       ,DIFF_RMK" ).append("\n"); 
		query.append("       ,TRSP_MOD_ID" ).append("\n"); 
		query.append("       ,IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append("       ,CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("       ,MF_SND_DT" ).append("\n"); 
		query.append("       ,AMDT_SND_DT" ).append("\n"); 
		query.append("       ,CSTMS_FILE_LOC_CD" ).append("\n"); 
		query.append("       ,FAX_OFC_CD" ).append("\n"); 
		query.append("       ,FAX_CNT_CD" ).append("\n"); 
		query.append("       ,FAX_CUST_SEQ" ).append("\n"); 
		query.append("       ,FAX_NO" ).append("\n"); 
		query.append("       ,TRSP_TP_ID" ).append("\n"); 
		query.append("       ,IN_TZ_YD_CD" ).append("\n"); 
		query.append("       ,IN_TZ_YD_NM" ).append("\n"); 
		query.append("       ,IN_TZ_YD_ADDR" ).append("\n"); 
		query.append("       ,IN_TZ_YD_CTY_NM" ).append("\n"); 
		query.append("       ,IN_TZ_YD_STE_CD" ).append("\n"); 
		query.append("       ,IN_TZ_YD_CNT_CD" ).append("\n"); 
		query.append("       ,IN_TZ_YD_ZIP_ID" ).append("\n"); 
		query.append("       ,AVC_NOTE_TP_ID" ).append("\n"); 
		query.append("       ,ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,BDR_GDT" ).append("\n"); 
		query.append("       ,BDR_IF_GDT" ).append("\n"); 
		query.append("       ,IF_GDT" ).append("\n"); 
		query.append("       ,MF_SND_GDT" ).append("\n"); 
		query.append("       ,AMDT_SND_GDT" ).append("\n"); 
		query.append("       ,PRT_FLG" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        'US'" ).append("\n"); 
		query.append("       ,@[bl_no]" ).append("\n"); 
		query.append("       ,@[bkg_no]" ).append("\n"); 
		query.append("       ,@[vsl_cd]" ).append("\n"); 
		query.append("       ,@[skd_voy_no]" ).append("\n"); 
		query.append("       ,@[skd_dir_cd]" ).append("\n"); 
		query.append("       ,@[slan_cd]" ).append("\n"); 
		query.append("       ,TO_DATE(@[vsl_arr_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,@[cstms_port_cd]" ).append("\n"); 
		query.append("       ,@[cstms_pol_cd]" ).append("\n"); 
		query.append("       ,@[cstms_pod_cd]" ).append("\n"); 
		query.append("       ,DECODE(@[cstms_loc_cd], NULL, @[hub_loc_cd], @[cstms_loc_cd])" ).append("\n"); 
		query.append("       ,DECODE(SUBSTR(@[cstms_pod_cd],0,2), 'CA', 'Y', 'N')" ).append("\n"); 
		query.append("       ,@[por_cd]" ).append("\n"); 
		query.append("       ,@[pol_cd]" ).append("\n"); 
		query.append("       ,@[pod_cd]" ).append("\n"); 
		query.append("       ,@[del_cd]" ).append("\n"); 
		query.append("       ,@[pod_nod_cd]" ).append("\n"); 
		query.append("       ,@[del_nod_cd]" ).append("\n"); 
		query.append("       ,NVL(@[cust_to_ord_flg], 'N')" ).append("\n"); 
		query.append("       ,@[usa_lst_loc_cd]" ).append("\n"); 
		query.append("       ,@[hub_loc_cd]" ).append("\n"); 
		query.append("       ,NVL(@[pck_qty],0)" ).append("\n"); 
		query.append("       ,@[ams_pck_tp_cd]" ).append("\n"); 
		query.append("       ,NVL(@[cgo_wgt],0)" ).append("\n"); 
		query.append("       ,@[wgt_ut_cd]" ).append("\n"); 
		query.append("       ,NVL(@[meas_qty],0)" ).append("\n"); 
		query.append("       ,@[meas_ut_cd]" ).append("\n"); 
		query.append("       ,@[rcv_term_cd]" ).append("\n"); 
		query.append("       ,@[de_term_cd]" ).append("\n"); 
		query.append("       ,NVL(@[bdr_flg],'N')" ).append("\n"); 
		query.append("       ,TO_DATE(@[bdr_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,@[bdr_ofc_cd]" ).append("\n"); 
		query.append("       ,NVL(@[ca_flg],'N')" ).append("\n"); 
		query.append("       ,TO_DATE(@[ca_iss_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,@[ca_no]" ).append("\n"); 
		query.append("       ,@[scac_cd]" ).append("\n"); 
		query.append("       ,DECODE(@[full_mty_cd], 'P', 'M', 'F')" ).append("\n"); 
		query.append("       ,'A'" ).append("\n"); 
		query.append("       ,'Y'" ).append("\n"); 
		query.append("       ,GLOBALDATE_PKG.TIME_CONV_FNC('KRACY', SYSDATE, 'USNYC')" ).append("\n"); 
		query.append("       ,@[mf_no]" ).append("\n"); 
		query.append("       ,@[pre_mf_no]" ).append("\n"); 
		query.append("       ,@[cstms_file_tp_cd]" ).append("\n"); 
		query.append("       ,@[cstms_trsm_sts_cd]" ).append("\n"); 
		query.append("       ,@[cstms_ack_key_no]" ).append("\n"); 
		query.append("       ,@[cstms_ack_rcv_rslt_cd]" ).append("\n"); 
		query.append("       ,@[cstms_ack_proc_rslt_cd]" ).append("\n"); 
		query.append("       ,@[cstms_ack_rjct_cd]" ).append("\n"); 
		query.append("       ,@[cstms_ack_rjct_msg]" ).append("\n"); 
		query.append("       ,TO_DATE(@[cstms_ack_rcv_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,@[usr_cmt_ctnt]" ).append("\n"); 
		query.append("       ,@[diff_rmk]" ).append("\n"); 
		query.append("       ,@[trsp_mod_id]" ).append("\n"); 
		query.append("       ,@[ibd_loc_gds_desc]" ).append("\n"); 
		query.append("       ,@[cstms_mf_tp_cd]" ).append("\n"); 
		query.append("       ,TO_DATE(@[mf_snd_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,TO_DATE(@[amdt_snd_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,@[cstms_file_loc_cd]" ).append("\n"); 
		query.append("       ,@[fax_ofc_cd]" ).append("\n"); 
		query.append("       ,@[fax_cnt_cd]" ).append("\n"); 
		query.append("       ,@[fax_cust_seq]" ).append("\n"); 
		query.append("       ,@[fax_no]" ).append("\n"); 
		query.append("       ,@[trsp_tp_id]" ).append("\n"); 
		query.append("       ,@[in_tz_yd_cd]" ).append("\n"); 
		query.append("       ,@[in_tz_yd_nm]" ).append("\n"); 
		query.append("       ,@[in_tz_yd_addr]" ).append("\n"); 
		query.append("       ,@[in_tz_yd_cty_nm]" ).append("\n"); 
		query.append("       ,@[in_tz_yd_ste_cd]" ).append("\n"); 
		query.append("       ,@[in_tz_yd_cnt_cd]" ).append("\n"); 
		query.append("       ,@[in_tz_yd_zip_id]" ).append("\n"); 
		query.append("       ,@[avc_note_tp_id]" ).append("\n"); 
		query.append("       ,CASE WHEN SUBSTR(@[cstms_pol_cd],0,2) = 'CA' AND @[act_file_skd_dir_cd] IS NOT NULL THEN @[act_file_skd_dir_cd]" ).append("\n"); 
		query.append("             WHEN SUBSTR(@[cstms_pol_cd],0,2) = 'CA' AND @[skd_dir_cd] = 'W' THEN 'E'" ).append("\n"); 
		query.append("             WHEN SUBSTR(@[cstms_pol_cd],0,2) = 'CA' AND @[skd_dir_cd] = 'E' THEN 'W'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("         END" ).append("\n"); 
		query.append("       ,TO_DATE(@[bdr_gdt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,TO_DATE(@[bdr_if_gdt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,TO_DATE(@[if_gdt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,TO_DATE(@[mf_snd_gdt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,TO_DATE(@[amdt_snd_gdt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,NVL(@[prt_flg], 'N')" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,NVL(TO_DATE(@[cre_dt],'YYYYMMDDHH24MISS'),SYSDATE)" ).append("\n"); 
		query.append("       ,@[upd_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}