/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeCharterInOutFleetManagementSC.java
*@FileTitle : TEU Range Target
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.15 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.basic.TCharterIOBasicRegisterBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.basic.TCharterIOBasicRegisterBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0068Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenuePortListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.basic.TCharIODeliveryScheduleBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.basic.TCharIODeliveryScheduleBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.event.EsmFms0019Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.event.EsmFms0020Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.event.EsmFms0059Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchDeliveryScheduleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchShipYardNameListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.basic.TCharIODockScheduleBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.basic.TCharIODockScheduleBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event.EsmFms00541Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event.EsmFms00542Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event.EsmFms0055Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event.EsmFms0057Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CustomDckSkdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleGraphListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.basic.TCharterIOInquiryBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.basic.TCharterIOInquiryBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event.EsmFms0008Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event.EsmFms0010Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event.EsmFms0060Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetSumListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusSumListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountSumListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.basic.TCharterStandardPrimeCostBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.basic.TCharterStandardPrimeCostBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.event.EsmFms0062Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.event.EsmFms0063Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.event.EsmFms0064Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.event.EsmFms0065Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.event.EsmFms0066Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchHireBaseListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchStandardHireBaseListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchStandardHireListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchTeuRangeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event.EsmFms0089Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchRfStatusListVO;

/**
 * NIS2010-TimeCharterInOutFleetManagement Business Logic ServiceCommand - NIS2010-TimeCharterInOutFleetManagement 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Choi Woo-Seok
 * @see TCharterStandardPrimeCostDBDAO
 * @since J2EE 1.4
 */

public class TimeCharterInOutFleetManagementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TimeCharterInOutFleetManagement system 업무 시나리오 선행작업<br>
	 * ESM_FMS_0062업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
		}
	}

	/**
	 * TimeCharterInOutFleetManagement system 업무 시나리오 마감작업<br>
	 * ESM_FMS_0062 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TimeCharterInOutFleetManagementSC 종료");
	}

	/**
	 * NIS2010-TimeCharterInOutFleetManagement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmFms0062Event")) {			// TEU Range Target
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTeuRangeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTeuRange(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {	
				eventResponse = removeAllTeuRange(e);	// Data Erase
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0065Event")) {	// Hire Base Input
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHireBaseList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHireBase(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeAllHireBase(e);	// Data Erase
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0082Event")) {	// Ship Yard Select – Pop up
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
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0063Event")) {	// Hire Creation
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStandardHireList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStandardHire(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeAllStandardHire(e);	// Data Erase
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchStandardHireBaseList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0066Event")) {	// Hire Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStandardHireList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0064Event")) {	// Hire Interface
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStandardHireList(e);
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
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0089Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRfStatusInquiryByVvd(e);
			}			
		}
		
		return eventResponse;
	}
	
	/**
	 * TeuRange 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTeuRangeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0062Event event = (EsmFms0062Event)e;
		TCharterStandardPrimeCostBC command = new TCharterStandardPrimeCostBCImpl();
		
		try {
			List<SearchTeuRangeListVO> searchTeuRangeListVO = command.searchTeuRangeList(event.getRngYr());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(searchTeuRangeListVO);
			return eventResponse;
		
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01800",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * TeuRange 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTeuRange(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0062Event event = (EsmFms0062Event)e;
		TCharterStandardPrimeCostBC command = new TCharterStandardPrimeCostBCImpl();
		try{
			begin();
			command.manageTeuRange(event.getCustomTeuRngVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchTeuRangeList(e);
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01801",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * TeuRange 정보 전체를 삭제한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeAllTeuRange(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0062Event event = (EsmFms0062Event)e;
		TCharterStandardPrimeCostBC command = new TCharterStandardPrimeCostBCImpl();
		try{
			begin();
			command.removeAllTeuRange(event.getRngYr());
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01804",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * HireBase 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHireBaseList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0065Event event = (EsmFms0065Event)e;
		TCharterStandardPrimeCostBC command = new TCharterStandardPrimeCostBCImpl();
		
		try {
			List<SearchHireBaseListVO> searchHireBaseListVO = command.searchHireBaseList(event.getMktRtYrmon());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(searchHireBaseListVO);
			return eventResponse;
		
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * HireBase 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHireBase(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0065Event event = (EsmFms0065Event)e;
		TCharterStandardPrimeCostBC command = new TCharterStandardPrimeCostBCImpl();
		try{
			begin();
			command.manageHireBase(event.getCustomMktRtVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchHireBaseList(e);
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
	 * HireBase 정보 전체를 삭제한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeAllHireBase(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0065Event event = (EsmFms0065Event)e;
		TCharterStandardPrimeCostBC command = new TCharterStandardPrimeCostBCImpl();
		try{
			begin();
			command.removeAllHireBase(event.getMktRtYrmon());
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
	 * ShipYardName 정보를 조회한다<br>
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
	 * ShipYardName 정보를 저장한다(입력 / 수정 / 삭제)<br>
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
	 * DeliverySchedule 정보를 조회한다<br>
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
	 * DeliverySchedule 정보를 저장한다(입력 / 수정 / 삭제)<br>
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
	 * DockEstimatedSchedule 정보를 조회한다<br>
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
	 * DockEstimatedSchedule 정보를 저장 후 다시 조회한다(입력 / 수정 / 삭제 / 조회)<br>
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
	 * DockRecommendSchedule 정보를 저장 후 조회한다(입력 / 수정 / 삭제 / 조회)<br>
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
	 * DockRecommendSchedule 정보를 조회한다<br>
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
	 * DryDockScheduleGraph 정보를 조회한다<br>
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
	 * DryDockSchedule 정보를 조회한다<br>
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
	 * StandardHire 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStandardHireList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TCharterStandardPrimeCostBC command = new TCharterStandardPrimeCostBCImpl();

		List<SearchStandardHireListVO> searchStandardHireListVO = null;
		
		try {
			if (e.getEventName().equalsIgnoreCase("EsmFms0063Event")) {
				EsmFms0063Event event = (EsmFms0063Event)e;
				searchStandardHireListVO = command.searchStandardHireList(event.getRngYr());
			} else if (e.getEventName().equalsIgnoreCase("EsmFms0064Event")) {
				EsmFms0064Event event = (EsmFms0064Event)e;
				searchStandardHireListVO = command.searchStandardHireList(event.getRngYr());
			} else {
				EsmFms0066Event event = (EsmFms0066Event)e;
				searchStandardHireListVO = command.searchStandardHireList(event.getRngYr());
			}
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(searchStandardHireListVO);
			return eventResponse;
		
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * StandardHire 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageStandardHire(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0063Event event = (EsmFms0063Event)e;
		TCharterStandardPrimeCostBC command = new TCharterStandardPrimeCostBCImpl();
		try{
			begin();
			command.manageStandardHire(event.getCustomStndHirVOS(), account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchStandardHireList(e);
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
	 * StandardHire 정보 전체를 삭제한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeAllStandardHire(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0063Event event = (EsmFms0063Event)e;
		TCharterStandardPrimeCostBC command = new TCharterStandardPrimeCostBCImpl();
		try{
			begin();
			command.removeAllStandardHire(event.getRngYr());
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
	 * StandardHireBase 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStandardHireBaseList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0063Event event = (EsmFms0063Event)e;
		TCharterStandardPrimeCostBC command = new TCharterStandardPrimeCostBCImpl();
		try{
			begin();
			List<SearchStandardHireBaseListVO> searchStandardHireBaseListVO = command.searchStandardHireBaseList(event.getRngYr(), account.getUsr_id());
			eventResponse.setRsVoList(searchStandardHireBaseListVO);
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
	 * FleetStatus 정보를 조회한다<br>
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
	 * Statement Account 정보를 조회한다<br>
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
	 * Capital Budget 자료를 조회한다
	 * 통화별 Total 금액 조회한다
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

	/**
	 * RF Status Inquiry By VVD<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfStatusInquiryByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0089Event event = (EsmFms0089Event)e;
		
		TCharterIOInquiryBC command = new TCharterIOInquiryBCImpl();
	    
		try {
			List<SearchRfStatusListVO> searchRfStatusListVO = null;
			
			if("S".equals(event.getSearchType())){
				searchRfStatusListVO = command.searchRfStatusInquiryByVvdSummaryList(event.getVvd());				
			}else{
				searchRfStatusListVO = command.searchRfStatusInquiryByVvdDetailList(event.getVvd());				
			}
			eventResponse.setRsVoList(searchRfStatusListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
}