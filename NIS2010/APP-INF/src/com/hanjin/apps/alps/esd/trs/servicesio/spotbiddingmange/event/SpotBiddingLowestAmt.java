/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : YardDetail.java
*@FileTitle : YardDetail Info
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
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
public class SpotBiddingLowestAmt implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** (Param 객체) */
	private String bid_no = null;
	private String bid_curr_cd = null;
	private String bid_amt = null;
	private String curr_dt = null;
	private String usd_amt = null;
	
	public String getCurr_dt() {
		return curr_dt;
	}
	public void setCurr_dt(String curr_dt) {
		this.curr_dt = curr_dt;
	}
	public String getBid_no() {
		return bid_no;
	}
	public void setBid_no(String bid_no) {
		this.bid_no = bid_no;
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
	public String getUsd_amt() {
		return usd_amt;
	}
	public void setUsd_amt(String usd_amt) {
		this.usd_amt = usd_amt;
	}
}
