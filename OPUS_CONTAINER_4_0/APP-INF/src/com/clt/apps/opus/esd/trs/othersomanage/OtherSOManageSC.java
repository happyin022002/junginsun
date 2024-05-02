/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OtherSOManageSCSC.java
 *@FileTitle : Other SO 생성화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-10-01
 *@LastModifier : kimjin
 *@LastVersion : 1.0
 * 2009-10-01 kimjin
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.othersomanage;

import com.clt.apps.opus.esd.trs.othersomanage.othersomanage.basic.OtherSOManageBC;
import com.clt.apps.opus.esd.trs.othersomanage.othersomanage.basic.OtherSOManageBCImpl;
import com.clt.apps.opus.esd.trs.othersomanage.othersomanage.event.EsdTrs0018Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * ESD-OtherSOManage Business Logic ServiceCommand<br>
 * - ESD-OtherSOManage에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author kimjin
 * @see ESD_TRS_018EventResponse,OtherSOManageDBDAO 참조
 * @since J2EE 1.6
 */
public class OtherSOManageSC extends ServiceCommandSupport {

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-OtherSOManage 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdTrs0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = addOtherSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyOtherSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeOtherSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchChassisEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGensetEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchContainerEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchChassisEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchGensetEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchOtherSOCorrectionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchContainerEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchChassisEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchGensetEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchRateApplyList(e);
			}
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateApplyList(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		try {
			OtherSOManageBC command = new OtherSOManageBCImpl();
			eventResponse = command.searchRateApplyList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOtherSOCorrectionList(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		try {
			OtherSOManageBC command = new OtherSOManageBCImpl();
			eventResponse = command.searchOtherSOCorrectionList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerEqNo(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		try {
			OtherSOManageBC command = new OtherSOManageBCImpl();
			eventResponse = command.searchContainerEqNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChassisEqNo(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		try {
			OtherSOManageBC command = new OtherSOManageBCImpl();
			eventResponse = command.searchChassisEqNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OtherSOManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGensetEqNo(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		try {
			OtherSOManageBC command = new OtherSOManageBCImpl();
			eventResponse = command.searchGensetEqNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Other S/O Creation
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse addOtherSOManage(Event e) throws EventException {
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		EventResponse eventResponse = null;
		OtherSOManageBC command = new OtherSOManageBCImpl();
		try {
			begin();
			eventResponse = command.searchTrspSvcOrdList(command.addOtherSOManage(event));
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Other S/O Modify
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse modifyOtherSOManage(Event e) throws EventException {
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		OtherSOManageBC command = new OtherSOManageBCImpl();
		try {
			begin();
			command.modifyOtherSOManage(event);
			commit();
			return new GeneralEventResponse();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Other S/O Remove
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse removeOtherSOManage(Event e) throws EventException {
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		OtherSOManageBC command = new OtherSOManageBCImpl();
		try {
			begin();
			command.removeOtherSOManage(event);
			commit();
			return new GeneralEventResponse();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
}