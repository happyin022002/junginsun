/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationBC.java
*@FileTitle : SPP TRS 메인화면 Invoice 조회 Basic Command 
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-05-15 sunghwan cho : searchInvoiceInquiryExcelExtract 메서드 추가
*@LastModifyDate : 2007-05-15
*@LastModifier : sunghwan cho
*@LastVersion : 1.1
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.InvoiceInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.SppTrsI05EventResponse;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * Basic Command<br>
 * - SPP TRS Invoice Inquiry Basic Command<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public interface InvoiceInquiryBC  {

	/**
	 * searchInvoiceInquiryList<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response InvoiceInquiry[]
	 * @exception EventException
	 */
	public InvoiceInquiry[] searchInvoiceInquiryList(Event e) throws EventException;

	/**
	 * searchInvoiceInquiryExcelExtract<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response InvoiceInquiry[]
	 * @exception EventException
	 */
	public InvoiceInquiry[] searchInvoiceInquiryExcelExtract(Event e) throws EventException;
	/**
	 * searchInvoiceInquiryExcelHeader<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response InvoiceInquiry
	 * @exception EventException
	 */
	public InvoiceInquiry searchInvoiceInquiryExcelHeader(Event e) throws EventException;


	/**
	 * searchInvoiceEquipmentList<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param vendorCode String
	 * @param invoiceNo String
	 * @return response InvoiceCreationInquiry[]
	 * @exception EventException
	 */
	public InvoiceCreationInquiry[] searchInvoiceEquipmentList(String vendorCode, String invoiceNo) throws EventException;

}