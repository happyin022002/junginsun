/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : railInvoiceauditBC.java
*@FileTitle : USA Rail Invoice Agree and Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-08
*@LastModifier : chkong
*@LastVersion : 1.0
* 2006-12-08 chkong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.basic;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import java.util.ArrayList;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 * adfadfasdfsa
 * @author chkong
 * @see EsdTrs0038EventResponse 참조
 * @since J2EE 1.4
 */
public interface RailInvoiceauditBC  
{
	/**
	 * Payment Vndr Info 조회 이벤트 처리<br>
	 * railInvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_923Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public ArrayList verifyInvoiceFileImportInvNo(Event e) throws EventException;
	
	/**
	 * Payment Vndr Info 조회 이벤트 처리<br>
	 * railInvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_923Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public ArrayList verifyInvoiceFileImportVndrSetList(Event e) throws EventException;
	
	/**
	 * Payment Vndr Info 조회 이벤트 처리<br>
	 * railInvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public ArrayList verifyInvoiceFileImportSoIFList(Event e) throws EventException;
	
	/**
	 * Payment Vndr Info 조회 이벤트 처리<br>
	 * railInvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public ArrayList verifyInvoiceFileImportEqNo(Event e) throws EventException;
	
	/**
	 * Payment Vndr Info 조회 이벤트 처리<br>
	 * railInvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public DBRowSet[] searchReAuditVerify(Event e) throws EventException;
	
	/**
	 * Payment Vndr Info 조회 이벤트 처리<br>
	 * railInvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentVndrList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Railinvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailinvoiceauditList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Payment History화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_924Event
	 * @return EventResponse ESD_TRS_924EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentHistoryList(Event e) throws EventException;
	
	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_038 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyRailinvoiceaudit(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Re Audit 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_925Event
	 * @return EventResponse ESD_TRS_925EventResponse
	 * @exception EventException
	 */
	public EventResponse searchReAuditInfoList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Re Audit 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_925Event
	 * @return EventResponse ESD_TRS_925EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerInfo(Event e) throws EventException;
	
}