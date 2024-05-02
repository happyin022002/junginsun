/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : ESD_TRS_0077HTMLAction.java
 *@FileTitle : Exception Ack Rail Road
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016-04-19
 *@LastModifier : S.W. KIM
 *@LastVersion : 1.0
 * 2016-04-19 ksw	   	1.0  최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.TrsExptAckRailVndrVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author
 * @see EsdTrs0077Event , ESD_TRS_0077EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0077HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0077HTMLAction
	 */
	public ESD_TRS_0077HTMLAction() {
	}

	/**
	 * perform
	 * 
	 * @param request
	 * @return Event
	 * @throws HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0077Event event = new EsdTrs0077Event();
		if (command.isCommand(FormCommand.MULTI)) {
			event.setTrExptAckRailVndrVOs(new TrsExptAckRailVndrVO().fromRequestGrid(request));
		} else if (command.isCommand(FormCommand.SEARCH)) {
			event.setSelRailroad(request.getParameter("sel_railroad"));
		}
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * doEnd
	 * 
	 * @param request
	 * @param eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * doEnd
	 * 
	 * @param request
	 * @param event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}