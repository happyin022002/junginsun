/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiry.java
*@FileTitle : SPP TRS Event Response Value Object
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
import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * Event Response Value Object<br>
 * - SPP TRS Event Response Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class SppTrsI05EventResponse extends EventResponseSupport {
	static final long serialVersionUID = 1L; 

	private String id = "SppTrsI05EventResponse";
	private InvoiceInquiry[] inquiryData = null;
	private InvoiceInquiry  invoiceData = null;
	String successFlag = "";
	
	/**
	 * 
	 *
	 */
	public SppTrsI05EventResponse() {
	}
	/**
	 * 
	 * @param surchargeData
	 */
	public SppTrsI05EventResponse(InvoiceInquiry[] surchargeData) {
		this.inquiryData = surchargeData;
	}
    /**
     *  SppTrsI05EventResponse 생성
     * @param inquiryData
     * @param successFlag
     */
    public SppTrsI05EventResponse(InvoiceInquiry[] inquiryData, String successFlag) {
        this.inquiryData = inquiryData;
        this.successFlag=successFlag;
    }
    
    /** 
     *  SppTrsI05EventResponse 생성
     * @param invoiceData
     * @param inquiryData
     * @param successFlag
     */
    public SppTrsI05EventResponse(InvoiceInquiry invoiceData, InvoiceInquiry[] inquiryData, String successFlag) {
        this.inquiryData = inquiryData;
        this.invoiceData = invoiceData;
        this.successFlag=successFlag;
    }
	/**
	 * 
	 */
	public String toString() {
		return id;
	}
	/**
	 * 
	 */
	public String getEventName() {
		return id;
	}
	/**
	 * 
	 * @return
	 */
	public InvoiceInquiry[] getInvoiceData() {
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
	public void setInvoiceData(InvoiceInquiry[] inquiryData) {
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
	 * @param inquiryData
	 */
	public void setInvoiceInquiryExcelHeader(InvoiceInquiry invoiceData) {
		this.invoiceData = invoiceData;
	}

}