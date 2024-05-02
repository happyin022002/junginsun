/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiry.java
*@FileTitle : SPP TRS Reqeust Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 subghwan cho : parentVendorCode 추가
* 2007-05-15 subghwan cho : extInvoiceNo 추가 (Excel 추출을 위해 별도 Parameter로 추가)
*@LastModifyDate : 2007-05-15
*@LastModifier : sunghwan cho
*@LastVersion : 1.2
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.availability.event;

/**
 * Reqeust Value Object<br>
 * - SPP TRS Reqeust Value Object<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.6
 */
public class EmptyAvailabilityInquiryRequest {
	private String id = "EmptyAvailabilityInquiryRequest";
	private String periodType = "";
	private String periodStartDate = "";
	private String periodEndDate = "";
	private String status = "";
	private String workOrderNo = "";
	private String equipmentNo = "";
	private String userID = "";
	private String vendorCode = "";
	private String dorNodCd = "";
	private String toNodCd = "";
	private String masterSpp = "";
	
	public String getToNodCd() {
		return toNodCd;
	}
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
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
	 */
	public String toString() {
		return id;
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
	public String getPeriodEndDate() {
		return periodEndDate;
	}
	/**
	 * 
	 * @param periodEndDate
	 */
	public void setPeriodEndDate(String periodEndDate) {
		this.periodEndDate = periodEndDate;
	}
	/**
	 * 
	 * @return
	 */
	public String getPeriodStartDate() {
		return periodStartDate;
	}
	/**
	 * 
	 * @param periodStartDate
	 */
	public void setPeriodStartDate(String periodStartDate) {
		this.periodStartDate = periodStartDate;
	}
	/**
	 * 
	 * @return
	 */
	public String getPeriodType() {
		return periodType;
	}
	/**
	 * 
	 * @param periodType
	 */
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	/**
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return Returns the dorNodCd.
	 */
	public String getDorNodCd() {
		return dorNodCd;
	}
	/**
	 * @param dorNodCd The dorNodCd to set.
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	/**
	 * @return Returns the masterSpp.
	 */
	public String getMasterSpp() {
		return masterSpp;
	}
	/**
	 * @param masterSpp The masterSpp to set.
	 */
	public void setMasterSpp(String masterSpp) {
		this.masterSpp = masterSpp;
	}
	
}
