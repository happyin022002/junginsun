/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingFullVerifyRetrive.java
*@FileTitle : Rail Billing Request Full Verify  Info Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

import java.util.Arrays;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Input Parameter<br>
 * - Event로 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingFullVerifyRetrive {
	/** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String bkgNo   = null;
	private String bkgVrfyRstCd = null;
	private String bkgVrfyErrCd = null;
	private String bkgVrfyErrLangTpCd = null;
	
	private String orgYdCd = null;
	private String destYdCd = null;
	private BookingDetail[] bookingDetailList = null;
	
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
	 * @return Returns the bookingDetailList.
	 */
	public BookingDetail[] getBookingDetailList() {
		BookingDetail[] rtnList = null;
		if(this.bookingDetailList != null){
			rtnList = Arrays.copyOf(bookingDetailList, bookingDetailList.length);
		}
		return rtnList;
	}
	/**
	 * @param bookingDetailList The bookingDetailList to set.
	 */
	public void setBookingDetailList(BookingDetail[] bookingDetailList) {
		if(bookingDetailList != null){
			BookingDetail[] tmpList = Arrays.copyOf(bookingDetailList, bookingDetailList.length);
			this.bookingDetailList = tmpList;
		}
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
	 * @return Returns the org_yd_cd.
	 */
	public String getOrg_yd_cd() {
		return orgYdCd;
	}
	/**
	 * @param org_yd_cd The org_yd_cd to set.
	 */
	public void setOrg_yd_cd(String org_yd_cd) {
		this.orgYdCd = org_yd_cd;
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
	/**
	 * @return Returns the dest_yd_cd.
	 */
	public String getDest_yd_cd() {
		return destYdCd;
	}
	/**
	 * @param dest_yd_cd The dest_yd_cd to set.
	 */
	public void setDest_yd_cd(String dest_yd_cd) {
		this.destYdCd = dest_yd_cd;
	}
	
	

}
