/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiry.java
*@FileTitle : SPP TRS 메인화면 Invoice List Value Object
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
* 2006-12-28 sunghwan cho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import java.util.Arrays;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS 메인화면 Invoice List Value Object<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class InvoiceCreationInquiryResponse {
	private String id = "InvoiceCreationInquiryResponse";
	private String status = "";
	private int count = 0;
	private InvoiceCreationInquiry[] invoiceData = null;
	
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
	/**
	 * 
	 * @return
	 */
	public InvoiceCreationInquiry[] getInvoiceData() {
		InvoiceCreationInquiry[] rtnList = null;
		if(this.invoiceData != null){
			rtnList = Arrays.copyOf(invoiceData, invoiceData.length);
		}
		return rtnList;
	}
	/**
	 * 
	 * @param invoiceData
	 */
	public void setInvoiceData(InvoiceCreationInquiry[] invoiceData) {
		if(invoiceData != null){
			InvoiceCreationInquiry[] tmpList = Arrays.copyOf(invoiceData, invoiceData.length);
			this.invoiceData = tmpList;
		}
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
}
