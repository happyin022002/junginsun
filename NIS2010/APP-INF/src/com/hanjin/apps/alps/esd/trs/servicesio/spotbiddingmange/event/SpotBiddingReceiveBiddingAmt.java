/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingReceiveBiddingAmt.java
*@FileTitle : Send Bidding Amount
*Open Issues :
*Change history :
*@LastModifyDate : 2015-07-06
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-07-06  SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event;

/**
 * WebService Document Object including<br>
 * - SpotBiddingManageWSProxy Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author SHIN DONG IL
 * @see SpotBiddingManageWSProxy 참조
 * @since J2EE 1.6
 */
public class SpotBiddingReceiveBiddingAmt implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** (Param 객체) */
	private String bid_no = "";
	private String bid_vndr_seq = "";
	private String bid_vndr_sts_cd  = "";
	private String bid_curr_cd = "";
	private String bid_amt = "";
	private String bid_usr_id = "";
	
	public String getBid_no() {
		return bid_no;
	}
	public void setBid_no(String bid_no) {
		this.bid_no = bid_no;
	}
	public String getBid_vndr_seq() {
		return bid_vndr_seq;
	}
	public void setBid_vndr_seq(String bid_vndr_seq) {
		this.bid_vndr_seq = bid_vndr_seq;
	}
	public String getBid_vndr_sts_cd() {
		return bid_vndr_sts_cd;
	}
	public void setBid_vndr_sts_cd(String bid_vndr_sts_cd) {
		this.bid_vndr_sts_cd = bid_vndr_sts_cd;
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
	public String getBid_usr_id() {
		return bid_usr_id;
	}
	public void setBid_usr_id(String bid_usr_id) {
		this.bid_usr_id = bid_usr_id;
	}
	
}
