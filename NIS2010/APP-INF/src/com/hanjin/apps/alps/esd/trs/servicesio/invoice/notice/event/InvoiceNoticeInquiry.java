/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiry.java
*@FileTitle : SPP TRS 메인화면 Invoice List Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 subghwan cho : vendorCode 추가
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.1
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS 메인화면 Invoice List Value Object<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class InvoiceNoticeInquiry {
	private int seq = 0;
	private String invoiceDate = "";
	private String invoiceNo = "";
	private String status = "";
	private String vendorCode = "";
	private String parentVendorCode = "";
	
    /**
     * 생성자<br>
     * 
     * @param void
     * @return void
     * @exception 
     */
	public InvoiceNoticeInquiry() {
	}
    /**
     * getInvoiceDate<br>
     * 
     * @param void
     * @return invoiceDate String
     * @exception 
     */
	public String getInvoiceDate() {
		return invoiceDate;
	}
    /**
     * setInvoiceDate<br>
     * 
     * @param invoiceDate String
     * @return void
     * @exception 
     */
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
    /**
     * getInvoiceNo<br>
     * 
     * @param void
     * @return invoiceNo String
     * @exception 
     */
	public String getInvoiceNo() {
		return invoiceNo;
	}
    /**
     * setInvoiceNo<br>
     * 
     * @param invoiceNo String 
     * @return void
     * @exception 
     */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
    /**
     * getSeq<br>
     * 
     * @param void
     * @return seq int
     * @exception 
     */
	public int getSeq() {
		return seq;
	}
    /**
     * setSeq<br>
     * 
     * @param seq int
     * @return void
     * @exception 
     */
	public void setSeq(int seq) {
		this.seq = seq;
	}
    /**
     * getStatus<br>
     * 
     * @param void
     * @return status String
     * @exception 
     */
	public String getStatus() {
		return status;
	}
    /**
     * setStatus<br>
     * 
     * @param status String
     * @return void
     * @exception 
     */
	public void setStatus(String status) {
		this.status = status;
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
	
}
