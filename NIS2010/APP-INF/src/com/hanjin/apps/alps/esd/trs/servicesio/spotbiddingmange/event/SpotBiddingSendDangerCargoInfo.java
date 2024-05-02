/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpotBiddingSendDangerCargoInfo.java
*@FileTitle : BKG Danger Cargo Info
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event;
/**
 * WebService Document Object including Parameters<br>
 * - SpotBiddingManageRSC Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author SHIN DONG IL
 * @see SpotBiddingManageWSProxy 참조
 * @since J2EE 1.6
 */
public class SpotBiddingSendDangerCargoInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String bkg_no				  = "";
	private String eq_no            	  = "";
	private String dcgo_seq		          = "";	
	private String hcdg_flg               = "";
	private String imdg_un_no             = "";
	private String imdg_clss_cd           = "";
	private String grs_wgt                = "";
	private String net_wgt                = "";
	private String prp_shp_nm             = "";
	private String hzd_desc               = "";
	private String flsh_pnt_cdo_temp      = "";
	private String ctrl_temp_ctnt         = "";
	private String emer_temp_ctnt         = "";
	private String imdg_pck_grp_cd        = "";
	private String imdg_subs_rsk_lbl_cd1  = "";
	private String ems_no                 = "";
	private String imdg_lmt_qty_flg       = "";
	private String mrn_polut_flg          = "";
	private String emer_rspn_gid_no       = "";
	private String emer_rspn_gid_chr_no   = "";
	private String psa_no                 = "";
	private String dcgo_sts_cd            = "";
	private String emer_cntc_phn_no_ctnt  = "";
	private String certi_no               = "";
	private String cnee_dtl_desc          = "";
	private String net_explo_wgt          = "";
	private String rada_skd_no            = "";
	private String rada_amt               = "";
	private String rada_ut_cd             = "";
	private String rada_trsp_no           = "";
	private String in_imdg_pck_qty1       = "";
	private String out_imdg_pck_cd1       = "";
	private String pck_desc               = "";
	private String max_in_pck_qty         = "";
	private String in_imdg_pck_cd1        = "";
	private String pck_desc2              = "";
	private String diff_rmk               = "";

	public String getBkg_no() {
		return bkg_no;
	}
	public void setBkg_no(String bkg_no) {
		this.bkg_no = bkg_no;
	}
	public String getEq_no() {
		return eq_no;
	}
	public void setEq_no(String eq_no) {
		this.eq_no = eq_no;
	}
	public String getDcgo_seq() {
		return dcgo_seq;
	}
	public void setDcgo_seq(String dcgo_seq) {
		this.dcgo_seq = dcgo_seq;
	}
	public String getHcdg_flg() {
		return hcdg_flg;
	}
	public void setHcdg_flg(String hcdg_flg) {
		this.hcdg_flg = hcdg_flg;
	}
	public String getImdg_un_no() {
		return imdg_un_no;
	}
	public void setImdg_un_no(String imdg_un_no) {
		this.imdg_un_no = imdg_un_no;
	}
	public String getImdg_clss_cd() {
		return imdg_clss_cd;
	}
	public void setImdg_clss_cd(String imdg_clss_cd) {
		this.imdg_clss_cd = imdg_clss_cd;
	}
	public String getGrs_wgt() {
		return grs_wgt;
	}
	public void setGrs_wgt(String grs_wgt) {
		this.grs_wgt = grs_wgt;
	}
	public String getNet_wgt() {
		return net_wgt;
	}
	public void setNet_wgt(String net_wgt) {
		this.net_wgt = net_wgt;
	}
	public String getPrp_shp_nm() {
		return prp_shp_nm;
	}
	public void setPrp_shp_nm(String prp_shp_nm) {
		this.prp_shp_nm = prp_shp_nm;
	}
	public String getHzd_desc() {
		return hzd_desc;
	}
	public void setHzd_desc(String hzd_desc) {
		this.hzd_desc = hzd_desc;
	}
	public String getFlsh_pnt_cdo_temp() {
		return flsh_pnt_cdo_temp;
	}
	public void setFlsh_pnt_cdo_temp(String flsh_pnt_cdo_temp) {
		this.flsh_pnt_cdo_temp = flsh_pnt_cdo_temp;
	}
	public String getCtrl_temp_ctnt() {
		return ctrl_temp_ctnt;
	}
	public void setCtrl_temp_ctnt(String ctrl_temp_ctnt) {
		this.ctrl_temp_ctnt = ctrl_temp_ctnt;
	}
	public String getEmer_temp_ctnt() {
		return emer_temp_ctnt;
	}
	public void setEmer_temp_ctnt(String emer_temp_ctnt) {
		this.emer_temp_ctnt = emer_temp_ctnt;
	}
	public String getImdg_pck_grp_cd() {
		return imdg_pck_grp_cd;
	}
	public void setImdg_pck_grp_cd(String imdg_pck_grp_cd) {
		this.imdg_pck_grp_cd = imdg_pck_grp_cd;
	}
	public String getImdg_subs_rsk_lbl_cd1() {
		return imdg_subs_rsk_lbl_cd1;
	}
	public void setImdg_subs_rsk_lbl_cd1(String imdg_subs_rsk_lbl_cd1) {
		this.imdg_subs_rsk_lbl_cd1 = imdg_subs_rsk_lbl_cd1;
	}
	public String getEms_no() {
		return ems_no;
	}
	public void setEms_no(String ems_no) {
		this.ems_no = ems_no;
	}
	public String getImdg_lmt_qty_flg() {
		return imdg_lmt_qty_flg;
	}
	public void setImdg_lmt_qty_flg(String imdg_lmt_qty_flg) {
		this.imdg_lmt_qty_flg = imdg_lmt_qty_flg;
	}
	public String getMrn_polut_flg() {
		return mrn_polut_flg;
	}
	public void setMrn_polut_flg(String mrn_polut_flg) {
		this.mrn_polut_flg = mrn_polut_flg;
	}
	public String getEmer_rspn_gid_no() {
		return emer_rspn_gid_no;
	}
	public void setEmer_rspn_gid_no(String emer_rspn_gid_no) {
		this.emer_rspn_gid_no = emer_rspn_gid_no;
	}
	public String getEmer_rspn_gid_chr_no() {
		return emer_rspn_gid_chr_no;
	}
	public void setEmer_rspn_gid_chr_no(String emer_rspn_gid_chr_no) {
		this.emer_rspn_gid_chr_no = emer_rspn_gid_chr_no;
	}
	public String getPsa_no() {
		return psa_no;
	}
	public void setPsa_no(String psa_no) {
		this.psa_no = psa_no;
	}
	public String getDcgo_sts_cd() {
		return dcgo_sts_cd;
	}
	public void setDcgo_sts_cd(String dcgo_sts_cd) {
		this.dcgo_sts_cd = dcgo_sts_cd;
	}
	public String getEmer_cntc_phn_no_ctnt() {
		return emer_cntc_phn_no_ctnt;
	}
	public void setEmer_cntc_phn_no_ctnt(String emer_cntc_phn_no_ctnt) {
		this.emer_cntc_phn_no_ctnt = emer_cntc_phn_no_ctnt;
	}
	public String getCerti_no() {
		return certi_no;
	}
	public void setCerti_no(String certi_no) {
		this.certi_no = certi_no;
	}
	public String getCnee_dtl_desc() {
		return cnee_dtl_desc;
	}
	public void setCnee_dtl_desc(String cnee_dtl_desc) {
		this.cnee_dtl_desc = cnee_dtl_desc;
	}
	public String getNet_explo_wgt() {
		return net_explo_wgt;
	}
	public void setNet_explo_wgt(String net_explo_wgt) {
		this.net_explo_wgt = net_explo_wgt;
	}
	public String getRada_skd_no() {
		return rada_skd_no;
	}
	public void setRada_skd_no(String rada_skd_no) {
		this.rada_skd_no = rada_skd_no;
	}
	public String getRada_amt() {
		return rada_amt;
	}
	public void setRada_amt(String rada_amt) {
		this.rada_amt = rada_amt;
	}
	public String getRada_ut_cd() {
		return rada_ut_cd;
	}
	public void setRada_ut_cd(String rada_ut_cd) {
		this.rada_ut_cd = rada_ut_cd;
	}
	public String getRada_trsp_no() {
		return rada_trsp_no;
	}
	public void setRada_trsp_no(String rada_trsp_no) {
		this.rada_trsp_no = rada_trsp_no;
	}
	public String getIn_imdg_pck_qty1() {
		return in_imdg_pck_qty1;
	}
	public void setIn_imdg_pck_qty1(String in_imdg_pck_qty1) {
		this.in_imdg_pck_qty1 = in_imdg_pck_qty1;
	}
	public String getOut_imdg_pck_cd1() {
		return out_imdg_pck_cd1;
	}
	public void setOut_imdg_pck_cd1(String out_imdg_pck_cd1) {
		this.out_imdg_pck_cd1 = out_imdg_pck_cd1;
	}
	public String getPck_desc() {
		return pck_desc;
	}
	public void setPck_desc(String pck_desc) {
		this.pck_desc = pck_desc;
	}
	public String getMax_in_pck_qty() {
		return max_in_pck_qty;
	}
	public void setMax_in_pck_qty(String max_in_pck_qty) {
		this.max_in_pck_qty = max_in_pck_qty;
	}
	public String getIn_imdg_pck_cd1() {
		return in_imdg_pck_cd1;
	}
	public void setIn_imdg_pck_cd1(String in_imdg_pck_cd1) {
		this.in_imdg_pck_cd1 = in_imdg_pck_cd1;
	}
	public String getPck_desc2() {
		return pck_desc2;
	}
	public void setPck_desc2(String pck_desc2) {
		this.pck_desc2 = pck_desc2;
	}
	public String getDiff_rmk() {
		return diff_rmk;
	}
	public void setDiff_rmk(String diff_rmk) {
		this.diff_rmk = diff_rmk;
	}
}