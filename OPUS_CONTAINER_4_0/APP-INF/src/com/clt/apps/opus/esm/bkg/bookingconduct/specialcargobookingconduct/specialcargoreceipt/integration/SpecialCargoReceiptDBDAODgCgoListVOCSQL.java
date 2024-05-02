/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAODgCgoListVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAODgCgoListVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgCgoListVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAODgCgoListVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_rqst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_explo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rada_trsp_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_dpnd_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_imdg_pck_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_in_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_expt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_stwg_rqst_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("erap_apro_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_rqst_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_dtl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dot_exp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_lcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_cntc_phn_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_polut_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("erap_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_comp_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ems_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_segr_grp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_imdg_pck_qty2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_temp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_spcl_provi_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_lmt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flsh_pnt_cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_rspn_gid_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hzd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rada_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_qty2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_qty2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("erap_cntc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dot_spcl_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dot_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_amdt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("emer_temp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_in_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rada_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("certi_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_rspn_gid_chr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rada_skd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAODgCgoListVOCSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT INTO BKG_DG_CGO_HIS (" ).append("\n"); 
		query.append("	IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append(",	CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	DCGO_SEQ" ).append("\n"); 
		query.append(",	DG_CNTR_SEQ" ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	IMDG_UN_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(",	IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(",	PRP_SHP_NM" ).append("\n"); 
		query.append(",	HZD_DESC" ).append("\n"); 
		query.append(",	MEAS_QTY" ).append("\n"); 
		query.append(",	MEAS_UT_CD" ).append("\n"); 
		query.append(",	CLOD_FLG" ).append("\n"); 
		query.append(",	SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(",	DCGO_STS_CD" ).append("\n"); 
		query.append(",	CGO_LCL_FLG" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_NO" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append(",	EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append(",	EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	EMER_TEMP_CTNT" ).append("\n"); 
		query.append(",	CTRL_TEMP_CTNT" ).append("\n"); 
		query.append(",	EMS_NO" ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",	MRN_POLUT_FLG" ).append("\n"); 
		query.append(",	PSA_NO" ).append("\n"); 
		query.append(",	CERTI_NO" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_CD2" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_CD2" ).append("\n"); 
		query.append(",	MAX_IN_PCK_QTY" ).append("\n"); 
		query.append(",	MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append(",	CNEE_DTL_DESC" ).append("\n"); 
		query.append(",	NET_EXPLO_WGT" ).append("\n"); 
		query.append(",	RADA_SKD_NO" ).append("\n"); 
		query.append(",	RADA_AMT" ).append("\n"); 
		query.append(",	RADA_UT_CD" ).append("\n"); 
		query.append(",	RADA_TRSP_NO" ).append("\n"); 
		query.append(",	RC_FLG" ).append("\n"); 
		query.append(",	AWK_CGO_FLG" ).append("\n"); 
		query.append(",	BB_CGO_FLG" ).append("\n"); 
		query.append(",	RC_SEQ" ).append("\n"); 
		query.append(",	AWK_CGO_SEQ" ).append("\n"); 
		query.append(",	BB_CGO_SEQ" ).append("\n"); 
		query.append(",	HCDG_FLG" ).append("\n"); 
		query.append(",	HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	APLY_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	CORR_NO" ).append("\n"); 
		query.append(",	SPCL_RQST_FLG " ).append("\n"); 
		query.append(",	SPCL_RQST_DESC " ).append("\n"); 
		query.append(",	IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append(",	RSD_FLG" ).append("\n"); 
		query.append(",	CFR_FLG" ).append("\n"); 
		query.append(",	DCGO_REF_NO" ).append("\n"); 
		query.append(",	IMDG_AMDT_NO" ).append("\n"); 
		query.append(",	ERAP_NO" ).append("\n"); 
		query.append(",	ERAP_CNTC_NO" ).append("\n"); 
		query.append(",	ERAP_APRO_REF_NO" ).append("\n"); 
		query.append(",	DOT_EXP_NO" ).append("\n"); 
		query.append(",	DOT_SPCL_APRO_NO" ).append("\n"); 
		query.append(",	DOT_AUTH_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SPCL_PROVI_CTNT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[imdg_comp_grp_cd]" ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd4]" ).append("\n"); 
		query.append(",	@[cntr_vol_qty]" ).append("\n"); 
		query.append(",	@[bkg_no]" ).append("\n"); 
		query.append(",	@[dcgo_seq]" ).append("\n"); 
		query.append(",	@[dg_cntr_seq]" ).append("\n"); 
		query.append(",	@[cntr_cgo_seq]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[imdg_un_no]" ).append("\n"); 
		query.append(",	@[imdg_un_no_seq]" ).append("\n"); 
		query.append(",	@[imdg_clss_cd]" ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd1]" ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd2]" ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd3]" ).append("\n"); 
		query.append(",	@[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append(",	@[imdg_expt_qty_flg]" ).append("\n"); 
		query.append(",	@[net_wgt]" ).append("\n"); 
		query.append(",	@[grs_wgt]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	@[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append(",	@[prp_shp_nm]" ).append("\n"); 
		query.append(",	@[hzd_desc]" ).append("\n"); 
		query.append(",	@[meas_qty]" ).append("\n"); 
		query.append(",	@[meas_ut_cd]" ).append("\n"); 
		query.append(",	@[clod_flg]" ).append("\n"); 
		query.append(",	@[spcl_stwg_rqst_desc]" ).append("\n"); 
		query.append(",	@[dcgo_sts_cd]" ).append("\n"); 
		query.append(",	@[cgo_lcl_flg]" ).append("\n"); 
		query.append(",	@[emer_rspn_gid_no]" ).append("\n"); 
		query.append(",	@[emer_rspn_gid_chr_no]" ).append("\n"); 
		query.append(",	@[emer_cntc_phn_no_ctnt]" ).append("\n"); 
		query.append(",	@[emer_cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[emer_temp_ctnt]" ).append("\n"); 
		query.append(",	@[ctrl_temp_ctnt]" ).append("\n"); 
		query.append(",	@[ems_no]" ).append("\n"); 
		query.append(",	@[imdg_pck_grp_cd]" ).append("\n"); 
		query.append(",	@[mrn_polut_flg]" ).append("\n"); 
		query.append(",	@[psa_no]" ).append("\n"); 
		query.append(",	@[certi_no]" ).append("\n"); 
		query.append(",	@[in_imdg_pck_qty1]" ).append("\n"); 
		query.append(",	@[in_imdg_pck_cd1]" ).append("\n"); 
		query.append(",	@[in_imdg_pck_qty2]" ).append("\n"); 
		query.append(",	@[in_imdg_pck_cd2]" ).append("\n"); 
		query.append(",	@[out_imdg_pck_qty1]" ).append("\n"); 
		query.append(",	@[out_imdg_pck_cd1]" ).append("\n"); 
		query.append(",	@[out_imdg_pck_qty2]" ).append("\n"); 
		query.append(",	@[out_imdg_pck_cd2]" ).append("\n"); 
		query.append(",	@[max_in_pck_qty]" ).append("\n"); 
		query.append(",	@[max_in_pck_tp_cd]" ).append("\n"); 
		query.append(",	@[cnee_dtl_desc]" ).append("\n"); 
		query.append(",	@[net_explo_wgt]" ).append("\n"); 
		query.append(",	@[rada_skd_no]" ).append("\n"); 
		query.append(",	@[rada_amt]" ).append("\n"); 
		query.append(",	@[rada_ut_cd]" ).append("\n"); 
		query.append(",	@[rada_trsp_no]" ).append("\n"); 
		query.append(",	@[rc_flg]" ).append("\n"); 
		query.append(",	@[awk_cgo_flg]" ).append("\n"); 
		query.append(",	@[bb_cgo_flg]" ).append("\n"); 
		query.append(",	@[rc_seq]" ).append("\n"); 
		query.append(",	@[awk_cgo_seq]" ).append("\n"); 
		query.append(",	@[bb_cgo_seq]" ).append("\n"); 
		query.append(",	DECODE(@[hcdg_flg], 'HCDG', 'Y', 'N')" ).append("\n"); 
		query.append(",	@[hcdg_dpnd_qty_flg]" ).append("\n"); 
		query.append(",	@[rqst_usr_id]" ).append("\n"); 
		query.append(",	@[aply_no]" ).append("\n"); 
		query.append(",	@[spcl_cgo_apro_cd]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	'TMP0000001'" ).append("\n"); 
		query.append(",	@[spcl_rqst_flg]" ).append("\n"); 
		query.append(",	@[spcl_rqst_desc]" ).append("\n"); 
		query.append(",	@[imdg_segr_grp_no]" ).append("\n"); 
		query.append(",	@[rsd_flg]" ).append("\n"); 
		query.append(",	NVL(@[cfr_flg],'N')" ).append("\n"); 
		query.append(",	BKG_COMMON_PKG.BKG_NO_GEN_FNC('DGN', @[ofc_cd], @[cre_usr_id])" ).append("\n"); 
		query.append(",	@[imdg_amdt_no]" ).append("\n"); 
		query.append(",	@[erap_no]" ).append("\n"); 
		query.append(",	@[erap_cntc_no]" ).append("\n"); 
		query.append(",	@[erap_apro_ref_no]" ).append("\n"); 
		query.append(",	@[dot_exp_no]" ).append("\n"); 
		query.append(",	@[dot_spcl_apro_no]" ).append("\n"); 
		query.append(",	@[dot_auth_no]" ).append("\n"); 
		query.append(",	@[imdg_un_no_spcl_provi_ctnt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT INTO BKG_DG_CGO (" ).append("\n"); 
		query.append("	IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append(",	CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	DCGO_SEQ" ).append("\n"); 
		query.append(",	DG_CNTR_SEQ" ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	IMDG_UN_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(",	IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(",	PRP_SHP_NM" ).append("\n"); 
		query.append(",	HZD_DESC" ).append("\n"); 
		query.append(",	MEAS_QTY" ).append("\n"); 
		query.append(",	MEAS_UT_CD" ).append("\n"); 
		query.append(",	CLOD_FLG" ).append("\n"); 
		query.append(",	SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(",	DCGO_STS_CD" ).append("\n"); 
		query.append(",	CGO_LCL_FLG" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_NO" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append(",	EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append(",	EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	EMER_TEMP_CTNT" ).append("\n"); 
		query.append(",	CTRL_TEMP_CTNT" ).append("\n"); 
		query.append(",	EMS_NO" ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",	MRN_POLUT_FLG" ).append("\n"); 
		query.append(",	PSA_NO" ).append("\n"); 
		query.append(",	CERTI_NO" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_CD2" ).append("\n"); 
		query.append(",	INTMD_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	INTMD_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",	INTMD_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(",	INTMD_IMDG_PCK_CD2" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_CD2" ).append("\n"); 
		query.append(",	MAX_IN_PCK_QTY" ).append("\n"); 
		query.append(",	MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append(",	CNEE_DTL_DESC" ).append("\n"); 
		query.append(",	NET_EXPLO_WGT" ).append("\n"); 
		query.append(",	RADA_SKD_NO" ).append("\n"); 
		query.append(",	RADA_AMT" ).append("\n"); 
		query.append(",	RADA_UT_CD" ).append("\n"); 
		query.append(",	RADA_TRSP_NO" ).append("\n"); 
		query.append(",	RC_FLG" ).append("\n"); 
		query.append(",	AWK_CGO_FLG" ).append("\n"); 
		query.append(",	BB_CGO_FLG" ).append("\n"); 
		query.append(",	RC_SEQ" ).append("\n"); 
		query.append(",	AWK_CGO_SEQ" ).append("\n"); 
		query.append(",	BB_CGO_SEQ" ).append("\n"); 
		query.append(",	HCDG_FLG" ).append("\n"); 
		query.append(",	HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	APLY_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	SPCL_RQST_FLG" ).append("\n"); 
		query.append(",	SPCL_RQST_DESC" ).append("\n"); 
		query.append(",	IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append(",	RSD_FLG" ).append("\n"); 
		query.append(",	CFR_FLG" ).append("\n"); 
		query.append(",	DCGO_REF_NO" ).append("\n"); 
		query.append(",	IMDG_AMDT_NO" ).append("\n"); 
		query.append(",	ERAP_NO" ).append("\n"); 
		query.append(",	ERAP_CNTC_NO" ).append("\n"); 
		query.append(",	ERAP_APRO_REF_NO" ).append("\n"); 
		query.append(",	DOT_EXP_NO" ).append("\n"); 
		query.append(",	DOT_SPCL_APRO_NO" ).append("\n"); 
		query.append(",	DOT_AUTH_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SPCL_PROVI_CTNT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[imdg_comp_grp_cd]" ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd4]" ).append("\n"); 
		query.append(",	@[cntr_vol_qty]" ).append("\n"); 
		query.append(",	@[bkg_no]" ).append("\n"); 
		query.append(",	@[dcgo_seq]" ).append("\n"); 
		query.append(",	@[dg_cntr_seq]" ).append("\n"); 
		query.append(",	@[cntr_cgo_seq]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[imdg_un_no]" ).append("\n"); 
		query.append(",	@[imdg_un_no_seq]" ).append("\n"); 
		query.append(",	@[imdg_clss_cd]" ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd1]" ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd2]" ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd3]" ).append("\n"); 
		query.append(",	@[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append(",	@[imdg_expt_qty_flg]" ).append("\n"); 
		query.append(",	@[net_wgt]" ).append("\n"); 
		query.append(",	@[grs_wgt]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	@[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append(",	@[prp_shp_nm]" ).append("\n"); 
		query.append(",	@[hzd_desc]" ).append("\n"); 
		query.append(",	@[meas_qty]" ).append("\n"); 
		query.append(",	@[meas_ut_cd]" ).append("\n"); 
		query.append(",	@[clod_flg]" ).append("\n"); 
		query.append(",	@[spcl_stwg_rqst_desc]" ).append("\n"); 
		query.append(",	@[dcgo_sts_cd]" ).append("\n"); 
		query.append(",	@[cgo_lcl_flg]" ).append("\n"); 
		query.append(",	@[emer_rspn_gid_no]" ).append("\n"); 
		query.append(",	@[emer_rspn_gid_chr_no]" ).append("\n"); 
		query.append(",	@[emer_cntc_phn_no_ctnt]" ).append("\n"); 
		query.append(",	@[emer_cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[emer_temp_ctnt]" ).append("\n"); 
		query.append(",	@[ctrl_temp_ctnt]" ).append("\n"); 
		query.append(",	@[ems_no]" ).append("\n"); 
		query.append(",	@[imdg_pck_grp_cd]" ).append("\n"); 
		query.append(",	@[mrn_polut_flg]" ).append("\n"); 
		query.append(",	@[psa_no]" ).append("\n"); 
		query.append(",	@[certi_no]" ).append("\n"); 
		query.append(",	@[in_imdg_pck_qty1]" ).append("\n"); 
		query.append(",	@[in_imdg_pck_cd1]" ).append("\n"); 
		query.append(",	@[in_imdg_pck_qty2]" ).append("\n"); 
		query.append(",	@[in_imdg_pck_cd2]" ).append("\n"); 
		query.append(",	@[intmd_imdg_pck_qty1]" ).append("\n"); 
		query.append(",	@[intmd_imdg_pck_cd1]" ).append("\n"); 
		query.append(",	@[intmd_imdg_pck_qty2]" ).append("\n"); 
		query.append(",	@[intmd_imdg_pck_cd2]" ).append("\n"); 
		query.append(",	@[out_imdg_pck_qty1]" ).append("\n"); 
		query.append(",	@[out_imdg_pck_cd1]" ).append("\n"); 
		query.append(",	@[out_imdg_pck_qty2]" ).append("\n"); 
		query.append(",	@[out_imdg_pck_cd2]" ).append("\n"); 
		query.append(",	@[max_in_pck_qty]" ).append("\n"); 
		query.append(",	@[max_in_pck_tp_cd]" ).append("\n"); 
		query.append(",	@[cnee_dtl_desc]" ).append("\n"); 
		query.append(",	@[net_explo_wgt]" ).append("\n"); 
		query.append(",	@[rada_skd_no]" ).append("\n"); 
		query.append(",	@[rada_amt]" ).append("\n"); 
		query.append(",	@[rada_ut_cd]" ).append("\n"); 
		query.append(",	@[rada_trsp_no]" ).append("\n"); 
		query.append(",	@[rc_flg]" ).append("\n"); 
		query.append(",	@[awk_cgo_flg]" ).append("\n"); 
		query.append(",	@[bb_cgo_flg]" ).append("\n"); 
		query.append(",	@[rc_seq]" ).append("\n"); 
		query.append(",	@[awk_cgo_seq]" ).append("\n"); 
		query.append(",	@[bb_cgo_seq]" ).append("\n"); 
		query.append(",	DECODE(@[hcdg_flg], 'HCDG', 'Y', 'N')" ).append("\n"); 
		query.append(",	@[hcdg_dpnd_qty_flg]" ).append("\n"); 
		query.append(",	@[rqst_usr_id]" ).append("\n"); 
		query.append(",	@[aply_no]" ).append("\n"); 
		query.append(",	@[spcl_cgo_apro_cd]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[spcl_rqst_flg]" ).append("\n"); 
		query.append(",	@[spcl_rqst_desc]" ).append("\n"); 
		query.append(",	@[imdg_segr_grp_no]" ).append("\n"); 
		query.append(",	@[rsd_flg]" ).append("\n"); 
		query.append(",	NVL(@[cfr_flg],'N')" ).append("\n"); 
		query.append(",	BKG_COMMON_PKG.BKG_NO_GEN_FNC('DGN', @[ofc_cd], @[cre_usr_id])" ).append("\n"); 
		query.append(",	@[imdg_amdt_no]" ).append("\n"); 
		query.append(",	@[erap_no]" ).append("\n"); 
		query.append(",	@[erap_cntc_no]" ).append("\n"); 
		query.append(",	@[erap_apro_ref_no]" ).append("\n"); 
		query.append(",	@[dot_exp_no]" ).append("\n"); 
		query.append(",	@[dot_spcl_apro_no]" ).append("\n"); 
		query.append(",	@[dot_auth_no]" ).append("\n"); 
		query.append(",	@[imdg_un_no_spcl_provi_ctnt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}