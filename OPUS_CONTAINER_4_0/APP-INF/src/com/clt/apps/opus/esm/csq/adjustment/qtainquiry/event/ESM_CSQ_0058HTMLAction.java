/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_CSQ_0058HTMLAction.java
*@FileTitle      : QTA Inquiry_Quarterly Overall
*Open Issues     :
*Change history  :
*@LastModifyDate : 2012.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtainquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.csq.planning 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PlanningSC로 실행요청<br>
 * - PlanningSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author JEONGMIN CHO
 * @see EsmCsq0058Event 참조
 * @since J2EE 1.6
 */

public class ESM_CSQ_0058HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_CSQ_0058HTMLAction 객체를 생성
	 */
	public ESM_CSQ_0058HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmCsq0058Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmCsq0058Event event = new EsmCsq0058Event();
		
    	if(command.isCommand(FormCommand.SEARCH)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		} else if(command.isCommand(FormCommand.COMMAND01)) {
    		event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
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