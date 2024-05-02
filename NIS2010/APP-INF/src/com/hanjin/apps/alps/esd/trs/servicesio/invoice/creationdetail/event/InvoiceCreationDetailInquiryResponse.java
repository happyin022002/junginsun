/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationDetailInquiryResponse.java
*@FileTitle : SPP TRS Invoice Creation Detail Response Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import java.util.Arrays;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS Invoice Creation Detail Response Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceCreationDetailInquiryResponse {
	private String id = "InvoiceCreationDetailInquiryResponse";
	private String status = "";
	private int count = 0;
	private InvoiceCreationInquiry[] invoiceCreationData = null;
	
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
