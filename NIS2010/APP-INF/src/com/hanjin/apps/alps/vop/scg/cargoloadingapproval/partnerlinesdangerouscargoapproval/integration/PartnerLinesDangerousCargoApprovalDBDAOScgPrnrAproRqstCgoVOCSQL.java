/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.27
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2014.10.27 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Won, Jong-Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO APVL for Partner Lines 의 Request Cago 생성
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_n2nd_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_dtl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_sd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rada_trsp_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwrd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_lcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dim_wdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_in_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_n2nd_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_n2nd_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("intmd_n1st_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_n1st_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flsh_pnt_cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_explo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n1st_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n2nd_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_co_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n4th_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("emer_rspn_gid_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n2nd_imdg_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_in_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("void_slt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_n1st_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkwd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n2nd_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("emer_rspn_gid_chr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n1st_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("intmd_n2nd_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hgt_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_n1st_imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_expt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lf_sd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dim_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVOCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_PRNR_APRO_RQST_CGO (" ).append("\n"); 
		query.append("	OUT_N1ST_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	OUT_N1ST_IMDG_PCK_CD" ).append("\n"); 
		query.append(",	OUT_N2ND_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	OUT_N2ND_IMDG_PCK_CD" ).append("\n"); 
		query.append(",	MAX_IN_PCK_QTY" ).append("\n"); 
		query.append(",	MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append(",	CNEE_DTL_DESC" ).append("\n"); 
		query.append(",	NET_EXPLO_WGT" ).append("\n"); 
		query.append(",	RADA_SKD_NO" ).append("\n"); 
		query.append(",	RADA_AMT" ).append("\n"); 
		query.append(",	RADA_UT_CD" ).append("\n"); 
		query.append(",	RADA_TRSP_NO" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	CGO_RQST_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	CRR_CD" ).append("\n"); 
		query.append(",	BKG_REF_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append(",	SPCL_CNTR_SEQ" ).append("\n"); 
		query.append(",	SPCL_CGO_SEQ" ).append("\n"); 
		query.append(",	IMDG_UN_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	N1ST_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",	N2ND_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",	N3RD_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",	N4TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",	IMDG_CO_GRP_CD" ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(",	IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append(",	MRN_POLUT_FLG" ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(",	PRP_SHP_NM" ).append("\n"); 
		query.append(",	HZD_DESC" ).append("\n"); 
		query.append(",	DCGO_STS_CD" ).append("\n"); 
		query.append(",	MEAS_QTY" ).append("\n"); 
		query.append(",	MEAS_TP_CD" ).append("\n"); 
		query.append(",	PCK_QTY" ).append("\n"); 
		query.append(",	PCK_TP_CD" ).append("\n"); 
		query.append(",	CLOD_FLG" ).append("\n"); 
		query.append(",	SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(",	CGO_LCL_FLG" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_NO" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append(",	EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append(",	EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	EMER_TEMP_CTNT" ).append("\n"); 
		query.append(",	CTRL_TEMP_CTNT" ).append("\n"); 
		query.append(",	EMS_NO" ).append("\n"); 
		query.append(",	CMDT_DESC" ).append("\n"); 
		query.append(",	TTL_DIM_LEN" ).append("\n"); 
		query.append(",	TTL_DIM_WDT" ).append("\n"); 
		query.append(",	TTL_DIM_HGT" ).append("\n"); 
		query.append(",	FWRD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	BKWD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	HGT_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	LF_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	VOID_SLT_QTY" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	PSA_NO" ).append("\n"); 
		query.append(",	IMDG_SEGR_GRP_NO " ).append("\n"); 
		query.append(",	IN_N1ST_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	IN_N1ST_IMDG_PCK_CD" ).append("\n"); 
		query.append(",	IN_N2ND_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	IN_N2ND_IMDG_PCK_CD" ).append("\n"); 
		query.append(",	INTMD_N1ST_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	INTMD_N1ST_IMDG_PCK_CD" ).append("\n"); 
		query.append(",	INTMD_N2ND_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	INTMD_N2ND_IMDG_PCK_CD" ).append("\n"); 
		query.append(",	SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	CNTR_REF_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	AUTH_STS_CD" ).append("\n"); 
		query.append(",   APRO_REF_NO" ).append("\n"); 
		query.append(",   CGO_OPR_CD" ).append("\n"); 
		query.append(",	EAI_IF_FLG" ).append("\n"); 
		query.append(", EAI_EVNT_DT" ).append("\n"); 
		query.append(", EAI_IF_ID" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[out_n1st_imdg_pck_qty]" ).append("\n"); 
		query.append(",	@[out_n1st_imdg_pck_cd]" ).append("\n"); 
		query.append(",	@[out_n2nd_imdg_pck_qty]" ).append("\n"); 
		query.append(",	@[out_n2nd_imdg_pck_cd]" ).append("\n"); 
		query.append(",	@[max_in_pck_qty]" ).append("\n"); 
		query.append(",	@[max_in_pck_tp_cd]" ).append("\n"); 
		query.append(",	@[cnee_dtl_desc]" ).append("\n"); 
		query.append(",	@[net_explo_wgt]" ).append("\n"); 
		query.append(",	@[rada_skd_no]" ).append("\n"); 
		query.append(",	@[rada_amt]" ).append("\n"); 
		query.append(",	@[rada_ut_cd]" ).append("\n"); 
		query.append(",	@[rada_trsp_no]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[auth_ofc_cd]),SYSDATE) " ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[crr_cd]" ).append("\n"); 
		query.append(",	@[bkg_ref_no]" ).append("\n"); 
		query.append(",	@[spcl_cgo_rqst_seq]" ).append("\n"); 
		query.append(",	@[spcl_cntr_seq]" ).append("\n"); 
		query.append(",	@[spcl_cgo_seq]" ).append("\n"); 
		query.append(",	@[imdg_un_no]" ).append("\n"); 
		query.append(",	@[imdg_un_no_seq]" ).append("\n"); 
		query.append(",	@[imdg_clss_cd]" ).append("\n"); 
		query.append(",	@[n1st_imdg_subs_rsk_lbl_cd]" ).append("\n"); 
		query.append(",	@[n2nd_imdg_subs_rsk_lbl_cd]" ).append("\n"); 
		query.append(",	@[n3rd_imdg_subs_rsk_lbl_cd]" ).append("\n"); 
		query.append(",	@[n4th_imdg_subs_rsk_lbl_cd]" ).append("\n"); 
		query.append(",	@[imdg_co_grp_cd]" ).append("\n"); 
		query.append(",	DECODE(@[imdg_pck_grp_cd],'I','1','II','2','III','3','')" ).append("\n"); 
		query.append(",	@[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append(",	@[imdg_expt_qty_flg]" ).append("\n"); 
		query.append(",	@[mrn_polut_flg]" ).append("\n"); 
		query.append(",	@[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append(",	@[prp_shp_nm]" ).append("\n"); 
		query.append(",	@[hzd_desc]" ).append("\n"); 
		query.append(",	@[dcgo_sts_cd]" ).append("\n"); 
		query.append(",	@[meas_qty]" ).append("\n"); 
		query.append(",	@[meas_tp_cd]" ).append("\n"); 
		query.append(",	@[pck_qty]" ).append("\n"); 
		query.append(",	@[pck_tp_cd]" ).append("\n"); 
		query.append(",	@[clod_flg]" ).append("\n"); 
		query.append(",	@[spcl_stwg_rqst_desc]" ).append("\n"); 
		query.append(",	@[cgo_lcl_flg]" ).append("\n"); 
		query.append(",	@[emer_rspn_gid_no]" ).append("\n"); 
		query.append(",	@[emer_rspn_gid_chr_no]" ).append("\n"); 
		query.append(",	@[emer_cntc_phn_no]" ).append("\n"); 
		query.append(",	@[emer_cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[emer_temp_ctnt]" ).append("\n"); 
		query.append(",	@[ctrl_temp_ctnt]" ).append("\n"); 
		query.append(",	@[ems_no]" ).append("\n"); 
		query.append(",	@[cmdt_desc]" ).append("\n"); 
		query.append(",	@[ttl_dim_len]" ).append("\n"); 
		query.append(",	@[ttl_dim_wdt]" ).append("\n"); 
		query.append(",	@[ttl_dim_hgt]" ).append("\n"); 
		query.append(",	@[fwrd_ovr_dim_len]" ).append("\n"); 
		query.append(",	@[bkwd_ovr_dim_len]" ).append("\n"); 
		query.append(",	@[hgt_ovr_dim_len]" ).append("\n"); 
		query.append(",	@[lf_sd_ovr_dim_len]" ).append("\n"); 
		query.append(",	@[rt_sd_ovr_dim_len]" ).append("\n"); 
		query.append(",	@[void_slt_qty]" ).append("\n"); 
		query.append(",	@[net_wgt]" ).append("\n"); 
		query.append(",	@[grs_wgt]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	@[psa_no]" ).append("\n"); 
		query.append(",	@[imdg_segr_grp_no]" ).append("\n"); 
		query.append(",	@[in_n1st_imdg_pck_qty]" ).append("\n"); 
		query.append(",	@[in_n1st_imdg_pck_cd]" ).append("\n"); 
		query.append(",	@[in_n2nd_imdg_pck_qty]" ).append("\n"); 
		query.append(",	@[in_n2nd_imdg_pck_cd]" ).append("\n"); 
		query.append(",	@[intmd_n1st_imdg_pck_qty]" ).append("\n"); 
		query.append(",	@[intmd_n1st_imdg_pck_cd]" ).append("\n"); 
		query.append(",	@[intmd_n2nd_imdg_pck_qty]" ).append("\n"); 
		query.append(",	@[intmd_n2nd_imdg_pck_cd]" ).append("\n"); 
		query.append(",	@[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append(",	@[cntr_ref_no]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[auth_sts_cd]" ).append("\n"); 
		query.append(",	@[apro_ref_no]" ).append("\n"); 
		query.append(",	@[cgo_opr_cd]" ).append("\n"); 
		query.append(", 'Y'" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[eai_if_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}