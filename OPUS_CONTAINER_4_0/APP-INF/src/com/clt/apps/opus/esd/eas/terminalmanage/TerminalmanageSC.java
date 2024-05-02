/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TerminalmanageSC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.eas.terminalmanage;

import com.clt.apps.opus.esd.eas.terminalmanage.basic.RehandExpmanageBC;
import com.clt.apps.opus.esd.eas.terminalmanage.basic.RehandExpmanageBCImpl;
import com.clt.apps.opus.esd.eas.terminalmanage.event.EsdEas0001Event;
import com.clt.apps.opus.esd.eas.terminalmanage.event.EsdEas0901Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * TerminalmanageSC PDTO(Data Transfer Object including Parameters)<br>
 */
public class TerminalmanageSC extends ServiceCommandSupport {

	
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * EAS preceding process for biz scenario<br>
     * TransportmanageSC related objects creation<br>
     */
    public void doStart() {
        try {
         
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("TransportmanageSC Operation error " + e.toString(), e);
        }
    }

    /**
     * EAS biz scenario closing<br>
     * TransportmanageSC clearing related objects<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("TransportmanageSC End");
    }

	/**
	 * perform<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */    
	public EventResponse perform(Event e) throws EventException {

        EventResponse eventResponse = null;
       
        if (e.getEventName().equalsIgnoreCase("EsdEas0001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
                eventResponse = searchRehandTPBCheckList(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("ESD_EAS_0901Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchRehandExpnAudRmk(e);
	        } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
	            eventResponse = multiRehandExpnAudRmk(e);
	        }
        }
		return eventResponse;
	}

	/**
	 * search RehandTPB Check List.<br>
	 * 
	 * @return e
	 * @throws EventException
	 */    
	private EventResponse searchRehandTPBCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0001Event event = (EsdEas0001Event)e;
		

		EventResponse eventResponse = null;
		
		try {
			RehandExpmanageBC command = new RehandExpmanageBCImpl();
			eventResponse = command.searchRehandTPBCheckList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Expense Audit Remark Retrieve
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchRehandExpnAudRmk(Event e) throws EventException {
    	EsdEas0901Event	event	= (EsdEas0901Event)e;
        EventResponse eventResponse = null;
        
        try {
        	RehandExpmanageBC command = new RehandExpmanageBCImpl();
            eventResponse = command.searchRehandExpnAudRmk(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
	
    /**
	 * Expense Audit Remark Modify 
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse multiRehandExpnAudRmk(Event e) throws EventException {
    	EsdEas0901Event	event	= (EsdEas0901Event)e;
    	
        EventResponse eventResponse = null;
        try {
        	begin();
            
        	RehandExpmanageBC	command	= new RehandExpmanageBCImpl();
            eventResponse	= command.multiRehandExpnAudRmk(event);
            
            commit();
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    	
	
}
	
	
