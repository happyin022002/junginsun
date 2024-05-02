/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SppTrsI10EventResponse.java
*@FileTitle : SPP TRS 메인화면 Invoice Response Event 
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
import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * SPP TRS Value Object<br>
 * - SPP TRS 메인화면 Invoice Response Event<br>
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,InvoiceNoticeBC 참조
 * @since J2EE 1.4
 */
public class SppTrsI10EventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;
	private String id = "SppTrsI10EventResponse";
	private int pendingInvoiceCount = 0;
	private InvoiceNoticeInquiry[] noticeData = null;
	
    /**
     * 생성자<br>
     * 
     * @param void
     * @return void
     * @exception 
     */
	public SppTrsI10EventResponse() {
	}
    /**
     * 생성자<br>
     * 
     * @param noticeData InvoiceNoticeInquiry[] 
     * @return void
     * @exception 
     */
	public SppTrsI10EventResponse(InvoiceNoticeInquiry[] noticeData) {
		this.noticeData = noticeData;
	}
    /**
     * toString<br>
     * 
     * @param void
     * @return id String
     * @exception 
     */
	public String toString() {
		return id;
	}
    /**
     * getEventName<br>
     * 
     * @param void
     * @return id String
     * @exception 
     */
	public String getEventName() {
		return id;
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
     * getInvoiceNoticeData<br>
     * 
     * @param void
     * @return noticeData InvoiceNoticeInquiry
     * @exception 
     */
	public InvoiceNoticeInquiry[] getInvoiceNoticeData() {
		InvoiceNoticeInquiry[] rtnList = null;
		if(this.noticeData != null){
			rtnList = Arrays.copyOf(noticeData, noticeData.length);
		}
		return rtnList;
	}
    /**
     * setInvoiceNoticeData<br>
     * 
     * @param noticeData InvoiceNoticeInquiry[]
     * @return void
     * @exception 
     */
	public void setInvoiceNoticeData(InvoiceNoticeInquiry[] noticeData) {
		if(noticeData != null){
			InvoiceNoticeInquiry[] tmpList = Arrays.copyOf(noticeData, noticeData.length);
			this.noticeData = tmpList;
		}
	}

}
