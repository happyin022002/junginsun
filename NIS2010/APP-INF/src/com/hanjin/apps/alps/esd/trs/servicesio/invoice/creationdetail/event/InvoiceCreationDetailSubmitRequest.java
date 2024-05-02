/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationDetailSubmitRequest.java
*@FileTitle : SPP TRS Invoice Creation Submit Request Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-02-05 sunghwan cho : vendorPhoneNo 추가
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.2
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.InvoiceSurchargeInquiry;
import java.util.Arrays;

/**
 * Request Value Object<br>
 * - SPP TRS Invoice Creation Submit Request Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceCreationDetailSubmitRequest {
	private String id = "InvoiceCreationDetailSubmitRequest";
	private String userID = "";
	private String vendorCode = "";
	private String vendorPhoneNo = "";
	private String invoiceNo = "";
	private String issueDate = "";
	private String invoiceCurrency = "";
	private InvoiceCreationInquiry[] invoiceCreationData = null;
	private InvoiceSurchargeInquiry[] invoiceSurchargeData = null;
	//추가:2007-01-12 조성환 : 교차 검증을 위해 Summary부분 추가
	private String totalWorkOrder = "";	//
	private String totalEquipment = "";	//
	private String invoiceBasicAmountTotal = "";	//
	private String surchargeTotal = "";	//
	private String grandTotal = "";	//
	private String parentVendorCode = "";
	private String vatAmt = "";
	
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
	public String getVendorPhoneNo() {
		return vendorPhoneNo;
	}
	/**
	 * 
	 * @param vendorPhoneNo
	 */
	public void setVendorPhoneNo(String vendorPhoneNo) {
		this.vendorPhoneNo = vendorPhoneNo;
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
	 * @return
	 */
	public InvoiceSurchargeInquiry[] getInvoiceSurchargeData() {
		InvoiceSurchargeInquiry[] rtnList = null;
		if(this.invoiceSurchargeData != null){
			rtnList = Arrays.copyOf(invoiceSurchargeData, invoiceSurchargeData.length);
		}
		return rtnList;
	}
	/**
	 * 
	 * @param invoiceSurchargeData
	 */
	public void setInvoiceSurchargeData(InvoiceSurchargeInquiry[] invoiceSurchargeData) {
		if(invoiceSurchargeData != null){
			InvoiceSurchargeInquiry[] tmpList = Arrays.copyOf(invoiceSurchargeData, invoiceSurchargeData.length);
			this.invoiceSurchargeData = tmpList;
		}
	}
	/**
	 * 
	 * @return
	 */
	public String getGrandTotal() {
		return grandTotal;
	}
	/**
	 * 
	 * @param grandTotal
	 */
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	/**
	 * 
	 * @return
	 */
	public String getInvoiceBasicAmountTotal() {
		return invoiceBasicAmountTotal;
	}
	/**
	 * 
	 * @param invoiceBasicAmountTotal
	 */
	public void setInvoiceBasicAmountTotal(String invoiceBasicAmountTotal) {
		this.invoiceBasicAmountTotal = invoiceBasicAmountTotal;
	}
	/**
	 * 
	 * @return
	 */
	public String getSurchargeTotal() {
		return surchargeTotal;
	}
	/**
	 * 
	 * @param surchargeTotal
	 */
	public void setSurchargeTotal(String surchargeTotal) {
		this.surchargeTotal = surchargeTotal;
	}
	/**
	 * 
	 * @return
	 */
	public String getTotalEquipment() {
		return totalEquipment;
	}
	/**
	 * 
	 * @param totalEquipment
	 */
	public void setTotalEquipment(String totalEquipment) {
		this.totalEquipment = totalEquipment;
	}
	/**
	 * 
	 * @return
	 */
	public String getTotalWorkOrder() {
		return totalWorkOrder;
	}
	/**
	 * 
	 * @param totalWorkOrder
	 */
	public void setTotalWorkOrder(String totalWorkOrder) {
		this.totalWorkOrder = totalWorkOrder;
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
	 * @return Returns the vatAmt.
	 */
	public String getVatAmt() {
		return vatAmt;
	}
	/**
	 * @param vatAmt The vatAmt to set.
	 */
	public void setVatAmt(String vatAmt) {
		this.vatAmt = vatAmt;
	}
	
}
