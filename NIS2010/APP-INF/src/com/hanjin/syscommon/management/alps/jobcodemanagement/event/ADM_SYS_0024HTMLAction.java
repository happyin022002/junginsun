/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ADM_SYS_0024HTMLAction.java
*@FileTitle : Job Code Approver Management
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.07.09 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.ApproverVO;


/**
 * HTTP Parser<br>
 * - 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JobCodeManagementSC로 실행요청<br>
 * - JobCodeManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi, Duk-Woo
 * @see AdmSys0024Event 참조
 * @since J2EE 1.6
 */
public class ADM_SYS_0024HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	* ADM_SYS_0024HTMLAction 객체를 생성
	*/
	public ADM_SYS_0024HTMLAction() {}

	/**
	* HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	* HttpRequst의 정보를 AdmSys0024Event로 파싱하여 request에 셋팅<br>
	* @param request HttpServletRequest HttpRequest
	* @return Event Event interface를 구현한 객체
	* @exception HTMLActionException
	*/
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		AdmSys0024Event event = new AdmSys0024Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setApproverVO((ApproverVO)getVO(request, ApproverVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setApproverVOs((ApproverVO[])getVOs(request, ApproverVO.class));
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