/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceInquiryCorrectionBC.java
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-30
*@LastModifier : chkong
*@LastVersion : 1.0
* 2007-01-30 chkong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-invoicemanage Business Logic Command Interface<br>
 * - ESD-invoicemanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author chkong
 * @see EsdTrs0046EventResponse 참조
 * @since J2EE 1.4
 */
public interface RailInvoiceInquiryCorrectionBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailInvoiceInquiryCorrectionList(Event e) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_046 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailInvoiceHold(Event e) throws EventException;
	
	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_046 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse removeRailInvoiceInquiryCorrection(Event e) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_046 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailInvoiceConfirmCancel(Event e) throws EventException;
	
	
}