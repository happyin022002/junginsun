/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EASCommonSC.java
*@FileTitle : EASCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-05-13 Jong-Ock Kim
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eascommon;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.eascommon.basic.EASCommonBC;
import com.hanjin.apps.alps.esd.eas.eascommon.basic.EASCommonBCImpl;
import com.hanjin.apps.alps.esd.eas.eascommon.event.EasCommonEvent;
import com.hanjin.apps.alps.esd.eas.eascommon.integration.EASCommonDBDAO;
import com.hanjin.apps.alps.esd.eas.eascommon.vo.EasCommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-EASCommon Business Logic ServiceCommand - ALPS-EASCommon 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Jong-Ock Kim
 * @see EASCommonDBDAO
 * @since J2EE 1.6
 */
public class EASCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * EASCommon system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */ 
	public void doStart() {
		log.debug("EASCommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * EASCommon system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("EASCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-EASCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EasCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getYardLocCdNodCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getYardByLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = getVesselClassByVesselList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = null;
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = null;
			}
		}
		return eventResponse;
	}

	/**
	 * 공통 : Yard에 Loc_cd 해당하는 Nod_code 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getYardLocCdNodCdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EasCommonEvent event = (EasCommonEvent)e;
		EASCommonBC command = new EASCommonBCImpl();
		try{
			List<EasCommonVO> commonVOlist = command.getYardLocCdNodCdList(event.getEasCommonVO());
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 공통 : Yard에 기항하는 Lane 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getYardByLaneList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EasCommonEvent event = (EasCommonEvent)e;
		EASCommonBC command = new EASCommonBCImpl();
		try{
			List<EasCommonVO> commonVOlist = command.getYardByLaneList(event.getEasCommonVO());
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 공통 : Vessel Class에 기항하는 Vessel 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getVesselClassByVesselList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EasCommonEvent event = (EasCommonEvent)e;
		EASCommonBC command = new EASCommonBCImpl();
		try{
			List<EasCommonVO> commonVOlist = command.getVesselClassByVesselList(event.getEasCommonVO());
			eventResponse.setRsVoList(commonVOlist);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
}
