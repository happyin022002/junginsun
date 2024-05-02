/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingFullSearchResponse
*@FileTitle : Rail Billing Request Full Search Info Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.RailBillingIWSProxy;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.BasicResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.Constants;

/**
 * EXP_PAP_010Response 에 대한 WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Output Parameter<br>
 * - EXP_PAP_010EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingFullSearchResponse extends BasicResponse {
	/** (Header) */
	
	private String	id				= "RailBillingFullSearchResponse";
	private String	status			= null;
	
	/** (Param 객체) */
	private String bkgVrfyGood    = Constants.VRFY_GOOD;
	private String bkgVrfyNoGood = Constants.VRFY_NOGOOD;
	private String bkgVrfyNoWrs  = Constants.VRFY_NOWRS;
	
	private String bkgVrfyRstCd = "";
	private String bkgVrfyErrCd = "";
	private String bkgVrfyErrLangTpCd = "";
	private String bkgVrfyErrMsg = "";
	
	private BookingSummary  bookingSummary = null;
	private BookingDetail[] bookingDetailList;
	private RailRampLocation railRampLocationInfo;
	
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
	 * @return Returns the id.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return Returns the status.
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status The status to set.
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return Returns the bkg_vrfy_err_msg.
	 */
	public String getBkg_vrfy_err_msg() {
		return bkgVrfyErrMsg;
	}
	/**
	 * @param bkg_vrfy_err_msg The bkg_vrfy_err_msg to set.
	 */
	public void setBkg_vrfy_err_msg(String bkg_vrfy_err_msg) {
		this.bkgVrfyErrMsg = bkg_vrfy_err_msg;
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
	 * @return Returns the bkg_vrfy_good.
	 */
	public String getBkg_vrfy_good() {
		return bkgVrfyGood;
	}
	/**
	 * @param bkg_vrfy_good The bkg_vrfy_good to set.
	 */
	public void setBkg_vrfy_good(String bkg_vrfy_good) {
		this.bkgVrfyGood = bkg_vrfy_good;
	}
	/**
	 * @return Returns the bkg_vrfy_no_good.
	 */
	public String getBkg_vrfy_no_good() {
		return bkgVrfyNoGood;
	}
	/**
	 * @param bkg_vrfy_no_good The bkg_vrfy_no_good to set.
	 */
	public void setBkg_vrfy_no_good(String bkg_vrfy_no_good) {
		this.bkgVrfyNoGood = bkg_vrfy_no_good;
	}
	/**
	 * @return Returns the bkg_vrfy_no_wrs.
	 */
	public String getBkg_vrfy_no_wrs() {
		return bkgVrfyNoWrs;
	}
	/**
	 * @param bkg_vrfy_no_wrs The bkg_vrfy_no_wrs to set.
	 */
	public void setBkg_vrfy_no_wrs(String bkg_vrfy_no_wrs) {
		this.bkgVrfyNoWrs = bkg_vrfy_no_wrs;
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
