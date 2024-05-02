/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ADM_SYS_0014HTMLAction.java
*@FileTitle : Job Code User Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-21
*@LastModifier : DukWoo Choi
*@LastVersion : 1.0
* 2013-05-21 DukWoo Choi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.UserInquiryVO;
import com.hanjin.syscommon.management.alps.role.event.ComSys009Event;


/**
 * HTTP Parser<br>
 * - com.hanjin.syscommon.management.enis 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RoleManagementSC로 실행요청<br>
 * - RoleManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author SeongWook Kim
 * @see ComSys009Event , UI_COM_SYS_009EventResponse 참조
 * @since J2EE 1.6
 */
public class ADM_SYS_0014HTMLAction extends HTMLActionSupport {

	/**
	 * UI_ADM_SYS_0014HTMLAction 객체를 생성
	 */
	public ADM_SYS_0014HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 UI_ADM_SYS_0014HTMLAction로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		AdmSys0014Event event = new AdmSys0014Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setUserInquiryVO((UserInquiryVO)getVO(request, UserInquiryVO.class));
		} else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setUserInquiryVO((UserInquiryVO)getVO(request, UserInquiryVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setUserInquiryVOs((UserInquiryVO[])getVOs(request, UserInquiryVO.class));
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