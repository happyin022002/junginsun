/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiryResponse.java
*@FileTitle : SPP TRS 메인화면 Invoice Response Value Object 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
* 2006-12-28 sunghwan cho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event.InvoiceNoticeInquiry;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS 메인화면 Invoice List Value Object<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class InvoiceNoticeInquiryResponse {
	private String status = "";
	private int count = 0;
	private int pendingInvoiceCount = 0;
	private InvoiceNoticeInquiry[] noticeData = null;
	
    /**
     * getCount<br>
     * 
     * @param void
     * @return count int
     * @exception 
     */
	public int getCount() {
		return count;
	}
    /**
     * setCount<br>
     * 
     * @param count int
     * @return void
     * @exception 
     */
	public void setCount(int count) {
		this.count = count;
	}
    /**
     * getPendingInvoiceCount<br>
     * 
     * @param void
     * @return pendingInvoiceCount int
     * @exception 
     */
	public int getPendingInvoiceCount() {
		return pendingInvoiceCount;
	}
    /**
     * setPendingInvoiceCount<br>
     * 
     * @param pendingInvoiceCount int
     * @return void
     * @exception 
     */
	public void setPendingInvoiceCount(int pendingInvoiceCount) {
		this.pendingInvoiceCount = pendingInvoiceCount;
	}
    /**
     * getInvoiceData<br>
     * 
     * @param void
     * @return noticeData InvoiceNoticeInquiry[]
     * @exception 
     */
	public InvoiceNoticeInquiry[] getInvoiceData() {
		InvoiceNoticeInquiry[] rtnList = null;
		if(this.noticeData != null){
			rtnList = Arrays.copyOf(noticeData, noticeData.length);
		}
		return rtnList;
	}
    /**
     * setInvoiceData<br>
     * 
     * @param noticeData InvoiceNoticeInquiry[]
     * @return void
     * @exception 
     */
	public void setInvoiceData(InvoiceNoticeInquiry[] noticeData) {
		if(noticeData != null){
			InvoiceNoticeInquiry[] tmpList = Arrays.copyOf(noticeData, noticeData.length);
			this.noticeData = tmpList;
		}
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
}
