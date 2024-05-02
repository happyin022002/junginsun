/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SppTrsU02Event.java
*@FileTitle : SPP TRS Invoice Event Value Object
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

import java.util.Arrays;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.InvoiceSurchargeInquiry;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * SPP TRS Request Value Object<br>
 * - SPP TRS Invoice Event Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class SppTrsU02Event extends EventSupport {
	static final long serialVersionUID = 1L; 
	
	private String id = "SppTrsU02Event";
	private String userID = "";
	private String vendorCode = "";
	private String vendorPhoneNo = "";
	private String invoiceNo = "";
	private String issueDate = "";
	private String invoiceCurrency = "";
	private InvoiceCreationInquiry[] invoiceCreationData = null;
	private InvoiceSurchargeInquiry[] invoiceSurchargeData = null;
	private MultiInvoiceCreationDetailList[] multiInvoiceCreationDetailList = null;
	//추가:2007-01-12 조성환 : 교차 검증을 위해 Summary부분 추가
	private String totalWorkOrder = "";	//
	private String totalEquipment = "";	//
	private String invoiceBasicAmountTotal = "";	//
	private String surchargeTotal = "";	//
	private String grandTotal = "";	//
	private String parentVendorCode = "";
	private String masterSPP = "";
	private String multiYN = "N";
	private String invCode[] = null;
	
	private String vatAmt = "";
	
	/**
	 * 
	 *
	 */
	public SppTrsU02Event() {
	}
	
	/**
	 * SppTrsU02Event 생성
	 * 
	 * @param userID
	 * @param vendorCode
	 * @param vendorPhoneNo
	 * @param invoiceNo
	 * @param issueDate
	 * @param invoiceCurrency
	 * @param invoiceCreationData
	 * @param invoiceSurchargeData
	 * @param totalWorkOrder
	 * @param totalEquipment
	 * @param invoiceBasicAmountTotal
	 * @param surchargeTotal
	 * @param grandTotal
	 * @param parentVendorCode
	 * @param vatAmt
	 */
	public SppTrsU02Event(String userID,
							String vendorCode,
							String vendorPhoneNo, 
							String invoiceNo, 
							String issueDate,
							String invoiceCurrency,
							InvoiceCreationInquiry[] invoiceCreationData,
							InvoiceSurchargeInquiry[] invoiceSurchargeData, 
							String totalWorkOrder,
							String totalEquipment,
							String invoiceBasicAmountTotal,
							String surchargeTotal,
							String grandTotal,
							String parentVendorCode,
							String vatAmt) { 
		this.userID = userID;
		//this.vendorCode = vendorCode;
		this.vendorPhoneNo = vendorPhoneNo;
		this.invoiceNo = invoiceNo;
		this.issueDate = issueDate;
		this.invoiceCurrency = invoiceCurrency;
		this.invoiceCreationData = invoiceCreationData;
		this.invoiceSurchargeData = invoiceSurchargeData;
		this.totalWorkOrder = totalWorkOrder;
		this.totalEquipment = totalEquipment;
		this.invoiceBasicAmountTotal = invoiceBasicAmountTotal;
		this.surchargeTotal = surchargeTotal;
		this.grandTotal = grandTotal;
		this.parentVendorCode = parentVendorCode;
		String vendor_cd_temp[] = vendorCode.split("-");
		if(vendor_cd_temp.length == 2){
			this.masterSPP = vendor_cd_temp[0];
			this.vendorCode = vendor_cd_temp[1];
		}else if(vendor_cd_temp.length == 1){
			this.masterSPP = "S";
			this.vendorCode = vendor_cd_temp[0];
		}else{
			this.masterSPP = "S";
			this.vendorCode = vendorCode;		
		}
		this.vatAmt = vatAmt;
	}
	
	/**
	 * SppTrsU02Event생성
	 * 
	 * @param userID
	 * @param vendorCode
	 * @param vendorPhoneNo
	 * @param parentVendorCode
	 * @param multiInvoiceCreationDetailList
	 * @param invCode
	 */
	public SppTrsU02Event(String userID,
							String vendorCode,
							String vendorPhoneNo, 
							String parentVendorCode,
							MultiInvoiceCreationDetailList[] multiInvoiceCreationDetailList,
							String[] invCode) { 
		this.userID = userID;
		//this.vendorCode = vendorCode;
		this.vendorPhoneNo = vendorPhoneNo;
		this.parentVendorCode = parentVendorCode;
		String vendor_cd_temp[] = vendorCode.split("-");
		if(vendor_cd_temp.length == 2){
			this.masterSPP = vendor_cd_temp[0];
			this.vendorCode = vendor_cd_temp[1];
		}else if(vendor_cd_temp.length == 1){
			this.masterSPP = "S";
			this.vendorCode = vendor_cd_temp[0];
		}else{
			this.masterSPP = "S";
			this.vendorCode = vendorCode;		
		}
		this.multiInvoiceCreationDetailList = multiInvoiceCreationDetailList;
		this.invCode = invCode;
		this.multiYN = "Y";
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
	public void setInvoiceCurency(String invoiceCurrency) {
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
	 * @param invoiceCurrency
	 */
	public void setInvoiceCurrency(String invoiceCurrency) {
		this.invoiceCurrency = invoiceCurrency;
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
	/**
	 * @return Returns the multiInvoiceCreationDetailList.
	 */
	public MultiInvoiceCreationDetailList[] getMultiInvoiceCreationDetailList() {
		MultiInvoiceCreationDetailList[] rtnList = null;
		if(this.multiInvoiceCreationDetailList != null){
			rtnList = Arrays.copyOf(multiInvoiceCreationDetailList, multiInvoiceCreationDetailList.length);
		}
		return rtnList;
	}
	/**
	 * @param multiInvoiceCreationDetailList The multiInvoiceCreationDetailList to set.
	 */
	public void setMultiInvoiceCreationDetailList(MultiInvoiceCreationDetailList[] multiInvoiceCreationDetailList) {
		if(multiInvoiceCreationDetailList != null){
			MultiInvoiceCreationDetailList[] tmpList = Arrays.copyOf(multiInvoiceCreationDetailList, multiInvoiceCreationDetailList.length);
			this.multiInvoiceCreationDetailList = tmpList;
		}
	}
	/**
	 * @return Returns the multiYN.
	 */
	public String getMultiYN() {
		return multiYN;
	}
	/**
	 * @param multiYN The multiYN to set.
	 */
	public void setMultiYN(String multiYN) {
		this.multiYN = multiYN;
	}
	/**
	 * @return Returns the invCode.
	 */
	public String[] getInvCode() {
		String[] rtnList = null;
		if(this.invCode != null){
			rtnList = Arrays.copyOf(invCode, invCode.length);
		}
		return rtnList;
	}
	/**
	 * @param invCode The invCode to set.
	 */
	public void setInvCode(String[] invCode) {
		if(invCode != null){
			String[] tmpList = Arrays.copyOf(invCode, invCode.length);
			this.invCode = tmpList;
		}
	}
}
