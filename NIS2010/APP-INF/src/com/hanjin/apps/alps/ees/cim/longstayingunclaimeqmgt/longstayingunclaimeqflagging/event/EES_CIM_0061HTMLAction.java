/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_CIM_0061HTMLAction.java
*@FileTitle : EQ Balance Report Input
*Open Issues : 
*Change history :
*@LastModifyDate : 2014.03.20
*@LastModifier : Kim Chang Young
*@LastVersion : 1.0
* 2014.03.20 Kim Chang Young
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0061Event;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LongstayingUnclaimEQMgtSC로 실행요청<br>
 * - LongstayingUnclaimEQMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Young Du
 * @see LongstayingUnclaimEQMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_CIM_0061HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CIM_0061HTMLAction 객체를 생성
	 */
	public EES_CIM_0061HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 LongstayingUnclaimEQMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EesCim0061Event event = new EesCim0061Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRhqCd(request.getParameter("rhq_cd"));
			event.setFmWeek(request.getParameter("fm_week"));
			event.setToWeek(request.getParameter("to_week"));
			event.setScontiCd(request.getParameter("sconti_cd"));
			event.setLccCd(request.getParameter("lcc_cd"));
			event.setEccCd(request.getParameter("ecc_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {	// Screen Onload or Button New
			event.setPageType(request.getParameter("page_type"));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {	// RHQ OnChange
			event.setRhqCd(request.getParameter("rhq_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {	// Sub-Conti OnChange
			event.setScontiCd(request.getParameter("sconti_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {	// LCC OnChange
			event.setScontiCd(request.getParameter("sconti_cd"));
			event.setLccCd(request.getParameter("lcc_cd"));
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