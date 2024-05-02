/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : InvoiceInquiryCorrectionBC.java
 *@FileTitle : Service Provider from the W / O after running a batch Confirm Invoice for payment or, Confirmed or Interfaced Invoice screen to cancel the
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS business logic handling.<br>
 * 
 * @author chkong
 * @see EsdTrs0046EventResponse
 * @since J2EE 1.4
 */
public interface RailInvoiceInquiryCorrectionBC {

	/**
	 * retrieve event handling<br>
	 * RailInvoiceInquiryCorrection screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailInvoiceInquiryCorrectionList(Event e) throws EventException;

	/**
	 * Multi-event processing<br>
	 * multi-event processing ESD_TRS_046<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailInvoiceHold(Event e) throws EventException;

	/**
	 * Delete the event-handling<br>
	 * Delete the event handling for ESD_TRS_046<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse removeRailInvoiceInquiryCorrection(Event e) throws EventException;

	/**
	 * Multi-event processing<br>
	 * On-screen multi-event processing ESD_TRS_046<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailInvoiceConfirmCancel(Event e) throws EventException;

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUsRailInvoiceInquirySecondExcelForm(Event e) throws EventException;

}