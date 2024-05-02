/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingFullInsertRetrive.java
*@FileTitle : Rail Billing Request Creation Info Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

/**
 * EXP_PAP_010 에 대한 WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Input Parameter<br>
 * - EXP_PAP_010Event로 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingFullInsertRetrive {
	/** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String bkgNo   = null;
	private String bkgVrfyRstCd = "";
	private String bkgVrfyErrCd = null;
	private String bkgVrfyErrLangTpCd = null;
	private VndrUserDetail vndrUserDetailInfo;
	private BookingSummary  bookingSummary;
	private BookingDetail[] bookingDetailList;
	private RailRampLocation railRampLocationInfo;
	
	/**
	 * @return Returns the bkg_no.
	 */
	public String getBkg_no() {
		return bkgNo;
	}
	/**
	 * @param bkg_no The bkg_no to set.
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}
	/**
	 * @return Returns the bkg_vrfy_rst_cd.
	 */
	public String getBkg_vrfy_rst_cd() {
		return bkgVrfyRstCd;
	}
	/**
	 * @param bkg_vrfy_rst_cd The bkg_vrfy_rst_cd to set.
	 */
	public void setBkg_vrfy_rst_cd(String bkg_vrfy_rst_cd) {
		this.bkgVrfyRstCd = bkg_vrfy_rst_cd;
	}
	/**
	 * @return Returns the vndrUserDetailInfo.
	 */
	public VndrUserDetail getVndrUserDetailInfo() {
		return vndrUserDetailInfo;
	}
	/**
	 * @param vndrUserDetailInfo The vndrUserDetailInfo to set.
	 */
	public void setVndrUserDetailInfo(VndrUserDetail vndrUserDetailInfo) {
		this.vndrUserDetailInfo = vndrUserDetailInfo;
	}
	/**
	 * @return Returns the bookingDetailList.
	 */
	public BookingDetail[] getBookingDetailList() {
		return bookingDetailList;
	}
	/**
	 * @param bookingDetailList The bookingDetailList to set.
	 */
	public void setBookingDetailList(BookingDetail[] bookingDetailList) {
		this.bookingDetailList = bookingDetailList;
	}
	/**
	 * @return Returns the bookingSummary.
	 */
	public BookingSummary getBookingSummary() {
		return bookingSummary;
	}
	/**
	 * @param bookingSummary The bookingSummary to set.
	 */
	public void setBookingSummary(BookingSummary bookingSummary) {
		this.bookingSummary = bookingSummary;
	}
	/**
	 * @return Returns the railRampLocationInfo.
	 */
	public RailRampLocation getRailRampLocationInfo() {
		return railRampLocationInfo;
	}
	/**
	 * @param railRampLocationInfo The railRampLocationInfo to set.
	 */
	public void setRailRampLocationInfo(RailRampLocation railRampLocationInfo) {
		this.railRampLocationInfo = railRampLocationInfo;
	}
	/**
	 * @return Returns the user_id.
	 */
	public String getUser_id() {
		return userId;
	}
	/**
	 * @param user_id The user_id to set.
	 */
	public void setUser_id(String user_id) {
		this.userId = user_id;
	}
	/**
	 * @return Returns the vender_cd.
	 */
	public String getVender_cd() {
		return venderCd;
	}
	/**
	 * @param vender_cd The vender_cd to set.
	 */
	public void setVender_cd(String vender_cd) {
		this.venderCd = vender_cd;
	}
	/**
	 * @return Returns the bkg_vrfy_err_cd.
	 */
	public String getBkg_vrfy_err_cd() {
		return bkgVrfyErrCd;
	}
	/**
	 * @param bkg_vrfy_err_cd The bkg_vrfy_err_cd to set.
	 */
	public void setBkg_vrfy_err_cd(String bkg_vrfy_err_cd) {
		this.bkgVrfyErrCd = bkg_vrfy_err_cd;
	}
	/**
	 * @return Returns the bkg_vrfy_err_lang_tp_cd.
	 */
	public String getBkg_vrfy_err_lang_tp_cd() {
		return bkgVrfyErrLangTpCd;
	}
	/**
	 * @param bkg_vrfy_err_lang_tp_cd The bkg_vrfy_err_lang_tp_cd to set.
	 */
	public void setBkg_vrfy_err_lang_tp_cd(String bkg_vrfy_err_lang_tp_cd) {
		this.bkgVrfyErrLangTpCd = bkg_vrfy_err_lang_tp_cd;
	}

}
