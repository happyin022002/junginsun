/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_LSE_0108HTMLAction.java
*@FileTitle : EQ Interchange Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 길정권
*@LastVersion : 1.0
* 2015.06.01 길정권
* 1.0 Creation
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeReqVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.lse.containerleasemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseMgtSC로 실행요청<br>
 * - ContainerLeaseMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jin Jun Sung
 * @see ContainerLeaseMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0108HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0108HTMLAction 객체를 생성
	 */
	public EES_LSE_0108HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerLeaseMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesLse0108Event event = new EesLse0108Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setEqInterchangeApprovalVO((EqInterchangeReqVO)getVO(request, EqInterchangeReqVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setEqInterchangeApprovalVOS((EqInterchangeReqVO[])getVOs(request, EqInterchangeReqVO.class));
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
	@Override
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