/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0231HTMLAction.java
*@FileTitle : SKD for Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.07.13 정명훈
* 1.0 Creation
* 
* History
* 2011.04.07 CHM-201110042-01 진마리아 불필요한 시스템 로그 출력 제거 
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.vsk.actualschedulemanagement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ActualScheduleManagementSC로 실행요청<br>
 * - ActualScheduleManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jeong Myounghun
 * @see ActualScheduleManagementEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0231HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0231HTMLAction 객체를 생성
	 */
	public VOP_VSK_0231HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ActualScheduleManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0231Event event = new VopVsk0231Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setOnTimeRsltAnalGRPVO((OnTimeRsltAnalGRPVO)getVO(request, OnTimeRsltAnalGRPVO.class));
		} else if(command.isCommand(FormCommand.DEFAULT)) { 
			event.setAttribute("vsl_cd", JSPUtil.getParameter(request, "vsl_cd", ""));	
			event.setAttribute("voy_no", JSPUtil.getParameter(request, "voy_no", ""));	
			event.setAttribute("dir_cd", JSPUtil.getParameter(request, "dir_cd", ""));	
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