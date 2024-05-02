/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOcopyBkgXterRqstMstCSQL.java
*@FileTitle : e-Booking & SI Process Detail(TRO/O)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.22 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOcopyBkgXterRqstMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * copyBkgXterRqstMst
	  * </pre>
	  */
	public EBookingReceiptDBDAOcopyBkgXterRqstMstCSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO bkg_xter_rqst_mst" ).append("\n");
		query.append("(  xter_sndr_id,  xter_rqst_no,  xter_rqst_seq" ).append("\n");
		query.append(", BKG_NO" ).append("\n");
		query.append(", doc_tp_cd,  xter_bkg_rqst_sts_cd,  xter_rqst_via_cd" ).append("\n");
		query.append(", rqst_dt,  rqst_delt_flg" ).append("\n");
		query.append(", bkg_upld_sts_cd,  upld_dt,  upld_usr_id" ).append("\n");
		query.append(", rjct_rsn_RMK" ).append("\n");
		query.append(", SI_NO" ).append("\n");
		query.append(", bl_no_ctnt,  xter_bl_tp_cd,  bl_obrd_tp_cd,  bl_iss_loc_nm" ).append("\n");
		query.append(", BKG_OFC_cd,  SLs_OFC_cd,  SREP_CD" ).append("\n");
		query.append(", VSL_CD,  SKD_VOY_NO,  SKD_DIR_CD,  vsl_NM,  PRE_VSL_NM" ).append("\n");
		query.append(", rqst_dep_dt,  mty_pkup_dt,  SHP_EXP_DT,  rqst_ARr_DT" ).append("\n");
		query.append(", POR_CD,  POR_NM,  POL_CD,  POL_NM,  POD_CD,  POD_NM,  DEL_CD,  DEL_NM" ).append("\n");
		query.append(", org_cnt_nm, FNL_DeST_CD,  FNL_DeST_NM" ).append("\n");
		query.append(", RCV_TERM_cd,  De_TERM_cd" ).append("\n");
		query.append(", FRT_TERM_cd,  pay_loc_cd" ).append("\n");
		query.append(", Pck_QTY,  Pck_tp_CD" ).append("\n");
		query.append(", estm_WGT,  estm_WGT_ut_cd" ).append("\n");
		query.append(", MEAs_QTY,  MEAs_ut_cd" ).append("\n");
		query.append(", CMDT_CD,  CMDT_DESC,  rep_CMDT_cd" ).append("\n");
		query.append(", xter_bkg_rmk1,  xter_bkg_rmk2" ).append("\n");
		query.append(", dcgo_flg,  rc_flg,  AwK_cgo_flg" ).append("\n");
		query.append(", cust_ID,  cust_co_nm,  cntc_nm" ).append("\n");
		query.append(", cntc_phn_intl_no,  cntc_phn_area_no,  cntc_phn_no,  cntc_xtn_phn_no" ).append("\n");
		query.append(", cntc_fax_intl_no,  cntc_fax_area_no,  cntc_fax_no" ).append("\n");
		query.append(", cntc_eml" ).append("\n");
		query.append(", ntfd_mzd_cd" ).append("\n");
		query.append(", SHpr_REF_NO,  CNee_REF_NO,  Fwrd_REF_NO,  AGn_REF_NO" ).append("\n");
		query.append(", XPt_REF_no,  TRF_REF_no,  QTtn_REF_no,  PSA_NO,  pty_ref_no" ).append("\n");
		query.append(", ctrt_NO,  PO_NO,  INV_NO_ctnt,  sony_cvy_ref_no" ).append("\n");
		query.append(", LC_NO,    LC_EXP_DT" ).append("\n");
		query.append(", bl_iss_knt,  bl_cpy_knt,  hbl_knt" ).append("\n");
		query.append(", usa_cstms_file_ctnt,  usa_cstms_file_no,  SCAC_cd" ).append("\n");
		query.append(", cstms_cmdt_cd, ds_desc)" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("xter_sndr_id,  xter_rqst_no,  xter_rqst_seq+1" ).append("\n");
		query.append(", BKG_NO" ).append("\n");
		query.append(", doc_tp_cd,  xter_bkg_rqst_sts_cd,  xter_rqst_via_cd" ).append("\n");
		query.append(", rqst_dt,  rqst_delt_flg" ).append("\n");
		query.append(", bkg_upld_sts_cd,  upld_dt,  upld_usr_id" ).append("\n");
		query.append(", rjct_rsn_RMK" ).append("\n");
		query.append(", SI_NO" ).append("\n");
		query.append(", bl_no_ctnt,  xter_bl_tp_cd,  bl_obrd_tp_cd,  bl_iss_loc_nm" ).append("\n");
		query.append(", BKG_OFC_cd,  SLs_OFC_cd,  SREP_CD" ).append("\n");
		query.append(", VSL_CD,  SKD_VOY_NO,  SKD_DIR_CD,  vsl_NM,  PRE_VSL_NM" ).append("\n");
		query.append(", rqst_dep_dt,  mty_pkup_dt,  SHP_EXP_DT,  rqst_ARr_DT" ).append("\n");
		query.append(", POR_CD,  POR_NM,  POL_CD,  POL_NM,  POD_CD,  POD_NM,  DEL_CD,  DEL_NM" ).append("\n");
		query.append(", org_cnt_nm, FNL_DeST_CD,  FNL_DeST_NM" ).append("\n");
		query.append(", RCV_TERM_cd,  De_TERM_cd" ).append("\n");
		query.append(", FRT_TERM_cd,  pay_loc_cd" ).append("\n");
		query.append(", Pck_QTY,  Pck_tp_CD" ).append("\n");
		query.append(", estm_WGT,  estm_WGT_ut_cd" ).append("\n");
		query.append(", MEAs_QTY,  MEAs_ut_cd" ).append("\n");
		query.append(", CMDT_CD,  CMDT_DESC,  rep_CMDT_cd" ).append("\n");
		query.append(", xter_bkg_rmk1,  xter_bkg_rmk2" ).append("\n");
		query.append(", dcgo_flg,  rc_flg,  AwK_cgo_flg" ).append("\n");
		query.append(", cust_ID,  cust_co_nm,  cntc_nm" ).append("\n");
		query.append(", cntc_phn_intl_no,  cntc_phn_area_no,  cntc_phn_no,  cntc_xtn_phn_no" ).append("\n");
		query.append(", cntc_fax_intl_no,  cntc_fax_area_no,  cntc_fax_no" ).append("\n");
		query.append(", cntc_eml" ).append("\n");
		query.append(", ntfd_mzd_cd" ).append("\n");
		query.append(", SHpr_REF_NO,  CNee_REF_NO,  Fwrd_REF_NO,  AGn_REF_NO" ).append("\n");
		query.append(", XPt_REF_no,  TRF_REF_no,  QTtn_REF_no,  PSA_NO,  pty_ref_no" ).append("\n");
		query.append(", ctrt_NO,  PO_NO,  INV_NO_ctnt,  sony_cvy_ref_no" ).append("\n");
		query.append(", LC_NO,    LC_EXP_DT" ).append("\n");
		query.append(", bl_iss_knt,  bl_cpy_knt,  hbl_knt" ).append("\n");
		query.append(", usa_cstms_file_ctnt,  usa_cstms_file_no,  SCAC_cd" ).append("\n");
		query.append(", cstms_cmdt_cd, ds_desc" ).append("\n");
		query.append("FROM	bkg_xter_rqst_mst" ).append("\n");
		query.append("WHERE	xter_rqst_no    = @[xter_rqst_no]" ).append("\n");
		query.append("AND		xter_rqst_seq	= @[xter_rqst_seq]" ).append("\n");
		query.append("AND     xter_sndr_id    = @[xter_sndr_id]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n");
		query.append("FileName : EBookingReceiptDBDAOcopyBkgXterRqstMstCSQL").append("\n");
		query.append("*/").append("\n");
	}
}