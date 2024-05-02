/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InvoiceInquiryCorrectionBCImpl.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.basic;

import com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.event.EsdTrs0030Event;
import com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.integration.InvoiceInquiryCorrectionDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-invoicemanage Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see ESD_TRS_030EventResponse,InvoiceInquiryCorrectionBC
 * @since J2EE 1.4
 */
public class InvoiceInquiryCorrectionBCImpl extends BasicCommandSupport implements InvoiceInquiryCorrectionBC {

	// Database Access Object
	private transient InvoiceInquiryCorrectionDBDAO dbDao = null;

	/**
	 * Add event processing<br>
	 * ESD_TRS_030<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;

		try {
			dbDao.deleteInvoice(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Add event processing<br>
	 * ESD_TRS_030<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;

		try {
			dbDao.confirmInvoice(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Add event processing<br>
	 * ESD_TRS_030<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmCancelInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;

		try {
			dbDao.confirmCancelInvoice(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Add event processing<br>
	 * ESD_TRS_030<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse saveHold(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;

		try {
			dbDao.saveHold(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * InvoiceInquiryCorrectionBCImpl <br>
	 * InvoiceInquiryCorrectionDBDAO<br>
	 */
	public InvoiceInquiryCorrectionBCImpl() {
		dbDao = new InvoiceInquiryCorrectionDBDAO();
	}

	/**
	 * Inquiry event process<br>
	 * InvoiceInquiryCorrection - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceInquiryCorrectionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;

		DBRowSet rowSet = null; // DB ResultSet for sending data
		try {
			rowSet = dbDao.searchInvoiceInquiryCorrectionList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
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
	public EventResponse modifyInvOfcCdForSPP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;

		try {
			dbDao.modifyInvOfcCdForSPP(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
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
	public EventResponse searchInvoiceConfrimAmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;

		DBRowSet rowSet = null; // DB ResultSet for sending data
		try {
			rowSet = dbDao.searchInvoiceConfrimAmt(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
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
	public EventResponse searchInvoiceInquirySecondExcelForm(Event e) throws EventException {
		EsdTrs0030Event event = (EsdTrs0030Event) e;
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(dbDao.searchInvoiceInquirySecondExcelForm(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * End process of invoicemanage task scenario<br>
	 * Releasing the related implicit object when InvoiceInquiryCorrection task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}