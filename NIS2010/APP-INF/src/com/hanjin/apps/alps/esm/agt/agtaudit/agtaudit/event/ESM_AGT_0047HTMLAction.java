/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESMAGT0047HTMLAction.java
*@FileTitle : Agent Commission Approval No
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.26
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.08.12 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AGTVVDRateVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.agt.agtaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTAuditSC로 실행요청<br>
 * - AGTAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Ho Jin
 * @see AGTAuditEvent 참조
 * @since J2EE 1.6
 */

public class ESM_AGT_0047HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESMAGT0047HTMLAction 객체를 생성
	 */
	public ESM_AGT_0047HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AGTAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0047Event event = new EsmAgt0047Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setAgtVVDRateVO((AGTVVDRateVO)getVO(request, AGTVVDRateVO .class));
			log.info("\n    <<<<<<<44>>>>>>");
		}
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			log.info("\n    <<<<<<<55>>>>>>");
			event.setAgtVVDRateVO((AGTVVDRateVO)getVO(request, AGTVVDRateVO .class));
		}
		
		if(command.isCommand(FormCommand.MODIFY)){
			event.setAgtVVDRateVOs((AGTVVDRateVO[])getVOs(request, AGTVVDRateVO .class, ""));
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