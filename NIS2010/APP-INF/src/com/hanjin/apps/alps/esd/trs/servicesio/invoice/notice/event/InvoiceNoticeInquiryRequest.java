/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiryRequest.java
*@FileTitle : SPP TRS 메인화면 Invoice Request Value Object 
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.01
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS 메인화면 Invoice List Value Object<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class InvoiceNoticeInquiryRequest {
	private String userID = "";
	private String vendorCode = "";
	private String parentVendorCode = "";
	
    /**
     * getUserID<br>
     * 
     * @param void
     * @return userID String
     * @exception 
     */
	public String getUserID() {
		return userID;
	}
    /**
     * setUserID<br>
     * 
     * @param userID String
     * @return void
     * @exception 
     */
	public void setUserID(String userID) {
		this.userID = userID;
	}
    /**
     * getVendorCode<br>
     * 
     * @param void
     * @return vendorCode String
     * @exception 
     */
	public String getVendorCode() {
		return vendorCode;
	}
    /**
     * setVendorCode<br>
     * 
     * @param vendorCode String
     * @return void
     * @exception 
     */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	/**
	 * 
	 * @return
	 */
	public String getParentVendorCode() {
		return parentVendorCode;
	}
	/**
	 * 
	 * @param parentVendorCode
	 */
	public void setParentVendorCode(String parentVendorCode) {
		this.parentVendorCode = parentVendorCode;
	}

}
