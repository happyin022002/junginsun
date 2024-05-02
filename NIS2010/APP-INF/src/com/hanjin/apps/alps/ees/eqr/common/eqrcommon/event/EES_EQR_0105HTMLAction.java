/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0105HTMLAction.java
*@FileTitle : data edit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.03 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.event.EesEqr0105Event;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.eqradjust 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EQRAdjustSC로 실행요청<br>
 * - EQRAdjustSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see EQRAdjustEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0105HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0105HTMLAction 객체를 생성
	 */
	public EES_EQR_0105HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EQRAdjustEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0105Event event = new EesEqr0105Event();
		
		// Retrieve 버튼 클릭시
    	String status	= JSPUtil.getParameter(request, "status".trim(), "");
    	String location = JSPUtil.getParameter(request, "location".trim(),"");    	
   	
    	// Retrieve 버튼 클릭시
		if (command.isCommand(FormCommand.SEARCHLIST)) {
	        event.setStatus(status);
	        event.setLocation(location);
	        
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