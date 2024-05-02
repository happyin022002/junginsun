/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : railInvoiceauditBC.java
*@FileTitle : USA Rail Invoice Agree and Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.basic;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TrsTrspRailInvDtlVO;

import java.util.ArrayList;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS business logic handling.<br>
 * 
 * @author chkong
 * @see EsdTrs0038EventResponse 참조
 * @since J2EE 1.4
 */
public interface RailInvoiceauditBC  
{
	/**
	 * Verify Cntr No event handling<br>
	 * railInvoiceaudit screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_923Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public ArrayList verifyInvoiceFileImportInvNo(Event e) throws EventException;
	
	/**
	 * Verify Cntr No event handling<br>
	 * railInvoiceaudit screen views for event handling<br>
	 * 
	 * @param trsTrspRailInvDtlVO
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public DBRowSet verifyInvoiceFileImportVndrSetList(TrsTrspRailInvDtlVO trsTrspRailInvDtlVO) throws EventException;
	
	
	/**
	 * Verify Cntr No event handling<br>
	 * railInvoiceaudit screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public ArrayList verifyInvoiceFileImportEqNo(Event e) throws EventException;
	
	/**
	 * retrieve event handling<br>
	 * Viewed on-screen event handling for CLM History<br>
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void searchReAuditVerify(Event e) throws EventException;
	
	/**
	 * Payment VNDR Info Event Handling<br>
	 * railInvoiceaudit screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentVndrList(Event e) throws EventException;
	
	/**
	 * retrieve event handling<br>
	 * Railinvoiceaudit screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailinvoiceauditList(Event e) throws EventException;
	
	/**
	 * retrieve event handling<br>
	 * Container History Inquiry event handling on the screen<br>
	 * 
	 * @param e ESD_TRS_924Event
	 * @return EventResponse ESD_TRS_924EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentHistoryList(Event e) throws EventException;
	
	/**
	 * Modified event handling<br>
	 * On-screen multi-event processing ESD_TRS_038<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyRailinvoiceaudit(Event e) throws EventException;
	
	/**
	 * retrieve event handling<br>
	 * Viewed on-screen event handling for CLM History<br>
	 * 
	 * @param e ESD_TRS_925Event
	 * @return EventResponse ESD_TRS_925EventResponse
	 * @exception EventException
	 */
	public EventResponse searchReAuditInfoList(Event e) throws EventException;
	
	/**
	 * retrieve event handling<br>
	 * Re Audit viewed on-screen event handling<br>
	 * 
	 * @param e ESD_TRS_925Event
	 * @return EventResponse ESD_TRS_925EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerInfo(Event e) throws EventException;

	/**
	 * retrieve event handling<br>
	 * Invoice information is stored in ApPayInvVO.<br>
	 * 
	 * @param invNo
	 * @param ofcCd
	 * @return ApPayInvVO
	 * @throws EventException
	 */
	public ApPayInvVO searchApPayInvMain(String invNo, String ofcCd) throws EventException;
	
	/**
	 * retrieve event handling<br>
	 * Invoice Detail information is stored in ApPayInvDtlVOs.<br>
	 * 
	 * @param invNo String
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDetail(String invNo) throws EventException;

	/**
	 * updateRgstNoInvWrk<br>
	 * 
	 * @param apPayInvVO
	 * @exception EventException
	 */
	public void updateRgstNoRailInvWrk(ApPayInvVO apPayInvVO) throws EventException;	
	
	
	/**
	 * Verify Cntr No event handling<br>
	 * @param trsTrspRailInvDtlVO
	 * @return
	 * @throws EventException
	 */
	public String verifyInvoiceFileImportVndrSetListForMultiSo(TrsTrspRailInvDtlVO trsTrspRailInvDtlVO) throws EventException;
	
}