/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : commonSC.java
*@FileTitle : EsdSce114
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.common;

import java.util.List;

import com.clt.apps.opus.esd.sce.common.popup.basic.EqYardOrzBC;
import com.clt.apps.opus.esd.sce.common.popup.basic.EqYardOrzBCImpl;
import com.clt.apps.opus.esd.sce.common.popup.event.EqYardOrzEvent;
import com.clt.apps.opus.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.EQYARDManageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * common Business Logic ServiceCommand - common to handle a business transaction.
 * 
 * @author 
 * @see popupDBDAO
 * @since J2EE 1.6
 */

public class EqYardOrzSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * common system business scenarios Predecessors<br>
	 * Business scenarios related internal object creation during calls<br>
	 */
	public void doStart() {
		log.debug("commonSC Start");
		try {
			// comment --> Log in Check part
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * common system business scenarios and finishing<br>
	 * Released at the end of business scenarios related internal objects<br>
	 */
	public void doEnd() {
		log.debug("commonSC End");
	}

	/**
	 * Perform tasks that correspond to each event scenario<br>
	 * common system of a quarter of all the events that occur in business processing<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// If the SC is used to handle multiple events that need to be
		if (e.getEventName().equalsIgnoreCase("EqYardOrzEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchEQYARDManage(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchExptMapgOfc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchExptInqMapgOfc(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * EsdSce114 : [Evnet]<br>
	 * [Business destination] to [act] is.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQYARDManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EqYardOrzEvent event = (EqYardOrzEvent)e;
		EqYardOrzBC command = new EqYardOrzBCImpl();

		try{
			List<EQYARDManageVO> list = command.searchEQYARDManage(event.getEqYARDManageConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * EsdSce114 : [Evnets]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExptMapgOfc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EqYardOrzEvent event = (EqYardOrzEvent)e;
		EqYardOrzBC command = new EqYardOrzBCImpl();

		try{
			List<ComOfficeManagementVO> list = command.searchExptMapgOfc(event.getComOfficeManagementVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * EsdSce114 : [Evnet]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExptInqMapgOfc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EqYardOrzEvent event = (EqYardOrzEvent)e;
		EqYardOrzBC command = new EqYardOrzBCImpl();

		try{
			List<ComOfficeManagementVO> list = command.searchExptInqMapgOfc(event.getComOfficeManagementVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
}