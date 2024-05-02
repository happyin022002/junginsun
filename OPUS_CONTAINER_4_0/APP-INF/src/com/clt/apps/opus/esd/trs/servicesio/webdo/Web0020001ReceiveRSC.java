/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : Web0020001ReceiveRSC.java
 *@FileTitle : Web0020001ReceiveRSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-10-07
 *@LastModifier : Choi jonghyek 
 *@LastVersion : 1.0
 * 2011-10-07 Choi jonghyek
 * 1.0 최초 생성
 * 2011.12.09 김종호 [CHM-201113793] [TRS] CUP Delivery Order 수신
=========================================================*/

package com.clt.apps.opus.esd.trs.servicesio.webdo;

import com.clt.apps.opus.esd.trs.servicesio.webdo.basic.WebDoManageBC;
import com.clt.apps.opus.esd.trs.servicesio.webdo.basic.WebDoManageBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.webdo.event.WebDoLinkEvent;
import com.clt.apps.opus.esd.trs.servicesio.webdo.vo.IfSchemaVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * Web0020001ReceiveRSC ServiceCommand<br>
 * - Web0020001ReceiveRSC 에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author Choi jonghyek
 * @see
 * @since J2EE 1.4
 */
public class Web0020001ReceiveRSC extends ServiceCommandSupport {
	/**
	 * WebGate 업무 시나리오 선행작업<br>
	 * WebGate 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("WebDoLink 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * WebDoLink 업무 시나리오 마감작업<br>
	 * WebDoLink 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("WebDoLink 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("WebDoLinkEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				boolean flag = multiUsDo(e);
				String msg = flag ? "1" : "0";
				eventResponse.setUserMessage(msg);
			}
		}
		return eventResponse;
	}

	/**
	 * multiUsDo 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @exception EventException
	 */
	private boolean multiUsDo(Event e) throws EventException {
		// EventResponse eventResponse = null;
		boolean returnFlag = false;
		try {
			begin();
			WebDoLinkEvent event = (WebDoLinkEvent) e;
			IfSchemaVO vo = event.getIfSchema();
			WebDoManageBC command = new WebDoManageBCImpl();
			int cnt = command.multiUsDo(vo);
			returnFlag = cnt > 0 ? true : false;
			log.debug("@@@@@@SC : returnFlag = " + returnFlag);
			commit();
			log.debug("@@@@@@SC : commit");
		} catch (EventException de) {
			rollback();
			log.debug("@@@@@@SC : rollback");
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return returnFlag;
	}
}
