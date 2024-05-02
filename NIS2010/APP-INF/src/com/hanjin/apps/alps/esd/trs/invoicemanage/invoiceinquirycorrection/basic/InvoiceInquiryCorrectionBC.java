/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceInquiryCorrectionBC.java
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-26
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2007-01-26 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-invoicemanage Business Logic Command Interface<br>
 * - ESD-invoicemanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author poong_yeon
 * @see EsdTrs0030EventResponse 참조
 * @since J2EE 1.4
 */
public interface InvoiceInquiryCorrectionBC  {

	/**
	 * 삭제 이벤트 처리<br>
	 * confrimInvoice 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteInvoice(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * confrimInvoice 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmCancelInvoice(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * confrimCancelInvoice 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInvoice(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * saveHold 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse saveHold(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * saveHold 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse saveUpdUsrId(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvoiceInquiryCorrectionList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvoiceEdiPdfFile(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse modifyInvOfcCdForSPP(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvoiceConfrimAmt(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvoiceInquirySecondExcelForm(Event e) throws EventException;
	
	public EventResponse searchInvoiceInquiryIdaList(Event e) throws EventException;

}