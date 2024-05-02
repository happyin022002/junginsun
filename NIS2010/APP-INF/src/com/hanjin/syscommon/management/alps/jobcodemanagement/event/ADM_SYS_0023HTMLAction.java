/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ADM_SYS_0023HTMLAction.java
*@FileTitle : Program Job Code Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-20
*@LastModifier : DukWoo Choi
*@LastVersion : 1.0
* 2013-05-20 DukWoo Choi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeManagementVO;
import com.hanjin.syscommon.management.alps.role.event.ComSys011Event;


/**
 * HTTP Parser<br>
 * - com.hanjin.syscommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RoleMappingManagementSCSC로 실행요청<br>
 * - RoleMappingManagementSCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kildong_hong
 * @see ComSys011Event , UI_COM_SYS_011EventResponse 참조
 * @since J2EE 1.4
 */
public class ADM_SYS_0023HTMLAction extends HTMLActionSupport {

	/**
	 * UI_COM_SYS_011HTMLAction 객체를 생성
	 */
	public ADM_SYS_0023HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 UI_COM_SYS_011Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		AdmSys0023Event event = new AdmSys0023Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setJobCodeManagementVO((JobCodeManagementVO)getVO(request, JobCodeManagementVO.class));
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