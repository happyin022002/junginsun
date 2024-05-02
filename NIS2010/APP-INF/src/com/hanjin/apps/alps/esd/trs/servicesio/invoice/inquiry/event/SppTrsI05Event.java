/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiry.java
*@FileTitle : SPP TRS Event Request Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 subghwan cho : parentVendorCode 추가
* 2007-05-15 subghwan cho : extInvoiceNo 추가 (Excel 추출을 위해 별도 Parameter로 추가)
*@LastModifyDate : 2007-05-15
*@LastModifier : sunghwan cho
*@LastVersion : 1.2
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * Event Request Value Object<br>
 * - SPP TRS Event Request Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class SppTrsI05Event extends EventSupport {
	static final long serialVersionUID = 1L; 
	
	private String id = "SppTrsI05Event"; 
	private String periodType = "";
	private String periodStartDate = "";
	private String periodEndDate = "";
	private String status = "";
	private String invoiceNo = "";
	private String workOrderNo = "";
	private String equipmentNoType = "";
	private String equipmentNo = "";
	private String userID = "";
	private String vendorCode = "";
	private String parentVendorCode = "";
	private String extInvoiceNo = "";	//excel, print 추출용
	private String masterSPP = "";
	
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
	 * @return
	 */
	public String getMasterSPP() {
		return masterSPP;
	}
	/**
	 * 
	 * @param vendorCode
	 */
	public void setVendorCode(String vendorCode) {
		String vendorCode_temp[] = null;
		if(vendorCode != null && !"".equals(vendorCode)){
			vendorCode_temp = vendorCode.split("-");
		
			if(vendorCode_temp.length == 2){
				this.masterSPP = vendorCode_temp[0];
				this.vendorCode = vendorCode_temp[1];
			}else if("M".equals(vendorCode_temp[0])){
				this.masterSPP = vendorCode_temp[0];			
			}else{
				this.vendorCode = vendorCode;
			}
		}
	}
	/**
	 * 
	 *
	 */
	public SppTrsI05Event() {
	}
	/**
	 * 
	 * @param userID
	 * @param vendorCode
	 * @param periodType
	 * @param periodStartDate
	 * @param periodEndDate
	 * @param status
	 * @param invoiceNo
	 * @param workOrderNo
	 * @param equipmentNoType
	 * @param equipmentNo
	 * @param parentVendorCode
	 * @param extInvoiceNo
	 */
	public SppTrsI05Event(String userID, 
							String vendorCode,
							String periodType, 
							String periodStartDate, 
							String periodEndDate, 
							String status, 
							String invoiceNo,
							String workOrderNo,
							String equipmentNoType,
							String equipmentNo,
							String parentVendorCode,
							String extInvoiceNo ) {
		this.userID = userID;
		//this.vendorCode = vendorCode;
		this.periodType = periodType;
		this.periodStartDate = periodStartDate;
		this.periodEndDate = periodEndDate;
		this.status = status;
		this.invoiceNo = invoiceNo;
		this.workOrderNo = workOrderNo;
		this.equipmentNoType = equipmentNoType;
		this.equipmentNo = equipmentNo;
		this.parentVendorCode = parentVendorCode;
		this.extInvoiceNo = extInvoiceNo;
		
		String vendorCode_temp[] = null;
		
		if(vendorCode != null && !"".equals(vendorCode) ){
			vendorCode_temp = vendorCode.split("-");
			
			if(vendorCode_temp.length == 2){
				this.masterSPP = vendorCode_temp[0];
				this.vendorCode = vendorCode_temp[1];
			}else if("M".equals(vendorCode_temp[0])){
				this.masterSPP = vendorCode_temp[0];
			}else{
				this.vendorCode = vendorCode;
			}
		}
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
	 * 
	 * @return
	 */
	public String getExtInvoiceNo() {
		return extInvoiceNo;
	}
	/**
	 * 
	 * @param extInvoiceNo
	 */
	public void setExtInvoiceNo(String extInvoiceNo) {
		this.extInvoiceNo = extInvoiceNo;
	}
	
}
