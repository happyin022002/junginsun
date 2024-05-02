/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SppTrsI10Event.java
*@FileTitle : SPP TRS 메인화면 Invoice Request Event 
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.1
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS 메인화면 Invoice Request Event<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class SppTrsI10Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private String id = "SppTrsI10Event";
	private String userID = "";
	private String vendorCode = "";
	private String parentVendorCode = "";
	private String mainFlag = "";
    
    /**
     * 생성자<br>
     * 
     * @param void
     * @return void
     * @exception 
     */
	public SppTrsI10Event() {
	}
    /**
     * 생성자<br>
     * 
	 * @param userID
	 * @param vendorCode
	 * @param parentVendorCode
	 * @param mainFlag
	 */
	public SppTrsI10Event(String userID, 
							String vendorCode,
							String parentVendorCode,
							String mainFlag) {
		this.userID = userID;
		this.vendorCode = vendorCode;
		this.parentVendorCode = parentVendorCode;
		this.mainFlag = mainFlag;
	}
    /**
     * getEventName<br>
     * 
     * @param void
     * @return id String
     * @exception 
     */
	public String getEventName() {
		return id;
	}
    /**
     * toString<br>
     * 
     * @param void
     * @return id String
     * @exception 
     */
	public String toString() {
		return id;
	}
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
	/**
	 * @return Returns the mainFlag.
	 */
	public String getMainFlag() {
		return mainFlag;
	}
	/**
	 * @param mainFlag The mainFlag to set.
	 */
	public void setMainFlag(String mainFlag) {
		this.mainFlag = mainFlag;
	}

}
