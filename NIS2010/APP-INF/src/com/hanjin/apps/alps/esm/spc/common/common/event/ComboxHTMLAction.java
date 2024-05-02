/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ComboxHTMLAction.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-11
*@LastModifier : 김원섭
*@LastVersion : 1.0
* 2006-10-11 김원섭
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.spc.common.common.event;

import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.core.layer.event.Event;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CommonSC로 실행요청<br>
 * - CommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 김원섭
 * @see ComboxEvent , ComboxEventResponse 참조
 * @since J2EE 1.4
 */

public class ComboxHTMLAction extends HTMLActionSupport {

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ComboxEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand f_cmd = FormCommand.fromRequest(request);
		ComboxEvent event = new ComboxEvent();
		event.setCommandClassName("CommonSC");
		event.setFormCommand(f_cmd);
		request.setAttribute("Event", event);
		return event;
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