/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_016SC.java
 *@FileTitle : Service Order 생성-Supplement
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-30
 *@LastModifier : juhyun
 *@LastVersion : 1.0
 * 2006-10-30 juhyun
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.supplementsomanage;

import java.util.List;

import com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.basic.SupplementSOManageBC;
import com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.basic.SupplementSOManageBCImpl;
import com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.event.EsdTrs0016Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author juhyun
 * @see ESD_TRS_016EventResponse,SupplementSOManageDBDAO 참조
 * @since J2EE 1.4
 */
public class SupplementSOManageSC extends ServiceCommandSupport {
	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * SupplementSOManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("SupplementSOManageSC Start");
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SupplementSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SupplementSOManageSC End");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
			eventResponse = searchSupplementSOTargetList(e);
		} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
			eventResponse = addSupplementSOList(e);
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
			eventResponse = searchSupplementSOCorrectionList(e);
		} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
			eventResponse = removeSupplementSOCreatedList(e);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSupplementSOTargetList(Event e) throws EventException {
		EsdTrs0016Event event = (EsdTrs0016Event) e;
		EventResponse eventResponse = null;
		try {
			SupplementSOManageBC command = new SupplementSOManageBCImpl();
			eventResponse = command.searchSupplementSOTargetList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSupplementSOCorrectionList(Event e) throws EventException {
		EsdTrs0016Event event = (EsdTrs0016Event) e;
		EventResponse eventResponse = null;
		try {
			SupplementSOManageBC command = new SupplementSOManageBCImpl();
			eventResponse = command.searchSupplementSOCorrectionList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addSupplementSOList(Event e) throws EventException {
		EsdTrs0016Event event = (EsdTrs0016Event) e;
		EventResponse eventResponse = null;
		SupplementSOManageBC command = new SupplementSOManageBCImpl();
		List<String> insertDatas = null;
		try {
			begin();
			insertDatas = command.addSupplementSOList(event);
			commit();
			eventResponse = command.searchSOCreatedList(insertDatas);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SupplementSOManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeSupplementSOCreatedList(Event e) throws EventException {
		EsdTrs0016Event event = (EsdTrs0016Event) e;
		SupplementSOManageBC command = new SupplementSOManageBCImpl();
		try {
			begin();
			command.removeSupplementSOCreatedList(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return new GeneralEventResponse();
	}
}
