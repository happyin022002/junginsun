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
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS 메인화면 Invoice Request Event<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class SppTrsI03Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private String id = "SppTrsI03Event";
	private String invoiceNo = "";
	private String issueDate = "";
	private String invoiceCurrency = "";
	private String userID = "";
	private String vendorCode = "";
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
	 *
	 */
	public SppTrsI03Event() {
	}
	/**
	 *  SppTrsI03Event 생성
	 *  
	 * @param userID
	 * @param vendorCode
	 * @param invoiceNo
	 * @param issueDate
	 * @param invoiceCurrency
	 * @param parentVendorCode
	 */
	public SppTrsI03Event(String userID, 
							String vendorCode,
							String invoiceNo, 
							String issueDate,
							String invoiceCurrency, 
							String parentVendorCode ) {
		this.userID = userID;
		this.vendorCode = vendorCode;
		this.invoiceNo = invoiceNo;
		this.issueDate = issueDate;
		this.invoiceCurrency = invoiceCurrency;
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
