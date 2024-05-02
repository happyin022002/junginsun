/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAODgCgoListVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.05
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.11.05 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAODgCgoListVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgCgoListVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAODgCgoListVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rada_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_rqst_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clod_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_cgo_apro_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_subs_rsk_lbl_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_in_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_imdg_pck_cd2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mrn_polut_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flsh_pnt_cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hcdg_dpnd_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hzd_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hzd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_stwg_rqst_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_qty2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_rspn_gid_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("certi_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_temp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("emer_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rada_skd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_subs_rsk_lbl_cd1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("emer_rspn_gid_chr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_rqst_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ems_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_qty2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_rqst_grp_eml2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_rqst_grp_eml1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stwg_temp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_capa_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAODgCgoListVOUSQL").append("\n"); 
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
		query.append("UPDATE BKG_DG_CGO_HIS SET " ).append("\n"); 
		query.append("	IMDG_COMP_GRP_CD = @[imdg_comp_grp_cd]" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD4 = @[imdg_subs_rsk_lbl_cd4]" ).append("\n"); 
		query.append(",	CNTR_VOL_QTY = @[cntr_vol_qty]" ).append("\n"); 
		query.append(",	DG_CNTR_SEQ = @[dg_cntr_seq]" ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ = @[cntr_cgo_seq]" ).append("\n"); 
		query.append(",	CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD1 = @[imdg_subs_rsk_lbl_cd1]" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD2 = @[imdg_subs_rsk_lbl_cd2]" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD3 = @[imdg_subs_rsk_lbl_cd3]" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_FLG = @[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append(",	IMDG_EXPT_QTY_FLG = @[imdg_expt_qty_flg]" ).append("\n"); 
		query.append(",	NET_WGT = @[net_wgt]" ).append("\n"); 
		query.append(",	GRS_WGT = @[grs_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP = @[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append(",	PRP_SHP_NM = @[prp_shp_nm]" ).append("\n"); 
		query.append(",	HZD_DESC = @[hzd_desc]" ).append("\n"); 
		query.append(",	MEAS_QTY = @[meas_qty]" ).append("\n"); 
		query.append(",	MEAS_UT_CD = @[meas_ut_cd]" ).append("\n"); 
		query.append(",	CLOD_FLG = @[clod_flg]" ).append("\n"); 
		query.append(",	SPCL_STWG_RQST_DESC = @[spcl_stwg_rqst_desc]" ).append("\n"); 
		query.append(",	DCGO_STS_CD = @[dcgo_sts_cd]" ).append("\n"); 
		query.append(",	CGO_LCL_FLG = @[cgo_lcl_flg]" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_NO = @[emer_rspn_gid_no]" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_CHR_NO = @[emer_rspn_gid_chr_no]" ).append("\n"); 
		query.append(",	EMER_CNTC_PHN_NO_CTNT = @[emer_cntc_phn_no_ctnt]" ).append("\n"); 
		query.append(",	EMER_CNTC_PSON_NM = @[emer_cntc_pson_nm]" ).append("\n"); 
		query.append(",	DCGO_RQST_GRP_EML1 = @[dcgo_rqst_grp_eml1]" ).append("\n"); 
		query.append(",	DCGO_RQST_GRP_EML2 = @[dcgo_rqst_grp_eml2]" ).append("\n"); 
		query.append(",	EMER_TEMP_CTNT = @[emer_temp_ctnt]" ).append("\n"); 
		query.append(",	CTRL_TEMP_CTNT = @[ctrl_temp_ctnt]" ).append("\n"); 
		query.append(",	EMS_NO = @[ems_no]" ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD = @[imdg_pck_grp_cd]" ).append("\n"); 
		query.append(",	MRN_POLUT_FLG = @[mrn_polut_flg]" ).append("\n"); 
		query.append(",	PSA_NO = @[psa_no]" ).append("\n"); 
		query.append(",	CERTI_NO = @[certi_no]" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_QTY1 = @[in_imdg_pck_qty1]" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_CD1 = @[in_imdg_pck_cd1]" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_QTY2 = @[in_imdg_pck_qty2]" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_CD2 = @[in_imdg_pck_cd2]" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_QTY1 = @[out_imdg_pck_qty1]" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_CD1 = @[out_imdg_pck_cd1]" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_QTY2 = @[out_imdg_pck_qty2]" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_CD2 = @[out_imdg_pck_cd2]" ).append("\n"); 
		query.append(",	MAX_IN_PCK_QTY = @[max_in_pck_qty]" ).append("\n"); 
		query.append(",	MAX_IN_PCK_TP_CD = @[max_in_pck_tp_cd]" ).append("\n"); 
		query.append(",	CNEE_DTL_DESC = @[cnee_dtl_desc]" ).append("\n"); 
		query.append(",	NET_EXPLO_WGT = @[net_explo_wgt]" ).append("\n"); 
		query.append(",	RADA_SKD_NO = @[rada_skd_no]" ).append("\n"); 
		query.append(",	RADA_AMT = @[rada_amt]" ).append("\n"); 
		query.append(",	RADA_UT_CD = @[rada_ut_cd]" ).append("\n"); 
		query.append(",	RADA_TRSP_NO = @[rada_trsp_no]" ).append("\n"); 
		query.append(",	RC_FLG = @[rc_flg]" ).append("\n"); 
		query.append(",	AWK_CGO_FLG = @[awk_cgo_flg]" ).append("\n"); 
		query.append(",	BB_CGO_FLG = @[bb_cgo_flg]" ).append("\n"); 
		query.append(",	RC_SEQ = @[rc_seq]" ).append("\n"); 
		query.append(",	AWK_CGO_SEQ = @[awk_cgo_seq]" ).append("\n"); 
		query.append(",	BB_CGO_SEQ = @[bb_cgo_seq]" ).append("\n"); 
		query.append(",	HCDG_FLG = @[hcdg_flg]" ).append("\n"); 
		query.append(",	HCDG_DPND_QTY_FLG = @[hcdg_dpnd_qty_flg]" ).append("\n"); 
		query.append(",	APLY_NO = @[aply_no]" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD = @[spcl_cgo_apro_cd]" ).append("\n"); 
		query.append(",	DIFF_RMK = @[diff_rmk]" ).append("\n"); 
		query.append(",	SPCL_RQST_FLG = @[spcl_rqst_flg]" ).append("\n"); 
		query.append(",	SPCL_RQST_DESC = @[spcl_rqst_desc]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append(",   HZD_CTNT = @[hzd_ctnt]" ).append("\n"); 
		query.append(",   STWG_TEMP_CTNT = @[stwg_temp_ctnt]" ).append("\n"); 
		query.append(",	GRS_CAPA_QTY = @[grs_capa_qty]" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	DCGO_SEQ = @[dcgo_seq]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE BKG_DG_CGO SET " ).append("\n"); 
		query.append("	IMDG_COMP_GRP_CD = @[imdg_comp_grp_cd]" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD4 = @[imdg_subs_rsk_lbl_cd4]" ).append("\n"); 
		query.append(",	CNTR_VOL_QTY = @[cntr_vol_qty]" ).append("\n"); 
		query.append(",	DG_CNTR_SEQ = @[dg_cntr_seq]" ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ = @[cntr_cgo_seq]" ).append("\n"); 
		query.append(",	CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD1 = @[imdg_subs_rsk_lbl_cd1]" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD2 = @[imdg_subs_rsk_lbl_cd2]" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD3 = @[imdg_subs_rsk_lbl_cd3]" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_FLG = @[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append(",	IMDG_EXPT_QTY_FLG = @[imdg_expt_qty_flg]" ).append("\n"); 
		query.append(",	NET_WGT = @[net_wgt]" ).append("\n"); 
		query.append(",	GRS_WGT = @[grs_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP = @[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append(",	PRP_SHP_NM = @[prp_shp_nm]" ).append("\n"); 
		query.append(",	HZD_DESC = @[hzd_desc]" ).append("\n"); 
		query.append(",	MEAS_QTY = @[meas_qty]" ).append("\n"); 
		query.append(",	MEAS_UT_CD = @[meas_ut_cd]" ).append("\n"); 
		query.append(",	CLOD_FLG = @[clod_flg]" ).append("\n"); 
		query.append(",	SPCL_STWG_RQST_DESC = @[spcl_stwg_rqst_desc]" ).append("\n"); 
		query.append(",	DCGO_STS_CD = @[dcgo_sts_cd]" ).append("\n"); 
		query.append(",	CGO_LCL_FLG = @[cgo_lcl_flg]" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_NO = @[emer_rspn_gid_no]" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_CHR_NO = @[emer_rspn_gid_chr_no]" ).append("\n"); 
		query.append(",	EMER_CNTC_PHN_NO_CTNT = @[emer_cntc_phn_no_ctnt]" ).append("\n"); 
		query.append(",	EMER_CNTC_PSON_NM = @[emer_cntc_pson_nm]" ).append("\n"); 
		query.append(",	DCGO_RQST_GRP_EML1 = @[dcgo_rqst_grp_eml1]" ).append("\n"); 
		query.append(",	DCGO_RQST_GRP_EML2 = @[dcgo_rqst_grp_eml2]" ).append("\n"); 
		query.append(",	EMER_TEMP_CTNT = @[emer_temp_ctnt]" ).append("\n"); 
		query.append(",	CTRL_TEMP_CTNT = @[ctrl_temp_ctnt]" ).append("\n"); 
		query.append(",	EMS_NO = @[ems_no]" ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD = @[imdg_pck_grp_cd]" ).append("\n"); 
		query.append(",	MRN_POLUT_FLG = @[mrn_polut_flg]" ).append("\n"); 
		query.append(",	PSA_NO = @[psa_no]" ).append("\n"); 
		query.append(",	CERTI_NO = @[certi_no]" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_QTY1 = @[in_imdg_pck_qty1]" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_CD1 = @[in_imdg_pck_cd1]" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_QTY2 = @[in_imdg_pck_qty2]" ).append("\n"); 
		query.append(",	IN_IMDG_PCK_CD2 = @[in_imdg_pck_cd2]" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_QTY1 = @[out_imdg_pck_qty1]" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_CD1 = @[out_imdg_pck_cd1]" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_QTY2 = @[out_imdg_pck_qty2]" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_CD2 = @[out_imdg_pck_cd2]" ).append("\n"); 
		query.append(",	MAX_IN_PCK_QTY = @[max_in_pck_qty]" ).append("\n"); 
		query.append(",	MAX_IN_PCK_TP_CD = @[max_in_pck_tp_cd]" ).append("\n"); 
		query.append(",	CNEE_DTL_DESC = @[cnee_dtl_desc]" ).append("\n"); 
		query.append(",	NET_EXPLO_WGT = @[net_explo_wgt]" ).append("\n"); 
		query.append(",	RADA_SKD_NO = @[rada_skd_no]" ).append("\n"); 
		query.append(",	RADA_AMT = @[rada_amt]" ).append("\n"); 
		query.append(",	RADA_UT_CD = @[rada_ut_cd]" ).append("\n"); 
		query.append(",	RADA_TRSP_NO = @[rada_trsp_no]" ).append("\n"); 
		query.append(",	RC_FLG = @[rc_flg]" ).append("\n"); 
		query.append(",	AWK_CGO_FLG = @[awk_cgo_flg]" ).append("\n"); 
		query.append(",	BB_CGO_FLG = @[bb_cgo_flg]" ).append("\n"); 
		query.append(",	RC_SEQ = @[rc_seq]" ).append("\n"); 
		query.append(",	AWK_CGO_SEQ = @[awk_cgo_seq]" ).append("\n"); 
		query.append(",	BB_CGO_SEQ = @[bb_cgo_seq]" ).append("\n"); 
		query.append(",	HCDG_FLG = @[hcdg_flg]" ).append("\n"); 
		query.append(",	HCDG_DPND_QTY_FLG = @[hcdg_dpnd_qty_flg]" ).append("\n"); 
		query.append(",	APLY_NO = @[aply_no]" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD = @[spcl_cgo_apro_cd]" ).append("\n"); 
		query.append(",	DIFF_RMK = @[diff_rmk]" ).append("\n"); 
		query.append(",	SPCL_RQST_FLG = @[spcl_rqst_flg]" ).append("\n"); 
		query.append(",	SPCL_RQST_DESC = @[spcl_rqst_desc]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append(",   HZD_CTNT = @[hzd_ctnt]" ).append("\n"); 
		query.append(",   STWG_TEMP_CTNT = @[stwg_temp_ctnt]" ).append("\n"); 
		query.append(",	GRS_CAPA_QTY = @[grs_capa_qty]" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	DCGO_SEQ = @[dcgo_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}