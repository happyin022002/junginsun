/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiry.java
*@FileTitle : SPP TRS Invoice Creation Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-02-05 subghwan cho : serviceOrderNo 추가
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.2
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS Invoice Creation Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceCreationInquiryRequest {
	private String id = "InvoiceCreationInquiryRequest";
	private String userID = "";
	private String vendorCode = "";
	private String workOrderNo = "";
	private String equipmentNoType = "";
	private String equipmentNo = "";
	private String bookingNo = "";
	private String billOfLadingNo = "";
	private String serviceOrderNo = "";	//Excel출력 및 Print시 EQ가 없는 경우를 위해 추가
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
	public String getBillOfLadingNo() {
		return billOfLadingNo;
	}
	/**
	 * 
	 * @param billOfLadingNo
	 */
	public void setBillOfLadingNo(String billOfLadingNo) {
		this.billOfLadingNo = billOfLadingNo;
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
	 */
	public String toString() {
		return id;
	}
	/**
	 * 
	 * @return
	 */
	public String getServiceOrderNo() {
		return serviceOrderNo;
	}
	/**
	 * 
	 * @param serviceOrderNo
	 */
	public void setServiceOrderNo(String serviceOrderNo) {
		this.serviceOrderNo = serviceOrderNo;
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
