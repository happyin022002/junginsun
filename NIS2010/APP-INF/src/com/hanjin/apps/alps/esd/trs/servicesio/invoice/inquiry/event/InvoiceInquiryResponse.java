/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiry.java
*@FileTitle : SPP TRS Response Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.InvoiceInquiry;

/**
 * Response Value Object<br>
 * - SPP TRS Response Value Object<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class InvoiceInquiryResponse {
	private String id = "InvoiceInquiryResponse";
	private String status = "";
	private int count = 0;
	private InvoiceInquiry[] inquiryData = null;
	private InvoiceInquiry invoiceData = null;
	
	/**
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}
	/**
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * 
	 * @return
	 */
	public InvoiceInquiry[] getInquiryData() {
		InvoiceInquiry[] rtnList = null;
		if(this.inquiryData != null){
			rtnList = Arrays.copyOf(inquiryData, inquiryData.length);
		}
		return rtnList;
	}
	/**
	 * 
	 * @param inquiryData
	 */
	public void setInquiryData(InvoiceInquiry[] inquiryData) {
		if(inquiryData != null){
			InvoiceInquiry[] tmpList = Arrays.copyOf(inquiryData, inquiryData.length);
			this.inquiryData = tmpList;
		}
	}
	/**
	 * 
	 * @return
	 */
	public InvoiceInquiry getInvoiceHeaderData() {
		return this.invoiceData;
		
	}
	/**
	 * 
	 * @param inquiryData
	 */
	public void setInvoiceHeaderData(InvoiceInquiry invoiceData) {
		this.invoiceData = invoiceData;
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
	public String getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
}
