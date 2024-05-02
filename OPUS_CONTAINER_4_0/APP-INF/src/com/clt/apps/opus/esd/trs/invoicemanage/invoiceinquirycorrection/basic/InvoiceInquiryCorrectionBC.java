/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InvoiceInquiryCorrectionBC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-invoicemanage Business Logic Command Interface<br>
 * 
 * @author
 * @see EsdTrs0030EventResponse
 * @since J2EE 1.4
 */
public interface InvoiceInquiryCorrectionBC {

	/**
	 * Delete event processing<br>
	 * confrimInvoice - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteInvoice(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * confrimInvoice - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmCancelInvoice(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * confrimCancelInvoice - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInvoice(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * saveHold - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse saveHold(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * InvoiceInquiryCorrection - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvoiceInquiryCorrectionList(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * InvoiceInquiryCorrection - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse modifyInvOfcCdForSPP(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * InvoiceInquiryCorrection - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvoiceConfrimAmt(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * InvoiceInquiryCorrection - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvoiceInquirySecondExcelForm(Event e) throws EventException;
}