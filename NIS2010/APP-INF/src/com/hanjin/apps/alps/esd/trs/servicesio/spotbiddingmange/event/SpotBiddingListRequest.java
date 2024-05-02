/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingListRequest.java
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

/**
* DTO(Data Transfer Object including Parameters)<br>
* RailBillingReqCreateRSC에서 작성<br>
* - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
*
* @author SHIN DONG IL
* @see SpotBiddingManageRSC 참조
* @since J2EE 1.6
*/
public class SpotBiddingListRequest{
	
	private static final long serialVersionUID = 1L;
	
	private String bid_no = "";
	private String bid_fm_due_dt = "";
	private String bid_to_due_dt = "";
	private String bid_sts_cd = "";
	private String bkg_no = "";
	private String wo_no = "";
	private String bid_vndr_seq = "";
	private String win_flg = "";
	
	public String getBid_no() {
		return bid_no;
	}
	public void setBid_no(String bid_no) {
		this.bid_no = bid_no;
	}

	public String getBid_fm_due_dt() {
		return bid_fm_due_dt;
	}
	public void setBid_fm_due_dt(String bid_fm_due_dt) {
		this.bid_fm_due_dt = bid_fm_due_dt;
	}
	public String getBid_to_due_dt() {
		return bid_to_due_dt;
	}
	public void setBid_to_due_dt(String bid_to_due_dt) {
		this.bid_to_due_dt = bid_to_due_dt;
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
	public String getWin_flg() {
		return win_flg;
	}
	public void setWin_flg(String win_flg) {
		this.win_flg = win_flg;
	}
	
}