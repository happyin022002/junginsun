/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiry.java
*@FileTitle : SPP TRS Request Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.1
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.InvoiceInquiry;

/**
 * Request Value Object<br>
 * - SPP TRS Request Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceInquirySubmitRequest {
	private String id = "InvoiceInquiryRequest";
	private InvoiceInquiry[] invoiceData = null;
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
	 */
	public String toString() {
		return id;
	}
	/**
	 * 
	 * @return
	 */
	public InvoiceInquiry[] getInvoiceData() {
		InvoiceInquiry[] rtnList = null;
		if(this.invoiceData != null){
			rtnList = Arrays.copyOf(invoiceData, invoiceData.length);
		}
		return rtnList;
	}
	/**
	 * 
	 * @param invoiceData
	 */
	public void setInvoiceData(InvoiceInquiry[] invoiceData) {
		if(invoiceData != null){
			InvoiceInquiry[] tmpList = Arrays.copyOf(invoiceData, invoiceData.length);
			this.invoiceData = tmpList;
		}
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
