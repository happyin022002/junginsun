/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalInvoiceInquiryBC.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2007-01-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * SPP_TES Business Logic Command Interface<br>
 * - SPP_TES에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author doomi
 * @see SPP_TES_005EventResponse 참조
 * @since J2EE 1.4
 */
public interface TerminalInvoiceInquiryBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * TerminalInvoiceInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e SPP_TES_005Event
	 * @return EventResponse SPP_TES_005EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceList(Event e) throws EventException;

	
	/**
	 * 엑셀  이벤트 처리<br>
	 * TerminalInvoiceInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e SPP_TES_005Event
	 * @return EventResponse SPP_TES_005EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceExcelPrint(Event e) throws EventException;
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMarineTerminalInvoiceDiscrepancyCntr(Event e) throws EventException;
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchOffDockCYInvoiceDiscrepancyCntr(Event e)throws EventException;
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMarineTerminalStorageInvoiceDiscrepancyCntr(Event e) throws EventException;
}