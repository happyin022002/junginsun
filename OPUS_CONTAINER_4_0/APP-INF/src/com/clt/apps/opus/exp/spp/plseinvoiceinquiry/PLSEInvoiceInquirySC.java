/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PLSEInvoiceInquirySC.java
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.exp.spp.plseinvoiceinquiry;

import java.util.List;

//import com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.integration;
import com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.basic.InvoiceInquiryBC;
import com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.basic.InvoiceInquiryBCImpl;
import com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.event.ExpSpp0302Event;
import com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.vo.PayableInvoiceDataVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * Handling the business transaction of ALPS-PLSEInvoiceInquiry Business Logic ServiceCommand - ALPS-PLSEInvoiceInquiry
 * 
 * @author 
 * @see InvoiceInquiryDBDAO
 * @since J2EE 1.6
 */
public class PLSEInvoiceInquirySC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Preceding the business scenario of PLSEInvoiceInquiry system<br>
	 * Creating the related objects<br>
	 */
	public void doStart() {
		log.debug("Start of PLSEInvoiceInquirySC");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Closing the business scenario of PLSEInvoiceInquiry system<br>
	 * Clearing the related objects<br>
	 */
	public void doEnd() {
		log.debug("End of PLSEInvoiceInquirySC");
	}

	/**
	 * Calling the method by the event name and the form command<br>
	 * 
	 * @param Event e
	 * @return EventResponse response 
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if(e.getEventName().equalsIgnoreCase("ExpSpp0302Event")){  //EXP_SPP_0302 Rental payable invoice inquiry by Lessee via SPP UI
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  //when Retreive button click
				eventResponse = searchPayableInvoiceService(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * 
	 * Retrieving Rental payable invoice inquiry<br>
	 * 
	 * @param Event e
	 * @return EventResponse response 
	 * @exception EventException
	 */
	private EventResponse searchPayableInvoiceService(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ExpSpp0302Event event = (ExpSpp0302Event)e;
		InvoiceInquiryBC command = new InvoiceInquiryBCImpl();
		try{
			List<PayableInvoiceDataVO> list = command.searchPayableInvoiceBasic(event.getPayableInvoiceDataVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	

		return eventResponse;
	}
	

	
}