/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : commonSC.java
*@FileTitle : EsdSce114
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.30 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.common.popup.basic.EqYardOrzBC;
import com.hanjin.apps.alps.esd.sce.common.popup.basic.EqYardOrzBCImpl;
import com.hanjin.apps.alps.esd.sce.common.popup.event.EqYardOrzEvent;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.EQYARDManageVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-common Business Logic ServiceCommand - ALPS-common 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Shin Han Sung
 * @see popupDBDAO
 * @since J2EE 1.6
 */

public class EqYardOrzSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * common system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("commonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * common system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("commonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-common system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
	 * EsdSce114 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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
	 * EsdSce114 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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
	 * EsdSce114 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
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