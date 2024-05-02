/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_DMT_2010HTMLAction.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.04.30 최성환
* 1.0 Creation
* 2010.11.25 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockStopParmVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.clt.apps.apls.ees.dmt.dmtexceptionmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTExceptionMgtSC로 실행요청<br>
 * - DMTExceptionMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Sung Hwan
 * @see DMTExceptionMgtEvent 참조
 * @since J2EE 1.4
 */

public class EES_DMT_2010HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_DMT_2010HTMLAction 객체를 생성
	 */
	public EES_DMT_2010HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DMTExceptionMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt2010Event event = new EesDmt2010Event();

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setTimeClockStopParmVO((TimeClockStopParmVO)getVO(request, TimeClockStopParmVO .class));
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setTimeClockStopParmVO((TimeClockStopParmVO)getVO(request, TimeClockStopParmVO .class));
		} else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setTimeClockStopParmVO((TimeClockStopParmVO)getVO(request, TimeClockStopParmVO .class));
		} else if(command.isCommand(FormCommand.COMMAND01) || command.isCommand(FormCommand.COMMAND02) ||command.isCommand(FormCommand.MULTI01)) {
			event.setDmtTimeClockStopVO((DmtTimeClockStopVO)getVO(request, DmtTimeClockStopVO .class));
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		} else if(command.isCommand(FormCommand.COMMAND11) || command.isCommand(FormCommand.COMMAND22) ||command.isCommand(FormCommand.MULTI02)) {
			event.setDmtTimeClockStopVO((DmtTimeClockStopVO)getVO(request, DmtTimeClockStopVO .class));
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		}
		

		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}