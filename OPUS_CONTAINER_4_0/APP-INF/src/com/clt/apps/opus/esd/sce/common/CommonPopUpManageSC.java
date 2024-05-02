/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CommonPopUpManageSC.java
 *@FileTitle : EsdSce0103
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.common;

import java.util.List;

import com.clt.apps.opus.esd.sce.common.popup.basic.CommonPopUpManageBC;
import com.clt.apps.opus.esd.sce.common.popup.basic.CommonPopUpManageBCImpl;
import com.clt.apps.opus.esd.sce.common.popup.event.CommonPopUpManageEvent;
import com.clt.apps.opus.esd.sce.common.popup.vo.COPSummaryVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.ComVvdManagementVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.SearchContiManageVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.SearchSceClmDataVO;
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

public class CommonPopUpManageSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * common system business scenarios Predecessors<br>
	 * Business scenarios related internal object creation during calls<br>
	 */
	public void doStart() {
		log.debug("CommonPopUpManageSC Start");
		try {
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
		log.debug("CommonPopUpManageSC End");
	}

	/**
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		
		if (e.getEventName().equalsIgnoreCase("CommonPopUpManageEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCOPSmryManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVVDManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOfcManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchSCNOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchContiManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchSceClmList(e);
			}
		}
		return eventResponse; 
	}

	/**
	 * EsdSce0103 : [Events]<br>
	 * [Business target]to [Act] is.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
		CommonPopUpManageBC command = new CommonPopUpManageBCImpl();

		try {
			List<ComVvdManagementVO> list = command.searchVVDManage(event
					.getComVvdManagementConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EsdSce0103 : [Events]<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
		CommonPopUpManageBC command = new CommonPopUpManageBCImpl();

		try {
			List<ComOfficeManagementVO> list = command
					.searchServiceOfficeCodeManage(event
							.getComOfficeManagementVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EsdSce0103 : [Events]<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCOPSmryManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
		CommonPopUpManageBC command = new CommonPopUpManageBCImpl();

		try {
			List<COPSummaryVO> list = command.searchCOPSmryManage(event
					.getCopSummaryVO());
			COPSummaryVO vo = null;

			if (list.size() > 0) {
				vo = (COPSummaryVO) list.get(0);
				eventResponse.setETCData(vo.getColumnValues());
			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EsdSce0103 : [Events]<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCNOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
		CommonPopUpManageBC command = new CommonPopUpManageBCImpl();

		try {
			eventResponse = command.searchSCNOManage(event
					.getSCNOManagementVO());
			// eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EsdSce0107 : <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSceClmList(Event e) throws EventException {
    	log.debug("\n searchSceClmList start ");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
    	CommonPopUpManageBC command = new CommonPopUpManageBCImpl();
        
        try {
            List<SearchSceClmDataVO> list = command.searchSceClmList(event.getSceClmInfo());
            eventResponse.setRsVoList(list);
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    	return eventResponse;
    }
	
	/**
	 * Country Inquery<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContiManage(Event e) throws EventException {
		log.debug("\n searchContiManage start ");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
    	CommonPopUpManageBC command = new CommonPopUpManageBCImpl();

		try {
			List<SearchContiManageVO> list = command.searchContiManage(event.getContiInfo());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    	return eventResponse;
	}
	
}