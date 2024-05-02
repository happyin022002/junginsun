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
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS 메인화면 Invoice Request Event<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class SppTrsI04Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private String id = "SppTrsI04Event";
	private String serviceNo = "";
	private String workOrderNo = "";
	private String equipmentNoType = "";
	private String equipmentNo = "";
	private String bookingNo = "";
	private String invoiceNo = "";
	private String issueDate = "";
	private String userID = "";
	private String vendorCode = "";
	private String stepCd = "";
	private String parentVendorCode = "";
	
	/**
	 * 
	 * @return
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * 
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * 
	 * @return
	 */
	public String getVendorCode() {
		return vendorCode;
	}
	/**
	 * 
	 * @param vendorCode
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	/**
	 * 
	 * @return
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * 
	 * @param invoiceNo
	 */

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getIssueDate() {
		return issueDate;
	}
	/**
	 * 
	 * @param issueDate
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	/**
	 * 
	 *
	 */
	public SppTrsI04Event() {
	}
	/**
	 * SppTrsI04Event 생성
	 * 
	 * @param userID String
	 * @param vendorCode String
	 * @param serviceNo String
	 * @param workOrderNo String
	 * @param equipmentNoType String
	 * @param equipmentNo String
	 * @param bookingNo String
	 * @param invoiceNo String
	 * @param issueDate String
	 * @param step_cd String
	 * @param parentVendorCode String
	 */
	public SppTrsI04Event(String userID, 
							String vendorCode, 
							String serviceNo,
							String workOrderNo,
							String equipmentNoType, 
							String equipmentNo, 
							String bookingNo,
							String invoiceNo,
							String issueDate,
							String step_cd,
							String parentVendorCode ) {
		this.userID = userID;
		this.vendorCode = vendorCode;
		this.serviceNo = serviceNo;
		this.workOrderNo = workOrderNo;
		this.equipmentNoType = equipmentNoType;
		this.equipmentNo = equipmentNo;
		this.bookingNo = bookingNo;
		this.invoiceNo = invoiceNo;
		this.issueDate = issueDate;
		this.stepCd = step_cd;
		this.parentVendorCode = parentVendorCode;
	}
	/**
	 * 
	 */
	public String getEventName() {
		return id;
	}
	/**
	 * 
	 */
	public String toString() {
		return id;
	}
	/**
	 * 
	 * @return
	 */
	public String getBookingNo() {
		return bookingNo;
	}
	/**
	 * 
	 * @param bookingNo
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getEquipmentNo() {
		return equipmentNo;
	}
	/**
	 * 
	 * @param equipmentNo
	 */
	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getEquipmentNoType() {
		return equipmentNoType;
	}
	/**
	 * 
	 * @param equipmentNoType
	 */
	public void setEquipmentNoType(String equipmentNoType) {
		this.equipmentNoType = equipmentNoType;
	}
	/**
	 * 
	 * @return
	 */
	public String getWorkOrderNo() {
		return workOrderNo;
	}
	/**
	 * 
	 * @param workOrderNo
	 */
	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getServiceNo() {
		return serviceNo;
	}
	/**
	 * 
	 * @param serviceNo
	 */
	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getStep_cd() {
		return stepCd;
	}
	/**
	 * 
	 * @param step_cd
	 */
	public void setStep_cd(String step_cd) {
		this.stepCd = step_cd;
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
