/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeCharterInOutFleetManagementSC.java
*@FileTitle : TEU Range Target
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.basic.TCharIODeliveryScheduleBC;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.basic.TCharIODeliveryScheduleBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.event.EsmFms0019Event;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.event.EsmFms0020Event;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.event.EsmFms0059Event;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchDeliveryScheduleListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchShipYardNameListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.basic.TCharIODockScheduleBC;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.basic.TCharIODockScheduleBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event.EsmFms00541Event;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event.EsmFms00542Event;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event.EsmFms0055Event;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event.EsmFms0057Event;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CustomDckSkdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleGraphListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.basic.TCharterIOInquiryBC;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.basic.TCharterIOInquiryBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event.EsmFms0008Event;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event.EsmFms0010Event;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event.EsmFms0060Event;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetSumListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusSumListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountSumListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-TimeCharterInOutFleetManagement Business Logic ServiceCommand - Handling Business Transaction of OPUS-TimeCharterInOutFleetManagement
 * 
 * @author 
 * @see TCharterStandardPrimeCostDBDAO
 * @since J2EE 1.4
 */

public class TimeCharterInOutFleetManagementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Pre-work for TimeCharterInOutFleetManagement system Business scenario<br>
	 * Generating Inner-Object when calling ESM_FMS_0062 Business scenario<br>
	 */
	public void doStart() {
		try {
			// Checking Log-in
			account = getSignOnUserAccount();
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
		}
	}

	/**
	 * Closing work for TimeCharterInOutFleetManagement system Business scenario<br>
	 * Terminating related Inner-Object when finishing ESM_FMS_0062 Business scenario<br>
	 */
	public void doEnd() {
		log.debug("TimeCharterInOutFleetManagementSC 종료");
	}

	/**
	 * Branch processing of all events generated in OPUS-TimeCharterInOutFleetManagement system <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Required to use in case SC handles several events 
		if (e.getEventName().equalsIgnoreCase("EsmFms0082Event")) {	// Ship Yard Select – Pop up
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchShipYardNameList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0019Event")) {	// NB Delivery Schedule Creation
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeliveryScheduleList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDeliverySchedule(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0020Event")) {	// NB Delivery Schedule Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeliveryScheduleList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0059Event")) {	// Ship Yard Registration / Window
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchShipYardNameList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageShipYardName(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms00541Event")) {	// D/Dock Schedule Input 1
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDockEstimatedScheduleList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDockEstimatedScheduleList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms00542Event")) {	// D/Dock Schedule Input 2
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDockRecommendScheduleList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDockRecommendScheduleList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0055Event")) {	// D/Dock Schedule Review - Graph
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDryDockScheduleGraphList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0057Event")) {	// D/Dock Schedule Review
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDryDockScheduleList(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0060Event")) {	// Fleet Status
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFleetStatusList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0010Event")) {	// Fleet Status
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStatementOfAccountList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0008Event")) {	// Fleet Status
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCapitalBudgetList(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * Retrieving ShipYardName information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchShipYardNameList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		List<SearchShipYardNameListVO> searchShipYardNameListVO = null;
		
		TCharIODeliveryScheduleBC command = new TCharIODeliveryScheduleBCImpl();
		
		try {
			if (e.getEventName().equalsIgnoreCase("EsmFms0059Event")) {	// Ship Yard Registration / Window
				searchShipYardNameListVO = command.searchShipYardNameList();
			} else {													// Ship Yard Select – Pop up
				searchShipYardNameListVO = command.searchShipYardNameList();
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(searchShipYardNameListVO);
			return eventResponse;
		
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Saving ShipYardName information(Insert / Modify / Delete)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageShipYardName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0059Event event = (EsmFms0059Event)e;
		TCharIODeliveryScheduleBC command = new TCharIODeliveryScheduleBCImpl();
		try{
			begin();
			command.manageShipYardName(event.getCustomShpYdVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchShipYardNameList(e);
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Retrieving DeliverySchedule information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeliveryScheduleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		List<SearchDeliveryScheduleListVO> searchDeliveryScheduleListVO = null;
		
		TCharIODeliveryScheduleBC command = new TCharIODeliveryScheduleBCImpl();
		
		try {
			if (e.getEventName().equalsIgnoreCase("EsmFms0019Event")) {	// NB Delivery Schedule Creation
				EsmFms0019Event event = (EsmFms0019Event)e;
				searchDeliveryScheduleListVO = command.searchDeliveryScheduleList(event.getCondDeliveryScheduleVO());
			} else {													// NB Delivery Schedule Inquiry
				EsmFms0020Event event = (EsmFms0020Event)e;
				searchDeliveryScheduleListVO = command.searchDeliveryScheduleList(event.getCondDeliveryScheduleVO());
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(searchDeliveryScheduleListVO);
			return eventResponse;
		
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Saving DeliverySchedule information(Insert / Modify / Delete)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDeliverySchedule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0019Event event = (EsmFms0019Event)e;
		TCharIODeliveryScheduleBC command = new TCharIODeliveryScheduleBCImpl();
		try{
			begin();
			command.manageDeliverySchedule(event.getCustomNewBldSkdVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchDeliveryScheduleList(e);
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Retrieving DockEstimatedSchedule information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDockEstimatedScheduleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms00541Event event = (EsmFms00541Event)e;
		
		TCharIODockScheduleBC command = new TCharIODockScheduleBCImpl();
	    
		try {
			List<CustomDckSkdVO > customDckSkdVO  = command.searchDockEstimatedScheduleList(event.getVslCd(), event.getDckSelCd());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(customDckSkdVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

	/**
	 * Re-Retrieving DockEstimatedSchedule information after Saving(Insert / Modify / Delete / Retrieve)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDockEstimatedScheduleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms00541Event event = (EsmFms00541Event)e;
		TCharIODockScheduleBC command = new TCharIODockScheduleBCImpl();
		try{
			
			begin();
			
			command.manageDockEstimatedSchedule(event.getCustomDckSkdVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchDockEstimatedScheduleList(e);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Re-Retrieving DockRecommendSchedule information after Saving(Insert / Modify / Delete / Retrieve)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDockRecommendScheduleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms00542Event event = (EsmFms00542Event)e;
		TCharIODockScheduleBC command = new TCharIODockScheduleBCImpl();
		try{
			
			begin();
			
			command.manageDockRecommendSchedule(event.getCustomDckSkdVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchDockRecommendScheduleList(e);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Retrieve DockRecommendSchedule information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDockRecommendScheduleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms00542Event event = (EsmFms00542Event)e;
		
		TCharIODockScheduleBC command = new TCharIODockScheduleBCImpl();
	    
		try {
			List<CustomDckSkdVO > customDckSkdVO  = command.searchDockRecommendScheduleList(event.getVslCd(), event.getDckSelCd());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(customDckSkdVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

	/**
	 * Retrieving DryDockScheduleGraph information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDryDockScheduleGraphList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0055Event event = (EsmFms0055Event)e;
		
		TCharIODockScheduleBC command = new TCharIODockScheduleBCImpl();
	    
		try {
			List<SearchDryDockScheduleGraphListVO > searchDryDockScheduleGraphListVO  = command.searchDryDockScheduleGraphList(event.getCondDryDockScheduleVO());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchDryDockScheduleGraphListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

	/**
	 * Retrieving DryDockSchedule information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDryDockScheduleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0057Event event = (EsmFms0057Event)e;
		
		TCharIODockScheduleBC command = new TCharIODockScheduleBCImpl();
	    
		try {
			List<SearchDryDockScheduleListVO > searchDryDockScheduleListVO  = command.searchDryDockScheduleList(event.getCondDryDockScheduleVO());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchDryDockScheduleListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	
	/**
	 * Retrieving FleetStatus information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFleetStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0060Event event = (EsmFms0060Event)e;
		TCharterIOInquiryBC command = new TCharterIOInquiryBCImpl();
		
		try {
			List<SearchFleetStatusListVO> searchFleetStatusListVO = command.searchFleetStatusList(event.getCondSearchFleetStatusVO());
			List<SearchFleetStatusSumListVO> searchFleetStatusSumListVO = command.searchFleetStatusSumList(event.getCondSearchFleetStatusSumVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(searchFleetStatusListVO);
			eventResponse.setRsVoList(searchFleetStatusSumListVO);
			return eventResponse;
		
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Statement Account information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStatementOfAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0010Event event = (EsmFms0010Event)e;
		TCharterIOInquiryBC command = new TCharterIOInquiryBCImpl();
		
		try {
			List<SearchStatementOfAccountListVO> searchStatementOfAccountList = command.searchStatementOfAccountList(event.getFletCtrtNo(), event.getHirNo());
			List<SearchStatementOfAccountSumListVO> searchStatementOfAccountSumList = command.searchStatementOfAccountSumList(event.getFletCtrtNo(), event.getHirNo());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(searchStatementOfAccountList);
			eventResponse.setRsVoList(searchStatementOfAccountSumList);
			return eventResponse;
		
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Capital Budget data
	 * Retrieving Total Amount by Currency
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCapitalBudgetList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		EsmFms0008Event event = (EsmFms0008Event)e;
		
		TCharterIOInquiryBC command = new TCharterIOInquiryBCImpl();
		
		try {
			List<SearchCapitalBudgetListVO> searchCapitalBudgetList = command.searchCapitalBudgetList(event.getEffDt(), event.getExpDt(), event.getVslCd());
			List<SearchCapitalBudgetSumListVO> searchCapitalBudgetSumList = command.searchCapitalBudgetSumList(event.getEffDt(), event.getExpDt(), event.getVslCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchCapitalBudgetList);
			eventResponse.setRsVoList(searchCapitalBudgetSumList);
			
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
}