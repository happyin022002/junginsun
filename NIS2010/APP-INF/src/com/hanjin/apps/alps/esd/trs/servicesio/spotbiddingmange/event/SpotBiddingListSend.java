/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingListSendEvent.java
*@FileTitle : Spot Bidding Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-22
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-06-22 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event;

import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.SpotBiddingManageRSC;
/**
* DTO(Data Transfer Object including Parameters)<br>
* RailBillingReqCreateRSC에서 작성<br>
* - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
*
* @author SHIN DONG IL
* @see SpotBiddingManageRSC 참조
* @since J2EE 1.6
*/
public class SpotBiddingListSend implements java.io.Serializable {
	
	private String bid_no = "";
	private String bid_due_dt = "";
	private String bid_sts_cd = "";
	private String bkg_no = "";
	private String wo_no = "";
	private String bid_vndr_seq = "";
	private String eq_no = "";
	private String eq_tpsz_cd = "";
	private String trsp_cost_dtl_mod_cd = "";
	private String trsp_crr_mod_cd = "";
	private String cgo_tp_cd = "";
	private String spcl_cgo_cntr_tp_cd = "";
	private String trsp_bnd_cd = "";
	private String cntr_kgs_wgt = "";
	private String cntr_lbs_wgt = "";
	private String fm_nod_cd = "";
	private String fm_nod_nm = "";
	private String fm_nod_addr = "";
	private String via_nod_cd = "";
	private String via_nod_nm = "";
	private String via_nod_addr = "";
	private String dor_nod_cd = "";
	private String dor_nod_nm = "";
	private String dor_nod_addr = "";
	private String to_nod_cd = "";
	private String to_nod_nm = "";
	private String to_nod_addr = "";
	private String fm_dept_dt = "";
	private String to_arvl_dt = "";
	private String dor_arvl_dt = "";
	private String low_bid_amt = "";
	private String bid_curr_cd = "";
	private String bid_amt = "";
	private String bid_win_flg = "";
	private String bid_vndr_sts_cd = "";
	private String locl_low_bid_curr_cd = "";
	private String locl_low_bid_amt = "";
	
	public String getBid_no() {
		return bid_no;
	}
	public void setBid_no(String bid_no) {
		this.bid_no = bid_no;
	}
	public String getBid_due_dt() {
		return bid_due_dt;
	}
	public void setBid_due_dt(String bid_due_dt) {
		this.bid_due_dt = bid_due_dt;
	}
	public String getBid_sts_cd() {
		return bid_sts_cd;
	}
	public void setBid_sts_cd(String bid_sts_cd) {
		this.bid_sts_cd = bid_sts_cd;
	}
	public String getBkg_no() {
		return bkg_no;
	}
	public void setBkg_no(String bkg_no) {
		this.bkg_no = bkg_no;
	}
	public String getWo_no() {
		return wo_no;
	}
	public void setWo_no(String wo_no) {
		this.wo_no = wo_no;
	}
	public String getBid_vndr_seq() {
		return bid_vndr_seq;
	}
	public void setBid_vndr_seq(String bid_vndr_seq) {
		this.bid_vndr_seq = bid_vndr_seq;
	}
	public String getEq_no() {
		return eq_no;
	}
	public void setEq_no(String eq_no) {
		this.eq_no = eq_no;
	}
	public String getEq_tpsz_cd() {
		return eq_tpsz_cd;
	}
	public void setEq_tpsz_cd(String eq_tpsz_cd) {
		this.eq_tpsz_cd = eq_tpsz_cd;
	}
	public String getTrsp_cost_dtl_mod_cd() {
		return trsp_cost_dtl_mod_cd;
	}
	public void setTrsp_cost_dtl_mod_cd(String trsp_cost_dtl_mod_cd) {
		this.trsp_cost_dtl_mod_cd = trsp_cost_dtl_mod_cd;
	}
	public String getTrsp_crr_mod_cd() {
		return trsp_crr_mod_cd;
	}
	public void setTrsp_crr_mod_cd(String trsp_crr_mod_cd) {
		this.trsp_crr_mod_cd = trsp_crr_mod_cd;
	}
	public String getCgo_tp_cd() {
		return cgo_tp_cd;
	}
	public void setCgo_tp_cd(String cgo_tp_cd) {
		this.cgo_tp_cd = cgo_tp_cd;
	}
	public String getSpcl_cgo_cntr_tp_cd() {
		return spcl_cgo_cntr_tp_cd;
	}
	public void setSpcl_cgo_cntr_tp_cd(String spcl_cgo_cntr_tp_cd) {
		this.spcl_cgo_cntr_tp_cd = spcl_cgo_cntr_tp_cd;
	}
	public String getTrsp_bnd_cd() {
		return trsp_bnd_cd;
	}
	public void setTrsp_bnd_cd(String trsp_bnd_cd) {
		this.trsp_bnd_cd = trsp_bnd_cd;
	}
	public String getCntr_kgs_wgt() {
		return cntr_kgs_wgt;
	}
	public void setCntr_kgs_wgt(String cntr_kgs_wgt) {
		this.cntr_kgs_wgt = cntr_kgs_wgt;
	}
	public String getCntr_lbs_wgt() {
		return cntr_lbs_wgt;
	}
	public void setCntr_lbs_wgt(String cntr_lbs_wgt) {
		this.cntr_lbs_wgt = cntr_lbs_wgt;
	}
	public String getFm_nod_cd() {
		return fm_nod_cd;
	}
	public void setFm_nod_cd(String fm_nod_cd) {
		this.fm_nod_cd = fm_nod_cd;
	}
	public String getFm_nod_nm() {
		return fm_nod_nm;
	}
	public void setFm_nod_nm(String fm_nod_nm) {
		this.fm_nod_nm = fm_nod_nm;
	}
	public String getFm_nod_addr() {
		return fm_nod_addr;
	}
	public void setFm_nod_addr(String fm_nod_addr) {
		this.fm_nod_addr = fm_nod_addr;
	}
	public String getVia_nod_cd() {
		return via_nod_cd;
	}
	public void setVia_nod_cd(String via_nod_cd) {
		this.via_nod_cd = via_nod_cd;
	}
	public String getVia_nod_nm() {
		return via_nod_nm;
	}
	public void setVia_nod_nm(String via_nod_nm) {
		this.via_nod_nm = via_nod_nm;
	}
	public String getVia_nod_addr() {
		return via_nod_addr;
	}
	public void setVia_nod_addr(String via_nod_addr) {
		this.via_nod_addr = via_nod_addr;
	}
	public String getDor_nod_cd() {
		return dor_nod_cd;
	}
	public void setDor_nod_cd(String dor_nod_cd) {
		this.dor_nod_cd = dor_nod_cd;
	}
	public String getDor_nod_nm() {
		return dor_nod_nm;
	}
	public void setDor_nod_nm(String dor_nod_nm) {
		this.dor_nod_nm = dor_nod_nm;
	}
	public String getDor_nod_addr() {
		return dor_nod_addr;
	}
	public void setDor_nod_addr(String dor_nod_addr) {
		this.dor_nod_addr = dor_nod_addr;
	}
	public String getTo_nod_cd() {
		return to_nod_cd;
	}
	public void setTo_nod_cd(String to_nod_cd) {
		this.to_nod_cd = to_nod_cd;
	}
	public String getTo_nod_nm() {
		return to_nod_nm;
	}
	public void setTo_nod_nm(String to_nod_nm) {
		this.to_nod_nm = to_nod_nm;
	}
	public String getTo_nod_addr() {
		return to_nod_addr;
	}
	public void setTo_nod_addr(String to_nod_addr) {
		this.to_nod_addr = to_nod_addr;
	}
	public String getLow_bid_amt() {
		return low_bid_amt;
	}
	public void setLow_bid_amt(String low_bid_amt) {
		this.low_bid_amt = low_bid_amt;
	}
	public String getBid_curr_cd() {
		return bid_curr_cd;
	}
	public void setBid_curr_cd(String bid_curr_cd) {
		this.bid_curr_cd = bid_curr_cd;
	}
	public String getBid_amt() {
		return bid_amt;
	}
	public void setBid_amt(String bid_amt) {
		this.bid_amt = bid_amt;
	}
	public String getBid_win_flg() {
		return bid_win_flg;
	}
	public void setBid_win_flg(String bid_win_flg) {
		this.bid_win_flg = bid_win_flg;
	}
	public String getBid_vndr_sts_cd() {
		return bid_vndr_sts_cd;
	}
	public void setBid_vndr_sts_cd(String bid_vndr_sts_cd) {
		this.bid_vndr_sts_cd = bid_vndr_sts_cd;
	}
	public String getLocl_low_bid_amt() {
		return locl_low_bid_amt;
	}
	public void setLocl_low_bid_amt(String locl_low_bid_amt) {
		this.locl_low_bid_amt = locl_low_bid_amt;
	}
	public String getFm_dept_dt() {
		return fm_dept_dt;
	}
	public void setFm_dept_dt(String fm_dept_dt) {
		this.fm_dept_dt = fm_dept_dt;
	}
	public String getTo_arvl_dt() {
		return to_arvl_dt;
	}
	public void setTo_arvl_dt(String to_arvl_dt) {
		this.to_arvl_dt = to_arvl_dt;
	}
	public String getDor_arvl_dt() {
		return dor_arvl_dt;
	}
	public void setDor_arvl_dt(String dor_arvl_dt) {
		this.dor_arvl_dt = dor_arvl_dt;
	}
	public String getLocl_low_bid_curr_cd() {
		return locl_low_bid_curr_cd;
	}
	public void setLocl_low_bid_curr_cd(String locl_low_bid_curr_cd) {
		this.locl_low_bid_curr_cd = locl_low_bid_curr_cd;
	}
	
	
}