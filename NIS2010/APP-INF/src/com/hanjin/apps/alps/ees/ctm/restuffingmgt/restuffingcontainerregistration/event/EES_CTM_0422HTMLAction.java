/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0422HTMLAction.java
*@FileTitle : Restuffing Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.04 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMovementHistoryVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmRestuffingDetailVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.ctm.restuffingmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RestuffingMgtSC로 실행요청<br>
 * - RestuffingMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kyung Min Woo
 * @see RestuffingMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_CTM_0422HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CTM_0422HTMLAction 객체를 생성
	 */
	public EES_CTM_0422HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RestuffingMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesCtm0422Event event = new EesCtm0422Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setCtmRestuffingDetailVOS((CtmRestuffingDetailVO[])getVOs(request, CtmRestuffingDetailVO .class,""));
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setCtmMovementHistoryVO((CtmMovementHistoryVO)getVO(request, CtmMovementHistoryVO .class));
		}

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