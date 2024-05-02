/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SppTrsI02Event.java
*@FileTitle : SPP TRS Event Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-02-07 sunghwan cho : extWorkOrderNo, extServiceOrderNo, extEquipmentNo 추가
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.2
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.framework.support.layer.event.EventSupport;
import java.util.Arrays;

/**
 * Value Object<br>
 * - SPP TRS Event Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class SppTrsI02Event extends EventSupport {
	static final long serialVersionUID = 1L; 
	
	private String id = "SppTrsI02Event";
	private String userID = "";
	private String vendorCode = "";
	private String invoiceNo = "";
	private String issueDate = "";
	private String invoiceCurrency = "";
	private String extWorkOrderNo = "";	//excel, print 추출용
	private String extServiceOrderNo = "";	//excel, print 추출용
	private String extEquipmentNo = "";	//excel, print 추출용
	private InvoiceCreationInquiry[] invoiceCreationData = null;
	private String parentVendorCode = "";

	/**
	 * 
	 * @return
	 */
	public InvoiceCreationInquiry[] getInvoiceCreationData() {
		InvoiceCreationInquiry[] rtnList = null;
		if(this.invoiceCreationData != null){
			rtnList = Arrays.copyOf(invoiceCreationData, invoiceCreationData.length);
		}
		return rtnList;
	}
	/**
	 * 
	 * @param invoiceCreationData
	 */
	public void setInvoiceCreationData(InvoiceCreationInquiry[] invoiceCreationData) {
		if(invoiceCreationData != null){
			InvoiceCreationInquiry[] tmpList = Arrays.copyOf(invoiceCreationData, invoiceCreationData.length);
			this.invoiceCreationData = tmpList;
		}
	}
	/**
	 * 
	 *
	 */
	public SppTrsI02Event() {
	}
	/**
	 * 
	 * @param userID
	 * @param vendorCode
	 * @param invoiceNo
	 * @param issueDate
	 * @param invoiceCurrency
	 * @param extWorkOrderNo
	 * @param extServiceOrderNo
	 * @param extEquipmentNo
	 * @param invoiceCreationData
	 * @param parentVendorCode
	 */
	public SppTrsI02Event(String userID, 
							String vendorCode, 
							String invoiceNo, 
							String issueDate,
							String invoiceCurrency,
							String extWorkOrderNo, 
							String extServiceOrderNo,
							String extEquipmentNo,
							InvoiceCreationInquiry[] invoiceCreationData,
							String parentVendorCode) { 
		this.userID = userID;
		this.vendorCode = vendorCode;
		this.invoiceNo = invoiceNo;
		this.issueDate = issueDate;
		this.invoiceCurrency = invoiceCurrency;
		this.extWorkOrderNo = extWorkOrderNo;
		this.extServiceOrderNo = extServiceOrderNo;
		this.extEquipmentNo = extEquipmentNo;
		this.invoiceCreationData = invoiceCreationData;
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
	 * @return
	 */
	public String getInvoiceCurrency() {
		return invoiceCurrency;
	}
	/**
	 * 
	 * @param invoiceCurrency
	 */
	public void setInvoiceCurrency(String invoiceCurrency) {
		this.invoiceCurrency = invoiceCurrency;
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
	 * @return
	 */
	public String getExtEquipmentNo() {
		return extEquipmentNo;
	}
	/**
	 * 
	 * @param extEquipmentNo
	 */
	public void setExtEquipmentNo(String extEquipmentNo) {
		this.extEquipmentNo = extEquipmentNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getExtServiceOrderNo() {
		return extServiceOrderNo;
	}
	/**
	 * 
	 * @param extServiceOrderNo
	 */
	public void setExtServiceOrderNo(String extServiceOrderNo) {
		this.extServiceOrderNo = extServiceOrderNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getExtWorkOrderNo() {
		return extWorkOrderNo;
	}
	/**
	 * 
	 * @param extWorkOrderNo
	 */
	public void setExtWorkOrderNo(String extWorkOrderNo) {
		this.extWorkOrderNo = extWorkOrderNo;
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
