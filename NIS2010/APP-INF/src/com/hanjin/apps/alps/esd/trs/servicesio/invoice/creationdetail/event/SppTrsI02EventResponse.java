/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SppTrsI02EventResponse.java
*@FileTitle : SPP TRS Event Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS Event Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class SppTrsI02EventResponse extends EventResponseSupport {
	static final long serialVersionUID = 1L; 
	
	private String id = "SppTrsI02EventResponse";
	private InvoiceCreationInquiry[] invoiceCreationData = null;
	
	/**
	 * 
	 *
	 */
	public SppTrsI02EventResponse() {
	}
	/**
	 * 
	 * @param invoiceCreationData
	 */
	public SppTrsI02EventResponse(InvoiceCreationInquiry[] invoiceCreationData) {
		this.invoiceCreationData = invoiceCreationData;
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

}