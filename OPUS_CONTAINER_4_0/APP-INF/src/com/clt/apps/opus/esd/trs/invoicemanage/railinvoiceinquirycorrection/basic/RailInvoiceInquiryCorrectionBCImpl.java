/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RailInvoiceInquiryCorrectionBCImpl.java
 *@FileTitle : Service Provider from the W / O after running a batch Confirm Invoice for payment or, Confirmed or Interfaced Invoice screen to cancel the
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.basic;

import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.event.EsdTrs0046Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.integration.RailInvoiceInquiryCorrectionDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS business logic handling.<br>
 * 
 * @author
 * @see ESD_TRS_046EventResponse,RailInvoiceInquiryCorrectionBC each DAO class reference
 * @since J2EE 1.4
 */
public class RailInvoiceInquiryCorrectionBCImpl extends BasicCommandSupport implements RailInvoiceInquiryCorrectionBC {

	private transient RailInvoiceInquiryCorrectionDBDAO dbDao = null;

	/**
	 * RailInvoiceInquiryCorrectionBCImpl object creation<br>
	 * RailInvoiceInquiryCorrectionDBDAO creation<br>
	 */
	public RailInvoiceInquiryCorrectionBCImpl() {
		dbDao = new RailInvoiceInquiryCorrectionDBDAO();
	}

	/**
	 * retrieve event handling<br>
	 * RailInvoiceInquiryCorrection screen views for event handling<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailInvoiceInquiryCorrectionList(Event e) throws EventException {
		EsdTrs0046Event event = (EsdTrs0046Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVo(dbDao.searchRailInvoiceInquiryCorrectionList(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * multi-event processing ESD_TRS_046<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailInvoiceHold(Event e) throws EventException {
		EsdTrs0046Event event = (EsdTrs0046Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multiRailInvoiceHold(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Delete the event-handling<br>
	 * Delete the event handling for ESD_TRS_046<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse removeRailInvoiceInquiryCorrection(Event e) throws EventException {
		EsdTrs0046Event event = (EsdTrs0046Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.removeRailInvoiceInquiryCorrection(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * On-screen multi-event processing ESD_TRS_046<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailInvoiceConfirmCancel(Event e) throws EventException {
		EsdTrs0046Event event = (EsdTrs0046Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multiRailInvoiceConfirmCancel(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * InvoiceInquiryCorrection - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUsRailInvoiceInquirySecondExcelForm(Event e) throws EventException {
		EsdTrs0046Event event = (EsdTrs0046Event) e;
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(dbDao.searchUsRailInvoiceInquirySecondExcelForm(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * invoicemanage finishing business scenarios<br>
	 * At the end of business-related internal objects InvoiceInquiryCorrection release scenarios<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

}