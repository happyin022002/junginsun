/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpotBiddingSendAwkwardCargoInfo.java
*@FileTitle : BKG Awkward Cargo Info
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
public class SpotBiddingSendAwkwardCargoInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String bkg_no		= "";
	private String eq_no            = "";
	private String pck_tp_cd        = "";
	private String pck_qty          = "";
	private String grs_wgt_tp_cd    = "";
	private String net_wgt_tp_cd    = "";
	private String grs_wgt          = "";
	private String net_wgt          = "";
	private String cmdt_cd          = "";
	private String cmdt_nm          = "";
	private String ttl_dim_len      = "";
	private String ttl_dim_wdt      = "";
	private String ttl_dim_hgt      = "";
	private String ovr_fwrd_len     = "";
	private String ovr_bkwd_len     = "";
	private String ovr_hgt          = "";
	private String ovr_lf_len       = "";
	private String ovr_rt_len       = "";
	private String stwg_rqst_desc   = "";
	private String ovr_void_slt_qty = "";
	private String diff_rmk         = "";
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
	public String getPck_tp_cd() {
		return pck_tp_cd;
	}
	public void setPck_tp_cd(String pck_tp_cd) {
		this.pck_tp_cd = pck_tp_cd;
	}
	public String getPck_qty() {
		return pck_qty;
	}
	public void setPck_qty(String pck_qty) {
		this.pck_qty = pck_qty;
	}
	public String getGrs_wgt_tp_cd() {
		return grs_wgt_tp_cd;
	}
	public void setGrs_wgt_tp_cd(String grs_wgt_tp_cd) {
		this.grs_wgt_tp_cd = grs_wgt_tp_cd;
	}
	public String getNet_wgt_tp_cd() {
		return net_wgt_tp_cd;
	}
	public void setNet_wgt_tp_cd(String net_wgt_tp_cd) {
		this.net_wgt_tp_cd = net_wgt_tp_cd;
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
	public String getCmdt_cd() {
		return cmdt_cd;
	}
	public void setCmdt_cd(String cmdt_cd) {
		this.cmdt_cd = cmdt_cd;
	}
	public String getCmdt_nm() {
		return cmdt_nm;
	}
	public void setCmdt_nm(String cmdt_nm) {
		this.cmdt_nm = cmdt_nm;
	}
	public String getTtl_dim_len() {
		return ttl_dim_len;
	}
	public void setTtl_dim_len(String ttl_dim_len) {
		this.ttl_dim_len = ttl_dim_len;
	}
	public String getTtl_dim_wdt() {
		return ttl_dim_wdt;
	}
	public void setTtl_dim_wdt(String ttl_dim_wdt) {
		this.ttl_dim_wdt = ttl_dim_wdt;
	}
	public String getTtl_dim_hgt() {
		return ttl_dim_hgt;
	}
	public void setTtl_dim_hgt(String ttl_dim_hgt) {
		this.ttl_dim_hgt = ttl_dim_hgt;
	}
	public String getOvr_fwrd_len() {
		return ovr_fwrd_len;
	}
	public void setOvr_fwrd_len(String ovr_fwrd_len) {
		this.ovr_fwrd_len = ovr_fwrd_len;
	}
	public String getOvr_bkwd_len() {
		return ovr_bkwd_len;
	}
	public void setOvr_bkwd_len(String ovr_bkwd_len) {
		this.ovr_bkwd_len = ovr_bkwd_len;
	}
	public String getOvr_hgt() {
		return ovr_hgt;
	}
	public void setOvr_hgt(String ovr_hgt) {
		this.ovr_hgt = ovr_hgt;
	}
	public String getOvr_lf_len() {
		return ovr_lf_len;
	}
	public void setOvr_lf_len(String ovr_lf_len) {
		this.ovr_lf_len = ovr_lf_len;
	}
	public String getOvr_rt_len() {
		return ovr_rt_len;
	}
	public void setOvr_rt_len(String ovr_rt_len) {
		this.ovr_rt_len = ovr_rt_len;
	}
	public String getStwg_rqst_desc() {
		return stwg_rqst_desc;
	}
	public void setStwg_rqst_desc(String stwg_rqst_desc) {
		this.stwg_rqst_desc = stwg_rqst_desc;
	}
	public String getOvr_void_slt_qty() {
		return ovr_void_slt_qty;
	}
	public void setOvr_void_slt_qty(String ovr_void_slt_qty) {
		this.ovr_void_slt_qty = ovr_void_slt_qty;
	}
	public String getDiff_rmk() {
		return diff_rmk;
	}
	public void setDiff_rmk(String diff_rmk) {
		this.diff_rmk = diff_rmk;
	}
	
}