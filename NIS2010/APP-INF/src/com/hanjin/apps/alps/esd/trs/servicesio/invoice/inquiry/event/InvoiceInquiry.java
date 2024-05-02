/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiry.java
*@FileTitle : SPP TRS Invoice Inquiry List Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 subghwan cho : parentVendorCode 추가
* 2007-05-15 subghwan cho : workOrderNo, serviceOrderNo, equipmentNo 추가 (Excel 추출을 위해 별도 Parameter로 추가)
* 2007-05-17 subghwan cho : vendorName 추가 (Excel 추출을 위해 별도 Parameter로 추가)
*@LastModifyDate : 2007-05-17
*@LastModifier : sunghwan cho
*@LastVersion : 1.3
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Value Object<br>
 * - SPP TRS Invoice Inquiry List Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceInquiry {
	private int seq = 0;
	private String invoiceNo = "";
	private String workOrderNo = "";
	private String serviceOrderNo = "";
	private String equipmentNo = "";
	private String invoiceCurrency = "";
	private String invoiceTotalAMT = "";
	private String issueDate = "";
	private String submitDate = "";
	private String status = "";
	private String statusCd = "";
	private String paidDate = "";
	private String paymentMethod = "";
	private String checkTTNumber = "";
	private String cancelFlag = "";
	private String vendorCode = "";
	private String vendorName = "";
	private String parentVendorCode = "";
	private String vendorAddress = "";
	private String vendorTelNo = "";
	private String vendorFaxNo = "";
	private String invoiceVendorCode = "";
	private String ifSysKndName = "";
	private String trspKindNm = "";
	private String trspModeNm = "";
	private String trspTypeNm = "";
	private String fmNodCd = "";
	private String toNodCd = "";
	private String eqTpszCd = "";
	private String invRmk = "";
	
	public String getTrspKindNm() {
		return trspKindNm;
	}
	public void setTrspKindNm(String trspKindNm) {
		this.trspKindNm = trspKindNm;
	}
	public String getTrspModeNm() {
		return trspModeNm;
	}
	public void setTrspModeNm(String trspModeNm) {
		this.trspModeNm = trspModeNm;
	}
	public String getTrspTypeNm() {
		return trspTypeNm;
	}
	public void setTrspTypeNm(String trspTypeNm) {
		this.trspTypeNm = trspTypeNm;
	}
	public String getFmNodCd() {
		return fmNodCd;
	}
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	public String getToNodCd() {
		return toNodCd;
	}
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	public String getEqTpszCd() {
		return eqTpszCd;
	}
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	public String getInvoiceVendorCode() {
		return invoiceVendorCode;
	}
	public void setInvoiceVendorCode(String invoiceVendorCode) {
		this.invoiceVendorCode = invoiceVendorCode;
	}
	/**
	 * 
	 * @return
	 */
	public String getVendorAddress() {
		return vendorAddress;
	}
	/**
	 * 
	 * @param cancelFlag
	 */
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = StringEscapeUtils.escapeXml(vendorAddress);
	}
	/**
	 * 
	 * @return
	 */
	public String getVendorTelNo() {
		return vendorTelNo;
	}
	/**
	 * 
	 * @param cancelFlag
	 */
	public void setVendorTelNo(String vendorTelNo) {
		this.vendorTelNo = vendorTelNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getVendorFaxNo() {
		return vendorFaxNo;
	}
	/**
	 * 
	 * @param cancelFlag
	 */
	public void setVendorFaxNo(String vendorFaxNo) {
		this.vendorFaxNo = vendorFaxNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getCancelFlag() {
		return cancelFlag;
	}
	/**
	 * 
	 * @param cancelFlag
	 */
	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	/**
	 * 
	 * @return
	 */
	public String getCheckTTNumber() {
		return checkTTNumber;
	}
	/**
	 * 
	 * @param checkTTNumber
	 */
	public void setCheckTTNumber(String checkTTNumber) {
		this.checkTTNumber = checkTTNumber;
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
	public String getInvoiceTotalAMT() {
		return invoiceTotalAMT;
	}
	/**
	 * 
	 * @param invoiceTotalAMT
	 */
	public void setInvoiceTotalAMT(String invoiceTotalAMT) {
		this.invoiceTotalAMT = invoiceTotalAMT;
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
	public String getPaidDate() {
		return paidDate;
	}
	/**
	 * 
	 * @param paidDate
	 */
	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}
	/**
	 * 
	 * @return
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	/**
	 * 
	 * @param paymentMethod
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	/**
	 * 
	 * @return
	 */
	public int getSeq() {
		return seq;
	}
	/**
	 * 
	 * @param seq
	 */
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getSubmitDate() {
		return submitDate;
	}
	/**
	 * 
	 * @param submitDate
	 */
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	/**
	 * 
	 * @return
	 */
	public String getStatus_cd() {
		return statusCd;
	}
	/**
	 * 
	 * @param status_cd
	 */
	public void setStatus_cd(String status_cd) {
		this.statusCd = status_cd;
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
	public String getVendorName() {
		return vendorName;
	}
	/**
	 * 
	 * @param vendorName
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = StringEscapeUtils.escapeXml(vendorName);
	}
	/**
	 * @return Returns the ifSysKndName.
	 */
	public String getIfSysKndName() {
		return ifSysKndName;
	}
	/**
	 * @param ifSysKndName The ifSysKndName to set.
	 */
	public void setIfSysKndName(String ifSysKndName) {
		this.ifSysKndName = ifSysKndName;
	}
	/**
	 * @return Returns the invRmk.
	 */
	public String getInvRmk() {
		return invRmk;
	}
	/**
	 * @param invRmk The invRmk to set.
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}
	
}