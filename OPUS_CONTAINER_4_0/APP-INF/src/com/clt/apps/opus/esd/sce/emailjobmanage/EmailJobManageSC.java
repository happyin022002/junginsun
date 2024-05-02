/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmailJobManageSC.java
*@FileTitle : VSL SKD e-mailing Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage;

import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBCImpl;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.event.EsdSce0119Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * EmailJobManage Business Logic ServiceCommand - EmailJobManage to handle a business transaction.
 * 
 * @author 
 * @see VskEmailSetupDBDAO
 * @since J2EE 1.6
 */

public class EmailJobManageSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * EmailJobManage system business scenarios Predecessors<br>
	 * Business scenarios related internal object creation during calls<br>
	 */
	public void doStart() {
		log.debug("EmailJobManageSC Start");
		try {
			// comment --> Log in Check part
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * EmailJobManage business scenarios and finishing<br>
	 * Released at the end of business scenarios related internal objects<br>
	 */
	public void doEnd() {
		log.debug("EmailJobManageSC End");
	}

	/**
	 * Perform tasks that correspond to each event scenario<br>
	 * EmailJobManage system of a quarter of all the events that occur in business processing<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// If the SC is used to handle multiple events that need to be
		if (e.getEventName().equalsIgnoreCase("EsdSce0119Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVslSkdEmlSetUp();
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = addVslSkdEmlSetUp(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeVslSkdEmlSetUp(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLaneVerify(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPortVerify(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * Destination Lookup VSL E-MAIL<br>
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVslSkdEmlSetUp() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
			VskEmailSetupBC command = new VskEmailSetupBCImpl();
			eventResponse = command.searchVslSkdEmlSetUp();
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;		
	}
	
	
	/**
	 * Add and change the target VSL E-MAIL<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse addVslSkdEmlSetUp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0119Event event = (EsdSce0119Event)e;
		// The result of user requests (DB Result Set, object, value, etc.) containing the object
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			VskEmailSetupBC command = new VskEmailSetupBCImpl();
			command.addVslSkdEmlSetUp(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Deleting a destination VSL E-MAIL<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeVslSkdEmlSetUp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0119Event event = (EsdSce0119Event)e;
		// The result of user requests (DB Result Set, object, value, etc.) containing the object
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			VskEmailSetupBC command = new VskEmailSetupBCImpl();
			command.removeVslSkdEmlSetUp(event); 
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Verify the destination lookup Lane<br>
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneVerify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0119Event event = (EsdSce0119Event)e;
		// The result of user requests (DB Result Set, object, value, etc.) containing the object
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
			VskEmailSetupBC command = new VskEmailSetupBCImpl();
			eventResponse = command.searchLaneVerify(event);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;		
	}
	
	/**
	 * Verify the destination Port Lookup<br>
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPortVerify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0119Event event = (EsdSce0119Event)e;
		// The result of user requests (DB Result Set, object, value, etc.) containing the object
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			VskEmailSetupBC command = new VskEmailSetupBCImpl();
			eventResponse = command.searchPortVerify(event);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;		
	}
}