/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffConditionManageSC.java
*@FileTitle : TariffConditionManageSC
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.06
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.03.06 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage;

import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.basic.TariffConditionManageBC;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.basic.TariffConditionManageBCImpl;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.event.EsdTes0050Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.event.EsdTes0057Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration.TariffConditionManageDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-TariffConditionManageManage Business Logic ServiceCommand - ALPS-TariffConditionManageManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 이혜민
 * @see TariffConditionManageDBDAO
 * @since J2EE 1.6
 */
public class TariffConditionManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * TariffConditionManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("TariffConditionManageSC 시작");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}		
	}

	/**
	 * TariffConditionManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TariffConditionManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-TariffConditionManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		/**
		 * Tariff Condition Creation & Adjustment
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0050Event")) {
			log.debug("\n\n TariffConditionManageSC - EsdTes0050Event  SEARCH ["+e.getFormCommand().getCommand()+"] \n\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTariffCondItem(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffObjectList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTariffCondDtlInfo(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeTariffCondInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTes0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTariffCond(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * Tariff Object List를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffObjectList(Event e) throws EventException {
		
		log.debug("\n\n TariffConditionManageSC.searchTariffObjectList ------ bbbbb \n\n");
		
		TariffConditionManageBC command = new TariffConditionManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0050Event	event = (EsdTes0050Event)e;

		try {
			eventResponse.setRsVoList(command.searchTariffObjectList(event.getTesObjListVO()));
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		log.debug("\n\n TariffConditionManageSC.searchTariffObjectList ------ eeeee \n\n");
		return eventResponse;
	}
	
	/**
	 * Tariff Condition 항목의 data을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffCondItem(Event e) throws EventException {
		
		log.debug("\n\n TariffConditionManageSC.searchTariffCondItem ------ bbbbb \n\n");
		
		EventResponse eventResponse = new GeneralEventResponse();
		TariffConditionManageBC command = new TariffConditionManageBCImpl();
		EsdTes0050Event	event = (EsdTes0050Event)e;

		try {
			eventResponse = command.searchTariffCondItem2(event);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		log.debug("\n\n TariffConditionManageSC.searchTariffCondItem ------ eeeee \n\n");
		return eventResponse;
	}
	
	/**
	 * Tariff Condition 항목의 data을 관리한다.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageTariffCondDtlInfo(Event e) throws EventException {
		
		log.debug("\n\n TariffConditionManageSC.manageTariffCondItem ------ bbbbb \n\n");
		
		EventResponse eventResponse = new GeneralEventResponse();
		TariffConditionManageBC command = new TariffConditionManageBCImpl();
		EsdTes0050Event	event = (EsdTes0050Event)e;

		try {
//			command.checkTariffCondRef(event); /** SELCGS만 허용함에 일단 풀어놓기로 함 **/
			
			begin();
			command.manageTariffCondDtlInfo(event);
			commit();
			
			eventResponse = command.searchTariffCondItem2(event);
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		log.debug("\n\n TariffConditionManageSC.manageTariffCondItem ------ eeeee \n\n");
		return eventResponse;
	}
	
	/**
	 * condition 삭제 처리
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse removeTariffCondInfo(Event e) throws EventException {
		
		log.debug("\n\n TariffConditionManageSC.removeTariffCondInfo ------ bbbbb \n\n");
		
		EventResponse eventResponse = new GeneralEventResponse();
		TariffConditionManageBC command = new TariffConditionManageBCImpl();
		EsdTes0050Event	event = (EsdTes0050Event)e;

		try {
//			command.checkTariffCondRef(event); /** SELCGS만 허용함에 일단 풀어놓기로 함 **/
			
			begin();
			command.removeTariffCondInfo(event);
			commit();
			
			eventResponse = command.searchTariffCondItem2(event);
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		log.debug("\n\n TariffConditionManageSC.removeTariffCondInfo ------ eeeee \n\n");
		return eventResponse;
	} 
	
	/**
	 * ESD_TES_0057<br>
	 * Tariff Condition을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffCond(Event e) throws EventException {
		TariffConditionManageBC command = new TariffConditionManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0057Event	event = (EsdTes0057Event)e;

		try {
			eventResponse.setRsVoList(command.searchTariffCond(event.getComTesTrfCondVO()));
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
}	