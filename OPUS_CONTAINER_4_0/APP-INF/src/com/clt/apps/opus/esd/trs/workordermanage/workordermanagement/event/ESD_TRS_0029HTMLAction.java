/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_029HTMLAction.java
*@FileTitle : W/O BFI Management 를 조회하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-17
*@LastModifier : P.K.S
*@LastVersion : 1.0
* 2014-11-17 P.K.S
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.vo.WorkOrderBFIManagementVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.workordermanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WorkOrderManageSC로 실행요청<br>
 * - WorkOrderManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author PKS
 * @see EsdTrs0029Event , ESD_TRS_029EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0029HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_029HTMLAction 객체를 생성
	 */
	public ESD_TRS_0029HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_029Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0029Event event = new EsdTrs0029Event();

		//조회 
		if(command.isCommand(FormCommand.SEARCH)) {  
			event.setWorkOrderBFIManagementVO((WorkOrderBFIManagementVO)getVO(request, WorkOrderBFIManagementVO .class));
		} 
		// LOOK : email testing, DON'T BUILD IT
		//SEARCH01:retrieve, SEARCH02:down excel for invoice, MULTI:send email
		else if(command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.MULTI)) {
			event.setWorkOrderBFIManagementVO((WorkOrderBFIManagementVO)getVO(request, WorkOrderBFIManagementVO .class));
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